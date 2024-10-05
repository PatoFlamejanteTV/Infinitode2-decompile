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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AMDVertexShaderTessellator
/*    */ {
/*    */   public static final int GL_SAMPLER_BUFFER_AMD = 36865;
/*    */   public static final int GL_INT_SAMPLER_BUFFER_AMD = 36866;
/*    */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_AMD = 36867;
/*    */   public static final int GL_DISCRETE_AMD = 36870;
/*    */   public static final int GL_CONTINUOUS_AMD = 36871;
/*    */   public static final int GL_TESSELLATION_MODE_AMD = 36868;
/*    */   public static final int GL_TESSELLATION_FACTOR_AMD = 36869;
/*    */   
/*    */   static {
/* 69 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTessellationModeAMD(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTessellationFactorAMD(@NativeType("GLfloat") float paramFloat);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AMDVertexShaderTessellator() {
/* 89 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDVertexShaderTessellator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */