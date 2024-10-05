/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.util.Pool;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Output
/*     */   extends OutputStream
/*     */   implements Pool.Poolable, AutoCloseable
/*     */ {
/*     */   protected int maxCapacity;
/*     */   protected long total;
/*     */   protected int position;
/*     */   protected int capacity;
/*     */   protected byte[] buffer;
/*     */   protected OutputStream outputStream;
/*     */   protected boolean varEncoding = true;
/*     */   
/*     */   public Output() {}
/*     */   
/*     */   public Output(int paramInt) {
/*  50 */     this(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Output(int paramInt1, int paramInt2) {
/*  58 */     if (paramInt1 > paramInt2 && paramInt2 != -1) throw new IllegalArgumentException("bufferSize: " + paramInt1 + " cannot be greater than maxBufferSize: " + paramInt2);
/*     */     
/*  60 */     if (paramInt2 < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt2); 
/*  61 */     this.capacity = paramInt1;
/*  62 */     this.maxCapacity = (paramInt2 == -1) ? 2147483639 : paramInt2;
/*  63 */     this.buffer = new byte[paramInt1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Output(byte[] paramArrayOfbyte) {
/*  69 */     this(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Output(byte[] paramArrayOfbyte, int paramInt) {
/*  75 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("buffer cannot be null."); 
/*  76 */     setBuffer(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Output(OutputStream paramOutputStream) {
/*  81 */     this(4096, 4096);
/*  82 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  83 */     this.outputStream = paramOutputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public Output(OutputStream paramOutputStream, int paramInt) {
/*  88 */     this(paramInt, paramInt);
/*  89 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  90 */     this.outputStream = paramOutputStream;
/*     */   }
/*     */   
/*     */   public OutputStream getOutputStream() {
/*  94 */     return this.outputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutputStream(OutputStream paramOutputStream) {
/* 101 */     this.outputStream = paramOutputStream;
/* 102 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte) {
/* 108 */     setBuffer(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt) {
/* 116 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("buffer cannot be null."); 
/* 117 */     if (paramArrayOfbyte.length > paramInt && paramInt != -1) throw new IllegalArgumentException("buffer has length: " + paramArrayOfbyte.length + " cannot be greater than maxBufferSize: " + paramInt);
/*     */     
/* 119 */     if (paramInt < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt); 
/* 120 */     this.buffer = paramArrayOfbyte;
/* 121 */     this.maxCapacity = (paramInt == -1) ? 2147483639 : paramInt;
/* 122 */     this.capacity = paramArrayOfbyte.length;
/* 123 */     this.position = 0;
/* 124 */     this.total = 0L;
/* 125 */     this.outputStream = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBuffer() {
/* 130 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes() {
/* 135 */     byte[] arrayOfByte = new byte[this.position];
/* 136 */     System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.position);
/* 137 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public boolean getVariableLengthEncoding() {
/* 141 */     return this.varEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVariableLengthEncoding(boolean paramBoolean) {
/* 148 */     this.varEncoding = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int position() {
/* 153 */     return this.position;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(int paramInt) {
/* 158 */     this.position = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public long total() {
/* 163 */     return this.total + this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCapacity() {
/* 169 */     return this.maxCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 174 */     this.position = 0;
/* 175 */     this.total = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean require(int paramInt) {
/* 181 */     if (this.capacity - this.position >= paramInt) return false; 
/* 182 */     flush();
/* 183 */     if (this.capacity - this.position >= paramInt) return true; 
/* 184 */     if (paramInt > this.maxCapacity - this.position) {
/* 185 */       if (paramInt > this.maxCapacity)
/* 186 */         throw new KryoBufferOverflowException("Buffer overflow. Max capacity: " + this.maxCapacity + ", required: " + paramInt); 
/* 187 */       throw new KryoBufferOverflowException("Buffer overflow. Available: " + (this.maxCapacity - this.position) + ", required: " + paramInt);
/*     */     } 
/*     */     
/* 190 */     if (this.capacity == 0) this.capacity = 16; 
/*     */     while (true) {
/* 192 */       this.capacity = Math.min(this.capacity << 1, this.maxCapacity);
/* 193 */       if (this.capacity - this.position >= paramInt) {
/* 194 */         byte[] arrayOfByte = new byte[this.capacity];
/* 195 */         System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.position);
/* 196 */         this.buffer = arrayOfByte;
/* 197 */         return true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 205 */     if (this.outputStream == null)
/*     */       return;  try {
/* 207 */       this.outputStream.write(this.buffer, 0, this.position);
/* 208 */       this.outputStream.flush();
/* 209 */     } catch (IOException iOException) {
/* 210 */       throw new KryoException(iOException);
/*     */     } 
/* 212 */     this.total += this.position;
/* 213 */     this.position = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 218 */     flush();
/* 219 */     if (this.outputStream != null) {
/*     */       try {
/* 221 */         this.outputStream.close(); return;
/* 222 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/* 229 */     if (this.position == this.capacity) require(1); 
/* 230 */     this.buffer[this.position++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/* 235 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 236 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 241 */     writeBytes(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeByte(byte paramByte) {
/* 247 */     if (this.position == this.capacity) require(1); 
/* 248 */     this.buffer[this.position++] = paramByte;
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/* 252 */     if (this.position == this.capacity) require(1); 
/* 253 */     this.buffer[this.position++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte) {
/* 258 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 259 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 264 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 265 */     int i = Math.min(this.capacity - this.position, paramInt2);
/*     */     while (true) {
/* 267 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.position, i);
/* 268 */       this.position += i;
/*     */       
/* 270 */       if ((paramInt2 = paramInt2 - i) == 0)
/* 271 */         return;  paramInt1 += i;
/* 272 */       i = Math.min(Math.max(this.capacity, 1), paramInt2);
/* 273 */       require(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeInt(int paramInt) {
/* 281 */     require(4);
/* 282 */     byte[] arrayOfByte = this.buffer;
/* 283 */     int i = this.position;
/* 284 */     this.position = i + 4;
/* 285 */     arrayOfByte[i] = (byte)paramInt;
/* 286 */     arrayOfByte[i + 1] = (byte)(paramInt >> 8);
/* 287 */     arrayOfByte[i + 2] = (byte)(paramInt >> 16);
/* 288 */     arrayOfByte[i + 3] = (byte)(paramInt >> 24);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeInt(int paramInt, boolean paramBoolean) {
/* 297 */     if (this.varEncoding) return writeVarInt(paramInt, paramBoolean); 
/* 298 */     writeInt(paramInt);
/* 299 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarInt(int paramInt, boolean paramBoolean) {
/* 308 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 309 */     if (paramInt >>> 7 == 0) {
/* 310 */       if (this.position == this.capacity) require(1); 
/* 311 */       this.buffer[this.position++] = (byte)paramInt;
/* 312 */       return 1;
/*     */     } 
/* 314 */     if (paramInt >>> 14 == 0) {
/* 315 */       require(2);
/* 316 */       int j = this.position;
/* 317 */       this.position = j + 2;
/* 318 */       this.buffer[j] = (byte)(paramInt & 0x7F | 0x80);
/* 319 */       this.buffer[j + 1] = (byte)(paramInt >>> 7);
/* 320 */       return 2;
/*     */     } 
/* 322 */     if (paramInt >>> 21 == 0) {
/* 323 */       require(3);
/* 324 */       int j = this.position;
/* 325 */       this.position = j + 3;
/*     */       byte[] arrayOfByte1;
/* 327 */       (arrayOfByte1 = this.buffer)[j] = (byte)(paramInt & 0x7F | 0x80);
/* 328 */       arrayOfByte1[j + 1] = (byte)(paramInt >>> 7 | 0x80);
/* 329 */       arrayOfByte1[j + 2] = (byte)(paramInt >>> 14);
/* 330 */       return 3;
/*     */     } 
/* 332 */     if (paramInt >>> 28 == 0) {
/* 333 */       require(4);
/* 334 */       int j = this.position;
/* 335 */       this.position = j + 4;
/*     */       byte[] arrayOfByte1;
/* 337 */       (arrayOfByte1 = this.buffer)[j] = (byte)(paramInt & 0x7F | 0x80);
/* 338 */       arrayOfByte1[j + 1] = (byte)(paramInt >>> 7 | 0x80);
/* 339 */       arrayOfByte1[j + 2] = (byte)(paramInt >>> 14 | 0x80);
/* 340 */       arrayOfByte1[j + 3] = (byte)(paramInt >>> 21);
/* 341 */       return 4;
/*     */     } 
/* 343 */     require(5);
/* 344 */     int i = this.position;
/* 345 */     this.position = i + 5;
/*     */     byte[] arrayOfByte;
/* 347 */     (arrayOfByte = this.buffer)[i] = (byte)(paramInt & 0x7F | 0x80);
/* 348 */     arrayOfByte[i + 1] = (byte)(paramInt >>> 7 | 0x80);
/* 349 */     arrayOfByte[i + 2] = (byte)(paramInt >>> 14 | 0x80);
/* 350 */     arrayOfByte[i + 3] = (byte)(paramInt >>> 21 | 0x80);
/* 351 */     arrayOfByte[i + 4] = (byte)(paramInt >>> 28);
/* 352 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarIntFlag(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
/* 360 */     if (!paramBoolean2) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 361 */     int i = paramInt & 0x3F | (paramBoolean1 ? 128 : 0);
/* 362 */     if (paramInt >>> 6 == 0) {
/* 363 */       if (this.position == this.capacity) require(1); 
/* 364 */       this.buffer[this.position++] = (byte)i;
/* 365 */       return 1;
/*     */     } 
/* 367 */     if (paramInt >>> 13 == 0) {
/* 368 */       require(2);
/* 369 */       int k = this.position;
/* 370 */       this.position = k + 2;
/* 371 */       this.buffer[k] = (byte)(i | 0x40);
/* 372 */       this.buffer[k + 1] = (byte)(paramInt >>> 6);
/* 373 */       return 2;
/*     */     } 
/* 375 */     if (paramInt >>> 20 == 0) {
/* 376 */       require(3);
/* 377 */       byte[] arrayOfByte1 = this.buffer;
/* 378 */       int k = this.position;
/* 379 */       this.position = k + 3;
/* 380 */       arrayOfByte1[k] = (byte)(i | 0x40);
/* 381 */       arrayOfByte1[k + 1] = (byte)(paramInt >>> 6 | 0x80);
/* 382 */       arrayOfByte1[k + 2] = (byte)(paramInt >>> 13);
/* 383 */       return 3;
/*     */     } 
/* 385 */     if (paramInt >>> 27 == 0) {
/* 386 */       require(4);
/* 387 */       byte[] arrayOfByte1 = this.buffer;
/* 388 */       int k = this.position;
/* 389 */       this.position = k + 4;
/* 390 */       arrayOfByte1[k] = (byte)(i | 0x40);
/* 391 */       arrayOfByte1[k + 1] = (byte)(paramInt >>> 6 | 0x80);
/* 392 */       arrayOfByte1[k + 2] = (byte)(paramInt >>> 13 | 0x80);
/* 393 */       arrayOfByte1[k + 3] = (byte)(paramInt >>> 20);
/* 394 */       return 4;
/*     */     } 
/* 396 */     require(5);
/* 397 */     byte[] arrayOfByte = this.buffer;
/* 398 */     int j = this.position;
/* 399 */     this.position = j + 5;
/* 400 */     arrayOfByte[j] = (byte)(i | 0x40);
/* 401 */     arrayOfByte[j + 1] = (byte)(paramInt >>> 6 | 0x80);
/* 402 */     arrayOfByte[j + 2] = (byte)(paramInt >>> 13 | 0x80);
/* 403 */     arrayOfByte[j + 3] = (byte)(paramInt >>> 20 | 0x80);
/* 404 */     arrayOfByte[j + 4] = (byte)(paramInt >>> 27);
/* 405 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public int intLength(int paramInt, boolean paramBoolean) {
/* 410 */     if (this.varEncoding) return varIntLength(paramInt, paramBoolean); 
/* 411 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeLong(long paramLong) {
/* 418 */     require(8);
/* 419 */     byte[] arrayOfByte = this.buffer;
/* 420 */     int i = this.position;
/* 421 */     this.position = i + 8;
/* 422 */     arrayOfByte[i] = (byte)(int)paramLong;
/* 423 */     arrayOfByte[i + 1] = (byte)(int)(paramLong >>> 8L);
/* 424 */     arrayOfByte[i + 2] = (byte)(int)(paramLong >>> 16L);
/* 425 */     arrayOfByte[i + 3] = (byte)(int)(paramLong >>> 24L);
/* 426 */     arrayOfByte[i + 4] = (byte)(int)(paramLong >>> 32L);
/* 427 */     arrayOfByte[i + 5] = (byte)(int)(paramLong >>> 40L);
/* 428 */     arrayOfByte[i + 6] = (byte)(int)(paramLong >>> 48L);
/* 429 */     arrayOfByte[i + 7] = (byte)(int)(paramLong >>> 56L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeLong(long paramLong, boolean paramBoolean) {
/* 438 */     if (this.varEncoding) return writeVarLong(paramLong, paramBoolean); 
/* 439 */     writeLong(paramLong);
/* 440 */     return 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarLong(long paramLong, boolean paramBoolean) {
/* 450 */     if (!paramBoolean) paramLong = paramLong << 1L ^ paramLong >> 63L; 
/* 451 */     if (paramLong >>> 7L == 0L) {
/* 452 */       if (this.position == this.capacity) require(1); 
/* 453 */       this.buffer[this.position++] = (byte)(int)paramLong;
/* 454 */       return 1;
/*     */     } 
/* 456 */     if (paramLong >>> 14L == 0L) {
/* 457 */       require(2);
/* 458 */       int j = this.position;
/* 459 */       this.position = j + 2;
/* 460 */       this.buffer[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 461 */       this.buffer[j + 1] = (byte)(int)(paramLong >>> 7L);
/* 462 */       return 2;
/*     */     } 
/* 464 */     if (paramLong >>> 21L == 0L) {
/* 465 */       require(3);
/* 466 */       int j = this.position;
/* 467 */       this.position = j + 3;
/*     */       byte[] arrayOfByte1;
/* 469 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 470 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 471 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L);
/* 472 */       return 3;
/*     */     } 
/* 474 */     if (paramLong >>> 28L == 0L) {
/* 475 */       require(4);
/* 476 */       int j = this.position;
/* 477 */       this.position = j + 4;
/*     */       byte[] arrayOfByte1;
/* 479 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 480 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 481 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 482 */       arrayOfByte1[j + 3] = (byte)(int)(paramLong >>> 21L);
/* 483 */       return 4;
/*     */     } 
/* 485 */     if (paramLong >>> 35L == 0L) {
/* 486 */       require(5);
/* 487 */       int j = this.position;
/* 488 */       this.position = j + 5;
/*     */       byte[] arrayOfByte1;
/* 490 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 491 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 492 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 493 */       arrayOfByte1[j + 3] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 494 */       arrayOfByte1[j + 4] = (byte)(int)(paramLong >>> 28L);
/* 495 */       return 5;
/*     */     } 
/* 497 */     if (paramLong >>> 42L == 0L) {
/* 498 */       require(6);
/* 499 */       int j = this.position;
/* 500 */       this.position = j + 6;
/*     */       byte[] arrayOfByte1;
/* 502 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 503 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 504 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 505 */       arrayOfByte1[j + 3] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 506 */       arrayOfByte1[j + 4] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 507 */       arrayOfByte1[j + 5] = (byte)(int)(paramLong >>> 35L);
/* 508 */       return 6;
/*     */     } 
/* 510 */     if (paramLong >>> 49L == 0L) {
/* 511 */       require(7);
/* 512 */       int j = this.position;
/* 513 */       this.position = j + 7;
/*     */       byte[] arrayOfByte1;
/* 515 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 516 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 517 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 518 */       arrayOfByte1[j + 3] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 519 */       arrayOfByte1[j + 4] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 520 */       arrayOfByte1[j + 5] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 521 */       arrayOfByte1[j + 6] = (byte)(int)(paramLong >>> 42L);
/* 522 */       return 7;
/*     */     } 
/* 524 */     if (paramLong >>> 56L == 0L) {
/* 525 */       require(8);
/* 526 */       int j = this.position;
/* 527 */       this.position = j + 8;
/*     */       byte[] arrayOfByte1;
/* 529 */       (arrayOfByte1 = this.buffer)[j] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 530 */       arrayOfByte1[j + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 531 */       arrayOfByte1[j + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 532 */       arrayOfByte1[j + 3] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 533 */       arrayOfByte1[j + 4] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 534 */       arrayOfByte1[j + 5] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 535 */       arrayOfByte1[j + 6] = (byte)(int)(paramLong >>> 42L | 0x80L);
/* 536 */       arrayOfByte1[j + 7] = (byte)(int)(paramLong >>> 49L);
/* 537 */       return 8;
/*     */     } 
/* 539 */     require(9);
/* 540 */     int i = this.position;
/* 541 */     this.position = i + 9;
/*     */     byte[] arrayOfByte;
/* 543 */     (arrayOfByte = this.buffer)[i] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 544 */     arrayOfByte[i + 1] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 545 */     arrayOfByte[i + 2] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 546 */     arrayOfByte[i + 3] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 547 */     arrayOfByte[i + 4] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 548 */     arrayOfByte[i + 5] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 549 */     arrayOfByte[i + 6] = (byte)(int)(paramLong >>> 42L | 0x80L);
/* 550 */     arrayOfByte[i + 7] = (byte)(int)(paramLong >>> 49L | 0x80L);
/* 551 */     arrayOfByte[i + 8] = (byte)(int)(paramLong >>> 56L);
/* 552 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public int longLength(int paramInt, boolean paramBoolean) {
/* 557 */     if (this.varEncoding) return varLongLength(paramInt, paramBoolean); 
/* 558 */     return 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFloat(float paramFloat) {
/* 565 */     require(4);
/* 566 */     byte[] arrayOfByte = this.buffer;
/* 567 */     int j = this.position;
/* 568 */     this.position = j + 4;
/* 569 */     int i = Float.floatToIntBits(paramFloat);
/* 570 */     arrayOfByte[j] = (byte)i;
/* 571 */     arrayOfByte[j + 1] = (byte)(i >> 8);
/* 572 */     arrayOfByte[j + 2] = (byte)(i >> 16);
/* 573 */     arrayOfByte[j + 3] = (byte)(i >> 24);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarFloat(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 581 */     return writeVarInt((int)(paramFloat1 * paramFloat2), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/* 588 */     require(8);
/* 589 */     byte[] arrayOfByte = this.buffer;
/* 590 */     int i = this.position;
/* 591 */     this.position = i + 8;
/* 592 */     long l = Double.doubleToLongBits(paramDouble);
/* 593 */     arrayOfByte[i] = (byte)(int)l;
/* 594 */     arrayOfByte[i + 1] = (byte)(int)(l >>> 8L);
/* 595 */     arrayOfByte[i + 2] = (byte)(int)(l >>> 16L);
/* 596 */     arrayOfByte[i + 3] = (byte)(int)(l >>> 24L);
/* 597 */     arrayOfByte[i + 4] = (byte)(int)(l >>> 32L);
/* 598 */     arrayOfByte[i + 5] = (byte)(int)(l >>> 40L);
/* 599 */     arrayOfByte[i + 6] = (byte)(int)(l >>> 48L);
/* 600 */     arrayOfByte[i + 7] = (byte)(int)(l >>> 56L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarDouble(double paramDouble1, double paramDouble2, boolean paramBoolean) {
/* 608 */     return writeVarLong((long)(paramDouble1 * paramDouble2), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeShort(int paramInt) {
/* 615 */     require(2);
/* 616 */     int i = this.position;
/* 617 */     this.position = i + 2;
/* 618 */     this.buffer[i] = (byte)paramInt;
/* 619 */     this.buffer[i + 1] = (byte)(paramInt >>> 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeChar(char paramChar) {
/* 626 */     require(2);
/* 627 */     int i = this.position;
/* 628 */     this.position = i + 2;
/* 629 */     this.buffer[i] = (byte)paramChar;
/* 630 */     this.buffer[i + 1] = (byte)(paramChar >>> 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/* 637 */     if (this.position == this.capacity) require(1); 
/* 638 */     this.buffer[this.position++] = paramBoolean ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeString(String paramString) {
/* 648 */     if (paramString == null) {
/* 649 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 653 */     if ((i = paramString.length()) == 0) {
/* 654 */       writeByte(129);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 659 */     if (i > 1 && i <= 32) {
/* 660 */       for (byte b1 = 0; b1 < i; ) {
/* 661 */         if (paramString.charAt(b1) <= '') { b1++; continue; }  // Byte code: goto -> 128
/* 662 */       }  if (this.capacity - this.position < i) {
/* 663 */         writeAscii_slow(paramString, i);
/*     */       } else {
/* 665 */         paramString.getBytes(0, i, this.buffer, this.position);
/* 666 */         this.position += i;
/*     */       } 
/* 668 */       this.buffer[this.position - 1] = (byte)(this.buffer[this.position - 1] | 0x80);
/*     */       return;
/*     */     } 
/* 671 */     writeVarIntFlag(true, i + 1, true);
/* 672 */     byte b = 0;
/* 673 */     if (this.capacity - this.position >= i) {
/*     */       
/* 675 */       byte[] arrayOfByte = this.buffer;
/* 676 */       int j = this.position;
/*     */       
/*     */       char c;
/* 679 */       while ((c = paramString.charAt(b)) <= '') {
/* 680 */         arrayOfByte[j++] = (byte)c;
/* 681 */         b++;
/* 682 */         if (b == i) {
/* 683 */           this.position = j;
/*     */           return;
/*     */         } 
/*     */       } 
/* 687 */       this.position = j;
/*     */     } 
/* 689 */     if (b < i) writeUtf8_slow(paramString, i, b);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeAscii(String paramString) {
/* 698 */     if (paramString == null) {
/* 699 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 703 */     switch (i = paramString.length()) {
/*     */       case 0:
/* 705 */         writeByte(129);
/*     */         return;
/*     */       case 1:
/* 708 */         require(2);
/* 709 */         this.buffer[this.position++] = -126;
/* 710 */         this.buffer[this.position++] = (byte)paramString.charAt(0);
/*     */         return;
/*     */     } 
/* 713 */     if (this.capacity - this.position < i) {
/* 714 */       writeAscii_slow(paramString, i);
/*     */     } else {
/* 716 */       paramString.getBytes(0, i, this.buffer, this.position);
/* 717 */       this.position += i;
/*     */     } 
/* 719 */     this.buffer[this.position - 1] = (byte)(this.buffer[this.position - 1] | 0x80);
/*     */   }
/*     */   
/*     */   private void writeUtf8_slow(String paramString, int paramInt1, int paramInt2) {
/* 723 */     for (; paramInt2 < paramInt1; paramInt2++) {
/* 724 */       if (this.position == this.capacity) require(Math.min(this.capacity, paramInt1 - paramInt2)); 
/*     */       char c;
/* 726 */       if ((c = paramString.charAt(paramInt2)) <= '')
/* 727 */       { this.buffer[this.position++] = (byte)c; }
/* 728 */       else { if (c > '߿') {
/* 729 */           this.buffer[this.position++] = (byte)(0xE0 | c >> 12 & 0xF);
/* 730 */           require(2);
/* 731 */           this.buffer[this.position++] = (byte)(0x80 | c >> 6 & 0x3F);
/*     */         } else {
/*     */           
/* 734 */           this.buffer[this.position++] = (byte)(0xC0 | c >> 6 & 0x1F);
/* 735 */           if (this.position == this.capacity) require(1); 
/* 736 */         }  this.buffer[this.position++] = (byte)(0x80 | c & 0x3F); }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeAscii_slow(String paramString, int paramInt) {
/* 742 */     if (paramInt == 0)
/* 743 */       return;  if (this.position == this.capacity) require(1); 
/* 744 */     int i = 0;
/* 745 */     byte[] arrayOfByte = this.buffer;
/* 746 */     int j = Math.min(paramInt, this.capacity - this.position);
/* 747 */     while (i < paramInt) {
/* 748 */       paramString.getBytes(i, i + j, arrayOfByte, this.position);
/* 749 */       i += j;
/* 750 */       this.position += j;
/* 751 */       j = Math.min(paramInt - i, this.capacity);
/* 752 */       if (require(j)) arrayOfByte = this.buffer;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeInts(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 760 */     if (this.capacity >= paramInt2 << 2) {
/* 761 */       require(paramInt2 << 2);
/* 762 */       byte[] arrayOfByte = this.buffer;
/* 763 */       int j = this.position;
/* 764 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 4) {
/* 765 */         int k = paramArrayOfint[paramInt1];
/* 766 */         arrayOfByte[j] = (byte)k;
/* 767 */         arrayOfByte[j + 1] = (byte)(k >> 8);
/* 768 */         arrayOfByte[j + 2] = (byte)(k >> 16);
/* 769 */         arrayOfByte[j + 3] = (byte)(k >> 24);
/*     */       } 
/* 771 */       this.position = j; return;
/*     */     } 
/* 773 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 774 */       writeInt(paramArrayOfint[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeInts(int[] paramArrayOfint, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 781 */     if (this.varEncoding) {
/* 782 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++)
/* 783 */         writeVarInt(paramArrayOfint[paramInt1], paramBoolean);  return;
/*     */     } 
/* 785 */     writeInts(paramArrayOfint, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeLongs(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 790 */     if (this.capacity >= paramInt2 << 3) {
/* 791 */       require(paramInt2 << 3);
/* 792 */       byte[] arrayOfByte = this.buffer;
/* 793 */       int j = this.position;
/* 794 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 8) {
/* 795 */         long l = paramArrayOflong[paramInt1];
/* 796 */         arrayOfByte[j] = (byte)(int)l;
/* 797 */         arrayOfByte[j + 1] = (byte)(int)(l >>> 8L);
/* 798 */         arrayOfByte[j + 2] = (byte)(int)(l >>> 16L);
/* 799 */         arrayOfByte[j + 3] = (byte)(int)(l >>> 24L);
/* 800 */         arrayOfByte[j + 4] = (byte)(int)(l >>> 32L);
/* 801 */         arrayOfByte[j + 5] = (byte)(int)(l >>> 40L);
/* 802 */         arrayOfByte[j + 6] = (byte)(int)(l >>> 48L);
/* 803 */         arrayOfByte[j + 7] = (byte)(int)(l >>> 56L);
/*     */       } 
/* 805 */       this.position = j; return;
/*     */     } 
/* 807 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 808 */       writeLong(paramArrayOflong[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeLongs(long[] paramArrayOflong, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 815 */     if (this.varEncoding) {
/* 816 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++)
/* 817 */         writeVarLong(paramArrayOflong[paramInt1], paramBoolean);  return;
/*     */     } 
/* 819 */     writeLongs(paramArrayOflong, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeFloats(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 824 */     if (this.capacity >= paramInt2 << 2) {
/* 825 */       require(paramInt2 << 2);
/* 826 */       byte[] arrayOfByte = this.buffer;
/* 827 */       int j = this.position;
/* 828 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 4) {
/* 829 */         int k = Float.floatToIntBits(paramArrayOffloat[paramInt1]);
/* 830 */         arrayOfByte[j] = (byte)k;
/* 831 */         arrayOfByte[j + 1] = (byte)(k >> 8);
/* 832 */         arrayOfByte[j + 2] = (byte)(k >> 16);
/* 833 */         arrayOfByte[j + 3] = (byte)(k >> 24);
/*     */       } 
/* 835 */       this.position = j; return;
/*     */     } 
/* 837 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 838 */       writeFloat(paramArrayOffloat[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeDoubles(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 844 */     if (this.capacity >= paramInt2 << 3) {
/* 845 */       require(paramInt2 << 3);
/* 846 */       byte[] arrayOfByte = this.buffer;
/* 847 */       int j = this.position;
/* 848 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 8) {
/* 849 */         long l = Double.doubleToLongBits(paramArrayOfdouble[paramInt1]);
/* 850 */         arrayOfByte[j] = (byte)(int)l;
/* 851 */         arrayOfByte[j + 1] = (byte)(int)(l >>> 8L);
/* 852 */         arrayOfByte[j + 2] = (byte)(int)(l >>> 16L);
/* 853 */         arrayOfByte[j + 3] = (byte)(int)(l >>> 24L);
/* 854 */         arrayOfByte[j + 4] = (byte)(int)(l >>> 32L);
/* 855 */         arrayOfByte[j + 5] = (byte)(int)(l >>> 40L);
/* 856 */         arrayOfByte[j + 6] = (byte)(int)(l >>> 48L);
/* 857 */         arrayOfByte[j + 7] = (byte)(int)(l >>> 56L);
/*     */       } 
/* 859 */       this.position = j; return;
/*     */     } 
/* 861 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 862 */       writeDouble(paramArrayOfdouble[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeShorts(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 868 */     if (this.capacity >= paramInt2 << 1) {
/* 869 */       require(paramInt2 << 1);
/* 870 */       byte[] arrayOfByte = this.buffer;
/* 871 */       int j = this.position;
/* 872 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 2) {
/* 873 */         short s = paramArrayOfshort[paramInt1];
/* 874 */         arrayOfByte[j] = (byte)s;
/* 875 */         arrayOfByte[j + 1] = (byte)(s >>> 8);
/*     */       } 
/* 877 */       this.position = j; return;
/*     */     } 
/* 879 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 880 */       writeShort(paramArrayOfshort[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 886 */     if (this.capacity >= paramInt2 << 1) {
/* 887 */       require(paramInt2 << 1);
/* 888 */       byte[] arrayOfByte = this.buffer;
/* 889 */       int j = this.position;
/* 890 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j += 2) {
/* 891 */         char c = paramArrayOfchar[paramInt1];
/* 892 */         arrayOfByte[j] = (byte)c;
/* 893 */         arrayOfByte[j + 1] = (byte)(c >>> 8);
/*     */       } 
/* 895 */       this.position = j; return;
/*     */     } 
/* 897 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 898 */       writeChar(paramArrayOfchar[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBooleans(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 904 */     if (this.capacity >= paramInt2) {
/* 905 */       require(paramInt2);
/* 906 */       byte[] arrayOfByte = this.buffer;
/* 907 */       int j = this.position;
/* 908 */       for (paramInt2 = paramInt1 + paramInt2; paramInt1 < paramInt2; paramInt1++, j++)
/* 909 */         arrayOfByte[j] = paramArrayOfboolean[paramInt1] ? 1 : 0; 
/* 910 */       this.position = j; return;
/*     */     } 
/* 912 */     for (int i = paramInt1 + paramInt2; paramInt1 < i; paramInt1++) {
/* 913 */       writeBoolean(paramArrayOfboolean[paramInt1]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int varIntLength(int paramInt, boolean paramBoolean) {
/* 921 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 922 */     if (paramInt >>> 7 == 0) return 1; 
/* 923 */     if (paramInt >>> 14 == 0) return 2; 
/* 924 */     if (paramInt >>> 21 == 0) return 3; 
/* 925 */     if (paramInt >>> 28 == 0) return 4; 
/* 926 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int varLongLength(long paramLong, boolean paramBoolean) {
/* 931 */     if (!paramBoolean) paramLong = paramLong << 1L ^ paramLong >> 63L; 
/* 932 */     if (paramLong >>> 7L == 0L) return 1; 
/* 933 */     if (paramLong >>> 14L == 0L) return 2; 
/* 934 */     if (paramLong >>> 21L == 0L) return 3; 
/* 935 */     if (paramLong >>> 28L == 0L) return 4; 
/* 936 */     if (paramLong >>> 35L == 0L) return 5; 
/* 937 */     if (paramLong >>> 42L == 0L) return 6; 
/* 938 */     if (paramLong >>> 49L == 0L) return 7; 
/* 939 */     if (paramLong >>> 56L == 0L) return 8; 
/* 940 */     return 9;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\Output.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */