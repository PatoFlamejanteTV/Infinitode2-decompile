/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.GameValuesRecalculate;
/*     */ import com.prineside.tdi2.events.game.TileChange;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.tiles.BossTile;
/*     */ import com.prineside.tdi2.tiles.CoreTile;
/*     */ import com.prineside.tdi2.tiles.GameValueTile;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class GameValueSystem extends GameSystem implements KryoSerializable, GameValueProvider {
/*     */   @NAGS
/*     */   private GameValueManager.GameValuesSnapshot a;
/*     */   private GameValueManager.GameValuesSnapshot b;
/*     */   private int c;
/*     */   private float d;
/*     */   
/*     */   public GameValueSystem() {
/*  43 */     this.c = Config.GAME_STATE_UPDATE_RATE;
/*  44 */     this.d = 1.0F / Config.GAME_STATE_UPDATE_RATE;
/*     */     
/*  46 */     this.e = new Array(true, 1, GameValueConfig.class);
/*  47 */     this.f = new float[TowerStatType.values.length];
/*     */     
/*  49 */     Arrays.fill(this.f, 1.0F);
/*     */     
/*  51 */     this.g = new Array(true, TowerStatType.values.length, Array.class);
/*     */     
/*  53 */     for (byte b = 0; b < TowerStatType.values.length; b++) {
/*  54 */       this.g.add(new Array(true, 1, GlobalTowerStatMutator.class));
/*     */     }
/*     */ 
/*     */     
/*  58 */     this.h = new double[GameValueType.values.length];
/*     */   } private Array<GameValueConfig> e; private float[] f; private Array<Array<GlobalTowerStatMutator>> g; @NAGS
/*     */   private final double[] h;
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  62 */     super.write(paramKryo, paramOutput);
/*  63 */     paramKryo.writeObject(paramOutput, this.b);
/*  64 */     paramOutput.writeVarInt(this.c, true);
/*  65 */     paramOutput.writeFloat(this.d);
/*  66 */     paramKryo.writeObject(paramOutput, this.e);
/*  67 */     paramKryo.writeObject(paramOutput, this.f);
/*  68 */     paramKryo.writeObject(paramOutput, this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  73 */     super.read(paramKryo, paramInput);
/*  74 */     this.b = (GameValueManager.GameValuesSnapshot)paramKryo.readObject(paramInput, GameValueManager.GameValuesSnapshot.class);
/*  75 */     this.c = paramInput.readVarInt(true);
/*  76 */     this.d = paramInput.readFloat();
/*  77 */     this.e = (Array<GameValueConfig>)paramKryo.readObject(paramInput, Array.class);
/*  78 */     this.f = (float[])paramKryo.readObject(paramInput, float[].class);
/*  79 */     this.g = (Array<Array<GlobalTowerStatMutator>>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public final float getGlobalStatMultiplier(TowerStatType paramTowerStatType) {
/*  88 */     return this.f[paramTowerStatType.ordinal()];
/*     */   }
/*     */   
/*     */   public final boolean addGlobalTowerStatMutator(TowerStatType paramTowerStatType, GlobalTowerStatMutator paramGlobalTowerStatMutator) {
/*     */     Array array;
/*  93 */     if (!(array = (Array)this.g.get(paramTowerStatType.ordinal())).contains(paramGlobalTowerStatMutator, true)) {
/*  94 */       array.add(paramGlobalTowerStatMutator);
/*  95 */       recalculateGlobalTowerStatMultipliers();
/*  96 */       return true;
/*     */     } 
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean removeGlobalTowerStatMutator(TowerStatType paramTowerStatType, GlobalTowerStatMutator paramGlobalTowerStatMutator) {
/*     */     Array array;
/* 104 */     if ((array = (Array)this.g.get(paramTowerStatType.ordinal())).removeValue(paramGlobalTowerStatMutator, true)) {
/* 105 */       recalculateGlobalTowerStatMultipliers();
/* 106 */       return true;
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<GlobalTowerStatMutator> getGlobalTowerStatMutators(TowerStatType paramTowerStatType) {
/* 113 */     return (Array<GlobalTowerStatMutator>)this.g.get(paramTowerStatType.ordinal());
/*     */   }
/*     */   
/*     */   public final void recalculateGlobalTowerStatMultipliers() {
/* 117 */     this.S.gameState.checkGameplayUpdateAllowed();
/* 118 */     boolean bool = false; TowerStatType[] arrayOfTowerStatType; int i; byte b;
/* 119 */     for (i = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/* 120 */       Array array = (Array)this.g.get(towerStatType.ordinal());
/* 121 */       float f = 1.0F;
/* 122 */       for (byte b1 = 0; b1 < array.size; b1++) {
/* 123 */         f *= GlobalTowerStatMutator.a(((GlobalTowerStatMutator[])array.items)[b1]);
/*     */       }
/* 125 */       if (this.f[towerStatType.ordinal()] != f) {
/* 126 */         this.f[towerStatType.ordinal()] = f;
/* 127 */         bool = true;
/*     */       }  b++; }
/*     */     
/* 130 */     if (bool) {
/* 131 */       System.arraycopy(this.b.values, 0, this.h, 0, this.b.values.length);
/* 132 */       this.S.events.trigger((Event)new GameValuesRecalculate(this.h));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 144 */     this.b = new GameValueManager.GameValuesSnapshot();
/* 145 */     recalculate();
/*     */     
/* 147 */     this.S.events.getListeners(TileChange.class).addStateAffecting(new OnTileChange(this, (byte)0)).setDescription("GameValueSystem - recalculates values");
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 152 */     return "GameValue";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameValueManager.GameValuesSnapshot getGlobalSnapshot() {
/* 160 */     if (this.a == null) {
/* 161 */       TargetTile targetTile = this.S.map.getMap().getTargetTile(false);
/* 162 */       boolean bool = false;
/* 163 */       if (targetTile != null) {
/* 164 */         bool = targetTile.isUseStockGameValues();
/*     */       }
/*     */       
/* 167 */       if (this.S.CFG.setup == GameSystemProvider.SystemsConfig.Setup.MAP_EDITOR) {
/* 168 */         this.a = GameValueManager.createSnapshot(null, DifficultyMode.NORMAL, false, null, bool, true, Game.i.progressManager
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 175 */             .createProgressSnapshotForState());
/*     */       } else {
/*     */         
/* 178 */         this.a = GameValueManager.createSnapshot(null, this.S.gameState.difficultyMode, false, 
/*     */ 
/*     */ 
/*     */             
/* 182 */             (this.S.gameState.basicLevelName == null) ? null : Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName), bool, (this.S.gameState.userMapId != null), this.S.gameState.gameStartProgressSnapshot);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setGlobalSnapshot(@Null GameValueManager.GameValuesSnapshot paramGameValuesSnapshot) {
/* 198 */     this.a = paramGameValuesSnapshot;
/*     */   }
/*     */   
/*     */   public final GameValueManager.GameValuesSnapshot getSnapshot() {
/* 202 */     return this.b;
/*     */   }
/*     */   
/*     */   public final int getTickRate() {
/* 206 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float getTickRateDeltaTime() {
/* 210 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void recalculate() {
/* 220 */     System.arraycopy(this.b.values, 0, this.h, 0, this.b.values.length);
/*     */ 
/*     */     
/* 223 */     this.b.effects.clear();
/*     */     
/*     */     GameValueManager.GameValuesSnapshot gameValuesSnapshot;
/*     */     
/* 227 */     System.arraycopy((gameValuesSnapshot = getGlobalSnapshot()).values, 0, this.b.values, 0, this.b.values.length);
/*     */     
/* 229 */     for (byte b2 = 0; b2 < gameValuesSnapshot.effects.size; b2++) {
/*     */       GameValueManager.GameValueEffect gameValueEffect;
/* 231 */       (gameValueEffect = new GameValueManager.GameValueEffect()).from(((GameValueManager.GameValueEffect[])gameValuesSnapshot.effects.items)[b2]);
/* 232 */       this.b.effects.add(gameValueEffect);
/*     */     } 
/*     */ 
/*     */     
/*     */     TargetTile targetTile;
/*     */     
/* 238 */     if ((targetTile = this.S.map.getMap().getTargetTile(false)) != null) {
/*     */       
/* 240 */       Array array = targetTile.getGameValues();
/* 241 */       for (byte b = 0; b < array.size; b++) {
/*     */         GameValueConfig gameValueConfig;
/* 243 */         if (!(gameValueConfig = ((GameValueConfig[])array.items)[b]).isAllowBonuses()) {
/*     */ 
/*     */           
/* 246 */           this.b.effects.begin();
/* 247 */           for (byte b4 = 0; b4 < this.b.effects.size; b4++) {
/*     */             GameValueManager.GameValueEffect gameValueEffect;
/* 249 */             if ((gameValueEffect = (GameValueManager.GameValueEffect)this.b.effects.get(b4)).type == gameValueConfig.getType() && gameValueEffect.source != GameValueManager.GameValueEffect.Source.STOCK)
/*     */             {
/* 251 */               this.b.effects.removeIndex(b4);
/*     */             }
/*     */           } 
/* 254 */           this.b.effects.end();
/*     */ 
/*     */ 
/*     */           
/* 258 */           this.b.values[gameValueConfig.getType().ordinal()] = (Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).stockValue;
/*     */         } 
/*     */         
/* 261 */         if (!gameValueConfig.isOverwrite()) {
/*     */           
/* 263 */           this.b.values[gameValueConfig.getType().ordinal()] = this.b.values[gameValueConfig.getType().ordinal()] + gameValueConfig.getValue();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/*     */           
/* 267 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = gameValueConfig.getValue();
/* 268 */           gameValueEffect.type = gameValueConfig.getType();
/* 269 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.BASE_TILE;
/* 270 */           this.b.effects.add(gameValueEffect);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 275 */           this.b.effects.begin();
/* 276 */           for (byte b4 = 0; b4 < this.b.effects.size; b4++) {
/*     */             GameValueManager.GameValueEffect gameValueEffect1;
/* 278 */             if ((gameValueEffect1 = (GameValueManager.GameValueEffect)this.b.effects.get(b4)).type == gameValueConfig.getType()) {
/* 279 */               this.b.effects.removeIndex(b4);
/*     */             }
/*     */           } 
/* 282 */           this.b.effects.end();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/* 285 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = -this.b.values[gameValueConfig.getType().ordinal()] + gameValueConfig.getValue();
/* 286 */           gameValueEffect.type = gameValueConfig.getType();
/* 287 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.BASE_TILE;
/* 288 */           this.b.effects.add(gameValueEffect);
/*     */ 
/*     */           
/* 291 */           this.b.values[gameValueConfig.getType().ordinal()] = gameValueConfig.getValue();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     Array array2;
/*     */     
/* 298 */     if ((array2 = this.S.map.getMap().getTilesByType(BossTile.class)).size != 0) {
/* 299 */       Array array = ((BossTile)array2.first()).getGameValues();
/* 300 */       for (byte b = 0; b < array.size; b++) {
/* 301 */         GameValueConfig gameValueConfig = ((GameValueConfig[])array.items)[b];
/*     */         
/* 303 */         this.b.values[gameValueConfig.getType().ordinal()] = this.b.values[gameValueConfig.getType().ordinal()] + gameValueConfig.getValue();
/*     */         
/*     */         GameValueManager.GameValueEffect gameValueEffect;
/*     */         
/* 307 */         (gameValueEffect = new GameValueManager.GameValueEffect()).delta = gameValueConfig.getValue();
/* 308 */         gameValueEffect.type = gameValueConfig.getType();
/* 309 */         gameValueEffect.source = GameValueManager.GameValueEffect.Source.BOSS_TILE;
/* 310 */         this.b.effects.add(gameValueEffect);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 316 */     DelayedRemovalArray delayedRemovalArray = this.S.map.getMap().getAllTiles();
/* 317 */     for (byte b1 = 0; b1 < ((Array)delayedRemovalArray).size; b1++) {
/*     */       Tile tile; GameValueTile gameValueTile;
/* 319 */       if (tile = ((Tile[])((Array)delayedRemovalArray).items)[b1] instanceof GameValueTile && 
/*     */         
/* 321 */         !(gameValueTile = (GameValueTile)tile).isFinalMultiplier())
/*     */       {
/*     */         
/* 324 */         if (!gameValueTile.isOverwrite()) {
/*     */           
/* 326 */           this.b.values[gameValueTile.getGameValueType().ordinal()] = this.b.values[gameValueTile.getGameValueType().ordinal()] + gameValueTile.getDelta();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/*     */           
/* 330 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = gameValueTile.getDelta();
/* 331 */           gameValueEffect.type = gameValueTile.getGameValueType();
/* 332 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.GV_TILE;
/* 333 */           this.b.effects.add(gameValueEffect);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 338 */           this.b.effects.begin();
/* 339 */           for (byte b = 0; b < this.b.effects.size; b++) {
/*     */             GameValueManager.GameValueEffect gameValueEffect1;
/* 341 */             if ((gameValueEffect1 = (GameValueManager.GameValueEffect)this.b.effects.get(b)).type == gameValueTile.getGameValueType()) {
/* 342 */               this.b.effects.removeIndex(b);
/*     */             }
/*     */           } 
/* 345 */           this.b.effects.end();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/* 348 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = -this.b.values[gameValueTile.getGameValueType().ordinal()] + gameValueTile.getDelta();
/* 349 */           gameValueEffect.type = gameValueTile.getGameValueType();
/* 350 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.GV_TILE;
/* 351 */           this.b.effects.add(gameValueEffect);
/*     */ 
/*     */           
/* 354 */           this.b.values[gameValueTile.getGameValueType().ordinal()] = gameValueTile.getDelta();
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 360 */     Array array1 = this.S.map.getMap().getTilesByType(CoreTile.class); int i;
/* 361 */     for (i = 0; i < array1.size; i++) {
/*     */       CoreTile coreTile;
/*     */       
/* 364 */       Array array = (coreTile = ((CoreTile[])array1.items)[i]).getUpgrades();
/* 365 */       for (byte b = 0; b < array.size; b++) {
/* 366 */         CoreTile.Upgrade upgrade = ((CoreTile.Upgrade[])array.items)[b];
/* 367 */         int k = coreTile.getUpgradeInstallLevelByIdx(b);
/*     */         
/* 369 */         if (upgrade != null && !upgrade.isAction && k != 0) {
/* 370 */           CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[k - 1];
/* 371 */           this.b.values[upgrade.getGameValueType().ordinal()] = this.b.values[upgrade.getGameValueType().ordinal()] + upgradeLevel.delta;
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/*     */           
/* 375 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = upgradeLevel.delta;
/* 376 */           gameValueEffect.type = upgrade.getGameValueType();
/* 377 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.CORE_TILE;
/* 378 */           this.b.effects.add(gameValueEffect);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 384 */     for (i = 0; i < ((Array)delayedRemovalArray).size; i++) {
/*     */       Tile tile; GameValueTile gameValueTile;
/* 386 */       if (tile = ((Tile[])((Array)delayedRemovalArray).items)[i] instanceof GameValueTile && (
/*     */         
/* 388 */         gameValueTile = (GameValueTile)tile).isFinalMultiplier()) {
/*     */ 
/*     */ 
/*     */         
/* 392 */         double d1, d2 = (d1 = this.b.values[gameValueTile.getGameValueType().ordinal()]) * gameValueTile.getDelta();
/*     */         
/*     */         GameValueManager.GameValueEffect gameValueEffect;
/*     */         
/* 396 */         (gameValueEffect = new GameValueManager.GameValueEffect()).delta = d2 - d1;
/* 397 */         gameValueEffect.type = gameValueTile.getGameValueType();
/* 398 */         gameValueEffect.source = GameValueManager.GameValueEffect.Source.GV_TILE;
/* 399 */         this.b.effects.add(gameValueEffect);
/*     */ 
/*     */         
/* 402 */         this.b.values[gameValueTile.getGameValueType().ordinal()] = d2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 407 */     for (i = 0; i < this.e.size; i++) {
/*     */       GameValueConfig gameValueConfig;
/* 409 */       if (!(gameValueConfig = ((GameValueConfig[])this.e.items)[i]).isFinalGlobalMultiplier())
/*     */       {
/* 411 */         if (!gameValueConfig.isOverwrite()) {
/*     */           
/* 413 */           this.b.values[gameValueConfig.getType().ordinal()] = this.b.values[gameValueConfig.getType().ordinal()] + gameValueConfig.getValue();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/*     */           
/* 417 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = gameValueConfig.getValue();
/* 418 */           gameValueEffect.type = gameValueConfig.getType();
/* 419 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.CUSTOM;
/* 420 */           this.b.effects.add(gameValueEffect);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 425 */           this.b.effects.begin();
/* 426 */           for (byte b = 0; b < this.b.effects.size; b++) {
/*     */             GameValueManager.GameValueEffect gameValueEffect1;
/* 428 */             if ((gameValueEffect1 = (GameValueManager.GameValueEffect)this.b.effects.get(b)).type == gameValueConfig.getType()) {
/* 429 */               this.b.effects.removeIndex(b);
/*     */             }
/*     */           } 
/* 432 */           this.b.effects.end();
/*     */           
/*     */           GameValueManager.GameValueEffect gameValueEffect;
/* 435 */           (gameValueEffect = new GameValueManager.GameValueEffect()).delta = -this.b.values[gameValueConfig.getType().ordinal()] + gameValueConfig.getValue();
/* 436 */           gameValueEffect.type = gameValueConfig.getType();
/* 437 */           gameValueEffect.source = GameValueManager.GameValueEffect.Source.CUSTOM;
/* 438 */           this.b.effects.add(gameValueEffect);
/*     */ 
/*     */           
/* 441 */           this.b.values[gameValueConfig.getType().ordinal()] = gameValueConfig.getValue();
/*     */         }  } 
/*     */     } 
/* 444 */     for (i = 0; i < this.e.size; i++) {
/*     */       GameValueConfig gameValueConfig;
/* 446 */       if ((gameValueConfig = ((GameValueConfig[])this.e.items)[i]).isFinalGlobalMultiplier()) {
/*     */ 
/*     */ 
/*     */         
/* 450 */         double d1, d2 = (d1 = this.b.values[gameValueConfig.getType().ordinal()]) * gameValueConfig.getValue();
/*     */         
/*     */         GameValueManager.GameValueEffect gameValueEffect;
/*     */         
/* 454 */         (gameValueEffect = new GameValueManager.GameValueEffect()).delta = d2 - d1;
/* 455 */         gameValueEffect.type = gameValueConfig.getType();
/* 456 */         gameValueEffect.source = GameValueManager.GameValueEffect.Source.CUSTOM;
/* 457 */         this.b.effects.add(gameValueEffect);
/*     */ 
/*     */         
/* 460 */         this.b.values[gameValueConfig.getType().ordinal()] = d2;
/*     */       } 
/*     */     } 
/* 463 */     i = 1; double[] arrayOfDouble; int j; byte b3;
/* 464 */     for (j = (arrayOfDouble = this.b.values).length, b3 = 0; b3 < j; ) { double d = arrayOfDouble[b3];
/* 465 */       i = i * 31 + (int)(d * 10000.0D);
/*     */       b3++; }
/*     */     
/* 468 */     if (this.b.hash != i) {
/* 469 */       this.b.hash = i;
/*     */       
/* 471 */       this.c = MathUtils.round(getFloatValue(GameValueType.GAME_TICK_RATE));
/* 472 */       if (this.c < 10) this.c = 10; 
/* 473 */       if (this.c > 300) this.c = 300; 
/* 474 */       this.d = 1.0F / this.c;
/*     */ 
/*     */       
/* 477 */       this.S.events.trigger((Event)new GameValuesRecalculate(this.h));
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void addCustomGameValue(GameValueConfig paramGameValueConfig) {
/* 482 */     if (!this.e.contains(paramGameValueConfig, true)) {
/* 483 */       this.e.add(paramGameValueConfig);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeCustomGameValue(GameValueConfig paramGameValueConfig) {
/* 488 */     this.e.removeValue(paramGameValueConfig, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getValue(GameValueType paramGameValueType) {
/* 493 */     return this.b.getValue(paramGameValueType);
/*     */   }
/*     */   
/*     */   public final float getFloatValue(GameValueType paramGameValueType) {
/* 497 */     return this.b.getFloatValue(paramGameValueType);
/*     */   }
/*     */   
/*     */   public final boolean getBooleanValue(GameValueType paramGameValueType) {
/* 501 */     return this.b.getBooleanValue(paramGameValueType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIntValue(GameValueType paramGameValueType) {
/* 506 */     return this.b.getIntValue(paramGameValueType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIntValueSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2) {
/* 511 */     return this.b.getIntValueSum(paramGameValueType1, paramGameValueType2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getFloatValueSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2) {
/* 516 */     return this.b.getFloatValueSum(paramGameValueType1, paramGameValueType2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPercentValueAsMultiplier(GameValueType paramGameValueType) {
/* 521 */     return this.b.getPercentValueAsMultiplier(paramGameValueType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPercentValueAsMultiplierSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2) {
/* 526 */     return this.b.getPercentValueAsMultiplierSum(paramGameValueType1, paramGameValueType2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPercentValueAsMultiplierSumAll(GameValueType[] paramArrayOfGameValueType) {
/* 531 */     return this.b.getPercentValueAsMultiplierSumAll(paramArrayOfGameValueType);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnTileChange extends SerializableListener<GameValueSystem> implements Listener<TileChange> {
/*     */     private OnTileChange() {}
/*     */     
/*     */     private OnTileChange(GameValueSystem param1GameValueSystem) {
/* 539 */       this.a = param1GameValueSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(TileChange param1TileChange) {
/* 544 */       Tile tile2 = param1TileChange.getOldTile();
/* 545 */       Tile tile1 = param1TileChange.getNewTile();
/*     */       
/* 547 */       if (tile2 instanceof CoreTile || tile2 instanceof TargetTile || tile2 instanceof GameValueTile || tile1 instanceof CoreTile || tile1 instanceof TargetTile || tile1 instanceof GameValueTile)
/*     */       {
/* 549 */         ((GameValueSystem)this.a).recalculate();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class GlobalTowerStatMutator implements KryoSerializable {
/* 556 */     private float a = 1.0F;
/* 557 */     private String b = "";
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 561 */       param1Output.writeFloat(this.a);
/* 562 */       param1Output.writeString(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 567 */       this.a = param1Input.readFloat();
/* 568 */       this.b = param1Input.readString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GlobalTowerStatMutator(String param1String, float param1Float) {
/* 574 */       Preconditions.checkNotNull(param1String, "description can not be null");
/* 575 */       setMultiplier(param1Float);
/* 576 */       this.b = param1String;
/* 577 */       this.a = param1Float;
/*     */     }
/*     */     
/*     */     public final float getMultiplier() {
/* 581 */       return this.a;
/*     */     }
/*     */     
/*     */     public final void setMultiplier(float param1Float) {
/* 585 */       Preconditions.checkArgument((param1Float >= 0.0F && PMath.isFinite(param1Float)), "invalid multiplier: %s", Float.valueOf(param1Float));
/* 586 */       this.a = param1Float;
/*     */     }
/*     */     
/*     */     public final String getDescription() {
/* 590 */       return this.b;
/*     */     }
/*     */     
/*     */     private GlobalTowerStatMutator() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\GameValueSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */