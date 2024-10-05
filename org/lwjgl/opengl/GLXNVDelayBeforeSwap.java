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
/*    */ public class GLXNVDelayBeforeSwap
/*    */ {
/*    */   protected GLXNVDelayBeforeSwap() {
/* 25 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("Bool")
/*    */   public static boolean glXDelayBeforeSwapNV(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLfloat") float paramFloat) {
/* 56 */     long l = (GL.getCapabilitiesGLXClient()).glXDelayBeforeSwapNV;
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(l);
/* 59 */       Checks.check(paramLong1);
/* 60 */       Checks.check(paramLong2);
/*    */     } 
/* 62 */     return (JNI.callPPI(paramLong1, paramLong2, paramFloat, l) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXNVDelayBeforeSwap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */