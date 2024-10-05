/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.m.o;
/*     */ import com.a.a.c.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */ {
/*     */   private final a[] a;
/*     */   private final int b;
/*     */   private final int c;
/*     */   
/*     */   private l(o<n, o<Object>> paramo) {
/*  27 */     this.b = a(paramo.a());
/*  28 */     this.c = this.b - 1;
/*  29 */     a[] arrayOfA = new a[this.b];
/*  30 */     paramo.a((paramn, paramo) -> {
/*     */           int i = paramn.hashCode() & this.c;
/*     */           paramArrayOfa[i] = new a(paramArrayOfa[i], paramn, paramo);
/*     */         });
/*  34 */     this.a = arrayOfA;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int a(int paramInt) {
/*  40 */     paramInt = (paramInt <= 64) ? (paramInt + paramInt) : (paramInt + (paramInt >> 2));
/*  41 */     int i = 8;
/*  42 */     while (i < paramInt) {
/*  43 */       i += i;
/*     */     }
/*  45 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(o<n, o<Object>> paramo) {
/*  52 */     return new l(paramo);
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
/*     */   public final o<Object> a(j paramj) {
/*     */     a a1;
/*  66 */     if ((a1 = this.a[n.b(paramj) & this.c]) == null) {
/*  67 */       return null;
/*     */     }
/*  69 */     if (a1.a(paramj)) {
/*  70 */       return a1.a;
/*     */     }
/*  72 */     while ((a1 = a1.b) != null) {
/*  73 */       if (a1.a(paramj)) {
/*  74 */         return a1.a;
/*     */       }
/*     */     } 
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<Object> a(Class<?> paramClass) {
/*     */     a a1;
/*  83 */     if ((a1 = this.a[n.b(paramClass) & this.c]) == null) {
/*  84 */       return null;
/*     */     }
/*  86 */     if (a1.a(paramClass)) {
/*  87 */       return a1.a;
/*     */     }
/*  89 */     while ((a1 = a1.b) != null) {
/*  90 */       if (a1.a(paramClass)) {
/*  91 */         return a1.a;
/*     */       }
/*     */     } 
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<Object> b(j paramj) {
/*     */     a a1;
/* 100 */     if ((a1 = this.a[n.a(paramj) & this.c]) == null) {
/* 101 */       return null;
/*     */     }
/* 103 */     if (a1.b(paramj)) {
/* 104 */       return a1.a;
/*     */     }
/* 106 */     while ((a1 = a1.b) != null) {
/* 107 */       if (a1.b(paramj)) {
/* 108 */         return a1.a;
/*     */       }
/*     */     } 
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<Object> b(Class<?> paramClass) {
/*     */     a a1;
/* 117 */     if ((a1 = this.a[n.a(paramClass) & this.c]) == null) {
/* 118 */       return null;
/*     */     }
/* 120 */     if (a1.b(paramClass)) {
/* 121 */       return a1.a;
/*     */     }
/* 123 */     while ((a1 = a1.b) != null) {
/* 124 */       if (a1.b(paramClass)) {
/* 125 */         return a1.a;
/*     */       }
/*     */     } 
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     public final o<Object> a;
/*     */ 
/*     */     
/*     */     public final a b;
/*     */ 
/*     */     
/*     */     private Class<?> c;
/*     */     
/*     */     private j d;
/*     */     
/*     */     private boolean e;
/*     */ 
/*     */     
/*     */     public a(a param1a, n param1n, o<Object> param1o) {
/* 149 */       this.b = param1a;
/* 150 */       this.a = param1o;
/* 151 */       this.e = param1n.a();
/* 152 */       this.c = param1n.b();
/* 153 */       this.d = param1n.c();
/*     */     }
/*     */     
/*     */     public final boolean a(Class<?> param1Class) {
/* 157 */       return (this.c == param1Class && this.e);
/*     */     }
/*     */     
/*     */     public final boolean b(Class<?> param1Class) {
/* 161 */       return (this.c == param1Class && !this.e);
/*     */     }
/*     */     
/*     */     public final boolean a(j param1j) {
/* 165 */       return (this.e && param1j.equals(this.d));
/*     */     }
/*     */     
/*     */     public final boolean b(j param1j) {
/* 169 */       return (!this.e && param1j.equals(this.d));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */