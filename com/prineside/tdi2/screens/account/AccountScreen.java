/*     */ package com.prineside.tdi2.screens.account;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.ui.shared.TextInputOverlay;
/*     */ import com.prineside.tdi2.ui.shared.WebBrowser;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AccountScreen extends GenericAccountScreen {
/*  51 */   private static final TLog a = TLog.forClass(AccountScreen.class);
/*     */   
/*  53 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "AccountScreen status");
/*  54 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "AccountScreen preferencesRestoreOverlay");
/*  55 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 103, "AccountScreen backupRestoreOverlay");
/*     */   
/*     */   private final Table e;
/*     */   
/*     */   private final Label f;
/*     */   
/*     */   private final Image g;
/*     */   private final Label h;
/*     */   private final Label i;
/*     */   private final Label j;
/*     */   private Table k;
/*     */   private final LabelToggleButton l;
/*     */   private final Table m;
/*  68 */   private final Array<FancyButton> n = new Array();
/*     */   
/*  70 */   private final _AuthManagerListener o = new _AuthManagerListener((byte)0);
/*     */   
/*     */   public static RectButton createGoogleSignInButton(Runnable paramRunnable1, Runnable paramRunnable2, boolean paramBoolean) {
/*  73 */     Preconditions.checkNotNull(paramRunnable1, "disableButtonsRunnable can not be null");
/*  74 */     Preconditions.checkNotNull(paramRunnable2, "enableButtonsRunnable can not be null");
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
/*     */     RectButton rectButton;
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
/* 112 */     (rectButton = new RectButton("Sign " + (paramBoolean ? "up" : "in") + " with Google", new Label.LabelStyle(Game.i.defaultSmallFuturaFont, Color.WHITE), () -> { paramRunnable1.run(); Game.i.actionResolver.requestGoogleAuth(()); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("google-g-icon"), 16.0F, 8.0F, 48.0F, 48.0F);
/* 113 */     rectButton.setBackgroundColors(Color.WHITE, MaterialColor.GREY.P100, Color.WHITE, Color.WHITE);
/* 114 */     rectButton.setIconColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/* 115 */     rectButton.setLabelColors(new Color(1886417151), new Color(1886417151), new Color(1886417151), Color.BLACK);
/* 116 */     rectButton.setLabel(72.0F, 0.0F, 240.0F, 64.0F, 1);
/* 117 */     rectButton.setSize(320.0F, 64.0F);
/*     */     
/* 119 */     return rectButton;
/*     */   }
/*     */   
/*     */   public static RectButton createSteamSignInButton(Runnable paramRunnable1, Runnable paramRunnable2, boolean paramBoolean) {
/* 123 */     Preconditions.checkNotNull(paramRunnable1, "disableButtonsRunnable can not be null");
/* 124 */     Preconditions.checkNotNull(paramRunnable2, "enableButtonsRunnable can not be null");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RectButton rectButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     (rectButton = new RectButton("Sign " + (paramBoolean ? "up" : "in") + " with Steam", new Label.LabelStyle(Game.i.defaultSmallFuturaFont, Color.WHITE), () -> { paramRunnable1.run(); Game.i.authManager.signInWithSteam(()); })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("steam-icon"), 16.0F, 8.0F, 48.0F, 48.0F);
/* 145 */     rectButton.setBackgroundColors(Color.WHITE, MaterialColor.GREY.P100, Color.WHITE, Color.WHITE);
/* 146 */     rectButton.setIconColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/* 147 */     rectButton.setLabelColors(new Color(1886417151), new Color(1886417151), new Color(1886417151), Color.BLACK);
/* 148 */     rectButton.setLabel(72.0F, 0.0F, 240.0F, 64.0F, 1);
/* 149 */     rectButton.setSize(320.0F, 64.0F);
/*     */     
/* 151 */     return rectButton;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void goToScreen() {
/* 156 */     if (Game.i.authManager.isSignedIn()) {
/* 157 */       Game.i.screenManager.setScreen(new AccountScreen()); return;
/*     */     } 
/* 159 */     Game.i.screenManager.setScreen(new AccountSignInScreen());
/*     */   }
/*     */ 
/*     */   
/*     */   public AccountScreen() {
/* 164 */     super(null, () -> Game.i.screenManager.goToMainMenu());
/*     */ 
/*     */ 
/*     */     
/* 168 */     Game.i.authManager.addListener(this.o);
/*     */     
/* 170 */     this.c.getTable().setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.78F)));
/* 171 */     this.c.getTable().setTouchable(Touchable.enabled);
/* 172 */     this.c.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {}
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 179 */     this.c.getTable().setVisible(false);
/*     */     
/* 181 */     this.d.getTable().setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.78F)));
/* 182 */     this.d.getTable().setTouchable(Touchable.enabled);
/* 183 */     this.d.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {}
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.d.getTable().setVisible(false);
/*     */ 
/*     */     
/* 193 */     Table table1 = new Table();
/* 194 */     this.uiLayer.getTable().add((Actor)table1).row();
/*     */ 
/*     */     
/* 197 */     Table table2 = new Table();
/* 198 */     table1.add((Actor)table2).width(600.0F);
/*     */     
/* 200 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 201 */     this.f.setColor(MaterialColor.GREEN.P500);
/* 202 */     table2.add((Actor)this.f).row();
/*     */     
/* 204 */     Table table4 = new Table();
/* 205 */     table2.add((Actor)table4).padTop(20.0F).row();
/*     */     
/*     */     Group group;
/* 208 */     (group = new Group()).setTransform(false);
/* 209 */     group.setTouchable(Touchable.enabled);
/* 210 */     group.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 213 */             Gdx.net.openURI(Config.SITE_URL + "/?m=edit_profile&ts=" + Game.i.authManager.getSessionId());
/*     */           }
/*     */         });
/* 216 */     table4.add((Actor)group).size(64.0F, 64.0F);
/*     */     
/* 218 */     this.g = new Image();
/* 219 */     this.g.setSize(64.0F, 64.0F);
/* 220 */     this.g.setColor(0.56F, 0.56F, 0.56F, 1.0F);
/* 221 */     group.addActor((Actor)this.g);
/*     */     
/*     */     Image image2;
/* 224 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-edit"))).setSize(28.0F, 28.0F);
/* 225 */     image2.setPosition(2.0F, 2.0F);
/* 226 */     group.addActor((Actor)image2);
/*     */     
/* 228 */     Table table5 = new Table();
/* 229 */     table4.add((Actor)table5).padLeft(16.0F);
/*     */     
/* 231 */     this.h = new Label("", Game.i.assetManager.getLabelStyle(36));
/* 232 */     table5.add((Actor)this.h);
/*     */     
/*     */     Image image1;
/* 235 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-edit"))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 236 */     image1.setTouchable(Touchable.enabled);
/* 237 */     image1.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 240 */             Game.i.uiManager.getTextInput(new Input.TextInputListener(this)
/*     */                 {
/*     */                   public void input(String param2String) {
/* 243 */                     Threads.i().runOnMainThread(() -> {
/*     */                           Pattern pattern;
/*     */                           if (!(pattern = Pattern.compile("^[a-zA-Z0-9_]+$")).matcher(param2String).matches()) {
/*     */                             Dialog.i().showAlert(Game.i.localeManager.i18n.get("nickname_is_invalid"));
/*     */                             return;
/*     */                           } 
/*     */                           Game.i.authManager.requestNicknameChange(param2String, ());
/*     */                         });
/*     */                   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   public void canceled() {}
/* 258 */                 }Game.i.localeManager.i18n.get("nickname"), Game.i.authManager.getNickname(), "");
/*     */           }
/*     */         });
/* 261 */     table5.add((Actor)image1).size(32.0F).padLeft(16.0F);
/*     */     
/* 263 */     this.i = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 264 */     this.i.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 265 */     table2.add((Actor)this.i).padTop(6.0F).row();
/*     */     
/* 267 */     this.j = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 268 */     this.j.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 269 */     table2.add((Actor)this.j).padTop(6.0F).row();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 275 */     FancyButton fancyButton = (new FancyButton("regularButton.a", () -> { (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_PLAYER_PROFILE_URL + Game.i.authManager.getPlayerId(), null); WebBrowser.i().setVisible(true); })).withLabel(24, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-user> " + Game.i.localeManager.i18n.get("view_profile")));
/* 276 */     table2.add((Actor)fancyButton).size(296.0F, 56.0F).padTop(32.0F).row();
/*     */ 
/*     */ 
/*     */     
/* 280 */     fancyButton = (new FancyButton("regularButton.b", () -> Game.i.screenManager.goToAccountSettingsScreen())).withLabel(24, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-tools> " + Game.i.localeManager.i18n.get("settings")));
/* 281 */     table2.add((Actor)fancyButton).size(296.0F, 56.0F).padTop(16.0F).row();
/*     */ 
/*     */     
/* 284 */     if (Game.i.authManager.getInviteCode() != null) {
/*     */       Label label4;
/* 286 */       (label4 = new Label(Game.i.localeManager.i18n.get("invite_code"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 287 */       table2.add((Actor)label4).padTop(32.0F).row();
/*     */ 
/*     */       
/* 290 */       (label4 = new Label(Game.i.authManager.getInviteCode(), Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 291 */       table2.add((Actor)label4).row();
/*     */       
/* 293 */       label4.setTouchable(Touchable.enabled);
/* 294 */       label4.addListener((EventListener)new ClickListener(this)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 297 */               Gdx.app.getClipboard().setContents(Game.i.authManager.getInviteCode());
/* 298 */               Notifications.i().add(Game.i.localeManager.i18n.get("copied_to_clipboard"), null, null, null);
/*     */             }
/*     */           });
/*     */       
/*     */       Label label5;
/* 303 */       (label5 = new Label(Game.i.localeManager.i18n.get("invite_code_hint"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 304 */       label5.setWrap(true);
/* 305 */       label5.setAlignment(1);
/* 306 */       table2.add((Actor)label5).width(500.0F).row();
/*     */     } 
/*     */ 
/*     */     
/* 310 */     if (!Game.i.authManager.isPasswordSet()) {
/* 311 */       this.k = new Table();
/* 312 */       this.k.setTouchable(Touchable.enabled);
/* 313 */       this.k.addListener((EventListener)new ClickListener(this)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 316 */               Game.i.screenManager.setScreen(new AccountSetPasswordScreen());
/*     */             }
/*     */           });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 345 */       this.k.setBackground(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.PURPLE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F)));
/*     */       
/*     */       Label label;
/* 348 */       (label = new Label(Game.i.localeManager.i18n.get("account_password_not_set_hint"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 349 */       label.setAlignment(1);
/* 350 */       this.k.add((Actor)label).width(460.0F).padTop(16.0F).padBottom(16.0F);
/*     */       
/* 352 */       table2.add((Actor)this.k).width(500.0F).padBottom(24.0F).padTop(16.0F).row();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 357 */     (fancyButton = new FancyButton("regularButton.a", () -> Game.i.authManager.signOut())).withLabel(24, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-exit> " + Game.i.localeManager.i18n.get("sign_out")));
/* 358 */     table2.add((Actor)fancyButton).size(296.0F, 56.0F).padTop(32.0F).row();
/*     */ 
/*     */     
/* 361 */     Table table3 = new Table();
/* 362 */     table1.add((Actor)table3).width(800.0F);
/*     */     
/*     */     Label label3;
/* 365 */     (label3 = new Label(Game.i.localeManager.i18n.get("cloud_saves"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 366 */     table3.add((Actor)label3).padBottom(8.0F).row();
/*     */     
/* 368 */     this.m = new Table();
/* 369 */     this.m.setWidth(800.0F);
/*     */     ScrollPane scrollPane;
/* 371 */     (scrollPane = new ScrollPane((Actor)this.m, Game.i.assetManager.getScrollPaneStyle(0.0F))).setScrollingDisabled(true, false);
/* 372 */     scrollPane.setOverscroll(false, false);
/* 373 */     table3.add((Actor)scrollPane).width(800.0F).height(700.0F).row();
/*     */     
/*     */     Label label2;
/* 376 */     (label2 = new Label(Game.i.localeManager.i18n.get("auto_saves_hint"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 377 */     label2.setAlignment(1);
/* 378 */     table3.add((Actor)label2).width(500.0F).padTop(16.0F).row();
/*     */     
/* 380 */     this.l = new LabelToggleButton(Game.i.localeManager.i18n.get("auto_saves"), Game.i.authManager.isAutoSavesEnabled(), null);
/* 381 */     this.l.onToggle = (paramBoolean -> {
/*     */         if (paramBoolean.booleanValue()) {
/*     */           if (Game.i.authManager.getCloudSaveSlotId() == -1) {
/*     */             b();
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             Game.i.authManager.getCloudSavedGamesList(());
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           Game.i.authManager.setAutoSavesEnabled(true);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         Game.i.authManager.setAutoSavesEnabled(false);
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 417 */     table3.add((Actor)this.l).height(96.0F).row();
/*     */     
/* 419 */     if (Game.i.authManager.isSignedIn()) {
/*     */       LabelButton labelButton;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 542 */       (labelButton = new LabelButton(Game.i.localeManager.i18n.get("lost_progress?"), Game.i.assetManager.getLabelStyle(24), () -> { if (Game.i.progressManager.isDeveloperModeEnabled()) { Notifications.i().add("Could not load game while being in Developer mode, please reset your progress first", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL); return; }  try { Net.HttpRequest httpRequest; (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_BACKUPS_TO_RESTORE_PREFERENCES_URL); HashMap<Object, Object> hashMap; (hashMap = new HashMap<>()).put("sessionid", Game.i.authManager.getSessionId()); httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap)); this.d.getTable().clearChildren(); Image image; (image = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setOrigin(32.0F, 32.0F); image.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F))); this.d.getTable().add((Actor)image).size(64.0F, 64.0F); this.d.getTable().setVisible(true); Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this) { public void handleHttpResponse(Net.HttpResponse param1HttpResponse) { try { String str = param1HttpResponse.getResultAsString(); AccountScreen.a().i(str, new Object[0]); JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) { Threads.i().runOnMainThread(() -> { AccountScreen.b(this.a).getTable().clearChildren(); Label label; (label = new Label(Game.i.localeManager.i18n.get("select_date_to_restore_game_state"), Game.i.assetManager.getLabelStyle(24))).setWrap(true); label.setAlignment(1); AccountScreen.b(this.a).getTable().add((Actor)label).width(600.0F).padBottom(15.0F).row(); param1JsonValue = param1JsonValue.get("data"); boolean bool = false; JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.iterator(); while (jsonIterator.hasNext()) { JsonValue jsonValue; int i = (jsonValue = jsonIterator.next()).getInt("modified"); String str = jsonValue.getString("url"); Date date = new Date(i * 1000L); SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US); bool = true; LabelButton labelButton; (labelButton = new LabelButton(simpleDateFormat.format(date), Game.i.assetManager.getLabelStyle(30), ())).setAlignment(1); AccountScreen.b(this.a).getTable().add((Actor)labelButton).size(600.0F, 64.0F).row(); }  if (!bool) { Label label1; (label1 = new Label(Game.i.localeManager.i18n.get("no_replays_found_cant_restore"), Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.AMBER.P500); label1.setAlignment(1); AccountScreen.b(this.a).getTable().add((Actor)label1).size(600.0F, 64.0F).row(); AccountScreen.a().i("no replays", new Object[0]); }  AccountScreen.b(this.a).getTable().setVisible(true); FancyButton fancyButton = (new FancyButton("regularButton.a", ())).withLabel(30, Game.i.localeManager.i18n.get("cancel")); AccountScreen.b(this.a).getTable().row(); AccountScreen.b(this.a).getTable().add((Actor)fancyButton).padTop(15.0F).size(200.0F, 56.0F); }); } else { AccountScreen.a().e(str, new Object[0]); return; }  } catch (Exception exception) { AccountScreen.a().e("Failed to parse response", new Object[] { exception }); }  } public void failed(Throwable param1Throwable) { AccountScreen.a().e("Error", new Object[] { param1Throwable }); } public void cancelled() { AccountScreen.a().e("Error", new Object[0]); } }); return; } catch (Exception exception) { a.e("Error", new Object[] { exception }); return; }  })).setAlignment(16);
/* 543 */       table3.add((Actor)labelButton).padTop(8.0F).right().height(64.0F).width(300.0F);
/*     */     } 
/*     */ 
/*     */     
/* 547 */     this.e = new Table();
/* 548 */     this.b.getTable().add((Actor)this.e).expand().bottom().padBottom(40.0F);
/*     */     
/* 550 */     if (Game.i.authManager.getSignInStatus() != AuthManager.SignInStatus.SIGNED_IN) Game.i.authManager.loadStateFromServer(null, null);
/*     */ 
/*     */     
/* 553 */     if (Game.i.authManager.isSignedIn()) {
/*     */       
/* 555 */       ScreenTitle.i().setText(Game.i.localeManager.i18n.get("account_screen_title"));
/*     */       
/* 557 */       this.g.setDrawable((Drawable)new TextureRegionDrawable(Game.i.authManager.getAvatar(64)));
/* 558 */       this.h.setText(Game.i.authManager.getNickname());
/* 559 */       this.i.setText(Game.i.authManager.getPlayerId());
/* 560 */       this.j.setText(Game.i.authManager.getEmailHint());
/* 561 */       this.f.setText((Game.i.authManager.getSignInStatus() == AuthManager.SignInStatus.SIGNED_IN) ? 
/* 562 */           Game.i.localeManager.i18n.get("signed_in_online_as") : 
/* 563 */           Game.i.localeManager.i18n.get("signed_in_offline_as"));
/* 564 */       if (this.k != null) {
/* 565 */         if (Game.i.authManager.isPasswordSet()) {
/* 566 */           this.k.setVisible(false);
/*     */         } else {
/* 568 */           this.k.setVisible(true);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 573 */       this.m.clearChildren();
/*     */       
/* 575 */       (label2 = new Label(Game.i.localeManager.i18n.get("loading..."), Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.AMBER.P500);
/* 576 */       this.m.add((Actor)label2);
/*     */       
/* 578 */       Game.i.authManager.getCloudSavedGamesList(paramJsonValue -> {
/*     */             if (paramJsonValue == null) {
/*     */               this.m.clearChildren();
/*     */               
/*     */               Label label;
/*     */               
/*     */               (label = new Label(Game.i.localeManager.i18n.get("failed_to_load_saved_games"), Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.RED.P500);
/*     */               
/*     */               this.m.add((Actor)label);
/*     */             } else {
/*     */               this.m.clearChildren();
/*     */               
/*     */               this.n.clear();
/*     */               
/*     */               byte b = 0;
/*     */               
/*     */               JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator();
/*     */               
/*     */               while (jsonIterator.hasNext()) {
/*     */                 JsonValue jsonValue = jsonIterator.next();
/*     */                 
/*     */                 b++;
/*     */                 
/*     */                 int j = jsonValue.getInt("slotId");
/*     */                 
/*     */                 Group group;
/*     */                 
/*     */                 (group = new Group()).setTransform(false);
/*     */                 
/*     */                 this.m.add((Actor)group).size(800.0F, 160.0F).padBottom(4.0F).row();
/*     */                 
/*     */                 Image image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*     */                 
/*     */                 if (Game.i.authManager.getCloudSaveSlotId() == j) {
/*     */                   image.setColor(new Color(61469747));
/*     */                 } else {
/*     */                   image.setColor(1.0F, 1.0F, 1.0F, 0.07F);
/*     */                 } 
/*     */                 
/*     */                 image.setSize(800.0F, 160.0F);
/*     */                 
/*     */                 group.addActor((Actor)image);
/*     */                 
/*     */                 Label label3;
/*     */                 
/*     */                 (label3 = new Label("#" + j + "-" + jsonValue.getString("gameStartHash") + " (" + StringFormatter.timePassed(jsonValue.getInt("timeInGame"), false, false) + ")", Game.i.assetManager.getLabelStyle(30))).setPosition(20.0F, 108.0F);
/*     */                 
/*     */                 group.addActor((Actor)label3);
/*     */                 
/*     */                 Date date = new Date(jsonValue.getInt("slotTimestamp") * 1000L);
/*     */                 
/*     */                 SimpleDateFormat simpleDateFormat;
/*     */                 
/*     */                 String str2 = (simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US)).format(date);
/*     */                 
/*     */                 int k;
/*     */                 
/*     */                 if (k = (Game.i.authManager.getCloudSaveSlotTimestamp() < jsonValue.getInt("slotTimestamp")) ? 1 : 0) {
/*     */                   str2 = str2 + " - [#4CAF50]" + Game.i.localeManager.i18n.get("newer") + "[]";
/*     */                 }
/*     */                 
/*     */                 Label label2;
/*     */                 
/*     */                 (label2 = new Label(str2, Game.i.assetManager.getLabelStyle(24))).setPosition(20.0F, 70.0F);
/*     */                 
/*     */                 label2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                 
/*     */                 group.addActor((Actor)label2);
/*     */                 
/*     */                 FancyButton fancyButton = (new FancyButton("regularButton.a", ())).withLabel(36, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-cloud-download>"));
/*     */                 
/*     */                 this.n.add(fancyButton);
/*     */                 
/*     */                 fancyButton.setPosition(676.0F, 20.0F);
/*     */                 
/*     */                 fancyButton.setSize(104.0F, 64.0F);
/*     */                 
/*     */                 if (k) {
/*     */                   fancyButton.setFlavor("regularGreenButton.a");
/*     */                 }
/*     */                 
/*     */                 group.addActor((Actor)fancyButton);
/*     */                 
/*     */                 fancyButton = (new FancyButton("regularButton.b", ())).withLabel(36, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-floppy>"));
/*     */                 
/*     */                 this.n.add(fancyButton);
/*     */                 
/*     */                 if (Game.i.authManager.hasUnsavedProgressForCloud() && j == Game.i.authManager.getCloudSaveSlotId()) {
/*     */                   Image image1;
/*     */                   
/*     */                   (image1 = new Image((Drawable)Game.i.assetManager.getQuad("ui.regularGreenButton.b.hover"))).addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(0.0F, 0.33F), (Action)Actions.alpha(1.0F, 0.33F))));
/*     */                   
/*     */                   image1.setFillParent(true);
/*     */                   
/*     */                   fancyButton.addActorAt(1, (Actor)image1);
/*     */                 } 
/*     */                 fancyButton.setPosition(560.0F, 20.0F);
/*     */                 fancyButton.setSize(104.0F, 64.0F);
/*     */                 group.addActor((Actor)fancyButton);
/*     */                 fancyButton = (new FancyButton("regularRedButton.a", ())).withLabel(36, Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-times>"));
/*     */                 this.n.add(fancyButton);
/*     */                 fancyButton.setPosition(468.0F, 20.0F);
/*     */                 fancyButton.setSize(80.0F, 64.0F);
/*     */                 group.addActor((Actor)fancyButton);
/*     */                 if (Game.i.authManager.getCloudSaveSlotId() == j) {
/*     */                   Label label;
/*     */                   (label = new Label(Game.i.localeManager.i18n.get("current").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.AMBER.P500);
/*     */                   label.setAlignment(16);
/*     */                   label.setSize(80.0F, 20.0F);
/*     */                   label.setPosition(700.0F, 124.0F);
/*     */                   group.addActor((Actor)label);
/*     */                   if (Game.i.authManager.hasUnsavedProgressForCloud()) {
/*     */                     Label label4;
/*     */                     (label4 = new Label(Game.i.localeManager.i18n.get("cloud_save_has_unsaved_progress"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.LIGHT_GREEN.P300);
/*     */                     label4.setAlignment(16);
/*     */                     label4.setSize(80.0F, 24.0F);
/*     */                     label4.setPosition(700.0F, 95.0F);
/*     */                     group.addActor((Actor)label4);
/*     */                   } 
/*     */                 } 
/*     */                 k = jsonValue.getInt("gameBuild");
/*     */                 Label label1;
/*     */                 (label1 = new Label(Game.i.localeManager.i18n.get("about_version") + ": B" + k, Game.i.assetManager.getLabelStyle(21))).setPosition(20.0F, 44.0F);
/*     */                 if (207 < k) {
/*     */                   label1.setColor(MaterialColor.ORANGE.P500);
/*     */                 } else {
/*     */                   label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */                 } 
/*     */                 group.addActor((Actor)label1);
/*     */                 String str1 = jsonValue.getString("note", null);
/*     */                 label1 = new Label((str1 == null) ? Game.i.localeManager.i18n.get("click_here_to_add_note") : str1, Game.i.assetManager.getLabelStyle(21));
/*     */                 if (str1 == null) {
/*     */                   label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */                 } else {
/*     */                   label1.setColor(MaterialColor.LIGHT_GREEN.P400);
/*     */                 } 
/*     */                 label1.setPosition(20.0F, 15.0F);
/*     */                 label1.setSize(420.0F, 58.0F);
/*     */                 label1.setWrap(true);
/*     */                 label1.setAlignment(12);
/*     */                 group.addActor((Actor)label1);
/*     */                 label1.setTouchable(Touchable.enabled);
/*     */                 label1.addListener((EventListener)new ClickListener(this, j, str1)
/*     */                     {
/*     */                       public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*     */                       {
/* 724 */                         TextInputOverlay.i().show(new Input.TextInputListener(this)
/*     */                             {
/*     */                               public void input(String param2String) {
/* 727 */                                 Threads.i().runOnMainThread(() -> {
/*     */                                       String str;
/*     */                                       if ((str = Game.i.authManager.getSessionId()) != null) {
/*     */                                         Net.HttpRequest httpRequest;
/*     */                                         (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.SET_CLOUD_SAVE_NOTE);
/*     */                                         HashMap<Object, Object> hashMap;
/*     */                                         (hashMap = new HashMap<>()).put("sessionid", str);
/*     */                                         hashMap.put("slot", param2Int);
/*     */                                         hashMap.put("note", (param2String == null) ? "" : param2String);
/*     */                                         httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */                                         Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */                                             {
/*     */                                               public void handleHttpResponse(Net.HttpResponse param3HttpResponse) {
/* 740 */                                                 AccountScreen.a().i(param3HttpResponse.getResultAsString(), new Object[0]);
/* 741 */                                                 Threads.i().runOnMainThread(AccountScreen::goToScreen);
/*     */                                               }
/*     */ 
/*     */                                               
/*     */                                               public void failed(Throwable param3Throwable) {
/* 746 */                                                 AccountScreen.a().e("SET_CLOUD_SAVE_HINT request failed", new Object[] { param3Throwable });
/*     */                                               }
/*     */ 
/*     */                                               
/*     */                                               public void cancelled() {}
/*     */                                             });
/*     */                                       } 
/*     */                                     });
/*     */                               }
/*     */ 
/*     */                               
/*     */                               public void canceled() {}
/* 758 */                             }Game.i.localeManager.i18n.get("cloud_save_note_title"), this.b, null);
/*     */                       }
/*     */                     });
/*     */               } 
/*     */ 
/*     */               
/*     */               this.m.row();
/*     */ 
/*     */               
/*     */               this.m.add().growY().width(1.0F).row();
/*     */ 
/*     */               
/*     */               int i = Game.i.authManager.getMaxCloudSaveSlots();
/*     */ 
/*     */               
/*     */               if (b < i) {
/*     */                 FancyButton fancyButton = (new FancyButton("regularButton.a", ())).withLabel(24, Game.i.localeManager.i18n.get("save_game_to_new_slot"));
/*     */ 
/*     */                 
/*     */                 this.n.add(fancyButton);
/*     */ 
/*     */                 
/*     */                 this.m.add((Actor)fancyButton).size(400.0F, 80.0F).row();
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/*     */             a.i((paramJsonValue == null) ? "null" : paramJsonValue.toJson(JsonWriter.OutputType.json), new Object[0]);
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 790 */     AuthManager.SignInStatus signInStatus = Game.i.authManager.getSignInStatus();
/* 791 */     this.e.clear();
/*     */     
/* 793 */     Label label1 = new Label(Game.i.localeManager.i18n.get("status") + ": [#FFC107]" + signInStatus.name() + "[] " + (Game.i.actionResolver.isSignedInWithGoogle() ? "G" : ""), Game.i.assetManager.getLabelStyle(24));
/* 794 */     this.e.add((Actor)label1).padTop(64.0F).row();
/*     */     
/* 796 */     label1 = new Label(Game.i.localeManager.i18n.get("nickname") + ": [#FFC107]" + Game.i.authManager.getNickname() + "[]", Game.i.assetManager.getLabelStyle(24));
/* 797 */     this.e.add((Actor)label1).row();
/*     */     
/* 799 */     label1 = new Label("Playerid: [#FFC107]" + Game.i.authManager.getPlayerId() + "[]", Game.i.assetManager.getLabelStyle(24));
/* 800 */     this.e.add((Actor)label1).row();
/*     */   }
/*     */   
/*     */   private void b() {
/* 804 */     this.l.setEnabled(false);
/* 805 */     for (byte b = 0; b < this.n.size; b++) {
/* 806 */       ((FancyButton)this.n.get(b)).setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void c() {
/* 811 */     this.l.setEnabled(true);
/* 812 */     for (byte b = 0; b < this.n.size; b++) {
/* 813 */       ((FancyButton)this.n.get(b)).setEnabled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 819 */     super.dispose();
/* 820 */     Game.i.uiManager.removeLayer(this.b);
/* 821 */     Game.i.uiManager.removeLayer(this.c);
/* 822 */     Game.i.uiManager.removeLayer(this.d);
/*     */     
/* 824 */     Game.i.authManager.removeListener(this.o);
/*     */   }
/*     */   
/*     */   private class _AuthManagerListener extends AuthManager.AuthManagerListener.AuthManagerListenerAdapter { private _AuthManagerListener(AccountScreen this$0) {}
/*     */     
/*     */     public void signInStatusUpdated() {
/* 830 */       if (Game.i.screenManager.getCurrentScreen() instanceof AccountScreen) {
/* 831 */         AccountScreen.goToScreen();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void autoSaveModeChanged() {
/* 837 */       AccountScreen.a(this.a).setEnabled(Game.i.authManager.isAutoSavesEnabled());
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\AccountScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */