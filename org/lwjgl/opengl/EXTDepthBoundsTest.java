/*    */ package org.lwjgl.opengl;
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
/*    */ public class EXTDepthBoundsTest
/*    */ {
/*    */   public static final int GL_DEPTH_BOUNDS_TEST_EXT = 34960;
/*    */   public static final int GL_DEPTH_BOUNDS_EXT = 34961;
/*    */   
/*    */   static {
/* 38 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glDepthBoundsEXT(double paramDouble1, double paramDouble2);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTDepthBoundsTest() {
/* 50 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDepthBoundsTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */