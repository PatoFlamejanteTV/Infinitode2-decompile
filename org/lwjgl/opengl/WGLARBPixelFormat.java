/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
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
/*     */ public class WGLARBPixelFormat
/*     */ {
/*     */   public static final int WGL_NUMBER_PIXEL_FORMATS_ARB = 8192;
/*     */   public static final int WGL_DRAW_TO_WINDOW_ARB = 8193;
/*     */   public static final int WGL_DRAW_TO_BITMAP_ARB = 8194;
/*     */   public static final int WGL_ACCELERATION_ARB = 8195;
/*     */   public static final int WGL_NEED_PALETTE_ARB = 8196;
/*     */   public static final int WGL_NEED_SYSTEM_PALETTE_ARB = 8197;
/*     */   public static final int WGL_SWAP_LAYER_BUFFERS_ARB = 8198;
/*     */   public static final int WGL_SWAP_METHOD_ARB = 8199;
/*     */   public static final int WGL_NUMBER_OVERLAYS_ARB = 8200;
/*     */   public static final int WGL_NUMBER_UNDERLAYS_ARB = 8201;
/*     */   public static final int WGL_TRANSPARENT_ARB = 8202;
/*     */   public static final int WGL_TRANSPARENT_RED_VALUE_ARB = 8247;
/*     */   public static final int WGL_TRANSPARENT_GREEN_VALUE_ARB = 8248;
/*     */   public static final int WGL_TRANSPARENT_BLUE_VALUE_ARB = 8249;
/*     */   public static final int WGL_TRANSPARENT_ALPHA_VALUE_ARB = 8250;
/*     */   public static final int WGL_TRANSPARENT_INDEX_VALUE_ARB = 8251;
/*     */   public static final int WGL_SHARE_DEPTH_ARB = 8204;
/*     */   public static final int WGL_SHARE_STENCIL_ARB = 8205;
/*     */   public static final int WGL_SHARE_ACCUM_ARB = 8206;
/*     */   public static final int WGL_SUPPORT_GDI_ARB = 8207;
/*     */   public static final int WGL_SUPPORT_OPENGL_ARB = 8208;
/*     */   public static final int WGL_DOUBLE_BUFFER_ARB = 8209;
/*     */   public static final int WGL_STEREO_ARB = 8210;
/*     */   public static final int WGL_PIXEL_TYPE_ARB = 8211;
/*     */   public static final int WGL_COLOR_BITS_ARB = 8212;
/*     */   public static final int WGL_RED_BITS_ARB = 8213;
/*     */   public static final int WGL_RED_SHIFT_ARB = 8214;
/*     */   public static final int WGL_GREEN_BITS_ARB = 8215;
/*     */   public static final int WGL_GREEN_SHIFT_ARB = 8216;
/*     */   public static final int WGL_BLUE_BITS_ARB = 8217;
/*     */   public static final int WGL_BLUE_SHIFT_ARB = 8218;
/*     */   public static final int WGL_ALPHA_BITS_ARB = 8219;
/*     */   public static final int WGL_ALPHA_SHIFT_ARB = 8220;
/*     */   public static final int WGL_ACCUM_BITS_ARB = 8221;
/*     */   public static final int WGL_ACCUM_RED_BITS_ARB = 8222;
/*     */   public static final int WGL_ACCUM_GREEN_BITS_ARB = 8223;
/*     */   public static final int WGL_ACCUM_BLUE_BITS_ARB = 8224;
/*     */   public static final int WGL_ACCUM_ALPHA_BITS_ARB = 8225;
/*     */   public static final int WGL_DEPTH_BITS_ARB = 8226;
/*     */   public static final int WGL_STENCIL_BITS_ARB = 8227;
/*     */   public static final int WGL_AUX_BUFFERS_ARB = 8228;
/*     */   public static final int WGL_NO_ACCELERATION_ARB = 8229;
/*     */   public static final int WGL_GENERIC_ACCELERATION_ARB = 8230;
/*     */   public static final int WGL_FULL_ACCELERATION_ARB = 8231;
/*     */   public static final int WGL_SWAP_EXCHANGE_ARB = 8232;
/*     */   public static final int WGL_SWAP_COPY_ARB = 8233;
/*     */   public static final int WGL_SWAP_UNDEFINED_ARB = 8234;
/*     */   public static final int WGL_TYPE_RGBA_ARB = 8235;
/*     */   public static final int WGL_TYPE_COLORINDEX_ARB = 8236;
/*     */   
/*     */   protected WGLARBPixelFormat() {
/*  93 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetPixelFormatAttribivARB(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3) {
/* 104 */     long l = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribivARB;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(l);
/* 107 */       Checks.check(paramLong1);
/*     */     } 
/* 109 */     return JNI.callPPPI(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramLong3, l);
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
/*     */   public static boolean wglGetPixelFormatAttribivARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());
/*     */     }
/* 124 */     return (nwglGetPixelFormatAttribivARB(paramLong, paramInt1, paramInt2, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribiARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") int paramInt3, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 135 */     if (Checks.CHECKS)
/* 136 */       Checks.check(paramIntBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 138 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 140 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 141 */       return (nwglGetPixelFormatAttribivARB(paramLong, paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer)) != 0);
/*     */     } finally {
/* 143 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetPixelFormatAttribfvARB(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3) {
/* 155 */     long l = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribfvARB;
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(l);
/* 158 */       Checks.check(paramLong1);
/*     */     } 
/* 160 */     return JNI.callPPPI(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramLong3, l);
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
/*     */   public static boolean wglGetPixelFormatAttribfvARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") IntBuffer paramIntBuffer, @NativeType("FLOAT *") FloatBuffer paramFloatBuffer) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(paramFloatBuffer, paramIntBuffer.remaining());
/*     */     }
/* 177 */     return (nwglGetPixelFormatAttribfvARB(paramLong, paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramFloatBuffer)) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribfARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") int paramInt3, @NativeType("FLOAT *") FloatBuffer paramFloatBuffer) {
/* 190 */     if (Checks.CHECKS)
/* 191 */       Checks.check(paramFloatBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 193 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 195 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 196 */       return (nwglGetPixelFormatAttribfvARB(paramLong, paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramFloatBuffer)) != 0);
/*     */     } finally {
/* 198 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglChoosePixelFormatARB(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5) {
/* 210 */     long l = (GL.getCapabilitiesWGL()).wglChoosePixelFormatARB;
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check(l);
/* 213 */       Checks.check(paramLong1);
/*     */     } 
/* 215 */     return JNI.callPPPPPI(paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramLong5, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglChoosePixelFormatARB(@NativeType("HDC") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer1, @NativeType("FLOAT const *") FloatBuffer paramFloatBuffer, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("UINT *") IntBuffer paramIntBuffer3) {
/* 232 */     if (Checks.CHECKS) {
/* 233 */       Checks.checkNTSafe(paramIntBuffer1);
/* 234 */       Checks.checkNTSafe(paramFloatBuffer);
/* 235 */       Checks.check(paramIntBuffer3, 1);
/*     */     } 
/* 237 */     return (nwglChoosePixelFormatARB(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramFloatBuffer), paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribivARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2) {
/* 243 */     long l = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribivARB;
/* 244 */     if (Checks.CHECKS) {
/* 245 */       Checks.check(l);
/* 246 */       Checks.check(paramLong);
/* 247 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     } 
/* 249 */     return (JNI.callPPPI(paramLong, paramInt1, paramInt2, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribfvARB(@NativeType("HDC") long paramLong, int paramInt1, int paramInt2, @NativeType("int const *") int[] paramArrayOfint, @NativeType("FLOAT *") float[] paramArrayOffloat) {
/* 255 */     long l = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribfvARB;
/* 256 */     if (Checks.CHECKS) {
/* 257 */       Checks.check(l);
/* 258 */       Checks.check(paramLong);
/* 259 */       Checks.check(paramArrayOffloat, paramArrayOfint.length);
/*     */     } 
/* 261 */     return (JNI.callPPPI(paramLong, paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, paramArrayOffloat, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglChoosePixelFormatARB(@NativeType("HDC") long paramLong, @NativeType("int const *") int[] paramArrayOfint1, @NativeType("FLOAT const *") float[] paramArrayOffloat, @NativeType("int *") int[] paramArrayOfint2, @NativeType("UINT *") int[] paramArrayOfint3) {
/* 267 */     long l = (GL.getCapabilitiesWGL()).wglChoosePixelFormatARB;
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(l);
/* 270 */       Checks.check(paramLong);
/* 271 */       Checks.checkNTSafe(paramArrayOfint1);
/* 272 */       Checks.checkNTSafe(paramArrayOffloat);
/* 273 */       Checks.check(paramArrayOfint3, 1);
/*     */     } 
/* 275 */     return (JNI.callPPPPPI(paramLong, paramArrayOfint1, paramArrayOffloat, paramArrayOfint2.length, paramArrayOfint2, paramArrayOfint3, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBPixelFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */