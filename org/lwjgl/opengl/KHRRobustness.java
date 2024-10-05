/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class KHRRobustness
/*     */ {
/*     */   public static final int GL_NO_ERROR = 0;
/*     */   public static final int GL_GUILTY_CONTEXT_RESET = 33363;
/*     */   public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
/*     */   public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
/*     */   public static final int GL_CONTEXT_ROBUST_ACCESS = 37107;
/*     */   public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
/*     */   public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
/*     */   public static final int GL_NO_RESET_NOTIFICATION = 33377;
/*     */   public static final int GL_CONTEXT_LOST = 1287;
/*     */   
/*     */   static {
/*  51 */     GL.initialize();
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
/*     */   protected KHRRobustness() {
/*  74 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("GLenum")
/*     */   public static int glGetGraphicsResetStatus() {
/* 116 */     return GL45C.glGetGraphicsResetStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {
/* 127 */     GL45C.nglReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void *") long paramLong) {
/* 143 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 158 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
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
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 173 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer);
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
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 188 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer);
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
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 203 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformfv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 214 */     GL45C.nglGetnUniformfv(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 225 */     GL45C.glGetnUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetnUniformf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 236 */     return GL45C.glGetnUniformf(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 247 */     GL45C.nglGetnUniformiv(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 258 */     GL45C.glGetnUniformiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 269 */     return GL45C.glGetnUniformi(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetnUniformuiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 280 */     GL45C.nglGetnUniformuiv(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 291 */     GL45C.glGetnUniformuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetnUniformui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 302 */     return GL45C.glGetnUniformui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/* 307 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 312 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glReadnPixels(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 317 */     GL45C.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 322 */     GL45C.glGetnUniformfv(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 327 */     GL45C.glGetnUniformiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 332 */     GL45C.glGetnUniformuiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\KHRRobustness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */