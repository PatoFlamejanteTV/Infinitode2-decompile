/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.ShortArray;
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
/*     */ public class ConvexHull
/*     */ {
/*  26 */   private final IntArray quicksortStack = new IntArray();
/*     */   private float[] sortedPoints;
/*  28 */   private final FloatArray hull = new FloatArray();
/*  29 */   private final IntArray indices = new IntArray();
/*  30 */   private final ShortArray originalIndices = new ShortArray(false, 0);
/*     */ 
/*     */   
/*     */   public FloatArray computePolygon(FloatArray paramFloatArray, boolean paramBoolean) {
/*  34 */     return computePolygon(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatArray computePolygon(float[] paramArrayOffloat, boolean paramBoolean) {
/*  39 */     return computePolygon(paramArrayOffloat, 0, paramArrayOffloat.length, paramBoolean);
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
/*     */   public FloatArray computePolygon(float[] paramArrayOffloat, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  51 */     int j = paramInt1 + paramInt2;
/*     */     
/*  53 */     if (!paramBoolean) {
/*  54 */       if (this.sortedPoints == null || this.sortedPoints.length < paramInt2) this.sortedPoints = new float[paramInt2]; 
/*  55 */       System.arraycopy(paramArrayOffloat, paramInt1, this.sortedPoints, 0, paramInt2);
/*  56 */       paramArrayOffloat = this.sortedPoints;
/*  57 */       paramInt1 = 0;
/*  58 */       j = paramInt2;
/*  59 */       sort(paramArrayOffloat, paramInt2);
/*     */     } 
/*     */     
/*     */     FloatArray floatArray;
/*  63 */     (floatArray = this.hull).clear();
/*     */     
/*     */     int i;
/*  66 */     for (i = paramInt1; i < j; i += 2) {
/*  67 */       float f1 = paramArrayOffloat[i];
/*  68 */       float f2 = paramArrayOffloat[i + 1];
/*  69 */       while (floatArray.size >= 4 && ccw(f1, f2) <= 0.0F)
/*  70 */         floatArray.size -= 2; 
/*  71 */       floatArray.add(f1);
/*  72 */       floatArray.add(f2);
/*     */     } 
/*     */     
/*     */     int k;
/*  76 */     for (i = j - 4, k = floatArray.size + 2; i >= paramInt1; i -= 2) {
/*  77 */       float f2 = paramArrayOffloat[i];
/*  78 */       float f1 = paramArrayOffloat[i + 1];
/*  79 */       while (floatArray.size >= k && ccw(f2, f1) <= 0.0F)
/*  80 */         floatArray.size -= 2; 
/*  81 */       floatArray.add(f2);
/*  82 */       floatArray.add(f1);
/*     */     } 
/*     */     
/*  85 */     return floatArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public IntArray computeIndices(FloatArray paramFloatArray, boolean paramBoolean1, boolean paramBoolean2) {
/*  90 */     return computeIndices(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntArray computeIndices(float[] paramArrayOffloat, boolean paramBoolean1, boolean paramBoolean2) {
/*  95 */     return computeIndices(paramArrayOffloat, 0, paramArrayOffloat.length, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray computeIndices(float[] paramArrayOffloat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 101 */     if (paramInt2 > 32767) throw new IllegalArgumentException("count must be <= 32767"); 
/* 102 */     int i = paramInt1 + paramInt2;
/*     */     
/* 104 */     if (!paramBoolean1) {
/* 105 */       if (this.sortedPoints == null || this.sortedPoints.length < paramInt2) this.sortedPoints = new float[paramInt2]; 
/* 106 */       System.arraycopy(paramArrayOffloat, paramInt1, this.sortedPoints, 0, paramInt2);
/* 107 */       paramArrayOffloat = this.sortedPoints;
/* 108 */       paramInt1 = 0;
/* 109 */       i = paramInt2;
/* 110 */       sortWithIndices(paramArrayOffloat, paramInt2, paramBoolean2);
/*     */     } 
/*     */     
/*     */     IntArray intArray;
/* 114 */     (intArray = this.indices).clear();
/*     */     
/*     */     FloatArray floatArray;
/* 117 */     (floatArray = this.hull).clear();
/*     */     
/*     */     int j, k;
/* 120 */     for (k = (j = paramInt1) / 2; j < i; j += 2, k++) {
/* 121 */       float f1 = paramArrayOffloat[j];
/* 122 */       float f2 = paramArrayOffloat[j + 1];
/* 123 */       while (floatArray.size >= 4 && ccw(f1, f2) <= 0.0F) {
/* 124 */         floatArray.size -= 2;
/* 125 */         intArray.size--;
/*     */       } 
/* 127 */       floatArray.add(f1);
/* 128 */       floatArray.add(f2);
/* 129 */       intArray.add(k);
/*     */     } 
/*     */     
/*     */     int m;
/* 133 */     for (k = (j = i - 4) / 2, m = floatArray.size + 2; j >= paramInt1; j -= 2, k--) {
/* 134 */       float f2 = paramArrayOffloat[j];
/* 135 */       float f1 = paramArrayOffloat[j + 1];
/* 136 */       while (floatArray.size >= m && ccw(f2, f1) <= 0.0F) {
/* 137 */         floatArray.size -= 2;
/* 138 */         intArray.size--;
/*     */       } 
/* 140 */       floatArray.add(f2);
/* 141 */       floatArray.add(f1);
/* 142 */       intArray.add(k);
/*     */     } 
/*     */ 
/*     */     
/* 146 */     if (!paramBoolean1) {
/* 147 */       short[] arrayOfShort = this.originalIndices.items;
/* 148 */       int[] arrayOfInt = intArray.items; int n;
/* 149 */       for (m = 0, n = intArray.size; m < n; m++) {
/* 150 */         arrayOfInt[m] = arrayOfShort[arrayOfInt[m]];
/*     */       }
/*     */     } 
/* 153 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   private float ccw(float paramFloat1, float paramFloat2) {
/*     */     FloatArray floatArray;
/* 159 */     int i = (floatArray = this.hull).size;
/* 160 */     float f3 = floatArray.get(i - 4);
/* 161 */     float f4 = floatArray.get(i - 3);
/* 162 */     float f2 = floatArray.get(i - 2);
/* 163 */     float f1 = floatArray.peek();
/* 164 */     return (f2 - f3) * (paramFloat2 - f4) - (f1 - f4) * (paramFloat1 - f3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sort(float[] paramArrayOffloat, int paramInt) {
/* 171 */     int i = paramInt - 1;
/*     */     IntArray intArray;
/* 173 */     (intArray = this.quicksortStack).add(0);
/* 174 */     intArray.add(i - 1);
/* 175 */     while (intArray.size > 0) {
/* 176 */       i = intArray.pop();
/* 177 */       paramInt = intArray.pop();
/* 178 */       if (i > paramInt) {
/*     */         int j;
/* 180 */         if ((j = quicksortPartition(paramArrayOffloat, paramInt, i)) - paramInt > i - j) {
/* 181 */           intArray.add(paramInt);
/* 182 */           intArray.add(j - 2);
/*     */         } 
/* 184 */         intArray.add(j + 2);
/* 185 */         intArray.add(i);
/* 186 */         if (i - j >= j - paramInt) {
/* 187 */           intArray.add(paramInt);
/* 188 */           intArray.add(j - 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private int quicksortPartition(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 194 */     float f1 = paramArrayOffloat[paramInt1];
/* 195 */     float f2 = paramArrayOffloat[paramInt1 + 1];
/* 196 */     paramInt2 = paramInt2;
/* 197 */     int i = paramInt1;
/*     */     
/* 199 */     while (i < paramInt2) {
/* 200 */       while (i < paramInt2 && paramArrayOffloat[i] <= f1)
/* 201 */         i += 2; 
/* 202 */       while (paramArrayOffloat[paramInt2] > f1 || (paramArrayOffloat[paramInt2] == f1 && paramArrayOffloat[paramInt2 + 1] < f2))
/* 203 */         paramInt2 -= 2; 
/* 204 */       if (i < paramInt2) {
/* 205 */         float f = paramArrayOffloat[i];
/* 206 */         paramArrayOffloat[i] = paramArrayOffloat[paramInt2];
/* 207 */         paramArrayOffloat[paramInt2] = f;
/*     */         
/* 209 */         f = paramArrayOffloat[i + 1];
/* 210 */         paramArrayOffloat[i + 1] = paramArrayOffloat[paramInt2 + 1];
/* 211 */         paramArrayOffloat[paramInt2 + 1] = f;
/*     */       } 
/*     */     } 
/* 214 */     if (f1 > paramArrayOffloat[paramInt2] || (f1 == paramArrayOffloat[paramInt2] && f2 < paramArrayOffloat[paramInt2 + 1])) {
/* 215 */       paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt2];
/* 216 */       paramArrayOffloat[paramInt2] = f1;
/*     */       
/* 218 */       paramArrayOffloat[paramInt1 + 1] = paramArrayOffloat[paramInt2 + 1];
/* 219 */       paramArrayOffloat[paramInt2 + 1] = f2;
/*     */     } 
/* 221 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void sortWithIndices(float[] paramArrayOffloat, int paramInt, boolean paramBoolean) {
/* 227 */     int i = paramInt / 2;
/* 228 */     this.originalIndices.clear();
/* 229 */     this.originalIndices.ensureCapacity(i);
/* 230 */     short[] arrayOfShort = this.originalIndices.items; int j;
/* 231 */     for (j = 0; j < i; j = (short)(j + 1)) {
/* 232 */       arrayOfShort[j] = j;
/*     */     }
/*     */     
/* 235 */     paramInt--;
/*     */     IntArray intArray;
/* 237 */     (intArray = this.quicksortStack).add(0);
/* 238 */     intArray.add(paramInt - 1);
/* 239 */     while (intArray.size > 0) {
/* 240 */       paramInt = intArray.pop();
/* 241 */       j = intArray.pop();
/* 242 */       if (paramInt > j) {
/*     */         int k;
/* 244 */         if ((k = quicksortPartitionWithIndices(paramArrayOffloat, j, paramInt, paramBoolean, arrayOfShort)) - j > paramInt - k) {
/* 245 */           intArray.add(j);
/* 246 */           intArray.add(k - 2);
/*     */         } 
/* 248 */         intArray.add(k + 2);
/* 249 */         intArray.add(paramInt);
/* 250 */         if (paramInt - k >= k - j) {
/* 251 */           intArray.add(j);
/* 252 */           intArray.add(k - 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int quicksortPartitionWithIndices(float[] paramArrayOffloat, int paramInt1, int paramInt2, boolean paramBoolean, short[] paramArrayOfshort) {
/* 259 */     float f1 = paramArrayOffloat[paramInt1];
/* 260 */     float f2 = paramArrayOffloat[paramInt1 + 1];
/* 261 */     paramInt2 = paramInt2;
/* 262 */     int i = paramInt1;
/*     */ 
/*     */     
/* 265 */     while (i < paramInt2) {
/* 266 */       while (i < paramInt2 && paramArrayOffloat[i] <= f1)
/* 267 */         i += 2; 
/* 268 */       if (paramBoolean) {
/* 269 */         while (paramArrayOffloat[paramInt2] > f1 || (paramArrayOffloat[paramInt2] == f1 && paramArrayOffloat[paramInt2 + 1] < f2))
/* 270 */           paramInt2 -= 2; 
/*     */       } else {
/* 272 */         while (paramArrayOffloat[paramInt2] > f1 || (paramArrayOffloat[paramInt2] == f1 && paramArrayOffloat[paramInt2 + 1] > f2))
/* 273 */           paramInt2 -= 2; 
/*     */       } 
/* 275 */       if (i < paramInt2) {
/* 276 */         float f = paramArrayOffloat[i];
/* 277 */         paramArrayOffloat[i] = paramArrayOffloat[paramInt2];
/* 278 */         paramArrayOffloat[paramInt2] = f;
/*     */         
/* 280 */         f = paramArrayOffloat[i + 1];
/* 281 */         paramArrayOffloat[i + 1] = paramArrayOffloat[paramInt2 + 1];
/* 282 */         paramArrayOffloat[paramInt2 + 1] = f;
/*     */         
/* 284 */         short s = paramArrayOfshort[i / 2];
/* 285 */         paramArrayOfshort[i / 2] = paramArrayOfshort[paramInt2 / 2];
/* 286 */         paramArrayOfshort[paramInt2 / 2] = s;
/*     */       } 
/*     */     } 
/* 289 */     if (f1 > paramArrayOffloat[paramInt2] || (f1 == paramArrayOffloat[paramInt2] && (paramBoolean ? (f2 < paramArrayOffloat[paramInt2 + 1]) : (f2 > paramArrayOffloat[paramInt2 + 1])))) {
/* 290 */       paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt2];
/* 291 */       paramArrayOffloat[paramInt2] = f1;
/*     */       
/* 293 */       paramArrayOffloat[paramInt1 + 1] = paramArrayOffloat[paramInt2 + 1];
/* 294 */       paramArrayOffloat[paramInt2 + 1] = f2;
/*     */       
/* 296 */       short s = paramArrayOfshort[paramInt1 / 2];
/* 297 */       paramArrayOfshort[paramInt1 / 2] = paramArrayOfshort[paramInt2 / 2];
/* 298 */       paramArrayOfshort[paramInt2 / 2] = s;
/*     */     } 
/* 300 */     return paramInt2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\ConvexHull.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */