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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVFence
/*     */ {
/*     */   public static final int GL_ALL_COMPLETED_NV = 34034;
/*     */   public static final int GL_FENCE_STATUS_NV = 34035;
/*     */   public static final int GL_FENCE_CONDITION_NV = 34036;
/*     */   
/*     */   static {
/*  38 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NVFence() {
/*  49 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  57 */     nglDeleteFencesNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/*  61 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  63 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  64 */       nglDeleteFencesNV(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/*  66 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenFencesNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  75 */     nglGenFencesNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenFencesNV() {
/*     */     MemoryStack memoryStack;
/*  80 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  82 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  83 */       nglGenFencesNV(1, MemoryUtil.memAddress(intBuffer));
/*  84 */       return intBuffer.get(0);
/*     */     } finally {
/*  86 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glGetFenceivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 108 */     nglGetFenceivNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetFenceiNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 113 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 115 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 116 */       nglGetFenceivNV(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 117 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 119 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glDeleteFencesNV(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 133 */     long l = (GL.getICD()).glDeleteFencesNV;
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(l);
/*     */     }
/* 137 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFencesNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 142 */     long l = (GL.getICD()).glGenFencesNV;
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(l);
/*     */     }
/* 146 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFenceivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 151 */     long l = (GL.getICD()).glGetFenceivNV;
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.check(l);
/* 154 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 156 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglDeleteFencesNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenFencesNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glTestFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetFenceivNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glFinishFenceNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glSetFenceNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVFence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */