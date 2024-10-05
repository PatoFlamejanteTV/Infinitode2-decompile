/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.g;
/*     */ import com.d.c.d.h;
/*     */ import com.d.c.f.a.a;
/*     */ import com.d.c.f.a.h;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.q;
/*     */ import com.d.e.d;
/*     */ import com.d.e.s;
/*     */ import com.d.e.t;
/*     */ import com.d.e.v;
/*     */ import com.d.e.y;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class r
/*     */   extends f
/*     */   implements s
/*     */ {
/*     */   private int a;
/*     */   private boolean b;
/*     */   private boolean c;
/*     */   private List<Object> d;
/*     */   private boolean e;
/*     */   private int f;
/*     */   private List<ad> g;
/*     */   private int h;
/*     */   
/*     */   public r(v paramv, Element paramElement, c paramc, int paramInt) {
/*  69 */     this();
/*  70 */     a(paramElement);
/*  71 */     a(paramc);
/*  72 */     d(paramInt);
/*  73 */     c((d)paramv, 0);
/*  74 */     d((d)paramv, 0);
/*  75 */     c(true);
/*  76 */     b(paramv);
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
/*     */   private r() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(v paramv) {
/*  98 */     a a = b((d)paramv);
/*  99 */     h h = o((d)paramv);
/*     */     
/* 101 */     l l = a().e((d)paramv);
/*     */     
/* 103 */     t((int)Math.ceil((a.t() + h.t() + l.a() + l
/* 104 */           .b() + h.v() + a.v())));
/*     */   }
/*     */   
/*     */   public final int c() {
/* 108 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 112 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public final int e() {
/* 116 */     return (this.d == null) ? 0 : this.d.size();
/*     */   }
/*     */   
/*     */   public final void a(v paramv, Object paramObject) {
/* 120 */     a(paramv, paramObject, true);
/*     */   }
/*     */   
/*     */   public final void a(v paramv, Object paramObject, boolean paramBoolean) {
/* 124 */     if (this.d == null) {
/* 125 */       this.d = new ArrayList();
/*     */     }
/*     */     
/* 128 */     this.d.add(paramObject);
/*     */     
/* 130 */     if (paramBoolean && h()) {
/* 131 */       a(paramv);
/*     */     }
/*     */     
/* 134 */     if (paramObject instanceof f) {
/*     */       
/* 136 */       (paramObject = paramObject).f(this);
/* 137 */       paramObject.r(paramv); return;
/* 138 */     }  if (paramObject instanceof s) {
/* 139 */       ((s)paramObject).a(this); return;
/*     */     } 
/* 141 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Object> n() {
/* 149 */     return (this.d == null) ? Collections.emptyList() : this.d;
/*     */   }
/*     */   
/*     */   public final Object b(int paramInt) {
/* 153 */     if (this.d == null) {
/* 154 */       throw new ArrayIndexOutOfBoundsException();
/*     */     }
/* 156 */     return this.d.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private int o() {
/* 161 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void f() {
/* 165 */     if (e() > 0) {
/* 166 */       Object object; for (int i = e() - 1; i >= 0 && 
/*     */         
/* 168 */         object = b(i) instanceof r; ) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 173 */         (object = object).f();
/*     */         
/* 175 */         if (object.h()) {
/* 176 */           j(i);
/*     */           i--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean p() {
/* 185 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 189 */     this.c = true;
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 193 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 197 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean h() {
/* 201 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void c(boolean paramBoolean) {
/* 205 */     this.e = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void a(v paramv) {
/* 209 */     this.e = false;
/*     */     r r1;
/* 211 */     if (U() instanceof r && (
/*     */       
/* 213 */       r1 = (r)U()).h()) {
/* 214 */       r1.a(paramv);
/*     */     }
/*     */ 
/*     */     
/* 218 */     b(true);
/*     */     
/* 220 */     if (a().O()) {
/* 221 */       paramv.a(this);
/* 222 */       Z().b(true);
/* 223 */       s(paramv);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void s(v paramv) {
/* 229 */     if (e() > 0) {
/* 230 */       for (byte b = 0; b < e(); b++) {
/*     */         Object object;
/* 232 */         if (object = b(b) instanceof f) {
/*     */           
/* 234 */           (object = object).b(paramv.o());
/* 235 */           object.s(paramv);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab) {
/* 252 */     if (!a().a(paramab, this)) {
/*     */       return;
/*     */     }
/*     */     
/* 256 */     Object object1 = paramab.p().a(q.c, this);
/*     */     
/* 258 */     b(paramab);
/* 259 */     c(paramab);
/*     */     
/* 261 */     if (paramab.l()) {
/* 262 */       e(paramab);
/*     */     }
/*     */     
/*     */     List<ad> list;
/* 266 */     for (Iterator<ad> iterator1 = (list = q()).iterator(); iterator1.hasNext();) {
/*     */       
/* 268 */       if ((c = (ad = iterator1.next()).c()) == c.bk || c == c.ax) {
/* 269 */         paramab.p().a(paramab, this, ad);
/*     */       }
/*     */     } 
/*     */     
/* 273 */     paramab.p().a(object1);
/*     */     
/* 275 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 277 */       if (object = b(b) instanceof s) {
/* 278 */         Object object3 = paramab.p().a(q.d, this);
/* 279 */         ((s)object).a(paramab);
/* 280 */         paramab.p().a(object3);
/* 281 */       } else if (object instanceof f) {
/* 282 */         Object object3 = paramab.p().a(q.h, (f)object);
/* 283 */         paramab.p().a(object3);
/*     */       } 
/*     */     } 
/*     */     
/* 287 */     Object object2 = paramab.p().a(q.c, this);
/*     */     
/* 289 */     for (Iterator<ad> iterator2 = list.iterator(); iterator2.hasNext();) {
/*     */       
/* 291 */       if ((object1 = (ad = iterator2.next()).c()) == c.ad) {
/* 292 */         paramab.p().a(paramab, this, ad);
/*     */       }
/*     */     } 
/*     */     
/* 296 */     paramab.p().a(object2);
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
/*     */   public final int ad() {
/* 316 */     byte b = 5;
/*     */     
/* 318 */     if (this.b) {
/* 319 */       b += 2;
/*     */     }
/* 321 */     if (this.c) {
/* 322 */       b += 8;
/*     */     }
/*     */     
/* 325 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Rectangle a(int paramInt1, int paramInt2, d paramd) {
/* 333 */     float f1 = 0.0F;
/* 334 */     float f2 = 0.0F;
/* 335 */     if (this.b || this.c) {
/* 336 */       h h1 = n(paramd);
/* 337 */       if (this.b) {
/* 338 */         f1 = h1.w();
/*     */       }
/* 340 */       if (this.c) {
/* 341 */         f2 = h1.u();
/*     */       }
/*     */     } 
/* 344 */     a a = b(paramd);
/* 345 */     h h = o(paramd);
/*     */ 
/*     */ 
/*     */     
/*     */     Rectangle rectangle;
/*     */ 
/*     */     
/* 352 */     return rectangle = new Rectangle((int)(paramInt1 + f1), (int)(paramInt2 - a.t() - h.t()), (int)(o() - f1 - f2), as());
/*     */   }
/*     */ 
/*     */   
/*     */   public final Rectangle a(int paramInt1, int paramInt2, d paramd, int paramInt3, int paramInt4) {
/* 357 */     Rectangle rectangle = a(paramInt1, paramInt2, paramd);
/* 358 */     float f1 = 0.0F;
/* 359 */     float f2 = 0.0F;
/* 360 */     if (this.b || this.c) {
/* 361 */       h h = n(paramd);
/* 362 */       if (this.b) {
/* 363 */         f1 = h.w();
/*     */       }
/* 365 */       if (this.c) {
/* 366 */         f2 = h.u();
/*     */       }
/*     */     } 
/* 369 */     if (f2 > 0.0F) {
/* 370 */       rectangle.width = (int)(rectangle.width + f2);
/*     */     }
/* 372 */     if (f1 > 0.0F) {
/* 373 */       rectangle.x = (int)(rectangle.x - f1);
/* 374 */       rectangle.width = (int)(rectangle.width + f1);
/*     */     } 
/* 376 */     rectangle.translate(paramInt3, paramInt4);
/* 377 */     return rectangle;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Rectangle c(int paramInt1, int paramInt2, d paramd) {
/* 382 */     a a = b(paramd);
/* 383 */     h h = o(paramd);
/*     */     
/* 385 */     float f1 = 0.0F;
/* 386 */     float f2 = 0.0F;
/*     */     
/* 388 */     float f3 = 0.0F;
/* 389 */     float f4 = 0.0F;
/*     */     
/* 391 */     float f5 = 0.0F;
/* 392 */     float f6 = 0.0F;
/*     */     
/* 394 */     if (this.b || this.c) {
/* 395 */       h h1 = n(paramd);
/* 396 */       if (this.b) {
/* 397 */         f1 = h1.w();
/* 398 */         f3 = a.w();
/* 399 */         f5 = h.w();
/*     */       } 
/* 401 */       if (this.c) {
/* 402 */         f2 = h1.u();
/* 403 */         f4 = a.u();
/* 404 */         f6 = h.u();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     Rectangle rectangle;
/*     */ 
/*     */ 
/*     */     
/* 414 */     return rectangle = new Rectangle((int)(paramInt1 + f1 + f3 + f5), (int)(paramInt2 - a.t() - h.t()), (int)(o() - f1 - f3 - f5 - f6 - f4 - f2), as());
/*     */   }
/*     */   
/*     */   public final int a(d paramd) {
/* 418 */     if (this.b) {
/* 419 */       return g(paramd, 1);
/*     */     }
/* 421 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int c(d paramd) {
/* 426 */     if (this.c) {
/* 427 */       return g(paramd, 2);
/*     */     }
/* 429 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int i() {
/* 434 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 438 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean j() {
/* 442 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 444 */       if (object = b(b) instanceof s) {
/*     */         
/* 446 */         if (!(object = object).c()) {
/* 447 */           return true;
/*     */         }
/* 449 */       } else if (object instanceof r) {
/*     */         
/* 451 */         if ((object = object).j()) {
/* 452 */           return true;
/*     */         
/*     */         }
/*     */       }
/* 456 */       else if ((object = object).Q() > 0 || object.as() > 0) {
/* 457 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 461 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean b(d paramd, Shape paramShape) {
/* 465 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/*     */       
/* 468 */       if (object = b(b) instanceof r) {
/*     */         boolean bool;
/*     */         
/* 471 */         if (bool = ((r)object).b(paramd, paramShape))
/* 472 */           return true; 
/*     */       } else {
/* 474 */         d d1; if (object instanceof f && (
/*     */           
/* 476 */           d1 = new d()).a(paramd, paramShape, (f)object)) {
/* 477 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 482 */     return false;
/*     */   }
/*     */   
/*     */   private List<ad> q() {
/* 486 */     return (this.g == null) ? Collections.emptyList() : this.g;
/*     */   }
/*     */   
/*     */   public final void a(List<ad> paramList) {
/* 490 */     this.g = paramList;
/*     */   }
/*     */   
/*     */   private void b(List<f> paramList) {
/* 494 */     paramList.add(this);
/*     */     
/* 496 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 498 */       if (object = b(b) instanceof r) {
/* 499 */         ((r)object).b(paramList);
/* 500 */       } else if (object instanceof f) {
/* 501 */         paramList.add((f)object);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final u k() {
/* 507 */     f f1 = U();
/* 508 */     while (!(f1 instanceof u)) {
/* 509 */       f1 = f1.U();
/*     */     }
/* 511 */     return (u)f1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<f> l() {
/* 517 */     ArrayList<f> arrayList = new ArrayList();
/*     */     
/* 519 */     c c = (c)k().U();
/*     */     while (true) {
/* 521 */       List<f> list = c.b(ai());
/* 522 */       for (byte b = 0; b < list.size(); b++) {
/*     */         r r1;
/* 524 */         (r1 = (r)list.get(b)).b(arrayList);
/*     */       } 
/*     */       
/* 527 */       if (c instanceof b && 
/* 528 */         !d(arrayList))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 534 */         if ((c = a(c, arrayList)) != null)
/*     */           continue; 
/*     */       }
/*     */       break;
/*     */     } 
/* 539 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static b a(c paramc, List<f> paramList) {
/* 543 */     f f1 = paramc.U();
/* 544 */     byte b = 0;
/* 545 */     for (; b < f1.V(); b++) {
/* 546 */       if (f1.k(b) == paramc) {
/* 547 */         b++;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 552 */     for (; b < f1.V() && 
/* 553 */       !(f1.k(b) instanceof b); b++)
/*     */     {
/*     */       
/* 556 */       paramList.add(f1.k(b));
/*     */     }
/*     */ 
/*     */     
/* 560 */     return (b == f1.V()) ? null : 
/* 561 */       (b)f1.k(b);
/*     */   }
/*     */   
/*     */   private boolean a(f paramf) {
/* 565 */     if (paramf instanceof r) {
/* 566 */       paramf = paramf;
/* 567 */       if (ai() == paramf.ai() && paramf.p()) {
/* 568 */         return true;
/*     */       }
/*     */     } 
/* 571 */     return false;
/*     */   }
/*     */   
/*     */   private boolean d(List<f> paramList) {
/* 575 */     return paramList.stream().anyMatch(this::a);
/*     */   }
/*     */   
/*     */   public final List<f> b(Element paramElement) {
/* 579 */     ArrayList<Object> arrayList = new ArrayList();
/* 580 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 582 */       if (object = b(b) instanceof f) {
/*     */         
/* 584 */         if ((object = object).ai() == paramElement) {
/* 585 */           arrayList.add(object);
/*     */         }
/* 587 */         arrayList.addAll(object.b(paramElement));
/*     */       } 
/*     */     } 
/* 590 */     return arrayList;
/*     */   }
/*     */   
/*     */   public final Dimension m(d paramd) {
/* 594 */     Dimension dimension = super.m(paramd);
/*     */     
/* 596 */     n(am() - dimension.width);
/* 597 */     o(an() - dimension.height);
/*     */     
/* 599 */     List<f> list = l();
/*     */     
/* 601 */     for (byte b = 0; b < list.size(); b++) {
/*     */       f f1;
/* 603 */       (f1 = list.get(b)).n(f1.am() + dimension.width);
/* 604 */       f1.o(f1.an() + dimension.height);
/*     */       
/* 606 */       f1.B();
/* 607 */       f1.C();
/*     */     } 
/*     */     
/* 610 */     return dimension;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(List<f> paramList, t paramt) {
/* 615 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 617 */       if (object = b(b) instanceof f && (
/* 618 */         (f)object).af() == paramt) {
/* 619 */         paramList.add((f)object);
/* 620 */         if (object instanceof r) {
/* 621 */           ((r)object).a(paramList, paramt);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void e(ab paramab) {
/* 629 */     paramab.p().a(paramab, this, (g)h.d);
/*     */   }
/*     */   
/*     */   protected final void t(v paramv) {
/* 633 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 635 */       if (object = b(b) instanceof f) {
/* 636 */         ((f)object).c(paramv);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void c(f paramf) {
/* 642 */     if (this.d != null) {
/* 643 */       this.d.remove(paramf);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void j(int paramInt) {
/* 648 */     if (this.d != null) {
/* 649 */       this.d.remove(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final f d(f paramf) {
/* 654 */     if (this.d == null) {
/* 655 */       return null;
/*     */     }
/*     */     
/* 658 */     for (byte b = 0; b < this.d.size() - 1; b++) {
/*     */       Object object;
/* 660 */       if ((object = this.d.get(b)) == paramf) {
/* 661 */         if (b == 0) {
/* 662 */           return null;
/*     */         }
/*     */         
/* 665 */         return (paramf = (f)this.d.get(b - 1) instanceof f) ? paramf : null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 670 */     return null;
/*     */   }
/*     */   
/*     */   protected final f e(f paramf) {
/* 674 */     if (this.d == null) {
/* 675 */       return null;
/*     */     }
/*     */     
/* 678 */     for (byte b = 0; b < this.d.size() - 1; b++) {
/*     */       Object object;
/* 680 */       if ((object = this.d.get(b)) == paramf)
/*     */       {
/* 682 */         return (paramf = (f)this.d.get(b + 1) instanceof f) ? paramf : null;
/*     */       }
/*     */     } 
/*     */     
/* 686 */     return null;
/*     */   }
/*     */   
/*     */   public final void B() {
/* 690 */     u u = k();
/* 691 */     m(u.ab() + am());
/* 692 */     l(u.aa() + an());
/*     */   }
/*     */   
/*     */   public final void C() {
/* 696 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 698 */       if (object = b(b) instanceof f) {
/*     */         
/* 700 */         (object = object).B();
/* 701 */         object.C();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(d paramd, y paramy, boolean paramBoolean) {
/* 708 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 710 */       if (object = b(b) instanceof f) {
/* 711 */         object = ((f)object).c(paramd, paramBoolean);
/* 712 */         a(paramy.b(), object.b());
/* 713 */         paramy.a().add(object.a());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void d(ab paramab) {
/* 719 */     for (byte b = 0; b < e(); b++) {
/*     */       Object object;
/* 721 */       if (object = b(b) instanceof s) {
/*     */         
/* 723 */         if ((object = object).h()) {
/* 724 */           object.b(paramab);
/*     */         }
/* 726 */       } else if (object instanceof r) {
/* 727 */         ((r)object).d(paramab);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final s m() {
/* 733 */     if (e() == 0) {
/* 734 */       return null;
/*     */     }
/*     */     
/* 737 */     Object object = null;
/*     */     
/* 739 */     for (int i = e() - 1; i >= 0; i--) {
/*     */       
/* 741 */       if (object = b(i) instanceof s) {
/*     */         
/* 743 */         if (!(object = object).c())
/*     */         {
/*     */           
/* 746 */           return (s)object; } 
/* 747 */       } else if (object instanceof r) {
/*     */         
/* 749 */         if ((object = ((r)object).m()) == null || !object.c())
/*     */         {
/*     */           
/* 752 */           return (s)object; } 
/*     */       } else {
/* 754 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 758 */     return (s)object;
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
/*     */   public final int aj() {
/* 796 */     return this.h;
/*     */   }
/*     */   
/*     */   private void d(int paramInt) {
/* 800 */     this.h = paramInt;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 805 */     (stringBuilder = new StringBuilder()).append("InlineLayoutBox: ");
/* 806 */     if (ai() != null) {
/* 807 */       stringBuilder.append("<");
/* 808 */       stringBuilder.append(ai().getNodeName());
/* 809 */       stringBuilder.append("> ");
/*     */     } else {
/* 811 */       stringBuilder.append("(anonymous) ");
/*     */     } 
/* 813 */     if (g() || p()) {
/* 814 */       stringBuilder.append("(");
/* 815 */       if (g()) {
/* 816 */         stringBuilder.append("S");
/*     */       }
/* 818 */       if (p()) {
/* 819 */         stringBuilder.append("E");
/*     */       }
/* 821 */       stringBuilder.append(") ");
/*     */     } 
/* 823 */     stringBuilder.append("(baseline=");
/* 824 */     stringBuilder.append(this.a);
/* 825 */     stringBuilder.append(") ");
/* 826 */     stringBuilder.append("(" + ab() + "," + aa() + ")->(" + i() + " x " + as() + ")");
/* 827 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh) {
/* 894 */     boolean bool = a().at();
/* 895 */     for (Iterator<Object> iterator = n().iterator(); iterator.hasNext(); ) {
/*     */       r r1;
/* 897 */       if (r1 = (r)iterator.next() instanceof r) {
/* 898 */         ((r)r1).a(paramh); continue;
/* 899 */       }  if (r1 instanceof s && bool) {
/* 900 */         ((s)r1).a(paramh);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final float a(t paramt, float paramFloat) {
/* 906 */     paramFloat = paramFloat;
/*     */     
/* 908 */     float f1 = 0.0F;
/*     */     
/* 910 */     for (Iterator<Object> iterator = n().iterator(); iterator.hasNext(); ) {
/*     */       s s1;
/*     */       
/* 913 */       if (s1 = (s)iterator.next() instanceof s) {
/*     */ 
/*     */         
/* 916 */         (s1 = s1).a(s1.e() + Math.round(f1));
/*     */         
/* 918 */         float f3 = s1.a(paramt);
/*     */         
/* 920 */         s1.b((int)(s1.f() + f3));
/*     */         
/* 922 */         f1 += f3;
/* 923 */         paramFloat += f3; continue;
/*     */       } 
/*     */       f f2;
/* 926 */       (f2 = (f)s1).n(f2.am() + Math.round(paramFloat));
/*     */       
/* 928 */       if (f2 instanceof r) {
/* 929 */         float f3 = ((r)f2).a(paramt, paramFloat);
/* 930 */         f1 += f3;
/* 931 */         paramFloat += f3;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 936 */     c((int)(i() + f1));
/* 937 */     return f1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */