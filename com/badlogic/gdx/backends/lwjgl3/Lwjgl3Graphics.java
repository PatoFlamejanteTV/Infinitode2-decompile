/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.AbstractGraphics;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.graphics.Cursor;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.graphics.GL32;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.glutils.GLVersion;
/*     */ import com.badlogic.gdx.graphics.glutils.HdpiMode;
/*     */ import com.badlogic.gdx.math.GridPoint2;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
/*     */ import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
/*     */ import org.lwjgl.system.Configuration;
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
/*     */ public class Lwjgl3Graphics
/*     */   extends AbstractGraphics
/*     */   implements Disposable
/*     */ {
/*     */   final Lwjgl3Window window;
/*     */   GL20 gl20;
/*     */   private GL30 gl30;
/*     */   private GL31 gl31;
/*     */   private GL32 gl32;
/*     */   private GLVersion glVersion;
/*     */   private volatile int backBufferWidth;
/*     */   private volatile int backBufferHeight;
/*     */   private volatile int logicalWidth;
/*     */   private volatile int logicalHeight;
/*     */   private volatile boolean isContinuous = true;
/*     */   private Graphics.BufferFormat bufferFormat;
/*  58 */   private long lastFrameTime = -1L;
/*     */   private float deltaTime;
/*     */   private boolean resetDeltaTime = false;
/*     */   private long frameId;
/*  62 */   private long frameCounterStart = 0L;
/*     */   private int frames;
/*     */   private int fps;
/*     */   private int windowPosXBeforeFullscreen;
/*     */   private int windowPosYBeforeFullscreen;
/*     */   private int windowWidthBeforeFullscreen;
/*     */   private int windowHeightBeforeFullscreen;
/*  69 */   private Graphics.DisplayMode displayModeBeforeFullscreen = null;
/*     */   
/*  71 */   IntBuffer tmpBuffer = BufferUtils.createIntBuffer(1);
/*  72 */   IntBuffer tmpBuffer2 = BufferUtils.createIntBuffer(1);
/*     */   
/*  74 */   GLFWFramebufferSizeCallback resizeCallback = new GLFWFramebufferSizeCallback()
/*     */     {
/*     */       volatile boolean posted;
/*     */       
/*     */       public void invoke(final long windowHandle, final int width, final int height) {
/*  79 */         if (((Boolean)Configuration.GLFW_CHECK_THREAD0.get(Boolean.TRUE)).booleanValue()) {
/*  80 */           Lwjgl3Graphics.this.renderWindow(windowHandle, width, height); return;
/*     */         } 
/*  82 */         if (this.posted)
/*  83 */           return;  this.posted = true;
/*  84 */         Gdx.app.postRunnable(new Runnable()
/*     */             {
/*     */               public void run() {
/*  87 */                 Lwjgl3Graphics.null.this.posted = false;
/*  88 */                 Lwjgl3Graphics.this.renderWindow(windowHandle, width, height);
/*     */               }
/*     */             });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private void renderWindow(long paramLong, int paramInt1, int paramInt2) {
/*  96 */     updateFramebufferInfo();
/*  97 */     if (!this.window.isListenerInitialized()) {
/*     */       return;
/*     */     }
/* 100 */     this.window.makeCurrent();
/* 101 */     this.gl20.glViewport(0, 0, this.backBufferWidth, this.backBufferHeight);
/* 102 */     this.window.getListener().resize(getWidth(), getHeight());
/* 103 */     update();
/* 104 */     this.window.getListener().render();
/* 105 */     GLFW.glfwSwapBuffers(paramLong);
/*     */   }
/*     */   
/*     */   public Lwjgl3Graphics(Lwjgl3Window paramLwjgl3Window) {
/* 109 */     this.window = paramLwjgl3Window;
/* 110 */     if ((paramLwjgl3Window.getConfig()).glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL32) {
/* 111 */       this.gl20 = (GL20)(this.gl30 = (GL30)(this.gl31 = (GL31)(this.gl32 = new Lwjgl3GL32())));
/* 112 */     } else if ((paramLwjgl3Window.getConfig()).glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL31) {
/* 113 */       this.gl20 = (GL20)(this.gl30 = (GL30)(this.gl31 = new Lwjgl3GL31()));
/* 114 */     } else if ((paramLwjgl3Window.getConfig()).glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL30) {
/* 115 */       this.gl20 = (GL20)(this.gl30 = new Lwjgl3GL30());
/*     */     } else {
/*     */       try {
/* 118 */         this
/* 119 */           .gl20 = ((paramLwjgl3Window.getConfig()).glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL20) ? new Lwjgl3GL20() : (GL20)Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.Lwjgl3GLES20").newInstance();
/* 120 */       } catch (Throwable throwable) {
/* 121 */         throw new GdxRuntimeException("Couldn't instantiate GLES20.", throwable);
/*     */       } 
/* 123 */       this.gl30 = null;
/*     */     } 
/* 125 */     updateFramebufferInfo();
/* 126 */     initiateGL();
/* 127 */     GLFW.glfwSetFramebufferSizeCallback(throwable.getWindowHandle(), (GLFWFramebufferSizeCallbackI)this.resizeCallback);
/*     */   }
/*     */   
/*     */   private void initiateGL() {
/* 131 */     String str1 = this.gl20.glGetString(7938);
/* 132 */     String str2 = this.gl20.glGetString(7936);
/* 133 */     String str3 = this.gl20.glGetString(7937);
/* 134 */     this.glVersion = new GLVersion(Application.ApplicationType.Desktop, str1, str2, str3);
/* 135 */     if (supportsCubeMapSeamless()) {
/* 136 */       enableCubeMapSeamless(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsCubeMapSeamless() {
/* 142 */     return (this.glVersion.isVersionEqualToOrHigher(3, 2) || supportsExtension("GL_ARB_seamless_cube_map"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enableCubeMapSeamless(boolean paramBoolean) {
/* 149 */     if (paramBoolean) {
/* 150 */       this.gl20.glEnable(34895); return;
/*     */     } 
/* 152 */     this.gl20.glDisable(34895);
/*     */   }
/*     */ 
/*     */   
/*     */   public Lwjgl3Window getWindow() {
/* 157 */     return this.window;
/*     */   }
/*     */   
/*     */   void updateFramebufferInfo() {
/* 161 */     GLFW.glfwGetFramebufferSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
/* 162 */     this.backBufferWidth = this.tmpBuffer.get(0);
/* 163 */     this.backBufferHeight = this.tmpBuffer2.get(0);
/* 164 */     GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
/* 165 */     this.logicalWidth = this.tmpBuffer.get(0);
/* 166 */     this.logicalHeight = this.tmpBuffer2.get(0);
/* 167 */     Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration = this.window.getConfig();
/* 168 */     this.bufferFormat = new Graphics.BufferFormat(lwjgl3ApplicationConfiguration.r, lwjgl3ApplicationConfiguration.g, lwjgl3ApplicationConfiguration.b, lwjgl3ApplicationConfiguration.a, lwjgl3ApplicationConfiguration.depth, lwjgl3ApplicationConfiguration.stencil, lwjgl3ApplicationConfiguration.samples, false);
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/* 173 */     long l = System.nanoTime();
/* 174 */     if (this.lastFrameTime == -1L) this.lastFrameTime = l; 
/* 175 */     if (this.resetDeltaTime) {
/* 176 */       this.resetDeltaTime = false;
/* 177 */       this.deltaTime = 0.0F;
/*     */     } else {
/* 179 */       this.deltaTime = (float)(l - this.lastFrameTime) / 1.0E9F;
/* 180 */     }  this.lastFrameTime = l;
/*     */     
/* 182 */     if (l - this.frameCounterStart >= 1000000000L) {
/* 183 */       this.fps = this.frames;
/* 184 */       this.frames = 0;
/* 185 */       this.frameCounterStart = l;
/*     */     } 
/* 187 */     this.frames++;
/* 188 */     this.frameId++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGL30Available() {
/* 193 */     return (this.gl30 != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGL31Available() {
/* 198 */     return (this.gl31 != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGL32Available() {
/* 203 */     return (this.gl32 != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public GL20 getGL20() {
/* 208 */     return this.gl20;
/*     */   }
/*     */ 
/*     */   
/*     */   public GL30 getGL30() {
/* 213 */     return this.gl30;
/*     */   }
/*     */ 
/*     */   
/*     */   public GL31 getGL31() {
/* 218 */     return this.gl31;
/*     */   }
/*     */ 
/*     */   
/*     */   public GL32 getGL32() {
/* 223 */     return this.gl32;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGL20(GL20 paramGL20) {
/* 228 */     this.gl20 = paramGL20;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGL30(GL30 paramGL30) {
/* 233 */     this.gl30 = paramGL30;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGL31(GL31 paramGL31) {
/* 238 */     this.gl31 = paramGL31;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGL32(GL32 paramGL32) {
/* 243 */     this.gl32 = paramGL32;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 248 */     if ((this.window.getConfig()).hdpiMode == HdpiMode.Pixels) {
/* 249 */       return this.backBufferWidth;
/*     */     }
/* 251 */     return this.logicalWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 257 */     if ((this.window.getConfig()).hdpiMode == HdpiMode.Pixels) {
/* 258 */       return this.backBufferHeight;
/*     */     }
/* 260 */     return this.logicalHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBackBufferWidth() {
/* 266 */     return this.backBufferWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBackBufferHeight() {
/* 271 */     return this.backBufferHeight;
/*     */   }
/*     */   
/*     */   public int getLogicalWidth() {
/* 275 */     return this.logicalWidth;
/*     */   }
/*     */   
/*     */   public int getLogicalHeight() {
/* 279 */     return this.logicalHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFrameId() {
/* 284 */     return this.frameId;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaTime() {
/* 289 */     return this.deltaTime;
/*     */   }
/*     */   
/*     */   public void resetDeltaTime() {
/* 293 */     this.resetDeltaTime = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFramesPerSecond() {
/* 298 */     return this.fps;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.GraphicsType getType() {
/* 303 */     return Graphics.GraphicsType.LWJGL3;
/*     */   }
/*     */ 
/*     */   
/*     */   public GLVersion getGLVersion() {
/* 308 */     return this.glVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpiX() {
/* 313 */     return getPpcX() * 2.54F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpiY() {
/* 318 */     return getPpcY() * 2.54F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpcX() {
/*     */     Lwjgl3Monitor lwjgl3Monitor;
/* 324 */     GLFW.glfwGetMonitorPhysicalSize((lwjgl3Monitor = (Lwjgl3Monitor)getMonitor()).monitorHandle, this.tmpBuffer, this.tmpBuffer2);
/* 325 */     int i = this.tmpBuffer.get(0);
/*     */     Graphics.DisplayMode displayMode;
/* 327 */     return (displayMode = getDisplayMode()).width / i * 10.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPpcY() {
/*     */     Lwjgl3Monitor lwjgl3Monitor;
/* 333 */     GLFW.glfwGetMonitorPhysicalSize((lwjgl3Monitor = (Lwjgl3Monitor)getMonitor()).monitorHandle, this.tmpBuffer, this.tmpBuffer2);
/* 334 */     int i = this.tmpBuffer2.get(0);
/*     */     Graphics.DisplayMode displayMode;
/* 336 */     return (displayMode = getDisplayMode()).height / i * 10.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsDisplayModeChange() {
/* 341 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.Monitor getPrimaryMonitor() {
/* 346 */     return Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Graphics.Monitor getMonitor() {
/* 352 */     Graphics.Monitor arrayOfMonitor1[], monitor = (arrayOfMonitor1 = getMonitors())[0];
/*     */     
/* 354 */     GLFW.glfwGetWindowPos(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
/* 355 */     int i = this.tmpBuffer.get(0);
/* 356 */     int j = this.tmpBuffer2.get(0);
/* 357 */     GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
/* 358 */     int k = this.tmpBuffer.get(0);
/* 359 */     int m = this.tmpBuffer2.get(0);
/*     */     
/* 361 */     int n = 0; Graphics.Monitor[] arrayOfMonitor2; int i1;
/*     */     byte b;
/* 363 */     for (i1 = (arrayOfMonitor2 = arrayOfMonitor1).length, b = 0; b < i1; ) { Graphics.Monitor monitor1 = arrayOfMonitor2[b];
/* 364 */       Graphics.DisplayMode displayMode = getDisplayMode(monitor1);
/*     */ 
/*     */ 
/*     */       
/* 368 */       int i2 = Math.max(0, Math.min(i + k, monitor1.virtualX + displayMode.width) - Math.max(i, monitor1.virtualX)) * Math.max(0, Math.min(j + m, monitor1.virtualY + displayMode.height) - Math.max(j, monitor1.virtualY));
/*     */       
/* 370 */       if (n < i2) {
/* 371 */         n = i2;
/* 372 */         monitor = monitor1;
/*     */       }  b++; }
/*     */     
/* 375 */     return monitor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.Monitor[] getMonitors() {
/*     */     PointerBuffer pointerBuffer;
/* 381 */     Graphics.Monitor[] arrayOfMonitor = new Graphics.Monitor[(pointerBuffer = GLFW.glfwGetMonitors()).limit()];
/* 382 */     for (byte b = 0; b < pointerBuffer.limit(); b++) {
/* 383 */       arrayOfMonitor[b] = Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(pointerBuffer.get(b));
/*     */     }
/* 385 */     return arrayOfMonitor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode[] getDisplayModes() {
/* 390 */     return Lwjgl3ApplicationConfiguration.getDisplayModes(getMonitor());
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor paramMonitor) {
/* 395 */     return Lwjgl3ApplicationConfiguration.getDisplayModes(paramMonitor);
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode getDisplayMode() {
/* 400 */     return Lwjgl3ApplicationConfiguration.getDisplayMode(getMonitor());
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.DisplayMode getDisplayMode(Graphics.Monitor paramMonitor) {
/* 405 */     return Lwjgl3ApplicationConfiguration.getDisplayMode(paramMonitor);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetLeft() {
/* 410 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetTop() {
/* 415 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetBottom() {
/* 420 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSafeInsetRight() {
/* 425 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setFullscreenMode(Graphics.DisplayMode paramDisplayMode) {
/* 430 */     this.window.getInput().resetPollingStates();
/* 431 */     paramDisplayMode = paramDisplayMode;
/* 432 */     if (isFullscreen()) {
/*     */       Lwjgl3DisplayMode lwjgl3DisplayMode;
/* 434 */       if ((lwjgl3DisplayMode = (Lwjgl3DisplayMode)getDisplayMode()).getMonitor() == paramDisplayMode.getMonitor() && lwjgl3DisplayMode.refreshRate == ((Lwjgl3DisplayMode)paramDisplayMode).refreshRate) {
/*     */         
/* 436 */         GLFW.glfwSetWindowSize(this.window.getWindowHandle(), ((Lwjgl3DisplayMode)paramDisplayMode).width, ((Lwjgl3DisplayMode)paramDisplayMode).height);
/*     */       } else {
/*     */         
/* 439 */         GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), paramDisplayMode.getMonitor(), 0, 0, ((Lwjgl3DisplayMode)paramDisplayMode).width, ((Lwjgl3DisplayMode)paramDisplayMode).height, ((Lwjgl3DisplayMode)paramDisplayMode).refreshRate);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 444 */       storeCurrentWindowPositionAndDisplayMode();
/*     */ 
/*     */       
/* 447 */       GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), paramDisplayMode.getMonitor(), 0, 0, ((Lwjgl3DisplayMode)paramDisplayMode).width, ((Lwjgl3DisplayMode)paramDisplayMode).height, ((Lwjgl3DisplayMode)paramDisplayMode).refreshRate);
/*     */     } 
/*     */     
/* 450 */     updateFramebufferInfo();
/*     */     
/* 452 */     setVSync((this.window.getConfig()).vSyncEnabled);
/*     */     
/* 454 */     return true;
/*     */   }
/*     */   
/*     */   private void storeCurrentWindowPositionAndDisplayMode() {
/* 458 */     this.windowPosXBeforeFullscreen = this.window.getPositionX();
/* 459 */     this.windowPosYBeforeFullscreen = this.window.getPositionY();
/* 460 */     this.windowWidthBeforeFullscreen = this.logicalWidth;
/* 461 */     this.windowHeightBeforeFullscreen = this.logicalHeight;
/* 462 */     this.displayModeBeforeFullscreen = getDisplayMode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setWindowedMode(int paramInt1, int paramInt2) {
/* 467 */     this.window.getInput().resetPollingStates();
/* 468 */     if (!isFullscreen()) {
/* 469 */       GridPoint2 gridPoint2 = null;
/* 470 */       boolean bool = false;
/* 471 */       if (paramInt1 != this.logicalWidth || paramInt2 != this.logicalHeight) {
/* 472 */         bool = true;
/* 473 */         gridPoint2 = Lwjgl3ApplicationConfiguration.calculateCenteredWindowPosition((Lwjgl3Monitor)getMonitor(), paramInt1, paramInt2);
/*     */       } 
/* 475 */       GLFW.glfwSetWindowSize(this.window.getWindowHandle(), paramInt1, paramInt2);
/* 476 */       if (bool) {
/* 477 */         this.window.setPosition(gridPoint2.x, gridPoint2.y);
/*     */       }
/*     */     } else {
/* 480 */       if (this.displayModeBeforeFullscreen == null) {
/* 481 */         storeCurrentWindowPositionAndDisplayMode();
/*     */       }
/* 483 */       if (paramInt1 != this.windowWidthBeforeFullscreen || paramInt2 != this.windowHeightBeforeFullscreen) {
/*     */         
/* 485 */         GridPoint2 gridPoint2 = Lwjgl3ApplicationConfiguration.calculateCenteredWindowPosition((Lwjgl3Monitor)getMonitor(), paramInt1, paramInt2);
/*     */         
/* 487 */         GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, gridPoint2.x, gridPoint2.y, paramInt1, paramInt2, this.displayModeBeforeFullscreen.refreshRate);
/*     */       } else {
/*     */         
/* 490 */         GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, this.windowPosXBeforeFullscreen, this.windowPosYBeforeFullscreen, paramInt1, paramInt2, this.displayModeBeforeFullscreen.refreshRate);
/*     */       } 
/*     */     } 
/*     */     
/* 494 */     updateFramebufferInfo();
/* 495 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTitle(String paramString) {
/* 500 */     if (paramString == null) {
/* 501 */       paramString = "";
/*     */     }
/* 503 */     GLFW.glfwSetWindowTitle(this.window.getWindowHandle(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUndecorated(boolean paramBoolean) {
/* 508 */     getWindow().getConfig().setDecorated(!paramBoolean);
/* 509 */     GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131077, paramBoolean ? 0 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setResizable(boolean paramBoolean) {
/* 514 */     getWindow().getConfig().setResizable(paramBoolean);
/* 515 */     GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131075, paramBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVSync(boolean paramBoolean) {
/* 520 */     (getWindow().getConfig()).vSyncEnabled = paramBoolean;
/* 521 */     GLFW.glfwSwapInterval(paramBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundFPS(int paramInt) {
/* 530 */     (getWindow().getConfig()).foregroundFPS = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics.BufferFormat getBufferFormat() {
/* 535 */     return this.bufferFormat;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsExtension(String paramString) {
/* 540 */     return GLFW.glfwExtensionSupported(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContinuousRendering(boolean paramBoolean) {
/* 545 */     this.isContinuous = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContinuousRendering() {
/* 550 */     return this.isContinuous;
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestRendering() {
/* 555 */     this.window.requestRendering();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFullscreen() {
/* 560 */     return (GLFW.glfwGetWindowMonitor(this.window.getWindowHandle()) != 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor newCursor(Pixmap paramPixmap, int paramInt1, int paramInt2) {
/* 565 */     return new Lwjgl3Cursor(getWindow(), paramPixmap, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCursor(Cursor paramCursor) {
/* 570 */     GLFW.glfwSetCursor(getWindow().getWindowHandle(), ((Lwjgl3Cursor)paramCursor).glfwCursor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSystemCursor(Cursor.SystemCursor paramSystemCursor) {
/* 575 */     Lwjgl3Cursor.setSystemCursor(getWindow().getWindowHandle(), paramSystemCursor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 580 */     this.resizeCallback.free();
/*     */   }
/*     */   
/*     */   public static class Lwjgl3DisplayMode extends Graphics.DisplayMode {
/*     */     final long monitorHandle;
/*     */     
/*     */     Lwjgl3DisplayMode(long param1Long, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 587 */       super(param1Int1, param1Int2, param1Int3, param1Int4);
/* 588 */       this.monitorHandle = param1Long;
/*     */     }
/*     */     
/*     */     public long getMonitor() {
/* 592 */       return this.monitorHandle;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Lwjgl3Monitor extends Graphics.Monitor {
/*     */     final long monitorHandle;
/*     */     
/*     */     Lwjgl3Monitor(long param1Long, int param1Int1, int param1Int2, String param1String) {
/* 600 */       super(param1Int1, param1Int2, param1String);
/* 601 */       this.monitorHandle = param1Long;
/*     */     }
/*     */     
/*     */     public long getMonitorHandle() {
/* 605 */       return this.monitorHandle;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Graphics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */