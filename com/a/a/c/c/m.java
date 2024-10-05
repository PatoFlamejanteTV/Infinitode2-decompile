/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.a.b;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.d.b;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.n;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class m
/*     */   extends v
/*     */ {
/*     */   private n g;
/*     */   private b.a h;
/*     */   private v i;
/*     */   private int j;
/*     */   private boolean k;
/*     */   
/*     */   private m(w paramw1, j paramj, w paramw2, e parame, b paramb, n paramn, int paramInt, b.a parama, v paramv) {
/*  87 */     super(paramw1, paramj, paramw2, parame, paramb, paramv);
/*  88 */     this.g = paramn;
/*  89 */     this.j = paramInt;
/*  90 */     this.h = parama;
/*  91 */     this.i = null;
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
/*     */   public static m a(w paramw1, j paramj, w paramw2, e parame, b paramb, n paramn, int paramInt, b.a parama, v paramv) {
/* 134 */     return new m(paramw1, paramj, paramw2, parame, paramb, paramn, paramInt, parama, paramv);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private m(m paramm, w paramw) {
/* 142 */     super(paramm, paramw);
/* 143 */     this.g = paramm.g;
/* 144 */     this.h = paramm.h;
/* 145 */     this.i = paramm.i;
/* 146 */     this.j = paramm.j;
/* 147 */     this.k = paramm.k;
/*     */   }
/*     */ 
/*     */   
/*     */   private m(m paramm, k<?> paramk, s params) {
/* 152 */     super(paramm, paramk, params);
/* 153 */     this.g = paramm.g;
/* 154 */     this.h = paramm.h;
/* 155 */     this.i = paramm.i;
/* 156 */     this.j = paramm.j;
/* 157 */     this.k = paramm.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(w paramw) {
/* 162 */     return new m(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/* 167 */     if (this.c == paramk) {
/* 168 */       return this;
/*     */     }
/*     */     
/* 171 */     s s = (s)((this.c == this.e) ? paramk : this.e);
/* 172 */     return new m(this, paramk, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/* 177 */     return new m(this, this.c, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/* 182 */     if (this.i != null) {
/* 183 */       this.i.a(paramf);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(v paramv) {
/* 194 */     this.i = paramv;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void f() {
/* 199 */     this.k = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 204 */     return this.k;
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
/*     */   public final j e() {
/* 254 */     return (j)this.g;
/*     */   }
/*     */   public final int h() {
/* 257 */     return this.j;
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
/*     */   public final void a(l paraml, g paramg, Object paramObject) {
/* 270 */     u();
/* 271 */     this.i.a(paramObject, a(paraml, paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/* 278 */     u();
/* 279 */     return this.i.b(paramObject, a(paraml, paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 285 */     u();
/* 286 */     this.i.a(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/* 292 */     u();
/* 293 */     return this.i.b(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v d() {
/* 303 */     v v1 = super.d();
/* 304 */     if (this.i != null) {
/* 305 */       return v1.a(this.i.d().d());
/*     */     }
/* 307 */     return v1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object i() {
/* 313 */     return (this.h == null) ? null : this.h.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean j() {
/* 318 */     return (this.h != null && !this.h.a(true));
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
/*     */   public final String toString() {
/* 330 */     return "[creator property, name " + i.b(a()) + "; inject id '" + i() + "']";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void u() {
/* 340 */     if (this.i == null) {
/* 341 */       b((l)null, (g)null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(l paraml, g paramg) {
/* 348 */     String str = "No fallback setter/field defined for creator property " + i.b(a());
/*     */ 
/*     */     
/* 351 */     if (paramg != null) {
/* 352 */       paramg.a(c(), str); return;
/*     */     } 
/* 354 */     throw b.a(paraml, str, c());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */