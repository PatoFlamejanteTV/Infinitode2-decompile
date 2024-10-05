/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STBImageWrite
/*     */ {
/*     */   static {
/*  71 */     LibSTB.initialize();
/*     */   }
/*     */   protected STBImageWrite() {
/*  74 */     throw new UnsupportedOperationException();
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
/*     */   public static boolean stbi_write_png(@NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer2, int paramInt4) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.checkNT1(paramByteBuffer1);
/* 106 */       Checks.check(paramByteBuffer2, ((paramInt4 != 0) ? paramInt4 : (paramInt1 * paramInt3)) * paramInt2);
/*     */     } 
/* 108 */     return (nstbi_write_png(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4) != 0);
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
/*     */   public static boolean stbi_write_png(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt4) {
/* 133 */     if (Checks.CHECKS)
/* 134 */       Checks.check(paramByteBuffer, ((paramInt4 != 0) ? paramInt4 : (paramInt1 * paramInt3)) * paramInt2); 
/*     */     MemoryStack memoryStack;
/* 136 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 138 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 140 */         (nstbi_write_png(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer), paramInt4) != 0);
/*     */     } finally {
/* 142 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_png_compression_level() {
/*     */     long l;
/* 153 */     return MemoryUtil.memIntBuffer(l = nstbi_write_png_compression_level(), 1);
/*     */   }
/*     */ 
/*     */   
/* 157 */   public static final IntBuffer stbi_write_png_compression_level = stbi_write_png_compression_level();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_force_png_filter() {
/*     */     long l;
/* 166 */     return MemoryUtil.memIntBuffer(l = nstbi_write_force_png_filter(), 1);
/*     */   }
/*     */ 
/*     */   
/* 170 */   public static final IntBuffer stbi_write_force_png_filter = stbi_write_force_png_filter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char * (*) (unsigned char *, int, int *, int) *")
/*     */   private static PointerBuffer stbi_zlib_compress() {
/*     */     long l;
/* 179 */     return MemoryUtil.memPointerBuffer(l = nstbi_zlib_compress(), 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public static final PointerBuffer stbi_zlib_compress = stbi_zlib_compress();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static boolean stbi_write_bmp(@NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.checkNT1(paramByteBuffer1);
/* 211 */       Checks.check(paramByteBuffer2, paramInt1 * paramInt2 * paramInt3);
/*     */     } 
/* 213 */     return (nstbi_write_bmp(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2)) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_bmp(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 231 */     if (Checks.CHECKS)
/* 232 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3); 
/*     */     MemoryStack memoryStack;
/* 234 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 236 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 238 */         (nstbi_write_bmp(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*     */     } finally {
/* 240 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static boolean stbi_write_tga(@NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.checkNT1(paramByteBuffer1);
/* 267 */       Checks.check(paramByteBuffer2, paramInt1 * paramInt2 * paramInt3);
/*     */     } 
/* 269 */     return (nstbi_write_tga(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2)) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_tga(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 288 */     if (Checks.CHECKS)
/* 289 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3); 
/*     */     MemoryStack memoryStack;
/* 291 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 293 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 295 */         (nstbi_write_tga(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*     */     } finally {
/* 297 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_tga_with_rle() {
/*     */     long l;
/* 308 */     return MemoryUtil.memIntBuffer(l = nstbi_write_tga_with_rle(), 1);
/*     */   }
/*     */ 
/*     */   
/* 312 */   public static final IntBuffer stbi_write_tga_with_rle = stbi_write_tga_with_rle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") FloatBuffer paramFloatBuffer) {
/* 335 */     if (Checks.CHECKS) {
/* 336 */       Checks.checkNT1(paramByteBuffer);
/* 337 */       Checks.check(paramFloatBuffer, paramInt1 * paramInt2 * paramInt3);
/*     */     } 
/* 339 */     return (nstbi_write_hdr(MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer)) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") FloatBuffer paramFloatBuffer) {
/* 358 */     if (Checks.CHECKS)
/* 359 */       Checks.check(paramFloatBuffer, paramInt1 * paramInt2 * paramInt3); 
/*     */     MemoryStack memoryStack;
/* 361 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 363 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 365 */         (nstbi_write_hdr(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer)) != 0);
/*     */     } finally {
/* 367 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static boolean stbi_write_jpg(@NativeType("char const *") ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer2, int paramInt4) {
/* 393 */     if (Checks.CHECKS) {
/* 394 */       Checks.checkNT1(paramByteBuffer1);
/* 395 */       Checks.check(paramByteBuffer2, paramInt1 * paramInt2 * paramInt3);
/*     */     } 
/* 397 */     return (nstbi_write_jpg(MemoryUtil.memAddress(paramByteBuffer1), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer2), paramInt4) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_jpg(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt4) {
/* 417 */     if (Checks.CHECKS)
/* 418 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3); 
/*     */     MemoryStack memoryStack;
/* 420 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 422 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 424 */         (nstbi_write_jpg(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer), paramInt4) != 0);
/*     */     } finally {
/* 426 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
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
/*     */   public static boolean stbi_write_png_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt4) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.check(paramByteBuffer, ((paramInt4 != 0) ? paramInt4 : (paramInt1 * paramInt3)) * paramInt2);
/*     */     }
/* 453 */     return (nstbi_write_png_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer), paramInt4) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_bmp_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3);
/*     */     }
/* 478 */     return (nstbi_write_bmp_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer)) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_tga_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 500 */     if (Checks.CHECKS) {
/* 501 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3);
/*     */     }
/* 503 */     return (nstbi_write_tga_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer)) != 0);
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
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") FloatBuffer paramFloatBuffer) {
/* 525 */     if (Checks.CHECKS) {
/* 526 */       Checks.check(paramFloatBuffer, paramInt1 * paramInt2 * paramInt3);
/*     */     }
/* 528 */     return (nstbi_write_hdr_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer)) != 0);
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
/*     */   public static int stbi_write_jpg_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt4) {
/* 550 */     if (Checks.CHECKS) {
/* 551 */       Checks.check(paramByteBuffer, paramInt1 * paramInt2 * paramInt3);
/*     */     }
/* 553 */     return nstbi_write_jpg_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer), paramInt4);
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
/*     */   public static void stbi_flip_vertically_on_write(@NativeType("int") boolean paramBoolean) {
/* 567 */     nstbi_flip_vertically_on_write(paramBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") float[] paramArrayOffloat) {
/* 576 */     if (Checks.CHECKS) {
/* 577 */       Checks.checkNT1(paramByteBuffer);
/* 578 */       Checks.check(paramArrayOffloat, paramInt1 * paramInt2 * paramInt3);
/*     */     } 
/* 580 */     return (nstbi_write_hdr(MemoryUtil.memAddress(paramByteBuffer), paramInt1, paramInt2, paramInt3, paramArrayOffloat) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") float[] paramArrayOffloat) {
/* 586 */     if (Checks.CHECKS)
/* 587 */       Checks.check(paramArrayOffloat, paramInt1 * paramInt2 * paramInt3); 
/*     */     MemoryStack memoryStack;
/* 589 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 591 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*     */         
/* 593 */         (nstbi_write_hdr(l = memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3, paramArrayOffloat) != 0);
/*     */     } finally {
/* 595 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI paramSTBIWriteCallbackI, @NativeType("void *") long paramLong, int paramInt1, int paramInt2, int paramInt3, @NativeType("float const *") float[] paramArrayOffloat) {
/* 605 */     if (Checks.CHECKS) {
/* 606 */       Checks.check(paramArrayOffloat, paramInt1 * paramInt2 * paramInt3);
/*     */     }
/* 608 */     return (nstbi_write_hdr_to_func(paramSTBIWriteCallbackI.address(), paramLong, paramInt1, paramInt2, paramInt3, paramArrayOffloat) != 0);
/*     */   }
/*     */   
/*     */   public static native int nstbi_write_png(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*     */   
/*     */   private static native long nstbi_write_png_compression_level();
/*     */   
/*     */   private static native long nstbi_write_force_png_filter();
/*     */   
/*     */   private static native long nstbi_zlib_compress();
/*     */   
/*     */   public static native int nstbi_write_bmp(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native int nstbi_write_tga(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   private static native long nstbi_write_tga_with_rle();
/*     */   
/*     */   public static native int nstbi_write_hdr(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native int nstbi_write_jpg(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*     */   
/*     */   public static native int nstbi_write_png_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4);
/*     */   
/*     */   public static native int nstbi_write_bmp_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_tga_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_hdr_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_jpg_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4);
/*     */   
/*     */   public static native void nstbi_flip_vertically_on_write(int paramInt);
/*     */   
/*     */   public static native int nstbi_write_hdr(long paramLong, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat);
/*     */   
/*     */   public static native int nstbi_write_hdr_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBImageWrite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */