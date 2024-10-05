/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BufferUtils
/*     */ {
/*     */   public static ByteBuffer createByteBuffer(int paramInt) {
/*  75 */     return ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
/*     */   }
/*     */   
/*     */   static int getAllocationSize(int paramInt1, int paramInt2) {
/*  79 */     APIUtil.apiCheckAllocation(paramInt1, APIUtil.apiGetBytes(paramInt1, paramInt2), 2147483647L);
/*  80 */     return paramInt1 << paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShortBuffer createShortBuffer(int paramInt) {
/*  91 */     return createByteBuffer(getAllocationSize(paramInt, 1)).asShortBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharBuffer createCharBuffer(int paramInt) {
/* 102 */     return createByteBuffer(getAllocationSize(paramInt, 1)).asCharBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer createIntBuffer(int paramInt) {
/* 113 */     return createByteBuffer(getAllocationSize(paramInt, 2)).asIntBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LongBuffer createLongBuffer(int paramInt) {
/* 124 */     return createByteBuffer(getAllocationSize(paramInt, 3)).asLongBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer createCLongBuffer(int paramInt) {
/* 135 */     return CLongBuffer.allocateDirect(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FloatBuffer createFloatBuffer(int paramInt) {
/* 146 */     return createByteBuffer(getAllocationSize(paramInt, 2)).asFloatBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DoubleBuffer createDoubleBuffer(int paramInt) {
/* 157 */     return createByteBuffer(getAllocationSize(paramInt, 3)).asDoubleBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer createPointerBuffer(int paramInt) {
/* 168 */     return PointerBuffer.allocateDirect(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(ByteBuffer paramByteBuffer) {
/* 178 */     MemoryUtil.memSet(paramByteBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(ShortBuffer paramShortBuffer) {
/* 185 */     MemoryUtil.memSet(paramShortBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(CharBuffer paramCharBuffer) {
/* 192 */     MemoryUtil.memSet(paramCharBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(IntBuffer paramIntBuffer) {
/* 199 */     MemoryUtil.memSet(paramIntBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(FloatBuffer paramFloatBuffer) {
/* 206 */     MemoryUtil.memSet(paramFloatBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(LongBuffer paramLongBuffer) {
/* 213 */     MemoryUtil.memSet(paramLongBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(DoubleBuffer paramDoubleBuffer) {
/* 220 */     MemoryUtil.memSet(paramDoubleBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends CustomBuffer<T>> void zeroBuffer(T paramT) {
/* 227 */     MemoryUtil.memSet((CustomBuffer)paramT, 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\BufferUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */