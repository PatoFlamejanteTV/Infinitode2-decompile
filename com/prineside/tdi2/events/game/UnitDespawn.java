/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Unit;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class UnitDespawn extends StoppableEvent {
/*    */   private final Unit a;
/*    */   
/*    */   public UnitDespawn(Unit paramUnit) {
/* 13 */     Preconditions.checkNotNull(paramUnit);
/* 14 */     this.a = paramUnit;
/*    */   }
/*    */   
/*    */   public final Unit getUnit() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\UnitDespawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */