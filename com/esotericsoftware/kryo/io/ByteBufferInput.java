/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteBufferInput
/*     */   extends Input
/*     */ {
/*  39 */   private static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
/*     */ 
/*     */   
/*     */   protected ByteBuffer byteBuffer;
/*     */ 
/*     */   
/*     */   private byte[] tempBuffer;
/*     */ 
/*     */   
/*     */   public ByteBufferInput() {}
/*     */ 
/*     */   
/*     */   public ByteBufferInput(int paramInt) {
/*  52 */     this.capacity = paramInt;
/*  53 */     this.byteBuffer = ByteBuffer.allocateDirect(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferInput(byte[] paramArrayOfbyte) {
/*  58 */     this(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBufferInput(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  64 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/*     */     ByteBuffer byteBuffer;
/*  66 */     (byteBuffer = ByteBuffer.allocateDirect(paramArrayOfbyte.length)).put(paramArrayOfbyte);
/*  67 */     flipBuffer(byteBuffer);
/*  68 */     setBuffer(byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferInput(ByteBuffer paramByteBuffer) {
/*  73 */     setBuffer(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferInput(InputStream paramInputStream) {
/*  78 */     this(4096);
/*  79 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*  80 */     this.inputStream = paramInputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferInput(InputStream paramInputStream, int paramInt) {
/*  85 */     this(paramInt);
/*  86 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*  87 */     this.inputStream = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBuffer() {
/*  94 */     throw new UnsupportedOperationException("This input does not used a byte[], see #getByteBuffer().");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte) {
/* 101 */     throw new UnsupportedOperationException("This input does not used a byte[], see #setByteBuffer(ByteBuffer).");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 108 */     throw new UnsupportedOperationException("This input does not used a byte[], see #setByteBufferByteBuffer().");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(ByteBuffer paramByteBuffer) {
/* 115 */     if (paramByteBuffer == null) throw new IllegalArgumentException("buffer cannot be null."); 
/* 116 */     this.byteBuffer = paramByteBuffer;
/* 117 */     this.position = paramByteBuffer.position();
/* 118 */     this.limit = paramByteBuffer.limit();
/* 119 */     this.capacity = paramByteBuffer.capacity();
/* 120 */     this.total = 0L;
/* 121 */     this.inputStream = null;
/*     */   }
/*     */   
/*     */   public ByteBuffer getByteBuffer() {
/* 125 */     return this.byteBuffer;
/*     */   }
/*     */   
/*     */   public void setInputStream(InputStream paramInputStream) {
/* 129 */     this.inputStream = paramInputStream;
/* 130 */     this.limit = 0;
/* 131 */     reset();
/*     */   }
/*     */   
/*     */   public void reset() {
/* 135 */     super.reset();
/* 136 */     setBufferPosition(this.byteBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int fill(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 142 */     if (this.inputStream == null) return -1; 
/*     */     try {
/* 144 */       if (this.tempBuffer == null) this.tempBuffer = new byte[2048]; 
/* 145 */       setBufferPosition(paramByteBuffer, paramInt1);
/* 146 */       paramInt1 = 0;
/* 147 */       while (paramInt2 > 0) {
/*     */         int i;
/* 149 */         if ((i = this.inputStream.read(this.tempBuffer, 0, Math.min(this.tempBuffer.length, paramInt2))) == -1) {
/* 150 */           if (paramInt1 == 0) return -1; 
/*     */           break;
/*     */         } 
/* 153 */         paramByteBuffer.put(this.tempBuffer, 0, i);
/* 154 */         paramInt2 -= i;
/* 155 */         paramInt1 += i;
/*     */       } 
/* 157 */       return paramInt1;
/* 158 */     } catch (IOException iOException) {
/* 159 */       throw new KryoException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int require(int paramInt) {
/*     */     int j, i;
/* 165 */     if ((i = this.limit - this.position) >= paramInt) return i; 
/* 166 */     if (paramInt > this.capacity) throw new KryoException("Buffer too small: capacity: " + this.capacity + ", required: " + paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     if (i > 0) {
/*     */       
/* 173 */       if ((j = fill(this.byteBuffer, this.limit, this.capacity - this.limit)) == -1) throw new KryoBufferUnderflowException("Buffer underflow."); 
/* 174 */       setBufferPosition(this.byteBuffer, this.position);
/*     */       
/* 176 */       if ((i = i + j) >= paramInt) {
/* 177 */         this.limit += j;
/* 178 */         return i;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 183 */     this.byteBuffer.compact();
/* 184 */     this.total += this.position;
/* 185 */     this.position = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 190 */       if ((j = fill(this.byteBuffer, i, this.capacity - i)) == -1) {
/* 191 */         if (i < paramInt)
/* 192 */           throw new KryoBufferUnderflowException("Buffer underflow."); 
/*     */         break;
/*     */       } 
/* 195 */     } while ((i = i + j) < paramInt);
/*     */     
/* 197 */     this.limit = i;
/* 198 */     setBufferPosition(this.byteBuffer, 0);
/* 199 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int optional(int paramInt) {
/*     */     int i;
/* 208 */     if ((i = this.limit - this.position) >= paramInt) return paramInt; 
/* 209 */     paramInt = Math.min(paramInt, this.capacity);
/*     */ 
/*     */     
/* 212 */     int j = fill(this.byteBuffer, this.limit, this.capacity - this.limit);
/* 213 */     setBufferPosition(this.byteBuffer, this.position);
/* 214 */     if (j == -1) return (i == 0) ? -1 : Math.min(i, paramInt);
/*     */     
/* 216 */     if ((i = i + j) >= paramInt) {
/* 217 */       this.limit += j;
/* 218 */       return paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 222 */     this.byteBuffer.compact();
/* 223 */     this.total += this.position;
/* 224 */     this.position = 0;
/*     */ 
/*     */     
/*     */     do {
/*     */     
/* 229 */     } while ((j = fill(this.byteBuffer, i, this.capacity - i)) != -1 && (
/*     */       
/* 231 */       i = i + j) < paramInt);
/*     */     
/* 233 */     this.limit = i;
/* 234 */     setBufferPosition(this.byteBuffer, 0);
/* 235 */     return (i == 0) ? -1 : Math.min(i, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() {
/* 241 */     if (optional(1) <= 0) return -1; 
/* 242 */     this.position++;
/* 243 */     return this.byteBuffer.get() & 0xFF;
/*     */   }
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 247 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 251 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 252 */     int i = paramInt2;
/* 253 */     int j = Math.min(this.limit - this.position, paramInt2);
/*     */     
/* 255 */     this.byteBuffer.get(paramArrayOfbyte, paramInt1, j);
/* 256 */     this.position += j;
/*     */     
/* 258 */     while ((paramInt2 = paramInt2 - j) != 0) {
/* 259 */       paramInt1 += j;
/*     */       
/* 261 */       if ((j = optional(paramInt2)) == -1) {
/*     */         
/* 263 */         if (i == paramInt2) return -1; 
/*     */         break;
/*     */       } 
/* 266 */       if (this.position == this.limit)
/*     */         break; 
/* 268 */     }  return i - paramInt2;
/*     */   }
/*     */   
/*     */   public void setPosition(int paramInt) {
/* 272 */     this.position = paramInt;
/* 273 */     setBufferPosition(this.byteBuffer, paramInt);
/*     */   }
/*     */   
/*     */   public void setLimit(int paramInt) {
/* 277 */     this.limit = paramInt;
/* 278 */     setBufferLimit(this.byteBuffer, paramInt);
/*     */   }
/*     */   
/*     */   public void skip(int paramInt) {
/* 282 */     super.skip(paramInt);
/* 283 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public long skip(long paramLong) {
/* 287 */     long l = paramLong;
/* 288 */     while (l > 0L) {
/* 289 */       int i = (int)Math.min(2147483639L, l);
/* 290 */       skip(i);
/* 291 */       l -= i;
/*     */     } 
/* 293 */     return paramLong;
/*     */   }
/*     */   
/*     */   public void close() {
/* 297 */     if (this.inputStream != null) {
/*     */       try {
/* 299 */         this.inputStream.close(); return;
/* 300 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int getBufferPosition(Buffer paramBuffer) {
/* 306 */     return paramBuffer.position();
/*     */   }
/*     */   
/*     */   private void setBufferPosition(Buffer paramBuffer, int paramInt) {
/* 310 */     paramBuffer.position(paramInt);
/*     */   }
/*     */   
/*     */   private void setBufferLimit(Buffer paramBuffer, int paramInt) {
/* 314 */     paramBuffer.limit(paramInt);
/*     */   }
/*     */   
/*     */   private void flipBuffer(Buffer paramBuffer) {
/* 318 */     paramBuffer.flip();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 324 */     if (this.position == this.limit) require(1); 
/* 325 */     this.position++;
/* 326 */     return this.byteBuffer.get();
/*     */   }
/*     */   
/*     */   public int readByteUnsigned() {
/* 330 */     if (this.position == this.limit) require(1); 
/* 331 */     this.position++;
/* 332 */     return this.byteBuffer.get() & 0xFF;
/*     */   }
/*     */   
/*     */   public byte[] readBytes(int paramInt) {
/* 336 */     byte[] arrayOfByte = new byte[paramInt];
/* 337 */     readBytes(arrayOfByte, 0, paramInt);
/* 338 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 342 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 343 */     int i = Math.min(this.limit - this.position, paramInt2);
/*     */     
/* 345 */     this.byteBuffer.get(paramArrayOfbyte, paramInt1, i);
/* 346 */     this.position += i;
/*     */     
/* 348 */     while ((paramInt2 = paramInt2 - i) != 0) {
/* 349 */       paramInt1 += i;
/* 350 */       i = Math.min(paramInt2, this.capacity);
/* 351 */       require(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 358 */     require(4);
/* 359 */     this.position += 4;
/*     */     ByteBuffer byteBuffer;
/* 361 */     return (byteBuffer = this.byteBuffer).get() & 0xFF | (byteBuffer
/* 362 */       .get() & 0xFF) << 8 | (byteBuffer
/* 363 */       .get() & 0xFF) << 16 | (byteBuffer
/* 364 */       .get() & 0xFF) << 24;
/*     */   }
/*     */   
/*     */   public int readVarInt(boolean paramBoolean) {
/* 368 */     if (require(1) < 5) return readVarInt_slow(paramBoolean); 
/*     */     byte b;
/* 370 */     int i = (b = this.byteBuffer.get()) & Byte.MAX_VALUE;
/* 371 */     if ((b & 0x80) != 0) {
/*     */       ByteBuffer byteBuffer;
/* 373 */       b = (byteBuffer = this.byteBuffer).get();
/* 374 */       i |= (b & Byte.MAX_VALUE) << 7;
/* 375 */       if ((b & 0x80) != 0) {
/* 376 */         b = byteBuffer.get();
/* 377 */         i |= (b & Byte.MAX_VALUE) << 14;
/* 378 */         if ((b & 0x80) != 0) {
/* 379 */           b = byteBuffer.get();
/* 380 */           i |= (b & Byte.MAX_VALUE) << 21;
/* 381 */           if ((b & 0x80) != 0) {
/* 382 */             b = byteBuffer.get();
/* 383 */             i |= (b & Byte.MAX_VALUE) << 28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 388 */     this.position = getBufferPosition(this.byteBuffer);
/* 389 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int readVarInt_slow(boolean paramBoolean) {
/* 394 */     this.position++;
/*     */     byte b;
/* 396 */     int i = (b = this.byteBuffer.get()) & Byte.MAX_VALUE;
/* 397 */     if ((b & 0x80) != 0) {
/* 398 */       if (this.position == this.limit) require(1); 
/* 399 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 400 */       this.position++;
/* 401 */       b = byteBuffer.get();
/* 402 */       i |= (b & Byte.MAX_VALUE) << 7;
/* 403 */       if ((b & 0x80) != 0) {
/* 404 */         if (this.position == this.limit) require(1); 
/* 405 */         this.position++;
/* 406 */         b = byteBuffer.get();
/* 407 */         i |= (b & Byte.MAX_VALUE) << 14;
/* 408 */         if ((b & 0x80) != 0) {
/* 409 */           if (this.position == this.limit) require(1); 
/* 410 */           this.position++;
/* 411 */           b = byteBuffer.get();
/* 412 */           i |= (b & Byte.MAX_VALUE) << 21;
/* 413 */           if ((b & 0x80) != 0) {
/* 414 */             if (this.position == this.limit) require(1); 
/* 415 */             this.position++;
/* 416 */             b = byteBuffer.get();
/* 417 */             i |= (b & Byte.MAX_VALUE) << 28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 422 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */   
/*     */   public boolean canReadVarInt() {
/* 426 */     if (this.limit - this.position >= 5) return true; 
/* 427 */     if (optional(5) <= 0) return false; 
/* 428 */     int i = this.position, j = this.limit;
/*     */     ByteBuffer byteBuffer;
/* 430 */     if (((byteBuffer = this.byteBuffer).get(i++) & 0x80) == 0) return true; 
/* 431 */     if (i == j) return false; 
/* 432 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 433 */     if (i == j) return false; 
/* 434 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 435 */     if (i == j) return false; 
/* 436 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 437 */     if (i == j) return false; 
/* 438 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean readVarIntFlag() {
/* 444 */     if (this.position == this.limit) require(1); 
/* 445 */     return ((this.byteBuffer.get(this.position) & 0x80) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readVarIntFlag(boolean paramBoolean) {
/* 451 */     if (require(1) < 5) return readVarIntFlag_slow(paramBoolean); 
/*     */     byte b;
/* 453 */     int i = (b = this.byteBuffer.get()) & 0x3F;
/* 454 */     if ((b & 0x40) != 0) {
/*     */       ByteBuffer byteBuffer;
/* 456 */       b = (byteBuffer = this.byteBuffer).get();
/* 457 */       i |= (b & Byte.MAX_VALUE) << 6;
/* 458 */       if ((b & 0x80) != 0) {
/* 459 */         b = byteBuffer.get();
/* 460 */         i |= (b & Byte.MAX_VALUE) << 13;
/* 461 */         if ((b & 0x80) != 0) {
/* 462 */           b = byteBuffer.get();
/* 463 */           i |= (b & Byte.MAX_VALUE) << 20;
/* 464 */           if ((b & 0x80) != 0) {
/* 465 */             b = byteBuffer.get();
/* 466 */             i |= (b & Byte.MAX_VALUE) << 27;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 471 */     this.position = getBufferPosition(this.byteBuffer);
/* 472 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int readVarIntFlag_slow(boolean paramBoolean) {
/* 477 */     this.position++;
/*     */     byte b;
/* 479 */     int i = (b = this.byteBuffer.get()) & 0x3F;
/* 480 */     if ((b & 0x40) != 0) {
/* 481 */       if (this.position == this.limit) require(1); 
/* 482 */       this.position++;
/*     */       ByteBuffer byteBuffer;
/* 484 */       b = (byteBuffer = this.byteBuffer).get();
/* 485 */       i |= (b & Byte.MAX_VALUE) << 6;
/* 486 */       if ((b & 0x80) != 0) {
/* 487 */         if (this.position == this.limit) require(1); 
/* 488 */         this.position++;
/* 489 */         b = byteBuffer.get();
/* 490 */         i |= (b & Byte.MAX_VALUE) << 13;
/* 491 */         if ((b & 0x80) != 0) {
/* 492 */           if (this.position == this.limit) require(1); 
/* 493 */           this.position++;
/* 494 */           b = byteBuffer.get();
/* 495 */           i |= (b & Byte.MAX_VALUE) << 20;
/* 496 */           if ((b & 0x80) != 0) {
/* 497 */             if (this.position == this.limit) require(1); 
/* 498 */             this.position++;
/* 499 */             b = byteBuffer.get();
/* 500 */             i |= (b & Byte.MAX_VALUE) << 27;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 505 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 511 */     require(8);
/* 512 */     this.position += 8;
/*     */     ByteBuffer byteBuffer;
/* 514 */     return ((byteBuffer = this.byteBuffer).get() & 0xFF | (byteBuffer
/* 515 */       .get() & 0xFF) << 8 | (byteBuffer
/* 516 */       .get() & 0xFF) << 16) | (byteBuffer
/* 517 */       .get() & 0xFF) << 24L | (byteBuffer
/* 518 */       .get() & 0xFF) << 32L | (byteBuffer
/* 519 */       .get() & 0xFF) << 40L | (byteBuffer
/* 520 */       .get() & 0xFF) << 48L | byteBuffer
/* 521 */       .get() << 56L;
/*     */   }
/*     */   
/*     */   public long readVarLong(boolean paramBoolean) {
/* 525 */     if (require(1) < 9) return readVarLong_slow(paramBoolean); 
/*     */     byte b;
/* 527 */     long l = ((b = this.byteBuffer.get()) & Byte.MAX_VALUE);
/* 528 */     if ((b & 0x80) != 0) {
/*     */       ByteBuffer byteBuffer;
/* 530 */       b = (byteBuffer = this.byteBuffer).get();
/* 531 */       l |= ((b & Byte.MAX_VALUE) << 7);
/* 532 */       if ((b & 0x80) != 0) {
/* 533 */         b = byteBuffer.get();
/* 534 */         l |= ((b & Byte.MAX_VALUE) << 14);
/* 535 */         if ((b & 0x80) != 0) {
/* 536 */           b = byteBuffer.get();
/* 537 */           l |= ((b & Byte.MAX_VALUE) << 21);
/* 538 */           if ((b & 0x80) != 0) {
/* 539 */             b = byteBuffer.get();
/* 540 */             l |= (b & Byte.MAX_VALUE) << 28L;
/* 541 */             if ((b & 0x80) != 0) {
/* 542 */               b = byteBuffer.get();
/* 543 */               l |= (b & Byte.MAX_VALUE) << 35L;
/* 544 */               if ((b & 0x80) != 0) {
/* 545 */                 b = byteBuffer.get();
/* 546 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/* 547 */                 if ((b & 0x80) != 0) {
/* 548 */                   b = byteBuffer.get();
/* 549 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/* 550 */                   if ((b & 0x80) != 0) {
/* 551 */                     b = byteBuffer.get();
/* 552 */                     l |= b << 56L;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 561 */     this.position = getBufferPosition(this.byteBuffer);
/* 562 */     return paramBoolean ? l : (l >>> 1L ^ -(l & 0x1L));
/*     */   }
/*     */ 
/*     */   
/*     */   private long readVarLong_slow(boolean paramBoolean) {
/* 567 */     this.position++;
/*     */     byte b;
/* 569 */     long l = ((b = this.byteBuffer.get()) & Byte.MAX_VALUE);
/* 570 */     if ((b & 0x80) != 0) {
/* 571 */       if (this.position == this.limit) require(1); 
/* 572 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 573 */       this.position++;
/* 574 */       b = byteBuffer.get();
/* 575 */       l |= ((b & Byte.MAX_VALUE) << 7);
/* 576 */       if ((b & 0x80) != 0) {
/* 577 */         if (this.position == this.limit) require(1); 
/* 578 */         this.position++;
/* 579 */         b = byteBuffer.get();
/* 580 */         l |= ((b & Byte.MAX_VALUE) << 14);
/* 581 */         if ((b & 0x80) != 0) {
/* 582 */           if (this.position == this.limit) require(1); 
/* 583 */           this.position++;
/* 584 */           b = byteBuffer.get();
/* 585 */           l |= ((b & Byte.MAX_VALUE) << 21);
/* 586 */           if ((b & 0x80) != 0) {
/* 587 */             if (this.position == this.limit) require(1); 
/* 588 */             this.position++;
/* 589 */             b = byteBuffer.get();
/* 590 */             l |= (b & Byte.MAX_VALUE) << 28L;
/* 591 */             if ((b & 0x80) != 0) {
/* 592 */               if (this.position == this.limit) require(1); 
/* 593 */               this.position++;
/* 594 */               b = byteBuffer.get();
/* 595 */               l |= (b & Byte.MAX_VALUE) << 35L;
/* 596 */               if ((b & 0x80) != 0) {
/* 597 */                 if (this.position == this.limit) require(1); 
/* 598 */                 this.position++;
/* 599 */                 b = byteBuffer.get();
/* 600 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/* 601 */                 if ((b & 0x80) != 0) {
/* 602 */                   if (this.position == this.limit) require(1); 
/* 603 */                   this.position++;
/* 604 */                   b = byteBuffer.get();
/* 605 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/* 606 */                   if ((b & 0x80) != 0) {
/* 607 */                     if (this.position == this.limit) require(1); 
/* 608 */                     this.position++;
/* 609 */                     b = byteBuffer.get();
/* 610 */                     l |= b << 56L;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 619 */     return paramBoolean ? l : (l >>> 1L ^ -(l & 0x1L));
/*     */   }
/*     */   
/*     */   public boolean canReadVarLong() {
/* 623 */     if (this.limit - this.position >= 9) return true; 
/* 624 */     if (optional(5) <= 0) return false; 
/* 625 */     int i = this.position, j = this.limit;
/*     */     ByteBuffer byteBuffer;
/* 627 */     if (((byteBuffer = this.byteBuffer).get(i++) & 0x80) == 0) return true; 
/* 628 */     if (i == j) return false; 
/* 629 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 630 */     if (i == j) return false; 
/* 631 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 632 */     if (i == j) return false; 
/* 633 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 634 */     if (i == j) return false; 
/* 635 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 636 */     if (i == j) return false; 
/* 637 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 638 */     if (i == j) return false; 
/* 639 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 640 */     if (i == j) return false; 
/* 641 */     if ((byteBuffer.get(i++) & 0x80) == 0) return true; 
/* 642 */     if (i == j) return false; 
/* 643 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float readFloat() {
/* 649 */     require(4);
/* 650 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 651 */     int i = this.position;
/* 652 */     this.position = i + 4;
/* 653 */     return Float.intBitsToFloat(byteBuffer.get() & 0xFF | (byteBuffer
/* 654 */         .get() & 0xFF) << 8 | (byteBuffer
/* 655 */         .get() & 0xFF) << 16 | (byteBuffer
/* 656 */         .get() & 0xFF) << 24);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 662 */     require(8);
/* 663 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 664 */     int i = this.position;
/* 665 */     this.position = i + 8;
/* 666 */     return Double.longBitsToDouble((byteBuffer.get() & 0xFF | (byteBuffer
/* 667 */         .get() & 0xFF) << 8 | (byteBuffer
/* 668 */         .get() & 0xFF) << 16) | (byteBuffer
/* 669 */         .get() & 0xFF) << 24L | (byteBuffer
/* 670 */         .get() & 0xFF) << 32L | (byteBuffer
/* 671 */         .get() & 0xFF) << 40L | (byteBuffer
/* 672 */         .get() & 0xFF) << 48L | byteBuffer
/* 673 */         .get() << 56L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean readBoolean() {
/* 679 */     if (this.position == this.limit) require(1); 
/* 680 */     this.position++;
/* 681 */     return (this.byteBuffer.get() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 687 */     require(2);
/* 688 */     this.position += 2;
/* 689 */     return (short)(this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8);
/*     */   }
/*     */   
/*     */   public int readShortUnsigned() {
/* 693 */     require(2);
/* 694 */     this.position += 2;
/* 695 */     return this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public char readChar() {
/* 701 */     require(2);
/* 702 */     this.position += 2;
/* 703 */     return (char)(this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString() {
/* 709 */     if (!readVarIntFlag()) return readAsciiString();
/*     */     
/*     */     int i;
/* 712 */     switch (i = readVarIntFlag(true)) {
/*     */       case 0:
/* 714 */         return null;
/*     */       case 1:
/* 716 */         return "";
/*     */     } 
/* 718 */     i--;
/* 719 */     readUtf8Chars(i);
/* 720 */     return new String(this.chars, 0, i);
/*     */   }
/*     */   
/*     */   public StringBuilder readStringBuilder() {
/* 724 */     if (!readVarIntFlag()) return new StringBuilder(readAsciiString());
/*     */     
/*     */     int i;
/* 727 */     switch (i = readVarIntFlag(true)) {
/*     */       case 0:
/* 729 */         return null;
/*     */       case 1:
/* 731 */         return new StringBuilder("");
/*     */     } 
/* 733 */     i--;
/* 734 */     readUtf8Chars(i);
/*     */     StringBuilder stringBuilder;
/* 736 */     (stringBuilder = new StringBuilder(i)).append(this.chars, 0, i);
/* 737 */     return stringBuilder;
/*     */   }
/*     */   
/*     */   private void readUtf8Chars(int paramInt) {
/* 741 */     if (this.chars.length < paramInt) this.chars = new char[paramInt]; 
/* 742 */     char[] arrayOfChar = this.chars;
/*     */     
/* 744 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 745 */     byte b = 0;
/* 746 */     int i = Math.min(require(1), paramInt); byte b1;
/* 747 */     while (b < i && (
/*     */       
/* 749 */       b1 = byteBuffer.get()) >= 0) {
/* 750 */       arrayOfChar[b++] = (char)b1;
/*     */     }
/* 752 */     this.position += b;
/*     */     
/* 754 */     if (b < paramInt) {
/* 755 */       setBufferPosition(byteBuffer, this.position);
/* 756 */       readUtf8Chars_slow(paramInt, b);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void readUtf8Chars_slow(int paramInt1, int paramInt2) {
/* 761 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 762 */     char[] arrayOfChar = this.chars;
/* 763 */     while (paramInt2 < paramInt1) {
/* 764 */       byte b1, b2; if (this.position == this.limit) require(1); 
/* 765 */       this.position++;
/*     */       int i;
/* 767 */       switch ((i = byteBuffer.get() & 0xFF) >> 4) {
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/* 776 */           arrayOfChar[paramInt2] = (char)i;
/*     */           break;
/*     */         case 12:
/*     */         case 13:
/* 780 */           if (this.position == this.limit) require(1); 
/* 781 */           this.position++;
/* 782 */           arrayOfChar[paramInt2] = (char)((i & 0x1F) << 6 | byteBuffer.get() & 0x3F);
/*     */           break;
/*     */         case 14:
/* 785 */           require(2);
/* 786 */           this.position += 2;
/* 787 */           b1 = byteBuffer.get();
/* 788 */           b2 = byteBuffer.get();
/* 789 */           arrayOfChar[paramInt2] = (char)((i & 0xF) << 12 | (b1 & 0x3F) << 6 | b2 & 0x3F);
/*     */           break;
/*     */       } 
/* 792 */       paramInt2++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String readAsciiString() {
/* 797 */     char[] arrayOfChar = this.chars;
/* 798 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 799 */     byte b = 0;
/* 800 */     for (int i = Math.min(arrayOfChar.length, this.limit - this.position); b < i; b++) {
/*     */       byte b1;
/* 802 */       if (((b1 = byteBuffer.get()) & 0x80) == 128) {
/* 803 */         this.position = getBufferPosition(byteBuffer);
/* 804 */         arrayOfChar[b] = (char)(b1 & Byte.MAX_VALUE);
/* 805 */         return new String(arrayOfChar, 0, b + 1);
/*     */       } 
/* 807 */       arrayOfChar[b] = (char)b1;
/*     */     } 
/* 809 */     this.position = getBufferPosition(byteBuffer);
/* 810 */     return readAscii_slow(b);
/*     */   }
/*     */   
/*     */   private String readAscii_slow(int paramInt) {
/* 814 */     char[] arrayOfChar = this.chars;
/* 815 */     ByteBuffer byteBuffer = this.byteBuffer;
/*     */     while (true) {
/* 817 */       if (this.position == this.limit) require(1); 
/* 818 */       this.position++;
/* 819 */       byte b = byteBuffer.get();
/* 820 */       if (paramInt == arrayOfChar.length) {
/* 821 */         char[] arrayOfChar1 = new char[paramInt << 1];
/* 822 */         System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, paramInt);
/* 823 */         arrayOfChar = arrayOfChar1;
/* 824 */         this.chars = arrayOfChar1;
/*     */       } 
/* 826 */       if ((b & 0x80) == 128) {
/* 827 */         arrayOfChar[paramInt] = (char)(b & Byte.MAX_VALUE);
/* 828 */         return new String(arrayOfChar, 0, paramInt + 1);
/*     */       } 
/* 830 */       arrayOfChar[paramInt++] = (char)b;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] readInts(int paramInt) {
/* 837 */     int[] arrayOfInt = new int[paramInt];
/* 838 */     if (optional(paramInt << 2) == paramInt << 2) {
/* 839 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 840 */       for (byte b = 0; b < paramInt; b++) {
/* 841 */         arrayOfInt[b] = byteBuffer.get() & 0xFF | (byteBuffer
/* 842 */           .get() & 0xFF) << 8 | (byteBuffer
/* 843 */           .get() & 0xFF) << 16 | (byteBuffer
/* 844 */           .get() & 0xFF) << 24;
/*     */       }
/* 846 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 848 */       for (byte b = 0; b < paramInt; b++)
/* 849 */         arrayOfInt[b] = readInt(); 
/*     */     } 
/* 851 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public long[] readLongs(int paramInt) {
/* 855 */     long[] arrayOfLong = new long[paramInt];
/* 856 */     if (optional(paramInt << 3) == paramInt << 3) {
/* 857 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 858 */       for (byte b = 0; b < paramInt; b++) {
/* 859 */         arrayOfLong[b] = (byteBuffer.get() & 0xFF | (byteBuffer
/* 860 */           .get() & 0xFF) << 8 | (byteBuffer
/* 861 */           .get() & 0xFF) << 16) | (byteBuffer
/* 862 */           .get() & 0xFF) << 24L | (byteBuffer
/* 863 */           .get() & 0xFF) << 32L | (byteBuffer
/* 864 */           .get() & 0xFF) << 40L | (byteBuffer
/* 865 */           .get() & 0xFF) << 48L | byteBuffer
/* 866 */           .get() << 56L;
/*     */       }
/* 868 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 870 */       for (byte b = 0; b < paramInt; b++)
/* 871 */         arrayOfLong[b] = readLong(); 
/*     */     } 
/* 873 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   public float[] readFloats(int paramInt) {
/* 877 */     float[] arrayOfFloat = new float[paramInt];
/* 878 */     if (optional(paramInt << 2) == paramInt << 2) {
/* 879 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 880 */       for (byte b = 0; b < paramInt; b++) {
/* 881 */         arrayOfFloat[b] = Float.intBitsToFloat(byteBuffer.get() & 0xFF | (byteBuffer
/* 882 */             .get() & 0xFF) << 8 | (byteBuffer
/* 883 */             .get() & 0xFF) << 16 | (byteBuffer
/* 884 */             .get() & 0xFF) << 24);
/*     */       }
/* 886 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 888 */       for (byte b = 0; b < paramInt; b++)
/* 889 */         arrayOfFloat[b] = readFloat(); 
/*     */     } 
/* 891 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   public double[] readDoubles(int paramInt) {
/* 895 */     double[] arrayOfDouble = new double[paramInt];
/* 896 */     if (optional(paramInt << 3) == paramInt << 3) {
/* 897 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 898 */       for (byte b = 0; b < paramInt; b++) {
/* 899 */         arrayOfDouble[b] = Double.longBitsToDouble((byteBuffer.get() & 0xFF | (byteBuffer
/* 900 */             .get() & 0xFF) << 8 | (byteBuffer
/* 901 */             .get() & 0xFF) << 16) | (byteBuffer
/* 902 */             .get() & 0xFF) << 24L | (byteBuffer
/* 903 */             .get() & 0xFF) << 32L | (byteBuffer
/* 904 */             .get() & 0xFF) << 40L | (byteBuffer
/* 905 */             .get() & 0xFF) << 48L | byteBuffer
/* 906 */             .get() << 56L);
/*     */       }
/* 908 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 910 */       for (byte b = 0; b < paramInt; b++)
/* 911 */         arrayOfDouble[b] = readDouble(); 
/*     */     } 
/* 913 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   public short[] readShorts(int paramInt) {
/* 917 */     short[] arrayOfShort = new short[paramInt];
/* 918 */     if (optional(paramInt << 1) == paramInt << 1) {
/* 919 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 920 */       for (byte b = 0; b < paramInt; b++)
/* 921 */         arrayOfShort[b] = (short)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8); 
/* 922 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 924 */       for (byte b = 0; b < paramInt; b++)
/* 925 */         arrayOfShort[b] = readShort(); 
/*     */     } 
/* 927 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public char[] readChars(int paramInt) {
/* 931 */     char[] arrayOfChar = new char[paramInt];
/* 932 */     if (optional(paramInt << 1) == paramInt << 1) {
/* 933 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 934 */       for (byte b = 0; b < paramInt; b++)
/* 935 */         arrayOfChar[b] = (char)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8); 
/* 936 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 938 */       for (byte b = 0; b < paramInt; b++)
/* 939 */         arrayOfChar[b] = readChar(); 
/*     */     } 
/* 941 */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public boolean[] readBooleans(int paramInt) {
/* 945 */     boolean[] arrayOfBoolean = new boolean[paramInt];
/* 946 */     if (optional(paramInt) == paramInt) {
/* 947 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 948 */       for (byte b = 0; b < paramInt; b++)
/* 949 */         arrayOfBoolean[b] = (byteBuffer.get() != 0); 
/* 950 */       this.position = getBufferPosition(byteBuffer);
/*     */     } else {
/* 952 */       for (byte b = 0; b < paramInt; b++)
/* 953 */         arrayOfBoolean[b] = readBoolean(); 
/*     */     } 
/* 955 */     return arrayOfBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\ByteBufferInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */