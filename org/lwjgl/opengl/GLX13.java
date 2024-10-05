/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.CLongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.linux.XVisualInfo;
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
/*     */ public class GLX13
/*     */   extends GLX12
/*     */ {
/*     */   public static final int GLX_WINDOW_BIT = 1;
/*     */   public static final int GLX_PIXMAP_BIT = 2;
/*     */   public static final int GLX_PBUFFER_BIT = 4;
/*     */   public static final int GLX_RGBA_BIT = 1;
/*     */   public static final int GLX_COLOR_INDEX_BIT = 2;
/*     */   public static final int GLX_PBUFFER_CLOBBER_MASK = 134217728;
/*     */   public static final int GLX_FRONT_LEFT_BUFFER_BIT = 1;
/*     */   public static final int GLX_FRONT_RIGHT_BUFFER_BIT = 2;
/*     */   public static final int GLX_BACK_LEFT_BUFFER_BIT = 4;
/*     */   public static final int GLX_BACK_RIGHT_BUFFER_BIT = 8;
/*     */   public static final int GLX_AUX_BUFFERS_BIT = 16;
/*     */   public static final int GLX_DEPTH_BUFFER_BIT = 32;
/*     */   public static final int GLX_STENCIL_BUFFER_BIT = 64;
/*     */   public static final int GLX_ACCUM_BUFFER_BIT = 128;
/*     */   public static final int GLX_CONFIG_CAVEAT = 32;
/*     */   public static final int GLX_X_VISUAL_TYPE = 34;
/*     */   public static final int GLX_TRANSPARENT_TYPE = 35;
/*     */   public static final int GLX_TRANSPARENT_INDEX_VALUE = 36;
/*     */   public static final int GLX_TRANSPARENT_RED_VALUE = 37;
/*     */   public static final int GLX_TRANSPARENT_GREEN_VALUE = 38;
/*     */   public static final int GLX_TRANSPARENT_BLUE_VALUE = 39;
/*     */   public static final int GLX_TRANSPARENT_ALPHA_VALUE = 40;
/*     */   public static final int GLX_DONT_CARE = -1;
/*     */   public static final int GLX_NONE = 32768;
/*     */   public static final int GLX_SLOW_CONFIG = 32769;
/*     */   public static final int GLX_TRUE_COLOR = 32770;
/*     */   public static final int GLX_DIRECT_COLOR = 32771;
/*     */   public static final int GLX_PSEUDO_COLOR = 32772;
/*     */   public static final int GLX_STATIC_COLOR = 32773;
/*     */   public static final int GLX_GRAY_SCALE = 32774;
/*     */   public static final int GLX_STATIC_GRAY = 32775;
/*     */   public static final int GLX_TRANSPARENT_RGB = 32776;
/*     */   public static final int GLX_TRANSPARENT_INDEX = 32777;
/*     */   public static final int GLX_VISUAL_ID = 32779;
/*     */   public static final int GLX_SCREEN = 32780;
/*     */   public static final int GLX_NON_CONFORMANT_CONFIG = 32781;
/*     */   public static final int GLX_DRAWABLE_TYPE = 32784;
/*     */   public static final int GLX_RENDER_TYPE = 32785;
/*     */   public static final int GLX_X_RENDERABLE = 32786;
/*     */   public static final int GLX_FBCONFIG_ID = 32787;
/*     */   public static final int GLX_RGBA_TYPE = 32788;
/*     */   public static final int GLX_COLOR_INDEX_TYPE = 32789;
/*     */   public static final int GLX_MAX_PBUFFER_WIDTH = 32790;
/*     */   public static final int GLX_MAX_PBUFFER_HEIGHT = 32791;
/*     */   public static final int GLX_MAX_PBUFFER_PIXELS = 32792;
/*     */   public static final int GLX_PRESERVED_CONTENTS = 32795;
/*     */   public static final int GLX_LARGEST_PBUFFER = 32796;
/*     */   public static final int GLX_WIDTH = 32797;
/*     */   public static final int GLX_HEIGHT = 32798;
/*     */   public static final int GLX_EVENT_MASK = 32799;
/*     */   public static final int GLX_DAMAGED = 32800;
/*     */   public static final int GLX_SAVED = 32801;
/*     */   public static final int GLX_WINDOW = 32802;
/*     */   public static final int GLX_PBUFFER = 32803;
/*     */   public static final int GLX_PBUFFER_HEIGHT = 32832;
/*     */   public static final int GLX_PBUFFER_WIDTH = 32833;
/*     */   
/*     */   protected GLX13() {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetFBConfigs(long paramLong1, int paramInt, long paramLong2) {
/*  97 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigs;
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(l);
/* 100 */       Checks.check(paramLong1);
/*     */     } 
/* 102 */     return JNI.callPPP(paramLong1, paramInt, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXGetFBConfigs(@NativeType("Display *") long paramLong, int paramInt) {
/*     */     MemoryStack memoryStack;
/* 114 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 115 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l;
/* 118 */       return MemoryUtil.memPointerBufferSafe(l = nglXGetFBConfigs(paramLong, paramInt, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*     */     } finally {
/* 120 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseFBConfig(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/* 132 */     long l = (GL.getCapabilitiesGLXClient()).glXChooseFBConfig;
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(l);
/* 135 */       Checks.check(paramLong1);
/*     */     } 
/* 137 */     return JNI.callPPPP(paramLong1, paramInt, paramLong2, paramLong3, l);
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
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXChooseFBConfig(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 150 */     if (Checks.CHECKS)
/* 151 */       Checks.checkNTSafe(paramIntBuffer); 
/*     */     MemoryStack memoryStack;
/* 153 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 154 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l;
/* 157 */       return MemoryUtil.memPointerBufferSafe(l = nglXChooseFBConfig(paramLong, paramInt, MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*     */     } finally {
/* 159 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetFBConfigAttrib(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/* 167 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttrib;
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check(l);
/* 170 */       Checks.check(paramLong1);
/* 171 */       Checks.check(paramLong2);
/*     */     } 
/* 173 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static int glXGetFBConfigAttrib(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 188 */     return nglXGetFBConfigAttrib(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetVisualFromFBConfig(long paramLong1, long paramLong2) {
/* 195 */     long l = (GL.getCapabilitiesGLXClient()).glXGetVisualFromFBConfig;
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(l);
/* 198 */       Checks.check(paramLong1);
/* 199 */       Checks.check(paramLong2);
/*     */     } 
/* 201 */     return JNI.callPPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXGetVisualFromFBConfig(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2) {
/*     */     long l;
/* 214 */     return XVisualInfo.createSafe(l = nglXGetVisualFromFBConfig(paramLong1, paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateWindow(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 221 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateWindow;
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(l);
/* 224 */       Checks.check(paramLong1);
/* 225 */       Checks.check(paramLong2);
/*     */     } 
/* 227 */     return JNI.callPPNPP(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*     */   @NativeType("GLXWindow")
/*     */   public static long glXCreateWindow(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("Window") long paramLong3, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 243 */     return nglXCreateWindow(paramLong1, paramLong2, paramLong3, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreatePixmap(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 250 */     long l = (GL.getCapabilitiesGLXClient()).glXCreatePixmap;
/* 251 */     if (Checks.CHECKS) {
/* 252 */       Checks.check(l);
/* 253 */       Checks.check(paramLong1);
/* 254 */       Checks.check(paramLong2);
/*     */     } 
/* 256 */     return JNI.callPPNPP(paramLong1, paramLong2, paramLong3, paramLong4, l);
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
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreatePixmap(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("Pixmap") long paramLong3, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 269 */     if (Checks.CHECKS) {
/* 270 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 272 */     return nglXCreatePixmap(paramLong1, paramLong2, paramLong3, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glXDestroyPixmap(@NativeType("Display *") long paramLong1, @NativeType("GLXPixmap") long paramLong2) {
/* 284 */     long l = (GL.getCapabilitiesGLXClient()).glXDestroyPixmap;
/* 285 */     if (Checks.CHECKS) {
/* 286 */       Checks.check(l);
/* 287 */       Checks.check(paramLong1);
/* 288 */       Checks.check(paramLong2);
/*     */     } 
/* 290 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreatePbuffer(long paramLong1, long paramLong2, long paramLong3) {
/* 297 */     long l = (GL.getCapabilitiesGLXClient()).glXCreatePbuffer;
/* 298 */     if (Checks.CHECKS) {
/* 299 */       Checks.check(l);
/* 300 */       Checks.check(paramLong1);
/* 301 */       Checks.check(paramLong2);
/*     */     } 
/* 303 */     return JNI.callPPPP(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreatePbuffer(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 315 */     if (Checks.CHECKS) {
/* 316 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 318 */     return nglXCreatePbuffer(paramLong1, paramLong2, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glXDestroyPbuffer(@NativeType("Display *") long paramLong1, @NativeType("GLXPbuffer") long paramLong2) {
/* 330 */     long l = (GL.getCapabilitiesGLXClient()).glXDestroyPbuffer;
/* 331 */     if (Checks.CHECKS) {
/* 332 */       Checks.check(l);
/* 333 */       Checks.check(paramLong1);
/* 334 */       Checks.check(paramLong2);
/*     */     } 
/* 336 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXQueryDrawable(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/* 343 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryDrawable;
/* 344 */     if (Checks.CHECKS) {
/* 345 */       Checks.check(l);
/* 346 */       Checks.check(paramLong1);
/* 347 */       Checks.check(paramLong2);
/*     */     } 
/* 349 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static void glXQueryDrawable(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt, @NativeType("unsigned int *") IntBuffer paramIntBuffer) {
/* 361 */     if (Checks.CHECKS) {
/* 362 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 364 */     nglXQueryDrawable(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glXQueryDrawable(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt) {
/*     */     MemoryStack memoryStack;
/* 376 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 378 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 379 */       nglXQueryDrawable(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(intBuffer));
/* 380 */       return intBuffer.get(0);
/*     */     } finally {
/* 382 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateNewContext(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, int paramInt, @NativeType("GLXContext") long paramLong3, @NativeType("Bool") boolean paramBoolean) {
/* 399 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateNewContext;
/* 400 */     if (Checks.CHECKS) {
/* 401 */       Checks.check(l);
/* 402 */       Checks.check(paramLong1);
/* 403 */       Checks.check(paramLong2);
/*     */     } 
/* 405 */     return JNI.callPPPP(paramLong1, paramLong2, paramInt, paramLong3, paramBoolean ? 1 : 0, l);
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
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeContextCurrent(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLXDrawable") long paramLong3, @NativeType("GLXContext") long paramLong4) {
/* 420 */     long l = (GL.getCapabilitiesGLXClient()).glXMakeContextCurrent;
/* 421 */     if (Checks.CHECKS) {
/* 422 */       Checks.check(l);
/* 423 */       Checks.check(paramLong1);
/*     */     } 
/* 425 */     return (JNI.callPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXDrawable")
/*     */   public static long glXGetCurrentReadDrawable() {
/* 433 */     long l = (GL.getCapabilitiesGLXClient()).glXGetCurrentReadDrawable;
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.check(l);
/*     */     }
/* 437 */     return JNI.callP(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryContext(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/* 444 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryContext;
/* 445 */     if (Checks.CHECKS) {
/* 446 */       Checks.check(l);
/* 447 */       Checks.check(paramLong1);
/* 448 */       Checks.check(paramLong2);
/*     */     } 
/* 450 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static int glXQueryContext(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 462 */     if (Checks.CHECKS) {
/* 463 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 465 */     return nglXQueryContext(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glXSelectEvent(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("unsigned long") long paramLong3) {
/* 478 */     long l = (GL.getCapabilitiesGLXClient()).glXSelectEvent;
/* 479 */     if (Checks.CHECKS) {
/* 480 */       Checks.check(l);
/* 481 */       Checks.check(paramLong1);
/* 482 */       Checks.check(paramLong2);
/*     */     } 
/* 484 */     JNI.callPPNV(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXGetSelectedEvent(long paramLong1, long paramLong2, long paramLong3) {
/* 491 */     long l = (GL.getCapabilitiesGLXClient()).glXGetSelectedEvent;
/* 492 */     if (Checks.CHECKS) {
/* 493 */       Checks.check(l);
/* 494 */       Checks.check(paramLong1);
/* 495 */       Checks.check(paramLong2);
/*     */     } 
/* 497 */     JNI.callPPPV(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXGetSelectedEvent(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("unsigned long *") CLongBuffer paramCLongBuffer) {
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check((CustomBuffer)paramCLongBuffer, 1);
/*     */     }
/* 511 */     nglXGetSelectedEvent(paramLong1, paramLong2, MemoryUtil.memAddress((CustomBuffer)paramCLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXChooseFBConfig(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int const *") int[] paramArrayOfint) {
/* 518 */     long l = (GL.getCapabilitiesGLXClient()).glXChooseFBConfig;
/* 519 */     if (Checks.CHECKS) {
/* 520 */       Checks.check(l);
/* 521 */       Checks.check(paramLong);
/* 522 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     }  MemoryStack memoryStack;
/* 524 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 525 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l1;
/* 528 */       return MemoryUtil.memPointerBufferSafe(l1 = JNI.callPPPP(paramLong, paramInt, paramArrayOfint, MemoryUtil.memAddress(intBuffer), l), intBuffer.get(0));
/*     */     } finally {
/* 530 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttrib(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 536 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttrib;
/* 537 */     if (Checks.CHECKS) {
/* 538 */       Checks.check(l);
/* 539 */       Checks.check(paramLong1);
/* 540 */       Checks.check(paramLong2);
/* 541 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 543 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXWindow")
/*     */   public static long glXCreateWindow(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("Window") long paramLong3, @NativeType("int const *") int[] paramArrayOfint) {
/* 549 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateWindow;
/* 550 */     if (Checks.CHECKS) {
/* 551 */       Checks.check(l);
/* 552 */       Checks.check(paramLong1);
/* 553 */       Checks.check(paramLong2);
/* 554 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 556 */     return JNI.callPPNPP(paramLong1, paramLong2, paramLong3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreatePixmap(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("Pixmap") long paramLong3, @NativeType("int const *") int[] paramArrayOfint) {
/* 562 */     long l = (GL.getCapabilitiesGLXClient()).glXCreatePixmap;
/* 563 */     if (Checks.CHECKS) {
/* 564 */       Checks.check(l);
/* 565 */       Checks.check(paramLong1);
/* 566 */       Checks.check(paramLong2);
/* 567 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 569 */     return JNI.callPPNPP(paramLong1, paramLong2, paramLong3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreatePbuffer(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("int const *") int[] paramArrayOfint) {
/* 575 */     long l = (GL.getCapabilitiesGLXClient()).glXCreatePbuffer;
/* 576 */     if (Checks.CHECKS) {
/* 577 */       Checks.check(l);
/* 578 */       Checks.check(paramLong1);
/* 579 */       Checks.check(paramLong2);
/* 580 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 582 */     return JNI.callPPPP(paramLong1, paramLong2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryDrawable(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt, @NativeType("unsigned int *") int[] paramArrayOfint) {
/* 587 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryDrawable;
/* 588 */     if (Checks.CHECKS) {
/* 589 */       Checks.check(l);
/* 590 */       Checks.check(paramLong1);
/* 591 */       Checks.check(paramLong2);
/* 592 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 594 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContext(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 599 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryContext;
/* 600 */     if (Checks.CHECKS) {
/* 601 */       Checks.check(l);
/* 602 */       Checks.check(paramLong1);
/* 603 */       Checks.check(paramLong2);
/* 604 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 606 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLX13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */