/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGLARBBufferRegion
/*     */ {
/*     */   public static final int WGL_FRONT_COLOR_BUFFER_BIT_ARB = 1;
/*     */   public static final int WGL_BACK_COLOR_BUFFER_BIT_ARB = 2;
/*     */   public static final int WGL_DEPTH_BUFFER_BIT_ARB = 4;
/*     */   public static final int WGL_STENCIL_BUFFER_BIT_ARB = 8;
/*     */   
/*     */   protected WGLARBBufferRegion() {
/*  32 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("HANDLE")
/*     */   public static long wglCreateBufferRegionARB(@NativeType("HDC") long paramLong, int paramInt1, @NativeType("UINT") int paramInt2) {
/*  47 */     long l = (GL.getCapabilitiesWGL()).wglCreateBufferRegionARB;
/*  48 */     if (Checks.CHECKS) {
/*  49 */       Checks.check(l);
/*  50 */       Checks.check(paramLong);
/*     */     } 
/*  52 */     return JNI.callPP(paramLong, paramInt1, paramInt2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("VOID")
/*     */   public static void wglDeleteBufferRegionARB(@NativeType("HANDLE") long paramLong) {
/*  64 */     long l = (GL.getCapabilitiesWGL()).wglDeleteBufferRegionARB;
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(l);
/*  67 */       Checks.check(paramLong);
/*     */     } 
/*  69 */     JNI.callPV(paramLong, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglSaveBufferRegionARB(@NativeType("HANDLE") long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  92 */     long l = (GL.getCapabilitiesWGL()).wglSaveBufferRegionARB;
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(l);
/*  95 */       Checks.check(paramLong);
/*     */     } 
/*  97 */     return (JNI.callPI(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, l) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglRestoreBufferRegionARB(@NativeType("HANDLE") long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 115 */     long l = (GL.getCapabilitiesWGL()).wglRestoreBufferRegionARB;
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.check(l);
/* 118 */       Checks.check(paramLong);
/*     */     } 
/* 120 */     return (JNI.callPI(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBBufferRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */