/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ 
/*      */ public class GL45C
/*      */   extends GL44C {
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
/*   45 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL45C() {
/*  102 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  140 */     nglCreateTransformFeedbacks(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTransformFeedbacks() {
/*      */     MemoryStack memoryStack;
/*  150 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  152 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  153 */       nglCreateTransformFeedbacks(1, MemoryUtil.memAddress(intBuffer));
/*  154 */       return intBuffer.get(0);
/*      */     } finally {
/*  156 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  203 */     if (Checks.CHECKS) {
/*  204 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  206 */     nglGetTransformFeedbackiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTransformFeedbacki(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  219 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  221 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  222 */       nglGetTransformFeedbackiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  223 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  225 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  245 */     if (Checks.CHECKS) {
/*  246 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  248 */     nglGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  262 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  264 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  265 */       nglGetTransformFeedbacki_v(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/*  266 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  268 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  288 */     if (Checks.CHECKS) {
/*  289 */       Checks.check(paramLongBuffer, 1);
/*      */     }
/*  291 */     nglGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramLongBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  305 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  307 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/*  308 */       nglGetTransformFeedbacki64_v(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(longBuffer));
/*  309 */       return longBuffer.get(0);
/*      */     } finally {
/*  311 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  333 */     nglCreateBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateBuffers() {
/*      */     MemoryStack memoryStack;
/*  344 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  346 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  347 */       nglCreateBuffers(1, MemoryUtil.memAddress(intBuffer));
/*  348 */       return intBuffer.get(0);
/*      */     } finally {
/*  350 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  408 */     nglNamedBufferStorage(paramInt1, paramLong, 0L, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  457 */     nglNamedBufferStorage(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  506 */     nglNamedBufferStorage(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  555 */     nglNamedBufferStorage(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  604 */     nglNamedBufferStorage(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  653 */     nglNamedBufferStorage(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  674 */     nglNamedBufferData(paramInt1, paramLong, 0L, paramInt2);
/*      */   }
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
/*  686 */     nglNamedBufferData(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
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
/*  698 */     nglNamedBufferData(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
/*      */   }
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
/*  710 */     nglNamedBufferData(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
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
/*  722 */     nglNamedBufferData(paramInt1, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer), paramInt2);
/*      */   }
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
/*  734 */     nglNamedBufferData(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
/*      */   }
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
/*  746 */     nglNamedBufferData(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  767 */     nglNamedBufferSubData(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*  779 */     nglNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
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
/*  791 */     nglNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*  803 */     nglNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer));
/*      */   }
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
/*  815 */     nglNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
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
/*  827 */     nglNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  864 */     nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  881 */     nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  898 */     nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  915 */     nglClearNamedBufferData(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  939 */     nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  958 */     nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  977 */     nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  996 */     nglClearNamedBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     long l;
/* 1016 */     return MemoryUtil.memByteBufferSafe(l = nglMapNamedBuffer(paramInt1, paramInt2), glGetNamedBufferParameteri(paramInt1, 34660));
/*      */   }
/*      */ 
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
/* 1030 */     long l = nglMapNamedBuffer(paramInt1, paramInt2);
/* 1031 */     paramInt1 = glGetNamedBufferParameteri(paramInt1, 34660);
/* 1032 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, paramInt1);
/*      */   }
/*      */ 
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
/* 1046 */     long l = nglMapNamedBuffer(paramInt1, paramInt2);
/* 1047 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     long l;
/* 1069 */     return MemoryUtil.memByteBufferSafe(l = nglMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2), (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1085 */     long l = nglMapNamedBufferRange(paramInt1, paramLong1, paramLong2, paramInt2);
/* 1086 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1129 */     if (Checks.CHECKS) {
/* 1130 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1132 */     nglGetNamedBufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetNamedBufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1145 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1147 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1148 */       nglGetNamedBufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1149 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1151 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 1170 */     if (Checks.CHECKS) {
/* 1171 */       Checks.check(paramLongBuffer, 1);
/*      */     }
/* 1173 */     nglGetNamedBufferParameteri64v(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
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
/*      */   public static long glGetNamedBufferParameteri64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1186 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1188 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 1189 */       nglGetNamedBufferParameteri64v(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 1190 */       return longBuffer.get(0);
/*      */     } finally {
/* 1192 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetNamedBufferPointerv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1211 */     if (Checks.CHECKS) {
/* 1212 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1214 */     nglGetNamedBufferPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
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
/*      */   public static long glGetNamedBufferPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1227 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1229 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 1230 */       nglGetNamedBufferPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1231 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 1233 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1256 */     nglGetNamedBufferSubData(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
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
/* 1269 */     nglGetNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
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
/* 1282 */     nglGetNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
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
/* 1295 */     nglGetNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer));
/*      */   }
/*      */ 
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
/* 1308 */     nglGetNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
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
/* 1321 */     nglGetNamedBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1341 */     nglCreateFramebuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateFramebuffers() {
/*      */     MemoryStack memoryStack;
/* 1351 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1353 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1354 */       nglCreateFramebuffers(1, MemoryUtil.memAddress(intBuffer));
/* 1355 */       return intBuffer.get(0);
/*      */     } finally {
/* 1357 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1447 */     nglNamedFramebufferDrawBuffers(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1458 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1460 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1461 */       nglNamedFramebufferDrawBuffers(paramInt1, 1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1463 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
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
/* 1497 */     nglInvalidateNamedFramebufferData(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1508 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1510 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1511 */       nglInvalidateNamedFramebufferData(paramInt1, 1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1513 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 1539 */     nglInvalidateNamedFramebufferSubData(paramInt1, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/* 1554 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1556 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1557 */       nglInvalidateNamedFramebufferSubData(paramInt1, 1, MemoryUtil.memAddress(intBuffer), paramInt3, paramInt4, paramInt5, paramInt6); return;
/*      */     } finally {
/* 1559 */       memoryStack.setPointer(i);
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
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1580 */     if (Checks.CHECKS) {
/* 1581 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1583 */     nglClearNamedFramebufferiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1602 */     if (Checks.CHECKS) {
/* 1603 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1605 */     nglClearNamedFramebufferuiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1625 */     if (Checks.CHECKS) {
/* 1626 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1628 */     nglClearNamedFramebufferfv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1696 */     if (Checks.CHECKS) {
/* 1697 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1699 */     nglGetNamedFramebufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1712 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1714 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1715 */       nglGetNamedFramebufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1716 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1718 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1738 */     if (Checks.CHECKS) {
/* 1739 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1741 */     nglGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1755 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1757 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1758 */       nglGetNamedFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1759 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1761 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1782 */     nglCreateRenderbuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateRenderbuffers() {
/*      */     MemoryStack memoryStack;
/* 1792 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1794 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1795 */       nglCreateRenderbuffers(1, MemoryUtil.memAddress(intBuffer));
/* 1796 */       return intBuffer.get(0);
/*      */     } finally {
/* 1798 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1843 */     if (Checks.CHECKS) {
/* 1844 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1846 */     nglGetNamedRenderbufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1858 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1860 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1861 */       nglGetNamedRenderbufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1862 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1864 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1886 */     nglCreateTextures(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateTextures(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1898 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1900 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1901 */       nglCreateTextures(paramInt, 1, MemoryUtil.memAddress(intBuffer));
/* 1902 */       paramInt = intBuffer.get(0); return paramInt;
/*      */     } finally {
/* 1904 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2035 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2052 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2069 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2086 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2103 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2120 */     nglTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2144 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2163 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2182 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2201 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2220 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2239 */     nglTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2265 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2286 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2307 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2328 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2349 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2370 */     nglTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2396 */     nglCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2412 */     nglCompressedTextureSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2440 */     nglCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2458 */     nglCompressedTextureSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2488 */     nglCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2508 */     nglCompressedTextureSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2592 */     if (Checks.CHECKS) {
/* 2593 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 2595 */     nglTextureParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2626 */     if (Checks.CHECKS) {
/* 2627 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2629 */     nglTextureParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2641 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2643 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 2644 */       nglTextureParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 2646 */       memoryStack.setPointer(i);
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
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2665 */     if (Checks.CHECKS) {
/* 2666 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2668 */     nglTextureParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2680 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2682 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 2683 */       nglTextureParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 2685 */       memoryStack.setPointer(i);
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
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2704 */     if (Checks.CHECKS) {
/* 2705 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2707 */     nglTextureParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2759 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2774 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2789 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2804 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2819 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2834 */     nglGetTextureImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer.remaining() << 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2857 */     nglGetCompressedTextureImage(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
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
/* 2870 */     if (Checks.CHECKS && 
/* 2871 */       Checks.DEBUG) {
/* 2872 */       Checks.check(paramByteBuffer, glGetTextureLevelParameteri(paramInt1, paramInt2, 34464));
/*      */     }
/*      */     
/* 2875 */     nglGetCompressedTextureImage(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2894 */     if (Checks.CHECKS) {
/* 2895 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2897 */     nglGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 2911 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2913 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 2914 */       nglGetTextureLevelParameterfv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/* 2915 */       return floatBuffer.get(0);
/*      */     } finally {
/* 2917 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2937 */     if (Checks.CHECKS) {
/* 2938 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2940 */     nglGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 2954 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2956 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2957 */       nglGetTextureLevelParameteriv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2958 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2960 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2979 */     if (Checks.CHECKS) {
/* 2980 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2982 */     nglGetTextureParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2995 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2997 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 2998 */       nglGetTextureParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 2999 */       return floatBuffer.get(0);
/*      */     } finally {
/* 3001 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3020 */     if (Checks.CHECKS) {
/* 3021 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3023 */     nglGetTextureParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTextureParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3036 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3038 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3039 */       nglGetTextureParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3040 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3042 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3061 */     if (Checks.CHECKS) {
/* 3062 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3064 */     nglGetTextureParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTextureParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3077 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3079 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3080 */       nglGetTextureParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3081 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3083 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3102 */     if (Checks.CHECKS) {
/* 3103 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3105 */     nglGetTextureParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3118 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3120 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3121 */       nglGetTextureParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3122 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3124 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3145 */     nglCreateVertexArrays(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateVertexArrays() {
/*      */     MemoryStack memoryStack;
/* 3155 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3157 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3158 */       nglCreateVertexArrays(1, MemoryUtil.memAddress(intBuffer));
/* 3159 */       return intBuffer.get(0);
/*      */     } finally {
/* 3161 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3237 */     if (Checks.CHECKS) {
/* 3238 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, Checks.remainingSafe(paramIntBuffer1));
/* 3239 */       Checks.checkSafe(paramIntBuffer2, Checks.remainingSafe(paramIntBuffer1));
/*      */     } 
/* 3241 */     nglVertexArrayVertexBuffers(paramInt1, paramInt2, Checks.remainingSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3332 */     if (Checks.CHECKS) {
/* 3333 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3335 */     nglGetVertexArrayiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetVertexArrayi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 3348 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3350 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3351 */       nglGetVertexArrayiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 3352 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3354 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 3374 */     if (Checks.CHECKS) {
/* 3375 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 3377 */     nglGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 3391 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3393 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3394 */       nglGetVertexArrayIndexediv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 3395 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 3397 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 3417 */     if (Checks.CHECKS) {
/* 3418 */       Checks.check(paramLongBuffer, 1);
/*      */     }
/* 3420 */     nglGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramLongBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 3434 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3436 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 3437 */       nglGetVertexArrayIndexed64iv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(longBuffer));
/* 3438 */       return longBuffer.get(0);
/*      */     } finally {
/* 3440 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3461 */     nglCreateSamplers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateSamplers() {
/*      */     MemoryStack memoryStack;
/* 3471 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3473 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3474 */       nglCreateSamplers(1, MemoryUtil.memAddress(intBuffer));
/* 3475 */       return intBuffer.get(0);
/*      */     } finally {
/* 3477 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3498 */     nglCreateProgramPipelines(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateProgramPipelines() {
/*      */     MemoryStack memoryStack;
/* 3508 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3510 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3511 */       nglCreateProgramPipelines(1, MemoryUtil.memAddress(intBuffer));
/* 3512 */       return intBuffer.get(0);
/*      */     } finally {
/* 3514 */       memoryStack.setPointer(i);
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
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 3536 */     nglCreateQueries(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glCreateQueries(@NativeType("GLenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 3548 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 3550 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 3551 */       nglCreateQueries(paramInt, 1, MemoryUtil.memAddress(intBuffer));
/* 3552 */       paramInt = intBuffer.get(0); return paramInt;
/*      */     } finally {
/* 3554 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3665 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3686 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3707 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3728 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3749 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3770 */     nglGetTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramDoubleBuffer.remaining() << 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3799 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3818 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3837 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3856 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3875 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3894 */     nglGetCompressedTextureSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramDoubleBuffer.remaining() << 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 3970 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 3985 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 4000 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 4015 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 4030 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 4045 */     nglGetnTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer.remaining() << 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4072 */     nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4089 */     nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4106 */     nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4123 */     nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4140 */     nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4163 */     nglGetnCompressedTexImage(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
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
/* 4176 */     if (Checks.CHECKS && 
/* 4177 */       Checks.DEBUG) {
/* 4178 */       Checks.check(paramByteBuffer, GL11.glGetTexLevelParameteri(paramInt1, paramInt2, 34464));
/*      */     }
/*      */     
/* 4181 */     nglGetnCompressedTexImage(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 4203 */     nglGetnUniformfv(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetnUniformf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 4216 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 4218 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 4219 */       nglGetnUniformfv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(floatBuffer));
/* 4220 */       return floatBuffer.get(0);
/*      */     } finally {
/* 4222 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 4245 */     nglGetnUniformdv(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetnUniformd(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 4258 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 4260 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 4261 */       nglGetnUniformdv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(doubleBuffer));
/* 4262 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 4264 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 4287 */     nglGetnUniformiv(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetnUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 4300 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 4302 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 4303 */       nglGetnUniformiv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/* 4304 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 4306 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 4329 */     nglGetnUniformuiv(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetnUniformui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 4342 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 4344 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 4345 */       nglGetnUniformuiv(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/* 4346 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 4348 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4358 */     long l = (GL.getICD()).glCreateTransformFeedbacks;
/* 4359 */     if (Checks.CHECKS) {
/* 4360 */       Checks.check(l);
/*      */     }
/* 4362 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbackiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4371 */     long l = (GL.getICD()).glGetTransformFeedbackiv;
/* 4372 */     if (Checks.CHECKS) {
/* 4373 */       Checks.check(l);
/* 4374 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4376 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4385 */     long l = (GL.getICD()).glGetTransformFeedbacki_v;
/* 4386 */     if (Checks.CHECKS) {
/* 4387 */       Checks.check(l);
/* 4388 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4390 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTransformFeedbacki64_v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 4399 */     long l = (GL.getICD()).glGetTransformFeedbacki64_v;
/* 4400 */     if (Checks.CHECKS) {
/* 4401 */       Checks.check(l);
/* 4402 */       Checks.check(paramArrayOflong, 1);
/*      */     } 
/* 4404 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateBuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4413 */     long l = (GL.getICD()).glCreateBuffers;
/* 4414 */     if (Checks.CHECKS) {
/* 4415 */       Checks.check(l);
/*      */     }
/* 4417 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 4426 */     long l = (GL.getICD()).glNamedBufferStorage;
/* 4427 */     if (Checks.CHECKS) {
/* 4428 */       Checks.check(l);
/*      */     }
/* 4430 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 4439 */     long l = (GL.getICD()).glNamedBufferStorage;
/* 4440 */     if (Checks.CHECKS) {
/* 4441 */       Checks.check(l);
/*      */     }
/* 4443 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 4452 */     long l = (GL.getICD()).glNamedBufferStorage;
/* 4453 */     if (Checks.CHECKS) {
/* 4454 */       Checks.check(l);
/*      */     }
/* 4456 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 4465 */     long l = (GL.getICD()).glNamedBufferStorage;
/* 4466 */     if (Checks.CHECKS) {
/* 4467 */       Checks.check(l);
/*      */     }
/* 4469 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 4478 */     long l = (GL.getICD()).glNamedBufferData;
/* 4479 */     if (Checks.CHECKS) {
/* 4480 */       Checks.check(l);
/*      */     }
/* 4482 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 4491 */     long l = (GL.getICD()).glNamedBufferData;
/* 4492 */     if (Checks.CHECKS) {
/* 4493 */       Checks.check(l);
/*      */     }
/* 4495 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") long[] paramArrayOflong, @NativeType("GLenum") int paramInt2) {
/* 4504 */     long l = (GL.getICD()).glNamedBufferData;
/* 4505 */     if (Checks.CHECKS) {
/* 4506 */       Checks.check(l);
/*      */     }
/* 4508 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 4517 */     long l = (GL.getICD()).glNamedBufferData;
/* 4518 */     if (Checks.CHECKS) {
/* 4519 */       Checks.check(l);
/*      */     }
/* 4521 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 4530 */     long l = (GL.getICD()).glNamedBufferData;
/* 4531 */     if (Checks.CHECKS) {
/* 4532 */       Checks.check(l);
/*      */     }
/* 4534 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4543 */     long l = (GL.getICD()).glNamedBufferSubData;
/* 4544 */     if (Checks.CHECKS) {
/* 4545 */       Checks.check(l);
/*      */     }
/* 4547 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 4556 */     long l = (GL.getICD()).glNamedBufferSubData;
/* 4557 */     if (Checks.CHECKS) {
/* 4558 */       Checks.check(l);
/*      */     }
/* 4560 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") long[] paramArrayOflong) {
/* 4569 */     long l = (GL.getICD()).glNamedBufferSubData;
/* 4570 */     if (Checks.CHECKS) {
/* 4571 */       Checks.check(l);
/*      */     }
/* 4573 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4582 */     long l = (GL.getICD()).glNamedBufferSubData;
/* 4583 */     if (Checks.CHECKS) {
/* 4584 */       Checks.check(l);
/*      */     }
/* 4586 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 4595 */     long l = (GL.getICD()).glNamedBufferSubData;
/* 4596 */     if (Checks.CHECKS) {
/* 4597 */       Checks.check(l);
/*      */     }
/* 4599 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4608 */     long l = (GL.getICD()).glClearNamedBufferData;
/* 4609 */     if (Checks.CHECKS) {
/* 4610 */       Checks.check(l);
/*      */     }
/* 4612 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 4621 */     long l = (GL.getICD()).glClearNamedBufferData;
/* 4622 */     if (Checks.CHECKS) {
/* 4623 */       Checks.check(l);
/*      */     }
/* 4625 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4634 */     long l = (GL.getICD()).glClearNamedBufferData;
/* 4635 */     if (Checks.CHECKS) {
/* 4636 */       Checks.check(l);
/*      */     }
/* 4638 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4647 */     long l = (GL.getICD()).glClearNamedBufferSubData;
/* 4648 */     if (Checks.CHECKS) {
/* 4649 */       Checks.check(l);
/*      */     }
/* 4651 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 4660 */     long l = (GL.getICD()).glClearNamedBufferSubData;
/* 4661 */     if (Checks.CHECKS) {
/* 4662 */       Checks.check(l);
/*      */     }
/* 4664 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4673 */     long l = (GL.getICD()).glClearNamedBufferSubData;
/* 4674 */     if (Checks.CHECKS) {
/* 4675 */       Checks.check(l);
/*      */     }
/* 4677 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4686 */     long l = (GL.getICD()).glGetNamedBufferParameteriv;
/* 4687 */     if (Checks.CHECKS) {
/* 4688 */       Checks.check(l);
/* 4689 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4691 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameteri64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 4700 */     long l = (GL.getICD()).glGetNamedBufferParameteri64v;
/* 4701 */     if (Checks.CHECKS) {
/* 4702 */       Checks.check(l);
/* 4703 */       Checks.check(paramArrayOflong, 1);
/*      */     } 
/* 4705 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 4714 */     long l = (GL.getICD()).glGetNamedBufferSubData;
/* 4715 */     if (Checks.CHECKS) {
/* 4716 */       Checks.check(l);
/*      */     }
/* 4718 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 4727 */     long l = (GL.getICD()).glGetNamedBufferSubData;
/* 4728 */     if (Checks.CHECKS) {
/* 4729 */       Checks.check(l);
/*      */     }
/* 4731 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") long[] paramArrayOflong) {
/* 4740 */     long l = (GL.getICD()).glGetNamedBufferSubData;
/* 4741 */     if (Checks.CHECKS) {
/* 4742 */       Checks.check(l);
/*      */     }
/* 4744 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 4753 */     long l = (GL.getICD()).glGetNamedBufferSubData;
/* 4754 */     if (Checks.CHECKS) {
/* 4755 */       Checks.check(l);
/*      */     }
/* 4757 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 4766 */     long l = (GL.getICD()).glGetNamedBufferSubData;
/* 4767 */     if (Checks.CHECKS) {
/* 4768 */       Checks.check(l);
/*      */     }
/* 4770 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4779 */     long l = (GL.getICD()).glCreateFramebuffers;
/* 4780 */     if (Checks.CHECKS) {
/* 4781 */       Checks.check(l);
/*      */     }
/* 4783 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedFramebufferDrawBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 4792 */     long l = (GL.getICD()).glNamedFramebufferDrawBuffers;
/* 4793 */     if (Checks.CHECKS) {
/* 4794 */       Checks.check(l);
/*      */     }
/* 4796 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferData(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 4805 */     long l = (GL.getICD()).glInvalidateNamedFramebufferData;
/* 4806 */     if (Checks.CHECKS) {
/* 4807 */       Checks.check(l);
/*      */     }
/* 4809 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glInvalidateNamedFramebufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 4818 */     long l = (GL.getICD()).glInvalidateNamedFramebufferSubData;
/* 4819 */     if (Checks.CHECKS) {
/* 4820 */       Checks.check(l);
/*      */     }
/* 4822 */     JNI.callPV(paramInt1, paramArrayOfint.length, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 4831 */     long l = (GL.getICD()).glClearNamedFramebufferiv;
/* 4832 */     if (Checks.CHECKS) {
/* 4833 */       Checks.check(l);
/* 4834 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4836 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 4845 */     long l = (GL.getICD()).glClearNamedFramebufferuiv;
/* 4846 */     if (Checks.CHECKS) {
/* 4847 */       Checks.check(l);
/* 4848 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 4850 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearNamedFramebufferfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 4859 */     long l = (GL.getICD()).glClearNamedFramebufferfv;
/* 4860 */     if (Checks.CHECKS) {
/* 4861 */       Checks.check(l);
/* 4862 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 4864 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4873 */     long l = (GL.getICD()).glGetNamedFramebufferParameteriv;
/* 4874 */     if (Checks.CHECKS) {
/* 4875 */       Checks.check(l);
/* 4876 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4878 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4887 */     long l = (GL.getICD()).glGetNamedFramebufferAttachmentParameteriv;
/* 4888 */     if (Checks.CHECKS) {
/* 4889 */       Checks.check(l);
/* 4890 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4892 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 4901 */     long l = (GL.getICD()).glCreateRenderbuffers;
/* 4902 */     if (Checks.CHECKS) {
/* 4903 */       Checks.check(l);
/*      */     }
/* 4905 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4914 */     long l = (GL.getICD()).glGetNamedRenderbufferParameteriv;
/* 4915 */     if (Checks.CHECKS) {
/* 4916 */       Checks.check(l);
/* 4917 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4919 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateTextures(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 4928 */     long l = (GL.getICD()).glCreateTextures;
/* 4929 */     if (Checks.CHECKS) {
/* 4930 */       Checks.check(l);
/*      */     }
/* 4932 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4941 */     long l = (GL.getICD()).glTextureSubImage1D;
/* 4942 */     if (Checks.CHECKS) {
/* 4943 */       Checks.check(l);
/*      */     }
/* 4945 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") int[] paramArrayOfint) {
/* 4954 */     long l = (GL.getICD()).glTextureSubImage1D;
/* 4955 */     if (Checks.CHECKS) {
/* 4956 */       Checks.check(l);
/*      */     }
/* 4958 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") float[] paramArrayOffloat) {
/* 4967 */     long l = (GL.getICD()).glTextureSubImage1D;
/* 4968 */     if (Checks.CHECKS) {
/* 4969 */       Checks.check(l);
/*      */     }
/* 4971 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 4980 */     long l = (GL.getICD()).glTextureSubImage1D;
/* 4981 */     if (Checks.CHECKS) {
/* 4982 */       Checks.check(l);
/*      */     }
/* 4984 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 4993 */     long l = (GL.getICD()).glTextureSubImage2D;
/* 4994 */     if (Checks.CHECKS) {
/* 4995 */       Checks.check(l);
/*      */     }
/* 4997 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 5006 */     long l = (GL.getICD()).glTextureSubImage2D;
/* 5007 */     if (Checks.CHECKS) {
/* 5008 */       Checks.check(l);
/*      */     }
/* 5010 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 5019 */     long l = (GL.getICD()).glTextureSubImage2D;
/* 5020 */     if (Checks.CHECKS) {
/* 5021 */       Checks.check(l);
/*      */     }
/* 5023 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 5032 */     long l = (GL.getICD()).glTextureSubImage2D;
/* 5033 */     if (Checks.CHECKS) {
/* 5034 */       Checks.check(l);
/*      */     }
/* 5036 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 5045 */     long l = (GL.getICD()).glTextureSubImage3D;
/* 5046 */     if (Checks.CHECKS) {
/* 5047 */       Checks.check(l);
/*      */     }
/* 5049 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 5058 */     long l = (GL.getICD()).glTextureSubImage3D;
/* 5059 */     if (Checks.CHECKS) {
/* 5060 */       Checks.check(l);
/*      */     }
/* 5062 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 5071 */     long l = (GL.getICD()).glTextureSubImage3D;
/* 5072 */     if (Checks.CHECKS) {
/* 5073 */       Checks.check(l);
/*      */     }
/* 5075 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 5084 */     long l = (GL.getICD()).glTextureSubImage3D;
/* 5085 */     if (Checks.CHECKS) {
/* 5086 */       Checks.check(l);
/*      */     }
/* 5088 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 5097 */     long l = (GL.getICD()).glTextureParameterfv;
/* 5098 */     if (Checks.CHECKS) {
/* 5099 */       Checks.check(l);
/* 5100 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 5102 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5111 */     long l = (GL.getICD()).glTextureParameterIiv;
/* 5112 */     if (Checks.CHECKS) {
/* 5113 */       Checks.check(l);
/* 5114 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5116 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 5125 */     long l = (GL.getICD()).glTextureParameterIuiv;
/* 5126 */     if (Checks.CHECKS) {
/* 5127 */       Checks.check(l);
/* 5128 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5130 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 5139 */     long l = (GL.getICD()).glTextureParameteriv;
/* 5140 */     if (Checks.CHECKS) {
/* 5141 */       Checks.check(l);
/* 5142 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 5144 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 5153 */     long l = (GL.getICD()).glGetTextureImage;
/* 5154 */     if (Checks.CHECKS) {
/* 5155 */       Checks.check(l);
/*      */     }
/* 5157 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 5166 */     long l = (GL.getICD()).glGetTextureImage;
/* 5167 */     if (Checks.CHECKS) {
/* 5168 */       Checks.check(l);
/*      */     }
/* 5170 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 5179 */     long l = (GL.getICD()).glGetTextureImage;
/* 5180 */     if (Checks.CHECKS) {
/* 5181 */       Checks.check(l);
/*      */     }
/* 5183 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5192 */     long l = (GL.getICD()).glGetTextureImage;
/* 5193 */     if (Checks.CHECKS) {
/* 5194 */       Checks.check(l);
/*      */     }
/* 5196 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble.length << 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5205 */     long l = (GL.getICD()).glGetTextureLevelParameterfv;
/* 5206 */     if (Checks.CHECKS) {
/* 5207 */       Checks.check(l);
/* 5208 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 5210 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5219 */     long l = (GL.getICD()).glGetTextureLevelParameteriv;
/* 5220 */     if (Checks.CHECKS) {
/* 5221 */       Checks.check(l);
/* 5222 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5224 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5233 */     long l = (GL.getICD()).glGetTextureParameterfv;
/* 5234 */     if (Checks.CHECKS) {
/* 5235 */       Checks.check(l);
/* 5236 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 5238 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5247 */     long l = (GL.getICD()).glGetTextureParameterIiv;
/* 5248 */     if (Checks.CHECKS) {
/* 5249 */       Checks.check(l);
/* 5250 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5252 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5261 */     long l = (GL.getICD()).glGetTextureParameterIuiv;
/* 5262 */     if (Checks.CHECKS) {
/* 5263 */       Checks.check(l);
/* 5264 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5266 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5275 */     long l = (GL.getICD()).glGetTextureParameteriv;
/* 5276 */     if (Checks.CHECKS) {
/* 5277 */       Checks.check(l);
/* 5278 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5280 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5289 */     long l = (GL.getICD()).glCreateVertexArrays;
/* 5290 */     if (Checks.CHECKS) {
/* 5291 */       Checks.check(l);
/*      */     }
/* 5293 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexArrayVertexBuffers(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 5302 */     long l = (GL.getICD()).glVertexArrayVertexBuffers;
/* 5303 */     if (Checks.CHECKS) {
/* 5304 */       Checks.check(l);
/* 5305 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, Checks.lengthSafe(paramArrayOfint1));
/* 5306 */       Checks.checkSafe(paramArrayOfint2, Checks.lengthSafe(paramArrayOfint1));
/*      */     } 
/* 5308 */     JNI.callPPPV(paramInt1, paramInt2, Checks.lengthSafe(paramArrayOfint1), paramArrayOfint1, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5317 */     long l = (GL.getICD()).glGetVertexArrayiv;
/* 5318 */     if (Checks.CHECKS) {
/* 5319 */       Checks.check(l);
/* 5320 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5322 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexediv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5331 */     long l = (GL.getICD()).glGetVertexArrayIndexediv;
/* 5332 */     if (Checks.CHECKS) {
/* 5333 */       Checks.check(l);
/* 5334 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 5336 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIndexed64iv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 5345 */     long l = (GL.getICD()).glGetVertexArrayIndexed64iv;
/* 5346 */     if (Checks.CHECKS) {
/* 5347 */       Checks.check(l);
/* 5348 */       Checks.check(paramArrayOflong, 1);
/*      */     } 
/* 5350 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5359 */     long l = (GL.getICD()).glCreateSamplers;
/* 5360 */     if (Checks.CHECKS) {
/* 5361 */       Checks.check(l);
/*      */     }
/* 5363 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 5372 */     long l = (GL.getICD()).glCreateProgramPipelines;
/* 5373 */     if (Checks.CHECKS) {
/* 5374 */       Checks.check(l);
/*      */     }
/* 5376 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCreateQueries(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5385 */     long l = (GL.getICD()).glCreateQueries;
/* 5386 */     if (Checks.CHECKS) {
/* 5387 */       Checks.check(l);
/*      */     }
/* 5389 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") short[] paramArrayOfshort) {
/* 5398 */     long l = (GL.getICD()).glGetTextureSubImage;
/* 5399 */     if (Checks.CHECKS) {
/* 5400 */       Checks.check(l);
/*      */     }
/* 5402 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") int[] paramArrayOfint) {
/* 5411 */     long l = (GL.getICD()).glGetTextureSubImage;
/* 5412 */     if (Checks.CHECKS) {
/* 5413 */       Checks.check(l);
/*      */     }
/* 5415 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") float[] paramArrayOffloat) {
/* 5424 */     long l = (GL.getICD()).glGetTextureSubImage;
/* 5425 */     if (Checks.CHECKS) {
/* 5426 */       Checks.check(l);
/*      */     }
/* 5428 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5437 */     long l = (GL.getICD()).glGetTextureSubImage;
/* 5438 */     if (Checks.CHECKS) {
/* 5439 */       Checks.check(l);
/*      */     }
/* 5441 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble.length << 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") short[] paramArrayOfshort) {
/* 5450 */     long l = (GL.getICD()).glGetCompressedTextureSubImage;
/* 5451 */     if (Checks.CHECKS) {
/* 5452 */       Checks.check(l);
/*      */     }
/* 5454 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") int[] paramArrayOfint) {
/* 5463 */     long l = (GL.getICD()).glGetCompressedTextureSubImage;
/* 5464 */     if (Checks.CHECKS) {
/* 5465 */       Checks.check(l);
/*      */     }
/* 5467 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") float[] paramArrayOffloat) {
/* 5476 */     long l = (GL.getICD()).glGetCompressedTextureSubImage;
/* 5477 */     if (Checks.CHECKS) {
/* 5478 */       Checks.check(l);
/*      */     }
/* 5480 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5489 */     long l = (GL.getICD()).glGetCompressedTextureSubImage;
/* 5490 */     if (Checks.CHECKS) {
/* 5491 */       Checks.check(l);
/*      */     }
/* 5493 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble.length << 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/* 5502 */     long l = (GL.getICD()).glGetnTexImage;
/* 5503 */     if (Checks.CHECKS) {
/* 5504 */       Checks.check(l);
/*      */     }
/* 5506 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/* 5515 */     long l = (GL.getICD()).glGetnTexImage;
/* 5516 */     if (Checks.CHECKS) {
/* 5517 */       Checks.check(l);
/*      */     }
/* 5519 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/* 5528 */     long l = (GL.getICD()).glGetnTexImage;
/* 5529 */     if (Checks.CHECKS) {
/* 5530 */       Checks.check(l);
/*      */     }
/* 5532 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/* 5541 */     long l = (GL.getICD()).glGetnTexImage;
/* 5542 */     if (Checks.CHECKS) {
/* 5543 */       Checks.check(l);
/*      */     }
/* 5545 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble.length << 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/* 5554 */     long l = (GL.getICD()).glReadnPixels;
/* 5555 */     if (Checks.CHECKS) {
/* 5556 */       Checks.check(l);
/*      */     }
/* 5558 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 5567 */     long l = (GL.getICD()).glReadnPixels;
/* 5568 */     if (Checks.CHECKS) {
/* 5569 */       Checks.check(l);
/*      */     }
/* 5571 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 5580 */     long l = (GL.getICD()).glReadnPixels;
/* 5581 */     if (Checks.CHECKS) {
/* 5582 */       Checks.check(l);
/*      */     }
/* 5584 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 5593 */     long l = (GL.getICD()).glGetnUniformfv;
/* 5594 */     if (Checks.CHECKS) {
/* 5595 */       Checks.check(l);
/*      */     }
/* 5597 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 5606 */     long l = (GL.getICD()).glGetnUniformdv;
/* 5607 */     if (Checks.CHECKS) {
/* 5608 */       Checks.check(l);
/*      */     }
/* 5610 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 5619 */     long l = (GL.getICD()).glGetnUniformiv;
/* 5620 */     if (Checks.CHECKS) {
/* 5621 */       Checks.check(l);
/*      */     }
/* 5623 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 5632 */     long l = (GL.getICD()).glGetnUniformuiv;
/* 5633 */     if (Checks.CHECKS) {
/* 5634 */       Checks.check(l);
/*      */     }
/* 5636 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native void glClipControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglCreateTransformFeedbacks(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glTransformFeedbackBufferBase(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTransformFeedbackBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void nglGetTransformFeedbackiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTransformFeedbacki_v(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTransformFeedbacki64_v(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateBuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglNamedBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glCopyNamedBufferSubData(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*      */   
/*      */   public static native void nglClearNamedBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*      */   
/*      */   public static native long nglMapNamedBuffer(int paramInt1, int paramInt2);
/*      */   
/*      */   public static native long nglMapNamedBufferRange(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glUnmapNamedBuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glFlushMappedNamedBufferRange(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void nglGetNamedBufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferParameteri64v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferPointerv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglCreateFramebuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glNamedFramebufferRenderbuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glNamedFramebufferTexture(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferTextureLayer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferDrawBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglNamedFramebufferDrawBuffers(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedFramebufferReadBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglInvalidateNamedFramebufferData(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglInvalidateNamedFramebufferSubData(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*      */   
/*      */   public static native void nglClearNamedFramebufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedFramebufferuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglClearNamedFramebufferfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glClearNamedFramebufferfi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLfloat") float paramFloat, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glBlitNamedFramebuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckNamedFramebufferStatus(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglGetNamedFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateRenderbuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorage(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglGetNamedRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglCreateTextures(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTextureBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glTextureBufferRange(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */   
/*      */   public static native void glTextureStorage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void glTextureStorage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void glTextureStorage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glTextureStorage2DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glTextureStorage3DMultisample(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void nglTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureSubImage1D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void glCopyTextureSubImage2D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8);
/*      */   
/*      */   public static native void glCopyTextureSubImage3D(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void glTextureParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTextureParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glTextureParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglTextureParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glGenerateTextureMipmap(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindTextureUnit(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetTextureImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureImage(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglCreateVertexArrays(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glDisableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glEnableVertexArrayAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexArrayElementBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexArrayVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void nglVertexArrayVertexBuffers(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glVertexArrayAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glVertexArrayAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexArrayBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglGetVertexArrayiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIndexed64iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCreateSamplers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglCreateProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglCreateQueries(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glGetQueryBufferObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glMemoryBarrierByRegion(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void nglGetTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glTextureBarrier();
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glGetGraphicsResetStatus();
/*      */   
/*      */   public static native void nglGetnTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetnCompressedTexImage(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformfv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformdv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL45C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */