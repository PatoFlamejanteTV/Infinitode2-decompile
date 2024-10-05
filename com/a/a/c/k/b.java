/*      */ package com.a.a.c.k;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.a.q;
/*      */ import com.a.a.a.s;
/*      */ import com.a.a.a.t;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.a.f;
/*      */ import com.a.a.c.aa;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.b.t;
/*      */ import com.a.a.c.f.d;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.f.w;
/*      */ import com.a.a.c.i.h;
/*      */ import com.a.a.c.i.i;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k.a.f;
/*      */ import com.a.a.c.k.a.h;
/*      */ import com.a.a.c.k.a.o;
/*      */ import com.a.a.c.k.a.p;
/*      */ import com.a.a.c.k.b.aa;
/*      */ import com.a.a.c.k.b.ac;
/*      */ import com.a.a.c.k.b.ag;
/*      */ import com.a.a.c.k.b.ai;
/*      */ import com.a.a.c.k.b.am;
/*      */ import com.a.a.c.k.b.ar;
/*      */ import com.a.a.c.k.b.as;
/*      */ import com.a.a.c.k.b.c;
/*      */ import com.a.a.c.k.b.f;
/*      */ import com.a.a.c.k.b.i;
/*      */ import com.a.a.c.k.b.l;
/*      */ import com.a.a.c.k.b.n;
/*      */ import com.a.a.c.k.b.t;
/*      */ import com.a.a.c.k.b.v;
/*      */ import com.a.a.c.k.b.y;
/*      */ import com.a.a.c.l.a;
/*      */ import com.a.a.c.l.d;
/*      */ import com.a.a.c.l.e;
/*      */ import com.a.a.c.l.g;
/*      */ import com.a.a.c.l.h;
/*      */ import com.a.a.c.l.j;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.c;
/*      */ import com.a.a.c.m.f;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.k;
/*      */ import com.a.a.c.o;
/*      */ import com.a.a.c.q;
/*      */ import com.a.a.c.y;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ 
/*      */ public abstract class b extends r implements Serializable {
/*      */   static {
/*   63 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     HashMap<Object, Object> hashMap2;
/*      */ 
/*      */ 
/*      */     
/*   72 */     (hashMap2 = new HashMap<>()).put(String.class.getName(), new ap());
/*   73 */     as as = as.a;
/*   74 */     hashMap2.put(StringBuffer.class.getName(), as);
/*   75 */     hashMap2.put(StringBuilder.class.getName(), as);
/*   76 */     hashMap2.put(Character.class.getName(), as);
/*   77 */     hashMap2.put(char.class.getName(), as);
/*      */ 
/*      */     
/*   80 */     aa.a(hashMap2);
/*   81 */     hashMap2.put(boolean.class.getName(), new f(true));
/*   82 */     hashMap2.put(Boolean.class.getName(), new f(false));
/*      */ 
/*      */     
/*   85 */     hashMap2.put(BigInteger.class.getName(), new y(BigInteger.class));
/*   86 */     hashMap2.put(BigDecimal.class.getName(), new y(BigDecimal.class));
/*      */ 
/*      */ 
/*      */     
/*   90 */     hashMap2.put(Calendar.class.getName(), i.a);
/*   91 */     hashMap2.put(Date.class.getName(), l.a);
/*      */ 
/*      */     
/*   94 */     for (Iterator<Map.Entry> iterator = ak.a().iterator(); iterator.hasNext(); ) {
/*      */       Map.Entry<?, Object> entry; o o;
/*   96 */       if (o = (o)(entry = iterator.next()).getValue() instanceof o) {
/*   97 */         hashMap2.put(((Class)entry.getKey()).getName(), o);
/*      */         continue;
/*      */       } 
/*  100 */       Class clazz = (Class)o;
/*  101 */       hashMap1.put(((Class)entry.getKey()).getName(), clazz);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  107 */     hashMap1.put(ac.class.getName(), au.class);
/*      */     
/*  109 */     b = (HashMap)hashMap2;
/*  110 */     c = (HashMap)hashMap1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static HashMap<String, o<?>> b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static HashMap<String, Class<? extends o<?>>> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final t a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected b(t paramt) {
/*  137 */     this.a = (paramt == null) ? new t() : paramt;
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
/*      */   public final o<Object> a(aa paramaa, j paramj, o<Object> paramo) {
/*      */     o<Object> o1;
/*      */     y y;
/*  210 */     com.a.a.c.b b1 = (y = paramaa.c()).a(paramj);
/*  211 */     w.a a = null;
/*      */     
/*  213 */     if (this.a.a())
/*      */     {
/*  215 */       for (Iterator<w.a> iterator = this.a.d().iterator(); iterator.hasNext() && (
/*      */         
/*  217 */         o1 = (a = iterator.next()).m()) == null;);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  222 */     if (o1 == null)
/*      */     {
/*      */       
/*  225 */       if ((o1 = c(paramaa, (com.a.a.c.f.b)b1.d())) == null)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  230 */         if ((o1 = paramo) == null)
/*      */         {
/*      */ 
/*      */           
/*  234 */           if ((o1 = am.a(paramj.b(), false)) == null) {
/*      */             j j1;
/*  236 */             if ((j1 = b1.p()) == null)
/*      */             {
/*  238 */               j1 = b1.q();
/*      */             }
/*  240 */             if (j1 != null) {
/*  241 */               o1 = a(paramaa, j1.c(), paramo);
/*  242 */               if (y.g()) {
/*  243 */                 i.a(j1.i(), y
/*  244 */                     .a(q.o));
/*      */               }
/*      */               
/*  247 */               t t1 = new t(j1, null, o1);
/*      */             } else {
/*  249 */               o1 = am.a(y, paramj.b());
/*      */             } 
/*      */           } 
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*  257 */     if (this.a.b()) {
/*  258 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/*  259 */         o1 = (o)i.h(o1); }
/*      */     
/*      */     }
/*  262 */     return o1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final o<Object> a(y paramy, j paramj, o<Object> paramo) {
/*  271 */     paramy.a(paramj);
/*  272 */     w.a a = null;
/*  273 */     if (this.a.a()) {
/*  274 */       for (Iterator<w.a> iterator = this.a.d().iterator(); iterator.hasNext() && (
/*      */         
/*  276 */         o1 = (a = iterator.next()).m()) == null;);
/*      */     }
/*      */     
/*      */     o<Object> o1;
/*      */     
/*  281 */     if (o1 == null && (
/*      */       
/*  283 */       o1 = paramo) == null && (
/*      */       
/*  285 */       o1 = am.a(paramj.b(), false)) == null) {
/*  286 */       o1 = am.a(paramy, paramj.b());
/*      */     }
/*      */ 
/*      */     
/*  290 */     if (this.a.b()) {
/*  291 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/*  292 */         o1 = (o)i.h(o1); }
/*      */     
/*      */     }
/*  295 */     return o1;
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
/*      */   public final i a(y paramy, j paramj) {
/*      */     com.a.a.c.b b1;
/*  308 */     d d = (b1 = paramy.c(paramj.b())).d();
/*      */     a a;
/*  310 */     h h = (a = paramy.j()).a((q)paramy, d, paramj);
/*      */ 
/*      */ 
/*      */     
/*  314 */     Collection collection = null;
/*  315 */     if (h == null) {
/*  316 */       h = paramy.n();
/*      */     } else {
/*  318 */       collection = paramy.w().a((q)paramy, d);
/*      */     } 
/*  320 */     if (h == null) {
/*  321 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  325 */     return h.a(paramy, paramj, collection);
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
/*      */   protected static o<?> a(j paramj) {
/*      */     Class<?> clazz1;
/*  351 */     String str = (clazz1 = paramj.b()).getName(); Class clazz;
/*      */     o<?> o;
/*  353 */     if ((o = b.get(str)) == null && (
/*      */       
/*  355 */       clazz = c.get(str)) != null)
/*      */     {
/*      */ 
/*      */       
/*  359 */       return (o)i.b(clazz, false);
/*      */     }
/*      */     
/*  362 */     return o;
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
/*      */   protected final o<?> a(aa paramaa, j paramj, com.a.a.c.b paramb) {
/*  385 */     Class<?> clazz = paramj.b();
/*      */     
/*  387 */     if (n.class.isAssignableFrom(clazz)) {
/*  388 */       return (o<?>)ag.a;
/*      */     }
/*      */     
/*      */     j j1;
/*  392 */     if ((j1 = paramb.q()) != null) {
/*  393 */       if (paramaa.f()) {
/*  394 */         i.a(j1.i(), paramaa
/*  395 */             .a(q.o));
/*      */       }
/*  397 */       j j2 = j1.c();
/*      */       o<Object> o;
/*  399 */       if ((o = a(paramaa, (com.a.a.c.f.b)j1)) == null) {
/*  400 */         o = (o<Object>)j2.A();
/*      */       }
/*      */       i i;
/*  403 */       if ((i = (i)j2.B()) == null) {
/*  404 */         i = a(paramaa.c(), j2);
/*      */       }
/*  406 */       return (o<?>)new t(j1, i, o);
/*      */     } 
/*      */     
/*  409 */     return null;
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
/*      */   protected final o<?> a(aa paramaa, j paramj, com.a.a.c.b paramb, boolean paramBoolean) {
/*      */     l.d d;
/*      */     j j1;
/*  424 */     if (paramj.h()) {
/*  425 */       return a(paramaa.c(), paramj, paramb);
/*      */     }
/*      */     
/*  428 */     Class<?> clazz = paramj.b();
/*      */     
/*      */     o<?> o;
/*  431 */     if ((o = b(paramaa, paramj, paramb)) != null) {
/*  432 */       return o;
/*      */     }
/*      */     
/*  435 */     if (Calendar.class.isAssignableFrom(clazz)) {
/*  436 */       return (o<?>)i.a;
/*      */     }
/*  438 */     if (Date.class.isAssignableFrom(clazz)) {
/*  439 */       return (o<?>)l.a;
/*      */     }
/*  441 */     if (Map.Entry.class.isAssignableFrom(clazz)) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  446 */       j1 = (paramj = paramj.d(Map.Entry.class)).b(0);
/*  447 */       paramj = paramj.b(1);
/*  448 */       return a(paramaa, paramb, paramBoolean, j1, paramj);
/*      */     } 
/*  450 */     if (ByteBuffer.class.isAssignableFrom((Class<?>)j1)) {
/*  451 */       return (o<?>)new h();
/*      */     }
/*  453 */     if (InetAddress.class.isAssignableFrom((Class<?>)j1)) {
/*  454 */       return (o<?>)new q();
/*      */     }
/*  456 */     if (InetSocketAddress.class.isAssignableFrom((Class<?>)j1)) {
/*  457 */       return (o<?>)new r();
/*      */     }
/*  459 */     if (TimeZone.class.isAssignableFrom((Class<?>)j1)) {
/*  460 */       return (o<?>)new aq();
/*      */     }
/*  462 */     if (Charset.class.isAssignableFrom((Class<?>)j1)) {
/*  463 */       return (o<?>)as.a;
/*      */     }
/*  465 */     if (Number.class.isAssignableFrom((Class<?>)j1)) {
/*      */       
/*  467 */       d = paramb.a(null);
/*  468 */       switch (c.a[d.c().ordinal()]) {
/*      */         case 1:
/*  470 */           return (o<?>)as.a;
/*      */         case 2:
/*      */         case 3:
/*  473 */           return null;
/*      */       } 
/*      */       
/*  476 */       return (o<?>)y.a;
/*      */     } 
/*      */     
/*  479 */     if (ClassLoader.class.isAssignableFrom((Class<?>)j1)) {
/*  480 */       return (o<?>)new ar((j)d);
/*      */     }
/*  482 */     return null;
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
/*      */   private static o<?> b(aa paramaa, j paramj, com.a.a.c.b paramb) {
/*  494 */     return g.a.a(paramaa.c(), paramj, paramb);
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
/*      */   protected final o<?> a(y paramy, j paramj, com.a.a.c.b paramb, boolean paramBoolean) {
/*      */     j j1;
/*  508 */     Class<?> clazz = paramj.b();
/*      */     
/*  510 */     if (Iterator.class.isAssignableFrom(clazz)) {
/*  511 */       paramy.p();
/*      */       j[] arrayOfJ;
/*  513 */       j1 = ((arrayOfJ = o.c(paramj, Iterator.class)) == null || arrayOfJ.length != 1) ? o.b() : arrayOfJ[0];
/*  514 */       return a(paramy, paramBoolean, j1);
/*      */     } 
/*  516 */     if (Iterable.class.isAssignableFrom(clazz)) {
/*  517 */       paramy.p();
/*      */       
/*  519 */       j arrayOfJ[], j2 = ((arrayOfJ = o.c(j1, Iterable.class)) == null || arrayOfJ.length != 1) ? o.b() : arrayOfJ[0];
/*  520 */       return b(paramy, paramBoolean, j2);
/*      */     } 
/*  522 */     if (CharSequence.class.isAssignableFrom(clazz)) {
/*  523 */       return (o<?>)as.a;
/*      */     }
/*  525 */     return null;
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
/*      */   protected final o<Object> a(aa paramaa, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*  541 */     if ((object = paramaa.d().n(paramb)) == null) {
/*  542 */       return null;
/*      */     }
/*  544 */     object = paramaa.b(paramb, object);
/*      */     
/*  546 */     return (o)a(paramaa, paramb, (o<?>)object);
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
/*      */   private o<?> a(aa paramaa, com.a.a.c.f.b paramb, o<?> paramo) {
/*      */     k<Object, Object> k;
/*  560 */     if ((k = b(paramaa, paramb)) == null) {
/*  561 */       return paramo;
/*      */     }
/*  563 */     paramaa.b(); j j = k.b();
/*  564 */     return (o<?>)new aj(k, j, paramo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static k<Object, Object> b(aa paramaa, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*  572 */     if ((object = paramaa.d().s(paramb)) == null) {
/*  573 */       return null;
/*      */     }
/*  575 */     return paramaa.a(paramb, object);
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
/*      */   protected final o<?> b(aa paramaa, j paramj, com.a.a.c.b paramb, boolean paramBoolean) {
/*      */     o<?> o;
/*      */     Iterator<w.a> iterator1, iterator2;
/*      */     w.a a;
/*  591 */     y y = paramaa.c();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  597 */     if (!paramBoolean && paramj.r() && (
/*  598 */       !paramj.n() || !paramj.u().q())) {
/*  599 */       paramBoolean = true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  604 */     j j1 = paramj.u();
/*      */ 
/*      */     
/*      */     i i;
/*      */     
/*  609 */     if ((i = a(y, j1)) != null) {
/*  610 */       paramBoolean = false;
/*      */     }
/*  612 */     o<Object> o1 = d(paramaa, (com.a.a.c.f.b)paramb
/*  613 */         .d());
/*  614 */     if (paramj.p()) {
/*  615 */       g g = (g)paramj;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  621 */       o<Object> o2 = c(paramaa, (com.a.a.c.f.b)paramb.d());
/*  622 */       if (g instanceof h) {
/*  623 */         return a(paramaa, (h)g, paramb, paramBoolean, o2, i, o1);
/*      */       }
/*      */ 
/*      */       
/*  627 */       w.a a1 = null;
/*      */       
/*  629 */       for (iterator2 = a().iterator(); iterator2.hasNext() && (
/*      */ 
/*      */         
/*  632 */         o = (a1 = iterator2.next()).s()) == null;);
/*      */ 
/*      */ 
/*      */       
/*  636 */       if (o == null) {
/*  637 */         o = a(paramaa, paramj, paramb);
/*      */       }
/*  639 */       if (o != null && 
/*  640 */         this.a.b()) {
/*  641 */         for (iterator2 = this.a.e().iterator(); iterator2.hasNext(); ) { iterator2.next();
/*  642 */           o = i.f(o); }
/*      */       
/*      */       }
/*      */       
/*  646 */       return o;
/*      */     } 
/*  648 */     if (paramj.o()) {
/*      */       d d;
/*  650 */       if (d = (d)paramj instanceof e) {
/*  651 */         return a(paramaa, (e)d, paramb, o, (i)iterator2, o1);
/*      */       }
/*      */ 
/*      */       
/*  655 */       o<?> o2 = null;
/*      */       
/*  657 */       for (iterator1 = a().iterator(); iterator1.hasNext() && (
/*      */ 
/*      */         
/*  660 */         o2 = (a = iterator1.next()).q()) == null;);
/*      */ 
/*      */ 
/*      */       
/*  664 */       if (o2 == null) {
/*  665 */         o2 = a(paramaa, paramj, paramb);
/*      */       }
/*  667 */       if (o2 != null && 
/*  668 */         this.a.b()) {
/*  669 */         for (iterator1 = this.a.e().iterator(); iterator1.hasNext(); ) { iterator1.next();
/*  670 */           o2 = i.d(o2); }
/*      */       
/*      */       }
/*      */       
/*  674 */       return o2;
/*      */     } 
/*  676 */     if (paramj.g()) {
/*  677 */       return a(paramaa, (a)paramj, paramb, iterator1, (i)a, o1);
/*      */     }
/*      */     
/*  680 */     return null;
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
/*      */   private o<?> a(aa paramaa, e parame, com.a.a.c.b paramb, boolean paramBoolean, i parami, o<Object> paramo) {
/*      */     j<?> j;
/*      */     o<?> o1;
/*  694 */     paramaa.c();
/*  695 */     o<?> o2 = null;
/*      */     
/*      */     Iterator<w.a> iterator;
/*      */     
/*      */     w.a a;
/*  700 */     for (iterator = a().iterator(); iterator.hasNext() && (
/*      */ 
/*      */       
/*  703 */       o2 = (a = iterator.next()).p()) == null;);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  708 */     if (o2 == null && (
/*      */       
/*  710 */       o2 = a(paramaa, (j)parame, paramb)) == null) {
/*      */       l.d d;
/*      */ 
/*      */       
/*  714 */       if ((d = paramb.a(null)).c() == l.c.e) {
/*  715 */         return null;
/*      */       }
/*  717 */       Class<?> clazz = parame.b();
/*  718 */       if (EnumSet.class.isAssignableFrom(clazz)) {
/*      */         j j1;
/*      */ 
/*      */         
/*  722 */         if (!(j1 = parame.u()).i()) {
/*  723 */           j1 = null;
/*      */         }
/*  725 */         o2 = b(j1);
/*      */       } else {
/*  727 */         p p; Class<String> clazz1 = parame.u().b();
/*  728 */         if (a(clazz)) {
/*  729 */           if (clazz1 == String.class) {
/*      */             
/*  731 */             if (i.e(paramo)) {
/*  732 */               f f = f.a;
/*      */             }
/*      */           } else {
/*  735 */             j = a(parame.u(), paramBoolean, parami, paramo);
/*      */           }
/*      */         
/*  738 */         } else if (clazz1 == String.class) {
/*      */           
/*  740 */           if (i.e(paramo)) {
/*  741 */             p = p.a;
/*      */           }
/*      */         } 
/*  744 */         if (p == null) {
/*  745 */           j = b(parame.u(), paramBoolean, parami, paramo);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  752 */     if (this.a.b()) {
/*  753 */       for (iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/*  754 */         o1 = i.c((o<?>)j); }
/*      */     
/*      */     }
/*  757 */     return o1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(Class<?> paramClass) {
/*  768 */     return RandomAccess.class.isAssignableFrom(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   private static j<?> a(j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  773 */     return (j<?>)new e(paramj, paramBoolean, parami, paramo);
/*      */   }
/*      */ 
/*      */   
/*      */   private static j<?> b(j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  778 */     return (j<?>)new k(paramj, paramBoolean, parami, paramo);
/*      */   }
/*      */   
/*      */   private static o<?> b(j paramj) {
/*  782 */     return (o<?>)new o(paramj);
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
/*      */   private o<?> a(aa paramaa, h paramh, com.a.a.c.b paramb, boolean paramBoolean, o<Object> paramo1, i parami, o<Object> paramo2) {
/*      */     v v;
/*      */     o<?> o1;
/*      */     l.d d;
/*  804 */     if ((d = paramb.a(null)).c() == l.c.e) {
/*  805 */       return null;
/*      */     }
/*      */     
/*  808 */     d = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  815 */     y y = paramaa.c(); o<?> o2; w.a a; Iterator<w.a> iterator;
/*  816 */     for (iterator = a().iterator(); iterator.hasNext() && (
/*      */ 
/*      */       
/*  819 */       o2 = (a = iterator.next()).r()) == null;);
/*      */     
/*  821 */     if (o2 == null && (
/*      */       
/*  823 */       o2 = a(paramaa, (j)paramh, paramb)) == null) {
/*  824 */       Object object = a(y, paramb);
/*      */ 
/*      */ 
/*      */       
/*      */       q.a a1;
/*      */ 
/*      */ 
/*      */       
/*  832 */       Set set1 = ((a1 = y.b(Map.class, paramb.d())) == null) ? null : a1.b();
/*  833 */       Map.class;
/*      */       
/*      */       t.a a2;
/*  836 */       Set set2 = ((a2 = y.a(paramb.d())) == null) ? null : a2.b();
/*  837 */       v v1 = v.a(set1, set2, (j)paramh, paramBoolean, parami, paramo1, paramo2, object);
/*      */ 
/*      */       
/*  840 */       v = a(paramaa, paramb, v1);
/*      */     } 
/*      */ 
/*      */     
/*  844 */     if (this.a.b()) {
/*  845 */       for (iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/*  846 */         o1 = i.e((o<?>)v); }
/*      */     
/*      */     }
/*  849 */     return o1;
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
/*      */   private v a(aa paramaa, com.a.a.c.b paramb, v paramv) {
/*  863 */     j j = paramv.d();
/*      */     
/*      */     s.b b1;
/*      */     
/*      */     s.a a;
/*      */     
/*  869 */     if ((a = ((b1 = a(paramaa, paramb, j, Map.class)) == null) ? s.a.g : b1.c()) == s.a.g || a == s.a.a) {
/*      */       
/*  871 */       if (!paramaa.a(z.p)) {
/*  872 */         return paramv.a(null, true);
/*      */       }
/*  874 */       return paramv;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  880 */     boolean bool = true;
/*      */     
/*  882 */     switch (c.b[a.ordinal()])
/*      */     
/*      */     { case 1:
/*  885 */         if ((object = f.a(j)) != null && 
/*  886 */           object.getClass().isArray()) {
/*  887 */           object = c.a(object);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  912 */         return paramv.a(object, bool);case 2: object = j.F() ? v.a : null; return paramv.a(object, bool);case 3: object = v.a; return paramv.a(object, bool);case 4: if ((object = paramaa.a(null, object.e())) == null) { bool = true; } else { bool = paramaa.b(object); }  return paramv.a(object, bool); }  Object object = null; return paramv.a(object, bool);
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
/*      */   private o<?> a(aa paramaa, com.a.a.c.b paramb, boolean paramBoolean, j paramj1, j paramj2) {
/*  925 */     l.d d1 = paramaa.a(Map.Entry.class);
/*      */     
/*      */     l.d d2;
/*  928 */     if ((d1 = l.d.a(d2 = paramb.a(null), d1)).c() == l.c.e) {
/*  929 */       return null;
/*      */     }
/*      */     
/*      */     h h;
/*      */     
/*  934 */     paramj1 = (h = new h(paramj2, paramj1, paramj2, paramBoolean, a(paramaa.c(), paramj2), null)).d();
/*      */     
/*      */     s.b b1;
/*      */     
/*      */     s.a a;
/*      */     
/*  940 */     if ((a = ((b1 = a(paramaa, paramb, paramj1, Map.Entry.class)) == null) ? s.a.g : b1.c()) == s.a.g || a == s.a.a)
/*      */     {
/*  942 */       return (o<?>)h;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  948 */     boolean bool = true;
/*      */     
/*  950 */     switch (c.b[a.ordinal()])
/*      */     
/*      */     { case 1:
/*  953 */         if ((object = f.a(paramj1)) != null && 
/*  954 */           object.getClass().isArray()) {
/*  955 */           object = c.a(object);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  979 */         return (o<?>)h.a(object, bool);case 2: object = paramj1.F() ? v.a : null; return (o<?>)h.a(object, bool);case 3: object = v.a; return (o<?>)h.a(object, bool);case 4: if ((object = paramaa.a(null, object.e())) == null) { bool = true; } else { bool = paramaa.b(object); }  return (o<?>)h.a(object, bool); }  Object object = null; return (o<?>)h.a(object, bool);
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
/*      */   private static s.b a(aa paramaa, com.a.a.c.b paramb, j paramj, Class<?> paramClass) {
/*  995 */     y y = paramaa.c();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1002 */     s.b b2 = paramb.a(y.A());
/* 1003 */     b2 = y.a(paramClass, b2);
/*      */ 
/*      */     
/*      */     s.b b1;
/*      */ 
/*      */     
/* 1009 */     if ((b1 = y.a(paramj.b(), null)) != null) {
/* 1010 */       switch (c.b[b1.b().ordinal()]) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 6:
/* 1020 */           return b2;
/*      */         case 4:
/*      */           b2 = b2.a(b1.e());
/*      */       } 
/*      */       b2 = b2.b(b1.b());
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
/*      */   private o<?> a(aa paramaa, a parama, com.a.a.c.b paramb, boolean paramBoolean, i parami, o<Object> paramo) {
/*      */     ac ac;
/*      */     o<?> o1;
/* 1043 */     paramaa.c();
/* 1044 */     paramaa = null; w.a a1; o o2;
/*      */     Iterator<w.a> iterator;
/* 1046 */     for (iterator = a().iterator(); iterator.hasNext() && (
/*      */ 
/*      */       
/* 1049 */       o2 = (a1 = iterator.next()).o()) == null;);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1054 */     if (o2 == null) {
/* 1055 */       Class<String[]> clazz = parama.b();
/*      */       
/* 1057 */       if (paramo == null || i.e(paramo)) {
/* 1058 */         if (String[].class == clazz) {
/* 1059 */           o o3 = o.a;
/*      */         } else {
/*      */           
/* 1062 */           o2 = ai.a(clazz);
/*      */         } 
/*      */       }
/* 1065 */       if (o2 == null) {
/* 1066 */         ac = new ac(parama.u(), paramBoolean, parami, paramo);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1071 */     if (this.a.b()) {
/* 1072 */       for (iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1073 */         o1 = i.b((o<?>)ac); }
/*      */     
/*      */     }
/* 1076 */     return o1;
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
/*      */   public final o<?> a(aa paramaa, j paramj, com.a.a.c.b paramb, boolean paramBoolean) {
/*      */     j j1;
/* 1094 */     i i = (i)(j1 = paramj.u()).B();
/* 1095 */     y y = paramaa.c();
/* 1096 */     if (i == null) {
/* 1097 */       i = a(y, j1);
/*      */     }
/* 1099 */     o<Object> o = (o)j1.A();
/* 1100 */     for (Iterator<w.a> iterator = a().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 1103 */       if ((o1 = (a = iterator.next()).n()) != null) {
/* 1104 */         return o1;
/*      */       }
/*      */     } 
/* 1107 */     if (paramj.b(AtomicReference.class)) {
/* 1108 */       return a(paramaa, paramj, paramb, paramBoolean, i, o);
/*      */     }
/*      */     
/* 1111 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<?> a(aa paramaa, j paramj, com.a.a.c.b paramb, boolean paramBoolean, i parami, o<Object> paramo) {
/*      */     boolean bool;
/* 1119 */     j j1 = paramj.v();
/*      */ 
/*      */     
/*      */     Object object;
/*      */ 
/*      */     
/*      */     s.a a;
/*      */ 
/*      */     
/* 1128 */     if ((a = ((object = a(paramaa, paramb, j1, AtomicReference.class)) == null) ? s.a.g : object.c()) == s.a.g || a == s.a.a)
/*      */     
/* 1130 */     { object = null;
/* 1131 */       bool = false; }
/*      */     else
/* 1133 */     { c c1; bool = true;
/* 1134 */       switch (c.b[a.ordinal()])
/*      */       
/*      */       { case 1:
/* 1137 */           if ((object = f.a(j1)) != null && 
/* 1138 */             object.getClass().isArray()) {
/* 1139 */             object = c.a(object);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1166 */           return (o<?>)(c1 = new c(paramj, paramBoolean, parami, paramo)).a(object, bool);case 2: object = j1.F() ? v.a : null; return (o<?>)(c1 = new c(paramj, paramBoolean, parami, paramo)).a(object, bool);case 3: object = v.a; return (o<?>)(c1 = new c(paramj, paramBoolean, parami, paramo)).a(object, bool);case 4: if ((object = c1.a(null, object.e())) == null) { bool = true; } else { bool = c1.b(object); }  return (o<?>)(c1 = new c(paramj, paramBoolean, parami, paramo)).a(object, bool); }  object = null; }  c c; return (o<?>)(c = new c(paramj, paramBoolean, parami, paramo)).a(object, bool);
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
/*      */   private o<?> a(y paramy, boolean paramBoolean, j paramj) {
/* 1183 */     return (o<?>)new g(paramj, paramBoolean, a(paramy, paramj));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<?> b(y paramy, boolean paramBoolean, j paramj) {
/* 1194 */     return (o<?>)new s(paramj, paramBoolean, a(paramy, paramj));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<?> a(y paramy, j paramj, com.a.a.c.b paramb) {
/*      */     o<?> o;
/*      */     l.d d;
/* 1207 */     if ((d = paramb.a(null)).c() == l.c.e) {
/*      */       
/* 1209 */       ((q)paramb).a("declaringClass");
/*      */       
/* 1211 */       return null;
/*      */     } 
/*      */     
/*      */     Class clazz;
/* 1215 */     n n = n.a(clazz = paramj.b(), paramy, d);
/*      */     
/* 1217 */     if (this.a.b()) {
/* 1218 */       for (Iterator iterator = this.a.e().iterator(); iterator.hasNext(); ) { iterator.next();
/* 1219 */         o = i.g((o<?>)n); }
/*      */     
/*      */     }
/* 1222 */     return o;
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
/*      */   private static o<Object> c(aa paramaa, com.a.a.c.f.b paramb) {
/*      */     a a;
/*      */     Object object;
/* 1242 */     if ((object = (a = paramaa.d()).o(paramb)) != null) {
/* 1243 */       return paramaa.b(paramb, object);
/*      */     }
/* 1245 */     return null;
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
/*      */   private static o<Object> d(aa paramaa, com.a.a.c.f.b paramb) {
/*      */     Object object;
/*      */     a a;
/* 1259 */     if ((object = (a = paramaa.d()).p(paramb)) != null) {
/* 1260 */       return paramaa.b(paramb, object);
/*      */     }
/* 1262 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Object a(y paramy, com.a.a.c.b paramb) {
/* 1270 */     return paramy.j().d((com.a.a.c.f.b)paramb.d());
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
/*      */   protected static boolean a(y paramy, com.a.a.c.b paramb, i parami) {
/* 1287 */     if (parami != null) {
/* 1288 */       return false;
/*      */     }
/*      */     f.b b1;
/*      */     a a;
/* 1292 */     if ((b1 = (a = paramy.j()).r((com.a.a.c.f.b)paramb.d())) != null && b1 != f.b.c) {
/* 1293 */       return (b1 == f.b.b);
/*      */     }
/* 1295 */     return paramy.a(q.p);
/*      */   }
/*      */   
/*      */   protected abstract Iterable<w.a> a();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */