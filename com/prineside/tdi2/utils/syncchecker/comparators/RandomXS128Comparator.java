/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.math.RandomXS128;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class RandomXS128Comparator extends DeepClassComparator<RandomXS128> {
/*    */   public final Class<RandomXS128> forClass() {
/*  9 */     return RandomXS128.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(RandomXS128 paramRandomXS1281, RandomXS128 paramRandomXS1282, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramRandomXS1281.getState(0) != paramRandomXS1282.getState(0)) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": seed 0 differ (").append(paramRandomXS1281.getState(0)).append(", ").append(paramRandomXS1282.getState(0)).append(")\n"); return;
/* 16 */     }  if (paramRandomXS1281.getState(1) != paramRandomXS1282.getState(1))
/* 17 */       paramDeepClassComparisonConfig.appendPrefix().append(": seed 1 differ (").append(paramRandomXS1281.getState(1)).append(", ").append(paramRandomXS1282.getState(1)).append(")\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\RandomXS128Comparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */