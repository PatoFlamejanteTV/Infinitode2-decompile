/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.systems.BonusSystem;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class BonusStageRequirementMet extends StoppableEvent {
/*    */   private final BonusSystem.BonusStage a;
/*    */   
/*    */   public BonusStageRequirementMet(BonusSystem.BonusStage paramBonusStage) {
/* 13 */     Preconditions.checkNotNull(paramBonusStage);
/* 14 */     this.a = paramBonusStage;
/*    */   }
/*    */   
/*    */   public final BonusSystem.BonusStage getStage() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\BonusStageRequirementMet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */