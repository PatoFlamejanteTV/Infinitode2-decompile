/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL33
/*      */   extends GL32
/*      */ {
/*      */   public static final int GL_SRC1_COLOR = 35065;
/*      */   public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
/*      */   public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
/*      */   public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
/*      */   public static final int GL_ANY_SAMPLES_PASSED = 35887;
/*      */   public static final int GL_SAMPLER_BINDING = 35097;
/*      */   public static final int GL_RGB10_A2UI = 36975;
/*      */   public static final int GL_TEXTURE_SWIZZLE_R = 36418;
/*      */   public static final int GL_TEXTURE_SWIZZLE_G = 36419;
/*      */   public static final int GL_TEXTURE_SWIZZLE_B = 36420;
/*      */   public static final int GL_TEXTURE_SWIZZLE_A = 36421;
/*      */   public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
/*      */   public static final int GL_TIME_ELAPSED = 35007;
/*      */   public static final int GL_TIMESTAMP = 36392;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
/*      */   public static final int GL_INT_2_10_10_10_REV = 36255;
/*      */   
/*      */   static {
/*   38 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL33() {
/*   93 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindFragDataLocationIndexed(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  100 */     GL33C.nglBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  114 */     GL33C.glBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  128 */     GL33C.glBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetFragDataIndex(int paramInt, long paramLong) {
/*  135 */     return GL33C.nglGetFragDataIndex(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  148 */     return GL33C.glGetFragDataIndex(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  161 */     return GL33C.glGetFragDataIndex(paramInt, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenSamplers(int paramInt, long paramLong) {
/*  172 */     GL33C.nglGenSamplers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  183 */     GL33C.glGenSamplers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenSamplers() {
/*  193 */     return GL33C.glGenSamplers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteSamplers(int paramInt, long paramLong) {
/*  204 */     GL33C.nglDeleteSamplers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  215 */     GL33C.glDeleteSamplers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") int paramInt) {
/*  224 */     GL33C.glDeleteSamplers(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsSampler(@NativeType("GLuint") int paramInt) {
/*  238 */     return GL33C.glIsSampler(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindSampler(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  252 */     GL33C.glBindSampler(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  267 */     GL33C.glSamplerParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/*  282 */     GL33C.glSamplerParameterf(paramInt1, paramInt2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglSamplerParameteriv(int paramInt1, int paramInt2, long paramLong) {
/*  289 */     GL33C.nglSamplerParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  302 */     GL33C.glSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglSamplerParameterfv(int paramInt1, int paramInt2, long paramLong) {
/*  309 */     GL33C.nglSamplerParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  322 */     GL33C.glSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/*  329 */     GL33C.nglSamplerParameterIiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  342 */     GL33C.glSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/*  349 */     GL33C.nglSamplerParameterIuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  362 */     GL33C.glSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetSamplerParameteriv(int paramInt1, int paramInt2, long paramLong) {
/*  369 */     GL33C.nglGetSamplerParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  382 */     GL33C.glGetSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  395 */     return GL33C.glGetSamplerParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetSamplerParameterfv(int paramInt1, int paramInt2, long paramLong) {
/*  402 */     GL33C.nglGetSamplerParameterfv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  415 */     GL33C.glGetSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  428 */     return GL33C.glGetSamplerParameterf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong) {
/*  435 */     GL33C.nglGetSamplerParameterIiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  448 */     GL33C.glGetSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetSamplerParameterIi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  461 */     return GL33C.glGetSamplerParameterIi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong) {
/*  468 */     GL33C.nglGetSamplerParameterIuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  481 */     GL33C.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetSamplerParameterIui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  494 */     return GL33C.glGetSamplerParameterIui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glQueryCounter(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  508 */     GL33C.glQueryCounter(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryObjecti64v(int paramInt1, int paramInt2, long paramLong) {
/*  515 */     GL33C.nglGetQueryObjecti64v(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  528 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long paramLong) {
/*  541 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetQueryObjecti64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  554 */     return GL33C.glGetQueryObjecti64(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryObjectui64v(int paramInt1, int paramInt2, long paramLong) {
/*  561 */     GL33C.nglGetQueryObjectui64v(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/*  574 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long paramLong) {
/*  587 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetQueryObjectui64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  600 */     return GL33C.glGetQueryObjectui64(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  614 */     GL33C.glVertexAttribDivisor(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  667 */     if (Checks.CHECKS) {
/*  668 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  670 */     nglVertexP2uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  687 */     if (Checks.CHECKS) {
/*  688 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  690 */     nglVertexP3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  707 */     if (Checks.CHECKS) {
/*  708 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  710 */     nglVertexP4uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP1uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  775 */     if (Checks.CHECKS) {
/*  776 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  778 */     nglTexCoordP1uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  795 */     if (Checks.CHECKS) {
/*  796 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  798 */     nglTexCoordP2uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  815 */     if (Checks.CHECKS) {
/*  816 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  818 */     nglTexCoordP3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  835 */     if (Checks.CHECKS) {
/*  836 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  838 */     nglTexCoordP4uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  908 */     if (Checks.CHECKS) {
/*  909 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  911 */     nglMultiTexCoordP1uiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  929 */     if (Checks.CHECKS) {
/*  930 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  932 */     nglMultiTexCoordP2uiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  950 */     if (Checks.CHECKS) {
/*  951 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  953 */     nglMultiTexCoordP3uiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  971 */     if (Checks.CHECKS) {
/*  972 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  974 */     nglMultiTexCoordP4uiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1003 */     if (Checks.CHECKS) {
/* 1004 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1006 */     nglNormalP3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1047 */     if (Checks.CHECKS) {
/* 1048 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1050 */     nglColorP3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1067 */     if (Checks.CHECKS) {
/* 1068 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1070 */     nglColorP4uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1099 */     if (Checks.CHECKS) {
/* 1100 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1102 */     nglSecondaryColorP3uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 1118 */     GL33C.glVertexAttribP1ui(paramInt1, paramInt2, paramBoolean, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 1134 */     GL33C.glVertexAttribP2ui(paramInt1, paramInt2, paramBoolean, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 1150 */     GL33C.glVertexAttribP3ui(paramInt1, paramInt2, paramBoolean, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 1166 */     GL33C.glVertexAttribP4ui(paramInt1, paramInt2, paramBoolean, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribP1uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 1173 */     GL33C.nglVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1187 */     GL33C.glVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribP2uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 1194 */     GL33C.nglVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1208 */     GL33C.glVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribP3uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 1215 */     GL33C.nglVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1229 */     GL33C.glVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribP4uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 1236 */     GL33C.nglVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1250 */     GL33C.glVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1259 */     GL33C.glGenSamplers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1268 */     GL33C.glDeleteSamplers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1277 */     GL33C.glSamplerParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1286 */     GL33C.glSamplerParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1295 */     GL33C.glSamplerParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1304 */     GL33C.glSamplerParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1313 */     GL33C.glGetSamplerParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1322 */     GL33C.glGetSamplerParameterfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1331 */     GL33C.glGetSamplerParameterIiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1340 */     GL33C.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 1349 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 1358 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1367 */     long l = (GL.getICD()).glVertexP2uiv;
/* 1368 */     if (Checks.CHECKS) {
/* 1369 */       Checks.check(l);
/* 1370 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1372 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1381 */     long l = (GL.getICD()).glVertexP3uiv;
/* 1382 */     if (Checks.CHECKS) {
/* 1383 */       Checks.check(l);
/* 1384 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1386 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1395 */     long l = (GL.getICD()).glVertexP4uiv;
/* 1396 */     if (Checks.CHECKS) {
/* 1397 */       Checks.check(l);
/* 1398 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1400 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP1uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1409 */     long l = (GL.getICD()).glTexCoordP1uiv;
/* 1410 */     if (Checks.CHECKS) {
/* 1411 */       Checks.check(l);
/* 1412 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1414 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1423 */     long l = (GL.getICD()).glTexCoordP2uiv;
/* 1424 */     if (Checks.CHECKS) {
/* 1425 */       Checks.check(l);
/* 1426 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1428 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1437 */     long l = (GL.getICD()).glTexCoordP3uiv;
/* 1438 */     if (Checks.CHECKS) {
/* 1439 */       Checks.check(l);
/* 1440 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1442 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTexCoordP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1451 */     long l = (GL.getICD()).glTexCoordP4uiv;
/* 1452 */     if (Checks.CHECKS) {
/* 1453 */       Checks.check(l);
/* 1454 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1456 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1465 */     long l = (GL.getICD()).glMultiTexCoordP1uiv;
/* 1466 */     if (Checks.CHECKS) {
/* 1467 */       Checks.check(l);
/* 1468 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1470 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1479 */     long l = (GL.getICD()).glMultiTexCoordP2uiv;
/* 1480 */     if (Checks.CHECKS) {
/* 1481 */       Checks.check(l);
/* 1482 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1484 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1493 */     long l = (GL.getICD()).glMultiTexCoordP3uiv;
/* 1494 */     if (Checks.CHECKS) {
/* 1495 */       Checks.check(l);
/* 1496 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1498 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1507 */     long l = (GL.getICD()).glMultiTexCoordP4uiv;
/* 1508 */     if (Checks.CHECKS) {
/* 1509 */       Checks.check(l);
/* 1510 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1512 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNormalP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1521 */     long l = (GL.getICD()).glNormalP3uiv;
/* 1522 */     if (Checks.CHECKS) {
/* 1523 */       Checks.check(l);
/* 1524 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1526 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1535 */     long l = (GL.getICD()).glColorP3uiv;
/* 1536 */     if (Checks.CHECKS) {
/* 1537 */       Checks.check(l);
/* 1538 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1540 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1549 */     long l = (GL.getICD()).glColorP4uiv;
/* 1550 */     if (Checks.CHECKS) {
/* 1551 */       Checks.check(l);
/* 1552 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1554 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1563 */     long l = (GL.getICD()).glSecondaryColorP3uiv;
/* 1564 */     if (Checks.CHECKS) {
/* 1565 */       Checks.check(l);
/* 1566 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1568 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1577 */     GL33C.glVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1586 */     GL33C.glVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1595 */     GL33C.glVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1604 */     GL33C.glVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*      */   }
/*      */   
/*      */   public static native void glVertexP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglVertexP2uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexP3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexP4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglTexCoordP1uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglTexCoordP2uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglTexCoordP3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglTexCoordP4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMultiTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglMultiTexCoordP1uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoordP2uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoordP3uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoordP4uiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNormalP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglNormalP3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glColorP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglColorP3uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglColorP4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glSecondaryColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglSecondaryColorP3uiv(int paramInt, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL33.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */