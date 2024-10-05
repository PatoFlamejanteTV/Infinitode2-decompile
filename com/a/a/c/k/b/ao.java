/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.o;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.IdentityHashMap;
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
/*     */ public abstract class ao<T>
/*     */   extends o<T>
/*     */   implements Serializable
/*     */ {
/*  44 */   private static final Object a = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Class<T> h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ao(Class<T> paramClass) {
/*  59 */     this.h = paramClass;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ao(j paramj) {
/*  64 */     this.h = paramj.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ao(Class<?> paramClass, byte paramByte) {
/*  73 */     this.h = (Class)paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ao(ao<?> paramao) {
/*  81 */     this.h = paramao.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<T> a() {
/*  91 */     return this.h;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void a(T paramT, h paramh, aa paramaa);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(aa paramaa, Throwable paramThrowable, Object paramObject, String paramString) {
/* 301 */     while (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/* 302 */       paramThrowable = paramThrowable.getCause();
/*     */     }
/*     */     
/* 305 */     i.a(paramThrowable);
/*     */     
/* 307 */     boolean bool = (paramaa == null || paramaa.a(z.e)) ? true : false;
/* 308 */     if (paramThrowable instanceof IOException) {
/* 309 */       if (!bool || !(paramThrowable instanceof com.a.a.b.d)) {
/* 310 */         throw (IOException)paramThrowable;
/*     */       }
/* 312 */     } else if (!bool) {
/* 313 */       i.b(paramThrowable);
/*     */     } 
/*     */     
/* 316 */     throw l.a(paramThrowable, paramObject, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(aa paramaa, Throwable paramThrowable, Object paramObject, int paramInt) {
/* 323 */     while (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/* 324 */       paramThrowable = paramThrowable.getCause();
/*     */     }
/*     */     
/* 327 */     i.a(paramThrowable);
/*     */     
/* 329 */     boolean bool = (paramaa == null || paramaa.a(z.e)) ? true : false;
/* 330 */     if (paramThrowable instanceof IOException) {
/* 331 */       if (!bool || !(paramThrowable instanceof com.a.a.b.d)) {
/* 332 */         throw (IOException)paramThrowable;
/*     */       }
/* 334 */     } else if (!bool) {
/* 335 */       i.b(paramThrowable);
/*     */     } 
/*     */     
/* 338 */     throw l.a(paramThrowable, paramObject, paramInt);
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
/*     */   protected final o<?> a(aa paramaa, c paramc, o<?> paramo) {
/*     */     Map<Object, Object> map;
/* 365 */     if ((map = (Map)paramaa.a(a)) != null) {
/*     */       Object object;
/* 367 */       if ((object = map.get(paramc)) != null) {
/* 368 */         return paramo;
/*     */       }
/*     */     } else {
/* 371 */       map = new IdentityHashMap<>();
/* 372 */       paramaa.a(a, map);
/*     */     } 
/* 374 */     map.put(paramc, Boolean.TRUE);
/*     */     try {
/*     */       o<?> o1;
/* 377 */       if ((o1 = b(paramaa, paramc, paramo)) != null) {
/* 378 */         return paramaa.b(o1, paramc);
/*     */       }
/*     */     } finally {
/* 381 */       map.remove(paramc);
/*     */     } 
/* 383 */     return paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   private static o<?> b(aa paramaa, c paramc, o<?> paramo) {
/*     */     a a;
/*     */     Object object;
/*     */     j j;
/* 395 */     if (a(a = paramaa.d(), paramc) && (
/*     */       
/* 397 */       j = paramc.e()) != null && (
/*     */       
/* 399 */       object = a.i(j)) != null) {
/*     */       
/* 401 */       paramaa.b(); k<Object, ?> k; object = (k = paramaa.a((b)paramc.e(), object)).b();
/*     */       
/* 403 */       if (paramo == null && !object.q()) {
/* 404 */         paramo = paramaa.a((j)object);
/*     */       }
/* 406 */       return new aj(k, (j)object, paramo);
/*     */     } 
/*     */ 
/*     */     
/* 410 */     return paramo;
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
/*     */   protected final o a(aa paramaa, Object paramObject1, Object paramObject2) {
/* 425 */     if ((paramObject2 = paramaa.i()) == null) {
/* 426 */       return (o)paramaa.a(a(), "Cannot resolve PropertyFilter with id '" + paramObject1 + "'; no FilterProvider configured");
/*     */     }
/*     */ 
/*     */     
/* 430 */     return paramObject2.a(paramObject1);
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
/*     */   protected static l.d a(aa paramaa, c paramc, Class<?> paramClass) {
/* 445 */     if (paramc != null) {
/* 446 */       return paramc.a((q)paramaa.c(), paramClass);
/*     */     }
/*     */     
/* 449 */     return paramaa.a(paramClass);
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
/*     */   protected final Boolean a(aa paramaa, c paramc, Class<?> paramClass, l.a parama) {
/*     */     l.d d;
/* 465 */     if ((d = a(paramaa, paramc, paramClass)) != null) {
/* 466 */       return d.a(parama);
/*     */     }
/* 468 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static s.b b(aa paramaa, c paramc, Class<?> paramClass) {
/* 477 */     if (paramc != null) {
/* 478 */       return paramc.b((q)paramaa.c(), paramClass);
/*     */     }
/*     */     
/* 481 */     return paramaa.b(paramClass);
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
/*     */   protected static o<?> b(aa paramaa, c paramc) {
/* 493 */     if (paramc != null) {
/*     */       
/* 495 */       j j = paramc.e();
/* 496 */       a a = paramaa.d(); Object object;
/* 497 */       if (j != null && (
/*     */         
/* 499 */         object = a.p((b)j)) != null) {
/* 500 */         return paramaa.b((b)j, object);
/*     */       }
/*     */     } 
/*     */     
/* 504 */     return null;
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
/*     */   protected static boolean a(o<?> paramo) {
/* 520 */     return i.e(paramo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final boolean a(Object paramObject1, Object paramObject2) {
/* 527 */     return (paramObject1 != null && paramObject2 != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final boolean a(Collection<?> paramCollection) {
/* 534 */     return (paramCollection != null && !paramCollection.isEmpty());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\ao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */