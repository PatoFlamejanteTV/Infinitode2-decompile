/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum ShapeType {
/*  7 */   MULTI_LINE,
/*  8 */   STRAIGHT_MULTI_LINE,
/*  9 */   TRAIL_MULTI_LINE,
/* 10 */   BULLET_SMOKE_MULTI_LINE,
/* 11 */   CIRCLE,
/* 12 */   PIE_CHART,
/* 13 */   CHAIN_LIGHTNING,
/* 14 */   RANGE_CIRCLE;
/*    */   static {
/* 16 */     values = values();
/*    */   }
/*    */   
/*    */   public static final ShapeType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\ShapeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */