/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class GLX11
/*     */   extends GLX
/*     */ {
/*     */   public static final int GLX_VENDOR = 1;
/*     */   public static final int GLX_VERSION = 2;
/*     */   public static final int GLX_EXTENSIONS = 3;
/*     */   
/*     */   protected GLX11() {
/*  26 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXQueryExtensionsString(long paramLong, int paramInt) {
/*  33 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryExtensionsString;
/*  34 */     if (Checks.CHECKS) {
/*  35 */       Checks.check(l);
/*  36 */       Checks.check(paramLong);
/*     */     } 
/*  38 */     return JNI.callPP(paramLong, paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String glXQueryExtensionsString(@NativeType("Display *") long paramLong, int paramInt) {
/*     */     long l;
/*  51 */     return MemoryUtil.memASCIISafe(l = nglXQueryExtensionsString(paramLong, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetClientString(long paramLong, int paramInt) {
/*  58 */     long l = (GL.getCapabilitiesGLXClient()).glXGetClientString;
/*  59 */     if (Checks.CHECKS) {
/*  60 */       Checks.check(l);
/*  61 */       Checks.check(paramLong);
/*     */     } 
/*  63 */     return JNI.callPP(paramLong, paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String glXGetClientString(@NativeType("Display *") long paramLong, int paramInt) {
/*     */     long l;
/*  76 */     return MemoryUtil.memASCIISafe(l = nglXGetClientString(paramLong, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXQueryServerString(long paramLong, int paramInt1, int paramInt2) {
/*  83 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryServerString;
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.check(l);
/*  86 */       Checks.check(paramLong);
/*     */     } 
/*  88 */     return JNI.callPP(paramLong, paramInt1, paramInt2, l);
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
/*     */   @NativeType("char const *")
/*     */   public static String glXQueryServerString(@NativeType("Display *") long paramLong, int paramInt1, int paramInt2) {
/*     */     long l;
/* 102 */     return MemoryUtil.memASCIISafe(l = nglXQueryServerString(paramLong, paramInt1, paramInt2));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLX11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */