/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.b;
/*     */ import com.a.a.c.c.a.a;
/*     */ import com.a.a.c.c.a.c;
/*     */ import com.a.a.c.c.a.g;
/*     */ import com.a.a.c.c.a.s;
/*     */ import com.a.a.c.c.a.v;
/*     */ import com.a.a.c.c.a.y;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.ac;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.m.r;
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
/*     */ public final class i
/*     */   extends f
/*     */ {
/*     */   private k t;
/*     */   private j u;
/*     */   
/*     */   public i(g paramg, b paramb, j paramj, c paramc, Map<String, v> paramMap, Set<String> paramSet1, boolean paramBoolean1, Set<String> paramSet2, boolean paramBoolean2) {
/*  67 */     super(paramg, paramb, paramc, paramMap, paramSet1, paramBoolean1, paramSet2, paramBoolean2);
/*     */     
/*  69 */     this.u = paramj;
/*  70 */     this.t = paramg.f();
/*     */     
/*  72 */     if (this.q != null) {
/*  73 */       throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + paramb
/*  74 */           .a() + ")");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i(i parami, boolean paramBoolean) {
/* 104 */     super(parami, paramBoolean);
/* 105 */     this.t = parami.t;
/* 106 */     this.u = parami.u;
/*     */   }
/*     */   
/*     */   private i(i parami, r paramr) {
/* 110 */     super(parami, paramr);
/* 111 */     this.t = parami.t;
/* 112 */     this.u = parami.u;
/*     */   }
/*     */   
/*     */   private i(i parami, s params) {
/* 116 */     super(parami, params);
/* 117 */     this.t = parami.t;
/* 118 */     this.u = parami.u;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i(i parami, Set<String> paramSet1, Set<String> paramSet2) {
/* 126 */     super(parami, paramSet1, paramSet2);
/* 127 */     this.t = parami.t;
/* 128 */     this.u = parami.u;
/*     */   }
/*     */   
/*     */   private i(i parami, c paramc) {
/* 132 */     super(parami, paramc);
/* 133 */     this.t = parami.t;
/* 134 */     this.u = parami.u;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object> a(r paramr) {
/* 144 */     return (k<Object>)new i(this, paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(s params) {
/* 149 */     return new i(this, params);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(Set<String> paramSet1, Set<String> paramSet2) {
/* 155 */     return new i(this, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(boolean paramBoolean) {
/* 160 */     return new i(this, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(c paramc) {
/* 165 */     return new i(this, paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final f g() {
/* 170 */     v[] arrayOfV = this.h.d();
/* 171 */     return (f)new a(this, this.u, arrayOfV, this.t);
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
/*     */   public final Boolean a(f paramf) {
/* 183 */     return Boolean.FALSE;
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
/*     */   private Object b(g paramg, Object paramObject) {
/* 196 */     if (this.t == null) {
/* 197 */       return paramObject;
/*     */     }
/*     */     try {
/* 200 */       return this.t.l().invoke(paramObject, (Object[])null);
/* 201 */     } catch (Exception exception) {
/* 202 */       return a(exception, paramg);
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
/*     */   public final Object a(l paraml, g paramg) {
/* 214 */     if (paraml.q()) {
/* 215 */       paraml.g();
/* 216 */       if (this.g) {
/* 217 */         return b(paramg, v(paraml, paramg));
/*     */       }
/* 219 */       return b(paramg, b(paraml, paramg));
/*     */     } 
/*     */     
/* 222 */     switch (paraml.l()) {
/*     */       case 6:
/* 224 */         return b(paramg, i(paraml, paramg));
/*     */       case 7:
/* 226 */         return b(paramg, h(paraml, paramg));
/*     */       case 8:
/* 228 */         return b(paramg, j(paraml, paramg));
/*     */       case 12:
/* 230 */         return paraml.N();
/*     */       case 9:
/*     */       case 10:
/* 233 */         return b(paramg, k(paraml, paramg));
/*     */ 
/*     */       
/*     */       case 3:
/* 237 */         return d(paraml, paramg);
/*     */       case 2:
/*     */       case 5:
/* 240 */         return b(paramg, b(paraml, paramg));
/*     */     } 
/*     */     
/* 243 */     return paramg.a(e(paramg), paraml);
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
/*     */   public final Object a(l paraml, g paramg, Object<?> paramObject) {
/* 257 */     j j1 = this.u;
/*     */     
/* 259 */     Class<?> clazz = a();
/* 260 */     paramObject = (Object<?>)paramObject.getClass();
/* 261 */     if (clazz.isAssignableFrom((Class<?>)paramObject)) {
/* 262 */       return paramg.a(j1, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", new Object[] { j1, clazz
/*     */               
/* 264 */               .getName() }));
/*     */     }
/* 266 */     return paramg.a(j1, String.format("Deserialization of %s by passing existing instance (of %s) not supported", new Object[] { j1, paramObject
/*     */             
/* 268 */             .getName() }));
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
/*     */   private final Object v(l paraml, g paramg) {
/* 285 */     Object object = this.b.a(paramg);
/* 286 */     for (; paraml.k() == o.f; paraml.g()) {
/* 287 */       String str = paraml.v();
/*     */       
/* 289 */       paraml.g();
/*     */       v v;
/* 291 */       if ((v = this.h.a(str)) != null) {
/*     */         try {
/* 293 */           object = v.b(paraml, paramg, object);
/* 294 */         } catch (Exception exception) {
/* 295 */           a(exception, object, str, paramg);
/*     */         } 
/*     */       } else {
/* 298 */         a(paraml, paramg, object, str);
/*     */       } 
/*     */     } 
/* 301 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg) {
/* 312 */     if (this.f) {
/* 313 */       if (this.o != null) {
/* 314 */         return w(paraml, paramg);
/*     */       }
/* 316 */       if (this.p != null) {
/* 317 */         return y(paraml, paramg);
/*     */       }
/* 319 */       return g(paraml, paramg);
/*     */     } 
/* 321 */     Object object = this.b.a(paramg);
/* 322 */     if (this.i != null)
/* 323 */       a(paramg, object); 
/*     */     Class<?> clazz;
/* 325 */     if (this.n && (
/*     */       
/* 327 */       clazz = paramg.d()) != null) {
/* 328 */       return a(paraml, paramg, object, clazz);
/*     */     }
/*     */     
/* 331 */     for (; paraml.k() == o.f; paraml.g()) {
/* 332 */       String str = paraml.v();
/*     */       
/* 334 */       paraml.g();
/*     */       v v;
/* 336 */       if ((v = this.h.a(str)) != null) {
/*     */         try {
/* 338 */           object = v.b(paraml, paramg, object);
/* 339 */         } catch (Exception exception) {
/* 340 */           a(exception, object, str, paramg);
/*     */         } 
/*     */       } else {
/*     */         
/* 344 */         a(paraml, paramg, object, str);
/*     */       } 
/* 346 */     }  return object;
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
/*     */   protected final Object c(l paraml, g paramg) {
/*     */     v v;
/* 365 */     y y = (v = this.e).a(paraml, paramg, this.q);
/* 366 */     Class<?> clazz = this.n ? paramg.d() : null;
/*     */ 
/*     */     
/* 369 */     ac ac = null;
/*     */     
/* 371 */     Object object = paraml.k();
/* 372 */     for (; object == o.f; o = paraml.g()) {
/* 373 */       o o; String str = paraml.v();
/* 374 */       paraml.g();
/*     */       
/* 376 */       v v1 = v.a(str);
/*     */       
/* 378 */       if (!y.a(str) || v1 != null)
/*     */       {
/*     */         
/* 381 */         if (v1 != null) {
/* 382 */           if (clazz != null && !v1.a(clazz)) {
/* 383 */             paraml.j();
/*     */ 
/*     */           
/*     */           }
/* 387 */           else if (y.a(v1, v1.a(paraml, paramg))) {
/* 388 */             paraml.g();
/*     */             
/*     */             try {
/* 391 */               object1 = v.a(paramg, y);
/* 392 */             } catch (Exception object1) {
/* 393 */               a((Throwable)object1, this.a.b(), str, paramg);
/*     */             } 
/*     */ 
/*     */             
/* 397 */             if (object1.getClass() != this.a.b()) {
/* 398 */               return a(paraml, paramg, object1, ac);
/*     */             }
/* 400 */             if (ac != null) {
/* 401 */               object1 = a(paramg, object1, ac);
/*     */             }
/*     */             
/* 404 */             return b(paraml, paramg, object1);
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/* 410 */         else if ((v1 = this.h.a(str)) != null) {
/* 411 */           y.b(v1, v1.a(paraml, paramg));
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 416 */         else if (n.a(str, this.k, this.l)) {
/* 417 */           c(paraml, paramg, a(), str);
/*     */ 
/*     */         
/*     */         }
/* 421 */         else if (this.j != null) {
/* 422 */           y.a(this.j, str, this.j.a(paraml, paramg));
/*     */         }
/*     */         else {
/*     */           
/* 426 */           if (ac == null) {
/* 427 */             ac = paramg.a(paraml);
/*     */           }
/* 429 */           ac.a(str);
/* 430 */           ac.b(paraml);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*     */     try {
/* 436 */       Object object1 = v.a(paramg, y);
/* 437 */     } catch (Exception exception) {
/* 438 */       object = a(exception, paramg);
/*     */     } 
/* 440 */     if (ac != null) {
/*     */       
/* 442 */       if (object.getClass() != this.a.b()) {
/* 443 */         return a((l)null, paramg, object, ac);
/*     */       }
/*     */       
/* 446 */       return a(paramg, object, ac);
/*     */     } 
/* 448 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object b(l paraml, g paramg, Object paramObject) {
/* 454 */     if (this.i != null) {
/* 455 */       a(paramg, paramObject);
/*     */     }
/* 457 */     if (this.o != null) {
/* 458 */       if (paraml.a(o.b)) {
/* 459 */         paraml.g();
/*     */       }
/*     */       ac ac;
/* 462 */       (ac = paramg.a(paraml)).i();
/* 463 */       return b(paraml, paramg, paramObject, ac);
/*     */     } 
/* 465 */     if (this.p != null)
/* 466 */       return c(paraml, paramg, paramObject); 
/*     */     Class<?> clazz;
/* 468 */     if (this.n && (
/*     */       
/* 470 */       clazz = paramg.d()) != null) {
/* 471 */       return a(paraml, paramg, paramObject, clazz);
/*     */     }
/*     */     
/*     */     o o;
/*     */     
/* 476 */     if ((o = paraml.k()) == o.b) {
/* 477 */       o = paraml.g();
/*     */     }
/* 479 */     for (; o == o.f; o1 = paraml.g()) {
/* 480 */       o o1; String str = paraml.v();
/*     */       
/* 482 */       paraml.g();
/*     */       
/*     */       v v;
/* 485 */       if ((v = this.h.a(str)) != null) {
/*     */         try {
/* 487 */           paramObject = v.b(paraml, paramg, paramObject);
/* 488 */         } catch (Exception exception) {
/* 489 */           a(exception, paramObject, str, paramg);
/*     */         } 
/*     */       } else {
/*     */         
/* 493 */         a(paraml, paramg, paramObject, str);
/*     */       } 
/* 495 */     }  return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Object d(l paraml, g paramg) {
/*     */     k<Object> k1;
/* 504 */     if ((k1 = this.d) != null || (k1 = this.c) != null) {
/* 505 */       Object object = this.b.b(paramg, k1
/* 506 */           .a(paraml, paramg));
/* 507 */       if (this.i != null) {
/* 508 */         a(paramg, object);
/*     */       }
/* 510 */       return b(paramg, object);
/*     */     } 
/* 512 */     b b = h(paramg);
/*     */     
/*     */     boolean bool;
/* 515 */     if ((bool = paramg.a(com.a.a.c.i.q)) || b != b.a) {
/*     */       o o;
/* 517 */       if ((o = paraml.g()) == o.e) {
/* 518 */         switch (j.a[b.ordinal()]) {
/*     */           case 1:
/* 520 */             return c(paramg);
/*     */           case 2:
/*     */           case 3:
/* 523 */             return a(paramg);
/*     */         } 
/*     */         
/* 526 */         return paramg.a(e(paramg), o.d, paraml, null, new Object[0]);
/*     */       } 
/* 528 */       if (bool) {
/* 529 */         Object object = a(paraml, paramg);
/* 530 */         if (paraml.g() != o.e) {
/* 531 */           j(paramg);
/*     */         }
/* 533 */         return object;
/*     */       } 
/*     */     } 
/* 536 */     return paramg.a(e(paramg), paraml);
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
/*     */   private Object a(l paraml, g paramg, Object paramObject, Class<?> paramClass) {
/* 549 */     o o = paraml.k();
/* 550 */     for (; o == o.f; o1 = paraml.g()) {
/* 551 */       o o1; String str = paraml.v();
/*     */       
/* 553 */       paraml.g();
/*     */       v v;
/* 555 */       if ((v = this.h.a(str)) != null) {
/* 556 */         if (!v.a(paramClass)) {
/* 557 */           paraml.j();
/*     */         } else {
/*     */           
/*     */           try {
/* 561 */             paramObject = v.b(paraml, paramg, paramObject);
/* 562 */           } catch (Exception exception) {
/* 563 */             a(exception, paramObject, str, paramg);
/*     */           } 
/*     */         } 
/*     */       } else {
/* 567 */         a(paraml, paramg, paramObject, str);
/*     */       } 
/* 569 */     }  return paramObject;
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
/*     */   private Object w(l paraml, g paramg) {
/* 586 */     if (this.c != null) {
/* 587 */       return this.b.a(paramg, this.c.a(paraml, paramg));
/*     */     }
/* 589 */     if (this.e != null) {
/* 590 */       return x(paraml, paramg);
/*     */     }
/*     */     ac ac;
/* 593 */     (ac = paramg.a(paraml)).i();
/* 594 */     Object object = this.b.a(paramg);
/*     */     
/* 596 */     if (this.i != null) {
/* 597 */       a(paramg, object);
/*     */     }
/*     */     
/* 600 */     Class<?> clazz = this.n ? paramg.d() : null;
/* 601 */     for (; paraml.k() == o.f; paraml.g()) {
/* 602 */       String str = paraml.v();
/* 603 */       paraml.g();
/*     */       v v;
/* 605 */       if ((v = this.h.a(str)) != null) {
/* 606 */         if (clazz != null && !v.a(clazz)) {
/* 607 */           paraml.j();
/*     */         } else {
/*     */           
/*     */           try {
/* 611 */             object = v.b(paraml, paramg, object);
/* 612 */           } catch (Exception exception) {
/* 613 */             a(exception, object, str, paramg);
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 618 */       } else if (n.a(str, this.k, this.l)) {
/* 619 */         c(paraml, paramg, object, str);
/*     */       }
/*     */       else {
/*     */         
/* 623 */         ac.a(str);
/* 624 */         ac.b(paraml);
/*     */         
/* 626 */         if (this.j != null) {
/*     */           try {
/* 628 */             this.j.a(paraml, paramg, object, str);
/* 629 */           } catch (Exception exception) {
/* 630 */             a(exception, object, str, paramg);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 635 */     ac.j();
/* 636 */     return this.o.a(paramg, object, ac);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object x(l paraml, g paramg) {
/*     */     v v;
/* 645 */     y y = (v = this.e).a(paraml, paramg, this.q);
/*     */     
/*     */     ac ac;
/* 648 */     (ac = paramg.a(paraml)).i();
/* 649 */     Object object = null;
/*     */     
/* 651 */     o o = paraml.k();
/* 652 */     for (; o == o.f; o1 = paraml.g()) {
/* 653 */       o o1; String str = paraml.v();
/* 654 */       paraml.g();
/*     */       
/* 656 */       v v1 = v.a(str);
/*     */       
/* 658 */       if (!y.a(str) || v1 != null)
/*     */       {
/*     */         
/* 661 */         if (v1 != null) {
/*     */           
/* 663 */           if (y.a(v1, v1.a(paraml, paramg))) {
/* 664 */             paraml.g();
/*     */             try {
/* 666 */               object = v.a(paramg, y);
/* 667 */             } catch (Exception exception) {
/* 668 */               a(exception, this.a.b(), str, paramg);
/*     */             } 
/*     */             
/* 671 */             if (object.getClass() != this.a.b()) {
/* 672 */               return a(paraml, paramg, object, ac);
/*     */             }
/* 674 */             return b(paraml, paramg, object, ac);
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/* 680 */         else if ((v1 = this.h.a(str)) != null) {
/* 681 */           y.b(v1, v1.a(paraml, paramg));
/*     */         
/*     */         }
/* 684 */         else if (n.a(str, this.k, this.l)) {
/* 685 */           c(paraml, paramg, a(), str);
/*     */         } else {
/*     */           
/* 688 */           ac.a(str);
/* 689 */           ac.b(paraml);
/*     */           
/* 691 */           if (this.j != null)
/* 692 */             y.a(this.j, str, this.j.a(paraml, paramg)); 
/*     */         }  } 
/*     */     } 
/* 695 */     ac.j();
/*     */ 
/*     */     
/* 698 */     if (object == null) {
/*     */       try {
/* 700 */         object = v.a(paramg, y);
/* 701 */       } catch (Exception exception) {
/* 702 */         return a(exception, paramg);
/*     */       } 
/*     */     }
/* 705 */     return this.o.a(paramg, object, ac);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object b(l paraml, g paramg, Object paramObject, ac paramac) {
/* 712 */     Class<?> clazz = this.n ? paramg.d() : null;
/* 713 */     for (o o = paraml.k(); o == o.f; o1 = paraml.g()) {
/* 714 */       o o1; String str = paraml.v();
/* 715 */       v v = this.h.a(str);
/* 716 */       paraml.g();
/* 717 */       if (v != null) {
/* 718 */         if (clazz != null && !v.a(clazz)) {
/* 719 */           paraml.j();
/*     */         } else {
/*     */           
/*     */           try {
/* 723 */             paramObject = v.b(paraml, paramg, paramObject);
/* 724 */           } catch (Exception exception) {
/* 725 */             a(exception, paramObject, str, paramg);
/*     */           }
/*     */         
/*     */         } 
/* 729 */       } else if (n.a(str, this.k, this.l)) {
/* 730 */         c(paraml, paramg, paramObject, str);
/*     */       }
/*     */       else {
/*     */         
/* 734 */         paramac.a(str);
/* 735 */         paramac.b(paraml);
/*     */         
/* 737 */         if (this.j != null)
/* 738 */           this.j.a(paraml, paramg, paramObject, str); 
/*     */       } 
/*     */     } 
/* 741 */     paramac.j();
/* 742 */     return this.o.a(paramg, paramObject, paramac);
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
/*     */   private Object y(l paraml, g paramg) {
/* 755 */     if (this.e != null) {
/* 756 */       return k(paramg);
/*     */     }
/* 758 */     return c(paraml, paramg, this.b.a(paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object c(l paraml, g paramg, Object paramObject) {
/* 765 */     Class<?> clazz = this.n ? paramg.d() : null;
/* 766 */     g g1 = this.p.a();
/*     */     
/* 768 */     for (o o = paraml.k(); o == o.f; o = paraml.g()) {
/* 769 */       String str = paraml.v();
/* 770 */       o = paraml.g();
/*     */       v v;
/* 772 */       if ((v = this.h.a(str)) != null) {
/*     */         
/* 774 */         if (o.g()) {
/* 775 */           g1.a(paraml, paramg, str, paramObject);
/*     */         }
/* 777 */         if (clazz != null && !v.a(clazz)) {
/* 778 */           paraml.j();
/*     */         } else {
/*     */           
/*     */           try {
/* 782 */             paramObject = v.b(paraml, paramg, paramObject);
/* 783 */           } catch (Exception exception) {
/* 784 */             a(exception, paramObject, str, paramg);
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 789 */       } else if (n.a(str, this.k, this.l)) {
/* 790 */         c(paraml, paramg, paramObject, str);
/*     */ 
/*     */       
/*     */       }
/* 794 */       else if (!g1.b(paraml, paramg, str, paramObject)) {
/*     */ 
/*     */ 
/*     */         
/* 798 */         if (this.j != null) {
/*     */           try {
/* 800 */             this.j.a(paraml, paramg, paramObject, str);
/* 801 */           } catch (Exception exception) {
/* 802 */             a(exception, paramObject, str, paramg);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 807 */           b(paraml, paramg, paramObject, str);
/*     */         } 
/*     */       } 
/*     */     } 
/* 811 */     return g1.a(paraml, paramg, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object k(g paramg) {
/* 819 */     j j1 = this.u;
/* 820 */     return paramg.a(j1, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", new Object[] { j1 }));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */