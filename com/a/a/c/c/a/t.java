/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.w;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.w;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class t
/*     */   extends v
/*     */ {
/*     */   private final v g;
/*     */   
/*     */   public t(v paramv, ad paramad) {
/*  23 */     super(paramv);
/*  24 */     this.g = paramv;
/*  25 */     this.f = paramad;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private t(t paramt, k<?> paramk, s params) {
/*  31 */     super(paramt, paramk, params);
/*  32 */     this.g = paramt.g;
/*  33 */     this.f = paramt.f;
/*     */   }
/*     */ 
/*     */   
/*     */   private t(t paramt, w paramw) {
/*  38 */     super(paramt, paramw);
/*  39 */     this.g = paramt.g;
/*  40 */     this.f = paramt.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(w paramw) {
/*  45 */     return new t(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/*  50 */     if (this.c == paramk) {
/*  51 */       return this;
/*     */     }
/*     */     
/*  54 */     s s = (s)((this.c == this.e) ? paramk : this.e);
/*  55 */     return new t(this, paramk, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/*  60 */     return new t(this, this.c, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/*  65 */     if (this.g != null) {
/*  66 */       this.g.a(paramf);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j e() {
/*  77 */     return this.g.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int h() {
/*  82 */     return this.g.h();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(l paraml, g paramg, Object paramObject) {
/*  87 */     b(paraml, paramg, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*     */     try {
/*  94 */       return b(paramObject, a(paraml, paramg));
/*  95 */     } catch (w w) {
/*     */       boolean bool;
/*  97 */       if (!(bool = (this.f != null || this.c.f() != null) ? true : false)) {
/*  98 */         throw l.a(paraml, "Unresolved forward reference but no identity info", w);
/*     */       }
/* 100 */       w.d().a(new a(this, w, this.b.b(), paramObject));
/* 101 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 107 */     this.g.a(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/* 112 */     return this.g.b(paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public static final class a
/*     */     extends z.a
/*     */   {
/*     */     private final t a;
/*     */     private Object b;
/*     */     
/*     */     public a(t param1t, w param1w, Class<?> param1Class, Object param1Object) {
/* 122 */       super(param1w, param1Class);
/* 123 */       this.a = param1t;
/* 124 */       this.b = param1Object;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 130 */       if (!b(param1Object1)) {
/* 131 */         throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + param1Object1 + "] that wasn't previously seen as unresolved.");
/*     */       }
/*     */       
/* 134 */       this.a.a(this.b, param1Object2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */