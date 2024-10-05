/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MdpsUpdate extends StoppableEvent {
/*    */   private final double a;
/*    */   
/*    */   public MdpsUpdate(double paramDouble) {
/* 11 */     this.a = paramDouble;
/*    */   }
/*    */   
/*    */   public final double getOldValue() {
/* 15 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MdpsUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */