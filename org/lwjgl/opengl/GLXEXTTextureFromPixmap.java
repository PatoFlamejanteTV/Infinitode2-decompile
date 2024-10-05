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
/*     */ public class GLXEXTTextureFromPixmap
/*     */ {
/*     */   public static final int GLX_BIND_TO_TEXTURE_RGB_EXT = 8400;
/*     */   public static final int GLX_BIND_TO_TEXTURE_RGBA_EXT = 8401;
/*     */   public static final int GLX_BIND_TO_MIPMAP_TEXTURE_EXT = 8402;
/*     */   public static final int GLX_BIND_TO_TEXTURE_TARGETS_EXT = 8403;
/*     */   public static final int GLX_Y_INVERTED_EXT = 8404;
/*     */   public static final int GLX_TEXTURE_FORMAT_EXT = 8405;
/*     */   public static final int GLX_TEXTURE_TARGET_EXT = 8406;
/*     */   public static final int GLX_MIPMAP_TEXTURE_EXT = 8407;
/*     */   public static final int GLX_TEXTURE_FORMAT_NONE_EXT = 8408;
/*     */   public static final int GLX_TEXTURE_FORMAT_RGB_EXT = 8409;
/*     */   public static final int GLX_TEXTURE_FORMAT_RGBA_EXT = 8410;
/*     */   public static final int GLX_TEXTURE_1D_BIT_EXT = 1;
/*     */   public static final int GLX_TEXTURE_2D_BIT_EXT = 2;
/*     */   public static final int GLX_TEXTURE_RECTANGLE_BIT_EXT = 4;
/*     */   public static final int GLX_TEXTURE_1D_EXT = 8411;
/*     */   public static final int GLX_TEXTURE_2D_EXT = 8412;
/*     */   public static final int GLX_TEXTURE_RECTANGLE_EXT = 8413;
/*     */   public static final int GLX_FRONT_LEFT_EXT = 8414;
/*     */   public static final int GLX_FRONT_RIGHT_EXT = 8415;
/*     */   public static final int GLX_BACK_LEFT_EXT = 8416;
/*     */   public static final int GLX_BACK_RIGHT_EXT = 8417;
/*     */   public static final int GLX_FRONT_EXT = 8414;
/*     */   public static final int GLX_BACK_EXT = 8416;
/*     */   public static final int GLX_AUX0_EXT = 8418;
/*     */   public static final int GLX_AUX1_EXT = 8419;
/*     */   public static final int GLX_AUX2_EXT = 8420;
/*     */   public static final int GLX_AUX3_EXT = 8421;
/*     */   public static final int GLX_AUX4_EXT = 8422;
/*     */   public static final int GLX_AUX5_EXT = 8423;
/*     */   public static final int GLX_AUX6_EXT = 8424;
/*     */   public static final int GLX_AUX7_EXT = 8425;
/*     */   public static final int GLX_AUX8_EXT = 8426;
/*     */   public static final int GLX_AUX9_EXT = 8427;
/*     */   
/*     */   protected GLXEXTTextureFromPixmap() {
/*  85 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXBindTexImageEXT(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/*  92 */     long l = (GL.getCapabilitiesGLXClient()).glXBindTexImageEXT;
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(l);
/*  95 */       Checks.check(paramLong1);
/*  96 */       Checks.check(paramLong2);
/*     */     } 
/*  98 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static void glXBindTexImageEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 114 */     nglXBindTexImageEXT(paramLong1, paramLong2, paramInt, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glXReleaseTexImageEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt) {
/* 127 */     long l = (GL.getCapabilitiesGLXClient()).glXReleaseTexImageEXT;
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(l);
/* 130 */       Checks.check(paramLong1);
/* 131 */       Checks.check(paramLong2);
/*     */     } 
/* 133 */     JNI.callPPV(paramLong1, paramLong2, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXBindTexImageEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt, @NativeType("int const *") int[] paramArrayOfint) {
/* 138 */     long l = (GL.getCapabilitiesGLXClient()).glXBindTexImageEXT;
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(l);
/* 141 */       Checks.check(paramLong1);
/* 142 */       Checks.check(paramLong2);
/* 143 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 145 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXEXTTextureFromPixmap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */