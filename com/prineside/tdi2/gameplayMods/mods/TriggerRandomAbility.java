/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.GameStateTick;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class TriggerRandomAbility extends GenericGameplayMod implements Listener<GameStateTick> {
/*  35 */   private static final TLog a = TLog.forClass(TriggerRandomAbility.class);
/*     */ 
/*     */   
/*  38 */   private float b = 360.0F;
/*  39 */   private float c = -60.0F;
/*  40 */   private float d = 0.15F;
/*  41 */   private float e = 0.15F;
/*  42 */   private float f = 0.05F;
/*     */ 
/*     */   
/*     */   private GameSystemProvider g;
/*     */ 
/*     */   
/*     */   private float h;
/*     */   
/*     */   private float i;
/*     */   
/*     */   private int j;
/*     */   
/*     */   private int k;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  58 */     super.write(paramKryo, paramOutput);
/*  59 */     paramOutput.writeFloat(this.b);
/*  60 */     paramOutput.writeFloat(this.c);
/*  61 */     paramOutput.writeFloat(this.d);
/*  62 */     paramOutput.writeFloat(this.e);
/*  63 */     paramOutput.writeFloat(this.f);
/*  64 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/*  65 */     paramOutput.writeFloat(this.h);
/*  66 */     paramOutput.writeFloat(this.i);
/*  67 */     paramOutput.writeVarInt(this.j, true);
/*  68 */     paramOutput.writeVarInt(this.k, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  73 */     super.read(paramKryo, paramInput);
/*  74 */     this.b = paramInput.readFloat();
/*  75 */     this.c = paramInput.readFloat();
/*  76 */     this.d = paramInput.readFloat();
/*  77 */     this.e = paramInput.readFloat();
/*  78 */     this.f = paramInput.readFloat();
/*  79 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  80 */     this.h = paramInput.readFloat();
/*  81 */     this.i = paramInput.readFloat();
/*  82 */     this.j = paramInput.readVarInt(true);
/*  83 */     this.k = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  88 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  93 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.TriggerRandomAbility");
/*     */   }
/*     */   
/*     */   public final float getMdpsMultiplier() {
/*  97 */     return this.e + this.f * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 102 */     String str1 = StringFormatter.timePassed(MathUtils.round(getInterval()), false, false);
/* 103 */     String str2 = StringFormatter.compactNumberWithPrecisionTrimZeros((getMdpsMultiplier() * 100.0F), 1, true).toString();
/* 104 */     return Game.i.localeManager.i18n.format("gmod_descr_trigger_random_ability", new Object[] { str1, str2 });
/*     */   }
/*     */   
/*     */   public final float getInterval() {
/* 108 */     return Math.max(this.b + this.c * this.power, 10.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/* 113 */     TriggerRandomAbility triggerRandomAbility = new TriggerRandomAbility();
/* 114 */     a(triggerRandomAbility);
/* 115 */     triggerRandomAbility.b = this.b;
/* 116 */     triggerRandomAbility.c = this.c;
/* 117 */     triggerRandomAbility.d = this.d;
/* 118 */     triggerRandomAbility.e = this.e;
/* 119 */     triggerRandomAbility.f = this.f;
/* 120 */     triggerRandomAbility.k = this.k;
/*     */     
/* 122 */     return (GameplayMod)triggerRandomAbility;
/*     */   }
/*     */   
/*     */   private void a() {
/* 126 */     this.i = getInterval();
/* 127 */     this.i += this.i * this.g.gameState.randomTriangular() * this.d;
/* 128 */     this.h = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 135 */     if (paramGameSystemProvider.gameState.startingAbilitiesConfiguration == null) {
/* 136 */       return true;
/*     */     }
/*     */     
/* 139 */     byte b1 = 0;
/* 140 */     for (byte b2 = 0; b2 < paramGameSystemProvider.gameState.startingAbilitiesConfiguration.slots.length; b2++) {
/*     */       AbilityType abilityType;
/* 142 */       if ((abilityType = paramGameSystemProvider.gameState.startingAbilitiesConfiguration.slots[b2]) != null) {
/* 143 */         b1++;
/*     */       }
/*     */     } 
/* 146 */     if (b1 >= this.k) {
/* 147 */       return false;
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*     */     int i;
/* 155 */     byte b = 0;
/* 156 */     if (paramGameSystemProvider.gameState.startingAbilitiesConfiguration != null) {
/* 157 */       for (byte b1 = 0; b1 < paramGameSystemProvider.gameState.startingAbilitiesConfiguration.slots.length; b1++) {
/*     */         AbilityType abilityType;
/* 159 */         if ((abilityType = paramGameSystemProvider.gameState.startingAbilitiesConfiguration.slots[b1]) != null) {
/* 160 */           b++;
/*     */         }
/*     */       } 
/*     */     }
/* 164 */     if (b >= this.k) {
/* 165 */       return null;
/*     */     }
/*     */     
/* 168 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_trigger_random_ability", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 175 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(TriggerRandomAbility.class, paramString)) == null) {
/*     */       
/* 177 */       this.g = paramGameSystemProvider;
/* 178 */       paramGameSystemProvider.events.getListeners(GameStateTick.class).addStateAffecting(this).setDescription("Triggers random ability if it is time to");
/*     */       
/* 180 */       a();
/*     */       
/* 182 */       return true;
/*     */     } 
/*     */     
/* 185 */     activeMod.getMod().setRegisteredPower(this.power);
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TriggerRandomAbility applyConfig(JsonValue paramJsonValue) {
/* 192 */     super.applyConfig(paramJsonValue);
/* 193 */     this.b = paramJsonValue.getFloat("baseInterval", this.b);
/* 194 */     this.c = paramJsonValue.getFloat("intervalPerPower", this.c);
/* 195 */     this.d = paramJsonValue.getFloat("intervalRandomDeviation", this.d);
/* 196 */     this.e = paramJsonValue.getFloat("mdpsMultiplier", this.e);
/* 197 */     this.f = paramJsonValue.getFloat("mdpsMultiplierPerPower", this.f);
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(GameStateTick paramGameStateTick) {
/* 203 */     if (this.g.gameState.startingAbilitiesConfiguration == null) {
/*     */       return;
/*     */     }
/*     */     
/* 207 */     this.h += paramGameStateTick.getDeltaTime();
/* 208 */     if (this.h > this.i) {
/* 209 */       this.j++;
/* 210 */       RandomXS128 randomXS128 = this.g.gameplayMod.getModRandom(86862 + this.j);
/* 211 */       a.i("triggering after " + this.h, new Object[0]);
/*     */       
/* 213 */       Array array = new Array(true, 1, AbilityType.class);
/* 214 */       for (byte b = 0; b < this.g.gameState.startingAbilitiesConfiguration.slots.length; b++) {
/*     */         AbilityType abilityType;
/* 216 */         if ((abilityType = this.g.gameState.startingAbilitiesConfiguration.slots[b]) != null) {
/* 217 */           array.add(abilityType);
/*     */         }
/*     */       } 
/* 220 */       if (array.size > 0) {
/* 221 */         AbilityType abilityType = (AbilityType)array.get(randomXS128.nextInt(array.size));
/*     */ 
/*     */         
/* 224 */         boolean bool1 = true;
/* 225 */         boolean bool2 = false;
/* 226 */         for (byte b1 = 0; b1 < this.g.ability.activeAbilities.size; b1++) {
/* 227 */           if (((Ability)this.g.ability.activeAbilities.get(b1)).getType() == AbilityType.MAGNET) {
/* 228 */             bool2 = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 232 */         if (abilityType == AbilityType.MAGNET && bool2 && (
/*     */           
/* 234 */           abilityType = (AbilityType)array.get(randomXS128.nextInt(array.size))) == AbilityType.MAGNET) {
/* 235 */           bool1 = false;
/*     */         }
/*     */ 
/*     */         
/* 239 */         if (bool1) {
/* 240 */           float f1, f2; Array array1 = new Array(true, 1, Enemy.class);
/* 241 */           for (byte b2 = 0; b2 < this.g.map.spawnedEnemies.size; b2++) {
/*     */             Enemy.EnemyReference enemyReference;
/* 243 */             if ((enemyReference = ((Enemy.EnemyReference[])this.g.map.spawnedEnemies.items)[b2]).enemy != null) {
/* 244 */               array1.add(enemyReference.enemy);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 249 */           if (array1.size != 0) {
/*     */             Enemy enemy;
/*     */             
/* 252 */             f1 = ((enemy = (Enemy)array1.get(randomXS128.nextInt(array1.size))).getPosition()).x;
/* 253 */             f2 = (enemy.getPosition()).y;
/*     */           } else {
/*     */             SpawnTile spawnTile;
/*     */             
/*     */             Array array2;
/* 258 */             f1 = (spawnTile = (SpawnTile)(array2 = this.g.map.getMap().getTilesByType(SpawnTile.class)).get(randomXS128.nextInt(array2.size))).center.x;
/* 259 */             f2 = spawnTile.center.y;
/*     */           } 
/*     */           Ability ability;
/* 262 */           if ((ability = this.g.ability.registerConfigureAndStartAbility(abilityType, (int)f1, (int)f2, this.g.damage.getTowersMaxDps() * getMdpsMultiplier())) != null) {
/* 263 */             ability.startEffects();
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 268 */       a();
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 276 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 279 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/*     */       JsonValue jsonValue;
/*     */       int i;
/* 286 */       if ((i = (jsonValue = param1BonusStagesConfig.getBonusConfig("TriggerRandomAbility")).getInt("minAbilityTypes", 5)) <= 0) i = 1; 
/*     */       TriggerRandomAbility triggerRandomAbility;
/* 288 */       TriggerRandomAbility.a(triggerRandomAbility = (new TriggerRandomAbility()).applyConfig(jsonValue), i);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 297 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(triggerRandomAbility, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.7F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 298 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\TriggerRandomAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */