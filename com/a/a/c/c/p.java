/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c.b.ad;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.a;
/*     */ import com.a.a.c.l.d;
/*     */ import com.a.a.c.l.e;
/*     */ import com.a.a.c.l.g;
/*     */ import com.a.a.c.l.h;
/*     */ import com.a.a.c.l.j;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.m.o;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class p
/*     */   implements Serializable
/*     */ {
/*     */   private o<j, k<Object>> a;
/*  44 */   private HashMap<j, k<Object>> b = new HashMap<>(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p() {
/*  54 */     this(2000);
/*     */   }
/*     */   
/*     */   private p(int paramInt) {
/*  58 */     paramInt = Math.min(64, 500);
/*  59 */     this.a = new o(paramInt, 2000);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object> a(g paramg, q paramq, j paramj) {
/*     */     k<Object> k;
/* 140 */     if ((k = a(paramj)) == null)
/*     */     {
/*     */       
/* 143 */       if ((k = c(paramg, paramq, paramj)) == null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 148 */         k = a(paramg, paramj);
/*     */       }
/*     */     }
/* 151 */     return k;
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
/*     */   public final com.a.a.c.p b(g paramg, q paramq, j paramj) {
/*     */     com.a.a.c.p p1;
/* 167 */     if ((p1 = paramq.a(paramg, paramj)) == null) {
/* 168 */       return b(paramg, paramj);
/*     */     }
/*     */     
/* 171 */     if (p1 instanceof t) {
/* 172 */       ((t)p1).d(paramg);
/*     */     }
/* 174 */     return p1;
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
/*     */   private k<Object> a(j paramj) {
/* 204 */     if (paramj == null) {
/* 205 */       throw new IllegalArgumentException("Null JavaType passed");
/*     */     }
/* 207 */     if (b(paramj)) {
/* 208 */       return null;
/*     */     }
/* 210 */     return (k<Object>)this.a.a(paramj);
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
/*     */   private k<Object> c(g paramg, q paramq, j paramj) {
/* 228 */     synchronized (this.b) {
/*     */       k<Object> k;
/*     */       
/* 231 */       if ((k = a(paramj)) != null) {
/* 232 */         return k;
/*     */       }
/*     */       
/*     */       int i;
/* 236 */       if ((i = this.b.size()) > 0 && (
/*     */         
/* 238 */         k = this.b.get(paramj)) != null) {
/* 239 */         return k;
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 244 */         return d(paramg, paramq, paramj);
/*     */       } finally {
/*     */         
/* 247 */         if (i == 0 && this.b.size() > 0) {
/* 248 */           this.b.clear();
/*     */         }
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
/*     */   private k<Object> d(g paramg, q paramq, j paramj) {
/*     */     try {
/* 264 */       k<Object> k = e(paramg, paramq, paramj);
/* 265 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 268 */       paramg.a(paramj, i.g(illegalArgumentException));
/* 269 */       paramq = null;
/*     */     } 
/* 271 */     if (paramq == null) {
/* 272 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     boolean bool = (!b(paramj) && paramq.c()) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     if (paramq instanceof t) {
/* 293 */       this.b.put(paramj, paramq);
/* 294 */       ((t)paramq).d(paramg);
/* 295 */       this.b.remove(paramj);
/*     */     } 
/* 297 */     if (bool) {
/* 298 */       this.a.a(paramj, paramq);
/*     */     }
/* 300 */     return (k<Object>)paramq;
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
/*     */   private k<Object> e(g paramg, q paramq, j paramj) {
/* 319 */     f f = paramg.c();
/*     */ 
/*     */     
/* 322 */     if (paramj.d() || paramj.p() || paramj.o()) {
/* 323 */       paramj = paramq.a(f, paramj);
/*     */     }
/* 325 */     b b = f.a(paramj);
/*     */     
/*     */     k<Object> k1;
/*     */     
/* 329 */     if ((k1 = a(paramg, (b)b.d())) != null) {
/* 330 */       return k1;
/*     */     }
/*     */     
/*     */     j j1;
/*     */     
/* 335 */     if ((j1 = a(paramg, (b)b.d(), paramj)) != paramj) {
/* 336 */       paramj = j1;
/* 337 */       b = f.a(j1);
/*     */     } 
/*     */     
/*     */     Class<?> clazz;
/*     */     
/* 342 */     if ((clazz = b.w()) != null) {
/* 343 */       return paramq.a(paramg, paramj, b, clazz);
/*     */     }
/*     */ 
/*     */     
/*     */     k k;
/*     */     
/* 349 */     if ((k = b.u()) == null) {
/* 350 */       return (k)a(paramg, paramq, paramj, b);
/*     */     }
/*     */     
/* 353 */     paramg.b();
/*     */     j j2;
/* 355 */     if (!(j2 = k.a()).a(paramj.b())) {
/* 356 */       b = f.a(j2);
/*     */     }
/* 358 */     return (k<Object>)new ad(k, j2, 
/* 359 */         a(paramg, paramq, j2, b));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static k<?> a(g paramg, q paramq, j paramj, b paramb) {
/*     */     d d;
/* 366 */     f f = paramg.c();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 371 */     if (paramj.h()) {
/* 372 */       return paramq.a(paramg, paramj, paramb);
/*     */     }
/* 374 */     if (paramj.n()) {
/* 375 */       g g1; if (paramj.g()) {
/* 376 */         return paramq.a(paramg, (a)paramj, paramb);
/*     */       }
/* 378 */       if (paramj.p()) {
/*     */         l.d d1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 385 */         if ((d1 = paramb.a(null)).c() != l.c.e) {
/*     */           
/* 387 */           if (g1 = (g)paramj instanceof h) {
/* 388 */             return paramq.a(paramg, (h)g1, paramb);
/*     */           }
/* 390 */           return paramq.a(paramg, g1, paramb);
/*     */         } 
/*     */       } 
/* 393 */       if (g1.o()) {
/*     */         l.d d1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 400 */         if ((d1 = paramb.a(null)).c() != l.c.e) {
/*     */           
/* 402 */           if (d = (d)g1 instanceof e) {
/* 403 */             return paramq.a(paramg, (e)d, paramb);
/*     */           }
/* 405 */           return paramq.a(paramg, d, paramb);
/*     */         } 
/*     */       } 
/*     */     } 
/* 409 */     if (d.F()) {
/* 410 */       return paramq.a(paramg, (j)d, paramb);
/*     */     }
/* 412 */     if (m.class.isAssignableFrom(d.b())) {
/* 413 */       return paramq.a(f, (j)d, paramb);
/*     */     }
/* 415 */     return paramq.c(paramg, (j)d, paramb);
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
/*     */   private k<Object> a(g paramg, b paramb) {
/*     */     Object object;
/* 428 */     if ((object = paramg.f().z(paramb)) == null) {
/* 429 */       return null;
/*     */     }
/* 431 */     object = paramg.b(paramb, object);
/*     */     
/* 433 */     return a(paramg, paramb, (k<Object>)object);
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
/*     */   private k<Object> a(g paramg, b paramb, k<Object> paramk) {
/*     */     k<Object, Object> k1;
/* 447 */     if ((k1 = b(paramg, paramb)) == null) {
/* 448 */       return paramk;
/*     */     }
/* 450 */     paramg.b(); j j = k1.a();
/* 451 */     return (k<Object>)new ad(k1, j, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static k<Object, Object> b(g paramg, b paramb) {
/*     */     Object object;
/* 459 */     if ((object = paramg.f().C(paramb)) == null) {
/* 460 */       return null;
/*     */     }
/* 462 */     return paramg.a(paramb, object);
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
/*     */   private j a(g paramg, b paramb, j paramj) {
/*     */     g g1;
/*     */     a a;
/* 485 */     if ((a = paramg.f()) == null) {
/* 486 */       return paramj;
/*     */     }
/*     */     
/*     */     Object<?> object;
/*     */     j j2;
/*     */     com.a.a.c.p p1;
/* 492 */     if (paramj.p() && (
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 497 */       j2 = paramj.t()) != null && j2.A() == null && (
/*     */       
/* 499 */       object = (Object<?>)a.A(paramb)) != null && (
/*     */       
/* 501 */       p1 = paramg.c(paramb, object)) != null) {
/* 502 */       g1 = ((g)paramj).i(p1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 509 */     if ((object = (Object<?>)g1.u()) != null && 
/* 510 */       object.A() == null && (
/*     */       
/* 512 */       object = (Object<?>)a.B(paramb)) != null) {
/* 513 */       k k; p1 = null;
/* 514 */       if (object instanceof k) {
/* 515 */         k = (k)object;
/*     */       
/*     */       }
/* 518 */       else if ((object = (Object<?>)a(object, "findContentDeserializer", k.a.class)) != null) {
/* 519 */         k = paramg.b(paramb, object);
/*     */       } 
/*     */       
/* 522 */       if (k != null) {
/* 523 */         j1 = g1.d(k);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     j j1;
/*     */ 
/*     */ 
/*     */     
/* 533 */     return j1 = a.b((q)paramg.c(), paramb, j1);
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
/*     */   private static boolean b(j paramj) {
/* 549 */     if (paramj.n()) {
/*     */       j j1;
/*     */       
/* 552 */       if ((j1 = paramj.u()) != null && (
/* 553 */         j1.A() != null || j1.B() != null)) {
/* 554 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 558 */       if (paramj.p() && (
/*     */         
/* 560 */         paramj = paramj.t()).A() != null) {
/* 561 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 565 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Class<?> a(Object paramObject, String paramString, Class<?> paramClass) {
/* 570 */     if (paramObject == null) {
/* 571 */       return null;
/*     */     }
/* 573 */     if (!(paramObject instanceof Class)) {
/* 574 */       throw new IllegalStateException("AnnotationIntrospector." + paramString + "() returned value of type " + paramObject.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
/*     */     }
/*     */     
/* 577 */     if ((paramObject = paramObject) == paramClass || i.e((Class)paramObject)) {
/* 578 */       return null;
/*     */     }
/* 580 */     return (Class<?>)paramObject;
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
/*     */   private static k<Object> a(g paramg, j paramj) {
/*     */     Class clazz;
/* 594 */     if (!i.d(clazz = paramj.b())) {
/* 595 */       return (k<Object>)paramg.a(paramj, "Cannot find a Value deserializer for abstract type " + paramj);
/*     */     }
/* 597 */     return (k<Object>)paramg.a(paramj, "Cannot find a Value deserializer for type " + paramj);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static com.a.a.c.p b(g paramg, j paramj) {
/* 603 */     return (com.a.a.c.p)paramg.a(paramj, "Cannot find a (Map) Key deserializer for type " + paramj);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */