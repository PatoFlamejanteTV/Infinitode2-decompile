/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public final class j
/*     */   implements Serializable
/*     */ {
/*  25 */   private static final j a = new j(1, 0, new Object[4]);
/*     */   
/*     */   private final int b;
/*     */   
/*     */   private final int c;
/*     */   
/*     */   private final Object[] d;
/*     */   
/*     */   private j(int paramInt1, int paramInt2, Object[] paramArrayOfObject) {
/*  34 */     this.b = paramInt1;
/*  35 */     this.c = paramInt2;
/*  36 */     this.d = paramArrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> j a(Map<String, T> paramMap) {
/*  41 */     if (paramMap.isEmpty()) {
/*  42 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  47 */     int i, k = (i = a(paramMap.size())) - 1;
/*     */     
/*     */     int m;
/*  50 */     Object[] arrayOfObject = new Object[m = i + (i >> 1) << 1];
/*  51 */     byte b = 0;
/*     */     
/*  53 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */       
/*  57 */       if ((str = (entry = iterator.next()).getKey()) != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  62 */         int n, i1 = (n = str.hashCode() & k) + n;
/*     */ 
/*     */         
/*  65 */         if (arrayOfObject[i1] != null) {
/*     */           
/*  67 */           i1 = i + (n >> 1) << 1;
/*  68 */           if (arrayOfObject[i1] != null) {
/*     */             
/*  70 */             i1 = (i + (i >> 1) << 1) + b;
/*  71 */             b += 2;
/*  72 */             if (i1 >= arrayOfObject.length) {
/*  73 */               arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length + 4);
/*     */             }
/*     */           } 
/*     */         } 
/*  77 */         arrayOfObject[i1] = str;
/*  78 */         arrayOfObject[i1 + 1] = entry.getValue();
/*     */       } 
/*  80 */     }  return new j(k, b, arrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int a(int paramInt) {
/*  85 */     if (paramInt <= 5) {
/*  86 */       return 8;
/*     */     }
/*  88 */     if (paramInt <= 12) {
/*  89 */       return 16;
/*     */     }
/*  91 */     paramInt += paramInt >> 2;
/*  92 */     int i = 32;
/*  93 */     while (i < paramInt) {
/*  94 */       i += i;
/*     */     }
/*  96 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(String paramString) {
/* 101 */     int i, k = (i = paramString.hashCode() & this.b) << 1;
/*     */     Object object;
/* 103 */     if ((object = this.d[k]) == paramString || paramString.equals(object)) {
/* 104 */       return this.d[k + 1];
/*     */     }
/* 106 */     return a(paramString, i, object);
/*     */   }
/*     */ 
/*     */   
/*     */   private final Object a(String paramString, int paramInt, Object paramObject) {
/* 111 */     if (paramObject == null) {
/* 112 */       return null;
/*     */     }
/*     */     int i;
/* 115 */     paramInt = (i = this.b + 1) + (paramInt >> 1) << 1;
/* 116 */     paramObject = this.d[paramInt];
/* 117 */     if (paramString.equals(paramObject)) {
/* 118 */       return this.d[paramInt + 1];
/*     */     }
/* 120 */     if (paramObject != null)
/*     */     {
/* 122 */       for (i = (paramInt = i + (i >> 1) << 1) + this.c; paramInt < i; paramInt += 2) {
/*     */         
/* 124 */         if ((paramObject = this.d[paramInt]) == paramString || paramString.equals(paramObject)) {
/* 125 */           return this.d[paramInt + 1];
/*     */         }
/*     */       } 
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */   public final Object b(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 134 */     for (b = 0, i = this.d.length; b < i; b += 2) {
/*     */       Object object;
/* 136 */       if ((object = this.d[b]) != null && (
/*     */         
/* 138 */         object = object).equalsIgnoreCase(paramString)) {
/* 139 */         return this.d[b + 1];
/*     */       }
/*     */     } 
/*     */     
/* 143 */     return null;
/*     */   }
/*     */   
/*     */   public final List<String> a() {
/* 147 */     int i = this.d.length;
/* 148 */     ArrayList<String> arrayList = new ArrayList(i >> 2);
/* 149 */     for (byte b = 0; b < i; b += 2) {
/*     */       Object object;
/* 151 */       if ((object = this.d[b]) != null) {
/* 152 */         arrayList.add((String)object);
/*     */       }
/*     */     } 
/* 155 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */