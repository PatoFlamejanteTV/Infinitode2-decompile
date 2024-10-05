/*     */ package com.badlogic.gdx.math;
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
/*     */ public class CatmullRomSpline<T extends Vector<T>>
/*     */   implements Path<T>
/*     */ {
/*     */   public T[] controlPoints;
/*     */   public boolean continuous;
/*     */   public int spanCount;
/*     */   private T tmp;
/*     */   private T tmp2;
/*     */   private T tmp3;
/*     */   
/*     */   public static <T extends Vector<T>> T calculate(T paramT1, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  30 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - 3);
/*  31 */     float f = paramFloat * j;
/*  32 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/*  33 */     f -= i;
/*  34 */     return calculate(paramT1, i, f, paramArrayOfT, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T calculate(T paramT1, int paramInt, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  47 */     int i = paramArrayOfT.length;
/*     */     
/*  49 */     float f1, f2 = (f1 = paramFloat * paramFloat) * paramFloat;
/*  50 */     paramT1.set(paramArrayOfT[paramInt]).scl(1.5F * f2 - 2.5F * f1 + 1.0F);
/*  51 */     if (paramBoolean || paramInt > 0) paramT1.add(paramT2.set(paramArrayOfT[(i + paramInt - 1) % i]).scl(-0.5F * f2 + f1 - 0.5F * paramFloat)); 
/*  52 */     if (paramBoolean || paramInt < i - 1) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 1) % i]).scl(-1.5F * f2 + f1 * 2.0F + 0.5F * paramFloat)); 
/*  53 */     if (paramBoolean || paramInt < i - 2) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 2) % i]).scl(0.5F * f2 - 0.5F * f1)); 
/*  54 */     return paramT1;
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
/*     */   public static <T extends Vector<T>> T derivative(T paramT1, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  66 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - 3);
/*  67 */     float f = paramFloat * j;
/*  68 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/*  69 */     f -= i;
/*  70 */     return derivative(paramT1, i, f, paramArrayOfT, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T derivative(T paramT1, int paramInt, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  86 */     int i = paramArrayOfT.length;
/*  87 */     float f = paramFloat * paramFloat;
/*     */     
/*  89 */     paramT1.set(paramArrayOfT[paramInt]).scl(-paramFloat * 5.0F + f * 4.5F);
/*  90 */     if (paramBoolean || paramInt > 0) paramT1.add(paramT2.set(paramArrayOfT[(i + paramInt - 1) % i]).scl(-0.5F + paramFloat * 2.0F - f * 1.5F)); 
/*  91 */     if (paramBoolean || paramInt < i - 1) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 1) % i]).scl(0.5F + paramFloat * 4.0F - f * 4.5F)); 
/*  92 */     if (paramBoolean || paramInt < i - 2) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 2) % i]).scl(-paramFloat + f * 1.5F)); 
/*  93 */     return paramT1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CatmullRomSpline() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CatmullRomSpline(T[] paramArrayOfT, boolean paramBoolean) {
/* 107 */     set(paramArrayOfT, paramBoolean);
/*     */   }
/*     */   
/*     */   public CatmullRomSpline set(T[] paramArrayOfT, boolean paramBoolean) {
/* 111 */     if (this.tmp == null) this.tmp = paramArrayOfT[0].cpy(); 
/* 112 */     if (this.tmp2 == null) this.tmp2 = paramArrayOfT[0].cpy(); 
/* 113 */     if (this.tmp3 == null) this.tmp3 = paramArrayOfT[0].cpy(); 
/* 114 */     this.controlPoints = paramArrayOfT;
/* 115 */     this.continuous = paramBoolean;
/* 116 */     this.spanCount = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - 3);
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T valueAt(T paramT, float paramFloat) {
/* 122 */     int j = this.spanCount;
/* 123 */     float f = paramFloat * j;
/* 124 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 125 */     f -= i;
/* 126 */     return valueAt(paramT, i, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public T valueAt(T paramT, int paramInt, float paramFloat) {
/* 131 */     return calculate(paramT, this.continuous ? paramInt : (paramInt + 1), paramFloat, this.controlPoints, this.continuous, this.tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   public T derivativeAt(T paramT, float paramFloat) {
/* 136 */     int j = this.spanCount;
/* 137 */     float f = paramFloat * j;
/* 138 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 139 */     f -= i;
/* 140 */     return derivativeAt(paramT, i, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public T derivativeAt(T paramT, int paramInt, float paramFloat) {
/* 145 */     return derivative(paramT, this.continuous ? paramInt : (paramInt + 1), paramFloat, this.controlPoints, this.continuous, this.tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   public int nearest(T paramT) {
/* 150 */     return nearest(paramT, 0, this.spanCount);
/*     */   }
/*     */ 
/*     */   
/*     */   public int nearest(T paramT, int paramInt1, int paramInt2) {
/* 155 */     while (paramInt1 < 0)
/* 156 */       paramInt1 += this.spanCount; 
/* 157 */     int i = paramInt1 % this.spanCount;
/* 158 */     float f = paramT.dst2(this.controlPoints[i]);
/* 159 */     for (byte b = 1; b < paramInt2; b++) {
/* 160 */       int j = (paramInt1 + b) % this.spanCount;
/*     */       float f1;
/* 162 */       if ((f1 = paramT.dst2(this.controlPoints[j])) < f) {
/* 163 */         f = f1;
/* 164 */         i = j;
/*     */       } 
/*     */     } 
/* 167 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public float approximate(T paramT) {
/* 172 */     return approximate(paramT, nearest(paramT));
/*     */   }
/*     */   
/*     */   public float approximate(T paramT, int paramInt1, int paramInt2) {
/* 176 */     return approximate(paramT, nearest(paramT, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public float approximate(T paramT, int paramInt) {
/* 180 */     int i = paramInt;
/* 181 */     T t1 = this.controlPoints[paramInt];
/* 182 */     T t2 = this.controlPoints[(paramInt > 0) ? (paramInt - 1) : (this.spanCount - 1)];
/* 183 */     T t3 = this.controlPoints[(paramInt + 1) % this.spanCount];
/* 184 */     float f5 = paramT.dst2(t2);
/*     */     
/*     */     float f6;
/* 187 */     if ((f6 = paramT.dst2(t3)) < f5) {
/* 188 */       t2 = t1;
/* 189 */       t1 = t3;
/* 190 */       paramT = paramT;
/*     */     } else {
/* 192 */       t2 = t2;
/* 193 */       t1 = t1;
/* 194 */       paramT = paramT;
/* 195 */       i = (paramInt > 0) ? (paramInt - 1) : (this.spanCount - 1);
/*     */     } 
/* 197 */     float f2 = t2.dst2(t1);
/* 198 */     float f3 = paramT.dst2(t1);
/* 199 */     float f1 = paramT.dst2(t2);
/* 200 */     float f4 = (float)Math.sqrt(f2);
/* 201 */     f1 = (f3 + f2 - f1) / f4 * 2.0F;
/* 202 */     f1 = MathUtils.clamp((f4 - f1) / f4, 0.0F, 1.0F);
/* 203 */     return (i + f1) / this.spanCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public float locate(T paramT) {
/* 208 */     return approximate(paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public float approxLength(int paramInt) {
/* 213 */     float f = 0.0F;
/* 214 */     for (byte b = 0; b < paramInt; b++) {
/* 215 */       this.tmp2.set(this.tmp3);
/* 216 */       valueAt(this.tmp3, b / (paramInt - 1.0F));
/* 217 */       if (b > 0) f += this.tmp2.dst(this.tmp3); 
/*     */     } 
/* 219 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\CatmullRomSpline.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */