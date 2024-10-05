/*     */ package com.prineside.tdi2.screens;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.pay.Transaction;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Purchase;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.screens.account.AccountScreen;
/*     */ import com.prineside.tdi2.screens.account.AccountSetPasswordScreen;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class AccountSettingsScreen extends Screen {
/*  52 */   private static final TLog a = TLog.forClass(AccountSettingsScreen.class);
/*     */   
/*  54 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "AccountSettingsScreen");
/*     */ 
/*     */   
/*     */   private boolean c;
/*     */   
/*  59 */   private static final DateFormat d = DateFormat.getDateInstance(2, Locale.US);
/*  60 */   private static final DateFormat e = DateFormat.getTimeInstance(2, Locale.US);
/*     */ 
/*     */ 
/*     */   
/*     */   public AccountSettingsScreen() {
/*  65 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */     
/*  67 */     Game.i.uiManager.hideAllComponents();
/*  68 */     Game.i.uiManager.setAsInputHandler();
/*     */     
/*  70 */     ScreenTitle.i()
/*  71 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-user"))
/*  72 */       .setText(Game.i.localeManager.i18n.get("account_settings_screen_title"))
/*  73 */       .setVisible(true);
/*     */     
/*  75 */     BackButton.i()
/*  76 */       .setVisible(true)
/*  77 */       .setText(null)
/*  78 */       .setClickHandler(AccountScreen::goToScreen);
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
/*     */   public void draw(float paramFloat) {
/*  90 */     Color color = Game.i.assetManager.getColor("menu_background");
/*  91 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/*  92 */     Gdx.gl.glClear(16640);
/*     */   }
/*     */   
/*     */   public void refresh() {
/*  96 */     this.b.getTable().clear();
/*     */     
/*  98 */     if (Game.i.authManager.getSignInStatus() != AuthManager.SignInStatus.SIGNED_IN) {
/*     */       Label label;
/* 100 */       (label = new Label(Game.i.localeManager.i18n.get("not_signed_in"), Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/* 101 */       this.b.getTable().add((Actor)label).growX().row();
/*     */       
/*     */       FancyButton fancyButton;
/*     */       
/* 105 */       (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(30, Game.i.localeManager.i18n.get("sign_in"))).setClickHandler(() -> {
/*     */             paramFancyButton.setEnabled(false);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             Game.i.authManager.loadStateFromServer(null, ());
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 116 */       this.b.getTable().add((Actor)fancyButton).size(192.0F, 48.0F).padTop(15.0F).row();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     Image image;
/* 122 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setOrigin(32.0F, 32.0F);
/* 123 */     image.addAction((Action)Actions.forever((Action)Actions.rotateBy(180.0F, 1.0F)));
/* 124 */     this.b.getTable().add((Actor)image).size(64.0F);
/*     */     
/*     */     Net.HttpRequest httpRequest;
/*     */     
/* 128 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_ACCOUNT_SETTINGS_URL);
/*     */     HashMap<Object, Object> hashMap;
/* 130 */     (hashMap = new HashMap<>()).put("sessionid", Game.i.authManager.getSessionId());
/* 131 */     hashMap.put("locale", Game.i.localeManager.getLocale());
/*     */ 
/*     */     
/* 134 */     Json json = new Json(JsonWriter.OutputType.json);
/* 135 */     StringWriter stringWriter = new StringWriter();
/* 136 */     json.setWriter(stringWriter);
/* 137 */     json.writeObjectStart();
/*     */ 
/*     */     
/* 140 */     double d = (1.0F + (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.SHOP_PURCHASE_BONUS));
/* 141 */     int i = Game.i.purchaseManager.getPapersHourBasePrice();
/*     */     
/* 143 */     json.writeObjectStart("shopStats");
/* 144 */     json.writeValue("purchaseMultiplier", String.valueOf(d));
/* 145 */     json.writeValue("papersPerHour", String.valueOf(i));
/* 146 */     json.writeObjectEnd();
/*     */     
/* 148 */     json.writeArrayStart("transactions");
/* 149 */     PP_Purchase pP_Purchase = (ProgressPrefs.i()).purchase;
/* 150 */     for (byte b = 0; b < (pP_Purchase.getTransactions()).size; b++) {
/* 151 */       Transaction transaction = (Transaction)pP_Purchase.getTransactions().get(b);
/* 152 */       json.writeObjectStart();
/* 153 */       json.writeValue("identifier", transaction.getIdentifier());
/* 154 */       json.writeValue("purchaseCost", Integer.valueOf(transaction.getPurchaseCost()));
/* 155 */       json.writeValue("storeName", transaction.getStoreName());
/* 156 */       json.writeValue("orderId", transaction.getOrderId());
/* 157 */       json.writeValue("requestId", transaction.getRequestId());
/* 158 */       json.writeValue("userId", transaction.getUserId());
/* 159 */       json.writeValue("purchaseTime", (transaction.getPurchaseTime() == null) ? null : Integer.valueOf((int)(transaction.getPurchaseTime().getTime() / 1000L)));
/* 160 */       json.writeValue("purchaseText", transaction.getPurchaseText());
/* 161 */       json.writeValue("purchaseCostCurrency", transaction.getPurchaseCostCurrency());
/* 162 */       json.writeValue("reversalTime", (transaction.getReversalTime() == null) ? null : Integer.valueOf((int)(transaction.getReversalTime().getTime() / 1000L)));
/* 163 */       json.writeValue("reversalText", transaction.getReversalText());
/* 164 */       json.writeValue("transactionData", transaction.getTransactionData());
/* 165 */       json.writeValue("transactionDataSignature", transaction.getTransactionDataSignature());
/* 166 */       json.writeObjectEnd();
/*     */     } 
/* 168 */     json.writeArrayEnd();
/*     */     
/* 170 */     json.writeObjectEnd();
/* 171 */     hashMap.put("data", stringWriter.toString());
/*     */     
/* 173 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 174 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */         {
/*     */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 177 */             String str = param1HttpResponse.getResultAsString();
/* 178 */             AccountSettingsScreen.a().i("getAccountSettings server: " + str, new Object[0]);
/* 179 */             Threads.i().runOnMainThread(() -> {
/*     */                   try {
/*     */                     AccountSettingsScreen.a(this.a, (new JsonReader()).parse(param1String)); return;
/* 182 */                   } catch (Exception exception) {
/*     */                     AccountSettingsScreen.a().e("failed to parse response from server: " + param1String, new Object[] { exception });
/*     */                     return;
/*     */                   } 
/*     */                 });
/*     */           }
/*     */           
/*     */           public void failed(Throwable param1Throwable) {
/* 190 */             AccountSettingsScreen.a().e("failed to get account settings", new Object[] { param1Throwable });
/*     */           }
/*     */ 
/*     */           
/*     */           public void cancelled() {}
/*     */         });
/*     */   }
/*     */   
/*     */   private void a(JsonValue paramJsonValue) {
/* 199 */     this.b.getTable().clear();
/*     */     
/* 201 */     Table table1 = new Table();
/*     */     ScrollPane scrollPane;
/* 203 */     (scrollPane = new ScrollPane((Actor)table1, Game.i.assetManager.getScrollPaneStyle(16.0F))).setScrollingDisabled(true, false);
/* 204 */     UiUtils.enableMouseMoveScrollFocus(scrollPane);
/* 205 */     this.b.getTable().add((Actor)scrollPane).expand().fill();
/*     */     
/* 207 */     table1.add().width(1.0F).height(120.0F).row();
/*     */ 
/*     */     
/* 210 */     Table table2 = new Table();
/* 211 */     table1.add((Actor)table2).width(960.0F).padBottom(15.0F).row();
/*     */     
/*     */     Label label2;
/* 214 */     (label2 = new Label(Game.i.authManager.getNickname(), Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.CYAN.P500);
/* 215 */     table2.add((Actor)label2).growX().row();
/*     */ 
/*     */     
/* 218 */     (label2 = new Label(Game.i.authManager.getPlayerId(), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 219 */     table2.add((Actor)label2).growX().row();
/*     */ 
/*     */     
/* 222 */     (label2 = new Label(Game.i.authManager.getEmailHint() + (paramJsonValue.getBoolean("email_confirmed") ? Game.i.assetManager.replaceRegionAliasesWithChars(" <@icon-check>") : ""), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 223 */     table2.add((Actor)label2).growX().row();
/*     */ 
/*     */     
/* 226 */     if (paramJsonValue.getBoolean("email_set") && 
/* 227 */       !paramJsonValue.getBoolean("email_confirmed")) {
/*     */       
/* 229 */       (table2 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.ORANGE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F)));
/*     */       
/* 231 */       (label2 = new Label(Game.i.localeManager.i18n.get("email_not_confirmed"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 232 */       table2.add((Actor)label2).pad(15.0F).padLeft(40.0F).width(570.0F);
/*     */       
/*     */       FancyButton fancyButton;
/*     */       
/* 236 */       (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("confirm_email_button"))).setClickHandler(() -> {
/*     */             paramFancyButton.setEnabled(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             Game.i.authManager.confirmEmail(());
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 254 */       table2.add((Actor)fancyButton).left().height(48.0F).pad(15.0F).growX().row();
/*     */       
/* 256 */       table1.add((Actor)table2).width(960.0F).padBottom(15.0F).row();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 263 */     if (!paramJsonValue.getBoolean("password_set")) {
/*     */       
/* 265 */       (table2 = new Table()).setTouchable(Touchable.enabled);
/* 266 */       table2.addListener((EventListener)new ClickListener(this)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 269 */               Game.i.screenManager.setScreen((Screen)new AccountSetPasswordScreen());
/*     */             }
/*     */           });
/* 272 */       table2.setBackground(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.PURPLE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F)));
/*     */ 
/*     */       
/* 275 */       (label2 = new Label(Game.i.localeManager.i18n.get("account_password_not_set_hint"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 276 */       table2.add((Actor)label2).pad(15.0F).padLeft(40.0F).padRight(40.0F).growX();
/* 277 */       table1.add((Actor)table2).width(960.0F).padBottom(15.0F).row();
/*     */     } 
/* 279 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/* 280 */       if (!paramJsonValue.getBoolean("steam_linked")) {
/*     */         
/* 282 */         (table2 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_BLUE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F)));
/*     */         
/* 284 */         Table table = new Table();
/* 285 */         table2.add((Actor)table).pad(15.0F).padLeft(40.0F).width(570.0F);
/*     */         
/*     */         Label label;
/* 288 */         (label = new Label(Game.i.localeManager.i18n.get("steam_account_not_linked"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 289 */         table.add((Actor)label).growX().row();
/*     */ 
/*     */         
/* 292 */         (label = new Label(Game.i.localeManager.i18n.get("steam_account_link_benefits"), Game.i.assetManager.getLabelStyle(18))).setWrap(true);
/* 293 */         table.add((Actor)label).growX().padTop(5.0F).row();
/*     */         
/*     */         FancyButton fancyButton;
/*     */         
/* 297 */         (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("link_steam_button"))).setClickHandler(() -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("link_steam_button_confirm"), ()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 305 */         table2.add((Actor)fancyButton).left().height(48.0F).pad(15.0F).growX().row();
/*     */         
/* 307 */         table1.add((Actor)table2).width(960.0F).padBottom(15.0F).row();
/*     */       }
/*     */       else {
/*     */         
/* 311 */         (table2 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F)));
/*     */ 
/*     */         
/* 314 */         (label2 = new Label(Game.i.localeManager.i18n.get("steam_account_linked"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 315 */         label2.setColor(MaterialColor.LIGHT_GREEN.P300);
/* 316 */         table2.add((Actor)label2).padBottom(10.0F).padTop(10.0F).padLeft(40.0F).padRight(40.0F).growX().row();
/*     */         
/* 318 */         table1.add((Actor)table2).width(960.0F).padBottom(15.0F).row();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 323 */     Label label1 = new Label(Game.i.localeManager.i18n.get("account_statuses"), Game.i.assetManager.getLabelStyle(36));
/* 324 */     table1.add((Actor)label1).width(960.0F).padTop(40.0F).row();
/*     */     
/* 326 */     (label2 = new Label(Game.i.localeManager.i18n.get("account_statuses_hint"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/* 327 */     label2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 328 */     table1.add((Actor)label2).width(960.0F).padBottom(15.0F).row();
/* 329 */     if ((paramJsonValue.get("profile_statuses")).size > 0) {
/* 330 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.get("profile_statuses").iterator(); jsonIterator.hasNext(); ) {
/* 331 */         JsonValue jsonValue2, jsonValue1 = (jsonValue2 = jsonIterator.next()).get("current_status");
/*     */         
/* 333 */         Table table4 = new Table();
/* 334 */         if (jsonValue1 == null) {
/* 335 */           table4.background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*     */         } else {
/* 337 */           table4.background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.14F)));
/*     */         } 
/* 339 */         table1.add((Actor)table4).width(960.0F).padBottom(4.0F).row();
/*     */         
/* 341 */         Table table5 = new Table();
/* 342 */         table4.add((Actor)table5).padLeft(40.0F).padRight(40.0F).padTop(20.0F).growX().row();
/*     */         
/* 344 */         Label label3 = new Label(jsonValue2.getString("title"), Game.i.assetManager.getLabelStyle(30));
/* 345 */         if (jsonValue1 != null) {
/* 346 */           label3.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */         }
/* 348 */         table5.add((Actor)label3).growX();
/*     */         
/* 350 */         if (jsonValue1 == null) {
/*     */           
/* 352 */           (label4 = new Label(Game.i.localeManager.i18n.get("account_status_not_linked"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */         } else {
/*     */           
/* 355 */           (label4 = new Label(Game.i.localeManager.i18n.get("account_status_linked"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */         } 
/* 357 */         table5.add((Actor)label4);
/*     */         
/*     */         Label label4;
/* 360 */         (label4 = new Label(jsonValue2.getString("description"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.78F);
/* 361 */         label4.setWrap(true);
/* 362 */         table4.add((Actor)label4).padLeft(40.0F).padRight(40.0F).padBottom(15.0F).growX().row();
/*     */         
/* 364 */         if (jsonValue1 != null) {
/*     */           
/* 366 */           (label4 = new Label(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-check> " + jsonValue1.getString("reason")), Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 367 */           table4.add((Actor)label4).padLeft(40.0F).padRight(40.0F).growX().row();
/*     */           
/* 369 */           int i = jsonValue1.getInt("received_at");
/* 370 */           boolean bool = jsonValue1.get("removed_at").isNull() ? true : jsonValue1.getInt("removed_at");
/* 371 */           String str1 = d.format(new Date(i * 1000L)) + " " + e.format(new Date(i * 1000L));
/* 372 */           str1 = str1 + " - ";
/* 373 */           if (bool == -1) {
/* 374 */             str1 = str1 + "Permanently";
/*     */           } else {
/* 376 */             str1 = str1 + d.format(new Date(bool * 1000L)) + " " + e.format(new Date(bool * 1000L));
/*     */           } 
/*     */           
/*     */           Label label;
/* 380 */           (label = new Label(str1, Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 381 */           table4.add((Actor)label).padLeft(40.0F).padRight(40.0F).padBottom(15.0F).growX().row();
/*     */         } 
/*     */         
/* 384 */         if (jsonValue1 != null) {
/*     */           
/* 386 */           if ("double_gain".equals(jsonValue2.getString("id")) && !Game.i.progressManager.hasPermanentDoubleGain()) {
/*     */             FancyButton fancyButton;
/*     */ 
/*     */             
/* 390 */             (fancyButton = (new FancyButton("regularGreenButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("enable_account_status_button"))).setClickHandler(() -> {
/*     */                   Game.i.progressManager.enableDoubleGainPermanently();
/*     */                   Game.i.screenManager.goToAccountSettingsScreen();
/*     */                 });
/* 394 */             table4.add((Actor)fancyButton).left().padLeft(40.0F).size(240.0F, 48.0F).padBottom(15.0F).row();
/*     */           } 
/*     */           continue;
/*     */         } 
/* 398 */         if ("double_gain".equals(jsonValue2.getString("id"))) {
/*     */ 
/*     */           
/* 401 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = paramJsonValue.get("transactions").iterator(); jsonIterator1.hasNext();) {
/* 402 */             if ((jsonValue = jsonIterator1.next()).getBoolean("valid") && (
/* 403 */               jsonValue
/* 404 */               .getString("identifier").equals("double_gain_infinitode2") || jsonValue
/* 405 */               .getString("identifier").equals("double_gain"))) {
/*     */               FancyButton fancyButton;
/*     */ 
/*     */ 
/*     */               
/* 410 */               (fancyButton = (new FancyButton("regularGreenButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("account_status_enable_with_purchase") + " (" + jsonValue.getString("store_name") + ")")).setClickHandler(() -> {
/*     */                     paramFancyButton.setEnabled(false);
/*     */                     
/*     */                     Json json = new Json(JsonWriter.OutputType.json);
/*     */                     
/*     */                     StringWriter stringWriter = new StringWriter();
/*     */                     
/*     */                     json.setWriter(stringWriter);
/*     */                     
/*     */                     json.writeObjectStart();
/*     */                     
/*     */                     json.writeValue("type", "transaction");
/*     */                     
/*     */                     json.writeValue("store_name", paramJsonValue.getString("store_name"));
/*     */                     
/*     */                     json.writeValue("order_id", paramJsonValue.getString("order_id"));
/*     */                     
/*     */                     json.writeObjectEnd();
/*     */                     
/*     */                     Game.i.authManager.linkAccountStatus(stringWriter.toString(), ());
/*     */                   });
/*     */               
/* 432 */               table4.add((Actor)fancyButton).left().padLeft(40.0F).size(400.0F, 48.0F).padBottom(15.0F).row();
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 438 */           if (Game.i.actionResolver.doubleGainEnabledBySteamGamePurchase()) {
/*     */             Label label;
/*     */             
/* 441 */             (label = new Label(Game.i.localeManager.i18n.get("steam_game_purchase_found_can_link_dg"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/* 442 */             table4.add((Actor)label).fillX().padLeft(40.0F).padRight(40.0F).padTop(15.0F).padBottom(15.0F).row();
/*     */             
/*     */             FancyButton fancyButton;
/*     */             
/* 446 */             (fancyButton = (new FancyButton("regularGreenButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("account_status_enable_with_steam_link"))).setClickHandler(() -> {
/*     */                   paramFancyButton.setEnabled(false);
/*     */ 
/*     */                   
/*     */                   Game.i.authManager.linkSteamAccount(());
/*     */                 });
/*     */ 
/*     */             
/* 454 */             table4.add((Actor)fancyButton).left().padLeft(40.0F).size(400.0F, 48.0F).padBottom(15.0F).row();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       Label label;
/*     */       
/* 461 */       (label = new Label(Game.i.localeManager.i18n.get("account_has_no_statuses"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 462 */       table1.add((Actor)label).width(960.0F).padBottom(15.0F).row();
/*     */     } 
/*     */ 
/*     */     
/* 466 */     String str = Game.i.authManager.getPlayerId();
/*     */     
/* 468 */     Table table3 = new Table();
/* 469 */     label1 = new Label(Game.i.localeManager.i18n.get("transactions"), Game.i.assetManager.getLabelStyle(36));
/* 470 */     table3.add((Actor)label1);
/*     */     
/* 472 */     table3.add().height(1.0F).growX();
/*     */     
/* 474 */     if (Game.i.purchaseManager.isPurchasesEnabled()) {
/*     */       FancyButton fancyButton;
/*     */       
/* 477 */       (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("settings_restore_purchases"))).setClickHandler(() -> {
/*     */             Game.i.purchaseManager.purchaseManager.purchaseRestore();
/*     */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("settings_purchases_restored"));
/*     */             refresh();
/*     */           });
/* 482 */       table3.add((Actor)fancyButton).height(48.0F).width(220.0F).pad(15.0F);
/*     */     } 
/* 484 */     table3.row();
/*     */     
/* 486 */     table1.add((Actor)table3).width(960.0F).padTop(40.0F).padBottom(15.0F).row();
/*     */     
/* 488 */     if ((paramJsonValue.get("transactions")).size > 0) {
/* 489 */       Table table = new Table();
/* 490 */       table1.add((Actor)table).pad(15.0F).width(930.0F).row();
/*     */       
/*     */       Label label;
/* 493 */       (label = new Label("Store", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 494 */       table.add((Actor)label).width(150.0F);
/*     */ 
/*     */       
/* 497 */       (label = new Label("Order ID", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 498 */       table.add((Actor)label).growX();
/*     */ 
/*     */       
/* 501 */       (label = new Label("Date", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 502 */       table.add((Actor)label).width(150.0F);
/*     */       
/* 504 */       table.add().height(1.0F).width(64.0F);
/* 505 */       table.add().height(1.0F).width(64.0F);
/*     */       
/* 507 */       Array array = new Array();
/* 508 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.get("transactions").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 509 */         array.add(jsonValue); }
/*     */       
/* 511 */       array.sort((paramJsonValue1, paramJsonValue2) -> Integer.compare(paramJsonValue2.getInt("purchase_time"), paramJsonValue1.getInt("purchase_time")));
/*     */       
/* 513 */       for (byte b = 0; b < array.size; b++) {
/* 514 */         if (!this.c && 
/* 515 */           b == 10) {
/*     */           FancyButton fancyButton;
/*     */           
/* 518 */           (fancyButton = (new FancyButton("regularButton.a", null)).withLabel(24, Game.i.localeManager.i18n.get("show_more_button"))).setClickHandler(() -> {
/*     */                 this.c = true;
/*     */                 refresh();
/*     */               });
/* 522 */           table1.add((Actor)fancyButton).height(48.0F).width(220.0F).pad(15.0F).row();
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 528 */         JsonValue jsonValue = (JsonValue)array.get(b);
/*     */         Table table4;
/* 530 */         (table4 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/* 531 */         if (!jsonValue.getBoolean("valid") || !jsonValue.getString("playerid").equals(str)) {
/* 532 */           table4.background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.ORANGE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.14F)));
/*     */         }
/* 534 */         table1.add((Actor)table4).width(960.0F).padBottom(4.0F).row();
/*     */         
/* 536 */         table = new Table();
/* 537 */         table4.add((Actor)table).pad(15.0F).width(930.0F);
/*     */         
/* 539 */         label = new Label(jsonValue.getString("store_name"), Game.i.assetManager.getLabelStyle(24));
/* 540 */         table.add((Actor)label).width(150.0F);
/*     */         
/* 542 */         table4 = new Table();
/* 543 */         label = new Label(jsonValue.getString("order_id"), Game.i.assetManager.getLabelStyle(24));
/* 544 */         table4.add((Actor)label).growX().row();
/*     */         
/* 546 */         (label = new Label(jsonValue.getString("identifier"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 547 */         table4.add((Actor)label).growX().row();
/* 548 */         table.add((Actor)table4).growX();
/*     */ 
/*     */         
/* 551 */         label = new Label(d.format(new Date(jsonValue.getInt("purchase_time") * 1000L)), Game.i.assetManager.getLabelStyle(24));
/* 552 */         table.add((Actor)label).width(150.0F);
/*     */         
/* 554 */         if (!jsonValue.getString("playerid").equals(str)) {
/* 555 */           String str1 = jsonValue.getString("playerid");
/*     */           Image image;
/* 557 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-user"))).setColor(MaterialColor.ORANGE.P500);
/* 558 */           image.setTouchable(Touchable.enabled);
/* 559 */           image.addListener((EventListener)new ClickListener(this, str1)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 562 */                   Dialog.i().showAlert(Game.i.localeManager.i18n.get("transaction_warning_wrong_owner") + " " + this.a);
/*     */                 }
/*     */               });
/* 565 */           table.add((Actor)image).height(32.0F).width(32.0F).padLeft(16.0F).padRight(16.0F);
/*     */         } else {
/* 567 */           table.add().height(1.0F).width(64.0F);
/*     */         } 
/*     */         
/* 570 */         if (jsonValue.getBoolean("valid")) {
/*     */           Image image;
/* 572 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 573 */           image.setTouchable(Touchable.enabled);
/* 574 */           image.addListener((EventListener)new ClickListener(this)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 577 */                   Dialog.i().showAlert(Game.i.localeManager.i18n.get("transaction_info_valid"));
/*     */                 }
/*     */               });
/* 580 */           table.add((Actor)image).height(32.0F).width(32.0F).padLeft(16.0F).padRight(16.0F);
/*     */         } else {
/*     */           Image image;
/* 583 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-times"))).setColor(MaterialColor.ORANGE.P500);
/* 584 */           image.setTouchable(Touchable.enabled);
/* 585 */           image.addListener((EventListener)new ClickListener(this)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 588 */                   Dialog.i().showAlert(Game.i.localeManager.i18n.get("transaction_info_invalid"));
/*     */                 }
/*     */               });
/* 591 */           table.add((Actor)image).height(32.0F).width(32.0F).padLeft(16.0F).padRight(16.0F);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 596 */       (label1 = new Label(Game.i.localeManager.i18n.get("account_has_no_transactions"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 597 */       table1.add((Actor)label1).width(960.0F).padBottom(15.0F).row();
/*     */     } 
/*     */     
/* 600 */     table1.add().growY().row();
/* 601 */     table1.add().width(1.0F).height(120.0F).row();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/* 606 */     refresh();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 611 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\AccountSettingsScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */