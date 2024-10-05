/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.BestReplayLoadFromServer;
/*     */ import com.prineside.tdi2.events.game.CoinsChange;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*     */ import com.prineside.tdi2.events.game.GameOver;
/*     */ import com.prineside.tdi2.events.game.MinedResourcesChange;
/*     */ import com.prineside.tdi2.events.game.MinerBuild;
/*     */ import com.prineside.tdi2.events.game.MinerUpgrade;
/*     */ import com.prineside.tdi2.events.game.NextWaveForce;
/*     */ import com.prineside.tdi2.events.game.ScoreChange;
/*     */ import com.prineside.tdi2.events.game.TowerBuild;
/*     */ import com.prineside.tdi2.events.game.TowerSell;
/*     */ import com.prineside.tdi2.events.game.TowerUpgrade;
/*     */ import com.prineside.tdi2.events.game.WaveComplete;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.utils.EnumKeyArray;
/*     */ import com.prineside.tdi2.utils.MovingAverageFloat;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class StatisticsSystem extends GameSystem {
/*  51 */   private static final TLog a = TLog.forClass(StatisticsSystem.class);
/*     */   
/*     */   public static final float AVERAGES_COUNT_INTERVAL = 3.0F;
/*     */   public static final int AVERAGES_COUNT_BUFFER_SIZE = 20;
/*     */   @EnumKeyArray(enumerator = StatisticsType.class)
/*  56 */   private double[] b = new double[StatisticsType.values.length];
/*     */   
/*     */   private float c;
/*     */   
/*     */   private float d;
/*     */   
/*     */   private float e;
/*     */   private float f;
/*  64 */   private MovingAverageFloat g = new MovingAverageFloat(20);
/*  65 */   private MovingAverageFloat h = new MovingAverageFloat(20);
/*  66 */   private MovingAverageFloat i = new MovingAverageFloat(20);
/*     */   
/*  68 */   private ReplayManager.ReplayRecord.ChartFrames j = new ReplayManager.ReplayRecord.ChartFrames();
/*     */   
/*     */   public int replayChartFrameCounter;
/*     */   @NAGS
/*     */   private ReplayManager.ReplayRecord k;
/*     */   @NAGS
/*     */   private boolean l;
/*     */   private boolean m;
/*     */   private float n;
/*     */   @NAGS
/*     */   private boolean o;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  81 */     super.write(paramKryo, paramOutput);
/*  82 */     paramKryo.writeObject(paramOutput, this.b);
/*  83 */     paramOutput.writeFloat(this.c);
/*  84 */     paramOutput.writeFloat(this.d);
/*  85 */     paramOutput.writeFloat(this.e);
/*  86 */     paramOutput.writeFloat(this.f);
/*  87 */     paramKryo.writeObject(paramOutput, this.g);
/*  88 */     paramKryo.writeObject(paramOutput, this.h);
/*  89 */     paramKryo.writeObject(paramOutput, this.i);
/*  90 */     paramKryo.writeObject(paramOutput, this.j);
/*  91 */     paramOutput.writeVarInt(this.replayChartFrameCounter, true);
/*  92 */     paramOutput.writeBoolean(this.m);
/*  93 */     paramOutput.writeFloat(this.n);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  98 */     super.read(paramKryo, paramInput);
/*  99 */     this.b = (double[])paramKryo.readObject(paramInput, double[].class);
/* 100 */     this.c = paramInput.readFloat();
/* 101 */     this.d = paramInput.readFloat();
/* 102 */     this.e = paramInput.readFloat();
/* 103 */     this.f = paramInput.readFloat();
/* 104 */     this.g = (MovingAverageFloat)paramKryo.readObject(paramInput, MovingAverageFloat.class);
/* 105 */     this.h = (MovingAverageFloat)paramKryo.readObject(paramInput, MovingAverageFloat.class);
/* 106 */     this.i = (MovingAverageFloat)paramKryo.readObject(paramInput, MovingAverageFloat.class);
/* 107 */     this.j = (ReplayManager.ReplayRecord.ChartFrames)paramKryo.readObject(paramInput, ReplayManager.ReplayRecord.ChartFrames.class);
/* 108 */     this.replayChartFrameCounter = paramInput.readVarInt(true);
/* 109 */     this.m = paramInput.readBoolean();
/* 110 */     this.n = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   public final float getAverageCoinsPerMinute() {
/* 114 */     return this.g.getAverage() * 20.0F;
/*     */   }
/*     */   
/*     */   public final float getAverageScorePerMinute() {
/* 118 */     return this.h.getAverage() * 20.0F;
/*     */   }
/*     */   
/*     */   public final float getAverageKillsPerMinute() {
/* 122 */     return this.i.getAverage() * 20.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 132 */     this.S.events.getListeners(WaveComplete.class).addStateAffecting(new OnWaveComplete(this, (byte)0));
/* 133 */     this.S.events.getListeners(NextWaveForce.class).addStateAffecting(new OnNextWaveForce(this, (byte)0));
/* 134 */     this.S.events.getListeners(GameOver.class).addStateAffecting(new OnGameOver(this, (byte)0));
/* 135 */     this.S.events.getListeners(MinerBuild.class).addStateAffecting(new OnMinerBuild(this, (byte)0));
/* 136 */     this.S.events.getListeners(MinerUpgrade.class).addStateAffecting(new OnMinerUpgrade(this, (byte)0));
/* 137 */     this.S.events.getListeners(CoinsChange.class).addStateAffecting(new OnCoinsChange(this, (byte)0));
/* 138 */     this.S.events.getListeners(ScoreChange.class).addStateAffecting(new OnScoreChange(this, (byte)0));
/* 139 */     this.S.events.getListeners(TowerBuild.class).addStateAffecting(new OnTowerBuild(this, (byte)0));
/* 140 */     this.S.events.getListeners(TowerSell.class).addStateAffecting(new OnTowerSell(this, (byte)0));
/* 141 */     this.S.events.getListeners(TowerUpgrade.class).addStateAffecting(new OnTowerUpgrade(this, (byte)0));
/* 142 */     this.S.events.getListeners(MinedResourcesChange.class).addStateAffecting(new OnMinedResourcesChange(this, (byte)0));
/* 143 */     this.S.events.getListeners(EnemyTakeDamage.class).addStateAffecting(new OnEnemyTakeDamage(this));
/* 144 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this));
/* 145 */     this.S.events.getListeners(EnemyReachTarget.class).addStateAffecting(new OnEnemyReachTarget(this.S));
/*     */   }
/*     */   
/*     */   public final ReplayManager.ReplayRecord.ChartFrames getCurrentReplayChart() {
/* 149 */     return this.j;
/*     */   }
/*     */   
/*     */   public final ReplayManager.ReplayRecord.ChartFrames.FrameValues getCurrentReplayChartValues() {
/* 153 */     return ReplayManager.ReplayRecord.ChartFrames.generateFrameValues(this.S);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final ReplayManager.ReplayRecord getBestReplay() {
/* 160 */     if (!this.o) {
/*     */       
/* 162 */       this.o = true;
/* 163 */       if (this.S.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS && this.S.gameState.difficultyMode == DifficultyMode.NORMAL) {
/* 164 */         Game.i.replayManager.loadAndStoreBestReplayFromServer(this.S.gameState.basicLevelName, paramReplayRecord -> {
/*     */               if (paramReplayRecord != null) {
/*     */                 if (this.k != null && paramReplayRecord.id.equals(this.k.id)) {
/*     */                   return;
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 Threads.i().runOnMainThread(());
/*     */               } 
/*     */             });
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (this.k != null) {
/* 182 */       return this.k;
/*     */     }
/*     */     
/* 185 */     if (this.l) {
/* 186 */       return null;
/*     */     }
/*     */     
/* 189 */     String str = "";
/* 190 */     if (GameStateSystem.GameMode.isBasicLevel(this.S.gameState.gameMode)) {
/* 191 */       str = this.S.gameState.basicLevelName;
/* 192 */     } else if (this.S.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/* 193 */       str = this.S.gameState.userMapId;
/*     */     } 
/*     */     
/* 196 */     Array array = Game.i.replayManager.getAllRecordIds();
/* 197 */     ReplayManager.ReplayRecord replayRecord = null;
/*     */     try {
/* 199 */       for (byte b = 0; b < array.size; b++) {
/*     */         ReplayManager.ReplayRecord replayRecord1;
/* 201 */         if ((replayRecord1 = Game.i.replayManager.getRecord(((String[])array.items)[b])) != null)
/*     */         {
/* 203 */           if (replayRecord1.gameMode == this.S.gameState.gameMode && replayRecord1.difficultyMode == this.S.gameState.difficultyMode && replayRecord1.chartFrames.version == 2 && str.equals(replayRecord1.levelName) && (
/* 204 */             replayRecord == null || replayRecord.score < replayRecord1.score)) {
/* 205 */             replayRecord = replayRecord1;
/*     */           }
/*     */         }
/*     */       } 
/* 209 */     } catch (Exception exception) {
/* 210 */       a.e("failed to get best replay", new Object[] { exception });
/*     */     } 
/*     */     
/* 213 */     if (replayRecord == null) {
/* 214 */       this.l = true;
/* 215 */       return null;
/*     */     } 
/*     */     
/* 218 */     this.k = replayRecord;
/*     */     
/* 220 */     return replayRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final void setStatistic(StatisticsType paramStatisticsType, double paramDouble) {
/* 228 */     if (this.m) throw new IllegalStateException("Statistics are already flushed"); 
/* 229 */     this.b[paramStatisticsType.ordinal()] = paramDouble;
/*     */   }
/*     */   
/*     */   public final double getStatistic(StatisticsType paramStatisticsType) {
/* 233 */     return this.b[paramStatisticsType.ordinal()];
/*     */   }
/*     */   
/*     */   public final void addStatistic(StatisticsType paramStatisticsType, double paramDouble) {
/* 237 */     if (this.m) throw new IllegalStateException("Statistics are already flushed"); 
/* 238 */     this.b[paramStatisticsType.ordinal()] = this.b[paramStatisticsType.ordinal()] + paramDouble;
/*     */     
/* 240 */     switch (null.a[paramStatisticsType.ordinal()]) { case 1:
/* 241 */         this.d = (float)(this.d + paramDouble); return;
/* 242 */       case 2: this.e = (float)(this.e + paramDouble); return;
/* 243 */       case 3: this.f = (float)(this.f + paramDouble);
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double getCurrentGameStatistic(StatisticsType paramStatisticsType) {
/* 252 */     return this.b[paramStatisticsType.ordinal()];
/*     */   }
/*     */   
/*     */   public final double[] getCurrentGameStatistics() {
/* 256 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flushStatistics() {
/* 267 */     if (this.m) throw new IllegalStateException("Statistics are already flushed"); 
/*     */     BasicLevel basicLevel;
/* 269 */     if (this.S.gameState.basicLevelName != null && (
/*     */       
/* 271 */       basicLevel = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName)) != null && 
/* 272 */       basicLevel.notAffectsStatistics) {
/* 273 */       a.i("statistics flush skipped - disabled by level configuration", new Object[0]);
/*     */       return;
/*     */     } 
/*     */     StatisticsType[] arrayOfStatisticsType;
/*     */     int i;
/*     */     byte b;
/* 279 */     for (i = (arrayOfStatisticsType = StatisticsType.values).length, b = 0; b < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/* 280 */       Game.i.statisticsManager.registerDelta(statisticsType, this.b[statisticsType.ordinal()]);
/* 281 */       Game.i.statisticsManager.registerMaxOneGame(statisticsType, this.b[statisticsType.ordinal()]);
/*     */       b++; }
/*     */     
/* 284 */     this.m = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 289 */     if (this.S.gameState.isGameRealTimePasses()) {
/*     */       
/* 291 */       this.n += paramFloat;
/* 292 */       if (this.n > 1.0F) {
/* 293 */         addStatistic(StatisticsType.PT, 1.0D);
/* 294 */         if (this.S.loot.canGiveChests()) {
/* 295 */           addStatistic(StatisticsType.PTCL, 1.0D);
/*     */         }
/* 297 */         if (DifficultyMode.isEndless(this.S.gameState.difficultyMode)) {
/*     */           float f;
/* 299 */           if (this.S.gameState.averageDifficulty <= 100) {
/* 300 */             f = (float)StrictMath.pow((this.S.gameState.averageDifficulty / 100.0F), 1.75D);
/*     */           } else {
/* 302 */             f = 1.0F + (this.S.gameState.averageDifficulty - 100.0F) / 400.0F * 0.75F;
/*     */           } 
/*     */           
/* 305 */           addStatistic(StatisticsType.PTEMWD, f);
/*     */         } 
/* 307 */         this.n--;
/*     */       } 
/*     */       
/* 310 */       this.c += paramFloat;
/* 311 */       if (this.c > 3.0F) {
/* 312 */         this.g.push(this.d);
/* 313 */         this.h.push(this.e);
/* 314 */         this.i.push(this.f);
/* 315 */         this.d = 0.0F;
/* 316 */         this.e = 0.0F;
/* 317 */         this.f = 0.0F;
/*     */         
/* 319 */         this.c -= 3.0F;
/*     */       } 
/*     */ 
/*     */       
/* 323 */       this.replayChartFrameCounter++;
/* 324 */       if (this.replayChartFrameCounter % Config.REPLAY_CHARTS_INTERVAL == 0) {
/* 325 */         this.j.addFrame(this.S);
/*     */       }
/*     */       
/* 328 */       if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) {
/* 329 */         Game.i.debugManager.registerValue("Stats coin/score/kill PM")
/* 330 */           .append(MathUtils.round(getAverageCoinsPerMinute()))
/* 331 */           .append(" / ")
/* 332 */           .append(MathUtils.round(getAverageScorePerMinute()))
/* 333 */           .append(" / ")
/* 334 */           .append(MathUtils.round(getAverageKillsPerMinute()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 341 */     return "Statistics";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 351 */     super.dispose();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnMinerBuild extends SerializableListener<StatisticsSystem> implements Listener<MinerBuild> {
/*     */     private OnMinerBuild() {}
/*     */     
/*     */     private OnMinerBuild(StatisticsSystem param1StatisticsSystem) {
/* 359 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(MinerBuild param1MinerBuild) {
/* 364 */       Miner miner = param1MinerBuild.getMiner();
/* 365 */       int i = param1MinerBuild.getBuildPrice();
/*     */       
/* 367 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.MB, 1.0D);
/* 368 */       ((StatisticsSystem)this.a).addStatistic(Game.i.minerManager.getBuiltStatisticType(miner.type), 1.0D);
/*     */       
/* 370 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.MMS, i);
/* 371 */       ((StatisticsSystem)this.a).addStatistic(Game.i.minerManager.getMoneySpentStatisticType(miner.type), i);
/*     */       
/* 373 */       if (((StatisticsSystem)this.a).getStatistic(StatisticsType.MBS) < ((StatisticsSystem)this.a).S.miner.miners.size)
/* 374 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.MBS, ((StatisticsSystem)this.a).S.miner.miners.size - ((StatisticsSystem)this.a).getStatistic(StatisticsType.MBS)); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnMinerUpgrade
/*     */     extends SerializableListener<StatisticsSystem> implements Listener<MinerUpgrade> {
/*     */     private OnMinerUpgrade() {}
/*     */     
/*     */     private OnMinerUpgrade(StatisticsSystem param1StatisticsSystem) {
/* 384 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(MinerUpgrade param1MinerUpgrade) {
/* 389 */       Miner miner = param1MinerUpgrade.getMiner();
/* 390 */       int i = param1MinerUpgrade.getUpgradePrice();
/*     */       
/* 392 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.MU, 1.0D);
/* 393 */       ((StatisticsSystem)this.a).addStatistic(Game.i.minerManager.getUpgradedStatisticType(miner.type), 1.0D);
/*     */       
/* 395 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.MMS, i);
/* 396 */       ((StatisticsSystem)this.a).addStatistic(Game.i.minerManager.getMoneySpentStatisticType(miner.type), i);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerBuild extends SerializableListener<StatisticsSystem> implements Listener<TowerBuild> {
/*     */     private OnTowerBuild() {}
/*     */     
/*     */     private OnTowerBuild(StatisticsSystem param1StatisticsSystem) {
/* 405 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerBuild param1TowerBuild) {
/* 410 */       Tower tower = param1TowerBuild.getTower();
/* 411 */       int i = param1TowerBuild.getPrice();
/*     */       
/* 413 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TB, 1.0D);
/* 414 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getBuiltStatisticType(tower.type), 1.0D);
/*     */       
/* 416 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TMS, i);
/* 417 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getMoneySpentStatisticType(tower.type), i);
/*     */       
/* 419 */       if (((StatisticsSystem)this.a).getStatistic(StatisticsType.TBS) < ((StatisticsSystem)this.a).S.tower.towers.size)
/* 420 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.TBS, ((StatisticsSystem)this.a).S.tower.towers.size - ((StatisticsSystem)this.a).S.statistics.getStatistic(StatisticsType.TBS)); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerSell
/*     */     extends SerializableListener<StatisticsSystem> implements Listener<TowerSell> {
/*     */     private OnTowerSell() {}
/*     */     
/*     */     private OnTowerSell(StatisticsSystem param1StatisticsSystem) {
/* 430 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerSell param1TowerSell) {
/* 435 */       Tower tower = param1TowerSell.getTower();
/* 436 */       int i = param1TowerSell.getReturnedCoins();
/* 437 */       if (!tower.isSellFullRefundStillActive()) {
/* 438 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.TS, 1.0D);
/* 439 */         ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getSoldStatisticType(tower.type), 1.0D);
/* 440 */         ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getMoneySpentStatisticType(tower.type), -i);
/*     */         return;
/*     */       } 
/* 443 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TB, -1.0D);
/* 444 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getBuiltStatisticType(tower.type), -1.0D);
/*     */       
/* 446 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TMS, -i);
/* 447 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getMoneySpentStatisticType(tower.type), -i);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerUpgrade
/*     */     extends SerializableListener<StatisticsSystem> implements Listener<TowerUpgrade> {
/*     */     private OnTowerUpgrade() {}
/*     */     
/*     */     private OnTowerUpgrade(StatisticsSystem param1StatisticsSystem) {
/* 457 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerUpgrade param1TowerUpgrade) {
/* 462 */       Tower tower = param1TowerUpgrade.getTower();
/* 463 */       int i = param1TowerUpgrade.getPrice();
/*     */       
/* 465 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TMS, i);
/* 466 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getMoneySpentStatisticType(tower.type), i);
/*     */       
/* 468 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.TU, 1.0D);
/* 469 */       ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getUpgradedStatisticType(tower.type), 1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnGameOver extends SerializableListener<StatisticsSystem> implements Listener<GameOver> {
/*     */     private OnGameOver() {}
/*     */     
/*     */     private OnGameOver(StatisticsSystem param1StatisticsSystem) {
/* 478 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(GameOver param1GameOver) {
/* 483 */       StatisticsSystem.a((StatisticsSystem)this.a).addFrame(((StatisticsSystem)this.a).S);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnCoinsChange extends SerializableListener<StatisticsSystem> implements Listener<CoinsChange> {
/*     */     private OnCoinsChange() {}
/*     */     
/*     */     private OnCoinsChange(StatisticsSystem param1StatisticsSystem) {
/* 492 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(CoinsChange param1CoinsChange) {
/* 497 */       if (param1CoinsChange.isGained() && 
/* 498 */         ((StatisticsSystem)this.a).S.gameState.getMoney() > param1CoinsChange.getOldValue())
/* 499 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.CG, (((StatisticsSystem)this.a).S.gameState.getMoney() - param1CoinsChange.getOldValue())); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnScoreChange
/*     */     extends SerializableListener<StatisticsSystem>
/*     */     implements Listener<ScoreChange> {
/*     */     private OnScoreChange() {}
/*     */     
/*     */     private OnScoreChange(StatisticsSystem param1StatisticsSystem) {
/* 510 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(ScoreChange param1ScoreChange) {
/* 515 */       if (param1ScoreChange.isGained() && 
/* 516 */         ((StatisticsSystem)this.a).S.gameState.getScore() > param1ScoreChange.getOldValue()) {
/* 517 */         long l = ((StatisticsSystem)this.a).S.gameState.getScore() - param1ScoreChange.getOldValue();
/* 518 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.SG, l);
/*     */         
/* 520 */         if (param1ScoreChange.getReason() != null)
/* 521 */           ((StatisticsSystem)this.a).addStatistic(param1ScoreChange.getReason(), l); 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnMinedResourcesChange
/*     */     extends SerializableListener<StatisticsSystem>
/*     */     implements Listener<MinedResourcesChange> {
/*     */     private OnMinedResourcesChange() {}
/*     */     
/*     */     private OnMinedResourcesChange(StatisticsSystem param1StatisticsSystem) {
/* 533 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(MinedResourcesChange param1MinedResourcesChange) {
/* 538 */       if (param1MinedResourcesChange.isGained() && 
/* 539 */         ((StatisticsSystem)this.a).S.gameState.getResources(param1MinedResourcesChange.getType()) > param1MinedResourcesChange.getOldValue()) {
/* 540 */         int i = ((StatisticsSystem)this.a).S.gameState.getResources(param1MinedResourcesChange.getType()) - param1MinedResourcesChange.getOldValue();
/* 541 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.RG, i);
/* 542 */         ((StatisticsSystem)this.a).addStatistic(Game.i.resourceManager.getGainedCountStatistic(param1MinedResourcesChange.getType()), i);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie
/*     */     extends SerializableListener<StatisticsSystem> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(StatisticsSystem param1StatisticsSystem) {
/* 553 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/* 559 */       Tower tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower();
/* 560 */       Ability ability = damageRecord.getAbility();
/* 561 */       DamageType damageType = damageRecord.getDamageType();
/*     */       
/* 563 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.EK, 1.0D);
/* 564 */       if (tower != null) {
/* 565 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.TEK, 1.0D);
/* 566 */         ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getEnemiesKilledStatisticsType(tower.type), 1.0D);
/*     */       } 
/*     */       
/* 569 */       if (ability != null) {
/* 570 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_A, 1.0D);
/*     */       }
/*     */       
/* 573 */       switch (StatisticsSystem.null.b[damageType.ordinal()]) { case 1:
/* 574 */           ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_B, 1.0D); return;
/* 575 */         case 2: ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_F, 1.0D); return;
/* 576 */         case 3: ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_P, 1.0D); return;
/* 577 */         case 4: ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_E, 1.0D); return;
/* 578 */         case 5: ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_EL, 1.0D); return;
/* 579 */         case 6: ((StatisticsSystem)this.a).addStatistic(StatisticsType.KEW_L, 1.0D);
/*     */           break; }
/*     */     
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyTakeDamage extends SerializableListener<StatisticsSystem> implements Listener<EnemyTakeDamage> {
/*     */     private OnEnemyTakeDamage() {}
/*     */     
/*     */     public OnEnemyTakeDamage(StatisticsSystem param1StatisticsSystem) {
/* 589 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyTakeDamage param1EnemyTakeDamage) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/* 596 */       if ((tower = (damageRecord = param1EnemyTakeDamage.getRecord()).getTower()) != null) {
/* 597 */         float f = damageRecord.getFactDamage();
/* 598 */         if (damageRecord.isCleanForDps()) {
/* 599 */           ((StatisticsSystem)this.a).addStatistic(StatisticsType.TDD, f);
/* 600 */           ((StatisticsSystem)this.a).addStatistic(Game.i.towerManager.getDamageDealtStatisticType(tower.type), f); return;
/*     */         } 
/* 602 */         ((StatisticsSystem)this.a).addStatistic(StatisticsType.TDDNC, f);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyReachTarget
/*     */     implements KryoSerializable, Listener<EnemyReachTarget>
/*     */   {
/*     */     private GameSystemProvider a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 615 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 620 */       this.a = (GameSystemProvider)param1Kryo.readObject(param1Input, GameSystemProvider.class);
/*     */     }
/*     */     
/*     */     private OnEnemyReachTarget() {}
/*     */     
/*     */     public OnEnemyReachTarget(GameSystemProvider param1GameSystemProvider) {
/* 626 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/*     */       Tile tile;
/* 632 */       if (tile = param1EnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile)
/* 633 */         this.a.statistics.addStatistic(StatisticsType.EP, 1.0D); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnWaveComplete
/*     */     extends SerializableListener<StatisticsSystem>
/*     */     implements Listener<WaveComplete> {
/*     */     private OnWaveComplete() {}
/*     */     
/*     */     private OnWaveComplete(StatisticsSystem param1StatisticsSystem) {
/* 644 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(WaveComplete param1WaveComplete) {
/* 649 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.WD, 1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnNextWaveForce
/*     */     extends SerializableListener<StatisticsSystem> implements Listener<NextWaveForce> {
/*     */     private OnNextWaveForce() {}
/*     */     
/*     */     private OnNextWaveForce(StatisticsSystem param1StatisticsSystem) {
/* 659 */       this.a = param1StatisticsSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(NextWaveForce param1NextWaveForce) {
/* 664 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.WC, 1.0D);
/* 665 */       if (param1NextWaveForce.getTime() > 0.0F) ((StatisticsSystem)this.a).addStatistic(StatisticsType.WCST, param1NextWaveForce.getTime()); 
/* 666 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.WCGC, param1NextWaveForce.getBonusMoney());
/* 667 */       ((StatisticsSystem)this.a).addStatistic(StatisticsType.WCGS, param1NextWaveForce.getBonusScore());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\StatisticsSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */