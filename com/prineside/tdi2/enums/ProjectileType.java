/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum ProjectileType {
/*  7 */   BASIC,
/*  8 */   AIR,
/*  9 */   CANNON,
/* 10 */   SPLINTER,
/* 11 */   SPLASH,
/* 12 */   VENOM,
/* 13 */   CHAIN_LIGHTNING,
/* 14 */   MISSILE,
/* 15 */   LASER,
/* 16 */   MULTISHOT,
/* 17 */   BULLET_WALL,
/* 18 */   BUFF;
/*    */   static {
/* 20 */     values = values();
/*    */   }
/*    */   
/*    */   public static ProjectileType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\ProjectileType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */