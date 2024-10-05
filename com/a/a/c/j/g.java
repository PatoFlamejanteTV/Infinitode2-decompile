/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   extends q
/*     */ {
/*  18 */   public static final g a = new g(BigDecimal.ZERO);
/*     */   static {
/*  20 */     BigDecimal.valueOf(-2147483648L);
/*  21 */     BigDecimal.valueOf(2147483647L);
/*  22 */     BigDecimal.valueOf(Long.MIN_VALUE);
/*  23 */     BigDecimal.valueOf(Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal b;
/*     */ 
/*     */ 
/*     */   
/*     */   private g(BigDecimal paramBigDecimal) {
/*  33 */     this.b = paramBigDecimal;
/*     */   } public static g a(BigDecimal paramBigDecimal) {
/*  35 */     return new g(paramBigDecimal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o p() {
/*  43 */     return o.j;
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
/*     */   public final int g() {
/*  81 */     return this.b.intValue();
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
/*     */   public final double h() {
/*  94 */     return this.b.doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String i() {
/* 101 */     return this.b.toString();
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
/*     */   public final void a(h paramh, aa paramaa) {
/* 118 */     paramh.a(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 124 */     if (paramObject == this) return true; 
/* 125 */     if (paramObject == null) return false; 
/* 126 */     if (paramObject instanceof g) {
/* 127 */       return (((g)paramObject).b.compareTo(this.b) == 0);
/*     */     }
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 133 */     return Double.valueOf(h()).hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */