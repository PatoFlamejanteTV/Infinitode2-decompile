/*    */ package com.badlogic.gdx.controllers.desktop.support;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.controllers.ControllerListener;
/*    */ import com.badlogic.gdx.controllers.desktop.JamepadControllerManager;
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ import com.badlogic.gdx.utils.IntMap;
/*    */ import com.studiohartman.jamepad.ControllerIndex;
/*    */ import com.studiohartman.jamepad.ControllerManager;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class JamepadControllerMonitor implements Runnable {
/*    */   private final ControllerManager controllerManager;
/* 14 */   private final IntMap<Tuple> indexToController = new IntMap();
/*    */   private final ControllerListener listener;
/* 16 */   private final IntArray disconnectedControllers = new IntArray();
/*    */   
/*    */   public JamepadControllerMonitor(ControllerManager paramControllerManager, ControllerListener paramControllerListener) {
/* 19 */     this.controllerManager = paramControllerManager;
/* 20 */     this.listener = paramControllerListener;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 25 */     this.controllerManager.c();
/*    */     
/* 27 */     checkForNewControllers();
/* 28 */     update();
/*    */     
/* 30 */     Gdx.app.postRunnable(this);
/*    */   }
/*    */   
/*    */   private void checkForNewControllers() {
/* 34 */     int i = JamepadControllerManager.jamepadConfiguration.a;
/* 35 */     for (byte b = 0; b < i; b++) { try {
/* 36 */         ControllerIndex controllerIndex = this.controllerManager.a(b);
/*    */         
/* 38 */         if (!this.indexToController.containsKey(controllerIndex.d()) && controllerIndex.c()) {
/*    */           Tuple tuple;
/* 40 */           (tuple = new Tuple(controllerIndex)).controller.addListener(this.listener);
/*    */           
/* 42 */           this.indexToController.put(controllerIndex.d(), tuple);
/* 43 */           this.listener.connected(tuple.controller);
/*    */         } 
/* 45 */       } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {} }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   private void update() {
/* 51 */     this.disconnectedControllers.clear();
/* 52 */     for (Iterator<Tuple> iterator = this.indexToController.values().iterator(); iterator.hasNext();) {
/*    */ 
/*    */ 
/*    */       
/* 56 */       if (!(bool = (jamepadController = (tuple = iterator.next()).controller).update())) {
/* 57 */         this.disconnectedControllers.add(tuple.index.d());
/*    */       }
/*    */     } 
/*    */     
/* 61 */     for (byte b = 0; b < this.disconnectedControllers.size; b++)
/* 62 */       this.indexToController.remove(this.disconnectedControllers.get(b)); 
/*    */   }
/*    */   
/*    */   private class Tuple
/*    */   {
/*    */     public final ControllerIndex index;
/*    */     public final JamepadController controller;
/*    */     
/*    */     public Tuple(ControllerIndex param1ControllerIndex) {
/* 71 */       this.index = param1ControllerIndex;
/* 72 */       this.controller = new JamepadController(param1ControllerIndex);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\support\JamepadControllerMonitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */