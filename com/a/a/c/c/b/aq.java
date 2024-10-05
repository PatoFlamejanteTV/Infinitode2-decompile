/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.b.s;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.t;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.f;
/*     */ import com.a.a.c.m.i;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public class aq
/*     */   extends ae<Object>
/*     */   implements k, t
/*     */ {
/*  35 */   private static Object[] a = new Object[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<Object> b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<Object> c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<Object> d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<Object> e;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j f;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean h;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public aq() {
/*  77 */     this((j)null, (j)null);
/*     */   }
/*     */   
/*     */   public aq(j paramj1, j paramj2) {
/*  81 */     super(Object.class);
/*  82 */     this.f = paramj1;
/*  83 */     this.g = paramj2;
/*  84 */     this.h = false;
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
/*     */   private aq(aq paramaq, boolean paramBoolean) {
/* 108 */     super(Object.class);
/* 109 */     this.b = paramaq.b;
/* 110 */     this.c = paramaq.c;
/* 111 */     this.d = paramaq.d;
/* 112 */     this.e = paramaq.e;
/* 113 */     this.f = paramaq.f;
/* 114 */     this.g = paramaq.g;
/* 115 */     this.h = paramBoolean;
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
/*     */   public final void d(g paramg) {
/* 133 */     j j1 = paramg.b(Object.class);
/* 134 */     j j2 = paramg.b(String.class);
/* 135 */     o o = paramg.b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     if (this.f == null) {
/* 148 */       this.c = b(a(paramg, (j)o.a(List.class, j1)));
/*     */     } else {
/*     */       
/* 151 */       this.c = a(paramg, this.f);
/*     */     } 
/* 153 */     if (this.g == null) {
/* 154 */       this.b = b(a(paramg, (j)o.a(Map.class, j2, j1)));
/*     */     } else {
/*     */       
/* 157 */       this.b = a(paramg, this.g);
/*     */     } 
/* 159 */     this.d = b(a(paramg, j2));
/* 160 */     this.e = b(a(paramg, o.a(Number.class)));
/*     */ 
/*     */ 
/*     */     
/* 164 */     j1 = o.b();
/* 165 */     this.b = paramg.b(this.b, null, j1);
/* 166 */     this.c = paramg.b(this.c, null, j1);
/* 167 */     this.d = paramg.b(this.d, null, j1);
/* 168 */     this.e = paramg.b(this.e, null, j1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static k<Object> a(g paramg, j paramj) {
/* 176 */     return paramg.a(paramj);
/*     */   }
/*     */   
/*     */   private static k<Object> b(k<Object> paramk) {
/* 180 */     return i.e(paramk) ? null : paramk;
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
/* 193 */     boolean bool = (paramc == null && Boolean.FALSE.equals(paramg.c().g(Object.class)));
/*     */ 
/*     */     
/* 196 */     if (this.d == null && this.e == null && this.b == null && this.c == null && 
/*     */       
/* 198 */       getClass() == aq.class) {
/* 199 */       return ar.a(bool);
/*     */     }
/*     */     
/* 202 */     if (bool != this.h) {
/* 203 */       return new aq(this, bool);
/*     */     }
/*     */     
/* 206 */     return this;
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
/*     */   public final boolean c() {
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 229 */     return f.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/* 235 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/* 241 */     switch (paraml.l()) {
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 2:
/*     */       case 5:
/* 247 */         if (this.b != null) {
/* 248 */           return this.b.a(paraml, paramg);
/*     */         }
/* 250 */         return e(paraml, paramg);
/*     */       case 3:
/* 252 */         if (paramg.a(i.d)) {
/* 253 */           return f(paraml, paramg);
/*     */         }
/* 255 */         if (this.c != null) {
/* 256 */           return this.c.a(paraml, paramg);
/*     */         }
/* 258 */         return c(paraml, paramg);
/*     */       case 12:
/* 260 */         return paraml.N();
/*     */       case 6:
/* 262 */         if (this.d != null) {
/* 263 */           return this.d.a(paraml, paramg);
/*     */         }
/* 265 */         return paraml.w();
/*     */       
/*     */       case 7:
/* 268 */         if (this.e != null) {
/* 269 */           return this.e.a(paraml, paramg);
/*     */         }
/*     */ 
/*     */         
/* 273 */         if (paramg.a(r)) {
/* 274 */           return u(paraml, paramg);
/*     */         }
/* 276 */         return paraml.B();
/*     */       
/*     */       case 8:
/* 279 */         if (this.e != null) {
/* 280 */           return this.e.a(paraml, paramg);
/*     */         }
/*     */         
/* 283 */         if (paramg.a(i.a)) {
/* 284 */           return paraml.L();
/*     */         }
/*     */         
/* 287 */         return paraml.B();
/*     */       
/*     */       case 9:
/* 290 */         return Boolean.TRUE;
/*     */       case 10:
/* 292 */         return Boolean.FALSE;
/*     */       
/*     */       case 11:
/* 295 */         return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 300 */     return paramg.a(Object.class, paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 307 */     switch (paraml.l()) {
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 3:
/*     */       case 5:
/* 313 */         return parame.d(paraml, paramg);
/*     */       
/*     */       case 12:
/* 316 */         return paraml.N();
/*     */ 
/*     */ 
/*     */       
/*     */       case 6:
/* 321 */         if (this.d != null) {
/* 322 */           return this.d.a(paraml, paramg);
/*     */         }
/* 324 */         return paraml.w();
/*     */       
/*     */       case 7:
/* 327 */         if (this.e != null) {
/* 328 */           return this.e.a(paraml, paramg);
/*     */         }
/*     */         
/* 331 */         if (paramg.a(r)) {
/* 332 */           return u(paraml, paramg);
/*     */         }
/* 334 */         return paraml.B();
/*     */       
/*     */       case 8:
/* 337 */         if (this.e != null) {
/* 338 */           return this.e.a(paraml, paramg);
/*     */         }
/* 340 */         if (paramg.a(i.a)) {
/* 341 */           return paraml.L();
/*     */         }
/* 343 */         return paraml.B();
/*     */       
/*     */       case 9:
/* 346 */         return Boolean.TRUE;
/*     */       case 10:
/* 348 */         return Boolean.FALSE;
/*     */       
/*     */       case 11:
/* 351 */         return null;
/*     */     } 
/*     */     
/* 354 */     return paramg.a(Object.class, paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, Object paramObject) {
/* 362 */     if (this.h) {
/* 363 */       return a(paraml, paramg);
/*     */     }
/*     */     
/* 366 */     switch (paraml.l()) {
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 2:
/*     */       case 5:
/* 372 */         if (this.b != null) {
/* 373 */           return this.b.a(paraml, paramg, paramObject);
/*     */         }
/* 375 */         if (paramObject instanceof Map) {
/* 376 */           return a(paraml, paramg, (Map<Object, Object>)paramObject);
/*     */         }
/* 378 */         return e(paraml, paramg);
/*     */       case 3:
/* 380 */         if (this.c != null) {
/* 381 */           return this.c.a(paraml, paramg, paramObject);
/*     */         }
/* 383 */         if (paramObject instanceof Collection) {
/* 384 */           return a(paraml, paramg, (Collection<Object>)paramObject);
/*     */         }
/* 386 */         if (paramg.a(i.d)) {
/* 387 */           return f(paraml, paramg);
/*     */         }
/* 389 */         return c(paraml, paramg);
/*     */       case 12:
/* 391 */         return paraml.N();
/*     */       case 6:
/* 393 */         if (this.d != null) {
/* 394 */           return this.d.a(paraml, paramg, paramObject);
/*     */         }
/* 396 */         return paraml.w();
/*     */       
/*     */       case 7:
/* 399 */         if (this.e != null) {
/* 400 */           return this.e.a(paraml, paramg, paramObject);
/*     */         }
/* 402 */         if (paramg.a(r)) {
/* 403 */           return u(paraml, paramg);
/*     */         }
/* 405 */         return paraml.B();
/*     */       
/*     */       case 8:
/* 408 */         if (this.e != null) {
/* 409 */           return this.e.a(paraml, paramg, paramObject);
/*     */         }
/* 411 */         if (paramg.a(i.a)) {
/* 412 */           return paraml.L();
/*     */         }
/* 414 */         return paraml.B();
/*     */       case 9:
/* 416 */         return Boolean.TRUE;
/*     */       case 10:
/* 418 */         return Boolean.FALSE;
/*     */ 
/*     */       
/*     */       case 11:
/* 422 */         return null;
/*     */     } 
/*     */ 
/*     */     
/* 426 */     return a(paraml, paramg);
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
/*     */   private Object c(l paraml, g paramg) {
/* 441 */     if (paraml.g() == o.e) {
/* 442 */       return new ArrayList(2);
/*     */     }
/* 444 */     Object object1 = a(paraml, paramg);
/* 445 */     if (paraml.g() == o.e) {
/*     */       ArrayList<Object> arrayList1;
/* 447 */       (arrayList1 = new ArrayList(2)).add(object1);
/* 448 */       return arrayList1;
/*     */     } 
/* 450 */     Object object2 = a(paraml, paramg);
/* 451 */     if (paraml.g() == o.e) {
/*     */       ArrayList<Object> arrayList1;
/* 453 */       (arrayList1 = new ArrayList(2)).add(object1);
/* 454 */       arrayList1.add(object2);
/* 455 */       return arrayList1;
/*     */     } 
/*     */     f f;
/* 458 */     Object[] arrayOfObject = (f = paramg.n()).a();
/* 459 */     byte b2 = 0;
/* 460 */     b2++; arrayOfObject[0] = object1;
/* 461 */     b2++; arrayOfObject[1] = object2;
/* 462 */     byte b1 = 2;
/*     */     do {
/* 464 */       object1 = a(paraml, paramg);
/* 465 */       b1++;
/* 466 */       if (b2 >= arrayOfObject.length) {
/* 467 */         arrayOfObject = f.a(arrayOfObject);
/* 468 */         b2 = 0;
/*     */       } 
/* 470 */       arrayOfObject[b2++] = object1;
/* 471 */     } while (paraml.g() != o.e);
/*     */     
/* 473 */     ArrayList arrayList = new ArrayList(b1);
/* 474 */     f.a(arrayOfObject, b2, arrayList);
/* 475 */     paramg.a(f);
/* 476 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, g paramg, Collection<Object> paramCollection) {
/* 484 */     while (paraml.g() != o.e) {
/* 485 */       paramCollection.add(a(paraml, paramg));
/*     */     }
/* 487 */     return paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object e(l paraml, g paramg) {
/*     */     String str1;
/*     */     o o;
/* 498 */     if ((o = paraml.k()) == o.b) {
/* 499 */       str1 = paraml.h();
/* 500 */     } else if (str1 == o.f) {
/* 501 */       str1 = paraml.v();
/*     */     } else {
/* 503 */       if (str1 != o.c) {
/* 504 */         return paramg.a(a(), paraml);
/*     */       }
/* 506 */       str1 = null;
/*     */     } 
/* 508 */     if (str1 == null)
/*     */     {
/* 510 */       return new LinkedHashMap<>(2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 515 */     paraml.g();
/* 516 */     Object object1 = a(paraml, paramg);
/*     */     String str2;
/* 518 */     if ((str2 = paraml.h()) == null) {
/*     */       LinkedHashMap<Object, Object> linkedHashMap1;
/*     */       
/* 521 */       (linkedHashMap1 = new LinkedHashMap<>(2)).put(str1, object1);
/* 522 */       return linkedHashMap1;
/*     */     } 
/* 524 */     paraml.g();
/* 525 */     Object object2 = a(paraml, paramg);
/*     */     
/*     */     String str3;
/* 528 */     if ((str3 = paraml.h()) == null) {
/*     */       LinkedHashMap<Object, Object> linkedHashMap1;
/* 530 */       (linkedHashMap1 = new LinkedHashMap<>(4)).put(str1, object1);
/* 531 */       if (linkedHashMap1.put(str2, object2) != null)
/*     */       {
/* 533 */         return a(paraml, paramg, (Map)linkedHashMap1, str1, object1, object2, str3);
/*     */       }
/* 535 */       return linkedHashMap1;
/*     */     } 
/*     */     
/*     */     LinkedHashMap<Object, Object> linkedHashMap;
/* 539 */     (linkedHashMap = new LinkedHashMap<>()).put(str1, object1);
/* 540 */     if (linkedHashMap.put(str2, object2) != null)
/*     */     {
/* 542 */       return a(paraml, paramg, (Map)linkedHashMap, str1, object1, object2, str3);
/*     */     }
/*     */     
/*     */     while (true) {
/* 546 */       paraml.g();
/* 547 */       Object object = a(paraml, paramg);
/*     */       
/* 549 */       if ((object1 = linkedHashMap.put(str3, object)) != null) {
/* 550 */         return a(paraml, paramg, (Map)linkedHashMap, str3, object1, object, paraml
/* 551 */             .h());
/*     */       }
/* 553 */       if ((str3 = paraml.h()) == null) {
/* 554 */         return linkedHashMap;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, g paramg, Map<String, Object> paramMap, String paramString1, Object paramObject1, Object paramObject2, String paramString2) {
/*     */     boolean bool;
/* 564 */     if (bool = paramg.a(s.a)) {
/* 565 */       a(paramMap, paramString1, paramObject1, paramObject2);
/*     */     }
/*     */     
/* 568 */     while (paramString2 != null) {
/* 569 */       paraml.g();
/* 570 */       paramObject2 = a(paraml, paramg);
/*     */       
/* 572 */       if ((paramObject1 = paramMap.put(paramString2, paramObject2)) != null && bool) {
/* 573 */         a(paramMap, paramString1, paramObject1, paramObject2);
/*     */       }
/* 575 */       paramString2 = paraml.h();
/*     */     } 
/*     */     
/* 578 */     return paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(Map<String, Object> paramMap, String paramString, Object paramObject1, Object paramObject2) {
/* 585 */     if (paramObject1 instanceof List) {
/* 586 */       ((List<Object>)paramObject1).add(paramObject2);
/* 587 */       paramMap.put(paramString, paramObject1); return;
/*     */     } 
/*     */     ArrayList<Object> arrayList;
/* 590 */     (arrayList = new ArrayList()).add(paramObject1);
/* 591 */     arrayList.add(paramObject2);
/* 592 */     paramMap.put(paramString, arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object[] f(l paraml, g paramg) {
/* 602 */     if (paraml.g() == o.e) {
/* 603 */       return a;
/*     */     }
/*     */     f f;
/* 606 */     Object[] arrayOfObject = (f = paramg.n()).a();
/* 607 */     byte b = 0;
/*     */     while (true) {
/* 609 */       Object object = a(paraml, paramg);
/* 610 */       if (b >= arrayOfObject.length) {
/* 611 */         arrayOfObject = f.a(arrayOfObject);
/* 612 */         b = 0;
/*     */       } 
/* 614 */       arrayOfObject[b++] = object;
/* 615 */       if (paraml.g() == o.e) {
/* 616 */         object = f.b(arrayOfObject, b);
/* 617 */         paramg.a(f);
/* 618 */         return (Object[])object;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object a(l paraml, g paramg, Map<Object, Object> paramMap) {
/*     */     o o;
/* 625 */     if ((o = paraml.k()) == o.b) {
/* 626 */       o = paraml.g();
/*     */     }
/* 628 */     if (o == o.c) {
/* 629 */       return paramMap;
/*     */     }
/*     */     
/* 632 */     String str = paraml.v(); while (true) {
/*     */       Object object2;
/* 634 */       paraml.g();
/*     */ 
/*     */       
/*     */       Object object1;
/*     */       
/* 639 */       if ((object1 = paramMap.get(str)) != null) {
/* 640 */         object2 = a(paraml, paramg, object1);
/*     */       } else {
/* 642 */         object2 = a(paraml, paramg);
/*     */       } 
/* 644 */       if (object2 != object1) {
/* 645 */         paramMap.put(str, object2);
/*     */       }
/* 647 */       if ((str = paraml.h()) == null)
/* 648 */         return paramMap; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\aq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */