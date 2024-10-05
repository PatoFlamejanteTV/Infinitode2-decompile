/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class WGLARBMakeCurrentRead
/*    */ {
/*    */   public static final int ERROR_INVALID_PIXEL_TYPE_ARB = 8259;
/*    */   public static final int ERROR_INCOMPATIBLE_DEVICE_CONTEXTS_ARB = 8276;
/*    */   
/*    */   protected WGLARBMakeCurrentRead() {
/* 29 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglMakeContextCurrentARB(@NativeType("HDC") long paramLong1, @NativeType("HDC") long paramLong2, @NativeType("HGLRC") long paramLong3) {
/* 63 */     long l = (GL.getCapabilitiesWGL()).wglMakeContextCurrentARB;
/* 64 */     if (Checks.CHECKS) {
/* 65 */       Checks.check(l);
/* 66 */       Checks.check(paramLong1);
/* 67 */       Checks.check(paramLong2);
/* 68 */       Checks.check(paramLong3);
/*    */     } 
/* 70 */     return (JNI.callPPPI(paramLong1, paramLong2, paramLong3, l) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("HDC")
/*    */   public static long wglGetCurrentReadDCARB() {
/* 78 */     long l = (GL.getCapabilitiesWGL()).wglGetCurrentReadDCARB;
/* 79 */     if (Checks.CHECKS) {
/* 80 */       Checks.check(l);
/*    */     }
/* 82 */     return JNI.callP(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBMakeCurrentRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */