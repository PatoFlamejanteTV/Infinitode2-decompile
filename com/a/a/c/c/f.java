/*      */ package com.a.a.c.c;
/*      */ import com.a.a.a.al;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.c.a.ad;
/*      */ import com.a.a.c.c.a.ae;
/*      */ import com.a.a.c.c.a.c;
/*      */ import com.a.a.c.c.a.g;
/*      */ import com.a.a.c.c.a.n;
/*      */ import com.a.a.c.c.a.s;
/*      */ import com.a.a.c.c.a.z;
/*      */ import com.a.a.c.f.ad;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i.e;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.l.b;
/*      */ import com.a.a.c.m.ac;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.r;
/*      */ import com.a.a.c.v;
/*      */ import com.a.a.c.w;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ 
/*      */ public abstract class f extends ae<Object> implements k, t, Serializable {
/*   35 */   private static w t = new w("#temporary-name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final j a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l.c u;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final x b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected k<Object> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected k<Object> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected v e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final c h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final ae[] i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected u j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Set<String> k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Set<String> l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean m;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, v> v;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient HashMap<b, k<Object>> w;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ad o;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected g p;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final s q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected f(g paramg, b paramb, c paramc, Map<String, v> paramMap, Set<String> paramSet1, boolean paramBoolean1, Set<String> paramSet2, boolean paramBoolean2) {
/*  218 */     super(paramb.a());
/*  219 */     this.a = paramb.a();
/*      */     
/*  221 */     this.b = paramg.c();
/*  222 */     this.c = null;
/*  223 */     this.d = null;
/*  224 */     this.e = null;
/*      */     
/*  226 */     this.h = paramc;
/*  227 */     this.v = paramMap;
/*  228 */     this.k = paramSet1;
/*  229 */     this.m = paramBoolean1;
/*  230 */     this.l = paramSet2;
/*      */     
/*  232 */     this.j = paramg.b();
/*  233 */     List<ae> list = paramg.d();
/*  234 */     this
/*  235 */       .i = (list == null || list.isEmpty()) ? null : list.<ae>toArray(new ae[list.size()]);
/*  236 */     this.q = paramg.e();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  243 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  249 */       .f = (this.o != null || this.b.m() || this.b.o() || !this.b.l());
/*      */ 
/*      */ 
/*      */     
/*  253 */     l.d d = paramb.a(null);
/*  254 */     this.u = d.c();
/*      */     
/*  256 */     this.n = paramBoolean2;
/*  257 */     this.g = (!this.f && this.i == null && !this.n && this.q == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected f(f paramf) {
/*  266 */     this(paramf, paramf.m);
/*      */   }
/*      */ 
/*      */   
/*      */   protected f(f paramf, boolean paramBoolean) {
/*  271 */     super(paramf.a);
/*      */     
/*  273 */     this.a = paramf.a;
/*      */     
/*  275 */     this.b = paramf.b;
/*  276 */     this.c = paramf.c;
/*  277 */     this.d = paramf.d;
/*  278 */     this.e = paramf.e;
/*      */     
/*  280 */     this.h = paramf.h;
/*  281 */     this.v = paramf.v;
/*  282 */     this.k = paramf.k;
/*  283 */     this.m = paramBoolean;
/*  284 */     this.l = paramf.l;
/*  285 */     this.j = paramf.j;
/*  286 */     this.i = paramf.i;
/*  287 */     this.q = paramf.q;
/*      */     
/*  289 */     this.f = paramf.f;
/*  290 */     this.o = paramf.o;
/*  291 */     this.n = paramf.n;
/*  292 */     this.u = paramf.u;
/*      */     
/*  294 */     this.g = paramf.g;
/*      */   }
/*      */ 
/*      */   
/*      */   protected f(f paramf, r paramr) {
/*  299 */     super(paramf.a);
/*      */     
/*  301 */     this.a = paramf.a;
/*      */     
/*  303 */     this.b = paramf.b;
/*  304 */     this.c = paramf.c;
/*  305 */     this.d = paramf.d;
/*  306 */     this.e = paramf.e;
/*      */     
/*  308 */     this.v = paramf.v;
/*  309 */     this.k = paramf.k;
/*  310 */     this.m = (paramr != null || paramf.m);
/*  311 */     this.l = paramf.l;
/*  312 */     this.j = paramf.j;
/*  313 */     this.i = paramf.i;
/*  314 */     this.q = paramf.q;
/*      */     
/*  316 */     this.f = paramf.f;
/*  317 */     ad ad1 = paramf.o;
/*      */     
/*  319 */     if (paramr != null) {
/*      */       
/*  321 */       if (ad1 != null) {
/*  322 */         ad1 = ad1.a(paramr);
/*      */       }
/*      */       
/*  325 */       this.h = paramf.h.a(paramr);
/*      */     } else {
/*  327 */       this.h = paramf.h;
/*      */     } 
/*  329 */     this.o = ad1;
/*  330 */     this.n = paramf.n;
/*  331 */     this.u = paramf.u;
/*      */ 
/*      */     
/*  334 */     this.g = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public f(f paramf, s params) {
/*  339 */     super(paramf.a);
/*  340 */     this.a = paramf.a;
/*      */     
/*  342 */     this.b = paramf.b;
/*  343 */     this.c = paramf.c;
/*  344 */     this.d = paramf.d;
/*  345 */     this.e = paramf.e;
/*      */     
/*  347 */     this.v = paramf.v;
/*  348 */     this.k = paramf.k;
/*  349 */     this.m = paramf.m;
/*  350 */     this.l = paramf.l;
/*  351 */     this.j = paramf.j;
/*  352 */     this.i = paramf.i;
/*      */     
/*  354 */     this.f = paramf.f;
/*  355 */     this.o = paramf.o;
/*  356 */     this.n = paramf.n;
/*  357 */     this.u = paramf.u;
/*      */ 
/*      */     
/*  360 */     this.q = params;
/*      */     
/*  362 */     if (params == null) {
/*  363 */       this.h = paramf.h;
/*  364 */       this.g = paramf.g;
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  370 */     u u1 = new u(params, v.a);
/*  371 */     this.h = paramf.h.a((v)u1);
/*  372 */     this.g = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f(f paramf, Set<String> paramSet1, Set<String> paramSet2) {
/*  382 */     super(paramf.a);
/*  383 */     this.a = paramf.a;
/*      */     
/*  385 */     this.b = paramf.b;
/*  386 */     this.c = paramf.c;
/*  387 */     this.d = paramf.d;
/*  388 */     this.e = paramf.e;
/*      */     
/*  390 */     this.v = paramf.v;
/*  391 */     this.k = paramSet1;
/*  392 */     this.m = paramf.m;
/*  393 */     this.l = paramSet2;
/*  394 */     this.j = paramf.j;
/*  395 */     this.i = paramf.i;
/*      */     
/*  397 */     this.f = paramf.f;
/*  398 */     this.o = paramf.o;
/*  399 */     this.n = paramf.n;
/*  400 */     this.u = paramf.u;
/*      */     
/*  402 */     this.g = paramf.g;
/*  403 */     this.q = paramf.q;
/*      */ 
/*      */ 
/*      */     
/*  407 */     this.h = paramf.h.a(paramSet1, paramSet2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected f(f paramf, c paramc) {
/*  415 */     super(paramf.a);
/*  416 */     this.a = paramf.a;
/*      */     
/*  418 */     this.b = paramf.b;
/*  419 */     this.c = paramf.c;
/*  420 */     this.d = paramf.d;
/*  421 */     this.e = paramf.e;
/*      */     
/*  423 */     this.h = paramc;
/*  424 */     this.v = paramf.v;
/*  425 */     this.k = paramf.k;
/*  426 */     this.m = paramf.m;
/*  427 */     this.l = paramf.l;
/*  428 */     this.j = paramf.j;
/*  429 */     this.i = paramf.i;
/*  430 */     this.q = paramf.q;
/*      */     
/*  432 */     this.f = paramf.f;
/*  433 */     this.o = paramf.o;
/*  434 */     this.n = paramf.n;
/*  435 */     this.u = paramf.u;
/*      */     
/*  437 */     this.g = paramf.g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract k<Object> a(r paramr);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract f a(s params);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract f a(Set<String> paramSet1, Set<String> paramSet2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract f a(boolean paramBoolean);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(c paramc) {
/*  468 */     throw new UnsupportedOperationException("Class " + getClass().getName() + " does not override `withBeanProperties()`, needs to");
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
/*      */   protected abstract f g();
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
/*      */   public final void d(g paramg) {
/*      */     v[] arrayOfV;
/*  503 */     g.a a = null;
/*      */ 
/*      */ 
/*      */     
/*  507 */     if (this.b.o()) {
/*  508 */       arrayOfV = this.b.a(paramg.c());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  513 */       if (this.k != null || this.l != null) {
/*  514 */         byte b; int i; for (b = 0, i = arrayOfV.length; b < i; b++) {
/*      */           v v1;
/*  516 */           if (n.a((v1 = arrayOfV[b]).a(), this.k, this.l)) {
/*  517 */             arrayOfV[b].f();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } else {
/*  522 */       arrayOfV = null;
/*      */     } 
/*  524 */     ad ad1 = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Iterator<v> iterator;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  534 */     for (iterator = this.h.iterator(); iterator.hasNext();) {
/*  535 */       if (!(v1 = iterator.next()).n()) {
/*      */         k<Object> k1;
/*      */         
/*  538 */         if ((k1 = a(paramg, v1)) == null) {
/*  539 */           k1 = paramg.a(v1.c());
/*      */         }
/*  541 */         v v2 = v1.a(k1);
/*  542 */         a(this.h, arrayOfV, v1, v2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  547 */     for (iterator = this.h.iterator(); iterator.hasNext(); ) {
/*      */       v v1, v2;
/*  549 */       k<Object> k2 = (v2 = v1 = iterator.next()).p();
/*  550 */       k2 = paramg.a(k2, (c)v2, v2.c());
/*  551 */       v2 = v2.a(k2);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  556 */       if (!(v2 = b(paramg, v2) instanceof m)) {
/*  557 */         v2 = a(v2);
/*      */       }
/*      */       r r;
/*      */       k<Object> k1, k3;
/*  561 */       if ((r = c(paramg, v2)) != null && (
/*      */ 
/*      */         
/*  564 */         k1 = (k3 = v2.p()).a(r)) != k3 && k1 != null) {
/*  565 */         v2 = v2.a(k1);
/*  566 */         if (ad1 == null) {
/*  567 */           ad1 = new ad();
/*      */         }
/*  569 */         ad1.a(v2);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  574 */         this.h.b(v2);
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  581 */       v v3 = v2.d();
/*  582 */       v2 = b(paramg, v2, v3);
/*      */ 
/*      */ 
/*      */       
/*  586 */       if ((v2 = d(paramg, v2)) != v1) {
/*  587 */         a(this.h, arrayOfV, v1, v2);
/*      */       }
/*      */       
/*      */       e e;
/*      */       
/*  592 */       if (v2.o() && (
/*      */         
/*  594 */         e = v2.q()).a() == af.a.d) {
/*  595 */         if (a == null) {
/*  596 */           a = g.a(this.a);
/*      */         }
/*  598 */         a.a(v2, e);
/*      */         
/*  600 */         this.h.b(v2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  606 */     if (this.j != null && !this.j.b()) {
/*  607 */       this.j = this.j.a(a(paramg, this.j
/*  608 */             .c(), this.j.a()));
/*      */     }
/*      */     
/*  611 */     if (this.b.m()) {
/*  612 */       paramg.c(); j j1;
/*  613 */       if ((j1 = this.b.p()) == null)
/*  614 */         paramg.a(this.a, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[] {
/*      */                 
/*  616 */                 i.b(this.a), i.d(this.b)
/*      */               })); 
/*  618 */       this.c = a(paramg, j1, this.b
/*  619 */           .s());
/*      */     } 
/*      */ 
/*      */     
/*  623 */     if (this.b.n()) {
/*  624 */       paramg.c(); j j1;
/*  625 */       if ((j1 = this.b.q()) == null)
/*  626 */         paramg.a(this.a, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[] {
/*      */                 
/*  628 */                 i.b(this.a), i.d(this.b)
/*      */               })); 
/*  630 */       this.d = a(paramg, j1, this.b
/*  631 */           .t());
/*      */     } 
/*      */ 
/*      */     
/*  635 */     if (arrayOfV != null) {
/*  636 */       this.e = v.a(paramg, this.b, arrayOfV, this.h);
/*      */     }
/*      */ 
/*      */     
/*  640 */     if (a != null) {
/*      */ 
/*      */       
/*  643 */       this.p = a.a(this.h);
/*      */       
/*  645 */       this.f = true;
/*      */     } 
/*      */     
/*  648 */     this.o = ad1;
/*  649 */     if (ad1 != null) {
/*  650 */       this.f = true;
/*      */     }
/*      */     
/*  653 */     this.g = (this.g && !this.f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(c paramc, v[] paramArrayOfv, v paramv1, v paramv2) {
/*  662 */     paramc.a(paramv1, paramv2);
/*      */     
/*  664 */     if (paramArrayOfv != null) {
/*      */       byte b;
/*      */       int i;
/*  667 */       for (b = 0, i = paramArrayOfv.length; b < i; b++) {
/*  668 */         if (paramArrayOfv[b] == paramv1) {
/*  669 */           paramArrayOfv[b] = paramv2;
/*      */           return;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<Object> a(g paramg, j paramj, o paramo) {
/*  691 */     c.b b = new c.b(t, paramj, null, (j)paramo, v.b);
/*      */     
/*      */     e e;
/*      */     
/*  695 */     if ((e = (e)paramj.B()) == null) {
/*  696 */       e = paramg.c().c(paramj);
/*      */     }
/*      */     
/*      */     k<Object> k1;
/*      */     
/*  701 */     if ((k1 = (k)paramj.A()) == null) {
/*  702 */       k1 = a(paramg, paramj, (c)b);
/*      */     } else {
/*  704 */       k1 = paramg.b(k1, (c)b, paramj);
/*      */     } 
/*  706 */     if (e != null) {
/*  707 */       e = e.a((c)b);
/*  708 */       return (k<Object>)new ab(e, k1);
/*      */     } 
/*  710 */     return k1;
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
/*      */   private static k<Object> a(g paramg, v paramv) {
/*      */     a a;
/*      */     Object object;
/*  728 */     if ((a = paramg.f()) != null && (
/*      */       
/*  730 */       object = a.C((b)paramv.e())) != null) {
/*      */       
/*  732 */       paramg.b(); k k2; object = (k2 = paramg.a((b)paramv.e(), object)).a();
/*      */ 
/*      */       
/*  735 */       k k1 = paramg.a((j)object);
/*  736 */       return (k<Object>)new ad(k2, (j)object, k1);
/*      */     } 
/*      */     
/*  739 */     return null;
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
/*      */   public final k<?> a(g paramg, c paramc) {
/*  753 */     s s1 = this.q;
/*      */ 
/*      */     
/*  756 */     a a = paramg.f(); j j1;
/*      */     ad ad1;
/*  758 */     if ((j1 = (j)(b(paramc, a) ? paramc.e() : null)) != null && (
/*      */       
/*  760 */       ad1 = a.a((b)j1)) != null) {
/*      */       v v1;
/*      */       j j2;
/*      */       al al;
/*  764 */       Class<am.c> clazz = (ad1 = a.a((b)j1, ad1)).d();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  769 */       an an = paramg.b((b)j1, ad1);
/*  770 */       if (clazz == am.c.class) {
/*  771 */         w w2 = ad1.b();
/*      */         
/*  773 */         if ((v1 = a(w2)) == null)
/*  774 */           return (k)paramg.a(this.a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[] {
/*      */                   
/*  776 */                   i.g(a()), i.a(w2)
/*      */                 })); 
/*  778 */         j2 = v1.c();
/*  779 */         w w1 = new w(ad1.c());
/*      */       } else {
/*  781 */         j j3 = paramg.b((Class)v1);
/*  782 */         paramg.b(); j2 = o.c(j3, al.class)[0];
/*  783 */         v1 = null;
/*  784 */         al = paramg.a((b)j1, ad1);
/*      */       } 
/*  786 */       k k1 = paramg.b(j2);
/*  787 */       s1 = s.a(j2, ad1.b(), al, k1, v1, an);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  792 */     f f1 = this;
/*  793 */     if (s1 != null && s1 != this.q) {
/*  794 */       f1 = f1.a(s1);
/*      */     }
/*      */     
/*  797 */     if (j1 != null) {
/*  798 */       f1 = a(paramg, a, f1, j1);
/*      */     }
/*      */ 
/*      */     
/*  802 */     l.d d = a(paramg, paramc, a());
/*  803 */     l.c c1 = null;
/*  804 */     if (d != null) {
/*  805 */       if (d.g())
/*  806 */         c1 = d.c(); 
/*      */       Boolean bool;
/*      */       c c2;
/*      */       c c3;
/*  810 */       if ((bool = d.a(l.a.b)) != null && (
/*      */ 
/*      */         
/*  813 */         c3 = (c2 = this.h).a(bool.booleanValue())) != c2) {
/*  814 */         f1 = f1.a(c3);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  819 */     if (c1 == null) {
/*  820 */       c1 = this.u;
/*      */     }
/*  822 */     if (c1 == l.c.d) {
/*  823 */       f1 = f1.g();
/*      */     }
/*  825 */     return (k<?>)f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private f a(g paramg, a parama, f paramf, j paramj) {
/*      */     Set<? extends String> set3;
/*  834 */     paramg.c();
/*      */ 
/*      */ 
/*      */     
/*      */     q.a a1;
/*      */ 
/*      */     
/*  841 */     if ((a1 = parama.b((b)paramj)).d() && !this.m) {
/*  842 */       paramf = paramf.a(true);
/*      */     }
/*      */     
/*  845 */     Set<? extends String> set1 = a1.c();
/*  846 */     Set<String> set = paramf.k;
/*      */ 
/*      */     
/*  849 */     if (set1.isEmpty()) {
/*  850 */       set3 = set;
/*  851 */     } else if (set == null || set.isEmpty()) {
/*  852 */       set3 = set1;
/*      */     } else {
/*      */       
/*  855 */       (set3 = new HashSet<>(set)).addAll(set1);
/*      */     } 
/*      */ 
/*      */     
/*  859 */     Set<? extends String> set2 = n.b(set1 = paramf.l, parama
/*  860 */         .c((b)paramj).b());
/*      */     
/*  862 */     if (set3 != set || set2 != set1)
/*      */     {
/*  864 */       paramf = paramf.a((Set)set3, (Set)set2);
/*      */     }
/*  866 */     return paramf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v b(g paramg, v paramv) {
/*      */     String str;
/*  878 */     if ((str = paramv.l()) == null) {
/*  879 */       return paramv;
/*      */     }
/*      */     k<Object> k1;
/*      */     v v1;
/*  883 */     if ((v1 = (k1 = paramv.p()).a(str)) == null) {
/*  884 */       return (v)paramg.a(this.a, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", new Object[] {
/*      */               
/*  886 */               i.b(str), i.b(paramv.c())
/*      */             }));
/*      */     }
/*  889 */     j j1 = this.a;
/*  890 */     j j2 = v1.c();
/*  891 */     boolean bool = paramv.c().n();
/*  892 */     if (!j2.b().isAssignableFrom(j1.b()))
/*  893 */       paramg.a(this.a, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", new Object[] {
/*      */               
/*  895 */               i.b(str), i.b(j2), j1
/*  896 */               .b().getName()
/*      */             })); 
/*  898 */     return (v)new m(paramv, str, v1, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static v a(v paramv) {
/*  908 */     ad ad1 = paramv.m();
/*      */     k<Object> k1;
/*  910 */     s s1 = ((k1 = paramv.p()) == null) ? null : k1.f();
/*  911 */     if (ad1 == null && s1 == null) {
/*  912 */       return paramv;
/*      */     }
/*  914 */     return (v)new t(paramv, ad1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private r c(g paramg, v paramv) {
/*      */     j j1;
/*      */     r r;
/*  926 */     if ((j1 = paramv.e()) != null && (
/*      */       
/*  928 */       r = paramg.f().c(j1)) != null) {
/*      */ 
/*      */       
/*  931 */       if (paramv instanceof m) {
/*  932 */         paramg.a(h(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", new Object[] { paramv
/*      */                 
/*  934 */                 .a() }));
/*      */       }
/*  936 */       return r;
/*      */     } 
/*      */     
/*  939 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v d(g paramg, v paramv) {
/*      */     Class clazz1;
/*      */     f f1;
/*      */     k<Object> k1;
/*      */     x x1;
/*      */     Class clazz2;
/*  954 */     if (k1 = paramv.p() instanceof f && 
/*      */ 
/*      */       
/*  957 */       !(x1 = (f1 = (f)k1).i()).l() && (
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  962 */       clazz2 = i.b(clazz1 = paramv.c().b())) != null && clazz2 == this.a.b()) {
/*  963 */       Constructor[] arrayOfConstructor; int i; byte b; for (i = (arrayOfConstructor = (Constructor[])clazz1.getConstructors()).length, b = 0; b < i; b++) {
/*  964 */         Constructor<?> constructor; if ((constructor = arrayOfConstructor[b]).getParameterCount() == 1) {
/*  965 */           Class[] arrayOfClass = constructor.getParameterTypes();
/*  966 */           if (clazz2.equals(arrayOfClass[0])) {
/*  967 */             if (paramg.e()) {
/*  968 */               i.a(constructor, paramg.a(q.o));
/*      */             }
/*  970 */             return (v)new j(paramv, constructor);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  977 */     return paramv;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v b(g paramg, v paramv, v paramv1) {
/*      */     n n;
/*      */     v v1;
/*      */     v.a a;
/*  987 */     if ((a = paramv1.d()) != null) {
/*      */       k<Object> k1;
/*      */       
/*      */       Boolean bool;
/*  991 */       if ((bool = (k1 = paramv.p()).a(paramg.c())) == null) {
/*      */         
/*  993 */         if (a.b) {
/*  994 */           return paramv;
/*      */         }
/*  996 */       } else if (!bool.booleanValue()) {
/*  997 */         if (!a.b)
/*      */         {
/*      */           
/* 1000 */           paramg.a(k1);
/*      */         }
/* 1002 */         return paramv;
/*      */       } 
/*      */       
/*      */       j j1;
/* 1006 */       (j1 = a.a).a(paramg.a(q.o));
/* 1007 */       if (!(paramv instanceof com.a.a.c.c.a.aa)) {
/* 1008 */         n = n.a(paramv, j1);
/*      */       }
/*      */     } 
/*      */     
/*      */     s s1;
/*      */     
/* 1014 */     if ((s1 = a(paramg, (v)n, paramv1)) != null) {
/* 1015 */       v1 = n.a(s1);
/*      */     }
/* 1017 */     return v1;
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
/*      */   public final a e() {
/* 1035 */     return a.c;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object c(g paramg) {
/*      */     try {
/* 1042 */       return this.b.a(paramg);
/* 1043 */     } catch (IOException iOException) {
/* 1044 */       return i.a(paramg, iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean c() {
/* 1055 */     return true;
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
/*      */   public Boolean a(com.a.a.c.f paramf) {
/* 1075 */     return Boolean.TRUE;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Class<?> a() {
/* 1080 */     return this.a.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final s f() {
/* 1090 */     return this.q;
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
/*      */   public final Collection<Object> d() {
/* 1110 */     ArrayList<String> arrayList = new ArrayList();
/* 1111 */     for (v v1 : this.h) {
/* 1112 */       arrayList.add(v1.a());
/*      */     }
/* 1114 */     return (Collection)arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j h() {
/* 1124 */     return this.a;
/*      */   }
/*      */   
/*      */   public final com.a.a.c.l.f b() {
/* 1128 */     return com.a.a.c.l.f.d;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v a(w paramw) {
/* 1164 */     return j(paramw.b());
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
/*      */   private v j(String paramString) {
/*      */     v v1;
/* 1178 */     if ((v1 = (v)((this.h == null) ? null : this.h.a(paramString))) == null && this.e != null) {
/* 1179 */       v1 = this.e.a(paramString);
/*      */     }
/* 1181 */     return v1;
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
/*      */   public final v a(String paramString) {
/* 1211 */     if (this.v == null) {
/* 1212 */       return null;
/*      */     }
/* 1214 */     return this.v.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public final x i() {
/* 1219 */     return this.b;
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
/*      */   public abstract Object b(l paraml, g paramg);
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
/*      */   public final Object a(l paraml, g paramg, e parame) {
/*      */     Object object;
/* 1265 */     if (this.q != null) {
/*      */       Object object1;
/* 1267 */       if (paraml.S() && (
/*      */         
/* 1269 */         object1 = paraml.U()) != null) {
/* 1270 */         object = parame.a(paraml, paramg);
/* 1271 */         return a(paraml, paramg, object, object1);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1276 */       if ((object1 = paraml.k()) != null) {
/*      */         
/* 1278 */         if (object1.g()) {
/* 1279 */           return f(paraml, paramg);
/*      */         }
/*      */         
/* 1282 */         if (object1 == o.b) {
/* 1283 */           object1 = paraml.g();
/*      */         }
/* 1285 */         if (object1 == o.f && this.q.c() && this.q
/* 1286 */           .a(paraml.v(), paraml)) {
/* 1287 */           return f(paraml, paramg);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1292 */     return object.a(paraml, paramg);
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
/*      */   protected final Object a(l paraml, g paramg, Object paramObject1, Object paramObject2) {
/*      */     Object object;
/*      */     k<Object> k1;
/* 1311 */     if ((k1 = this.q.a()).a() == paramObject2.getClass()) {
/*      */       
/* 1313 */       object = paramObject2;
/*      */     } else {
/* 1315 */       object = a((l)object, paramg, paramObject2, k1);
/*      */     } 
/*      */     
/*      */     z z;
/* 1319 */     (z = paramg.a(object, this.q.b, this.q.c)).a(paramObject1);
/*      */     
/*      */     v v1;
/* 1322 */     if ((v1 = this.q.d) != null) {
/* 1323 */       return v1.b(paramObject1, object);
/*      */     }
/* 1325 */     return paramObject1;
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
/*      */   private static Object a(l paraml, g paramg, Object paramObject, k<Object> paramk) {
/* 1341 */     ac ac = paramg.a(paraml);
/* 1342 */     if (paramObject instanceof String) {
/* 1343 */       ac.b((String)paramObject);
/* 1344 */     } else if (paramObject instanceof Long) {
/* 1345 */       ac.b(((Long)paramObject).longValue());
/* 1346 */     } else if (paramObject instanceof Integer) {
/* 1347 */       ac.c(((Integer)paramObject).intValue());
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1354 */       ac.h(paramObject);
/*      */     } 
/*      */     l l1;
/* 1357 */     (l1 = ac.o()).g();
/* 1358 */     return paramk.a(l1, paramg);
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
/*      */   protected final Object e(l paraml, g paramg) {
/* 1371 */     return b(paraml, paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Object f(l paraml, g paramg) {
/* 1380 */     Object object1 = this.q.a(paraml, paramg);
/*      */     
/*      */     z z;
/*      */     Object object2;
/* 1384 */     if ((object2 = (z = paramg.a(object1, this.q.b, this.q.c)).b()) == null) {
/* 1385 */       throw new w(paraml, "Could not resolve Object Id [" + object1 + "] (for " + this.a + ").", paraml
/*      */           
/* 1387 */           .e(), z);
/*      */     }
/* 1389 */     return object2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Object g(l paraml, g paramg) {
/*      */     k<Object> k1;
/* 1396 */     if ((k1 = j()) != null) {
/* 1397 */       Object object = this.b.a(paramg, k1
/* 1398 */           .a(paraml, paramg));
/* 1399 */       if (this.i != null) {
/* 1400 */         a(paramg, object);
/*      */       }
/* 1402 */       return object;
/*      */     } 
/* 1404 */     if (this.e != null) {
/* 1405 */       return c(paraml, paramg);
/*      */     }
/*      */ 
/*      */     
/*      */     Class clazz;
/*      */     
/* 1411 */     if (i.n(clazz = this.a.b())) {
/* 1412 */       return paramg.a(clazz, null, paraml, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
/*      */     }
/*      */ 
/*      */     
/* 1416 */     if (w.a(clazz)) {
/* 1417 */       return paramg.a(clazz, null, paraml, "cannot deserialize from Object value (no delegate- or property-based Creator): this appears to be a native image, in which case you may need to configure reflection for the class that is to be deserialized", new Object[0]);
/*      */     }
/*      */     
/* 1420 */     return paramg.a(clazz, i(), paraml, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected abstract Object c(l paraml, g paramg);
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object h(l paraml, g paramg) {
/*      */     Object object;
/* 1431 */     if (this.q != null) {
/* 1432 */       return f(paraml, paramg);
/*      */     }
/* 1434 */     k<Object> k1 = j();
/*      */     l.b b;
/* 1436 */     if ((b = paraml.D()) == l.b.a) {
/* 1437 */       if (k1 != null && 
/* 1438 */         !this.b.f()) {
/* 1439 */         object = this.b.a(paramg, k1
/* 1440 */             .a(paraml, paramg));
/* 1441 */         if (this.i != null) {
/* 1442 */           a(paramg, object);
/*      */         }
/* 1444 */         return object;
/*      */       } 
/*      */       
/* 1447 */       return this.b.a(paramg, object.G());
/*      */     } 
/* 1449 */     if (b == l.b.b) {
/* 1450 */       if (k1 != null && 
/* 1451 */         !this.b.f()) {
/* 1452 */         object = this.b.a(paramg, k1
/* 1453 */             .a((l)object, paramg));
/* 1454 */         if (this.i != null) {
/* 1455 */           a(paramg, object);
/*      */         }
/* 1457 */         return object;
/*      */       } 
/*      */       
/* 1460 */       return this.b.a(paramg, object.H());
/*      */     } 
/* 1462 */     if (b == l.b.c) {
/* 1463 */       if (k1 != null && 
/* 1464 */         !this.b.h()) {
/* 1465 */         object = this.b.a(paramg, k1.a((l)object, paramg));
/* 1466 */         if (this.i != null) {
/* 1467 */           a(paramg, object);
/*      */         }
/* 1469 */         return object;
/*      */       } 
/*      */       
/* 1472 */       return this.b.a(paramg, object.I());
/*      */     } 
/*      */     
/* 1475 */     return paramg.a(a(), i(), (l)object, "no suitable creator method found to deserialize from Number value (%s)", new Object[] { object
/*      */           
/* 1477 */           .B() });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object i(l paraml, g paramg) {
/*      */     Object object;
/* 1484 */     if (this.q != null) {
/* 1485 */       return f(paraml, paramg);
/*      */     }
/*      */     
/*      */     k<Object> k1;
/*      */     
/* 1490 */     if ((k1 = j()) != null && 
/* 1491 */       !this.b.e()) {
/* 1492 */       object = this.b.a(paramg, k1
/* 1493 */           .a(paraml, paramg));
/* 1494 */       if (this.i != null) {
/* 1495 */         a(paramg, object);
/*      */       }
/* 1497 */       return object;
/*      */     } 
/*      */     
/* 1500 */     return m((l)object, paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object j(l paraml, g paramg) {
/*      */     Object object;
/*      */     k<Object> k1;
/*      */     l.b b;
/* 1511 */     if ((b = paraml.D()) == l.b.e || b == l.b.d) {
/*      */       
/* 1513 */       if ((k1 = j()) != null && 
/* 1514 */         !this.b.i()) {
/* 1515 */         object = this.b.a(paramg, k1
/* 1516 */             .a(paraml, paramg));
/* 1517 */         if (this.i != null) {
/* 1518 */           a(paramg, object);
/*      */         }
/* 1520 */         return object;
/*      */       } 
/*      */       
/* 1523 */       return this.b.a(paramg, object.K());
/*      */     } 
/*      */     
/* 1526 */     if (k1 == l.b.f) {
/*      */       
/* 1528 */       if ((k1 = j()) != null && 
/* 1529 */         !this.b.j()) {
/* 1530 */         object = this.b.a(paramg, k1.a((l)object, paramg));
/* 1531 */         if (this.i != null) {
/* 1532 */           a(paramg, object);
/*      */         }
/* 1534 */         return object;
/*      */       } 
/*      */ 
/*      */       
/* 1538 */       return this.b.a(paramg, object.L());
/*      */     } 
/*      */     
/* 1541 */     return paramg.a(a(), i(), (l)object, "no suitable creator method found to deserialize from Number value (%s)", new Object[] { object
/*      */           
/* 1543 */           .B() });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object k(l paraml, g paramg) {
/*      */     Object object;
/*      */     k<Object> k1;
/* 1552 */     if ((k1 = j()) != null && 
/* 1553 */       !this.b.k()) {
/* 1554 */       object = this.b.a(paramg, k1
/* 1555 */           .a(paraml, paramg));
/* 1556 */       if (this.i != null) {
/* 1557 */         a(paramg, object);
/*      */       }
/* 1559 */       return object;
/*      */     } 
/*      */     
/* 1562 */     boolean bool = (object.k() == o.k) ? true : false;
/* 1563 */     return this.b.a(paramg, bool);
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
/*      */   public final Object l(l paraml, g paramg) {
/* 1582 */     if (this.q != null) {
/* 1583 */       return f(paraml, paramg);
/*      */     }
/*      */     
/*      */     k<Object> k1;
/* 1587 */     if ((k1 = j()) != null && 
/* 1588 */       !this.b.e()) {
/* 1589 */       Object object1 = this.b.a(paramg, k1
/* 1590 */           .a(paraml, paramg));
/* 1591 */       if (this.i != null) {
/* 1592 */         a(paramg, object1);
/*      */       }
/* 1594 */       return object1;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     Object object;
/*      */ 
/*      */ 
/*      */     
/* 1603 */     if ((object = paraml.N()) != null && 
/* 1604 */       !this.a.c(object.getClass()))
/*      */     {
/* 1606 */       object = paramg.a(this.a, object, paraml);
/*      */     }
/*      */     
/* 1609 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<Object> j() {
/*      */     k<Object> k1;
/* 1617 */     if ((k1 = this.c) == null) {
/* 1618 */       k1 = this.d;
/*      */     }
/* 1620 */     return k1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(g paramg, Object paramObject) {
/*      */     ae[] arrayOfAe;
/*      */     int i;
/*      */     byte b;
/* 1632 */     for (i = (arrayOfAe = this.i).length, b = 0; b < i; b++) {
/* 1633 */       ae ae1; (ae1 = arrayOfAe[b]).a(paramg, paramObject);
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
/*      */   protected final Object a(g paramg, Object paramObject, ac paramac) {
/* 1647 */     paramac.j();
/*      */ 
/*      */     
/* 1650 */     l l = paramac.o();
/* 1651 */     while (l.g() != o.c) {
/* 1652 */       String str = l.v();
/*      */       
/* 1654 */       l.g();
/* 1655 */       b(l, paramg, paramObject, str);
/*      */     } 
/* 1657 */     return paramObject;
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
/*      */   protected final void a(l paraml, g paramg, Object paramObject, String paramString) {
/* 1672 */     if (n.a(paramString, this.k, this.l)) {
/* 1673 */       c(paraml, paramg, paramObject, paramString); return;
/* 1674 */     }  if (this.j != null) {
/*      */       
/*      */       try {
/* 1677 */         this.j.a(paraml, paramg, paramObject, paramString); return;
/* 1678 */       } catch (Exception exception) {
/* 1679 */         a(exception, paramObject, paramString, paramg);
/*      */         return;
/*      */       } 
/*      */     }
/* 1683 */     b((l)exception, paramg, paramObject, paramString);
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
/*      */   protected final void b(l paraml, g paramg, Object paramObject, String paramString) {
/* 1696 */     if (this.m) {
/* 1697 */       paraml.j();
/*      */       return;
/*      */     } 
/* 1700 */     if (n.a(paramString, this.k, this.l)) {
/* 1701 */       c(paraml, paramg, paramObject, paramString);
/*      */     }
/*      */ 
/*      */     
/* 1705 */     super.b(paraml, paramg, paramObject, paramString);
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
/*      */   protected final void c(l paraml, g paramg, Object paramObject, String paramString) {
/* 1718 */     if (paramg.a(i.j)) {
/* 1719 */       throw a.a(paraml, paramObject, paramString, d());
/*      */     }
/* 1721 */     paraml.j();
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
/*      */   protected final Object a(l paraml, g paramg, Object paramObject, ac paramac) {
/*      */     l l1;
/*      */     k<Object> k1;
/* 1741 */     if ((k1 = b(paramg, paramObject)) != null) {
/* 1742 */       if (paramac != null) {
/*      */         
/* 1744 */         paramac.j();
/*      */         
/* 1746 */         (l1 = paramac.o()).g();
/* 1747 */         paramObject = k1.a(l1, paramg, paramObject);
/*      */       } 
/*      */       
/* 1750 */       if (paraml != null) {
/* 1751 */         paramObject = k1.a(paraml, paramg, paramObject);
/*      */       }
/* 1753 */       return paramObject;
/*      */     } 
/*      */     
/* 1756 */     if (l1 != null) {
/* 1757 */       paramObject = a(paramg, paramObject, (ac)l1);
/*      */     }
/*      */     
/* 1760 */     if (paraml != null) {
/* 1761 */       paramObject = a(paraml, paramg, paramObject);
/*      */     }
/* 1763 */     return paramObject;
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
/*      */   private k<Object> b(g paramg, Object paramObject) {
/* 1777 */     synchronized (this) {
/* 1778 */       k1 = (this.w == null) ? null : this.w.get(new b(paramObject.getClass()));
/*      */     } 
/* 1780 */     if (k1 != null) {
/* 1781 */       return k1;
/*      */     }
/*      */     
/* 1784 */     j j1 = paramg.b(paramObject.getClass());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     k<Object> k1;
/*      */ 
/*      */ 
/*      */     
/* 1793 */     if ((k1 = paramg.b(j1)) != null) {
/* 1794 */       synchronized (this) {
/* 1795 */         if (this.w == null) {
/* 1796 */           this.w = new HashMap<>();
/*      */         }
/* 1798 */         this.w.put(new b(paramObject.getClass()), k1);
/*      */       } 
/*      */     }
/* 1801 */     return k1;
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
/*      */   public final void a(Throwable paramThrowable, Object paramObject, String paramString, g paramg) {
/* 1826 */     throw l.a(b(paramThrowable, paramg), paramObject, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Throwable b(Throwable paramThrowable, g paramg) {
/* 1836 */     while (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/* 1837 */       paramThrowable = paramThrowable.getCause();
/*      */     }
/*      */     
/* 1840 */     i.a(paramThrowable);
/* 1841 */     boolean bool = (paramg == null || paramg.a(i.o)) ? true : false;
/*      */     
/* 1843 */     if (paramThrowable instanceof IOException) {
/* 1844 */       if (!bool || !(paramThrowable instanceof com.a.a.b.d)) {
/* 1845 */         throw (IOException)paramThrowable;
/*      */       }
/* 1847 */     } else if (!bool) {
/* 1848 */       i.b(paramThrowable);
/*      */     } 
/* 1850 */     return paramThrowable;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Object a(Throwable paramThrowable, g paramg) {
/* 1856 */     while (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/* 1857 */       paramThrowable = paramThrowable.getCause();
/*      */     }
/*      */     
/* 1860 */     i.a(paramThrowable);
/* 1861 */     if (paramThrowable instanceof IOException)
/*      */     {
/* 1863 */       throw (IOException)paramThrowable;
/*      */     }
/* 1865 */     if (paramg == null) {
/* 1866 */       throw new IllegalArgumentException(paramThrowable.getMessage(), paramThrowable);
/*      */     }
/* 1868 */     if (!paramg.a(i.o)) {
/* 1869 */       i.b(paramThrowable);
/*      */     }
/* 1871 */     return paramg.a(this.a.b(), null, paramThrowable);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */