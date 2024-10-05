/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class ShortArrayComparator
/*    */   extends DeepClassComparator<short[]> {
/*    */   public final Class<short[]> forClass() {
/*  9 */     return short[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(short[] paramArrayOfshort1, short[] paramArrayOfshort2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOfshort1.length != paramArrayOfshort2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfshort1.length).append(", ").append(paramArrayOfshort2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOfshort1.length; b++) {
/* 18 */       if (paramArrayOfshort1[b] != paramArrayOfshort2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOfshort1[b]).append(" != ").append(paramArrayOfshort2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ShortArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */