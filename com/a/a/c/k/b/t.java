/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.l;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class t
/*     */   extends ao<Object>
/*     */   implements k
/*     */ {
/*     */   private j a;
/*     */   private i b;
/*     */   private o<Object> c;
/*     */   private c d;
/*     */   private j e;
/*     */   private boolean f;
/*     */   private transient k g;
/*     */   
/*     */   public t(j paramj, i parami, o<?> paramo) {
/* 101 */     super(paramj.c());
/* 102 */     this.a = paramj;
/* 103 */     this.e = paramj.c();
/* 104 */     this.b = parami;
/* 105 */     this.c = (o)paramo;
/* 106 */     this.d = null;
/* 107 */     this.f = true;
/* 108 */     this.g = k.a();
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
/*     */   private t(t paramt, c paramc, i parami, o<?> paramo, boolean paramBoolean) {
/* 124 */     super(a(paramt.a()));
/* 125 */     this.a = paramt.a;
/* 126 */     this.e = paramt.e;
/* 127 */     this.b = parami;
/* 128 */     this.c = (o)paramo;
/* 129 */     this.d = paramc;
/* 130 */     this.f = paramBoolean;
/* 131 */     this.g = k.a();
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Class<Object> a(Class<?> paramClass) {
/* 136 */     return (Class)((paramClass == null) ? Object.class : paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private t a(c paramc, i parami, o<?> paramo, boolean paramBoolean) {
/* 142 */     if (this.d == paramc && this.b == parami && this.c == paramo && paramBoolean == this.f)
/*     */     {
/*     */       
/* 145 */       return this;
/*     */     }
/* 147 */     return new t(this, paramc, parami, paramo, paramBoolean);
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
/*     */   public final boolean a(aa paramaa, Object paramObject) {
/* 161 */     if ((paramObject = this.a.b(paramObject)) == null) {
/* 162 */       return true;
/*     */     }
/*     */     o<Object> o1;
/* 165 */     if ((o1 = this.c) == null) {
/*     */       try {
/* 167 */         o1 = a(paramaa, paramObject.getClass());
/* 168 */       } catch (l l) {
/* 169 */         throw new w.a(l);
/*     */       } 
/*     */     }
/* 172 */     return o1.a((aa)l, paramObject);
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
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     boolean bool;
/*     */     i i1;
/* 191 */     if ((i1 = this.b) != null) {
/* 192 */       i1 = i1.a(paramc);
/*     */     }
/*     */     o<Object> o1;
/* 195 */     if ((o1 = this.c) == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 200 */       if (paramaa.a(q.p) || this.e.m()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 206 */         o1 = paramaa.b(this.e, paramc);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 211 */         bool = a(this.e.b(), o1);
/* 212 */         return a(paramc, i1, o1, bool);
/*     */       } 
/*     */       
/* 215 */       if (paramc != this.d) {
/* 216 */         return a(paramc, i1, o1, this.f);
/*     */       }
/*     */     } else {
/*     */       
/* 220 */       o1 = bool.a(o1, paramc);
/* 221 */       return a(paramc, i1, o1, this.f);
/*     */     } 
/* 223 */     return this;
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/*     */     Object object;
/*     */     try {
/* 237 */       object = this.a.b(paramObject);
/* 238 */     } catch (Exception exception) {
/* 239 */       object = null;
/* 240 */       a(paramaa, exception, paramObject, this.a.b() + "()");
/*     */     } 
/*     */     
/* 243 */     if (object == null) {
/* 244 */       paramaa.a(paramh); return;
/*     */     } 
/*     */     o<Object> o1;
/* 247 */     if ((o1 = this.c) == null) {
/* 248 */       o1 = a(paramaa, object.getClass());
/*     */     }
/* 250 */     if (this.b != null) {
/* 251 */       o1.a(object, paramh, paramaa, this.b); return;
/*     */     } 
/* 253 */     o1.a(object, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, h paramh, aa paramaa, i parami) {
/*     */     Object object;
/*     */     try {
/* 265 */       object = this.a.b(paramObject);
/* 266 */     } catch (Exception exception) {
/* 267 */       object = null;
/* 268 */       a(paramaa, exception, paramObject, this.a.b() + "()");
/*     */     } 
/*     */ 
/*     */     
/* 272 */     if (object == null) {
/* 273 */       paramaa.a(paramh);
/*     */       return;
/*     */     } 
/*     */     o<Object> o1;
/* 277 */     if ((o1 = this.c) == null) {
/* 278 */       o1 = a(paramaa, object.getClass());
/*     */ 
/*     */     
/*     */     }
/* 282 */     else if (this.f) {
/*     */       
/* 284 */       paramObject = parami.a(paramh, parami
/* 285 */           .a(paramObject, o.h));
/* 286 */       o1.a(object, paramh, paramaa);
/* 287 */       parami.b(paramh, (com.a.a.b.f.a)paramObject);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 295 */     paramObject = new a(parami, paramObject);
/* 296 */     o1.a(object, paramh, paramaa, (i)paramObject);
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
/*     */   private boolean a(Class<?> paramClass, o<?> paramo) {
/* 392 */     if (paramClass.isPrimitive()) {
/* 393 */       if (paramClass != int.class && paramClass != boolean.class && paramClass != double.class) {
/* 394 */         return false;
/*     */       }
/*     */     }
/* 397 */     else if (paramClass != String.class && paramClass != Integer.class && paramClass != Boolean.class && paramClass != Double.class) {
/*     */       
/* 399 */       return false;
/*     */     } 
/*     */     
/* 402 */     return a(paramo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> a(aa paramaa, Class<?> paramClass) {
/*     */     o<Object> o1;
/* 410 */     if ((o1 = this.g.a(paramClass)) == null) {
/* 411 */       k.d d; j j1; if (this.e.s()) {
/* 412 */         j1 = paramaa.a(this.e, paramClass);
/* 413 */         o1 = paramaa.b(j1, this.d);
/* 414 */         d = this.g.a(j1, o1);
/* 415 */         this.g = d.b;
/*     */       } else {
/* 417 */         o1 = d.b((Class)j1, this.d);
/* 418 */         k.d d1 = this.g.a((Class)j1, o1);
/* 419 */         this.g = d1.b;
/*     */       } 
/*     */     } 
/* 422 */     return o1;
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
/*     */   public final String toString() {
/* 452 */     return "(@JsonValue serializer for method " + this.a.h() + "#" + this.a.b() + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */     extends i
/*     */   {
/*     */     private i a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(i param1i, Object param1Object) {
/* 473 */       this.a = param1i;
/* 474 */       this.b = param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public final i a(c param1c) {
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public final af.a a() {
/* 484 */       return this.a.a();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String b() {
/* 489 */       return this.a.b();
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
/*     */     public final com.a.a.b.f.a a(h param1h, com.a.a.b.f.a param1a) {
/* 503 */       param1a.a = this.b;
/* 504 */       return this.a.a(param1h, param1a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final com.a.a.b.f.a b(h param1h, com.a.a.b.f.a param1a) {
/* 511 */       return this.a.b(param1h, param1a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */