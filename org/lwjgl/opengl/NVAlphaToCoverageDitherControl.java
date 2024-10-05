/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVAlphaToCoverageDitherControl
/*    */ {
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_DEFAULT_NV = 37709;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_ENABLE_NV = 37710;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_DISABLE_NV = 37711;
/*    */   public static final int GL_ALPHA_TO_COVERAGE_DITHER_MODE_NV = 37567;
/*    */   
/*    */   static {
/* 18 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glAlphaToCoverageDitherControlNV(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVAlphaToCoverageDitherControl() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVAlphaToCoverageDitherControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */