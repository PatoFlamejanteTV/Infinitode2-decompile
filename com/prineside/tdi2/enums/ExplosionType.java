/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum ExplosionType {
/*  7 */   CANNON,
/*  8 */   MISSILE,
/*  9 */   AIR_FALL,
/* 10 */   FIREBALL,
/* 11 */   GENERIC;
/*    */   static {
/* 13 */     values = values();
/*    */   }
/*    */   
/*    */   public static final ExplosionType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\ExplosionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */