/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.FloatArray;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class GdxFloatArrayComparator extends DeepClassComparator<FloatArray> {
/*    */   public final Class<FloatArray> forClass() {
/* 10 */     return FloatArray.class;
/*    */   }
/*    */   
/*    */   public final void compare(FloatArray paramFloatArray1, FloatArray paramFloatArray2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramFloatArray1.size != paramFloatArray2.size) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramFloatArray1.size).append(", ").append(paramFloatArray2.size).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramFloatArray1.size; b++) {
/* 18 */       paramDeepClassComparisonConfig.addPrefix(new String[] { "[", SyncChecker.toString(b), "]" });
/* 19 */       SyncChecker.compareObjects(Float.valueOf(paramFloatArray1.get(b)), Float.valueOf(paramFloatArray2.get(b)), paramDeepClassComparisonConfig);
/* 20 */       paramDeepClassComparisonConfig.popPrefix(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\GdxFloatArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */