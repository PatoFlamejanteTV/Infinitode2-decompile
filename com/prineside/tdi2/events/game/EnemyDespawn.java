/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemyDespawn extends StoppableEvent {
/*    */   private Enemy a;
/*    */   
/*    */   public EnemyDespawn(Enemy paramEnemy) {
/* 13 */     setEnemy(paramEnemy);
/*    */   }
/*    */   
/*    */   public final Enemy getEnemy() {
/* 17 */     return this.a;
/*    */   }
/*    */   
/*    */   public final EnemyDespawn setEnemy(Enemy paramEnemy) {
/* 21 */     Preconditions.checkNotNull(paramEnemy);
/* 22 */     this.a = paramEnemy;
/* 23 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemyDespawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */