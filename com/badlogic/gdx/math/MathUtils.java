/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MathUtils
/*     */ {
/*     */   public static final float nanoToSec = 1.0E-9F;
/*     */   public static final float FLOAT_ROUNDING_ERROR = 1.0E-6F;
/*     */   public static final float PI = 3.1415927F;
/*     */   public static final float PI2 = 6.2831855F;
/*     */   public static final float HALF_PI = 1.5707964F;
/*     */   public static final float E = 2.7182817F;
/*     */   private static final int SIN_BITS = 14;
/*     */   private static final int SIN_MASK = 16383;
/*     */   private static final int SIN_COUNT = 16384;
/*     */   private static final float radFull = 6.2831855F;
/*     */   private static final float degFull = 360.0F;
/*     */   private static final float radToIndex = 2607.5945F;
/*     */   private static final float degToIndex = 45.511112F;
/*     */   public static final float radiansToDegrees = 57.295776F;
/*     */   public static final float radDeg = 57.295776F;
/*     */   public static final float degreesToRadians = 0.017453292F;
/*     */   public static final float degRad = 0.017453292F;
/*     */   
/*     */   private static class Sin
/*     */   {
/*  57 */     static final float[] table = new float[16384];
/*     */     
/*     */     static {
/*  60 */       for (byte b = 0; b < '䀀'; b++) {
/*  61 */         table[b] = (float)Math.sin(((b + 0.5F) / 16384.0F * 6.2831855F));
/*     */       }
/*     */       
/*  64 */       table[0] = 0.0F;
/*  65 */       table[4096] = 1.0F;
/*  66 */       table[8192] = 0.0F;
/*  67 */       table[12288] = -1.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float sin(float paramFloat) {
/*  74 */     return Sin.table[(int)(paramFloat * 2607.5945F) & 0x3FFF];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float cos(float paramFloat) {
/*  80 */     return Sin.table[(int)((paramFloat + 1.5707964F) * 2607.5945F) & 0x3FFF];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float sinDeg(float paramFloat) {
/*  86 */     return Sin.table[(int)(paramFloat * 45.511112F) & 0x3FFF];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float cosDeg(float paramFloat) {
/*  92 */     return Sin.table[(int)((paramFloat + 90.0F) * 45.511112F) & 0x3FFF];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float tan(float paramFloat) {
/* 122 */     float f1, f2 = (f1 = (paramFloat = (paramFloat = (paramFloat = (float)((paramFloat = (paramFloat = paramFloat / 3.1415927F) + 0.5F) - Math.floor(paramFloat))) - 0.5F) * 3.1415927F) * paramFloat) * f1;
/* 123 */     return paramFloat * (0.0010582011F * f2 - 0.11111111F * f1 + 1.0F) / (0.015873017F * f2 - 0.44444445F * f1 + 1.0F);
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
/*     */   public static float tanDeg(float paramFloat) {
/* 142 */     float f1, f2 = (f1 = (paramFloat = (paramFloat = (paramFloat = (float)((paramFloat = (paramFloat = paramFloat * 0.0055555557F) + 0.5F) - Math.floor(paramFloat))) - 0.5F) * 3.1415927F) * paramFloat) * f1;
/* 143 */     return paramFloat * (0.0010582011F * f2 - 0.11111111F * f1 + 1.0F) / (0.015873017F * f2 - 0.44444445F * f1 + 1.0F);
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
/*     */   public static float atanUnchecked(double paramDouble) {
/* 161 */     double d1, d2, d3 = (d2 = ((d1 = Math.abs(paramDouble)) - 1.0D) / (d1 + 1.0D)) * d2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     double d4, d5, d6, d7, d8 = (d7 = (d6 = (d5 = (d4 = d2 * d3) * d3) * d3) * d3) * d3;
/* 167 */     return (float)(Math.signum(paramDouble) * (0.7853981633974483D + d2 * 0.99997726D - d4 * 0.33262347D + d5 * 0.19354346D - d6 * 0.11643287D + d7 * 0.05265332D - d8 * 0.0117212D));
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
/*     */   public static float atan2(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 184 */     if ((f = paramFloat1 / paramFloat2) != f)
/* 185 */     { f = (paramFloat1 == paramFloat2) ? 1.0F : -1.0F; }
/* 186 */     else if (f - f != f - f) { paramFloat2 = 0.0F; }
/* 187 */      if (paramFloat2 > 0.0F)
/* 188 */       return atanUnchecked(f); 
/* 189 */     if (paramFloat2 < 0.0F) {
/* 190 */       if (paramFloat1 >= 0.0F) return atanUnchecked(f) + 3.1415927F; 
/* 191 */       return atanUnchecked(f) - 3.1415927F;
/* 192 */     }  if (paramFloat1 > 0.0F)
/* 193 */       return paramFloat2 + 1.5707964F; 
/* 194 */     if (paramFloat1 < 0.0F) return paramFloat2 - 1.5707964F; 
/* 195 */     return paramFloat2 + paramFloat1;
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
/*     */   public static double atanUncheckedDeg(double paramDouble) {
/* 210 */     double d1, d2, d3 = (d2 = ((d1 = Math.abs(paramDouble)) - 1.0D) / (d1 + 1.0D)) * d2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     double d4, d5, d6, d7, d8 = (d7 = (d6 = (d5 = (d4 = d2 * d3) * d3) * d3) * d3) * d3;
/* 216 */     return Math.signum(paramDouble) * (45.0D + d2 * 57.2944766070562D - d4 * 19.05792099799635D + d5 * 11.089223410359068D - d6 * 6.6711120475953765D + d7 * 3.016813013351768D - d8 * 0.6715752908287405D);
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
/*     */   public static float atan2Deg(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 232 */     if ((f = paramFloat1 / paramFloat2) != f)
/* 233 */     { f = (paramFloat1 == paramFloat2) ? 1.0F : -1.0F; }
/* 234 */     else if (f - f != f - f) { paramFloat2 = 0.0F; }
/* 235 */      if (paramFloat2 > 0.0F)
/* 236 */       return (float)atanUncheckedDeg(f); 
/* 237 */     if (paramFloat2 < 0.0F) {
/* 238 */       if (paramFloat1 >= 0.0F) return (float)(atanUncheckedDeg(f) + 180.0D); 
/* 239 */       return (float)(atanUncheckedDeg(f) - 180.0D);
/* 240 */     }  if (paramFloat1 > 0.0F)
/* 241 */       return paramFloat2 + 90.0F; 
/* 242 */     if (paramFloat1 < 0.0F) return paramFloat2 - 90.0F; 
/* 243 */     return paramFloat2 + paramFloat1;
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
/*     */   public static float atan2Deg360(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 259 */     if ((f = paramFloat1 / paramFloat2) != f)
/* 260 */     { f = (paramFloat1 == paramFloat2) ? 1.0F : -1.0F; }
/* 261 */     else if (f - f != f - f) { paramFloat2 = 0.0F; }
/* 262 */      if (paramFloat2 > 0.0F) {
/* 263 */       if (paramFloat1 >= 0.0F) {
/* 264 */         return (float)atanUncheckedDeg(f);
/*     */       }
/* 266 */       return (float)(atanUncheckedDeg(f) + 360.0D);
/* 267 */     }  if (paramFloat2 < 0.0F)
/* 268 */       return (float)(atanUncheckedDeg(f) + 180.0D); 
/* 269 */     if (paramFloat1 > 0.0F)
/* 270 */       return paramFloat2 + 90.0F; 
/* 271 */     if (paramFloat1 < 0.0F) return paramFloat2 + 270.0F; 
/* 272 */     return paramFloat2 + paramFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float acos(float paramFloat) {
/* 281 */     float f1 = paramFloat * paramFloat;
/* 282 */     float f2 = paramFloat * f1;
/* 283 */     if (paramFloat >= 0.0F) {
/* 284 */       return (float)Math.sqrt((1.0F - paramFloat)) * (1.5707288F - 0.2121144F * paramFloat + 0.074261F * f1 - 0.0187293F * f2);
/*     */     }
/* 286 */     return 3.1415927F - 
/* 287 */       (float)Math.sqrt((paramFloat + 1.0F)) * (1.5707288F + 0.2121144F * paramFloat + 0.074261F * f1 + 0.0187293F * f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float asin(float paramFloat) {
/* 296 */     float f1 = paramFloat * paramFloat;
/* 297 */     float f2 = paramFloat * f1;
/* 298 */     if (paramFloat >= 0.0F) {
/* 299 */       return 1.5707964F - 
/* 300 */         (float)Math.sqrt((1.0F - paramFloat)) * (1.5707288F - 0.2121144F * paramFloat + 0.074261F * f1 - 0.0187293F * f2);
/*     */     }
/* 302 */     return -1.5707964F + (float)Math.sqrt((paramFloat + 1.0F)) * (1.5707288F + 0.2121144F * paramFloat + 0.074261F * f1 + 0.0187293F * f2);
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
/*     */   public static float atan(float paramFloat) {
/* 321 */     double d1, d2, d3 = (d2 = ((d1 = Math.min(Math.abs(paramFloat), Double.MAX_VALUE)) - 1.0D) / (d1 + 1.0D)) * d2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 326 */     double d4, d5, d6, d7, d8 = (d7 = (d6 = (d5 = (d4 = d2 * d3) * d3) * d3) * d3) * d3;
/* 327 */     return Math.signum(paramFloat) * (float)(0.7853981633974483D + d2 * 0.99997726D - d4 * 0.33262347D + d5 * 0.19354346D - d6 * 0.11643287D + d7 * 0.05265332D - d8 * 0.0117212D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float asinDeg(float paramFloat) {
/* 336 */     float f1 = paramFloat * paramFloat;
/* 337 */     float f2 = paramFloat * f1;
/* 338 */     if (paramFloat >= 0.0F) {
/* 339 */       return 90.0F - (float)Math.sqrt((1.0F - paramFloat)) * (89.99613F - 12.15326F * paramFloat + 4.254842F * f1 - 1.0731099F * f2);
/*     */     }
/*     */     
/* 342 */     return (float)Math.sqrt((paramFloat + 1.0F)) * (89.99613F + 12.15326F * paramFloat + 4.254842F * f1 + 1.0731099F * f2) - 90.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float acosDeg(float paramFloat) {
/* 351 */     float f1 = paramFloat * paramFloat;
/* 352 */     float f2 = paramFloat * f1;
/* 353 */     if (paramFloat >= 0.0F) {
/* 354 */       return (float)Math.sqrt((1.0F - paramFloat)) * (89.99613F - 12.153259F * paramFloat + 4.254842F * f1 - 1.0731097F * f2);
/*     */     }
/*     */     
/* 357 */     return 180.0F - (float)Math.sqrt((paramFloat + 1.0F)) * (89.99613F + 12.153259F * paramFloat + 4.254842F * f1 + 1.0731097F * f2);
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
/*     */   public static float atanDeg(float paramFloat) {
/* 377 */     double d1, d2, d3 = (d2 = ((d1 = Math.min(Math.abs(paramFloat), Double.MAX_VALUE)) - 1.0D) / (d1 + 1.0D)) * d2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 382 */     double d4, d5, d6, d7, d8 = (d7 = (d6 = (d5 = (d4 = d2 * d3) * d3) * d3) * d3) * d3;
/* 383 */     return (float)(Math.signum(paramFloat) * (45.0D + d2 * 57.2944766070562D - d4 * 19.05792099799635D + d5 * 11.089223410359068D - d6 * 6.6711120475953765D + d7 * 3.016813013351768D - d8 * 0.6715752908287405D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 389 */   public static Random random = new RandomXS128(); private static final int BIG_ENOUGH_INT = 16384;
/*     */   private static final double BIG_ENOUGH_FLOOR = 16384.0D;
/*     */   
/*     */   public static int random(int paramInt) {
/* 393 */     return random.nextInt(paramInt + 1);
/*     */   }
/*     */   private static final double CEIL = 0.9999999D; private static final double BIG_ENOUGH_CEIL = 16384.999999999996D; private static final double BIG_ENOUGH_ROUND = 16384.5D;
/*     */   
/*     */   public static int random(int paramInt1, int paramInt2) {
/* 398 */     return paramInt1 + random.nextInt(paramInt2 - paramInt1 + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long random(long paramLong) {
/* 404 */     return random(0L, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static long random(long paramLong1, long paramLong2) {
/* 409 */     long l1 = random.nextLong();
/*     */ 
/*     */     
/* 412 */     if (paramLong2 < paramLong1) {
/* 413 */       long l = paramLong2;
/* 414 */       paramLong2 = paramLong1;
/* 415 */       paramLong1 = l;
/*     */     } 
/* 417 */     long l2 = paramLong2 - paramLong1 + 1L;
/*     */ 
/*     */     
/* 420 */     long l3 = l1 & 0xFFFFFFFFL;
/* 421 */     long l4 = l2 & 0xFFFFFFFFL;
/* 422 */     long l5 = l1 >>> 32L;
/* 423 */     long l6 = l2 >>> 32L;
/* 424 */     return paramLong1 + (l5 * l4 >>> 32L) + (l3 * l6 >>> 32L) + l5 * l6;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean randomBoolean() {
/* 429 */     return random.nextBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean randomBoolean(float paramFloat) {
/* 434 */     return (random() < paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float random() {
/* 439 */     return random.nextFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public static float random(float paramFloat) {
/* 444 */     return random.nextFloat() * paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float random(float paramFloat1, float paramFloat2) {
/* 449 */     return paramFloat1 + random.nextFloat() * (paramFloat2 - paramFloat1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int randomSign() {
/* 454 */     return 0x1 | random.nextInt() >> 31;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float randomTriangular() {
/* 462 */     return random.nextFloat() - random.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float randomTriangular(float paramFloat) {
/* 471 */     return (random.nextFloat() - random.nextFloat()) * paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float randomTriangular(float paramFloat1, float paramFloat2) {
/* 481 */     return randomTriangular(paramFloat1, paramFloat2, (paramFloat1 + paramFloat2) * 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float randomTriangular(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 490 */     float f1 = random.nextFloat();
/* 491 */     float f2 = paramFloat2 - paramFloat1;
/* 492 */     if (f1 <= (paramFloat3 - paramFloat1) / f2) return paramFloat1 + (float)Math.sqrt((f1 * f2 * (paramFloat3 - paramFloat1))); 
/* 493 */     return paramFloat2 - (float)Math.sqrt(((1.0F - f1) * f2 * (paramFloat2 - paramFloat3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nextPowerOfTwo(int paramInt) {
/* 500 */     if (paramInt == 0) return 1; 
/* 501 */     paramInt--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 507 */     return (paramInt = (paramInt = (paramInt = (paramInt = (paramInt = paramInt | paramInt >> 1) | paramInt >> 2) | paramInt >> 4) | paramInt >> 8) | paramInt >> 16) + 1;
/*     */   }
/*     */   
/*     */   public static boolean isPowerOfTwo(int paramInt) {
/* 511 */     return (paramInt != 0 && (paramInt & paramInt - 1) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short clamp(short paramShort1, short paramShort2, short paramShort3) {
/* 517 */     if (paramShort1 < paramShort2) return paramShort2; 
/* 518 */     if (paramShort1 > paramShort3) return paramShort3; 
/* 519 */     return paramShort1;
/*     */   }
/*     */   
/*     */   public static int clamp(int paramInt1, int paramInt2, int paramInt3) {
/* 523 */     if (paramInt1 < paramInt2) return paramInt2; 
/* 524 */     if (paramInt1 > paramInt3) return paramInt3; 
/* 525 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public static long clamp(long paramLong1, long paramLong2, long paramLong3) {
/* 529 */     if (paramLong1 < paramLong2) return paramLong2; 
/* 530 */     if (paramLong1 > paramLong3) return paramLong3; 
/* 531 */     return paramLong1;
/*     */   }
/*     */   
/*     */   public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 535 */     if (paramFloat1 < paramFloat2) return paramFloat2; 
/* 536 */     if (paramFloat1 > paramFloat3) return paramFloat3; 
/* 537 */     return paramFloat1;
/*     */   }
/*     */   
/*     */   public static double clamp(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 541 */     if (paramDouble1 < paramDouble2) return paramDouble2; 
/* 542 */     if (paramDouble1 > paramDouble3) return paramDouble3; 
/* 543 */     return paramDouble1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 550 */     return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float norm(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 559 */     return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
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
/*     */   public static float map(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 571 */     return paramFloat3 + (paramFloat5 - paramFloat1) * (paramFloat4 - paramFloat3) / (paramFloat2 - paramFloat1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float lerpAngle(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 582 */     paramFloat2 = ((paramFloat2 - paramFloat1) % 6.2831855F + 6.2831855F + 3.1415927F) % 6.2831855F - 3.1415927F;
/* 583 */     return ((paramFloat1 + paramFloat2 * paramFloat3) % 6.2831855F + 6.2831855F) % 6.2831855F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float lerpAngleDeg(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 594 */     paramFloat2 = ((paramFloat2 - paramFloat1) % 360.0F + 360.0F + 180.0F) % 360.0F - 180.0F;
/* 595 */     return ((paramFloat1 + paramFloat2 * paramFloat3) % 360.0F + 360.0F) % 360.0F;
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
/*     */   public static int floor(float paramFloat) {
/* 609 */     return (int)(paramFloat + 16384.0D) - 16384;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int floorPositive(float paramFloat) {
/* 615 */     return (int)paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ceil(float paramFloat) {
/* 621 */     return 16384 - (int)(16384.0D - paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ceilPositive(float paramFloat) {
/* 627 */     return (int)(paramFloat + 0.9999999D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int round(float paramFloat) {
/* 633 */     return (int)(paramFloat + 16384.5D) - 16384;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int roundPositive(float paramFloat) {
/* 638 */     return (int)(paramFloat + 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isZero(float paramFloat) {
/* 643 */     return (Math.abs(paramFloat) <= 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isZero(float paramFloat1, float paramFloat2) {
/* 649 */     return (Math.abs(paramFloat1) <= paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEqual(float paramFloat1, float paramFloat2) {
/* 656 */     return (Math.abs(paramFloat1 - paramFloat2) <= 1.0E-6F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEqual(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 664 */     return (Math.abs(paramFloat1 - paramFloat2) <= paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float log(float paramFloat1, float paramFloat2) {
/* 669 */     return (float)(Math.log(paramFloat2) / Math.log(paramFloat1));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float log2(float paramFloat) {
/* 674 */     return log(2.0F, paramFloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\MathUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */