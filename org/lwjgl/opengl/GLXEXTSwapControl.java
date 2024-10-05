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
/*    */ public class GLXEXTSwapControl
/*    */ {
/*    */   public static final int GLX_SWAP_INTERVAL_EXT = 8433;
/*    */   public static final int GLX_MAX_SWAP_INTERVAL_EXT = 8434;
/*    */   
/*    */   protected GLXEXTSwapControl() {
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
/*    */   public static void glXSwapIntervalEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt) {
/* 42 */     long l = (GL.getCapabilitiesGLXClient()).glXSwapIntervalEXT;
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.check(l);
/* 45 */       Checks.check(paramLong1);
/* 46 */       Checks.check(paramLong2);
/*    */     } 
/* 48 */     JNI.callPPV(paramLong1, paramLong2, paramInt, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXEXTSwapControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */