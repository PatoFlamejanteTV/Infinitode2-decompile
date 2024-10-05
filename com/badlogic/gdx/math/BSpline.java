/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public class BSpline<T extends Vector<T>>
/*     */   implements Path<T>
/*     */ {
/*     */   private static final float d6 = 0.16666667F;
/*     */   public T[] controlPoints;
/*     */   public Array<T> knots;
/*     */   public int degree;
/*     */   public boolean continuous;
/*     */   public int spanCount;
/*     */   private T tmp;
/*     */   private T tmp2;
/*     */   private T tmp3;
/*     */   
/*     */   public static <T extends Vector<T>> T cubic(T paramT1, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  34 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - 3);
/*  35 */     float f = paramFloat * j;
/*  36 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/*  37 */     f -= i;
/*  38 */     return cubic(paramT1, i, f, paramArrayOfT, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T cubic_derivative(T paramT1, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  50 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - 3);
/*  51 */     float f = paramFloat * j;
/*  52 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/*  53 */     f -= i;
/*  54 */     return cubic(paramT1, i, f, paramArrayOfT, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T cubic(T paramT1, int paramInt, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  67 */     int i = paramArrayOfT.length;
/*  68 */     float f1 = 1.0F - paramFloat;
/*     */     
/*  70 */     float f2, f3 = (f2 = paramFloat * paramFloat) * paramFloat;
/*  71 */     paramT1.set(paramArrayOfT[paramInt]).scl((3.0F * f3 - 6.0F * f2 + 4.0F) * 0.16666667F);
/*  72 */     if (paramBoolean || paramInt > 0) paramT1.add(paramT2.set(paramArrayOfT[(i + paramInt - 1) % i]).scl(f1 * f1 * f1 * 0.16666667F)); 
/*  73 */     if (paramBoolean || paramInt < i - 1) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 1) % i]).scl((-3.0F * f3 + 3.0F * f2 + 3.0F * paramFloat + 1.0F) * 0.16666667F)); 
/*  74 */     if (paramBoolean || paramInt < i - 2) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 2) % i]).scl(f3 * 0.16666667F)); 
/*  75 */     return paramT1;
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
/*     */   public static <T extends Vector<T>> T cubic_derivative(T paramT1, int paramInt, float paramFloat, T[] paramArrayOfT, boolean paramBoolean, T paramT2) {
/*  88 */     int i = paramArrayOfT.length;
/*  89 */     float f1 = 1.0F - paramFloat;
/*  90 */     float f2 = paramFloat * paramFloat;
/*     */     
/*  92 */     paramT1.set(paramArrayOfT[paramInt]).scl(1.5F * f2 - paramFloat * 2.0F);
/*  93 */     if (paramBoolean || paramInt > 0) paramT1.add(paramT2.set(paramArrayOfT[(i + paramInt - 1) % i]).scl(-0.5F * f1 * f1)); 
/*  94 */     if (paramBoolean || paramInt < i - 1) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 1) % i]).scl(-1.5F * f2 + paramFloat + 0.5F)); 
/*  95 */     if (paramBoolean || paramInt < i - 2) paramT1.add(paramT2.set(paramArrayOfT[(paramInt + 2) % i]).scl(0.5F * f2)); 
/*  96 */     return paramT1;
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
/*     */   public static <T extends Vector<T>> T calculate(T paramT1, float paramFloat, T[] paramArrayOfT, int paramInt, boolean paramBoolean, T paramT2) {
/* 109 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - paramInt);
/* 110 */     float f = paramFloat * j;
/* 111 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 112 */     f -= i;
/* 113 */     return calculate(paramT1, i, f, paramArrayOfT, paramInt, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T derivative(T paramT1, float paramFloat, T[] paramArrayOfT, int paramInt, boolean paramBoolean, T paramT2) {
/* 126 */     int j = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - paramInt);
/* 127 */     float f = paramFloat * j;
/* 128 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 129 */     f -= i;
/* 130 */     return derivative(paramT1, i, f, paramArrayOfT, paramInt, paramBoolean, paramT2);
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
/*     */   public static <T extends Vector<T>> T calculate(T paramT1, int paramInt1, float paramFloat, T[] paramArrayOfT, int paramInt2, boolean paramBoolean, T paramT2) {
/* 144 */     switch (paramInt2) {
/*     */       case 3:
/* 146 */         return cubic(paramT1, paramInt1, paramFloat, paramArrayOfT, paramBoolean, paramT2);
/*     */     } 
/* 148 */     throw new IllegalArgumentException();
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
/*     */   public static <T extends Vector<T>> T derivative(T paramT1, int paramInt1, float paramFloat, T[] paramArrayOfT, int paramInt2, boolean paramBoolean, T paramT2) {
/* 162 */     switch (paramInt2) {
/*     */       case 3:
/* 164 */         return cubic_derivative(paramT1, paramInt1, paramFloat, paramArrayOfT, paramBoolean, paramT2);
/*     */     } 
/* 166 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BSpline() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BSpline(T[] paramArrayOfT, int paramInt, boolean paramBoolean) {
/* 182 */     set(paramArrayOfT, paramInt, paramBoolean);
/*     */   }
/*     */   
/*     */   public BSpline set(T[] paramArrayOfT, int paramInt, boolean paramBoolean) {
/* 186 */     if (this.tmp == null) this.tmp = paramArrayOfT[0].cpy(); 
/* 187 */     if (this.tmp2 == null) this.tmp2 = paramArrayOfT[0].cpy(); 
/* 188 */     if (this.tmp3 == null) this.tmp3 = paramArrayOfT[0].cpy(); 
/* 189 */     this.controlPoints = paramArrayOfT;
/* 190 */     this.degree = paramInt;
/* 191 */     this.continuous = paramBoolean;
/* 192 */     this.spanCount = paramBoolean ? paramArrayOfT.length : (paramArrayOfT.length - paramInt);
/* 193 */     if (this.knots == null) {
/* 194 */       this.knots = new Array(this.spanCount);
/*     */     } else {
/* 196 */       this.knots.clear();
/* 197 */       this.knots.ensureCapacity(this.spanCount);
/*     */     } 
/* 199 */     for (byte b = 0; b < this.spanCount; b++) {
/* 200 */       this.knots.add(calculate(paramArrayOfT[0].cpy(), paramBoolean ? b : (int)(b + 0.5F * paramInt), 0.0F, paramArrayOfT, paramInt, paramBoolean, this.tmp));
/*     */     }
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T valueAt(T paramT, float paramFloat) {
/* 207 */     int j = this.spanCount;
/* 208 */     float f = paramFloat * j;
/* 209 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 210 */     f -= i;
/* 211 */     return valueAt(paramT, i, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public T valueAt(T paramT, int paramInt, float paramFloat) {
/* 216 */     return calculate(paramT, this.continuous ? paramInt : (paramInt + (int)(this.degree * 0.5F)), paramFloat, this.controlPoints, this.degree, this.continuous, this.tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   public T derivativeAt(T paramT, float paramFloat) {
/* 221 */     int j = this.spanCount;
/* 222 */     float f = paramFloat * j;
/* 223 */     int i = (paramFloat >= 1.0F) ? (j - 1) : (int)f;
/* 224 */     f -= i;
/* 225 */     return derivativeAt(paramT, i, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public T derivativeAt(T paramT, int paramInt, float paramFloat) {
/* 230 */     return derivative(paramT, this.continuous ? paramInt : (paramInt + (int)(this.degree * 0.5F)), paramFloat, this.controlPoints, this.degree, this.continuous, this.tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   public int nearest(T paramT) {
/* 235 */     return nearest(paramT, 0, this.spanCount);
/*     */   }
/*     */ 
/*     */   
/*     */   public int nearest(T paramT, int paramInt1, int paramInt2) {
/* 240 */     while (paramInt1 < 0)
/* 241 */       paramInt1 += this.spanCount; 
/* 242 */     int i = paramInt1 % this.spanCount;
/* 243 */     float f = paramT.dst2((Vector)this.knots.get(i));
/* 244 */     for (byte b = 1; b < paramInt2; b++) {
/* 245 */       int j = (paramInt1 + b) % this.spanCount;
/*     */       float f1;
/* 247 */       if ((f1 = paramT.dst2((Vector)this.knots.get(j))) < f) {
/* 248 */         f = f1;
/* 249 */         i = j;
/*     */       } 
/*     */     } 
/* 252 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public float approximate(T paramT) {
/* 257 */     return approximate(paramT, nearest(paramT));
/*     */   }
/*     */   
/*     */   public float approximate(T paramT, int paramInt1, int paramInt2) {
/* 261 */     return approximate(paramT, nearest(paramT, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public float approximate(T paramT, int paramInt) {
/* 265 */     int i = paramInt;
/* 266 */     Vector<Vector> vector1 = (Vector)this.knots.get(paramInt);
/* 267 */     Vector<Vector> vector2 = (Vector)this.knots.get((paramInt > 0) ? (paramInt - 1) : (this.spanCount - 1));
/* 268 */     Vector<Vector> vector3 = (Vector)this.knots.get((paramInt + 1) % this.spanCount);
/* 269 */     float f5 = paramT.dst2(vector2);
/*     */     
/*     */     float f6;
/* 272 */     if ((f6 = paramT.dst2(vector3)) < f5) {
/* 273 */       vector2 = vector1;
/* 274 */       vector1 = vector3;
/* 275 */       paramT = paramT;
/*     */     } else {
/* 277 */       vector2 = vector2;
/* 278 */       vector1 = vector1;
/* 279 */       paramT = paramT;
/* 280 */       i = (paramInt > 0) ? (paramInt - 1) : (this.spanCount - 1);
/*     */     } 
/* 282 */     float f2 = vector2.dst2(vector1);
/* 283 */     float f3 = paramT.dst2(vector1);
/* 284 */     float f1 = paramT.dst2(vector2);
/* 285 */     float f4 = (float)Math.sqrt(f2);
/* 286 */     f1 = (f3 + f2 - f1) / f4 * 2.0F;
/* 287 */     f1 = MathUtils.clamp((f4 - f1) / f4, 0.0F, 1.0F);
/* 288 */     return (i + f1) / this.spanCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float locate(T paramT) {
/* 294 */     return approximate(paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public float approxLength(int paramInt) {
/* 299 */     float f = 0.0F;
/* 300 */     for (byte b = 0; b < paramInt; b++) {
/* 301 */       this.tmp2.set(this.tmp3);
/* 302 */       valueAt(this.tmp3, b / (paramInt - 1.0F));
/* 303 */       if (b > 0) f += this.tmp2.dst(this.tmp3); 
/*     */     } 
/* 305 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\BSpline.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */