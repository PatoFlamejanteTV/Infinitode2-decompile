/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.v;
/*     */ import com.a.a.c.w;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class u
/*     */   extends v
/*     */ {
/*     */   private s g;
/*     */   
/*     */   public u(s params, v paramv) {
/*  27 */     super(params.a, params.b(), paramv, params
/*  28 */         .a());
/*  29 */     this.g = params;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private u(u paramu, k<?> paramk, s params) {
/*  35 */     super(paramu, paramk, params);
/*  36 */     this.g = paramu.g;
/*     */   }
/*     */   
/*     */   private u(u paramu, w paramw) {
/*  40 */     super(paramu, paramw);
/*  41 */     this.g = paramu.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(w paramw) {
/*  46 */     return new u(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/*  51 */     if (this.c == paramk) {
/*  52 */       return this;
/*     */     }
/*     */     
/*  55 */     s s1 = (s)((this.c == this.e) ? paramk : this.e);
/*  56 */     return new u(this, paramk, s1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/*  61 */     return new u(this, this.c, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j e() {
/*  71 */     return null;
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
/*     */   public final void a(l paraml, g paramg, Object paramObject) {
/*  83 */     b(paraml, paramg, paramObject);
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
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*  96 */     if (paraml.a(o.m)) {
/*  97 */       return null;
/*     */     }
/*  99 */     Object object = this.c.a(paraml, paramg);
/*     */     z z;
/* 101 */     (z = paramg.a(object, this.g.b, this.g.c)).a(paramObject);
/*     */     
/*     */     v v1;
/* 104 */     if ((v1 = this.g.d) != null) {
/* 105 */       return v1.b(paramObject, object);
/*     */     }
/* 107 */     return paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 112 */     b(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/*     */     v v1;
/* 119 */     if ((v1 = this.g.d) == null) {
/* 120 */       throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
/*     */     }
/*     */     
/* 123 */     return v1.b(paramObject1, paramObject2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */