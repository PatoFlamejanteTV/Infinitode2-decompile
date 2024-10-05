/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ public class Vector3
/*     */   implements Vector<Vector3>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3840054589595372522L;
/*     */   public float x;
/*     */   public float y;
/*     */   public float z;
/*  36 */   public static final Vector3 X = new Vector3(1.0F, 0.0F, 0.0F);
/*  37 */   public static final Vector3 Y = new Vector3(0.0F, 1.0F, 0.0F);
/*  38 */   public static final Vector3 Z = new Vector3(0.0F, 0.0F, 1.0F);
/*  39 */   public static final Vector3 Zero = new Vector3(0.0F, 0.0F, 0.0F);
/*     */   
/*  41 */   private static final Matrix4 tmpMat = new Matrix4();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  52 */     set(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3(Vector3 paramVector3) {
/*  58 */     set(paramVector3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3(float[] paramArrayOffloat) {
/*  65 */     set(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3(Vector2 paramVector2, float paramFloat) {
/*  73 */     set(paramVector2.x, paramVector2.y, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 set(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  83 */     this.x = paramFloat1;
/*  84 */     this.y = paramFloat2;
/*  85 */     this.z = paramFloat3;
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 set(Vector3 paramVector3) {
/*  91 */     return set(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 set(float[] paramArrayOffloat) {
/*  99 */     return set(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 set(Vector2 paramVector2, float paramFloat) {
/* 108 */     return set(paramVector2.x, paramVector2.y, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 setFromSpherical(float paramFloat1, float paramFloat2) {
/* 116 */     float f1 = MathUtils.cos(paramFloat2);
/* 117 */     paramFloat2 = MathUtils.sin(paramFloat2);
/*     */     
/* 119 */     float f2 = MathUtils.cos(paramFloat1);
/* 120 */     paramFloat1 = MathUtils.sin(paramFloat1);
/*     */     
/* 122 */     return set(f2 * paramFloat2, paramFloat1 * paramFloat2, f1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 setToRandomDirection() {
/* 127 */     float f1 = MathUtils.random();
/* 128 */     float f2 = MathUtils.random();
/*     */     
/* 130 */     f1 = 6.2831855F * f1;
/* 131 */     f2 = (float)Math.acos((f2 * 2.0F - 1.0F));
/*     */     
/* 133 */     return setFromSpherical(f1, f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 cpy() {
/* 138 */     return new Vector3(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 add(Vector3 paramVector3) {
/* 143 */     return add(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 add(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 152 */     return set(this.x + paramFloat1, this.y + paramFloat2, this.z + paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 add(float paramFloat) {
/* 160 */     return set(this.x + paramFloat, this.y + paramFloat, this.z + paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 sub(Vector3 paramVector3) {
/* 165 */     return sub(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 sub(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 175 */     return set(this.x - paramFloat1, this.y - paramFloat2, this.z - paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 sub(float paramFloat) {
/* 183 */     return set(this.x - paramFloat, this.y - paramFloat, this.z - paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 scl(float paramFloat) {
/* 188 */     return set(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 scl(Vector3 paramVector3) {
/* 193 */     return set(this.x * paramVector3.x, this.y * paramVector3.y, this.z * paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 scl(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 202 */     return set(this.x * paramFloat1, this.y * paramFloat2, this.z * paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 mulAdd(Vector3 paramVector3, float paramFloat) {
/* 207 */     this.x += paramVector3.x * paramFloat;
/* 208 */     this.y += paramVector3.y * paramFloat;
/* 209 */     this.z += paramVector3.z * paramFloat;
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 mulAdd(Vector3 paramVector31, Vector3 paramVector32) {
/* 215 */     this.x += paramVector31.x * paramVector32.x;
/* 216 */     this.y += paramVector31.y * paramVector32.y;
/* 217 */     this.z += paramVector31.z * paramVector32.z;
/* 218 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float len(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 223 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3));
/*     */   }
/*     */ 
/*     */   
/*     */   public float len() {
/* 228 */     return (float)Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float len2(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 233 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public float len2() {
/* 238 */     return this.x * this.x + this.y * this.y + this.z * this.z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean idt(Vector3 paramVector3) {
/* 245 */     return (this.x == paramVector3.x && this.y == paramVector3.y && this.z == paramVector3.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 250 */     paramFloat1 = paramFloat4 - paramFloat1;
/* 251 */     paramFloat2 = paramFloat5 - paramFloat2;
/* 252 */     paramFloat3 = paramFloat6 - paramFloat3;
/* 253 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3));
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst(Vector3 paramVector3) {
/* 258 */     float f2 = paramVector3.x - this.x;
/* 259 */     float f3 = paramVector3.y - this.y;
/* 260 */     float f1 = paramVector3.z - this.z;
/* 261 */     return (float)Math.sqrt((f2 * f2 + f3 * f3 + f1 * f1));
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 266 */     paramFloat1 -= this.x;
/* 267 */     paramFloat2 -= this.y;
/* 268 */     paramFloat3 -= this.z;
/* 269 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 274 */     paramFloat1 = paramFloat4 - paramFloat1;
/* 275 */     paramFloat2 = paramFloat5 - paramFloat2;
/* 276 */     paramFloat3 = paramFloat6 - paramFloat3;
/* 277 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst2(Vector3 paramVector3) {
/* 282 */     float f2 = paramVector3.x - this.x;
/* 283 */     float f3 = paramVector3.y - this.y;
/* 284 */     float f1 = paramVector3.z - this.z;
/* 285 */     return f2 * f2 + f3 * f3 + f1 * f1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 294 */     paramFloat1 -= this.x;
/* 295 */     paramFloat2 -= this.y;
/* 296 */     paramFloat3 -= this.z;
/* 297 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 nor() {
/*     */     float f;
/* 303 */     if ((f = len2()) == 0.0F || f == 1.0F) return this; 
/* 304 */     return scl(1.0F / (float)Math.sqrt(f));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 309 */     return paramFloat1 * paramFloat4 + paramFloat2 * paramFloat5 + paramFloat3 * paramFloat6;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dot(Vector3 paramVector3) {
/* 314 */     return this.x * paramVector3.x + this.y * paramVector3.y + this.z * paramVector3.z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dot(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 323 */     return this.x * paramFloat1 + this.y * paramFloat2 + this.z * paramFloat3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 crs(Vector3 paramVector3) {
/* 330 */     return set(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 crs(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 339 */     return set(this.y * paramFloat3 - this.z * paramFloat2, this.z * paramFloat1 - this.x * paramFloat3, this.x * paramFloat2 - this.y * paramFloat1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 mul4x3(float[] paramArrayOffloat) {
/* 347 */     return set(this.x * paramArrayOffloat[0] + this.y * paramArrayOffloat[3] + this.z * paramArrayOffloat[6] + paramArrayOffloat[9], this.x * paramArrayOffloat[1] + this.y * paramArrayOffloat[4] + this.z * paramArrayOffloat[7] + paramArrayOffloat[10], this.x * paramArrayOffloat[2] + this.y * paramArrayOffloat[5] + this.z * paramArrayOffloat[8] + paramArrayOffloat[11]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 mul(Matrix4 paramMatrix4) {
/* 355 */     float[] arrayOfFloat = paramMatrix4.val;
/* 356 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8] + arrayOfFloat[12], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9] + arrayOfFloat[13], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10] + arrayOfFloat[14]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 traMul(Matrix4 paramMatrix4) {
/* 365 */     float[] arrayOfFloat = paramMatrix4.val;
/* 366 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2] + arrayOfFloat[3], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6] + arrayOfFloat[7], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10] + arrayOfFloat[11]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 mul(Matrix3 paramMatrix3) {
/* 375 */     float[] arrayOfFloat = paramMatrix3.val;
/* 376 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[3] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[7], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[8]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 traMul(Matrix3 paramMatrix3) {
/* 385 */     float[] arrayOfFloat = paramMatrix3.val;
/* 386 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[3] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[5], this.x * arrayOfFloat[6] + this.y * arrayOfFloat[7] + this.z * arrayOfFloat[8]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 mul(Quaternion paramQuaternion) {
/* 394 */     return paramQuaternion.transform(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 prj(Matrix4 paramMatrix4) {
/* 403 */     float[] arrayOfFloat = paramMatrix4.val;
/* 404 */     float f = 1.0F / (this.x * arrayOfFloat[3] + this.y * arrayOfFloat[7] + this.z * arrayOfFloat[11] + arrayOfFloat[15]);
/* 405 */     return set((this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8] + arrayOfFloat[12]) * f, (this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9] + arrayOfFloat[13]) * f, (this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10] + arrayOfFloat[14]) * f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 rot(Matrix4 paramMatrix4) {
/* 415 */     float[] arrayOfFloat = paramMatrix4.val;
/* 416 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[4] + this.z * arrayOfFloat[8], this.x * arrayOfFloat[1] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[9], this.x * arrayOfFloat[2] + this.y * arrayOfFloat[6] + this.z * arrayOfFloat[10]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 unrotate(Matrix4 paramMatrix4) {
/* 426 */     float[] arrayOfFloat = paramMatrix4.val;
/* 427 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 untransform(Matrix4 paramMatrix4) {
/* 438 */     float[] arrayOfFloat = paramMatrix4.val;
/* 439 */     this.x -= arrayOfFloat[12];
/* 440 */     this.y -= arrayOfFloat[12];
/* 441 */     this.z -= arrayOfFloat[12];
/* 442 */     return set(this.x * arrayOfFloat[0] + this.y * arrayOfFloat[1] + this.z * arrayOfFloat[2], this.x * arrayOfFloat[4] + this.y * arrayOfFloat[5] + this.z * arrayOfFloat[6], this.x * arrayOfFloat[8] + this.y * arrayOfFloat[9] + this.z * arrayOfFloat[10]);
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
/*     */   public Vector3 rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 455 */     return mul(tmpMat.setToRotation(paramFloat2, paramFloat3, paramFloat4, paramFloat1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 rotateRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 466 */     return mul(tmpMat.setToRotationRad(paramFloat2, paramFloat3, paramFloat4, paramFloat1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 rotate(Vector3 paramVector3, float paramFloat) {
/* 475 */     tmpMat.setToRotation(paramVector3, paramFloat);
/* 476 */     return mul(tmpMat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 rotateRad(Vector3 paramVector3, float paramFloat) {
/* 485 */     tmpMat.setToRotationRad(paramVector3, paramFloat);
/* 486 */     return mul(tmpMat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit() {
/* 491 */     return isUnit(1.0E-9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit(float paramFloat) {
/* 496 */     return (Math.abs(len2() - 1.0F) < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 501 */     return (this.x == 0.0F && this.y == 0.0F && this.z == 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero(float paramFloat) {
/* 506 */     return (len2() < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector3 paramVector3, float paramFloat) {
/* 511 */     return (len2(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x) <= paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector3 paramVector3) {
/* 516 */     return (len2(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x) <= 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector3 paramVector3, float paramFloat) {
/* 522 */     return (isOnLine(paramVector3, paramFloat) && hasSameDirection(paramVector3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector3 paramVector3) {
/* 527 */     return (isOnLine(paramVector3) && hasSameDirection(paramVector3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector3 paramVector3, float paramFloat) {
/* 532 */     return (isOnLine(paramVector3, paramFloat) && hasOppositeDirection(paramVector3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector3 paramVector3) {
/* 537 */     return (isOnLine(paramVector3) && hasOppositeDirection(paramVector3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector3 paramVector3) {
/* 542 */     return MathUtils.isZero(dot(paramVector3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector3 paramVector3, float paramFloat) {
/* 547 */     return MathUtils.isZero(dot(paramVector3), paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSameDirection(Vector3 paramVector3) {
/* 552 */     return (dot(paramVector3) > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOppositeDirection(Vector3 paramVector3) {
/* 557 */     return (dot(paramVector3) < 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 lerp(Vector3 paramVector3, float paramFloat) {
/* 562 */     this.x += paramFloat * (paramVector3.x - this.x);
/* 563 */     this.y += paramFloat * (paramVector3.y - this.y);
/* 564 */     this.z += paramFloat * (paramVector3.z - this.z);
/* 565 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 interpolate(Vector3 paramVector3, float paramFloat, Interpolation paramInterpolation) {
/* 570 */     return lerp(paramVector3, paramInterpolation.apply(0.0F, 1.0F, paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 slerp(Vector3 paramVector3, float paramFloat) {
/*     */     float f2;
/* 582 */     if ((f2 = dot(paramVector3)) > 0.9995D || f2 < -0.9995D) return lerp(paramVector3, paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 589 */     float f3 = (float)Math.sin((paramFloat = (f3 = (float)Math.acos(f2)) * paramFloat));
/* 590 */     float f4 = paramVector3.x - this.x * f2;
/* 591 */     float f5 = paramVector3.y - this.y * f2;
/* 592 */     float f1 = paramVector3.z - this.z * f2;
/* 593 */     f2 = f4 * f4 + f5 * f5 + f1 * f1;
/* 594 */     f2 = f3 * ((f2 < 1.0E-4F) ? 1.0F : (1.0F / (float)Math.sqrt(f2)));
/*     */     
/* 596 */     return scl((float)Math.cos(paramFloat)).add(f4 * f2, f5 * f2, f1 * f2).nor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 603 */     return "(" + this.x + "," + this.y + "," + this.z + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 fromString(String paramString) {
/* 610 */     int i = paramString.indexOf(',', 1);
/* 611 */     int j = paramString.indexOf(',', i + 1);
/* 612 */     if (i != -1 && j != -1 && paramString.charAt(0) == '(' && paramString.charAt(paramString.length() - 1) == ')') {
/*     */       try {
/* 614 */         float f3 = Float.parseFloat(paramString.substring(1, i));
/* 615 */         float f1 = Float.parseFloat(paramString.substring(i + 1, j));
/* 616 */         float f2 = Float.parseFloat(paramString.substring(j + 1, paramString.length() - 1));
/* 617 */         return set(f3, f1, f2);
/* 618 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 622 */     throw new GdxRuntimeException("Malformed Vector3: " + paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 limit(float paramFloat) {
/* 627 */     return limit2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 limit2(float paramFloat) {
/*     */     float f;
/* 633 */     if ((f = len2()) > paramFloat) {
/* 634 */       scl((float)Math.sqrt((paramFloat / f)));
/*     */     }
/* 636 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 setLength(float paramFloat) {
/* 641 */     return setLength2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 setLength2(float paramFloat) {
/*     */     float f;
/* 647 */     if ((f = len2()) == 0.0F || f == paramFloat) return this;  return scl((float)Math.sqrt((paramFloat / f)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 clamp(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 653 */     if ((f = len2()) == 0.0F) return this; 
/* 654 */     paramFloat2 *= paramFloat2;
/* 655 */     if (f > paramFloat2) return scl((float)Math.sqrt((paramFloat2 / f))); 
/* 656 */     paramFloat1 *= paramFloat1;
/* 657 */     if (f < paramFloat1) return scl((float)Math.sqrt((paramFloat1 / f))); 
/* 658 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 665 */     int i = 31 + NumberUtils.floatToIntBits(this.x);
/* 666 */     i = i * 31 + NumberUtils.floatToIntBits(this.y);
/*     */     
/* 668 */     return i = i * 31 + NumberUtils.floatToIntBits(this.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 673 */     if (this == paramObject) return true; 
/* 674 */     if (paramObject == null) return false; 
/* 675 */     if (getClass() != paramObject.getClass()) return false; 
/* 676 */     paramObject = paramObject;
/* 677 */     if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(((Vector3)paramObject).x)) return false; 
/* 678 */     if (NumberUtils.floatToIntBits(this.y) != NumberUtils.floatToIntBits(((Vector3)paramObject).y)) return false; 
/* 679 */     if (NumberUtils.floatToIntBits(this.z) != NumberUtils.floatToIntBits(((Vector3)paramObject).z)) return false; 
/* 680 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector3 paramVector3, float paramFloat) {
/* 685 */     if (paramVector3 == null) return false; 
/* 686 */     if (Math.abs(paramVector3.x - this.x) > paramFloat) return false; 
/* 687 */     if (Math.abs(paramVector3.y - this.y) > paramFloat) return false; 
/* 688 */     if (Math.abs(paramVector3.z - this.z) > paramFloat) return false; 
/* 689 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 695 */     if (Math.abs(paramFloat1 - this.x) > paramFloat4) return false; 
/* 696 */     if (Math.abs(paramFloat2 - this.y) > paramFloat4) return false; 
/* 697 */     if (Math.abs(paramFloat3 - this.z) > paramFloat4) return false; 
/* 698 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector3 paramVector3) {
/* 706 */     return epsilonEquals(paramVector3, 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 716 */     return epsilonEquals(paramFloat1, paramFloat2, paramFloat3, 1.0E-6F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 setZero() {
/* 721 */     this.x = 0.0F;
/* 722 */     this.y = 0.0F;
/* 723 */     this.z = 0.0F;
/* 724 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Vector3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */