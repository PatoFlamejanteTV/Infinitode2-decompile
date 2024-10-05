/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WGLARBCreateContext
/*    */ {
/*    */   public static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 8337;
/*    */   public static final int WGL_CONTEXT_MINOR_VERSION_ARB = 8338;
/*    */   public static final int WGL_CONTEXT_LAYER_PLANE_ARB = 8339;
/*    */   public static final int WGL_CONTEXT_FLAGS_ARB = 8340;
/*    */   public static final int WGL_CONTEXT_DEBUG_BIT_ARB = 1;
/*    */   public static final int WGL_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
/*    */   public static final int ERROR_INVALID_VERSION_ARB = 8341;
/*    */   
/*    */   protected WGLARBCreateContext() {
/* 45 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglCreateContextAttribsARB(long paramLong1, long paramLong2, long paramLong3) {
/* 52 */     long l = (GL.getCapabilitiesWGL()).wglCreateContextAttribsARB;
/* 53 */     if (Checks.CHECKS) {
/* 54 */       Checks.check(l);
/* 55 */       Checks.check(paramLong1);
/*    */     } 
/* 57 */     return JNI.callPPPP(paramLong1, paramLong2, paramLong3, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HGLRC")
/*    */   public static long wglCreateContextAttribsARB(@NativeType("HDC") long paramLong1, @NativeType("HGLRC") long paramLong2, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.checkNTSafe(paramIntBuffer);
/*    */     }
/* 75 */     return nwglCreateContextAttribsARB(paramLong1, paramLong2, MemoryUtil.memAddressSafe(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("HGLRC")
/*    */   public static long wglCreateContextAttribsARB(@NativeType("HDC") long paramLong1, @NativeType("HGLRC") long paramLong2, @NativeType("int const *") int[] paramArrayOfint) {
/* 81 */     long l = (GL.getCapabilitiesWGL()).wglCreateContextAttribsARB;
/* 82 */     if (Checks.CHECKS) {
/* 83 */       Checks.check(l);
/* 84 */       Checks.check(paramLong1);
/* 85 */       Checks.checkNTSafe(paramArrayOfint);
/*    */     } 
/* 87 */     return JNI.callPPPP(paramLong1, paramLong2, paramArrayOfint, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBCreateContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */