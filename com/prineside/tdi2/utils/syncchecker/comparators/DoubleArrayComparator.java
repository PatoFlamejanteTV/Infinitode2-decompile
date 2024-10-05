/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class DoubleArrayComparator
/*    */   extends DeepClassComparator<double[]> {
/*    */   public final Class<double[]> forClass() {
/*  9 */     return double[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOfdouble1.length != paramArrayOfdouble2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfdouble1.length).append(", ").append(paramArrayOfdouble2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOfdouble1.length; b++) {
/* 18 */       if (paramArrayOfdouble1[b] != paramArrayOfdouble2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOfdouble1[b]).append(" != ").append(paramArrayOfdouble2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\DoubleArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */