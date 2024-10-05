/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum ModifierType {
/*  7 */   BALANCE,
/*  8 */   SEARCH,
/*  9 */   POWER,
/* 10 */   DAMAGE,
/* 11 */   ATTACK_SPEED,
/* 12 */   MINING_SPEED,
/* 13 */   BOUNTY,
/* 14 */   EXPERIENCE;
/*    */   static {
/* 16 */     values = values();
/*    */   }
/*    */   
/*    */   public static ModifierType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\ModifierType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */