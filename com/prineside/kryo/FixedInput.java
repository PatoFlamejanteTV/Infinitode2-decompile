/*     */ package com.prineside.kryo;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FixedInput
/*     */   extends InputStream
/*     */ {
/*     */   private byte[] a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private long e;
/*  21 */   private char[] f = new char[32];
/*     */ 
/*     */   
/*     */   private InputStream g;
/*     */ 
/*     */   
/*     */   public FixedInput() {}
/*     */ 
/*     */   
/*     */   public FixedInput(int paramInt) {
/*  31 */     this.c = paramInt;
/*  32 */     this.a = new byte[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedInput(byte[] paramArrayOfbyte) {
/*  38 */     setBuffer(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedInput(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  44 */     setBuffer(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public FixedInput(InputStream paramInputStream) {
/*  49 */     this(4096);
/*  50 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*  51 */     this.g = paramInputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public FixedInput(InputStream paramInputStream, int paramInt) {
/*  56 */     this(paramInt);
/*  57 */     if (paramInputStream == null) throw new IllegalArgumentException("inputStream cannot be null."); 
/*  58 */     this.g = paramInputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void setBuffer(byte[] paramArrayOfbyte) {
/*  64 */     setBuffer(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  70 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/*  71 */     this.a = paramArrayOfbyte;
/*  72 */     this.b = paramInt1;
/*  73 */     this.d = paramInt1 + paramInt2;
/*  74 */     this.c = paramArrayOfbyte.length;
/*  75 */     this.e = 0L;
/*  76 */     this.g = null;
/*     */   }
/*     */   
/*     */   public byte[] getBuffer() {
/*  80 */     return this.a;
/*     */   }
/*     */   
/*     */   public InputStream getInputStream() {
/*  84 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInputStream(InputStream paramInputStream) {
/*  90 */     this.g = paramInputStream;
/*  91 */     this.d = 0;
/*  92 */     rewind();
/*     */   }
/*     */ 
/*     */   
/*     */   public long total() {
/*  97 */     return this.e + this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTotal(int paramInt) {
/* 102 */     this.e = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int position() {
/* 107 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(int paramInt) {
/* 112 */     this.b = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int limit() {
/* 117 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLimit(int paramInt) {
/* 122 */     this.d = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rewind() {
/* 127 */     this.b = 0;
/* 128 */     this.e = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void skip(int paramInt) {
/* 134 */     int i = Math.min(this.d - this.b, paramInt);
/*     */     
/* 136 */     this.b += i;
/*     */     
/* 138 */     while ((paramInt = paramInt - i) != 0) {
/* 139 */       i = Math.min(paramInt, this.c);
/* 140 */       a(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 147 */     if (this.g == null) return -1; 
/*     */     try {
/* 149 */       return this.g.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 150 */     } catch (IOException iOException) {
/* 151 */       throw new KryoException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(int paramInt) {
/*     */     int j, i;
/* 160 */     if ((i = this.d - this.b) >= paramInt) return i; 
/* 161 */     if (paramInt > this.c) throw new KryoException("Buffer too small: capacity: " + this.c + ", required: " + paramInt);
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (i > 0) {
/*     */       
/* 167 */       if ((j = a(this.a, this.d, this.c - this.d)) == -1) throw new KryoException("Buffer underflow.");
/*     */       
/* 169 */       if ((i = i + j) >= paramInt) {
/* 170 */         this.d += j;
/* 171 */         return i;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 176 */     System.arraycopy(this.a, this.b, this.a, 0, i);
/* 177 */     this.e += this.b;
/* 178 */     this.b = 0;
/*     */ 
/*     */     
/*     */     do {
/* 182 */       if ((j = a(this.a, i, this.c - i)) == -1) {
/* 183 */         if (i < paramInt)
/* 184 */           throw new KryoException("Buffer underflow."); 
/*     */         break;
/*     */       } 
/* 187 */     } while ((i = i + j) < paramInt);
/*     */ 
/*     */     
/* 190 */     this.d = i;
/* 191 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int b(int paramInt) {
/*     */     int i;
/* 198 */     if ((i = this.d - this.b) >= paramInt) return paramInt; 
/* 199 */     paramInt = Math.min(paramInt, this.c);
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */     
/* 205 */     if ((j = a(this.a, this.d, this.c - this.d)) == -1) return (i == 0) ? -1 : Math.min(i, paramInt);
/*     */     
/* 207 */     if ((i = i + j) >= paramInt) {
/* 208 */       this.d += j;
/* 209 */       return paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 213 */     System.arraycopy(this.a, this.b, this.a, 0, i);
/* 214 */     this.e += this.b;
/* 215 */     this.b = 0;
/*     */     
/*     */     do {
/*     */     
/* 219 */     } while ((j = a(this.a, i, this.c - i)) != -1 && (
/*     */       
/* 221 */       i = i + j) < paramInt);
/*     */ 
/*     */     
/* 224 */     this.d = i;
/* 225 */     return (i == 0) ? -1 : Math.min(i, paramInt);
/*     */   }
/*     */   
/*     */   public boolean eof() {
/* 229 */     return (b(1) <= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 235 */     return this.d - this.b + ((this.g != null) ? this.g.available() : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int read() {
/* 242 */     if (b(1) <= 0) return -1; 
/* 243 */     return this.a[this.b++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 251 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 258 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 259 */     int i = paramInt2;
/* 260 */     int j = Math.min(this.d - this.b, paramInt2);
/*     */     
/* 262 */     System.arraycopy(this.a, this.b, paramArrayOfbyte, paramInt1, j);
/* 263 */     this.b += j;
/*     */     
/* 265 */     while ((paramInt2 = paramInt2 - j) != 0) {
/* 266 */       paramInt1 += j;
/*     */       
/* 268 */       if ((j = b(paramInt2)) == -1) {
/*     */         
/* 270 */         if (i == paramInt2) return -1; 
/*     */         break;
/*     */       } 
/* 273 */       if (this.b == this.d)
/*     */         break; 
/* 275 */     }  return i - paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public long skip(long paramLong) {
/* 281 */     long l = paramLong;
/* 282 */     while (l > 0L) {
/* 283 */       int i = (int)Math.min(2147483647L, l);
/* 284 */       skip(i);
/* 285 */       l -= i;
/*     */     } 
/* 287 */     return paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 292 */     if (this.g != null) {
/*     */       try {
/* 294 */         this.g.close(); return;
/* 295 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 304 */     a(1);
/* 305 */     return this.a[this.b++];
/*     */   }
/*     */ 
/*     */   
/*     */   public int readByteUnsigned() {
/* 310 */     a(1);
/* 311 */     return this.a[this.b++] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public byte[] readBytes(int paramInt) {
/* 317 */     byte[] arrayOfByte = new byte[paramInt];
/* 318 */     readBytes(arrayOfByte, 0, paramInt);
/* 319 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void readBytes(byte[] paramArrayOfbyte) {
/* 325 */     readBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 331 */     if (paramArrayOfbyte == null) throw new IllegalArgumentException("bytes cannot be null."); 
/* 332 */     int i = Math.min(this.d - this.b, paramInt2);
/*     */     
/* 334 */     System.arraycopy(this.a, this.b, paramArrayOfbyte, paramInt1, i);
/* 335 */     this.b += i;
/*     */     
/* 337 */     while ((paramInt2 = paramInt2 - i) != 0) {
/* 338 */       paramInt1 += i;
/* 339 */       i = Math.min(paramInt2, this.c);
/* 340 */       a(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int readInt() {
/* 349 */     a(4);
/* 350 */     byte[] arrayOfByte = this.a;
/* 351 */     int i = this.b;
/* 352 */     this.b = i + 4;
/* 353 */     return (arrayOfByte[i] & 0xFF) << 24 | (arrayOfByte[i + 1] & 0xFF) << 16 | (arrayOfByte[i + 2] & 0xFF) << 8 | arrayOfByte[i + 3] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int readInt(boolean paramBoolean) {
/* 364 */     return readVarInt(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readVarInt(boolean paramBoolean) {
/* 369 */     if (a(1) < 5) return a(paramBoolean); 
/*     */     byte b;
/* 371 */     int i = (b = this.a[this.b++]) & Byte.MAX_VALUE;
/* 372 */     if ((b & 0x80) != 0) {
/*     */       byte[] arrayOfByte;
/* 374 */       b = (arrayOfByte = this.a)[this.b++];
/* 375 */       i |= (b & Byte.MAX_VALUE) << 7;
/* 376 */       if ((b & 0x80) != 0) {
/* 377 */         b = arrayOfByte[this.b++];
/* 378 */         i |= (b & Byte.MAX_VALUE) << 14;
/* 379 */         if ((b & 0x80) != 0) {
/* 380 */           b = arrayOfByte[this.b++];
/* 381 */           i |= (b & Byte.MAX_VALUE) << 21;
/* 382 */           if ((b & 0x80) != 0) {
/* 383 */             b = arrayOfByte[this.b++];
/* 384 */             i |= (b & Byte.MAX_VALUE) << 28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 389 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(boolean paramBoolean) {
/*     */     byte b;
/* 395 */     int i = (b = this.a[this.b++]) & Byte.MAX_VALUE;
/* 396 */     if ((b & 0x80) != 0) {
/* 397 */       a(1);
/*     */       byte[] arrayOfByte;
/* 399 */       b = (arrayOfByte = this.a)[this.b++];
/* 400 */       i |= (b & Byte.MAX_VALUE) << 7;
/* 401 */       if ((b & 0x80) != 0) {
/* 402 */         a(1);
/* 403 */         b = arrayOfByte[this.b++];
/* 404 */         i |= (b & Byte.MAX_VALUE) << 14;
/* 405 */         if ((b & 0x80) != 0) {
/* 406 */           a(1);
/* 407 */           b = arrayOfByte[this.b++];
/* 408 */           i |= (b & Byte.MAX_VALUE) << 21;
/* 409 */           if ((b & 0x80) != 0) {
/* 410 */             a(1);
/* 411 */             b = arrayOfByte[this.b++];
/* 412 */             i |= (b & Byte.MAX_VALUE) << 28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 417 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReadInt() {
/* 422 */     if (this.d - this.b >= 5) return true; 
/* 423 */     if (b(5) <= 0) return false; 
/* 424 */     int i = this.b;
/* 425 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 426 */     if (i == this.d) return false; 
/* 427 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 428 */     if (i == this.d) return false; 
/* 429 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 430 */     if (i == this.d) return false; 
/* 431 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 432 */     if (i == this.d) return false; 
/* 433 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReadLong() {
/* 438 */     if (this.d - this.b >= 9) return true; 
/* 439 */     if (b(5) <= 0) return false; 
/* 440 */     int i = this.b;
/* 441 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 442 */     if (i == this.d) return false; 
/* 443 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 444 */     if (i == this.d) return false; 
/* 445 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 446 */     if (i == this.d) return false; 
/* 447 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 448 */     if (i == this.d) return false; 
/* 449 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 450 */     if (i == this.d) return false; 
/* 451 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 452 */     if (i == this.d) return false; 
/* 453 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 454 */     if (i == this.d) return false; 
/* 455 */     if ((this.a[i++] & 0x80) == 0) return true; 
/* 456 */     if (i == this.d) return false; 
/* 457 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString() {
/* 466 */     int i = a(1);
/*     */     byte b;
/* 468 */     if (((b = this.a[this.b++]) & 0x80) == 0) return a();
/*     */ 
/*     */     
/* 471 */     switch (i = (i >= 5) ? c(b) : d(b)) {
/*     */       case 0:
/* 473 */         return null;
/*     */       case 1:
/* 475 */         return "";
/*     */     } 
/* 477 */     i--;
/* 478 */     if (this.f.length < i) this.f = new char[i]; 
/* 479 */     e(i);
/* 480 */     return new String(this.f, 0, i);
/*     */   }
/*     */   
/*     */   private int c(int paramInt) {
/* 484 */     int i = paramInt & 0x3F;
/* 485 */     if ((paramInt & 0x40) != 0) {
/*     */       byte[] arrayOfByte;
/* 487 */       paramInt = (arrayOfByte = this.a)[this.b++];
/* 488 */       i |= (paramInt & 0x7F) << 6;
/* 489 */       if ((paramInt & 0x80) != 0) {
/* 490 */         paramInt = arrayOfByte[this.b++];
/* 491 */         i |= (paramInt & 0x7F) << 13;
/* 492 */         if ((paramInt & 0x80) != 0) {
/* 493 */           paramInt = arrayOfByte[this.b++];
/* 494 */           i |= (paramInt & 0x7F) << 20;
/* 495 */           if ((paramInt & 0x80) != 0) {
/* 496 */             paramInt = arrayOfByte[this.b++];
/* 497 */             i |= (paramInt & 0x7F) << 27;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 502 */     return i;
/*     */   }
/*     */   
/*     */   private int d(int paramInt) {
/* 506 */     int i = paramInt & 0x3F;
/* 507 */     if ((paramInt & 0x40) != 0) {
/* 508 */       a(1);
/*     */       byte[] arrayOfByte;
/* 510 */       paramInt = (arrayOfByte = this.a)[this.b++];
/* 511 */       i |= (paramInt & 0x7F) << 6;
/* 512 */       if ((paramInt & 0x80) != 0) {
/* 513 */         a(1);
/* 514 */         paramInt = arrayOfByte[this.b++];
/* 515 */         i |= (paramInt & 0x7F) << 13;
/* 516 */         if ((paramInt & 0x80) != 0) {
/* 517 */           a(1);
/* 518 */           paramInt = arrayOfByte[this.b++];
/* 519 */           i |= (paramInt & 0x7F) << 20;
/* 520 */           if ((paramInt & 0x80) != 0) {
/* 521 */             a(1);
/* 522 */             paramInt = arrayOfByte[this.b++];
/* 523 */             i |= (paramInt & 0x7F) << 27;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 528 */     return i;
/*     */   }
/*     */   
/*     */   private void e(int paramInt) {
/* 532 */     byte[] arrayOfByte = this.a;
/* 533 */     char[] arrayOfChar = this.f;
/*     */     
/* 535 */     byte b = 0;
/* 536 */     int i = Math.min(a(1), paramInt);
/* 537 */     int j = this.b;
/*     */     
/* 539 */     while (b < i) {
/*     */       byte b1;
/* 541 */       if ((b1 = arrayOfByte[j++]) < 0) {
/* 542 */         j--;
/*     */         break;
/*     */       } 
/* 545 */       arrayOfChar[b++] = (char)b1;
/*     */     } 
/* 547 */     this.b = j;
/*     */     
/* 549 */     if (b < paramInt) a(paramInt, b); 
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2) {
/* 553 */     char[] arrayOfChar = this.f;
/* 554 */     byte[] arrayOfByte = this.a;
/* 555 */     while (paramInt2 < paramInt1) {
/* 556 */       if (this.b == this.d) a(1); 
/*     */       int i;
/* 558 */       switch ((i = arrayOfByte[this.b++] & 0xFF) >> 4) {
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/* 567 */           arrayOfChar[paramInt2] = (char)i;
/*     */           break;
/*     */         case 12:
/*     */         case 13:
/* 571 */           if (this.b == this.d) a(1); 
/* 572 */           arrayOfChar[paramInt2] = (char)((i & 0x1F) << 6 | arrayOfByte[this.b++] & 0x3F);
/*     */           break;
/*     */         case 14:
/* 575 */           a(2);
/* 576 */           arrayOfChar[paramInt2] = (char)((i & 0xF) << 12 | (arrayOfByte[this.b++] & 0x3F) << 6 | arrayOfByte[this.b++] & 0x3F);
/*     */           break;
/*     */       } 
/* 579 */       paramInt2++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String a() {
/* 584 */     byte[] arrayOfByte = this.a;
/*     */     
/* 586 */     int i, j = (i = this.b) - 1;
/* 587 */     int k = this.d;
/*     */     
/*     */     while (true) {
/* 590 */       if (i == k) return b(); 
/*     */       byte b;
/* 592 */       if (((b = arrayOfByte[i++]) & 0x80) != 0) {
/* 593 */         arrayOfByte[i - 1] = (byte)(arrayOfByte[i - 1] & Byte.MAX_VALUE);
/* 594 */         String str = new String(arrayOfByte, 0, j, i - j);
/* 595 */         arrayOfByte[i - 1] = (byte)(arrayOfByte[i - 1] | 0x80);
/* 596 */         this.b = i;
/* 597 */         return str;
/*     */       } 
/*     */     } 
/*     */   } private String b() {
/* 601 */     this.b--;
/*     */     
/*     */     int i;
/* 604 */     if ((i = this.d - this.b) > this.f.length) this.f = new char[i << 1]; 
/* 605 */     char[] arrayOfChar = this.f;
/* 606 */     byte[] arrayOfByte = this.a; int j; byte b; int k;
/* 607 */     for (j = this.b, b = 0, k = this.d; j < k; j++, b++)
/* 608 */       arrayOfChar[b] = (char)arrayOfByte[j]; 
/* 609 */     this.b = this.d;
/*     */     
/*     */     while (true) {
/* 612 */       a(1);
/* 613 */       j = arrayOfByte[this.b++];
/* 614 */       if (i == arrayOfChar.length) {
/* 615 */         char[] arrayOfChar1 = new char[i << 1];
/* 616 */         System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, i);
/* 617 */         arrayOfChar = arrayOfChar1;
/* 618 */         this.f = arrayOfChar1;
/*     */       } 
/* 620 */       if ((j & 0x80) == 128) {
/* 621 */         arrayOfChar[i++] = (char)(j & 0x7F);
/*     */         break;
/*     */       } 
/* 624 */       arrayOfChar[i++] = (char)j;
/*     */     } 
/* 626 */     return new String(arrayOfChar, 0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuilder readStringBuilder() {
/* 633 */     int i = a(1);
/*     */     byte b;
/* 635 */     if (((b = this.a[this.b++]) & 0x80) == 0) return new StringBuilder(a());
/*     */ 
/*     */     
/* 638 */     switch (i = (i >= 5) ? c(b) : d(b)) {
/*     */       case 0:
/* 640 */         return null;
/*     */       case 1:
/* 642 */         return new StringBuilder("");
/*     */     } 
/* 644 */     i--;
/* 645 */     if (this.f.length < i) this.f = new char[i]; 
/* 646 */     e(i);
/*     */     StringBuilder stringBuilder;
/* 648 */     (stringBuilder = new StringBuilder(i)).append(this.f, 0, i);
/* 649 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public float readFloat() {
/* 657 */     return Float.intBitsToFloat(readInt());
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public float readFloat(float paramFloat, boolean paramBoolean) {
/* 663 */     return readInt(paramBoolean) / paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 670 */     a(2);
/* 671 */     return (short)((this.a[this.b++] & 0xFF) << 8 | this.a[this.b++] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readShortUnsigned() {
/* 676 */     a(2);
/* 677 */     return (this.a[this.b++] & 0xFF) << 8 | this.a[this.b++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public long readLong() {
/* 685 */     a(8);
/*     */     byte[] arrayOfByte;
/* 687 */     return (arrayOfByte = this.a)[this.b++] << 56L | (arrayOfByte[this.b++] & 0xFF) << 48L | (arrayOfByte[this.b++] & 0xFF) << 40L | (arrayOfByte[this.b++] & 0xFF) << 32L | (arrayOfByte[this.b++] & 0xFF) << 24L | ((arrayOfByte[this.b++] & 0xFF) << 16) | ((arrayOfByte[this.b++] & 0xFF) << 8) | (arrayOfByte[this.b++] & 0xFF);
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public long readLong(boolean paramBoolean) {
/* 703 */     return readVarLong(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public long readVarLong(boolean paramBoolean) {
/* 708 */     if (a(1) < 9) return b(paramBoolean); 
/*     */     byte b;
/* 710 */     long l = ((b = this.a[this.b++]) & Byte.MAX_VALUE);
/* 711 */     if ((b & 0x80) != 0) {
/*     */       byte[] arrayOfByte;
/* 713 */       b = (arrayOfByte = this.a)[this.b++];
/* 714 */       l |= ((b & Byte.MAX_VALUE) << 7);
/* 715 */       if ((b & 0x80) != 0) {
/* 716 */         b = arrayOfByte[this.b++];
/* 717 */         l |= ((b & Byte.MAX_VALUE) << 14);
/* 718 */         if ((b & 0x80) != 0) {
/* 719 */           b = arrayOfByte[this.b++];
/* 720 */           l |= ((b & Byte.MAX_VALUE) << 21);
/* 721 */           if ((b & 0x80) != 0) {
/* 722 */             b = arrayOfByte[this.b++];
/* 723 */             l |= (b & Byte.MAX_VALUE) << 28L;
/* 724 */             if ((b & 0x80) != 0) {
/* 725 */               b = arrayOfByte[this.b++];
/* 726 */               l |= (b & Byte.MAX_VALUE) << 35L;
/* 727 */               if ((b & 0x80) != 0) {
/* 728 */                 b = arrayOfByte[this.b++];
/* 729 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/* 730 */                 if ((b & 0x80) != 0) {
/* 731 */                   b = arrayOfByte[this.b++];
/* 732 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/* 733 */                   if ((b & 0x80) != 0) {
/* 734 */                     b = arrayOfByte[this.b++];
/* 735 */                     l |= b << 56L;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 744 */     if (!paramBoolean) l = l >>> 1L ^ -(l & 0x1L); 
/* 745 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   private long b(boolean paramBoolean) {
/*     */     byte b;
/* 751 */     long l = ((b = this.a[this.b++]) & Byte.MAX_VALUE);
/* 752 */     if ((b & 0x80) != 0) {
/* 753 */       a(1);
/*     */       byte[] arrayOfByte;
/* 755 */       b = (arrayOfByte = this.a)[this.b++];
/* 756 */       l |= ((b & Byte.MAX_VALUE) << 7);
/* 757 */       if ((b & 0x80) != 0) {
/* 758 */         a(1);
/* 759 */         b = arrayOfByte[this.b++];
/* 760 */         l |= ((b & Byte.MAX_VALUE) << 14);
/* 761 */         if ((b & 0x80) != 0) {
/* 762 */           a(1);
/* 763 */           b = arrayOfByte[this.b++];
/* 764 */           l |= ((b & Byte.MAX_VALUE) << 21);
/* 765 */           if ((b & 0x80) != 0) {
/* 766 */             a(1);
/* 767 */             b = arrayOfByte[this.b++];
/* 768 */             l |= (b & Byte.MAX_VALUE) << 28L;
/* 769 */             if ((b & 0x80) != 0) {
/* 770 */               a(1);
/* 771 */               b = arrayOfByte[this.b++];
/* 772 */               l |= (b & Byte.MAX_VALUE) << 35L;
/* 773 */               if ((b & 0x80) != 0) {
/* 774 */                 a(1);
/* 775 */                 b = arrayOfByte[this.b++];
/* 776 */                 l |= (b & Byte.MAX_VALUE) << 42L;
/* 777 */                 if ((b & 0x80) != 0) {
/* 778 */                   a(1);
/* 779 */                   b = arrayOfByte[this.b++];
/* 780 */                   l |= (b & Byte.MAX_VALUE) << 49L;
/* 781 */                   if ((b & 0x80) != 0) {
/* 782 */                     a(1);
/* 783 */                     b = arrayOfByte[this.b++];
/* 784 */                     l |= b << 56L;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 793 */     if (!paramBoolean) l = l >>> 1L ^ -(l & 0x1L); 
/* 794 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean readBoolean() {
/* 801 */     a(1);
/* 802 */     return (this.a[this.b++] == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char readChar() {
/* 809 */     a(2);
/* 810 */     return (char)((this.a[this.b++] & 0xFF) << 8 | this.a[this.b++] & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public double readDouble() {
/* 818 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public double readDouble(double paramDouble, boolean paramBoolean) {
/* 824 */     return readLong(paramBoolean) / paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int[] readInts(int paramInt, boolean paramBoolean) {
/* 832 */     int[] arrayOfInt = new int[paramInt];
/* 833 */     for (byte b = 0; b < paramInt; b++)
/* 834 */       arrayOfInt[b] = readInt(paramBoolean); 
/* 835 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public long[] readLongs(int paramInt, boolean paramBoolean) {
/* 841 */     long[] arrayOfLong = new long[paramInt];
/* 842 */     for (byte b = 0; b < paramInt; b++)
/* 843 */       arrayOfLong[b] = readLong(paramBoolean); 
/* 844 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public int[] readInts(int paramInt) {
/* 850 */     int[] arrayOfInt = new int[paramInt];
/* 851 */     for (byte b = 0; b < paramInt; b++)
/* 852 */       arrayOfInt[b] = readInt(); 
/* 853 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public long[] readLongs(int paramInt) {
/* 859 */     long[] arrayOfLong = new long[paramInt];
/* 860 */     for (byte b = 0; b < paramInt; b++)
/* 861 */       arrayOfLong[b] = readLong(); 
/* 862 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] readFloats(int paramInt) {
/* 867 */     float[] arrayOfFloat = new float[paramInt];
/* 868 */     for (byte b = 0; b < paramInt; b++)
/* 869 */       arrayOfFloat[b] = readFloat(); 
/* 870 */     return arrayOfFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public short[] readShorts(int paramInt) {
/* 875 */     short[] arrayOfShort = new short[paramInt];
/* 876 */     for (byte b = 0; b < paramInt; b++)
/* 877 */       arrayOfShort[b] = readShort(); 
/* 878 */     return arrayOfShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public char[] readChars(int paramInt) {
/* 883 */     char[] arrayOfChar = new char[paramInt];
/* 884 */     for (byte b = 0; b < paramInt; b++)
/* 885 */       arrayOfChar[b] = readChar(); 
/* 886 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] readDoubles(int paramInt) {
/* 891 */     double[] arrayOfDouble = new double[paramInt];
/* 892 */     for (byte b = 0; b < paramInt; b++)
/* 893 */       arrayOfDouble[b] = readDouble(); 
/* 894 */     return arrayOfDouble;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\kryo\FixedInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */