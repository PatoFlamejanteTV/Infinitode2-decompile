/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ public class GL44
/*      */   extends GL43
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
/*   36 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL44() {
/*  103 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  114 */     GL44C.nglBufferStorage(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  169 */     GL44C.glBufferStorage(paramInt1, paramLong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  225 */     GL44C.glBufferStorage(paramInt1, paramByteBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  281 */     GL44C.glBufferStorage(paramInt1, paramShortBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  337 */     GL44C.glBufferStorage(paramInt1, paramIntBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  393 */     GL44C.glBufferStorage(paramInt1, paramFloatBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  449 */     GL44C.glBufferStorage(paramInt1, paramDoubleBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearTexSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong) {
/*  456 */     GL44C.nglClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  490 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  524 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  558 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  592 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  626 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglClearTexImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  633 */     GL44C.nglClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  652 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  671 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  690 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  709 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  728 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindBuffersBase(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  739 */     GL44C.nglBindBuffersBase(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  765 */     GL44C.glBindBuffersBase(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindBuffersRange(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3) {
/*  776 */     GL44C.nglBindBuffersRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  810 */     GL44C.glBindBuffersRange(paramInt1, paramInt2, paramIntBuffer, paramPointerBuffer1, paramPointerBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindTextures(int paramInt1, int paramInt2, long paramLong) {
/*  821 */     GL44C.nglBindTextures(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  866 */     GL44C.glBindTextures(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindSamplers(int paramInt1, int paramInt2, long paramLong) {
/*  877 */     GL44C.nglBindSamplers(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  906 */     GL44C.glBindSamplers(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindImageTextures(int paramInt1, int paramInt2, long paramLong) {
/*  917 */     GL44C.nglBindImageTextures(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  957 */     GL44C.glBindImageTextures(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindVertexBuffers(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/*  968 */     GL44C.nglBindVertexBuffers(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1004 */     GL44C.glBindVertexBuffers(paramInt, paramIntBuffer1, paramPointerBuffer, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 1013 */     GL44C.glBufferStorage(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 1022 */     GL44C.glBufferStorage(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 1031 */     GL44C.glBufferStorage(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 1040 */     GL44C.glBufferStorage(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1049 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 1058 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1067 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1076 */     GL44C.glClearTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1085 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 1094 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1103 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glClearTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1112 */     GL44C.glClearTexImage(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersBase(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1121 */     GL44C.glBindBuffersBase(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffersRange(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer1, @NativeType("GLsizeiptr const *") PointerBuffer paramPointerBuffer2) {
/* 1130 */     GL44C.glBindBuffersRange(paramInt1, paramInt2, paramArrayOfint, paramPointerBuffer1, paramPointerBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1139 */     GL44C.glBindTextures(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindSamplers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1148 */     GL44C.glBindSamplers(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindImageTextures(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1157 */     GL44C.glBindImageTextures(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindVertexBuffers(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 1166 */     GL44C.glBindVertexBuffers(paramInt, paramArrayOfint1, paramPointerBuffer, paramArrayOfint2);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL44.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */