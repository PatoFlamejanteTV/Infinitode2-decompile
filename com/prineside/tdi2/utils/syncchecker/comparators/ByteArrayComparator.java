/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class ByteArrayComparator
/*    */   extends DeepClassComparator<byte[]> {
/*    */   public final Class<byte[]> forClass() {
/*  9 */     return byte[].class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 14 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length) {
/* 15 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes differ (").append(paramArrayOfbyte1.length).append(", ").append(paramArrayOfbyte2.length).append(")\n"); return;
/*    */     } 
/* 17 */     for (byte b = 0; b < paramArrayOfbyte1.length; b++) {
/* 18 */       if (paramArrayOfbyte1[b] != paramArrayOfbyte2[b])
/* 19 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(String.valueOf((paramDeepClassComparisonConfig.keyEnum == null) ? Integer.valueOf(b) : paramDeepClassComparisonConfig.keyEnum[b].name())).append("] ").append(paramArrayOfbyte1[b]).append(" != ").append(paramArrayOfbyte2[b]).append("\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ByteArrayComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */