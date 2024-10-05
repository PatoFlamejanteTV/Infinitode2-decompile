/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddListenerAction
/*    */   extends Action
/*    */ {
/*    */   private EventListener listener;
/*    */   private boolean capture;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 29 */     if (this.capture) {
/* 30 */       this.target.addCaptureListener(this.listener);
/*    */     } else {
/* 32 */       this.target.addListener(this.listener);
/* 33 */     }  return true;
/*    */   }
/*    */   
/*    */   public EventListener getListener() {
/* 37 */     return this.listener;
/*    */   }
/*    */   
/*    */   public void setListener(EventListener paramEventListener) {
/* 41 */     this.listener = paramEventListener;
/*    */   }
/*    */   
/*    */   public boolean getCapture() {
/* 45 */     return this.capture;
/*    */   }
/*    */   
/*    */   public void setCapture(boolean paramBoolean) {
/* 49 */     this.capture = paramBoolean;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 53 */     super.reset();
/* 54 */     this.listener = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\AddListenerAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */