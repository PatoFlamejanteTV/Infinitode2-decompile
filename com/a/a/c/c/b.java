/*      */ package com.a.a.c.c;
/*      */ import com.a.a.a.ac;
/*      */ import com.a.a.a.ak;
/*      */ import com.a.a.a.i;
/*      */ import com.a.a.c.b.i;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.c.a.d;
/*      */ import com.a.a.c.c.a.e;
/*      */ import com.a.a.c.c.b.ah;
/*      */ import com.a.a.c.c.b.l;
/*      */ import com.a.a.c.c.b.u;
/*      */ import com.a.a.c.f;
/*      */ import com.a.a.c.f.ap;
/*      */ import com.a.a.c.f.d;
/*      */ import com.a.a.c.f.f;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.f.k;
/*      */ import com.a.a.c.f.n;
/*      */ import com.a.a.c.f.o;
/*      */ import com.a.a.c.f.s;
/*      */ import com.a.a.c.f.w;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i.e;
/*      */ import com.a.a.c.i.h;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.l.e;
/*      */ import com.a.a.c.l.g;
/*      */ import com.a.a.c.l.h;
/*      */ import com.a.a.c.l.j;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.l;
/*      */ import com.a.a.c.m.r;
/*      */ import com.a.a.c.p;
/*      */ import com.a.a.c.v;
/*      */ import com.a.a.c.w;
/*      */ import com.d.c.d.a.j;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public abstract class b extends q implements Serializable {
/*   49 */   private static final Class<?> b = Object.class;
/*   50 */   private static final Class<?> c = String.class;
/*   51 */   private static final Class<?> d = CharSequence.class;
/*   52 */   private static final Class<?> e = Iterable.class;
/*   53 */   private static final Class<?> f = Map.Entry.class;
/*   54 */   private static final Class<?> g = Serializable.class;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final m a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected b(m paramm) {
/*   81 */     this.a = paramm;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j a(f paramf, j paramj) {
/*      */     while (true) {
/*      */       j j1;
/*  160 */       if ((j1 = c(paramf, paramj)) == null) {
/*  161 */         return paramj;
/*      */       }
/*      */ 
/*      */       
/*  165 */       Class clazz = paramj.b();
/*  166 */       Class<?> clazz1 = j1.b();
/*  167 */       if (clazz == clazz1 || !clazz.isAssignableFrom(clazz1)) {
/*  168 */         throw new IllegalArgumentException("Invalid abstract type resolution from " + paramj + " to " + j1 + ": latter is not a subtype of former");
/*      */       }
/*  170 */       paramj = j1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j c(f paramf, j paramj) {
/*  181 */     Class clazz = paramj.b();
/*  182 */     if (this.a.c()) {
/*  183 */       for (Iterator iterator = this.a.h().iterator(); iterator.hasNext(); ) { iterator.next();
/*      */         j j1;
/*  185 */         if ((j1 = d.a()) != null && !j1.a(clazz)) {
/*  186 */           return j1;
/*      */         } }
/*      */     
/*      */     }
/*  190 */     return null;
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
/*      */   public final x a(g paramg, com.a.a.c.b paramb) {
/*  209 */     f f = paramg.c();
/*      */     
/*  211 */     x x = null;
/*      */     
/*  213 */     d d = paramb.d();
/*      */     Object object;
/*  215 */     if ((object = paramg.f().f(d)) != null) {
/*  216 */       x = a(f, (com.a.a.c.f.b)d, object);
/*      */     }
/*  218 */     if (x == null)
/*      */     {
/*      */ 
/*      */       
/*  222 */       if ((x = k.b(paramb.b())) == null) {
/*  223 */         x = b(paramg, paramb);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*  228 */     if (this.a.d()) {
/*  229 */       for (Iterator<w.a> iterator = this.a.i().iterator(); iterator.hasNext();) {
/*      */ 
/*      */         
/*  232 */         if ((x = (a = iterator.next()).l()) == null) {
/*  233 */           paramg.a(paramb, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", new Object[] { a
/*      */                 
/*  235 */                 .getClass().getName() });
/*      */         }
/*      */       } 
/*      */     }
/*  239 */     if (x != null) {
/*  240 */       x = x.a();
/*      */     }
/*      */     
/*  243 */     return x;
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
/*      */   private x b(g paramg, com.a.a.c.b paramb) {
/*      */     f f;
/*  260 */     ap<?> ap = (f = paramg.c()).a(paramb.b(), paramb
/*  261 */         .d());
/*  262 */     i i = f.e();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  271 */     e e = new e(paramb, (q)f);
/*  272 */     Map<o, s[]> map = c(paramg, paramb);
/*      */     
/*  274 */     b b1 = new b(paramg, paramb, ap, e, map);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  279 */     b(paramg, b1, !i.b());
/*      */ 
/*      */     
/*  282 */     if (paramb.a().e()) {
/*      */ 
/*      */       
/*  285 */       ArrayList<String> arrayList = new ArrayList();
/*      */       
/*      */       f f1;
/*  288 */       if (paramb.a().j() && (f1 = com.a.a.c.g.a.a(paramg, paramb, arrayList)) != null) {
/*  289 */         a(paramg, b1, f1, arrayList);
/*  290 */         return b1.c.a(paramg);
/*      */       } 
/*      */ 
/*      */       
/*      */       boolean bool;
/*      */ 
/*      */       
/*  297 */       if (!(bool = paramb.c())) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  303 */         boolean bool1 = i.a(paramb.b());
/*  304 */         a(paramg, b1, bool1);
/*  305 */         if (b1.h() && 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  311 */           !b1.g()) {
/*  312 */           a(paramg, b1, b1.i());
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  317 */     if (b1.d() && 
/*  318 */       !b1.c() && !b1.g()) {
/*  319 */       b(paramg, b1, b1.e());
/*      */     }
/*  321 */     return b1.c.a(paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<o, s[]> c(g paramg, com.a.a.c.b paramb) {
/*  327 */     Map<?, ?> map = Collections.emptyMap();
/*  328 */     for (Iterator<s> iterator = paramb.h().iterator(); iterator.hasNext(); ) {
/*  329 */       s s; Iterator<n> iterator1 = (s = iterator.next()).r();
/*  330 */       while (iterator1.hasNext()) {
/*      */         n n;
/*  332 */         o o = (n = iterator1.next()).e();
/*  333 */         s[] arrayOfS = (s[])map.get(o);
/*  334 */         int i = n.f();
/*      */         
/*  336 */         if (arrayOfS == null) {
/*  337 */           if (map.isEmpty()) {
/*  338 */             map = new LinkedHashMap<>();
/*      */           }
/*  340 */           arrayOfS = new s[o.f()];
/*  341 */           map.put(o, arrayOfS);
/*      */         }
/*  343 */         else if (arrayOfS[i] != null) {
/*  344 */           paramg.a(paramb, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", new Object[] {
/*      */                 
/*  346 */                 Integer.valueOf(i), o, arrayOfS[i], s
/*      */               });
/*      */         } 
/*  349 */         arrayOfS[i] = s;
/*      */       } 
/*      */     } 
/*  352 */     return (Map)map;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static x a(f paramf, com.a.a.c.f.b paramb, Object paramObject) {
/*  359 */     if (paramObject == null) {
/*  360 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  365 */     if (paramObject instanceof x) {
/*  366 */       return (x)paramObject;
/*      */     }
/*  368 */     if (!(paramObject instanceof Class)) {
/*  369 */       throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + paramObject
/*  370 */           .getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
/*      */     }
/*      */ 
/*      */     
/*  374 */     if (i.e((Class)(paramObject = paramObject))) {
/*  375 */       return null;
/*      */     }
/*  377 */     if (!x.class.isAssignableFrom((Class<?>)paramObject)) {
/*  378 */       throw new IllegalStateException("AnnotationIntrospector returned Class " + paramObject.getName() + "; expected Class<ValueInstantiator>");
/*      */     }
/*      */     x x;
/*      */     d d;
/*  382 */     if ((d = paramf.m()) != null && (
/*      */       
/*  384 */       x = d.i()) != null) {
/*  385 */       return x;
/*      */     }
/*      */     
/*  388 */     return (x)i.b((Class)paramObject, paramf
/*  389 */         .g());
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
/*      */   private void a(g paramg, b paramb, f paramf, List<String> paramList) {
/*  408 */     int i = paramf.f();
/*  409 */     com.a.a.c.a a = paramg.f();
/*  410 */     v[] arrayOfV = new v[i];
/*      */     
/*  412 */     for (byte b1 = 0; b1 < i; b1++) {
/*  413 */       n n = paramf.c(b1);
/*  414 */       com.a.a.a.b.a a1 = a.e((j)n);
/*      */       w w;
/*  416 */       if ((w = a.D((com.a.a.c.f.b)n)) == null || w.e()) {
/*  417 */         w = w.a(paramList.get(b1));
/*      */       }
/*  419 */       arrayOfV[b1] = a(paramg, paramb.a, w, b1, n, a1);
/*      */     } 
/*  421 */     paramb.c.a((o)paramf, false, arrayOfV);
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
/*      */   private void a(g paramg, b paramb, boolean paramBoolean) {
/*  434 */     com.a.a.c.b b1 = paramb.a;
/*  435 */     e e = paramb.c;
/*  436 */     com.a.a.c.a a = paramb.a();
/*  437 */     ap<?> ap = paramb.b;
/*  438 */     Map<o, s[]> map = paramb.d;
/*      */ 
/*      */     
/*      */     f f;
/*      */ 
/*      */     
/*  444 */     if ((f = b1.o()) != null && (
/*  445 */       !e.a() || d(paramg, (com.a.a.c.f.b)f))) {
/*  446 */       e.a((o)f);
/*      */     }
/*      */ 
/*      */     
/*  450 */     for (f f1 : b1.k()) {
/*  451 */       i.a a1 = a.a((q)paramg.c(), (com.a.a.c.f.b)f1);
/*  452 */       if (i.a.d != a1) {
/*      */ 
/*      */         
/*  455 */         if (a1 == null) {
/*      */           
/*  457 */           if (paramBoolean && ap.a((j)f1)) {
/*  458 */             paramb.b(d.a(a, (o)f1, map
/*  459 */                   .get(f1)));
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*  464 */         switch (c.a[a1.ordinal()]) {
/*      */           case 1:
/*  466 */             a(paramg, b1, e, 
/*  467 */                 d.a(a, (o)f1, null));
/*      */             break;
/*      */           case 2:
/*  470 */             b(paramg, b1, e, 
/*  471 */                 d.a(a, (o)f1, map.get(f1)));
/*      */             break;
/*      */           default:
/*  474 */             a(paramg, b1, e, 
/*  475 */                 d.a(a, (o)f1, map.get(f1)), paramg
/*  476 */                 .c().e());
/*      */             break;
/*      */         } 
/*  479 */         paramb.f();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(g paramg, b paramb, List<d> paramList) {
/*  487 */     f f = paramg.c();
/*  488 */     com.a.a.c.b b1 = paramb.a;
/*  489 */     e e = paramb.c;
/*  490 */     com.a.a.c.a a = paramb.a();
/*  491 */     ap<?> ap = paramb.b;
/*  492 */     LinkedList<o> linkedList = null;
/*  493 */     boolean bool = f.e().d();
/*      */     
/*  495 */     for (Iterator<d> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  496 */       com.a.a.a.b.a a1; d d; int i = (d = iterator.next()).b();
/*  497 */       o o = d.a();
/*      */       
/*  499 */       if (i == 1) {
/*  500 */         s s = d.c(0);
/*      */         
/*      */         boolean bool1;
/*  503 */         if (bool1 = (bool || a(a, o, s)) ? true : false) {
/*  504 */           v[] arrayOfV1 = new v[1];
/*  505 */           a1 = d.a(0);
/*      */ 
/*      */           
/*      */           w w;
/*      */           
/*  510 */           if ((w = d.d(0)) != null || (
/*      */             
/*  512 */             w = d.f(0)) != null || a1 != null) {
/*      */ 
/*      */ 
/*      */             
/*  516 */             arrayOfV1[0] = a(paramg, b1, w, 0, d
/*  517 */                 .b(0), a1);
/*  518 */             e.a(o, false, arrayOfV1);
/*      */           }  continue;
/*  520 */         }  a(e, o, false, ap
/*      */             
/*  522 */             .a((j)o));
/*      */ 
/*      */         
/*  525 */         if (s != null) {
/*  526 */           ((af)s).I();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  537 */       byte b2 = -1;
/*  538 */       v[] arrayOfV = new v[a1];
/*  539 */       byte b3 = 0;
/*      */       
/*  541 */       byte b4 = 0;
/*      */       byte b5;
/*  543 */       for (b5 = 0; b5 < a1; b5++) {
/*  544 */         n n = o.c(b5);
/*  545 */         s s = d.c(b5);
/*  546 */         com.a.a.a.b.a a2 = a.e((j)n);
/*  547 */         w w = (s == null) ? null : s.b();
/*      */         
/*  549 */         if (s != null && s.e()) {
/*  550 */           b3++;
/*  551 */           arrayOfV[b5] = a(paramg, b1, w, b5, n, a2);
/*      */         
/*      */         }
/*  554 */         else if (a2 != null) {
/*  555 */           b4++;
/*  556 */           arrayOfV[b5] = a(paramg, b1, w, b5, n, a2);
/*      */         } else {
/*      */           r r;
/*      */           
/*  560 */           if ((r = a.c((j)n)) != null) {
/*  561 */             a(paramg, b1, n);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  576 */           else if (b2 < 0) {
/*  577 */             b2 = b5;
/*      */           } 
/*      */         } 
/*      */       } 
/*  581 */       b5 = b3;
/*      */       
/*  583 */       if (b3 > 0 || b4 > 0) {
/*      */         
/*  585 */         if (b5 + b4 == a1) {
/*  586 */           e.a(o, false, arrayOfV);
/*      */           continue;
/*      */         } 
/*  589 */         if (b3 == 0 && b4 + 1 == a1) {
/*      */           
/*  591 */           e.a(o, false, arrayOfV, 0);
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*      */         w w;
/*      */         
/*  598 */         if ((w = d.f(b2)) == null || w.e())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  607 */           paramg.a(b1, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", new Object[] {
/*      */                 
/*  609 */                 Integer.valueOf(b2), o
/*      */               });
/*      */         }
/*      */       } 
/*  613 */       if (!e.a()) {
/*  614 */         if (linkedList == null) {
/*  615 */           linkedList = new LinkedList();
/*      */         }
/*  617 */         linkedList.add(o);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  622 */     if (linkedList != null && !e.b() && 
/*  623 */       !e.c()) {
/*  624 */       a(paramg, b1, ap, a, e, linkedList);
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
/*      */   private void b(g paramg, b paramb, boolean paramBoolean) {
/*  639 */     com.a.a.c.b b1 = paramb.a;
/*  640 */     e e = paramb.c;
/*  641 */     com.a.a.c.a a = paramb.a();
/*  642 */     ap<?> ap = paramb.b;
/*  643 */     Map<o, s[]> map = paramb.d;
/*      */ 
/*      */     
/*  646 */     for (k k : b1.m()) {
/*  647 */       i.a a1 = a.a((q)paramg.c(), (com.a.a.c.f.b)k);
/*  648 */       int i = k.f();
/*  649 */       if (a1 == null) {
/*      */         
/*  651 */         if (paramBoolean && i == 1 && ap.a((j)k)) {
/*  652 */           paramb.a(d.a(a, (o)k, null));
/*      */         }
/*      */         continue;
/*      */       } 
/*  656 */       if (a1 != i.a.d) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  661 */         if (i == 0) {
/*  662 */           e.a((o)k);
/*      */           
/*      */           continue;
/*      */         } 
/*  666 */         switch (c.a[a1.ordinal()]) {
/*      */           case 1:
/*  668 */             a(paramg, b1, e, 
/*  669 */                 d.a(a, (o)k, null));
/*      */             break;
/*      */           case 2:
/*  672 */             b(paramg, b1, e, 
/*  673 */                 d.a(a, (o)k, map.get(k)));
/*      */             break;
/*      */           
/*      */           default:
/*  677 */             a(paramg, b1, e, 
/*  678 */                 d.a(a, (o)k, map.get(k)), i.a);
/*      */             break;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  684 */         paramb.b();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(g paramg, b paramb, List<d> paramList) {
/*  692 */     com.a.a.c.b b1 = paramb.a;
/*  693 */     e e = paramb.c;
/*  694 */     com.a.a.c.a a = paramb.a();
/*  695 */     ap<?> ap = paramb.b;
/*  696 */     Map<o, s[]> map = paramb.d;
/*      */ 
/*      */     
/*  699 */     for (Iterator<d> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  700 */       d d; int i = (d = iterator.next()).b();
/*  701 */       o o = d.a();
/*  702 */       s[] arrayOfS = map.get(o);
/*      */       
/*  704 */       if (i == 1) {
/*      */         n n;
/*      */         
/*  707 */         s s = d.c(0);
/*      */         boolean bool;
/*  709 */         if (!(bool = a(a, o, s))) {
/*  710 */           a(e, o, false, ap
/*  711 */               .a((j)o));
/*      */ 
/*      */           
/*  714 */           if (s != null) {
/*  715 */             ((af)s).I();
/*      */           }
/*      */           continue;
/*      */         } 
/*  719 */         s = null;
/*  720 */         v[] arrayOfV = new v[i];
/*      */         
/*  722 */         byte b2 = 0;
/*  723 */         byte b3 = 0;
/*      */         byte b4;
/*  725 */         for (b4 = 0; b4 < i; b4++) {
/*  726 */           n n1 = o.c(b4);
/*  727 */           s s1 = (arrayOfS == null) ? null : arrayOfS[b4];
/*  728 */           com.a.a.a.b.a a1 = a.e((j)n1);
/*  729 */           w w = (s1 == null) ? null : s1.b();
/*      */           
/*  731 */           if (s1 != null && s1.e()) {
/*  732 */             b2++;
/*  733 */             arrayOfV[b4] = a(paramg, b1, w, b4, n1, a1);
/*      */           
/*      */           }
/*  736 */           else if (a1 != null) {
/*  737 */             b3++;
/*  738 */             arrayOfV[b4] = a(paramg, b1, w, b4, n1, a1);
/*      */           } else {
/*      */             r r;
/*      */             
/*  742 */             if ((r = a.c((j)n1)) != null) {
/*  743 */               a(paramg, b1, n1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*  772 */             else if (s == null) {
/*  773 */               n = n1;
/*      */             } 
/*      */           } 
/*  776 */         }  b4 = b2;
/*      */ 
/*      */         
/*  779 */         if (b2 > 0 || b3 > 0) {
/*      */           
/*  781 */           if (b4 + b3 == i) {
/*  782 */             e.a(o, false, arrayOfV); continue;
/*  783 */           }  if (b2 == 0 && b3 + 1 == i) {
/*      */             
/*  785 */             e.a(o, false, arrayOfV, 0); continue;
/*      */           } 
/*  787 */           paramg.a(b1, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", new Object[] {
/*      */                 
/*  789 */                 Integer.valueOf((n == null) ? -1 : n.f()), o
/*      */               });
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(g paramg, com.a.a.c.b paramb, e parame, d paramd) {
/*  815 */     byte b1 = -1;
/*      */     int i;
/*  817 */     v[] arrayOfV = new v[i = paramd.b()];
/*  818 */     for (byte b2 = 0; b2 < i; b2++) {
/*  819 */       n n = paramd.b(b2);
/*      */       com.a.a.a.b.a a;
/*  821 */       if ((a = paramd.a(b2)) != null) {
/*  822 */         arrayOfV[b2] = a(paramg, paramb, (w)null, b2, n, a);
/*      */       
/*      */       }
/*  825 */       else if (b1 < 0) {
/*  826 */         b1 = b2;
/*      */       }
/*      */       else {
/*      */         
/*  830 */         paramg.a(paramb, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", new Object[] {
/*      */               
/*  832 */               Integer.valueOf(b1), Integer.valueOf(b2), paramd });
/*      */       } 
/*      */     } 
/*  835 */     if (b1 < 0) {
/*  836 */       paramg.a(paramb, "No argument left as delegating for Creator %s: exactly one required", new Object[] { paramd });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  841 */     if (i == 1) {
/*  842 */       a(parame, paramd.a(), true, true);
/*      */       
/*      */       s s;
/*      */       
/*  846 */       if ((s = paramd.c(0)) != null) {
/*  847 */         ((af)s).I();
/*      */       }
/*      */       return;
/*      */     } 
/*  851 */     parame.a(paramd.a(), true, arrayOfV, b1);
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
/*      */   private void b(g paramg, com.a.a.c.b paramb, e parame, d paramd) {
/*      */     int i;
/*  866 */     v[] arrayOfV = new v[i = paramd.b()];
/*      */     
/*  868 */     for (byte b1 = 0; b1 < i; b1++) {
/*  869 */       com.a.a.a.b.a a = paramd.a(b1);
/*  870 */       n n = paramd.b(b1);
/*      */       w w;
/*  872 */       if ((w = paramd.d(b1)) == null) {
/*      */         r r;
/*      */ 
/*      */         
/*  876 */         if ((r = paramg.f().c((j)n)) != null) {
/*  877 */           a(paramg, paramb, n);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  883 */         w = paramd.f(b1);
/*  884 */         a(paramg, paramb, paramd, b1, w, a);
/*      */       } 
/*      */       
/*  887 */       arrayOfV[b1] = a(paramg, paramb, w, b1, n, a);
/*      */     } 
/*  889 */     parame.a(paramd.a(), true, arrayOfV);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(g paramg, com.a.a.c.b paramb, e parame, d paramd, i parami) {
/*      */     // Byte code:
/*      */     //   0: iconst_1
/*      */     //   1: aload #4
/*      */     //   3: invokevirtual b : ()I
/*      */     //   6: if_icmpeq -> 66
/*      */     //   9: aload #5
/*      */     //   11: invokevirtual d : ()Z
/*      */     //   14: ifne -> 56
/*      */     //   17: aload #4
/*      */     //   19: invokevirtual c : ()I
/*      */     //   22: dup
/*      */     //   23: istore #6
/*      */     //   25: iflt -> 56
/*      */     //   28: aload #5
/*      */     //   30: invokevirtual c : ()Z
/*      */     //   33: ifne -> 46
/*      */     //   36: aload #4
/*      */     //   38: iload #6
/*      */     //   40: invokevirtual d : (I)Lcom/a/a/c/w;
/*      */     //   43: ifnonnull -> 56
/*      */     //   46: aload_0
/*      */     //   47: aload_1
/*      */     //   48: aload_2
/*      */     //   49: aload_3
/*      */     //   50: aload #4
/*      */     //   52: invokevirtual a : (Lcom/a/a/c/g;Lcom/a/a/c/b;Lcom/a/a/c/c/a/e;Lcom/a/a/c/c/a/d;)V
/*      */     //   55: return
/*      */     //   56: aload_0
/*      */     //   57: aload_1
/*      */     //   58: aload_2
/*      */     //   59: aload_3
/*      */     //   60: aload #4
/*      */     //   62: invokevirtual b : (Lcom/a/a/c/g;Lcom/a/a/c/b;Lcom/a/a/c/c/a/e;Lcom/a/a/c/c/a/d;)V
/*      */     //   65: return
/*      */     //   66: aload #4
/*      */     //   68: iconst_0
/*      */     //   69: invokevirtual b : (I)Lcom/a/a/c/f/n;
/*      */     //   72: astore #6
/*      */     //   74: aload #4
/*      */     //   76: iconst_0
/*      */     //   77: invokevirtual a : (I)Lcom/a/a/a/b$a;
/*      */     //   80: astore #7
/*      */     //   82: aconst_null
/*      */     //   83: astore #8
/*      */     //   85: getstatic com/a/a/c/c/c.b : [I
/*      */     //   88: aload #5
/*      */     //   90: invokevirtual a : ()Lcom/a/a/c/b/i$a;
/*      */     //   93: invokevirtual ordinal : ()I
/*      */     //   96: iaload
/*      */     //   97: tableswitch default -> 179, 1 -> 124, 2 -> 128, 3 -> 158
/*      */     //   124: iconst_0
/*      */     //   125: goto -> 245
/*      */     //   128: iconst_1
/*      */     //   129: istore #5
/*      */     //   131: aload #4
/*      */     //   133: iconst_0
/*      */     //   134: invokevirtual d : (I)Lcom/a/a/c/w;
/*      */     //   137: dup
/*      */     //   138: astore #8
/*      */     //   140: ifnonnull -> 247
/*      */     //   143: aload_1
/*      */     //   144: aload_2
/*      */     //   145: aload #4
/*      */     //   147: iconst_0
/*      */     //   148: aload #8
/*      */     //   150: aload #7
/*      */     //   152: invokestatic a : (Lcom/a/a/c/g;Lcom/a/a/c/b;Lcom/a/a/c/c/a/d;ILcom/a/a/c/w;Lcom/a/a/a/b$a;)V
/*      */     //   155: goto -> 247
/*      */     //   158: aload_1
/*      */     //   159: aload_2
/*      */     //   160: ldc 'Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`'
/*      */     //   162: iconst_1
/*      */     //   163: anewarray java/lang/Object
/*      */     //   166: dup
/*      */     //   167: iconst_0
/*      */     //   168: aload #4
/*      */     //   170: invokevirtual a : ()Lcom/a/a/c/f/o;
/*      */     //   173: aastore
/*      */     //   174: invokevirtual a : (Lcom/a/a/c/b;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   177: pop
/*      */     //   178: return
/*      */     //   179: aload #4
/*      */     //   181: iconst_0
/*      */     //   182: invokevirtual c : (I)Lcom/a/a/c/f/s;
/*      */     //   185: astore #9
/*      */     //   187: aload #4
/*      */     //   189: iconst_0
/*      */     //   190: invokevirtual e : (I)Lcom/a/a/c/w;
/*      */     //   193: dup
/*      */     //   194: astore #8
/*      */     //   196: ifnonnull -> 204
/*      */     //   199: aload #7
/*      */     //   201: ifnull -> 208
/*      */     //   204: iconst_1
/*      */     //   205: goto -> 209
/*      */     //   208: iconst_0
/*      */     //   209: dup
/*      */     //   210: istore #5
/*      */     //   212: ifne -> 247
/*      */     //   215: aload #9
/*      */     //   217: ifnull -> 247
/*      */     //   220: aload #4
/*      */     //   222: iconst_0
/*      */     //   223: invokevirtual d : (I)Lcom/a/a/c/w;
/*      */     //   226: dup
/*      */     //   227: astore #8
/*      */     //   229: ifnull -> 244
/*      */     //   232: aload #9
/*      */     //   234: invokevirtual j : ()Z
/*      */     //   237: ifeq -> 244
/*      */     //   240: iconst_1
/*      */     //   241: goto -> 245
/*      */     //   244: iconst_0
/*      */     //   245: istore #5
/*      */     //   247: iload #5
/*      */     //   249: ifeq -> 287
/*      */     //   252: iconst_1
/*      */     //   253: anewarray com/a/a/c/c/v
/*      */     //   256: dup
/*      */     //   257: iconst_0
/*      */     //   258: aload_0
/*      */     //   259: aload_1
/*      */     //   260: aload_2
/*      */     //   261: aload #8
/*      */     //   263: iconst_0
/*      */     //   264: aload #6
/*      */     //   266: aload #7
/*      */     //   268: invokevirtual a : (Lcom/a/a/c/g;Lcom/a/a/c/b;Lcom/a/a/c/w;ILcom/a/a/c/f/n;Lcom/a/a/a/b$a;)Lcom/a/a/c/c/v;
/*      */     //   271: aastore
/*      */     //   272: astore #9
/*      */     //   274: aload_3
/*      */     //   275: aload #4
/*      */     //   277: invokevirtual a : ()Lcom/a/a/c/f/o;
/*      */     //   280: iconst_1
/*      */     //   281: aload #9
/*      */     //   283: invokevirtual a : (Lcom/a/a/c/f/o;Z[Lcom/a/a/c/c/v;)V
/*      */     //   286: return
/*      */     //   287: aload_3
/*      */     //   288: aload #4
/*      */     //   290: invokevirtual a : ()Lcom/a/a/c/f/o;
/*      */     //   293: iconst_1
/*      */     //   294: iconst_1
/*      */     //   295: invokestatic a : (Lcom/a/a/c/c/a/e;Lcom/a/a/c/f/o;ZZ)Z
/*      */     //   298: pop
/*      */     //   299: aload #4
/*      */     //   301: iconst_0
/*      */     //   302: invokevirtual c : (I)Lcom/a/a/c/f/s;
/*      */     //   305: dup
/*      */     //   306: astore #9
/*      */     //   308: ifnull -> 319
/*      */     //   311: aload #9
/*      */     //   313: checkcast com/a/a/c/f/af
/*      */     //   316: invokevirtual I : ()V
/*      */     //   319: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #914	-> 0
/*      */     //   #919	-> 9
/*      */     //   #920	-> 17
/*      */     //   #921	-> 23
/*      */     //   #924	-> 28
/*      */     //   #925	-> 40
/*      */     //   #926	-> 46
/*      */     //   #927	-> 55
/*      */     //   #931	-> 56
/*      */     //   #932	-> 65
/*      */     //   #936	-> 66
/*      */     //   #937	-> 74
/*      */     //   #938	-> 82
/*      */     //   #941	-> 85
/*      */     //   #943	-> 124
/*      */     //   #944	-> 125
/*      */     //   #946	-> 128
/*      */     //   #949	-> 131
/*      */     //   #951	-> 138
/*      */     //   #952	-> 143
/*      */     //   #958	-> 158
/*      */     //   #961	-> 170
/*      */     //   #958	-> 174
/*      */     //   #962	-> 178
/*      */     //   #966	-> 179
/*      */     //   #968	-> 187
/*      */     //   #971	-> 194
/*      */     //   #972	-> 210
/*      */     //   #979	-> 220
/*      */     //   #980	-> 227
/*      */     //   #985	-> 247
/*      */     //   #986	-> 252
/*      */     //   #987	-> 268
/*      */     //   #989	-> 274
/*      */     //   #990	-> 286
/*      */     //   #993	-> 287
/*      */     //   #997	-> 299
/*      */     //   #998	-> 306
/*      */     //   #999	-> 311
/*      */     //   #1001	-> 319
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(com.a.a.c.a parama, o paramo, s params) {
/* 1007 */     if ((params != null && params.e()) || parama
/* 1008 */       .e((j)paramo.c(0)) != null) {
/* 1009 */       return true;
/*      */     }
/* 1011 */     if (params != null) {
/*      */       String str;
/*      */ 
/*      */       
/* 1015 */       if ((str = params.a()) != null && !str.isEmpty() && 
/* 1016 */         params.j()) {
/* 1017 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1022 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(g paramg, com.a.a.c.b paramb, ap<?> paramap, com.a.a.c.a parama, e parame, List<o> paramList) {
/* 1030 */     o o = null;
/* 1031 */     v[] arrayOfV = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1038 */     label32: for (o o1 : paramList) {
/* 1039 */       if (paramap.a((j)o1)) {
/*      */         int i;
/*      */ 
/*      */ 
/*      */         
/* 1044 */         v[] arrayOfV1 = new v[i = o1.f()];
/* 1045 */         for (byte b1 = 0; b1 < i; ) {
/*      */           n n;
/*      */           
/*      */           w w;
/*      */           
/* 1050 */           if ((w = a(n = o1.c(b1), parama)) != null) { if (!w.e()) {
/*      */ 
/*      */               
/* 1053 */               arrayOfV1[b1] = a(paramg, paramb, w, n.f(), n, (com.a.a.a.b.a)null); b1++;
/*      */             }  continue label32; }
/*      */            continue label32;
/* 1056 */         }  if (o != null) {
/* 1057 */           o = null;
/*      */           break;
/*      */         } 
/* 1060 */         o = o1;
/* 1061 */         arrayOfV = arrayOfV1;
/*      */       } 
/*      */     } 
/* 1064 */     if (o != null) {
/* 1065 */       parame.a(o, false, arrayOfV);
/* 1066 */       q q1 = (q)paramb; v[] arrayOfV1; int i;
/*      */       byte b1;
/* 1068 */       for (i = (arrayOfV1 = arrayOfV).length, b1 = 0; b1 < i; b1++) {
/* 1069 */         v v; w w = (v = arrayOfV1[b1]).b();
/* 1070 */         if (!q1.a(w)) {
/* 1071 */           aa aa = aa.a((q)paramg
/* 1072 */               .c(), v.e(), w);
/* 1073 */           q1.a((s)aa);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(e parame, o paramo, boolean paramBoolean1, boolean paramBoolean2) {
/*      */     Class<String> clazz;
/* 1084 */     if ((clazz = paramo.a(0)) == String.class || clazz == d) {
/* 1085 */       if (paramBoolean1 || paramBoolean2) {
/* 1086 */         parame.a(paramo, paramBoolean1);
/*      */       }
/* 1088 */       return true;
/*      */     } 
/* 1090 */     if (clazz == int.class || clazz == Integer.class) {
/* 1091 */       if (paramBoolean1 || paramBoolean2) {
/* 1092 */         parame.b(paramo, paramBoolean1);
/*      */       }
/* 1094 */       return true;
/*      */     } 
/* 1096 */     if (clazz == long.class || clazz == Long.class) {
/* 1097 */       if (paramBoolean1 || paramBoolean2) {
/* 1098 */         parame.c(paramo, paramBoolean1);
/*      */       }
/* 1100 */       return true;
/*      */     } 
/* 1102 */     if (clazz == double.class || clazz == Double.class) {
/* 1103 */       if (paramBoolean1 || paramBoolean2) {
/* 1104 */         parame.e(paramo, paramBoolean1);
/*      */       }
/* 1106 */       return true;
/*      */     } 
/* 1108 */     if (clazz == boolean.class || clazz == Boolean.class) {
/* 1109 */       if (paramBoolean1 || paramBoolean2) {
/* 1110 */         parame.g(paramo, paramBoolean1);
/*      */       }
/* 1112 */       return true;
/*      */     } 
/* 1114 */     if (clazz == BigInteger.class && (
/* 1115 */       paramBoolean1 || paramBoolean2)) {
/* 1116 */       parame.d(paramo, paramBoolean1);
/*      */     }
/*      */     
/* 1119 */     if (clazz == BigDecimal.class && (
/* 1120 */       paramBoolean1 || paramBoolean2)) {
/* 1121 */       parame.f(paramo, paramBoolean1);
/*      */     }
/*      */ 
/*      */     
/* 1125 */     if (paramBoolean1) {
/* 1126 */       parame.a(paramo, paramBoolean1, null, 0);
/* 1127 */       return true;
/*      */     } 
/* 1129 */     return false;
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
/*      */   private static void a(g paramg, com.a.a.c.b paramb, d paramd, int paramInt, w paramw, com.a.a.a.b.a parama) {
/* 1143 */     if (paramw == null && parama == null) {
/* 1144 */       paramg.a(paramb, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", new Object[] {
/*      */             
/* 1146 */             Integer.valueOf(paramInt), paramd
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(g paramg, com.a.a.c.b paramb, n paramn) {
/* 1156 */     paramg.a(paramb, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", new Object[] {
/*      */           
/* 1158 */           Integer.valueOf(paramn.f())
/*      */         });
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
/*      */   private v a(g paramg, com.a.a.c.b paramb, w paramw, int paramInt, n paramn, com.a.a.a.b.a parama) {
/*      */     w w1;
/* 1172 */     f f = paramg.c();
/*      */ 
/*      */     
/*      */     com.a.a.c.a a1;
/*      */     
/* 1177 */     if ((a1 = paramg.f()) == null) {
/* 1178 */       v1 = v.c;
/* 1179 */       w1 = null;
/*      */     } else {
/* 1181 */       Boolean bool = v1.f((j)paramn);
/* 1182 */       String str2 = v1.j((com.a.a.c.f.b)paramn);
/* 1183 */       Integer integer = v1.k((com.a.a.c.f.b)paramn);
/* 1184 */       String str1 = v1.i((com.a.a.c.f.b)paramn);
/* 1185 */       v1 = v.a(bool, str2, integer, str1);
/* 1186 */       w1 = com.a.a.c.a.b();
/*      */     } 
/*      */     
/* 1189 */     j j = a(paramg, (j)paramn, paramn.c());
/* 1190 */     c.b b1 = new c.b(paramw, j, w1, (j)paramn, v1);
/*      */ 
/*      */     
/*      */     e e;
/*      */     
/* 1195 */     if ((e = (e)j.B()) == null) {
/* 1196 */       e = b(f, j);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1201 */     v v1 = a(paramg, (c)b1, v1);
/*      */ 
/*      */ 
/*      */     
/* 1205 */     v v = m.a(paramw, j, b1.f(), e, paramb
/* 1206 */         .g(), paramn, paramInt, parama, v1);
/*      */     
/*      */     k<Object> k;
/* 1209 */     if ((k = a(paramg, (com.a.a.c.f.b)paramn)) == null) {
/* 1210 */       k = (k<Object>)j.A();
/*      */     }
/* 1212 */     if (k != null) {
/*      */       
/* 1214 */       k = paramg.a(k, (c)v, j);
/* 1215 */       v = v.a(k);
/*      */     } 
/* 1217 */     return v;
/*      */   }
/*      */ 
/*      */   
/*      */   private static w a(n paramn, com.a.a.c.a parama) {
/* 1222 */     if (parama != null) {
/*      */       w w;
/* 1224 */       if ((w = parama.D((com.a.a.c.f.b)paramn)) != null)
/*      */       {
/*      */         
/* 1227 */         if (!w.e()) {
/* 1228 */           return w;
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       String str;
/*      */       
/* 1235 */       if ((str = parama.g((j)paramn)) != null && !str.isEmpty()) {
/* 1236 */         return w.a(str);
/*      */       }
/*      */     } 
/* 1239 */     return null;
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
/*      */   private static v a(g paramg, c paramc, v paramv) {
/* 1251 */     com.a.a.c.a a1 = paramg.f();
/* 1252 */     f f = paramg.c();
/*      */ 
/*      */     
/* 1255 */     ak ak1 = null;
/* 1256 */     ak ak2 = null;
/*      */ 
/*      */     
/*      */     j j;
/*      */ 
/*      */     
/* 1262 */     if ((j = paramc.e()) != null) {
/*      */       ac.a a3;
/* 1264 */       if (a1 != null && (
/*      */         
/* 1266 */         a3 = a1.F((com.a.a.c.f.b)j)) != null) {
/* 1267 */         ak1 = a3.c();
/* 1268 */         ak2 = a3.d();
/*      */       } 
/*      */ 
/*      */       
/*      */       ac.a a2;
/*      */       
/*      */       g g1;
/*      */       
/* 1276 */       if ((a2 = (g1 = f.d(paramc.c().b())).g()) != null) {
/* 1277 */         if (ak1 == null) {
/* 1278 */           ak1 = a2.c();
/*      */         }
/* 1280 */         if (ak2 == null) {
/* 1281 */           ak2 = a2.d();
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1287 */     ac.a a = f.q();
/* 1288 */     if (ak1 == null) {
/* 1289 */       ak1 = a.c();
/*      */     }
/* 1291 */     if (ak2 == null) {
/* 1292 */       ak2 = a.d();
/*      */     }
/*      */     
/* 1295 */     if (ak1 != null || ak2 != null) {
/* 1296 */       paramv = paramv.a(ak1, ak2);
/*      */     }
/* 1298 */     return paramv;
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
/*      */   public final k<?> a(g paramg, com.a.a.c.l.a parama, com.a.a.c.b paramb) {
/*      */     z z;
/*      */     k<?> k1;
/* 1312 */     f f = paramg.c();
/*      */     
/*      */     j j;
/*      */     
/* 1316 */     k<?> k3 = (k)(j = parama.u()).A();
/*      */     
/*      */     e e;
/*      */     
/* 1320 */     if ((e = (e)j.B()) == null) {
/* 1321 */       e = b(f, j);
/*      */     }
/*      */     
/*      */     k<?> k2;
/*      */     
/* 1326 */     if ((k2 = a(parama, f, paramb, e, k3)) == null) {
/* 1327 */       if (k3 == null) {
/* 1328 */         Class<String> clazz = j.b();
/* 1329 */         if (j.l()) {
/* 1330 */           return aa.a(clazz);
/*      */         }
/* 1332 */         if (clazz == String.class) {
/* 1333 */           return (k<?>)ak.a;
/*      */         }
/*      */       } 
/* 1336 */       z = new z((j)parama, k3, e);
/*      */     } 
/*      */     
/* 1339 */     if (this.a.b()) {
/* 1340 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1341 */         k1 = j.d((k)z); }
/*      */     
/*      */     }
/* 1344 */     return k1;
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
/*      */   public final k<?> a(g paramg, e parame, com.a.a.c.b paramb) {
/*      */     o o;
/*      */     h h;
/*      */     k<?> k2;
/*      */     j j;
/* 1360 */     k<?> k1 = (k)(j = parame.u()).A();
/* 1361 */     f f = paramg.c();
/*      */ 
/*      */     
/*      */     e e1;
/*      */     
/* 1366 */     if ((e1 = (e)j.B()) == null) {
/* 1367 */       e1 = b(f, j);
/*      */     }
/*      */     
/*      */     k<?> k3;
/*      */     
/* 1372 */     if ((k3 = a(parame, f, paramb, e1, k1)) == null) {
/* 1373 */       Class<?> clazz = parame.b();
/* 1374 */       if (k1 == null)
/*      */       {
/* 1376 */         if (EnumSet.class.isAssignableFrom(clazz)) {
/* 1377 */           o = new o(j, null);
/*      */         }
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
/* 1391 */     if (o == null) {
/* 1392 */       if (parame.k() || parame.d()) {
/*      */         e e2;
/* 1394 */         if ((e2 = a((j)parame, f)) == null) {
/*      */           
/* 1396 */           if (parame.B() == null) {
/* 1397 */             throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + parame);
/*      */           }
/* 1399 */           k2 = a.a(paramb);
/*      */         } else {
/* 1401 */           parame = e2;
/*      */           
/* 1403 */           paramb = f.b((j)parame);
/*      */         } 
/*      */       } 
/* 1406 */       if (k2 == null) {
/*      */         x x;
/* 1408 */         if (!(x = a(paramg, paramb)).l()) {
/*      */           
/* 1410 */           if (parame.a(ArrayBlockingQueue.class)) {
/* 1411 */             return (k<?>)new a((j)parame, k1, e1, x);
/*      */           }
/*      */           
/*      */           k<?> k;
/* 1415 */           if ((k = l.c((j)parame)) != null) {
/* 1416 */             return k;
/*      */           }
/*      */         } 
/*      */         
/* 1420 */         if (j.a(String.class)) {
/*      */           
/* 1422 */           al al = new al((j)parame, k1, x);
/*      */         } else {
/* 1424 */           h = new h((j)parame, k1, e1, x);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1429 */     if (this.a.b()) {
/* 1430 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1431 */         k2 = j.e((k)h); }
/*      */     
/*      */     }
/* 1434 */     return k2;
/*      */   }
/*      */ 
/*      */   
/*      */   private static e a(j paramj, f paramf) {
/*      */     Class<?> clazz;
/* 1440 */     if ((clazz = a.a(paramj)) != null) {
/* 1441 */       return (e)paramf.p()
/* 1442 */         .a(paramj, clazz, true);
/*      */     }
/* 1444 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> a(g paramg, d paramd, com.a.a.c.b paramb) {
/*      */     j j;
/* 1455 */     k<?> k2 = (k)(j = paramd.u()).A();
/* 1456 */     f f = paramg.c();
/*      */ 
/*      */     
/*      */     e e;
/*      */     
/* 1461 */     if ((e = (e)j.B()) == null) {
/* 1462 */       e = b(f, j);
/*      */     }
/*      */     
/*      */     k<?> k1;
/* 1466 */     if ((k1 = a(paramd, f, paramb, e, k2)) != null)
/*      */     {
/* 1468 */       if (this.a.b()) {
/* 1469 */         for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1470 */           k1 = j.f(k1); }
/*      */       
/*      */       }
/*      */     }
/* 1474 */     return k1;
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
/*      */   public final k<?> a(g paramg, h paramh, com.a.a.c.b paramb) {
/*      */     u u;
/*      */     k<?> k1;
/* 1488 */     f f = paramg.c();
/* 1489 */     j j1 = paramh.t();
/*      */ 
/*      */     
/*      */     j j2;
/*      */     
/* 1494 */     k<?> k3 = (k)(j2 = paramh.u()).A();
/*      */ 
/*      */     
/* 1497 */     p p = (p)j1.A();
/*      */     
/*      */     e e;
/*      */     
/* 1501 */     if ((e = (e)j2.B()) == null) {
/* 1502 */       e = b(f, j2);
/*      */     }
/*      */ 
/*      */     
/*      */     k<?> k2;
/*      */ 
/*      */     
/* 1509 */     if ((k2 = a(paramh, f, paramb, p, e, k3)) == null) {
/*      */       n n;
/* 1511 */       Class<?> clazz = paramh.b();
/* 1512 */       if (EnumMap.class.isAssignableFrom(clazz)) {
/*      */         x x;
/*      */ 
/*      */ 
/*      */         
/* 1517 */         if (clazz == EnumMap.class) {
/* 1518 */           clazz = null;
/*      */         } else {
/* 1520 */           x = a(paramg, paramb);
/*      */         } 
/* 1522 */         if (!j1.i()) {
/* 1523 */           throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
/*      */         }
/* 1525 */         n = new n((j)paramh, x, null, k3, e, null);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1540 */       if (n == null) {
/* 1541 */         if (paramh.k() || paramh.d()) {
/*      */           h h1;
/* 1543 */           if ((h1 = b((j)paramh, f)) != null) {
/*      */             
/* 1545 */             (paramh = h1).b();
/*      */             
/* 1547 */             paramb = f.b((j)paramh);
/*      */           } else {
/*      */             
/* 1550 */             if (paramh.B() == null) {
/* 1551 */               throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + paramh);
/*      */             }
/* 1553 */             k1 = a.a(paramb);
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 1558 */         else if ((k1 = l.d((j)paramh)) != null) {
/* 1559 */           return k1;
/*      */         } 
/*      */         
/* 1562 */         if (k1 == null) {
/* 1563 */           x x = a(paramg, paramb);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1568 */           u u1 = new u((j)paramh, x, p, k3, e);
/*      */           
/*      */           q.a a1;
/*      */           
/* 1572 */           Set set2 = ((a1 = f.b(Map.class, paramb.d())) == null) ? null : a1.c();
/* 1573 */           u1.a(set2);
/* 1574 */           Map.class;
/*      */           t.a a;
/* 1576 */           Set set1 = ((a = f.a(paramb.d())) == null) ? null : a.b();
/* 1577 */           u1.b(set1);
/* 1578 */           u = u1;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1582 */     if (this.a.b()) {
/* 1583 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1584 */         k1 = j.g((k)u); }
/*      */     
/*      */     }
/* 1587 */     return k1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static h b(j paramj, f paramf) {
/*      */     Class<?> clazz;
/* 1593 */     if ((clazz = a.b(paramj)) != null) {
/* 1594 */       return (h)paramf.p()
/* 1595 */         .a(paramj, clazz, true);
/*      */     }
/* 1597 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> a(g paramg, g paramg1, com.a.a.c.b paramb) {
/* 1606 */     j j1 = paramg1.t();
/* 1607 */     j j2 = paramg1.u();
/* 1608 */     f f = paramg.c();
/*      */ 
/*      */ 
/*      */     
/* 1612 */     k<?> k2 = (k)j2.A();
/*      */ 
/*      */     
/* 1615 */     p p = (p)j1.A();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     e e;
/*      */ 
/*      */ 
/*      */     
/* 1624 */     if ((e = (e)j2.B()) == null) {
/* 1625 */       e = b(f, j2);
/*      */     }
/*      */     
/*      */     k<?> k1;
/* 1629 */     if ((k1 = a(paramg1, f, paramb, p, e, k2)) != null)
/*      */     {
/* 1631 */       if (this.a.b()) {
/* 1632 */         for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1633 */           k1 = j.h(k1); }
/*      */       
/*      */       }
/*      */     }
/* 1637 */     return k1;
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
/*      */   public final k<?> a(g paramg, j paramj, com.a.a.c.b paramb) {
/*      */     l l;
/*      */     k<?> k1;
/* 1654 */     f f = paramg.c();
/* 1655 */     Class<?> clazz = paramj.b();
/*      */     
/*      */     k<?> k2;
/*      */     
/* 1659 */     if ((k2 = b(clazz, f, paramb)) == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1665 */       if (clazz == Enum.class) {
/* 1666 */         return a.a(paramb);
/*      */       }
/*      */       
/*      */       x x;
/*      */       
/* 1671 */       v[] arrayOfV = ((x = b(paramg, paramb)) == null) ? null : x.a(paramg.c());
/*      */       
/* 1673 */       for (k k : paramb.m()) {
/* 1674 */         if (d(paramg, (com.a.a.c.f.b)k)) {
/* 1675 */           if (k.f() == 0) {
/* 1676 */             k2 = l.a(f, clazz, k);
/*      */             
/*      */             break;
/*      */           } 
/*      */           Class<?> clazz1;
/* 1681 */           if (!(clazz1 = k.m()).isAssignableFrom(clazz)) {
/* 1682 */             paramg.a(paramj, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", new Object[] { k
/*      */                     
/* 1684 */                     .toString() }));
/*      */           }
/* 1686 */           k1 = l.a(f, clazz, k, x, arrayOfV);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */       
/* 1692 */       if (k1 == null)
/*      */       {
/*      */         
/* 1695 */         l = new l(a(clazz, f, paramb.q()), Boolean.valueOf(f.a(q.w)));
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1700 */     if (this.a.b()) {
/* 1701 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1702 */         k1 = j.b((k)l); }
/*      */     
/*      */     }
/* 1705 */     return k1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> a(f paramf, j paramj, com.a.a.c.b paramb) {
/* 1714 */     Class<? extends m> clazz = paramj.b();
/*      */     
/*      */     k<?> k;
/*      */     
/* 1718 */     if ((k = a(clazz, paramf, paramb)) != null) {
/* 1719 */       return k;
/*      */     }
/* 1721 */     return t.a(clazz);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> a(g paramg, j paramj, com.a.a.c.b paramb) {
/*      */     j j1;
/* 1731 */     k<?> k2 = (k)(j1 = paramj.u()).A();
/* 1732 */     f f = paramg.c();
/*      */     
/*      */     e e;
/* 1735 */     if ((e = (e)j1.B()) == null) {
/* 1736 */       e = b(f, j1);
/*      */     }
/*      */     
/*      */     k<?> k1;
/*      */     
/* 1741 */     if ((k1 = a(paramj, f, paramb, e, k2)) == null)
/*      */     {
/* 1743 */       if (paramj.b(AtomicReference.class)) {
/*      */         x x;
/*      */         Class<AtomicReference> clazz;
/* 1746 */         if ((clazz = paramj.b()) == AtomicReference.class) {
/* 1747 */           paramg = null;
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/* 1753 */           x = a(paramg, paramb);
/*      */         } 
/* 1755 */         return (k<?>)new e((j)paramj, x, e, k2);
/*      */       } 
/*      */     }
/* 1758 */     if (k1 != null)
/*      */     {
/* 1760 */       if (this.a.b()) {
/* 1761 */         for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1762 */           k1 = j.c(k1); }
/*      */       
/*      */       }
/*      */     }
/* 1766 */     return k1;
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
/*      */   public final e b(f paramf, j paramj) {
/*      */     com.a.a.c.b b1;
/* 1781 */     d d = (b1 = paramf.c(paramj.b())).d();
/*      */     
/*      */     com.a.a.c.a a;
/*      */     
/*      */     h h;
/*      */     
/* 1787 */     if ((h = (a = paramf.j()).a((q)paramf, d, paramj)) == null && (
/*      */       
/* 1789 */       h = paramf.n()) == null) {
/* 1790 */       return null;
/*      */     }
/*      */     
/* 1793 */     Collection collection = paramf.w().b((q)paramf, d);
/*      */     
/*      */     j j1;
/*      */     
/* 1797 */     if (h.a() == null && paramj.d() && (
/*      */ 
/*      */ 
/*      */       
/* 1801 */       j1 = a(paramf, paramj)) != null && !j1.a(paramj.b())) {
/* 1802 */       h = h.b(j1.b());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1808 */       return h.a(paramf, paramj, collection);
/* 1809 */     } catch (IllegalArgumentException|IllegalStateException illegalArgumentException) {
/* 1810 */       throw com.a.a.c.d.b.a((l)null, 
/* 1811 */           i.g(illegalArgumentException), paramj)
/* 1812 */         .a(illegalArgumentException);
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
/*      */   private static k<?> d(g paramg, j paramj, com.a.a.c.b paramb) {
/* 1825 */     return g.a.a(paramj, paramg.c(), paramb);
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
/*      */   public final p a(g paramg, j paramj) {
/*      */     p p;
/* 1839 */     f f = paramg.c();
/* 1840 */     com.a.a.c.b b1 = null;
/* 1841 */     r r = null;
/* 1842 */     if (this.a.a()) {
/* 1843 */       b1 = f.d(paramj);
/* 1844 */       for (Iterator<r> iterator = this.a.f().iterator(); iterator.hasNext() && (
/*      */         
/* 1846 */         p = (r = iterator.next()).a(paramj)) == null;);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1853 */     if (p == null) {
/*      */       
/* 1855 */       if (b1 == null) {
/* 1856 */         b1 = f.c(paramj.b());
/*      */       }
/*      */       
/* 1859 */       if ((p = b(paramg, (com.a.a.c.f.b)b1.d())) == null) {
/* 1860 */         if (paramj.h()) {
/* 1861 */           p = b(paramg, paramj);
/*      */         } else {
/* 1863 */           p = ah.a(f, paramj);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1868 */     if (p != null && 
/* 1869 */       this.a.b()) {
/* 1870 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1871 */         p = j.a(p); }
/*      */     
/*      */     }
/*      */     
/* 1875 */     return p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private p b(g paramg, j paramj) {
/* 1882 */     f f = paramg.c();
/* 1883 */     Class<?> clazz = paramj.b();
/*      */     
/* 1885 */     com.a.a.c.b b1 = f.a(paramj);
/*      */     
/*      */     p p;
/* 1888 */     if ((p = b(paramg, (com.a.a.c.f.b)b1.d())) != null) {
/* 1889 */       return p;
/*      */     }
/*      */     
/*      */     k<?> k;
/* 1893 */     if ((k = b(clazz, f, b1)) != null) {
/* 1894 */       return ah.a(paramj, k);
/*      */     }
/*      */     k<Object> k1;
/* 1897 */     if ((k1 = a(paramg, (com.a.a.c.f.b)b1.d())) != null) {
/* 1898 */       return ah.a(paramj, k1);
/*      */     }
/*      */     
/* 1901 */     l l = a(clazz, f, b1.q());
/*      */ 
/*      */     
/* 1904 */     for (k k2 : b1.m()) {
/* 1905 */       if (d(paramg, (com.a.a.c.f.b)k2)) {
/*      */         int i; Class<?> clazz1;
/* 1907 */         if ((i = k2.f()) == 1 && (
/*      */ 
/*      */           
/* 1910 */           clazz1 = k2.m()).isAssignableFrom(clazz)) {
/*      */           
/* 1912 */           if (k2.a(0) == String.class) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1919 */             if (f.g()) {
/* 1920 */               i.a(k2.l(), paramg
/* 1921 */                   .a(q.o));
/*      */             }
/* 1923 */             return ah.a(l, k2);
/*      */           }  continue;
/*      */         } 
/* 1926 */         throw new IllegalArgumentException("Unsuitable method (" + k2 + ") decorated with @JsonCreator (for Enum type " + clazz
/* 1927 */             .getName() + ")");
/*      */       } 
/*      */     } 
/*      */     
/* 1931 */     return ah.a(l);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private e a(f paramf, j paramj, j paramj1) {
/*      */     com.a.a.c.a a;
/*      */     h h;
/* 2014 */     if ((h = (a = paramf.j()).a((q)paramf, paramj1, paramj)) == null) {
/* 2015 */       return b(paramf, paramj);
/*      */     }
/*      */     
/* 2018 */     Collection collection = paramf.w().b((q)paramf, paramj1, paramj);
/*      */     
/*      */     try {
/* 2021 */       return h.a(paramf, paramj, collection);
/* 2022 */     } catch (IllegalArgumentException|IllegalStateException illegalArgumentException) {
/* 2023 */       throw com.a.a.c.d.b.a((l)null, 
/* 2024 */           i.g(illegalArgumentException), paramj)
/* 2025 */         .a(illegalArgumentException);
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
/*      */   private e b(f paramf, j paramj, j paramj1) {
/*      */     com.a.a.c.a a;
/* 2045 */     h h = (a = paramf.j()).b((q)paramf, paramj1, paramj);
/* 2046 */     paramj = paramj.u();
/*      */     
/* 2048 */     if (h == null) {
/* 2049 */       return b(paramf, paramj);
/*      */     }
/*      */     
/* 2052 */     Collection collection = paramf.w().b((q)paramf, paramj1, paramj);
/*      */     
/* 2054 */     return h.a(paramf, paramj, collection);
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
/*      */   public final k<?> b(g paramg, j paramj, com.a.a.c.b paramb) {
/*      */     p p;
/*      */     j j1;
/*      */     e e;
/*      */     Class<?> clazz;
/* 2070 */     if ((clazz = paramj.b()) == b || clazz == g) {
/*      */       Class<?> clazz1;
/* 2072 */       f f = paramg.c();
/*      */ 
/*      */       
/* 2075 */       if (this.a.c()) {
/* 2076 */         j j2 = a(f, List.class);
/* 2077 */         j1 = a(f, Map.class);
/*      */       } else {
/* 2079 */         clazz1 = clazz = null;
/*      */       } 
/* 2081 */       return (k<?>)new aq((j)clazz1, (j)clazz);
/*      */     } 
/*      */     
/* 2084 */     if (clazz == c || clazz == d) {
/* 2085 */       return (k<?>)am.a;
/*      */     }
/* 2087 */     if (clazz == e) {
/*      */       
/* 2089 */       o o = paramg.b();
/*      */       j[] arrayOfJ;
/* 2091 */       j1 = ((arrayOfJ = o.c(paramj, e)) == null || arrayOfJ.length != 1) ? o.b() : arrayOfJ[0];
/* 2092 */       e e1 = o.a(Collection.class, j1);
/*      */       
/* 2094 */       return a(paramg, e1, paramb);
/*      */     } 
/* 2096 */     if (j1 == f) {
/*      */       
/* 2098 */       j j2 = paramj.b(0);
/*      */       
/*      */       j j3;
/* 2101 */       if ((e = (e)(j3 = paramj.b(1)).B()) == null) {
/* 2102 */         e = b(paramg.c(), j3);
/*      */       }
/* 2104 */       k k1 = (k)j3.A();
/* 2105 */       p = (p)j2.A();
/* 2106 */       return (k<?>)new v(paramj, p, k1, e);
/*      */     } 
/* 2108 */     String str = e.getName();
/* 2109 */     if (e.isPrimitive() || str.startsWith("java.")) {
/*      */       k<?> k1;
/*      */       
/* 2112 */       if ((k1 = x.a((Class)e, str)) == null) {
/* 2113 */         k1 = j.a((Class)e, str);
/*      */       }
/* 2115 */       if (k1 != null) {
/* 2116 */         return k1;
/*      */       }
/*      */     } 
/*      */     
/* 2120 */     if (e == ac.class) {
/* 2121 */       return (k<?>)new ao();
/*      */     }
/*      */     k<?> k;
/* 2124 */     if ((k = d((g)p, paramj, paramb)) != null) {
/* 2125 */       return k;
/*      */     }
/* 2127 */     return r.a((g)p, (Class)e, str);
/*      */   }
/*      */   
/*      */   private j a(f paramf, Class<?> paramClass) {
/*      */     j j;
/* 2132 */     if ((j = a(paramf, paramf.b(paramClass))) == null || j.a(paramClass)) return null;  return j;
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
/*      */   private k<?> a(Class<? extends m> paramClass, f paramf, com.a.a.c.b paramb) {
/* 2145 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */       
/* 2147 */       if ((k = (a = iterator.next()).d()) != null) {
/* 2148 */         return k;
/*      */       }
/*      */     } 
/* 2151 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(j paramj, f paramf, com.a.a.c.b paramb, e parame, k<?> paramk) {
/* 2159 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2162 */       if ((k1 = (a = iterator.next()).f()) != null) {
/* 2163 */         return k1;
/*      */       }
/*      */     } 
/* 2166 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final k<Object> a(j paramj, f paramf, com.a.a.c.b paramb) {
/* 2174 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */       
/* 2176 */       if ((k = (a = iterator.next()).e()) != null) {
/* 2177 */         return k;
/*      */       }
/*      */     } 
/* 2180 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(com.a.a.c.l.a parama, f paramf, com.a.a.c.b paramb, e parame, k<?> paramk) {
/* 2188 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2191 */       if ((k1 = (a1 = iterator.next()).g()) != null) {
/* 2192 */         return k1;
/*      */       }
/*      */     } 
/* 2195 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(e parame, f paramf, com.a.a.c.b paramb, e parame1, k<?> paramk) {
/* 2203 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2206 */       if ((k1 = (a = iterator.next()).h()) != null) {
/* 2207 */         return k1;
/*      */       }
/*      */     } 
/* 2210 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(d paramd, f paramf, com.a.a.c.b paramb, e parame, k<?> paramk) {
/* 2218 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2221 */       if ((k1 = (a = iterator.next()).i()) != null) {
/* 2222 */         return k1;
/*      */       }
/*      */     } 
/* 2225 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> b(Class<?> paramClass, f paramf, com.a.a.c.b paramb) {
/* 2232 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */       
/* 2234 */       if ((k = (a = iterator.next()).c()) != null) {
/* 2235 */         return k;
/*      */       }
/*      */     } 
/* 2238 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(h paramh, f paramf, com.a.a.c.b paramb, p paramp, e parame, k<?> paramk) {
/* 2247 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2250 */       if ((k1 = (a = iterator.next()).j()) != null) {
/* 2251 */         return k1;
/*      */       }
/*      */     } 
/* 2254 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<?> a(g paramg, f paramf, com.a.a.c.b paramb, p paramp, e parame, k<?> paramk) {
/* 2263 */     for (Iterator<w.a> iterator = this.a.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 2266 */       if ((k1 = (a = iterator.next()).k()) != null) {
/* 2267 */         return k1;
/*      */       }
/*      */     } 
/* 2270 */     return null;
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
/*      */   protected static k<Object> a(g paramg, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*      */     com.a.a.c.a a;
/* 2292 */     if ((a = paramg.f()) != null && (
/*      */       
/* 2294 */       object = a.z(paramb)) != null) {
/* 2295 */       return paramg.b(paramb, object);
/*      */     }
/*      */     
/* 2298 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static p b(g paramg, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*      */     com.a.a.c.a a;
/* 2311 */     if ((a = paramg.f()) != null && (
/*      */       
/* 2313 */       object = a.A(paramb)) != null) {
/* 2314 */       return paramg.c(paramb, object);
/*      */     }
/*      */     
/* 2317 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static k<Object> c(g paramg, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*      */     com.a.a.c.a a;
/* 2328 */     if ((a = paramg.f()) != null && (
/*      */       
/* 2330 */       object = a.B(paramb)) != null) {
/* 2331 */       return paramg.b(paramb, object);
/*      */     }
/*      */     
/* 2334 */     return null;
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
/*      */   protected final j a(g paramg, j paramj, j paramj1) {
/*      */     g g1;
/*      */     com.a.a.c.a a;
/* 2351 */     if ((a = paramg.f()) == null) {
/* 2352 */       return paramj1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2361 */     Object object = a.A((com.a.a.c.f.b)paramj);
/*      */     j j2;
/* 2363 */     if (paramj1.p() && (j2 = paramj1.t()) != null && (object = paramg.c((com.a.a.c.f.b)paramj, object)) != null)
/*      */     {
/* 2365 */       (g1 = ((g)paramj1).i(object)).t();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2370 */     if (g1.c()) {
/* 2371 */       object = a.B((com.a.a.c.f.b)paramj);
/*      */       
/* 2373 */       if ((object = paramg.b((com.a.a.c.f.b)paramj, object)) != null) {
/* 2374 */         j1 = g1.d(object);
/*      */       }
/*      */ 
/*      */       
/* 2378 */       if ((object = b(paramg.c(), j1, paramj)) != null) {
/* 2379 */         j1 = j1.b(object);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2384 */     if ((object = a(paramg.c(), j1, paramj)) != null) {
/* 2385 */       j1 = j1.a(object);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     j j1;
/*      */ 
/*      */ 
/*      */     
/* 2394 */     return j1 = a.b((q)paramg.c(), (com.a.a.c.f.b)paramj, j1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static l a(Class<?> paramClass, f paramf, j paramj) {
/* 2400 */     if (paramj != null) {
/* 2401 */       if (paramf.g()) {
/* 2402 */         i.a(paramj.i(), paramf
/* 2403 */             .a(q.o));
/*      */       }
/* 2405 */       return l.a(paramf, paramClass, paramj);
/*      */     } 
/*      */ 
/*      */     
/* 2409 */     return l.a(paramf, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean d(g paramg, com.a.a.c.f.b paramb) {
/*      */     com.a.a.c.a a;
/* 2418 */     if ((a = paramg.f()) != null) {
/*      */       i.a a1;
/* 2420 */       if ((a1 = a.a((q)paramg.c(), paramb)) != null && a1 != i.a.d) return true;  return false;
/*      */     } 
/* 2422 */     return false;
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
/*      */   public static class a
/*      */   {
/*      */     private static HashMap<String, Class<? extends Collection>> a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static HashMap<String, Class<? extends Map>> b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/* 2487 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*      */       
/* 2489 */       Class<ArrayList> clazz1 = ArrayList.class;
/* 2490 */       Class<HashSet> clazz2 = HashSet.class;
/*      */       
/* 2492 */       hashMap.put(Collection.class.getName(), clazz1);
/* 2493 */       hashMap.put(List.class.getName(), clazz1);
/* 2494 */       hashMap.put(Set.class.getName(), clazz2);
/* 2495 */       hashMap.put(SortedSet.class.getName(), TreeSet.class);
/* 2496 */       hashMap.put(Queue.class.getName(), LinkedList.class);
/*      */ 
/*      */       
/* 2499 */       hashMap.put(AbstractList.class.getName(), clazz1);
/* 2500 */       hashMap.put(AbstractSet.class.getName(), clazz2);
/*      */ 
/*      */       
/* 2503 */       hashMap.put(Deque.class.getName(), LinkedList.class);
/* 2504 */       hashMap.put(NavigableSet.class.getName(), TreeSet.class);
/*      */       
/* 2506 */       a = (HashMap)hashMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2514 */       hashMap = new HashMap<>();
/*      */       
/* 2516 */       Class<LinkedHashMap> clazz = LinkedHashMap.class;
/* 2517 */       hashMap.put(Map.class.getName(), clazz);
/* 2518 */       hashMap.put(AbstractMap.class.getName(), clazz);
/* 2519 */       hashMap.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
/* 2520 */       hashMap.put(SortedMap.class.getName(), TreeMap.class);
/*      */       
/* 2522 */       hashMap.put(NavigableMap.class.getName(), TreeMap.class);
/* 2523 */       hashMap.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
/*      */ 
/*      */       
/* 2526 */       b = (HashMap)hashMap;
/*      */     }
/*      */     
/*      */     public static Class<?> a(j param1j) {
/* 2530 */       return a.get(param1j.b().getName());
/*      */     }
/*      */     
/*      */     public static Class<?> b(j param1j) {
/* 2534 */       return b.get(param1j.b().getName());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class b
/*      */   {
/*      */     private g e;
/*      */     
/*      */     public final com.a.a.c.b a;
/*      */     
/*      */     public final ap<?> b;
/*      */     
/*      */     public final e c;
/*      */     
/*      */     public final Map<o, s[]> d;
/*      */     
/*      */     private List<d> f;
/*      */     
/*      */     private int g;
/*      */     
/*      */     private List<d> h;
/*      */     
/*      */     private int i;
/*      */ 
/*      */     
/*      */     public b(g param1g, com.a.a.c.b param1b, ap<?> param1ap, e param1e, Map<o, s[]> param1Map) {
/* 2562 */       this.e = param1g;
/* 2563 */       this.a = param1b;
/* 2564 */       this.b = param1ap;
/* 2565 */       this.c = param1e;
/* 2566 */       this.d = param1Map;
/*      */     }
/*      */     
/*      */     public final com.a.a.c.a a() {
/* 2570 */       return this.e.f();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void a(d param1d) {
/* 2576 */       if (this.f == null) {
/* 2577 */         this.f = new LinkedList<>();
/*      */       }
/* 2579 */       this.f.add(param1d);
/*      */     }
/*      */     
/*      */     public final void b() {
/* 2583 */       this.g++;
/*      */     }
/*      */     
/*      */     public final boolean c() {
/* 2587 */       return (this.g > 0);
/*      */     }
/*      */     
/*      */     public final boolean d() {
/* 2591 */       return (this.f != null);
/*      */     }
/*      */     
/*      */     public final List<d> e() {
/* 2595 */       return this.f;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void b(d param1d) {
/* 2601 */       if (this.h == null) {
/* 2602 */         this.h = new LinkedList<>();
/*      */       }
/* 2604 */       this.h.add(param1d);
/*      */     }
/*      */     
/*      */     public final void f() {
/* 2608 */       this.i++;
/*      */     }
/*      */     
/*      */     public final boolean g() {
/* 2612 */       return (this.i > 0);
/*      */     }
/*      */     
/*      */     public final boolean h() {
/* 2616 */       return (this.h != null);
/*      */     }
/*      */     
/*      */     public final List<d> i() {
/* 2620 */       return this.h;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */