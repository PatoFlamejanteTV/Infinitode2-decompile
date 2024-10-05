/*    */ package com.prineside.tdi2.configs;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GameRenderingOrder
/*    */ {
/*  9 */   private static int a = 0;
/*    */ 
/*    */   
/*    */   public static final int AFTER_PERCENT = 1;
/*    */ 
/*    */   
/*    */   public static final int BEFORE_PERCENT = -1;
/*    */   
/*    */   public static final int STEP = 100;
/*    */   
/* 19 */   public static final int MAP_DRAW_TILES = 100 * a++;
/* 20 */   public static final int MAP_DRAW_STAINS = 100 * a++;
/* 21 */   public static final int MAP_DRAW_TILE_EXTRAS = 100 * a++;
/* 22 */   public static final int MAP_DRAW_BATCH = 100 * a++;
/* 23 */   public static final int MAP_DRAW_BUILDINGS_CACHE = 100 * a++;
/* 24 */   public static final int TOWER_APPLY_INTERPOLATION = 100 * a++;
/* 25 */   public static final int TOWER_DRAW_WEAPONS = 100 * a++;
/* 26 */   public static final int TOWER_DRAW_BATCH = 100 * a++;
/* 27 */   public static final int MINER_DRAW_BATCH = 100 * a++;
/* 28 */   public static final int MODIFIER_DRAW_BATCH = 100 * a++;
/* 29 */   public static final int PATH_RENDERING_DRAW = 100 * a++;
/* 30 */   public static final int OVERLOAD_IMPULSE_UPDATE_GRAPHICS = 100 * a++;
/* 31 */   public static final int PROJECTILE_TRAIL_UPDATE_DRAW = 100 * a++;
/* 32 */   public static final int PROJECTILE_TRAIL_DRAW_OPAQUE = 100 * a++;
/* 33 */   public static final int OVERLOAD_IMPULSE_DRAW = 100 * a++;
/* 34 */   public static final int UNIT_DRAW_GROUNDED = 100 * a++;
/* 35 */   public static final int ENEMY_DRAW = 100 * a++;
/* 36 */   public static final int WAVE_DRAW = 100 * a++;
/* 37 */   public static final int UNIT_DRAW_FLYING = 100 * a++;
/* 38 */   public static final int TOWER_DRAW_BATCH_ADDITIVE = 100 * a++;
/* 39 */   public static final int MODIFIER_DRAW_BATCH_ADDITIVE = 100 * a++;
/* 40 */   public static final int ABILITY_DRAW_BATCH_ADDITIVE = 100 * a++;
/* 41 */   public static final int PARTICLE_UPDATE_DRAW = 100 * a++;
/*    */   
/* 43 */   public static final int EFFECTS_FBO_START = 100 * a++;
/*    */   
/* 45 */   public static final int PARTICLE_DRAW = 100 * a++;
/* 46 */   public static final int PROJECTILE_TRAIL_DRAW = 100 * a++;
/* 47 */   public static final int PROJECTILE_DRAW = 100 * a++;
/*    */   
/* 49 */   public static final int EFFECTS_FBO_END = 100 * a++;
/*    */   
/* 51 */   public static final int MAP_DRAW = 100 * a++;
/* 52 */   public static final int TOWER_DRAW_RANGES = 100 * a++;
/* 53 */   public static final int MAP_RENDERING_POST_DRAW = 100 * a++;
/* 54 */   public static final int MAP_RENDERING_GAME_SELECTION = 100 * a++;
/* 55 */   public static final int MAP_RENDERING_MAP_EDITOR_SELECTION = 100 * a++;
/* 56 */   public static final int HOT_KEY_DRAW_CURSOR = 100 * a++;
/* 57 */   public static final int ABILITY_DRAW_BATCH = 100 * a++;
/* 58 */   public static final int ENEMY_DRAW_HEALTH = 100 * a++;
/* 59 */   public static final int PARTICLE_DRAW_DAMAGE = 100 * a++;
/* 60 */   public static final int INPUT_DRAW = 100 * a++;
/* 61 */   public static final int QUEST_DRAW = 100 * a++;
/* 62 */   public static final int GAME_UI_DRAW = 100 * a++;
/* 63 */   public static final int SOUND_DRAW = 100 * a++;
/*    */   
/* 65 */   public static final int DEBUG_DPS_CHART_DRAW = 100 * a++;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\configs\GameRenderingOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */