/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ public class GL45
/*      */   extends GL44
/*      */ {
/*      */   public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
/*      */   public static final int GL_ZERO_TO_ONE = 37727;
/*      */   public static final int GL_CLIP_ORIGIN = 37724;
/*      */   public static final int GL_CLIP_DEPTH_MODE = 37725;
/*      */   public static final int GL_QUERY_WAIT_INVERTED = 36375;
/*      */   public static final int GL_QUERY_NO_WAIT_INVERTED = 36376;
/*      */   public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 36377;
/*      */   public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 36378;
/*      */   public static final int GL_MAX_CULL_DISTANCES = 33529;
/*      */   public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 33530;
/*      */   public static final int GL_TEXTURE_TARGET = 4102;
/*      */   public static final int GL_QUERY_TARGET = 33514;
/*      */   public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 33531;
/*      */   public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 33532;
/*      */   public static final int GL_GUILTY_CONTEXT_RESET = 33363;
/*      */   public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
/*      */   public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
/*      */   public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
/*      */   public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
/*      */   public static final int GL_NO_RESET_NOTIFICATION = 33377;
/*      */   public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4;
/*      */   public static final int GL_CONTEXT_LOST = 1287;
/*      */   
/*      */   static {
/*   44 */     GL.initialize();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL45() {
/*  101 */     throw new UnsupportedOperationException();
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
/*      */   public static void glClipControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  121 */     GL45C.glClipControl(paramInt1, paramInt2);
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
/*  132 */     GL45C.nglCreateTransformFeedbacks(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  143 */     GL45C.glCreateTransformFeedbacks(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*  153 */     return GL45C.glCreateTransformFeedbacks();
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
/*      */   public static void glTransformFeedbackBufferBase(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  168 */     GL45C.glTransformFeedbackBufferBase(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glTransformFeedbackBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/*  185 */     GL45C.glTransformFeedbackBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbackiv(int paramInt1, int paramInt2, long paramLong) {
/*  192 */     GL45C.nglGetTransformFeedbackiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  205 */     GL45C.glGetTransformFeedbackiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  218 */     return GL45C.glGetTransformFeedbacki(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki_v(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  225 */     GL45C.nglGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  239 */     GL45C.glGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  253 */     return GL45C.glGetTransformFeedbacki(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTransformFeedbacki64_v(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  260 */     GL45C.nglGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  274 */     GL45C.glGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramLongBuffer);
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
/*      */   @NativeType("void")
/*      */   public static long glGetTransformFeedbacki64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  288 */     return GL45C.glGetTransformFeedbacki64(paramInt1, paramInt2, paramInt3);
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
/*  299 */     GL45C.nglCreateBuffers(paramInt, paramLong);
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
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  311 */     GL45C.glCreateBuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*  322 */     return GL45C.glCreateBuffers();
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
/*  333 */     GL45C.nglNamedBufferStorage(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLbitfield") int paramInt2) {
/*  381 */     GL45C.glNamedBufferStorage(paramInt1, paramLong, paramInt2);
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
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  430 */     GL45C.glNamedBufferStorage(paramInt1, paramByteBuffer, paramInt2);
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
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  479 */     GL45C.glNamedBufferStorage(paramInt1, paramShortBuffer, paramInt2);
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
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  528 */     GL45C.glNamedBufferStorage(paramInt1, paramIntBuffer, paramInt2);
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
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  577 */     GL45C.glNamedBufferStorage(paramInt1, paramFloatBuffer, paramInt2);
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
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  626 */     GL45C.glNamedBufferStorage(paramInt1, paramDoubleBuffer, paramInt2);
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
/*  637 */     GL45C.nglNamedBufferData(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLenum") int paramInt2) {
/*  649 */     GL45C.glNamedBufferData(paramInt1, paramLong, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2) {
/*  661 */     GL45C.glNamedBufferData(paramInt1, paramByteBuffer, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLenum") int paramInt2) {
/*  673 */     GL45C.glNamedBufferData(paramInt1, paramShortBuffer, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/*  685 */     GL45C.glNamedBufferData(paramInt1, paramIntBuffer, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") LongBuffer paramLongBuffer, @NativeType("GLenum") int paramInt2) {
/*  697 */     GL45C.glNamedBufferData(paramInt1, paramLongBuffer, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLenum") int paramInt2) {
/*  709 */     GL45C.glNamedBufferData(paramInt1, paramFloatBuffer, paramInt2);
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
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLenum") int paramInt2) {
/*  721 */     GL45C.glNamedBufferData(paramInt1, paramDoubleBuffer, paramInt2);
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
/*  732 */     GL45C.nglNamedBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  744 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramByteBuffer);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  756 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramShortBuffer);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  768 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramIntBuffer);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") LongBuffer paramLongBuffer) {
/*  780 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramLongBuffer);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  792 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramFloatBuffer);
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
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  804 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramDoubleBuffer);
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
/*      */   public static void glCopyNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3) {
/*  821 */     GL45C.glCopyNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  828 */     GL45C.nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  845 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  862 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
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
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  879 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  896 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3) {
/*  903 */     GL45C.nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramLong3);
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
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  922 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  941 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramShortBuffer);
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
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  960 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramIntBuffer);
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
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  979 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBuffer(int paramInt1, int paramInt2) {
/*  986 */     return GL45C.nglMapNamedBuffer(paramInt1, paramInt2);
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
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1000 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2);
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
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, ByteBuffer paramByteBuffer) {
/* 1014 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static ByteBuffer glMapNamedBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/* 1028 */     return GL45C.glMapNamedBuffer(paramInt1, paramInt2, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapNamedBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/* 1035 */     return GL45C.nglMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/* 1051 */     return GL45C.glMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2, ByteBuffer paramByteBuffer) {
/* 1067 */     return GL45C.glMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2, paramByteBuffer);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glUnmapNamedBuffer(@NativeType("GLuint") int paramInt) {
/* 1081 */     return GL45C.glUnmapNamedBuffer(paramInt);
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
/*      */   public static void glFlushMappedNamedBufferRange(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1096 */     GL45C.glFlushMappedNamedBufferRange(paramInt, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1103 */     GL45C.nglGetNamedBufferParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1116 */     GL45C.glGetNamedBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1129 */     return GL45C.glGetNamedBufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferParameteri64v(int paramInt1, int paramInt2, long paramLong) {
/* 1136 */     GL45C.nglGetNamedBufferParameteri64v(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 1149 */     GL45C.glGetNamedBufferParameteri64v(paramInt1, paramInt2, paramLongBuffer);
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
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1162 */     return GL45C.glGetNamedBufferParameteri64(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedBufferPointerv(int paramInt1, int paramInt2, long paramLong) {
/* 1169 */     GL45C.nglGetNamedBufferPointerv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1182 */     GL45C.glGetNamedBufferPointerv(paramInt1, paramInt2, paramPointerBuffer);
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
/*      */   @NativeType("void")
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1195 */     return GL45C.glGetNamedBufferPointer(paramInt1, paramInt2);
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
/* 1206 */     GL45C.nglGetNamedBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1219 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramByteBuffer);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1232 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramShortBuffer);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1245 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramIntBuffer);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") LongBuffer paramLongBuffer) {
/* 1258 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramLongBuffer);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1271 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramFloatBuffer);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 1284 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramDoubleBuffer);
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
/* 1295 */     GL45C.nglCreateFramebuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1306 */     GL45C.glCreateFramebuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/* 1316 */     return GL45C.glCreateFramebuffers();
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
/*      */   public static void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 1332 */     GL45C.glNamedFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 1347 */     GL45C.glNamedFramebufferParameteri(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glNamedFramebufferTexture(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4) {
/* 1363 */     GL45C.glNamedFramebufferTexture(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glNamedFramebufferTextureLayer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 1380 */     GL45C.glNamedFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1394 */     GL45C.glNamedFramebufferDrawBuffer(paramInt1, paramInt2);
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
/* 1405 */     GL45C.nglNamedFramebufferDrawBuffers(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1417 */     GL45C.glNamedFramebufferDrawBuffers(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 1428 */     GL45C.glNamedFramebufferDrawBuffers(paramInt1, paramInt2);
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
/*      */   public static void glNamedFramebufferReadBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1442 */     GL45C.glNamedFramebufferReadBuffer(paramInt1, paramInt2);
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
/* 1453 */     GL45C.nglInvalidateNamedFramebufferData(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 1465 */     GL45C.glInvalidateNamedFramebufferData(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 1476 */     GL45C.glInvalidateNamedFramebufferData(paramInt1, paramInt2);
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
/* 1487 */     GL45C.nglInvalidateNamedFramebufferSubData(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1503 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 1518 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1525 */     GL45C.nglClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1540 */     GL45C.glClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1547 */     GL45C.nglClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1561 */     GL45C.glClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearNamedFramebufferfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1568 */     GL45C.nglClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1583 */     GL45C.glClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
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
/*      */   public static void glClearNamedFramebufferfi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt4) {
/* 1600 */     GL45C.glClearNamedFramebufferfi(paramInt1, paramInt2, paramInt3, paramFloat, paramInt4);
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
/*      */   public static void glBlitNamedFramebuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12) {
/* 1624 */     GL45C.glBlitNamedFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
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
/*      */   @NativeType("GLenum")
/*      */   public static int glCheckNamedFramebufferStatus(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1639 */     return GL45C.glCheckNamedFramebufferStatus(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1646 */     GL45C.nglGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1659 */     GL45C.glGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1672 */     return GL45C.glGetNamedFramebufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1679 */     GL45C.nglGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1693 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1707 */     return GL45C.glGetNamedFramebufferAttachmentParameteri(paramInt1, paramInt2, paramInt3);
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
/* 1718 */     GL45C.nglCreateRenderbuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1729 */     GL45C.glCreateRenderbuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/* 1739 */     return GL45C.glCreateRenderbuffers();
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
/*      */   public static void glNamedRenderbufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1754 */     GL45C.glNamedRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1770 */     GL45C.glNamedRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetNamedRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1777 */     GL45C.nglGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1789 */     GL45C.glGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1801 */     return GL45C.glGetNamedRenderbufferParameteri(paramInt1, paramInt2);
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
/* 1812 */     GL45C.nglCreateTextures(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1824 */     GL45C.glCreateTextures(paramInt, paramIntBuffer);
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
/*      */   public static int glCreateTextures(@NativeType("GLenum") int paramInt) {
/* 1836 */     return GL45C.glCreateTextures(paramInt);
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
/*      */   public static void glTextureBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1851 */     GL45C.glTextureBuffer(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glTextureBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 1868 */     GL45C.glTextureBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*      */   public static void glTextureStorage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1884 */     GL45C.glTextureStorage1D(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glTextureStorage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1901 */     GL45C.glTextureStorage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glTextureStorage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 1919 */     GL45C.glTextureStorage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glTextureStorage2DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean) {
/* 1938 */     GL45C.glTextureStorage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
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
/*      */   public static void glTextureStorage3DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean) {
/* 1958 */     GL45C.glTextureStorage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 1965 */     GL45C.nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1982 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") long paramLong) {
/* 1999 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 2016 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 2033 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2050 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
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
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2067 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/* 2074 */     GL45C.nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2093 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/* 2112 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 2131 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 2150 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2169 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer);
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
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2188 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong) {
/* 2195 */     GL45C.nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2216 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") long paramLong) {
/* 2237 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 2258 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramShortBuffer);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 2279 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramIntBuffer);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 2300 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloatBuffer);
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
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 2321 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramDoubleBuffer);
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
/* 2332 */     GL45C.nglCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/* 2349 */     GL45C.glCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2365 */     GL45C.glCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer);
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
/* 2376 */     GL45C.nglCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 2395 */     GL45C.glCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2413 */     GL45C.glCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer);
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
/* 2424 */     GL45C.nglCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLsizei") int paramInt10, @NativeType("void const *") long paramLong) {
/* 2445 */     GL45C.glCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glCompressedTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2465 */     GL45C.glCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramByteBuffer);
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
/*      */   public static void glCopyTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 2483 */     GL45C.glCopyTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glCopyTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8) {
/* 2503 */     GL45C.glCopyTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
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
/*      */   public static void glCopyTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9) {
/* 2524 */     GL45C.glCopyTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
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
/*      */   public static void glTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/* 2539 */     GL45C.glTextureParameterf(paramInt1, paramInt2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 2546 */     GL45C.nglTextureParameterfv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2559 */     GL45C.glTextureParameterfv(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   public static void glTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 2574 */     GL45C.glTextureParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 2581 */     GL45C.nglTextureParameterIiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2594 */     GL45C.glTextureParameterIiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/* 2606 */     GL45C.glTextureParameterIi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 2613 */     GL45C.nglTextureParameterIuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2626 */     GL45C.glTextureParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3) {
/* 2638 */     GL45C.glTextureParameterIui(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglTextureParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 2645 */     GL45C.nglTextureParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2658 */     GL45C.glTextureParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glGenerateTextureMipmap(@NativeType("GLuint") int paramInt) {
/* 2671 */     GL45C.glGenerateTextureMipmap(paramInt);
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
/*      */   public static void glBindTextureUnit(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2689 */     GL45C.glBindTextureUnit(paramInt1, paramInt2);
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
/* 2700 */     GL45C.nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong) {
/* 2716 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2731 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 2746 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 2761 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 2776 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
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
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 2791 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer);
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
/* 2802 */     GL45C.nglGetCompressedTextureImage(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void *") long paramLong) {
/* 2816 */     GL45C.glGetCompressedTextureImage(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetCompressedTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2829 */     GL45C.glGetCompressedTextureImage(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2836 */     GL45C.nglGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2850 */     GL45C.glGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
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
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2864 */     return GL45C.glGetTextureLevelParameterf(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 2871 */     GL45C.nglGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2885 */     GL45C.glGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 2899 */     return GL45C.glGetTextureLevelParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 2906 */     GL45C.nglGetTextureParameterfv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2919 */     GL45C.glGetTextureParameterfv(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2932 */     return GL45C.glGetTextureParameterf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 2939 */     GL45C.nglGetTextureParameterIiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2952 */     GL45C.glGetTextureParameterIiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2965 */     return GL45C.glGetTextureParameterIi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 2972 */     GL45C.nglGetTextureParameterIuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2985 */     GL45C.glGetTextureParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2998 */     return GL45C.glGetTextureParameterIui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 3005 */     GL45C.nglGetTextureParameteriv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3018 */     GL45C.glGetTextureParameteriv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 3031 */     return GL45C.glGetTextureParameteri(paramInt1, paramInt2);
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
/* 3042 */     GL45C.nglCreateVertexArrays(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3053 */     GL45C.glCreateVertexArrays(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/* 3063 */     return GL45C.glCreateVertexArrays();
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
/*      */   public static void glDisableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 3077 */     GL45C.glDisableVertexArrayAttrib(paramInt1, paramInt2);
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
/*      */   public static void glEnableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 3091 */     GL45C.glEnableVertexArrayAttrib(paramInt1, paramInt2);
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
/*      */   public static void glVertexArrayElementBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 3105 */     GL45C.glVertexArrayElementBuffer(paramInt1, paramInt2);
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
/*      */   public static void glVertexArrayVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4) {
/* 3122 */     GL45C.glVertexArrayVertexBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/* 3133 */     GL45C.nglVertexArrayVertexBuffers(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3);
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
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer2) {
/* 3148 */     GL45C.glVertexArrayVertexBuffers(paramInt1, paramInt2, paramIntBuffer1, paramPointerBuffer, paramIntBuffer2);
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
/*      */   public static void glVertexArrayAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5) {
/* 3167 */     GL45C.glVertexArrayAttribFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
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
/*      */   public static void glVertexArrayAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 3184 */     GL45C.glVertexArrayAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glVertexArrayAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 3201 */     GL45C.glVertexArrayAttribLFormat(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glVertexArrayAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 3216 */     GL45C.glVertexArrayAttribBinding(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glVertexArrayBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 3231 */     GL45C.glVertexArrayBindingDivisor(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayiv(int paramInt1, int paramInt2, long paramLong) {
/* 3238 */     GL45C.nglGetVertexArrayiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3251 */     GL45C.glGetVertexArrayiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 3264 */     return GL45C.glGetVertexArrayi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 3271 */     GL45C.nglGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3285 */     GL45C.glGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIndexedi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 3299 */     return GL45C.glGetVertexArrayIndexedi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexArrayIndexed64iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 3306 */     GL45C.nglGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 3320 */     GL45C.glGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramLongBuffer);
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
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayIndexed64i(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 3334 */     return GL45C.glGetVertexArrayIndexed64i(paramInt1, paramInt2, paramInt3);
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
/* 3345 */     GL45C.nglCreateSamplers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3356 */     GL45C.glCreateSamplers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/* 3366 */     return GL45C.glCreateSamplers();
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
/* 3377 */     GL45C.nglCreateProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3388 */     GL45C.glCreateProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/* 3398 */     return GL45C.glCreateProgramPipelines();
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
/* 3409 */     GL45C.nglCreateQueries(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3421 */     GL45C.glCreateQueries(paramInt, paramIntBuffer);
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
/*      */   public static int glCreateQueries(@NativeType("GLenum") int paramInt) {
/* 3433 */     return GL45C.glCreateQueries(paramInt);
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
/*      */   public static void glGetQueryBufferObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3449 */     GL45C.glGetQueryBufferObjectiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetQueryBufferObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3465 */     GL45C.glGetQueryBufferObjectuiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetQueryBufferObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3481 */     GL45C.glGetQueryBufferObjecti64v(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetQueryBufferObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong) {
/* 3497 */     GL45C.glGetQueryBufferObjectui64v(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glMemoryBarrierByRegion(@NativeType("GLbitfield") int paramInt) {
/* 3522 */     GL45C.glMemoryBarrierByRegion(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong) {
/* 3533 */     GL45C.nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLsizei") int paramInt11, @NativeType("void *") long paramLong) {
/* 3555 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 3576 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 3597 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramShortBuffer);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 3618 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramIntBuffer);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 3639 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloatBuffer);
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
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 3660 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong) {
/* 3671 */     GL45C.nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("void *") long paramLong) {
/* 3691 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 3710 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 3729 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 3748 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 3767 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer);
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
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 3786 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureBarrier() {
/* 3797 */     GL45C.glTextureBarrier();
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
/*      */   @NativeType("GLenum")
/*      */   public static int glGetGraphicsResetStatus() {
/* 3841 */     return GL45C.glGetGraphicsResetStatus();
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
/*      */   public static void glGetnMapdv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 3863 */     nglGetnMapdv(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetnMapd(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3876 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3878 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 3879 */       nglGetnMapdv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(doubleBuffer));
/* 3880 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 3882 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetnMapfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 3905 */     nglGetnMapfv(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetnMapf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3918 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3920 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 3921 */       nglGetnMapfv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(floatBuffer));
/* 3922 */       return floatBuffer.get(0);
/*      */     } finally {
/* 3924 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetnMapiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3947 */     nglGetnMapiv(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetnMapi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3960 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3962 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3963 */       nglGetnMapiv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/* 3964 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3966 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetnPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 3988 */     nglGetnPixelMapfv(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetnPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 4009 */     nglGetnPixelMapuiv(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetnPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") ShortBuffer paramShortBuffer) {
/* 4030 */     nglGetnPixelMapusv(paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glGetnPolygonStipple(@NativeType("GLsizei") int paramInt, @NativeType("GLubyte *") long paramLong) {
/* 4051 */     nglGetnPolygonStipple(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPolygonStipple(@NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/* 4062 */     nglGetnPolygonStipple(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 4073 */     GL45C.nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong) {
/* 4089 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4104 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 4119 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 4134 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 4149 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
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
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 4164 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {
/* 4175 */     GL45C.nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void *") long paramLong) {
/* 4193 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4210 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
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
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 4227 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
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
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 4244 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
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
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 4261 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
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
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/* 4285 */     nglGetnColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4299 */     nglGetnColorTable(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 4313 */     nglGetnColorTable(paramInt1, paramInt2, paramInt3, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 4327 */     nglGetnColorTable(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 4341 */     nglGetnColorTable(paramInt1, paramInt2, paramInt3, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetnConvolutionFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/* 4365 */     nglGetnConvolutionFilter(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetnConvolutionFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4379 */     nglGetnConvolutionFilter(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glGetnSeparableFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong1, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4406 */     nglGetnSeparableFilter(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramInt5, paramLong2, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*      */   public static void glGetnSeparableFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer3) {
/* 4421 */     nglGetnSeparableFilter(paramInt1, paramInt2, paramInt3, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddressSafe(paramByteBuffer3));
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
/*      */   public static void glGetnHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/* 4446 */     nglGetnHistogram(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetnHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4461 */     nglGetnHistogram(paramInt1, paramBoolean, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glGetnMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/* 4487 */     nglGetnMinmax(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetnMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4503 */     nglGetnMinmax(paramInt1, paramBoolean, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnCompressedTexImage(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 4514 */     GL45C.nglGetnCompressedTexImage(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void *") long paramLong) {
/* 4528 */     GL45C.glGetnCompressedTexImage(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 4541 */     GL45C.glGetnCompressedTexImage(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 4552 */     GL45C.nglGetnUniformfv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 4565 */     GL45C.glGetnUniformfv(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   @NativeType("void")
/*      */   public static float glGetnUniformf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 4578 */     return GL45C.glGetnUniformf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformdv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 4589 */     GL45C.nglGetnUniformdv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 4602 */     GL45C.glGetnUniformdv(paramInt1, paramInt2, paramDoubleBuffer);
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
/*      */   @NativeType("void")
/*      */   public static double glGetnUniformd(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 4615 */     return GL45C.glGetnUniformd(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 4626 */     GL45C.nglGetnUniformiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 4639 */     GL45C.glGetnUniformiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 4652 */     return GL45C.glGetnUniformi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetnUniformuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 4663 */     GL45C.nglGetnUniformuiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 4676 */     GL45C.glGetnUniformuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 4689 */     return GL45C.glGetnUniformui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4698 */     GL45C.glCreateTransformFeedbacks(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4707 */     GL45C.glGetTransformFeedbackiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4716 */     GL45C.glGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 4725 */     GL45C.glGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4734 */     GL45C.glCreateBuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 4743 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 4752 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 4761 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 4770 */     GL45C.glNamedBufferStorage(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 4779 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 4788 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") long[] paramArrayOflong, @NativeType("GLenum") int paramInt2) {
/* 4797 */     GL45C.glNamedBufferData(paramInt1, paramArrayOflong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 4806 */     GL45C.glNamedBufferData(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 4815 */     GL45C.glNamedBufferData(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4824 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 4833 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") long[] paramArrayOflong) {
/* 4842 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4851 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 4860 */     GL45C.glNamedBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4869 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 4878 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4887 */     GL45C.glClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4896 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 4905 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4914 */     GL45C.glClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4923 */     GL45C.glGetNamedBufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 4932 */     GL45C.glGetNamedBufferParameteri64v(paramInt1, paramInt2, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 4941 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 4950 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") long[] paramArrayOflong) {
/* 4959 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 4968 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 4977 */     GL45C.glGetNamedBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4986 */     GL45C.glCreateFramebuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 4995 */     GL45C.glNamedFramebufferDrawBuffers(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 5004 */     GL45C.glInvalidateNamedFramebufferData(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 5013 */     GL45C.glInvalidateNamedFramebufferSubData(paramInt1, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5022 */     GL45C.glClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5031 */     GL45C.glClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 5040 */     GL45C.glClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5049 */     GL45C.glGetNamedFramebufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5058 */     GL45C.glGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5067 */     GL45C.glCreateRenderbuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5076 */     GL45C.glGetNamedRenderbufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5085 */     GL45C.glCreateTextures(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") short[] paramArrayOfshort) {
/* 5094 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") int[] paramArrayOfint) {
/* 5103 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") float[] paramArrayOffloat) {
/* 5112 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 5121 */     GL45C.glTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 5130 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 5139 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 5148 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 5157 */     GL45C.glTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 5166 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 5175 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 5184 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 5193 */     GL45C.glTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 5202 */     GL45C.glTextureParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5211 */     GL45C.glTextureParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 5220 */     GL45C.glTextureParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5229 */     GL45C.glTextureParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 5238 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 5247 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 5256 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5265 */     GL45C.glGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5274 */     GL45C.glGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5283 */     GL45C.glGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5292 */     GL45C.glGetTextureParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5301 */     GL45C.glGetTextureParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5310 */     GL45C.glGetTextureParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5319 */     GL45C.glGetTextureParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5328 */     GL45C.glCreateVertexArrays(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 5337 */     GL45C.glVertexArrayVertexBuffers(paramInt1, paramInt2, paramArrayOfint1, paramPointerBuffer, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5346 */     GL45C.glGetVertexArrayiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5355 */     GL45C.glGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 5364 */     GL45C.glGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5373 */     GL45C.glCreateSamplers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5382 */     GL45C.glCreateProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5391 */     GL45C.glCreateQueries(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") short[] paramArrayOfshort) {
/* 5400 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") int[] paramArrayOfint) {
/* 5409 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") float[] paramArrayOffloat) {
/* 5418 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5427 */     GL45C.glGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") short[] paramArrayOfshort) {
/* 5436 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") int[] paramArrayOfint) {
/* 5445 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") float[] paramArrayOffloat) {
/* 5454 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5463 */     GL45C.glGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapdv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 5472 */     long l = (GL.getICD()).glGetnMapdv;
/* 5473 */     if (Checks.CHECKS) {
/* 5474 */       Checks.check(l);
/*      */     }
/* 5476 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5485 */     long l = (GL.getICD()).glGetnMapfv;
/* 5486 */     if (Checks.CHECKS) {
/* 5487 */       Checks.check(l);
/*      */     }
/* 5489 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5498 */     long l = (GL.getICD()).glGetnMapiv;
/* 5499 */     if (Checks.CHECKS) {
/* 5500 */       Checks.check(l);
/*      */     }
/* 5502 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5511 */     long l = (GL.getICD()).glGetnPixelMapfv;
/* 5512 */     if (Checks.CHECKS) {
/* 5513 */       Checks.check(l);
/*      */     }
/* 5515 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5524 */     long l = (GL.getICD()).glGetnPixelMapuiv;
/* 5525 */     if (Checks.CHECKS) {
/* 5526 */       Checks.check(l);
/*      */     }
/* 5528 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapusv(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") short[] paramArrayOfshort) {
/* 5537 */     long l = (GL.getICD()).glGetnPixelMapusv;
/* 5538 */     if (Checks.CHECKS) {
/* 5539 */       Checks.check(l);
/*      */     }
/* 5541 */     JNI.callPV(paramInt, paramArrayOfshort.length, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 5550 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 5559 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 5568 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5577 */     GL45C.glGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/* 5586 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 5595 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 5604 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") short[] paramArrayOfshort) {
/* 5613 */     long l = (GL.getICD()).glGetnColorTable;
/* 5614 */     if (Checks.CHECKS) {
/* 5615 */       Checks.check(l);
/*      */     }
/* 5617 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") int[] paramArrayOfint) {
/* 5626 */     long l = (GL.getICD()).glGetnColorTable;
/* 5627 */     if (Checks.CHECKS) {
/* 5628 */       Checks.check(l);
/*      */     }
/* 5630 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") float[] paramArrayOffloat) {
/* 5639 */     long l = (GL.getICD()).glGetnColorTable;
/* 5640 */     if (Checks.CHECKS) {
/* 5641 */       Checks.check(l);
/*      */     }
/* 5643 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5652 */     GL45C.glGetnUniformfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 5661 */     GL45C.glGetnUniformdv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5670 */     GL45C.glGetnUniformiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5679 */     GL45C.glGetnUniformuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */   
/*      */   public static native void nglGetnMapdv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapusv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPolygonStipple(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetnColorTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnConvolutionFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnSeparableFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglGetnHistogram(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnMinmax(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL45.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */