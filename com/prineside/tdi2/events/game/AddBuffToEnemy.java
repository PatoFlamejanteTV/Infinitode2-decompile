/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class AddBuffToEnemy
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Enemy a;
/*    */   private Buff b;
/*    */   private boolean c;
/*    */   
/*    */   public final AddBuffToEnemy setup(Enemy paramEnemy, Buff paramBuff) {
/* 21 */     setEnemy(paramEnemy);
/* 22 */     setBuff(paramBuff);
/* 23 */     this.c = false;
/* 24 */     return this;
/*    */   }
/*    */   
/*    */   public final AddBuffToEnemy reset() {
/* 28 */     this.a = null;
/* 29 */     this.b = null;
/* 30 */     this.c = false;
/* 31 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/* 35 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setCancelled(boolean paramBoolean) {
/* 39 */     this.c = paramBoolean;
/*    */   }
/*    */   
/*    */   public final Enemy getEnemy() {
/* 43 */     return this.a;
/*    */   }
/*    */   
/*    */   public final AddBuffToEnemy setEnemy(Enemy paramEnemy) {
/* 47 */     Preconditions.checkNotNull(paramEnemy, "Enemy can not be null");
/* 48 */     this.a = paramEnemy;
/* 49 */     return this;
/*    */   }
/*    */   
/*    */   public final Buff getBuff() {
/* 53 */     return this.b;
/*    */   }
/*    */   
/*    */   public final AddBuffToEnemy setBuff(Buff paramBuff) {
/* 57 */     Preconditions.checkNotNull(paramBuff, "buff can not be null");
/* 58 */     this.b = paramBuff;
/* 59 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\AddBuffToEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */