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
/*     */ 
/*     */ public final class a
/*     */ {
/* 112 */   private static final ThreadLocal<a> a = ThreadLocal.withInitial(a::new);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   private final byte[] b = new byte[24];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public static String a(double paramDouble) {
/* 249 */     return a().b(paramDouble);
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
/*     */   private static a a() {
/* 269 */     return a.get();
/*     */   }
/*     */   
/*     */   private String b(double paramDouble) {
/* 273 */     switch (c(paramDouble)) { case 0:
/* 274 */         return c();
/* 275 */       case 1: return "0.0";
/* 276 */       case 2: return "-0.0";
/* 277 */       case 3: return "Infinity";
/* 278 */       case 4: return "-Infinity"; }
/* 279 */      return "NaN";
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
/*     */   private int c(double paramDouble) {
/* 327 */     long l1, l2 = (l1 = Double.doubleToRawLongBits(paramDouble)) & 0xFFFFFFFFFFFFFL;
/*     */     int i;
/* 329 */     if ((i = (int)(l1 >>> 52L) & 0x7FF) < 2047) {
/* 330 */       this.c = -1;
/* 331 */       if (l1 < 0L) {
/* 332 */         e(45);
/*     */       }
/* 334 */       if (i != 0) {
/*     */         
/* 336 */         i = 1075 - i;
/* 337 */         long l3 = 0x10000000000000L | l2;
/*     */         long l4;
/* 339 */         if ((((i > 0) ? 1 : 0) & ((i < 53) ? 1 : 0)) != 0 && (
/*     */           
/* 341 */           l4 = l3 >> i) << i == l3) {
/* 342 */           return a(l4, 0);
/*     */         }
/*     */         
/* 345 */         return a(-i, l3, 0);
/*     */       } 
/* 347 */       if (l2 != 0L) {
/*     */         
/* 349 */         if (l2 < 3L)
/* 350 */           return a(-1074, 10L * l2, -1); 
/* 351 */         return a(-1074, l2, 0);
/*     */       } 
/* 353 */       return (l1 == 0L) ? 1 : 2;
/*     */     } 
/* 355 */     if (l2 != 0L) {
/* 356 */       return 5;
/*     */     }
/* 358 */     return (l1 > 0L) ? 3 : 4;
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
/*     */   private int a(int paramInt1, long paramLong, int paramInt2) {
/*     */     int i;
/*     */     long l3;
/* 379 */     int j = (int)paramLong & 0x1;
/*     */     
/* 381 */     long l1, l2 = (l1 = paramLong << 2L) + 2L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     if ((((paramLong != 4503599627370496L) ? 1 : 0) | ((paramInt1 == -1074) ? 1 : 0)) != 0) {
/*     */       
/* 391 */       l3 = l1 - 2L;
/* 392 */       i = c.b(paramInt1);
/*     */     } else {
/*     */       
/* 395 */       l3 = l1 - 1L;
/* 396 */       i = c.c(paramInt1);
/*     */     } 
/* 398 */     paramInt1 = paramInt1 + c.d(-i) + 2;
/*     */ 
/*     */     
/* 401 */     long l4 = c.e(i);
/* 402 */     long l5 = c.f(i);
/*     */     
/* 404 */     long l6 = a(l4, l5, l1 << paramInt1);
/* 405 */     long l7 = a(l4, l5, l3 << paramInt1);
/* 406 */     long l8 = a(l4, l5, l2 << paramInt1);
/*     */     
/*     */     long l9;
/* 409 */     if ((l9 = l6 >> 2L) >= 100L) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 422 */       long l12, l13 = (l12 = 10L * c.a(l9, 1844674407370955168L)) + 10L;
/* 423 */       boolean bool3 = (l7 + j <= l12 << 2L) ? true : false;
/* 424 */       boolean bool4 = ((l13 << 2L) + j <= l8) ? true : false;
/* 425 */       if (bool3 != bool4) {
/* 426 */         return a(bool3 ? l12 : l13, i);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     long l10 = l9 + 1L;
/* 437 */     boolean bool1 = (l7 + j <= l9 << 2L) ? true : false;
/* 438 */     boolean bool2 = ((l10 << 2L) + j <= l8) ? true : false;
/* 439 */     if (bool1 != bool2)
/*     */     {
/* 441 */       return a(bool1 ? l9 : l10, i + paramInt2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 447 */     long l11 = l6 - (l9 + l10 << 1L);
/* 448 */     return a((l11 < 0L || (l11 == 0L && (l9 & 0x1L) == 0L)) ? l9 : l10, i + paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long a(long paramLong1, long paramLong2, long paramLong3) {
/* 456 */     long l1 = c.a(paramLong2, paramLong3);
/* 457 */     long l2 = paramLong1 * paramLong3;
/* 458 */     long l3 = c.a(paramLong1, paramLong3);
/* 459 */     long l4 = (l2 >>> 1L) + l1;
/*     */     long l5;
/* 461 */     return (l5 = l3 + (l4 >>> 63L)) | (l4 & Long.MAX_VALUE) + Long.MAX_VALUE >>> 63L;
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
/*     */   private int a(long paramLong, int paramInt) {
/* 474 */     int k = c.b(64 - Long.numberOfLeadingZeros(paramLong));
/* 475 */     if (paramLong >= c.a(k)) {
/* 476 */       k++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 485 */     paramLong *= c.a(17 - k);
/* 486 */     paramInt += k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 502 */     long l = c.a(paramLong, 193428131138340668L) >>> 20L;
/* 503 */     int i = (int)(paramLong - 100000000L * l);
/* 504 */     int j = (int)(l * 1441151881L >>> 57L);
/* 505 */     k = (int)(l - (j * 100000000));
/*     */     
/* 507 */     if (paramInt > 0 && paramInt <= 7) {
/* 508 */       return a(j, k, i, paramInt);
/*     */     }
/* 510 */     if (-3 < paramInt && paramInt <= 0) {
/* 511 */       return b(j, k, i, paramInt);
/*     */     }
/* 513 */     return c(j, k, i, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 522 */     f(paramInt1);
/* 523 */     paramInt1 = c(paramInt2);
/*     */     
/* 525 */     paramInt2 = 1;
/* 526 */     for (; paramInt2 < paramInt4; paramInt2++) {
/* 527 */       paramInt1 *= 10;
/* 528 */       f(paramInt1 >>> 28);
/* 529 */       paramInt1 &= 0xFFFFFFF;
/*     */     } 
/* 531 */     e(46);
/* 532 */     for (; paramInt2 <= 8; paramInt2++) {
/* 533 */       paramInt1 *= 10;
/* 534 */       f(paramInt1 >>> 28);
/* 535 */       paramInt1 &= 0xFFFFFFF;
/*     */     } 
/* 537 */     a(paramInt3);
/* 538 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 543 */     f(0);
/* 544 */     e(46);
/* 545 */     for (; paramInt4 < 0; paramInt4++) {
/* 546 */       f(0);
/*     */     }
/* 548 */     f(paramInt1);
/* 549 */     b(paramInt2);
/* 550 */     a(paramInt3);
/* 551 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 556 */     f(paramInt1);
/* 557 */     e(46);
/* 558 */     b(paramInt2);
/* 559 */     a(paramInt3);
/* 560 */     d(paramInt4 - 1);
/* 561 */     return 0;
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 565 */     if (paramInt != 0) {
/* 566 */       b(paramInt);
/*     */     }
/* 568 */     b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 576 */     paramInt = c(paramInt);
/* 577 */     for (byte b = 0; b < 8; b++) {
/* 578 */       paramInt *= 10;
/* 579 */       f(paramInt >>> 28);
/* 580 */       paramInt &= 0xFFFFFFF;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/* 585 */     while (this.b[this.c] == 48) {
/* 586 */       this.c--;
/*     */     }
/*     */     
/* 589 */     if (this.b[this.c] == 46) {
/* 590 */       this.c++;
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
/*     */   private static int c(int paramInt) {
/* 603 */     return (int)(c.a((paramInt + 1) << 28L, 193428131138340668L) >>> 20L) - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(int paramInt) {
/* 609 */     e(69);
/* 610 */     if (paramInt < 0) {
/* 611 */       e(45);
/* 612 */       paramInt = -paramInt;
/*     */     } 
/* 614 */     if (paramInt < 10) {
/* 615 */       f(paramInt);
/*     */       
/*     */       return;
/*     */     } 
/* 619 */     if (paramInt >= 100) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 624 */       int j = paramInt * 1311 >>> 17;
/* 625 */       f(j);
/* 626 */       paramInt -= j * 100;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 632 */     int i = paramInt * 103 >>> 10;
/* 633 */     f(i);
/* 634 */     f(paramInt - i * 10);
/*     */   }
/*     */   
/*     */   private void e(int paramInt) {
/* 638 */     this.b[++this.c] = (byte)paramInt;
/*     */   }
/*     */   
/*     */   private void f(int paramInt) {
/* 642 */     this.b[++this.c] = (byte)(paramInt + 48);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String c() {
/* 648 */     return new String(this.b, 0, 0, this.c + 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */