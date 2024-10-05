/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVBindlessTexture
/*     */ {
/*     */   static {
/*  66 */     GL.initialize();
/*     */   }
/*     */   protected NVBindlessTexture() {
/*  69 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniformHandleui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 246 */     nglUniformHandleui64vNV(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniformHandleui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 277 */     nglProgramUniformHandleui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniformHandleui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 302 */     long l = (GL.getICD()).glUniformHandleui64vNV;
/* 303 */     if (Checks.CHECKS) {
/* 304 */       Checks.check(l);
/*     */     }
/* 306 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformHandleui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 311 */     long l = (GL.getICD()).glProgramUniformHandleui64vNV;
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(l);
/*     */     }
/* 315 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureHandleNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetTextureSamplerHandleNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glMakeTextureHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glMakeTextureHandleNonResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLuint64")
/*     */   public static native long glGetImageHandleNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */   
/*     */   public static native void glMakeImageHandleResidentNV(@NativeType("GLuint64") long paramLong, @NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeImageHandleNonResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glUniformHandleui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniformHandleui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformHandleui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformHandleui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsTextureHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsImageHandleResidentNV(@NativeType("GLuint64") long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVBindlessTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */