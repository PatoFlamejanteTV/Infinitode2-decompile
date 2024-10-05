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
/*    */ public class GLX12
/*    */   extends GLX11
/*    */ {
/*    */   protected GLX12() {
/* 17 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("Display *")
/*    */   public static long glXGetCurrentDisplay() {
/* 25 */     long l = (GL.getCapabilitiesGLXClient()).glXGetCurrentDisplay;
/* 26 */     if (Checks.CHECKS) {
/* 27 */       Checks.check(l);
/*    */     }
/* 29 */     return JNI.callP(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLX12.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */