/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Ability;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class AbilityStart extends StoppableEvent {
/*    */   private final Ability a;
/*    */   
/*    */   public AbilityStart(Ability paramAbility) {
/* 13 */     Preconditions.checkNotNull(paramAbility);
/* 14 */     this.a = paramAbility;
/*    */   }
/*    */   
/*    */   public final Ability getAbility() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\AbilityStart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */