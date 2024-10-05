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
/*    */ public final class NumberUtils
/*    */ {
/*    */   public static int floatToIntBits(float paramFloat) {
/* 21 */     return Float.floatToIntBits(paramFloat);
/*    */   }
/*    */   
/*    */   public static int floatToRawIntBits(float paramFloat) {
/* 25 */     return Float.floatToRawIntBits(paramFloat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int floatToIntColor(float paramFloat) {
/*    */     int i;
/* 34 */     return i = (i = Float.floatToRawIntBits(paramFloat)) | (int)((i >>> 24) * 1.003937F) << 24;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static float intToFloatColor(int paramInt) {
/* 41 */     return Float.intBitsToFloat(paramInt & 0xFEFFFFFF);
/*    */   }
/*    */   
/*    */   public static float intBitsToFloat(int paramInt) {
/* 45 */     return Float.intBitsToFloat(paramInt);
/*    */   }
/*    */   
/*    */   public static long doubleToLongBits(double paramDouble) {
/* 49 */     return Double.doubleToLongBits(paramDouble);
/*    */   }
/*    */   
/*    */   public static double longBitsToDouble(long paramLong) {
/* 53 */     return Double.longBitsToDouble(paramLong);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\NumberUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */