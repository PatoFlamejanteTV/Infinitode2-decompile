/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public enum AbilityType {
/*  7 */   FIREBALL,
/*  8 */   BLIZZARD,
/*  9 */   WINDSTORM,
/* 10 */   THUNDER,
/* 11 */   SMOKE_BOMB,
/* 12 */   FIRESTORM,
/* 13 */   MAGNET,
/* 14 */   BULLET_WALL,
/* 15 */   BALL_LIGHTNING,
/* 16 */   LOIC,
/* 17 */   NUKE,
/* 18 */   OVERLOAD,
/* 19 */   LOOP;
/*    */   static {
/* 21 */     values = values();
/*    */   }
/*    */   
/*    */   public static final AbilityType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\AbilityType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */