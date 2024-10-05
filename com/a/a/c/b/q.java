/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.a.ac;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.b.a;
/*     */ import com.a.a.b.c;
/*     */ import com.a.a.b.c.k;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.f.a;
/*     */ import com.a.a.c.f.ab;
/*     */ import com.a.a.c.f.ap;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.d;
/*     */ import com.a.a.c.f.t;
/*     */ import com.a.a.c.i.a;
/*     */ import com.a.a.c.i.a.l;
/*     */ import com.a.a.c.i.c;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.i.h;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.x;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class q<T extends q<T>>
/*     */   implements t.a, Serializable
/*     */ {
/*     */   protected final long a;
/*     */   private a b;
/*     */   
/*     */   static {
/*  51 */     s.b.a();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     l.d.a();
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
/*     */   protected q(a parama, long paramLong) {
/*  79 */     this.b = parama;
/*  80 */     this.a = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   protected q(q<T> paramq, long paramLong) {
/*  85 */     this.b = paramq.b;
/*  86 */     this.a = paramLong;
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
/*     */   public static <F extends Enum<F> & c> int a(Class<F> paramClass) {
/* 107 */     int i = 0; Enum[] arrayOfEnum; int j; byte b;
/* 108 */     for (j = (arrayOfEnum = (Enum[])paramClass.getEnumConstants()).length, b = 0; b < j; b++) {
/* 109 */       Enum enum_; if (((c)(enum_ = arrayOfEnum[b])).a()) {
/* 110 */         i |= ((c)enum_).b();
/*     */       }
/*     */     } 
/* 113 */     return i;
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
/*     */   public final boolean a(com.a.a.c.q paramq) {
/* 150 */     return paramq.a(this.a);
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
/*     */   public final boolean f() {
/* 173 */     return a(com.a.a.c.q.a);
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
/*     */   public final boolean g() {
/* 188 */     return a(com.a.a.c.q.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean h() {
/* 196 */     return a(com.a.a.c.q.t);
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
/*     */   public static r a(String paramString) {
/* 228 */     return (r)new k(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final t i() {
/* 238 */     return this.b.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a j() {
/* 248 */     if (a(com.a.a.c.q.a)) {
/* 249 */       return this.b.b();
/*     */     }
/* 251 */     return (a)ab.a;
/*     */   }
/*     */   
/*     */   public final x k() {
/* 255 */     return this.b.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public final a.a l() {
/* 260 */     return this.b.d();
/*     */   }
/*     */   
/*     */   public final d m() {
/* 264 */     return this.b.i();
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
/*     */   public final h<?> n() {
/* 280 */     return this.b.f();
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
/*     */   public final c o() {
/*     */     a a1;
/*     */     c c;
/* 299 */     if ((c = this.b.g()) == l.a && 
/* 300 */       a(com.a.a.c.q.E)) {
/* 301 */       a1 = new a();
/*     */     }
/*     */     
/* 304 */     return (c)a1;
/*     */   }
/*     */   
/*     */   public final o p() {
/* 308 */     return this.b.e();
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
/*     */   public final j b(Class<?> paramClass) {
/* 320 */     return p().a(paramClass);
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
/*     */   public final b c(Class<?> paramClass) {
/* 351 */     return d(b(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b d(j paramj) {
/* 359 */     return i().a(this, paramj, this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b a(Class<?> paramClass, s.b paramb) {
/*     */     s.b b1;
/* 444 */     if ((b1 = d(paramClass).c()) != null) {
/* 445 */       return b1;
/*     */     }
/* 447 */     return paramb;
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
/*     */   public final s.b a(Class<?> paramClass1, Class<?> paramClass2, s.b paramb) {
/* 480 */     s.b b1 = d(paramClass1).c();
/* 481 */     s.b b2 = d(paramClass2).d();
/*     */ 
/*     */     
/* 484 */     return b1 = s.b.a(new s.b[] { paramb, b1, b2 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DateFormat s() {
/* 604 */     return this.b.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Locale t() {
/* 611 */     return this.b.j();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TimeZone u() {
/* 618 */     return this.b.k();
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
/*     */   public final a v() {
/* 648 */     return this.b.l();
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
/*     */   public final h<?> a(b paramb, Class<? extends h<?>> paramClass) {
/*     */     d d;
/*     */     h<?> h;
/* 684 */     if ((d = m()) != null && (
/*     */       
/* 686 */       h = d.g()) != null) {
/* 687 */       return h;
/*     */     }
/*     */     
/* 690 */     return (h)i.b(paramClass, g());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g b(b paramb, Class<? extends g> paramClass) {
/*     */     g g;
/*     */     d d;
/* 701 */     if ((d = m()) != null && (
/*     */       
/* 703 */       g = d.h()) != null) {
/* 704 */       return g;
/*     */     }
/*     */     
/* 707 */     return (g)i.b(paramClass, g());
/*     */   }
/*     */   
/*     */   public abstract g d(Class<?> paramClass);
/*     */   
/*     */   public abstract s.b e(Class<?> paramClass);
/*     */   
/*     */   public abstract s.b a(Class<?> paramClass1, Class<?> paramClass2);
/*     */   
/*     */   public abstract l.d f(Class<?> paramClass);
/*     */   
/*     */   public abstract ap<?> a(Class<?> paramClass, d paramd);
/*     */   
/*     */   public abstract ac.a q();
/*     */   
/*     */   public abstract Boolean r();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */