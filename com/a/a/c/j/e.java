/*     */ package com.a.a.c.j;
/*     */ 
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
/*     */ public final class e
/*     */   extends u
/*     */ {
/*  21 */   private static e a = new e(true);
/*  22 */   private static e b = new e(false);
/*     */ 
/*     */   
/*     */   private final boolean c;
/*     */ 
/*     */ 
/*     */   
/*     */   private e(boolean paramBoolean) {
/*  30 */     this.c = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static e q() {
/*  37 */     return a; } public static e r() {
/*  38 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final m d() {
/*  44 */     return m.c;
/*     */   }
/*     */   
/*     */   public final o p() {
/*  48 */     return this.c ? o.k : o.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String i() {
/*  58 */     return this.c ? "true" : "false";
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean l() {
/*  63 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(boolean paramBoolean) {
/*  68 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/*  73 */     return this.c ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double a(double paramDouble) {
/*  81 */     return this.c ? 1.0D : 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa) {
/*  86 */     paramh.a(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*  91 */     return this.c ? 3 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 101 */     if (paramObject == this) return true; 
/* 102 */     if (paramObject == null) return false; 
/* 103 */     if (!(paramObject instanceof e)) {
/* 104 */       return false;
/*     */     }
/* 106 */     return (this.c == ((e)paramObject).c);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */