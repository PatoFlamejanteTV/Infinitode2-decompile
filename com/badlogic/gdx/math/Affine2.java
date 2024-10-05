/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.Serializable;
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
/*     */ public final class Affine2
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1524569123485049187L;
/*  32 */   public float m00 = 1.0F, m01 = 0.0F, m02 = 0.0F;
/*  33 */   public float m10 = 0.0F, m11 = 1.0F, m12 = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Affine2() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Affine2(Affine2 paramAffine2) {
/*  45 */     set(paramAffine2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 idt() {
/*  51 */     this.m00 = 1.0F;
/*  52 */     this.m01 = 0.0F;
/*  53 */     this.m02 = 0.0F;
/*  54 */     this.m10 = 0.0F;
/*  55 */     this.m11 = 1.0F;
/*  56 */     this.m12 = 0.0F;
/*  57 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 set(Affine2 paramAffine2) {
/*  64 */     this.m00 = paramAffine2.m00;
/*  65 */     this.m01 = paramAffine2.m01;
/*  66 */     this.m02 = paramAffine2.m02;
/*  67 */     this.m10 = paramAffine2.m10;
/*  68 */     this.m11 = paramAffine2.m11;
/*  69 */     this.m12 = paramAffine2.m12;
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 set(Matrix3 paramMatrix3) {
/*  77 */     float[] arrayOfFloat = paramMatrix3.val;
/*     */     
/*  79 */     this.m00 = arrayOfFloat[0];
/*  80 */     this.m01 = arrayOfFloat[3];
/*  81 */     this.m02 = arrayOfFloat[6];
/*  82 */     this.m10 = arrayOfFloat[1];
/*  83 */     this.m11 = arrayOfFloat[4];
/*  84 */     this.m12 = arrayOfFloat[7];
/*  85 */     return this;
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
/*     */   public final Affine2 set(Matrix4 paramMatrix4) {
/*  99 */     float[] arrayOfFloat = paramMatrix4.val;
/*     */     
/* 101 */     this.m00 = arrayOfFloat[0];
/* 102 */     this.m01 = arrayOfFloat[4];
/* 103 */     this.m02 = arrayOfFloat[12];
/* 104 */     this.m10 = arrayOfFloat[1];
/* 105 */     this.m11 = arrayOfFloat[5];
/* 106 */     this.m12 = arrayOfFloat[13];
/* 107 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTranslation(float paramFloat1, float paramFloat2) {
/* 115 */     this.m00 = 1.0F;
/* 116 */     this.m01 = 0.0F;
/* 117 */     this.m02 = paramFloat1;
/* 118 */     this.m10 = 0.0F;
/* 119 */     this.m11 = 1.0F;
/* 120 */     this.m12 = paramFloat2;
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTranslation(Vector2 paramVector2) {
/* 128 */     return setToTranslation(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToScaling(float paramFloat1, float paramFloat2) {
/* 136 */     this.m00 = paramFloat1;
/* 137 */     this.m01 = 0.0F;
/* 138 */     this.m02 = 0.0F;
/* 139 */     this.m10 = 0.0F;
/* 140 */     this.m11 = paramFloat2;
/* 141 */     this.m12 = 0.0F;
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToScaling(Vector2 paramVector2) {
/* 149 */     return setToScaling(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToRotation(float paramFloat) {
/* 156 */     float f = MathUtils.cosDeg(paramFloat);
/* 157 */     paramFloat = MathUtils.sinDeg(paramFloat);
/*     */     
/* 159 */     this.m00 = f;
/* 160 */     this.m01 = -paramFloat;
/* 161 */     this.m02 = 0.0F;
/* 162 */     this.m10 = paramFloat;
/* 163 */     this.m11 = f;
/* 164 */     this.m12 = 0.0F;
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToRotationRad(float paramFloat) {
/* 172 */     float f = MathUtils.cos(paramFloat);
/* 173 */     paramFloat = MathUtils.sin(paramFloat);
/*     */     
/* 175 */     this.m00 = f;
/* 176 */     this.m01 = -paramFloat;
/* 177 */     this.m02 = 0.0F;
/* 178 */     this.m10 = paramFloat;
/* 179 */     this.m11 = f;
/* 180 */     this.m12 = 0.0F;
/* 181 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToRotation(float paramFloat1, float paramFloat2) {
/* 189 */     this.m00 = paramFloat1;
/* 190 */     this.m01 = -paramFloat2;
/* 191 */     this.m02 = 0.0F;
/* 192 */     this.m10 = paramFloat2;
/* 193 */     this.m11 = paramFloat1;
/* 194 */     this.m12 = 0.0F;
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToShearing(float paramFloat1, float paramFloat2) {
/* 203 */     this.m00 = 1.0F;
/* 204 */     this.m01 = paramFloat1;
/* 205 */     this.m02 = 0.0F;
/* 206 */     this.m10 = paramFloat2;
/* 207 */     this.m11 = 1.0F;
/* 208 */     this.m12 = 0.0F;
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToShearing(Vector2 paramVector2) {
/* 216 */     return setToShearing(paramVector2.x, paramVector2.y);
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
/*     */   public final Affine2 setToTrnRotScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 228 */     this.m02 = paramFloat1;
/* 229 */     this.m12 = paramFloat2;
/*     */     
/* 231 */     if (paramFloat3 == 0.0F) {
/* 232 */       this.m00 = paramFloat4;
/* 233 */       this.m01 = 0.0F;
/* 234 */       this.m10 = 0.0F;
/* 235 */       this.m11 = paramFloat5;
/*     */     } else {
/* 237 */       paramFloat1 = MathUtils.sinDeg(paramFloat3);
/* 238 */       paramFloat2 = MathUtils.cosDeg(paramFloat3);
/*     */       
/* 240 */       this.m00 = paramFloat2 * paramFloat4;
/* 241 */       this.m01 = -paramFloat1 * paramFloat5;
/* 242 */       this.m10 = paramFloat1 * paramFloat4;
/* 243 */       this.m11 = paramFloat2 * paramFloat5;
/*     */     } 
/* 245 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTrnRotScl(Vector2 paramVector21, float paramFloat, Vector2 paramVector22) {
/* 255 */     return setToTrnRotScl(paramVector21.x, paramVector21.y, paramFloat, paramVector22.x, paramVector22.y);
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
/*     */   public final Affine2 setToTrnRotRadScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 267 */     this.m02 = paramFloat1;
/* 268 */     this.m12 = paramFloat2;
/*     */     
/* 270 */     if (paramFloat3 == 0.0F) {
/* 271 */       this.m00 = paramFloat4;
/* 272 */       this.m01 = 0.0F;
/* 273 */       this.m10 = 0.0F;
/* 274 */       this.m11 = paramFloat5;
/*     */     } else {
/* 276 */       paramFloat1 = MathUtils.sin(paramFloat3);
/* 277 */       paramFloat2 = MathUtils.cos(paramFloat3);
/*     */       
/* 279 */       this.m00 = paramFloat2 * paramFloat4;
/* 280 */       this.m01 = -paramFloat1 * paramFloat5;
/* 281 */       this.m10 = paramFloat1 * paramFloat4;
/* 282 */       this.m11 = paramFloat2 * paramFloat5;
/*     */     } 
/* 284 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTrnRotRadScl(Vector2 paramVector21, float paramFloat, Vector2 paramVector22) {
/* 294 */     return setToTrnRotRadScl(paramVector21.x, paramVector21.y, paramFloat, paramVector22.x, paramVector22.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTrnScl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 305 */     this.m00 = paramFloat3;
/* 306 */     this.m01 = 0.0F;
/* 307 */     this.m02 = paramFloat1;
/* 308 */     this.m10 = 0.0F;
/* 309 */     this.m11 = paramFloat4;
/* 310 */     this.m12 = paramFloat2;
/* 311 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToTrnScl(Vector2 paramVector21, Vector2 paramVector22) {
/* 320 */     return setToTrnScl(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 setToProduct(Affine2 paramAffine21, Affine2 paramAffine22) {
/* 328 */     this.m00 = paramAffine21.m00 * paramAffine22.m00 + paramAffine21.m01 * paramAffine22.m10;
/* 329 */     this.m01 = paramAffine21.m00 * paramAffine22.m01 + paramAffine21.m01 * paramAffine22.m11;
/* 330 */     this.m02 = paramAffine21.m00 * paramAffine22.m02 + paramAffine21.m01 * paramAffine22.m12 + paramAffine21.m02;
/* 331 */     this.m10 = paramAffine21.m10 * paramAffine22.m00 + paramAffine21.m11 * paramAffine22.m10;
/* 332 */     this.m11 = paramAffine21.m10 * paramAffine22.m01 + paramAffine21.m11 * paramAffine22.m11;
/* 333 */     this.m12 = paramAffine21.m10 * paramAffine22.m02 + paramAffine21.m11 * paramAffine22.m12 + paramAffine21.m12;
/* 334 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 inv() {
/*     */     float f1;
/* 342 */     if ((f1 = det()) == 0.0F) throw new GdxRuntimeException("Can't invert a singular affine matrix");
/*     */     
/* 344 */     f1 = 1.0F / f1;
/*     */     
/* 346 */     float f2 = this.m11;
/* 347 */     float f3 = -this.m01;
/* 348 */     float f4 = this.m01 * this.m12 - this.m11 * this.m02;
/* 349 */     float f5 = -this.m10;
/* 350 */     float f6 = this.m00;
/* 351 */     float f7 = this.m10 * this.m02 - this.m00 * this.m12;
/*     */     
/* 353 */     this.m00 = f1 * f2;
/* 354 */     this.m01 = f1 * f3;
/* 355 */     this.m02 = f1 * f4;
/* 356 */     this.m10 = f1 * f5;
/* 357 */     this.m11 = f1 * f6;
/* 358 */     this.m12 = f1 * f7;
/* 359 */     return this;
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
/*     */   public final Affine2 mul(Affine2 paramAffine2) {
/* 371 */     float f2 = this.m00 * paramAffine2.m00 + this.m01 * paramAffine2.m10;
/* 372 */     float f3 = this.m00 * paramAffine2.m01 + this.m01 * paramAffine2.m11;
/* 373 */     float f4 = this.m00 * paramAffine2.m02 + this.m01 * paramAffine2.m12 + this.m02;
/* 374 */     float f5 = this.m10 * paramAffine2.m00 + this.m11 * paramAffine2.m10;
/* 375 */     float f6 = this.m10 * paramAffine2.m01 + this.m11 * paramAffine2.m11;
/* 376 */     float f1 = this.m10 * paramAffine2.m02 + this.m11 * paramAffine2.m12 + this.m12;
/*     */     
/* 378 */     this.m00 = f2;
/* 379 */     this.m01 = f3;
/* 380 */     this.m02 = f4;
/* 381 */     this.m10 = f5;
/* 382 */     this.m11 = f6;
/* 383 */     this.m12 = f1;
/* 384 */     return this;
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
/*     */   public final Affine2 preMul(Affine2 paramAffine2) {
/* 396 */     float f2 = paramAffine2.m00 * this.m00 + paramAffine2.m01 * this.m10;
/* 397 */     float f3 = paramAffine2.m00 * this.m01 + paramAffine2.m01 * this.m11;
/* 398 */     float f4 = paramAffine2.m00 * this.m02 + paramAffine2.m01 * this.m12 + paramAffine2.m02;
/* 399 */     float f5 = paramAffine2.m10 * this.m00 + paramAffine2.m11 * this.m10;
/* 400 */     float f6 = paramAffine2.m10 * this.m01 + paramAffine2.m11 * this.m11;
/* 401 */     float f1 = paramAffine2.m10 * this.m02 + paramAffine2.m11 * this.m12 + paramAffine2.m12;
/*     */     
/* 403 */     this.m00 = f2;
/* 404 */     this.m01 = f3;
/* 405 */     this.m02 = f4;
/* 406 */     this.m10 = f5;
/* 407 */     this.m11 = f6;
/* 408 */     this.m12 = f1;
/* 409 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 translate(float paramFloat1, float paramFloat2) {
/* 417 */     this.m02 += this.m00 * paramFloat1 + this.m01 * paramFloat2;
/* 418 */     this.m12 += this.m10 * paramFloat1 + this.m11 * paramFloat2;
/* 419 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 translate(Vector2 paramVector2) {
/* 426 */     return translate(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preTranslate(float paramFloat1, float paramFloat2) {
/* 434 */     this.m02 += paramFloat1;
/* 435 */     this.m12 += paramFloat2;
/* 436 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preTranslate(Vector2 paramVector2) {
/* 443 */     return preTranslate(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 scale(float paramFloat1, float paramFloat2) {
/* 451 */     this.m00 *= paramFloat1;
/* 452 */     this.m01 *= paramFloat2;
/* 453 */     this.m10 *= paramFloat1;
/* 454 */     this.m11 *= paramFloat2;
/* 455 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 scale(Vector2 paramVector2) {
/* 462 */     return scale(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preScale(float paramFloat1, float paramFloat2) {
/* 470 */     this.m00 *= paramFloat1;
/* 471 */     this.m01 *= paramFloat1;
/* 472 */     this.m02 *= paramFloat1;
/* 473 */     this.m10 *= paramFloat2;
/* 474 */     this.m11 *= paramFloat2;
/* 475 */     this.m12 *= paramFloat2;
/* 476 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preScale(Vector2 paramVector2) {
/* 483 */     return preScale(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 rotate(float paramFloat) {
/* 490 */     if (paramFloat == 0.0F) return this;
/*     */     
/* 492 */     float f1 = MathUtils.cosDeg(paramFloat);
/* 493 */     paramFloat = MathUtils.sinDeg(paramFloat);
/*     */     
/* 495 */     float f2 = this.m00 * f1 + this.m01 * paramFloat;
/* 496 */     float f3 = this.m00 * -paramFloat + this.m01 * f1;
/* 497 */     float f4 = this.m10 * f1 + this.m11 * paramFloat;
/* 498 */     paramFloat = this.m10 * -paramFloat + this.m11 * f1;
/*     */     
/* 500 */     this.m00 = f2;
/* 501 */     this.m01 = f3;
/* 502 */     this.m10 = f4;
/* 503 */     this.m11 = paramFloat;
/* 504 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 rotateRad(float paramFloat) {
/* 511 */     if (paramFloat == 0.0F) return this;
/*     */     
/* 513 */     float f1 = MathUtils.cos(paramFloat);
/* 514 */     paramFloat = MathUtils.sin(paramFloat);
/*     */     
/* 516 */     float f2 = this.m00 * f1 + this.m01 * paramFloat;
/* 517 */     float f3 = this.m00 * -paramFloat + this.m01 * f1;
/* 518 */     float f4 = this.m10 * f1 + this.m11 * paramFloat;
/* 519 */     paramFloat = this.m10 * -paramFloat + this.m11 * f1;
/*     */     
/* 521 */     this.m00 = f2;
/* 522 */     this.m01 = f3;
/* 523 */     this.m10 = f4;
/* 524 */     this.m11 = paramFloat;
/* 525 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preRotate(float paramFloat) {
/* 532 */     if (paramFloat == 0.0F) return this;
/*     */     
/* 534 */     float f1 = MathUtils.cosDeg(paramFloat);
/* 535 */     paramFloat = MathUtils.sinDeg(paramFloat);
/*     */     
/* 537 */     float f2 = f1 * this.m00 - paramFloat * this.m10;
/* 538 */     float f3 = f1 * this.m01 - paramFloat * this.m11;
/* 539 */     float f4 = f1 * this.m02 - paramFloat * this.m12;
/* 540 */     float f5 = paramFloat * this.m00 + f1 * this.m10;
/* 541 */     float f6 = paramFloat * this.m01 + f1 * this.m11;
/* 542 */     paramFloat = paramFloat * this.m02 + f1 * this.m12;
/*     */     
/* 544 */     this.m00 = f2;
/* 545 */     this.m01 = f3;
/* 546 */     this.m02 = f4;
/* 547 */     this.m10 = f5;
/* 548 */     this.m11 = f6;
/* 549 */     this.m12 = paramFloat;
/* 550 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preRotateRad(float paramFloat) {
/* 557 */     if (paramFloat == 0.0F) return this;
/*     */     
/* 559 */     float f1 = MathUtils.cos(paramFloat);
/* 560 */     paramFloat = MathUtils.sin(paramFloat);
/*     */     
/* 562 */     float f2 = f1 * this.m00 - paramFloat * this.m10;
/* 563 */     float f3 = f1 * this.m01 - paramFloat * this.m11;
/* 564 */     float f4 = f1 * this.m02 - paramFloat * this.m12;
/* 565 */     float f5 = paramFloat * this.m00 + f1 * this.m10;
/* 566 */     float f6 = paramFloat * this.m01 + f1 * this.m11;
/* 567 */     paramFloat = paramFloat * this.m02 + f1 * this.m12;
/*     */     
/* 569 */     this.m00 = f2;
/* 570 */     this.m01 = f3;
/* 571 */     this.m02 = f4;
/* 572 */     this.m10 = f5;
/* 573 */     this.m11 = f6;
/* 574 */     this.m12 = paramFloat;
/* 575 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 shear(float paramFloat1, float paramFloat2) {
/* 583 */     float f1 = this.m00 + paramFloat2 * this.m01;
/* 584 */     float f2 = this.m01 + paramFloat1 * this.m00;
/* 585 */     this.m00 = f1;
/* 586 */     this.m01 = f2;
/*     */     
/* 588 */     f1 = this.m10 + paramFloat2 * this.m11;
/* 589 */     f2 = this.m11 + paramFloat1 * this.m10;
/* 590 */     this.m10 = f1;
/* 591 */     this.m11 = f2;
/* 592 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 shear(Vector2 paramVector2) {
/* 599 */     return shear(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preShear(float paramFloat1, float paramFloat2) {
/* 607 */     float f1 = this.m00 + paramFloat1 * this.m10;
/* 608 */     float f2 = this.m01 + paramFloat1 * this.m11;
/* 609 */     paramFloat1 = this.m02 + paramFloat1 * this.m12;
/* 610 */     float f3 = this.m10 + paramFloat2 * this.m00;
/* 611 */     float f4 = this.m11 + paramFloat2 * this.m01;
/* 612 */     paramFloat2 = this.m12 + paramFloat2 * this.m02;
/*     */     
/* 614 */     this.m00 = f1;
/* 615 */     this.m01 = f2;
/* 616 */     this.m02 = paramFloat1;
/* 617 */     this.m10 = f3;
/* 618 */     this.m11 = f4;
/* 619 */     this.m12 = paramFloat2;
/* 620 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Affine2 preShear(Vector2 paramVector2) {
/* 627 */     return preShear(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float det() {
/* 633 */     return this.m00 * this.m11 - this.m01 * this.m10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Vector2 getTranslation(Vector2 paramVector2) {
/* 640 */     paramVector2.x = this.m02;
/* 641 */     paramVector2.y = this.m12;
/* 642 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTranslation() {
/* 648 */     return (this.m00 == 1.0F && this.m11 == 1.0F && this.m01 == 0.0F && this.m10 == 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isIdt() {
/* 654 */     return (this.m00 == 1.0F && this.m02 == 0.0F && this.m12 == 0.0F && this.m11 == 1.0F && this.m01 == 0.0F && this.m10 == 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void applyTo(Vector2 paramVector2) {
/* 659 */     float f1 = paramVector2.x;
/* 660 */     float f2 = paramVector2.y;
/* 661 */     paramVector2.x = this.m00 * f1 + this.m01 * f2 + this.m02;
/* 662 */     paramVector2.y = this.m10 * f1 + this.m11 * f2 + this.m12;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 667 */     return "[" + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Affine2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */