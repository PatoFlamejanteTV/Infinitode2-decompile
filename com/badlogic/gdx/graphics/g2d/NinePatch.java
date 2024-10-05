/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ public class NinePatch
/*     */ {
/*     */   public static final int TOP_LEFT = 0;
/*     */   public static final int TOP_CENTER = 1;
/*     */   public static final int TOP_RIGHT = 2;
/*     */   public static final int MIDDLE_LEFT = 3;
/*     */   public static final int MIDDLE_CENTER = 4;
/*     */   public static final int MIDDLE_RIGHT = 5;
/*     */   public static final int BOTTOM_LEFT = 6;
/*     */   public static final int BOTTOM_CENTER = 7;
/*     */   public static final int BOTTOM_RIGHT = 8;
/*  45 */   private static final Color tmpDrawColor = new Color(); private Texture texture; private int bottomLeft;
/*     */   private int bottomCenter;
/*     */   private int bottomRight;
/*     */   private int middleLeft;
/*     */   private int middleCenter;
/*     */   private int middleRight;
/*     */   private int topLeft;
/*  52 */   private float[] vertices = new float[180]; private int topCenter; private int topRight; private float leftWidth; private float rightWidth; private float middleWidth; private float middleHeight; private float topHeight; private float bottomHeight;
/*     */   private int idx;
/*  54 */   private final Color color = new Color(Color.WHITE);
/*  55 */   private float padLeft = -1.0F, padRight = -1.0F, padTop = -1.0F, padBottom = -1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NinePatch(Texture paramTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  64 */     this(new TextureRegion(paramTexture), paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NinePatch(TextureRegion paramTextureRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  74 */     if (paramTextureRegion == null) throw new IllegalArgumentException("region cannot be null."); 
/*  75 */     int i = paramTextureRegion.getRegionWidth() - paramInt1 - paramInt2;
/*  76 */     int j = paramTextureRegion.getRegionHeight() - paramInt3 - paramInt4;
/*     */     
/*  78 */     TextureRegion[] arrayOfTextureRegion = new TextureRegion[9];
/*  79 */     if (paramInt3 > 0) {
/*  80 */       if (paramInt1 > 0) arrayOfTextureRegion[0] = new TextureRegion(paramTextureRegion, 0, 0, paramInt1, paramInt3); 
/*  81 */       if (i > 0) arrayOfTextureRegion[1] = new TextureRegion(paramTextureRegion, paramInt1, 0, i, paramInt3); 
/*  82 */       if (paramInt2 > 0) arrayOfTextureRegion[2] = new TextureRegion(paramTextureRegion, paramInt1 + i, 0, paramInt2, paramInt3); 
/*     */     } 
/*  84 */     if (j > 0) {
/*  85 */       if (paramInt1 > 0) arrayOfTextureRegion[3] = new TextureRegion(paramTextureRegion, 0, paramInt3, paramInt1, j); 
/*  86 */       if (i > 0) arrayOfTextureRegion[4] = new TextureRegion(paramTextureRegion, paramInt1, paramInt3, i, j); 
/*  87 */       if (paramInt2 > 0) arrayOfTextureRegion[5] = new TextureRegion(paramTextureRegion, paramInt1 + i, paramInt3, paramInt2, j); 
/*     */     } 
/*  89 */     if (paramInt4 > 0) {
/*  90 */       if (paramInt1 > 0) arrayOfTextureRegion[6] = new TextureRegion(paramTextureRegion, 0, paramInt3 + j, paramInt1, paramInt4); 
/*  91 */       if (i > 0) arrayOfTextureRegion[7] = new TextureRegion(paramTextureRegion, paramInt1, paramInt3 + j, i, paramInt4); 
/*  92 */       if (paramInt2 > 0) arrayOfTextureRegion[8] = new TextureRegion(paramTextureRegion, paramInt1 + i, paramInt3 + j, paramInt2, paramInt4);
/*     */     
/*     */     } 
/*     */     
/*  96 */     if (paramInt1 == 0 && i == 0) {
/*  97 */       arrayOfTextureRegion[1] = arrayOfTextureRegion[2];
/*  98 */       arrayOfTextureRegion[4] = arrayOfTextureRegion[5];
/*  99 */       arrayOfTextureRegion[7] = arrayOfTextureRegion[8];
/* 100 */       arrayOfTextureRegion[2] = null;
/* 101 */       arrayOfTextureRegion[5] = null;
/* 102 */       arrayOfTextureRegion[8] = null;
/*     */     } 
/*     */     
/* 105 */     if (paramInt3 == 0 && j == 0) {
/* 106 */       arrayOfTextureRegion[3] = arrayOfTextureRegion[6];
/* 107 */       arrayOfTextureRegion[4] = arrayOfTextureRegion[7];
/* 108 */       arrayOfTextureRegion[5] = arrayOfTextureRegion[8];
/* 109 */       arrayOfTextureRegion[6] = null;
/* 110 */       arrayOfTextureRegion[7] = null;
/* 111 */       arrayOfTextureRegion[8] = null;
/*     */     } 
/*     */     
/* 114 */     load(arrayOfTextureRegion);
/*     */   }
/*     */ 
/*     */   
/*     */   public NinePatch(Texture paramTexture, Color paramColor) {
/* 119 */     this(paramTexture);
/* 120 */     setColor(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public NinePatch(Texture paramTexture) {
/* 125 */     this(new TextureRegion(paramTexture));
/*     */   }
/*     */ 
/*     */   
/*     */   public NinePatch(TextureRegion paramTextureRegion, Color paramColor) {
/* 130 */     this(paramTextureRegion);
/* 131 */     setColor(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public NinePatch(TextureRegion paramTextureRegion) {
/* 136 */     load(new TextureRegion[] { null, null, null, null, paramTextureRegion, null, null, null, null });
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
/*     */   public NinePatch(TextureRegion... paramVarArgs) {
/* 148 */     if (paramVarArgs == null || paramVarArgs.length != 9) throw new IllegalArgumentException("NinePatch needs nine TextureRegions");
/*     */     
/* 150 */     load(paramVarArgs);
/*     */     
/* 152 */     if ((paramVarArgs[0] != null && paramVarArgs[0].getRegionWidth() != this.leftWidth) || (paramVarArgs[3] != null && paramVarArgs[3]
/* 153 */       .getRegionWidth() != this.leftWidth) || (paramVarArgs[6] != null && paramVarArgs[6]
/* 154 */       .getRegionWidth() != this.leftWidth)) {
/* 155 */       throw new GdxRuntimeException("Left side patches must have the same width");
/*     */     }
/* 157 */     if ((paramVarArgs[2] != null && paramVarArgs[2].getRegionWidth() != this.rightWidth) || (paramVarArgs[5] != null && paramVarArgs[5]
/* 158 */       .getRegionWidth() != this.rightWidth) || (paramVarArgs[8] != null && paramVarArgs[8]
/* 159 */       .getRegionWidth() != this.rightWidth)) {
/* 160 */       throw new GdxRuntimeException("Right side patches must have the same width");
/*     */     }
/* 162 */     if ((paramVarArgs[6] != null && paramVarArgs[6].getRegionHeight() != this.bottomHeight) || (paramVarArgs[7] != null && paramVarArgs[7]
/* 163 */       .getRegionHeight() != this.bottomHeight) || (paramVarArgs[8] != null && paramVarArgs[8]
/* 164 */       .getRegionHeight() != this.bottomHeight)) {
/* 165 */       throw new GdxRuntimeException("Bottom side patches must have the same height");
/*     */     }
/* 167 */     if ((paramVarArgs[0] != null && paramVarArgs[0].getRegionHeight() != this.topHeight) || (paramVarArgs[1] != null && paramVarArgs[1]
/* 168 */       .getRegionHeight() != this.topHeight) || (paramVarArgs[2] != null && paramVarArgs[2]
/* 169 */       .getRegionHeight() != this.topHeight)) {
/* 170 */       throw new GdxRuntimeException("Top side patches must have the same height");
/*     */     }
/*     */   }
/*     */   
/*     */   public NinePatch(NinePatch paramNinePatch) {
/* 175 */     this(paramNinePatch, paramNinePatch.color);
/*     */   }
/*     */   
/*     */   public NinePatch(NinePatch paramNinePatch, Color paramColor) {
/* 179 */     this.texture = paramNinePatch.texture;
/*     */     
/* 181 */     this.bottomLeft = paramNinePatch.bottomLeft;
/* 182 */     this.bottomCenter = paramNinePatch.bottomCenter;
/* 183 */     this.bottomRight = paramNinePatch.bottomRight;
/* 184 */     this.middleLeft = paramNinePatch.middleLeft;
/* 185 */     this.middleCenter = paramNinePatch.middleCenter;
/* 186 */     this.middleRight = paramNinePatch.middleRight;
/* 187 */     this.topLeft = paramNinePatch.topLeft;
/* 188 */     this.topCenter = paramNinePatch.topCenter;
/* 189 */     this.topRight = paramNinePatch.topRight;
/*     */     
/* 191 */     this.leftWidth = paramNinePatch.leftWidth;
/* 192 */     this.rightWidth = paramNinePatch.rightWidth;
/* 193 */     this.middleWidth = paramNinePatch.middleWidth;
/* 194 */     this.middleHeight = paramNinePatch.middleHeight;
/* 195 */     this.topHeight = paramNinePatch.topHeight;
/* 196 */     this.bottomHeight = paramNinePatch.bottomHeight;
/*     */     
/* 198 */     this.padLeft = paramNinePatch.padLeft;
/* 199 */     this.padTop = paramNinePatch.padTop;
/* 200 */     this.padBottom = paramNinePatch.padBottom;
/* 201 */     this.padRight = paramNinePatch.padRight;
/*     */     
/* 203 */     this.vertices = new float[paramNinePatch.vertices.length];
/* 204 */     System.arraycopy(paramNinePatch.vertices, 0, this.vertices, 0, paramNinePatch.vertices.length);
/* 205 */     this.idx = paramNinePatch.idx;
/* 206 */     this.color.set(paramColor);
/*     */   }
/*     */   
/*     */   private void load(TextureRegion[] paramArrayOfTextureRegion) {
/* 210 */     if (paramArrayOfTextureRegion[6] != null) {
/* 211 */       this.bottomLeft = add(paramArrayOfTextureRegion[6], false, false);
/* 212 */       this.leftWidth = paramArrayOfTextureRegion[6].getRegionWidth();
/* 213 */       this.bottomHeight = paramArrayOfTextureRegion[6].getRegionHeight();
/*     */     } else {
/* 215 */       this.bottomLeft = -1;
/* 216 */     }  if (paramArrayOfTextureRegion[7] != null) {
/* 217 */       this.bottomCenter = add(paramArrayOfTextureRegion[7], (paramArrayOfTextureRegion[6] != null || paramArrayOfTextureRegion[8] != null), false);
/* 218 */       this.middleWidth = Math.max(this.middleWidth, paramArrayOfTextureRegion[7].getRegionWidth());
/* 219 */       this.bottomHeight = Math.max(this.bottomHeight, paramArrayOfTextureRegion[7].getRegionHeight());
/*     */     } else {
/* 221 */       this.bottomCenter = -1;
/* 222 */     }  if (paramArrayOfTextureRegion[8] != null) {
/* 223 */       this.bottomRight = add(paramArrayOfTextureRegion[8], false, false);
/* 224 */       this.rightWidth = Math.max(this.rightWidth, paramArrayOfTextureRegion[8].getRegionWidth());
/* 225 */       this.bottomHeight = Math.max(this.bottomHeight, paramArrayOfTextureRegion[8].getRegionHeight());
/*     */     } else {
/* 227 */       this.bottomRight = -1;
/* 228 */     }  if (paramArrayOfTextureRegion[3] != null) {
/* 229 */       this.middleLeft = add(paramArrayOfTextureRegion[3], false, (paramArrayOfTextureRegion[0] != null || paramArrayOfTextureRegion[6] != null));
/* 230 */       this.leftWidth = Math.max(this.leftWidth, paramArrayOfTextureRegion[3].getRegionWidth());
/* 231 */       this.middleHeight = Math.max(this.middleHeight, paramArrayOfTextureRegion[3].getRegionHeight());
/*     */     } else {
/* 233 */       this.middleLeft = -1;
/* 234 */     }  if (paramArrayOfTextureRegion[4] != null) {
/* 235 */       this.middleCenter = add(paramArrayOfTextureRegion[4], (paramArrayOfTextureRegion[3] != null || paramArrayOfTextureRegion[5] != null), (paramArrayOfTextureRegion[1] != null || paramArrayOfTextureRegion[7] != null));
/*     */       
/* 237 */       this.middleWidth = Math.max(this.middleWidth, paramArrayOfTextureRegion[4].getRegionWidth());
/* 238 */       this.middleHeight = Math.max(this.middleHeight, paramArrayOfTextureRegion[4].getRegionHeight());
/*     */     } else {
/* 240 */       this.middleCenter = -1;
/* 241 */     }  if (paramArrayOfTextureRegion[5] != null) {
/* 242 */       this.middleRight = add(paramArrayOfTextureRegion[5], false, (paramArrayOfTextureRegion[2] != null || paramArrayOfTextureRegion[8] != null));
/* 243 */       this.rightWidth = Math.max(this.rightWidth, paramArrayOfTextureRegion[5].getRegionWidth());
/* 244 */       this.middleHeight = Math.max(this.middleHeight, paramArrayOfTextureRegion[5].getRegionHeight());
/*     */     } else {
/* 246 */       this.middleRight = -1;
/* 247 */     }  if (paramArrayOfTextureRegion[0] != null) {
/* 248 */       this.topLeft = add(paramArrayOfTextureRegion[0], false, false);
/* 249 */       this.leftWidth = Math.max(this.leftWidth, paramArrayOfTextureRegion[0].getRegionWidth());
/* 250 */       this.topHeight = Math.max(this.topHeight, paramArrayOfTextureRegion[0].getRegionHeight());
/*     */     } else {
/* 252 */       this.topLeft = -1;
/* 253 */     }  if (paramArrayOfTextureRegion[1] != null) {
/* 254 */       this.topCenter = add(paramArrayOfTextureRegion[1], (paramArrayOfTextureRegion[0] != null || paramArrayOfTextureRegion[2] != null), false);
/* 255 */       this.middleWidth = Math.max(this.middleWidth, paramArrayOfTextureRegion[1].getRegionWidth());
/* 256 */       this.topHeight = Math.max(this.topHeight, paramArrayOfTextureRegion[1].getRegionHeight());
/*     */     } else {
/* 258 */       this.topCenter = -1;
/* 259 */     }  if (paramArrayOfTextureRegion[2] != null) {
/* 260 */       this.topRight = add(paramArrayOfTextureRegion[2], false, false);
/* 261 */       this.rightWidth = Math.max(this.rightWidth, paramArrayOfTextureRegion[2].getRegionWidth());
/* 262 */       this.topHeight = Math.max(this.topHeight, paramArrayOfTextureRegion[2].getRegionHeight());
/*     */     } else {
/* 264 */       this.topRight = -1;
/* 265 */     }  if (this.idx < this.vertices.length) {
/* 266 */       float[] arrayOfFloat = new float[this.idx];
/* 267 */       System.arraycopy(this.vertices, 0, arrayOfFloat, 0, this.idx);
/* 268 */       this.vertices = arrayOfFloat;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int add(TextureRegion paramTextureRegion, boolean paramBoolean1, boolean paramBoolean2) {
/* 273 */     if (this.texture == null) {
/* 274 */       this.texture = paramTextureRegion.getTexture();
/* 275 */     } else if (this.texture != paramTextureRegion.getTexture()) {
/* 276 */       throw new IllegalArgumentException("All regions must be from the same texture.");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 281 */     float f2 = paramTextureRegion.u, f3 = paramTextureRegion.v2, f4 = paramTextureRegion.u2, f1 = paramTextureRegion.v;
/* 282 */     if (this.texture.getMagFilter() == Texture.TextureFilter.Linear || this.texture.getMinFilter() == Texture.TextureFilter.Linear) {
/* 283 */       if (paramBoolean1) {
/* 284 */         float f = 0.5F / this.texture.getWidth();
/* 285 */         f2 += f;
/* 286 */         f4 -= f;
/*     */       } 
/* 288 */       if (paramBoolean2) {
/* 289 */         float f = 0.5F / this.texture.getHeight();
/* 290 */         f3 -= f;
/* 291 */         f1 += f;
/*     */       } 
/*     */     } 
/*     */     
/* 295 */     float[] arrayOfFloat = this.vertices;
/* 296 */     int i = this.idx;
/* 297 */     arrayOfFloat[i + 3] = f2;
/* 298 */     arrayOfFloat[i + 4] = f3;
/*     */     
/* 300 */     arrayOfFloat[i + 8] = f2;
/* 301 */     arrayOfFloat[i + 9] = f1;
/*     */     
/* 303 */     arrayOfFloat[i + 13] = f4;
/* 304 */     arrayOfFloat[i + 14] = f1;
/*     */     
/* 306 */     arrayOfFloat[i + 18] = f4;
/* 307 */     arrayOfFloat[i + 19] = f3;
/* 308 */     this.idx += 20;
/* 309 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 314 */     paramFloat3 = paramFloat1 + paramFloat3;
/* 315 */     paramFloat4 = paramFloat2 + paramFloat4;
/*     */     float[] arrayOfFloat;
/* 317 */     (arrayOfFloat = this.vertices)[paramInt] = paramFloat1;
/* 318 */     arrayOfFloat[paramInt + 1] = paramFloat2;
/* 319 */     arrayOfFloat[paramInt + 2] = paramFloat5;
/*     */     
/* 321 */     arrayOfFloat[paramInt + 5] = paramFloat1;
/* 322 */     arrayOfFloat[paramInt + 6] = paramFloat4;
/* 323 */     arrayOfFloat[paramInt + 7] = paramFloat5;
/*     */     
/* 325 */     arrayOfFloat[paramInt + 10] = paramFloat3;
/* 326 */     arrayOfFloat[paramInt + 11] = paramFloat4;
/* 327 */     arrayOfFloat[paramInt + 12] = paramFloat5;
/*     */     
/* 329 */     arrayOfFloat[paramInt + 15] = paramFloat3;
/* 330 */     arrayOfFloat[paramInt + 16] = paramFloat2;
/* 331 */     arrayOfFloat[paramInt + 17] = paramFloat5;
/*     */   }
/*     */   
/*     */   private void prepareVertices(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 335 */     float f2 = paramFloat1 + this.leftWidth;
/* 336 */     float f3 = paramFloat2 + this.bottomHeight;
/* 337 */     float f4 = paramFloat3 - this.rightWidth - this.leftWidth;
/* 338 */     float f5 = paramFloat4 - this.topHeight - this.bottomHeight;
/* 339 */     paramFloat3 = paramFloat1 + paramFloat3 - this.rightWidth;
/* 340 */     paramFloat4 = paramFloat2 + paramFloat4 - this.topHeight;
/* 341 */     float f1 = tmpDrawColor.set(this.color).mul(paramBatch.getColor()).toFloatBits();
/* 342 */     if (this.bottomLeft != -1) set(this.bottomLeft, paramFloat1, paramFloat2, this.leftWidth, this.bottomHeight, f1); 
/* 343 */     if (this.bottomCenter != -1) set(this.bottomCenter, f2, paramFloat2, f4, this.bottomHeight, f1); 
/* 344 */     if (this.bottomRight != -1) set(this.bottomRight, paramFloat3, paramFloat2, this.rightWidth, this.bottomHeight, f1); 
/* 345 */     if (this.middleLeft != -1) set(this.middleLeft, paramFloat1, f3, this.leftWidth, f5, f1); 
/* 346 */     if (this.middleCenter != -1) set(this.middleCenter, f2, f3, f4, f5, f1); 
/* 347 */     if (this.middleRight != -1) set(this.middleRight, paramFloat3, f3, this.rightWidth, f5, f1); 
/* 348 */     if (this.topLeft != -1) set(this.topLeft, paramFloat1, paramFloat4, this.leftWidth, this.topHeight, f1); 
/* 349 */     if (this.topCenter != -1) set(this.topCenter, f2, paramFloat4, f4, this.topHeight, f1); 
/* 350 */     if (this.topRight != -1) set(this.topRight, paramFloat3, paramFloat4, this.rightWidth, this.topHeight, f1); 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 354 */     prepareVertices(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 355 */     paramBatch.draw(this.texture, this.vertices, 0, this.idx);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 360 */     prepareVertices(paramBatch, paramFloat1, paramFloat2, paramFloat5, paramFloat6);
/* 361 */     paramFloat1 += paramFloat3; paramFloat2 += paramFloat4;
/* 362 */     int i = this.idx;
/* 363 */     float[] arrayOfFloat = this.vertices;
/* 364 */     if (paramFloat9 != 0.0F) {
/* 365 */       for (byte b = 0; b < i; b += 5) {
/* 366 */         paramFloat6 = (arrayOfFloat[b] - paramFloat1) * paramFloat7; float f1 = (arrayOfFloat[b + 1] - paramFloat2) * paramFloat8;
/* 367 */         float f2 = MathUtils.cosDeg(paramFloat9), f3 = MathUtils.sinDeg(paramFloat9);
/* 368 */         arrayOfFloat[b] = f2 * paramFloat6 - f3 * f1 + paramFloat1;
/* 369 */         arrayOfFloat[b + 1] = f3 * paramFloat6 + f2 * f1 + paramFloat2;
/*     */       } 
/* 371 */     } else if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/* 372 */       for (byte b = 0; b < i; b += 5) {
/* 373 */         arrayOfFloat[b] = (arrayOfFloat[b] - paramFloat1) * paramFloat7 + paramFloat1;
/* 374 */         arrayOfFloat[b + 1] = (arrayOfFloat[b + 1] - paramFloat2) * paramFloat8 + paramFloat2;
/*     */       } 
/*     */     } 
/* 377 */     paramBatch.draw(this.texture, arrayOfFloat, 0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 383 */     this.color.set(paramColor);
/*     */   }
/*     */   
/*     */   public Color getColor() {
/* 387 */     return this.color;
/*     */   }
/*     */   
/*     */   public float getLeftWidth() {
/* 391 */     return this.leftWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLeftWidth(float paramFloat) {
/* 396 */     this.leftWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getRightWidth() {
/* 400 */     return this.rightWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRightWidth(float paramFloat) {
/* 405 */     this.rightWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTopHeight() {
/* 409 */     return this.topHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTopHeight(float paramFloat) {
/* 414 */     this.topHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public float getBottomHeight() {
/* 418 */     return this.bottomHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBottomHeight(float paramFloat) {
/* 423 */     this.bottomHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMiddleWidth() {
/* 427 */     return this.middleWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMiddleWidth(float paramFloat) {
/* 434 */     this.middleWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMiddleHeight() {
/* 438 */     return this.middleHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMiddleHeight(float paramFloat) {
/* 445 */     this.middleHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTotalWidth() {
/* 449 */     return this.leftWidth + this.middleWidth + this.rightWidth;
/*     */   }
/*     */   
/*     */   public float getTotalHeight() {
/* 453 */     return this.topHeight + this.middleHeight + this.bottomHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 459 */     this.padLeft = paramFloat1;
/* 460 */     this.padRight = paramFloat2;
/* 461 */     this.padTop = paramFloat3;
/* 462 */     this.padBottom = paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadLeft() {
/* 467 */     if (this.padLeft == -1.0F) return getLeftWidth(); 
/* 468 */     return this.padLeft;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadLeft(float paramFloat) {
/* 473 */     this.padLeft = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadRight() {
/* 478 */     if (this.padRight == -1.0F) return getRightWidth(); 
/* 479 */     return this.padRight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadRight(float paramFloat) {
/* 484 */     this.padRight = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadTop() {
/* 489 */     if (this.padTop == -1.0F) return getTopHeight(); 
/* 490 */     return this.padTop;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadTop(float paramFloat) {
/* 495 */     this.padTop = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadBottom() {
/* 500 */     if (this.padBottom == -1.0F) return getBottomHeight(); 
/* 501 */     return this.padBottom;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadBottom(float paramFloat) {
/* 506 */     this.padBottom = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(float paramFloat1, float paramFloat2) {
/* 511 */     this.leftWidth *= paramFloat1;
/* 512 */     this.rightWidth *= paramFloat1;
/* 513 */     this.topHeight *= paramFloat2;
/* 514 */     this.bottomHeight *= paramFloat2;
/* 515 */     this.middleWidth *= paramFloat1;
/* 516 */     this.middleHeight *= paramFloat2;
/* 517 */     if (this.padLeft != -1.0F) this.padLeft *= paramFloat1; 
/* 518 */     if (this.padRight != -1.0F) this.padRight *= paramFloat1; 
/* 519 */     if (this.padTop != -1.0F) this.padTop *= paramFloat2; 
/* 520 */     if (this.padBottom != -1.0F) this.padBottom *= paramFloat2; 
/*     */   }
/*     */   
/*     */   public Texture getTexture() {
/* 524 */     return this.texture;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\NinePatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */