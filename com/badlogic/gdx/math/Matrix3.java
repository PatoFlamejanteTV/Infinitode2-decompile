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
/*     */ public class Matrix3
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7907569533774959788L;
/*     */   public static final int M00 = 0;
/*     */   public static final int M01 = 3;
/*     */   public static final int M02 = 6;
/*     */   public static final int M10 = 1;
/*     */   public static final int M11 = 4;
/*     */   public static final int M12 = 7;
/*     */   public static final int M20 = 2;
/*     */   public static final int M21 = 5;
/*     */   public static final int M22 = 8;
/*  38 */   public float[] val = new float[9];
/*  39 */   private float[] tmp = new float[9];
/*     */   public Matrix3() {
/*  41 */     this.tmp[8] = 1.0F;
/*     */ 
/*     */ 
/*     */     
/*  45 */     idt();
/*     */   }
/*     */   public Matrix3(Matrix3 paramMatrix3) {
/*     */     this.tmp[8] = 1.0F;
/*  49 */     set(paramMatrix3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3(float[] paramArrayOffloat) {
/*     */     this.tmp[8] = 1.0F;
/*  57 */     set(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 idt() {
/*     */     float[] arrayOfFloat;
/*  64 */     (arrayOfFloat = this.val)[0] = 1.0F;
/*  65 */     arrayOfFloat[1] = 0.0F;
/*  66 */     arrayOfFloat[2] = 0.0F;
/*  67 */     arrayOfFloat[3] = 0.0F;
/*  68 */     arrayOfFloat[4] = 1.0F;
/*  69 */     arrayOfFloat[5] = 0.0F;
/*  70 */     arrayOfFloat[6] = 0.0F;
/*  71 */     arrayOfFloat[7] = 0.0F;
/*  72 */     arrayOfFloat[8] = 1.0F;
/*  73 */     return this;
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
/*     */   public Matrix3 mul(Matrix3 paramMatrix3) {
/*  87 */     float arrayOfFloat[], f2 = (arrayOfFloat = this.val)[0] * paramMatrix3.val[0] + arrayOfFloat[3] * paramMatrix3.val[1] + arrayOfFloat[6] * paramMatrix3.val[2];
/*  88 */     float f3 = arrayOfFloat[0] * paramMatrix3.val[3] + arrayOfFloat[3] * paramMatrix3.val[4] + arrayOfFloat[6] * paramMatrix3.val[5];
/*  89 */     float f4 = arrayOfFloat[0] * paramMatrix3.val[6] + arrayOfFloat[3] * paramMatrix3.val[7] + arrayOfFloat[6] * paramMatrix3.val[8];
/*     */     
/*  91 */     float f5 = arrayOfFloat[1] * paramMatrix3.val[0] + arrayOfFloat[4] * paramMatrix3.val[1] + arrayOfFloat[7] * paramMatrix3.val[2];
/*  92 */     float f6 = arrayOfFloat[1] * paramMatrix3.val[3] + arrayOfFloat[4] * paramMatrix3.val[4] + arrayOfFloat[7] * paramMatrix3.val[5];
/*  93 */     float f7 = arrayOfFloat[1] * paramMatrix3.val[6] + arrayOfFloat[4] * paramMatrix3.val[7] + arrayOfFloat[7] * paramMatrix3.val[8];
/*     */     
/*  95 */     float f8 = arrayOfFloat[2] * paramMatrix3.val[0] + arrayOfFloat[5] * paramMatrix3.val[1] + arrayOfFloat[8] * paramMatrix3.val[2];
/*  96 */     float f9 = arrayOfFloat[2] * paramMatrix3.val[3] + arrayOfFloat[5] * paramMatrix3.val[4] + arrayOfFloat[8] * paramMatrix3.val[5];
/*  97 */     float f1 = arrayOfFloat[2] * paramMatrix3.val[6] + arrayOfFloat[5] * paramMatrix3.val[7] + arrayOfFloat[8] * paramMatrix3.val[8];
/*     */     
/*  99 */     arrayOfFloat[0] = f2;
/* 100 */     arrayOfFloat[1] = f5;
/* 101 */     arrayOfFloat[2] = f8;
/* 102 */     arrayOfFloat[3] = f3;
/* 103 */     arrayOfFloat[4] = f6;
/* 104 */     arrayOfFloat[5] = f9;
/* 105 */     arrayOfFloat[6] = f4;
/* 106 */     arrayOfFloat[7] = f7;
/* 107 */     arrayOfFloat[8] = f1;
/*     */     
/* 109 */     return this;
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
/*     */   public Matrix3 mulLeft(Matrix3 paramMatrix3) {
/* 121 */     float[] arrayOfFloat = this.val;
/*     */     
/* 123 */     float f2 = paramMatrix3.val[0] * arrayOfFloat[0] + paramMatrix3.val[3] * arrayOfFloat[1] + paramMatrix3.val[6] * arrayOfFloat[2];
/* 124 */     float f3 = paramMatrix3.val[0] * arrayOfFloat[3] + paramMatrix3.val[3] * arrayOfFloat[4] + paramMatrix3.val[6] * arrayOfFloat[5];
/* 125 */     float f4 = paramMatrix3.val[0] * arrayOfFloat[6] + paramMatrix3.val[3] * arrayOfFloat[7] + paramMatrix3.val[6] * arrayOfFloat[8];
/*     */     
/* 127 */     float f5 = paramMatrix3.val[1] * arrayOfFloat[0] + paramMatrix3.val[4] * arrayOfFloat[1] + paramMatrix3.val[7] * arrayOfFloat[2];
/* 128 */     float f6 = paramMatrix3.val[1] * arrayOfFloat[3] + paramMatrix3.val[4] * arrayOfFloat[4] + paramMatrix3.val[7] * arrayOfFloat[5];
/* 129 */     float f7 = paramMatrix3.val[1] * arrayOfFloat[6] + paramMatrix3.val[4] * arrayOfFloat[7] + paramMatrix3.val[7] * arrayOfFloat[8];
/*     */     
/* 131 */     float f8 = paramMatrix3.val[2] * arrayOfFloat[0] + paramMatrix3.val[5] * arrayOfFloat[1] + paramMatrix3.val[8] * arrayOfFloat[2];
/* 132 */     float f9 = paramMatrix3.val[2] * arrayOfFloat[3] + paramMatrix3.val[5] * arrayOfFloat[4] + paramMatrix3.val[8] * arrayOfFloat[5];
/* 133 */     float f1 = paramMatrix3.val[2] * arrayOfFloat[6] + paramMatrix3.val[5] * arrayOfFloat[7] + paramMatrix3.val[8] * arrayOfFloat[8];
/*     */     
/* 135 */     arrayOfFloat[0] = f2;
/* 136 */     arrayOfFloat[1] = f5;
/* 137 */     arrayOfFloat[2] = f8;
/* 138 */     arrayOfFloat[3] = f3;
/* 139 */     arrayOfFloat[4] = f6;
/* 140 */     arrayOfFloat[5] = f9;
/* 141 */     arrayOfFloat[6] = f4;
/* 142 */     arrayOfFloat[7] = f7;
/* 143 */     arrayOfFloat[8] = f1;
/*     */     
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToRotation(float paramFloat) {
/* 152 */     return setToRotationRad(0.017453292F * paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToRotationRad(float paramFloat) {
/* 159 */     float f = (float)Math.cos(paramFloat);
/* 160 */     paramFloat = (float)Math.sin(paramFloat);
/*     */     
/*     */     float[] arrayOfFloat;
/* 163 */     (arrayOfFloat = this.val)[0] = f;
/* 164 */     arrayOfFloat[1] = paramFloat;
/* 165 */     arrayOfFloat[2] = 0.0F;
/*     */     
/* 167 */     arrayOfFloat[3] = -paramFloat;
/* 168 */     arrayOfFloat[4] = f;
/* 169 */     arrayOfFloat[5] = 0.0F;
/*     */     
/* 171 */     arrayOfFloat[6] = 0.0F;
/* 172 */     arrayOfFloat[7] = 0.0F;
/* 173 */     arrayOfFloat[8] = 1.0F;
/*     */     
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   public Matrix3 setToRotation(Vector3 paramVector3, float paramFloat) {
/* 179 */     return setToRotation(paramVector3, MathUtils.cosDeg(paramFloat), MathUtils.sinDeg(paramFloat));
/*     */   }
/*     */   
/*     */   public Matrix3 setToRotation(Vector3 paramVector3, float paramFloat1, float paramFloat2) {
/* 183 */     float[] arrayOfFloat = this.val;
/* 184 */     float f = 1.0F - paramFloat1;
/* 185 */     arrayOfFloat[0] = f * paramVector3.x * paramVector3.x + paramFloat1;
/* 186 */     arrayOfFloat[3] = f * paramVector3.x * paramVector3.y - paramVector3.z * paramFloat2;
/* 187 */     arrayOfFloat[6] = f * paramVector3.z * paramVector3.x + paramVector3.y * paramFloat2;
/* 188 */     arrayOfFloat[1] = f * paramVector3.x * paramVector3.y + paramVector3.z * paramFloat2;
/* 189 */     arrayOfFloat[4] = f * paramVector3.y * paramVector3.y + paramFloat1;
/* 190 */     arrayOfFloat[7] = f * paramVector3.y * paramVector3.z - paramVector3.x * paramFloat2;
/* 191 */     arrayOfFloat[2] = f * paramVector3.z * paramVector3.x - paramVector3.y * paramFloat2;
/* 192 */     arrayOfFloat[5] = f * paramVector3.y * paramVector3.z + paramVector3.x * paramFloat2;
/* 193 */     arrayOfFloat[8] = f * paramVector3.z * paramVector3.z + paramFloat1;
/* 194 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToTranslation(float paramFloat1, float paramFloat2) {
/*     */     float[] arrayOfFloat;
/* 204 */     (arrayOfFloat = this.val)[0] = 1.0F;
/* 205 */     arrayOfFloat[1] = 0.0F;
/* 206 */     arrayOfFloat[2] = 0.0F;
/*     */     
/* 208 */     arrayOfFloat[3] = 0.0F;
/* 209 */     arrayOfFloat[4] = 1.0F;
/* 210 */     arrayOfFloat[5] = 0.0F;
/*     */     
/* 212 */     arrayOfFloat[6] = paramFloat1;
/* 213 */     arrayOfFloat[7] = paramFloat2;
/* 214 */     arrayOfFloat[8] = 1.0F;
/*     */     
/* 216 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToTranslation(Vector2 paramVector2) {
/*     */     float[] arrayOfFloat;
/* 225 */     (arrayOfFloat = this.val)[0] = 1.0F;
/* 226 */     arrayOfFloat[1] = 0.0F;
/* 227 */     arrayOfFloat[2] = 0.0F;
/*     */     
/* 229 */     arrayOfFloat[3] = 0.0F;
/* 230 */     arrayOfFloat[4] = 1.0F;
/* 231 */     arrayOfFloat[5] = 0.0F;
/*     */     
/* 233 */     arrayOfFloat[6] = paramVector2.x;
/* 234 */     arrayOfFloat[7] = paramVector2.y;
/* 235 */     arrayOfFloat[8] = 1.0F;
/*     */     
/* 237 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToScaling(float paramFloat1, float paramFloat2) {
/*     */     float[] arrayOfFloat;
/* 247 */     (arrayOfFloat = this.val)[0] = paramFloat1;
/* 248 */     arrayOfFloat[1] = 0.0F;
/* 249 */     arrayOfFloat[2] = 0.0F;
/* 250 */     arrayOfFloat[3] = 0.0F;
/* 251 */     arrayOfFloat[4] = paramFloat2;
/* 252 */     arrayOfFloat[5] = 0.0F;
/* 253 */     arrayOfFloat[6] = 0.0F;
/* 254 */     arrayOfFloat[7] = 0.0F;
/* 255 */     arrayOfFloat[8] = 1.0F;
/* 256 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 setToScaling(Vector2 paramVector2) {
/*     */     float[] arrayOfFloat;
/* 264 */     (arrayOfFloat = this.val)[0] = paramVector2.x;
/* 265 */     arrayOfFloat[1] = 0.0F;
/* 266 */     arrayOfFloat[2] = 0.0F;
/* 267 */     arrayOfFloat[3] = 0.0F;
/* 268 */     arrayOfFloat[4] = paramVector2.y;
/* 269 */     arrayOfFloat[5] = 0.0F;
/* 270 */     arrayOfFloat[6] = 0.0F;
/* 271 */     arrayOfFloat[7] = 0.0F;
/* 272 */     arrayOfFloat[8] = 1.0F;
/* 273 */     return this;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 277 */     float[] arrayOfFloat = this.val;
/* 278 */     return "[" + arrayOfFloat[0] + "|" + arrayOfFloat[3] + "|" + arrayOfFloat[6] + "]\n[" + arrayOfFloat[1] + "|" + arrayOfFloat[4] + "|" + arrayOfFloat[7] + "]\n[" + arrayOfFloat[2] + "|" + arrayOfFloat[5] + "|" + arrayOfFloat[8] + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float det() {
/*     */     float[] arrayOfFloat;
/* 286 */     return (arrayOfFloat = this.val)[0] * arrayOfFloat[4] * arrayOfFloat[8] + arrayOfFloat[3] * arrayOfFloat[7] * arrayOfFloat[2] + arrayOfFloat[6] * arrayOfFloat[1] * arrayOfFloat[5] - arrayOfFloat[0] * arrayOfFloat[7] * arrayOfFloat[5] - arrayOfFloat[3] * arrayOfFloat[1] * arrayOfFloat[8] - arrayOfFloat[6] * arrayOfFloat[4] * arrayOfFloat[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 inv() {
/*     */     float f1;
/* 295 */     if ((f1 = det()) == 0.0F) throw new GdxRuntimeException("Can't invert a singular matrix");
/*     */     
/* 297 */     f1 = 1.0F / f1;
/*     */ 
/*     */     
/* 300 */     float arrayOfFloat[], f2 = (arrayOfFloat = this.val)[4] * arrayOfFloat[8] - arrayOfFloat[5] * arrayOfFloat[7];
/* 301 */     float f3 = arrayOfFloat[2] * arrayOfFloat[7] - arrayOfFloat[1] * arrayOfFloat[8];
/* 302 */     float f4 = arrayOfFloat[1] * arrayOfFloat[5] - arrayOfFloat[2] * arrayOfFloat[4];
/* 303 */     float f5 = arrayOfFloat[5] * arrayOfFloat[6] - arrayOfFloat[3] * arrayOfFloat[8];
/* 304 */     float f6 = arrayOfFloat[0] * arrayOfFloat[8] - arrayOfFloat[2] * arrayOfFloat[6];
/* 305 */     float f7 = arrayOfFloat[2] * arrayOfFloat[3] - arrayOfFloat[0] * arrayOfFloat[5];
/* 306 */     float f8 = arrayOfFloat[3] * arrayOfFloat[7] - arrayOfFloat[4] * arrayOfFloat[6];
/* 307 */     float f9 = arrayOfFloat[1] * arrayOfFloat[6] - arrayOfFloat[0] * arrayOfFloat[7];
/* 308 */     float f10 = arrayOfFloat[0] * arrayOfFloat[4] - arrayOfFloat[1] * arrayOfFloat[3];
/*     */     
/* 310 */     arrayOfFloat[0] = f1 * f2;
/* 311 */     arrayOfFloat[1] = f1 * f3;
/* 312 */     arrayOfFloat[2] = f1 * f4;
/* 313 */     arrayOfFloat[3] = f1 * f5;
/* 314 */     arrayOfFloat[4] = f1 * f6;
/* 315 */     arrayOfFloat[5] = f1 * f7;
/* 316 */     arrayOfFloat[6] = f1 * f8;
/* 317 */     arrayOfFloat[7] = f1 * f9;
/* 318 */     arrayOfFloat[8] = f1 * f10;
/*     */     
/* 320 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 set(Matrix3 paramMatrix3) {
/* 327 */     System.arraycopy(paramMatrix3.val, 0, this.val, 0, this.val.length);
/* 328 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 set(Affine2 paramAffine2) {
/*     */     float[] arrayOfFloat;
/* 337 */     (arrayOfFloat = this.val)[0] = paramAffine2.m00;
/* 338 */     arrayOfFloat[1] = paramAffine2.m10;
/* 339 */     arrayOfFloat[2] = 0.0F;
/* 340 */     arrayOfFloat[3] = paramAffine2.m01;
/* 341 */     arrayOfFloat[4] = paramAffine2.m11;
/* 342 */     arrayOfFloat[5] = 0.0F;
/* 343 */     arrayOfFloat[6] = paramAffine2.m02;
/* 344 */     arrayOfFloat[7] = paramAffine2.m12;
/* 345 */     arrayOfFloat[8] = 1.0F;
/*     */     
/* 347 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 set(Matrix4 paramMatrix4) {
/*     */     float[] arrayOfFloat;
/* 355 */     (arrayOfFloat = this.val)[0] = paramMatrix4.val[0];
/* 356 */     arrayOfFloat[1] = paramMatrix4.val[1];
/* 357 */     arrayOfFloat[2] = paramMatrix4.val[2];
/* 358 */     arrayOfFloat[3] = paramMatrix4.val[4];
/* 359 */     arrayOfFloat[4] = paramMatrix4.val[5];
/* 360 */     arrayOfFloat[5] = paramMatrix4.val[6];
/* 361 */     arrayOfFloat[6] = paramMatrix4.val[8];
/* 362 */     arrayOfFloat[7] = paramMatrix4.val[9];
/* 363 */     arrayOfFloat[8] = paramMatrix4.val[10];
/* 364 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 set(float[] paramArrayOffloat) {
/* 374 */     System.arraycopy(paramArrayOffloat, 0, this.val, 0, this.val.length);
/* 375 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 trn(Vector2 paramVector2) {
/* 382 */     this.val[6] = this.val[6] + paramVector2.x;
/* 383 */     this.val[7] = this.val[7] + paramVector2.y;
/* 384 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 trn(float paramFloat1, float paramFloat2) {
/* 392 */     this.val[6] = this.val[6] + paramFloat1;
/* 393 */     this.val[7] = this.val[7] + paramFloat2;
/* 394 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 trn(Vector3 paramVector3) {
/* 401 */     this.val[6] = this.val[6] + paramVector3.x;
/* 402 */     this.val[7] = this.val[7] + paramVector3.y;
/* 403 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 translate(float paramFloat1, float paramFloat2) {
/*     */     float[] arrayOfFloat;
/* 413 */     (arrayOfFloat = this.tmp)[0] = 1.0F;
/* 414 */     arrayOfFloat[1] = 0.0F;
/*     */ 
/*     */     
/* 417 */     arrayOfFloat[3] = 0.0F;
/* 418 */     arrayOfFloat[4] = 1.0F;
/*     */ 
/*     */     
/* 421 */     arrayOfFloat[6] = paramFloat1;
/* 422 */     arrayOfFloat[7] = paramFloat2;
/*     */     
/* 424 */     mul(this.val, arrayOfFloat);
/* 425 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 translate(Vector2 paramVector2) {
/*     */     float[] arrayOfFloat;
/* 434 */     (arrayOfFloat = this.tmp)[0] = 1.0F;
/* 435 */     arrayOfFloat[1] = 0.0F;
/*     */ 
/*     */     
/* 438 */     arrayOfFloat[3] = 0.0F;
/* 439 */     arrayOfFloat[4] = 1.0F;
/*     */ 
/*     */     
/* 442 */     arrayOfFloat[6] = paramVector2.x;
/* 443 */     arrayOfFloat[7] = paramVector2.y;
/*     */     
/* 445 */     mul(this.val, arrayOfFloat);
/* 446 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 rotate(float paramFloat) {
/* 454 */     return rotateRad(0.017453292F * paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 rotateRad(float paramFloat) {
/* 462 */     if (paramFloat == 0.0F) return this; 
/* 463 */     float f = (float)Math.cos(paramFloat);
/* 464 */     paramFloat = (float)Math.sin(paramFloat);
/*     */     
/*     */     float[] arrayOfFloat;
/* 467 */     (arrayOfFloat = this.tmp)[0] = f;
/* 468 */     arrayOfFloat[1] = paramFloat;
/*     */ 
/*     */     
/* 471 */     arrayOfFloat[3] = -paramFloat;
/* 472 */     arrayOfFloat[4] = f;
/*     */ 
/*     */     
/* 475 */     arrayOfFloat[6] = 0.0F;
/* 476 */     arrayOfFloat[7] = 0.0F;
/*     */ 
/*     */     
/* 479 */     mul(this.val, arrayOfFloat);
/* 480 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 scale(float paramFloat1, float paramFloat2) {
/*     */     float[] arrayOfFloat;
/* 490 */     (arrayOfFloat = this.tmp)[0] = paramFloat1;
/* 491 */     arrayOfFloat[1] = 0.0F;
/*     */ 
/*     */     
/* 494 */     arrayOfFloat[3] = 0.0F;
/* 495 */     arrayOfFloat[4] = paramFloat2;
/*     */ 
/*     */     
/* 498 */     arrayOfFloat[6] = 0.0F;
/* 499 */     arrayOfFloat[7] = 0.0F;
/*     */ 
/*     */     
/* 502 */     mul(this.val, arrayOfFloat);
/* 503 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 scale(Vector2 paramVector2) {
/*     */     float[] arrayOfFloat;
/* 512 */     (arrayOfFloat = this.tmp)[0] = paramVector2.x;
/* 513 */     arrayOfFloat[1] = 0.0F;
/*     */ 
/*     */     
/* 516 */     arrayOfFloat[3] = 0.0F;
/* 517 */     arrayOfFloat[4] = paramVector2.y;
/*     */ 
/*     */     
/* 520 */     arrayOfFloat[6] = 0.0F;
/* 521 */     arrayOfFloat[7] = 0.0F;
/*     */ 
/*     */     
/* 524 */     mul(this.val, arrayOfFloat);
/* 525 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] getValues() {
/* 531 */     return this.val;
/*     */   }
/*     */   
/*     */   public Vector2 getTranslation(Vector2 paramVector2) {
/* 535 */     paramVector2.x = this.val[6];
/* 536 */     paramVector2.y = this.val[7];
/* 537 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 getScale(Vector2 paramVector2) {
/* 543 */     float[] arrayOfFloat = this.val;
/* 544 */     paramVector2.x = (float)Math.sqrt((arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[3] * arrayOfFloat[3]));
/* 545 */     paramVector2.y = (float)Math.sqrt((arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[4] * arrayOfFloat[4]));
/* 546 */     return paramVector2;
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 550 */     return 57.295776F * (float)Math.atan2(this.val[1], this.val[0]);
/*     */   }
/*     */   
/*     */   public float getRotationRad() {
/* 554 */     return (float)Math.atan2(this.val[1], this.val[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 scl(float paramFloat) {
/* 561 */     this.val[0] = this.val[0] * paramFloat;
/* 562 */     this.val[4] = this.val[4] * paramFloat;
/* 563 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 scl(Vector2 paramVector2) {
/* 570 */     this.val[0] = this.val[0] * paramVector2.x;
/* 571 */     this.val[4] = this.val[4] * paramVector2.y;
/* 572 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 scl(Vector3 paramVector3) {
/* 579 */     this.val[0] = this.val[0] * paramVector3.x;
/* 580 */     this.val[4] = this.val[4] * paramVector3.y;
/* 581 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix3 transpose() {
/* 589 */     float arrayOfFloat[], f1 = (arrayOfFloat = this.val)[1];
/* 590 */     float f2 = arrayOfFloat[2];
/* 591 */     float f3 = arrayOfFloat[3];
/* 592 */     float f4 = arrayOfFloat[5];
/* 593 */     float f5 = arrayOfFloat[6];
/* 594 */     float f6 = arrayOfFloat[7];
/* 595 */     arrayOfFloat[3] = f1;
/* 596 */     arrayOfFloat[6] = f2;
/* 597 */     arrayOfFloat[1] = f3;
/* 598 */     arrayOfFloat[7] = f4;
/* 599 */     arrayOfFloat[2] = f5;
/* 600 */     arrayOfFloat[5] = f6;
/* 601 */     return this;
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
/*     */   private static void mul(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 613 */     float f2 = paramArrayOffloat1[0] * paramArrayOffloat2[0] + paramArrayOffloat1[3] * paramArrayOffloat2[1] + paramArrayOffloat1[6] * paramArrayOffloat2[2];
/* 614 */     float f3 = paramArrayOffloat1[0] * paramArrayOffloat2[3] + paramArrayOffloat1[3] * paramArrayOffloat2[4] + paramArrayOffloat1[6] * paramArrayOffloat2[5];
/* 615 */     float f4 = paramArrayOffloat1[0] * paramArrayOffloat2[6] + paramArrayOffloat1[3] * paramArrayOffloat2[7] + paramArrayOffloat1[6] * paramArrayOffloat2[8];
/*     */     
/* 617 */     float f5 = paramArrayOffloat1[1] * paramArrayOffloat2[0] + paramArrayOffloat1[4] * paramArrayOffloat2[1] + paramArrayOffloat1[7] * paramArrayOffloat2[2];
/* 618 */     float f6 = paramArrayOffloat1[1] * paramArrayOffloat2[3] + paramArrayOffloat1[4] * paramArrayOffloat2[4] + paramArrayOffloat1[7] * paramArrayOffloat2[5];
/* 619 */     float f7 = paramArrayOffloat1[1] * paramArrayOffloat2[6] + paramArrayOffloat1[4] * paramArrayOffloat2[7] + paramArrayOffloat1[7] * paramArrayOffloat2[8];
/*     */     
/* 621 */     float f8 = paramArrayOffloat1[2] * paramArrayOffloat2[0] + paramArrayOffloat1[5] * paramArrayOffloat2[1] + paramArrayOffloat1[8] * paramArrayOffloat2[2];
/* 622 */     float f9 = paramArrayOffloat1[2] * paramArrayOffloat2[3] + paramArrayOffloat1[5] * paramArrayOffloat2[4] + paramArrayOffloat1[8] * paramArrayOffloat2[5];
/* 623 */     float f1 = paramArrayOffloat1[2] * paramArrayOffloat2[6] + paramArrayOffloat1[5] * paramArrayOffloat2[7] + paramArrayOffloat1[8] * paramArrayOffloat2[8];
/*     */     
/* 625 */     paramArrayOffloat1[0] = f2;
/* 626 */     paramArrayOffloat1[1] = f5;
/* 627 */     paramArrayOffloat1[2] = f8;
/* 628 */     paramArrayOffloat1[3] = f3;
/* 629 */     paramArrayOffloat1[4] = f6;
/* 630 */     paramArrayOffloat1[5] = f9;
/* 631 */     paramArrayOffloat1[6] = f4;
/* 632 */     paramArrayOffloat1[7] = f7;
/* 633 */     paramArrayOffloat1[8] = f1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Matrix3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */