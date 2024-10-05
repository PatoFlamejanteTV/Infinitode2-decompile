/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.CheckIntrinsics;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class PointerBuffer
/*     */   extends CustomBuffer<PointerBuffer> implements Comparable<PointerBuffer> {
/*     */   protected PointerBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  20 */     super(paramLong, paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static PointerBuffer allocateDirect(int paramInt) {
/*  35 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(paramInt, POINTER_SHIFT));
/*  36 */     return new PointerBuffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer create(long paramLong, int paramInt) {
/*  46 */     return new PointerBuffer(paramLong, null, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer create(ByteBuffer paramByteBuffer) {
/*  55 */     int i = paramByteBuffer.remaining() >> POINTER_SHIFT;
/*  56 */     return new PointerBuffer(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer, -1, 0, i, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PointerBuffer self() {
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  66 */     return POINTER_SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long get() {
/*  77 */     return MemoryUtil.memGetAddress(this.address + Integer.toUnsignedLong(nextGetIndex()) * POINTER_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer paramByteBuffer) {
/*  86 */     if (paramByteBuffer.remaining() < POINTER_SIZE) {
/*  87 */       throw new BufferUnderflowException();
/*     */     }
/*     */     
/*     */     try {
/*  91 */       return MemoryUtil.memGetAddress(MemoryUtil.memAddress(paramByteBuffer));
/*     */     } finally {
/*  93 */       paramByteBuffer.position(paramByteBuffer.position() + POINTER_SIZE);
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
/*     */   public PointerBuffer put(long paramLong) {
/* 109 */     MemoryUtil.memPutAddress(this.address + Integer.toUnsignedLong(nextPutIndex()) * POINTER_SIZE, paramLong);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer paramByteBuffer, long paramLong) {
/* 120 */     if (paramByteBuffer.remaining() < POINTER_SIZE) {
/* 121 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/*     */     try {
/* 125 */       MemoryUtil.memPutAddress(MemoryUtil.memAddress(paramByteBuffer), paramLong); return;
/*     */     } finally {
/* 127 */       paramByteBuffer.position(paramByteBuffer.position() + POINTER_SIZE);
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
/*     */   public long get(int paramInt) {
/* 141 */     return MemoryUtil.memGetAddress(this.address + Checks.check(paramInt, this.limit) * POINTER_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer paramByteBuffer, int paramInt) {
/* 151 */     CheckIntrinsics.checkFromIndexSize(paramInt, POINTER_SIZE, paramByteBuffer.limit());
/* 152 */     return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(paramByteBuffer) + paramInt);
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
/*     */   public PointerBuffer put(int paramInt, long paramLong) {
/* 168 */     MemoryUtil.memPutAddress(this.address + Checks.check(paramInt, this.limit) * POINTER_SIZE, paramLong);
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
/* 180 */     CheckIntrinsics.checkFromIndexSize(paramInt, POINTER_SIZE, paramByteBuffer.limit());
/* 181 */     MemoryUtil.memPutAddress(MemoryUtil.memAddress0(paramByteBuffer) + paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(Pointer paramPointer) {
/* 188 */     put(paramPointer.address());
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, Pointer paramPointer) {
/* 194 */     put(paramInt, paramPointer.address());
/* 195 */     return this;
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
/*     */   public PointerBuffer put(ByteBuffer paramByteBuffer) {
/* 210 */     put(MemoryUtil.memAddress(paramByteBuffer));
/* 211 */     return this;
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
/*     */   public PointerBuffer put(ShortBuffer paramShortBuffer) {
/* 224 */     put(MemoryUtil.memAddress(paramShortBuffer));
/* 225 */     return this;
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
/*     */   public PointerBuffer put(IntBuffer paramIntBuffer) {
/* 238 */     put(MemoryUtil.memAddress(paramIntBuffer));
/* 239 */     return this;
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
/*     */   public PointerBuffer put(LongBuffer paramLongBuffer) {
/* 252 */     put(MemoryUtil.memAddress(paramLongBuffer));
/* 253 */     return this;
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
/*     */   public PointerBuffer put(FloatBuffer paramFloatBuffer) {
/* 266 */     put(MemoryUtil.memAddress(paramFloatBuffer));
/* 267 */     return this;
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
/*     */   public PointerBuffer put(DoubleBuffer paramDoubleBuffer) {
/* 280 */     put(MemoryUtil.memAddress(paramDoubleBuffer));
/* 281 */     return this;
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
/*     */   public PointerBuffer putAddressOf(CustomBuffer<?> paramCustomBuffer) {
/* 294 */     put(MemoryUtil.memAddress(paramCustomBuffer));
/* 295 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, ByteBuffer paramByteBuffer) {
/* 302 */     put(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/* 303 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, ShortBuffer paramShortBuffer) {
/* 308 */     put(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/* 309 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, IntBuffer paramIntBuffer) {
/* 314 */     put(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/* 315 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, LongBuffer paramLongBuffer) {
/* 320 */     put(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/* 321 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, FloatBuffer paramFloatBuffer) {
/* 326 */     put(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/* 327 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int paramInt, DoubleBuffer paramDoubleBuffer) {
/* 332 */     put(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/* 333 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer putAddressOf(int paramInt, CustomBuffer<?> paramCustomBuffer) {
/* 338 */     put(paramInt, MemoryUtil.memAddress(paramCustomBuffer));
/* 339 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getByteBuffer(int paramInt) {
/* 350 */     return MemoryUtil.memByteBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortBuffer getShortBuffer(int paramInt) {
/* 358 */     return MemoryUtil.memShortBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntBuffer getIntBuffer(int paramInt) {
/* 366 */     return MemoryUtil.memIntBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongBuffer getLongBuffer(int paramInt) {
/* 374 */     return MemoryUtil.memLongBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatBuffer getFloatBuffer(int paramInt) {
/* 382 */     return MemoryUtil.memFloatBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DoubleBuffer getDoubleBuffer(int paramInt) {
/* 390 */     return MemoryUtil.memDoubleBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer getPointerBuffer(int paramInt) {
/* 398 */     return MemoryUtil.memPointerBuffer(get(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringASCII() {
/* 406 */     return MemoryUtil.memASCII(get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringUTF8() {
/* 414 */     return MemoryUtil.memUTF8(get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringUTF16() {
/* 422 */     return MemoryUtil.memUTF16(get());
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer getByteBuffer(int paramInt1, int paramInt2) {
/* 427 */     return MemoryUtil.memByteBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public ShortBuffer getShortBuffer(int paramInt1, int paramInt2) {
/* 430 */     return MemoryUtil.memShortBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public IntBuffer getIntBuffer(int paramInt1, int paramInt2) {
/* 433 */     return MemoryUtil.memIntBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public LongBuffer getLongBuffer(int paramInt1, int paramInt2) {
/* 436 */     return MemoryUtil.memLongBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public FloatBuffer getFloatBuffer(int paramInt1, int paramInt2) {
/* 439 */     return MemoryUtil.memFloatBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public DoubleBuffer getDoubleBuffer(int paramInt1, int paramInt2) {
/* 442 */     return MemoryUtil.memDoubleBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public PointerBuffer getPointerBuffer(int paramInt1, int paramInt2) {
/* 445 */     return MemoryUtil.memPointerBuffer(get(paramInt1), paramInt2);
/*     */   }
/*     */   public String getStringASCII(int paramInt) {
/* 448 */     return MemoryUtil.memASCII(get(paramInt));
/*     */   }
/*     */   public String getStringUTF8(int paramInt) {
/* 451 */     return MemoryUtil.memUTF8(get(paramInt));
/*     */   }
/*     */   public String getStringUTF16(int paramInt) {
/* 454 */     return MemoryUtil.memUTF16(get(paramInt));
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
/*     */   public PointerBuffer get(long[] paramArrayOflong) {
/* 472 */     return get(paramArrayOflong, 0, paramArrayOflong.length);
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
/*     */   public PointerBuffer get(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 503 */     if (BITS64) {
/* 504 */       MemoryUtil.memLongBuffer(address(), remaining()).get(paramArrayOflong, paramInt1, paramInt2);
/* 505 */       position(position() + paramInt2);
/*     */     } else {
/* 507 */       get32(paramArrayOflong, paramInt1, paramInt2);
/*     */     } 
/*     */     
/* 510 */     return this;
/*     */   }
/*     */   
/*     */   private void get32(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 514 */     CheckIntrinsics.checkFromIndexSize(paramInt1, paramInt2, paramArrayOflong.length);
/* 515 */     if (remaining() < paramInt2) {
/* 516 */       throw new BufferUnderflowException();
/*     */     }
/* 518 */     for (int i = paramInt1; i < paramInt1; i++) {
/* 519 */       paramArrayOflong[i] = get();
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
/*     */   public PointerBuffer put(long[] paramArrayOflong) {
/* 537 */     return put(paramArrayOflong, 0, paramArrayOflong.length);
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
/*     */   public PointerBuffer put(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 568 */     if (BITS64) {
/* 569 */       MemoryUtil.memLongBuffer(address(), remaining()).put(paramArrayOflong, paramInt1, paramInt2);
/* 570 */       position(position() + paramInt2);
/*     */     } else {
/* 572 */       put32(paramArrayOflong, paramInt1, paramInt2);
/*     */     } 
/*     */     
/* 575 */     return this;
/*     */   }
/*     */   
/*     */   private void put32(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 579 */     CheckIntrinsics.checkFromIndexSize(paramInt1, paramInt2, paramArrayOflong.length);
/* 580 */     if (remaining() < paramInt2) {
/* 581 */       throw new BufferOverflowException();
/*     */     }
/* 583 */     paramInt2 = paramInt1 + paramInt2;
/* 584 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 585 */       put(paramArrayOflong[paramInt1]);
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
/*     */   public int hashCode() {
/* 601 */     int i = 1;
/* 602 */     int j = position();
/* 603 */     for (int k = limit() - 1; k >= j; k--) {
/* 604 */       i = i * 31 + (int)get(k);
/*     */     }
/* 606 */     return i;
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
/*     */   public boolean equals(Object paramObject) {
/* 629 */     if (!(paramObject instanceof PointerBuffer)) {
/* 630 */       return false;
/*     */     }
/* 632 */     paramObject = paramObject;
/* 633 */     if (remaining() != paramObject.remaining()) {
/* 634 */       return false;
/*     */     }
/* 636 */     int i = position();
/* 637 */     for (int j = limit() - 1, k = paramObject.limit() - 1; j >= i; j--, k--) {
/* 638 */       long l1 = get(j);
/* 639 */       long l2 = paramObject.get(k);
/* 640 */       if (l1 != l2) {
/* 641 */         return false;
/*     */       }
/*     */     } 
/* 644 */     return true;
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
/*     */   public int compareTo(PointerBuffer paramPointerBuffer) {
/* 659 */     int i = position() + Math.min(remaining(), paramPointerBuffer.remaining());
/* 660 */     for (int j = position(), k = paramPointerBuffer.position(); j < i; j++, k++) {
/* 661 */       long l1 = get(j);
/* 662 */       long l2 = paramPointerBuffer.get(k);
/* 663 */       if (l1 != l2) {
/*     */ 
/*     */         
/* 666 */         if (l1 < l2) {
/* 667 */           return -1;
/*     */         }
/* 669 */         return 1;
/*     */       } 
/* 671 */     }  return remaining() - paramPointerBuffer.remaining();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\PointerBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */