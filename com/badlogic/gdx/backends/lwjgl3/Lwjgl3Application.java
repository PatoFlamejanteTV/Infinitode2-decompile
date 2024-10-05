/*     */ package com.badlogic.gdx.backends.lwjgl3;
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
/*     */ import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
/*     */ import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
/*     */ import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudio;
/*     */ import com.badlogic.gdx.graphics.glutils.GLVersion;
/*     */ import com.badlogic.gdx.math.GridPoint2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Clipboard;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWErrorCallback;
/*     */ import org.lwjgl.glfw.GLFWErrorCallbackI;
/*     */ import org.lwjgl.opengl.AMDDebugOutput;
/*     */ import org.lwjgl.opengl.ARBDebugOutput;
/*     */ import org.lwjgl.opengl.GL;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL43;
/*     */ import org.lwjgl.opengl.GLCapabilities;
/*     */ import org.lwjgl.opengl.GLUtil;
/*     */ import org.lwjgl.opengl.KHRDebug;
/*     */ import org.lwjgl.system.Callback;
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
/*     */ 
/*     */ 
/*     */ public class Lwjgl3Application
/*     */   implements Lwjgl3ApplicationBase
/*     */ {
/*     */   private final Lwjgl3ApplicationConfiguration config;
/*  63 */   final Array<Lwjgl3Window> windows = new Array();
/*     */   private volatile Lwjgl3Window currentWindow;
/*     */   private Lwjgl3Audio audio;
/*     */   private final Files files;
/*     */   private final Net net;
/*  68 */   private final ObjectMap<String, Preferences> preferences = new ObjectMap();
/*     */   private final Lwjgl3Clipboard clipboard;
/*  70 */   private int logLevel = 2;
/*     */   private ApplicationLogger applicationLogger;
/*     */   private volatile boolean running = true;
/*  73 */   private final Array<Runnable> runnables = new Array();
/*  74 */   private final Array<Runnable> executedRunnables = new Array();
/*  75 */   private final Array<LifecycleListener> lifecycleListeners = new Array();
/*     */   private static GLFWErrorCallback errorCallback;
/*     */   private static GLVersion glVersion;
/*     */   private static Callback glDebugCallback;
/*     */   private final Sync sync;
/*     */   
/*     */   static void initializeGlfw() {
/*  82 */     if (errorCallback == null) {
/*  83 */       if (SharedLibraryLoader.isMac) loadGlfwAwtMacos(); 
/*  84 */       Lwjgl3NativesLoader.load();
/*     */       
/*  86 */       GLFW.glfwSetErrorCallback((GLFWErrorCallbackI)(errorCallback = GLFWErrorCallback.createPrint(Lwjgl3ApplicationConfiguration.errorStream)));
/*  87 */       if (SharedLibraryLoader.isMac) GLFW.glfwInitHint(327682, 225288); 
/*  88 */       GLFW.glfwInitHint(327681, 0);
/*  89 */       if (!GLFW.glfwInit()) {
/*  90 */         throw new GdxRuntimeException("Unable to initialize GLFW");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   static void loadANGLE() {
/*     */     try {
/*     */       Class<?> clazz;
/*     */       Method method;
/*  99 */       (method = (clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.ANGLELoader")).getMethod("load", new Class[0])).invoke(clazz, new Object[0]); return;
/* 100 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       return;
/* 102 */     } catch (Throwable throwable) {
/* 103 */       throw new GdxRuntimeException("Couldn't load ANGLE.", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void postLoadANGLE() {
/*     */     try {
/*     */       Class<?> clazz;
/*     */       Method method;
/* 111 */       (method = (clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.angle.ANGLELoader")).getMethod("postGlfwInit", new Class[0])).invoke(clazz, new Object[0]); return;
/* 112 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       return;
/* 114 */     } catch (Throwable throwable) {
/* 115 */       throw new GdxRuntimeException("Couldn't load ANGLE.", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void loadGlfwAwtMacos() {
/*     */     try {
/*     */       Class<?> clazz;
/*     */       Method method;
/* 123 */       File file = (File)(method = (clazz = Class.forName("com.badlogic.gdx.backends.lwjgl3.awt.GlfwAWTLoader")).getMethod("load", new Class[0])).invoke(clazz, new Object[0]);
/* 124 */       Configuration.GLFW_LIBRARY_NAME.set(file.getAbsolutePath());
/* 125 */       Configuration.GLFW_CHECK_THREAD0.set(Boolean.FALSE); return;
/* 126 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       return;
/* 128 */     } catch (Throwable throwable) {
/* 129 */       throw new GdxRuntimeException("Couldn't load GLFW AWT for macOS.", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Lwjgl3Application(ApplicationListener paramApplicationListener) {
/* 134 */     this(paramApplicationListener, new Lwjgl3ApplicationConfiguration());
/*     */   }
/*     */   
/*     */   public Lwjgl3Application(ApplicationListener paramApplicationListener, Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration) {
/* 138 */     if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) loadANGLE(); 
/* 139 */     initializeGlfw();
/* 140 */     setApplicationLogger(new Lwjgl3ApplicationLogger());
/*     */     
/* 142 */     this.config = paramLwjgl3ApplicationConfiguration = Lwjgl3ApplicationConfiguration.copy(paramLwjgl3ApplicationConfiguration);
/* 143 */     if (paramLwjgl3ApplicationConfiguration.title == null) paramLwjgl3ApplicationConfiguration.title = paramApplicationListener.getClass().getSimpleName();
/*     */     
/* 145 */     Gdx.app = this;
/* 146 */     if (!paramLwjgl3ApplicationConfiguration.disableAudio) {
/*     */       try {
/* 148 */         this.audio = createAudio(paramLwjgl3ApplicationConfiguration);
/* 149 */       } catch (Throwable throwable) {
/* 150 */         log("Lwjgl3Application", "Couldn't initialize audio, disabling audio", throwable);
/* 151 */         this.audio = (Lwjgl3Audio)new MockAudio();
/*     */       } 
/*     */     } else {
/* 154 */       this.audio = (Lwjgl3Audio)new MockAudio();
/*     */     } 
/* 156 */     Gdx.audio = (Audio)this.audio;
/* 157 */     this.files = Gdx.files = createFiles();
/* 158 */     this.net = Gdx.net = new Lwjgl3Net(paramLwjgl3ApplicationConfiguration);
/* 159 */     this.clipboard = new Lwjgl3Clipboard();
/*     */     
/* 161 */     this.sync = new Sync();
/*     */     
/* 163 */     Lwjgl3Window lwjgl3Window = createWindow(paramLwjgl3ApplicationConfiguration, paramApplicationListener, 0L);
/* 164 */     if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) postLoadANGLE(); 
/* 165 */     this.windows.add(lwjgl3Window);
/*     */     try {
/* 167 */       loop();
/* 168 */       cleanupWindows(); return;
/* 169 */     } catch (Throwable throwable) {
/* 170 */       if (paramApplicationListener = null instanceof RuntimeException) {
/* 171 */         throw (RuntimeException)paramApplicationListener;
/*     */       }
/* 173 */       throw new GdxRuntimeException(paramApplicationListener);
/*     */     } finally {
/* 175 */       cleanup();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void loop() {
/* 180 */     Array array = new Array();
/* 181 */     while (this.running && this.windows.size > 0) {
/*     */       int j;
/* 183 */       this.audio.update();
/*     */       
/* 185 */       boolean bool = false;
/* 186 */       array.clear();
/* 187 */       int i = -2;
/* 188 */       for (Array.ArrayIterator<Lwjgl3Window> arrayIterator = this.windows.iterator(); arrayIterator.hasNext(); ) { Lwjgl3Window lwjgl3Window = arrayIterator.next();
/* 189 */         if (this.currentWindow != lwjgl3Window) {
/* 190 */           lwjgl3Window.makeCurrent();
/* 191 */           this.currentWindow = lwjgl3Window;
/*     */         } 
/* 193 */         if (i == -2) i = (lwjgl3Window.getConfig()).foregroundFPS; 
/* 194 */         synchronized (this.lifecycleListeners) {
/* 195 */           bool |= lwjgl3Window.update();
/*     */         } 
/* 197 */         if (lwjgl3Window.shouldClose()) {
/* 198 */           array.add(lwjgl3Window);
/*     */         } }
/*     */       
/* 201 */       GLFW.glfwPollEvents();
/*     */ 
/*     */       
/* 204 */       synchronized (this.runnables) {
/* 205 */         j = (this.runnables.size > 0) ? 1 : 0;
/* 206 */         this.executedRunnables.clear();
/* 207 */         this.executedRunnables.addAll(this.runnables);
/* 208 */         this.runnables.clear();
/*     */       }  Array.ArrayIterator<Runnable> arrayIterator1;
/* 210 */       for (arrayIterator1 = this.executedRunnables.iterator(); arrayIterator1.hasNext();) {
/* 211 */         (runnable = arrayIterator1.next()).run();
/*     */       }
/* 213 */       if (j)
/*     */       {
/*     */         
/* 216 */         for (arrayIterator1 = this.windows.iterator(); arrayIterator1.hasNext();) {
/* 217 */           if (!(lwjgl3Window = (Lwjgl3Window)arrayIterator1.next()).getGraphics().isContinuousRendering()) lwjgl3Window.requestRendering();
/*     */         
/*     */         } 
/*     */       }
/* 221 */       for (arrayIterator1 = array.iterator(); arrayIterator1.hasNext(); ) { Lwjgl3Window lwjgl3Window = (Lwjgl3Window)arrayIterator1.next();
/* 222 */         if (this.windows.size == 1) {
/*     */ 
/*     */ 
/*     */           
/* 226 */           for (j = this.lifecycleListeners.size - 1; j >= 0; j--) {
/*     */             LifecycleListener lifecycleListener;
/* 228 */             (lifecycleListener = (LifecycleListener)this.lifecycleListeners.get(j)).pause();
/* 229 */             lifecycleListener.dispose();
/*     */           } 
/* 231 */           this.lifecycleListeners.clear();
/*     */         } 
/* 233 */         lwjgl3Window.dispose();
/*     */         
/* 235 */         this.windows.removeValue(lwjgl3Window, false); }
/*     */ 
/*     */       
/* 238 */       if (!bool) {
/*     */ 
/*     */         
/*     */         try {
/* 242 */           Thread.sleep((1000 / this.config.idleFPS));
/* 243 */         } catch (InterruptedException interruptedException) {}
/*     */         continue;
/*     */       } 
/* 246 */       if (i > 0) {
/* 247 */         this.sync.sync(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void cleanupWindows() {
/* 253 */     synchronized (this.lifecycleListeners) {
/* 254 */       for (Array.ArrayIterator<LifecycleListener> arrayIterator1 = this.lifecycleListeners.iterator(); arrayIterator1.hasNext(); ) {
/* 255 */         LifecycleListener lifecycleListener; (lifecycleListener = arrayIterator1.next()).pause();
/* 256 */         lifecycleListener.dispose();
/*     */       } 
/*     */     } 
/* 259 */     for (Array.ArrayIterator<Lwjgl3Window> arrayIterator = this.windows.iterator(); arrayIterator.hasNext();) {
/* 260 */       (lwjgl3Window = arrayIterator.next()).dispose();
/*     */     }
/* 262 */     this.windows.clear();
/*     */   }
/*     */   
/*     */   protected void cleanup() {
/* 266 */     Lwjgl3Cursor.disposeSystemCursors();
/* 267 */     this.audio.dispose();
/* 268 */     errorCallback.free();
/* 269 */     errorCallback = null;
/* 270 */     if (glDebugCallback != null) {
/* 271 */       glDebugCallback.free();
/* 272 */       glDebugCallback = null;
/*     */     } 
/* 274 */     GLFW.glfwTerminate();
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationListener getApplicationListener() {
/* 279 */     return this.currentWindow.getListener();
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics getGraphics() {
/* 284 */     return (Graphics)this.currentWindow.getGraphics();
/*     */   }
/*     */ 
/*     */   
/*     */   public Audio getAudio() {
/* 289 */     return (Audio)this.audio;
/*     */   }
/*     */ 
/*     */   
/*     */   public Input getInput() {
/* 294 */     return this.currentWindow.getInput();
/*     */   }
/*     */ 
/*     */   
/*     */   public Files getFiles() {
/* 299 */     return this.files;
/*     */   }
/*     */ 
/*     */   
/*     */   public Net getNet() {
/* 304 */     return this.net;
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug(String paramString1, String paramString2) {
/* 309 */     if (this.logLevel >= 3) getApplicationLogger().debug(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 314 */     if (this.logLevel >= 3) getApplicationLogger().debug(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void log(String paramString1, String paramString2) {
/* 319 */     if (this.logLevel >= 2) getApplicationLogger().log(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void log(String paramString1, String paramString2, Throwable paramThrowable) {
/* 324 */     if (this.logLevel >= 2) getApplicationLogger().log(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void error(String paramString1, String paramString2) {
/* 329 */     if (this.logLevel > 0) getApplicationLogger().error(paramString1, paramString2);
/*     */   
/*     */   }
/*     */   
/*     */   public void error(String paramString1, String paramString2, Throwable paramThrowable) {
/* 334 */     if (this.logLevel > 0) getApplicationLogger().error(paramString1, paramString2, paramThrowable);
/*     */   
/*     */   }
/*     */   
/*     */   public void setLogLevel(int paramInt) {
/* 339 */     this.logLevel = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLogLevel() {
/* 344 */     return this.logLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setApplicationLogger(ApplicationLogger paramApplicationLogger) {
/* 349 */     this.applicationLogger = paramApplicationLogger;
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationLogger getApplicationLogger() {
/* 354 */     return this.applicationLogger;
/*     */   }
/*     */ 
/*     */   
/*     */   public Application.ApplicationType getType() {
/* 359 */     return Application.ApplicationType.Desktop;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 364 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getJavaHeap() {
/* 369 */     return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeHeap() {
/* 374 */     return getJavaHeap();
/*     */   }
/*     */ 
/*     */   
/*     */   public Preferences getPreferences(String paramString) {
/* 379 */     if (this.preferences.containsKey(paramString)) {
/* 380 */       return (Preferences)this.preferences.get(paramString);
/*     */     }
/* 382 */     Lwjgl3Preferences lwjgl3Preferences = new Lwjgl3Preferences(new Lwjgl3FileHandle(new File(this.config.preferencesDirectory, paramString), this.config.preferencesFileType));
/*     */     
/* 384 */     this.preferences.put(paramString, lwjgl3Preferences);
/* 385 */     return lwjgl3Preferences;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Clipboard getClipboard() {
/* 391 */     return this.clipboard;
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRunnable(Runnable paramRunnable) {
/* 396 */     synchronized (this.runnables) {
/* 397 */       this.runnables.add(paramRunnable);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void exit() {
/* 403 */     this.running = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLifecycleListener(LifecycleListener paramLifecycleListener) {
/* 408 */     synchronized (this.lifecycleListeners) {
/* 409 */       this.lifecycleListeners.add(paramLifecycleListener);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeLifecycleListener(LifecycleListener paramLifecycleListener) {
/* 415 */     synchronized (this.lifecycleListeners) {
/* 416 */       this.lifecycleListeners.removeValue(paramLifecycleListener, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Lwjgl3Audio createAudio(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration) {
/* 422 */     return (Lwjgl3Audio)new OpenALLwjgl3Audio(paramLwjgl3ApplicationConfiguration.audioDeviceSimultaneousSources, paramLwjgl3ApplicationConfiguration.audioDeviceBufferCount, paramLwjgl3ApplicationConfiguration.audioDeviceBufferSize);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Lwjgl3Input createInput(Lwjgl3Window paramLwjgl3Window) {
/* 428 */     return new DefaultLwjgl3Input(paramLwjgl3Window);
/*     */   }
/*     */   
/*     */   protected Files createFiles() {
/* 432 */     return new Lwjgl3Files();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Lwjgl3Window newWindow(ApplicationListener paramApplicationListener, Lwjgl3WindowConfiguration paramLwjgl3WindowConfiguration) {
/*     */     Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration;
/* 441 */     (lwjgl3ApplicationConfiguration = Lwjgl3ApplicationConfiguration.copy(this.config)).setWindowConfiguration(paramLwjgl3WindowConfiguration);
/* 442 */     if (lwjgl3ApplicationConfiguration.title == null) lwjgl3ApplicationConfiguration.title = paramApplicationListener.getClass().getSimpleName(); 
/* 443 */     return createWindow(lwjgl3ApplicationConfiguration, paramApplicationListener, ((Lwjgl3Window)this.windows.get(0)).getWindowHandle());
/*     */   }
/*     */ 
/*     */   
/*     */   private Lwjgl3Window createWindow(final Lwjgl3ApplicationConfiguration config, ApplicationListener paramApplicationListener, final long sharedContext) {
/* 448 */     final Lwjgl3Window window = new Lwjgl3Window(paramApplicationListener, this.lifecycleListeners, config, this);
/* 449 */     if (sharedContext == 0L) {
/*     */       
/* 451 */       createWindow(lwjgl3Window, config, sharedContext);
/*     */     } else {
/*     */       
/* 454 */       postRunnable(new Runnable() {
/*     */             public void run() {
/* 456 */               Lwjgl3Application.this.createWindow(window, config, sharedContext);
/* 457 */               Lwjgl3Application.this.windows.add(window);
/*     */             }
/*     */           });
/*     */     } 
/* 461 */     return lwjgl3Window;
/*     */   }
/*     */   
/*     */   void createWindow(Lwjgl3Window paramLwjgl3Window, Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration, long paramLong) {
/* 465 */     long l = createGlfwWindow(paramLwjgl3ApplicationConfiguration, paramLong);
/* 466 */     paramLwjgl3Window.create(l);
/* 467 */     paramLwjgl3Window.setVisible(paramLwjgl3ApplicationConfiguration.initialVisible);
/*     */     
/* 469 */     for (byte b = 0; b < 2; b++) {
/* 470 */       (paramLwjgl3Window.getGraphics()).gl20.glClearColor(paramLwjgl3ApplicationConfiguration.initialBackgroundColor.r, paramLwjgl3ApplicationConfiguration.initialBackgroundColor.g, paramLwjgl3ApplicationConfiguration.initialBackgroundColor.b, paramLwjgl3ApplicationConfiguration.initialBackgroundColor.a);
/*     */       
/* 472 */       (paramLwjgl3Window.getGraphics()).gl20.glClear(16384);
/* 473 */       GLFW.glfwSwapBuffers(l);
/*     */     } 
/*     */     
/* 476 */     if (this.currentWindow != null)
/*     */     {
/*     */       
/* 479 */       this.currentWindow.makeCurrent(); } 
/*     */   }
/*     */   
/*     */   static long createGlfwWindow(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration, long paramLong) {
/*     */     long l;
/* 484 */     GLFW.glfwDefaultWindowHints();
/* 485 */     GLFW.glfwWindowHint(131076, 0);
/* 486 */     GLFW.glfwWindowHint(131075, paramLwjgl3ApplicationConfiguration.windowResizable ? 1 : 0);
/* 487 */     GLFW.glfwWindowHint(131080, paramLwjgl3ApplicationConfiguration.windowMaximized ? 1 : 0);
/* 488 */     GLFW.glfwWindowHint(131078, paramLwjgl3ApplicationConfiguration.autoIconify ? 1 : 0);
/*     */     
/* 490 */     GLFW.glfwWindowHint(135169, paramLwjgl3ApplicationConfiguration.r);
/* 491 */     GLFW.glfwWindowHint(135170, paramLwjgl3ApplicationConfiguration.g);
/* 492 */     GLFW.glfwWindowHint(135171, paramLwjgl3ApplicationConfiguration.b);
/* 493 */     GLFW.glfwWindowHint(135172, paramLwjgl3ApplicationConfiguration.a);
/* 494 */     GLFW.glfwWindowHint(135174, paramLwjgl3ApplicationConfiguration.stencil);
/* 495 */     GLFW.glfwWindowHint(135173, paramLwjgl3ApplicationConfiguration.depth);
/* 496 */     GLFW.glfwWindowHint(135181, paramLwjgl3ApplicationConfiguration.samples);
/*     */     
/* 498 */     if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL30 || paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL31 || paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.GL32) {
/*     */ 
/*     */       
/* 501 */       GLFW.glfwWindowHint(139266, paramLwjgl3ApplicationConfiguration.gles30ContextMajorVersion);
/* 502 */       GLFW.glfwWindowHint(139267, paramLwjgl3ApplicationConfiguration.gles30ContextMinorVersion);
/* 503 */       if (SharedLibraryLoader.isMac)
/*     */       {
/*     */ 
/*     */         
/* 507 */         GLFW.glfwWindowHint(139270, 1);
/* 508 */         GLFW.glfwWindowHint(139272, 204801);
/*     */       }
/*     */     
/* 511 */     } else if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
/* 512 */       GLFW.glfwWindowHint(139275, 221186);
/* 513 */       GLFW.glfwWindowHint(139265, 196610);
/* 514 */       GLFW.glfwWindowHint(139266, 2);
/* 515 */       GLFW.glfwWindowHint(139267, 0);
/*     */     } 
/*     */ 
/*     */     
/* 519 */     if (paramLwjgl3ApplicationConfiguration.transparentFramebuffer) {
/* 520 */       GLFW.glfwWindowHint(131082, 1);
/*     */     }
/*     */     
/* 523 */     if (paramLwjgl3ApplicationConfiguration.debug) {
/* 524 */       GLFW.glfwWindowHint(139271, 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 529 */     if (paramLwjgl3ApplicationConfiguration.fullscreenMode != null) {
/* 530 */       GLFW.glfwWindowHint(135183, paramLwjgl3ApplicationConfiguration.fullscreenMode.refreshRate);
/* 531 */       l = GLFW.glfwCreateWindow(paramLwjgl3ApplicationConfiguration.fullscreenMode.width, paramLwjgl3ApplicationConfiguration.fullscreenMode.height, paramLwjgl3ApplicationConfiguration.title, paramLwjgl3ApplicationConfiguration.fullscreenMode
/* 532 */           .getMonitor(), paramLong);
/*     */     } else {
/* 534 */       GLFW.glfwWindowHint(131077, paramLwjgl3ApplicationConfiguration.windowDecorated ? 1 : 0);
/* 535 */       l = GLFW.glfwCreateWindow(paramLwjgl3ApplicationConfiguration.windowWidth, paramLwjgl3ApplicationConfiguration.windowHeight, paramLwjgl3ApplicationConfiguration.title, 0L, paramLong);
/*     */     } 
/* 537 */     if (l == 0L) {
/* 538 */       throw new GdxRuntimeException("Couldn't create window");
/*     */     }
/* 540 */     Lwjgl3Window.setSizeLimits(l, paramLwjgl3ApplicationConfiguration.windowMinWidth, paramLwjgl3ApplicationConfiguration.windowMinHeight, paramLwjgl3ApplicationConfiguration.windowMaxWidth, paramLwjgl3ApplicationConfiguration.windowMaxHeight);
/*     */     
/* 542 */     if (paramLwjgl3ApplicationConfiguration.fullscreenMode == null) {
/* 543 */       if (paramLwjgl3ApplicationConfiguration.windowX == -1 && paramLwjgl3ApplicationConfiguration.windowY == -1) {
/* 544 */         int i = Math.max(paramLwjgl3ApplicationConfiguration.windowWidth, paramLwjgl3ApplicationConfiguration.windowMinWidth);
/* 545 */         int j = Math.max(paramLwjgl3ApplicationConfiguration.windowHeight, paramLwjgl3ApplicationConfiguration.windowMinHeight);
/* 546 */         if (paramLwjgl3ApplicationConfiguration.windowMaxWidth >= 0) i = Math.min(i, paramLwjgl3ApplicationConfiguration.windowMaxWidth); 
/* 547 */         if (paramLwjgl3ApplicationConfiguration.windowMaxHeight >= 0) j = Math.min(j, paramLwjgl3ApplicationConfiguration.windowMaxHeight);
/*     */         
/* 549 */         long l1 = GLFW.glfwGetPrimaryMonitor();
/* 550 */         if (paramLwjgl3ApplicationConfiguration.windowMaximized && paramLwjgl3ApplicationConfiguration.maximizedMonitor != null) {
/* 551 */           l1 = paramLwjgl3ApplicationConfiguration.maximizedMonitor.monitorHandle;
/*     */         }
/*     */         
/* 554 */         GridPoint2 gridPoint2 = Lwjgl3ApplicationConfiguration.calculateCenteredWindowPosition(
/* 555 */             Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(l1), i, j);
/* 556 */         GLFW.glfwSetWindowPos(l, gridPoint2.x, gridPoint2.y);
/*     */       } else {
/* 558 */         GLFW.glfwSetWindowPos(l, paramLwjgl3ApplicationConfiguration.windowX, paramLwjgl3ApplicationConfiguration.windowY);
/*     */       } 
/*     */       
/* 561 */       if (paramLwjgl3ApplicationConfiguration.windowMaximized) {
/* 562 */         GLFW.glfwMaximizeWindow(l);
/*     */       }
/*     */     } 
/* 565 */     if (paramLwjgl3ApplicationConfiguration.windowIconPaths != null) {
/* 566 */       Lwjgl3Window.setIcon(l, paramLwjgl3ApplicationConfiguration.windowIconPaths, paramLwjgl3ApplicationConfiguration.windowIconFileType);
/*     */     }
/* 568 */     GLFW.glfwMakeContextCurrent(l);
/* 569 */     GLFW.glfwSwapInterval(paramLwjgl3ApplicationConfiguration.vSyncEnabled ? 1 : 0);
/* 570 */     if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
/*     */       try {
/*     */         Class<?> clazz;
/* 573 */         (clazz = Class.forName("org.lwjgl.opengles.GLES")).getMethod("createCapabilities", new Class[0]).invoke(clazz, new Object[0]);
/* 574 */       } catch (Throwable throwable) {
/* 575 */         throw new GdxRuntimeException("Couldn't initialize GLES", throwable);
/*     */       } 
/*     */     } else {
/* 578 */       GL.createCapabilities();
/*     */     } 
/*     */     
/* 581 */     initiateGL((paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20));
/* 582 */     if (!glVersion.isVersionEqualToOrHigher(2, 0)) {
/* 583 */       throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + glVersion
/* 584 */           .getVersionString() + "\n" + glVersion.getDebugVersionString());
/*     */     }
/* 586 */     if (paramLwjgl3ApplicationConfiguration.glEmulation != Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20 && !supportsFBO()) {
/* 587 */       throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + glVersion
/* 588 */           .getVersionString() + ", FBO extension: false\n" + glVersion.getDebugVersionString());
/*     */     }
/*     */     
/* 591 */     if (paramLwjgl3ApplicationConfiguration.debug) {
/* 592 */       if (paramLwjgl3ApplicationConfiguration.glEmulation == Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20) {
/* 593 */         throw new IllegalStateException("ANGLE currently can't be used with with Lwjgl3ApplicationConfiguration#enableGLDebugOutput");
/*     */       }
/*     */       
/* 596 */       glDebugCallback = GLUtil.setupDebugMessageCallback(paramLwjgl3ApplicationConfiguration.debugStream);
/* 597 */       setGLDebugMessageControl(GLDebugMessageSeverity.NOTIFICATION, false);
/*     */     } 
/*     */     
/* 600 */     return l;
/*     */   }
/*     */   
/*     */   private static void initiateGL(boolean paramBoolean) {
/* 604 */     if (!paramBoolean) {
/* 605 */       String str1 = GL11.glGetString(7938);
/* 606 */       String str2 = GL11.glGetString(7936);
/* 607 */       String str3 = GL11.glGetString(7937);
/* 608 */       glVersion = new GLVersion(Application.ApplicationType.Desktop, str1, str2, str3); return;
/*     */     } 
/*     */     try {
/*     */       Class<?> clazz;
/*     */       Method method;
/* 613 */       String str2 = (String)(method = (clazz = Class.forName("org.lwjgl.opengles.GLES20")).getMethod("glGetString", new Class[] { int.class })).invoke(clazz, new Object[] { Integer.valueOf(7938) });
/* 614 */       String str3 = (String)method.invoke(clazz, new Object[] { Integer.valueOf(7936) });
/* 615 */       String str1 = (String)method.invoke(clazz, new Object[] { Integer.valueOf(7937) });
/* 616 */       glVersion = new GLVersion(Application.ApplicationType.Desktop, str2, str3, str1); return;
/* 617 */     } catch (Throwable throwable) {
/* 618 */       throw new GdxRuntimeException("Couldn't get GLES version string.", throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean supportsFBO() {
/* 625 */     if (glVersion.isVersionEqualToOrHigher(3, 0) || GLFW.glfwExtensionSupported("GL_EXT_framebuffer_object") || 
/* 626 */       GLFW.glfwExtensionSupported("GL_ARB_framebuffer_object")) return true; 
/*     */     return false;
/*     */   }
/*     */   
/* 630 */   public enum GLDebugMessageSeverity { HIGH(37190, 37190, 37190, 37190),
/* 631 */     MEDIUM(37191, 37191, 37191, 37191),
/* 632 */     LOW(37192, 37192, 37192, 37192),
/*     */     
/* 634 */     NOTIFICATION(33387, 33387, -1, -1); final int gl43;
/*     */     final int khr;
/*     */     final int arb;
/*     */     final int amd;
/*     */     
/*     */     GLDebugMessageSeverity(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 640 */       this.gl43 = param1Int1;
/* 641 */       this.khr = param1Int2;
/* 642 */       this.arb = param1Int3;
/* 643 */       this.amd = param1Int4;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean setGLDebugMessageControl(GLDebugMessageSeverity paramGLDebugMessageSeverity, boolean paramBoolean) {
/*     */     GLCapabilities gLCapabilities;
/* 655 */     if ((gLCapabilities = GL.getCapabilities()).OpenGL43) {
/* 656 */       GL43.glDebugMessageControl(4352, 4352, paramGLDebugMessageSeverity.gl43, (IntBuffer)null, paramBoolean);
/* 657 */       return true;
/*     */     } 
/*     */     
/* 660 */     if (gLCapabilities.GL_KHR_debug) {
/* 661 */       KHRDebug.glDebugMessageControl(4352, 4352, paramGLDebugMessageSeverity.khr, (IntBuffer)null, paramBoolean);
/* 662 */       return true;
/*     */     } 
/*     */     
/* 665 */     if (gLCapabilities.GL_ARB_debug_output && paramGLDebugMessageSeverity.arb != -1) {
/* 666 */       ARBDebugOutput.glDebugMessageControlARB(4352, 4352, paramGLDebugMessageSeverity.arb, (IntBuffer)null, paramBoolean);
/* 667 */       return true;
/*     */     } 
/*     */     
/* 670 */     if (gLCapabilities.GL_AMD_debug_output && paramGLDebugMessageSeverity.amd != -1) {
/* 671 */       AMDDebugOutput.glDebugMessageEnableAMD(4352, paramGLDebugMessageSeverity.amd, (IntBuffer)null, paramBoolean);
/* 672 */       return true;
/*     */     } 
/*     */     
/* 675 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Application.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */