/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class Render extends StoppableEvent {
/*    */   private float a;
/*    */   private float b;
/*    */   private float c;
/*    */   
/*    */   public Render(float paramFloat1, float paramFloat2) {
/* 13 */     setRealDeltaTime(paramFloat1);
/* 14 */     setInGameDeltaTime(paramFloat2);
/*    */   }
/*    */   
/*    */   public final float getRealDeltaTime() {
/* 18 */     return this.a;
/*    */   }
/*    */   
/*    */   public final void setRealDeltaTime(float paramFloat) {
/* 22 */     this.a = paramFloat;
/*    */   }
/*    */   
/*    */   public final float getInGameDeltaTime() {
/* 26 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void setInGameDeltaTime(float paramFloat) {
/* 30 */     this.b = paramFloat;
/*    */   }
/*    */   
/*    */   public final float getInterpolatedTime() {
/* 34 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setInterpolatedTime(float paramFloat) {
/* 38 */     this.c = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\Render.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */