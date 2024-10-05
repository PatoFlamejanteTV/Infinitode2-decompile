/*    */ package com.prineside.tdi2.events;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public abstract class StoppableEvent
/*    */   implements Event
/*    */ {
/*    */   private boolean a;
/*    */   
/*    */   public final boolean isStopped() {
/* 14 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void stop() {
/* 19 */     this.a = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\StoppableEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */