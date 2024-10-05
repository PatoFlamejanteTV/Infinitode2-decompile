/*     */ package org.lwjgl.system.libc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibCString
/*     */ {
/*     */   static {
/*  20 */     Library.initialize();
/*     */   }
/*     */   protected LibCString() {
/*  23 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") ByteBuffer paramByteBuffer, int paramInt) {
/*  45 */     return nmemset(MemoryUtil.memAddress(paramByteBuffer), paramInt, paramByteBuffer.remaining());
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") ShortBuffer paramShortBuffer, int paramInt) {
/*  58 */     return nmemset(MemoryUtil.memAddress(paramShortBuffer), paramInt, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L);
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") IntBuffer paramIntBuffer, int paramInt) {
/*  71 */     return nmemset(MemoryUtil.memAddress(paramIntBuffer), paramInt, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") LongBuffer paramLongBuffer, int paramInt) {
/*  84 */     return nmemset(MemoryUtil.memAddress(paramLongBuffer), paramInt, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") FloatBuffer paramFloatBuffer, int paramInt) {
/*  97 */     return nmemset(MemoryUtil.memAddress(paramFloatBuffer), paramInt, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") DoubleBuffer paramDoubleBuffer, int paramInt) {
/* 110 */     return nmemset(MemoryUtil.memAddress(paramDoubleBuffer), paramInt, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(paramByteBuffer1, paramByteBuffer2.remaining());
/*     */     }
/* 135 */     return nmemcpy(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") ShortBuffer paramShortBuffer1, @NativeType("void const *") ShortBuffer paramShortBuffer2) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(paramShortBuffer1, paramShortBuffer2.remaining());
/*     */     }
/* 151 */     return nmemcpy(MemoryUtil.memAddress(paramShortBuffer1), MemoryUtil.memAddress(paramShortBuffer2), Integer.toUnsignedLong(paramShortBuffer2.remaining()) << 1L);
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") IntBuffer paramIntBuffer1, @NativeType("void const *") IntBuffer paramIntBuffer2) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(paramIntBuffer1, paramIntBuffer2.remaining());
/*     */     }
/* 167 */     return nmemcpy(MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), Integer.toUnsignedLong(paramIntBuffer2.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") LongBuffer paramLongBuffer1, @NativeType("void const *") LongBuffer paramLongBuffer2) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.check(paramLongBuffer1, paramLongBuffer2.remaining());
/*     */     }
/* 183 */     return nmemcpy(MemoryUtil.memAddress(paramLongBuffer1), MemoryUtil.memAddress(paramLongBuffer2), Integer.toUnsignedLong(paramLongBuffer2.remaining()) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") FloatBuffer paramFloatBuffer1, @NativeType("void const *") FloatBuffer paramFloatBuffer2) {
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(paramFloatBuffer1, paramFloatBuffer2.remaining());
/*     */     }
/* 199 */     return nmemcpy(MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), Integer.toUnsignedLong(paramFloatBuffer2.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") DoubleBuffer paramDoubleBuffer1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer2) {
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(paramDoubleBuffer1, paramDoubleBuffer2.remaining());
/*     */     }
/* 215 */     return nmemcpy(MemoryUtil.memAddress(paramDoubleBuffer1), MemoryUtil.memAddress(paramDoubleBuffer2), Integer.toUnsignedLong(paramDoubleBuffer2.remaining()) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(paramByteBuffer1, paramByteBuffer2.remaining());
/*     */     }
/* 243 */     return nmemmove(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") ShortBuffer paramShortBuffer1, @NativeType("void const *") ShortBuffer paramShortBuffer2) {
/* 259 */     if (Checks.CHECKS) {
/* 260 */       Checks.check(paramShortBuffer1, paramShortBuffer2.remaining());
/*     */     }
/* 262 */     return nmemmove(MemoryUtil.memAddress(paramShortBuffer1), MemoryUtil.memAddress(paramShortBuffer2), Integer.toUnsignedLong(paramShortBuffer2.remaining()) << 1L);
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") IntBuffer paramIntBuffer1, @NativeType("void const *") IntBuffer paramIntBuffer2) {
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(paramIntBuffer1, paramIntBuffer2.remaining());
/*     */     }
/* 281 */     return nmemmove(MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), Integer.toUnsignedLong(paramIntBuffer2.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") LongBuffer paramLongBuffer1, @NativeType("void const *") LongBuffer paramLongBuffer2) {
/* 297 */     if (Checks.CHECKS) {
/* 298 */       Checks.check(paramLongBuffer1, paramLongBuffer2.remaining());
/*     */     }
/* 300 */     return nmemmove(MemoryUtil.memAddress(paramLongBuffer1), MemoryUtil.memAddress(paramLongBuffer2), Integer.toUnsignedLong(paramLongBuffer2.remaining()) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") FloatBuffer paramFloatBuffer1, @NativeType("void const *") FloatBuffer paramFloatBuffer2) {
/* 316 */     if (Checks.CHECKS) {
/* 317 */       Checks.check(paramFloatBuffer1, paramFloatBuffer2.remaining());
/*     */     }
/* 319 */     return nmemmove(MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), Integer.toUnsignedLong(paramFloatBuffer2.remaining()) << 2L);
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
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") DoubleBuffer paramDoubleBuffer1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer2) {
/* 335 */     if (Checks.CHECKS) {
/* 336 */       Checks.check(paramDoubleBuffer1, paramDoubleBuffer2.remaining());
/*     */     }
/* 338 */     return nmemmove(MemoryUtil.memAddress(paramDoubleBuffer1), MemoryUtil.memAddress(paramDoubleBuffer2), Integer.toUnsignedLong(paramDoubleBuffer2.remaining()) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("size_t")
/*     */   public static long strlen(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 347 */     if (Checks.CHECKS) {
/* 348 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 350 */     return nstrlen(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char *")
/*     */   public static String strerror(int paramInt) {
/*     */     long l;
/* 363 */     return MemoryUtil.memASCIISafe(l = nstrerror(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") byte[] paramArrayOfbyte, int paramInt) {
/* 372 */     return nmemset(paramArrayOfbyte, paramInt, Integer.toUnsignedLong(paramArrayOfbyte.length));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") short[] paramArrayOfshort, int paramInt) {
/* 381 */     return nmemset(paramArrayOfshort, paramInt, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") int[] paramArrayOfint, int paramInt) {
/* 390 */     return nmemset(paramArrayOfint, paramInt, Integer.toUnsignedLong(paramArrayOfint.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") long[] paramArrayOflong, int paramInt) {
/* 399 */     return nmemset(paramArrayOflong, paramInt, Integer.toUnsignedLong(paramArrayOflong.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") float[] paramArrayOffloat, int paramInt) {
/* 408 */     return nmemset(paramArrayOffloat, paramInt, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memset(@NativeType("void *") double[] paramArrayOfdouble, int paramInt) {
/* 417 */     return nmemset(paramArrayOfdouble, paramInt, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") byte[] paramArrayOfbyte1, @NativeType("void const *") byte[] paramArrayOfbyte2) {
/* 426 */     if (Checks.CHECKS) {
/* 427 */       Checks.check(paramArrayOfbyte1, paramArrayOfbyte2.length);
/*     */     }
/* 429 */     return nmemcpy(paramArrayOfbyte1, paramArrayOfbyte2, Integer.toUnsignedLong(paramArrayOfbyte2.length));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") short[] paramArrayOfshort1, @NativeType("void const *") short[] paramArrayOfshort2) {
/* 438 */     if (Checks.CHECKS) {
/* 439 */       Checks.check(paramArrayOfshort1, paramArrayOfshort2.length);
/*     */     }
/* 441 */     return nmemcpy(paramArrayOfshort1, paramArrayOfshort2, Integer.toUnsignedLong(paramArrayOfshort2.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") int[] paramArrayOfint1, @NativeType("void const *") int[] paramArrayOfint2) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.check(paramArrayOfint1, paramArrayOfint2.length);
/*     */     }
/* 453 */     return nmemcpy(paramArrayOfint1, paramArrayOfint2, Integer.toUnsignedLong(paramArrayOfint2.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") long[] paramArrayOflong1, @NativeType("void const *") long[] paramArrayOflong2) {
/* 462 */     if (Checks.CHECKS) {
/* 463 */       Checks.check(paramArrayOflong1, paramArrayOflong2.length);
/*     */     }
/* 465 */     return nmemcpy(paramArrayOflong1, paramArrayOflong2, Integer.toUnsignedLong(paramArrayOflong2.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") float[] paramArrayOffloat1, @NativeType("void const *") float[] paramArrayOffloat2) {
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(paramArrayOffloat1, paramArrayOffloat2.length);
/*     */     }
/* 477 */     return nmemcpy(paramArrayOffloat1, paramArrayOffloat2, Integer.toUnsignedLong(paramArrayOffloat2.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memcpy(@NativeType("void *") double[] paramArrayOfdouble1, @NativeType("void const *") double[] paramArrayOfdouble2) {
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(paramArrayOfdouble1, paramArrayOfdouble2.length);
/*     */     }
/* 489 */     return nmemcpy(paramArrayOfdouble1, paramArrayOfdouble2, Integer.toUnsignedLong(paramArrayOfdouble2.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") byte[] paramArrayOfbyte1, @NativeType("void const *") byte[] paramArrayOfbyte2) {
/* 498 */     if (Checks.CHECKS) {
/* 499 */       Checks.check(paramArrayOfbyte1, paramArrayOfbyte2.length);
/*     */     }
/* 501 */     return nmemmove(paramArrayOfbyte1, paramArrayOfbyte2, Integer.toUnsignedLong(paramArrayOfbyte2.length));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") short[] paramArrayOfshort1, @NativeType("void const *") short[] paramArrayOfshort2) {
/* 510 */     if (Checks.CHECKS) {
/* 511 */       Checks.check(paramArrayOfshort1, paramArrayOfshort2.length);
/*     */     }
/* 513 */     return nmemmove(paramArrayOfshort1, paramArrayOfshort2, Integer.toUnsignedLong(paramArrayOfshort2.length) << 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") int[] paramArrayOfint1, @NativeType("void const *") int[] paramArrayOfint2) {
/* 522 */     if (Checks.CHECKS) {
/* 523 */       Checks.check(paramArrayOfint1, paramArrayOfint2.length);
/*     */     }
/* 525 */     return nmemmove(paramArrayOfint1, paramArrayOfint2, Integer.toUnsignedLong(paramArrayOfint2.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") long[] paramArrayOflong1, @NativeType("void const *") long[] paramArrayOflong2) {
/* 534 */     if (Checks.CHECKS) {
/* 535 */       Checks.check(paramArrayOflong1, paramArrayOflong2.length);
/*     */     }
/* 537 */     return nmemmove(paramArrayOflong1, paramArrayOflong2, Integer.toUnsignedLong(paramArrayOflong2.length) << 3L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") float[] paramArrayOffloat1, @NativeType("void const *") float[] paramArrayOffloat2) {
/* 546 */     if (Checks.CHECKS) {
/* 547 */       Checks.check(paramArrayOffloat1, paramArrayOffloat2.length);
/*     */     }
/* 549 */     return nmemmove(paramArrayOffloat1, paramArrayOffloat2, Integer.toUnsignedLong(paramArrayOffloat2.length) << 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long memmove(@NativeType("void *") double[] paramArrayOfdouble1, @NativeType("void const *") double[] paramArrayOfdouble2) {
/* 558 */     if (Checks.CHECKS) {
/* 559 */       Checks.check(paramArrayOfdouble1, paramArrayOfdouble2.length);
/*     */     }
/* 561 */     return nmemmove(paramArrayOfdouble1, paramArrayOfdouble2, Integer.toUnsignedLong(paramArrayOfdouble2.length) << 3L);
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memset(@NativeType("void *") T paramT, @NativeType("int") int paramInt) {
/* 574 */     return nmemset(MemoryUtil.memAddress((CustomBuffer)paramT), paramInt, Integer.toUnsignedLong(paramT.remaining()) * paramT.sizeof());
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memcpy(@NativeType("void *") T paramT1, @NativeType("void const *") T paramT2) {
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check((CustomBuffer)paramT2, paramT1.remaining());
/*     */     }
/* 590 */     return nmemcpy(MemoryUtil.memAddress((CustomBuffer)paramT1), MemoryUtil.memAddress((CustomBuffer)paramT2), paramT2.remaining() * paramT2.sizeof());
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
/*     */   @NativeType("void *")
/*     */   public static <T extends CustomBuffer<T>> long memmove(@NativeType("void *") T paramT1, @NativeType("void const *") T paramT2) {
/* 606 */     if (Checks.CHECKS) {
/* 607 */       Checks.check((CustomBuffer)paramT2, paramT1.remaining());
/*     */     }
/* 609 */     return nmemmove(MemoryUtil.memAddress((CustomBuffer)paramT1), MemoryUtil.memAddress((CustomBuffer)paramT2), paramT2.remaining() * paramT2.sizeof());
/*     */   }
/*     */   
/*     */   public static native long nmemset(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native long nmemcpy(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nmemmove(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nstrlen(long paramLong);
/*     */   
/*     */   public static native long nstrerror(int paramInt);
/*     */   
/*     */   public static native long nmemset(byte[] paramArrayOfbyte, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(short[] paramArrayOfshort, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(int[] paramArrayOfint, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(long[] paramArrayOflong, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(float[] paramArrayOffloat, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemset(double[] paramArrayOfdouble, int paramInt, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*     */   
/*     */   public static native long nmemcpy(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*     */   
/*     */   public static native long nmemmove(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libc\LibCString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */