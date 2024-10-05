/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLXAMDGPUAssociation
/*     */ {
/*     */   public static final int GLX_GPU_VENDOR_AMD = 7936;
/*     */   public static final int GLX_GPU_RENDERER_STRING_AMD = 7937;
/*     */   public static final int GLX_GPU_OPENGL_VERSION_STRING_AMD = 7938;
/*     */   public static final int GLX_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
/*     */   public static final int GLX_GPU_RAM_AMD = 8611;
/*     */   public static final int GLX_GPU_CLOCK_AMD = 8612;
/*     */   public static final int GLX_GPU_NUM_PIPES_AMD = 8613;
/*     */   public static final int GLX_GPU_NUM_SIMD_AMD = 8614;
/*     */   public static final int GLX_GPU_NUM_RB_AMD = 8615;
/*     */   public static final int GLX_GPU_NUM_SPI_AMD = 8616;
/*     */   
/*     */   protected GLXAMDGPUAssociation() {
/*  44 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXBlitContextFramebufferAMD(@NativeType("GLXContext") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10) {
/*  50 */     long l = (GL.getCapabilitiesGLXClient()).glXBlitContextFramebufferAMD;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(l);
/*  53 */       Checks.check(paramLong);
/*     */     } 
/*  55 */     JNI.callPV(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAMD(@NativeType("unsigned int") int paramInt, @NativeType("GLXContext") long paramLong) {
/*  63 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAMD;
/*  64 */     if (Checks.CHECKS) {
/*  65 */       Checks.check(l);
/*  66 */       Checks.check(paramLong);
/*     */     } 
/*  68 */     return JNI.callPP(paramInt, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateAssociatedContextAttribsAMD(int paramInt, long paramLong1, long paramLong2) {
/*  75 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAttribsAMD;
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(l);
/*  78 */       Checks.check(paramLong1);
/*     */     } 
/*  80 */     return JNI.callPPP(paramInt, paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAttribsAMD(@NativeType("unsigned int") int paramInt, @NativeType("GLXContext") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer) {
/*  86 */     if (Checks.CHECKS) {
/*  87 */       Checks.checkNT(paramIntBuffer);
/*     */     }
/*  89 */     return nglXCreateAssociatedContextAttribsAMD(paramInt, paramLong, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXDeleteAssociatedContextAMD(@NativeType("GLXContext") long paramLong) {
/* 101 */     long l = (GL.getCapabilitiesGLXClient()).glXDeleteAssociatedContextAMD;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(l);
/* 104 */       Checks.check(paramLong);
/*     */     } 
/* 106 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int glXGetContextGPUIDAMD(@NativeType("GLXContext") long paramLong) {
/* 118 */     long l = (GL.getCapabilitiesGLXClient()).glXGetContextGPUIDAMD;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(l);
/* 121 */       Checks.check(paramLong);
/*     */     } 
/* 123 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXGetCurrentAssociatedContextAMD() {
/* 131 */     long l = (GL.getCapabilitiesGLXClient()).glXGetCurrentAssociatedContextAMD;
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(l);
/*     */     }
/* 135 */     return JNI.callP(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int glXGetGPUIDsAMD(@NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2) {
/* 143 */     long l = (GL.getCapabilitiesGLXClient()).glXGetGPUIDsAMD;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(l);
/*     */     }
/* 147 */     return JNI.callI(paramInt1, paramInt2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetGPUInfoAMD(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 154 */     long l = (GL.getCapabilitiesGLXClient()).glXGetGPUInfoAMD;
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(l);
/*     */     }
/* 158 */     return JNI.callPI(paramInt1, paramInt2, paramInt3, paramInt4, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int glXGetGPUInfoAMD(@NativeType("unsigned int") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 167 */     return nglXGetGPUInfoAMD(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeAssociatedContextCurrentAMD(@NativeType("GLXContext") long paramLong) {
/* 179 */     long l = (GL.getCapabilitiesGLXClient()).glXMakeAssociatedContextCurrentAMD;
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.check(l);
/* 182 */       Checks.check(paramLong);
/*     */     } 
/* 184 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAttribsAMD(@NativeType("unsigned int") int paramInt, @NativeType("GLXContext") long paramLong, @NativeType("int const *") int[] paramArrayOfint) {
/* 190 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAttribsAMD;
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(l);
/* 193 */       Checks.check(paramLong);
/* 194 */       Checks.checkNT(paramArrayOfint);
/*     */     } 
/* 196 */     return JNI.callPPP(paramInt, paramLong, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXAMDGPUAssociation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */