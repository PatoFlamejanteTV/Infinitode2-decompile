/*     */ package com.prineside.tdi2;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.utils.BitVector;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectFilter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public abstract class CollidingProjectile extends Projectile {
/*     */   static {
/*  14 */     TLog.forClass(CollidingProjectile.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final float RAYCAST_INTERVAL_MIN = 32.0F;
/*     */   
/*     */   public static final float RAYCAST_INTERVAL_MIN_SQR = 1024.0F;
/*     */   
/*  22 */   public float flyTime = 0.0F;
/*     */   public float totalFlyTime;
/*  24 */   protected Vector2 a = new Vector2(); private float d;
/*     */   @NAGS
/*  26 */   protected float b = -741.84F;
/*  27 */   private Vector2 e = new Vector2();
/*     */   private float f;
/*  29 */   private BitVector g = new BitVector();
/*     */   @NAGS
/*  31 */   public Vector2 drawPosition = new Vector2();
/*     */   @NAGS
/*  33 */   private final RayCastHandler h = new RayCastHandler((byte)0); @NAGS
/*     */   public float drawAngle;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  37 */     super.write(paramKryo, paramOutput);
/*  38 */     paramOutput.writeFloat(this.flyTime);
/*  39 */     paramOutput.writeFloat(this.totalFlyTime);
/*  40 */     paramKryo.writeObject(paramOutput, this.a);
/*  41 */     paramOutput.writeFloat(this.d);
/*  42 */     paramKryo.writeObject(paramOutput, this.e);
/*  43 */     paramOutput.writeFloat(this.f);
/*  44 */     paramKryo.writeObject(paramOutput, this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  49 */     super.read(paramKryo, paramInput);
/*  50 */     this.flyTime = paramInput.readFloat();
/*  51 */     this.totalFlyTime = paramInput.readFloat();
/*  52 */     this.a = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  53 */     this.d = paramInput.readFloat();
/*  54 */     this.e = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  55 */     this.f = paramInput.readFloat();
/*  56 */     this.g = (BitVector)paramKryo.readObject(paramInput, BitVector.class);
/*     */   }
/*     */   
/*     */   protected CollidingProjectile(ProjectileType paramProjectileType) {
/*  60 */     super(paramProjectileType);
/*     */   }
/*     */   
/*     */   protected final void a(Vector2 paramVector21, float paramFloat, Vector2 paramVector22) {
/*  64 */     float f = paramVector21.dst(paramVector22) / paramFloat / 128.0F;
/*     */     
/*  66 */     (paramVector22 = new Vector2(paramVector22)).sub(paramVector21).nor().scl(paramFloat);
/*  67 */     a(paramVector21, paramVector22, f);
/*     */   }
/*     */   
/*     */   private void a(Vector2 paramVector21, Vector2 paramVector22, float paramFloat) {
/*  71 */     this.f = 0.0F;
/*  72 */     this.position.set(paramVector21);
/*  73 */     this.d = paramVector22.len() * 128.0F;
/*  74 */     this.a.set(paramVector22).nor();
/*  75 */     this.totalFlyTime = paramFloat;
/*     */     
/*  77 */     this.e.set(paramVector21);
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyDrawInterpolation(float paramFloat) {
/*  82 */     if (paramFloat == 0.0F) {
/*  83 */       this.drawPosition.set(this.position);
/*  84 */       this.drawAngle = b(); return;
/*     */     } 
/*  86 */     this.drawPosition.set(this.position);
/*  87 */     this.drawPosition.x += this.a.x * this.d * paramFloat;
/*  88 */     this.drawPosition.y += this.a.y * this.d * paramFloat;
/*  89 */     this.drawAngle = b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void flyOnEnemy(Enemy paramEnemy) {
/*  95 */     this.a.set(paramEnemy.getPosition());
/*  96 */     this.a.sub(this.position).nor();
/*  97 */     this.b = -741.84F;
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
/*     */   protected final float a() {
/*     */     float f;
/* 113 */     if ((f = this.totalFlyTime - this.flyTime) < 0.0F) f = 0.0F;
/*     */     
/* 115 */     return f;
/*     */   }
/*     */   
/*     */   private float b() {
/* 119 */     if (this.b == -741.84F) {
/* 120 */       this.b = this.a.angleDeg() - 90.0F;
/*     */     }
/* 122 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 127 */     return (this.flyTime >= this.totalFlyTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasReachedTarget() {
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 137 */     if (isDone())
/*     */       return; 
/* 139 */     if (this.flyTime + paramFloat >= this.totalFlyTime) {
/*     */       
/* 141 */       paramFloat = this.totalFlyTime - this.flyTime;
/* 142 */       this.flyTime = this.totalFlyTime;
/* 143 */       this.f = 64.0F;
/* 144 */       a(paramFloat);
/*     */       return;
/*     */     } 
/* 147 */     this.flyTime += paramFloat;
/* 148 */     a(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(float paramFloat) {
/* 153 */     this.position.x += this.a.x * this.d * paramFloat;
/* 154 */     this.position.y += this.a.y * this.d * paramFloat;
/* 155 */     paramFloat *= this.d;
/* 156 */     this.f += paramFloat;
/*     */     
/* 158 */     if (this.f > 32.0F) {
/* 159 */       this.f = 0.0F;
/*     */       
/* 161 */       this.S.map.rayCastEnemiesSorted(this.e.x, this.e.y, this.position.x, this.position.y, 1.0F, this.h);
/*     */       
/* 163 */       this.e.set(this.position);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 171 */     this.f = 0.0F;
/* 172 */     this.flyTime = 0.0F;
/* 173 */     this.totalFlyTime = 0.0F;
/* 174 */     this.drawAngle = 0.0F;
/* 175 */     this.a.setZero();
/* 176 */     this.b = -741.84F;
/* 177 */     this.e.setZero();
/* 178 */     this.drawPosition.setZero();
/* 179 */     this.g.clear();
/*     */     
/* 181 */     super.reset();
/*     */   }
/*     */   
/*     */   protected abstract void a(Enemy paramEnemy);
/*     */   
/*     */   private final class RayCastHandler implements ObjectFilter<Enemy.EnemyReference> { public final boolean test(Enemy.EnemyReference param1EnemyReference) {
/* 187 */       if (this.a.isDone()) {
/* 188 */         return false;
/*     */       }
/*     */       
/*     */       Enemy enemy;
/* 192 */       if ((enemy = param1EnemyReference.enemy) != null && !CollidingProjectile.a(this.a).get(enemy.id)) {
/* 193 */         CollidingProjectile.a(this.a).set(enemy.id);
/* 194 */         this.a.a(enemy);
/*     */       } 
/* 196 */       return true;
/*     */     }
/*     */     
/*     */     private RayCastHandler(CollidingProjectile this$0) {} }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\CollidingProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */