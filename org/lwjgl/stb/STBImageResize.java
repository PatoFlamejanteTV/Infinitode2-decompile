/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class STBImageResize
/*     */ {
/*     */   public static final int STBIR_ALPHA_CHANNEL_NONE = -1;
/*     */   public static final int STBIR_FLAG_ALPHA_PREMULTIPLIED = 1;
/*     */   public static final int STBIR_FLAG_ALPHA_USES_COLORSPACE = 2;
/*     */   public static final int STBIR_EDGE_CLAMP = 1;
/*     */   public static final int STBIR_EDGE_REFLECT = 2;
/*     */   public static final int STBIR_EDGE_WRAP = 3;
/*     */   public static final int STBIR_EDGE_ZERO = 4;
/*     */   public static final int STBIR_FILTER_DEFAULT = 0;
/*     */   public static final int STBIR_FILTER_BOX = 1;
/*     */   public static final int STBIR_FILTER_TRIANGLE = 2;
/*     */   public static final int STBIR_FILTER_CUBICBSPLINE = 3;
/*     */   public static final int STBIR_FILTER_CATMULLROM = 4;
/*     */   public static final int STBIR_FILTER_MITCHELL = 5;
/*     */   public static final int STBIR_COLORSPACE_LINEAR = 0;
/*     */   public static final int STBIR_COLORSPACE_SRGB = 1;
/*     */   public static final int STBIR_TYPE_UINT8 = 0;
/*     */   public static final int STBIR_TYPE_UINT16 = 1;
/*     */   public static final int STBIR_TYPE_UINT32 = 2;
/*     */   public static final int STBIR_TYPE_FLOAT = 3;
/*     */   
/*     */   static {
/*  66 */     LibSTB.initialize();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected STBImageResize() {
/* 153 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint8(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 187 */     if (Checks.CHECKS) {
/* 188 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : paramInt3));
/* 189 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : paramInt6));
/*     */     } 
/* 191 */     return (nstbir_resize_uint8(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_float(@NativeType("float const *") FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") FloatBuffer paramFloatBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(paramFloatBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 2)));
/* 218 */       Checks.check(paramFloatBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 2)));
/*     */     } 
/* 220 */     return (nstbir_resize_float(MemoryUtil.memAddress(paramFloatBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer2), paramInt4, paramInt5, paramInt6, paramInt7) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint8_srgb(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : paramInt3));
/* 257 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : paramInt6));
/*     */     } 
/* 259 */     return (nstbir_resize_uint8_srgb(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint8_srgb_edgemode(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10) {
/* 287 */     if (Checks.CHECKS) {
/* 288 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : paramInt3));
/* 289 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : paramInt6));
/*     */     } 
/* 291 */     return (nstbir_resize_uint8_srgb_edgemode(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint8_generic(@NativeType("unsigned char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10, @NativeType("stbir_filter") int paramInt11, @NativeType("stbir_colorspace") int paramInt12) {
/* 321 */     if (Checks.CHECKS) {
/* 322 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : paramInt3));
/* 323 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : paramInt6));
/*     */     } 
/* 325 */     return (nstbir_resize_uint8_generic(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, 0L) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint16_generic(@NativeType("stbir_uint16 const *") ShortBuffer paramShortBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("stbir_uint16 *") ShortBuffer paramShortBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10, @NativeType("stbir_filter") int paramInt11, @NativeType("stbir_colorspace") int paramInt12) {
/* 355 */     if (Checks.CHECKS) {
/* 356 */       Checks.check(paramShortBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 1)));
/* 357 */       Checks.check(paramShortBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 1)));
/*     */     } 
/* 359 */     return (nstbir_resize_uint16_generic(MemoryUtil.memAddress(paramShortBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, 0L) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_float_generic(@NativeType("float const *") FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") FloatBuffer paramFloatBuffer2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10, @NativeType("stbir_filter") int paramInt11, @NativeType("stbir_colorspace") int paramInt12) {
/* 389 */     if (Checks.CHECKS) {
/* 390 */       Checks.check(paramFloatBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 2)));
/* 391 */       Checks.check(paramFloatBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 2)));
/*     */     } 
/* 393 */     return (nstbir_resize_float_generic(MemoryUtil.memAddress(paramFloatBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, 0L) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize(@NativeType("void const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, @NativeType("stbir_datatype") int paramInt7, int paramInt8, int paramInt9, int paramInt10, @NativeType("stbir_edge") int paramInt11, @NativeType("stbir_edge") int paramInt12, @NativeType("stbir_filter") int paramInt13, @NativeType("stbir_filter") int paramInt14, @NativeType("stbir_colorspace") int paramInt15) {
/* 426 */     if (Checks.CHECKS) {
/* 427 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt8 << getTypeShift(paramInt7)) : paramInt3));
/* 428 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt8 << getTypeShift(paramInt7)) : paramInt6));
/*     */     } 
/* 430 */     return (nstbir_resize(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, 0L) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_subpixel(@NativeType("void const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, @NativeType("stbir_datatype") int paramInt7, int paramInt8, int paramInt9, int paramInt10, @NativeType("stbir_edge") int paramInt11, @NativeType("stbir_edge") int paramInt12, @NativeType("stbir_filter") int paramInt13, @NativeType("stbir_filter") int paramInt14, @NativeType("stbir_colorspace") int paramInt15, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 467 */     if (Checks.CHECKS) {
/* 468 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt8 << getTypeShift(paramInt7)) : paramInt3));
/* 469 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt8 << getTypeShift(paramInt7)) : paramInt6));
/*     */     } 
/* 471 */     return (nstbir_resize_subpixel(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, 0L, paramFloat1, paramFloat2, paramFloat3, paramFloat4) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_region(@NativeType("void const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer2, int paramInt4, int paramInt5, int paramInt6, @NativeType("stbir_datatype") int paramInt7, int paramInt8, int paramInt9, int paramInt10, @NativeType("stbir_edge") int paramInt11, @NativeType("stbir_edge") int paramInt12, @NativeType("stbir_filter") int paramInt13, @NativeType("stbir_filter") int paramInt14, @NativeType("stbir_colorspace") int paramInt15, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check(paramByteBuffer1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt8 << getTypeShift(paramInt7)) : paramInt3));
/* 510 */       Checks.check(paramByteBuffer2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt8 << getTypeShift(paramInt7)) : paramInt6));
/*     */     } 
/* 512 */     return (nstbir_resize_region(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, 0L, paramFloat1, paramFloat2, paramFloat3, paramFloat4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_float(@NativeType("float const *") float[] paramArrayOffloat1, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") float[] paramArrayOffloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 521 */     if (Checks.CHECKS) {
/* 522 */       Checks.check(paramArrayOffloat1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 2)));
/* 523 */       Checks.check(paramArrayOffloat2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 2)));
/*     */     } 
/* 525 */     return (nstbir_resize_float(paramArrayOffloat1, paramInt1, paramInt2, paramInt3, paramArrayOffloat2, paramInt4, paramInt5, paramInt6, paramInt7) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_uint16_generic(@NativeType("stbir_uint16 const *") short[] paramArrayOfshort1, int paramInt1, int paramInt2, int paramInt3, @NativeType("stbir_uint16 *") short[] paramArrayOfshort2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10, @NativeType("stbir_filter") int paramInt11, @NativeType("stbir_colorspace") int paramInt12) {
/* 534 */     if (Checks.CHECKS) {
/* 535 */       Checks.check(paramArrayOfshort1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 1)));
/* 536 */       Checks.check(paramArrayOfshort2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 1)));
/*     */     } 
/* 538 */     return (nstbir_resize_uint16_generic(paramArrayOfshort1, paramInt1, paramInt2, paramInt3, paramArrayOfshort2, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, 0L) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbir_resize_float_generic(@NativeType("float const *") float[] paramArrayOffloat1, int paramInt1, int paramInt2, int paramInt3, @NativeType("float *") float[] paramArrayOffloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @NativeType("stbir_edge") int paramInt10, @NativeType("stbir_filter") int paramInt11, @NativeType("stbir_colorspace") int paramInt12) {
/* 547 */     if (Checks.CHECKS) {
/* 548 */       Checks.check(paramArrayOffloat1, paramInt2 * ((paramInt3 == 0) ? (paramInt1 * paramInt7) : (paramInt3 >> 2)));
/* 549 */       Checks.check(paramArrayOffloat2, paramInt5 * ((paramInt6 == 0) ? (paramInt4 * paramInt7) : (paramInt6 >> 2)));
/*     */     } 
/* 551 */     return (nstbir_resize_float_generic(paramArrayOffloat1, paramInt1, paramInt2, paramInt3, paramArrayOffloat2, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, 0L) != 0);
/*     */   }
/*     */   
/*     */   private static int getTypeShift(int paramInt) {
/* 555 */     switch (paramInt) {
/*     */       case 0:
/* 557 */         return 0;
/*     */       case 1:
/* 559 */         return 1;
/*     */     } 
/* 561 */     return 2;
/*     */   }
/*     */   
/*     */   public static native int nstbir_resize_uint8(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native int nstbir_resize_float(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native int nstbir_resize_uint8_srgb(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
/*     */   
/*     */   public static native int nstbir_resize_uint8_srgb_edgemode(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
/*     */   
/*     */   public static native int nstbir_resize_uint8_generic(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong3);
/*     */   
/*     */   public static native int nstbir_resize_uint16_generic(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong3);
/*     */   
/*     */   public static native int nstbir_resize_float_generic(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong3);
/*     */   
/*     */   public static native int nstbir_resize(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong3);
/*     */   
/*     */   public static native int nstbir_resize_subpixel(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   public static native int nstbir_resize_region(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   public static native int nstbir_resize_float(float[] paramArrayOffloat1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   public static native int nstbir_resize_uint16_generic(short[] paramArrayOfshort1, int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfshort2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong);
/*     */   
/*     */   public static native int nstbir_resize_float_generic(float[] paramArrayOffloat1, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBImageResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */