/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.IntBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public class Config
/*     */ {
/*  21 */   private static final TLog a = TLog.forClass(Class.class);
/*     */ 
/*     */   
/*  24 */   public static String PACKAGE = "com.prineside.tdi2";
/*     */   
/*     */   public static final int BUILD = 207;
/*     */   
/*     */   public static final int BUILD_PROTOCOL = 207;
/*     */   
/*     */   public static final String VERSION = "R.1.9.1";
/*     */   
/*     */   public static final boolean DEBUG_MODE = false;
/*     */   
/*     */   public static final boolean PUBLIC_BETA_MODE = false;
/*     */   public static final boolean DEBUG_GENERATE_LOCALE_STUFF = true;
/*     */   public static final boolean DEBUG_GENERATE_RESOURCES_JSON = true;
/*     */   public static final boolean DEBUG_GENERATE_KRYO_REGISTRY = true;
/*     */   
/*     */   public static boolean isCompatibleWithBuild(int paramInt) {
/*  40 */     return (paramInt <= 207 && paramInt >= 207);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean DEBUG_VALIDATE_LOCALES = false;
/*     */ 
/*     */   
/*     */   public static final boolean AD_DEBUG_MODE = false;
/*     */ 
/*     */   
/*     */   public static final boolean DEVELOPER_MODE_AVAILABLE = true;
/*     */ 
/*     */   
/*     */   public static final int DISPLAY_HEIGHT = 900;
/*     */ 
/*     */   
/*     */   public static final int DISPLAY_WIDTH = 1600;
/*     */ 
/*     */   
/*     */   public static final int SYNC_CHECK_MAX_DEPTH = 12;
/*     */   
/*     */   public static final boolean SYNC_CHECK_COLD_START_ON_CONTINUE = true;
/*     */   
/*     */   public static final float DEBUG_ITEM_DROP_RATE = 1.0F;
/*     */   
/*     */   public static final boolean DEBUG_TEST_MANAGERS = false;
/*     */ 
/*     */   
/*  69 */   public static final Color WHITE_COLOR_CACHED_FLOAT_BITS = new Color(1.0F, 1.0F, 1.0F, 1.0F)
/*     */     {
/*     */       public float toFloatBits() {
/*  72 */         return Color.WHITE_FLOAT_BITS;
/*     */       }
/*     */     };
/*  75 */   public static final Color BACKGROUND_COLOR = new Color(387389439);
/*     */   
/*     */   public static final int VIEWPORT_HEIGHT = 1080;
/*     */   
/*     */   public static final int TILE_SIZE = 128;
/*     */   
/*     */   public static final float TILE_SIZE_INV = 0.0078125F;
/*     */   
/*     */   public static final int TILE_HALF_SIZE = 64;
/*     */   
/*     */   public static final float TILE_HALF_SIZE_INV = 0.015625F;
/*     */   
/*     */   public static final int FONT_SIZE_HUGE = 60;
/*     */   public static final int FONT_SIZE_LARGE = 36;
/*     */   public static final int FONT_SIZE_MEDIUM = 30;
/*     */   public static final int FONT_SIZE_SMALL = 24;
/*     */   public static final int FONT_SIZE_X_SMALL = 21;
/*     */   public static final int FONT_SIZE_XX_SMALL = 18;
/*  93 */   public static int GAME_STATE_UPDATE_RATE = 30;
/*  94 */   public static float UPDATE_DELTA_TIME = 1.0F / GAME_STATE_UPDATE_RATE;
/*     */   public static final long MAX_UPDATES_DURATION = 33333L;
/*     */   public static final float MAX_UPDATES_TIME_ACCUMULATOR = 2.0F;
/*  97 */   public static final int REPLAY_CHARTS_INTERVAL = GAME_STATE_UPDATE_RATE * 5;
/*     */   
/*     */   public static final int REPLAY_CHARTS_VERSION = 2;
/*     */   
/*     */   public static final float GIVEN_DAMAGE_EXP_COEFF = 2.0F;
/*     */   
/*     */   public static final float ENEMY_DIE_SCORE_MULTIPLIER = 1.75F;
/*     */   
/*     */   public static final int PLAYER_XP_ISSUE_INTERVAL = 2700;
/*     */   
/*     */   public static final int PLAYER_XP_ISSUE_INTERVAL_ENDLESS = 5400;
/*     */   
/*     */   public static final int PLAYER_XP_INACTIVITY_DURATION = 13500;
/*     */   
/*     */   public static final int PLAYER_XP_MAX_PER_GAME = 1333;
/*     */   
/*     */   public static final int PRESTIGE_MAP_SELL_STAT_MIN_PRICE = 50;
/*     */   
/*     */   public static final float ENDLESS_MAX_REPLAY_DURATION = 2700.0F;
/*     */   
/* 117 */   public static String LEGACY_PREFERENCES_NAME_PREFIX = "com.prineside.tdi2._prefV1.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public static final String LEGACY_PREFERENCES_NAME_PROGRESS = LEGACY_PREFERENCES_NAME_PREFIX + "Progress";
/* 124 */   public static final String LEGACY_PREFERENCES_NAME_SETTINGS = LEGACY_PREFERENCES_NAME_PREFIX + "Settings";
/* 125 */   public static final String LEGACY_PREFERENCES_NAME_STATISTICS = LEGACY_PREFERENCES_NAME_PREFIX + "Statistics";
/* 126 */   public static final String LEGACY_PREFERENCES_NAME_USER_MAPS = LEGACY_PREFERENCES_NAME_PREFIX + "UserMaps";
/* 127 */   public static final String[] LEGACY_PREFERENCES_NAMES = new String[] { LEGACY_PREFERENCES_NAME_PROGRESS, LEGACY_PREFERENCES_NAME_SETTINGS, LEGACY_PREFERENCES_NAME_STATISTICS, LEGACY_PREFERENCES_NAME_USER_MAPS };
/*     */   
/*     */   public static final String RESOURCES_DIR = "res/";
/*     */   
/*     */   public static final String PLAY_STORE_URI = "https://play.google.com/store/apps/details?id=com.prineside.tdi2";
/*     */   
/*     */   public static final String APP_STORE_URI = "https://apps.apple.com/us/app/infinitode-2/id1480178308";
/* 134 */   public static String SITE_URL = "https://infinitode.prineside.com";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   public static String AVATAR_WEB_TEXTURES_URL = "https://storage.prineside.com/files/i2/avatars/";
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int STEAM_APP_ID = 937310;
/*     */ 
/*     */ 
/*     */   
/* 148 */   public static final String NEWS_URI = SITE_URL + "/?m=news";
/*     */   public static final String WIKI_URL = "https://infinitode-2.wikia.com";
/*     */   public static final String OPTIONAL_WEB_TEXTURES_URL = "https://files.prineside.com/static/infinitode_website/optional/";
/* 151 */   public static String PRIVACY_POLICY_URL = "https://infinitode.prineside.com/?m=game_privacy_policy";
/* 152 */   public static String TERMS_AND_CONDITIONS_URL = "https://infinitode.prineside.com/?m=game_terms_and_conditions";
/* 153 */   public static String WHY_ACCOUNT_URL = SITE_URL + "/?m=why_account";
/*     */   public static final String I18N_SUGGEST_FIX_URL = "https://infinitode.prineside.com/?m=translate";
/*     */   public static final String DAILY_QUEST_RULES_WIKI_URL = "https://infinitode-2.fandom.com/wiki/Daily_quests";
/*     */   public static final String SITE_SHARED_GET_PART = "&v=207";
/* 157 */   public static final String SERVER_TIMESTAMP_URL = SITE_URL + "/?m=api&a=getTimestamp&v=207";
/*     */   public static final String SERVER_TIMESTAMP_FALLBACK_URL = "https://dev.prineside.com/timestamp";
/* 159 */   public static final String GAME_REPLAY_REPORT_URL = SITE_URL + "/?m=api&a=submitGameReplay&v=207";
/* 160 */   public static final String IAP_VALIDATION_URL = SITE_URL + "/?m=api&a=validateIAP&v=207";
/* 161 */   public static final String GET_BEST_GAME_REPLAY_URL = SITE_URL + "/?m=api&a=getBestGameReplay&v=207";
/* 162 */   public static final String SECRET_CODE_APPLICATION_URL = SITE_URL + "/?m=api&a=applySecretCode&v=207";
/* 163 */   public static final String LOGGER_REPORT_URL = SITE_URL + "/?m=api&a=submitLoggerReport&v=207";
/* 164 */   public static final String GAME_START_LOG_URL = SITE_URL + "/?m=api&a=logGameStart&v=207";
/* 165 */   public static final String DYNAMIC_SETTINGS_URL = SITE_URL + "/?m=api&a=getDynamicSettings&v=207";
/* 166 */   public static final String AUTH_GET_SESSION_INFO_URL = SITE_URL + "/?m=api&a=getPlayerSessionInfo&v=207";
/* 167 */   public static final String AUTH_SAVE_GAME_URL = SITE_URL + "/?m=api&a=saveGame&v=207";
/* 168 */   public static final String AUTH_PASTEBIN_URL = SITE_URL + "/?m=api&a=createPasteBin&v=207";
/* 169 */   public static final String AUTH_BACKUP_PROGRESS_URL = SITE_URL + "/?m=api&a=addProgressRestorePoint&v=207";
/* 170 */   public static final String AUTH_LOAD_GAME_URL = SITE_URL + "/?m=api&a=loadGame&v=207";
/* 171 */   public static final String AUTH_DELETE_GAME_URL = SITE_URL + "/?m=api&a=deleteGame&v=207";
/* 172 */   public static final String AUTH_SIGN_IN_URL = SITE_URL + "/?m=api&a=signIn&v=207";
/* 173 */   public static final String AUTH_SIGN_IN_CONFIRM_OTP_URL = SITE_URL + "/?m=api&a=signInConfirmOTP&v=207";
/* 174 */   public static final String AUTH_SIGN_IN_GOOGLE_URL = SITE_URL + "/?m=api&a=signInWithGoogle&v=207";
/* 175 */   public static final String AUTH_SIGN_IN_STEAM_URL = SITE_URL + "/?m=api&a=signInOrUpWithSteam&v=207";
/* 176 */   public static final String AUTH_SIGN_IN_OKJOY_URL = SITE_URL + "/?m=api&a=signInOrUpWithApptutti&v=207";
/* 177 */   public static final String AUTH_PASSWORD_RESET_URL = SITE_URL + "/?m=api&a=resetPassword&v=207";
/* 178 */   public static final String AUTH_PASSWORD_SET_URL = SITE_URL + "/?m=api&a=setPassword&v=207";
/* 179 */   public static final String AUTH_CONFIRM_EMAIL_URL = SITE_URL + "/?m=api&a=confirmEmail&v=207";
/* 180 */   public static final String AUTH_LINK_ACCOUNT_STATUS_URL = SITE_URL + "/?m=api&a=linkAccountStatus&v=207";
/* 181 */   public static final String AUTH_LINK_STEAM_URL = SITE_URL + "/?m=api&a=linkSteamAccount&v=207";
/* 182 */   public static final String AUTH_NICKNAME_CHANGE_URL = SITE_URL + "/?m=api&a=changeNickname&v=207";
/* 183 */   public static final String AUTH_SIGN_OUT_URL = SITE_URL + "/?m=api&a=signOut&v=207";
/* 184 */   public static final String AUTH_SIGN_UP_URL = SITE_URL + "/?m=api&a=signUp&v=207";
/* 185 */   public static final String AUTH_SIGN_UP_STEAM_URL = SITE_URL + "/?m=api&a=signUpSteam&v=207";
/* 186 */   public static final String AUTH_SIGN_UP_GOOGLE_URL = SITE_URL + "/?m=api&a=signUpGoogle&v=207";
/*     */   
/* 188 */   public static final String REVIEW_URL = SITE_URL + "/?m=api&a=submitReview&v=207";
/* 189 */   public static final String GET_SAVED_GAMES_LIST_URL = SITE_URL + "/?m=api&a=getSavedGamesList&v=207";
/* 190 */   public static final String SET_CLOUD_SAVE_NOTE = SITE_URL + "/?m=api&a=setSavedGameNote&v=207";
/* 191 */   public static final String REQUEST_OF_MERIT_BADGE = SITE_URL + "/?m=api&a=requestOfMeritBadge&v=207";
/* 192 */   public static final String GET_LAST_REPLAYS_TO_RESTORE_PREFERENCES_URL = SITE_URL + "/?m=api&a=getLastReplaysToRestorePreferences&v=207";
/* 193 */   public static final String GET_BACKUPS_TO_RESTORE_PREFERENCES_URL = SITE_URL + "/?m=api&a=getProgressRestorePoints&v=207";
/* 194 */   public static final String GET_BASIC_LEVELS_TOP_LEADERBOARDS_URL = SITE_URL + "/?m=api&a=getBasicLevelsTopLeaderboards&v=207";
/* 195 */   public static final String GET_LEADERBOARDS_URL = SITE_URL + "/?m=api&a=getLeaderboards&v=207";
/* 196 */   public static final String GET_SKILL_POINT_LEADER_BOARD_URL = SITE_URL + "/?m=api&a=getSkillPointLeaderboard&v=207";
/* 197 */   public static final String GET_LEADERBOARDS_RANK_URL = SITE_URL + "/?m=api&a=getLeaderboardsRank&v=207";
/* 198 */   public static final String GET_DAILY_QUEST_LEADERBOARDS_URL = SITE_URL + "/?m=api&a=getDailyQuestLeaderboards&v=207";
/* 199 */   public static final String GET_LEADERBOARDS_ADVANCE_RANK_URL = SITE_URL + "/?m=api&a=getAdvanceLeaderboardsRank&v=207";
/* 200 */   public static final String GET_DAILY_QUEST_LEADERBOARDS_ADVANCE_RANK_URL = SITE_URL + "/?m=api&a=getDailyQuestAdvanceLeaderboardsRank&v=207";
/* 201 */   public static final String GET_LATEST_NEWS_URL = SITE_URL + "/?m=api&a=getLatestNews&v=207";
/* 202 */   public static final String RECEIVE_ISSUED_ITEMS_URL = SITE_URL + "/?m=api&a=receiveIssuedItems&v=207";
/* 203 */   public static final String GET_DAILY_QUEST_INFO_URL = SITE_URL + "/?m=api&a=getDailyQuestInfo&v=207";
/* 204 */   public static final String GET_DAILY_QUEST_HASH_URL = SITE_URL + "/?m=api&a=getDailyQuestHash&v=207";
/* 205 */   public static final String GET_DAILY_QUEST_MAP_URL = SITE_URL + "/?m=api&a=getDailyQuestMap&v=207";
/* 206 */   public static final String GET_RUNTIME_LEADERBOARDS_URL = SITE_URL + "/?m=api&a=getRuntimeLeaderboards&v=207";
/* 207 */   public static final String GET_COMMUNITY_TRANSLATORS_URL = SITE_URL + "/?m=api&a=getCommunityTranslators&v=207";
/* 208 */   public static final String GET_MESSAGES_URL = SITE_URL + "/?m=api&a=getPlayerMessages&v=207";
/* 209 */   public static final String GET_BETA_ACCOUNT_LINK_STATUS_URL = SITE_URL + "/?m=api&a=getBetaAccountLinkStatus&v=207";
/* 210 */   public static final String LINK_BETA_ACCOUNT_URL = SITE_URL + "/?m=api&a=linkBetaAccount&v=207";
/* 211 */   public static final String MARK_MESSAGE_URL = SITE_URL + "/?m=api&a=markMessage&v=207";
/*     */   public static final String ANALYTICS_FOR_ACTIONS_URL = "https://dev.prineside.com/tdi2_player_actions_analytics/?action=submit";
/* 213 */   public static final String GET_ACCOUNT_SETTINGS_URL = SITE_URL + "/?m=api&a=getAccountSettings&v=207";
/* 214 */   public static final String VOTE_MUSIC_URL = SITE_URL + "/?m=api&a=voteMusic&v=207";
/* 215 */   public static final String SUBMIT_MUSIC_URL = SITE_URL + "/?m=api&a=submitMusic&v=207";
/* 216 */   public static final String GET_STEAM_AUTH_TICKET_INFO_URL = SITE_URL + "/?m=api&a=getSteamAuthTicketInfo&v=207";
/* 217 */   public static final String XDX_ROOT_URL = SITE_URL + "/xdx/?url=";
/* 218 */   public static final String XDX_VIEW_NEWS_URL = SITE_URL + "/xdx/?url=news/view&id=";
/* 219 */   public static final String XDX_VIEW_SEASONAL_LEADERBOARD_URL = SITE_URL + "/xdx/?url=seasonal_leaderboard";
/* 220 */   public static final String XDX_VIEW_PLAYER_PROFILE_URL = SITE_URL + "/xdx/?url=profile/view&id=";
/* 221 */   public static final String XDX_VIEW_PLAYER_PROFILE_BY_NICKNAME_URL = SITE_URL + "/xdx/?url=profile/view&nickname=";
/*     */   public static final String DEVELOPER_DOCUMENTATION_URL = "https://infinitode.prineside.com/modding/";
/* 223 */   public static final String STEAM_TXN_PRODUCT_LIST_URL = SITE_URL + "/?m=api&a=steamTxnGetProducts&v=207";
/* 224 */   public static final String STEAM_TXN_START_URL = SITE_URL + "/?m=api&a=steamTxnStart&v=207";
/* 225 */   public static final String STEAM_TXN_FINALIZE_URL = SITE_URL + "/?m=api&a=steamTxnFinalize&v=207";
/*     */   public static final String FEEDBACK_EMAIL = "sup.prineside@gmail.com";
/*     */   public static final String PROFILE_STATUS_DOUBLE_GAIN = "double_gain";
/*     */   public static final String PROFILE_STATUS_PREMIUM = "premium";
/*     */   public static final String PAYMENTS_STORE_PARAM_ANDROID_GOOGLE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA/U+ICp4sQUINhFRq+JaoetZReLuOOb1m1b5qPlxqeSRhGdu0HruaniHqz/96r81gxS14nCWMsBcV6qHQMj54rgPAAUVwMOY9tnf4ET5ObjwxgSpSsa0219FG9r6SbJyyNNOcR7O+4wefwtLItFwt8ItW3IOasyxyEb4frqK6PLiQNs6hTHtANYULlv4UrvTNoijvhLBGL8N2GO5pNMIwwI7GNp+VecmSG/xKD+4E7kZR1F0ZxSew03Zrz0UiVikk3Lgks4WoEwevwNi44OU/P7oqYFDDoHDh81xf+hK8MQ3ijPa8u3EBARBFYN0mc3Hl9w0lrpiKx19PE5yZ48IoUQIDAQAB";
/*     */   
/*     */   public enum ProductId
/*     */   {
/* 233 */     DOUBLE_GAIN,
/* 234 */     PACK_TINY,
/* 235 */     PACK_SMALL,
/* 236 */     PACK_MEDIUM,
/* 237 */     PACK_LARGE,
/* 238 */     PACK_HUGE,
/* 239 */     ACCELERATOR_PACK_TINY,
/* 240 */     ACCELERATOR_PACK_SMALL,
/* 241 */     ACCELERATOR_PACK_MEDIUM,
/* 242 */     ACCELERATOR_PACK_LARGE,
/* 243 */     ACCELERATOR_PACK_HUGE;
/*     */     
/* 245 */     public static ProductId[] values = values();
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/* 252 */   public static String ANDROID_REWARDED_VIDEOS_ID = "ca-app-pub-1337541681212211/4322427738";
/* 253 */   public static String ANDROID_REWARDED_INTERSTITIAL_AD_ID = "ca-app-pub-1337541681212211/6253548041";
/* 254 */   public static String ANDROID_INTERSTITIAL_AD_ID = "ca-app-pub-1337541681212211/5100070865";
/* 255 */   public static String IOS_REWARDED_VIDEOS_ID = "ca-app-pub-1337541681212211/2711212026";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMaxTextureSize() {
/* 270 */     if (b == 0) {
/*     */       try {
/* 272 */         IntBuffer intBuffer = BufferUtils.newIntBuffer(16);
/* 273 */         Gdx.gl20.glGetIntegerv(3379, intBuffer);
/* 274 */         b = intBuffer.get();
/* 275 */       } catch (Exception exception) {
/* 276 */         b = 2048;
/* 277 */         a.e("Failed to get max texture size, falling back to 2048", new Object[0]);
/*     */       } 
/*     */     }
/*     */     
/* 281 */     return b;
/*     */   }
/*     */   
/*     */   public static boolean IS_HEADLESS = false;
/*     */   
/*     */   public static boolean isHeadless() {
/* 287 */     return IS_HEADLESS;
/*     */   }
/*     */   
/* 290 */   private static String c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getModId() {
/* 296 */     if (c == null) {
/* 297 */       c = "";
/*     */       try {
/*     */         File file;
/* 300 */         if ((file = new File("mod_id.txt")).exists() && file.isFile()) {
/* 301 */           FileInputStream fileInputStream = new FileInputStream(file);
/*     */           
/*     */           BufferedReader bufferedReader;
/*     */           String str;
/* 305 */           if ((str = (str = (bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"))).readLine().trim()).replaceAll("[^a-zA-Z0-9]", "")).length() > 0 && str.length() <= 32) {
/* 306 */             c = str;
/* 307 */             a.i("Using mod id: " + c, new Object[0]);
/*     */           } else {
/* 309 */             a.e("Invalid or empty mod id (should be a-zA-Z0-9, 1-32 chars in length)", new Object[0]);
/*     */           } 
/*     */         } 
/* 312 */       } catch (Exception exception) {}
/*     */     } 
/* 314 */     return "".equals(c) ? null : c;
/*     */   }
/*     */   
/*     */   public static boolean isModdingMode() {
/* 318 */     return (getModId() != null);
/*     */   }
/*     */   
/*     */   public static boolean preferencesEncryptionEnabled() {
/* 322 */     return (!isHeadless() && !isModdingMode());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */