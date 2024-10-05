/*    */ package com.prineside.tdi2.utils.simulation;
/*    */ 
/*    */ import com.prineside.tdi2.BasicLevel;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.UserMap;
/*    */ import com.prineside.tdi2.enums.DifficultyMode;
/*    */ import com.prineside.tdi2.managers.ProgressManager;
/*    */ import com.prineside.tdi2.screens.GameScreen;
/*    */ import com.prineside.tdi2.systems.GameStateSystem;
/*    */ 
/*    */ public final class SimConfig {
/* 13 */   public DifficultyMode difficultyMode = DifficultyMode.NORMAL;
/* 14 */   public int difficultyModeMultiplier = 100;
/* 15 */   public GameStateSystem.GameMode gameMode = GameStateSystem.GameMode.BASIC_LEVELS;
/* 16 */   public String basicLevelName = "1.1";
/* 17 */   public String userMapName = "test";
/*    */   public boolean lootBoost;
/*    */   public boolean rarityBoost;
/*    */   public long startTimestamp;
/*    */   
/*    */   public final String getShortDescription() {
/* 23 */     return this.gameMode + " / " + this.difficultyMode + " / " + ((this.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) ? this.basicLevelName : this.userMapName);
/*    */   }
/*    */   
/*    */   public final SimConfig cpy() {
/*    */     SimConfig simConfig;
/* 28 */     (simConfig = new SimConfig()).difficultyMode = this.difficultyMode;
/* 29 */     simConfig.difficultyModeMultiplier = this.difficultyModeMultiplier;
/* 30 */     simConfig.gameMode = this.gameMode;
/* 31 */     simConfig.basicLevelName = this.basicLevelName;
/* 32 */     simConfig.userMapName = this.userMapName;
/* 33 */     simConfig.lootBoost = this.lootBoost;
/* 34 */     simConfig.rarityBoost = this.rarityBoost;
/* 35 */     simConfig.startTimestamp = this.startTimestamp;
/*    */     
/* 37 */     return simConfig;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GameSystemProvider createProgressSnapshotAndInitGSP(SimConfig paramSimConfig) {
/* 44 */     return initGSP(paramSimConfig, Game.i.progressManager.createProgressSnapshotForState());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GameSystemProvider initGSP(SimConfig paramSimConfig, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState) {
/* 51 */     GameSystemProvider.SystemsConfig systemsConfig = new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, true);
/*    */     GameSystemProvider gameSystemProvider;
/* 53 */     (gameSystemProvider = new GameSystemProvider(systemsConfig)).createSystems();
/*    */     
/* 55 */     BasicLevel basicLevel = null;
/* 56 */     UserMap userMap = null;
/* 57 */     if (paramSimConfig.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*    */       
/* 59 */       if ((basicLevel = Game.i.basicLevelManager.getLevel(paramSimConfig.basicLevelName)) == null) {
/* 60 */         throw new IllegalArgumentException("Basic level '" + paramSimConfig.basicLevelName + "' not exists");
/*    */       }
/*    */     } else {
/* 63 */       userMap = Game.i.userMapManager.getUserMap(paramSimConfig.userMapName);
/*    */     } 
/*    */     
/* 66 */     GameScreen.configureSystemsBeforeSetup(gameSystemProvider, null, true, paramSimConfig.lootBoost, paramSimConfig.rarityBoost, paramSimConfig.startTimestamp, basicLevel, userMap, paramSimConfig.difficultyMode, paramSimConfig.difficultyModeMultiplier, paramSimConfig.gameMode, 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 78 */         (userMap == null) ? null : Game.i.userMapManager.getDefaultBosses(), paramProgressSnapshotForState, Game.i.progressManager
/*    */         
/* 80 */         .getInventoryStatistics(), null);
/*    */ 
/*    */ 
/*    */     
/* 84 */     gameSystemProvider.setupSystems();
/* 85 */     gameSystemProvider.postSetupSystems();
/*    */     
/* 87 */     return gameSystemProvider;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\SimConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */