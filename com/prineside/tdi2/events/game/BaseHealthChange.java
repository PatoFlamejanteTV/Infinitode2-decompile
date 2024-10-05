/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class BaseHealthChange extends StoppableEvent {
/*    */   private int a;
/*    */   
/*    */   public BaseHealthChange(int paramInt) {
/* 11 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public final int getOldValue() {
/* 15 */     return this.a;
/*    */   }
/*    */   
/*    */   public final BaseHealthChange setOldValue(int paramInt) {
/* 19 */     this.a = paramInt;
/* 20 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\BaseHealthChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */