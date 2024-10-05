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
/*    */ public class EXTTextureArray
/*    */ {
/*    */   public static final int GL_TEXTURE_1D_ARRAY_EXT = 35864;
/*    */   public static final int GL_TEXTURE_2D_ARRAY_EXT = 35866;
/*    */   public static final int GL_PROXY_TEXTURE_2D_ARRAY_EXT = 35867;
/*    */   public static final int GL_PROXY_TEXTURE_1D_ARRAY_EXT = 35865;
/*    */   public static final int GL_TEXTURE_BINDING_1D_ARRAY_EXT = 35868;
/*    */   public static final int GL_TEXTURE_BINDING_2D_ARRAY_EXT = 35869;
/*    */   public static final int GL_MAX_ARRAY_TEXTURE_LAYERS_EXT = 35071;
/*    */   public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE_EXT = 34894;
/*    */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT = 36052;
/*    */   public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
/*    */   public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
/*    */   public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
/*    */   public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
/*    */   
/*    */   static {
/* 35 */     GL.initialize();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glFramebufferTextureLayerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
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
/*    */   protected EXTTextureArray() {
/* 81 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTextureArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */