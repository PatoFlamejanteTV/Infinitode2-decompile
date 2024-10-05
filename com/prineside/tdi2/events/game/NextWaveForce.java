/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class NextWaveForce extends StoppableEvent {
/*    */   private final int a;
/*    */   private final int b;
/*    */   private final float c;
/*    */   
/*    */   public NextWaveForce(int paramInt1, int paramInt2, float paramFloat) {
/* 13 */     this.a = paramInt1;
/* 14 */     this.b = paramInt2;
/* 15 */     this.c = paramFloat;
/*    */   }
/*    */   
/*    */   public final int getBonusMoney() {
/* 19 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getBonusScore() {
/* 23 */     return this.b;
/*    */   }
/*    */   
/*    */   public final float getTime() {
/* 27 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\NextWaveForce.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */