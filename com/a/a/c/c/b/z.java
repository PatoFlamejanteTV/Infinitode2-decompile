/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.b.b;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.a;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.a;
/*     */ import com.a.a.c.m.f;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class z
/*     */   extends i<Object[]>
/*     */   implements k
/*     */ {
/*     */   private boolean a;
/*     */   private Class<?> f;
/*     */   private k<Object> g;
/*     */   private e h;
/*     */   private Object[] i;
/*     */   
/*     */   public z(j paramj, k<Object> paramk, e parame) {
/*  72 */     super(paramj, (s)null, (Boolean)null);
/*  73 */     a a = (a)paramj;
/*  74 */     this.f = a.u().b();
/*  75 */     this.a = (this.f == Object.class);
/*  76 */     this.g = paramk;
/*  77 */     this.h = parame;
/*  78 */     this.i = a.H();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private z(z paramz, k<Object> paramk, e parame, s params, Boolean paramBoolean) {
/*  85 */     super(paramz, params, paramBoolean);
/*  86 */     this.f = paramz.f;
/*  87 */     this.a = paramz.a;
/*  88 */     this.i = paramz.i;
/*     */     
/*  90 */     this.g = paramk;
/*  91 */     this.h = parame;
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
/*     */   private z a(e parame, k<?> paramk, s params, Boolean paramBoolean) {
/* 111 */     if (Objects.equals(paramBoolean, this.e) && params == this.c && paramk == this.g && parame == this.h)
/*     */     {
/*     */       
/* 114 */       return this;
/*     */     }
/* 116 */     return new z(this, (k)paramk, parame, params, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 125 */     return (this.g == null && this.h == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 130 */     return f.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/* 137 */     k<Object> k1 = this.g;
/*     */ 
/*     */ 
/*     */     
/* 141 */     Boolean bool = a(paramg, paramc, this.b.b(), l.a.a);
/*     */ 
/*     */     
/* 144 */     k1 = (k)a(paramg, paramc, k1);
/* 145 */     j j = this.b.u();
/* 146 */     if (k1 == null) {
/* 147 */       k1 = paramg.a(j, paramc);
/*     */     } else {
/* 149 */       k1 = paramg.b(k1, paramc, j);
/*     */     } 
/*     */     e e1;
/* 152 */     if ((e1 = this.h) != null) {
/* 153 */       e1 = e1.a(paramc);
/*     */     }
/* 155 */     s s = b(paramg, paramc, k1);
/* 156 */     return a(e1, k1, s, bool);
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
/* 167 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 173 */     return a.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object c(g paramg) {
/* 181 */     return this.i;
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
/*     */   private Object[] c(l paraml, g paramg) {
/*     */     Object object;
/* 195 */     if (!paraml.p()) {
/* 196 */       return f(paraml, paramg);
/*     */     }
/*     */     
/*     */     f f;
/* 200 */     Object[] arrayOfObject = (f = paramg.n()).a();
/* 201 */     byte b = 0;
/*     */     
/* 203 */     e e1 = this.h;
/*     */     try {
/*     */       o o;
/* 206 */       while ((o = paraml.g()) != o.e) {
/*     */ 
/*     */ 
/*     */         
/* 210 */         if (o == o.m) {
/* 211 */           if (!this.d)
/*     */           
/*     */           { 
/* 214 */             object = this.c.a(paramg); } else { continue; } 
/* 215 */         } else if (e1 == null) {
/* 216 */           object = this.g.a(paraml, paramg);
/*     */         } else {
/* 218 */           object = this.g.a(paraml, paramg, e1);
/*     */         } 
/* 220 */         if (b >= arrayOfObject.length) {
/* 221 */           arrayOfObject = f.a(arrayOfObject);
/* 222 */           b = 0;
/*     */         } 
/* 224 */         arrayOfObject[b++] = object;
/*     */       } 
/* 226 */     } catch (Exception exception) {
/* 227 */       throw l.a(object = null, arrayOfObject, f.c() + b);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 232 */     if (this.a) {
/* 233 */       object = f.b(arrayOfObject, b);
/*     */     } else {
/* 235 */       object = f.a(arrayOfObject, b, this.f);
/*     */     } 
/* 237 */     paramg.a(f);
/* 238 */     return (Object[])object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object[] c(l paraml, g paramg, e parame) {
/* 248 */     return (Object[])parame.b(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object[] a(l paraml, g paramg, Object[] paramArrayOfObject) {
/* 255 */     if (!paraml.p()) {
/*     */       Object[] arrayOfObject1;
/* 257 */       if ((arrayOfObject1 = f(paraml, paramg)) == null) {
/* 258 */         return paramArrayOfObject;
/*     */       }
/*     */       int m;
/* 261 */       Object[] arrayOfObject2 = new Object[(m = paramArrayOfObject.length) + arrayOfObject1.length];
/* 262 */       System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, m);
/* 263 */       System.arraycopy(arrayOfObject1, 0, arrayOfObject2, m, arrayOfObject1.length);
/* 264 */       return arrayOfObject2;
/*     */     } 
/*     */     
/* 267 */     f f = paramg.n();
/* 268 */     int j = paramArrayOfObject.length;
/* 269 */     Object[] arrayOfObject = f.a(paramArrayOfObject, j);
/*     */     
/* 271 */     e e1 = this.h;
/*     */     try {
/*     */       o o;
/* 274 */       while ((o = paraml.g()) != o.e) {
/*     */         Object object;
/*     */         
/* 277 */         if (o == o.m) {
/* 278 */           if (!this.d)
/*     */           
/*     */           { 
/* 281 */             object = this.c.a(paramg); } else { continue; } 
/* 282 */         } else if (e1 == null) {
/* 283 */           object = this.g.a(paraml, paramg);
/*     */         } else {
/* 285 */           object = this.g.a(paraml, paramg, e1);
/*     */         } 
/* 287 */         if (j >= arrayOfObject.length) {
/* 288 */           arrayOfObject = f.a(arrayOfObject);
/* 289 */           j = 0;
/*     */         } 
/* 291 */         arrayOfObject[j++] = object;
/*     */       } 
/* 293 */     } catch (Exception exception) {
/* 294 */       throw l.a(paramArrayOfObject = null, arrayOfObject, f.c() + j);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 299 */     if (this.a) {
/* 300 */       paramArrayOfObject = f.b(arrayOfObject, j);
/*     */     } else {
/* 302 */       paramArrayOfObject = f.a(arrayOfObject, j, this.f);
/*     */     } 
/* 304 */     paramg.a(f);
/* 305 */     return paramArrayOfObject;
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
/*     */   private static Byte[] e(l paraml, g paramg) {
/*     */     byte[] arrayOfByte;
/* 320 */     Byte[] arrayOfByte1 = new Byte[(arrayOfByte = paraml.a(paramg.k())).length]; byte b; int j;
/* 321 */     for (b = 0, j = arrayOfByte.length; b < j; b++) {
/* 322 */       arrayOfByte1[b] = Byte.valueOf(arrayOfByte[b]);
/*     */     }
/* 324 */     return arrayOfByte1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object[] f(l paraml, g paramg) {
/*     */     Object object, arrayOfObject[];
/*     */     boolean bool;
/* 334 */     if (!(bool = (this.e == Boolean.TRUE || (this.e == null && paramg.a(i.p))) ? true : false)) {
/*     */       
/* 336 */       if (paraml.a(o.h)) {
/*     */ 
/*     */         
/* 339 */         if (this.f == Byte.class) {
/* 340 */           return (Object[])e(paraml, paramg);
/*     */         }
/*     */         
/* 343 */         return m(paraml, paramg);
/*     */       } 
/* 345 */       return (Object[])paramg.a(this.b, paraml);
/*     */     } 
/*     */ 
/*     */     
/* 349 */     if (paraml.a(o.m)) {
/*     */       
/* 351 */       if (this.d) {
/* 352 */         return this.i;
/*     */       }
/* 354 */       object = this.c.a(paramg);
/*     */     } else {
/* 356 */       if (object.a(o.h)) {
/*     */         b b;
/*     */         String str;
/* 359 */         if ((str = object.w()).isEmpty()) {
/*     */ 
/*     */           
/* 362 */           if ((b = paramg.a(b(), a(), f.f)) != b.a) {
/* 363 */             return (Object[])a(paramg, b, a());
/*     */           }
/*     */         }
/* 366 */         else if (h((String)b) && (
/*     */ 
/*     */           
/* 369 */           b = paramg.a(b(), a(), b.a)) != b.a) {
/* 370 */           return (Object[])a(paramg, b, a());
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 377 */       if (this.h == null) {
/* 378 */         object = this.g.a((l)object, paramg);
/*     */       } else {
/* 380 */         object = this.g.a((l)object, paramg, this.h);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 386 */     if (this.a) {
/* 387 */       arrayOfObject = new Object[1];
/*     */     } else {
/* 389 */       arrayOfObject = (Object[])Array.newInstance(this.f, 1);
/*     */     } 
/* 391 */     arrayOfObject[0] = object;
/* 392 */     return arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */