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
/*    */ public class WGLEXTSwapControl
/*    */ {
/*    */   protected WGLEXTSwapControl() {
/* 23 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("BOOL")
/*    */   public static boolean wglSwapIntervalEXT(int paramInt) {
/* 45 */     long l = (GL.getCapabilitiesWGL()).wglSwapIntervalEXT;
/* 46 */     if (Checks.CHECKS) {
/* 47 */       Checks.check(l);
/*    */     }
/* 49 */     return (JNI.callI(paramInt, l) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int wglGetSwapIntervalEXT() {
/* 56 */     long l = (GL.getCapabilitiesWGL()).wglGetSwapIntervalEXT;
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(l);
/*    */     }
/* 60 */     return JNI.callI(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLEXTSwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */