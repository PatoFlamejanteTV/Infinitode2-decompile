/*     */ package com.badlogic.gdx.math;
/*     */ 
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
/*     */ public class Quaternion
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7661875440774897168L;
/*  30 */   private static Quaternion tmp1 = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
/*  31 */   private static Quaternion tmp2 = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */   
/*     */   public float x;
/*     */   
/*     */   public float y;
/*     */   
/*     */   public float z;
/*     */   
/*     */   public float w;
/*     */ 
/*     */   
/*     */   public Quaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  44 */     set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public Quaternion() {
/*  48 */     idt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion(Quaternion paramQuaternion) {
/*  55 */     set(paramQuaternion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion(Vector3 paramVector3, float paramFloat) {
/*  63 */     set(paramVector3, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  73 */     this.x = paramFloat1;
/*  74 */     this.y = paramFloat2;
/*  75 */     this.z = paramFloat3;
/*  76 */     this.w = paramFloat4;
/*  77 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion set(Quaternion paramQuaternion) {
/*  84 */     return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion set(Vector3 paramVector3, float paramFloat) {
/*  93 */     return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Quaternion cpy() {
/*  98 */     return new Quaternion(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final float len(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 103 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4));
/*     */   }
/*     */ 
/*     */   
/*     */   public float len() {
/* 108 */     return (float)Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return "[" + this.x + "|" + this.y + "|" + this.z + "|" + this.w + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setEulerAngles(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 122 */     return setEulerAnglesRad(paramFloat1 * 0.017453292F, paramFloat2 * 0.017453292F, paramFloat3 * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setEulerAnglesRad(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 133 */     float f1 = (float)Math.sin((paramFloat3 = paramFloat3 * 0.5F));
/* 134 */     paramFloat3 = (float)Math.cos(paramFloat3);
/*     */     
/* 136 */     float f2 = (float)Math.sin((paramFloat2 = paramFloat2 * 0.5F));
/* 137 */     paramFloat2 = (float)Math.cos(paramFloat2);
/*     */     
/* 139 */     float f3 = (float)Math.sin((paramFloat1 = paramFloat1 * 0.5F));
/*     */     
/* 141 */     float f4 = (paramFloat1 = (float)Math.cos(paramFloat1)) * f2;
/* 142 */     float f5 = f3 * paramFloat2;
/* 143 */     paramFloat1 *= paramFloat2;
/* 144 */     paramFloat2 = f3 * f2;
/*     */     
/* 146 */     this.x = f4 * paramFloat3 + f5 * f1;
/* 147 */     this.y = f5 * paramFloat3 - f4 * f1;
/* 148 */     this.z = paramFloat1 * f1 - paramFloat2 * paramFloat3;
/* 149 */     this.w = paramFloat1 * paramFloat3 + paramFloat2 * f1;
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGimbalPole() {
/*     */     float f;
/* 157 */     return ((f = this.y * this.x + this.z * this.w) > 0.499F) ? 1 : ((f < -0.499F) ? -1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getRollRad() {
/*     */     int i;
/* 164 */     return ((i = getGimbalPole()) == 0) ? MathUtils.atan2(2.0F * (this.w * this.z + this.y * this.x), 1.0F - 2.0F * (this.x * this.x + this.z * this.z)) : (
/* 165 */       i * 2.0F * MathUtils.atan2(this.y, this.w));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getRoll() {
/* 171 */     return getRollRad() * 57.295776F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPitchRad() {
/*     */     int i;
/* 178 */     return ((i = getGimbalPole()) == 0) ? (float)Math.asin(MathUtils.clamp(2.0F * (this.w * this.x - this.z * this.y), -1.0F, 1.0F)) : (i * 3.1415927F * 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPitch() {
/* 184 */     return getPitchRad() * 57.295776F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getYawRad() {
/* 190 */     return (getGimbalPole() == 0) ? MathUtils.atan2(2.0F * (this.y * this.w + this.x * this.z), 1.0F - 2.0F * (this.y * this.y + this.x * this.x)) : 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getYaw() {
/* 196 */     return getYawRad() * 57.295776F;
/*     */   }
/*     */   
/*     */   public static final float len2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 200 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float len2() {
/* 205 */     return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion nor() {
/*     */     float f;
/* 212 */     if ((f = len2()) != 0.0F && !MathUtils.isEqual(f, 1.0F)) {
/* 213 */       f = (float)Math.sqrt(f);
/* 214 */       this.w /= f;
/* 215 */       this.x /= f;
/* 216 */       this.y /= f;
/* 217 */       this.z /= f;
/*     */     } 
/* 219 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion conjugate() {
/* 226 */     this.x = -this.x;
/* 227 */     this.y = -this.y;
/* 228 */     this.z = -this.z;
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 transform(Vector3 paramVector3) {
/* 237 */     tmp2.set(this);
/* 238 */     tmp2.conjugate();
/* 239 */     tmp2.mulLeft(tmp1.set(paramVector3.x, paramVector3.y, paramVector3.z, 0.0F)).mulLeft(this);
/*     */     
/* 241 */     paramVector3.x = tmp2.x;
/* 242 */     paramVector3.y = tmp2.y;
/* 243 */     paramVector3.z = tmp2.z;
/* 244 */     return paramVector3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion mul(Quaternion paramQuaternion) {
/* 252 */     float f2 = this.w * paramQuaternion.x + this.x * paramQuaternion.w + this.y * paramQuaternion.z - this.z * paramQuaternion.y;
/* 253 */     float f3 = this.w * paramQuaternion.y + this.y * paramQuaternion.w + this.z * paramQuaternion.x - this.x * paramQuaternion.z;
/* 254 */     float f4 = this.w * paramQuaternion.z + this.z * paramQuaternion.w + this.x * paramQuaternion.y - this.y * paramQuaternion.x;
/* 255 */     float f1 = this.w * paramQuaternion.w - this.x * paramQuaternion.x - this.y * paramQuaternion.y - this.z * paramQuaternion.z;
/* 256 */     this.x = f2;
/* 257 */     this.y = f3;
/* 258 */     this.z = f4;
/* 259 */     this.w = f1;
/* 260 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion mul(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 271 */     float f1 = this.w * paramFloat1 + this.x * paramFloat4 + this.y * paramFloat3 - this.z * paramFloat2;
/* 272 */     float f2 = this.w * paramFloat2 + this.y * paramFloat4 + this.z * paramFloat1 - this.x * paramFloat3;
/* 273 */     float f3 = this.w * paramFloat3 + this.z * paramFloat4 + this.x * paramFloat2 - this.y * paramFloat1;
/* 274 */     paramFloat1 = this.w * paramFloat4 - this.x * paramFloat1 - this.y * paramFloat2 - this.z * paramFloat3;
/* 275 */     this.x = f1;
/* 276 */     this.y = f2;
/* 277 */     this.z = f3;
/* 278 */     this.w = paramFloat1;
/* 279 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion mulLeft(Quaternion paramQuaternion) {
/* 287 */     float f2 = paramQuaternion.w * this.x + paramQuaternion.x * this.w + paramQuaternion.y * this.z - paramQuaternion.z * this.y;
/* 288 */     float f3 = paramQuaternion.w * this.y + paramQuaternion.y * this.w + paramQuaternion.z * this.x - paramQuaternion.x * this.z;
/* 289 */     float f4 = paramQuaternion.w * this.z + paramQuaternion.z * this.w + paramQuaternion.x * this.y - paramQuaternion.y * this.x;
/* 290 */     float f1 = paramQuaternion.w * this.w - paramQuaternion.x * this.x - paramQuaternion.y * this.y - paramQuaternion.z * this.z;
/* 291 */     this.x = f2;
/* 292 */     this.y = f3;
/* 293 */     this.z = f4;
/* 294 */     this.w = f1;
/* 295 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion mulLeft(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 306 */     float f1 = paramFloat4 * this.x + paramFloat1 * this.w + paramFloat2 * this.z - paramFloat3 * this.y;
/* 307 */     float f2 = paramFloat4 * this.y + paramFloat2 * this.w + paramFloat3 * this.x - paramFloat1 * this.z;
/* 308 */     float f3 = paramFloat4 * this.z + paramFloat3 * this.w + paramFloat1 * this.y - paramFloat2 * this.x;
/* 309 */     paramFloat1 = paramFloat4 * this.w - paramFloat1 * this.x - paramFloat2 * this.y - paramFloat3 * this.z;
/* 310 */     this.x = f1;
/* 311 */     this.y = f2;
/* 312 */     this.z = f3;
/* 313 */     this.w = paramFloat1;
/* 314 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Quaternion add(Quaternion paramQuaternion) {
/* 319 */     this.x += paramQuaternion.x;
/* 320 */     this.y += paramQuaternion.y;
/* 321 */     this.z += paramQuaternion.z;
/* 322 */     this.w += paramQuaternion.w;
/* 323 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Quaternion add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 328 */     this.x += paramFloat1;
/* 329 */     this.y += paramFloat2;
/* 330 */     this.z += paramFloat3;
/* 331 */     this.w += paramFloat4;
/* 332 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toMatrix(float[] paramArrayOffloat) {
/* 341 */     float f1 = this.x * this.x;
/* 342 */     float f2 = this.x * this.y;
/* 343 */     float f3 = this.x * this.z;
/* 344 */     float f4 = this.x * this.w;
/* 345 */     float f5 = this.y * this.y;
/* 346 */     float f6 = this.y * this.z;
/* 347 */     float f7 = this.y * this.w;
/* 348 */     float f8 = this.z * this.z;
/* 349 */     float f9 = this.z * this.w;
/*     */     
/* 351 */     paramArrayOffloat[0] = 1.0F - 2.0F * (f5 + f8);
/* 352 */     paramArrayOffloat[4] = 2.0F * (f2 - f9);
/* 353 */     paramArrayOffloat[8] = 2.0F * (f3 + f7);
/* 354 */     paramArrayOffloat[12] = 0.0F;
/* 355 */     paramArrayOffloat[1] = 2.0F * (f2 + f9);
/* 356 */     paramArrayOffloat[5] = 1.0F - 2.0F * (f1 + f8);
/* 357 */     paramArrayOffloat[9] = 2.0F * (f6 - f4);
/* 358 */     paramArrayOffloat[13] = 0.0F;
/* 359 */     paramArrayOffloat[2] = 2.0F * (f3 - f7);
/* 360 */     paramArrayOffloat[6] = 2.0F * (f6 + f4);
/* 361 */     paramArrayOffloat[10] = 1.0F - 2.0F * (f1 + f5);
/* 362 */     paramArrayOffloat[14] = 0.0F;
/* 363 */     paramArrayOffloat[3] = 0.0F;
/* 364 */     paramArrayOffloat[7] = 0.0F;
/* 365 */     paramArrayOffloat[11] = 0.0F;
/* 366 */     paramArrayOffloat[15] = 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion idt() {
/* 372 */     return set(0.0F, 0.0F, 0.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIdentity() {
/* 377 */     return (MathUtils.isZero(this.x) && MathUtils.isZero(this.y) && MathUtils.isZero(this.z) && MathUtils.isEqual(this.w, 1.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIdentity(float paramFloat) {
/* 382 */     if (MathUtils.isZero(this.x, paramFloat) && MathUtils.isZero(this.y, paramFloat) && MathUtils.isZero(this.z, paramFloat) && 
/* 383 */       MathUtils.isEqual(this.w, 1.0F, paramFloat)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxis(Vector3 paramVector3, float paramFloat) {
/* 393 */     return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxisRad(Vector3 paramVector3, float paramFloat) {
/* 402 */     return setFromAxisRad(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxis(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 412 */     return setFromAxisRad(paramFloat1, paramFloat2, paramFloat3, paramFloat4 * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxisRad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*     */     float f1;
/* 423 */     if ((f1 = Vector3.len(paramFloat1, paramFloat2, paramFloat3)) == 0.0F) return idt(); 
/* 424 */     f1 = 1.0F / f1;
/*     */     
/* 426 */     float f2 = (float)Math.sin(((paramFloat4 = (paramFloat4 < 0.0F) ? (6.2831855F - -paramFloat4 % 6.2831855F) : (paramFloat4 % 6.2831855F)) / 2.0F));
/* 427 */     paramFloat4 = (float)Math.cos((paramFloat4 / 2.0F));
/* 428 */     return set(f1 * paramFloat1 * f2, f1 * paramFloat2 * f2, f1 * paramFloat3 * f2, paramFloat4).nor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Quaternion setFromMatrix(boolean paramBoolean, Matrix4 paramMatrix4) {
/* 433 */     return setFromAxes(paramBoolean, paramMatrix4.val[0], paramMatrix4.val[4], paramMatrix4.val[8], paramMatrix4.val[1], paramMatrix4.val[5], paramMatrix4.val[9], paramMatrix4.val[2], paramMatrix4.val[6], paramMatrix4.val[10]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromMatrix(Matrix4 paramMatrix4) {
/* 440 */     return setFromMatrix(false, paramMatrix4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Quaternion setFromMatrix(boolean paramBoolean, Matrix3 paramMatrix3) {
/* 445 */     return setFromAxes(paramBoolean, paramMatrix3.val[0], paramMatrix3.val[3], paramMatrix3.val[6], paramMatrix3.val[1], paramMatrix3.val[4], paramMatrix3.val[7], paramMatrix3.val[2], paramMatrix3.val[5], paramMatrix3.val[8]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromMatrix(Matrix3 paramMatrix3) {
/* 452 */     return setFromMatrix(false, paramMatrix3);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxes(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 475 */     return setFromAxes(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromAxes(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 500 */     if (paramBoolean) {
/* 501 */       float f1 = 1.0F / Vector3.len(paramFloat1, paramFloat2, paramFloat3);
/* 502 */       float f2 = 1.0F / Vector3.len(paramFloat4, paramFloat5, paramFloat6);
/* 503 */       float f3 = 1.0F / Vector3.len(paramFloat7, paramFloat8, paramFloat9);
/* 504 */       paramFloat1 *= f1;
/* 505 */       paramFloat2 *= f1;
/* 506 */       paramFloat3 *= f1;
/* 507 */       paramFloat4 *= f2;
/* 508 */       paramFloat5 *= f2;
/* 509 */       paramFloat6 *= f2;
/* 510 */       paramFloat7 *= f3;
/* 511 */       paramFloat8 *= f3;
/* 512 */       paramFloat9 *= f3;
/*     */     } 
/*     */ 
/*     */     
/*     */     float f;
/*     */ 
/*     */     
/* 519 */     if ((f = paramFloat1 + paramFloat5 + paramFloat9) >= 0.0F) {
/* 520 */       float f1 = (float)Math.sqrt((f + 1.0F));
/* 521 */       this.w = 0.5F * f1;
/* 522 */       f1 = 0.5F / f1;
/* 523 */       this.x = (paramFloat8 - paramFloat6) * f1;
/* 524 */       this.y = (paramFloat3 - paramFloat7) * f1;
/* 525 */       this.z = (paramFloat4 - paramFloat2) * f1;
/* 526 */     } else if (paramFloat1 > paramFloat5 && paramFloat1 > paramFloat9) {
/* 527 */       float f1 = (float)Math.sqrt(1.0D + paramFloat1 - paramFloat5 - paramFloat9);
/* 528 */       this.x = f1 * 0.5F;
/* 529 */       f1 = 0.5F / f1;
/* 530 */       this.y = (paramFloat4 + paramFloat2) * f1;
/* 531 */       this.z = (paramFloat3 + paramFloat7) * f1;
/* 532 */       this.w = (paramFloat8 - paramFloat6) * f1;
/* 533 */     } else if (paramFloat5 > paramFloat9) {
/* 534 */       float f1 = (float)Math.sqrt(1.0D + paramFloat5 - paramFloat1 - paramFloat9);
/* 535 */       this.y = f1 * 0.5F;
/* 536 */       f1 = 0.5F / f1;
/* 537 */       this.x = (paramFloat4 + paramFloat2) * f1;
/* 538 */       this.z = (paramFloat8 + paramFloat6) * f1;
/* 539 */       this.w = (paramFloat3 - paramFloat7) * f1;
/*     */     } else {
/* 541 */       float f1 = (float)Math.sqrt(1.0D + paramFloat9 - paramFloat1 - paramFloat5);
/* 542 */       this.z = f1 * 0.5F;
/* 543 */       f1 = 0.5F / f1;
/* 544 */       this.x = (paramFloat3 + paramFloat7) * f1;
/* 545 */       this.y = (paramFloat8 + paramFloat6) * f1;
/* 546 */       this.w = (paramFloat4 - paramFloat2) * f1;
/*     */     } 
/*     */     
/* 549 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion setFromCross(Vector3 paramVector31, Vector3 paramVector32) {
/* 558 */     float f = (float)Math.acos((f = MathUtils.clamp(paramVector31.dot(paramVector32), -1.0F, 1.0F)));
/* 559 */     return setFromAxisRad(paramVector31.y * paramVector32.z - paramVector31.z * paramVector32.y, paramVector31.z * paramVector32.x - paramVector31.x * paramVector32.z, paramVector31.x * paramVector32.y - paramVector31.y * paramVector32.x, f);
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
/*     */   public Quaternion setFromCross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 573 */     float f = (float)Math.acos((f = MathUtils.clamp(Vector3.dot(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6), -1.0F, 1.0F)));
/* 574 */     return setFromAxisRad(paramFloat2 * paramFloat6 - paramFloat3 * paramFloat5, paramFloat3 * paramFloat4 - paramFloat1 * paramFloat6, paramFloat1 * paramFloat5 - paramFloat2 * paramFloat4, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion slerp(Quaternion paramQuaternion, float paramFloat) {
/* 584 */     float f1, f2 = ((f1 = this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w) < 0.0F) ? -f1 : f1;
/*     */ 
/*     */     
/* 587 */     float f3 = 1.0F - paramFloat;
/* 588 */     float f4 = paramFloat;
/*     */ 
/*     */ 
/*     */     
/* 592 */     if ((1.0F - f2) > 0.1D) {
/*     */       
/* 594 */       f2 = (float)Math.acos(f2);
/* 595 */       f4 = 1.0F / (float)Math.sin(f2);
/*     */ 
/*     */ 
/*     */       
/* 599 */       f3 = (float)Math.sin((f3 * f2)) * f4;
/* 600 */       f4 = (float)Math.sin((paramFloat * f2)) * f4;
/*     */     } 
/*     */     
/* 603 */     if (f1 < 0.0F) f4 = -f4;
/*     */ 
/*     */ 
/*     */     
/* 607 */     this.x = f3 * this.x + f4 * paramQuaternion.x;
/* 608 */     this.y = f3 * this.y + f4 * paramQuaternion.y;
/* 609 */     this.z = f3 * this.z + f4 * paramQuaternion.z;
/* 610 */     this.w = f3 * this.w + f4 * paramQuaternion.w;
/*     */ 
/*     */     
/* 613 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion slerp(Quaternion[] paramArrayOfQuaternion) {
/* 623 */     float f = 1.0F / paramArrayOfQuaternion.length;
/* 624 */     set(paramArrayOfQuaternion[0]).exp(f);
/* 625 */     for (byte b = 1; b < paramArrayOfQuaternion.length; b++)
/* 626 */       mul(tmp1.set(paramArrayOfQuaternion[b]).exp(f)); 
/* 627 */     nor();
/* 628 */     return this;
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
/*     */   public Quaternion slerp(Quaternion[] paramArrayOfQuaternion, float[] paramArrayOffloat) {
/* 640 */     set(paramArrayOfQuaternion[0]).exp(paramArrayOffloat[0]);
/* 641 */     for (byte b = 1; b < paramArrayOfQuaternion.length; b++)
/* 642 */       mul(tmp1.set(paramArrayOfQuaternion[b]).exp(paramArrayOffloat[b])); 
/* 643 */     nor();
/* 644 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion exp(float paramFloat) {
/* 655 */     float f1, f2 = (float)Math.pow((f1 = len()), paramFloat);
/*     */ 
/*     */ 
/*     */     
/*     */     float f3;
/*     */ 
/*     */     
/* 662 */     if (Math.abs(f3 = (float)Math.acos((this.w / f1))) < 0.001D) {
/*     */       
/* 664 */       f1 = f2 * paramFloat / f1;
/*     */     } else {
/* 666 */       f1 = (float)(f2 * Math.sin((paramFloat * f3)) / f1 * Math.sin(f3));
/*     */     } 
/*     */     
/* 669 */     this.w = (float)(f2 * Math.cos((paramFloat * f3)));
/* 670 */     this.x *= f1;
/* 671 */     this.y *= f1;
/* 672 */     this.z *= f1;
/*     */ 
/*     */     
/* 675 */     nor();
/*     */     
/* 677 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 684 */     int i = 31 + NumberUtils.floatToRawIntBits(this.w);
/* 685 */     i = i * 31 + NumberUtils.floatToRawIntBits(this.x);
/* 686 */     i = i * 31 + NumberUtils.floatToRawIntBits(this.y);
/*     */     
/* 688 */     return i = i * 31 + NumberUtils.floatToRawIntBits(this.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 693 */     if (this == paramObject) {
/* 694 */       return true;
/*     */     }
/* 696 */     if (paramObject == null) {
/* 697 */       return false;
/*     */     }
/* 699 */     if (!(paramObject instanceof Quaternion)) {
/* 700 */       return false;
/*     */     }
/* 702 */     paramObject = paramObject;
/* 703 */     if (NumberUtils.floatToRawIntBits(this.w) == NumberUtils.floatToRawIntBits(((Quaternion)paramObject).w) && 
/* 704 */       NumberUtils.floatToRawIntBits(this.x) == NumberUtils.floatToRawIntBits(((Quaternion)paramObject).x) && 
/* 705 */       NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(((Quaternion)paramObject).y) && 
/* 706 */       NumberUtils.floatToRawIntBits(this.z) == NumberUtils.floatToRawIntBits(((Quaternion)paramObject).z)) return true;
/*     */     
/*     */     return false;
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
/*     */   public static final float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 721 */     return paramFloat1 * paramFloat5 + paramFloat2 * paramFloat6 + paramFloat3 * paramFloat7 + paramFloat4 * paramFloat8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dot(Quaternion paramQuaternion) {
/* 728 */     return this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 738 */     return this.x * paramFloat1 + this.y * paramFloat2 + this.z * paramFloat3 + this.w * paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion mul(float paramFloat) {
/* 745 */     this.x *= paramFloat;
/* 746 */     this.y *= paramFloat;
/* 747 */     this.z *= paramFloat;
/* 748 */     this.w *= paramFloat;
/* 749 */     return this;
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
/*     */   public float getAxisAngle(Vector3 paramVector3) {
/* 764 */     return getAxisAngleRad(paramVector3) * 57.295776F;
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
/*     */   public float getAxisAngleRad(Vector3 paramVector3) {
/* 779 */     if (this.w > 1.0F) nor(); 
/* 780 */     float f = (float)(2.0D * Math.acos(this.w));
/*     */     double d;
/* 782 */     if ((d = Math.sqrt((1.0F - this.w * this.w))) < 9.999999974752427E-7D) {
/*     */       
/* 784 */       paramVector3.x = this.x;
/* 785 */       paramVector3.y = this.y;
/* 786 */       paramVector3.z = this.z;
/*     */     } else {
/* 788 */       paramVector3.x = (float)(this.x / d);
/* 789 */       paramVector3.y = (float)(this.y / d);
/* 790 */       paramVector3.z = (float)(this.z / d);
/*     */     } 
/*     */     
/* 793 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngleRad() {
/* 801 */     return (float)(2.0D * Math.acos((this.w > 1.0F) ? (this.w / len()) : this.w));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngle() {
/* 808 */     return getAngleRad() * 57.295776F;
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
/*     */   
/*     */   public void getSwingTwist(float paramFloat1, float paramFloat2, float paramFloat3, Quaternion paramQuaternion1, Quaternion paramQuaternion2) {
/* 825 */     float f = Vector3.dot(this.x, this.y, this.z, paramFloat1, paramFloat2, paramFloat3);
/* 826 */     paramQuaternion2.set(paramFloat1 * f, paramFloat2 * f, paramFloat3 * f, this.w).nor();
/* 827 */     if (f < 0.0F) paramQuaternion2.mul(-1.0F); 
/* 828 */     paramQuaternion1.set(paramQuaternion2).conjugate().mulLeft(this);
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
/*     */   public void getSwingTwist(Vector3 paramVector3, Quaternion paramQuaternion1, Quaternion paramQuaternion2) {
/* 842 */     getSwingTwist(paramVector3.x, paramVector3.y, paramVector3.z, paramQuaternion1, paramQuaternion2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngleAroundRad(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 851 */     float f = Vector3.dot(this.x, this.y, this.z, paramFloat1, paramFloat2, paramFloat3);
/*     */     
/* 853 */     return MathUtils.isZero(paramFloat1 = len2(paramFloat1 * f, paramFloat2 * f, paramFloat3 * f, this.w)) ? 0.0F : 
/* 854 */       (float)(2.0D * Math.acos(MathUtils.clamp((float)(((f < 0.0F) ? -this.w : this.w) / Math.sqrt(paramFloat1)), -1.0F, 1.0F)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngleAroundRad(Vector3 paramVector3) {
/* 861 */     return getAngleAroundRad(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngleAround(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 870 */     return getAngleAroundRad(paramFloat1, paramFloat2, paramFloat3) * 57.295776F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAngleAround(Vector3 paramVector3) {
/* 877 */     return getAngleAround(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Quaternion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */