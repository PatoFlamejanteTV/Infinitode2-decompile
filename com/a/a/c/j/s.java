/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class s
/*     */   extends u
/*     */ {
/*     */   private Object a;
/*     */   
/*     */   public s(Object paramObject) {
/*  21 */     this.a = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final m d() {
/*  31 */     return m.h;
/*     */   }
/*     */   public final o p() {
/*  34 */     return o.g;
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
/*     */   public final String i() {
/*  57 */     return (this.a == null) ? "null" : this.a.toString();
/*     */   }
/*     */   public final String c(String paramString) {
/*  60 */     return (this.a == null) ? paramString : this.a.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(boolean paramBoolean) {
/*  66 */     if (this.a != null && this.a instanceof Boolean) {
/*  67 */       return ((Boolean)this.a).booleanValue();
/*     */     }
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/*  75 */     if (this.a instanceof Number) {
/*  76 */       return ((Number)this.a).intValue();
/*     */     }
/*  78 */     return 0;
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
/*     */   public final double a(double paramDouble) {
/*  93 */     if (this.a instanceof Number) {
/*  94 */       return ((Number)this.a).doubleValue();
/*     */     }
/*  96 */     return 0.0D;
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
/* 108 */     if (this.a == null) {
/* 109 */       paramaa.a(paramh); return;
/* 110 */     }  if (this.a instanceof n) {
/* 111 */       ((n)this.a).a(paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/* 115 */     paramaa.a(this.a, paramh);
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
/*     */   public final boolean equals(Object paramObject) {
/* 139 */     if (paramObject == this) return true; 
/* 140 */     if (paramObject == null) return false; 
/* 141 */     if (paramObject instanceof s) {
/* 142 */       return a((s)paramObject);
/*     */     }
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(s params) {
/* 152 */     if (this.a == null) {
/* 153 */       return (params.a == null);
/*     */     }
/* 155 */     return this.a.equals(params.a);
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 159 */     return this.a.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */