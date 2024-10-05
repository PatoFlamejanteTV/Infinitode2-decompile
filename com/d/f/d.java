/*      */ package com.d.f;
/*      */ 
/*      */ import com.d.c.f.a.h;
/*      */ import com.d.c.f.i;
/*      */ import com.d.e.v;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.c;
/*      */ import com.d.i.f;
/*      */ import com.d.i.i;
/*      */ import com.d.i.j;
/*      */ import com.d.m.l;
/*      */ import java.awt.Rectangle;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class d
/*      */   extends c
/*      */ {
/*   52 */   private final List a = new ArrayList();
/*      */   
/*      */   private int[] b;
/*      */   
/*      */   private d c;
/*      */   
/*      */   private List d;
/*      */   
/*      */   private int e;
/*      */   
/*      */   private boolean f;
/*      */   private j g;
/*      */   private int h;
/*      */   private int i;
/*      */   
/*      */   public final boolean b() {
/*   68 */     return this.f;
/*      */   }
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/*   72 */     this.f = true;
/*      */   }
/*      */   
/*      */   public final c c() {
/*      */     d d1;
/*   77 */     (d1 = new d()).a(a());
/*   78 */     d1.a(ai());
/*      */     
/*   80 */     return d1;
/*      */   }
/*      */   
/*      */   public final void a(h paramh) {
/*   84 */     if (this.d == null) {
/*   85 */       this.d = new ArrayList();
/*      */     }
/*   87 */     this.d.add(paramh);
/*      */   }
/*      */   
/*      */   public final List d() {
/*   91 */     return (this.d == null) ? Collections.EMPTY_LIST : this.d;
/*      */   }
/*      */   
/*      */   public final int[] e() {
/*   95 */     return com.d.m.a.a(this.b);
/*      */   }
/*      */   
/*      */   private void a(int[] paramArrayOfint) {
/*   99 */     this.b = paramArrayOfint;
/*      */   }
/*      */   
/*      */   public final int f() {
/*  103 */     return this.a.size();
/*      */   }
/*      */   
/*      */   public final int a(int paramInt) {
/*  107 */     return ((b)this.a.get(paramInt)).a();
/*      */   }
/*      */   
/*      */   public final int b(int paramInt) {
/*  111 */     int i = 0;
/*  112 */     byte b = 0;
/*  113 */     while (i < paramInt && b < f()) {
/*  114 */       i += a(b);
/*  115 */       b++;
/*      */     } 
/*  117 */     return b;
/*      */   }
/*      */   
/*      */   public final int c(int paramInt) {
/*  121 */     int i = 0;
/*  122 */     for (byte b = 0; b < paramInt; b++) {
/*  123 */       i += a(b);
/*      */     }
/*  125 */     return i;
/*      */   }
/*      */   
/*      */   public final void d(int paramInt) {
/*      */     b b;
/*  130 */     (b = new b()).a(paramInt);
/*      */     
/*  132 */     this.a.add(b);
/*      */     
/*  134 */     for (Iterator<j> iterator = W(); iterator.hasNext();)
/*      */     {
/*  136 */       (j1 = iterator.next()).a(this.a.size());
/*      */     }
/*      */   }
/*      */   
/*      */   public final void a(com.d.c.f.c paramc) {
/*  141 */     super.a(paramc);
/*      */     
/*  143 */     if (b()) {
/*  144 */       this.c = new c(this); return;
/*  145 */     }  if (a().a(com.d.c.a.a.am, com.d.c.a.c.e) || a().H()) {
/*  146 */       this.c = new a(this); return;
/*      */     } 
/*  148 */     this.c = new b(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(v paramv) {
/*  153 */     if (!J()) {
/*  154 */       f(paramv);
/*  155 */       if (a().am()) {
/*  156 */         g(paramv);
/*      */       }
/*  158 */       this.c.a(paramv);
/*  159 */       f(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(int paramInt1, int paramInt2) {
/*      */     b b;
/*  165 */     (b = new b()).a(paramInt2);
/*  166 */     this.a.add(paramInt1, b);
/*      */ 
/*      */     
/*  169 */     (b = this.a.get(paramInt1 + 1)).a(b.a() - paramInt2);
/*      */     
/*  171 */     for (Iterator<j> iterator = W(); iterator.hasNext();)
/*      */     {
/*  173 */       (j1 = iterator.next()).b(paramInt1);
/*      */     }
/*      */   }
/*      */   
/*      */   public final int a(com.d.c.f.d paramd, boolean paramBoolean) {
/*  178 */     int i = 0;
/*  179 */     h h = n(paramd);
/*  180 */     if (!paramBoolean || !a().K()) {
/*  181 */       i = 0 + (int)h.w();
/*      */     }
/*  183 */     if (!paramBoolean || !a().L()) {
/*  184 */       i += (int)h.u();
/*      */     }
/*  186 */     com.d.c.f.a.a a = b(paramd);
/*  187 */     i += (int)a.w() + (int)a.u();
/*  188 */     if (!a().am()) {
/*  189 */       h h1 = o(paramd);
/*  190 */       int k = a().f(paramd);
/*  191 */       i = (int)(i + h1.w() + h1.u() + ((f() + 1) * k));
/*      */     } 
/*  193 */     return i;
/*      */   }
/*      */   
/*      */   public final List g() {
/*  197 */     return this.a;
/*      */   }
/*      */   
/*      */   private void f(v paramv) {
/*  201 */     l(paramv);
/*  202 */     for (Iterator<j> iterator = W(); iterator.hasNext();)
/*      */     {
/*  204 */       (j1 = iterator.next()).e(paramv);
/*      */     }
/*      */   }
/*      */   
/*      */   private void g(v paramv) {
/*  209 */     l(paramv);
/*  210 */     for (Iterator<j> iterator = W(); iterator.hasNext();)
/*      */     {
/*  212 */       (j1 = iterator.next()).f(paramv);
/*      */     }
/*      */   }
/*      */   
/*      */   protected final boolean h() {
/*  217 */     return false;
/*      */   }
/*      */   
/*      */   public final void b(v paramv) {
/*  221 */     a(paramv);
/*  222 */     k(paramv);
/*  223 */     p();
/*  224 */     z(paramv);
/*      */ 
/*      */ 
/*      */     
/*  228 */     if (!au()) {
/*  229 */       g(false);
/*  230 */       d(paramv, d_());
/*      */     } 
/*      */     
/*  233 */     this.c.b(paramv);
/*      */     
/*  235 */     A(paramv);
/*      */     
/*  237 */     v(paramv);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(v paramv, int paramInt, h paramh, com.d.c.f.a.a parama) {
/*  246 */     if (I() <= d_() + a((com.d.c.f.d)paramv, true)) {
/*  247 */       super.a(paramv, paramInt, paramh, parama); return;
/*      */     } 
/*  249 */     if (a().K()) {
/*  250 */       e((com.d.c.f.d)paramv, 0);
/*      */     }
/*  252 */     if (a().L()) {
/*  253 */       f((com.d.c.f.d)paramv, 0);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void v(v paramv) {
/*  259 */     boolean bool = (paramv.r() && a().as()) ? true : false;
/*  260 */     int i = 0;
/*  261 */     int k = 0;
/*      */     
/*  263 */     if (bool) {
/*  264 */       i = paramv.A();
/*  265 */       k = paramv.z();
/*      */       
/*  267 */       paramv.b(paramv.A() + 
/*  268 */           (int)o((com.d.c.f.d)paramv).t() + 
/*  269 */           (int)b((com.d.c.f.d)paramv).t() + 
/*  270 */           a().g((com.d.c.f.d)paramv));
/*  271 */       paramv.a(paramv.z() + 
/*  272 */           (int)o((com.d.c.f.d)paramv).v() + 
/*  273 */           (int)b((com.d.c.f.d)paramv).v() + 
/*  274 */           a().g((com.d.c.f.d)paramv));
/*      */     } 
/*      */     
/*  277 */     super.b(paramv);
/*      */     
/*  279 */     if (bool) {
/*  280 */       if (o()) {
/*  281 */         y(paramv);
/*      */         
/*  283 */         w(0);
/*  284 */         x(0);
/*      */       } else {
/*  286 */         w(paramv.A() - i);
/*  287 */         x(paramv.z() - k);
/*      */       } 
/*  289 */       paramv.b(i);
/*  290 */       paramv.a(k);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected final void a(v paramv, int paramInt) {
/*  295 */     l(paramv);
/*      */     
/*      */     int i;
/*  298 */     if (i = (paramv.r() && a().as()) ? 1 : 0) {
/*  299 */       i = w(paramv);
/*      */       int k;
/*  301 */       byte b = ((k = x(paramv)) == 0) ? 0 : a().g((com.d.c.f.d)paramv);
/*      */       
/*  303 */       aa aa = paramv.p().a((com.d.c.f.d)paramv, (f)this);
/*  304 */       if (aa() + ao() + i + k + b > aa.a())
/*      */       {
/*      */ 
/*      */         
/*  308 */         e(true);
/*      */       }
/*      */     } 
/*  311 */     super.a(paramv, paramInt);
/*      */   }
/*      */   
/*      */   private int w(v paramv) {
/*  315 */     int i = 0; j j1;
/*  316 */     if (V() > 0 && (
/*      */       
/*  318 */       j1 = (j)k(0)).q()) {
/*  319 */       paramv.c(paramv.C() + 1);
/*      */       
/*  321 */       j1.r(paramv);
/*  322 */       j1.b(paramv);
/*      */       
/*  324 */       paramv.b(paramv.A() + j1.as());
/*      */       
/*  326 */       i = j1.as();
/*      */       
/*  328 */       j1.c(paramv);
/*      */       
/*  330 */       paramv.c(paramv.C() - 1);
/*      */     } 
/*      */ 
/*      */     
/*  334 */     return i;
/*      */   }
/*      */   
/*      */   private int x(v paramv) {
/*  338 */     int i = 0; j j1;
/*  339 */     if (V() > 0 && (
/*      */       
/*  341 */       j1 = (j)k(V() - 1)).p()) {
/*  342 */       paramv.c(paramv.C() + 1);
/*      */       
/*  344 */       j1.r(paramv);
/*  345 */       j1.b(paramv);
/*      */       
/*  347 */       paramv.a(paramv.z() + j1
/*  348 */           .as() + 
/*  349 */           a().g((com.d.c.f.d)paramv));
/*      */       
/*  351 */       i = j1.as();
/*      */       
/*  353 */       j1.c(paramv);
/*      */       
/*  355 */       paramv.c(paramv.C() - 1);
/*      */     } 
/*      */     
/*  358 */     return i;
/*      */   }
/*      */   
/*      */   private boolean o() {
/*  362 */     f f = U();
/*  363 */     while (f != null) {
/*  364 */       if (f.a().q() && f.a().as()) {
/*  365 */         return false;
/*      */       }
/*      */       
/*  368 */       f = f.U();
/*      */     } 
/*      */     
/*  371 */     return true;
/*      */   }
/*      */   
/*      */   private void y(v paramv) {
/*  375 */     a(paramv, (j)null);
/*      */   }
/*      */   
/*      */   public final void a(v paramv, j paramj) {
/*  379 */     this.g = new j(paramv, aa());
/*  380 */     this.g.a(paramj);
/*      */     
/*  382 */     if (paramj != null) {
/*  383 */       paramj.a(paramv, aa());
/*  384 */       paramj.b(paramv, aa() + as());
/*      */     } 
/*      */     
/*  387 */     for (Iterator<f> iterator = W(); iterator.hasNext();)
/*      */     {
/*  389 */       (f = iterator.next()).a(paramv, this.g);
/*      */     }
/*      */     
/*  392 */     if (paramj != null && this.g.c() && (
/*  393 */       q() > 0 || r() > 0)) {
/*  394 */       a(paramv, paramj, this.g, q(), r());
/*      */     }
/*      */   }
/*      */   
/*      */   public final void b(ab paramab) {
/*  399 */     if (this.g == null) {
/*  400 */       super.b(paramab); return;
/*  401 */     }  if (a().a(paramab, (f)this)) {
/*  402 */       paramab.p().a(paramab, 
/*  403 */           a(), i(paramab), j((com.d.c.f.d)paramab), 
/*  404 */           a().a((com.d.c.f.d)paramab));
/*      */     }
/*      */   }
/*      */   
/*      */   public final void c(ab paramab) {
/*  409 */     if (this.g == null) {
/*  410 */       super.c(paramab); return;
/*  411 */     }  if (a().a(paramab, (f)this))
/*  412 */       paramab.p().a(paramab, a(), i(paramab), ad()); 
/*      */   }
/*      */   
/*      */   private Rectangle i(ab paramab) {
/*      */     int k, m;
/*  417 */     Rectangle rectangle = j((com.d.c.f.d)paramab);
/*      */     
/*      */     i i;
/*      */     
/*  421 */     if ((i = this.g.a(paramab.t())) == null) {
/*  422 */       l.g(Level.WARNING, "No content limit found");
/*  423 */       return rectangle;
/*      */     } 
/*  425 */     if (i.a() == -1 || i
/*  426 */       .b() == -1) {
/*  427 */       return rectangle;
/*      */     }
/*      */     
/*  430 */     h h = o((com.d.c.f.d)paramab);
/*  431 */     com.d.c.f.a.a a = b((com.d.c.f.d)paramab);
/*      */ 
/*      */     
/*  434 */     if (paramab.t() == this.g.a()) {
/*  435 */       k = rectangle.y;
/*      */     } else {
/*      */       
/*  438 */       k = i.a() - (int)h.t() - (int)a.t() - a().g((com.d.c.f.d)paramab); j j1;
/*  439 */       if (V() > 0 && (
/*      */         
/*  441 */         j1 = (j)k(0)).q()) {
/*  442 */         k -= j1.as();
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  448 */     if (paramab.t() == this.g.b()) {
/*  449 */       m = rectangle.y + rectangle.height;
/*      */     } else {
/*      */       
/*  452 */       m = i.b() + (int)h.v() + (int)a.v() + a().g((com.d.c.f.d)paramab); j j1;
/*  453 */       if (V() > 0 && (
/*      */         
/*  455 */         j1 = (j)k(V() - 1)).p()) {
/*  456 */         m += j1.as();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  461 */     rectangle.y = k;
/*  462 */     rectangle.height = m - k;
/*      */     
/*  464 */     return rectangle;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(ab paramab) {
/*      */     i i;
/*  471 */     if ((i = this.g.a(paramab.t())) != null) {
/*  472 */       a(paramab, i);
/*  473 */       b(paramab, i);
/*      */     } 
/*      */   }
/*      */   private void a(ab paramab, i parami) {
/*      */     j j1;
/*  478 */     if ((parami.a() != -1 || paramab
/*  479 */       .t() == this.g.a()) && 
/*  480 */       V() > 0 && (
/*      */       
/*  482 */       j1 = (j)k(0)).q()) {
/*  483 */       if (!j1.r()) {
/*  484 */         j1.c(j1.aa());
/*  485 */         j1.d(true);
/*      */       } 
/*      */ 
/*      */       
/*  489 */       if (paramab.t() == this.g.a()) {
/*  490 */         k = j1.s();
/*      */       }
/*      */       else {
/*      */         
/*  494 */         k = k.a() - a().g((com.d.c.f.d)paramab) - j1.as();
/*      */       } 
/*      */       
/*      */       int k;
/*      */       
/*  499 */       if ((k = k - j1.aa()) != 0) {
/*  500 */         j1.o(j1.an() + k);
/*  501 */         j1.B();
/*  502 */         j1.C();
/*  503 */         j1.c((com.d.c.f.d)paramab, false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(ab paramab, i parami) {
/*      */     j j1;
/*  511 */     if ((parami.b() != -1 || paramab
/*  512 */       .t() == this.g.b()) && 
/*  513 */       V() > 0 && (
/*      */       
/*  515 */       j1 = (j)k(V() - 1)).p()) {
/*  516 */       if (!j1.r()) {
/*  517 */         j1.c(j1.aa());
/*  518 */         j1.d(true);
/*      */       } 
/*      */ 
/*      */       
/*  522 */       if (paramab.t() == this.g.b()) {
/*  523 */         k = j1.s();
/*      */       } else {
/*  525 */         k = k.b();
/*      */       } 
/*      */       
/*      */       int k;
/*      */       
/*  530 */       if ((k = k - j1.aa()) != 0) {
/*  531 */         j1.o(j1.an() + k);
/*  532 */         j1.B();
/*  533 */         j1.C();
/*  534 */         j1.c((com.d.c.f.d)paramab, false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void z(v paramv) {
/*      */     aa aa;
/*      */     i i;
/*  542 */     if (paramv.r() && a().am() && (
/*      */       
/*  544 */       aa = paramv.p().a((com.d.c.f.d)paramv, (f)this)) != null && (
/*      */       
/*  546 */       i = i()) != null) {
/*  547 */       int m = 0;
/*  548 */       for (Iterator<f> iterator = i.W(); iterator.hasNext();) {
/*      */ 
/*      */ 
/*      */         
/*  552 */         if ((i1 = (int)(a = (f = iterator.next()).p()).t() / 2) > m) {
/*  553 */           m = i1;
/*      */         }
/*      */       } 
/*      */       
/*  557 */       int k = aa() + (int)n((com.d.c.f.d)paramv).t() - m;
/*      */       int n;
/*  559 */       if ((n = aa.b() - k) > 0) {
/*  560 */         o(an() + n);
/*  561 */         v(n);
/*  562 */         B();
/*  563 */         paramv.a(0, n);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void p() {
/*  571 */     if (I() > Q()) {
/*  572 */       u(d_() + I() - Q()); return;
/*  573 */     }  if (a().a(com.d.c.a.a.ax, com.d.c.a.c.e) && 
/*  574 */       H() < Q()) {
/*  575 */       u(d_() - Q() - H());
/*      */     }
/*      */   }
/*      */   
/*      */   public final i i() {
/*  580 */     for (Iterator<j> iterator = W(); iterator.hasNext();) {
/*      */       
/*  582 */       if ((j1 = iterator.next()).V() > 0) {
/*  583 */         return (i)j1.k(0);
/*      */       }
/*      */     } 
/*      */     
/*  587 */     return null;
/*      */   }
/*      */   
/*      */   public final i j() {
/*  591 */     for (Iterator<j> iterator = W(); iterator.hasNext();) {
/*      */       
/*  593 */       if (!(j1 = iterator.next()).q() && !j1.p())
/*      */       {
/*      */         
/*  596 */         if (j1.V() > 0) {
/*  597 */           return (i)j1.k(0);
/*      */         }
/*      */       }
/*      */     } 
/*  601 */     return null;
/*      */   }
/*      */   
/*      */   private void A(v paramv) {
/*  605 */     for (Iterator<c> iterator = W(); iterator.hasNext();) {
/*      */       
/*  607 */       if ((c1 = iterator.next()).a().t()) {
/*  608 */         ((j)c1).g(paramv);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected final void a(v paramv, com.d.c.f.a.a parama, h paramh1, h paramh2) {
/*  615 */     super.a(paramv, parama, paramh1, paramh2);
/*      */     
/*  617 */     if (V() > 0) {
/*  618 */       t(as() + a().g((com.d.c.f.d)paramv));
/*      */     }
/*      */   }
/*      */   
/*      */   public final void c(v paramv) {
/*  623 */     super.c(paramv);
/*      */     
/*  625 */     this.g = null;
/*      */     
/*  627 */     this.c.a();
/*      */   }
/*      */   
/*      */   protected final int a(com.d.c.f.d paramd) {
/*  631 */     if (a().H()) {
/*  632 */       return -1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  637 */     int i = (int)a().b(com.d.c.a.a.ax, 
/*  638 */         Y().d_(), paramd);
/*      */     
/*  640 */     com.d.c.f.a.a a = b(paramd);
/*  641 */     i -= (int)a.w() + (int)a.u();
/*  642 */     if (!a().am()) {
/*  643 */       h h = o(paramd);
/*  644 */       i -= (int)h.w() + (int)h.u();
/*      */     } 
/*      */     
/*  647 */     return (i >= 0) ? i : -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public final h e(int paramInt) {
/*      */     List<?> list;
/*  653 */     if ((list = d()).size() == 0) {
/*  654 */       return null;
/*      */     }
/*  656 */     int i = 0;
/*  657 */     for (Iterator<?> iterator = list.iterator(); iterator.hasNext(); ) {
/*      */       h h;
/*  659 */       int k = (h = (h)iterator.next()).a().ao();
/*      */       
/*  661 */       if ((i = i + k) > paramInt) {
/*  662 */         return h;
/*      */       }
/*      */     } 
/*  665 */     return null;
/*      */   }
/*      */   
/*      */   public final Rectangle a(com.d.c.f.d paramd, int paramInt) {
/*  669 */     paramInt = b(paramInt);
/*      */     
/*  671 */     int i = a().f(paramd);
/*  672 */     int k = a().g(paramd);
/*      */     
/*      */     Rectangle rectangle;
/*      */     
/*  676 */     (rectangle = c(ab(), aa(), paramd)).y += k;
/*  677 */     rectangle.height -= k << 1;
/*      */     
/*  679 */     rectangle.x += this.b[paramInt] + i;
/*      */     
/*  681 */     return rectangle;
/*      */   }
/*      */   
/*      */   public final com.d.c.f.a.a b(com.d.c.f.d paramd) {
/*  685 */     if (a().am()) {
/*  686 */       return com.d.c.f.a.a.a;
/*      */     }
/*  688 */     return super.b(paramd);
/*      */   }
/*      */   
/*      */   public final int c(com.d.c.f.d paramd) {
/*      */     int i;
/*  693 */     if (!au() && (
/*      */       
/*  695 */       i = h(paramd)) != -1) {
/*  696 */       return aa() + i - 
/*  697 */         (int)b(paramd).v() - (int)o(paramd).v() - 
/*  698 */         a().g(paramd);
/*      */     }
/*      */ 
/*      */     
/*  702 */     return -1;
/*      */   }
/*      */   
/*      */   protected final boolean k() {
/*  706 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static j a(j paramj, boolean paramBoolean) {
/*  713 */     if ((paramj = (j)paramj.S()) == null) {
/*  714 */       return null;
/*      */     }
/*      */     
/*  717 */     while (paramj != null && 
/*  718 */       paramj.g() <= 0 && paramBoolean)
/*      */     {
/*      */       
/*  721 */       paramj = (j)paramj.S();
/*      */     }
/*      */     
/*  724 */     return paramj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static j b(j paramj, boolean paramBoolean) {
/*  731 */     if ((paramj = (j)paramj.T()) == null) {
/*  732 */       return null;
/*      */     }
/*      */     
/*  735 */     while (paramj != null && 
/*  736 */       paramj.g() <= 0 && paramBoolean)
/*      */     {
/*      */       
/*  739 */       paramj = (j)paramj.T();
/*      */     }
/*      */     
/*  742 */     return paramj;
/*      */   }
/*      */   
/*      */   protected final f a(f paramf) {
/*      */     j j1;
/*  747 */     int i = paramf.e();
/*      */     
/*  749 */     int k = 0;
/*  750 */     if (i > 0) {
/*      */ 
/*      */       
/*  753 */       j1 = paramf.g();
/*  754 */       k = i - 1;
/*      */     
/*      */     }
/*  757 */     else if ((j1 = a(paramf.g(), true)) != null) {
/*  758 */       k = j1.g() - 1;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  764 */     if (j1 != null) {
/*  765 */       f f1; int m = b(paramf.d());
/*      */ 
/*      */       
/*      */       do {
/*  769 */         f1 = j1.a(k, m);
/*  770 */         m--;
/*  771 */       } while (f1 == f.a && m >= 0);
/*  772 */       return (f1 == f.a) ? null : f1;
/*      */     } 
/*  774 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final f b(f paramf) {
/*      */     j j1;
/*  780 */     int i = paramf.e() + paramf.a().an() - 1;
/*      */     
/*  782 */     int k = 0;
/*  783 */     if (i < paramf.g().g() - 1) {
/*      */ 
/*      */       
/*  786 */       j1 = paramf.g();
/*  787 */       k = i + 1;
/*      */     
/*      */     }
/*  790 */     else if ((j1 = b(paramf.g(), true)) != null) {
/*  791 */       k = 0;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  796 */     if (j1 != null) {
/*  797 */       f f1; int m = b(paramf.d());
/*      */ 
/*      */       
/*      */       do {
/*  801 */         f1 = j1.a(k, m);
/*  802 */         m--;
/*  803 */       } while (f1 == f.a && m >= 0);
/*  804 */       return (f1 == f.a) ? null : f1;
/*      */     } 
/*  806 */     return null;
/*      */   }
/*      */   
/*      */   protected final f c(f paramf) {
/*      */     f f1;
/*  811 */     j j1 = paramf.g();
/*      */     int i;
/*  813 */     if ((i = b(paramf.d())) == 0) {
/*  814 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     do {
/*  820 */       f1 = j1.a(paramf.e(), i - 1);
/*  821 */       i--;
/*  822 */     } while (f1 == f.a && i >= 0);
/*  823 */     return (f1 == f.a) ? null : f1;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final f d(f paramf) {
/*      */     int i;
/*  829 */     if ((i = b(paramf.d() + paramf.a().ao())) >= f()) {
/*  830 */       return null;
/*      */     }
/*      */     
/*  833 */     return ((paramf = paramf.g().a(paramf.e(), i)) == f.a) ? null : paramf;
/*      */   }
/*      */   
/*      */   public final int d(com.d.c.f.d paramd) {
/*  837 */     int i = 0;
/*  838 */     boolean bool = false;
/*      */     
/*  840 */     for (Iterator<j> iterator = W(); iterator.hasNext();) {
/*      */       
/*  842 */       if ((iterator1 = (j1 = iterator.next()).W()).hasNext()) {
/*  843 */         i i1 = (i)iterator1.next();
/*  844 */         bool = true;
/*  845 */         int k = i1.aa() + i1.d() - aa();
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  850 */     if (!bool) {
/*  851 */       i = as();
/*      */     }
/*      */     
/*  854 */     return i;
/*      */   }
/*      */   
/*      */   protected final int l() {
/*  858 */     return this.e;
/*      */   }
/*      */   
/*      */   private void v(int paramInt) {
/*  862 */     this.e = paramInt;
/*      */   }
/*      */   
/*      */   public final boolean m() {
/*  866 */     return (this.g != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean e(ab paramab) {
/*  873 */     return (m() && this.g.a() == paramab.t());
/*      */   }
/*      */   
/*      */   private int q() {
/*  877 */     return this.h;
/*      */   }
/*      */   
/*      */   private void w(int paramInt) {
/*  881 */     this.h = paramInt;
/*      */   }
/*      */   
/*      */   private int r() {
/*  885 */     return this.i;
/*      */   }
/*      */   
/*      */   private void x(int paramInt) {
/*  889 */     this.i = paramInt;
/*      */   }
/*      */   
/*      */   static interface d
/*      */   {
/*      */     void a(v param1v);
/*      */     
/*      */     void b(v param1v);
/*      */     
/*      */     void a();
/*      */   }
/*      */   
/*      */   static class c
/*      */     extends a
/*      */   {
/*      */     public c(d param1d) {
/*  905 */       super(param1d);
/*      */     }
/*      */     
/*      */     protected final int c() {
/*  909 */       return 0;
/*      */     }
/*      */     
/*      */     public final void a(v param1v) {
/*  913 */       super.a(param1v);
/*      */       
/*      */       d.a.a arrayOfA[], a1;
/*      */       
/*  917 */       if ((arrayOfA = b()).length == 3 && (
/*      */ 
/*      */         
/*  920 */         !(a1 = arrayOfA[1]).a().c() || a1.d() != 0L)) {
/*  921 */         if (arrayOfA[0].c() > arrayOfA[2].c()) {
/*  922 */           arrayOfA[2] = arrayOfA[0]; return;
/*  923 */         }  if (arrayOfA[2].c() > arrayOfA[0].c()) {
/*  924 */           arrayOfA[0] = arrayOfA[2];
/*      */           return;
/*      */         } 
/*  927 */         (a1 = new d.a.a()).a(Math.max(arrayOfA[0].c(), arrayOfA[2].c()));
/*  928 */         a1.c(a1.c());
/*  929 */         a1.b(Math.max(arrayOfA[0].d(), arrayOfA[2].d()));
/*  930 */         a1.d(a1.d());
/*      */         
/*  932 */         arrayOfA[0] = a1;
/*  933 */         arrayOfA[2] = a1;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   static class b
/*      */     implements d
/*      */   {
/*      */     private final d a;
/*      */     private List b;
/*      */     
/*      */     public b(d param1d) {
/*  945 */       this.a = param1d;
/*      */     }
/*      */     
/*      */     public final void a() {
/*  949 */       this.b = null;
/*      */     }
/*      */     
/*      */     private void b() {
/*  953 */       this.b = new ArrayList(this.a.f());
/*  954 */       for (byte b1 = 0; b1 < this.a.f(); b1++) {
/*  955 */         this.b.add(new i());
/*      */       }
/*      */     }
/*      */     
/*      */     private int c(v param1v) {
/*  960 */       b();
/*      */       
/*  962 */       d d1 = this.a;
/*      */       
/*  964 */       int i = 0;
/*  965 */       int j = d1.f();
/*  966 */       int k = 0;
/*      */       
/*  968 */       for (Iterator<h> iterator = d1.d().iterator(); iterator.hasNext(); ) {
/*      */         h h;
/*  970 */         int m = (h = iterator.next()).a().ao();
/*      */         i i2;
/*  972 */         if ((i2 = h.a().a((com.d.c.f.d)param1v, com.d.c.a.a.ax)).c() && h.c() != null) {
/*  973 */           i2 = h.c().a().a((com.d.c.f.d)param1v, com.d.c.a.a.ax);
/*      */         }
/*      */         
/*  976 */         long l = 0L;
/*  977 */         if (i2.d() && i2.a() > 0L)
/*      */         {
/*  979 */           l = Math.min(l = i2.a(), 1073741823L);
/*      */         }
/*      */         
/*  982 */         int n = 0;
/*  983 */         byte b1 = 0;
/*  984 */         while (n < m) {
/*  985 */           if (i + b1 >= j) {
/*  986 */             d1.d(m - n);
/*  987 */             j++;
/*  988 */             this.b.add(new i());
/*      */           } 
/*  990 */           int i3 = d1.a(i + b1);
/*  991 */           if ((i2.d() || i2.e()) && i2.a() > 0L) {
/*  992 */             this.b.set(i + b1, new i(i2.a() * i3, i2.b()));
/*  993 */             k = (int)(k + l * i3);
/*      */           } 
/*  995 */           n += i3;
/*  996 */           b1++;
/*      */         } 
/*  998 */         i += b1;
/*      */       } 
/*      */       
/* 1001 */       i = 0;
/*      */       i i1;
/* 1003 */       if ((i1 = this.a.i()) != null) {
/* 1004 */         for (Iterator<f> iterator1 = i1.W(); iterator1.hasNext(); ) {
/*      */           f f;
/* 1006 */           i i2 = (f = iterator1.next()).e((com.d.c.f.d)param1v);
/* 1007 */           int m = f.a().ao();
/* 1008 */           long l = 0L;
/* 1009 */           if (i2.d() && i2.a() > 0L) {
/* 1010 */             l = i2.a();
/*      */           }
/*      */           
/* 1013 */           int n = 0;
/* 1014 */           byte b1 = 0;
/* 1015 */           while (n < m) {
/* 1016 */             int i3 = this.a.a(i + b1);
/*      */             
/*      */             i i4;
/*      */             
/* 1020 */             if ((i4 = this.b.get(i + b1)).c() && !i2.c()) {
/* 1021 */               this.b.set(i + b1, new i(i2.a() * i3, i2.b()));
/* 1022 */               k = (int)(k + l * i3);
/*      */             } 
/*      */             
/* 1025 */             n += i3;
/* 1026 */             b1++;
/*      */           } 
/*      */           
/* 1029 */           i += b1;
/*      */         } 
/*      */       }
/*      */       
/* 1033 */       return k;
/*      */     }
/*      */     
/*      */     public final void a(v param1v) {
/* 1037 */       int j = this.a.a((com.d.c.f.d)param1v, true);
/*      */       
/* 1039 */       this.a.k(param1v);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1045 */       d.a(this.a, false);
/*      */       
/* 1047 */       int i = c(param1v) + j;
/* 1048 */       d.a(this.a, Math.max(i, this.a.Q()));
/* 1049 */       d.b(this.a, this.a.I());
/*      */       
/* 1051 */       i = 0;
/* 1052 */       for (j = 0; j < this.b.size(); j++) {
/*      */         i i1;
/* 1054 */         if (!(i1 = this.b.get(j)).d()) {
/* 1055 */           i = 1;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1060 */       if (i != 0) {
/* 1061 */         d.c(this.a, 1073741823);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public final void b(v param1v) {
/* 1067 */       int i = this.a.Q() - this.a.a((com.d.c.f.d)param1v, false), j = i;
/*      */       
/*      */       int k;
/* 1070 */       long[] arrayOfLong = new long[k = this.a.f()]; int m;
/* 1071 */       for (m = 0; m < arrayOfLong.length; m++) {
/* 1072 */         arrayOfLong[m] = -1L;
/*      */       }
/*      */ 
/*      */       
/* 1076 */       for (m = 0; m < k; m++) {
/*      */         i i1;
/* 1078 */         if ((i1 = this.b.get(m)).d()) {
/* 1079 */           arrayOfLong[m] = i1.a();
/* 1080 */           j = (int)(j - i1.a());
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1085 */       if (j > 0) {
/* 1086 */         m = 0; int i1;
/* 1087 */         for (i1 = 0; i1 < k; i1++) {
/*      */           i i2;
/* 1089 */           if ((i2 = this.b.get(i1)).e()) {
/* 1090 */             m = (int)(m + i2.a());
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1096 */         if ((i1 = i * m / 100) > j) {
/* 1097 */           i1 = j;
/*      */         }
/*      */         
/* 1100 */         for (byte b1 = 0; j > 0 && b1 < k; b1++) {
/*      */           i i2;
/* 1102 */           if ((i2 = this.b.get(b1)).e()) {
/* 1103 */             long l = i1 * i2.a() / m;
/* 1104 */             j = (int)(j - l);
/* 1105 */             arrayOfLong[b1] = l;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1111 */       if (j > 0) {
/* 1112 */         m = 0; byte b1;
/* 1113 */         for (b1 = 0; b1 < k; b1++) {
/*      */           i i1;
/* 1115 */           if ((i1 = this.b.get(b1)).c()) {
/* 1116 */             m++;
/*      */           }
/*      */         } 
/*      */         
/* 1120 */         for (b1 = 0; j > 0 && b1 < k; b1++) {
/*      */           i i1;
/* 1122 */           if ((i1 = this.b.get(b1)).c()) {
/* 1123 */             i = j / m;
/* 1124 */             j -= i;
/* 1125 */             arrayOfLong[b1] = i;
/* 1126 */             m--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1131 */       for (m = 0; m < k; m++) {
/* 1132 */         if (arrayOfLong[m] < 0L) {
/* 1133 */           arrayOfLong[m] = 0L;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1138 */       if (j > 0) {
/* 1139 */         m = k;
/*      */         
/* 1141 */         int i1 = k;
/* 1142 */         while (i1-- > 0) {
/* 1143 */           int i2 = j / m;
/* 1144 */           j -= i2;
/* 1145 */           m--;
/* 1146 */           arrayOfLong[i1] = arrayOfLong[i1] + i2;
/*      */         } 
/*      */       } 
/*      */       
/* 1150 */       m = 0;
/* 1151 */       int n = this.a.a().f((com.d.c.f.d)param1v);
/* 1152 */       int[] arrayOfInt = new int[k + 1];
/* 1153 */       for (i = 0; i < k; i++) {
/* 1154 */         arrayOfInt[i] = m;
/* 1155 */         m = (int)(m + arrayOfLong[i] + n);
/*      */       } 
/*      */       
/* 1158 */       arrayOfInt[arrayOfInt.length - 1] = m;
/*      */       
/* 1160 */       d.a(this.a, arrayOfInt);
/*      */     }
/*      */   }
/*      */   
/*      */   static class a implements d {
/*      */     private final d a;
/*      */     private a[] b;
/*      */     private List c;
/*      */     
/*      */     public a(d param1d) {
/* 1170 */       this.a = param1d;
/*      */     }
/*      */     
/*      */     public final void a() {
/* 1174 */       this.b = null;
/* 1175 */       this.c = null;
/*      */     }
/*      */     
/*      */     protected final a[] b() {
/* 1179 */       return this.b;
/*      */     }
/*      */     
/*      */     private void c(v param1v) {
/* 1183 */       this.b = new a[this.a.f()];
/* 1184 */       for (byte b1 = 0; b1 < this.b.length; b1++) {
/* 1185 */         this.b[b1] = new a();
/* 1186 */         this.b[b1].a(c());
/* 1187 */         this.b[b1].b(c());
/*      */       } 
/*      */       
/* 1190 */       this.c = new ArrayList();
/*      */       
/*      */       d d1;
/* 1193 */       int i = (d1 = this.a).f();
/*      */       
/* 1195 */       int j = 0;
/* 1196 */       for (Iterator<h> iterator = d1.d().iterator(); iterator.hasNext(); ) {
/*      */         h h;
/* 1198 */         int m = (h = iterator.next()).a().ao();
/*      */         i i1;
/* 1200 */         if ((i1 = h.a().a((com.d.c.f.d)param1v, com.d.c.a.a.ax)).c() && h.c() != null) {
/* 1201 */           i1 = h.c().a().a((com.d.c.f.d)param1v, com.d.c.a.a.ax);
/*      */         }
/*      */         
/* 1204 */         if ((i1.d() && i1.a() == 0L) || (i1.e() && i1.a() == 0L)) {
/* 1205 */           i1 = new i();
/*      */         }
/* 1207 */         int k = d1.b(j);
/* 1208 */         if (!i1.c() && m == 1 && k < i && 
/* 1209 */           d1.a(k) == 1) {
/* 1210 */           this.b[k].a(i1);
/* 1211 */           if (i1.d() && this.b[k].d() < i1.a()) {
/* 1212 */             this.b[k].b(i1.a());
/*      */           }
/*      */         } 
/*      */         
/* 1216 */         j += m;
/*      */       } 
/*      */ 
/*      */       
/* 1220 */       for (byte b2 = 0; b2 < i; b2++) {
/* 1221 */         a(param1v, b2);
/*      */       }
/*      */     }
/*      */     
/*      */     protected int c() {
/* 1226 */       return 1;
/*      */     }
/*      */     
/*      */     private void a(v param1v, int param1Int) {
/* 1230 */       a a1 = this.b[param1Int];
/*      */ 
/*      */       
/* 1233 */       for (Iterator<j> iterator = this.a.W(); iterator.hasNext(); ) {
/*      */         j j;
/* 1235 */         int i = (j = iterator.next()).g();
/* 1236 */         for (byte b = 0; b < i; b++) {
/*      */           f f;
/* 1238 */           if ((f = j.a(b, param1Int)) != f.a && f != null) {
/*      */             i i1;
/*      */             
/* 1241 */             if (f.a().ao() == 1) {
/*      */ 
/*      */               
/* 1244 */               a1.a(Math.max(a1.c(), c()));
/* 1245 */               a1.b(Math.max(a1.d(), c()));
/*      */               
/* 1247 */               f.a(param1v);
/* 1248 */               if (f.I() > a1.c()) {
/* 1249 */                 a1.a(f.I());
/*      */               }
/* 1251 */               if (f.H() > a1.d()) {
/* 1252 */                 a1.b(f.H());
/*      */               }
/*      */ 
/*      */               
/* 1256 */               (i1 = f.f((com.d.c.f.d)param1v)).a(Math.min(1073741823L, Math.max(0L, i1.a())));
/*      */               
/* 1258 */               switch (i1.b()) {
/*      */                 case 2:
/* 1260 */                   if (i1.a() > 0L && !a1.a().e()) {
/* 1261 */                     if (a1.a().d()) {
/* 1262 */                       if (i1.a() > a1.a().a()) {
/* 1263 */                         a1.a().a(i1.a());
/*      */                       }
/*      */                     } else {
/* 1266 */                       a1.a(i1);
/*      */                     } 
/* 1268 */                     if (i1.a() > a1.d()) {
/* 1269 */                       a1.b(i1.a());
/*      */                     }
/*      */                   } 
/*      */                   break;
/*      */                 case 3:
/* 1274 */                   if (i1.a() > 0L && (
/* 1275 */                     !a1.a().e() || i1.a() > a1.a().a())) {
/* 1276 */                     a1.a(i1);
/*      */                   }
/*      */                   break;
/*      */               } 
/*      */             
/* 1281 */             } else if (param1Int == 0 || j.a(b, param1Int - 1) != i1) {
/*      */ 
/*      */               
/* 1284 */               a1.a(Math.max(a1.c(), c()));
/* 1285 */               a1.b(Math.max(a1.d(), c()));
/*      */               
/* 1287 */               this.c.add(i1);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1293 */       a1.b(Math.max(a1.d(), a1.c()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private long d(v param1v) {
/* 1301 */       long l = 0L;
/*      */       
/*      */       a[] arrayOfA;
/*      */       
/* 1305 */       int i = (arrayOfA = this.b).length;
/* 1306 */       int j = this.a.a().f((com.d.c.f.d)param1v);
/*      */       
/* 1308 */       for (byte b = 0; b < i; b++) {
/* 1309 */         arrayOfA[b].b(arrayOfA[b].a());
/* 1310 */         arrayOfA[b].c(arrayOfA[b].c());
/* 1311 */         arrayOfA[b].d(arrayOfA[b].d());
/*      */       } 
/*      */       
/* 1314 */       Collections.sort(this.c, new e(this));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1323 */       for (Iterator<f> iterator = this.c.iterator(); iterator.hasNext(); ) {
/*      */         f f;
/*      */         
/* 1326 */         (f = iterator.next()).a(param1v);
/*      */         
/* 1328 */         int m = f.a().ao();
/*      */         i i1;
/* 1330 */         if ((i1 = f.f((com.d.c.f.d)param1v)).a() == 0L) {
/* 1331 */           i1 = new i();
/*      */         }
/*      */ 
/*      */         
/* 1335 */         int n = this.a.b(f.d()), i2 = n;
/* 1336 */         int i3 = f.I() + j;
/* 1337 */         int k = f.H() + j;
/* 1338 */         int i4 = 0;
/* 1339 */         int i5 = 0;
/* 1340 */         int i6 = 0;
/* 1341 */         boolean bool1 = true;
/* 1342 */         boolean bool2 = true;
/* 1343 */         boolean bool3 = false;
/* 1344 */         int i7 = 0;
/*      */         
/* 1346 */         while (i2 < i && m > 0) {
/* 1347 */           switch (arrayOfA[i2].a().b()) {
/*      */             case 3:
/* 1349 */               i4 = (int)(i4 + arrayOfA[i2].a().a());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1376 */               bool2 = false; break;case 2: if (arrayOfA[i2].a().a() > 0L) { i7 = (int)(i7 + arrayOfA[i2].a().a()); bool1 = false; break; } case 1: bool3 = true;default: if (!arrayOfA[i2].b().e()) { arrayOfA[i2].b(new i()); bool1 = false; } else { i4 = (int)(i4 + arrayOfA[i2].b().a()); }  bool2 = false;
/*      */               break;
/*      */           } 
/* 1379 */           m -= this.a.a(i2);
/* 1380 */           i5 = (int)(i5 + arrayOfA[i2].e());
/* 1381 */           i6 = (int)(i6 + arrayOfA[i2].f());
/* 1382 */           i2++;
/* 1383 */           i3 -= j;
/* 1384 */           k -= j;
/*      */         } 
/*      */ 
/*      */         
/* 1388 */         if (i1.e()) {
/* 1389 */           if (i4 > i1.a() || bool1) {
/*      */             
/* 1391 */             i1 = new i();
/*      */           } else {
/* 1393 */             m = Math.max(i6, k);
/* 1394 */             l = Math.max(l, (m * 100) / i1.a());
/*      */ 
/*      */ 
/*      */             
/* 1398 */             long l1 = i1.a() - i4;
/* 1399 */             int i8 = 0; int i9;
/* 1400 */             for (i9 = n; i9 < i2; i9++) {
/* 1401 */               if (!arrayOfA[i9].a().e()) {
/* 1402 */                 i8 = (int)(i8 + arrayOfA[i9].f());
/*      */               }
/*      */             } 
/*      */             
/* 1406 */             for (i9 = n; i9 < i2 && i8 > 0; i9++) {
/* 1407 */               if (!arrayOfA[i9].a().e()) {
/* 1408 */                 long l2 = l1 * arrayOfA[i9].f() / i8;
/*      */                 
/* 1410 */                 i8 = (int)(i8 - arrayOfA[i9].f());
/* 1411 */                 l1 -= l2;
/* 1412 */                 if (l2 > 0L) {
/* 1413 */                   arrayOfA[i9].b(new i(l2, 3));
/*      */                 } else {
/*      */                   
/* 1416 */                   arrayOfA[i9].b(new i());
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/* 1424 */         if (i3 > i5) {
/* 1425 */           if (bool2) {
/* 1426 */             for (m = n; i7 > 0 && m < i2; m++) {
/* 1427 */               long l1 = Math.max(arrayOfA[m].e(), i3 * arrayOfA[m]
/* 1428 */                   .a().a() / i7);
/* 1429 */               i7 = (int)(i7 - arrayOfA[m].a().a());
/* 1430 */               i3 = (int)(i3 - l1);
/* 1431 */               arrayOfA[m].c(l1);
/*      */             } 
/* 1433 */           } else if (bool1) {
/* 1434 */             m = i6;
/* 1435 */             int i8 = i5;
/* 1436 */             int i9 = i3;
/*      */             
/* 1438 */             for (int i10 = n; m > 0 && i10 < i2; i10++) {
/* 1439 */               if (arrayOfA[i10].b().e() && arrayOfA[i10]
/* 1440 */                 .b().a() > 0L && i7 <= i3) {
/*      */ 
/*      */                 
/* 1443 */                 long l1 = Math.max(l1 = arrayOfA[i10].e(), i9 * arrayOfA[i10]
/* 1444 */                     .b().a() / i4);
/* 1445 */                 l1 = Math.min(arrayOfA[i10].e() + (i3 - i8), l1);
/*      */                 
/* 1447 */                 m = (int)(m - arrayOfA[i10].f());
/* 1448 */                 i8 = (int)(i8 - arrayOfA[i10].e());
/* 1449 */                 i3 = (int)(i3 - l1);
/* 1450 */                 arrayOfA[i10].c(l1);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 1454 */             m = i6;
/* 1455 */             int i8 = i5;
/*      */             
/*      */             int i9;
/*      */             
/* 1459 */             for (i9 = n; m > 0 && i9 < i2; i9++) {
/* 1460 */               if (arrayOfA[i9].a().d() && bool3 && i7 <= i3) {
/*      */                 
/* 1462 */                 long l1 = Math.max(arrayOfA[i9].e(), arrayOfA[i9]
/* 1463 */                     .a().a());
/* 1464 */                 i7 = (int)(i7 - arrayOfA[i9].a().a());
/* 1465 */                 i8 = (int)(i8 - arrayOfA[i9].e());
/* 1466 */                 m = (int)(m - arrayOfA[i9].f());
/* 1467 */                 i3 = (int)(i3 - l1);
/* 1468 */                 arrayOfA[i9].c(l1);
/*      */               } 
/*      */             } 
/*      */             
/* 1472 */             for (i9 = n; m > 0 && i9 < i2 && i8 < i3; i9++) {
/* 1473 */               if (!arrayOfA[i9].a().d() || !bool3 || i7 > i3) {
/* 1474 */                 long l1 = Math.max(arrayOfA[i9].e(), i3 * arrayOfA[i9]
/* 1475 */                     .f() / m);
/* 1476 */                 l1 = Math.min(arrayOfA[i9].e() + (i3 - i8), l1);
/*      */ 
/*      */                 
/* 1479 */                 m = (int)(m - arrayOfA[i9].f());
/* 1480 */                 i8 = (int)(i8 - arrayOfA[i9].e());
/* 1481 */                 i3 = (int)(i3 - l1);
/* 1482 */                 arrayOfA[i9].c(l1);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */         
/* 1488 */         if (!i1.e()) {
/* 1489 */           if (k > i6)
/* 1490 */             for (m = n; i6 > 0 && m < i2; m++) {
/* 1491 */               long l1 = Math.max(arrayOfA[m].f(), k * arrayOfA[m]
/* 1492 */                   .f() / i6);
/* 1493 */               i6 = (int)(i6 - arrayOfA[m].f());
/* 1494 */               k = (int)(k - l1);
/* 1495 */               arrayOfA[m].d(l1);
/*      */             }  
/*      */           continue;
/*      */         } 
/* 1499 */         for (m = n; m < i2; m++) {
/* 1500 */           arrayOfA[m].b(Math.max(arrayOfA[m].d(), arrayOfA[m]
/* 1501 */                 .c()));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1506 */       return l;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void a(v param1v) {
/* 1514 */       d d1 = this.a;
/*      */       
/* 1516 */       c(param1v);
/*      */       
/* 1518 */       a[] arrayOfA = this.b;
/*      */       
/* 1520 */       long l1 = d(param1v);
/* 1521 */       long l2 = 0L;
/* 1522 */       long l3 = 0L;
/* 1523 */       long l4 = 0L;
/* 1524 */       long l5 = 0L;
/*      */       
/* 1526 */       int i = 100; int j;
/* 1527 */       for (j = 0; j < arrayOfA.length; j++) {
/* 1528 */         l2 += arrayOfA[j].e();
/* 1529 */         l3 += arrayOfA[j].f();
/* 1530 */         if (arrayOfA[j].b().e()) {
/* 1531 */           long l6 = Math.min(arrayOfA[j].b().a(), i);
/* 1532 */           long l7 = arrayOfA[j].f() * 100L / Math.max(l6, 1L);
/* 1533 */           i = (int)(i - l6);
/* 1534 */           l4 = Math.max(l7, l4);
/*      */         } else {
/* 1536 */           l5 += arrayOfA[j].f();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1546 */       l3 = Math.max(l3 = Math.max(l3 = Math.max(l5 = (l5 * 100L + 50L) / Math.max(i, 1), l3), l4), l1);
/*      */       
/* 1548 */       j = d1.a((com.d.c.f.d)param1v, true);
/* 1549 */       l2 += j;
/* 1550 */       l3 += j;
/*      */       
/*      */       i i1;
/* 1553 */       if ((i1 = d1.a().a((com.d.c.f.d)param1v, com.d.c.a.a.ax)).d() && i1.a() > 0L) {
/* 1554 */         d1.k(param1v);
/* 1555 */         int k = d1.d_() + d1.a((com.d.c.f.d)param1v, true);
/*      */         
/* 1557 */         l3 = l2 = Math.max(l2, k);
/*      */       } 
/*      */       
/* 1560 */       d.d(d1, (int)Math.min(l3, 1073741823L));
/* 1561 */       d.e(d1, (int)Math.min(l2, 1073741823L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void b(v param1v) {
/*      */       d d1;
/* 1570 */       int j = (d1 = this.a).Q() - d1.a((com.d.c.f.d)param1v, false), k = j;
/* 1571 */       int i = d1.f();
/*      */       
/* 1573 */       boolean bool = false;
/* 1574 */       byte b1 = 0;
/* 1575 */       byte b2 = 0;
/* 1576 */       int m = 0;
/* 1577 */       int n = 0;
/* 1578 */       int i1 = 0;
/* 1579 */       int i2 = 0;
/*      */       
/* 1581 */       a[] arrayOfA = this.b;
/*      */       
/*      */       int i3;
/* 1584 */       for (i3 = 0; i3 < i; i3++) {
/* 1585 */         long l = arrayOfA[i3].e();
/* 1586 */         arrayOfA[i3].e(l);
/* 1587 */         k = (int)(k - l);
/*      */         i i5;
/* 1589 */         switch ((i5 = arrayOfA[i3].b()).b()) {
/*      */           case 3:
/* 1591 */             bool = true;
/* 1592 */             i1 = (int)(i1 + i5.a());
/*      */             break;
/*      */           case 2:
/* 1595 */             b2++;
/* 1596 */             n = (int)(n + arrayOfA[i3].f());
/*      */             break;
/*      */           
/*      */           case 1:
/* 1600 */             b1++;
/* 1601 */             m = (int)(m + arrayOfA[i3].f());
/* 1602 */             i2 = (int)(i2 + l);
/*      */             break;
/*      */         } 
/*      */       
/*      */       } 
/* 1607 */       if (k > 0 && bool) {
/* 1608 */         for (i3 = 0; i3 < i; i3++) {
/*      */           i i5;
/* 1610 */           if ((i5 = arrayOfA[i3].b()).e()) {
/* 1611 */             long l = Math.max(arrayOfA[i3].e(), i5.b(j));
/* 1612 */             k = (int)(k + arrayOfA[i3].g() - l);
/* 1613 */             arrayOfA[i3].e(l);
/*      */           } 
/*      */         } 
/* 1616 */         if (i1 > 100) {
/*      */           
/* 1618 */           i3 = j * (i1 - 100) / 100;
/* 1619 */           for (int i5 = i - 1; i5 >= 0; i5--) {
/* 1620 */             if (arrayOfA[i5].b().e()) {
/*      */               
/* 1622 */               long l1, l2 = Math.min(l1 = arrayOfA[i5].g(), i3);
/*      */ 
/*      */               
/* 1625 */               i3 = (int)(i3 - l2);
/* 1626 */               long l3 = Math.max(arrayOfA[i5].e(), l1 - l2);
/* 1627 */               k = (int)(k + l1 - l3);
/* 1628 */               arrayOfA[i5].e(l3);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1637 */       if (k > 0) {
/* 1638 */         for (i3 = 0; i3 < i; i3++) {
/*      */           i i5;
/* 1640 */           if ((i5 = arrayOfA[i3].b()).d() && i5.a() > arrayOfA[i3].g()) {
/* 1641 */             k = (int)(k + arrayOfA[i3].g() - i5.a());
/* 1642 */             arrayOfA[i3].e(i5.a());
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1648 */       if (k > 0 && b1 > 0) {
/* 1649 */         k += i2;
/*      */ 
/*      */         
/* 1652 */         for (i3 = 0; i3 < i; i3++) {
/*      */           i i5;
/* 1654 */           if ((i5 = arrayOfA[i3].b()).c() && m != 0) {
/* 1655 */             long l = Math.max(arrayOfA[i3].g(), k * arrayOfA[i3]
/* 1656 */                 .f() / m);
/* 1657 */             k = (int)(k - l);
/* 1658 */             m = (int)(m - arrayOfA[i3].f());
/* 1659 */             arrayOfA[i3].e(l);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1665 */       if (k > 0 && b2 > 0)
/*      */       {
/* 1667 */         for (i3 = 0; i3 < i; i3++) {
/*      */           i i5;
/* 1669 */           if ((i5 = arrayOfA[i3].b()).d()) {
/* 1670 */             long l = k * arrayOfA[i3].f() / n;
/* 1671 */             k = (int)(k - l);
/* 1672 */             n = (int)(n - arrayOfA[i3].f());
/* 1673 */             arrayOfA[i3].e(arrayOfA[i3].g() + l);
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1679 */       if (k > 0 && bool && i1 < 100)
/*      */       {
/*      */         
/* 1682 */         for (i3 = 0; i3 < i; i3++) {
/*      */           i i5;
/* 1684 */           if ((i5 = arrayOfA[i3].b()).e()) {
/* 1685 */             long l = k * i5.a() / i1;
/* 1686 */             k = (int)(k - l);
/* 1687 */             i1 = (int)(i1 - i5.a());
/* 1688 */             arrayOfA[i3].e(arrayOfA[i3].g() + l);
/* 1689 */             if (k != 0 && i1 != 0) {
/*      */               continue;
/*      */             }
/*      */             break;
/*      */           } 
/*      */           continue;
/*      */         } 
/*      */       }
/* 1697 */       if (k > 0) {
/* 1698 */         i3 = i;
/*      */         
/* 1700 */         int i5 = i;
/* 1701 */         while (i5-- > 0) {
/* 1702 */           int i6 = k / i3;
/* 1703 */           k -= i6;
/* 1704 */           i3--;
/* 1705 */           arrayOfA[i5].e(arrayOfA[i5].g() + i6);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1713 */       if (k < 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1720 */         if (k < 0) {
/* 1721 */           i3 = 0; int i5;
/* 1722 */           for (i5 = i - 1; i5 >= 0; i5--) {
/*      */             i i6;
/* 1724 */             if ((i6 = arrayOfA[i5].b()).c()) {
/* 1725 */               i3 = (int)(i3 + arrayOfA[i5].g() - arrayOfA[i5].e());
/*      */             }
/*      */           } 
/* 1728 */           for (i5 = i - 1; i5 >= 0 && i3 > 0; i5--) {
/*      */             i i6;
/* 1730 */             if ((i6 = arrayOfA[i5].b()).c()) {
/*      */               
/* 1732 */               long l1 = arrayOfA[i5].g() - arrayOfA[i5].e();
/* 1733 */               long l2 = k * l1 / i3;
/* 1734 */               arrayOfA[i5].e(arrayOfA[i5].g() + l2);
/* 1735 */               k = (int)(k - l2);
/* 1736 */               i3 = (int)(i3 - l1);
/* 1737 */               if (k < 0)
/*      */                 continue;  break;
/*      */             } 
/*      */             continue;
/*      */           } 
/*      */         } 
/* 1743 */         if (k < 0) {
/* 1744 */           i3 = 0; int i5;
/* 1745 */           for (i5 = i - 1; i5 >= 0; i5--) {
/*      */             i i6;
/* 1747 */             if ((i6 = arrayOfA[i5].b()).d()) {
/* 1748 */               i3 = (int)(i3 + arrayOfA[i5].g() - arrayOfA[i5].e());
/*      */             }
/*      */           } 
/* 1751 */           for (i5 = i - 1; i5 >= 0 && i3 > 0; i5--) {
/*      */             i i6;
/* 1753 */             if ((i6 = arrayOfA[i5].b()).d()) {
/*      */               
/* 1755 */               long l1 = arrayOfA[i5].g() - arrayOfA[i5].e();
/* 1756 */               long l2 = k * l1 / i3;
/* 1757 */               arrayOfA[i5].e(arrayOfA[i5].g() + l2);
/* 1758 */               k = (int)(k - l2);
/* 1759 */               i3 = (int)(i3 - l1);
/* 1760 */               if (k < 0)
/*      */                 continue;  break;
/*      */             } 
/*      */             continue;
/*      */           } 
/*      */         } 
/* 1766 */         if (k < 0) {
/* 1767 */           i3 = 0; int i5;
/* 1768 */           for (i5 = i - 1; i5 >= 0; i5--) {
/*      */             i i6;
/* 1770 */             if ((i6 = arrayOfA[i5].b()).e()) {
/* 1771 */               i3 = (int)(i3 + arrayOfA[i5].g() - arrayOfA[i5].e());
/*      */             }
/*      */           } 
/* 1774 */           for (i5 = i - 1; i5 >= 0 && i3 > 0; i5--) {
/*      */             i i6;
/* 1776 */             if ((i6 = arrayOfA[i5].b()).e()) {
/*      */               
/* 1778 */               long l1 = arrayOfA[i5].g() - arrayOfA[i5].e();
/* 1779 */               long l2 = k * l1 / i3;
/* 1780 */               arrayOfA[i5].e(arrayOfA[i5].g() + l2);
/* 1781 */               k = (int)(k - l2);
/* 1782 */               i3 = (int)(i3 - l1);
/* 1783 */               if (k < 0)
/*      */                 continue;  break;
/*      */             } 
/*      */             continue;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1790 */       i3 = 0;
/* 1791 */       int i4 = this.a.a().f((com.d.c.f.d)param1v);
/* 1792 */       int[] arrayOfInt = new int[i + 1];
/* 1793 */       for (byte b3 = 0; b3 < i; b3++) {
/* 1794 */         arrayOfInt[b3] = i3;
/* 1795 */         i3 = (int)(i3 + arrayOfA[b3].g() + i4);
/*      */       } 
/*      */       
/* 1798 */       arrayOfInt[arrayOfInt.length - 1] = i3;
/*      */       
/* 1800 */       d.a(this.a, arrayOfInt);
/*      */     }
/*      */     
/*      */     public static class a {
/* 1804 */       private i a = new i();
/* 1805 */       private i b = new i();
/* 1806 */       private long c = 1L;
/* 1807 */       private long d = 1L;
/* 1808 */       private long e = 0L;
/* 1809 */       private long f = 0L;
/* 1810 */       private long g = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final i a() {
/* 1816 */         return this.a;
/*      */       }
/*      */       
/*      */       public final void a(i param2i) {
/* 1820 */         this.a = param2i;
/*      */       }
/*      */       
/*      */       public final i b() {
/* 1824 */         return this.b;
/*      */       }
/*      */       
/*      */       public final void b(i param2i) {
/* 1828 */         this.b = param2i;
/*      */       }
/*      */       
/*      */       public final long c() {
/* 1832 */         return this.c;
/*      */       }
/*      */       
/*      */       public final void a(long param2Long) {
/* 1836 */         this.c = param2Long;
/*      */       }
/*      */       
/*      */       public final long d() {
/* 1840 */         return this.d;
/*      */       }
/*      */       
/*      */       public final void b(long param2Long) {
/* 1844 */         this.d = param2Long;
/*      */       }
/*      */       
/*      */       public final long e() {
/* 1848 */         return this.e;
/*      */       }
/*      */       
/*      */       public final void c(long param2Long) {
/* 1852 */         this.e = param2Long;
/*      */       }
/*      */       
/*      */       public final long f() {
/* 1856 */         return this.f;
/*      */       }
/*      */       
/*      */       public final void d(long param2Long) {
/* 1860 */         this.f = param2Long;
/*      */       }
/*      */       
/*      */       public final long g() {
/* 1864 */         return this.g;
/*      */       }
/*      */       
/*      */       public final void e(long param2Long) {
/* 1868 */         this.g = param2Long;
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\f\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */