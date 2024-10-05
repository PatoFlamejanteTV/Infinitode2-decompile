/*    */ package org.lwjgl.opengl;
/*    */ 
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
/*    */ public class NVFragmentCoverageToColor
/*    */ {
/*    */   public static final int GL_FRAGMENT_COVERAGE_TO_COLOR_NV = 37597;
/*    */   public static final int GL_FRAGMENT_COVERAGE_COLOR_NV = 37598;
/*    */   
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glFragmentCoverageColorNV(@NativeType("GLuint") int paramInt);
/*    */ 
/*    */   
/*    */   protected NVFragmentCoverageToColor() {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVFragmentCoverageToColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */