/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class e
/*     */   extends FilterInputStream
/*     */ {
/*     */   private final int e;
/*     */   private final byte[] f;
/*     */   private int g;
/*     */   private int h;
/*     */   private final int i;
/*     */   private final int j;
/*     */   private int[] k;
/*     */   private int[] l;
/*     */   private int m;
/*     */   private int n;
/*     */   private boolean p = false;
/*     */   private boolean q = false;
/*     */   private int r;
/*     */   private int s;
/*     */   
/*     */   private void a() {
/*     */     if (this.h >= this.g) {
/*     */       this.g = 0;
/*     */       try {
/*     */         g();
/*     */       } catch (EOFException eOFException) {
/*     */         if (this.g != 0)
/*     */           throw eOFException; 
/*     */         this.g = -1;
/*     */       } 
/*     */       this.h = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     int i = 0;
/*     */     boolean bool = true;
/*     */     this.n = 0;
/*     */     do {
/*     */       int j;
/*     */       if (bool) {
/*     */         j = a(w);
/*     */       } else {
/*     */         j = a(v);
/*     */       } 
/*     */       if (j == -2000)
/*     */         continue; 
/*     */       i += j;
/*     */       this.l[this.n++] = i;
/*     */       bool = !bool ? true : false;
/*     */     } while (i < this.e);
/*     */   }
/*     */   
/*  70 */   private int o = 0; private void c() { this.m = this.n; int[] arrayOfInt = this.l; this.l = this.k; this.k = arrayOfInt; boolean bool = true; int i = 0; this.n = 0; while (i < this.e) { a a1 = y.a; while ((a1 = a1.a(i())) != null) { if (a1.e) { int j; switch (a1.c) { case -4000:
/*     */               j = a(bool ? w : v); i += j; this.l[this.n++] = i; j = a(bool ? v : w); i += j; this.l[this.n++] = i; continue;
/*     */             case -3000:
/*     */               if ((i = a(i, bool) + 1) >= this.m) { i = this.e; continue; }
/*     */                i = this.k[i]; continue; }
/*     */            if ((i = a(i, bool)) >= this.m || i == -1) { i = this.e + j.c; }
/*     */           else
/*     */           { i = this.k[i] + j.c; }
/*     */            this.l[this.n] = i; this.n++; bool = !bool ? true : false; }
/*     */          }
/*     */        }
/*     */      }
/*  82 */   e(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3, long paramLong) { super(paramInputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     this.r = -1;
/* 390 */     this.s = -1; this.e = paramInt1; this.f = new byte[(paramInt1 + 7) / 8]; this.j = paramInt2; this.i = 1; this.k = new int[paramInt1 + 2]; this.l = new int[paramInt1 + 2]; switch (paramInt2) { case 2: this.q = ((paramLong & 0x8L) != 0L); return;case 3: this.p = ((paramLong & 0x1L) != 0L); this.q = ((paramLong & 0x8L) != 0L); return;case 4: this.q = ((paramLong & 0x4L) != 0L); break; }  } private int a(int paramInt, boolean paramBoolean) { int i; if ((i = (this.o & 0xFFFFFFFE) + (paramBoolean ? 0 : 1)) > 2) i -= 2;  if (paramInt == 0) return i;  for (i = i; i < this.m; i += 2) { if (paramInt < this.k[i]) { this.o = i; return i; }  }  return -1; }
/*     */   private void d() { if (this.q)
/*     */       h();  b(); }
/* 393 */   private boolean i() { boolean bool; if (this.s < 0 || this.s > 7) {
/* 394 */       this.r = this.in.read();
/*     */       
/* 396 */       if (this.r == -1) {
/* 397 */         throw new EOFException("Unexpected end of Huffman RLE stream");
/*     */       }
/*     */       
/* 400 */       this.s = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 405 */     if (this.i == 1) {
/* 406 */       bool = ((this.r >> 7 - this.s & 0x1) == 1) ? true : false;
/*     */     } else {
/*     */       
/* 409 */       bool = ((this.r >> this.s & 0x1) == 1) ? true : false;
/*     */     } 
/*     */     
/* 412 */     this.s++;
/*     */     
/* 414 */     if (this.s > 7) {
/* 415 */       this.s = -1;
/*     */     }
/*     */     
/* 418 */     return bool; }
/*     */   private void e() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield q : Z
/*     */     //   4: ifeq -> 11
/*     */     //   7: aload_0
/*     */     //   8: invokespecial h : ()V
/*     */     //   11: getstatic org/a/c/c/e.x : Lorg/a/c/c/e$b;
/*     */     //   14: getfield a : Lorg/a/c/c/e$a;
/*     */     //   17: astore_1
/*     */     //   18: aload_1
/*     */     //   19: aload_0
/*     */     //   20: invokespecial i : ()Z
/*     */     //   23: invokevirtual a : (Z)Lorg/a/c/c/e$a;
/*     */     //   26: dup
/*     */     //   27: astore_1
/*     */     //   28: ifnull -> 11
/*     */     //   31: aload_1
/*     */     //   32: getfield e : Z
/*     */     //   35: ifeq -> 18
/*     */     //   38: aload_0
/*     */     //   39: getfield p : Z
/*     */     //   42: ifeq -> 52
/*     */     //   45: aload_0
/*     */     //   46: invokespecial i : ()Z
/*     */     //   49: ifeq -> 57
/*     */     //   52: aload_0
/*     */     //   53: invokespecial b : ()V
/*     */     //   56: return
/*     */     //   57: aload_0
/*     */     //   58: invokespecial c : ()V
/*     */     //   61: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #260	-> 0
/*     */     //   #261	-> 7
/*     */     //   #265	-> 11
/*     */     //   #268	-> 18
/*     */     //   #270	-> 27
/*     */     //   #274	-> 31
/*     */     //   #280	-> 38
/*     */     //   #281	-> 52
/*     */     //   #284	-> 57
/*     */     //   #286	-> 61 }
/*     */   private void f() { if (this.q) h();  c(); }
/*     */   private void g() { switch (this.j) { case 2: d(); break;case 3: e(); break;case 4: f(); break; }  byte b1 = 0; boolean bool = true; this.o = 0; for (byte b2 = 0; b2 <= this.n; b2++) { int i = this.e; if (b2 != this.n) i = this.l[b2];  if (i > this.e) i = this.e;  int j = b1 / 8; while (b1 % 8 != 0 && i - b1 > 0) { this.f[j] = (byte)(this.f[j] | (bool ? 0 : (1 << 7 - b1 % 8))); b1++; }  if (b1 % 8 == 0) { j = b1 / 8; byte b3 = (byte)(bool ? 0 : 255); while (i - b1 > 7) { this.f[j] = b3; b1 += 8; j++; }  }  while (i - b1 > 0) { if (b1 % 8 == 0)
/*     */           this.f[j] = 0;  this.f[j] = (byte)(this.f[j] | (bool ? 0 : (1 << 7 - b1 % 8))); b1++; }  bool = !bool ? true : false; }  if (b1 != this.e)
/* 423 */       throw new IOException("Sum of run-lengths does not equal scan line width: " + b1 + " > " + this.e);  this.g = (b1 + 7) / 8; } public final int read() { if (this.g < 0) {
/* 424 */       return 0;
/*     */     }
/*     */     
/* 427 */     if (this.h >= this.g) {
/* 428 */       a();
/*     */       
/* 430 */       if (this.g < 0) {
/* 431 */         return 0;
/*     */       }
/*     */     } 
/*     */     
/* 435 */     return this.f[this.h++] & 0xFF; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 440 */     if (this.g < 0) {
/*     */       
/* 442 */       Arrays.fill(paramArrayOfbyte, paramInt1, paramInt1 + paramInt2, (byte)0);
/* 443 */       return paramInt2;
/*     */     } 
/*     */     
/* 446 */     if (this.h >= this.g) {
/* 447 */       a();
/*     */       
/* 449 */       if (this.g < 0) {
/* 450 */         Arrays.fill(paramArrayOfbyte, paramInt1, paramInt1 + paramInt2, (byte)0);
/* 451 */         return paramInt2;
/*     */       } 
/*     */     } 
/*     */     
/* 455 */     paramInt2 = Math.min(this.g - this.h, paramInt2);
/* 456 */     System.arraycopy(this.f, this.h, paramArrayOfbyte, paramInt1, paramInt2);
/* 457 */     this.h += paramInt2;
/*     */     
/* 459 */     return paramInt2; } private int a(b paramb) { int i = 0; a a1 = paramb.a; while (true) { boolean bool = i(); if ((a1 = a1.a(bool)) == null)
/*     */         throw new IOException("Unknown code in Huffman RLE stream");  if (a1.e) { i += a1.c; if (a1.c < 64)
/*     */           return i;  a1 = paramb.a; }  }
/*     */      }
/*     */   private void h() { this.s = -1; }
/* 464 */   public final long skip(long paramLong) { if (this.g < 0) {
/* 465 */       return -1L;
/*     */     }
/*     */     
/* 468 */     if (this.h >= this.g) {
/* 469 */       a();
/*     */       
/* 471 */       if (this.g < 0) {
/* 472 */         return -1L;
/*     */       }
/*     */     } 
/*     */     
/* 476 */     int i = (int)Math.min((this.g - this.h), paramLong);
/* 477 */     this.h += i;
/*     */     
/* 479 */     return i; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean markSupported() {
/* 484 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void reset() {
/* 489 */     throw new IOException("mark/reset not supported");
/*     */   }
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     a a;
/*     */     a b;
/*     */     int c;
/*     */     boolean d = false;
/*     */     boolean e = false;
/*     */     
/*     */     final void a(boolean param1Boolean, a param1a) {
/* 502 */       if (!param1Boolean) {
/* 503 */         this.a = param1a;
/*     */         return;
/*     */       } 
/* 506 */       this.b = param1a;
/*     */     }
/*     */ 
/*     */     
/*     */     final a a(boolean param1Boolean) {
/* 511 */       return param1Boolean ? this.b : this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 516 */       return "[leaf=" + this.e + ", value=" + this.c + ", canBeFill=" + this.d + "]";
/*     */     }
/*     */     
/*     */     private a() {} }
/*     */   
/* 521 */   static final class b { final e.a a = new e.a((byte)0);
/*     */     
/*     */     final void a(int param1Int1, int param1Int2, int param1Int3) {
/* 524 */       e.a a1 = this.a;
/*     */       
/* 526 */       for (byte b1 = 0; b1 < param1Int1; b1++) {
/* 527 */         int i = param1Int1 - 1 - b1;
/* 528 */         i = ((param1Int2 >> i & 0x1) == 1) ? 1 : 0;
/*     */         
/*     */         e.a a2;
/* 531 */         if ((a2 = a1.a(i)) == null) {
/* 532 */           a2 = new e.a((byte)0);
/*     */           
/* 534 */           if (b1 == param1Int1 - 1) {
/* 535 */             a2.c = param1Int3;
/* 536 */             a2.e = true;
/*     */           } 
/*     */           
/* 539 */           if (param1Int2 == 0) {
/* 540 */             a2.d = true;
/*     */           }
/*     */           
/* 543 */           a1.a(i, a2);
/*     */         
/*     */         }
/* 546 */         else if (a2.e) {
/* 547 */           throw new IOException("node is leaf, no other following");
/*     */         } 
/*     */ 
/*     */         
/* 551 */         a1 = a2;
/*     */       } 
/*     */     }
/*     */     
/*     */     final void a(int param1Int1, int param1Int2, e.a param1a) {
/* 556 */       e.a a1 = this.a;
/*     */       
/* 558 */       for (byte b1 = 0; b1 < 12; b1++) {
/* 559 */         int i = 11 - b1;
/* 560 */         i = ((param1Int2 >> i & 0x1) == 1) ? 1 : 0;
/*     */         
/*     */         e.a a2;
/* 563 */         if ((a2 = a1.a(i)) == null) {
/* 564 */           if (b1 == 11) {
/* 565 */             a2 = param1a;
/*     */           } else {
/*     */             
/* 568 */             a2 = new e.a((byte)0);
/*     */           } 
/*     */           
/* 571 */           if (param1Int2 == 0) {
/* 572 */             a2.d = true;
/*     */           }
/*     */           
/* 575 */           a1.a(i, a2);
/*     */         
/*     */         }
/* 578 */         else if (a2.e) {
/* 579 */           throw new IOException("node is leaf, no other following");
/*     */         } 
/*     */ 
/*     */         
/* 583 */         a1 = a2;
/*     */       } 
/*     */     }
/*     */     
/*     */     private b() {} }
/* 588 */   static final short[][] a = new short[][] { { 2, 3 }, { 2, 3 }, { 2, 3 }, { 3 }, { 4, 5 }, { 4, 5, 7 }, { 4, 7 }, { 24 }, { 23, 24, 55, 8, 15 }, { 23, 24, 40, 55, 103, 104, 108, 8, 12, 13 }, { 18, 19, 20, 21, 22, 23, 28, 29, 30, 31, 36, 39, 40, 43, 44, 51, 52, 53, 55, 56, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 200, 201, 202, 203, 204, 205, 210, 211, 212, 213, 214, 215, 218, 219 }, { 74, 75, 76, 77, 82, 83, 84, 85, 90, 91, 100, 101, 108, 109, 114, 115, 116, 117, 118, 119 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 630 */   static final short[][] b = new short[][] { { 3, 2 }, { 1, 4 }, { 6, 5 }, { 7 }, { 9, 8 }, { 10, 11, 12 }, { 13, 14 }, { 15 }, { 16, 17, 0, 18, 64 }, { 24, 25, 23, 22, 19, 20, 21, 1792, 1856, 1920 }, { 1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560, 52, 55, 56, 59, 60, 320, 384, 448, 53, 54, 50, 51, 44, 45, 46, 47, 57, 58, 61, 256, 48, 49, 62, 63, 30, 31, 32, 33, 40, 41, 128, 192, 26, 27, 28, 29, 34, 35, 36, 37, 38, 39, 42, 43 }, { 640, 704, 768, 832, 1280, 1344, 1408, 1472, 1536, 1600, 1664, 1728, 512, 576, 896, 960, 1024, 1088, 1152, 1216 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 672 */   public static final short[][] c = new short[][] { { 7, 8, 11, 12, 14, 15 }, { 18, 19, 20, 27, 7, 8 }, { 23, 24, 42, 43, 3, 52, 53, 7, 8 }, { 19, 23, 24, 36, 39, 40, 43, 3, 55, 4, 8, 12 }, { 18, 19, 20, 21, 22, 23, 26, 27, 2, 36, 37, 40, 41, 42, 43, 44, 45, 3, 50, 51, 52, 53, 54, 55, 4, 74, 75, 5, 82, 83, 84, 85, 88, 89, 90, 91, 100, 101, 103, 104, 10, 11 }, { 152, 153, 154, 155, 204, 205, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219 }, {}, { 8, 12, 13 }, { 18, 19, 20, 21, 22, 23, 28, 29, 30, 31 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 703 */   public static final short[][] d = new short[][] { { 2, 3, 4, 5, 6, 7 }, { 128, 8, 9, 64, 10, 11 }, { 192, 1664, 16, 17, 13, 14, 15, 1, 12 }, { 26, 21, 28, 27, 18, 24, 25, 22, 256, 23, 20, 19 }, { 33, 34, 35, 36, 37, 38, 31, 32, 29, 53, 54, 39, 40, 41, 42, 43, 44, 30, 61, 62, 63, 0, 320, 384, 45, 59, 60, 46, 49, 50, 51, 52, 55, 56, 57, 58, 448, 512, 640, 576, 47, 48 }, { 1472, 1536, 1600, 1728, 704, 768, 832, 896, 960, 1024, 1088, 1152, 1216, 1280, 1344, 1408 }, {}, { 1792, 1856, 1920 }, { 1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static a t;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static a u;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static b v;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static b w;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 747 */     (t = new a((byte)0)).e = true;
/* 748 */     t.c = -2000;
/*     */     
/* 750 */     (u = new a((byte)0)).c = -1000;
/* 751 */     u.a = u;
/* 752 */     u.b = t;
/*     */   }
/* 754 */   private static b x = new b((byte)0); private static b y; static {
/*     */     try {
/* 756 */       x.a(12, 0, u);
/* 757 */       x.a(12, 1, t);
/*     */     }
/* 759 */     catch (IOException iOException) {
/* 760 */       throw new AssertionError(iOException);
/*     */     } 
/*     */     
/* 763 */     v = new b((byte)0);
/*     */     try {
/* 765 */       for (byte b1 = 0; b1 < a.length; b1++) {
/* 766 */         for (byte b2 = 0; b2 < (a[b1]).length; b2++) {
/* 767 */           v.a(b1 + 2, a[b1][b2], b[b1][b2]);
/*     */         }
/*     */       } 
/* 770 */       v.a(12, 0, u);
/* 771 */       v.a(12, 1, t);
/*     */     }
/* 773 */     catch (IOException iOException) {
/* 774 */       throw new AssertionError(iOException);
/*     */     } 
/*     */     
/* 777 */     w = new b((byte)0);
/*     */     try {
/* 779 */       for (byte b1 = 0; b1 < c.length; b1++) {
/* 780 */         for (byte b2 = 0; b2 < (c[b1]).length; b2++) {
/* 781 */           w.a(b1 + 4, c[b1][b2], d[b1][b2]);
/*     */         }
/*     */       } 
/*     */       
/* 785 */       w.a(12, 0, u);
/* 786 */       w.a(12, 1, t);
/*     */     }
/* 788 */     catch (IOException iOException) {
/* 789 */       throw new AssertionError(iOException);
/*     */     } 
/*     */     
/* 792 */     y = new b((byte)0);
/*     */     try {
/* 794 */       y.a(4, 1, -3000);
/* 795 */       y.a(3, 1, -4000);
/* 796 */       y.a(1, 1, 0);
/* 797 */       y.a(3, 3, 1);
/* 798 */       y.a(6, 3, 2);
/* 799 */       y.a(7, 3, 3);
/* 800 */       y.a(3, 2, -1);
/* 801 */       y.a(6, 2, -2);
/* 802 */       y.a(7, 2, -3);
/*     */       return;
/* 804 */     } catch (IOException iOException) {
/* 805 */       throw new AssertionError(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */