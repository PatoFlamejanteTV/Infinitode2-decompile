/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBVertexShader
/*      */ {
/*      */   public static final int GL_VERTEX_SHADER_ARB = 35633;
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB = 35658;
/*      */   public static final int GL_MAX_VARYING_FLOATS_ARB = 35659;
/*      */   public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
/*      */   public static final int GL_MAX_TEXTURE_IMAGE_UNITS_ARB = 34930;
/*      */   public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB = 35660;
/*      */   public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB = 35661;
/*      */   public static final int GL_MAX_TEXTURE_COORDS_ARB = 34929;
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
/*      */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
/*      */   public static final int GL_OBJECT_ACTIVE_ATTRIBUTES_ARB = 35721;
/*      */   public static final int GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB = 35722;
/*      */   
/*      */   static {
/*   34 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
/*      */ 
/*      */   
/*      */   public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_VEC2_ARB = 35664;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_VEC3_ARB = 35665;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_VEC4_ARB = 35666;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_MAT2_ARB = 35674;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_MAT3_ARB = 35675;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_MAT4_ARB = 35676;
/*      */ 
/*      */ 
/*      */   
/*      */   protected ARBVertexShader() {
/*   84 */     throw new UnsupportedOperationException();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  250 */     if (Checks.CHECKS) {
/*  251 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  253 */     nglVertexAttrib1fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  268 */     if (Checks.CHECKS) {
/*  269 */       Checks.check(paramShortBuffer, 1);
/*      */     }
/*  271 */     nglVertexAttrib1svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  286 */     if (Checks.CHECKS) {
/*  287 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  289 */     nglVertexAttrib1dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  304 */     if (Checks.CHECKS) {
/*  305 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/*  307 */     nglVertexAttrib2fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  322 */     if (Checks.CHECKS) {
/*  323 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/*  325 */     nglVertexAttrib2svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  340 */     if (Checks.CHECKS) {
/*  341 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/*  343 */     nglVertexAttrib2dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  358 */     if (Checks.CHECKS) {
/*  359 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/*  361 */     nglVertexAttrib3fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  376 */     if (Checks.CHECKS) {
/*  377 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/*  379 */     nglVertexAttrib3svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  394 */     if (Checks.CHECKS) {
/*  395 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/*  397 */     nglVertexAttrib3dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  412 */     if (Checks.CHECKS) {
/*  413 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  415 */     nglVertexAttrib4fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  430 */     if (Checks.CHECKS) {
/*  431 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  433 */     nglVertexAttrib4svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  448 */     if (Checks.CHECKS) {
/*  449 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/*  451 */     nglVertexAttrib4dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  466 */     if (Checks.CHECKS) {
/*  467 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  469 */     nglVertexAttrib4ivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttrib4bvARB(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  484 */     if (Checks.CHECKS) {
/*  485 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  487 */     nglVertexAttrib4bvARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttrib4ubvARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  502 */     if (Checks.CHECKS) {
/*  503 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  505 */     nglVertexAttrib4ubvARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/*  520 */     if (Checks.CHECKS) {
/*  521 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  523 */     nglVertexAttrib4usvARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  538 */     if (Checks.CHECKS) {
/*  539 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  541 */     nglVertexAttrib4uivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttrib4NbvARB(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  556 */     if (Checks.CHECKS) {
/*  557 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  559 */     nglVertexAttrib4NbvARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  574 */     if (Checks.CHECKS) {
/*  575 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  577 */     nglVertexAttrib4NsvARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  592 */     if (Checks.CHECKS) {
/*  593 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  595 */     nglVertexAttrib4NivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttrib4NubvARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  610 */     if (Checks.CHECKS) {
/*  611 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/*  613 */     nglVertexAttrib4NubvARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/*  628 */     if (Checks.CHECKS) {
/*  629 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/*  631 */     nglVertexAttrib4NusvARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  646 */     if (Checks.CHECKS) {
/*  647 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  649 */     nglVertexAttrib4NuivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  670 */     nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/*  686 */     nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  702 */     nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  718 */     nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  734 */     nglVertexAttribPointerARB(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glBindAttribLocationARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  768 */     if (Checks.CHECKS) {
/*  769 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  771 */     nglBindAttribLocationARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindAttribLocationARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  782 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  784 */       memoryStack.nASCII(paramCharSequence, true);
/*  785 */       long l = memoryStack.getPointerAddress();
/*  786 */       nglBindAttribLocationARB(paramInt1, paramInt2, l); return;
/*      */     } finally {
/*  788 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetActiveAttribARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  813 */     if (Checks.CHECKS) {
/*  814 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  815 */       Checks.check(paramIntBuffer2, 1);
/*  816 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*  818 */     nglGetActiveAttribARB(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttribARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/*  832 */     if (Checks.CHECKS) {
/*  833 */       Checks.check(paramIntBuffer1, 1);
/*  834 */       Checks.check(paramIntBuffer2, 1);
/*      */     }  MemoryStack memoryStack;
/*  836 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  838 */       IntBuffer intBuffer = memoryStack.ints(0);
/*  839 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/*  840 */       nglGetActiveAttribARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/*  841 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/*  843 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttribARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/*  857 */     return glGetActiveAttribARB(paramInt1, paramInt2, ARBShaderObjects.glGetObjectParameteriARB(paramInt1, 35722), paramIntBuffer1, paramIntBuffer2);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocationARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  873 */     if (Checks.CHECKS) {
/*  874 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  876 */     return nglGetAttribLocationARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocationARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  887 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  889 */       memoryStack.nASCII(paramCharSequence, true);
/*  890 */       long l = memoryStack.getPointerAddress();
/*  891 */       paramInt = nglGetAttribLocationARB(paramInt, l); return paramInt;
/*      */     } finally {
/*  893 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  910 */     if (Checks.CHECKS) {
/*  911 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  913 */     nglGetVertexAttribivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetVertexAttribiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  924 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  926 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  927 */       nglGetVertexAttribivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  928 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  930 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  947 */     if (Checks.CHECKS) {
/*  948 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  950 */     nglGetVertexAttribfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  966 */     if (Checks.CHECKS) {
/*  967 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/*  969 */     nglGetVertexAttribdvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetVertexAttribPointervARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  985 */     if (Checks.CHECKS) {
/*  986 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  988 */     nglGetVertexAttribPointervARB(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  999 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1001 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 1002 */       nglGetVertexAttribPointervARB(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 1003 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 1005 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1011 */     long l = (GL.getICD()).glVertexAttrib1fvARB;
/* 1012 */     if (Checks.CHECKS) {
/* 1013 */       Checks.check(l);
/* 1014 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1016 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1021 */     long l = (GL.getICD()).glVertexAttrib1svARB;
/* 1022 */     if (Checks.CHECKS) {
/* 1023 */       Checks.check(l);
/* 1024 */       Checks.check(paramArrayOfshort, 1);
/*      */     } 
/* 1026 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1031 */     long l = (GL.getICD()).glVertexAttrib1dvARB;
/* 1032 */     if (Checks.CHECKS) {
/* 1033 */       Checks.check(l);
/* 1034 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 1036 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1041 */     long l = (GL.getICD()).glVertexAttrib2fvARB;
/* 1042 */     if (Checks.CHECKS) {
/* 1043 */       Checks.check(l);
/* 1044 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 1046 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1051 */     long l = (GL.getICD()).glVertexAttrib2svARB;
/* 1052 */     if (Checks.CHECKS) {
/* 1053 */       Checks.check(l);
/* 1054 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 1056 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1061 */     long l = (GL.getICD()).glVertexAttrib2dvARB;
/* 1062 */     if (Checks.CHECKS) {
/* 1063 */       Checks.check(l);
/* 1064 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 1066 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1071 */     long l = (GL.getICD()).glVertexAttrib3fvARB;
/* 1072 */     if (Checks.CHECKS) {
/* 1073 */       Checks.check(l);
/* 1074 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 1076 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1081 */     long l = (GL.getICD()).glVertexAttrib3svARB;
/* 1082 */     if (Checks.CHECKS) {
/* 1083 */       Checks.check(l);
/* 1084 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 1086 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1091 */     long l = (GL.getICD()).glVertexAttrib3dvARB;
/* 1092 */     if (Checks.CHECKS) {
/* 1093 */       Checks.check(l);
/* 1094 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 1096 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fvARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1101 */     long l = (GL.getICD()).glVertexAttrib4fvARB;
/* 1102 */     if (Checks.CHECKS) {
/* 1103 */       Checks.check(l);
/* 1104 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1106 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4svARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1111 */     long l = (GL.getICD()).glVertexAttrib4svARB;
/* 1112 */     if (Checks.CHECKS) {
/* 1113 */       Checks.check(l);
/* 1114 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 1116 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dvARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1121 */     long l = (GL.getICD()).glVertexAttrib4dvARB;
/* 1122 */     if (Checks.CHECKS) {
/* 1123 */       Checks.check(l);
/* 1124 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1126 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4ivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1131 */     long l = (GL.getICD()).glVertexAttrib4ivARB;
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(l);
/* 1134 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1136 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 1141 */     long l = (GL.getICD()).glVertexAttrib4usvARB;
/* 1142 */     if (Checks.CHECKS) {
/* 1143 */       Checks.check(l);
/* 1144 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 1146 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1151 */     long l = (GL.getICD()).glVertexAttrib4uivARB;
/* 1152 */     if (Checks.CHECKS) {
/* 1153 */       Checks.check(l);
/* 1154 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1156 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NsvARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1161 */     long l = (GL.getICD()).glVertexAttrib4NsvARB;
/* 1162 */     if (Checks.CHECKS) {
/* 1163 */       Checks.check(l);
/* 1164 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 1166 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NivARB(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1171 */     long l = (GL.getICD()).glVertexAttrib4NivARB;
/* 1172 */     if (Checks.CHECKS) {
/* 1173 */       Checks.check(l);
/* 1174 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1176 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NusvARB(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 1181 */     long l = (GL.getICD()).glVertexAttrib4NusvARB;
/* 1182 */     if (Checks.CHECKS) {
/* 1183 */       Checks.check(l);
/* 1184 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 1186 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4NuivARB(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1191 */     long l = (GL.getICD()).glVertexAttrib4NuivARB;
/* 1192 */     if (Checks.CHECKS) {
/* 1193 */       Checks.check(l);
/* 1194 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1196 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1201 */     long l = (GL.getICD()).glVertexAttribPointerARB;
/* 1202 */     if (Checks.CHECKS) {
/* 1203 */       Checks.check(l);
/*      */     }
/* 1205 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 1210 */     long l = (GL.getICD()).glVertexAttribPointerARB;
/* 1211 */     if (Checks.CHECKS) {
/* 1212 */       Checks.check(l);
/*      */     }
/* 1214 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glVertexAttribPointerARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1219 */     long l = (GL.getICD()).glVertexAttribPointerARB;
/* 1220 */     if (Checks.CHECKS) {
/* 1221 */       Checks.check(l);
/*      */     }
/* 1223 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttribARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1228 */     long l = (GL.getICD()).glGetActiveAttribARB;
/* 1229 */     if (Checks.CHECKS) {
/* 1230 */       Checks.check(l);
/* 1231 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 1232 */       Checks.check(paramArrayOfint2, 1);
/* 1233 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 1235 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1240 */     long l = (GL.getICD()).glGetVertexAttribivARB;
/* 1241 */     if (Checks.CHECKS) {
/* 1242 */       Checks.check(l);
/* 1243 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1245 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1250 */     long l = (GL.getICD()).glGetVertexAttribfvARB;
/* 1251 */     if (Checks.CHECKS) {
/* 1252 */       Checks.check(l);
/* 1253 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1255 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1260 */     long l = (GL.getICD()).glGetVertexAttribdvARB;
/* 1261 */     if (Checks.CHECKS) {
/* 1262 */       Checks.check(l);
/* 1263 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1265 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glVertexAttrib1fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glVertexAttrib1sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glVertexAttrib1dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glVertexAttrib2fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glVertexAttrib2sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glVertexAttrib2dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glVertexAttrib3fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glVertexAttrib3sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glVertexAttrib3dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertexAttrib4fARB(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glVertexAttrib4sARB(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glVertexAttrib4dARB(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glVertexAttrib4NubARB(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*      */   
/*      */   public static native void nglVertexAttrib1fvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1svARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1dvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2fvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2svARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2dvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3fvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3svARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3dvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4fvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4svARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4dvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4ivARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4bvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4ubvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4usvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4uivARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NbvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NsvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NivARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NubvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NusvARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4NuivARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribPointerARB(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glEnableVertexAttribArrayARB(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glDisableVertexAttribArrayARB(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglBindAttribLocationARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveAttribARB(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nglGetAttribLocationARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribdvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribPointervARB(int paramInt1, int paramInt2, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */