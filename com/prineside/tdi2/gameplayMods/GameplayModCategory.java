/*    */ package com.prineside.tdi2.gameplayMods;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum GameplayModCategory {
/*  7 */   OTHER,
/*  8 */   OFFENSIVE,
/*  9 */   DEFENSIVE,
/* 10 */   LOOTING,
/* 11 */   ECONOMICS; static {
/* 12 */     values = values();
/*    */   }
/*    */   
/*    */   public static final GameplayModCategory[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\GameplayModCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */