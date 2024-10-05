/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Screen;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.UserMap;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.screens.AccountSettingsScreen;
/*     */ import com.prineside.tdi2.screens.CrashReportScreen;
/*     */ import com.prineside.tdi2.screens.CustomMapSelectScreen;
/*     */ import com.prineside.tdi2.screens.GameScreen;
/*     */ import com.prineside.tdi2.screens.HotkeyScreen;
/*     */ import com.prineside.tdi2.screens.LanguageSelectScreen;
/*     */ import com.prineside.tdi2.screens.LevelSelectScreen;
/*     */ import com.prineside.tdi2.screens.LoadingScreen;
/*     */ import com.prineside.tdi2.screens.MainMenuScreen;
/*     */ import com.prineside.tdi2.screens.MapEditorScreen;
/*     */ import com.prineside.tdi2.screens.MoneyScreen;
/*     */ import com.prineside.tdi2.screens.ResearchesScreen;
/*     */ import com.prineside.tdi2.screens.SettingsScreen;
/*     */ import com.prineside.tdi2.screens.SimulationScreen;
/*     */ import com.prineside.tdi2.screens.StatisticsScreen;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.GameSyncLoader;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = ScreenManager.Serializer.class)
/*     */ public class ScreenManager extends Manager.ManagerAdapter {
/*     */   private Screen b;
/*  42 */   private static final TLog a = TLog.forClass(ScreenManager.class);
/*     */   public static interface ScreenManagerListener {
/*     */     void screenChanged(); }
/*     */   public static class Serializer extends SingletonSerializer<ScreenManager> { public ScreenManager read() {
/*  46 */       return Game.i.screenManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*  51 */   private final DelayedRemovalArray<ScreenManagerListener> c = new DelayedRemovalArray(false, 1);
/*     */   
/*     */   private long d;
/*     */ 
/*     */   
/*     */   public ScreenManager() {
/*  57 */     this.d = Game.getTimestampMillis();
/*     */   }
/*     */   private void a() {
/*  60 */     long l = Game.getRealTickCount();
/*  61 */     if ((getCurrentScreen() instanceof GameScreen || getCurrentScreen() instanceof MapEditorScreen) && 
/*  62 */       Game.i.purchaseManager.noIAPAbility()) {
/*  63 */       a.i("noIAPAbility true, dyn setting: " + Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_NOT_AVAILABLE_IN_COUNTRY), new Object[0]);
/*  64 */       if (Game.getTimestampMillis() - this.d > 180000L) {
/*  65 */         this.d = Game.getTimestampMillis();
/*  66 */         a.i("interstitial show start", new Object[0]);
/*  67 */         Game.i.actionResolver.showInterstitialAd(paramBoolean -> a.i("interstitial show " + paramBoolean, new Object[0]));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (this.b != null) {
/*  75 */       this.b.dispose();
/*  76 */       this.b = null;
/*     */     } 
/*     */     
/*  79 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("ScreenManager-disposeScreen", Game.getRealTickCount() - l);
/*     */     
/*  81 */     Game.i.actionResolver.getInitConfigManager().saveIfRequired();
/*     */   }
/*     */   
/*     */   public void setNoScreen() {
/*  85 */     a();
/*  86 */     setScreen(null);
/*     */   }
/*     */   
/*     */   public Screen getCurrentScreen() {
/*  90 */     return this.b;
/*     */   }
/*     */   
/*     */   public void addListener(ScreenManagerListener paramScreenManagerListener) {
/*  94 */     if (paramScreenManagerListener == null) {
/*  95 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/*  98 */     if (!this.c.contains(paramScreenManagerListener, true)) {
/*  99 */       this.c.add(paramScreenManagerListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setScreen(Screen paramScreen) {
/* 104 */     a();
/*     */     
/* 106 */     Game.i.setScreen((Screen)paramScreen);
/* 107 */     this.b = paramScreen;
/*     */     
/* 109 */     if (!Config.isHeadless()) a.i("setting screen: " + paramScreen.getClass().getSimpleName(), new Object[0]);
/*     */     
/* 111 */     this.c.begin();
/* 112 */     for (Array.ArrayIterator<ScreenManagerListener> arrayIterator = this.c.iterator(); arrayIterator.hasNext();) {
/* 113 */       (screenManagerListener = arrayIterator.next()).screenChanged();
/*     */     }
/* 115 */     this.c.end();
/*     */     
/* 117 */     Game.i.actionResolver.logScreenChange(paramScreen.getClass().getSimpleName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startNewBasicLevel(BasicLevel paramBasicLevel, @Null AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration) {
/* 125 */     a();
/*     */     
/* 127 */     DifficultyMode difficultyMode = Game.i.progressManager.getDifficultyMode();
/*     */ 
/*     */ 
/*     */     
/* 131 */     GameScreen gameScreen = new GameScreen(paramBasicLevel, difficultyMode, Game.i.progressManager.getDifficultyModeDiffMultiplier(difficultyMode), paramSelectedAbilitiesConfiguration, -1L, null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     setScreen((Screen)gameScreen);
/*     */   }
/*     */   
/*     */   public void startNewDailyLevel(DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) {
/* 140 */     a();
/* 141 */     GameScreen gameScreen = new GameScreen(paramDailyQuestLevel);
/* 142 */     setScreen((Screen)gameScreen);
/*     */   }
/*     */   
/*     */   public void startNewUserLevel(UserMap paramUserMap, AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration) {
/* 146 */     a();
/*     */     
/* 148 */     DifficultyMode difficultyMode = Game.i.progressManager.getDifficultyMode();
/* 149 */     setScreen((Screen)new GameScreen(paramUserMap, difficultyMode, Game.i.progressManager
/*     */ 
/*     */           
/* 152 */           .getDifficultyModeDiffMultiplier(difficultyMode), paramSelectedAbilitiesConfiguration, -1L, Game.i.userMapManager
/*     */ 
/*     */           
/* 155 */           .getDefaultBosses(), null, null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void goToCrashReportScreen(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 162 */     a();
/*     */     
/* 164 */     setScreen((Screen)new CrashReportScreen(paramString1, paramString2, paramString3, paramString4));
/*     */   }
/*     */   
/*     */   public void goToAccountSettingsScreen() {
/* 168 */     if (Config.isModdingMode()) {
/* 169 */       Notifications.i().add("Not available in modding mode", null, null, StaticSoundType.FAIL);
/*     */       
/*     */       return;
/*     */     } 
/* 173 */     a();
/*     */     
/* 175 */     setScreen((Screen)new AccountSettingsScreen());
/*     */   }
/*     */   
/*     */   public void goToMoneyScreen() {
/* 179 */     if (Config.isModdingMode()) {
/* 180 */       Notifications.i().add("Not available in modding mode", null, null, StaticSoundType.FAIL);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 188 */     MoneyScreen moneyScreen = new MoneyScreen((Screen)this.b);
/* 189 */     setScreen((Screen)moneyScreen);
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
/*     */   public void goToCustomMapSelectScreen() {
/* 221 */     a();
/*     */     
/* 223 */     setScreen((Screen)new CustomMapSelectScreen());
/*     */   }
/*     */   
/*     */   public void goToMapEditorScreenUserMap(UserMap paramUserMap) {
/* 227 */     a();
/*     */     
/* 229 */     setScreen((Screen)new MapEditorScreen(paramUserMap));
/*     */   }
/*     */   
/*     */   public void goToMapEditorScreenBasicLevel(BasicLevel paramBasicLevel) {
/* 233 */     a();
/*     */     
/* 235 */     if (Game.i.basicLevelManager.mapEditingAvailable()) {
/* 236 */       setScreen((Screen)new MapEditorScreen(paramBasicLevel)); return;
/*     */     } 
/* 238 */     Dialog.i().showAlert("Not available on this OS or you are not in developer mode");
/*     */   }
/*     */ 
/*     */   
/*     */   public void goToAboutScreen() {
/* 243 */     a();
/*     */     
/* 245 */     setScreen((Screen)new AboutScreen());
/*     */   }
/*     */   
/*     */   public void goToSettingsScreen() {
/* 249 */     a();
/*     */     
/* 251 */     setScreen((Screen)new SettingsScreen());
/*     */   }
/*     */   
/*     */   public void goToSettingsScreenAndScroll(float paramFloat) {
/* 255 */     a();
/*     */     
/* 257 */     setScreen((Screen)new SettingsScreen(paramFloat));
/*     */   }
/*     */   
/*     */   public void goToHotkeyEditorScreen() {
/* 261 */     a();
/*     */     
/* 263 */     setScreen((Screen)new HotkeyScreen());
/*     */   }
/*     */   
/*     */   public void goToLoadingScreen(GameSyncLoader paramGameSyncLoader) {
/* 267 */     a();
/*     */     
/* 269 */     setScreen((Screen)new LoadingScreen(paramGameSyncLoader));
/*     */   }
/*     */   
/*     */   public void goToStatisticsScreen() {
/* 273 */     a();
/*     */     
/* 275 */     setScreen((Screen)new StatisticsScreen());
/*     */   }
/*     */   
/*     */   public void goToMainMenu() {
/* 279 */     goToMainMenuJustLaunched(false);
/*     */   }
/*     */   
/*     */   public void goToMainMenuJustLaunched(boolean paramBoolean) {
/* 283 */     Game.i.assertInMainThread();
/*     */     
/* 285 */     a();
/*     */     
/* 287 */     long l = Game.getTimestampMillis();
/* 288 */     a.i("isLocaleSet " + LocaleManager.a() + " " + (SettingsPrefs.i()).locale.localeName, new Object[0]);
/* 289 */     if (!LocaleManager.a()) {
/*     */       
/* 291 */       a();
/* 292 */       setScreen((Screen)new LanguageSelectScreen(paramBoolean));
/*     */     } else {
/* 294 */       setScreen((Screen)new MainMenuScreen(paramBoolean));
/*     */     } 
/* 296 */     a.d("goToMainMenu took " + (Game.getTimestampMillis() - l) + "ms", new Object[0]);
/*     */   }
/*     */   
/*     */   public void goToSimulationScreen() {
/* 300 */     a();
/* 301 */     setScreen((Screen)new SimulationScreen());
/*     */   }
/*     */   
/*     */   public void goToLanguageSelectScreen() {
/* 305 */     a();
/* 306 */     setScreen((Screen)new LanguageSelectScreen());
/*     */   }
/*     */   
/*     */   public void goToResearchesScreen() {
/* 310 */     a();
/*     */     
/* 312 */     setScreen((Screen)new ResearchesScreen());
/*     */   }
/*     */   
/*     */   public void goToResearchesScreenFocusOnResearch(ResearchType paramResearchType) {
/* 316 */     a();
/*     */     
/* 318 */     setScreen((Screen)new ResearchesScreen(paramResearchType));
/*     */   }
/*     */   
/*     */   public void goToLevelSelectScreen() {
/* 322 */     a();
/*     */     
/* 324 */     setScreen((Screen)new LevelSelectScreen());
/*     */   }
/*     */   
/*     */   public void goToLevelSelectScreenShowLevel(BasicLevel paramBasicLevel) {
/* 328 */     a();
/*     */     
/* 330 */     setScreen((Screen)new LevelSelectScreen(paramBasicLevel));
/*     */   }
/*     */   
/*     */   public void startNewLevelWithAbilitySelection(GameStateSystem.GameMode paramGameMode, String paramString) {
/* 334 */     if (paramGameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 335 */       if (Game.i.basicLevelManager.getLevel(paramString).getMap().getTargetTileOrThrow().isDisableAbilities() || !Game.i.abilityManager.isAnyAbilityOpened()) {
/*     */         
/* 337 */         Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel(paramString), null);
/*     */         return;
/*     */       } 
/* 340 */       AbilitySelectionOverlay.i().show(() -> {
/*     */           
/*     */           }paramSelectedAbilitiesConfiguration -> Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel(paramString), paramSelectedAbilitiesConfiguration));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 347 */     if (paramGameMode == GameStateSystem.GameMode.USER_MAPS) {
/* 348 */       if ((Game.i.userMapManager.getUserMap(paramString)).map.getTargetTileOrThrow().isDisableAbilities() || !Game.i.abilityManager.isAnyAbilityOpened()) {
/*     */         
/* 350 */         Game.i.screenManager.startNewUserLevel(Game.i.userMapManager.getUserMap(paramString), null);
/*     */         return;
/*     */       } 
/* 353 */       AbilitySelectionOverlay.i().show(() -> {
/*     */           
/*     */           }paramSelectedAbilitiesConfiguration -> Game.i.screenManager.startNewUserLevel(Game.i.userMapManager.getUserMap(paramString), paramSelectedAbilitiesConfiguration));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dispose() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ScreenManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */