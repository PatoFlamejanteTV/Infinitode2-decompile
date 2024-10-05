/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.t;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ad<T>
/*     */   extends ae<T>
/*     */   implements k, t
/*     */ {
/*     */   private k<Object, T> a;
/*     */   private j b;
/*     */   private k<Object> c;
/*     */   
/*     */   public ad(k<?, T> paramk) {
/*  66 */     super(Object.class);
/*  67 */     this.a = (k)paramk;
/*  68 */     this.b = null;
/*  69 */     this.c = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ad(k<Object, T> paramk, j paramj, k<?> paramk1) {
/*  76 */     super(paramj);
/*  77 */     this.a = paramk;
/*  78 */     this.b = paramj;
/*  79 */     this.c = (k)paramk1;
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
/*     */   private ad<T> a(k<Object, T> paramk, j paramj, k<?> paramk1) {
/* 100 */     i.a(ad.class, this, "withDelegate");
/* 101 */     return new ad(paramk, paramj, paramk1);
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
/*     */   public final void d(g paramg) {
/* 116 */     if (this.c != null && this.c instanceof t) {
/* 117 */       ((t)this.c).d(paramg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/* 126 */     if (this.c != null) {
/*     */       k<Object> k1;
/*     */       
/* 129 */       if ((k1 = paramg.b(this.c, paramc, this.b)) != this.c) {
/* 130 */         return a(this.a, this.b, k1);
/*     */       }
/* 132 */       return this;
/*     */     } 
/*     */     
/* 135 */     paramg.b(); j j1 = this.a.a();
/* 136 */     return a(this.a, j1, paramg
/* 137 */         .a(j1, paramc));
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
/*     */   public final Class<?> a() {
/* 153 */     return this.c.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 158 */     return this.c.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/* 163 */     return this.c.a(paramf);
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
/*     */   public final T a(l paraml, g paramg) {
/*     */     Object object;
/* 176 */     if ((object = this.c.a(paraml, paramg)) == null) {
/* 177 */       return null;
/*     */     }
/* 179 */     return b(object);
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
/*     */   public final Object a(l paraml, g paramg, e parame) {
/*     */     Object object;
/* 198 */     if ((object = this.c.a(paraml, paramg)) == null) {
/* 199 */       return null;
/*     */     }
/* 201 */     return b(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T a(l paraml, g paramg, Object paramObject) {
/* 209 */     if (this.b.b().isAssignableFrom(paramObject.getClass())) {
/* 210 */       return (T)this.c.a(paraml, paramg, paramObject);
/*     */     }
/* 212 */     return (T)a(paramObject);
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
/*     */   private Object a(Object paramObject) {
/* 228 */     throw new UnsupportedOperationException(
/* 229 */         String.format("Cannot update object of type %s (using deserializer for type %s)" + paramObject
/* 230 */           .getClass().getName(), new Object[] { this.b }));
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
/*     */   private T b(Object paramObject) {
/* 252 */     return (T)this.a.a(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */