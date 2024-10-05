/*      */ package com.a.a.c;
/*      */ 
/*      */ import com.a.a.a.al;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.a.s;
/*      */ import com.a.a.b.h;
/*      */ import com.a.a.c.b.j;
/*      */ import com.a.a.c.b.k;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.d.b;
/*      */ import com.a.a.c.d.e;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.s;
/*      */ import com.a.a.c.g.a;
/*      */ import com.a.a.c.i.i;
/*      */ import com.a.a.c.k.a.c;
/*      */ import com.a.a.c.k.a.d;
/*      */ import com.a.a.c.k.a.l;
/*      */ import com.a.a.c.k.a.q;
/*      */ import com.a.a.c.k.a.r;
/*      */ import com.a.a.c.k.a.v;
/*      */ import com.a.a.c.k.b.x;
/*      */ import com.a.a.c.k.k;
/*      */ import com.a.a.c.k.q;
/*      */ import com.a.a.c.k.r;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.i;
/*      */ import java.text.DateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class aa
/*      */   extends d
/*      */ {
/*   60 */   private static o<Object> b = (o<Object>)new c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   72 */   private static o<Object> c = (o<Object>)new r();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final y a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Class<?> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private r e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient j g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  134 */   private o<Object> h = c;
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
/*  147 */   private o<Object> j = (o<Object>)x.a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  156 */   private o<Object> k = b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DateFormat m;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public aa() {
/*  197 */     this.a = null;
/*  198 */     this.e = null;
/*  199 */     this.f = new a();
/*      */     
/*  201 */     this.l = null;
/*      */     
/*  203 */     this.d = null;
/*  204 */     this.g = null;
/*      */ 
/*      */     
/*  207 */     this.n = true;
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
/*      */   protected aa(aa paramaa, y paramy, r paramr) {
/*  219 */     this.e = paramr;
/*  220 */     this.a = paramy;
/*      */     
/*  222 */     this.f = paramaa.f;
/*  223 */     this.h = paramaa.h;
/*  224 */     this.i = paramaa.i;
/*  225 */     this.j = paramaa.j;
/*  226 */     this.k = paramaa.k;
/*      */     
/*  228 */     this.n = (this.j == b);
/*      */     
/*  230 */     this.d = paramy.y();
/*  231 */     this.g = paramy.z();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  236 */     this.l = this.f.a();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final y c() {
/*  326 */     return this.a;
/*      */   }
/*      */   
/*      */   public final a d() {
/*  330 */     return this.a.j();
/*      */   }
/*      */ 
/*      */   
/*      */   public final o b() {
/*  335 */     return this.a.p();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j a(j paramj, Class<?> paramClass) {
/*  342 */     if (paramj.a(paramClass)) {
/*  343 */       return paramj;
/*      */     }
/*      */ 
/*      */     
/*  347 */     return c().p().a(paramj, paramClass, true);
/*      */   }
/*      */   
/*      */   public final Class<?> e() {
/*  351 */     return this.d;
/*      */   }
/*      */   
/*      */   public final boolean f() {
/*  355 */     return this.a.g();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(q paramq) {
/*  360 */     return this.a.a(paramq);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(k paramk) {
/*  365 */     return this.a.a(paramk);
/*      */   }
/*      */ 
/*      */   
/*      */   public final l.d a(Class<?> paramClass) {
/*  370 */     return this.a.f(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final s.b b(Class<?> paramClass) {
/*  377 */     return this.a.e(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Locale g() {
/*  388 */     return this.a.t();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final TimeZone h() {
/*  399 */     return this.a.u();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Object paramObject) {
/*  410 */     return this.g.a(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final aa a(Object paramObject1, Object paramObject2) {
/*  416 */     this.g = this.g.a(paramObject1, paramObject2);
/*  417 */     return this;
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
/*      */   public final boolean a(z paramz) {
/*  435 */     return this.a.a(paramz);
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
/*      */   public final d i() {
/*  456 */     return this.a.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h j() {
/*  467 */     return null;
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
/*      */   public final o<Object> a(Class<?> paramClass, c paramc) {
/*      */     o<Object> o1;
/*  542 */     if ((o1 = this.l.b(paramClass)) == null)
/*      */     {
/*      */       
/*  545 */       if ((o1 = this.f.b(paramClass)) == null)
/*      */       {
/*      */         
/*  548 */         if ((o1 = this.f.a(this.a.b(paramClass))) == null)
/*      */         {
/*      */ 
/*      */           
/*  552 */           if ((o1 = e(paramClass)) == null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  558 */             return o1 = d(paramClass);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  564 */     return (o)b(o1, paramc);
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
/*      */   public final o<Object> a(j paramj, c paramc) {
/*  583 */     if (paramj == null) {
/*  584 */       b("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
/*      */     }
/*      */     
/*      */     o<Object> o1;
/*  588 */     if ((o1 = this.l.b(paramj)) == null && (
/*      */       
/*  590 */       o1 = this.f.a(paramj)) == null && (
/*      */       
/*  592 */       o1 = b(paramj)) == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  597 */       return o1 = d(paramj.b());
/*      */     }
/*      */ 
/*      */     
/*  601 */     return (o)b(o1, paramc);
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
/*      */   public final o<Object> c(Class<?> paramClass) {
/*      */     o<Object> o1;
/*  615 */     if ((o1 = this.l.b(paramClass)) == null && (
/*      */       
/*  617 */       o1 = this.f.b(paramClass)) == null && (
/*      */       
/*  619 */       o1 = this.f.a(this.a.b(paramClass))) == null && (
/*      */       
/*  621 */       o1 = e(paramClass)) == null) {
/*  622 */       o1 = d(paramClass);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  630 */     return o1;
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
/*      */   public final o<Object> a(j paramj) {
/*      */     o<Object> o1;
/*  645 */     if ((o1 = this.l.b(paramj)) == null && (
/*      */       
/*  647 */       o1 = this.f.a(paramj)) == null && (
/*      */       
/*  649 */       o1 = b(paramj)) == null) {
/*  650 */       o1 = d(paramj.b());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  657 */     return o1;
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
/*      */   public final o<Object> b(j paramj, c paramc) {
/*      */     o<Object> o1;
/*  678 */     if ((o1 = this.l.b(paramj)) == null && (
/*      */       
/*  680 */       o1 = this.f.a(paramj)) == null && (
/*      */       
/*  682 */       o1 = b(paramj)) == null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  688 */       return o1 = d(paramj.b());
/*      */     }
/*      */ 
/*      */     
/*  692 */     return (o)a(o1, paramc);
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
/*      */   public final o<Object> b(Class<?> paramClass, c paramc) {
/*      */     o<Object> o1;
/*  706 */     if ((o1 = this.l.b(paramClass)) == null && (
/*      */       
/*  708 */       o1 = this.f.b(paramClass)) == null && (
/*      */       
/*  710 */       o1 = this.f.a(this.a.b(paramClass))) == null && (
/*      */       
/*  712 */       o1 = e(paramClass)) == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  717 */       return o1 = d(paramClass);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  722 */     return (o)a(o1, paramc);
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
/*      */   public final o<Object> c(j paramj, c paramc) {
/*      */     o<Object> o1;
/*  750 */     if ((o1 = this.l.b(paramj)) == null && (
/*      */       
/*  752 */       o1 = this.f.a(paramj)) == null && (
/*      */       
/*  754 */       o1 = b(paramj)) == null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  760 */       return o1 = d(paramj.b());
/*      */     }
/*      */ 
/*      */     
/*  764 */     return (o)b(o1, paramc);
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
/*      */   public final o<Object> c(Class<?> paramClass, c paramc) {
/*      */     o<Object> o1;
/*  778 */     if ((o1 = this.l.b(paramClass)) == null && (
/*      */       
/*  780 */       o1 = this.f.b(paramClass)) == null && (
/*      */       
/*  782 */       o1 = this.f.a(this.a.b(paramClass))) == null && (
/*      */       
/*  784 */       o1 = e(paramClass)) == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  789 */       return o1 = d(paramClass);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  794 */     return (o)b(o1, paramc);
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
/*      */   public final o<Object> a(Class<?> paramClass, boolean paramBoolean, c paramc) {
/*      */     q q;
/*      */     o<Object> o1;
/*  818 */     if ((o1 = this.l.a(paramClass)) != null) {
/*  819 */       return o1;
/*      */     }
/*      */ 
/*      */     
/*  823 */     if ((o1 = this.f.c(paramClass)) != null) {
/*  824 */       return o1;
/*      */     }
/*      */ 
/*      */     
/*  828 */     o1 = a(paramClass, paramc);
/*      */     
/*      */     i i;
/*  831 */     if ((i = this.e.a(this.a, this.a.b(paramClass))) != null) {
/*  832 */       i = i.a(paramc);
/*  833 */       q = new q(i, o1);
/*      */     } 
/*      */     
/*  836 */     this.f.a(paramClass, (o)q);
/*      */     
/*  838 */     return (o<Object>)q;
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
/*      */   public final o<Object> a(j paramj, boolean paramBoolean, c paramc) {
/*      */     q q;
/*      */     o<Object> o1;
/*  863 */     if ((o1 = this.l.a(paramj)) != null) {
/*  864 */       return o1;
/*      */     }
/*      */ 
/*      */     
/*  868 */     if ((o1 = this.f.b(paramj)) != null) {
/*  869 */       return o1;
/*      */     }
/*      */ 
/*      */     
/*  873 */     o1 = a(paramj, paramc);
/*      */     i i;
/*  875 */     if ((i = this.e.a(this.a, paramj)) != null) {
/*  876 */       i = i.a(paramc);
/*  877 */       q = new q(i, o1);
/*      */     } 
/*      */     
/*  880 */     this.f.a(paramj, (o)q);
/*      */     
/*  882 */     return (o<Object>)q;
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
/*      */   public final o<Object> d(j paramj, c paramc) {
/*  909 */     o<?> o1 = this.e.a(this, paramj, this.i);
/*      */     
/*  911 */     return c(o1, paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final o<Object> d(Class<?> paramClass, c paramc) {
/*  920 */     return d(this.a.b(paramClass), paramc);
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
/*      */   public final o<Object> k() {
/*  940 */     return this.j;
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
/*      */   public final o<Object> l() {
/*  964 */     return this.k;
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
/*      */   public final o<Object> m() {
/*  980 */     return this.j;
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
/*      */   public final o<Object> d(Class<?> paramClass) {
/*  997 */     if (paramClass == Object.class) {
/*  998 */       return this.h;
/*      */     }
/*      */     
/* 1001 */     return (o<Object>)new r(paramClass);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final o<?> a(o<?> paramo, c paramc) {
/* 1089 */     if (paramo != null && 
/* 1090 */       paramo instanceof k) {
/* 1091 */       paramo = ((k)paramo).a(this, paramc);
/*      */     }
/*      */     
/* 1094 */     return paramo;
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
/*      */   public final o<?> b(o<?> paramo, c paramc) {
/* 1117 */     if (paramo != null && 
/* 1118 */       paramo instanceof k) {
/* 1119 */       paramo = ((k)paramo).a(this, paramc);
/*      */     }
/*      */     
/* 1122 */     return paramo;
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
/*      */   public final void a(Object paramObject, h paramh) {
/* 1140 */     if (paramObject == null) {
/* 1141 */       if (this.n) {
/* 1142 */         paramh.k(); return;
/*      */       } 
/* 1144 */       this.j.a(null, paramh, this);
/*      */       return;
/*      */     } 
/* 1147 */     Class<?> clazz = paramObject.getClass();
/* 1148 */     a(clazz, true, (c)null).a(paramObject, paramh, this);
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
/*      */   public final void a(Date paramDate, h paramh) {
/* 1202 */     if (a(z.j)) {
/* 1203 */       paramh.b(paramDate.getTime()); return;
/*      */     } 
/* 1205 */     paramh.b(n().format(paramDate));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(long paramLong, h paramh) {
/* 1216 */     if (a(z.k)) {
/* 1217 */       paramh.a(String.valueOf(paramLong)); return;
/*      */     } 
/* 1219 */     paramh.a(n().format(new Date(paramLong)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(Date paramDate, h paramh) {
/* 1230 */     if (a(z.k)) {
/* 1231 */       paramh.a(String.valueOf(paramDate.getTime())); return;
/*      */     } 
/* 1233 */     paramh.a(n().format(paramDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(h paramh) {
/* 1239 */     if (this.n) {
/* 1240 */       paramh.k(); return;
/*      */     } 
/* 1242 */     this.j.a(null, paramh, this);
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
/*      */   public final void b(String paramString, Object... paramVarArgs) {
/* 1260 */     throw c(paramString, paramVarArgs);
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
/*      */   public final <T> T a(b paramb, String paramString, Object... paramVarArgs) {
/* 1272 */     String str = "N/A";
/* 1273 */     if (paramb != null) {
/* 1274 */       str = i.g(paramb.b());
/*      */     }
/* 1276 */     paramString = String.format("Invalid type definition for type %s: %s", new Object[] { str, 
/* 1277 */           a(paramString, paramVarArgs) });
/* 1278 */     throw b.a(j(), paramString, paramb, null);
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
/*      */   public final <T> T a(b paramb, s params, String paramString, Object... paramVarArgs) {
/* 1290 */     paramString = a(paramString, paramVarArgs);
/* 1291 */     String str1 = "N/A";
/* 1292 */     if (params != null) {
/* 1293 */       str1 = a(params.a());
/*      */     }
/* 1295 */     String str2 = "N/A";
/* 1296 */     if (paramb != null) {
/* 1297 */       str2 = i.g(paramb.b());
/*      */     }
/* 1299 */     paramString = String.format("Invalid definition for property %s (of type %s): %s", new Object[] { str1, str2, paramString });
/*      */     
/* 1301 */     throw b.a(j(), paramString, paramb, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public final <T> T a(j paramj, String paramString) {
/* 1306 */     throw b.a(j(), paramString, paramj);
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
/*      */   public final <T> T a(Class<?> paramClass, String paramString, Throwable paramThrowable) {
/* 1323 */     throw b.a(j(), paramString, a(paramClass))
/* 1324 */       .a(paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 1335 */     paramString = a(paramString, paramVarArgs);
/* 1336 */     throw l.a(j(), paramString, paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final l a(j paramj, String paramString1, String paramString2) {
/* 1342 */     String str = String.format("Could not resolve type id '%s' as a subtype of %s", new Object[] { paramString1, 
/* 1343 */           i.b(paramj) });
/* 1344 */     return (l)e.a(null, a(str, paramString2), paramj, paramString1);
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
/*      */   @Deprecated
/*      */   private l c(String paramString, Object... paramVarArgs) {
/* 1364 */     return l.a(j(), a(paramString, paramVarArgs));
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
/*      */   protected final void a(Object paramObject, j paramj) {
/*      */     Class<?> clazz;
/* 1390 */     if (paramj.l() && (
/*      */ 
/*      */       
/* 1393 */       clazz = i.i(paramj.b())).isAssignableFrom(paramObject.getClass())) {
/*      */       return;
/*      */     }
/*      */     
/* 1397 */     a(paramj, String.format("Incompatible types: declared root type (%s) vs %s", new Object[] { paramj, 
/*      */             
/* 1399 */             i.d(paramObject) }));
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
/*      */   private o<Object> e(Class<?> paramClass) {
/* 1446 */     j j1 = this.a.b(paramClass);
/*      */     
/*      */     try {
/* 1449 */       o<Object> o1 = c(j1);
/* 1450 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */       
/* 1453 */       a(j1, i.g(illegalArgumentException));
/* 1454 */       illegalArgumentException = null;
/*      */     } 
/*      */     
/* 1457 */     if (illegalArgumentException != null)
/*      */     {
/* 1459 */       this.f.a(paramClass, j1, (o)illegalArgumentException, this);
/*      */     }
/* 1461 */     return (o<Object>)illegalArgumentException;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private o<Object> b(j paramj) {
/*      */     o<Object> o1;
/*      */     try {
/* 1469 */       o1 = c(paramj);
/* 1470 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */       
/* 1473 */       o1 = null;
/* 1474 */       a(illegalArgumentException, i.g(illegalArgumentException), new Object[0]);
/*      */     } 
/*      */     
/* 1477 */     if (o1 != null)
/*      */     {
/* 1479 */       this.f.a(paramj, o1, this);
/*      */     }
/* 1481 */     return o1;
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
/*      */   private o<Object> c(j paramj) {
/* 1501 */     return this.e.a(this, paramj);
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
/*      */   private o<Object> c(o<?> paramo, c paramc) {
/* 1514 */     if (paramo instanceof q) {
/* 1515 */       ((q)paramo).a(this);
/*      */     }
/* 1517 */     return (o)b(paramo, paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final o<Object> a(o<?> paramo) {
/* 1524 */     if (paramo instanceof q) {
/* 1525 */       ((q)paramo).a(this);
/*      */     }
/* 1527 */     return (o)paramo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DateFormat n() {
/* 1538 */     if (this.m != null) {
/* 1539 */       return this.m;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1545 */     DateFormat dateFormat = this.a.s();
/* 1546 */     this.m = dateFormat = (DateFormat)dateFormat.clone();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1555 */     return dateFormat;
/*      */   }
/*      */   
/*      */   public abstract v a(Object paramObject, al<?> paramal);
/*      */   
/*      */   public abstract o<Object> b(b paramb, Object paramObject);
/*      */   
/*      */   public abstract Object a(s params, Class<?> paramClass);
/*      */   
/*      */   public abstract boolean b(Object paramObject);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */