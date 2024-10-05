/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBDirectStateAccess
/*      */ {
/*      */   public static final int GL_TEXTURE_TARGET = 4102;
/*      */   public static final int GL_QUERY_TARGET = 33514;
/*      */   
/*      */   static {
/*   33 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ARBDirectStateAccess() {
/*   42 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTransformFeedbacks(int paramInt, long paramLong) {
/*   53 */     GL45C.nglCreateTransformFeedbacks(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*   62 */     GL45C.glCreateTransformFeedbacks(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*   68 */     return GL45C.glCreateTransformFeedbacks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferBase(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*   81 */     GL45C.glTransformFeedbackBufferBase(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTransformFeedbackBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/*   96 */     GL45C.glTransformFeedbackBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbackiv(int paramInt1, int paramInt2, long paramLong) {
/*  103 */     GL45C.nglGetTransformFeedbackiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  114 */     GL45C.glGetTransformFeedbackiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  125 */     return GL45C.glGetTransformFeedbacki(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki_v(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  132 */     GL45C.nglGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  144 */     GL45C.glGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  156 */     return GL45C.glGetTransformFeedbacki(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki64_v(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  163 */     GL45C.nglGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  175 */     GL45C.glGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetTransformFeedbacki64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  187 */     return GL45C.glGetTransformFeedbacki64(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateBuffers(int paramInt, long paramLong) {
/*  198 */     GL45C.nglCreateBuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  208 */     GL45C.glCreateBuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*  217 */     return GL45C.glCreateBuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  228 */     GL45C.nglNamedBufferStorage(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLbitfield") int paramInt2) {
/*  274 */     GL45C.glNamedBufferStorage(paramInt1, paramLong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  321 */     GL45C.glNamedBufferStorage(paramInt1, paramByteBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  368 */     GL45C.glNamedBufferStorage(paramInt1, paramShortBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  415 */     GL45C.glNamedBufferStorage(paramInt1, paramIntBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  462 */     GL45C.glNamedBufferStorage(paramInt1, paramFloatBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  509 */     GL45C.glNamedBufferStorage(paramInt1, paramDoubleBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  520 */     GL45C.nglNamedBufferData(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLenum") int paramInt2) {
/*  530 */     GL45C.glNamedBufferData(paramInt1, paramLong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2) {
/*  540 */     GL45C.glNamedBufferData(paramInt1, paramByteBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLenum") int paramInt2) {
/*  550 */     GL45C.glNamedBufferData(paramInt1, paramShortBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/*  560 */     GL45C.glNamedBufferData(paramInt1, paramIntBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") LongBuffer paramLongBuffer, @NativeType("GLenum") int paramInt2) {
/*  570 */     GL45C.glNamedBufferData(paramInt1, paramLongBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLenum") int paramInt2) {
/*  580 */     GL45C.glNamedBufferData(paramInt1, paramFloatBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLenum") int paramInt2) {
/*  590 */     GL45C.glNamedBufferData(paramInt1, paramDoubleBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3) {
/*  601 */     GL45C.nglNamedBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  611 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  621 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  631 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") LongBuffer paramLongBuffer) {
/*  641 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  651 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  661 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3) {
/*  676 */     GL45C.glCopyNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  683 */     GL45C.nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  698 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  713 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  728 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  743 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3) {
/*  750 */     GL45C.nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  767 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  784 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  801 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  818 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBuffer(int paramInt1, int paramInt2) {
/*  825 */     return GL45C.nglMapNamedBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  837 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, ByteBuffer paramByteBuffer) {
/*  849 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/*  861 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  868 */     return GL45C.nglMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/*  882 */     return GL45C.glMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2, ByteBuffer paramByteBuffer) {
/*  896 */     return GL45C.glMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glUnmapNamedBuffer(@NativeType("GLuint") int paramInt) {
/*  908 */     return GL45C.glUnmapNamedBuffer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFlushMappedNamedBufferRange(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/*  921 */     GL45C.glFlushMappedNamedBufferRange(paramInt, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/*  928 */     GL45C.nglGetNamedBufferParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  939 */     GL45C.glGetNamedBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  950 */     return GL45C.glGetNamedBufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteri64v(int paramInt1, int paramInt2, long paramLong) {
/*  957 */     GL45C.nglGetNamedBufferParameteri64v(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  968 */     GL45C.glGetNamedBufferParameteri64v(paramInt1, paramInt2, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  979 */     return GL45C.glGetNamedBufferParameteri64(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferPointerv(int paramInt1, int paramInt2, long paramLong) {
/*  986 */     GL45C.nglGetNamedBufferPointerv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  997 */     GL45C.glGetNamedBufferPointerv(paramInt1, paramInt2, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1008 */     return GL45C.glGetNamedBufferPointer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3) {
/* 1019 */     GL45C.nglGetNamedBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1030 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1041 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1052 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") LongBuffer paramLongBuffer) {
/* 1063 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1074 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 1085 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateFramebuffers(int paramInt, long paramLong) {
/* 1096 */     GL45C.nglCreateFramebuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1105 */     GL45C.glCreateFramebuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/* 1111 */     return GL45C.glCreateFramebuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 1125 */     GL45C.glNamedFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 1138 */     GL45C.glNamedFramebufferParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTexture(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4) {
/* 1152 */     GL45C.glNamedFramebufferTexture(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferTextureLayer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 1167 */     GL45C.glNamedFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1179 */     GL45C.glNamedFramebufferDrawBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglNamedFramebufferDrawBuffers(int paramInt1, int paramInt2, long paramLong) {
/* 1190 */     GL45C.nglNamedFramebufferDrawBuffers(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1200 */     GL45C.glNamedFramebufferDrawBuffers(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 1209 */     GL45C.glNamedFramebufferDrawBuffers(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferReadBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1221 */     GL45C.glNamedFramebufferReadBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferData(int paramInt1, int paramInt2, long paramLong) {
/* 1232 */     GL45C.nglInvalidateNamedFramebufferData(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1242 */     GL45C.glInvalidateNamedFramebufferData(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 1251 */     GL45C.glInvalidateNamedFramebufferData(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglInvalidateNamedFramebufferSubData(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 1262 */     GL45C.nglInvalidateNamedFramebufferSubData(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1276 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 1289 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1296 */     GL45C.nglClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1309 */     GL45C.glClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1316 */     GL45C.nglClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1328 */     GL45C.glClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1335 */     GL45C.nglClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1348 */     GL45C.glClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt4) {
/* 1363 */     GL45C.glClearNamedFramebufferfi(paramInt1, paramInt2, paramInt3, paramFloat, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlitNamedFramebuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12) {
/* 1385 */     GL45C.glBlitNamedFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static int glCheckNamedFramebufferStatus(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1398 */     return GL45C.glCheckNamedFramebufferStatus(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1405 */     GL45C.nglGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1416 */     GL45C.glGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1427 */     return GL45C.glGetNamedFramebufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1434 */     GL45C.nglGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1446 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1458 */     return GL45C.glGetNamedFramebufferAttachmentParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateRenderbuffers(int paramInt, long paramLong) {
/* 1469 */     GL45C.nglCreateRenderbuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1478 */     GL45C.glCreateRenderbuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/* 1484 */     return GL45C.glCreateRenderbuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1497 */     GL45C.glNamedRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1511 */     GL45C.glNamedRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1518 */     GL45C.nglGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1528 */     GL45C.glGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1538 */     return GL45C.glGetNamedRenderbufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateTextures(int paramInt1, int paramInt2, long paramLong) {
/* 1549 */     GL45C.nglCreateTextures(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1559 */     GL45C.glCreateTextures(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTextures(@NativeType("GLenum") int paramInt) {
/* 1569 */     return GL45C.glCreateTextures(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1582 */     GL45C.glTextureBuffer(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1597 */     GL45C.glTextureBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1611 */     GL45C.glTextureStorage1D(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1626 */     GL45C.glTextureStorage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 1642 */     GL45C.glTextureStorage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage2DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean) {
/* 1659 */     GL45C.glTextureStorage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureStorage3DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean) {
/* 1677 */     GL45C.glTextureStorage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 1684 */     GL45C.nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1699 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") long paramLong) {
/* 1714 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1729 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1744 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1759 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1774 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/* 1781 */     GL45C.nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1798 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/* 1815 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1832 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1849 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1866 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1883 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong) {
/* 1890 */     GL45C.nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1909 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") long paramLong) {
/* 1928 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1947 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1966 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1985 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2004 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 2015 */     GL45C.nglCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/* 2030 */     GL45C.glCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2044 */     GL45C.glCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/* 2055 */     GL45C.nglCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 2072 */     GL45C.glCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2088 */     GL45C.glCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong) {
/* 2099 */     GL45C.nglCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLsizei") int paramInt10, @NativeType("void const *") long paramLong) {
/* 2118 */     GL45C.glCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2136 */     GL45C.glCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 2152 */     GL45C.glCopyTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8) {
/* 2170 */     GL45C.glCopyTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCopyTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9) {
/* 2189 */     GL45C.glCopyTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/* 2202 */     GL45C.glTextureParameterf(paramInt1, paramInt2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 2209 */     GL45C.nglTextureParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2220 */     GL45C.glTextureParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 2233 */     GL45C.glTextureParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 2240 */     GL45C.nglTextureParameterIiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2251 */     GL45C.glTextureParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/* 2261 */     GL45C.glTextureParameterIi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 2268 */     GL45C.nglTextureParameterIuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2279 */     GL45C.glTextureParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3) {
/* 2289 */     GL45C.glTextureParameterIui(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 2296 */     GL45C.nglTextureParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2307 */     GL45C.glTextureParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenerateTextureMipmap(@NativeType("GLuint") int paramInt) {
/* 2318 */     GL45C.glGenerateTextureMipmap(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextureUnit(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2334 */     GL45C.glBindTextureUnit(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 2345 */     GL45C.nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong) {
/* 2359 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2372 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 2385 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 2398 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 2411 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 2424 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTextureImage(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2435 */     GL45C.nglGetCompressedTextureImage(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void *") long paramLong) {
/* 2447 */     GL45C.glGetCompressedTextureImage(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2458 */     GL45C.glGetCompressedTextureImage(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2465 */     GL45C.nglGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2477 */     GL45C.glGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2489 */     return GL45C.glGetTextureLevelParameterf(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2496 */     GL45C.nglGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2508 */     GL45C.glGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2520 */     return GL45C.glGetTextureLevelParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 2527 */     GL45C.nglGetTextureParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2538 */     GL45C.glGetTextureParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2549 */     return GL45C.glGetTextureParameterf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 2556 */     GL45C.nglGetTextureParameterIiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2567 */     GL45C.glGetTextureParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2578 */     return GL45C.glGetTextureParameterIi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 2585 */     GL45C.nglGetTextureParameterIuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2596 */     GL45C.glGetTextureParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2607 */     return GL45C.glGetTextureParameterIui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 2614 */     GL45C.nglGetTextureParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2625 */     GL45C.glGetTextureParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2636 */     return GL45C.glGetTextureParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateVertexArrays(int paramInt, long paramLong) {
/* 2647 */     GL45C.nglCreateVertexArrays(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2656 */     GL45C.glCreateVertexArrays(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/* 2662 */     return GL45C.glCreateVertexArrays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2674 */     GL45C.glDisableVertexArrayAttrib(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2686 */     GL45C.glEnableVertexArrayAttrib(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayElementBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2698 */     GL45C.glVertexArrayElementBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4) {
/* 2713 */     GL45C.glVertexArrayVertexBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexArrayVertexBuffers(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3) {
/* 2724 */     GL45C.nglVertexArrayVertexBuffers(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer2) {
/* 2737 */     GL45C.glVertexArrayVertexBuffers(paramInt1, paramInt2, paramIntBuffer1, paramPointerBuffer, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5) {
/* 2754 */     GL45C.glVertexArrayAttribFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 2769 */     GL45C.glVertexArrayAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 2784 */     GL45C.glVertexArrayAttribLFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 2797 */     GL45C.glVertexArrayAttribBinding(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 2810 */     GL45C.glVertexArrayBindingDivisor(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayiv(int paramInt1, int paramInt2, long paramLong) {
/* 2817 */     GL45C.nglGetVertexArrayiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2828 */     GL45C.glGetVertexArrayiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2839 */     return GL45C.glGetVertexArrayi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2846 */     GL45C.nglGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2858 */     GL45C.glGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIndexedi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2870 */     return GL45C.glGetVertexArrayIndexedi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexed64iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2877 */     GL45C.nglGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 2889 */     GL45C.glGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayIndexed64i(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2901 */     return GL45C.glGetVertexArrayIndexed64i(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateSamplers(int paramInt, long paramLong) {
/* 2912 */     GL45C.nglCreateSamplers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2921 */     GL45C.glCreateSamplers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/* 2927 */     return GL45C.glCreateSamplers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateProgramPipelines(int paramInt, long paramLong) {
/* 2938 */     GL45C.nglCreateProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2947 */     GL45C.glCreateProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/* 2953 */     return GL45C.glCreateProgramPipelines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCreateQueries(int paramInt1, int paramInt2, long paramLong) {
/* 2964 */     GL45C.nglCreateQueries(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2974 */     GL45C.glCreateQueries(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateQueries(@NativeType("GLenum") int paramInt) {
/* 2984 */     return GL45C.glCreateQueries(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 2998 */     GL45C.glGetQueryBufferObjecti64v(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3012 */     GL45C.glGetQueryBufferObjectiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3026 */     GL45C.glGetQueryBufferObjectui64v(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryBufferObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3040 */     GL45C.glGetQueryBufferObjectuiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3045 */     GL45C.glCreateTransformFeedbacks(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3050 */     GL45C.glGetTransformFeedbackiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3055 */     GL45C.glGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 3060 */     GL45C.glGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramArrayOflong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3065 */     GL45C.glCreateBuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 3070 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 3075 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 3080 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 3085 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 3090 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 3095 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") long[] paramArrayOflong, @NativeType("GLenum") int paramInt2) {
/* 3100 */     GL45C.glNamedBufferData(paramInt1, paramArrayOflong, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 3105 */     GL45C.glNamedBufferData(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 3110 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3115 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 3120 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") long[] paramArrayOflong) {
/* 3125 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3130 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3135 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3140 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 3145 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3150 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3155 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 3160 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3165 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3170 */     GL45C.glGetNamedBufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 3175 */     GL45C.glGetNamedBufferParameteri64v(paramInt1, paramInt2, paramArrayOflong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 3180 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 3185 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") long[] paramArrayOflong) {
/* 3190 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 3195 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 3200 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3205 */     GL45C.glCreateFramebuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 3210 */     GL45C.glNamedFramebufferDrawBuffers(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 3215 */     GL45C.glInvalidateNamedFramebufferData(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 3220 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3225 */     GL45C.glClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3230 */     GL45C.glClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3235 */     GL45C.glClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3240 */     GL45C.glGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3245 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3250 */     GL45C.glCreateRenderbuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3255 */     GL45C.glGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3260 */     GL45C.glCreateTextures(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3265 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") int[] paramArrayOfint) {
/* 3270 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3275 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3280 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3285 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 3290 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3295 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3300 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3305 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 3310 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3315 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3320 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3325 */     GL45C.glTextureParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3330 */     GL45C.glTextureParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3335 */     GL45C.glTextureParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3340 */     GL45C.glTextureParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 3345 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 3350 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 3355 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 3360 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3365 */     GL45C.glGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3370 */     GL45C.glGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3375 */     GL45C.glGetTextureParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3380 */     GL45C.glGetTextureParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3385 */     GL45C.glGetTextureParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3390 */     GL45C.glGetTextureParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3395 */     GL45C.glCreateVertexArrays(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 3400 */     GL45C.glVertexArrayVertexBuffers(paramInt1, paramInt2, paramArrayOfint1, paramPointerBuffer, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3405 */     GL45C.glGetVertexArrayiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3410 */     GL45C.glGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 3415 */     GL45C.glGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramArrayOflong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3420 */     GL45C.glCreateSamplers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 3425 */     GL45C.glCreateProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3430 */     GL45C.glCreateQueries(paramInt, paramArrayOfint);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBDirectStateAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */