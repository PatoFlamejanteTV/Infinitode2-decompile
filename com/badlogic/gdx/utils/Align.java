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
/*    */ 
/*    */ 
/*    */ public class Align
/*    */ {
/*    */   public static final int center = 1;
/*    */   public static final int top = 2;
/*    */   public static final int bottom = 4;
/*    */   public static final int left = 8;
/*    */   public static final int right = 16;
/*    */   public static final int topLeft = 10;
/*    */   public static final int topRight = 18;
/*    */   public static final int bottomLeft = 12;
/*    */   public static final int bottomRight = 20;
/*    */   
/*    */   public static final boolean isLeft(int paramInt) {
/* 34 */     return ((paramInt & 0x8) != 0);
/*    */   }
/*    */   
/*    */   public static final boolean isRight(int paramInt) {
/* 38 */     return ((paramInt & 0x10) != 0);
/*    */   }
/*    */   
/*    */   public static final boolean isTop(int paramInt) {
/* 42 */     return ((paramInt & 0x2) != 0);
/*    */   }
/*    */   
/*    */   public static final boolean isBottom(int paramInt) {
/* 46 */     return ((paramInt & 0x4) != 0);
/*    */   }
/*    */   
/*    */   public static final boolean isCenterVertical(int paramInt) {
/* 50 */     return ((paramInt & 0x2) == 0 && (paramInt & 0x4) == 0);
/*    */   }
/*    */   
/*    */   public static final boolean isCenterHorizontal(int paramInt) {
/* 54 */     return ((paramInt & 0x8) == 0 && (paramInt & 0x10) == 0);
/*    */   }
/*    */   
/*    */   public static String toString(int paramInt) {
/* 58 */     StringBuilder stringBuilder = new StringBuilder(13);
/* 59 */     if ((paramInt & 0x2) != 0) {
/* 60 */       stringBuilder.append("top,");
/* 61 */     } else if ((paramInt & 0x4) != 0) {
/* 62 */       stringBuilder.append("bottom,");
/*    */     } else {
/* 64 */       stringBuilder.append("center,");
/* 65 */     }  if ((paramInt & 0x8) != 0) {
/* 66 */       stringBuilder.append("left");
/* 67 */     } else if ((paramInt & 0x10) != 0) {
/* 68 */       stringBuilder.append("right");
/*    */     } else {
/* 70 */       stringBuilder.append("center");
/* 71 */     }  return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Align.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */