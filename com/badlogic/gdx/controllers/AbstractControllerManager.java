/*    */ package com.badlogic.gdx.controllers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ public abstract class AbstractControllerManager implements ControllerManager {
/*  6 */   protected final Array<Controller> controllers = new Array();
/*    */   
/*    */   private Controller currentController;
/*    */   
/*    */   public Array<Controller> getControllers() {
/* 11 */     return this.controllers;
/*    */   }
/*    */ 
/*    */   
/*    */   public Controller getCurrentController() {
/* 16 */     return this.currentController;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class ManageCurrentControllerListener
/*    */     extends ControllerAdapter
/*    */   {
/*    */     public void connected(Controller param1Controller) {
/* 26 */       if (AbstractControllerManager.this.currentController == null) {
/* 27 */         AbstractControllerManager.this.currentController = param1Controller;
/*    */       }
/*    */     }
/*    */ 
/*    */     
/*    */     public void disconnected(Controller param1Controller) {
/* 33 */       if (AbstractControllerManager.this.currentController == param1Controller) {
/* 34 */         AbstractControllerManager.this.currentController = null;
/*    */       }
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean buttonDown(Controller param1Controller, int param1Int) {
/* 40 */       AbstractControllerManager.this.currentController = param1Controller;
/* 41 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean buttonUp(Controller param1Controller, int param1Int) {
/* 46 */       AbstractControllerManager.this.currentController = param1Controller;
/* 47 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean axisMoved(Controller param1Controller, int param1Int, float param1Float) {
/* 52 */       AbstractControllerManager.this.currentController = param1Controller;
/* 53 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\AbstractControllerManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */