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
/*    */ public class GLXSGISwapControl
/*    */ {
/*    */   protected GLXSGISwapControl() {
/* 21 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("GLint")
/*    */   public static int glXSwapIntervalSGI(int paramInt) {
/* 38 */     long l = (GL.getCapabilitiesGLXClient()).glXSwapIntervalSGI;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(l);
/*    */     }
/* 42 */     return JNI.callI(paramInt, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGISwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */