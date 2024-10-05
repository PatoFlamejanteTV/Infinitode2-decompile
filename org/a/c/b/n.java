/*     */ package org.a.c.b;
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
/*     */ public final class n
/*     */   implements Comparable<n>
/*     */ {
/*     */   private final long a;
/*     */   private int b;
/*     */   
/*     */   public n(m paramm) {
/*  37 */     this(paramm.b(), paramm.d());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(long paramLong, int paramInt) {
/*  48 */     this.a = paramLong;
/*  49 */     this.b = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  59 */     if ((paramObject = (paramObject instanceof n) ? paramObject : null) != null && paramObject
/*  60 */       .b() == b() && paramObject
/*  61 */       .a() == a()) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  71 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/*  81 */     this.b = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long b() {
/*  91 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 100 */     return Long.valueOf(this.a + this.b).hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 106 */     return Long.toString(this.a) + " " + Integer.toString(this.b) + " R";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(n paramn) {
/* 112 */     if (b() < paramn.b())
/*     */     {
/* 114 */       return -1;
/*     */     }
/* 116 */     if (b() > paramn.b())
/*     */     {
/* 118 */       return 1;
/*     */     }
/*     */ 
/*     */     
/* 122 */     if (a() < paramn.a())
/*     */     {
/* 124 */       return -1;
/*     */     }
/* 126 */     if (a() > paramn.a())
/*     */     {
/* 128 */       return 1;
/*     */     }
/*     */ 
/*     */     
/* 132 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */