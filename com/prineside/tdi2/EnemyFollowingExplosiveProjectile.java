/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.enums.ProjectileType;
/*    */ 
/*    */ public abstract class EnemyFollowingExplosiveProjectile
/*    */   extends EnemyFollowingProjectile {
/*    */   private Explosion d;
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 14 */     super.write(paramKryo, paramOutput);
/* 15 */     paramKryo.writeClassAndObject(paramOutput, this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 20 */     super.read(paramKryo, paramInput);
/* 21 */     this.d = (Explosion)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   protected EnemyFollowingExplosiveProjectile(ProjectileType paramProjectileType) {
/* 25 */     super(paramProjectileType);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 30 */     super.reset();
/* 31 */     this.d = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setUnregistered() {
/* 36 */     this.d = null;
/* 37 */     super.setUnregistered();
/*    */   }
/*    */ 
/*    */   
/*    */   public void multiplyDamage(float paramFloat) {
/* 42 */     super.multiplyDamage(paramFloat);
/*    */     
/* 44 */     this.d.multiplyDamage(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public void setup(Vector2 paramVector2, Enemy paramEnemy, float paramFloat) {
/* 50 */     throw new RuntimeException("Use method with Explosion");
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public void setup(Vector2 paramVector2, Enemy paramEnemy, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 56 */     throw new RuntimeException("Use method with Explosion");
/*    */   }
/*    */   
/*    */   protected final void a(Vector2 paramVector2, Enemy paramEnemy, float paramFloat1, float paramFloat2, Explosion paramExplosion, float paramFloat3, float paramFloat4) {
/* 60 */     super.setup(paramVector2, paramEnemy, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */     
/* 62 */     this.d = paramExplosion;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hit() {
/* 67 */     super.hit();
/*    */     
/* 69 */     this.d.position.set(getPosition());
/* 70 */     this.S.explosion.register(this.d);
/* 71 */     this.d.explode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\EnemyFollowingExplosiveProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */