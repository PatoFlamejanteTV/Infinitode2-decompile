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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBBindlessTexture
/*     */ {
/*     */   public static final int GL_UNSIGNED_INT64_ARB = 5135;
/*     */   
/*     */   static {
/*  48 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBBindlessTexture() {
/*  54 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformHandleui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 232 */     nglUniformHandleui64vARB(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniformHandleui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 263 */     nglProgramUniformHandleui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glVertexAttribL1ui64vARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 311 */     nglVertexAttribL1ui64vARB(paramInt, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glGetVertexAttribLui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 327 */     if (Checks.CHECKS) {
/* 328 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 330 */     nglGetVertexAttribLui64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 341 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 343 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 344 */       nglGetVertexAttribLui64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 345 */       return longBuffer.get(0);
/*     */     } finally {
/* 347 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformHandleui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 353 */     long l = (GL.getICD()).glUniformHandleui64vARB;
/* 354 */     if (Checks.CHECKS) {
/* 355 */       Checks.check(l);
/*     */     }
/* 357 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformHandleui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 362 */     long l = (GL.getICD()).glProgramUniformHandleui64vARB;
/* 363 */     if (Checks.CHECKS) {
/* 364 */       Checks.check(l);
/*     */     }
/* 366 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1ui64vARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 371 */     long l = (GL.getICD()).glVertexAttribL1ui64vARB;
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(l);
/* 374 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 376 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 381 */     long l = (GL.getICD()).glGetVertexAttribLui64vARB;
/* 382 */     if (Checks.CHECKS) {
/* 383 */       Checks.check(l);
/* 384 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 386 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureHandleARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureSamplerHandleARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glMakeTextureHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glMakeTextureHandleNonResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetImageHandleARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */   
/*     */   public static native void glMakeImageHandleResidentARB(@NativeType("GLuint64") long paramLong, @NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeImageHandleNonResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glUniformHandleui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniformHandleui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformHandleui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformHandleui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTextureHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsImageHandleResidentARB(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL1ui64ARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL1ui64vARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBBindlessTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */