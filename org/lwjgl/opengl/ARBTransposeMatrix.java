/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class ARBTransposeMatrix
/*     */ {
/*     */   public static final int GL_TRANSPOSE_MODELVIEW_MATRIX_ARB = 34019;
/*     */   public static final int GL_TRANSPOSE_PROJECTION_MATRIX_ARB = 34020;
/*     */   public static final int GL_TRANSPOSE_TEXTURE_MATRIX_ARB = 34021;
/*     */   public static final int GL_TRANSPOSE_COLOR_MATRIX_ARB = 34022;
/*     */   
/*     */   static {
/*  31 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBTransposeMatrix() {
/*  41 */     throw new UnsupportedOperationException();
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
/*     */   public static void glLoadTransposeMatrixfARB(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  64 */     if (Checks.CHECKS) {
/*  65 */       Checks.check(paramFloatBuffer, 16);
/*     */     }
/*  67 */     nglLoadTransposeMatrixfARB(MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glLoadTransposeMatrixdARB(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  81 */     if (Checks.CHECKS) {
/*  82 */       Checks.check(paramDoubleBuffer, 16);
/*     */     }
/*  84 */     nglLoadTransposeMatrixdARB(MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glMultTransposeMatrixfARB(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(paramFloatBuffer, 16);
/*     */     }
/* 101 */     nglMultTransposeMatrixfARB(MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMultTransposeMatrixdARB(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check(paramDoubleBuffer, 16);
/*     */     }
/* 118 */     nglMultTransposeMatrixdARB(MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixfARB(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 123 */     long l = (GL.getICD()).glLoadTransposeMatrixfARB;
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(l);
/* 126 */       Checks.check(paramArrayOffloat, 16);
/*     */     } 
/* 128 */     JNI.callPV(paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glLoadTransposeMatrixdARB(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 133 */     long l = (GL.getICD()).glLoadTransposeMatrixdARB;
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(l);
/* 136 */       Checks.check(paramArrayOfdouble, 16);
/*     */     } 
/* 138 */     JNI.callPV(paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixfARB(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 143 */     long l = (GL.getICD()).glMultTransposeMatrixfARB;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(l);
/* 146 */       Checks.check(paramArrayOffloat, 16);
/*     */     } 
/* 148 */     JNI.callPV(paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultTransposeMatrixdARB(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 153 */     long l = (GL.getICD()).glMultTransposeMatrixdARB;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(l);
/* 156 */       Checks.check(paramArrayOfdouble, 16);
/*     */     } 
/* 158 */     JNI.callPV(paramArrayOfdouble, l);
/*     */   }
/*     */   
/*     */   public static native void nglLoadTransposeMatrixfARB(long paramLong);
/*     */   
/*     */   public static native void nglLoadTransposeMatrixdARB(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixfARB(long paramLong);
/*     */   
/*     */   public static native void nglMultTransposeMatrixdARB(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTransposeMatrix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */