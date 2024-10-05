/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
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
/*     */ public class GLXARBCreateContext
/*     */ {
/*     */   public static final int GLX_CONTEXT_MAJOR_VERSION_ARB = 8337;
/*     */   public static final int GLX_CONTEXT_MINOR_VERSION_ARB = 8338;
/*     */   public static final int GLX_CONTEXT_FLAGS_ARB = 8340;
/*     */   public static final int GLX_CONTEXT_DEBUG_BIT_ARB = 1;
/*     */   public static final int GLX_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
/*     */   
/*     */   protected GLXARBCreateContext() {
/*  42 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateContextAttribsARB(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4) {
/*  49 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateContextAttribsARB;
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(l);
/*  52 */       Checks.check(paramLong1);
/*  53 */       Checks.check(paramLong2);
/*     */     } 
/*  55 */     return JNI.callPPPPP(paramLong1, paramLong2, paramLong3, paramInt, paramLong4, l);
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
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateContextAttribsARB(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("GLXContext") long paramLong3, @NativeType("Bool") boolean paramBoolean, @NativeType("int const *") IntBuffer paramIntBuffer) {
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/*  91 */     return nglXCreateContextAttribsARB(paramLong1, paramLong2, paramLong3, paramBoolean ? 1 : 0, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateContextAttribsARB(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("GLXContext") long paramLong3, @NativeType("Bool") boolean paramBoolean, @NativeType("int const *") int[] paramArrayOfint) {
/*  97 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateContextAttribsARB;
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(l);
/* 100 */       Checks.check(paramLong1);
/* 101 */       Checks.check(paramLong2);
/* 102 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 104 */     return JNI.callPPPPP(paramLong1, paramLong2, paramLong3, paramBoolean ? 1 : 0, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXARBCreateContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */