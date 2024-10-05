/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Miner;
/*    */ import com.prineside.tdi2.enums.ResourceType;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MinerResourceChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Miner a;
/*    */   private ResourceType b;
/*    */   private int c;
/*    */   private boolean d;
/*    */   private boolean e;
/*    */   
/*    */   public MinerResourceChange(Miner paramMiner, ResourceType paramResourceType, int paramInt, boolean paramBoolean) {
/* 23 */     setMiner(paramMiner);
/* 24 */     setResourceType(paramResourceType);
/* 25 */     setDelta(paramInt);
/* 26 */     this.d = paramBoolean;
/* 27 */     this.e = false;
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/* 31 */     return this.e;
/*    */   }
/*    */   
/*    */   public final void setCancelled(boolean paramBoolean) {
/* 35 */     this.e = paramBoolean;
/*    */   }
/*    */   
/*    */   public final Miner getMiner() {
/* 39 */     return this.a;
/*    */   }
/*    */   
/*    */   public final MinerResourceChange setMiner(Miner paramMiner) {
/* 43 */     Preconditions.checkNotNull(paramMiner, "miner can not be null");
/* 44 */     this.a = paramMiner;
/* 45 */     return this;
/*    */   }
/*    */   
/*    */   public final ResourceType getResourceType() {
/* 49 */     return this.b;
/*    */   }
/*    */   
/*    */   public final MinerResourceChange setResourceType(ResourceType paramResourceType) {
/* 53 */     Preconditions.checkNotNull(paramResourceType, "resourceType can not be null");
/* 54 */     this.b = paramResourceType;
/* 55 */     return this;
/*    */   }
/*    */   
/*    */   public final int getDelta() {
/* 59 */     return this.c;
/*    */   }
/*    */   
/*    */   public final MinerResourceChange setDelta(int paramInt) {
/* 63 */     Preconditions.checkArgument((paramInt != 0), "delta can not be 0");
/* 64 */     this.c = paramInt;
/* 65 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isMined() {
/* 69 */     return this.d;
/*    */   }
/*    */   
/*    */   public final MinerResourceChange setMined(boolean paramBoolean) {
/* 73 */     this.d = paramBoolean;
/* 74 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinerResourceChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */