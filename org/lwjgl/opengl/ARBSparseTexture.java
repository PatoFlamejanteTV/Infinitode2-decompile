/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBSparseTexture
/*    */ {
/*    */   public static final int GL_TEXTURE_SPARSE_ARB = 37286;
/*    */   public static final int GL_VIRTUAL_PAGE_SIZE_INDEX_ARB = 37287;
/*    */   public static final int GL_NUM_SPARSE_LEVELS_ARB = 37290;
/*    */   public static final int GL_NUM_VIRTUAL_PAGE_SIZES_ARB = 37288;
/*    */   public static final int GL_VIRTUAL_PAGE_SIZE_X_ARB = 37269;
/*    */   public static final int GL_VIRTUAL_PAGE_SIZE_Y_ARB = 37270;
/*    */   public static final int GL_VIRTUAL_PAGE_SIZE_Z_ARB = 37271;
/*    */   public static final int GL_MAX_SPARSE_TEXTURE_SIZE_ARB = 37272;
/*    */   public static final int GL_MAX_SPARSE_3D_TEXTURE_SIZE_ARB = 37273;
/*    */   public static final int GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS_ARB = 37274;
/*    */   public static final int GL_SPARSE_TEXTURE_FULL_ARRAY_CUBE_MIPMAPS_ARB = 37289;
/*    */   
/*    */   static {
/* 25 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTexturePageCommitmentEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLboolean") boolean paramBoolean);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTexPageCommitmentARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLboolean") boolean paramBoolean);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBSparseTexture() {
/* 50 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSparseTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */