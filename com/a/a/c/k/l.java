/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.k.a.v;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.w;
/*     */ import com.a.a.c.y;
/*     */ import com.a.a.c.z;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class l
/*     */   extends aa
/*     */   implements Serializable
/*     */ {
/*     */   private transient Map<Object, v> b;
/*     */   private transient ArrayList<al<?>> c;
/*     */   private transient h d;
/*     */   
/*     */   protected l() {}
/*     */   
/*     */   protected l(aa paramaa, y paramy, r paramr) {
/*  70 */     super(paramaa, paramy, paramr);
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
/*     */   public abstract l a(y paramy, r paramr);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<Object> b(b paramb, Object paramObject) {
/*     */     o o;
/* 107 */     if (paramObject == null) {
/* 108 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 112 */     if (paramObject instanceof o) {
/* 113 */       o = (o)paramObject;
/*     */     }
/*     */     else {
/*     */       
/* 117 */       if (!(paramObject instanceof Class)) {
/* 118 */         a(o.c(), "AnnotationIntrospector returned serializer definition of type " + paramObject
/*     */             
/* 120 */             .getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
/*     */       }
/*     */ 
/*     */       
/* 124 */       if ((paramObject = paramObject) == o.a.class || i.e((Class)paramObject)) {
/* 125 */         return null;
/*     */       }
/* 127 */       if (!o.class.isAssignableFrom((Class<?>)paramObject)) {
/* 128 */         a(o.c(), "AnnotationIntrospector returned Class " + paramObject
/*     */             
/* 130 */             .getName() + "; expected Class<JsonSerializer>");
/*     */       }
/*     */       
/*     */       d d;
/* 134 */       if ((o = (o)(((d = this.a.m()) == null) ? null : d.f())) == null) {
/* 135 */         o = (o)i.b((Class)paramObject, this.a
/* 136 */             .g());
/*     */       }
/*     */     } 
/* 139 */     return a(o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(s params, Class<?> paramClass) {
/* 146 */     if (paramClass == null) {
/* 147 */       return null;
/*     */     }
/*     */     Object object;
/*     */     d d;
/* 151 */     if ((object = ((d = this.a.m()) == null) ? null : d.o()) == null) {
/* 152 */       object = i.b(paramClass, this.a
/* 153 */           .g());
/*     */     }
/* 155 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(Object paramObject) {
/* 161 */     if (paramObject == null) {
/* 162 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 167 */       return paramObject.equals((Object)null);
/* 168 */     } catch (Exception exception) {
/* 169 */       String str = String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", new Object[] { paramObject
/*     */             
/* 171 */             .getClass().getName(), exception.getClass().getName(), i.g(exception) });
/* 172 */       a(paramObject.getClass(), str, exception);
/* 173 */       return false;
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
/*     */   public final v a(Object paramObject, al<?> paramal) {
/* 186 */     if (this.b == null) {
/* 187 */       this.b = n();
/*     */     } else {
/*     */       v v1;
/* 190 */       if ((v1 = this.b.get(paramObject)) != null) {
/* 191 */         return v1;
/*     */       }
/*     */     } 
/*     */     
/* 195 */     al<?> al1 = null;
/*     */     
/* 197 */     if (this.c == null) {
/* 198 */       this.c = new ArrayList<>(8);
/*     */     } else {
/* 200 */       byte b; int i; for (b = 0, i = this.c.size(); b < i; b++) {
/*     */         al<?> al2;
/* 202 */         if ((al2 = this.c.get(b)).a(paramal)) {
/* 203 */           al1 = al2;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 208 */     if (al1 == null) {
/* 209 */       al1 = paramal.b();
/* 210 */       this.c.add(al1);
/*     */     } 
/* 212 */     v v = new v(al1);
/* 213 */     this.b.put(paramObject, v);
/* 214 */     return v;
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
/*     */   private Map<Object, v> n() {
/* 229 */     if (a(z.u)) {
/* 230 */       return new HashMap<>();
/*     */     }
/* 232 */     return new IdentityHashMap<>();
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
/*     */   public final h j() {
/* 284 */     return this.d;
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
/*     */   public final void a(h paramh, Object paramObject) {
/* 301 */     this.d = paramh;
/* 302 */     if (paramObject == null) {
/* 303 */       b(paramh);
/*     */       return;
/*     */     } 
/* 306 */     Class<?> clazz = paramObject.getClass();
/*     */     
/* 308 */     o<Object> o = a(clazz, true, (c)null);
/*     */     w w;
/* 310 */     if ((w = this.a.x()) == null) {
/* 311 */       if (this.a.a(z.a)) {
/* 312 */         a(paramh, paramObject, o, this.a.h(clazz));
/*     */         return;
/*     */       } 
/* 315 */     } else if (!w.e()) {
/* 316 */       a(paramh, paramObject, o, w);
/*     */       return;
/*     */     } 
/* 319 */     a(paramh, paramObject, o);
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
/*     */   public final void a(h paramh, Object paramObject, j paramj) {
/* 335 */     this.d = paramh;
/* 336 */     if (paramObject == null) {
/* 337 */       b(paramh);
/*     */       
/*     */       return;
/*     */     } 
/* 341 */     if (!paramj.b().isAssignableFrom(paramObject.getClass())) {
/* 342 */       a(paramObject, paramj);
/*     */     }
/*     */     
/* 345 */     o<Object> o = a(paramj, true, (c)null);
/*     */     w w;
/* 347 */     if ((w = this.a.x()) == null) {
/* 348 */       if (this.a.a(z.a)) {
/* 349 */         a(paramh, paramObject, o, this.a.e(paramj));
/*     */         return;
/*     */       } 
/* 352 */     } else if (!w.e()) {
/* 353 */       a(paramh, paramObject, o, w);
/*     */       return;
/*     */     } 
/* 356 */     a(paramh, paramObject, o);
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
/*     */   public final void a(h paramh, Object paramObject, j paramj, o<Object> paramo) {
/* 374 */     this.d = paramh;
/* 375 */     if (paramObject == null) {
/* 376 */       b(paramh);
/*     */       
/*     */       return;
/*     */     } 
/* 380 */     if (paramj != null && !paramj.b().isAssignableFrom(paramObject.getClass())) {
/* 381 */       a(paramObject, paramj);
/*     */     }
/*     */     
/* 384 */     if (paramo == null) {
/* 385 */       paramo = a(paramj, true, (c)null);
/*     */     }
/*     */     w w;
/* 388 */     if ((w = this.a.x()) == null) {
/* 389 */       if (this.a.a(z.a)) {
/*     */ 
/*     */         
/* 392 */         w = (paramj == null) ? this.a.h(paramObject.getClass()) : this.a.e(paramj);
/* 393 */         a(paramh, paramObject, paramo, w);
/*     */         return;
/*     */       } 
/* 396 */     } else if (!w.e()) {
/* 397 */       a(paramh, paramObject, paramo, w);
/*     */       return;
/*     */     } 
/* 400 */     a(paramh, paramObject, paramo);
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
/*     */   public final void a(h paramh, Object paramObject, j paramj, o<Object> paramo, i parami) {
/*     */     boolean bool;
/* 413 */     this.d = paramh;
/* 414 */     if (paramObject == null) {
/* 415 */       b(paramh);
/*     */       
/*     */       return;
/*     */     } 
/* 419 */     if (paramj != null && !paramj.b().isAssignableFrom(paramObject.getClass())) {
/* 420 */       a(paramObject, paramj);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 427 */     if (paramo == null) {
/* 428 */       if (paramj != null && paramj.n()) {
/* 429 */         paramo = a(paramj, (c)null);
/*     */       } else {
/* 431 */         paramo = a(paramObject.getClass(), (c)null);
/*     */       } 
/*     */     }
/*     */     
/*     */     w w;
/*     */     
/* 437 */     if ((w = this.a.x()) == null) {
/*     */       
/* 439 */       if (bool = this.a.a(z.a)) {
/* 440 */         paramh.i();
/* 441 */         w = this.a.h(paramObject.getClass());
/* 442 */         paramh.b(w.a((q)this.a));
/*     */       } 
/* 444 */     } else if (w.e()) {
/* 445 */       bool = false;
/*     */     } else {
/* 447 */       bool = true;
/* 448 */       paramh.i();
/* 449 */       paramh.a(w.b());
/*     */     } 
/*     */     try {
/* 452 */       paramo.a(paramObject, paramh, this, parami);
/* 453 */       if (bool)
/* 454 */         paramh.j(); 
/*     */       return;
/* 456 */     } catch (Exception exception) {
/* 457 */       throw a(paramh, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void a(h paramh, Object paramObject, o<Object> paramo, w paramw) {
/*     */     try {
/* 466 */       paramh.i();
/* 467 */       paramh.b(paramw.a((q)this.a));
/* 468 */       paramo.a(paramObject, paramh, this);
/* 469 */       paramh.j(); return;
/* 470 */     } catch (Exception exception) {
/* 471 */       throw a(paramh, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void a(h paramh, Object paramObject, o<Object> paramo) {
/*     */     try {
/* 480 */       paramo.a(paramObject, paramh, this); return;
/* 481 */     } catch (Exception exception) {
/* 482 */       throw a(paramh, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(h paramh) {
/* 493 */     o o = k();
/*     */     try {
/* 495 */       o.a(null, paramh, this); return;
/* 496 */     } catch (Exception exception) {
/* 497 */       throw a(paramh, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static IOException a(h paramh, Exception paramException) {
/* 502 */     if (paramException instanceof IOException) {
/* 503 */       return (IOException)paramException;
/*     */     }
/*     */     String str;
/* 506 */     if ((str = i.g(paramException)) == null) {
/* 507 */       str = "[no message for " + paramException.getClass().getName() + "]";
/*     */     }
/* 509 */     return (IOException)new com.a.a.c.l((Closeable)paramh, str, paramException);
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
/*     */   public static final class a
/*     */     extends l
/*     */   {
/*     */     public a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(aa param1aa, y param1y, r param1r) {
/* 614 */       super(param1aa, param1y, param1r);
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
/*     */     private a b(y param1y, r param1r) {
/* 628 */       return new a(this, param1y, param1r);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */