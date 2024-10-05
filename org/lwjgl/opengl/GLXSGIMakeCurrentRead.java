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
/*    */ public class GLXSGIMakeCurrentRead
/*    */ {
/*    */   protected GLXSGIMakeCurrentRead() {
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
/*    */   @NativeType("Bool")
/*    */   public static boolean glXMakeCurrentReadSGI(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLXDrawable") long paramLong3, @NativeType("GLXContext") long paramLong4) {
/* 38 */     long l = (GL.getCapabilitiesGLXClient()).glXMakeCurrentReadSGI;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(l);
/* 41 */       Checks.check(paramLong1);
/*    */     } 
/* 43 */     return (JNI.callPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, l) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLXDrawable")
/*    */   public static long glXGetCurrentReadDrawableSGI() {
/* 51 */     long l = (GL.getCapabilitiesGLXClient()).glXGetCurrentReadDrawableSGI;
/* 52 */     if (Checks.CHECKS) {
/* 53 */       Checks.check(l);
/*    */     }
/* 55 */     return JNI.callP(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIMakeCurrentRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */