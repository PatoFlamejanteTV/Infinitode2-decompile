/*     */ package com.prineside.tdi2.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Building;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.SpaceTileBonus;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.shapes.RangeCircle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.AimStrategySelector;
/*     */ import com.prineside.tdi2.ui.actors.EffectTooltip;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class PlatformTile extends Tile implements KryoSerializable {
/*  61 */   public SpaceTileBonusType bonusType = null;
/*  62 */   public int bonusLevel = 0;
/*     */ 
/*     */   
/*     */   public Building building;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  69 */     super.write(paramKryo, paramOutput);
/*  70 */     paramKryo.writeObjectOrNull(paramOutput, this.bonusType, SpaceTileBonusType.class);
/*  71 */     paramOutput.writeVarInt(this.bonusLevel, true);
/*  72 */     paramKryo.writeClassAndObject(paramOutput, this.building);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  77 */     super.read(paramKryo, paramInput);
/*  78 */     this.bonusType = (SpaceTileBonusType)paramKryo.readObjectOrNull(paramInput, SpaceTileBonusType.class);
/*  79 */     this.bonusLevel = paramInput.readVarInt(true);
/*  80 */     this.building = (Building)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   private PlatformTile() {
/*  83 */     super(TileType.PLATFORM);
/*     */   }
/*     */   
/*     */   public final void getData(IntArray paramIntArray) {
/*  87 */     if (this.bonusType != null) {
/*  88 */       paramIntArray.add(ItemDataType.BONUS_TYPE.ordinal(), this.bonusType.ordinal());
/*     */     }
/*  90 */     paramIntArray.add(ItemDataType.BONUS_LEVEL.ordinal(), (this.bonusType == null) ? 0 : this.bonusLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillInventoryWithInfo(Table paramTable, float paramFloat) {
/*  95 */     if (this.bonusType != null && this.bonusLevel != 0) {
/*  96 */       Color color = SpaceTileBonus.getBrightColor(this.bonusType);
/*     */       
/*     */       Image image;
/*  99 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(SpaceTileBonus.getIconName(this.bonusType)))).setColor(color);
/* 100 */       paramTable.add((Actor)image).size(64.0F).row();
/*     */       
/*     */       Label label;
/* 103 */       (label = new Label((CharSequence)SpaceTileBonus.getDetailedName(this.bonusType, this.bonusLevel), Game.i.assetManager.getLabelStyle(21))).setColor(color);
/* 104 */       label.setWrap(true);
/* 105 */       label.setAlignment(1);
/* 106 */       paramTable.add((Actor)label).width(paramFloat).padTop(4.0F).row();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 112 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/* 114 */     if (this.bonusLevel > 0 && this.bonusType != null) {
/*     */       EffectTooltip effectTooltip;
/* 116 */       (effectTooltip = new EffectTooltip((Drawable)Game.i.assetManager.getDrawable(SpaceTileBonus.getIconName(this.bonusType)), (CharSequence)SpaceTileBonus.getDetailedName(this.bonusType, this.bonusLevel))).setHint(Game.i.localeManager.i18n.get("tile_effect"));
/* 117 */       effectTooltip.setColor(SpaceTileBonus.getBrightColor(this.bonusType));
/* 118 */       paramTable.add((Actor)effectTooltip).growX().row();
/*     */     } 
/*     */     
/* 121 */     if (paramMapEditorItemInfoMenu.isSelectionFromInventory())
/*     */       return; 
/* 123 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/*     */       
/* 125 */       if (this.building == null || this.building.buildingType == BuildingType.TOWER) {
/*     */         Label label;
/* 127 */         (label = new Label("Tower type", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 128 */         paramTable.add((Actor)label).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */         
/*     */         SelectBox selectBox;
/* 131 */         (selectBox = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_tower_type_select");
/*     */         Array array;
/* 133 */         (array = new Array()).add(Game.i.localeManager.i18n.get("no_tower"));
/* 134 */         for (byte b = 0; b < TowerType.values.length; b++) {
/* 135 */           array.add(TowerType.values[b].name());
/*     */         }
/* 137 */         selectBox.setItems(array);
/* 138 */         paramTable.add((Actor)selectBox).height(48.0F).padBottom(8.0F).growX().row();
/*     */         
/* 140 */         if (this.building != null && this.building.buildingType == BuildingType.TOWER) {
/* 141 */           selectBox.setSelected(((Tower)this.building).type.name());
/*     */         } else {
/* 143 */           selectBox.setSelected(Game.i.localeManager.i18n.get("no_tower"));
/*     */         } 
/* 145 */         selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramMapEditorItemInfoMenu)
/*     */             {
/*     */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                 String str;
/* 149 */                 if ((str = (String)this.a.getSelected()).equals(Game.i.localeManager.i18n.get("no_tower"))) {
/* 150 */                   if (this.c.building != null) {
/* 151 */                     this.c.building.setTile(null);
/* 152 */                     this.c.building = null;
/*     */                   }
/*     */                 
/*     */                 } else {
/*     */                   
/* 157 */                   if (this.c.building != null) {
/* 158 */                     this.c.building.setTile(null);
/*     */                   }
/* 160 */                   this.c.building = (Building)Game.i.towerManager.getFactory(TowerType.valueOf(str)).create();
/* 161 */                   this.c.building.setTile(this.c);
/*     */                 } 
/* 163 */                 this.b.notifySelectedElementChanged();
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 169 */       if (this.building == null || this.building.buildingType == BuildingType.MODIFIER) {
/*     */         Label label;
/* 171 */         (label = new Label("Modifier type", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 172 */         paramTable.add((Actor)label).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */         
/*     */         SelectBox selectBox;
/* 175 */         (selectBox = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_modifier_type_select");
/*     */         Array array;
/* 177 */         (array = new Array()).add("No modifier");
/* 178 */         for (byte b = 0; b < ModifierType.values.length; b++) {
/* 179 */           array.add(ModifierType.values[b].name());
/*     */         }
/* 181 */         selectBox.setItems(array);
/* 182 */         paramTable.add((Actor)selectBox).height(48.0F).padBottom(8.0F).growX().row();
/*     */         
/* 184 */         if (this.building != null && this.building.buildingType == BuildingType.MODIFIER) {
/* 185 */           selectBox.setSelected(((Modifier)this.building).type.name());
/*     */         } else {
/* 187 */           selectBox.setSelected("No modifier");
/*     */         } 
/* 189 */         selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramMapEditorItemInfoMenu)
/*     */             {
/*     */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */                 String str;
/* 193 */                 if ((str = (String)this.a.getSelected()).equals("No modifier")) {
/* 194 */                   if (this.c.building != null) {
/* 195 */                     this.c.building.setTile(null);
/* 196 */                     this.c.building = null;
/*     */                   } 
/*     */                 } else {
/*     */                   
/* 200 */                   if (this.c.building != null) {
/* 201 */                     this.c.building.setTile(null);
/*     */                   }
/* 203 */                   this.c.building = (Building)Game.i.modifierManager.getFactory(ModifierType.valueOf(str)).create();
/* 204 */                   this.c.building.setTile(this.c);
/*     */                 } 
/* 206 */                 this.b.notifySelectedElementChanged();
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 211 */       if (this.building != null) {
/* 212 */         if (this.building.buildingType == BuildingType.TOWER) {
/* 213 */           Tower tower = (Tower)this.building;
/*     */           
/*     */           Label label3;
/*     */           
/* 217 */           (label3 = new Label("Aim mode", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 218 */           paramTable.add((Actor)label3).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */           
/* 220 */           AimStrategySelector aimStrategySelector = new AimStrategySelector();
/* 221 */           paramTable.add((Actor)aimStrategySelector).padBottom(8.0F).row();
/* 222 */           aimStrategySelector.setStrategy(tower.aimStrategy, false, false);
/* 223 */           aimStrategySelector.addListener(paramAimStrategy -> {
/*     */                 paramTower.aimStrategy = paramAimStrategy;
/*     */ 
/*     */                 
/*     */                 paramMapEditorItemInfoMenu.notifySelectedElementChanged();
/*     */               });
/*     */           
/* 230 */           (label3 = new Label("XP level", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 231 */           paramTable.add((Actor)label3).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */           
/*     */           SelectBox selectBox2;
/* 234 */           (selectBox2 = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_tower_experience_select");
/* 235 */           Array array2 = new Array();
/* 236 */           for (byte b2 = 1; b2 <= 'ϧ'; b2++) {
/* 237 */             array2.add(Tower.LEVEL_EXPERIENCE_MILESTONES[b2] + " - " + b2 + "LVL");
/*     */           }
/* 239 */           selectBox2.setItems(array2);
/* 240 */           paramTable.add((Actor)selectBox2).growX().height(48.0F).padBottom(8.0F).row();
/*     */           
/* 242 */           String str = StrictMath.round(tower.experience) + " - " + Tower.getLevelForExperienceFast(tower.experience) + "LVL";
/* 243 */           selectBox2.setSelected(str);
/*     */           
/* 245 */           selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2, tower, paramMapEditorItemInfoMenu)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor)
/*     */                 {
/* 249 */                   String str, arrayOfString[] = (str = (String)this.a.getSelected()).split(" ");
/* 250 */                   this.b.experience = Integer.parseInt(arrayOfString[0]);
/* 251 */                   this.b.calculateXpLevel(true);
/* 252 */                   this.c.notifySelectedElementChanged();
/*     */                 }
/*     */               });
/*     */           
/*     */           Label label2;
/*     */           
/* 258 */           (label2 = new Label("Upgrade level", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 259 */           paramTable.add((Actor)label2).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */           
/*     */           SelectBox selectBox1;
/* 262 */           (selectBox1 = new SelectBox(paramMapEditorItemInfoMenu.selectBoxStyle)).setName("map_editor_menu_tower_upgrade_level_select");
/* 263 */           Array array1 = new Array();
/* 264 */           for (byte b3 = 0; b3 <= 10; b3++) {
/* 265 */             array1.add(String.valueOf(b3));
/*     */           }
/* 267 */           selectBox1.setItems(array1);
/* 268 */           paramTable.add((Actor)selectBox1).growX().height(48.0F).padBottom(8.0F).row();
/*     */           
/* 270 */           selectBox1.setSelected(String.valueOf(tower.getUpgradeLevel()));
/*     */           
/* 272 */           selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1, tower, paramMapEditorItemInfoMenu)
/*     */               {
/*     */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 275 */                   String str = (String)this.a.getSelected();
/* 276 */                   this.b.setUpgradeLevel((byte)Integer.parseInt(str));
/* 277 */                   this.c.notifySelectedElementChanged();
/*     */                 }
/*     */               });
/*     */           
/*     */           Label label1;
/*     */           
/* 283 */           (label1 = new Label("Abilities", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 284 */           paramTable.add((Actor)label1).padBottom(4.0F).padTop(4.0F).growX().row();
/*     */           
/* 286 */           Table table = new Table();
/* 287 */           paramTable.add((Actor)table).growX().height(56.0F).row();
/* 288 */           for (byte b1 = 0; b1 < 6; b1++) {
/*     */             Group group;
/* 290 */             (group = new Group()).setTransform(false);
/* 291 */             table.add((Actor)group).size(56.0F);
/*     */             
/* 293 */             Quad quad1 = Game.i.towerManager.getFactory(tower.type).getBaseTextures();
/*     */             Image image1;
/* 295 */             (image1 = new Image((Drawable)quad1)).setSize(56.0F, 56.0F);
/* 296 */             image1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 297 */             group.addActor((Actor)image1);
/*     */             
/* 299 */             Quad quad2 = Game.i.towerManager.getFactory(tower.type).getAbilityTextures(b1);
/*     */             Image image2;
/* 301 */             (image2 = new Image((Drawable)quad2)).setSize(56.0F, 56.0F);
/* 302 */             image2.setTouchable(Touchable.disabled);
/* 303 */             group.addActor((Actor)image2);
/*     */             
/* 305 */             if (!tower.installedAbilities[b1]) {
/* 306 */               image2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */             }
/*     */             
/* 309 */             if (!tower.installedAbilities[b1]) {
/* 310 */               image1.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*     */             }
/*     */             
/* 313 */             group.setTouchable(Touchable.enabled);
/* 314 */             byte b = b1;
/* 315 */             group.addListener((EventListener)new ClickListener(this, tower, b, paramMapEditorItemInfoMenu)
/*     */                 {
/*     */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 318 */                     this.a.installedAbilities[this.b] = !this.a.installedAbilities[this.b];
/* 319 */                     this.c.notifySelectedElementChanged();
/*     */                   }
/*     */                 });
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int generateSeedSalt() {
/* 334 */     if (this.bonusType == null || this.bonusLevel == 0) return 0;
/*     */     
/* 336 */     return this.bonusLevel + 6 * this.bonusType.ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/* 341 */     super.setUnregistered();
/*     */     
/* 343 */     this.building = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawSelectedRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/* 348 */     if (this.building != null) {
/* 349 */       this.building.drawSelectedRange(paramBatch, paramRangeCircle);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawHoveredRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/* 355 */     if (this.building != null) {
/* 356 */       this.building.drawHoveredRange(paramBatch, paramRangeCircle);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/* 362 */     float f = paramFloat / 128.0F;
/*     */     Group group;
/* 364 */     (group = new Group()).setTransform(false);
/*     */     Image image;
/* 366 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.PLATFORM.a))).setSize(128.0F * f, 128.0F * f);
/* 367 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 370 */     (image = new Image((Drawable)new TextureRegionDrawable(Game.i.tileManager.F.PLATFORM.c[(this.bonusType == null) ? 0 : this.bonusLevel]))).setSize(128.0F * f, 128.0F * f);
/* 371 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 374 */     if (this.bonusType != null && this.bonusLevel != 0) {
/*     */       
/* 376 */       f = paramFloat / 32.0F * 11.0F;
/* 377 */       float f1 = paramFloat - f * 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Image image1;
/*     */ 
/*     */ 
/*     */       
/* 386 */       (image1 = new Image(Game.i.tileManager.F.PLATFORM.d[this.bonusType.ordinal()])).setSize(f1, f1);
/* 387 */       image1.setPosition(f, f);
/* 388 */       image1.setColor(SpaceTileBonus.getColor(this.bonusType));
/* 389 */       group.addActor((Actor)image1);
/*     */       
/* 391 */       if (this.bonusLevel > 1) {
/*     */         Image image2;
/*     */         
/* 394 */         (image2 = new Image(Game.i.tileManager.F.PLATFORM.b[this.bonusLevel - 2])).setSize(paramFloat, paramFloat);
/* 395 */         image2.setColor(SpaceTileBonus.getColor(this.bonusType));
/* 396 */         group.addActor((Actor)image2);
/*     */       } 
/*     */     } 
/*     */     
/* 400 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/* 405 */     switch (this.bonusLevel) { case 2:
/* 406 */         return RarityType.RARE;
/* 407 */       case 3: return RarityType.VERY_RARE;
/* 408 */       case 4: return RarityType.EPIC;
/* 409 */       case 5: return RarityType.LEGENDARY; }
/*     */ 
/*     */     
/* 412 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getWalkCost(boolean paramBoolean) {
/* 417 */     if (paramBoolean) {
/* 418 */       if (this.building == null) {
/* 419 */         return 1.0F;
/*     */       }
/* 421 */       return 1.0F * this.building.getWalkCost();
/*     */     } 
/*     */     
/* 424 */     if (this.building == null) {
/* 425 */       return 512.0F;
/*     */     }
/* 427 */     return 512.0F * this.building.getWalkCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/* 434 */     return ItemSubcategoryType.ME_PLATFORMS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void from(Tile paramTile) {
/* 439 */     super.from(paramTile);
/* 440 */     paramTile = paramTile;
/*     */     
/* 442 */     this.bonusLevel = ((PlatformTile)paramTile).bonusLevel;
/* 443 */     this.bonusType = ((PlatformTile)paramTile).bonusType;
/* 444 */     this.building = (((PlatformTile)paramTile).building == null) ? null : ((PlatformTile)paramTile).building.cloneBuilding();
/* 445 */     if (this.building != null) this.building.setTile(this);
/*     */   
/*     */   }
/*     */   
/*     */   public final void updateCache() {
/* 450 */     if (this.building != null && this.building.isRegistered()) {
/* 451 */       this.building.updateCache();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/* 457 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*     */     
/* 459 */     paramBatch.draw(Game.i.tileManager.F.PLATFORM.a, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getValue() {
/* 464 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/* 469 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, (this.bonusLevel + 2) * 50));
/*     */     
/* 471 */     switch (this.bonusLevel) {
/*     */       case 1:
/* 473 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_SCALAR, MathUtils.round((this.bonusType.ordinal() + 5) * 1.5F)));
/*     */         return;
/*     */       
/*     */       case 2:
/* 477 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_SCALAR, MathUtils.round((this.bonusType.ordinal() + 7) * 1.6F)));
/* 478 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, MathUtils.round((this.bonusType.ordinal() + 5) * 1.2F)));
/*     */         return;
/*     */       
/*     */       case 3:
/* 482 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_SCALAR, MathUtils.round((this.bonusType.ordinal() + 3) * 1.4F)));
/* 483 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, MathUtils.round((this.bonusType.ordinal() + 7) * 1.3F)));
/* 484 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, MathUtils.round((this.bonusType.ordinal() + 6) * 0.95F)));
/*     */         return;
/*     */       
/*     */       case 4:
/* 488 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, MathUtils.round((this.bonusType.ordinal() + 4) * 1.5F)));
/* 489 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, MathUtils.round((this.bonusType.ordinal() + 8) * 1.1F)));
/* 490 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_TENSOR, MathUtils.round((this.bonusType.ordinal() + 7) * 0.8F)));
/*     */         return;
/*     */       
/*     */       case 5:
/* 494 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, MathUtils.round((this.bonusType.ordinal() + 4) * 1.2F)));
/* 495 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_TENSOR, MathUtils.round((this.bonusType.ordinal() + 7) * 1.1F)));
/* 496 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_INFIAR, MathUtils.round((this.bonusType.ordinal() + 8) * 0.55F)));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/* 504 */     if (this.bonusType == null) return 0.002D; 
/* 505 */     double d = 1.0D + this.bonusType.ordinal() * 0.03D;
/*     */     
/* 507 */     switch (this.bonusLevel) { case 1:
/* 508 */         return d * 0.002D;
/* 509 */       case 2: return d * 0.008D;
/* 510 */       case 3: return d * 0.025D;
/* 511 */       case 4: return d * 0.077D;
/* 512 */       case 5: return d * 0.24D; }
/*     */ 
/*     */     
/* 515 */     return 0.002D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/* 520 */     return (this.bonusLevel < 5 && this.bonusType != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Tile createUpgradedTile() {
/* 525 */     if (!canBeUpgraded()) {
/* 526 */       throw new IllegalStateException("PlatformTile can't be upgraded more");
/*     */     }
/*     */     
/*     */     PlatformTile platformTile;
/* 530 */     (platformTile = Game.i.tileManager.F.PLATFORM.create()).bonusType = this.bonusType;
/* 531 */     this.bonusLevel++;
/* 532 */     platformTile.building = (this.building != null) ? this.building.cloneBuilding() : null;
/*     */     
/* 534 */     return platformTile;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getUpgradePriceInGreenPapers() {
/* 539 */     int i = 250;
/* 540 */     for (byte b = 1; b <= this.bonusLevel; b++) {
/* 541 */       i += b * 150;
/*     */     }
/*     */     
/* 544 */     return i;
/*     */   }
/*     */   
/*     */   public final int getUpgradePriceInAccelerators() {
/* 548 */     return this.bonusLevel;
/*     */   }
/*     */   
/*     */   public final int getUpgradePriceInResources(ResourceType paramResourceType) {
/* 552 */     if (!canBeUpgraded()) return 0;
/*     */     
/* 554 */     switch (this.bonusLevel + 1) {
/*     */       case 2:
/* 556 */         if (paramResourceType == ResourceType.SCALAR) return MathUtils.floor((this.bonusType.ordinal() + 8) * 6.5F); 
/* 557 */         if (paramResourceType == ResourceType.VECTOR) return MathUtils.floor((this.bonusType.ordinal() + 12) * 5.5F);
/*     */         
/*     */         break;
/*     */       case 3:
/* 561 */         if (paramResourceType == ResourceType.VECTOR) return MathUtils.floor((this.bonusType.ordinal() + 12) * 7.0F); 
/* 562 */         if (paramResourceType == ResourceType.MATRIX) return MathUtils.floor((this.bonusType.ordinal() + 17) * 6.0F);
/*     */         
/*     */         break;
/*     */       case 4:
/* 566 */         if (paramResourceType == ResourceType.MATRIX) return MathUtils.floor((this.bonusType.ordinal() + 17) * 7.5F); 
/* 567 */         if (paramResourceType == ResourceType.TENSOR) return MathUtils.floor((this.bonusType.ordinal() + 28) * 7.0F);
/*     */         
/*     */         break;
/*     */       case 5:
/* 571 */         if (paramResourceType == ResourceType.TENSOR) return MathUtils.floor((this.bonusType.ordinal() + 15) * 8.5F); 
/* 572 */         if (paramResourceType == ResourceType.INFIAR) return MathUtils.floor((this.bonusType.ordinal() + 28) * 8.0F);
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 577 */     return 0;
/*     */   }
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/*     */     int i;
/* 582 */     switch (null.a[paramItemSortingType.ordinal()]) {
/*     */       case 1:
/* 584 */         if (this.bonusType == null) {
/* 585 */           return 0;
/*     */         }
/* 587 */         return this.bonusType.ordinal() * 1000 + this.bonusLevel;
/*     */       
/*     */       case 2:
/* 590 */         i = getRarity().ordinal() * 1000;
/* 591 */         if (this.bonusType != null) {
/* 592 */           i += this.bonusType.ordinal() + this.bonusLevel * SpaceTileBonusType.values.length;
/*     */         }
/* 594 */         return i;
/*     */     } 
/*     */ 
/*     */     
/* 598 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/* 603 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 608 */     super.toJson(paramJson);
/*     */     
/* 610 */     if (this.bonusType != null && this.bonusLevel > 0) {
/* 611 */       paramJson.writeObjectStart("d");
/* 612 */       paramJson.writeValue("bt", this.bonusType.name());
/* 613 */       paramJson.writeValue("bl", Integer.valueOf(this.bonusLevel));
/* 614 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */     
/* 617 */     if (this.building != null) {
/* 618 */       paramJson.writeObjectStart("building");
/* 619 */       this.building.toJson(paramJson);
/* 620 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void drawBonusExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2) {
/* 625 */     if (paramBoolean1) paramBatch.draw(Game.i.tileManager.F.PLATFORM.c[(this.bonusType == null) ? 0 : this.bonusLevel], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     
/* 627 */     if (paramBoolean2 && this.bonusType != null && this.bonusLevel > 0) {
/* 628 */       paramBoolean1 = false;
/* 629 */       if (isRegistered()) {
/* 630 */         if (this.S == null) {
/* 631 */           throw new IllegalStateException("S is null");
/*     */         }
/* 633 */         if (this.S._mapRendering == null) {
/* 634 */           throw new IllegalStateException("S._mapRendering is null " + this.S);
/*     */         }
/* 636 */         ObjectSet objectSet = this.S._mapRendering.spaceTileBonusesToDrawColoredOnFreeTiles;
/* 637 */         if (this.S._mapRendering
/*     */           
/* 639 */           .getDrawMode() == MapRenderingSystem.DrawMode.DETAILED || this.S._mapRendering
/* 640 */           .getDrawMode() == MapRenderingSystem.DrawMode.MAP_EDITOR || this.S._mapRendering
/* 641 */           .getDrawMode() == MapRenderingSystem.DrawMode.FULL || objectSet
/* 642 */           .contains(this.bonusType) || Game.i.settingsManager
/*     */           
/* 644 */           .getCustomValue(SettingsManager.CustomValueType.DBG_ALWAYS_DRAW_TILE_EXTRAS) == 1.0D)
/*     */         {
/*     */           
/* 647 */           paramBoolean1 = true;
/*     */         }
/*     */       } else {
/*     */         
/* 651 */         paramBoolean1 = true;
/*     */       } 
/*     */       
/* 654 */       float f1 = paramFloat3 / 32.0F * 11.0F;
/* 655 */       float f2 = paramFloat3 - f1 * 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 661 */       if (paramBoolean1) {
/* 662 */         paramBatch.setColor(SpaceTileBonus.getColor(this.bonusType));
/*     */       } else {
/* 664 */         paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.18F);
/*     */       } 
/*     */       
/* 667 */       if (this.bonusLevel >= 2)
/*     */       {
/* 669 */         paramBatch.draw(Game.i.tileManager.F.PLATFORM.b[this.bonusLevel - 2], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */       }
/*     */ 
/*     */       
/* 673 */       paramBatch.draw(Game.i.tileManager.F.PLATFORM.d[this.bonusType.ordinal()], paramFloat1 + f1, paramFloat2 + f1, f2, f2);
/* 674 */       paramBatch.setColor(Color.WHITE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawExtras(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 680 */     drawBonusExtras(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, true, (paramDrawMode == MapRenderingSystem.DrawMode.FULL || this.building == null));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAs(Tile paramTile) {
/* 685 */     if (!super.sameAs(paramTile)) return false;
/*     */ 
/*     */     
/* 688 */     if ((((PlatformTile)(paramTile = paramTile)).bonusType == null || ((PlatformTile)paramTile).bonusLevel == 0) && (this.bonusType == null || this.bonusLevel == 0)) return true;
/*     */     
/* 690 */     if (((PlatformTile)paramTile).bonusType != this.bonusType) return false; 
/* 691 */     if (((PlatformTile)paramTile).bonusLevel != this.bonusLevel) return false;
/*     */     
/* 693 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final PlatformTile removeExtrasForInventory() {
/* 698 */     this.building = null;
/* 699 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean sameAsWithExtras(Tile paramTile) {
/* 704 */     if (!sameAs(paramTile)) return false;
/*     */     
/* 706 */     paramTile = paramTile;
/* 707 */     if (this.building == null) {
/* 708 */       return (((PlatformTile)paramTile).building == null);
/*     */     }
/* 710 */     return this.building.sameAs(((PlatformTile)paramTile).building);
/*     */   }
/*     */   
/*     */   public static class SpaceTileFactory
/*     */     extends Tile.Factory.AbstractFactory<PlatformTile> {
/*     */     TextureRegion a;
/* 716 */     TextureRegion[] b = new TextureRegion[4];
/* 717 */     TextureRegion[] c = new TextureRegion[6];
/* 718 */     final TextureRegion[] d = new TextureRegion[SpaceTileBonusType.values.length];
/*     */     
/*     */     public SpaceTileFactory() {
/* 721 */       super(TileType.PLATFORM);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 726 */       return 500;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 731 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-platform"); byte b1;
/* 732 */       for (b1 = 2; b1 <= 5; b1++) {
/* 733 */         this.b[b1 - 2] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-platform-extra-" + b1);
/*     */       }
/* 735 */       for (b1 = 0; b1 <= 5; b1++)
/* 736 */         this.c[b1] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-platform-shade-" + b1);  SpaceTileBonusType[] arrayOfSpaceTileBonusType;
/*     */       int i;
/*     */       byte b2;
/* 739 */       for (i = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b2 = 0; b2 < i; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b2];
/* 740 */         this.d[spaceTileBonusType.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion(SpaceTileBonus.getIconName(spaceTileBonusType));
/*     */         b2++; }
/*     */     
/*     */     }
/*     */     
/*     */     public PlatformTile create() {
/* 746 */       return new PlatformTile((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public PlatformTile createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/* 751 */       PlatformTile platformTile = create();
/*     */       
/* 753 */       if (param1Float < 0.075D) {
/* 754 */         platformTile.bonusLevel = 0;
/*     */       } else {
/* 756 */         platformTile.bonusType = SpaceTileBonusType.values[param1RandomXS128.nextInt(SpaceTileBonusType.values.length)];
/* 757 */         if (param1Float < 0.2D) {
/* 758 */           platformTile.bonusLevel = 1;
/* 759 */         } else if (param1Float < 0.4D) {
/* 760 */           platformTile.bonusLevel = 2;
/* 761 */         } else if (param1Float < 0.6D) {
/* 762 */           platformTile.bonusLevel = 3;
/* 763 */         } else if (param1Float < 0.8D) {
/* 764 */           platformTile.bonusLevel = 4;
/*     */         } else {
/* 766 */           platformTile.bonusLevel = 5;
/*     */         } 
/*     */       } 
/*     */       
/* 770 */       return platformTile;
/*     */     }
/*     */ 
/*     */     
/*     */     public PlatformTile fromJson(JsonValue param1JsonValue) {
/* 775 */       PlatformTile platformTile = (PlatformTile)super.fromJson(param1JsonValue);
/*     */       
/* 777 */       if (param1JsonValue.has("d")) {
/* 778 */         JsonValue jsonValue = param1JsonValue.get("d");
/*     */         
/* 780 */         platformTile.bonusType = SpaceTileBonusType.valueOf(jsonValue.getString("bt"));
/* 781 */         platformTile.bonusLevel = jsonValue.getInt("bl");
/* 782 */         if (platformTile.bonusLevel < 0) platformTile.bonusLevel = 0; 
/* 783 */         if (platformTile.bonusLevel > 5) platformTile.bonusLevel = 5; 
/*     */       } 
/* 785 */       if (param1JsonValue.has("building")) {
/* 786 */         Building building = Building.fromJson(param1JsonValue.get("building"));
/* 787 */         platformTile.building = building;
/* 788 */         building.setTile(platformTile);
/*     */       } 
/*     */       
/* 791 */       return platformTile;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\PlatformTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */