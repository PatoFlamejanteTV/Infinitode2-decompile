/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Intersector
/*    */ {
/*    */   public static boolean intersectSegmentRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 12 */     if (intersectSegmentSegment(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat5, paramFloat8)) return true; 
/* 13 */     if (intersectSegmentSegment(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat6)) return true; 
/* 14 */     if (intersectSegmentSegment(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat7, paramFloat6, paramFloat7, paramFloat8)) return true; 
/* 15 */     if (intersectSegmentSegment(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat8, paramFloat7, paramFloat8)) return true;
/*    */ 
/*    */     
/* 18 */     return isPointInRect(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
/*    */   }
/*    */   
/*    */   public static boolean isPointInRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 22 */     return (paramFloat1 >= paramFloat3 && paramFloat1 <= paramFloat5 && paramFloat2 >= paramFloat4 && paramFloat2 <= paramFloat6);
/*    */   }
/*    */   
/*    */   public static boolean rectanglesOverlap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 26 */     return (paramFloat1 < paramFloat7 && paramFloat2 < paramFloat8 && paramFloat3 > paramFloat5 && paramFloat4 > paramFloat6);
/*    */   }
/*    */   
/*    */   public static boolean intersectSegmentSegment(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*    */     float f1;
/* 31 */     if ((f1 = (paramFloat8 - paramFloat6) * (paramFloat3 - paramFloat1) - (paramFloat7 - paramFloat5) * (paramFloat4 - paramFloat2)) == 0.0F) return false;
/*    */     
/* 33 */     float f2 = paramFloat2 - paramFloat6;
/* 34 */     float f3 = paramFloat1 - paramFloat5;
/*    */     
/* 36 */     if ((paramFloat5 = ((paramFloat7 - paramFloat5) * f2 - (paramFloat8 - paramFloat6) * f3) / f1) < 0.0F || paramFloat5 > 1.0F) return false;
/*    */ 
/*    */     
/* 39 */     if ((paramFloat1 = ((paramFloat3 - paramFloat1) * f2 - (paramFloat4 - paramFloat2) * f3) / f1) >= 0.0F && paramFloat1 <= 1.0F) return true;  return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean intersectSegmentCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 45 */     float f1 = paramFloat3 - paramFloat1;
/* 46 */     float f2 = paramFloat4 - paramFloat2;
/*    */ 
/*    */     
/* 49 */     float f3 = paramFloat5 - paramFloat1;
/* 50 */     float f4 = paramFloat6 - paramFloat2;
/*    */ 
/*    */     
/* 53 */     float f5 = (float)Math.sqrt((f1 * f1 + f2 * f2));
/*    */ 
/*    */ 
/*    */     
/* 57 */     float f6 = f1;
/* 58 */     float f7 = f2;
/* 59 */     if (f5 != 0.0F) {
/* 60 */       f6 = f1 / f5;
/* 61 */       f7 = f2 / f5;
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     if ((f1 = f3 * f6 + f4 * f7) <= 0.0F) {
/* 69 */       paramFloat1 = paramFloat1;
/* 70 */       paramFloat2 = paramFloat2;
/* 71 */     } else if (f1 >= f5) {
/* 72 */       paramFloat1 = paramFloat3;
/* 73 */       paramFloat2 = paramFloat4;
/*    */     }
/*    */     else {
/*    */       
/* 77 */       paramFloat1 = f6 * f1 + paramFloat1;
/* 78 */       paramFloat2 = f7 * f1 + paramFloat2;
/*    */     } 
/*    */     
/* 81 */     paramFloat1 = paramFloat5 - paramFloat1;
/* 82 */     paramFloat2 = paramFloat6 - paramFloat2;
/*    */     
/* 84 */     return (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= paramFloat7);
/*    */   }
/*    */   
/*    */   public static boolean intersectSegmentCircleV(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, float paramFloat) {
/* 88 */     return intersectSegmentCircle(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramVector23.x, paramVector23.y, paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\Intersector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */