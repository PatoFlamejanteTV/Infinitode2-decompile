/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class FirestormAbility
/*     */   extends Ability
/*     */ {
/*  36 */   private static final int[] b = new int[] { 100, 125, 170, 250, 350, 475, 600, 725, 850, 1000, 1200 };
/*     */ 
/*     */   
/*  39 */   private static final int[][] c = new int[][] { { 7, 15, 35, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 7, 15, 30, 0, 0, 0, 0, 0, 250 }, { 0, 0, 0, 0, 10, 25, 50, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 15, 35, 60, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 15, 35, 80, 100 } };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float progressCoeff;
/*     */ 
/*     */ 
/*     */   
/*  48 */   public Array<ObjectPair<Enemy, BurnBuff>> buffsToAdd = new Array(true, 1, ObjectPair.class);
/*     */   @NAGS
/*     */   private ParticlesCanvas.ParticleConfig d;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  53 */     super.write(paramKryo, paramOutput);
/*  54 */     paramOutput.writeFloat(this.progressCoeff);
/*  55 */     paramKryo.writeObject(paramOutput, this.buffsToAdd);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  60 */     super.read(paramKryo, paramInput);
/*  61 */     this.progressCoeff = paramInput.readFloat();
/*  62 */     this.buffsToAdd = (Array<ObjectPair<Enemy, BurnBuff>>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private FirestormAbility() {
/*  66 */     super(AbilityType.FIRESTORM);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  71 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_FIRESTORM_COINS);
/*  72 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.ABILITY_FIRESTORM_DURATION);
/*     */     
/*  74 */     float f2 = (float)((f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_FIRESTORM_DAMAGE)) * paramDouble);
/*  75 */     this.buffsToAdd.clear();
/*     */     
/*  77 */     if (f2 > 0.0F) {
/*  78 */       this.S.map.spawnedEnemies.begin();
/*  79 */       for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */         Enemy enemy;
/*  81 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */           BurnBuff burnBuff;
/*     */           
/*  84 */           (burnBuff = new BurnBuff()).setup(null, f1, f1 * 10.0F, f2, this);
/*  85 */           this.buffsToAdd.add(new ObjectPair(enemy, burnBuff));
/*     */         } 
/*     */       } 
/*  88 */       this.S.map.spawnedEnemies.end();
/*     */     } 
/*     */     
/*  91 */     this.progressCoeff = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  96 */     if (this.buffsToAdd.size == 0) {
/*  97 */       if (this.S._gameUi != null) {
/*  98 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/* 100 */       return false;
/*     */     } 
/*     */     
/* 103 */     for (byte b = 0; b < this.buffsToAdd.size; b++) {
/* 104 */       ObjectPair objectPair = ((ObjectPair[])this.buffsToAdd.items)[b];
/* 105 */       this.S.buff.P_BURN.addBuff((Enemy)objectPair.first, (BurnBuff)objectPair.second);
/*     */     } 
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startEffects() {
/* 112 */     a(1.5F);
/*     */ 
/*     */     
/* 115 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && this.S._gameUi != null && !this.S.gameState.canSkipMediaUpdate()) {
/* 116 */       ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)FirestormAbilityFactory.a(Game.i.abilityManager.F.FIRESTORM).obtain();
/* 117 */       this.S._gameUi.mainUi.particlesCanvas.addParticle((ParticleEffect)pooledEffect, 0.0F, 0.0F);
/*     */       
/* 119 */       pooledEffect = (ParticleEffectPool.PooledEffect)FirestormAbilityFactory.b(Game.i.abilityManager.F.FIRESTORM).obtain();
/* 120 */       this.S._gameUi.mainUi.particlesCanvas.addParticle((ParticleEffect)pooledEffect, this.S._gameUi.mainUi.particlesCanvas.getWidth(), 0.0F);
/*     */       
/* 122 */       pooledEffect = (ParticleEffectPool.PooledEffect)FirestormAbilityFactory.c(Game.i.abilityManager.F.FIRESTORM).obtain();
/* 123 */       this.d = this.S._gameUi.mainUi.particlesCanvas.addParticle((ParticleEffect)pooledEffect, 0.0F, 0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 129 */     this.progressCoeff += paramFloat * 0.5F;
/*     */     
/* 131 */     if (this.d != null) {
/* 132 */       this.d.x = Game.i.uiManager.viewport.getWorldWidth() * this.progressCoeff;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 138 */     return (this.progressCoeff >= 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDone() {
/* 143 */     if (this.d != null) {
/* 144 */       this.d.effect.allowCompletion();
/* 145 */       this.d = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */   
/*     */   public static class FirestormAbilityFactory
/*     */     extends Ability.Factory<FirestormAbility>
/*     */   {
/*     */     private ParticleEffectPool a;
/*     */     private ParticleEffectPool b;
/*     */     private ParticleEffectPool c;
/*     */     
/*     */     public FirestormAbilityFactory(AbilityType param1AbilityType) {
/* 160 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 165 */       this.a = Game.i.assetManager.getParticleEffectPool("screen-sparks-bottom-left.prt");
/* 166 */       this.b = Game.i.assetManager.getParticleEffectPool("screen-sparks-bottom-right.prt");
/* 167 */       this.c = Game.i.assetManager.getParticleEffectPool("fire-2.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public FirestormAbility create() {
/* 172 */       return new FirestormAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 177 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 182 */       return MaterialColor.RED.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 187 */       float f1 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_FIRESTORM_DURATION);
/* 188 */       float f2 = (float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_FIRESTORM_DAMAGE);
/* 189 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_FIRESTORM_COINS) * 100.0D);
/* 190 */       f2 = MathUtils.round(f2 * 1000.0F) * 0.1F;
/*     */       
/* 192 */       String str2 = Game.i.localeManager.i18n.format("ability_description_FIRESTORM", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
/* 193 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 194 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 199 */       return MaterialColor.RED.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 204 */       return FirestormAbility.a()[StrictMath.min(param1Int, (FirestormAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 209 */       return FirestormAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (FirestormAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 214 */       return Game.i.assetManager.getDrawable("icon-firestorm");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\FirestormAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */