/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class ObjectArrayComparator
/*    */   extends DeepClassComparator<Object[]> {
/*    */   public final Class<Object[]> forClass() {
/* 10 */     return Object[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 15 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
/* 16 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfObject1.length).append(", ").append(paramArrayOfObject2.length).append(")\n"); return;
/*    */     } 
/* 18 */     for (byte b = 0; b < paramArrayOfObject1.length; b++) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 23 */       String str = (paramArrayOfObject1[b] != null) ? paramArrayOfObject1[b].getClass().getSimpleName() : ((paramArrayOfObject2[b] != null) ? paramArrayOfObject2[b].getClass().getSimpleName() : "?");
/*    */       
/* 25 */       paramDeepClassComparisonConfig.addPrefix(new String[] { "[", (paramDeepClassComparisonConfig.keyEnum == null) ? SyncChecker.toString(b) : paramDeepClassComparisonConfig.keyEnum[b].name(), ":", str, "]" });
/* 26 */       SyncChecker.compareObjects(paramArrayOfObject1[b], paramArrayOfObject2[b], paramDeepClassComparisonConfig);
/* 27 */       paramDeepClassComparisonConfig.popPrefix(5);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ObjectArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */