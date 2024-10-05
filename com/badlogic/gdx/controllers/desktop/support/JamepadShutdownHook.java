/*    */ package com.badlogic.gdx.controllers.desktop.support;
/*    */ 
/*    */ import com.badlogic.gdx.LifecycleListener;
/*    */ import com.studiohartman.jamepad.ControllerManager;
/*    */ 
/*    */ public class JamepadShutdownHook implements LifecycleListener {
/*    */   private final ControllerManager controllerManager;
/*    */   
/*    */   public JamepadShutdownHook(ControllerManager paramControllerManager) {
/* 10 */     this.controllerManager = paramControllerManager;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void pause() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void resume() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 25 */     this.controllerManager.b();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\support\JamepadShutdownHook.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */