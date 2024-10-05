/*    */ package com.d.h.a;
/*    */ 
/*    */ import java.awt.geom.Point2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */ {
/*    */   public final Point2D.Float a;
/*    */   public final Point2D.Float b;
/*    */   public final Point2D.Float c;
/*    */   
/*    */   b(Point2D.Float paramFloat1, Point2D.Float paramFloat2, Point2D.Float paramFloat3) {
/* 20 */     this.a = paramFloat1;
/* 21 */     this.b = paramFloat2;
/* 22 */     this.c = paramFloat3;
/*    */   }
/*    */   
/*    */   public static boolean a(Point2D.Float paramFloat1, Point2D.Float paramFloat2, Point2D.Float paramFloat3, Point2D.Float paramFloat4) {
/* 26 */     paramFloat2 = new Point2D.Float(paramFloat2.x - paramFloat1.x, paramFloat2.y - paramFloat1.y);
/* 27 */     paramFloat3 = new Point2D.Float(paramFloat3.x - paramFloat1.x, paramFloat3.y - paramFloat1.y);
/*    */     
/* 29 */     double d1 = (paramFloat2.x * paramFloat3.y - paramFloat3.x * paramFloat2.y);
/*    */     
/* 31 */     double d2 = ((paramFloat1 = new Point2D.Float(paramFloat4.x - paramFloat1.x, paramFloat4.y - paramFloat1.y)).x * paramFloat3.y - paramFloat3.x * paramFloat1.y) / d1;
/* 32 */     double d3 = (paramFloat2.x * paramFloat1.y - paramFloat1.x * paramFloat2.y) / d1;
/*    */     
/* 34 */     return (d2 > 0.0D && d3 > 0.0D && d2 + d3 < 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */