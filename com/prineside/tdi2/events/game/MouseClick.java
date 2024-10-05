/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MouseClick extends StoppableEvent {
/*    */   private final float a;
/*    */   private final float b;
/*    */   private final int c;
/*    */   private final int d;
/*    */   
/*    */   public MouseClick(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/* 14 */     this.a = paramFloat1;
/* 15 */     this.b = paramFloat2;
/* 16 */     this.c = paramInt1;
/* 17 */     this.d = paramInt2;
/*    */   }
/*    */   
/*    */   public final float getMapX() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final float getMapY() {
/* 25 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getPointer() {
/* 32 */     return this.c;
/*    */   }
/*    */   
/*    */   public final int getButton() {
/* 36 */     return this.d;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MouseClick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */