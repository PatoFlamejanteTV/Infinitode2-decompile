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
/*    */ 
/*    */ public class WGLNVDelayBeforeSwap
/*    */ {
/*    */   protected WGLNVDelayBeforeSwap() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   public static boolean wglDelayBeforeSwapNV(@NativeType("HDC") long paramLong, @NativeType("GLfloat") float paramFloat) {
/* 61 */     long l = (GL.getCapabilitiesWGL()).wglDelayBeforeSwapNV;
/* 62 */     if (Checks.CHECKS) {
/* 63 */       Checks.check(l);
/* 64 */       Checks.check(paramLong);
/*    */     } 
/* 66 */     return (JNI.callPI(paramLong, paramFloat, l) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLNVDelayBeforeSwap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */