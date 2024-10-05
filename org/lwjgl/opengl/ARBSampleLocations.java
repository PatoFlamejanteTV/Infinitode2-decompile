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
/*     */ 
/*     */ 
/*     */ public class ARBSampleLocations
/*     */ {
/*     */   public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB = 37693;
/*     */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB = 37694;
/*     */   public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB = 37695;
/*     */   public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB = 37696;
/*     */   public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB = 37698;
/*     */   public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB = 37699;
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
/*     */   protected ARBSampleLocations() {
/*  57 */     throw new UnsupportedOperationException();
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
/*     */   public static void glFramebufferSampleLocationsfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  82 */     nglFramebufferSampleLocationsfvARB(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glNamedFramebufferSampleLocationsfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 102 */     nglNamedFramebufferSampleLocationsfvARB(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glFramebufferSampleLocationsfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 116 */     long l = (GL.getICD()).glFramebufferSampleLocationsfvARB;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(l);
/*     */     }
/* 120 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedFramebufferSampleLocationsfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 125 */     long l = (GL.getICD()).glNamedFramebufferSampleLocationsfvARB;
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(l);
/*     */     }
/* 129 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*     */   }
/*     */   
/*     */   public static native void nglFramebufferSampleLocationsfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglNamedFramebufferSampleLocationsfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glEvaluateDepthValuesARB();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSampleLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */