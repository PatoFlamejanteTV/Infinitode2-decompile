/*     */ package com.d.g.a;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d<T extends f>
/*     */ {
/*     */   private List<T> a;
/*     */   
/*     */   public final List<T> a() {
/*  17 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(T paramT) {
/*  21 */     if (this.a == null) {
/*  22 */       this.a = new ArrayList<>();
/*     */     }
/*  24 */     this.a.add(paramT);
/*  25 */     Collections.sort(this.a, new e(this));
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
/*     */   public final T a(int paramInt, c paramc) {
/*  37 */     if (this.a == null) {
/*  38 */       throw new RuntimeException("fontDescriptions is null");
/*     */     }
/*     */     
/*  41 */     ArrayList<f> arrayList = new ArrayList();
/*     */     Iterator<T> iterator;
/*  43 */     for (iterator = this.a.iterator(); iterator.hasNext();) {
/*  44 */       if ((f = (f)iterator.next()).b() == paramc) {
/*  45 */         arrayList.add(f);
/*     */       }
/*     */     } 
/*     */     
/*  49 */     if (arrayList.size() == 0) {
/*  50 */       if (paramc == c.W)
/*  51 */         return a(paramInt, c.at); 
/*  52 */       if (paramc == c.at) {
/*  53 */         return a(paramInt, c.aq);
/*     */       }
/*  55 */       arrayList.addAll(this.a);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     if ((iterator = (Iterator<T>)a((List)arrayList, paramInt, 1)) != null) {
/*  62 */       return (T)iterator;
/*     */     }
/*  64 */     if (paramInt <= 500) {
/*  65 */       return a((List)arrayList, paramInt, 2);
/*     */     }
/*  67 */     return a((List)arrayList, paramInt, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static T a(List<T> paramList, int paramInt1, int paramInt2) {
/*     */     Iterator<T> iterator;
/*     */     int i;
/*  77 */     if (paramInt2 == 1) {
/*  78 */       for (iterator = paramList.iterator(); iterator.hasNext();) {
/*  79 */         if ((f = (f)iterator.next()).a() == paramInt1) {
/*  80 */           return (T)f;
/*     */         }
/*     */       } 
/*  83 */       return null;
/*  84 */     }  if (iterator == 2) {
/*     */       
/*  86 */       f f = null;
/*  87 */       for (i = 0; i < paramList.size() && (
/*     */         
/*  89 */         f = (f)paramList.get(i)).a() <= paramInt1; i++);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       if (i > 0 && f.a() > paramInt1) {
/*  95 */         return paramList.get(i - 1);
/*     */       }
/*  97 */       return (T)f;
/*     */     } 
/*     */     
/* 100 */     if (i == 3) {
/*     */       
/* 102 */       f f = null;
/* 103 */       for (i = paramList.size() - 1; i >= 0 && (
/*     */         
/* 105 */         f = (f)paramList.get(i)).a() >= paramInt1; i--);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 110 */       if (i != paramList.size() - 1 && f.a() < paramInt1) {
/* 111 */         return paramList.get(i + 1);
/*     */       }
/* 113 */       return (T)f;
/*     */     } 
/*     */ 
/*     */     
/* 117 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\g\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */