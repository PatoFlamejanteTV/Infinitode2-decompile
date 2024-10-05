/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MouseMove extends StoppableEvent {
/*    */   private final float a;
/*    */   private final float b;
/*    */   private final int c;
/*    */   
/*    */   public MouseMove(float paramFloat1, float paramFloat2, int paramInt) {
/* 13 */     this.a = paramFloat1;
/* 14 */     this.b = paramFloat2;
/* 15 */     this.c = paramInt;
/*    */   }
/*    */   
/*    */   public final float getMapX() {
/* 19 */     return this.a;
/*    */   }
/*    */   
/*    */   public final float getMapY() {
/* 23 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getPointer() {
/* 30 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MouseMove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */