/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.actions.UseAbilityAction;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.AbilitiesConfigChange;
/*     */ import com.prineside.tdi2.events.game.AbilityApply;
/*     */ import com.prineside.tdi2.events.game.AbilityStart;
/*     */ import com.prineside.tdi2.events.game.AbilityUseStart;
/*     */ import com.prineside.tdi2.events.game.AbilityUseStop;
/*     */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class AbilitySystem extends GameSystem {
/*  33 */   private static final TLog a = TLog.forClass(AbilitySystem.class);
/*     */   
/*  35 */   public DelayedRemovalArray<Ability> activeAbilities = new DelayedRemovalArray(false, 1, Ability.class);
/*     */   public AbilitySelectionOverlay.SelectedAbilitiesConfiguration abilitiesConfiguration;
/*  37 */   private int b = 0;
/*     */   private float c;
/*  39 */   public int[] abilitiesUsed = new int[] { 0, 0, 0, 0, 0, 0 };
/*     */   @NAGS
/*  41 */   private final InputProcessor d = (InputProcessor)new InputAdapter(this)
/*     */     {
/*     */       public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  44 */         if (this.a.S._input == null) return false;
/*     */         
/*  46 */         Vector2 vector2 = new Vector2(param1Int1, param1Int2);
/*  47 */         this.a.S._input.getCameraController().screenToMap(vector2);
/*  48 */         if (AbilitySystem.a(this.a) != null) {
/*  49 */           AbilitySystem.a(this.a, AbilitySystem.a(this.a), (int)vector2.x, (int)vector2.y);
/*     */         }
/*  51 */         this.a.cancelUsingAbility();
/*  52 */         return false;
/*     */       }
/*     */     };
/*     */   @NAGS
/*     */   private AbilityType e;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  59 */     super.write(paramKryo, paramOutput);
/*  60 */     paramKryo.writeObject(paramOutput, this.activeAbilities);
/*  61 */     paramKryo.writeObjectOrNull(paramOutput, this.abilitiesConfiguration, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  62 */     paramOutput.writeVarInt(this.b, true);
/*  63 */     paramOutput.writeFloat(this.c);
/*  64 */     paramKryo.writeObject(paramOutput, this.abilitiesUsed);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  69 */     super.read(paramKryo, paramInput);
/*  70 */     this.activeAbilities = (DelayedRemovalArray<Ability>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  71 */     this.abilitiesConfiguration = (AbilitySelectionOverlay.SelectedAbilitiesConfiguration)paramKryo.readObjectOrNull(paramInput, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  72 */     this.b = paramInput.readVarInt(true);
/*  73 */     this.c = paramInput.readFloat();
/*  74 */     this.abilitiesUsed = (int[])paramKryo.readObject(paramInput, int[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  84 */     this.abilitiesConfiguration = new AbilitySelectionOverlay.SelectedAbilitiesConfiguration(this.S.gameState.startingAbilitiesConfiguration);
/*     */     
/*  86 */     if (this.S.map.getMap().getTargetTileOrThrow().isDisableAbilities())
/*     */     {
/*     */       
/*  89 */       for (byte b = 0; b < getAbilitySlotCount(); b++) {
/*  90 */         AbilityType abilityType = this.abilitiesConfiguration.slots[b];
/*  91 */         this.abilitiesConfiguration.counts[b] = 0;
/*  92 */         if (abilityType != null) {
/*  93 */           int i = this.S.gameValue.getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType));
/*  94 */           this.abilitiesConfiguration.counts[b] = i;
/*     */         } 
/*     */       } 
/*     */     }
/*  98 */     if (!this.S.CFG.headless) a();
/*     */   
/*     */   }
/*     */   
/*     */   public final void postStateRestore() {
/* 103 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 107 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.ABILITY_DRAW_BATCH_ADDITIVE, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatchAdditive(paramBatch, paramFloat2)))
/*     */ 
/*     */         
/* 110 */         .setName("Ability-drawBatchAdditive"));
/*     */     
/* 112 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.ABILITY_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2)))
/*     */ 
/*     */         
/* 115 */         .setName("Ability-drawBatch"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 120 */     super.postSetup();
/*     */ 
/*     */     
/* 123 */     for (byte b = 0; b < this.abilitiesConfiguration.slots.length; b++) {
/*     */       AbilityType abilityType;
/* 125 */       if ((abilityType = this.abilitiesConfiguration.slots[b]) != null) {
/* 126 */         int i = this.S.gameValue.getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType));
/* 127 */         if (this.abilitiesConfiguration.counts[b] > i) {
/* 128 */           this.abilitiesConfiguration.counts[b] = i;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     b();
/*     */   }
/*     */   
/*     */   public final int getAbilitySlotCount() {
/* 137 */     return 6;
/*     */   }
/*     */   
/*     */   private void b() {
/* 141 */     this.S.events.trigger((Event)new AbilitiesConfigChange());
/*     */   }
/*     */   
/*     */   private void a(AbilityType paramAbilityType, int paramInt1, int paramInt2) {
/* 145 */     this.S.gameState.pushActionNextUpdate((Action)new UseAbilityAction(paramAbilityType, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AbilityType getUiCurrentlyUsingAbility() {
/* 152 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void startUsingAbility(AbilityType paramAbilityType) {
/* 159 */     if (this.e != null) {
/* 160 */       cancelUsingAbility();
/*     */     }
/*     */     
/*     */     int i;
/* 164 */     if ((i = this.abilitiesConfiguration.getSlot(paramAbilityType)) == -1 || getAvailableAbilities(i) <= 0)
/*     */       return; 
/*     */     InputMultiplexerExtended inputMultiplexerExtended;
/* 167 */     (inputMultiplexerExtended = this.S._input.setupInputMultiplexer(true, true, false)).addProcessor(this.d);
/* 168 */     this.e = paramAbilityType;
/*     */     
/* 170 */     this.S.events.trigger((Event)new AbilityUseStart());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void cancelUsingAbility() {
/* 181 */     if (this.e != null) {
/* 182 */       this.e = null;
/* 183 */       this.S.events.trigger((Event)new AbilityUseStop());
/*     */     } 
/*     */     
/* 186 */     this.S._input.enableAllInput();
/*     */   }
/*     */   
/*     */   public final int getEnergy() {
/* 190 */     return this.b;
/*     */   }
/*     */   
/*     */   public final float getNextEnergyGenerationTime() {
/* 194 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int getAvailableAbilitiesByType(AbilityType paramAbilityType) {
/* 198 */     for (byte b = 0; b < this.abilitiesConfiguration.slots.length; b++) {
/* 199 */       if (this.abilitiesConfiguration.slots[b] == paramAbilityType) {
/* 200 */         return getAvailableAbilities(b);
/*     */       }
/*     */     } 
/*     */     
/* 204 */     return 0;
/*     */   }
/*     */   
/*     */   public final int getAvailableAbilities(int paramInt) {
/* 208 */     return this.abilitiesConfiguration.counts[paramInt];
/*     */   }
/*     */   
/*     */   public final void addAbilityCharges(int paramInt1, int paramInt2) {
/* 212 */     this.abilitiesConfiguration.counts[paramInt1] = this.abilitiesConfiguration.counts[paramInt1] + paramInt2;
/* 213 */     b();
/*     */   }
/*     */   
/*     */   public final Ability registerConfigureAndStartAbility(AbilityType paramAbilityType, int paramInt1, int paramInt2, double paramDouble) {
/* 217 */     Ability ability = Game.i.abilityManager.getFactory(paramAbilityType).create();
/* 218 */     registerAndConfigure(ability, paramInt1, paramInt2, paramDouble);
/* 219 */     return startAbility(ability);
/*     */   }
/*     */   
/*     */   public final Ability startAbility(Ability paramAbility) {
/* 223 */     if (!paramAbility.isRegistered()) {
/* 224 */       throw new IllegalArgumentException("Ability must be registered and configured first");
/*     */     }
/*     */     
/* 227 */     this.S.events.trigger((Event)new AbilityStart(paramAbility));
/*     */     
/* 229 */     if (paramAbility.start()) {
/* 230 */       this.activeAbilities.add(paramAbility);
/* 231 */       return paramAbility;
/*     */     } 
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void registerAndConfigure(Ability paramAbility, int paramInt1, int paramInt2, double paramDouble) {
/* 238 */     paramAbility.setRegistered(this.S);
/* 239 */     paramAbility.configure(paramInt1, paramInt2, paramDouble);
/*     */   }
/*     */   
/*     */   public final int getEnergyCost(AbilityType paramAbilityType) {
/* 243 */     return this.S.gameValue.getIntValue(Game.i.abilityManager.getEnergyCostGameValueType(paramAbilityType));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     StateSystem.ActionsArray actionsArray;
/* 250 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 251 */       for (byte b1 = 0; b1 < actionsArray.size; b1++) {
/*     */         Action action;
/* 253 */         if ((action = actionsArray.actions[b1]).getType() == ActionType.UA) {
/*     */           
/* 255 */           UseAbilityAction useAbilityAction = (UseAbilityAction)action;
/*     */           
/*     */           int i;
/* 258 */           if ((i = this.abilitiesConfiguration.getSlot(useAbilityAction.abilityType)) != -1) {
/* 259 */             if (getAvailableAbilities(i) > 0) {
/* 260 */               int j = getEnergyCost(useAbilityAction.abilityType);
/* 261 */               if (this.b >= j) {
/*     */                 Ability ability;
/* 263 */                 if ((ability = registerConfigureAndStartAbility(useAbilityAction.abilityType, useAbilityAction.x, useAbilityAction.y, this.S.damage.getTowersMaxDps())) != null) {
/* 264 */                   ability.startEffects();
/* 265 */                   this.b -= j;
/* 266 */                   this.abilitiesConfiguration.counts[i] = this.abilitiesConfiguration.counts[i] - 1;
/* 267 */                   this.abilitiesUsed[i] = this.abilitiesUsed[i] + 1;
/* 268 */                   b();
/*     */                   
/* 270 */                   this.S.events.trigger((Event)new AbilityApply(ability, useAbilityAction.x, useAbilityAction.y));
/* 271 */                   this.S.gameState.registerPlayerActivity();
/*     */                 } else {
/* 273 */                   a.e("useAbility - ability can not be started", new Object[0]);
/*     */                 } 
/*     */               } else {
/* 276 */                 a.e("useAbility - ability requires " + j + " energy though only " + this.b + " available", new Object[0]);
/*     */               } 
/*     */             } else {
/* 279 */               a.e("useAbility - no abilities of type " + useAbilityAction.abilityType.name() + " left", new Object[0]);
/*     */             } 
/*     */           } else {
/* 282 */             a.e("useAbility - ability type " + useAbilityAction.abilityType.name() + " not exists in configuration", new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 289 */     if (this.S.gameState.isGameRealTimePasses() && 
/* 290 */       this.b < getMaxEnergy()) {
/* 291 */       float f = getEnergyRegenerationTime();
/* 292 */       this.c += paramFloat;
/* 293 */       if (this.c >= f) {
/* 294 */         this.c -= f;
/* 295 */         this.b++;
/* 296 */         if (this.b == getMaxEnergy()) {
/* 297 */           this.c = 0.0F;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 303 */     this.activeAbilities.begin();
/* 304 */     for (byte b = 0; b < this.activeAbilities.size; b++) {
/*     */       Ability ability;
/* 306 */       (ability = ((Ability[])this.activeAbilities.items)[b]).update(paramFloat);
/* 307 */       if (ability.isDone()) {
/* 308 */         ability.onDone();
/* 309 */         ability.setUnregistered();
/* 310 */         this.activeAbilities.removeIndex(b);
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     this.activeAbilities.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 319 */     return "Ability";
/*     */   }
/*     */   
/*     */   public final int getMaxEnergy() {
/* 323 */     return this.S.gameValue.getIntValue(GameValueType.ABILITIES_MAX_ENERGY);
/*     */   }
/*     */   
/*     */   public final float getEnergyRegenerationTime() {
/* 327 */     return this.S.gameValue.getFloatValue(GameValueType.ABILITIES_ENERGY_GENERATION_INTERVAL);
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 331 */     this.activeAbilities.begin();
/* 332 */     for (byte b = 0; b < this.activeAbilities.size; b++) {
/* 333 */       ((Ability[])this.activeAbilities.items)[b].draw(paramBatch, paramFloat);
/*     */     }
/* 335 */     this.activeAbilities.end();
/*     */   }
/*     */   
/*     */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 339 */     this.activeAbilities.begin();
/* 340 */     for (byte b = 0; b < this.activeAbilities.size; b++) {
/* 341 */       ((Ability[])this.activeAbilities.items)[b].drawBatchAdditive(paramBatch, paramFloat);
/*     */     }
/* 343 */     this.activeAbilities.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 348 */     for (byte b = 0; b < this.activeAbilities.size; b++) {
/* 349 */       ((Ability[])this.activeAbilities.items)[b].setUnregistered();
/*     */     }
/* 351 */     this.activeAbilities.clear();
/*     */     
/* 353 */     super.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\AbilitySystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */