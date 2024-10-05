/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL21C
/*     */   extends GL20C
/*     */ {
/*     */   public static final int GL_FLOAT_MAT2x3 = 35685;
/*     */   public static final int GL_FLOAT_MAT2x4 = 35686;
/*     */   public static final int GL_FLOAT_MAT3x2 = 35687;
/*     */   public static final int GL_FLOAT_MAT3x4 = 35688;
/*     */   public static final int GL_FLOAT_MAT4x2 = 35689;
/*     */   public static final int GL_FLOAT_MAT4x3 = 35690;
/*     */   public static final int GL_PIXEL_PACK_BUFFER = 35051;
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER = 35052;
/*     */   public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053;
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055;
/*     */   public static final int GL_SRGB = 35904;
/*     */   public static final int GL_SRGB8 = 35905;
/*     */   public static final int GL_SRGB_ALPHA = 35906;
/*     */   public static final int GL_SRGB8_ALPHA8 = 35907;
/*     */   public static final int GL_COMPRESSED_SRGB = 35912;
/*     */   public static final int GL_COMPRESSED_SRGB_ALPHA = 35913;
/*     */   
/*     */   static {
/*  30 */     GL.initialize();
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
/*     */   protected GL21C() {
/*  64 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  86 */     nglUniformMatrix2x3fv(paramInt, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 108 */     nglUniformMatrix3x2fv(paramInt, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 130 */     nglUniformMatrix2x4fv(paramInt, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 152 */     nglUniformMatrix4x2fv(paramInt, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 174 */     nglUniformMatrix3x4fv(paramInt, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 196 */     nglUniformMatrix4x3fv(paramInt, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 205 */     long l = (GL.getICD()).glUniformMatrix2x3fv;
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.check(l);
/*     */     }
/* 209 */     JNI.callPV(paramInt, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 218 */     long l = (GL.getICD()).glUniformMatrix3x2fv;
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.check(l);
/*     */     }
/* 222 */     JNI.callPV(paramInt, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 231 */     long l = (GL.getICD()).glUniformMatrix2x4fv;
/* 232 */     if (Checks.CHECKS) {
/* 233 */       Checks.check(l);
/*     */     }
/* 235 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 244 */     long l = (GL.getICD()).glUniformMatrix4x2fv;
/* 245 */     if (Checks.CHECKS) {
/* 246 */       Checks.check(l);
/*     */     }
/* 248 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 257 */     long l = (GL.getICD()).glUniformMatrix3x4fv;
/* 258 */     if (Checks.CHECKS) {
/* 259 */       Checks.check(l);
/*     */     }
/* 261 */     JNI.callPV(paramInt, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 270 */     long l = (GL.getICD()).glUniformMatrix4x3fv;
/* 271 */     if (Checks.CHECKS) {
/* 272 */       Checks.check(l);
/*     */     }
/* 274 */     JNI.callPV(paramInt, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL21C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */