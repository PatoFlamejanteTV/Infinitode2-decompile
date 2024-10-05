/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum DifficultyMode {
/*  7 */   EASY,
/*  8 */   NORMAL,
/*  9 */   ENDLESS_I;
/*    */   
/*    */   public static final DifficultyMode[] values;
/*    */   
/*    */   public static boolean hasSpecialResources(DifficultyMode paramDifficultyMode) {
/* 14 */     return (paramDifficultyMode != EASY && paramDifficultyMode != NORMAL);
/*    */   }
/*    */   
/*    */   public static boolean isEndless(DifficultyMode paramDifficultyMode) {
/* 18 */     return (paramDifficultyMode != EASY && paramDifficultyMode != NORMAL);
/*    */   }
/*    */   static {
/* 21 */     values = values();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\DifficultyMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */