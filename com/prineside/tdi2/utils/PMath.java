/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameListener;
/*     */ import com.prineside.tdi2.ListenerGroup;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PMath
/*     */ {
/*  21 */   private static final TLog a = TLog.forClass(PMath.class);
/*     */ 
/*     */   
/*     */   private static final ObjectSet<Class> b;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  29 */     (b = new ObjectSet()).add(Character.class);
/*  30 */     b.add(Byte.class);
/*  31 */     b.add(Short.class);
/*  32 */     b.add(Long.class);
/*  33 */     b.add(Float.class);
/*  34 */     b.add(Integer.class);
/*  35 */     b.add(Double.class);
/*  36 */     b.add(Boolean.class);
/*  37 */     b.add(String.class);
/*     */   }
/*     */   
/*  40 */   private static final String[] c = new String[8192];
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
/*     */   public static Color abgr8888ToColor(int paramInt) {
/*     */     Color color;
/*  53 */     (color = new Color()).a = ((paramInt & 0xFF000000) >>> 24) / 255.0F;
/*  54 */     color.b = (paramInt >>> 16 & 0xFF) / 255.0F;
/*  55 */     color.g = (paramInt >>> 8 & 0xFF) / 255.0F;
/*  56 */     color.r = (paramInt & 0xFF) / 255.0F;
/*     */     
/*  58 */     return color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static boolean isFinite(float paramFloat) {
/*  66 */     return (!Float.isInfinite(paramFloat) && !Float.isNaN(paramFloat));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static boolean isFinite(double paramDouble) {
/*  71 */     return (!Double.isInfinite(paramDouble) && !Double.isNaN(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Sin
/*     */   {
/*  77 */     static final float[] a = new float[8192];
/*     */     static {
/*     */       byte b;
/*  80 */       for (b = 0; b < ' '; b++)
/*  81 */         a[b] = (float)StrictMath.sin(((b + 0.5F) / 8192.0F * 6.2831855F)); 
/*  82 */       for (b = 0; b < 'Ũ'; b += 90) {
/*  83 */         a[(int)(b * 22.755556F) & 0x1FFF] = (float)StrictMath.sin((b * 0.017453292F));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeArrayIndicesDirect(Array<?> paramArray, IntArray paramIntArray) {
/*  94 */     Object[] arrayOfObject = paramArray.items;
/*  95 */     int i = paramArray.size;
/*  96 */     for (byte b = 0; b < paramIntArray.size; b++) {
/*  97 */       int j = paramIntArray.items[b];
/*  98 */       i--;
/*  99 */       arrayOfObject[j] = arrayOfObject[i];
/*     */     } 
/* 101 */     paramArray.size = i;
/*     */     
/* 103 */     Arrays.fill(arrayOfObject, i, i + paramIntArray.size, (Object)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float sin(float paramFloat) {
/* 108 */     return Sin.a[(int)(paramFloat * 1303.7972F) & 0x1FFF];
/*     */   }
/*     */ 
/*     */   
/*     */   public static float cos(float paramFloat) {
/* 113 */     return Sin.a[(int)((paramFloat + 1.5707964F) * 1303.7972F) & 0x1FFF];
/*     */   }
/*     */ 
/*     */   
/*     */   public static float sinDeg(float paramFloat) {
/* 118 */     return Sin.a[(int)(paramFloat * 22.755556F) & 0x1FFF];
/*     */   }
/*     */ 
/*     */   
/*     */   public static float cosDeg(float paramFloat) {
/* 123 */     return Sin.a[(int)((paramFloat + 90.0F) * 22.755556F) & 0x1FFF];
/*     */   }
/*     */   
/*     */   public static long generateNewId() {
/* 127 */     return (Game.getTimestampSeconds() << 32L) + FastRandom.random.nextInt();
/*     */   }
/*     */   
/*     */   public static String toString(int paramInt) {
/* 131 */     if (paramInt >= 0 && paramInt < c.length) {
/*     */       String str;
/* 133 */       if ((str = c[paramInt]) == null) {
/* 134 */         c[paramInt] = Integer.toString(paramInt);
/* 135 */         return c[paramInt];
/*     */       } 
/* 137 */       return str;
/*     */     } 
/* 139 */     return Integer.toString(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int getByChance(RandomXS128 paramRandomXS128, int[] paramArrayOfint, int paramInt) {
/* 149 */     if (paramInt % 2 != 0) throw new IllegalArgumentException("chances must contain pairs (chance, index)");
/*     */     
/* 151 */     int i = 0; int j;
/* 152 */     for (j = 0; j < paramInt; j += 2) {
/* 153 */       i += paramArrayOfint[j];
/*     */     }
/* 155 */     j = paramRandomXS128.nextInt(i);
/*     */     
/* 157 */     i = 0;
/* 158 */     for (byte b = 0; b < paramInt; b += 2) {
/* 159 */       if (j < i + paramArrayOfint[b]) {
/* 160 */         return paramArrayOfint[b + 1];
/*     */       }
/* 162 */       i += paramArrayOfint[b];
/*     */     } 
/*     */ 
/*     */     
/* 166 */     throw new RuntimeException("Something gone wrong");
/*     */   }
/*     */   
/*     */   public static Date addDays(Date paramDate, int paramInt) {
/*     */     Calendar calendar;
/* 171 */     (calendar = Calendar.getInstance()).setTime(paramDate);
/* 172 */     calendar.add(5, paramInt);
/*     */     
/* 174 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int getByChance(RandomXS128 paramRandomXS128, IntArray paramIntArray) {
/* 182 */     return getByChance(paramRandomXS128, paramIntArray.items, paramIntArray.size);
/*     */   }
/*     */   
/*     */   public static float loopedDistance(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 186 */     paramFloat1 = (paramFloat1 % paramFloat3 + paramFloat3) % paramFloat3;
/* 187 */     paramFloat2 = (paramFloat2 % paramFloat3 + paramFloat3) % paramFloat3;
/*     */ 
/*     */     
/* 190 */     paramFloat2 = (paramFloat1 = paramFloat1 - paramFloat2) - paramFloat3;
/* 191 */     paramFloat3 = paramFloat1 + paramFloat3;
/* 192 */     float f1 = StrictMath.abs(paramFloat1);
/* 193 */     float f2 = StrictMath.abs(paramFloat2);
/* 194 */     float f3 = StrictMath.abs(paramFloat3);
/* 195 */     if (f1 <= f2 && f1 <= f3)
/* 196 */       return paramFloat1; 
/* 197 */     if (f2 <= f1 && f2 <= f3) {
/* 198 */       return paramFloat2;
/*     */     }
/* 200 */     return paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float randomTriangular(RandomXS128 paramRandomXS128) {
/* 205 */     return paramRandomXS128.nextFloat() - paramRandomXS128.nextFloat();
/*     */   }
/*     */   
/*     */   public static float randomTriangularMax(float paramFloat, RandomXS128 paramRandomXS128) {
/* 209 */     return (paramRandomXS128.nextFloat() - paramRandomXS128.nextFloat()) * paramFloat;
/*     */   }
/*     */   
/*     */   public static float randomTriangularMinMax(float paramFloat1, float paramFloat2, RandomXS128 paramRandomXS128) {
/* 213 */     return randomTriangularMinMaxMode(paramFloat1, paramFloat2, (paramFloat1 + paramFloat2) * 0.5F, paramRandomXS128);
/*     */   }
/*     */   
/*     */   public static float randomTriangularMinMaxMode(float paramFloat1, float paramFloat2, float paramFloat3, RandomXS128 paramRandomXS128) {
/* 217 */     float f1 = paramRandomXS128.nextFloat();
/* 218 */     float f2 = paramFloat2 - paramFloat1;
/* 219 */     if (f1 <= (paramFloat3 - paramFloat1) / f2) return paramFloat1 + (float)StrictMath.sqrt((f1 * f2 * (paramFloat3 - paramFloat1))); 
/* 220 */     return paramFloat2 - (float)StrictMath.sqrt(((1.0F - f1) * f2 * (paramFloat2 - paramFloat3)));
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
/*     */   public static void getBezierCurvePos(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, float paramFloat) {
/* 233 */     float f2 = (paramVector23.x - paramVector22.x) * paramFloat + paramVector22.x;
/* 234 */     float f1 = (paramVector23.y - paramVector22.y) * paramFloat + paramVector22.y;
/*     */     
/* 236 */     paramVector21.x = paramVector24.x;
/* 237 */     paramVector21.y = paramVector24.y;
/* 238 */     paramVector21.sub(paramVector23);
/* 239 */     paramVector21.x *= paramFloat;
/* 240 */     paramVector21.y *= paramFloat;
/* 241 */     paramVector21.add(paramVector23);
/*     */     
/* 243 */     paramVector21.sub(f2, f1);
/* 244 */     paramVector21.x *= paramFloat;
/* 245 */     paramVector21.y *= paramFloat;
/* 246 */     paramVector21.add(f2, f1);
/*     */   }
/*     */   
/*     */   public static void interpolatePoint(Vector2 paramVector21, Vector2 paramVector22, float paramFloat) {
/* 250 */     paramVector21.x += (paramVector22.x - paramVector21.x) * paramFloat;
/* 251 */     paramVector21.y += (paramVector22.y - paramVector21.y) * paramFloat;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static float getDistanceBetweenPoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 256 */     return (float)StrictMath.sqrt(((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static float getDistanceBetweenPoints(Vector2 paramVector21, Vector2 paramVector22) {
/* 261 */     return (float)StrictMath.sqrt(((paramVector21.x - paramVector22.x) * (paramVector21.x - paramVector22.x) + (paramVector21.y - paramVector22.y) * (paramVector21.y - paramVector22.y)));
/*     */   }
/*     */   
/*     */   public static float getSquareDistanceBetweenPoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 265 */     return (paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4);
/*     */   }
/*     */   
/*     */   public static float normalizeAngle(float paramFloat) {
/* 269 */     return (paramFloat % 360.0F + 360.0F) % 360.0F;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static float getAngleBetweenPoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 274 */     return 57.295776F * MathUtils.atan2(paramFloat4 - paramFloat2, paramFloat3 - paramFloat1) - 90.0F;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static float getAngleBetweenPoints(Vector2 paramVector21, Vector2 paramVector22) {
/* 279 */     return 57.295776F * MathUtils.atan2(paramVector22.y - paramVector21.y, paramVector22.x - paramVector21.x) - 90.0F;
/*     */   }
/*     */   
/*     */   public static float getDistanceBetweenAngles(float paramFloat1, float paramFloat2) {
/* 283 */     paramFloat1 = normalizeAngle(paramFloat1);
/*     */ 
/*     */ 
/*     */     
/* 287 */     if ((paramFloat1 = (paramFloat2 = normalizeAngle(paramFloat2)) - paramFloat1) < -180.0F)
/* 288 */       return paramFloat1 + 360.0F; 
/* 289 */     if (paramFloat1 > 180.0F) {
/* 290 */       return paramFloat1 - 360.0F;
/*     */     }
/* 292 */     return paramFloat1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int addWithoutOverflow(int paramInt1, int paramInt2) {
/* 297 */     return willAdditionOverflow(paramInt1, paramInt2) ? Integer.MAX_VALUE : (paramInt1 + paramInt2);
/*     */   }
/*     */   
/*     */   public static int multiplyWithoutOverflow(int paramInt1, int paramInt2) {
/* 301 */     if (paramInt1 < 0 || paramInt2 < 0) throw new IllegalArgumentException("left and right must be positive, " + paramInt1 + " and " + paramInt2 + " given");
/*     */     
/*     */     long l;
/* 304 */     if ((l = paramInt1 * paramInt2) > 2147483647L || l < 0L) {
/* 305 */       return Integer.MAX_VALUE;
/*     */     }
/* 307 */     return paramInt1 * paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean willAdditionOverflow(int paramInt1, int paramInt2) {
/* 312 */     if (paramInt2 < 0 && paramInt2 != Integer.MIN_VALUE) {
/* 313 */       return willSubtractionOverflow(paramInt1, -paramInt2);
/*     */     }
/* 315 */     return (((paramInt1 ^ paramInt2 ^ 0xFFFFFFFF) & (paramInt1 ^ paramInt1 + paramInt2)) < 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean willSubtractionOverflow(int paramInt1, int paramInt2) {
/* 320 */     if (paramInt2 < 0) {
/* 321 */       return willAdditionOverflow(paramInt1, -paramInt2);
/*     */     }
/* 323 */     return (((paramInt1 ^ paramInt2) & (paramInt1 ^ paramInt1 - paramInt2)) < 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void getPointByAngleFromPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Vector2 paramVector2) {
/* 328 */     paramFloat3 = 0.017453292F * paramFloat3;
/* 329 */     paramVector2.x = paramFloat1 + -sin(paramFloat3) * paramFloat4;
/* 330 */     paramVector2.y = paramFloat2 + paramFloat4 * cos(paramFloat3);
/*     */   }
/*     */   
/*     */   public static void shiftPointByAngle(Vector2 paramVector2, float paramFloat1, float paramFloat2) {
/* 334 */     paramFloat1 = 0.017453292F * paramFloat1;
/* 335 */     paramVector2.x += -sin(paramFloat1) * paramFloat2;
/* 336 */     paramVector2.y += paramFloat2 * cos(paramFloat1);
/*     */   }
/*     */   
/*     */   public static boolean circleIntersectsRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 340 */     paramFloat4 = MathUtils.clamp(paramFloat1, paramFloat4, paramFloat4 + paramFloat6);
/* 341 */     paramFloat5 = MathUtils.clamp(paramFloat2, paramFloat5, paramFloat5 + paramFloat7);
/*     */     
/* 343 */     return (StrictMath.pow((paramFloat1 - paramFloat4), 2.0D) + StrictMath.pow((paramFloat2 - paramFloat5), 2.0D) < (paramFloat3 * paramFloat3));
/*     */   }
/*     */   
/*     */   public static boolean circleIntersectsCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 347 */     paramFloat1 -= paramFloat4;
/* 348 */     paramFloat2 -= paramFloat5;
/*     */     
/* 350 */     return ((paramFloat3 + paramFloat6) * (paramFloat3 + paramFloat6) > paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
/*     */   }
/*     */   
/*     */   public static boolean circleIntersectsCircleV(Vector2 paramVector21, float paramFloat1, Vector2 paramVector22, float paramFloat2) {
/* 354 */     return circleIntersectsCircle(paramVector21.x, paramVector21.y, paramFloat1, paramVector22.x, paramVector22.y, paramFloat2);
/*     */   }
/*     */   
/*     */   private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 358 */     if (paramFloat5 == 0.0F) return false; 
/* 359 */     paramFloat1 = paramFloat3 - paramFloat1;
/* 360 */     paramFloat2 = paramFloat4 - paramFloat2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 368 */     return (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= paramFloat5);
/*     */   }
/*     */   
/*     */   public static boolean getLineCircleIntersection(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, float paramFloat, Vector2 paramVector24) {
/* 372 */     return getLineCircleIntersectionFloats(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramVector23.x, paramVector23.y, paramFloat, paramVector24);
/*     */   }
/*     */   
/*     */   public static boolean getLineCircleIntersectionFloats(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, Vector2 paramVector2) {
/* 376 */     if (a(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7)) {
/* 377 */       paramVector2.x = paramFloat1;
/* 378 */       paramVector2.y = paramFloat2;
/* 379 */       return true;
/*     */     } 
/* 381 */     paramFloat3 -= paramFloat1;
/* 382 */     paramFloat4 -= paramFloat2;
/* 383 */     float f1 = paramFloat5 - paramFloat1;
/* 384 */     float f2 = paramFloat6 - paramFloat2;
/* 385 */     float f3 = paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
/* 386 */     float f4 = paramFloat3;
/* 387 */     float f5 = paramFloat4;
/* 388 */     if (f3 > 0.0F) {
/* 389 */       f1 = (f1 * paramFloat3 + f2 * paramFloat4) / f3;
/* 390 */       f4 = paramFloat3 * f1;
/* 391 */       f5 = paramFloat4 * f1;
/*     */     } 
/* 393 */     paramVector2.x = paramFloat1 + f4;
/* 394 */     paramVector2.y = paramFloat2 + f5;
/* 395 */     f1 = f4 * f4 + f5 * f5;
/* 396 */     return (a(paramVector2.x, paramVector2.y, paramFloat5, paramFloat6, paramFloat7) && f1 <= f3 && f4 * paramFloat3 + f5 * paramFloat4 >= 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(int paramInt) {
/* 402 */     return paramInt;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(float paramFloat) {
/* 407 */     return hash(Float.floatToIntBits(paramFloat));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(long paramLong) {
/* 412 */     return hash((int)(paramLong >> 32L) + (int)paramLong);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(String paramString) {
/* 417 */     int i = 1; byte b; int j;
/* 418 */     for (b = 0, j = paramString.length(); b < j; b++) {
/* 419 */       i = i * 31 + hash(paramString.charAt(b));
/*     */     }
/*     */     
/* 422 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(double paramDouble) {
/* 427 */     return hash(Double.doubleToLongBits(paramDouble));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(boolean paramBoolean) {
/* 432 */     return paramBoolean ? 1 : 0;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(Vector2 paramVector2) {
/* 437 */     return hash(paramVector2.x) * 31 + hash(paramVector2.y);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(Enum paramEnum) {
/* 442 */     if (paramEnum == null) return -1; 
/* 443 */     return paramEnum.ordinal();
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(Array[] paramArrayOfArray) {
/* 448 */     int i = 1; int j; byte b;
/* 449 */     for (j = (paramArrayOfArray = paramArrayOfArray).length, b = 0; b < j; ) { Array array = paramArrayOfArray[b];
/* 450 */       i = i * 31 + array.size; b++; }
/*     */     
/* 452 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(boolean[] paramArrayOfboolean) {
/* 457 */     int i = 1; int j; byte b;
/* 458 */     for (j = (paramArrayOfboolean = paramArrayOfboolean).length, b = 0; b < j; ) { boolean bool = paramArrayOfboolean[b];
/* 459 */       i = i * 31 + (bool ? 1 : 0); b++; }
/*     */     
/* 461 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(byte[] paramArrayOfbyte) {
/* 466 */     int i = 1; int j; byte b;
/* 467 */     for (j = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < j; ) { byte b1 = paramArrayOfbyte[b];
/* 468 */       i = i * 31 + b1; b++; }
/*     */     
/* 470 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(int[] paramArrayOfint) {
/* 475 */     int i = 1; int j; byte b;
/* 476 */     for (j = (paramArrayOfint = paramArrayOfint).length, b = 0; b < j; ) { int k = paramArrayOfint[b];
/* 477 */       i = i * 31 + k; b++; }
/*     */     
/* 479 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(IntArray paramIntArray) {
/* 484 */     int i = 1;
/* 485 */     for (byte b = 0; b < paramIntArray.size; b++) {
/* 486 */       i = i * 31 + paramIntArray.items[b];
/*     */     }
/* 488 */     return i;
/*     */   }
/*     */   
/*     */   public static int intHash(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 492 */     int i = 1;
/* 493 */     for (int j = paramInt1; j < paramInt1; j++) {
/* 494 */       i = i * 23 + paramArrayOfbyte[j];
/*     */     }
/* 496 */     return i;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static int hash(float[] paramArrayOffloat) {
/* 501 */     int i = 1; int j; byte b;
/* 502 */     for (j = (paramArrayOffloat = paramArrayOffloat).length, b = 0; b < j; ) { float f = paramArrayOffloat[b];
/* 503 */       i = i * 11 + hash(f); b++; }
/*     */     
/* 505 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int parseUnsignedInt(String paramString, int paramInt) {
/* 510 */     if (paramString == null) {
/* 511 */       throw new NumberFormatException("null");
/*     */     }
/*     */     
/*     */     int i;
/* 515 */     if ((i = paramString.length()) > 0) {
/*     */       char c;
/* 517 */       if ((c = paramString.charAt(0)) == '-') {
/* 518 */         throw new NumberFormatException(
/* 519 */             String.format("Illegal leading minus sign on unsigned string %s.", new Object[] { paramString }));
/*     */       }
/*     */       
/* 522 */       if (i <= 5 || (paramInt == 10 && i <= 9))
/*     */       {
/* 524 */         return Integer.parseInt(paramString, paramInt);
/*     */       }
/*     */       long l;
/* 527 */       if (((l = Long.parseLong(paramString, paramInt)) & 0xFFFFFFFF00000000L) == 0L) {
/* 528 */         return (int)l;
/*     */       }
/* 530 */       throw new NumberFormatException(
/* 531 */           String.format("String value %s exceeds range of unsigned int.", new Object[] { paramString }));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 537 */     throw new IllegalArgumentException("Invalid input: " + paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int hashGameListeners(ListenerGroup paramListenerGroup) {
/* 542 */     int i = 1;
/* 543 */     paramListenerGroup.begin();
/* 544 */     for (byte b = 0; b < paramListenerGroup.size(); b++) {
/*     */       GameListener gameListener;
/* 546 */       if ((gameListener = paramListenerGroup.get(b)).affectsGameState()) {
/* 547 */         i = i * 31 + hash(gameListener.getConstantId());
/*     */       }
/*     */     } 
/* 550 */     paramListenerGroup.end();
/* 551 */     return hash(i);
/*     */   }
/*     */   
/*     */   public static boolean compareFingerprints(String paramString, Enum[] paramArrayOfEnum, byte[] paramArrayOfbyte, Input paramInput) {
/* 555 */     boolean bool = false; int i; byte b;
/* 556 */     for (i = (paramArrayOfEnum = paramArrayOfEnum).length, b = 0; b < i; ) { Enum enum_ = paramArrayOfEnum[b];
/* 557 */       if (paramInput.readByte() != paramArrayOfbyte[enum_.ordinal()]) {
/* 558 */         a.d(enum_.name(), new Object[0]);
/* 559 */         bool = true;
/*     */       } 
/*     */       b++; }
/*     */     
/* 563 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\PMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */