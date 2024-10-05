/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class GLXSGIXFBConfig
/*     */ {
/*     */   public static final int GLX_DRAWABLE_TYPE_SGIX = 32784;
/*     */   public static final int GLX_RENDER_TYPE_SGIX = 32785;
/*     */   public static final int GLX_X_RENDERABLE_SGIX = 32786;
/*     */   public static final int GLX_FBCONFIG_ID_SGIX = 32787;
/*     */   public static final int GLX_SCREEN_EXT = 32780;
/*     */   public static final int GLX_WINDOW_BIT_SGIX = 1;
/*     */   public static final int GLX_PIXMAP_BIT_SGIX = 2;
/*     */   public static final int GLX_RGBA_BIT_SGIX = 1;
/*     */   public static final int GLX_COLOR_INDEX_BIT_SGIX = 2;
/*     */   public static final int GLX_RGBA_TYPE_SGIX = 32788;
/*     */   public static final int GLX_COLOR_INDEX_TYPE_SGIX = 32789;
/*     */   
/*     */   protected GLXSGIXFBConfig() {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetFBConfigAttribSGIX(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/*  77 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttribSGIX;
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check(l);
/*  80 */       Checks.check(paramLong1);
/*  81 */       Checks.check(paramLong2);
/*     */     } 
/*  83 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static int glXGetFBConfigAttribSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfigSGIX") long paramLong2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  98 */     return nglXGetFBConfigAttribSGIX(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseFBConfigSGIX(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/* 109 */     long l = (GL.getCapabilitiesGLXClient()).glXChooseFBConfigSGIX;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(l);
/* 112 */       Checks.check(paramLong1);
/*     */     } 
/* 114 */     return JNI.callPPPP(paramLong1, paramInt, paramLong2, paramLong3, l);
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
/*     */   @NativeType("GLXFBConfigSGIX *")
/*     */   public static PointerBuffer glXChooseFBConfigSGIX(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 127 */     if (Checks.CHECKS)
/* 128 */       Checks.checkNTSafe(paramIntBuffer); 
/*     */     MemoryStack memoryStack;
/* 130 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 131 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l;
/* 134 */       return MemoryUtil.memPointerBufferSafe(l = nglXChooseFBConfigSGIX(paramLong, paramInt, MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*     */     } finally {
/* 136 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreateGLXPixmapWithConfigSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("Pixmap") long paramLong3) {
/* 151 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateGLXPixmapWithConfigSGIX;
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.check(l);
/* 154 */       Checks.check(paramLong1);
/* 155 */       Checks.check(paramLong2);
/*     */     } 
/* 157 */     return JNI.callPPNP(paramLong1, paramLong2, paramLong3, l);
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
/*     */   public static long glXCreateContextWithConfigSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, int paramInt, @NativeType("GLXContext") long paramLong3, @NativeType("Bool") boolean paramBoolean) {
/* 173 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateContextWithConfigSGIX;
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(l);
/* 176 */       Checks.check(paramLong1);
/* 177 */       Checks.check(paramLong2);
/* 178 */       Checks.check(paramLong3);
/*     */     } 
/* 180 */     return JNI.callPPPP(paramLong1, paramLong2, paramInt, paramLong3, paramBoolean ? 1 : 0, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetVisualFromFBConfigSGIX(long paramLong1, long paramLong2) {
/* 187 */     long l = (GL.getCapabilitiesGLXClient()).glXGetVisualFromFBConfigSGIX;
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.check(l);
/* 190 */       Checks.check(paramLong1);
/* 191 */       Checks.check(paramLong2);
/*     */     } 
/* 193 */     return JNI.callPPP(paramLong1, paramLong2, l);
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
/*     */   public static XVisualInfo glXGetVisualFromFBConfigSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2) {
/*     */     long l;
/* 206 */     return XVisualInfo.createSafe(l = nglXGetVisualFromFBConfigSGIX(paramLong1, paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetFBConfigFromVisualSGIX(long paramLong1, long paramLong2) {
/* 213 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigFromVisualSGIX;
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(l);
/* 216 */       Checks.check(paramLong1);
/* 217 */       XVisualInfo.validate(paramLong2);
/*     */     } 
/* 219 */     return JNI.callPPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfigSGIX")
/*     */   public static long glXGetFBConfigFromVisualSGIX(@NativeType("Display *") long paramLong, @NativeType("XVisualInfo *") XVisualInfo paramXVisualInfo) {
/* 230 */     return nglXGetFBConfigFromVisualSGIX(paramLong, paramXVisualInfo.address());
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttribSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfigSGIX") long paramLong2, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 235 */     long l = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttribSGIX;
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(l);
/* 238 */       Checks.check(paramLong1);
/* 239 */       Checks.check(paramLong2);
/* 240 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 242 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfigSGIX *")
/*     */   public static PointerBuffer glXChooseFBConfigSGIX(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int const *") int[] paramArrayOfint) {
/* 249 */     long l = (GL.getCapabilitiesGLXClient()).glXChooseFBConfigSGIX;
/* 250 */     if (Checks.CHECKS) {
/* 251 */       Checks.check(l);
/* 252 */       Checks.check(paramLong);
/* 253 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     }  MemoryStack memoryStack;
/* 255 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 256 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l1;
/* 259 */       return MemoryUtil.memPointerBufferSafe(l1 = JNI.callPPPP(paramLong, paramInt, paramArrayOfint, MemoryUtil.memAddress(intBuffer), l), intBuffer.get(0));
/*     */     } finally {
/* 261 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIXFBConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */