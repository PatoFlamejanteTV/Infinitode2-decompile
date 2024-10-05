/*    */ package com.prineside.tdi2.explosions;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Explosion;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.enums.DamageType;
/*    */ import com.prineside.tdi2.enums.ExplosionType;
/*    */ import com.prineside.tdi2.enums.LimitedParticleType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class AirFallExplosion extends Explosion {
/* 15 */   private static final Color d = MaterialColor.LIGHT_BLUE.P400;
/*    */   
/*    */   private AirFallExplosion() {
/* 18 */     super(ExplosionType.AIR_FALL);
/*    */   }
/*    */   
/*    */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 22 */     float f = 0.25F + paramFloat4 * 0.08F;
/* 23 */     a(paramTower, paramFloat1, paramFloat2, paramFloat3, paramFloat4, f, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void explode() {
/* 28 */     super.explode();
/*    */ 
/*    */     
/* 31 */     addExplosionParticle(d, LimitedParticleType.EXPLOSION_AIR_FALL);
/*    */     
/* 33 */     if (this.S._sound != null) {
/* 34 */       this.S._sound.playExplosionSound(this.position.x);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 42 */     this.S.damage.queueDamage(this.S.damage
/* 43 */         .obtainRecord().setup(paramEnemy, calculateDamage(this.damage, paramFloat1, paramFloat2), DamageType.EXPLOSION)
/* 44 */         .setTower(getTower())
/* 45 */         .setAbility(this.fromAbility)
/* 46 */         .setIgnoreTowerEfficiency(true)
/* 47 */         .setCleanForDps(false)
/* 48 */         .setExplosion(this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDone() {
/* 54 */     return super.isDone();
/*    */   }
/*    */   
/*    */   public static class AirFallExplosionFactory
/*    */     extends Explosion.Factory<AirFallExplosion> {
/*    */     private static AirFallExplosion b() {
/* 60 */       return new AirFallExplosion((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\explosions\AirFallExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */