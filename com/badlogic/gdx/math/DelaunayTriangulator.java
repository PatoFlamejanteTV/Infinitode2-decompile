/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.BooleanArray;
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
/*     */ 
/*     */ public class DelaunayTriangulator
/*     */ {
/*     */   private static final float EPSILON = 1.0E-6F;
/*     */   private static final int INSIDE = 0;
/*     */   private static final int COMPLETE = 1;
/*     */   private static final int INCOMPLETE = 2;
/*  32 */   private final IntArray quicksortStack = new IntArray();
/*     */   private float[] sortedPoints;
/*  34 */   private final ShortArray triangles = new ShortArray(false, 16);
/*  35 */   private final ShortArray originalIndices = new ShortArray(false, 0);
/*  36 */   private final IntArray edges = new IntArray();
/*  37 */   private final BooleanArray complete = new BooleanArray(false, 16);
/*  38 */   private final float[] superTriangle = new float[6];
/*  39 */   private final Vector2 centroid = new Vector2();
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(FloatArray paramFloatArray, boolean paramBoolean) {
/*  43 */     return computeTriangles(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(float[] paramArrayOffloat, boolean paramBoolean) {
/*  48 */     return computeTriangles(paramArrayOffloat, 0, paramArrayOffloat.length, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray computeTriangles(float[] paramArrayOffloat, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  59 */     if (paramInt2 > 32767) throw new IllegalArgumentException("count must be <= 32767"); 
/*     */     ShortArray shortArray;
/*  61 */     (shortArray = this.triangles).clear();
/*  62 */     if (paramInt2 < 6) return shortArray; 
/*  63 */     shortArray.ensureCapacity(paramInt2);
/*     */     
/*  65 */     if (!paramBoolean) {
/*  66 */       if (this.sortedPoints == null || this.sortedPoints.length < paramInt2) this.sortedPoints = new float[paramInt2]; 
/*  67 */       System.arraycopy(paramArrayOffloat, paramInt1, this.sortedPoints, 0, paramInt2);
/*  68 */       paramArrayOffloat = this.sortedPoints;
/*  69 */       paramInt1 = 0;
/*  70 */       sort(paramArrayOffloat, paramInt2);
/*     */     } 
/*     */     
/*  73 */     int i = paramInt1 + paramInt2;
/*     */ 
/*     */     
/*  76 */     float f1 = paramArrayOffloat[0], f2 = paramArrayOffloat[1];
/*  77 */     float f3 = f1, f4 = f2;
/*  78 */     for (int k = paramInt1 + 2; k < i; k++) {
/*     */       float f;
/*  80 */       if ((f = paramArrayOffloat[k]) < f1) f1 = f; 
/*  81 */       if (f > f3) f3 = f; 
/*  82 */       k++;
/*     */       
/*  84 */       if ((f = paramArrayOffloat[k]) < f2) f2 = f; 
/*  85 */       if (f > f4) f4 = f; 
/*     */     } 
/*  87 */     float f5 = f3 - f1, f6 = f4 - f2;
/*  88 */     f5 = ((f5 > f6) ? f5 : f6) * 20.0F;
/*  89 */     f1 = (f3 + f1) / 2.0F; f2 = (f4 + f2) / 2.0F;
/*     */     
/*     */     float[] arrayOfFloat;
/*     */     
/*  93 */     (arrayOfFloat = this.superTriangle)[0] = f1 - f5;
/*  94 */     arrayOfFloat[1] = f2 - f5;
/*  95 */     arrayOfFloat[2] = f1;
/*  96 */     arrayOfFloat[3] = f2 + f5;
/*  97 */     arrayOfFloat[4] = f1 + f5;
/*  98 */     arrayOfFloat[5] = f2 - f5;
/*     */     
/*     */     IntArray intArray;
/* 101 */     (intArray = this.edges).ensureCapacity(paramInt2 / 2);
/*     */     
/*     */     BooleanArray booleanArray;
/* 104 */     (booleanArray = this.complete).clear();
/* 105 */     booleanArray.ensureCapacity(paramInt2);
/*     */ 
/*     */     
/* 108 */     shortArray.add(i);
/* 109 */     shortArray.add(i + 2);
/* 110 */     shortArray.add(i + 4);
/* 111 */     booleanArray.add(false);
/*     */ 
/*     */     
/* 114 */     for (paramInt2 = paramInt1; paramInt2 < i; paramInt2 += 2) {
/* 115 */       f4 = paramArrayOffloat[paramInt2]; f5 = paramArrayOffloat[paramInt2 + 1];
/*     */ 
/*     */       
/* 118 */       short[] arrayOfShort1 = shortArray.items;
/* 119 */       boolean[] arrayOfBoolean = booleanArray.items;
/* 120 */       for (int m = shortArray.size - 1; m >= 0; m -= 3) {
/* 121 */         int i1 = m / 3;
/* 122 */         if (!arrayOfBoolean[i1]) {
/* 123 */           float f7, f8, f9, f10, f11, f12; short s1 = arrayOfShort1[m - 2];
/* 124 */           short s2 = arrayOfShort1[m - 1];
/* 125 */           short s3 = arrayOfShort1[m];
/*     */           
/* 127 */           if (s1 >= i) {
/* 128 */             int i2 = s1 - i;
/* 129 */             f7 = arrayOfFloat[i2];
/* 130 */             f8 = arrayOfFloat[i2 + 1];
/*     */           } else {
/* 132 */             f7 = paramArrayOffloat[s1];
/* 133 */             f8 = paramArrayOffloat[s1 + 1];
/*     */           } 
/* 135 */           if (s2 >= i) {
/* 136 */             int i2 = s2 - i;
/* 137 */             f9 = arrayOfFloat[i2];
/* 138 */             f10 = arrayOfFloat[i2 + 1];
/*     */           } else {
/* 140 */             f9 = paramArrayOffloat[s2];
/* 141 */             f10 = paramArrayOffloat[s2 + 1];
/*     */           } 
/* 143 */           if (s3 >= i) {
/* 144 */             int i2 = s3 - i;
/* 145 */             f11 = arrayOfFloat[i2];
/* 146 */             f12 = arrayOfFloat[i2 + 1];
/*     */           } else {
/* 148 */             f11 = paramArrayOffloat[s3];
/* 149 */             f12 = paramArrayOffloat[s3 + 1];
/*     */           } 
/* 151 */           switch (circumCircle(f4, f5, f7, f8, f9, f10, f11, f12)) {
/*     */             case 1:
/* 153 */               arrayOfBoolean[i1] = true;
/*     */               break;
/*     */             case 0:
/* 156 */               intArray.add(s1, s2, s2, s3);
/* 157 */               intArray.add(s3, s1);
/*     */               
/* 159 */               shortArray.removeRange(m - 2, m);
/* 160 */               booleanArray.removeIndex(i1);
/*     */               break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 165 */       int[] arrayOfInt = intArray.items; byte b; int n;
/* 166 */       for (b = 0, n = intArray.size; b < n; b += 2) {
/*     */         int i1;
/*     */         
/* 169 */         if ((i1 = arrayOfInt[b]) != -1) {
/* 170 */           int i2 = arrayOfInt[b + 1];
/* 171 */           boolean bool = false;
/* 172 */           for (int i3 = b + 2; i3 < n; i3 += 2) {
/* 173 */             if (i1 == arrayOfInt[i3 + 1] && i2 == arrayOfInt[i3]) {
/* 174 */               bool = true;
/* 175 */               arrayOfInt[i3] = -1;
/*     */             } 
/*     */           } 
/* 178 */           if (!bool)
/*     */           
/*     */           { 
/* 181 */             shortArray.add(i1);
/* 182 */             shortArray.add(arrayOfInt[b + 1]);
/* 183 */             shortArray.add(paramInt2);
/* 184 */             booleanArray.add(false); } 
/*     */         } 
/* 186 */       }  intArray.clear();
/*     */     } 
/*     */ 
/*     */     
/* 190 */     short[] arrayOfShort = shortArray.items; int j;
/* 191 */     for (j = shortArray.size - 1; j >= 0; j -= 3) {
/* 192 */       if (arrayOfShort[j] >= i || arrayOfShort[j - 1] >= i || arrayOfShort[j - 2] >= i) {
/* 193 */         shortArray.removeIndex(j);
/* 194 */         shortArray.removeIndex(j - 1);
/* 195 */         shortArray.removeIndex(j - 2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 200 */     if (!paramBoolean) {
/* 201 */       short[] arrayOfShort1 = this.originalIndices.items; byte b; int m;
/* 202 */       for (b = 0, m = shortArray.size; b < m; b++) {
/* 203 */         arrayOfShort[b] = (short)(arrayOfShort1[arrayOfShort[b] / 2] << 1);
/*     */       }
/*     */     } 
/*     */     
/* 207 */     if (paramInt1 == 0) {
/* 208 */       int m; for (j = 0, m = shortArray.size; j < m; j++)
/* 209 */         arrayOfShort[j] = (short)(arrayOfShort[j] / 2); 
/*     */     } else {
/* 211 */       int m; for (j = 0, m = shortArray.size; j < m; j++) {
/* 212 */         arrayOfShort[j] = (short)((arrayOfShort[j] - paramInt1) / 2);
/*     */       }
/*     */     } 
/* 215 */     return shortArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int circumCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 223 */     float f1 = Math.abs(paramFloat4 - paramFloat6);
/* 224 */     float f2 = Math.abs(paramFloat6 - paramFloat8);
/* 225 */     if (f1 < 1.0E-6F) {
/* 226 */       if (f2 < 1.0E-6F) return 2; 
/* 227 */       f1 = -(paramFloat7 - paramFloat5) / (paramFloat8 - paramFloat6);
/* 228 */       float f5 = (paramFloat5 + paramFloat7) / 2.0F;
/* 229 */       float f6 = (paramFloat6 + paramFloat8) / 2.0F;
/* 230 */       paramFloat3 = (paramFloat5 + paramFloat3) / 2.0F;
/* 231 */       paramFloat4 = f1 * (paramFloat3 - f5) + f6;
/*     */     } else {
/* 233 */       f1 = -(paramFloat5 - paramFloat3) / (paramFloat6 - paramFloat4);
/* 234 */       float f5 = (paramFloat3 + paramFloat5) / 2.0F;
/* 235 */       float f6 = (paramFloat4 + paramFloat6) / 2.0F;
/* 236 */       if (f2 < 1.0E-6F) {
/* 237 */         paramFloat3 = (paramFloat7 + paramFloat5) / 2.0F;
/* 238 */         paramFloat4 = f1 * (paramFloat3 - f5) + f6;
/*     */       } else {
/* 240 */         paramFloat3 = -(paramFloat7 - paramFloat5) / (paramFloat8 - paramFloat6);
/* 241 */         paramFloat4 = (paramFloat5 + paramFloat7) / 2.0F;
/* 242 */         paramFloat7 = (paramFloat6 + paramFloat8) / 2.0F;
/* 243 */         paramFloat3 = (f1 * f5 - paramFloat3 * paramFloat4 + paramFloat7 - f6) / (f1 - paramFloat3);
/* 244 */         paramFloat4 = f1 * (paramFloat3 - f5) + f6;
/*     */       } 
/*     */     } 
/*     */     
/* 248 */     f1 = paramFloat5 - paramFloat3;
/* 249 */     float f3 = paramFloat6 - paramFloat4;
/* 250 */     float f4 = f1 * f1 + f3 * f3;
/*     */ 
/*     */     
/* 253 */     f1 = (f1 = paramFloat1 - paramFloat3) * f1;
/* 254 */     f3 = paramFloat2 - paramFloat4;
/* 255 */     if (f1 + f3 * f3 - f4 <= 1.0E-6F) return 0; 
/* 256 */     return (paramFloat1 > paramFloat3 && f1 > f4) ? 1 : 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void sort(float[] paramArrayOffloat, int paramInt) {
/* 262 */     int i = paramInt / 2;
/* 263 */     this.originalIndices.clear();
/* 264 */     this.originalIndices.ensureCapacity(i);
/* 265 */     short[] arrayOfShort = this.originalIndices.items; int j;
/* 266 */     for (j = 0; j < i; j = (short)(j + 1)) {
/* 267 */       arrayOfShort[j] = j;
/*     */     }
/*     */     
/* 270 */     paramInt--;
/*     */     IntArray intArray;
/* 272 */     (intArray = this.quicksortStack).add(0);
/* 273 */     intArray.add(paramInt - 1);
/* 274 */     while (intArray.size > 0) {
/* 275 */       paramInt = intArray.pop();
/* 276 */       j = intArray.pop();
/* 277 */       if (paramInt > j) {
/*     */         int k;
/* 279 */         if ((k = quicksortPartition(paramArrayOffloat, j, paramInt, arrayOfShort)) - j > paramInt - k) {
/* 280 */           intArray.add(j);
/* 281 */           intArray.add(k - 2);
/*     */         } 
/* 283 */         intArray.add(k + 2);
/* 284 */         intArray.add(paramInt);
/* 285 */         if (paramInt - k >= k - j) {
/* 286 */           intArray.add(j);
/* 287 */           intArray.add(k - 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private int quicksortPartition(float[] paramArrayOffloat, int paramInt1, int paramInt2, short[] paramArrayOfshort) {
/* 293 */     float f = paramArrayOffloat[paramInt1];
/* 294 */     paramInt2 = paramInt2;
/* 295 */     int i = paramInt1 + 2;
/*     */ 
/*     */     
/* 298 */     while (i < paramInt2) {
/* 299 */       while (i < paramInt2 && paramArrayOffloat[i] <= f)
/* 300 */         i += 2; 
/* 301 */       while (paramArrayOffloat[paramInt2] > f)
/* 302 */         paramInt2 -= 2; 
/* 303 */       if (i < paramInt2) {
/* 304 */         float f1 = paramArrayOffloat[i];
/* 305 */         paramArrayOffloat[i] = paramArrayOffloat[paramInt2];
/* 306 */         paramArrayOffloat[paramInt2] = f1;
/*     */         
/* 308 */         f1 = paramArrayOffloat[i + 1];
/* 309 */         paramArrayOffloat[i + 1] = paramArrayOffloat[paramInt2 + 1];
/* 310 */         paramArrayOffloat[paramInt2 + 1] = f1;
/*     */         
/* 312 */         short s = paramArrayOfshort[i / 2];
/* 313 */         paramArrayOfshort[i / 2] = paramArrayOfshort[paramInt2 / 2];
/* 314 */         paramArrayOfshort[paramInt2 / 2] = s;
/*     */       } 
/*     */     } 
/* 317 */     if (f > paramArrayOffloat[paramInt2]) {
/* 318 */       paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt2];
/* 319 */       paramArrayOffloat[paramInt2] = f;
/*     */       
/* 321 */       float f1 = paramArrayOffloat[paramInt1 + 1];
/* 322 */       paramArrayOffloat[paramInt1 + 1] = paramArrayOffloat[paramInt2 + 1];
/* 323 */       paramArrayOffloat[paramInt2 + 1] = f1;
/*     */       
/* 325 */       short s = paramArrayOfshort[paramInt1 / 2];
/* 326 */       paramArrayOfshort[paramInt1 / 2] = paramArrayOfshort[paramInt2 / 2];
/* 327 */       paramArrayOfshort[paramInt2 / 2] = s;
/*     */     } 
/* 329 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trim(ShortArray paramShortArray, float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2) {
/* 335 */     short[] arrayOfShort = paramShortArray.items;
/* 336 */     for (int i = paramShortArray.size - 1; i >= 0; i -= 3) {
/* 337 */       int j = arrayOfShort[i - 2] << 1;
/* 338 */       int k = arrayOfShort[i - 1] << 1;
/* 339 */       int m = arrayOfShort[i] << 1;
/* 340 */       GeometryUtils.triangleCentroid(paramArrayOffloat1[j], paramArrayOffloat1[j + 1], paramArrayOffloat1[k], paramArrayOffloat1[k + 1], paramArrayOffloat1[m], paramArrayOffloat1[m + 1], this.centroid);
/*     */       
/* 342 */       if (!Intersector.isPointInPolygon(paramArrayOffloat2, paramInt1, paramInt2, this.centroid.x, this.centroid.y)) {
/* 343 */         paramShortArray.removeIndex(i);
/* 344 */         paramShortArray.removeIndex(i - 1);
/* 345 */         paramShortArray.removeIndex(i - 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\DelaunayTriangulator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */