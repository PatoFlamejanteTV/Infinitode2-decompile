/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBVertexBlend
/*     */ {
/*     */   public static final int GL_MAX_VERTEX_UNITS_ARB = 34468;
/*     */   public static final int GL_ACTIVE_VERTEX_UNITS_ARB = 34469;
/*     */   public static final int GL_WEIGHT_SUM_UNITY_ARB = 34470;
/*     */   public static final int GL_VERTEX_BLEND_ARB = 34471;
/*     */   public static final int GL_MODELVIEW0_ARB = 5888;
/*     */   public static final int GL_MODELVIEW1_ARB = 34058;
/*     */   public static final int GL_MODELVIEW2_ARB = 34594;
/*     */   public static final int GL_MODELVIEW3_ARB = 34595;
/*     */   public static final int GL_MODELVIEW4_ARB = 34596;
/*     */   public static final int GL_MODELVIEW5_ARB = 34597;
/*     */   
/*     */   static {
/*  27 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MODELVIEW6_ARB = 34598;
/*     */   
/*     */   public static final int GL_MODELVIEW7_ARB = 34599;
/*     */   
/*     */   public static final int GL_MODELVIEW8_ARB = 34600;
/*     */   
/*     */   public static final int GL_MODELVIEW9_ARB = 34601;
/*     */   
/*     */   public static final int GL_MODELVIEW10_ARB = 34602;
/*     */   
/*     */   public static final int GL_MODELVIEW11_ARB = 34603;
/*     */   
/*     */   public static final int GL_MODELVIEW12_ARB = 34604;
/*     */   
/*     */   public static final int GL_MODELVIEW13_ARB = 34605;
/*     */   
/*     */   public static final int GL_MODELVIEW14_ARB = 34606;
/*     */   
/*     */   public static final int GL_MODELVIEW15_ARB = 34607;
/*     */   
/*     */   public static final int GL_MODELVIEW16_ARB = 34608;
/*     */   
/*     */   public static final int GL_MODELVIEW17_ARB = 34609;
/*     */   
/*     */   public static final int GL_MODELVIEW18_ARB = 34610;
/*     */   
/*     */   public static final int GL_MODELVIEW19_ARB = 34611;
/*     */   
/*     */   public static final int GL_MODELVIEW20_ARB = 34612;
/*     */   
/*     */   public static final int GL_MODELVIEW21_ARB = 34613;
/*     */   
/*     */   public static final int GL_MODELVIEW22_ARB = 34614;
/*     */   
/*     */   public static final int GL_MODELVIEW23_ARB = 34615;
/*     */   
/*     */   public static final int GL_MODELVIEW24_ARB = 34616;
/*     */   
/*     */   public static final int GL_MODELVIEW25_ARB = 34617;
/*     */   
/*     */   public static final int GL_MODELVIEW26_ARB = 34618;
/*     */   
/*     */   public static final int GL_MODELVIEW27_ARB = 34619;
/*     */   
/*     */   public static final int GL_MODELVIEW28_ARB = 34620;
/*     */   
/*     */   public static final int GL_MODELVIEW29_ARB = 34621;
/*     */   
/*     */   public static final int GL_MODELVIEW30_ARB = 34622;
/*     */   
/*     */   public static final int GL_MODELVIEW31_ARB = 34623;
/*     */   
/*     */   public static final int GL_CURRENT_WEIGHT_ARB = 34472;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_TYPE_ARB = 34473;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_STRIDE_ARB = 34474;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_SIZE_ARB = 34475;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_POINTER_ARB = 34476;
/*     */   
/*     */   public static final int GL_WEIGHT_ARRAY_ARB = 34477;
/*     */   
/*     */   protected ARBVertexBlend() {
/*  96 */     throw new UnsupportedOperationException();
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
/*     */   public static void glWeightfvARB(@NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 114 */     nglWeightfvARB(paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glWeightbvARB(@NativeType("GLbyte *") ByteBuffer paramByteBuffer) {
/* 132 */     nglWeightbvARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glWeightubvARB(@NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/* 150 */     nglWeightubvARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glWeightsvARB(@NativeType("GLshort *") ShortBuffer paramShortBuffer) {
/* 168 */     nglWeightsvARB(paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glWeightusvARB(@NativeType("GLushort *") ShortBuffer paramShortBuffer) {
/* 186 */     nglWeightusvARB(paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glWeightivARB(@NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 204 */     nglWeightivARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glWeightuivARB(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 222 */     nglWeightuivARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glWeightdvARB(@NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 240 */     nglWeightdvARB(paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 257 */     nglWeightPointerARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 269 */     nglWeightPointerARB(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 281 */     nglWeightPointerARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 293 */     nglWeightPointerARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 305 */     nglWeightPointerARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glWeightfvARB(@NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 319 */     long l = (GL.getICD()).glWeightfvARB;
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.check(l);
/*     */     }
/* 323 */     JNI.callPV(paramArrayOffloat.length, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightsvARB(@NativeType("GLshort *") short[] paramArrayOfshort) {
/* 328 */     long l = (GL.getICD()).glWeightsvARB;
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(l);
/*     */     }
/* 332 */     JNI.callPV(paramArrayOfshort.length, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightusvARB(@NativeType("GLushort *") short[] paramArrayOfshort) {
/* 337 */     long l = (GL.getICD()).glWeightusvARB;
/* 338 */     if (Checks.CHECKS) {
/* 339 */       Checks.check(l);
/*     */     }
/* 341 */     JNI.callPV(paramArrayOfshort.length, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightivARB(@NativeType("GLint *") int[] paramArrayOfint) {
/* 346 */     long l = (GL.getICD()).glWeightivARB;
/* 347 */     if (Checks.CHECKS) {
/* 348 */       Checks.check(l);
/*     */     }
/* 350 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightuivARB(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 355 */     long l = (GL.getICD()).glWeightuivARB;
/* 356 */     if (Checks.CHECKS) {
/* 357 */       Checks.check(l);
/*     */     }
/* 359 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightdvARB(@NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 364 */     long l = (GL.getICD()).glWeightdvARB;
/* 365 */     if (Checks.CHECKS) {
/* 366 */       Checks.check(l);
/*     */     }
/* 368 */     JNI.callPV(paramArrayOfdouble.length, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") short[] paramArrayOfshort) {
/* 373 */     long l = (GL.getICD()).glWeightPointerARB;
/* 374 */     if (Checks.CHECKS) {
/* 375 */       Checks.check(l);
/*     */     }
/* 377 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") int[] paramArrayOfint) {
/* 382 */     long l = (GL.getICD()).glWeightPointerARB;
/* 383 */     if (Checks.CHECKS) {
/* 384 */       Checks.check(l);
/*     */     }
/* 386 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWeightPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") float[] paramArrayOffloat) {
/* 391 */     long l = (GL.getICD()).glWeightPointerARB;
/* 392 */     if (Checks.CHECKS) {
/* 393 */       Checks.check(l);
/*     */     }
/* 395 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglWeightfvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightbvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightsvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightusvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightuivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightdvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglWeightPointerARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glVertexBlendARB(@NativeType("GLint") int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */