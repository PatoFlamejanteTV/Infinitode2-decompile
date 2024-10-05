/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class MetaphorBossEnemy
/*     */   extends Enemy
/*     */ {
/*  36 */   public int creepCount = 0;
/*     */   @NAGS
/*     */   private LegConfig[] a;
/*     */   @NAGS
/*     */   private LegConfig[] b;
/*     */   
/*     */   static {
/*  43 */     d = ((paramLegConfig1, paramLegConfig2) -> Float.compare(paramLegConfig2.a, paramLegConfig1.a));
/*     */   } @NAGS
/*     */   private ParticleEffectPool.PooledEffect c; private static final Comparator<LegConfig> d;
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  47 */     super.write(paramKryo, paramOutput);
/*  48 */     paramOutput.writeVarInt(this.creepCount, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  53 */     super.read(paramKryo, paramInput);
/*  54 */     this.creepCount = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   private void a() {
/*  68 */     this.a = new LegConfig[8];
/*  69 */     this.b = new LegConfig[8];
/*     */ 
/*     */     
/*  72 */     this.a[0] = new LegConfig(this, 0, -10.0F, 14.0F, 25.0F, 75.0F, 1.2F);
/*  73 */     this.a[1] = new LegConfig(this, 1, 10.0F, 14.0F, 335.0F, 285.0F, 1.2F);
/*     */     
/*  75 */     this.a[2] = new LegConfig(this, 0, -9.0F, 2.0F, 63.0F, 113.0F, 1.0F);
/*  76 */     this.a[3] = new LegConfig(this, 1, 9.0F, 2.0F, 297.0F, 247.0F, 1.0F);
/*     */     
/*  78 */     this.a[4] = new LegConfig(this, 0, -11.0F, -6.0F, 101.0F, 129.0F, 0.85F);
/*  79 */     this.a[5] = new LegConfig(this, 1, 11.0F, -6.0F, 259.0F, 231.0F, 0.85F);
/*     */     
/*  81 */     this.a[6] = new LegConfig(this, 0, -8.0F, -14.0F, 133.0F, 167.0F, 0.7F);
/*  82 */     this.a[7] = new LegConfig(this, 1, 8.0F, -14.0F, 227.0F, 193.0F, 0.7F);
/*     */     
/*  84 */     System.arraycopy(this.a, 0, this.b, 0, this.b.length);
/*     */   }
/*     */   
/*     */   private MetaphorBossEnemy() {
/*  88 */     super(EnemyType.METAPHOR_BOSS);
/*     */   }
/*     */   
/*     */   public final boolean canHaveRandomSideShift() {
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*     */     float f;
/*  98 */     if ((f = 1.0F - this.creepCount * 0.02F) < 0.0F) f = 0.0F;
/*     */     
/* 100 */     return super.getBuffedDamageMultiplier(paramTowerType, paramDamageType) * f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/* 115 */     float f = super.getAbilityVulnerability(paramAbilityType);
/* 116 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/* 117 */       return f * 0.1F;
/*     */     }
/*     */     
/* 120 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/* 125 */     return 100.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat, Color paramColor) {
/* 130 */     if (this.c == null && Game.i.settingsManager.isParticlesDrawing()) {
/* 131 */       this.c = (ParticleEffectPool.PooledEffect)Game.i.enemyManager.F.METAPHOR_BOSS.c.obtain();
/* 132 */       this.c.start();
/*     */     } 
/*     */     
/* 135 */     if (this.c != null) {
/* 136 */       this.c.setPosition(this.drawPosition.x, this.drawPosition.y);
/* 137 */       this.c.draw(paramBatch, paramFloat);
/*     */     } 
/*     */ 
/*     */     
/* 141 */     if (this.a == null)
/* 142 */       a();  LegConfig[] arrayOfLegConfig;
/*     */     int i;
/*     */     byte b;
/* 145 */     for (i = (arrayOfLegConfig = this.a).length, b = 0; b < i; b++) {
/* 146 */       LegConfig legConfig; if ((legConfig = arrayOfLegConfig[b]) != null)
/* 147 */         legConfig.a(paramFloat * this.S.gameState.getGameSpeed(), this.drawPosition.x, this.drawPosition.y, this.drawAngle); 
/*     */     } 
/* 149 */     if ((this.a[0]).b > 0.75F && (this.a[1]).b > 0.75F)
/*     */     {
/* 151 */       LegConfig.a(this.a[FastRandom.getInt(2)], this.drawPosition.x, this.drawPosition.y, this.drawAngle);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     Arrays.sort(this.b, d);
/* 173 */     for (i = (arrayOfLegConfig = this.b).length, b = 0; b < i; b++) {
/* 174 */       LegConfig legConfig; if ((legConfig = arrayOfLegConfig[b]) != null) {
/* 175 */         legConfig.a(paramBatch, this.drawPosition.x, this.drawPosition.y, this.drawAngle, this.drawScale);
/*     */       }
/*     */     } 
/*     */     
/* 179 */     float f1 = this.drawScale + MathUtils.sin(this.existsTime * 4.0F) * 0.05F;
/* 180 */     float f2 = Game.i.enemyManager.F.METAPHOR_BOSS.a.getRegionWidth() * 1.8F * f1;
/* 181 */     paramBatch.draw(Game.i.enemyManager.F.METAPHOR_BOSS.a, this.drawPosition.x - f2 * 0.5F, this.drawPosition.y - f2 * 0.5F, f2 * 0.5F, f2 * 0.5F, f2, f2, 1.0F, 1.0F, this.drawAngle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 192 */     return false;
/*     */   }
/*     */   
/*     */   private class LegConfig {
/* 196 */     private float c = 0.5F;
/* 197 */     private float d = 1.3F;
/*     */     
/* 199 */     private float e = 44.979996F;
/* 200 */     private float f = 153.4F;
/* 201 */     private float g = this.c * this.f * this.c * this.f;
/* 202 */     private float h = this.d * this.f * this.d * this.f;
/*     */ 
/*     */     
/* 205 */     private Vector2 i = new Vector2();
/* 206 */     private Vector2 j = new Vector2(Float.MIN_VALUE, Float.MIN_VALUE);
/* 207 */     private Vector2 k = new Vector2(Float.MIN_VALUE, Float.MIN_VALUE);
/*     */     
/*     */     private float l;
/*     */     private float m;
/*     */     private float n;
/*     */     private float o;
/* 213 */     private float p = 0.0F;
/* 214 */     float a = 1.0F;
/* 215 */     float b = 0.0F;
/*     */     
/* 217 */     private final Vector2 q = new Vector2();
/*     */ 
/*     */     
/*     */     LegConfig(MetaphorBossEnemy this$0, int param1Int, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5) {
/* 221 */       this.i.set(param1Float1, param1Float2);
/* 222 */       this.l = param1Float3;
/* 223 */       this.m = param1Float4;
/* 224 */       this.o = param1Float5;
/*     */       
/* 226 */       this.n = PMath.getDistanceBetweenAngles(param1Float3, param1Float4);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5) {
/* 235 */       param1Float4 = this.l + (this.m - this.l) * param1Float4;
/* 236 */       Vector2 vector2 = new Vector2();
/* 237 */       PMath.getPointByAngleFromPoint(0.0F, 0.0F, param1Float4, this.f * param1Float5, vector2);
/*     */ 
/*     */       
/* 240 */       this.j.set(this.i).add(vector2).rotateDeg(param1Float3).add(param1Float1, param1Float2);
/*     */ 
/*     */       
/* 243 */       b(param1Float1, param1Float2, param1Float3);
/*     */ 
/*     */       
/* 246 */       this.p = 1.0F;
/*     */     }
/*     */     
/*     */     private void a(float param1Float1, float param1Float2, float param1Float3) {
/* 250 */       a(param1Float1, param1Float2, param1Float3, 0.001F + FastRandom.getFloat() * 0.1F, this.o);
/*     */     }
/*     */     
/*     */     private float b(float param1Float1, float param1Float2, float param1Float3) {
/* 254 */       this.q.set(this.i);
/* 255 */       this.q.rotate(param1Float3);
/*     */       
/* 257 */       return PMath.getAngleBetweenPoints(param1Float1 + this.q.x, param1Float2 + this.q.y, this.j.x, this.j.y) - param1Float3;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private float a(float param1Float) {
/* 263 */       float f = (param1Float = PMath.getDistanceBetweenAngles(this.l, param1Float)) / this.n;
/* 264 */       if (this.n < 0.0F) {
/* 265 */         f = -param1Float / -this.n;
/*     */       }
/*     */       
/* 268 */       return f;
/*     */     }
/*     */     
/*     */     private Vector2 c(float param1Float1, float param1Float2, float param1Float3) {
/* 272 */       this.q.set(this.i);
/* 273 */       this.q.rotate(param1Float3);
/* 274 */       this.q.add(param1Float1, param1Float2);
/*     */       
/* 276 */       return this.q;
/*     */     }
/*     */ 
/*     */     
/*     */     final void a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 281 */       float f1 = -1.0F;
/* 282 */       float f2 = this.o;
/*     */       
/* 284 */       float f3 = b(param1Float2, param1Float3, param1Float4);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 289 */       if ((f3 = a(f3)) < 0.0F) {
/*     */         
/* 291 */         f1 = 0.999F - FastRandom.getFloat() * 0.1F;
/*     */       }
/* 293 */       else if (f3 > 1.0F) {
/*     */         
/* 295 */         f1 = 0.001F + FastRandom.getFloat() * 0.1F;
/*     */       } 
/*     */       
/* 298 */       if (this.j.x == Float.MIN_VALUE)
/*     */       {
/* 300 */         f1 = 0.002F + FastRandom.getFloat() * 0.996F;
/*     */       }
/* 302 */       if (f1 == -1.0F) {
/*     */         
/* 304 */         Vector2 vector21 = c(param1Float2, param1Float3, param1Float4);
/*     */         float f;
/* 306 */         if ((f = PMath.getSquareDistanceBetweenPoints(this.j.x, this.j.y, vector21.x, vector21.y)) < this.g) {
/*     */ 
/*     */           
/* 309 */           f1 = f3 * 0.2F;
/* 310 */         } else if (f > this.h) {
/*     */           
/* 312 */           f1 = f3 * 0.2F;
/*     */         } 
/*     */       } 
/*     */       
/* 316 */       if (f1 != -1.0F) {
/*     */         
/* 318 */         a(param1Float2, param1Float3, param1Float4, f1, f2);
/* 319 */         this.b = a(b(param1Float2, param1Float3, param1Float4));
/*     */       } else {
/* 321 */         this.b = f3;
/*     */       } 
/*     */       
/* 324 */       if (this.k.x == Float.MIN_VALUE) {
/*     */         
/* 326 */         this.k.set(this.j);
/*     */       
/*     */       }
/* 329 */       else if (this.p != 0.0F) {
/* 330 */         this.p -= param1Float1 * 5.0F;
/* 331 */         if (this.p <= 0.0F) {
/* 332 */           this.k.set(this.j);
/* 333 */           this.p = 0.0F;
/*     */         } else {
/* 335 */           this.k.lerp(this.j, 1.0F - this.p);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 340 */       Vector2 vector2 = c(param1Float2, param1Float3, param1Float4);
/* 341 */       this.a = PMath.getDistanceBetweenPoints(vector2.x, vector2.y, this.k.x, this.k.y) / this.f;
/*     */     }
/*     */     
/*     */     final void a(Batch param1Batch, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 345 */       Vector2 vector2 = c(param1Float1, param1Float2, param1Float3);
/* 346 */       DrawUtils.texturedLineB(param1Batch, Game.i.enemyManager.F.METAPHOR_BOSS.b, vector2.x, vector2.y, vector2.x + (this.k.x - vector2.x) * param1Float4, vector2.y + (this.k.y - vector2.y) * param1Float4, this.e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MetaphorBossEnemyFactory
/*     */     extends Enemy.Factory<MetaphorBossEnemy> {
/*     */     private TextureRegion d;
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     ParticleEffectPool c;
/*     */     
/*     */     public MetaphorBossEnemyFactory() {
/* 358 */       super(EnemyType.METAPHOR_BOSS);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 363 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 368 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 373 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-metaphor");
/* 374 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-metaphor-body");
/* 375 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-metaphor-leg");
/*     */       
/* 377 */       this.c = Game.i.assetManager.getParticleEffectPool("smoke-cloud.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public MetaphorBossEnemy create() {
/* 382 */       return new MetaphorBossEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 387 */       return MaterialColor.RED.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\MetaphorBossEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */