/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Affine2;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Matrix4;
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
/*     */ public class CpuSpriteBatch
/*     */   extends SpriteBatch
/*     */ {
/*  35 */   private final Matrix4 virtualMatrix = new Matrix4();
/*  36 */   private final Affine2 adjustAffine = new Affine2();
/*     */   
/*     */   private boolean adjustNeeded;
/*     */   private boolean haveIdentityRealMatrix = true;
/*  40 */   private final Affine2 tmpAffine = new Affine2();
/*     */ 
/*     */ 
/*     */   
/*     */   public CpuSpriteBatch() {
/*  45 */     this(1000);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CpuSpriteBatch(int paramInt) {
/*  51 */     this(paramInt, (ShaderProgram)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CpuSpriteBatch(int paramInt, ShaderProgram paramShaderProgram) {
/*  57 */     super(paramInt, paramShaderProgram);
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
/*     */   public void flushAndSyncTransformMatrix() {
/*  71 */     flush();
/*     */     
/*  73 */     if (this.adjustNeeded) {
/*     */       
/*  75 */       this.haveIdentityRealMatrix = checkIdt(this.virtualMatrix);
/*     */       
/*  77 */       if (!this.haveIdentityRealMatrix && this.virtualMatrix.det() == 0.0F) {
/*  78 */         throw new GdxRuntimeException("Transform matrix is singular, can't sync");
/*     */       }
/*  80 */       this.adjustNeeded = false;
/*  81 */       super.setTransformMatrix(this.virtualMatrix);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Matrix4 getTransformMatrix() {
/*  87 */     return this.adjustNeeded ? this.virtualMatrix : super.getTransformMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransformMatrix(Matrix4 paramMatrix4) {
/*     */     Matrix4 matrix4;
/*  98 */     if (checkEqual(matrix4 = super.getTransformMatrix(), paramMatrix4)) {
/*  99 */       this.adjustNeeded = false; return;
/*     */     } 
/* 101 */     if (isDrawing()) {
/* 102 */       this.virtualMatrix.setAsAffine(paramMatrix4);
/* 103 */       this.adjustNeeded = true;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       if (this.haveIdentityRealMatrix) {
/* 109 */         this.adjustAffine.set(paramMatrix4); return;
/*     */       } 
/* 111 */       this.tmpAffine.set(paramMatrix4);
/* 112 */       this.adjustAffine.set(matrix4).inv().mul(this.tmpAffine);
/*     */       return;
/*     */     } 
/* 115 */     matrix4.setAsAffine(paramMatrix4);
/* 116 */     this.haveIdentityRealMatrix = checkIdt(matrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransformMatrix(Affine2 paramAffine2) {
/*     */     Matrix4 matrix4;
/* 128 */     if (checkEqual(matrix4 = super.getTransformMatrix(), paramAffine2)) {
/* 129 */       this.adjustNeeded = false; return;
/*     */     } 
/* 131 */     this.virtualMatrix.setAsAffine(paramAffine2);
/*     */     
/* 133 */     if (isDrawing()) {
/* 134 */       this.adjustNeeded = true;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       if (this.haveIdentityRealMatrix) {
/* 140 */         this.adjustAffine.set(paramAffine2); return;
/*     */       } 
/* 142 */       this.adjustAffine.set(matrix4).inv().mul(paramAffine2);
/*     */       return;
/*     */     } 
/* 145 */     matrix4.setAsAffine(paramAffine2);
/* 146 */     this.haveIdentityRealMatrix = checkIdt(matrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/* 154 */     if (!this.adjustNeeded) {
/* 155 */       super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
/*     */       return;
/*     */     } 
/* 158 */     drawAdjusted(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/* 166 */     if (!this.adjustNeeded) {
/* 167 */       super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2); return;
/*     */     } 
/* 169 */     drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 175 */     if (!this.adjustNeeded) {
/* 176 */       super.draw(paramTexture, paramFloat1, paramFloat2, paramInt1, paramInt2, paramInt3, paramInt4); return;
/*     */     } 
/* 178 */     drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt3, paramInt4, 1.0F, 1.0F, 0.0F, paramInt1, paramInt2, paramInt3, paramInt4, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 184 */     if (!this.adjustNeeded) {
/* 185 */       super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8); return;
/*     */     } 
/* 187 */     drawAdjustedUV(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F, paramFloat5, paramFloat6, paramFloat7, paramFloat8, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2) {
/* 193 */     if (!this.adjustNeeded) {
/* 194 */       super.draw(paramTexture, paramFloat1, paramFloat2); return;
/*     */     } 
/* 196 */     drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTexture.getWidth(), paramTexture.getHeight(), 1.0F, 1.0F, 0.0F, 0, 1, 1, 0, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 202 */     if (!this.adjustNeeded) {
/* 203 */       super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4); return;
/*     */     } 
/* 205 */     drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F, 0, 1, 1, 0, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/* 211 */     if (!this.adjustNeeded) {
/* 212 */       super.draw(paramTextureRegion, paramFloat1, paramFloat2); return;
/*     */     } 
/* 214 */     drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight(), 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 220 */     if (!this.adjustNeeded) {
/* 221 */       super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4); return;
/*     */     } 
/* 223 */     drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 230 */     if (!this.adjustNeeded) {
/* 231 */       super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9); return;
/*     */     } 
/* 233 */     drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/* 240 */     if (!this.adjustNeeded) {
/* 241 */       super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramBoolean); return;
/*     */     } 
/* 243 */     drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 249 */     if (paramInt2 % 20 != 0) throw new GdxRuntimeException("invalid vertex count");
/*     */     
/* 251 */     if (!this.adjustNeeded) {
/* 252 */       super.draw(paramTexture, paramArrayOffloat, paramInt1, paramInt2); return;
/*     */     } 
/* 254 */     drawAdjusted(paramTexture, paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/* 260 */     if (!this.adjustNeeded) {
/* 261 */       super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramAffine2); return;
/*     */     } 
/* 263 */     drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramAffine2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 270 */     drawAdjustedUV(paramTextureRegion.texture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramTextureRegion.u, paramTextureRegion.v2, paramTextureRegion.u2, paramTextureRegion.v, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawAdjusted(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/* 276 */     float f4 = 1.0F / paramTexture.getWidth();
/* 277 */     float f5 = 1.0F / paramTexture.getHeight();
/*     */     
/* 279 */     float f6 = paramInt1 * f4;
/* 280 */     float f3 = (paramInt2 + paramInt4) * f5;
/* 281 */     float f1 = (paramInt1 + paramInt3) * f4;
/* 282 */     float f2 = paramInt2 * f5;
/*     */     
/* 284 */     drawAdjustedUV(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, f6, f3, f1, f2, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawAdjustedUV(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, boolean paramBoolean1, boolean paramBoolean2) {
/* 289 */     if (!this.drawing) throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
/*     */     
/* 291 */     if (paramTexture != this.lastTexture)
/* 292 */     { switchTexture(paramTexture); }
/* 293 */     else if (this.idx == this.vertices.length) { flush(); }
/*     */ 
/*     */     
/* 296 */     float f1 = paramFloat1 + paramFloat3;
/* 297 */     paramFloat1 = paramFloat2 + paramFloat4;
/* 298 */     paramFloat2 = -paramFloat3;
/* 299 */     float f2 = -paramFloat4;
/* 300 */     paramFloat3 = paramFloat5 - paramFloat3;
/* 301 */     paramFloat4 = paramFloat6 - paramFloat4;
/*     */ 
/*     */     
/* 304 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/* 305 */       paramFloat2 *= paramFloat7;
/* 306 */       f2 *= paramFloat8;
/* 307 */       paramFloat3 *= paramFloat7;
/* 308 */       paramFloat4 *= paramFloat8;
/*     */     } 
/*     */ 
/*     */     
/* 312 */     paramFloat5 = paramFloat2;
/* 313 */     paramFloat6 = f2;
/* 314 */     paramFloat2 = paramFloat2;
/* 315 */     paramFloat7 = paramFloat4;
/* 316 */     paramFloat8 = paramFloat3;
/* 317 */     paramFloat4 = paramFloat4;
/* 318 */     paramFloat3 = paramFloat3;
/* 319 */     f2 = f2;
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
/* 331 */     if (paramFloat9 != 0.0F) {
/* 332 */       f2 = MathUtils.cosDeg(paramFloat9);
/* 333 */       paramFloat3 = MathUtils.sinDeg(paramFloat9);
/*     */       
/* 335 */       paramFloat9 = f2 * paramFloat5 - paramFloat3 * paramFloat6;
/* 336 */       paramFloat5 = paramFloat3 * paramFloat5 + f2 * paramFloat6;
/*     */       
/* 338 */       paramFloat6 = f2 * paramFloat2 - paramFloat3 * paramFloat7;
/* 339 */       paramFloat2 = paramFloat3 * paramFloat2 + f2 * paramFloat7;
/*     */       
/* 341 */       paramFloat7 = f2 * paramFloat8 - paramFloat3 * paramFloat4;
/* 342 */       paramFloat4 = paramFloat3 * paramFloat8 + f2 * paramFloat4;
/*     */       
/* 344 */       paramFloat3 = paramFloat9 + paramFloat7 - paramFloat6;
/* 345 */       paramFloat8 = paramFloat4 - paramFloat2 - paramFloat5;
/*     */     } else {
/* 347 */       paramFloat9 = paramFloat5;
/* 348 */       paramFloat5 = paramFloat6;
/*     */       
/* 350 */       paramFloat6 = paramFloat2;
/* 351 */       paramFloat2 = paramFloat7;
/*     */       
/* 353 */       paramFloat7 = paramFloat8;
/* 354 */       paramFloat4 = paramFloat4;
/*     */       
/* 356 */       paramFloat3 = paramFloat3;
/* 357 */       paramFloat8 = f2;
/*     */     } 
/*     */     
/* 360 */     paramFloat9 += f1;
/* 361 */     paramFloat5 += paramFloat1;
/* 362 */     paramFloat6 += f1;
/* 363 */     paramFloat2 += paramFloat1;
/* 364 */     paramFloat7 += f1;
/* 365 */     paramFloat4 += paramFloat1;
/* 366 */     paramFloat3 += f1;
/* 367 */     paramFloat8 += paramFloat1;
/*     */     
/* 369 */     if (paramBoolean1) {
/* 370 */       f2 = paramFloat10;
/* 371 */       paramFloat10 = paramFloat12;
/* 372 */       paramFloat12 = f2;
/*     */     } 
/* 374 */     if (paramBoolean2) {
/* 375 */       f2 = paramFloat11;
/* 376 */       paramFloat11 = paramFloat13;
/* 377 */       paramFloat13 = f2;
/*     */     } 
/*     */     
/* 380 */     Affine2 affine2 = this.adjustAffine;
/*     */     
/* 382 */     this.vertices[this.idx] = affine2.m00 * paramFloat9 + affine2.m01 * paramFloat5 + affine2.m02;
/* 383 */     this.vertices[this.idx + 1] = affine2.m10 * paramFloat9 + affine2.m11 * paramFloat5 + affine2.m12;
/* 384 */     this.vertices[this.idx + 2] = this.colorPacked;
/* 385 */     this.vertices[this.idx + 3] = paramFloat10;
/* 386 */     this.vertices[this.idx + 4] = paramFloat11;
/*     */     
/* 388 */     this.vertices[this.idx + 5] = affine2.m00 * paramFloat6 + affine2.m01 * paramFloat2 + affine2.m02;
/* 389 */     this.vertices[this.idx + 6] = affine2.m10 * paramFloat6 + affine2.m11 * paramFloat2 + affine2.m12;
/* 390 */     this.vertices[this.idx + 7] = this.colorPacked;
/* 391 */     this.vertices[this.idx + 8] = paramFloat10;
/* 392 */     this.vertices[this.idx + 9] = paramFloat13;
/*     */     
/* 394 */     this.vertices[this.idx + 10] = affine2.m00 * paramFloat7 + affine2.m01 * paramFloat4 + affine2.m02;
/* 395 */     this.vertices[this.idx + 11] = affine2.m10 * paramFloat7 + affine2.m11 * paramFloat4 + affine2.m12;
/* 396 */     this.vertices[this.idx + 12] = this.colorPacked;
/* 397 */     this.vertices[this.idx + 13] = paramFloat12;
/* 398 */     this.vertices[this.idx + 14] = paramFloat13;
/*     */     
/* 400 */     this.vertices[this.idx + 15] = affine2.m00 * paramFloat3 + affine2.m01 * paramFloat8 + affine2.m02;
/* 401 */     this.vertices[this.idx + 16] = affine2.m10 * paramFloat3 + affine2.m11 * paramFloat8 + affine2.m12;
/* 402 */     this.vertices[this.idx + 17] = this.colorPacked;
/* 403 */     this.vertices[this.idx + 18] = paramFloat12;
/* 404 */     this.vertices[this.idx + 19] = paramFloat11;
/*     */     
/* 406 */     this.idx += 20;
/*     */   }
/*     */   
/*     */   private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/*     */     float f1, f2, f5, f6, f7;
/* 411 */     if (!this.drawing) throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
/*     */     
/* 413 */     if (paramTextureRegion.texture != this.lastTexture)
/* 414 */     { switchTexture(paramTextureRegion.texture); }
/* 415 */     else if (this.idx == this.vertices.length) { flush(); }
/*     */ 
/*     */     
/* 418 */     paramFloat1 += paramFloat3;
/* 419 */     paramFloat2 += paramFloat4;
/* 420 */     float f3 = -paramFloat3;
/* 421 */     float f4 = -paramFloat4;
/* 422 */     paramFloat3 = paramFloat5 - paramFloat3;
/* 423 */     paramFloat4 = paramFloat6 - paramFloat4;
/*     */ 
/*     */     
/* 426 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/* 427 */       f3 *= paramFloat7;
/* 428 */       f4 *= paramFloat8;
/* 429 */       paramFloat3 *= paramFloat7;
/* 430 */       paramFloat4 *= paramFloat8;
/*     */     } 
/*     */ 
/*     */     
/* 434 */     paramFloat5 = f3;
/* 435 */     paramFloat6 = f4;
/* 436 */     paramFloat7 = f3;
/* 437 */     paramFloat8 = paramFloat4;
/* 438 */     f3 = paramFloat3;
/* 439 */     paramFloat4 = paramFloat4;
/* 440 */     paramFloat3 = paramFloat3;
/* 441 */     f4 = f4;
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
/* 453 */     if (paramFloat9 != 0.0F) {
/* 454 */       f4 = MathUtils.cosDeg(paramFloat9);
/* 455 */       f5 = MathUtils.sinDeg(paramFloat9);
/*     */       
/* 457 */       paramFloat9 = f4 * paramFloat5 - f5 * paramFloat6;
/* 458 */       paramFloat5 = f5 * paramFloat5 + f4 * paramFloat6;
/*     */       
/* 460 */       paramFloat6 = f4 * paramFloat7 - f5 * paramFloat8;
/* 461 */       paramFloat7 = f5 * paramFloat7 + f4 * paramFloat8;
/*     */       
/* 463 */       paramFloat8 = f4 * f3 - f5 * paramFloat4;
/* 464 */       paramFloat4 = f5 * f3 + f4 * paramFloat4;
/*     */       
/* 466 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/* 467 */       f3 = paramFloat4 - paramFloat7 - paramFloat5;
/*     */     } else {
/* 469 */       paramFloat9 = paramFloat5;
/* 470 */       paramFloat5 = paramFloat6;
/*     */       
/* 472 */       paramFloat6 = paramFloat7;
/* 473 */       paramFloat7 = paramFloat8;
/*     */       
/* 475 */       paramFloat8 = f3;
/* 476 */       paramFloat4 = paramFloat4;
/*     */       
/* 478 */       paramFloat3 = paramFloat3;
/* 479 */       f3 = f4;
/*     */     } 
/*     */     
/* 482 */     paramFloat9 += paramFloat1;
/* 483 */     paramFloat5 += paramFloat2;
/* 484 */     paramFloat6 += paramFloat1;
/* 485 */     paramFloat7 += paramFloat2;
/* 486 */     paramFloat8 += paramFloat1;
/* 487 */     paramFloat4 += paramFloat2;
/* 488 */     paramFloat3 += paramFloat1;
/* 489 */     f3 += paramFloat2;
/*     */ 
/*     */     
/* 492 */     if (paramBoolean) {
/* 493 */       f4 = paramTextureRegion.u2;
/* 494 */       f5 = paramTextureRegion.v2;
/* 495 */       paramFloat1 = paramTextureRegion.u;
/* 496 */       paramFloat2 = paramTextureRegion.v2;
/* 497 */       f2 = paramTextureRegion.u;
/* 498 */       f6 = paramTextureRegion.v;
/* 499 */       f7 = paramTextureRegion.u2;
/* 500 */       f1 = paramTextureRegion.v;
/*     */     } else {
/* 502 */       f4 = f1.u;
/* 503 */       f5 = f1.v;
/* 504 */       paramFloat1 = f1.u2;
/* 505 */       paramFloat2 = f1.v;
/* 506 */       f2 = f1.u2;
/* 507 */       f6 = f1.v2;
/* 508 */       f7 = f1.u;
/* 509 */       f1 = f1.v2;
/*     */     } 
/*     */     
/* 512 */     Affine2 affine2 = this.adjustAffine;
/*     */     
/* 514 */     this.vertices[this.idx] = affine2.m00 * paramFloat9 + affine2.m01 * paramFloat5 + affine2.m02;
/* 515 */     this.vertices[this.idx + 1] = affine2.m10 * paramFloat9 + affine2.m11 * paramFloat5 + affine2.m12;
/* 516 */     this.vertices[this.idx + 2] = this.colorPacked;
/* 517 */     this.vertices[this.idx + 3] = f4;
/* 518 */     this.vertices[this.idx + 4] = f5;
/*     */     
/* 520 */     this.vertices[this.idx + 5] = affine2.m00 * paramFloat6 + affine2.m01 * paramFloat7 + affine2.m02;
/* 521 */     this.vertices[this.idx + 6] = affine2.m10 * paramFloat6 + affine2.m11 * paramFloat7 + affine2.m12;
/* 522 */     this.vertices[this.idx + 7] = this.colorPacked;
/* 523 */     this.vertices[this.idx + 8] = paramFloat1;
/* 524 */     this.vertices[this.idx + 9] = paramFloat2;
/*     */     
/* 526 */     this.vertices[this.idx + 10] = affine2.m00 * paramFloat8 + affine2.m01 * paramFloat4 + affine2.m02;
/* 527 */     this.vertices[this.idx + 11] = affine2.m10 * paramFloat8 + affine2.m11 * paramFloat4 + affine2.m12;
/* 528 */     this.vertices[this.idx + 12] = this.colorPacked;
/* 529 */     this.vertices[this.idx + 13] = f2;
/* 530 */     this.vertices[this.idx + 14] = f6;
/*     */     
/* 532 */     this.vertices[this.idx + 15] = affine2.m00 * paramFloat3 + affine2.m01 * f3 + affine2.m02;
/* 533 */     this.vertices[this.idx + 16] = affine2.m10 * paramFloat3 + affine2.m11 * f3 + affine2.m12;
/* 534 */     this.vertices[this.idx + 17] = this.colorPacked;
/* 535 */     this.vertices[this.idx + 18] = f7;
/* 536 */     this.vertices[this.idx + 19] = f1;
/*     */     
/* 538 */     this.idx += 20;
/*     */   }
/*     */   
/*     */   private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/* 542 */     if (!this.drawing) throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
/*     */     
/* 544 */     if (paramTextureRegion.texture != this.lastTexture)
/* 545 */     { switchTexture(paramTextureRegion.texture); }
/* 546 */     else if (this.idx == this.vertices.length) { flush(); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 551 */     float f2 = (paramAffine2 = paramAffine2).m02;
/* 552 */     float f3 = paramAffine2.m12;
/* 553 */     float f4 = paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 554 */     float f5 = paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 555 */     float f6 = paramAffine2.m00 * paramFloat1 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 556 */     paramFloat2 = paramAffine2.m10 * paramFloat1 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 557 */     float f7 = paramAffine2.m00 * paramFloat1 + paramAffine2.m02;
/* 558 */     paramFloat1 = paramAffine2.m10 * paramFloat1 + paramAffine2.m12;
/*     */ 
/*     */     
/* 561 */     float f8 = paramTextureRegion.u;
/* 562 */     float f9 = paramTextureRegion.v2;
/* 563 */     float f10 = paramTextureRegion.u2;
/* 564 */     float f1 = paramTextureRegion.v;
/*     */     
/* 566 */     paramAffine2 = this.adjustAffine;
/*     */     
/* 568 */     this.vertices[this.idx] = paramAffine2.m00 * f2 + paramAffine2.m01 * f3 + paramAffine2.m02;
/* 569 */     this.vertices[this.idx + 1] = paramAffine2.m10 * f2 + paramAffine2.m11 * f3 + paramAffine2.m12;
/* 570 */     this.vertices[this.idx + 2] = this.colorPacked;
/* 571 */     this.vertices[this.idx + 3] = f8;
/* 572 */     this.vertices[this.idx + 4] = f9;
/*     */     
/* 574 */     this.vertices[this.idx + 5] = paramAffine2.m00 * f4 + paramAffine2.m01 * f5 + paramAffine2.m02;
/* 575 */     this.vertices[this.idx + 6] = paramAffine2.m10 * f4 + paramAffine2.m11 * f5 + paramAffine2.m12;
/* 576 */     this.vertices[this.idx + 7] = this.colorPacked;
/* 577 */     this.vertices[this.idx + 8] = f8;
/* 578 */     this.vertices[this.idx + 9] = f1;
/*     */     
/* 580 */     this.vertices[this.idx + 10] = paramAffine2.m00 * f6 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 581 */     this.vertices[this.idx + 11] = paramAffine2.m10 * f6 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 582 */     this.vertices[this.idx + 12] = this.colorPacked;
/* 583 */     this.vertices[this.idx + 13] = f10;
/* 584 */     this.vertices[this.idx + 14] = f1;
/*     */     
/* 586 */     this.vertices[this.idx + 15] = paramAffine2.m00 * f7 + paramAffine2.m01 * paramFloat1 + paramAffine2.m02;
/* 587 */     this.vertices[this.idx + 16] = paramAffine2.m10 * f7 + paramAffine2.m11 * paramFloat1 + paramAffine2.m12;
/* 588 */     this.vertices[this.idx + 17] = this.colorPacked;
/* 589 */     this.vertices[this.idx + 18] = f10;
/* 590 */     this.vertices[this.idx + 19] = f9;
/*     */     
/* 592 */     this.idx += 20;
/*     */   }
/*     */   
/*     */   private void drawAdjusted(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 596 */     if (!this.drawing) throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
/*     */     
/* 598 */     if (paramTexture != this.lastTexture) switchTexture(paramTexture);
/*     */     
/* 600 */     Affine2 affine2 = this.adjustAffine;
/*     */     
/* 602 */     int i = Math.min(this.vertices.length - this.idx, paramInt2);
/*     */     do {
/* 604 */       paramInt2 -= i;
/* 605 */       while (i > 0) {
/* 606 */         float f1 = paramArrayOffloat[paramInt1];
/* 607 */         float f2 = paramArrayOffloat[paramInt1 + 1];
/*     */         
/* 609 */         this.vertices[this.idx] = affine2.m00 * f1 + affine2.m01 * f2 + affine2.m02;
/* 610 */         this.vertices[this.idx + 1] = affine2.m10 * f1 + affine2.m11 * f2 + affine2.m12;
/* 611 */         this.vertices[this.idx + 2] = paramArrayOffloat[paramInt1 + 2];
/* 612 */         this.vertices[this.idx + 3] = paramArrayOffloat[paramInt1 + 3];
/* 613 */         this.vertices[this.idx + 4] = paramArrayOffloat[paramInt1 + 4];
/*     */         
/* 615 */         this.idx += 5;
/* 616 */         paramInt1 += 5;
/* 617 */         i -= 5;
/*     */       } 
/*     */       
/* 620 */       if (paramInt2 <= 0)
/* 621 */         continue;  flush();
/* 622 */       i = Math.min(this.vertices.length, paramInt2);
/*     */     }
/* 624 */     while (paramInt2 > 0);
/*     */   }
/*     */   
/*     */   private static boolean checkEqual(Matrix4 paramMatrix41, Matrix4 paramMatrix42) {
/* 628 */     if (paramMatrix41 == paramMatrix42) return true;
/*     */ 
/*     */     
/* 631 */     return (paramMatrix41.val[0] == paramMatrix42.val[0] && paramMatrix41.val[1] == paramMatrix42.val[1] && paramMatrix41.val[4] == paramMatrix42.val[4] && paramMatrix41.val[5] == paramMatrix42.val[5] && paramMatrix41.val[12] == paramMatrix42.val[12] && paramMatrix41.val[13] == paramMatrix42.val[13]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkEqual(Matrix4 paramMatrix4, Affine2 paramAffine2) {
/*     */     float[] arrayOfFloat;
/* 640 */     if ((arrayOfFloat = paramMatrix4.getValues())[0] == paramAffine2.m00 && arrayOfFloat[1] == paramAffine2.m10 && arrayOfFloat[4] == paramAffine2.m01 && arrayOfFloat[5] == paramAffine2.m11 && arrayOfFloat[12] == paramAffine2.m02 && arrayOfFloat[13] == paramAffine2.m12) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkIdt(Matrix4 paramMatrix4) {
/*     */     float[] arrayOfFloat;
/* 648 */     if ((arrayOfFloat = paramMatrix4.getValues())[0] == 1.0F && arrayOfFloat[1] == 0.0F && arrayOfFloat[4] == 0.0F && arrayOfFloat[5] == 1.0F && arrayOfFloat[12] == 0.0F && arrayOfFloat[13] == 0.0F) return true;  return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\CpuSpriteBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */