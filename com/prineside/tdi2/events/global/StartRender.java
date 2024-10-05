/*    */ package com.prineside.tdi2.events.global;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ 
/*    */ public final class StartRender extends StoppableEvent {
/*    */   private float a;
/*    */   
/*    */   public final StartRender setDeltaTime(float paramFloat) {
/* 10 */     if (!PMath.isFinite(paramFloat) || paramFloat < 0.0F) {
/* 11 */       paramFloat = 0.0F;
/*    */     }
/* 13 */     this.a = paramFloat;
/* 14 */     return this;
/*    */   }
/*    */   
/*    */   public final float getDeltaTime() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\global\StartRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */