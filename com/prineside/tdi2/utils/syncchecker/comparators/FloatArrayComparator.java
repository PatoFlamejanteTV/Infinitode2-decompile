/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class FloatArrayComparator
/*    */   extends DeepClassComparator<float[]> {
/*    */   public final Class<float[]> forClass() {
/*  9 */     return float[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(float[] paramArrayOffloat1, float[] paramArrayOffloat2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOffloat1.length != paramArrayOffloat2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOffloat1.length).append(", ").append(paramArrayOffloat2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOffloat1.length; b++) {
/* 18 */       if (paramArrayOffloat1[b] != paramArrayOffloat2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOffloat1[b]).append(" != ").append(paramArrayOffloat2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\FloatArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */