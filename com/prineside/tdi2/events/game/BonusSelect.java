/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class BonusSelect extends StoppableEvent {
/*    */   private final int a;
/*    */   
/*    */   public BonusSelect(int paramInt) {
/* 11 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public final int getStageNumber() {
/* 15 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\BonusSelect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */