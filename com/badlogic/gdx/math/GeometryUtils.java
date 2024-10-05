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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GeometryUtils
/*     */ {
/*  25 */   private static final Vector2 tmp1 = new Vector2(), tmp2 = new Vector2(), tmp3 = new Vector2();
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
/*     */   public static Vector2 toBarycoord(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25) {
/*  45 */     paramVector23 = tmp1.set(paramVector23).sub(paramVector22);
/*  46 */     paramVector24 = tmp2.set(paramVector24).sub(paramVector22);
/*  47 */     paramVector21 = tmp3.set(paramVector21).sub(paramVector22);
/*  48 */     float f2 = paramVector23.dot(paramVector23);
/*  49 */     float f5 = paramVector23.dot(paramVector24);
/*  50 */     float f6 = paramVector24.dot(paramVector24);
/*  51 */     float f3 = paramVector21.dot(paramVector23);
/*  52 */     float f1 = paramVector21.dot(paramVector24);
/*  53 */     float f4 = f2 * f6 - f5 * f5;
/*  54 */     paramVector25.x = (f6 * f3 - f5 * f1) / f4;
/*  55 */     paramVector25.y = (f2 * f1 - f5 * f3) / f4;
/*  56 */     return paramVector25;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean barycoordInsideTriangle(Vector2 paramVector2) {
/*  61 */     return (paramVector2.x >= 0.0F && paramVector2.y >= 0.0F && paramVector2.x + paramVector2.y <= 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Vector2 fromBarycoord(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25) {
/*  67 */     float f = 1.0F - paramVector21.x - paramVector21.y;
/*  68 */     paramVector25.x = f * paramVector22.x + paramVector21.x * paramVector23.x + paramVector21.y * paramVector24.x;
/*  69 */     paramVector25.y = f * paramVector22.y + paramVector21.x * paramVector23.y + paramVector21.y * paramVector24.y;
/*  70 */     return paramVector25;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float fromBarycoord(Vector2 paramVector2, float paramFloat1, float paramFloat2, float paramFloat3) {
/*     */     float f;
/*  77 */     return (f = 1.0F - paramVector2.x - paramVector2.y) * paramFloat1 + paramVector2.x * paramFloat2 + paramVector2.y * paramFloat3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float lowestPositiveRoot(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  88 */     if ((paramFloat3 = paramFloat2 * paramFloat2 - 4.0F * paramFloat1 * paramFloat3) < 0.0F) return Float.NaN;
/*     */     
/*  90 */     paramFloat3 = (float)Math.sqrt(paramFloat3);
/*  91 */     paramFloat1 = 1.0F / paramFloat1 * 2.0F;
/*  92 */     float f = (-paramFloat2 - paramFloat3) * paramFloat1;
/*  93 */     paramFloat1 = (-paramFloat2 + paramFloat3) * paramFloat1;
/*     */     
/*  95 */     if (f > paramFloat1) {
/*  96 */       paramFloat2 = paramFloat1;
/*  97 */       paramFloat1 = f;
/*  98 */       f = paramFloat2;
/*     */     } 
/*     */     
/* 101 */     if (f > 0.0F) return f; 
/* 102 */     if (paramFloat1 > 0.0F) return paramFloat1; 
/* 103 */     return Float.NaN;
/*     */   }
/*     */   
/*     */   public static boolean colinear(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 107 */     paramFloat1 = paramFloat3 - paramFloat1; paramFloat2 = paramFloat4 - paramFloat2;
/* 108 */     paramFloat3 = paramFloat5 - paramFloat3; paramFloat4 = paramFloat6 - paramFloat4;
/*     */     
/* 110 */     return (Math.abs(paramFloat1 = paramFloat3 * paramFloat2 - paramFloat1 * paramFloat4) < 1.0E-6F);
/*     */   }
/*     */   
/*     */   public static Vector2 triangleCentroid(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2) {
/* 114 */     paramVector2.x = (paramFloat1 + paramFloat3 + paramFloat5) / 3.0F;
/* 115 */     paramVector2.y = (paramFloat2 + paramFloat4 + paramFloat6) / 3.0F;
/* 116 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector2 triangleCircumcenter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2) {
/* 121 */     float f1 = paramFloat3 - paramFloat1, f2 = paramFloat4 - paramFloat2;
/* 122 */     float f3 = paramFloat5 - paramFloat3, f4 = paramFloat6 - paramFloat4;
/* 123 */     float f5 = paramFloat1 - paramFloat5, f6 = paramFloat2 - paramFloat6;
/*     */     float f7;
/* 125 */     if (Math.abs(f7 = f3 * f2 - f1 * f4) < 1.0E-6F)
/* 126 */       throw new IllegalArgumentException("Triangle points must not be colinear."); 
/* 127 */     f7 *= 2.0F;
/* 128 */     paramFloat1 = paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2; paramFloat2 = paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4; paramFloat3 = paramFloat5 * paramFloat5 + paramFloat6 * paramFloat6;
/* 129 */     paramVector2.set((paramFloat1 * f4 + paramFloat2 * f6 + paramFloat3 * f2) / f7, -(paramFloat1 * f3 + paramFloat2 * f5 + paramFloat3 * f1) / f7);
/* 130 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float triangleCircumradius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 135 */     if (Math.abs(paramFloat4 - paramFloat2) < 1.0E-6F) {
/* 136 */       float f = -(paramFloat5 - paramFloat3) / (paramFloat6 - paramFloat4);
/* 137 */       paramFloat5 = (paramFloat3 + paramFloat5) / 2.0F;
/* 138 */       paramFloat4 = (paramFloat4 + paramFloat6) / 2.0F;
/* 139 */       paramFloat3 = (paramFloat3 + paramFloat1) / 2.0F;
/* 140 */       paramFloat4 = f * (paramFloat3 - paramFloat5) + paramFloat4;
/* 141 */     } else if (Math.abs(paramFloat6 - paramFloat4) < 1.0E-6F) {
/* 142 */       float f1 = -(paramFloat3 - paramFloat1) / (paramFloat4 - paramFloat2);
/* 143 */       float f2 = (paramFloat1 + paramFloat3) / 2.0F;
/* 144 */       float f3 = (paramFloat2 + paramFloat4) / 2.0F;
/* 145 */       paramFloat3 = (paramFloat5 + paramFloat3) / 2.0F;
/* 146 */       paramFloat4 = f1 * (paramFloat3 - f2) + f3;
/*     */     } else {
/* 148 */       float f1 = -(paramFloat3 - paramFloat1) / (paramFloat4 - paramFloat2);
/* 149 */       float f2 = -(paramFloat5 - paramFloat3) / (paramFloat6 - paramFloat4);
/* 150 */       float f3 = (paramFloat1 + paramFloat3) / 2.0F;
/* 151 */       paramFloat5 = (paramFloat3 + paramFloat5) / 2.0F;
/* 152 */       float f4 = (paramFloat2 + paramFloat4) / 2.0F;
/* 153 */       paramFloat4 = (paramFloat4 + paramFloat6) / 2.0F;
/* 154 */       paramFloat3 = (f1 * f3 - f2 * paramFloat5 + paramFloat4 - f4) / (f1 - f2);
/* 155 */       paramFloat4 = f1 * (paramFloat3 - f3) + f4;
/*     */     } 
/* 157 */     paramFloat1 -= paramFloat3; paramFloat2 -= paramFloat4;
/* 158 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float triangleQuality(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 166 */     float f1 = paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
/* 167 */     float f2 = paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/* 168 */     float f3 = paramFloat5 * paramFloat5 + paramFloat6 * paramFloat6;
/* 169 */     return (float)Math.sqrt(Math.min(f1, Math.min(f2, f3))) / triangleCircumradius(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/*     */   }
/*     */   
/*     */   public static float triangleArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 173 */     return Math.abs((paramFloat1 - paramFloat5) * (paramFloat4 - paramFloat2) - (paramFloat1 - paramFloat3) * (paramFloat6 - paramFloat2)) * 0.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector2 quadrilateralCentroid(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2) {
/* 178 */     paramFloat3 = (paramFloat1 + paramFloat3 + paramFloat5) / 3.0F;
/* 179 */     paramFloat4 = (paramFloat2 + paramFloat4 + paramFloat6) / 3.0F;
/* 180 */     paramFloat1 = (paramFloat1 + paramFloat7 + paramFloat5) / 3.0F;
/* 181 */     paramFloat2 = (paramFloat2 + paramFloat8 + paramFloat6) / 3.0F;
/* 182 */     paramVector2.x = paramFloat3 - (paramFloat3 - paramFloat1) / 2.0F;
/* 183 */     paramVector2.y = paramFloat4 - (paramFloat4 - paramFloat2) / 2.0F;
/* 184 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector2 polygonCentroid(float[] paramArrayOffloat, int paramInt1, int paramInt2, Vector2 paramVector2) {
/* 189 */     if (paramInt2 < 6) throw new IllegalArgumentException("A polygon must have 3 or more coordinate pairs.");
/*     */     
/* 191 */     float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F;
/* 192 */     paramInt2 = paramInt1 + paramInt2 - 2;
/* 193 */     float f4 = paramArrayOffloat[paramInt2], f5 = paramArrayOffloat[paramInt2 + 1];
/* 194 */     for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1 += 2) {
/* 195 */       float f6 = paramArrayOffloat[paramInt1], f7 = paramArrayOffloat[paramInt1 + 1];
/* 196 */       float f8 = f4 * f7 - f6 * f5;
/* 197 */       f1 += f8;
/* 198 */       f2 += (f4 + f6) * f8;
/* 199 */       f3 += (f5 + f7) * f8;
/* 200 */       f4 = f6;
/* 201 */       f5 = f7;
/*     */     } 
/* 203 */     if (f1 == 0.0F) {
/* 204 */       paramVector2.x = 0.0F;
/* 205 */       paramVector2.y = 0.0F;
/*     */     } else {
/* 207 */       f1 *= 0.5F;
/* 208 */       paramVector2.x = f2 / 6.0F * f1;
/* 209 */       paramVector2.y = f3 / 6.0F * f1;
/*     */     } 
/* 211 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float polygonArea(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 216 */     float f1 = 0.0F;
/* 217 */     paramInt2 = paramInt1 + paramInt2 - 2;
/* 218 */     float f2 = paramArrayOffloat[paramInt2], f3 = paramArrayOffloat[paramInt2 + 1];
/* 219 */     for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1 += 2) {
/* 220 */       float f4 = paramArrayOffloat[paramInt1], f5 = paramArrayOffloat[paramInt1 + 1];
/* 221 */       f1 += f2 * f5 - f4 * f3;
/* 222 */       f2 = f4;
/* 223 */       f3 = f5;
/*     */     } 
/* 225 */     return f1 * 0.5F;
/*     */   }
/*     */   
/*     */   public static void ensureCCW(float[] paramArrayOffloat) {
/* 229 */     ensureCCW(paramArrayOffloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */   
/*     */   public static void ensureCCW(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 233 */     if (!isClockwise(paramArrayOffloat, paramInt1, paramInt2))
/* 234 */       return;  reverseVertices(paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static void ensureClockwise(float[] paramArrayOffloat) {
/* 238 */     ensureClockwise(paramArrayOffloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */   
/*     */   public static void ensureClockwise(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 242 */     if (isClockwise(paramArrayOffloat, paramInt1, paramInt2))
/* 243 */       return;  reverseVertices(paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static void reverseVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 247 */     int i = paramInt1 + paramInt2 - 2;
/* 248 */     for (int j = paramInt1; j < paramInt1; j += 2) {
/* 249 */       paramInt2 = i - j;
/* 250 */       float f1 = paramArrayOffloat[j];
/* 251 */       float f2 = paramArrayOffloat[j + 1];
/* 252 */       paramArrayOffloat[j] = paramArrayOffloat[paramInt2];
/* 253 */       paramArrayOffloat[j + 1] = paramArrayOffloat[paramInt2 + 1];
/* 254 */       paramArrayOffloat[paramInt2] = f1;
/* 255 */       paramArrayOffloat[paramInt2 + 1] = f2;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean isClockwise(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 260 */     if (paramInt2 <= 2) return false; 
/* 261 */     float f1 = 0.0F;
/* 262 */     paramInt2 = paramInt1 + paramInt2 - 2;
/* 263 */     float f2 = paramArrayOffloat[paramInt2], f3 = paramArrayOffloat[paramInt2 + 1];
/* 264 */     for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1 += 2) {
/* 265 */       float f4 = paramArrayOffloat[paramInt1], f5 = paramArrayOffloat[paramInt1 + 1];
/* 266 */       f1 += f2 * f5 - f4 * f3;
/* 267 */       f2 = f4;
/* 268 */       f3 = f5;
/*     */     } 
/* 270 */     return (f1 < 0.0F);
/*     */   }
/*     */   
/*     */   public static boolean isCCW(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 274 */     return !isClockwise(paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\GeometryUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */