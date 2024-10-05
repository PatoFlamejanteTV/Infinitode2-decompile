/*      */ package com.a.a.c.f;
/*      */ import com.a.a.a.ac;
/*      */ import com.a.a.a.ad;
/*      */ import com.a.a.a.af;
/*      */ import com.a.a.a.ah;
/*      */ import com.a.a.a.ai;
/*      */ import com.a.a.a.b;
/*      */ import com.a.a.a.c;
/*      */ import com.a.a.a.i;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.a.n;
/*      */ import com.a.a.a.q;
/*      */ import com.a.a.a.s;
/*      */ import com.a.a.a.t;
/*      */ import com.a.a.a.z;
/*      */ import com.a.a.c.a.b;
/*      */ import com.a.a.c.a.c;
/*      */ import com.a.a.c.a.f;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.i.b;
/*      */ import com.a.a.c.i.h;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.k.e;
/*      */ import com.a.a.c.l.g;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.o;
/*      */ import com.a.a.c.v;
/*      */ import com.a.a.c.w;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Field;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ 
/*      */ public final class x extends a implements Serializable {
/*   37 */   private static final Class<? extends Annotation>[] a = new Class[] { f.class, aj.class, l.class, af.class, aa.class, ah.class, h.class, v.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   50 */   private static final Class<? extends Annotation>[] b = new Class[] { c.class, aj.class, l.class, af.class, ah.class, h.class, v.class, w.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final c c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*   66 */     c c1 = null;
/*      */     try {
/*   68 */       c1 = c.a();
/*   69 */     } catch (Throwable throwable) {}
/*   70 */     c = c1;
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
/*   82 */   private transient o<Class<?>, Boolean> d = new o(48, 48);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean e = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(Annotation paramAnnotation) {
/*  158 */     Class<? extends Annotation> clazz = paramAnnotation.annotationType();
/*      */     Boolean bool;
/*  160 */     if ((bool = (Boolean)this.d.a(clazz)) == null) {
/*  161 */       bool = Boolean.valueOf((clazz.getAnnotation(a.class) != null));
/*  162 */       this.d.b(clazz, bool);
/*      */     } 
/*  164 */     return bool.booleanValue();
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
/*      */   public final String[] a(Class<?> paramClass, Enum<?>[] paramArrayOfEnum, String[] paramArrayOfString) {
/*  206 */     HashMap<Object, Object> hashMap = null; Field[] arrayOfField; int i; byte b;
/*  207 */     for (i = (arrayOfField = paramClass.getDeclaredFields()).length, b = 0; b < i; b++) {
/*  208 */       Field field; if ((field = arrayOfField[b]).isEnumConstant()) {
/*      */         com.a.a.a.x x1;
/*      */ 
/*      */         
/*  212 */         if ((x1 = field.<Annotation>getAnnotation(com.a.a.a.x.class)) != null) {
/*      */           String str;
/*      */ 
/*      */           
/*  216 */           if (!(str = x1.a()).isEmpty())
/*      */           
/*      */           { 
/*  219 */             if (hashMap == null) {
/*  220 */               hashMap = new HashMap<>();
/*      */             }
/*  222 */             hashMap.put(field.getName(), str); } 
/*      */         } 
/*      */       } 
/*  225 */     }  if (hashMap != null) {
/*  226 */       for (byte b1 = 0; b1 < i; b1++) {
/*  227 */         String str1 = paramArrayOfEnum[b1].name();
/*      */         String str2;
/*  229 */         if ((str2 = (String)hashMap.get(str1)) != null) {
/*  230 */           paramArrayOfString[b1] = str2;
/*      */         }
/*      */       } 
/*      */     }
/*  234 */     return paramArrayOfString;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(Class<?> paramClass, Enum<?>[] paramArrayOfEnum, String[][] paramArrayOfString) {
/*      */     Field[] arrayOfField;
/*      */     int i;
/*      */     byte b;
/*  242 */     for (i = (arrayOfField = paramClass.getDeclaredFields()).length, b = 0; b < i; ) {
/*  243 */       Field field; String[] arrayOfString; c c1; if ((field = arrayOfField[b]).isEnumConstant() && (
/*      */         
/*  245 */         c1 = field.<Annotation>getAnnotation(c.class)) != null && (
/*      */         
/*  247 */         arrayOfString = c1.a()).length != 0) {
/*  248 */         String str = field.getName(); byte b1;
/*      */         int j;
/*  250 */         for (b1 = 0, j = paramArrayOfEnum.length; b1 < j; b1++) {
/*  251 */           if (str.equals(paramArrayOfEnum[b1].name())) {
/*  252 */             paramArrayOfString[b1] = arrayOfString;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       b++;
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
/*      */   public final Enum<?> a(Class<Enum<?>> paramClass) {
/*  272 */     return i.a(paramClass, j.class);
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
/*      */   public final w a(d paramd) {
/*      */     ab ab;
/*  285 */     if ((ab = (ab)a(paramd, ab.class)) == null) {
/*  286 */       return null;
/*      */     }
/*      */     String str;
/*  289 */     if ((str = ab.b()) != null && str.isEmpty()) {
/*  290 */       str = null;
/*      */     }
/*  292 */     return w.a(ab.a(), str);
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean b(d paramd) {
/*      */     r r;
/*  298 */     return ((r = (r)a(paramd, r.class)) == null) ? null : Boolean.valueOf(r.a());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final q.a b(b paramb) {
/*      */     q q;
/*  305 */     if ((q = (q)a(paramb, q.class)) == null) {
/*  306 */       return q.a.a();
/*      */     }
/*  308 */     return q.a.a(q);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final q.a e(b paramb) {
/*  315 */     return b(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final t.a c(b paramb) {
/*      */     t t;
/*  322 */     if ((t = (t)a(paramb, t.class)) == null) {
/*  323 */       return t.a.a();
/*      */     }
/*  325 */     return t.a.a(t);
/*      */   }
/*      */   
/*      */   public final Object d(b paramb) {
/*      */     String str;
/*      */     k k;
/*  331 */     if ((k = (k)a(paramb, k.class)) != null && 
/*      */ 
/*      */       
/*  334 */       !(str = k.a()).isEmpty()) {
/*  335 */       return str;
/*      */     }
/*      */     
/*  338 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object c(d paramd) {
/*      */     d d1;
/*  345 */     return ((d1 = (d)a(paramd, d.class)) == null) ? null : d1.a();
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
/*      */   public final ap<?> a(d paramd, ap<?> paramap) {
/*      */     f f;
/*  365 */     return (ap<?>)(((f = (f)a(paramd, f.class)) == null) ? paramap : paramap.a(f));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String g(j paramj) {
/*      */     w w;
/*  377 */     return ((w = L(paramj)) == null) ? null : w.b();
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<w> l(b paramb) {
/*      */     c c1;
/*  383 */     if ((c1 = (c)a(paramb, c.class)) == null) {
/*  384 */       return null;
/*      */     }
/*      */     String[] arrayOfString;
/*      */     int i;
/*  388 */     if ((i = (arrayOfString = c1.a()).length) == 0) {
/*  389 */       return Collections.emptyList();
/*      */     }
/*  391 */     ArrayList<w> arrayList = new ArrayList(i);
/*  392 */     for (byte b1 = 0; b1 < i; b1++) {
/*  393 */       arrayList.add(w.a(arrayOfString[b1]));
/*      */     }
/*  395 */     return arrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean d(j paramj) {
/*  400 */     return K(paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Boolean f(j paramj) {
/*      */     com.a.a.a.x x1;
/*  407 */     if ((x1 = (com.a.a.a.x)a(paramj, com.a.a.a.x.class)) != null) {
/*  408 */       return Boolean.valueOf(x1.c());
/*      */     }
/*  410 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final com.a.a.a.x.a m(b paramb) {
/*      */     com.a.a.a.x x1;
/*  416 */     if ((x1 = (com.a.a.a.x)a(paramb, com.a.a.a.x.class)) != null) {
/*  417 */       return x1.f();
/*      */     }
/*  419 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final String j(b paramb) {
/*      */     y y;
/*  425 */     return ((y = (y)a(paramb, y.class)) == null) ? null : y.a();
/*      */   }
/*      */   
/*      */   public final Integer k(b paramb) {
/*      */     com.a.a.a.x x1;
/*      */     int i;
/*  431 */     if ((x1 = (com.a.a.a.x)a(paramb, com.a.a.a.x.class)) != null && (
/*      */       
/*  433 */       i = x1.d()) != -1) {
/*  434 */       return Integer.valueOf(i);
/*      */     }
/*      */     
/*  437 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final String i(b paramb) {
/*      */     com.a.a.a.x x1;
/*  443 */     if ((x1 = (com.a.a.a.x)a(paramb, com.a.a.a.x.class)) == null) {
/*  444 */       return null;
/*      */     }
/*      */     
/*      */     String str;
/*  448 */     return (str = x1.e()).isEmpty() ? null : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l.d h(b paramb) {
/*      */     l l;
/*  456 */     return ((l = (l)a(paramb, l.class)) == null) ? null : l.d.a(l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final a.a b(j paramj) {
/*      */     v v;
/*  463 */     if ((v = (v)a(paramj, v.class)) != null) {
/*  464 */       return a.a.a(v.a());
/*      */     }
/*      */     h h;
/*  467 */     if ((h = (h)a(paramj, h.class)) != null) {
/*  468 */       return a.a.b(h.a());
/*      */     }
/*  470 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final r c(j paramj) {
/*      */     ah ah;
/*  479 */     if ((ah = (ah)a(paramj, ah.class)) == null || !ah.a()) {
/*  480 */       return null;
/*      */     }
/*  482 */     String str2 = ah.b();
/*  483 */     String str1 = ah.c();
/*  484 */     return r.a(str2, str1);
/*      */   }
/*      */ 
/*      */   
/*      */   public final b.a e(j paramj) {
/*      */     b b;
/*  490 */     if ((b = (b)a(paramj, b.class)) == null) {
/*  491 */       return null;
/*      */     }
/*      */     
/*      */     b.a a1;
/*  495 */     if (!(a1 = b.a.a(b)).b()) {
/*      */       String str;
/*      */       
/*  498 */       if (!(paramj instanceof k)) {
/*  499 */         str = paramj.d().getName();
/*      */       } else {
/*      */         k k;
/*  502 */         if ((k = (k)str).f() == 0) {
/*  503 */           str = str.d().getName();
/*      */         } else {
/*  505 */           str = k.a(0).getName();
/*      */         } 
/*      */       } 
/*  508 */       a1 = a1.b(str);
/*      */     } 
/*  510 */     return a1;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final Object h(j paramj) {
/*      */     b.a a1;
/*  517 */     return ((a1 = e(paramj)) == null) ? null : a1.a();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<?>[] g(b paramb) {
/*      */     aj aj;
/*  524 */     return ((aj = (aj)a(paramb, aj.class)) == null) ? null : aj.a();
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
/*      */   public final k a(k paramk1, k paramk2) {
/*  545 */     Class<?> clazz1 = paramk1.a(0);
/*  546 */     Class<?> clazz2 = paramk2.a(0);
/*      */ 
/*      */ 
/*      */     
/*  550 */     if (clazz1.isPrimitive()) {
/*  551 */       if (!clazz2.isPrimitive()) {
/*  552 */         return paramk1;
/*      */       }
/*      */       
/*  555 */       return null;
/*  556 */     }  if (clazz2.isPrimitive()) {
/*  557 */       return paramk2;
/*      */     }
/*      */     
/*  560 */     if (clazz1 == String.class) {
/*  561 */       if (clazz2 != String.class) {
/*  562 */         return paramk1;
/*      */       }
/*  564 */     } else if (clazz2 == String.class) {
/*  565 */       return paramk2;
/*      */     } 
/*      */     
/*  568 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final w c() {
/*  575 */     return null;
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
/*      */   public final h<?> a(q<?> paramq, d paramd, j paramj) {
/*  588 */     return c(paramq, paramd, paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final h<?> a(q<?> paramq, j paramj, j paramj1) {
/*  599 */     if (paramj1.n() || paramj1.F()) {
/*  600 */       return null;
/*      */     }
/*      */     
/*  603 */     return c(paramq, paramj, paramj1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final h<?> b(q<?> paramq, j paramj, j paramj1) {
/*  612 */     if (paramj1.u() == null) {
/*  613 */       throw new IllegalArgumentException("Must call method with a container or reference type (got " + paramj1 + ")");
/*      */     }
/*  615 */     return c(paramq, paramj, paramj1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<b> f(b paramb) {
/*      */     ad ad;
/*  622 */     if ((ad = (ad)a(paramb, ad.class)) == null) return null; 
/*  623 */     ad.a[] arrayOfA2 = ad.a();
/*      */ 
/*      */ 
/*      */     
/*  627 */     if (ad.b()) {
/*  628 */       return a(paramb.b(), arrayOfA2);
/*      */     }
/*  630 */     ArrayList<b> arrayList = new ArrayList(arrayOfA2.length); ad.a[] arrayOfA1; int i; byte b1;
/*  631 */     for (i = (arrayOfA1 = arrayOfA2).length, b1 = 0; b1 < i; ) { ad.a a1 = arrayOfA1[b1];
/*  632 */       arrayList.add(new b(a1.a(), a1.b())); String[] arrayOfString; int j;
/*      */       byte b2;
/*  634 */       for (j = (arrayOfString = a1.c()).length, b2 = 0; b2 < j; ) { String str = arrayOfString[b2];
/*  635 */         arrayList.add(new b(a1.a(), str)); b2++; }
/*      */        b1++; }
/*      */     
/*  638 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<b> a(String paramString, ad.a[] paramArrayOfa) {
/*  645 */     ArrayList<b> arrayList = new ArrayList(paramArrayOfa.length);
/*  646 */     HashSet<String> hashSet = new HashSet(); int i; byte b;
/*  647 */     for (i = (paramArrayOfa = paramArrayOfa).length, b = 0; b < i; ) {
/*      */       ad.a a1; String str;
/*  649 */       if (!(str = (a1 = paramArrayOfa[b]).b()).isEmpty() && hashSet.contains(str)) {
/*  650 */         throw new IllegalArgumentException("Annotated type [" + paramString + "] got repeated subtype name [" + str + "]");
/*      */       }
/*  652 */       hashSet.add(str);
/*      */       
/*  654 */       arrayList.add(new b(a1.a(), str)); String[] arrayOfString;
/*      */       int j;
/*      */       byte b1;
/*  657 */       for (j = (arrayOfString = a1.c()).length, b1 = 0; b1 < j; ) {
/*  658 */         String str1; if (!(str1 = arrayOfString[b1]).isEmpty() && hashSet.contains(str1)) {
/*  659 */           throw new IllegalArgumentException("Annotated type [" + paramString + "] got repeated subtype name [" + str1 + "]");
/*      */         }
/*  661 */         hashSet.add(str1);
/*      */         
/*  663 */         arrayList.add(new b(a1.a(), str1)); b1++;
/*      */       } 
/*      */       b++;
/*      */     } 
/*  667 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String d(d paramd) {
/*      */     ag ag;
/*  674 */     return ((ag = (ag)a(paramd, ag.class)) == null) ? null : ag.a();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean a(j paramj) {
/*  679 */     return Boolean.valueOf(b(paramj, ae.class));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ad a(b paramb) {
/*      */     n n;
/*  691 */     if ((n = (n)a(paramb, n.class)) == null || n.b() == am.b.class) {
/*  692 */       return null;
/*      */     }
/*      */     
/*  695 */     w w = w.a(n.a());
/*  696 */     return new ad(w, n.d(), n.b(), n.c());
/*      */   }
/*      */ 
/*      */   
/*      */   public final ad a(b paramb, ad paramad) {
/*      */     o o1;
/*  702 */     if ((o1 = (o)a(paramb, o.class)) == null) {
/*  703 */       return paramad;
/*      */     }
/*  705 */     if (paramad == null) {
/*  706 */       paramad = ad.a();
/*      */     }
/*  708 */     return paramad.a(o1.a());
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
/*      */   public final Object n(b paramb) {
/*      */     f f;
/*  721 */     if ((f = (f)a(paramb, f.class)) != null) {
/*      */       Class<o.a> clazz;
/*      */       
/*  724 */       if ((clazz = f.a()) != o.a.class) {
/*  725 */         return clazz;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     aa aa;
/*      */ 
/*      */     
/*  734 */     if ((aa = (aa)a(paramb, aa.class)) != null && aa.a()) {
/*      */       
/*  736 */       Class<?> clazz = paramb.d();
/*  737 */       return new ad(clazz);
/*      */     } 
/*  739 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object o(b paramb) {
/*      */     f f;
/*  746 */     if ((f = (f)a(paramb, f.class)) != null) {
/*      */       Class<o.a> clazz;
/*      */       
/*  749 */       if ((clazz = f.c()) != o.a.class) {
/*  750 */         return clazz;
/*      */       }
/*      */     } 
/*  753 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object p(b paramb) {
/*      */     f f;
/*  760 */     if ((f = (f)a(paramb, f.class)) != null) {
/*      */       Class<o.a> clazz;
/*      */       
/*  763 */       if ((clazz = f.b()) != o.a.class) {
/*  764 */         return clazz;
/*      */       }
/*      */     } 
/*  767 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object q(b paramb) {
/*      */     f f;
/*  774 */     if ((f = (f)a(paramb, f.class)) != null) {
/*      */       Class<o.a> clazz;
/*      */       
/*  777 */       if ((clazz = f.d()) != o.a.class) {
/*  778 */         return clazz;
/*      */       }
/*      */     } 
/*  781 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final s.b t(b paramb) {
/*      */     s s;
/*      */     s.b b1;
/*  791 */     if ((b1 = ((s = (s)a(paramb, s.class)) == null) ? s.b.a() : s.b.a(s)).b() == s.a.g) {
/*  792 */       b1 = a(paramb, b1);
/*      */     }
/*  794 */     return b1;
/*      */   }
/*      */ 
/*      */   
/*      */   private s.b a(b paramb, s.b paramb1) {
/*      */     f f;
/*  800 */     if ((f = (f)a(paramb, f.class)) != null) {
/*  801 */       switch (y.a[f.k().ordinal()]) {
/*      */         case 1:
/*  803 */           return paramb1.a(s.a.a);
/*      */         case 2:
/*  805 */           return paramb1.a(s.a.b);
/*      */         case 3:
/*  807 */           return paramb1.a(s.a.e);
/*      */         case 4:
/*  809 */           return paramb1.a(s.a.d);
/*      */       } 
/*      */ 
/*      */     
/*      */     }
/*  814 */     return paramb1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final f.b r(b paramb) {
/*      */     f f;
/*  821 */     return ((f = (f)a(paramb, f.class)) == null) ? null : f.h();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Object s(b paramb) {
/*      */     f f;
/*  827 */     return ((f = (f)a(paramb, f.class)) == null) ? null : a(f.i(), k.a.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public final Object i(j paramj) {
/*      */     f f;
/*  833 */     return ((f = (f)a(paramj, f.class)) == null) ? null : a(f.j(), k.a.class);
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
/*      */   public final j a(q<?> paramq, b paramb, j paramj) {
/*      */     g g;
/*      */     j j1;
/*  847 */     paramj = paramj;
/*  848 */     o o1 = paramq.p();
/*      */ 
/*      */     
/*      */     f f;
/*      */     
/*      */     Class<?> clazz;
/*      */     
/*  855 */     if ((clazz = (Class<?>)(((f = (f)a(paramb, f.class)) == null) ? null : b(f.e()))) != null) {
/*  856 */       if (paramj.a(clazz)) {
/*      */ 
/*      */         
/*  859 */         paramj = paramj.a();
/*      */       } else {
/*  861 */         Class<?> clazz1 = paramj.b();
/*      */ 
/*      */         
/*      */         try {
/*  865 */           if (clazz.isAssignableFrom(clazz1)) {
/*  866 */             paramj = o.b(paramj, clazz);
/*  867 */           } else if (clazz1.isAssignableFrom(clazz)) {
/*  868 */             paramj = o1.a(paramj, clazz);
/*  869 */           } else if (b(clazz1, clazz)) {
/*      */             
/*  871 */             paramj = paramj.a();
/*      */           } else {
/*  873 */             throw a(
/*  874 */                 String.format("Cannot refine serialization type %s into %s; types not related", new Object[] {
/*  875 */                     paramj, clazz.getName() }));
/*      */           } 
/*  877 */         } catch (IllegalArgumentException illegalArgumentException2) {
/*  878 */           IllegalArgumentException illegalArgumentException1; throw a(illegalArgumentException1 = null, 
/*  879 */               String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[] {
/*  880 */                   paramj, clazz.getName(), paramb.b(), illegalArgumentException1.getMessage()
/*      */                 }));
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  887 */     if (paramj.p()) {
/*  888 */       j j3 = paramj.t();
/*      */       Class<?> clazz1;
/*  890 */       if ((clazz1 = (Class<?>)((f == null) ? null : b(f.f()))) != null) {
/*  891 */         if (j3.a(clazz1)) {
/*  892 */           j3 = j3.a();
/*      */         } else {
/*  894 */           clazz = j3.b();
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/*  899 */             if (clazz1.isAssignableFrom(clazz)) {
/*  900 */               j3 = o.b(j3, clazz1);
/*  901 */             } else if (clazz.isAssignableFrom(clazz1)) {
/*  902 */               j3 = o1.a(j3, clazz1);
/*  903 */             } else if (b(clazz, clazz1)) {
/*      */               
/*  905 */               j3 = j3.a();
/*      */             } else {
/*  907 */               throw a(
/*  908 */                   String.format("Cannot refine serialization key type %s into %s; types not related", new Object[] {
/*  909 */                       j3, clazz1.getName() }));
/*      */             } 
/*  911 */           } catch (IllegalArgumentException illegalArgumentException) {
/*  912 */             throw a(o1 = null, 
/*  913 */                 String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[] {
/*  914 */                     paramj, clazz1.getName(), paramb.b(), o1.getMessage() }));
/*      */           } 
/*      */         } 
/*  917 */         g = ((g)paramj).e(j3);
/*      */       } 
/*      */     } 
/*      */     
/*      */     j j2;
/*  922 */     if ((j2 = g.u()) != null) {
/*      */       Class<?> clazz1;
/*      */       
/*  925 */       if ((clazz1 = (Class<?>)((f == null) ? null : b(f.g()))) != null) {
/*  926 */         if (j2.a(clazz1)) {
/*  927 */           j2 = j2.a();
/*      */         
/*      */         }
/*      */         else {
/*      */           
/*  932 */           clazz = j2.b();
/*      */           try {
/*  934 */             if (clazz1.isAssignableFrom(clazz)) {
/*  935 */               j2 = o.b(j2, clazz1);
/*  936 */             } else if (clazz.isAssignableFrom(clazz1)) {
/*  937 */               j2 = o1.a(j2, clazz1);
/*  938 */             } else if (b(clazz, clazz1)) {
/*      */               
/*  940 */               j2 = j2.a();
/*      */             } else {
/*  942 */               throw a(
/*  943 */                   String.format("Cannot refine serialization content type %s into %s; types not related", new Object[] {
/*  944 */                       j2, clazz1.getName() }));
/*      */             } 
/*  946 */           } catch (IllegalArgumentException illegalArgumentException) {
/*  947 */             throw a(o1 = null, 
/*  948 */                 String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[] {
/*  949 */                     g, clazz1.getName(), paramb.b(), o1.getMessage() }));
/*      */           } 
/*      */         } 
/*  952 */         j1 = g.a(j2);
/*      */       } 
/*      */     } 
/*  955 */     return j1;
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
/*      */   public final String[] e(d paramd) {
/*      */     z z;
/*  985 */     return ((z = (z)a(paramd, z.class)) == null) ? null : z.a();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean u(b paramb) {
/*  990 */     return J(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final Boolean J(b paramb) {
/*      */     z z;
/*  997 */     if ((z = (z)a(paramb, z.class)) != null && z.b()) {
/*  998 */       return Boolean.TRUE;
/*      */     }
/* 1000 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(q<?> paramq, d paramd, List<e> paramList) {
/*      */     b b;
/* 1007 */     if ((b = (b)a(paramd, b.class)) == null) {
/*      */       return;
/*      */     }
/* 1010 */     boolean bool = b.c();
/* 1011 */     j j = null;
/*      */ 
/*      */     
/* 1014 */     b.a[] arrayOfA = b.a(); int i;
/* 1015 */     for (byte b1 = 0; b1 < i; b1++) {
/* 1016 */       if (j == null) {
/* 1017 */         j = paramq.b(Object.class);
/*      */       }
/* 1019 */       e e = a(arrayOfA[b1], paramq, paramd, j);
/*      */       
/* 1021 */       if (bool) {
/* 1022 */         paramList.add(b1, e);
/*      */       } else {
/* 1024 */         paramList.add(e);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1029 */     b.b[] arrayOfB = b.b(); int k;
/* 1030 */     for (i = 0, k = arrayOfB.length; i < k; i++) {
/* 1031 */       e e = a(arrayOfB[i], paramq, paramd);
/*      */       
/* 1033 */       if (bool) {
/* 1034 */         paramList.add(i, e);
/*      */       } else {
/* 1036 */         paramList.add(e);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private e a(b.a parama, q<?> paramq, d paramd, j paramj) {
/* 1044 */     v v = parama.e() ? v.a : v.b;
/*      */ 
/*      */     
/* 1047 */     String str = parama.a();
/*      */     
/*      */     w w;
/*      */     
/* 1051 */     if (!(w = a(parama.b(), parama.c())).c()) {
/* 1052 */       w = w.a(str);
/*      */     }
/*      */     
/* 1055 */     ao ao = new ao(paramd, paramd.d(), str, paramj);
/*      */ 
/*      */     
/* 1058 */     aa aa = aa.a(paramq, ao, w, v, parama
/* 1059 */         .d());
/*      */     
/* 1061 */     return (e)a.a(str, (s)aa, paramd
/* 1062 */         .f(), paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private e a(b.b paramb, q<?> paramq, d paramd) {
/* 1068 */     v v = paramb.e() ? v.a : v.b;
/*      */     
/* 1070 */     w w = a(paramb.b(), paramb.c());
/* 1071 */     j j = paramq.b(paramb.f());
/*      */ 
/*      */     
/* 1074 */     ao ao = new ao(paramd, paramd.d(), w.b(), j);
/*      */     
/* 1076 */     aa.a(paramq, ao, w, v, paramb
/* 1077 */         .d());
/*      */     
/* 1079 */     Class clazz = paramb.a();
/*      */     
/*      */     d d1;
/*      */     
/*      */     s s;
/* 1084 */     if ((s = (s)(((d1 = paramq.m()) == null) ? null : d.n())) == null) {
/* 1085 */       s = (s)i.b(clazz, paramq
/* 1086 */           .g());
/*      */     }
/*      */ 
/*      */     
/* 1090 */     return (e)s.l();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final w v(b paramb) {
/*      */     String str;
/* 1102 */     boolean bool = false;
/*      */     m m;
/* 1104 */     if ((m = (m)a(paramb, m.class)) != null) {
/*      */       String str1;
/*      */       
/* 1107 */       if (!(str1 = m.a()).isEmpty()) {
/* 1108 */         return w.a(str1);
/*      */       }
/* 1110 */       bool = true;
/*      */     } 
/*      */     com.a.a.a.x x1;
/* 1113 */     if ((x1 = (com.a.a.a.x)a(paramb, com.a.a.a.x.class)) != null) {
/*      */ 
/*      */       
/* 1116 */       if ((str = x1.b()) != null && str.isEmpty()) {
/* 1117 */         str = null;
/*      */       }
/* 1119 */       return w.a(x1.a(), str);
/*      */     } 
/* 1121 */     if (bool || a((b)str, (Class[])a)) {
/* 1122 */       return w.a;
/*      */     }
/* 1124 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean w(b paramb) {
/*      */     u u;
/* 1130 */     if ((u = (u)a(paramb, u.class)) == null) {
/* 1131 */       return null;
/*      */     }
/* 1133 */     return Boolean.valueOf(u.a());
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean x(b paramb) {
/*      */     ai ai;
/* 1139 */     if ((ai = (ai)a(paramb, ai.class)) == null) {
/* 1140 */       return null;
/*      */     }
/* 1142 */     return Boolean.valueOf(ai.a());
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean y(b paramb) {
/*      */     d d;
/* 1148 */     if ((d = (d)a(paramb, d.class)) == null) {
/* 1149 */       return null;
/*      */     }
/* 1151 */     return Boolean.valueOf(d.a());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final boolean b(k paramk) {
/* 1158 */     return b(paramk, d.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final boolean a(k paramk) {
/*      */     ai ai;
/* 1166 */     if ((ai = (ai)a(paramk, ai.class)) != null && ai.a()) return true;  return false;
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
/*      */   public final Object z(b paramb) {
/*      */     c c1;
/* 1179 */     if ((c1 = (c)a(paramb, c.class)) != null) {
/*      */       Class<k.a> clazz;
/*      */       
/* 1182 */       if ((clazz = c1.a()) != k.a.class) {
/* 1183 */         return clazz;
/*      */       }
/*      */     } 
/* 1186 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Object A(b paramb) {
/*      */     c c1;
/*      */     Class<p.a> clazz;
/* 1193 */     if ((c1 = (c)a(paramb, c.class)) != null && (
/*      */       
/* 1195 */       clazz = c1.c()) != p.a.class) {
/* 1196 */       return clazz;
/*      */     }
/*      */     
/* 1199 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object B(b paramb) {
/*      */     c c1;
/* 1206 */     if ((c1 = (c)a(paramb, c.class)) != null) {
/*      */       Class<k.a> clazz;
/*      */       
/* 1209 */       if ((clazz = c1.b()) != k.a.class) {
/* 1210 */         return clazz;
/*      */       }
/*      */     } 
/* 1213 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object C(b paramb) {
/*      */     c c1;
/* 1220 */     return ((c1 = (c)a(paramb, c.class)) == null) ? null : a(c1.e(), k.a.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object j(j paramj) {
/*      */     c c1;
/* 1227 */     return ((c1 = (c)a(paramj, c.class)) == null) ? null : a(c1.f(), k.a.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j b(q<?> paramq, b paramb, j paramj) {
/*      */     g g;
/*      */     j j1;
/* 1240 */     paramj = paramj;
/* 1241 */     o o1 = paramq.p();
/*      */     
/*      */     c c1;
/*      */     
/*      */     Class<?> clazz;
/*      */     
/* 1247 */     if ((clazz = (Class<?>)(((c1 = (c)a(paramb, c.class)) == null) ? null : b(c1.g()))) != null && !paramj.a(clazz) && 
/* 1248 */       !a(paramj, clazz)) {
/*      */       try {
/* 1250 */         paramj = o1.a(paramj, clazz);
/* 1251 */       } catch (IllegalArgumentException illegalArgumentException2) {
/* 1252 */         IllegalArgumentException illegalArgumentException1; throw a(illegalArgumentException1 = null, 
/* 1253 */             String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[] {
/* 1254 */                 paramj, clazz.getName(), paramb.b(), illegalArgumentException1.getMessage()
/*      */               }));
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1260 */     if (paramj.p()) {
/* 1261 */       j j3 = paramj.t();
/*      */       
/* 1263 */       if ((clazz = (Class<?>)((c1 == null) ? null : b(c1.h()))) != null && 
/* 1264 */         !a(j3, clazz))
/*      */         try {
/* 1266 */           j3 = o1.a(j3, clazz);
/* 1267 */           g = ((g)paramj).e(j3);
/* 1268 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 1269 */           throw a(o1 = null, 
/* 1270 */               String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[] {
/* 1271 */                   g, clazz.getName(), paramb.b(), o1.getMessage()
/*      */                 }));
/*      */         }  
/*      */     } 
/*      */     j j2;
/* 1276 */     if ((j2 = g.u()) != null)
/*      */     {
/*      */       
/* 1279 */       if ((clazz = (Class<?>)((c1 == null) ? null : b(c1.i()))) != null && 
/* 1280 */         !a(j2, clazz))
/*      */         try {
/* 1282 */           j2 = o1.a(j2, clazz);
/* 1283 */           j1 = g.a(j2);
/* 1284 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 1285 */           throw a(o1 = null, 
/* 1286 */               String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[] {
/* 1287 */                   j1, clazz.getName(), paramb.b(), o1.getMessage()
/*      */                 }));
/*      */         }  
/*      */     }
/* 1291 */     return j1;
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
/*      */   public final Object f(d paramd) {
/*      */     i i;
/* 1323 */     return ((i = (i)a(paramd, i.class)) == null) ? null : i.a();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<?> g(d paramd) {
/*      */     c c1;
/* 1330 */     return ((c1 = (c)a(paramd, c.class)) == null) ? null : b(c1.d());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final e.a h(d paramd) {
/*      */     e e;
/* 1337 */     return ((e = (e)a(paramd, e.class)) == null) ? null : new e.a(e);
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
/*      */   public final w D(b paramb) {
/*      */     String str;
/* 1351 */     boolean bool = false;
/*      */     ac ac;
/* 1353 */     if ((ac = (ac)a(paramb, ac.class)) != null) {
/*      */       String str1;
/*      */       
/* 1356 */       if ((str1 = ac.a()).isEmpty()) {
/* 1357 */         bool = true;
/*      */       } else {
/* 1359 */         return w.a(str1);
/*      */       } 
/*      */     } 
/*      */     com.a.a.a.x x1;
/* 1363 */     if ((x1 = (com.a.a.a.x)a(paramb, com.a.a.a.x.class)) != null) {
/*      */ 
/*      */       
/* 1366 */       if ((str = x1.b()) != null && str.isEmpty()) {
/* 1367 */         str = null;
/*      */       }
/* 1369 */       return w.a(x1.a(), str);
/*      */     } 
/* 1371 */     if (bool || a((b)str, (Class[])b)) {
/* 1372 */       return w.a;
/*      */     }
/* 1374 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean E(b paramb) {
/*      */     e e;
/* 1380 */     return ((e = (e)a(paramb, e.class)) == null) ? null : Boolean.valueOf(e.a());
/*      */   }
/*      */ 
/*      */   
/*      */   public final ac.a F(b paramb) {
/* 1385 */     return ac.a.a((ac)a(paramb, ac.class));
/*      */   }
/*      */ 
/*      */   
/*      */   public final Boolean G(b paramb) {
/*      */     w w;
/* 1391 */     return ((w = (w)a(paramb, w.class)) == null) ? null : w.a().a();
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
/*      */   @Deprecated
/*      */   public final boolean H(b paramb) {
/*      */     i i;
/* 1408 */     if ((i = (i)a(paramb, i.class)) != null) {
/* 1409 */       return (i.a() != i.a.d);
/*      */     }
/*      */     
/*      */     Boolean bool;
/* 1413 */     if (this.e && 
/* 1414 */       paramb instanceof f && 
/* 1415 */       c != null && (
/*      */       
/* 1417 */       bool = c.b(paramb)) != null) {
/* 1418 */       return bool.booleanValue();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1423 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final i.a I(b paramb) {
/*      */     i i;
/* 1430 */     return ((i = (i)a(paramb, i.class)) == null) ? null : i.a();
/*      */   }
/*      */ 
/*      */   
/*      */   public final i.a a(q<?> paramq, b paramb) {
/*      */     i i;
/* 1436 */     if ((i = (i)a(paramb, i.class)) != null) {
/* 1437 */       return i.a();
/*      */     }
/* 1439 */     if (this.e && paramq
/* 1440 */       .a(q.l)) {
/*      */       Boolean bool;
/* 1442 */       if (paramb instanceof f && 
/* 1443 */         c != null && (
/*      */         
/* 1445 */         bool = c.b(paramb)) != null && bool.booleanValue())
/*      */       {
/*      */         
/* 1448 */         return i.a.c;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1453 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean K(b paramb) {
/*      */     p p;
/* 1465 */     if ((p = (p)a(paramb, p.class)) != null)
/* 1466 */       return p.a(); 
/*      */     Boolean bool;
/* 1468 */     if (c != null && (
/*      */       
/* 1470 */       bool = c.a(paramb)) != null) {
/* 1471 */       return bool.booleanValue();
/*      */     }
/*      */     
/* 1474 */     return false;
/*      */   }
/*      */   
/*      */   private static Class<?> b(Class<?> paramClass) {
/* 1478 */     if (paramClass == null || i.e(paramClass)) {
/* 1479 */       return null;
/*      */     }
/* 1481 */     return paramClass;
/*      */   }
/*      */ 
/*      */   
/*      */   private Class<?> a(Class<?> paramClass1, Class<?> paramClass2) {
/* 1486 */     if ((paramClass1 = b(paramClass1)) == null || paramClass1 == paramClass2) return null;  return paramClass1;
/*      */   }
/*      */   
/*      */   private static w a(String paramString1, String paramString2) {
/* 1490 */     if (paramString1.isEmpty()) {
/* 1491 */       return w.a;
/*      */     }
/* 1493 */     if (paramString2 == null || paramString2.isEmpty()) {
/* 1494 */       return w.a(paramString1);
/*      */     }
/* 1496 */     return w.a(paramString1, paramString2);
/*      */   }
/*      */   private static w L(b paramb) {
/*      */     w w;
/*      */     o o1;
/* 1501 */     if (paramb instanceof n && (
/*      */ 
/*      */ 
/*      */       
/* 1505 */       o1 = (paramb = paramb).e()) != null && 
/* 1506 */       c != null && (
/*      */       
/* 1508 */       w = c.a((n)paramb)) != null) {
/* 1509 */       return w;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1514 */     return null;
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
/*      */   private h<?> c(q<?> paramq, b paramb, j paramj) {
/*      */     o o1;
/* 1527 */     af af = (af)a(paramb, af.class);
/*      */     
/*      */     h h1;
/* 1530 */     if ((h1 = (h)a(paramb, h.class)) != null) {
/* 1531 */       if (af == null) {
/* 1532 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1536 */       h h2 = paramq.a(paramb, h1.a());
/*      */     } else {
/* 1538 */       if (af == null) {
/* 1539 */         return null;
/*      */       }
/*      */       
/* 1542 */       if (af.a() == af.b.a) {
/* 1543 */         return (h<?>)e();
/*      */       }
/* 1545 */       o1 = d();
/*      */     } 
/*      */     
/*      */     g g1;
/*      */     
/* 1550 */     g g = ((g1 = (g)a(paramb, g.class)) == null) ? null : paramq.b(paramb, g1.a());
/*      */ 
/*      */ 
/*      */     
/* 1554 */     h<?> h = o1.a(af.a(), g);
/*      */ 
/*      */     
/*      */     af.a a1;
/*      */     
/* 1559 */     if ((a1 = af.b()) == af.a.d && paramb instanceof d) {
/* 1560 */       a1 = af.a.a;
/*      */     }
/*      */     
/* 1563 */     h = (h = h.a(a1)).a(af.c());
/*      */ 
/*      */ 
/*      */     
/*      */     Class<af.c> clazz;
/*      */ 
/*      */     
/* 1570 */     if ((clazz = af.d()) != af.c.class && !clazz.isAnnotation()) {
/* 1571 */       h = h.a(clazz);
/*      */     }
/*      */     
/* 1574 */     return h = h.a(af.e());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static o d() {
/* 1582 */     return new o();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static o e() {
/* 1590 */     return o.b();
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean b(Class<?> paramClass1, Class<?> paramClass2) {
/* 1595 */     if (paramClass1.isPrimitive()) {
/* 1596 */       return (paramClass1 == i.j(paramClass2));
/*      */     }
/* 1598 */     if (paramClass2.isPrimitive()) {
/* 1599 */       return (paramClass2 == i.j(paramClass1));
/*      */     }
/* 1601 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(j paramj, Class<?> paramClass) {
/* 1606 */     if (paramj.l()) {
/* 1607 */       return paramj.a(i.j(paramClass));
/*      */     }
/* 1609 */     if (paramClass.isPrimitive()) {
/* 1610 */       return (paramClass == i.j(paramj.b()));
/*      */     }
/* 1612 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static l a(String paramString) {
/* 1617 */     return new l(null, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private static l a(Throwable paramThrowable, String paramString) {
/* 1622 */     return new l(null, paramString, paramThrowable);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */