/*     */ package com.prineside.tdi2.screens;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class AboutScreen extends Screen {
/*  25 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "AboutScreen main");
/*     */ 
/*     */ 
/*     */   
/*     */   public AboutScreen() {
/*  30 */     long l = Game.getRealTickCount();
/*     */ 
/*     */     
/*  33 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */     
/*  35 */     Game.i.uiManager.hideAllComponents();
/*  36 */     Game.i.uiManager.setAsInputHandler();
/*     */ 
/*     */     
/*  39 */     BackButton.i()
/*  40 */       .setVisible(true)
/*  41 */       .setText(null)
/*  42 */       .setClickHandler(() -> Game.i.screenManager.goToMainMenu());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     Table table1 = this.a.getTable();
/*     */     
/*  50 */     Label.LabelStyle labelStyle1 = Game.i.assetManager.getLabelStyle(30);
/*     */     Label.LabelStyle labelStyle2;
/*  52 */     (labelStyle2 = new Label.LabelStyle(Game.i.assetManager.getLabelStyle(24))).fontColor = MaterialColor.AMBER.P500;
/*     */     
/*  54 */     table1.add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("infinitode-2-logo"))).size(128.0F).padBottom(20.0F);
/*  55 */     table1.row();
/*     */     
/*  57 */     String str = Game.i.localeManager.i18n.get("game_name");
/*  58 */     table1.add((Actor)new Label(str, labelStyle1));
/*  59 */     table1.row();
/*     */ 
/*     */     
/*  62 */     table1.add((Actor)new Label(Game.i.localeManager.i18n.get("about_version"), labelStyle2)).height(40.0F).padTop(16.0F);
/*  63 */     table1.row();
/*     */     
/*  65 */     table1.add((Actor)new Label("R.1.9.1 (build 207)", labelStyle1)).height(40.0F);
/*  66 */     table1.row();
/*     */ 
/*     */     
/*  69 */     Table table3 = new Table();
/*     */ 
/*     */     
/*  72 */     FancyButton fancyButton = (new FancyButton("regularButton.a", () -> Game.i.actionResolver.openSupportPage())).withLabel(30, Game.i.localeManager.i18n.get("get_support"));
/*  73 */     table3.add((Actor)fancyButton).size(320.0F, 64.0F);
/*     */ 
/*     */     
/*  76 */     fancyButton = (new FancyButton("regularButton.b", () -> Gdx.net.openURI("https://tracker.prineside.com/set_project.php?project_id=1"))).withLabel(30, Game.i.localeManager.i18n.get("report_bug"));
/*  77 */     table3.add((Actor)fancyButton).size(320.0F, 64.0F).padLeft(16.0F);
/*     */ 
/*     */     
/*  80 */     fancyButton = (new FancyButton("regularButton.a", () -> Gdx.net.openURI("https://tracker.prineside.com/set_project.php?project_id=2"))).withLabel(30, Game.i.localeManager.i18n.get("i_have_idea"));
/*  81 */     table3.add((Actor)fancyButton).size(320.0F, 64.0F).padLeft(16.0F);
/*     */     
/*  83 */     table1.add((Actor)table3).padTop(16.0F).row();
/*     */     
/*  85 */     table3 = new Table();
/*  86 */     table1.add((Actor)table3).padTop(16.0F).row();
/*     */ 
/*     */     
/*  89 */     Table table4 = new Table();
/*  90 */     table3.add((Actor)table4).width(500.0F);
/*     */     
/*  92 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("about_developer"), labelStyle2)).height(40.0F).padTop(16.0F);
/*  93 */     table4.row();
/*     */     
/*  95 */     table4.add((Actor)new Label("Vadym Sakhno (therainycat)", labelStyle1)).height(40.0F);
/*  96 */     table4.row();
/*     */     
/*     */     Label label2;
/*  99 */     (label2 = new Label("web.prineside@gmail.com", Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 100 */     label2.setTouchable(Touchable.enabled);
/* 101 */     label2.addListener((EventListener)new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 103 */             Gdx.app.getClipboard().setContents("web.prineside@gmail.com");
/* 104 */             Notifications.i().add(Game.i.localeManager.i18n.get("copied_to_clipboard"), (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, StaticSoundType.NOTIFICATION);
/*     */           }
/*     */         });
/* 107 */     table4.add((Actor)label2).height(40.0F);
/*     */ 
/*     */     
/* 110 */     table4 = new Table();
/* 111 */     table3.add((Actor)table4).width(500.0F).row();
/*     */     
/* 113 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("about_3d_artist"), labelStyle2)).height(40.0F).padTop(16.0F);
/* 114 */     table4.row();
/*     */     
/* 116 */     table4.add((Actor)new Label("Ihor Pronoza (SlyCheD)", labelStyle1)).height(40.0F);
/* 117 */     table4.row();
/*     */ 
/*     */     
/* 120 */     (label2 = new Label("ihor.pronoza@gmail.com", Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 121 */     label2.setTouchable(Touchable.enabled);
/* 122 */     label2.addListener((EventListener)new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 124 */             Gdx.app.getClipboard().setContents("ihor.pronoza@gmail.com");
/* 125 */             Notifications.i().add(Game.i.localeManager.i18n.get("copied_to_clipboard"), (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, StaticSoundType.NOTIFICATION);
/*     */           }
/*     */         });
/* 128 */     table4.add((Actor)label2).height(40.0F);
/*     */ 
/*     */     
/* 131 */     table4 = new Table();
/* 132 */     table3.add((Actor)table4).colspan(2).row();
/*     */     
/* 134 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("about_community_manager"), labelStyle2)).height(40.0F).padTop(16.0F);
/* 135 */     table4.row();
/*     */     
/* 137 */     table4.add((Actor)new Label("Alexander Susla (MarshallUA)", labelStyle1)).height(40.0F);
/* 138 */     table4.row();
/*     */     
/* 140 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("about_special_thanks"), labelStyle2)).height(40.0F).padTop(16.0F);
/* 141 */     table4.row();
/*     */     
/* 143 */     table4.add((Actor)new Label("Steven McManus (Zeraco)", labelStyle1)).height(40.0F);
/* 144 */     table4.row();
/*     */     
/*     */     Label label1;
/* 147 */     (label1 = new Label("infinitode.prineside.com", Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 148 */     label1.setTouchable(Touchable.enabled);
/* 149 */     label1.addListener((EventListener)new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 151 */             Gdx.net.openURI("https://infinitode.prineside.com");
/*     */           }
/*     */         });
/* 154 */     table1.add((Actor)label1).height(40.0F).padTop(16.0F);
/* 155 */     table1.row();
/*     */     
/*     */     LabelButton labelButton;
/* 158 */     (labelButton = new LabelButton(Game.i.localeManager.i18n.get("privacy_policy"), Game.i.assetManager.getLabelStyle(30), () -> Gdx.net.openURI(Config.PRIVACY_POLICY_URL))).setAlignment(1);
/* 159 */     table1.add((Actor)labelButton).padTop(12.0F).padBottom(8.0F).row();
/*     */ 
/*     */     
/* 162 */     (labelButton = new LabelButton(Game.i.localeManager.i18n.get("terms_and_conditions"), Game.i.assetManager.getLabelStyle(30), () -> Gdx.net.openURI(Config.TERMS_AND_CONDITIONS_URL))).setAlignment(1);
/* 163 */     table1.add((Actor)labelButton).padTop(8.0F).padBottom(12.0F).row();
/*     */     
/* 165 */     Table table2 = new Table();
/* 166 */     table1.add((Actor)table2).padTop(15.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Image image;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-colored-reddit"))).setTouchable(Touchable.enabled);
/* 179 */     image.addListener((EventListener)new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 181 */             Gdx.net.openURI("https://www.reddit.com/r/infinitode/");
/*     */           }
/*     */         });
/* 184 */     table2.add((Actor)image).size(64.0F).padRight(32.0F);
/*     */ 
/*     */     
/* 187 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-colored-discord"))).setTouchable(Touchable.enabled);
/* 188 */     image.addListener((EventListener)new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 190 */             Gdx.net.openURI("https://discord.gg/4kZ2TJ4");
/*     */           }
/*     */         });
/* 193 */     table2.add((Actor)image).size(64.0F);
/*     */     
/* 195 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("ConstructScreen-" + getClass().getSimpleName(), Game.getRealTickCount() - l);
/*     */   
/*     */   }
/*     */   
/*     */   public void show() {
/* 200 */     this.a.getTable().setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 205 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 210 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 211 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 212 */     Gdx.gl.glClear(16640);
/*     */     
/* 214 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*     */       
/* 216 */       Game.i.screenManager.goToMainMenu();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 223 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\AboutScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */