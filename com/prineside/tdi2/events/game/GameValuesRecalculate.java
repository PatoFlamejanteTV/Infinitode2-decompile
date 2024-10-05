/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class GameValuesRecalculate extends StoppableEvent {
/*    */   private final double[] a;
/*    */   
/*    */   public GameValuesRecalculate(double[] paramArrayOfdouble) {
/* 12 */     Preconditions.checkNotNull(paramArrayOfdouble);
/* 13 */     this.a = paramArrayOfdouble;
/*    */   }
/*    */   
/*    */   public final double[] getOldValues() {
/* 17 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\GameValuesRecalculate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */