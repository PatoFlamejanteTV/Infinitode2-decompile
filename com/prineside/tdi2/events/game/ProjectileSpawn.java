/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Projectile;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ProjectileSpawn
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Projectile a;
/*    */   
/*    */   public ProjectileSpawn(Projectile paramProjectile) {
/* 16 */     setProjectile(paramProjectile);
/*    */   }
/*    */   
/*    */   public final Projectile getProjectile() {
/* 20 */     return this.a;
/*    */   }
/*    */   
/*    */   public final ProjectileSpawn setProjectile(Projectile paramProjectile) {
/* 24 */     Preconditions.checkNotNull(paramProjectile);
/* 25 */     this.a = paramProjectile;
/* 26 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ProjectileSpawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */