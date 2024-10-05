/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Wave;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class WaveComplete extends StoppableEvent {
/*    */   private final Wave a;
/*    */   
/*    */   public WaveComplete(Wave paramWave) {
/* 13 */     Preconditions.checkNotNull(paramWave);
/* 14 */     this.a = paramWave;
/*    */   }
/*    */   
/*    */   public final Wave getWave() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\WaveComplete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */