/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.d.q;
/*     */ import com.d.e.v;
/*     */ import com.d.i.b.b;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class aa
/*     */ {
/*  52 */   private static final e[] a = new e[] { new i(), new j(), new k(), new d(), new h(), new a(), new b(), new c() };
/*     */ 
/*     */ 
/*     */   
/*     */   private com.d.c.f.c b;
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */   
/*     */   private int f;
/*     */ 
/*     */   
/*     */   private int g;
/*     */ 
/*     */   
/*     */   private int h;
/*     */ 
/*     */   
/*     */   private g i;
/*     */ 
/*     */   
/*     */   private com.d.c.c.e j;
/*     */ 
/*     */   
/*  83 */   private f[] k = new f[a.length];
/*     */   
/*     */   private int l;
/*     */   
/*     */   private f m;
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/*  91 */     this.l = paramInt;
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
/*     */   public final int a(com.d.c.f.d paramd) {
/* 107 */     h(paramd);
/*     */     
/* 109 */     return this.i.b();
/*     */   }
/*     */   
/*     */   public final int b(com.d.c.f.d paramd) {
/* 113 */     h(paramd);
/*     */     
/* 115 */     return this.i.a();
/*     */   }
/*     */   
/*     */   private void h(com.d.c.f.d paramd) {
/* 119 */     if (this.i == null) {
/*     */       int i, j;
/*     */ 
/*     */       
/*     */       com.d.c.f.c c1;
/*     */       
/* 125 */       if ((c1 = l()).g(com.d.c.a.a.p)) {
/* 126 */         j = (int)c1.a(com.d.c.a.a.p, 0.0F, paramd);
/*     */       } else {
/*     */         
/* 129 */         j = i(paramd);
/*     */       } 
/*     */       
/* 132 */       if (c1.g(com.d.c.a.a.q)) {
/* 133 */         i = (int)c1.a(com.d.c.a.a.q, 0.0F, paramd);
/*     */       } else {
/*     */         
/* 136 */         i = j(i);
/*     */       } 
/*     */       
/* 139 */       if (c1.a(com.d.c.a.a.t, com.d.c.a.c.Z)) {
/*     */ 
/*     */         
/* 142 */         int k = j;
/* 143 */         j = i;
/* 144 */         i = k;
/*     */       } 
/*     */       
/*     */       g g1;
/* 148 */       (g1 = new g((byte)0)).b(j);
/* 149 */       g1.a(i);
/*     */       
/* 151 */       this.i = g1;
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
/*     */   private int i(com.d.c.f.d paramd) {
/* 164 */     if (com.d.m.i.a().a().u() != null) {
/* 165 */       float f1 = com.d.m.i.a().a().u().floatValue();
/* 166 */       boolean bool = com.d.m.i.a().a().w();
/* 167 */       return (int)com.d.c.f.a.e.a(l(), com.d.c.a.a.p, 
/* 168 */           String.valueOf(f1), f1, bool ? 8 : 7, 0.0F, paramd);
/*     */     } 
/*     */     
/* 171 */     return (int)com.d.c.f.a.e.a(
/* 172 */         l(), com.d.c.a.a.p, "210mm", 210.0F, (short)7, 0.0F, paramd);
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
/*     */   private int j(com.d.c.f.d paramd) {
/* 188 */     if (com.d.m.i.a().a().v() != null) {
/* 189 */       float f1 = com.d.m.i.a().a().v().floatValue();
/* 190 */       boolean bool = com.d.m.i.a().a().w();
/* 191 */       return (int)com.d.c.f.a.e.a(l(), com.d.c.a.a.p, 
/* 192 */           String.valueOf(f1), f1, bool ? 8 : 7, 0.0F, paramd);
/*     */     } 
/*     */     
/* 195 */     return (int)com.d.c.f.a.e.a(
/* 196 */         l(), com.d.c.a.a.q, "297mm", 297.0F, (short)7, 0.0F, paramd);
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
/*     */   public final int c(com.d.c.f.d paramd) {
/*     */     int i;
/* 209 */     if ((i = b(paramd) - d(paramd, 3) - d(paramd, 4)) <= 0) {
/* 210 */       throw new IllegalArgumentException("The content height cannot be zero or less.  Check your document margin definition.");
/*     */     }
/*     */     
/* 213 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int d(com.d.c.f.d paramd) {
/*     */     int i;
/* 219 */     if ((i = a(paramd) - d(paramd, 1) - d(paramd, 2)) <= 0) {
/* 220 */       throw new IllegalArgumentException("The content width cannot be zero or less.  Check your document margin definition.");
/*     */     }
/*     */     
/* 223 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private com.d.c.f.c l() {
/* 228 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(com.d.c.f.c paramc) {
/* 232 */     this.b = paramc;
/*     */   }
/*     */   
/*     */   public final int a() {
/* 236 */     return this.d;
/*     */   }
/*     */   
/*     */   public final int b() {
/* 240 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(com.d.c.f.d paramd, int paramInt) {
/* 244 */     this.c = paramInt;
/* 245 */     this.d = paramInt + c(paramd);
/*     */   }
/*     */   
/*     */   public final int c() {
/* 249 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 253 */     this.f = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d() {
/* 263 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 267 */     this.e = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Rectangle k(com.d.c.f.d paramd) {
/* 277 */     return new Rectangle(0, 0, 
/*     */         
/* 279 */         a(paramd), b(paramd));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Rectangle e(com.d.c.f.d paramd) {
/* 288 */     return new Rectangle(0, 
/*     */         
/* 290 */         d(), 
/* 291 */         d(paramd), 
/* 292 */         c(paramd));
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
/*     */   public final Rectangle b(com.d.c.f.d paramd, int paramInt) {
/* 304 */     return new Rectangle(
/* 305 */         d(paramd) * (paramInt + 1) * ((g() == com.d.c.a.c.ak) ? 1 : -1), 
/* 306 */         d(), 
/* 307 */         d(paramd), 
/* 308 */         c(paramd));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c(com.d.c.f.d paramd, int paramInt) {
/* 318 */     com.d.c.a.c c1 = g();
/* 319 */     float f2 = paramInt;
/*     */     
/*     */     float f1;
/* 322 */     if ((f1 = d(paramd)) == 0.0F) {
/* 323 */       return 0;
/*     */     }
/*     */     
/* 326 */     if (c1 == com.d.c.a.c.ak) {
/* 327 */       return (int)((paramInt > 0) ? (Math.ceil((f2 / f1)) - 1.0D) : 0.0D);
/*     */     }
/*     */     
/* 330 */     return (int)((paramInt < 0) ? Math.ceil((Math.abs(f2) / f1)) : 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 337 */     return (f() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/* 344 */     return l().aa();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final com.d.c.a.c g() {
/* 352 */     return l().e(com.d.c.a.a.bd);
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
/*     */   public final Rectangle f(com.d.c.f.d paramd) {
/*     */     Rectangle rectangle;
/* 374 */     (rectangle = new Rectangle(d(paramd, 1), d(paramd, 3), d(paramd), c(paramd))).height--;
/*     */     
/* 376 */     return rectangle;
/*     */   }
/*     */   
/*     */   public final com.d.c.f.a.h g(com.d.c.f.d paramd) {
/* 380 */     return l().a(this.h, paramd);
/*     */   }
/*     */   
/*     */   private Rectangle a(int paramInt1, int paramInt2, com.d.c.f.d paramd) {
/* 384 */     com.d.c.f.a.h h = g(paramd);
/*     */ 
/*     */     
/*     */     Rectangle rectangle;
/*     */     
/* 389 */     return rectangle = new Rectangle(paramInt1 + (int)h.w(), paramInt2 + (int)h.t(), a(paramd) - (int)h.w() - (int)h.u(), b(paramd) - (int)h.t() - (int)h.v());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, int paramInt, short paramShort) {
/* 397 */     paramab.p().a(paramab, 
/* 398 */         l(), 
/* 399 */         a(0, 0, paramab), 15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(ab paramab, int paramInt, short paramShort) {
/* 408 */     Rectangle rectangle = k(paramab);
/*     */ 
/*     */     
/* 411 */     paramab.p().a(paramab, l(), rectangle, rectangle, l().a(paramab));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void c(ab paramab, int paramInt, short paramShort) {
/* 416 */     for (paramInt = 0; paramInt < a.length; paramInt++) {
/*     */       f f1;
/*     */       
/* 419 */       if ((f1 = this.k[paramInt]) != null) {
/* 420 */         this.m = f1;
/* 421 */         com.d.f.d d = this.k[paramInt].b();
/* 422 */         Point point = f1.a().a(paramab, this, 0, (short)2);
/*     */ 
/*     */         
/* 425 */         paramab.p().a(point.x, point.y);
/* 426 */         if (paramab.p().i()) {
/* 427 */           d.Z().a(paramab);
/* 428 */           b b = new b(point.x, point.y);
/* 429 */           Object object = paramab.p().a(q.b, (f)d);
/* 430 */           b.a(paramab, d.Z());
/* 431 */           paramab.p().a(object);
/*     */         } else {
/* 433 */           d.Z().a(paramab);
/*     */         } 
/* 435 */         paramab.p().a(-point.x, -point.y);
/*     */       } 
/*     */     } 
/* 438 */     this.m = null;
/*     */   }
/*     */   
/*     */   public final com.d.c.a.d[] h() {
/* 442 */     if (this.m == null)
/* 443 */       return null; 
/* 444 */     return this.m.a().b();
/*     */   }
/*     */   
/*     */   public final int i() {
/* 448 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void d(int paramInt) {
/* 452 */     this.g = paramInt;
/*     */   }
/*     */   
/*     */   private int m() {
/* 456 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void e(int paramInt) {
/* 460 */     this.h = paramInt;
/*     */   }
/*     */   
/*     */   public final int d(com.d.c.f.d paramd, int paramInt) {
/* 464 */     return l().a(paramd, 
/* 465 */         m(), paramInt);
/*     */   }
/*     */   
/*     */   private com.d.c.c.e n() {
/* 469 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void a(com.d.c.c.e parame) {
/* 473 */     this.j = parame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(v paramv) {
/* 481 */     paramv.a(this);
/* 482 */     b(paramv);
/* 483 */     c(paramv);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(v paramv) {
/*     */     List list;
/* 490 */     if ((list = n().b()) != null && list.size() > 0)
/*     */     {
/* 492 */       for (Iterator<v> iterator = list.iterator(); iterator.hasNext();) {
/*     */         
/* 494 */         if ((v1 = iterator.next()).d() == com.d.c.a.a.C) {
/*     */           List<?> list1;
/*     */           com.d.c.d.j j;
/* 497 */           if ((list1 = (j = (com.d.c.d.j)v1.e()).l()).size() == 1) {
/*     */             c c1; com.d.c.d.j j1; e e1;
/* 499 */             if ((j1 = (com.d.c.d.j)list1.get(0)).i() == 7 && 
/*     */               
/* 501 */               com.d.e.c.a(e1 = j1.n()) && (
/*     */               
/* 503 */               c1 = com.d.e.c.a(paramv, j1)) != null) {
/* 504 */               c1.ai();
/*     */             }
/*     */             return;
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(v paramv) {
/* 516 */     com.d.c.f.a.h h = g((com.d.c.f.d)paramv);
/* 517 */     for (byte b = 0; b < a.length; b++) {
/*     */       e e1;
/*     */       
/* 520 */       Dimension dimension = (e1 = a[b]).a((com.d.c.f.d)paramv, this, h);
/*     */ 
/*     */       
/*     */       com.d.f.d d;
/*     */ 
/*     */       
/* 526 */       if ((d = com.d.e.c.a(paramv, this.j, e1.b(), (int)dimension.getHeight(), e1.a())) != null) {
/* 527 */         d.g(new w(new Rectangle((int)dimension.getWidth(), (int)dimension.getHeight())));
/*     */         try {
/* 529 */           paramv.c(1);
/*     */           
/* 531 */           paramv.a(false);
/* 532 */           paramv.a((f)d);
/* 533 */           paramv.p().b((com.d.c.f.d)paramv);
/*     */           
/* 535 */           d.b(paramv);
/*     */           
/* 537 */           paramv.n();
/*     */         } finally {
/* 539 */           paramv.c(0);
/*     */         } 
/* 541 */         this.k[b] = new f(e1, d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean j() {
/* 547 */     return (this.g % 2 != 0);
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 551 */     return (this.g % 2 == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class g
/*     */   {
/*     */     private int a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private g() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a() {
/* 577 */       return this.b;
/*     */     }
/*     */     
/*     */     public final void a(int param1Int) {
/* 581 */       this.b = param1Int;
/*     */     }
/*     */     
/*     */     public final int b() {
/* 585 */       return this.a;
/*     */     }
/*     */     
/*     */     public final void b(int param1Int) {
/* 589 */       this.a = param1Int;
/*     */     }
/*     */   }
/*     */   
/*     */   static class f {
/*     */     private final aa.e a;
/*     */     private final com.d.f.d b;
/*     */     
/*     */     public f(aa.e param1e, com.d.f.d param1d) {
/* 598 */       this.a = param1e;
/* 599 */       this.b = param1d;
/*     */     }
/*     */     
/*     */     public final aa.e a() {
/* 603 */       return this.a;
/*     */     }
/*     */     
/*     */     public final com.d.f.d b() {
/* 607 */       return this.b;
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class e
/*     */   {
/*     */     private final com.d.c.a.d[] a;
/*     */     
/*     */     public abstract Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h);
/*     */     
/*     */     public abstract Point a(ab param1ab, aa param1aa, int param1Int, short param1Short);
/*     */     
/*     */     public e(com.d.c.a.d param1d) {
/* 620 */       this.a = new com.d.c.a.d[] { param1d };
/*     */     }
/*     */     
/*     */     public e(com.d.c.a.d[] param1ArrayOfd) {
/* 624 */       this.a = param1ArrayOfd;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final com.d.c.a.d[] b() {
/* 636 */       return this.a;
/*     */     }
/*     */     
/*     */     public int a() {
/* 640 */       return 2;
/*     */     }
/*     */   }
/*     */   
/*     */   static class i extends e {
/*     */     public i() {
/* 646 */       super(com.d.c.a.d.a);
/*     */     }
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 650 */       return new Dimension((int)param1h.w(), (int)param1h.t());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       boolean bool;
/* 655 */       int j = param1Int;
/*     */       
/* 657 */       if (param1Short == 1) {
/* 658 */         bool = param1aa.d();
/* 659 */       } else if (param1Short == 2) {
/* 660 */         bool = false;
/*     */       } else {
/* 662 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 665 */       return new Point(j, bool);
/*     */     }
/*     */   }
/*     */   
/*     */   static class k
/*     */     extends e {
/*     */     public k() {
/* 672 */       super(com.d.c.a.d.e);
/*     */     }
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 676 */       return new Dimension((int)param1h.u(), (int)param1h.t());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       boolean bool;
/* 681 */       int i = param1Int + param1aa.a(param1ab) - (int)param1aa.g(param1ab).u();
/*     */       
/* 683 */       if (param1Short == 1) {
/* 684 */         bool = param1aa.d();
/* 685 */       } else if (param1Short == 2) {
/* 686 */         bool = false;
/*     */       } else {
/* 688 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 691 */       return new Point(i, bool);
/*     */     }
/*     */   }
/*     */   
/*     */   static class c extends e {
/*     */     public c() {
/* 697 */       super(com.d.c.a.d.j);
/*     */     }
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 701 */       return new Dimension((int)param1h.u(), (int)param1h.v());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       int i;
/* 706 */       param1Int = param1Int + param1aa.a(param1ab) - (int)param1aa.g(param1ab).u();
/*     */ 
/*     */       
/* 709 */       if (param1Short == 1) {
/* 710 */         i = param1aa.c() - (int)param1aa.g(param1ab).v();
/* 711 */       } else if (param1Short == 2) {
/* 712 */         i = param1aa.b(i) - (int)param1aa.g(i).v();
/*     */       } else {
/* 714 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 717 */       return new Point(param1Int, i);
/*     */     }
/*     */   }
/*     */   
/*     */   static class a extends e {
/*     */     public a() {
/* 723 */       super(com.d.c.a.d.f);
/*     */     }
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 727 */       return new Dimension((int)param1h.w(), (int)param1h.v());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       int i;
/* 732 */       param1Int = param1Int;
/*     */ 
/*     */       
/* 735 */       if (param1Short == 1) {
/* 736 */         i = param1aa.c() - (int)param1aa.g(param1ab).v();
/* 737 */       } else if (param1Short == 2) {
/* 738 */         i = param1aa.b(i) - (int)param1aa.g(i).v();
/*     */       } else {
/* 740 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 743 */       return new Point(param1Int, i);
/*     */     }
/*     */   }
/*     */   
/*     */   static class d extends e {
/*     */     public d() {
/* 749 */       super(new com.d.c.a.d[] { com.d.c.a.d.k, com.d.c.a.d.l, com.d.c.a.d.m });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 756 */       return new Dimension((int)param1h.w(), param1aa.c(param1d));
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       int i;
/* 761 */       param1Int = param1Int;
/*     */       
/* 763 */       if (param1Short == 1) {
/* 764 */         i = param1aa.d() + (int)param1aa.g(param1ab).t();
/* 765 */       } else if (param1Short == 2) {
/* 766 */         i = (int)param1aa.g(i).t();
/*     */       } else {
/* 768 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 771 */       return new Point(param1Int, i);
/*     */     }
/*     */     
/*     */     public final int a() {
/* 775 */       return 1;
/*     */     }
/*     */   }
/*     */   
/*     */   static class h extends e {
/*     */     public h() {
/* 781 */       super(new com.d.c.a.d[] { com.d.c.a.d.n, com.d.c.a.d.o, com.d.c.a.d.p });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 788 */       return new Dimension((int)param1h.w(), param1aa.c(param1d));
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       int i;
/* 793 */       param1Int = param1Int + param1aa.a(param1ab) - (int)param1aa.g(param1ab).u();
/*     */       
/* 795 */       if (param1Short == 1) {
/* 796 */         i = param1aa.d() + (int)param1aa.g(param1ab).t();
/* 797 */       } else if (param1Short == 2) {
/* 798 */         i = (int)param1aa.g(i).t();
/*     */       } else {
/* 800 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 803 */       return new Point(param1Int, i);
/*     */     }
/*     */     
/*     */     public final int a() {
/* 807 */       return 1;
/*     */     }
/*     */   }
/*     */   
/*     */   static class j extends e {
/*     */     public j() {
/* 813 */       super(new com.d.c.a.d[] { com.d.c.a.d.b, com.d.c.a.d.c, com.d.c.a.d.d });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 820 */       return new Dimension(param1aa.d(param1d), (int)param1h.t());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       boolean bool;
/* 825 */       int i = param1Int + (int)param1aa.g(param1ab).w();
/*     */       
/* 827 */       if (param1Short == 1) {
/* 828 */         bool = param1aa.d();
/* 829 */       } else if (param1Short == 2) {
/* 830 */         bool = false;
/*     */       } else {
/* 832 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 835 */       return new Point(i, bool);
/*     */     }
/*     */   }
/*     */   
/*     */   static class b extends e {
/*     */     public b() {
/* 841 */       super(new com.d.c.a.d[] { com.d.c.a.d.g, com.d.c.a.d.h, com.d.c.a.d.i });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Dimension a(com.d.c.f.d param1d, aa param1aa, com.d.c.f.a.h param1h) {
/* 848 */       return new Dimension(param1aa.d(param1d), (int)param1h.v());
/*     */     }
/*     */     
/*     */     public final Point a(ab param1ab, aa param1aa, int param1Int, short param1Short) {
/*     */       int i;
/* 853 */       param1Int += (int)param1aa.g(param1ab).w();
/*     */ 
/*     */       
/* 856 */       if (param1Short == 1) {
/* 857 */         i = param1aa.c() - (int)param1aa.g(param1ab).v();
/* 858 */       } else if (param1Short == 2) {
/* 859 */         i = param1aa.b(i) - (int)param1aa.g(i).v();
/*     */       } else {
/* 861 */         throw new IllegalArgumentException("Illegal mode");
/*     */       } 
/*     */       
/* 864 */       return new Point(param1Int, i);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */