/*      */ package com.prineside.tdi2.systems;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Action;
/*      */ import com.prineside.tdi2.Building;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.DamageRecord;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.SerializableListener;
/*      */ import com.prineside.tdi2.SpaceTileBonus;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.actions.BuildTowerAction;
/*      */ import com.prineside.tdi2.actions.ChangeTowerAimStrategyAction;
/*      */ import com.prineside.tdi2.actions.CustomTowerButtonAction;
/*      */ import com.prineside.tdi2.actions.GlobalUpgradeTowerAction;
/*      */ import com.prineside.tdi2.actions.SelectGlobalTowerAbilityAction;
/*      */ import com.prineside.tdi2.actions.SelectTowerAbilityAction;
/*      */ import com.prineside.tdi2.actions.SellTowerAction;
/*      */ import com.prineside.tdi2.actions.ToggleTowerEnabledAction;
/*      */ import com.prineside.tdi2.actions.UpgradeTowerAction;
/*      */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*      */ import com.prineside.tdi2.enums.ActionType;
/*      */ import com.prineside.tdi2.enums.BuildingType;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ShapeType;
/*      */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TowerStatType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.BuildingRemove;
/*      */ import com.prineside.tdi2.events.game.EnemyDie;
/*      */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*      */ import com.prineside.tdi2.events.game.GameStateTick;
/*      */ import com.prineside.tdi2.events.game.TowerAbilityChange;
/*      */ import com.prineside.tdi2.events.game.TowerAimStrategyChange;
/*      */ import com.prineside.tdi2.events.game.TowerBuild;
/*      */ import com.prineside.tdi2.events.game.TowerCustomButtonPress;
/*      */ import com.prineside.tdi2.events.game.TowerPlace;
/*      */ import com.prineside.tdi2.events.game.TowerPreSell;
/*      */ import com.prineside.tdi2.events.game.TowerUpgrade;
/*      */ import com.prineside.tdi2.events.game.TowersDefaultAimStrategyChange;
/*      */ import com.prineside.tdi2.managers.AssetManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.shapes.RangeCircle;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.towers.FlamethrowerTower;
/*      */ import com.prineside.tdi2.utils.DrawUtils;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.ObjectFilter;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ @REGS
/*      */ public final class TowerSystem extends GameSystem {
/*   79 */   private static final TLog a = TLog.forClass(TowerSystem.class);
/*      */ 
/*      */   
/*   82 */   private static final Color b = (new Color(MaterialColor.RED.P500)).mul(1.0F, 1.0F, 1.0F, 0.14F);
/*   83 */   private static final Color c = (new Color(MaterialColor.RED.P500)).mul(1.0F, 1.0F, 1.0F, 0.78F);
/*      */   
/*      */   public static final String TOWER_OUT_OF_ORDER_REASON_MANUAL = "ManuallyDisabled";
/*      */   
/*   87 */   private static final boolean[][] d = new boolean[6][6];
/*      */   static {
/*   89 */     for (byte b = 0; b < 6; b++) {
/*   90 */       for (byte b1 = 0; b1 < 6; b1++) {
/*   91 */         d[b][b1] = (b1 != b);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  100 */   public TowerAbilityCategoryRule[] towerAbilityCategoryRules = new TowerAbilityCategoryRule[] { new TowerAbilityCategoryRule(0, new int[] { 4, 7 }, false), new TowerAbilityCategoryRule(1, new int[] { 10 }, true), new TowerAbilityCategoryRule(2, new int[] { 20 }, false) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  112 */   public int[] towerAbilityIdxToCategory = new int[] { 0, 0, 0, 1, 2, 2 };
/*      */   
/*  114 */   private int e = 1;
/*  115 */   public boolean[][] canTowerAttackEnemy = new boolean[EnemyType.values.length][TowerType.values.length];
/*  116 */   public float[][] towerEnemyDamageMultiplier = new float[EnemyType.values.length][TowerType.values.length];
/*      */   
/*  118 */   public DelayedRemovalArray<Tower> towers = new DelayedRemovalArray(false, 8, Tower.class);
/*  119 */   private float[] f = new float[TowerStatType.values.length];
/*      */   @NAGS
/*  121 */   private Tower.AimStrategy g = Tower.AimStrategy.FIRST;
/*      */   @NAGS
/*      */   private RangeCircle h;
/*      */   @NAGS
/*      */   private RangeCircle i;
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  128 */     super.write(paramKryo, paramOutput);
/*  129 */     paramKryo.writeObject(paramOutput, this.towerAbilityCategoryRules);
/*  130 */     paramKryo.writeObject(paramOutput, this.towerAbilityIdxToCategory);
/*  131 */     paramOutput.writeVarInt(this.e, true);
/*  132 */     paramKryo.writeObject(paramOutput, this.canTowerAttackEnemy);
/*  133 */     paramKryo.writeObject(paramOutput, this.towerEnemyDamageMultiplier);
/*  134 */     paramKryo.writeObject(paramOutput, this.towers);
/*  135 */     paramKryo.writeObject(paramOutput, this.f);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  140 */     super.read(paramKryo, paramInput);
/*  141 */     this.towerAbilityCategoryRules = (TowerAbilityCategoryRule[])paramKryo.readObject(paramInput, TowerAbilityCategoryRule[].class);
/*  142 */     this.towerAbilityIdxToCategory = (int[])paramKryo.readObject(paramInput, int[].class);
/*  143 */     this.e = paramInput.readVarInt(true);
/*  144 */     this.canTowerAttackEnemy = (boolean[][])paramKryo.readObject(paramInput, boolean[][].class);
/*  145 */     this.towerEnemyDamageMultiplier = (float[][])paramKryo.readObject(paramInput, float[][].class);
/*  146 */     this.towers = (DelayedRemovalArray<Tower>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  147 */     this.f = (float[])paramKryo.readObject(paramInput, float[].class);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean affectsGameState() {
/*  152 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setup() {
/*      */     byte b1;
/*  159 */     for (b1 = 0; b1 < Game.i.towerManager.canTowerAttackEnemy.length; b1++) {
/*      */       boolean[] arrayOfBoolean;
/*  161 */       System.arraycopy(arrayOfBoolean = Game.i.towerManager.canTowerAttackEnemy[b1], 0, this.canTowerAttackEnemy[b1], 0, arrayOfBoolean.length);
/*      */     } 
/*  163 */     for (b1 = 0; b1 < Game.i.towerManager.towerEnemyDamageMultiplier.length; b1++) {
/*      */       float[] arrayOfFloat;
/*  165 */       System.arraycopy(arrayOfFloat = Game.i.towerManager.towerEnemyDamageMultiplier[b1], 0, this.towerEnemyDamageMultiplier[b1], 0, arrayOfFloat.length);
/*      */     }  TowerType[] arrayOfTowerType;
/*      */     int i;
/*      */     byte b2;
/*  169 */     for (i = (arrayOfTowerType = TowerType.values).length, b2 = 0; b2 < i; ) { TowerType towerType = arrayOfTowerType[b2];
/*  170 */       Game.i.towerManager.getFactory(towerType).configureSystems(this.S);
/*      */       b2++; }
/*      */     
/*  173 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this)).setDescription("TowerSystem - adds XP to the tower and increases Tower.enemiesKilled");
/*  174 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDieFlamethrowerPapers(this)).setDescription("TowerSystem - Flamethrower - gives papers for ultimate kills");
/*  175 */     this.S.events.getListeners(TowerPlace.class).addStateAffecting(new OnTowerPlace(this));
/*  176 */     this.S.events.getListeners(BuildingRemove.class).addStateAffecting(new OnBuildingRemove(this));
/*  177 */     this.S.events.getListeners(EnemyTakeDamage.class).addStateAffecting(new OnEnemyTakeDamage(this));
/*  178 */     this.S.events.getListeners(GameStateTick.class).addStateAffecting(new OnTickDisableTowersUnderEnemies(this)).setDescription("TowerSystem - Disables towers who have enemies on top of them");
/*  179 */     if (!this.S.CFG.headless) a(); 
/*      */   }
/*      */   
/*      */   private void a() {
/*  183 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.TOWER_APPLY_INTERPOLATION, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> applyDrawInterpolation(paramFloat3)))
/*      */ 
/*      */         
/*  186 */         .setName("Tower-applyDrawInterpolation"));
/*      */     
/*  188 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.TOWER_DRAW_WEAPONS, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawWeapons(paramBatch, paramFloat2)))
/*      */ 
/*      */         
/*  191 */         .setName("Tower-drawWeapons"));
/*      */     
/*  193 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.TOWER_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> a(paramBatch, paramFloat2)))
/*      */ 
/*      */         
/*  196 */         .setName("Tower-drawBatch"));
/*      */     
/*  198 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.TOWER_DRAW_BATCH_ADDITIVE, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatchAdditive(paramBatch, paramFloat2)))
/*      */ 
/*      */         
/*  201 */         .setName("Tower-drawBatchAdditive"));
/*      */     
/*  203 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.TOWER_DRAW_RANGES, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawRanges(paramBatch)))
/*      */ 
/*      */         
/*  206 */         .setName("Tower-drawBatchAdditive"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void postSetup() {
/*  212 */     Arrays.fill(this.f, Float.MIN_VALUE);
/*      */     
/*  214 */     if (this.S == null) throw new IllegalStateException("System is not registered");  TowerStatType[] arrayOfTowerStatType; int i;
/*      */     byte b;
/*  216 */     for (i = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/*  217 */       float f = 0.0F; TowerType[] arrayOfTowerType; int j; byte b1;
/*  218 */       for (j = (arrayOfTowerType = TowerType.values).length, b1 = 0; b1 < j; ) { TowerType towerType = arrayOfTowerType[b1];
/*  219 */         if (Game.i.towerManager.hasStat(towerType, towerStatType)) {
/*      */           Tower tower;
/*      */           
/*  222 */           (tower = Game.i.towerManager.getFactory(towerType).create()).setRegistered(this.S);
/*      */           
/*  224 */           PlatformTile platformTile = (PlatformTile)Game.i.tileManager.getFactory(TileType.PLATFORM).create(); SpaceTileBonusType[] arrayOfSpaceTileBonusType;
/*      */           int k;
/*      */           byte b2;
/*  227 */           for (k = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b2 = 0; b2 < k; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b2];
/*  228 */             platformTile.bonusType = spaceTileBonusType;
/*  229 */             tower.setTile(platformTile);
/*  230 */             tower.updateCache();
/*      */             float f1;
/*  232 */             if ((f1 = tower.getStat(towerStatType)) > f) {
/*  233 */               f = f1;
/*      */             }
/*      */             
/*      */             b2++; }
/*      */           
/*  238 */           tower.setExperience(Tower.LEVEL_EXPERIENCE_MILESTONES[Tower.LEVEL_EXPERIENCE_MILESTONES.length - 1] + 1.0F);
/*  239 */           tower.calculateXpLevel(false);
/*  240 */           tower.upgradeToLevel((byte)10);
/*      */           
/*  242 */           platformTile.bonusLevel = 5;
/*      */           
/*  244 */           for (k = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b2 = 0; b2 < k; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b2];
/*  245 */             platformTile.bonusType = spaceTileBonusType;
/*  246 */             tower.setTile(platformTile); boolean[][] arrayOfBoolean; int m;
/*      */             byte b3;
/*  248 */             for (m = (arrayOfBoolean = d).length, b3 = 0; b3 < m; b3++) {
/*  249 */               boolean[] arrayOfBoolean1; System.arraycopy(arrayOfBoolean1 = arrayOfBoolean[b3], 0, tower.installedAbilities, 0, arrayOfBoolean1.length);
/*  250 */               tower.updateCache();
/*      */               
/*      */               float f1;
/*  253 */               if ((f1 = tower.getStat(towerStatType)) > f) {
/*  254 */                 f = f1;
/*      */               }
/*      */             } 
/*      */             b2++; }
/*      */           
/*  259 */           tower.setTile(null);
/*  260 */           tower.setUnregistered();
/*      */         } 
/*      */         b1++; }
/*      */       
/*  264 */       this.f[towerStatType.ordinal()] = f;
/*      */       b++; }
/*      */   
/*      */   }
/*      */   
/*      */   public final void postStateRestore() {
/*  270 */     a();
/*      */   }
/*      */   
/*      */   public final boolean isRegistered(Tower paramTower) {
/*  274 */     return paramTower.isRegistered();
/*      */   }
/*      */   
/*      */   private void a(Tower paramTower) {
/*  278 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  280 */     if (paramTower.isRegistered()) throw new IllegalArgumentException("Tower is already registered");
/*      */     
/*  282 */     paramTower.id = this.e++;
/*  283 */     paramTower.setRegistered(this.S);
/*  284 */     this.towers.add(paramTower);
/*      */   }
/*      */   
/*      */   private void b(Tower paramTower) {
/*  288 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  290 */     if (!paramTower.isRegistered()) throw new IllegalArgumentException("Tower is not registered");
/*      */     
/*  292 */     paramTower.setUnregistered();
/*  293 */     this.towers.removeValue(paramTower, true);
/*      */     
/*  295 */     updateAbilityAvailableParticleEffect(paramTower);
/*      */   }
/*      */   
/*      */   public final float getMaxPossibleStat(TowerStatType paramTowerStatType) {
/*  299 */     return this.f[paramTowerStatType.ordinal()];
/*      */   }
/*      */   
/*      */   public final Tower.AimStrategy getDefaultAimStrategy() {
/*  303 */     return this.g;
/*      */   }
/*      */   
/*      */   public final void setDefaultAimStrategy(Tower.AimStrategy paramAimStrategy) {
/*  307 */     this.g = paramAimStrategy;
/*      */     
/*  309 */     this.S.events.trigger((Event)new TowersDefaultAimStrategyChange());
/*      */   }
/*      */   
/*      */   public final void selectTowerAbilityAction(Tower paramTower, int paramInt) {
/*  313 */     selectTowerAbilityActionAt(paramTower.getTile().getX(), paramTower.getTile().getY(), paramInt);
/*      */   }
/*      */   
/*      */   public final void selectGlobalTowerAbilityAction(Tower paramTower, int paramInt) {
/*  317 */     selectGlobalTowerAbilityActionAt(paramTower.getTile().getX(), paramTower.getTile().getY(), paramInt);
/*      */   }
/*      */   
/*      */   public final void customTowerButtonAction(Tower paramTower, int paramInt1, int paramInt2) {
/*  321 */     this.S.gameState.pushActionNextUpdate((Action)new CustomTowerButtonAction(paramTower.getTile().getX(), paramTower.getTile().getY(), paramInt1, paramInt2));
/*      */   }
/*      */   
/*      */   public final void customTowerButtonActionAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  325 */     this.S.gameState.pushActionNextUpdate((Action)new CustomTowerButtonAction(paramInt1, paramInt2, paramInt3, paramInt4));
/*      */   }
/*      */   
/*      */   public final void selectTowerAbilityActionAt(int paramInt1, int paramInt2, int paramInt3) {
/*  329 */     this.S.gameState.pushActionNextUpdate((Action)new SelectTowerAbilityAction(paramInt3, paramInt1, paramInt2));
/*      */   }
/*      */   
/*      */   public final void selectGlobalTowerAbilityActionAt(int paramInt1, int paramInt2, int paramInt3) {
/*  333 */     this.S.gameState.pushActionNextUpdate((Action)new SelectGlobalTowerAbilityAction(paramInt3, paramInt1, paramInt2));
/*      */   }
/*      */   
/*      */   public final void setAbilityInstalled(Tower paramTower, int paramInt, boolean paramBoolean) {
/*  337 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */ 
/*      */ 
/*      */     
/*  341 */     if (paramTower.installedAbilities[paramInt] == paramBoolean)
/*      */       return; 
/*  343 */     paramTower.installedAbilities[paramInt] = paramBoolean;
/*  344 */     this.S.map.markTilesDirtyNearTile((Tile)paramTower.getTile(), 1);
/*      */     
/*  346 */     this.S.events.trigger((Event)new TowerAbilityChange(paramTower, paramInt, paramBoolean));
/*      */     
/*  348 */     paramTower.onAbilitySet(paramInt, paramBoolean);
/*      */ 
/*      */     
/*  351 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*      */       ParticleEffectPool.PooledEffect pooledEffect;
/*  353 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.upgradeParticles.obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/*  354 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */ 
/*      */       
/*  357 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.highlightParticles[paramTower.type.ordinal()].obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/*  358 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void buildTowerActionOnSelectedTile(TowerType paramTowerType) {
/*      */     Tile tile;
/*  364 */     if ((tile = this.S._gameMapSelection.getSelectedTile()) != null) {
/*  365 */       buildTowerAction(paramTowerType, this.g, tile.getX(), tile.getY());
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean canTowersBeManuallyDisabled() {
/*  370 */     return this.S.gameValue.getBooleanValue(GameValueType.TOWERS_CAN_BE_MANUALLY_DISABLED);
/*      */   }
/*      */   
/*      */   public final void toggleTowerEnabledAction() {
/*  374 */     if (!canTowersBeManuallyDisabled())
/*      */       return;  Tile tile;
/*      */     PlatformTile platformTile;
/*  377 */     if ((tile = this.S._gameMapSelection.getSelectedTile()) != null && 
/*  378 */       tile.type == TileType.PLATFORM && 
/*      */       
/*  380 */       (platformTile = (PlatformTile)tile).building instanceof Tower) {
/*  381 */       this.S.gameState.pushActionNextUpdate((Action)new ToggleTowerEnabledAction(tile.getX(), tile.getY()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void buildTowerActionWithAimStrategy(TowerType paramTowerType, Tower.AimStrategy paramAimStrategy) {
/*      */     Tile tile;
/*  389 */     if ((tile = this.S._gameMapSelection.getSelectedTile()) != null) {
/*  390 */       buildTowerAction(paramTowerType, paramAimStrategy, tile.getX(), tile.getY());
/*      */     }
/*      */   }
/*      */   
/*      */   public final void buildTowerAction(TowerType paramTowerType, Tower.AimStrategy paramAimStrategy, int paramInt1, int paramInt2) {
/*  395 */     if (!Game.i.towerManager.getFactory(paramTowerType).isAvailable(this.S.gameValue)) {
/*      */       return;
/*      */     }
/*      */     
/*      */     Tile tile;
/*  400 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) == null) {
/*      */       return;
/*      */     }
/*      */     PlatformTile platformTile;
/*  404 */     if (tile.type == TileType.PLATFORM && 
/*      */       
/*  406 */       (platformTile = (PlatformTile)tile).building == null) {
/*  407 */       int i = Game.i.towerManager.getFactory(paramTowerType).getBuildPrice(this.S);
/*      */       
/*  409 */       if (this.S.gameState.getMoney() >= i) {
/*  410 */         this.S.gameState.pushActionNextUpdate((Action)new BuildTowerAction(paramTowerType, paramAimStrategy, paramInt1, paramInt2));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final Tower buildTower(TowerType paramTowerType, @Null Tower.AimStrategy paramAimStrategy, int paramInt1, int paramInt2) {
/*  417 */     return buildTowerIgnorePrice(paramTowerType, paramAimStrategy, paramInt1, paramInt2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Tower buildTowerIgnorePrice(TowerType paramTowerType, @Null Tower.AimStrategy paramAimStrategy, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  425 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  427 */     if (!paramBoolean && !Game.i.towerManager.getFactory(paramTowerType).isAvailable(this.S.gameValue)) {
/*  428 */       a.e("buildTower - tower type " + paramTowerType.name() + " is not available", new Object[0]);
/*  429 */       return null;
/*      */     } 
/*      */     
/*      */     Tile tile;
/*  433 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) == null) {
/*  434 */       a.e("buildTower - no tile at " + paramInt1 + ":" + paramInt2, new Object[0]);
/*  435 */       return null;
/*      */     } 
/*      */     
/*  438 */     if (paramAimStrategy == null) {
/*  439 */       paramAimStrategy = Tower.AimStrategy.FIRST;
/*      */     }
/*      */     
/*  442 */     if (tile.type == TileType.PLATFORM) {
/*      */       Tower tower;
/*      */       PlatformTile platformTile;
/*  445 */       if ((platformTile = (PlatformTile)tile).building == null) {
/*      */         
/*  447 */         paramInt1 = paramBoolean ? 0 : Game.i.towerManager.getFactory(paramTowerType).getBuildPrice(this.S);
/*      */         
/*  449 */         if (this.S.gameState.removeMoney(paramInt1)) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  454 */           (tower = Game.i.towerManager.getFactory(paramTowerType).create()).moneySpentOn = paramInt1;
/*  455 */           tower.aimStrategy = paramAimStrategy;
/*  456 */           for (byte b = 0; b < tower.dpsDamage.length; b++) {
/*  457 */             tower.dpsDamage[b] = 0.0F;
/*  458 */             tower.dpsTime[b] = b / 10.0F * 10.0F;
/*      */           } 
/*  460 */           this.S.map.setTower(tile.getX(), tile.getY(), tower);
/*      */ 
/*      */           
/*  463 */           tower.experience = Tower.getLevelExperienceMilestone(Tower.getStartingLevel(paramTowerType, this.S.gameValue));
/*      */           
/*  465 */           this.S.map.updateDirtyTiles();
/*      */           
/*  467 */           this.S.events.trigger((Event)new TowerBuild(tower, paramInt1));
/*      */ 
/*      */           
/*  470 */           if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*      */             ParticleEffectPool.PooledEffect pooledEffect;
/*  472 */             (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.highlightParticles[tower.type.ordinal()].obtain()).setPosition((tower.getTile()).center.x, (tower.getTile()).center.y);
/*  473 */             this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */           } 
/*      */ 
/*      */           
/*  477 */           return tower;
/*      */         } 
/*  479 */         a.e("buildTower - not enough money", new Object[0]);
/*  480 */         return null;
/*      */       } 
/*      */       
/*  483 */       a.e("buildTower - tile " + paramInt1 + ":" + tower + " already has a tower", new Object[0]);
/*  484 */       return null;
/*      */     } 
/*      */     
/*  487 */     a.e("buildTower - tile type is " + tile.type.name(), new Object[0]);
/*  488 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void upgradeTowerAction(Tower paramTower) {
/*  493 */     upgradeTowerActionAt(paramTower.getTile().getX(), paramTower.getTile().getY());
/*      */   }
/*      */   public final void upgradeTowerActionAt(int paramInt1, int paramInt2) {
/*      */     PlatformTile platformTile;
/*      */     Tile tile;
/*  498 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null && tile.type == TileType.PLATFORM && 
/*      */       
/*  500 */       (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER && 
/*  501 */       c((Tower)platformTile.building)) {
/*  502 */       this.S.gameState.pushActionNextUpdate((Action)new UpgradeTowerAction(paramInt1, paramInt2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void globalUpgradeTowerAction(TowerType paramTowerType) {
/*  509 */     this.S.gameState.pushActionNextUpdate((Action)new GlobalUpgradeTowerAction(paramTowerType));
/*      */   }
/*      */   
/*      */   private boolean c(Tower paramTower) {
/*  513 */     if (paramTower.getUpgradeLevel() >= paramTower.getMaxUpgradeLevel()) return false; 
/*  514 */     int i = getUpgradePrice(paramTower);
/*  515 */     return (this.S.gameState.getMoney() >= i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean upgradeTower(Tower paramTower) {
/*  523 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  525 */     if (paramTower.getUpgradeLevel() >= paramTower.getMaxUpgradeLevel()) return false;
/*      */     
/*  527 */     int i = getUpgradePrice(paramTower);
/*  528 */     if (this.S.gameState.removeMoney(i)) {
/*      */       
/*  530 */       paramTower.moneySpentOn += i;
/*  531 */       paramTower.upgrade();
/*      */       
/*  533 */       this.S.events.trigger((Event)new TowerUpgrade(paramTower, i));
/*      */ 
/*      */       
/*  536 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*      */         ParticleEffectPool.PooledEffect pooledEffect;
/*  538 */         (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.upgradeParticles.obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/*  539 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */ 
/*      */         
/*  542 */         (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.highlightParticles[paramTower.type.ordinal()].obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/*  543 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */       } 
/*      */       
/*  546 */       return true;
/*      */     } 
/*  548 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void sellTowerAction(Tower paramTower) {
/*  553 */     if (paramTower.isOutOfOrder()) {
/*      */       return;
/*      */     }
/*      */     
/*  557 */     this.S.gameState.pushActionNextUpdate((Action)new SellTowerAction(paramTower.getTile().getX(), paramTower.getTile().getY()));
/*      */   }
/*      */   
/*      */   public final boolean sellTower(Tower paramTower) {
/*  561 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  563 */     paramTower.onPreSell();
/*  564 */     int i = paramTower.getSellPrice();
/*      */     
/*  566 */     this.S.events.trigger((Event)new TowerPreSell(paramTower, i));
/*      */     
/*  568 */     this.S.gameState.addMoney(i, false);
/*  569 */     this.S.map.removeBuilding((Building)paramTower);
/*  570 */     this.S.events.trigger((Event)new TowerSell(paramTower, i));
/*      */     
/*  572 */     return true;
/*      */   }
/*      */   
/*      */   public final void setTowerAimStrategyAction(Tower paramTower, Tower.AimStrategy paramAimStrategy) {
/*  576 */     this.S.gameState.pushActionNextUpdate((Action)new ChangeTowerAimStrategyAction(paramTower.getTile().getX(), paramTower.getTile().getY(), paramAimStrategy));
/*      */   }
/*      */   
/*      */   public final void setTowerAimStrategy(Tower paramTower, Tower.AimStrategy paramAimStrategy) {
/*  580 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  582 */     paramTower.setAimStrategy(paramAimStrategy);
/*      */ 
/*      */     
/*  585 */     paramTower.setTarget(null);
/*      */     
/*  587 */     this.S.events.trigger((Event)new TowerAimStrategyChange(paramTower));
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getUpgradePrice(Tower paramTower) {
/*      */     int i;
/*  593 */     if ((i = paramTower.getUpgradeLevel() + 1) > paramTower.getMaxUpgradeLevel()) {
/*  594 */       return 0;
/*      */     }
/*      */     
/*  597 */     int j = Game.i.towerManager.getUpgradePrice(paramTower.type, i, this.S.gameValue);
/*      */     float f;
/*  599 */     if ((f = Game.i.towerManager.getUpgradePriceMultiplier(paramTower.type)) != 1.0F) {
/*      */       
/*  601 */       float f1 = 1.0F;
/*  602 */       for (byte b = 0; b < this.towers.size; b++) {
/*  603 */         if ((((Tower[])this.towers.items)[b]).type == paramTower.type && ((Tower[])this.towers.items)[b].getUpgradeLevel() >= i) {
/*  604 */           f1 *= f;
/*      */         }
/*      */       } 
/*  607 */       j = (int)(j * f1);
/*      */     } 
/*      */ 
/*      */     
/*  611 */     if (paramTower.getTile() != null && (paramTower.getTile()).bonusType == SpaceTileBonusType.UPGRADE_DISCOUNT && (paramTower.getTile()).bonusLevel > 0) {
/*  612 */       j = (int)(j * SpaceTileBonus.getEffect(SpaceTileBonusType.UPGRADE_DISCOUNT, (paramTower.getTile()).bonusLevel));
/*      */     }
/*      */     
/*  615 */     return j;
/*      */   }
/*      */   
/*      */   public final int getBaseUpgradePrice(Tower paramTower, int paramInt) {
/*  619 */     if (paramInt > paramTower.getMaxUpgradeLevel()) {
/*  620 */       return 0;
/*      */     }
/*      */     
/*  623 */     return Game.i.towerManager.getUpgradePrice(paramTower.type, paramInt, this.S.gameValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getGlobalUpgradePrice(TowerType paramTowerType) {
/*      */     float f;
/*  629 */     if ((f = Game.i.towerManager.getUpgradePriceMultiplier(paramTowerType)) == 1.0F) {
/*  630 */       int j = 0;
/*  631 */       for (byte b1 = 0; b1 < this.towers.size; b1++) {
/*      */         Tower tower;
/*  633 */         if ((tower = (Tower)this.towers.get(b1)).type == paramTowerType && 
/*  634 */           tower.getUpgradeLevel() < tower.getMaxUpgradeLevel()) {
/*  635 */           j += getUpgradePrice(tower);
/*      */         }
/*      */       } 
/*      */       
/*  639 */       return j;
/*      */     } 
/*  641 */     int i = 0;
/*  642 */     for (byte b = 0; b < this.towers.size; b++) {
/*      */       Tower tower;
/*  644 */       if ((tower = ((Tower[])this.towers.items)[b]).type == paramTowerType && 
/*  645 */         tower.getUpgradeLevel() < tower.getMaxUpgradeLevel()) {
/*  646 */         int j = tower.getUpgradeLevel() + 1;
/*      */         
/*  648 */         float f1 = 1.0F; int k;
/*  649 */         for (k = 0; k < this.towers.size; k++) {
/*      */           Tower tower1;
/*  651 */           if ((tower1 = ((Tower[])this.towers.items)[k]).type == paramTowerType) {
/*  652 */             byte b1 = tower1.getUpgradeLevel();
/*  653 */             if (k < b && b1 < tower1.getMaxUpgradeLevel()) {
/*  654 */               b1++;
/*      */             }
/*      */             
/*  657 */             if (b1 >= j) {
/*  658 */               f1 *= f;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/*  663 */         k = (int)(getBaseUpgradePrice(tower, j) * f1);
/*      */ 
/*      */         
/*  666 */         if (tower.getTile() != null && (tower.getTile()).bonusType == SpaceTileBonusType.UPGRADE_DISCOUNT && (tower.getTile()).bonusLevel > 0) {
/*  667 */           k = (int)(k * SpaceTileBonus.getEffect(SpaceTileBonusType.UPGRADE_DISCOUNT, (tower.getTile()).bonusLevel));
/*      */         }
/*      */         
/*  670 */         i += k;
/*      */       } 
/*      */     } 
/*  673 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void update(float paramFloat) {
/*      */     StateSystem.ActionsArray actionsArray;
/*  681 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null)
/*  682 */       for (byte b1 = 0; b1 < actionsArray.size; b1++) {
/*      */         Action action;
/*  684 */         if ((action = actionsArray.actions[b1]).getType() == ActionType.BT) {
/*      */           
/*  686 */           BuildTowerAction buildTowerAction = (BuildTowerAction)action;
/*  687 */           if (buildTower(buildTowerAction.towerType, buildTowerAction.aimStrategy, buildTowerAction.x, buildTowerAction.y) != null)
/*  688 */             this.S.gameState.registerPlayerActivity(); 
/*      */         } else {
/*  690 */           Tile tile; if (action.getType() == ActionType.UT) {
/*      */             
/*  692 */             UpgradeTowerAction upgradeTowerAction = (UpgradeTowerAction)action;
/*      */             PlatformTile platformTile;
/*  694 */             if ((tile = this.S.map.getMap().getTile(upgradeTowerAction.x, upgradeTowerAction.y)) != null && tile.type == TileType.PLATFORM && 
/*      */               
/*  696 */               (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER && 
/*  697 */               upgradeTower((Tower)platformTile.building)) {
/*  698 */               this.S.gameState.registerPlayerActivity();
/*      */             
/*      */             }
/*      */           }
/*  702 */           else if (tile.getType() == ActionType.TTE) {
/*      */ 
/*      */             
/*  705 */             ToggleTowerEnabledAction toggleTowerEnabledAction = (ToggleTowerEnabledAction)tile;
/*      */             PlatformTile platformTile;
/*  707 */             if (canTowersBeManuallyDisabled() && (tile = this.S.map.getMap().getTile(toggleTowerEnabledAction.x, toggleTowerEnabledAction.y)) != null && tile.type == TileType.PLATFORM && 
/*      */               
/*  709 */               (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*      */               Tower tower;
/*  711 */               if ((tower = (Tower)platformTile.building).outOfOrder.hasReason("ManuallyDisabled")) {
/*  712 */                 tower.outOfOrder.removeReason("ManuallyDisabled");
/*      */               } else {
/*  714 */                 tower.outOfOrder.addReason("ManuallyDisabled");
/*      */               } 
/*      */             } 
/*      */           } else {
/*      */             boolean bool;
/*  719 */             if (tile.getType() == ActionType.GUT) {
/*      */               
/*  721 */               GlobalUpgradeTowerAction globalUpgradeTowerAction = (GlobalUpgradeTowerAction)tile;
/*  722 */               bool = false;
/*  723 */               for (byte b2 = 0; b2 < this.towers.size; b2++) {
/*      */                 Tower tower;
/*  725 */                 if ((tower = (Tower)this.towers.get(b2)).type == globalUpgradeTowerAction.towerType && 
/*  726 */                   upgradeTower(tower)) {
/*  727 */                   bool = true;
/*      */                 }
/*      */               } 
/*      */               
/*  731 */               if (bool)
/*  732 */                 this.S.gameState.registerPlayerActivity(); 
/*      */             } else {
/*  734 */               Tile tile1; if (bool.getType() == ActionType.ST) {
/*      */                 
/*  736 */                 SellTowerAction sellTowerAction = (SellTowerAction)bool;
/*      */                 PlatformTile platformTile;
/*  738 */                 if ((tile1 = this.S.map.getMap().getTile(sellTowerAction.x, sellTowerAction.y)) != null && tile1.type == TileType.PLATFORM && 
/*      */                   
/*  740 */                   (platformTile = (PlatformTile)tile1).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*      */                   Tower tower;
/*  742 */                   if (!(tower = (Tower)platformTile.building).isSellFullRefundStillActive() && tower.getUpgradeLevel() > 0) {
/*  743 */                     this.S.gameState.registerPlayerActivity();
/*      */                   }
/*  745 */                   sellTower(tower);
/*      */                 }
/*      */               
/*  748 */               } else if (tile1.getType() == ActionType.CTAS) {
/*      */                 
/*  750 */                 ChangeTowerAimStrategyAction changeTowerAimStrategyAction = (ChangeTowerAimStrategyAction)tile1;
/*      */                 PlatformTile platformTile;
/*  752 */                 if ((tile1 = this.S.map.getMap().getTile(changeTowerAimStrategyAction.x, changeTowerAimStrategyAction.y)) != null && tile1.type == TileType.PLATFORM && 
/*      */                   
/*  754 */                   (platformTile = (PlatformTile)tile1).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*  755 */                   setTowerAimStrategy((Tower)platformTile.building, changeTowerAimStrategyAction.aimStrategy);
/*      */                 }
/*      */               }
/*  758 */               else if (tile1.getType() == ActionType.STA) {
/*      */                 
/*  760 */                 SelectTowerAbilityAction selectTowerAbilityAction = (SelectTowerAbilityAction)tile1; PlatformTile platformTile;
/*      */                 Tower tower;
/*  762 */                 if ((tile1 = this.S.map.getMap().getTile(selectTowerAbilityAction.x, selectTowerAbilityAction.y)) != null && tile1.type == TileType.PLATFORM && 
/*      */                   
/*  764 */                   (platformTile = (PlatformTile)tile1).building != null && platformTile.building.buildingType == BuildingType.TOWER && (
/*      */                   
/*  766 */                   tower = (Tower)platformTile.building).canAbilityBeInstalled(selectTowerAbilityAction.abilityIndex)) {
/*  767 */                   setAbilityInstalled(tower, selectTowerAbilityAction.abilityIndex, true);
/*  768 */                   if (!tower.isSellFullRefundStillActive() && tower.getUpgradeLevel() > 0) {
/*  769 */                     this.S.gameState.registerPlayerActivity();
/*      */                   }
/*      */                 } 
/*      */               } else {
/*      */                 byte b2;
/*  774 */                 if (tile1.getType() == ActionType.SGTA) {
/*      */                   
/*  776 */                   SelectGlobalTowerAbilityAction selectGlobalTowerAbilityAction = (SelectGlobalTowerAbilityAction)tile1;
/*      */                   PlatformTile platformTile;
/*  778 */                   if ((tile1 = this.S.map.getMap().getTile(selectGlobalTowerAbilityAction.x, selectGlobalTowerAbilityAction.y)) != null && tile1.type == TileType.PLATFORM && 
/*      */                     
/*  780 */                     (platformTile = (PlatformTile)tile1).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*  781 */                     Tower tower = (Tower)platformTile.building;
/*      */ 
/*      */                     
/*  784 */                     for (b2 = 0; b2 < this.towers.size; b2++) {
/*      */                       Tower tower1;
/*  786 */                       if ((tower1 = (Tower)this.towers.get(b2)).type == tower.type && tower1.canAbilityBeInstalled(selectGlobalTowerAbilityAction.abilityIndex)) {
/*  787 */                         setAbilityInstalled(tower1, selectGlobalTowerAbilityAction.abilityIndex, true);
/*  788 */                         if (!tower1.isSellFullRefundStillActive() && tower1.getUpgradeLevel() > 0) {
/*  789 */                           this.S.gameState.registerPlayerActivity();
/*      */                         
/*      */                         }
/*      */                       
/*      */                       }
/*      */                     
/*      */                     }
/*      */                   
/*      */                   }
/*      */                 
/*      */                 }
/*  800 */                 else if (b2.getType() == ActionType.CTB) {
/*      */                   
/*  802 */                   CustomTowerButtonAction customTowerButtonAction = (CustomTowerButtonAction)b2; Tile tile2;
/*      */                   PlatformTile platformTile;
/*  804 */                   if ((tile2 = this.S.map.getMap().getTile(customTowerButtonAction.x, customTowerButtonAction.y)) != null && tile2.type == TileType.PLATFORM && 
/*      */                     
/*  806 */                     (platformTile = (PlatformTile)tile2).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*      */                     Tower tower;
/*      */ 
/*      */                     
/*  810 */                     if ((tower = (Tower)platformTile.building).hasCustomButton()) {
/*  811 */                       tower.customButtonAction(customTowerButtonAction.mapX, customTowerButtonAction.mapY);
/*      */                       
/*  813 */                       this.S.events.trigger((Event)new TowerCustomButtonPress(tower));
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }  
/*  822 */     this.towers.begin(); byte b; int i;
/*  823 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*      */       Tower tower;
/*  825 */       (tower = ((Tower[])this.towers.items)[b]).update(paramFloat);
/*      */ 
/*      */       
/*  828 */       a(tower, paramFloat);
/*      */     } 
/*  830 */     this.towers.end();
/*      */   }
/*      */   
/*      */   private static void a(Tower paramTower, float paramFloat) {
/*  834 */     for (byte b = 0; b < paramTower.dpsTime.length; b++) {
/*  835 */       paramTower.dpsTime[b] = paramTower.dpsTime[b] + paramFloat;
/*  836 */       if (paramTower.dpsTime[b] >= 10.0F) {
/*  837 */         paramTower.dpsTime[b] = 0.0F;
/*  838 */         paramTower.dpsDamage[b] = 0.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final String getSystemName() {
/*  845 */     return "Tower";
/*      */   }
/*      */   
/*      */   private void a(Batch paramBatch, float paramFloat) {
/*  849 */     this.towers.begin(); byte b; int i;
/*  850 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*      */       Tower tower;
/*  852 */       if (!(tower = ((Tower[])this.towers.items)[b]).isOutOfOrder()) tower.drawBatch(paramBatch, paramFloat); 
/*  853 */       updateAbilityAvailableParticleEffect(tower);
/*      */     } 
/*  855 */     this.towers.end();
/*      */     
/*  857 */     this.towers.begin();
/*  858 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*  859 */       if (((Tower[])this.towers.items)[b].isOutOfOrder()) ((Tower[])this.towers.items)[b].drawGlitch(paramBatch); 
/*      */     } 
/*  861 */     this.towers.end();
/*      */     
/*  863 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */   }
/*      */   
/*      */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/*  867 */     this.towers.begin(); byte b; int i;
/*  868 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*  869 */       ((Tower[])this.towers.items)[b].drawBatchAdditive(paramBatch, paramFloat);
/*      */     }
/*  871 */     this.towers.end();
/*      */   }
/*      */   public final void drawRanges(Batch paramBatch) {
/*      */     Vector2 vector2;
/*  875 */     Tile tile1 = this.S._gameMapSelection.getSelectedTile();
/*  876 */     Tile tile2 = this.S._gameMapSelection.getHoveredTile();
/*      */     
/*  878 */     if (tile1 != null) {
/*  879 */       if (this.h == null) {
/*  880 */         this.h = (RangeCircle)Game.i.shapeManager.getFactory(ShapeType.RANGE_CIRCLE).obtain();
/*      */       }
/*      */       
/*  883 */       tile1.drawSelectedRange(paramBatch, this.h);
/*      */     } 
/*      */     
/*  886 */     if (tile2 != null) {
/*  887 */       if (this.i == null) {
/*  888 */         this.i = (RangeCircle)Game.i.shapeManager.getFactory(ShapeType.RANGE_CIRCLE).obtain();
/*      */       }
/*      */       
/*  891 */       tile2.drawHoveredRange(paramBatch, this.i);
/*      */     } 
/*      */ 
/*      */     
/*  895 */     tile2 = null; PlatformTile platformTile; Enemy enemy; Tower tower;
/*  896 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET) != 0.0D && 
/*  897 */       tile1 != null && tile1.type == TileType.PLATFORM && 
/*      */       
/*  899 */       (platformTile = (PlatformTile)tile1).building != null && platformTile.building.buildingType == BuildingType.TOWER && (
/*      */ 
/*      */       
/*  902 */       enemy = (tower = (Tower)platformTile.building).getTarget()) != null) {
/*      */       
/*  904 */       DrawUtils.texturedLineD(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), platformTile.center.x, platformTile.center.y, (enemy.getPosition()).x, (enemy.getPosition()).y, 1.0F, 5.0F, b, c);
/*  905 */       vector2 = enemy.getPosition();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  911 */     this.S._render.prepareBatch(paramBatch, false);
/*      */     
/*  913 */     if (vector2 != null)
/*      */     {
/*  915 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).crosshairSmall, vector2.x - 12.0F, vector2.y - 12.0F, 24.0F, 24.0F);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void applyDrawInterpolation(float paramFloat) {
/*  920 */     if (paramFloat < 0.0F) paramFloat = 0.0F; 
/*  921 */     if (paramFloat > 1.0F) paramFloat = 1.0F;  byte b;
/*      */     int i;
/*  923 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*  924 */       ((Tower[])this.towers.items)[b].applyDrawInterpolation(paramFloat);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void drawWeapons(Batch paramBatch, float paramFloat) {
/*  929 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/*  930 */       paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.21F);
/*      */     }
/*  932 */     this.towers.begin(); byte b; int i;
/*  933 */     for (b = 0, i = this.towers.size; b < i; b++) {
/*      */       Tower tower;
/*  935 */       (tower = ((Tower[])this.towers.items)[b]).drawWeapon(paramBatch, (tower.getTile()).boundingBox.minX, (tower.getTile()).boundingBox.minY, 128.0F, paramFloat);
/*      */     } 
/*  937 */     this.towers.end();
/*      */   }
/*      */   
/*      */   public final void traverseTilesInRange(Tower paramTower, ObjectFilter<Tile> paramObjectFilter) {
/*  941 */     Vector2 vector2 = (paramTower.getTile()).center;
/*  942 */     float f = paramTower.rangeInPixels;
/*  943 */     DelayedRemovalArray delayedRemovalArray = this.S.map.getMap().getAllTiles();
/*  944 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*      */       
/*  946 */       Tile tile = ((Tile[])((Array)delayedRemovalArray).items)[b];
/*  947 */       if (PMath.circleIntersectsRect(vector2.x, vector2.y, f, tile.center.x - 64.0F, tile.center.y - 64.0F, 128.0F, 128.0F) && 
/*  948 */         !paramObjectFilter.test(tile)) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void updateAbilityAvailableParticleEffect(Tower paramTower) {
/*  959 */     if (this.S._particle == null || paramTower == null)
/*      */       return; 
/*  961 */     if (!paramTower.isRegistered())
/*      */     
/*  963 */     { if (paramTower.abilityAvailableParticleEffect != null)
/*      */       
/*      */       { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  981 */         paramTower.abilityAvailableParticleEffect.allowCompletion();
/*  982 */         paramTower.abilityAvailableParticleEffect = null; return; }  } else if (paramTower.abilityAvailableParticleEffect == null) { if (paramTower.canNewAbilityBeInstalled() && paramTower.getTile() != null) { paramTower.abilityAvailableParticleEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.abilityAvailableParticleEffectPool.obtain(); paramTower.abilityAvailableParticleEffect.setPosition((paramTower.getTile()).center.x + 32.0F, (paramTower.getTile()).center.y - 42.24F); this.S._particle.addParticle((ParticleEffect)paramTower.abilityAvailableParticleEffect, false); return; }  } else if (!paramTower.canNewAbilityBeInstalled() || paramTower.getTile() == null) { paramTower.abilityAvailableParticleEffect.allowCompletion(); paramTower.abilityAvailableParticleEffect = null;
/*      */       return; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void dispose() {
/*  993 */     this.towers.begin();
/*  994 */     for (byte b = 0; b < this.towers.size; b++) {
/*  995 */       ((Tower)this.towers.get(b)).setUnregistered();
/*      */     }
/*  997 */     this.towers.end();
/*  998 */     this.towers.clear();
/*      */     
/* 1000 */     super.dispose();
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDie extends SerializableListener<TowerSystem> implements Listener<EnemyDie> {
/*      */     private OnEnemyDie() {}
/*      */     
/*      */     public OnEnemyDie(TowerSystem param1TowerSystem) {
/* 1008 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*      */       Tower tower;
/* 1014 */       if ((tower = param1EnemyDie.getLastDamage().getTower()) != null) {
/* 1015 */         Enemy enemy = param1EnemyDie.getLastDamage().getEnemy();
/* 1016 */         float f = ((TowerSystem)this.a).S.experience.addExperienceBuffed(tower, enemy.getKillExp());
/* 1017 */         ((TowerSystem)this.a).S.statistics.addStatistic(StatisticsType.XPG_EK, f);
/* 1018 */         tower.enemiesKilled++;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDieFlamethrowerPapers extends SerializableListener<TowerSystem> implements Listener<EnemyDie> { @NAGS
/* 1025 */     private final Vector2 b = new Vector2();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public OnEnemyDieFlamethrowerPapers(TowerSystem param1TowerSystem) {
/* 1031 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*      */       Tower tower;
/* 1037 */       if (tower = param1EnemyDie.getLastDamage().getTower() instanceof FlamethrowerTower) {
/*      */ 
/*      */ 
/*      */         
/* 1041 */         Enemy enemy = param1EnemyDie.getLastDamage().getEnemy();
/* 1042 */         this.b.set(enemy.getPosition());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1047 */         int i = (int)((i = (int)((i = ((TowerSystem)this.a).S.gameState.calculatePrizeGreenPapers()) / ((TowerSystem)this.a).S.statistics.getStatistic(StatisticsType.PT) * 60.0D)) / 30.0F);
/*      */         
/*      */         FlamethrowerTower flamethrowerTower;
/* 1050 */         if ((flamethrowerTower = (FlamethrowerTower)tower).isAbilityInstalled(4) && (i = ((TowerSystem)this.a).S.loot.getPapersFromFlamethrowerUltBank(i)) > 0) {
/* 1051 */           flamethrowerTower.instaKillPapersAccumulator += i;
/* 1052 */           if (flamethrowerTower.instaKillPapersAccumulator > 5) {
/* 1053 */             i = flamethrowerTower.instaKillPapersAccumulator % 5;
/*      */             
/* 1055 */             ItemStack itemStack = new ItemStack((Item)Item.D.GREEN_PAPER, flamethrowerTower.instaKillPapersAccumulator - i);
/*      */             
/* 1057 */             if (((TowerSystem)this.a).S._input != null) {
/* 1058 */               ((TowerSystem)this.a).S._input.cameraController.mapToStage(this.b);
/*      */             }
/* 1060 */             ((TowerSystem)this.a).S.gameState.addLootIssuedPrizes(itemStack, this.b.x, this.b.y, 2);
/* 1061 */             flamethrowerTower.instaKillPapersAccumulator = i;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     private OnEnemyDieFlamethrowerPapers() {} }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyTakeDamage extends SerializableListener<TowerSystem> implements Listener<EnemyTakeDamage> {
/*      */     private OnEnemyTakeDamage() {}
/*      */     
/*      */     public OnEnemyTakeDamage(TowerSystem param1TowerSystem) {
/* 1074 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyTakeDamage param1EnemyTakeDamage) {
/*      */       DamageRecord damageRecord;
/* 1080 */       Tower tower = (damageRecord = param1EnemyTakeDamage.getRecord()).getTower();
/* 1081 */       float f = damageRecord.getFactDamage();
/* 1082 */       if (tower != null && f > 0.0F) {
/*      */         
/* 1084 */         Enemy enemy = damageRecord.getEnemy();
/* 1085 */         float f1 = ((TowerSystem)this.a).S.experience.addExperienceBuffed(tower, f / enemy.maxHealth * enemy.getKillExp() * 2.0F);
/* 1086 */         ((TowerSystem)this.a).S.statistics.addStatistic(StatisticsType.XPG_EK, f1);
/*      */ 
/*      */         
/* 1089 */         if (damageRecord.isCleanForDps())
/* 1090 */           for (byte b = 0; b < tower.dpsDamage.length; b++) {
/* 1091 */             tower.dpsDamage[b] = tower.dpsDamage[b] + f;
/*      */             
/* 1093 */             if ((f1 = tower.dpsDamage[b] / 10.0F) > tower.mdps)
/* 1094 */               tower.mdps = f1; 
/*      */           }  
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnTickDisableTowersUnderEnemies
/*      */     extends SerializableListener<TowerSystem>
/*      */     implements Listener<GameStateTick> {
/*      */     private OnTickDisableTowersUnderEnemies() {}
/*      */     
/*      */     public OnTickDisableTowersUnderEnemies(TowerSystem param1TowerSystem) {
/* 1107 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(GameStateTick param1GameStateTick) {
/* 1112 */       for (byte b = 0; b < ((TowerSystem)this.a).towers.size; b++) {
/*      */         Tower tower;
/* 1114 */         if ((tower = ((Tower[])((TowerSystem)this.a).towers.items)[b]) != null) {
/*      */           PlatformTile platformTile;
/*      */           
/* 1117 */           if ((platformTile = tower.getTile()) != null && ((Tile)platformTile).enemyCount != 0) {
/* 1118 */             tower.outOfOrder.addReason("EnemyOnTop");
/*      */           } else {
/* 1120 */             tower.outOfOrder.removeReason("EnemyOnTop");
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } }
/*      */   
/*      */   @REGS
/*      */   public static final class OnTowerPlace extends SerializableListener<TowerSystem> implements Listener<TowerPlace> {
/*      */     private OnTowerPlace() {}
/*      */     
/*      */     public OnTowerPlace(TowerSystem param1TowerSystem) {
/* 1131 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(TowerPlace param1TowerPlace) {
/* 1136 */       TowerSystem.a((TowerSystem)this.a, param1TowerPlace.getTower());
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnBuildingRemove extends SerializableListener<TowerSystem> implements Listener<BuildingRemove> {
/*      */     private OnBuildingRemove() {}
/*      */     
/*      */     public OnBuildingRemove(TowerSystem param1TowerSystem) {
/* 1145 */       this.a = param1TowerSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(BuildingRemove param1BuildingRemove) {
/* 1150 */       if ((param1BuildingRemove.getBuilding()).buildingType == BuildingType.TOWER) {
/* 1151 */         TowerSystem.b((TowerSystem)this.a, (Tower)param1BuildingRemove.getBuilding());
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS(arrayLevels = 1)
/*      */   public static final class TowerAbilityCategoryRule
/*      */     implements KryoSerializable
/*      */   {
/*      */     public int categoryId;
/*      */     
/* 1164 */     public IntArray requiredXpLevels = new IntArray();
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean autoInstallSingleVariant;
/*      */ 
/*      */ 
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 1173 */       param1Output.writeInt(this.categoryId);
/* 1174 */       param1Kryo.writeObject(param1Output, this.requiredXpLevels);
/* 1175 */       param1Output.writeBoolean(this.autoInstallSingleVariant);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 1180 */       this.categoryId = param1Input.readInt();
/* 1181 */       this.requiredXpLevels = (IntArray)param1Kryo.readObject(param1Input, IntArray.class);
/* 1182 */       this.autoInstallSingleVariant = param1Input.readBoolean();
/*      */     }
/*      */     
/*      */     private TowerAbilityCategoryRule() {}
/*      */     
/*      */     public TowerAbilityCategoryRule(int param1Int, int[] param1ArrayOfint, boolean param1Boolean) {
/* 1188 */       this.categoryId = param1Int;
/* 1189 */       this.requiredXpLevels.addAll(param1ArrayOfint);
/* 1190 */       this.autoInstallSingleVariant = param1Boolean;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\TowerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */