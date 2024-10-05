/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ARBViewportArray
/*     */ {
/*     */   public static final int GL_MAX_VIEWPORTS = 33371;
/*     */   public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
/*     */   public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
/*     */   public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
/*     */   public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
/*     */   public static final int GL_UNDEFINED_VERTEX = 33376;
/*     */   
/*     */   static {
/*  32 */     GL.initialize();
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
/*     */   protected ARBViewportArray() {
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
/*     */   public static void nglViewportArrayv(int paramInt1, int paramInt2, long paramLong) {
/*  57 */     GL41C.nglViewportArrayv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glViewportArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  67 */     GL41C.glViewportArrayv(paramInt, paramFloatBuffer);
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
/*     */   public static void glViewportIndexedf(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/*  82 */     GL41C.glViewportIndexedf(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglViewportIndexedfv(int paramInt, long paramLong) {
/*  89 */     GL41C.nglViewportIndexedfv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glViewportIndexedfv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  99 */     GL41C.glViewportIndexedfv(paramInt, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglScissorArrayv(int paramInt1, int paramInt2, long paramLong) {
/* 110 */     GL41C.nglScissorArrayv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glScissorArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 120 */     GL41C.glScissorArrayv(paramInt, paramIntBuffer);
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
/*     */   public static void glScissorIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 135 */     GL41C.glScissorIndexed(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglScissorIndexedv(int paramInt, long paramLong) {
/* 142 */     GL41C.nglScissorIndexedv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glScissorIndexedv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 152 */     GL41C.glScissorIndexedv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDepthRangeArrayv(int paramInt1, int paramInt2, long paramLong) {
/* 163 */     GL41C.nglDepthRangeArrayv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDepthRangeArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 173 */     GL41C.glDepthRangeArrayv(paramInt, paramDoubleBuffer);
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
/*     */   public static void glDepthRangeIndexed(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 186 */     GL41C.glDepthRangeIndexed(paramInt, paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFloati_v(int paramInt1, int paramInt2, long paramLong) {
/* 193 */     GL41C.nglGetFloati_v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetFloati_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 204 */     GL41C.glGetFloati_v(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetFloati(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 215 */     return GL41C.glGetFloati(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetDoublei_v(int paramInt1, int paramInt2, long paramLong) {
/* 222 */     GL41C.nglGetDoublei_v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 233 */     GL41C.glGetDoublei_v(paramInt1, paramInt2, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetDoublei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 244 */     return GL41C.glGetDoublei(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 249 */     GL41C.glViewportArrayv(paramInt, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glViewportIndexedfv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 254 */     GL41C.glViewportIndexedfv(paramInt, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 259 */     GL41C.glScissorArrayv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glScissorIndexedv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 264 */     GL41C.glScissorIndexedv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDepthRangeArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 269 */     GL41C.glDepthRangeArrayv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFloati_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 274 */     GL41C.glGetFloati_v(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 279 */     GL41C.glGetDoublei_v(paramInt1, paramInt2, paramArrayOfdouble);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBViewportArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */