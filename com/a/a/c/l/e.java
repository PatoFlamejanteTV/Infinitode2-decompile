/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class e
/*     */   extends d
/*     */ {
/*     */   private e(Class<?> paramClass, n paramn, j paramj1, j[] paramArrayOfj, j paramj2, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  25 */     super(paramClass, paramn, paramj1, paramArrayOfj, paramj2, paramObject1, paramObject2, paramBoolean);
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
/*     */   public static e a(Class<?> paramClass, n paramn, j paramj1, j[] paramArrayOfj, j paramj2) {
/*  40 */     return new e(paramClass, paramn, paramj1, paramArrayOfj, paramj2, null, null, false);
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
/*     */   public final j a(j paramj) {
/*  73 */     if (this.e == paramj) {
/*  74 */       return this;
/*     */     }
/*  76 */     return new e(this.a, this.i, this.g, this.h, paramj, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e i(Object paramObject) {
/*  82 */     return new e(this.a, this.i, this.g, this.h, this.e, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e j(Object paramObject) {
/*  89 */     return new e(this.a, this.i, this.g, this.h, this.e
/*  90 */         .a(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e k(Object paramObject) {
/*  96 */     return new e(this.a, this.i, this.g, this.h, this.e, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e l(Object paramObject) {
/* 102 */     return new e(this.a, this.i, this.g, this.h, this.e
/* 103 */         .c(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e J() {
/* 109 */     if (this.d) {
/* 110 */       return this;
/*     */     }
/* 112 */     return new e(this.a, this.i, this.g, this.h, this.e
/* 113 */         .a(), this.b, this.c, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 120 */     return new e(paramClass, paramn, paramj, paramArrayOfj, this.e, this.b, this.c, this.d);
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
/*     */   public final String toString() {
/* 134 */     return "[collection type; class " + this.a.getName() + ", contains " + this.e + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */