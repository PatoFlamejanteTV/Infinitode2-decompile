/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.Resource;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.actions.BuildMinerAction;
/*     */ import com.prineside.tdi2.actions.GlobalUpgradeMinerAction;
/*     */ import com.prineside.tdi2.actions.SellMinerAction;
/*     */ import com.prineside.tdi2.actions.UpgradeMinerAction;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.MinerBuild;
/*     */ import com.prineside.tdi2.events.game.MinerRemove;
/*     */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*     */ import com.prineside.tdi2.events.game.MinerSell;
/*     */ import com.prineside.tdi2.events.game.MinerUpgrade;
/*     */ import com.prineside.tdi2.events.game.NextWaveForce;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class MinerSystem extends GameSystem {
/*  53 */   private static final TLog a = TLog.forClass(MinerSystem.class);
/*     */ 
/*     */   
/*  56 */   private static final GameValueType[] b = new GameValueType[] { GameValueType.MINER_COUNT_SCALAR, GameValueType.MINER_COUNT_VECTOR, GameValueType.MINER_COUNT_MATRIX, GameValueType.MINER_COUNT_TENSOR, GameValueType.MINER_COUNT_INFIAR };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private static final float[] c = new float[] { 1.0F, 1.2F, 1.5F, 1.9F, 2.4F, 3.0F, 3.6F, 4.2F, 4.9F, 5.6F, 6.5F };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private int d = 1;
/*  72 */   public DelayedRemovalArray<Miner> miners = new DelayedRemovalArray(false, 8, Miner.class);
/*  73 */   private int[] e = new int[MinerType.values.length];
/*  74 */   public float bonusDoubleMiningSpeedTimeLeft = 0.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   @NAGS
/*  79 */   private final float[][] f = new float[ResourceType.values.length][3]; @NAGS
/*  80 */   private final Array<Sprite>[] g = (Array<Sprite>[])new Array[ResourceType.values.length];
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  84 */     super.write(paramKryo, paramOutput);
/*  85 */     paramOutput.writeVarInt(this.d, true);
/*  86 */     paramKryo.writeObject(paramOutput, this.miners);
/*  87 */     paramKryo.writeObject(paramOutput, this.e);
/*  88 */     paramOutput.writeFloat(this.bonusDoubleMiningSpeedTimeLeft);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  95 */     super.read(paramKryo, paramInput);
/*  96 */     this.d = paramInput.readVarInt(true);
/*  97 */     this.miners = (DelayedRemovalArray<Miner>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  98 */     this.e = (int[])paramKryo.readObject(paramInput, int[].class);
/*  99 */     this.bonusDoubleMiningSpeedTimeLeft = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 111 */     this.S.events.getListeners(NextWaveForce.class).addStateAffecting(new OnNextWaveForce(this, (byte)0));
/* 112 */     this.S.events.getListeners(MinerRemove.class).addStateAffecting(new OnMinerRemove(this, (byte)0)).setDescription("MinerSystem - unregisters the miner");
/*     */ 
/*     */     
/* 115 */     if (!this.S.CFG.headless) a();
/*     */   
/*     */   }
/*     */   
/*     */   public final void postStateRestore() {
/* 120 */     a();
/*     */   }
/*     */   
/*     */   public final float getBonusDoubleMiningSpeedTimeLeft() {
/* 124 */     return this.bonusDoubleMiningSpeedTimeLeft;
/*     */   }
/*     */   
/*     */   public final boolean isRegistered(Tower paramTower) {
/* 128 */     return paramTower.isRegistered();
/*     */   }
/*     */   
/*     */   public final void register(Miner paramMiner) {
/* 132 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 134 */     if (paramMiner.isRegistered()) throw new IllegalStateException("Miner is already registered");
/*     */     
/* 136 */     this.e[paramMiner.type.ordinal()] = this.e[paramMiner.type.ordinal()] + 1;
/* 137 */     paramMiner.id = this.d++;
/* 138 */     paramMiner.setRegistered(this.S);
/* 139 */     this.miners.add(paramMiner);
/*     */   }
/*     */   
/*     */   public final void unregister(Miner paramMiner) {
/* 143 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 145 */     if (!paramMiner.isRegistered()) throw new IllegalArgumentException("Miner is not registered");
/*     */     
/* 147 */     if (paramMiner.doubleSpeedParticle != null) {
/* 148 */       paramMiner.doubleSpeedParticle.allowCompletion();
/* 149 */       paramMiner.doubleSpeedParticle = null;
/*     */     } 
/*     */     
/* 152 */     this.e[paramMiner.type.ordinal()] = this.e[paramMiner.type.ordinal()] - 1;
/* 153 */     paramMiner.setUnregistered();
/* 154 */     this.miners.removeValue(paramMiner, true);
/*     */   }
/*     */   
/*     */   private void a() {
/* 158 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MINER_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatch(paramBatch, this.S.map.getMap(), paramFloat2, this.S._mapRendering.getDrawMode())))
/*     */ 
/*     */         
/* 161 */         .setName("Miner-drawBatch"));
/*     */   }
/*     */   
/*     */   public final void addResources(Miner paramMiner, ResourceType paramResourceType, int paramInt, boolean paramBoolean) {
/* 165 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 167 */     MinerResourceChange minerResourceChange = new MinerResourceChange(paramMiner, paramResourceType, paramInt, paramBoolean);
/* 168 */     this.S.events.trigger((Event)minerResourceChange);
/*     */     
/* 170 */     if (minerResourceChange.isCancelled())
/*     */       return; 
/* 172 */     paramResourceType = minerResourceChange.getResourceType();
/* 173 */     paramInt = minerResourceChange.getDelta();
/*     */     
/*     */     Miner miner;
/* 176 */     int i = (miner = minerResourceChange.getMiner()).getTile().getResourcesCount(paramResourceType);
/* 177 */     int j = Integer.MAX_VALUE - miner.minedResources[paramResourceType.ordinal()];
/* 178 */     if (this.S.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/* 179 */       j = i - (miner.getTile()).minedResources[paramResourceType.ordinal()];
/*     */     }
/* 181 */     miner.minedResources[paramResourceType.ordinal()] = miner.minedResources[paramResourceType.ordinal()] + paramInt;
/* 182 */     (miner.getTile()).minedResources[paramResourceType.ordinal()] = (miner.getTile()).minedResources[paramResourceType.ordinal()] + paramInt;
/*     */     
/* 184 */     if (j > 0) {
/* 185 */       this.S.gameState.addResources(paramResourceType, Math.min(j, paramInt));
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean removeResources(Miner paramMiner, ResourceType paramResourceType, int paramInt) {
/* 190 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 192 */     if (paramInt == 0) {
/* 193 */       throw new IllegalArgumentException("Amount can not be 0");
/*     */     }
/*     */     
/* 196 */     if (paramMiner.minedResources[paramResourceType.ordinal()] >= paramInt) {
/* 197 */       MinerResourceChange minerResourceChange = new MinerResourceChange(paramMiner, paramResourceType, -paramInt, false);
/* 198 */       this.S.events.trigger((Event)minerResourceChange);
/*     */       
/* 200 */       if (minerResourceChange.isCancelled()) {
/* 201 */         return false;
/*     */       }
/*     */       
/* 204 */       paramMiner = minerResourceChange.getMiner();
/* 205 */       paramResourceType = minerResourceChange.getResourceType();
/* 206 */       int i = -minerResourceChange.getDelta();
/*     */       
/* 208 */       int j = paramMiner.getTile().getResourcesCount(paramResourceType);
/* 209 */       int k = 0;
/* 210 */       if (this.S.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS && (
/*     */         
/* 212 */         k = (paramMiner.getTile()).minedResources[paramResourceType.ordinal()] - j) < 0) k = 0;
/*     */ 
/*     */ 
/*     */       
/* 216 */       if ((j = i - k) > 0) {
/* 217 */         this.S.gameState.removeResources(paramResourceType, j);
/*     */       }
/*     */       
/* 220 */       paramMiner.minedResources[paramResourceType.ordinal()] = paramMiner.minedResources[paramResourceType.ordinal()] - i;
/* 221 */       (paramMiner.getTile()).minedResources[paramResourceType.ordinal()] = (paramMiner.getTile()).minedResources[paramResourceType.ordinal()] - i;
/*     */       
/* 223 */       return true;
/*     */     } 
/* 225 */     return false;
/*     */   }
/*     */   
/*     */   public final int getMaxUpgradeLevel(MinerType paramMinerType) {
/* 229 */     int i = this.S.gameValue.getIntValue(GameValueType.MINERS_MAX_UPGRADE_LEVEL);
/* 230 */     switch (null.a[paramMinerType.ordinal()]) { case 1:
/* 231 */         i += this.S.gameValue.getIntValue(GameValueType.MINER_SCALAR_MAX_UPGRADE_LEVEL); break;
/* 232 */       case 2: i += this.S.gameValue.getIntValue(GameValueType.MINER_VECTOR_MAX_UPGRADE_LEVEL); break;
/* 233 */       case 3: i += this.S.gameValue.getIntValue(GameValueType.MINER_MATRIX_MAX_UPGRADE_LEVEL); break;
/* 234 */       case 4: i += this.S.gameValue.getIntValue(GameValueType.MINER_TENSOR_MAX_UPGRADE_LEVEL); break;
/* 235 */       case 5: i += this.S.gameValue.getIntValue(GameValueType.MINER_INFIAR_MAX_UPGRADE_LEVEL);
/*     */         break; }
/*     */     
/* 238 */     return Math.min(i, 10);
/*     */   }
/*     */   
/*     */   public final int getGlobalUpgradePrice(MinerType paramMinerType) {
/* 242 */     int i = 0;
/* 243 */     for (byte b = 0; b < this.miners.size; b++) {
/*     */       Miner miner;
/* 245 */       if ((miner = ((Miner[])this.miners.items)[b]).type == paramMinerType && 
/* 246 */         miner.getUpgradeLevel() < getMaxUpgradeLevel(miner.type)) {
/* 247 */         int j = miner.getUpgradeLevel() + 1;
/*     */         
/* 249 */         float f = 1.0F;
/* 250 */         for (byte b1 = 0; b1 < this.miners.size; b1++) {
/*     */           Miner miner1;
/* 252 */           if ((miner1 = ((Miner[])this.miners.items)[b1]).type == paramMinerType) {
/* 253 */             int k = miner1.getUpgradeLevel();
/* 254 */             if (b1 < b && k < getMaxUpgradeLevel(miner1.type)) {
/* 255 */               k++;
/*     */             }
/*     */             
/* 258 */             if (k >= j) {
/* 259 */               f *= 1.25F;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 264 */         i += (int)(miner.getBaseUpgradePrice(j) * f);
/*     */       } 
/*     */     } 
/* 267 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMaxMinersCount(MinerType paramMinerType) {
/* 274 */     return this.S.gameValue.getIntValue(b[paramMinerType.ordinal()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(MinerType paramMinerType) {
/* 281 */     return this.e[paramMinerType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getBuildableMinersCount(MinerType paramMinerType) {
/* 288 */     return Math.max(0, getMaxMinersCount(paramMinerType) - this.e[paramMinerType.ordinal()]);
/*     */   }
/*     */   
/*     */   public final int getBuildPrice(MinerType paramMinerType) {
/* 292 */     return (int)(Game.i.minerManager.getFactory(paramMinerType).getBaseBuildPrice(this.S.gameValue) * StrictMath.pow(1.600000023841858D, a(paramMinerType)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getUpgradePrice(Miner paramMiner) {
/*     */     int i;
/* 298 */     if ((i = paramMiner.getUpgradeLevel() + 1) > getMaxUpgradeLevel(paramMiner.type)) {
/* 299 */       return 0;
/*     */     }
/*     */     
/* 302 */     float f = 1.0F;
/*     */     
/* 304 */     for (byte b = 0; b < this.miners.size; b++) {
/* 305 */       if (((Miner)this.miners.get(b)).type == paramMiner.type && ((Miner)this.miners.get(b)).getUpgradeLevel() >= i) {
/* 306 */         f *= 1.25F;
/*     */       }
/*     */     } 
/*     */     
/* 310 */     return (int)(paramMiner.getBaseUpgradePrice(i) * f);
/*     */   }
/*     */   
/*     */   public final void upgradeMinerAction(Miner paramMiner) {
/* 314 */     upgradeMinerActionAt(paramMiner.getTile().getX(), paramMiner.getTile().getY());
/*     */   }
/*     */   public final void upgradeMinerActionAt(int paramInt1, int paramInt2) {
/*     */     Tile tile;
/*     */     SourceTile sourceTile;
/* 319 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null && 
/* 320 */       tile.type == TileType.SOURCE && 
/*     */       
/* 322 */       (sourceTile = (SourceTile)tile).miner != null) {
/*     */       Miner miner;
/* 324 */       if ((miner = sourceTile.miner).getUpgradeLevel() >= getMaxUpgradeLevel(miner.type)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 329 */       int i = getUpgradePrice(miner);
/* 330 */       if (this.S.gameState.getMoney() >= i) {
/* 331 */         this.S.gameState.pushActionNextUpdate((Action)new UpgradeMinerAction(paramInt1, paramInt2));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void globalUpgradeMinerAction(MinerType paramMinerType) {
/* 339 */     this.S.gameState.pushActionNextUpdate((Action)new GlobalUpgradeMinerAction(paramMinerType));
/*     */   }
/*     */   
/*     */   public final boolean upgradeMiner(Miner paramMiner) {
/* 343 */     return upgradeMinerAt(paramMiner.getTile().getX(), paramMiner.getTile().getY());
/*     */   }
/*     */   
/*     */   public final boolean upgradeMinerAt(int paramInt1, int paramInt2) {
/* 347 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/*     */     Tile tile;
/* 350 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null) {
/* 351 */       Miner miner; if (tile.type == TileType.SOURCE) {
/*     */         SourceTile sourceTile;
/* 353 */         if ((sourceTile = (SourceTile)tile).miner != null) {
/*     */           
/* 355 */           if ((miner = sourceTile.miner).getUpgradeLevel() >= getMaxUpgradeLevel(miner.type)) {
/* 356 */             a.e("can't upgrade miner, it is already fully upgraded", new Object[0]);
/* 357 */             return false;
/*     */           } 
/*     */           
/* 360 */           paramInt2 = getUpgradePrice(miner);
/* 361 */           if (this.S.gameState.removeMoney(paramInt2)) {
/* 362 */             miner.moneySpentOn += paramInt2;
/* 363 */             miner.setUpgradeLevel(miner.getUpgradeLevel() + 1);
/*     */ 
/*     */             
/* 366 */             if (miner.nextMinedResourceType != null) {
/* 367 */               float f1 = getMiningSpeed(miner, miner.getUpgradeLevel() - 1);
/* 368 */               float f2 = getMiningSpeed(miner, miner.getUpgradeLevel());
/* 369 */               miner.miningTime *= f1 / f2;
/*     */             } 
/*     */             
/* 372 */             this.S.events.trigger((Event)new MinerUpgrade(miner, paramInt2));
/* 373 */             return true;
/*     */           } 
/* 375 */           a.e("not enough money to upgrade the miner", new Object[0]);
/* 376 */           return false;
/*     */         } 
/*     */         
/* 379 */         a.e("upgradeMiner - no miner on tile", new Object[0]);
/* 380 */         return false;
/*     */       } 
/*     */       
/* 383 */       a.e("upgradeMiner - tile is " + ((Tile)miner).type.name(), new Object[0]);
/* 384 */       return false;
/*     */     } 
/*     */     
/* 387 */     a.e("upgradeMiner - tile is null", new Object[0]);
/* 388 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void buildMinerActionForSelectedTile(MinerType paramMinerType) {
/*     */     Tile tile;
/* 397 */     if ((tile = this.S._gameMapSelection.getSelectedTile()) != null)
/*     */     {
/* 399 */       if (tile.type == TileType.SOURCE)
/*     */       {
/* 401 */         if (((SourceTile)tile).miner == null) {
/* 402 */           buildMinerActionAt(paramMinerType, tile.getX(), tile.getY());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void buildMinerActionAt(MinerType paramMinerType, int paramInt1, int paramInt2) {
/* 409 */     if (this.e[paramMinerType.ordinal()] + 1 > getMaxMinersCount(paramMinerType)) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Tile tile;
/*     */     
/* 415 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null && 
/* 416 */       tile.type == TileType.SOURCE) {
/*     */       SourceTile sourceTile;
/*     */       
/* 419 */       if ((sourceTile = (SourceTile)tile).miner == null) {
/*     */         
/* 421 */         int i = getBuildPrice(paramMinerType);
/* 422 */         if (this.S.gameState.getMoney() >= i) {
/* 423 */           this.S.gameState.pushActionNextUpdate((Action)new BuildMinerAction(paramMinerType, paramInt1, paramInt2));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public final Miner buildMiner(MinerType paramMinerType, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 431 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 433 */     if (paramBoolean1 && 
/* 434 */       this.e[paramMinerType.ordinal()] + 1 > getMaxMinersCount(paramMinerType)) {
/* 435 */       a.e("No more miners of type " + paramMinerType.name() + " can be built", new Object[0]);
/* 436 */       return null;
/*     */     } 
/*     */     
/*     */     Tile tile;
/*     */     
/* 441 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null) {
/*     */       
/* 443 */       if (tile.type == TileType.SOURCE) {
/*     */         SourceTile sourceTile;
/*     */         
/* 446 */         if ((sourceTile = (SourceTile)tile).miner == null) {
/*     */           int i;
/* 448 */           Miner miner = Game.i.minerManager.getFactory(paramMinerType).create();
/* 449 */           paramBoolean1 = false;
/* 450 */           if (paramBoolean2) {
/* 451 */             i = getBuildPrice(paramMinerType);
/*     */           }
/*     */           
/* 454 */           if (this.S.gameState.removeMoney(i)) {
/*     */             
/* 456 */             register(miner);
/* 457 */             miner.setInstallTime(miner.getInstallDuration());
/* 458 */             miner.moneySpentOn = i;
/* 459 */             this.S.map.setMiner(tile.getX(), tile.getY(), miner);
/*     */             
/* 461 */             this.S.map.updateDirtyTiles();
/*     */             
/* 463 */             this.S.events.trigger((Event)new MinerBuild(miner, i));
/*     */ 
/*     */             
/* 466 */             if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */               ParticleEffectPool.PooledEffect pooledEffect;
/* 468 */               (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.minerManager.highlightParticles[miner.type.ordinal()].obtain()).setPosition((miner.getTile()).center.x, (miner.getTile()).center.y);
/* 469 */               this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */             } 
/* 471 */             return miner;
/*     */           } 
/* 473 */           a.e("not enough money to build a miner", new Object[0]);
/*     */         } else {
/*     */           
/* 476 */           a.e("trying to build miner on tile which already has a miner", new Object[0]);
/*     */         } 
/*     */       } else {
/* 479 */         a.e("buildMiner - tile type is " + tile.type.name(), new Object[0]);
/*     */       } 
/*     */     } else {
/* 482 */       a.e("buildMiner - tile is null", new Object[0]);
/*     */     } 
/* 484 */     return null;
/*     */   }
/*     */   
/*     */   public final void sellMinerAction(Miner paramMiner) {
/* 488 */     sellMinerActionAt(paramMiner.getTile().getX(), paramMiner.getTile().getY());
/*     */   }
/*     */   
/*     */   public final void sellMinerActionAt(int paramInt1, int paramInt2) {
/* 492 */     this.S.gameState.pushActionNextUpdate((Action)new SellMinerAction(paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public final boolean sellMiner(int paramInt1, int paramInt2) {
/* 496 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/*     */     Tile tile;
/* 499 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null) {
/* 500 */       Miner miner; if (tile.type == TileType.SOURCE) {
/*     */         
/* 502 */         if ((miner = ((SourceTile)tile).miner) != null) {
/* 503 */           paramInt2 = miner.getSellPrice();
/* 504 */           this.S.gameState.addMoney(paramInt2, false);
/* 505 */           this.S.map.removeMiner(miner);
/*     */ 
/*     */           
/* 508 */           this.S.events.trigger((Event)new MinerSell(miner, paramInt2));
/* 509 */           return true;
/*     */         } 
/* 511 */         a.e("sellMiner - miner is not on tile", new Object[0]);
/* 512 */         return false;
/*     */       } 
/*     */       
/* 515 */       a.e("sellMiner - tile is " + ((Tile)miner).type.name(), new Object[0]);
/* 516 */       return false;
/*     */     } 
/*     */     
/* 519 */     a.e("sellMiner - tile is null", new Object[0]);
/* 520 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getResourceMinedRawScore(ResourceType paramResourceType) {
/* 525 */     return 10 + paramResourceType.ordinal() * 5;
/*     */   }
/*     */   
/*     */   public final float calculateScorePerMinute(Miner paramMiner) {
/*     */     SourceTile sourceTile;
/* 530 */     if ((sourceTile = paramMiner.getTile()) == null) return 0.0F;
/*     */     
/* 532 */     Miner.Factory factory = Game.i.minerManager.getFactory(paramMiner.type);
/*     */     
/* 534 */     int i = 0; ResourceType[] arrayOfResourceType1; int j; byte b1;
/* 535 */     for (j = (arrayOfResourceType1 = ResourceType.values).length, b1 = 0; b1 < j; ) { ResourceType resourceType = arrayOfResourceType1[b1];
/* 536 */       if (factory.canMineResource(resourceType))
/*     */       {
/*     */         
/* 539 */         i += sourceTile.getResourcesCount(resourceType); }  b1++; }
/*     */     
/* 541 */     if (i == 0) {
/* 542 */       return 0.0F;
/*     */     }
/*     */     
/* 545 */     float f1 = getMiningSpeed(paramMiner, paramMiner.getUpgradeLevel()) * 60.0F;
/* 546 */     float f2 = 0.0F; ResourceType[] arrayOfResourceType2; int k; byte b2;
/* 547 */     for (k = (arrayOfResourceType2 = ResourceType.values).length, b2 = 0; b2 < k; ) { ResourceType resourceType = arrayOfResourceType2[b2];
/* 548 */       if (factory.canMineResource(resourceType)) {
/*     */ 
/*     */         
/* 551 */         float f = sourceTile.getResourcesCount(resourceType) / i;
/* 552 */         int m = (int)this.S.gameState.calculateFinalScore(getResourceMinedRawScore(resourceType), StatisticsType.SG_RM);
/* 553 */         f2 += f1 * m * f;
/*     */       }  b2++; }
/*     */     
/* 556 */     if (sourceTile.getResourceDensity() < 1.0F) {
/* 557 */       f2 *= sourceTile.getResourceDensity();
/*     */     }
/* 559 */     if (paramMiner.doubleSpeedTimeLeft > 0.0F) {
/* 560 */       f2 *= 2.0F;
/*     */     }
/*     */     
/* 563 */     return f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getBaseMiningSpeed(Miner paramMiner, int paramInt) {
/* 570 */     return Game.i.minerManager.getFactory(paramMiner.type).getBaseMiningSpeed(this.S.gameValue) * c[paramInt] / 60.0F;
/*     */   }
/*     */   
/*     */   public final int getMiningSpeedModifierCount(Miner paramMiner) {
/* 574 */     byte b1 = 0;
/* 575 */     for (byte b2 = 0; b2 < paramMiner.nearbyModifiers.size; b2++) {
/*     */       Modifier modifier;
/* 577 */       if ((modifier = (Modifier)paramMiner.nearbyModifiers.get(b2)).type == ModifierType.MINING_SPEED) {
/* 578 */         b1++;
/*     */       }
/*     */     } 
/* 581 */     return b1;
/*     */   }
/*     */   
/* 584 */   private static final float[] h = new float[8];
/*     */   static {
/* 586 */     for (byte b = 0; b < h.length; b++) {
/* 587 */       h[b] = (float)StrictMath.pow((b + 1), 0.63092975357D);
/*     */     }
/*     */   }
/*     */   
/*     */   public final float getMiningSpeedModifierEfficiencyPerCount(int paramInt) {
/* 592 */     if (paramInt <= h.length) {
/* 593 */       return h[paramInt - 1];
/*     */     }
/* 595 */     return (float)StrictMath.pow(paramInt, 0.63092975357D);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getMiningSpeedModifierMultiplier(Miner paramMiner) {
/*     */     int i;
/* 601 */     if ((i = getMiningSpeedModifierCount(paramMiner)) == 0) {
/* 602 */       return 1.0F;
/*     */     }
/* 604 */     return 1.0F + getMiningSpeedModifierEfficiencyPerCount(i) * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_MINING_SPEED_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getMiningSpeed(Miner paramMiner, int paramInt) {
/*     */     float f;
/* 614 */     if ((f = getBaseMiningSpeed(paramMiner, paramInt)) <= 0.0F || f >= 2.1474836E9F) {
/* 615 */       throw new IllegalStateException("Base mining speed for " + paramMiner.type.name() + " L" + paramInt + " is " + f);
/*     */     }
/*     */ 
/*     */     
/* 619 */     f *= getMiningSpeedModifierMultiplier(paramMiner);
/*     */     
/*     */     SourceTile sourceTile;
/* 622 */     if ((sourceTile = paramMiner.getTile()) != null) {
/* 623 */       f *= sourceTile.getResourceDensity();
/*     */     }
/*     */     
/* 626 */     if (f < 0.0F || f >= 2.1474836E9F) {
/* 627 */       throw new IllegalStateException("Base mining speed for " + paramMiner.type.name() + " L" + paramInt + " is " + f);
/*     */     }
/*     */     
/* 630 */     if (this.S.gameState.difficultyMode == DifficultyMode.EASY) {
/* 631 */       f *= 0.75F;
/*     */     }
/*     */     
/* 634 */     if (this.bonusDoubleMiningSpeedTimeLeft > 0.0F) {
/* 635 */       f *= 2.0F;
/*     */     }
/*     */     
/* 638 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Miner paramMiner) {
/* 646 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 648 */     SourceTile sourceTile = paramMiner.getTile();
/* 649 */     int i = 0; ResourceType[] arrayOfResourceType; int j; byte b;
/* 650 */     for (j = (arrayOfResourceType = ResourceType.values).length, b = 0; b < j; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 651 */       if (Game.i.minerManager.getFactory(paramMiner.type).canMineResource(resourceType)) {
/* 652 */         i += sourceTile.getResourcesCount(resourceType);
/*     */       }
/*     */       b++; }
/*     */     
/* 656 */     if (i > 0)
/*     */     
/* 658 */     { int k = this.S.gameState.randomInt(i);
/* 659 */       j = 0; ResourceType[] arrayOfResourceType1;
/* 660 */       int m = (arrayOfResourceType1 = ResourceType.values).length; i = 0; while (true) { if (i < m) { ResourceType resourceType = arrayOfResourceType1[i];
/* 661 */           if (Game.i.minerManager.getFactory(paramMiner.type).canMineResource(resourceType)) {
/*     */             
/* 663 */             int n = sourceTile.getResourcesCount(resourceType);
/* 664 */             if (k >= j && k < j + n) {
/* 665 */               paramMiner.nextMinedResourceType = resourceType;
/*     */               break;
/*     */             } 
/* 668 */             j += n;
/*     */           }  i++; continue; }
/*     */          return; }
/*     */        }
/* 672 */     else { paramMiner.nextMinedResourceType = null; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Miner paramMiner) {
/*     */     ResourceType resourceType;
/* 681 */     if ((resourceType = paramMiner.nextMinedResourceType) != null) {
/*     */       
/* 683 */       float f = getMiningSpeed(paramMiner, paramMiner.getUpgradeLevel());
/* 684 */       f = 1.0F / f;
/* 685 */       int j = (int)(paramMiner.miningTime / f);
/* 686 */       paramMiner.miningTime -= j * f;
/*     */       
/* 688 */       int i = Math.min(j, paramMiner.loopAbilityResourceBuffer);
/* 689 */       addResources(paramMiner, resourceType, j + i, true);
/* 690 */       paramMiner.loopAbilityResourceBuffer -= i;
/* 691 */       if (paramMiner.loopAbilityResourceBuffer <= 0) {
/* 692 */         paramMiner.affectedByLoopAbility = null;
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
/* 705 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 706 */         ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.minerManager.minedResourceParticleEffectPool.obtain();
/*     */ 
/*     */         
/* 709 */         if (this.g[resourceType.ordinal()] == null) {
/* 710 */           array = new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()])) });
/* 711 */           this.g[resourceType.ordinal()] = array;
/*     */         } else {
/* 713 */           array = this.g[resourceType.ordinal()];
/*     */         } 
/*     */         
/* 716 */         ((ParticleEmitter)pooledEffect.getEmitters().get(1)).setSprites(array);
/* 717 */         Array<Sprite> array = pooledEffect.getEmitters();
/*     */         
/* 719 */         float f1 = (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) ? 0.28F : 1.0F;
/*     */         
/* 721 */         for (byte b = 0; b < array.size; b++) {
/* 722 */           Color color = Game.i.resourceManager.getColor(resourceType);
/*     */           float[] arrayOfFloat;
/* 724 */           (arrayOfFloat = this.f[resourceType.ordinal()])[0] = color.r * f1;
/* 725 */           arrayOfFloat[1] = color.g * f1;
/* 726 */           arrayOfFloat[2] = color.b * f1;
/* 727 */           ((ParticleEmitter)array.get(b)).getTint().setColors(arrayOfFloat);
/*     */         } 
/* 729 */         pooledEffect.setPosition((paramMiner.getTile()).center.x, (paramMiner.getTile()).center.y);
/*     */         
/* 731 */         this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.RESOURCE_MINED, (paramMiner.getTile()).center.x, (paramMiner.getTile()).center.y);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 738 */     a(paramMiner);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     StateSystem.ActionsArray actionsArray;
/* 745 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 746 */       for (byte b1 = 0; b1 < actionsArray.size; b1++) {
/*     */         Action action;
/* 748 */         if ((action = actionsArray.actions[b1]).getType() == ActionType.BM) {
/*     */           
/* 750 */           BuildMinerAction buildMinerAction = (BuildMinerAction)action;
/* 751 */           if (buildMiner(buildMinerAction.minerType, buildMinerAction.x, buildMinerAction.y, true, true) != null) {
/* 752 */             this.S.gameState.registerPlayerActivity();
/*     */           }
/* 754 */         } else if (action.getType() == ActionType.UM) {
/*     */           
/* 756 */           UpgradeMinerAction upgradeMinerAction = (UpgradeMinerAction)action;
/* 757 */           if (upgradeMinerAt(upgradeMinerAction.x, upgradeMinerAction.y)) {
/* 758 */             this.S.gameState.registerPlayerActivity();
/*     */           }
/* 760 */         } else if (action.getType() == ActionType.GUM) {
/*     */           
/* 762 */           GlobalUpgradeMinerAction globalUpgradeMinerAction = (GlobalUpgradeMinerAction)action;
/* 763 */           boolean bool = false;
/* 764 */           for (byte b2 = 0; b2 < this.miners.size; b2++) {
/*     */             Miner miner;
/* 766 */             if ((miner = ((Miner[])this.miners.items)[b2]).type == globalUpgradeMinerAction.minerType && 
/* 767 */               upgradeMiner(miner)) {
/* 768 */               bool = true;
/*     */             }
/*     */           } 
/*     */           
/* 772 */           if (bool) {
/* 773 */             this.S.gameState.registerPlayerActivity();
/*     */           }
/* 775 */         } else if (action.getType() == ActionType.SM) {
/*     */           
/* 777 */           SellMinerAction sellMinerAction = (SellMinerAction)action;
/* 778 */           if (sellMiner(sellMinerAction.x, sellMinerAction.y)) {
/* 779 */             this.S.gameState.registerPlayerActivity();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 785 */     if (!this.S.gameState.isGameRealTimePasses())
/*     */       return;  byte b;
/*     */     int i;
/* 788 */     for (b = 0, i = this.miners.size; b < i; b++) {
/* 789 */       Miner miner = ((Miner[])this.miners.items)[b];
/*     */       
/* 791 */       float f = this.S.gameValue.getTickRateDeltaTime();
/* 792 */       if (miner.doubleSpeedTimeLeft != 0.0F) {
/* 793 */         f = this.S.gameValue.getTickRateDeltaTime() * 2.0F;
/* 794 */         miner.doubleSpeedTimeLeft -= this.S.gameValue.getTickRateDeltaTime();
/* 795 */         if (miner.doubleSpeedTimeLeft <= 0.0F) {
/* 796 */           miner.doubleSpeedTimeLeft = 0.0F;
/* 797 */           if (miner.doubleSpeedParticle != null) {
/* 798 */             miner.doubleSpeedParticle.allowCompletion();
/* 799 */             miner.doubleSpeedParticle = null;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 804 */       if (!miner.isPrepared()) {
/*     */         
/*     */         try {
/* 807 */           miner.reduceInstallTime(f);
/* 808 */         } catch (Exception exception) {
/* 809 */           throw new IllegalStateException("failed to reduce install time, miner idx " + b + " of " + i, exception);
/*     */         } 
/*     */         
/* 812 */         if (miner.isPrepared())
/*     */         {
/* 814 */           a(miner);
/*     */         }
/*     */       } else {
/*     */         
/* 818 */         miner.miningTime += f;
/* 819 */         if (miner.nextMinedResourceType == null) {
/*     */           
/* 821 */           if (miner.miningTime > 1.0F) {
/* 822 */             miner.miningTime = 0.0F;
/* 823 */             a(miner);
/*     */           } 
/*     */         } else {
/*     */           
/* 827 */           float f1 = getMiningSpeed(miner, miner.getUpgradeLevel());
/* 828 */           float f2 = 1.0F / f1;
/* 829 */           if (miner.miningTime >= f2)
/*     */           {
/* 831 */             b(miner);
/*     */           }
/*     */         } 
/*     */       } 
/* 835 */       miner.existsTime += paramFloat;
/*     */     } 
/*     */     
/* 838 */     this.bonusDoubleMiningSpeedTimeLeft -= paramFloat;
/* 839 */     if (this.bonusDoubleMiningSpeedTimeLeft < 0.0F) {
/* 840 */       this.bonusDoubleMiningSpeedTimeLeft = 0.0F;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 903 */     return "Miner";
/*     */   }
/*     */   
/*     */   public static void drawBatch(Batch paramBatch, Map paramMap, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/* 907 */     for (Array.ArrayIterator<SourceTile> arrayIterator = paramMap.getTilesByType(SourceTile.class).iterator(); arrayIterator.hasNext();) {
/* 908 */       if ((sourceTile = arrayIterator.next()).visibleOnScreen && 
/* 909 */         sourceTile.miner != null) {
/* 910 */         sourceTile.miner.drawBatch(paramBatch, (sourceTile.getX() << 7), (sourceTile.getY() << 7), 128.0F, paramFloat, paramDrawMode);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 917 */     this.miners.clear();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnNextWaveForce
/*     */     extends SerializableListener<MinerSystem> implements Listener<NextWaveForce> {
/*     */     private OnNextWaveForce() {}
/*     */     
/*     */     private OnNextWaveForce(MinerSystem param1MinerSystem) {
/* 926 */       this.a = param1MinerSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(NextWaveForce param1NextWaveForce) {
/* 931 */       if (param1NextWaveForce.getTime() > 0.0F) {
/* 932 */         for (byte b = 0; b < ((MinerSystem)this.a).miners.size; b++) {
/*     */           Miner miner;
/* 934 */           (miner = ((Miner[])((MinerSystem)this.a).miners.items)[b]).doubleSpeedTimeLeft += param1NextWaveForce.getTime();
/*     */           
/* 936 */           if (miner.doubleSpeedParticle == null && ((MinerSystem)this.a).S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !((MinerSystem)this.a).S._particle.willParticleBeSkipped()) {
/* 937 */             miner.doubleSpeedParticle = (ParticleEffectPool.PooledEffect)Game.i.minerManager.doubleSpeedParticleEffectPool.obtain();
/* 938 */             miner.doubleSpeedParticle.setPosition((miner.getTile()).center.x, (miner.getTile()).center.y);
/* 939 */             ((MinerSystem)this.a).S._particle.addParticle((ParticleEffect)miner.doubleSpeedParticle, true);
/*     */           } 
/*     */         } 
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class OnMinerRemove
/*     */     extends SerializableListener<MinerSystem>
/*     */     implements Listener<MinerRemove>
/*     */   {
/*     */     private OnMinerRemove() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private OnMinerRemove(MinerSystem param1MinerSystem) {
/* 976 */       this.a = param1MinerSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(MinerRemove param1MinerRemove) {
/* 981 */       ((MinerSystem)this.a).unregister(param1MinerRemove.getMiner());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\MinerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */