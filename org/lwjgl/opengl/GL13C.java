/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL13C
/*     */   extends GL12C
/*     */ {
/*     */   public static final int GL_COMPRESSED_RGB = 34029;
/*     */   public static final int GL_COMPRESSED_RGBA = 34030;
/*     */   public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
/*     */   public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
/*     */   public static final int GL_TEXTURE_COMPRESSED = 34465;
/*     */   public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
/*     */   public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
/*     */   public static final int GL_TEXTURE_CUBE_MAP = 34067;
/*     */   public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
/*     */   
/*     */   static {
/*  32 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
/*     */ 
/*     */   
/*     */   public static final int GL_MULTISAMPLE = 32925;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE = 32928;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_BUFFERS = 32936;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLES = 32937;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE0 = 33984;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE1 = 33985;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE2 = 33986;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE3 = 33987;
/*     */   
/*     */   public static final int GL_TEXTURE4 = 33988;
/*     */   
/*     */   public static final int GL_TEXTURE5 = 33989;
/*     */   
/*     */   public static final int GL_TEXTURE6 = 33990;
/*     */   
/*     */   public static final int GL_TEXTURE7 = 33991;
/*     */   
/*     */   public static final int GL_TEXTURE8 = 33992;
/*     */   
/*     */   public static final int GL_TEXTURE9 = 33993;
/*     */   
/*     */   public static final int GL_TEXTURE10 = 33994;
/*     */   
/*     */   public static final int GL_TEXTURE11 = 33995;
/*     */   
/*     */   public static final int GL_TEXTURE12 = 33996;
/*     */   
/*     */   public static final int GL_TEXTURE13 = 33997;
/*     */   
/*     */   public static final int GL_TEXTURE14 = 33998;
/*     */   
/*     */   public static final int GL_TEXTURE15 = 33999;
/*     */   
/*     */   public static final int GL_TEXTURE16 = 34000;
/*     */   
/*     */   public static final int GL_TEXTURE17 = 34001;
/*     */   
/*     */   public static final int GL_TEXTURE18 = 34002;
/*     */   
/*     */   public static final int GL_TEXTURE19 = 34003;
/*     */   
/*     */   public static final int GL_TEXTURE20 = 34004;
/*     */   
/*     */   public static final int GL_TEXTURE21 = 34005;
/*     */   
/*     */   public static final int GL_TEXTURE22 = 34006;
/*     */   
/*     */   public static final int GL_TEXTURE23 = 34007;
/*     */   
/*     */   public static final int GL_TEXTURE24 = 34008;
/*     */   
/*     */   public static final int GL_TEXTURE25 = 34009;
/*     */   
/*     */   public static final int GL_TEXTURE26 = 34010;
/*     */   
/*     */   public static final int GL_TEXTURE27 = 34011;
/*     */   
/*     */   public static final int GL_TEXTURE28 = 34012;
/*     */   
/*     */   public static final int GL_TEXTURE29 = 34013;
/*     */   
/*     */   public static final int GL_TEXTURE30 = 34014;
/*     */   
/*     */   public static final int GL_TEXTURE31 = 34015;
/*     */   
/*     */   public static final int GL_ACTIVE_TEXTURE = 34016;
/*     */   
/*     */   public static final int GL_CLAMP_TO_BORDER = 33069;
/*     */ 
/*     */   
/*     */   protected GL13C() {
/* 143 */     throw new UnsupportedOperationException();
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
/*     */   public static void glCompressedTexImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 171 */     nglCompressedTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*     */   public static void glCompressedTexImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 189 */     nglCompressedTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   public static void glCompressedTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void const *") long paramLong) {
/* 216 */     nglCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
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
/*     */   public static void glCompressedTexImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 233 */     nglCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   public static void glCompressedTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/* 259 */     nglCompressedTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*     */   public static void glCompressedTexImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 275 */     nglCompressedTexImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("GLsizei") int paramInt10, @NativeType("void const *") long paramLong) {
/* 305 */     nglCompressedTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramLong);
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
/*     */   public static void glCompressedTexSubImage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLenum") int paramInt9, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 325 */     nglCompressedTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("void const *") long paramLong) {
/* 353 */     nglCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong);
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
/*     */   public static void glCompressedTexSubImage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLenum") int paramInt7, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 371 */     nglCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("void const *") long paramLong) {
/* 397 */     nglCompressedTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
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
/*     */   public static void glCompressedTexSubImage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 413 */     nglCompressedTexSubImage1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glGetCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 431 */     if (Checks.CHECKS && 
/* 432 */       Checks.DEBUG) {
/* 433 */       Checks.check(paramByteBuffer, GL11.glGetTexLevelParameteri(paramInt1, paramInt2, 34464));
/*     */     }
/*     */     
/* 436 */     nglGetCompressedTexImage(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glGetCompressedTexImage(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") long paramLong) {
/* 449 */     nglGetCompressedTexImage(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static native void nglCompressedTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*     */   
/*     */   public static native void nglCompressedTexSubImage1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*     */   
/*     */   public static native void nglGetCompressedTexImage(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glSampleCoverage(@NativeType("GLfloat") float paramFloat, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glActiveTexture(@NativeType("GLenum") int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL13C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */