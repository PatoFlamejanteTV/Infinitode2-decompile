/*    */ package com.badlogic.gdx.controllers.desktop.support;
/*    */ 
/*    */ import com.badlogic.gdx.controllers.Controller;
/*    */ import com.badlogic.gdx.controllers.ControllerListener;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class CompositeControllerListener implements ControllerListener {
/*  9 */   private final LinkedList<ControllerListener> listeners = new LinkedList<>();
/*    */ 
/*    */   
/*    */   public void connected(Controller paramController) {
/* 13 */     for (Iterator<ControllerListener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 14 */       (controllerListener = iterator.next()).connected(paramController);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void disconnected(Controller paramController) {
/* 20 */     for (Iterator<ControllerListener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 21 */       (controllerListener = iterator.next()).disconnected(paramController);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean buttonDown(Controller paramController, int paramInt) {
/* 27 */     for (Iterator<ControllerListener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 28 */       if ((controllerListener = iterator.next()).buttonDown(paramController, paramInt)) {
/* 29 */         return true;
/*    */       }
/*    */     } 
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean buttonUp(Controller paramController, int paramInt) {
/* 37 */     for (Iterator<ControllerListener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 38 */       if ((controllerListener = iterator.next()).buttonUp(paramController, paramInt)) {
/* 39 */         return true;
/*    */       }
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean axisMoved(Controller paramController, int paramInt, float paramFloat) {
/* 47 */     for (Iterator<ControllerListener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 48 */       if ((controllerListener = iterator.next()).axisMoved(paramController, paramInt, paramFloat)) {
/* 49 */         return true;
/*    */       }
/*    */     } 
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public void addListener(ControllerListener paramControllerListener) {
/* 56 */     this.listeners.add(paramControllerListener);
/*    */   }
/*    */   
/*    */   public void removeListener(ControllerListener paramControllerListener) {
/* 60 */     this.listeners.remove(paramControllerListener);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 64 */     this.listeners.clear();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\support\CompositeControllerListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */