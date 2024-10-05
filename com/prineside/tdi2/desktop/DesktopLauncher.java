/*     */ package com.prineside.tdi2.desktop;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
/*     */ import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.pay.PurchaseManager;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.codedisaster.steamworks.SteamAPI;
/*     */ import com.codedisaster.steamworks.SteamApps;
/*     */ import com.codedisaster.steamworks.SteamAuth;
/*     */ import com.codedisaster.steamworks.SteamAuthTicket;
/*     */ import com.codedisaster.steamworks.SteamException;
/*     */ import com.codedisaster.steamworks.SteamFriends;
/*     */ import com.codedisaster.steamworks.SteamFriendsCallback;
/*     */ import com.codedisaster.steamworks.SteamID;
/*     */ import com.codedisaster.steamworks.SteamLeaderboardEntriesHandle;
/*     */ import com.codedisaster.steamworks.SteamLeaderboardHandle;
/*     */ import com.codedisaster.steamworks.SteamNativeHandle;
/*     */ import com.codedisaster.steamworks.SteamResult;
/*     */ import com.codedisaster.steamworks.SteamUser;
/*     */ import com.codedisaster.steamworks.SteamUserCallback;
/*     */ import com.codedisaster.steamworks.SteamUserStats;
/*     */ import com.codedisaster.steamworks.SteamUserStatsCallback;
/*     */ import com.codedisaster.steamworks.SteamUtils;
/*     */ import com.codedisaster.steamworks.SteamUtilsCallback;
/*     */ import com.prineside.tdi2.ActionResolver;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.NormalGame;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.desktop.luadef.javadoc.ParserVariant;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.events.global.Render;
/*     */ import com.prineside.tdi2.managers.PurchaseManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.FocusListener;
/*     */ import com.prineside.tdi2.screens.GameScreen;
/*     */ import com.prineside.tdi2.utils.FileChooser;
/*     */ import com.prineside.tdi2.utils.IntPair;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.Logger;
/*     */ import com.prineside.tdi2.utils.logging.PlatformLogger;
/*     */ import com.prineside.tdi2.utils.logging.SystemOutPlatformLogger;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import io.github.classgraph.ClassGraph;
/*     */ import io.github.classgraph.ClassInfo;
/*     */ import io.github.classgraph.ScanResult;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashSet;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DesktopLauncher
/*     */ {
/*  77 */   private static final TLog a = TLog.forTag("DesktopLauncher");
/*     */   
/*     */   private static Lwjgl3ApplicationConfiguration b;
/*     */   
/*     */   public static SteamUser steamUser;
/*     */   
/*     */   public static SteamUserStats steamUserStats;
/*     */   
/*     */   public static SteamUtils steamUtils;
/*     */   
/*     */   public static SteamApps steamApps;
/*     */   public static SteamFriends steamFriends;
/*     */   public static SteamPurchaseManager purchaseManager;
/*  90 */   private static final ObjectMap<String, String> c = new ObjectMap();
/*     */   
/*  92 */   private static final SteamUserCallback d = new SteamUserCallback()
/*     */     {
/*     */       public void onAuthSessionTicket(SteamAuthTicket param1SteamAuthTicket, SteamResult param1SteamResult) {
/*  95 */         DesktopLauncher.a().i("SteamUser.onAuthSessionTicket " + param1SteamAuthTicket + " " + param1SteamResult, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onValidateAuthTicket(SteamID param1SteamID1, SteamAuth.AuthSessionResponse param1AuthSessionResponse, SteamID param1SteamID2) {
/* 100 */         DesktopLauncher.a().i("SteamUser.onValidateAuthTicket " + param1SteamID1 + " " + param1AuthSessionResponse + " " + param1SteamID2, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onMicroTxnAuthorization(int param1Int, long param1Long, boolean param1Boolean) {
/* 105 */         DesktopLauncher.a().i("SteamUser.onMicroTxnAuthorization " + param1Int + " " + param1Long + " " + param1Boolean, new Object[0]);
/*     */         
/* 107 */         DesktopLauncher.purchaseManager.onMicroTxnAuthorization(param1Int, param1Long, param1Boolean);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onEncryptedAppTicket(SteamResult param1SteamResult) {
/* 112 */         DesktopLauncher.a().i("SteamUser.onEncryptedAppTicket " + param1SteamResult, new Object[0]);
/*     */       }
/*     */     };
/*     */   
/* 116 */   private static final SteamUserStatsCallback e = new SteamUserStatsCallback()
/*     */     {
/*     */       public void onUserStatsReceived(long param1Long, SteamID param1SteamID, SteamResult param1SteamResult) {
/* 119 */         DesktopLauncher.a().i("SteamUserStats.onUserStatsReceived " + param1Long + " " + param1SteamID + " " + param1SteamResult, new Object[0]);
/* 120 */         DesktopLauncher.a(true);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onUserStatsStored(long param1Long, SteamResult param1SteamResult) {
/* 125 */         DesktopLauncher.a().i("SteamUserStats.onUserStatsStored " + param1Long + " " + param1SteamResult, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onUserStatsUnloaded(SteamID param1SteamID) {
/* 130 */         DesktopLauncher.a().i("SteamUserStats.onUserStatsUnloaded " + param1SteamID, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onUserAchievementStored(long param1Long, boolean param1Boolean, String param1String, int param1Int1, int param1Int2) {
/* 135 */         DesktopLauncher.a().i("SteamUserStats.onUserAchievementStored " + param1Long + " " + param1Boolean + " " + param1String + " " + param1Int1 + " " + param1Int2, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onLeaderboardFindResult(SteamLeaderboardHandle param1SteamLeaderboardHandle, boolean param1Boolean) {
/* 140 */         DesktopLauncher.a().i("SteamUserStats.onLeaderboardFindResult " + param1SteamLeaderboardHandle + " " + param1Boolean, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onLeaderboardScoresDownloaded(SteamLeaderboardHandle param1SteamLeaderboardHandle, SteamLeaderboardEntriesHandle param1SteamLeaderboardEntriesHandle, int param1Int) {
/* 145 */         DesktopLauncher.a().i("SteamUserStats.onLeaderboardScoresDownloaded " + param1SteamLeaderboardHandle + " " + param1SteamLeaderboardEntriesHandle + " " + param1Int, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onLeaderboardScoreUploaded(boolean param1Boolean1, SteamLeaderboardHandle param1SteamLeaderboardHandle, int param1Int1, boolean param1Boolean2, int param1Int2, int param1Int3) {
/* 150 */         DesktopLauncher.a().i("SteamUserStats.onLeaderboardScoreUploaded " + param1Boolean1 + " " + param1SteamLeaderboardHandle + " " + param1Int1 + " " + param1Boolean2 + " " + param1Int2 + " " + param1Int3, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onNumberOfCurrentPlayersReceived(boolean param1Boolean, int param1Int) {
/* 155 */         DesktopLauncher.a().i("SteamUserStats.onNumberOfCurrentPlayersReceived " + param1Boolean + " " + param1Int, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/*     */       public void onGlobalStatsReceived(long param1Long, SteamResult param1SteamResult) {
/* 160 */         DesktopLauncher.a().i("SteamUserStats.onGlobalStatsReceived " + param1Long + " " + param1SteamResult, new Object[0]);
/*     */       }
/*     */     };
/*     */   
/* 164 */   private static final SteamUtilsCallback f = new SteamUtilsCallback()
/*     */     {
/*     */       public void onSteamShutdown() {
/* 167 */         DesktopLauncher.a().i("SteamUtils.onSteamShutdown", new Object[0]);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 172 */   private static final SteamFriendsCallback g = new SteamFriendsCallback()
/*     */     {
/*     */       public void onSetPersonaNameResponse(boolean param1Boolean1, boolean param1Boolean2, SteamResult param1SteamResult) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onPersonaStateChange(SteamID param1SteamID, SteamFriends.PersonaChange param1PersonaChange) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGameOverlayActivated(boolean param1Boolean) {
/* 185 */         DesktopLauncher.a().i("SteamFriendsCallback.onGameOverlayActivated " + param1Boolean, new Object[0]);
/* 186 */         if (Gdx.app != null) {
/* 187 */           Threads.i().postRunnable(() -> {
/*     */                 try {
/*     */                   Screen screen;
/*     */                   
/*     */                   GameScreen gameScreen;
/*     */                   
/*     */                   if (screen = Game.i.screenManager.getCurrentScreen() instanceof GameScreen && (gameScreen = (GameScreen)screen).S != null && gameScreen.S.gameState != null && !gameScreen.S.gameState.isGameOver()) {
/*     */                     gameScreen.S.gameState.pauseGame();
/*     */                   }
/*     */                   
/*     */                   return;
/* 198 */                 } catch (Exception exception) {
/*     */                   DesktopLauncher.a().e("Failed to handle onGameOverlayActivated", new Object[] { exception });
/*     */                   return;
/*     */                 } 
/*     */               });
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGameLobbyJoinRequested(SteamID param1SteamID1, SteamID param1SteamID2) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAvatarImageLoaded(SteamID param1SteamID, int param1Int1, int param1Int2, int param1Int3) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onFriendRichPresenceUpdate(SteamID param1SteamID, int param1Int) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGameRichPresenceJoinRequested(SteamID param1SteamID, String param1String) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGameServerChangeRequested(String param1String1, String param1String2) {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean h = false;
/*     */ 
/*     */   
/*     */   private static boolean i = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 237 */     if (paramArrayOfString.length != 0 && "generate-lua-defs".equals(paramArrayOfString[0])) {
/*     */       ActionResolver actionResolver;
/* 239 */       Logger.init(actionResolver = ActionResolver.createDummy((FileHandle)new Lwjgl3FileHandle("luadef-gen-log.txt", Files.FileType.Local), (PlatformLogger)new SystemOutPlatformLogger(true, true)));
/*     */       
/* 241 */       a.i("Starting Lua definitions generator", new Object[0]);
/*     */       try {
/* 243 */         boolean bool = false; int m; byte b;
/* 244 */         for (m = (paramArrayOfString = paramArrayOfString).length, b = 0; b < m; ) { String str = paramArrayOfString[b];
/* 245 */           if ("-v".equals(str)) {
/* 246 */             bool = true; break;
/*     */           } 
/*     */           b++; }
/*     */         
/* 250 */         LuaDefinitionsGenerator.verbose = bool;
/* 251 */         ParserVariant.verbose = bool;
/* 252 */         ParserVariant.verboseGenerics = bool;
/* 253 */         ParserVariant.verboseParamMatch = bool;
/* 254 */         (new LuaDefinitionsGenerator()).runEverything(); return;
/* 255 */       } catch (IOException iOException) {
/* 256 */         throw new RuntimeException(iOException);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 261 */     ActionResolverDesktop actionResolverDesktop = new ActionResolverDesktop();
/*     */ 
/*     */     
/* 264 */     (b = new Lwjgl3ApplicationConfiguration()).setTitle("Infinitode 2");
/* 265 */     b.setWindowIcon(new String[] { "res/logo-32.png" });
/*     */ 
/*     */     
/*     */     ActionResolver.InitConfigManager initConfigManager;
/*     */ 
/*     */     
/* 271 */     int i = (initConfigManager = actionResolverDesktop.getInitConfigManager()).get(SettingsManager.InitConfig.AUDIO_SIM_SOURCES);
/* 272 */     int j = initConfigManager.get(SettingsManager.InitConfig.AUDIO_BUFFER_SIZE);
/* 273 */     int k = initConfigManager.get(SettingsManager.InitConfig.AUDIO_BUFFER_COUNT);
/* 274 */     b.setAudioConfig(i, j, k);
/*     */ 
/*     */     
/* 277 */     b.setBackBufferConfig(8, 8, 8, 8, 16, 0, initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS));
/* 278 */     b.useVsync((initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_VSYNC) != 0));
/* 279 */     b.setIdleFPS(initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FPS_LIMIT));
/* 280 */     b.setForegroundFPS(initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FPS_LIMIT));
/*     */     
/* 282 */     b.setWindowedMode(1600, 900);
/*     */     
/* 284 */     NormalGame normalGame = new NormalGame((ActionResolver)actionResolverDesktop, () -> {
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/*     */ 
/*     */             
/*     */             try {
/*     */               SteamAPI.loadLibraries();
/* 293 */             } catch (Throwable throwable) {
/*     */               a.w("failed to execute SteamAPI.loadLibraries() - probably the user has unicode characters in their OS user name, trying manually", new Object[] { throwable });
/*     */               
/*     */               try {
/*     */                 System.load((new File("bin/steam_api64.dll")).getAbsolutePath());
/*     */                 System.load((new File("bin/steamworks4j64.dll")).getAbsolutePath());
/*     */                 Field field;
/*     */                 (field = SteamAPI.class.getDeclaredField("isNativeAPILoaded")).setAccessible(true);
/*     */                 field.setBoolean(null, true);
/* 302 */               } catch (Throwable throwable1) {
/*     */                 a.e("failed to load steam dlls manually", new Object[] { throwable1 });
/*     */               } 
/*     */             } 
/*     */             
/*     */             if (!SteamAPI.init()) {
/*     */               a.e("SteamAPI failed to init", new Object[0]);
/*     */               
/*     */               SteamAPI.printDebugInfo(System.out);
/*     */               
/*     */               boolean bool = SteamAPI.restartAppIfNecessary(937310);
/*     */               
/*     */               a.i("restartAppIfNecessary = " + bool, new Object[0]);
/*     */               
/*     */               if (!bool) {
/*     */                 JOptionPane.showMessageDialog(null, "SteamAPI failed to init, make sure Steam is running");
/*     */               }
/*     */               System.exit(0);
/*     */             } else {
/*     */               a.i("SteamAPI loaded", new Object[0]);
/*     */               e();
/*     */             } 
/* 324 */           } catch (Throwable throwable) {
/*     */             a.e("SteamAPI failed to init with exception", new Object[] { throwable });
/*     */             
/*     */             JOptionPane.showMessageDialog(null, "SteamAPI failed to init with error: " + throwable.getMessage());
/*     */             
/*     */             System.exit(0);
/*     */           } 
/*     */           
/*     */           if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) != 0) {
/*     */             a.d("full screen mode enabled through config, applying", new Object[0]);
/*     */             
/*     */             int i = paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_WIDTH);
/*     */             
/*     */             int j = paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_HEIGHT);
/*     */             
/*     */             boolean bool;
/*     */             
/*     */             if (bool = (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS) != 0) ? true : false) {
/*     */               Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode();
/*     */               
/*     */               Gdx.graphics.setUndecorated(true);
/*     */               
/*     */               Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height);
/*     */               
/*     */               a.i("full screen windowed borderless", new Object[0]);
/*     */             } else if (i <= 0 || j <= 0) {
/*     */               Gdx.graphics.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
/*     */               a.i("full screen mode set to values retrieved from LWJGL", new Object[0]);
/*     */             } else {
/*     */               Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
/*     */               Gdx.graphics.setFullscreenMode(SettingsManager.getBestFullscreenModeWithPrefDimensions(i, j, dimension.width, dimension.height));
/*     */               a.i("full screen mode set to values specified in config", new Object[0]);
/*     */             } 
/*     */           } else {
/*     */             a.d("full screen mode not enabled through config", new Object[0]);
/*     */             try {
/*     */               int i = 0;
/*     */               int j = 0;
/*     */               Graphics.DisplayMode[] arrayOfDisplayMode;
/*     */               int k = (arrayOfDisplayMode = Gdx.graphics.getDisplayModes()).length;
/*     */               for (byte b = 0; b < k; b++) {
/*     */                 Graphics.DisplayMode displayMode = arrayOfDisplayMode[b];
/*     */                 i = Math.max(i, displayMode.width);
/*     */                 j = Math.max(j, displayMode.height);
/*     */               } 
/*     */               if (i <= 1440.0F || j <= 810.0F) {
/*     */                 a.i("display is too small, falling back to windowed 1280x720", new Object[0]);
/*     */                 Gdx.app.postRunnable(());
/*     */               } 
/* 373 */             } catch (Exception exception) {}
/*     */           } 
/*     */           Game.EVENTS.getListeners(Render.class).add(());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void e() {
/* 475 */     a.d("Steam: Register user...", new Object[0]);
/* 476 */     steamUser = new SteamUser(d);
/* 477 */     a.d("Steam: Register user stats callback...", new Object[0]);
/* 478 */     steamUserStats = new SteamUserStats(e);
/*     */ 
/*     */ 
/*     */     
/* 482 */     a.d("Steam: Register Utils...", new Object[0]);
/* 483 */     steamUtils = new SteamUtils(f);
/*     */     
/* 485 */     a.d("Steam: Register Apps...", new Object[0]);
/* 486 */     steamApps = new SteamApps();
/*     */     
/* 488 */     a.d("Steam: Register Friends...", new Object[0]);
/* 489 */     System.out.println("Register Friends ...");
/* 490 */     steamFriends = new SteamFriends(g);
/*     */     
/* 492 */     a.d("Steam: Local user account ID: " + steamUser.getSteamID().getAccountID(), new Object[0]);
/* 493 */     a.d("Steam: Local user steam ID: " + SteamID.getNativeHandle((SteamNativeHandle)steamUser.getSteamID()), new Object[0]);
/* 494 */     a.d("Steam: App ID: " + steamUtils.getAppID(), new Object[0]);
/* 495 */     a.d("Steam: App build ID: " + steamApps.getAppBuildId(), new Object[0]);
/* 496 */     a.d("Steam: App owner: " + steamApps.getAppOwner().getAccountID(), new Object[0]);
/* 497 */     a.d("Steam: App purchase time: " + steamApps.getEarliestPurchaseUnixTime(937310), new Object[0]);
/* 498 */     a.d("Steam: App subscribed from free weekend: " + steamApps.isSubscribedFromFreeWeekend(), new Object[0]);
/* 499 */     a.d("Steam: App subscribed: " + steamApps.isSubscribedApp(937310), new Object[0]);
/* 500 */     a.d("Steam: Friends persona name: " + steamFriends.getPersonaName(), new Object[0]);
/*     */     
/* 502 */     c.put("steam.account_id", steamUser.getSteamID().getAccountID());
/* 503 */     c.put("steam.user_id", SteamID.getNativeHandle((SteamNativeHandle)steamUser.getSteamID()));
/* 504 */     c.put("steam.app_id", steamUtils.getAppID());
/* 505 */     c.put("steam.app_build_id", steamApps.getAppBuildId());
/* 506 */     c.put("steam.owner_id", steamApps.getAppOwner().getAccountID());
/* 507 */     c.put("steam.purchase_time", steamApps.getEarliestPurchaseUnixTime(937310));
/* 508 */     c.put("steam.purchased_from_free_weekend", steamApps.isSubscribedFromFreeWeekend());
/* 509 */     c.put("steam.app_subscribed", steamApps.isSubscribedApp(937310));
/* 510 */     c.put("steam.persona_name", steamFriends.getPersonaName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ActionResolverDesktop
/*     */     extends ActionResolver.ActionResolverAdapter
/*     */   {
/*     */     private ActionResolver.InitConfigManager a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private DesktopFileChooser b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PurchaseManager getPurchaseManager() {
/* 597 */       if (DesktopLauncher.steamApps == null) return null;
/*     */       
/* 599 */       if (DesktopLauncher.purchaseManager == null)
/*     */       {
/* 601 */         DesktopLauncher.purchaseManager = new SteamPurchaseManager();
/*     */       }
/*     */       
/* 604 */       return DesktopLauncher.purchaseManager;
/*     */     }
/*     */ 
/*     */     
/*     */     public HashSet<Class<?>> getClasses(String param1String) {
/*     */       HashSet<Class<Object>> hashSet;
/* 610 */       (hashSet = new HashSet<>()).add(Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ScanResult scanResult;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 621 */       for (ClassInfo classInfo : (scanResult = (new ClassGraph()).removeTemporaryFilesAfterScan().enableSystemJarsAndModules().ignoreClassVisibility().acceptPackages(new String[] { param1String }).scan()).getAllClasses()) {
/*     */         try {
/* 623 */           Class<?> clazz = Class.forName(classInfo.getName());
/* 624 */           hashSet.add(clazz);
/* 625 */         } catch (Throwable throwable) {}
/*     */       } 
/*     */ 
/*     */       
/* 629 */       scanResult.close();
/*     */       
/* 631 */       return hashSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean personalizedAdsSupported() {
/* 636 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean personalizedAdsEnabled() {
/* 641 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setPersonalizedAds(boolean param1Boolean) {
/* 646 */       this.c = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public FileChooser getFileChooser() {
/* 651 */       if (this.b == null) {
/* 652 */         this.b = new DesktopFileChooser();
/*     */       }
/* 654 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void requestSteamAuthTicket(ObjectConsumer<String> param1ObjectConsumer) {
/* 659 */       if (DesktopLauncher.steamUser != null) {
/* 660 */         int[] arrayOfInt = { 0 };
/* 661 */         ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
/*     */         try {
/* 663 */           DesktopLauncher.steamUser.getAuthSessionTicket(byteBuffer, arrayOfInt);
/* 664 */           byte[] arrayOfByte = new byte[arrayOfInt[0]];
/* 665 */           byteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
/*     */           
/* 667 */           String str = StringFormatter.bytesToHex(arrayOfByte);
/* 668 */           param1ObjectConsumer.accept(str);
/* 669 */         } catch (SteamException steamException) {
/* 670 */           DesktopLauncher.a().e("getAuthSessionTicket failed", new Object[] { steamException });
/* 671 */           param1ObjectConsumer.accept(null); return;
/*     */         } 
/*     */       } else {
/* 674 */         param1ObjectConsumer.accept(null);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ActionResolver.InitConfigManager getInitConfigManager() {
/* 680 */       if (this.a == null) {
/* 681 */         this.a = new ActionResolver.InitConfigManager(this)
/*     */           {
/*     */             public boolean isAvailable(SettingsManager.InitConfig param2InitConfig) {
/* 684 */               switch (DesktopLauncher.null.a[param2InitConfig.ordinal()]) {
/*     */                 case 1:
/*     */                 case 2:
/*     */                 case 3:
/*     */                 case 4:
/*     */                 case 5:
/*     */                 case 6:
/*     */                 case 7:
/*     */                 case 8:
/*     */                 case 9:
/*     */                 case 10:
/*     */                 case 11:
/*     */                 case 12:
/*     */                 case 13:
/*     */                 case 14:
/* 699 */                   return true;
/*     */               } 
/* 701 */               return false;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public int getDefault(SettingsManager.InitConfig param2InitConfig) {
/* 707 */               switch (DesktopLauncher.null.a[param2InitConfig.ordinal()]) { case 1:
/* 708 */                   return 1;
/* 709 */                 case 2: return 1024;
/* 710 */                 case 4: return 18;
/* 711 */                 case 5: return 56;
/* 712 */                 case 6: return 4;
/* 713 */                 case 7: return 0;
/* 714 */                 case 9: return 1;
/* 715 */                 case 10: return 0;
/* 716 */                 case 3: return -1;
/* 717 */                 case 8: return -1;
/* 718 */                 case 11: return 1;
/* 719 */                 case 12: return 0;
/* 720 */                 case 14: return 0; }
/*     */ 
/*     */               
/* 723 */               return 0;
/*     */             }
/*     */           };
/*     */       }
/*     */       
/* 728 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectMap<String, String> getDeviceInfo() {
/* 733 */       DesktopLauncher.b().put("id", "Desktop");
/*     */       try {
/* 735 */         DesktopLauncher.b().put("screen-res", Toolkit.getDefaultToolkit().getScreenResolution());
/* 736 */       } catch (Exception exception) {}
/*     */       
/* 738 */       DesktopLauncher.b().put("os.name", System.getProperty("os.name", "?"));
/* 739 */       DesktopLauncher.b().put("os.arch", System.getProperty("os.arch", "?"));
/* 740 */       DesktopLauncher.b().put("java.version", System.getProperty("java.version", "?"));
/*     */       
/* 742 */       return DesktopLauncher.b();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean doubleGainEnabledBySteamGamePurchase() {
/* 749 */       if (!this.d) DesktopLauncher.a().i("eligibleForFreeDoubleGain called", new Object[0]);
/*     */       
/* 751 */       if (DesktopLauncher.steamApps != null) {
/* 752 */         if (!this.d) DesktopLauncher.a().i("steamApps not null", new Object[0]); 
/* 753 */         int i = DesktopLauncher.steamApps.getEarliestPurchaseUnixTime(937310);
/* 754 */         if (!this.d) DesktopLauncher.a().i("getEarliestPurchaseUnixTime " + i, new Object[0]); 
/* 755 */         DesktopLauncher.b().put("steam.earliestPurchaseUnixTime", String.valueOf(i));
/* 756 */         this.d = true;
/*     */         
/* 758 */         return (i < 1634178509);
/*     */       } 
/* 760 */       if (!this.d) DesktopLauncher.a().i("steamApps is null", new Object[0]); 
/* 761 */       this.d = true;
/* 762 */       DesktopLauncher.b().put("steam.earliestPurchaseUnixTime", "no steamApps");
/* 763 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String glGetStringi(int param1Int1, int param1Int2) {
/* 769 */       return GL30.glGetStringi(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getWindowsGraphicsScale() {
/*     */       try {
/* 775 */         return Toolkit.getDefaultToolkit().getScreenResolution();
/* 776 */       } catch (Exception exception) {
/* 777 */         DesktopLauncher.a().e("failed to call java.awt.Toolkit.getDefaultToolkit().getScreenResolution()", new Object[] { exception });
/* 778 */         return 120;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void unlockAchievement(AchievementType param1AchievementType) {
/* 784 */       if (DesktopLauncher.c() && DesktopLauncher.steamUserStats != null)
/*     */         try {
/* 786 */           DesktopLauncher.steamUserStats.setAchievement("ACHIEVEMENT_" + param1AchievementType.name());
/* 787 */           DesktopLauncher.steamUserStats.storeStats(); return;
/* 788 */         } catch (Exception exception) {
/* 789 */           DesktopLauncher.a().e("failed to unlock achievement " + param1AchievementType, new Object[] { exception });
/*     */           return;
/*     */         }  
/* 792 */       DesktopLauncher.a().e("steam user stats are not loaded yet", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFpsLimit(int param1Int) {
/* 798 */       DesktopLauncher.d().setForegroundFPS(param1Int);
/* 799 */       DesktopLauncher.d().setIdleFPS(param1Int);
/* 800 */       Gdx.graphics.setForegroundFPS(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getShortDeviceInfo() {
/* 805 */       return System.getProperty("os.name", "?") + " / " + 
/* 806 */         System.getProperty("os.arch", "?") + " / " + 
/* 807 */         System.getProperty("java.version", "?");
/*     */     }
/*     */ 
/*     */     
/*     */     public IntPair getBestScreenResolution() {
/*     */       try {
/* 813 */         Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
/* 814 */         return new IntPair(dimension.width, dimension.height);
/* 815 */       } catch (Exception exception) {
/* 816 */         DesktopLauncher.a().e("failed to get best screen resolution", new Object[] { exception });
/* 817 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static long a(long param1Long) {
/*     */       String str;
/*     */       int i;
/* 829 */       if ((i = (str = ManagementFactory.getRuntimeMXBean().getName()).indexOf('@')) <= 0)
/*     */       {
/* 831 */         return -1L;
/*     */       }
/*     */       
/*     */       try {
/* 835 */         return Long.parseLong(str.substring(0, i));
/* 836 */       } catch (Exception exception) {
/*     */         
/* 838 */         return -1L;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onExit() {
/* 843 */       DesktopLauncher.a().i("onExit", new Object[0]);
/*     */       try {
/* 845 */         if (DesktopLauncher.steamUser != null) {
/* 846 */           DesktopLauncher.steamUser.dispose();
/* 847 */           DesktopLauncher.steamUser = null;
/*     */         } 
/* 849 */         if (DesktopLauncher.steamUserStats != null) {
/* 850 */           DesktopLauncher.steamUserStats.dispose();
/* 851 */           DesktopLauncher.steamUserStats = null;
/*     */         } 
/* 853 */         if (DesktopLauncher.steamUtils != null) {
/* 854 */           DesktopLauncher.steamUtils.dispose();
/* 855 */           DesktopLauncher.steamUtils = null;
/*     */         } 
/* 857 */         if (DesktopLauncher.steamApps != null) {
/* 858 */           DesktopLauncher.steamApps.dispose();
/* 859 */           DesktopLauncher.steamApps = null;
/*     */         } 
/* 861 */         if (DesktopLauncher.steamFriends != null) {
/* 862 */           DesktopLauncher.steamFriends.dispose();
/* 863 */           DesktopLauncher.steamFriends = null;
/*     */         } 
/* 865 */         SteamAPI.shutdown();
/* 866 */         DesktopLauncher.a().i("SteamAPI shutdown", new Object[0]);
/* 867 */       } catch (Exception exception) {
/* 868 */         DesktopLauncher.a().e("failed to stop steam", new Object[] { exception });
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 910 */       (thread = new Thread(() -> { System.out.println("Started killer thread"); for (byte b = 0; b < 10; b++) { try { System.out.println("Killer is sleeping " + (b + 1) + "/10"); Thread.sleep(100L); } catch (Exception exception) { System.out.println("Interrupted the killer thread"); exception.printStackTrace(); return; }  }  System.out.println("Game is still running, trying to kill"); long l; if ((l = a(-1L)) != -1L) { try { System.out.println("Killing process id " + l); Process process; (process = Runtime.getRuntime().exec("taskkill /PID " + l + " /F")).waitFor(); } catch (Throwable throwable2) { Throwable throwable1; (throwable1 = null).printStackTrace(); }  } else { try { System.out.println("Process id not found, killing by name"); Process process; (process = Runtime.getRuntime().exec("taskkill /F /IM infinitode-2.exe")).waitFor(); } catch (Throwable throwable2) { Throwable throwable1; (throwable1 = null).printStackTrace(); }  }  try { Runtime.getRuntime().halt(0); return; } catch (Throwable throwable2) { Throwable throwable1; (throwable1 = null).printStackTrace(); return; }  }"Game killer")).setDaemon(true);
/* 911 */       thread.start();
/*     */     }
/*     */ 
/*     */     
/*     */     public void getMobilePasswordInput(Input.TextInputListener param1TextInputListener, String param1String1, String param1String2, String param1String3) {
/* 916 */       throw new RuntimeException("Only for mobile devices");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean rewardAdsAvailable() {
/* 923 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canShowRewardAd() {
/* 930 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasGoogleAuth() {
/* 939 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSignedInWithGoogle() {
/* 944 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void requestGoogleAuth(ObjectConsumer<String> param1ObjectConsumer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void signOutGoogle() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSecondsTillCanShowRewardAd() {
/* 961 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void showRewardAd(ObjectConsumer<Boolean> param1ObjectConsumer, PurchaseManager.RewardingAdsType param1RewardingAdsType) {
/* 966 */       param1ObjectConsumer.accept(Boolean.TRUE);
/*     */     }
/*     */ 
/*     */     
/*     */     public FileHandle getLogFile() {
/* 971 */       return (FileHandle)new Lwjgl3FileHandle("log.txt", Files.FileType.Local);
/*     */     }
/*     */ 
/*     */     
/*     */     public PlatformLogger createPlatformLogger() {
/* 976 */       return (PlatformLogger)new SystemOutPlatformLogger(true, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isAppModified() {
/* 981 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleTextFieldFocus(FocusListener.FocusEvent param1FocusEvent, TextField param1TextField, boolean param1Boolean) {
/*     */       try {
/* 987 */         if (DesktopLauncher.steamUtils == null)
/*     */           return; 
/* 989 */         if (param1Boolean) {
/* 990 */           Vector2 vector21 = param1TextField.localToScreenCoordinates(new Vector2());
/* 991 */           Vector2 vector22 = param1TextField.localToScreenCoordinates(new Vector2(param1TextField.getWidth(), param1TextField.getHeight()));
/* 992 */           DesktopLauncher.steamUtils.showFloatingGamepadTextInput(SteamUtils.FloatingGamepadTextInputMode.ModeSingleLine, (int)vector21.x, (int)vector21.y, (int)(vector22.x - vector21.x), (int)(vector22.y - vector21.y));
/*     */         } else {
/* 994 */           DesktopLauncher.steamUtils.dismissFloatingGamepadTextInput(); return;
/*     */         } 
/* 996 */       } catch (Exception exception) {
/* 997 */         DesktopLauncher.a().e("failed to show gamepad input", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\DesktopLauncher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */