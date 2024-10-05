/*      */ package com.a.a.c.f;
/*      */ 
/*      */ import com.a.a.a.b;
/*      */ import com.a.a.a.i;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k.a.d;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.q;
/*      */ import com.a.a.c.w;
/*      */ import com.a.a.c.x;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
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
/*      */ public final class ae
/*      */ {
/*      */   private q<?> a;
/*      */   private a b;
/*      */   private boolean c;
/*      */   private j d;
/*      */   private d e;
/*      */   private ap<?> f;
/*      */   private a g;
/*      */   private boolean h;
/*      */   private boolean i;
/*      */   private LinkedHashMap<String, af> j;
/*      */   private LinkedList<af> k;
/*      */   private Map<w, w> l;
/*      */   private LinkedList<j> m;
/*      */   private LinkedList<j> n;
/*      */   private LinkedList<k> o;
/*      */   private LinkedList<j> p;
/*      */   private LinkedList<j> q;
/*      */   private LinkedList<j> r;
/*      */   private HashSet<String> s;
/*      */   private LinkedHashMap<Object, j> t;
/*      */   
/*      */   protected ae(q<?> paramq, boolean paramBoolean, j paramj, d paramd, a parama) {
/*  168 */     this.a = paramq;
/*  169 */     this.c = paramBoolean;
/*  170 */     this.d = paramj;
/*  171 */     this.e = paramd;
/*  172 */     if (paramq.f()) {
/*  173 */       this.h = true;
/*  174 */       this.g = this.a.j();
/*      */     } else {
/*  176 */       this.h = false;
/*  177 */       this.g = a.a();
/*      */     } 
/*  179 */     this.f = this.a.a(paramj.b(), paramd);
/*      */     
/*  181 */     this.b = parama;
/*      */ 
/*      */     
/*  184 */     paramq.a(q.z);
/*      */   }
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
/*      */   public final q<?> a() {
/*  216 */     return this.a;
/*      */   }
/*      */   
/*      */   public final j b() {
/*  220 */     return this.d;
/*      */   }
/*      */   
/*      */   public final d c() {
/*  224 */     return this.e;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<s> d() {
/*  233 */     Map<String, af> map = n();
/*  234 */     return new ArrayList<>(map.values());
/*      */   }
/*      */   
/*      */   public final Map<Object, j> e() {
/*  238 */     if (!this.i) {
/*  239 */       o();
/*      */     }
/*  241 */     return this.t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j f() {
/*  248 */     if (!this.i) {
/*  249 */       o();
/*      */     }
/*      */     
/*  252 */     if (this.q != null) {
/*  253 */       if (this.q.size() > 1) {
/*  254 */         a("Multiple 'as-key' properties defined (%s vs %s)", new Object[] { this.q
/*  255 */               .get(0), this.q
/*  256 */               .get(1) });
/*      */       }
/*      */       
/*  259 */       return this.q.get(0);
/*      */     } 
/*  261 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j g() {
/*  269 */     if (!this.i) {
/*  270 */       o();
/*      */     }
/*      */     
/*  273 */     if (this.r != null) {
/*  274 */       if (this.r.size() > 1) {
/*  275 */         a("Multiple 'as-value' properties defined (%s vs %s)", new Object[] { this.r
/*  276 */               .get(0), this.r
/*  277 */               .get(1) });
/*      */       }
/*      */       
/*  280 */       return this.r.get(0);
/*      */     } 
/*  282 */     return null;
/*      */   }
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
/*      */   public final j h() {
/*  301 */     if (!this.i) {
/*  302 */       o();
/*      */     }
/*  304 */     if (this.n != null) {
/*  305 */       if (this.n.size() > 1) {
/*  306 */         a("Multiple 'any-getter' fields defined (%s vs %s)", new Object[] { this.n
/*  307 */               .get(0), this.n.get(1) });
/*      */       }
/*  309 */       return this.n.getFirst();
/*      */     } 
/*  311 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j i() {
/*  319 */     if (!this.i) {
/*  320 */       o();
/*      */     }
/*  322 */     if (this.m != null) {
/*  323 */       if (this.m.size() > 1) {
/*  324 */         a("Multiple 'any-getter' methods defined (%s vs %s)", new Object[] { this.m
/*  325 */               .get(0), this.m.get(1) });
/*      */       }
/*  327 */       return this.m.getFirst();
/*      */     } 
/*  329 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final j j() {
/*  334 */     if (!this.i) {
/*  335 */       o();
/*      */     }
/*  337 */     if (this.p != null) {
/*  338 */       if (this.p.size() > 1) {
/*  339 */         a("Multiple 'any-setter' fields defined (%s vs %s)", new Object[] { this.p
/*  340 */               .get(0), this.p.get(1) });
/*      */       }
/*  342 */       return this.p.getFirst();
/*      */     } 
/*  344 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final k k() {
/*  349 */     if (!this.i) {
/*  350 */       o();
/*      */     }
/*  352 */     if (this.o != null) {
/*  353 */       if (this.o.size() > 1) {
/*  354 */         a("Multiple 'any-setter' methods defined (%s vs %s)", new Object[] { this.o
/*  355 */               .get(0), this.o.get(1) });
/*      */       }
/*  357 */       return this.o.getFirst();
/*      */     } 
/*  359 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Set<String> l() {
/*  367 */     return this.s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ad m() {
/*      */     ad ad;
/*  377 */     if ((ad = this.g.a(this.e)) != null) {
/*  378 */       ad = this.g.a(this.e, ad);
/*      */     }
/*  380 */     return ad;
/*      */   }
/*      */ 
/*      */   
/*      */   private Map<String, af> n() {
/*  385 */     if (!this.i) {
/*  386 */       o();
/*      */     }
/*  388 */     return this.j;
/*      */   }
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
/*      */   private void o() {
/*  418 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*      */ 
/*      */     
/*  421 */     a((Map)linkedHashMap);
/*  422 */     c((Map)linkedHashMap);
/*      */ 
/*      */     
/*  425 */     if (!this.e.m()) {
/*  426 */       b((Map)linkedHashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  431 */     d((Map)linkedHashMap);
/*      */     
/*  433 */     e((Map)linkedHashMap);
/*      */ 
/*      */     
/*  436 */     f((Map)linkedHashMap);
/*      */ 
/*      */ 
/*      */     
/*  440 */     p();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  445 */     for (Iterator<af> iterator1 = linkedHashMap.values().iterator(); iterator1.hasNext();) {
/*  446 */       (af = iterator1.next()).a(this.c);
/*      */     }
/*      */ 
/*      */     
/*      */     x x;
/*      */ 
/*      */     
/*  453 */     if ((x = q()) != null) {
/*  454 */       a((Map)linkedHashMap, x);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  459 */     for (Iterator<af> iterator2 = linkedHashMap.values().iterator(); iterator2.hasNext();) {
/*  460 */       (af = iterator2.next()).J();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  465 */     if (this.a.a(q.y)) {
/*  466 */       g((Map)linkedHashMap);
/*      */     }
/*      */ 
/*      */     
/*  470 */     h((Map)linkedHashMap);
/*  471 */     this.j = (LinkedHashMap)linkedHashMap;
/*  472 */     this.i = true;
/*      */   }
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
/*      */   private void a(Map<String, af> paramMap) {
/*  486 */     a a1 = this.g;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  491 */     boolean bool = (!this.c && !this.a.a(q.j)) ? true : false;
/*  492 */     boolean bool1 = this.a.a(q.c);
/*      */     
/*  494 */     for (h h : this.e.l()) {
/*      */       
/*  496 */       if (Boolean.TRUE.equals(a1.w(h))) {
/*  497 */         if (this.q == null) {
/*  498 */           this.q = new LinkedList<>();
/*      */         }
/*  500 */         this.q.add(h);
/*      */       } 
/*      */       
/*  503 */       if (Boolean.TRUE.equals(a1.x(h))) {
/*  504 */         if (this.r == null) {
/*  505 */           this.r = new LinkedList<>();
/*      */         }
/*  507 */         this.r.add(h);
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  512 */       boolean bool2 = Boolean.TRUE.equals(a1.y(h));
/*  513 */       boolean bool3 = Boolean.TRUE.equals(a1.E(h));
/*  514 */       if (bool2 || bool3) {
/*      */         
/*  516 */         if (bool2) {
/*  517 */           if (this.n == null) {
/*  518 */             this.n = new LinkedList<>();
/*      */           }
/*  520 */           this.n.add(h);
/*      */         } 
/*      */         
/*  523 */         if (bool3) {
/*  524 */           if (this.p == null) {
/*  525 */             this.p = new LinkedList<>();
/*      */           }
/*  527 */           this.p.add(h);
/*      */         } 
/*      */         continue;
/*      */       } 
/*      */       String str;
/*  532 */       if ((str = a1.g(h)) == null) {
/*  533 */         str = h.b();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  538 */       if ((str = this.b.b(str)) != null) {
/*      */ 
/*      */ 
/*      */         
/*  542 */         w w1 = b(str);
/*      */ 
/*      */         
/*      */         w w2;
/*      */         
/*  547 */         if ((w2 = a1.c()) != null && !w2.equals(w1)) {
/*  548 */           if (this.l == null) {
/*  549 */             this.l = new HashMap<>();
/*      */           }
/*  551 */           this.l.put(w2, w1);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  556 */         if (this.c) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  561 */           w1 = a1.v(h);
/*      */         } else {
/*  563 */           w1 = a1.D(h);
/*      */         } 
/*      */         
/*      */         boolean bool4, bool5;
/*      */         
/*  568 */         if ((bool5 = bool4 = (w1 != null) ? true : false) && w1.e()) {
/*  569 */           w1 = b(str);
/*  570 */           bool5 = false;
/*      */         } 
/*      */         
/*      */         boolean bool6;
/*  574 */         if (!(bool6 = (w1 != null))) {
/*  575 */           bool6 = this.f.a(h);
/*      */         }
/*      */         
/*  578 */         boolean bool7 = a1.d(h);
/*      */ 
/*      */         
/*  581 */         if (h.g())
/*      */         {
/*      */           
/*  584 */           if (!bool4) {
/*  585 */             bool6 = false;
/*  586 */             if (bool1) {
/*  587 */               bool7 = true;
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  596 */         if (!bool || w1 != null || bool7 || 
/*  597 */           !Modifier.isFinal(h.f()))
/*      */         {
/*      */           
/*  600 */           a(paramMap, str).a(h, w1, bool5, bool6, bool7);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(Map<String, af> paramMap) {
/*  610 */     if (!this.h) {
/*      */       return;
/*      */     }
/*  613 */     for (f f : this.e.i()) {
/*  614 */       if (this.k == null)
/*  615 */         this.k = new LinkedList<>();  byte b;
/*      */       int i;
/*  617 */       for (b = 0, i = f.f(); b < i; b++) {
/*  618 */         a(paramMap, f.c(b));
/*      */       }
/*      */     } 
/*  621 */     for (k k : this.e.j()) {
/*  622 */       if (this.k == null)
/*  623 */         this.k = new LinkedList<>();  byte b;
/*      */       int i;
/*  625 */       for (b = 0, i = k.f(); b < i; b++) {
/*  626 */         a(paramMap, k.c(b));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Map<String, af> paramMap, n paramn) {
/*      */     String str;
/*  639 */     if ((str = this.g.g(paramn)) == null) {
/*  640 */       str = "";
/*      */     }
/*      */     w w;
/*      */     boolean bool;
/*  644 */     if (!(bool = ((w = this.g.D(paramn)) != null && !w.e()) ? true : false)) {
/*  645 */       if (str.isEmpty()) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/*      */       i.a a1;
/*      */ 
/*      */       
/*  653 */       if ((a1 = this.g.a(this.a, paramn.e())) == null || a1 == i.a.d) {
/*      */         return;
/*      */       }
/*  656 */       w = w.a(str);
/*      */     } 
/*      */ 
/*      */     
/*  660 */     str = c(str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     af af;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  671 */     (af = (bool && str.isEmpty()) ? a(paramMap, w) : a(paramMap, str)).a(paramn, w, bool, true, false);
/*  672 */     this.k.add(af);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(Map<String, af> paramMap) {
/*  680 */     for (Iterator<k> iterator = this.e.k().iterator(); iterator.hasNext(); ) {
/*      */       k k;
/*      */ 
/*      */       
/*      */       int i;
/*      */ 
/*      */       
/*  687 */       if ((i = (k = iterator.next()).f()) == 0) {
/*  688 */         a(paramMap, k, this.g); continue;
/*  689 */       }  if (i == 1) {
/*  690 */         b(paramMap, k, this.g); continue;
/*  691 */       }  if (i == 2 && 
/*  692 */         Boolean.TRUE.equals(this.g.E(k))) {
/*  693 */         if (this.o == null) {
/*  694 */           this.o = new LinkedList<>();
/*      */         }
/*  696 */         this.o.add(k);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Map<String, af> paramMap, k paramk, a parama) {
/*      */     boolean bool1;
/*      */     Class<?> clazz;
/*  709 */     if ((clazz = paramk.m()) == void.class || (clazz == Void.class && 
/*  710 */       !this.a.a(q.m))) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  717 */     if (Boolean.TRUE.equals(parama.y(paramk))) {
/*  718 */       if (this.m == null) {
/*  719 */         this.m = new LinkedList<>();
/*      */       }
/*  721 */       this.m.add(paramk);
/*      */       
/*      */       return;
/*      */     } 
/*  725 */     if (Boolean.TRUE.equals(parama.w(paramk))) {
/*  726 */       if (this.q == null) {
/*  727 */         this.q = new LinkedList<>();
/*      */       }
/*  729 */       this.q.add(paramk);
/*      */       
/*      */       return;
/*      */     } 
/*  733 */     if (Boolean.TRUE.equals(parama.x(paramk))) {
/*  734 */       if (this.r == null) {
/*  735 */         this.r = new LinkedList<>();
/*      */       }
/*  737 */       this.r.add(paramk);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     w w;
/*      */     
/*      */     boolean bool2;
/*      */     
/*  746 */     if (!(bool2 = ((w = parama.v(paramk)) != null) ? true : false)) {
/*      */       
/*  748 */       if ((str = parama.g(paramk)) == null) {
/*  749 */         str = this.b.b(paramk, paramk.b());
/*      */       }
/*  751 */       if (str == null) {
/*      */         
/*  753 */         if ((str = this.b.a(paramk, paramk.b())) == null) {
/*      */           return;
/*      */         }
/*  756 */         bool1 = this.f.b(paramk);
/*      */       } else {
/*  758 */         bool1 = this.f.a(paramk);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  763 */       if ((str = parama.g(paramk)) == null && (
/*      */         
/*  765 */         str = this.b.b(paramk, paramk.b())) == null) {
/*  766 */         str = this.b.a(paramk, paramk.b());
/*      */       }
/*      */ 
/*      */       
/*  770 */       if (str == null) {
/*  771 */         str = paramk.b();
/*      */       }
/*  773 */       if (w.e()) {
/*      */         
/*  775 */         w = b(str);
/*  776 */         bool2 = false;
/*      */       } 
/*  778 */       bool1 = true;
/*      */     } 
/*      */     
/*  781 */     String str = c(str);
/*  782 */     boolean bool = parama.d(paramk);
/*  783 */     a(paramMap, str).a(paramk, w, bool2, bool1, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(Map<String, af> paramMap, k paramk, a parama) {
/*      */     boolean bool1;
/*      */     w w;
/*      */     boolean bool2;
/*  793 */     if (!(bool2 = ((w = parama.D(paramk)) != null) ? true : false)) {
/*      */       
/*  795 */       if ((str = parama.g(paramk)) == null) {
/*  796 */         str = this.b.a(paramk.b());
/*      */       }
/*  798 */       if (str == null) {
/*      */         return;
/*      */       }
/*  801 */       bool1 = this.f.c(paramk);
/*      */     }
/*      */     else {
/*      */       
/*  805 */       if ((str = parama.g(paramk)) == null) {
/*  806 */         str = this.b.a(paramk.b());
/*      */       }
/*      */       
/*  809 */       if (str == null) {
/*  810 */         str = paramk.b();
/*      */       }
/*  812 */       if (w.e()) {
/*      */         
/*  814 */         w = b(str);
/*  815 */         bool2 = false;
/*      */       } 
/*  817 */       bool1 = true;
/*      */     } 
/*      */     
/*  820 */     String str = c(str);
/*  821 */     boolean bool = parama.d(paramk);
/*  822 */     a(paramMap, str)
/*  823 */       .b(paramk, w, bool2, bool1, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void p() {
/*  829 */     for (h h : this.e.l()) {
/*  830 */       a(this.g.e(h), h);
/*      */     }
/*      */     
/*  833 */     for (Iterator<k> iterator = this.e.k().iterator(); iterator.hasNext();) {
/*      */       
/*  835 */       if ((k = iterator.next()).f() == 1)
/*      */       {
/*      */         
/*  838 */         a(this.g.e(k), k);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(b.a parama, j paramj) {
/*  844 */     if (parama == null) {
/*      */       return;
/*      */     }
/*  847 */     Object object = parama.a();
/*  848 */     if (this.t == null) {
/*  849 */       this.t = new LinkedHashMap<>();
/*      */     }
/*      */     j j1;
/*  852 */     if ((j1 = this.t.put(object, paramj)) != null)
/*      */     {
/*  854 */       if (j1.getClass() == paramj.getClass()) {
/*  855 */         String str = object.getClass().getName();
/*  856 */         throw new IllegalArgumentException("Duplicate injectable value with id '" + object + "' (of type " + str + ")");
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static w b(String paramString) {
/*  863 */     return w.a(paramString, null);
/*      */   }
/*      */   
/*      */   private String c(String paramString) {
/*      */     w w;
/*  868 */     if (this.l != null && (
/*      */       
/*  870 */       w = this.l.get(b(paramString))) != null)
/*      */     {
/*  872 */       return paramString = w.b();
/*      */     }
/*      */ 
/*      */     
/*  876 */     return paramString;
/*      */   }
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
/*      */   private void d(Map<String, af> paramMap) {
/*  891 */     Iterator<af> iterator = paramMap.values().iterator();
/*  892 */     while (iterator.hasNext()) {
/*      */       af af;
/*      */ 
/*      */       
/*  896 */       if (!(af = iterator.next()).K()) {
/*  897 */         iterator.remove();
/*      */         
/*      */         continue;
/*      */       } 
/*  901 */       if (af.L()) {
/*      */ 
/*      */ 
/*      */         
/*  905 */         if (!af.M()) {
/*  906 */           iterator.remove();
/*  907 */           a(af.a());
/*      */           
/*      */           continue;
/*      */         } 
/*  911 */         af.H();
/*  912 */         if (!af.i()) {
/*  913 */           a(af.a());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(Map<String, af> paramMap) {
/*  926 */     boolean bool = this.a.a(q.k);
/*  927 */     Iterator<af> iterator = paramMap.values().iterator();
/*      */     
/*  929 */     while (iterator.hasNext()) {
/*      */       af af;
/*      */ 
/*      */ 
/*      */       
/*  934 */       (af = iterator.next()).a(bool, this.c ? null : this);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(String paramString) {
/*  945 */     if (!this.c && paramString != null) {
/*  946 */       if (this.s == null) {
/*  947 */         this.s = new HashSet<>();
/*      */       }
/*  949 */       this.s.add(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void f(Map<String, af> paramMap) {
/*  962 */     Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
/*  963 */     LinkedList<af> linkedList = null;
/*  964 */     while (iterator.hasNext()) {
/*      */       Map.Entry<?, af> entry;
/*      */       
/*      */       af af;
/*      */       
/*      */       Set<w> set;
/*      */       
/*  971 */       if (!(set = (af = (entry = iterator.next()).getValue()).N()).isEmpty()) {
/*      */ 
/*      */         
/*  974 */         iterator.remove();
/*  975 */         if (linkedList == null) {
/*  976 */           linkedList = new LinkedList();
/*      */         }
/*      */         
/*  979 */         if (set.size() == 1) {
/*  980 */           w w = set.iterator().next();
/*  981 */           linkedList.add(af.b(w));
/*      */           
/*      */           continue;
/*      */         } 
/*  985 */         linkedList.addAll(af.a(set));
/*      */       } 
/*      */     } 
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
/* 1001 */     if (linkedList != null) {
/* 1002 */       for (Iterator<af> iterator1 = linkedList.iterator(); iterator1.hasNext(); ) {
/* 1003 */         af af1; String str = (af1 = iterator1.next()).a();
/*      */         af af2;
/* 1005 */         if ((af2 = paramMap.get(str)) == null) {
/* 1006 */           paramMap.put(str, af1);
/*      */         } else {
/* 1008 */           af2.a(af1);
/*      */         } 
/*      */         
/* 1011 */         if (a(af1, this.k))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1022 */           if (this.s != null) {
/* 1023 */             this.s.remove(str);
/*      */           }
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Map<String, af> paramMap, x paramx) {
/* 1033 */     af[] arrayOfAf = (af[])paramMap.values().toArray((Object[])new af[paramMap.size()]);
/* 1034 */     paramMap.clear(); int i; byte b;
/* 1035 */     for (i = (arrayOfAf = arrayOfAf).length, b = 0; b < i; b++) {
/* 1036 */       String str1; af af1; w w = (af1 = arrayOfAf[b]).b();
/* 1037 */       String str2 = null;
/*      */ 
/*      */       
/* 1040 */       if (!af1.e() || this.a.a(q.A)) {
/* 1041 */         if (this.c) {
/* 1042 */           if (af1.D()) {
/* 1043 */             af1.n(); str2 = paramx.b(w.b());
/* 1044 */           } else if (af1.l()) {
/* 1045 */             af1.p(); str2 = paramx.a(w.b());
/*      */           }
/*      */         
/* 1048 */         } else if (af1.k()) {
/* 1049 */           af1.F(); str2 = paramx.c(w.b());
/* 1050 */         } else if (af1.m()) {
/* 1051 */           af1.q(); str2 = paramx.d(w.b());
/* 1052 */         } else if (af1.l()) {
/* 1053 */           af1.G(); str2 = paramx.a(w.b());
/* 1054 */         } else if (af1.D()) {
/*      */ 
/*      */           
/* 1057 */           af1.E(); str2 = paramx.b(w.b());
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1062 */       if (str2 != null && !w.c(str2)) {
/* 1063 */         af1 = af1.a(str2);
/* 1064 */         str1 = str2;
/*      */       } else {
/* 1066 */         str1 = str1.b();
/*      */       } 
/*      */       
/*      */       af af2;
/* 1070 */       if ((af2 = paramMap.get(str1)) == null) {
/* 1071 */         paramMap.put(str1, af1);
/*      */       } else {
/* 1073 */         af2.a(af1);
/*      */       } 
/*      */ 
/*      */       
/* 1077 */       a(af1, this.k);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void g(Map<String, af> paramMap) {
/* 1085 */     Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
/* 1086 */     LinkedList<af> linkedList = null;
/* 1087 */     while (iterator.hasNext()) {
/*      */       Map.Entry<?, af> entry;
/*      */       af af;
/*      */       j j1;
/* 1091 */       if ((j1 = (af = (entry = iterator.next()).getValue()).v()) != null) {
/*      */         w w;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1098 */         if ((w = a.b()) != null && w.c())
/*      */         {
/*      */           
/* 1101 */           if (!w.equals(af.b())) {
/* 1102 */             if (linkedList == null) {
/* 1103 */               linkedList = new LinkedList();
/*      */             }
/* 1105 */             af = af.b(w);
/* 1106 */             linkedList.add(af);
/* 1107 */             iterator.remove();
/*      */           }  } 
/*      */       } 
/*      */     } 
/* 1111 */     if (linkedList != null) {
/* 1112 */       for (Iterator<af> iterator1 = linkedList.iterator(); iterator1.hasNext(); ) {
/* 1113 */         af af1; String str = (af1 = iterator1.next()).a();
/*      */         af af2;
/* 1115 */         if ((af2 = paramMap.get(str)) == null) {
/* 1116 */           paramMap.put(str, af1); continue;
/*      */         } 
/* 1118 */         af2.a(af1);
/*      */       } 
/*      */     }
/*      */   }
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
/*      */   private void h(Map<String, af> paramMap) {
/*      */     LinkedHashMap<Object, Object> linkedHashMap1;
/*      */     a a1;
/*      */     Boolean bool;
/* 1141 */     boolean bool1 = ((bool = (a1 = this.g).u(this.e)) == null) ? this.a.h() : bool.booleanValue();
/* 1142 */     boolean bool2 = a(paramMap.values());
/*      */     
/* 1144 */     String[] arrayOfString = a1.e(this.e);
/*      */ 
/*      */     
/* 1147 */     if (!bool1 && !bool2 && this.k == null && arrayOfString == null) {
/*      */       return;
/*      */     }
/* 1150 */     int i = paramMap.size();
/*      */ 
/*      */     
/* 1153 */     if (bool1) {
/* 1154 */       TreeMap<Object, Object> treeMap = new TreeMap<>();
/*      */     } else {
/* 1156 */       linkedHashMap1 = new LinkedHashMap<>(i + i);
/*      */     } 
/*      */     
/* 1159 */     for (af af : paramMap.values()) {
/* 1160 */       linkedHashMap1.put(af.a(), af);
/*      */     }
/* 1162 */     LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<>(i + i);
/*      */     
/* 1164 */     if (arrayOfString != null) {
/* 1165 */       String[] arrayOfString1; for (int k = (arrayOfString1 = arrayOfString).length; i < k; ) { String str = arrayOfString1[i];
/*      */         af af;
/* 1167 */         if ((af = (af)linkedHashMap1.remove(str)) == null) {
/* 1168 */           for (af af1 : paramMap.values()) {
/* 1169 */             if (str.equals(af1.C())) {
/* 1170 */               af = af1;
/*      */               
/* 1172 */               str = af1.a();
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/* 1177 */         if (af != null) {
/* 1178 */           linkedHashMap2.put(str, af);
/*      */         }
/*      */         
/*      */         i++; }
/*      */     
/*      */     } 
/* 1184 */     if (bool2) {
/* 1185 */       TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 1186 */       Iterator<Map.Entry> iterator = linkedHashMap1.entrySet().iterator();
/* 1187 */       while (iterator.hasNext()) {
/*      */         Map.Entry<?, af> entry;
/*      */         af af;
/*      */         Integer integer;
/* 1191 */         if ((integer = (af = (entry = iterator.next()).getValue()).h().b()) != null) {
/* 1192 */           treeMap.put(integer, af);
/* 1193 */           iterator.remove();
/*      */         } 
/*      */       } 
/* 1196 */       for (af af : treeMap.values()) {
/* 1197 */         linkedHashMap2.put(af.a(), af);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1203 */     if (this.k != null && (!bool1 || this.a
/* 1204 */       .a(q.u))) {
/*      */       Collection collection;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1211 */       if (bool1) {
/* 1212 */         TreeMap<Object, Object> treeMap = new TreeMap<>();
/*      */         
/* 1214 */         for (af af : this.k) {
/* 1215 */           treeMap.put(af.a(), af);
/*      */         }
/* 1217 */         collection = treeMap.values();
/*      */       } else {
/* 1219 */         collection = this.k;
/*      */       } 
/* 1221 */       for (Iterator<af> iterator = collection.iterator(); iterator.hasNext(); ) {
/*      */         af af;
/*      */         
/* 1224 */         String str = (af = iterator.next()).a();
/*      */ 
/*      */         
/* 1227 */         if (linkedHashMap1.containsKey(str)) {
/* 1228 */           linkedHashMap2.put(str, af);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1233 */     linkedHashMap2.putAll(linkedHashMap1);
/* 1234 */     paramMap.clear();
/* 1235 */     paramMap.putAll(linkedHashMap2);
/*      */   }
/*      */   
/*      */   private static boolean a(Collection<af> paramCollection) {
/* 1239 */     for (Iterator<af> iterator = paramCollection.iterator(); iterator.hasNext();) {
/* 1240 */       if ((af = iterator.next()).h().c()) {
/* 1241 */         return true;
/*      */       }
/*      */     } 
/* 1244 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString, Object... paramVarArgs) {
/* 1255 */     paramString = String.format(paramString, paramVarArgs);
/*      */     
/* 1257 */     throw new IllegalArgumentException("Problem with definition of " + this.e + ": " + paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private af a(Map<String, af> paramMap, w paramw) {
/* 1262 */     String str = paramw.b();
/*      */     af af;
/* 1264 */     if ((af = paramMap.get(str)) == null) {
/* 1265 */       af = new af(this.a, this.g, this.c, paramw);
/*      */       
/* 1267 */       paramMap.put(str, af);
/*      */     } 
/* 1269 */     return af;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private af a(Map<String, af> paramMap, String paramString) {
/*      */     af af;
/* 1277 */     if ((af = paramMap.get(paramString)) == null) {
/*      */       
/* 1279 */       af = new af(this.a, this.g, this.c, w.a(paramString));
/* 1280 */       paramMap.put(paramString, af);
/*      */     } 
/* 1282 */     return af;
/*      */   }
/*      */ 
/*      */   
/*      */   private x q() {
/*      */     Object object;
/* 1288 */     if ((object = this.g.c(this.e)) == null) {
/* 1289 */       return this.a.k();
/*      */     }
/* 1291 */     if (object instanceof x) {
/* 1292 */       return (x)object;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1297 */     if (!(object instanceof Class)) {
/* 1298 */       throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + object
/* 1299 */           .getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
/*      */     }
/*      */ 
/*      */     
/* 1303 */     if ((object = object) == x.class) {
/* 1304 */       return null;
/*      */     }
/*      */     
/* 1307 */     if (!x.class.isAssignableFrom((Class<?>)object))
/* 1308 */       throw new IllegalStateException("AnnotationIntrospector returned Class " + object
/* 1309 */           .getName() + "; expected Class<PropertyNamingStrategy>"); 
/*      */     d d1;
/*      */     x x;
/* 1312 */     if ((d1 = this.a.m()) != null && (
/*      */       
/* 1314 */       x = d.l()) != null) {
/* 1315 */       return x;
/*      */     }
/*      */     
/* 1318 */     return (x)i.b((Class)object, this.a
/* 1319 */         .g());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(af paramaf, List<af> paramList) {
/* 1328 */     if (paramList != null) {
/* 1329 */       String str = paramaf.C(); byte b; int i;
/* 1330 */       for (b = 0, i = paramList.size(); b < i; b++) {
/* 1331 */         if (((af)paramList.get(b)).C().equals(str)) {
/* 1332 */           paramList.set(b, paramaf);
/* 1333 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1337 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */