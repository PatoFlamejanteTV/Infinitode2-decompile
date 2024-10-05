/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Miner;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.tiles.SourceTile;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MinerRemove extends StoppableEvent {
/*    */   private final Miner a;
/*    */   private final SourceTile b;
/*    */   
/*    */   public MinerRemove(Miner paramMiner, SourceTile paramSourceTile) {
/* 15 */     Preconditions.checkNotNull(paramMiner, "miner can not be null");
/* 16 */     Preconditions.checkNotNull(paramSourceTile, "oldTile can not be null");
/* 17 */     this.a = paramMiner;
/* 18 */     this.b = paramSourceTile;
/*    */   }
/*    */   
/*    */   public final Miner getMiner() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final SourceTile getOldTile() {
/* 26 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinerRemove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */