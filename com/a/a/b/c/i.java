/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import com.a.a.b.c.b.a;
/*     */ import com.a.a.b.c.b.b;
/*     */ 
/*     */ public final class i
/*     */ {
/*   8 */   private static int a = 1000000;
/*   9 */   private static int b = 1000000000;
/*  10 */   private static long c = 1000000000L;
/*     */   
/*  12 */   private static long d = -2147483648L;
/*  13 */   private static long e = 2147483647L;
/*     */   
/*  15 */   private static String f = "-2147483648";
/*  16 */   private static String g = "-9223372036854775808";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  24 */   private static final int[] h = new int[1000];
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  29 */     byte b1 = 0;
/*  30 */     for (byte b2 = 0; b2 < 10; b2++) {
/*  31 */       for (byte b = 0; b < 10; b++) {
/*  32 */         for (byte b3 = 0; b3 < 10; b3++) {
/*  33 */           int j = b2 + 48 << 16 | b + 48 << 8 | b3 + 48;
/*     */ 
/*     */           
/*  36 */           h[b1++] = j;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*  42 */   private static final String[] i = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
/*     */ 
/*     */   
/*  45 */   private static final String[] j = new String[] { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/*  70 */     if (paramInt1 < 0) {
/*  71 */       if (paramInt1 == Integer.MIN_VALUE)
/*     */       {
/*     */         
/*  74 */         return b(paramArrayOfchar, paramInt2);
/*     */       }
/*  76 */       paramArrayOfchar[paramInt2++] = '-';
/*  77 */       paramInt1 = -paramInt1;
/*     */     } 
/*     */     
/*  80 */     if (paramInt1 < a) {
/*  81 */       if (paramInt1 < 1000) {
/*  82 */         if (paramInt1 < 10) {
/*  83 */           paramArrayOfchar[paramInt2] = (char)(paramInt1 + 48);
/*  84 */           return paramInt2 + 1;
/*     */         } 
/*  86 */         return d(paramInt1, paramArrayOfchar, paramInt2);
/*     */       } 
/*  88 */       int m = paramInt1 / 1000;
/*  89 */       paramInt1 -= m * 1000;
/*  90 */       paramInt2 = d(m, paramArrayOfchar, paramInt2);
/*     */       
/*  92 */       return paramInt2 = e(paramInt1, paramArrayOfchar, paramInt2);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     if (paramInt1 >= b) {
/*     */       
/* 102 */       if ((paramInt1 = paramInt1 - b) >= b) {
/* 103 */         paramInt1 -= b;
/* 104 */         paramArrayOfchar[paramInt2++] = '2';
/*     */       } else {
/* 106 */         paramArrayOfchar[paramInt2++] = '1';
/*     */       } 
/* 108 */       return c(paramInt1, paramArrayOfchar, paramInt2);
/*     */     } 
/* 110 */     int j = paramInt1 / 1000;
/* 111 */     int k = paramInt1 - j * 1000;
/* 112 */     paramInt1 = j;
/* 113 */     j /= 1000;
/* 114 */     paramInt1 -= j * 1000;
/*     */     
/* 116 */     paramInt2 = d(j, paramArrayOfchar, paramInt2);
/* 117 */     paramInt2 = e(paramInt1, paramArrayOfchar, paramInt2);
/* 118 */     return e(k, paramArrayOfchar, paramInt2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(long paramLong, char[] paramArrayOfchar, int paramInt) {
/* 182 */     if (paramLong < 0L) {
/* 183 */       if (paramLong > d) {
/* 184 */         return a((int)paramLong, paramArrayOfchar, paramInt);
/*     */       }
/* 186 */       if (paramLong == Long.MIN_VALUE) {
/* 187 */         return a(paramArrayOfchar, paramInt);
/*     */       }
/* 189 */       paramArrayOfchar[paramInt++] = '-';
/* 190 */       paramLong = -paramLong;
/*     */     }
/* 192 */     else if (paramLong <= e) {
/* 193 */       return a((int)paramLong, paramArrayOfchar, paramInt);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 198 */     long l = paramLong / c;
/* 199 */     paramLong -= l * c;
/*     */ 
/*     */     
/* 202 */     if (l < c) {
/* 203 */       paramInt = b((int)l, paramArrayOfchar, paramInt);
/*     */     } else {
/*     */       
/* 206 */       long l1 = l / c;
/* 207 */       l -= l1 * c;
/* 208 */       paramInt = d((int)l1, paramArrayOfchar, paramInt);
/* 209 */       paramInt = c((int)l, paramArrayOfchar, paramInt);
/*     */     } 
/* 211 */     return c((int)paramLong, paramArrayOfchar, paramInt);
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
/*     */   
/*     */   public static String a(int paramInt) {
/* 260 */     if (paramInt < i.length) {
/* 261 */       if (paramInt >= 0) {
/* 262 */         return i[paramInt];
/*     */       }
/*     */       int j;
/* 265 */       if ((j = -paramInt - 1) < j.length) {
/* 266 */         return j[j];
/*     */       }
/*     */     } 
/* 269 */     return Integer.toString(paramInt);
/*     */   }
/*     */   
/*     */   public static String a(long paramLong) {
/* 273 */     if (paramLong <= 2147483647L && paramLong >= -2147483648L) {
/* 274 */       return a((int)paramLong);
/*     */     }
/* 276 */     return Long.toString(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(double paramDouble) {
/* 284 */     return a(paramDouble, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(double paramDouble, boolean paramBoolean) {
/* 294 */     return paramBoolean ? a.a(paramDouble) : Double.toString(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(float paramFloat) {
/* 303 */     return a(paramFloat, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(float paramFloat, boolean paramBoolean) {
/* 313 */     return paramBoolean ? b.a(paramFloat) : Float.toString(paramFloat);
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
/*     */   public static boolean b(double paramDouble) {
/* 334 */     return (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble));
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
/*     */   public static boolean b(float paramFloat) {
/* 349 */     return (Float.isNaN(paramFloat) || Float.isInfinite(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 360 */     if (paramInt1 < a) {
/* 361 */       if (paramInt1 < 1000) {
/* 362 */         return d(paramInt1, paramArrayOfchar, paramInt2);
/*     */       }
/* 364 */       int m = paramInt1 / 1000;
/* 365 */       paramInt1 -= m * 1000;
/* 366 */       return a(paramArrayOfchar, paramInt2, m, paramInt1);
/*     */     } 
/* 368 */     int j = paramInt1 / 1000;
/* 369 */     paramInt1 -= j * 1000;
/* 370 */     int k = j / 1000;
/* 371 */     j -= k * 1000;
/*     */     
/* 373 */     paramInt2 = d(k, paramArrayOfchar, paramInt2);
/*     */     
/* 375 */     j = h[j];
/* 376 */     paramArrayOfchar[paramInt2++] = (char)(j >> 16);
/* 377 */     paramArrayOfchar[paramInt2++] = (char)(j >> 8 & 0x7F);
/* 378 */     paramArrayOfchar[paramInt2++] = (char)(j & 0x7F);
/*     */     
/* 380 */     j = h[paramInt1];
/* 381 */     paramArrayOfchar[paramInt2++] = (char)(j >> 16);
/* 382 */     paramArrayOfchar[paramInt2++] = (char)(j >> 8 & 0x7F);
/* 383 */     paramArrayOfchar[paramInt2++] = (char)(j & 0x7F);
/*     */     
/* 385 */     return paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int c(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 390 */     int j = paramInt1 / 1000;
/* 391 */     paramInt1 -= j * 1000;
/* 392 */     int k = j / 1000;
/*     */     
/* 394 */     int m = h[k];
/* 395 */     paramArrayOfchar[paramInt2++] = (char)(m >> 16);
/* 396 */     paramArrayOfchar[paramInt2++] = (char)(m >> 8 & 0x7F);
/* 397 */     paramArrayOfchar[paramInt2++] = (char)(m & 0x7F);
/*     */     
/* 399 */     j -= k * 1000;
/* 400 */     m = h[j];
/* 401 */     paramArrayOfchar[paramInt2++] = (char)(m >> 16);
/* 402 */     paramArrayOfchar[paramInt2++] = (char)(m >> 8 & 0x7F);
/* 403 */     paramArrayOfchar[paramInt2++] = (char)(m & 0x7F);
/*     */     
/* 405 */     m = h[paramInt1];
/* 406 */     paramArrayOfchar[paramInt2++] = (char)(m >> 16);
/* 407 */     paramArrayOfchar[paramInt2++] = (char)(m >> 8 & 0x7F);
/* 408 */     paramArrayOfchar[paramInt2++] = (char)(m & 0x7F);
/*     */     
/* 410 */     return paramInt2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 470 */     int j = h[paramInt2];
/* 471 */     if (paramInt2 > 9) {
/* 472 */       if (paramInt2 > 99) {
/* 473 */         paramArrayOfchar[paramInt1++] = (char)(j >> 16);
/*     */       }
/* 475 */       paramArrayOfchar[paramInt1++] = (char)(j >> 8 & 0x7F);
/*     */     } 
/* 477 */     paramArrayOfchar[paramInt1++] = (char)(j & 0x7F);
/*     */     
/* 479 */     j = h[paramInt3];
/* 480 */     paramArrayOfchar[paramInt1++] = (char)(j >> 16);
/* 481 */     paramArrayOfchar[paramInt1++] = (char)(j >> 8 & 0x7F);
/* 482 */     paramArrayOfchar[paramInt1++] = (char)(j & 0x7F);
/* 483 */     return paramInt1;
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
/*     */   private static int d(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 506 */     int j = h[paramInt1];
/* 507 */     if (paramInt1 > 9) {
/* 508 */       if (paramInt1 > 99) {
/* 509 */         paramArrayOfchar[paramInt2++] = (char)(j >> 16);
/*     */       }
/* 511 */       paramArrayOfchar[paramInt2++] = (char)(j >> 8 & 0x7F);
/*     */     } 
/* 513 */     paramArrayOfchar[paramInt2++] = (char)(j & 0x7F);
/* 514 */     return paramInt2;
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
/*     */   private static int e(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 532 */     paramInt1 = h[paramInt1];
/* 533 */     paramArrayOfchar[paramInt2++] = (char)(paramInt1 >> 16);
/* 534 */     paramArrayOfchar[paramInt2++] = (char)(paramInt1 >> 8 & 0x7F);
/* 535 */     paramArrayOfchar[paramInt2++] = (char)(paramInt1 & 0x7F);
/* 536 */     return paramInt2;
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
/*     */   private static int a(char[] paramArrayOfchar, int paramInt) {
/* 552 */     int j = g.length();
/* 553 */     g.getChars(0, j, paramArrayOfchar, paramInt);
/* 554 */     return paramInt + j;
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
/*     */   private static int b(char[] paramArrayOfchar, int paramInt) {
/* 568 */     int j = f.length();
/* 569 */     f.getChars(0, j, paramArrayOfchar, paramInt);
/* 570 */     return paramInt + j;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */