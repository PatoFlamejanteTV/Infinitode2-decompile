/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ public class EXTTimerQuery
/*     */ {
/*     */   public static final int GL_TIME_ELAPSED_EXT = 35007;
/*     */   
/*     */   static {
/*  36 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected EXTTimerQuery() {
/*  42 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/*  53 */     nglGetQueryObjecti64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long paramLong) {
/*  57 */     nglGetQueryObjecti64vEXT(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjecti64EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/*  62 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  64 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/*  65 */       nglGetQueryObjecti64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/*  66 */       return longBuffer.get(0);
/*     */     } finally {
/*  68 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/*  80 */     nglGetQueryObjectui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long paramLong) {
/*  84 */     nglGetQueryObjectui64vEXT(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjectui64EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/*  89 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  91 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/*  92 */       nglGetQueryObjectui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/*  93 */       return longBuffer.get(0);
/*     */     } finally {
/*  95 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 101 */     long l = (GL.getICD()).glGetQueryObjecti64vEXT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(l);
/* 104 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 106 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 111 */     long l = (GL.getICD()).glGetQueryObjectui64vEXT;
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(l);
/* 114 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 116 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void nglGetQueryObjecti64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTimerQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */