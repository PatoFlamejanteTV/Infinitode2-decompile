/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.b.b;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.j;
/*     */ import com.a.a.c.q;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class l
/*     */   extends ai<Object>
/*     */   implements k
/*     */ {
/*     */   private Object[] a;
/*     */   private final Enum<?> b;
/*     */   private j c;
/*     */   private j d;
/*     */   private Boolean e;
/*     */   private boolean f;
/*     */   
/*     */   public l(com.a.a.c.m.l paraml, Boolean paramBoolean) {
/*  69 */     super(paraml.e());
/*  70 */     this.c = paraml.a();
/*  71 */     this.a = (Object[])paraml.c();
/*  72 */     this.b = paraml.b();
/*  73 */     this.e = paramBoolean;
/*  74 */     this.f = paraml.f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private l(l paraml, Boolean paramBoolean) {
/*  82 */     super(paraml);
/*  83 */     this.c = paraml.c;
/*  84 */     this.a = paraml.a;
/*  85 */     this.b = paraml.b;
/*  86 */     this.e = paramBoolean;
/*  87 */     this.f = paraml.f;
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
/*     */   public static k<?> a(f paramf, Class<?> paramClass, k paramk, x paramx, v[] paramArrayOfv) {
/* 119 */     if (paramf.g()) {
/* 120 */       i.a(paramk.l(), paramf
/* 121 */           .a(q.o));
/*     */     }
/* 123 */     return new p(paramClass, paramk, paramk
/* 124 */         .b(0), paramx, paramArrayOfv);
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
/*     */   public static k<?> a(f paramf, Class<?> paramClass, k paramk) {
/* 139 */     if (paramf.g()) {
/* 140 */       i.a(paramk.l(), paramf
/* 141 */           .a(q.o));
/*     */     }
/* 143 */     return new p(paramClass, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private l a(Boolean paramBoolean) {
/* 150 */     if (Objects.equals(this.e, paramBoolean)) {
/* 151 */       return this;
/*     */     }
/* 153 */     return new l(this, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/*     */     Boolean bool;
/* 162 */     if ((bool = a(paramg, paramc, a(), com.a.a.a.l.a.b)) == null) {
/* 163 */       bool = this.e;
/*     */     }
/* 165 */     return a(bool);
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
/*     */   public final boolean c() {
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   public final f b() {
/* 183 */     return f.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(g paramg) {
/* 188 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(com.a.a.b.l paraml, g paramg) {
/* 197 */     if (paraml.a(o.h)) {
/* 198 */       return a(paraml, paramg, paraml.w());
/*     */     }
/*     */ 
/*     */     
/* 202 */     if (paraml.a(o.i)) {
/*     */ 
/*     */       
/* 205 */       if (this.f)
/*     */       {
/*     */         
/* 208 */         return a(paraml, paramg, paraml.w());
/*     */       }
/* 210 */       return a(paramg, paraml.G());
/*     */     } 
/*     */     
/* 213 */     if (paraml.q()) {
/* 214 */       return a(paraml, paramg, paramg
/* 215 */           .a(paraml, this.s));
/*     */     }
/* 217 */     return c(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(com.a.a.b.l paraml, g paramg, String paramString) {
/*     */     j j1;
/*     */     Object object;
/*     */     String str;
/* 227 */     if ((object = (j1 = paramg.a(i.v) ? d(paramg) : this.c).a(paramString)) == null && ((
/*     */       
/* 229 */       str = paramString.trim()) == paramString || (object = j1.a(str)) == null)) {
/* 230 */       return a(paramg, j1, str);
/*     */     }
/*     */     
/* 233 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(g paramg, int paramInt) {
/*     */     b b;
/* 244 */     if ((b = paramg.a(b(), a(), f.a)) == b.a) {
/* 245 */       if (paramg.a(i.g)) {
/* 246 */         return paramg.a(g(), Integer.valueOf(paramInt), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 251 */       a(paramg, b, a(), Integer.valueOf(paramInt), "Integer value (" + paramInt + ")");
/*     */     } 
/*     */     
/* 254 */     switch (m.a[b.ordinal()]) {
/*     */       case 1:
/* 256 */         return null;
/*     */       case 2:
/* 258 */         return c(paramg);
/*     */     } 
/*     */ 
/*     */     
/* 262 */     if (paramInt >= 0 && paramInt < this.a.length) {
/* 263 */       return this.a[paramInt];
/*     */     }
/* 265 */     if (this.b != null && paramg
/* 266 */       .a(i.x)) {
/* 267 */       return this.b;
/*     */     }
/* 269 */     if (!paramg.a(i.w))
/* 270 */       return paramg.a(g(), Integer.valueOf(paramInt), "index value outside legal index range [0..%s]", new Object[] {
/*     */             
/* 272 */             Integer.valueOf(this.a.length - 1)
/*     */           }); 
/* 274 */     return null;
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
/*     */   private final Object a(g paramg, j paramj, String paramString) {
/*     */     String str;
/* 291 */     if ((str = paramString.trim()).isEmpty()) {
/*     */       b b;
/*     */       
/* 294 */       if (this.b != null && paramg
/* 295 */         .a(i.x)) {
/* 296 */         return this.b;
/*     */       }
/* 298 */       if (paramg.a(i.w)) {
/* 299 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 303 */       if (paramString.isEmpty()) {
/* 304 */         b = g(paramg);
/* 305 */         b = a(paramg, b, a(), paramString, "empty String (\"\")");
/*     */       } else {
/*     */         
/* 308 */         b = i(paramg);
/* 309 */         b = a(paramg, b, a(), paramString, "blank String (all whitespace)");
/*     */       } 
/*     */       
/* 312 */       switch (m.a[b.ordinal()]) {
/*     */         case 2:
/*     */         case 3:
/* 315 */           return c(paramg);
/*     */       } 
/*     */ 
/*     */       
/* 319 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 323 */     if (Boolean.TRUE.equals(this.e)) {
/*     */       Object object;
/* 325 */       if ((object = paramj.b(str)) != null) {
/* 326 */         return object;
/*     */       }
/* 328 */     } else if (!paramg.a(i.g) && !this.f) {
/*     */       char c;
/*     */ 
/*     */       
/* 332 */       if ((c = str.charAt(0)) >= '0' && c <= '9') {
/*     */         try {
/* 334 */           int i = Integer.parseInt(str);
/* 335 */           if (!paramg.a(q.C)) {
/* 336 */             return paramg.b(g(), str, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
/*     */           }
/*     */ 
/*     */           
/* 340 */           if (i >= 0 && i < this.a.length) {
/* 341 */             return this.a[i];
/*     */           }
/* 343 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 349 */     if (this.b != null && paramg
/* 350 */       .a(i.x)) {
/* 351 */       return this.b;
/*     */     }
/* 353 */     if (paramg.a(i.w)) {
/* 354 */       return null;
/*     */     }
/* 356 */     return paramg.b(g(), str, "not one of the values accepted for Enum class: %s", new Object[] { paramj
/* 357 */           .a() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object c(com.a.a.b.l paraml, g paramg) {
/* 363 */     if (paraml.a(o.d)) {
/* 364 */       return d(paraml, paramg);
/*     */     }
/* 366 */     return paramg.a(g(), paraml);
/*     */   }
/*     */   
/*     */   private Class<?> g() {
/* 370 */     return a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j d(g paramg) {
/*     */     j j1;
/* 378 */     if ((j1 = this.d) == null) {
/* 379 */       synchronized (this) {
/*     */         
/* 381 */         j1 = com.a.a.c.m.l.b(paramg.c(), g()).a();
/*     */       } 
/* 383 */       this.d = j1;
/*     */     } 
/* 385 */     return j1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */