/*    */ package com.prineside.tdi2.events;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public abstract class SignalEvent
/*    */   implements Event
/*    */ {
/*    */   public final boolean isStopped() {
/* 12 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void stop() {
/* 17 */     throw new IllegalStateException("This event can not be stopped");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\SignalEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */