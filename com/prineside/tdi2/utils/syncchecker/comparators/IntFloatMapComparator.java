/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntFloatMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class IntFloatMapComparator extends DeepClassComparator<IntFloatMap> {
/*    */   public final Class<IntFloatMap> forClass() {
/*  9 */     return IntFloatMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(IntFloatMap paramIntFloatMap1, IntFloatMap paramIntFloatMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramIntFloatMap1.size != paramIntFloatMap2.size) {
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIntFloatMap1.size).append(" != ").append(paramIntFloatMap2.size).append("\n");
/*    */     }
/*    */     
/* 17 */     for (IntFloatMap.Entry entry : paramIntFloatMap1) {
/* 18 */       if (!paramIntFloatMap2.containsKey(entry.key)) {
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(entry.key).append("]: key not exists\n"); continue;
/*    */       } 
/* 21 */       if (entry.value != paramIntFloatMap2.get(entry.key, 0.0F))
/* 22 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(entry.key).append("]: ").append(entry.value).append(" != ").append(paramIntFloatMap2.get(entry.key, 0.0F)).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IntFloatMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */