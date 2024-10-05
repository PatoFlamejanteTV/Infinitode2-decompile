/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL46C
/*     */   extends GL45C
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
/*  42 */     GL.initialize();
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
/*     */   protected GL46C() {
/* 102 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(paramByteBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3));
/*     */     }
/* 129 */     nglMultiDrawArraysIndirectCount(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt2, paramInt3);
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
/* 148 */     nglMultiDrawArraysIndirectCount(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3);
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
/* 167 */     if (Checks.CHECKS) {
/* 168 */       Checks.check(paramIntBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*     */     }
/* 170 */     nglMultiDrawArraysIndirectCount(paramInt1, MemoryUtil.memAddress(paramIntBuffer), paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(paramByteBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4));
/*     */     }
/* 198 */     nglMultiDrawElementsIndirectCount(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt3, paramInt4);
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
/* 218 */     nglMultiDrawElementsIndirectCount(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4);
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
/* 238 */     if (Checks.CHECKS) {
/* 239 */       Checks.check(paramIntBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*     */     }
/* 241 */     nglMultiDrawElementsIndirectCount(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramLong, paramInt3, paramInt4);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2) {
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.checkNT1(paramByteBuffer);
/* 309 */       Checks.checkSafe(paramIntBuffer2, Checks.remainingSafe(paramIntBuffer1));
/*     */     } 
/* 311 */     nglSpecializeShader(paramInt, MemoryUtil.memAddress(paramByteBuffer), Checks.remainingSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
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
/* 347 */     if (Checks.CHECKS)
/* 348 */       Checks.checkSafe(paramIntBuffer2, Checks.remainingSafe(paramIntBuffer1)); 
/*     */     MemoryStack memoryStack;
/* 350 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 352 */       memoryStack.nUTF8(paramCharSequence, true);
/* 353 */       long l = memoryStack.getPointerAddress();
/* 354 */       nglSpecializeShader(paramInt, l, Checks.remainingSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2)); return;
/*     */     } finally {
/* 356 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 366 */     long l = (GL.getICD()).glMultiDrawArraysIndirectCount;
/* 367 */     if (Checks.CHECKS) {
/* 368 */       Checks.check(l);
/* 369 */       Checks.check(paramArrayOfint, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*     */     } 
/* 371 */     JNI.callPPV(paramInt1, paramArrayOfint, paramLong, paramInt2, paramInt3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCount(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 380 */     long l = (GL.getICD()).glMultiDrawElementsIndirectCount;
/* 381 */     if (Checks.CHECKS) {
/* 382 */       Checks.check(l);
/* 383 */       Checks.check(paramArrayOfint, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*     */     } 
/* 385 */     JNI.callPPV(paramInt1, paramInt2, paramArrayOfint, paramLong, paramInt3, paramInt4, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 394 */     long l = (GL.getICD()).glSpecializeShader;
/* 395 */     if (Checks.CHECKS) {
/* 396 */       Checks.check(l);
/* 397 */       Checks.checkNT1(paramByteBuffer);
/* 398 */       Checks.checkSafe(paramArrayOfint2, Checks.lengthSafe(paramArrayOfint1));
/*     */     } 
/* 400 */     JNI.callPPPV(paramInt, MemoryUtil.memAddress(paramByteBuffer), Checks.lengthSafe(paramArrayOfint1), paramArrayOfint1, paramArrayOfint2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSpecializeShader(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 409 */     long l = (GL.getICD()).glSpecializeShader;
/* 410 */     if (Checks.CHECKS) {
/* 411 */       Checks.check(l);
/* 412 */       Checks.checkSafe(paramArrayOfint2, Checks.lengthSafe(paramArrayOfint1));
/*     */     }  MemoryStack memoryStack;
/* 414 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 416 */       memoryStack.nUTF8(paramCharSequence, true);
/* 417 */       long l1 = memoryStack.getPointerAddress();
/* 418 */       JNI.callPPPV(paramInt, l1, Checks.lengthSafe(paramArrayOfint1), paramArrayOfint1, paramArrayOfint2, l); return;
/*     */     } finally {
/* 420 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native void nglMultiDrawArraysIndirectCount(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3);
/*     */   
/*     */   public static native void nglMultiDrawElementsIndirectCount(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native void glPolygonOffsetClamp(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void nglSpecializeShader(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL46C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */