/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum SpecialDamageType {
/*  7 */   KILLSHOT,
/*  8 */   INSTAKILL,
/*  9 */   MISSILE_FIRST_DAMAGE,
/* 10 */   PIERCING,
/* 11 */   CHAINING,
/* 12 */   NANOPARTICLES;
/*    */   static {
/* 14 */     values = values();
/*    */   }
/*    */   
/*    */   public static final SpecialDamageType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\SpecialDamageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */