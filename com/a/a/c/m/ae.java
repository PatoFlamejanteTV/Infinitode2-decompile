/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.b.c.d;
/*     */ import com.a.a.b.d.d;
/*     */ import com.a.a.b.j;
/*     */ import com.a.a.b.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ae
/*     */   extends n
/*     */ {
/*     */   private n c;
/*     */   private j d;
/*     */   private String e;
/*     */   private Object f;
/*     */   
/*     */   private ae(n paramn, d paramd) {
/*  39 */     super(paramn);
/*  40 */     this.c = paramn.a();
/*  41 */     this.e = paramn.g();
/*  42 */     this.f = paramn.h();
/*  43 */     if (paramn instanceof d) {
/*  44 */       d d1 = (d)paramn;
/*  45 */       this.d = d1.a(paramd); return;
/*     */     } 
/*  47 */     this.d = j.a;
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
/*     */   private ae(n paramn, j paramj) {
/*  59 */     super(paramn);
/*  60 */     this.c = paramn.a();
/*  61 */     this.e = paramn.g();
/*  62 */     this.f = paramn.h();
/*  63 */     this.d = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ae() {
/*  71 */     super(0, -1);
/*  72 */     this.c = null;
/*  73 */     this.d = j.a;
/*     */   }
/*     */   
/*     */   private ae(ae paramae, int paramInt1, int paramInt2) {
/*  77 */     super(paramInt1, -1);
/*  78 */     this.c = paramae;
/*  79 */     this.d = paramae.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object h() {
/*  84 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject) {
/*  89 */     this.f = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ae a(n paramn) {
/* 100 */     if (paramn == null) {
/* 101 */       return new ae();
/*     */     }
/* 103 */     return new ae(paramn, d.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ae i() {
/* 108 */     this.b++;
/* 109 */     return new ae(this, 1, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ae j() {
/* 114 */     this.b++;
/* 115 */     return new ae(this, 2, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ae k() {
/* 126 */     if (this.c instanceof ae) {
/* 127 */       return (ae)this.c;
/*     */     }
/* 129 */     if (this.c == null) {
/* 130 */       return new ae();
/*     */     }
/* 132 */     return new ae(this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String g() {
/* 141 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final n a() {
/* 146 */     return this.c;
/*     */   }
/*     */   public final void a(String paramString) {
/* 149 */     this.e = paramString;
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
/*     */   public final void l() {
/* 162 */     this.b++;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */