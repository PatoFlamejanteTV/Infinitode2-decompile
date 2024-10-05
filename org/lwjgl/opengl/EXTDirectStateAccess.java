/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EXTDirectStateAccess
/*      */ {
/*      */   public static final int GL_PROGRAM_MATRIX_EXT = 36397;
/*      */   public static final int GL_TRANSPOSE_PROGRAM_MATRIX_EXT = 36398;
/*      */   public static final int GL_PROGRAM_MATRIX_STACK_DEPTH_EXT = 36399;
/*      */   
/*      */   static {
/*  172 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected EXTDirectStateAccess() {
/*  181 */     throw new UnsupportedOperationException();
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
/*      */   public static void glMatrixLoadfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  197 */     if (Checks.CHECKS) {
/*  198 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/*  200 */     nglMatrixLoadfEXT(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoaddEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  208 */     if (Checks.CHECKS) {
/*  209 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/*  211 */     nglMatrixLoaddEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  219 */     if (Checks.CHECKS) {
/*  220 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/*  222 */     nglMatrixMultfEXT(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultdEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  230 */     if (Checks.CHECKS) {
/*  231 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/*  233 */     nglMatrixMultdEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glTextureParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  289 */     if (Checks.CHECKS) {
/*  290 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  292 */     nglTextureParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glTextureParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  304 */     if (Checks.CHECKS) {
/*  305 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  307 */     nglTextureParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  315 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/*  319 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  323 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  327 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  331 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  335 */     nglTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  343 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") long paramLong) {
/*  347 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  351 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  355 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  359 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  363 */     nglTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  371 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") long paramLong) {
/*  375 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  379 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  383 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  387 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  391 */     nglTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  399 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") long paramLong) {
/*  403 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  407 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  411 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  415 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  419 */     nglTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  443 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") long paramLong) {
/*  447 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  451 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  455 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  459 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/*  463 */     nglGetTextureImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  471 */     if (Checks.CHECKS) {
/*  472 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  474 */     nglGetTextureParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetTextureParameterfEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  479 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  481 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  482 */       nglGetTextureParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/*  483 */       return floatBuffer.get(0);
/*      */     } finally {
/*  485 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  494 */     if (Checks.CHECKS) {
/*  495 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  497 */     nglGetTextureParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  502 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  504 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  505 */       nglGetTextureParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/*  506 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  508 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  517 */     if (Checks.CHECKS) {
/*  518 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  520 */     nglGetTextureLevelParameterfvEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetTextureLevelParameterfEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/*      */     MemoryStack memoryStack;
/*  525 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  527 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  528 */       nglGetTextureLevelParameterfvEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(floatBuffer));
/*  529 */       return floatBuffer.get(0);
/*      */     } finally {
/*  531 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  540 */     if (Checks.CHECKS) {
/*  541 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  543 */     nglGetTextureLevelParameterivEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetTextureLevelParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/*      */     MemoryStack memoryStack;
/*  548 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  550 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  551 */       nglGetTextureLevelParameterivEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer));
/*  552 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  554 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  563 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") long paramLong) {
/*  567 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  571 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  575 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  579 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  583 */     nglTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  591 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") long paramLong) {
/*  595 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  599 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  603 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  607 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  611 */     nglTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  627 */     nglMultiTexCoordPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/*  631 */     nglMultiTexCoordPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  635 */     nglMultiTexCoordPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  639 */     nglMultiTexCoordPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  643 */     nglMultiTexCoordPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexEnvfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  655 */     if (Checks.CHECKS) {
/*  656 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  658 */     nglMultiTexEnvfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexEnvivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  670 */     if (Checks.CHECKS) {
/*  671 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  673 */     nglMultiTexEnvivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexGendvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  685 */     if (Checks.CHECKS) {
/*  686 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/*  688 */     nglMultiTexGendvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultiTexGenfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  700 */     if (Checks.CHECKS) {
/*  701 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  703 */     nglMultiTexGenfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexGenivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  715 */     if (Checks.CHECKS) {
/*  716 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  718 */     nglMultiTexGenivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  726 */     if (Checks.CHECKS) {
/*  727 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  729 */     nglGetMultiTexEnvfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexEnvfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  734 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  736 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  737 */       nglGetMultiTexEnvfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/*  738 */       return floatBuffer.get(0);
/*      */     } finally {
/*  740 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  749 */     if (Checks.CHECKS) {
/*  750 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  752 */     nglGetMultiTexEnvivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexEnviEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  757 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  759 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  760 */       nglGetMultiTexEnvivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/*  761 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  763 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGendvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  772 */     if (Checks.CHECKS) {
/*  773 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  775 */     nglGetMultiTexGendvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static double glGetMultiTexGendEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  780 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  782 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/*  783 */       nglGetMultiTexGendvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(doubleBuffer));
/*  784 */       return doubleBuffer.get(0);
/*      */     } finally {
/*  786 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  795 */     if (Checks.CHECKS) {
/*  796 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  798 */     nglGetMultiTexGenfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexGenfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  803 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  805 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  806 */       nglGetMultiTexGenfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/*  807 */       return floatBuffer.get(0);
/*      */     } finally {
/*  809 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  818 */     if (Checks.CHECKS) {
/*  819 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  821 */     nglGetMultiTexGenivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexGeniEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/*  826 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  828 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  829 */       nglGetMultiTexGenivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/*  830 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  832 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glMultiTexParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  845 */     if (Checks.CHECKS) {
/*  846 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  848 */     nglMultiTexParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  860 */     if (Checks.CHECKS) {
/*  861 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  863 */     nglMultiTexParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  871 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") long paramLong) {
/*  875 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  879 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  883 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  887 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  891 */     nglMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  899 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") long paramLong) {
/*  903 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  907 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  911 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  915 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  919 */     nglMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  927 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") long paramLong) {
/*  931 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  935 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  939 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  943 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  947 */     nglMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  955 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") long paramLong) {
/*  959 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  963 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  967 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  971 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  975 */     nglMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  999 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") long paramLong) {
/* 1003 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1007 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1011 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1015 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 1019 */     nglGetMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1027 */     if (Checks.CHECKS) {
/* 1028 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1030 */     nglGetMultiTexParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexParameterfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1035 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1037 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1038 */       nglGetMultiTexParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(floatBuffer));
/* 1039 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1041 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1050 */     if (Checks.CHECKS) {
/* 1051 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1053 */     nglGetMultiTexParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1058 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1060 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1061 */       nglGetMultiTexParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1062 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1064 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1073 */     if (Checks.CHECKS) {
/* 1074 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1076 */     nglGetMultiTexLevelParameterfvEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetMultiTexLevelParameterfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/*      */     MemoryStack memoryStack;
/* 1081 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1083 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1084 */       nglGetMultiTexLevelParameterfvEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(floatBuffer));
/* 1085 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1087 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1096 */     if (Checks.CHECKS) {
/* 1097 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1099 */     nglGetMultiTexLevelParameterivEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexLevelParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/*      */     MemoryStack memoryStack;
/* 1104 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1106 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1107 */       nglGetMultiTexLevelParameterivEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer));
/* 1108 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1110 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1119 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") long paramLong) {
/* 1123 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1127 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1131 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1135 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1139 */     nglMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1147 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") long paramLong) {
/* 1151 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1155 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1159 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1163 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1167 */     nglMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetFloatIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1195 */     if (Checks.CHECKS) {
/* 1196 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1198 */     nglGetFloatIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetFloatIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1203 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1205 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1206 */       nglGetFloatIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1207 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1209 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoubleIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1218 */     if (Checks.CHECKS) {
/* 1219 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 1221 */     nglGetDoubleIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static double glGetDoubleIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1226 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1228 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 1229 */       nglGetDoubleIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 1230 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 1232 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPointerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1241 */     if (Checks.CHECKS) {
/* 1242 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1244 */     nglGetPointerIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static long glGetPointerIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1249 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1251 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 1252 */       nglGetPointerIndexedvEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1253 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 1255 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloati_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1264 */     if (Checks.CHECKS) {
/* 1265 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1267 */     nglGetFloati_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static float glGetFloatiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1272 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1274 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1275 */       nglGetFloati_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1276 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1278 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1287 */     if (Checks.CHECKS) {
/* 1288 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 1290 */     nglGetDoublei_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static double glGetDoubleiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1295 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1297 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 1298 */       nglGetDoublei_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 1299 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 1301 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetPointeri_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1310 */     if (Checks.CHECKS) {
/* 1311 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1313 */     nglGetPointeri_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static long glGetPointeriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1318 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1320 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 1321 */       nglGetPointeri_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1322 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 1324 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEnableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1331 */     EXTDrawBuffers2.glEnableIndexedEXT(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDisableIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1337 */     EXTDrawBuffers2.glDisableIndexedEXT(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsEnabledIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1344 */     return EXTDrawBuffers2.glIsEnabledIndexedEXT(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetIntegerIndexedvEXT(int paramInt1, int paramInt2, long paramLong) {
/* 1350 */     EXTDrawBuffers2.nglGetIntegerIndexedvEXT(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */   
/*      */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1354 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetIntegerIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1359 */     return EXTDrawBuffers2.glGetIntegerIndexedEXT(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBooleanIndexedvEXT(int paramInt1, int paramInt2, long paramLong) {
/* 1365 */     EXTDrawBuffers2.nglGetBooleanIndexedvEXT(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */   
/*      */   public static void glGetBooleanIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/* 1369 */     EXTDrawBuffers2.glGetBooleanIndexedvEXT(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */   
/*      */   @NativeType("void")
/*      */   public static boolean glGetBooleanIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1374 */     return EXTDrawBuffers2.glGetBooleanIndexedEXT(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramStringEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1382 */     nglNamedProgramStringEXT(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glNamedProgramLocalParameter4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1394 */     if (Checks.CHECKS) {
/* 1395 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1397 */     nglNamedProgramLocalParameter4dvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glNamedProgramLocalParameter4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1409 */     if (Checks.CHECKS) {
/* 1410 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1412 */     nglNamedProgramLocalParameter4fvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterdvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1420 */     if (Checks.CHECKS) {
/* 1421 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1423 */     nglGetNamedProgramLocalParameterdvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1431 */     if (Checks.CHECKS) {
/* 1432 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1434 */     nglGetNamedProgramLocalParameterfvEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1442 */     if (Checks.CHECKS) {
/* 1443 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1445 */     nglGetNamedProgramivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetNamedProgramiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 1450 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1452 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1453 */       nglGetNamedProgramivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1454 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1456 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramStringEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1465 */     if (Checks.CHECKS && 
/* 1466 */       Checks.DEBUG) {
/* 1467 */       Checks.check(paramByteBuffer, glGetNamedProgramiEXT(paramInt1, paramInt2, 34343));
/*      */     }
/*      */     
/* 1470 */     nglGetNamedProgramStringEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("void const *") long paramLong) {
/* 1478 */     nglCompressedTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1482 */     nglCompressedTextureImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 1490 */     nglCompressedTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1494 */     nglCompressedTextureImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/* 1502 */     nglCompressedTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1506 */     nglCompressedTextureImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLsizei") int paramInt11, @NativeType("void const *") long paramLong) {
/* 1514 */     nglCompressedTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1518 */     nglCompressedTextureSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("void const *") long paramLong) {
/* 1526 */     nglCompressedTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1530 */     nglCompressedTextureSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/* 1538 */     nglCompressedTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1542 */     nglCompressedTextureSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1550 */     if (Checks.CHECKS && 
/* 1551 */       Checks.DEBUG) {
/* 1552 */       Checks.check(paramByteBuffer, glGetTextureLevelParameteriEXT(paramInt1, paramInt2, paramInt3, 34464));
/*      */     }
/*      */     
/* 1555 */     nglGetCompressedTextureImageEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetCompressedTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("void *") long paramLong) {
/* 1559 */     nglGetCompressedTextureImageEXT(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("void const *") long paramLong) {
/* 1567 */     nglCompressedMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1571 */     nglCompressedMultiTexImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 1579 */     nglCompressedMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1583 */     nglCompressedMultiTexImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/* 1591 */     nglCompressedMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1595 */     nglCompressedMultiTexImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLsizei") int paramInt11, @NativeType("void const *") long paramLong) {
/* 1603 */     nglCompressedMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1607 */     nglCompressedMultiTexSubImage3DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("void const *") long paramLong) {
/* 1615 */     nglCompressedMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1619 */     nglCompressedMultiTexSubImage2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glCompressedMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/* 1627 */     nglCompressedMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */   
/*      */   public static void glCompressedMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1631 */     nglCompressedMultiTexSubImage1DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetCompressedMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1639 */     if (Checks.CHECKS && 
/* 1640 */       Checks.DEBUG) {
/* 1641 */       Checks.check(paramByteBuffer, glGetMultiTexLevelParameteriEXT(paramInt1, paramInt2, paramInt3, 34464));
/*      */     }
/*      */     
/* 1644 */     nglGetCompressedMultiTexImageEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetCompressedMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("void *") long paramLong) {
/* 1648 */     nglGetCompressedMultiTexImageEXT(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1656 */     if (Checks.CHECKS) {
/* 1657 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 1659 */     nglMatrixLoadTransposefEXT(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1667 */     if (Checks.CHECKS) {
/* 1668 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 1670 */     nglMatrixLoadTransposedEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1678 */     if (Checks.CHECKS) {
/* 1679 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 1681 */     nglMatrixMultTransposefEXT(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1689 */     if (Checks.CHECKS) {
/* 1690 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 1692 */     nglMatrixMultTransposedEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLenum") int paramInt2) {
/* 1700 */     nglNamedBufferDataEXT(paramInt1, paramLong, 0L, paramInt2);
/*      */   }
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2) {
/* 1704 */     nglNamedBufferDataEXT(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*      */   }
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLenum") int paramInt2) {
/* 1708 */     nglNamedBufferDataEXT(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
/*      */   }
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/* 1712 */     nglNamedBufferDataEXT(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*      */   }
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLenum") int paramInt2) {
/* 1716 */     nglNamedBufferDataEXT(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
/*      */   }
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLenum") int paramInt2) {
/* 1720 */     nglNamedBufferDataEXT(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1728 */     nglNamedBufferSubDataEXT(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1732 */     nglNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1736 */     nglNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1740 */     nglNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1744 */     nglNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     long l;
/* 1755 */     return MemoryUtil.memByteBufferSafe(l = nglMapNamedBufferEXT(paramInt1, paramInt2), glGetNamedBufferParameteriEXT(paramInt1, 34660));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, ByteBuffer paramByteBuffer) {
/* 1761 */     long l = nglMapNamedBufferEXT(paramInt1, paramInt2);
/* 1762 */     paramInt1 = glGetNamedBufferParameteriEXT(paramInt1, 34660);
/* 1763 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, paramInt1);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/* 1769 */     long l = nglMapNamedBufferEXT(paramInt1, paramInt2);
/* 1770 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong);
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
/*      */   public static void glGetNamedBufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1783 */     if (Checks.CHECKS) {
/* 1784 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1786 */     nglGetNamedBufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetNamedBufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1791 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1793 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1794 */       nglGetNamedBufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1795 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1797 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1806 */     nglGetNamedBufferSubDataEXT(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 1810 */     nglGetNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 1814 */     nglGetNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 1818 */     nglGetNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 1822 */     nglGetNamedBufferSubDataEXT(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glProgramUniform1fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1862 */     nglProgramUniform1fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1870 */     nglProgramUniform2fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1878 */     nglProgramUniform3fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1886 */     nglProgramUniform4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1894 */     nglProgramUniform1ivEXT(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1902 */     nglProgramUniform2ivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1910 */     nglProgramUniform3ivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1918 */     nglProgramUniform4ivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1926 */     nglProgramUniformMatrix2fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1934 */     nglProgramUniformMatrix3fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1942 */     nglProgramUniformMatrix4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1950 */     nglProgramUniformMatrix2x3fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1958 */     nglProgramUniformMatrix3x2fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1966 */     nglProgramUniformMatrix2x4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1974 */     nglProgramUniformMatrix4x2fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1982 */     nglProgramUniformMatrix3x4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1990 */     nglProgramUniformMatrix4x3fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glTextureParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2006 */     if (Checks.CHECKS) {
/* 2007 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2009 */     nglTextureParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2017 */     if (Checks.CHECKS) {
/* 2018 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2020 */     nglTextureParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2028 */     if (Checks.CHECKS) {
/* 2029 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2031 */     nglGetTextureParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2036 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2038 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2039 */       nglGetTextureParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2040 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2042 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2051 */     if (Checks.CHECKS) {
/* 2052 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2054 */     nglGetTextureParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetTextureParameterIuiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2059 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2061 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2062 */       nglGetTextureParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2063 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2065 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2074 */     if (Checks.CHECKS) {
/* 2075 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2077 */     nglMultiTexParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2085 */     if (Checks.CHECKS) {
/* 2086 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2088 */     nglMultiTexParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2096 */     if (Checks.CHECKS) {
/* 2097 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2099 */     nglGetMultiTexParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameterIiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2104 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2106 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2107 */       nglGetMultiTexParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2108 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2110 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2119 */     if (Checks.CHECKS) {
/* 2120 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2122 */     nglGetMultiTexParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetMultiTexParameterIuiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2127 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2129 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2130 */       nglGetMultiTexParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2131 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2133 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glProgramUniform1uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2158 */     nglProgramUniform1uivEXT(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2166 */     nglProgramUniform2uivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2174 */     nglProgramUniform3uivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2182 */     nglProgramUniform4uivEXT(paramInt1, paramInt2, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameters4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 2190 */     nglNamedProgramLocalParameters4fvEXT(paramInt1, paramInt2, paramInt3, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glNamedProgramLocalParameterI4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2202 */     if (Checks.CHECKS) {
/* 2203 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2205 */     nglNamedProgramLocalParameterI4ivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2213 */     nglNamedProgramLocalParametersI4ivEXT(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glNamedProgramLocalParameterI4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2225 */     if (Checks.CHECKS) {
/* 2226 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2228 */     nglNamedProgramLocalParameterI4uivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 2236 */     nglNamedProgramLocalParametersI4uivEXT(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2244 */     if (Checks.CHECKS) {
/* 2245 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2247 */     nglGetNamedProgramLocalParameterIivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 2255 */     if (Checks.CHECKS) {
/* 2256 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 2258 */     nglGetNamedProgramLocalParameterIuivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetNamedRenderbufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2270 */     if (Checks.CHECKS) {
/* 2271 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2273 */     nglGetNamedRenderbufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetNamedRenderbufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2278 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2280 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2281 */       nglGetNamedRenderbufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2282 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2284 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2322 */     if (Checks.CHECKS) {
/* 2323 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2325 */     nglGetNamedFramebufferAttachmentParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetNamedFramebufferAttachmentParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2330 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2332 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2333 */       nglGetNamedFramebufferAttachmentParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2334 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2336 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glFramebufferDrawBuffersEXT(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 2357 */     nglFramebufferDrawBuffersEXT(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetFramebufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2369 */     if (Checks.CHECKS) {
/* 2370 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2372 */     nglGetFramebufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetFramebufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2377 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2379 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2380 */       nglGetFramebufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2381 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2383 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegervEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2476 */     if (Checks.CHECKS) {
/* 2477 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2479 */     nglGetVertexArrayIntegervEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIntegerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2484 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2486 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2487 */       nglGetVertexArrayIntegervEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2488 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2490 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayPointervEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 2499 */     if (Checks.CHECKS) {
/* 2500 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 2502 */     nglGetVertexArrayPointervEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2507 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2509 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 2510 */       nglGetVertexArrayPointervEXT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 2511 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 2513 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegeri_vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2522 */     if (Checks.CHECKS) {
/* 2523 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2525 */     nglGetVertexArrayIntegeri_vEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static int glGetVertexArrayIntegeriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2530 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2532 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2533 */       nglGetVertexArrayIntegeri_vEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 2534 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2536 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayPointeri_vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 2545 */     if (Checks.CHECKS) {
/* 2546 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 2548 */     nglGetVertexArrayPointeri_vEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */   @NativeType("void")
/*      */   public static long glGetVertexArrayPointeriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*      */     MemoryStack memoryStack;
/* 2553 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2555 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 2556 */       nglGetVertexArrayPointeri_vEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 2557 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 2559 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2) {
/*      */     long l;
/* 2571 */     return MemoryUtil.memByteBufferSafe(l = nglMapNamedBufferRangeEXT(paramInt1, paramLong1, paramLong2, paramInt2), (int)paramLong2);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLbitfield") int paramInt2, ByteBuffer paramByteBuffer) {
/* 2577 */     long l = nglMapNamedBufferRangeEXT(paramInt1, paramLong1, paramLong2, paramInt2);
/* 2578 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2587 */     long l = (GL.getICD()).glMatrixLoadfEXT;
/* 2588 */     if (Checks.CHECKS) {
/* 2589 */       Checks.check(l);
/* 2590 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 2592 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoaddEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2597 */     long l = (GL.getICD()).glMatrixLoaddEXT;
/* 2598 */     if (Checks.CHECKS) {
/* 2599 */       Checks.check(l);
/* 2600 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 2602 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2607 */     long l = (GL.getICD()).glMatrixMultfEXT;
/* 2608 */     if (Checks.CHECKS) {
/* 2609 */       Checks.check(l);
/* 2610 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 2612 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultdEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2617 */     long l = (GL.getICD()).glMatrixMultdEXT;
/* 2618 */     if (Checks.CHECKS) {
/* 2619 */       Checks.check(l);
/* 2620 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 2622 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2627 */     long l = (GL.getICD()).glTextureParameterivEXT;
/* 2628 */     if (Checks.CHECKS) {
/* 2629 */       Checks.check(l);
/* 2630 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2632 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2637 */     long l = (GL.getICD()).glTextureParameterfvEXT;
/* 2638 */     if (Checks.CHECKS) {
/* 2639 */       Checks.check(l);
/* 2640 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2642 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2647 */     long l = (GL.getICD()).glTextureImage1DEXT;
/* 2648 */     if (Checks.CHECKS) {
/* 2649 */       Checks.check(l);
/*      */     }
/* 2651 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 2656 */     long l = (GL.getICD()).glTextureImage1DEXT;
/* 2657 */     if (Checks.CHECKS) {
/* 2658 */       Checks.check(l);
/*      */     }
/* 2660 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2665 */     long l = (GL.getICD()).glTextureImage1DEXT;
/* 2666 */     if (Checks.CHECKS) {
/* 2667 */       Checks.check(l);
/*      */     }
/* 2669 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2674 */     long l = (GL.getICD()).glTextureImage1DEXT;
/* 2675 */     if (Checks.CHECKS) {
/* 2676 */       Checks.check(l);
/*      */     }
/* 2678 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2683 */     long l = (GL.getICD()).glTextureImage2DEXT;
/* 2684 */     if (Checks.CHECKS) {
/* 2685 */       Checks.check(l);
/*      */     }
/* 2687 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") int[] paramArrayOfint) {
/* 2692 */     long l = (GL.getICD()).glTextureImage2DEXT;
/* 2693 */     if (Checks.CHECKS) {
/* 2694 */       Checks.check(l);
/*      */     }
/* 2696 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2701 */     long l = (GL.getICD()).glTextureImage2DEXT;
/* 2702 */     if (Checks.CHECKS) {
/* 2703 */       Checks.check(l);
/*      */     }
/* 2705 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2710 */     long l = (GL.getICD()).glTextureImage2DEXT;
/* 2711 */     if (Checks.CHECKS) {
/* 2712 */       Checks.check(l);
/*      */     }
/* 2714 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2719 */     long l = (GL.getICD()).glTextureSubImage1DEXT;
/* 2720 */     if (Checks.CHECKS) {
/* 2721 */       Checks.check(l);
/*      */     }
/* 2723 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") int[] paramArrayOfint) {
/* 2728 */     long l = (GL.getICD()).glTextureSubImage1DEXT;
/* 2729 */     if (Checks.CHECKS) {
/* 2730 */       Checks.check(l);
/*      */     }
/* 2732 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2737 */     long l = (GL.getICD()).glTextureSubImage1DEXT;
/* 2738 */     if (Checks.CHECKS) {
/* 2739 */       Checks.check(l);
/*      */     }
/* 2741 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2746 */     long l = (GL.getICD()).glTextureSubImage1DEXT;
/* 2747 */     if (Checks.CHECKS) {
/* 2748 */       Checks.check(l);
/*      */     }
/* 2750 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2755 */     long l = (GL.getICD()).glTextureSubImage2DEXT;
/* 2756 */     if (Checks.CHECKS) {
/* 2757 */       Checks.check(l);
/*      */     }
/* 2759 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") int[] paramArrayOfint) {
/* 2764 */     long l = (GL.getICD()).glTextureSubImage2DEXT;
/* 2765 */     if (Checks.CHECKS) {
/* 2766 */       Checks.check(l);
/*      */     }
/* 2768 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2773 */     long l = (GL.getICD()).glTextureSubImage2DEXT;
/* 2774 */     if (Checks.CHECKS) {
/* 2775 */       Checks.check(l);
/*      */     }
/* 2777 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2782 */     long l = (GL.getICD()).glTextureSubImage2DEXT;
/* 2783 */     if (Checks.CHECKS) {
/* 2784 */       Checks.check(l);
/*      */     }
/* 2786 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") short[] paramArrayOfshort) {
/* 2791 */     long l = (GL.getICD()).glGetTextureImageEXT;
/* 2792 */     if (Checks.CHECKS) {
/* 2793 */       Checks.check(l);
/*      */     }
/* 2795 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") int[] paramArrayOfint) {
/* 2800 */     long l = (GL.getICD()).glGetTextureImageEXT;
/* 2801 */     if (Checks.CHECKS) {
/* 2802 */       Checks.check(l);
/*      */     }
/* 2804 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") float[] paramArrayOffloat) {
/* 2809 */     long l = (GL.getICD()).glGetTextureImageEXT;
/* 2810 */     if (Checks.CHECKS) {
/* 2811 */       Checks.check(l);
/*      */     }
/* 2813 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureImageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") double[] paramArrayOfdouble) {
/* 2818 */     long l = (GL.getICD()).glGetTextureImageEXT;
/* 2819 */     if (Checks.CHECKS) {
/* 2820 */       Checks.check(l);
/*      */     }
/* 2822 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2827 */     long l = (GL.getICD()).glGetTextureParameterfvEXT;
/* 2828 */     if (Checks.CHECKS) {
/* 2829 */       Checks.check(l);
/* 2830 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2832 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2837 */     long l = (GL.getICD()).glGetTextureParameterivEXT;
/* 2838 */     if (Checks.CHECKS) {
/* 2839 */       Checks.check(l);
/* 2840 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2842 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2847 */     long l = (GL.getICD()).glGetTextureLevelParameterfvEXT;
/* 2848 */     if (Checks.CHECKS) {
/* 2849 */       Checks.check(l);
/* 2850 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2852 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureLevelParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2857 */     long l = (GL.getICD()).glGetTextureLevelParameterivEXT;
/* 2858 */     if (Checks.CHECKS) {
/* 2859 */       Checks.check(l);
/* 2860 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2862 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2867 */     long l = (GL.getICD()).glTextureImage3DEXT;
/* 2868 */     if (Checks.CHECKS) {
/* 2869 */       Checks.check(l);
/*      */     }
/* 2871 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 2876 */     long l = (GL.getICD()).glTextureImage3DEXT;
/* 2877 */     if (Checks.CHECKS) {
/* 2878 */       Checks.check(l);
/*      */     }
/* 2880 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2885 */     long l = (GL.getICD()).glTextureImage3DEXT;
/* 2886 */     if (Checks.CHECKS) {
/* 2887 */       Checks.check(l);
/*      */     }
/* 2889 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2894 */     long l = (GL.getICD()).glTextureImage3DEXT;
/* 2895 */     if (Checks.CHECKS) {
/* 2896 */       Checks.check(l);
/*      */     }
/* 2898 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2903 */     long l = (GL.getICD()).glTextureSubImage3DEXT;
/* 2904 */     if (Checks.CHECKS) {
/* 2905 */       Checks.check(l);
/*      */     }
/* 2907 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") int[] paramArrayOfint) {
/* 2912 */     long l = (GL.getICD()).glTextureSubImage3DEXT;
/* 2913 */     if (Checks.CHECKS) {
/* 2914 */       Checks.check(l);
/*      */     }
/* 2916 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2921 */     long l = (GL.getICD()).glTextureSubImage3DEXT;
/* 2922 */     if (Checks.CHECKS) {
/* 2923 */       Checks.check(l);
/*      */     }
/* 2925 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 2930 */     long l = (GL.getICD()).glTextureSubImage3DEXT;
/* 2931 */     if (Checks.CHECKS) {
/* 2932 */       Checks.check(l);
/*      */     }
/* 2934 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 2939 */     long l = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 2940 */     if (Checks.CHECKS) {
/* 2941 */       Checks.check(l);
/*      */     }
/* 2943 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 2948 */     long l = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 2949 */     if (Checks.CHECKS) {
/* 2950 */       Checks.check(l);
/*      */     }
/* 2952 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoordPointerEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 2957 */     long l = (GL.getICD()).glMultiTexCoordPointerEXT;
/* 2958 */     if (Checks.CHECKS) {
/* 2959 */       Checks.check(l);
/*      */     }
/* 2961 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2966 */     long l = (GL.getICD()).glMultiTexEnvfvEXT;
/* 2967 */     if (Checks.CHECKS) {
/* 2968 */       Checks.check(l);
/* 2969 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2971 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexEnvivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2976 */     long l = (GL.getICD()).glMultiTexEnvivEXT;
/* 2977 */     if (Checks.CHECKS) {
/* 2978 */       Checks.check(l);
/* 2979 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2981 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGendvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2986 */     long l = (GL.getICD()).glMultiTexGendvEXT;
/* 2987 */     if (Checks.CHECKS) {
/* 2988 */       Checks.check(l);
/* 2989 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 2991 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2996 */     long l = (GL.getICD()).glMultiTexGenfvEXT;
/* 2997 */     if (Checks.CHECKS) {
/* 2998 */       Checks.check(l);
/* 2999 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 3001 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexGenivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3006 */     long l = (GL.getICD()).glMultiTexGenivEXT;
/* 3007 */     if (Checks.CHECKS) {
/* 3008 */       Checks.check(l);
/* 3009 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3011 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3016 */     long l = (GL.getICD()).glGetMultiTexEnvfvEXT;
/* 3017 */     if (Checks.CHECKS) {
/* 3018 */       Checks.check(l);
/* 3019 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3021 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexEnvivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3026 */     long l = (GL.getICD()).glGetMultiTexEnvivEXT;
/* 3027 */     if (Checks.CHECKS) {
/* 3028 */       Checks.check(l);
/* 3029 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3031 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGendvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 3036 */     long l = (GL.getICD()).glGetMultiTexGendvEXT;
/* 3037 */     if (Checks.CHECKS) {
/* 3038 */       Checks.check(l);
/* 3039 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 3041 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3046 */     long l = (GL.getICD()).glGetMultiTexGenfvEXT;
/* 3047 */     if (Checks.CHECKS) {
/* 3048 */       Checks.check(l);
/* 3049 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3051 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexGenivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3056 */     long l = (GL.getICD()).glGetMultiTexGenivEXT;
/* 3057 */     if (Checks.CHECKS) {
/* 3058 */       Checks.check(l);
/* 3059 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3061 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3066 */     long l = (GL.getICD()).glMultiTexParameterivEXT;
/* 3067 */     if (Checks.CHECKS) {
/* 3068 */       Checks.check(l);
/* 3069 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3071 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3076 */     long l = (GL.getICD()).glMultiTexParameterfvEXT;
/* 3077 */     if (Checks.CHECKS) {
/* 3078 */       Checks.check(l);
/* 3079 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 3081 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3086 */     long l = (GL.getICD()).glMultiTexImage1DEXT;
/* 3087 */     if (Checks.CHECKS) {
/* 3088 */       Checks.check(l);
/*      */     }
/* 3090 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") int[] paramArrayOfint) {
/* 3095 */     long l = (GL.getICD()).glMultiTexImage1DEXT;
/* 3096 */     if (Checks.CHECKS) {
/* 3097 */       Checks.check(l);
/*      */     }
/* 3099 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3104 */     long l = (GL.getICD()).glMultiTexImage1DEXT;
/* 3105 */     if (Checks.CHECKS) {
/* 3106 */       Checks.check(l);
/*      */     }
/* 3108 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3113 */     long l = (GL.getICD()).glMultiTexImage1DEXT;
/* 3114 */     if (Checks.CHECKS) {
/* 3115 */       Checks.check(l);
/*      */     }
/* 3117 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3122 */     long l = (GL.getICD()).glMultiTexImage2DEXT;
/* 3123 */     if (Checks.CHECKS) {
/* 3124 */       Checks.check(l);
/*      */     }
/* 3126 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") int[] paramArrayOfint) {
/* 3131 */     long l = (GL.getICD()).glMultiTexImage2DEXT;
/* 3132 */     if (Checks.CHECKS) {
/* 3133 */       Checks.check(l);
/*      */     }
/* 3135 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3140 */     long l = (GL.getICD()).glMultiTexImage2DEXT;
/* 3141 */     if (Checks.CHECKS) {
/* 3142 */       Checks.check(l);
/*      */     }
/* 3144 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3149 */     long l = (GL.getICD()).glMultiTexImage2DEXT;
/* 3150 */     if (Checks.CHECKS) {
/* 3151 */       Checks.check(l);
/*      */     }
/* 3153 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3158 */     long l = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3159 */     if (Checks.CHECKS) {
/* 3160 */       Checks.check(l);
/*      */     }
/* 3162 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") int[] paramArrayOfint) {
/* 3167 */     long l = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3168 */     if (Checks.CHECKS) {
/* 3169 */       Checks.check(l);
/*      */     }
/* 3171 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3176 */     long l = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3177 */     if (Checks.CHECKS) {
/* 3178 */       Checks.check(l);
/*      */     }
/* 3180 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3185 */     long l = (GL.getICD()).glMultiTexSubImage1DEXT;
/* 3186 */     if (Checks.CHECKS) {
/* 3187 */       Checks.check(l);
/*      */     }
/* 3189 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3194 */     long l = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3195 */     if (Checks.CHECKS) {
/* 3196 */       Checks.check(l);
/*      */     }
/* 3198 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") int[] paramArrayOfint) {
/* 3203 */     long l = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3204 */     if (Checks.CHECKS) {
/* 3205 */       Checks.check(l);
/*      */     }
/* 3207 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3212 */     long l = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3213 */     if (Checks.CHECKS) {
/* 3214 */       Checks.check(l);
/*      */     }
/* 3216 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3221 */     long l = (GL.getICD()).glMultiTexSubImage2DEXT;
/* 3222 */     if (Checks.CHECKS) {
/* 3223 */       Checks.check(l);
/*      */     }
/* 3225 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") short[] paramArrayOfshort) {
/* 3230 */     long l = (GL.getICD()).glGetMultiTexImageEXT;
/* 3231 */     if (Checks.CHECKS) {
/* 3232 */       Checks.check(l);
/*      */     }
/* 3234 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") int[] paramArrayOfint) {
/* 3239 */     long l = (GL.getICD()).glGetMultiTexImageEXT;
/* 3240 */     if (Checks.CHECKS) {
/* 3241 */       Checks.check(l);
/*      */     }
/* 3243 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") float[] paramArrayOffloat) {
/* 3248 */     long l = (GL.getICD()).glGetMultiTexImageEXT;
/* 3249 */     if (Checks.CHECKS) {
/* 3250 */       Checks.check(l);
/*      */     }
/* 3252 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexImageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void *") double[] paramArrayOfdouble) {
/* 3257 */     long l = (GL.getICD()).glGetMultiTexImageEXT;
/* 3258 */     if (Checks.CHECKS) {
/* 3259 */       Checks.check(l);
/*      */     }
/* 3261 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3266 */     long l = (GL.getICD()).glGetMultiTexParameterfvEXT;
/* 3267 */     if (Checks.CHECKS) {
/* 3268 */       Checks.check(l);
/* 3269 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3271 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3276 */     long l = (GL.getICD()).glGetMultiTexParameterivEXT;
/* 3277 */     if (Checks.CHECKS) {
/* 3278 */       Checks.check(l);
/* 3279 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3281 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterfvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3286 */     long l = (GL.getICD()).glGetMultiTexLevelParameterfvEXT;
/* 3287 */     if (Checks.CHECKS) {
/* 3288 */       Checks.check(l);
/* 3289 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3291 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexLevelParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3296 */     long l = (GL.getICD()).glGetMultiTexLevelParameterivEXT;
/* 3297 */     if (Checks.CHECKS) {
/* 3298 */       Checks.check(l);
/* 3299 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3301 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3306 */     long l = (GL.getICD()).glMultiTexImage3DEXT;
/* 3307 */     if (Checks.CHECKS) {
/* 3308 */       Checks.check(l);
/*      */     }
/* 3310 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") int[] paramArrayOfint) {
/* 3315 */     long l = (GL.getICD()).glMultiTexImage3DEXT;
/* 3316 */     if (Checks.CHECKS) {
/* 3317 */       Checks.check(l);
/*      */     }
/* 3319 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3324 */     long l = (GL.getICD()).glMultiTexImage3DEXT;
/* 3325 */     if (Checks.CHECKS) {
/* 3326 */       Checks.check(l);
/*      */     }
/* 3328 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3333 */     long l = (GL.getICD()).glMultiTexImage3DEXT;
/* 3334 */     if (Checks.CHECKS) {
/* 3335 */       Checks.check(l);
/*      */     }
/* 3337 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3342 */     long l = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3343 */     if (Checks.CHECKS) {
/* 3344 */       Checks.check(l);
/*      */     }
/* 3346 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") int[] paramArrayOfint) {
/* 3351 */     long l = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3352 */     if (Checks.CHECKS) {
/* 3353 */       Checks.check(l);
/*      */     }
/* 3355 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3360 */     long l = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3361 */     if (Checks.CHECKS) {
/* 3362 */       Checks.check(l);
/*      */     }
/* 3364 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLenum") int paramInt11, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3369 */     long l = (GL.getICD()).glMultiTexSubImage3DEXT;
/* 3370 */     if (Checks.CHECKS) {
/* 3371 */       Checks.check(l);
/*      */     }
/* 3373 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloatIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3378 */     long l = (GL.getICD()).glGetFloatIndexedvEXT;
/* 3379 */     if (Checks.CHECKS) {
/* 3380 */       Checks.check(l);
/* 3381 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3383 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoubleIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 3388 */     long l = (GL.getICD()).glGetDoubleIndexedvEXT;
/* 3389 */     if (Checks.CHECKS) {
/* 3390 */       Checks.check(l);
/* 3391 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 3393 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFloati_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3398 */     long l = (GL.getICD()).glGetFloati_vEXT;
/* 3399 */     if (Checks.CHECKS) {
/* 3400 */       Checks.check(l);
/* 3401 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 3403 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 3408 */     long l = (GL.getICD()).glGetDoublei_vEXT;
/* 3409 */     if (Checks.CHECKS) {
/* 3410 */       Checks.check(l);
/* 3411 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 3413 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3418 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 3423 */     long l = (GL.getICD()).glNamedProgramLocalParameter4dvEXT;
/* 3424 */     if (Checks.CHECKS) {
/* 3425 */       Checks.check(l);
/* 3426 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 3428 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameter4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3433 */     long l = (GL.getICD()).glNamedProgramLocalParameter4fvEXT;
/* 3434 */     if (Checks.CHECKS) {
/* 3435 */       Checks.check(l);
/* 3436 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 3438 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterdvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 3443 */     long l = (GL.getICD()).glGetNamedProgramLocalParameterdvEXT;
/* 3444 */     if (Checks.CHECKS) {
/* 3445 */       Checks.check(l);
/* 3446 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 3448 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterfvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 3453 */     long l = (GL.getICD()).glGetNamedProgramLocalParameterfvEXT;
/* 3454 */     if (Checks.CHECKS) {
/* 3455 */       Checks.check(l);
/* 3456 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 3458 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3463 */     long l = (GL.getICD()).glGetNamedProgramivEXT;
/* 3464 */     if (Checks.CHECKS) {
/* 3465 */       Checks.check(l);
/* 3466 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3468 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3473 */     long l = (GL.getICD()).glMatrixLoadTransposefEXT;
/* 3474 */     if (Checks.CHECKS) {
/* 3475 */       Checks.check(l);
/* 3476 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 3478 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixLoadTransposedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 3483 */     long l = (GL.getICD()).glMatrixLoadTransposedEXT;
/* 3484 */     if (Checks.CHECKS) {
/* 3485 */       Checks.check(l);
/* 3486 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 3488 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3493 */     long l = (GL.getICD()).glMatrixMultTransposefEXT;
/* 3494 */     if (Checks.CHECKS) {
/* 3495 */       Checks.check(l);
/* 3496 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 3498 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMatrixMultTransposedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 3503 */     long l = (GL.getICD()).glMatrixMultTransposedEXT;
/* 3504 */     if (Checks.CHECKS) {
/* 3505 */       Checks.check(l);
/* 3506 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 3508 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 3513 */     long l = (GL.getICD()).glNamedBufferDataEXT;
/* 3514 */     if (Checks.CHECKS) {
/* 3515 */       Checks.check(l);
/*      */     }
/* 3517 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 3522 */     long l = (GL.getICD()).glNamedBufferDataEXT;
/* 3523 */     if (Checks.CHECKS) {
/* 3524 */       Checks.check(l);
/*      */     }
/* 3526 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 3531 */     long l = (GL.getICD()).glNamedBufferDataEXT;
/* 3532 */     if (Checks.CHECKS) {
/* 3533 */       Checks.check(l);
/*      */     }
/* 3535 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 3540 */     long l = (GL.getICD()).glNamedBufferDataEXT;
/* 3541 */     if (Checks.CHECKS) {
/* 3542 */       Checks.check(l);
/*      */     }
/* 3544 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 3549 */     long l = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3550 */     if (Checks.CHECKS) {
/* 3551 */       Checks.check(l);
/*      */     }
/* 3553 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 3558 */     long l = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3559 */     if (Checks.CHECKS) {
/* 3560 */       Checks.check(l);
/*      */     }
/* 3562 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 3567 */     long l = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3568 */     if (Checks.CHECKS) {
/* 3569 */       Checks.check(l);
/*      */     }
/* 3571 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 3576 */     long l = (GL.getICD()).glNamedBufferSubDataEXT;
/* 3577 */     if (Checks.CHECKS) {
/* 3578 */       Checks.check(l);
/*      */     }
/* 3580 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3585 */     long l = (GL.getICD()).glGetNamedBufferParameterivEXT;
/* 3586 */     if (Checks.CHECKS) {
/* 3587 */       Checks.check(l);
/* 3588 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3590 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 3595 */     long l = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3596 */     if (Checks.CHECKS) {
/* 3597 */       Checks.check(l);
/*      */     }
/* 3599 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 3604 */     long l = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3605 */     if (Checks.CHECKS) {
/* 3606 */       Checks.check(l);
/*      */     }
/* 3608 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 3613 */     long l = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3614 */     if (Checks.CHECKS) {
/* 3615 */       Checks.check(l);
/*      */     }
/* 3617 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedBufferSubDataEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 3622 */     long l = (GL.getICD()).glGetNamedBufferSubDataEXT;
/* 3623 */     if (Checks.CHECKS) {
/* 3624 */       Checks.check(l);
/*      */     }
/* 3626 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3631 */     long l = (GL.getICD()).glProgramUniform1fvEXT;
/* 3632 */     if (Checks.CHECKS) {
/* 3633 */       Checks.check(l);
/*      */     }
/* 3635 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3640 */     long l = (GL.getICD()).glProgramUniform2fvEXT;
/* 3641 */     if (Checks.CHECKS) {
/* 3642 */       Checks.check(l);
/*      */     }
/* 3644 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3649 */     long l = (GL.getICD()).glProgramUniform3fvEXT;
/* 3650 */     if (Checks.CHECKS) {
/* 3651 */       Checks.check(l);
/*      */     }
/* 3653 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3658 */     long l = (GL.getICD()).glProgramUniform4fvEXT;
/* 3659 */     if (Checks.CHECKS) {
/* 3660 */       Checks.check(l);
/*      */     }
/* 3662 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3667 */     long l = (GL.getICD()).glProgramUniform1ivEXT;
/* 3668 */     if (Checks.CHECKS) {
/* 3669 */       Checks.check(l);
/*      */     }
/* 3671 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3676 */     long l = (GL.getICD()).glProgramUniform2ivEXT;
/* 3677 */     if (Checks.CHECKS) {
/* 3678 */       Checks.check(l);
/*      */     }
/* 3680 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3685 */     long l = (GL.getICD()).glProgramUniform3ivEXT;
/* 3686 */     if (Checks.CHECKS) {
/* 3687 */       Checks.check(l);
/*      */     }
/* 3689 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3694 */     long l = (GL.getICD()).glProgramUniform4ivEXT;
/* 3695 */     if (Checks.CHECKS) {
/* 3696 */       Checks.check(l);
/*      */     }
/* 3698 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3703 */     long l = (GL.getICD()).glProgramUniformMatrix2fvEXT;
/* 3704 */     if (Checks.CHECKS) {
/* 3705 */       Checks.check(l);
/*      */     }
/* 3707 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3712 */     long l = (GL.getICD()).glProgramUniformMatrix3fvEXT;
/* 3713 */     if (Checks.CHECKS) {
/* 3714 */       Checks.check(l);
/*      */     }
/* 3716 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 9, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3721 */     long l = (GL.getICD()).glProgramUniformMatrix4fvEXT;
/* 3722 */     if (Checks.CHECKS) {
/* 3723 */       Checks.check(l);
/*      */     }
/* 3725 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 4, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3730 */     long l = (GL.getICD()).glProgramUniformMatrix2x3fvEXT;
/* 3731 */     if (Checks.CHECKS) {
/* 3732 */       Checks.check(l);
/*      */     }
/* 3734 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3739 */     long l = (GL.getICD()).glProgramUniformMatrix3x2fvEXT;
/* 3740 */     if (Checks.CHECKS) {
/* 3741 */       Checks.check(l);
/*      */     }
/* 3743 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3748 */     long l = (GL.getICD()).glProgramUniformMatrix2x4fvEXT;
/* 3749 */     if (Checks.CHECKS) {
/* 3750 */       Checks.check(l);
/*      */     }
/* 3752 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3757 */     long l = (GL.getICD()).glProgramUniformMatrix4x2fvEXT;
/* 3758 */     if (Checks.CHECKS) {
/* 3759 */       Checks.check(l);
/*      */     }
/* 3761 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3766 */     long l = (GL.getICD()).glProgramUniformMatrix3x4fvEXT;
/* 3767 */     if (Checks.CHECKS) {
/* 3768 */       Checks.check(l);
/*      */     }
/* 3770 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3775 */     long l = (GL.getICD()).glProgramUniformMatrix4x3fvEXT;
/* 3776 */     if (Checks.CHECKS) {
/* 3777 */       Checks.check(l);
/*      */     }
/* 3779 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3784 */     long l = (GL.getICD()).glTextureParameterIivEXT;
/* 3785 */     if (Checks.CHECKS) {
/* 3786 */       Checks.check(l);
/* 3787 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3789 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glTextureParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3794 */     long l = (GL.getICD()).glTextureParameterIuivEXT;
/* 3795 */     if (Checks.CHECKS) {
/* 3796 */       Checks.check(l);
/* 3797 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3799 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3804 */     long l = (GL.getICD()).glGetTextureParameterIivEXT;
/* 3805 */     if (Checks.CHECKS) {
/* 3806 */       Checks.check(l);
/* 3807 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3809 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetTextureParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3814 */     long l = (GL.getICD()).glGetTextureParameterIuivEXT;
/* 3815 */     if (Checks.CHECKS) {
/* 3816 */       Checks.check(l);
/* 3817 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3819 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3824 */     long l = (GL.getICD()).glMultiTexParameterIivEXT;
/* 3825 */     if (Checks.CHECKS) {
/* 3826 */       Checks.check(l);
/* 3827 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3829 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glMultiTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3834 */     long l = (GL.getICD()).glMultiTexParameterIuivEXT;
/* 3835 */     if (Checks.CHECKS) {
/* 3836 */       Checks.check(l);
/* 3837 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3839 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3844 */     long l = (GL.getICD()).glGetMultiTexParameterIivEXT;
/* 3845 */     if (Checks.CHECKS) {
/* 3846 */       Checks.check(l);
/* 3847 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3849 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMultiTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3854 */     long l = (GL.getICD()).glGetMultiTexParameterIuivEXT;
/* 3855 */     if (Checks.CHECKS) {
/* 3856 */       Checks.check(l);
/* 3857 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3859 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3864 */     long l = (GL.getICD()).glProgramUniform1uivEXT;
/* 3865 */     if (Checks.CHECKS) {
/* 3866 */       Checks.check(l);
/*      */     }
/* 3868 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3873 */     long l = (GL.getICD()).glProgramUniform2uivEXT;
/* 3874 */     if (Checks.CHECKS) {
/* 3875 */       Checks.check(l);
/*      */     }
/* 3877 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3882 */     long l = (GL.getICD()).glProgramUniform3uivEXT;
/* 3883 */     if (Checks.CHECKS) {
/* 3884 */       Checks.check(l);
/*      */     }
/* 3886 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3891 */     long l = (GL.getICD()).glProgramUniform4uivEXT;
/* 3892 */     if (Checks.CHECKS) {
/* 3893 */       Checks.check(l);
/*      */     }
/* 3895 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameters4fvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 3900 */     long l = (GL.getICD()).glNamedProgramLocalParameters4fvEXT;
/* 3901 */     if (Checks.CHECKS) {
/* 3902 */       Checks.check(l);
/*      */     }
/* 3904 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3909 */     long l = (GL.getICD()).glNamedProgramLocalParameterI4ivEXT;
/* 3910 */     if (Checks.CHECKS) {
/* 3911 */       Checks.check(l);
/* 3912 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3914 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4ivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 3919 */     long l = (GL.getICD()).glNamedProgramLocalParametersI4ivEXT;
/* 3920 */     if (Checks.CHECKS) {
/* 3921 */       Checks.check(l);
/*      */     }
/* 3923 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParameterI4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3928 */     long l = (GL.getICD()).glNamedProgramLocalParameterI4uivEXT;
/* 3929 */     if (Checks.CHECKS) {
/* 3930 */       Checks.check(l);
/* 3931 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3933 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glNamedProgramLocalParametersI4uivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 3938 */     long l = (GL.getICD()).glNamedProgramLocalParametersI4uivEXT;
/* 3939 */     if (Checks.CHECKS) {
/* 3940 */       Checks.check(l);
/*      */     }
/* 3942 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3947 */     long l = (GL.getICD()).glGetNamedProgramLocalParameterIivEXT;
/* 3948 */     if (Checks.CHECKS) {
/* 3949 */       Checks.check(l);
/* 3950 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3952 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 3957 */     long l = (GL.getICD()).glGetNamedProgramLocalParameterIuivEXT;
/* 3958 */     if (Checks.CHECKS) {
/* 3959 */       Checks.check(l);
/* 3960 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 3962 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedRenderbufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3967 */     long l = (GL.getICD()).glGetNamedRenderbufferParameterivEXT;
/* 3968 */     if (Checks.CHECKS) {
/* 3969 */       Checks.check(l);
/* 3970 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3972 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3977 */     long l = (GL.getICD()).glGetNamedFramebufferAttachmentParameterivEXT;
/* 3978 */     if (Checks.CHECKS) {
/* 3979 */       Checks.check(l);
/* 3980 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 3982 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glFramebufferDrawBuffersEXT(@NativeType("GLuint") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 3987 */     long l = (GL.getICD()).glFramebufferDrawBuffersEXT;
/* 3988 */     if (Checks.CHECKS) {
/* 3989 */       Checks.check(l);
/*      */     }
/* 3991 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetFramebufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 3996 */     long l = (GL.getICD()).glGetFramebufferParameterivEXT;
/* 3997 */     if (Checks.CHECKS) {
/* 3998 */       Checks.check(l);
/* 3999 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4001 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegervEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4006 */     long l = (GL.getICD()).glGetVertexArrayIntegervEXT;
/* 4007 */     if (Checks.CHECKS) {
/* 4008 */       Checks.check(l);
/* 4009 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4011 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexArrayIntegeri_vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 4016 */     long l = (GL.getICD()).glGetVertexArrayIntegeri_vEXT;
/* 4017 */     if (Checks.CHECKS) {
/* 4018 */       Checks.check(l);
/* 4019 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 4021 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native void glClientAttribDefaultEXT(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void glPushClientAttribDefaultEXT(@NativeType("GLbitfield") int paramInt);
/*      */   
/*      */   public static native void nglMatrixLoadfEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoaddEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultfEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultdEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMatrixLoadIdentityEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glMatrixRotatefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glMatrixRotatedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glMatrixScalefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glMatrixScaledEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glMatrixTranslatefEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glMatrixTranslatedEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glMatrixOrthoEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glMatrixFrustumEXT(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4, @NativeType("GLdouble") double paramDouble5, @NativeType("GLdouble") double paramDouble6);
/*      */   
/*      */   public static native void glMatrixPushEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glMatrixPopEXT(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glTextureParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglTextureParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glTextureParameterfEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglTextureParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyTextureImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLint") int paramInt9);
/*      */   
/*      */   public static native void glCopyTextureSubImage1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*      */   
/*      */   public static native void glCopyTextureSubImage2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void nglGetTextureImageEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureLevelParameterivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglTextureImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglTextureSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void glCopyTextureSubImage3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLsizei") int paramInt10);
/*      */   
/*      */   public static native void glBindMultiTextureEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglMultiTexCoordPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glMultiTexEnvfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexEnvfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexEnviEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexEnvivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGendEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglMultiTexGendvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGenfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexGenfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexGeniEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexGenivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexEnvfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexEnvivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGendvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGenfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexGenivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void nglMultiTexParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glMultiTexParameterfEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglMultiTexParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void glCopyMultiTexImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLint") int paramInt8);
/*      */   
/*      */   public static native void glCopyMultiTexImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLint") int paramInt9);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9);
/*      */   
/*      */   public static native void nglGetMultiTexImageEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexLevelParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexLevelParameterivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void glCopyMultiTexSubImage3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLsizei") int paramInt10);
/*      */   
/*      */   public static native void glEnableClientStateIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientStateIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glEnableClientStateiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableClientStateiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetFloatIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoubleIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPointerIndexedvEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetFloati_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublei_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetPointeri_vEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramStringEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameter4dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameter4dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameter4fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameter4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterdvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterfvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramStringEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedTextureSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedTextureImageEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage3DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage2DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*      */   
/*      */   public static native void nglCompressedMultiTexSubImage1DEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetCompressedMultiTexImageEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTransposefEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixLoadTransposedEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTransposefEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMatrixMultTransposedEXT(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglNamedBufferDataEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglNamedBufferSubDataEXT(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nglMapNamedBufferEXT(int paramInt1, int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glUnmapNamedBufferEXT(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetNamedBufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedBufferSubDataEXT(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glProgramUniform1fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glProgramUniform2fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glProgramUniform3fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glProgramUniform4fEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glProgramUniform1iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void nglProgramUniform1fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3fvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void glTextureBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glMultiTexBufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglTextureParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglTextureParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetTextureParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMultiTexParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glProgramUniform1uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6);
/*      */   
/*      */   public static native void nglProgramUniform1uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameterI4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameterI4ivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParametersI4ivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glNamedProgramLocalParameterI4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7);
/*      */   
/*      */   public static native void nglNamedProgramLocalParameterI4uivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglNamedProgramLocalParametersI4uivEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterIivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetNamedProgramLocalParameterIuivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*      */   
/*      */   public static native void nglGetNamedRenderbufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void glNamedRenderbufferStorageMultisampleCoverageEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glCheckNamedFramebufferStatusEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glNamedFramebufferTexture1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTexture2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTexture3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glNamedFramebufferRenderbufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void nglGetNamedFramebufferAttachmentParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glGenerateTextureMipmapEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glGenerateMultiTexMipmapEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glFramebufferDrawBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglFramebufferDrawBuffersEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glFramebufferReadBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglGetFramebufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glNamedCopyBufferSubDataEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*      */   
/*      */   public static native void glNamedFramebufferTextureEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glNamedFramebufferTextureLayerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glNamedFramebufferTextureFaceEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5);
/*      */   
/*      */   public static native void glTextureRenderbufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexArrayVertexOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayColorOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayEdgeFlagOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayIndexOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayNormalOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayTexCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayMultiTexCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayFogCoordOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArraySecondaryColorOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayVertexAttribOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glVertexArrayVertexAttribIOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*      */   
/*      */   public static native void glEnableVertexArrayEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glDisableVertexArrayEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glEnableVertexArrayAttribEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDisableVertexArrayAttribEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetVertexArrayIntegervEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayPointervEXT(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayIntegeri_vEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexArrayPointeri_vEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native long nglMapNamedBufferRangeEXT(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void glFlushMappedNamedBufferRangeEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDirectStateAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */