/*     */ package com.d.c.d;
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
/*     */ public final class f
/*     */   implements g
/*     */ {
/*     */   private final float a;
/*     */   private final float b;
/*     */   private final float c;
/*     */   private final float d;
/*     */   
/*     */   public f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  29 */     if (paramFloat1 < 0.0F || paramFloat1 > 1.0F) {
/*  30 */       throw new IllegalArgumentException();
/*     */     }
/*  32 */     if (paramFloat2 < 0.0F || paramFloat2 > 1.0F) {
/*  33 */       throw new IllegalArgumentException();
/*     */     }
/*  35 */     if (paramFloat3 < 0.0F || paramFloat3 > 1.0F) {
/*  36 */       throw new IllegalArgumentException();
/*     */     }
/*  38 */     if (paramFloat4 < 0.0F || paramFloat4 > 1.0F) {
/*  39 */       throw new IllegalArgumentException();
/*     */     }
/*  41 */     this.a = paramFloat1;
/*  42 */     this.b = paramFloat2;
/*  43 */     this.c = paramFloat3;
/*  44 */     this.d = paramFloat4;
/*     */   }
/*     */   
/*     */   public final float a() {
/*  48 */     return this.a;
/*     */   }
/*     */   
/*     */   public final float b() {
/*  52 */     return this.b;
/*     */   }
/*     */   
/*     */   public final float c() {
/*  56 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float d() {
/*  60 */     return this.d;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  64 */     return "cmyk(" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g e() {
/*  72 */     return new f(
/*  73 */         Math.min(1.0F, this.a / 0.8F), Math.min(1.0F, this.b / 0.8F), 
/*  74 */         Math.min(1.0F, this.c / 0.8F), this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*  81 */     int i = 31 + Float.floatToIntBits(this.d);
/*  82 */     i = i * 31 + Float.floatToIntBits(this.a);
/*  83 */     i = i * 31 + Float.floatToIntBits(this.b);
/*     */     
/*  85 */     return i = i * 31 + Float.floatToIntBits(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  90 */     if (this == paramObject)
/*  91 */       return true; 
/*  92 */     if (paramObject == null)
/*  93 */       return false; 
/*  94 */     if (getClass() != paramObject.getClass())
/*  95 */       return false; 
/*  96 */     paramObject = paramObject;
/*  97 */     if (Float.floatToIntBits(this.d) != Float.floatToIntBits(((f)paramObject).d))
/*  98 */       return false; 
/*  99 */     if (Float.floatToIntBits(this.a) != Float.floatToIntBits(((f)paramObject).a))
/* 100 */       return false; 
/* 101 */     if (Float.floatToIntBits(this.b) != 
/* 102 */       Float.floatToIntBits(((f)paramObject).b))
/* 103 */       return false; 
/* 104 */     if (Float.floatToIntBits(this.c) != 
/* 105 */       Float.floatToIntBits(((f)paramObject).c))
/* 106 */       return false; 
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */