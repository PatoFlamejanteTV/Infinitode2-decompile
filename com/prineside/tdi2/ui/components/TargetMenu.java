/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntFloatMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.abilities.OverloadAbility;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.AbilityApply;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.items.GameValueLevelItem;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TargetMenu
/*     */ {
/*  49 */   private static final Color a = new Color(623191551);
/*     */   
/*     */   private final SideMenu.SideMenuContainer b;
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private Table d;
/*     */   
/*     */   private Image e;
/*     */   
/*     */   private Image f;
/*     */   private Label g;
/*  61 */   private int h = 0;
/*     */ 
/*     */   
/*     */   private GameSystemProvider i;
/*     */   
/*  66 */   private static final StringBuilder j = new StringBuilder();
/*  67 */   private static final IntFloatMap k = new IntFloatMap();
/*     */   
/*     */   public TargetMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  70 */     this.i = paramGameSystemProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.b = paramSideMenu.createContainer("TargetMenu");
/*     */     
/*  77 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label2;
/*     */     
/*  81 */     (label2 = new Label(Game.i.localeManager.i18n.get("tile_name_TARGET").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setSize(460.0F, 26.0F);
/*  82 */     label2.setPosition(40.0F, 994.0F + i);
/*  83 */     this.b.addActor((Actor)label2);
/*     */ 
/*     */     
/*  86 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("icon-ability"));
/*  87 */     this.e.setColor(MaterialColor.RED.P500);
/*  88 */     this.e.setSize(48.0F, 48.0F);
/*  89 */     this.e.setPosition(450.0F, 986.0F + i);
/*  90 */     this.e.setTouchable(Touchable.enabled);
/*  91 */     this.e.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  94 */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("abilities_not_available_on_map"));
/*     */           }
/*     */         });
/*  97 */     this.b.addActor((Actor)this.e);
/*     */ 
/*     */     
/* 100 */     this.f = new Image((Drawable)Game.i.assetManager.getDrawable("icon-research"));
/* 101 */     this.f.setColor(MaterialColor.RED.P500);
/* 102 */     this.f.setSize(48.0F, 48.0F);
/* 103 */     this.f.setPosition(514.0F, 986.0F + i);
/* 104 */     this.f.setTouchable(Touchable.enabled);
/* 105 */     this.f.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 108 */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("map_not_affected_by_researches"));
/*     */           }
/*     */         });
/* 111 */     this.b.addActor((Actor)this.f);
/*     */ 
/*     */ 
/*     */     
/* 115 */     (label2 = new Label(Game.i.localeManager.i18n.get("tile_description_TARGET"), Game.i.assetManager.getLabelStyle(24))).setSize(420.0F, 100.0F);
/* 116 */     label2.setPosition(40.0F, 884.0F + i);
/* 117 */     label2.setAlignment(10);
/* 118 */     label2.setWrap(true);
/* 119 */     this.b.addActor((Actor)label2);
/*     */     
/*     */     Table table;
/*     */     
/* 123 */     (table = new Table()).setSize(600.0F, 52.0F);
/* 124 */     table.setBackground(Game.i.assetManager.getDrawable("blank").tint(a));
/* 125 */     table.setPosition(0.0F, 886.0F + i);
/* 126 */     this.b.addActor((Actor)table);
/*     */     
/* 128 */     Label label3 = new Label(Game.i.localeManager.i18n.get("base_menu_gained_green_papers"), Game.i.assetManager.getLabelStyle(24));
/* 129 */     table.add((Actor)label3).expandX().fillX().height(52.0F).padLeft(40.0F);
/*     */     
/*     */     Image image;
/* 132 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setColor(MaterialColor.GREEN.P500);
/* 133 */     table.add((Actor)image).size(32.0F).padTop(10.0F).padBottom(10.0F).padRight(8.0F);
/*     */     
/* 135 */     this.g = new Label("0", Game.i.assetManager.getLabelStyle(24));
/* 136 */     this.g.setColor(MaterialColor.GREEN.P500);
/* 137 */     table.add((Actor)this.g).height(52.0F).padRight(40.0F);
/*     */ 
/*     */     
/*     */     Label label1;
/*     */ 
/*     */     
/* 143 */     (label1 = new Label(Game.i.localeManager.i18n.get("effect").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/* 144 */     label1.setPosition(40.0F, 846.0F + i);
/* 145 */     label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 146 */     this.b.addActor((Actor)label1);
/*     */ 
/*     */     
/* 149 */     (label1 = new Label(Game.i.localeManager.i18n.get("ignores_researches_short").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/* 150 */     label1.setAlignment(16);
/* 151 */     label1.setPosition(340.0F, 846.0F + i);
/* 152 */     label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 153 */     this.b.addActor((Actor)label1);
/*     */ 
/*     */     
/* 156 */     (label1 = new Label(Game.i.localeManager.i18n.get("value_units").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/* 157 */     label1.setPosition(460.0F, 846.0F + i);
/* 158 */     label1.setAlignment(16);
/* 159 */     label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 160 */     this.b.addActor((Actor)label1);
/*     */     
/* 162 */     this.d = new Table();
/*     */     ScrollPane scrollPane;
/* 164 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.d));
/* 165 */     scrollPane.setSize(600.0F, 830.0F + i);
/* 166 */     this.b.addActor((Actor)scrollPane);
/*     */ 
/*     */ 
/*     */     
/* 170 */     paramSideMenu.addListener((SideMenu.SideMenuListener)new SideMenu.SideMenuListener.SideMenuListenerAdapter(this)
/*     */         {
/*     */           public void offscreenChanged() {
/* 173 */             TargetMenu.a(this.a);
/*     */           }
/*     */         });
/* 176 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.TARGET) {
/*     */             b();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 185 */     paramGameSystemProvider.events.getListeners(AbilityApply.class).add(paramAbilityApply -> {
/*     */           if (this.c && paramAbilityApply.getAbility() instanceof OverloadAbility) {
/*     */             b();
/*     */           }
/*     */         });
/* 190 */     paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).add(paramEnemyReachTarget -> {
/*     */           if (this.c) {
/*     */             b();
/*     */           }
/*     */         });
/*     */     
/* 196 */     this.b.hide();
/*     */   }
/*     */   
/*     */   private void a() {
/* 200 */     int i = this.i.gameState.calculatePrizeGreenPapers();
/* 201 */     if (this.h != i) {
/* 202 */       this.g.setText((CharSequence)StringFormatter.commaSeparatedNumber(i));
/* 203 */       this.h = i;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 208 */     if (this.c != paramBoolean) {
/* 209 */       this.c = paramBoolean;
/* 210 */       if (paramBoolean) {
/* 211 */         this.b.show();
/*     */         return;
/*     */       } 
/* 214 */       this.b.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Drawable paramDrawable, String paramString1, String paramString2) {
/*     */     Group group;
/* 221 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image2;
/* 224 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 225 */     image2.setColor(a);
/* 226 */     group.addActor((Actor)image2);
/*     */     
/*     */     Image image1;
/* 229 */     (image1 = new Image(paramDrawable)).setPosition(40.0F, 6.0F);
/* 230 */     image1.setSize(40.0F, 40.0F);
/* 231 */     group.addActor((Actor)image1);
/*     */     
/*     */     LimitedWidthLabel limitedWidthLabel;
/* 234 */     (limitedWidthLabel = new LimitedWidthLabel(paramString1, 24, 21, 420.0F)).setSize(300.0F, 52.0F);
/* 235 */     limitedWidthLabel.setPosition(96.0F, 0.0F);
/* 236 */     group.addActor((Actor)limitedWidthLabel);
/*     */     
/*     */     Label label;
/* 239 */     (label = new Label(paramString2, Game.i.assetManager.getLabelStyle(24))).setPosition(460.0F, 0.0F);
/* 240 */     label.setSize(100.0F, 52.0F);
/* 241 */     label.setAlignment(16);
/* 242 */     group.addActor((Actor)label);
/*     */     
/* 244 */     this.d.add((Actor)group).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(GameValueType paramGameValueType, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     Group group;
/* 252 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image;
/* 255 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 256 */     image.setColor(a);
/* 257 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 260 */     (image = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(paramGameValueType).createIconForBackground(new Color(623191551)))).setPosition(40.0F, 6.0F);
/* 261 */     image.setSize(40.0F, 40.0F);
/* 262 */     group.addActor((Actor)image);
/*     */     
/*     */     LimitedWidthLabel limitedWidthLabel;
/* 265 */     (limitedWidthLabel = new LimitedWidthLabel((CharSequence)Game.i.gameValueManager.getTitle(paramGameValueType), 24, 21, 420.0F)).setSize(300.0F, 52.0F);
/* 266 */     limitedWidthLabel.setPosition(96.0F, 0.0F);
/*     */     
/* 268 */     limitedWidthLabel.setTouchable(Touchable.enabled);
/* 269 */     limitedWidthLabel.addListener((EventListener)new ClickListener(this, paramGameValueType)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 272 */             Dialog.i().showAlert((CharSequence)Game.i.gameValueManager.getTitle(this.a));
/*     */           }
/*     */         });
/*     */     
/* 276 */     group.addActor((Actor)limitedWidthLabel);
/*     */     
/* 278 */     if (!paramBoolean1) {
/*     */       Image image1;
/* 280 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setSize(32.0F, 32.0F);
/* 281 */       image1.setPosition(414.0F, 10.0F);
/* 282 */       group.addActor((Actor)image1);
/*     */     } 
/*     */     
/* 285 */     j.setLength(0);
/*     */     GameValueManager.ValueUnits valueUnits;
/* 287 */     if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(paramGameValueType)).units) == GameValueManager.ValueUnits.BOOLEAN) {
/*     */       
/* 289 */       if (paramDouble == 0.0D)
/*     */       {
/* 291 */         j.append(Game.i.localeManager.i18n.get("disabled").toLowerCase(Locale.ENGLISH));
/*     */       }
/*     */     } else {
/* 294 */       j.append(Game.i.gameValueManager.formatEffectValue(paramDouble, valueUnits));
/* 295 */       if (paramBoolean2) {
/* 296 */         j.setCharAt(0, '=');
/*     */       }
/* 298 */       if (j.length == 1) {
/* 299 */         j.append('0');
/*     */       }
/*     */     } 
/*     */     Label label;
/* 303 */     (label = new Label((CharSequence)j, Game.i.assetManager.getLabelStyle(24))).setPosition(460.0F, 0.0F);
/* 304 */     label.setSize(100.0F, 52.0F);
/* 305 */     label.setAlignment(16);
/* 306 */     group.addActor((Actor)label);
/*     */     
/* 308 */     this.d.add((Actor)group).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */   }
/*     */   
/*     */   private void b() {
/* 312 */     Tile tile = this.i._gameMapSelection.getSelectedTile();
/*     */     
/* 314 */     this.b.setLabelOverTitleTilePos(tile);
/*     */     
/* 316 */     this.d.clearChildren();
/* 317 */     if (tile != null && tile.type == TileType.TARGET) {
/* 318 */       TargetTile targetTile = (TargetTile)tile;
/*     */ 
/*     */       
/* 321 */       this.e.setVisible(targetTile.isDisableAbilities());
/* 322 */       this.f.setVisible(targetTile.isUseStockGameValues());
/*     */       
/*     */       Array array;
/* 325 */       if ((array = targetTile.getGameValues()).size != 0) {
/* 326 */         for (byte b1 = 0; b1 < array.size; b1++) {
/* 327 */           GameValueConfig gameValueConfig = (GameValueConfig)array.get(b1);
/* 328 */           a(gameValueConfig.getType(), gameValueConfig.getValue(), gameValueConfig.isAllowBonuses(), gameValueConfig.isOverwrite());
/*     */         } 
/*     */       } else {
/*     */         Label label;
/* 332 */         (label = new Label(Game.i.localeManager.i18n.get("base_has_no_effects"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 333 */         this.d.add((Actor)label).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */       } 
/*     */ 
/*     */       
/* 337 */       OverloadAbility overloadAbility = null;
/* 338 */       for (byte b = 0; b < this.i.ability.activeAbilities.size; b++) {
/*     */         Ability ability;
/* 340 */         if (ability = (Ability)this.i.ability.activeAbilities.get(b) instanceof OverloadAbility) {
/* 341 */           overloadAbility = (OverloadAbility)ability;
/*     */           break;
/*     */         } 
/*     */       } 
/* 345 */       if (overloadAbility != null) {
/* 346 */         Table table = new Table();
/* 347 */         this.d.add((Actor)table).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */         
/*     */         Label label;
/* 350 */         (label = new Label(Game.i.localeManager.i18n.get("ability_name_OVERLOAD"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.DEEP_ORANGE.P500);
/* 351 */         table.add((Actor)label).padRight(16.0F);
/*     */         
/*     */         Image image;
/* 354 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-overload"))).setColor(MaterialColor.DEEP_ORANGE.P500);
/* 355 */         table.add((Actor)image).size(32.0F).padRight(4.0F);
/*     */ 
/*     */         
/* 358 */         (label = new Label("x" + overloadAbility.getLevel(), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.DEEP_ORANGE.P500);
/* 359 */         table.add((Actor)label);
/*     */         
/* 361 */         a((Drawable)Game.i.assetManager.getDrawable("icon-enemy-heart"), Game.i.localeManager.i18n.get("base_menu_overload_toughness"), StringFormatter.commaSeparatedNumber(MathUtils.round(overloadAbility.getDifficulty() * 100.0F + 100.0F)).toString() + "%");
/* 362 */         a((Drawable)Game.i.assetManager.getDrawable("icon-pickaxe"), Game.i.localeManager.i18n.get("mining_speed"), StringFormatter.commaSeparatedNumber(MathUtils.round(overloadAbility.getMiningSpeed() * 100.0F + 100.0F)).toString() + "%");
/*     */       } 
/*     */ 
/*     */       
/* 366 */       if (this.i.gameState.basicLevelName != null) {
/* 367 */         k.clear();
/*     */         
/* 369 */         BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(this.i.gameState.basicLevelName); byte b1;
/* 370 */         for (b1 = 0; b1 < basicLevel.quests.size; b1++) {
/*     */           BasicLevelQuestConfig basicLevelQuestConfig;
/* 372 */           if ((basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel.quests.items)[b1]).wasEverCompleted())
/*     */           {
/* 374 */             for (byte b2 = 0; b2 < basicLevelQuestConfig.prizes.size; b2++) {
/*     */               ItemStack itemStack;
/* 376 */               if ((itemStack = ((ItemStack[])basicLevelQuestConfig.prizes.items)[b2]).getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/* 377 */                 GameValueLevelItem gameValueLevelItem = (GameValueLevelItem)itemStack.getItem();
/* 378 */                 float f = k.get(gameValueLevelItem.gameValueType.ordinal(), 0.0F);
/* 379 */                 k.put(gameValueLevelItem.gameValueType.ordinal(), f + (float)gameValueLevelItem.delta);
/*     */               } 
/*     */             }  } 
/*     */         } 
/* 383 */         for (b1 = 0; b1 < basicLevel.waveQuests.size; b1++) {
/*     */           BasicLevel.WaveQuest waveQuest;
/* 385 */           if ((waveQuest = ((BasicLevel.WaveQuest[])basicLevel.waveQuests.items)[b1]).isCompleted())
/*     */           {
/* 387 */             for (byte b2 = 0; b2 < waveQuest.prizes.size; b2++) {
/*     */               ItemStack itemStack;
/* 389 */               if ((itemStack = ((ItemStack[])waveQuest.prizes.items)[b2]).getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/* 390 */                 GameValueLevelItem gameValueLevelItem = (GameValueLevelItem)itemStack.getItem();
/* 391 */                 float f = k.get(gameValueLevelItem.gameValueType.ordinal(), 0.0F);
/* 392 */                 k.put(gameValueLevelItem.gameValueType.ordinal(), f + (float)gameValueLevelItem.delta);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/* 397 */         if (!k.isEmpty()) {
/*     */           Label label;
/* 399 */           (label = new Label(Game.i.localeManager.i18n.get("quests"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 400 */           label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 401 */           this.d.add((Actor)label).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */           
/* 403 */           for (IntFloatMap.Entry entry : k) {
/* 404 */             a(GameValueType.values[entry.key], entry.value, true, false);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 410 */     this.d.add().expandX().fillX().height(40.0F).row();
/* 411 */     this.d.add().expand().fill();
/*     */     
/* 413 */     a();
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 417 */     if (this.c)
/* 418 */       a(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\TargetMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */