/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.f.a;
/*     */ import com.d.f.f;
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
/*     */ public final class k
/*     */   implements Comparable<k>
/*     */ {
/*     */   private f a;
/*     */   private int b;
/*     */   
/*     */   public k(f paramf, int paramInt) {
/*  37 */     this.b = paramInt;
/*  38 */     this.a = paramf;
/*     */   }
/*     */   
/*     */   public final f a() {
/*  42 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  50 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(k paramk) {
/*  59 */     k k1 = this;
/*  60 */     paramk = paramk;
/*     */     
/*  62 */     a a2 = null;
/*  63 */     a a3 = null;
/*     */     
/*  65 */     switch (k1.b) {
/*     */       case 1:
/*  67 */         a2 = k1.a.t();
/*     */         break;
/*     */       case 8:
/*  70 */         a2 = k1.a.s();
/*     */         break;
/*     */       case 4:
/*  73 */         a2 = k1.a.q();
/*     */         break;
/*     */       case 2:
/*  76 */         a2 = k1.a.r();
/*     */         break;
/*     */     } 
/*     */     
/*  80 */     switch (paramk.b) {
/*     */       case 1:
/*  82 */         a3 = paramk.a.t();
/*     */         break;
/*     */       case 8:
/*  85 */         a3 = paramk.a.s();
/*     */         break;
/*     */       case 4:
/*  88 */         a3 = paramk.a.q();
/*     */         break;
/*     */       case 2:
/*  91 */         a3 = paramk.a.r();
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/*     */     a a1;
/*  97 */     if ((a1 = f.a(a2, a3, true)) == null) {
/*  98 */       return 0;
/*     */     }
/* 100 */     return (a1 == a2) ? 1 : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 105 */     if (this == paramObject) return true; 
/* 106 */     if (!(paramObject instanceof k)) return false;
/*     */     
/* 108 */     paramObject = paramObject;
/*     */     
/* 110 */     if (this.b != ((k)paramObject).b) return false; 
/* 111 */     if (!this.a.equals(((k)paramObject).a)) return false;
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 117 */     int i = this.a.hashCode();
/*     */     
/* 119 */     return i = i * 31 + this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */