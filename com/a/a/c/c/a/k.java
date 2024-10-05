/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.j;
/*     */ import com.a.a.c.c.b.s;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.g;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class k
/*     */ {
/*     */   public static x b(Class<?> paramClass) {
/*  25 */     if (paramClass == j.class) {
/*  26 */       return (x)new s();
/*     */     }
/*     */ 
/*     */     
/*  30 */     if (Collection.class.isAssignableFrom(paramClass)) {
/*  31 */       if (paramClass == ArrayList.class) {
/*  32 */         return (x)a.a;
/*     */       }
/*  34 */       if (Collections.EMPTY_SET.getClass() == paramClass) {
/*  35 */         return (x)new b(Collections.EMPTY_SET);
/*     */       }
/*  37 */       if (Collections.EMPTY_LIST.getClass() == paramClass) {
/*  38 */         return (x)new b(Collections.EMPTY_LIST);
/*     */       }
/*  40 */     } else if (Map.class.isAssignableFrom(paramClass)) {
/*  41 */       if (paramClass == LinkedHashMap.class) {
/*  42 */         return (x)d.a;
/*     */       }
/*  44 */       if (paramClass == HashMap.class) {
/*  45 */         return (x)c.a;
/*     */       }
/*  47 */       if (Collections.EMPTY_MAP.getClass() == paramClass) {
/*  48 */         return (x)new b(Collections.EMPTY_MAP);
/*     */       }
/*     */     } 
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */     extends x.a
/*     */     implements Serializable
/*     */   {
/*  60 */     public static final a a = new a();
/*     */     public a() {
/*  62 */       super(ArrayList.class);
/*     */     }
/*     */     
/*     */     public final boolean d() {
/*  66 */       return true;
/*     */     }
/*     */     public final boolean l() {
/*  69 */       return true;
/*     */     }
/*     */     
/*     */     public final Object a(g param1g) {
/*  73 */       return new ArrayList();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class c
/*     */     extends x.a
/*     */     implements Serializable
/*     */   {
/*  83 */     public static final c a = new c();
/*     */     
/*     */     public c() {
/*  86 */       super(HashMap.class);
/*     */     }
/*     */     
/*     */     public final boolean d() {
/*  90 */       return true;
/*     */     }
/*     */     public final boolean l() {
/*  93 */       return true;
/*     */     }
/*     */     
/*     */     public final Object a(g param1g) {
/*  97 */       return new HashMap<>();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */     extends x.a
/*     */     implements Serializable
/*     */   {
/* 107 */     public static final d a = new d();
/*     */     
/*     */     public d() {
/* 110 */       super(LinkedHashMap.class);
/*     */     }
/*     */     
/*     */     public final boolean d() {
/* 114 */       return true;
/*     */     }
/*     */     public final boolean l() {
/* 117 */       return true;
/*     */     }
/*     */     
/*     */     public final Object a(g param1g) {
/* 121 */       return new LinkedHashMap<>();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class b
/*     */     extends x.a
/*     */     implements Serializable
/*     */   {
/*     */     private Object a;
/*     */ 
/*     */     
/*     */     public b(Object param1Object) {
/* 134 */       super(param1Object.getClass());
/* 135 */       this.a = param1Object;
/*     */     }
/*     */     
/*     */     public final boolean d() {
/* 139 */       return true;
/*     */     }
/*     */     public final boolean l() {
/* 142 */       return true;
/*     */     }
/*     */     
/*     */     public final Object a(g param1g) {
/* 146 */       return this.a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */