/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public enum BossType {
/*  7 */   BROOT,
/*  8 */   SNAKE,
/*  9 */   CONSTRUCTOR,
/* 10 */   MOBCHAIN,
/* 11 */   METAPHOR;
/*    */   static {
/* 13 */     values = values();
/*    */   }
/*    */   
/*    */   public static final BossType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\BossType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */