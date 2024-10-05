/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class BooleanArrayComparator
/*    */   extends DeepClassComparator<boolean[]> {
/*    */   public final Class<boolean[]> forClass() {
/*  9 */     return boolean[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOfboolean1.length != paramArrayOfboolean2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfboolean1.length).append(", ").append(paramArrayOfboolean2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOfboolean1.length; b++) {
/* 18 */       if (paramArrayOfboolean1[b] != paramArrayOfboolean2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOfboolean1[b]).append(" != ").append(paramArrayOfboolean2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\BooleanArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */