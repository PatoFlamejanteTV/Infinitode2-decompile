/*     */ package com.badlogic.gdx.backends.headless;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.ApplicationListener;
/*     */ import com.badlogic.gdx.ApplicationLogger;
/*     */ import com.badlogic.gdx.Audio;
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.Preferences;
/*     */ import com.badlogic.gdx.backends.headless.mock.audio.MockAudio;
/*     */ import com.badlogic.gdx.backends.headless.mock.graphics.MockGraphics;
/*     */ import com.badlogic.gdx.backends.headless.mock.input.MockInput;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Clipboard;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ public class HeadlessApplication
/*     */   implements Application
/*     */ {
/*     */   protected final ApplicationListener listener;
/*     */   protected Thread mainLoopThread;
/*     */   protected final HeadlessFiles files;
/*     */   protected final HeadlessNet net;
/*     */   protected final MockAudio audio;
/*     */   protected final MockInput input;
/*     */   protected final MockGraphics graphics;
/*     */   protected boolean running = true;
/*  50 */   protected final Array<Runnable> runnables = new Array();
/*  51 */   protected final Array<Runnable> executedRunnables = new Array();
/*  52 */   protected final Array<LifecycleListener> lifecycleListeners = new Array();
/*  53 */   protected int logLevel = 2; protected ApplicationLogger applicationLogger;
/*     */   private String preferencesdir;
/*     */   ObjectMap<String, Preferences> preferences;
/*     */   
/*     */   public HeadlessApplication(ApplicationListener paramApplicationListener) {
/*  58 */     this(paramApplicationListener, null);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initialize() {
/*  89 */     this.mainLoopThread = new Thread("HeadlessApplication")
/*     */       {
/*     */         public void run() {
/*     */           try {
/*  93 */             HeadlessApplication.this.mainLoop(); return;
/*  94 */           } catch (Throwable throwable2) {
/*  95 */             Throwable throwable1; if (throwable1 = null instanceof RuntimeException) {
/*  96 */               throw (RuntimeException)throwable1;
/*     */             }
/*  98 */             throw new GdxRuntimeException(throwable1);
/*     */           } 
/*     */         }
/*     */       };
/* 102 */     this.mainLoopThread.start();
/*     */   }
/*     */   
/*     */   protected void mainLoop() {
/* 106 */     null = this.lifecycleListeners;
/*     */     
/* 108 */     this.listener.create();
/*     */ 
/*     */ 
/*     */     
/* 112 */     long l = TimeUtils.nanoTime() + this.graphics.getTargetRenderInterval();
/* 113 */     if ((float)this.graphics.getTargetRenderInterval() >= 0.0F) {
/* 114 */       while (this.running) {
/* 115 */         long l1 = TimeUtils.nanoTime();
/* 116 */         if (l > l1) {
/*     */           try {
/*     */             long l2;
/* 119 */             Thread.sleep((l2 = l - l1) / 1000000L, (int)(l2 % 1000000L));
/* 120 */           } catch (InterruptedException interruptedException) {}
/*     */           
/* 122 */           l += this.graphics.getTargetRenderInterval();
/*     */         } else {
/* 124 */           l = l1 + this.graphics.getTargetRenderInterval();
/*     */         } 
/* 126 */         executeRunnables();
/* 127 */         this.graphics.incrementFrameId();
/* 128 */         this.listener.render();
/* 129 */         this.graphics.updateTime();
/*     */ 
/*     */         
/* 132 */         if (this.running);
/*     */       } 
/*     */     }
/*     */     
/* 136 */     synchronized (null) {
/* 137 */       for (Array.ArrayIterator<LifecycleListener> arrayIterator = null.iterator(); arrayIterator.hasNext(); ) {
/* 138 */         LifecycleListener lifecycleListener; (lifecycleListener = arrayIterator.next()).pause();
/* 139 */         lifecycleListener.dispose();
/*     */       } 
/*     */     } 
/* 142 */     this.listener.pause();
/* 143 */     this.listener.dispose();
/*     */   }
/*     */   
/*     */   public boolean executeRunnables() {
/* 147 */     synchronized (this.runnables) {
/* 148 */       for (int j = this.runnables.size - 1; j >= 0; j--)
/* 149 */         this.executedRunnables.add(this.runnables.get(j)); 
/* 150 */       this.runnables.clear();
/*     */     } 
/* 152 */     if (this.executedRunnables.size == 0) return false; 
/* 153 */     for (int i = this.executedRunnables.size - 1; i >= 0; i--)
/* 154 */       ((Runnable)this.executedRunnables.removeIndex(i)).run(); 
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationListener getApplicationListener() {
/* 160 */     return this.listener;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics getGraphics() {
/* 165 */     return (Graphics)this.graphics;
/*     */   }
/*     */ 
/*     */   
/*     */   public Audio getAudio() {
/* 170 */     return (Audio)this.audio;
/*     */   }
/*     */ 
/*     */   
/*     */   public Input getInput() {
/* 175 */     return (Input)this.input;
/*     */   }
/*     */ 
/*     */   
/*     */   public Files getFiles() {
/* 180 */     return this.files;
/*     */   }
/*     */ 
/*     */   
/*     */   public Net getNet() {
/* 185 */     return this.net;
/*     */   }
/*     */ 
/*     */   
/*     */   public Application.ApplicationType getType() {
/* 190 */     return Application.ApplicationType.HeadlessDesktop;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 195 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getJavaHeap() {
/* 200 */     return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeHeap() {
/* 205 */     return getJavaHeap();
/*     */   }
/*     */   
/* 208 */   public HeadlessApplication(ApplicationListener paramApplicationListener, HeadlessApplicationConfiguration paramHeadlessApplicationConfiguration) { this.preferences = new ObjectMap(); if (paramHeadlessApplicationConfiguration == null)
/*     */       paramHeadlessApplicationConfiguration = new HeadlessApplicationConfiguration();  HeadlessNativesLoader.load(); setApplicationLogger(new HeadlessApplicationLogger()); this.listener = paramApplicationListener; this.files = new HeadlessFiles(); this.net = new HeadlessNet(paramHeadlessApplicationConfiguration); this.graphics = new MockGraphics(); this.graphics.setForegroundFPS(paramHeadlessApplicationConfiguration.updatesPerSecond); this.audio = new MockAudio(); this.input = new MockInput(); this.preferencesdir = paramHeadlessApplicationConfiguration.preferencesDirectory; Gdx.app = this; Gdx.files = this.files; Gdx.net = this.net; Gdx.audio = (Audio)this.audio;
/*     */     Gdx.graphics = (Graphics)this.graphics;
/*     */     Gdx.input = (Input)this.input;
/* 212 */     initialize(); } public Preferences getPreferences(String paramString) { if (this.preferences.containsKey(paramString)) {
/* 213 */       return (Preferences)this.preferences.get(paramString);
/*     */     }
/* 215 */     HeadlessPreferences headlessPreferences = new HeadlessPreferences(paramString, this.preferencesdir);
/* 216 */     this.preferences.put(paramString, headlessPreferences);
/* 217 */     return headlessPreferences; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Clipboard getClipboard() {
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRunnable(Runnable paramRunnable) {
/* 229 */     synchronized (this.runnables) {
/* 230 */       this.runnables.add(paramRunnable);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void debug(String paramString1, String paramString2) {
/* 236 */     if (this.logLevel >= 3) getApplicationLogger().debug(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 241 */     if (this.logLevel >= 3) getApplicationLogger().debug(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void log(String paramString1, String paramString2) {
/* 246 */     if (this.logLevel >= 2) getApplicationLogger().log(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void log(String paramString1, String paramString2, Throwable paramThrowable) {
/* 251 */     if (this.logLevel >= 2) getApplicationLogger().log(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void error(String paramString1, String paramString2) {
/* 256 */     if (this.logLevel > 0) getApplicationLogger().error(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void error(String paramString1, String paramString2, Throwable paramThrowable) {
/* 261 */     if (this.logLevel > 0) getApplicationLogger().error(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void setLogLevel(int paramInt) {
/* 266 */     this.logLevel = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLogLevel() {
/* 271 */     return this.logLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setApplicationLogger(ApplicationLogger paramApplicationLogger) {
/* 276 */     this.applicationLogger = paramApplicationLogger;
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationLogger getApplicationLogger() {
/* 281 */     return this.applicationLogger;
/*     */   }
/*     */ 
/*     */   
/*     */   public void exit() {
/* 286 */     postRunnable(new Runnable()
/*     */         {
/*     */           public void run() {
/* 289 */             HeadlessApplication.this.running = false;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLifecycleListener(LifecycleListener paramLifecycleListener) {
/* 296 */     synchronized (this.lifecycleListeners) {
/* 297 */       this.lifecycleListeners.add(paramLifecycleListener);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeLifecycleListener(LifecycleListener paramLifecycleListener) {
/* 303 */     synchronized (this.lifecycleListeners) {
/* 304 */       this.lifecycleListeners.removeValue(paramLifecycleListener, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\HeadlessApplication.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */