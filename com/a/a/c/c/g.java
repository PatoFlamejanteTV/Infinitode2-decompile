/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.e;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c.a.ae;
/*     */ import com.a.a.c.c.a.c;
/*     */ import com.a.a.c.c.a.s;
/*     */ import com.a.a.c.c.a.u;
/*     */ import com.a.a.c.e;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.v;
/*     */ import com.a.a.c.w;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*     */   private f a;
/*     */   private com.a.a.c.g b;
/*     */   private b c;
/*  57 */   private Map<String, v> d = new LinkedHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ae> e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HashMap<String, v> f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HashSet<String> g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HashSet<String> h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private x i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private s j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private u k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(b paramb, com.a.a.c.g paramg) {
/* 126 */     this.c = paramb;
/* 127 */     this.b = paramg;
/* 128 */     this.a = paramg.c();
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
/*     */   public final void a(v paramv) {
/* 177 */     this.d.put(paramv.a(), paramv);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(v paramv) {
/*     */     v v1;
/* 188 */     if ((v1 = this.d.put(paramv.a(), paramv)) != null && v1 != paramv) {
/* 189 */       throw new IllegalArgumentException("Duplicate property '" + paramv.a() + "' for " + this.c.a());
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
/*     */   public final void a(String paramString, v paramv) {
/* 201 */     if (this.f == null) {
/* 202 */       this.f = new HashMap<>(4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 207 */     if (this.a.g()) {
/*     */       try {
/* 209 */         paramv.a(this.a);
/* 210 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 211 */         a(illegalArgumentException);
/*     */       } 
/*     */     }
/* 214 */     this.f.put(paramString, paramv);
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
/*     */   public final void a(w paramw, j paramj, j paramj1, Object paramObject) {
/* 231 */     if (this.e == null) {
/* 232 */       this.e = new ArrayList<>();
/*     */     }
/* 234 */     if (this.a.g()) {
/*     */       try {
/* 236 */         paramj1.a(this.a.a(q.o));
/* 237 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 238 */         a(illegalArgumentException);
/*     */       } 
/*     */     }
/* 241 */     this.e.add(new ae(paramw, paramj, paramj1, paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 250 */     if (this.g == null) {
/* 251 */       this.g = new HashSet<>();
/*     */     }
/* 253 */     this.g.add(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/* 263 */     if (this.h == null) {
/* 264 */       this.h = new HashSet<>();
/*     */     }
/* 266 */     this.h.add(paramString);
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
/*     */   public final void c(v paramv) {
/* 281 */     b(paramv);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(u paramu) {
/* 286 */     if (this.k != null && paramu != null) {
/* 287 */       throw new IllegalStateException("_anySetter already set to non-null");
/*     */     }
/* 289 */     this.k = paramu;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 293 */     this.l = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void a(x paramx) {
/* 297 */     this.i = paramx;
/*     */   }
/*     */   
/*     */   public final void a(s params) {
/* 301 */     this.j = params;
/*     */   }
/*     */   
/*     */   public final void a(k paramk, e.a parama) {
/* 305 */     this.m = paramk;
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
/*     */   public final Iterator<v> a() {
/* 324 */     return this.d.values().iterator();
/*     */   }
/*     */   
/*     */   public final v a(w paramw) {
/* 328 */     return this.d.get(paramw.b());
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
/*     */   public final u b() {
/* 340 */     return this.k;
/*     */   }
/*     */   
/*     */   public final x c() {
/* 344 */     return this.i;
/*     */   }
/*     */   
/*     */   public final List<ae> d() {
/* 348 */     return this.e;
/*     */   }
/*     */   
/*     */   public final s e() {
/* 352 */     return this.j;
/*     */   }
/*     */   
/*     */   public final k f() {
/* 356 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c(String paramString) {
/* 367 */     return n.a(paramString, this.g, this.h);
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
/*     */   public final k<?> g() {
/* 383 */     Collection<v> collection = this.d.values();
/* 384 */     a(collection);
/*     */     
/*     */     c c;
/*     */     
/* 388 */     (c = c.a((q)this.a, collection, b(collection), i())).a();
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 394 */     if (!(bool = !this.a.a(q.s) ? true : false)) {
/* 395 */       for (Iterator<v> iterator = collection.iterator(); iterator.hasNext();) {
/* 396 */         if ((v = iterator.next()).s()) {
/* 397 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 404 */     if (this.j != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 409 */       u u1 = new u(this.j, v.a);
/* 410 */       c = c.a((v)u1);
/*     */     } 
/*     */     
/* 413 */     return (k<?>)new d(this, this.c, c, this.f, this.g, this.l, this.h, bool);
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
/*     */   public final a h() {
/* 426 */     return new a(this, this.c, this.f, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(j paramj, String paramString) {
/* 437 */     if (this.m == null) {
/*     */       
/* 439 */       if (!paramString.isEmpty()) {
/* 440 */         this.b.a(this.c.a(), 
/* 441 */             String.format("Builder class %s does not have build method (name: '%s')", new Object[] {
/* 442 */                 i.b(this.c.a()), paramString
/*     */               }));
/*     */       }
/*     */     } else {
/*     */       
/* 447 */       Class<?> clazz1 = this.m.m();
/* 448 */       Class<?> clazz2 = paramj.b();
/* 449 */       if (clazz1 != clazz2 && 
/* 450 */         !clazz1.isAssignableFrom(clazz2) && 
/* 451 */         !clazz2.isAssignableFrom(clazz1)) {
/* 452 */         this.b.a(this.c.a(), 
/* 453 */             String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", new Object[] {
/* 454 */                 this.m.j(), 
/* 455 */                 i.c(clazz1), 
/* 456 */                 i.b(paramj)
/*     */               }));
/*     */       }
/*     */     } 
/* 460 */     Collection<v> collection = this.d.values();
/* 461 */     a(collection);
/*     */     
/*     */     c c;
/*     */     
/* 465 */     (c = c.a((q)this.a, collection, b(collection), i())).a();
/*     */     
/*     */     boolean bool;
/*     */     
/* 469 */     if (!(bool = !this.a.a(q.s) ? true : false)) {
/* 470 */       for (Iterator<v> iterator = collection.iterator(); iterator.hasNext();) {
/* 471 */         if ((v = iterator.next()).s()) {
/* 472 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 478 */     if (this.j != null) {
/*     */ 
/*     */       
/* 481 */       u u1 = new u(this.j, v.a);
/*     */       
/* 483 */       c = c.a((v)u1);
/*     */     } 
/*     */     
/* 486 */     return a(paramj, c, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<?> a(j paramj, c paramc, boolean paramBoolean) {
/* 496 */     return (k<?>)new i(this, this.c, paramj, paramc, this.f, this.g, this.l, this.h, paramBoolean);
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
/*     */   private void a(Collection<v> paramCollection) {
/* 526 */     if (this.a.g()) {
/* 527 */       for (v v : paramCollection) {
/*     */ 
/*     */         
/*     */         try {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 535 */           v.a(this.a);
/* 536 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 537 */           a(illegalArgumentException);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 560 */     if (this.k != null) {
/*     */       try {
/* 562 */         this.k.a(this.a);
/* 563 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 564 */         a(illegalArgumentException);
/*     */       } 
/*     */     }
/* 567 */     if (this.m != null) {
/*     */       try {
/* 569 */         this.m.a(this.a.a(q.o)); return;
/* 570 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 571 */         a(illegalArgumentException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, List<w>> b(Collection<v> paramCollection) {
/* 578 */     HashMap<Object, Object> hashMap = null;
/*     */     a a;
/* 580 */     if ((a = this.a.j()) != null)
/* 581 */       for (v v : paramCollection) {
/*     */         List list;
/* 583 */         if ((list = a.l((b)v.e())) != null && !list.isEmpty()) {
/*     */ 
/*     */           
/* 586 */           if (hashMap == null) {
/* 587 */             hashMap = new HashMap<>();
/*     */           }
/* 589 */           hashMap.put(v.a(), list);
/*     */         } 
/*     */       }  
/* 592 */     if (hashMap == null) {
/* 593 */       return Collections.emptyMap();
/*     */     }
/* 595 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean i() {
/*     */     Boolean bool;
/*     */     l.d d;
/* 605 */     return ((bool = (d = this.c.a(null)).a(l.a.b)) == null) ? this.a.a(q.v) : bool
/* 606 */       .booleanValue();
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
/*     */   private void a(IllegalArgumentException paramIllegalArgumentException) {
/*     */     try {
/* 620 */       this.b.a(this.c, paramIllegalArgumentException.getMessage(), new Object[0]); return;
/* 621 */     } catch (e e2) {
/* 622 */       e e1; if ((e1 = null).getCause() == null) {
/* 623 */         e1.initCause(paramIllegalArgumentException);
/*     */       }
/* 625 */       throw e1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */