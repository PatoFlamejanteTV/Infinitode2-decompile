/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.q;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class d
/*     */   implements Serializable
/*     */ {
/*     */   private b a;
/*     */   private s b;
/*     */   private s[] c;
/*     */   private Map<Class<?>, s> d;
/*     */   
/*     */   static {
/*  19 */     f.values();
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
/*     */   public d() {
/*  49 */     this(b.b, new s(), null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d(b paramb, s params, s[] paramArrayOfs, Map<Class<?>, s> paramMap) {
/*  58 */     this.b = params;
/*  59 */     this.a = paramb;
/*  60 */     this.c = paramArrayOfs;
/*  61 */     this.d = paramMap;
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
/*     */   public final b a(f paramf, f paramf1, Class<?> paramClass, f paramf2) {
/*     */     b b2;
/*     */     s s2;
/* 166 */     if (this.d != null && paramClass != null && (
/*     */       
/* 168 */       s2 = this.d.get(paramClass)) != null && (
/*     */       
/* 170 */       b2 = s2.a(paramf2)) != null) {
/* 171 */       return b2;
/*     */     }
/*     */     
/*     */     b b1;
/*     */     
/*     */     s s1;
/* 177 */     if (this.c != null && paramf1 != null && (
/*     */       
/* 179 */       s1 = this.c[paramf1.ordinal()]) != null && (
/*     */       
/* 181 */       b1 = s1.a(paramf2)) != null) {
/* 182 */       return b1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     if ((b1 = this.b.a(paramf2)) != null) {
/* 190 */       return b1;
/*     */     }
/*     */ 
/*     */     
/* 194 */     switch (e.a[paramf2.ordinal()]) {
/*     */       
/*     */       case 1:
/* 197 */         return paramf.a(i.t) ? b.c : b.a;
/*     */       
/*     */       case 2:
/* 200 */         if (paramf1 == f.f)
/*     */         {
/* 202 */           return paramf.a(i.u) ? b.b : b.a;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 207 */         if (paramf1 == f.i && 
/* 208 */           paramf.a(i.g)) {
/* 209 */           return b.a;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean bool;
/* 220 */     if ((bool = a(paramf1)) && 
/*     */       
/* 222 */       !paramf.a(q.C) && (paramf1 != f.g || paramf2 != f.a))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       return b.a;
/*     */     }
/*     */     
/* 231 */     if (paramf2 == f.f) {
/*     */ 
/*     */       
/* 234 */       if (bool || paramf
/*     */         
/* 236 */         .a(i.s)) {
/* 237 */         return b.c;
/*     */       }
/*     */ 
/*     */       
/* 241 */       if (paramf1 == f.m) {
/* 242 */         return b.b;
/*     */       }
/*     */       
/* 245 */       return b.a;
/*     */     } 
/*     */ 
/*     */     
/* 249 */     return this.a;
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
/*     */   public final b a(f paramf, f paramf1, Class<?> paramClass, b paramb) {
/* 272 */     Boolean bool = null;
/* 273 */     b b1 = null;
/*     */     
/*     */     s s1;
/* 276 */     if (this.d != null && paramClass != null && (
/*     */       
/* 278 */       s1 = this.d.get(paramClass)) != null) {
/* 279 */       bool = s1.a();
/* 280 */       b1 = s1.a(f.f);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 285 */     if (this.c != null && paramf1 != null && (
/*     */       
/* 287 */       s1 = this.c[paramf1.ordinal()]) != null) {
/* 288 */       if (bool == null) {
/* 289 */         bool = s1.a();
/*     */       }
/* 291 */       if (b1 == null) {
/* 292 */         b1 = s1.a(f.f);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 298 */     if (bool == null) {
/* 299 */       bool = this.b.a();
/*     */     }
/* 301 */     if (b1 == null) {
/* 302 */       b1 = this.b.a(f.f);
/*     */     }
/*     */ 
/*     */     
/* 306 */     if (Boolean.FALSE.equals(bool)) {
/* 307 */       return paramb;
/*     */     }
/*     */     
/* 310 */     if (b1 != null) {
/* 311 */       return b1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 316 */     if (a(paramf1)) {
/* 317 */       return b.c;
/*     */     }
/*     */ 
/*     */     
/* 321 */     if (paramf.a(i.s)) {
/* 322 */       return b.c;
/*     */     }
/*     */ 
/*     */     
/* 326 */     return paramb;
/*     */   }
/*     */   
/*     */   private static boolean a(f paramf) {
/* 330 */     return (paramf == f.g || paramf == f.f || paramf == f.h || paramf == f.l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */