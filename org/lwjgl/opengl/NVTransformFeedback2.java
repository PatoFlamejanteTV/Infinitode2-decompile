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
/*     */ public class NVTransformFeedback2
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;
/*     */   
/*     */   static {
/*  37 */     GL.initialize();
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
/*     */   protected NVTransformFeedback2() {
/*  49 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  61 */     nglDeleteTransformFeedbacksNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/*  65 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  67 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  68 */       nglDeleteTransformFeedbacksNV(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/*  70 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacksNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  79 */     if (Checks.CHECKS) {
/*  80 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  82 */     nglGenTransformFeedbacksNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacksNV() {
/*     */     MemoryStack memoryStack;
/*  87 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  89 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  90 */       nglGenTransformFeedbacksNV(1, MemoryUtil.memAddress(intBuffer));
/*  91 */       return intBuffer.get(0);
/*     */     } finally {
/*  93 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacksNV(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 116 */     long l = (GL.getICD()).glDeleteTransformFeedbacksNV;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(l);
/*     */     }
/* 120 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacksNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 125 */     long l = (GL.getICD()).glGenTransformFeedbacksNV;
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(l);
/* 128 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 130 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glBindTransformFeedbackNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteTransformFeedbacksNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenTransformFeedbacksNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTransformFeedbackNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glPauseTransformFeedbackNV();
/*     */   
/*     */   public static native void glResumeTransformFeedbackNV();
/*     */   
/*     */   public static native void glDrawTransformFeedbackNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVTransformFeedback2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */