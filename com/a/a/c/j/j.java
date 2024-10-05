/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.c.i;
/*     */ import com.a.a.b.h;
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
/*     */ 
/*     */ public final class j
/*     */   extends q
/*     */ {
/*  27 */   private static final j[] a = new j[12]; static {
/*  28 */     for (byte b = 0; b < 12; b++) {
/*  29 */       a[b] = new j(b + -1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j(int paramInt) {
/*  44 */     this.b = paramInt;
/*     */   }
/*     */   public static j c(int paramInt) {
/*  47 */     if (paramInt > 10 || paramInt < -1) return new j(paramInt); 
/*  48 */     return a[paramInt - -1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o p() {
/*  57 */     return o.i;
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
/*     */   public final int g() {
/*  86 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double h() {
/*  95 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String i() {
/* 106 */     return i.a(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(boolean paramBoolean) {
/* 111 */     return (this.b != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa) {
/* 118 */     paramh.c(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 124 */     if (paramObject == this) return true; 
/* 125 */     if (paramObject == null) return false; 
/* 126 */     if (paramObject instanceof j) {
/* 127 */       return (((j)paramObject).b == this.b);
/*     */     }
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 133 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */