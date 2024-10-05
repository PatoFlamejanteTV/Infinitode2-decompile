/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class ARBBufferStorage
/*     */ {
/*     */   public static final int GL_MAP_PERSISTENT_BIT = 64;
/*     */   public static final int GL_MAP_COHERENT_BIT = 128;
/*     */   public static final int GL_DYNAMIC_STORAGE_BIT = 256;
/*     */   public static final int GL_CLIENT_STORAGE_BIT = 512;
/*     */   public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
/*     */   public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
/*     */   public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
/*     */   
/*     */   static {
/*  35 */     GL.initialize();
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
/*     */   protected ARBBufferStorage() {
/*  53 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBufferStorage(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  64 */     GL44C.nglBufferStorage(paramInt1, paramLong1, paramLong2, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLbitfield") int paramInt2) {
/* 117 */     GL44C.glBufferStorage(paramInt1, paramLong, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 171 */     GL44C.glBufferStorage(paramInt1, paramByteBuffer, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 225 */     GL44C.glBufferStorage(paramInt1, paramShortBuffer, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 279 */     GL44C.glBufferStorage(paramInt1, paramIntBuffer, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 333 */     GL44C.glBufferStorage(paramInt1, paramFloatBuffer, paramInt2);
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
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 387 */     GL44C.glBufferStorage(paramInt1, paramDoubleBuffer, paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLbitfield") int paramInt2) {
/* 443 */     nglNamedBufferStorageEXT(paramInt1, paramLong, 0L, paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 491 */     nglNamedBufferStorageEXT(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 539 */     nglNamedBufferStorageEXT(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 587 */     nglNamedBufferStorageEXT(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 635 */     nglNamedBufferStorageEXT(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
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
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLbitfield") int paramInt2) {
/* 683 */     nglNamedBufferStorageEXT(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 688 */     GL44C.glBufferStorage(paramInt1, paramArrayOfshort, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 693 */     GL44C.glBufferStorage(paramInt1, paramArrayOfint, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 698 */     GL44C.glBufferStorage(paramInt1, paramArrayOffloat, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 703 */     GL44C.glBufferStorage(paramInt1, paramArrayOfdouble, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLbitfield") int paramInt2) {
/* 708 */     long l = (GL.getICD()).glNamedBufferStorageEXT;
/* 709 */     if (Checks.CHECKS) {
/* 710 */       Checks.check(l);
/*     */     }
/* 712 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLbitfield") int paramInt2) {
/* 717 */     long l = (GL.getICD()).glNamedBufferStorageEXT;
/* 718 */     if (Checks.CHECKS) {
/* 719 */       Checks.check(l);
/*     */     }
/* 721 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLbitfield") int paramInt2) {
/* 726 */     long l = (GL.getICD()).glNamedBufferStorageEXT;
/* 727 */     if (Checks.CHECKS) {
/* 728 */       Checks.check(l);
/*     */     }
/* 730 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedBufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLbitfield") int paramInt2) {
/* 735 */     long l = (GL.getICD()).glNamedBufferStorageEXT;
/* 736 */     if (Checks.CHECKS) {
/* 737 */       Checks.check(l);
/*     */     }
/* 739 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*     */   }
/*     */   
/*     */   public static native void nglNamedBufferStorageEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBBufferStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */