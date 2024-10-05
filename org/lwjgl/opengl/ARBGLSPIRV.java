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
/*     */ 
/*     */ 
/*     */ public class ARBGLSPIRV
/*     */ {
/*     */   public static final int GL_SHADER_BINARY_FORMAT_SPIR_V_ARB = 38225;
/*     */   public static final int GL_SPIR_V_BINARY_ARB = 38226;
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
/*     */   protected ARBGLSPIRV() {
/*  44 */     throw new UnsupportedOperationException();
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
/*     */   public static void glSpecializeShaderARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2) {
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.checkNT1(paramByteBuffer);
/*  89 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());
/*     */     } 
/*  91 */     nglSpecializeShaderARB(paramInt, MemoryUtil.memAddress(paramByteBuffer), paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
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
/*     */   public static void glSpecializeShaderARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2) {
/* 125 */     if (Checks.CHECKS)
/* 126 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining()); 
/*     */     MemoryStack memoryStack;
/* 128 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 130 */       memoryStack.nUTF8(paramCharSequence, true);
/* 131 */       long l = memoryStack.getPointerAddress();
/* 132 */       nglSpecializeShaderARB(paramInt, l, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)); return;
/*     */     } finally {
/* 134 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSpecializeShaderARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 140 */     long l = (GL.getICD()).glSpecializeShaderARB;
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(l);
/* 143 */       Checks.checkNT1(paramByteBuffer);
/* 144 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     } 
/* 146 */     JNI.callPPPV(paramInt, MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSpecializeShaderARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2) {
/* 151 */     long l = (GL.getICD()).glSpecializeShaderARB;
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.check(l);
/* 154 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     }  MemoryStack memoryStack;
/* 156 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 158 */       memoryStack.nUTF8(paramCharSequence, true);
/* 159 */       long l1 = memoryStack.getPointerAddress();
/* 160 */       JNI.callPPPV(paramInt, l1, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2, l); return;
/*     */     } finally {
/* 162 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native void nglSpecializeShaderARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBGLSPIRV.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */