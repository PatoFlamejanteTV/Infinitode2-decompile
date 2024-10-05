/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Miner;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MinerBuild extends StoppableEvent {
/*    */   private final Miner a;
/*    */   private final int b;
/*    */   
/*    */   public MinerBuild(Miner paramMiner, int paramInt) {
/* 14 */     Preconditions.checkNotNull(paramMiner, "miner can not be null");
/* 15 */     Preconditions.checkArgument((paramInt >= 0), "invalid price: %s", paramInt);
/* 16 */     this.a = paramMiner;
/* 17 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final Miner getMiner() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getBuildPrice() {
/* 25 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinerBuild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */