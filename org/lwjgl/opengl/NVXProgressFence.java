/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVXProgressFence
/*     */ {
/*     */   static {
/*  34 */     GL.initialize();
/*     */   }
/*     */   protected NVXProgressFence() {
/*  37 */     throw new UnsupportedOperationException();
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
/*     */   public static void glSignalSemaphoreui64NVX(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(paramLongBuffer, paramIntBuffer.remaining());
/*     */     }
/*  53 */     nglSignalSemaphoreui64NVX(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreui64NVX(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/*  61 */     if (Checks.CHECKS) {
/*  62 */       Checks.check(paramLongBuffer, paramIntBuffer.remaining());
/*     */     }
/*  64 */     nglWaitSemaphoreui64NVX(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClientWaitSemaphoreui64NVX(@NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/*  72 */     if (Checks.CHECKS) {
/*  73 */       Checks.check(paramLongBuffer, paramIntBuffer.remaining());
/*     */     }
/*  75 */     nglClientWaitSemaphoreui64NVX(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSignalSemaphoreui64NVX(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/*  80 */     long l = (GL.getICD()).glSignalSemaphoreui64NVX;
/*  81 */     if (Checks.CHECKS) {
/*  82 */       Checks.check(l);
/*  83 */       Checks.check(paramArrayOflong, paramArrayOfint.length);
/*     */     } 
/*  85 */     JNI.callPPV(paramInt, paramArrayOfint.length, paramArrayOfint, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreui64NVX(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/*  90 */     long l = (GL.getICD()).glWaitSemaphoreui64NVX;
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(l);
/*  93 */       Checks.check(paramArrayOflong, paramArrayOfint.length);
/*     */     } 
/*  95 */     JNI.callPPV(paramInt, paramArrayOfint.length, paramArrayOfint, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClientWaitSemaphoreui64NVX(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 100 */     long l = (GL.getICD()).glClientWaitSemaphoreui64NVX;
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(l);
/* 103 */       Checks.check(paramArrayOflong, paramArrayOfint.length);
/*     */     } 
/* 105 */     JNI.callPPV(paramArrayOfint.length, paramArrayOfint, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static native int glCreateProgressFenceNVX();
/*     */   
/*     */   public static native void nglSignalSemaphoreui64NVX(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglWaitSemaphoreui64NVX(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglClientWaitSemaphoreui64NVX(int paramInt, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVXProgressFence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */