/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.ApplicationListener;
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWDropCallback;
/*     */ import org.lwjgl.glfw.GLFWDropCallbackI;
/*     */ import org.lwjgl.glfw.GLFWImage;
/*     */ import org.lwjgl.glfw.GLFWWindowCloseCallback;
/*     */ import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
/*     */ import org.lwjgl.glfw.GLFWWindowFocusCallback;
/*     */ import org.lwjgl.glfw.GLFWWindowFocusCallbackI;
/*     */ import org.lwjgl.glfw.GLFWWindowIconifyCallback;
/*     */ import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
/*     */ import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
/*     */ import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
/*     */ import org.lwjgl.glfw.GLFWWindowRefreshCallback;
/*     */ import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
/*     */ import org.lwjgl.system.Struct;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Lwjgl3Window
/*     */   implements Disposable
/*     */ {
/*     */   private long windowHandle;
/*     */   final ApplicationListener listener;
/*     */   private final Array<LifecycleListener> lifecycleListeners;
/*     */   final Lwjgl3ApplicationBase application;
/*     */   private boolean listenerInitialized = false;
/*     */   Lwjgl3WindowListener windowListener;
/*     */   private Lwjgl3Graphics graphics;
/*     */   private Lwjgl3Input input;
/*     */   private final Lwjgl3ApplicationConfiguration config;
/*  47 */   private final Array<Runnable> runnables = new Array();
/*  48 */   private final Array<Runnable> executedRunnables = new Array();
/*     */   private final IntBuffer tmpBuffer;
/*     */   private final IntBuffer tmpBuffer2;
/*     */   boolean iconified = false;
/*     */   boolean focused = false;
/*     */   private boolean requestRendering = false;
/*     */   
/*  55 */   private final GLFWWindowFocusCallback focusCallback = new GLFWWindowFocusCallback()
/*     */     {
/*     */       public void invoke(long param1Long, final boolean focused) {
/*  58 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/*  61 */                 if (Lwjgl3Window.this.windowListener != null) {
/*  62 */                   if (focused) {
/*  63 */                     if (Lwjgl3Window.this.config.pauseWhenLostFocus) {
/*  64 */                       synchronized (Lwjgl3Window.this.lifecycleListeners) {
/*  65 */                         for (Array.ArrayIterator<LifecycleListener> arrayIterator = Lwjgl3Window.this.lifecycleListeners.iterator(); arrayIterator.hasNext();) {
/*  66 */                           (lifecycleListener = arrayIterator.next()).resume();
/*     */                         }
/*     */                       } 
/*     */                     }
/*  70 */                     Lwjgl3Window.this.windowListener.focusGained();
/*     */                   } else {
/*  72 */                     Lwjgl3Window.this.windowListener.focusLost();
/*  73 */                     if (Lwjgl3Window.this.config.pauseWhenLostFocus) {
/*  74 */                       synchronized (Lwjgl3Window.this.lifecycleListeners) {
/*  75 */                         for (Array.ArrayIterator<LifecycleListener> arrayIterator = Lwjgl3Window.this.lifecycleListeners.iterator(); arrayIterator.hasNext();) {
/*  76 */                           (lifecycleListener = arrayIterator.next()).pause();
/*     */                         }
/*     */                       } 
/*  79 */                       Lwjgl3Window.this.listener.pause();
/*     */                     } 
/*     */                   } 
/*  82 */                   Lwjgl3Window.this.focused = focused;
/*     */                 } 
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */   
/*  89 */   private final GLFWWindowIconifyCallback iconifyCallback = new GLFWWindowIconifyCallback()
/*     */     {
/*     */       public void invoke(long param1Long, final boolean iconified) {
/*  92 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/*  95 */                 if (Lwjgl3Window.this.windowListener != null) {
/*  96 */                   Lwjgl3Window.this.windowListener.iconified(iconified);
/*     */                 }
/*  98 */                 Lwjgl3Window.this.iconified = iconified;
/*  99 */                 if (iconified) {
/* 100 */                   if (Lwjgl3Window.this.config.pauseWhenMinimized) {
/* 101 */                     synchronized (Lwjgl3Window.this.lifecycleListeners) {
/* 102 */                       for (Array.ArrayIterator<LifecycleListener> arrayIterator = Lwjgl3Window.this.lifecycleListeners.iterator(); arrayIterator.hasNext();) {
/* 103 */                         (lifecycleListener = arrayIterator.next()).pause();
/*     */                       }
/*     */                     } 
/* 106 */                     Lwjgl3Window.this.listener.pause();
/*     */                     return;
/*     */                   } 
/* 109 */                 } else if (Lwjgl3Window.this.config.pauseWhenMinimized) {
/* 110 */                   synchronized (Lwjgl3Window.this.lifecycleListeners) {
/* 111 */                     for (Array.ArrayIterator<LifecycleListener> arrayIterator = Lwjgl3Window.this.lifecycleListeners.iterator(); arrayIterator.hasNext();) {
/* 112 */                       (lifecycleListener = arrayIterator.next()).resume();
/*     */                     }
/*     */                   } 
/* 115 */                   Lwjgl3Window.this.listener.resume();
/*     */                 } 
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 123 */   private final GLFWWindowMaximizeCallback maximizeCallback = new GLFWWindowMaximizeCallback()
/*     */     {
/*     */       public void invoke(long param1Long, final boolean maximized) {
/* 126 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/* 129 */                 if (Lwjgl3Window.this.windowListener != null) {
/* 130 */                   Lwjgl3Window.this.windowListener.maximized(maximized);
/*     */                 }
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 138 */   private final GLFWWindowCloseCallback closeCallback = new GLFWWindowCloseCallback()
/*     */     {
/*     */       public void invoke(final long windowHandle) {
/* 141 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/* 144 */                 if (Lwjgl3Window.this.windowListener != null && 
/* 145 */                   !Lwjgl3Window.this.windowListener.closeRequested()) {
/* 146 */                   GLFW.glfwSetWindowShouldClose(windowHandle, false);
/*     */                 }
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 154 */   private final GLFWDropCallback dropCallback = new GLFWDropCallback()
/*     */     {
/*     */       public void invoke(long param1Long1, int param1Int, long param1Long2) {
/* 157 */         final String[] files = new String[param1Int];
/* 158 */         for (byte b = 0; b < param1Int; b++) {
/* 159 */           arrayOfString[b] = getName(param1Long2, b);
/*     */         }
/* 161 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/* 164 */                 if (Lwjgl3Window.this.windowListener != null) {
/* 165 */                   Lwjgl3Window.this.windowListener.filesDropped(files);
/*     */                 }
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */   
/* 172 */   private final GLFWWindowRefreshCallback refreshCallback = new GLFWWindowRefreshCallback()
/*     */     {
/*     */       public void invoke(long param1Long) {
/* 175 */         Lwjgl3Window.this.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/* 178 */                 if (Lwjgl3Window.this.windowListener != null) {
/* 179 */                   Lwjgl3Window.this.windowListener.refreshRequested();
/*     */                 }
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Lwjgl3Window(ApplicationListener paramApplicationListener, Array<LifecycleListener> paramArray, Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration, Lwjgl3ApplicationBase paramLwjgl3ApplicationBase) {
/* 188 */     this.listener = paramApplicationListener;
/* 189 */     this.lifecycleListeners = paramArray;
/* 190 */     this.windowListener = paramLwjgl3ApplicationConfiguration.windowListener;
/* 191 */     this.config = paramLwjgl3ApplicationConfiguration;
/* 192 */     this.application = paramLwjgl3ApplicationBase;
/* 193 */     this.tmpBuffer = BufferUtils.createIntBuffer(1);
/* 194 */     this.tmpBuffer2 = BufferUtils.createIntBuffer(1);
/*     */   }
/*     */   
/*     */   void create(long paramLong) {
/* 198 */     this.windowHandle = paramLong;
/* 199 */     this.input = this.application.createInput(this);
/* 200 */     this.graphics = new Lwjgl3Graphics(this);
/*     */     
/* 202 */     GLFW.glfwSetWindowFocusCallback(paramLong, (GLFWWindowFocusCallbackI)this.focusCallback);
/* 203 */     GLFW.glfwSetWindowIconifyCallback(paramLong, (GLFWWindowIconifyCallbackI)this.iconifyCallback);
/* 204 */     GLFW.glfwSetWindowMaximizeCallback(paramLong, (GLFWWindowMaximizeCallbackI)this.maximizeCallback);
/* 205 */     GLFW.glfwSetWindowCloseCallback(paramLong, (GLFWWindowCloseCallbackI)this.closeCallback);
/* 206 */     GLFW.glfwSetDropCallback(paramLong, (GLFWDropCallbackI)this.dropCallback);
/* 207 */     GLFW.glfwSetWindowRefreshCallback(paramLong, (GLFWWindowRefreshCallbackI)this.refreshCallback);
/*     */     
/* 209 */     if (this.windowListener != null) {
/* 210 */       this.windowListener.created(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationListener getListener() {
/* 216 */     return this.listener;
/*     */   }
/*     */ 
/*     */   
/*     */   public Lwjgl3WindowListener getWindowListener() {
/* 221 */     return this.windowListener;
/*     */   }
/*     */   
/*     */   public void setWindowListener(Lwjgl3WindowListener paramLwjgl3WindowListener) {
/* 225 */     this.windowListener = paramLwjgl3WindowListener;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void postRunnable(Runnable paramRunnable) {
/* 231 */     synchronized (this.runnables) {
/* 232 */       this.runnables.add(paramRunnable);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(int paramInt1, int paramInt2) {
/* 239 */     GLFW.glfwSetWindowPos(this.windowHandle, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPositionX() {
/* 245 */     GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
/* 246 */     return this.tmpBuffer.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPositionY() {
/* 252 */     GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
/* 253 */     return this.tmpBuffer2.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 258 */     if (paramBoolean) {
/* 259 */       GLFW.glfwShowWindow(this.windowHandle); return;
/*     */     } 
/* 261 */     GLFW.glfwHideWindow(this.windowHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeWindow() {
/* 267 */     GLFW.glfwSetWindowShouldClose(this.windowHandle, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void iconifyWindow() {
/* 273 */     GLFW.glfwIconifyWindow(this.windowHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIconified() {
/* 278 */     return this.iconified;
/*     */   }
/*     */ 
/*     */   
/*     */   public void restoreWindow() {
/* 283 */     GLFW.glfwRestoreWindow(this.windowHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void maximizeWindow() {
/* 288 */     GLFW.glfwMaximizeWindow(this.windowHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void focusWindow() {
/* 293 */     GLFW.glfwFocusWindow(this.windowHandle);
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 297 */     return this.focused;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIcon(Pixmap... paramVarArgs) {
/* 306 */     setIcon(this.windowHandle, paramVarArgs);
/*     */   }
/*     */   
/*     */   static void setIcon(long paramLong, String[] paramArrayOfString, Files.FileType paramFileType) {
/* 310 */     if (SharedLibraryLoader.isMac)
/*     */       return; 
/* 312 */     Pixmap[] arrayOfPixmap1 = new Pixmap[paramArrayOfString.length];
/* 313 */     for (byte b2 = 0; b2 < paramArrayOfString.length; b2++) {
/* 314 */       arrayOfPixmap1[b2] = new Pixmap(Gdx.files.getFileHandle(paramArrayOfString[b2], paramFileType));
/*     */     }
/*     */     
/* 317 */     setIcon(paramLong, arrayOfPixmap1); int i; byte b1;
/*     */     Pixmap[] arrayOfPixmap2;
/* 319 */     for (i = (arrayOfPixmap2 = arrayOfPixmap1).length, b1 = 0; b1 < i; b1++) {
/* 320 */       Pixmap pixmap; (pixmap = arrayOfPixmap2[b1]).dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   static void setIcon(long paramLong, Pixmap[] paramArrayOfPixmap) {
/* 325 */     if (SharedLibraryLoader.isMac)
/*     */       return; 
/* 327 */     GLFWImage.Buffer buffer = GLFWImage.malloc(paramArrayOfPixmap.length);
/* 328 */     Pixmap[] arrayOfPixmap1 = new Pixmap[paramArrayOfPixmap.length];
/*     */     
/* 330 */     for (byte b1 = 0; b1 < paramArrayOfPixmap.length; b1++) {
/*     */       Pixmap pixmap;
/*     */       
/* 333 */       if ((pixmap = paramArrayOfPixmap[b1]).getFormat() != Pixmap.Format.RGBA8888) {
/*     */         Pixmap pixmap1;
/* 335 */         (pixmap1 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), Pixmap.Format.RGBA8888)).setBlending(Pixmap.Blending.None);
/* 336 */         pixmap1.drawPixmap(pixmap, 0, 0);
/* 337 */         arrayOfPixmap1[b1] = pixmap1;
/* 338 */         pixmap = pixmap1;
/*     */       } 
/*     */       
/*     */       GLFWImage gLFWImage;
/* 342 */       (gLFWImage = GLFWImage.malloc()).set(pixmap.getWidth(), pixmap.getHeight(), pixmap.getPixels());
/* 343 */       buffer.put((Struct)gLFWImage);
/*     */       
/* 345 */       gLFWImage.free();
/*     */     } 
/*     */     
/* 348 */     buffer.position(0);
/* 349 */     GLFW.glfwSetWindowIcon(paramLong, buffer);
/*     */     
/* 351 */     buffer.free(); Pixmap[] arrayOfPixmap2; int i; byte b2;
/* 352 */     for (i = (arrayOfPixmap2 = arrayOfPixmap1).length, b2 = 0; b2 < i; b2++) {
/* 353 */       Pixmap pixmap; if ((pixmap = arrayOfPixmap2[b2]) != null) {
/* 354 */         pixmap.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTitle(CharSequence paramCharSequence) {
/* 361 */     GLFW.glfwSetWindowTitle(this.windowHandle, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeLimits(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 367 */     setSizeLimits(this.windowHandle, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   static void setSizeLimits(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 371 */     GLFW.glfwSetWindowSizeLimits(paramLong, (paramInt1 >= 0) ? paramInt1 : -1, 
/* 372 */         (paramInt2 >= 0) ? paramInt2 : -1, (paramInt3 >= 0) ? paramInt3 : -1, 
/* 373 */         (paramInt4 >= 0) ? paramInt4 : -1);
/*     */   }
/*     */   
/*     */   Lwjgl3Graphics getGraphics() {
/* 377 */     return this.graphics;
/*     */   }
/*     */   
/*     */   Lwjgl3Input getInput() {
/* 381 */     return this.input;
/*     */   }
/*     */   
/*     */   public long getWindowHandle() {
/* 385 */     return this.windowHandle;
/*     */   }
/*     */   
/*     */   void windowHandleChanged(long paramLong) {
/* 389 */     this.windowHandle = paramLong;
/* 390 */     this.input.windowHandleChanged(paramLong);
/*     */   }
/*     */   
/*     */   boolean update() {
/* 394 */     if (!this.listenerInitialized) {
/* 395 */       initializeListener();
/*     */     }
/* 397 */     synchronized (this.runnables) {
/* 398 */       this.executedRunnables.addAll(this.runnables);
/* 399 */       this.runnables.clear();
/*     */     } 
/* 401 */     for (Array.ArrayIterator<Runnable> arrayIterator = this.executedRunnables.iterator(); arrayIterator.hasNext();) {
/* 402 */       (runnable = arrayIterator.next()).run();
/*     */     }
/* 404 */     int i = (this.executedRunnables.size > 0 || this.graphics.isContinuousRendering()) ? 1 : 0;
/* 405 */     this.executedRunnables.clear();
/*     */     
/* 407 */     if (!this.iconified) this.input.update();
/*     */     
/* 409 */     synchronized (this) {
/* 410 */       i |= (this.requestRendering && !this.iconified) ? 1 : 0;
/* 411 */       this.requestRendering = false;
/*     */     } 
/*     */     
/* 414 */     if (i != 0) {
/* 415 */       this.graphics.update();
/* 416 */       this.listener.render();
/* 417 */       GLFW.glfwSwapBuffers(this.windowHandle);
/*     */     } 
/*     */     
/* 420 */     if (!this.iconified) this.input.prepareNext();
/*     */     
/* 422 */     return i;
/*     */   }
/*     */   
/*     */   void requestRendering() {
/* 426 */     synchronized (this) {
/* 427 */       this.requestRendering = true;
/*     */       return;
/*     */     } 
/*     */   }
/*     */   boolean shouldClose() {
/* 432 */     return GLFW.glfwWindowShouldClose(this.windowHandle);
/*     */   }
/*     */   
/*     */   Lwjgl3ApplicationConfiguration getConfig() {
/* 436 */     return this.config;
/*     */   }
/*     */   
/*     */   boolean isListenerInitialized() {
/* 440 */     return this.listenerInitialized;
/*     */   }
/*     */   
/*     */   void initializeListener() {
/* 444 */     if (!this.listenerInitialized) {
/* 445 */       this.listener.create();
/* 446 */       this.listener.resize(this.graphics.getWidth(), this.graphics.getHeight());
/* 447 */       this.listenerInitialized = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   void makeCurrent() {
/* 452 */     Gdx.graphics = (Graphics)this.graphics;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     Gdx.gl = Gdx.gl20 = ((Gdx.gl30 = (GL30)(((Gdx.gl31 = (GL31)(((Gdx.gl32 = this.graphics.getGL32()) != null) ? Gdx.gl32 : this.graphics.getGL31())) != null) ? Gdx.gl31 : this.graphics.getGL30())) != null) ? (GL20)Gdx.gl30 : this.graphics.getGL20();
/* 458 */     Gdx.input = this.input;
/*     */     
/* 460 */     GLFW.glfwMakeContextCurrent(this.windowHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 465 */     this.listener.pause();
/* 466 */     this.listener.dispose();
/* 467 */     Lwjgl3Cursor.dispose(this);
/* 468 */     this.graphics.dispose();
/* 469 */     this.input.dispose();
/* 470 */     GLFW.glfwSetWindowFocusCallback(this.windowHandle, null);
/* 471 */     GLFW.glfwSetWindowIconifyCallback(this.windowHandle, null);
/* 472 */     GLFW.glfwSetWindowCloseCallback(this.windowHandle, null);
/* 473 */     GLFW.glfwSetDropCallback(this.windowHandle, null);
/* 474 */     GLFW.glfwDestroyWindow(this.windowHandle);
/*     */     
/* 476 */     this.focusCallback.free();
/* 477 */     this.iconifyCallback.free();
/* 478 */     this.maximizeCallback.free();
/* 479 */     this.closeCallback.free();
/* 480 */     this.dropCallback.free();
/* 481 */     this.refreshCallback.free();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     int i;
/* 489 */     return i = 31 + (int)(this.windowHandle ^ this.windowHandle >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 494 */     if (this == paramObject) return true; 
/* 495 */     if (paramObject == null) return false; 
/* 496 */     if (getClass() != paramObject.getClass()) return false; 
/* 497 */     paramObject = paramObject;
/* 498 */     if (this.windowHandle != ((Lwjgl3Window)paramObject).windowHandle) return false; 
/* 499 */     return true;
/*     */   }
/*     */   
/*     */   public void flash() {
/* 503 */     GLFW.glfwRequestWindowAttention(this.windowHandle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Window.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */