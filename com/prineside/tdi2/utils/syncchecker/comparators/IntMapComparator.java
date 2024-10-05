/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class IntMapComparator extends DeepClassComparator<IntMap> {
/*    */   public final Class<IntMap> forClass() {
/* 10 */     return IntMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(IntMap paramIntMap1, IntMap paramIntMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramIntMap1.size != paramIntMap2.size) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIntMap1.size).append(" != ").append(paramIntMap2.size).append("\n");
/*    */     }
/*    */     
/* 18 */     IntMap.Keys keys = paramIntMap1.keys();
/* 19 */     while (keys.hasNext) {
/* 20 */       int i = keys.next();
/* 21 */       if (!paramIntMap2.containsKey(i)) {
/* 22 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(i).append("]: key not exists (object: ").append(paramIntMap1.get(i).getClass().getName()).append(")\n"); continue;
/*    */       } 
/* 24 */       Object object1 = paramIntMap1.get(i);
/* 25 */       Object object2 = paramIntMap2.get(i);
/*    */       
/* 27 */       paramDeepClassComparisonConfig.addPrefix(new String[] { "[", SyncChecker.toString(i), " ", object1.getClass().getName(), "]" });
/* 28 */       SyncChecker.compareObjects(object1, object2, paramDeepClassComparisonConfig);
/* 29 */       paramDeepClassComparisonConfig.popPrefix(5);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IntMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */