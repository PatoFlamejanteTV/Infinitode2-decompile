/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class ByteBufferOutput
/*     */   extends Output
/*     */ {
/*  38 */   private static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
/*     */ 
/*     */   
/*     */   protected ByteBuffer byteBuffer;
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBufferOutput() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(int paramInt) {
/*  50 */     this(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(int paramInt1, int paramInt2) {
/*  58 */     if (paramInt2 < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt2); 
/*  59 */     this.capacity = paramInt1;
/*  60 */     this.maxCapacity = (paramInt2 == -1) ? 2147483639 : paramInt2;
/*  61 */     this.byteBuffer = ByteBuffer.allocateDirect(paramInt1);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(ByteBuffer paramByteBuffer) {
/*  66 */     setBuffer(paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(ByteBuffer paramByteBuffer, int paramInt) {
/*  73 */     setBuffer(paramByteBuffer, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(OutputStream paramOutputStream) {
/*  78 */     this(4096, 4096);
/*  79 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  80 */     this.outputStream = paramOutputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufferOutput(OutputStream paramOutputStream, int paramInt) {
/*  85 */     this(paramInt, paramInt);
/*  86 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  87 */     this.outputStream = paramOutputStream;
/*     */   }
/*     */   
/*     */   public OutputStream getOutputStream() {
/*  91 */     return this.outputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBuffer() {
/*  98 */     throw new UnsupportedOperationException("This buffer does not used a byte[], see #getByteBuffer().");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte) {
/* 105 */     throw new UnsupportedOperationException("This buffer does not used a byte[], see #setByteBuffer(ByteBuffer).");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt) {
/* 112 */     throw new UnsupportedOperationException("This buffer does not used a byte[], see #setByteBuffer(ByteBuffer).");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     ByteBuffer byteBuffer;
/* 119 */     (byteBuffer = ByteBuffer.allocateDirect(paramArrayOfbyte.length)).put(paramArrayOfbyte, paramInt1, paramInt2);
/* 120 */     setBufferPosition(byteBuffer, 0);
/* 121 */     setBufferLimit(byteBuffer, paramArrayOfbyte.length);
/* 122 */     setBuffer(byteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(ByteBuffer paramByteBuffer) {
/* 128 */     setBuffer(paramByteBuffer, paramByteBuffer.capacity());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(ByteBuffer paramByteBuffer, int paramInt) {
/* 137 */     if (paramByteBuffer == null) throw new IllegalArgumentException("buffer cannot be null."); 
/* 138 */     if (paramInt < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt); 
/* 139 */     this.byteBuffer = paramByteBuffer;
/* 140 */     this.maxCapacity = (paramInt == -1) ? 2147483639 : paramInt;
/* 141 */     this.capacity = paramByteBuffer.capacity();
/* 142 */     this.position = paramByteBuffer.position();
/* 143 */     this.total = 0L;
/* 144 */     this.outputStream = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer getByteBuffer() {
/* 149 */     return this.byteBuffer;
/*     */   }
/*     */   
/*     */   public byte[] toBytes() {
/* 153 */     byte[] arrayOfByte = new byte[this.position];
/* 154 */     setBufferPosition(this.byteBuffer, 0);
/* 155 */     this.byteBuffer.get(arrayOfByte, 0, this.position);
/* 156 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public void setPosition(int paramInt) {
/* 160 */     this.position = paramInt;
/* 161 */     setBufferPosition(this.byteBuffer, paramInt);
/*     */   }
/*     */   
/*     */   public void reset() {
/* 165 */     super.reset();
/* 166 */     setBufferPosition(this.byteBuffer, 0);
/*     */   }
/*     */   
/*     */   private int getBufferPosition(Buffer paramBuffer) {
/* 170 */     return paramBuffer.position();
/*     */   }
/*     */   
/*     */   private void setBufferPosition(Buffer paramBuffer, int paramInt) {
/* 174 */     paramBuffer.position(paramInt);
/*     */   }
/*     */   
/*     */   private void setBufferLimit(Buffer paramBuffer, int paramInt) {
/* 178 */     paramBuffer.limit(paramInt);
/*     */   }
/*     */   
/*     */   protected boolean require(int paramInt) {
/* 182 */     if (this.capacity - this.position >= paramInt) return false; 
/* 183 */     flush();
/* 184 */     if (this.capacity - this.position >= paramInt) return true; 
/* 185 */     if (paramInt > this.maxCapacity - this.position) {
/* 186 */       if (paramInt > this.maxCapacity)
/* 187 */         throw new KryoBufferOverflowException("Buffer overflow. Max capacity: " + this.maxCapacity + ", required: " + paramInt); 
/* 188 */       throw new KryoBufferOverflowException("Buffer overflow. Available: " + (this.maxCapacity - this.position) + ", required: " + paramInt);
/*     */     } 
/*     */     
/* 191 */     if (this.capacity == 0) this.capacity = 16; 
/*     */     while (true) {
/* 193 */       this.capacity = Math.min(this.capacity << 1, this.maxCapacity);
/* 194 */       if (this.capacity - this.position >= paramInt) {
/* 195 */         ByteBuffer byteBuffer = !this.byteBuffer.isDirect() ? ByteBuffer.allocate(this.capacity) : ByteBuffer.allocateDirect(this.capacity);
/* 196 */         setBufferPosition(this.byteBuffer, 0);
/* 197 */         setBufferLimit(this.byteBuffer, this.position);
/* 198 */         byteBuffer.put(this.byteBuffer);
/* 199 */         byteBuffer.order(this.byteBuffer.order());
/* 200 */         this.byteBuffer = byteBuffer;
/* 201 */         return true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void flush() {
/* 207 */     if (this.outputStream == null)
/*     */       return;  try {
/* 209 */       byte[] arrayOfByte = new byte[this.position];
/* 210 */       setBufferPosition(this.byteBuffer, 0);
/* 211 */       this.byteBuffer.get(arrayOfByte);
/* 212 */       setBufferPosition(this.byteBuffer, 0);
/* 213 */       this.outputStream.write(arrayOfByte, 0, this.position);
/* 214 */     } catch (IOException iOException) {
/* 215 */       throw new KryoException(iOException);
/*     */     } 
/* 217 */     this.total += this.position;
/* 218 */     this.position = 0;
/*     */   }
/*     */   
/*     */   public void close() {
/* 222 */     flush();
/* 223 */     if (this.outputStream != null) {
/*     */       try {
/* 225 */         this.outputStream.close(); return;
/* 226 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/* 232 */     if (this.position == this.capacity) require(1); 
/* 233 */     this.byteBuffer.put((byte)paramInt);
/* 234 */     this.position++;
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/* 238 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 239 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 243 */     writeBytes(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeByte(byte paramByte) {
/* 249 */     if (this.position == this.capacity) require(1); 
/* 250 */     this.byteBuffer.put(paramByte);
/* 251 */     this.position++;
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/* 255 */     if (this.position == this.capacity) require(1); 
/* 256 */     this.byteBuffer.put((byte)paramInt);
/* 257 */     this.position++;
/*     */   }
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte) {
/* 261 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 262 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 266 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 267 */     int i = Math.min(this.capacity - this.position, paramInt2);
/*     */     while (true) {
/* 269 */       this.byteBuffer.put(paramArrayOfbyte, paramInt1, i);
/* 270 */       this.position += i;
/*     */       
/* 272 */       if ((paramInt2 = paramInt2 - i) == 0)
/* 273 */         return;  paramInt1 += i;
/* 274 */       i = Math.min(this.capacity, paramInt2);
/* 275 */       require(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeInt(int paramInt) {
/* 282 */     require(4);
/* 283 */     this.position += 4;
/*     */     ByteBuffer byteBuffer;
/* 285 */     (byteBuffer = this.byteBuffer).put((byte)paramInt);
/* 286 */     byteBuffer.put((byte)(paramInt >> 8));
/* 287 */     byteBuffer.put((byte)(paramInt >> 16));
/* 288 */     byteBuffer.put((byte)(paramInt >> 24));
/*     */   }
/*     */   
/*     */   public int writeVarInt(int paramInt, boolean paramBoolean) {
/* 292 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 293 */     if (paramInt >>> 7 == 0) {
/* 294 */       if (this.position == this.capacity) require(1); 
/* 295 */       this.position++;
/* 296 */       this.byteBuffer.put((byte)paramInt);
/* 297 */       return 1;
/*     */     } 
/* 299 */     if (paramInt >>> 14 == 0) {
/* 300 */       require(2);
/* 301 */       this.position += 2;
/* 302 */       this.byteBuffer.put((byte)(paramInt & 0x7F | 0x80));
/* 303 */       this.byteBuffer.put((byte)(paramInt >>> 7));
/* 304 */       return 2;
/*     */     } 
/* 306 */     if (paramInt >>> 21 == 0) {
/* 307 */       require(3);
/* 308 */       this.position += 3;
/*     */       ByteBuffer byteBuffer1;
/* 310 */       (byteBuffer1 = this.byteBuffer).put((byte)(paramInt & 0x7F | 0x80));
/* 311 */       byteBuffer1.put((byte)(paramInt >>> 7 | 0x80));
/* 312 */       byteBuffer1.put((byte)(paramInt >>> 14));
/* 313 */       return 3;
/*     */     } 
/* 315 */     if (paramInt >>> 28 == 0) {
/* 316 */       require(4);
/* 317 */       this.position += 4;
/*     */       ByteBuffer byteBuffer1;
/* 319 */       (byteBuffer1 = this.byteBuffer).put((byte)(paramInt & 0x7F | 0x80));
/* 320 */       byteBuffer1.put((byte)(paramInt >>> 7 | 0x80));
/* 321 */       byteBuffer1.put((byte)(paramInt >>> 14 | 0x80));
/* 322 */       byteBuffer1.put((byte)(paramInt >>> 21));
/* 323 */       return 4;
/*     */     } 
/* 325 */     require(5);
/* 326 */     this.position += 5;
/*     */     ByteBuffer byteBuffer;
/* 328 */     (byteBuffer = this.byteBuffer).put((byte)(paramInt & 0x7F | 0x80));
/* 329 */     byteBuffer.put((byte)(paramInt >>> 7 | 0x80));
/* 330 */     byteBuffer.put((byte)(paramInt >>> 14 | 0x80));
/* 331 */     byteBuffer.put((byte)(paramInt >>> 21 | 0x80));
/* 332 */     byteBuffer.put((byte)(paramInt >>> 28));
/* 333 */     return 5;
/*     */   }
/*     */   
/*     */   public int writeVarIntFlag(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
/* 337 */     if (!paramBoolean2) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 338 */     int i = paramInt & 0x3F | (paramBoolean1 ? 128 : 0);
/* 339 */     if (paramInt >>> 6 == 0) {
/* 340 */       if (this.position == this.capacity) require(1); 
/* 341 */       this.byteBuffer.put((byte)i);
/* 342 */       this.position++;
/* 343 */       return 1;
/*     */     } 
/* 345 */     if (paramInt >>> 13 == 0) {
/* 346 */       require(2);
/* 347 */       this.position += 2;
/* 348 */       this.byteBuffer.put((byte)(i | 0x40));
/* 349 */       this.byteBuffer.put((byte)(paramInt >>> 6));
/* 350 */       return 2;
/*     */     } 
/* 352 */     if (paramInt >>> 20 == 0) {
/* 353 */       require(3);
/* 354 */       this.position += 3;
/*     */       ByteBuffer byteBuffer1;
/* 356 */       (byteBuffer1 = this.byteBuffer).put((byte)(i | 0x40));
/* 357 */       byteBuffer1.put((byte)(paramInt >>> 6 | 0x80));
/* 358 */       byteBuffer1.put((byte)(paramInt >>> 13));
/* 359 */       return 3;
/*     */     } 
/* 361 */     if (paramInt >>> 27 == 0) {
/* 362 */       require(4);
/* 363 */       this.position += 4;
/*     */       ByteBuffer byteBuffer1;
/* 365 */       (byteBuffer1 = this.byteBuffer).put((byte)(i | 0x40));
/* 366 */       byteBuffer1.put((byte)(paramInt >>> 6 | 0x80));
/* 367 */       byteBuffer1.put((byte)(paramInt >>> 13 | 0x80));
/* 368 */       byteBuffer1.put((byte)(paramInt >>> 20));
/* 369 */       return 4;
/*     */     } 
/* 371 */     require(5);
/* 372 */     this.position += 5;
/*     */     ByteBuffer byteBuffer;
/* 374 */     (byteBuffer = this.byteBuffer).put((byte)(i | 0x40));
/* 375 */     byteBuffer.put((byte)(paramInt >>> 6 | 0x80));
/* 376 */     byteBuffer.put((byte)(paramInt >>> 13 | 0x80));
/* 377 */     byteBuffer.put((byte)(paramInt >>> 20 | 0x80));
/* 378 */     byteBuffer.put((byte)(paramInt >>> 27));
/* 379 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeLong(long paramLong) {
/* 385 */     require(8);
/* 386 */     this.position += 8;
/*     */     ByteBuffer byteBuffer;
/* 388 */     (byteBuffer = this.byteBuffer).put((byte)(int)paramLong);
/* 389 */     byteBuffer.put((byte)(int)(paramLong >>> 8L));
/* 390 */     byteBuffer.put((byte)(int)(paramLong >>> 16L));
/* 391 */     byteBuffer.put((byte)(int)(paramLong >>> 24L));
/* 392 */     byteBuffer.put((byte)(int)(paramLong >>> 32L));
/* 393 */     byteBuffer.put((byte)(int)(paramLong >>> 40L));
/* 394 */     byteBuffer.put((byte)(int)(paramLong >>> 48L));
/* 395 */     byteBuffer.put((byte)(int)(paramLong >>> 56L));
/*     */   }
/*     */   
/*     */   public int writeVarLong(long paramLong, boolean paramBoolean) {
/* 399 */     if (!paramBoolean) paramLong = paramLong << 1L ^ paramLong >> 63L; 
/* 400 */     if (paramLong >>> 7L == 0L) {
/* 401 */       if (this.position == this.capacity) require(1); 
/* 402 */       this.position++;
/* 403 */       this.byteBuffer.put((byte)(int)paramLong);
/* 404 */       return 1;
/*     */     } 
/* 406 */     if (paramLong >>> 14L == 0L) {
/* 407 */       require(2);
/* 408 */       this.position += 2;
/* 409 */       this.byteBuffer.put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 410 */       this.byteBuffer.put((byte)(int)(paramLong >>> 7L));
/* 411 */       return 2;
/*     */     } 
/* 413 */     if (paramLong >>> 21L == 0L) {
/* 414 */       require(3);
/* 415 */       this.position += 3;
/*     */       ByteBuffer byteBuffer1;
/* 417 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 418 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 419 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L));
/* 420 */       return 3;
/*     */     } 
/* 422 */     if (paramLong >>> 28L == 0L) {
/* 423 */       require(4);
/* 424 */       this.position += 4;
/*     */       ByteBuffer byteBuffer1;
/* 426 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 427 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 428 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 429 */       byteBuffer1.put((byte)(int)(paramLong >>> 21L));
/* 430 */       return 4;
/*     */     } 
/* 432 */     if (paramLong >>> 35L == 0L) {
/* 433 */       require(5);
/* 434 */       this.position += 5;
/*     */       ByteBuffer byteBuffer1;
/* 436 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 437 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 438 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 439 */       byteBuffer1.put((byte)(int)(paramLong >>> 21L | 0x80L));
/* 440 */       byteBuffer1.put((byte)(int)(paramLong >>> 28L));
/* 441 */       return 5;
/*     */     } 
/* 443 */     if (paramLong >>> 42L == 0L) {
/* 444 */       require(6);
/* 445 */       this.position += 6;
/*     */       ByteBuffer byteBuffer1;
/* 447 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 448 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 449 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 450 */       byteBuffer1.put((byte)(int)(paramLong >>> 21L | 0x80L));
/* 451 */       byteBuffer1.put((byte)(int)(paramLong >>> 28L | 0x80L));
/* 452 */       byteBuffer1.put((byte)(int)(paramLong >>> 35L));
/* 453 */       return 6;
/*     */     } 
/* 455 */     if (paramLong >>> 49L == 0L) {
/* 456 */       require(7);
/* 457 */       this.position += 7;
/*     */       ByteBuffer byteBuffer1;
/* 459 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 460 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 461 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 462 */       byteBuffer1.put((byte)(int)(paramLong >>> 21L | 0x80L));
/* 463 */       byteBuffer1.put((byte)(int)(paramLong >>> 28L | 0x80L));
/* 464 */       byteBuffer1.put((byte)(int)(paramLong >>> 35L | 0x80L));
/* 465 */       byteBuffer1.put((byte)(int)(paramLong >>> 42L));
/* 466 */       return 7;
/*     */     } 
/* 468 */     if (paramLong >>> 56L == 0L) {
/* 469 */       require(8);
/* 470 */       this.position += 8;
/*     */       ByteBuffer byteBuffer1;
/* 472 */       (byteBuffer1 = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 473 */       byteBuffer1.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 474 */       byteBuffer1.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 475 */       byteBuffer1.put((byte)(int)(paramLong >>> 21L | 0x80L));
/* 476 */       byteBuffer1.put((byte)(int)(paramLong >>> 28L | 0x80L));
/* 477 */       byteBuffer1.put((byte)(int)(paramLong >>> 35L | 0x80L));
/* 478 */       byteBuffer1.put((byte)(int)(paramLong >>> 42L | 0x80L));
/* 479 */       byteBuffer1.put((byte)(int)(paramLong >>> 49L));
/* 480 */       return 8;
/*     */     } 
/* 482 */     require(9);
/* 483 */     this.position += 9;
/*     */     ByteBuffer byteBuffer;
/* 485 */     (byteBuffer = this.byteBuffer).put((byte)(int)(paramLong & 0x7FL | 0x80L));
/* 486 */     byteBuffer.put((byte)(int)(paramLong >>> 7L | 0x80L));
/* 487 */     byteBuffer.put((byte)(int)(paramLong >>> 14L | 0x80L));
/* 488 */     byteBuffer.put((byte)(int)(paramLong >>> 21L | 0x80L));
/* 489 */     byteBuffer.put((byte)(int)(paramLong >>> 28L | 0x80L));
/* 490 */     byteBuffer.put((byte)(int)(paramLong >>> 35L | 0x80L));
/* 491 */     byteBuffer.put((byte)(int)(paramLong >>> 42L | 0x80L));
/* 492 */     byteBuffer.put((byte)(int)(paramLong >>> 49L | 0x80L));
/* 493 */     byteBuffer.put((byte)(int)(paramLong >>> 56L));
/* 494 */     return 9;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFloat(float paramFloat) {
/* 500 */     require(4);
/* 501 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 502 */     this.position += 4;
/* 503 */     int i = Float.floatToIntBits(paramFloat);
/* 504 */     byteBuffer.put((byte)i);
/* 505 */     byteBuffer.put((byte)(i >> 8));
/* 506 */     byteBuffer.put((byte)(i >> 16));
/* 507 */     byteBuffer.put((byte)(i >> 24));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/* 513 */     require(8);
/* 514 */     this.position += 8;
/* 515 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 516 */     long l = Double.doubleToLongBits(paramDouble);
/* 517 */     byteBuffer.put((byte)(int)l);
/* 518 */     byteBuffer.put((byte)(int)(l >>> 8L));
/* 519 */     byteBuffer.put((byte)(int)(l >>> 16L));
/* 520 */     byteBuffer.put((byte)(int)(l >>> 24L));
/* 521 */     byteBuffer.put((byte)(int)(l >>> 32L));
/* 522 */     byteBuffer.put((byte)(int)(l >>> 40L));
/* 523 */     byteBuffer.put((byte)(int)(l >>> 48L));
/* 524 */     byteBuffer.put((byte)(int)(l >>> 56L));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeShort(int paramInt) {
/* 530 */     require(2);
/* 531 */     this.position += 2;
/* 532 */     this.byteBuffer.put((byte)paramInt);
/* 533 */     this.byteBuffer.put((byte)(paramInt >>> 8));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeChar(char paramChar) {
/* 539 */     require(2);
/* 540 */     this.position += 2;
/* 541 */     this.byteBuffer.put((byte)paramChar);
/* 542 */     this.byteBuffer.put((byte)(paramChar >>> 8));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/* 548 */     if (this.position == this.capacity) require(1); 
/* 549 */     this.byteBuffer.put((byte)(paramBoolean ? 1 : 0));
/* 550 */     this.position++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeString(String paramString) {
/* 556 */     if (paramString == null) {
/* 557 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 561 */     if ((i = paramString.length()) == 0) {
/* 562 */       writeByte(129);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 567 */     if (i > 1 && i <= 32) {
/* 568 */       byte b1; for (b1 = 0; b1 < i; ) {
/* 569 */         if (paramString.charAt(b1) <= '') { b1++; continue; }  // Byte code: goto -> 162
/* 570 */       }  if (this.capacity - this.position < i) {
/* 571 */         writeAscii_slow(paramString, i);
/*     */       } else {
/* 573 */         int j; for (b1 = 0, j = paramString.length(); b1 < j; b1++)
/* 574 */           this.byteBuffer.put((byte)paramString.charAt(b1)); 
/* 575 */         this.position += i;
/*     */       } 
/* 577 */       this.byteBuffer.put(this.position - 1, (byte)(this.byteBuffer.get(this.position - 1) | 0x80));
/*     */       return;
/*     */     } 
/* 580 */     writeVarIntFlag(true, i + 1, true);
/* 581 */     byte b = 0;
/* 582 */     if (this.capacity - this.position >= i) {
/*     */       
/* 584 */       ByteBuffer byteBuffer = this.byteBuffer;
/*     */       
/*     */       char c;
/* 587 */       while ((c = paramString.charAt(b)) <= '') {
/* 588 */         byteBuffer.put((byte)c);
/* 589 */         b++;
/* 590 */         if (b == i) {
/* 591 */           this.position = getBufferPosition(byteBuffer);
/*     */           return;
/*     */         } 
/*     */       } 
/* 595 */       this.position = getBufferPosition(byteBuffer);
/*     */     } 
/* 597 */     if (b < i) writeUtf8_slow(paramString, i, b); 
/*     */   }
/*     */   
/*     */   public void writeAscii(String paramString) {
/* 601 */     if (paramString == null) {
/* 602 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 606 */     switch (i = paramString.length()) {
/*     */       case 0:
/* 608 */         writeByte(129);
/*     */         return;
/*     */       case 1:
/* 611 */         require(2);
/* 612 */         this.byteBuffer.put((byte)-126);
/* 613 */         this.byteBuffer.put((byte)paramString.charAt(0));
/* 614 */         this.position += 2;
/*     */         return;
/*     */     } 
/* 617 */     if (this.capacity - this.position < i) {
/* 618 */       writeAscii_slow(paramString, i);
/*     */     } else {
/* 620 */       ByteBuffer byteBuffer = this.byteBuffer; byte b; int j;
/* 621 */       for (b = 0, j = paramString.length(); b < j; b++)
/* 622 */         byteBuffer.put((byte)paramString.charAt(b)); 
/* 623 */       this.position += i;
/*     */     } 
/* 625 */     this.byteBuffer.put(this.position - 1, (byte)(this.byteBuffer.get(this.position - 1) | 0x80));
/*     */   }
/*     */   
/*     */   private void writeUtf8_slow(String paramString, int paramInt1, int paramInt2) {
/* 629 */     for (; paramInt2 < paramInt1; paramInt2++) {
/* 630 */       if (this.position == this.capacity) require(Math.min(this.capacity, paramInt1 - paramInt2)); 
/* 631 */       this.position++;
/*     */       char c;
/* 633 */       if ((c = paramString.charAt(paramInt2)) <= '') {
/* 634 */         this.byteBuffer.put((byte)c);
/* 635 */       } else if (c > '߿') {
/* 636 */         this.byteBuffer.put((byte)(0xE0 | c >> 12 & 0xF));
/* 637 */         require(2);
/* 638 */         this.position += 2;
/* 639 */         this.byteBuffer.put((byte)(0x80 | c >> 6 & 0x3F));
/* 640 */         this.byteBuffer.put((byte)(0x80 | c & 0x3F));
/*     */       } else {
/* 642 */         this.byteBuffer.put((byte)(0xC0 | c >> 6 & 0x1F));
/* 643 */         if (this.position == this.capacity) require(1); 
/* 644 */         this.position++;
/* 645 */         this.byteBuffer.put((byte)(0x80 | c & 0x3F));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeAscii_slow(String paramString, int paramInt) {
/* 651 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 652 */     int i = 0;
/* 653 */     int j = Math.min(paramInt, this.capacity - this.position);
/* 654 */     while (i < paramInt) {
/* 655 */       byte[] arrayOfByte = new byte[paramInt];
/* 656 */       paramString.getBytes(i, i + j, arrayOfByte, 0);
/* 657 */       byteBuffer.put(arrayOfByte, 0, j);
/* 658 */       i += j;
/* 659 */       this.position += j;
/* 660 */       j = Math.min(paramInt - i, this.capacity);
/* 661 */       if (require(j)) byteBuffer = this.byteBuffer;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeInts(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 668 */     if (this.capacity >= paramInt2 << 2) {
/* 669 */       require(paramInt2 << 2);
/* 670 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 671 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 672 */         int j = paramArrayOfint[paramInt1];
/* 673 */         byteBuffer.put((byte)j);
/* 674 */         byteBuffer.put((byte)(j >> 8));
/* 675 */         byteBuffer.put((byte)(j >> 16));
/* 676 */         byteBuffer.put((byte)(j >> 24));
/*     */       } 
/* 678 */       this.position = getBufferPosition(byteBuffer); return;
/*     */     } 
/* 680 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 681 */       writeInt(paramArrayOfint[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeLongs(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 686 */     if (this.capacity >= paramInt2 << 3) {
/* 687 */       require(paramInt2 << 3);
/* 688 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 689 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 690 */         long l = paramArrayOflong[paramInt1];
/* 691 */         byteBuffer.put((byte)(int)l);
/* 692 */         byteBuffer.put((byte)(int)(l >>> 8L));
/* 693 */         byteBuffer.put((byte)(int)(l >>> 16L));
/* 694 */         byteBuffer.put((byte)(int)(l >>> 24L));
/* 695 */         byteBuffer.put((byte)(int)(l >>> 32L));
/* 696 */         byteBuffer.put((byte)(int)(l >>> 40L));
/* 697 */         byteBuffer.put((byte)(int)(l >>> 48L));
/* 698 */         byteBuffer.put((byte)(int)(l >>> 56L));
/*     */       } 
/* 700 */       this.position = getBufferPosition(byteBuffer); return;
/*     */     } 
/* 702 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 703 */       writeLong(paramArrayOflong[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeFloats(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 708 */     if (this.capacity >= paramInt2 << 2) {
/* 709 */       require(paramInt2 << 2);
/* 710 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 711 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 712 */         int j = Float.floatToIntBits(paramArrayOffloat[paramInt1]);
/* 713 */         byteBuffer.put((byte)j);
/* 714 */         byteBuffer.put((byte)(j >> 8));
/* 715 */         byteBuffer.put((byte)(j >> 16));
/* 716 */         byteBuffer.put((byte)(j >> 24));
/*     */       } 
/* 718 */       this.position = getBufferPosition(byteBuffer); return;
/*     */     } 
/* 720 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 721 */       writeFloat(paramArrayOffloat[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeDoubles(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 726 */     if (this.capacity >= paramInt2 << 3) {
/* 727 */       require(paramInt2 << 3);
/* 728 */       ByteBuffer byteBuffer = this.byteBuffer;
/* 729 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 730 */         long l = Double.doubleToLongBits(paramArrayOfdouble[paramInt1]);
/* 731 */         byteBuffer.put((byte)(int)l);
/* 732 */         byteBuffer.put((byte)(int)(l >>> 8L));
/* 733 */         byteBuffer.put((byte)(int)(l >>> 16L));
/* 734 */         byteBuffer.put((byte)(int)(l >>> 24L));
/* 735 */         byteBuffer.put((byte)(int)(l >>> 32L));
/* 736 */         byteBuffer.put((byte)(int)(l >>> 40L));
/* 737 */         byteBuffer.put((byte)(int)(l >>> 48L));
/* 738 */         byteBuffer.put((byte)(int)(l >>> 56L));
/*     */       } 
/* 740 */       this.position = getBufferPosition(byteBuffer); return;
/*     */     } 
/* 742 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 743 */       writeDouble(paramArrayOfdouble[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeShorts(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 748 */     if (this.capacity >= paramInt2 << 1) {
/* 749 */       require(paramInt2 << 1);
/* 750 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 751 */         short s = paramArrayOfshort[paramInt1];
/* 752 */         this.byteBuffer.put((byte)s);
/* 753 */         this.byteBuffer.put((byte)(s >>> 8));
/*     */       } 
/* 755 */       this.position = getBufferPosition(this.byteBuffer); return;
/*     */     } 
/* 757 */     for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 758 */       writeShort(paramArrayOfshort[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 763 */     if (this.capacity >= paramInt2 << 1) {
/* 764 */       require(paramInt2 << 1);
/* 765 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 766 */         char c = paramArrayOfchar[paramInt1];
/* 767 */         this.byteBuffer.put((byte)c);
/* 768 */         this.byteBuffer.put((byte)(c >>> 8));
/*     */       } 
/* 770 */       this.position = getBufferPosition(this.byteBuffer); return;
/*     */     } 
/* 772 */     for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/* 773 */       writeChar(paramArrayOfchar[paramInt1]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeBooleans(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 778 */     if (this.capacity >= paramInt2) {
/* 779 */       require(paramInt2);
/* 780 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++)
/* 781 */         this.byteBuffer.put(paramArrayOfboolean[paramInt1] ? 1 : 0); 
/* 782 */       this.position = getBufferPosition(this.byteBuffer); return;
/*     */     } 
/* 784 */     for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++)
/* 785 */       writeBoolean(paramArrayOfboolean[paramInt1]); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\ByteBufferOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */