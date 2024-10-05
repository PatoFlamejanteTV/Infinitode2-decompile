/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
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
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class GameValueTile extends Tile {
/*  38 */   private static final TLog c = TLog.forClass(GameValueTile.class);
/*     */   
/*     */   private GameValueType d;
/*     */   
/*     */   private double e;
/*     */   private boolean f;
/*     */   private boolean g;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  47 */     super.write(paramKryo, paramOutput);
/*  48 */     paramKryo.writeObjectOrNull(paramOutput, this.d, GameValueType.class);
/*  49 */     paramOutput.writeDouble(this.e);
/*  50 */     paramOutput.writeBoolean(this.f);
/*  51 */     paramOutput.writeBoolean(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.d = (GameValueType)paramKryo.readObjectOrNull(paramInput, GameValueType.class);
/*  58 */     this.e = paramInput.readDouble();
/*  59 */     this.f = paramInput.readBoolean();
/*  60 */     this.g = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private GameValueTile() {
/*  64 */     super(TileType.GAME_VALUE);
/*     */     
/*  66 */     setGameValueType(GameValueType.STARTING_MONEY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*  71 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/*  73 */     Table table = new Table();
/*  74 */     paramMapEditorItemInfoMenu.listRowBg(0, table);
/*  75 */     paramTable.add((Actor)table).growX().height(32.0F).row();
/*     */     
/*     */     StringBuilder stringBuilder;
/*  78 */     (stringBuilder = new StringBuilder()).setLength(0);
/*  79 */     stringBuilder.append(Game.i.gameValueManager.getTitle(getGameValueType()));
/*  80 */     if (stringBuilder.length() > 34) {
/*  81 */       stringBuilder.setLength(34);
/*  82 */       stringBuilder.append("...");
/*     */     } 
/*  84 */     Label label2 = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(21));
/*  85 */     table.add((Actor)label2);
/*     */     
/*  87 */     stringBuilder.setLength(0);
/*     */     GameValueManager.ValueUnits valueUnits;
/*  89 */     if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(getGameValueType())).units) != GameValueManager.ValueUnits.BOOLEAN)
/*     */     {
/*  91 */       stringBuilder.append(Game.i.gameValueManager.formatEffectValue(getDelta(), valueUnits));
/*     */     }
/*     */     Label label1;
/*  94 */     (label1 = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(21))).setAlignment(16);
/*  95 */     table.add((Actor)label1).growX();
/*     */     
/*  97 */     if (isOverwrite()) {
/*     */       
/*  99 */       (label1 = new Label(Game.i.localeManager.i18n.get("overwrites_other_effects"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 100 */       label1.setAlignment(8);
/* 101 */       paramTable.add((Actor)label1).growX().height(32.0F).row();
/*     */     } 
/* 103 */     if (isFinalMultiplier()) {
/*     */       
/* 105 */       (label1 = new Label(Game.i.localeManager.i18n.get("gv_tile_final_multiplier"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.PURPLE.P500);
/* 106 */       label1.setAlignment(8);
/* 107 */       paramTable.add((Actor)label1).growX().height(32.0F).row();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 113 */     return 0.02D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     Label label2;
/* 119 */     (label2 = new Label((CharSequence)Game.i.gameValueManager.getTitle(getGameValueType()), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/* 120 */     label2.setAlignment(1);
/* 121 */     paramTable.add((Actor)label2).width(paramFloat).row();
/*     */     
/* 123 */     if (isFinalMultiplier()) {
/*     */       StringBuilder stringBuilder1;
/* 125 */       if (getDelta() == 0.0D) {
/* 126 */         stringBuilder1 = new StringBuilder(Game.i.localeManager.i18n.get("gv_bonus_disabled"));
/*     */       } else {
/*     */         
/* 129 */         (stringBuilder1 = Game.i.gameValueManager.formatEffectValue(getDelta(), GameValueManager.ValueUnits.UNITS)).setCharAt(0, 'x');
/*     */       } 
/*     */       Label label;
/* 132 */       (label = new Label((CharSequence)stringBuilder1, Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 133 */       label.setAlignment(1);
/* 134 */       label.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 135 */       paramTable.add((Actor)label).width(paramFloat).row();
/*     */ 
/*     */       
/* 138 */       (label = new Label(Game.i.localeManager.i18n.get("gv_tile_final_multiplier"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 139 */       label.setWrap(true);
/* 140 */       label.setAlignment(1);
/* 141 */       paramTable.add((Actor)label).width(paramFloat).padTop(8.0F).row(); return;
/*     */     } 
/* 143 */     StringBuilder stringBuilder = Game.i.gameValueManager.formatEffectValue(getDelta(), Game.i.gameValueManager.getUnits(getGameValueType()));
/* 144 */     if (isOverwrite()) {
/* 145 */       stringBuilder.setCharAt(0, '=');
/*     */     }
/*     */     Label label1;
/* 148 */     (label1 = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 149 */     label1.setAlignment(1);
/* 150 */     label1.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 151 */     paramTable.add((Actor)label1).width(paramFloat).row();
/*     */     
/* 153 */     if (isOverwrite()) {
/*     */       
/* 155 */       (label1 = new Label(Game.i.localeManager.i18n.get("overwrites_other_effects"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 156 */       label1.setWrap(true);
/* 157 */       label1.setAlignment(1);
/* 158 */       paramTable.add((Actor)label1).width(paramFloat).padTop(8.0F).row();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 165 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/* 166 */       return getRarity().ordinal() * 1000;
/*     */     }
/* 168 */     return 25000 + this.d.ordinal();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 179 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 184 */     return ItemSubcategoryType.ME_SPECIAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 189 */     if (!super.sameAs(paramTile)) return false;
/*     */ 
/*     */ 
/*     */     
/* 193 */     if (((GameValueTile)(paramTile = paramTile)).d != this.d) return false; 
/* 194 */     if (((GameValueTile)paramTile).e != this.e) return false; 
/* 195 */     if (((GameValueTile)paramTile).f != this.f) return false; 
/* 196 */     if (((GameValueTile)paramTile).g != this.g) return false;
/*     */     
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 203 */     super.from(paramTile);
/* 204 */     paramTile = paramTile;
/* 205 */     setGameValueType(((GameValueTile)paramTile).d);
/* 206 */     setDelta(((GameValueTile)paramTile).e);
/* 207 */     setOverwrite(((GameValueTile)paramTile).f);
/* 208 */     setFinalMultiplier(((GameValueTile)paramTile).g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/*     */     Group group;
/* 214 */     (group = new Group()).setTransform(false);
/* 215 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 218 */     (image = new Image(GameValueTileFactory.a(Game.i.tileManager.F.GAME_VALUE))).setSize(paramFloat, paramFloat);
/* 219 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 222 */     (image = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(this.d).getIcon())).setPosition(paramFloat * 0.15F, paramFloat * 0.15F);
/* 223 */     image.setSize(paramFloat * 0.7F, paramFloat * 0.7F);
/* 224 */     group.addActor((Actor)image);
/*     */     
/* 226 */     return group;
/*     */   }
/*     */   
/*     */   public final GameValueType getGameValueType() {
/* 230 */     return this.d;
/*     */   }
/*     */   
/*     */   public final double getDelta() {
/* 234 */     return this.e;
/*     */   }
/*     */   
/*     */   public final boolean isOverwrite() {
/* 238 */     return this.f;
/*     */   }
/*     */   
/*     */   public final boolean isFinalMultiplier() {
/* 242 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void setFinalMultiplier(boolean paramBoolean) {
/* 246 */     this.g = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void setDelta(double paramDouble) {
/* 250 */     this.e = paramDouble;
/*     */   }
/*     */   
/*     */   public final void setOverwrite(boolean paramBoolean) {
/* 254 */     this.f = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void setGameValueType(GameValueType paramGameValueType) {
/* 258 */     if (paramGameValueType == null) throw new IllegalArgumentException("type is null"); 
/* 259 */     this.d = paramGameValueType;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 264 */     super.toJson(paramJson);
/*     */     
/* 266 */     paramJson.writeObjectStart("d");
/* 267 */     paramJson.writeValue("gv", this.d.name());
/* 268 */     paramJson.writeValue("d", Double.valueOf(this.e));
/* 269 */     paramJson.writeValue("o", Integer.valueOf(this.f ? 1 : 0));
/* 270 */     paramJson.writeValue("f", Integer.valueOf(this.g ? 1 : 0));
/* 271 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 276 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 278 */     if (this.d != GameValueType.DUMMY || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/* 279 */       paramBatch.draw(GameValueTileFactory.a(Game.i.tileManager.F.GAME_VALUE), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     }
/*     */     
/* 282 */     Game.i.gameValueManager.getStockValueConfig(this.d).getIcon()
/* 283 */       .draw(paramBatch, paramFloat1 + paramFloat3 * 0.15F, paramFloat2 + paramFloat4 * 0.15F, 0.7F * paramFloat3, 0.7F * paramFloat3);
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
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 300 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 150));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   public static class GameValueTileFactory extends Tile.Factory.AbstractFactory<GameValueTile> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public GameValueTileFactory() {
/* 312 */       super(TileType.GAME_VALUE);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 317 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 322 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-game-value-base");
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueTile create() {
/* 327 */       return new GameValueTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueTile createTypeDelta(GameValueType param1GameValueType, double param1Double) {
/*     */       GameValueTile gameValueTile;
/* 333 */       (gameValueTile = new GameValueTile((byte)0)).setGameValueType(param1GameValueType);
/* 334 */       gameValueTile.setDelta(param1Double);
/*     */       
/* 336 */       return gameValueTile;
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueTile createTypeDeltaOverwrite(GameValueType param1GameValueType, double param1Double, boolean param1Boolean) {
/*     */       GameValueTile gameValueTile;
/* 342 */       (gameValueTile = new GameValueTile((byte)0)).setGameValueType(param1GameValueType);
/* 343 */       gameValueTile.setDelta(param1Double);
/* 344 */       gameValueTile.setOverwrite(param1Boolean);
/*     */       
/* 346 */       return gameValueTile;
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueTile fromJson(JsonValue param1JsonValue) {
/* 351 */       GameValueTile gameValueTile = (GameValueTile)super.fromJson(param1JsonValue);
/*     */ 
/*     */       
/* 354 */       if ((param1JsonValue = param1JsonValue.get("d")) != null) {
/*     */         GameValueType gameValueType;
/*     */         try {
/* 357 */           gameValueType = GameValueType.valueOf(param1JsonValue.getString("gv"));
/* 358 */         } catch (Exception exception) {
/* 359 */           gameValueType = GameValueType.EMOJI_ENEMIES;
/* 360 */           GameValueTile.a().e("failed to load GV: " + param1JsonValue.getString("gv", "[gv is empty]") + ", replaced with a dummy tile", new Object[] { exception });
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 365 */         gameValueTile.setGameValueType(gameValueType);
/* 366 */         gameValueTile.setDelta(param1JsonValue.getDouble("d", 0.0D));
/* 367 */         gameValueTile.setOverwrite((param1JsonValue.getInt("o", 0) == 1));
/* 368 */         gameValueTile.setFinalMultiplier((param1JsonValue.getInt("f", 0) == 1));
/*     */       } 
/*     */       
/* 371 */       return gameValueTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\GameValueTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */