/*     */ package com.badlogic.gdx.controllers.desktop;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.controllers.AbstractControllerManager;
/*     */ import com.badlogic.gdx.controllers.Controller;
/*     */ import com.badlogic.gdx.controllers.ControllerListener;
/*     */ import com.badlogic.gdx.controllers.desktop.support.CompositeControllerListener;
/*     */ import com.badlogic.gdx.controllers.desktop.support.JamepadControllerMonitor;
/*     */ import com.badlogic.gdx.controllers.desktop.support.JamepadShutdownHook;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.studiohartman.jamepad.ControllerManager;
/*     */ import com.studiohartman.jamepad.a;
/*     */ 
/*     */ public class JamepadControllerManager
/*     */   extends AbstractControllerManager
/*     */   implements Disposable {
/*     */   public static a jamepadConfiguration;
/*     */   private static boolean nativeLibInitialized = false;
/*     */   private static ControllerManager controllerManager;
/*  22 */   private final CompositeControllerListener compositeListener = new CompositeControllerListener();
/*     */   
/*     */   public JamepadControllerManager() {
/*  25 */     this.compositeListener.addListener((ControllerListener)new ManageControllers());
/*     */     
/*  27 */     if (!nativeLibInitialized) {
/*  28 */       if (jamepadConfiguration == null) {
/*  29 */         jamepadConfiguration = new a();
/*     */       }
/*     */ 
/*     */       
/*  33 */       (controllerManager = new ControllerManager(jamepadConfiguration)).a();
/*     */       
/*     */       JamepadControllerMonitor jamepadControllerMonitor;
/*  36 */       (jamepadControllerMonitor = new JamepadControllerMonitor(controllerManager, (ControllerListener)this.compositeListener)).run();
/*     */       
/*  38 */       Gdx.app.addLifecycleListener((LifecycleListener)new JamepadShutdownHook(controllerManager));
/*  39 */       Gdx.app.postRunnable((Runnable)jamepadControllerMonitor);
/*     */       
/*  41 */       nativeLibInitialized = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addListener(ControllerListener paramControllerListener) {
/*  47 */     this.compositeListener.addListener(paramControllerListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeListener(ControllerListener paramControllerListener) {
/*  52 */     this.compositeListener.removeListener(paramControllerListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<ControllerListener> getListeners() {
/*     */     Array<ControllerListener> array;
/*  58 */     (array = new Array()).add(this.compositeListener);
/*  59 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearListeners() {
/*  64 */     this.compositeListener.clear();
/*  65 */     this.compositeListener.addListener((ControllerListener)new ManageControllers());
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  70 */     controllerManager.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addMappingsFromFile(String paramString) {
/*  77 */     controllerManager.a(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void logLastNativeGamepadError() {
/*  86 */     Gdx.app.error("Jamepad", controllerManager.getLastNativeError());
/*     */   }
/*     */   private class ManageControllers extends AbstractControllerManager.ManageCurrentControllerListener { private ManageControllers() {
/*  89 */       super(JamepadControllerManager.this);
/*     */     }
/*     */     public void connected(Controller param1Controller) {
/*  92 */       synchronized (JamepadControllerManager.this.controllers) {
/*  93 */         JamepadControllerManager.this.controllers.add(param1Controller);
/*     */       } 
/*  95 */       super.connected(param1Controller);
/*     */     }
/*     */ 
/*     */     
/*     */     public void disconnected(Controller param1Controller) {
/* 100 */       synchronized (JamepadControllerManager.this.controllers) {
/* 101 */         JamepadControllerManager.this.controllers.removeValue(param1Controller, true);
/*     */       } 
/* 103 */       super.disconnected(param1Controller);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\JamepadControllerManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */