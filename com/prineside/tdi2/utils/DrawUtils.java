/*     */ package com.prineside.tdi2.utils;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Bezier;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.google.common.base.Preconditions;
/*     */ 
/*     */ public class DrawUtils {
/*  21 */   private static final float a = Color.WHITE.toFloatBits();
/*     */   
/*  23 */   private static final float[] b = new float[20];
/*  24 */   private static float[] c = new float[0];
/*     */   
/*  26 */   private static final Vector2 d = new Vector2();
/*     */   
/*     */   private static void a(int paramInt) {
/*  29 */     if (c.length < paramInt) {
/*  30 */       float[] arrayOfFloat = new float[MathUtils.nextPowerOfTwo(paramInt)];
/*  31 */       System.arraycopy(c, 0, arrayOfFloat, 0, c.length);
/*  32 */       c = arrayOfFloat;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void bakeVertices(float[] paramArrayOffloat, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  42 */     paramFloat1 += paramFloat3;
/*  43 */     paramFloat2 += paramFloat4;
/*  44 */     float f2 = -paramFloat3;
/*  45 */     float f3 = -paramFloat4;
/*  46 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  47 */     paramFloat4 = paramFloat6 - paramFloat4;
/*     */ 
/*     */     
/*  50 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  51 */       f2 *= paramFloat7;
/*  52 */       f3 *= paramFloat8;
/*  53 */       paramFloat3 *= paramFloat7;
/*  54 */       paramFloat4 *= paramFloat8;
/*     */     } 
/*     */ 
/*     */     
/*  58 */     paramFloat5 = f2;
/*  59 */     paramFloat6 = f3;
/*  60 */     paramFloat7 = f2;
/*  61 */     paramFloat8 = paramFloat4;
/*  62 */     f2 = paramFloat3;
/*  63 */     paramFloat4 = paramFloat4;
/*  64 */     paramFloat3 = paramFloat3;
/*  65 */     f3 = f3;
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
/*  77 */     if (paramFloat9 != 0.0F) {
/*  78 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  79 */       float f = MathUtils.sinDeg(paramFloat9);
/*     */       
/*  81 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  82 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*     */       
/*  84 */       paramFloat6 = f3 * paramFloat7 - f * paramFloat8;
/*  85 */       paramFloat7 = f * paramFloat7 + f3 * paramFloat8;
/*     */       
/*  87 */       paramFloat8 = f3 * f2 - f * paramFloat4;
/*  88 */       paramFloat4 = f * f2 + f3 * paramFloat4;
/*     */       
/*  90 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  91 */       f2 = paramFloat4 - paramFloat7 - paramFloat5;
/*     */     } else {
/*  93 */       paramFloat9 = paramFloat5;
/*  94 */       paramFloat5 = paramFloat6;
/*     */       
/*  96 */       paramFloat6 = paramFloat7;
/*  97 */       paramFloat7 = paramFloat8;
/*     */       
/*  99 */       paramFloat8 = f2;
/* 100 */       paramFloat4 = paramFloat4;
/*     */       
/* 102 */       paramFloat3 = paramFloat3;
/* 103 */       f2 = f3;
/*     */     } 
/*     */     
/* 106 */     paramFloat9 += paramFloat1;
/* 107 */     paramFloat5 += paramFloat2;
/* 108 */     paramFloat6 += paramFloat1;
/* 109 */     paramFloat7 += paramFloat2;
/* 110 */     paramFloat8 += paramFloat1;
/* 111 */     paramFloat4 += paramFloat2;
/* 112 */     paramFloat3 += paramFloat1;
/* 113 */     f2 += paramFloat2;
/*     */     
/* 115 */     f3 = paramTextureRegion.getU();
/* 116 */     float f4 = paramTextureRegion.getV2();
/* 117 */     paramFloat1 = paramTextureRegion.getU2();
/* 118 */     float f1 = paramTextureRegion.getV();
/*     */     
/* 120 */     paramFloat2 = Color.WHITE_FLOAT_BITS;
/* 121 */     paramArrayOffloat[0] = paramFloat9;
/* 122 */     paramArrayOffloat[1] = paramFloat5;
/* 123 */     paramArrayOffloat[2] = paramFloat2;
/* 124 */     paramArrayOffloat[3] = f3;
/* 125 */     paramArrayOffloat[4] = f4;
/*     */     
/* 127 */     paramArrayOffloat[5] = paramFloat6;
/* 128 */     paramArrayOffloat[6] = paramFloat7;
/* 129 */     paramArrayOffloat[7] = paramFloat2;
/* 130 */     paramArrayOffloat[8] = f3;
/* 131 */     paramArrayOffloat[9] = f1;
/*     */     
/* 133 */     paramArrayOffloat[10] = paramFloat8;
/* 134 */     paramArrayOffloat[11] = paramFloat4;
/* 135 */     paramArrayOffloat[12] = paramFloat2;
/* 136 */     paramArrayOffloat[13] = paramFloat1;
/* 137 */     paramArrayOffloat[14] = f1;
/*     */     
/* 139 */     paramArrayOffloat[15] = paramFloat3;
/* 140 */     paramArrayOffloat[16] = f2;
/* 141 */     paramArrayOffloat[17] = paramFloat2;
/* 142 */     paramArrayOffloat[18] = paramFloat1;
/* 143 */     paramArrayOffloat[19] = f4;
/*     */   }
/*     */   
/* 146 */   private static final Bezier<Vector2> e = new Bezier((Vector[])new Vector2[] { new Vector2(), new Vector2() });
/* 147 */   private static final Color f = new Color();
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
/*     */   public static void prepareBezierCurve(float[] paramArrayOffloat, Vector2[] paramArrayOfVector2, int paramInt, Color paramColor1, Color paramColor2) {
/* 159 */     Preconditions.checkArgument((paramArrayOffloat.length == (paramInt + 1) * 3), "Array length must be equal %s, array of %s given", (paramInt + 1) * 3, paramArrayOffloat.length);
/* 160 */     e.set((Vector[])paramArrayOfVector2);
/* 161 */     for (byte b = 0; b <= paramInt; b++) {
/* 162 */       float f = b / paramInt;
/* 163 */       f.set(paramColor1).lerp(paramColor2, f);
/* 164 */       e.valueAt((Vector)d, f);
/* 165 */       paramArrayOffloat[b * 3] = d.x;
/* 166 */       paramArrayOffloat[b * 3 + 1] = d.y;
/* 167 */       paramArrayOffloat[b * 3 + 2] = f.toFloatBits();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTexturedMultiLineVertices(float[] paramArrayOffloat1, float paramFloat, TextureRegion paramTextureRegion, float[] paramArrayOffloat2, int paramInt1, int paramInt2) {
/*     */     int i;
/* 178 */     if ((i = paramInt2 / 3) < 2) throw new IllegalArgumentException("data array must contain at least 2 points (6 floats), " + paramInt2 + " given"); 
/* 179 */     Preconditions.checkArgument((paramArrayOffloat1.length >= 20 * (i - 1)), "Out array should be of size " + (20 * (i - 1)) + " or larger, " + paramArrayOffloat1.length + " given");
/*     */     
/* 181 */     paramInt2 = 0;
/* 182 */     for (byte b = 1; b < i; b++) {
/* 183 */       int j = b - 1;
/*     */       
/* 185 */       float f2 = paramArrayOffloat2[j * 3 + paramInt1];
/* 186 */       float f3 = paramArrayOffloat2[j * 3 + 1 + paramInt1];
/* 187 */       float f4 = paramArrayOffloat2[b * 3 + paramInt1];
/* 188 */       float f5 = paramArrayOffloat2[b * 3 + 1 + paramInt1];
/* 189 */       float f1 = paramArrayOffloat2[j * 3 + 2 + paramInt1];
/* 190 */       float f6 = paramArrayOffloat2[b * 3 + 2 + paramInt1];
/* 191 */       float f7 = d.set(f4 - f2, f5 - f3).angleRad() - 1.5707964F;
/*     */       
/*     */       float[] arrayOfFloat;
/* 194 */       System.arraycopy(arrayOfFloat = getTexturedLineVertices(paramTextureRegion, f2, f3, f4, f5, paramFloat, paramFloat, f7, f7, f1, f6), 0, paramArrayOffloat1, paramInt2, 20);
/* 195 */       paramInt2 += 20;
/*     */     } 
/*     */     
/* 198 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float[] getTexturedLineVertices(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/* 206 */     float f2 = paramTextureRegion.getU();
/* 207 */     float f3 = paramTextureRegion.getU2();
/* 208 */     float f4 = paramTextureRegion.getV();
/* 209 */     float f1 = paramTextureRegion.getV2();
/*     */ 
/*     */     
/* 212 */     paramFloat5 *= 0.5F;
/* 213 */     paramFloat6 *= 0.5F;
/*     */     
/* 215 */     b[0] = paramFloat1 + -PMath.sin(paramFloat7 - 1.5707964F) * paramFloat5;
/* 216 */     b[1] = paramFloat2 + PMath.cos(paramFloat7 - 1.5707964F) * paramFloat5;
/* 217 */     b[2] = paramFloat9;
/* 218 */     b[3] = f3;
/* 219 */     b[4] = f1;
/*     */     
/* 221 */     b[5] = paramFloat1 + -PMath.sin(paramFloat7 + 1.5707964F) * paramFloat5;
/* 222 */     b[6] = paramFloat2 + PMath.cos(paramFloat7 + 1.5707964F) * paramFloat5;
/* 223 */     b[7] = paramFloat9;
/* 224 */     b[8] = f2;
/* 225 */     b[9] = f1;
/*     */     
/* 227 */     b[10] = paramFloat3 + -PMath.sin(paramFloat8 + 1.5707964F) * paramFloat6;
/* 228 */     b[11] = paramFloat4 + PMath.cos(paramFloat8 + 1.5707964F) * paramFloat6;
/* 229 */     b[12] = paramFloat10;
/* 230 */     b[13] = f2;
/* 231 */     b[14] = f4;
/*     */     
/* 233 */     b[15] = paramFloat3 + -PMath.sin(paramFloat8 - 1.5707964F) * paramFloat6;
/* 234 */     b[16] = paramFloat4 + PMath.cos(paramFloat8 - 1.5707964F) * paramFloat6;
/* 235 */     b[17] = paramFloat10;
/* 236 */     b[18] = f3;
/* 237 */     b[19] = f4;
/*     */     
/* 239 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void texturedMultiLine(Batch paramBatch, float paramFloat, TextureRegion paramTextureRegion, float[] paramArrayOffloat) {
/*     */     int i;
/* 249 */     if ((i = paramArrayOffloat.length / 3) < 2) throw new IllegalArgumentException("data array must contain at least 2 points (6 floats), " + paramArrayOffloat.length + " given");
/*     */     
/* 251 */     for (byte b = 1; b < i; b++) {
/* 252 */       int j = b - 1;
/*     */       
/* 254 */       texturedLineC(paramBatch, paramTextureRegion, paramArrayOffloat[j * 3], paramArrayOffloat[j * 3 + 1], paramArrayOffloat[b * 3], paramArrayOffloat[b * 3 + 1], paramFloat, paramArrayOffloat[j * 3 + 2], paramArrayOffloat[b * 3 + 2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void texturedLineB(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 264 */     texturedLineC(paramBatch, paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, a, a);
/*     */   }
/*     */   
/*     */   public static void texturedLineC(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 268 */     float f = d.set(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2).angleRad() - 1.5707964F;
/* 269 */     texturedLineF(paramBatch, paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat5, f, f, paramFloat6, paramFloat7);
/*     */   }
/*     */   
/*     */   public static void texturedLineF(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/* 273 */     float f1 = paramTextureRegion.getU();
/* 274 */     float f2 = paramTextureRegion.getU2();
/* 275 */     float f3 = paramTextureRegion.getV();
/* 276 */     float f4 = paramTextureRegion.getV2();
/*     */ 
/*     */     
/* 279 */     paramFloat5 /= 2.0F;
/* 280 */     paramFloat6 /= 2.0F;
/*     */     
/* 282 */     b[0] = paramFloat1 + -PMath.sin(paramFloat7 - 1.5707964F) * paramFloat5;
/* 283 */     b[1] = paramFloat2 + PMath.cos(paramFloat7 - 1.5707964F) * paramFloat5;
/* 284 */     b[2] = paramFloat9;
/* 285 */     b[3] = f2;
/* 286 */     b[4] = f4;
/*     */     
/* 288 */     b[5] = paramFloat1 + -PMath.sin(paramFloat7 + 1.5707964F) * paramFloat5;
/* 289 */     b[6] = paramFloat2 + PMath.cos(paramFloat7 + 1.5707964F) * paramFloat5;
/* 290 */     b[7] = paramFloat9;
/* 291 */     b[8] = f1;
/* 292 */     b[9] = f4;
/*     */     
/* 294 */     b[10] = paramFloat3 + -PMath.sin(paramFloat8 + 1.5707964F) * paramFloat6;
/* 295 */     b[11] = paramFloat4 + PMath.cos(paramFloat8 + 1.5707964F) * paramFloat6;
/* 296 */     b[12] = paramFloat10;
/* 297 */     b[13] = f1;
/* 298 */     b[14] = f3;
/*     */     
/* 300 */     b[15] = paramFloat3 + -PMath.sin(paramFloat8 - 1.5707964F) * paramFloat6;
/* 301 */     b[16] = paramFloat4 + PMath.cos(paramFloat8 - 1.5707964F) * paramFloat6;
/* 302 */     b[17] = paramFloat10;
/* 303 */     b[18] = f2;
/* 304 */     b[19] = f3;
/*     */     
/* 306 */     paramBatch.draw(paramTextureRegion.getTexture(), b, 0, 20);
/*     */   }
/*     */   
/*     */   public static void texturedLineCacheA(SpriteCache paramSpriteCache, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 310 */     float f = d.set(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2).angleRad() - 1.5707964F;
/* 311 */     texturedLineCacheB(paramSpriteCache, paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat5, f, f, paramFloat6, paramFloat7);
/*     */   }
/*     */   
/*     */   public static void texturedLineCacheB(SpriteCache paramSpriteCache, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/* 315 */     float f1 = paramTextureRegion.getU();
/* 316 */     float f2 = paramTextureRegion.getU2();
/* 317 */     float f3 = paramTextureRegion.getV();
/* 318 */     float f4 = paramTextureRegion.getV2();
/*     */ 
/*     */     
/* 321 */     paramFloat5 /= 2.0F;
/* 322 */     paramFloat6 /= 2.0F;
/*     */     
/* 324 */     b[0] = paramFloat1 + -PMath.sin(paramFloat7 - 1.5707964F) * paramFloat5;
/* 325 */     b[1] = paramFloat2 + PMath.cos(paramFloat7 - 1.5707964F) * paramFloat5;
/* 326 */     b[2] = paramFloat9;
/* 327 */     b[3] = f2;
/* 328 */     b[4] = f4;
/*     */     
/* 330 */     b[5] = paramFloat1 + -PMath.sin(paramFloat7 + 1.5707964F) * paramFloat5;
/* 331 */     b[6] = paramFloat2 + PMath.cos(paramFloat7 + 1.5707964F) * paramFloat5;
/* 332 */     b[7] = paramFloat9;
/* 333 */     b[8] = f1;
/* 334 */     b[9] = f4;
/*     */     
/* 336 */     b[10] = paramFloat3 + -PMath.sin(paramFloat8 + 1.5707964F) * paramFloat6;
/* 337 */     b[11] = paramFloat4 + PMath.cos(paramFloat8 + 1.5707964F) * paramFloat6;
/* 338 */     b[12] = paramFloat10;
/* 339 */     b[13] = f1;
/* 340 */     b[14] = f3;
/*     */     
/* 342 */     b[15] = paramFloat3 + -PMath.sin(paramFloat8 - 1.5707964F) * paramFloat6;
/* 343 */     b[16] = paramFloat4 + PMath.cos(paramFloat8 - 1.5707964F) * paramFloat6;
/* 344 */     b[17] = paramFloat10;
/* 345 */     b[18] = f2;
/* 346 */     b[19] = f3;
/*     */     
/* 348 */     paramSpriteCache.add(paramTextureRegion.getTexture(), b, 0, 20);
/*     */   }
/*     */   
/*     */   public static void texturedLineE(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Color paramColor1, Color paramColor2) {
/* 352 */     float f1 = paramColor1.toFloatBits();
/* 353 */     float f2 = paramColor2.toFloatBits();
/*     */     
/* 355 */     texturedLineF(paramBatch, paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, f1, f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void texturedLineA(Batch paramBatch, Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14) {
/* 363 */     paramFloat9 /= 2.0F;
/* 364 */     paramFloat10 /= 2.0F;
/*     */ 
/*     */     
/* 367 */     b[0] = paramFloat5 + -PMath.sin(paramFloat11 - 1.5707964F) * paramFloat9;
/* 368 */     b[1] = paramFloat6 + PMath.cos(paramFloat11 - 1.5707964F) * paramFloat9;
/* 369 */     b[2] = paramFloat13;
/* 370 */     b[3] = paramFloat3;
/* 371 */     b[4] = paramFloat4;
/*     */     
/* 373 */     b[15] = paramFloat7 + -PMath.sin(paramFloat12 - 1.5707964F) * paramFloat10;
/* 374 */     b[16] = paramFloat8 + PMath.cos(paramFloat12 - 1.5707964F) * paramFloat10;
/* 375 */     b[17] = paramFloat14;
/* 376 */     b[18] = paramFloat3;
/* 377 */     b[19] = paramFloat2;
/*     */ 
/*     */     
/* 380 */     b[5] = paramFloat5 + -PMath.sin(paramFloat11 + 1.5707964F) * paramFloat9;
/* 381 */     b[6] = paramFloat6 + PMath.cos(paramFloat11 + 1.5707964F) * paramFloat9;
/* 382 */     b[7] = paramFloat13;
/* 383 */     b[8] = paramFloat1;
/* 384 */     b[9] = paramFloat4;
/*     */     
/* 386 */     b[10] = paramFloat7 + -PMath.sin(paramFloat12 + 1.5707964F) * paramFloat10;
/* 387 */     b[11] = paramFloat8 + PMath.cos(paramFloat12 + 1.5707964F) * paramFloat10;
/* 388 */     b[12] = paramFloat14;
/* 389 */     b[13] = paramFloat1;
/* 390 */     b[14] = paramFloat2;
/*     */     
/* 392 */     paramBatch.draw(paramTexture, b, 0, 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void texturedLineD(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2) {
/* 397 */     float f = MathUtils.atan2(paramFloat4 - paramFloat2, paramFloat3 - paramFloat1) - 1.5707964F;
/* 398 */     texturedLineE(paramBatch, paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, f, f, paramColor1, paramColor2);
/*     */   }
/*     */   
/*     */   public static void drawFontToCache(SpriteCache paramSpriteCache, CharSequence paramCharSequence, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean) {
/* 402 */     drawFontToCacheScaled(paramSpriteCache, paramCharSequence, paramBitmapFont, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramBoolean, 1.0F);
/*     */   }
/*     */   
/*     */   public static void drawFontToCacheScaled(SpriteCache paramSpriteCache, CharSequence paramCharSequence, BitmapFont paramBitmapFont, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean, float paramFloat5) {
/*     */     BitmapFontCache bitmapFontCache;
/* 407 */     (bitmapFontCache = paramBitmapFont.getCache()).clear();
/* 408 */     bitmapFontCache.addText(paramCharSequence, paramFloat2, paramFloat3, paramFloat4, paramInt, paramBoolean);
/*     */     
/* 410 */     Array array = paramBitmapFont.getRegions(); int i; byte b;
/* 411 */     for (b = 0, i = (paramBitmapFont.getRegions()).size; b < i; b++) {
/* 412 */       if (bitmapFontCache.getVertexCount(b) > 0) {
/* 413 */         float[] arrayOfFloat = bitmapFontCache.getVertices(b);
/*     */         
/*     */         int j;
/*     */         
/* 417 */         a((int)((j = bitmapFontCache.getVertexCount(b)) * 1.51F));
/* 418 */         byte b1 = 0; byte b2;
/* 419 */         for (b2 = 0; b2 < j; b2 += 20) {
/* 420 */           float f1 = arrayOfFloat[b2];
/* 421 */           float f2 = arrayOfFloat[b2 + 1];
/* 422 */           float f3 = arrayOfFloat[b2 + 10];
/* 423 */           float f4 = arrayOfFloat[b2 + 6];
/* 424 */           float f5 = arrayOfFloat[b2 + 3];
/* 425 */           float f6 = arrayOfFloat[b2 + 4];
/* 426 */           float f7 = arrayOfFloat[b2 + 13];
/* 427 */           float f8 = arrayOfFloat[b2 + 14];
/*     */           
/* 429 */           System.arraycopy(arrayOfFloat, b2, c, b1, 15);
/* 430 */           b1 += true;
/*     */           
/* 432 */           c[b1++] = f3;
/* 433 */           c[b1++] = f4;
/*     */           
/* 435 */           b1++;
/* 436 */           c[b1++] = f7;
/* 437 */           c[b1++] = f8;
/*     */           
/* 439 */           c[b1++] = f3;
/* 440 */           c[b1++] = f2;
/*     */           
/* 442 */           b1++;
/* 443 */           c[b1++] = f7;
/* 444 */           c[b1++] = f6;
/*     */           
/* 446 */           c[b1++] = f1;
/* 447 */           c[b1++] = f2;
/*     */           
/* 449 */           b1++;
/* 450 */           c[b1++] = f5;
/* 451 */           c[b1++] = f6;
/*     */         } 
/*     */ 
/*     */         
/* 455 */         for (b2 = 2; b2 < b1; b2 += 5) {
/* 456 */           c[b2] = paramFloat1;
/*     */         }
/*     */ 
/*     */         
/* 460 */         if (paramFloat5 != 1.0F) {
/* 461 */           for (b2 = 0; b2 < b1; b2 += 5) {
/* 462 */             c[b2] = paramFloat2 + (c[b2] - paramFloat2) * paramFloat5;
/* 463 */             c[b2 + 1] = paramFloat3 + (c[b2 + 1] - paramFloat3) * paramFloat5;
/*     */           } 
/*     */         }
/*     */         
/* 467 */         paramSpriteCache.add(((TextureRegion)array.get(b)).getTexture(), c, 0, b1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Mesh mergeMeshes(Array<Mesh> paramArray, Array<Matrix4> paramArray1) {
/* 473 */     if (paramArray.size == 0) return null;
/*     */     
/* 475 */     int i = 0;
/* 476 */     int j = 0;
/*     */     
/*     */     VertexAttributes vertexAttributes;
/* 479 */     int[] arrayOfInt = new int[(vertexAttributes = ((Mesh)paramArray.get(0)).getVertexAttributes()).size()]; byte b1;
/* 480 */     for (b1 = 0; b1 < vertexAttributes.size(); b1++) {
/* 481 */       arrayOfInt[b1] = (vertexAttributes.get(b1)).usage;
/*     */     }
/*     */     
/* 484 */     for (b1 = 0; b1 < paramArray.size; b1++) {
/*     */       Mesh mesh1;
/* 486 */       if ((mesh1 = (Mesh)paramArray.get(b1)).getVertexAttributes().size() != vertexAttributes.size()) {
/* 487 */         paramArray.set(b1, copyMesh(mesh1, true, false, arrayOfInt));
/*     */       }
/*     */       
/* 490 */       i += mesh1.getNumVertices() * mesh1.getVertexSize() / 4;
/* 491 */       j += mesh1.getNumIndices();
/*     */     } 
/*     */     
/* 494 */     float[] arrayOfFloat = new float[i];
/* 495 */     short[] arrayOfShort = new short[j];
/*     */     
/* 497 */     i = 0;
/* 498 */     j = 0;
/* 499 */     int k = 0;
/*     */ 
/*     */     
/* 502 */     for (byte b2 = 0; b2 < paramArray.size; b2++) {
/*     */       Mesh mesh1;
/*     */       
/* 505 */       int n = (mesh1 = (Mesh)paramArray.get(b2)).getNumIndices();
/* 506 */       int i1 = mesh1.getNumVertices();
/* 507 */       int m = mesh1.getVertexSize() / 4;
/* 508 */       int i2 = i1 * m;
/*     */       VertexAttribute vertexAttribute;
/* 510 */       int i4 = (vertexAttribute = mesh1.getVertexAttribute(1)).offset / 4;
/* 511 */       int i3 = vertexAttribute.numComponents;
/*     */       
/* 513 */       mesh1.getIndices(arrayOfShort, i);
/* 514 */       for (int i5 = i; i5 < i + n; i5++) {
/* 515 */         arrayOfShort[i5] = (short)(arrayOfShort[i5] + j);
/*     */       }
/* 517 */       i += n;
/*     */       
/* 519 */       mesh1.getVertices(0, i2, arrayOfFloat, k);
/* 520 */       Mesh.transform((Matrix4)paramArray1.get(b2), arrayOfFloat, m, i4, i3, j, i1);
/* 521 */       j += i1;
/* 522 */       k += i2;
/*     */     } 
/*     */     
/*     */     Mesh mesh;
/* 526 */     (mesh = new Mesh(true, j, arrayOfShort.length, ((Mesh)paramArray.get(0)).getVertexAttributes())).setVertices(arrayOfFloat);
/* 527 */     mesh.setIndices(arrayOfShort);
/*     */     
/* 529 */     return mesh;
/*     */   }
/*     */   public static Mesh copyMesh(Mesh paramMesh, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfint) {
/*     */     Mesh mesh;
/* 533 */     int i = paramMesh.getVertexSize() / 4;
/*     */     int j;
/* 535 */     float[] arrayOfFloat = new float[(j = paramMesh.getNumVertices()) * i];
/* 536 */     paramMesh.getVertices(0, arrayOfFloat.length, arrayOfFloat);
/* 537 */     short[] arrayOfShort1 = null;
/* 538 */     VertexAttribute[] arrayOfVertexAttribute = null;
/* 539 */     int k = 0;
/* 540 */     if (paramArrayOfint != null) {
/* 541 */       int n = 0;
/* 542 */       byte b1 = 0; int arrayOfInt[], i1; byte b2;
/* 543 */       for (i1 = (arrayOfInt = paramArrayOfint).length, b2 = 0; b2 < i1; ) { int i2 = arrayOfInt[b2];
/* 544 */         if (paramMesh.getVertexAttribute(i2) != null) {
/* 545 */           n += (paramMesh.getVertexAttribute(i2)).numComponents;
/* 546 */           b1++;
/*     */         }  b2++; }
/*     */       
/* 549 */       if (n > 0) {
/* 550 */         arrayOfVertexAttribute = new VertexAttribute[b1];
/* 551 */         arrayOfShort1 = new short[n];
/* 552 */         byte b3 = -1;
/* 553 */         i1 = -1; byte b; int arrayOfInt1[], i2;
/* 554 */         for (i2 = (arrayOfInt1 = paramArrayOfint).length, b = 0; b < i2; ) { int i3 = arrayOfInt1[b];
/*     */           VertexAttribute vertexAttribute;
/* 556 */           if ((vertexAttribute = paramMesh.getVertexAttribute(i3)) != null) {
/*     */             
/* 558 */             for (byte b4 = 0; b4 < vertexAttribute.numComponents; b4++) {
/* 559 */               arrayOfShort1[++b3] = (short)(vertexAttribute.offset / 4 + b4);
/*     */             }
/*     */             
/* 562 */             arrayOfVertexAttribute[++i1] = new VertexAttribute(vertexAttribute.usage, vertexAttribute.numComponents, vertexAttribute.alias);
/* 563 */             k += vertexAttribute.numComponents;
/*     */           }  b++; }
/*     */       
/*     */       } 
/* 567 */     }  if (arrayOfShort1 == null) {
/* 568 */       arrayOfShort1 = new short[i]; short s;
/* 569 */       for (s = 0; s < i; s = (short)(s + 1)) {
/* 570 */         arrayOfShort1[s] = s;
/*     */       }
/* 572 */       k = i;
/*     */     } 
/*     */     
/* 575 */     int m = paramMesh.getNumIndices();
/* 576 */     short[] arrayOfShort2 = null;
/* 577 */     if (m > 0) {
/* 578 */       arrayOfShort2 = new short[m];
/* 579 */       paramMesh.getIndices(arrayOfShort2);
/* 580 */       if (paramBoolean2 || k != i) {
/* 581 */         float[] arrayOfFloat1 = new float[arrayOfFloat.length];
/* 582 */         byte b1 = 0;
/* 583 */         for (byte b2 = 0; b2 < m; b2++) {
/* 584 */           int n = arrayOfShort2[b2] * i;
/* 585 */           short s = -1;
/* 586 */           if (paramBoolean2) {
/* 587 */             short s1; for (s1 = 0; s1 < b1 && s < 0; s1 = (short)(s1 + 1)) {
/* 588 */               int i1 = s1 * k;
/* 589 */               boolean bool = true;
/* 590 */               for (j = 0; j < arrayOfShort1.length && bool; j++) {
/* 591 */                 if (arrayOfFloat1[i1 + j] != arrayOfFloat[n + arrayOfShort1[j]]) {
/* 592 */                   bool = false;
/*     */                 }
/*     */               } 
/* 595 */               if (bool) {
/* 596 */                 s = s1;
/*     */               }
/*     */             } 
/*     */           } 
/* 600 */           if (s > 0) {
/* 601 */             arrayOfShort2[b2] = s;
/*     */           } else {
/* 603 */             int i1 = b1 * k;
/* 604 */             for (byte b = 0; b < arrayOfShort1.length; b++) {
/* 605 */               arrayOfFloat1[i1 + b] = arrayOfFloat[n + arrayOfShort1[b]];
/*     */             }
/* 607 */             arrayOfShort2[b2] = (short)b1;
/* 608 */             b1++;
/*     */           } 
/*     */         } 
/* 611 */         arrayOfFloat = arrayOfFloat1;
/* 612 */         j = b1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 617 */     if (arrayOfVertexAttribute == null) {
/* 618 */       mesh = new Mesh(paramBoolean1, j, (arrayOfShort2 == null) ? 0 : arrayOfShort2.length, paramMesh.getVertexAttributes());
/*     */     } else {
/* 620 */       mesh = new Mesh(paramBoolean1, j, (arrayOfShort2 == null) ? 0 : arrayOfShort2.length, arrayOfVertexAttribute);
/*     */     } 
/* 622 */     mesh.setVertices(arrayOfFloat, 0, j * k);
/*     */     
/* 624 */     if (arrayOfShort2 != null) mesh.setIndices(arrayOfShort2);
/*     */     
/* 626 */     return mesh;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\DrawUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */