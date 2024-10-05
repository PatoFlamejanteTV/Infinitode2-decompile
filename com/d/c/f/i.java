/*     */ package com.d.c.f;
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
/*     */ public final class i
/*     */ {
/*  35 */   private int a = 1;
/*  36 */   private long b = 0L;
/*     */ 
/*     */   
/*     */   public i() {}
/*     */   
/*     */   public i(long paramLong, int paramInt) {
/*  42 */     this.b = paramLong;
/*  43 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public final void a(long paramLong) {
/*  47 */     this.b = paramLong;
/*     */   }
/*     */   
/*     */   public final long a() {
/*  51 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/*  55 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public final int b() {
/*  59 */     return this.a;
/*     */   }
/*     */   
/*     */   public final boolean c() {
/*  63 */     return (this.a == 1);
/*     */   }
/*     */   
/*     */   public final boolean d() {
/*  67 */     return (this.a == 2);
/*     */   }
/*     */   
/*     */   public final boolean e() {
/*  71 */     return (this.a == 3);
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
/*     */   public final long b(int paramInt) {
/*  88 */     switch (this.a) {
/*     */       case 2:
/*  90 */         return this.b;
/*     */       case 3:
/*  92 */         return paramInt * this.b / 100L;
/*     */     } 
/*  94 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 100 */     (stringBuilder = new StringBuilder()).append("(type=");
/* 101 */     switch (this.a)
/*     */     { case 2:
/* 103 */         stringBuilder.append("fixed");
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
/* 114 */         stringBuilder.append(", value=");
/* 115 */         stringBuilder.append(this.b);
/* 116 */         stringBuilder.append(")");
/*     */         
/* 118 */         return stringBuilder.toString();case 3: stringBuilder.append("percent"); stringBuilder.append(", value="); stringBuilder.append(this.b); stringBuilder.append(")"); return stringBuilder.toString();case 1: stringBuilder.append("variable"); stringBuilder.append(", value="); stringBuilder.append(this.b); stringBuilder.append(")"); return stringBuilder.toString(); }  stringBuilder.append("unknown"); stringBuilder.append(", value="); stringBuilder.append(this.b); stringBuilder.append(")"); return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */