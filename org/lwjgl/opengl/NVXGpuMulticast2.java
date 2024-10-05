/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ public class NVXGpuMulticast2
/*     */ {
/*     */   static {
/*  25 */     GL.initialize();
/*     */   }
/*     */   protected NVXGpuMulticast2() {
/*  28 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glAsyncCopyImageSubDataNVX(@NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer1, @NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLuint") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLint") int paramInt13, @NativeType("GLint") int paramInt14, @NativeType("GLsizei") int paramInt15, @NativeType("GLsizei") int paramInt16, @NativeType("GLsizei") int paramInt17, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer2) {
/*  37 */     if (Checks.CHECKS) {
/*  38 */       Checks.check(paramLongBuffer1, paramIntBuffer1.remaining());
/*  39 */       Checks.check(paramLongBuffer2, paramIntBuffer2.remaining());
/*     */     } 
/*  41 */     return nglAsyncCopyImageSubDataNVX(paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramLongBuffer1), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, paramInt16, paramInt17, paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramLongBuffer2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glAsyncCopyBufferSubDataNVX(@NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer1, @NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer2) {
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(paramLongBuffer1, paramIntBuffer1.remaining());
/*  52 */       Checks.check(paramLongBuffer2, paramIntBuffer2.remaining());
/*     */     } 
/*  54 */     return nglAsyncCopyBufferSubDataNVX(paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramLongBuffer1), paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3, paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramLongBuffer2));
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
/*     */   public static void glMulticastViewportArrayvNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  66 */     nglMulticastViewportArrayvNVX(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastScissorArrayvNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  74 */     nglMulticastScissorArrayvNVX(paramInt1, paramInt2, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glAsyncCopyImageSubDataNVX(@NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint64 const *") long[] paramArrayOflong1, @NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLuint") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLint") int paramInt13, @NativeType("GLint") int paramInt14, @NativeType("GLsizei") int paramInt15, @NativeType("GLsizei") int paramInt16, @NativeType("GLsizei") int paramInt17, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLuint64 const *") long[] paramArrayOflong2) {
/*  84 */     long l = (GL.getICD()).glAsyncCopyImageSubDataNVX;
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(l);
/*  87 */       Checks.check(paramArrayOflong1, paramArrayOfint1.length);
/*  88 */       Checks.check(paramArrayOflong2, paramArrayOfint2.length);
/*     */     } 
/*  90 */     return JNI.callPPPPI(paramArrayOfint1.length, paramArrayOfint1, paramArrayOflong1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, paramInt16, paramInt17, paramArrayOfint2.length, paramArrayOfint2, paramArrayOflong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static long glAsyncCopyBufferSubDataNVX(@NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint64 const *") long[] paramArrayOflong1, @NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLuint64 const *") long[] paramArrayOflong2) {
/*  96 */     long l = (GL.getICD()).glAsyncCopyBufferSubDataNVX;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(l);
/*  99 */       Checks.check(paramArrayOflong1, paramArrayOfint1.length);
/* 100 */       Checks.check(paramArrayOflong2, paramArrayOfint2.length);
/*     */     } 
/* 102 */     return JNI.callPPPPPPPP(paramArrayOfint1.length, paramArrayOfint1, paramArrayOflong1, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3, paramArrayOfint2.length, paramArrayOfint2, paramArrayOflong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastViewportArrayvNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 107 */     long l = (GL.getICD()).glMulticastViewportArrayvNVX;
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.check(l);
/*     */     }
/* 111 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastScissorArrayvNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 116 */     long l = (GL.getICD()).glMulticastScissorArrayvNVX;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(l);
/*     */     }
/* 120 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native int nglAsyncCopyImageSubDataNVX(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native long nglAsyncCopyBufferSubDataNVX(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, long paramLong4, long paramLong5, int paramInt6, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native void glUploadGpuMaskNVX(@NativeType("GLbitfield") int paramInt);
/*     */   
/*     */   public static native void nglMulticastViewportArrayvNVX(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastScissorArrayvNVX(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glMulticastViewportPositionWScaleNVX(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVXGpuMulticast2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */