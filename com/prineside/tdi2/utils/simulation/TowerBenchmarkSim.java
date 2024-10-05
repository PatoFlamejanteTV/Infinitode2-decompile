/*     */ package com.prineside.tdi2.utils.simulation;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.google.common.b.a.a;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ public final class TowerBenchmarkSim
/*     */   extends AbstractSimulation
/*     */ {
/*  60 */   private static final TLog a = TLog.forClass(TowerBenchmarkSim.class); public static final long BENCHMARK_STATE_START_TIMESTAMP = 1692113508000L; public final String benchmarkName; public final int threadCount; public final int runsPerCombo; public final ResearchTreeMode researchTreeMode; public final SimConfig simConfig; public final TowerType[] towerTypes;
/*     */   public final int[] waveCounts;
/*     */   public final int[] upgradeLevels;
/*     */   public final TowersBenchmarkScenario.ExtraTowers[] extraTowerScenarios;
/*     */   public final TowerBenchmarkXpConfig[] towerXpConfigs;
/*     */   
/*  66 */   public enum ResearchTreeMode { NO_RESEARCH,
/*  67 */     FULL_NORMAL,
/*  68 */     FULL_ENDLESS; }
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
/*  82 */   private final Array<a> b = new Array(true, 1, a.class);
/*  83 */   private final AtomicBoolean c = new AtomicBoolean(false);
/*     */   private Throwable d;
/*  85 */   private final List<TowerBenchmarkResults> e = Collections.synchronizedList(new ArrayList<>());
/*     */   private Runnable f;
/*     */   
/*     */   public TowerBenchmarkSim(SimConfig paramSimConfig, String paramString, int paramInt1, int paramInt2, ResearchTreeMode paramResearchTreeMode, Array<TowerBenchmarkXpConfig> paramArray, IntArray paramIntArray1, IntArray paramIntArray2, Array<TowersBenchmarkScenario.ExtraTowers> paramArray1, Array<TowerType> paramArray2) {
/*  89 */     this.benchmarkName = paramString;
/*  90 */     this.threadCount = paramInt1;
/*  91 */     this.runsPerCombo = paramInt2;
/*  92 */     this.researchTreeMode = paramResearchTreeMode;
/*  93 */     this.simConfig = paramSimConfig.cpy();
/*     */     
/*  95 */     this.towerTypes = (TowerType[])paramArray2.toArray();
/*  96 */     this.waveCounts = paramIntArray1.toArray();
/*  97 */     this.upgradeLevels = paramIntArray2.toArray();
/*  98 */     this.extraTowerScenarios = (TowersBenchmarkScenario.ExtraTowers[])paramArray1.toArray();
/*  99 */     this.towerXpConfigs = (TowerBenchmarkXpConfig[])paramArray.toArray();
/*     */   }
/*     */   
/*     */   private TowerBenchmarkResults a(String paramString, TowersBenchmarkScenario paramTowersBenchmarkScenario, GameSystemProvider paramGameSystemProvider, ObjectConsumer<Float> paramObjectConsumer) {
/*     */     TowersBenchmarkScenario towersBenchmarkScenario;
/* 104 */     (towersBenchmarkScenario = paramTowersBenchmarkScenario.cpy()).start(paramGameSystemProvider);
/* 105 */     long l1 = Game.getRealTickCount();
/* 106 */     while (!towersBenchmarkScenario.isFinished() && 
/* 107 */       isRunning()) {
/*     */ 
/*     */       
/*     */       try {
/* 111 */         paramGameSystemProvider.updateSystems();
/* 112 */         towersBenchmarkScenario.onUpdate();
/* 113 */         paramObjectConsumer.accept(Float.valueOf(towersBenchmarkScenario.getProgress()));
/* 114 */       } catch (Exception exception) {
/* 115 */         logThrowable((byte)3, "exception in " + paramString + ", frame " + paramGameSystemProvider.gameState.updateNumber, exception);
/* 116 */         this.d = exception;
/* 117 */         stop();
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     TowerBenchmarkResults towerBenchmarkResults = new TowerBenchmarkResults(paramString);
/*     */     
/* 126 */     long l2 = 0L;
/* 127 */     long l3 = 0L;
/* 128 */     towerBenchmarkResults.ups = (int)((paramGameSystemProvider.gameState.updateNumber * 1000) / (float)(Game.getRealTickCount() - l1) * 0.001F);
/* 129 */     towerBenchmarkResults.minTowerDPS = Integer.MAX_VALUE;
/* 130 */     towerBenchmarkResults.maxTowerDPS = Integer.MIN_VALUE;
/* 131 */     towerBenchmarkResults.towerPrice = Integer.MIN_VALUE;
/* 132 */     towerBenchmarkResults.minTowerKills = Integer.MAX_VALUE;
/* 133 */     towerBenchmarkResults.maxTowerKills = Integer.MIN_VALUE;
/* 134 */     towerBenchmarkResults.sumTowersPrice = 0;
/* 135 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/*     */       Tower tower;
/* 137 */       if ((tower = (Tower)paramGameSystemProvider.tower.towers.get(b)).type == paramTowersBenchmarkScenario.towerType && tower.moneySpentOn != 0) {
/*     */ 
/*     */ 
/*     */         
/* 141 */         towerBenchmarkResults.towerPrice = Math.max(towerBenchmarkResults.towerPrice, tower.moneySpentOn);
/*     */         
/* 143 */         int i = (int)tower.mdps;
/* 144 */         towerBenchmarkResults.minTowerDPS = Math.min(towerBenchmarkResults.minTowerDPS, i);
/* 145 */         towerBenchmarkResults.maxTowerDPS = Math.max(towerBenchmarkResults.maxTowerDPS, i);
/* 146 */         l2 += i;
/*     */         
/* 148 */         towerBenchmarkResults.minTowerKills = Math.min(towerBenchmarkResults.minTowerKills, tower.enemiesKilled);
/* 149 */         towerBenchmarkResults.maxTowerKills = Math.max(towerBenchmarkResults.maxTowerKills, tower.enemiesKilled);
/* 150 */         l3 += tower.enemiesKilled;
/*     */         
/* 152 */         towerBenchmarkResults.sumTowersPrice += tower.moneySpentOn;
/*     */       } 
/* 154 */     }  towerBenchmarkResults.avgTowerDPS = (int)(l2 / paramGameSystemProvider.tower.towers.size);
/* 155 */     towerBenchmarkResults.avgTowerKills = (int)(l3 / paramGameSystemProvider.statistics.getStatistic(StatisticsType.EK));
/* 156 */     towerBenchmarkResults.totalKills = (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.EK);
/* 157 */     towerBenchmarkResults.mdps = (long)paramGameSystemProvider.damage.getTowersMaxDps();
/* 158 */     towerBenchmarkResults.totalDamage = paramGameSystemProvider.statistics.getStatistic(Game.i.towerManager.getDamageDealtStatisticType(paramTowersBenchmarkScenario.towerType));
/*     */     
/* 160 */     return towerBenchmarkResults;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence getName() {
/* 166 */     return "Towers benchmark " + this.benchmarkName + " (" + this.researchTreeMode + ") on " + this.threadCount + " threads, " + Arrays.toString(this.waveCounts) + " waves, " + Arrays.toString(this.upgradeLevels) + " upgrade levels, " + Arrays.toString((Object[])this.extraTowerScenarios) + " extra towers, " + this.towerXpConfigs.length + " XP configs, " + this.simConfig.basicLevelName;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setSimFinishListener(Runnable paramRunnable) {
/* 171 */     this.f = paramRunnable;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getProgress() {
/* 176 */     synchronized (this.b) {
/* 177 */       if (this.b.size == 0) {
/* 178 */         return 0.0F;
/*     */       }
/* 180 */       double d = 0.0D;
/* 181 */       for (byte b = 0; b < this.b.size; b++) {
/* 182 */         d += ((a)this.b.get(b)).a();
/*     */       }
/* 184 */       return (float)(d / this.b.size);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void start() {
/* 190 */     if (isRunning()) {
/* 191 */       throw new IllegalStateException("Already running");
/*     */     }
/*     */     
/* 194 */     synchronized (this.b) {
/* 195 */       this.b.clear();
/*     */     } 
/* 197 */     this.e.clear();
/* 198 */     this.d = null;
/* 199 */     this.c.set(true);
/*     */     
/*     */     SimConfig simConfig;
/*     */     
/* 203 */     (simConfig = this.simConfig.cpy()).startTimestamp = 1692113508000L;
/*     */ 
/*     */     
/* 206 */     ProgressManager.ProgressSnapshotForState progressSnapshotForState = null;
/* 207 */     switch (null.a[this.researchTreeMode.ordinal()]) {
/*     */       case 1:
/* 209 */         simConfig.difficultyMode = DifficultyMode.NORMAL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 219 */         progressSnapshotForState = new ProgressManager.ProgressSnapshotForState();
/*     */         break;
/*     */       
/*     */       case 2:
/* 223 */         simConfig.difficultyMode = DifficultyMode.NORMAL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 233 */         progressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/*     */         break;
/*     */       
/*     */       case 3:
/* 237 */         simConfig.difficultyMode = DifficultyMode.ENDLESS_I;
/* 238 */         simConfig.difficultyModeMultiplier = 900;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 248 */         progressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 253 */     progressSnapshotForState = progressSnapshotForState;
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
/*     */     Thread thread;
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
/* 417 */     (thread = new Thread(() -> { ExecutorService executorService = Executors.newFixedThreadPool(this.threadCount, (ThreadFactory)new Threads.DaemonThreadFactory("Towers benchmark", true)); ArrayList<Callable> arrayList = new ArrayList(); log((byte)1, "starting tower benchmark in " + paramSimConfig.difficultyMode + " mode (" + this.researchTreeMode + " / " + this.benchmarkName + ")"); AtomicInteger atomicInteger1 = new AtomicInteger(0); AtomicInteger atomicInteger2 = new AtomicInteger(0); RandomXS128 randomXS128 = new RandomXS128(); int[] arrayOfInt; int i = (arrayOfInt = this.waveCounts).length; byte b; for (b = 0; b < i; b++) { int j = arrayOfInt[b]; TowerType[] arrayOfTowerType; int k = (arrayOfTowerType = this.towerTypes).length; for (byte b1 = 0; b1 < k; b1++) { TowerType towerType = arrayOfTowerType[b1]; TowersBenchmarkScenario.ExtraTowers[] arrayOfExtraTowers; int m = (arrayOfExtraTowers = this.extraTowerScenarios).length; for (byte b2 = 0; b2 < m; b2++) { TowersBenchmarkScenario.ExtraTowers extraTowers = arrayOfExtraTowers[b2]; int[] arrayOfInt1; int n = (arrayOfInt1 = this.upgradeLevels).length; for (byte b3 = 0; b3 < n; b3++) { int i1 = arrayOfInt1[b3]; Tower.AimStrategy aimStrategy = Tower.AimStrategy.RANDOM; TowerBenchmarkXpConfig[] arrayOfTowerBenchmarkXpConfig; int i2 = (arrayOfTowerBenchmarkXpConfig = this.towerXpConfigs).length; for (byte b4 = 0; b4 < i2; b4++) { TowerBenchmarkXpConfig towerBenchmarkXpConfig = arrayOfTowerBenchmarkXpConfig[b4]; for (byte b5 = 0; b5 < this.runsPerCombo; b5++) { atomicInteger2.addAndGet(1); a a = new a(0.0D); synchronized (this.b) { this.b.add(a); }  byte b6 = b5; arrayList.add(()); }  }  }  }  }  }  this.c.set(true); try { executorService.invokeAll((Collection)arrayList); } catch (InterruptedException interruptedException) { throw new RuntimeException(interruptedException); }  log((byte)1, "All finished"); if (this.d != null) { this.d.printStackTrace(); log((byte)3, "Finished with error, check console"); } else { synchronized (this.e) { DelayedRemovalArray delayedRemovalArray; (delayedRemovalArray = new DelayedRemovalArray(true, this.e.size(), TowerBenchmarkResults.class)).addAll((Object[])this.e.<TowerBenchmarkResults>toArray(new TowerBenchmarkResults[0])); a.i(delayedRemovalArray.size + " (resultsCopy.size)", new Object[0]); if (this.runsPerCombo > 1) for (b = 0; b < delayedRemovalArray.size; b++) { TowerBenchmarkResults towerBenchmarkResults; if ((towerBenchmarkResults = (TowerBenchmarkResults)delayedRemovalArray.get(b)) != null) { for (int k = b + 1; k < delayedRemovalArray.size; k++) { TowerBenchmarkResults towerBenchmarkResults1; if ((towerBenchmarkResults1 = (TowerBenchmarkResults)delayedRemovalArray.get(k)) != null && towerBenchmarkResults.name.equals(towerBenchmarkResults1.name)) { towerBenchmarkResults.add(towerBenchmarkResults1); delayedRemovalArray.set(k, null); }  }  towerBenchmarkResults.divideValues(this.runsPerCombo); }  }   delayedRemovalArray.begin(); for (b = 0; b < delayedRemovalArray.size; b++) { if (delayedRemovalArray.get(b) == null) delayedRemovalArray.removeIndex(b);  }  delayedRemovalArray.end(); a.i(delayedRemovalArray.size + " (resultsCopy.size after)", new Object[0]); TowerBenchmarkResults[] arrayOfTowerBenchmarkResults1 = (TowerBenchmarkResults[])delayedRemovalArray.toArray(TowerBenchmarkResults.class); a.i(arrayOfTowerBenchmarkResults1.length + " (resultsOrdered.length)", new Object[0]); Threads.sort((Object[])arrayOfTowerBenchmarkResults1, ()); StringBuilder stringBuilder; (stringBuilder = new StringBuilder()).append("INSERT INTO towers_benchmark (benchmarkName, waves, extraTowers, tower, aimStrategy, abilities, upgradeLevel, xpLevel, towerPrice, maxTowerDPS, avgTowerDPS, mdps, maxTowerKills, totalKills, ups, totalDamage, sumTowersPrice, dpsPerCoin, totalDamagePerCoin, killsPerCoin) VALUES \n"); TowerBenchmarkResults[] arrayOfTowerBenchmarkResults2; int j = (arrayOfTowerBenchmarkResults2 = arrayOfTowerBenchmarkResults1).length; for (byte b1 = 0; b1 < j; b1++) { TowerBenchmarkResults towerBenchmarkResults = arrayOfTowerBenchmarkResults2[b1]; stringBuilder.append("('").append(this.benchmarkName).append("', ").append(towerBenchmarkResults.waveCount).append(", ").append("'").append(towerBenchmarkResults.extraTowers).append("',").append("'").append(towerBenchmarkResults.tower).append("',").append("'").append(towerBenchmarkResults.aimStrategy).append("',").append("'").append(towerBenchmarkResults.abilities).append("',").append("'").append(towerBenchmarkResults.upgradeLevel).append("',").append("'").append(towerBenchmarkResults.xpLevel).append("',").append("'").append(towerBenchmarkResults.towerPrice).append("',").append("'").append(towerBenchmarkResults.maxTowerDPS).append("',").append("'").append(towerBenchmarkResults.avgTowerDPS).append("',").append("'").append(towerBenchmarkResults.mdps).append("',").append("'").append(towerBenchmarkResults.maxTowerKills).append("',").append("'").append(towerBenchmarkResults.totalKills).append("',").append("'").append(towerBenchmarkResults.ups).append("',").append("'").append(towerBenchmarkResults.totalDamage).append("',").append("'").append(towerBenchmarkResults.sumTowersPrice).append("',").append("'").append(towerBenchmarkResults.maxTowerDPS / towerBenchmarkResults.towerPrice).append("',").append("'").append(towerBenchmarkResults.totalDamage / towerBenchmarkResults.sumTowersPrice).append("',").append("'").append(towerBenchmarkResults.maxTowerKills / towerBenchmarkResults.towerPrice).append("'),\n"); }  stringBuilder.setLength(stringBuilder.length - 2); stringBuilder.append(" \nON DUPLICATE KEY UPDATE towerPrice = VALUES(towerPrice), maxTowerDPS = VALUES(maxTowerDPS), avgTowerDPS = VALUES(avgTowerDPS), mdps = VALUES(mdps), maxTowerKills = VALUES(maxTowerKills), totalKills = VALUES(totalKills), ups = VALUES(ups), totalDamage = VALUES(totalDamage), sumTowersPrice = VALUES(sumTowersPrice), dpsPerCoin = VALUES(dpsPerCoin), killsPerCoin = VALUES(killsPerCoin), totalDamagePerCoin = VALUES(totalDamagePerCoin);"); Gdx.files.local(this.benchmarkName + ".sql").writeString(stringBuilder.toString(), false, "UTF-8"); log((byte)1, "Saved results as " + this.benchmarkName + ".sql"); }  }  this.c.set(false); if (this.f != null) Threads.i().runOnMainThread(this.f);  }"TowerBenchmarkSim main")).setDaemon(true);
/* 418 */     thread.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 423 */     return this.c.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isReadyToStart() {
/* 428 */     return !isRunning();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSuccessful() {
/* 433 */     return (this.d == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void stop() {
/* 438 */     this.c.set(false);
/*     */   }
/*     */   
/*     */   public static final class TowerBenchmarkXpConfig {
/*     */     public int xpLevel;
/*     */     public int[] abilities;
/*     */     public String name;
/*     */     
/*     */     public TowerBenchmarkXpConfig(String param1String, int param1Int, int[] param1ArrayOfint) {
/* 447 */       this.name = param1String;
/* 448 */       this.xpLevel = param1Int;
/* 449 */       this.abilities = param1ArrayOfint;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class TowerBenchmarkResults
/*     */   {
/*     */     public String name;
/*     */     public int waveCount;
/*     */     public String extraTowers;
/*     */     public String tower;
/*     */     public String aimStrategy;
/*     */     public String abilities;
/*     */     public int upgradeLevel;
/*     */     public int xpLevel;
/*     */     public int towerPrice;
/*     */     public int minTowerDPS;
/*     */     public int maxTowerDPS;
/*     */     public int avgTowerDPS;
/*     */     public long mdps;
/*     */     public int minTowerKills;
/*     */     public int maxTowerKills;
/*     */     public int avgTowerKills;
/*     */     public int totalKills;
/*     */     public int ups;
/*     */     public double totalDamage;
/*     */     public int sumTowersPrice;
/*     */     
/*     */     public TowerBenchmarkResults(String param1String) {
/* 477 */       this.name = param1String;
/* 478 */       String[] arrayOfString = param1String.split("\\|");
/* 479 */       this.tower = arrayOfString[0];
/* 480 */       this.upgradeLevel = Integer.parseInt(arrayOfString[1]);
/* 481 */       this.aimStrategy = arrayOfString[2];
/* 482 */       this.xpLevel = Integer.parseInt(arrayOfString[3]);
/* 483 */       this.abilities = arrayOfString[4];
/* 484 */       this.waveCount = Integer.parseInt(arrayOfString[5]);
/* 485 */       this.extraTowers = arrayOfString[6];
/*     */     }
/*     */     
/*     */     public final void add(TowerBenchmarkResults param1TowerBenchmarkResults) {
/* 489 */       this.minTowerDPS += param1TowerBenchmarkResults.minTowerDPS;
/* 490 */       this.maxTowerDPS += param1TowerBenchmarkResults.maxTowerDPS;
/* 491 */       this.avgTowerDPS += param1TowerBenchmarkResults.avgTowerDPS;
/* 492 */       this.mdps += param1TowerBenchmarkResults.mdps;
/* 493 */       this.minTowerKills += param1TowerBenchmarkResults.minTowerKills;
/* 494 */       this.maxTowerKills += param1TowerBenchmarkResults.maxTowerKills;
/* 495 */       this.avgTowerKills += param1TowerBenchmarkResults.avgTowerKills;
/* 496 */       this.totalKills += param1TowerBenchmarkResults.totalKills;
/* 497 */       this.ups += param1TowerBenchmarkResults.ups;
/* 498 */       this.totalDamage += param1TowerBenchmarkResults.totalDamage;
/* 499 */       this.sumTowersPrice += param1TowerBenchmarkResults.sumTowersPrice;
/*     */     }
/*     */     
/*     */     public final void divideValues(int param1Int) {
/* 503 */       float f = 1.0F / param1Int;
/* 504 */       this.minTowerDPS = (int)(this.minTowerDPS * f);
/* 505 */       this.maxTowerDPS = (int)(this.maxTowerDPS * f);
/* 506 */       this.avgTowerDPS = (int)(this.avgTowerDPS * f);
/* 507 */       this.mdps = (long)((float)this.mdps * f);
/* 508 */       this.minTowerKills = (int)(this.minTowerKills * f);
/* 509 */       this.maxTowerKills = (int)(this.maxTowerKills * f);
/* 510 */       this.avgTowerKills = (int)(this.avgTowerKills * f);
/* 511 */       this.totalKills = (int)(this.totalKills * f);
/* 512 */       this.ups = (int)(this.ups * f);
/* 513 */       this.totalDamage *= f;
/* 514 */       this.sumTowersPrice = (int)(this.sumTowersPrice * f);
/*     */     }
/*     */     
/*     */     public final void toJson(Json param1Json) {
/* 518 */       param1Json.writeValue(this.name);
/* 519 */       param1Json.writeValue(Integer.valueOf(this.waveCount));
/* 520 */       param1Json.writeValue(this.extraTowers);
/* 521 */       param1Json.writeValue(this.tower);
/* 522 */       param1Json.writeValue(this.aimStrategy);
/* 523 */       param1Json.writeValue(this.abilities);
/* 524 */       param1Json.writeValue(Integer.valueOf(this.upgradeLevel));
/* 525 */       param1Json.writeValue(Integer.valueOf(this.xpLevel));
/* 526 */       param1Json.writeValue(Integer.valueOf(this.towerPrice));
/* 527 */       param1Json.writeValue(Integer.valueOf(this.minTowerDPS));
/* 528 */       param1Json.writeValue(Integer.valueOf(this.maxTowerDPS));
/* 529 */       param1Json.writeValue(Integer.valueOf(this.avgTowerDPS));
/* 530 */       param1Json.writeValue(Long.valueOf(this.mdps));
/* 531 */       param1Json.writeValue(Integer.valueOf(this.minTowerKills));
/* 532 */       param1Json.writeValue(Integer.valueOf(this.maxTowerKills));
/* 533 */       param1Json.writeValue(Integer.valueOf(this.avgTowerKills));
/* 534 */       param1Json.writeValue(Integer.valueOf(this.totalKills));
/* 535 */       param1Json.writeValue(Integer.valueOf(this.ups));
/* 536 */       param1Json.writeValue(Double.valueOf(this.totalDamage));
/* 537 */       param1Json.writeValue(Integer.valueOf(this.sumTowersPrice));
/*     */     }
/*     */     
/*     */     public static void writeFieldsToJson(Json param1Json) {
/* 541 */       param1Json.writeValue("name");
/* 542 */       param1Json.writeValue("waves");
/* 543 */       param1Json.writeValue("extraTowers");
/* 544 */       param1Json.writeValue("tower");
/* 545 */       param1Json.writeValue("aimStrategy");
/* 546 */       param1Json.writeValue("abilities");
/* 547 */       param1Json.writeValue("upgradeLevel");
/* 548 */       param1Json.writeValue("xpLevel");
/* 549 */       param1Json.writeValue("towerPrice");
/* 550 */       param1Json.writeValue("minTowerDPS");
/* 551 */       param1Json.writeValue("maxTowerDPS");
/* 552 */       param1Json.writeValue("avgTowerDPS");
/* 553 */       param1Json.writeValue("mdps");
/* 554 */       param1Json.writeValue("minTowerKills");
/* 555 */       param1Json.writeValue("maxTowerKills");
/* 556 */       param1Json.writeValue("avgTowerKills");
/* 557 */       param1Json.writeValue("totalKills");
/* 558 */       param1Json.writeValue("ups");
/* 559 */       param1Json.writeValue("totalDamage");
/* 560 */       param1Json.writeValue("sumTowersPrice");
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 565 */       return "Tower: " + this.tower + ", aimStrategy: " + this.aimStrategy + ", abilities: " + this.abilities + ", upgradeLevel: " + this.upgradeLevel + ", xpLevel: " + this.xpLevel + ", tower price: " + this.towerPrice;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\TowerBenchmarkSim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */