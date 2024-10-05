/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*     */ import com.prineside.tdi2.buffs.processors.ThrowBackBuffProcessor;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class WindstormAbility
/*     */   extends Ability
/*     */ {
/*  38 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  41 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 300 }, { 0, 0, 5, 10, 30, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 10, 20, 50, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 25, 45, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 75, 100 } };
/*     */ 
/*     */   
/*     */   private int d;
/*     */   
/*     */   private int e;
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */   
/*     */   private float h;
/*     */   
/*  54 */   private float i = 0.0F; @NAGS
/*     */   private ParticleEffectPool.PooledEffect j;
/*  56 */   private Array<Enemy.EnemyReference> k = new Array(Enemy.EnemyReference.class);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramOutput.writeInt(this.d, true);
/*  62 */     paramOutput.writeInt(this.e, true);
/*  63 */     paramOutput.writeFloat(this.f);
/*  64 */     paramOutput.writeFloat(this.g);
/*  65 */     paramOutput.writeFloat(this.h);
/*  66 */     paramOutput.writeFloat(this.i);
/*  67 */     paramKryo.writeObject(paramOutput, this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  72 */     super.read(paramKryo, paramInput);
/*  73 */     this.d = paramInput.readInt(true);
/*  74 */     this.e = paramInput.readInt(true);
/*  75 */     this.f = paramInput.readFloat();
/*  76 */     this.g = paramInput.readFloat();
/*  77 */     this.h = paramInput.readFloat();
/*  78 */     this.i = paramInput.readFloat();
/*  79 */     this.k = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private WindstormAbility() {
/*  83 */     super(AbilityType.WINDSTORM);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  88 */     this.d = paramInt1;
/*  89 */     this.e = paramInt2;
/*  90 */     this.f = this.S.gameValue.getFloatValue(GameValueType.ABILITY_WINDSTORM_RANGE);
/*  91 */     this.g = this.S.gameValue.getFloatValue(GameValueType.ABILITY_WINDSTORM_DURATION);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  97 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate()) {
/*  98 */       this.j = (ParticleEffectPool.PooledEffect)WindstormAbilityFactory.a(Game.i.abilityManager.F.WINDSTORM).obtain();
/*  99 */       this.j.setPosition(this.d, this.e);
/*     */       
/* 101 */       float f = this.f * 128.0F / 128.0F;
/*     */       
/* 103 */       ((ParticleEmitter)this.j.getEmitters().first()).getVelocity().setHigh(140.0F * f, 200.0F * f);
/* 104 */       this.S._particle.addParticle((ParticleEffect)this.j, false);
/*     */     } 
/*     */ 
/*     */     
/* 108 */     this.S.wave.freezeTimeToNextWave(this.g * 2.0F);
/* 109 */     this.S.wave.setForceWaveDoubleBonus(true);
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 116 */     this.i -= paramFloat;
/* 117 */     this.h += paramFloat;
/*     */     
/* 119 */     if (this.h >= this.g) {
/*     */       
/* 121 */       ThrowBackBuffProcessor throwBackBuffProcessor = this.S.buff.P_THROW_BACK;
/* 122 */       for (byte b = 0; b < this.k.size; b++) {
/*     */         Enemy enemy;
/* 124 */         if ((enemy = (((Enemy.EnemyReference[])this.k.items)[b]).enemy) != null) {
/*     */           DelayedRemovalArray delayedRemovalArray;
/* 126 */           for (int i = (delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.THROW_BACK)).size - 1; i >= 0; i--) {
/*     */             ThrowBackBuff throwBackBuff;
/*     */             
/* 129 */             if ((throwBackBuff = (ThrowBackBuff)delayedRemovalArray.items[i]).ownerId == -1) {
/* 130 */               throwBackBuffProcessor.removeBuffAtIndex(enemy, BuffType.THROW_BACK, i);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 135 */       this.k.clear();
/*     */       
/* 137 */       if (this.j != null)
/* 138 */         this.j.allowCompletion();  return;
/*     */     } 
/* 140 */     if (this.i <= 0.0F) {
/* 141 */       ThrowBackBuffProcessor throwBackBuffProcessor = this.S.buff.P_THROW_BACK;
/* 142 */       float f = this.f * 128.0F * this.f * 128.0F;
/* 143 */       this.S.map.spawnedEnemies.begin();
/* 144 */       for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */         Enemy enemy; DelayedRemovalArray delayedRemovalArray;
/* 146 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null && ((
/*     */           
/* 148 */           delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.THROW_BACK)) == null || delayedRemovalArray.size == 0)) {
/*     */           float f1;
/*     */           
/* 151 */           if ((f1 = PMath.getSquareDistanceBetweenPoints(this.d, this.e, (enemy.getPosition()).x, (enemy.getPosition()).y)) < f) {
/*     */             ThrowBackBuff throwBackBuff;
/* 153 */             (throwBackBuff = new ThrowBackBuff()).setup(-1, 2.5F, this.g + 0.01F, this.g * 10.0F);
/* 154 */             if (throwBackBuffProcessor.addBuff(enemy, throwBackBuff))
/* 155 */               this.k.add(this.S.enemy.getReference(enemy)); 
/*     */           } 
/*     */         } 
/*     */       } 
/* 159 */       this.S.map.spawnedEnemies.end();
/*     */       
/* 161 */       this.i = 0.191F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 167 */     return (this.h >= this.g);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 173 */     if ((paramFloat = this.h / this.g) > 1.0F) paramFloat = 1.0F;
/*     */     
/* 175 */     ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getTextureRegion("particle-shockwave-twirled-fat");
/*     */     
/* 177 */     float f = 1.0F;
/* 178 */     if (paramFloat <= 0.05F) {
/* 179 */       f = paramFloat / 0.05F;
/* 180 */     } else if (paramFloat >= 0.95F) {
/* 181 */       f = 1.0F - (paramFloat - 0.95F) / 0.05F;
/*     */     } 
/* 183 */     f *= 0.19F;
/* 184 */     paramBatch.setColor(1.0F, 1.0F, 1.0F, f);
/* 185 */     paramBatch.draw((TextureRegion)atlasTextureRegion, this.d - this.f * 128.0F, this.e - this.f * 128.0F, this.f * 128.0F, this.f * 128.0F, this.f * 2.0F * 128.0F, this.f * 2.0F * 128.0F, 1.0F, 1.0F, -this.h * 90.0F);
/* 186 */     paramBatch.draw((TextureRegion)atlasTextureRegion, this.d - this.f * 128.0F, this.e - this.f * 128.0F, this.f * 128.0F, this.f * 128.0F, this.f * 2.0F * 128.0F, this.f * 2.0F * 128.0F, 0.74F, 0.74F, -this.h * 120.0F);
/* 187 */     paramBatch.draw((TextureRegion)atlasTextureRegion, this.d - this.f * 128.0F, this.e - this.f * 128.0F, this.f * 128.0F, this.f * 128.0F, this.f * 2.0F * 128.0F, this.f * 2.0F * 128.0F, 0.54760003F, 0.54760003F, -this.h * 150.0F);
/* 188 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */   
/*     */   public static class WindstormAbilityFactory extends Ability.Factory<WindstormAbility> {
/*     */     private ParticleEffectPool a;
/*     */     
/*     */     public WindstormAbilityFactory(AbilityType param1AbilityType) {
/* 195 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 200 */       this.a = Game.i.assetManager.getParticleEffectPool("windstorm.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public WindstormAbility create() {
/* 205 */       return new WindstormAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 210 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 215 */       return MaterialColor.BLUE.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 220 */       float f2 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_WINDSTORM_RANGE);
/* 221 */       float f1 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_WINDSTORM_DURATION);
/*     */       
/* 223 */       String str2 = Game.i.localeManager.i18n.format("ability_description_WINDSTORM", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
/* 224 */       String str1 = Game.i.localeManager.i18n.format("ability_delays_next_wave", new Object[] { StringFormatter.compactNumberWithPrecision((f1 * 2.0F), 1) });
/*     */       
/* 226 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 231 */       return MaterialColor.BLUE.P700;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 237 */       return WindstormAbility.a()[StrictMath.min(param1Int, (WindstormAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 242 */       return WindstormAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (WindstormAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 247 */       return Game.i.assetManager.getDrawable("icon-windstorm");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\WindstormAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */