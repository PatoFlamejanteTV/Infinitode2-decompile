/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum RarityType {
/*  7 */   COMMON,
/*  8 */   RARE,
/*  9 */   VERY_RARE,
/* 10 */   EPIC,
/* 11 */   LEGENDARY;
/*    */   static {
/* 13 */     values = values();
/*    */   }
/*    */   
/*    */   public static final RarityType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\RarityType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */