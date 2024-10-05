/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.o;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class aj
/*     */   extends x
/*     */   implements Serializable
/*     */ {
/*     */   private String a;
/*     */   private Class<?> b;
/*     */   private o c;
/*     */   private o d;
/*     */   private v[] e;
/*     */   private j f;
/*     */   private o g;
/*     */   private v[] h;
/*     */   private j i;
/*     */   private o j;
/*     */   private v[] k;
/*     */   private o l;
/*     */   private o m;
/*     */   private o n;
/*     */   private o o;
/*     */   private o p;
/*     */   private o q;
/*     */   private o r;
/*     */   
/*     */   public aj(j paramj) {
/*  88 */     this.a = (paramj == null) ? "UNKNOWN TYPE" : paramj.toString();
/*  89 */     this.b = (paramj == null) ? Object.class : paramj.b();
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
/*     */   public final void a(o paramo1, o paramo2, j paramj, v[] paramArrayOfv1, o paramo3, v[] paramArrayOfv2) {
/* 132 */     this.c = paramo1;
/* 133 */     this.g = paramo2;
/* 134 */     this.f = paramj;
/* 135 */     this.h = paramArrayOfv1;
/* 136 */     this.d = paramo3;
/* 137 */     this.e = paramArrayOfv2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo, j paramj, v[] paramArrayOfv) {
/* 145 */     this.j = paramo;
/* 146 */     this.i = paramj;
/* 147 */     this.k = paramArrayOfv;
/*     */   }
/*     */   
/*     */   public final void a(o paramo) {
/* 151 */     this.l = paramo;
/*     */   }
/*     */   
/*     */   public final void b(o paramo) {
/* 155 */     this.m = paramo;
/*     */   }
/*     */   
/*     */   public final void c(o paramo) {
/* 159 */     this.n = paramo;
/*     */   }
/*     */   public final void d(o paramo) {
/* 162 */     this.o = paramo;
/*     */   }
/*     */   public final void e(o paramo) {
/* 165 */     this.p = paramo;
/*     */   }
/*     */   public final void f(o paramo) {
/* 168 */     this.q = paramo;
/*     */   }
/*     */   public final void g(o paramo) {
/* 171 */     this.r = paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String c() {
/* 182 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class<?> b() {
/* 187 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 192 */     return (this.l != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean f() {
/* 197 */     return (this.m != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 202 */     return (this.n != null);
/*     */   }
/*     */   
/*     */   public final boolean h() {
/* 206 */     return (this.o != null);
/*     */   }
/*     */   
/*     */   public final boolean i() {
/* 210 */     return (this.p != null);
/*     */   }
/*     */   
/*     */   public final boolean j() {
/* 214 */     return (this.q != null);
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 218 */     return (this.r != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean l() {
/* 223 */     return (this.c != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean m() {
/* 228 */     return (this.f != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean n() {
/* 233 */     return (this.i != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean o() {
/* 238 */     return (this.d != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 243 */     if (l() || 
/* 244 */       m() || n() || 
/* 245 */       o() || e() || 
/* 246 */       f() || g() || 
/* 247 */       i() || k()) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final j p() {
/* 252 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j q() {
/* 257 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v[] a(f paramf) {
/* 262 */     return this.e;
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
/*     */   public final Object a(g paramg) {
/* 274 */     if (this.c == null) {
/* 275 */       return super.a(paramg);
/*     */     }
/*     */     try {
/* 278 */       return this.c.g();
/* 279 */     } catch (Exception exception) {
/* 280 */       return paramg.a(this.b, null, (Throwable)b(paramg, exception));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, Object[] paramArrayOfObject) {
/* 287 */     if (this.d == null) {
/* 288 */       return super.a(paramg, paramArrayOfObject);
/*     */     }
/*     */     try {
/* 291 */       return this.d.a(paramArrayOfObject);
/* 292 */     } catch (Exception exception) {
/* 293 */       return paramg.a(this.b, paramArrayOfObject, (Throwable)b(paramg, exception));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, Object paramObject) {
/* 301 */     if (this.g == null && 
/* 302 */       this.j != null) {
/* 303 */       return a(this.j, this.k, paramg, paramObject);
/*     */     }
/*     */     
/* 306 */     return a(this.g, this.h, paramg, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(g paramg, Object paramObject) {
/* 312 */     if (this.j == null && 
/* 313 */       this.g != null)
/*     */     {
/* 315 */       return a(paramg, paramObject);
/*     */     }
/*     */     
/* 318 */     return a(this.j, this.k, paramg, paramObject);
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
/*     */   public final Object a(g paramg, String paramString) {
/* 330 */     if (this.l != null) {
/*     */       try {
/* 332 */         return this.l.a(paramString);
/* 333 */       } catch (Throwable throwable) {
/* 334 */         return paramg.a(this.l.h(), paramString, (Throwable)
/* 335 */             b(paramg, throwable));
/*     */       } 
/*     */     }
/* 338 */     return super.a(paramg, paramString);
/*     */   }
/*     */   
/*     */   public final Object a(g paramg, int paramInt) {
/*     */     Integer integer;
/*     */     Long long_;
/*     */     BigInteger bigInteger;
/* 345 */     if (this.m != null) {
/* 346 */       integer = Integer.valueOf(paramInt);
/*     */       try {
/* 348 */         return this.m.a(integer);
/* 349 */       } catch (Throwable throwable) {
/* 350 */         return paramg.a(this.m.h(), integer, (Throwable)
/* 351 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */     
/* 355 */     if (this.n != null) {
/* 356 */       long_ = Long.valueOf(integer);
/*     */       try {
/* 358 */         return this.n.a(long_);
/* 359 */       } catch (Throwable throwable) {
/* 360 */         return paramg.a(this.n.h(), long_, (Throwable)
/* 361 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */     
/* 365 */     if (this.o != null) {
/* 366 */       bigInteger = BigInteger.valueOf(long_);
/*     */       try {
/* 368 */         return this.o.a(bigInteger);
/* 369 */       } catch (Throwable throwable) {
/* 370 */         return paramg.a(this.o.h(), bigInteger, (Throwable)
/* 371 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 376 */     return super.a(paramg, bigInteger);
/*     */   }
/*     */   
/*     */   public final Object a(g paramg, long paramLong) {
/*     */     Long long_;
/*     */     BigInteger bigInteger;
/* 382 */     if (this.n != null) {
/* 383 */       long_ = Long.valueOf(paramLong);
/*     */       try {
/* 385 */         return this.n.a(long_);
/* 386 */       } catch (Throwable throwable) {
/* 387 */         return paramg.a(this.n.h(), long_, (Throwable)
/* 388 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 393 */     if (this.o != null) {
/* 394 */       bigInteger = BigInteger.valueOf(long_);
/*     */       try {
/* 396 */         return this.o.a(bigInteger);
/* 397 */       } catch (Throwable throwable) {
/* 398 */         return paramg.a(this.o.h(), bigInteger, (Throwable)
/* 399 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 404 */     return super.a(paramg, bigInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, BigInteger paramBigInteger) {
/* 410 */     if (this.o != null) {
/*     */       try {
/* 412 */         return this.o.a(paramBigInteger);
/* 413 */       } catch (Throwable throwable) {
/* 414 */         return paramg.a(this.o.h(), paramBigInteger, (Throwable)
/* 415 */             b(paramg, throwable));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 420 */     return super.a(paramg, paramBigInteger);
/*     */   }
/*     */   
/*     */   public final Object a(g paramg, double paramDouble) {
/*     */     Double double_;
/*     */     BigDecimal bigDecimal;
/* 426 */     if (this.p != null) {
/* 427 */       double_ = Double.valueOf(paramDouble);
/*     */       try {
/* 429 */         return this.p.a(double_);
/* 430 */       } catch (Throwable throwable) {
/* 431 */         return paramg.a(this.p.h(), double_, (Throwable)
/* 432 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */     
/* 436 */     if (this.q != null) {
/* 437 */       bigDecimal = BigDecimal.valueOf(double_);
/*     */       try {
/* 439 */         return this.q.a(bigDecimal);
/* 440 */       } catch (Throwable throwable) {
/* 441 */         return paramg.a(this.q.h(), bigDecimal, (Throwable)
/* 442 */             b(paramg, throwable));
/*     */       } 
/*     */     } 
/*     */     
/* 446 */     return super.a(paramg, bigDecimal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, BigDecimal paramBigDecimal) {
/* 452 */     if (this.q != null) {
/*     */       try {
/* 454 */         return this.q.a(paramBigDecimal);
/* 455 */       } catch (Throwable throwable1) {
/* 456 */         return paramg.a(this.q.h(), paramBigDecimal, (Throwable)
/* 457 */             b(paramg, throwable1));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Double double_;
/*     */ 
/*     */     
/* 466 */     if (this.p != null && (
/*     */       
/* 468 */       double_ = a(paramBigDecimal)) != null) {
/*     */       try {
/* 470 */         return this.p.a(double_);
/* 471 */       } catch (Throwable throwable) {
/* 472 */         return paramg.a(this.p.h(), double_, (Throwable)
/* 473 */             b(paramg, throwable));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 478 */     return super.a(paramg, (BigDecimal)throwable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double a(BigDecimal paramBigDecimal) {
/*     */     double d;
/* 487 */     return Double.isInfinite(d = paramBigDecimal.doubleValue()) ? null : Double.valueOf(d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, boolean paramBoolean) {
/* 493 */     if (this.r == null) {
/* 494 */       return super.a(paramg, paramBoolean);
/*     */     }
/* 496 */     Boolean bool = Boolean.valueOf(paramBoolean);
/*     */     try {
/* 498 */       return this.r.a(bool);
/* 499 */     } catch (Throwable throwable) {
/* 500 */       return paramg.a(this.r.h(), bool, (Throwable)
/* 501 */           b(paramg, throwable));
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
/*     */   public final o s() {
/* 513 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o t() {
/* 518 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o r() {
/* 523 */     return this.c;
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
/*     */   private l a(g paramg, Throwable paramThrowable) {
/* 584 */     if (paramThrowable instanceof l) {
/* 585 */       return (l)paramThrowable;
/*     */     }
/* 587 */     return paramg.a(b(), paramThrowable);
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
/*     */   private l b(g paramg, Throwable paramThrowable) {
/* 602 */     if (paramThrowable instanceof ExceptionInInitializerError || paramThrowable instanceof java.lang.reflect.InvocationTargetException) {
/*     */       Throwable throwable;
/*     */ 
/*     */       
/* 606 */       if ((throwable = paramThrowable.getCause()) != null) {
/* 607 */         paramThrowable = throwable;
/*     */       }
/*     */     } 
/* 610 */     return a(paramg, paramThrowable);
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
/*     */   private Object a(o paramo, v[] paramArrayOfv, g paramg, Object paramObject) {
/* 625 */     if (paramo == null) {
/* 626 */       throw new IllegalStateException("No delegate constructor for " + c());
/*     */     }
/*     */     
/*     */     try {
/* 630 */       if (paramArrayOfv == null) {
/* 631 */         return paramo.a(paramObject);
/*     */       }
/*     */       
/*     */       int i;
/* 635 */       Object[] arrayOfObject = new Object[i = paramArrayOfv.length];
/* 636 */       for (byte b = 0; b < i; b++) {
/*     */         v v1;
/* 638 */         if ((v1 = paramArrayOfv[b]) == null) {
/* 639 */           arrayOfObject[b] = paramObject;
/*     */         } else {
/* 641 */           arrayOfObject[b] = paramg.a(v1.i(), (c)v1, null);
/*     */         } 
/*     */       } 
/*     */       
/* 645 */       return paramo.a(arrayOfObject);
/* 646 */     } catch (Throwable throwable) {
/* 647 */       throw b(paramg, throwable);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\aj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */