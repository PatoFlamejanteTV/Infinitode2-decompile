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
/*    */ public class EXTTextureStorage
/*    */ {
/*    */   public static final int GL_TEXTURE_IMMUTABLE_FORMAT_EXT = 37167;
/*    */   public static final int GL_ALPHA8_EXT = 32828;
/*    */   public static final int GL_LUMINANCE8_EXT = 32832;
/*    */   public static final int GL_LUMINANCE8_ALPHA8_EXT = 32837;
/*    */   public static final int GL_RGBA32F_EXT = 34836;
/*    */   public static final int GL_RGB32F_EXT = 34837;
/*    */   public static final int GL_ALPHA32F_EXT = 34838;
/*    */   public static final int GL_LUMINANCE32F_EXT = 34840;
/*    */   public static final int GL_LUMINANCE_ALPHA32F_EXT = 34841;
/*    */   public static final int GL_RGBA16F_EXT = 34842;
/*    */   public static final int GL_RGB16F_EXT = 34843;
/*    */   public static final int GL_ALPHA16F_EXT = 34844;
/*    */   
/*    */   static {
/* 30 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_LUMINANCE16F_EXT = 34846;
/*    */   
/*    */   public static final int GL_LUMINANCE_ALPHA16F_EXT = 34847;
/*    */   
/*    */   public static final int GL_RGB10_A2_EXT = 32857;
/*    */   public static final int GL_RGB10_EXT = 32850;
/*    */   public static final int GL_BGRA8_EXT = 37793;
/*    */   public static final int GL_R8_EXT = 33321;
/*    */   public static final int GL_RG8_EXT = 33323;
/*    */   public static final int GL_R32F_EXT = 33326;
/*    */   public static final int GL_RG32F_EXT = 33328;
/*    */   public static final int GL_R16F_EXT = 33325;
/*    */   public static final int GL_RG16F_EXT = 33327;
/*    */   public static final int GL_RGB_RAW_422_APPLE = 35409;
/*    */   
/*    */   public static native void glTextureStorage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*    */   
/*    */   public static native void glTextureStorage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */   
/*    */   public static native void glTextureStorage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*    */   
/*    */   public static native void glTexStorage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*    */   
/*    */   public static native void glTexStorage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*    */   
/*    */   public static native void glTexStorage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*    */   
/*    */   protected EXTTextureStorage() {
/* 62 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTextureStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */