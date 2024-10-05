/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class ARBClearBufferObject
/*     */ {
/*     */   static {
/*  33 */     GL.initialize();
/*     */   }
/*     */   protected ARBClearBufferObject() {
/*  36 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  43 */     GL43C.nglClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  58 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  73 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer);
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
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  88 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 103 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglClearBufferSubData(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3) {
/* 110 */     GL43C.nglClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramLong3);
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
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 127 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramByteBuffer);
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
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 144 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramShortBuffer);
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
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 161 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramIntBuffer);
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
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 178 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramFloatBuffer);
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
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 198 */     nglClearNamedBufferDataEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 213 */     nglClearNamedBufferDataEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
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
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 228 */     nglClearNamedBufferDataEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 243 */     nglClearNamedBufferDataEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
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
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 265 */     nglClearNamedBufferSubDataEXT(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 282 */     nglClearNamedBufferSubDataEXT(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramShortBuffer));
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
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 299 */     nglClearNamedBufferSubDataEXT(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 316 */     nglClearNamedBufferSubDataEXT(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 321 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 326 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 331 */     GL43C.glClearBufferData(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 336 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 341 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 346 */     GL43C.glClearBufferSubData(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 351 */     long l = (GL.getICD()).glClearNamedBufferDataEXT;
/* 352 */     if (Checks.CHECKS) {
/* 353 */       Checks.check(l);
/*     */     }
/* 355 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 360 */     long l = (GL.getICD()).glClearNamedBufferDataEXT;
/* 361 */     if (Checks.CHECKS) {
/* 362 */       Checks.check(l);
/*     */     }
/* 364 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 369 */     long l = (GL.getICD()).glClearNamedBufferDataEXT;
/* 370 */     if (Checks.CHECKS) {
/* 371 */       Checks.check(l);
/*     */     }
/* 373 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 378 */     long l = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 379 */     if (Checks.CHECKS) {
/* 380 */       Checks.check(l);
/*     */     }
/* 382 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 387 */     long l = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 388 */     if (Checks.CHECKS) {
/* 389 */       Checks.check(l);
/*     */     }
/* 391 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glClearNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 396 */     long l = (GL.getICD()).glClearNamedBufferSubDataEXT;
/* 397 */     if (Checks.CHECKS) {
/* 398 */       Checks.check(l);
/*     */     }
/* 400 */     JNI.callPPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglClearNamedBufferDataEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglClearNamedBufferSubDataEXT(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBClearBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */