/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.c.a.j;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.i.b;
/*     */ import com.a.a.c.i.c;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.i.h;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.y;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class o
/*     */   implements h<o>
/*     */ {
/*     */   private af.b a;
/*     */   private af.a b;
/*     */   private String c;
/*     */   private boolean d = false;
/*     */   private Class<?> e;
/*     */   private g f;
/*     */   
/*     */   private o(o paramo, Class<?> paramClass) {
/*  71 */     this.a = paramo.a;
/*  72 */     this.b = paramo.b;
/*  73 */     this.c = paramo.c;
/*  74 */     this.d = paramo.d;
/*  75 */     this.f = paramo.f;
/*     */     
/*  77 */     this.e = paramClass;
/*     */   }
/*     */   
/*     */   public static o b() {
/*  81 */     return (new o()).b(af.b.a, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o b(af.b paramb, g paramg) {
/*  88 */     if (paramb == null) {
/*  89 */       throw new IllegalArgumentException("idType cannot be null");
/*     */     }
/*  91 */     this.a = paramb;
/*  92 */     this.f = paramg;
/*     */     
/*  94 */     this.c = paramb.a();
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final i a(y paramy, j paramj, Collection<b> paramCollection) {
/* 102 */     if (this.a == af.b.a) return null;
/*     */ 
/*     */     
/* 105 */     if (paramj.l())
/*     */     {
/*     */       
/* 108 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 112 */     g g1 = a((q<?>)paramy, paramj, a((q<?>)paramy), paramCollection, true, false);
/*     */ 
/*     */     
/* 115 */     if (this.a == af.b.e)
/*     */     {
/* 117 */       return new d(g1, null, this.c);
/*     */     }
/*     */     
/* 120 */     switch (p.a[this.b.ordinal()]) {
/*     */       case 1:
/* 122 */         return new b(g1, null);
/*     */       case 2:
/* 124 */         return new h(g1, null, this.c);
/*     */       case 3:
/* 126 */         return new j(g1, null);
/*     */       case 4:
/* 128 */         return new f(g1, null, this.c);
/*     */       
/*     */       case 5:
/* 131 */         return new d(g1, null, this.c);
/*     */     } 
/* 133 */     throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
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
/*     */   public final e a(f paramf, j paramj, Collection<b> paramCollection) {
/* 146 */     if (this.a == af.b.a) return null;
/*     */ 
/*     */     
/* 149 */     if (paramj.l())
/*     */     {
/*     */       
/* 152 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     c c = a((q<?>)paramf, paramj);
/*     */     
/* 160 */     g g1 = a((q<?>)paramf, paramj, c, paramCollection, false, true);
/*     */     
/* 162 */     j j1 = a(paramf, paramj);
/*     */     
/* 164 */     if (this.a == af.b.e)
/*     */     {
/* 166 */       return new c(paramj, g1, j1, paramf, paramCollection);
/*     */     }
/*     */ 
/*     */     
/* 170 */     switch (p.a[this.b.ordinal()]) {
/*     */       case 1:
/* 172 */         return new a(paramj, g1, this.c, this.d, j1);
/*     */       
/*     */       case 2:
/*     */       case 5:
/* 176 */         return new g(paramj, g1, this.c, this.d, j1, this.b);
/*     */       
/*     */       case 3:
/* 179 */         return new i(paramj, g1, this.c, this.d, j1);
/*     */       
/*     */       case 4:
/* 182 */         return new e(paramj, g1, this.c, this.d, j1);
/*     */     } 
/*     */     
/* 185 */     throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   private j a(f paramf, j paramj) {
/* 190 */     if (this.e != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       if (this.e == Void.class || this.e == j.class)
/*     */       {
/*     */         
/* 200 */         return paramf.p().a(this.e);
/*     */       }
/* 202 */       if (paramj.a(this.e)) {
/* 203 */         return paramj;
/*     */       }
/* 205 */       if (paramj.c(this.e))
/*     */       {
/* 207 */         return paramf.p()
/* 208 */           .a(paramj, this.e);
/*     */       }
/* 210 */       if (paramj.a(this.e)) {
/* 211 */         return paramj;
/*     */       }
/*     */     } 
/*     */     
/* 215 */     if (paramf.a(q.q) && 
/* 216 */       !paramj.d())
/*     */     {
/* 218 */       return paramj;
/*     */     }
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o b(af.a parama) {
/* 231 */     if (parama == null) {
/* 232 */       throw new IllegalArgumentException("includeAs cannot be null");
/*     */     }
/* 234 */     this.b = parama;
/* 235 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o b(String paramString) {
/* 245 */     if (paramString == null || paramString.isEmpty()) {
/* 246 */       paramString = this.a.a();
/*     */     }
/* 248 */     this.c = paramString;
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private o c(Class<?> paramClass) {
/* 254 */     this.e = paramClass;
/* 255 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private o b(boolean paramBoolean) {
/* 260 */     this.d = paramBoolean;
/* 261 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private o d(Class<?> paramClass) {
/* 266 */     if (this.e == paramClass) {
/* 267 */       return this;
/*     */     }
/* 269 */     i.a(o.class, this, "withDefaultImpl");
/*     */ 
/*     */     
/* 272 */     return new o(this, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> a() {
/* 281 */     return this.e;
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
/*     */   private g a(q<?> paramq, j paramj, c paramc, Collection<b> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
/* 302 */     if (this.f != null) return this.f; 
/* 303 */     if (this.a == null) throw new IllegalStateException("Cannot build, 'init()' not yet called"); 
/* 304 */     switch (p.b[this.a.ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/* 307 */         return k.a(paramj, paramq, paramc);
/*     */       case 3:
/* 309 */         return m.b(paramj, paramq, paramc);
/*     */       case 4:
/* 311 */         return t.a(paramq, paramj, paramCollection, paramBoolean1, paramBoolean2);
/*     */       case 5:
/* 313 */         return null;
/*     */     } 
/*     */     
/* 316 */     throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.a);
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
/*     */   private static c a(q<?> paramq) {
/* 335 */     return paramq.o();
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
/*     */   private c a(q<?> paramq, j paramj) {
/* 348 */     c c = a(paramq);
/* 349 */     if (this.a == af.b.b || this.a == af.b.c) {
/*     */       c.b b1;
/*     */       
/* 352 */       if ((b1 = c.a(paramq, paramj)) == c.b.b) {
/* 353 */         return a(paramj, c);
/*     */       }
/*     */       
/* 356 */       if (b1 == c.b.a) {
/* 357 */         return (c)l.a;
/*     */       }
/*     */     } 
/*     */     
/* 361 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static c a(j paramj, c paramc) {
/* 370 */     throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", new Object[] {
/*     */             
/* 372 */             i.d(paramc), i.d(paramj.b())
/*     */           }));
/*     */   }
/*     */   
/*     */   public o() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */