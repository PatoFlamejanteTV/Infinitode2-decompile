/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBUniformBufferObject
/*     */ {
/*     */   public static final int GL_UNIFORM_BUFFER = 35345;
/*     */   public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
/*     */   public static final int GL_UNIFORM_BUFFER_START = 35369;
/*     */   public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
/*     */   public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
/*     */   public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
/*     */   public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
/*     */   public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
/*     */   public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
/*     */   public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
/*     */   public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
/*     */   public static final int GL_UNIFORM_TYPE = 35383;
/*     */   public static final int GL_UNIFORM_SIZE = 35384;
/*     */   public static final int GL_UNIFORM_NAME_LENGTH = 35385;
/*     */   public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
/*     */   public static final int GL_UNIFORM_OFFSET = 35387;
/*     */   public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
/*     */   public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
/*     */   public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
/*     */   public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
/*     */   public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
/*     */   public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
/*     */   public static final int GL_INVALID_INDEX = -1;
/*     */   
/*     */   static {
/*  92 */     GL.initialize();
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
/*     */   protected ARBUniformBufferObject() {
/* 149 */     throw new UnsupportedOperationException();
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
/* 160 */     GL31C.nglGetUniformIndices(paramInt1, paramInt2, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 171 */     GL31C.glGetUniformIndices(paramInt, paramPointerBuffer, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 182 */     GL31C.glGetUniformIndices(paramInt, paramArrayOfCharSequence, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/* 192 */     return GL31C.glGetUniformIndices(paramInt, paramCharSequence);
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
/* 203 */     GL31C.nglGetActiveUniformsiv(paramInt1, paramInt2, paramLong1, paramInt3, paramLong2);
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
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 215 */     GL31C.glGetActiveUniformsiv(paramInt1, paramIntBuffer1, paramInt2, paramIntBuffer2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformsi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 226 */     return GL31C.glGetActiveUniformsi(paramInt1, paramInt2, paramInt3);
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
/* 237 */     GL31C.nglGetActiveUniformName(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 249 */     GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
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
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 261 */     return GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 272 */     return glGetActiveUniformName(paramInt1, paramInt2, glGetActiveUniformsi(paramInt1, paramInt2, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetUniformBlockIndex(int paramInt, long paramLong) {
/* 279 */     return GL31C.nglGetUniformBlockIndex(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 290 */     return GL31C.glGetUniformBlockIndex(paramInt, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 301 */     return GL31C.glGetUniformBlockIndex(paramInt, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 308 */     GL31C.nglGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 320 */     GL31C.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   public static int glGetActiveUniformBlocki(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 332 */     return GL31C.glGetActiveUniformBlocki(paramInt1, paramInt2, paramInt3);
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
/* 343 */     GL31C.nglGetActiveUniformBlockName(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 355 */     GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
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
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 367 */     return GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 378 */     return glGetActiveUniformBlockName(paramInt1, paramInt2, glGetActiveUniformBlocki(paramInt1, paramInt2, 35393));
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
/*     */   public static void glBindBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 393 */     GL30C.glBindBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glBindBufferBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 406 */     GL30C.glBindBufferBase(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetIntegeri_v(int paramInt1, int paramInt2, long paramLong) {
/* 413 */     GL30C.nglGetIntegeri_v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 424 */     GL30C.glGetIntegeri_v(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetIntegeri(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 435 */     return GL30C.glGetIntegeri(paramInt1, paramInt2);
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
/*     */   public static void glUniformBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 448 */     GL31C.glUniformBlockBinding(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 453 */     GL31C.glGetUniformIndices(paramInt, paramPointerBuffer, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 458 */     GL31C.glGetActiveUniformsiv(paramInt1, paramArrayOfint1, paramInt2, paramArrayOfint2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 463 */     GL31C.glGetActiveUniformName(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 468 */     GL31C.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 473 */     GL31C.glGetActiveUniformBlockName(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetIntegeri_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 478 */     GL30C.glGetIntegeri_v(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBUniformBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */