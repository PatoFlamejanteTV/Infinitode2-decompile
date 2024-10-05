/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL46
/*     */   extends GL45
/*     */ {
/*     */   public static final int GL_PARAMETER_BUFFER = 33006;
/*     */   public static final int GL_PARAMETER_BUFFER_BINDING = 33007;
/*     */   public static final int GL_VERTICES_SUBMITTED = 33518;
/*     */   public static final int GL_PRIMITIVES_SUBMITTED = 33519;
/*     */   public static final int GL_VERTEX_SHADER_INVOCATIONS = 33520;
/*     */   public static final int GL_TESS_CONTROL_SHADER_PATCHES = 33521;
/*     */   public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 33522;
/*     */   public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 33523;
/*     */   public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 33524;
/*     */   public static final int GL_COMPUTE_SHADER_INVOCATIONS = 33525;
/*     */   public static final int GL_CLIPPING_INPUT_PRIMITIVES = 33526;
/*     */   public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 33527;
/*     */   public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
/*     */   public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 8;
/*     */   public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 38225;
/*     */   public static final int GL_SPIR_V_BINARY = 38226;
/*     */   public static final int GL_SPIR_V_EXTENSIONS = 38227;
/*     */   public static final int GL_NUM_SPIR_V_EXTENSIONS = 38228;
/*     */   public static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
/*     */   public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 34047;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 33516;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 33517;
/*     */   
/*     */   static {
/*  37 */     GL.initialize();
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected GL46() {
/*  97 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawArraysIndirectCount(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3) {
/* 104 */     GL46C.nglMultiDrawArraysIndirectCount(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 123 */     GL46C.glMultiDrawArraysIndirectCount(paramInt1, paramByteBuffer, paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 142 */     GL46C.glMultiDrawArraysIndirectCount(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 161 */     GL46C.glMultiDrawArraysIndirectCount(paramInt1, paramIntBuffer, paramLong, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElementsIndirectCount(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4) {
/* 168 */     GL46C.nglMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 188 */     GL46C.glMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramByteBuffer, paramLong, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 208 */     GL46C.glMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 228 */     GL46C.glMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramIntBuffer, paramLong, paramInt3, paramInt4);
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
/*     */   public static void glPolygonOffsetClamp(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/* 251 */     GL46C.glPolygonOffsetClamp(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSpecializeShader(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3) {
/* 262 */     GL46C.nglSpecializeShader(paramInt1, paramLong1, paramInt2, paramLong2, paramLong3);
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
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2) {
/* 298 */     GL46C.glSpecializeShader(paramInt, paramByteBuffer, paramIntBuffer1, paramIntBuffer2);
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
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2) {
/* 334 */     GL46C.glSpecializeShader(paramInt, paramCharSequence, paramIntBuffer1, paramIntBuffer2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 343 */     GL46C.glMultiDrawArraysIndirectCount(paramInt1, paramArrayOfint, paramLong, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 352 */     GL46C.glMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramArrayOfint, paramLong, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 361 */     GL46C.glSpecializeShader(paramInt, paramByteBuffer, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 370 */     GL46C.glSpecializeShader(paramInt, paramCharSequence, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL46.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */