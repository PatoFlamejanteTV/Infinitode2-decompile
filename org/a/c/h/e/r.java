/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.f.aq;
/*     */ import org.a.b.f.ar;
/*     */ import org.a.b.f.k;
/*     */ import org.a.b.f.p;
/*     */ import org.a.b.f.s;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class r
/*     */   extends aj
/*     */ {
/*  56 */   private static final org.a.a.a.a d = c.a(r.class);
/*     */ 
/*     */   
/*     */   private final b e;
/*     */ 
/*     */   
/*     */   private final ac f;
/*     */ 
/*     */   
/*     */   private final d g;
/*     */ 
/*     */   
/*     */   private final d h;
/*     */ 
/*     */   
/*     */   private final boolean i;
/*     */ 
/*     */ 
/*     */   
/*     */   r(b paramb, d paramd, ap paramap, boolean paramBoolean1, ac paramac, boolean paramBoolean2) {
/*  76 */     super(paramb, paramd, paramap, paramBoolean1);
/*  77 */     this.e = paramb;
/*  78 */     this.g = paramd;
/*  79 */     this.f = paramac;
/*  80 */     this.i = paramBoolean2;
/*     */ 
/*     */     
/*  83 */     paramd.a(j.dE, (b)j.dO);
/*  84 */     paramd.a(j.v, this.b.g());
/*  85 */     paramd.a(j.aR, paramBoolean2 ? (b)j.bD : (b)j.bC);
/*     */ 
/*     */     
/*  88 */     this.h = d();
/*     */     org.a.c.b.a a1;
/*  90 */     (a1 = new org.a.c.b.a()).a((b)this.h);
/*  91 */     paramd.a(j.aw, (b)a1);
/*     */     
/*  93 */     if (!paramBoolean1)
/*     */     {
/*     */       
/*  96 */       a((Map<Integer, Integer>)null);
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
/*     */   protected final void a(InputStream paramInputStream, String paramString, Map<Integer, Integer> paramMap) {
/* 108 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
/* 109 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<Integer, ?> entry;
/* 111 */       int j = ((Integer)(entry = iterator.next()).getKey()).intValue();
/* 112 */       int i = ((Integer)entry.getValue()).intValue();
/* 113 */       hashMap.put(Integer.valueOf(i), Integer.valueOf(j));
/*     */     } 
/*     */     
/* 116 */     a(paramMap);
/*     */     
/* 118 */     if (this.i)
/*     */     {
/* 120 */       e((Map)hashMap);
/*     */     }
/*     */     
/* 123 */     a(paramInputStream);
/* 124 */     a(paramString);
/* 125 */     d((Map)hashMap);
/* 126 */     b((Map)hashMap);
/* 127 */     c((Map)hashMap);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Map<Integer, Integer> paramMap) {
/* 132 */     ai ai = new ai();
/* 133 */     boolean bool = false; byte b1; int i;
/* 134 */     for (b1 = 1, i = this.a.m().n(); b1 <= i; b1++) {
/*     */       byte b2;
/*     */ 
/*     */       
/* 138 */       if (paramMap != null) {
/*     */         
/* 140 */         if (paramMap.containsKey(Integer.valueOf(b1))) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 146 */           b2 = ((Integer)paramMap.get(Integer.valueOf(b1))).intValue();
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       } else {
/* 151 */         b2 = b1;
/*     */       } 
/*     */       
/*     */       List<Integer> list;
/*     */       
/* 156 */       if ((list = this.c.b(b2)) != null) {
/*     */         int j;
/*     */ 
/*     */         
/* 160 */         if ((j = ((Integer)list.get(0)).intValue()) > 65535)
/*     */         {
/* 162 */           bool = true;
/*     */         }
/* 164 */         ai.a(b2, new String(new int[] { j }, 0, 1));
/*     */       } 
/*     */       continue;
/*     */     } 
/* 168 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 169 */     ai.a(byteArrayOutputStream);
/* 170 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*     */     
/* 172 */     i i1 = new i(this.e, byteArrayInputStream, j.bc);
/*     */ 
/*     */     
/* 175 */     if (bool) {
/*     */       float f;
/*     */       
/* 178 */       if ((f = this.e.i()) < 1.5D)
/*     */       {
/* 180 */         this.e.a(1.5F);
/*     */       }
/*     */     } 
/*     */     
/* 184 */     this.g.a(j.dJ, (c)i1);
/*     */   }
/*     */ 
/*     */   
/*     */   private static d a(String paramString1, String paramString2, int paramInt) {
/*     */     d d1;
/* 190 */     (d1 = new d()).b(j.de, paramString1);
/* 191 */     d1.b(j.cD, paramString2);
/* 192 */     d1.a(j.dF, 0);
/* 193 */     return d1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d d() {
/*     */     d d1;
/* 201 */     (d1 = new d()).a(j.dN, (b)j.be);
/* 202 */     d1.a(j.dE, (b)j.W);
/*     */ 
/*     */     
/* 205 */     d1.a(j.v, this.b.g());
/*     */ 
/*     */     
/* 208 */     d d2 = a("Adobe", "Identity", 0);
/* 209 */     d1.a(j.Z, (b)d2);
/*     */ 
/*     */     
/* 212 */     d1.a(j.bg, (b)this.b.e());
/*     */ 
/*     */     
/* 215 */     b(d1);
/*     */ 
/*     */     
/* 218 */     if (this.i)
/*     */     {
/* 220 */       c(d1);
/*     */     }
/*     */ 
/*     */     
/* 224 */     d1.a(j.X, (b)j.bB);
/*     */     
/* 226 */     return d1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(String paramString) {
/* 231 */     String str = this.b.g();
/* 232 */     paramString = paramString + str;
/*     */     
/* 234 */     this.g.a(j.v, paramString);
/* 235 */     this.b.a(paramString);
/* 236 */     this.h.a(j.v, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(Map<Integer, Integer> paramMap) {
/* 241 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 242 */     int i = ((Integer)Collections.<Integer>max(paramMap.keySet())).intValue();
/* 243 */     for (byte b1 = 0; b1 <= i; b1++) {
/*     */       boolean bool;
/*     */       
/* 246 */       if (paramMap.containsKey(Integer.valueOf(b1))) {
/*     */         
/* 248 */         bool = ((Integer)paramMap.get(Integer.valueOf(b1))).intValue();
/*     */       }
/*     */       else {
/*     */         
/* 252 */         bool = false;
/*     */       } 
/* 254 */       byteArrayOutputStream.write(new byte[] { (byte)(bool >> 8), (byte)bool });
/*     */     } 
/*     */     
/* 257 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 258 */     i i1 = new i(this.e, byteArrayInputStream, j.bc);
/*     */     
/* 260 */     this.h.a(j.X, (c)i1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Map<Integer, Integer> paramMap) {
/*     */     int i;
/* 270 */     byte[] arrayOfByte = new byte[(i = ((Integer)Collections.<Integer>max(paramMap.keySet())).intValue()) / 8 + 1];
/* 271 */     for (byte b1 = 0; b1 <= i; b1++) {
/*     */       
/* 273 */       int j = 1 << 7 - b1 % 8;
/* 274 */       arrayOfByte[b1 / 8] = (byte)(arrayOfByte[b1 / 8] | j);
/*     */     } 
/*     */     
/* 277 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/* 278 */     i i1 = new i(this.e, byteArrayInputStream, j.bc);
/*     */     
/* 280 */     this.b.b(i1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(Map<Integer, Integer> paramMap) {
/* 288 */     float f = 1000.0F / this.a.n().k();
/*     */     
/* 290 */     org.a.c.b.a a1 = new org.a.c.b.a();
/* 291 */     org.a.c.b.a a2 = new org.a.c.b.a();
/* 292 */     int i = Integer.MIN_VALUE;
/*     */     
/*     */     TreeSet<?> treeSet;
/* 295 */     for (Iterator<?> iterator = (treeSet = new TreeSet(paramMap.keySet())).iterator(); iterator.hasNext(); ) { int j = ((Integer)iterator.next()).intValue();
/*     */       
/* 297 */       int k = ((Integer)paramMap.get(Integer.valueOf(j))).intValue();
/*     */       long l;
/* 299 */       if ((l = Math.round(this.a.p().a(k) * f)) != 1000L) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 305 */         if (i != j - 1) {
/*     */           
/* 307 */           a2 = new org.a.c.b.a();
/* 308 */           a1.a((b)i.a(j));
/* 309 */           a1.a((b)a2);
/*     */         } 
/* 311 */         a2.a((b)i.a(l));
/* 312 */         i = j;
/*     */       }  }
/* 314 */      this.h.a(j.dX, (b)a1);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(d paramd) {
/*     */     aq aq;
/* 320 */     if ((aq = this.a.s()) == null)
/*     */     {
/*     */       
/* 323 */       return false;
/*     */     }
/*     */     
/* 326 */     float f = 1000.0F / this.a.n().k();
/*     */     
/* 328 */     long l1 = Math.round(aq.b() * f);
/* 329 */     long l2 = Math.round(-aq.a() * f);
/* 330 */     if (l1 != 880L || l2 != -1000L) {
/*     */       org.a.c.b.a a1;
/*     */       
/* 333 */       (a1 = new org.a.c.b.a()).a((b)i.a(l1));
/* 334 */       a1.a((b)i.a(l2));
/* 335 */       paramd.a(j.aN, (b)a1);
/*     */     } 
/* 337 */     return true;
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
/*     */   private void e(Map<Integer, Integer> paramMap) {
/* 349 */     if (!a(this.h)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 354 */     float f = 1000.0F / this.a.n().k();
/*     */     
/* 356 */     aq aq = this.a.s();
/* 357 */     ar ar = this.a.t();
/* 358 */     p p = this.a.e();
/* 359 */     s s = this.a.p();
/*     */     
/* 361 */     long l1 = Math.round(aq.b() * f);
/* 362 */     long l2 = Math.round(-aq.a() * f);
/*     */     
/* 364 */     org.a.c.b.a a1 = new org.a.c.b.a();
/* 365 */     org.a.c.b.a a2 = new org.a.c.b.a();
/* 366 */     int i = Integer.MIN_VALUE;
/*     */     
/*     */     TreeSet<?> treeSet;
/* 369 */     for (Iterator<?> iterator = (treeSet = new TreeSet(paramMap.keySet())).iterator(); iterator.hasNext(); ) { int j = ((Integer)iterator.next()).intValue();
/*     */ 
/*     */       
/*     */       k k;
/*     */       
/* 374 */       if ((k = p.a(j)) != null) {
/*     */ 
/*     */ 
/*     */         
/* 378 */         long l3 = Math.round((k.c() + ar.a(j)) * f);
/* 379 */         long l4 = Math.round(-ar.b(j) * f);
/* 380 */         if (l3 != l1 || l4 != l2)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */           
/* 386 */           if (i != j - 1) {
/*     */             
/* 388 */             a2 = new org.a.c.b.a();
/* 389 */             a1.a((b)i.a(j));
/* 390 */             a1.a((b)a2);
/*     */           } 
/* 392 */           a2.a((b)i.a(l4));
/* 393 */           long l = Math.round(s.a(j) * f);
/* 394 */           a2.a((b)i.a(l / 2L));
/* 395 */           a2.a((b)i.a(l3));
/* 396 */           i = j; } 
/*     */       }  }
/* 398 */      this.h.a(j.dY, (b)a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(d paramd) {
/* 407 */     int i, arrayOfInt[] = new int[(i = this.a.w()) << 1];
/* 408 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       
/* 410 */       arrayOfInt[b1 << 1] = b1;
/* 411 */       arrayOfInt[(b1 << 1) + 1] = this.a.p().a(b1);
/*     */     } 
/*     */     
/* 414 */     paramd.a(j.dX, (b)a(arrayOfInt));
/*     */   }
/*     */   
/*     */   enum a
/*     */   {
/* 419 */     a, b, c;
/*     */   }
/*     */ 
/*     */   
/*     */   private org.a.c.b.a a(int[] paramArrayOfint) {
/* 424 */     if (paramArrayOfint.length == 0)
/*     */     {
/* 426 */       throw new IllegalArgumentException("length of widths must be > 0");
/*     */     }
/*     */     
/* 429 */     float f = 1000.0F / this.a.n().k();
/*     */     
/* 431 */     long l1 = paramArrayOfint[0];
/* 432 */     long l2 = Math.round(paramArrayOfint[1] * f);
/*     */     
/* 434 */     org.a.c.b.a a1 = new org.a.c.b.a();
/*     */     org.a.c.b.a a2;
/* 436 */     (a2 = new org.a.c.b.a()).a((b)i.a(l1));
/*     */     
/* 438 */     a a3 = a.a;
/*     */     
/* 440 */     for (byte b1 = 2; b1 < paramArrayOfint.length; b1 += 2) {
/*     */       
/* 442 */       long l3 = paramArrayOfint[b1];
/* 443 */       long l4 = Math.round(paramArrayOfint[b1 + 1] * f);
/*     */       
/* 445 */       switch (s.a[a3.ordinal()]) {
/*     */         
/*     */         case 1:
/* 448 */           if (l3 == l1 + 1L && l4 == l2) {
/*     */             
/* 450 */             a3 = a.c; break;
/*     */           } 
/* 452 */           if (l3 == l1 + 1L) {
/*     */             
/* 454 */             a3 = a.b;
/*     */             
/* 456 */             (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 461 */           (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/* 462 */           a2.a((b)a1);
/* 463 */           a2.a((b)i.a(l3));
/*     */           break;
/*     */         
/*     */         case 2:
/* 467 */           if (l3 == l1 + 1L && l4 == l2) {
/*     */             
/* 469 */             a3 = a.c;
/* 470 */             a2.a((b)a1);
/* 471 */             a2.a((b)i.a(l1)); break;
/*     */           } 
/* 473 */           if (l3 == l1 + 1L) {
/*     */             
/* 475 */             a1.a((b)i.a(l2));
/*     */             
/*     */             break;
/*     */           } 
/* 479 */           a3 = a.a;
/* 480 */           a1.a((b)i.a(l2));
/* 481 */           a2.a((b)a1);
/* 482 */           a2.a((b)i.a(l3));
/*     */           break;
/*     */         
/*     */         case 3:
/* 486 */           if (l3 != l1 + 1L || l4 != l2) {
/*     */             
/* 488 */             a2.a((b)i.a(l1));
/* 489 */             a2.a((b)i.a(l2));
/* 490 */             a2.a((b)i.a(l3));
/* 491 */             a3 = a.a;
/*     */           } 
/*     */           break;
/*     */       } 
/* 495 */       l2 = l4;
/* 496 */       l1 = l3;
/*     */     } 
/*     */     
/* 499 */     switch (s.a[a3.ordinal()]) {
/*     */ 
/*     */       
/*     */       case 1:
/* 503 */         (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/* 504 */         a2.a((b)a1);
/*     */         break;
/*     */       case 2:
/* 507 */         a1.a((b)i.a(l2));
/* 508 */         a2.a((b)a1);
/*     */         break;
/*     */       case 3:
/* 511 */         a2.a((b)i.a(l1));
/* 512 */         a2.a((b)i.a(l2));
/*     */         break;
/*     */     } 
/* 515 */     return a2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(d paramd) {
/* 523 */     if (!a(paramd)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 529 */     int i, arrayOfInt[] = new int[(i = this.a.w()) << 2];
/* 530 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       k k;
/*     */       
/* 533 */       if ((k = this.a.e().a(b1)) == null) {
/*     */         
/* 535 */         arrayOfInt[b1 << 2] = Integer.MIN_VALUE;
/*     */       }
/*     */       else {
/*     */         
/* 539 */         arrayOfInt[b1 << 2] = b1;
/* 540 */         arrayOfInt[(b1 << 2) + 1] = this.a.t().b(b1);
/* 541 */         arrayOfInt[(b1 << 2) + 2] = this.a.p().a(b1);
/* 542 */         arrayOfInt[(b1 << 2) + 3] = k.c() + this.a.t().a(b1);
/*     */       } 
/*     */     } 
/*     */     
/* 546 */     paramd.a(j.dY, (b)b(arrayOfInt));
/*     */   }
/*     */ 
/*     */   
/*     */   private org.a.c.b.a b(int[] paramArrayOfint) {
/* 551 */     if (paramArrayOfint.length == 0)
/*     */     {
/* 553 */       throw new IllegalArgumentException("length of values must be > 0");
/*     */     }
/*     */     
/* 556 */     float f = 1000.0F / this.a.n().k();
/*     */     
/* 558 */     long l1 = paramArrayOfint[0];
/* 559 */     long l2 = Math.round(-paramArrayOfint[1] * f);
/* 560 */     long l3 = Math.round(paramArrayOfint[2] * f / 2.0F);
/* 561 */     long l4 = Math.round(paramArrayOfint[3] * f);
/*     */     
/* 563 */     org.a.c.b.a a1 = new org.a.c.b.a();
/*     */     org.a.c.b.a a2;
/* 565 */     (a2 = new org.a.c.b.a()).a((b)i.a(l1));
/*     */     
/* 567 */     a a3 = a.a;
/*     */     
/* 569 */     for (byte b1 = 4; b1 < paramArrayOfint.length; b1 += 4) {
/*     */       long l;
/*     */       
/* 572 */       if ((l = paramArrayOfint[b1]) != -2147483648L) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 577 */         long l5 = Math.round(-paramArrayOfint[b1 + 1] * f);
/* 578 */         long l6 = Math.round(paramArrayOfint[b1 + 2] * f / 2.0F);
/* 579 */         long l7 = Math.round(paramArrayOfint[b1 + 3] * f);
/*     */         
/* 581 */         switch (s.a[a3.ordinal()]) {
/*     */           
/*     */           case 1:
/* 584 */             if (l == l1 + 1L && l5 == l2 && l6 == l3 && l7 == l4) {
/*     */               
/* 586 */               a3 = a.c; break;
/*     */             } 
/* 588 */             if (l == l1 + 1L) {
/*     */               
/* 590 */               a3 = a.b;
/*     */               
/* 592 */               (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/* 593 */               a1.a((b)i.a(l3));
/* 594 */               a1.a((b)i.a(l4));
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 599 */             (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/* 600 */             a1.a((b)i.a(l3));
/* 601 */             a1.a((b)i.a(l4));
/* 602 */             a2.a((b)a1);
/* 603 */             a2.a((b)i.a(l));
/*     */             break;
/*     */           
/*     */           case 2:
/* 607 */             if (l == l1 + 1L && l5 == l2 && l6 == l3 && l7 == l4) {
/*     */               
/* 609 */               a3 = a.c;
/* 610 */               a2.a((b)a1);
/* 611 */               a2.a((b)i.a(l1)); break;
/*     */             } 
/* 613 */             if (l == l1 + 1L) {
/*     */               
/* 615 */               a1.a((b)i.a(l2));
/* 616 */               a1.a((b)i.a(l3));
/* 617 */               a1.a((b)i.a(l4));
/*     */               
/*     */               break;
/*     */             } 
/* 621 */             a3 = a.a;
/* 622 */             a1.a((b)i.a(l2));
/* 623 */             a1.a((b)i.a(l3));
/* 624 */             a1.a((b)i.a(l4));
/* 625 */             a2.a((b)a1);
/* 626 */             a2.a((b)i.a(l));
/*     */             break;
/*     */           
/*     */           case 3:
/* 630 */             if (l != l1 + 1L || l5 != l2 || l6 != l3 || l7 != l4) {
/*     */               
/* 632 */               a2.a((b)i.a(l1));
/* 633 */               a2.a((b)i.a(l2));
/* 634 */               a2.a((b)i.a(l3));
/* 635 */               a2.a((b)i.a(l4));
/* 636 */               a2.a((b)i.a(l));
/* 637 */               a3 = a.a;
/*     */             } 
/*     */             break;
/*     */         } 
/* 641 */         l2 = l5;
/* 642 */         l3 = l6;
/* 643 */         l4 = l7;
/* 644 */         l1 = l;
/*     */       } 
/*     */     } 
/* 647 */     switch (s.a[a3.ordinal()]) {
/*     */ 
/*     */       
/*     */       case 1:
/* 651 */         (a1 = new org.a.c.b.a()).a((b)i.a(l2));
/* 652 */         a1.a((b)i.a(l3));
/* 653 */         a1.a((b)i.a(l4));
/* 654 */         a2.a((b)a1);
/*     */         break;
/*     */       case 2:
/* 657 */         a1.a((b)i.a(l2));
/* 658 */         a1.a((b)i.a(l3));
/* 659 */         a1.a((b)i.a(l4));
/* 660 */         a2.a((b)a1);
/*     */         break;
/*     */       case 3:
/* 663 */         a2.a((b)i.a(l1));
/* 664 */         a2.a((b)i.a(l2));
/* 665 */         a2.a((b)i.a(l3));
/* 666 */         a2.a((b)i.a(l4));
/*     */         break;
/*     */     } 
/* 669 */     return a2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o a() {
/* 677 */     return new q(this.h, this.f, this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */