/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.math.RandomXS128;
/*    */ import com.badlogic.gdx.utils.TimeUtils;
/*    */ import com.prineside.tdi2.Game;
/*    */ import java.security.SecureRandom;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FastRandom
/*    */ {
/* 13 */   public static final RandomXS128 random = new RandomXS128();
/*    */   
/* 15 */   private static final float[] a = new float[8192];
/* 16 */   private static int b = 0;
/*    */   static {
/* 18 */     for (byte b = 0; b < ' '; b++) {
/* 19 */       a[b] = random.nextFloat();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static float getFloat() {
/* 27 */     if ((b = b + 1) == 8192) b = 0; 
/* 28 */     return a[b];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long getLongUUID() {
/*    */     long l1;
/*    */     try {
/* 39 */       l1 = (new SecureRandom()).nextInt();
/* 40 */     } catch (Exception exception) {
/* 41 */       l1 = getFairInt(2147483647);
/*    */     } 
/*    */     
/* 44 */     long l2 = Game.getTimestampMillis() / 10L;
/* 45 */     return l1 << 32L | l2 & 0xFFFFFFFFL;
/*    */   }
/*    */   
/*    */   public static int getInt(int paramInt) {
/* 49 */     return (int)(getFloat() * paramInt);
/*    */   }
/*    */   
/*    */   public static float getFairFloat() {
/* 53 */     return random.nextFloat();
/*    */   }
/*    */   
/*    */   public static int getFairInt(int paramInt) {
/* 57 */     return random.nextInt(paramInt);
/*    */   }
/*    */   
/*    */   public static String getDistinguishableString(int paramInt, RandomXS128 paramRandomXS128) {
/* 61 */     if (paramRandomXS128 == null)
/*    */     {
/* 63 */       (paramRandomXS128 = random).setSeed((long)(Math.random() * 9.223372036854776E18D) + TimeUtils.nanoTime());
/*    */     }
/*    */     
/* 66 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/* 67 */     for (byte b = 0; b < paramInt; ) { stringBuilder.append("23456789ABCDEFGHJKLMNPQRSTUVWXYZ".charAt(paramRandomXS128.nextInt(32))); b++; }
/*    */     
/* 69 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String generateUniqueDistinguishableId() {
/* 77 */     String str = StringFormatter.distinguishableString(Game.getTimestampSeconds());
/*    */     
/* 79 */     Random random = new Random();
/* 80 */     random.setState(random.nextLong(), Game.getTimestampMillis());
/*    */     
/* 82 */     return getDistinguishableString(4, random) + "-" + getDistinguishableString(4, random) + "-" + str.substring(str.length() - 6, str.length());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FastRandom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */