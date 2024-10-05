/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class Vector2Comparator extends DeepClassComparator<Vector2> {
/*    */   public final Class<Vector2> forClass() {
/*  9 */     return Vector2.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(Vector2 paramVector21, Vector2 paramVector22, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramVector21.x != paramVector22.x) paramDeepClassComparisonConfig.appendPrefix().append(".x: ").append(paramVector21.x).append(" != ").append(paramVector22.x).append("\n"); 
/* 15 */     if (paramVector21.y != paramVector22.y) paramDeepClassComparisonConfig.appendPrefix().append(".y: ").append(paramVector21.y).append(" != ").append(paramVector22.y).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\Vector2Comparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */