/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   implements c
/*     */ {
/*  38 */   private static final org.a.a.a.a a = c.a(d.class);
/*     */   
/*     */   private int b;
/*     */   
/*     */   private int c;
/*     */   
/*     */   private long d;
/*     */   
/*     */   private int[] e;
/*  47 */   private final Map<Integer, List<Integer>> f = new HashMap<Integer, List<Integer>>();
/*  48 */   private Map<Integer, Integer> g = new HashMap<Integer, Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ak paramak) {
/*  58 */     this.b = paramak.c();
/*  59 */     this.c = paramak.c();
/*  60 */     this.d = paramak.k();
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
/*     */   public final void a(f paramf, int paramInt, ak paramak) {
/*  73 */     paramak.a(paramf.D() + this.d);
/*     */     
/*     */     int i;
/*     */     
/*  77 */     if ((i = paramak.c()) < 8) {
/*     */       
/*  79 */       paramak.c();
/*  80 */       paramak.c();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  85 */       paramak.c();
/*  86 */       paramak.k();
/*  87 */       paramak.k();
/*     */     } 
/*     */     
/*  90 */     switch (i) {
/*     */       
/*     */       case 0:
/*  93 */         c(paramak);
/*     */         return;
/*     */       case 2:
/*  96 */         f(paramak, paramInt);
/*     */         return;
/*     */       case 4:
/*  99 */         e(paramak, paramInt);
/*     */         return;
/*     */       case 6:
/* 102 */         d(paramak, paramInt);
/*     */         return;
/*     */       case 8:
/* 105 */         a(paramak, paramInt);
/*     */         return;
/*     */       case 10:
/* 108 */         b(paramak);
/*     */         return;
/*     */       case 12:
/* 111 */         b(paramak, paramInt);
/*     */         return;
/*     */       case 13:
/* 114 */         c(paramak, paramInt);
/*     */         return;
/*     */       
/*     */       case 14:
/*     */         return;
/*     */     } 
/* 120 */     throw new IOException("Unknown cmap format:" + i);
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
/*     */   private void a(ak paramak, int paramInt) {
/* 134 */     int[] arrayOfInt = paramak.b(8192);
/*     */     
/*     */     long l1;
/*     */     
/* 138 */     if ((l1 = paramak.k()) > 65536L)
/*     */     {
/* 140 */       throw new IOException("CMap ( Subtype8 ) is invalid");
/*     */     }
/*     */     
/* 143 */     this.e = d(paramInt);
/* 144 */     this.g = new HashMap<Integer, Integer>(paramInt);
/*     */     long l2;
/* 146 */     for (l2 = 0L; l2 < l1; l2++) {
/*     */       
/* 148 */       long l3 = paramak.k();
/* 149 */       long l4 = paramak.k();
/* 150 */       long l5 = paramak.k();
/*     */ 
/*     */       
/* 153 */       if (l3 > l4 || 0L > l3)
/*     */       {
/* 155 */         throw new IOException("Range invalid");
/*     */       }
/*     */       long l6;
/* 158 */       for (l6 = l3; l6 <= l4; l6++) {
/*     */         int i;
/*     */         
/* 161 */         if (l6 > 2147483647L)
/*     */         {
/* 163 */           throw new IOException("[Sub Format 8] Invalid Character code");
/*     */         }
/*     */ 
/*     */         
/* 167 */         if ((arrayOfInt[(int)l6 / 8] & 1 << (int)l6 % 8) == 0) {
/*     */           
/* 169 */           i = (int)l6;
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 175 */           long l7 = 55232L + (l6 >> 10L);
/* 176 */           long l8 = 56320L + (l6 & 0x3FFL);
/*     */           
/*     */           long l9;
/* 179 */           if ((l9 = (l7 << 10L) + l8 + -56613888L) > 2147483647L)
/*     */           {
/* 181 */             throw new IOException("[Sub Format 8] Invalid Character code");
/*     */           }
/* 183 */           i = (int)l9;
/*     */         } 
/*     */         
/*     */         long l;
/* 187 */         if ((l = l5 + l6 - l3) > paramInt || l > 2147483647L)
/*     */         {
/* 189 */           throw new IOException("CMap contains an invalid glyph index");
/*     */         }
/*     */         
/* 192 */         this.e[(int)l] = i;
/* 193 */         this.g.put(Integer.valueOf(i), Integer.valueOf((int)l));
/*     */       } 
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
/*     */   private static void b(ak paramak) {
/* 207 */     long l1 = paramak.k();
/*     */     long l2;
/* 209 */     if ((l2 = paramak.k()) > 2147483647L)
/*     */     {
/* 211 */       throw new IOException("Invalid number of Characters");
/*     */     }
/*     */     
/* 214 */     if (l1 < 0L || l1 > 1114111L || l1 + l2 > 1114111L || (l1 + l2 >= 55296L && l1 + l2 <= 57343L))
/*     */     {
/*     */       
/* 217 */       throw new IOException("Invalid Characters codes");
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
/*     */   
/*     */   private void b(ak paramak, int paramInt) {
/* 231 */     long l1 = paramak.k();
/* 232 */     this.e = d(paramInt);
/* 233 */     this.g = new HashMap<Integer, Integer>(paramInt); long l2;
/* 234 */     for (l2 = 0L; l2 < l1; l2++) {
/*     */       
/* 236 */       long l3 = paramak.k();
/* 237 */       long l4 = paramak.k();
/* 238 */       long l5 = paramak.k();
/*     */       
/* 240 */       if (l3 < 0L || l3 > 1114111L || (l3 >= 55296L && l3 <= 57343L))
/*     */       {
/*     */         
/* 243 */         throw new IOException("Invalid characters codes");
/*     */       }
/*     */       
/* 246 */       if ((l4 > 0L && l4 < l3) || l4 > 1114111L || (l4 >= 55296L && l4 <= 57343L))
/*     */       {
/*     */ 
/*     */         
/* 250 */         throw new IOException("Invalid characters codes");
/*     */       }
/*     */       long l6;
/* 253 */       for (l6 = 0L; l6 <= l4 - l3;) {
/*     */ 
/*     */         
/* 256 */         if ((l = l5 + l6) < paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 267 */           this.e[(int)l] = (int)(l3 + l6);
/* 268 */           this.g.put(Integer.valueOf((int)(l3 + l6)), Integer.valueOf((int)l));
/*     */           l6++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(ak paramak, int paramInt) {
/* 282 */     long l1 = paramak.k();
/* 283 */     this.g = new HashMap<Integer, Integer>(paramInt); long l2;
/* 284 */     for (l2 = 0L; l2 < l1; ) {
/*     */       
/* 286 */       long l3 = paramak.k();
/* 287 */       long l4 = paramak.k();
/*     */       
/*     */       long l5;
/* 290 */       if ((l5 = paramak.k()) <= paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 296 */         if (l3 < 0L || l3 > 1114111L || (l3 >= 55296L && l3 <= 57343L))
/*     */         {
/* 298 */           throw new IOException("Invalid Characters codes");
/*     */         }
/*     */         
/* 301 */         if ((l4 > 0L && l4 < l3) || l4 > 1114111L || (l4 >= 55296L && l4 <= 57343L))
/*     */         {
/*     */           
/* 304 */           throw new IOException("Invalid Characters codes");
/*     */         }
/*     */         long l;
/* 307 */         for (l = 0L; l <= l4 - l3; l++) {
/*     */           
/* 309 */           if (l3 + l > 2147483647L)
/*     */           {
/* 311 */             throw new IOException("Character Code greater than Integer.MAX_VALUE");
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 319 */           this.e[(int)l5] = (int)(l3 + l);
/* 320 */           this.g.put(Integer.valueOf((int)(l3 + l)), Integer.valueOf((int)l5));
/*     */         } 
/*     */         l2++;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(ak paramak, int paramInt) {
/* 348 */     int i = paramak.c();
/*     */     
/*     */     int j;
/* 351 */     if ((j = paramak.c()) == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 355 */     this.g = new HashMap<Integer, Integer>(paramInt);
/* 356 */     int[] arrayOfInt = paramak.c(j);
/* 357 */     paramInt = 0;
/* 358 */     for (byte b = 0; b < j; b++) {
/*     */       
/* 360 */       paramInt = Math.max(paramInt, arrayOfInt[b]);
/* 361 */       this.g.put(Integer.valueOf(i + b), Integer.valueOf(arrayOfInt[b]));
/*     */     } 
/* 363 */     c(paramInt);
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
/*     */   private void e(ak paramak, int paramInt) {
/* 376 */     int i = (i = paramak.c()) / 2;
/* 377 */     paramak.c();
/* 378 */     paramak.c();
/* 379 */     paramak.c();
/* 380 */     int[] arrayOfInt1 = paramak.c(i);
/* 381 */     paramak.c();
/* 382 */     int[] arrayOfInt2 = paramak.c(i);
/* 383 */     int[] arrayOfInt3 = paramak.c(i);
/* 384 */     long l = paramak.e();
/* 385 */     int[] arrayOfInt4 = paramak.c(i);
/*     */     
/* 387 */     this.g = new HashMap<Integer, Integer>(paramInt);
/* 388 */     paramInt = 0;
/*     */     
/* 390 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 392 */       int j = arrayOfInt2[b];
/* 393 */       int k = arrayOfInt1[b];
/* 394 */       int m = arrayOfInt3[b];
/* 395 */       int n = arrayOfInt4[b];
/* 396 */       long l1 = l + (b << 1) + n;
/* 397 */       if (j != 65535 && k != 65535)
/*     */       {
/* 399 */         for (int i1 = j; i1 <= k; i1++) {
/*     */           
/* 401 */           if (n == 0) {
/*     */             int i2;
/*     */             
/* 404 */             paramInt = Math.max(i2 = i1 + m & 0xFFFF, paramInt);
/* 405 */             this.g.put(Integer.valueOf(i1), Integer.valueOf(i2));
/*     */           }
/*     */           else {
/*     */             
/* 409 */             long l2 = l1 + (i1 - j << 1);
/* 410 */             paramak.a(l2);
/*     */             int i2;
/* 412 */             if ((i2 = paramak.c()) != 0) {
/*     */ 
/*     */               
/* 415 */               paramInt = Math.max(i2 = i2 + m & 0xFFFF, paramInt);
/* 416 */               this.g.put(Integer.valueOf(i1), Integer.valueOf(i2));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 427 */     if (this.g.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 432 */     c(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(int paramInt) {
/* 437 */     this.e = d(paramInt + 1);
/* 438 */     for (Map.Entry<Integer, Integer> entry : this.g.entrySet()) {
/*     */       
/* 440 */       if (this.e[((Integer)entry.getValue()).intValue()] == -1) {
/*     */ 
/*     */         
/* 443 */         this.e[((Integer)entry.getValue()).intValue()] = ((Integer)entry.getKey()).intValue();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       List<Integer> list;
/* 449 */       if ((list = this.f.get(entry.getValue())) == null) {
/*     */         
/* 451 */         list = new ArrayList();
/* 452 */         this.f.put((Integer)entry.getValue(), list);
/* 453 */         list.add(Integer.valueOf(this.e[((Integer)entry.getValue()).intValue()]));
/*     */         
/* 455 */         this.e[((Integer)entry.getValue()).intValue()] = Integer.MIN_VALUE;
/*     */       } 
/* 457 */       list.add((Integer)entry.getKey());
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
/*     */   
/*     */   private void f(ak paramak, int paramInt) {
/* 471 */     int[] arrayOfInt = new int[256];
/*     */     
/* 473 */     int i = 0;
/* 474 */     for (byte b2 = 0; b2 < 'Ā'; b2++) {
/*     */       
/* 476 */       arrayOfInt[b2] = paramak.c();
/* 477 */       i = Math.max(i, arrayOfInt[b2] / 8);
/*     */     } 
/*     */ 
/*     */     
/* 481 */     a[] arrayOfA = new a[i + 1];
/* 482 */     for (byte b3 = 0; b3 <= i; b3++) {
/*     */       
/* 484 */       int k = paramak.c();
/* 485 */       int j = paramak.c();
/* 486 */       short s = paramak.d();
/* 487 */       int m = paramak.c() - (i + 1 - b3 - 1 << 3) - 2;
/* 488 */       arrayOfA[b3] = new a(k, j, s, m, (byte)0);
/*     */     } 
/* 490 */     long l = paramak.e();
/* 491 */     this.e = d(paramInt);
/* 492 */     this.g = new HashMap<Integer, Integer>(paramInt);
/* 493 */     for (byte b1 = 0; b1 <= i; b1++) {
/*     */       a a1;
/*     */       
/* 496 */       int k = a.a(a1 = arrayOfA[b1]);
/* 497 */       int m = a.b(a1);
/* 498 */       short s = a.c(a1);
/* 499 */       int j = a.d(a1);
/* 500 */       paramak.a(l + m);
/* 501 */       for (m = 0; m < j; m++) {
/*     */ 
/*     */ 
/*     */         
/* 505 */         int n = ((n = b1) << 8) + k + m;
/*     */ 
/*     */ 
/*     */         
/*     */         int i1;
/*     */ 
/*     */ 
/*     */         
/* 513 */         if ((i1 = paramak.c()) > 0)
/*     */         {
/*     */           
/* 516 */           if ((i1 = (i1 + s) % 65536) < 0)
/*     */           {
/* 518 */             i1 += 65536;
/*     */           }
/*     */         }
/*     */         
/* 522 */         if (i1 >= paramInt) {
/*     */           
/* 524 */           (new StringBuilder("glyphId ")).append(i1).append(" for charcode ").append(n).append(" ignored, numGlyphs is ").append(paramInt);
/*     */         }
/*     */         else {
/*     */           
/* 528 */           this.e[i1] = n;
/* 529 */           this.g.put(Integer.valueOf(n), Integer.valueOf(i1));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(ak paramak) {
/* 542 */     byte[] arrayOfByte = paramak.d(256);
/* 543 */     this.e = d(256);
/* 544 */     this.g = new HashMap<Integer, Integer>(arrayOfByte.length);
/* 545 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/*     */       
/* 547 */       int i = arrayOfByte[b] & 0xFF;
/* 548 */       this.e[i] = b;
/* 549 */       this.g.put(Integer.valueOf(b), Integer.valueOf(i));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] d(int paramInt) {
/*     */     int[] arrayOfInt;
/* 560 */     Arrays.fill(arrayOfInt = new int[paramInt], -1);
/* 561 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/* 569 */     return this.c;
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
/*     */   public final int b() {
/* 585 */     return this.b;
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
/*     */   public final int a(int paramInt) {
/*     */     Integer integer;
/* 606 */     return ((integer = this.g.get(Integer.valueOf(paramInt))) == null) ? 0 : integer.intValue();
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
/*     */   private int e(int paramInt) {
/* 640 */     if (paramInt < 0 || paramInt >= this.e.length)
/*     */     {
/* 642 */       return -1;
/*     */     }
/* 644 */     return this.e[paramInt];
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
/*     */   public final List<Integer> b(int paramInt) {
/*     */     int i;
/* 658 */     if ((i = e(paramInt)) == -1)
/*     */     {
/* 660 */       return null;
/*     */     }
/* 662 */     ArrayList<Comparable> arrayList = null;
/* 663 */     if (i == Integer.MIN_VALUE) {
/*     */       List<?> list;
/*     */       
/* 666 */       if ((list = this.f.get(Integer.valueOf(paramInt))) != null)
/*     */       {
/*     */ 
/*     */         
/* 670 */         Collections.sort(arrayList = new ArrayList<Comparable>(list));
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 676 */       (arrayList = new ArrayList<Comparable>(1)).add(Integer.valueOf(i));
/*     */     } 
/* 678 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 684 */     return "{" + b() + " " + a() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a
/*     */   {
/*     */     private final int a;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int b;
/*     */ 
/*     */     
/*     */     private final short c;
/*     */ 
/*     */     
/*     */     private final int d;
/*     */ 
/*     */ 
/*     */     
/*     */     private a(int param1Int1, int param1Int2, short param1Short, int param1Int3) {
/* 707 */       this.a = param1Int1;
/* 708 */       this.b = param1Int2;
/* 709 */       this.c = param1Short;
/* 710 */       this.d = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int a() {
/* 718 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int b() {
/* 726 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private short c() {
/* 734 */       return this.c;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int d() {
/* 742 */       return this.d;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */