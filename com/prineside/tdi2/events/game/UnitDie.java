/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Unit;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class UnitDie extends StoppableEvent {
/*    */   private final Unit a;
/*    */   @Null
/*    */   private final Enemy b;
/*    */   
/*    */   public UnitDie(Unit paramUnit, @Null Enemy paramEnemy) {
/* 17 */     Preconditions.checkNotNull(paramUnit);
/* 18 */     this.a = paramUnit;
/* 19 */     this.b = paramEnemy;
/*    */   }
/*    */   
/*    */   public final Unit getUnit() {
/* 23 */     return this.a;
/*    */   }
/*    */   
/*    */   public final Enemy getKiller() {
/* 27 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\UnitDie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */