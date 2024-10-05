/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.CheatSafeInt;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class CheatSafeIntComparator extends DeepClassComparator<CheatSafeInt> {
/*    */   public final Class<CheatSafeInt> forClass() {
/*  9 */     return CheatSafeInt.class;
/*    */   }
/*    */   
/*    */   public final void compare(CheatSafeInt paramCheatSafeInt1, CheatSafeInt paramCheatSafeInt2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramCheatSafeInt1.get() != paramCheatSafeInt2.get())
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": ").append(paramCheatSafeInt1.get()).append(" != ").append(paramCheatSafeInt2.get()).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\CheatSafeIntComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */