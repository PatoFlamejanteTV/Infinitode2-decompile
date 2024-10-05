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
/*     */ public class Vector2
/*     */   implements Vector<Vector2>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 913902788239530931L;
/*  29 */   public static final Vector2 X = new Vector2(1.0F, 0.0F);
/*  30 */   public static final Vector2 Y = new Vector2(0.0F, 1.0F);
/*  31 */   public static final Vector2 Zero = new Vector2(0.0F, 0.0F);
/*     */ 
/*     */   
/*     */   public float x;
/*     */ 
/*     */   
/*     */   public float y;
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2(float paramFloat1, float paramFloat2) {
/*  46 */     this.x = paramFloat1;
/*  47 */     this.y = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2(Vector2 paramVector2) {
/*  53 */     set(paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 cpy() {
/*  58 */     return new Vector2(this);
/*     */   }
/*     */   
/*     */   public static float len(float paramFloat1, float paramFloat2) {
/*  62 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
/*     */   }
/*     */ 
/*     */   
/*     */   public float len() {
/*  67 */     return (float)Math.sqrt((this.x * this.x + this.y * this.y));
/*     */   }
/*     */   
/*     */   public static float len2(float paramFloat1, float paramFloat2) {
/*  71 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float len2() {
/*  76 */     return this.x * this.x + this.y * this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 set(Vector2 paramVector2) {
/*  81 */     this.x = paramVector2.x;
/*  82 */     this.y = paramVector2.y;
/*  83 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 set(float paramFloat1, float paramFloat2) {
/*  91 */     this.x = paramFloat1;
/*  92 */     this.y = paramFloat2;
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 sub(Vector2 paramVector2) {
/*  98 */     this.x -= paramVector2.x;
/*  99 */     this.y -= paramVector2.y;
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 sub(float paramFloat1, float paramFloat2) {
/* 108 */     this.x -= paramFloat1;
/* 109 */     this.y -= paramFloat2;
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 nor() {
/*     */     float f;
/* 116 */     if ((f = len()) != 0.0F) {
/* 117 */       this.x /= f;
/* 118 */       this.y /= f;
/*     */     } 
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 add(Vector2 paramVector2) {
/* 125 */     this.x += paramVector2.x;
/* 126 */     this.y += paramVector2.y;
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 add(float paramFloat1, float paramFloat2) {
/* 135 */     this.x += paramFloat1;
/* 136 */     this.y += paramFloat2;
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public static float dot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 141 */     return paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dot(Vector2 paramVector2) {
/* 146 */     return this.x * paramVector2.x + this.y * paramVector2.y;
/*     */   }
/*     */   
/*     */   public float dot(float paramFloat1, float paramFloat2) {
/* 150 */     return this.x * paramFloat1 + this.y * paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 scl(float paramFloat) {
/* 155 */     this.x *= paramFloat;
/* 156 */     this.y *= paramFloat;
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 scl(float paramFloat1, float paramFloat2) {
/* 163 */     this.x *= paramFloat1;
/* 164 */     this.y *= paramFloat2;
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 scl(Vector2 paramVector2) {
/* 170 */     this.x *= paramVector2.x;
/* 171 */     this.y *= paramVector2.y;
/* 172 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 mulAdd(Vector2 paramVector2, float paramFloat) {
/* 177 */     this.x += paramVector2.x * paramFloat;
/* 178 */     this.y += paramVector2.y * paramFloat;
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 mulAdd(Vector2 paramVector21, Vector2 paramVector22) {
/* 184 */     this.x += paramVector21.x * paramVector22.x;
/* 185 */     this.y += paramVector21.y * paramVector22.y;
/* 186 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean idt(Vector2 paramVector2) {
/* 193 */     return (this.x == paramVector2.x && this.y == paramVector2.y);
/*     */   }
/*     */   
/*     */   public static float dst(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 197 */     paramFloat1 = paramFloat3 - paramFloat1;
/* 198 */     paramFloat2 = paramFloat4 - paramFloat2;
/* 199 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst(Vector2 paramVector2) {
/* 204 */     float f2 = paramVector2.x - this.x;
/* 205 */     float f1 = paramVector2.y - this.y;
/* 206 */     return (float)Math.sqrt((f2 * f2 + f1 * f1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst(float paramFloat1, float paramFloat2) {
/* 213 */     paramFloat1 -= this.x;
/* 214 */     paramFloat2 -= this.y;
/* 215 */     return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
/*     */   }
/*     */   
/*     */   public static float dst2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 219 */     paramFloat1 = paramFloat3 - paramFloat1;
/* 220 */     paramFloat2 = paramFloat4 - paramFloat2;
/* 221 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float dst2(Vector2 paramVector2) {
/* 226 */     float f2 = paramVector2.x - this.x;
/* 227 */     float f1 = paramVector2.y - this.y;
/* 228 */     return f2 * f2 + f1 * f1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float dst2(float paramFloat1, float paramFloat2) {
/* 235 */     paramFloat1 -= this.x;
/* 236 */     paramFloat2 -= this.y;
/* 237 */     return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 limit(float paramFloat) {
/* 242 */     return limit2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 limit2(float paramFloat) {
/*     */     float f;
/* 248 */     if ((f = len2()) > paramFloat) {
/* 249 */       return scl((float)Math.sqrt((paramFloat / f)));
/*     */     }
/* 251 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 clamp(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 257 */     if ((f = len2()) == 0.0F) return this; 
/* 258 */     paramFloat2 *= paramFloat2;
/* 259 */     if (f > paramFloat2) return scl((float)Math.sqrt((paramFloat2 / f))); 
/* 260 */     paramFloat1 *= paramFloat1;
/* 261 */     if (f < paramFloat1) return scl((float)Math.sqrt((paramFloat1 / f))); 
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 setLength(float paramFloat) {
/* 267 */     return setLength2(paramFloat * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 setLength2(float paramFloat) {
/*     */     float f;
/* 273 */     if ((f = len2()) == 0.0F || f == paramFloat) return this;  return scl((float)Math.sqrt((paramFloat / f)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 280 */     return "(" + this.x + "," + this.y + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 fromString(String paramString) {
/*     */     int i;
/* 288 */     if ((i = paramString.indexOf(',', 1)) != -1 && paramString.charAt(0) == '(' && paramString.charAt(paramString.length() - 1) == ')') {
/*     */       try {
/* 290 */         float f2 = Float.parseFloat(paramString.substring(1, i));
/* 291 */         float f1 = Float.parseFloat(paramString.substring(i + 1, paramString.length() - 1));
/* 292 */         return set(f2, f1);
/* 293 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 297 */     throw new GdxRuntimeException("Malformed Vector2: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 mul(Matrix3 paramMatrix3) {
/* 304 */     float f2 = this.x * paramMatrix3.val[0] + this.y * paramMatrix3.val[3] + paramMatrix3.val[6];
/* 305 */     float f1 = this.x * paramMatrix3.val[1] + this.y * paramMatrix3.val[4] + paramMatrix3.val[7];
/* 306 */     this.x = f2;
/* 307 */     this.y = f1;
/* 308 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float crs(Vector2 paramVector2) {
/* 315 */     return this.x * paramVector2.y - this.y * paramVector2.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float crs(float paramFloat1, float paramFloat2) {
/* 323 */     return this.x * paramFloat2 - this.y * paramFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public float angle() {
/*     */     float f;
/* 332 */     if ((f = (float)Math.atan2(this.y, this.x) * 57.295776F) < 0.0F) f += 360.0F; 
/* 333 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public float angle(Vector2 paramVector2) {
/* 342 */     return (float)Math.atan2(crs(paramVector2), dot(paramVector2)) * 57.295776F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float angleDeg() {
/*     */     float f;
/* 349 */     if ((f = (float)Math.atan2(this.y, this.x) * 57.295776F) < 0.0F) f += 360.0F; 
/* 350 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float angleDeg(Vector2 paramVector2) {
/*     */     float f;
/* 357 */     if ((f = (float)Math.atan2(paramVector2.crs(this), paramVector2.dot(this)) * 57.295776F) < 0.0F) f += 360.0F; 
/* 358 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float angleDeg(float paramFloat1, float paramFloat2) {
/* 365 */     if ((paramFloat1 = (float)Math.atan2(paramFloat2, paramFloat1) * 57.295776F) < 0.0F) paramFloat1 += 360.0F; 
/* 366 */     return paramFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float angleRad() {
/* 372 */     return (float)Math.atan2(this.y, this.x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float angleRad(Vector2 paramVector2) {
/* 378 */     return (float)Math.atan2(paramVector2.crs(this), paramVector2.dot(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float angleRad(float paramFloat1, float paramFloat2) {
/* 384 */     return (float)Math.atan2(paramFloat2, paramFloat1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Vector2 setAngle(float paramFloat) {
/* 392 */     return setAngleRad(paramFloat * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 setAngleDeg(float paramFloat) {
/* 398 */     return setAngleRad(paramFloat * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 setAngleRad(float paramFloat) {
/* 404 */     set(len(), 0.0F);
/* 405 */     rotateRad(paramFloat);
/*     */     
/* 407 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Vector2 rotate(float paramFloat) {
/* 415 */     return rotateRad(paramFloat * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Vector2 rotateAround(Vector2 paramVector2, float paramFloat) {
/* 424 */     return sub(paramVector2).rotateDeg(paramFloat).add(paramVector2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 rotateDeg(float paramFloat) {
/* 430 */     return rotateRad(paramFloat * 0.017453292F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 rotateRad(float paramFloat) {
/* 436 */     float f1 = (float)Math.cos(paramFloat);
/* 437 */     paramFloat = (float)Math.sin(paramFloat);
/*     */     
/* 439 */     float f2 = this.x * f1 - this.y * paramFloat;
/* 440 */     paramFloat = this.x * paramFloat + this.y * f1;
/*     */     
/* 442 */     this.x = f2;
/* 443 */     this.y = paramFloat;
/*     */     
/* 445 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 rotateAroundDeg(Vector2 paramVector2, float paramFloat) {
/* 452 */     return sub(paramVector2).rotateDeg(paramFloat).add(paramVector2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 rotateAroundRad(Vector2 paramVector2, float paramFloat) {
/* 459 */     return sub(paramVector2).rotateRad(paramFloat).add(paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 rotate90(int paramInt) {
/* 464 */     float f = this.x;
/* 465 */     if (paramInt >= 0) {
/* 466 */       this.x = -this.y;
/* 467 */       this.y = f;
/*     */     } else {
/* 469 */       this.x = this.y;
/* 470 */       this.y = -f;
/*     */     } 
/* 472 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 lerp(Vector2 paramVector2, float paramFloat) {
/* 477 */     float f = 1.0F - paramFloat;
/* 478 */     this.x = this.x * f + paramVector2.x * paramFloat;
/* 479 */     this.y = this.y * f + paramVector2.y * paramFloat;
/* 480 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 interpolate(Vector2 paramVector2, float paramFloat, Interpolation paramInterpolation) {
/* 485 */     return lerp(paramVector2, paramInterpolation.apply(paramFloat));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 setToRandomDirection() {
/* 490 */     float f = MathUtils.random(0.0F, 6.2831855F);
/* 491 */     return set(MathUtils.cos(f), MathUtils.sin(f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 498 */     int i = 31 + NumberUtils.floatToIntBits(this.x);
/*     */     
/* 500 */     return i = i * 31 + NumberUtils.floatToIntBits(this.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 505 */     if (this == paramObject) return true; 
/* 506 */     if (paramObject == null) return false; 
/* 507 */     if (getClass() != paramObject.getClass()) return false; 
/* 508 */     paramObject = paramObject;
/* 509 */     if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(((Vector2)paramObject).x)) return false; 
/* 510 */     if (NumberUtils.floatToIntBits(this.y) != NumberUtils.floatToIntBits(((Vector2)paramObject).y)) return false; 
/* 511 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector2 paramVector2, float paramFloat) {
/* 516 */     if (paramVector2 == null) return false; 
/* 517 */     if (Math.abs(paramVector2.x - this.x) > paramFloat) return false; 
/* 518 */     if (Math.abs(paramVector2.y - this.y) > paramFloat) return false; 
/* 519 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 525 */     if (Math.abs(paramFloat1 - this.x) > paramFloat3) return false; 
/* 526 */     if (Math.abs(paramFloat2 - this.y) > paramFloat3) return false; 
/* 527 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(Vector2 paramVector2) {
/* 534 */     return epsilonEquals(paramVector2, 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean epsilonEquals(float paramFloat1, float paramFloat2) {
/* 542 */     return epsilonEquals(paramFloat1, paramFloat2, 1.0E-6F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit() {
/* 547 */     return isUnit(1.0E-9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnit(float paramFloat) {
/* 552 */     return (Math.abs(len2() - 1.0F) < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 557 */     return (this.x == 0.0F && this.y == 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero(float paramFloat) {
/* 562 */     return (len2() < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector2 paramVector2) {
/* 567 */     return MathUtils.isZero(this.x * paramVector2.y - this.y * paramVector2.x);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOnLine(Vector2 paramVector2, float paramFloat) {
/* 572 */     return MathUtils.isZero(this.x * paramVector2.y - this.y * paramVector2.x, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector2 paramVector2, float paramFloat) {
/* 577 */     return (isOnLine(paramVector2, paramFloat) && dot(paramVector2) > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinear(Vector2 paramVector2) {
/* 582 */     return (isOnLine(paramVector2) && dot(paramVector2) > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector2 paramVector2, float paramFloat) {
/* 587 */     return (isOnLine(paramVector2, paramFloat) && dot(paramVector2) < 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollinearOpposite(Vector2 paramVector2) {
/* 592 */     return (isOnLine(paramVector2) && dot(paramVector2) < 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector2 paramVector2) {
/* 597 */     return MathUtils.isZero(dot(paramVector2));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPerpendicular(Vector2 paramVector2, float paramFloat) {
/* 602 */     return MathUtils.isZero(dot(paramVector2), paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSameDirection(Vector2 paramVector2) {
/* 607 */     return (dot(paramVector2) > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOppositeDirection(Vector2 paramVector2) {
/* 612 */     return (dot(paramVector2) < 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 setZero() {
/* 617 */     this.x = 0.0F;
/* 618 */     this.y = 0.0F;
/* 619 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Vector2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */