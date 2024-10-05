/*    */ package com.prineside.tdi2.events.global;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ 
/*    */ public final class ScreenResize extends StoppableEvent {
/*    */   private final int a;
/*    */   private final int b;
/*    */   
/*    */   public ScreenResize(int paramInt1, int paramInt2) {
/* 10 */     if (paramInt1 <= 0) {
/* 11 */       paramInt1 = 1;
/*    */     }
/* 13 */     if (paramInt2 <= 0) {
/* 14 */       paramInt2 = 1;
/*    */     }
/* 16 */     this.a = paramInt1;
/* 17 */     this.b = paramInt2;
/*    */   }
/*    */   
/*    */   public final int getWidth() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getHeight() {
/* 25 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\global\ScreenResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */