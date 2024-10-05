/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.InvalidMarkException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CustomBuffer<SELF extends CustomBuffer<SELF>>
/*     */   extends Pointer.Default
/*     */ {
/*     */   protected ByteBuffer container;
/*     */   protected int mark;
/*     */   protected int position;
/*     */   protected int limit;
/*     */   protected int capacity;
/*     */   
/*     */   protected CustomBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  25 */     super(paramLong);
/*     */     
/*  27 */     this.container = paramByteBuffer;
/*     */     
/*  29 */     this.mark = paramInt1;
/*  30 */     this.position = paramInt2;
/*  31 */     this.limit = paramInt3;
/*  32 */     this.capacity = paramInt4;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract int sizeof();
/*     */ 
/*     */   
/*     */   public long address0() {
/*  40 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long address() {
/*  46 */     return this.address + Integer.toUnsignedLong(this.position) * sizeof();
/*     */   }
/*     */ 
/*     */   
/*     */   public long address(int paramInt) {
/*  51 */     return this.address + Integer.toUnsignedLong(paramInt) * sizeof();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/*  60 */     MemoryUtil.nmemFree(this.address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/*  69 */     return this.capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int position() {
/*  78 */     return this.position;
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
/*     */   public SELF position(int paramInt) {
/*  91 */     if (paramInt < 0 || this.limit < paramInt) {
/*  92 */       throw new IllegalArgumentException();
/*     */     }
/*  94 */     this.position = paramInt;
/*  95 */     if (paramInt < this.mark) {
/*  96 */       this.mark = -1;
/*     */     }
/*  98 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int limit() {
/* 107 */     return this.limit;
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
/*     */   public SELF limit(int paramInt) {
/* 121 */     if (paramInt < 0 || this.capacity < paramInt) {
/* 122 */       throw new IllegalArgumentException();
/*     */     }
/* 124 */     this.limit = paramInt;
/* 125 */     if (paramInt < this.position) {
/* 126 */       this.position = paramInt;
/*     */     }
/* 128 */     if (paramInt < this.mark) {
/* 129 */       this.mark = -1;
/*     */     }
/* 131 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SELF mark() {
/* 140 */     this.mark = this.position;
/* 141 */     return self();
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
/*     */   public SELF reset() {
/*     */     int i;
/* 155 */     if ((i = this.mark) < 0) {
/* 156 */       throw new InvalidMarkException();
/*     */     }
/* 158 */     this.position = i;
/* 159 */     return self();
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
/*     */   public SELF clear() {
/* 177 */     this.position = 0;
/* 178 */     this.limit = this.capacity;
/* 179 */     this.mark = -1;
/* 180 */     return self();
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
/*     */   public SELF flip() {
/* 200 */     this.limit = this.position;
/* 201 */     this.position = 0;
/* 202 */     this.mark = -1;
/* 203 */     return self();
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
/*     */   public SELF rewind() {
/* 220 */     this.position = 0;
/* 221 */     this.mark = -1;
/* 222 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remaining() {
/* 231 */     return this.limit - this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRemaining() {
/* 240 */     return (this.position < this.limit);
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
/*     */   public SELF slice() {
/*     */     try {
/* 258 */       CustomBuffer customBuffer = (CustomBuffer)UNSAFE.allocateInstance(getClass());
/* 259 */     } catch (InstantiationException instantiationException) {
/* 260 */       throw new UnsupportedOperationException(instantiationException);
/*     */     } 
/*     */     
/* 263 */     UNSAFE.putLong(instantiationException, ADDRESS, this.address + Integer.toUnsignedLong(this.position) * sizeof());
/* 264 */     UNSAFE.putInt(instantiationException, BUFFER_MARK, -1);
/* 265 */     UNSAFE.putInt(instantiationException, BUFFER_LIMIT, remaining());
/* 266 */     UNSAFE.putInt(instantiationException, BUFFER_CAPACITY, remaining());
/* 267 */     UNSAFE.putObject(instantiationException, BUFFER_CONTAINER, this.container);
/*     */     
/* 269 */     return (SELF)instantiationException;
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
/*     */   public SELF slice(int paramInt1, int paramInt2) {
/* 284 */     int i = this.position + paramInt1;
/* 285 */     if (paramInt1 < 0 || this.limit < paramInt1) {
/* 286 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/* 289 */     if (paramInt2 < 0 || this.capacity - i < paramInt2) {
/* 290 */       throw new IllegalArgumentException();
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 295 */       CustomBuffer customBuffer = (CustomBuffer)UNSAFE.allocateInstance(getClass());
/* 296 */     } catch (InstantiationException instantiationException) {
/* 297 */       throw new UnsupportedOperationException(instantiationException);
/*     */     } 
/*     */     
/* 300 */     UNSAFE.putLong(instantiationException, ADDRESS, this.address + Integer.toUnsignedLong(i) * sizeof());
/* 301 */     UNSAFE.putInt(instantiationException, BUFFER_MARK, -1);
/* 302 */     UNSAFE.putInt(instantiationException, BUFFER_LIMIT, paramInt2);
/* 303 */     UNSAFE.putInt(instantiationException, BUFFER_CAPACITY, paramInt2);
/* 304 */     UNSAFE.putObject(instantiationException, BUFFER_CONTAINER, this.container);
/*     */     
/* 306 */     return (SELF)instantiationException;
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
/*     */   public SELF duplicate() {
/*     */     try {
/* 323 */       CustomBuffer customBuffer = (CustomBuffer)UNSAFE.allocateInstance(getClass());
/* 324 */     } catch (InstantiationException instantiationException) {
/* 325 */       throw new UnsupportedOperationException(instantiationException);
/*     */     } 
/*     */     
/* 328 */     UNSAFE.putLong(instantiationException, ADDRESS, this.address);
/* 329 */     UNSAFE.putInt(instantiationException, BUFFER_MARK, this.mark);
/* 330 */     UNSAFE.putInt(instantiationException, BUFFER_POSITION, this.position);
/* 331 */     UNSAFE.putInt(instantiationException, BUFFER_LIMIT, this.limit);
/* 332 */     UNSAFE.putInt(instantiationException, BUFFER_CAPACITY, this.capacity);
/* 333 */     UNSAFE.putObject(instantiationException, BUFFER_CONTAINER, this.container);
/*     */     
/* 335 */     return (SELF)instantiationException;
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
/*     */   public SELF put(SELF paramSELF) {
/* 367 */     if (paramSELF == this) {
/* 368 */       throw new IllegalArgumentException();
/*     */     }
/* 370 */     int i = paramSELF.remaining();
/* 371 */     if (remaining() < i) {
/* 372 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/* 375 */     MemoryUtil.memCopy(paramSELF.address(), address(), Integer.toUnsignedLong(i) * sizeof());
/* 376 */     this.position += i;
/*     */     
/* 378 */     return self();
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
/*     */   public SELF compact() {
/* 398 */     MemoryUtil.memCopy(address(), this.address, Integer.toUnsignedLong(remaining()) * sizeof());
/* 399 */     position(remaining());
/* 400 */     limit(capacity());
/* 401 */     this.mark = -1;
/*     */     
/* 403 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 412 */     return getClass().getName() + "[pos=" + position() + " lim=" + limit() + " cap=" + capacity() + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract SELF self();
/*     */ 
/*     */   
/*     */   protected final int nextGetIndex() {
/* 420 */     if (this.position < this.limit) {
/* 421 */       return this.position++;
/*     */     }
/* 423 */     throw new BufferUnderflowException();
/*     */   }
/*     */   
/*     */   protected final int nextPutIndex() {
/* 427 */     if (this.position < this.limit) {
/* 428 */       return this.position++;
/*     */     }
/* 430 */     throw new BufferOverflowException();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\CustomBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */