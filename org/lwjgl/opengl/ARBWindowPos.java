/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class ARBWindowPos
/*     */ {
/*     */   static {
/*  33 */     GL.initialize();
/*     */   }
/*     */   protected ARBWindowPos() {
/*  36 */     throw new UnsupportedOperationException();
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
/*     */   public static void glWindowPos2ivARB(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(paramIntBuffer, 2);
/*     */     }
/*  93 */     nglWindowPos2ivARB(MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glWindowPos2svARB(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/* 110 */     nglWindowPos2svARB(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glWindowPos2fvARB(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(paramFloatBuffer, 2);
/*     */     }
/* 127 */     nglWindowPos2fvARB(MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glWindowPos2dvARB(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(paramDoubleBuffer, 2);
/*     */     }
/* 144 */     nglWindowPos2dvARB(MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glWindowPos3ivARB(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 202 */     if (Checks.CHECKS) {
/* 203 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 205 */     nglWindowPos3ivARB(MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glWindowPos3svARB(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 222 */     nglWindowPos3svARB(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glWindowPos3fvARB(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(paramFloatBuffer, 3);
/*     */     }
/* 239 */     nglWindowPos3fvARB(MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glWindowPos3dvARB(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.check(paramDoubleBuffer, 3);
/*     */     }
/* 256 */     nglWindowPos3dvARB(MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2ivARB(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 261 */     long l = (GL.getICD()).glWindowPos2ivARB;
/* 262 */     if (Checks.CHECKS) {
/* 263 */       Checks.check(l);
/* 264 */       Checks.check(paramArrayOfint, 2);
/*     */     } 
/* 266 */     JNI.callPV(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2svARB(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 271 */     long l = (GL.getICD()).glWindowPos2svARB;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(l);
/* 274 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 276 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2fvARB(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 281 */     long l = (GL.getICD()).glWindowPos2fvARB;
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(l);
/* 284 */       Checks.check(paramArrayOffloat, 2);
/*     */     } 
/* 286 */     JNI.callPV(paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos2dvARB(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 291 */     long l = (GL.getICD()).glWindowPos2dvARB;
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(l);
/* 294 */       Checks.check(paramArrayOfdouble, 2);
/*     */     } 
/* 296 */     JNI.callPV(paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3ivARB(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 301 */     long l = (GL.getICD()).glWindowPos3ivARB;
/* 302 */     if (Checks.CHECKS) {
/* 303 */       Checks.check(l);
/* 304 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 306 */     JNI.callPV(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3svARB(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 311 */     long l = (GL.getICD()).glWindowPos3svARB;
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(l);
/* 314 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 316 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3fvARB(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 321 */     long l = (GL.getICD()).glWindowPos3fvARB;
/* 322 */     if (Checks.CHECKS) {
/* 323 */       Checks.check(l);
/* 324 */       Checks.check(paramArrayOffloat, 3);
/*     */     } 
/* 326 */     JNI.callPV(paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowPos3dvARB(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 331 */     long l = (GL.getICD()).glWindowPos3dvARB;
/* 332 */     if (Checks.CHECKS) {
/* 333 */       Checks.check(l);
/* 334 */       Checks.check(paramArrayOfdouble, 3);
/*     */     } 
/* 336 */     JNI.callPV(paramArrayOfdouble, l);
/*     */   }
/*     */   
/*     */   public static native void glWindowPos2iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glWindowPos2sARB(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glWindowPos2fARB(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glWindowPos2dARB(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglWindowPos2ivARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2svARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2fvARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos2dvARB(long paramLong);
/*     */   
/*     */   public static native void glWindowPos3iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glWindowPos3sARB(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glWindowPos3fARB(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glWindowPos3dARB(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglWindowPos3ivARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3svARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3fvARB(long paramLong);
/*     */   
/*     */   public static native void nglWindowPos3dvARB(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBWindowPos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */