/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum TileType
/*    */ {
/*  8 */   ROAD,
/*  9 */   SPAWN,
/* 10 */   TARGET,
/* 11 */   PLATFORM,
/* 12 */   SOURCE,
/* 13 */   XM_MUSIC_TRACK,
/* 14 */   CORE,
/* 15 */   BOSS,
/* 16 */   GAME_VALUE,
/* 17 */   SCRIPT,
/* 18 */   DUMMY,
/* 19 */   QUAD,
/* 20 */   EQUALIZER;
/*    */   static {
/* 22 */     values = values();
/*    */   }
/*    */   
/*    */   public static final TileType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\TileType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */