/*     */ package com.a.a.c.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class x<T>
/*     */ {
/*     */   private T a;
/*     */   private a<T> b;
/*     */   private a<T> c;
/*     */   private int d;
/*     */   
/*     */   public final int a() {
/*  53 */     return this.d;
/*     */   }
/*     */   
/*     */   public final T b() {
/*  57 */     c();
/*  58 */     if (this.a == null)
/*  59 */       return a(12);  return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T a(T paramT, int paramInt) {
/*  67 */     a<T> a1 = new a<>(paramT, paramInt);
/*  68 */     if (this.b == null) {
/*  69 */       this.b = this.c = a1;
/*     */     } else {
/*  71 */       this.c.a(a1);
/*  72 */       this.c = a1;
/*     */     } 
/*  74 */     this.d += paramInt;
/*     */     
/*     */     int i;
/*  77 */     if ((i = paramInt) < 16384) {
/*  78 */       i += i;
/*     */     } else {
/*  80 */       i += i >> 2;
/*     */     } 
/*  82 */     return a(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final T b(T paramT, int paramInt) {
/*  87 */     int i = paramInt + this.d;
/*  88 */     T t = a(i);
/*     */     
/*  90 */     int j = 0;
/*     */     
/*  92 */     for (a<T> a1 = this.b; a1 != null; a1 = a1.b()) {
/*  93 */       j = a1.a(t, j);
/*     */     }
/*  95 */     System.arraycopy(paramT, 0, t, j, paramInt);
/*     */ 
/*     */ 
/*     */     
/*  99 */     if ((j = j + paramInt) != i) {
/* 100 */       throw new IllegalStateException("Should have gotten " + i + " entries, got " + j);
/*     */     }
/* 102 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T a(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c() {
/* 122 */     if (this.c != null) {
/* 123 */       this.a = this.c.a();
/*     */     }
/*     */     
/* 126 */     this.b = this.c = null;
/* 127 */     this.d = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a<T>
/*     */   {
/*     */     private T a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a<T> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(T param1T, int param1Int) {
/* 159 */       this.a = param1T;
/* 160 */       this.b = param1Int;
/*     */     }
/*     */     public final T a() {
/* 163 */       return this.a;
/*     */     }
/*     */     
/*     */     public final int a(T param1T, int param1Int) {
/* 167 */       System.arraycopy(this.a, 0, param1T, param1Int, this.b);
/*     */       
/* 169 */       return param1Int = param1Int + this.b;
/*     */     }
/*     */     public final a<T> b() {
/* 172 */       return this.c;
/*     */     }
/*     */     
/*     */     public final void a(a<T> param1a) {
/* 176 */       if (this.c != null) {
/* 177 */         throw new IllegalStateException();
/*     */       }
/* 179 */       this.c = param1a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */