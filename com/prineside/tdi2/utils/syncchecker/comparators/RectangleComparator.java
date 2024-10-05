/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.math.Rectangle;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class RectangleComparator extends DeepClassComparator<Rectangle> {
/*    */   public final Class<Rectangle> forClass() {
/*  9 */     return Rectangle.class;
/*    */   }
/*    */   
/*    */   public final void compare(Rectangle paramRectangle1, Rectangle paramRectangle2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramRectangle1.x != paramRectangle2.x) paramDeepClassComparisonConfig.appendPrefix().append(".x: ").append(paramRectangle1.x).append(" != ").append(paramRectangle2.x).append("\n"); 
/* 14 */     if (paramRectangle1.y != paramRectangle2.y) paramDeepClassComparisonConfig.appendPrefix().append(".y: ").append(paramRectangle1.y).append(" != ").append(paramRectangle2.y).append("\n"); 
/* 15 */     if (paramRectangle1.width != paramRectangle2.width) paramDeepClassComparisonConfig.appendPrefix().append(".width: ").append(paramRectangle1.width).append(" != ").append(paramRectangle2.width).append("\n"); 
/* 16 */     if (paramRectangle1.height != paramRectangle2.height) paramDeepClassComparisonConfig.appendPrefix().append(".height: ").append(paramRectangle1.height).append(" != ").append(paramRectangle2.height).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\RectangleComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */