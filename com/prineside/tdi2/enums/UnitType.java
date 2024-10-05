/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public enum UnitType {
/*  7 */   SNOWBALL,
/*  8 */   BALL_LIGHTNING,
/*  9 */   DISORIENTED,
/* 10 */   MICROGUN,
/* 11 */   MINE,
/* 12 */   ICE_FIELD;
/*    */   static {
/* 14 */     values = values();
/*    */   }
/*    */   
/*    */   public static final UnitType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\UnitType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */