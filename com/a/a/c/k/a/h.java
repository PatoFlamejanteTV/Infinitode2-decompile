/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.c;
/*     */ import com.a.a.c.m.f;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class h
/*     */   extends j<Map.Entry<?, ?>>
/*     */   implements k
/*     */ {
/*  33 */   private static Object a = s.a.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(j paramj1, j paramj2, j paramj3, boolean paramBoolean, i parami, c paramc) {
/* 111 */     super(paramj1);
/* 112 */     this.d = paramj1;
/* 113 */     this.e = paramj2;
/* 114 */     this.f = paramj3;
/* 115 */     this.c = paramBoolean;
/* 116 */     this.j = parami;
/* 117 */     this.b = paramc;
/* 118 */     this.k = k.a();
/* 119 */     this.l = null;
/* 120 */     this.m = false;
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
/*     */   private h(h paramh, o<?> paramo1, o<?> paramo2, Object paramObject, boolean paramBoolean) {
/* 138 */     super(Map.class, false);
/* 139 */     this.d = paramh.d;
/* 140 */     this.e = paramh.e;
/* 141 */     this.f = paramh.f;
/* 142 */     this.c = paramh.c;
/* 143 */     this.j = paramh.j;
/* 144 */     this.g = (o)paramo1;
/* 145 */     this.i = (o)paramo2;
/*     */     
/* 147 */     this.k = k.a();
/* 148 */     this.b = paramh.b;
/* 149 */     this.l = paramObject;
/* 150 */     this.m = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/* 155 */     return new h(this, this.g, this.i, this.l, this.m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h a(c paramc, o<?> paramo1, o<?> paramo2, Object paramObject, boolean paramBoolean) {
/* 165 */     return new h(this, paramo1, paramo2, paramObject, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final h a(Object paramObject, boolean paramBoolean) {
/* 174 */     if (this.l == paramObject && this.m == paramBoolean)
/*     */     {
/* 176 */       return this;
/*     */     }
/* 178 */     return new h(this, this.g, this.i, paramObject, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/* 186 */     o<Object> o1 = null;
/* 187 */     o<Object> o2 = null;
/* 188 */     a a = paramaa.d();
/*     */     
/*     */     j j1;
/*     */     
/* 192 */     if ((j1 = (j)((paramc == null) ? null : paramc.e())) != null && a != null) {
/*     */       Object object1;
/* 194 */       if ((object1 = a.o((b)j1)) != null) {
/* 195 */         o2 = paramaa.b((b)j1, object1);
/*     */       }
/*     */       
/* 198 */       if ((object1 = a.p((b)j1)) != null) {
/* 199 */         o1 = paramaa.b((b)j1, object1);
/*     */       }
/*     */     } 
/* 202 */     if (o1 == null) {
/* 203 */       o1 = this.i;
/*     */     }
/*     */ 
/*     */     
/* 207 */     if ((o1 = a(paramaa, paramc, o1)) == null)
/*     */     {
/*     */ 
/*     */       
/* 211 */       if (this.c && !this.f.q()) {
/* 212 */         o1 = paramaa.c(this.f, paramc);
/*     */       }
/*     */     }
/* 215 */     if (o2 == null) {
/* 216 */       o2 = this.g;
/*     */     }
/* 218 */     if (o2 == null) {
/* 219 */       o2 = paramaa.d(this.e, paramc);
/*     */     } else {
/* 221 */       o2 = paramaa.b(o2, paramc);
/*     */     } 
/*     */     
/* 224 */     Object object = this.l;
/* 225 */     boolean bool = this.m; s.b b; s.a a1;
/* 226 */     if (paramc != null && (
/*     */       
/* 228 */       b = paramc.b((q)paramaa.c(), null)) != null && (
/*     */       
/* 230 */       a1 = b.c()) != s.a.g)
/* 231 */     { h h2; switch (i.a[a1.ordinal()])
/*     */       { case 1:
/* 233 */           object = f.a(this.f);
/* 234 */           bool = true;
/* 235 */           if (object != null && 
/* 236 */             object.getClass().isArray()) {
/* 237 */             object = c.a(object);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 276 */           return (o<?>)(h2 = a(paramc, o2, o1, object, bool));case 2: bool = true; object = this.f.F() ? a : null; return (o<?>)(h2 = a(paramc, o2, o1, object, bool));case 3: bool = true; object = a; return (o<?>)(h2 = a(paramc, o2, o1, object, bool));case 4: if ((object = paramaa.a(null, h2.e())) == null) { bool = true; } else { bool = paramaa.b(object); }  return (o<?>)(h2 = a(paramc, o2, o1, object, bool));case 5: object = null; bool = true; return (o<?>)(h2 = a(paramc, o2, o1, object, bool)); }  object = null; bool = false; }  h h1; return (o<?>)(h1 = a(paramc, o2, o1, object, bool));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j d() {
/* 287 */     return this.f;
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
/*     */   private boolean a(aa paramaa, Map.Entry<?, ?> paramEntry) {
/* 304 */     if ((paramEntry = (Map.Entry<?, ?>)paramEntry.getValue()) == null) {
/* 305 */       return this.m;
/*     */     }
/* 307 */     if (this.l == null) {
/* 308 */       return false;
/*     */     }
/*     */     o<Object> o1;
/* 311 */     if ((o1 = this.i) == null) {
/*     */ 
/*     */       
/* 314 */       Class<?> clazz = paramEntry.getClass();
/*     */       
/* 316 */       if ((o1 = this.k.a(clazz)) == null) {
/*     */         try {
/* 318 */           o1 = a(this.k, clazz, paramaa);
/* 319 */         } catch (l l) {
/* 320 */           return false;
/*     */         } 
/*     */       }
/*     */     } 
/* 324 */     if (this.l == a) {
/* 325 */       return o1.a(paramaa, paramEntry);
/*     */     }
/* 327 */     return this.l.equals(paramEntry);
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
/*     */   private void a(Map.Entry<?, ?> paramEntry, com.a.a.b.h paramh, aa paramaa) {
/* 340 */     paramh.c(paramEntry);
/* 341 */     b(paramEntry, paramh, paramaa);
/* 342 */     paramh.j();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Map.Entry<?, ?> paramEntry, com.a.a.b.h paramh, aa paramaa, i parami) {
/* 350 */     paramh.a(paramEntry);
/* 351 */     a a = parami.a(paramh, parami
/* 352 */         .a(paramEntry, o.b));
/* 353 */     b(paramEntry, paramh, paramaa);
/* 354 */     parami.b(paramh, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Map.Entry<?, ?> paramEntry, com.a.a.b.h paramh, aa paramaa) {
/*     */     o<Object> o1, o2;
/* 361 */     i i1 = this.j;
/*     */     
/*     */     Object object1;
/*     */     
/* 365 */     if ((object1 = paramEntry.getKey()) == null) {
/* 366 */       o1 = paramaa.l();
/*     */     } else {
/* 368 */       o1 = this.g;
/*     */     } 
/*     */ 
/*     */     
/*     */     Object object2;
/*     */     
/* 374 */     if ((object2 = paramEntry.getValue()) == null) {
/* 375 */       if (this.m) {
/*     */         return;
/*     */       }
/* 378 */       o2 = paramaa.k();
/*     */     }
/*     */     else {
/*     */       
/* 382 */       Class<?> clazz = object2.getClass();
/*     */       
/* 384 */       if ((o2 = this.i) == null && (o2 = this.k.a(clazz)) == null) {
/* 385 */         if (this.f.s()) {
/* 386 */           o2 = a(this.k, paramaa
/* 387 */               .a(this.f, clazz), paramaa);
/*     */         } else {
/* 389 */           o2 = a(this.k, clazz, paramaa);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 394 */       if (this.l != null) {
/* 395 */         if (this.l == a && 
/* 396 */           o2.a(paramaa, object2)) {
/*     */           return;
/*     */         }
/* 399 */         if (this.l.equals(object2)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 404 */     o1.a(object1, paramh, paramaa);
/*     */     try {
/* 406 */       if (i1 == null) {
/* 407 */         o2.a(object2, paramh, paramaa);
/*     */       } else {
/* 409 */         o2.a(object2, paramh, paramaa, i1); return;
/*     */       } 
/* 411 */     } catch (Exception exception) {
/* 412 */       Object object = object1;
/* 413 */       a(paramaa, exception, paramEntry, (String)object);
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
/*     */   private o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/* 426 */     k.d d = paramk.b(paramClass, paramaa, this.b);
/* 427 */     if (paramk != d.b) {
/* 428 */       this.k = d.b;
/*     */     }
/* 430 */     return d.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> a(k paramk, j paramj, aa paramaa) {
/* 436 */     k.d d = paramk.b(paramj, paramaa, this.b);
/* 437 */     if (paramk != d.b) {
/* 438 */       this.k = d.b;
/*     */     }
/* 440 */     return d.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */