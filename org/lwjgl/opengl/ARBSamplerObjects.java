/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBSamplerObjects
/*     */ {
/*     */   public static final int GL_SAMPLER_BINDING = 35097;
/*     */   
/*     */   static {
/*  32 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBSamplerObjects() {
/*  38 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenSamplers(int paramInt, long paramLong) {
/*  49 */     GL33C.nglGenSamplers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  58 */     GL33C.glGenSamplers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenSamplers() {
/*  64 */     return GL33C.glGenSamplers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteSamplers(int paramInt, long paramLong) {
/*  75 */     GL33C.nglDeleteSamplers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  84 */     GL33C.glDeleteSamplers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int paramInt) {
/*  89 */     GL33C.glDeleteSamplers(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSampler(@NativeType("GLuint") int paramInt) {
/* 101 */     return GL33C.glIsSampler(paramInt);
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
/*     */   public static void glBindSampler(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 113 */     GL33C.glBindSampler(paramInt1, paramInt2);
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
/*     */   public static void glSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 126 */     GL33C.glSamplerParameteri(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/* 139 */     GL33C.glSamplerParameterf(paramInt1, paramInt2, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 146 */     GL33C.nglSamplerParameteriv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 157 */     GL33C.glSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 164 */     GL33C.nglSamplerParameterfv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 175 */     GL33C.glSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 182 */     GL33C.nglSamplerParameterIiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 193 */     GL33C.glSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 200 */     GL33C.nglSamplerParameterIuiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 211 */     GL33C.glSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 218 */     GL33C.nglGetSamplerParameteriv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 229 */     GL33C.glGetSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 240 */     return GL33C.glGetSamplerParameteri(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterfv(int paramInt1, int paramInt2, long paramLong) {
/* 247 */     GL33C.nglGetSamplerParameterfv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 258 */     GL33C.glGetSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 269 */     return GL33C.glGetSamplerParameterf(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/* 276 */     GL33C.nglGetSamplerParameterIiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 287 */     GL33C.glGetSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 298 */     return GL33C.glGetSamplerParameterIi(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/* 305 */     GL33C.nglGetSamplerParameterIuiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 316 */     GL33C.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 327 */     return GL33C.glGetSamplerParameterIui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 332 */     GL33C.glGenSamplers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 337 */     GL33C.glDeleteSamplers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 342 */     GL33C.glSamplerParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 347 */     GL33C.glSamplerParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 352 */     GL33C.glSamplerParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 357 */     GL33C.glSamplerParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 362 */     GL33C.glGetSamplerParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 367 */     GL33C.glGetSamplerParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 372 */     GL33C.glGetSamplerParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 377 */     GL33C.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSamplerObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */