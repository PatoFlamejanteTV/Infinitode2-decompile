/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.c.h;
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
/*     */ public final class t
/*     */   extends u
/*     */ {
/*  21 */   private static t a = new t("");
/*     */   private String b;
/*     */   
/*     */   private t(String paramString) {
/*  25 */     this.b = paramString;
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
/*     */   public static t d(String paramString) {
/*  38 */     if (paramString == null) {
/*  39 */       return null;
/*     */     }
/*  41 */     if (paramString.isEmpty()) {
/*  42 */       return a;
/*     */     }
/*  44 */     return new t(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final m d() {
/*  49 */     return m.i;
/*     */   }
/*     */   public final o p() {
/*  52 */     return o.h;
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
/* 100 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String c(String paramString) {
/* 105 */     return (this.b == null) ? paramString : this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(boolean paramBoolean) {
/* 112 */     if (this.b != null) {
/* 113 */       String str = this.b.trim();
/* 114 */       if ("true".equals(str)) {
/* 115 */         return true;
/*     */       }
/* 117 */       if ("false".equals(str)) {
/* 118 */         return false;
/*     */       }
/*     */     } 
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/* 126 */     return h.a(this.b, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double a(double paramDouble) {
/* 136 */     return h.a(this.b, 0.0D);
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
/*     */   public final void a(h paramh, aa paramaa) {
/* 148 */     if (this.b == null) {
/* 149 */       paramh.k(); return;
/*     */     } 
/* 151 */     paramh.b(this.b);
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
/*     */   public final boolean equals(Object paramObject) {
/* 164 */     if (paramObject == this) return true; 
/* 165 */     if (paramObject == null) return false; 
/* 166 */     if (paramObject instanceof t) {
/* 167 */       return ((t)paramObject).b.equals(this.b);
/*     */     }
/* 169 */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 173 */     return this.b.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */