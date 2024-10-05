/*      */ package com.prineside.tdi2.screens;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.CameraController;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueConfig;
/*      */ import com.prineside.tdi2.HeadlessReplayReportGenerator;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.MapPrestigeConfig;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.UserMap;
/*      */ import com.prineside.tdi2.enums.AchievementType;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ModifierType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.game.ForceWaveAvailabilityChange;
/*      */ import com.prineside.tdi2.events.game.Render;
/*      */ import com.prineside.tdi2.managers.DailyQuestManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.systems.StateSystem;
/*      */ import com.prineside.tdi2.systems.WaveSystem;
/*      */ import com.prineside.tdi2.tiles.BossTile;
/*      */ import com.prineside.tdi2.tiles.TargetTile;
/*      */ import com.prineside.tdi2.ui.components.GameOverOverlay;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.LoadingOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.ProfileSummary;
/*      */ import com.prineside.tdi2.utils.GameSyncLoader;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*      */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class GameScreen extends Screen {
/*   63 */   private static final TLog a = TLog.forClass(GameScreen.class);
/*      */   
/*      */   public GameSystemProvider S;
/*      */   
/*      */   public GameSystemProvider validationS;
/*      */   
/*   69 */   public final GameSyncLoader loader = new GameSyncLoader();
/*      */   
/*      */   private boolean b = false;
/*      */   
/*      */   private float c;
/*      */   
/*      */   private boolean d = false;
/*      */   
/*   77 */   private static final StringBuilder e = new StringBuilder();
/*   78 */   private static final StringBuilder f = new StringBuilder();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float[] h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void configureSystemsBeforeSetup(GameSystemProvider paramGameSystemProvider, AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, BasicLevel paramBasicLevel, UserMap paramUserMap, DifficultyMode paramDifficultyMode, int paramInt, GameStateSystem.GameMode paramGameMode, BossType[] paramArrayOfBossType, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState, ProgressManager.InventoryStatistics paramInventoryStatistics, @Null DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) {
/*      */     Map map;
/*  105 */     if (paramProgressSnapshotForState == null) {
/*  106 */       throw new IllegalStateException("progressSnapshot not specified");
/*      */     }
/*      */     
/*  109 */     paramGameSystemProvider.gameState.inUpdateStage = true;
/*      */     
/*  111 */     paramGameSystemProvider.gameState.startingAbilitiesConfiguration = paramSelectedAbilitiesConfiguration;
/*  112 */     paramGameSystemProvider.gameState.canLootCases = paramBoolean1;
/*  113 */     paramGameSystemProvider.gameState.lootBoostEnabled = paramBoolean2;
/*  114 */     paramGameSystemProvider.gameState.rarityBoostEnabled = paramBoolean3;
/*  115 */     paramGameSystemProvider.gameState.gameStartTimestamp = paramLong;
/*  116 */     paramGameSystemProvider.gameState.difficultyMode = paramDifficultyMode;
/*  117 */     paramGameSystemProvider.gameState.gameMode = paramGameMode;
/*  118 */     paramGameSystemProvider.gameState.basicLevelName = (paramBasicLevel == null) ? null : paramBasicLevel.name;
/*  119 */     paramGameSystemProvider.gameState.userMapId = (paramUserMap == null) ? null : paramUserMap.id;
/*  120 */     paramGameSystemProvider.gameState.userMapOriginalSeed = (paramUserMap == null) ? 0 : paramUserMap.map.generateSeed();
/*  121 */     paramGameSystemProvider.gameState.dailyQuestLevel = paramDailyQuestLevel;
/*      */     
/*  123 */     if (Game.i.settingsManager != null) {
/*  124 */       paramGameSystemProvider.wave.instantWaveCallsEnabled = Game.i.settingsManager.isInstantAutoWaveCallEnabled();
/*      */     }
/*      */ 
/*      */     
/*  128 */     if (paramBasicLevel != null) {
/*  129 */       map = paramBasicLevel.getMap().cpy();
/*  130 */     } else if (paramUserMap != null) {
/*  131 */       map = paramUserMap.map.cpy();
/*      */     } else {
/*  133 */       throw new IllegalArgumentException("Both BasicLevel and UserMap not specified");
/*      */     } 
/*      */     
/*  136 */     paramGameSystemProvider.gameState.modeDifficultyMultiplier = ProgressManager.clampModeDifficulty(paramDifficultyMode, paramInt, paramBasicLevel, map
/*      */ 
/*      */ 
/*      */         
/*  140 */         .getTargetTileOrThrow().isUseStockGameValues(), (paramUserMap != null), paramProgressSnapshotForState);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  145 */     if (paramBasicLevel != null) {
/*  146 */       if (paramBasicLevel.enemyWaves != null) {
/*      */         
/*  148 */         paramGameSystemProvider.wave.mode = WaveSystem.Mode.PREDEFINED;
/*  149 */         paramGameSystemProvider.wave.predefinedWaveTemplates = paramBasicLevel.enemyWaves;
/*      */       } 
/*      */       
/*  152 */       paramGameSystemProvider.gameState.setSeed(paramBasicLevel.seed);
/*      */       
/*  154 */       map.multiplyPortalsDifficulty(paramGameSystemProvider.gameState.modeDifficultyMultiplier * 0.01F);
/*  155 */       paramGameSystemProvider.gameState.averageDifficulty = map.getAverageDifficulty();
/*  156 */       paramGameSystemProvider.map.setMap(map);
/*      */       
/*  158 */       paramGameSystemProvider.wave.setDifficultyExpectedPlaytime(paramBasicLevel.getDifficultyExpectedPlaytime());
/*      */       WaveBossSupplier waveBossSupplier;
/*  160 */       if ((waveBossSupplier = map.getBossWaves()) != null) {
/*  161 */         paramGameSystemProvider.wave.setBossWaves(waveBossSupplier.cpy());
/*      */       }
/*      */ 
/*      */       
/*  165 */       if (paramBasicLevel.bonusStagesConfig != null) {
/*  166 */         paramGameSystemProvider.bonus.setStagesConfig(paramBasicLevel.bonusStagesConfig);
/*      */       }
/*      */       
/*  169 */       if (!Config.isHeadless()) {
/*      */         ProgressPrefs progressPrefs;
/*      */         
/*  172 */         (progressPrefs = ProgressPrefs.i()).basicLevel.addLevelGameStartsCount(paramBasicLevel.name, 1);
/*  173 */         progressPrefs.requireSave();
/*      */       } 
/*  175 */       paramGameSystemProvider.statistics.addStatistic(StatisticsType.GS, 1.0D);
/*  176 */     } else if (paramUserMap != null) {
/*  177 */       WaveBossSupplier.Procedural procedural; map.multiplyPortalsDifficulty(paramGameSystemProvider.gameState.modeDifficultyMultiplier * 0.01F);
/*      */       
/*  179 */       paramGameSystemProvider.wave.setDifficultyExpectedPlaytime(map.getDifficultyExpectedPlaytime());
/*      */       
/*      */       WaveBossSupplier waveBossSupplier;
/*  182 */       if ((waveBossSupplier = map.getBossWaves()) == null && paramArrayOfBossType != null) {
/*      */         
/*  184 */         Array array = new Array(true, 1, BossTile.BossTypeWavePair.class);
/*  185 */         paramBoolean2 = false; BossType[] arrayOfBossType; int i; byte b;
/*  186 */         for (i = (arrayOfBossType = paramArrayOfBossType).length, b = 0; b < i; ) { BossType bossType = arrayOfBossType[b];
/*  187 */           array.add(new BossTile.BossTypeWavePair(paramBoolean2, bossType));
/*  188 */           paramBoolean2 += true; b++; }
/*      */         
/*  190 */         procedural = new WaveBossSupplier.Procedural(new BossTile.BossWavesConfig(paramArrayOfBossType.length * 20, 0, 40, array));
/*  191 */         paramGameSystemProvider.gameState.allowedBossesForCustomMaps = paramArrayOfBossType;
/*      */       } 
/*  193 */       if (procedural != null) {
/*  194 */         paramGameSystemProvider.wave.setBossWaves(procedural.cpy());
/*      */       }
/*  196 */       paramGameSystemProvider.map.setMap(map);
/*      */       
/*  198 */       paramGameSystemProvider.gameState.averageDifficulty = map.getAverageDifficulty();
/*  199 */       paramGameSystemProvider.gameState.setSeed(map.generateSeed());
/*      */       
/*  201 */       paramGameSystemProvider.statistics.addStatistic(StatisticsType.GS, 1.0D);
/*  202 */       paramGameSystemProvider.statistics.addStatistic(StatisticsType.GSUM, 1.0D);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  215 */     paramGameSystemProvider.gameState.gameStartProgressSnapshot = paramProgressSnapshotForState;
/*      */     
/*  217 */     if (paramInventoryStatistics == null) {
/*  218 */       a.i("inventoryStatistics not specified, generating with manager", new Object[0]);
/*  219 */       paramInventoryStatistics = Game.i.progressManager.getInventoryStatistics();
/*      */     } 
/*  221 */     paramGameSystemProvider.loot.inventoryStatistics = paramInventoryStatistics;
/*      */     
/*  223 */     if (DifficultyMode.isEndless(paramDifficultyMode) && paramBasicLevel != null && paramBasicLevel.hasLeaderboards) {
/*      */       
/*  225 */       paramGameSystemProvider.map.getMap().getTargetTileOrThrow().getGameValues().add(new GameValueConfig(GameValueType.ENEMIES_WALK_ON_PLATFORMS, 1.0D, true, false));
/*  226 */       paramGameSystemProvider.map.getMap().getTargetTileOrThrow().getGameValues().add(new GameValueConfig(GameValueType.ENEMIES_MAX_PATH_SEARCHES, 2.0D, true, false));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, BasicLevel paramBasicLevel, UserMap paramUserMap, DifficultyMode paramDifficultyMode, int paramInt, GameStateSystem.GameMode paramGameMode, BossType[] paramArrayOfBossType, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState, ProgressManager.InventoryStatistics paramInventoryStatistics, @Null DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) {
/*  254 */     if (paramProgressSnapshotForState == null) {
/*  255 */       a.i("progressSnapshot not specified, generating with manager", new Object[0]);
/*      */       
/*  257 */       Game.i.researchManager.updateAndValidateStarBranch();
/*  258 */       paramProgressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  277 */     this
/*      */       
/*  279 */       .S = new GameSystemProvider(new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, Config.isHeadless()));
/*      */     
/*  281 */     this.S.createSystems();
/*      */ 
/*      */     
/*  284 */     configureSystemsBeforeSetup(this.S, paramSelectedAbilitiesConfiguration, paramBoolean1, paramBoolean2, paramBoolean3, paramLong, paramBasicLevel, paramUserMap, paramDifficultyMode, paramInt, paramGameMode, paramArrayOfBossType, paramProgressSnapshotForState, paramInventoryStatistics, paramDailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  303 */     boolean bool = (paramBasicLevel != null && paramBasicLevel.hasLeaderboards) ? true : false;
/*  304 */     if (!Config.isHeadless() && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION) != 0.0D)
/*      */     {
/*  306 */       if (bool) {
/*      */         
/*  308 */         this.validationS = new GameSystemProvider(new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, true));
/*      */ 
/*      */ 
/*      */         
/*  312 */         this.validationS.createSystems();
/*      */         
/*  314 */         this.S.gameState.duplicateActionsTo = (StateSystem)this.validationS.gameState;
/*      */         
/*  316 */         configureSystemsBeforeSetup(this.validationS, paramSelectedAbilitiesConfiguration, paramBoolean1, paramBoolean2, paramBoolean3, paramLong, paramBasicLevel, paramUserMap, paramDifficultyMode, paramInt, paramGameMode, paramArrayOfBossType, paramProgressSnapshotForState, paramInventoryStatistics, paramDailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  333 */         this.validationS.setupSystems();
/*  334 */         this.validationS.postSetupSystems();
/*      */         
/*  336 */         Notifications.i().add("Synchronization check enabled, thanks for helping us to make Infinitode 2 better!", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, null);
/*      */         
/*  338 */         Timer.schedule(new Timer.Task(this)
/*      */             {
/*      */               public void run() {
/*  341 */                 Notifications.i().add("It affects performance and can be turned off in Settings -> Advanced -> \"Desync check\".", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.LIGHT_BLUE.P800, null);
/*      */               }
/*      */             }3.0F);
/*      */       } 
/*      */     }
/*  346 */     Config.isHeadless();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  380 */     if (!Config.isHeadless()) {
/*  381 */       if (this.S.map.getMap().getMusicTile() != null && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.IGNORE_MAP_MUSIC) == 0.0D)
/*      */       {
/*  383 */         Game.i.musicManager.setVolume(0.0F, 1.0F, true);
/*      */       }
/*      */       
/*  386 */       if (Game.i.uiManager != null) {
/*  387 */         Game.i.uiManager.hideAllComponents();
/*  388 */         LoadingOverlay.i().show();
/*      */       } 
/*      */     } 
/*      */     
/*  392 */     this.S.setupSystems();
/*      */     
/*  394 */     this.loader.addTask(new GameSyncLoader.Task("Initialization", () -> {
/*      */             if (!this.S.gameState.isFastForwarding() && Game.i.uiManager != null) {
/*      */               LoadingOverlay.i().hide();
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             if (this.S._gameUi != null) {
/*      */               if (this.S.gameValue.getBooleanValue(GameValueType.MANUAL_GAME_SPEED)) {
/*      */                 this.S._gameUi.getMainUi().showGameSpeedButton(false, null);
/*      */               } else {
/*      */                 this.S._gameUi.getMainUi().hideGameSpeedButton();
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             this.S.postSetupSystems();
/*      */           }));
/*      */ 
/*      */     
/*  414 */     this.loader.addListener(new GameSyncLoader.SyncExecutionListener(this)
/*      */         {
/*      */           public void startedTask(GameSyncLoader.Task param1Task1, GameSyncLoader.Task param1Task2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void done() {
/*  422 */             if (this.a.S.gameState.basicLevelName != null && (Game.i.basicLevelManager.getLevel(this.a.S.gameState.basicLevelName)).fastForwardFrame > 0) {
/*      */               
/*  424 */               this.a.S.events.getListeners(ForceWaveAvailabilityChange.class).add(param1ForceWaveAvailabilityChange -> {
/*      */                     if (this.a.S.gameState.basicLevelName != null && (Game.i.basicLevelManager.getLevel(this.a.S.gameState.basicLevelName)).fastForwardFrame > this.a.S.gameState.updateNumber && this.a.S.wave.isForceWaveAvailable()) {
/*      */                       this.a.S.wave.forceNextWaveAction();
/*      */                     }
/*      */                   });
/*      */ 
/*      */ 
/*      */               
/*  432 */               this.a.S.wave.startNextWave();
/*  433 */               this.a.S.gameState.startFastForwarding((Game.i.basicLevelManager.getLevel(this.a.S.gameState.basicLevelName)).fastForwardFrame);
/*      */             } 
/*      */           }
/*      */         });
/*      */     
/*  438 */     Game.i.analyticsManager.logLevelStarted(
/*  439 */         (paramBasicLevel != null) ? "basic" : "custom", 
/*  440 */         (paramBasicLevel != null) ? paramBasicLevel.name : "custom");
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GameScreen(BasicLevel paramBasicLevel, DifficultyMode paramDifficultyMode, int paramInt, @Null AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration, long paramLong, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState) {
/*  456 */     this(paramBasicLevel, paramDifficultyMode, paramInt, 
/*      */ 
/*      */ 
/*      */         
/*  460 */         paramBasicLevel.getMap().getTargetTileOrThrow().isDisableAbilities() ? paramBasicLevel.getMap().getMaxedAbilitiesConfiguration() : paramSelectedAbilitiesConfiguration, true, 
/*      */         
/*  462 */         (Game.i.progressManager.getLootBoostTimeLeft() > 0.0F), 
/*  463 */         (Game.i.progressManager.getItemsCount((Item)Item.D.RARITY_BOOST) > 0), paramLong, paramProgressSnapshotForState, null, null);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public GameScreen(DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) {
/*  478 */     this(Game.i.basicLevelManager
/*  479 */         .getLevel(paramDailyQuestLevel.getLevelName()), DifficultyMode.NORMAL, 100, Game.i.basicLevelManager
/*      */ 
/*      */         
/*  482 */         .getLevel(paramDailyQuestLevel.getLevelName()).getMap().getMaxedAbilitiesConfiguration(), false, false, false, -1L, null, null, paramDailyQuestLevel);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDraw(float paramFloat1, float paramFloat2) {
/*  615 */     if (this.S.CFG.headless)
/*      */       return; 
/*  617 */     long l = Game.getRealTickCount();
/*  618 */     if (Float.isNaN(paramFloat2)) {
/*  619 */       paramFloat2 = 0.0F;
/*  620 */     } else if (paramFloat2 < 0.0F) {
/*  621 */       paramFloat2 = 0.0F;
/*      */     } 
/*      */     
/*  624 */     this.S.events.trigger((Event)new Render(paramFloat2, paramFloat1));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  629 */     if (!this.S.CFG.headless && !Config.isHeadless() && !this.S.gameState.isFastForwarding() && !this.S.gameState.isGameOver()) {
/*      */       
/*  631 */       this.g += paramFloat2;
/*      */ 
/*      */       
/*  634 */       if ((paramFloat1 = (float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.STATE_AUTO_SAVE_INTERVAL) * 60.0F) > 0.0F && this.g > paramFloat1) {
/*  635 */         this.S.gameState.saveGame();
/*  636 */         this.g = 0.0F;
/*      */       } 
/*      */     } 
/*      */     
/*  640 */     paramFloat1 = (float)(Game.getRealTickCount() - l) * 0.001F;
/*  641 */     this.h[this.i] = paramFloat1;
/*  642 */     this.i++;
/*  643 */     if (this.i == this.h.length) {
/*  644 */       this.i = 0;
/*      */     }
/*      */     
/*  647 */     if (Game.i.debugManager.isEnabled()) {
/*  648 */       paramFloat2 = 0.0F; float[] arrayOfFloat; int i; byte b;
/*  649 */       for (i = (arrayOfFloat = this.h).length, b = 0; b < i; ) { float f = arrayOfFloat[b];
/*  650 */         paramFloat2 += f; b++; }
/*      */       
/*  652 */       Game.i.debugManager.registerValue("Drawing time").append(StringFormatter.compactNumberWithPrecision(paramFloat1, 2)).append("ms / ")
/*  653 */         .append(StringFormatter.compactNumberWithPrecision((paramFloat2 / this.h.length), 2)).append("ms");
/*      */     } 
/*      */     
/*  656 */     Game.i.renderingManager.stopAnyBatchDrawing();
/*      */   }
/*      */   
/*  659 */   public GameScreen(GameSystemProvider paramGameSystemProvider, long paramLong) { this.h = new float[600]; Game.i.uiManager.hideAllComponents(); this.S = paramGameSystemProvider; paramGameSystemProvider.gameState.gameStartTimestamp = paramLong; paramGameSystemProvider.gameState.setGameSpeed(0.0F); } public GameScreen(BasicLevel paramBasicLevel, DifficultyMode paramDifficultyMode, int paramInt, @Null AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState, ProgressManager.InventoryStatistics paramInventoryStatistics, @Null DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) { this.h = new float[600]; if (paramLong == -1L) paramLong = Game.getTimestampMillis();  if (paramBasicLevel.forcedDifficulty != null) paramDifficultyMode = paramBasicLevel.forcedDifficulty;  a.i("starting level " + paramBasicLevel.name + " " + paramDifficultyMode.name(), new Object[0]); a(paramSelectedAbilitiesConfiguration, paramBoolean1, paramBoolean2, paramBoolean3, paramLong, paramBasicLevel, null, paramDifficultyMode, paramInt, GameStateSystem.GameMode.BASIC_LEVELS, null, paramProgressSnapshotForState, paramInventoryStatistics, paramDailyQuestLevel); } public GameScreen(UserMap paramUserMap, DifficultyMode paramDifficultyMode, int paramInt, AbilitySelectionOverlay.SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration, long paramLong, BossType[] paramArrayOfBossType, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState, ProgressManager.InventoryStatistics paramInventoryStatistics) { this.h = new float[600]; if (paramLong == -1L)
/*      */       paramLong = Game.getTimestampMillis();  Preconditions.checkNotNull(paramUserMap, "UserMap is null");
/*      */     boolean bool1 = (Game.i.progressManager.getItemsCount((Item)Item.D.RARITY_BOOST) > 0) ? true : false;
/*      */     boolean bool2 = (Game.i.progressManager.getLootBoostTimeLeft() > 0.0F) ? true : false;
/*      */     a(paramUserMap.map.getTargetTileOrThrow().isDisableAbilities() ? paramUserMap.map.getMaxedAbilitiesConfiguration() : paramSelectedAbilitiesConfiguration, true, bool2, bool1, paramLong, null, paramUserMap, paramDifficultyMode, paramInt, GameStateSystem.GameMode.USER_MAPS, paramArrayOfBossType, paramProgressSnapshotForState, paramInventoryStatistics, null);
/*      */     this.S.achievement.setProgress(AchievementType.HUNDRED_TILE_CUSTOM_MAP, (paramUserMap.map.getAllTiles()).size);
/*  665 */     this.S.achievement.setProgress(AchievementType.FIVE_HUNDRED_TILE_CUSTOM_MAP, (paramUserMap.map.getAllTiles()).size); } public void show() { if (Game.i.uiManager != null) {
/*  666 */       Game.i.uiManager.stage.setScrollFocus(null);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSystems() {
/*  674 */     this.S.syncChecking = (this.validationS != null);
/*  675 */     this.S.syncCheckLog.clear();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  767 */     this.S.updateSystems();
/*      */     
/*  769 */     if (this.validationS != null) {
/*      */       
/*  771 */       this.validationS.syncChecking = true;
/*  772 */       this.validationS.syncCheckLog.clear();
/*  773 */       this.validationS.updateSystems();
/*      */       
/*  775 */       f.setLength(0);
/*      */       try {
/*  777 */         long l = Game.getRealTickCount();
/*  778 */         this.validationS.compareSync(this.S, f, false);
/*  779 */         Game.i.debugManager.registerFrameJob("SyncCheck", Game.getRealTickCount() - l);
/*      */         
/*  781 */         if (f.length != 0) {
/*      */           
/*  783 */           f.append("\nLog A:\n").append(this.S.syncCheckLog.toString("\n"));
/*  784 */           f.append("\nLog B:\n").append(this.validationS.syncCheckLog.toString("\n"));
/*      */           
/*  786 */           a.e(f.toString(), new Object[0]);
/*      */           
/*  788 */           this.S.gameState.gameSavesDisabled = true;
/*      */ 
/*      */           
/*  791 */           l = (this.S.gameState.headlessValidatedReplayRecord == null) ? Game.getTimestampSeconds() : this.S.gameState.headlessValidatedReplayRecord.id;
/*      */           FileHandle fileHandle;
/*  793 */           (fileHandle = Gdx.files.local("desync-report-" + l + ".txt")).writeString(f.toString(), false, "UTF-8");
/*      */ 
/*      */ 
/*      */           
/*  797 */           this.validationS.dispose();
/*  798 */           this.validationS = null;
/*      */           
/*  800 */           if (!Config.isHeadless()) {
/*  801 */             CrashHandler.report("Sync check - desync\n" + f.toString());
/*  802 */             Notifications.i().add("Desynchronization spotted!", (Drawable)Game.i.assetManager.getDrawable("icon-exclamation-triangle"), MaterialColor.ORANGE.P800, StaticSoundType.WARNING);
/*      */           } 
/*      */         } 
/*  805 */       } catch (Exception exception2) {
/*  806 */         Exception exception1; (exception1 = null).printStackTrace();
/*  807 */         this.validationS = null;
/*      */         
/*  809 */         if (!Config.isHeadless()) {
/*  810 */           CrashHandler.report("Sync check - exception", exception1);
/*  811 */           Notifications.i().add("Synchronization check disabled", (Drawable)Game.i.assetManager.getDrawable("icon-exclamation-triangle"), MaterialColor.ORANGE.P800, StaticSoundType.WARNING);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  816 */     Game.i.debugManager.registerGameStateUpdate();
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  821 */     boolean bool = !this.S.CFG.headless ? true : false;
/*      */     
/*  823 */     if (paramFloat < 0.0F) {
/*  824 */       paramFloat = 0.0F;
/*      */     }
/*      */     
/*  827 */     if (bool) {
/*  828 */       Color color = Game.i.assetManager.getColor("game_background");
/*  829 */       Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/*  830 */       Gdx.gl.glClear(16640);
/*      */     } 
/*      */     
/*  833 */     float f1 = 0.0F;
/*      */     
/*  835 */     if (!this.loader.isDone()) {
/*      */       
/*  837 */       this.loader.iterate();
/*      */       
/*      */       return;
/*      */     } 
/*  841 */     if (bool && Game.i.settingsManager.isEscButtonJustPressed())
/*      */     {
/*  843 */       if (this.S == null || !this.S.gameState.isGameOver())
/*      */       {
/*      */         
/*  846 */         if (this.S != null) this.S.gameState.togglePauseMenu();
/*      */       
/*      */       }
/*      */     }
/*  850 */     float f2 = 0.0F;
/*  851 */     if (paramFloat > 0.2F) {
/*  852 */       paramFloat = 0.2F;
/*      */     }
/*      */     
/*  855 */     if (this.S.gameState.isFastForwarding()) {
/*      */       
/*  857 */       long l = Game.getRealTickCount();
/*  858 */       this.S.gameState.setGameSpeed(1.0F);
/*  859 */       while (this.S.gameState.updateNumber < this.S.gameState.getFastForwardUpdateNumber()) {
/*  860 */         updateSystems();
/*      */         
/*  862 */         if (!bool) {
/*      */           
/*  864 */           if (this.S.gameState.updateNumber % 1800 == 0)
/*      */           {
/*  866 */             HeadlessReplayReportGenerator.interval(this.S);
/*      */           }
/*  868 */           if (this.S.gameState.updateNumber == this.S.gameState.validationLastUpdateNumber) {
/*      */             
/*  870 */             a.i("reached last validation frame", new Object[0]);
/*  871 */             this.S.gameState.triggerGameOver(GameStateSystem.GameOverReason.MANUAL);
/*      */           } 
/*      */           
/*      */           long l1;
/*  875 */           if ((l1 = Game.getTimestampMillis() - this.S.gameState.validationStartTimestamp) > 10800000L) {
/*      */             
/*  877 */             a.i("validation running for too long, aborting", new Object[0]);
/*  878 */             this.S.gameState.triggerGameOver(GameStateSystem.GameOverReason.MANUAL);
/*      */           } 
/*      */         } 
/*      */         
/*  882 */         if (this.S.gameState.isGameOver()) {
/*  883 */           this.S.gameState.stopFastForwarding(); break;
/*      */         } 
/*  885 */         if (Game.getRealTickCount() - l > 33333L) {
/*      */           
/*  887 */           if (bool) {
/*  888 */             if (!this.S.gameState.canSkipMediaUpdate()) {
/*  889 */               updateDraw(33333.0F, 33333.0F);
/*      */             }
/*      */             
/*  892 */             e.setLength(0);
/*  893 */             e.append("Frame ").append(this.S.gameState.updateNumber).append("/").append(this.S.gameState.getFastForwardUpdateNumber());
/*  894 */             LoadingOverlay.i().showWithBar(this.S.gameState.updateNumber / this.S.gameState.getFastForwardUpdateNumber(), (CharSequence)e);
/*      */           } 
/*      */           return;
/*      */         } 
/*      */       } 
/*  899 */       if (this.S.gameState.updateNumber >= this.S.gameState.getFastForwardUpdateNumber())
/*      */       {
/*  901 */         this.S.gameState.stopFastForwarding();
/*  902 */         if (this.S.gameState.basicLevelName != null && (Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName)).fastForwardFrame > 0) {
/*      */           
/*  904 */           this.S.gameState.setGameSpeed(1.0F);
/*      */         } else {
/*  906 */           this.S.gameState.setGameSpeed(0.0F);
/*      */         } 
/*  908 */         if (bool) LoadingOverlay.i().hide();
/*      */         
/*  910 */         a.i("fast forward to update " + this.S.gameState.getFastForwardUpdateNumber() + " done, frame " + this.S.gameState.updateNumber + ", continued game state hash " + ((this.S.gameState.getApproxStateHash() == this.S.gameState.continuedGameApproxStateHash) ? "matches :)" : ("differs :( " + this.S.gameState.getApproxStateHash() + " " + this.S.gameState.continuedGameApproxStateHash)), new Object[0]);
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  917 */       this.S.resetSystemsFrameProfiling();
/*      */       
/*  919 */       if (this.S.gameState.isGameOver()) {
/*      */         
/*  921 */         b();
/*      */       } else {
/*      */         
/*  924 */         byte b = 0;
/*      */         
/*      */         float f3, f4;
/*  927 */         if ((f4 = (f3 = this.S.gameState.getGameSpeed()) * paramFloat) < 0.0F) {
/*  928 */           throw new IllegalStateException("expectedDeltaTime is " + f4 + " game speed " + f3 + " real delta " + paramFloat);
/*      */         }
/*      */         
/*  931 */         this.c += f4;
/*  932 */         if (this.S.gameState.getGameSpeed() != 0.0F) {
/*      */           
/*  934 */           long l = Game.getRealTickCount();
/*  935 */           float f = this.S.gameValue.getTickRateDeltaTime();
/*      */           
/*  937 */           if (this.S.gameState.updateRequired && this.c < f)
/*      */           {
/*  939 */             this.c = f;
/*      */           }
/*      */           
/*  942 */           f2 = f3 * paramFloat;
/*  943 */           while (this.c >= f) {
/*  944 */             updateSystems();
/*  945 */             this.c -= f;
/*  946 */             b++;
/*      */             
/*  948 */             if (this.S.gameState.replayMode && this.S.gameState.updateNumber == this.S.gameState.replayFrameCount)
/*      */             {
/*  950 */               this.S.gameState.triggerGameOver(GameStateSystem.GameOverReason.MANUAL);
/*      */             }
/*      */             
/*  953 */             if (!this.S.gameState.isGameOver())
/*      */             {
/*      */ 
/*      */               
/*  957 */               if (Game.getRealTickCount() - l > 33333L) {
/*      */                 
/*  959 */                 f2 = f * b;
/*      */                 break;
/*      */               } 
/*      */             }
/*      */           } 
/*  964 */           f1 = (float)(Game.getRealTickCount() - l) * 0.001F;
/*      */         
/*      */         }
/*  967 */         else if (this.S.gameState.updateRequired) {
/*      */           
/*  969 */           updateSystems();
/*  970 */           b++;
/*  971 */           f2 = this.S.gameValue.getTickRateDeltaTime();
/*      */         } 
/*      */ 
/*      */         
/*  975 */         if (this.c > 2.0F) {
/*  976 */           this.c = 2.0F;
/*      */         }
/*      */         
/*  979 */         this.S.gameState.updateRequired = false;
/*      */ 
/*      */         
/*  982 */         if (Game.i.debugManager.isEnabled()) {
/*  983 */           Game.i.debugManager.registerValue("Game updates last frame").append(b);
/*      */         }
/*  985 */         if (Game.i.debugManager.isEnabled()) this.S.flushSystemsFrameProfiling();
/*      */       
/*      */       } 
/*      */     } 
/*  989 */     if (this.d) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  994 */     this.S.gameState.realUpdate(paramFloat);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1003 */     if (f2 < 0.0F || f2 > 3600.0F) {
/* 1004 */       f2 = 0.0F;
/*      */     }
/* 1006 */     updateDraw(f2, paramFloat);
/*      */ 
/*      */     
/* 1009 */     if (Game.i.debugManager.isEnabled()) {
/* 1010 */       Game.i.debugManager.registerValue("Game speed").append((int)(this.S.gameState.getGameSpeed() * 100.0F)).append('%');
/* 1011 */       Game.i.debugManager.registerValue("Updates time").append((int)f1).append("ms");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/* 1020 */     if (this.S.CFG.headless && this.S.gameState.headlessValidatedReplayRecord == null)
/*      */       return; 
/* 1022 */     if (this.b)
/* 1023 */       return;  this.b = true;
/*      */     
/* 1025 */     this.S.gameState.inUpdateStage = true;
/*      */ 
/*      */     
/* 1028 */     if (this.S._quest != null) this.S._quest.update(this.S.gameValue.getTickRateDeltaTime());
/*      */     
/* 1030 */     if (this.S.gameState.headlessValidatedReplayRecord != null) {
/*      */       return;
/*      */     }
/*      */     
/* 1034 */     if (!this.S.gameState.replayMode) {
/* 1035 */       GameStateSystem.deleteSavedGame();
/*      */     }
/*      */     
/* 1038 */     if (this.S.wave.status == WaveSystem.Status.NOT_STARTED) {
/*      */       
/* 1040 */       Game.i.screenManager.goToMainMenu();
/*      */     } else {
/* 1042 */       a.i("Game Over ========", new Object[0]);
/* 1043 */       a.i("Reason: " + this.S.gameState.gameOverReason.name(), new Object[0]);
/* 1044 */       a.i("Updates count: " + this.S.gameState.updateNumber, new Object[0]);
/* 1045 */       a.i("Random state: " + this.S.gameState.getRandomState(0) + " " + this.S.gameState.getRandomState(1), new Object[0]);
/*      */       
/* 1047 */       if (this.S.gameState.isPaused() && this.S._gameUi != null) {
/* 1048 */         this.S._gameUi.pauseMenu.setVisible(false);
/*      */       }
/* 1050 */       Dialog.i().hide();
/*      */ 
/*      */       
/*      */       GameSystemProvider gameSystemProvider;
/*      */       
/* 1055 */       (gameSystemProvider = this.S)._render.gameOverGameSpeed = gameSystemProvider.gameState.getNonAnimatedGameSpeed();
/* 1056 */       if (gameSystemProvider._render.gameOverGameSpeed > 4.0F) gameSystemProvider._render.gameOverGameSpeed = 4.0F; 
/* 1057 */       if (gameSystemProvider._render.gameOverGameSpeed < 1.0F) gameSystemProvider._render.gameOverGameSpeed = 1.0F; 
/* 1058 */       gameSystemProvider.gameState.setGameSpeed(0.0F);
/*      */ 
/*      */       
/* 1061 */       gameSystemProvider._input.enableOnlyStage();
/*      */ 
/*      */       
/* 1064 */       Game.i.musicManager.setVolume(0.0F, 1.0F, true);
/*      */ 
/*      */       
/* 1067 */       gameSystemProvider._gameUi.fadeOutUi();
/*      */ 
/*      */       
/* 1070 */       if (gameSystemProvider.gameState.gameOverReason != GameStateSystem.GameOverReason.NO_ENEMIES_LEFT && gameSystemProvider.gameState.gameOverReason != GameStateSystem.GameOverReason.MANUAL) gameSystemProvider.map.getMap().getTargetTileOrThrow().startExplosionEffect();
/*      */       
/* 1072 */       float f1 = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.5F : 0.0F;
/*      */       
/* 1074 */       float f2 = 0.4F * f1;
/* 1075 */       f1 = 1.5F * f1;
/*      */       
/* 1077 */       Timer.schedule(new Timer.Task(this, gameSystemProvider)
/*      */           {
/*      */             public void run()
/*      */             {
/* 1081 */               if (this.a._input == null)
/*      */                 return; 
/* 1083 */               this.a._input.cameraController.animate((CameraController.CameraControllerAnimation)new CameraController.BasicAnimation(
/* 1084 */                     (this.a.map.getMap().getTargetTileOrThrow()).center.x, 
/* 1085 */                     (this.a.map.getMap().getTargetTileOrThrow()).center.y, 1.0D, 
/*      */                     
/* 1087 */                     Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F, (Interpolation)Interpolation.pow2));
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1092 */               String str = "game_over_reason_" + this.a.gameState.gameOverReason.name();
/* 1093 */               str = Game.i.localeManager.i18n.get(str);
/* 1094 */               this.a._gameUi.tooltip.show(str);
/*      */ 
/*      */               
/* 1097 */               Game.i.soundManager.playStatic(StaticSoundType.GAME_OVER);
/*      */             }
/*      */           }f2);
/*      */       
/* 1101 */       Timer.schedule(new Timer.Task(this, gameSystemProvider)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void run()
/*      */             {
/* 1110 */               if (this.a.gameState == null) {
/* 1111 */                 GameScreen.a().w("Stopping gameOver timer task - S.gameState is null", new Object[0]);
/*      */                 
/*      */                 return;
/*      */               } 
/* 1115 */               if (this.a.gameState.replayMode) {
/*      */                 
/* 1117 */                 Array array = new Array(GameOverOverlay.GameOverItemStack.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1123 */                 this.a._gameUi.gameOverOverlay.show(array, null);
/*      */                 
/*      */                 return;
/*      */               } 
/* 1127 */               Array array1 = new Array(this.a.gameState.getQuestsIssuedPrizes());
/* 1128 */               IssuedItems issuedItems = this.a.gameState.getGameLootIssuedItems();
/* 1129 */               array1.add(issuedItems);
/*      */ 
/*      */ 
/*      */               
/* 1133 */               byte b1 = 0;
/*      */               while (true) {
/* 1135 */                 int k = (int)Game.i.statisticsManager.getAllTime(StatisticsType.AFPTG);
/* 1136 */                 int m = 600 + k * (600 + StrictMath.min(k, 20) * 15);
/* 1137 */                 if ((int)Game.i.statisticsManager.getAllTime(StatisticsType.PRT) >= m) {
/* 1138 */                   Game.i.statisticsManager.registerDelta(StatisticsType.AFPTG, 1.0D);
/* 1139 */                   b1++;
/*      */                   continue;
/*      */                 } 
/*      */                 break;
/*      */               } 
/* 1144 */               if (b1 != 0) {
/* 1145 */                 ProgressManager.addItemToStacksArray(issuedItems.items, (Item)Item.D.ACCELERATOR, b1);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1171 */               float f1 = 1.0F;
/* 1172 */               if (this.a.gameState.isDailyQuestAndNotCompleted())
/*      */               {
/* 1174 */                 f1 = 0.1F;
/*      */               }
/*      */ 
/*      */               
/*      */               int i;
/*      */ 
/*      */               
/* 1181 */               if ((i = (int)((i = this.a.gameState.calculatePrizeGreenPapers()) * f1)) > 0) {
/* 1182 */                 ProgressManager.addItemToStacksArray(issuedItems.items, (Item)Item.D.GREEN_PAPER, i);
/*      */               }
/*      */               
/*      */               ResourceType[] arrayOfResourceType;
/*      */               byte b3;
/* 1187 */               for (int j = (arrayOfResourceType = ResourceType.values).length; b3 < j; ) { ResourceType resourceType = arrayOfResourceType[b3];
/*      */ 
/*      */                 
/*      */                 int k;
/*      */ 
/*      */                 
/* 1193 */                 if ((k = (int)((k = this.a.gameState.getResources(resourceType)) * f1)) != 0) {
/* 1194 */                   ProgressManager.addItemToStacksArray(issuedItems.items, (Item)Item.D.F_RESOURCE.create(resourceType), k);
/*      */                 }
/*      */                 
/*      */                 b3++; }
/*      */ 
/*      */               
/* 1200 */               if (this.a.gameState.basicLevelName != null) {
/* 1201 */                 Game.i.basicLevelManager.handleGameOverBonusLoot(this.a, this.a.gameState.basicLevelName, array1);
/*      */               }
/* 1203 */               Game.i.progressManager.handleGameOverShopOffersRotation(this.a);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1210 */               Array array3 = new Array(GameOverOverlay.GameOverItemStack.class);
/*      */               
/* 1212 */               boolean bool = Game.i.progressManager.isDoubleGainEnabled();
/* 1213 */               for (b3 = 0; b3 < array1.size; b3++) {
/* 1214 */                 IssuedItems issuedItems1 = (IssuedItems)array1.get(b3);
/* 1215 */                 for (byte b = 0; b < issuedItems1.items.size; b++) {
/* 1216 */                   ItemStack itemStack = (ItemStack)issuedItems1.items.get(b);
/*      */                   
/*      */                   boolean bool1;
/* 1219 */                   if (bool1 = (bool && itemStack.getItem().isAffectedByDoubleGain())) {
/* 1220 */                     itemStack.setCount(PMath.multiplyWithoutOverflow(itemStack.getCount(), 2));
/*      */                   }
/*      */ 
/*      */                   
/* 1224 */                   boolean bool2 = false;
/* 1225 */                   for (byte b5 = 0; b5 < array3.size; b5++) {
/*      */                     GameOverOverlay.GameOverItemStack gameOverItemStack;
/* 1227 */                     if ((gameOverItemStack = (GameOverOverlay.GameOverItemStack)array3.get(b5)).covered == itemStack.covered && gameOverItemStack.isDoubled == bool1 && gameOverItemStack.getItem().sameAs(itemStack.getItem())) {
/* 1228 */                       ((GameOverOverlay.GameOverItemStack)array3.get(b5)).setCount(PMath.addWithoutOverflow(gameOverItemStack.getCount(), itemStack.getCount()));
/* 1229 */                       bool2 = true;
/*      */                       
/*      */                       break;
/*      */                     } 
/*      */                   } 
/* 1234 */                   if (!bool2) {
/* 1235 */                     GameOverOverlay.GameOverItemStack gameOverItemStack = new GameOverOverlay.GameOverItemStack(itemStack);
/* 1236 */                     if (bool1) {
/* 1237 */                       gameOverItemStack.isDoubled = true;
/*      */                     }
/* 1239 */                     array3.add(gameOverItemStack);
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */ 
/*      */               
/* 1245 */               this.a.statistics.addStatistic(StatisticsType.GPG, Game.i.progressManager.isDoubleGainEnabled() ? (i << 1) : i);
/*      */               
/*      */               float f2;
/*      */               
/* 1249 */               if ((f2 = this.a.gameState.playRealTime) < 0.0F || Float.isNaN(f2) || Float.isInfinite(f2)) {
/* 1250 */                 f2 = 0.0F;
/* 1251 */               } else if (f2 > 86400.0F) {
/* 1252 */                 f2 = 86400.0F;
/*      */               } 
/* 1254 */               this.a.statistics.addStatistic(StatisticsType.PRT, f2);
/*      */ 
/*      */               
/* 1257 */               for (byte b4 = 0; b4 < array1.size; b4++) {
/* 1258 */                 IssuedItems issuedItems1 = (IssuedItems)array1.get(b4);
/* 1259 */                 for (byte b = 0; b < issuedItems1.items.size; b++) {
/* 1260 */                   Game.i.progressManager.addItemStack((ItemStack)issuedItems1.items.get(b), "game");
/*      */                 }
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1285 */               if (this.a.gameState.basicLevelName != null && this.a.gameState.difficultyMode == DifficultyMode.NORMAL)
/*      */               {
/* 1287 */                 Game.i.authManager.localXpPlayedLevels.add(this.a.gameState.basicLevelName);
/*      */               }
/*      */               
/* 1290 */               String str = Game.i.replayManager.saveReplay(this.a);
/* 1291 */               Game.i.replayManager.sendReplayToServer(str, param1ReplaySendStatus -> {
/*      */                     if (param1ReplaySendStatus.regularXpGained > 0 && param1GameSystemProvider._gameUi != null && param1GameSystemProvider._gameUi.gameOverOverlay != null && !param1GameSystemProvider._gameUi.gameOverOverlay.isDisposed()) {
/*      */                       ProfileSummary.i().showXpGained(param1ReplaySendStatus.regularXpGained, param1ReplaySendStatus.bonusXpGained, param1ReplaySendStatus.bonusXpLeft, param1ReplaySendStatus.regularXpLeft);
/*      */                     }
/*      */ 
/*      */ 
/*      */                     
/*      */                     Game.i.replayManager.sendUnsentReplaysToTheServer();
/*      */                   });
/*      */ 
/*      */ 
/*      */               
/* 1303 */               MapPrestigeConfig mapPrestigeConfig = null;
/* 1304 */               if (this.a.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS && Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.PRESTIGE_MODE)) {
/* 1305 */                 boolean bool1 = true; int arrayOfInt[], k; byte b;
/* 1306 */                 for (k = (arrayOfInt = this.a.ability.abilitiesUsed).length, b = 0; b < k; b++) {
/* 1307 */                   int m; if ((m = arrayOfInt[b]) != 0) {
/* 1308 */                     bool1 = false;
/*      */                     break;
/*      */                   } 
/*      */                 } 
/* 1312 */                 TargetTile targetTile = this.a.map.getMap().getTargetTileOrThrow();
/*      */                 
/* 1314 */                 double d = Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.PRESTIGE_DUST_DROP_RATE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1324 */                 mapPrestigeConfig = new MapPrestigeConfig(this.a.gameState.userMapId, this.a.map.getMap().getPrestigeScore() * d, this.a.gameState.averageDifficulty, bool1, targetTile.isUseStockGameValues(), targetTile.isWalkableTiles(), (this.a.modifier.modifiersBuiltByTypeAllTime[ModifierType.BOUNTY.ordinal()] == 0), (this.a.statistics.getStatistic(StatisticsType.MB) == 0.0D), this.a.gameState.getScore());
/*      */               } 
/*      */ 
/*      */               
/*      */               Array array2;
/*      */               
/* 1330 */               if ((array2 = this.a.gameState.getCompletedQuests()).size > 0) {
/*      */                 
/* 1332 */                 if (this.a.gameState.basicLevelName != null) {
/* 1333 */                   for (byte b5 = 0; b5 < array2.size; b5++) {
/* 1334 */                     String str2 = (String)array2.get(b5); byte b6;
/* 1335 */                     for (b6 = 0; b6 < (Game.i.basicLevelManager.getLevel(this.a.gameState.basicLevelName)).quests.size; b6++) {
/*      */                       BasicLevelQuestConfig basicLevelQuestConfig;
/* 1337 */                       if ((basicLevelQuestConfig = ((BasicLevelQuestConfig[])(Game.i.basicLevelManager.getLevel(this.a.gameState.basicLevelName)).quests.items)[b6]).id.equals(str2)) {
/* 1338 */                         basicLevelQuestConfig.setCompleted(true);
/* 1339 */                         GameScreen.a().i("saving quest " + str2, new Object[0]);
/*      */                         break;
/*      */                       } 
/*      */                     } 
/* 1343 */                     for (b6 = 0; b6 < (Game.i.basicLevelManager.getLevel(this.a.gameState.basicLevelName)).waveQuests.size; b6++) {
/*      */                       BasicLevel.WaveQuest waveQuest;
/* 1345 */                       if ((waveQuest = ((BasicLevel.WaveQuest[])(Game.i.basicLevelManager.getLevel(this.a.gameState.basicLevelName)).waveQuests.items)[b6]).id.equals(str2)) {
/* 1346 */                         waveQuest.setCompleted(true);
/* 1347 */                         GameScreen.a().i("saving quest " + str2, new Object[0]);
/*      */                         
/*      */                         break;
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 }
/* 1354 */                 if (this.a.gameState.dailyQuestLevel != null) {
/*      */                   
/* 1356 */                   GameScreen.a().i("saved today's daily quest as completed", new Object[0]);
/* 1357 */                   this.a.gameState.dailyQuestLevel.setCompleted();
/*      */                 } 
/*      */ 
/*      */                 
/* 1361 */                 String str1 = Game.i.dailyQuestManager.getDailyLootCurrentQuest();
/* 1362 */                 for (byte b = 0; b < array2.size; b++) {
/* 1363 */                   if (((String[])array2.items)[b].equals(str1)) {
/*      */                     IssuedItems issuedItems1;
/* 1365 */                     if ((issuedItems1 = Game.i.dailyQuestManager.setDailyLootQuestCompleted()) != null) {
/* 1366 */                       for (byte b5 = 0; b5 < issuedItems1.items.size; b5++) {
/*      */                         GameOverOverlay.GameOverItemStack gameOverItemStack;
/* 1368 */                         (gameOverItemStack = new GameOverOverlay.GameOverItemStack(((ItemStack[])issuedItems1.items.items)[b5])).isDailyLoot = true;
/* 1369 */                         array3.add(gameOverItemStack);
/*      */                       } 
/*      */                     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1387 */               this.a._gameUi.gameOverOverlay.show(array3, mapPrestigeConfig);
/* 1388 */               Game.i.analyticsManager.logLevelFinished(
/* 1389 */                   (this.a.gameState.basicLevelName != null) ? "basic" : "custom", 
/* 1390 */                   (this.a.gameState.basicLevelName != null) ? this.a.gameState.basicLevelName : "custom", (int)this.a.gameState.playRealTime, 
/*      */                   
/* 1392 */                   (int)(this.a.gameState.updateNumber * this.a.gameValue.getTickRateDeltaTime()));
/*      */ 
/*      */               
/* 1395 */               if (this.a.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*      */ 
/*      */                 
/* 1398 */                 ProgressPrefs progressPrefs = ProgressPrefs.i();
/*      */                 int k;
/* 1400 */                 if ((k = this.a.wave.getCompletedWavesCount()) > progressPrefs.basicLevel.getLevelMaxReachedWave(this.a.gameState.basicLevelName)) {
/*      */                   
/* 1402 */                   progressPrefs.basicLevel.setLevelMaxReachedWave(this.a.gameState.basicLevelName, k);
/* 1403 */                   progressPrefs.requireSave();
/*      */                 } 
/*      */                 
/* 1406 */                 if (this.a.gameState.getScore() > progressPrefs.basicLevel.getLevelMaxScore(this.a.gameState.basicLevelName)) {
/*      */                   
/* 1408 */                   progressPrefs.basicLevel.setLevelMaxScore(this.a.gameState.basicLevelName, this.a.gameState.getScore());
/* 1409 */                   progressPrefs.requireSave();
/*      */                 } 
/*      */                 
/*      */                 int m;
/* 1413 */                 if ((m = (int)this.a.statistics.getCurrentGameStatistic(StatisticsType.PRT)) > progressPrefs.basicLevel.getLevelMaxPlayingTime(this.a.gameState.basicLevelName)) {
/*      */                   
/* 1415 */                   progressPrefs.basicLevel.setLevelMaxPlayingTime(this.a.gameState.basicLevelName, m);
/* 1416 */                   progressPrefs.requireSave();
/*      */                 } 
/*      */ 
/*      */                 
/* 1420 */                 this.a._quest.saveBasicLevelQuestValues();
/*      */               } 
/*      */ 
/*      */               
/* 1424 */               this.a.statistics.flushStatistics();
/*      */ 
/*      */               
/* 1427 */               Game.i.researchManager.checkResearchesStatus(true);
/*      */ 
/*      */               
/* 1430 */               for (byte b2 = 0; b2 < array1.size; b2++) {
/*      */                 
/* 1432 */                 Array array4 = new Array();
/* 1433 */                 Array array5 = ((IssuedItems)array1.get(b2)).items;
/* 1434 */                 for (byte b = 0; b < array5.size; b++) {
/* 1435 */                   ItemStack itemStack = (ItemStack)array5.get(b);
/*      */                   
/* 1437 */                   boolean bool1 = false;
/* 1438 */                   for (i = 0; i < array4.size; i++) {
/* 1439 */                     if (((ItemStack)array4.get(i)).getItem().sameAs(itemStack.getItem())) {
/* 1440 */                       ((ItemStack)array4.get(i)).setCount(PMath.addWithoutOverflow(((ItemStack)array4.get(i)).getCount(), itemStack.getCount()));
/* 1441 */                       bool1 = true;
/*      */                       
/*      */                       break;
/*      */                     } 
/*      */                   } 
/* 1446 */                   if (!bool1) {
/* 1447 */                     array4.add(new ItemStack(itemStack));
/*      */                   }
/*      */                 } 
/*      */ 
/*      */                 
/* 1452 */                 ((IssuedItems)array1.get(b2)).items.clear();
/* 1453 */                 ((IssuedItems)array1.get(b2)).items.addAll(array4);
/*      */                 
/* 1455 */                 Game.i.progressManager.addIssuedPrizes((IssuedItems)array1.get(b2), true);
/*      */               } 
/*      */ 
/*      */               
/* 1459 */               if (this.a.gameState.dailyQuestLevel == null && !this.a.map.getMap().getTargetTileOrThrow().isDisableAbilities()) {
/*      */                 
/* 1461 */                 AbilitySelectionOverlay.SelectedAbilitiesConfiguration selectedAbilitiesConfiguration = this.a.ability.abilitiesConfiguration;
/* 1462 */                 for (byte b = 0; b < selectedAbilitiesConfiguration.slots.length; b++) {
/* 1463 */                   int k; if (selectedAbilitiesConfiguration.slots[b] != null && (
/*      */ 
/*      */                     
/* 1466 */                     k = -this.a.ability.abilitiesUsed[b]) < 0)
/*      */                   {
/* 1468 */                     if (!Game.i.progressManager.removeAbilities(selectedAbilitiesConfiguration.slots[b], -k)) {
/* 1469 */                       GameScreen.a().e("removeAbilities false " + -k, new Object[0]);
/*      */                     }
/*      */                   }
/*      */                 } 
/*      */ 
/*      */                 
/* 1475 */                 if (this.a.gameState.rarityBoostEnabled) {
/*      */                   
/* 1477 */                   Game.i.analyticsManager.logCurrencySpent("used", "rarity_boost", 1);
/* 1478 */                   Game.i.progressManager.removeItems((Item)Item.D.RARITY_BOOST, 1);
/*      */                 } 
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1492 */               Game.i.achievementManager.updateGlobal();
/*      */               
/* 1494 */               Game.i.preferencesManager.saveNowIfRequired();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1500 */               Game.i.authManager.handleAutoSave();
/*      */             }
/*      */           }f1);
/*      */     } 
/*      */ 
/*      */     
/* 1506 */     Game.i.researchManager.checkResearchesStatus(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1511 */     super.dispose();
/*      */     
/* 1513 */     if (this.S != null) {
/* 1514 */       this.S.dispose();
/* 1515 */       this.S = null;
/*      */     } 
/* 1517 */     if (this.validationS != null) {
/* 1518 */       this.validationS.dispose();
/* 1519 */       this.validationS = null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1527 */     this.d = true;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\GameScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */