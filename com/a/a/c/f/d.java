/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.n;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   extends b
/*     */   implements an
/*     */ {
/*  20 */   private static final a a = new a(null, 
/*  21 */       Collections.emptyList(), 
/*  22 */       Collections.emptyList());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<j> e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.c.a f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private t.a h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private m m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<h> n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Boolean o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   d(j paramj, Class<?> paramClass1, List<j> paramList, Class<?> paramClass2, b paramb, n paramn, com.a.a.c.a parama, t.a parama1, o paramo, boolean paramBoolean) {
/* 143 */     this.b = paramj;
/* 144 */     this.c = paramClass1;
/* 145 */     this.e = paramList;
/* 146 */     this.i = paramClass2;
/* 147 */     this.k = paramb;
/* 148 */     this.d = paramn;
/* 149 */     this.f = parama;
/* 150 */     this.h = parama1;
/* 151 */     this.g = paramo;
/* 152 */     this.j = paramBoolean;
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
/*     */   d(Class<?> paramClass) {
/* 171 */     this.b = null;
/* 172 */     this.c = paramClass;
/* 173 */     this.e = Collections.emptyList();
/* 174 */     this.i = null;
/* 175 */     this.k = p.a();
/* 176 */     this.d = n.a();
/* 177 */     this.f = null;
/* 178 */     this.h = null;
/* 179 */     this.g = null;
/* 180 */     this.j = false;
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
/*     */   public final j a(Type paramType) {
/* 234 */     return this.g.a(paramType, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> e() {
/* 244 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 250 */     return this.c.getName();
/*     */   }
/*     */   
/*     */   public final <A extends Annotation> A a(Class<A> paramClass) {
/* 254 */     return (A)this.k.a(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean b(Class<?> paramClass) {
/* 259 */     return this.k.b(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(Class<? extends Annotation>[] paramArrayOfClass) {
/* 264 */     return this.k.a((Class[])paramArrayOfClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class<?> d() {
/* 269 */     return this.c;
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
/*     */   public final j c() {
/* 286 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b f() {
/* 296 */     return this.k;
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 300 */     return (this.k.a() > 0);
/*     */   }
/*     */   
/*     */   public final f h() {
/* 304 */     return (p()).a;
/*     */   }
/*     */   
/*     */   public final List<f> i() {
/* 308 */     return (p()).b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<k> j() {
/* 315 */     return (p()).c;
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
/*     */   public final Iterable<k> k() {
/* 327 */     return o();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(String paramString, Class<?>[] paramArrayOfClass) {
/* 335 */     return o().a(paramString, paramArrayOfClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterable<h> l() {
/* 343 */     return n();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean m() {
/*     */     Boolean bool;
/* 352 */     if ((bool = this.o) == null) {
/* 353 */       this.o = bool = Boolean.valueOf(i.n(this.c));
/*     */     }
/* 355 */     return bool.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<h> n() {
/*     */     List<h> list;
/* 366 */     if ((list = this.n) == null) {
/*     */       
/* 368 */       if (this.b == null) {
/* 369 */         list = Collections.emptyList();
/*     */       } else {
/* 371 */         list = i.a(this.f, this, this.h, this.g, this.b, this.j);
/*     */       } 
/*     */       
/* 374 */       this.n = list;
/*     */     } 
/* 376 */     return list;
/*     */   }
/*     */   
/*     */   private final m o() {
/*     */     m m1;
/* 381 */     if ((m1 = this.m) == null) {
/*     */ 
/*     */       
/* 384 */       if (this.b == null) {
/* 385 */         m1 = new m();
/*     */       } else {
/* 387 */         m1 = l.a(this.f, this, this.h, this.g, this.b, this.e, this.i, this.j);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 392 */       this.m = m1;
/*     */     } 
/* 394 */     return m1;
/*     */   }
/*     */   
/*     */   private final a p() {
/*     */     a a1;
/* 399 */     if ((a1 = this.l) == null) {
/* 400 */       if (this.b == null) {
/* 401 */         a1 = a;
/*     */       } else {
/* 403 */         a1 = g.a(this.f, this.g, this, this.b, this.i, this.j);
/*     */       } 
/*     */ 
/*     */       
/* 407 */       this.l = a1;
/*     */     } 
/* 409 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 420 */     return "[AnnotedClass " + this.c.getName() + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 425 */     return this.c.getName().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 430 */     if (paramObject == this) return true; 
/* 431 */     if (!i.a(paramObject, getClass())) {
/* 432 */       return false;
/*     */     }
/* 434 */     return (((d)paramObject).c == this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     public final f a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final List<f> b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final List<k> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(f param1f, List<f> param1List, List<k> param1List1) {
/* 465 */       this.a = param1f;
/* 466 */       this.b = param1List;
/* 467 */       this.c = param1List1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */