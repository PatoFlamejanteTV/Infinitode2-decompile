/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.f;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.j;
/*     */ import com.a.a.c.m.c;
/*     */ import com.a.a.c.m.f;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import com.d.h.w;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ae<T>
/*     */   extends ao<T>
/*     */   implements k
/*     */ {
/*  35 */   private static Object g = s.a.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final i b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final o<Object> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final r d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient k j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Object e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ae(j paramj, i parami, o<Object> paramo) {
/* 100 */     super((j)paramj);
/* 101 */     this.i = paramj.v();
/* 102 */     this.a = null;
/* 103 */     this.b = parami;
/* 104 */     this.c = paramo;
/* 105 */     this.d = null;
/* 106 */     this.e = null;
/* 107 */     this.f = false;
/* 108 */     this.j = k.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ae(ae<?> paramae, c paramc, i parami, o<?> paramo, r paramr, Object paramObject, boolean paramBoolean) {
/* 117 */     super(paramae);
/* 118 */     this.i = paramae.i;
/*     */     
/* 120 */     this.j = k.a();
/* 121 */     this.a = paramc;
/* 122 */     this.b = parami;
/* 123 */     this.c = (o)paramo;
/* 124 */     this.d = paramr;
/* 125 */     this.e = paramObject;
/* 126 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<T> a(r paramr) {
/*     */     o<Object> o1;
/* 132 */     if ((o1 = this.c) != null)
/*     */     {
/*     */ 
/*     */       
/* 136 */       if ((o1 = o1.a(paramr)) == this.c) {
/* 137 */         return this;
/*     */       }
/*     */     }
/*     */     
/* 141 */     paramr = (this.d == null) ? paramr : r.a(paramr, this.d);
/* 142 */     if (this.c == o1 && this.d == paramr) {
/* 143 */       return this;
/*     */     }
/* 145 */     return a(this.a, this.b, o1, paramr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract ae<T> a(c paramc, i parami, o<?> paramo, r paramr);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ae<T> a(Object paramObject, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean c(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Object b(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Object a(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     ae<T> ae1;
/*     */     i i1;
/* 202 */     if ((i1 = this.b) != null) {
/* 203 */       i1 = i1.a(paramc);
/*     */     }
/*     */     
/*     */     o<?> o1;
/* 207 */     if ((o1 = b(paramaa, paramc)) == null)
/*     */     {
/*     */       
/* 210 */       if ((o1 = this.c) == null) {
/*     */         
/* 212 */         if (a(paramaa, paramc, this.i)) {
/* 213 */           o1 = a(paramaa, this.i, paramc);
/*     */         }
/*     */       } else {
/* 216 */         o1 = paramaa.a(o1, paramc);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 221 */     if (this.a == paramc && this.b == i1 && this.c == o1) {
/*     */       
/* 223 */       ae1 = this;
/*     */     } else {
/* 225 */       ae1 = a(paramc, (i)ae1, o1, this.d);
/*     */     } 
/*     */     s.b b;
/*     */     s.a a;
/* 229 */     if (paramc != null && (
/*     */       
/* 231 */       b = paramc.b((q)paramaa.c(), a())) != null && (
/*     */ 
/*     */       
/* 234 */       a = b.c()) != s.a.g) {
/*     */       boolean bool;
/*     */       Object object;
/* 237 */       switch (af.a[a.ordinal()]) {
/*     */         case 1:
/* 239 */           object = f.a(this.i);
/* 240 */           bool = true;
/* 241 */           if (object != null && 
/* 242 */             object.getClass().isArray()) {
/* 243 */             object = c.a(object);
/*     */           }
/*     */           break;
/*     */         
/*     */         case 2:
/* 248 */           bool = true;
/* 249 */           object = this.i.F() ? g : null;
/*     */           break;
/*     */         case 3:
/* 252 */           bool = true;
/* 253 */           object = g;
/*     */           break;
/*     */         
/*     */         case 4:
/* 257 */           if ((object = bool.a(null, object.e())) == null) {
/* 258 */             bool = true; break;
/*     */           } 
/* 260 */           bool = bool.b(object);
/*     */           break;
/*     */         
/*     */         case 5:
/* 264 */           object = null;
/* 265 */           bool = true;
/*     */           break;
/*     */         
/*     */         default:
/* 269 */           object = null;
/* 270 */           bool = false;
/*     */           break;
/*     */       } 
/* 273 */       if (this.e != object || this.f != bool)
/*     */       {
/* 275 */         ae1 = ae1.a(object, bool);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 280 */     return ae1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(aa paramaa, c paramc, j paramj) {
/* 287 */     if (paramj.q()) {
/* 288 */       return false;
/*     */     }
/*     */     
/* 291 */     if (paramj.m()) {
/* 292 */       return true;
/*     */     }
/*     */     
/* 295 */     if (paramj.r()) {
/* 296 */       return true;
/*     */     }
/*     */     a a;
/*     */     j j1;
/* 300 */     if ((a = paramaa.d()) != null && paramc != null && (
/*     */       
/* 302 */       j1 = paramc.e()) != null) {
/*     */       f.b b;
/* 304 */       if ((b = a.r((b)paramc.e())) == f.b.b) {
/* 305 */         return true;
/*     */       }
/* 307 */       if (b == f.b.a) {
/* 308 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 313 */     return paramaa.a(q.p);
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
/*     */   public final boolean a(aa paramaa, T paramT) {
/* 326 */     if (!c(paramT)) {
/* 327 */       return true;
/*     */     }
/*     */     
/* 330 */     if ((paramT = (T)b(paramT)) == null) {
/* 331 */       return this.f;
/*     */     }
/* 333 */     if (this.e == null) {
/* 334 */       return false;
/*     */     }
/*     */     o<Object> o1;
/* 337 */     if ((o1 = this.c) == null) {
/*     */       try {
/* 339 */         o1 = a(paramaa, paramT.getClass());
/* 340 */       } catch (l l) {
/* 341 */         throw new w.a(l);
/*     */       } 
/*     */     }
/* 344 */     if (this.e == g) {
/* 345 */       return o1.a((aa)l, paramT);
/*     */     }
/* 347 */     return this.e.equals(paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 352 */     return (this.d != null);
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
/*     */   public final void a(T paramT, h paramh, aa paramaa) {
/* 373 */     if ((paramT = (T)a(paramT)) == null) {
/* 374 */       if (this.d == null) {
/* 375 */         paramaa.a(paramh);
/*     */       }
/*     */       return;
/*     */     } 
/*     */     o<Object> o1;
/* 380 */     if ((o1 = this.c) == null) {
/* 381 */       o1 = a(paramaa, paramT.getClass());
/*     */     }
/* 383 */     if (this.b != null) {
/* 384 */       o1.a(paramT, paramh, paramaa, this.b); return;
/*     */     } 
/* 386 */     o1.a(paramT, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(T paramT, h paramh, aa paramaa, i parami) {
/* 396 */     if ((paramT = (T)a(paramT)) == null) {
/* 397 */       if (this.d == null) {
/* 398 */         paramaa.a(paramh);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     o<Object> o1;
/*     */ 
/*     */ 
/*     */     
/* 414 */     if ((o1 = this.c) == null) {
/* 415 */       o1 = a(paramaa, paramT.getClass());
/*     */     }
/* 417 */     o1.a(paramT, paramh, paramaa, parami);
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
/*     */   private final o<Object> a(aa paramaa, Class<?> paramClass) {
/*     */     o<Object> o1;
/* 454 */     if ((o1 = this.j.a(paramClass)) == null) {
/*     */ 
/*     */ 
/*     */       
/* 458 */       if (this.i.s()) {
/*     */ 
/*     */         
/* 461 */         j j1 = paramaa.a(this.i, paramClass);
/*     */ 
/*     */ 
/*     */         
/* 465 */         o o2 = paramaa.b(j1, this.a);
/*     */       } else {
/* 467 */         o1 = paramaa.b(paramClass, this.a);
/*     */       } 
/* 469 */       if (this.d != null) {
/* 470 */         o1 = o1.a(this.d);
/*     */       }
/* 472 */       this.j = this.j.b(paramClass, o1);
/*     */     } 
/* 474 */     return o1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static o<Object> a(aa paramaa, j paramj, c paramc) {
/* 485 */     return paramaa.b(paramj, paramc);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */