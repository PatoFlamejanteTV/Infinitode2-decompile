/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.v;
/*     */ import com.a.a.c.c.a.y;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.t;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.p;
/*     */ import com.a.a.c.q;
/*     */ import java.io.IOException;
/*     */ import java.util.EnumMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   extends i<EnumMap<?, ?>>
/*     */   implements k, t
/*     */ {
/*     */   private Class<?> a;
/*     */   private p f;
/*     */   private k<Object> g;
/*     */   private e h;
/*     */   private x i;
/*     */   private k<Object> j;
/*     */   private v k;
/*     */   
/*     */   public n(j paramj, x paramx, p paramp, k<?> paramk, e parame, s params) {
/*  78 */     super(paramj, params, (Boolean)null);
/*  79 */     this.a = paramj.t().b();
/*  80 */     this.f = paramp;
/*  81 */     this.g = (k)paramk;
/*  82 */     this.h = parame;
/*  83 */     this.i = paramx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n(n paramn, p paramp, k<?> paramk, e parame, s params) {
/*  93 */     super(paramn, params, paramn.e);
/*  94 */     this.a = paramn.a;
/*  95 */     this.f = paramp;
/*  96 */     this.g = (k)paramk;
/*  97 */     this.h = parame;
/*     */     
/*  99 */     this.i = paramn.i;
/* 100 */     this.j = paramn.j;
/* 101 */     this.k = paramn.k;
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
/*     */   private n a(p paramp, k<?> paramk, e parame, s params) {
/* 115 */     if (paramp == this.f && params == this.c && paramk == this.g && parame == this.h)
/*     */     {
/* 117 */       return this;
/*     */     }
/* 119 */     return new n(this, paramp, paramk, parame, params);
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
/*     */   public final void d(g paramg) {
/* 133 */     if (this.i != null) {
/* 134 */       if (this.i.m()) {
/* 135 */         paramg.c(); j j;
/* 136 */         if ((j = this.i.p()) == null) {
/* 137 */           paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[] { this.b, this.i
/*     */ 
/*     */                   
/* 140 */                   .getClass().getName() }));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         this.j = a(paramg, j, (c)null); return;
/* 147 */       }  if (this.i.n()) {
/* 148 */         paramg.c(); j j;
/* 149 */         if ((j = this.i.q()) == null) {
/* 150 */           paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[] { this.b, this.i
/*     */ 
/*     */                   
/* 153 */                   .getClass().getName() }));
/*     */         }
/* 155 */         this.j = a(paramg, j, (c)null); return;
/* 156 */       }  if (this.i.o()) {
/* 157 */         v[] arrayOfV = this.i.a(paramg.c());
/* 158 */         this.k = v.a(paramg, this.i, arrayOfV, paramg
/* 159 */             .a(q.v));
/*     */       } 
/*     */     } 
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
/*     */   public final k<?> a(g paramg, c paramc) {
/*     */     p p1;
/* 175 */     if ((p1 = this.f) == null) {
/* 176 */       p1 = paramg.b(this.b.t(), paramc);
/*     */     }
/* 178 */     k<Object> k1 = this.g;
/* 179 */     j j = this.b.u();
/* 180 */     if (k1 == null) {
/* 181 */       k1 = paramg.a(j, paramc);
/*     */     } else {
/* 183 */       k1 = paramg.b(k1, paramc, j);
/*     */     } 
/*     */     e e1;
/* 186 */     if ((e1 = this.h) != null) {
/* 187 */       e1 = e1.a(paramc);
/*     */     }
/* 189 */     return a(p1, k1, e1, b(paramg, paramc, k1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 199 */     return (this.g == null && this.f == null && this.h == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f b() {
/* 206 */     return f.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object> g() {
/* 217 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final x i() {
/* 222 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(g paramg) {
/* 227 */     return k(paramg);
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
/*     */   private EnumMap<?, ?> c(l paraml, g paramg) {
/* 240 */     if (this.k != null) {
/* 241 */       return e(paraml, paramg);
/*     */     }
/* 243 */     if (this.j != null) {
/* 244 */       return (EnumMap<?, ?>)this.i.a(paramg, this.j
/* 245 */           .a(paraml, paramg));
/*     */     }
/*     */     
/* 248 */     switch (paraml.l()) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 5:
/* 252 */         return a(paraml, paramg, k(paramg));
/*     */       
/*     */       case 6:
/* 255 */         return m(paraml, paramg);
/*     */       
/*     */       case 3:
/* 258 */         return d(paraml, paramg);
/*     */     } 
/*     */     
/* 261 */     return (EnumMap<?, ?>)paramg.a(e(paramg), paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumMap<?, ?> a(l paraml, g paramg, EnumMap<?, ?> paramEnumMap) {
/* 270 */     paraml.a(paramEnumMap);
/*     */     
/* 272 */     k<Object> k1 = this.g;
/* 273 */     e e1 = this.h;
/*     */ 
/*     */     
/* 276 */     if (paraml.q()) {
/* 277 */       str = paraml.h();
/*     */     } else {
/*     */       o o;
/* 280 */       if ((o = paraml.k()) != o.f) {
/* 281 */         if (o == o.c) {
/* 282 */           return paramEnumMap;
/*     */         }
/* 284 */         paramg.a(this, o.f, null, new Object[0]);
/*     */       } 
/* 286 */       str = paraml.v();
/*     */     } 
/*     */     String str;
/* 289 */     for (; str != null; str = paraml.h()) {
/*     */       
/* 291 */       Enum enum_ = (Enum)this.f.a(str, paramg);
/* 292 */       Object object = paraml.g();
/* 293 */       if (enum_ == null) {
/* 294 */         if (!paramg.a(i.w)) {
/* 295 */           return (EnumMap<?, ?>)paramg.b(this.a, str, "value not one of declared Enum instance names for %s", new Object[] { this.b
/*     */                 
/* 297 */                 .t() });
/*     */         }
/*     */ 
/*     */         
/* 301 */         paraml.j();
/*     */ 
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 310 */         if (object == o.m) {
/* 311 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 314 */           Object object1 = this.c.a(paramg);
/* 315 */         } else if (e1 == null) {
/* 316 */           Object object1 = k1.a(paraml, paramg);
/*     */         } else {
/* 318 */           object = k1.a(paraml, paramg, e1);
/*     */         } 
/* 320 */       } catch (Exception exception) {
/* 321 */         return (EnumMap<?, ?>)a(paramg, exception, paramEnumMap, str);
/*     */       } 
/* 323 */       paramEnumMap.put(enum_, object); continue;
/*     */     } 
/* 325 */     return paramEnumMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 334 */     return parame.a(paraml, paramg);
/*     */   }
/*     */   
/*     */   private EnumMap<?, ?> k(g paramg) {
/* 338 */     if (this.i == null) {
/* 339 */       return new EnumMap<>(this.a);
/*     */     }
/*     */     try {
/* 342 */       if (!this.i.l()) {
/* 343 */         return (EnumMap<?, ?>)paramg.a(a(), 
/* 344 */             i(), null, "no default constructor found", new Object[0]);
/*     */       }
/*     */       
/* 347 */       return (EnumMap<?, ?>)this.i.a(paramg);
/* 348 */     } catch (IOException iOException) {
/* 349 */       return (EnumMap<?, ?>)i.a(paramg, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumMap<?, ?> e(l paraml, g paramg) {
/*     */     v v1;
/* 357 */     y y = (v1 = this.k).a(paraml, paramg, null);
/*     */ 
/*     */     
/* 360 */     if (paraml.q()) {
/* 361 */       str = paraml.h();
/* 362 */     } else if (paraml.a(o.f)) {
/* 363 */       str = paraml.v();
/*     */     } else {
/* 365 */       str = null;
/*     */     } 
/*     */     String str;
/* 368 */     for (; str != null; str = paraml.h()) {
/* 369 */       Object object; o o = paraml.g();
/*     */       
/*     */       v v2;
/* 372 */       if ((v2 = v1.a(str)) != null) {
/*     */         
/* 374 */         if (y.a(v2, v2.a(paraml, paramg))) {
/* 375 */           EnumMap enumMap; paraml.g();
/*     */           
/*     */           try {
/* 378 */             enumMap = (EnumMap)v1.a(paramg, y);
/* 379 */           } catch (Exception null) {
/* 380 */             return (EnumMap<?, ?>)a(paramg, (Throwable)object, this.b.b(), str);
/*     */           } 
/* 382 */           return a(paraml, paramg, enumMap);
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       Enum enum_;
/* 389 */       if ((enum_ = (Enum)this.f.a(str, paramg)) == null) {
/* 390 */         if (!paramg.a(i.w)) {
/* 391 */           return (EnumMap<?, ?>)paramg.b(this.a, str, "value not one of declared Enum instance names for %s", new Object[] { this.b
/*     */                 
/* 393 */                 .t() });
/*     */         }
/*     */ 
/*     */         
/* 397 */         paraml.g();
/* 398 */         paraml.j();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       try {
/* 404 */         if (object == o.m) {
/* 405 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 408 */           Object object1 = this.c.a(paramg);
/* 409 */         } else if (this.h == null) {
/* 410 */           Object object1 = this.g.a(paraml, paramg);
/*     */         } else {
/* 412 */           object = this.g.a(paraml, paramg, this.h);
/*     */         } 
/* 414 */       } catch (Exception exception) {
/* 415 */         a(paramg, exception, this.b.b(), str);
/* 416 */         return null;
/*     */       } 
/* 418 */       y.a(enum_, object);
/*     */       
/*     */       continue;
/*     */     } 
/*     */     try {
/* 423 */       return (EnumMap<?, ?>)v1.a(paramg, y);
/* 424 */     } catch (Exception exception) {
/* 425 */       a(paramg, exception, this.b.b(), str);
/* 426 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */