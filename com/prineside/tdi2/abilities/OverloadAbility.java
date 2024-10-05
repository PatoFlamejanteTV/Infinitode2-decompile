/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.managers.RenderingManager;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class OverloadAbility
/*     */   extends Ability
/*     */ {
/*  41 */   private static final TLog b = TLog.forClass(OverloadAbility.class);
/*     */ 
/*     */   
/*  44 */   private static final int[] c = new int[] { 150, 250, 350, 500, 750, 1200, 1600, 2200, 3400, 5000, 10000 };
/*     */ 
/*     */   
/*  47 */   private static final int[][] d = new int[][] { { 15, 40, 100, 0, 0, 0, 0, 0, 0, 0, 200 }, { 0, 0, 20, 50, 120, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 30, 80, 150, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 20, 60, 130, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 40, 110, 200 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final BuffType[] AFFECTED_DEBUFFS = new BuffType[] { BuffType.SLIPPING, BuffType.STUN, BuffType.SNOWBALL, BuffType.BLIZZARD, BuffType.THROW_BACK };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private int e = 1;
/*  64 */   private GameValueConfig f = new GameValueConfig(GameValueType.ENEMIES_VULNERABILITY, 0.0D, false, true);
/*  65 */   private GameValueConfig g = new GameValueConfig(GameValueType.MINERS_SPEED, 0.0D, false, true);
/*     */   @Null
/*     */   private OnEnemyReachTarget h;
/*     */   private boolean i;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  71 */     super.write(paramKryo, paramOutput);
/*  72 */     paramOutput.writeVarInt(this.e, true);
/*  73 */     paramKryo.writeObject(paramOutput, this.f);
/*  74 */     paramKryo.writeObject(paramOutput, this.g);
/*  75 */     paramKryo.writeObjectOrNull(paramOutput, this.h, OnEnemyReachTarget.class);
/*  76 */     paramOutput.writeBoolean(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  81 */     super.read(paramKryo, paramInput);
/*  82 */     this.e = paramInput.readVarInt(true);
/*  83 */     this.f = (GameValueConfig)paramKryo.readObject(paramInput, GameValueConfig.class);
/*  84 */     this.g = (GameValueConfig)paramKryo.readObject(paramInput, GameValueConfig.class);
/*  85 */     this.h = (OnEnemyReachTarget)paramKryo.readObjectOrNull(paramInput, OnEnemyReachTarget.class);
/*  86 */     this.i = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private OverloadAbility() {
/*  90 */     super(AbilityType.OVERLOAD);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDone() {
/*  95 */     b.i("onDone", new Object[0]);
/*  96 */     this.S.gameValue.removeCustomGameValue(this.f);
/*  97 */     this.S.gameValue.removeCustomGameValue(this.g);
/*  98 */     if (this.h != null) {
/*  99 */       this.S.events.getListeners(EnemyReachTarget.class).remove(this.h);
/* 100 */       this.h = null;
/*     */     } 
/* 102 */     this.S.gameValue.recalculate();
/*     */   }
/*     */   
/*     */   public int getLevel() {
/* 106 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 112 */     RenderingManager.prepareBatch(paramBatch, false);
/*     */     
/*     */     TargetTile targetTile;
/* 115 */     float f2 = ((targetTile = this.S.map.getMap().getTargetTileOrThrow()).getX() << 7) + 32.0F;
/* 116 */     float f1 = (targetTile.getY() << 7) + 38.4F;
/*     */     float f3;
/* 118 */     for (f3 = -2.0F; f3 <= 2.0F; f3++) {
/* 119 */       float f; for (f = -2.0F; f <= 2.0F; f++) {
/* 120 */         if (f3 != 0.0F || f != 0.0F) {
/*     */           
/* 122 */           paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*     */           
/* 124 */           paramBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("icon-overload"), f2 + 6.4F + f3, f1 + 6.4F + f, 51.2F, 51.2F);
/*     */           
/*     */           ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont1;
/* 127 */           (resourcePackBitmapFont1 = Game.i.assetManager.getFont(24)).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 128 */           resourcePackBitmapFont1.draw(paramBatch, this.e, f2 + 24.0F + f3, f1 + 18.0F + f, 51.2F, 1, false);
/* 129 */           resourcePackBitmapFont1.setColor(Color.WHITE);
/*     */         } 
/*     */       } 
/* 132 */     }  paramBatch.setColor(MaterialColor.DEEP_ORANGE.P500);
/*     */     
/* 134 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("icon-overload"), f2 + 6.4F, f1 + 6.4F, 51.2F, 51.2F);
/*     */     
/*     */     ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/* 137 */     (resourcePackBitmapFont = Game.i.assetManager.getFont(24)).setColor(MaterialColor.DEEP_ORANGE.P500);
/* 138 */     resourcePackBitmapFont.draw(paramBatch, this.e, f2 + 24.0F, f1 + 18.0F, 51.2F, 1, false);
/* 139 */     resourcePackBitmapFont.setColor(Color.WHITE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean start() {
/* 149 */     for (byte b = 0; b < this.S.ability.activeAbilities.size; overloadAbility++) {
/*     */       OverloadAbility overloadAbility; Ability ability;
/* 151 */       if ((ability = ((Ability[])this.S.ability.activeAbilities.items)[b]).getType() == AbilityType.OVERLOAD) {
/*     */ 
/*     */         
/* 154 */         (overloadAbility = (OverloadAbility)ability).e++;
/* 155 */         overloadAbility.c();
/*     */         
/* 157 */         this.i = true;
/*     */         
/* 159 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 164 */     this.S.gameValue.addCustomGameValue(this.f);
/* 165 */     this.S.gameValue.addCustomGameValue(this.g);
/* 166 */     this.h = new OnEnemyReachTarget(this, (byte)0);
/* 167 */     this.S.events.getListeners(EnemyReachTarget.class).addStateAffecting(this.h);
/* 168 */     c();
/*     */     
/* 170 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startEffects() {
/* 175 */     a(1.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/*     */     float f;
/* 182 */     paramFloat = (f = getDifficulty()) * paramFloat;
/* 183 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy.EnemyReference enemyReference;
/* 185 */       if ((enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy != null) {
/* 186 */         Enemy enemy = enemyReference.enemy; BuffType[] arrayOfBuffType; int i; byte b1;
/* 187 */         for (i = (arrayOfBuffType = AFFECTED_DEBUFFS).length, b1 = 0; b1 < i; ) { BuffType buffType = arrayOfBuffType[b1];
/*     */           DelayedRemovalArray delayedRemovalArray;
/* 189 */           if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(buffType)) != null)
/* 190 */             for (byte b2 = 0; b2 < delayedRemovalArray.size; b2++) {
/* 191 */               ((Buff)delayedRemovalArray.get(b2)).duration -= paramFloat;
/*     */             } 
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getDifficulty() {
/*     */     float f;
/* 201 */     return (float)StrictMath.pow(((f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_OVERLOAD_DIFFICULTY)) + 1.0F), this.e) - 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMiningSpeed() {
/* 206 */     float f = (float)StrictMath.pow(((f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_OVERLOAD_MINING_SPEED)) + 1.0F), this.e) - 1.0F;
/* 207 */     if (DifficultyMode.isEndless(this.S.gameState.difficultyMode)) {
/* 208 */       f *= (this.S.gameState.modeDifficultyMultiplier / 100.0F - 1.0F) * this.S.gameValue.getFloatValue(GameValueType.ABILITY_OVERLOAD_BONUS_PER_DIFFICULTY) + 1.0F;
/*     */     }
/* 210 */     return f;
/*     */   }
/*     */   
/*     */   private void c() {
/* 214 */     float f1 = getDifficulty();
/* 215 */     float f2 = getMiningSpeed();
/*     */     
/* 217 */     this.g.setValue((f2 + 1.0F));
/* 218 */     this.g.setFinalGlobalMultiplier(true);
/*     */     
/* 220 */     this.f.setValue((1.0F / (f1 + 1.0F)));
/* 221 */     this.f.setFinalGlobalMultiplier(true);
/*     */     
/* 223 */     this.S.gameValue.recalculate();
/*     */     
/* 225 */     b.d("miningSpeedGV %s", new Object[] { Double.valueOf(this.g.getValue()) });
/* 226 */     b.d("enemiesVulnerabilityGV %s", new Object[] { Double.valueOf(this.f.getValue()) });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 231 */     return this.i;
/*     */   }
/*     */   
/*     */   public static class OverloadAbilityFactory extends Ability.Factory<OverloadAbility> {
/*     */     public OverloadAbilityFactory(AbilityType param1AbilityType) {
/* 236 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public OverloadAbility create() {
/* 241 */       return new OverloadAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 246 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 251 */       return MaterialColor.DEEP_ORANGE.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 256 */       float f2 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_OVERLOAD_DIFFICULTY);
/* 257 */       float f3 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_OVERLOAD_MINING_SPEED);
/* 258 */       float f1 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_OVERLOAD_BONUS_PER_DIFFICULTY);
/*     */ 
/*     */ 
/*     */       
/*     */       String str;
/*     */ 
/*     */       
/* 265 */       return str = Game.i.localeManager.i18n.format("ability_description_OVERLOAD", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros(f3, 2, true).toString(), StringFormatter.compactNumberWithPrecisionTrimZeros(f2, 2, true).toString(), StringFormatter.compactNumberWithPrecisionTrimZeros(f1, 2, true).toString() });
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 270 */       return MaterialColor.DEEP_ORANGE.P800;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 276 */       return OverloadAbility.a()[StrictMath.min(param1Int, (OverloadAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 281 */       return OverloadAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (OverloadAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 286 */       return Game.i.assetManager.getDrawable("icon-overload");
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyReachTarget extends SerializableListener<OverloadAbility> implements Listener<EnemyReachTarget> {
/*     */     private OnEnemyReachTarget() {}
/*     */     
/*     */     private OnEnemyReachTarget(OverloadAbility param1OverloadAbility) {
/* 295 */       this.a = param1OverloadAbility;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/* 300 */       if (param1EnemyReachTarget.getEnemy().getCurrentTile() instanceof TargetTile) {
/* 301 */         OverloadAbility.a((OverloadAbility)this.a);
/* 302 */         if (OverloadAbility.b((OverloadAbility)this.a) == 0) {
/* 303 */           OverloadAbility.a((OverloadAbility)this.a, true); return;
/*     */         } 
/* 305 */         OverloadAbility.c((OverloadAbility)this.a);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\OverloadAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */