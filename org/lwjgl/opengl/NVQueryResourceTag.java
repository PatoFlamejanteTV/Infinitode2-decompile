/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class NVQueryResourceTag
/*     */ {
/*     */   static {
/*  28 */     GL.initialize();
/*     */   }
/*     */   protected NVQueryResourceTag() {
/*  31 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenQueryResourceTagNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  39 */     nglGenQueryResourceTagNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenQueryResourceTagNV() {
/*     */     MemoryStack memoryStack;
/*  44 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  46 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  47 */       nglGenQueryResourceTagNV(1, MemoryUtil.memAddress(intBuffer));
/*  48 */       return intBuffer.get(0);
/*     */     } finally {
/*  50 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  59 */     nglDeleteQueryResourceTagNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/*  63 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  65 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  66 */       nglDeleteQueryResourceTagNV(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/*  68 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glQueryResourceTagNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/*  80 */     nglQueryResourceTagNV(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   public static void glQueryResourceTagNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/*  84 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  86 */       memoryStack.nASCII(paramCharSequence, true);
/*  87 */       long l = memoryStack.getPointerAddress();
/*  88 */       nglQueryResourceTagNV(paramInt, l); return;
/*     */     } finally {
/*  90 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueryResourceTagNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/*  96 */     long l = (GL.getICD()).glGenQueryResourceTagNV;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(l);
/*     */     }
/* 100 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueryResourceTagNV(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 105 */     long l = (GL.getICD()).glDeleteQueryResourceTagNV;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(l);
/*     */     }
/* 109 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglGenQueryResourceTagNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteQueryResourceTagNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglQueryResourceTagNV(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVQueryResourceTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */