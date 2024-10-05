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
/*     */ public class EXTSecondaryColor
/*     */ {
/*     */   public static final int GL_COLOR_SUM_EXT = 33880;
/*     */   public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 33881;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 33882;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 33883;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 33884;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 33885;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 33886;
/*     */   
/*     */   static {
/*  24 */     GL.initialize();
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
/*     */   protected EXTSecondaryColor() {
/*  46 */     throw new UnsupportedOperationException();
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
/*     */   public static void glSecondaryColor3bvEXT(@NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(paramByteBuffer, 3);
/*     */     }
/* 151 */     nglSecondaryColor3bvEXT(MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glSecondaryColor3svEXT(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 165 */     if (Checks.CHECKS) {
/* 166 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 168 */     nglSecondaryColor3svEXT(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glSecondaryColor3ivEXT(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 185 */     nglSecondaryColor3ivEXT(MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glSecondaryColor3fvEXT(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(paramFloatBuffer, 3);
/*     */     }
/* 202 */     nglSecondaryColor3fvEXT(MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glSecondaryColor3dvEXT(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(paramDoubleBuffer, 3);
/*     */     }
/* 219 */     nglSecondaryColor3dvEXT(MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glSecondaryColor3ubvEXT(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(paramByteBuffer, 3);
/*     */     }
/* 236 */     nglSecondaryColor3ubvEXT(MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glSecondaryColor3usvEXT(@NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 250 */     if (Checks.CHECKS) {
/* 251 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 253 */     nglSecondaryColor3usvEXT(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glSecondaryColor3uivEXT(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 267 */     if (Checks.CHECKS) {
/* 268 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 270 */     nglSecondaryColor3uivEXT(MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 287 */     nglSecondaryColorPointerEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 299 */     nglSecondaryColorPointerEXT(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 311 */     nglSecondaryColorPointerEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 323 */     nglSecondaryColorPointerEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 335 */     nglSecondaryColorPointerEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3svEXT(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 340 */     long l = (GL.getICD()).glSecondaryColor3svEXT;
/* 341 */     if (Checks.CHECKS) {
/* 342 */       Checks.check(l);
/* 343 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 345 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3ivEXT(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 350 */     long l = (GL.getICD()).glSecondaryColor3ivEXT;
/* 351 */     if (Checks.CHECKS) {
/* 352 */       Checks.check(l);
/* 353 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 355 */     JNI.callPV(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3fvEXT(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 360 */     long l = (GL.getICD()).glSecondaryColor3fvEXT;
/* 361 */     if (Checks.CHECKS) {
/* 362 */       Checks.check(l);
/* 363 */       Checks.check(paramArrayOffloat, 3);
/*     */     } 
/* 365 */     JNI.callPV(paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3dvEXT(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 370 */     long l = (GL.getICD()).glSecondaryColor3dvEXT;
/* 371 */     if (Checks.CHECKS) {
/* 372 */       Checks.check(l);
/* 373 */       Checks.check(paramArrayOfdouble, 3);
/*     */     } 
/* 375 */     JNI.callPV(paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3usvEXT(@NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 380 */     long l = (GL.getICD()).glSecondaryColor3usvEXT;
/* 381 */     if (Checks.CHECKS) {
/* 382 */       Checks.check(l);
/* 383 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 385 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3uivEXT(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 390 */     long l = (GL.getICD()).glSecondaryColor3uivEXT;
/* 391 */     if (Checks.CHECKS) {
/* 392 */       Checks.check(l);
/* 393 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 395 */     JNI.callPV(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") short[] paramArrayOfshort) {
/* 400 */     long l = (GL.getICD()).glSecondaryColorPointerEXT;
/* 401 */     if (Checks.CHECKS) {
/* 402 */       Checks.check(l);
/*     */     }
/* 404 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") int[] paramArrayOfint) {
/* 409 */     long l = (GL.getICD()).glSecondaryColorPointerEXT;
/* 410 */     if (Checks.CHECKS) {
/* 411 */       Checks.check(l);
/*     */     }
/* 413 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorPointerEXT(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") float[] paramArrayOffloat) {
/* 418 */     long l = (GL.getICD()).glSecondaryColorPointerEXT;
/* 419 */     if (Checks.CHECKS) {
/* 420 */       Checks.check(l);
/*     */     }
/* 422 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void glSecondaryColor3bEXT(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3sEXT(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3iEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glSecondaryColor3fEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glSecondaryColor3dEXT(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glSecondaryColor3ubEXT(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*     */   
/*     */   public static native void glSecondaryColor3usEXT(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*     */   
/*     */   public static native void glSecondaryColor3uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglSecondaryColor3bvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3svEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3ivEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3fvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3dvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3ubvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3usvEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColor3uivEXT(long paramLong);
/*     */   
/*     */   public static native void nglSecondaryColorPointerEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTSecondaryColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */