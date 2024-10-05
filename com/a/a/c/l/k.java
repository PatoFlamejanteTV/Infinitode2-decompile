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
/*     */ public final class k
/*     */   extends m
/*     */ {
/*     */   private j e;
/*     */   
/*     */   public k(Class<?> paramClass, n paramn) {
/*  17 */     super(paramClass, paramn, null, null, 0, null, null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void e(j paramj) {
/*  23 */     if (this.e != null) {
/*  24 */       throw new IllegalStateException("Trying to re-set self reference; old value = " + this.e + ", new = " + paramj);
/*     */     }
/*  26 */     this.e = paramj;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j y() {
/*  31 */     if (this.e != null) {
/*  32 */       return this.e.y();
/*     */     }
/*  34 */     return super.y();
/*     */   }
/*     */   public final j H() {
/*  37 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final n x() {
/*  42 */     if (this.e != null) {
/*  43 */       return this.e.x();
/*     */     }
/*  45 */     return super.x();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder) {
/*  53 */     if (this.e != null)
/*     */     {
/*  55 */       return this.e.b(paramStringBuilder);
/*     */     }
/*  57 */     return paramStringBuilder.append("?");
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder b(StringBuilder paramStringBuilder) {
/*  62 */     if (this.e != null) {
/*  63 */       return this.e.b(paramStringBuilder);
/*     */     }
/*  65 */     return paramStringBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(j paramj) {
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(Object paramObject) {
/*  75 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j b(Object paramObject) {
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j c(Object paramObject) {
/*  85 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j d(Object paramObject) {
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a() {
/*  95 */     return this;
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
/*     */   public final j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean n() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 118 */     StringBuilder stringBuilder = (new StringBuilder(40)).append("[recursive type; ");
/* 119 */     if (this.e == null) {
/* 120 */       stringBuilder.append("UNRESOLVED");
/*     */     }
/*     */     else {
/*     */       
/* 124 */       stringBuilder.append(this.e.b().getName());
/*     */     } 
/* 126 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 131 */     if (paramObject == this) return true; 
/* 132 */     if (paramObject == null) return false; 
/* 133 */     if (paramObject.getClass() == getClass())
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 138 */       return false;
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
/* 149 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */