/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.a.ac;
/*     */ import com.a.a.a.f;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.q;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.a.t;
/*     */ import com.a.a.b.c;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.f.am;
/*     */ import com.a.a.c.f.ap;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.d;
/*     */ import com.a.a.c.i.d;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.z;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.w;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class r<CFG extends c, T extends r<CFG, T>>
/*     */   extends q<T>
/*     */   implements Serializable
/*     */ {
/*  32 */   private static g d = g.a();
/*     */   
/*  34 */   private static final long e = q.c();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final long f = q.e
/*  40 */     .d() | q.f
/*  41 */     .d() | q.g
/*  42 */     .d() | q.h
/*  43 */     .d() | q.d
/*  44 */     .d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private am g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final w b;
/*     */ 
/*     */ 
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
/*     */ 
/*     */   
/*     */   private j j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private z k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final l c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected r(a parama, d paramd, am paramam, z paramz, h paramh, l paraml) {
/* 134 */     super(parama, e);
/* 135 */     this.g = paramam;
/* 136 */     this.h = paramd;
/* 137 */     this.k = paramz;
/* 138 */     this.b = null;
/* 139 */     this.i = null;
/*     */     
/* 141 */     this.j = j.a();
/* 142 */     this.l = paramh;
/* 143 */     this.c = paraml;
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
/*     */   protected r(r<CFG, T> paramr, long paramLong) {
/* 201 */     super(paramr, paramLong);
/* 202 */     this.g = paramr.g;
/* 203 */     this.h = paramr.h;
/* 204 */     this.k = paramr.k;
/* 205 */     this.b = paramr.b;
/* 206 */     this.i = paramr.i;
/* 207 */     this.j = paramr.j;
/* 208 */     this.l = paramr.l;
/* 209 */     this.c = paramr.c;
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
/*     */   protected abstract T a(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T a(q... paramVarArgs) {
/* 339 */     long l1 = this.a; byte b;
/* 340 */     for (paramVarArgs = paramVarArgs, b = 0; b; ) { q q1 = paramVarArgs[0];
/* 341 */       l1 |= q1.d(); b++; }
/*     */     
/* 343 */     if (l1 == this.a) {
/* 344 */       return (T)this;
/*     */     }
/* 346 */     return a(l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T b(q... paramVarArgs) {
/* 357 */     long l1 = this.a; byte b;
/* 358 */     for (paramVarArgs = paramVarArgs, b = 0; b; ) { q q1 = paramVarArgs[0];
/* 359 */       l1 &= q1.d() ^ 0xFFFFFFFFFFFFFFFFL; b++; }
/*     */     
/* 361 */     if (l1 == this.a) {
/* 362 */       return (T)this;
/*     */     }
/* 364 */     return a(l1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d w() {
/* 683 */     return this.h;
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
/*     */   public final w x() {
/* 698 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class<?> y() {
/* 703 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j z() {
/* 708 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g d(Class<?> paramClass) {
/*     */     g g1;
/* 720 */     return ((g1 = this.l.a(paramClass)) == null) ? d : g1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b A() {
/* 730 */     return this.l.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final s.b e(Class<?> paramClass) {
/* 735 */     s.b b1 = d(paramClass).c();
/*     */     s.b b2;
/* 737 */     if ((b2 = A()) == null) {
/* 738 */       return b1;
/*     */     }
/* 740 */     return b2.a(b1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b a(Class<?> paramClass1, Class<?> paramClass2) {
/* 746 */     s.b b2 = d(paramClass2).d();
/*     */     s.b b1;
/* 748 */     if ((b1 = e(paramClass1)) == null) {
/* 749 */       return b2;
/*     */     }
/* 751 */     return b1.a(b2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final l.d f(Class<?> paramClass) {
/* 756 */     return this.l.b(paramClass);
/*     */   }
/*     */   
/*     */   private q.a j(Class<?> paramClass) {
/*     */     g g1;
/*     */     q.a a;
/* 762 */     if ((g1 = this.l.a(paramClass)) != null && (
/*     */       
/* 764 */       a = g1.e()) != null) {
/* 765 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 770 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final q.a b(Class<?> paramClass, d paramd) {
/*     */     a a;
/* 779 */     q.a a2 = ((a = j()) == null) ? null : a.b((b)paramd);
/* 780 */     q.a a1 = j(paramClass);
/* 781 */     return q.a.a(a2, a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final t.a a(d paramd) {
/*     */     a a;
/* 789 */     return ((a = j()) == null) ? null : a.c((b)paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ap<?> a() {
/* 795 */     ap<?> ap = this.l.d();
/*     */ 
/*     */     
/* 798 */     if ((this.a & f) != f) {
/* 799 */       if (!a(q.e)) {
/* 800 */         ap = ap.e(f.b.e);
/*     */       }
/* 802 */       if (!a(q.f)) {
/* 803 */         ap = ap.a(f.b.e);
/*     */       }
/* 805 */       if (!a(q.g)) {
/* 806 */         ap = ap.b(f.b.e);
/*     */       }
/* 808 */       if (!a(q.h)) {
/* 809 */         ap = ap.c(f.b.e);
/*     */       }
/* 811 */       if (!a(q.d)) {
/* 812 */         ap = ap.d(f.b.e);
/*     */       }
/*     */     } 
/* 815 */     return ap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ap<?> a(Class<?> paramClass, d paramd) {
/*     */     ap<?> ap;
/* 826 */     if (i.m(paramClass)) {
/* 827 */       ap.a a1 = ap.a.b();
/*     */     } else {
/* 829 */       ap = a();
/*     */     } 
/*     */     a a;
/* 832 */     if ((a = j()) != null) {
/* 833 */       ap = a.a(paramd, ap);
/*     */     }
/*     */     g g1;
/* 836 */     if ((g1 = this.l.a(paramClass)) != null) {
/* 837 */       ap = ap.a(g1.h());
/*     */     }
/* 839 */     return ap;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ac.a q() {
/* 844 */     return this.l.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean r() {
/* 849 */     return this.l.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean g(Class<?> paramClass) {
/*     */     g g1;
/*     */     Boolean bool;
/* 856 */     if ((g1 = this.l.a(paramClass)) != null && (
/*     */       
/* 858 */       bool = g1.i()) != null) {
/* 859 */       return bool;
/*     */     }
/*     */     
/* 862 */     return this.l.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final w e(j paramj) {
/* 873 */     if (this.b != null) {
/* 874 */       return this.b;
/*     */     }
/* 876 */     return this.k.a(paramj, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final w h(Class<?> paramClass) {
/* 881 */     if (this.b != null) {
/* 882 */       return this.b;
/*     */     }
/* 884 */     return this.k.a(paramClass, this);
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
/*     */   public final Class<?> i(Class<?> paramClass) {
/* 899 */     return this.g.i(paramClass);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */