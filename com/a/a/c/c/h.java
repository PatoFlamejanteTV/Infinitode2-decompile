/*      */ package com.a.a.c.c;
/*      */ import com.a.a.a.al;
/*      */ import com.a.a.a.am;
/*      */ import com.a.a.a.q;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.a.e;
/*      */ import com.a.a.c.b;
/*      */ import com.a.a.c.b.m;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.c.a.aa;
/*      */ import com.a.a.c.c.a.i;
/*      */ import com.a.a.c.c.a.o;
/*      */ import com.a.a.c.c.a.w;
/*      */ import com.a.a.c.c.b.an;
/*      */ import com.a.a.c.f;
/*      */ import com.a.a.c.f.ad;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.f.k;
/*      */ import com.a.a.c.f.s;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i.e;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.m.aa;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.p;
/*      */ import com.a.a.c.q;
/*      */ import com.a.a.c.v;
/*      */ import com.a.a.c.w;
/*      */ import com.a.a.c.x;
/*      */ import com.d.c.d.a.j;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ 
/*      */ public final class h extends b implements Serializable {
/*   41 */   private static final Class<?>[] c = new Class[] { Throwable.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   53 */   public static final h b = new h(new m());
/*      */ 
/*      */   
/*      */   private h(m paramm) {
/*   57 */     super(paramm);
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
/*      */   public final k<Object> c(g paramg, j paramj, b paramb) {
/*   98 */     f f = paramg.c();
/*      */     
/*      */     k<Object> k;
/*  101 */     if ((k = a(paramj, f, paramb)) != null) {
/*      */       
/*  103 */       if (this.a.b()) {
/*  104 */         for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  105 */           paramg.c(); k = j.a(k); }
/*      */       
/*      */       }
/*  108 */       return k;
/*      */     } 
/*      */ 
/*      */     
/*  112 */     if (paramj.f()) {
/*  113 */       return c(paramg, paramb);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  120 */     if (paramj.d() && !paramj.l() && !paramj.h()) {
/*      */       j j1;
/*      */       
/*  123 */       if ((j1 = b(paramg, paramb)) != null) {
/*      */ 
/*      */         
/*  126 */         paramb = f.a(j1);
/*  127 */         return e(paramg, j1, paramb);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  132 */     if ((k = (k)d(paramg, paramj, paramb)) != null) {
/*  133 */       return k;
/*      */     }
/*      */ 
/*      */     
/*  137 */     b(paramj.b());
/*      */ 
/*      */ 
/*      */     
/*  141 */     g(paramg, paramj, paramb);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  146 */     if ((k = b(paramg, paramj)) != null) {
/*  147 */       return k;
/*      */     }
/*      */ 
/*      */     
/*  151 */     return e(paramg, paramj, paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<Object> a(g paramg, j paramj, b paramb, Class<?> paramClass) {
/*      */     j j1;
/*  162 */     if (paramg.a(q.r)) {
/*  163 */       j1 = paramg.b().a(paramClass, paramj.x());
/*      */     } else {
/*  165 */       j1 = paramg.b((Class)j1);
/*      */     } 
/*  167 */     paramb = paramg.c().a(j1, paramb);
/*      */ 
/*      */     
/*  170 */     return f(paramg, paramj, paramb);
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
/*      */   private k<?> d(g paramg, j paramj, b paramb) {
/*      */     k<?> k;
/*  185 */     if ((k = b(paramg, paramj, paramb)) != null && 
/*  186 */       this.a.b()) {
/*  187 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  188 */         paramg.c(); k = j.a(k); }
/*      */     
/*      */     }
/*      */     
/*  192 */     return k;
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
/*      */   private static k<Object> b(g paramg, j paramj) {
/*      */     String str;
/*  211 */     if ((str = f.b(paramj)) != null)
/*      */     {
/*      */       
/*  214 */       if (paramg.c().i(paramj.b()) == null) {
/*  215 */         return (k<Object>)new ac(paramj, str);
/*      */       }
/*      */     }
/*  218 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j b(g paramg, b paramb) {
/*  226 */     for (Iterator iterator = this.a.h().iterator(); iterator.hasNext(); ) { iterator.next();
/*  227 */       paramg.c(); j j;
/*  228 */       if ((j = d.b()) != null) {
/*  229 */         return j;
/*      */       } }
/*      */     
/*  232 */     return null;
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
/*      */   private k<Object> e(g paramg, j paramj, b paramb) {
/*      */     k<?> k;
/*      */     x x;
/*      */     try {
/*  262 */       x = a(paramg, paramb);
/*  263 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/*  264 */       return (k<Object>)new f(noClassDefFoundError);
/*  265 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */ 
/*      */       
/*  269 */       throw b.a(paramg.j(), 
/*  270 */           i.g(illegalArgumentException), paramb, null)
/*      */         
/*  272 */         .a(illegalArgumentException);
/*      */     } 
/*      */     g g1;
/*  275 */     (g1 = d(paramg, paramb)).a(x);
/*      */     
/*  277 */     b(paramg, paramb, g1);
/*  278 */     a(paramg, paramb, g1);
/*      */ 
/*      */     
/*  281 */     c(paramg, paramb, g1);
/*  282 */     a(paramb, g1);
/*      */     
/*  284 */     paramg.c();
/*  285 */     if (this.a.b()) {
/*  286 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  287 */         g1 = j.a(g1); }
/*      */     
/*      */     }
/*      */ 
/*      */     
/*  292 */     if (paramj.d() && !x.d()) {
/*  293 */       k = g1.h();
/*      */     } else {
/*  295 */       k = g1.g();
/*      */     } 
/*      */ 
/*      */     
/*  299 */     if (this.a.b()) {
/*  300 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  301 */         k = j.a(k); }
/*      */     
/*      */     }
/*  304 */     return (k)k;
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
/*      */   private k<Object> f(g paramg, j paramj, b paramb) {
/*      */     x x;
/*      */     try {
/*  322 */       x = a(paramg, paramb);
/*  323 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/*  324 */       return (k<Object>)new f(noClassDefFoundError);
/*  325 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */ 
/*      */       
/*  329 */       throw b.a(paramg.j(), 
/*  330 */           i.g(illegalArgumentException), paramb, null);
/*      */     } 
/*      */     
/*  333 */     f f = paramg.c();
/*      */     g g1;
/*  335 */     (g1 = d(paramg, paramb)).a(x);
/*      */     
/*  337 */     b(paramg, paramb, g1);
/*  338 */     a(paramg, paramb, g1);
/*      */ 
/*      */     
/*  341 */     c(paramg, paramb, g1);
/*  342 */     a(paramb, g1);
/*      */     
/*      */     e.a a;
/*  345 */     String str = ((a = paramb.x()) == null) ? "build" : a.a;
/*      */ 
/*      */     
/*      */     k k1;
/*      */     
/*  350 */     if ((k1 = paramb.a(str, null)) != null && 
/*  351 */       f.g()) {
/*  352 */       i.a(k1.l(), f.a(q.o));
/*      */     }
/*      */     
/*  355 */     g1.a(k1, a);
/*      */     
/*  357 */     if (this.a.b()) {
/*  358 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  359 */         g1 = j.a(g1); }
/*      */     
/*      */     }
/*  362 */     k<?> k = g1.a(paramj, str);
/*      */ 
/*      */ 
/*      */     
/*  366 */     if (this.a.b()) {
/*  367 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  368 */         k = j.a(k); }
/*      */     
/*      */     }
/*  371 */     return (k)k;
/*      */   }
/*      */   private static void a(g paramg, b paramb, g paramg1) {
/*      */     w w;
/*      */     al al;
/*      */     j j;
/*      */     v v;
/*      */     ad ad;
/*  379 */     if ((ad = paramb.e()) == null) {
/*      */       return;
/*      */     }
/*  382 */     Class<am.c> clazz = ad.d();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  387 */     an an = paramg.b((b)paramb.d(), ad);
/*      */ 
/*      */     
/*  390 */     if (clazz == am.c.class) {
/*  391 */       w w1 = ad.b();
/*      */       
/*  393 */       if ((v = paramg1.a(w1)) == null)
/*  394 */         throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[] {
/*      */                 
/*  396 */                 i.b(paramb.a()), 
/*  397 */                 i.a(w1)
/*      */               })); 
/*  399 */       j = v.c();
/*  400 */       w = new w(ad.c());
/*      */     } else {
/*  402 */       j j1 = paramg.b((Class)j);
/*  403 */       paramg.b(); j = o.c(j1, al.class)[0];
/*  404 */       v = null;
/*  405 */       al = paramg.a((b)w.d(), ad);
/*      */     } 
/*      */     
/*  408 */     k k = paramg.b(j);
/*  409 */     paramg1.a(s.a(j, ad
/*  410 */           .b(), al, k, v, an));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k<Object> c(g paramg, b paramb) {
/*      */     k<Object> k;
/*  418 */     f f = paramg.c();
/*      */     
/*      */     g g1;
/*  421 */     (g1 = d(paramg, paramb)).a(a(paramg, paramb));
/*      */     
/*  423 */     b(paramg, paramb, g1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  430 */     Iterator<v> iterator = g1.a();
/*  431 */     while (iterator.hasNext()) {
/*  432 */       v v = iterator.next();
/*  433 */       if ("setCause".equals(v.e().b())) {
/*      */         
/*  435 */         iterator.remove();
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     k k2;
/*  440 */     if ((k2 = paramb.a("initCause", c)) != null) {
/*      */       
/*  442 */       String str = "cause";
/*      */       x x;
/*  444 */       if ((x = f.k()) != null) {
/*  445 */         str = x.c("cause");
/*      */       }
/*  447 */       aa aa = aa.a((q)paramg.c(), (j)k2, new w(str));
/*      */       
/*      */       v v;
/*      */       
/*  451 */       if ((v = a(paramg, paramb, (s)aa, k2.b(0))) != null)
/*      */       {
/*      */         
/*  454 */         g1.a(v);
/*      */       }
/*      */     } 
/*      */     
/*  458 */     if (this.a.b()) {
/*  459 */       for (iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  460 */         g1 = j.a(g1); }
/*      */     
/*      */     }
/*      */ 
/*      */     
/*      */     k<?> k1;
/*      */ 
/*      */     
/*  468 */     an an = an.a((d)(k1 = g1.g()));
/*      */ 
/*      */ 
/*      */     
/*  472 */     if (this.a.b()) {
/*  473 */       for (Iterator iterator1 = this.a.g().iterator(); iterator1.hasNext(); ) { iterator1.next();
/*  474 */         k = j.a((k)an); }
/*      */     
/*      */     }
/*  477 */     return k;
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
/*      */   private static g d(g paramg, b paramb) {
/*  493 */     return new g(paramb, paramg);
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
/*      */   private void b(g paramg, b paramb, g paramg1) {
/*      */     Set<?> set;
/*      */     v[] arrayOfV;
/*  511 */     boolean bool1, bool2 = ((arrayOfV = (v[])((bool1 = !paramb.a().d() ? true : false) ? paramg1.c().a(paramg.c()) : null)) != null) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     q.a a;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  521 */     if ((a = paramg.c().b(paramb.b(), paramb.d())) != null) {
/*  522 */       boolean bool = a.d();
/*  523 */       paramg1.a(bool);
/*      */ 
/*      */       
/*  526 */       for (String str : set = a.c()) {
/*  527 */         paramg1.a(str);
/*      */       }
/*      */     } else {
/*  530 */       set = Collections.emptySet();
/*      */     } 
/*  532 */     paramb
/*  533 */       .b(); t.a a1 = paramg.c().a(paramb
/*  534 */         .d());
/*  535 */     Set<String> set1 = null;
/*  536 */     if (a1 != null && (
/*      */       
/*  538 */       set1 = a1.b()) != null) {
/*  539 */       for (String str : set1) {
/*  540 */         paramg1.b(str);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     j j;
/*      */     
/*  547 */     if ((j = paramb.s()) != null) {
/*  548 */       paramg1.a(a(paramg, paramb, j));
/*      */     } else {
/*      */       Set set2;
/*      */ 
/*      */       
/*  553 */       if ((set2 = paramb.i()) != null) {
/*  554 */         for (String str : set2)
/*      */         {
/*      */           
/*  557 */           paramg1.a(str);
/*      */         }
/*      */       }
/*      */     } 
/*      */     
/*  562 */     boolean bool3 = (paramg.a(q.b) && paramg.a(q.f)) ? true : false;
/*      */ 
/*      */     
/*  565 */     List<s> list = a(paramg, paramg1, paramb
/*  566 */         .h(), (Set)set, set1);
/*      */     
/*  568 */     if (this.a.b()) {
/*  569 */       for (Iterator iterator = this.a.g().iterator(); iterator.hasNext(); ) { iterator.next();
/*  570 */         paramg.c(); list = j.a(list); }
/*      */     
/*      */     }
/*      */ 
/*      */     
/*  575 */     for (s s : list) {
/*  576 */       v v; list = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  581 */       if (s.k()) {
/*      */         k k;
/*  583 */         j j1 = (k = s.o()).b(0);
/*  584 */         v = a(paramg, paramb, s, j1);
/*  585 */       } else if (s.l()) {
/*      */         com.a.a.c.f.h h1;
/*  587 */         j j1 = (h1 = s.p()).c();
/*  588 */         v = a(paramg, paramb, s, j1);
/*      */       } else {
/*      */         k k;
/*      */         
/*  592 */         if ((k = s.n()) != null) {
/*  593 */           if (bool3 && a(k.d())) {
/*      */ 
/*      */             
/*  596 */             if (!paramg1.c(s.a()))
/*      */             {
/*      */               
/*  599 */               v = a(paramg, paramb, s); } 
/*      */           } else {
/*  601 */             v v1; if (!s.m() && (
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  607 */               v1 = s.h()).d() != null) {
/*  608 */               v = a(paramg, paramb, s);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  616 */       if (bool2 && s.m()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  622 */         String str = s.a();
/*  623 */         m m = null; v[] arrayOfV1;
/*      */         int k;
/*  625 */         for (int i = (arrayOfV1 = arrayOfV).length; k < i; ) { v v1 = arrayOfV1[k];
/*  626 */           if (str.equals(v1.a()) && v1 instanceof m) {
/*  627 */             m = (m)v1; break;
/*      */           } 
/*      */           k++; }
/*      */         
/*  631 */         if (m == null) {
/*  632 */           ArrayList<String> arrayList = new ArrayList(); v[] arrayOfV2; byte b1;
/*  633 */           for (k = (arrayOfV2 = arrayOfV).length, b1 = 0; b1 < k; ) { v = arrayOfV2[b1];
/*  634 */             arrayList.add(v.a()); b1++; }
/*      */           
/*  636 */           paramg.a(paramb, s, "Could not find creator property with name %s (known Creator properties: %s)", new Object[] {
/*      */                 
/*  638 */                 i.b(str), arrayList });
/*      */           continue;
/*      */         } 
/*  641 */         if (v != null) {
/*  642 */           m.a(v);
/*      */         }
/*      */         Class[] arrayOfClass;
/*  645 */         if ((arrayOfClass = s.w()) == null) {
/*  646 */           arrayOfClass = paramb.y();
/*      */         }
/*  648 */         m.a(arrayOfClass);
/*  649 */         paramg1.c(m);
/*      */         continue;
/*      */       } 
/*  652 */       if (v != null) {
/*      */         Class[] arrayOfClass;
/*      */         
/*  655 */         if ((arrayOfClass = s.w()) == null) {
/*  656 */           arrayOfClass = paramb.y();
/*      */         }
/*  658 */         v.a(arrayOfClass);
/*  659 */         paramg1.b(v);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(Class<?> paramClass) {
/*  668 */     if (Collection.class.isAssignableFrom(paramClass) || Map.class
/*  669 */       .isAssignableFrom(paramClass)) return true;
/*      */     
/*      */     return false;
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
/*      */   private List<s> a(g paramg, g paramg1, List<s> paramList, Set<String> paramSet1, Set<String> paramSet2) {
/*  705 */     ArrayList<s> arrayList = new ArrayList(Math.max(4, paramList.size()));
/*  706 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*      */     
/*  708 */     for (Iterator<s> iterator = paramList.iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/*  711 */       if (!n.a(str = (s = iterator.next()).a(), paramSet1, paramSet2)) {
/*      */         Class<?> clazz;
/*      */         
/*  714 */         if (!s.m() && (
/*      */ 
/*      */           
/*  717 */           clazz = s.g()) != null && 
/*  718 */           a(paramg.c(), clazz, (Map)hashMap)) {
/*      */           
/*  720 */           paramg1.a(str);
/*      */           
/*      */           continue;
/*      */         } 
/*  724 */         arrayList.add(s);
/*      */       } 
/*  726 */     }  return arrayList;
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
/*      */   private void c(g paramg, b paramb, g paramg1) {
/*      */     List list;
/*  741 */     if ((list = paramb.j()) != null) {
/*  742 */       for (Iterator<s> iterator = list.iterator(); iterator.hasNext(); ) {
/*      */         s s;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  759 */         String str = (s = iterator.next()).y();
/*  760 */         paramg1.a(str, a(paramg, paramb, s, s
/*  761 */               .f()));
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
/*      */   private static void a(b paramb, g paramg) {
/*      */     Map map;
/*  783 */     if ((map = paramb.v()) != null) {
/*  784 */       for (Iterator<Map.Entry> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
/*  785 */         Map.Entry<?, j> entry; j j = (entry = iterator.next()).getValue();
/*      */         
/*  787 */         paramb
/*  788 */           .g(); paramg.a(w.a(j.b()), j.c(), j, entry.getKey());
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
/*      */   private u a(g paramg, b paramb, j paramj) {
/*      */     c.b b1;
/*      */     j j1, j2;
/*  810 */     boolean bool = paramj instanceof com.a.a.c.f.h;
/*      */     
/*  812 */     if (paramj instanceof k) {
/*      */       k k1;
/*      */       
/*  815 */       j1 = (k1 = (k)paramj).b(0);
/*  816 */       j2 = k1.b(1);
/*  817 */       j2 = a(paramg, paramj, j2);
/*  818 */       b1 = new c.b(w.a(paramj.b()), j2, null, paramj, v.b);
/*      */ 
/*      */     
/*      */     }
/*  822 */     else if (bool) {
/*      */       com.a.a.c.f.h h1;
/*      */       
/*      */       j j3;
/*      */       
/*  827 */       if ((j3 = (h1 = (com.a.a.c.f.h)paramj).c()).p()) {
/*      */         
/*  829 */         j1 = (j3 = a(paramg, paramj, j3)).t();
/*  830 */         j2 = j3.u();
/*  831 */         b1 = new c.b(w.a(paramj.b()), j3, null, paramj, v.b);
/*      */       } else {
/*  833 */         if (j3.a(m.class) || j3
/*  834 */           .a(r.class)) {
/*  835 */           j3 = a(paramg, paramj, j3);
/*      */           
/*  837 */           j2 = paramg.b(m.class);
/*  838 */           b1 = new c.b(w.a(paramj.b()), j3, null, paramj, v.b);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  843 */           return u.a(paramg, (c)b1, paramj, j2, paramg
/*      */               
/*  845 */               .b(j2));
/*      */         } 
/*  847 */         return (u)paramg.a(b1.a(), String.format("Unsupported type for any-setter: %s -- only support `Map`s, `JsonNode` and `ObjectNode` ", new Object[] {
/*      */                 
/*  849 */                 i.b(j3) }));
/*      */       } 
/*      */     } else {
/*  852 */       return (u)paramg.a(b1.a(), String.format("Unrecognized mutator type for any-setter: %s", new Object[] {
/*      */               
/*  854 */               i.g(paramj.getClass())
/*      */             }));
/*      */     } 
/*      */     
/*      */     p p;
/*  859 */     if ((p = b(paramg, (b)paramj)) == null) {
/*  860 */       p = (p)j1.A();
/*      */     }
/*  862 */     if (p == null) {
/*  863 */       p = paramg.b(j1, (c)b1);
/*      */     }
/*  865 */     else if (p instanceof l) {
/*      */       
/*  867 */       p = ((l)p).a();
/*      */     } 
/*      */     
/*      */     k<Object> k;
/*  871 */     if ((k = c(paramg, (b)paramj)) == null) {
/*  872 */       k = (k<Object>)j2.A();
/*      */     }
/*  874 */     if (k != null)
/*      */     {
/*  876 */       k = paramg.a(k, (c)b1, j2);
/*      */     }
/*  878 */     e e = (e)j2.B();
/*  879 */     if (bool) {
/*  880 */       return u.a(paramg, (c)b1, paramj, j2, p, k, e);
/*      */     }
/*      */     
/*  883 */     return u.a((c)b1, paramj, j2, p, k, e);
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
/*      */   private v a(g paramg, b paramb, s params, j paramj) {
/*      */     o o;
/*      */     i i;
/*      */     v v;
/*      */     j j1;
/*  904 */     if ((j1 = params.u()) == null) {
/*  905 */       paramg.a(paramb, params, "No non-constructor mutator available", new Object[0]);
/*      */     }
/*      */ 
/*      */     
/*  909 */     e e = (e)(paramj = a(paramg, j1, paramj)).B();
/*      */     
/*  911 */     if (j1 instanceof k) {
/*      */       
/*  913 */       o = new o(params, paramj, e, paramb.g(), (k)j1);
/*      */     }
/*      */     else {
/*      */       
/*  917 */       i = new i(params, paramj, e, o.g(), (com.a.a.c.f.h)j1);
/*      */     } 
/*      */     k<Object> k;
/*  920 */     if ((k = a(paramg, (b)j1)) == null) {
/*  921 */       k = (k<Object>)paramj.A();
/*      */     }
/*  923 */     if (k != null) {
/*  924 */       k = paramg.a(k, (c)i, paramj);
/*  925 */       v = i.a(k);
/*      */     } 
/*      */     
/*      */     a.a a;
/*  929 */     if ((a = params.x()) != null && a.b()) {
/*  930 */       v.b(a.a());
/*      */     }
/*      */     ad ad;
/*  933 */     if ((ad = params.A()) != null) {
/*  934 */       v.a(ad);
/*      */     }
/*  936 */     return v;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v a(g paramg, b paramb, s params) {
/*      */     v v;
/*  947 */     k k1 = params.n();
/*      */     j j;
/*  949 */     e e = (e)(j = a(paramg, (j)k1, k1.c())).B();
/*      */     
/*  951 */     aa aa = new aa(params, j, e, paramb.g(), k1);
/*      */     k<Object> k;
/*  953 */     if ((k = a(paramg, (b)k1)) == null) {
/*  954 */       k = (k<Object>)j.A();
/*      */     }
/*  956 */     if (k != null) {
/*  957 */       k = paramg.a(k, (c)aa, j);
/*  958 */       v = aa.a(k);
/*      */     } 
/*  960 */     return v;
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
/*      */   private static boolean b(Class<?> paramClass) {
/*      */     String str;
/*  980 */     if ((str = i.a(paramClass)) != null) {
/*  981 */       throw new IllegalArgumentException("Cannot deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
/*      */     }
/*  983 */     if (i.c(paramClass)) {
/*  984 */       throw new IllegalArgumentException("Cannot deserialize Proxy class " + paramClass.getName() + " as a Bean");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  989 */     if ((str = i.a(paramClass, true)) != null) {
/*  990 */       throw new IllegalArgumentException("Cannot deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
/*      */     }
/*  992 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(f paramf, Class<?> paramClass, Map<Class<?>, Boolean> paramMap) {
/*      */     Boolean bool;
/* 1003 */     if ((bool = paramMap.get(paramClass)) != null) {
/* 1004 */       return bool.booleanValue();
/*      */     }
/*      */     
/* 1007 */     if (paramClass == String.class || paramClass.isPrimitive()) {
/* 1008 */       bool = Boolean.FALSE;
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1013 */       b b1 = paramf.c(paramClass);
/*      */ 
/*      */       
/* 1016 */       if ((bool = paramf.d(paramClass).f()) == null && (bool = paramf.j().b(b1.d())) == null) {
/* 1017 */         bool = Boolean.FALSE;
/*      */       }
/*      */     } 
/*      */     
/* 1021 */     paramMap.put(paramClass, bool);
/* 1022 */     return bool.booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void g(g paramg, j paramj, b paramb) {
/* 1032 */     q.a().a(paramg, paramj, paramb);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */