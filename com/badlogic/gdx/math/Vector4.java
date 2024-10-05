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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vector4
/*     */   implements Vector<Vector4>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5394070284130414492L;
/*     */   public float x;
/*     */   public float y;
/*     */   public float z;
/*     */   public float w;
/*  40 */   public static final Vector4 X = new Vector4(1.0F, 0.0F, 0.0F, 0.0F);
/*  41 */   public static final Vector4 Y = new Vector4(0.0F, 1.0F, 0.0F, 0.0F);
/*  42 */   public static final Vector4 Z = new Vector4(0.0F, 0.0F, 1.0F, 0.0F);
/*  43 */   public static final Vector4 W = new Vector4(0.0F, 0.0F, 0.0F, 1.0F);
/*  44 */   public static final Vector4 Zero = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  56 */     set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4(Vector4 paramVector4) {
/*  62 */     set(paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4(float[] paramArrayOffloat) {
/*  69 */     set(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2], paramArrayOffloat[3]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4(Vector2 paramVector2, float paramFloat1, float paramFloat2) {
/*  78 */     set(paramVector2.x, paramVector2.y, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4(Vector3 paramVector3, float paramFloat) {
/*  86 */     set(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  97 */     this.x = paramFloat1;
/*  98 */     this.y = paramFloat2;
/*  99 */     this.z = paramFloat3;
/* 100 */     this.w = paramFloat4;
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 set(Vector4 paramVector4) {
/* 106 */     return set(paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 set(float[] paramArrayOffloat) {
/* 114 */     return set(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2], paramArrayOffloat[3]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 set(Vector2 paramVector2, float paramFloat1, float paramFloat2) {
/* 124 */     return set(paramVector2.x, paramVector2.y, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 set(Vector3 paramVector3, float paramFloat) {
/* 133 */     return set(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 setToRandomDirection() {
/*     */     while (true) {
/* 145 */       float f1 = (MathUtils.random() - 0.5F) * 2.0F;
/* 146 */       float f2 = (MathUtils.random() - 0.5F) * 2.0F;
/*     */       float f3;
/* 148 */       if ((f3 = f1 * f1 + f2 * f2) < 1.0F && f3 != 0.0F) {
/* 149 */         f3 = (float)Math.sqrt(-2.0D * Math.log(f3) / f3);
/* 150 */         this.x = f1 * f3;
/* 151 */         this.y = f2 * f3;
/*     */         
/*     */         while (true) {
/* 154 */           f1 = (MathUtils.random() - 0.5F) * 2.0F;
/* 155 */           f2 = (MathUtils.random() - 0.5F) * 2.0F;
/*     */           
/* 157 */           if ((f3 = f1 * f1 + f2 * f2) < 1.0F && f3 != 0.0F) {
/* 158 */             f3 = (float)Math.sqrt(-2.0D * Math.log(f3) / f3);
/* 159 */             this.z = f1 * f3;
/* 160 */             this.w = f2 * f3;
/*     */             
/* 162 */             return nor();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       } 
/* 167 */     }  } public Vector4 cpy() { return new Vector4(this); }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 add(Vector4 paramVector4) {
/* 172 */     return add(paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 182 */     return set(this.x + paramFloat1, this.y + paramFloat2, this.z + paramFloat3, this.w + paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 add(float paramFloat) {
/* 190 */     return set(this.x + paramFloat, this.y + paramFloat, this.z + paramFloat, this.w + paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 sub(Vector4 paramVector4) {
/* 195 */     return sub(paramVector4.x, paramVector4.y, paramVector4.z, paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 sub(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 206 */     return set(this.x - paramFloat1, this.y - paramFloat2, this.z - paramFloat3, this.w - paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 sub(float paramFloat) {
/* 214 */     return set(this.x - paramFloat, this.y - paramFloat, this.z - paramFloat, this.w - paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 scl(float paramFloat) {
/* 222 */     return set(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat, this.w * paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 scl(Vector4 paramVector4) {
/* 230 */     return set(this.x * paramVector4.x, this.y * paramVector4.y, this.z * paramVector4.z, this.w * paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 scl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 240 */     return set(this.x * paramFloat1, this.y * paramFloat2, this.z * paramFloat3, this.w * paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 mulAdd(Vector4 paramVector4, float paramFloat) {
/* 245 */     this.x += paramVector4.x * paramFloat;
/* 246 */     this.y += paramVector4.y * paramFloat;
/* 247 */     this.z += paramVector4.z * paramFloat;
/* 248 */     this.w += paramVector4.w * paramFloat;
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 mulAdd(Vector4 paramVector41, Vector4 paramVector42) {
/* 254 */     this.x += paramVector41.x * paramVector42.x;
/* 255 */     this.y += paramVector41.y * paramVector42.y;
/* 256 */     this.z += paramVector41.z * paramVector42.z;
/* 257 */     this.w += paramVector41.w * paramVector42.w;
/* 258 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float len(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 263 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4));
/*     */   }
/*     */ 
/*     */   
/*     */   public float len() {
/* 268 */     return (float)Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float len2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 273 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float len2() {
/* 278 */     return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean idt(Vector4 paramVector4) {
/* 285 */     return (this.x == paramVector4.x && this.y == paramVector4.y && this.z == paramVector4.z && this.w == paramVector4.w);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 291 */     paramFloat1 = paramFloat5 - paramFloat1;
/* 292 */     paramFloat2 = paramFloat6 - paramFloat2;
/* 293 */     paramFloat3 = paramFloat7 - paramFloat3;
/* 294 */     paramFloat4 = paramFloat8 - paramFloat4;
/* 295 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4));
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst(Vector4 paramVector4) {
/* 300 */     float f2 = paramVector4.x - this.x;
/* 301 */     float f3 = paramVector4.y - this.y;
/* 302 */     float f4 = paramVector4.z - this.z;
/* 303 */     float f1 = paramVector4.w - this.w;
/* 304 */     return (float)Math.sqrt((f2 * f2 + f3 * f3 + f4 * f4 + f1 * f1));
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 309 */     paramFloat1 -= this.x;
/* 310 */     paramFloat2 -= this.y;
/* 311 */     paramFloat3 -= this.z;
/* 312 */     paramFloat4 -= this.w;
/* 313 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 319 */     paramFloat1 = paramFloat5 - paramFloat1;
/* 320 */     paramFloat2 = paramFloat6 - paramFloat2;
/* 321 */     paramFloat3 = paramFloat7 - paramFloat3;
/* 322 */     paramFloat4 = paramFloat8 - paramFloat4;
/* 323 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst2(Vector4 paramVector4) {
/* 328 */     float f2 = paramVector4.x - this.x;
/* 329 */     float f3 = paramVector4.y - this.y;
/* 330 */     float f4 = paramVector4.z - this.z;
/* 331 */     float f1 = paramVector4.w - this.w;
/* 332 */     return f2 * f2 + f3 * f3 + f4 * f4 + f1 * f1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 342 */     paramFloat1 -= this.x;
/* 343 */     paramFloat2 -= this.y;
/* 344 */     paramFloat3 -= this.z;
/* 345 */     paramFloat4 -= this.w;
/* 346 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 nor() {
/*     */     float f;
/* 352 */     if ((f = len2()) == 0.0F || f == 1.0F) return this; 
/* 353 */     return scl(1.0F / (float)Math.sqrt(f));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 358 */     return paramFloat1 * paramFloat5 + paramFloat2 * paramFloat6 + paramFloat3 * paramFloat7 + paramFloat4 * paramFloat8;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dot(Vector4 paramVector4) {
/* 363 */     return this.x * paramVector4.x + this.y * paramVector4.y + this.z * paramVector4.z + this.w * paramVector4.w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 373 */     return this.x * paramFloat1 + this.y * paramFloat2 + this.z * paramFloat3 + this.w * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit() {
/* 378 */     return isUnit(1.0E-9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit(float paramFloat) {
/* 383 */     return (Math.abs(len2() - 1.0F) < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 388 */     return (this.x == 0.0F && this.y == 0.0F && this.z == 0.0F && this.w == 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero(float paramFloat) {
/* 393 */     return (len2() < paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector4 paramVector4, float paramFloat) {
/* 402 */     int i = 0;
/* 403 */     float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F, f4 = 0.0F;
/*     */     
/* 405 */     if (MathUtils.isZero(this.x, paramFloat)) {
/* 406 */       if (!MathUtils.isZero(paramVector4.x, paramFloat)) {
/* 407 */         return false;
/*     */       }
/*     */     } else {
/* 410 */       f1 = this.x / paramVector4.x;
/* 411 */       i = 1;
/*     */     } 
/* 413 */     if (MathUtils.isZero(this.y, paramFloat)) {
/* 414 */       if (!MathUtils.isZero(paramVector4.y, paramFloat)) {
/* 415 */         return false;
/*     */       }
/*     */     } else {
/* 418 */       f2 = this.y / paramVector4.y;
/* 419 */       i |= 0x2;
/*     */     } 
/* 421 */     if (MathUtils.isZero(this.z, paramFloat)) {
/* 422 */       if (!MathUtils.isZero(paramVector4.z, paramFloat)) {
/* 423 */         return false;
/*     */       }
/*     */     } else {
/* 426 */       f3 = this.z / paramVector4.z;
/* 427 */       i |= 0x4;
/*     */     } 
/* 429 */     if (MathUtils.isZero(this.w, paramFloat)) {
/* 430 */       if (!MathUtils.isZero(paramVector4.w, paramFloat)) {
/* 431 */         return false;
/*     */       }
/*     */     } else {
/* 434 */       f4 = this.w / paramVector4.w;
/* 435 */       i |= 0x8;
/*     */     } 
/*     */     
/* 438 */     switch (i) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 4:
/*     */       case 8:
/* 444 */         return true;
/*     */       case 3:
/* 446 */         return MathUtils.isEqual(f1, f2, paramFloat);
/*     */       case 5:
/* 448 */         return MathUtils.isEqual(f1, f3, paramFloat);
/*     */       case 9:
/* 450 */         return MathUtils.isEqual(f1, f4, paramFloat);
/*     */       case 6:
/* 452 */         return MathUtils.isEqual(f2, f3, paramFloat);
/*     */       case 10:
/* 454 */         return MathUtils.isEqual(f2, f4, paramFloat);
/*     */       case 12:
/* 456 */         return MathUtils.isEqual(f3, f4, paramFloat);
/*     */       case 7:
/* 458 */         return (MathUtils.isEqual(f1, f2, paramFloat) && MathUtils.isEqual(f1, f3, paramFloat));
/*     */       case 11:
/* 460 */         return (MathUtils.isEqual(f1, f2, paramFloat) && MathUtils.isEqual(f1, f4, paramFloat));
/*     */       case 13:
/* 462 */         return (MathUtils.isEqual(f1, f3, paramFloat) && MathUtils.isEqual(f1, f4, paramFloat));
/*     */       case 14:
/* 464 */         return (MathUtils.isEqual(f2, f3, paramFloat) && MathUtils.isEqual(f2, f4, paramFloat));
/*     */     } 
/* 466 */     return (MathUtils.isEqual(f1, f2, paramFloat) && MathUtils.isEqual(f1, f3, paramFloat) && MathUtils.isEqual(f1, f4, paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector4 paramVector4) {
/* 473 */     return isOnLine(paramVector4, 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector4 paramVector4, float paramFloat) {
/* 480 */     return (isOnLine(paramVector4, paramFloat) && hasSameDirection(paramVector4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector4 paramVector4) {
/* 487 */     return (isOnLine(paramVector4) && hasSameDirection(paramVector4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector4 paramVector4, float paramFloat) {
/* 494 */     return (isOnLine(paramVector4, paramFloat) && hasOppositeDirection(paramVector4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector4 paramVector4) {
/* 501 */     return (isOnLine(paramVector4) && hasOppositeDirection(paramVector4));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector4 paramVector4) {
/* 506 */     return MathUtils.isZero(dot(paramVector4));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector4 paramVector4, float paramFloat) {
/* 511 */     return MathUtils.isZero(dot(paramVector4), paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSameDirection(Vector4 paramVector4) {
/* 516 */     return (dot(paramVector4) > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOppositeDirection(Vector4 paramVector4) {
/* 521 */     return (dot(paramVector4) < 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 lerp(Vector4 paramVector4, float paramFloat) {
/* 526 */     this.x += paramFloat * (paramVector4.x - this.x);
/* 527 */     this.y += paramFloat * (paramVector4.y - this.y);
/* 528 */     this.z += paramFloat * (paramVector4.z - this.z);
/* 529 */     this.w += paramFloat * (paramVector4.w - this.w);
/* 530 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 interpolate(Vector4 paramVector4, float paramFloat, Interpolation paramInterpolation) {
/* 535 */     return lerp(paramVector4, paramInterpolation.apply(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 543 */     return "(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector4 fromString(String paramString) {
/* 550 */     int i = paramString.indexOf(',', 1);
/* 551 */     int j = paramString.indexOf(',', i + 1);
/* 552 */     int k = paramString.indexOf(',', j + 1);
/* 553 */     if (i != -1 && j != -1 && paramString.charAt(0) == '(' && paramString.charAt(paramString.length() - 1) == ')') {
/*     */       try {
/* 555 */         float f4 = Float.parseFloat(paramString.substring(1, i));
/* 556 */         float f1 = Float.parseFloat(paramString.substring(i + 1, j));
/* 557 */         float f2 = Float.parseFloat(paramString.substring(j + 1, k));
/* 558 */         float f3 = Float.parseFloat(paramString.substring(k + 1, paramString.length() - 1));
/* 559 */         return set(f4, f1, f2, f3);
/* 560 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 564 */     throw new GdxRuntimeException("Malformed Vector4: " + paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 limit(float paramFloat) {
/* 569 */     return limit2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 limit2(float paramFloat) {
/*     */     float f;
/* 575 */     if ((f = len2()) > paramFloat) {
/* 576 */       scl((float)Math.sqrt((paramFloat / f)));
/*     */     }
/* 578 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 setLength(float paramFloat) {
/* 583 */     return setLength2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 setLength2(float paramFloat) {
/*     */     float f;
/* 589 */     if ((f = len2()) == 0.0F || f == paramFloat) return this;  return scl((float)Math.sqrt((paramFloat / f)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 clamp(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 595 */     if ((f = len2()) == 0.0F) return this; 
/* 596 */     paramFloat2 *= paramFloat2;
/* 597 */     if (f > paramFloat2) return scl((float)Math.sqrt((paramFloat2 / f))); 
/* 598 */     paramFloat1 *= paramFloat1;
/* 599 */     if (f < paramFloat1) return scl((float)Math.sqrt((paramFloat1 / f))); 
/* 600 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 607 */     int i = 31 + NumberUtils.floatToIntBits(this.x);
/* 608 */     i = i * 31 + NumberUtils.floatToIntBits(this.y);
/* 609 */     i = i * 31 + NumberUtils.floatToIntBits(this.z);
/*     */     
/* 611 */     return i = i * 31 + NumberUtils.floatToIntBits(this.w);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 616 */     if (this == paramObject) return true; 
/* 617 */     if (paramObject == null) return false; 
/* 618 */     if (getClass() != paramObject.getClass()) return false; 
/* 619 */     paramObject = paramObject;
/* 620 */     if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(((Vector4)paramObject).x)) return false; 
/* 621 */     if (NumberUtils.floatToIntBits(this.y) != NumberUtils.floatToIntBits(((Vector4)paramObject).y)) return false; 
/* 622 */     if (NumberUtils.floatToIntBits(this.z) != NumberUtils.floatToIntBits(((Vector4)paramObject).z)) return false; 
/* 623 */     if (NumberUtils.floatToIntBits(this.w) != NumberUtils.floatToIntBits(((Vector4)paramObject).w)) return false; 
/* 624 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector4 paramVector4, float paramFloat) {
/* 629 */     if (paramVector4 == null) return false; 
/* 630 */     if (Math.abs(paramVector4.x - this.x) > paramFloat) return false; 
/* 631 */     if (Math.abs(paramVector4.y - this.y) > paramFloat) return false; 
/* 632 */     if (Math.abs(paramVector4.z - this.z) > paramFloat) return false; 
/* 633 */     if (Math.abs(paramVector4.w - this.w) > paramFloat) return false; 
/* 634 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 645 */     if (Math.abs(paramFloat1 - this.x) > paramFloat5) return false; 
/* 646 */     if (Math.abs(paramFloat2 - this.y) > paramFloat5) return false; 
/* 647 */     if (Math.abs(paramFloat3 - this.z) > paramFloat5) return false; 
/* 648 */     if (Math.abs(paramFloat4 - this.w) > paramFloat5) return false; 
/* 649 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector4 paramVector4) {
/* 657 */     return epsilonEquals(paramVector4, 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 668 */     return epsilonEquals(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0E-6F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector4 setZero() {
/* 673 */     this.x = 0.0F;
/* 674 */     this.y = 0.0F;
/* 675 */     this.z = 0.0F;
/* 676 */     this.w = 0.0F;
/* 677 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Vector4.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */