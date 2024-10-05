/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.q;
/*     */ import com.a.a.a.t;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.b.s;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.v;
/*     */ import com.a.a.c.c.a.y;
/*     */ import com.a.a.c.c.a.z;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.l;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.t;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.w;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.p;
/*     */ import com.a.a.c.q;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class u
/*     */   extends i<Map<Object, Object>>
/*     */   implements k, t
/*     */ {
/*     */   private p a;
/*     */   private boolean f;
/*     */   private k<Object> g;
/*     */   private e h;
/*     */   private x i;
/*     */   private k<Object> j;
/*     */   private v k;
/*     */   private boolean l;
/*     */   private Set<String> m;
/*     */   private Set<String> n;
/*     */   private n.a o;
/*     */   private boolean p;
/*     */   
/*     */   public u(j paramj, x paramx, p paramp, k<Object> paramk, e parame) {
/* 123 */     super(paramj, (s)null, (Boolean)null);
/* 124 */     this.a = paramp;
/* 125 */     this.g = paramk;
/* 126 */     this.h = parame;
/* 127 */     this.i = paramx;
/* 128 */     this.l = paramx.l();
/* 129 */     this.j = null;
/* 130 */     this.k = null;
/* 131 */     this.f = a(paramj, paramp);
/* 132 */     this.o = null;
/* 133 */     this.p = paramj.u().a(Object.class);
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
/*     */   private u(u paramu, p paramp, k<Object> paramk, e parame, s params, Set<String> paramSet1, Set<String> paramSet2) {
/* 178 */     super(paramu, params, paramu.e);
/* 179 */     this.a = paramp;
/* 180 */     this.g = paramk;
/* 181 */     this.h = parame;
/* 182 */     this.i = paramu.i;
/* 183 */     this.k = paramu.k;
/* 184 */     this.j = paramu.j;
/* 185 */     this.l = paramu.l;
/* 186 */     this.m = paramSet1;
/* 187 */     this.n = paramSet2;
/* 188 */     this.o = n.a(paramSet1, paramSet2);
/*     */     
/* 190 */     this.f = a(this.b, paramp);
/* 191 */     this.p = paramu.p;
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
/*     */   private u a(p paramp, e parame, k<?> paramk, s params, Set<String> paramSet1, Set<String> paramSet2) {
/* 215 */     if (this.a == paramp && this.g == paramk && this.h == parame && this.c == params && this.m == paramSet1 && this.n == paramSet2)
/*     */     {
/*     */       
/* 218 */       return this;
/*     */     }
/* 220 */     return new u(this, paramp, (k)paramk, parame, params, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(j paramj, p paramp) {
/* 231 */     if (paramp == null) {
/* 232 */       return true;
/*     */     }
/*     */     
/* 235 */     if ((paramj = paramj.t()) == null) {
/* 236 */       return true;
/*     */     }
/*     */     Class<String> clazz;
/* 239 */     if (((clazz = paramj.b()) == String.class || clazz == Object.class) && 
/* 240 */       a(paramp)) return true;
/*     */     
/*     */     return false;
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
/*     */   public final void a(Set<String> paramSet) {
/* 254 */     this.m = (paramSet == null || paramSet.isEmpty()) ? null : paramSet;
/*     */     
/* 256 */     this.o = n.a(this.m, this.n);
/*     */   }
/*     */   
/*     */   public final void b(Set<String> paramSet) {
/* 260 */     this.n = paramSet;
/* 261 */     this.o = n.a(this.m, this.n);
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
/*     */   public final void d(g paramg) {
/* 274 */     if (this.i.m()) {
/* 275 */       paramg.c(); j j;
/* 276 */       if ((j = this.i.p()) == null) {
/* 277 */         paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[] { this.b, this.i
/*     */ 
/*     */                 
/* 280 */                 .getClass().getName() }));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 285 */       this.j = a(paramg, j, (c)null);
/* 286 */     } else if (this.i.n()) {
/* 287 */       paramg.c(); j j;
/* 288 */       if ((j = this.i.q()) == null) {
/* 289 */         paramg.a(this.b, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[] { this.b, this.i
/*     */ 
/*     */                 
/* 292 */                 .getClass().getName() }));
/*     */       }
/* 294 */       this.j = a(paramg, j, (c)null);
/*     */     } 
/* 296 */     if (this.i.o()) {
/* 297 */       v[] arrayOfV = this.i.a(paramg.c());
/* 298 */       this.k = v.a(paramg, this.i, arrayOfV, paramg
/* 299 */           .a(q.v));
/*     */     } 
/* 301 */     this.f = a(this.b, this.a);
/*     */   }
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
/* 313 */     if ((p1 = this.a) == null) {
/* 314 */       p1 = paramg.b(this.b.t(), paramc);
/*     */     }
/* 316 */     else if (p1 instanceof l) {
/* 317 */       p1 = ((l)p1).a();
/*     */     } 
/*     */ 
/*     */     
/* 321 */     k<Object> k1 = this.g;
/*     */     
/* 323 */     if (paramc != null) {
/* 324 */       k1 = (k)a(paramg, paramc, k1);
/*     */     }
/* 326 */     j j = this.b.u();
/* 327 */     if (k1 == null) {
/* 328 */       k1 = paramg.a(j, paramc);
/*     */     } else {
/* 330 */       k1 = paramg.b(k1, paramc, j);
/*     */     } 
/*     */     e e1;
/* 333 */     if ((e1 = this.h) != null) {
/* 334 */       e1 = e1.a(paramc);
/*     */     }
/* 336 */     Set<String> set1 = this.m;
/* 337 */     Set<String> set2 = this.n; com.a.a.c.a a1;
/*     */     j j1;
/* 339 */     if (b(a1 = paramg.f(), paramc) && (
/*     */       
/* 341 */       j1 = paramc.e()) != null) {
/* 342 */       paramg.c(); Set<?> set4;
/*     */       q.a a3;
/* 344 */       if ((a3 = a1.b((com.a.a.c.f.b)j1)) != null && 
/*     */         
/* 346 */         !(set4 = a3.c()).isEmpty()) {
/* 347 */         set1 = (set1 == null) ? new HashSet<>() : new HashSet<>(set1);
/* 348 */         for (String str : set4) {
/* 349 */           set1.add(str);
/*     */         }
/*     */       } 
/*     */       Set<?> set3;
/*     */       t.a a2;
/* 354 */       if ((a2 = a1.c((com.a.a.c.f.b)j1)) != null && (
/*     */         
/* 356 */         set3 = a2.b()) != null) {
/* 357 */         HashSet<String> hashSet = new HashSet();
/* 358 */         if (set2 == null) {
/* 359 */           hashSet = new HashSet(set3);
/*     */         } else {
/* 361 */           for (String str : set3) {
/* 362 */             if (set2.contains(str)) {
/* 363 */               hashSet.add(str);
/*     */             }
/*     */           } 
/*     */         } 
/* 367 */         set2 = hashSet;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 372 */     return a(p1, e1, k1, 
/* 373 */         b(paramg, paramc, k1), set1, set2);
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
/* 384 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final x i() {
/* 389 */     return this.i;
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
/*     */   public final boolean c() {
/* 415 */     return (this.g == null && this.a == null && this.h == null && this.m == null && this.n == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f b() {
/* 424 */     return f.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Object, Object> c(l paraml, g paramg) {
/*     */     Map<Object, Object> map;
/* 431 */     if (this.k != null) {
/* 432 */       return e(paraml, paramg);
/*     */     }
/* 434 */     if (this.j != null) {
/* 435 */       return (Map<Object, Object>)this.i.a(paramg, this.j
/* 436 */           .a(paraml, paramg));
/*     */     }
/* 438 */     if (!this.l) {
/* 439 */       return (Map<Object, Object>)paramg.a(j(), 
/* 440 */           i(), paraml, "no default constructor found", new Object[0]);
/*     */     }
/*     */     
/* 443 */     switch (paraml.l()) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 5:
/* 447 */         map = (Map)this.i.a(paramg);
/* 448 */         if (this.f) {
/* 449 */           return c(paraml, paramg, map);
/*     */         }
/* 451 */         return b(paraml, paramg, map);
/*     */       
/*     */       case 6:
/* 454 */         return m(paraml, paramg);
/*     */       
/*     */       case 3:
/* 457 */         return d(paraml, paramg);
/*     */     } 
/*     */     
/* 460 */     return (Map<Object, Object>)paramg.a(e(paramg), paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Object, Object> a(l paraml, g paramg, Map<Object, Object> paramMap) {
/* 470 */     paraml.a(paramMap);
/*     */     
/*     */     o o;
/*     */     
/* 474 */     if ((o = paraml.k()) != o.b && o != o.f) {
/* 475 */       return (Map<Object, Object>)paramg.a(j(), paraml);
/*     */     }
/*     */     
/* 478 */     if (this.f) {
/* 479 */       e(paraml, paramg, paramMap);
/* 480 */       return paramMap;
/*     */     } 
/* 482 */     d(paraml, paramg, paramMap);
/* 483 */     return paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 492 */     return parame.a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> j() {
/* 502 */     return this.b.b();
/*     */   } public final j h() {
/* 504 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Object, Object> b(l paraml, g paramg, Map<Object, Object> paramMap) {
/* 515 */     p p1 = this.a;
/* 516 */     k<Object> k1 = this.g;
/* 517 */     e e1 = this.h;
/*     */     
/* 519 */     b b = null;
/*     */     boolean bool;
/* 521 */     if (bool = (k1.f() != null) ? true : false) {
/* 522 */       b = new b(this.b.u().b(), paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 527 */     if (paraml.q()) {
/* 528 */       str = paraml.h();
/*     */     } else {
/*     */       o o;
/* 531 */       if ((o = paraml.k()) != o.f) {
/* 532 */         if (o == o.c) {
/* 533 */           return paramMap;
/*     */         }
/* 535 */         paramg.a(this, o.f, null, new Object[0]);
/*     */       } 
/* 537 */       str = paraml.v();
/*     */     } 
/*     */     String str;
/* 540 */     for (; str != null; str = paraml.h()) {
/* 541 */       Object object = p1.a(str, paramg);
/*     */       
/* 543 */       o o = paraml.g();
/* 544 */       if (this.o != null && this.o.a(str)) {
/* 545 */         paraml.j();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       try {
/*     */         Object object1;
/* 551 */         if (o == o.m) {
/* 552 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 555 */           object1 = this.c.a(paramg);
/* 556 */         } else if (e1 == null) {
/* 557 */           object1 = k1.a(paraml, paramg);
/*     */         } else {
/* 559 */           object1 = k1.a(paraml, paramg, e1);
/*     */         } 
/* 561 */         if (bool) {
/* 562 */           b.a(object, object1);
/*     */         } else {
/*     */           Object object2;
/* 565 */           if ((object2 = paramMap.put(object, object1)) != null) {
/* 566 */             a(paramg, paramMap, object, object2, object1);
/*     */           }
/*     */         } 
/* 569 */       } catch (w w) {
/* 570 */         a(paramg, b, object, w);
/* 571 */       } catch (Exception exception) {
/* 572 */         a(paramg, exception, paramMap, str);
/*     */       }  continue;
/*     */     } 
/* 575 */     return paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Object, Object> c(l paraml, g paramg, Map<Object, Object> paramMap) {
/* 586 */     k<Object> k1 = this.g;
/* 587 */     e e1 = this.h;
/* 588 */     b b = null;
/*     */     boolean bool;
/* 590 */     if (bool = (k1.f() != null) ? true : false) {
/* 591 */       b = new b(this.b.u().b(), paramMap);
/*     */     }
/*     */ 
/*     */     
/* 595 */     if (paraml.q()) {
/* 596 */       str = paraml.h();
/*     */     } else {
/*     */       o o;
/* 599 */       if ((o = paraml.k()) == o.c) {
/* 600 */         return paramMap;
/*     */       }
/* 602 */       if (o != o.f) {
/* 603 */         paramg.a(this, o.f, null, new Object[0]);
/*     */       }
/* 605 */       str = paraml.v();
/*     */     } 
/*     */     String str;
/* 608 */     for (; str != null; str = paraml.h()) {
/* 609 */       o o = paraml.g();
/* 610 */       if (this.o != null && this.o.a(str)) {
/* 611 */         paraml.j();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       try {
/*     */         Object object;
/* 617 */         if (o == o.m) {
/* 618 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 621 */           object = this.c.a(paramg);
/* 622 */         } else if (e1 == null) {
/* 623 */           object = k1.a(paraml, paramg);
/*     */         } else {
/* 625 */           object = k1.a(paraml, paramg, e1);
/*     */         } 
/* 627 */         if (bool) {
/* 628 */           b.a(str, object);
/*     */         } else {
/*     */           Object object1;
/* 631 */           if ((object1 = paramMap.put(str, object)) != null) {
/* 632 */             a(paramg, paramMap, str, object1, object);
/*     */           }
/*     */         } 
/* 635 */       } catch (w w) {
/* 636 */         a(paramg, b, str, w);
/* 637 */       } catch (Exception exception) {
/* 638 */         a(paramg, exception, paramMap, str);
/*     */       } 
/*     */       
/*     */       continue;
/*     */     } 
/* 643 */     return paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Object, Object> e(l paraml, g paramg) {
/*     */     v v1;
/* 651 */     y y = (v1 = this.k).a(paraml, paramg, null);
/*     */     
/* 653 */     k<Object> k1 = this.g;
/* 654 */     e e1 = this.h;
/*     */ 
/*     */     
/* 657 */     if (paraml.q()) {
/* 658 */       str = paraml.h();
/* 659 */     } else if (paraml.a(o.f)) {
/* 660 */       str = paraml.v();
/*     */     } else {
/* 662 */       str = null;
/*     */     } 
/*     */     String str;
/* 665 */     for (; str != null; str = paraml.h()) {
/* 666 */       Object object1; o o = paraml.g();
/* 667 */       if (this.o != null && this.o.a(str)) {
/* 668 */         paraml.j();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       v v2;
/* 673 */       if ((v2 = v1.a(str)) != null) {
/*     */         
/* 675 */         if (y.a(v2, v2.a(paraml, paramg))) {
/* 676 */           Map<Object, Object> map; paraml.g();
/*     */           
/*     */           try {
/* 679 */             map = (Map)v1.a(paramg, y);
/* 680 */           } catch (Exception null) {
/* 681 */             return (Map<Object, Object>)a(paramg, (Throwable)object1, this.b.b(), str);
/*     */           } 
/* 683 */           return b(paraml, paramg, map);
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 688 */       Object object2 = this.a.a(str, paramg);
/*     */ 
/*     */       
/*     */       try {
/* 692 */         if (object1 == o.m) {
/* 693 */           if (this.d) {
/*     */             continue;
/*     */           }
/* 696 */           Object object = this.c.a(paramg);
/* 697 */         } else if (e1 == null) {
/* 698 */           Object object = k1.a(paraml, paramg);
/*     */         } else {
/* 700 */           object1 = k1.a(paraml, paramg, e1);
/*     */         } 
/* 702 */       } catch (Exception exception) {
/* 703 */         a(paramg, exception, this.b.b(), str);
/* 704 */         return null;
/*     */       } 
/* 706 */       y.a(object2, object1);
/*     */       
/*     */       continue;
/*     */     } 
/*     */     try {
/* 711 */       return (Map<Object, Object>)v1.a(paramg, y);
/* 712 */     } catch (Exception exception) {
/* 713 */       a(paramg, exception, this.b.b(), str);
/* 714 */       return null;
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
/*     */ 
/*     */   
/*     */   private void d(l paraml, g paramg, Map<Object, Object> paramMap) {
/* 730 */     p p1 = this.a;
/* 731 */     k<Object> k1 = this.g;
/* 732 */     e e1 = this.h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 738 */     if (paraml.q()) {
/* 739 */       str = paraml.h();
/*     */     } else {
/*     */       o o;
/* 742 */       if ((o = paraml.k()) == o.c) {
/*     */         return;
/*     */       }
/* 745 */       if (o != o.f) {
/* 746 */         paramg.a(this, o.f, null, new Object[0]);
/*     */       }
/* 748 */       str = paraml.v();
/*     */     } 
/*     */     String str;
/* 751 */     for (; str != null; str = paraml.h()) {
/* 752 */       Object object = p1.a(str, paramg);
/*     */       
/* 754 */       o o = paraml.g();
/* 755 */       if (this.o != null && this.o.a(str)) {
/* 756 */         paraml.j();
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/* 761 */           if (o == o.m) {
/* 762 */             if (!this.d)
/*     */             {
/*     */               
/* 765 */               paramMap.put(object, this.c.a(paramg));
/*     */             }
/*     */           } else {
/*     */             Object object1;
/*     */             
/* 770 */             if ((o = (o)paramMap.get(object)) != null) {
/* 771 */               if (e1 == null) {
/* 772 */                 object1 = k1.a(paraml, paramg, o);
/*     */               } else {
/* 774 */                 object1 = k1.b(paraml, paramg, e1);
/*     */               } 
/* 776 */             } else if (e1 == null) {
/* 777 */               object1 = k1.a(paraml, paramg);
/*     */             } else {
/* 779 */               object1 = k1.a(paraml, paramg, e1);
/*     */             } 
/* 781 */             if (object1 != o)
/* 782 */               paramMap.put(object, object1); 
/*     */           } 
/* 784 */         } catch (Exception exception) {
/* 785 */           a(paramg, exception, paramMap, str);
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
/*     */   private void e(l paraml, g paramg, Map<Object, Object> paramMap) {
/* 800 */     k<Object> k1 = this.g;
/* 801 */     e e1 = this.h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 807 */     if (paraml.q()) {
/* 808 */       str = paraml.h();
/*     */     } else {
/*     */       o o;
/* 811 */       if ((o = paraml.k()) == o.c) {
/*     */         return;
/*     */       }
/* 814 */       if (o != o.f) {
/* 815 */         paramg.a(this, o.f, null, new Object[0]);
/*     */       }
/* 817 */       str = paraml.v();
/*     */     } 
/*     */     String str;
/* 820 */     for (; str != null; str = paraml.h()) {
/* 821 */       o o = paraml.g();
/* 822 */       if (this.o != null && this.o.a(str)) {
/* 823 */         paraml.j();
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/* 828 */           if (o == o.m) {
/* 829 */             if (!this.d)
/*     */             {
/*     */               
/* 832 */               paramMap.put(str, this.c.a(paramg));
/*     */             }
/*     */           } else {
/*     */             Object object;
/*     */             
/* 837 */             if ((o = (o)paramMap.get(str)) != null) {
/* 838 */               if (e1 == null) {
/* 839 */                 object = k1.a(paraml, paramg, o);
/*     */               } else {
/* 841 */                 object = k1.b(paraml, paramg, e1);
/*     */               } 
/* 843 */             } else if (e1 == null) {
/* 844 */               object = k1.a(paraml, paramg);
/*     */             } else {
/* 846 */               object = k1.a(paraml, paramg, e1);
/*     */             } 
/* 848 */             if (object != o)
/* 849 */               paramMap.put(str, object); 
/*     */           } 
/* 851 */         } catch (Exception exception) {
/* 852 */           a(paramg, exception, paramMap, str);
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
/*     */   private void a(g paramg, Map<Object, Object> paramMap, Object paramObject1, Object paramObject2, Object paramObject3) {
/* 865 */     if (this.p && paramg.a(s.a)) {
/* 866 */       if (paramObject2 instanceof List) {
/* 867 */         ((List<Object>)paramObject2).add(paramObject3);
/* 868 */         paramMap.put(paramObject1, paramObject2); return;
/*     */       } 
/*     */       ArrayList<Object> arrayList;
/* 871 */       (arrayList = new ArrayList()).add(paramObject2);
/* 872 */       arrayList.add(paramObject3);
/* 873 */       paramMap.put(paramObject1, arrayList);
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
/*     */ 
/*     */   
/*     */   private void a(g paramg, b paramb, Object paramObject, w paramw) {
/* 889 */     if (paramb == null) {
/* 890 */       paramg.a(this, "Unresolved forward reference but no identity info: " + paramw, new Object[0]);
/*     */     }
/*     */     
/* 893 */     z.a a1 = paramb.a(paramw, paramObject);
/* 894 */     paramw.d().a(a1);
/*     */   }
/*     */ 
/*     */   
/*     */   static final class b
/*     */   {
/*     */     private final Class<?> a;
/*     */     
/*     */     private Map<Object, Object> b;
/* 903 */     private List<u.a> c = new ArrayList<>();
/*     */     
/*     */     public b(Class<?> param1Class, Map<Object, Object> param1Map) {
/* 906 */       this.a = param1Class;
/* 907 */       this.b = param1Map;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 912 */       if (this.c.isEmpty()) {
/* 913 */         this.b.put(param1Object1, param1Object2); return;
/*     */       } 
/*     */       u.a a;
/* 916 */       (a = this.c.get(this.c.size() - 1)).a.put(param1Object1, param1Object2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final z.a a(w param1w, Object param1Object) {
/* 922 */       u.a a = new u.a(this, param1w, this.a, param1Object);
/* 923 */       this.c.add(a);
/* 924 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void b(Object param1Object1, Object param1Object2) {
/* 929 */       Iterator<u.a> iterator = this.c.iterator();
/*     */ 
/*     */ 
/*     */       
/* 933 */       Map<Object, Object> map = this.b;
/* 934 */       while (iterator.hasNext()) {
/*     */         u.a a;
/* 936 */         if ((a = iterator.next()).b(param1Object1)) {
/* 937 */           iterator.remove();
/* 938 */           map.put(a.b, param1Object2);
/* 939 */           map.putAll(a.a);
/*     */           return;
/*     */         } 
/* 942 */         map = a.a;
/*     */       } 
/*     */       
/* 945 */       throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + param1Object1 + "] that wasn't previously seen as unresolved.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */     extends z.a
/*     */   {
/*     */     private final u.b c;
/*     */ 
/*     */     
/* 958 */     public final Map<Object, Object> a = new LinkedHashMap<>();
/*     */     
/*     */     public final Object b;
/*     */ 
/*     */     
/*     */     a(u.b param1b, w param1w, Class<?> param1Class, Object param1Object) {
/* 964 */       super(param1w, param1Class);
/* 965 */       this.c = param1b;
/* 966 */       this.b = param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 971 */       this.c.b(param1Object1, param1Object2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */