/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Graphics;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.g3d.Model;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.ByteArray;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Settings;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.TextInputOverlay;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @REGS(serializer = SettingsManager.Serializer.class)
/*      */ public class SettingsManager
/*      */   extends Manager.ManagerAdapter
/*      */ {
/*      */   private static final TLog a;
/*      */   private final String[] b;
/*      */   private final String[] c;
/*      */   private final String[] d;
/*      */   private int e;
/*      */   private int[] f;
/*      */   
/*      */   public SettingsManager() {
/*   61 */     this.b = new String[(DynamicSetting.values()).length];
/*   62 */     this.c = new String[(DynamicSetting.values()).length];
/*      */ 
/*      */     
/*   65 */     this.c[DynamicSetting.IAP_DOUBLE_GAIN_ENABLED.ordinal()] = "true";
/*   66 */     this.c[DynamicSetting.IAP_GREEN_PAPER_ENABLED.ordinal()] = "true";
/*   67 */     this.c[DynamicSetting.IAP_ACCELERATOR_ENABLED.ordinal()] = "true";
/*   68 */     this.c[DynamicSetting.IAP_OFFERS.ordinal()] = "";
/*   69 */     this.c[DynamicSetting.IOS_OKJOY_SECRET_CODE_ENABLED.ordinal()] = "false";
/*   70 */     this.c[DynamicSetting.ADS_ENABLED.ordinal()] = "true";
/*   71 */     this.c[DynamicSetting.WIKI_URL.ordinal()] = "https://infinitode-2.wikia.com";
/*   72 */     this.c[DynamicSetting.IAP_GREEN_PAPER_MAX_PER_HOUR.ordinal()] = "1000000";
/*   73 */     this.c[DynamicSetting.MULTIPLAYER_TEST_ENDPOINT.ordinal()] = "null";
/*   74 */     this.c[DynamicSetting.REWARDING_ADS_MODE.ordinal()] = "admob,appodeal";
/*      */     
/*   76 */     System.arraycopy(this.c, 0, this.b, 0, this.b.length);
/*      */     
/*   78 */     this.d = new String[(DynamicSetting.values()).length];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  159 */     this.e = -1;
/*      */     
/*  161 */     this.g = new IntArray();
/*  162 */     this.h = new IntArray();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  370 */     this.j = new DelayedRemovalArray(false, 1);
/*      */   }
/*      */   private IntArray g; private IntArray h; public static final int[][] DEFAULT_HOT_KEYS; private static final Array<HotkeyAction> i; private final DelayedRemovalArray<SettingsManagerListener> j; static { a = TLog.forClass(SettingsManager.class); (new int[1])[0] = 62; (DEFAULT_HOT_KEYS = new int[HotkeyAction.values.length][])[HotkeyAction.CALL_WAVE.ordinal()] = new int[1]; (new int[2])[0] = 129; (new int[2])[1] = 62; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_AUTO_WAVE_CALL.ordinal()] = new int[2]; (new int[1])[0] = 44; DEFAULT_HOT_KEYS[HotkeyAction.PAUSE_GAME.ordinal()] = new int[1]; (new int[1])[0] = 72; DEFAULT_HOT_KEYS[HotkeyAction.SPEED_UP.ordinal()] = new int[1]; (new int[1])[0] = 71; DEFAULT_HOT_KEYS[HotkeyAction.SPEED_DOWN.ordinal()] = new int[1]; (new int[1])[0] = 41; DEFAULT_HOT_KEYS[HotkeyAction.SWITCH_DRAW_MODE.ordinal()] = new int[1]; (new int[1])[0] = 61; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_TILE_MENU.ordinal()] = new int[1]; (new int[1])[0] = 7; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_QUEST_LIST.ordinal()] = new int[1]; (new int[1])[0] = 69; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_STATS_PANE.ordinal()] = new int[1]; (new int[1])[0] = 40; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_LEADERBOARD.ordinal()] = new int[1]; (new int[1])[0] = 131; DEFAULT_HOT_KEYS[HotkeyAction.ZOOM_1X.ordinal()] = new int[1]; (new int[1])[0] = 132; DEFAULT_HOT_KEYS[HotkeyAction.ZOOM_FIT_MAP.ordinal()] = new int[1]; (new int[1])[0] = 121; DEFAULT_HOT_KEYS[HotkeyAction.PANIC.ordinal()] = new int[1]; (new int[1])[0] = 54; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_1.ordinal()] = new int[1]; (new int[1])[0] = 52; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_2.ordinal()] = new int[1]; (new int[1])[0] = 29; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_3.ordinal()] = new int[1]; (new int[1])[0] = 47; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_4.ordinal()] = new int[1]; (new int[1])[0] = 45; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_5.ordinal()] = new int[1]; (new int[1])[0] = 51; DEFAULT_HOT_KEYS[HotkeyAction.ABILITY_6.ordinal()] = new int[1]; (new int[1])[0] = 59; DEFAULT_HOT_KEYS[HotkeyAction.UPGRADE_BUILDING.ordinal()] = new int[1]; (new int[1])[0] = 123; DEFAULT_HOT_KEYS[HotkeyAction.TOGGLE_TOWER_ENABLED.ordinal()] = new int[1]; (new int[2])[0] = 129; (new int[2])[1] = 59; DEFAULT_HOT_KEYS[HotkeyAction.UPGRADE_ALL_BUILDINGS.ordinal()] = new int[2]; (new int[1])[0] = 67; DEFAULT_HOT_KEYS[HotkeyAction.SELL_BUILDING.ordinal()] = new int[1]; (new int[1])[0] = 55; DEFAULT_HOT_KEYS[HotkeyAction.AIM_MODE_SWITCH_PREVIOUS.ordinal()] = new int[1]; (new int[1])[0] = 56; DEFAULT_HOT_KEYS[HotkeyAction.AIM_MODE_SWITCH_NEXT.ordinal()] = new int[1]; (new int[1])[0] = 145; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_1.ordinal()] = new int[1]; (new int[1])[0] = 146; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_2.ordinal()] = new int[1]; (new int[1])[0] = 147; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_3.ordinal()] = new int[1]; (new int[1])[0] = 148; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_4.ordinal()] = new int[1]; (new int[1])[0] = 149; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_5.ordinal()] = new int[1]; (new int[1])[0] = 150; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_6.ordinal()] = new int[1]; (new int[2])[0] = 129; (new int[2])[1] = 145; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_1.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 146; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_2.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 147; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_3.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 148; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_4.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 149; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_5.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 150; DEFAULT_HOT_KEYS[HotkeyAction.TOWER_ABILITY_ALL_6.ordinal()] = new int[2]; (new int[1])[0] = 10; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_BASIC.ordinal()] = new int[1]; (new int[1])[0] = 11; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_SNIPER.ordinal()] = new int[1]; (new int[1])[0] = 12; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_CANNON.ordinal()] = new int[1]; (new int[1])[0] = 13; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_FREEZING.ordinal()] = new int[1]; (new int[1])[0] = 33; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_AIR.ordinal()] = new int[1]; (new int[1])[0] = 46; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_SPLASH.ordinal()] = new int[1]; (new int[1])[0] = 48; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_BLAST.ordinal()] = new int[1]; (new int[1])[0] = 53; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_MULTISHOT.ordinal()] = new int[1]; (new int[1])[0] = 32; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_MINIGUN.ordinal()] = new int[1]; (new int[1])[0] = 34; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_VENOM.ordinal()] = new int[1]; (new int[1])[0] = 35; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_TESLA.ordinal()] = new int[1]; (new int[1])[0] = 36; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_MISSILE.ordinal()] = new int[1]; (new int[1])[0] = 31; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_FLAMETHROWER.ordinal()] = new int[1]; (new int[1])[0] = 50; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_LASER.ordinal()] = new int[1]; (new int[1])[0] = 30; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_GAUSS.ordinal()] = new int[1]; (new int[1])[0] = 42; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_TOWER_CRUSHER.ordinal()] = new int[1]; (new int[2])[0] = 129; (new int[2])[1] = 10; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_BALANCE.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 11; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_SEARCH.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 12; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_POWER.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 13; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_DAMAGE.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 33; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_ATTACK_SPEED.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 46; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_MINING_SPEED.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 48; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_BOUNTY.ordinal()] = new int[2]; (new int[2])[0] = 129; (new int[2])[1] = 53; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MODIFIER_EXPERIENCE.ordinal()] = new int[2]; (new int[1])[0] = 10; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MINER_SCALAR.ordinal()] = new int[1]; (new int[1])[0] = 11; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MINER_VECTOR.ordinal()] = new int[1]; (new int[1])[0] = 12; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MINER_MATRIX.ordinal()] = new int[1]; (new int[1])[0] = 13; DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MINER_TENSOR.ordinal()] = new int[1]; (new int[1])[0] = 33;
/*      */     DEFAULT_HOT_KEYS[HotkeyAction.BUILD_MINER_INFIAR.ordinal()] = new int[1];
/*      */     i = new Array(HotkeyAction.class); } public static class Serializer extends SingletonSerializer<SettingsManager> {
/*      */     public SettingsManager read() { return Game.i.settingsManager; } } public enum DynamicSetting {
/*  376 */     IAP_DOUBLE_GAIN_ENABLED, IAP_GREEN_PAPER_ENABLED, IAP_ACCELERATOR_ENABLED, IAP_OFFERS, ADS_ENABLED, IOS_OKJOY_SECRET_CODE_ENABLED, WIKI_URL, IAP_GREEN_PAPER_MAX_PER_HOUR, MULTIPLAYER_TEST_ENDPOINT, REWARDING_ADS_MODE, IAP_NOT_AVAILABLE_IN_COUNTRY, ANALYTICS_HOST, ANALYTICS_TOKEN, ANALYTICS_BUCKET, ANALYTICS_ORG; } public boolean isEscButtonJustPressed() { if (Dialog.i().isVisible() || TextInputOverlay.i().isVisible()) {
/*  377 */       return false;
/*      */     }
/*  379 */     return (Gdx.input.isKeyJustPressed(4) || Gdx.input.isKeyJustPressed(111)); } public enum HotkeyAction {
/*      */     CALL_WAVE, TOGGLE_AUTO_WAVE_CALL, PAUSE_GAME, SPEED_UP, SPEED_DOWN, SWITCH_DRAW_MODE, TOGGLE_QUEST_LIST, TOGGLE_TILE_MENU, TOGGLE_STATS_PANE, TOGGLE_LEADERBOARD, ZOOM_1X, ZOOM_FIT_MAP, PANIC, ABILITY_1, ABILITY_2, ABILITY_3, ABILITY_4, ABILITY_5, ABILITY_6, UPGRADE_BUILDING, UPGRADE_ALL_BUILDINGS, TOGGLE_TOWER_ENABLED, SELL_BUILDING, AIM_MODE_SWITCH_NEXT, AIM_MODE_SWITCH_PREVIOUS, BUILD_TOWER_BASIC, BUILD_TOWER_SNIPER, BUILD_TOWER_CANNON, BUILD_TOWER_FREEZING, BUILD_TOWER_AIR, BUILD_TOWER_SPLASH, BUILD_TOWER_BLAST, BUILD_TOWER_MULTISHOT, BUILD_TOWER_MINIGUN, BUILD_TOWER_VENOM, BUILD_TOWER_TESLA, BUILD_TOWER_MISSILE, BUILD_TOWER_FLAMETHROWER, BUILD_TOWER_LASER, BUILD_TOWER_GAUSS, BUILD_TOWER_CRUSHER, TOWER_ABILITY_1, TOWER_ABILITY_2, TOWER_ABILITY_3, TOWER_ABILITY_4, TOWER_ABILITY_5, TOWER_ABILITY_6, TOWER_ABILITY_ALL_1, TOWER_ABILITY_ALL_2, TOWER_ABILITY_ALL_3, TOWER_ABILITY_ALL_4, TOWER_ABILITY_ALL_5, TOWER_ABILITY_ALL_6, BUILD_MODIFIER_BALANCE, BUILD_MODIFIER_SEARCH, BUILD_MODIFIER_POWER, BUILD_MODIFIER_DAMAGE, BUILD_MODIFIER_ATTACK_SPEED, BUILD_MODIFIER_MINING_SPEED, BUILD_MODIFIER_BOUNTY, BUILD_MODIFIER_EXPERIENCE, BUILD_MINER_SCALAR, BUILD_MINER_VECTOR, BUILD_MINER_MATRIX, BUILD_MINER_TENSOR, BUILD_MINER_INFIAR; public static HotkeyAction[] values = values(); static {  } } public enum InitConfig {
/*      */     GRAPHICS_VSYNC, GRAPHICS_FPS_LIMIT, GRAPHICS_AA_LEVELS, GRAPHICS_FS_ENABLED, GRAPHICS_FS_BORDERLESS, GRAPHICS_FS_WIDTH, GRAPHICS_FS_HEIGHT, GRAPHICS_PAUSE_ON_MIN, GRAPHICS_PAUSE_ON_BACK, GRAPHICS_ALLOW_SOFTWARE, GRAPHICS_SAFE_AREA, GRAPHICS_BASIS_TEXTURES, AUDIO_BUFFER_SIZE, AUDIO_BUFFER_COUNT, AUDIO_SIM_SOURCES; public static final InitConfig[] values = values(); static {  } } public enum CustomValueType {
/*      */     CORE_HINT_SHOWN, UI_SCALE, MUSIC_CACHE_MAX_SIZE, SHOOTING_SOUNDS_VOLUME, CAMERA_TOOLS_ENABLED, LAST_AUTO_SHOWN_NEWS_ID, UNLOCK_ALL_LOCALES, TOUCHES_STOP_CAMERA_SCENARIOS, SEND_NOTIFICATIONS, ENABLE_REWARDING_ADS, ENABLE_PAUSE_AD_ICON, IGNORE_MAP_MUSIC, DRAW_TOWER_TARGET, SOUND_VOLUME, MUSIC_VOLUME, PERSONALIZED_ADS, PERSONALIZED_ADS_CONSENT_CONFIRMED, SMOOTH_MUSIC, LIVE_LEADERBOARDS, DPS_CHART_ENABLED, SLOW_MOTION_PAUSE, COLORBLIND_MODE, GRAPHICS_INTERPOLATION_ENABLED, CAMERA_SHAKE_ENABLED, STATISTICS_CHART_ENABLED, STATE_EDITOR_ENABLED, LOOT_ICONS_ENABLED, BACKGROUND_ENABLED, STATE_AUTO_SAVE_INTERVAL, BETA_ITEMS_GIVEN_1_9_0, ENDLESS_MODE_DIFFICULTY, ENDLESS_LEADERBOARD_HINT_SHOWN, INSTANT_HOLD_BUTTON_ON_RMB, DOUBLE_GAIN_DISABLED_MANUALLY, PREMIUM_STATUS_DISABLED_MANUALLY, UI_QUEST_LIST_VISIBLE, UI_LIVE_LEADERBOARDS_VISIBLE, UI_DETAILED_MODE_ENABLED, UI_STATISTICS_CHART_VISIBLE, UI_HOT_KEY_HINTS, MULTITHREADING, POSTPROCESSING, PP_GRAPHICS_SCALE, PP_CLEAN_DETAILED_MODE, PP_EFFECTS_SCALE, PARTICLE_COUNT, SHOW_BONUS_SELECTION_IMMEDIATELY, TT_MODIFIER_TAB_SHOWN, GL3ASWN, DAMAGE_PARTICLES_ENABLED, MUSIC_SPECTRUM_ENABLED, DAMAGE_PARTICLES_MORE, DBG_DISABLE_PATH_RENDERING, DBG_SHOW_TILE_COORDINATES_IN_MENU, DBG_DISABLE_TILE_HOVERING, DBG_ALWAYS_DRAW_TILE_EXTRAS, DBG_CONSOLE_DISABLED, DBG_CONSOLE_LINE_COUNT, DBG_DRAW_TOWER_XP, DBG_DRAW_ENEMIES_INFO, DBG_DRAW_UNITS_BBOX, DBG_DRAW_ENEMIES_AABB, DBG_DRAW_PROBLEMATIC_PROJECTILES, DBG_DRAW_ENEMIES_COUNT_AABB, DBG_DRAW_CURSOR_POS, DBG_DRAW_TILE_POS, DBG_DRAW_PATHFINDING, DBG_DRAW_TILE_INFO, DBG_DRAW_BUILDING_INFO, DBG_DRAW_ENEMY_PATHS, DBG_VIEWPORT_CULLING, DBG_DISABLE_UI_TOUCH_LOG, DBG_SYNC_VALIDATION, DBG_SHOW_FPS, DBG_PERFORMANCE_SURVEY_REQUESTED, DBG_PERFORMANCE_SURVEY_SUBMITTED, DBG_RAYCASTS, DBG_DIRTY_TILES, DBG_COLLISIONS, DBG_DISABLE_ADDITIVE_BLENDING, DBG_PRINT_FULL_LUA_STACKTRACES, DBG_SIMULATE_VISIBLE_DISPLAY_FRAME, DBG_BETA_ITEMS_ISSUE_TS, BUG_REPORTS_ENABLED, EXPLOSIONS_DRAWING, PROJECTILES_DRAWING, PROJECTILE_TRAILS_DRAWING, PARTICLES_DRAWING, UI_ANIMATIONS_ENABLED, FLYING_COINS_ENABLED, LARGE_FONTS_ENABLED, DEBUG_MODE, DEBUG_DETAILED_MODE, INSTANT_AUTO_WAVE_CALL, STAINS_ENABLED, THREE_DEE_MODELS_ENABLED; public static final CustomValueType[] values = values();
/*      */     static {  } }
/*  384 */   public boolean isSecretCodesEnabled() { return true; }
/*      */ 
/*      */   
/*      */   public String getDynamicSetting(DynamicSetting paramDynamicSetting) {
/*  388 */     return this.b[paramDynamicSetting.ordinal()];
/*      */   }
/*      */   
/*      */   public int getScaledViewportHeight() {
/*      */     double d;
/*  393 */     if ((d = getCustomValue(CustomValueType.UI_SCALE)) < 0.5D) d = 0.5D; 
/*  394 */     if (d > 1.0D) d = 1.0D;
/*      */     
/*  396 */     return MathUtils.round(1080.0F * (float)(1.0D / d));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getHotKey(HotkeyAction paramHotkeyAction) {
/*  403 */     if ((SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] != null) {
/*  404 */       return (SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()];
/*      */     }
/*  406 */     return getDefaultHotKey(paramHotkeyAction);
/*      */   }
/*      */   
/*      */   public int[] getDefaultHotKey(HotkeyAction paramHotkeyAction) {
/*  410 */     return DEFAULT_HOT_KEYS[paramHotkeyAction.ordinal()];
/*      */   }
/*      */   
/*      */   public void setHotKey(HotkeyAction paramHotkeyAction, int[] paramArrayOfint) {
/*  414 */     int[] arrayOfInt = getDefaultHotKey(paramHotkeyAction);
/*  415 */     if (paramArrayOfint == null) {
/*  416 */       paramArrayOfint = arrayOfInt;
/*      */     }
/*      */ 
/*      */     
/*  420 */     if (a(arrayOfInt, paramArrayOfint) && 
/*  421 */       (SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] != null) {
/*  422 */       (SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] = null;
/*  423 */       SettingsPrefs.i().requireSave();
/*  424 */       this.f = null;
/*  425 */       this.g.clear();
/*  426 */       this.h.clear();
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  432 */     if ((SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] != null && a(paramArrayOfint, (SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()])) {
/*      */       return;
/*      */     }
/*      */     
/*  436 */     (SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] = paramArrayOfint;
/*  437 */     this.f = null;
/*  438 */     this.g.clear();
/*  439 */     this.h.clear();
/*      */     
/*  441 */     SettingsPrefs.i().requireSave();
/*      */   }
/*      */   
/*      */   private static boolean a(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  445 */     if (paramArrayOfint1.length != paramArrayOfint2.length) return false; 
/*  446 */     Arrays.sort(paramArrayOfint1);
/*  447 */     Arrays.sort(paramArrayOfint2);
/*  448 */     for (byte b = 0; b < paramArrayOfint1.length; b++) {
/*  449 */       if (paramArrayOfint1[b] != paramArrayOfint2[b]) {
/*  450 */         return false;
/*      */       }
/*      */     } 
/*  453 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isDefaultHotKey(HotkeyAction paramHotkeyAction) {
/*  457 */     return ((SettingsPrefs.i()).settings.hotKeys[paramHotkeyAction.ordinal()] == null);
/*      */   }
/*      */   
/*      */   private int[] b() {
/*  461 */     if (this.f == null) {
/*  462 */       IntArray intArray = new IntArray(); HotkeyAction[] arrayOfHotkeyAction; int i; byte b;
/*  463 */       for (i = (arrayOfHotkeyAction = HotkeyAction.values).length, b = 0; b < i; ) { HotkeyAction hotkeyAction = arrayOfHotkeyAction[b];
/*      */         int[] arrayOfInt;
/*  465 */         if ((arrayOfInt = getHotKey(hotkeyAction)) != null) {
/*      */           int j;
/*      */           byte b1;
/*  468 */           for (j = (arrayOfInt = arrayOfInt).length, b1 = 0; b1 < j; ) { int k = arrayOfInt[b1];
/*  469 */             if (!intArray.contains(k))
/*  470 */               intArray.add(k);  b1++; }
/*      */         
/*      */         }  b++; }
/*      */       
/*  474 */       intArray.sort();
/*  475 */       this.f = intArray.toArray();
/*      */     } 
/*      */     
/*  478 */     return this.f;
/*      */   }
/*      */   
/*      */   public Array<HotkeyAction> getHotKeyActions(IntArray paramIntArray) {
/*  482 */     i.clear(); HotkeyAction[] arrayOfHotkeyAction; int i; byte b;
/*  483 */     for (i = (arrayOfHotkeyAction = HotkeyAction.values).length, b = 0; b < i; ) { HotkeyAction hotkeyAction = arrayOfHotkeyAction[b];
/*      */       int[] arrayOfInt;
/*  485 */       if ((arrayOfInt = getHotKey(hotkeyAction)) != null && paramIntArray.size == arrayOfInt.length) {
/*  486 */         int j = (arrayOfInt = arrayOfInt).length; byte b1 = 0; while (true) { if (b1 < j) { int k = arrayOfInt[b1];
/*  487 */             boolean bool = false;
/*  488 */             for (byte b2 = 0; b2 < paramIntArray.size; b2++) {
/*  489 */               if (paramIntArray.items[b2] == k) {
/*  490 */                 bool = true;
/*      */                 break;
/*      */               } 
/*      */             } 
/*  494 */             if (bool) {
/*      */               b1++; continue;
/*      */             } 
/*      */             break; }
/*      */           
/*  499 */           i.add(hotkeyAction); break; }
/*      */       
/*      */       }  b++; }
/*      */     
/*  503 */     return i;
/*      */   }
/*      */   
/*      */   public Array<HotkeyAction> getHotkeysJustPressed() {
/*  507 */     i.clear();
/*  508 */     if (this.g.size == 0) return i;  HotkeyAction[] arrayOfHotkeyAction; int i;
/*      */     byte b;
/*  510 */     for (i = (arrayOfHotkeyAction = HotkeyAction.values).length, b = 0; b < i; ) { HotkeyAction hotkeyAction = arrayOfHotkeyAction[b];
/*      */       int[] arrayOfInt;
/*  512 */       if ((arrayOfInt = getHotKey(hotkeyAction)) != null && 
/*  513 */         this.g.size == arrayOfInt.length) {
/*  514 */         int j = (arrayOfInt = arrayOfInt).length; byte b1 = 0; while (true) { if (b1 < j) { int k = arrayOfInt[b1];
/*  515 */             if (this.g.contains(k)) {
/*      */               b1++; continue;
/*      */             }  break; }
/*      */           
/*  519 */           i.add(hotkeyAction); break; }
/*      */       
/*      */       }  b++; }
/*      */     
/*  523 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isHotkeyJustPressed(HotkeyAction paramHotkeyAction) {
/*  530 */     int[] arrayOfInt = DEFAULT_HOT_KEYS[paramHotkeyAction.ordinal()];
/*  531 */     if (this.g.size == arrayOfInt.length) {
/*  532 */       int i; byte b; for (i = (arrayOfInt = arrayOfInt).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  533 */         if (!this.g.contains(j)) {
/*  534 */           return false;
/*      */         }
/*      */         b++; }
/*      */       
/*  538 */       return true;
/*      */     } 
/*  540 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getHotKeyName(HotkeyAction paramHotkeyAction) {
/*  545 */     String str = "hotkey_" + paramHotkeyAction.name();
/*  546 */     return Game.i.localeManager.i18n.get(str);
/*      */   }
/*      */   
/*      */   public String getHotkeyGroupTitle(HotkeyAction paramHotkeyAction) {
/*  550 */     switch (null.a[paramHotkeyAction.ordinal()]) { case 1:
/*  551 */         return Game.i.localeManager.i18n.get("hotkey_group_general");
/*  552 */       case 2: return Game.i.localeManager.i18n.get("hotkey_group_abilities");
/*  553 */       case 3: return Game.i.localeManager.i18n.get("hotkey_group_buildings");
/*  554 */       case 4: return Game.i.localeManager.i18n.get("hotkey_group_towers");
/*  555 */       case 5: return Game.i.localeManager.i18n.get("hotkey_group_tower_abilities");
/*  556 */       case 6: return Game.i.localeManager.i18n.get("hotkey_group_modifiers");
/*  557 */       case 7: return Game.i.localeManager.i18n.get("hotkey_group_miners"); }
/*      */     
/*  559 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*  564 */     if (!Config.isHeadless()) {
/*  565 */       c();
/*  566 */       d();
/*      */     } 
/*      */     
/*  569 */     Timer.schedule(new Timer.Task(this)
/*      */         {
/*      */           public void run() {
/*  572 */             SettingsManager.a(this.a);
/*      */           }
/*      */         },  300.0F, 300.0F);
/*      */ 
/*      */     
/*  577 */     if (isThreeDeeModelsEnabled()) {
/*  578 */       a.i("preloading main menu scene", new Object[0]);
/*  579 */       Game.i.assetManager.getSceneModel(paramModel -> a.i("main menu scene preloaded", new Object[0]));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Graphics.DisplayMode getBestFullscreenModeWithPrefDimensions(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  586 */     a.i("getBestFullscreenMode " + paramInt1 + " " + paramInt2 + " " + paramInt3 + " " + paramInt4, new Object[0]);
/*  587 */     paramInt1 = (paramInt1 > 1) ? paramInt1 : paramInt3;
/*  588 */     paramInt2 = (paramInt2 > 1) ? paramInt2 : paramInt4;
/*      */     
/*  590 */     Graphics.DisplayMode displayMode = null;
/*  591 */     Graphics.DisplayMode[] arrayOfDisplayMode1 = Gdx.graphics.getDisplayModes();
/*      */     
/*  593 */     int i = 0; Graphics.DisplayMode[] arrayOfDisplayMode2; int j; byte b;
/*  594 */     for (j = (arrayOfDisplayMode2 = arrayOfDisplayMode1).length, b = 0; b < j; b++) {
/*  595 */       Graphics.DisplayMode displayMode1; if ((displayMode1 = arrayOfDisplayMode2[b]).bitsPerPixel > i) {
/*  596 */         i = displayMode1.bitsPerPixel;
/*      */       }
/*      */     } 
/*      */     
/*  600 */     if (paramInt1 > 1 && paramInt2 > 1) {
/*  601 */       for (j = (arrayOfDisplayMode2 = arrayOfDisplayMode1).length, b = 0; b < j; ) {
/*  602 */         Graphics.DisplayMode displayMode1; if ((displayMode1 = arrayOfDisplayMode2[b]).width == paramInt1 && displayMode1.height == paramInt2 && displayMode1.bitsPerPixel >= i && (
/*  603 */           displayMode == null || displayMode.refreshRate < displayMode1.refreshRate)) {
/*  604 */           displayMode = displayMode1;
/*      */         }
/*      */         b++;
/*      */       } 
/*      */     }
/*  609 */     if (displayMode == null)
/*      */     {
/*  611 */       for (j = (arrayOfDisplayMode2 = arrayOfDisplayMode1).length, b = 0; b < j; b++) {
/*  612 */         Graphics.DisplayMode displayMode1; if ((displayMode1 = arrayOfDisplayMode2[b]).bitsPerPixel >= i)
/*      */         {
/*  614 */           if (displayMode == null || ((displayMode.width < displayMode1.width || displayMode.height < displayMode1.height) && displayMode.refreshRate <= displayMode1.refreshRate))
/*      */           {
/*      */             
/*  617 */             displayMode = displayMode1;
/*      */           }
/*      */         }
/*      */       } 
/*      */     }
/*  622 */     a.i("best fullscreen mode: " + displayMode, new Object[0]);
/*  623 */     return displayMode;
/*      */   }
/*      */   
/*      */   public static Graphics.DisplayMode getBestFullscreenMode(int paramInt1, int paramInt2) {
/*      */     IntPair intPair;
/*  628 */     if ((intPair = Game.i.actionResolver.getBestScreenResolution()) == null) {
/*  629 */       intPair = new IntPair(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*      */     }
/*  631 */     return getBestFullscreenModeWithPrefDimensions(paramInt1, paramInt2, intPair.a, intPair.b);
/*      */   }
/*      */   
/*      */   private boolean c() {
/*      */     FileHandle fileHandle;
/*  636 */     if ((fileHandle = Gdx.files.local("cache/dynamic-settings.json")).exists()) {
/*      */       
/*      */       try {
/*      */         
/*  640 */         JsonValue jsonValue = (new JsonReader()).parse(fileHandle.readString("UTF-8"));
/*  641 */         a(jsonValue);
/*  642 */         return true;
/*  643 */       } catch (Exception exception) {
/*  644 */         a.e("failed to load local dynamic settings, clearing", new Object[] { exception });
/*      */         try {
/*  646 */           fileHandle.delete();
/*  647 */         } catch (Exception exception1) {}
/*  648 */         return false;
/*      */       } 
/*      */     }
/*      */     
/*  652 */     return false;
/*      */   }
/*      */   
/*      */   public boolean cvdFriendlyColors() {
/*  656 */     return (Game.i.settingsManager.getCustomValue(CustomValueType.COLORBLIND_MODE) != 0.0D);
/*      */   }
/*      */   
/*      */   private void d() {
/*      */     Net.HttpRequest httpRequest;
/*  661 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.DYNAMIC_SETTINGS_URL);
/*      */     HashMap<Object, Object> hashMap;
/*  663 */     (hashMap = new HashMap<>()).put("os", Gdx.app.getType().name());
/*  664 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  666 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*      */         {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */             try {
/*  670 */               String str = param1HttpResponse.getResultAsString();
/*      */ 
/*      */               
/*      */               try {
/*      */                 FileHandle fileHandle;
/*      */                 
/*  676 */                 (fileHandle = Gdx.files.local("cache/dynamic-settings.json")).writeString(str, false, "UTF-8");
/*  677 */               } catch (Exception exception) {
/*  678 */                 SettingsManager.a().e("failed to cache dynamic settings locally", new Object[] { exception });
/*      */               } 
/*      */               
/*      */               try {
/*  682 */                 JsonValue jsonValue = (new JsonReader()).parse(str);
/*  683 */                 SettingsManager.a(this.a, jsonValue);
/*  684 */               } catch (Exception exception) {
/*  685 */                 SettingsManager.a().e("failed to load server's dynamic settings after response", new Object[] { exception }); return;
/*      */               } 
/*  687 */             } catch (Exception exception) {
/*  688 */               SettingsManager.a().e("failed to load server's dynamic settings", new Object[] { exception });
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/*  694 */             SettingsManager.a().i("failed to load dynamic settings from server", new Object[] { param1Throwable });
/*      */           }
/*      */ 
/*      */           
/*      */           public void cancelled() {
/*  699 */             SettingsManager.a().i("canceled loading dynamic settings from server", new Object[0]);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized void a(JsonValue paramJsonValue) {
/*  709 */     System.arraycopy(this.c, 0, this.d, 0, this.d.length);
/*      */     
/*      */     try {
/*  712 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator(); jsonIterator.hasNext();) {
/*      */         
/*  714 */         if ((str = (jsonValue = jsonIterator.next()).getString("os", null)) == null || str.equals(Gdx.app.getType().name())) {
/*      */           int i;
/*      */ 
/*      */ 
/*      */           
/*  719 */           if ((i = jsonValue.getInt("build", 0)) == 0 || i == 207)
/*      */           {
/*      */ 
/*      */ 
/*      */             
/*  724 */             if ((jsonValue = jsonValue.get("settings")) != null)
/*  725 */               for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue1 = jsonIterator1.next();
/*      */                 try {
/*  727 */                   DynamicSetting dynamicSetting = DynamicSetting.valueOf(jsonValue1.name);
/*      */                   
/*  729 */                   this.d[dynamicSetting.ordinal()] = jsonValue1.asString();
/*  730 */                 } catch (Exception exception) {
/*  731 */                   a.e("failed to load dynamic setting '" + jsonValue1.name + "'", new Object[] { exception });
/*      */                 }  }
/*      */                 } 
/*      */         } 
/*      */       } 
/*  736 */     } catch (Exception exception) {
/*  737 */       a.e("failed to load dynamic settings", new Object[] { exception });
/*      */     } 
/*      */ 
/*      */     
/*  741 */     boolean bool = false;
/*  742 */     for (byte b = 0; b < this.b.length; b++) {
/*  743 */       String str1 = this.b[b];
/*  744 */       String str2 = this.d[b];
/*  745 */       if (str1 != null || str2 != null) {
/*  746 */         if (str1 == null || str2 == null) {
/*  747 */           bool = true;
/*      */           break;
/*      */         } 
/*  750 */         if (!str1.equals(str2)) {
/*  751 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  757 */     if (bool) {
/*  758 */       Threads.i().runOnMainThread(() -> {
/*      */             System.arraycopy(this.d, 0, this.b, 0, this.d.length);
/*      */             DynamicSetting[] arrayOfDynamicSetting;
/*      */             int i = (arrayOfDynamicSetting = DynamicSetting.values()).length;
/*      */             for (byte b2 = 0; b2 < i; b2++) {
/*      */               DynamicSetting dynamicSetting = arrayOfDynamicSetting[b2];
/*      */               a.i("- " + dynamicSetting + " = " + this.b[dynamicSetting.ordinal()], new Object[0]);
/*      */             } 
/*      */             this.j.begin();
/*      */             byte b1 = 0;
/*      */             i = this.j.size;
/*      */             while (b1 < i) {
/*      */               ((SettingsManagerListener)this.j.get(b1)).dynamicSettingsChanged();
/*      */               b1++;
/*      */             } 
/*      */             this.j.end();
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolCustomValue(CustomValueType paramCustomValueType) {
/*  787 */     if (Config.isHeadless()) throw new IllegalStateException("Not available in headless"); 
/*      */     double d;
/*  789 */     if ((d = (SettingsPrefs.i()).settings.customValues[paramCustomValueType.ordinal()]) == -9740019.0D) {
/*  790 */       d = SP_Settings.getDefaultCustomValue(paramCustomValueType);
/*      */     }
/*  792 */     return (d != 0.0D);
/*      */   }
/*      */   
/*      */   public double getCustomValue(CustomValueType paramCustomValueType) {
/*  796 */     if (Config.isHeadless()) throw new IllegalStateException("Not available in headless"); 
/*      */     double d;
/*  798 */     if ((d = (SettingsPrefs.i()).settings.customValues[paramCustomValueType.ordinal()]) == -9740019.0D) {
/*  799 */       d = SP_Settings.getDefaultCustomValue(paramCustomValueType);
/*      */     }
/*  801 */     return d;
/*      */   }
/*      */   
/*      */   public boolean setBoolCustomValue(CustomValueType paramCustomValueType, boolean paramBoolean) {
/*  805 */     return setCustomValue(paramCustomValueType, paramBoolean ? 1.0D : 0.0D);
/*      */   }
/*      */   
/*      */   public boolean unsetCustomValue(CustomValueType paramCustomValueType) {
/*  809 */     return setCustomValue(paramCustomValueType, -9740019.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomValue(CustomValueType paramCustomValueType, double paramDouble) {
/*      */     double d;
/*  817 */     if ((d = (SettingsPrefs.i()).settings.customValues[paramCustomValueType.ordinal()]) == paramDouble) return false;
/*      */     
/*  819 */     (SettingsPrefs.i()).settings.customValues[paramCustomValueType.ordinal()] = paramDouble;
/*  820 */     SettingsPrefs.i().requireSave();
/*      */     
/*  822 */     this.j.begin();
/*  823 */     for (byte b = 0; b < this.j.size; b++) {
/*  824 */       ((SettingsManagerListener)this.j.get(b)).customValueChanged(paramCustomValueType, d);
/*      */     }
/*  826 */     this.j.end();
/*  827 */     e();
/*  828 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getGameSessionFingerprint(String paramString1, String paramString2) {
/*  834 */     char[] arrayOfChar = new char[25];
/*  835 */     byte b3 = 0;
/*  836 */     byte b4 = 0;
/*  837 */     b4++; b3++; arrayOfChar[0] = paramString1.charAt(0);
/*  838 */     b3++; byte b5;
/*  839 */     for (b5 = 0; b5 < 4; b5++) {
/*  840 */       arrayOfChar[b4++] = paramString1.charAt(b3++);
/*      */     }
/*  842 */     b3++;
/*  843 */     for (b5 = 0; b5 < 4; b5++) {
/*  844 */       arrayOfChar[b4++] = paramString1.charAt(b3++);
/*      */     }
/*  846 */     b3++;
/*  847 */     for (b5 = 0; b5 < 6; b5++) {
/*  848 */       arrayOfChar[b4++] = paramString1.charAt(b3++);
/*      */     }
/*  850 */     while (paramString2.length() < 10)
/*      */     {
/*  852 */       paramString2 = paramString2 + 'Z';
/*      */     }
/*  854 */     for (b5 = 0; b5 < 10; b5++) {
/*  855 */       arrayOfChar[b4++] = paramString2.charAt(b5);
/*      */     }
/*      */     
/*  858 */     byte[] arrayOfByte3 = new byte[25];
/*  859 */     for (byte b1 = 0; b1 < 25; b1++) {
/*  860 */       char c = arrayOfChar[b1];
/*  861 */       arrayOfByte3[b1] = (byte)StringFormatter.DIST_STRING_CHAR_TO_IDX.get(c, 0);
/*      */     } 
/*      */     
/*  864 */     ByteArray byteArray = new ByteArray();
/*  865 */     byte b = 0;
/*  866 */     byte b2 = 0;
/*      */     
/*  868 */     for (byte[] arrayOfByte2 = arrayOfByte3; b4 < 25; ) { byte b6 = arrayOfByte2[b4];
/*  869 */       for (byte b7 = 0; b7 < 5; b7++) {
/*      */         
/*  871 */         if ((b6 >> b7 & 0x1) == 1) {
/*  872 */           b = (byte)(b | 1 << b2);
/*      */         }
/*  874 */         b2++;
/*  875 */         if (b2 == 8) {
/*  876 */           byteArray.add(b);
/*  877 */           b = 0;
/*  878 */           b2 = 0;
/*      */         } 
/*      */       }  b4++; }
/*      */     
/*  882 */     if (b2 != 0) {
/*  883 */       byteArray.add(b);
/*      */     }
/*      */ 
/*      */     
/*  887 */     int[] arrayOfInt = { 2, 7, 13, 8, 14, 3, 0, 10, 5, 6, 9, 11, 15, 12, 1, 4 };
/*  888 */     if (!k && byteArray.size != 16) throw new AssertionError(); 
/*  889 */     for (b = 0; b < 16; b++) {
/*  890 */       byteArray.swap(b, arrayOfInt[b]);
/*      */     }
/*      */ 
/*      */     
/*      */     byte[] arrayOfByte1;
/*      */     
/*  896 */     return StringFormatter.toBase64(arrayOfByte1 = byteArray.toArray(), 0, arrayOfByte1.length);
/*      */   }
/*      */   
/*      */   public void addListener(SettingsManagerListener paramSettingsManagerListener) {
/*  900 */     if (paramSettingsManagerListener == null) {
/*  901 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  904 */     if (!this.j.contains(paramSettingsManagerListener, true)) {
/*  905 */       this.j.add(paramSettingsManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(SettingsManagerListener paramSettingsManagerListener) {
/*  910 */     if (paramSettingsManagerListener == null) {
/*  911 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  914 */     this.j.removeValue(paramSettingsManagerListener, true);
/*      */   }
/*      */   
/*      */   public void setSoundVoulme(double paramDouble) {
/*  918 */     if (paramDouble < 0.0D) paramDouble = 0.0D; 
/*  919 */     if (paramDouble > 1.0D) paramDouble = 1.0D; 
/*  920 */     setCustomValue(CustomValueType.SOUND_VOLUME, paramDouble);
/*      */   }
/*      */   
/*      */   public boolean isSoundEnabled() {
/*  924 */     return (getCustomValue(CustomValueType.SOUND_VOLUME) > 0.0D);
/*      */   }
/*      */   
/*      */   public boolean isMusicEnabled() {
/*  928 */     return (getCustomValue(CustomValueType.MUSIC_VOLUME) > 0.0D);
/*      */   }
/*      */   
/*      */   public void setMusicVolume(double paramDouble) {
/*  932 */     if (paramDouble < 0.0D) paramDouble = 0.0D; 
/*  933 */     if (paramDouble > 1.0D) paramDouble = 1.0D; 
/*  934 */     setCustomValue(CustomValueType.MUSIC_VOLUME, paramDouble);
/*      */   }
/*      */   
/*      */   public boolean isBugReportsEnabled() {
/*  938 */     return getBoolCustomValue(CustomValueType.BUG_REPORTS_ENABLED);
/*      */   }
/*      */   
/*      */   public void setBugReportsEnabled(boolean paramBoolean) {
/*  942 */     setBoolCustomValue(CustomValueType.BUG_REPORTS_ENABLED, paramBoolean);
/*      */   }
/*      */   
/*      */   public void setExplosionsDrawing(boolean paramBoolean) {
/*  946 */     setBoolCustomValue(CustomValueType.EXPLOSIONS_DRAWING, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isExplosionsDrawing() {
/*  950 */     return getBoolCustomValue(CustomValueType.EXPLOSIONS_DRAWING);
/*      */   }
/*      */   
/*      */   public void setProjectilesDrawing(boolean paramBoolean) {
/*  954 */     setBoolCustomValue(CustomValueType.PROJECTILES_DRAWING, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isProjectilesDrawing() {
/*  958 */     return getBoolCustomValue(CustomValueType.PROJECTILES_DRAWING);
/*      */   }
/*      */   
/*      */   public void setProjectileTrailsDrawing(boolean paramBoolean) {
/*  962 */     setBoolCustomValue(CustomValueType.PROJECTILE_TRAILS_DRAWING, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isProjectileTrailsDrawing() {
/*  966 */     return getBoolCustomValue(CustomValueType.PROJECTILE_TRAILS_DRAWING);
/*      */   }
/*      */   
/*      */   public void setParticlesDrawing(boolean paramBoolean) {
/*  970 */     setBoolCustomValue(CustomValueType.PARTICLES_DRAWING, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isParticlesDrawing() {
/*  974 */     return getBoolCustomValue(CustomValueType.PARTICLES_DRAWING);
/*      */   }
/*      */   
/*      */   public void setUiAnimationsEnabled(boolean paramBoolean) {
/*  978 */     setBoolCustomValue(CustomValueType.UI_ANIMATIONS_ENABLED, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isUiAnimationsEnabled() {
/*  982 */     return getBoolCustomValue(CustomValueType.UI_ANIMATIONS_ENABLED);
/*      */   }
/*      */   
/*      */   public void setFlyingCoinsEnabled(boolean paramBoolean) {
/*  986 */     setBoolCustomValue(CustomValueType.FLYING_COINS_ENABLED, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isFlyingCoinsEnabled() {
/*  990 */     return getBoolCustomValue(CustomValueType.FLYING_COINS_ENABLED);
/*      */   }
/*      */   
/*      */   public void setInstantAutoWaveCallEnabled(boolean paramBoolean) {
/*  994 */     setBoolCustomValue(CustomValueType.INSTANT_AUTO_WAVE_CALL, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isInstantAutoWaveCallEnabled() {
/*  998 */     return getBoolCustomValue(CustomValueType.INSTANT_AUTO_WAVE_CALL);
/*      */   }
/*      */   
/*      */   public void setStainsEnabled(boolean paramBoolean) {
/* 1002 */     setBoolCustomValue(CustomValueType.STAINS_ENABLED, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isStainsEnabled() {
/* 1006 */     return getBoolCustomValue(CustomValueType.STAINS_ENABLED);
/*      */   }
/*      */   
/*      */   public boolean setThreeDeeModelsEnabled(boolean paramBoolean) {
/* 1010 */     setBoolCustomValue(CustomValueType.THREE_DEE_MODELS_ENABLED, paramBoolean);
/* 1011 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isThreeDeeModelsEnabled() {
/* 1015 */     return getBoolCustomValue(CustomValueType.THREE_DEE_MODELS_ENABLED);
/*      */   }
/*      */   
/*      */   public void setLargeFontsEnabled(boolean paramBoolean) {
/* 1019 */     setBoolCustomValue(CustomValueType.LARGE_FONTS_ENABLED, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isLargeFontsEnabled() {
/* 1023 */     return getBoolCustomValue(CustomValueType.LARGE_FONTS_ENABLED);
/*      */   }
/*      */   
/*      */   public void setDebugMode(boolean paramBoolean) {
/* 1027 */     setBoolCustomValue(CustomValueType.DEBUG_MODE, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isInDebugMode() {
/* 1031 */     return getBoolCustomValue(CustomValueType.DEBUG_MODE);
/*      */   }
/*      */   
/*      */   public void setDebugDetailedMode(boolean paramBoolean) {
/* 1035 */     setBoolCustomValue(CustomValueType.DEBUG_DETAILED_MODE, paramBoolean);
/*      */   }
/*      */   
/*      */   public boolean isInDebugDetailedMode() {
/* 1039 */     return getBoolCustomValue(CustomValueType.DEBUG_DETAILED_MODE);
/*      */   }
/*      */   
/*      */   private void e() {
/* 1043 */     this.j.begin(); byte b; int i;
/* 1044 */     for (b = 0, i = this.j.size; b < i; b++) {
/* 1045 */       ((SettingsManagerListener)this.j.get(b)).settingsChanged();
/*      */     }
/* 1047 */     this.j.end();
/*      */   }
/*      */   
/*      */   public IntArray getHoldingHotKeys() {
/* 1051 */     return this.h;
/*      */   }
/*      */ 
/*      */   
/*      */   public void preRender(float paramFloat) {
/* 1056 */     super.preRender(paramFloat);
/*      */ 
/*      */     
/* 1059 */     this.h.clear();
/* 1060 */     int[] arrayOfInt = b();
/* 1061 */     int i = 1; int j; byte b;
/* 1062 */     for (j = (arrayOfInt = arrayOfInt).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 1063 */       if (Gdx.input.isKeyPressed(k)) {
/* 1064 */         this.h.add(k);
/* 1065 */         i = i * 31 + k;
/*      */       } 
/*      */       b++; }
/*      */     
/* 1069 */     this.g.clear();
/* 1070 */     if (this.e != i) {
/*      */       
/* 1072 */       this.e = i;
/* 1073 */       this.g.addAll(this.h);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static interface SettingsManagerListener {
/*      */     void settingsChanged();
/*      */     
/*      */     void customValueChanged(SettingsManager.CustomValueType param1CustomValueType, double param1Double);
/*      */     
/*      */     void dynamicSettingsChanged();
/*      */     
/*      */     public static abstract class SettingsManagerListenerAdapter implements SettingsManagerListener {
/*      */       public void settingsChanged() {}
/*      */       
/*      */       public void customValueChanged(SettingsManager.CustomValueType param2CustomValueType, double param2Double) {}
/*      */       
/*      */       public void dynamicSettingsChanged() {}
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\SettingsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */