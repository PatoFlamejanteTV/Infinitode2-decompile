/*    */ package com.prineside.tdi2.pathfinding;public final class PathSegmentForRendering { public float x1; public float y1; public float x2;
/*    */   public float y2;
/*    */   public float distanceFromStart;
/*    */   public float length;
/*    */   public Direction direction;
/*    */   
/*  7 */   public enum Direction { TOP,
/*  8 */     LEFT,
/*  9 */     RIGHT,
/* 10 */     BOTTOM; }
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
/*    */   public static Direction getDirection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 23 */     if ((paramFloat1 = PMath.normalizeAngle(PMath.getAngleBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4))) < 45.0F || paramFloat1 > 315.0F)
/* 24 */       return Direction.TOP; 
/* 25 */     if (paramFloat1 >= 45.0F && paramFloat1 < 135.0F)
/* 26 */       return Direction.LEFT; 
/* 27 */     if (paramFloat1 >= 135.0F && paramFloat1 < 225.0F) {
/* 28 */       return Direction.BOTTOM;
/*    */     }
/* 30 */     return Direction.RIGHT;
/*    */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\PathSegmentForRendering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */