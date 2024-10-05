/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class GdxIntArrayComparator extends DeepClassComparator<IntArray> {
/*    */   public final Class<IntArray> forClass() {
/* 10 */     return IntArray.class;
/*    */   }
/*    */   
/*    */   public final void compare(IntArray paramIntArray1, IntArray paramIntArray2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramIntArray1.size != paramIntArray2.size) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramIntArray1.size).append(", ").append(paramIntArray2.size).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramIntArray1.size; b++) {
/* 18 */       paramDeepClassComparisonConfig.addPrefix(new String[] { "[", SyncChecker.toString(b), "]" });
/* 19 */       SyncChecker.compareObjects(Integer.valueOf(paramIntArray1.get(b)), Integer.valueOf(paramIntArray2.get(b)), paramDeepClassComparisonConfig);
/* 20 */       paramDeepClassComparisonConfig.popPrefix(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\GdxIntArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */