/*     */ package com.prineside.tdi2.screens;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.UserMap;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public class CustomMapSelectScreen
/*     */   extends Screen {
/*  37 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "CustomMapSelectScreen main");
/*     */ 
/*     */   
/*     */   private Table b;
/*     */ 
/*     */   
/*     */   public CustomMapSelectScreen() {
/*  44 */     Game.i.uiManager.hideAllComponents();
/*  45 */     Game.i.uiManager.setAsInputHandler();
/*     */ 
/*     */     
/*  48 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */ 
/*     */     
/*  51 */     ScreenTitle.i()
/*  52 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-edit"))
/*  53 */       .setText(Game.i.localeManager.i18n.get("map_editor_map_select_title"))
/*  54 */       .setVisible(true);
/*     */     
/*  56 */     BackButton.i()
/*  57 */       .setVisible(true)
/*  58 */       .setText(null)
/*  59 */       .setClickHandler(() -> {
/*     */           if (AbilitySelectionOverlay.i().isVisible()) {
/*     */             AbilitySelectionOverlay.i().hide();
/*     */             
/*     */             return;
/*     */           } 
/*     */           Game.i.screenManager.goToMainMenu();
/*     */         });
/*  67 */     Table table1 = this.a.getTable();
/*     */ 
/*     */     
/*  70 */     Table table2 = new Table();
/*     */     ScrollPane scrollPane;
/*  72 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table2));
/*     */     
/*  74 */     table1.add((Actor)scrollPane).padRight(40.0F).fill().expand();
/*     */     
/*  76 */     table2.add().top().left().height(160.0F).fillX().expandX().row();
/*  77 */     this.b = new Table();
/*  78 */     table2.add((Actor)this.b).expandX().fillX().padBottom(160.0F).row();
/*  79 */     table2.add().fill().expand();
/*     */ 
/*     */     
/*  82 */     boolean bool = false;
/*  83 */     Array array = Game.i.userMapManager.getUserMaps();
/*  84 */     for (byte b = 0; b < array.size; b++) {
/*     */       UserMap userMap;
/*  86 */       if ((userMap = ((UserMap[])array.items)[b]).removeUnexistentTilesFromMap()) {
/*  87 */         bool = true;
/*     */       }
/*     */     } 
/*  90 */     if (bool) {
/*  91 */       ProgressPrefs.i().requireSave();
/*     */     }
/*     */     
/*  94 */     a();
/*     */ 
/*     */     
/*  97 */     Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/* 102 */     Game.i.uiManager.setAsInputHandler();
/*     */   }
/*     */   
/*     */   private void a() {
/* 106 */     this.b.clear();
/*     */     
/* 108 */     Table table = new Table();
/* 109 */     this.b.add((Actor)table).width(800.0F).padRight(40.0F).expandY().fillY();
/*     */     
/* 111 */     Array array = Game.i.userMapManager.getUserMaps();
/* 112 */     for (byte b = 0; b < array.size; b++) {
/* 113 */       UserMap userMap = (UserMap)array.get(b);
/*     */       
/*     */       Group group;
/* 116 */       (group = new Group()).setTransform(false);
/* 117 */       table.add((Actor)group).size(800.0F, 250.0F).padBottom(4.0F).row();
/*     */       
/*     */       Image image;
/* 120 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(800.0F, 250.0F);
/* 121 */       image.setColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 122 */       group.addActor((Actor)image);
/*     */       
/* 124 */       userMap.map.regeneratePreview();
/*     */ 
/*     */       
/* 127 */       (image = new Image(userMap.map.getPreview().getTextureRegion())).setSize(310.0F, 230.0F);
/* 128 */       image.setPosition(10.0F, 10.0F);
/* 129 */       group.addActor((Actor)image);
/*     */       
/*     */       Label label;
/* 132 */       (label = new Label(userMap.name, Game.i.assetManager.getLabelStyle(30))).setPosition(340.0F, 192.0F);
/* 133 */       label.setSize(100.0F, 30.0F);
/* 134 */       group.addActor((Actor)label);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       PaddedImageButton paddedImageButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-edit"), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this, paramUserMap) { public void input(String param1String) { Threads.i().runOnMainThread(() -> { Game.i.userMapManager.rename(param1UserMap, param1String); CustomMapSelectScreen.a(this.b); }); } public void canceled() {} }"", paramUserMap.name, ""), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setIconSize(40.0F, 40.0F);
/* 149 */       paddedImageButton.setIconPosition(12.0F, 12.0F);
/* 150 */       paddedImageButton.setPosition(712.0F, 176.0F);
/* 151 */       group.addActor((Actor)paddedImageButton);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ComplexButton complexButton2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       (complexButton2 = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> { Runnable runnable = (); if (GameStateSystem.savedGameExists()) { Dialog.i().showConfirm(Game.i.localeManager.i18n.get("saved_game_will_be_lost_confirm"), ()); return; }  runnable.run(); })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 64.0F, 104.0F, 64.0F, 96.0F, 0.0F })), 0.0F, 0.0F, 104.0F, 64.0F);
/* 172 */       complexButton2.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/* 173 */       complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 22.0F, 8.0F, 48.0F, 48.0F);
/* 174 */       complexButton2.setPosition(338.0F, 18.0F);
/* 175 */       group.addActor((Actor)complexButton2);
/*     */ 
/*     */       
/* 178 */       (complexButton2 = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> Game.i.screenManager.goToMapEditorScreenUserMap(paramUserMap))).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 8.0F, 64.0F, 170.0F, 64.0F, 162.0F, 0.0F })), 0.0F, 0.0F, 170.0F, 64.0F);
/* 179 */       complexButton2.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, Color.GRAY);
/* 180 */       complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-edit"), 61.0F, 8.0F, 48.0F, 48.0F);
/* 181 */       complexButton2.setPosition(442.0F, 18.0F);
/* 182 */       group.addActor((Actor)complexButton2);
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
/*     */       ComplexButton complexButton1;
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
/* 222 */       (complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> { try { paramUserMap.map.validate(); Runnable runnable; (runnable = (())).run(); return; } catch (com.prineside.tdi2.Map.InvalidMapException invalidMapException) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("map_cant_be_played") + ": " + invalidMapException.getFixHintMessage()); return; }  })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 8.0F, 64.0F, 170.0F, 64.0F, 170.0F, 0.0F })), 0.0F, 0.0F, 170.0F, 64.0F);
/* 223 */       complexButton1.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.GRAY);
/* 224 */       complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), 65.0F, 8.0F, 48.0F, 48.0F);
/* 225 */       complexButton1.setPosition(612.0F, 18.0F);
/* 226 */       group.addActor((Actor)complexButton1);
/*     */     } 
/*     */ 
/*     */     
/* 230 */     if (array.size < 8) {
/*     */       Group group;
/* 232 */       (group = new Group()).setTransform(false);
/* 233 */       table.add((Actor)group).size(800.0F, 100.0F).padBottom(4.0F).row();
/*     */       
/*     */       Image image;
/* 236 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(800.0F, 100.0F);
/* 237 */       image.setColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 238 */       group.addActor((Actor)image);
/*     */       
/*     */       Label label;
/* 241 */       (label = new Label(Game.i.localeManager.i18n.get("new_map") + ":", Game.i.assetManager.getLabelStyle(24))).setSize(222.0F, 64.0F);
/* 242 */       label.setPosition(18.0F, 18.0F);
/* 243 */       label.setAlignment(16);
/* 244 */       group.addActor((Actor)label);
/*     */       
/*     */       TextFieldXPlatform textFieldXPlatform;
/* 247 */       (textFieldXPlatform = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(24))).setSize(306.0F, 64.0F);
/* 248 */       textFieldXPlatform.setPosition(258.0F, 18.0F);
/* 249 */       group.addActor((Actor)textFieldXPlatform);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       FancyButton fancyButton;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 259 */       (fancyButton = (new FancyButton("regularButton.b", () -> { if (paramTextFieldXPlatform.getText().length() == 0) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("enter_map_name")); return; }  Game.i.userMapManager.addUserMap(paramTextFieldXPlatform.getText()); a(); })).withLabel(30, Game.i.localeManager.i18n.get("create"))).setSize(200.0F, 64.0F);
/* 260 */       fancyButton.setPosition(582.0F, 18.0F);
/* 261 */       group.addActor((Actor)fancyButton);
/*     */     } 
/*     */     
/* 264 */     table.add().expand().fill();
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 268 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 269 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 270 */     Gdx.gl.glClear(16640);
/*     */     
/* 272 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*     */       
/* 274 */       Game.i.screenManager.goToMainMenu();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 281 */     super.dispose();
/*     */     
/* 283 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\CustomMapSelectScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */