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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGLARBRenderTexture
/*     */ {
/*     */   public static final int WGL_BIND_TO_TEXTURE_RGB_ARB = 8304;
/*     */   public static final int WGL_BIND_TO_TEXTURE_RGBA_ARB = 8305;
/*     */   public static final int WGL_TEXTURE_FORMAT_ARB = 8306;
/*     */   public static final int WGL_TEXTURE_TARGET_ARB = 8307;
/*     */   public static final int WGL_MIPMAP_TEXTURE_ARB = 8308;
/*     */   public static final int WGL_TEXTURE_RGB_ARB = 8309;
/*     */   public static final int WGL_TEXTURE_RGBA_ARB = 8310;
/*     */   public static final int WGL_NO_TEXTURE_ARB = 8311;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_ARB = 8312;
/*     */   public static final int WGL_TEXTURE_1D_ARB = 8313;
/*     */   public static final int WGL_TEXTURE_2D_ARB = 8314;
/*     */   public static final int WGL_MIPMAP_LEVEL_ARB = 8315;
/*     */   public static final int WGL_CUBE_MAP_FACE_ARB = 8316;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB = 8317;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB = 8318;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB = 8319;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB = 8320;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB = 8321;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB = 8322;
/*     */   public static final int WGL_FRONT_LEFT_ARB = 8323;
/*     */   public static final int WGL_FRONT_RIGHT_ARB = 8324;
/*     */   public static final int WGL_BACK_LEFT_ARB = 8325;
/*     */   public static final int WGL_BACK_RIGHT_ARB = 8326;
/*     */   public static final int WGL_AUX0_ARB = 8327;
/*     */   public static final int WGL_AUX1_ARB = 8328;
/*     */   public static final int WGL_AUX2_ARB = 8329;
/*     */   public static final int WGL_AUX3_ARB = 8330;
/*     */   public static final int WGL_AUX4_ARB = 8331;
/*     */   public static final int WGL_AUX5_ARB = 8332;
/*     */   public static final int WGL_AUX6_ARB = 8333;
/*     */   public static final int WGL_AUX7_ARB = 8334;
/*     */   public static final int WGL_AUX8_ARB = 8335;
/*     */   public static final int WGL_AUX9_ARB = 8336;
/*     */   
/*     */   protected WGLARBRenderTexture() {
/* 112 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglBindTexImageARB(@NativeType("HPBUFFERARB") long paramLong, int paramInt) {
/* 127 */     long l = (GL.getCapabilitiesWGL()).wglBindTexImageARB;
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(l);
/* 130 */       Checks.check(paramLong);
/*     */     } 
/* 132 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglReleaseTexImageARB(@NativeType("HPBUFFERARB") long paramLong, int paramInt) {
/* 146 */     long l = (GL.getCapabilitiesWGL()).wglReleaseTexImageARB;
/* 147 */     if (Checks.CHECKS) {
/* 148 */       Checks.check(l);
/* 149 */       Checks.check(paramLong);
/*     */     } 
/* 151 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglSetPbufferAttribARB(long paramLong1, long paramLong2) {
/* 158 */     long l = (GL.getCapabilitiesWGL()).wglSetPbufferAttribARB;
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(l);
/* 161 */       Checks.check(paramLong1);
/*     */     } 
/* 163 */     return JNI.callPPI(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglSetPbufferAttribARB(@NativeType("HPBUFFERARB") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 177 */     return (nwglSetPbufferAttribARB(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglSetPbufferAttribARB(@NativeType("HPBUFFERARB") long paramLong, @NativeType("int const *") int[] paramArrayOfint) {
/* 183 */     long l = (GL.getCapabilitiesWGL()).wglSetPbufferAttribARB;
/* 184 */     if (Checks.CHECKS) {
/* 185 */       Checks.check(l);
/* 186 */       Checks.check(paramLong);
/* 187 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 189 */     return (JNI.callPPI(paramLong, paramArrayOfint, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBRenderTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */