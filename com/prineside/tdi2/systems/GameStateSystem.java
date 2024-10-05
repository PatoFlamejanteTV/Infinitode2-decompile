/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.LifecycleListener;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.DamageRecord;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.SerializableListener;
/*      */ import com.prineside.tdi2.SpaceTileBonus;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.UserMap;
/*      */ import com.prineside.tdi2.enums.AchievementType;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.BaseHealthChange;
/*      */ import com.prineside.tdi2.events.game.CoinsChange;
/*      */ import com.prineside.tdi2.events.game.EnemyDie;
/*      */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*      */ import com.prineside.tdi2.events.game.GameOver;
/*      */ import com.prineside.tdi2.events.game.GamePaused;
/*      */ import com.prineside.tdi2.events.game.GameResumed;
/*      */ import com.prineside.tdi2.events.game.GameSpeedChange;
/*      */ import com.prineside.tdi2.events.game.GameStateTick;
/*      */ import com.prineside.tdi2.events.game.IssuedItemsAdd;
/*      */ import com.prineside.tdi2.events.game.MinedResourcesChange;
/*      */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*      */ import com.prineside.tdi2.events.game.NextWaveForce;
/*      */ import com.prineside.tdi2.events.game.ScoreChange;
/*      */ import com.prineside.tdi2.managers.DailyQuestManager;
/*      */ import com.prineside.tdi2.managers.NetworkManager;
/*      */ import com.prineside.tdi2.managers.PreferencesManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.screens.GameScreen;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ @REGS
/*      */ public final class GameStateSystem
/*      */   extends StateSystem
/*      */ {
/*   80 */   private static final TLog c = TLog.forClass(GameStateSystem.class);
/*      */   
/*      */   public static final float NOT_COMPLETED_DAILY_QUEST_PRIZE_MULTIPLIER = 0.1F;
/*      */   
/*      */   public static final float SLOW_MOTION_GAME_SPEED = 0.0667F;
/*      */   
/*      */   public DifficultyMode difficultyMode;
/*      */   
/*      */   public GameMode gameMode;
/*      */   public int modeDifficultyMultiplier;
/*      */   @NAGS
/*      */   public String replayId;
/*      */   public String basicLevelName;
/*      */   public String userMapId;
/*      */   public int userMapOriginalSeed;
/*      */   
/*      */   public enum ContinueGameStatus
/*      */   {
/*   98 */     MAP_NOT_FOUND,
/*   99 */     MAP_CHANGED,
/*  100 */     GAME_VALUES_CHANGED,
/*  101 */     GAME_FROM_PREVIOUS_BUILD,
/*  102 */     OTHER_ERROR,
/*      */     
/*  104 */     SUCCESS;
/*      */     
/*  106 */     public static final ContinueGameStatus[] values = values();
/*      */     static {
/*      */     
/*      */     } }
/*      */   @REGS
/*  111 */   public enum GameOverReason { MANUAL,
/*  112 */     ZERO_BASE_HEALTH,
/*  113 */     NO_ENEMIES_LEFT,
/*  114 */     QUEST_FAILED; }
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public enum GameMode {
/*  119 */     BASIC_LEVELS,
/*  120 */     USER_MAPS;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  126 */     public static GameMode[] values = values();
/*      */ 
/*      */     
/*      */     public static boolean isBasicLevel(GameMode param1GameMode) {
/*      */       return (param1GameMode == BASIC_LEVELS);
/*      */     }
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */   }
/*  138 */   public BossType[] allowedBossesForCustomMaps = null; @NAGS
/*      */   public DailyQuestManager.DailyQuestLevel dailyQuestLevel; @NAGS
/*      */   public AbilitySelectionOverlay.SelectedAbilitiesConfiguration startingAbilitiesConfiguration;
/*  141 */   private long d = -1L;
/*      */   @NAGS
/*  143 */   public long gameStartTimestamp = -1L; @NAGS
/*      */   public int continuedGameApproxStateHash; @NAGS
/*      */   public boolean gameIsContinued;
/*      */   @NAGS
/*      */   public boolean snapshotSavesEnabled = true;
/*      */   public boolean canLootCases;
/*      */   public boolean lootBoostEnabled;
/*      */   public boolean rarityBoostEnabled;
/*      */   @NAGS
/*      */   public boolean gameSavesDisabled;
/*  153 */   private long e = 0L;
/*  154 */   private int f = 0;
/*  155 */   private int g = 0;
/*      */   public long scoreWithEndlessTimeLimit;
/*  157 */   private int[] h = new int[ResourceType.values.length]; private IssuedItems i;
/*      */   @NAGS
/*  159 */   private Array<String> j = new Array(String.class); @NAGS
/*  160 */   private Array<IssuedItems> k = new Array(IssuedItems.class); public RandomXS128 random; public int averageDifficulty;
/*      */   @NAGS
/*      */   private boolean l = false;
/*      */   @NAGS
/*  164 */   private float m = 1.0F; @NAGS
/*      */   public float playRealTime; @NAGS
/*  166 */   private float n = 1.0F; @NAGS
/*      */   private long o;
/*      */   public EnemyType lastEnemyReachedTarget;
/*      */   private boolean p = false;
/*      */   @NAGS
/*      */   public GameOverReason gameOverReason;
/*      */   @NAGS
/*      */   public ProgressManager.ProgressSnapshotForState gameStartProgressSnapshot;
/*  174 */   private int q = 0;
/*  175 */   public int pxpExperience = 0;
/*  176 */   private int r = -13501;
/*  177 */   private int s = 0;
/*      */ 
/*      */   
/*      */   private float t;
/*      */   
/*      */   private float u;
/*      */   
/*      */   private float v;
/*      */   
/*      */   @NAGS
/*  187 */   private final Output w = new Output(1024, -1); @NAGS
/*  188 */   private final Output x = new Output(1024, -1); @NAGS
/*      */   private byte[] y; @NAGS
/*      */   private int z; @NAGS
/*  191 */   private Output A = new Output(1024, -1); @NAGS
/*      */   private byte[] B; @NAGS
/*      */   private int C; @NAGS
/*  194 */   private final Object D = new Object();
/*      */   
/*  196 */   private static final Input E = new Input();
/*      */   @NAGS
/*  198 */   public long validationStartTimestamp = -1L; @NAGS
/*      */   public ReplayManager.ReplayRecord headlessValidatedReplayRecord; @NAGS
/*      */   public int validationLastUpdateNumber; @NAGS
/*      */   public boolean validationFingerprintMismatchPrinted; @NAGS
/*      */   private boolean F = false; @NAGS
/*      */   private float G; @NAGS
/*      */   private float H;
/*      */   @NAGS
/*      */   private float I;
/*      */   @NAGS
/*  208 */   private final RandomXS128 J = new RandomXS128();
/*      */   
/*      */   @NAGS
/*      */   private _LifecycleListener K;
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  215 */     super.write(paramKryo, paramOutput);
/*  216 */     paramKryo.writeObject(paramOutput, this.difficultyMode);
/*  217 */     paramKryo.writeObject(paramOutput, this.gameMode);
/*  218 */     paramOutput.writeVarInt(this.modeDifficultyMultiplier, true);
/*  219 */     paramOutput.writeString(this.replayId);
/*  220 */     paramKryo.writeObjectOrNull(paramOutput, this.basicLevelName, String.class);
/*  221 */     paramKryo.writeObjectOrNull(paramOutput, this.userMapId, String.class);
/*  222 */     paramOutput.writeInt(this.userMapOriginalSeed);
/*  223 */     paramKryo.writeObjectOrNull(paramOutput, this.allowedBossesForCustomMaps, BossType[].class);
/*  224 */     paramKryo.writeObjectOrNull(paramOutput, this.dailyQuestLevel, DailyQuestManager.DailyQuestLevel.class);
/*  225 */     paramKryo.writeObjectOrNull(paramOutput, this.startingAbilitiesConfiguration, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  226 */     paramOutput.writeLong(this.d);
/*  227 */     paramOutput.writeBoolean(this.canLootCases);
/*  228 */     paramOutput.writeBoolean(this.lootBoostEnabled);
/*  229 */     paramOutput.writeBoolean(this.rarityBoostEnabled);
/*  230 */     paramOutput.writeVarLong(this.e, true);
/*  231 */     paramOutput.writeVarInt(this.f, true);
/*  232 */     paramOutput.writeVarInt(this.g, true);
/*  233 */     paramOutput.writeVarLong(this.scoreWithEndlessTimeLimit, true);
/*  234 */     paramKryo.writeObject(paramOutput, this.h);
/*  235 */     paramKryo.writeObject(paramOutput, this.j);
/*  236 */     paramKryo.writeObjectOrNull(paramOutput, this.i, IssuedItems.class);
/*  237 */     paramKryo.writeObjectOrNull(paramOutput, this.random, RandomXS128.class);
/*  238 */     paramOutput.writeVarInt(this.averageDifficulty, true);
/*  239 */     paramOutput.writeFloat(this.playRealTime);
/*  240 */     paramKryo.writeObjectOrNull(paramOutput, this.lastEnemyReachedTarget, EnemyType.class);
/*  241 */     paramOutput.writeBoolean(this.p);
/*  242 */     paramKryo.writeObjectOrNull(paramOutput, this.gameOverReason, GameOverReason.class);
/*  243 */     paramKryo.writeObjectOrNull(paramOutput, this.gameStartProgressSnapshot, ProgressManager.ProgressSnapshotForState.class);
/*  244 */     paramOutput.writeVarInt(this.q, true);
/*  245 */     paramOutput.writeVarInt(this.pxpExperience, true);
/*  246 */     paramOutput.writeVarInt(this.r, true);
/*  247 */     paramOutput.writeVarInt(this.s, true);
/*  248 */     paramOutput.writeFloat(this.t);
/*  249 */     paramOutput.writeFloat(this.u);
/*  250 */     paramOutput.writeFloat(this.v);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  255 */     super.read(paramKryo, paramInput);
/*  256 */     this.difficultyMode = (DifficultyMode)paramKryo.readObject(paramInput, DifficultyMode.class);
/*  257 */     this.gameMode = (GameMode)paramKryo.readObject(paramInput, GameMode.class);
/*  258 */     this.modeDifficultyMultiplier = paramInput.readVarInt(true);
/*  259 */     this.replayId = paramInput.readString();
/*  260 */     this.basicLevelName = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  261 */     this.userMapId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  262 */     this.userMapOriginalSeed = paramInput.readInt();
/*  263 */     this.allowedBossesForCustomMaps = (BossType[])paramKryo.readObjectOrNull(paramInput, BossType[].class);
/*  264 */     this.dailyQuestLevel = (DailyQuestManager.DailyQuestLevel)paramKryo.readObjectOrNull(paramInput, DailyQuestManager.DailyQuestLevel.class);
/*  265 */     this.startingAbilitiesConfiguration = (AbilitySelectionOverlay.SelectedAbilitiesConfiguration)paramKryo.readObjectOrNull(paramInput, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  266 */     this.d = paramInput.readLong();
/*  267 */     this.canLootCases = paramInput.readBoolean();
/*  268 */     this.lootBoostEnabled = paramInput.readBoolean();
/*  269 */     this.rarityBoostEnabled = paramInput.readBoolean();
/*  270 */     this.e = paramInput.readVarLong(true);
/*  271 */     this.f = paramInput.readVarInt(true);
/*  272 */     this.g = paramInput.readVarInt(true);
/*  273 */     this.scoreWithEndlessTimeLimit = paramInput.readVarLong(true);
/*  274 */     this.h = (int[])paramKryo.readObject(paramInput, int[].class);
/*  275 */     this.j = (Array<String>)paramKryo.readObject(paramInput, Array.class);
/*  276 */     this.i = (IssuedItems)paramKryo.readObjectOrNull(paramInput, IssuedItems.class);
/*  277 */     this.random = (RandomXS128)paramKryo.readObjectOrNull(paramInput, RandomXS128.class);
/*  278 */     this.averageDifficulty = paramInput.readVarInt(true);
/*  279 */     this.playRealTime = paramInput.readFloat();
/*  280 */     this.lastEnemyReachedTarget = (EnemyType)paramKryo.readObjectOrNull(paramInput, EnemyType.class);
/*  281 */     this.p = paramInput.readBoolean();
/*  282 */     this.gameOverReason = (GameOverReason)paramKryo.readObjectOrNull(paramInput, GameOverReason.class);
/*  283 */     this.gameStartProgressSnapshot = (ProgressManager.ProgressSnapshotForState)paramKryo.readObjectOrNull(paramInput, ProgressManager.ProgressSnapshotForState.class);
/*  284 */     this.q = paramInput.readVarInt(true);
/*  285 */     this.pxpExperience = paramInput.readVarInt(true);
/*  286 */     this.r = paramInput.readVarInt(true);
/*  287 */     this.s = paramInput.readVarInt(true);
/*  288 */     this.t = paramInput.readFloat();
/*  289 */     this.u = paramInput.readFloat();
/*  290 */     this.v = paramInput.readFloat();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setup() {
/*  295 */     this.replayId = "R-" + FastRandom.generateUniqueDistinguishableId();
/*      */     
/*  297 */     if (this.gameStartTimestamp == -1L) {
/*  298 */       throw new IllegalStateException("Game start timestamp not set");
/*      */     }
/*      */     
/*  301 */     for (byte b = 0; b < ResourceType.values.length; b++) {
/*  302 */       this.h[b] = 0;
/*      */     }
/*      */ 
/*      */     
/*  306 */     if (this.gameStartProgressSnapshot == null) {
/*  307 */       this.gameStartProgressSnapshot = Game.i.progressManager.createProgressSnapshotForState();
/*      */     }
/*      */     
/*  310 */     this.S.events.getListeners(NextWaveForce.class).addStateAffecting(new OnNextWaveForce(this, (byte)0)).setDescription("GameStateSystem - increases double speed bonus");
/*  311 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this)).setDescription("GameStateSystem - removes base HP, gives kill bounty and triggers game over");
/*  312 */     this.S.events.getListeners(EnemyReachTarget.class).addStateAffectingWithPriority(new OnEnemyReachTarget(this.S), -2000).setDescription("GameStateSystem - removes base HP and triggers game over");
/*  313 */     this.S.events.getListeners(MinerResourceChange.class).addStateAffecting(new OnMinerResourceChange(this.S, (byte)0)).setDescription("GameStateSystem - adds a score for a mined resource");
/*      */     
/*  315 */     if (GameMode.isBasicLevel(this.gameMode)) {
/*  316 */       this.i = new IssuedItems(IssuedItems.IssueReason.GAME_OVER_BASIC_LEVEL, Game.getTimestampSeconds());
/*  317 */       this.i.gameOverBasicLevel = this.basicLevelName;
/*  318 */       this.i.basicLevelGameMode = this.gameMode; return;
/*  319 */     }  if (this.gameMode == GameMode.USER_MAPS) {
/*  320 */       this.i = new IssuedItems(IssuedItems.IssueReason.GAME_OVER_USER_MAP, Game.getTimestampSeconds());
/*  321 */       this.i.userMapId = this.userMapId;
/*  322 */       this.i.userMapHash = (Game.i.userMapManager.getUserMap(this.userMapId)).map.generateSeed(); return;
/*      */     } 
/*  324 */     throw new IllegalStateException("Game mode " + this.gameMode.name() + " not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void postSetup() {
/*  331 */     this.m = 1.0F;
/*      */     
/*  333 */     addMoney(this.S.gameValue.getIntValue(GameValueType.STARTING_MONEY), false);
/*  334 */     addHealth(this.S.gameValue.getIntValue(GameValueType.STARTING_HEALTH));
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
/*      */   public final float getDoubleSpeedTimeLeft() {
/*  434 */     return this.v;
/*      */   }
/*      */   
/*      */   public final boolean isDoubleSpeedActive() {
/*  438 */     return (getDoubleSpeedTimeLeft() > 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setSeed(long paramLong) {
/*  444 */     this.d = paramLong;
/*  445 */     this.random = new RandomXS128(paramLong);
/*      */   }
/*      */   
/*      */   public final boolean isDailyQuestAndNotCompleted() {
/*  449 */     if (this.dailyQuestLevel == null) {
/*  450 */       return false;
/*      */     }
/*  452 */     return (this.j.size == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public final IssuedItems getGameLootIssuedItems() {
/*  457 */     return this.i;
/*      */   }
/*      */   
/*      */   public final long getSeed() {
/*  461 */     return this.d;
/*      */   }
/*      */   
/*      */   public final int randomInt(int paramInt) {
/*  465 */     checkGameplayUpdateAllowed();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  470 */     return this.random.nextInt(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int randomIntIndependent(int paramInt, long paramLong) {
/*  477 */     this.J.setSeed(paramLong);
/*  478 */     return this.J.nextInt(paramInt);
/*      */   }
/*      */   
/*      */   public final float randomFloat() {
/*  482 */     checkGameplayUpdateAllowed();
/*      */     
/*  484 */     return this.random.nextFloat();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float randomTriangular() {
/*  491 */     checkGameplayUpdateAllowed();
/*      */     
/*  493 */     return this.random.nextFloat() - this.random.nextFloat();
/*      */   }
/*      */   
/*      */   public final long getRandomState(int paramInt) {
/*  497 */     return this.random.getState(paramInt);
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
/*      */   public final int calculatePrizeGreenPapers() {
/*  530 */     if (this.S.wave.wave == null) return 0;
/*      */     
/*  532 */     long l1 = getScore();
/*      */ 
/*      */     
/*  535 */     byte b = 1;
/*      */     while (true) {
/*  537 */       long l = 50000L * b;
/*      */       
/*  539 */       if (l1 > l) {
/*  540 */         l1 = l + (long)((l1 - l) * (1.0D - 0.025D * b));
/*      */ 
/*      */ 
/*      */         
/*  544 */         b++;
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  549 */     float f1 = (f1 = this.S.loot.getActiveSecondsPlayed()) + (float)(this.S.statistics.getCurrentGameStatistic(StatisticsType.WCST) * this.S.wave.getCompletedWavesCount() / this.S.wave.wave.waveNumber);
/*  550 */     float f2 = 1.0F + f1 / 60.0F * 0.03F;
/*  551 */     long l2 = (long)((float)l1 * 0.02F * this.averageDifficulty * 0.01F * 0.5F);
/*  552 */     int i = (int)(f1 * f2 * 0.15F * 3.0F);
/*      */     
/*  554 */     if (this.gameMode == GameMode.USER_MAPS) {
/*      */       
/*  556 */       l2 = (long)((float)l2 * 0.6F);
/*  557 */       i = (int)(i * 1.2F);
/*      */     } else {
/*      */       
/*  560 */       l2 = (long)((float)l2 * 1.4F);
/*      */     } 
/*      */     
/*  563 */     if (l2 > 2147483647L) {
/*  564 */       l2 = 2147483647L;
/*      */     }
/*  566 */     long l3 = l2 + i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  576 */     return ((l3 = (long)((l3 = (long)(ProgressManager.getDifficultyModePrizeMultiplier(this.difficultyMode) * (float)l3 * 0.85F)) * (this.S.gameValue.getPercentValueAsMultiplier(GameValueType.GREEN_PAPERS_BONUS) + 1.0D))) > 2147483647L) ? Integer.MAX_VALUE : (int)l3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void restartGame(boolean paramBoolean) {
/*  584 */     if (this.dailyQuestLevel != null) {
/*  585 */       Game.i.dailyQuestManager.startDailyLevel();
/*      */       
/*      */       return;
/*      */     } 
/*  589 */     if (paramBoolean) {
/*      */       
/*  591 */       GameScreen gameScreen = null;
/*      */       
/*  593 */       if (this.gameMode == GameMode.BASIC_LEVELS) {
/*      */         
/*  595 */         gameScreen = new GameScreen(Game.i.basicLevelManager.getLevel(this.basicLevelName), this.S.gameState.difficultyMode, this.S.gameState.modeDifficultyMultiplier, this.startingAbilitiesConfiguration, this.S.gameState.canLootCases, this.S.gameState.lootBoostEnabled, this.S.gameState.rarityBoostEnabled, this.gameStartTimestamp, null, this.S.loot.inventoryStatistics, this.dailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  607 */       else if (this.gameMode == GameMode.USER_MAPS) {
/*      */         
/*  609 */         gameScreen = new GameScreen(Game.i.userMapManager.getUserMap(this.userMapId), this.S.gameState.difficultyMode, this.S.gameState.modeDifficultyMultiplier, this.startingAbilitiesConfiguration, this.gameStartTimestamp, this.allowedBossesForCustomMaps, null, this.S.loot.inventoryStatistics);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  620 */       if (gameScreen != null) {
/*  621 */         deleteSavedGame();
/*  622 */         Game.i.screenManager.setScreen((Screen)gameScreen);
/*      */       } else {
/*  624 */         throw new RuntimeException("Not implemented for " + this.gameMode.name());
/*      */       } 
/*      */     } else {
/*      */       
/*  628 */       if (this.gameMode == GameMode.BASIC_LEVELS) {
/*  629 */         if (Game.i.basicLevelManager.getLevel(this.basicLevelName).getMap().getTargetTileOrThrow().isDisableAbilities() || !Game.i.abilityManager.isAnyAbilityOpened()) {
/*      */           
/*  631 */           Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel(this.basicLevelName), null);
/*      */           return;
/*      */         } 
/*  634 */         AbilitySelectionOverlay.i().show(() -> {
/*      */             
/*      */             }paramSelectedAbilitiesConfiguration -> Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel(this.basicLevelName), paramSelectedAbilitiesConfiguration));
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  641 */       if (this.gameMode == GameMode.USER_MAPS) {
/*  642 */         if ((Game.i.userMapManager.getUserMap(this.userMapId)).map.getTargetTileOrThrow().isDisableAbilities() || !Game.i.abilityManager.isAnyAbilityOpened()) {
/*      */           
/*  644 */           Game.i.screenManager.startNewUserLevel(Game.i.userMapManager.getUserMap(this.userMapId), null);
/*      */           return;
/*      */         } 
/*  647 */         AbilitySelectionOverlay.i().show(() -> {
/*      */             
/*      */             }paramSelectedAbilitiesConfiguration -> Game.i.screenManager.startNewUserLevel(Game.i.userMapManager.getUserMap(this.userMapId), paramSelectedAbilitiesConfiguration));
/*      */       } 
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
/*      */   public final int getApproxStateHash() {
/*  668 */     int i = (i = (i = (i = (i = 31 + (int)this.random.getState(0)) * 31 + (int)this.random.getState(1)) * 31 + this.g) * 31 + (int)this.e) * 31 + this.f;
/*  669 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*      */       Enemy enemy;
/*  671 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  679 */         i = (i = (i = (i = (i = (i = (i = i * 31 + enemy.type.ordinal()) * 31 + enemy.id) * 31 + enemy.sideShiftIndex) * 31 + (int)(enemy.angle * 1000.0F)) * 31 + (int)(enemy.passedTiles * 1000.0F)) * 31 + (int)((enemy.getPosition()).x * 1000.0F)) * 31 + (int)((enemy.getPosition()).y * 1000.0F);
/*      */       }
/*      */     } 
/*  682 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setSnapshotSavesEnabled(boolean paramBoolean) {
/*  691 */     this.snapshotSavesEnabled = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/*  698 */     Output output = this.w;
/*  699 */     NetworkManager.KryoForState kryoForState = Game.i.networkManager.getFullKryo();
/*  700 */     if (this.y == null) {
/*      */       
/*  702 */       output.reset();
/*      */       
/*  704 */       kryoForState.writeObject(output, this.difficultyMode);
/*  705 */       output.writeLong(this.d);
/*  706 */       output.writeVarInt(this.modeDifficultyMultiplier, true);
/*  707 */       kryoForState.writeObject(output, this.gameMode);
/*  708 */       kryoForState.writeObjectOrNull(output, this.startingAbilitiesConfiguration, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  709 */       output.writeBoolean(this.canLootCases);
/*  710 */       output.writeBoolean(this.lootBoostEnabled);
/*  711 */       output.writeBoolean(this.rarityBoostEnabled);
/*      */       
/*  713 */       if (GameMode.isBasicLevel(this.gameMode)) {
/*  714 */         output.writeString(this.basicLevelName);
/*  715 */       } else if (this.gameMode == GameMode.USER_MAPS) {
/*  716 */         output.writeString(this.userMapId);
/*  717 */         output.writeInt(this.userMapOriginalSeed);
/*  718 */         kryoForState.writeObjectOrNull(output, this.S.gameState.allowedBossesForCustomMaps, BossType[].class);
/*      */       } 
/*  720 */       output.writeLong(this.gameStartTimestamp);
/*      */ 
/*      */       
/*  723 */       kryoForState.writeObject(output, this.gameStartProgressSnapshot);
/*  724 */       kryoForState.writeObject(output, this.S.loot.inventoryStatistics);
/*  725 */       kryoForState.writeObjectOrNull(output, this.S.gameState.dailyQuestLevel, DailyQuestManager.DailyQuestLevel.class);
/*      */       
/*  727 */       this.y = output.toBytes();
/*      */     } 
/*      */ 
/*      */     
/*  731 */     output.reset();
/*  732 */     output.writeVarInt(207, true);
/*      */ 
/*      */     
/*  735 */     output.writeBytes(this.y);
/*  736 */     output.writeFloat(this.playRealTime);
/*  737 */     output.writeVarInt(this.updateNumber, true);
/*  738 */     output.writeInt(getApproxStateHash());
/*  739 */     output.writeVarInt(this.b.size, true);
/*      */ 
/*      */     
/*  742 */     while (this.z < this.b.size) {
/*  743 */       kryoForState.writeObject(this.A, ((StateSystem.ActionUpdatePair[])this.b.items)[this.z]);
/*  744 */       this.z++;
/*      */     } 
/*  746 */     output.writeBytes(this.A.getBuffer(), 0, this.A.position());
/*      */ 
/*      */     
/*  749 */     if (paramBoolean) {
/*      */       try {
/*  751 */         this.x.reset();
/*  752 */         this.S.serialize(this.x);
/*  753 */         output.write(this.x.getBuffer(), 0, this.x.position()); return;
/*  754 */       } catch (Exception exception) {
/*  755 */         c.e("failed to serialize state, forcing regular save", new Object[] { exception });
/*  756 */         CrashHandler.report("failed to serialize state", exception);
/*  757 */         setSnapshotSavesEnabled(false);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public final Output getStateBytes() {
/*  763 */     a(false);
/*      */     
/*  765 */     return this.w;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String getStateStr(boolean paramBoolean) {
/*  772 */     a(paramBoolean);
/*      */     
/*  774 */     return StringFormatter.toCompactBase64(this.w.getBuffer(), 0, this.w.position());
/*      */   }
/*      */   
/*      */   public final void saveGame() {
/*  778 */     if (this.S.CFG.headless || this.replayMode)
/*      */       return; 
/*  780 */     if (this.gameSavesDisabled) {
/*  781 */       c.e("game saves disabled manually", new Object[0]);
/*      */       return;
/*      */     } 
/*  784 */     if (this.S.gameState.isFastForwarding()) {
/*  785 */       c.e("game is fast-forwarding, save skipped", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  789 */     if (this.S.gameValue.getBooleanValue(GameValueType.GAME_SAVES) && !this.p)
/*      */     {
/*  791 */       if (this.updateNumber != this.o) {
/*      */         
/*  793 */         long l = Game.getRealTickCount();
/*  794 */         this.o = this.updateNumber;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  811 */         a(this.snapshotSavesEnabled);
/*      */ 
/*      */ 
/*      */         
/*  815 */         if (this.B == null || this.B.length < this.w.position()) {
/*  816 */           this.B = new byte[MathUtils.nextPowerOfTwo(this.w.position())];
/*      */         }
/*  818 */         synchronized (this.D) {
/*  819 */           System.arraycopy(this.w.getBuffer(), 0, this.B, 0, this.w.position());
/*  820 */           this.C = this.w.position();
/*  821 */           c.i("state: " + this.w.position() + " bytes", new Object[0]);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         Thread thread;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  841 */         (thread = new Thread(() -> { try { null = Gdx.files.local(PreferencesManager.getSavedGameFilePath()); synchronized (this.D) { null.writeBytes(this.B, 0, this.C, false); }  } catch (Exception exception) { c.e("failed to save game state", new Object[] { exception }); }  }"SaveGame")).setDaemon(true);
/*  842 */         thread.start();
/*  843 */         CrashHandler.handleThreadExceptionsForgiving(thread);
/*      */         
/*  845 */         c.i("game saved in " + ((float)(Game.getRealTickCount() - l) / 1000.0F) + "ms for update #" + this.updateNumber, new Object[0]);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static boolean savedGameExists() {
/*      */     FileHandle fileHandle;
/*  852 */     if (!(fileHandle = Gdx.files.local(PreferencesManager.getSavedGameFilePath())).exists()) {
/*  853 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  858 */       byte[] arrayOfByte = fileHandle.readBytes();
/*      */       
/*  860 */       E.setPosition(0);
/*  861 */       E.setBuffer(arrayOfByte);
/*      */ 
/*      */       
/*      */       int i;
/*      */       
/*  866 */       return Config.isCompatibleWithBuild(i = E.readVarInt(true));
/*  867 */     } catch (Exception exception) {
/*  868 */       c.e("savedGameExists - parsing failed, cleared saved game", new Object[] { exception });
/*  869 */       deleteSavedGame();
/*  870 */       return false;
/*      */     } 
/*      */   }
/*      */   @Null
/*      */   public static ReplayManager.ReplayHeader getSavedGameInfo() {
/*      */     FileHandle fileHandle;
/*  876 */     if (!(fileHandle = Gdx.files.local(PreferencesManager.getSavedGameFilePath())).exists()) {
/*  877 */       return null;
/*      */     }
/*      */     
/*      */     try {
/*  881 */       byte[] arrayOfByte = fileHandle.readBytes();
/*      */       Input input;
/*  883 */       (input = E).setPosition(0);
/*  884 */       input.setBuffer(arrayOfByte);
/*      */       
/*      */       ReplayManager.ReplayHeader replayHeader;
/*      */       
/*  888 */       if (!Config.isCompatibleWithBuild((replayHeader = ReplayManager.ReplayHeader.fromBytes(input)).build)) {
/*  889 */         return null;
/*      */       }
/*  891 */       return replayHeader;
/*  892 */     } catch (Exception exception) {
/*  893 */       c.e("savedGameExists - parsing failed, cleared saved game", new Object[] { exception });
/*  894 */       deleteSavedGame();
/*  895 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static ContinueGameStatus continueSavedGame() {
/*  900 */     if (savedGameExists()) {
/*  901 */       FileHandle fileHandle = Gdx.files.local(PreferencesManager.getSavedGameFilePath());
/*      */       try {
/*  903 */         Game.i.researchManager.updateAndValidateStarBranch();
/*      */         
/*  905 */         byte[] arrayOfByte = fileHandle.readBytes();
/*      */         Input input;
/*  907 */         (input = E).setPosition(0);
/*  908 */         input.setBuffer(arrayOfByte);
/*      */         
/*      */         ReplayManager.ReplayHeader replayHeader;
/*  911 */         if (!Config.isCompatibleWithBuild((replayHeader = ReplayManager.ReplayHeader.fromBytes(input)).build)) {
/*  912 */           c.e("Game is from build " + replayHeader.build + ", not compatible with 207", new Object[0]);
/*  913 */           return ContinueGameStatus.GAME_FROM_PREVIOUS_BUILD;
/*      */         } 
/*      */ 
/*      */         
/*      */         try {
/*  918 */           GameSystemProvider gameSystemProvider = GameSystemProvider.unserialize(input);
/*  919 */           c.i("restored GameSystemProvider", new Object[0]);
/*      */ 
/*      */           
/*  922 */           ProgressManager.ProgressSnapshotForState progressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  933 */           if (!replayHeader.progressSnapshot.sameAs(progressSnapshotForState)) {
/*  934 */             c.e("continueSavedGame - progress snapshots don't match", new Object[0]);
/*      */             
/*  936 */             return ContinueGameStatus.GAME_VALUES_CHANGED;
/*      */           } 
/*  938 */           c.i("game values are fine", new Object[0]);
/*      */ 
/*      */           
/*  941 */           gameSystemProvider.createAndSetupNonStateAffectingSystemsAfterDeserialization();
/*      */ 
/*      */           
/*  944 */           GameScreen gameScreen = new GameScreen(gameSystemProvider, replayHeader.gameStartTs);
/*  945 */           Game.i.screenManager.setScreen((Screen)gameScreen);
/*      */ 
/*      */           
/*  948 */           byte b = (replayHeader.basicLevelName != null) ? 1 : 0;
/*  949 */           if (!Config.isHeadless() && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION) != 0.0D)
/*      */           {
/*  951 */             if (b) {
/*      */ 
/*      */               
/*  954 */               gameScreen.validationS = new GameSystemProvider(new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, true));
/*  955 */               gameScreen.validationS.createSystems();
/*  956 */               GameScreen.configureSystemsBeforeSetup(gameScreen.validationS, replayHeader.abilitiesConfiguration, replayHeader.canLootCases, replayHeader.lootBoostEnabled, replayHeader.rarityBoostEnabled, replayHeader.gameStartTs, Game.i.basicLevelManager
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  963 */                   .getLevel(replayHeader.basicLevelName), null, replayHeader.difficultyMode, replayHeader.modeDifficultyMultiplier, replayHeader.gameMode, null, progressSnapshotForState, replayHeader.inventoryStatistics, replayHeader.dailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  973 */               gameScreen.validationS.setupSystems();
/*  974 */               gameScreen.validationS.postSetupSystems();
/*  975 */               for (b = 0; b < replayHeader.actions.size; b++) {
/*  976 */                 StateSystem.ActionUpdatePair actionUpdatePair = ((StateSystem.ActionUpdatePair[])replayHeader.actions.items)[b];
/*  977 */                 gameScreen.validationS.gameState.pushAction(actionUpdatePair.action, actionUpdatePair.update);
/*      */               } 
/*      */               
/*  980 */               gameSystemProvider.gameState.duplicateActionsTo = gameScreen.validationS.gameState;
/*      */               
/*  982 */               while (gameScreen.validationS.gameState.updateNumber != gameSystemProvider.gameState.updateNumber) {
/*  983 */                 gameScreen.validationS.gameState.a.get(gameScreen.validationS.gameState.updateNumber);
/*      */                 
/*  985 */                 gameScreen.validationS.updateSystems();
/*      */               } 
/*      */               
/*      */               try {
/*  989 */                 StringBuilder stringBuilder = new StringBuilder();
/*  990 */                 gameScreen.validationS.compareSync(gameSystemProvider, stringBuilder, false);
/*  991 */                 if (stringBuilder.length != 0) {
/*      */                   
/*  993 */                   c.e(stringBuilder.toString(), new Object[0]);
/*      */                   
/*  995 */                   if (!Config.isHeadless()) {
/*  996 */                     CrashHandler.report("Sync check - desync on continue\n" + stringBuilder);
/*  997 */                     Notifications.i().add("Desynchronization spotted!", (Drawable)Game.i.assetManager.getDrawable("icon-exclamation-triangle"), MaterialColor.ORANGE.P800, StaticSoundType.WARNING);
/*  998 */                     gameScreen.validationS = null;
/*      */                   } 
/*      */                 } 
/* 1001 */               } catch (Exception exception2) {
/* 1002 */                 Exception exception1; (exception1 = null).printStackTrace();
/* 1003 */                 c.e("Sync check - exception", new Object[] { exception1 });
/* 1004 */                 CrashHandler.report("Sync check - failed on continue", exception1);
/* 1005 */                 gameScreen.validationS = null;
/*      */               } 
/* 1007 */               c.i("validation S synchronized", new Object[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1016 */               Notifications.i().add("Synchronization check enabled, thanks for helping us to make Infinitode 2 better!", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, null);
/*      */               
/* 1018 */               Timer.schedule(new Timer.Task()
/*      */                   {
/*      */                     public void run() {
/* 1021 */                       Notifications.i().add("It affects performance and can be turned off in Settings -> Advanced -> \"Desync check\".", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.LIGHT_BLUE.P800, null);
/*      */                     }
/*      */                   }3.0F);
/*      */             } 
/*      */           }
/*      */           
/* 1027 */           gameSystemProvider.gameState.o = gameSystemProvider.gameState.updateNumber;
/* 1028 */         } catch (Exception exception) {
/* 1029 */           (input = null).printStackTrace();
/* 1030 */           c.e("failed to load the game from the snapshot, running full frame by frame loading", new Object[0]);
/*      */           
/* 1032 */           GameScreen gameScreen = null;
/* 1033 */           if (replayHeader.gameMode == GameMode.BASIC_LEVELS) {
/* 1034 */             BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(replayHeader.basicLevelName);
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1039 */             gameScreen = new GameScreen(basicLevel, replayHeader.difficultyMode, replayHeader.modeDifficultyMultiplier, replayHeader.abilitiesConfiguration, replayHeader.canLootCases, replayHeader.lootBoostEnabled, replayHeader.rarityBoostEnabled, replayHeader.gameStartTs, null, replayHeader.inventoryStatistics, replayHeader.dailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             DailyQuestManager.DailyQuestLevel dailyQuestLevel;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1054 */             if (basicLevel.dailyQuest && (
/*      */               
/* 1056 */               dailyQuestLevel = Game.i.dailyQuestManager.getDailyQuestLevelCache()).getLevelName().equals(basicLevel.name))
/*      */             {
/* 1058 */               c.i("continue daily quest", new Object[0]);
/* 1059 */               gameScreen.S.gameState.dailyQuestLevel = dailyQuestLevel;
/*      */             }
/*      */           
/* 1062 */           } else if (replayHeader.gameMode == GameMode.USER_MAPS) {
/*      */             UserMap userMap;
/* 1064 */             if ((userMap = Game.i.userMapManager.getUserMap(replayHeader.userMapId)) == null) {
/*      */               
/* 1066 */               c.e("continueSavedGame - user map not exists", new Object[0]);
/*      */ 
/*      */               
/* 1069 */               return ContinueGameStatus.MAP_NOT_FOUND;
/*      */             } 
/*      */             
/* 1072 */             if (replayHeader.userMapSeed != userMap.map.generateSeed()) {
/*      */               
/* 1074 */               c.e("continueSavedGame - user map seeds differ", new Object[0]);
/*      */ 
/*      */               
/* 1077 */               return ContinueGameStatus.MAP_CHANGED;
/*      */             } 
/*      */             
/* 1080 */             gameScreen = new GameScreen(userMap, replayHeader.difficultyMode, replayHeader.modeDifficultyMultiplier, replayHeader.abilitiesConfiguration, replayHeader.gameStartTs, replayHeader.customMapBossTypes, null, replayHeader.inventoryStatistics);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1092 */           if (gameScreen != null) {
/*      */             GameStateSystem gameStateSystem;
/*      */             
/* 1095 */             (gameStateSystem = gameScreen.S.gameState).continuedGameApproxStateHash = replayHeader.continuedGameApproxStateHash;
/*      */ 
/*      */             
/* 1098 */             ProgressManager.ProgressSnapshotForState progressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/* 1099 */             if (!gameScreen.S.gameState.gameStartProgressSnapshot.sameAs(progressSnapshotForState)) {
/* 1100 */               c.e("continueSavedGame - progress snapshots don't match", new Object[0]);
/*      */               
/* 1102 */               gameScreen.dispose();
/*      */               
/* 1104 */               return ContinueGameStatus.GAME_VALUES_CHANGED;
/*      */             } 
/*      */ 
/*      */             
/* 1108 */             if (gameStateSystem.getSeed() != replayHeader.seed) {
/* 1109 */               c.e("continueSavedGame - seeds don't match: " + gameStateSystem.getSeed() + " " + replayHeader.seed, new Object[0]);
/*      */               
/* 1111 */               gameScreen.dispose();
/*      */               
/* 1113 */               return ContinueGameStatus.MAP_CHANGED;
/*      */             } 
/* 1115 */             gameStateSystem.gameIsContinued = true;
/* 1116 */             gameStateSystem.playRealTime = replayHeader.playRealTime;
/*      */             
/* 1118 */             for (byte b = 0; b < replayHeader.actions.size; b++) {
/* 1119 */               StateSystem.ActionUpdatePair actionUpdatePair = ((StateSystem.ActionUpdatePair[])replayHeader.actions.items)[b];
/* 1120 */               gameStateSystem.pushAction(actionUpdatePair.action, actionUpdatePair.update);
/*      */             } 
/*      */ 
/*      */             
/* 1124 */             gameStateSystem.startFastForwarding((int)replayHeader.updateNumber);
/*      */             
/* 1126 */             Game.i.screenManager.setScreen((Screen)gameScreen);
/*      */             
/* 1128 */             gameStateSystem.o = gameStateSystem.updateNumber;
/*      */             
/* 1130 */             return ContinueGameStatus.SUCCESS;
/*      */           } 
/* 1132 */           c.e("screen is null", new Object[0]);
/* 1133 */           return ContinueGameStatus.OTHER_ERROR;
/*      */         } 
/*      */         
/* 1136 */         return ContinueGameStatus.SUCCESS;
/* 1137 */       } catch (Exception exception) {
/* 1138 */         c.e("continueSavedGame - parsing failed, cleared saved game", new Object[] { exception });
/* 1139 */         return ContinueGameStatus.OTHER_ERROR;
/*      */       } 
/*      */     } 
/* 1142 */     c.e("saved game not exists", new Object[0]);
/* 1143 */     return ContinueGameStatus.OTHER_ERROR;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void startReplay(ReplayManager.ReplayRecord paramReplayRecord) {
/* 1148 */     startReplayAsRealRun(paramReplayRecord, false);
/*      */   }
/*      */   
/*      */   public static void startReplayAsRealRun(ReplayManager.ReplayRecord paramReplayRecord, boolean paramBoolean) {
/* 1152 */     if (!Config.isCompatibleWithBuild(paramReplayRecord.build)) {
/* 1153 */       Dialog.i().showAlert("Game is from build " + paramReplayRecord.build + ", not compatible with 207");
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     try {
/*      */       byte[] arrayOfByte;
/*      */       
/* 1161 */       if ((arrayOfByte = paramReplayRecord.getStateBytes()) != null) {
/*      */         GameScreen gameScreen; Input input;
/* 1163 */         (input = E).setPosition(0);
/* 1164 */         input.setBuffer(arrayOfByte);
/* 1165 */         ReplayManager.ReplayHeader replayHeader = ReplayManager.ReplayHeader.fromBytes(input);
/*      */         
/* 1167 */         input = null;
/* 1168 */         if (replayHeader.gameMode == GameMode.BASIC_LEVELS) {
/*      */           BasicLevel basicLevel;
/* 1170 */           if ((basicLevel = Game.i.basicLevelManager.getLevel(replayHeader.basicLevelName)) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1175 */             gameScreen = new GameScreen(basicLevel, replayHeader.difficultyMode, replayHeader.modeDifficultyMultiplier, replayHeader.abilitiesConfiguration, replayHeader.canLootCases, replayHeader.lootBoostEnabled, replayHeader.rarityBoostEnabled, replayHeader.gameStartTs, replayHeader.progressSnapshot, replayHeader.inventoryStatistics, replayHeader.dailyQuestLevel);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*      */           else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1189 */             Dialog.i().showAlert("Basic map not exists");
/*      */           } 
/* 1191 */         } else if (replayHeader.gameMode == GameMode.USER_MAPS) {
/*      */           UserMap userMap;
/* 1193 */           if ((userMap = Game.i.userMapManager.getUserMap(replayHeader.userMapId)) == null) {
/*      */             
/* 1195 */             Dialog.i().showAlert("User map not exists");
/*      */             
/*      */             return;
/*      */           } 
/* 1199 */           if (replayHeader.userMapSeed != userMap.map.generateSeed() && !paramBoolean) {
/*      */             
/* 1201 */             Dialog.i().showAlert("User map seeds differ");
/*      */             
/*      */             return;
/*      */           } 
/* 1205 */           gameScreen = new GameScreen(userMap, replayHeader.difficultyMode, replayHeader.modeDifficultyMultiplier, replayHeader.abilitiesConfiguration, replayHeader.gameStartTs, replayHeader.customMapBossTypes, replayHeader.progressSnapshot, replayHeader.inventoryStatistics);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1217 */         if (gameScreen != null) {
/*      */           GameStateSystem gameStateSystem;
/*      */ 
/*      */           
/* 1221 */           if ((gameStateSystem = gameScreen.S.gameState).getSeed() != replayHeader.seed) {
/* 1222 */             Dialog.i().showAlert("Seeds don't match: " + gameStateSystem.getSeed() + " " + replayHeader.seed);
/* 1223 */             gameScreen.dispose();
/*      */             
/*      */             return;
/*      */           } 
/* 1227 */           gameStateSystem.playRealTime = replayHeader.playRealTime;
/*      */ 
/*      */ 
/*      */           
/* 1231 */           for (byte b = 0; b < replayHeader.actionsCount; b++) {
/* 1232 */             StateSystem.ActionUpdatePair actionUpdatePair = (StateSystem.ActionUpdatePair)replayHeader.actions.get(b);
/* 1233 */             gameStateSystem.pushAction(actionUpdatePair.action, actionUpdatePair.update);
/*      */           } 
/*      */           
/* 1236 */           if (!paramBoolean) {
/* 1237 */             gameStateSystem.replayMode = true;
/* 1238 */             gameStateSystem.replayRecord = paramReplayRecord;
/* 1239 */             gameStateSystem.replayFrameCount = replayHeader.updateNumber;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1245 */           c.i("successfully started the game", new Object[0]);
/*      */           
/* 1247 */           Game.i.screenManager.setScreen((Screen)gameScreen);
/*      */         } else {
/* 1249 */           Dialog.i().showAlert("Screen is null"); return;
/*      */         } 
/*      */       } else {
/* 1252 */         c.e("Replay has no state", new Object[0]);
/* 1253 */         Dialog.i().showAlert("Replay has no state, only basic data");
/*      */       }  return;
/* 1255 */     } catch (Exception exception) {
/* 1256 */       c.e("Parsing failed", new Object[] { exception });
/* 1257 */       Dialog.i().showAlert("Parsing failed");
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void deleteSavedGame() {
/* 1262 */     if (Config.isHeadless())
/*      */       return; 
/*      */     try {
/* 1265 */       if (Gdx.files.local(PreferencesManager.getSavedGameFilePath()).exists())
/* 1266 */         Gdx.files.local(PreferencesManager.getSavedGameFilePath()).delete(); 
/*      */       return;
/* 1268 */     } catch (Exception exception) {
/* 1269 */       c.e("failed to delete saved game", new Object[] { exception });
/*      */       return;
/*      */     } 
/*      */   }
/*      */   public final void animateSpeed(float paramFloat1, float paramFloat2) {
/* 1274 */     this.F = true;
/* 1275 */     this.H = paramFloat2;
/* 1276 */     this.I = 0.0F;
/* 1277 */     this.G = paramFloat1;
/*      */   }
/*      */   
/*      */   public final float getNonAnimatedGameSpeed() {
/* 1281 */     return this.m;
/*      */   }
/*      */   
/*      */   public final float getGameSpeed() {
/*      */     float f;
/* 1286 */     if (this.F) {
/*      */       
/* 1288 */       if ((f = this.I / this.H) >= 1.0F) {
/* 1289 */         this.F = false;
/* 1290 */         f = 1.0F;
/*      */       } 
/* 1292 */       f = 1.0F - f;
/*      */       
/* 1294 */       f = this.m + (this.G - this.m) * f;
/*      */     } else {
/* 1296 */       f = this.m;
/*      */     } 
/*      */     
/* 1299 */     return Math.max(f, 0.0F);
/*      */   }
/*      */   
/*      */   public final void setGameSpeed(float paramFloat) {
/* 1303 */     if (this.m != paramFloat) {
/*      */       
/* 1305 */       this.F = false;
/* 1306 */       this.m = paramFloat;
/*      */       
/* 1308 */       this.S.events.trigger((Event)new GameSpeedChange());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void higherGameSpeed() {
/* 1313 */     float f = this.m * 2.0F;
/*      */     
/* 1315 */     if (!this.S.gameState.replayMode && 
/* 1316 */       f > 4.0F) {
/* 1317 */       f = 4.0F;
/*      */     }
/*      */ 
/*      */     
/* 1321 */     if (f > 0.95F && f < 1.05F) {
/* 1322 */       f = 1.0F;
/* 1323 */     } else if (f > 1.95F && f < 2.05F) {
/* 1324 */       f = 2.0F;
/* 1325 */     } else if (f > 3.95F && f < 4.05F) {
/*      */       
/* 1327 */       f = 4.0F;
/*      */     } 
/*      */     
/* 1330 */     setGameSpeed(f);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void lowerGameSpeed() {
/*      */     float f;
/* 1336 */     if ((f = this.m * 0.5F) > 0.95F && f < 1.05F) {
/* 1337 */       f = 1.0F;
/* 1338 */     } else if (f > 1.95F && f < 2.05F) {
/* 1339 */       f = 2.0F;
/* 1340 */     } else if (f > 3.95F && f < 4.05F) {
/*      */       
/* 1342 */       f = 4.0F;
/*      */     } 
/*      */     
/* 1345 */     setGameSpeed(f);
/*      */   }
/*      */   
/*      */   public final void switchGameSpeed() {
/*      */     float f;
/* 1350 */     if (StrictMath.abs(this.m - 1.0F) < 0.1D) {
/*      */       
/* 1352 */       f = 2.0F;
/* 1353 */     } else if (StrictMath.abs(this.m - 2.0F) < 0.1D) {
/*      */       
/* 1355 */       f = 4.0F;
/*      */     } else {
/*      */       
/* 1358 */       f = 1.0F;
/*      */     } 
/*      */     
/* 1361 */     setGameSpeed(f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isGameRealTimePasses() {
/* 1368 */     if (this.S.wave.status == WaveSystem.Status.NOT_STARTED) return false;
/*      */     
/* 1370 */     if (this.difficultyMode == DifficultyMode.EASY) {
/* 1371 */       if (this.S.wave.status == WaveSystem.Status.SPAWNING)
/* 1372 */         return true; 
/* 1373 */       if (this.S.wave.getTimeToNextWave() <= 0.0F && !this.S.wave.allWavesSpawned()) {
/* 1374 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1378 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setMoney(int paramInt) {
/* 1384 */     int i = this.g;
/* 1385 */     this.g = paramInt;
/*      */     
/* 1387 */     this.S.events.trigger((Event)new CoinsChange(i, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int addMoney(float paramFloat, boolean paramBoolean) {
/* 1395 */     checkGameplayUpdateAllowed();
/*      */     
/* 1397 */     int i = (int)paramFloat;
/*      */     
/* 1399 */     if ((paramFloat = paramFloat - i) > 0.001F && randomFloat() < paramFloat) {
/* 1400 */       i++;
/*      */     }
/*      */     
/* 1403 */     if (i > 0) {
/* 1404 */       int j = this.g;
/* 1405 */       this.g = PMath.addWithoutOverflow(this.g, i);
/*      */       
/* 1407 */       this.S.events.trigger((Event)new CoinsChange(j, paramBoolean));
/*      */     } 
/*      */     
/* 1410 */     return i;
/*      */   }
/*      */   
/*      */   public final boolean removeMoney(int paramInt) {
/* 1414 */     if (paramInt <= 0) return true;
/*      */     
/* 1416 */     checkGameplayUpdateAllowed();
/*      */     
/* 1418 */     if (this.g >= paramInt) {
/* 1419 */       int i = this.g;
/* 1420 */       this.g -= paramInt;
/* 1421 */       this.S.events.trigger((Event)new CoinsChange(i, false));
/*      */       
/* 1423 */       return true;
/*      */     } 
/*      */     
/* 1426 */     return false;
/*      */   }
/*      */   
/*      */   public final int getMoney() {
/* 1430 */     return this.g;
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
/*      */   public final void addCompletedQuestIssuedPrizes(IssuedItems paramIssuedItems, float paramFloat1, float paramFloat2, int paramInt) {
/* 1487 */     if (!paramIssuedItems.addedToIssuedItemsArray) {
/* 1488 */       this.k.add(paramIssuedItems);
/* 1489 */       paramIssuedItems.addedToIssuedItemsArray = true;
/*      */       
/* 1491 */       float f = 0.0F;
/* 1492 */       for (byte b = 0; b < paramIssuedItems.items.size; b++) {
/*      */         ItemStack itemStack;
/*      */         
/* 1495 */         if ((itemStack = ((ItemStack[])paramIssuedItems.items.items)[b]).getItem() != Item.D.GREEN_PAPER && !(itemStack.getItem() instanceof com.prineside.tdi2.items.StarItem) && itemStack.getItem() != Item.D.ACCELERATOR) {
/* 1496 */           itemStack.covered = true;
/*      */         }
/*      */         
/* 1499 */         this.S.events.trigger((Event)new IssuedItemsAdd(paramIssuedItems, itemStack, paramFloat1 + f, paramFloat2, paramInt));
/* 1500 */         f += 108.4F;
/*      */       } 
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
/*      */ 
/*      */   
/*      */   public final void addLootIssuedPrizes(ItemStack paramItemStack, float paramFloat1, float paramFloat2, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: invokevirtual checkGameplayUpdateAllowed : ()V
/*      */     //   4: iconst_0
/*      */     //   5: istore #5
/*      */     //   7: iconst_0
/*      */     //   8: istore #6
/*      */     //   10: iload #6
/*      */     //   12: aload_0
/*      */     //   13: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   16: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   19: getfield size : I
/*      */     //   22: if_icmpge -> 97
/*      */     //   25: aload_0
/*      */     //   26: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   29: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   32: getfield items : [Ljava/lang/Object;
/*      */     //   35: checkcast [Lcom/prineside/tdi2/ItemStack;
/*      */     //   38: iload #6
/*      */     //   40: aaload
/*      */     //   41: dup
/*      */     //   42: astore #7
/*      */     //   44: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   47: aload_1
/*      */     //   48: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   51: invokevirtual sameAs : (Lcom/prineside/tdi2/Item;)Z
/*      */     //   54: ifeq -> 91
/*      */     //   57: aload #7
/*      */     //   59: getfield covered : Z
/*      */     //   62: aload_1
/*      */     //   63: getfield covered : Z
/*      */     //   66: if_icmpne -> 91
/*      */     //   69: iconst_1
/*      */     //   70: istore #5
/*      */     //   72: aload #7
/*      */     //   74: dup
/*      */     //   75: invokevirtual getCount : ()I
/*      */     //   78: aload_1
/*      */     //   79: invokevirtual getCount : ()I
/*      */     //   82: invokestatic addWithoutOverflow : (II)I
/*      */     //   85: invokevirtual setCount : (I)V
/*      */     //   88: goto -> 97
/*      */     //   91: iinc #6, 1
/*      */     //   94: goto -> 10
/*      */     //   97: iload #5
/*      */     //   99: ifne -> 320
/*      */     //   102: iconst_0
/*      */     //   103: istore #6
/*      */     //   105: aload_0
/*      */     //   106: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   109: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   112: getfield size : I
/*      */     //   115: sipush #500
/*      */     //   118: if_icmple -> 125
/*      */     //   121: iconst_1
/*      */     //   122: goto -> 165
/*      */     //   125: aload_0
/*      */     //   126: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   129: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   132: getfield size : I
/*      */     //   135: sipush #250
/*      */     //   138: if_icmple -> 167
/*      */     //   141: aload_0
/*      */     //   142: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   145: getfield loot : Lcom/prineside/tdi2/systems/LootSystem;
/*      */     //   148: getfield random : Lcom/badlogic/gdx/math/RandomXS128;
/*      */     //   151: invokevirtual nextFloat : ()F
/*      */     //   154: ldc 0.5
/*      */     //   156: fcmpl
/*      */     //   157: ifle -> 164
/*      */     //   160: iconst_1
/*      */     //   161: goto -> 165
/*      */     //   164: iconst_0
/*      */     //   165: istore #6
/*      */     //   167: iload #6
/*      */     //   169: ifeq -> 306
/*      */     //   172: aload_1
/*      */     //   173: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   176: astore #7
/*      */     //   178: iconst_0
/*      */     //   179: istore #5
/*      */     //   181: aload_1
/*      */     //   182: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   185: instanceof com/prineside/tdi2/items/TileItem
/*      */     //   188: ifeq -> 218
/*      */     //   191: aload #7
/*      */     //   193: checkcast com/prineside/tdi2/items/TileItem
/*      */     //   196: getfield tile : Lcom/prineside/tdi2/Tile;
/*      */     //   199: invokevirtual getPrestigeScore : ()D
/*      */     //   202: aload_1
/*      */     //   203: invokevirtual getCount : ()I
/*      */     //   206: i2d
/*      */     //   207: dmul
/*      */     //   208: ldc2_w 1000.0
/*      */     //   211: dmul
/*      */     //   212: d2i
/*      */     //   213: istore #5
/*      */     //   215: goto -> 252
/*      */     //   218: aload_1
/*      */     //   219: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   222: instanceof com/prineside/tdi2/items/GateItem
/*      */     //   225: ifeq -> 252
/*      */     //   228: aload #7
/*      */     //   230: checkcast com/prineside/tdi2/items/GateItem
/*      */     //   233: getfield gate : Lcom/prineside/tdi2/Gate;
/*      */     //   236: invokevirtual getPrestigeScore : ()D
/*      */     //   239: aload_1
/*      */     //   240: invokevirtual getCount : ()I
/*      */     //   243: i2d
/*      */     //   244: dmul
/*      */     //   245: ldc2_w 1000.0
/*      */     //   248: dmul
/*      */     //   249: d2i
/*      */     //   250: istore #5
/*      */     //   252: iload #5
/*      */     //   254: ifgt -> 274
/*      */     //   257: aload_0
/*      */     //   258: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   261: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   264: aload_1
/*      */     //   265: invokevirtual cpy : ()Lcom/prineside/tdi2/ItemStack;
/*      */     //   268: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   271: goto -> 320
/*      */     //   274: aload_0
/*      */     //   275: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   278: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   281: getstatic com/prineside/tdi2/Item$D.PRESTIGE_DUST : Lcom/prineside/tdi2/items/PrestigeDustItem;
/*      */     //   284: iload #5
/*      */     //   286: invokestatic addItemToStacksArray : (Lcom/badlogic/gdx/utils/Array;Lcom/prineside/tdi2/Item;I)Lcom/prineside/tdi2/ItemStack;
/*      */     //   289: pop
/*      */     //   290: new com/prineside/tdi2/ItemStack
/*      */     //   293: dup
/*      */     //   294: getstatic com/prineside/tdi2/Item$D.PRESTIGE_DUST : Lcom/prineside/tdi2/items/PrestigeDustItem;
/*      */     //   297: iload #5
/*      */     //   299: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   302: astore_1
/*      */     //   303: goto -> 320
/*      */     //   306: aload_0
/*      */     //   307: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   310: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   313: aload_1
/*      */     //   314: invokevirtual cpy : ()Lcom/prineside/tdi2/ItemStack;
/*      */     //   317: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   320: aload_0
/*      */     //   321: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   324: getfield events : Lcom/prineside/tdi2/events/EventDispatcher;
/*      */     //   327: new com/prineside/tdi2/events/game/IssuedItemsAdd
/*      */     //   330: dup
/*      */     //   331: aload_0
/*      */     //   332: getfield i : Lcom/prineside/tdi2/IssuedItems;
/*      */     //   335: aload_1
/*      */     //   336: fload_2
/*      */     //   337: fload_3
/*      */     //   338: iload #4
/*      */     //   340: invokespecial <init> : (Lcom/prineside/tdi2/IssuedItems;Lcom/prineside/tdi2/ItemStack;FFI)V
/*      */     //   343: invokevirtual trigger : (Lcom/prineside/tdi2/events/Event;)Lcom/prineside/tdi2/events/Event;
/*      */     //   346: pop
/*      */     //   347: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1510	-> 0
/*      */     //   #1512	-> 4
/*      */     //   #1513	-> 7
/*      */     //   #1514	-> 25
/*      */     //   #1515	-> 42
/*      */     //   #1516	-> 69
/*      */     //   #1517	-> 72
/*      */     //   #1519	-> 88
/*      */     //   #1513	-> 91
/*      */     //   #1522	-> 97
/*      */     //   #1524	-> 102
/*      */     //   #1525	-> 105
/*      */     //   #1526	-> 121
/*      */     //   #1527	-> 125
/*      */     //   #1528	-> 141
/*      */     //   #1531	-> 167
/*      */     //   #1532	-> 172
/*      */     //   #1533	-> 178
/*      */     //   #1534	-> 181
/*      */     //   #1535	-> 191
/*      */     //   #1536	-> 218
/*      */     //   #1537	-> 228
/*      */     //   #1539	-> 252
/*      */     //   #1541	-> 257
/*      */     //   #1545	-> 274
/*      */     //   #1548	-> 290
/*      */     //   #1550	-> 303
/*      */     //   #1551	-> 306
/*      */     //   #1556	-> 320
/*      */     //   #1557	-> 347
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
/*      */   public final Array<IssuedItems> getQuestsIssuedPrizes() {
/* 1560 */     return this.k;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void addCompletedQuest(String paramString) {
/* 1565 */     this.j.add(paramString);
/*      */   }
/*      */   
/*      */   public final Array<String> getCompletedQuests() {
/* 1569 */     return this.j;
/*      */   }
/*      */   
/*      */   public final void setResources(ResourceType paramResourceType, int paramInt) {
/* 1573 */     checkGameplayUpdateAllowed();
/*      */     
/* 1575 */     int i = this.h[paramResourceType.ordinal()];
/* 1576 */     this.h[paramResourceType.ordinal()] = paramInt;
/*      */     
/* 1578 */     this.S.events.trigger((Event)new MinedResourcesChange(paramResourceType, i, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int addResources(ResourceType paramResourceType, float paramFloat) {
/* 1585 */     checkGameplayUpdateAllowed();
/*      */     
/* 1587 */     int j = (int)paramFloat;
/*      */     
/* 1589 */     if ((paramFloat = paramFloat - j) > 0.001F && randomFloat() < paramFloat) {
/* 1590 */       j++;
/*      */     }
/*      */     
/* 1593 */     int i = this.h[paramResourceType.ordinal()];
/* 1594 */     this.h[paramResourceType.ordinal()] = PMath.addWithoutOverflow(this.h[paramResourceType.ordinal()], j);
/*      */     
/* 1596 */     this.S.events.trigger((Event)new MinedResourcesChange(paramResourceType, i, true));
/*      */     
/* 1598 */     return j;
/*      */   }
/*      */   
/*      */   public final boolean removeResources(ResourceType paramResourceType, int paramInt) {
/* 1602 */     checkGameplayUpdateAllowed();
/*      */     
/* 1604 */     if (this.h[paramResourceType.ordinal()] >= paramInt) {
/* 1605 */       int i = this.h[paramResourceType.ordinal()];
/* 1606 */       this.h[paramResourceType.ordinal()] = this.h[paramResourceType.ordinal()] - paramInt;
/*      */       
/* 1608 */       this.S.events.trigger((Event)new MinedResourcesChange(paramResourceType, i, false));
/*      */       
/* 1610 */       return true;
/*      */     } 
/*      */     
/* 1613 */     return false;
/*      */   }
/*      */   
/*      */   public final int getResources(ResourceType paramResourceType) {
/* 1617 */     return this.h[paramResourceType.ordinal()];
/*      */   }
/*      */   
/*      */   public final void setHealth(int paramInt) {
/* 1621 */     checkGameplayUpdateAllowed();
/*      */     
/* 1623 */     int i = this.f;
/* 1624 */     this.f = paramInt;
/*      */     
/* 1626 */     this.S.events.trigger((Event)new BaseHealthChange(i));
/*      */   }
/*      */   
/*      */   public final void addHealth(int paramInt) {
/* 1630 */     checkGameplayUpdateAllowed();
/*      */     
/* 1632 */     int i = this.f;
/* 1633 */     this.f = PMath.addWithoutOverflow(this.f, paramInt);
/*      */     
/* 1635 */     this.S.events.trigger((Event)new BaseHealthChange(i));
/*      */   }
/*      */   
/*      */   public final void removeHealth(int paramInt) {
/* 1639 */     checkGameplayUpdateAllowed();
/*      */     
/* 1641 */     int i = this.f;
/* 1642 */     this.f -= paramInt;
/*      */     
/* 1644 */     this.S.events.trigger((Event)new BaseHealthChange(i));
/*      */   }
/*      */   
/*      */   public final int getHealth() {
/* 1648 */     return this.f;
/*      */   }
/*      */   
/*      */   public final void setScore(long paramLong) {
/* 1652 */     checkGameplayUpdateAllowed();
/*      */     
/* 1654 */     long l = this.e;
/* 1655 */     this.e = paramLong;
/*      */     
/* 1657 */     if (!isMaxEndlessReplayTimeReached()) {
/* 1658 */       this.scoreWithEndlessTimeLimit = paramLong;
/*      */     }
/*      */     
/* 1661 */     this.S.events.trigger((Event)new ScoreChange(l, false, null));
/*      */   }
/*      */   
/*      */   public final float getScoreMultiplier(StatisticsType paramStatisticsType) {
/* 1665 */     switch (null.a[paramStatisticsType.ordinal()]) {
/*      */       case 1:
/* 1667 */         return (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.SCORE_ENEMIES_KILLED);
/*      */       
/*      */       case 2:
/* 1670 */         return (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.SCORE_WAVE_CALLS);
/*      */       
/*      */       case 3:
/* 1673 */         return (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.SCORE_MINING);
/*      */       
/*      */       case 4:
/* 1676 */         return (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.SCORE_CLEARED_WAVES);
/*      */     } 
/*      */     
/* 1679 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final long calculateFinalScore(long paramLong, StatisticsType paramStatisticsType) {
/*      */     float f;
/* 1691 */     paramLong = Math.round((f = getScoreMultiplier(paramStatisticsType)) * (float)paramLong);
/*      */ 
/*      */     
/* 1694 */     f = 1.0F;
/* 1695 */     if (this.averageDifficulty < 100) {
/* 1696 */       f = this.averageDifficulty * 0.01F;
/* 1697 */     } else if (this.averageDifficulty > 100) {
/* 1698 */       f = 1.0F + (this.averageDifficulty - 100) / 400.0F;
/*      */     } 
/*      */     
/* 1701 */     f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.SCORE));
/*      */ 
/*      */     
/* 1704 */     return paramLong = (long)((float)paramLong * f);
/*      */   }
/*      */   
/*      */   public final long addScore(long paramLong, StatisticsType paramStatisticsType) {
/* 1708 */     checkGameplayUpdateAllowed();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1713 */     if ((paramLong = calculateFinalScore(paramLong, paramStatisticsType)) <= 0L) return 0L;
/*      */     
/* 1715 */     long l = this.e;
/* 1716 */     this.e += paramLong;
/*      */     
/* 1718 */     if (!isMaxEndlessReplayTimeReached()) {
/* 1719 */       this.scoreWithEndlessTimeLimit = this.e;
/*      */     }
/*      */     
/* 1722 */     this.S.events.trigger((Event)new ScoreChange(l, true, paramStatisticsType));
/*      */     
/* 1724 */     return paramLong;
/*      */   }
/*      */   
/*      */   public final long getScore() {
/* 1728 */     return this.e;
/*      */   }
/*      */   
/*      */   public final void pauseGame() {
/* 1732 */     if (!this.l) {
/* 1733 */       if (this.p)
/*      */         return; 
/* 1735 */       c.i("pausing " + this, new Object[0]);
/* 1736 */       this.l = true;
/* 1737 */       this.n = this.m;
/* 1738 */       this.m = 0.0F;
/* 1739 */       this.F = false;
/*      */       
/* 1741 */       saveGame();
/*      */       
/* 1743 */       this.S.events.trigger((Event)new GamePaused());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void resumeGame() {
/* 1748 */     if (this.l) {
/* 1749 */       this.l = false;
/* 1750 */       this.m = this.n;
/*      */       
/* 1752 */       this.S.events.trigger((Event)new GameResumed());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final boolean isPaused() {
/* 1757 */     return this.l;
/*      */   }
/*      */   
/*      */   public final void togglePauseMenu() {
/* 1761 */     if (this.l) {
/* 1762 */       resumeGame(); return;
/*      */     } 
/* 1764 */     pauseGame();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void triggerGameOver(GameOverReason paramGameOverReason) {
/* 1769 */     if (this.p)
/*      */       return; 
/* 1771 */     c.i("game over triggered", new Object[0]);
/*      */     
/* 1773 */     this.p = true;
/* 1774 */     this.gameOverReason = paramGameOverReason;
/*      */     
/* 1776 */     this.S.events.trigger((Event)new GameOver());
/*      */     
/* 1778 */     if (this.basicLevelName != null && this.basicLevelName.startsWith("0."))
/*      */     {
/* 1780 */       if (paramGameOverReason == GameOverReason.QUEST_FAILED || paramGameOverReason == GameOverReason.ZERO_BASE_HEALTH) {
/* 1781 */         Game.i.achievementManager.setProgress(AchievementType.FAIL_TUTORIAL, 1);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isGameOver() {
/* 1788 */     return this.p;
/*      */   }
/*      */   
/*      */   public final void realUpdate(float paramFloat) {
/* 1792 */     if (paramFloat < 0.0F || Float.isInfinite(paramFloat) || Float.isNaN(paramFloat)) {
/* 1793 */       c.e("realDeltaTime is " + paramFloat + ", reset to 0", new Object[0]);
/* 1794 */       paramFloat = 0.0F;
/* 1795 */     } else if (paramFloat > 10.0F) {
/* 1796 */       paramFloat = 10.0F;
/*      */     } 
/*      */     
/* 1799 */     if (this.K == null) {
/* 1800 */       this.K = new _LifecycleListener((byte)0);
/* 1801 */       Gdx.app.addLifecycleListener(this.K);
/*      */     } 
/*      */     
/* 1804 */     if (!isPaused() && getGameSpeed() > 0.0F) {
/* 1805 */       this.playRealTime += paramFloat;
/* 1806 */       this.I += paramFloat;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void registerPlayerActivity() {
/* 1814 */     this.r = this.q;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isMaxEndlessReplayTimeReached() {
/* 1821 */     return (DifficultyMode.isEndless(this.S.gameState.difficultyMode) && this.S.statistics.getStatistic(StatisticsType.PT) > 2700.0D);
/*      */   }
/*      */   
/*      */   public final int getPxpLastActionFrame() {
/* 1825 */     return this.r;
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
/*      */   public final void update(float paramFloat) {
/* 1838 */     if (isGameRealTimePasses()) {
/* 1839 */       this.v -= paramFloat;
/* 1840 */       if (this.v < 0.0F) this.v = 0.0F;
/*      */ 
/*      */       
/* 1843 */       if (this.pxpExperience < 1333 && !isMaxEndlessReplayTimeReached()) {
/* 1844 */         this.q++;
/*      */         
/* 1846 */         if (this.q - this.r > 13500) {
/*      */ 
/*      */ 
/*      */           
/* 1850 */           this.s = this.q;
/*      */         
/*      */         }
/*      */         else {
/*      */           
/* 1855 */           char c = DifficultyMode.isEndless(this.difficultyMode) ? 'ᔘ' : 'ઌ';
/* 1856 */           if (this.q - this.s == c) {
/*      */             
/* 1858 */             this.pxpExperience++;
/* 1859 */             this.s = this.q;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*      */       float f;
/*      */ 
/*      */       
/* 1868 */       if ((f = this.S.gameValue.getFloatValue(GameValueType.COINS_GENERATION) / 60.0F) > 0.0F) {
/* 1869 */         this.u += paramFloat;
/* 1870 */         float f1 = 1.0F;
/* 1871 */         if (isDoubleSpeedActive()) {
/* 1872 */           f *= 2.0F;
/* 1873 */           f1 = 0.5F;
/*      */         } 
/* 1875 */         this.t += paramFloat * f;
/*      */         
/* 1877 */         if (this.u >= f1) {
/* 1878 */           this.u -= f1;
/*      */           
/* 1880 */           if (this.t >= 1.0F) {
/* 1881 */             int i = (int)this.t;
/* 1882 */             addMoney(i, true);
/* 1883 */             this.S.statistics.addStatistic(StatisticsType.CG_PG, i);
/* 1884 */             this.t -= i;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1890 */     this.S.events.getListeners(GameStateTick.class).trigger((Event)new GameStateTick(paramFloat));
/*      */ 
/*      */     
/* 1893 */     boolean bool = false;
/* 1894 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*      */       Enemy enemy;
/* 1896 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null && 
/* 1897 */         !enemy.ignoredOnGameOverNoEnemies) {
/* 1898 */         bool = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1903 */     if (this.S.wave.status == WaveSystem.Status.ENDED && !bool) {
/* 1904 */       triggerGameOver(GameOverReason.NO_ENEMIES_LEFT);
/*      */     }
/*      */     
/* 1907 */     if (this.headlessValidatedReplayRecord != null)
/*      */     {
/* 1909 */       if (isMaxEndlessReplayTimeReached())
/*      */       {
/* 1911 */         triggerGameOver(GameOverReason.MANUAL);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean profileUpdate() {
/* 1917 */     return false;
/*      */   }
/*      */   
/*      */   public final void dispose() {
/* 1921 */     if (this.K != null) Gdx.app.removeLifecycleListener(this.K);
/*      */     
/* 1923 */     this.dailyQuestLevel = null;
/* 1924 */     this.startingAbilitiesConfiguration = null;
/* 1925 */     this.i = null;
/* 1926 */     this.gameStartProgressSnapshot = null;
/* 1927 */     this.headlessValidatedReplayRecord = null;
/*      */     
/* 1929 */     super.dispose();
/*      */   }
/*      */ 
/*      */   
/*      */   public final String getSystemName() {
/* 1934 */     return "GameState";
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static class OnMinerResourceChange
/*      */     implements KryoSerializable, Listener<MinerResourceChange> {
/*      */     private GameSystemProvider a;
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/* 1943 */       param1Kryo.writeObjectOrNull(param1Output, this.a, GameSystemProvider.class);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/* 1948 */       this.a = (GameSystemProvider)param1Kryo.readObjectOrNull(param1Input, GameSystemProvider.class);
/*      */     }
/*      */     
/*      */     @Deprecated
/*      */     private OnMinerResourceChange() {}
/*      */     
/*      */     private OnMinerResourceChange(GameSystemProvider param1GameSystemProvider) {
/* 1955 */       this.a = param1GameSystemProvider;
/*      */     }
/*      */ 
/*      */     
/*      */     public void handleEvent(MinerResourceChange param1MinerResourceChange) {
/* 1960 */       if (param1MinerResourceChange.isMined() && param1MinerResourceChange.getDelta() > 0) {
/* 1961 */         long l1 = this.a.miner.getResourceMinedRawScore(param1MinerResourceChange.getResourceType()) * param1MinerResourceChange.getDelta();
/* 1962 */         if ((param1MinerResourceChange.getMiner()).loopAbilityResourceBuffer > 0)
/*      */         {
/* 1964 */           l1 /= 2L;
/*      */         }
/* 1966 */         long l2 = this.a.gameState.addScore(l1, StatisticsType.SG_RM);
/* 1967 */         (param1MinerResourceChange.getMiner()).totalScoreGained += l2;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDie extends SerializableListener<GameStateSystem> implements Listener<EnemyDie> {
/*      */     private OnEnemyDie() {}
/*      */     
/*      */     public OnEnemyDie(GameStateSystem param1GameStateSystem) {
/* 1977 */       this.a = param1GameStateSystem;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/* 1983 */       GameSystemProvider gameSystemProvider = ((GameStateSystem)this.a).S;
/*      */       DamageRecord damageRecord;
/* 1985 */       Enemy enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy();
/* 1986 */       Tower tower = damageRecord.getTower();
/*      */       
/* 1988 */       int i = MathUtils.round(1.75F * enemy.getKillScore());
/* 1989 */       gameSystemProvider.gameState.addScore(i, StatisticsType.SG_EK);
/*      */ 
/*      */       
/* 1992 */       float f = enemy.bounty;
/* 1993 */       if (tower != null)
/*      */       {
/* 1995 */         if (tower.bountyModifiersNearby != 0 && !gameSystemProvider.gameValue.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NO_HARM_TO_TOWERS)) {
/*      */           
/* 1997 */           tower.bonusCoinsBrought -= f;
/* 1998 */           f = 0.0F;
/*      */         
/*      */         }
/* 2001 */         else if (tower.getTile() != null && (tower.getTile()).bonusType == SpaceTileBonusType.BONUS_COINS && (tower.getTile()).bonusLevel > 0) {
/* 2002 */           float f1 = SpaceTileBonus.getEffect(SpaceTileBonusType.BONUS_COINS, (tower.getTile()).bonusLevel);
/* 2003 */           tower.bonusCoinsBrought += f * (f1 - 1.0F);
/* 2004 */           f *= f1;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2010 */       if (damageRecord.getAbility() != null) {
/* 2011 */         f *= damageRecord.getAbility().getKilledEnemiesCoinMultiplier();
/*      */       }
/* 2013 */       if (f != 0.0F) {
/* 2014 */         int j = gameSystemProvider.gameState.addMoney(f, true);
/* 2015 */         gameSystemProvider.statistics.addStatistic(StatisticsType.CG_EK, j);
/*      */ 
/*      */         
/* 2018 */         if (j != 0 && gameSystemProvider._particle != null) gameSystemProvider._particle.addCoinParticle((enemy.getPosition()).x, (enemy.getPosition()).y, j); 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyReachTarget
/*      */     implements KryoSerializable, Listener<EnemyReachTarget> {
/*      */     private GameSystemProvider a;
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 2029 */       param1Kryo.writeObject(param1Output, this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 2034 */       this.a = (GameSystemProvider)param1Kryo.readObject(param1Input, GameSystemProvider.class);
/*      */     }
/*      */     
/*      */     private OnEnemyReachTarget() {}
/*      */     
/*      */     public OnEnemyReachTarget(GameSystemProvider param1GameSystemProvider) {
/* 2040 */       this.a = param1GameSystemProvider;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/*      */       Tile tile;
/* 2046 */       if (tile = param1EnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile) {
/* 2047 */         if (this.a._gameUi != null) {
/* 2048 */           this.a.map.getMap().getTargetTileOrThrow().showHitEffect(param1EnemyReachTarget.getEnemy().getPosition());
/* 2049 */           this.a._gameUi.mainUi.showHealthDelta(param1EnemyReachTarget.getFactDamage());
/*      */         } 
/*      */         
/* 2052 */         this.a.gameState.lastEnemyReachedTarget = (param1EnemyReachTarget.getEnemy()).type;
/* 2053 */         if (param1EnemyReachTarget.getFactDamage() > 0) {
/* 2054 */           this.a.gameState.removeHealth(param1EnemyReachTarget.getFactDamage());
/*      */         }
/*      */         
/* 2057 */         if (GameStateSystem.a(this.a.gameState) <= 0)
/*      */         {
/* 2059 */           this.a.gameState.triggerGameOver(GameStateSystem.GameOverReason.ZERO_BASE_HEALTH); } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @NAGS
/*      */   private class _LifecycleListener implements LifecycleListener {
/*      */     private _LifecycleListener(GameStateSystem this$0) {}
/*      */     
/*      */     public void pause() {
/* 2069 */       if (!GameStateSystem.b(this.a.S.gameState)) {
/* 2070 */         this.a.pauseGame();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void resume() {}
/*      */ 
/*      */     
/*      */     public void dispose() {}
/*      */   }
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class OnNextWaveForce
/*      */     extends SerializableListener<GameStateSystem>
/*      */     implements Listener<NextWaveForce>
/*      */   {
/*      */     private OnNextWaveForce() {}
/*      */     
/*      */     private OnNextWaveForce(GameStateSystem param1GameStateSystem) {
/* 2090 */       this.a = param1GameStateSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(NextWaveForce param1NextWaveForce) {
/* 2095 */       if (param1NextWaveForce.getTime() > 0.0F)
/* 2096 */         GameStateSystem.a((GameStateSystem)this.a, param1NextWaveForce.getTime()); 
/*      */     } }
/*      */   public static class ReplayValidationResult { public Result result; public float timeSpent; public int updatesPerSecond; public int realWaves; public long realScore; public int updates; public int xp; public int resourcesMined; public int enemiesKilled;
/*      */     public String cheatingReason;
/*      */     public ReplayManager.ReplayRecord replayRecord;
/*      */     public GameSystemProvider S;
/*      */     
/* 2103 */     public enum Result { INVALID_RECORD,
/* 2104 */       MODIFIED_GAME,
/* 2105 */       VALID,
/* 2106 */       INVALID; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ReplayValidationResult(Result param1Result, float param1Float, int param1Int1, int param1Int2, int param1Int3, long param1Long, ReplayManager.ReplayRecord param1ReplayRecord) {
/* 2126 */       this.result = param1Result;
/* 2127 */       this.timeSpent = param1Float;
/* 2128 */       this.updatesPerSecond = param1Int1;
/* 2129 */       this.updates = param1Int2;
/* 2130 */       this.replayRecord = param1ReplayRecord;
/* 2131 */       this.realWaves = param1Int3;
/* 2132 */       this.realScore = param1Long;
/*      */     }
/*      */     
/*      */     public ReplayValidationResult(Result param1Result, float param1Float, int param1Int1, int param1Int2, int param1Int3, long param1Long, ReplayManager.ReplayRecord param1ReplayRecord, String param1String) {
/* 2136 */       this(param1Result, param1Float, param1Int1, param1Int2, param1Int3, param1Long, param1ReplayRecord);
/* 2137 */       this.cheatingReason = param1String;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\GameStateSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */