/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.w;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class v
/*     */ {
/*     */   private int a;
/*     */   private x b;
/*     */   private HashMap<String, com.a.a.c.c.v> c;
/*     */   private com.a.a.c.c.v[] d;
/*     */   
/*     */   private v(g paramg, x paramx, com.a.a.c.c.v[] paramArrayOfv, boolean paramBoolean1, boolean paramBoolean2) {
/*  59 */     this.b = paramx;
/*  60 */     if (paramBoolean1) {
/*  61 */       this.c = a.a(paramg.c().t());
/*     */     } else {
/*  63 */       this.c = new HashMap<>();
/*     */     } 
/*  65 */     int i = paramArrayOfv.length;
/*  66 */     this.a = i;
/*  67 */     this.d = new com.a.a.c.c.v[i];
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (paramBoolean2) {
/*  72 */       f f = paramg.c(); com.a.a.c.c.v[] arrayOfV; int j; byte b1;
/*  73 */       for (j = (arrayOfV = paramArrayOfv).length, b1 = 0; b1 < j; ) {
/*     */         com.a.a.c.c.v v1; List<?> list;
/*  75 */         if (!(v1 = arrayOfV[b1]).g() && 
/*     */           
/*  77 */           !(list = v1.a((q)f)).isEmpty()) {
/*  78 */           for (w w : list) {
/*  79 */             this.c.put(w.b(), v1);
/*     */           }
/*     */         }
/*     */         b1++;
/*     */       } 
/*     */     } 
/*  85 */     for (byte b = 0; b < i; b++) {
/*  86 */       com.a.a.c.c.v v1 = paramArrayOfv[b];
/*  87 */       this.d[b] = v1;
/*     */       
/*  89 */       if (!v1.g()) {
/*  90 */         this.c.put(v1.a(), v1);
/*     */       }
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
/*     */   public static v a(g paramg, x paramx, com.a.a.c.c.v[] paramArrayOfv, c paramc) {
/*     */     int i;
/* 107 */     com.a.a.c.c.v[] arrayOfV = new com.a.a.c.c.v[i = paramArrayOfv.length];
/* 108 */     for (byte b = 0; b < i; b++) {
/*     */       com.a.a.c.c.v v1;
/* 110 */       if (!(v1 = paramArrayOfv[b]).n())
/*     */       {
/*     */         
/* 113 */         if (!v1.j()) {
/* 114 */           v1 = v1.a(paramg.a(v1.c(), (c)v1));
/*     */         }
/*     */       }
/* 117 */       arrayOfV[b] = v1;
/*     */     } 
/* 119 */     return new v(paramg, paramx, arrayOfV, paramc
/* 120 */         .c(), true);
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
/*     */   public static v a(g paramg, x paramx, com.a.a.c.c.v[] paramArrayOfv, boolean paramBoolean) {
/*     */     int i;
/* 140 */     com.a.a.c.c.v[] arrayOfV = new com.a.a.c.c.v[i = paramArrayOfv.length];
/* 141 */     for (byte b = 0; b < i; b++) {
/*     */       com.a.a.c.c.v v1;
/* 143 */       if (!(v1 = paramArrayOfv[b]).n()) {
/* 144 */         v1 = v1.a(paramg.a(v1.c(), (c)v1));
/*     */       }
/* 146 */       arrayOfV[b] = v1;
/*     */     } 
/* 148 */     return new v(paramg, paramx, arrayOfV, paramBoolean, false);
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
/*     */   public final com.a.a.c.c.v a(String paramString) {
/* 172 */     return this.c.get(paramString);
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
/*     */   public final y a(l paraml, g paramg, s params) {
/* 197 */     return new y(paraml, paramg, this.a, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, y paramy) {
/*     */     Object object;
/* 205 */     if ((object = this.b.a(paramg, this.d, paramy)) != null) {
/*     */       
/* 207 */       object = paramy.a(paramg, object);
/*     */ 
/*     */       
/* 210 */       for (x x1 = paramy.a(); x1 != null; x1 = x1.a) {
/* 211 */         x1.a(object);
/*     */       }
/*     */     } 
/* 214 */     return object;
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
/*     */   static class a
/*     */     extends HashMap<String, com.a.a.c.c.v>
/*     */   {
/*     */     private Locale a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public a() {
/* 242 */       this(Locale.getDefault());
/*     */     }
/*     */ 
/*     */     
/*     */     private a(Locale param1Locale) {
/* 247 */       this.a = param1Locale;
/*     */     }
/*     */ 
/*     */     
/*     */     public static a a(Locale param1Locale) {
/* 252 */       return new a(param1Locale);
/*     */     }
/*     */ 
/*     */     
/*     */     private com.a.a.c.c.v a(Object param1Object) {
/* 257 */       return super.get(((String)param1Object).toLowerCase(this.a));
/*     */     }
/*     */ 
/*     */     
/*     */     private com.a.a.c.c.v a(String param1String, com.a.a.c.c.v param1v) {
/* 262 */       param1String = param1String.toLowerCase(this.a);
/* 263 */       return super.put(param1String, param1v);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */