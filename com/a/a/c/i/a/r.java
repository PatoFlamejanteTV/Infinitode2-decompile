/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.b.w;
/*     */ import com.a.a.c.d;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class r
/*     */   extends e
/*     */   implements Serializable
/*     */ {
/*     */   protected final g a;
/*     */   protected final j b;
/*     */   protected final c c;
/*     */   protected final j d;
/*     */   protected final String e;
/*     */   protected final boolean f;
/*     */   private Map<String, k<Object>> g;
/*     */   private k<Object> h;
/*     */   
/*     */   protected r(j paramj1, g paramg, String paramString, boolean paramBoolean, j paramj2) {
/*  73 */     this.b = paramj1;
/*  74 */     this.a = paramg;
/*  75 */     this.e = i.a(paramString);
/*  76 */     this.f = paramBoolean;
/*     */     
/*  78 */     this.g = new ConcurrentHashMap<>(16, 0.75F, 2);
/*  79 */     this.d = paramj2;
/*  80 */     this.c = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected r(r paramr, c paramc) {
/*  85 */     this.b = paramr.b;
/*  86 */     this.a = paramr.a;
/*  87 */     this.e = paramr.e;
/*  88 */     this.f = paramr.f;
/*  89 */     this.g = paramr.g;
/*  90 */     this.d = paramr.d;
/*  91 */     this.h = paramr.h;
/*  92 */     this.c = paramc;
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
/*     */   public final String g() {
/* 107 */     return this.b.b().getName();
/*     */   }
/*     */   public final String b() {
/* 110 */     return this.e;
/*     */   }
/*     */   public final g c() {
/* 113 */     return this.a;
/*     */   }
/*     */   
/*     */   public final Class<?> d() {
/* 117 */     return i.a(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 122 */     return (this.d != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j h() {
/* 129 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     StringBuilder stringBuilder;
/* 136 */     (stringBuilder = new StringBuilder()).append('[').append(getClass().getName());
/* 137 */     stringBuilder.append("; base-type:").append(this.b);
/* 138 */     stringBuilder.append("; id-resolver: ").append(this.a);
/* 139 */     stringBuilder.append(']');
/* 140 */     return stringBuilder.toString();
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
/*     */   protected final k<Object> a(g paramg, String paramString) {
/*     */     k<Object> k1;
/* 153 */     if ((k1 = this.g.get(paramString)) == null) {
/*     */       j j1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       if ((j1 = this.a.a((d)paramg, paramString)) == null) {
/*     */ 
/*     */         
/* 163 */         if ((k1 = a(paramg)) == null) {
/*     */           j j2;
/*     */           
/* 166 */           if ((j2 = c(paramg, paramString)) == null)
/*     */           {
/* 168 */             return (k<Object>)w.a;
/*     */           }
/*     */           
/* 171 */           k1 = paramg.a(j2, this.c);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 182 */         if (this.b != null && this.b
/* 183 */           .getClass() == k1.getClass())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 193 */           if (!k1.s()) {
/*     */             try {
/* 195 */               j j2 = paramg.a(this.b, k1.b());
/* 196 */             } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */               
/* 199 */               throw paramg.a(this.b, paramString, illegalArgumentException.getMessage());
/*     */             } 
/*     */           }
/*     */         }
/* 203 */         k1 = paramg.a((j)illegalArgumentException, this.c);
/*     */       } 
/* 205 */       this.g.put(paramString, k1);
/*     */     } 
/* 207 */     return k1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final k<Object> a(g paramg) {
/* 215 */     if (this.d == null) {
/* 216 */       if (!paramg.a(i.h)) {
/* 217 */         return (k<Object>)w.a;
/*     */       }
/* 219 */       return null;
/*     */     } 
/*     */     Class clazz;
/* 222 */     if (i.e(clazz = this.d.b())) {
/* 223 */       return (k<Object>)w.a;
/*     */     }
/*     */     
/* 226 */     synchronized (this.d) {
/* 227 */       if (this.h == null) {
/* 228 */         this.h = paramg.a(this.d, this.c);
/*     */       }
/*     */       
/* 231 */       return this.h;
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
/*     */   protected final Object a(l paraml, g paramg, Object<Object> paramObject) {
/*     */     k<Object> k1;
/* 257 */     if (paramObject == null) {
/*     */ 
/*     */ 
/*     */       
/* 261 */       if ((paramObject = (Object<Object>)a(paramg)) == null) {
/* 262 */         return paramg.a(h(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
/*     */       }
/*     */     } else {
/*     */       
/* 266 */       paramObject = (paramObject instanceof String) ? paramObject : (Object<Object>)String.valueOf(paramObject);
/* 267 */       k1 = a(paramg, (String)paramObject);
/*     */     } 
/* 269 */     return k1.a(paraml, paramg);
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
/*     */   private j c(g paramg, String paramString) {
/*     */     String str;
/* 289 */     if ((str = this.a.b()) == null) {
/* 290 */       str = "type ids are not statically known";
/*     */     } else {
/* 292 */       str = "known type ids = " + str;
/*     */     } 
/* 294 */     if (this.c != null) {
/* 295 */       str = String.format("%s (for POJO property '%s')", new Object[] { str, this.c
/* 296 */             .a() });
/*     */     }
/* 298 */     return paramg.a(this.b, paramString, this.a, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final j b(g paramg, String paramString) {
/* 307 */     return paramg.a(this.b, this.a, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */