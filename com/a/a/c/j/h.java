/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.c.i;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
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
/*     */ public final class h
/*     */   extends q
/*     */ {
/*     */   private double a;
/*     */   
/*     */   private h(double paramDouble) {
/*  28 */     this.a = paramDouble;
/*     */   } public static h b(double paramDouble) {
/*  30 */     return new h(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o p() {
/*  38 */     return o.j;
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
/*     */   
/*     */   public final int g() {
/*  77 */     return (int)this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double h() {
/*  86 */     return this.a;
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
/*     */   public final String i() {
/*  98 */     return i.a(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(com.a.a.b.h paramh, aa paramaa) {
/* 109 */     paramh.a(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 115 */     if (paramObject == this) return true; 
/* 116 */     if (paramObject == null) return false; 
/* 117 */     if (paramObject instanceof h) {
/*     */ 
/*     */       
/* 120 */       double d = ((h)paramObject).a;
/* 121 */       return (Double.compare(this.a, d) == 0);
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*     */     long l;
/* 131 */     return (int)(l = Double.doubleToLongBits(this.a)) ^ (int)(l >> 32L);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */