/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class GdxArrayComparator extends DeepClassComparator<Array> {
/*    */   public final Class<Array> forClass() {
/* 10 */     return Array.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(Array paramArray1, Array paramArray2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 15 */     if (paramArray1.size != paramArray2.size) {
/* 16 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArray1.size).append(", ").append(paramArray2.size).append(")\n"); return;
/*    */     } 
/* 18 */     for (byte b = 0; b < paramArray1.size; b++) {
/*    */ 
/*    */       
/* 21 */       String str = (paramArray1.get(b) != null) ? paramArray1.get(b).getClass().getSimpleName() : ((paramArray2.get(b) != null) ? paramArray2.get(b).getClass().getSimpleName() : "?");
/*    */       
/* 23 */       paramDeepClassComparisonConfig.addPrefix(new String[] { "[", SyncChecker.toString(b), " ", str, "]" });
/* 24 */       SyncChecker.compareObjects(paramArray1.get(b), paramArray2.get(b), paramDeepClassComparisonConfig);
/* 25 */       paramDeepClassComparisonConfig.popPrefix(5);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\GdxArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */