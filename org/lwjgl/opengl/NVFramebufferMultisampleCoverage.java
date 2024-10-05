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
/*    */ 
/*    */ 
/*    */ public class NVFramebufferMultisampleCoverage
/*    */ {
/*    */   public static final int GL_RENDERBUFFER_COVERAGE_SAMPLES_NV = 36011;
/*    */   public static final int GL_RENDERBUFFER_COLOR_SAMPLES_NV = 36368;
/*    */   public static final int GL_MAX_MULTISAMPLE_COVERAGE_MODES_NV = 36369;
/*    */   public static final int GL_MULTISAMPLE_COVERAGE_MODES_NV = 36370;
/*    */   
/*    */   static {
/* 28 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glRenderbufferStorageMultisampleCoverageNV(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVFramebufferMultisampleCoverage() {
/* 41 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVFramebufferMultisampleCoverage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */