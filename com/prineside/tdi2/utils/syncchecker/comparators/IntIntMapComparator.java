/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntIntMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class IntIntMapComparator extends DeepClassComparator<IntIntMap> {
/*    */   public final Class<IntIntMap> forClass() {
/*  9 */     return IntIntMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(IntIntMap paramIntIntMap1, IntIntMap paramIntIntMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramIntIntMap1.size != paramIntIntMap2.size) {
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIntIntMap1.size).append(" != ").append(paramIntIntMap2.size).append("\n");
/*    */     }
/*    */     
/* 17 */     for (IntIntMap.Entry entry : paramIntIntMap1) {
/* 18 */       if (!paramIntIntMap2.containsKey(entry.key)) {
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(entry.key).append("]: key not exists\n"); continue;
/*    */       } 
/* 21 */       if (entry.value != paramIntIntMap2.get(entry.key, 0))
/* 22 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(entry.key).append("]: ").append(entry.value).append(" != ").append(paramIntIntMap2.get(entry.key, 0)).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IntIntMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */