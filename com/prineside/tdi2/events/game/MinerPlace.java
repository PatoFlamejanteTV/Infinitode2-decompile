/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Miner;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MinerPlace extends StoppableEvent {
/*    */   private final Miner a;
/*    */   
/*    */   public MinerPlace(Miner paramMiner) {
/* 13 */     Preconditions.checkNotNull(paramMiner);
/* 14 */     this.a = paramMiner;
/*    */   }
/*    */   
/*    */   public final Miner getMiner() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinerPlace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */