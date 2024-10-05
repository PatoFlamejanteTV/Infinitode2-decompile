/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVTimelineSemaphore
/*     */ {
/*     */   public static final int GL_SEMAPHORE_TYPE_NV = 38323;
/*     */   public static final int GL_SEMAPHORE_TYPE_BINARY_NV = 38324;
/*     */   public static final int GL_SEMAPHORE_TYPE_TIMELINE_NV = 38325;
/*     */   public static final int GL_TIMELINE_SEMAPHORE_VALUE_NV = 38293;
/*     */   public static final int GL_MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_NV = 38326;
/*     */   
/*     */   static {
/*  28 */     GL.initialize();
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
/*     */   protected NVTimelineSemaphore() {
/*  45 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCreateSemaphoresNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  53 */     nglCreateSemaphoresNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glCreateSemaphoresNV() {
/*     */     MemoryStack memoryStack;
/*  58 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  60 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  61 */       nglCreateSemaphoresNV(1, MemoryUtil.memAddress(intBuffer));
/*  62 */       return intBuffer.get(0);
/*     */     } finally {
/*  64 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  73 */     if (Checks.CHECKS) {
/*  74 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  76 */     nglSemaphoreParameterivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  87 */     nglGetSemaphoreParameterivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateSemaphoresNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/*  92 */     long l = (GL.getICD()).glCreateSemaphoresNV;
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(l);
/*     */     }
/*  96 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 101 */     long l = (GL.getICD()).glSemaphoreParameterivNV;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(l);
/* 104 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 106 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 111 */     long l = (GL.getICD()).glGetSemaphoreParameterivNV;
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(l);
/* 114 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 116 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglCreateSemaphoresNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglSemaphoreParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSemaphoreParameterivNV(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVTimelineSemaphore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */