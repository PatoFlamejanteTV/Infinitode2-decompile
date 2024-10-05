/*     */ package com.prineside.tdi2.tiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.RenderingManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Comparator;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class TargetTile extends Tile {
/*  61 */   private static final TLog c = TLog.forClass(TargetTile.class);
/*     */   
/*  63 */   private Array<GameValueConfig> d = new Array(GameValueConfig.class);
/*     */   private boolean e = false;
/*     */   private boolean f = false;
/*  66 */   private int g = 0; @NAGS
/*     */   private boolean h = true;
/*     */   @NAGS
/*  69 */   private Color i = Color.WHITE;
/*     */   
/*     */   public final Color getBaseColor() {
/*  72 */     return this.i;
/*     */   }
/*     */   
/*     */   public final Color getCoreColor() {
/*  76 */     return this.j;
/*     */   }
/*     */   @NAGS
/*  79 */   private Color j = Color.WHITE;
/*     */   @NAGS
/*     */   private TextureRegion k;
/*     */   @NAGS
/*     */   private float l;
/*     */   @NAGS
/*     */   private boolean m;
/*  86 */   private static final Color n = new Color();
/*     */   static {
/*  88 */     o = ((paramGameValueConfig1, paramGameValueConfig2) -> Integer.compare(paramGameValueConfig1.getType().ordinal(), paramGameValueConfig2.getType().ordinal()));
/*     */   }
/*     */   private static final Comparator<GameValueConfig> o;
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  92 */     super.write(paramKryo, paramOutput);
/*  93 */     paramKryo.writeObject(paramOutput, this.d);
/*  94 */     paramOutput.writeBoolean(this.e);
/*  95 */     paramOutput.writeBoolean(this.f);
/*  96 */     paramOutput.writeVarInt(this.g, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 101 */     super.read(paramKryo, paramInput);
/* 102 */     this.d = (Array<GameValueConfig>)paramKryo.readObject(paramInput, Array.class);
/* 103 */     this.e = paramInput.readBoolean();
/* 104 */     this.f = paramInput.readBoolean();
/* 105 */     this.g = paramInput.readVarInt(true);
/*     */   }
/*     */   private TargetTile() {
/* 108 */     super(TileType.TARGET);
/*     */   }
/*     */   public final int getOverloadLevel() {
/* 111 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void setOverloadLevel(int paramInt) {
/* 115 */     this.g = paramInt;
/*     */   }
/*     */   
/*     */   public final void showHitEffect(Vector2 paramVector2) {
/* 119 */     if (this.S != null && this.S._particle != null) {
/* 120 */       c();
/*     */       
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/* 123 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.tileManager.F.TARGET.d.obtain()).setPosition(((this.a << 7) + 64), ((this.b << 7) + 64));
/* 124 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/*     */       
/* 126 */       this.l += 0.4F;
/* 127 */       if (this.l > 1.0F) this.l = 1.0F;
/*     */       
/* 129 */       n.set(this.i);
/* 130 */       n.a = 0.5F;
/* 131 */       this.S._particle.addFlashParticleColored(Game.i.tileManager.F.TARGET.b, ((this.a << 7) + 64), ((this.b << 7) + 64), 64.0F, 64.0F, 128.0F, 128.0F, 0.0F, n);
/*     */       
/* 133 */       n.set(this.j);
/* 134 */       n.a = 0.5F;
/* 135 */       this.S._particle.addFlashParticleColored(this.k, ((this.a << 7) + 64), ((this.b << 7) + 64), 64.0F, 64.0F, 128.0F, 128.0F, 0.0F, n);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void startExplosionEffect() {
/* 140 */     this.m = true;
/*     */     
/* 142 */     if (this.S._particle != null) {
/* 143 */       c();
/*     */       
/* 145 */       this.S._particle.addShatterParticle(Game.i.tileManager.F.TARGET.b, ((this.a << 7) + 64), ((this.b << 7) + 64), 128.0F, 0.0F, 1.0F, this.i, new ExplosionInterpolation((byte)0), false);
/* 146 */       this.S._particle.addShatterParticle(this.k, ((this.a << 7) + 64), ((this.b << 7) + 64), 128.0F, 0.0F, 1.0F, this.j, new ExplosionInterpolation((byte)0), true);
/*     */       
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/* 149 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.tileManager.F.TARGET.c.obtain()).setPosition(((this.a << 7) + 64), ((this.b << 7) + 64));
/* 150 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 156 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/* 158 */     if (isUseStockGameValues()) {
/*     */       Label label;
/* 160 */       (label = new Label(Game.i.localeManager.i18n.get("portal_disables_researches"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.RED.P500);
/* 161 */       label.setAlignment(8);
/* 162 */       paramTable.add((Actor)label).growX().height(32.0F).row();
/*     */     } 
/* 164 */     if (isDisableAbilities()) {
/*     */       Label label;
/* 166 */       (label = new Label(Game.i.localeManager.i18n.get("portal_disables_abilities"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.YELLOW.P500);
/* 167 */       label.setAlignment(8);
/* 168 */       paramTable.add((Actor)label).growX().height(32.0F).row();
/*     */     } 
/* 170 */     if (isWalkableTiles()) {
/*     */       Label label;
/* 172 */       (label = new Label((CharSequence)Game.i.gameValueManager.getTitle(GameValueType.ENEMIES_WALK_ON_PLATFORMS), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 173 */       label.setAlignment(8);
/* 174 */       paramTable.add((Actor)label).growX().height(32.0F).row();
/*     */     } 
/*     */     
/* 177 */     Array<GameValueConfig> array = getGameValues();
/* 178 */     for (byte b = 0; b < array.size; b++) {
/* 179 */       GameValueConfig gameValueConfig = (GameValueConfig)array.get(b);
/*     */       
/* 181 */       Table table = new Table();
/* 182 */       paramMapEditorItemInfoMenu.listRowBg(b, table);
/* 183 */       paramTable.add((Actor)table).growX().height(32.0F).row();
/*     */       
/* 185 */       Quad quad = Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType()).getIcon();
/* 186 */       table.add((Actor)new Image((Drawable)quad)).size(24.0F).padRight(8.0F);
/*     */       
/*     */       StringBuilder stringBuilder;
/* 189 */       (stringBuilder = new StringBuilder()).setLength(0);
/* 190 */       stringBuilder.append(Game.i.gameValueManager.getTitle(gameValueConfig.getType()));
/* 191 */       if (stringBuilder.length() > 34) {
/* 192 */         stringBuilder.setLength(34);
/* 193 */         stringBuilder.append("...");
/*     */       } 
/* 195 */       LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel((CharSequence)stringBuilder, 21, 18, 250.0F);
/* 196 */       table.add((Actor)limitedWidthLabel).growX();
/*     */       
/* 198 */       if (!gameValueConfig.isAllowBonuses()) {
/*     */         Image image;
/* 200 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setColor(MaterialColor.AMBER.P500);
/* 201 */         table.add((Actor)image).size(24.0F).padLeft(8.0F);
/*     */       } else {
/* 203 */         table.add();
/*     */       } 
/*     */       
/* 206 */       stringBuilder.setLength(0);
/*     */       GameValueManager.ValueUnits valueUnits;
/* 208 */       if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units) != GameValueManager.ValueUnits.BOOLEAN) {
/*     */         
/* 210 */         stringBuilder.append(Game.i.gameValueManager.formatEffectValue(gameValueConfig.getValue(), valueUnits));
/* 211 */         if (gameValueConfig.isOverwrite()) {
/* 212 */           stringBuilder.setCharAt(0, '=');
/*     */         }
/*     */       } 
/*     */       Label label;
/* 216 */       (label = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(21))).setAlignment(16);
/* 217 */       table.add((Actor)label);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*     */     Label label1;
/* 223 */     if (isUseStockGameValues()) {
/*     */       Label label;
/* 225 */       (label = new Label(Game.i.localeManager.i18n.get("portal_disables_researches"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.RED.P500);
/* 226 */       label.setWrap(true);
/* 227 */       label.setAlignment(1);
/* 228 */       paramTable.add((Actor)label).width(paramFloat - 16.0F).row();
/*     */     } 
/* 230 */     if (isDisableAbilities()) {
/*     */       Label label;
/* 232 */       (label = new Label(Game.i.localeManager.i18n.get("portal_disables_abilities"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.YELLOW.P500);
/* 233 */       label.setWrap(true);
/* 234 */       label.setAlignment(1);
/* 235 */       paramTable.add((Actor)label).width(paramFloat - 16.0F).row();
/*     */     } 
/* 237 */     if (isWalkableTiles()) {
/*     */       Label label;
/* 239 */       (label = new Label((CharSequence)Game.i.gameValueManager.getTitle(GameValueType.ENEMIES_WALK_ON_PLATFORMS), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 240 */       label.setWrap(true);
/* 241 */       label.setAlignment(1);
/* 242 */       paramTable.add((Actor)label).width(paramFloat - 16.0F).row();
/*     */     } 
/*     */     
/* 245 */     Table table = new Table();
/* 246 */     paramTable.add((Actor)table).width(paramFloat).padTop(8.0F).row();
/*     */     
/*     */     Array<GameValueConfig> array;
/*     */     
/* 250 */     if ((array = getGameValues()).size != 0) {
/* 251 */       for (byte b = 0; b < array.size; b++) {
/* 252 */         GameValueConfig gameValueConfig = (GameValueConfig)array.get(b);
/*     */         
/*     */         Group group;
/* 255 */         (group = new Group()).setTransform(false);
/*     */         
/* 257 */         if (b % 2 == 0) {
/*     */           Image image1;
/* 259 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-horizontal"))).setSize(paramFloat, 43.0F);
/* 260 */           image1.setPosition(0.0F, -2.0F);
/* 261 */           image1.setColor(0.0F, 0.0F, 0.0F, 0.21F);
/* 262 */           group.addActor((Actor)image1);
/*     */         } 
/*     */         
/*     */         Image image;
/* 266 */         (image = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType()).createIconForBackground(new Color(623191551)))).setPosition(3.75F, 4.5F);
/* 267 */         image.setSize(30.0F, 30.0F);
/* 268 */         group.addActor((Actor)image);
/*     */         
/*     */         LimitedWidthLabel limitedWidthLabel;
/* 271 */         (limitedWidthLabel = new LimitedWidthLabel((CharSequence)Game.i.gameValueManager.getTitle(gameValueConfig.getType()), 21, 18, 172.5F)).setSize(150.0F, 39.0F);
/* 272 */         limitedWidthLabel.setPosition(56.0F, 0.0F);
/* 273 */         limitedWidthLabel.setTouchable(Touchable.enabled);
/* 274 */         limitedWidthLabel.addListener((EventListener)new ClickListener(this, gameValueConfig)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 277 */                 Dialog.i().showAlert((CharSequence)Game.i.gameValueManager.getTitle(this.a.getType()));
/*     */               }
/*     */             });
/*     */         
/* 281 */         group.addActor((Actor)limitedWidthLabel);
/*     */         
/* 283 */         if (!gameValueConfig.isAllowBonuses()) {
/*     */           Image image1;
/* 285 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setSize(24.0F, 24.0F);
/* 286 */           image1.setPosition(310.5F, 7.5F);
/* 287 */           group.addActor((Actor)image1);
/*     */         } 
/*     */         
/*     */         StringBuilder stringBuilder;
/* 291 */         (stringBuilder = new StringBuilder()).setLength(0);
/*     */         GameValueManager.ValueUnits valueUnits;
/* 293 */         if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units) == GameValueManager.ValueUnits.BOOLEAN) {
/*     */           
/* 295 */           if (gameValueConfig.getValue() == 0.0D)
/*     */           {
/* 297 */             stringBuilder.append(Game.i.localeManager.i18n.get("disabled").toLowerCase(Locale.ENGLISH));
/*     */           }
/*     */         } else {
/* 300 */           stringBuilder.append(Game.i.gameValueManager.formatEffectValue(gameValueConfig.getValue(), valueUnits));
/* 301 */           if (gameValueConfig.isOverwrite()) {
/* 302 */             stringBuilder.setCharAt(0, '=');
/*     */           }
/* 304 */           if (stringBuilder.length == 1) {
/* 305 */             stringBuilder.append('0');
/*     */           }
/*     */         } 
/*     */         
/* 309 */         (label1 = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(24))).setPosition(paramFloat - 75.0F - 8.0F, 0.0F);
/* 310 */         label1.setSize(75.0F, 39.0F);
/* 311 */         label1.setAlignment(16);
/* 312 */         group.addActor((Actor)label1);
/*     */         
/* 314 */         table.add((Actor)group).size(paramFloat, 39.0F).padBottom(4.0F).row();
/*     */       }  return;
/*     */     } 
/* 317 */     Label label2 = new Label(Game.i.localeManager.i18n.get("base_has_no_effects"), Game.i.assetManager.getLabelStyle(21));
/* 318 */     label1.add((Actor)label2).row();
/*     */   }
/*     */ 
/*     */   
/*     */   private void c() {
/* 323 */     if (this.h) {
/* 324 */       this.h = false;
/*     */       
/* 326 */       int i = 420; int j;
/* 327 */       for (j = 0; j < this.d.size; j++) {
/* 328 */         i = i * 27 + ((GameValueConfig)this.d.get(j)).getType().ordinal();
/* 329 */         i = i * 31 + (((GameValueConfig)this.d.get(j)).isOverwrite() ? 1 : 0) + (((GameValueConfig)this.d.get(j)).isAllowBonuses() ? 3 : 0);
/* 330 */         i = i * 37 + (int)(((GameValueConfig)this.d.get(j)).getValue() * 10.0D);
/*     */       } 
/*     */       
/* 333 */       if (this.e) {
/* 334 */         i = i * 23 + 7;
/*     */       }
/* 336 */       if (this.f) {
/* 337 */         i = i * 31 + 5;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 342 */       j = (i = (i = StrictMath.abs(i)) % 1296) / 18 / 18;
/* 343 */       int k = i / 18 % 18;
/* 344 */       i %= 18;
/*     */ 
/*     */       
/* 347 */       switch (j) { case 1:
/* 348 */           this.k = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-core-1"); break;
/* 349 */         case 2: this.k = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-core-2"); break;
/* 350 */         case 3: this.k = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-core-3"); break;
/* 351 */         default: this.k = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-core-4"); break; }
/*     */       
/* 353 */       this.j = MaterialColor.allColors[i][MaterialColor.Variants.P500.ordinal()];
/* 354 */       this.i = MaterialColor.allColors[k][MaterialColor.Variants.P500.ordinal()];
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addGameValue(GameValueConfig paramGameValueConfig) {
/* 360 */     Preconditions.checkNotNull(paramGameValueConfig, "config can not be null");
/* 361 */     this.d.add(paramGameValueConfig);
/* 362 */     this.h = true;
/*     */   }
/*     */   
/*     */   public final void removeGameValue(GameValueConfig paramGameValueConfig) {
/* 366 */     Preconditions.checkNotNull(paramGameValueConfig, "config can not be null");
/* 367 */     this.d.removeValue(paramGameValueConfig, true);
/* 368 */     this.h = true;
/*     */   }
/*     */   
/*     */   public final void updateAppearance() {
/* 372 */     this.h = true;
/*     */   }
/*     */   
/*     */   public final Array<GameValueConfig> getGameValues() {
/* 376 */     return this.d;
/*     */   }
/*     */   
/*     */   public final boolean isDisableAbilities() {
/* 380 */     return this.f;
/*     */   }
/*     */   
/*     */   public final boolean isWalkableTiles() {
/* 384 */     for (byte b = 0; b < this.d.size; b++) {
/*     */       GameValueConfig gameValueConfig;
/*     */       
/* 387 */       if ((gameValueConfig = ((GameValueConfig[])this.d.items)[b]).getType() == GameValueType.ENEMIES_WALK_ON_PLATFORMS && gameValueConfig.getValue() >= 1.0D) {
/* 388 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 392 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean isUseStockGameValues() {
/* 396 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void setUseStockGameValues(boolean paramBoolean) {
/* 400 */     this.e = paramBoolean;
/* 401 */     this.h = true;
/*     */   }
/*     */   
/*     */   public final void setDisableAbilities(boolean paramBoolean) {
/* 405 */     this.f = paramBoolean;
/* 406 */     this.h = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 411 */     if (this.d.size <= 2) {
/* 412 */       return RarityType.COMMON;
/*     */     }
/* 414 */     if (this.d.size <= 4) {
/* 415 */       return RarityType.RARE;
/*     */     }
/* 417 */     if (this.d.size <= 6) {
/* 418 */       return RarityType.VERY_RARE;
/*     */     }
/* 420 */     if (this.d.size <= 8) {
/* 421 */       return RarityType.EPIC;
/*     */     }
/*     */     
/* 424 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getWalkCost(boolean paramBoolean) {
/* 429 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 434 */     return ItemSubcategoryType.ME_BASES;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int generateSeedSalt() {
/* 439 */     int i = 0;
/*     */     
/* 441 */     for (byte b = 0; b < this.d.size; b++) {
/* 442 */       GameValueConfig gameValueConfig = (GameValueConfig)this.d.get(b);
/*     */ 
/*     */ 
/*     */       
/* 446 */       i = (i = (i = (i = i * 21 + gameValueConfig.getType().ordinal()) * 23 + (gameValueConfig.isAllowBonuses() ? 0 : 1)) * 27 + (gameValueConfig.isOverwrite() ? 0 : 1)) * 31 + (int)(gameValueConfig.getValue() * 100.0D);
/*     */     } 
/* 448 */     if (this.e) i += 1000000; 
/* 449 */     if (this.e) i += 10000000;
/*     */     
/* 451 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 456 */     if (!super.sameAs(paramTile)) return false;
/*     */ 
/*     */     
/* 459 */     if (((TargetTile)(paramTile = paramTile)).e != this.e) return false; 
/* 460 */     if (((TargetTile)paramTile).f != this.f) return false; 
/* 461 */     if (((TargetTile)paramTile).d.size != this.d.size) return false;
/*     */     
/* 463 */     for (byte b = 0; b < this.d.size; b++) {
/* 464 */       GameValueConfig gameValueConfig1 = (GameValueConfig)this.d.get(b);
/* 465 */       GameValueConfig gameValueConfig2 = (GameValueConfig)((TargetTile)paramTile).d.get(b);
/* 466 */       if (gameValueConfig1.isOverwrite() != gameValueConfig2.isOverwrite()) return false; 
/* 467 */       if (gameValueConfig1.getValue() != gameValueConfig2.getValue()) return false; 
/* 468 */       if (gameValueConfig1.isAllowBonuses() != gameValueConfig2.isAllowBonuses()) return false; 
/* 469 */       if (gameValueConfig1.getType() != gameValueConfig2.getType()) return false;
/*     */     
/*     */     } 
/* 472 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 477 */     super.from(paramTile);
/* 478 */     paramTile = paramTile;
/*     */     
/* 480 */     this.d.clear();
/* 481 */     for (byte b = 0; b < ((TargetTile)paramTile).d.size; b++) {
/* 482 */       this.d.add(((GameValueConfig)((TargetTile)paramTile).d.get(b)).cpy());
/*     */     }
/* 484 */     this.e = ((TargetTile)paramTile).e;
/* 485 */     this.f = ((TargetTile)paramTile).f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/* 490 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/* 491 */       int j = getRarity().ordinal() * 1000;
/*     */       
/* 493 */       if (this.e) j++; 
/* 494 */       if (this.f) j++;
/*     */ 
/*     */       
/* 497 */       return j = j + this.d.size;
/*     */     } 
/* 499 */     int i = 0;
/*     */     
/* 501 */     if (this.e) i++; 
/* 502 */     if (this.f) i++;
/*     */ 
/*     */     
/* 505 */     return i = i + this.d.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 511 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 516 */     int i = 200;
/*     */     
/* 518 */     if (this.e) i += 'È'; 
/* 519 */     if (this.f) i += 'È';
/*     */     
/* 521 */     i += this.d.size * 100;
/*     */     
/* 523 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 531 */     double d = 0.05D + this.d.size * 0.5D;
/* 532 */     if (this.d.size >= 8) {
/* 533 */       d *= 1.2D;
/* 534 */     } else if (this.d.size >= 6) {
/* 535 */       d *= 0.95D;
/* 536 */     } else if (this.d.size >= 4) {
/* 537 */       d *= 0.65D;
/* 538 */     } else if (this.d.size >= 2) {
/* 539 */       d *= 0.3D;
/*     */     } else {
/* 541 */       d *= 0.1D;
/*     */     } 
/*     */     
/* 544 */     if (this.e) {
/* 545 */       d += 1.5D;
/*     */     }
/* 547 */     if (this.f) {
/* 548 */       d += 0.8D;
/*     */     }
/*     */     
/* 551 */     return d;
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
/*     */   public final boolean canBeUpgraded() {
/* 572 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/* 577 */     paramFloat4 *= 0.0078125F;
/* 578 */     paramFloat5 *= 0.0078125F;
/*     */     
/* 580 */     this.l -= paramFloat1;
/* 581 */     if (this.l < 0.0F) this.l = 0.0F;
/*     */     
/* 583 */     c();
/*     */     
/* 585 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 586 */     paramBatch.draw(Game.i.tileManager.F.TARGET.a, paramFloat2, paramFloat3, 128.0F * paramFloat4, 128.0F * paramFloat5);
/*     */     
/* 588 */     if (this.m)
/*     */       return; 
/* 590 */     n.set(this.i);
/* 591 */     n.mul(1.0F + this.l * 1.4F, 1.0F + this.l * 1.9F, 1.0F + this.l * 0.7F, 1.0F);
/* 592 */     paramBatch.setColor(n);
/* 593 */     paramBatch.draw(Game.i.tileManager.F.TARGET.b, paramFloat2, paramFloat3, 128.0F * paramFloat4, 128.0F * paramFloat5);
/*     */     
/* 595 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postDrawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/* 600 */     if (this.m)
/*     */       return; 
/* 602 */     boolean bool = RenderingManager.isAdditiveBatch(paramBatch);
/* 603 */     RenderingManager.prepareBatch(paramBatch, false);
/*     */     
/* 605 */     c();
/*     */     
/* 607 */     n.set(this.j);
/* 608 */     n.mul(1.0F + this.l * 1.4F, 1.0F + this.l * 1.9F, 1.0F + this.l * 0.7F, 1.0F);
/* 609 */     paramBatch.setColor(n);
/* 610 */     paramBatch.draw(this.k, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
/*     */     
/* 612 */     RenderingManager.setBatchAdditiveBlending(paramBatch, bool);
/*     */     
/* 614 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/* 619 */     c();
/*     */     
/* 621 */     float f = paramFloat / 128.0F;
/*     */     
/*     */     Group group;
/* 624 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image;
/* 627 */     (image = new Image(Game.i.tileManager.getRoadTexture(null, null, null, null))).setSize(paramFloat, paramFloat);
/* 628 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 631 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.TARGET.a))).setSize(paramFloat, paramFloat);
/* 632 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 635 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.TARGET.b))).setSize(paramFloat, paramFloat);
/* 636 */     image.setColor(this.i);
/* 637 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 640 */     (image = new Image((Drawable)new TextureRegionDrawable(this.k))).setSize(paramFloat, paramFloat);
/* 641 */     image.setColor(this.j);
/* 642 */     group.addActor((Actor)image);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 649 */     for (byte b = 0; b < this.d.size; b++) {
/*     */       
/* 651 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle-outline"))).setSize(10.0F * f, 10.0F * f);
/*     */       
/* 653 */       int i = b % 7;
/* 654 */       int j = b / 7;
/* 655 */       image.setPosition(10.0F * f + 12.0F * f * j, 10.0F * f + 12.0F * f * i);
/*     */       
/* 657 */       group.addActor((Actor)image);
/*     */     } 
/* 659 */     if (isUseStockGameValues()) {
/*     */       Image image1;
/* 661 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle-outline"))).setSize(16.0F * f, 16.0F * f);
/* 662 */       image1.setPosition(10.0F * f, 102.0F * f);
/* 663 */       image1.setColor(MaterialColor.RED.P500);
/*     */       
/* 665 */       group.addActor((Actor)image1);
/*     */     } 
/* 667 */     if (this.f) {
/*     */       Image image1;
/* 669 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle-outline"))).setSize(16.0F * f, 16.0F * f);
/* 670 */       image1.setPosition(28.0F * f, 102.0F * f);
/* 671 */       image1.setColor(MaterialColor.YELLOW.P500);
/*     */       
/* 673 */       group.addActor((Actor)image1);
/*     */     } 
/* 675 */     if (isWalkableTiles()) {
/*     */       Image image1;
/* 677 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle-outline"))).setSize(16.0F * f, 16.0F * f);
/* 678 */       image1.setPosition(46.0F * f, 102.0F * f);
/* 679 */       image1.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */       
/* 681 */       group.addActor((Actor)image1);
/*     */     } 
/*     */     
/* 684 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 689 */     super.toJson(paramJson);
/*     */     
/* 691 */     paramJson.writeObjectStart("d");
/* 692 */     paramJson.writeValue("da", Boolean.valueOf(this.f));
/* 693 */     paramJson.writeValue("usgv", Boolean.valueOf(this.e));
/*     */     
/* 695 */     paramJson.writeArrayStart("gv");
/* 696 */     for (byte b = 0; b < this.d.size; b++) {
/* 697 */       paramJson.writeObjectStart();
/* 698 */       ((GameValueConfig)this.d.get(b)).toJson(paramJson);
/* 699 */       paramJson.writeObjectEnd();
/*     */     } 
/* 701 */     paramJson.writeArrayEnd();
/* 702 */     paramJson.writeObjectEnd();
/*     */   }
/*     */   
/*     */   public static class TargetTileFactory
/*     */     extends Tile.Factory.AbstractFactory<TargetTile> {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     ParticleEffectPool c;
/*     */     ParticleEffectPool d;
/*     */     
/*     */     public TargetTileFactory() {
/* 713 */       super(TileType.TARGET);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/*     */       int i;
/* 719 */       if ((i = param1InventoryStatistics.byTileType[TileType.TARGET.ordinal()]) == 0)
/* 720 */         return 1000; 
/* 721 */       if (i > 500) {
/* 722 */         return 0;
/*     */       }
/* 724 */       return 30;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 730 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-hollow");
/* 731 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-target-base");
/*     */       
/* 733 */       this.c = Game.i.assetManager.getParticleEffectPool("base-explosion.prt");
/* 734 */       this.d = Game.i.assetManager.getParticleEffectPool("base-hit.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public TargetTile create() {
/* 739 */       return new TargetTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public TargetTile createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/* 744 */       if (param1RandomXS128 == null) {
/* 745 */         param1RandomXS128 = FastRandom.random;
/*     */       }
/* 747 */       RandomXS128 randomXS128 = param1RandomXS128;
/*     */       
/* 749 */       TargetTile targetTile = create();
/*     */       
/* 751 */       Array array = new Array();
/*     */       
/* 753 */       if (param1RandomXS128.nextFloat() * param1Float < 0.1F) {
/* 754 */         TargetTile.a(targetTile, true);
/*     */       }
/* 756 */       if (param1RandomXS128.nextFloat() * param1Float < 0.1F) {
/* 757 */         TargetTile.b(targetTile, true);
/*     */       }
/*     */       
/* 760 */       byte b1 = 0; GameValueType[] arrayOfGameValueType; int j, k;
/* 761 */       for (j = (arrayOfGameValueType = GameValueType.minerCount).length, k = 0; k < j; ) { GameValueType gameValueType = arrayOfGameValueType[k];
/*     */         
/* 763 */         if (Game.i.progressManager.isResourceOpened(ResourceType.values[b1])) {
/*     */           
/* 765 */           array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */                   int i;
/*     */                   if ((i = MathUtils.round(param1Float * 3.0F)) == 0) {
/*     */                     i = 1;
/*     */                   }
/*     */                   TargetTile.b(param1TargetTile).add(new GameValueConfig(param1GameValueType, i, false, true));
/*     */                 }));
/* 772 */           b1++;
/*     */         }  k++; }
/*     */       
/* 775 */       if (TargetTile.a(targetTile) && param1Float > 0.2D)
/*     */       {
/* 777 */         array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */                 byte b = 1;
/*     */                 
/*     */                 if (param1RandomXS128.nextFloat() * param1Float > 0.5F) {
/*     */                   b = 2;
/*     */                 }
/*     */                 
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.TOWERS_MAX_UPGRADE_LEVEL, b, false, true));
/*     */               }));
/*     */       }
/* 787 */       if (param1Float >= 0.65F)
/*     */       {
/* 789 */         array.add(new TargetTile.RandomTileValue(5, () -> TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.ENEMIES_WALK_ON_PLATFORMS, 1.0D, false, true))));
/*     */       }
/*     */       
/* 792 */       if (param1Float >= 0.25F)
/*     */       {
/* 794 */         array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */                 int i;
/*     */                 if ((i = MathUtils.round((param1Float - 0.25F) / 0.75F * 5.0F) * 5) < 5) {
/*     */                   i = 5;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.MINERS_INSTALL_DURATION, -i, false, true));
/*     */               }));
/*     */       }
/* 802 */       if (param1Float >= 0.5F)
/*     */       {
/* 804 */         array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */                 int i;
/*     */                 if ((i = MathUtils.round((param1Float - 0.5F) / 0.5F * 10.0F) * 5) < 5) {
/*     */                   i = 5;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.TOWERS_EXPERIENCE_MULTIPLIER, i, false, true));
/*     */               }));
/*     */       }
/* 812 */       if (param1Float >= 0.25F)
/*     */       {
/* 814 */         array.add(new TargetTile.RandomTileValue(5, () -> {
/*     */                 double d;
/*     */                 if ((d = MathUtils.round((param1Float - 0.25F) / 0.75F * 3.0F) / 10.0D) < 0.1D) {
/*     */                   d = 0.1D;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.TOWERS_EXPERIENCE_GENERATION, d, false, true));
/*     */               }));
/*     */       }
/* 822 */       if (param1Float >= 0.5F)
/*     */       {
/* 824 */         array.add(new TargetTile.RandomTileValue(5, () -> {
/*     */                 int i;
/*     */                 if ((i = MathUtils.round((param1Float - 0.5F) / 0.5F * 5.0F)) <= 0) {
/*     */                   i = 1;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.TOWERS_UPGRADE_PRICE, -i, false, true));
/*     */               }));
/*     */       }
/* 832 */       if (param1Float >= 0.7F)
/*     */       {
/* 834 */         array.add(new TargetTile.RandomTileValue(3, () -> TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.TOWERS_SELL_REFUND, 99.0D, true, false))));
/*     */       }
/*     */       
/* 837 */       if (param1Float >= 0.25F)
/*     */       {
/* 839 */         array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */                 if (param1RandomXS128.nextFloat() < 0.1F) {
/*     */                   TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.STARTING_HEALTH, 1.0D, true, false));
/*     */                   
/*     */                   return;
/*     */                 } 
/*     */                 
/*     */                 int i;
/*     */                 if ((i = MathUtils.round((param1Float - 0.25F) / 0.75F * 5.0F) << 1) < 2) {
/*     */                   i = 2;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.STARTING_HEALTH, i, false, true));
/*     */               }));
/*     */       }
/* 853 */       array.add(new TargetTile.RandomTileValue(10, () -> {
/*     */               int i;
/*     */               if ((i = MathUtils.round(param1Float * 5.0F) * 10) < 10) {
/*     */                 i = 10;
/*     */               }
/*     */               TargetTile.b(param1TargetTile).add(new GameValueConfig(GameValueType.STARTING_MONEY, i, false, true));
/*     */             }));
/* 860 */       for (j = (arrayOfGameValueType = GameValueType.sharedTowerStats).length, k = 0; k < j; ) { GameValueType gameValueType = arrayOfGameValueType[k];
/*     */         
/* 862 */         array.add(new TargetTile.RandomTileValue(3, () -> {
/*     */                 int i;
/*     */                 if ((i = MathUtils.round(param1RandomXS128.nextFloat() * param1Float * 5.0F) * 10) < 10) {
/*     */                   i = 10;
/*     */                 }
/*     */                 TargetTile.b(param1TargetTile).add(new GameValueConfig(param1GameValueType, i, false, true));
/*     */               }));
/*     */         k++; }
/*     */       
/* 871 */       int i = 0;
/* 872 */       for (j = 0; j < array.size; j++) {
/* 873 */         i += ((TargetTile.RandomTileValue)array.get(j)).a;
/*     */       }
/*     */       
/* 876 */       RarityType rarityType = ProgressManager.getRarityFromQuality(param1Float);
/*     */       
/* 878 */       switch (TargetTile.null.a[rarityType.ordinal()]) { case 1:
/* 879 */           k = param1RandomXS128.nextInt(3); break;
/* 880 */         case 2: k = 3 + param1RandomXS128.nextInt(2); break;
/* 881 */         case 3: k = 5 + param1RandomXS128.nextInt(2); break;
/* 882 */         case 4: k = 7 + param1RandomXS128.nextInt(2); break;
/* 883 */         default: k = 9 + param1RandomXS128.nextInt(2);
/*     */           break; }
/*     */       
/* 886 */       for (byte b2 = 0; b2 < k; b2++) {
/* 887 */         int m = param1RandomXS128.nextInt(i);
/* 888 */         int n = 0;
/* 889 */         for (b1 = 0; b1 < array.size; b1++) {
/* 890 */           if (n + ((TargetTile.RandomTileValue)array.get(b1)).a >= m && 
/* 891 */             !((TargetTile.RandomTileValue)array.get(b1)).c) {
/* 892 */             ((TargetTile.RandomTileValue)array.get(b1)).b.run();
/* 893 */             ((TargetTile.RandomTileValue)array.get(b1)).c = true;
/*     */             
/*     */             break;
/*     */           } 
/* 897 */           n += ((TargetTile.RandomTileValue)array.get(b1)).a;
/*     */         } 
/*     */       } 
/*     */       
/* 901 */       Threads.sortGdxArray(TargetTile.b(targetTile), (param1GameValueConfig1, param1GameValueConfig2) -> (param1GameValueConfig1.getType() == param1GameValueConfig2.getType()) ? 0 : ((param1GameValueConfig1.getType().ordinal() > param1GameValueConfig2.getType().ordinal()) ? -1 : 1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 907 */       return targetTile;
/*     */     }
/*     */ 
/*     */     
/*     */     public TargetTile fromJson(JsonValue param1JsonValue) {
/* 912 */       TargetTile targetTile = (TargetTile)super.fromJson(param1JsonValue);
/*     */       
/* 914 */       if (param1JsonValue.has("d")) {
/*     */         JsonValue jsonValue;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 920 */         if ((jsonValue = (param1JsonValue = param1JsonValue.get("d")).get("gv")) != null) {
/* 921 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */             try {
/* 923 */               GameValueConfig gameValueConfig = GameValueConfig.fromJson(jsonValue1);
/* 924 */               TargetTile.b(targetTile).add(gameValueConfig);
/* 925 */             } catch (Exception exception) {
/* 926 */               TargetTile.a().e("failed to load GV", new Object[] { exception });
/*     */             }  }
/*     */         
/*     */         }
/*     */         
/* 931 */         TargetTile.b(targetTile).sort(TargetTile.b());
/*     */         
/* 933 */         TargetTile.b(targetTile, param1JsonValue.getBoolean("da", false));
/* 934 */         TargetTile.a(targetTile, param1JsonValue.getBoolean("usgv", false));
/*     */       } 
/*     */       
/* 937 */       return targetTile;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RandomTileValue {
/*     */     int a;
/*     */     Runnable b;
/*     */     boolean c;
/*     */     
/*     */     public RandomTileValue(int param1Int, Runnable param1Runnable) {
/* 947 */       this.a = param1Int;
/* 948 */       this.b = param1Runnable;
/*     */     } }
/*     */   
/*     */   private static class ExplosionInterpolation extends Interpolation {
/*     */     private ExplosionInterpolation() {}
/*     */     
/*     */     public float apply(float param1Float) {
/* 955 */       return Interpolation.pow2In.apply(param1Float) * 0.2F + Interpolation.pow5In.apply(param1Float) * 0.3F;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\TargetTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */