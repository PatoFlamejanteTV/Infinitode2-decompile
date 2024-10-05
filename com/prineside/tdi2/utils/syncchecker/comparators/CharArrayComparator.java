/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class CharArrayComparator
/*    */   extends DeepClassComparator<char[]> {
/*    */   public final Class<char[]> forClass() {
/*  9 */     return char[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(char[] paramArrayOfchar1, char[] paramArrayOfchar2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOfchar1.length != paramArrayOfchar2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfchar1.length).append(", ").append(paramArrayOfchar2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOfchar1.length; b++) {
/* 18 */       if (paramArrayOfchar1[b] != paramArrayOfchar2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOfchar1[b]).append(" != ").append(paramArrayOfchar2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\CharArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */