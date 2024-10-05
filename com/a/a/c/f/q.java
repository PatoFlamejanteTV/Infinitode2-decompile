/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.a.i;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.e;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.w;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */   extends b
/*     */ {
/*  31 */   private static final Class<?>[] a = new Class[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ae b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.c.b.q<?> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?>[] f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<s> h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ad i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q(ae paramae, j paramj, d paramd) {
/*  96 */     super(paramj);
/*  97 */     this.b = paramae;
/*  98 */     this.c = paramae.a();
/*     */     
/* 100 */     if (this.c == null) {
/* 101 */       this.d = null;
/*     */     } else {
/* 103 */       this.d = this.c.j();
/*     */     } 
/* 105 */     this.e = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q(com.a.a.c.b.q<?> paramq, j paramj, d paramd, List<s> paramList) {
/* 115 */     super(paramj);
/* 116 */     this.b = null;
/* 117 */     this.c = paramq;
/*     */     
/* 119 */     if (this.c == null) {
/* 120 */       this.d = null;
/*     */     } else {
/* 122 */       this.d = this.c.j();
/*     */     } 
/* 124 */     this.e = paramd;
/* 125 */     this.h = paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   private q(ae paramae) {
/* 130 */     this(paramae, paramae.b(), paramae.c());
/* 131 */     this.i = paramae.m();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static q a(ae paramae) {
/* 139 */     return new q(paramae);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static q b(ae paramae) {
/* 147 */     return new q(paramae);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static q a(com.a.a.c.b.q<?> paramq, j paramj, d paramd) {
/* 158 */     return new q(paramq, paramj, paramd, 
/* 159 */         Collections.emptyList());
/*     */   }
/*     */   
/*     */   private List<s> z() {
/* 163 */     if (this.h == null) {
/* 164 */       this.h = this.b.d();
/*     */     }
/* 166 */     return this.h;
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
/*     */   public final boolean a(String paramString) {
/* 184 */     Iterator<s> iterator = z().iterator();
/* 185 */     while (iterator.hasNext()) {
/*     */       s s;
/* 187 */       if ((s = iterator.next()).a().equals(paramString)) {
/* 188 */         iterator.remove();
/* 189 */         return true;
/*     */       } 
/*     */     } 
/* 192 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(s params) {
/* 198 */     if (a(params.b())) {
/* 199 */       return false;
/*     */     }
/* 201 */     z().add(params);
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(w paramw) {
/* 209 */     return (b(paramw) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private s b(w paramw) {
/* 217 */     for (Iterator<s> iterator = z().iterator(); iterator.hasNext();) {
/* 218 */       if ((s = iterator.next()).a(paramw)) {
/* 219 */         return s;
/*     */       }
/*     */     } 
/* 222 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d d() {
/* 232 */     return this.e;
/*     */   }
/*     */   public final ad e() {
/* 235 */     return this.i;
/*     */   }
/*     */   
/*     */   public final List<s> h() {
/* 239 */     return z();
/*     */   }
/*     */ 
/*     */   
/*     */   public final j p() {
/* 244 */     return (this.b == null) ? null : this.b
/* 245 */       .f();
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
/*     */   public final j q() {
/* 257 */     return (this.b == null) ? null : this.b
/* 258 */       .g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Set<String> i() {
/*     */     Set<String> set;
/* 265 */     if ((set = (Set<String>)((this.b == null) ? null : this.b.l())) == null) {
/* 266 */       return Collections.emptySet();
/*     */     }
/* 268 */     return set;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean f() {
/* 273 */     return this.e.g();
/*     */   }
/*     */ 
/*     */   
/*     */   public final b g() {
/* 278 */     return this.e.f();
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
/*     */   public final f o() {
/* 297 */     return this.e.h();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j s() {
/* 303 */     if (this.b != null) {
/*     */       k k;
/* 305 */       if ((k = this.b.k()) != null) {
/*     */         Class<?> clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 313 */         if ((clazz = k.a(0)) != String.class && clazz != Object.class) {
/* 314 */           throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", new Object[] { k
/*     */                   
/* 316 */                   .b(), clazz.getName() }));
/*     */         }
/* 318 */         return k;
/*     */       } 
/*     */       j j;
/* 321 */       if ((j = this.b.j()) != null) {
/*     */ 
/*     */         
/* 324 */         Class<?> clazz = j.d();
/* 325 */         if (!Map.class.isAssignableFrom(clazz) && 
/* 326 */           !m.class.isAssignableFrom(clazz)) {
/* 327 */           throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of `java.util.Map` or `JsonNode`", new Object[] { j
/*     */                   
/* 329 */                   .b() }));
/*     */         }
/* 331 */         return j;
/*     */       } 
/*     */     } 
/* 334 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Map<Object, j> v() {
/* 339 */     if (this.b != null) {
/* 340 */       return this.b.e();
/*     */     }
/* 342 */     return Collections.emptyMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<f> k() {
/* 347 */     return this.e.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<c<f, i.a>> l() {
/*     */     List<f> list;
/* 353 */     if ((list = this.e.i()).isEmpty()) {
/* 354 */       return Collections.emptyList();
/*     */     }
/* 356 */     ArrayList<c<f, i.a>> arrayList = new ArrayList();
/* 357 */     for (f f : list) {
/*     */       i.a a1;
/* 359 */       if ((a1 = this.d.a(this.c, f)) != i.a.d)
/*     */       {
/*     */         
/* 362 */         arrayList.add(c.a(f, a1)); } 
/*     */     } 
/* 364 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(boolean paramBoolean) {
/*     */     f f;
/* 370 */     if ((f = this.e.h()) == null) {
/* 371 */       return null;
/*     */     }
/* 373 */     if (paramBoolean) {
/* 374 */       f.a(this.c.a(com.a.a.c.q.o));
/*     */     }
/*     */     try {
/* 377 */       return f.g();
/* 378 */     } catch (Exception exception) {
/* 379 */       Throwable throwable = null, throwable = throwable;
/* 380 */       while (throwable.getCause() != null) {
/* 381 */         throwable = throwable.getCause();
/*     */       }
/* 383 */       i.a(throwable);
/* 384 */       i.b(throwable);
/* 385 */       throw new IllegalArgumentException("Failed to instantiate bean of type " + this.e
/* 386 */           .e().getName() + ": (" + throwable.getClass().getName() + ") " + 
/* 387 */           i.g(throwable), throwable);
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
/*     */   public final k a(String paramString, Class<?>[] paramArrayOfClass) {
/* 399 */     return this.e.a(paramString, paramArrayOfClass);
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
/*     */   public final l.d a(l.d paramd) {
/*     */     l.d d1;
/* 413 */     if (this.d != null && (
/*     */       
/* 415 */       d1 = this.d.h(this.e)) != null) {
/* 416 */       if (paramd == null) {
/* 417 */         paramd = d1;
/*     */       } else {
/* 419 */         paramd = paramd.a(d1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 424 */     if ((d1 = this.c.f(this.e.d())) != null) {
/* 425 */       if (paramd == null) {
/* 426 */         paramd = d1;
/*     */       } else {
/* 428 */         paramd = paramd.a(d1);
/*     */       } 
/*     */     }
/* 431 */     return paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?>[] y() {
/* 437 */     if (!this.g) {
/* 438 */       this.g = true;
/*     */       
/*     */       Class[] arrayOfClass;
/*     */       
/* 442 */       if ((arrayOfClass = (Class[])((this.d == null) ? null : this.d.g(this.e))) == null && 
/* 443 */         !this.c.a(com.a.a.c.q.s)) {
/* 444 */         arrayOfClass = a;
/*     */       }
/*     */       
/* 447 */       this.f = arrayOfClass;
/*     */     } 
/* 449 */     return this.f;
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
/*     */   public final k<Object, Object> t() {
/* 461 */     if (this.d == null) {
/* 462 */       return null;
/*     */     }
/* 464 */     return a(this.d.s(this.e));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b a(s.b paramb) {
/*     */     s.b b1;
/* 475 */     if (this.d != null && (
/*     */       
/* 477 */       b1 = this.d.t(this.e)) != null) {
/* 478 */       return (paramb == null) ? b1 : paramb.a(b1);
/*     */     }
/*     */     
/* 481 */     return paramb;
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
/*     */   public final j r() {
/* 493 */     if (this.b != null) {
/*     */       j j1;
/* 495 */       if ((j1 = this.b.i()) != null) {
/*     */ 
/*     */         
/* 498 */         Class<?> clazz = j1.d();
/* 499 */         if (!Map.class.isAssignableFrom(clazz)) {
/* 500 */           throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", new Object[] { j1
/*     */                   
/* 502 */                   .b() }));
/*     */         }
/* 504 */         return j1;
/*     */       } 
/*     */       
/*     */       j j2;
/* 508 */       if ((j2 = this.b.h()) != null) {
/*     */ 
/*     */         
/* 511 */         Class<?> clazz = j2.d();
/* 512 */         if (!Map.class.isAssignableFrom(clazz)) {
/* 513 */           throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", new Object[] { j2
/*     */                   
/* 515 */                   .b() }));
/*     */         }
/* 517 */         return j2;
/*     */       } 
/*     */     } 
/* 520 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<s> j() {
/* 526 */     ArrayList<s> arrayList = null;
/* 527 */     HashSet<String> hashSet = null;
/* 528 */     for (Iterator<s> iterator = z().iterator(); iterator.hasNext();) {
/*     */       
/* 530 */       if ((a1 = (s = iterator.next()).x()) != null && a1.c()) {
/*     */ 
/*     */         
/* 533 */         String str = a1.a();
/* 534 */         if (arrayList == null) {
/* 535 */           arrayList = new ArrayList();
/*     */           
/* 537 */           (hashSet = new HashSet<>()).add(str);
/*     */         }
/* 539 */         else if (!hashSet.add(str)) {
/* 540 */           throw new IllegalArgumentException("Multiple back-reference properties with name " + i.b(str));
/*     */         } 
/*     */         
/* 543 */         arrayList.add(s);
/*     */       } 
/* 545 */     }  return arrayList;
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
/*     */   public final List<k> m() {
/*     */     List<k> list;
/* 574 */     if ((list = this.e.j()).isEmpty()) {
/* 575 */       return list;
/*     */     }
/* 577 */     ArrayList<k> arrayList = null;
/* 578 */     for (k k : list) {
/* 579 */       if (a(k)) {
/* 580 */         if (arrayList == null) {
/* 581 */           arrayList = new ArrayList();
/*     */         }
/* 583 */         arrayList.add(k);
/*     */       } 
/*     */     } 
/* 586 */     if (arrayList == null) {
/* 587 */       return Collections.emptyList();
/*     */     }
/* 589 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<c<k, i.a>> n() {
/*     */     List<k> list;
/* 596 */     if ((list = this.e.j()).isEmpty()) {
/* 597 */       return Collections.emptyList();
/*     */     }
/* 599 */     ArrayList<c<k, i.a>> arrayList = null;
/* 600 */     for (k k : list) {
/*     */       c<k, i.a> c;
/*     */       
/* 603 */       if ((c = b(k)) != null) {
/* 604 */         if (arrayList == null) {
/* 605 */           arrayList = new ArrayList();
/*     */         }
/* 607 */         arrayList.add(c);
/*     */       } 
/*     */     } 
/* 610 */     if (arrayList == null) {
/* 611 */       return Collections.emptyList();
/*     */     }
/* 613 */     return arrayList;
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
/*     */   private boolean a(k paramk) {
/* 659 */     Class<?> clazz2 = paramk.m();
/* 660 */     if (!b().isAssignableFrom(clazz2)) {
/* 661 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     i.a a1;
/*     */ 
/*     */     
/* 669 */     if ((a1 = this.d.a(this.c, paramk)) != null && a1 != i.a.d) {
/* 670 */       return true;
/*     */     }
/* 672 */     String str = paramk.b();
/*     */     
/* 674 */     if ("valueOf".equals(str) && 
/* 675 */       paramk.f() == 1) {
/* 676 */       return true;
/*     */     }
/*     */     
/*     */     Class<?> clazz1;
/* 680 */     if ("fromString".equals(str) && 
/* 681 */       paramk.f() == 1 && ((
/*     */       
/* 683 */       clazz1 = paramk.a(0)) == String.class || CharSequence.class.isAssignableFrom(clazz1))) {
/* 684 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 688 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c<k, i.a> b(k paramk) {
/* 696 */     Class<?> clazz1 = paramk.m();
/* 697 */     if (!b().isAssignableFrom(clazz1)) {
/* 698 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     i.a a1;
/*     */ 
/*     */     
/* 705 */     if ((a1 = this.d.a(this.c, paramk)) != null) {
/* 706 */       if (a1 == i.a.d) {
/* 707 */         return null;
/*     */       }
/* 709 */       return c.a(paramk, a1);
/*     */     } 
/* 711 */     String str = paramk.b();
/*     */     
/* 713 */     if ("valueOf".equals(str) && 
/* 714 */       paramk.f() == 1) {
/* 715 */       return c.a(paramk, a1);
/*     */     }
/*     */     
/*     */     Class<?> clazz2;
/* 719 */     if ("fromString".equals(str) && 
/* 720 */       paramk.f() == 1 && ((
/*     */       
/* 722 */       clazz2 = paramk.a(0)) == String.class || CharSequence.class.isAssignableFrom(clazz2))) {
/* 723 */       return c.a(paramk, a1);
/*     */     }
/*     */ 
/*     */     
/* 727 */     return null;
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
/*     */   public final Class<?> w() {
/* 754 */     return (this.d == null) ? null : this.d
/* 755 */       .g(this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final e.a x() {
/* 761 */     return (this.d == null) ? null : this.d
/* 762 */       .h(this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object, Object> u() {
/* 768 */     if (this.d == null) {
/* 769 */       return null;
/*     */     }
/* 771 */     return a(this.d.C(this.e));
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
/*     */   private k<Object, Object> a(Object paramObject) {
/* 827 */     if (paramObject == null) {
/* 828 */       return null;
/*     */     }
/* 830 */     if (paramObject instanceof k) {
/* 831 */       return (k<Object, Object>)paramObject;
/*     */     }
/* 833 */     if (!(paramObject instanceof Class)) {
/* 834 */       throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + paramObject
/* 835 */           .getClass().getName() + "; expected type Converter or Class<Converter> instead");
/*     */     }
/*     */ 
/*     */     
/* 839 */     if ((paramObject = paramObject) == k.a.class || i.e((Class)paramObject)) {
/* 840 */       return null;
/*     */     }
/* 842 */     if (!k.class.isAssignableFrom((Class<?>)paramObject)) {
/* 843 */       throw new IllegalStateException("AnnotationIntrospector returned Class " + paramObject
/* 844 */           .getName() + "; expected Class<Converter>");
/*     */     }
/*     */     d d1;
/*     */     k<Object, Object> k;
/* 848 */     if ((k = (k<Object, Object>)(((d1 = this.c.m()) == null) ? null : d.m())) == null) {
/* 849 */       k = (k)i.b((Class)paramObject, this.c
/* 850 */           .g());
/*     */     }
/* 852 */     return k;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */