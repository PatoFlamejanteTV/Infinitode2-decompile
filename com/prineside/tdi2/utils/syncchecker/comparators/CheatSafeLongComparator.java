/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.CheatSafeLong;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class CheatSafeLongComparator extends DeepClassComparator<CheatSafeLong> {
/*    */   public final Class<CheatSafeLong> forClass() {
/*  9 */     return CheatSafeLong.class;
/*    */   }
/*    */   
/*    */   public final void compare(CheatSafeLong paramCheatSafeLong1, CheatSafeLong paramCheatSafeLong2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramCheatSafeLong1.get() != paramCheatSafeLong2.get())
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": ").append(paramCheatSafeLong1.get()).append(" != ").append(paramCheatSafeLong2.get()).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\CheatSafeLongComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */