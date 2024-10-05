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
/*     */ 
/*     */ 
/*     */ public class EXTDrawBuffers2
/*     */ {
/*     */   static {
/*  30 */     GL.initialize();
/*     */   }
/*     */   protected EXTDrawBuffers2() {
/*  33 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetBooleanIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.check(paramByteBuffer, 1);
/*     */     }
/*  48 */     nglGetBooleanIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static boolean glGetBooleanIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/*  53 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  55 */       ByteBuffer byteBuffer = memoryStack.calloc(1);
/*  56 */       nglGetBooleanIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(byteBuffer));
/*  57 */       paramInt1 = (byteBuffer.get(0) != 0) ? 1 : 0; return paramInt1;
/*     */     } finally {
/*  59 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  68 */     if (Checks.CHECKS) {
/*  69 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  71 */     nglGetIntegerIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetIntegerIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/*  76 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  78 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  79 */       nglGetIntegerIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  80 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/*  82 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 101 */     long l = (GL.getICD()).glGetIntegerIndexedvEXT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(l);
/* 104 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 106 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glColorMaskIndexedEXT(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean1, @NativeType("GLboolean") boolean paramBoolean2, @NativeType("GLboolean") boolean paramBoolean3, @NativeType("GLboolean") boolean paramBoolean4);
/*     */   
/*     */   public static native void nglGetBooleanIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetIntegerIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glEnableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glDisableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsEnabledIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDrawBuffers2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */