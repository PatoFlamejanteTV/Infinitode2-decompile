/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CheckIntrinsics;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class CLongBuffer
/*     */   extends CustomBuffer<CLongBuffer>
/*     */   implements Comparable<CLongBuffer>
/*     */ {
/*     */   protected CLongBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  25 */     super(paramLong, paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static CLongBuffer allocateDirect(int paramInt) {
/*  40 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(paramInt, CLONG_SHIFT));
/*  41 */     return new CLongBuffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer create(long paramLong, int paramInt) {
/*  51 */     return new CLongBuffer(paramLong, null, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer create(ByteBuffer paramByteBuffer) {
/*  60 */     int i = paramByteBuffer.remaining() >> CLONG_SHIFT;
/*  61 */     return new CLongBuffer(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer, -1, 0, i, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CLongBuffer self() {
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  71 */     return CLONG_SIZE;
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
/*  82 */     return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(nextGetIndex()) * CLONG_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer paramByteBuffer) {
/*  91 */     if (paramByteBuffer.remaining() < CLONG_SIZE) {
/*  92 */       throw new BufferUnderflowException();
/*     */     }
/*     */     
/*     */     try {
/*  96 */       return MemoryUtil.memGetCLong(MemoryUtil.memAddress(paramByteBuffer));
/*     */     } finally {
/*  98 */       paramByteBuffer.position(paramByteBuffer.position() + CLONG_SIZE);
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
/*     */   public CLongBuffer put(long paramLong) {
/* 114 */     MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(nextPutIndex()) * CLONG_SIZE, paramLong);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer paramByteBuffer, long paramLong) {
/* 125 */     if (paramByteBuffer.remaining() < CLONG_SIZE) {
/* 126 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/*     */     try {
/* 130 */       MemoryUtil.memPutCLong(MemoryUtil.memAddress(paramByteBuffer), paramLong); return;
/*     */     } finally {
/* 132 */       paramByteBuffer.position(paramByteBuffer.position() + CLONG_SIZE);
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
/* 146 */     return MemoryUtil.memGetCLong(this.address + Checks.check(paramInt, this.limit) * CLONG_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer paramByteBuffer, int paramInt) {
/* 156 */     CheckIntrinsics.checkFromIndexSize(paramInt, CLONG_SIZE, paramByteBuffer.limit());
/* 157 */     return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(paramByteBuffer) + paramInt);
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
/*     */   public CLongBuffer put(int paramInt, long paramLong) {
/* 173 */     MemoryUtil.memPutCLong(this.address + Checks.check(paramInt, this.limit) * CLONG_SIZE, paramLong);
/* 174 */     return this;
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
/* 185 */     CheckIntrinsics.checkFromIndexSize(paramInt, CLONG_SIZE, paramByteBuffer.limit());
/* 186 */     MemoryUtil.memPutCLong(MemoryUtil.memAddress0(paramByteBuffer) + paramInt, paramLong);
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
/*     */   public CLongBuffer get(long[] paramArrayOflong) {
/* 205 */     return get(paramArrayOflong, 0, paramArrayOflong.length);
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
/*     */   public CLongBuffer get(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 236 */     if (CLONG_SIZE == 8) {
/* 237 */       MemoryUtil.memLongBuffer(address(), remaining()).get(paramArrayOflong, paramInt1, paramInt2);
/* 238 */       position(position() + paramInt2);
/*     */     } else {
/* 240 */       get32(paramArrayOflong, paramInt1, paramInt2);
/*     */     } 
/*     */     
/* 243 */     return this;
/*     */   }
/*     */   
/*     */   private void get32(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 247 */     CheckIntrinsics.checkFromIndexSize(paramInt1, paramInt2, paramArrayOflong.length);
/* 248 */     if (remaining() < paramInt2) {
/* 249 */       throw new BufferUnderflowException();
/*     */     }
/* 251 */     for (int i = paramInt1; i < paramInt1; i++) {
/* 252 */       paramArrayOflong[i] = get();
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
/*     */   public CLongBuffer put(long[] paramArrayOflong) {
/* 270 */     return put(paramArrayOflong, 0, paramArrayOflong.length);
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
/*     */   public CLongBuffer put(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 301 */     if (CLONG_SIZE == 8) {
/* 302 */       MemoryUtil.memLongBuffer(address(), remaining()).put(paramArrayOflong, paramInt1, paramInt2);
/* 303 */       position(position() + paramInt2);
/*     */     } else {
/* 305 */       put32(paramArrayOflong, paramInt1, paramInt2);
/*     */     } 
/*     */     
/* 308 */     return this;
/*     */   }
/*     */   
/*     */   private void put32(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 312 */     CheckIntrinsics.checkFromIndexSize(paramInt1, paramInt2, paramArrayOflong.length);
/* 313 */     if (remaining() < paramInt2) {
/* 314 */       throw new BufferOverflowException();
/*     */     }
/* 316 */     paramInt2 = paramInt1 + paramInt2;
/* 317 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 318 */       put(paramArrayOflong[paramInt1]);
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
/* 334 */     int i = 1;
/* 335 */     int j = position();
/* 336 */     for (int k = limit() - 1; k >= j; k--) {
/* 337 */       i = i * 31 + (int)get(k);
/*     */     }
/* 339 */     return i;
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
/* 362 */     if (!(paramObject instanceof CLongBuffer)) {
/* 363 */       return false;
/*     */     }
/* 365 */     paramObject = paramObject;
/* 366 */     if (remaining() != paramObject.remaining()) {
/* 367 */       return false;
/*     */     }
/* 369 */     int i = position();
/* 370 */     for (int j = limit() - 1, k = paramObject.limit() - 1; j >= i; j--, k--) {
/* 371 */       long l1 = get(j);
/* 372 */       long l2 = paramObject.get(k);
/* 373 */       if (l1 != l2) {
/* 374 */         return false;
/*     */       }
/*     */     } 
/* 377 */     return true;
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
/*     */   public int compareTo(CLongBuffer paramCLongBuffer) {
/* 392 */     int i = position() + Math.min(remaining(), paramCLongBuffer.remaining());
/* 393 */     for (int j = position(), k = paramCLongBuffer.position(); j < i; j++, k++) {
/* 394 */       long l1 = get(j);
/* 395 */       long l2 = paramCLongBuffer.get(k);
/* 396 */       if (l1 != l2) {
/*     */ 
/*     */         
/* 399 */         if (l1 < l2) {
/* 400 */           return -1;
/*     */         }
/* 402 */         return 1;
/*     */       } 
/* 404 */     }  return remaining() - paramCLongBuffer.remaining();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\CLongBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */