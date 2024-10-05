/*     */ package com.d.f;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.f.a.a;
/*     */ import com.d.c.f.a.h;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.c.f.i;
/*     */ import com.d.e.k;
/*     */ import com.d.e.v;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.i;
/*     */ import com.d.i.j;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */   extends c
/*     */ {
/*  45 */   public static final f a = new f();
/*     */   
/*     */   private int b;
/*     */   
/*     */   private int c;
/*     */   
/*     */   private d d;
/*     */   
/*     */   private j e;
/*     */   
/*     */   private a f;
/*     */   
/*     */   private a g;
/*     */   private a h;
/*     */   private a i;
/*     */   private a j;
/*     */   private a k;
/*     */   private static final int[] l;
/*     */   
/*     */   static {
/*  65 */     (l = new int[c.a()])[c.z.a] = 1;
/*  66 */     l[c.aQ.a] = 2;
/*  67 */     l[c.u.a] = 3;
/*  68 */     l[c.y.a] = 4;
/*  69 */     l[c.aI.a] = 5;
/*  70 */     l[c.av.a] = 6;
/*  71 */     l[c.O.a] = 7;
/*  72 */     l[c.U.a] = 8;
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
/*     */   public final c c() {
/*     */     f f1;
/*  86 */     (f1 = new f()).a(a());
/*  87 */     f1.a(ai());
/*     */     
/*  89 */     return f1;
/*     */   }
/*     */   
/*     */   public final a b(d paramd) {
/*  93 */     if (f().a().am()) {
/*     */       
/*  95 */       if (this.f == null)
/*  96 */         return a.a;  return this.f;
/*     */     } 
/*  98 */     return super.b(paramd);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void c(d paramd) {
/* 103 */     a a2 = v(paramd);
/* 104 */     a a3 = u(paramd);
/* 105 */     a a4 = w(paramd);
/* 106 */     a a1 = t(paramd);
/*     */     
/* 108 */     this.g = new a(a2, a3, a4, a1);
/*     */ 
/*     */     
/* 111 */     a2.a((a2.c() + 1) / 2);
/* 112 */     a3.a(a3.c() / 2);
/* 113 */     a4.a(a4.c() / 2);
/* 114 */     a1.a((a1.c() + 1) / 2);
/*     */     
/* 116 */     this.f = new a(a2, a3, a4, a1);
/*     */     
/* 118 */     this.h = a2;
/* 119 */     this.i = a3;
/* 120 */     this.j = a4;
/* 121 */     this.k = a1;
/*     */   }
/*     */   
/*     */   public final int d() {
/* 125 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 129 */     this.c = paramInt;
/*     */   }
/*     */   
/*     */   public final int e() {
/* 133 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 137 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public final void b(v paramv) {
/* 141 */     super.b(paramv);
/*     */   }
/*     */ 
/*     */   
/*     */   public final d f() {
/* 146 */     if (this.d == null) {
/* 147 */       this.d = (d)U().U().U();
/*     */     }
/* 149 */     return this.d;
/*     */   }
/*     */   
/*     */   protected final j g() {
/* 153 */     if (this.e == null) {
/* 154 */       this.e = (j)U().U();
/*     */     }
/* 156 */     return this.e;
/*     */   }
/*     */   
/*     */   public final i e(d paramd) {
/*     */     i i;
/* 161 */     if ((i = a().a(paramd, a.ax)).c() || i.e()) {
/* 162 */       return i;
/*     */     }
/*     */ 
/*     */     
/* 166 */     a a1 = b(paramd);
/* 167 */     int k = 0 + (int)a1.w() + (int)a1.u();
/*     */     
/* 169 */     h h = o(paramd);
/* 170 */     k += (int)h.w() + (int)h.u();
/*     */     
/* 172 */     i.a(i.a() + k);
/*     */     
/* 174 */     return i;
/*     */   }
/*     */   
/*     */   public final i f(d paramd) {
/* 178 */     i i = e(paramd);
/* 179 */     if (a().ao() > 1 || !i.c()) {
/* 180 */       return i;
/*     */     }
/*     */     h h;
/* 183 */     if ((h = f().e(d())) != null)
/*     */     {
/* 185 */       i = h.a().a(paramd, a.ax);
/*     */     }
/* 187 */     return i;
/*     */   }
/*     */   
/*     */   public final void b(v paramv, int paramInt) {
/* 191 */     k(paramv);
/*     */     
/* 193 */     u(paramInt - ar() - aq());
/*     */   }
/*     */   
/*     */   public final boolean b_() {
/* 197 */     return (a().J() || !a().d(a.R));
/*     */   }
/*     */   
/*     */   public final int d(v paramv) {
/*     */     int i;
/* 202 */     if ((i = super.d(paramv)) != Integer.MIN_VALUE) {
/* 203 */       return i;
/*     */     }
/*     */     Rectangle rectangle;
/* 206 */     return (int)(rectangle = c(ab(), aa(), (d)paramv)).getY();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int e(v paramv) {
/* 211 */     return super.d(paramv);
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 215 */     for (byte b = 0; b < V(); b++) {
/*     */       com.d.i.f f1;
/* 217 */       (f1 = k(b)).o(f1.an() + paramInt);
/*     */     } 
/*     */     
/* 220 */     x().a().a(new g(this, paramInt));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     C();
/*     */   }
/*     */   
/*     */   public final boolean c(v paramv, int paramInt) {
/* 231 */     if (!paramv.D()) {
/* 232 */       return false;
/*     */     }
/*     */     
/* 235 */     aa aa = paramv.p().a((d)paramv, (com.d.i.f)this);
/*     */     
/* 237 */     int i = aa() + M();
/*     */     
/* 239 */     if (aa != null && (i >= aa.a() - paramv.z() || i + paramInt >= aa
/* 240 */       .a() - paramv.z())) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final c j() {
/*     */     c c1;
/* 246 */     if ((c1 = a().e(a.as)) == c.bi || c1 == c.al || c1 == c.l) {
/* 247 */       return c1;
/*     */     }
/* 249 */     return c.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ay() {
/*     */     boolean bool;
/* 258 */     if ((bool = a().ap()) || F() != 4) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void b(ab paramab) {
/* 263 */     if (ay() && a().a(paramab, (com.d.i.f)this)) {
/*     */       Rectangle rectangle;
/* 265 */       if (paramab.o() && f().a().as()) {
/* 266 */         rectangle = d(paramab);
/*     */       } else {
/* 268 */         rectangle = j((d)paramab);
/*     */       } 
/*     */       
/* 271 */       if (rectangle != null) {
/* 272 */         a(paramab, rectangle);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, Rectangle paramRectangle) {
/* 280 */     a a2 = a().a((d)paramab);
/*     */     h h;
/* 282 */     if ((h = f().e(d())) != null) {
/* 283 */       paramab.p().a(paramab, h
/* 284 */           .a(), paramRectangle, 
/* 285 */           f().a((d)paramab, d()), a2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 290 */     com.d.i.f f2, f1 = (f2 = U()).U();
/*     */     
/* 292 */     c c1 = f().a();
/*     */     
/* 294 */     c c2 = f1.a();
/*     */     
/*     */     Rectangle rectangle;
/* 297 */     (rectangle = f1.j((d)paramab)).y += c1.g((d)paramab);
/* 298 */     rectangle.height -= c1.g((d)paramab);
/* 299 */     rectangle.x += c1.f((d)paramab);
/* 300 */     rectangle.width -= 2 * c1.f((d)paramab);
/*     */     
/* 302 */     paramab.p().a(paramab, c2, paramRectangle, rectangle, a2);
/*     */     
/* 304 */     c2 = f2.a();
/*     */ 
/*     */     
/* 307 */     (rectangle = f2.j((d)paramab)).x += c1.f((d)paramab);
/* 308 */     rectangle.width -= 2 * c1.f((d)paramab);
/*     */     
/* 310 */     paramab.p().a(paramab, c2, paramRectangle, rectangle, a2);
/*     */     
/* 312 */     a a1 = (this.f != null) ? this.f : a2;
/*     */     
/* 314 */     paramab.p().a(paramab, a(), paramRectangle, j((d)paramab), a1);
/*     */   }
/*     */   
/*     */   public final void c(ab paramab) {
/* 318 */     if (ay() && !o()) {
/*     */       
/* 320 */       if (paramab.o() && f().a().as() && a().a(paramab, (com.d.i.f)this)) {
/*     */         Rectangle rectangle;
/* 322 */         if ((rectangle = d(paramab)) != null)
/* 323 */           paramab.p().a(paramab, a(), rectangle, ad()); 
/*     */         return;
/*     */       } 
/* 326 */       super.c(paramab);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, int paramInt) {
/* 332 */     paramab.p().a(paramab, 
/* 333 */         p(), x((d)paramab), paramInt);
/*     */   }
/*     */   private Rectangle d(ab paramab) {
/*     */     int i, k;
/* 337 */     Rectangle rectangle = j((d)paramab);
/*     */     
/*     */     j j2;
/* 340 */     if ((j2 = g()).q() || j2.p()) {
/* 341 */       return rectangle;
/*     */     }
/*     */     
/*     */     j j1;
/*     */     
/*     */     i i1;
/* 347 */     if ((i1 = (j1 = ((i)U()).g()).a(paramab.t())) == null) {
/* 348 */       return null;
/*     */     }
/* 350 */     if (i1.a() == -1 || i1
/* 351 */       .b() == -1) {
/* 352 */       return rectangle;
/*     */     }
/*     */ 
/*     */     
/* 356 */     if (paramab.t() == j1.a()) {
/* 357 */       k = rectangle.y;
/*     */     } else {
/* 359 */       k = i1.a() - ((i)U()).j();
/*     */     } 
/*     */ 
/*     */     
/* 363 */     if (paramab.t() == j1.b()) {
/* 364 */       i = rectangle.y + rectangle.height;
/*     */     } else {
/* 366 */       i = i1.b() + ((i)U()).o();
/*     */     } 
/*     */     
/* 369 */     rectangle.y = k;
/* 370 */     rectangle.height = i - k;
/*     */     
/* 372 */     return rectangle;
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
/*     */   protected final boolean c_() {
/* 392 */     return f().a().a(a.am, c.e);
/*     */   }
/*     */   
/*     */   protected final boolean n() {
/* 396 */     return true;
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
/*     */   public static a a(a parama1, a parama2, boolean paramBoolean) {
/* 425 */     if (!parama2.e()) {
/* 426 */       return parama1;
/*     */     }
/*     */     
/* 429 */     if (!parama1.e()) {
/* 430 */       return parama2;
/*     */     }
/*     */ 
/*     */     
/* 434 */     if (parama1.b() == c.P)
/*     */     {
/* 436 */       return parama1;
/*     */     }
/* 438 */     if (parama2.b() == c.P)
/*     */     {
/* 440 */       return parama2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 445 */     if (parama2.b() == c.ap) {
/* 446 */       return parama1;
/*     */     }
/*     */     
/* 449 */     if (parama1.b() == c.ap) {
/* 450 */       return parama2;
/*     */     }
/*     */ 
/*     */     
/* 454 */     if (parama1.c() != parama2.c()) {
/* 455 */       return (parama1.c() > parama2.c()) ? parama1 : parama2;
/*     */     }
/*     */ 
/*     */     
/* 459 */     if (parama1.b() != parama2.b()) {
/* 460 */       if (l[(parama1.b()).a] > l[
/* 461 */           (parama2.b()).a]) return parama1;  return parama2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 466 */     if (paramBoolean && parama1.d() == parama2.d()) {
/* 467 */       return null;
/*     */     }
/* 469 */     return (parama1.d() >= parama2.d()) ? parama1 : parama2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static a a(a parama1, a parama2) {
/* 475 */     return a(parama1, parama2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a t(d paramd) {
/*     */     a a2;
/* 482 */     a a1 = a.a(a2 = a().a(paramd), 10);
/*     */     
/*     */     f f1;
/*     */     
/* 486 */     if ((f1 = f().c(this)) != null) {
/*     */ 
/*     */       
/* 489 */       if ((a1 = a(a1, a.b(f1.a().a(paramd), 10))).g()) {
/* 490 */         return a1;
/*     */       }
/* 492 */     } else if (d() == 0) {
/*     */ 
/*     */ 
/*     */       
/* 496 */       if ((a1 = a(a1, a.a(U().a().a(paramd), 9))).g()) {
/* 497 */         return a1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 503 */       if ((a1 = a(a1, a.a(g().a().a(paramd), 8))).g()) {
/* 504 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/*     */     h h;
/*     */     
/* 510 */     if ((h = f().e(d())) != null)
/*     */     {
/*     */       
/* 513 */       if ((a1 = a(a1, a.a(h.a().a(paramd), 7))).g()) {
/* 514 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 519 */     if (d() > 0 && (
/*     */       
/* 521 */       h = f().e(d() - 1)) != null)
/*     */     {
/*     */       
/* 524 */       if ((a1 = a(a1, a.b(h.a().a(paramd), 7))).g()) {
/* 525 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 530 */     if (d() == 0)
/*     */     {
/*     */ 
/*     */       
/* 534 */       if ((a1 = a(a1, a.a(f().a().a(paramd), 6))).g()) {
/* 535 */         return a1;
/*     */       }
/*     */     }
/*     */     
/* 539 */     return a1;
/*     */   }
/*     */   
/*     */   private a u(d paramd) {
/* 543 */     d d1 = f();
/* 544 */     boolean bool = false;
/*     */     int i;
/* 546 */     if ((i = d1.b(d() + a().ao() - 1)) == d1.f() - 1) {
/* 547 */       bool = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 553 */     a a1 = a.b(a().a(paramd), 10);
/*     */ 
/*     */     
/* 556 */     if (!bool) {
/*     */       f f1;
/* 558 */       if ((f1 = d1.d(this)) != null)
/*     */       {
/*     */         
/* 561 */         if ((a1 = a(a1, a.a(f1.a().a(paramd), 10))).g()) {
/* 562 */           return a1;
/*     */         
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 569 */       if ((a1 = a(a1, a.b(U().a().a(paramd), 9))).g()) {
/* 570 */         return a1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 576 */       if ((a1 = a(a1, a.b(g().a().a(paramd), 8))).g()) {
/* 577 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/*     */     h h;
/*     */     
/* 583 */     if ((h = f().e(d() + a().ao() - 1)) != null)
/*     */     {
/*     */       
/* 586 */       if ((a1 = a(a1, a.b(h.a().a(paramd), 7))).g()) {
/* 587 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 592 */     if (!bool) {
/*     */       
/* 594 */       if ((h = d1.e(d() + a().ao())) != null)
/*     */       {
/*     */         
/* 597 */         if ((a1 = a(a1, a.a(h.a().a(paramd), 7))).g()) {
/* 598 */           return a1;
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 605 */     else if ((a1 = a(a1, a.b(d1.a().a(paramd), 6))).g()) {
/* 606 */       return a1;
/*     */     } 
/*     */ 
/*     */     
/* 610 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a v(d paramd) {
/* 617 */     a a1 = a.c(a().a(paramd), 10);
/*     */     
/*     */     f f1;
/* 620 */     if ((f1 = f().a(this)) != null)
/*     */     {
/*     */ 
/*     */       
/* 624 */       if ((a1 = a(a1, a.d(f1.a().a(paramd), 10))).g()) {
/* 625 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 632 */     if ((a1 = a(a1, a.c(U().a().a(paramd), 9))).g()) {
/* 633 */       return a1;
/*     */     }
/*     */ 
/*     */     
/* 637 */     if (f1 != null) {
/*     */       i i;
/* 639 */       if (f1.g() == g()) {
/* 640 */         i = (i)U().S();
/*     */       } else {
/* 642 */         i = i.g().j();
/*     */       } 
/*     */       
/* 645 */       if (i != null)
/*     */       {
/*     */         
/* 648 */         if ((a1 = a(a1, a.d(i.a().a(paramd), 9))).g()) {
/* 649 */           return a1;
/*     */         }
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 655 */     j j1 = g();
/* 656 */     if (e() == 0) {
/*     */ 
/*     */ 
/*     */       
/* 660 */       if ((a1 = a(a1, a.c(j1.a().a(paramd), 8))).g()) {
/* 661 */         return a1;
/*     */       }
/*     */ 
/*     */       
/* 665 */       f();
/* 666 */       if ((j1 = d.a(j1, false)) != null)
/*     */       {
/*     */         
/* 669 */         if ((a1 = a(a1, a.d(j1.a().a(paramd), 8))).g()) {
/* 670 */           return a1;
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 675 */     if (j1 == null) {
/*     */       h h;
/*     */       
/* 678 */       if ((h = f().e(d())) != null)
/*     */       {
/*     */         
/* 681 */         if ((a1 = a(a1, a.c(h.a().a(paramd), 7))).g()) {
/* 682 */           return a1;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 689 */       if ((a1 = a(a1, a.c(f().a().a(paramd), 6))).g()) {
/* 690 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/* 694 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a w(d paramd) {
/* 701 */     a a1 = a.d(a().a(paramd), 10);
/*     */     
/*     */     f f1;
/* 704 */     if ((f1 = f().b(this)) != null)
/*     */     {
/*     */ 
/*     */       
/* 708 */       if ((a1 = a(a1, a.c(f1.a().a(paramd), 10))).g()) {
/* 709 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 716 */     if ((a1 = a(a1, a.d(U().a().a(paramd), 9))).g()) {
/* 717 */       return a1;
/*     */     }
/*     */ 
/*     */     
/* 721 */     if (f1 != null)
/*     */     {
/*     */       
/* 724 */       if ((a1 = a(a1, a.c(f1.U().a().a(paramd), 9))).g()) {
/* 725 */         return a1;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 730 */     j j1 = g();
/* 731 */     if (e() + a().an() >= j1.g()) {
/*     */ 
/*     */ 
/*     */       
/* 735 */       if ((a1 = a(a1, a.d(j1.a().a(paramd), 8))).g()) {
/* 736 */         return a1;
/*     */       }
/*     */ 
/*     */       
/* 740 */       f();
/* 741 */       if ((j1 = d.b(j1, false)) != null)
/*     */       {
/*     */         
/* 744 */         if ((a1 = a(a1, a.c(j1.a().a(paramd), 8))).g()) {
/* 745 */           return a1;
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 750 */     if (j1 == null) {
/*     */       h h;
/*     */       
/* 753 */       if ((h = f().e(d())) != null)
/*     */       {
/*     */         
/* 756 */         if ((a1 = a(a1, a.d(h.a().a(paramd), 7))).g()) {
/* 757 */           return a1;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 764 */       if ((a1 = a(a1, a.d(f().a().a(paramd), 6))).g()) {
/* 765 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/* 769 */     return a1;
/*     */   }
/*     */   
/*     */   private Rectangle x(d paramd) {
/* 773 */     a a1 = p();
/*     */     
/*     */     Rectangle rectangle;
/* 776 */     (rectangle = j(paramd)).x -= (int)a1.w() / 2;
/* 777 */     rectangle.y -= (int)a1.t() / 2;
/* 778 */     rectangle.width += (int)a1.w() / 2 + ((int)a1.u() + 1) / 2;
/* 779 */     rectangle.height += (int)a1.t() / 2 + ((int)a1.v() + 1) / 2;
/*     */     
/* 781 */     return rectangle;
/*     */   }
/*     */   
/*     */   public final Rectangle g(d paramd) {
/* 785 */     if (o()) {
/* 786 */       return x(paramd);
/*     */     }
/* 788 */     return super.g(paramd);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean o() {
/* 793 */     return (this.g != null);
/*     */   }
/*     */   
/*     */   protected final a p() {
/* 797 */     return this.g;
/*     */   }
/*     */   
/*     */   public final a q() {
/* 801 */     return this.j;
/*     */   }
/*     */   
/*     */   public final a r() {
/* 805 */     return this.k;
/*     */   }
/*     */   
/*     */   public final a s() {
/* 809 */     return this.i;
/*     */   }
/*     */   
/*     */   public final a t() {
/* 813 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(Set<a> paramSet, List<k> paramList) {
/* 817 */     if (this.h.f() && !paramSet.contains(this.h)) {
/* 818 */       paramSet.add(this.h);
/* 819 */       paramList.add(new k(this, 1));
/*     */     } 
/*     */     
/* 822 */     if (this.i.f() && !paramSet.contains(this.i)) {
/* 823 */       paramSet.add(this.i);
/* 824 */       paramList.add(new k(this, 8));
/*     */     } 
/*     */     
/* 827 */     if (this.j.f() && !paramSet.contains(this.j)) {
/* 828 */       paramSet.add(this.j);
/* 829 */       paramList.add(new k(this, 4));
/*     */     } 
/*     */     
/* 832 */     if (this.k.f() && !paramSet.contains(this.k)) {
/* 833 */       paramSet.add(this.k);
/* 834 */       paramList.add(new k(this, 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int h(d paramd) {
/* 843 */     if (a().J()) {
/* 844 */       return -1;
/*     */     }
/* 846 */     int i = (int)a().b(a.R, 
/* 847 */         Y().d_(), paramd);
/*     */     
/* 849 */     a a1 = b(paramd);
/* 850 */     i -= (int)a1.t() + (int)a1.v();
/*     */     
/* 852 */     h h = o(paramd);
/*     */ 
/*     */     
/* 855 */     return ((i = i - (int)h.t() + (int)h.v()) >= 0) ? i : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean h() {
/* 860 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\f\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */