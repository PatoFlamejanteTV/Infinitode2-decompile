/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
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
/*     */ public abstract class j
/*     */ {
/*     */   public static j a() {
/*  24 */     return a.b();
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
/*     */   public abstract Object a(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract j a(Object paramObject1, Object paramObject2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */     extends j
/*     */     implements Serializable
/*     */   {
/*  67 */     private static a a = new a(Collections.emptyMap());
/*     */     
/*  69 */     private static Object b = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Map<?, ?> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private transient Map<Object, Object> d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(Map<?, ?> param1Map) {
/*  93 */       this.c = param1Map;
/*  94 */       this.d = null;
/*     */     }
/*     */     
/*     */     private a(Map<?, ?> param1Map, Map<Object, Object> param1Map1) {
/*  98 */       this.c = param1Map;
/*  99 */       this.d = param1Map1;
/*     */     }
/*     */     
/*     */     public static j b() {
/* 103 */       return a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object a(Object param1Object) {
/*     */       Object object;
/* 160 */       if (this.d != null && (
/*     */         
/* 162 */         object = this.d.get(param1Object)) != null) {
/* 163 */         if (object == b) {
/* 164 */           return null;
/*     */         }
/* 166 */         return object;
/*     */       } 
/*     */       
/* 169 */       return this.c.get(param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final j a(Object param1Object1, Object param1Object2) {
/* 176 */       if (param1Object2 == null)
/*     */       {
/* 178 */         if (this.c.containsKey(param1Object1))
/* 179 */         { param1Object2 = b; }
/* 180 */         else { if (this.d == null || !this.d.containsKey(param1Object1))
/*     */           {
/* 182 */             return this;
/*     */           }
/* 184 */           this.d.remove(param1Object1);
/* 185 */           return this; }
/*     */       
/*     */       }
/*     */       
/* 189 */       if (this.d == null) {
/* 190 */         return b(param1Object1, param1Object2);
/*     */       }
/* 192 */       this.d.put(param1Object1, param1Object2);
/* 193 */       return this;
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
/*     */     
/*     */     private j b(Object param1Object1, Object param1Object2) {
/* 208 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 209 */       if (param1Object2 == null) {
/* 210 */         param1Object2 = b;
/*     */       }
/* 212 */       hashMap.put(param1Object1, param1Object2);
/* 213 */       return new a(this.c, hashMap);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */