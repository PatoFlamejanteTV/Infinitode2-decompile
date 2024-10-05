/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ 
/*      */ public class GL44C
/*      */   extends GL43C
/*      */ {
/*      */   public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
/*      */   public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
/*      */   public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
/*      */   public static final int GL_MAP_PERSISTENT_BIT = 64;
/*      */   public static final int GL_MAP_COHERENT_BIT = 128;
/*      */   public static final int GL_DYNAMIC_STORAGE_BIT = 256;
/*      */   public static final int GL_CLIENT_STORAGE_BIT = 512;
/*      */   public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
/*      */   public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
/*      */   public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
/*      */   public static final int GL_CLEAR_TEXTURE = 37733;
/*      */   public static final int GL_LOCATION_COMPONENT = 37706;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;
/*      */   public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
/*      */   public static final int GL_QUERY_BUFFER = 37266;
/*      */   public static final int GL_QUERY_BUFFER_BINDING = 37267;
/*      */   public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
/*      */   public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;
/*      */   
/*      */   static {
/*   40 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL44C() {
/*  107 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLbitfield") int paramInt2) {
/*  171 */     nglBufferStorage(paramInt1, paramLong, 0L, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  227 */     nglBufferStorage(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  283 */     nglBufferStorage(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  339 */     nglBufferStorage(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  395 */     nglBufferStorage(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLbitfield") int paramInt2) {
/*  451 */     nglBufferStorage(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  490 */     nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  524 */     nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  558 */     nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  592 */     nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  626 */     nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  650 */     nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  669 */     nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  688 */     nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  707 */     nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  726 */     nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  761 */     nglBindBuffersBase(paramInt1, paramInt2, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer1, @NativeType("GLsizeiptr const *") PointerBuffer paramPointerBuffer2) {
/*  804 */     if (Checks.CHECKS) {
/*  805 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer1, Checks.remainingSafe(paramIntBuffer));
/*  806 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer2, Checks.remainingSafe(paramIntBuffer));
/*      */     } 
/*  808 */     nglBindBuffersRange(paramInt1, paramInt2, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  862 */     nglBindTextures(paramInt, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindSamplers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  900 */     nglBindSamplers(paramInt, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindImageTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  949 */     nglBindImageTextures(paramInt, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindVertexBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer2) {
/*  994 */     if (Checks.CHECKS) {
/*  995 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, Checks.remainingSafe(paramIntBuffer1));
/*  996 */       Checks.checkSafe(paramIntBuffer2, Checks.remainingSafe(paramIntBuffer1));
/*      */     } 
/*  998 */     nglBindVertexBuffers(paramInt, Checks.remainingSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 1007 */     long l = (GL.getICD()).glBufferStorage;
/* 1008 */     if (Checks.CHECKS) {
/* 1009 */       Checks.check(l);
/*      */     }
/* 1011 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 1020 */     long l = (GL.getICD()).glBufferStorage;
/* 1021 */     if (Checks.CHECKS) {
/* 1022 */       Checks.check(l);
/*      */     }
/* 1024 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 1033 */     long l = (GL.getICD()).glBufferStorage;
/* 1034 */     if (Checks.CHECKS) {
/* 1035 */       Checks.check(l);
/*      */     }
/* 1037 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 1046 */     long l = (GL.getICD()).glBufferStorage;
/* 1047 */     if (Checks.CHECKS) {
/* 1048 */       Checks.check(l);
/*      */     }
/* 1050 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1059 */     long l = (GL.getICD()).glClearTexSubImage;
/* 1060 */     if (Checks.CHECKS) {
/* 1061 */       Checks.check(l);
/*      */     }
/* 1063 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 1072 */     long l = (GL.getICD()).glClearTexSubImage;
/* 1073 */     if (Checks.CHECKS) {
/* 1074 */       Checks.check(l);
/*      */     }
/* 1076 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1085 */     long l = (GL.getICD()).glClearTexSubImage;
/* 1086 */     if (Checks.CHECKS) {
/* 1087 */       Checks.check(l);
/*      */     }
/* 1089 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1098 */     long l = (GL.getICD()).glClearTexSubImage;
/* 1099 */     if (Checks.CHECKS) {
/* 1100 */       Checks.check(l);
/*      */     }
/* 1102 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1111 */     long l = (GL.getICD()).glClearTexImage;
/* 1112 */     if (Checks.CHECKS) {
/* 1113 */       Checks.check(l);
/*      */     }
/* 1115 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 1124 */     long l = (GL.getICD()).glClearTexImage;
/* 1125 */     if (Checks.CHECKS) {
/* 1126 */       Checks.check(l);
/*      */     }
/* 1128 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1137 */     long l = (GL.getICD()).glClearTexImage;
/* 1138 */     if (Checks.CHECKS) {
/* 1139 */       Checks.check(l);
/*      */     }
/* 1141 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1150 */     long l = (GL.getICD()).glClearTexImage;
/* 1151 */     if (Checks.CHECKS) {
/* 1152 */       Checks.check(l);
/*      */     }
/* 1154 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1163 */     long l = (GL.getICD()).glBindBuffersBase;
/* 1164 */     if (Checks.CHECKS) {
/* 1165 */       Checks.check(l);
/*      */     }
/* 1167 */     JNI.callPV(paramInt1, paramInt2, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer1, @NativeType("GLsizeiptr const *") PointerBuffer paramPointerBuffer2) {
/* 1176 */     long l = (GL.getICD()).glBindBuffersRange;
/* 1177 */     if (Checks.CHECKS) {
/* 1178 */       Checks.check(l);
/* 1179 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer1, Checks.lengthSafe(paramArrayOfint));
/* 1180 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer2, Checks.lengthSafe(paramArrayOfint));
/*      */     } 
/* 1182 */     JNI.callPPPV(paramInt1, paramInt2, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer2), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1191 */     long l = (GL.getICD()).glBindTextures;
/* 1192 */     if (Checks.CHECKS) {
/* 1193 */       Checks.check(l);
/*      */     }
/* 1195 */     JNI.callPV(paramInt, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindSamplers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1204 */     long l = (GL.getICD()).glBindSamplers;
/* 1205 */     if (Checks.CHECKS) {
/* 1206 */       Checks.check(l);
/*      */     }
/* 1208 */     JNI.callPV(paramInt, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindImageTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1217 */     long l = (GL.getICD()).glBindImageTextures;
/* 1218 */     if (Checks.CHECKS) {
/* 1219 */       Checks.check(l);
/*      */     }
/* 1221 */     JNI.callPV(paramInt, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindVertexBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 1230 */     long l = (GL.getICD()).glBindVertexBuffers;
/* 1231 */     if (Checks.CHECKS) {
/* 1232 */       Checks.check(l);
/* 1233 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, Checks.lengthSafe(paramArrayOfint1));
/* 1234 */       Checks.checkSafe(paramArrayOfint2, Checks.lengthSafe(paramArrayOfint1));
/*      */     } 
/* 1236 */     JNI.callPPPV(paramInt, Checks.lengthSafe(paramArrayOfint1), paramArrayOfint1, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), paramArrayOfint2, l);
/*      */   }
/*      */   
/*      */   public static native void nglBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglClearTexSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglClearTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglBindBuffersBase(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglBindBuffersRange(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglBindTextures(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglBindSamplers(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglBindImageTextures(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglBindVertexBuffers(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL44C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */