/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TimeUtils
/*    */ {
/*    */   private static final long nanosPerMilli = 1000000L;
/*    */   
/*    */   public static long nanoTime() {
/* 24 */     return System.nanoTime();
/*    */   }
/*    */ 
/*    */   
/*    */   public static long millis() {
/* 29 */     return System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nanosToMillis(long paramLong) {
/* 38 */     return paramLong / 1000000L;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long millisToNanos(long paramLong) {
/* 45 */     return paramLong * 1000000L;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long timeSinceNanos(long paramLong) {
/* 52 */     return nanoTime() - paramLong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long timeSinceMillis(long paramLong) {
/* 59 */     return millis() - paramLong;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\TimeUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */