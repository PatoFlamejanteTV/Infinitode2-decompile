/*      */ package com.a.a.c.k.b;
/*      */ 
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.a.s;
/*      */ import com.a.a.b.f.a;
/*      */ import com.a.a.b.h;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.a.a;
/*      */ import com.a.a.c.aa;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.e;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.i.i;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k.a.k;
/*      */ import com.a.a.c.k.j;
/*      */ import com.a.a.c.k.k;
/*      */ import com.a.a.c.k.o;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.c;
/*      */ import com.a.a.c.m.f;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.n;
/*      */ import com.a.a.c.o;
/*      */ import com.a.a.c.z;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ @a
/*      */ public class v
/*      */   extends j<Map<?, ?>>
/*      */   implements k
/*      */ {
/*   42 */   private static j b = o.b();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   47 */   public static final Object a = s.a.d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private c c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<Object> g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<Object> i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private i j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Set<String> l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Set<String> m;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object o;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean p;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private n.a q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean r;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v(Set<String> paramSet1, Set<String> paramSet2, j paramj1, j paramj2, boolean paramBoolean, i parami, o<?> paramo1, o<?> paramo2) {
/*  184 */     super(Map.class, false);
/*  185 */     this.l = (paramSet1 == null || paramSet1.isEmpty()) ? null : paramSet1;
/*      */     
/*  187 */     this.m = paramSet2;
/*  188 */     this.e = paramj1;
/*  189 */     this.f = paramj2;
/*  190 */     this.d = paramBoolean;
/*  191 */     this.j = parami;
/*  192 */     this.g = (o)paramo1;
/*  193 */     this.i = (o)paramo2;
/*  194 */     this.k = k.a();
/*  195 */     this.c = null;
/*  196 */     this.n = null;
/*  197 */     this.r = false;
/*  198 */     this.o = null;
/*  199 */     this.p = false;
/*      */     
/*  201 */     this.q = n.a(this.l, this.m);
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
/*      */   private v(v paramv, c paramc, o<?> paramo1, o<?> paramo2, Set<String> paramSet1, Set<String> paramSet2) {
/*  228 */     super(Map.class, false);
/*  229 */     this.l = (paramSet1 == null || paramSet1.isEmpty()) ? null : paramSet1;
/*      */     
/*  231 */     this.m = paramSet2;
/*  232 */     this.e = paramv.e;
/*  233 */     this.f = paramv.f;
/*  234 */     this.d = paramv.d;
/*  235 */     this.j = paramv.j;
/*  236 */     this.g = (o)paramo1;
/*  237 */     this.i = (o)paramo2;
/*      */     
/*  239 */     this.k = k.a();
/*  240 */     this.c = paramc;
/*  241 */     this.n = paramv.n;
/*  242 */     this.r = paramv.r;
/*  243 */     this.o = paramv.o;
/*  244 */     this.p = paramv.p;
/*      */     
/*  246 */     this.q = n.a(this.l, this.m);
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
/*      */   private v(v paramv, i parami, Object paramObject, boolean paramBoolean) {
/*  266 */     super(Map.class, false);
/*  267 */     this.l = paramv.l;
/*  268 */     this.m = paramv.m;
/*  269 */     this.e = paramv.e;
/*  270 */     this.f = paramv.f;
/*  271 */     this.d = paramv.d;
/*  272 */     this.j = parami;
/*  273 */     this.g = paramv.g;
/*  274 */     this.i = paramv.i;
/*      */ 
/*      */     
/*  277 */     this.k = paramv.k;
/*  278 */     this.c = paramv.c;
/*  279 */     this.n = paramv.n;
/*  280 */     this.r = paramv.r;
/*  281 */     this.o = paramObject;
/*  282 */     this.p = paramBoolean;
/*      */     
/*  284 */     this.q = paramv.q;
/*      */   }
/*      */ 
/*      */   
/*      */   private v(v paramv, Object paramObject, boolean paramBoolean) {
/*  289 */     super(Map.class, false);
/*  290 */     this.l = paramv.l;
/*  291 */     this.m = paramv.m;
/*  292 */     this.e = paramv.e;
/*  293 */     this.f = paramv.f;
/*  294 */     this.d = paramv.d;
/*  295 */     this.j = paramv.j;
/*  296 */     this.g = paramv.g;
/*  297 */     this.i = paramv.i;
/*      */     
/*  299 */     this.k = k.a();
/*  300 */     this.c = paramv.c;
/*  301 */     this.n = paramObject;
/*  302 */     this.r = paramBoolean;
/*  303 */     this.o = paramv.o;
/*  304 */     this.p = paramv.p;
/*      */     
/*  306 */     this.q = paramv.q;
/*      */   }
/*      */ 
/*      */   
/*      */   private v c(i parami) {
/*  311 */     if (this.j == parami) {
/*  312 */       return this;
/*      */     }
/*  314 */     a("_withValueTypeSerializer");
/*  315 */     return new v(this, parami, this.o, this.p);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private v a(c paramc, o<?> paramo1, o<?> paramo2, Set<String> paramSet1, Set<String> paramSet2, boolean paramBoolean) {
/*  325 */     a("withResolved");
/*  326 */     v v1 = new v(this, paramc, paramo1, paramo2, paramSet1, paramSet2);
/*  327 */     if (paramBoolean != v1.r) {
/*  328 */       v1 = new v(v1, this.n, paramBoolean);
/*      */     }
/*  330 */     return v1;
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
/*      */   private v b(Object paramObject) {
/*  345 */     if (this.n == paramObject) {
/*  346 */       return this;
/*      */     }
/*  348 */     a("withFilterId");
/*  349 */     return new v(this, paramObject, this.r);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final v a(Object paramObject, boolean paramBoolean) {
/*  359 */     if (paramObject == this.o && paramBoolean == this.p) {
/*  360 */       return this;
/*      */     }
/*  362 */     a("withContentInclusion");
/*  363 */     return new v(this, this.j, paramObject, paramBoolean);
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
/*      */   public static v a(Set<String> paramSet1, Set<String> paramSet2, j paramj, boolean paramBoolean, i parami, o<Object> paramo1, o<Object> paramo2, Object paramObject) {
/*      */     j j1;
/*  376 */     if (paramj == null) {
/*  377 */       j1 = paramj = b;
/*      */     } else {
/*  379 */       j1 = paramj.t();
/*  380 */       if (paramj.a(Properties.class)) {
/*      */ 
/*      */         
/*  383 */         paramj = o.b();
/*      */       } else {
/*  385 */         paramj = paramj.u();
/*      */       } 
/*      */     } 
/*      */     
/*  389 */     if (!paramBoolean) {
/*  390 */       paramBoolean = (paramj != null && paramj.m());
/*      */     
/*      */     }
/*  393 */     else if (paramj.b() == Object.class) {
/*  394 */       paramBoolean = false;
/*      */     } 
/*      */     
/*  397 */     v v1 = new v(paramSet1, paramSet2, j1, paramj, paramBoolean, parami, paramo1, paramo2);
/*      */     
/*  399 */     if (paramObject != null) {
/*  400 */       v1 = v1.b(paramObject);
/*      */     }
/*  402 */     return v1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static v a(Set<String> paramSet, j paramj, boolean paramBoolean, i parami, o<Object> paramo1, o<Object> paramo2, Object paramObject) {
/*  413 */     return a(paramSet, (Set<String>)null, paramj, paramBoolean, parami, paramo1, paramo2, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString) {
/*  420 */     i.a(v.class, this, paramString);
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
/*      */   public final o<?> a(aa paramaa, c paramc) {
/*  483 */     o<Object> o1 = null;
/*  484 */     o<Object> o2 = null;
/*  485 */     a a1 = paramaa.d();
/*      */     
/*      */     j j1;
/*      */     
/*  489 */     if (a(j1 = (j)((paramc == null) ? null : paramc.e()), a1)) {
/*      */       Object object1;
/*  491 */       if ((object1 = a1.o((b)j1)) != null) {
/*  492 */         o2 = paramaa.b((b)j1, object1);
/*      */       }
/*      */       
/*  495 */       if ((object1 = a1.p((b)j1)) != null) {
/*  496 */         o1 = paramaa.b((b)j1, object1);
/*      */       }
/*      */     } 
/*  499 */     if (o1 == null) {
/*  500 */       o1 = this.i;
/*      */     }
/*      */ 
/*      */     
/*  504 */     if ((o1 = a(paramaa, paramc, o1)) == null)
/*      */     {
/*      */ 
/*      */       
/*  508 */       if (this.d && !this.f.q()) {
/*  509 */         o1 = paramaa.c(this.f, paramc);
/*      */       }
/*      */     }
/*  512 */     if (o2 == null) {
/*  513 */       o2 = this.g;
/*      */     }
/*  515 */     if (o2 == null) {
/*  516 */       o2 = paramaa.d(this.e, paramc);
/*      */     } else {
/*  518 */       o2 = paramaa.b(o2, paramc);
/*      */     } 
/*  520 */     Set<String> set1 = this.l;
/*  521 */     Set<String> set2 = this.m;
/*  522 */     boolean bool = false;
/*  523 */     if (a(j1, a1)) {
/*  524 */       paramaa.c();
/*      */       
/*      */       Set set4;
/*  527 */       if (a(set4 = a1.b((b)j1).b())) {
/*  528 */         set1 = (set1 == null) ? new HashSet<>() : new HashSet<>(set1);
/*  529 */         for (String str : set4) {
/*  530 */           set1.add(str);
/*      */         }
/*      */       } 
/*      */       
/*      */       Set set3;
/*  535 */       if ((set3 = a1.c((b)j1).b()) != null) {
/*  536 */         set2 = (set2 == null) ? new HashSet<>() : new HashSet<>(set2);
/*  537 */         for (String str : set3) {
/*  538 */           set2.add(str);
/*      */         }
/*      */       } 
/*      */       
/*  542 */       Boolean bool3 = a1.u((b)j1);
/*  543 */       boolean bool2 = Boolean.TRUE.equals(bool3);
/*      */     }  Boolean bool1;
/*      */     l.d d;
/*  546 */     if ((d = a(paramaa, paramc, Map.class)) != null && (
/*      */       
/*  548 */       bool1 = d.a(l.a.d)) != null) {
/*  549 */       bool = bool1.booleanValue();
/*      */     }
/*      */     
/*  552 */     v v1 = a(paramc, o2, o1, set1, set2, bool);
/*      */     
/*      */     Object object;
/*  555 */     if (j1 != null && (
/*      */       
/*  557 */       object = a1.d((b)j1)) != null) {
/*  558 */       v1 = v1.b(object);
/*      */     }
/*      */     
/*      */     s.a a2;
/*  562 */     if ((object = b(paramaa, paramc, Map.class)) != null && (
/*      */ 
/*      */       
/*  565 */       a2 = object.c()) != s.a.g) {
/*      */       boolean bool2;
/*      */       
/*  568 */       switch (w.a[a2.ordinal()]) {
/*      */         case 1:
/*  570 */           object = f.a(this.f);
/*  571 */           bool2 = true;
/*  572 */           if (object != null && 
/*  573 */             object.getClass().isArray()) {
/*  574 */             object = c.a(object);
/*      */           }
/*      */           break;
/*      */         
/*      */         case 2:
/*  579 */           bool2 = true;
/*  580 */           object = this.f.F() ? a : null;
/*      */           break;
/*      */         case 3:
/*  583 */           bool2 = true;
/*  584 */           object = a;
/*      */           break;
/*      */         
/*      */         case 4:
/*  588 */           if ((object = bool2.a(null, object.e())) == null) {
/*  589 */             bool2 = true; break;
/*      */           } 
/*  591 */           bool2 = bool2.b(object);
/*      */           break;
/*      */         
/*      */         case 5:
/*  595 */           object = null;
/*  596 */           bool2 = true;
/*      */           break;
/*      */         
/*      */         default:
/*  600 */           object = null;
/*      */ 
/*      */           
/*  603 */           bool2 = false;
/*      */           break;
/*      */       } 
/*  606 */       v1 = v1.a(object, bool2);
/*      */     } 
/*      */     
/*  609 */     return (o<?>)v1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j d() {
/*  620 */     return this.f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(aa paramaa, Map<?, ?> paramMap) {
/*  631 */     if (paramMap.isEmpty()) {
/*  632 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     Object object;
/*      */     
/*  638 */     if ((object = this.o) == null && !this.p) {
/*  639 */       return false;
/*      */     }
/*  641 */     o<Object> o1 = this.i;
/*  642 */     boolean bool = (a == object) ? true : false;
/*  643 */     if (o1 != null) {
/*  644 */       for (Iterator<Object> iterator1 = paramMap.values().iterator(); iterator1.hasNext(); ) {
/*  645 */         Object object1; if ((object1 = iterator1.next()) == null) {
/*  646 */           if (!this.p)
/*      */           {
/*      */             
/*  649 */             return false; }  continue;
/*      */         } 
/*  651 */         if (bool) {
/*  652 */           if (!o1.a(paramaa, object1))
/*  653 */             return false;  continue;
/*      */         } 
/*  655 */         if (object == null || !object.equals(paramMap)) {
/*  656 */           return false;
/*      */         }
/*      */       } 
/*  659 */       return true;
/*      */     } 
/*      */     
/*  662 */     for (Iterator<Object> iterator = paramMap.values().iterator(); iterator.hasNext(); ) {
/*  663 */       Object object1; if ((object1 = iterator.next()) == null) {
/*  664 */         if (!this.p)
/*      */         {
/*      */           
/*  667 */           return false; }  continue;
/*      */       } 
/*      */       try {
/*  670 */         o1 = b(paramaa, object1);
/*  671 */       } catch (e e) {
/*      */         
/*  673 */         return false;
/*      */       } 
/*  675 */       if (bool) {
/*  676 */         if (!o1.a(paramaa, object1))
/*  677 */           return false;  continue;
/*      */       } 
/*  679 */       if (object == null || !object.equals(paramMap)) {
/*  680 */         return false;
/*      */       }
/*      */     } 
/*  683 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(Map<?, ?> paramMap) {
/*  688 */     return (paramMap.size() == 1);
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
/*      */   private void b(Map<?, ?> paramMap, h paramh, aa paramaa) {
/*  719 */     paramh.c(paramMap);
/*  720 */     a(paramMap, paramh, paramaa);
/*  721 */     paramh.j();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Map<?, ?> paramMap, h paramh, aa paramaa, i parami) {
/*  730 */     paramh.a(paramMap);
/*  731 */     a a1 = parami.a(paramh, parami
/*  732 */         .a(paramMap, o.b));
/*  733 */     a(paramMap, paramh, paramaa);
/*  734 */     parami.b(paramh, a1);
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
/*      */   public final void a(Map<?, ?> paramMap, h paramh, aa paramaa) {
/*  752 */     if (!paramMap.isEmpty()) {
/*  753 */       if (this.r || paramaa.a(z.t)) {
/*  754 */         paramMap = d(paramMap, paramh, paramaa);
/*      */       }
/*      */       o o1;
/*  757 */       if (this.n != null && (o1 = a(paramaa, this.n, paramMap)) != null) {
/*  758 */         a(paramMap, paramh, paramaa, o1, this.o); return;
/*  759 */       }  if (this.o != null || this.p) {
/*  760 */         a(paramMap, paramh, paramaa, this.o); return;
/*  761 */       }  if (this.i != null) {
/*  762 */         a(paramMap, paramh, paramaa, this.i); return;
/*      */       } 
/*  764 */       c(paramMap, paramh, paramaa);
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
/*      */   private void c(Map<?, ?> paramMap, h paramh, aa paramaa) {
/*  778 */     if (this.j != null) {
/*  779 */       b(paramMap, paramh, paramaa, (Object)null);
/*      */       return;
/*      */     } 
/*  782 */     o<Object> o1 = this.g;
/*  783 */     Object object = null;
/*      */     
/*      */     try {
/*  786 */       for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*  787 */         Map.Entry<?, Object> entry; Object object1 = (entry = iterator.next()).getValue();
/*      */ 
/*      */         
/*  790 */         if ((object = entry.getKey()) == null) {
/*  791 */           paramaa.l().a(null, paramh, paramaa);
/*      */         
/*      */         }
/*  794 */         else if (this.q == null || !this.q.a(object)) {
/*      */ 
/*      */           
/*  797 */           o1.a(object, paramh, paramaa);
/*      */         } else {
/*      */           continue;
/*  800 */         }  if (object1 == null) {
/*  801 */           paramaa.a(paramh);
/*      */           continue;
/*      */         } 
/*      */         o<Object> o2;
/*  805 */         if ((o2 = this.i) == null) {
/*  806 */           o2 = b(paramaa, object1);
/*      */         }
/*  808 */         o2.a(object1, paramh, paramaa);
/*      */       }  return;
/*  810 */     } catch (Exception exception) {
/*  811 */       a(paramaa, exception, paramMap, String.valueOf(object));
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Map<?, ?> paramMap, h paramh, aa paramaa, Object paramObject) {
/*  823 */     if (this.j != null) {
/*  824 */       b(paramMap, paramh, paramaa, paramObject);
/*      */       return;
/*      */     } 
/*  827 */     boolean bool = (a == paramObject) ? true : false;
/*      */     
/*  829 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       o<Object> o1; o<Object> o2;
/*      */       Map.Entry<Object, ?> entry;
/*      */       Object object;
/*  833 */       if ((object = (entry = iterator.next()).getKey()) == null) {
/*  834 */         o1 = paramaa.l();
/*      */       }
/*  836 */       else if (this.q == null || !this.q.a(object)) {
/*      */ 
/*      */         
/*  839 */         o1 = this.g;
/*      */       } else {
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  845 */       if ((entry = (Map.Entry<Object, ?>)entry.getValue()) == null)
/*  846 */       { if (!this.p)
/*      */         
/*      */         { 
/*  849 */           o2 = paramaa.k(); }
/*      */         else { continue; }
/*      */          }
/*  852 */       else { if ((o2 = this.i) == null) {
/*  853 */           o2 = b(paramaa, entry);
/*      */         }
/*      */         
/*  856 */         if (bool ? 
/*  857 */           o2.a(paramaa, entry) : (
/*      */ 
/*      */           
/*  860 */           paramObject != null && 
/*  861 */           paramObject.equals(entry))) {
/*      */           continue;
/*      */         } }
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  868 */         o1.a(object, paramh, paramaa);
/*  869 */         o2.a(entry, paramh, paramaa);
/*  870 */       } catch (Exception exception) {
/*  871 */         a(paramaa, exception, paramMap, String.valueOf(object));
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
/*      */   private void a(Map<?, ?> paramMap, h paramh, aa paramaa, o<Object> paramo) {
/*  885 */     o<Object> o1 = this.g;
/*  886 */     i i1 = this.j;
/*      */     
/*  888 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*  889 */       Map.Entry<Object, ?> entry; Object object = (entry = iterator.next()).getKey();
/*  890 */       if (this.q == null || !this.q.a(object)) {
/*      */ 
/*      */ 
/*      */         
/*  894 */         if (object == null) {
/*  895 */           paramaa.l().a(null, paramh, paramaa);
/*      */         } else {
/*  897 */           o1.a(object, paramh, paramaa);
/*      */         } 
/*      */         
/*  900 */         if ((entry = (Map.Entry<Object, ?>)entry.getValue()) == null) {
/*  901 */           paramaa.a(paramh); continue;
/*      */         } 
/*      */         try {
/*  904 */           if (i1 == null) {
/*  905 */             paramo.a(entry, paramh, paramaa); continue;
/*      */           } 
/*  907 */           paramo.a(entry, paramh, paramaa, i1);
/*      */         }
/*  909 */         catch (Exception exception) {
/*  910 */           a(paramaa, exception, paramMap, String.valueOf(object));
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
/*      */   private void a(Map<?, ?> paramMap, h paramh, aa paramaa, o paramo, Object paramObject) {
/*  927 */     u u = new u(this.j, this.c);
/*  928 */     boolean bool = (a == paramObject) ? true : false;
/*      */     
/*  930 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       Map.Entry<Object, ?> entry;
/*  932 */       Object object = (entry = iterator.next()).getKey();
/*  933 */       if (this.q == null || !this.q.a(object)) {
/*      */         o<Object> o1, o2;
/*      */ 
/*      */ 
/*      */         
/*  938 */         if (object == null) {
/*  939 */           o1 = paramaa.l();
/*      */         } else {
/*  941 */           o1 = this.g;
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  948 */         if ((entry = (Map.Entry<Object, ?>)entry.getValue()) == null)
/*  949 */         { if (!this.p)
/*      */           
/*      */           { 
/*  952 */             o2 = paramaa.k(); }
/*      */           else { continue; }
/*      */            }
/*  955 */         else { if ((o2 = this.i) == null) {
/*  956 */             o2 = b(paramaa, entry);
/*      */           }
/*      */           
/*  959 */           if (bool ? 
/*  960 */             o2.a(paramaa, entry) : (
/*      */ 
/*      */             
/*  963 */             paramObject != null && 
/*  964 */             paramObject.equals(entry))) {
/*      */             continue;
/*      */           } }
/*      */ 
/*      */ 
/*      */         
/*  970 */         u.a(object, entry, o1, o2);
/*      */         try {
/*  972 */           paramo.a(paramMap, paramh, paramaa, u);
/*  973 */         } catch (Exception exception) {
/*  974 */           a(paramaa, exception, paramMap, String.valueOf(object));
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
/*      */   private void b(Map<?, ?> paramMap, h paramh, aa paramaa, Object paramObject) {
/*  986 */     boolean bool = (a == paramObject) ? true : false;
/*      */     
/*  988 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       o<Object> o1, o2; Map.Entry<Object, ?> entry;
/*      */       Object object;
/*  991 */       if ((object = (entry = iterator.next()).getKey()) == null) {
/*  992 */         o1 = paramaa.l();
/*      */       
/*      */       }
/*  995 */       else if (this.q == null || !this.q.a(object)) {
/*      */ 
/*      */         
/*  998 */         o1 = this.g;
/*      */       } else {
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/* 1004 */       if ((entry = (Map.Entry<Object, ?>)entry.getValue()) == null)
/* 1005 */       { if (!this.p)
/*      */         
/*      */         { 
/* 1008 */           o2 = paramaa.k(); }
/*      */         else { continue; }
/*      */          }
/* 1011 */       else { if ((o2 = this.i) == null) {
/* 1012 */           o2 = b(paramaa, entry);
/*      */         }
/*      */         
/* 1015 */         if (bool ? 
/* 1016 */           o2.a(paramaa, entry) : (
/*      */ 
/*      */           
/* 1019 */           paramObject != null && 
/* 1020 */           paramObject.equals(entry))) {
/*      */           continue;
/*      */         } }
/*      */ 
/*      */       
/* 1025 */       o1.a(object, paramh, paramaa);
/*      */       try {
/* 1027 */         o2.a(entry, paramh, paramaa, this.j);
/* 1028 */       } catch (Exception exception) {
/* 1029 */         a(paramaa, exception, paramMap, String.valueOf(object));
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
/*      */   public final void a(aa paramaa, h paramh, Object paramObject1, Map<?, ?> paramMap, o paramo, Object paramObject2) {
/* 1047 */     u u = new u(this.j, this.c);
/* 1048 */     boolean bool = (a == paramObject2) ? true : false;
/*      */     
/* 1050 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       Map.Entry<Object, ?> entry;
/* 1052 */       Object object = (entry = iterator.next()).getKey();
/* 1053 */       if (this.q == null || !this.q.a(object)) {
/*      */         o<Object> o1, o2;
/*      */ 
/*      */ 
/*      */         
/* 1058 */         if (object == null) {
/* 1059 */           o1 = paramaa.l();
/*      */         } else {
/* 1061 */           o1 = this.g;
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1068 */         if ((entry = (Map.Entry<Object, ?>)entry.getValue()) == null)
/* 1069 */         { if (!this.p)
/*      */           
/*      */           { 
/* 1072 */             o2 = paramaa.k(); }
/*      */           else { continue; }
/*      */            }
/* 1075 */         else { if ((o2 = this.i) == null) {
/* 1076 */             o2 = b(paramaa, entry);
/*      */           }
/*      */           
/* 1079 */           if (bool ? 
/* 1080 */             o2.a(paramaa, entry) : (
/*      */ 
/*      */             
/* 1083 */             paramObject2 != null && 
/* 1084 */             paramObject2.equals(entry))) {
/*      */             continue;
/*      */           } }
/*      */ 
/*      */ 
/*      */         
/* 1090 */         u.a(object, entry, o1, o2);
/*      */         try {
/* 1092 */           paramo.a(paramObject1, paramh, paramaa, u);
/* 1093 */         } catch (Exception exception) {
/* 1094 */           a(paramaa, exception, paramMap, String.valueOf(object));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/* 1139 */     k.d d = paramk.b(paramClass, paramaa, this.c);
/*      */     
/* 1141 */     if (paramk != d.b) {
/* 1142 */       this.k = d.b;
/*      */     }
/* 1144 */     return d.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o<Object> a(k paramk, j paramj, aa paramaa) {
/* 1151 */     k.d d = paramk.b(paramj, paramaa, this.c);
/* 1152 */     if (paramk != d.b) {
/* 1153 */       this.k = d.b;
/*      */     }
/* 1155 */     return d.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<?, ?> d(Map<?, ?> paramMap, h paramh, aa paramaa) {
/*      */     Iterator<Map.Entry> iterator;
/* 1163 */     if (paramMap instanceof java.util.SortedMap) {
/* 1164 */       return paramMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1170 */     if (b(paramMap)) {
/* 1171 */       TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 1172 */       for (iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */         Map.Entry<Object, ?> entry; Object object;
/* 1174 */         if ((object = (entry = iterator.next()).getKey()) == null) {
/* 1175 */           a(paramh, paramaa, entry.getValue());
/*      */           continue;
/*      */         } 
/* 1178 */         treeMap.put(object, entry.getValue());
/*      */       } 
/* 1180 */       return treeMap;
/*      */     } 
/* 1182 */     return new TreeMap<>((Map)iterator);
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
/*      */   private static boolean b(Map<?, ?> paramMap) {
/* 1198 */     return (paramMap instanceof java.util.HashMap && paramMap.containsKey(null));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(h paramh, aa paramaa, Object paramObject) {
/*      */     o<Object> o2;
/* 1205 */     o o1 = paramaa.l();
/*      */     
/* 1207 */     if (paramObject == null) {
/* 1208 */       if (this.p) {
/*      */         return;
/*      */       }
/* 1211 */       o2 = paramaa.k();
/*      */     } else {
/*      */       
/* 1214 */       if ((o2 = this.i) == null) {
/* 1215 */         o2 = b(paramaa, paramObject);
/*      */       }
/* 1217 */       if (this.o == a) {
/* 1218 */         if (o2.a(paramaa, paramObject)) {
/*      */           return;
/*      */         }
/* 1221 */       } else if (this.o != null && this.o
/* 1222 */         .equals(paramObject)) {
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     
/*      */     try {
/* 1228 */       o1.a(null, paramh, paramaa);
/* 1229 */       o2.a(paramObject, paramh, paramaa); return;
/* 1230 */     } catch (Exception exception) {
/* 1231 */       a(paramaa, exception, paramObject, "");
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final o<Object> b(aa paramaa, Object<?> paramObject) {
/* 1239 */     paramObject = (Object<?>)paramObject.getClass();
/*      */     o<Object> o1;
/* 1241 */     if ((o1 = this.k.a((Class)paramObject)) != null) {
/* 1242 */       return o1;
/*      */     }
/* 1244 */     if (this.f.s()) {
/* 1245 */       return a(this.k, paramaa
/* 1246 */           .a(this.f, (Class)paramObject), paramaa);
/*      */     }
/* 1248 */     return a(this.k, (Class<?>)paramObject, paramaa);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */