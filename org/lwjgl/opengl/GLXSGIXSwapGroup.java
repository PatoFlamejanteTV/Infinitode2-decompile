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
/*    */ public class GLXSGIXSwapGroup
/*    */ {
/*    */   protected GLXSGIXSwapGroup() {
/* 24 */     throw new UnsupportedOperationException();
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
/*    */   public static void glXJoinSwapGroupSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLXDrawable") long paramLong3) {
/* 39 */     long l = (GL.getCapabilitiesGLXClient()).glXJoinSwapGroupSGIX;
/* 40 */     if (Checks.CHECKS) {
/* 41 */       Checks.check(l);
/* 42 */       Checks.check(paramLong1);
/* 43 */       Checks.check(paramLong2);
/*    */     } 
/* 45 */     JNI.callPPPV(paramLong1, paramLong2, paramLong3, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIXSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */