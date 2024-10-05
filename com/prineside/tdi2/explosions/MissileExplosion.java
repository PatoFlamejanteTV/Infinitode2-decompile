/*    */ package com.prineside.tdi2.explosions;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Explosion;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.enums.DamageType;
/*    */ import com.prineside.tdi2.enums.ExplosionType;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.LimitedParticleType;
/*    */ import com.prineside.tdi2.enums.TowerType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class MissileExplosion extends Explosion {
/* 17 */   private static final Color d = MaterialColor.RED.P400;
/*    */   
/*    */   private MissileExplosion() {
/* 20 */     super(ExplosionType.MISSILE);
/*    */   }
/*    */   
/*    */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 24 */     float f = 0.25F + paramFloat4 * 0.08F;
/* 25 */     a(paramTower, paramFloat1, paramFloat2, paramFloat3, paramFloat4, f, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void explode() {
/* 30 */     super.explode();
/*    */ 
/*    */     
/* 33 */     addExplosionParticle(d, LimitedParticleType.EXPLOSION_MISSILE);
/*    */     
/* 35 */     if (this.S._sound != null) {
/* 36 */       this.S._sound.playExplosionSound(this.position.x);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/*    */     Tower tower;
/* 44 */     if ((tower = getTower()) == null || !tower.isRegistered() || !tower.canAttackEnemy(paramEnemy))
/*    */       return; 
/* 46 */     float f = this.damage;
/* 47 */     if (tower.type == TowerType.MISSILE && 
/* 48 */       tower.isAbilityInstalled(3) && (paramEnemy.getHealth() / paramEnemy.maxHealth) > this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_OVERWEIGHT_HP)) {
/*    */       
/* 50 */       double d = this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_OVERWEIGHT_DAMAGE);
/* 51 */       if (tower.isAbilityInstalled(4))
/*    */       {
/* 53 */         d += this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_ULTIMATE_DAMAGE);
/*    */       }
/*    */       
/* 56 */       f = (float)(f * (d + 1.0D));
/*    */     } 
/*    */     
/* 59 */     this.S.damage.queueDamage(this.S.damage
/* 60 */         .obtainRecord().setup(paramEnemy, calculateDamage(f, paramFloat1, paramFloat2), DamageType.EXPLOSION)
/* 61 */         .setTower(tower)
/* 62 */         .setExplosion(this)
/* 63 */         .setAbility(this.fromAbility));
/*    */   }
/*    */   
/*    */   public static class MissileExplosionFactory
/*    */     extends Explosion.Factory<MissileExplosion>
/*    */   {
/*    */     private static MissileExplosion b() {
/* 70 */       return new MissileExplosion((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\explosions\MissileExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */