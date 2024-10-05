/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.z;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.w;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class h
/*     */   extends i<Collection<Object>>
/*     */   implements k
/*     */ {
/*     */   private k<Object> f;
/*     */   private e g;
/*     */   protected final x a;
/*     */   private k<Object> h;
/*     */   
/*     */   public h(j paramj, k<Object> paramk, e parame, x paramx) {
/*  74 */     this(paramj, paramk, parame, paramx, (k<Object>)null, (s)null, (Boolean)null);
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
/*     */   protected h(j paramj, k<Object> paramk1, e parame, x paramx, k<Object> paramk2, s params, Boolean paramBoolean) {
/*  87 */     super(paramj, params, paramBoolean);
/*  88 */     this.f = paramk1;
/*  89 */     this.g = parame;
/*  90 */     this.a = paramx;
/*  91 */     this.h = paramk2;
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
/*     */   protected h a(k<?> paramk1, k<?> paramk2, e parame, s params, Boolean paramBoolean) {
/* 117 */     return new h(this.b, (k)paramk2, parame, this.a, (k)paramk1, params, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 127 */     return (this.f == null && this.g == null && this.h == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f b() {
/* 135 */     return f.b;
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
/*     */   private h c(g paramg, c paramc) {
/* 154 */     k<Object> k1 = null;
/* 155 */     if (this.a != null) {
/* 156 */       if (this.a.m()) {
/* 157 */         paramg.c(); j j1;
/* 158 */         if ((j1 = this.a.p()) == null) {
/* 159 */           paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[] { this.b, this.a
/*     */ 
/*     */                   
/* 162 */                   .getClass().getName() }));
/*     */         }
/* 164 */         k1 = a(paramg, j1, paramc);
/* 165 */       } else if (this.a.n()) {
/* 166 */         paramg.c(); j j1;
/* 167 */         if ((j1 = this.a.q()) == null) {
/* 168 */           paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[] { this.b, this.a
/*     */ 
/*     */                   
/* 171 */                   .getClass().getName() }));
/*     */         }
/* 173 */         k1 = a(paramg, j1, paramc);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 179 */     Boolean bool = a(paramg, paramc, Collection.class, l.a.a);
/*     */ 
/*     */     
/* 182 */     k<Object> k2 = this.f;
/*     */ 
/*     */     
/* 185 */     k2 = (k)a(paramg, paramc, k2);
/* 186 */     j j = this.b.u();
/* 187 */     if (k2 == null) {
/* 188 */       k2 = paramg.a(j, paramc);
/*     */     } else {
/* 190 */       k2 = paramg.b(k2, paramc, j);
/*     */     } 
/*     */     
/*     */     e e1;
/* 194 */     if ((e1 = this.g) != null) {
/* 195 */       e1 = e1.a(paramc);
/*     */     }
/* 197 */     s s = b(paramg, paramc, k2);
/* 198 */     if (!Objects.equals(bool, this.e) || s != this.c || k1 != this.h || k2 != this.f || e1 != this.g)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 204 */       return a(k1, k2, e1, s, bool);
/*     */     }
/*     */     
/* 207 */     return this;
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
/* 218 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final x i() {
/* 223 */     return this.a;
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
/*     */   private Collection<Object> c(l paraml, g paramg) {
/* 237 */     if (this.h != null) {
/* 238 */       return (Collection<Object>)this.a.a(paramg, this.h
/* 239 */           .a(paraml, paramg));
/*     */     }
/*     */ 
/*     */     
/* 243 */     if (paraml.p()) {
/* 244 */       return a(paraml, paramg, d(paramg));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 249 */     if (paraml.a(o.h)) {
/* 250 */       return a(paraml, paramg, paraml.w());
/*     */     }
/* 252 */     return c(paraml, paramg, d(paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<Object> d(g paramg) {
/* 262 */     return (Collection<Object>)this.a.a(paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<Object> b(l paraml, g paramg, Collection<Object> paramCollection) {
/* 271 */     if (paraml.p()) {
/* 272 */       return a(paraml, paramg, paramCollection);
/*     */     }
/* 274 */     return c(paraml, paramg, paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(l paraml, g paramg, e parame) {
/* 283 */     return parame.b(paraml, paramg);
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
/*     */   private Collection<Object> a(l paraml, g paramg, String paramString) {
/*     */     com.a.a.c.b.b b;
/* 296 */     Class<?> clazz = a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     if (paramString.isEmpty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 311 */       if ((b = paramg.a(b(), clazz, f.f)) != null && b != com.a.a.c.b.b.a) {
/* 312 */         return (Collection<Object>)a(paramg, b, clazz);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 320 */     else if (h((String)b) && (
/*     */ 
/*     */       
/* 323 */       b = paramg.a(b(), clazz, com.a.a.c.b.b.a)) != com.a.a.c.b.b.a) {
/* 324 */       return (Collection<Object>)a(paramg, b, clazz);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 330 */     return c(paraml, paramg, d(paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<Object> a(l paraml, g paramg, Collection<Object> paramCollection) {
/* 341 */     paraml.a(paramCollection);
/*     */     
/*     */     k<Object> k1;
/*     */     
/* 345 */     if ((k1 = this.f).f() != null) {
/* 346 */       return d(paraml, paramg, paramCollection);
/*     */     }
/* 348 */     e e1 = this.g;
/*     */     o o;
/* 350 */     while ((o = paraml.g()) != o.e) {
/*     */       try {
/*     */         Object object;
/* 353 */         if (o == o.m) {
/* 354 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 357 */           object = this.c.a(paramg);
/* 358 */         } else if (e1 == null) {
/* 359 */           object = k1.a(paraml, paramg);
/*     */         } else {
/* 361 */           object = k1.a(paraml, paramg, e1);
/*     */         } 
/* 363 */         paramCollection.add(object);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 370 */       catch (Exception exception) {
/*     */         boolean bool;
/* 372 */         if (!(bool = (paramg == null || paramg.a(i.o)) ? true : false)) {
/* 373 */           i.b(exception);
/*     */         }
/* 375 */         throw l.a(exception, paramCollection, paramCollection.size());
/*     */       } 
/*     */     } 
/* 378 */     return paramCollection;
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
/*     */   private Collection<Object> c(l paraml, g paramg, Collection<Object> paramCollection) {
/*     */     boolean bool;
/* 395 */     if (!(bool = (this.e == Boolean.TRUE || (this.e == null && paramg.a(i.p))) ? true : false)) {
/* 396 */       return (Collection<Object>)paramg.a(this.b, paraml);
/*     */     }
/* 398 */     k<Object> k1 = this.f;
/* 399 */     e e1 = this.g;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 404 */       if (paraml.a(o.m)) {
/*     */         
/* 406 */         if (this.d) {
/* 407 */           return paramCollection;
/*     */         }
/* 409 */         object = this.c.a(paramg);
/* 410 */       } else if (e1 == null) {
/* 411 */         object = k1.a((l)object, paramg);
/*     */       } else {
/* 413 */         object = k1.a((l)object, paramg, e1);
/*     */       } 
/* 415 */     } catch (Exception object) {
/*     */       boolean bool1;
/* 417 */       if (!(bool1 = paramg.a(i.o))) {
/* 418 */         i.b((Throwable)object);
/*     */       }
/*     */       
/* 421 */       throw l.a(object, Object.class, paramCollection.size());
/*     */     } 
/* 423 */     paramCollection.add(object);
/* 424 */     return paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<Object> d(l paraml, g paramg, Collection<Object> paramCollection) {
/* 432 */     if (!paraml.p()) {
/* 433 */       return c(paraml, paramg, paramCollection);
/*     */     }
/*     */     
/* 436 */     paraml.a(paramCollection);
/*     */     
/* 438 */     k<Object> k1 = this.f;
/* 439 */     e e1 = this.g;
/*     */     
/* 441 */     b b = new b(this.b.u().b(), paramCollection);
/*     */     
/*     */     o o;
/* 444 */     while ((o = paraml.g()) != o.e) {
/*     */       try {
/*     */         Object object;
/* 447 */         if (o == o.m) {
/* 448 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 451 */           object = this.c.a(paramg);
/* 452 */         } else if (e1 == null) {
/* 453 */           object = k1.a(paraml, paramg);
/*     */         } else {
/* 455 */           object = k1.a(paraml, paramg, e1);
/*     */         } 
/* 457 */         b.a(object);
/* 458 */       } catch (w w) {
/* 459 */         z.a a = b.a(w);
/* 460 */         w.d().a(a);
/* 461 */       } catch (Exception exception) {
/*     */         boolean bool;
/* 463 */         if (!(bool = (paramg == null || paramg.a(i.o)) ? true : false)) {
/* 464 */           i.b(exception);
/*     */         }
/* 466 */         throw l.a(exception, paramCollection, paramCollection.size());
/*     */       } 
/*     */     } 
/* 469 */     return paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */   {
/*     */     private final Class<?> a;
/*     */ 
/*     */     
/*     */     private final Collection<Object> b;
/*     */ 
/*     */     
/* 483 */     private List<h.a> c = new ArrayList<>();
/*     */     
/*     */     public b(Class<?> param1Class, Collection<Object> param1Collection) {
/* 486 */       this.a = param1Class;
/* 487 */       this.b = param1Collection;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object) {
/* 492 */       if (this.c.isEmpty()) {
/* 493 */         this.b.add(param1Object); return;
/*     */       } 
/*     */       h.a a;
/* 496 */       (a = this.c.get(this.c.size() - 1)).a.add(param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final z.a a(w param1w) {
/* 502 */       h.a a = new h.a(this, param1w, this.a);
/* 503 */       this.c.add(a);
/* 504 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 509 */       Iterator<h.a> iterator = this.c.iterator();
/*     */ 
/*     */ 
/*     */       
/* 513 */       Collection<Object> collection = this.b;
/* 514 */       while (iterator.hasNext()) {
/*     */         h.a a;
/* 516 */         if ((a = iterator.next()).b(param1Object1)) {
/* 517 */           iterator.remove();
/* 518 */           collection.add(param1Object2);
/* 519 */           collection.addAll(a.a);
/*     */           return;
/*     */         } 
/* 522 */         collection = a.a;
/*     */       } 
/*     */       
/* 525 */       throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + param1Object1 + "] that wasn't previously seen as unresolved.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends z.a
/*     */   {
/*     */     private final h.b b;
/*     */ 
/*     */     
/* 537 */     public final List<Object> a = new ArrayList();
/*     */ 
/*     */ 
/*     */     
/*     */     a(h.b param1b, w param1w, Class<?> param1Class) {
/* 542 */       super(param1w, param1Class);
/* 543 */       this.b = param1b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 548 */       this.b.a(param1Object1, param1Object2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */