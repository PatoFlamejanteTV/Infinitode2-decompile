/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class GL14C
/*     */   extends GL13C
/*     */ {
/*     */   public static final int GL_CONSTANT_COLOR = 32769;
/*     */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*     */   public static final int GL_CONSTANT_ALPHA = 32771;
/*     */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*     */   public static final int GL_FUNC_ADD = 32774;
/*     */   public static final int GL_MIN = 32775;
/*     */   public static final int GL_MAX = 32776;
/*     */   public static final int GL_FUNC_SUBTRACT = 32778;
/*     */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*     */   public static final int GL_DEPTH_COMPONENT16 = 33189;
/*     */   public static final int GL_DEPTH_COMPONENT24 = 33190;
/*     */   public static final int GL_DEPTH_COMPONENT32 = 33191;
/*     */   
/*     */   static {
/*  38 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_MODE = 34892;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_BLEND_DST_RGB = 32968;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_BLEND_SRC_RGB = 32969;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_BLEND_DST_ALPHA = 32970;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_BLEND_SRC_ALPHA = 32971;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_INCR_WRAP = 34055;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_DECR_WRAP = 34056;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_LOD_BIAS = 34049;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MIRRORED_REPEAT = 33648;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected GL14C() {
/* 103 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer1, @NativeType("GLsizei const *") IntBuffer paramIntBuffer2) {
/* 150 */     if (Checks.CHECKS) {
/* 151 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());
/*     */     }
/* 153 */     nglMultiDrawArrays(paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), paramIntBuffer1.remaining());
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
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer) {
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check((CustomBuffer)paramPointerBuffer, paramIntBuffer.remaining());
/*     */     }
/* 181 */     nglMultiDrawElements(paramInt1, MemoryUtil.memAddress(paramIntBuffer), paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramIntBuffer.remaining());
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
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(paramFloatBuffer, 3);
/*     */     }
/* 225 */     nglPointParameterfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 245 */     nglPointParameteriv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glMultiDrawArrays(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint1, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 268 */     long l = (GL.getICD()).glMultiDrawArrays;
/* 269 */     if (Checks.CHECKS) {
/* 270 */       Checks.check(l);
/* 271 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     } 
/* 273 */     JNI.callPPV(paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint1.length, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer) {
/* 282 */     long l = (GL.getICD()).glMultiDrawElements;
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(l);
/* 285 */       Checks.check((CustomBuffer)paramPointerBuffer, paramArrayOfint.length);
/*     */     } 
/* 287 */     JNI.callPPV(paramInt1, paramArrayOfint, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint.length, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPointParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 296 */     long l = (GL.getICD()).glPointParameterfv;
/* 297 */     if (Checks.CHECKS) {
/* 298 */       Checks.check(l);
/* 299 */       Checks.check(paramArrayOffloat, 3);
/*     */     } 
/* 301 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPointParameteriv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 310 */     long l = (GL.getICD()).glPointParameteriv;
/* 311 */     if (Checks.CHECKS) {
/* 312 */       Checks.check(l);
/* 313 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 315 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glBlendColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glBlendEquation(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglMultiDrawArrays(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglMultiDrawElements(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native void glPointParameterf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glPointParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void nglPointParameterfv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglPointParameteriv(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glBlendFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL14C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */