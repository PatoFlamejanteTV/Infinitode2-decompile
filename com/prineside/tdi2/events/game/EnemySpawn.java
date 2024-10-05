/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemySpawn
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Enemy a;
/*    */   
/*    */   public EnemySpawn(Enemy paramEnemy) {
/* 19 */     setEnemy(paramEnemy);
/*    */   }
/*    */   
/*    */   public final Enemy getEnemy() {
/* 23 */     return this.a;
/*    */   }
/*    */   
/*    */   public final EnemySpawn setEnemy(Enemy paramEnemy) {
/* 27 */     Preconditions.checkNotNull(paramEnemy);
/* 28 */     this.a = paramEnemy;
/* 29 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemySpawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */