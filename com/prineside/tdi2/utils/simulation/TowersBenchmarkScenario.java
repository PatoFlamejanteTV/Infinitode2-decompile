/*     */ package com.prineside.tdi2.utils.simulation;
/*     */ import com.prineside.tdi2.Tower;
/*     */ 
/*     */ public class TowersBenchmarkScenario implements Scenario {
/*     */   public GameSystemProvider S;
/*     */   public final int waves;
/*     */   public final TowerType towerType;
/*     */   public final Tower.AimStrategy aimStrategy;
/*     */   public final int[] abilities;
/*     */   public final float angle;
/*     */   public final int xpLevel;
/*     */   public final int upgradeLevel;
/*     */   public final ExtraTowers extraTowers;
/*     */   
/*     */   public enum ExtraTowers {
/*  16 */     NONE,
/*  17 */     FREEZING,
/*  18 */     BLAST,
/*  19 */     FREEZING_BLAST;
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
/*     */   public TowersBenchmarkScenario(int paramInt1, TowerType paramTowerType, int[] paramArrayOfint, Tower.AimStrategy paramAimStrategy, float paramFloat, int paramInt2, int paramInt3, ExtraTowers paramExtraTowers) {
/*  32 */     this.waves = paramInt1;
/*  33 */     this.towerType = paramTowerType;
/*  34 */     this.aimStrategy = paramAimStrategy;
/*  35 */     this.abilities = paramArrayOfint;
/*  36 */     this.angle = paramFloat;
/*  37 */     this.xpLevel = paramInt2;
/*  38 */     this.upgradeLevel = paramInt3;
/*  39 */     this.extraTowers = paramExtraTowers;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGSP(GameSystemProvider paramGameSystemProvider) {
/*  44 */     this.S = paramGameSystemProvider;
/*     */   }
/*     */ 
/*     */   
/*     */   public void start(GameSystemProvider paramGameSystemProvider) {
/*  49 */     this.S = paramGameSystemProvider;
/*  50 */     paramGameSystemProvider.wave.startNextWave();
/*     */ 
/*     */     
/*  53 */     paramGameSystemProvider.gameValue.addCustomGameValue(new GameValueConfig(GameValueType.TOWERS_STARTING_LEVEL, this.xpLevel, true, false));
/*  54 */     paramGameSystemProvider.gameValue.addCustomGameValue(new GameValueConfig(GameValueType.TOWERS_MAX_EXP_LEVEL, this.xpLevel, true, false));
/*  55 */     paramGameSystemProvider.gameValue.addCustomGameValue(new GameValueConfig(Game.i.towerManager.getMaxExpLevelGameValueType(this.towerType), 0.0D, true, false));
/*  56 */     paramGameSystemProvider.gameValue.recalculate();
/*     */ 
/*     */     
/*  59 */     Array array = paramGameSystemProvider.map.getMap().getTilesByType(PlatformTile.class);
/*  60 */     for (byte b = 0; b < array.size; b++) {
/*     */       Tower tower;
/*     */ 
/*     */       
/*     */       PlatformTile platformTile;
/*     */       
/*  66 */       if ((platformTile = (PlatformTile)array.get(b)).bonusLevel != 0) {
/*     */         
/*  68 */         if (platformTile.bonusType == SpaceTileBonusType.BONUS_EXPERIENCE && (this.extraTowers == ExtraTowers.FREEZING || this.extraTowers == ExtraTowers.FREEZING_BLAST)) {
/*     */           
/*  70 */           tower = paramGameSystemProvider.tower.buildTower(TowerType.FREEZING, Tower.AimStrategy.FIRST, platformTile.getX(), platformTile.getY()); byte b1;
/*  71 */           for (b1 = 0; b1 < 6; b1++) {
/*  72 */             paramGameSystemProvider.tower.setAbilityInstalled(tower, b1, true);
/*     */           }
/*  74 */           for (b1 = 0; b1 < 10; b1++) {
/*  75 */             paramGameSystemProvider.tower.upgradeTower(tower);
/*     */           }
/*  77 */           tower.moneySpentOn = 0;
/*  78 */         } else if (((PlatformTile)tower).bonusType == SpaceTileBonusType.SELL_REFUND && (this.extraTowers == ExtraTowers.BLAST || this.extraTowers == ExtraTowers.FREEZING_BLAST)) {
/*     */           
/*  80 */           tower = paramGameSystemProvider.tower.buildTower(TowerType.BLAST, Tower.AimStrategy.FIRST, tower.getX(), tower.getY()); byte b1;
/*  81 */           for (b1 = 0; b1 < 6; b1++) {
/*  82 */             paramGameSystemProvider.tower.setAbilityInstalled(tower, b1, true);
/*     */           }
/*  84 */           for (b1 = 0; b1 < 10; b1++) {
/*  85 */             paramGameSystemProvider.tower.upgradeTower(tower);
/*     */           }
/*  87 */           tower.moneySpentOn = 0;
/*     */         }
/*     */       
/*  90 */       } else if (((PlatformTile)tower).building == null) {
/*  91 */         tower = paramGameSystemProvider.tower.buildTower(this.towerType, this.aimStrategy, tower.getX(), tower.getY());
/*  92 */         if (this.towerType == TowerType.GAUSS) {
/*  93 */           ((GaussTower)tower).setTargetAngle(this.angle);
/*     */         }
/*  95 */         tower.angle = this.angle; int arrayOfInt[], i; byte b2;
/*  96 */         for (i = (arrayOfInt = this.abilities).length, b2 = 0; b2 < i; ) { int j = arrayOfInt[b2];
/*  97 */           paramGameSystemProvider.tower.setAbilityInstalled(tower, j, true); b2++; }
/*     */         
/*  99 */         for (byte b1 = 0; b1 < this.upgradeLevel; b1++) {
/* 100 */           paramGameSystemProvider.tower.upgradeTower(tower);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFinished() {
/* 109 */     return (this.S.wave.getCompletedWavesCount() >= this.waves);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getProgress() {
/* 114 */     return this.S.wave.getCompletedWavesCount() / this.waves;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public TowersBenchmarkScenario cpy() {
/* 124 */     return new TowersBenchmarkScenario(this.waves, this.towerType, this.abilities, this.aimStrategy, this.angle, this.xpLevel, this.upgradeLevel, this.extraTowers);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\TowersBenchmarkScenario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */