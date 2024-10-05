/*     */ package org.lwjgl.opengl;public class GLX { public static final int GLXBadContext = 0; public static final int GLXBadContextState = 1; public static final int GLXBadDrawable = 2; public static final int GLXBadPixmap = 3; public static final int GLXBadContextTag = 4; public static final int GLXBadCurrentWindow = 5; public static final int GLXBadRenderRequest = 6; public static final int GLXBadLargeRequest = 7; public static final int GLXUnsupportedPrivateRequest = 8;
/*     */   public static final int GLXBadFBConfig = 9;
/*     */   public static final int GLXBadPbuffer = 10;
/*     */   public static final int GLXBadCurrentDrawable = 11;
/*     */   public static final int GLXBadWindow = 12;
/*     */   public static final int GLX_USE_GL = 1;
/*     */   public static final int GLX_BUFFER_SIZE = 2;
/*     */   public static final int GLX_LEVEL = 3;
/*     */   public static final int GLX_RGBA = 4;
/*     */   public static final int GLX_DOUBLEBUFFER = 5;
/*     */   public static final int GLX_STEREO = 6;
/*     */   public static final int GLX_AUX_BUFFERS = 7;
/*     */   public static final int GLX_RED_SIZE = 8;
/*     */   public static final int GLX_GREEN_SIZE = 9;
/*     */   public static final int GLX_BLUE_SIZE = 10;
/*     */   public static final int GLX_ALPHA_SIZE = 11;
/*     */   public static final int GLX_DEPTH_SIZE = 12;
/*     */   public static final int GLX_STENCIL_SIZE = 13;
/*     */   public static final int GLX_ACCUM_RED_SIZE = 14;
/*     */   public static final int GLX_ACCUM_GREEN_SIZE = 15;
/*     */   public static final int GLX_ACCUM_BLUE_SIZE = 16;
/*     */   public static final int GLX_ACCUM_ALPHA_SIZE = 17;
/*     */   public static final int GLX_BAD_SCREEN = 1;
/*     */   public static final int GLX_BAD_ATTRIBUTE = 2;
/*     */   public static final int GLX_NO_EXTENSION = 3;
/*     */   public static final int GLX_BAD_VISUAL = 4;
/*     */   public static final int GLX_BAD_CONTEXT = 5;
/*     */   public static final int GLX_BAD_VALUE = 6;
/*     */   public static final int GLX_BAD_ENUM = 7;
/*     */   
/*  31 */   public static final class Functions { public static final long QueryExtension = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryExtension");
/*  32 */     public static final long QueryVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryVersion");
/*  33 */     public static final long GetConfig = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetConfig");
/*  34 */     public static final long ChooseVisual = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXChooseVisual");
/*  35 */     public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateContext");
/*  36 */     public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXMakeCurrent");
/*  37 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCopyContext");
/*  38 */     public static final long IsDirect = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXIsDirect");
/*  39 */     public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyContext");
/*  40 */     public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentContext");
/*  41 */     public static final long GetCurrentDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentDrawable");
/*  42 */     public static final long WaitGL = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitGL");
/*  43 */     public static final long WaitX = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitX");
/*  44 */     public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXSwapBuffers");
/*  45 */     public static final long UseXFont = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXUseXFont");
/*  46 */     public static final long CreateGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateGLXPixmap");
/*  47 */     public static final long DestroyGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyGLXPixmap"); }
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
/*     */   protected GLX() {
/*  98 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryExtension(long paramLong1, long paramLong2, long paramLong3) {
/* 105 */     long l = Functions.QueryExtension;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(paramLong1);
/*     */     }
/* 109 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryExtension(@NativeType("Display *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(paramIntBuffer1, 1);
/* 123 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 125 */     return (nglXQueryExtension(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryVersion(long paramLong1, long paramLong2, long paramLong3) {
/* 132 */     long l = Functions.QueryVersion;
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(paramLong1);
/*     */     }
/* 136 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryVersion(@NativeType("Display *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(paramIntBuffer1, 1);
/* 150 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 152 */     return (nglXQueryVersion(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetConfig(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/* 159 */     long l = Functions.GetConfig;
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.check(paramLong1);
/* 162 */       XVisualInfo.validate(paramLong2);
/*     */     } 
/* 164 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static int glXGetConfig(@NativeType("Display *") long paramLong, @NativeType("XVisualInfo *") XVisualInfo paramXVisualInfo, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 176 */     if (Checks.CHECKS) {
/* 177 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 179 */     return nglXGetConfig(paramLong, paramXVisualInfo.address(), paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseVisual(long paramLong1, int paramInt, long paramLong2) {
/* 186 */     long l = Functions.ChooseVisual;
/* 187 */     if (Checks.CHECKS) {
/* 188 */       Checks.check(paramLong1);
/*     */     }
/* 190 */     return JNI.callPPP(paramLong1, paramInt, paramLong2, l);
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
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXChooseVisual(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/*     */     long l;
/* 210 */     return XVisualInfo.createSafe(l = nglXChooseVisual(paramLong, paramInt, MemoryUtil.memAddressSafe(paramIntBuffer)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateContext(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/* 217 */     long l = Functions.CreateContext;
/* 218 */     if (Checks.CHECKS) {
/* 219 */       Checks.check(paramLong1);
/* 220 */       XVisualInfo.validate(paramLong2);
/*     */     } 
/* 222 */     return JNI.callPPPP(paramLong1, paramLong2, paramLong3, paramInt, l);
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
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateContext(@NativeType("Display *") long paramLong1, @NativeType("XVisualInfo *") XVisualInfo paramXVisualInfo, @NativeType("GLXContext") long paramLong2, @NativeType("Bool") boolean paramBoolean) {
/* 235 */     return nglXCreateContext(paramLong1, paramXVisualInfo.address(), paramLong2, paramBoolean ? 1 : 0);
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
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeCurrent(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLXContext") long paramLong3) {
/* 249 */     long l = Functions.MakeCurrent;
/* 250 */     if (Checks.CHECKS) {
/* 251 */       Checks.check(paramLong1);
/*     */     }
/* 253 */     return (JNI.callPPPI(paramLong1, paramLong2, paramLong3, l) != 0);
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
/*     */   public static void glXCopyContext(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, @NativeType("GLXContext") long paramLong3, @NativeType("unsigned long") long paramLong4) {
/* 267 */     long l = Functions.CopyContext;
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(paramLong1);
/* 270 */       Checks.check(paramLong2);
/* 271 */       Checks.check(paramLong3);
/*     */     } 
/* 273 */     JNI.callPPPNV(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*     */   @NativeType("Bool")
/*     */   public static boolean glXIsDirect(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2) {
/* 286 */     long l = Functions.IsDirect;
/* 287 */     if (Checks.CHECKS) {
/* 288 */       Checks.check(paramLong1);
/* 289 */       Checks.check(paramLong2);
/*     */     } 
/* 291 */     return (JNI.callPPI(paramLong1, paramLong2, l) != 0);
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
/*     */   public static void glXDestroyContext(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2) {
/* 306 */     long l = Functions.DestroyContext;
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(paramLong1);
/* 309 */       Checks.check(paramLong2);
/*     */     } 
/* 311 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXGetCurrentContext() {
/*     */     long l;
/* 320 */     return JNI.callP(l = Functions.GetCurrentContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXDrawable")
/*     */   public static long glXGetCurrentDrawable() {
/*     */     long l;
/* 329 */     return JNI.callP(l = Functions.GetCurrentDrawable);
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
/*     */   public static void glXWaitGL() {
/*     */     long l;
/* 343 */     JNI.callV(l = Functions.WaitGL);
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
/*     */   public static void glXWaitX() {
/*     */     long l;
/* 356 */     JNI.callV(l = Functions.WaitX);
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
/*     */   public static void glXSwapBuffers(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2) {
/* 371 */     long l = Functions.SwapBuffers;
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(paramLong1);
/* 374 */       Checks.check(paramLong2);
/*     */     } 
/* 376 */     JNI.callPPV(paramLong1, paramLong2, l);
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
/*     */   public static void glXUseXFont(@NativeType("Font") long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 390 */     long l = Functions.UseXFont;
/* 391 */     JNI.callNV(paramLong, paramInt1, paramInt2, paramInt3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateGLXPixmap(long paramLong1, long paramLong2, long paramLong3) {
/* 398 */     long l = Functions.CreateGLXPixmap;
/* 399 */     if (Checks.CHECKS) {
/* 400 */       Checks.check(paramLong1);
/* 401 */       XVisualInfo.validate(paramLong2);
/*     */     } 
/* 403 */     return JNI.callPPNP(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreateGLXPixmap(@NativeType("Display *") long paramLong1, @NativeType("XVisualInfo *") XVisualInfo paramXVisualInfo, @NativeType("Pixmap") long paramLong2) {
/* 415 */     return nglXCreateGLXPixmap(paramLong1, paramXVisualInfo.address(), paramLong2);
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
/*     */   public static void glXDestroyGLXPixmap(@NativeType("Display *") long paramLong1, @NativeType("GLXPixmap") long paramLong2) {
/* 427 */     long l = Functions.DestroyGLXPixmap;
/* 428 */     if (Checks.CHECKS) {
/* 429 */       Checks.check(paramLong1);
/* 430 */       Checks.check(paramLong2);
/*     */     } 
/* 432 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryExtension(@NativeType("Display *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 438 */     long l = Functions.QueryExtension;
/* 439 */     if (Checks.CHECKS) {
/* 440 */       Checks.check(paramLong);
/* 441 */       Checks.check(paramArrayOfint1, 1);
/* 442 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 444 */     return (JNI.callPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryVersion(@NativeType("Display *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 450 */     long l = Functions.QueryVersion;
/* 451 */     if (Checks.CHECKS) {
/* 452 */       Checks.check(paramLong);
/* 453 */       Checks.check(paramArrayOfint1, 1);
/* 454 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 456 */     return (JNI.callPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetConfig(@NativeType("Display *") long paramLong, @NativeType("XVisualInfo *") XVisualInfo paramXVisualInfo, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 461 */     long l = Functions.GetConfig;
/* 462 */     if (Checks.CHECKS) {
/* 463 */       Checks.check(paramLong);
/* 464 */       Checks.check(paramArrayOfint, 1);
/* 465 */       XVisualInfo.validate(paramXVisualInfo.address());
/*     */     } 
/* 467 */     return JNI.callPPPI(paramLong, paramXVisualInfo.address(), paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXChooseVisual(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 474 */     long l1 = Functions.ChooseVisual;
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(paramLong);
/* 477 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/*     */     long l2;
/* 480 */     return XVisualInfo.createSafe(l2 = JNI.callPPP(paramLong, paramInt, paramArrayOfint, l1));
/*     */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */