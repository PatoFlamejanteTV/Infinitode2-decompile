/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class LongArrayComparator
/*    */   extends DeepClassComparator<long[]> {
/*    */   public final Class<long[]> forClass() {
/*  9 */     return long[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(long[] paramArrayOflong1, long[] paramArrayOflong2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOflong1.length != paramArrayOflong2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOflong1.length).append(", ").append(paramArrayOflong2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOflong1.length; b++) {
/* 18 */       if (paramArrayOflong1[b] != paramArrayOflong2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOflong1[b]).append(" != ").append(paramArrayOflong2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\LongArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */