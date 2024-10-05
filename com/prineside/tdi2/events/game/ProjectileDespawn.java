/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Projectile;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ProjectileDespawn extends StoppableEvent {
/*    */   private final Projectile a;
/*    */   
/*    */   public ProjectileDespawn(Projectile paramProjectile) {
/* 13 */     Preconditions.checkNotNull(paramProjectile);
/* 14 */     this.a = paramProjectile;
/*    */   }
/*    */   
/*    */   public final Projectile getProjectile() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ProjectileDespawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */