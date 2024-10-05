/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ 
/*     */ public class WGLAMDGPUAssociation
/*     */ {
/*     */   public static final int WGL_GPU_VENDOR_AMD = 7936;
/*     */   public static final int WGL_GPU_RENDERER_STRING_AMD = 7937;
/*     */   public static final int WGL_GPU_OPENGL_VERSION_STRING_AMD = 7938;
/*     */   public static final int WGL_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
/*     */   public static final int WGL_GPU_RAM_AMD = 8611;
/*     */   public static final int WGL_GPU_CLOCK_AMD = 8612;
/*     */   public static final int WGL_GPU_NUM_PIPES_AMD = 8613;
/*     */   public static final int WGL_GPU_NUM_SIMD_AMD = 8614;
/*     */   public static final int WGL_GPU_NUM_RB_AMD = 8615;
/*     */   public static final int WGL_GPU_NUM_SPI_AMD = 8616;
/*     */   
/*     */   protected WGLAMDGPUAssociation() {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetGPUIDsAMD(int paramInt, long paramLong) {
/*  57 */     long l = (GL.getCapabilitiesWGL()).wglGetGPUIDsAMD;
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.check(l);
/*     */     }
/*  61 */     return JNI.callPI(paramInt, paramLong, l);
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
/*     */   @NativeType("UINT")
/*     */   public static int wglGetGPUIDsAMD(@NativeType("UINT *") IntBuffer paramIntBuffer) {
/*  75 */     return nwglGetGPUIDsAMD(Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetGPUInfoAMD(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  86 */     long l = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(l);
/*     */     }
/*  90 */     return JNI.callPI(paramInt1, paramInt2, paramInt3, paramInt4, paramLong, l);
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
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 108 */     return nwglGetGPUInfoAMD(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt3), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 126 */     return nwglGetGPUInfoAMD(paramInt1, paramInt2, paramInt3, (int)(paramIntBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt3)), MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 144 */     return nwglGetGPUInfoAMD(paramInt1, paramInt2, paramInt3, (int)(paramFloatBuffer.remaining() << 2L >> GLChecks.typeToByteShift(paramInt3)), MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   @NativeType("UINT")
/*     */   public static int wglGetContextGPUIDAMD(@NativeType("HGLRC") long paramLong) {
/* 160 */     long l = (GL.getCapabilitiesWGL()).wglGetContextGPUIDAMD;
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.check(l);
/* 163 */       Checks.check(paramLong);
/*     */     } 
/* 165 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAMD(@NativeType("UINT") int paramInt) {
/* 177 */     long l = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAMD;
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check(l);
/*     */     }
/* 181 */     return JNI.callP(paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateAssociatedContextAttribsAMD(int paramInt, long paramLong1, long paramLong2) {
/* 188 */     long l = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAttribsAMD;
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(l);
/*     */     }
/* 192 */     return JNI.callPPP(paramInt, paramLong1, paramLong2, l);
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
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAttribsAMD(@NativeType("UINT") int paramInt, @NativeType("HGLRC") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 209 */     return nwglCreateAssociatedContextAttribsAMD(paramInt, paramLong, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteAssociatedContextAMD(@NativeType("HGLRC") long paramLong) {
/* 221 */     long l = (GL.getCapabilitiesWGL()).wglDeleteAssociatedContextAMD;
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(l);
/* 224 */       Checks.check(paramLong);
/*     */     } 
/* 226 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglMakeAssociatedContextCurrentAMD(@NativeType("HGLRC") long paramLong) {
/* 238 */     long l = (GL.getCapabilitiesWGL()).wglMakeAssociatedContextCurrentAMD;
/* 239 */     if (Checks.CHECKS) {
/* 240 */       Checks.check(l);
/* 241 */       Checks.check(paramLong);
/*     */     } 
/* 243 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglGetCurrentAssociatedContextAMD() {
/* 251 */     long l = (GL.getCapabilitiesWGL()).wglGetCurrentAssociatedContextAMD;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(l);
/*     */     }
/* 255 */     return JNI.callP(l);
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
/*     */   @NativeType("VOID")
/*     */   public static void wglBlitContextFramebufferAMD(@NativeType("HGLRC") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10) {
/* 277 */     long l = (GL.getCapabilitiesWGL()).wglBlitContextFramebufferAMD;
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(l);
/* 280 */       Checks.check(paramLong);
/*     */     } 
/* 282 */     JNI.callPV(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("UINT")
/*     */   public static int wglGetGPUIDsAMD(@NativeType("UINT *") int[] paramArrayOfint) {
/* 288 */     long l = (GL.getCapabilitiesWGL()).wglGetGPUIDsAMD;
/* 289 */     if (Checks.CHECKS) {
/* 290 */       Checks.check(l);
/*     */     }
/* 292 */     return JNI.callPI(Checks.lengthSafe(paramArrayOfint), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") int[] paramArrayOfint) {
/* 297 */     long l = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/* 298 */     if (Checks.CHECKS) {
/* 299 */       Checks.check(l);
/*     */     }
/* 301 */     return JNI.callPI(paramInt1, paramInt2, paramInt3, paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int paramInt1, int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") float[] paramArrayOffloat) {
/* 306 */     long l = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(l);
/*     */     }
/* 310 */     return JNI.callPI(paramInt1, paramInt2, paramInt3, paramArrayOffloat.length, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAttribsAMD(@NativeType("UINT") int paramInt, @NativeType("HGLRC") long paramLong, @NativeType("int const *") int[] paramArrayOfint) {
/* 316 */     long l = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAttribsAMD;
/* 317 */     if (Checks.CHECKS) {
/* 318 */       Checks.check(l);
/* 319 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 321 */     return JNI.callPPP(paramInt, paramLong, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLAMDGPUAssociation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */