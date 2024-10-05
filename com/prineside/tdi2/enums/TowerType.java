/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum TowerType
/*    */ {
/*  8 */   BASIC,
/*  9 */   SNIPER,
/* 10 */   CANNON,
/* 11 */   FREEZING,
/* 12 */   AIR,
/* 13 */   SPLASH,
/* 14 */   BLAST,
/*    */   
/* 16 */   MULTISHOT,
/* 17 */   MINIGUN,
/* 18 */   VENOM,
/* 19 */   TESLA,
/* 20 */   MISSILE,
/* 21 */   FLAMETHROWER,
/* 22 */   LASER,
/* 23 */   GAUSS,
/* 24 */   CRUSHER;
/*    */   
/*    */   public static final TowerType[] values;
/*    */   
/*    */   static {
/* 29 */     values = values();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\TowerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */