/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBTextureMultisample
/*     */ {
/*     */   public static final int GL_SAMPLE_POSITION = 36432;
/*     */   public static final int GL_SAMPLE_MASK = 36433;
/*     */   public static final int GL_SAMPLE_MASK_VALUE = 36434;
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
/*     */   public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
/*     */   public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
/*     */   public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
/*     */   
/*     */   static {
/*  29 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_INTEGER_SAMPLES = 37136;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_SAMPLES = 37126;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBTextureMultisample() {
/*  79 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexImage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean) {
/*  97 */     GL32C.glTexImage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexImage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean) {
/* 116 */     GL32C.glTexImage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetMultisamplefv(int paramInt1, int paramInt2, long paramLong) {
/* 123 */     GL32C.nglGetMultisamplefv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 134 */     GL32C.glGetMultisamplefv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetMultisamplef(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 145 */     return GL32C.glGetMultisamplef(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSampleMaski(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2) {
/* 157 */     GL32C.glSampleMaski(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 162 */     GL32C.glGetMultisamplefv(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTextureMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */