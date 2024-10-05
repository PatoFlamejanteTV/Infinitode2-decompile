/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Wave;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class WaveStart
/*    */   extends StoppableEvent
/*    */ {
/*    */   private final Wave a;
/*    */   
/*    */   public WaveStart(Wave paramWave) {
/* 17 */     Preconditions.checkNotNull(paramWave, "wave can not be null");
/* 18 */     this.a = paramWave;
/*    */   }
/*    */   
/*    */   public final Wave getWave() {
/* 22 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\WaveStart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */