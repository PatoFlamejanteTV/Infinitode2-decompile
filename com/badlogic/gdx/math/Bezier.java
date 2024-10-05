/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class Bezier<T extends Vector<T>>
/*     */   implements Path<T>
/*     */ {
/*     */   public static <T extends Vector<T>> T linear(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4) {
/*  36 */     return paramT1.set(paramT2).scl(1.0F - paramFloat).add(paramT4.set(paramT3).scl(paramFloat));
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
/*     */   public static <T extends Vector<T>> T linear_derivative(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4) {
/*  48 */     return paramT1.set(paramT3).sub(paramT2);
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
/*     */   public static <T extends Vector<T>> T quadratic(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4, T paramT5) {
/*  61 */     float f = 1.0F - paramFloat;
/*  62 */     return paramT1.set(paramT2).scl(f * f).add(paramT5.set(paramT3).scl(f * 2.0F * paramFloat)).add(paramT5.set(paramT4).scl(paramFloat * paramFloat));
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
/*     */   public static <T extends Vector<T>> T quadratic_derivative(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4, T paramT5) {
/*  76 */     float f = 1.0F - paramFloat;
/*  77 */     return paramT1.set(paramT3).sub(paramT2).scl(2.0F).scl(f).add(paramT5.set(paramT4).sub(paramT3).scl(paramFloat).scl(2.0F));
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
/*     */   public static <T extends Vector<T>> T cubic(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6) {
/*  93 */     float f1, f2 = (f1 = 1.0F - paramFloat) * f1;
/*  94 */     float f3 = paramFloat * paramFloat;
/*  95 */     return paramT1.set(paramT2).scl(f2 * f1).add(paramT6.set(paramT3).scl(3.0F * f2 * paramFloat)).add(paramT6.set(paramT4).scl(3.0F * f1 * f3))
/*  96 */       .add(paramT6.set(paramT5).scl(f3 * paramFloat));
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
/*     */   public static <T extends Vector<T>> T cubic_derivative(T paramT1, float paramFloat, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6) {
/* 112 */     float f1, f2 = (f1 = 1.0F - paramFloat) * f1;
/* 113 */     float f3 = paramFloat * paramFloat;
/* 114 */     return paramT1.set(paramT3).sub(paramT2).scl(f2 * 3.0F).add(paramT6.set(paramT4).sub(paramT3).scl(f1 * paramFloat * 6.0F)).add(paramT6.set(paramT5).sub(paramT4).scl(f3 * 3.0F));
/*     */   }
/*     */   
/* 117 */   public Array<T> points = new Array();
/*     */   
/*     */   private T tmp;
/*     */   
/*     */   private T tmp2;
/*     */   
/*     */   private T tmp3;
/*     */   
/*     */   public Bezier(T... paramVarArgs) {
/* 126 */     set(paramVarArgs);
/*     */   }
/*     */   
/*     */   public Bezier(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 130 */     set(paramArrayOfT, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public Bezier(Array<T> paramArray, int paramInt1, int paramInt2) {
/* 134 */     set(paramArray, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public Bezier set(T... paramVarArgs) {
/* 138 */     return set(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public Bezier set(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 142 */     if (paramInt2 < 2 || paramInt2 > 4)
/* 143 */       throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported."); 
/* 144 */     if (this.tmp == null) this.tmp = paramArrayOfT[0].cpy(); 
/* 145 */     if (this.tmp2 == null) this.tmp2 = paramArrayOfT[0].cpy(); 
/* 146 */     if (this.tmp3 == null) this.tmp3 = paramArrayOfT[0].cpy(); 
/* 147 */     this.points.clear();
/* 148 */     this.points.addAll((Object[])paramArrayOfT, paramInt1, paramInt2);
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public Bezier set(Array<T> paramArray, int paramInt1, int paramInt2) {
/* 153 */     if (paramInt2 < 2 || paramInt2 > 4)
/* 154 */       throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported."); 
/* 155 */     if (this.tmp == null) this.tmp = ((Vector<T>)paramArray.get(0)).cpy(); 
/* 156 */     if (this.tmp2 == null) this.tmp2 = ((Vector<T>)paramArray.get(0)).cpy(); 
/* 157 */     if (this.tmp3 == null) this.tmp3 = ((Vector<T>)paramArray.get(0)).cpy(); 
/* 158 */     this.points.clear();
/* 159 */     this.points.addAll(paramArray, paramInt1, paramInt2);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T valueAt(T paramT, float paramFloat) {
/*     */     int i;
/* 166 */     if ((i = this.points.size) == 2)
/* 167 */     { linear(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), this.tmp); }
/* 168 */     else if (i == 3)
/* 169 */     { quadratic(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), (T)this.points.get(2), this.tmp); }
/* 170 */     else if (i == 4) { cubic(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), (T)this.points.get(2), (T)this.points.get(3), this.tmp); }
/* 171 */      return paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   public T derivativeAt(T paramT, float paramFloat) {
/*     */     int i;
/* 177 */     if ((i = this.points.size) == 2)
/* 178 */     { linear_derivative(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), this.tmp); }
/* 179 */     else if (i == 3)
/* 180 */     { quadratic_derivative(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), (T)this.points.get(2), this.tmp); }
/* 181 */     else if (i == 4) { cubic_derivative(paramT, paramFloat, (T)this.points.get(0), (T)this.points.get(1), (T)this.points.get(2), (T)this.points.get(3), this.tmp); }
/* 182 */      return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float approximate(T paramT) {
/* 188 */     Vector<Vector> vector = (Vector)this.points.get(0);
/* 189 */     Vector vector1 = (Vector)this.points.get(this.points.size - 1);
/* 190 */     paramT = paramT;
/* 191 */     float f4 = vector.dst2(vector1);
/* 192 */     float f3 = paramT.dst2(vector1);
/* 193 */     float f1 = paramT.dst2(vector);
/* 194 */     float f2 = (float)Math.sqrt(f4);
/* 195 */     f1 = (f3 + f4 - f1) / f2 * 2.0F;
/* 196 */     return MathUtils.clamp((f2 - f1) / f2, 0.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float locate(T paramT) {
/* 202 */     return approximate(paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public float approxLength(int paramInt) {
/* 207 */     float f = 0.0F;
/* 208 */     for (byte b = 0; b < paramInt; b++) {
/* 209 */       this.tmp2.set(this.tmp3);
/* 210 */       valueAt(this.tmp3, b / (paramInt - 1.0F));
/* 211 */       if (b > 0) f += this.tmp2.dst(this.tmp3); 
/*     */     } 
/* 213 */     return f;
/*     */   }
/*     */   
/*     */   public Bezier() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Bezier.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */