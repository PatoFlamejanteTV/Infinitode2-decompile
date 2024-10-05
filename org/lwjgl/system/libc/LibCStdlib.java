/*     */ package org.lwjgl.system.libc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibCStdlib
/*     */ {
/*     */   static {
/*  21 */     Library.initialize();
/*     */   }
/*     */   protected LibCStdlib() {
/*  24 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer malloc(@NativeType("size_t") long paramLong) {
/*     */     long l;
/*  42 */     return MemoryUtil.memByteBufferSafe(l = nmalloc(paramLong), (int)paramLong);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer calloc(@NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2) {
/*     */     long l;
/*  62 */     return MemoryUtil.memByteBufferSafe(l = ncalloc(paramLong1, paramLong2), (int)paramLong1 * (int)paramLong2);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer realloc(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong) {
/*     */     long l;
/*  84 */     return MemoryUtil.memByteBufferSafe(l = nrealloc(MemoryUtil.memAddressSafe(paramByteBuffer), paramLong), (int)paramLong);
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
/*     */   public static void free(@NativeType("void *") ByteBuffer paramByteBuffer) {
/*  99 */     nfree(MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") ShortBuffer paramShortBuffer) {
/* 109 */     nfree(MemoryUtil.memAddressSafe(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") IntBuffer paramIntBuffer) {
/* 119 */     nfree(MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") LongBuffer paramLongBuffer) {
/* 129 */     nfree(MemoryUtil.memAddressSafe(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 139 */     nfree(MemoryUtil.memAddressSafe(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 149 */     nfree(MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(@NativeType("void *") PointerBuffer paramPointerBuffer) {
/* 159 */     nfree(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer aligned_alloc(@NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2) {
/*     */     long l;
/* 178 */     return MemoryUtil.memByteBufferSafe(l = naligned_alloc(paramLong1, paramLong2), (int)paramLong2);
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
/*     */   public static void aligned_free(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 192 */     naligned_free(MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") ShortBuffer paramShortBuffer) {
/* 201 */     naligned_free(MemoryUtil.memAddressSafe(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") IntBuffer paramIntBuffer) {
/* 210 */     naligned_free(MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") LongBuffer paramLongBuffer) {
/* 219 */     naligned_free(MemoryUtil.memAddressSafe(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 228 */     naligned_free(MemoryUtil.memAddressSafe(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 237 */     naligned_free(MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aligned_free(@NativeType("void *") PointerBuffer paramPointerBuffer) {
/* 246 */     naligned_free(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
/*     */   }
/*     */   
/*     */   public static native long nmalloc(long paramLong);
/*     */   
/*     */   public static native long ncalloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nrealloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nfree(long paramLong);
/*     */   
/*     */   public static native long naligned_alloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void naligned_free(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libc\LibCStdlib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */