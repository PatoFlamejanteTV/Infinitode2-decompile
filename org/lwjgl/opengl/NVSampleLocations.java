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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVSampleLocations
/*     */ {
/*     */   public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_NV = 37693;
/*     */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_NV = 37694;
/*     */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_NV = 37695;
/*     */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_NV = 37696;
/*     */   public static final int GL_SAMPLE_LOCATION_NV = 36432;
/*     */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_NV = 37697;
/*     */   public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_NV = 37698;
/*     */   public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_NV = 37699;
/*     */   
/*     */   static {
/*  39 */     GL.initialize();
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
/*     */   protected NVSampleLocations() {
/*  59 */     throw new UnsupportedOperationException();
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
/*     */   public static void glFramebufferSampleLocationsfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  79 */     nglFramebufferSampleLocationsfvNV(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glNamedFramebufferSampleLocationsfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  99 */     nglNamedFramebufferSampleLocationsfvNV(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glFramebufferSampleLocationsfvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 113 */     long l = (GL.getICD()).glFramebufferSampleLocationsfvNV;
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.check(l);
/*     */     }
/* 117 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedFramebufferSampleLocationsfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 122 */     long l = (GL.getICD()).glNamedFramebufferSampleLocationsfvNV;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(l);
/*     */     }
/* 126 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglNamedFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glResolveDepthValuesNV();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVSampleLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */