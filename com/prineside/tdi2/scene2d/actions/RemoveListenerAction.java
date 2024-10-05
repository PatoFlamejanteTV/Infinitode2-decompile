/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
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
/*    */ public class RemoveListenerAction
/*    */   extends Action
/*    */ {
/*    */   private EventListener c;
/*    */   private boolean d;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 29 */     if (this.d) {
/* 30 */       this.b.removeCaptureListener(this.c);
/*    */     } else {
/* 32 */       this.b.removeListener(this.c);
/* 33 */     }  return true;
/*    */   }
/*    */   
/*    */   public EventListener getListener() {
/* 37 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setListener(EventListener paramEventListener) {
/* 41 */     this.c = paramEventListener;
/*    */   }
/*    */   
/*    */   public boolean getCapture() {
/* 45 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setCapture(boolean paramBoolean) {
/* 49 */     this.d = paramBoolean;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 53 */     super.reset();
/* 54 */     this.c = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RemoveListenerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */