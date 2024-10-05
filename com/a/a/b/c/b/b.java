/*     */ package com.a.a.b.c.b;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/* 111 */   private static final ThreadLocal<b> a = ThreadLocal.withInitial(b::new);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   private final byte[] b = new byte[15];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(float paramFloat) {
/* 248 */     return a().b(paramFloat);
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
/*     */   private static b a() {
/* 268 */     return a.get();
/*     */   }
/*     */   
/*     */   private String b(float paramFloat) {
/* 272 */     switch (c(paramFloat)) { case 0:
/* 273 */         return c();
/* 274 */       case 1: return "0.0";
/* 275 */       case 2: return "-0.0";
/* 276 */       case 3: return "Infinity";
/* 277 */       case 4: return "-Infinity"; }
/* 278 */      return "NaN";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int c(float paramFloat) {
/* 326 */     int i, j = (i = Float.floatToRawIntBits(paramFloat)) & 0x7FFFFF;
/*     */     int k;
/* 328 */     if ((k = i >>> 23 & 0xFF) < 255) {
/* 329 */       this.c = -1;
/* 330 */       if (i < 0) {
/* 331 */         d(45);
/*     */       }
/* 333 */       if (k != 0) {
/*     */         
/* 335 */         i = 150 - k;
/* 336 */         j = 0x800000 | j;
/*     */         
/* 338 */         if ((((i > 0) ? 1 : 0) & ((i < 24) ? 1 : 0)) != 0 && (
/*     */           
/* 340 */           k = j >> i) << i == j) {
/* 341 */           return a(k, 0);
/*     */         }
/*     */         
/* 344 */         return a(-i, j, 0);
/*     */       } 
/* 346 */       if (j != 0) {
/*     */         
/* 348 */         if (j < 8)
/* 349 */           return a(-149, j * 10, -1); 
/* 350 */         return a(-149, j, 0);
/*     */       } 
/* 352 */       return (i == 0) ? 1 : 2;
/*     */     } 
/* 354 */     if (j != 0) {
/* 355 */       return 5;
/*     */     }
/* 357 */     return (i > 0) ? 3 : 4;
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
/*     */   private int a(int paramInt1, int paramInt2, int paramInt3) {
/*     */     long l3;
/* 379 */     int i = paramInt2 & 0x1;
/*     */     
/* 381 */     long l1, l2 = (l1 = (paramInt2 << 2)) + 2L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     if ((((paramInt2 != 8388608) ? 1 : 0) | ((paramInt1 == -149) ? 1 : 0)) != 0) {
/*     */       
/* 391 */       l3 = l1 - 2L;
/* 392 */       paramInt2 = c.b(paramInt1);
/*     */     } else {
/*     */       
/* 395 */       l3 = l1 - 1L;
/* 396 */       paramInt2 = c.c(paramInt1);
/*     */     } 
/* 398 */     paramInt1 = paramInt1 + c.d(-paramInt2) + 33;
/*     */ 
/*     */     
/*     */     long l4;
/*     */     
/* 403 */     int j = a(l4 = c.e(paramInt2) + 1L, l1 << paramInt1);
/* 404 */     int k = a(l4, l3 << paramInt1);
/* 405 */     paramInt1 = a(l4, l2 << paramInt1);
/*     */     
/*     */     int m;
/* 408 */     if ((m = j >> 2) >= 100) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 420 */       int i2, i3 = (i2 = 10 * (int)(m * 1717986919L >>> 34L)) + 10;
/* 421 */       boolean bool3 = (k + i <= i2 << 2) ? true : false;
/* 422 */       boolean bool4 = ((i3 << 2) + i <= paramInt1) ? true : false;
/* 423 */       if (bool3 != bool4) {
/* 424 */         return a(bool3 ? i2 : i3, paramInt2);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 434 */     int n = m + 1;
/* 435 */     boolean bool1 = (k + i <= m << 2) ? true : false;
/* 436 */     boolean bool2 = ((n << 2) + i <= paramInt1) ? true : false;
/* 437 */     if (bool1 != bool2)
/*     */     {
/* 439 */       return a(bool1 ? m : n, paramInt2 + paramInt3);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 445 */     int i1 = j - (m + n << 1);
/* 446 */     return a((i1 < 0 || (i1 == 0 && (m & 0x1) == 0)) ? m : n, paramInt2 + paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(long paramLong1, long paramLong2) {
/*     */     long l1;
/*     */     long l2;
/* 456 */     return (int)((l2 = (l1 = c.a(paramLong1, paramLong2)) >>> 31L) | (l1 & 0xFFFFFFFFL) + 4294967295L >>> 32L);
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
/*     */   private int a(int paramInt1, int paramInt2) {
/* 469 */     int i = c.b(32 - Integer.numberOfLeadingZeros(paramInt1));
/* 470 */     if (paramInt1 >= c.a(i)) {
/* 471 */       i++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 480 */     paramInt1 = (int)(paramInt1 * c.a(9 - i));
/* 481 */     paramInt2 += i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 493 */     i = (int)(paramInt1 * 1441151881L >>> 57L);
/* 494 */     paramInt1 -= i * 100000000;
/*     */     
/* 496 */     if (paramInt2 > 0 && paramInt2 <= 7) {
/* 497 */       return b(i, paramInt1, paramInt2);
/*     */     }
/* 499 */     if (-3 < paramInt2 && paramInt2 <= 0) {
/* 500 */       return c(i, paramInt1, paramInt2);
/*     */     }
/* 502 */     return d(i, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b(int paramInt1, int paramInt2, int paramInt3) {
/* 511 */     e(paramInt1);
/* 512 */     paramInt1 = b(paramInt2);
/*     */     
/* 514 */     paramInt2 = 1;
/* 515 */     for (; paramInt2 < paramInt3; paramInt2++) {
/* 516 */       paramInt1 *= 10;
/* 517 */       e(paramInt1 >>> 28);
/* 518 */       paramInt1 &= 0xFFFFFFF;
/*     */     } 
/* 520 */     d(46);
/* 521 */     for (; paramInt2 <= 8; paramInt2++) {
/* 522 */       paramInt1 *= 10;
/* 523 */       e(paramInt1 >>> 28);
/* 524 */       paramInt1 &= 0xFFFFFFF;
/*     */     } 
/* 526 */     b();
/* 527 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private int c(int paramInt1, int paramInt2, int paramInt3) {
/* 532 */     e(0);
/* 533 */     d(46);
/* 534 */     for (; paramInt3 < 0; paramInt3++) {
/* 535 */       e(0);
/*     */     }
/* 537 */     e(paramInt1);
/* 538 */     a(paramInt2);
/* 539 */     b();
/* 540 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private int d(int paramInt1, int paramInt2, int paramInt3) {
/* 545 */     e(paramInt1);
/* 546 */     d(46);
/* 547 */     a(paramInt2);
/* 548 */     b();
/* 549 */     c(paramInt3 - 1);
/* 550 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/* 558 */     paramInt = b(paramInt);
/* 559 */     for (byte b1 = 0; b1 < 8; b1++) {
/* 560 */       paramInt *= 10;
/* 561 */       e(paramInt >>> 28);
/* 562 */       paramInt &= 0xFFFFFFF;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/* 567 */     while (this.b[this.c] == 48) {
/* 568 */       this.c--;
/*     */     }
/*     */     
/* 571 */     if (this.b[this.c] == 46) {
/* 572 */       this.c++;
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
/*     */   private static int b(int paramInt) {
/* 585 */     return (int)(c.a((paramInt + 1) << 28L, 193428131138340668L) >>> 20L) - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(int paramInt) {
/* 591 */     d(69);
/* 592 */     if (paramInt < 0) {
/* 593 */       d(45);
/* 594 */       paramInt = -paramInt;
/*     */     } 
/* 596 */     if (paramInt < 10) {
/* 597 */       e(paramInt);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 604 */     int i = paramInt * 103 >>> 10;
/* 605 */     e(i);
/* 606 */     e(paramInt - i * 10);
/*     */   }
/*     */   
/*     */   private void d(int paramInt) {
/* 610 */     this.b[++this.c] = (byte)paramInt;
/*     */   }
/*     */   
/*     */   private void e(int paramInt) {
/* 614 */     this.b[++this.c] = (byte)(paramInt + 48);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String c() {
/* 620 */     return new String(this.b, 0, 0, this.c + 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */