/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
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
/*     */ public class NVShadingRateImage
/*     */ {
/*     */   public static final int GL_SHADING_RATE_IMAGE_NV = 38243;
/*     */   public static final int GL_SHADING_RATE_NO_INVOCATIONS_NV = 38244;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_PIXEL_NV = 38245;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_1X2_PIXELS_NV = 38246;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X1_PIXELS_NV = 38247;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X2_PIXELS_NV = 38248;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X4_PIXELS_NV = 38249;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X2_PIXELS_NV = 38250;
/*     */   public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X4_PIXELS_NV = 38251;
/*     */   public static final int GL_SHADING_RATE_2_INVOCATIONS_PER_PIXEL_NV = 38252;
/*     */   public static final int GL_SHADING_RATE_4_INVOCATIONS_PER_PIXEL_NV = 38253;
/*     */   public static final int GL_SHADING_RATE_8_INVOCATIONS_PER_PIXEL_NV = 38254;
/*     */   public static final int GL_SHADING_RATE_16_INVOCATIONS_PER_PIXEL_NV = 38255;
/*     */   public static final int GL_SHADING_RATE_IMAGE_BINDING_NV = 38235;
/*     */   public static final int GL_SHADING_RATE_IMAGE_TEXEL_WIDTH_NV = 38236;
/*     */   public static final int GL_SHADING_RATE_IMAGE_TEXEL_HEIGHT_NV = 38237;
/*     */   public static final int GL_SHADING_RATE_IMAGE_PALETTE_SIZE_NV = 38238;
/*     */   public static final int GL_MAX_COARSE_FRAGMENT_SAMPLES_NV = 38239;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_DEFAULT_NV = 38318;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_PIXEL_MAJOR_NV = 38319;
/*     */   public static final int GL_SHADING_RATE_SAMPLE_ORDER_SAMPLE_MAJOR_NV = 38320;
/*     */   
/*     */   static {
/*  46 */     GL.initialize();
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
/*     */ 
/*     */   
/*     */   protected NVShadingRateImage() {
/*  89 */     throw new UnsupportedOperationException();
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
/*     */   public static void glShadingRateImagePaletteNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 101 */     nglShadingRateImagePaletteNV(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateImagePaletteNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum *") IntBuffer paramIntBuffer) {
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 112 */     nglGetShadingRateImagePaletteNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glShadingRateSampleOrderCustomNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 128 */     nglShadingRateSampleOrderCustomNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateSampleLocationivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 136 */     if (Checks.CHECKS) {
/* 137 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 139 */     nglGetShadingRateSampleLocationivNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShadingRateImagePaletteNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 144 */     long l = (GL.getICD()).glShadingRateImagePaletteNV;
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(l);
/*     */     }
/* 148 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateImagePaletteNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum *") int[] paramArrayOfint) {
/* 153 */     long l = (GL.getICD()).glGetShadingRateImagePaletteNV;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(l);
/* 156 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 158 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShadingRateSampleOrderCustomNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 163 */     long l = (GL.getICD()).glShadingRateSampleOrderCustomNV;
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(l);
/*     */     }
/* 167 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShadingRateSampleLocationivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 172 */     long l = (GL.getICD()).glGetShadingRateSampleLocationivNV;
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(l);
/* 175 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 177 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glBindShadingRateImageNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglShadingRateImagePaletteNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetShadingRateImagePaletteNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glShadingRateImageBarrierNV(@NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glShadingRateSampleOrderNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglShadingRateSampleOrderCustomNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetShadingRateSampleLocationivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVShadingRateImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */