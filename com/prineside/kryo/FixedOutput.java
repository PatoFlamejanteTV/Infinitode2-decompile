/*     */ package com.prineside.kryo;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
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
/*     */ public class FixedOutput
/*     */   extends OutputStream
/*     */ {
/*     */   private int a;
/*     */   private long b;
/*     */   private int c;
/*     */   private int d;
/*     */   private byte[] e;
/*     */   private OutputStream f;
/*     */   
/*     */   public FixedOutput() {}
/*     */   
/*     */   public FixedOutput(int paramInt) {
/*  32 */     this(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedOutput(int paramInt1, int paramInt2) {
/*  40 */     if (paramInt2 < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt2); 
/*  41 */     this.d = paramInt1;
/*  42 */     this.a = (paramInt2 == -1) ? Integer.MAX_VALUE : paramInt2;
/*  43 */     this.e = new byte[paramInt1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedOutput(byte[] paramArrayOfbyte) {
/*  49 */     this(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedOutput(byte[] paramArrayOfbyte, int paramInt) {
/*  55 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("buffer cannot be null."); 
/*  56 */     setBuffer(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public FixedOutput(OutputStream paramOutputStream) {
/*  61 */     this(4096, 4096);
/*  62 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  63 */     this.f = paramOutputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public FixedOutput(OutputStream paramOutputStream, int paramInt) {
/*  68 */     this(paramInt, paramInt);
/*  69 */     if (paramOutputStream == null) throw new IllegalArgumentException("outputStream cannot be null."); 
/*  70 */     this.f = paramOutputStream;
/*     */   }
/*     */   
/*     */   public OutputStream getOutputStream() {
/*  74 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutputStream(OutputStream paramOutputStream) {
/*  80 */     this.f = paramOutputStream;
/*  81 */     this.c = 0;
/*  82 */     this.b = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void setBuffer(byte[] paramArrayOfbyte) {
/*  89 */     setBuffer(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt) {
/*  97 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("buffer cannot be null."); 
/*  98 */     if (paramInt < -1) throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + paramInt); 
/*  99 */     this.e = paramArrayOfbyte;
/* 100 */     this.a = (paramInt == -1) ? Integer.MAX_VALUE : paramInt;
/* 101 */     this.d = paramArrayOfbyte.length;
/* 102 */     this.c = 0;
/* 103 */     this.b = 0L;
/* 104 */     this.f = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBuffer() {
/* 109 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes() {
/* 114 */     byte[] arrayOfByte = new byte[this.c];
/* 115 */     System.arraycopy(this.e, 0, arrayOfByte, 0, this.c);
/* 116 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int position() {
/* 121 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(int paramInt) {
/* 126 */     this.c = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final long total() {
/* 131 */     return this.b + this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 136 */     this.c = 0;
/* 137 */     this.b = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(int paramInt) {
/* 142 */     if (this.d - this.c >= paramInt) return false; 
/* 143 */     if (paramInt > this.a)
/* 144 */       throw new KryoException("Buffer overflow. Max capacity: " + this.a + ", required: " + paramInt); 
/* 145 */     flush();
/* 146 */     while (this.d - this.c < paramInt) {
/* 147 */       if (this.d == this.a) {
/* 148 */         throw new KryoException("Buffer overflow. Available: " + (this.d - this.c) + ", required: " + paramInt);
/*     */       }
/* 150 */       if (this.d == 0) this.d = 1; 
/* 151 */       this.d = Math.min(this.d << 1, this.a);
/* 152 */       if (this.d < 0) this.d = this.a; 
/* 153 */       byte[] arrayOfByte = new byte[this.d];
/* 154 */       System.arraycopy(this.e, 0, arrayOfByte, 0, this.c);
/* 155 */       this.e = arrayOfByte;
/*     */     } 
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 164 */     if (this.f == null)
/*     */       return;  try {
/* 166 */       this.f.write(this.e, 0, this.c);
/* 167 */     } catch (IOException iOException) {
/* 168 */       throw new KryoException(iOException);
/*     */     } 
/* 170 */     this.b += this.c;
/* 171 */     this.c = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 176 */     flush();
/* 177 */     if (this.f != null) {
/*     */       try {
/* 179 */         this.f.close(); return;
/* 180 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void write(int paramInt) {
/* 188 */     if (this.c == this.d) a(1); 
/* 189 */     this.e[this.c++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void write(byte[] paramArrayOfbyte) {
/* 195 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 196 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 202 */     writeBytes(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeByte(byte paramByte) {
/* 209 */     if (this.c == this.d) a(1); 
/* 210 */     this.e[this.c++] = paramByte;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeByte(int paramInt) {
/* 215 */     if (this.c == this.d) a(1); 
/* 216 */     this.e[this.c++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeBytes(byte[] paramArrayOfbyte) {
/* 222 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 223 */     writeBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 229 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 230 */     int i = Math.min(this.d - this.c, paramInt2);
/*     */     while (true) {
/* 232 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.e, this.c, i);
/* 233 */       this.c += i;
/*     */       
/* 235 */       if ((paramInt2 = paramInt2 - i) == 0)
/* 236 */         return;  paramInt1 += i;
/* 237 */       i = Math.min(this.d, paramInt2);
/* 238 */       a(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeInt(int paramInt) {
/* 247 */     a(4);
/*     */     byte[] arrayOfByte;
/* 249 */     (arrayOfByte = this.e)[this.c++] = (byte)(paramInt >> 24);
/* 250 */     arrayOfByte[this.c++] = (byte)(paramInt >> 16);
/* 251 */     arrayOfByte[this.c++] = (byte)(paramInt >> 8);
/* 252 */     arrayOfByte[this.c++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int writeInt(int paramInt, boolean paramBoolean) {
/* 263 */     return writeVarInt(paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarInt(int paramInt, boolean paramBoolean) {
/* 271 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 272 */     if (paramInt >>> 7 == 0) {
/* 273 */       a(1);
/* 274 */       this.e[this.c++] = (byte)paramInt;
/* 275 */       return 1;
/*     */     } 
/* 277 */     if (paramInt >>> 14 == 0) {
/* 278 */       a(2);
/* 279 */       this.e[this.c++] = (byte)(paramInt & 0x7F | 0x80);
/* 280 */       this.e[this.c++] = (byte)(paramInt >>> 7);
/* 281 */       return 2;
/*     */     } 
/* 283 */     if (paramInt >>> 21 == 0) {
/* 284 */       a(3);
/* 285 */       this.e[this.c++] = (byte)(paramInt & 0x7F | 0x80);
/* 286 */       this.e[this.c++] = (byte)(paramInt >>> 7 | 0x80);
/* 287 */       this.e[this.c++] = (byte)(paramInt >>> 14);
/* 288 */       return 3;
/*     */     } 
/* 290 */     if (paramInt >>> 28 == 0) {
/* 291 */       a(4);
/* 292 */       this.e[this.c++] = (byte)(paramInt & 0x7F | 0x80);
/* 293 */       this.e[this.c++] = (byte)(paramInt >>> 7 | 0x80);
/* 294 */       this.e[this.c++] = (byte)(paramInt >>> 14 | 0x80);
/* 295 */       this.e[this.c++] = (byte)(paramInt >>> 21);
/* 296 */       return 4;
/*     */     } 
/* 298 */     a(5);
/* 299 */     this.e[this.c++] = (byte)(paramInt & 0x7F | 0x80);
/* 300 */     this.e[this.c++] = (byte)(paramInt >>> 7 | 0x80);
/* 301 */     this.e[this.c++] = (byte)(paramInt >>> 14 | 0x80);
/* 302 */     this.e[this.c++] = (byte)(paramInt >>> 21 | 0x80);
/* 303 */     this.e[this.c++] = (byte)(paramInt >>> 28);
/* 304 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeString(String paramString) {
/* 315 */     if (paramString == null) {
/* 316 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 320 */     if ((i = paramString.length()) == 0) {
/* 321 */       writeByte(129);
/*     */       
/*     */       return;
/*     */     } 
/* 325 */     int j = 0;
/* 326 */     if (i > 1 && i < 64) {
/* 327 */       j = 1;
/* 328 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         char c;
/* 330 */         if ((c = paramString.charAt(b1)) > '') {
/* 331 */           j = 0;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 336 */     if (j) {
/* 337 */       if (this.d - this.c < i) {
/* 338 */         a(paramString, i);
/*     */       } else {
/* 340 */         paramString.getBytes(0, i, this.e, this.c);
/* 341 */         this.c += i;
/*     */       } 
/* 343 */       this.e[this.c - 1] = (byte)(this.e[this.c - 1] | 0x80); return;
/*     */     } 
/* 345 */     b(i + 1);
/* 346 */     byte b = 0;
/* 347 */     if (this.d - this.c >= i) {
/*     */       
/* 349 */       byte[] arrayOfByte = this.e;
/* 350 */       j = this.c; char c;
/* 351 */       for (; b < i && (
/*     */         
/* 353 */         c = paramString.charAt(b)) <= ''; b++) {
/* 354 */         arrayOfByte[j++] = (byte)c;
/*     */       }
/* 356 */       this.c = j;
/*     */     } 
/* 358 */     if (b < i) a(paramString, i, b);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeString(CharSequence paramCharSequence) {
/* 367 */     if (paramCharSequence == null) {
/* 368 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 372 */     if ((i = paramCharSequence.length()) == 0) {
/* 373 */       writeByte(129);
/*     */       return;
/*     */     } 
/* 376 */     b(i + 1);
/* 377 */     byte b = 0;
/* 378 */     if (this.d - this.c >= i) {
/*     */       
/* 380 */       byte[] arrayOfByte = this.e;
/* 381 */       int j = this.c; char c;
/* 382 */       for (; b < i && (
/*     */         
/* 384 */         c = paramCharSequence.charAt(b)) <= ''; b++) {
/* 385 */         arrayOfByte[j++] = (byte)c;
/*     */       }
/* 387 */       this.c = j;
/*     */     } 
/* 389 */     if (b < i) a(paramCharSequence, i, b);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeAscii(String paramString) {
/* 398 */     if (paramString == null) {
/* 399 */       writeByte(128);
/*     */       return;
/*     */     } 
/*     */     int i;
/* 403 */     switch (i = paramString.length()) {
/*     */       case 0:
/* 405 */         writeByte(129);
/*     */         return;
/*     */       case 1:
/* 408 */         writeByte(130);
/* 409 */         writeByte(paramString.charAt(0));
/*     */         return;
/*     */     } 
/* 412 */     if (this.d - this.c < i) {
/* 413 */       a(paramString, i);
/*     */     } else {
/* 415 */       paramString.getBytes(0, i, this.e, this.c);
/* 416 */       this.c += i;
/*     */     } 
/* 418 */     this.e[this.c - 1] = (byte)(this.e[this.c - 1] | 0x80);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 424 */     if (paramInt >>> 6 == 0) {
/* 425 */       a(1);
/* 426 */       this.e[this.c++] = (byte)(paramInt | 0x80); return;
/* 427 */     }  if (paramInt >>> 13 == 0) {
/* 428 */       a(2);
/*     */       byte[] arrayOfByte1;
/* 430 */       (arrayOfByte1 = this.e)[this.c++] = (byte)(paramInt | 0x40 | 0x80);
/* 431 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 6); return;
/* 432 */     }  if (paramInt >>> 20 == 0) {
/* 433 */       a(3);
/*     */       byte[] arrayOfByte1;
/* 435 */       (arrayOfByte1 = this.e)[this.c++] = (byte)(paramInt | 0x40 | 0x80);
/* 436 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 6 | 0x80);
/* 437 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 13); return;
/* 438 */     }  if (paramInt >>> 27 == 0) {
/* 439 */       a(4);
/*     */       byte[] arrayOfByte1;
/* 441 */       (arrayOfByte1 = this.e)[this.c++] = (byte)(paramInt | 0x40 | 0x80);
/* 442 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 6 | 0x80);
/* 443 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 13 | 0x80);
/* 444 */       arrayOfByte1[this.c++] = (byte)(paramInt >>> 20); return;
/*     */     } 
/* 446 */     a(5);
/*     */     byte[] arrayOfByte;
/* 448 */     (arrayOfByte = this.e)[this.c++] = (byte)(paramInt | 0x40 | 0x80);
/* 449 */     arrayOfByte[this.c++] = (byte)(paramInt >>> 6 | 0x80);
/* 450 */     arrayOfByte[this.c++] = (byte)(paramInt >>> 13 | 0x80);
/* 451 */     arrayOfByte[this.c++] = (byte)(paramInt >>> 20 | 0x80);
/* 452 */     arrayOfByte[this.c++] = (byte)(paramInt >>> 27);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 457 */     for (; paramInt2 < paramInt1; paramInt2++) {
/* 458 */       if (this.c == this.d) a(Math.min(this.d, paramInt1 - paramInt2)); 
/*     */       char c;
/* 460 */       if ((c = paramCharSequence.charAt(paramInt2)) <= '') {
/* 461 */         this.e[this.c++] = (byte)c;
/* 462 */       } else if (c > '߿') {
/* 463 */         this.e[this.c++] = (byte)(0xE0 | c >> 12 & 0xF);
/* 464 */         a(2);
/* 465 */         this.e[this.c++] = (byte)(0x80 | c >> 6 & 0x3F);
/* 466 */         this.e[this.c++] = (byte)(0x80 | c & 0x3F);
/*     */       } else {
/* 468 */         this.e[this.c++] = (byte)(0xC0 | c >> 6 & 0x1F);
/* 469 */         a(1);
/* 470 */         this.e[this.c++] = (byte)(0x80 | c & 0x3F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(String paramString, int paramInt) {
/* 476 */     byte[] arrayOfByte = this.e;
/* 477 */     int i = 0;
/* 478 */     int j = Math.min(paramInt, this.d - this.c);
/* 479 */     while (i < paramInt) {
/* 480 */       paramString.getBytes(i, i + j, arrayOfByte, this.c);
/* 481 */       i += j;
/* 482 */       this.c += j;
/* 483 */       j = Math.min(paramInt - i, this.d);
/* 484 */       if (a(j)) arrayOfByte = this.e;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeFloat(float paramFloat) {
/* 493 */     writeInt(Float.floatToIntBits(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int writeFloat(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 501 */     return writeInt((int)(paramFloat1 * paramFloat2), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeShort(int paramInt) {
/* 508 */     a(2);
/* 509 */     this.e[this.c++] = (byte)(paramInt >>> 8);
/* 510 */     this.e[this.c++] = (byte)paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeLong(long paramLong) {
/* 518 */     a(8);
/*     */     byte[] arrayOfByte;
/* 520 */     (arrayOfByte = this.e)[this.c++] = (byte)(int)(paramLong >>> 56L);
/* 521 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 48L);
/* 522 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 40L);
/* 523 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 32L);
/* 524 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 24L);
/* 525 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 16L);
/* 526 */     arrayOfByte[this.c++] = (byte)(int)(paramLong >>> 8L);
/* 527 */     arrayOfByte[this.c++] = (byte)(int)paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int writeLong(long paramLong, boolean paramBoolean) {
/* 538 */     return writeVarLong(paramLong, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int writeVarLong(long paramLong, boolean paramBoolean) {
/* 545 */     if (!paramBoolean) paramLong = paramLong << 1L ^ paramLong >> 63L; 
/* 546 */     if (paramLong >>> 7L == 0L) {
/* 547 */       a(1);
/* 548 */       this.e[this.c++] = (byte)(int)paramLong;
/* 549 */       return 1;
/*     */     } 
/* 551 */     if (paramLong >>> 14L == 0L) {
/* 552 */       a(2);
/* 553 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 554 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L);
/* 555 */       return 2;
/*     */     } 
/* 557 */     if (paramLong >>> 21L == 0L) {
/* 558 */       a(3);
/* 559 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 560 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 561 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L);
/* 562 */       return 3;
/*     */     } 
/* 564 */     if (paramLong >>> 28L == 0L) {
/* 565 */       a(4);
/* 566 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 567 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 568 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 569 */       this.e[this.c++] = (byte)(int)(paramLong >>> 21L);
/* 570 */       return 4;
/*     */     } 
/* 572 */     if (paramLong >>> 35L == 0L) {
/* 573 */       a(5);
/* 574 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 575 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 576 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 577 */       this.e[this.c++] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 578 */       this.e[this.c++] = (byte)(int)(paramLong >>> 28L);
/* 579 */       return 5;
/*     */     } 
/* 581 */     if (paramLong >>> 42L == 0L) {
/* 582 */       a(6);
/* 583 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 584 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 585 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 586 */       this.e[this.c++] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 587 */       this.e[this.c++] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 588 */       this.e[this.c++] = (byte)(int)(paramLong >>> 35L);
/* 589 */       return 6;
/*     */     } 
/* 591 */     if (paramLong >>> 49L == 0L) {
/* 592 */       a(7);
/* 593 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 594 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 595 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 596 */       this.e[this.c++] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 597 */       this.e[this.c++] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 598 */       this.e[this.c++] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 599 */       this.e[this.c++] = (byte)(int)(paramLong >>> 42L);
/* 600 */       return 7;
/*     */     } 
/* 602 */     if (paramLong >>> 56L == 0L) {
/* 603 */       a(8);
/* 604 */       this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 605 */       this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 606 */       this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 607 */       this.e[this.c++] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 608 */       this.e[this.c++] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 609 */       this.e[this.c++] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 610 */       this.e[this.c++] = (byte)(int)(paramLong >>> 42L | 0x80L);
/* 611 */       this.e[this.c++] = (byte)(int)(paramLong >>> 49L);
/* 612 */       return 8;
/*     */     } 
/* 614 */     a(9);
/* 615 */     this.e[this.c++] = (byte)(int)(paramLong & 0x7FL | 0x80L);
/* 616 */     this.e[this.c++] = (byte)(int)(paramLong >>> 7L | 0x80L);
/* 617 */     this.e[this.c++] = (byte)(int)(paramLong >>> 14L | 0x80L);
/* 618 */     this.e[this.c++] = (byte)(int)(paramLong >>> 21L | 0x80L);
/* 619 */     this.e[this.c++] = (byte)(int)(paramLong >>> 28L | 0x80L);
/* 620 */     this.e[this.c++] = (byte)(int)(paramLong >>> 35L | 0x80L);
/* 621 */     this.e[this.c++] = (byte)(int)(paramLong >>> 42L | 0x80L);
/* 622 */     this.e[this.c++] = (byte)(int)(paramLong >>> 49L | 0x80L);
/* 623 */     this.e[this.c++] = (byte)(int)(paramLong >>> 56L);
/* 624 */     return 9;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/* 631 */     if (this.c == this.d) a(1); 
/* 632 */     this.e[this.c++] = (byte)(paramBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeChar(char paramChar) {
/* 639 */     a(2);
/* 640 */     this.e[this.c++] = (byte)(paramChar >>> 8);
/* 641 */     this.e[this.c++] = (byte)paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeDouble(double paramDouble) {
/* 649 */     writeLong(Double.doubleToLongBits(paramDouble));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int writeDouble(double paramDouble1, double paramDouble2, boolean paramBoolean) {
/* 657 */     return writeLong((long)(paramDouble1 * paramDouble2), paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int intLength(int paramInt, boolean paramBoolean) {
/* 662 */     if (!paramBoolean) paramInt = paramInt << 1 ^ paramInt >> 31; 
/* 663 */     if (paramInt >>> 7 == 0) return 1; 
/* 664 */     if (paramInt >>> 14 == 0) return 2; 
/* 665 */     if (paramInt >>> 21 == 0) return 3; 
/* 666 */     if (paramInt >>> 28 == 0) return 4; 
/* 667 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int longLength(long paramLong, boolean paramBoolean) {
/* 672 */     if (!paramBoolean) paramLong = paramLong << 1L ^ paramLong >> 63L; 
/* 673 */     if (paramLong >>> 7L == 0L) return 1; 
/* 674 */     if (paramLong >>> 14L == 0L) return 2; 
/* 675 */     if (paramLong >>> 21L == 0L) return 3; 
/* 676 */     if (paramLong >>> 28L == 0L) return 4; 
/* 677 */     if (paramLong >>> 35L == 0L) return 5; 
/* 678 */     if (paramLong >>> 42L == 0L) return 6; 
/* 679 */     if (paramLong >>> 49L == 0L) return 7; 
/* 680 */     if (paramLong >>> 56L == 0L) return 8; 
/* 681 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeInts(int[] paramArrayOfint, boolean paramBoolean) {
/*     */     byte b;
/*     */     int i;
/* 689 */     for (b = 0, i = paramArrayOfint.length; b < i; b++)
/* 690 */       writeInt(paramArrayOfint[b], paramBoolean); 
/*     */   }
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeLongs(long[] paramArrayOflong, boolean paramBoolean) {
/*     */     byte b;
/*     */     int i;
/* 696 */     for (b = 0, i = paramArrayOflong.length; b < i; b++)
/* 697 */       writeLong(paramArrayOflong[b], paramBoolean); 
/*     */   }
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeInts(int[] paramArrayOfint) {
/*     */     byte b;
/*     */     int i;
/* 703 */     for (b = 0, i = paramArrayOfint.length; b < i; b++)
/* 704 */       writeInt(paramArrayOfint[b]); 
/*     */   }
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void writeLongs(long[] paramArrayOflong) {
/*     */     byte b;
/*     */     int i;
/* 710 */     for (b = 0, i = paramArrayOflong.length; b < i; b++)
/* 711 */       writeLong(paramArrayOflong[b]); 
/*     */   }
/*     */   public void writeFloats(float[] paramArrayOffloat) {
/*     */     byte b;
/*     */     int i;
/* 716 */     for (b = 0, i = paramArrayOffloat.length; b < i; b++)
/* 717 */       writeFloat(paramArrayOffloat[b]); 
/*     */   }
/*     */   public void writeShorts(short[] paramArrayOfshort) {
/*     */     byte b;
/*     */     int i;
/* 722 */     for (b = 0, i = paramArrayOfshort.length; b < i; b++)
/* 723 */       writeShort(paramArrayOfshort[b]); 
/*     */   }
/*     */   public void writeChars(char[] paramArrayOfchar) {
/*     */     byte b;
/*     */     int i;
/* 728 */     for (b = 0, i = paramArrayOfchar.length; b < i; b++)
/* 729 */       writeChar(paramArrayOfchar[b]); 
/*     */   }
/*     */   public void writeDoubles(double[] paramArrayOfdouble) {
/*     */     byte b;
/*     */     int i;
/* 734 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++)
/* 735 */       writeDouble(paramArrayOfdouble[b]); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\kryo\FixedOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */