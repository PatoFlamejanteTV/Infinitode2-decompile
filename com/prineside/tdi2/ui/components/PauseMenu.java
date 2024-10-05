/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.game.GamePaused;
/*     */ import com.prineside.tdi2.events.game.GameResumed;
/*     */ import com.prineside.tdi2.events.game.RewardingAdRegistered;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.PurchaseManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_BasicLevel;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.systems.LootSystem;
/*     */ import com.prineside.tdi2.ui.actors.AttentionRaysUnderlay;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.HorizontalSlider;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.RightSideMenuButton;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.ItemDescriptionDialog;
/*     */ import com.prineside.tdi2.ui.shared.MusicListOverlay;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public class PauseMenu implements Disposable {
/*  60 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 200, "PauseMenu overlay", true);
/*  61 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 201, "PauseMenu main");
/*  62 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 202, "PauseMenu ad loot bonus");
/*     */   
/*     */   private Group d;
/*     */   
/*     */   private Group e;
/*     */   
/*     */   private Group f;
/*     */   
/*     */   private Group g;
/*     */   private Table h;
/*     */   private Table i;
/*     */   private Label j;
/*     */   private Label k;
/*     */   private Label l;
/*     */   private GameSystemProvider m;
/*     */   
/*     */   public PauseMenu(GameSystemProvider paramGameSystemProvider) {
/*  79 */     this.m = paramGameSystemProvider;
/*     */ 
/*     */     
/*  82 */     this.c.getTable().setVisible(false);
/*     */     
/*  84 */     this.g = new Group();
/*  85 */     this.g.setTransform(false);
/*     */     
/*  87 */     this.c.getTable().add().width(1.0F).expandY().fillY().row();
/*  88 */     this.c.getTable().add((Actor)this.g).size(540.0F, 105.0F).bottom().padBottom(50.0F);
/*     */     
/*     */     Image image1;
/*     */     
/*  92 */     (image1 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setColor(new Color(218959311));
/*  93 */     this.a.getTable().add((Actor)image1).expand().fill();
/*     */     
/*     */     Table table1;
/*  96 */     (table1 = this.b.getTable()).setName("pause_menu");
/*     */     
/*  98 */     Table table3 = new Table();
/*  99 */     table1.add((Actor)table3).expand().fill();
/*     */ 
/*     */     
/* 102 */     this.h = new Table();
/*     */     
/*     */     ScrollPane scrollPane;
/* 105 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.h, Game.i.assetManager.getScrollPaneStyle(0.0F)));
/* 106 */     scrollPane.setOverscroll(false, false);
/* 107 */     scrollPane.setSmoothScrolling(false);
/* 108 */     scrollPane.setFadeScrollBars(false);
/* 109 */     table3.add((Actor)scrollPane).expand().fill().top().left().padTop(40.0F).row();
/*     */     
/*     */     Group group2;
/*     */     
/* 113 */     (group2 = new Group()).setTransform(false);
/* 114 */     group2.setTouchable(Touchable.childrenOnly);
/* 115 */     table3.add((Actor)group2).size(1.0F, 256.0F).bottom().left().row();
/*     */ 
/*     */     
/* 118 */     this.d = new Group();
/* 119 */     this.d.setTransform(false);
/* 120 */     this.d.setPosition(100.0F, 173.0F);
/* 121 */     group2.addActor((Actor)this.d);
/*     */     
/*     */     Image image3;
/* 124 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-arrow-pointer-bottom-left"))).setSize(64.0F, 64.0F);
/* 125 */     this.d.addActor((Actor)image3);
/*     */     
/*     */     Label label2;
/* 128 */     (label2 = new Label(Game.i.localeManager.i18n.get("pause_menu_hint_hold_for_auto_wave"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(74.0F, 48.0F);
/* 129 */     this.d.addActor((Actor)label2);
/*     */ 
/*     */     
/* 132 */     this.e = new Group();
/* 133 */     this.e.setTransform(false);
/* 134 */     this.e.setPosition(268.0F, 136.0F);
/* 135 */     group2.addActor((Actor)this.e);
/*     */     
/*     */     Image image2;
/* 138 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-arrow-pointer-bottom-left"))).setSize(64.0F, 64.0F);
/* 139 */     this.e.addActor((Actor)image2);
/*     */     
/*     */     Label label1;
/* 142 */     (label1 = new Label(Game.i.localeManager.i18n.get("pause_menu_hint_hold_for_pause"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(74.0F, 48.0F);
/* 143 */     this.e.addActor((Actor)label1);
/*     */ 
/*     */     
/* 146 */     this.f = new Group();
/* 147 */     this.f.setTransform(false);
/* 148 */     this.f.setPosition(290.0F, 380.0F);
/* 149 */     group2.addActor((Actor)this.f);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ComplexButton complexButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("mainMenu_musicPlayerButton"), Game.i.assetManager.getLabelStyle(24), () -> { MusicListOverlay.i().show(); paramGameSystemProvider._sound.updateMusicPlayback(); })).setSize(300.0F, 96.0F);
/* 165 */     complexButton.setPosition(460.0F, 16.0F);
/*     */     
/* 167 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-music-player"), 16.0F, 16.0F, 64.0F, 64.0F);
/* 168 */     complexButton.setLabel(96.0F, 0.0F, 236.0F, 96.0F, 8);
/* 169 */     complexButton.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700, Color.GRAY);
/* 170 */     group2.addActor((Actor)complexButton);
/*     */ 
/*     */     
/* 173 */     Table table2 = new Table();
/* 174 */     table1.add((Actor)table2).right().expandY().fillY().padBottom(40.0F);
/*     */     
/* 176 */     table1 = new Table();
/* 177 */     table2.add((Actor)table1).top().right().row();
/*     */     
/* 179 */     this.j = new Label("", Game.i.assetManager.getLabelStyle(36));
/* 180 */     table1.add((Actor)this.j).padRight(40.0F).padTop(40.0F).top().right().row();
/*     */     
/* 182 */     this.k = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 183 */     table1.add((Actor)this.k).padRight(40.0F).padTop(8.0F).top().right().row();
/*     */     
/* 185 */     this.l = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 186 */     table1.add((Actor)this.l).padRight(40.0F).padTop(8.0F).top().right().row();
/*     */     
/* 188 */     table1.add().width(1.0F).height(32.0F).row();
/*     */ 
/*     */     
/* 191 */     if (paramGameSystemProvider.gameState.rarityBoostEnabled) {
/* 192 */       Table table = new Table();
/* 193 */       table1.add((Actor)table).padTop(8.0F).padRight(40.0F).expandX().fillX().row();
/* 194 */       table.add().height(1.0F).expandX().fillX();
/*     */       
/*     */       Label label;
/* 197 */       (label = new Label(Item.D.RARITY_BOOST.getTitle(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 198 */       table.add((Actor)label);
/*     */       
/* 200 */       Actor actor = Item.D.RARITY_BOOST.generateIcon(32.0F, false);
/* 201 */       table.add(actor).size(32.0F).padLeft(12.0F);
/*     */     } 
/* 203 */     if (paramGameSystemProvider.gameState.lootBoostEnabled) {
/* 204 */       Table table = new Table();
/* 205 */       table1.add((Actor)table).padTop(8.0F).padRight(40.0F).expandX().fillX().row();
/* 206 */       table.add().height(1.0F).expandX().fillX();
/*     */       
/*     */       Label label;
/* 209 */       (label = new Label(Item.D.LOOT_BOOST.getTitle(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 210 */       table.add((Actor)label);
/*     */       
/* 212 */       Actor actor = Item.D.LOOT_BOOST.generateIcon(32.0F, false);
/* 213 */       table.add(actor).size(32.0F).padLeft(12.0F);
/*     */     }  PP_BasicLevel.LevelLootBonus levelLootBonus;
/* 215 */     if (paramGameSystemProvider.gameState.basicLevelName != null && (
/*     */       
/* 217 */       levelLootBonus = (ProgressPrefs.i()).basicLevel.getLevelLootBonus(paramGameSystemProvider.gameState.basicLevelName)) != null) {
/* 218 */       Table table = new Table();
/* 219 */       table1.add((Actor)table).padTop(8.0F).padRight(40.0F).expandX().fillX().row();
/* 220 */       table.add().height(1.0F).expandX().fillX();
/*     */       
/* 222 */       Image image = new Image(levelLootBonus.getIconDrawable());
/* 223 */       table.add((Actor)image).size(32.0F).padRight(12.0F);
/*     */       
/*     */       Label label;
/* 226 */       (label = new Label("x" + StringFormatter.compactNumberWithPrecisionTrimZeros(levelLootBonus.multiplier, 1, true), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 227 */       table.add((Actor)label);
/*     */     } 
/*     */ 
/*     */     
/* 231 */     table2.add().expandY().fillY().width(100.0F).minHeight(30.0F).row();
/*     */ 
/*     */     
/* 234 */     this.i = new Table();
/* 235 */     table2.add((Actor)this.i).padRight(40.0F).right().row();
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/* 240 */     if ((str = Game.i.localeManager.i18n.get("settings_instant_auto_wave_calls")).length() > 24) {
/* 241 */       str = str.substring(0, 22) + "...";
/*     */     }
/*     */     
/* 244 */     table2.add((Actor)new LabelToggleButton(str, Game.i.settingsManager.isInstantAutoWaveCallEnabled(), 24, 32.0F, paramBoolean -> {
/*     */             Game.i.settingsManager.setInstantAutoWaveCallEnabled(paramBoolean.booleanValue());
/*     */             paramGameSystemProvider.wave.instantWaveCallsEnabled = paramBoolean.booleanValue();
/* 247 */           })).height(56.0F).width(348.0F).padRight(40.0F).right().row();
/*     */ 
/*     */     
/* 250 */     table2.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_particles"), Game.i.settingsManager.isParticlesDrawing(), 24, 32.0F, paramBoolean -> Game.i.settingsManager.setParticlesDrawing(paramBoolean.booleanValue()))).height(56.0F).width(348.0F).padRight(40.0F).right().row();
/*     */     
/*     */     Group group3;
/*     */     
/* 254 */     (group3 = new Group()).setTransform(false);
/*     */     
/*     */     Label label3;
/* 257 */     (label3 = new Label(Game.i.localeManager.i18n.get("settings_sound"), Game.i.assetManager.getLabelStyle(24))).setSize(1.0F, 56.0F);
/* 258 */     group3.addActor((Actor)label3);
/*     */     
/*     */     HorizontalSlider horizontalSlider1;
/* 261 */     (horizontalSlider1 = new HorizontalSlider(200.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SOUND_VOLUME), 0.0D, 1.0D, paramDouble -> Game.i.settingsManager.setSoundVoulme(paramDouble.doubleValue()))).setNotifyOnDrag(true);
/* 262 */     horizontalSlider1.setPosition(148.0F, (56.0F - horizontalSlider1.getHeight()) * 0.5F);
/* 263 */     group3.addActor((Actor)horizontalSlider1);
/* 264 */     table2.add((Actor)group3).height(56.0F).width(348.0F).padRight(40.0F).right().row();
/*     */     
/*     */     Group group1;
/*     */     
/* 268 */     (group1 = new Group()).setTransform(false);
/*     */ 
/*     */     
/* 271 */     (label3 = new Label(Game.i.localeManager.i18n.get("settings_music"), Game.i.assetManager.getLabelStyle(24))).setSize(1.0F, 56.0F);
/* 272 */     group1.addActor((Actor)label3);
/*     */ 
/*     */ 
/*     */     
/*     */     HorizontalSlider horizontalSlider2;
/*     */ 
/*     */     
/* 279 */     (horizontalSlider2 = new HorizontalSlider(200.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME), 0.0D, 1.0D, paramDouble -> { if (paramGameSystemProvider._sound == null) return;  Game.i.settingsManager.setMusicVolume(paramDouble.doubleValue()); paramGameSystemProvider._sound.updateMusicPlayback(); })).setNotifyOnDrag(true);
/* 280 */     horizontalSlider2.setPosition(148.0F, (56.0F - horizontalSlider1.getHeight()) * 0.5F);
/* 281 */     group1.addActor((Actor)horizontalSlider2);
/* 282 */     table2.add((Actor)group1).height(56.0F).width(348.0F).padRight(40.0F).right().row();
/*     */     
/* 284 */     table2.add().height(16.0F).row();
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
/*     */     RightSideMenuButton rightSideMenuButton;
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
/* 307 */     (rightSideMenuButton = new RightSideMenuButton(Game.i.localeManager.i18n.get("continue"), "icon-triangle-right", () -> { if (paramGameSystemProvider.gameState != null) paramGameSystemProvider.gameState.resumeGame();  })).setColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P700, MaterialColor.GREEN.P900, Color.WHITE);
/* 308 */     table2.add((Actor)rightSideMenuButton).row();
/*     */     
/* 310 */     rightSideMenuButton = new RightSideMenuButton(Game.i.localeManager.i18n.get("restart"), "icon-restart", () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("restart_confirm"), ()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     table2.add((Actor)rightSideMenuButton).row();
/*     */     
/* 321 */     table2.add((Actor)new RightSideMenuButton(Game.i.localeManager.i18n.get("end_game_button_text"), "icon-times", () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("end_game_button_confirm"), ())))
/*     */ 
/*     */ 
/*     */       
/* 325 */       .row();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     (rightSideMenuButton = new RightSideMenuButton(Game.i.localeManager.i18n.get("main_menu"), "icon-house", () -> { if (!paramGameSystemProvider.gameValue.getBooleanValue(GameValueType.GAME_SAVES)) { Dialog.i().showConfirm(Game.i.localeManager.i18n.get("game_cant_be_continued_confirm"), ()); return; }  Game.i.screenManager.goToMainMenu(); })).setName("pause_menu_main_menu_button");
/* 335 */     table2.add((Actor)rightSideMenuButton);
/*     */     
/* 337 */     this.a.getTable().setVisible(false);
/* 338 */     this.b.getTable().setVisible(false);
/* 339 */     this.c.getTable().setVisible(false);
/*     */     
/* 341 */     paramGameSystemProvider.events.getListeners(RewardingAdRegistered.class).add(paramRewardingAdRegistered -> { if (!paramGameSystemProvider.gameState.isFastForwarding() && this.b.getTable().isVisible())
/*     */             setVisible(true); 
/* 343 */         }).setDescription("PauseMenu - hides the menu on ad shown");
/* 344 */     paramGameSystemProvider.events.getListeners(GamePaused.class).add(paramGamePaused -> setVisible(true)).setDescription("PauseMenu - shows itself");
/* 345 */     paramGameSystemProvider.events.getListeners(GameResumed.class).add(paramGameResumed -> setVisible(false)).setDescription("PauseMenu - hides itself");
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 349 */     this.a.getTable().setVisible(paramBoolean);
/* 350 */     this.b.getTable().setVisible(paramBoolean);
/*     */     
/* 352 */     this.c.getTable().setVisible(false);
/*     */     
/* 354 */     if (!paramBoolean) {
/* 355 */       Game.i.uiManager.stage.setScrollFocus(null);
/*     */     }
/*     */     
/* 358 */     if (paramBoolean && !this.m.gameState.isGameOver()) {
/* 359 */       Game.i.preferencesManager.saveNowIfRequired();
/*     */ 
/*     */       
/* 362 */       if (Game.i.purchaseManager.rewardingAdsAvailable()) {
/* 363 */         this.c.getTable().setVisible(true);
/*     */         
/* 365 */         this.g.clear();
/*     */         
/* 367 */         QuadActor quadActor = new QuadActor(new Color(943208703), new float[] { 5.0F, 0.0F, 0.0F, 100.0F, 540.0F, 105.0F, 535.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 373 */         this.g.addActor((Actor)quadActor);
/*     */         
/*     */         Table table;
/* 376 */         (table = new Table()).setPosition(19.0F, 60.0F);
/* 377 */         table.setSize(300.0F, 24.0F);
/* 378 */         this.g.addActor((Actor)table);
/*     */         
/* 380 */         Label label = new Label(Game.i.localeManager.i18n.get("loot_bonus_menu_title"), Game.i.assetManager.getLabelStyle(21));
/* 381 */         table.add((Actor)label);
/*     */         
/* 383 */         Image image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"));
/* 384 */         table.add((Actor)image).padLeft(4.0F).size(24.0F);
/*     */         
/* 386 */         table.setTouchable(Touchable.enabled);
/* 387 */         table.addListener((EventListener)new ClickListener(this, image)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 390 */                 TooltipsOverlay.i().showText("_generic_", (Actor)this.a, Game.i.localeManager.i18n.get("pause_menu_ad_loot_bonus_info"), (PauseMenu.a(this.b)).mainUiLayer, (PauseMenu.a(this.b)).zIndex + 1, 2);
/*     */               }
/*     */             });
/*     */         
/* 394 */         table.add().height(1.0F).growX();
/*     */         
/* 396 */         int j = this.m.loot.getRewardingAdViews();
/* 397 */         for (byte b1 = 0; b1 < 5; b1++) {
/*     */           Label label1; Image image1;
/* 399 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(19.0F + b1 * 62.0F, 13.0F);
/* 400 */           image1.setSize(58.0F, 36.0F);
/* 401 */           this.g.addActor((Actor)image1);
/*     */ 
/*     */           
/* 404 */           if (b1 == 4) {
/* 405 */             label1 = new Label(LootSystem.REWARDING_AD_VIEW_BONUSES[b1] + "%", Game.i.assetManager.getLabelStyle(24));
/*     */           } else {
/* 407 */             label1 = new Label(LootSystem.REWARDING_AD_VIEW_BONUSES[b1] + "%", Game.i.assetManager.getLabelStyle(21));
/*     */           } 
/* 409 */           label1.setPosition(image1.getX(), image1.getY());
/* 410 */           label1.setAlignment(1);
/* 411 */           label1.setSize(58.0F, 36.0F);
/* 412 */           this.g.addActor((Actor)label1);
/*     */           
/* 414 */           if (j > b1) {
/* 415 */             label1.setColor(Color.WHITE);
/* 416 */             if (b1 == 4) {
/* 417 */               image1.setColor(MaterialColor.CYAN.P800);
/*     */             } else {
/* 419 */               image1.setColor(MaterialColor.GREEN.P800);
/*     */             } 
/*     */           } else {
/* 422 */             image1.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 423 */             if (b1 == 4) {
/* 424 */               label1.setColor(MaterialColor.CYAN.P700);
/*     */             } else {
/* 426 */               label1.setColor(MaterialColor.GREY.P700);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*     */         AttentionRaysUnderlay attentionRaysUnderlay;
/*     */         
/* 433 */         (attentionRaysUnderlay = new AttentionRaysUnderlay(192.0F, MaterialColor.LIGHT_BLUE.P300)).setPosition(340.0F, -44.0F);
/* 434 */         this.g.addActor((Actor)attentionRaysUnderlay);
/*     */         
/* 436 */         boolean bool = Game.i.progressManager.isPremiumStatusActive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         ComplexButton complexButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 448 */         (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("do_upgrade"), Game.i.assetManager.getLabelStyle(24), () -> { if (paramBoolean) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("auto_pause_menu_reward_ads")); return; }  Game.i.purchaseManager.showRewardingAd(PurchaseManager.RewardingAdsType.LOOT_MULTIPLIER, ()); })).setPosition(344.0F, 13.0F);
/* 449 */         complexButton.setSize(184.0F, 78.0F);
/* 450 */         complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 3.0F, 0.0F, 0.0F, 76.0F, 184.0F, 78.0F, 181.0F, 0.0F })), 0.0F, 0.0F, 184.0F, 78.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 456 */         complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable(bool ? "icon-crown" : "rewarding-ad"), 14.0F, 15.0F, 48.0F, 48.0F);
/* 457 */         complexButton.setLabel(73.0F, 15.0F, 100.0F, 48.0F, 8);
/* 458 */         this.g.addActor((Actor)complexButton);
/*     */         
/*     */         float f;
/* 461 */         if ((f = this.m.loot.getTimeToRewardingAds(true)) == -1.0F) {
/*     */           
/* 463 */           attentionRaysUnderlay.setVisible(false);
/* 464 */           complexButton.setText("MAX");
/*     */           
/* 466 */           if (!bool) {
/* 467 */             complexButton.setEnabled(false);
/*     */           }
/* 469 */         } else if (f == 0.0F) {
/*     */           
/* 471 */           attentionRaysUnderlay.setVisible(true);
/* 472 */           complexButton.setEnabled(true);
/*     */         }
/*     */         else {
/*     */           
/* 476 */           attentionRaysUnderlay.setVisible(false);
/*     */           
/* 478 */           complexButton.setText((CharSequence)StringFormatter.digestTime(MathUtils.ceil(f)));
/* 479 */           if (!bool) {
/* 480 */             complexButton.setEnabled(false);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 486 */       GameStateSystem gameStateSystem = this.m.gameState;
/*     */       
/* 488 */       this.l.setText(Game.i.progressManager.getDifficultyName(gameStateSystem.difficultyMode));
/* 489 */       this.l.setColor(Game.i.progressManager.getDifficultyModeColor(gameStateSystem.difficultyMode));
/*     */       
/* 491 */       if (gameStateSystem.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 492 */         if (gameStateSystem.dailyQuestLevel != null) {
/* 493 */           this.k.setText(Game.i.localeManager.i18n.get("daily_quest"));
/*     */         } else {
/* 495 */           this.k.setText(Game.i.localeManager.i18n.get("basic_level"));
/*     */         } 
/* 497 */         this.j.setText(gameStateSystem.basicLevelName);
/*     */       } else {
/* 499 */         this.k.setText(Game.i.localeManager.i18n.get("custom_map"));
/* 500 */         this.j.setText((Game.i.userMapManager.getUserMap(gameStateSystem.userMapId)).name);
/*     */       } 
/*     */ 
/*     */       
/* 504 */       this.d.setVisible(this.m._gameUi.mainUi.nextWaveButtonVisible());
/* 505 */       this.e.setVisible(this.m._gameUi.mainUi.gameSpeedButtonVisible());
/*     */       
/* 507 */       DelayedRemovalArray delayedRemovalArray = new DelayedRemovalArray();
/*     */       
/*     */       Array array1;
/*     */       
/* 511 */       for (Array.ArrayIterator<IssuedItems> arrayIterator = (array1 = new Array(gameStateSystem.getQuestsIssuedPrizes())).iterator(); arrayIterator.hasNext(); ) { IssuedItems issuedItems = arrayIterator.next();
/* 512 */         delayedRemovalArray.addAll(issuedItems.items); }
/*     */       
/* 514 */       delayedRemovalArray.addAll((gameStateSystem.getGameLootIssuedItems()).items);
/*     */       
/*     */       int i;
/*     */       
/* 518 */       if ((i = gameStateSystem.calculatePrizeGreenPapers()) > 0) {
/* 519 */         delayedRemovalArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*     */       }
/*     */       ResourceType[] arrayOfResourceType;
/*     */       byte b;
/* 523 */       for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/*     */ 
/*     */         
/*     */         int j;
/*     */         
/* 528 */         if ((j = gameStateSystem.getResources(resourceType)) != 0) {
/* 529 */           delayedRemovalArray.add(new ItemStack((Item)Item.D.F_RESOURCE.create(resourceType), j));
/*     */         }
/*     */         
/*     */         b++; }
/*     */       
/* 534 */       Array array2 = new Array(ItemStack.class);
/* 535 */       for (i = 0; i < delayedRemovalArray.size; i++) {
/* 536 */         ItemStack itemStack = (ItemStack)delayedRemovalArray.get(i);
/* 537 */         boolean bool = false;
/* 538 */         for (byte b1 = 0; b1 < array2.size; b1++) {
/* 539 */           ItemStack itemStack1 = ((ItemStack[])array2.items)[b1];
/* 540 */           if (itemStack.covered == itemStack1.covered && itemStack1.getItem().sameAs(itemStack.getItem())) {
/* 541 */             bool = true;
/* 542 */             itemStack1.setCount(PMath.addWithoutOverflow(itemStack1.getCount(), itemStack.getCount()));
/*     */             break;
/*     */           } 
/*     */         } 
/* 546 */         if (!bool) {
/* 547 */           array2.add(new ItemStack(itemStack));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 552 */       array2.sort(ProgressManager.ITEM_RARITY_COMPARATOR);
/* 553 */       this.h.clear();
/* 554 */       if (!gameStateSystem.isGameOver()) {
/* 555 */         i = 0;
/* 556 */         b = 0;
/* 557 */         byte b1 = (array2.size <= 25) ? 5 : 10;
/* 558 */         for (byte b2 = 0; b2 < array2.size; b2++) {
/* 559 */           ItemStack itemStack = ((ItemStack[])array2.items)[b2];
/*     */           ItemCell itemCell;
/* 561 */           (itemCell = new ItemCell()).setCompact();
/* 562 */           itemCell.setItemStack(itemStack);
/*     */           
/* 564 */           itemCell.setColRow(i, b);
/*     */ 
/*     */           
/* 567 */           if (itemStack.covered) {
/* 568 */             itemCell.setCovered(true);
/* 569 */             itemCell.shine(false, false);
/*     */           } else {
/* 571 */             itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */                 {
/*     */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 574 */                     ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/*     */                   }
/*     */                 });
/* 577 */             itemCell.shine(false, false);
/*     */           } 
/*     */           
/* 580 */           Cell cell = this.h.add((Actor)itemCell);
/* 581 */           i++;
/* 582 */           if (i == b1) {
/* 583 */             b++;
/* 584 */             i = 0;
/* 585 */             cell.row();
/*     */           } 
/*     */         } 
/*     */       } 
/* 589 */       a();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a() {
/* 594 */     this.i.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 599 */     String str1 = Game.i.localeManager.i18n.get("enabled");
/* 600 */     String str2 = Game.i.localeManager.i18n.get("disabled");
/*     */ 
/*     */ 
/*     */     
/* 604 */     PaddedImageButton paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-overload"), () -> { Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.MULTITHREADING, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) == 0.0D) ? 1.0D : 0.0D); a(); String str = Game.i.localeManager.i18n.get("settings_multithreaded_rendering"); if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) == 0.0D) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
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
/* 615 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) != 0.0D) {
/* 616 */       paddedImageButton.setColors(MaterialColor.AMBER.P800, MaterialColor.AMBER.P700, MaterialColor.AMBER.P900);
/*     */     } else {
/* 618 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 620 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 621 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 623 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-easel"), () -> { Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.POSTPROCESSING, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) == 0.0D) ? 1.0D : 0.0D); a(); String str = Game.i.localeManager.i18n.get("settings_postprocessing"); if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) == 0.0D) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
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
/* 634 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) != 0.0D) {
/* 635 */       paddedImageButton.setColors(MaterialColor.AMBER.P800, MaterialColor.AMBER.P700, MaterialColor.AMBER.P900);
/*     */     } else {
/* 637 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 639 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 640 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 642 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-explosion-range"), () -> { Game.i.settingsManager.setExplosionsDrawing(!Game.i.settingsManager.isExplosionsDrawing()); a(); String str = Game.i.localeManager.i18n.get("settings_draw_explosions"); if (Game.i.settingsManager.isExplosionsDrawing()) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 652 */     if (Game.i.settingsManager.isExplosionsDrawing()) {
/* 653 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 655 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 657 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 658 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 660 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-coins"), () -> { Game.i.settingsManager.setFlyingCoinsEnabled(!Game.i.settingsManager.isFlyingCoinsEnabled()); a(); String str = Game.i.localeManager.i18n.get("settings_flying_coins"); if (Game.i.settingsManager.isFlyingCoinsEnabled()) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
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
/* 671 */     if (Game.i.settingsManager.isFlyingCoinsEnabled()) {
/* 672 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 674 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 676 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 677 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 679 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-bullet"), () -> { Game.i.settingsManager.setProjectilesDrawing(!Game.i.settingsManager.isProjectilesDrawing()); a(); String str = Game.i.localeManager.i18n.get("settings_draw_projectiles"); if (Game.i.settingsManager.isProjectilesDrawing()) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 689 */     if (Game.i.settingsManager.isProjectilesDrawing()) {
/* 690 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 692 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 694 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 695 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 697 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-projectile-speed"), () -> { Game.i.settingsManager.setProjectileTrailsDrawing(!Game.i.settingsManager.isProjectileTrailsDrawing()); a(); String str = Game.i.localeManager.i18n.get("settings_draw_projectile_trails"); if (Game.i.settingsManager.isProjectileTrailsDrawing()) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 707 */     if (Game.i.settingsManager.isProjectileTrailsDrawing()) {
/* 708 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 710 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 712 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 713 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 715 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-dat-paper"), () -> { Game.i.settingsManager.setStainsEnabled(!Game.i.settingsManager.isStainsEnabled()); a(); String str = Game.i.localeManager.i18n.get("settings_stains"); if (Game.i.settingsManager.isStainsEnabled()) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 725 */     if (Game.i.settingsManager.isStainsEnabled()) {
/* 726 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 728 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 730 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 731 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 733 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-chest"), () -> { Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED) == 0.0D) ? 1.0D : 0.0D); a(); String str = Game.i.localeManager.i18n.get("settings_loot_icons"); if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED) != 0.0D) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 743 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED) != 0.0D) {
/* 744 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 746 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 748 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 749 */     this.i.add((Actor)paddedImageButton).size(52.0F);
/*     */     
/* 751 */     paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-crosshair"), () -> { Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET) == 0.0D) ? 1.0D : 0.0D); a(); String str = Game.i.localeManager.i18n.get("settings_draw_tower_target"); if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET) != 0.0D) { Notifications.i().add(str + " - " + paramString1, null, null, null); return; }  Notifications.i().add(str + " - " + paramString2, null, null, null); }Color.WHITE, Color.WHITE, Color.WHITE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 761 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET) != 0.0D) {
/* 762 */       paddedImageButton.setColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900);
/*     */     } else {
/* 764 */       paddedImageButton.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P700, MaterialColor.GREY.P900);
/*     */     } 
/* 766 */     paddedImageButton.setIconPosition(6.0F, 6.0F).setIconSize(40.0F, 40.0F);
/* 767 */     this.i.add((Actor)paddedImageButton).size(52.0F).padRight(-6.0F);
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
/*     */   public void dispose() {
/* 784 */     Game.i.uiManager.removeLayer(this.a);
/* 785 */     Game.i.uiManager.removeLayer(this.b);
/* 786 */     Game.i.uiManager.removeLayer(this.c);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\PauseMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */