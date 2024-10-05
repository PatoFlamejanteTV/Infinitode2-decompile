/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.g;
/*     */ import com.d.c.d.h;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.q;
/*     */ import com.d.e.d;
/*     */ import com.d.e.q;
/*     */ import com.d.e.s;
/*     */ import com.d.e.t;
/*     */ import com.d.e.v;
/*     */ import com.d.h.w;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ public final class u
/*     */   extends f
/*     */   implements s
/*     */ {
/*     */   private boolean a;
/*     */   private boolean b;
/*     */   private m c;
/*     */   private List<ad> d;
/*     */   private int e;
/*     */   private int f;
/*     */   private List<f> g;
/*     */   private x h;
/*     */   private boolean i;
/*     */   private int j;
/*     */   private int k;
/*     */   private t l;
/*  78 */   private byte m = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 102 */     return "LineBox: (" + ab() + "," + aa() + ")->(" + Q() + "," + as() + ")";
/*     */   }
/*     */   
/*     */   public final Rectangle a(d paramd, int paramInt1, int paramInt2) {
/*     */     Rectangle rectangle;
/* 107 */     (rectangle = new Rectangle(am(), an(), d_(), as())).translate(paramInt1, paramInt2);
/* 108 */     return rectangle;
/*     */   }
/*     */   
/*     */   public final void a(ab paramab) {
/* 112 */     if (!U().a().a(paramab, this)) {
/*     */       return;
/*     */     }
/*     */     
/* 116 */     if (i()) {
/* 117 */       int i; d(paramab);
/*     */ 
/*     */       
/* 120 */       if (this.m == 1) {
/* 121 */         i = q.a(paramab, this, 0, 0);
/*     */       } else {
/*     */         
/* 124 */         i = q.a(paramab, this, 0);
/*     */       } 
/* 126 */       u(i);
/* 127 */       C();
/* 128 */       a(true, paramab);
/* 129 */       c(paramab, false);
/*     */     } 
/*     */     
/* 132 */     if (this.d != null) {
/* 133 */       Object object = paramab.p().a(q.c, this);
/* 134 */       paramab.p().a(this);
/* 135 */       paramab.p().a(object);
/*     */     } 
/*     */     
/* 138 */     if (paramab.k()) {
/* 139 */       paramab.p().a(paramab, this, (g)h.c);
/*     */     }
/*     */   }
/*     */   
/*     */   private void d(ab paramab) {
/* 144 */     if (V() > 0) {
/* 145 */       for (byte b = 0; b < V(); b++) {
/*     */         f f1;
/* 147 */         if (f1 = k(b) instanceof r) {
/* 148 */           ((r)f1).d(paramab);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean c() {
/*     */     f f1;
/* 156 */     if ((f1 = U()) != null && f1.V() > 0 && f1.k(0) == this) return true;  return false;
/*     */   }
/*     */   
/*     */   public final void e() {
/* 160 */     if (V() > 0) {
/* 161 */       f f1; for (int i = V() - 1; i >= 0 && 
/*     */         
/* 163 */         f1 = k(i) instanceof r; i--) {
/*     */ 
/*     */ 
/*     */         
/* 167 */         (f1 = f1).f();
/* 168 */         if (f1.h()) {
/* 169 */           j(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean f() {
/* 176 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 180 */     this.a = true;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean, d paramd) {
/* 184 */     c c = U().a().e(a.an);
/*     */     
/* 186 */     int i = 0;
/* 187 */     byte b = -1;
/*     */     
/* 189 */     if (c == c.bH) {
/* 190 */       b = (this.m == 1) ? 1 : 0;
/*     */     }
/*     */     
/* 193 */     if (c == c.aa || c == c.X || b == 0) {
/* 194 */       i = q().a();
/* 195 */       i = t() + i;
/* 196 */       if (c == c.X && paramBoolean) {
/* 197 */         g();
/*     */       }
/* 199 */     } else if (c == c.n) {
/* 200 */       i = q().a();
/* 201 */       int j = q().b();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       i = (j = i + (U().d_() - i - j) / 2) - (d_() + t()) / 2;
/* 207 */     } else if (c == c.aJ || b == 1) {
/* 208 */       i = q().b();
/* 209 */       i = U().d_() - i - d_();
/*     */     } 
/*     */     
/* 212 */     if (i != am()) {
/* 213 */       n(i);
/* 214 */       B();
/* 215 */       C();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void g() {
/* 221 */     if (!U().a().aA()) {
/*     */ 
/*     */       
/* 224 */       int i = q().a();
/* 225 */       int j = q().b();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       if (!o() && (i = U().d_() - i - j - t()) > d_()) {
/* 231 */         i -= d_();
/*     */         
/* 233 */         h h = p();
/*     */         
/* 235 */         t t1 = new t();
/*     */         
/* 237 */         if (h.b() > 1) {
/* 238 */           t1.a(i * 0.2F / (h.b() - 1));
/*     */         } else {
/* 240 */           t1.a(0.0F);
/*     */         } 
/*     */         
/* 243 */         if (h.a() > 0) {
/* 244 */           t1.b(i * 0.8F / h.a());
/*     */         } else {
/* 246 */           t1.b(0.0F);
/*     */         } 
/*     */         
/* 249 */         a(t1);
/*     */         
/* 251 */         b(t1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(t paramt) {
/* 257 */     float f1 = 0.0F;
/* 258 */     for (Iterator<f> iterator = X().iterator(); iterator.hasNext(); ) {
/* 259 */       f f2; (f2 = iterator.next()).n(f2.am() + Math.round(f1));
/*     */       
/* 261 */       if (f2 instanceof r) {
/* 262 */         f1 += ((r)f2).a(paramt, f1);
/*     */       }
/*     */     } 
/*     */     
/* 266 */     C();
/*     */   }
/*     */   
/*     */   private boolean o() {
/* 270 */     u u1 = (u)T();
/* 271 */     while (u1 != null) {
/* 272 */       if (u1.f()) {
/* 273 */         return false;
/*     */       }
/* 275 */       u1 = (u)u1.T();
/*     */     } 
/*     */ 
/*     */     
/* 279 */     return true;
/*     */   }
/*     */   
/*     */   private h p() {
/* 283 */     h h = new h();
/*     */     
/* 285 */     for (Iterator<f> iterator = X().iterator(); iterator.hasNext();) {
/* 286 */       if (f1 = iterator.next() instanceof r) {
/* 287 */         ((r)f1).a(h);
/*     */       }
/*     */     } 
/*     */     
/* 291 */     return h;
/*     */   }
/*     */   
/*     */   private m q() {
/* 295 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(m paramm) {
/* 299 */     this.c = paramm;
/*     */   }
/*     */   
/*     */   private boolean r() {
/* 303 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 307 */     this.b = true;
/*     */   }
/*     */   
/*     */   public final boolean a(d paramd, Shape paramShape) {
/* 311 */     if (paramShape == null || b(paramd, paramShape) || (
/* 312 */       r() && c(paramd, paramShape))) return true; 
/*     */     return false;
/*     */   }
/*     */   private boolean b(d paramd, Shape paramShape) {
/* 316 */     Rectangle rectangle = g(paramd);
/* 317 */     return paramShape.intersects(rectangle);
/*     */   }
/*     */   
/*     */   public final Rectangle g(d paramd) {
/*     */     Rectangle rectangle;
/*     */     f f1;
/* 323 */     if ((f1 = U()).a().a(a.v, c.h) || 
/*     */       
/* 325 */       m() != null) {
/*     */ 
/*     */       
/* 328 */       rectangle = new Rectangle(ab(), aa() + this.e, f1.ab() + f1.ap() + f1.d_() - ab(), this.f);
/*     */     }
/*     */     else {
/*     */       
/* 332 */       rectangle = new Rectangle(ab(), aa() + this.e, d_(), this.f);
/*     */     } 
/* 334 */     return rectangle;
/*     */   }
/*     */   
/*     */   private boolean c(d paramd, Shape paramShape) {
/* 338 */     for (byte b = 0; b < V(); b++) {
/*     */       f f1;
/* 340 */       if (f1 = k(b) instanceof r) {
/*     */         boolean bool;
/*     */         
/* 343 */         if (bool = ((r)f1).b(paramd, paramShape)) {
/* 344 */           return true;
/*     */         }
/*     */       } else {
/*     */         d d1;
/* 348 */         if ((d1 = new d()).a(paramd, paramShape, f1)) {
/* 349 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 354 */     return false;
/*     */   }
/*     */   
/*     */   public final List<ad> h() {
/* 358 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void a(List<ad> paramList) {
/* 362 */     this.d = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 370 */     this.f = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt) {
/* 378 */     this.e = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(List<f> paramList, t paramt) {
/* 383 */     for (byte b = 0; b < V(); b++) {
/* 384 */       f f1 = k(b);
/* 385 */       if (af() == paramt) {
/* 386 */         paramList.add(f1);
/* 387 */         if (f1 instanceof r) {
/* 388 */           ((r)f1).a(paramList, paramt);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<f> s() {
/* 395 */     return (this.g == null) ? Collections.emptyList() : this.g;
/*     */   }
/*     */   
/*     */   public final void a(c paramc) {
/* 399 */     if (this.g == null) {
/* 400 */       this.g = new ArrayList<>();
/*     */     }
/*     */     
/* 403 */     this.g.add(paramc);
/*     */   }
/*     */   
/*     */   public final void c(v paramv) {
/* 407 */     for (byte b = 0; b < s().size(); b++) {
/*     */       f f1;
/* 409 */       (f1 = s().get(b)).c(paramv);
/*     */     } 
/* 411 */     if (this.h != null) {
/* 412 */       this.h.b(this);
/*     */     }
/* 414 */     super.c(paramv);
/*     */   }
/*     */   
/*     */   public final void B() {
/*     */     f f1;
/* 419 */     if ((f1 = U()) == null) {
/* 420 */       throw new w.a("calcCanvasLocation() called with no parent");
/*     */     }
/* 422 */     m(f1.ab() + f1.ap() + am());
/* 423 */     l(f1.aa() + f1.ao() + an());
/*     */   }
/*     */   
/*     */   public final void C() {
/* 427 */     super.C();
/*     */ 
/*     */ 
/*     */     
/* 431 */     for (byte b = 0; b < s().size(); b++) {
/*     */       f f1;
/* 433 */       if ((f1 = s().get(b)).a().A()) {
/* 434 */         f1.B();
/* 435 */         f1.C();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(x paramx) {
/* 445 */     this.h = paramx;
/*     */   }
/*     */   
/*     */   public final boolean i() {
/* 449 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void c(boolean paramBoolean) {
/* 453 */     this.i |= paramBoolean;
/*     */   }
/*     */   
/*     */   private int t() {
/* 457 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 461 */     this.j = paramInt;
/*     */   }
/*     */   
/*     */   private s u() {
/* 465 */     if (V() == 0) {
/* 466 */       return null;
/*     */     }
/*     */     
/* 469 */     for (int i = V() - 1; i >= 0; i--) {
/*     */       f f1;
/* 471 */       if (f1 = k(i) instanceof r) {
/*     */         s s1;
/* 473 */         if ((s1 = ((r)f1).m()) == null || !s1.c())
/*     */         {
/*     */           
/* 476 */           return s1; } 
/*     */       } else {
/* 478 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 482 */     return null;
/*     */   }
/*     */   public final void a(v paramv) {
/*     */     s s1;
/*     */     c c;
/*     */     r r;
/* 488 */     if ((s1 = u()) != null && ((
/*     */ 
/*     */       
/* 491 */       c = (r = s1.g()).a().i()) == c.aq || c == c.ar)) {
/* 492 */       s1.a(paramv);
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
/*     */   public final int j() {
/* 516 */     return this.k;
/*     */   }
/*     */   
/*     */   public final void d(int paramInt) {
/* 520 */     this.k = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 524 */     if (!r()) {
/* 525 */       return false;
/*     */     }
/*     */     
/* 528 */     for (byte b = 0; b < V(); b++) {
/*     */       f f1;
/* 530 */       if (!(f1 = k(b) instanceof c)) {
/* 531 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 535 */     return true;
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
/*     */   public final boolean l() {
/* 554 */     for (byte b = 0; b < V(); b++) {
/*     */       f f1;
/* 556 */       if (f1 = k(b) instanceof c) {
/* 557 */         if (f1.Q() > 0 || f1.as() > 0) {
/* 558 */           return true;
/*     */         }
/*     */       } else {
/*     */         boolean bool;
/* 562 */         if (bool = ((r)f1).j()) {
/* 563 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 568 */     return false;
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
/*     */   public final void a(v paramv, j paramj) {
/* 600 */     paramj.a(paramv, aa());
/* 601 */     paramj.b(paramv, aa() + as());
/*     */   }
/*     */   
/*     */   public final void a(v paramv, boolean paramBoolean) {
/* 605 */     if (!paramv.D()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     aa aa;
/* 610 */     if ((aa = paramv.p().a((d)paramv, this)) != null) {
/*     */ 
/*     */ 
/*     */       
/* 614 */       if (paramBoolean = (paramBoolean || aa() + as() >= aa.a() - paramv.z())) {
/* 615 */         a(paramv, c.c, false);
/* 616 */         B(); return;
/* 617 */       }  if (aa.b() + paramv.A() > aa()) {
/* 618 */         int i = aa.b() + paramv.A() - aa();
/*     */         
/* 620 */         o(an() + i);
/* 621 */         B();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final t m() {
/* 627 */     return this.l;
/*     */   }
/*     */   
/*     */   private void b(t paramt) {
/* 631 */     this.l = paramt;
/*     */   }
/*     */   
/*     */   public final void a(byte paramByte) {
/* 635 */     this.m = paramByte;
/*     */   }
/*     */   
/*     */   public final boolean n() {
/* 639 */     return (this.m == 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */