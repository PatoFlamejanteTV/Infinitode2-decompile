/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   extends q
/*     */ {
/*     */   private BigInteger a;
/*     */   
/*     */   static {
/*  17 */     BigInteger.valueOf(-2147483648L);
/*  18 */     BigInteger.valueOf(2147483647L);
/*  19 */     BigInteger.valueOf(Long.MIN_VALUE);
/*  20 */     BigInteger.valueOf(Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(BigInteger paramBigInteger) {
/*  30 */     this.a = paramBigInteger;
/*     */   } public static c a(BigInteger paramBigInteger) {
/*  32 */     return new c(paramBigInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o p() {
/*  41 */     return o.i;
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
/*     */   public final int g() {
/*  68 */     return this.a.intValue();
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
/*     */   public final double h() {
/*  80 */     return this.a.doubleValue();
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
/*     */   public final String i() {
/*  93 */     return this.a.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(boolean paramBoolean) {
/*  98 */     return !BigInteger.ZERO.equals(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa) {
/* 105 */     paramh.a(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 111 */     if (paramObject == this) return true; 
/* 112 */     if (paramObject == null) return false; 
/* 113 */     if (!(paramObject instanceof c)) {
/* 114 */       return false;
/*     */     }
/* 116 */     return ((c)paramObject).a.equals(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 121 */     return this.a.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */