/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.BossTileType;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class BossTile extends Tile {
/*  49 */   private static final TLog c = TLog.forClass(BossTile.class);
/*     */ 
/*     */   
/*  52 */   private static Array<GameValueConfig> d = new Array((Object[])new GameValueConfig[] { new GameValueConfig(GameValueType.SCORE, -50.0D, false, true), new GameValueConfig(GameValueType.MINERS_SPEED, -25.0D, false, true), new GameValueConfig(GameValueType.LOOT_RARITY, -10.0D, false, true) });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final BossWavesConfig e = new BossWavesConfig(1, 1, 0, new Array());
/*     */ 
/*     */   
/*  60 */   private static Array<GameValueConfig> f = new Array((Object[])new GameValueConfig[] { new GameValueConfig(GameValueType.SCORE, -25.0D, false, true), new GameValueConfig(GameValueType.MINERS_SPEED, -10.0D, false, true) });
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static BossWavesConfig g = new BossWavesConfig(300, 0, 0, new Array((Object[])new BossTypeWavePair[] { new BossTypeWavePair(40, BossType.BROOT), new BossTypeWavePair(90, BossType.SNAKE), new BossTypeWavePair(150, BossType.CONSTRUCTOR), new BossTypeWavePair(220, BossType.MOBCHAIN), new BossTypeWavePair(300, BossType.METAPHOR) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static Array<GameValueConfig> h = new Array((Object[])new GameValueConfig[] { new GameValueConfig(GameValueType.SCORE, 10.0D, false, true), new GameValueConfig(GameValueType.LOOT_RARITY, 10.0D, false, true) });
/*     */ 
/*     */ 
/*     */   
/*  77 */   private static BossWavesConfig i = new BossWavesConfig(50, 0, 10, new Array((Object[])new BossTypeWavePair[] { new BossTypeWavePair(10, BossType.BROOT), new BossTypeWavePair(20, BossType.SNAKE), new BossTypeWavePair(30, BossType.CONSTRUCTOR), new BossTypeWavePair(40, BossType.MOBCHAIN), new BossTypeWavePair(50, BossType.METAPHOR) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   private static Array<GameValueConfig> j = new Array((Object[])new GameValueConfig[] { new GameValueConfig(GameValueType.SCORE, -25.0D, false, true), new GameValueConfig(GameValueType.MINERS_SPEED, -10.0D, false, true), new GameValueConfig(GameValueType.LOOT_RARITY, -10.0D, false, true) });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   private static BossWavesConfig[] k = new BossWavesConfig[(BossType.values()).length]; static { BossType[] arrayOfBossType; int i;
/*     */     byte b;
/*  93 */     for (i = (arrayOfBossType = BossType.values).length, b = 0; b < i; ) { BossType bossType = arrayOfBossType[b];
/*  94 */       k[bossType.ordinal()] = new BossWavesConfig(20, 0, 0, new Array((Object[])new BossTypeWavePair[] { new BossTypeWavePair(20, bossType) }));
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */     
/* 101 */     (l = new Color[BossType.values.length])[BossType.BROOT.ordinal()] = MaterialColor.ORANGE.P600;
/* 102 */     l[BossType.SNAKE.ordinal()] = MaterialColor.LIGHT_GREEN.P600;
/* 103 */     l[BossType.METAPHOR.ordinal()] = MaterialColor.RED.P600;
/* 104 */     l[BossType.CONSTRUCTOR.ordinal()] = MaterialColor.BLUE_GREY.P500;
/* 105 */     l[BossType.MOBCHAIN.ordinal()] = MaterialColor.DEEP_PURPLE.P400; }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Color[] l;
/* 110 */   private BossTileType m = BossTileType.NO;
/*     */ 
/*     */   
/* 113 */   public BossType oneBossType = BossType.BROOT;
/*     */ 
/*     */   
/* 116 */   public Array<GameValueConfig> customEffects = new Array(GameValueConfig.class);
/* 117 */   public BossWavesConfig customBossWaveConfig = new BossWavesConfig((byte)0);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 121 */     super.write(paramKryo, paramOutput);
/* 122 */     paramKryo.writeObject(paramOutput, this.m);
/* 123 */     paramKryo.writeObject(paramOutput, this.oneBossType);
/* 124 */     paramKryo.writeObject(paramOutput, this.customEffects);
/* 125 */     paramKryo.writeObject(paramOutput, this.customBossWaveConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 130 */     super.read(paramKryo, paramInput);
/* 131 */     this.m = (BossTileType)paramKryo.readObject(paramInput, BossTileType.class);
/* 132 */     this.oneBossType = (BossType)paramKryo.readObject(paramInput, BossType.class);
/* 133 */     this.customEffects = (Array<GameValueConfig>)paramKryo.readObject(paramInput, Array.class);
/* 134 */     this.customBossWaveConfig = (BossWavesConfig)paramKryo.readObject(paramInput, BossWavesConfig.class);
/*     */   }
/*     */   
/*     */   private BossTile() {
/* 138 */     super(TileType.BOSS);
/*     */   }
/*     */   
/*     */   private BossTile(BossTileType paramBossTileType) {
/* 142 */     super(TileType.BOSS);
/*     */     
/* 144 */     setBossTileType(paramBossTileType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     Label label;
/* 150 */     (label = new Label(getBossTileTypeName(), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500);
/* 151 */     label.setWrap(true);
/* 152 */     label.setAlignment(1);
/* 153 */     paramTable.add((Actor)label).width(paramFloat).row();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 158 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/*     */     Label label1;
/* 161 */     (label1 = new Label(getBossTileTypeName(), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500);
/* 162 */     paramTable.add((Actor)label1).growX().row();
/*     */ 
/*     */ 
/*     */     
/* 166 */     (label1 = new Label(Game.i.localeManager.i18n.get("effects").toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 167 */     label1.setAlignment(8);
/* 168 */     paramTable.add((Actor)label1).padTop(8.0F).padBottom(4.0F).growX().row();
/*     */     
/*     */     Array<GameValueConfig> array;
/* 171 */     if ((array = getGameValues()).size != 0) {
/* 172 */       StringBuilder stringBuilder = new StringBuilder();
/* 173 */       for (byte b = 0; b < array.size; b++) {
/* 174 */         GameValueConfig gameValueConfig = (GameValueConfig)array.get(b);
/* 175 */         GameValueManager.GameValueStockConfig gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType());
/*     */         
/* 177 */         Table table = new Table();
/* 178 */         paramMapEditorItemInfoMenu.listRowBg(b, table);
/* 179 */         paramTable.add((Actor)table).height(32.0F).growX().row();
/*     */         
/* 181 */         table.add((Actor)new Image((Drawable)gameValueStockConfig.getIcon())).size(24.0F).padRight(8.0F);
/*     */         
/* 183 */         float f = paramTable.getWidth() - 32.0F;
/*     */         LimitedWidthLabel limitedWidthLabel;
/* 185 */         (limitedWidthLabel = new LimitedWidthLabel((CharSequence)Game.i.gameValueManager.getTitle(gameValueConfig.getType()), 21, 18, f * 0.75F)).setAlignment(8);
/* 186 */         table.add((Actor)limitedWidthLabel).growX();
/*     */         
/* 188 */         stringBuilder.setLength(0);
/*     */         GameValueManager.ValueUnits valueUnits;
/* 190 */         if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units) == GameValueManager.ValueUnits.BOOLEAN) {
/*     */           
/* 192 */           if (gameValueConfig.getValue() == 0.0D)
/*     */           {
/* 194 */             stringBuilder.append(Game.i.localeManager.i18n.get("disabled").toLowerCase(Locale.ENGLISH));
/*     */           }
/*     */         } else {
/* 197 */           stringBuilder.append(Game.i.gameValueManager.formatEffectValue(gameValueConfig.getValue(), valueUnits));
/* 198 */           if (gameValueConfig.isOverwrite()) {
/* 199 */             stringBuilder.setCharAt(0, '=');
/* 200 */             stringBuilder.insert(1, ' ');
/*     */           } 
/*     */         } 
/* 203 */         table.add((Actor)new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(21)));
/*     */       } 
/*     */     } else {
/*     */       Label label;
/* 207 */       (label = new Label(Game.i.localeManager.i18n.get("tile_has_no_effects"), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 208 */       paramTable.add((Actor)label).height(32.0F).padBottom(4.0F).growX().row();
/*     */     } 
/*     */ 
/*     */     
/*     */     BossWavesConfig bossWavesConfig;
/*     */     
/* 214 */     if ((bossWavesConfig = getBossWavesConfig()).bossWavePairs.size > 0) {
/* 215 */       Table table = new Table();
/* 216 */       paramTable.add((Actor)table).growX().padTop(8.0F).padBottom(4.0F).growX().row();
/*     */       
/*     */       Label label;
/* 219 */       (label = new Label(Game.i.localeManager.i18n.get("enemy_name_BOSS").toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 220 */       label.setAlignment(8);
/* 221 */       table.add((Actor)label).growX();
/*     */ 
/*     */       
/* 224 */       (label = new Label(Game.i.localeManager.i18n.get("main_ui_wave_title").toUpperCase(), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 225 */       table.add((Actor)label);
/*     */       
/* 227 */       for (byte b = 0; b < bossWavesConfig.bossWavePairs.size; b++) {
/* 228 */         BossTypeWavePair bossTypeWavePair = ((BossTypeWavePair[])bossWavesConfig.bossWavePairs.items)[b];
/*     */         
/* 230 */         Table table1 = new Table();
/* 231 */         paramMapEditorItemInfoMenu.listRowBg(b, table1);
/* 232 */         paramTable.add((Actor)table1).height(32.0F).growX().row();
/*     */         
/* 234 */         EnemyType enemyType = Game.i.enemyManager.getBossEnemyType(bossTypeWavePair.bossType);
/* 235 */         Enemy.Factory factory = Game.i.enemyManager.getFactory(enemyType);
/*     */         
/* 237 */         table1.add((Actor)new Image(factory.getTexture())).size(24.0F).padRight(8.0F);
/* 238 */         table1.add((Actor)new Label(factory.getTitle(), Game.i.assetManager.getLabelStyle(21))).growX();
/*     */         
/*     */         int i;
/* 241 */         String str = String.valueOf(i = bossTypeWavePair.wave + bossWavesConfig.startDelay);
/* 242 */         if (bossWavesConfig.repeatCount <= 0) {
/* 243 */           str = str + ", " + (i + bossWavesConfig.cycleLength) + "...";
/*     */         }
/* 245 */         Label label3 = new Label(str, Game.i.assetManager.getLabelStyle(21));
/* 246 */         table1.add((Actor)label3);
/*     */       }  return;
/*     */     } 
/*     */     Label label2;
/* 250 */     (label2 = new Label(Game.i.localeManager.i18n.get("boss_tile_name_NO"), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 251 */     label2.setColor(MaterialColor.GREEN.P500);
/* 252 */     paramTable.add((Actor)label2).height(32.0F).padTop(8.0F).growX().row();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setBossTileType(BossTileType paramBossTileType) {
/* 257 */     this.m = paramBossTileType;
/*     */   }
/*     */   
/*     */   public final BossTileType getBossTileType() {
/* 261 */     return this.m;
/*     */   }
/*     */   
/*     */   public final String getBossTileTypeName() {
/* 265 */     String str = Game.i.tileManager.F.BOSS.getBossTileTypeName(this.m);
/*     */     
/* 267 */     if (this.m == BossTileType.ONE) {
/* 268 */       EnemyType enemyType = Game.i.enemyManager.getBossEnemyType(this.oneBossType);
/* 269 */       str = str + " (" + Game.i.enemyManager.getFactory(enemyType).getTitle() + ")";
/*     */     } 
/*     */     
/* 272 */     return str;
/*     */   }
/*     */   
/*     */   public final BossWavesConfig getBossWavesConfig() {
/* 276 */     if (this.m == BossTileType.CUSTOM) return this.customBossWaveConfig; 
/* 277 */     if (this.m == BossTileType.ONE) return k[this.oneBossType.ordinal()]; 
/* 278 */     if (this.m == BossTileType.HARD) return i; 
/* 279 */     if (this.m == BossTileType.RARE) return g; 
/* 280 */     if (this.m == BossTileType.NO) return e;
/*     */     
/* 282 */     throw new IllegalArgumentException("not implemented for " + this.m);
/*     */   }
/*     */   
/*     */   public final WaveBossSupplier getBossWaveMap() {
/* 286 */     return (WaveBossSupplier)new WaveBossSupplier.Procedural(getBossWavesConfig());
/*     */   }
/*     */   
/*     */   public final Array<GameValueConfig> getGameValues() {
/* 290 */     if (this.m == BossTileType.CUSTOM) return this.customEffects; 
/* 291 */     if (this.m == BossTileType.ONE) return j; 
/* 292 */     if (this.m == BossTileType.HARD) return h; 
/* 293 */     if (this.m == BossTileType.RARE) return f; 
/* 294 */     if (this.m == BossTileType.NO) return d;
/*     */     
/* 296 */     throw new IllegalArgumentException("not implemented for " + this.m);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 301 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/* 302 */       return getRarity().ordinal() * 1000 + 10 - this.m.ordinal() + 150;
/*     */     }
/* 304 */     int i = 2000 + this.m.ordinal() * 100;
/*     */     
/* 306 */     if (this.m == BossTileType.ONE) {
/* 307 */       i += this.oneBossType.ordinal() * 10;
/*     */     }
/* 309 */     if (this.m == BossTileType.CUSTOM)
/*     */     {
/* 311 */       i = (i = i + this.customBossWaveConfig.bossWavePairs.size * 10) + this.customEffects.size * 100;
/*     */     }
/* 313 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 319 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 324 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 329 */     return ItemSubcategoryType.ME_SPECIAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 334 */     if (!super.sameAs(paramTile)) return false;
/*     */ 
/*     */ 
/*     */     
/* 338 */     if (((BossTile)(paramTile = paramTile)).m != this.m) {
/* 339 */       return false;
/*     */     }
/*     */     
/* 342 */     if (this.m == BossTileType.ONE && ((BossTile)paramTile).oneBossType != this.oneBossType) {
/* 343 */       return false;
/*     */     }
/*     */     
/* 346 */     if (this.m == BossTileType.CUSTOM) {
/* 347 */       if (((BossTile)paramTile).customEffects.size != this.customEffects.size) return false; 
/* 348 */       for (byte b = 0; b < ((BossTile)paramTile).customEffects.size; b++) {
/* 349 */         if (!((GameValueConfig[])((BossTile)paramTile).customEffects.items)[b].sameAs(((GameValueConfig[])this.customEffects.items)[b])) return false;
/*     */       
/*     */       } 
/* 352 */       if (!((BossTile)paramTile).customBossWaveConfig.sameAs(this.customBossWaveConfig)) return false;
/*     */     
/*     */     } 
/* 355 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 360 */     super.from(paramTile);
/* 361 */     paramTile = paramTile;
/*     */     
/* 363 */     this.m = ((BossTile)paramTile).m;
/* 364 */     this.oneBossType = ((BossTile)paramTile).oneBossType;
/*     */     
/* 366 */     this.customEffects.clear(); byte b;
/* 367 */     for (b = 0; b < ((BossTile)paramTile).customEffects.size; b++) {
/* 368 */       this.customEffects.add(((GameValueConfig[])((BossTile)paramTile).customEffects.items)[b].cpy());
/*     */     }
/*     */     
/* 371 */     this.customBossWaveConfig.bossWavePairs.clear();
/* 372 */     for (b = 0; b < ((BossTile)paramTile).customBossWaveConfig.bossWavePairs.size; b++) {
/* 373 */       this.customBossWaveConfig.repeatCount = ((BossTile)paramTile).customBossWaveConfig.repeatCount;
/* 374 */       this.customBossWaveConfig.startDelay = ((BossTile)paramTile).customBossWaveConfig.startDelay;
/* 375 */       this.customBossWaveConfig.cycleLength = ((BossTile)paramTile).customBossWaveConfig.cycleLength;
/*     */       
/* 377 */       this.customBossWaveConfig.bossWavePairs.add(((BossTypeWavePair[])((BossTile)paramTile).customBossWaveConfig.bossWavePairs.items)[b].cpy());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/*     */     Group group;
/* 384 */     (group = new Group()).setTransform(false);
/* 385 */     group.setSize(paramFloat, paramFloat);
/*     */     
/* 387 */     if (this.m == BossTileType.ONE) {
/*     */       Image image;
/* 389 */       (image = new Image(BossTileFactory.a(Game.i.tileManager.F.BOSS))).setColor(l[this.oneBossType.ordinal()]);
/* 390 */       image.setSize(paramFloat, paramFloat);
/* 391 */       group.addActor((Actor)image);
/*     */ 
/*     */       
/* 394 */       (image = new Image(BossTileFactory.b(Game.i.tileManager.F.BOSS))).setSize(paramFloat, paramFloat);
/* 395 */       group.addActor((Actor)image);
/* 396 */     } else if (this.m == BossTileType.CUSTOM) {
/*     */       Image image;
/* 398 */       (image = new Image(BossTileFactory.c(Game.i.tileManager.F.BOSS))).setSize(paramFloat, paramFloat);
/* 399 */       group.addActor((Actor)image);
/* 400 */     } else if (this.m == BossTileType.HARD) {
/*     */       Image image;
/* 402 */       (image = new Image(BossTileFactory.d(Game.i.tileManager.F.BOSS))).setSize(paramFloat, paramFloat);
/* 403 */       group.addActor((Actor)image);
/* 404 */     } else if (this.m == BossTileType.RARE) {
/*     */       Image image;
/* 406 */       (image = new Image(BossTileFactory.e(Game.i.tileManager.F.BOSS))).setSize(paramFloat, paramFloat);
/* 407 */       group.addActor((Actor)image);
/* 408 */     } else if (this.m == BossTileType.NO) {
/*     */       Image image;
/* 410 */       (image = new Image(BossTileFactory.f(Game.i.tileManager.F.BOSS))).setSize(paramFloat, paramFloat);
/* 411 */       group.addActor((Actor)image);
/*     */     } 
/*     */     
/* 414 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 419 */     super.toJson(paramJson);
/*     */     
/* 421 */     paramJson.writeObjectStart("d");
/* 422 */     paramJson.writeValue("btt", this.m.name());
/*     */     
/* 424 */     if (this.m == BossTileType.ONE) {
/* 425 */       paramJson.writeValue("obt", this.oneBossType.name());
/* 426 */     } else if (this.m == BossTileType.CUSTOM) {
/* 427 */       paramJson.writeArrayStart("ce");
/* 428 */       for (byte b = 0; b < this.customEffects.size; b++) {
/* 429 */         paramJson.writeObjectStart();
/* 430 */         ((GameValueConfig[])this.customEffects.items)[b].toJson(paramJson);
/* 431 */         paramJson.writeObjectEnd();
/*     */       } 
/* 433 */       paramJson.writeArrayEnd();
/*     */       
/* 435 */       paramJson.writeObjectStart("cbwc");
/* 436 */       this.customBossWaveConfig.toJson(paramJson);
/* 437 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */     
/* 440 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 445 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 447 */     if (this.m == BossTileType.ONE) {
/* 448 */       paramBatch.setColor(l[this.oneBossType.ordinal()]);
/* 449 */       paramBatch.draw(BossTileFactory.a(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 450 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 451 */       paramBatch.draw(BossTileFactory.b(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 452 */     } else if (this.m == BossTileType.CUSTOM) {
/* 453 */       paramBatch.draw(BossTileFactory.c(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 454 */     } else if (this.m == BossTileType.HARD) {
/* 455 */       paramBatch.draw(BossTileFactory.d(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 456 */     } else if (this.m == BossTileType.RARE) {
/* 457 */       paramBatch.draw(BossTileFactory.e(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 458 */     } else if (this.m == BossTileType.NO) {
/* 459 */       paramBatch.draw(BossTileFactory.f(Game.i.tileManager.F.BOSS), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     } 
/*     */     
/* 462 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 467 */     paramArray.add(new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_III, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 472 */     switch (null.a[this.m.ordinal()]) { case 1:
/* 473 */         return 0.1D;
/* 474 */       case 2: return 0.3D;
/* 475 */       case 3: return 0.3D;
/* 476 */       case 4: return 1.0D;
/* 477 */       case 5: return 0.1D; }
/*     */     
/* 479 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectedByLuckyWheelMultiplier() {
/* 484 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/* 489 */     return false;
/*     */   }
/*     */   
/*     */   public static class BossTileFactory
/*     */     extends Tile.Factory.AbstractFactory<BossTile> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     private TextureRegion d;
/*     */     private TextureRegion e;
/*     */     private TextureRegion f;
/* 500 */     private final String[] g = new String[BossTileType.values.length];
/*     */     
/*     */     public BossTileFactory() {
/* 503 */       super(TileType.BOSS); BossTileType[] arrayOfBossTileType; int i;
/*     */       byte b;
/* 505 */       for (i = (arrayOfBossTileType = BossTileType.values).length, b = 0; b < i; ) { BossTileType bossTileType = arrayOfBossTileType[b];
/* 506 */         this.g[bossTileType.ordinal()] = "boss_tile_name_" + bossTileType.name();
/*     */         b++; }
/*     */     
/*     */     }
/*     */     public String getBossTileTypeName(BossTileType param1BossTileType) {
/* 511 */       String str = this.g[param1BossTileType.ordinal()];
/*     */       
/* 513 */       return Game.i.localeManager.i18n.get(str);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 518 */       if (param1Float < 0.9D) return 0;
/*     */       
/* 520 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 525 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-custom");
/* 526 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-no");
/* 527 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-hard");
/* 528 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-rare");
/* 529 */       this.e = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-one-bg");
/* 530 */       this.f = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-boss-one-fg");
/*     */     }
/*     */ 
/*     */     
/*     */     public BossTile create() {
/* 535 */       return new BossTile(BossTileType.NO, (byte)0);
/*     */     }
/*     */     
/*     */     public BossTile createWithTileType(BossTileType param1BossTileType) {
/* 539 */       return new BossTile(param1BossTileType, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public BossTile fromJson(JsonValue param1JsonValue) {
/* 544 */       BossTile bossTile = (BossTile)super.fromJson(param1JsonValue);
/*     */ 
/*     */       
/* 547 */       if ((param1JsonValue = param1JsonValue.get("d")) != null) {
/*     */         try {
/* 549 */           bossTile.setBossTileType(BossTileType.valueOf(param1JsonValue.getString("btt")));
/* 550 */         } catch (Exception exception) {
/* 551 */           BossTile.a().e("failed to load boss tile type", new Object[] { exception });
/*     */         } 
/*     */         
/* 554 */         if (BossTile.a(bossTile) == BossTileType.ONE) {
/*     */           try {
/* 556 */             bossTile.oneBossType = BossType.valueOf(param1JsonValue.getString("obt"));
/* 557 */           } catch (Exception exception) {
/* 558 */             BossTile.a().e("failed to load one boss type", new Object[] { exception });
/*     */           } 
/* 560 */         } else if (BossTile.a(bossTile) == BossTileType.CUSTOM) {
/*     */           try {
/*     */             JsonValue jsonValue;
/* 563 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = param1JsonValue.get("ce")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */               try {
/* 565 */                 GameValueConfig gameValueConfig = GameValueConfig.fromJson(jsonValue1);
/* 566 */                 bossTile.customEffects.add(gameValueConfig);
/* 567 */               } catch (Exception exception) {
/* 568 */                 BossTile.a().e("failed to load custom GV", new Object[] { exception });
/*     */               }  }
/*     */           
/* 571 */           } catch (Exception exception) {
/* 572 */             BossTile.a().e("failed to load custom GVs", new Object[] { exception });
/*     */           } 
/*     */           
/*     */           try {
/* 576 */             bossTile.customBossWaveConfig = BossTile.BossWavesConfig.fromJson(param1JsonValue.get("cbwc"));
/* 577 */           } catch (Exception exception) {
/* 578 */             BossTile.a().e("failed to load custom waves config", new Object[] { exception });
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 583 */       return bossTile;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class BossWavesConfig implements KryoSerializable {
/* 589 */     public int cycleLength = 20;
/* 590 */     public int repeatCount = 1;
/* 591 */     public int startDelay = 0;
/* 592 */     public Array<BossTile.BossTypeWavePair> bossWavePairs = new Array(BossTile.BossTypeWavePair.class);
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 596 */       param1Output.writeVarInt(this.cycleLength, true);
/* 597 */       param1Output.writeInt(this.repeatCount);
/* 598 */       param1Output.writeVarInt(this.startDelay, true);
/* 599 */       param1Kryo.writeObject(param1Output, this.bossWavePairs);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 604 */       this.cycleLength = param1Input.readVarInt(true);
/* 605 */       this.repeatCount = param1Input.readInt();
/* 606 */       this.startDelay = param1Input.readVarInt(true);
/* 607 */       this.bossWavePairs = (Array<BossTile.BossTypeWavePair>)param1Kryo.readObject(param1Input, Array.class);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BossWavesConfig(int param1Int1, int param1Int2, int param1Int3, Array<BossTile.BossTypeWavePair> param1Array) {
/* 613 */       this.cycleLength = param1Int1;
/* 614 */       this.repeatCount = param1Int2;
/* 615 */       this.startDelay = param1Int3;
/* 616 */       this.bossWavePairs.addAll(param1Array);
/*     */     }
/*     */     
/*     */     public boolean sameAs(BossWavesConfig param1BossWavesConfig) {
/* 620 */       if (param1BossWavesConfig.cycleLength != this.cycleLength) return false; 
/* 621 */       if (param1BossWavesConfig.repeatCount != this.repeatCount) return false; 
/* 622 */       if (param1BossWavesConfig.startDelay != this.startDelay) return false; 
/* 623 */       if (this.bossWavePairs.size != param1BossWavesConfig.bossWavePairs.size) return false; 
/* 624 */       for (byte b = 0; b < this.bossWavePairs.size; b++) {
/* 625 */         if (!((BossTile.BossTypeWavePair[])this.bossWavePairs.items)[b].sameAs(((BossTile.BossTypeWavePair[])param1BossWavesConfig.bossWavePairs.items)[b])) {
/* 626 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 630 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public static BossWavesConfig fromJson(JsonValue param1JsonValue) {
/*     */       BossWavesConfig bossWavesConfig;
/* 636 */       (bossWavesConfig = new BossWavesConfig()).cycleLength = param1JsonValue.getInt("cl");
/* 637 */       bossWavesConfig.repeatCount = param1JsonValue.getInt("rc");
/* 638 */       bossWavesConfig.startDelay = param1JsonValue.getInt("sd");
/*     */       
/*     */       try {
/* 641 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (param1JsonValue = param1JsonValue.get("bwp")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 642 */           bossWavesConfig.bossWavePairs.add(BossTile.BossTypeWavePair.fromJson(jsonValue)); }
/*     */       
/* 644 */       } catch (Exception exception) {
/* 645 */         BossTile.a().e("failed to load boss wave pairs", new Object[] { exception });
/*     */       } 
/*     */       
/* 648 */       return bossWavesConfig;
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 652 */       param1Json.writeValue("cl", Integer.valueOf(this.cycleLength));
/* 653 */       param1Json.writeValue("rc", Integer.valueOf(this.repeatCount));
/* 654 */       param1Json.writeValue("sd", Integer.valueOf(this.startDelay));
/* 655 */       param1Json.writeArrayStart("bwp");
/* 656 */       for (byte b = 0; b < this.bossWavePairs.size; b++) {
/* 657 */         param1Json.writeObjectStart();
/* 658 */         ((BossTile.BossTypeWavePair[])this.bossWavePairs.items)[b].toJson(param1Json);
/* 659 */         param1Json.writeObjectEnd();
/*     */       } 
/* 661 */       param1Json.writeArrayEnd();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 666 */       return super.toString() + " (cycleLength: " + this.cycleLength + ", repeatCount: " + this.repeatCount + ", startDelay: " + this.startDelay + ", bossWavePairs: " + this.bossWavePairs + ")";
/*     */     }
/*     */     
/*     */     public BossWavesConfig cpy() {
/*     */       BossWavesConfig bossWavesConfig;
/* 671 */       (bossWavesConfig = new BossWavesConfig()).repeatCount = this.repeatCount;
/* 672 */       bossWavesConfig.cycleLength = this.cycleLength;
/* 673 */       bossWavesConfig.startDelay = this.startDelay;
/* 674 */       for (byte b = 0; b < this.bossWavePairs.size; b++) {
/* 675 */         bossWavesConfig.bossWavePairs.add(((BossTile.BossTypeWavePair)this.bossWavePairs.get(b)).cpy());
/*     */       }
/*     */       
/* 678 */       return bossWavesConfig;
/*     */     }
/*     */     
/*     */     private BossWavesConfig() {} }
/*     */   
/*     */   @REGS
/*     */   public static class BossTypeWavePair implements KryoSerializable {
/*     */     public int wave;
/*     */     public BossType bossType;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 689 */       param1Output.writeVarInt(this.wave, true);
/* 690 */       param1Kryo.writeObjectOrNull(param1Output, this.bossType, BossType.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 695 */       this.wave = param1Input.readVarInt(true);
/* 696 */       this.bossType = (BossType)param1Kryo.readObjectOrNull(param1Input, BossType.class);
/*     */     }
/*     */     
/*     */     private BossTypeWavePair() {}
/*     */     
/*     */     public BossTypeWavePair(int param1Int, BossType param1BossType) {
/* 702 */       this.wave = param1Int;
/* 703 */       this.bossType = param1BossType;
/*     */     }
/*     */     
/*     */     public BossTypeWavePair cpy() {
/* 707 */       return new BossTypeWavePair(this.wave, this.bossType);
/*     */     }
/*     */     
/*     */     public static BossTypeWavePair fromJson(JsonValue param1JsonValue) {
/*     */       BossTypeWavePair bossTypeWavePair;
/* 712 */       (bossTypeWavePair = new BossTypeWavePair()).wave = param1JsonValue.getInt("w");
/*     */       try {
/* 714 */         bossTypeWavePair.bossType = BossType.valueOf(param1JsonValue.getString("bt"));
/* 715 */       } catch (Exception exception) {
/* 716 */         BossTile.a().e("failed to load boss type", new Object[] { exception });
/* 717 */         bossTypeWavePair.bossType = BossType.BROOT;
/*     */       } 
/*     */       
/* 720 */       return bossTypeWavePair;
/*     */     }
/*     */     
/*     */     public boolean sameAs(BossTypeWavePair param1BossTypeWavePair) {
/* 724 */       if (param1BossTypeWavePair.bossType != this.bossType) return false; 
/* 725 */       if (param1BossTypeWavePair.wave != this.wave) return false;
/*     */       
/* 727 */       return true;
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 731 */       param1Json.writeValue("w", Integer.valueOf(this.wave));
/* 732 */       param1Json.writeValue("bt", this.bossType.name());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 737 */       return super.toString() + " (" + this.wave + ", " + this.bossType + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\BossTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */