/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL31
/*     */   extends GL30
/*     */ {
/*     */   public static final int GL_R8_SNORM = 36756;
/*     */   public static final int GL_RG8_SNORM = 36757;
/*     */   public static final int GL_RGB8_SNORM = 36758;
/*     */   public static final int GL_RGBA8_SNORM = 36759;
/*     */   public static final int GL_R16_SNORM = 36760;
/*     */   public static final int GL_RG16_SNORM = 36761;
/*     */   public static final int GL_RGB16_SNORM = 36762;
/*     */   public static final int GL_RGBA16_SNORM = 36763;
/*     */   public static final int GL_SIGNED_NORMALIZED = 36764;
/*     */   public static final int GL_SAMPLER_BUFFER = 36290;
/*     */   public static final int GL_INT_SAMPLER_2D_RECT = 36301;
/*     */   public static final int GL_INT_SAMPLER_BUFFER = 36304;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
/*     */   public static final int GL_COPY_READ_BUFFER = 36662;
/*     */   
/*     */   static {
/*  34 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_COPY_WRITE_BUFFER = 36663;
/*     */ 
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART = 36765;
/*     */ 
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER = 35882;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_RECTANGLE = 34037;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT = 35683;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER = 35345;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_START = 35369;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
/*     */ 
/*     */   
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
/*     */ 
/*     */   
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_TYPE = 35383;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_SIZE = 35384;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_NAME_LENGTH = 35385;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
/*     */   
/*     */   public static final int GL_UNIFORM_OFFSET = 35387;
/*     */   
/*     */   public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
/*     */   
/*     */   public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
/*     */   
/*     */   public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
/*     */   
/*     */   public static final int GL_INVALID_INDEX = -1;
/*     */ 
/*     */   
/*     */   protected GL31() {
/* 165 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDrawArraysInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 181 */     GL31C.glDrawArraysInstanced(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void nglDrawElementsInstanced(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4) {
/* 193 */     GL31C.nglDrawElementsInstanced(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4) {
/* 208 */     GL31C.glDrawElementsInstanced(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3) {
/* 222 */     GL31C.glDrawElementsInstanced(paramInt1, paramInt2, paramByteBuffer, paramInt3);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2) {
/* 235 */     GL31C.glDrawElementsInstanced(paramInt1, paramByteBuffer, paramInt2);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2) {
/* 248 */     GL31C.glDrawElementsInstanced(paramInt1, paramShortBuffer, paramInt2);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2) {
/* 261 */     GL31C.glDrawElementsInstanced(paramInt1, paramIntBuffer, paramInt2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCopyBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3) {
/* 288 */     GL31C.glCopyBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
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
/*     */   public static void glPrimitiveRestartIndex(@NativeType("GLuint") int paramInt) {
/* 301 */     GL31C.glPrimitiveRestartIndex(paramInt);
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
/*     */   public static void glTexBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 336 */     GL31C.glTexBuffer(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformIndices(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/* 347 */     GL31C.nglGetUniformIndices(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 360 */     GL31C.glGetUniformIndices(paramInt, paramPointerBuffer, paramIntBuffer);
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
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 373 */     GL31C.glGetUniformIndices(paramInt, paramArrayOfCharSequence, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/* 385 */     return GL31C.glGetUniformIndices(paramInt, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveUniformsiv(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2) {
/* 396 */     GL31C.nglGetActiveUniformsiv(paramInt1, paramInt2, paramLong1, paramInt3, paramLong2);
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
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 410 */     GL31C.glGetActiveUniformsiv(paramInt1, paramIntBuffer1, paramInt2, paramIntBuffer2);
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
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformsi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 423 */     return GL31C.glGetActiveUniformsi(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveUniformName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/* 434 */     GL31C.nglGetActiveUniformName(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 448 */     GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 462 */     return GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramInt3);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 475 */     return glGetActiveUniformName(paramInt1, paramInt2, glGetActiveUniformsi(paramInt1, paramInt2, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetUniformBlockIndex(int paramInt, long paramLong) {
/* 482 */     return GL31C.nglGetUniformBlockIndex(paramInt, paramLong);
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 495 */     return GL31C.glGetUniformBlockIndex(paramInt, paramByteBuffer);
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 508 */     return GL31C.glGetUniformBlockIndex(paramInt, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 515 */     GL31C.nglGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 529 */     GL31C.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformBlocki(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 543 */     return GL31C.glGetActiveUniformBlocki(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveUniformBlockName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/* 554 */     GL31C.nglGetActiveUniformBlockName(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 568 */     GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 582 */     return GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramInt3);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 595 */     return glGetActiveUniformBlockName(paramInt1, paramInt2, glGetActiveUniformBlocki(paramInt1, paramInt2, 35393));
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
/*     */   public static void glUniformBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 610 */     GL31C.glUniformBlockBinding(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 619 */     GL31C.glGetUniformIndices(paramInt, paramPointerBuffer, paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 628 */     GL31C.glGetActiveUniformsiv(paramInt1, paramArrayOfint1, paramInt2, paramArrayOfint2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 637 */     GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 646 */     GL31C.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 655 */     GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL31.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */