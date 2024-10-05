/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.am;
/*     */ import com.a.a.a.an;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.s;
/*     */ import com.a.a.c.c.a.w;
/*     */ import com.a.a.c.c.a.z;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.w;
/*     */ import java.io.Serializable;
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
/*     */ public final class a
/*     */   extends k<Object>
/*     */   implements k, Serializable
/*     */ {
/*     */   private j a;
/*     */   private s b;
/*     */   private Map<String, v> c;
/*     */   private transient Map<String, v> d;
/*     */   private boolean e;
/*     */   private boolean f;
/*     */   private boolean g;
/*     */   private boolean h;
/*     */   
/*     */   public a(g paramg, b paramb, Map<String, v> paramMap1, Map<String, v> paramMap2) {
/*  67 */     this.a = paramb.a();
/*  68 */     this.b = paramg.e();
/*  69 */     this.c = paramMap1;
/*  70 */     this.d = paramMap2;
/*  71 */     Class<boolean> clazz = this.a.b();
/*  72 */     this.e = clazz.isAssignableFrom(String.class);
/*  73 */     this.f = (clazz == boolean.class || clazz.isAssignableFrom(Boolean.class));
/*  74 */     this.g = (clazz == int.class || clazz.isAssignableFrom(Integer.class));
/*  75 */     this.h = (clazz == double.class || clazz.isAssignableFrom(Double.class));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(b paramb) {
/*  86 */     this.a = paramb.a();
/*  87 */     this.b = null;
/*  88 */     this.c = null;
/*  89 */     Class<boolean> clazz = this.a.b();
/*  90 */     this.e = clazz.isAssignableFrom(String.class);
/*  91 */     this.f = (clazz == boolean.class || clazz.isAssignableFrom(Boolean.class));
/*  92 */     this.g = (clazz == int.class || clazz.isAssignableFrom(Integer.class));
/*  93 */     this.h = (clazz == double.class || clazz.isAssignableFrom(Double.class));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(a parama, s params, Map<String, v> paramMap) {
/* 102 */     this.a = parama.a;
/* 103 */     this.c = parama.c;
/* 104 */     this.e = parama.e;
/* 105 */     this.f = parama.f;
/* 106 */     this.g = parama.g;
/* 107 */     this.h = parama.h;
/*     */     
/* 109 */     this.b = params;
/* 110 */     this.d = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(b paramb) {
/* 120 */     return new a(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/* 127 */     com.a.a.c.a a1 = paramg.f(); j j1; ad ad;
/* 128 */     if (paramc != null && a1 != null && (
/*     */       
/* 130 */       j1 = paramc.e()) != null && (
/*     */       
/* 132 */       ad = a1.a((b)j1)) != null) {
/*     */       w w; al al;
/*     */       j j2;
/* 135 */       v v = null;
/* 136 */       an an = paramg.b((b)j1, ad);
/*     */ 
/*     */       
/*     */       Class<am.c> clazz;
/*     */ 
/*     */       
/* 142 */       if ((clazz = (ad = a1.a((b)j1, ad)).d()) == am.c.class) {
/* 143 */         w w1 = ad.b();
/*     */         
/* 145 */         if ((v = (v)((this.d == null) ? null : this.d.get(w1.b()))) == null)
/* 146 */           paramg.a(this.a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[] {
/*     */                   
/* 148 */                   i.g(a()), i.a(w1)
/*     */                 })); 
/* 150 */         j2 = v.c();
/* 151 */         w = new w(ad.c());
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 159 */         an = paramg.b((b)w, ad);
/* 160 */         j j3 = paramg.b((Class)j2);
/* 161 */         paramg.b(); j2 = o.c(j3, al.class)[0];
/* 162 */         al = paramg.a((b)w, ad);
/*     */       } 
/* 164 */       k k1 = paramg.b(j2);
/* 165 */       s s1 = s.a(j2, ad.b(), al, k1, v, an);
/*     */       
/* 167 */       return new a(this, s1, null);
/*     */     } 
/*     */ 
/*     */     
/* 171 */     if (this.d == null) {
/* 172 */       return this;
/*     */     }
/*     */     
/* 175 */     return new a(this, this.b, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> a() {
/* 186 */     return this.a.b();
/*     */   }
/*     */   
/*     */   public final boolean c() {
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f b() {
/* 196 */     return f.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/* 206 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s f() {
/* 216 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v a(String paramString) {
/* 225 */     return (this.c == null) ? null : this.c.get(paramString);
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
/*     */   public final Object a(l paraml, g paramg, e parame) {
/*     */     o o;
/* 241 */     if (this.b != null && (
/*     */       
/* 243 */       o = paraml.k()) != null) {
/*     */       
/* 245 */       if (o.g()) {
/* 246 */         return b(paraml, paramg);
/*     */       }
/*     */       
/* 249 */       if (o == o.b) {
/* 250 */         o = paraml.g();
/*     */       }
/* 252 */       if (o == o.f && this.b.c() && this.b
/* 253 */         .a(paraml.v(), paraml)) {
/* 254 */         return b(paraml, paramg);
/*     */       }
/*     */     } 
/*     */     
/*     */     Object object;
/*     */     
/* 260 */     if ((object = a(paraml)) != null) {
/* 261 */       return object;
/*     */     }
/* 263 */     return parame.a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/* 273 */     x.a a1 = new x.a(this.a);
/* 274 */     return paramg.a(this.a.b(), a1, paraml, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
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
/*     */   private Object a(l paraml) {
/* 292 */     switch (paraml.l()) {
/*     */       case 6:
/* 294 */         if (this.e) {
/* 295 */           return paraml.w();
/*     */         }
/*     */         break;
/*     */       case 7:
/* 299 */         if (this.g) {
/* 300 */           return Integer.valueOf(paraml.G());
/*     */         }
/*     */         break;
/*     */       case 8:
/* 304 */         if (this.h) {
/* 305 */           return Double.valueOf(paraml.K());
/*     */         }
/*     */         break;
/*     */       case 9:
/* 309 */         if (this.f) {
/* 310 */           return Boolean.TRUE;
/*     */         }
/*     */         break;
/*     */       case 10:
/* 314 */         if (this.f) {
/* 315 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */     } 
/* 319 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object b(l paraml, g paramg) {
/* 328 */     Object object1 = this.b.a(paraml, paramg);
/*     */     
/*     */     z z;
/*     */     Object object2;
/* 332 */     if ((object2 = (z = paramg.a(object1, this.b.b, this.b.c)).b()) == null) {
/* 333 */       throw new w(paraml, "Could not resolve Object Id [" + object1 + "] -- unresolved forward-reference?", paraml
/* 334 */           .e(), z);
/*     */     }
/* 336 */     return object2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */