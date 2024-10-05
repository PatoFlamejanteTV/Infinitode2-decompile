/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.am;
/*     */ import com.a.a.a.q;
/*     */ import com.a.a.a.t;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.v;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.b.t;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.d;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.d;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.f.w;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.k.a.j;
/*     */ import com.a.a.c.k.a.m;
/*     */ import com.a.a.c.k.a.s;
/*     */ import com.a.a.c.k.b.aj;
/*     */ import com.a.a.c.k.b.ar;
/*     */ import com.a.a.c.k.b.v;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.f;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.m.w;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.s;
/*     */ import com.a.a.c.t;
/*     */ import com.a.a.c.u;
/*     */ import com.a.a.c.v;
/*     */ import com.a.a.c.w;
/*     */ import com.a.a.c.y;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public final class h
/*     */   extends b
/*     */   implements Serializable
/*     */ {
/*  73 */   public static final h b = new h(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h(t paramt) {
/*  86 */     super(paramt);
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
/*     */   protected final Iterable<w.a> a() {
/* 117 */     return this.a.c();
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
/*     */   public final o<Object> a(aa paramaa, j paramj) {
/*     */     boolean bool;
/*     */     j j2;
/*     */     y y;
/* 144 */     b b1 = (y = paramaa.c()).a(paramj);
/*     */     o<Object> o;
/* 146 */     if ((o = a(paramaa, (b)b1.d())) != null) {
/* 147 */       return o;
/*     */     }
/*     */ 
/*     */     
/*     */     a a;
/*     */ 
/*     */     
/* 154 */     if ((a = y.j()) == null) {
/* 155 */       j2 = paramj;
/*     */     } else {
/*     */       try {
/* 158 */         j2 = a.a((q)y, (b)b1.d(), paramj);
/* 159 */       } catch (l l) {
/* 160 */         return (o<Object>)paramaa.a(b1, l.getMessage(), new Object[0]);
/*     */       } 
/*     */     } 
/* 163 */     if (j2 == l) {
/* 164 */       bool = false;
/*     */     } else {
/* 166 */       bool = true;
/* 167 */       if (!j2.a(l.b())) {
/* 168 */         b1 = y.a(j2);
/*     */       }
/*     */     } 
/*     */     
/*     */     k k;
/* 173 */     if ((k = b1.t()) == null) {
/* 174 */       return (o)c(paramaa, j2, b1, bool);
/*     */     }
/* 176 */     paramaa.b();
/*     */     
/*     */     j j1;
/* 179 */     if (!(j1 = k.b()).a(j2.b())) {
/* 180 */       b1 = y.a(j1);
/*     */       
/* 182 */       o = a(paramaa, (b)b1.d());
/*     */     } 
/*     */     
/* 185 */     if (o == null && !j1.q()) {
/* 186 */       o = (o)c(paramaa, j1, b1, true);
/*     */     }
/* 188 */     return (o<Object>)new aj(k, j1, o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o<?> c(aa paramaa, j paramj, b paramb, boolean paramBoolean) {
/* 195 */     o<?> o = null;
/* 196 */     y y = paramaa.c();
/*     */ 
/*     */ 
/*     */     
/* 200 */     if (paramj.n()) {
/* 201 */       if (!paramBoolean) {
/* 202 */         paramBoolean = a(y, paramb, (i)null);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 207 */       if ((o = b(paramaa, paramj, paramb, paramBoolean)) != null) {
/* 208 */         return o;
/*     */       }
/*     */     } else {
/* 211 */       if (paramj.F()) {
/* 212 */         o = a(paramaa, (j)paramj, paramb, paramBoolean);
/*     */       } else {
/*     */         w.a a;
/* 215 */         for (Iterator<w.a> iterator = a().iterator(); iterator.hasNext() && (
/*     */           
/* 217 */           o = (a = iterator.next()).m()) == null;);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 224 */       if (o == null) {
/* 225 */         o = a(paramaa, paramj, paramb);
/*     */       }
/*     */     } 
/*     */     
/* 229 */     if (o == null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 234 */       if ((o = a(paramj)) == null && (
/*     */         
/* 236 */         o = a(paramaa, paramj, paramb, paramBoolean)) == null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 244 */         if ((o = d(paramaa, paramj, paramb, paramBoolean)) == null) {
/* 245 */           o = paramaa.d(paramb.b());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 250 */     if (o != null)
/*     */     {
/* 252 */       if (this.a.b()) {
/* 253 */         for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 254 */           o = i.a(o); }
/*     */       
/*     */       }
/*     */     }
/* 258 */     return o;
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
/*     */   private o<Object> d(aa paramaa, j paramj, b paramb, boolean paramBoolean) {
/* 288 */     if (!a(paramj.b()))
/*     */     {
/*     */       
/* 291 */       if (!i.k(paramj.b())) {
/* 292 */         return null;
/*     */       }
/*     */     }
/* 295 */     return e(paramaa, paramj, paramb, paramBoolean);
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
/*     */   private i a(j paramj, y paramy, j paramj1) {
/*     */     i i;
/*     */     a a;
/*     */     com.a.a.c.i.h h1;
/* 317 */     if ((h1 = (a = paramy.j()).a((q)paramy, paramj1, paramj)) == null) {
/* 318 */       i = a(paramy, paramj);
/*     */     } else {
/* 320 */       Collection collection = paramy.w().a((q)paramy, paramj1, (j)i);
/*     */       
/* 322 */       i = h1.a(paramy, (j)i, collection);
/*     */     } 
/* 324 */     return i;
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
/*     */   private i b(j paramj, y paramy, j paramj1) {
/*     */     i i;
/* 341 */     j j1 = paramj.u();
/*     */     
/*     */     com.a.a.c.i.h h1;
/*     */     
/*     */     a a;
/*     */     
/* 347 */     if ((h1 = (a = paramy.j()).b((q)paramy, paramj1, paramj)) == null) {
/* 348 */       i = a(paramy, j1);
/*     */     } else {
/* 350 */       Collection collection = paramy.w().a((q)paramy, paramj1, j1);
/*     */       
/* 352 */       i = i.a(paramy, j1, collection);
/*     */     } 
/* 354 */     return i;
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
/*     */   private o<Object> e(aa paramaa, j paramj, b paramb, boolean paramBoolean) {
/*     */     o<?> o1;
/* 384 */     if (paramb.b() == Object.class) {
/* 385 */       return paramaa.d(Object.class);
/*     */     }
/*     */     
/*     */     o<?> o2;
/* 389 */     if ((o2 = b(paramaa, paramj)) != null) {
/* 390 */       return (o)o2;
/*     */     }
/*     */ 
/*     */     
/* 394 */     if (b(paramj)) {
/* 395 */       return (o<Object>)new ar(paramj);
/*     */     }
/* 397 */     y y = paramaa.c();
/*     */     g g;
/* 399 */     (g = a(paramb)).a(y);
/*     */     
/*     */     List<e> list;
/*     */     
/* 403 */     if ((list = a(paramaa, paramb, g)) == null) {
/* 404 */       list = new ArrayList<>();
/*     */     } else {
/* 406 */       list = b(list);
/*     */     } 
/*     */ 
/*     */     
/* 410 */     paramaa.d().a((q)y, paramb.d(), list);
/*     */ 
/*     */     
/* 413 */     if (this.a.b()) {
/* 414 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 415 */         list = i.a(list); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     list = a(paramb, list);
/* 424 */     list = a(y, paramb, list);
/*     */ 
/*     */     
/* 427 */     if (this.a.b()) {
/* 428 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 429 */         list = i.b(list); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     g.a(a(paramaa, paramb, list));
/*     */     
/* 438 */     g.a(list);
/* 439 */     g.a(a(y, paramb));
/*     */     
/*     */     j j1;
/* 442 */     if ((j1 = paramb.r()) != null) {
/*     */       v v;
/*     */       
/* 445 */       j j2, j3 = (j2 = j1.c()).u();
/* 446 */       i i = a(y, j3);
/*     */       
/*     */       o<Object> o;
/*     */       
/* 450 */       if ((o = a(paramaa, (b)j1)) == null)
/*     */       {
/* 452 */         v = v.a((Set)null, j2, y
/* 453 */             .a(q.p), i, null, null, null);
/*     */       }
/*     */ 
/*     */       
/* 457 */       w w = w.a(j1.b());
/* 458 */       c.b b1 = new c.b(w, j3, null, j1, v.b);
/*     */       
/* 460 */       g.a(new a((c)b1, j1, (o<?>)v));
/*     */     } 
/*     */     
/* 463 */     a(y, g);
/*     */ 
/*     */     
/* 466 */     if (this.a.b()) {
/* 467 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 468 */         g = i.a(g); }
/*     */     
/*     */     }
/*     */     
/*     */     try {
/* 473 */       o1 = g.g();
/* 474 */     } catch (RuntimeException runtimeException) {
/* 475 */       return (o<Object>)paramaa.a(paramb, "Failed to construct BeanSerializer for %s: (%s) %s", new Object[] { paramb
/* 476 */             .a(), runtimeException.getClass().getName(), runtimeException.getMessage() });
/*     */     } 
/* 478 */     if (runtimeException == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 483 */       if (paramj.j() && !w.a(paramj.b())) {
/* 484 */         return (o<Object>)g.h();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 490 */       if ((o1 = a(y, paramj, paramb, paramBoolean)) == null)
/*     */       {
/*     */ 
/*     */         
/* 494 */         if (paramb.f()) {
/* 495 */           return (o<Object>)g.h();
/*     */         }
/*     */       }
/*     */     } 
/* 499 */     return (o)o1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static m a(aa paramaa, b paramb, List<e> paramList) {
/*     */     j j;
/*     */     e e;
/*     */     ad ad;
/* 507 */     if ((ad = paramb.e()) == null) {
/* 508 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     Class<am.c> clazz;
/*     */     
/* 514 */     if ((clazz = ad.d()) == am.c.class) {
/* 515 */       String str = ad.b().b();
/*     */ 
/*     */       
/* 518 */       for (int k = 0, i = paramList.size();; k++) {
/* 519 */         if (k == i)
/* 520 */           throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[] {
/*     */                   
/* 522 */                   i.b(paramb.a()), i.b(str)
/*     */                 })); 
/* 524 */         e e1 = paramList.get(k);
/* 525 */         if (str.equals(e1.a())) {
/* 526 */           e = e1;
/*     */ 
/*     */           
/* 529 */           if (k > 0) {
/* 530 */             paramList.remove(k);
/* 531 */             paramList.add(0, e);
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/* 536 */       j j2 = e.c();
/* 537 */       j = new j(ad, e);
/*     */       
/* 539 */       return m.a(j2, (w)null, (al)j, ad.f());
/*     */     } 
/*     */ 
/*     */     
/* 543 */     j j1 = j.a((Type)e);
/*     */     
/* 545 */     j.b(); j1 = o.c(j1, al.class)[0];
/* 546 */     al al = j.a((b)paramb.d(), ad);
/* 547 */     return m.a(j1, ad.b(), al, ad
/* 548 */         .f());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static e a(e parame, Class<?>[] paramArrayOfClass) {
/* 559 */     return d.a(parame, paramArrayOfClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static m b(y paramy, b paramb) {
/* 565 */     return new m(paramy, paramb);
/*     */   }
/*     */   
/*     */   private static g a(b paramb) {
/* 569 */     return new g(paramb);
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
/*     */   private static boolean a(Class<?> paramClass) {
/* 588 */     return (i.a(paramClass) == null && !i.c(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<e> a(aa paramaa, b paramb, g paramg) {
/* 599 */     List<s> list = paramb.h();
/*     */     
/*     */     y y;
/*     */     
/* 603 */     a(y = paramaa.c(), list);
/*     */ 
/*     */     
/* 606 */     if (y.a(q.i)) {
/* 607 */       a(list);
/*     */     }
/*     */ 
/*     */     
/* 611 */     if (list.isEmpty()) {
/* 612 */       return null;
/*     */     }
/*     */     
/* 615 */     boolean bool = a(y, paramb, (i)null);
/* 616 */     m m = b(y, paramb);
/*     */     
/* 618 */     ArrayList<e> arrayList = new ArrayList(list.size());
/* 619 */     for (Iterator<s> iterator = list.iterator(); iterator.hasNext(); ) {
/* 620 */       s s; j j = (s = iterator.next()).s();
/*     */       
/* 622 */       if (s.z()) {
/* 623 */         if (j != null) {
/* 624 */           paramg.a(j);
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/*     */       a.a a;
/* 630 */       if ((a = s.x()) == null || !a.c()) {
/*     */ 
/*     */         
/* 633 */         if (j instanceof com.a.a.c.f.k) {
/* 634 */           arrayList.add(a(paramaa, s, m, bool, j)); continue;
/*     */         } 
/* 636 */         arrayList.add(a(paramaa, s, m, bool, j));
/*     */       } 
/*     */     } 
/* 639 */     return arrayList;
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
/*     */   private static List<e> a(y paramy, b paramb, List<e> paramList) {
/*     */     Set set1;
/* 659 */     q.a a1 = paramy.b(paramb.b(), paramb
/* 660 */         .d());
/* 661 */     Set set2 = null;
/* 662 */     if (a1 != null) {
/* 663 */       set2 = a1.b();
/*     */     }
/* 665 */     paramb.b(); t.a a = paramy.a(paramb
/* 666 */         .d());
/* 667 */     paramb = null;
/* 668 */     if (a != null) {
/* 669 */       set1 = a.b();
/*     */     }
/* 671 */     if (set1 != null || (set2 != null && !set2.isEmpty())) {
/* 672 */       Iterator<e> iterator = paramList.iterator();
/* 673 */       while (iterator.hasNext()) {
/* 674 */         if (n.a(((e)iterator.next()).a(), set2, set1)) {
/* 675 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 680 */     return paramList;
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
/*     */   private static List<e> a(b paramb, List<e> paramList) {
/* 696 */     if (paramb.a().b(CharSequence.class)) {
/*     */       e e; j j;
/* 698 */       if (paramList.size() == 1 && 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 704 */         j = (e = paramList.get(0)).e() instanceof com.a.a.c.f.k && "isEmpty"
/* 705 */         .equals(j.b()) && j
/* 706 */         .h() == CharSequence.class) {
/* 707 */         paramList.remove(0);
/*     */       }
/*     */     } 
/*     */     
/* 711 */     return paramList;
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
/*     */   private void a(y paramy, g paramg) {
/* 726 */     List<e> list = paramg.b();
/* 727 */     boolean bool = paramy.a(q.s);
/* 728 */     int i = list.size();
/* 729 */     byte b1 = 0;
/* 730 */     e[] arrayOfE = new e[i];
/*     */     
/* 732 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       e e;
/*     */       Class[] arrayOfClass;
/* 735 */       if ((arrayOfClass = (e = list.get(b2)).k()) == null || arrayOfClass.length == 0) {
/*     */ 
/*     */         
/* 738 */         if (bool) {
/* 739 */           arrayOfE[b2] = e;
/*     */         }
/*     */       } else {
/* 742 */         b1++;
/* 743 */         arrayOfE[b2] = a(e, arrayOfClass);
/*     */       } 
/*     */     } 
/*     */     
/* 747 */     if (bool && b1 == 0) {
/*     */       return;
/*     */     }
/* 750 */     paramg.a(arrayOfE);
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
/*     */   private static void a(y paramy, List<s> paramList) {
/* 762 */     a a = paramy.j();
/* 763 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 764 */     Iterator<s> iterator = paramList.iterator();
/* 765 */     while (iterator.hasNext()) {
/*     */       s s;
/*     */ 
/*     */       
/*     */       j j;
/*     */ 
/*     */       
/* 772 */       if ((j = (s = iterator.next()).s()) == null) {
/* 773 */         iterator.remove();
/*     */         continue;
/*     */       } 
/* 776 */       Class clazz = s.g();
/*     */       Boolean bool;
/* 778 */       if ((bool = (Boolean)hashMap.get(clazz)) == null) {
/*     */         b b1;
/*     */ 
/*     */ 
/*     */         
/* 783 */         d d = (b1 = paramy.c(clazz)).d();
/*     */ 
/*     */         
/* 786 */         if ((bool = paramy.d(clazz).f()) == null && (bool = a.b(d)) == null) {
/* 787 */           bool = Boolean.FALSE;
/*     */         }
/*     */         
/* 790 */         hashMap.put(clazz, bool);
/*     */       } 
/*     */       
/* 793 */       if (bool.booleanValue()) {
/* 794 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(List<s> paramList) {
/* 805 */     Iterator<s> iterator = paramList.iterator();
/* 806 */     while (iterator.hasNext()) {
/*     */       s s;
/*     */ 
/*     */       
/* 810 */       if (!(s = iterator.next()).i() && !s.d()) {
/* 811 */         iterator.remove();
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
/*     */   private static List<e> b(List<e> paramList) {
/*     */     byte b1;
/*     */     int i;
/* 826 */     for (b1 = 0, i = paramList.size(); b1 < i; b1++) {
/*     */       e e;
/*     */       i i1;
/* 829 */       if ((i1 = (e = paramList.get(b1)).h()) != null && i1.a() == af.a.d) {
/*     */         String str;
/*     */ 
/*     */         
/* 833 */         w w = w.a(str = i1.b());
/*     */         
/* 835 */         for (Iterator<e> iterator = paramList.iterator(); iterator.hasNext();) {
/* 836 */           if ((e1 = iterator.next()) != e && e1.a(w)) {
/* 837 */             e.a((i)null); break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 842 */     return paramList;
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
/*     */   private e a(aa paramaa, s params, m paramm, boolean paramBoolean, j paramj) {
/*     */     i i1;
/* 860 */     w w = params.b();
/* 861 */     j j1 = paramj.c();
/*     */     
/* 863 */     c.b b1 = new c.b(w, j1, params.c(), paramj, params.h());
/*     */ 
/*     */ 
/*     */     
/*     */     o<Object> o;
/*     */ 
/*     */     
/* 870 */     if (o = a(paramaa, (b)paramj) instanceof q) {
/* 871 */       ((q)o).a(paramaa);
/*     */     }
/*     */     
/* 874 */     o = paramaa.a(o, (c)b1);
/*     */     
/* 876 */     b1 = null;
/*     */     
/* 878 */     if (j1.n() || j1.F()) {
/* 879 */       i1 = b(j1, paramaa.c(), paramj);
/*     */     }
/*     */     
/* 882 */     i i2 = a(j1, paramaa.c(), paramj);
/* 883 */     return paramm.a(paramaa, params, j1, o, i2, i1, paramj, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static o<?> b(aa paramaa, j paramj) {
/*     */     String str;
/* 894 */     if ((str = f.b(paramj)) != null)
/*     */     {
/*     */       
/* 897 */       if (paramaa.c().i(paramj.b()) == null) {
/* 898 */         return (o<?>)new s(paramj, str);
/*     */       }
/*     */     }
/* 901 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean b(j paramj) {
/* 912 */     Class<?> clazz = paramj.b();
/* 913 */     if (s.class.isAssignableFrom(clazz) || t.class
/* 914 */       .isAssignableFrom(clazz) || u.class
/* 915 */       .isAssignableFrom(clazz) || d.class
/* 916 */       .isAssignableFrom(clazz) || v.class
/* 917 */       .isAssignableFrom(clazz) || l.class
/* 918 */       .isAssignableFrom(clazz) || com.a.a.b.h.class
/* 919 */       .isAssignableFrom(clazz)) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */