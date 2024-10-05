/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVFramebufferMixedSamples
/*     */ {
/*     */   public static final int GL_RASTER_MULTISAMPLE_EXT = 37671;
/*     */   public static final int GL_COVERAGE_MODULATION_TABLE_NV = 37681;
/*     */   public static final int GL_RASTER_SAMPLES_EXT = 37672;
/*     */   public static final int GL_MAX_RASTER_SAMPLES_EXT = 37673;
/*     */   public static final int GL_RASTER_FIXED_SAMPLE_LOCATIONS_EXT = 37674;
/*     */   public static final int GL_MULTISAMPLE_RASTERIZATION_ALLOWED_EXT = 37675;
/*     */   public static final int GL_EFFECTIVE_RASTER_SAMPLES_EXT = 37676;
/*     */   public static final int GL_COLOR_SAMPLES_NV = 36384;
/*     */   public static final int GL_DEPTH_SAMPLES_NV = 37677;
/*     */   public static final int GL_STENCIL_SAMPLES_NV = 37678;
/*     */   public static final int GL_MIXED_DEPTH_SAMPLES_SUPPORTED_NV = 37679;
/*     */   public static final int GL_MIXED_STENCIL_SAMPLES_SUPPORTED_NV = 37680;
/*     */   public static final int GL_COVERAGE_MODULATION_NV = 37682;
/*     */   public static final int GL_COVERAGE_MODULATION_TABLE_SIZE_NV = 37683;
/*     */   
/*     */   static {
/*  31 */     GL.initialize();
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
/*     */   protected NVFramebufferMixedSamples() {
/*  54 */     throw new UnsupportedOperationException();
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
/*     */   public static void glRasterSamplesEXT(@NativeType("GLuint") int paramInt, @NativeType("GLboolean") boolean paramBoolean) {
/*  91 */     EXTRasterMultisample.glRasterSamplesEXT(paramInt, paramBoolean);
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
/*     */   public static void glCoverageModulationTableNV(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 104 */     nglCoverageModulationTableNV(paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetCoverageModulationTableNV(@NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 112 */     nglGetCoverageModulationTableNV(paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCoverageModulationTableNV(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 121 */     long l = (GL.getICD()).glCoverageModulationTableNV;
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(l);
/*     */     }
/* 125 */     JNI.callPV(paramArrayOffloat.length, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetCoverageModulationTableNV(@NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 130 */     long l = (GL.getICD()).glGetCoverageModulationTableNV;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(l);
/*     */     }
/* 134 */     JNI.callPV(paramArrayOffloat.length, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglCoverageModulationTableNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetCoverageModulationTableNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glCoverageModulationNV(@NativeType("GLenum") int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVFramebufferMixedSamples.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */