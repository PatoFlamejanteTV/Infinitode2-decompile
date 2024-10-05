/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
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
/*     */ public final class aa
/*     */   extends v
/*     */ {
/*     */   private k g;
/*     */   private Method h;
/*     */   
/*     */   public aa(s params, j paramj, e parame, b paramb, k paramk) {
/*  39 */     super(params, paramj, parame, paramb);
/*  40 */     this.g = paramk;
/*  41 */     this.h = paramk.e();
/*     */   }
/*     */ 
/*     */   
/*     */   private aa(aa paramaa, k<?> paramk, s params) {
/*  46 */     super(paramaa, paramk, params);
/*  47 */     this.g = paramaa.g;
/*  48 */     this.h = paramaa.h;
/*     */   }
/*     */   
/*     */   private aa(aa paramaa, w paramw) {
/*  52 */     super(paramaa, paramw);
/*  53 */     this.g = paramaa.g;
/*  54 */     this.h = paramaa.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(w paramw) {
/*  59 */     return new aa(this, paramw);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(k<?> paramk) {
/*  64 */     if (this.c == paramk) {
/*  65 */       return this;
/*     */     }
/*     */     
/*  68 */     s s = (s)((this.c == this.e) ? paramk : this.e);
/*  69 */     return new aa(this, paramk, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(s params) {
/*  74 */     return new aa(this, this.c, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/*  79 */     this.g.a(paramf
/*  80 */         .a(q.o));
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
/*  94 */     return (j)this.g;
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
/* 106 */     if (paraml.a(o.m)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (this.d != null) {
/* 113 */       paramg.a(c(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", new Object[] {
/*     */               
/* 115 */               a()
/*     */             }));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 121 */       paramObject = this.h.invoke(paramObject, (Object[])null);
/* 122 */     } catch (Exception exception) {
/* 123 */       a(paraml, exception);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 129 */     if (paramObject == null)
/* 130 */       exception.a(c(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", new Object[] {
/*     */               
/* 132 */               a()
/*     */             })); 
/* 134 */     this.c.a(paraml, (g)exception, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/* 141 */     a(paraml, paramg, paramObject);
/* 142 */     return paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 147 */     throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + a() + "')");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/* 153 */     a(paramObject1, paramObject2);
/* 154 */     return paramObject1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */