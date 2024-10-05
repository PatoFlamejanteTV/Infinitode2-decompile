/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import org.lwjgl.system.Checks;
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
/*      */ public class GL33C
/*      */   extends GL32C
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
/*   39 */     GL.initialize();
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
/*      */   protected GL33C() {
/*   94 */     throw new UnsupportedOperationException();
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
/*      */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  113 */     if (Checks.CHECKS) {
/*  114 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  116 */     nglBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  130 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  132 */       memoryStack.nASCII(paramCharSequence, true);
/*  133 */       long l = memoryStack.getPointerAddress();
/*  134 */       nglBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, l); return;
/*      */     } finally {
/*  136 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetFragDataIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  155 */     if (Checks.CHECKS) {
/*  156 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  158 */     return nglGetFragDataIndex(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  171 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  173 */       memoryStack.nASCII(paramCharSequence, true);
/*  174 */       long l = memoryStack.getPointerAddress();
/*  175 */       paramInt = nglGetFragDataIndex(paramInt, l); return paramInt;
/*      */     } finally {
/*  177 */       memoryStack.setPointer(i);
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
/*      */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  198 */     nglGenSamplers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenSamplers() {
/*      */     MemoryStack memoryStack;
/*  208 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  210 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  211 */       nglGenSamplers(1, MemoryUtil.memAddress(intBuffer));
/*  212 */       return intBuffer.get(0);
/*      */     } finally {
/*  214 */       memoryStack.setPointer(i);
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
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  235 */     nglDeleteSamplers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  244 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  246 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  247 */       nglDeleteSamplers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  249 */       memoryStack.setPointer(i);
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
/*      */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  318 */     if (Checks.CHECKS) {
/*  319 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  321 */     nglSamplerParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  339 */     if (Checks.CHECKS) {
/*  340 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  342 */     nglSamplerParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  360 */     if (Checks.CHECKS) {
/*  361 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  363 */     nglSamplerParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  381 */     if (Checks.CHECKS) {
/*  382 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  384 */     nglSamplerParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  402 */     if (Checks.CHECKS) {
/*  403 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  405 */     nglGetSamplerParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  418 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  420 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  421 */       nglGetSamplerParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  422 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  424 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  443 */     if (Checks.CHECKS) {
/*  444 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  446 */     nglGetSamplerParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  459 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  461 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  462 */       nglGetSamplerParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  463 */       return floatBuffer.get(0);
/*      */     } finally {
/*  465 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  484 */     if (Checks.CHECKS) {
/*  485 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  487 */     nglGetSamplerParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  500 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  502 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  503 */       nglGetSamplerParameterIiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  504 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  506 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  525 */     if (Checks.CHECKS) {
/*  526 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  528 */     nglGetSamplerParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  541 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  543 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  544 */       nglGetSamplerParameterIuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  545 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  547 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  578 */     if (Checks.CHECKS) {
/*  579 */       Checks.check(paramLongBuffer, 1);
/*      */     }
/*  581 */     nglGetQueryObjecti64v(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
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
/*  594 */     nglGetQueryObjecti64v(paramInt1, paramInt2, paramLong);
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  607 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  609 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/*  610 */       nglGetQueryObjecti64v(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/*  611 */       return longBuffer.get(0);
/*      */     } finally {
/*  613 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/*  632 */     if (Checks.CHECKS) {
/*  633 */       Checks.check(paramLongBuffer, 1);
/*      */     }
/*  635 */     nglGetQueryObjectui64v(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
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
/*  648 */     nglGetQueryObjectui64v(paramInt1, paramInt2, paramLong);
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  661 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  663 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/*  664 */       nglGetQueryObjectui64v(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/*  665 */       return longBuffer.get(0);
/*      */     } finally {
/*  667 */       memoryStack.setPointer(i);
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
/*      */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  755 */     if (Checks.CHECKS) {
/*  756 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  758 */     nglVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  777 */     if (Checks.CHECKS) {
/*  778 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  780 */     nglVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  799 */     if (Checks.CHECKS) {
/*  800 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  802 */     nglVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  821 */     if (Checks.CHECKS) {
/*  822 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  824 */     nglVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenSamplers(@NativeType("GLuint *") int[] paramArrayOfint) {
/*  833 */     long l = (GL.getICD()).glGenSamplers;
/*  834 */     if (Checks.CHECKS) {
/*  835 */       Checks.check(l);
/*      */     }
/*  837 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/*  846 */     long l = (GL.getICD()).glDeleteSamplers;
/*  847 */     if (Checks.CHECKS) {
/*  848 */       Checks.check(l);
/*      */     }
/*  850 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/*  859 */     long l = (GL.getICD()).glSamplerParameteriv;
/*  860 */     if (Checks.CHECKS) {
/*  861 */       Checks.check(l);
/*  862 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  864 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/*  873 */     long l = (GL.getICD()).glSamplerParameterfv;
/*  874 */     if (Checks.CHECKS) {
/*  875 */       Checks.check(l);
/*  876 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/*  878 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/*  887 */     long l = (GL.getICD()).glSamplerParameterIiv;
/*  888 */     if (Checks.CHECKS) {
/*  889 */       Checks.check(l);
/*  890 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  892 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/*  901 */     long l = (GL.getICD()).glSamplerParameterIuiv;
/*  902 */     if (Checks.CHECKS) {
/*  903 */       Checks.check(l);
/*  904 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  906 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/*  915 */     long l = (GL.getICD()).glGetSamplerParameteriv;
/*  916 */     if (Checks.CHECKS) {
/*  917 */       Checks.check(l);
/*  918 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  920 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/*  929 */     long l = (GL.getICD()).glGetSamplerParameterfv;
/*  930 */     if (Checks.CHECKS) {
/*  931 */       Checks.check(l);
/*  932 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/*  934 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/*  943 */     long l = (GL.getICD()).glGetSamplerParameterIiv;
/*  944 */     if (Checks.CHECKS) {
/*  945 */       Checks.check(l);
/*  946 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  948 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/*  957 */     long l = (GL.getICD()).glGetSamplerParameterIuiv;
/*  958 */     if (Checks.CHECKS) {
/*  959 */       Checks.check(l);
/*  960 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/*  962 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/*  971 */     long l = (GL.getICD()).glGetQueryObjecti64v;
/*  972 */     if (Checks.CHECKS) {
/*  973 */       Checks.check(l);
/*  974 */       Checks.check(paramArrayOflong, 1);
/*      */     } 
/*  976 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/*  985 */     long l = (GL.getICD()).glGetQueryObjectui64v;
/*  986 */     if (Checks.CHECKS) {
/*  987 */       Checks.check(l);
/*  988 */       Checks.check(paramArrayOflong, 1);
/*      */     } 
/*  990 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/*  999 */     long l = (GL.getICD()).glVertexAttribP1uiv;
/* 1000 */     if (Checks.CHECKS) {
/* 1001 */       Checks.check(l);
/* 1002 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1004 */     JNI.callPV(paramInt1, paramInt2, paramBoolean, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1013 */     long l = (GL.getICD()).glVertexAttribP2uiv;
/* 1014 */     if (Checks.CHECKS) {
/* 1015 */       Checks.check(l);
/* 1016 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1018 */     JNI.callPV(paramInt1, paramInt2, paramBoolean, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1027 */     long l = (GL.getICD()).glVertexAttribP3uiv;
/* 1028 */     if (Checks.CHECKS) {
/* 1029 */       Checks.check(l);
/* 1030 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1032 */     JNI.callPV(paramInt1, paramInt2, paramBoolean, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1041 */     long l = (GL.getICD()).glVertexAttribP4uiv;
/* 1042 */     if (Checks.CHECKS) {
/* 1043 */       Checks.check(l);
/* 1044 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1046 */     JNI.callPV(paramInt1, paramInt2, paramBoolean, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native void nglBindFragDataLocationIndexed(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native int nglGetFragDataIndex(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenSamplers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDeleteSamplers(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsSampler(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBindSampler(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glSamplerParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glSamplerParameterf(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglSamplerParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglSamplerParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetSamplerParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetSamplerParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetSamplerParameterIiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetSamplerParameterIuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glQueryCounter(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void nglGetQueryObjecti64v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetQueryObjectui64v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glVertexAttribDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glVertexAttribP1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribP2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribP3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glVertexAttribP4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void nglVertexAttribP1uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribP2uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribP3uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribP4uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL33C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */