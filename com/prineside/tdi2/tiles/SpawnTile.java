/*      */ package com.prineside.tdi2.tiles;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.EnemyGroup;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.ItemSortingType;
/*      */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*      */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ @REGS
/*      */ public final class SpawnTile extends Tile {
/*   56 */   private static final TLog c = TLog.forClass(SpawnTile.class);
/*      */   
/*   58 */   public int difficulty = 100;
/*   59 */   private Array<AllowedEnemyConfig> d = new Array(AllowedEnemyConfig.class);
/*   60 */   private ObjectSet<EnemyType> e = new ObjectSet();
/*      */   
/*      */   @NAGS
/*      */   private float f;
/*      */   @NAGS
/*      */   private ParticleEffectPool.PooledEffect g;
/*   66 */   public Array<Array<EnemyGroup.SpawnEnemyGroup>> enemySpawnQueues = new Array(Array.class);
/*      */   
/*   68 */   private static final StringBuilder h = new StringBuilder();
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*   72 */     super.write(paramKryo, paramOutput);
/*   73 */     paramOutput.writeVarInt(this.difficulty, true);
/*   74 */     paramKryo.writeObject(paramOutput, this.d);
/*   75 */     paramKryo.writeObject(paramOutput, this.e);
/*   76 */     paramKryo.writeObject(paramOutput, this.enemySpawnQueues);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*   81 */     super.read(paramKryo, paramInput);
/*   82 */     this.difficulty = paramInput.readVarInt(true);
/*   83 */     this.d = (Array<AllowedEnemyConfig>)paramKryo.readObject(paramInput, Array.class);
/*   84 */     this.e = (ObjectSet<EnemyType>)paramKryo.readObject(paramInput, ObjectSet.class);
/*   85 */     this.enemySpawnQueues = (Array<Array<EnemyGroup.SpawnEnemyGroup>>)paramKryo.readObject(paramInput, Array.class);
/*      */   }
/*      */   
/*      */   private SpawnTile() {
/*   89 */     super(TileType.SPAWN);
/*      */     
/*   91 */     for (byte b = 0; b <= 10; b++) {
/*   92 */       this.enemySpawnQueues.add(new Array(EnemyGroup.SpawnEnemyGroup.class));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*   98 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*      */     
/*  100 */     Label label1 = new Label(Game.i.localeManager.i18n.get("difficulty") + ": " + this.difficulty + "%", Game.i.assetManager.getLabelStyle(24));
/*  101 */     paramTable.add((Actor)label1).growX().row();
/*      */ 
/*      */     
/*  104 */     Table table = new Table();
/*  105 */     paramTable.add((Actor)table).padTop(8.0F).padBottom(4.0F).growX().row();
/*      */     
/*      */     Label label2;
/*  108 */     (label2 = new Label(Game.i.localeManager.i18n.get("enemy_type").toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  109 */     label2.setAlignment(8);
/*  110 */     table.add((Actor)label2).growX();
/*      */ 
/*      */     
/*  113 */     (label2 = new Label(Game.i.localeManager.i18n.get("waves").toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  114 */     label2.setAlignment(16);
/*  115 */     table.add((Actor)label2);
/*      */ 
/*      */ 
/*      */     
/*  119 */     table = new Table();
/*  120 */     paramTable.add((Actor)table).growX().row();
/*  121 */     byte b = 0;
/*  122 */     for (Array.ArrayIterator<AllowedEnemyConfig> arrayIterator = getAllowedEnemies().iterator(); arrayIterator.hasNext(); ) { AllowedEnemyConfig allowedEnemyConfig = arrayIterator.next();
/*  123 */       Table table1 = new Table();
/*  124 */       paramMapEditorItemInfoMenu.listRowBg(b++, table1);
/*  125 */       table.add((Actor)table1).growX().height(32.0F).row();
/*      */       
/*  127 */       Image image = new Image(Game.i.enemyManager.getFactory(allowedEnemyConfig.enemyType).getTexture());
/*  128 */       table1.add((Actor)image).size(24.0F).padRight(12.0F);
/*      */       
/*  130 */       Enemy.Factory factory = Game.i.enemyManager.getFactory(allowedEnemyConfig.enemyType);
/*      */       Label label4;
/*  132 */       (label4 = new Label(factory.getTitle(), Game.i.assetManager.getLabelStyle(21))).setColor(factory.getColor());
/*  133 */       table1.add((Actor)label4).left().padRight(12.0F);
/*      */       
/*  135 */       table1.add().height(1.0F).growX();
/*      */       
/*  137 */       Label label3 = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  138 */       if (allowedEnemyConfig.firstWave <= 1 && allowedEnemyConfig.lastWave <= 0) {
/*  139 */         label3.setText(Game.i.localeManager.i18n.get("spawn_tile_menu_spawns_always"));
/*  140 */         label3.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */       } else {
/*  142 */         label3.setText(allowedEnemyConfig.firstWave + " - " + ((allowedEnemyConfig.lastWave <= 0) ? "%" : (CharSequence)Integer.valueOf(allowedEnemyConfig.lastWave)));
/*      */       } 
/*  144 */       table1.add((Actor)label3); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*  150 */     Table table = new Table();
/*  151 */     paramTable.add((Actor)table).width(paramFloat).row();
/*      */     
/*  153 */     table.add();
/*      */     
/*      */     Image image;
/*  156 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  157 */     table.add((Actor)image).size(32.0F).top().left().padLeft(12.0F).padBottom(4.0F).row();
/*      */     
/*  159 */     for (Array.ArrayIterator<AllowedEnemyConfig> arrayIterator = getAllowedEnemies().iterator(); arrayIterator.hasNext(); ) { AllowedEnemyConfig allowedEnemyConfig = arrayIterator.next();
/*  160 */       Image image1 = new Image(Game.i.enemyManager.getFactory(allowedEnemyConfig.enemyType).getTexture());
/*  161 */       table.add((Actor)image1).size(32.0F).padRight(16.0F).padLeft(16.0F).padTop(4.0F);
/*      */       
/*  163 */       Label label = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  164 */       int i = StrictMath.max(allowedEnemyConfig.firstWave, 1);
/*  165 */       if (allowedEnemyConfig.lastWave <= 0) {
/*  166 */         label.setText(i + " - " + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-infinity>"));
/*      */       } else {
/*  168 */         label.setText(i + " - " + allowedEnemyConfig.lastWave);
/*      */       } 
/*  170 */       table.add((Actor)label).minWidth(100.0F).row(); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public final int generateSeedSalt() {
/*  176 */     int i = this.difficulty;
/*  177 */     for (byte b = 0; b < this.d.size; b++) {
/*  178 */       i = i * 29 + ((AllowedEnemyConfig)this.d.get(b)).enemyType.ordinal();
/*      */     }
/*      */     
/*  181 */     return i;
/*      */   }
/*      */   
/*      */   public final void addAllowedEnemy(EnemyType paramEnemyType, int paramInt1, int paramInt2) {
/*  185 */     boolean bool = false;
/*  186 */     for (byte b = 0; b < this.d.size; b++) {
/*      */       AllowedEnemyConfig allowedEnemyConfig;
/*  188 */       if ((allowedEnemyConfig = ((AllowedEnemyConfig[])this.d.items)[b]).enemyType == paramEnemyType) {
/*  189 */         allowedEnemyConfig.firstWave = paramInt1;
/*  190 */         allowedEnemyConfig.lastWave = paramInt2;
/*  191 */         bool = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  196 */     if (!bool) {
/*      */       AllowedEnemyConfig allowedEnemyConfig;
/*  198 */       (allowedEnemyConfig = new AllowedEnemyConfig()).enemyType = paramEnemyType;
/*  199 */       allowedEnemyConfig.firstWave = paramInt1;
/*  200 */       allowedEnemyConfig.lastWave = paramInt2;
/*      */       
/*  202 */       this.d.add(allowedEnemyConfig);
/*  203 */       this.e.add(paramEnemyType);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void removeAllowedEnemy(EnemyType paramEnemyType) {
/*  208 */     if (this.e.contains(paramEnemyType)) {
/*  209 */       this.e.remove(paramEnemyType);
/*      */       
/*  211 */       for (byte b = 0; b < this.d.size; b++) {
/*      */         AllowedEnemyConfig allowedEnemyConfig;
/*  213 */         if ((allowedEnemyConfig = ((AllowedEnemyConfig[])this.d.items)[b]).enemyType == paramEnemyType) {
/*  214 */           this.d.removeIndex(b);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AllowedEnemyConfig getEnemyConfig(EnemyType paramEnemyType) {
/*  225 */     for (byte b = 0; b < this.d.size; b++) {
/*  226 */       if ((((AllowedEnemyConfig[])this.d.items)[b]).enemyType == paramEnemyType) {
/*  227 */         return ((AllowedEnemyConfig[])this.d.items)[b];
/*      */       }
/*      */     } 
/*      */     
/*  231 */     return null;
/*      */   }
/*      */   
/*      */   public final void setAllowedEnemies(Array<AllowedEnemyConfig> paramArray) {
/*  235 */     this.d.clear();
/*  236 */     this.d.addAll(paramArray);
/*      */     
/*  238 */     this.e.clear();
/*  239 */     for (byte b = 0; b < paramArray.size; b++) {
/*  240 */       this.e.add(((AllowedEnemyConfig)paramArray.get(b)).enemyType);
/*      */     }
/*      */   }
/*      */   
/*      */   public final Array<AllowedEnemyConfig> getAllowedEnemies() {
/*  245 */     return this.d;
/*      */   }
/*      */   
/*      */   public final ObjectSet<EnemyType> getAllowedEnemiesSet() {
/*  249 */     return this.e;
/*      */   }
/*      */   
/*      */   public final boolean isEnemyAllowedOnWave(EnemyType paramEnemyType, int paramInt) {
/*  253 */     if (this.e.contains(paramEnemyType)) {
/*  254 */       for (byte b = 0; b < this.d.size; b++) {
/*      */         AllowedEnemyConfig allowedEnemyConfig;
/*  256 */         if ((allowedEnemyConfig = ((AllowedEnemyConfig[])this.d.items)[b]).enemyType == paramEnemyType) {
/*  257 */           return (paramInt >= allowedEnemyConfig.firstWave && (paramInt <= allowedEnemyConfig.lastWave || allowedEnemyConfig.lastWave <= 0));
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  262 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final RarityType getRarity() {
/*  267 */     if (this.difficulty >= 450 || this.difficulty < 60) {
/*  268 */       return RarityType.LEGENDARY;
/*      */     }
/*  270 */     if (this.difficulty >= 350 || this.difficulty < 70) {
/*  271 */       return RarityType.EPIC;
/*      */     }
/*  273 */     if (this.difficulty >= 250 || this.difficulty < 80) {
/*  274 */       return RarityType.VERY_RARE;
/*      */     }
/*  276 */     if (this.difficulty >= 150 || this.difficulty < 90) {
/*  277 */       return RarityType.RARE;
/*      */     }
/*      */     
/*  280 */     return RarityType.COMMON;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getWalkCost(boolean paramBoolean) {
/*  285 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ItemSubcategoryType getInventorySubcategory() {
/*  290 */     return ItemSubcategoryType.ME_SPAWNS;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void from(Tile paramTile) {
/*  295 */     super.from(paramTile);
/*  296 */     paramTile = paramTile;
/*      */     
/*  298 */     Array<AllowedEnemyConfig> array = new Array();
/*  299 */     for (byte b = 0; b < ((SpawnTile)paramTile).d.size; b++) {
/*  300 */       AllowedEnemyConfig allowedEnemyConfig = ((AllowedEnemyConfig[])((SpawnTile)paramTile).d.items)[b];
/*  301 */       array.add(new AllowedEnemyConfig(allowedEnemyConfig.enemyType, allowedEnemyConfig.firstWave, allowedEnemyConfig.lastWave));
/*      */     } 
/*  303 */     setAllowedEnemies(array);
/*      */     
/*  305 */     this.difficulty = ((SpawnTile)paramTile).difficulty;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getValue() {
/*  310 */     return this.difficulty * 0.01F;
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
/*      */   public final void addSellItems(Array<ItemStack> paramArray) {
/*      */     float f;
/*  332 */     if (this.difficulty < 100) {
/*  333 */       f = 100.0F - (this.difficulty - 50) * 2.0F;
/*      */     } else {
/*  335 */       f = (this.difficulty - 100) / 4.0F;
/*      */     } 
/*      */     
/*  338 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 200 + MathUtils.ceil((float)StrictMath.pow((f * 3.0F), 1.2999999523162842D))));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final double getPrestigeScore() {
/*  344 */     double d2, d1 = this.difficulty / 500.0D * 0.8D;
/*  345 */     if (this.difficulty > 400) {
/*  346 */       d1 += 0.2D;
/*  347 */     } else if (this.difficulty > 300) {
/*  348 */       d1 += 0.125D;
/*  349 */     } else if (this.difficulty > 200) {
/*  350 */       d1 += 0.05D;
/*  351 */     } else if (this.difficulty > 100) {
/*  352 */       d1 += 0.02D;
/*      */     } 
/*      */ 
/*      */     
/*  356 */     if (this.d.size <= 2) {
/*  357 */       d2 = 0.15D;
/*  358 */     } else if (this.d.size == 3) {
/*  359 */       d2 = 0.25D;
/*  360 */     } else if (this.d.size == 4) {
/*  361 */       d2 = 0.4D;
/*  362 */     } else if (this.d.size == 5) {
/*  363 */       d2 = 0.6D;
/*      */     } else {
/*  365 */       d2 = 0.85D;
/*      */     } 
/*      */     
/*  368 */     for (byte b = 0; b < this.d.size; b++) {
/*      */       EnemyType enemyType;
/*  370 */       if ((enemyType = (((AllowedEnemyConfig[])this.d.items)[b]).enemyType) == EnemyType.ARMORED || enemyType == EnemyType.HEALER) {
/*  371 */         d2 += 0.075D;
/*  372 */       } else if (enemyType == EnemyType.LIGHT || enemyType == EnemyType.ICY) {
/*  373 */         d2 += 0.05D;
/*      */       } 
/*      */     } 
/*      */     
/*  377 */     return 0.01D + d1 * d2;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean canBeUpgraded() {
/*  382 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/*  387 */     if (paramItemSortingType == ItemSortingType.KIND) {
/*  388 */       return 5000 + this.difficulty;
/*      */     }
/*  390 */     if (this.difficulty < 100) {
/*  391 */       return getRarity().ordinal() * 1000 + 100 - this.difficulty;
/*      */     }
/*  393 */     return getRarity().ordinal() * 1000 + this.difficulty;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isRoadType() {
/*  400 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setUnregistered() {
/*  406 */     if (this.g != null) {
/*  407 */       this.g.allowCompletion();
/*  408 */       this.g = null;
/*      */     } 
/*      */     
/*  411 */     this.enemySpawnQueues.clear();
/*      */     
/*  413 */     super.setUnregistered();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/*  418 */     paramFloat4 *= 0.0078125F;
/*  419 */     paramFloat5 *= 0.0078125F;
/*      */     
/*  421 */     boolean bool = true;
/*  422 */     if (this.S != null) {
/*      */       
/*  424 */       bool = false;
/*  425 */       Array array = (Array)this.enemySpawnQueues.get(0);
/*  426 */       for (byte b = 0; b < array.size; b++) {
/*  427 */         if (((EnemyGroup.SpawnEnemyGroup)array.get(b)).count - ((EnemyGroup.SpawnEnemyGroup)array.get(b)).getSpawnedCount() != 0) {
/*      */           
/*  429 */           bool = true;
/*      */           break;
/*      */         } 
/*      */       } 
/*  433 */       if (!bool)
/*      */       {
/*  435 */         if (((Array)this.enemySpawnQueues.get(1)).size != 0)
/*      */         {
/*  437 */           bool = true;
/*      */         }
/*      */       }
/*      */     } 
/*  441 */     if (bool && this.S != null) {
/*      */       
/*  443 */       if (Game.i.settingsManager.isParticlesDrawing()) {
/*  444 */         if (this.g == null) {
/*  445 */           this.g = (ParticleEffectPool.PooledEffect)Game.i.tileManager.F.SPAWN.e.obtain();
/*  446 */           this.g.setPosition(this.center.x, this.center.y);
/*  447 */           this.S._particle.addParticle((ParticleEffect)this.g, false);
/*      */         }
/*      */       
/*      */       }
/*  451 */       else if (this.g != null) {
/*  452 */         this.g.allowCompletion();
/*  453 */         this.g = null;
/*      */       }
/*      */     
/*  456 */     } else if (this.S != null) {
/*      */       
/*  458 */       if (this.g != null) {
/*  459 */         this.g.allowCompletion();
/*  460 */         this.g = null;
/*      */       } 
/*      */     } 
/*      */     
/*  464 */     this.f += paramFloat1;
/*  465 */     float f = this.f % 8.0F * 360.0F / 8.0F;
/*  466 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*  467 */     if (bool) {
/*  468 */       paramBatch.draw(Game.i.tileManager.F.SPAWN.b, paramFloat2, paramFloat3, 64.0F * paramFloat4, 64.0F * paramFloat5, 128.0F * paramFloat4, 128.0F * paramFloat5, 1.0F, 1.0F, f);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  480 */       paramBatch.draw(Game.i.tileManager.F.SPAWN.a, paramFloat2, paramFloat3, 128.0F * paramFloat4, 128.0F * paramFloat4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  488 */       if (this.S != null) {
/*  489 */         paramBatch.setColor(1.0F, 1.0F, 1.0F, (PMath.sin(this.f) + 1.0F) * 0.25F + 0.25F);
/*  490 */         paramBatch.draw(Game.i.tileManager.F.SPAWN.c, paramFloat2, paramFloat3, 128.0F * paramFloat4, 128.0F * paramFloat5);
/*      */       } 
/*      */     } else {
/*  493 */       paramBatch.draw(Game.i.tileManager.F.SPAWN.d, paramFloat2, paramFloat3, 128.0F * paramFloat4, 128.0F * paramFloat5);
/*      */     } 
/*  495 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     
/*  497 */     if (paramDrawMode == MapRenderingSystem.DrawMode.FULL || paramDrawMode == MapRenderingSystem.DrawMode.DETAILED || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/*      */       int k;
/*      */       
/*  500 */       if ((k = (int)(21.0F * paramFloat4)) >= 12) {
/*  501 */         ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(k);
/*  502 */         h.setLength(0);
/*  503 */         h.append(this.difficulty).append('%');
/*  504 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)h, paramFloat2 + 10.0F * paramFloat4, paramFloat3 + 29.0F * paramFloat5);
/*      */       } 
/*      */ 
/*      */       
/*      */       int i;
/*      */       
/*  510 */       if ((i = this.d.size) > 4) i = 4; 
/*  511 */       int j = this.d.size / 4 + 1;
/*  512 */       float f1 = (128.0F - 24.0F * i) * 0.5F;
/*  513 */       float f2 = j * 24.0F;
/*  514 */       f2 = (128.0F - f2) * 0.5F;
/*      */       
/*  516 */       for (byte b = 0; b < this.d.size; b++) {
/*  517 */         k = b % 4;
/*  518 */         float f3 = f1 + k * 24.0F - 4.0F;
/*  519 */         float f4 = f2 + (j - b / 4 + 1) * 24.0F - 4.0F;
/*      */         
/*  521 */         TextureRegion textureRegion = Game.i.enemyManager.getFactory((((AllowedEnemyConfig[])this.d.items)[b]).enemyType).getTexture();
/*  522 */         paramBatch.draw(textureRegion, paramFloat2 + (f3 + 6.0F) * paramFloat4, paramFloat3 + (f4 + 6.0F) * paramFloat5, 20.0F * paramFloat4, 20.0F * paramFloat5);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Group generateUiIcon(float paramFloat) {
/*  623 */     float f = paramFloat / 128.0F;
/*      */     
/*      */     Group group;
/*  626 */     (group = new Group()).setTransform(false);
/*      */     
/*      */     Image image;
/*  629 */     (image = new Image(Game.i.tileManager.getRoadTexture(null, null, null, null))).setSize(paramFloat, paramFloat);
/*  630 */     group.addActor((Actor)image);
/*      */ 
/*      */     
/*  633 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.SPAWN.b))).setSize(paramFloat, paramFloat);
/*  634 */     group.addActor((Actor)image);
/*      */ 
/*      */     
/*  637 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.SPAWN.a))).setSize(paramFloat, paramFloat);
/*  638 */     group.addActor((Actor)image);
/*      */ 
/*      */     
/*  641 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.SPAWN.c))).setSize(paramFloat, paramFloat);
/*  642 */     image.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  643 */     group.addActor((Actor)image);
/*      */ 
/*      */     
/*  646 */     h.setLength(0);
/*  647 */     h.append(this.difficulty).append('%');
/*      */     Label label;
/*  649 */     (label = new Label((CharSequence)h, Game.i.assetManager.getLabelStyle(MathUtils.round(24.0F * f)))).setPosition(10.0F, 8.0F);
/*  650 */     group.addActor((Actor)label);
/*      */     
/*      */     Table table;
/*      */     
/*  654 */     (table = new Table()).setSize(paramFloat, paramFloat - 24.0F * f);
/*  655 */     table.setPosition(0.0F, 24.0F * f);
/*  656 */     group.addActor((Actor)table);
/*      */     
/*  658 */     for (byte b = 0; b < this.d.size; b++) {
/*  659 */       Image image1 = new Image(Game.i.enemyManager.getFactory((((AllowedEnemyConfig[])this.d.items)[b]).enemyType).getTexture());
/*  660 */       Cell cell = table.add((Actor)image1).size(20.0F * f, 20.0F * f).pad(f * 2.0F);
/*  661 */       if (b % 4 == 3) cell.row();
/*      */     
/*      */     } 
/*  664 */     return group;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void toJson(Json paramJson) {
/*  669 */     super.toJson(paramJson);
/*      */     
/*  671 */     paramJson.writeObjectStart("d");
/*  672 */     paramJson.writeValue("d", Integer.valueOf(this.difficulty));
/*  673 */     paramJson.writeArrayStart("ae");
/*  674 */     for (byte b = 0; b < this.d.size; b++) {
/*  675 */       AllowedEnemyConfig allowedEnemyConfig = (AllowedEnemyConfig)this.d.get(b);
/*  676 */       paramJson.writeObjectStart();
/*  677 */       paramJson.writeValue("t", allowedEnemyConfig.enemyType.name());
/*  678 */       paramJson.writeValue("f", Integer.valueOf(allowedEnemyConfig.firstWave));
/*  679 */       paramJson.writeValue("l", Integer.valueOf(allowedEnemyConfig.lastWave));
/*  680 */       paramJson.writeObjectEnd();
/*      */     } 
/*  682 */     paramJson.writeArrayEnd();
/*  683 */     paramJson.writeObjectEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean sameAs(Tile paramTile) {
/*  688 */     if (!super.sameAs(paramTile)) return false;
/*      */ 
/*      */ 
/*      */     
/*  692 */     if (((SpawnTile)(paramTile = paramTile)).difficulty != this.difficulty) return false; 
/*  693 */     if (((SpawnTile)paramTile).d.size != this.d.size) return false;
/*      */     
/*  695 */     for (byte b = 0; b < this.d.size; b++) {
/*  696 */       AllowedEnemyConfig allowedEnemyConfig = ((AllowedEnemyConfig[])this.d.items)[b];
/*  697 */       if (!((SpawnTile)paramTile).e.contains(allowedEnemyConfig.enemyType))
/*      */       {
/*  699 */         return false;
/*      */       }
/*      */       
/*  702 */       for (byte b1 = 0; b1 < ((SpawnTile)paramTile).d.size; b1++) {
/*      */         AllowedEnemyConfig allowedEnemyConfig1;
/*  704 */         if ((allowedEnemyConfig1 = ((AllowedEnemyConfig[])((SpawnTile)paramTile).d.items)[b1]).enemyType == allowedEnemyConfig.enemyType) {
/*  705 */           if (allowedEnemyConfig1.firstWave != allowedEnemyConfig.firstWave || allowedEnemyConfig1.lastWave != allowedEnemyConfig.lastWave) {
/*  706 */             return false;
/*      */           }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  714 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/*  719 */     paramItemCreationOverlay.label("Difficulty");
/*  720 */     paramItemCreationOverlay.textField(String.valueOf(this.difficulty), paramString -> {
/*      */           try {
/*      */             this.difficulty = Integer.parseInt(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */             return;
/*  724 */           } catch (Exception exception) {
/*      */             c.e("bad value: " + paramString, new Object[0]);
/*      */             return;
/*      */           } 
/*      */         });
/*  729 */     paramItemCreationOverlay.label("Allowed enemies");
/*  730 */     Table table = new Table();
/*  731 */     paramItemCreationOverlay.form.add((Actor)table).top().left().row(); EnemyType[] arrayOfEnemyType; int i; byte b;
/*  732 */     for (i = (arrayOfEnemyType = EnemyType.mainEnemyTypes).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/*  733 */       Image image = new Image(Game.i.enemyManager.getFactory(enemyType).getTexture());
/*  734 */       table.add((Actor)image).size(32.0F).pad(8.0F).padRight(12.0F);
/*      */       
/*  736 */       LabelToggleButton labelToggleButton = paramItemCreationOverlay.toggle(false, Game.i.enemyManager.getFactory(enemyType).getTitle(), getAllowedEnemiesSet().contains(enemyType), paramBoolean -> {
/*      */             if (paramBoolean.booleanValue()) {
/*      */               addAllowedEnemy(paramEnemyType, 1, 0);
/*      */             } else {
/*      */               removeAllowedEnemy(paramEnemyType);
/*      */             } 
/*      */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */             paramItemCreationOverlay.updateForm();
/*      */           });
/*  745 */       table.add((Actor)labelToggleButton).height(48.0F).width(400.0F).padLeft(16.0F).padBottom(4.0F);
/*      */       
/*  747 */       AllowedEnemyConfig allowedEnemyConfig = getEnemyConfig(enemyType);
/*      */       
/*  749 */       TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform((allowedEnemyConfig == null) ? "1" : String.valueOf(allowedEnemyConfig.firstWave), paramItemCreationOverlay.textFieldStyle);
/*  750 */       table.add((Actor)textFieldXPlatform2).size(100.0F, 48.0F).padLeft(16.0F);
/*  751 */       textFieldXPlatform2.addListener((EventListener)new ChangeListener(this, textFieldXPlatform2, enemyType, labelToggleButton)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*      */                 int i;
/*  756 */                 if ((i = Integer.parseInt(this.a.getText())) > 0)
/*      */                 { SpawnTile.AllowedEnemyConfig allowedEnemyConfig;
/*  758 */                   if ((allowedEnemyConfig = this.d.getEnemyConfig(this.b)) == null)
/*  759 */                   { this.d.addAllowedEnemy(this.b, i, 0);
/*  760 */                     this.c.setEnabled(true); }
/*      */                   else
/*  762 */                   { allowedEnemyConfig.firstWave = i; return; }  }
/*      */                 else { return; }
/*      */               
/*  765 */               } catch (Exception exception) {}
/*      */             }
/*      */           });
/*      */       
/*  769 */       TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform((allowedEnemyConfig == null) ? "0" : String.valueOf(allowedEnemyConfig.lastWave), paramItemCreationOverlay.textFieldStyle);
/*  770 */       table.add((Actor)textFieldXPlatform1).size(100.0F, 48.0F).padLeft(16.0F).row();
/*  771 */       textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, textFieldXPlatform1, enemyType, labelToggleButton)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*      */                 int i;
/*  776 */                 if ((i = Integer.parseInt(this.a.getText())) >= 0)
/*      */                 { SpawnTile.AllowedEnemyConfig allowedEnemyConfig;
/*  778 */                   if ((allowedEnemyConfig = this.d.getEnemyConfig(this.b)) == null)
/*  779 */                   { this.d.addAllowedEnemy(this.b, 1, i);
/*  780 */                     this.c.setEnabled(true); }
/*      */                   else
/*  782 */                   { allowedEnemyConfig.lastWave = i; return; }  }
/*      */                 else { return; }
/*      */               
/*  785 */               } catch (Exception exception) {}
/*      */             }
/*      */           });
/*      */       b++; }
/*      */   
/*      */   }
/*      */   
/*      */   public static class SpawnTileFactory extends Tile.Factory.AbstractFactory<SpawnTile> { TextureRegion a;
/*      */     TextureRegion b;
/*      */     TextureRegion c;
/*      */     TextureRegion d;
/*      */     ParticleEffectPool e;
/*      */     
/*      */     public SpawnTileFactory() {
/*  799 */       super(TileType.SPAWN);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/*      */       int i;
/*  805 */       if ((i = param1InventoryStatistics.byTileType[TileType.SPAWN.ordinal()]) == 0)
/*  806 */         return 1000; 
/*  807 */       if (i > 500) {
/*  808 */         return 0;
/*      */       }
/*  810 */       return 50;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setupAssets() {
/*  816 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-spawn-overlay");
/*  817 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-spawn-portal");
/*  818 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-spawn-glow");
/*  819 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-spawn-inactive");
/*      */       
/*  821 */       this.e = Game.i.assetManager.getParticleEffectPool("portal.prt");
/*      */     }
/*      */ 
/*      */     
/*      */     public SpawnTile create() {
/*  826 */       return new SpawnTile((byte)0);
/*      */     }
/*      */     
/*      */     public SpawnTile createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/*      */       char c1, c2;
/*  831 */       if (param1RandomXS128 == null) {
/*  832 */         param1RandomXS128 = FastRandom.random;
/*      */       }
/*      */       
/*  835 */       SpawnTile spawnTile = create();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  840 */       RarityType rarityType = ProgressManager.getRarityFromQuality(param1Float);
/*  841 */       if (param1RandomXS128.nextFloat() < 0.5F) {
/*      */         
/*  843 */         switch (SpawnTile.null.a[rarityType.ordinal()]) {
/*      */           case 1:
/*  845 */             c1 = '2';
/*  846 */             c2 = ';';
/*      */             break;
/*      */           
/*      */           case 2:
/*  850 */             c1 = '<';
/*  851 */             c2 = 'E';
/*      */             break;
/*      */           
/*      */           case 3:
/*  855 */             c1 = 'F';
/*  856 */             c2 = 'O';
/*      */             break;
/*      */           
/*      */           case 4:
/*  860 */             c1 = 'P';
/*  861 */             c2 = 'Y';
/*      */             break;
/*      */           
/*      */           default:
/*  865 */             c1 = 'Z';
/*  866 */             c2 = 'd';
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       } else {
/*  872 */         switch (SpawnTile.null.a[c1.ordinal()]) {
/*      */           case 1:
/*  874 */             c1 = 'ǁ';
/*  875 */             c2 = 'Ǵ';
/*      */             break;
/*      */           
/*      */           case 2:
/*  879 */             c1 = 'Ş';
/*  880 */             c2 = 'ǁ';
/*      */             break;
/*      */           
/*      */           case 3:
/*  884 */             c1 = 'ú';
/*  885 */             c2 = 'ŝ';
/*      */             break;
/*      */           
/*      */           case 4:
/*  889 */             c1 = '';
/*  890 */             c2 = 'ù';
/*      */             break;
/*      */           
/*      */           default:
/*  894 */             c1 = 'd';
/*  895 */             c2 = '';
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       } 
/*  901 */       spawnTile.difficulty = c1 + MathUtils.round((c2 - c1) * param1RandomXS128.nextFloat());
/*      */       
/*  903 */       if (spawnTile.difficulty < 150) {
/*  904 */         spawnTile.difficulty -= spawnTile.difficulty % 5;
/*  905 */       } else if (spawnTile.difficulty > 495) {
/*  906 */         spawnTile.difficulty = 500;
/*      */       } else {
/*  908 */         spawnTile.difficulty -= spawnTile.difficulty % 10;
/*      */       } 
/*      */       
/*      */       Array<SpawnTile.AllowedEnemyConfig> array;
/*  912 */       (array = new Array(SpawnTile.AllowedEnemyConfig.class)).add(new SpawnTile.AllowedEnemyConfig(EnemyType.REGULAR, 1, 0));
/*  913 */       array.add(new SpawnTile.AllowedEnemyConfig(EnemyType.BOSS, 1, 0));
/*  914 */       int i = 4 + StrictMath.round(param1RandomXS128.nextFloat() * param1Float * 3.0F);
/*  915 */       while (i > 0) {
/*  916 */         EnemyType enemyType = EnemyType.mainEnemyTypes[param1RandomXS128.nextInt(EnemyType.mainEnemyTypes.length)];
/*  917 */         boolean bool = false;
/*  918 */         for (byte b = 0; b < array.size; b++) {
/*  919 */           if ((((SpawnTile.AllowedEnemyConfig[])array.items)[b]).enemyType == enemyType) {
/*  920 */             bool = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*  924 */         if (!bool) {
/*  925 */           i--;
/*  926 */           array.add(new SpawnTile.AllowedEnemyConfig(enemyType, 1, 0));
/*      */         } 
/*      */       } 
/*  929 */       Threads.sortGdxArray(array, (param1AllowedEnemyConfig1, param1AllowedEnemyConfig2) -> Integer.compare(param1AllowedEnemyConfig1.enemyType.ordinal(), param1AllowedEnemyConfig2.enemyType.ordinal()));
/*  930 */       spawnTile.setAllowedEnemies(array);
/*      */       
/*  932 */       return spawnTile;
/*      */     }
/*      */ 
/*      */     
/*      */     public SpawnTile fromJson(JsonValue param1JsonValue) {
/*  937 */       SpawnTile spawnTile = (SpawnTile)super.fromJson(param1JsonValue);
/*      */       
/*  939 */       if (param1JsonValue.has("d")) {
/*      */         JsonValue jsonValue;
/*      */ 
/*      */ 
/*      */         
/*  944 */         if ((jsonValue = (param1JsonValue = param1JsonValue.get("d")).get("et")) != null) {
/*  945 */           Array<SpawnTile.AllowedEnemyConfig> array = new Array();
/*  946 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  947 */             array.add(new SpawnTile.AllowedEnemyConfig(EnemyType.valueOf(jsonValue1.asString()), 1, 0)); }
/*      */           
/*  949 */           spawnTile.setAllowedEnemies(array);
/*      */         
/*      */         }
/*      */         else {
/*      */           
/*  954 */           jsonValue = param1JsonValue.get("ae");
/*  955 */           Array<SpawnTile.AllowedEnemyConfig> array = new Array();
/*  956 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  957 */             SpawnTile.AllowedEnemyConfig allowedEnemyConfig = new SpawnTile.AllowedEnemyConfig(EnemyType.valueOf(jsonValue1.getString("t")), jsonValue1.getInt("f", 1), jsonValue1.getInt("l", 0));
/*      */ 
/*      */ 
/*      */             
/*  961 */             array.add(allowedEnemyConfig); }
/*      */ 
/*      */           
/*  964 */           if (array.size == 0) {
/*      */             
/*  966 */             SpawnTile.AllowedEnemyConfig allowedEnemyConfig = new SpawnTile.AllowedEnemyConfig(EnemyType.REGULAR, 1, 0);
/*  967 */             array.add(allowedEnemyConfig);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  973 */           spawnTile.setAllowedEnemies(array);
/*      */         } 
/*      */         
/*  976 */         spawnTile.difficulty = param1JsonValue.getInt("d", 100);
/*  977 */         if (spawnTile.difficulty <= 0) spawnTile.difficulty = 1; 
/*  978 */         if (spawnTile.difficulty > 65535) spawnTile.difficulty = 65535;
/*      */       
/*      */       } 
/*  981 */       return spawnTile;
/*      */     } }
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static class AllowedEnemyConfig implements KryoSerializable {
/*      */     public EnemyType enemyType;
/*  988 */     public int firstWave = 1;
/*  989 */     public int lastWave = 0;
/*      */ 
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/*  993 */       param1Kryo.writeObjectOrNull(param1Output, this.enemyType, EnemyType.class);
/*  994 */       param1Output.writeVarInt(this.firstWave, true);
/*  995 */       param1Output.writeInt(this.lastWave);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/* 1000 */       this.enemyType = (EnemyType)param1Kryo.readObjectOrNull(param1Input, EnemyType.class);
/* 1001 */       this.firstWave = param1Input.readVarInt(true);
/* 1002 */       this.lastWave = param1Input.readInt();
/*      */     }
/*      */ 
/*      */     
/*      */     public AllowedEnemyConfig() {}
/*      */ 
/*      */     
/*      */     public AllowedEnemyConfig(EnemyType param1EnemyType, int param1Int1, int param1Int2) {
/* 1010 */       this.enemyType = param1EnemyType;
/* 1011 */       this.firstWave = param1Int1;
/* 1012 */       this.lastWave = param1Int2;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\SpawnTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */