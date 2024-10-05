/*     */ package com.prineside.tdi2.projectiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BonusCoinsBuff;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.shapes.MultiLine;
/*     */ import com.prineside.tdi2.towers.LaserTower;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class LaserProjectile
/*     */   extends Projectile {
/*     */   @NAGS
/*     */   private MultiLine a;
/*     */   @NAGS
/*     */   private MultiLine b;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect d;
/*     */   @NAGS
/*     */   private boolean e;
/*     */   private Tower f;
/*     */   private float g;
/*     */   private float h;
/*     */   private float i;
/*     */   private float j;
/*     */   private float k;
/*     */   private float l;
/*     */   private float m;
/*     */   private float n;
/*     */   public int penetrationCount;
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte o;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  59 */     super.write(paramKryo, paramOutput);
/*  60 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*  61 */     paramOutput.writeFloat(this.g);
/*  62 */     paramOutput.writeFloat(this.h);
/*  63 */     paramOutput.writeFloat(this.i);
/*  64 */     paramOutput.writeFloat(this.j);
/*  65 */     paramOutput.writeVarInt(this.penetrationCount, true);
/*  66 */     paramOutput.writeFloat(this.k);
/*  67 */     paramOutput.writeFloat(this.l);
/*  68 */     paramOutput.writeFloat(this.m);
/*  69 */     paramOutput.writeFloat(this.n);
/*  70 */     paramOutput.writeByte(this.o);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  75 */     super.read(paramKryo, paramInput);
/*  76 */     this.f = (Tower)paramKryo.readClassAndObject(paramInput);
/*  77 */     this.g = paramInput.readFloat();
/*  78 */     this.h = paramInput.readFloat();
/*  79 */     this.i = paramInput.readFloat();
/*  80 */     this.j = paramInput.readFloat();
/*  81 */     this.penetrationCount = paramInput.readVarInt(true);
/*  82 */     this.k = paramInput.readFloat();
/*  83 */     this.l = paramInput.readFloat();
/*  84 */     this.m = paramInput.readFloat();
/*  85 */     this.n = paramInput.readFloat();
/*  86 */     this.o = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private LaserProjectile() {
/*  90 */     super(ProjectileType.LASER);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt) {
/*  94 */     setup();
/*     */     
/*  96 */     this.f = paramTower;
/*  97 */     this.c = paramFloat2;
/*  98 */     this.g = paramFloat3;
/*  99 */     this.h = paramFloat4;
/* 100 */     this.i = paramFloat5;
/* 101 */     this.j = paramFloat6;
/* 102 */     this.penetrationCount = paramInt;
/* 103 */     this.k = paramFloat1;
/*     */     
/* 105 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final float getStartX() {
/* 109 */     return this.g;
/*     */   }
/*     */   
/*     */   public final float getStartY() {
/* 113 */     return this.h;
/*     */   }
/*     */   
/*     */   public final float getEndX() {
/* 117 */     return this.i;
/*     */   }
/*     */   
/*     */   public final float getEndY() {
/* 121 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/* 126 */     super.setUnregistered();
/*     */     
/* 128 */     if (this.a != null) {
/* 129 */       ((MultiLine.MultiLineFactory)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE)).free((Shape)this.a);
/* 130 */       this.a = null;
/*     */     } 
/* 132 */     if (this.b != null) {
/* 133 */       ((MultiLine.MultiLineFactory)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE)).free((Shape)this.b);
/* 134 */       this.b = null;
/*     */     } 
/*     */     
/* 137 */     if (this.d != null) {
/* 138 */       this.d.allowCompletion();
/* 139 */       this.d = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/* 145 */     super.reset();
/*     */     
/* 147 */     this.f = null;
/* 148 */     this.n = 0.0F;
/* 149 */     this.l = 0.0F;
/* 150 */     this.m = 0.0F;
/* 151 */     this.g = 0.0F;
/* 152 */     this.h = 0.0F;
/* 153 */     this.i = 0.0F;
/* 154 */     this.j = 0.0F;
/* 155 */     this.k = 0.0F;
/* 156 */     this.penetrationCount = 0;
/* 157 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final void stop() {
/* 161 */     this.n = this.k;
/*     */   }
/*     */   
/*     */   private boolean a() {
/* 165 */     return (this.l == 0.0F && this.m == 0.0F);
/*     */   }
/*     */   
/*     */   public final void handleCollisions(float paramFloat) {
/* 169 */     if (this.S == null)
/*     */       return; 
/* 171 */     if (this.f != null && !this.f.isRegistered()) {
/* 172 */       this.f = null;
/*     */     }
/*     */     
/*     */     LaserTower laserTower;
/* 176 */     float f1 = ((laserTower = (LaserTower)((this.f != null && this.f.type == TowerType.LASER && this.f.isAbilityInstalled(4)) ? this.f : null)) == null) ? 1.0F : laserTower.getUltDamageMultiplier();
/* 177 */     this.S.achievement.setProgress(AchievementType.DOUBLE_LASER_DAMAGE, (int)((f1 - 1.0F) * 100.0F));
/*     */     
/* 179 */     Array array = this.S.TSH.getEnemyArray();
/* 180 */     this.S.map.rayCastEnemiesSorted(this.g, this.h, this.i, this.j, 0.0F, paramEnemyReference -> {
/*     */           if (paramEnemyReference.enemy != null) {
/*     */             paramArray.add(paramEnemyReference.enemy);
/*     */           }
/*     */           
/*     */           return true;
/*     */         });
/* 187 */     float f2 = 0.0F;
/* 188 */     float f3 = 0.0F;
/*     */     
/* 190 */     if (array.size > 0) {
/* 191 */       float f4; int i = this.penetrationCount;
/*     */       
/* 193 */       boolean bool = false;
/* 194 */       float f5 = 0.0F;
/*     */       
/* 196 */       for (byte b = 0; b < array.size; b++) {
/*     */         Enemy enemy;
/* 198 */         if ((enemy = ((Enemy[])array.items)[b]) != null) {
/*     */           Vector2 vector2;
/*     */           
/* 201 */           f2 = (vector2 = enemy.getPosition()).x;
/* 202 */           f4 = vector2.y;
/* 203 */           f5 = enemy.getSquaredSize();
/*     */           
/* 205 */           if (paramFloat != 0.0F) {
/* 206 */             this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.c * f1 * paramFloat, DamageType.LASER).setTower(this.f).setProjectile(this));
/*     */           }
/*     */           
/* 209 */           if (this.f instanceof LaserTower && this.f.isAbilityInstalled(3)) {
/* 210 */             BonusCoinsBuff bonusCoinsBuff = new BonusCoinsBuff();
/* 211 */             float f6 = this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_COINS_DURATION);
/* 212 */             float f7 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_IONIZATION_COINS);
/* 213 */             bonusCoinsBuff.setup(f6, f6 * 10.0F, f7, this.f);
/* 214 */             this.S.buff.P_BONUS_COINS.addBuff(enemy, bonusCoinsBuff);
/*     */           } 
/*     */           
/* 217 */           i--;
/* 218 */           if (i == 0) {
/* 219 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 225 */       if (bool) {
/* 226 */         Vector2 vector2 = new Vector2();
/* 227 */         if (PMath.getLineCircleIntersectionFloats(this.g, this.h, this.i, this.j, f2, f4, f5, vector2)) {
/* 228 */           this.l = vector2.x;
/* 229 */           this.m = vector2.y;
/* 230 */           this.e = true;
/*     */         } 
/*     */       } else {
/* 233 */         if (this.l != this.i) {
/* 234 */           this.e = true;
/*     */         }
/* 236 */         this.l = this.i;
/* 237 */         this.m = this.j;
/*     */       }
/*     */     
/* 240 */     } else if (this.i != this.l || this.j != this.m) {
/* 241 */       this.l = this.i;
/* 242 */       this.m = this.j;
/* 243 */       this.e = true;
/*     */     } 
/*     */     
/* 246 */     this.S.TSH.freeEnemyArray(array);
/*     */   }
/*     */   private void b() {
/*     */     float f1;
/* 250 */     if (a()) {
/* 251 */       throw new IllegalStateException("Collision point is not calculated");
/*     */     }
/*     */     
/* 254 */     if (this.a == null) {
/* 255 */       this.a = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/* 256 */       this.b = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*     */     } 
/*     */ 
/*     */     
/* 260 */     if (this.penetrationCount == 1) {
/* 261 */       f1 = MaterialColor.RED.P500.toFloatBits();
/*     */     } else {
/* 263 */       f1 = MaterialColor.LIGHT_BLUE.P500.toFloatBits();
/*     */     } 
/*     */     
/* 266 */     this.b.reset();
/* 267 */     this.b.setTextureRegion(this.S.projectile.F.LASER.b, false, false);
/*     */     Vector2 vector2;
/* 269 */     (vector2 = new Vector2()).set(this.i - this.g, this.j - this.h);
/* 270 */     vector2.nor().scl(this.S.projectile.F.LASER.b.getRegionWidth());
/* 271 */     this.b.appendNode(this.g, this.h, 48.0F, f1, false);
/* 272 */     this.b.appendNode(this.g + vector2.x, this.h + vector2.y, 48.0F, f1, false);
/* 273 */     this.b.updateAllNodes();
/*     */ 
/*     */     
/* 276 */     this.a.reset();
/* 277 */     this.a.setTextureRegion(this.S.projectile.F.LASER.a, false, false);
/*     */ 
/*     */ 
/*     */     
/* 281 */     float f2 = PMath.getDistanceBetweenPoints(this.g, this.h, this.l, this.m) / this.S.projectile.F.LASER.a.getRegionWidth();
/* 282 */     float f3 = this.g + vector2.x;
/* 283 */     float f4 = this.h + vector2.y;
/* 284 */     this.a.appendNode(f3, f4, 48.0F, f1, false);
/* 285 */     while (f2 > 0.0F) {
/* 286 */       if (f2 <= 1.0F) {
/* 287 */         f3 = this.l;
/* 288 */         f4 = this.m;
/*     */       } else {
/* 290 */         f3 += vector2.x;
/* 291 */         f4 += vector2.y;
/*     */       } 
/* 293 */       this.a.appendNode(f3, f4, 48.0F, f1, false);
/* 294 */       f2--;
/*     */     } 
/* 296 */     this.a.updateAllNodes();
/*     */ 
/*     */     
/* 299 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 300 */       if (this.l != 0.0F && this.m != 0.0F) {
/* 301 */         if (this.d == null && !this.S._particle.willParticleBeSkipped()) {
/* 302 */           this.d = (ParticleEffectPool.PooledEffect)this.S.projectile.F.LASER.c.obtain();
/* 303 */           f1 = PMath.getAngleBetweenPoints(this.g, this.h, this.i, this.j) - 90.0F;
/*     */           ParticleEmitter.ScaledNumericValue scaledNumericValue;
/* 305 */           (scaledNumericValue = ((ParticleEmitter)this.d.getEmitters().first()).getAngle()).setHigh(f1 - 60.0F, f1 + 60.0F);
/* 306 */           this.S._particle.addParticle((ParticleEffect)this.d, true);
/*     */         } 
/*     */         
/* 309 */         this.d.setPosition(this.l, this.m);
/*     */       }
/* 311 */       else if (this.d != null) {
/* 312 */         this.d.allowCompletion();
/* 313 */         this.d = null;
/*     */       } 
/*     */     }
/*     */     
/* 317 */     this.e = false;
/*     */   }
/*     */   
/*     */   public final void setStartPos(float paramFloat1, float paramFloat2) {
/* 321 */     this.g = paramFloat1;
/* 322 */     this.h = paramFloat2;
/* 323 */     this.l = 0.0F;
/* 324 */     this.m = 0.0F;
/* 325 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final void setEndPos(float paramFloat1, float paramFloat2) {
/* 329 */     this.i = paramFloat1;
/* 330 */     this.j = paramFloat2;
/* 331 */     this.l = 0.0F;
/* 332 */     this.m = 0.0F;
/* 333 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final float getDuration() {
/* 337 */     return this.k;
/*     */   }
/*     */   
/*     */   public final void setDuration(float paramFloat) {
/* 341 */     this.k = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 346 */     return (this.n >= this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasReachedTarget() {
/* 351 */     return (this.n >= this.k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyDrawInterpolation(float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 361 */     if (isDone())
/*     */       return; 
/* 363 */     this.n += paramFloat;
/*     */ 
/*     */     
/* 366 */     this.o = (byte)(this.o + 1);
/* 367 */     if (this.o == 2) {
/* 368 */       this.o = 0;
/* 369 */       handleCollisions(paramFloat * 2.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 376 */     if (a()) {
/*     */       return;
/*     */     }
/*     */     
/* 380 */     if (this.e || this.a == null) {
/* 381 */       b();
/*     */     }
/*     */     
/* 384 */     paramFloat = this.n / 0.15F;
/* 385 */     if (this.k - this.n < 0.15F) {
/* 386 */       paramFloat = (this.k - this.n) / 0.15F;
/*     */     }
/* 388 */     if (paramFloat > 1.0F) paramFloat = 1.0F;
/*     */     
/* 390 */     this.b.setTintWithAlpha(Color.WHITE, paramFloat);
/* 391 */     this.b.draw(paramBatch);
/* 392 */     this.a.setTintWithAlpha(Color.WHITE, paramFloat);
/* 393 */     this.a.draw(paramBatch);
/*     */   }
/*     */   
/*     */   public static class LaserProjectileFactory
/*     */     extends Projectile.Factory<LaserProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     ParticleEffectPool c;
/*     */     
/*     */     public void setupAssets() {
/* 404 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("laser");
/* 405 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("laser-cap");
/* 406 */       this.c = Game.i.assetManager.getParticleEffectPool("sparkles.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     private static LaserProjectile b() {
/* 411 */       return new LaserProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\LaserProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */