/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.w;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class o
/*     */   extends v
/*     */ {
/*     */   private k g;
/*     */   private transient Method h;
/*     */   private boolean i;
/*     */   
/*     */   public o(s params, j paramj, e parame, b paramb, k paramk) {
/*  42 */     super(params, paramj, parame, paramb);
/*  43 */     this.g = paramk;
/*  44 */     this.h = paramk.e();
/*  45 */     this.i = q.a(this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   private o(o paramo, k<?> paramk, s params) {
/*  50 */     super(paramo, paramk, params);
/*  51 */     this.g = paramo.g;
/*  52 */     this.h = paramo.h;
/*  53 */     this.i = q.a(params);
/*     */   }
/*     */   
/*     */   private o(o paramo, w paramw) {
/*  57 */     super(paramo, paramw);
/*  58 */     this.g = paramo.g;
/*  59 */     this.h = paramo.h;
/*  60 */     this.i = paramo.i;
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
/*     */   public final v a(w paramw) {
/*  75 */     return new o(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/*  80 */     if (this.c == paramk) {
/*  81 */       return this;
/*     */     }
/*     */     
/*  84 */     s s = (s)((this.c == this.e) ? paramk : this.e);
/*  85 */     return new o(this, paramk, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/*  90 */     return new o(this, this.c, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/*  95 */     this.g.a(paramf
/*  96 */         .a(q.o));
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
/*     */   public final j e() {
/* 110 */     return (j)this.g;
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
/*     */     Object object;
/* 123 */     if (paraml.a(com.a.a.b.o.m)) {
/* 124 */       if (this.i) {
/*     */         return;
/*     */       }
/* 127 */       object = this.e.a(paramg);
/* 128 */     } else if (this.d == null) {
/*     */ 
/*     */       
/* 131 */       if ((object = this.c.a(paraml, paramg)) == null) {
/* 132 */         if (this.i) {
/*     */           return;
/*     */         }
/* 135 */         object = this.e.a(paramg);
/*     */       } 
/*     */     } else {
/* 138 */       object = this.c.a(paraml, paramg, this.d);
/*     */     } 
/*     */     try {
/* 141 */       this.h.invoke(paramObject, new Object[] { object }); return;
/* 142 */     } catch (Exception exception) {
/* 143 */       a(paraml, exception, object);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*     */     Object object;
/* 152 */     if (paraml.a(com.a.a.b.o.m)) {
/* 153 */       if (this.i) {
/* 154 */         return paramObject;
/*     */       }
/* 156 */       object = this.e.a(paramg);
/* 157 */     } else if (this.d == null) {
/*     */ 
/*     */       
/* 160 */       if ((object = this.c.a(paraml, paramg)) == null) {
/* 161 */         if (this.i) {
/* 162 */           return paramObject;
/*     */         }
/* 164 */         object = this.e.a(paramg);
/*     */       } 
/*     */     } else {
/* 167 */       object = this.c.a(paraml, paramg, this.d);
/*     */     } 
/*     */     try {
/*     */       Object object1;
/* 171 */       return ((object1 = this.h.invoke(paramObject, new Object[] { object })) == null) ? paramObject : object1;
/* 172 */     } catch (Exception exception) {
/* 173 */       a(paraml, exception, object);
/* 174 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 182 */       this.h.invoke(paramObject1, new Object[] { paramObject2 }); return;
/* 183 */     } catch (Exception exception) {
/*     */       
/* 185 */       a(exception, paramObject2);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/*     */     try {
/*     */       Object object;
/* 194 */       return ((object = this.h.invoke(paramObject1, new Object[] { paramObject2 })) == null) ? paramObject1 : object;
/* 195 */     } catch (Exception exception) {
/*     */       
/* 197 */       a(exception, paramObject2);
/* 198 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */