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
/*     */ public class WGLARBPbuffer
/*     */ {
/*     */   public static final int WGL_DRAW_TO_PBUFFER_ARB = 8237;
/*     */   public static final int WGL_MAX_PBUFFER_PIXELS_ARB = 8238;
/*     */   public static final int WGL_MAX_PBUFFER_WIDTH_ARB = 8239;
/*     */   public static final int WGL_MAX_PBUFFER_HEIGHT_ARB = 8240;
/*     */   public static final int WGL_PBUFFER_LARGEST_ARB = 8243;
/*     */   public static final int WGL_PBUFFER_WIDTH_ARB = 8244;
/*     */   public static final int WGL_PBUFFER_HEIGHT_ARB = 8245;
/*     */   public static final int WGL_PBUFFER_LOST_ARB = 8246;
/*     */   
/*     */   protected WGLARBPbuffer() {
/*  65 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreatePbufferARB(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2) {
/*  72 */     long l = (GL.getCapabilitiesWGL()).wglCreatePbufferARB;
/*  73 */     if (Checks.CHECKS) {
/*  74 */       Checks.check(l);
/*  75 */       Checks.check(paramLong1);
/*     */     } 
/*  77 */     return JNI.callPPP(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, l);
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
/*     */   @NativeType("HPBUFFERARB")
/*     */   public static long wglCreatePbufferARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("int const *") IntBuffer paramIntBuffer) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/*  97 */     return nwglCreatePbufferARB(paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HDC")
/*     */   public static long wglGetPbufferDCARB(@NativeType("HPBUFFERARB") long paramLong) {
/* 109 */     long l = (GL.getCapabilitiesWGL()).wglGetPbufferDCARB;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(l);
/* 112 */       Checks.check(paramLong);
/*     */     } 
/* 114 */     return JNI.callPP(paramLong, l);
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
/*     */   public static int wglReleasePbufferDCARB(@NativeType("HPBUFFERARB") long paramLong1, @NativeType("HDC") long paramLong2) {
/* 126 */     long l = (GL.getCapabilitiesWGL()).wglReleasePbufferDCARB;
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(l);
/* 129 */       Checks.check(paramLong1);
/* 130 */       Checks.check(paramLong2);
/*     */     } 
/* 132 */     return JNI.callPPI(paramLong1, paramLong2, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDestroyPbufferARB(@NativeType("HPBUFFERARB") long paramLong) {
/* 147 */     long l = (GL.getCapabilitiesWGL()).wglDestroyPbufferARB;
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(l);
/* 150 */       Checks.check(paramLong);
/*     */     } 
/* 152 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryPbufferARB(long paramLong1, int paramInt, long paramLong2) {
/* 159 */     long l = (GL.getCapabilitiesWGL()).wglQueryPbufferARB;
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.check(l);
/* 162 */       Checks.check(paramLong1);
/*     */     } 
/* 164 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryPbufferARB(@NativeType("HPBUFFERARB") long paramLong, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 176 */     if (Checks.CHECKS) {
/* 177 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 179 */     return (nwglQueryPbufferARB(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HPBUFFERARB")
/*     */   public static long wglCreatePbufferARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("int const *") int[] paramArrayOfint) {
/* 185 */     long l = (GL.getCapabilitiesWGL()).wglCreatePbufferARB;
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(l);
/* 188 */       Checks.check(paramLong);
/* 189 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 191 */     return JNI.callPPP(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryPbufferARB(@NativeType("HPBUFFERARB") long paramLong, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 197 */     long l = (GL.getCapabilitiesWGL()).wglQueryPbufferARB;
/* 198 */     if (Checks.CHECKS) {
/* 199 */       Checks.check(l);
/* 200 */       Checks.check(paramLong);
/* 201 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 203 */     return (JNI.callPPI(paramLong, paramInt, paramArrayOfint, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBPbuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */