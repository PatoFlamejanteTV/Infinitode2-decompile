/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
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
/*      */ 
/*      */ 
/*      */ public class GL13
/*      */   extends GL12
/*      */ {
/*      */   public static final int GL_COMPRESSED_ALPHA = 34025;
/*      */   public static final int GL_COMPRESSED_LUMINANCE = 34026;
/*      */   public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;
/*      */   public static final int GL_COMPRESSED_INTENSITY = 34028;
/*      */   public static final int GL_COMPRESSED_RGB = 34029;
/*      */   public static final int GL_COMPRESSED_RGBA = 34030;
/*      */   public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
/*      */   public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
/*      */   public static final int GL_TEXTURE_COMPRESSED = 34465;
/*      */   public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
/*      */   public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
/*      */   public static final int GL_NORMAL_MAP = 34065;
/*      */   
/*      */   static {
/*   37 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_REFLECTION_MAP = 34066;
/*      */ 
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP = 34067;
/*      */ 
/*      */   
/*      */   public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
/*      */   
/*      */   public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
/*      */   
/*      */   public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
/*      */   
/*      */   public static final int GL_MULTISAMPLE = 32925;
/*      */   
/*      */   public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
/*      */   
/*      */   public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
/*      */   
/*      */   public static final int GL_SAMPLE_COVERAGE = 32928;
/*      */   
/*      */   public static final int GL_MULTISAMPLE_BIT = 536870912;
/*      */   
/*      */   public static final int GL_SAMPLE_BUFFERS = 32936;
/*      */   
/*      */   public static final int GL_SAMPLES = 32937;
/*      */   
/*      */   public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
/*      */   
/*      */   public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
/*      */   
/*      */   public static final int GL_TEXTURE0 = 33984;
/*      */   
/*      */   public static final int GL_TEXTURE1 = 33985;
/*      */   
/*      */   public static final int GL_TEXTURE2 = 33986;
/*      */   
/*      */   public static final int GL_TEXTURE3 = 33987;
/*      */   
/*      */   public static final int GL_TEXTURE4 = 33988;
/*      */   
/*      */   public static final int GL_TEXTURE5 = 33989;
/*      */   
/*      */   public static final int GL_TEXTURE6 = 33990;
/*      */   
/*      */   public static final int GL_TEXTURE7 = 33991;
/*      */   
/*      */   public static final int GL_TEXTURE8 = 33992;
/*      */   
/*      */   public static final int GL_TEXTURE9 = 33993;
/*      */   
/*      */   public static final int GL_TEXTURE10 = 33994;
/*      */   
/*      */   public static final int GL_TEXTURE11 = 33995;
/*      */   
/*      */   public static final int GL_TEXTURE12 = 33996;
/*      */   
/*      */   public static final int GL_TEXTURE13 = 33997;
/*      */   
/*      */   public static final int GL_TEXTURE14 = 33998;
/*      */   
/*      */   public static final int GL_TEXTURE15 = 33999;
/*      */   
/*      */   public static final int GL_TEXTURE16 = 34000;
/*      */   
/*      */   public static final int GL_TEXTURE17 = 34001;
/*      */   
/*      */   public static final int GL_TEXTURE18 = 34002;
/*      */   
/*      */   public static final int GL_TEXTURE19 = 34003;
/*      */   
/*      */   public static final int GL_TEXTURE20 = 34004;
/*      */   
/*      */   public static final int GL_TEXTURE21 = 34005;
/*      */   
/*      */   public static final int GL_TEXTURE22 = 34006;
/*      */   
/*      */   public static final int GL_TEXTURE23 = 34007;
/*      */   
/*      */   public static final int GL_TEXTURE24 = 34008;
/*      */   
/*      */   public static final int GL_TEXTURE25 = 34009;
/*      */   
/*      */   public static final int GL_TEXTURE26 = 34010;
/*      */   
/*      */   public static final int GL_TEXTURE27 = 34011;
/*      */   
/*      */   public static final int GL_TEXTURE28 = 34012;
/*      */   
/*      */   public static final int GL_TEXTURE29 = 34013;
/*      */   
/*      */   public static final int GL_TEXTURE30 = 34014;
/*      */   
/*      */   public static final int GL_TEXTURE31 = 34015;
/*      */   
/*      */   public static final int GL_ACTIVE_TEXTURE = 34016;
/*      */   
/*      */   public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;
/*      */   
/*      */   public static final int GL_MAX_TEXTURE_UNITS = 34018;
/*      */   
/*      */   public static final int GL_COMBINE = 34160;
/*      */   
/*      */   public static final int GL_COMBINE_RGB = 34161;
/*      */   
/*      */   public static final int GL_COMBINE_ALPHA = 34162;
/*      */   
/*      */   public static final int GL_SOURCE0_RGB = 34176;
/*      */   
/*      */   public static final int GL_SOURCE1_RGB = 34177;
/*      */   
/*      */   public static final int GL_SOURCE2_RGB = 34178;
/*      */   
/*      */   public static final int GL_SOURCE0_ALPHA = 34184;
/*      */   
/*      */   public static final int GL_SOURCE1_ALPHA = 34185;
/*      */   
/*      */   public static final int GL_SOURCE2_ALPHA = 34186;
/*      */   
/*      */   public static final int GL_OPERAND0_RGB = 34192;
/*      */   
/*      */   public static final int GL_OPERAND1_RGB = 34193;
/*      */   
/*      */   public static final int GL_OPERAND2_RGB = 34194;
/*      */   
/*      */   public static final int GL_OPERAND0_ALPHA = 34200;
/*      */   
/*      */   public static final int GL_OPERAND1_ALPHA = 34201;
/*      */   
/*      */   public static final int GL_OPERAND2_ALPHA = 34202;
/*      */   
/*      */   public static final int GL_RGB_SCALE = 34163;
/*      */   
/*      */   public static final int GL_ADD_SIGNED = 34164;
/*      */   
/*      */   public static final int GL_INTERPOLATE = 34165;
/*      */   
/*      */   public static final int GL_SUBTRACT = 34023;
/*      */   
/*      */   public static final int GL_CONSTANT = 34166;
/*      */   
/*      */   public static final int GL_PRIMARY_COLOR = 34167;
/*      */   
/*      */   public static final int GL_PREVIOUS = 34168;
/*      */   
/*      */   public static final int GL_DOT3_RGB = 34478;
/*      */   
/*      */   public static final int GL_DOT3_RGBA = 34479;
/*      */   
/*      */   public static final int GL_CLAMP_TO_BORDER = 33069;
/*      */   
/*      */   public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;
/*      */   
/*      */   public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;
/*      */   
/*      */   public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;
/*      */   
/*      */   public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;
/*      */ 
/*      */   
/*      */   protected GL13() {
/*  214 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/*  225 */     GL13C.nglCompressedTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTexImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/*  244 */     GL13C.glCompressedTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTexImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  262 */     GL13C.glCompressedTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {
/*  273 */     GL13C.nglCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*      */   public static void glCompressedTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/*  291 */     GL13C.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*      */   public static void glCompressedTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  308 */     GL13C.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/*  319 */     GL13C.nglCompressedTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/*  336 */     GL13C.glCompressedTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  352 */     GL13C.glCompressedTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong) {
/*  363 */     GL13C.nglCompressedTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLsizei") int paramInt10, @NativeType("void const *") long paramLong) {
/*  384 */     GL13C.glCompressedTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*      */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  404 */     GL13C.glCompressedTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong) {
/*  415 */     GL13C.nglCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/*  434 */     GL13C.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*      */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  452 */     GL13C.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglCompressedTexSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/*  463 */     GL13C.nglCompressedTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/*  480 */     GL13C.glCompressedTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*      */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  496 */     GL13C.glCompressedTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetCompressedTexImage(int paramInt1, int paramInt2, long paramLong) {
/*  503 */     GL13C.nglGetCompressedTexImage(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  516 */     GL13C.glGetCompressedTexImage(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static void glGetCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") long paramLong) {
/*  529 */     GL13C.glGetCompressedTexImage(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glSampleCoverage(@NativeType("GLfloat") float paramFloat, @NativeType("GLboolean") boolean paramBoolean) {
/*  556 */     GL13C.glSampleCoverage(paramFloat, paramBoolean);
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
/*      */   public static void glActiveTexture(@NativeType("GLenum") int paramInt) {
/*  570 */     GL13C.glActiveTexture(paramInt);
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
/*      */   public static void glMultiTexCoord1fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  647 */     if (Checks.CHECKS) {
/*  648 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  650 */     nglMultiTexCoord1fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexCoord1sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  667 */     if (Checks.CHECKS) {
/*  668 */       Checks.check(paramShortBuffer, 1);
/*      */     }
/*  670 */     nglMultiTexCoord1sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glMultiTexCoord1iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  687 */     if (Checks.CHECKS) {
/*  688 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  690 */     nglMultiTexCoord1iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexCoord1dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  707 */     if (Checks.CHECKS) {
/*  708 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  710 */     nglMultiTexCoord1dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultiTexCoord2fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  779 */     if (Checks.CHECKS) {
/*  780 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/*  782 */     nglMultiTexCoord2fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexCoord2sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  799 */     if (Checks.CHECKS) {
/*  800 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/*  802 */     nglMultiTexCoord2sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glMultiTexCoord2iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  819 */     if (Checks.CHECKS) {
/*  820 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/*  822 */     nglMultiTexCoord2iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexCoord2dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  839 */     if (Checks.CHECKS) {
/*  840 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/*  842 */     nglMultiTexCoord2dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultiTexCoord3fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  915 */     if (Checks.CHECKS) {
/*  916 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/*  918 */     nglMultiTexCoord3fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexCoord3sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  935 */     if (Checks.CHECKS) {
/*  936 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/*  938 */     nglMultiTexCoord3sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glMultiTexCoord3iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  955 */     if (Checks.CHECKS) {
/*  956 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  958 */     nglMultiTexCoord3iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexCoord3dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  975 */     if (Checks.CHECKS) {
/*  976 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/*  978 */     nglMultiTexCoord3dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultiTexCoord4fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1055 */     if (Checks.CHECKS) {
/* 1056 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1058 */     nglMultiTexCoord4fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultiTexCoord4sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1075 */     if (Checks.CHECKS) {
/* 1076 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1078 */     nglMultiTexCoord4sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void glMultiTexCoord4iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1095 */     if (Checks.CHECKS) {
/* 1096 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1098 */     nglMultiTexCoord4iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void glMultiTexCoord4dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1115 */     if (Checks.CHECKS) {
/* 1116 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1118 */     nglMultiTexCoord4dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glLoadTransposeMatrixf(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1143 */     if (Checks.CHECKS) {
/* 1144 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 1146 */     nglLoadTransposeMatrixf(MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glLoadTransposeMatrixd(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1162 */     if (Checks.CHECKS) {
/* 1163 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 1165 */     nglLoadTransposeMatrixd(MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glMultTransposeMatrixf(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1181 */     if (Checks.CHECKS) {
/* 1182 */       Checks.check(paramFloatBuffer, 16);
/*      */     }
/* 1184 */     nglMultTransposeMatrixf(MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void glMultTransposeMatrixd(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1200 */     if (Checks.CHECKS) {
/* 1201 */       Checks.check(paramDoubleBuffer, 16);
/*      */     }
/* 1203 */     nglMultTransposeMatrixd(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord1fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1212 */     long l = (GL.getICD()).glMultiTexCoord1fv;
/* 1213 */     if (Checks.CHECKS) {
/* 1214 */       Checks.check(l);
/* 1215 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1217 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord1sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1226 */     long l = (GL.getICD()).glMultiTexCoord1sv;
/* 1227 */     if (Checks.CHECKS) {
/* 1228 */       Checks.check(l);
/* 1229 */       Checks.check(paramArrayOfshort, 1);
/*      */     } 
/* 1231 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord1iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1240 */     long l = (GL.getICD()).glMultiTexCoord1iv;
/* 1241 */     if (Checks.CHECKS) {
/* 1242 */       Checks.check(l);
/* 1243 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1245 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord1dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1254 */     long l = (GL.getICD()).glMultiTexCoord1dv;
/* 1255 */     if (Checks.CHECKS) {
/* 1256 */       Checks.check(l);
/* 1257 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 1259 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord2fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1268 */     long l = (GL.getICD()).glMultiTexCoord2fv;
/* 1269 */     if (Checks.CHECKS) {
/* 1270 */       Checks.check(l);
/* 1271 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 1273 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord2sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1282 */     long l = (GL.getICD()).glMultiTexCoord2sv;
/* 1283 */     if (Checks.CHECKS) {
/* 1284 */       Checks.check(l);
/* 1285 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 1287 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord2iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1296 */     long l = (GL.getICD()).glMultiTexCoord2iv;
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.check(l);
/* 1299 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 1301 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord2dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1310 */     long l = (GL.getICD()).glMultiTexCoord2dv;
/* 1311 */     if (Checks.CHECKS) {
/* 1312 */       Checks.check(l);
/* 1313 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 1315 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord3fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1324 */     long l = (GL.getICD()).glMultiTexCoord3fv;
/* 1325 */     if (Checks.CHECKS) {
/* 1326 */       Checks.check(l);
/* 1327 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 1329 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord3sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1338 */     long l = (GL.getICD()).glMultiTexCoord3sv;
/* 1339 */     if (Checks.CHECKS) {
/* 1340 */       Checks.check(l);
/* 1341 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 1343 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord3iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1352 */     long l = (GL.getICD()).glMultiTexCoord3iv;
/* 1353 */     if (Checks.CHECKS) {
/* 1354 */       Checks.check(l);
/* 1355 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 1357 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord3dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1366 */     long l = (GL.getICD()).glMultiTexCoord3dv;
/* 1367 */     if (Checks.CHECKS) {
/* 1368 */       Checks.check(l);
/* 1369 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 1371 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord4fv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1380 */     long l = (GL.getICD()).glMultiTexCoord4fv;
/* 1381 */     if (Checks.CHECKS) {
/* 1382 */       Checks.check(l);
/* 1383 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1385 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord4sv(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1394 */     long l = (GL.getICD()).glMultiTexCoord4sv;
/* 1395 */     if (Checks.CHECKS) {
/* 1396 */       Checks.check(l);
/* 1397 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 1399 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord4iv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1408 */     long l = (GL.getICD()).glMultiTexCoord4iv;
/* 1409 */     if (Checks.CHECKS) {
/* 1410 */       Checks.check(l);
/* 1411 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1413 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiTexCoord4dv(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1422 */     long l = (GL.getICD()).glMultiTexCoord4dv;
/* 1423 */     if (Checks.CHECKS) {
/* 1424 */       Checks.check(l);
/* 1425 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 1427 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadTransposeMatrixf(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1436 */     long l = (GL.getICD()).glLoadTransposeMatrixf;
/* 1437 */     if (Checks.CHECKS) {
/* 1438 */       Checks.check(l);
/* 1439 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 1441 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glLoadTransposeMatrixd(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1450 */     long l = (GL.getICD()).glLoadTransposeMatrixd;
/* 1451 */     if (Checks.CHECKS) {
/* 1452 */       Checks.check(l);
/* 1453 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 1455 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultTransposeMatrixf(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1464 */     long l = (GL.getICD()).glMultTransposeMatrixf;
/* 1465 */     if (Checks.CHECKS) {
/* 1466 */       Checks.check(l);
/* 1467 */       Checks.check(paramArrayOffloat, 16);
/*      */     } 
/* 1469 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultTransposeMatrixd(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1478 */     long l = (GL.getICD()).glMultTransposeMatrixd;
/* 1479 */     if (Checks.CHECKS) {
/* 1480 */       Checks.check(l);
/* 1481 */       Checks.check(paramArrayOfdouble, 16);
/*      */     } 
/* 1483 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glClientActiveTexture(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glMultiTexCoord1f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glMultiTexCoord1s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glMultiTexCoord1i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glMultiTexCoord1d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglMultiTexCoord1fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord1sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord1iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord1dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMultiTexCoord2f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glMultiTexCoord2s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glMultiTexCoord2i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glMultiTexCoord2d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglMultiTexCoord2fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord2sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord2iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord2dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMultiTexCoord3f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glMultiTexCoord3s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glMultiTexCoord3i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glMultiTexCoord3d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglMultiTexCoord3fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord3sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord3iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord3dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glMultiTexCoord4f(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glMultiTexCoord4s(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glMultiTexCoord4i(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glMultiTexCoord4d(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglMultiTexCoord4fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord4sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord4iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglMultiTexCoord4dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglLoadTransposeMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglLoadTransposeMatrixd(long paramLong);
/*      */   
/*      */   public static native void nglMultTransposeMatrixf(long paramLong);
/*      */   
/*      */   public static native void nglMultTransposeMatrixd(long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */