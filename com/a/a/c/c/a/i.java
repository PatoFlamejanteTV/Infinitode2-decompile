/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.h;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.w;
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends v
/*     */ {
/*     */   private h g;
/*     */   private transient Field h;
/*     */   private boolean i;
/*     */   
/*     */   public i(s params, j paramj, e parame, b paramb, h paramh) {
/*  46 */     super(params, paramj, parame, paramb);
/*  47 */     this.g = paramh;
/*  48 */     this.h = paramh.e();
/*  49 */     this.i = q.a(this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   private i(i parami, k<?> paramk, s params) {
/*  54 */     super(parami, paramk, params);
/*  55 */     this.g = parami.g;
/*  56 */     this.h = parami.h;
/*  57 */     this.i = q.a(params);
/*     */   }
/*     */   
/*     */   private i(i parami, w paramw) {
/*  61 */     super(parami, paramw);
/*  62 */     this.g = parami.g;
/*  63 */     this.h = parami.h;
/*  64 */     this.i = parami.i;
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
/*     */   public final v a(w paramw) {
/*  84 */     return new i(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/*  89 */     if (this.c == paramk) {
/*  90 */       return this;
/*     */     }
/*     */     
/*  93 */     s s = (s)((this.c == this.e) ? paramk : this.e);
/*  94 */     return new i(this, paramk, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/*  99 */     return new i(this, this.c, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/* 104 */     com.a.a.c.m.i.a(this.h, paramf
/* 105 */         .a(q.o));
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
/* 119 */     return (j)this.g;
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
/* 132 */     if (paraml.a(o.m)) {
/* 133 */       if (this.i) {
/*     */         return;
/*     */       }
/* 136 */       object = this.e.a(paramg);
/* 137 */     } else if (this.d == null) {
/*     */ 
/*     */       
/* 140 */       if ((object = this.c.a(paraml, paramg)) == null) {
/* 141 */         if (this.i) {
/*     */           return;
/*     */         }
/* 144 */         object = this.e.a(paramg);
/*     */       } 
/*     */     } else {
/* 147 */       object = this.c.a(paraml, paramg, this.d);
/*     */     } 
/*     */     try {
/* 150 */       this.h.set(paramObject, object); return;
/* 151 */     } catch (Exception exception) {
/* 152 */       a(paraml, exception, object);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*     */     Object object;
/* 161 */     if (paraml.a(o.m)) {
/* 162 */       if (this.i) {
/* 163 */         return paramObject;
/*     */       }
/* 165 */       object = this.e.a(paramg);
/* 166 */     } else if (this.d == null) {
/*     */ 
/*     */       
/* 169 */       if ((object = this.c.a(paraml, paramg)) == null) {
/* 170 */         if (this.i) {
/* 171 */           return paramObject;
/*     */         }
/* 173 */         object = this.e.a(paramg);
/*     */       } 
/*     */     } else {
/* 176 */       object = this.c.a(paraml, paramg, this.d);
/*     */     } 
/*     */     try {
/* 179 */       this.h.set(paramObject, object);
/* 180 */     } catch (Exception exception) {
/* 181 */       a(paraml, exception, object);
/*     */     } 
/* 183 */     return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 190 */       this.h.set(paramObject1, paramObject2); return;
/* 191 */     } catch (Exception exception) {
/*     */       
/* 193 */       a(exception, paramObject2);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 201 */       this.h.set(paramObject1, paramObject2);
/* 202 */     } catch (Exception exception) {
/*     */       
/* 204 */       a(exception, paramObject2);
/*     */     } 
/* 206 */     return paramObject1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */