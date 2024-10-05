/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class CoinsChange extends StoppableEvent {
/*    */   private int a;
/*    */   private boolean b;
/*    */   
/*    */   public CoinsChange(int paramInt, boolean paramBoolean) {
/* 12 */     setOldValue(paramInt);
/* 13 */     setGained(paramBoolean);
/*    */   }
/*    */   
/*    */   public final int getOldValue() {
/* 17 */     return this.a;
/*    */   }
/*    */   
/*    */   public final CoinsChange setOldValue(int paramInt) {
/* 21 */     this.a = paramInt;
/* 22 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isGained() {
/* 26 */     return this.b;
/*    */   }
/*    */   
/*    */   public final CoinsChange setGained(boolean paramBoolean) {
/* 30 */     this.b = paramBoolean;
/* 31 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\CoinsChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */