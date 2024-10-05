/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class RemoveBuffFromEnemy
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Enemy a;
/*    */   private Buff b;
/*    */   
/*    */   public RemoveBuffFromEnemy(Enemy paramEnemy, Buff paramBuff) {
/* 18 */     Preconditions.checkNotNull(paramEnemy);
/* 19 */     Preconditions.checkNotNull(paramBuff);
/* 20 */     this.a = paramEnemy;
/* 21 */     this.b = paramBuff;
/*    */   }
/*    */   
/*    */   public final Enemy getEnemy() {
/* 25 */     return this.a;
/*    */   }
/*    */   
/*    */   public final Buff getBuff() {
/* 29 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\RemoveBuffFromEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */