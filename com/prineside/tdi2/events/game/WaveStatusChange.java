/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.systems.WaveSystem;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class WaveStatusChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   public WaveStatusChange(@Null WaveSystem.Status paramStatus) {
/* 13 */     this.a = paramStatus;
/*    */   } @Null
/*    */   private final WaveSystem.Status a; @Null
/*    */   public final WaveSystem.Status getOldStatus() {
/* 17 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\WaveStatusChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */