/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.graphics.glutils.HdpiMode;
/*     */ import com.badlogic.gdx.math.GridPoint2;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWVidMode;
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
/*     */ public class Lwjgl3ApplicationConfiguration
/*     */   extends Lwjgl3WindowConfiguration
/*     */ {
/*  44 */   public static PrintStream errorStream = System.err;
/*     */ 
/*     */   
/*     */   boolean disableAudio = false;
/*     */   
/*  49 */   int maxNetThreads = Integer.MAX_VALUE;
/*     */   
/*  51 */   int audioDeviceSimultaneousSources = 16;
/*  52 */   int audioDeviceBufferSize = 512;
/*  53 */   int audioDeviceBufferCount = 9;
/*     */   
/*     */   public enum GLEmulation {
/*  56 */     ANGLE_GLES20, GL20, GL30, GL31, GL32;
/*     */   }
/*     */   
/*  59 */   GLEmulation glEmulation = GLEmulation.GL20;
/*  60 */   int gles30ContextMajorVersion = 3;
/*  61 */   int gles30ContextMinorVersion = 2;
/*     */   
/*  63 */   int r = 8, g = 8, b = 8, a = 8;
/*  64 */   int depth = 16, stencil = 0;
/*  65 */   int samples = 0;
/*     */   
/*     */   boolean transparentFramebuffer;
/*  68 */   int idleFPS = 60;
/*  69 */   int foregroundFPS = 0;
/*     */   
/*     */   boolean pauseWhenMinimized = true;
/*     */   
/*     */   boolean pauseWhenLostFocus = false;
/*  74 */   String preferencesDirectory = ".prefs/";
/*  75 */   Files.FileType preferencesFileType = Files.FileType.External;
/*     */   
/*  77 */   HdpiMode hdpiMode = HdpiMode.Logical;
/*     */   
/*     */   boolean debug = false;
/*  80 */   PrintStream debugStream = System.err;
/*     */   
/*     */   static Lwjgl3ApplicationConfiguration copy(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration) {
/*     */     Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration;
/*  84 */     (lwjgl3ApplicationConfiguration = new Lwjgl3ApplicationConfiguration()).set(paramLwjgl3ApplicationConfiguration);
/*  85 */     return lwjgl3ApplicationConfiguration;
/*     */   }
/*     */   
/*     */   void set(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration) {
/*  89 */     setWindowConfiguration(paramLwjgl3ApplicationConfiguration);
/*  90 */     this.disableAudio = paramLwjgl3ApplicationConfiguration.disableAudio;
/*  91 */     this.audioDeviceSimultaneousSources = paramLwjgl3ApplicationConfiguration.audioDeviceSimultaneousSources;
/*  92 */     this.audioDeviceBufferSize = paramLwjgl3ApplicationConfiguration.audioDeviceBufferSize;
/*  93 */     this.audioDeviceBufferCount = paramLwjgl3ApplicationConfiguration.audioDeviceBufferCount;
/*  94 */     this.glEmulation = paramLwjgl3ApplicationConfiguration.glEmulation;
/*  95 */     this.gles30ContextMajorVersion = paramLwjgl3ApplicationConfiguration.gles30ContextMajorVersion;
/*  96 */     this.gles30ContextMinorVersion = paramLwjgl3ApplicationConfiguration.gles30ContextMinorVersion;
/*  97 */     this.r = paramLwjgl3ApplicationConfiguration.r;
/*  98 */     this.g = paramLwjgl3ApplicationConfiguration.g;
/*  99 */     this.b = paramLwjgl3ApplicationConfiguration.b;
/* 100 */     this.a = paramLwjgl3ApplicationConfiguration.a;
/* 101 */     this.depth = paramLwjgl3ApplicationConfiguration.depth;
/* 102 */     this.stencil = paramLwjgl3ApplicationConfiguration.stencil;
/* 103 */     this.samples = paramLwjgl3ApplicationConfiguration.samples;
/* 104 */     this.transparentFramebuffer = paramLwjgl3ApplicationConfiguration.transparentFramebuffer;
/* 105 */     this.idleFPS = paramLwjgl3ApplicationConfiguration.idleFPS;
/* 106 */     this.foregroundFPS = paramLwjgl3ApplicationConfiguration.foregroundFPS;
/* 107 */     this.pauseWhenMinimized = paramLwjgl3ApplicationConfiguration.pauseWhenMinimized;
/* 108 */     this.pauseWhenLostFocus = paramLwjgl3ApplicationConfiguration.pauseWhenLostFocus;
/* 109 */     this.preferencesDirectory = paramLwjgl3ApplicationConfiguration.preferencesDirectory;
/* 110 */     this.preferencesFileType = paramLwjgl3ApplicationConfiguration.preferencesFileType;
/* 111 */     this.hdpiMode = paramLwjgl3ApplicationConfiguration.hdpiMode;
/* 112 */     this.debug = paramLwjgl3ApplicationConfiguration.debug;
/* 113 */     this.debugStream = paramLwjgl3ApplicationConfiguration.debugStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialVisible(boolean paramBoolean) {
/* 118 */     this.initialVisible = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableAudio(boolean paramBoolean) {
/* 124 */     this.disableAudio = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxNetThreads(int paramInt) {
/* 129 */     this.maxNetThreads = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAudioConfig(int paramInt1, int paramInt2, int paramInt3) {
/* 138 */     this.audioDeviceSimultaneousSources = paramInt1;
/* 139 */     this.audioDeviceBufferSize = paramInt2;
/* 140 */     this.audioDeviceBufferCount = paramInt3;
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
/*     */   public void setOpenGLEmulation(GLEmulation paramGLEmulation, int paramInt1, int paramInt2) {
/* 154 */     this.glEmulation = paramGLEmulation;
/* 155 */     this.gles30ContextMajorVersion = paramInt1;
/* 156 */     this.gles30ContextMinorVersion = paramInt2;
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
/*     */   public void setBackBufferConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 169 */     this.r = paramInt1;
/* 170 */     this.g = paramInt2;
/* 171 */     this.b = paramInt3;
/* 172 */     this.a = paramInt4;
/* 173 */     this.depth = paramInt5;
/* 174 */     this.stencil = paramInt6;
/* 175 */     this.samples = paramInt7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransparentFramebuffer(boolean paramBoolean) {
/* 181 */     this.transparentFramebuffer = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIdleFPS(int paramInt) {
/* 186 */     this.idleFPS = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundFPS(int paramInt) {
/* 192 */     this.foregroundFPS = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPauseWhenMinimized(boolean paramBoolean) {
/* 198 */     this.pauseWhenMinimized = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPauseWhenLostFocus(boolean paramBoolean) {
/* 204 */     this.pauseWhenLostFocus = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPreferencesConfig(String paramString, Files.FileType paramFileType) {
/* 210 */     this.preferencesDirectory = paramString;
/* 211 */     this.preferencesFileType = paramFileType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHdpiMode(HdpiMode paramHdpiMode) {
/* 221 */     this.hdpiMode = paramHdpiMode;
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
/*     */   public void enableGLDebugOutput(boolean paramBoolean, PrintStream paramPrintStream) {
/* 233 */     this.debug = paramBoolean;
/* 234 */     this.debugStream = paramPrintStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.DisplayMode getDisplayMode() {
/* 239 */     Lwjgl3Application.initializeGlfw();
/* 240 */     GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
/* 241 */     return new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode
/* 242 */         .refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.DisplayMode getDisplayMode(Graphics.Monitor paramMonitor) {
/* 247 */     Lwjgl3Application.initializeGlfw();
/* 248 */     GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(((Lwjgl3Graphics.Lwjgl3Monitor)paramMonitor).monitorHandle);
/* 249 */     return new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)paramMonitor).monitorHandle, gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode
/* 250 */         .refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.DisplayMode[] getDisplayModes() {
/* 255 */     Lwjgl3Application.initializeGlfw();
/*     */     GLFWVidMode.Buffer buffer;
/* 257 */     Graphics.DisplayMode[] arrayOfDisplayMode = new Graphics.DisplayMode[(buffer = GLFW.glfwGetVideoModes(GLFW.glfwGetPrimaryMonitor())).limit()];
/* 258 */     for (byte b = 0; b < arrayOfDisplayMode.length; b++) {
/* 259 */       GLFWVidMode gLFWVidMode = (GLFWVidMode)buffer.get(b);
/* 260 */       arrayOfDisplayMode[b] = new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), gLFWVidMode.width(), gLFWVidMode.height(), gLFWVidMode
/* 261 */           .refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
/*     */     } 
/* 263 */     return arrayOfDisplayMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor paramMonitor) {
/* 268 */     Lwjgl3Application.initializeGlfw();
/*     */     GLFWVidMode.Buffer buffer;
/* 270 */     Graphics.DisplayMode[] arrayOfDisplayMode = new Graphics.DisplayMode[(buffer = GLFW.glfwGetVideoModes(((Lwjgl3Graphics.Lwjgl3Monitor)paramMonitor).monitorHandle)).limit()];
/* 271 */     for (byte b = 0; b < arrayOfDisplayMode.length; b++) {
/* 272 */       GLFWVidMode gLFWVidMode = (GLFWVidMode)buffer.get(b);
/* 273 */       arrayOfDisplayMode[b] = new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)paramMonitor).monitorHandle, gLFWVidMode.width(), gLFWVidMode
/* 274 */           .height(), gLFWVidMode.refreshRate(), gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits());
/*     */     } 
/* 276 */     return arrayOfDisplayMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.Monitor getPrimaryMonitor() {
/* 281 */     Lwjgl3Application.initializeGlfw();
/* 282 */     return toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Graphics.Monitor[] getMonitors() {
/* 287 */     Lwjgl3Application.initializeGlfw();
/*     */     PointerBuffer pointerBuffer;
/* 289 */     Graphics.Monitor[] arrayOfMonitor = new Graphics.Monitor[(pointerBuffer = GLFW.glfwGetMonitors()).limit()];
/* 290 */     for (byte b = 0; b < pointerBuffer.limit(); b++) {
/* 291 */       arrayOfMonitor[b] = toLwjgl3Monitor(pointerBuffer.get(b));
/*     */     }
/* 293 */     return arrayOfMonitor;
/*     */   }
/*     */   
/*     */   static Lwjgl3Graphics.Lwjgl3Monitor toLwjgl3Monitor(long paramLong) {
/* 297 */     IntBuffer intBuffer1 = BufferUtils.createIntBuffer(1);
/* 298 */     IntBuffer intBuffer2 = BufferUtils.createIntBuffer(1);
/* 299 */     GLFW.glfwGetMonitorPos(paramLong, intBuffer1, intBuffer2);
/* 300 */     int i = intBuffer1.get(0);
/* 301 */     int j = intBuffer2.get(0);
/* 302 */     String str = GLFW.glfwGetMonitorName(paramLong);
/* 303 */     return new Lwjgl3Graphics.Lwjgl3Monitor(paramLong, i, j, str);
/*     */   }
/*     */   
/*     */   static GridPoint2 calculateCenteredWindowPosition(Lwjgl3Graphics.Lwjgl3Monitor paramLwjgl3Monitor, int paramInt1, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: iconst_1
/*     */     //   1: invokestatic createIntBuffer : (I)Ljava/nio/IntBuffer;
/*     */     //   4: astore_3
/*     */     //   5: iconst_1
/*     */     //   6: invokestatic createIntBuffer : (I)Ljava/nio/IntBuffer;
/*     */     //   9: astore #4
/*     */     //   11: iconst_1
/*     */     //   12: invokestatic createIntBuffer : (I)Ljava/nio/IntBuffer;
/*     */     //   15: astore #5
/*     */     //   17: iconst_1
/*     */     //   18: invokestatic createIntBuffer : (I)Ljava/nio/IntBuffer;
/*     */     //   21: astore #6
/*     */     //   23: aload_0
/*     */     //   24: invokestatic getDisplayMode : (Lcom/badlogic/gdx/Graphics$Monitor;)Lcom/badlogic/gdx/Graphics$DisplayMode;
/*     */     //   27: astore #7
/*     */     //   29: aload_0
/*     */     //   30: getfield monitorHandle : J
/*     */     //   33: aload_3
/*     */     //   34: aload #4
/*     */     //   36: aload #5
/*     */     //   38: aload #6
/*     */     //   40: invokestatic glfwGetMonitorWorkarea : (JLjava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;)V
/*     */     //   43: aload #5
/*     */     //   45: iconst_0
/*     */     //   46: invokevirtual get : (I)I
/*     */     //   49: istore #5
/*     */     //   51: aload #6
/*     */     //   53: iconst_0
/*     */     //   54: invokevirtual get : (I)I
/*     */     //   57: istore #6
/*     */     //   59: iload_1
/*     */     //   60: iload #5
/*     */     //   62: if_icmple -> 80
/*     */     //   65: aload_0
/*     */     //   66: getfield virtualX : I
/*     */     //   69: istore_3
/*     */     //   70: aload #7
/*     */     //   72: getfield width : I
/*     */     //   75: istore #5
/*     */     //   77: goto -> 90
/*     */     //   80: aload_3
/*     */     //   81: iconst_0
/*     */     //   82: invokevirtual get : (I)I
/*     */     //   85: istore_3
/*     */     //   86: iload #5
/*     */     //   88: istore #5
/*     */     //   90: iload_2
/*     */     //   91: iload #6
/*     */     //   93: if_icmple -> 111
/*     */     //   96: aload_0
/*     */     //   97: getfield virtualY : I
/*     */     //   100: istore_0
/*     */     //   101: aload #7
/*     */     //   103: getfield height : I
/*     */     //   106: istore #4
/*     */     //   108: goto -> 122
/*     */     //   111: aload #4
/*     */     //   113: iconst_0
/*     */     //   114: invokevirtual get : (I)I
/*     */     //   117: istore_0
/*     */     //   118: iload #6
/*     */     //   120: istore #4
/*     */     //   122: new com/badlogic/gdx/math/GridPoint2
/*     */     //   125: dup
/*     */     //   126: iload_3
/*     */     //   127: dup
/*     */     //   128: iload #5
/*     */     //   130: iload_1
/*     */     //   131: isub
/*     */     //   132: iconst_2
/*     */     //   133: idiv
/*     */     //   134: iadd
/*     */     //   135: invokestatic max : (II)I
/*     */     //   138: iload_0
/*     */     //   139: dup
/*     */     //   140: iload #4
/*     */     //   142: iload_2
/*     */     //   143: isub
/*     */     //   144: iconst_2
/*     */     //   145: idiv
/*     */     //   146: iadd
/*     */     //   147: invokestatic max : (II)I
/*     */     //   150: invokespecial <init> : (II)V
/*     */     //   153: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #307	-> 0
/*     */     //   #308	-> 5
/*     */     //   #309	-> 11
/*     */     //   #310	-> 17
/*     */     //   #312	-> 23
/*     */     //   #314	-> 29
/*     */     //   #315	-> 43
/*     */     //   #316	-> 51
/*     */     //   #322	-> 59
/*     */     //   #323	-> 65
/*     */     //   #324	-> 70
/*     */     //   #326	-> 80
/*     */     //   #327	-> 86
/*     */     //   #330	-> 90
/*     */     //   #331	-> 96
/*     */     //   #332	-> 101
/*     */     //   #334	-> 111
/*     */     //   #335	-> 118
/*     */     //   #338	-> 122
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3ApplicationConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */