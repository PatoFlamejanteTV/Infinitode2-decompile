/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.n;
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
/*     */ public final class y
/*     */   implements n
/*     */ {
/*     */   private Object a;
/*     */   
/*     */   public y(String paramString) {
/*  30 */     this.a = paramString;
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
/*     */   public final void a(h paramh, aa paramaa) {
/*  63 */     if (this.a instanceof n) {
/*  64 */       ((n)this.a).a(paramh, paramaa); return;
/*     */     } 
/*  66 */     b(paramh);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa, i parami) {
/*  74 */     if (this.a instanceof n) {
/*  75 */       ((n)this.a).a(paramh, paramaa, parami); return;
/*  76 */     }  if (this.a instanceof r)
/*     */     {
/*     */ 
/*     */       
/*  80 */       a(paramh, paramaa);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(h paramh) {
/*  86 */     if (this.a instanceof n) {
/*     */       
/*  88 */       paramh.h(this.a); return;
/*     */     } 
/*  90 */     b(paramh);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(h paramh) {
/*  96 */     if (this.a instanceof r) {
/*  97 */       paramh.e((r)this.a); return;
/*     */     } 
/*  99 */     paramh.d(String.valueOf(this.a));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 105 */     if (paramObject == this) return true; 
/* 106 */     if (!(paramObject instanceof y)) return false; 
/* 107 */     paramObject = paramObject;
/*     */     
/* 109 */     if (this.a == ((y)paramObject).a) {
/* 110 */       return true;
/*     */     }
/* 112 */     return (this.a != null && this.a.equals(((y)paramObject).a));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 117 */     return (this.a == null) ? 0 : this.a.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 122 */     return String.format("[RawValue of type %s]", new Object[] { i.d(this.a) });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */