/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.systems.ExplosionSystem;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Explosion
/*     */   extends Registrable
/*     */   implements Pool.Poolable {
/*     */   public static final float EXPLOSION_RANGE_ENEMY_SEARCH_SPACING = 32.0F;
/*     */   public static final int RAY_COUNT = 20;
/*     */   @Null
/*     */   private Tower d;
/*     */   public ExplosionType type;
/*  36 */   public Vector2 position = new Vector2();
/*     */   public float damage;
/*     */   protected float a;
/*     */   protected float b;
/*     */   protected float c;
/*     */   public Ability fromAbility;
/*     */   private boolean e = false;
/*  43 */   private float f = 0.0F;
/*     */ 
/*     */   
/*     */   public float piercingMultiplier;
/*     */ 
/*     */   
/*  49 */   private float[] g = new float[20];
/*  50 */   private DelayedRemovalArray<Enemy.EnemyReference> h = new DelayedRemovalArray(false, 8, Enemy.EnemyReference.class);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  54 */     super.write(paramKryo, paramOutput);
/*  55 */     paramKryo.writeClassAndObject(paramOutput, this.d);
/*  56 */     paramKryo.writeObjectOrNull(paramOutput, this.type, ExplosionType.class);
/*  57 */     paramKryo.writeObject(paramOutput, this.position);
/*  58 */     paramOutput.writeFloat(this.damage);
/*  59 */     paramOutput.writeFloat(this.a);
/*  60 */     paramOutput.writeFloat(this.b);
/*  61 */     paramOutput.writeFloat(this.c);
/*  62 */     paramKryo.writeClassAndObject(paramOutput, this.fromAbility);
/*  63 */     paramOutput.writeBoolean(this.e);
/*  64 */     paramOutput.writeFloat(this.f);
/*  65 */     paramOutput.writeFloat(this.piercingMultiplier);
/*  66 */     paramKryo.writeObject(paramOutput, this.g);
/*  67 */     paramKryo.writeObject(paramOutput, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  72 */     super.read(paramKryo, paramInput);
/*  73 */     this.d = (Tower)paramKryo.readClassAndObject(paramInput);
/*  74 */     this.type = (ExplosionType)paramKryo.readObjectOrNull(paramInput, ExplosionType.class);
/*  75 */     this.position = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  76 */     this.damage = paramInput.readFloat();
/*  77 */     this.a = paramInput.readFloat();
/*  78 */     this.b = paramInput.readFloat();
/*  79 */     this.c = paramInput.readFloat();
/*  80 */     this.fromAbility = (Ability)paramKryo.readClassAndObject(paramInput);
/*  81 */     this.e = paramInput.readBoolean();
/*  82 */     this.f = paramInput.readFloat();
/*  83 */     this.piercingMultiplier = paramInput.readFloat();
/*  84 */     this.g = (float[])paramKryo.readObject(paramInput, float[].class);
/*  85 */     this.h = (DelayedRemovalArray<Enemy.EnemyReference>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*     */   }
/*     */   
/*     */   protected Explosion(ExplosionType paramExplosionType) {
/*  89 */     this.type = paramExplosionType;
/*     */   }
/*     */   
/*     */   protected final void a(@Null Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Ability paramAbility) {
/*  93 */     this.d = paramTower;
/*  94 */     this.position.set(paramFloat1, paramFloat2);
/*  95 */     this.damage = paramFloat3;
/*  96 */     this.a = paramFloat4;
/*  97 */     this.b = paramFloat4 * 128.0F;
/*  98 */     this.c = paramFloat5;
/*  99 */     this.fromAbility = paramAbility;
/* 100 */     this.piercingMultiplier = 1.0F;
/*     */     
/* 102 */     Arrays.fill(this.g, 1.0F);
/*     */   }
/*     */   @Null
/*     */   public Tower getTower() {
/* 106 */     return this.d;
/*     */   }
/*     */   public Explosion cpy() {
/* 109 */     return null;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 113 */     this.d = null;
/* 114 */     this.f = 0.0F;
/* 115 */     this.e = false;
/* 116 */     this.h.clear();
/* 117 */     this.fromAbility = null;
/*     */   }
/*     */   
/*     */   public void multiplyDamage(float paramFloat) {
/* 121 */     this.damage *= paramFloat;
/*     */   }
/*     */   
/*     */   public void explode() {
/* 125 */     if (this.e) throw new IllegalStateException("Explosion is already triggered");
/*     */     
/* 127 */     this.e = true;
/*     */     
/* 129 */     if (this.b <= 0.0F) {
/* 130 */       this.h.clear(); return;
/*     */     } 
/* 132 */     this.S.map.getEnemiesInCircle(this.position.x, this.position.y, this.b + 32.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           this.h.add(paramEnemyReference);
/*     */           return true;
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static float calculateDamage(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 140 */     return paramFloat1 * (0.2F + paramFloat2 * 0.8F) * paramFloat3;
/*     */   }
/*     */   
/*     */   public static int getRayIndex(Vector2 paramVector21, Vector2 paramVector22) {
/* 144 */     return MathUtils.round(PMath.normalizeAngle(PMath.getAngleBetweenPoints(paramVector21, paramVector22)) / 18.947369F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 151 */     if (!this.e)
/*     */       return; 
/* 153 */     this.f += paramFloat;
/* 154 */     if (this.f > this.c) this.f = this.c;
/*     */     
/* 156 */     if (this.b > 0.0F) {
/*     */       
/* 158 */       float f1 = (paramFloat = this.f / this.c) * this.b * paramFloat * this.b;
/*     */       float f2;
/* 160 */       if ((f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.EXPLOSIONS_PIERCING) * this.piercingMultiplier) > 0.999F) f2 = 0.999F; 
/* 161 */       if (f2 < 0.05F) f2 = 0.05F;
/*     */       
/* 163 */       float f3 = 1.0F - (1.0F - f2) * 0.5F;
/*     */       
/* 165 */       this.h.begin(); byte b; int i;
/* 166 */       for (b = 0, i = this.h.size; b < i; b++) {
/*     */         Enemy enemy;
/* 168 */         if ((enemy = (((Enemy.EnemyReference[])this.h.items)[b]).enemy) != null && this.position.dst2(enemy.getPosition()) < f1) {
/* 169 */           int k = getRayIndex(this.position, enemy.getPosition());
/* 170 */           this.h.removeIndex(b);
/*     */           
/* 172 */           if (this.g[k] > 0.05F) {
/* 173 */             enemyAffected(enemy, 1.0F - paramFloat, this.g[k]);
/*     */           }
/*     */           
/* 176 */           this.g[k] = this.g[k] * f2;
/* 177 */           this.g[(k + 1) % 20] = this.g[(k + 1) % 20] * f3;
/*     */           int j;
/* 179 */           if ((j = k - 1) == -1) {
/* 180 */             j = 19;
/*     */           }
/* 182 */           this.g[j] = this.g[j] * f3;
/*     */         } 
/*     */       } 
/* 185 */       this.h.end();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addExplosionParticle(Color paramColor, LimitedParticleType paramLimitedParticleType) {
/* 190 */     if (this.S._particle != null && Game.i.settingsManager.isExplosionsDrawing()) {
/*     */       
/* 192 */       boolean bool = (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED || !Game.i.settingsManager.isParticlesDrawing()) ? true : false;
/*     */       
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/*     */       
/* 196 */       Array array = (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("explosion.prt").obtain()).getEmitters();
/*     */       
/* 198 */       float f1 = this.b * 2.0F / 128.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 203 */       float f2 = 16.0F + 8.0F * f1;
/* 204 */       float f3 = f1 * 75.0F;
/* 205 */       float f4 = f1 * 300.0F;
/*     */       ParticleEmitter.GradientColorValue gradientColorValue;
/*     */       float[] arrayOfFloat;
/*     */       ParticleEmitter particleEmitter2;
/* 209 */       (arrayOfFloat = (gradientColorValue = (particleEmitter2 = (ParticleEmitter)array.get(1)).getTint()).getColors())[0] = paramColor.r;
/* 210 */       arrayOfFloat[1] = paramColor.g;
/* 211 */       arrayOfFloat[2] = paramColor.b;
/* 212 */       gradientColorValue.setColors(arrayOfFloat);
/*     */       
/* 214 */       particleEmitter2.getXScale().setHigh(f2);
/* 215 */       particleEmitter2.getYScale().setHigh(f2);
/* 216 */       particleEmitter2.getVelocity().setHigh(f3, f4);
/*     */ 
/*     */       
/* 219 */       ParticleEmitter particleEmitter1 = (ParticleEmitter)array.get(2);
/* 220 */       if (bool) {
/* 221 */         particleEmitter1.setMinParticleCount(0);
/*     */       } else {
/* 223 */         particleEmitter1.setMinParticleCount(3);
/* 224 */         particleEmitter1.getXScale().setHigh(120.0F * f1);
/* 225 */         particleEmitter1.getYScale().setHigh(120.0F * f1);
/* 226 */         particleEmitter1.getVelocity().setHigh(15.0F * f1, 90.0F * f1);
/*     */ 
/*     */ 
/*     */         
/* 230 */         (arrayOfFloat = (gradientColorValue = particleEmitter1.getTint()).getColors())[0] = paramColor.r;
/* 231 */         arrayOfFloat[1] = paramColor.g;
/* 232 */         arrayOfFloat[2] = paramColor.b;
/*     */         
/* 234 */         gradientColorValue.setColors(arrayOfFloat);
/*     */       } 
/*     */       
/* 237 */       pooledEffect.setPosition(this.position.x, this.position.y);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       (arrayOfFloat = (gradientColorValue = (particleEmitter1 = (ParticleEmitter)pooledEffect.getEmitters().get(0)).getTint()).getColors())[0] = paramColor.r;
/* 245 */       arrayOfFloat[1] = paramColor.g;
/* 246 */       arrayOfFloat[2] = paramColor.b;
/* 247 */       if (bool) {
/* 248 */         arrayOfFloat[0] = arrayOfFloat[0] * 0.4F;
/* 249 */         arrayOfFloat[1] = arrayOfFloat[1] * 0.4F;
/* 250 */         arrayOfFloat[2] = arrayOfFloat[2] * 0.4F;
/*     */       } 
/* 252 */       gradientColorValue.setColors(arrayOfFloat);
/*     */       
/* 254 */       particleEmitter1.getXScale().setHigh(this.b * 2.0F);
/* 255 */       particleEmitter1.getYScale().setHigh(this.b * 2.0F);
/* 256 */       particleEmitter1.getLife().setHigh(this.c * 1000.0F);
/*     */       
/* 258 */       this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, paramLimitedParticleType, this.position.x, this.position.y);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 263 */     this.S.damage.queueDamage(this.S.damage
/* 264 */         .obtainRecord().setup(paramEnemy, calculateDamage(this.damage, paramFloat1, paramFloat2), DamageType.EXPLOSION)
/* 265 */         .setTower(this.d)
/* 266 */         .setAbility(this.fromAbility));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 271 */     return (this.e && this.f >= this.c);
/*     */   }
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
/*     */   public static abstract class Factory<T extends Explosion>
/*     */     implements Disposable, EntityFactory
/*     */   {
/*     */     public void setup(ExplosionSystem param1ExplosionSystem) {
/* 290 */       if (Game.i.assetManager != null) {
/* 291 */         setupAssets();
/*     */       }
/*     */     }
/*     */     
/*     */     public void setupAssets() {}
/*     */     
/*     */     protected abstract T a();
/*     */     
/*     */     public final T obtain() {
/* 300 */       return a();
/*     */     }
/*     */     
/*     */     public final void free(Explosion param1Explosion) {}
/*     */     
/*     */     public void dispose() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Explosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */