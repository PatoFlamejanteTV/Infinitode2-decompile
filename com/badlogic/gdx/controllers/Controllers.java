/*     */ package com.badlogic.gdx.controllers;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Controllers
/*     */ {
/*     */   private static final String TAG = "Controllers";
/*  36 */   static final ObjectMap<Application, ControllerManager> managers = new ObjectMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public static String preferredManager = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Array<Controller> getControllers() {
/*  47 */     initialize();
/*  48 */     return getManager().getControllers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Controller getCurrent() {
/*  56 */     initialize();
/*  57 */     return getManager().getCurrentController();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addListener(ControllerListener paramControllerListener) {
/*  64 */     initialize();
/*  65 */     getManager().addListener(paramControllerListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeListener(ControllerListener paramControllerListener) {
/*  71 */     initialize();
/*  72 */     getManager().removeListener(paramControllerListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearListeners() {
/*  77 */     initialize();
/*  78 */     getManager().clearListeners();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Array<ControllerListener> getListeners() {
/*  83 */     initialize();
/*  84 */     return getManager().getListeners();
/*     */   }
/*     */   
/*     */   private static ControllerManager getManager() {
/*  88 */     return (ControllerManager)managers.get(Gdx.app);
/*     */   }
/*     */   
/*     */   private static void initialize() {
/*  92 */     if (managers.containsKey(Gdx.app))
/*     */       return; 
/*  94 */     String str = null;
/*  95 */     Application.ApplicationType applicationType = Gdx.app.getType();
/*  96 */     ControllerManager controllerManager = null;
/*     */     
/*  98 */     if (preferredManager != null) {
/*  99 */       str = preferredManager;
/* 100 */     } else if (applicationType == Application.ApplicationType.Android) {
/* 101 */       str = "com.badlogic.gdx.controllers.android.AndroidControllers";
/* 102 */     } else if (applicationType == Application.ApplicationType.Desktop) {
/* 103 */       str = "com.badlogic.gdx.controllers.desktop.JamepadControllerManager";
/* 104 */     } else if (applicationType == Application.ApplicationType.WebGL) {
/* 105 */       str = "com.badlogic.gdx.controllers.gwt.GwtControllers";
/* 106 */     } else if (applicationType == Application.ApplicationType.iOS) {
/* 107 */       str = "com.badlogic.gdx.controllers.IosControllerManager";
/*     */     } else {
/* 109 */       Gdx.app.log("Controllers", "No controller manager is available for: " + Gdx.app.getType());
/* 110 */       controllerManager = new ControllerManagerStub();
/*     */     } 
/*     */     
/* 113 */     if (controllerManager == null) {
/*     */       try {
/*     */         Class clazz;
/* 116 */         controllerManager = (ControllerManager)ClassReflection.newInstance(clazz = ClassReflection.forName(str));
/* 117 */       } catch (Throwable throwable) {
/* 118 */         throw new GdxRuntimeException("Error creating controller manager: " + str, throwable);
/*     */       } 
/*     */     }
/*     */     
/* 122 */     managers.put(Gdx.app, controllerManager);
/* 123 */     final Application app = Gdx.app;
/* 124 */     Gdx.app.addLifecycleListener(new LifecycleListener()
/*     */         {
/*     */           public final void resume() {}
/*     */ 
/*     */ 
/*     */           
/*     */           public final void pause() {}
/*     */ 
/*     */ 
/*     */           
/*     */           public final void dispose() {
/* 135 */             Controllers.managers.remove(app);
/* 136 */             Gdx.app.log("Controllers", "removed manager for application, " + Controllers.managers.size + " managers active");
/*     */           }
/*     */         });
/*     */     
/* 140 */     Gdx.app.log("Controllers", "added manager for application, " + managers.size + " managers active");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\Controllers.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */