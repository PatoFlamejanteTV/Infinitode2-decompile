/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.events.game.ScoreChange;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class LiveLeaderboard implements Disposable {
/*  53 */   private static final TLog a = TLog.forClass(LiveLeaderboard.class);
/*     */ 
/*     */   
/*  56 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "LiveLeaderboard");
/*     */ 
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private int d;
/*     */   
/*  63 */   private Array<PlaceConfig> e = new Array(PlaceConfig.class);
/*     */   
/*     */   private Group f;
/*     */   private Label g;
/*     */   private Label h;
/*     */   private Label i;
/*     */   private Label j;
/*     */   private Label k;
/*     */   private Label l;
/*     */   private Label m;
/*     */   private Image n;
/*     */   private Group o;
/*     */   private Group p;
/*     */   private Group q;
/*     */   private Group r;
/*     */   
/*  79 */   private Pool<ListItem> s = new Pool<ListItem>(this, 1, 512)
/*     */     {
/*     */       private LiveLeaderboard.ListItem a() {
/*  82 */         return new LiveLeaderboard.ListItem(this.a, false);
/*     */       }
/*     */     };
/*     */   
/*  86 */   private int u = -1; private PlaceConfig t;
/*  87 */   private int v = -1;
/*     */   
/*  89 */   private Array<PlaceConfig> w = new Array(PlaceConfig.class);
/*  90 */   private Array<ListItem> x = new Array(ListItem.class);
/*     */   
/*     */   private GameSystemProvider y;
/*  93 */   private final Runnable z = this::d;
/*     */   
/*  95 */   private static final StringBuilder A = new StringBuilder();
/*     */   
/*     */   public LiveLeaderboard(GameSystemProvider paramGameSystemProvider) {
/*  98 */     this.y = paramGameSystemProvider;
/*     */     
/*     */     Group group;
/* 101 */     (group = new Group()).setTransform(false);
/* 102 */     group.setTouchable(Touchable.childrenOnly);
/* 103 */     this.b.getTable().add((Actor)group).expand().top().right().size(320.0F, 336.0F).padRight(40.0F);
/*     */     
/* 105 */     this.b.getTable().add().expandY().fillY().row();
/*     */     
/* 107 */     this.r = new Group();
/* 108 */     this.r.setTransform(false);
/* 109 */     this.r.setSize(320.0F, 336.0F);
/* 110 */     this.r.setPosition(0.0F, 336.0F);
/* 111 */     this.r.setTouchable(Touchable.enabled);
/* 112 */     this.r.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 115 */             this.a.toggleVisible();
/*     */           }
/*     */         });
/* 118 */     group.addActor((Actor)this.r);
/*     */     
/* 120 */     this.f = new Group();
/* 121 */     this.f.setTransform(false);
/* 122 */     this.f.setPosition(0.0F, 86.0F);
/* 123 */     this.r.addActor((Actor)this.f);
/*     */     
/* 125 */     paramGameSystemProvider.events.getListeners(Render.class).add(new Listener<Render>(this)
/*     */         {
/*     */           public void handleEvent(Render param1Render) {
/* 128 */             LiveLeaderboard.a(this.a);
/*     */           }
/*     */         });
/*     */     
/* 132 */     String str = Game.i.authManager.getPlayerId();
/* 133 */     if (paramGameSystemProvider.gameState.basicLevelName != null && 
/* 134 */       (Game.i.basicLevelManager.getLevel(paramGameSystemProvider.gameState.basicLevelName)).hasLeaderboards && str != null && Game.i.authManager
/*     */       
/* 136 */       .isSignedIn() && (paramGameSystemProvider.gameState.difficultyMode == DifficultyMode.NORMAL || 
/* 137 */       DifficultyMode.isEndless(paramGameSystemProvider.gameState.difficultyMode)) && Game.i.settingsManager
/* 138 */       .getCustomValue(SettingsManager.CustomValueType.LIVE_LEADERBOARDS) != 0.0D) {
/*     */       Net.HttpRequest httpRequest;
/*     */       
/* 141 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_RUNTIME_LEADERBOARDS_URL);
/*     */       HashMap<Object, Object> hashMap;
/* 143 */       (hashMap = new HashMap<>()).put("gamemode", paramGameSystemProvider.gameState.gameMode.name());
/* 144 */       hashMap.put("difficulty", paramGameSystemProvider.gameState.difficultyMode.name());
/* 145 */       hashMap.put("mapname", paramGameSystemProvider.gameState.basicLevelName);
/* 146 */       hashMap.put("playerid", str);
/* 147 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 148 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramGameSystemProvider, group)
/*     */           {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */               try {
/* 152 */                 String str = param1HttpResponse.getResultAsString();
/* 153 */                 LiveLeaderboard.a().i("getRuntimeLeaderboards result for map name " + this.b.gameState.basicLevelName, new Object[0]);
/*     */                 
/*     */                 JsonValue jsonValue;
/*     */                 
/* 157 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success"))
/*     */                 {
/* 159 */                   Threads.i().runOnMainThread(() -> {
/*     */                         if (param1GameSystemProvider == null || param1GameSystemProvider.gameState == null) {
/*     */                           return;
/*     */                         }
/*     */                         
/*     */                         LiveLeaderboard.a(this.a, param1JsonValue.get("player").getInt("total"));
/*     */                         
/*     */                         if (LiveLeaderboard.b(this.a) == 0) {
/*     */                           return;
/*     */                         }
/*     */                         long l = param1JsonValue.get("player").getLong("score");
/*     */                         JsonValue.JsonIterator<JsonValue> jsonIterator = (param1JsonValue = param1JsonValue.get("leaderboards")).iterator();
/*     */                         while (jsonIterator.hasNext()) {
/*     */                           JsonValue jsonValue = jsonIterator.next();
/*     */                           try {
/*     */                             LiveLeaderboard.PlaceConfig placeConfig;
/*     */                             (placeConfig = new LiveLeaderboard.PlaceConfig((byte)0)).nickname = jsonValue.getString("nickname");
/*     */                             placeConfig.score = jsonValue.getLong("score");
/*     */                             placeConfig.place = jsonValue.getInt("position");
/*     */                             placeConfig.hasPfp = jsonValue.getBoolean("hasPfp", false);
/*     */                             placeConfig.playerId = jsonValue.getString("playerid");
/*     */                             LiveLeaderboard.c(this.a).add(placeConfig);
/* 181 */                           } catch (Exception exception) {
/*     */                             String str = "failed to parse live leaderboards place result: " + jsonValue.toJson(JsonWriter.OutputType.json);
/*     */                             
/*     */                             LiveLeaderboard.a().e(str, new Object[] { exception });
/*     */                             
/*     */                             CrashHandler.report(str, exception);
/*     */                           } 
/*     */                         } 
/*     */                         
/*     */                         LiveLeaderboard.a(this.a, new LiveLeaderboard.PlaceConfig((byte)0));
/*     */                         
/*     */                         (LiveLeaderboard.d(this.a)).listItem = new LiveLeaderboard.ListItem(this.a, true);
/*     */                         
/*     */                         (LiveLeaderboard.d(this.a)).listItem.setup(Game.i.authManager.getNickname(), 0L, 0, (Drawable)new TextureRegionDrawable(Game.i.authManager.getAvatar(64)));
/*     */                         
/*     */                         LiveLeaderboard.a(this.a, new Label(Game.i.localeManager.i18n.get("live_leaderboard_previous_record") + ": " + StringFormatter.commaSeparatedNumber(l), Game.i.assetManager.getLabelStyle(21)));
/*     */                         
/*     */                         LiveLeaderboard.e(this.a).setAlignment(1);
/*     */                         
/*     */                         LiveLeaderboard.e(this.a).setPosition(0.0F, 280.0F);
/*     */                         
/*     */                         LiveLeaderboard.e(this.a).setSize(320.0F, 16.0F);
/*     */                         
/*     */                         LiveLeaderboard.e(this.a).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         
/*     */                         LiveLeaderboard.f(this.a).addActor((Actor)LiveLeaderboard.e(this.a));
/*     */                         
/*     */                         LiveLeaderboard.a(this.a, new Group());
/*     */                         
/*     */                         LiveLeaderboard.g(this.a).setTransform(false);
/*     */                         
/*     */                         LiveLeaderboard.g(this.a).setSize(30.0F, 6.0F);
/*     */                         
/*     */                         LiveLeaderboard.g(this.a).setPosition(145.0F, 221.0F);
/*     */                         
/*     */                         byte b;
/*     */                         
/*     */                         for (b = 0; b < 3; b++) {
/*     */                           Image image;
/*     */                           
/*     */                           (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setSize(6.0F, 6.0F);
/*     */                           
/*     */                           image.setPosition(b * 12.0F, 0.0F);
/*     */                           
/*     */                           image.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */                           
/*     */                           LiveLeaderboard.g(this.a).addActor((Actor)image);
/*     */                         } 
/*     */                         
/*     */                         LiveLeaderboard.f(this.a).addActor((Actor)LiveLeaderboard.g(this.a));
/*     */                         
/*     */                         LiveLeaderboard.b(this.a, new Group());
/*     */                         
/*     */                         LiveLeaderboard.h(this.a).setTransform(false);
/*     */                         
/*     */                         LiveLeaderboard.h(this.a).setSize(320.0F, 100.0F);
/*     */                         
/*     */                         LiveLeaderboard.h(this.a).setPosition(0.0F, 22.0F);
/*     */                         
/*     */                         LiveLeaderboard.f(this.a).addActor((Actor)LiveLeaderboard.h(this.a));
/*     */                         
/*     */                         LiveLeaderboard.c(this.a, new Group());
/*     */                         
/*     */                         LiveLeaderboard.i(this.a).setTransform(false);
/*     */                         
/*     */                         LiveLeaderboard.i(this.a).setSize(30.0F, 6.0F);
/*     */                         
/*     */                         LiveLeaderboard.i(this.a).setPosition(145.0F, 49.0F);
/*     */                         
/*     */                         for (b = 0; b < 3; b++) {
/*     */                           Image image;
/*     */                           
/*     */                           (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setSize(6.0F, 6.0F);
/*     */                           
/*     */                           image.setPosition(b * 12.0F, 0.0F);
/*     */                           
/*     */                           image.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */                           
/*     */                           LiveLeaderboard.i(this.a).addActor((Actor)image);
/*     */                         } 
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)LiveLeaderboard.i(this.a));
/*     */                         LiveLeaderboard.a(this.a, new Image((Drawable)Game.i.assetManager.getDrawable("gradient-radial-top")));
/*     */                         LiveLeaderboard.j(this.a).setSize(320.0F, 40.0F);
/*     */                         LiveLeaderboard.j(this.a).setColor(MaterialColor.LIGHT_BLUE.P800.r, MaterialColor.LIGHT_BLUE.P800.g, MaterialColor.LIGHT_BLUE.P800.b, 0.4F);
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)LiveLeaderboard.j(this.a));
/*     */                         Table table1;
/*     */                         (table1 = new Table()).setPosition(0.0F, 12.0F);
/*     */                         table1.setSize(320.0F, 18.0F);
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)table1);
/*     */                         LiveLeaderboard.b(this.a, new Label("~ 123,456 / 567,890", Game.i.assetManager.getLabelStyle(24)));
/*     */                         table1.add((Actor)LiveLeaderboard.k(this.a));
/*     */                         LiveLeaderboard.c(this.a, new Label("/ " + StringFormatter.commaSeparatedNumber((LiveLeaderboard.b(this.a) + 1)), Game.i.assetManager.getLabelStyle(21)));
/*     */                         LiveLeaderboard.l(this.a).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         table1.add((Actor)LiveLeaderboard.l(this.a)).padLeft(5.0F);
/*     */                         Table table2;
/*     */                         (table2 = new Table()).setPosition(0.0F, -22.0F);
/*     */                         table2.setSize(320.0F, 32.0F);
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)table2);
/*     */                         if (HotKeyHintLabel.isEnabled()) {
/*     */                           HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_LEADERBOARD), 300.0F, 0.0F);
/*     */                           LiveLeaderboard.h(this.a).addActor((Actor)hotKeyHintLabel);
/*     */                         } 
/*     */                         LiveLeaderboard.d(this.a, new Label("Top 13%", Game.i.assetManager.getLabelStyle(21)));
/*     */                         LiveLeaderboard.m(this.a).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         table2.add((Actor)LiveLeaderboard.m(this.a));
/*     */                         Image image1;
/*     */                         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         table2.add((Actor)image1).size(20.0F).padLeft(20.0F);
/*     */                         LiveLeaderboard.e(this.a, new Label("14,551", Game.i.assetManager.getLabelStyle(21)));
/*     */                         LiveLeaderboard.n(this.a).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         table2.add((Actor)LiveLeaderboard.n(this.a)).padLeft(5.0F);
/*     */                         Image image2;
/*     */                         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-double-arrow-up"))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */                         table2.add((Actor)image2).size(20.0F).padLeft(5.0F);
/*     */                         LiveLeaderboard.f(this.a, new Label(Game.i.localeManager.i18n.get("time_limit_reached") + " (" + StringFormatter.timePassed(MathUtils.round(2700.0F), false, false) + ")", Game.i.assetManager.getLabelStyle(21)));
/*     */                         LiveLeaderboard.o(this.a).setPosition(0.0F, -46.0F);
/*     */                         LiveLeaderboard.o(this.a).setSize(320.0F, 32.0F);
/*     */                         LiveLeaderboard.o(this.a).setAlignment(1);
/*     */                         LiveLeaderboard.o(this.a).setColor(MaterialColor.AMBER.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*     */                         LiveLeaderboard.o(this.a).setVisible(false);
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)LiveLeaderboard.o(this.a));
/*     */                         LiveLeaderboard.g(this.a, new Label("", Game.i.assetManager.getLabelStyle(24)));
/*     */                         LiveLeaderboard.p(this.a).setPosition(0.0F, -50.0F);
/*     */                         LiveLeaderboard.p(this.a).setSize(320.0F, 32.0F);
/*     */                         LiveLeaderboard.p(this.a).setAlignment(1);
/*     */                         LiveLeaderboard.p(this.a).setColor(MaterialColor.LIGHT_GREEN.P500.cpy());
/*     */                         LiveLeaderboard.p(this.a).setVisible(false);
/*     */                         LiveLeaderboard.h(this.a).addActor((Actor)LiveLeaderboard.p(this.a));
/*     */                         param1GameSystemProvider.events.getListeners(ScoreChange.class).add(()).setDescription("LiveLeaderboard - rebuilds a list");
/*     */                         param1GameSystemProvider._gameUi.sideMenu.addListener((SideMenu.SideMenuListener)new SideMenu.SideMenuListener.SideMenuListenerAdapter(this)
/*     */                             {
/*     */                               private void a()
/*     */                               {
/* 314 */                                 LiveLeaderboard.q(this.a.a);
/*     */                               }
/*     */ 
/*     */                               
/*     */                               public void offscreenStartingToChange() {
/* 319 */                                 a();
/*     */                               }
/*     */ 
/*     */                               
/*     */                               public void visibilityChanged() {
/* 324 */                                 a();
/*     */                               }
/*     */                             });
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
/*     */                         LiveLeaderboard.a(this.a, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_LIVE_LEADERBOARDS_VISIBLE) == 1.0D));
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
/*     */                         LiveLeaderboard.r(this.a);
/*     */                       });
/*     */                 }
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
/*     */                 return;
/* 375 */               } catch (Exception exception) {
/* 376 */                 LiveLeaderboard.a().e("failed to load live leaderboards", new Object[] { exception });
/*     */                 return;
/*     */               } 
/*     */             }
/*     */             
/*     */             public void failed(Throwable param1Throwable) {
/* 382 */               LiveLeaderboard.a().e("request failed", new Object[] { param1Throwable });
/*     */             }
/*     */             
/*     */             public void cancelled()
/*     */             {
/* 387 */               LiveLeaderboard.a().e("request canceled", new Object[0]); }
/*     */           });
/*     */       return;
/*     */     } 
/* 391 */     a.i("cancel, level: " + paramGameSystemProvider.gameState.basicLevelName + ", is signed in: " + Game.i.authManager.isSignedIn() + ", difficulty: " + paramGameSystemProvider.gameState.difficultyMode.name(), new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 398 */     if (DifficultyMode.isEndless(this.y.gameState.difficultyMode) && this.k != null) {
/* 399 */       A.setLength(0);
/*     */       int i;
/* 401 */       if ((i = (int)(2700.0D - this.y.statistics.getStatistic(StatisticsType.PT))) < 0) {
/* 402 */         i = 0;
/*     */       }
/* 404 */       A.append("<@icon-clock>");
/* 405 */       A.append(StringFormatter.digestTime(i));
/* 406 */       this.k.setText(Game.i.assetManager.replaceRegionAliasesWithChars((CharSequence)A));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void finalFadeOut() {
/* 411 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 413 */     this.b.getTable().setTouchable(Touchable.disabled);
/* 414 */     this.b.getTable().clearActions();
/* 415 */     this.b.getTable().addAction((Action)Actions.alpha(0.0F, f * 1.0F));
/*     */   }
/*     */   
/*     */   private void c() {
/* 419 */     int i = (this.y._gameUi.sideMenu.isVisible() && !this.y._gameUi.sideMenu.isOffscreen()) ? 1 : 0;
/* 420 */     float f1 = Game.i.uiManager.getScreenWidth() / Game.i.uiManager.getScreenHeight() * Game.i.settingsManager.getScaledViewportHeight() / 1080.0F;
/*     */     
/* 422 */     float f2 = 0.0F;
/* 423 */     if (f1 > 1.7D && i)
/*     */     {
/* 425 */       f2 = -580.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 430 */     i = (i = 31 + (int)f2) * 31 + (this.c ? 1 : 0);
/*     */     
/* 432 */     if (this.u != i) {
/* 433 */       this.u = i;
/*     */       
/* 435 */       if (this.c) {
/* 436 */         this.f.setVisible(true);
/*     */         
/* 438 */         this.r.clearActions();
/* 439 */         this.r.addAction((Action)Actions.parallel(
/* 440 */               (Action)Actions.moveTo(f2, 0.0F, 0.2F, (Interpolation)Interpolation.exp5Out)));
/*     */ 
/*     */         
/* 443 */         this.p.clearActions();
/* 444 */         this.p.addAction((Action)Actions.fadeIn(0.1F));
/*     */         
/* 446 */         this.n.clearActions();
/* 447 */         this.n.addAction((Action)Actions.alpha(0.4F, 0.1F)); return;
/*     */       } 
/* 449 */       this.r.clearActions();
/* 450 */       this.r.addAction((Action)Actions.sequence(
/* 451 */             (Action)Actions.moveTo(f2, 249.0F, 0.2F, (Interpolation)Interpolation.exp5Out), 
/* 452 */             (Action)Actions.run(() -> this.f.setVisible(false))));
/*     */ 
/*     */       
/* 455 */       this.p.clearActions();
/* 456 */       this.p.addAction((Action)Actions.fadeOut(0.1F));
/*     */       
/* 458 */       this.n.clearActions();
/* 459 */       this.n.addAction((Action)Actions.fadeOut(0.1F));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void toggleVisible() {
/* 465 */     this.c = !this.c;
/* 466 */     Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_LIVE_LEADERBOARDS_VISIBLE, this.c ? 1.0D : 0.0D);
/* 467 */     d();
/*     */   }
/*     */   private void d() {
/*     */     try {
/*     */       int i, m;
/* 472 */       if (this.v == this.y.gameState.scoreWithEndlessTimeLimit) {
/*     */         return;
/*     */       }
/* 475 */       if (this.t == null) {
/* 476 */         a.i("canceled rebuildList - no localPlayerPlaceConfig", new Object[0]);
/*     */         
/*     */         return;
/*     */       } 
/* 480 */       long l = this.y.gameState.scoreWithEndlessTimeLimit;
/* 481 */       if (DifficultyMode.isEndless(this.y.gameState.difficultyMode)) {
/* 482 */         if (this.y.gameState.isMaxEndlessReplayTimeReached()) {
/* 483 */           this.l.setVisible(true);
/* 484 */           this.k.setVisible(false);
/*     */         } else {
/* 486 */           this.l.setVisible(false);
/* 487 */           this.k.setVisible(true);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 492 */       this.w.clear();
/*     */ 
/*     */       
/* 495 */       int j = -1; int k;
/* 496 */       for (k = 0; k < this.e.size; ) {
/* 497 */         PlaceConfig placeConfig = ((PlaceConfig[])this.e.items)[k];
/* 498 */         if (l <= placeConfig.score) {
/* 499 */           j = k; k++;
/*     */         } 
/*     */       } 
/* 502 */       if (j == -1) {
/*     */         
/* 504 */         i = 0;
/* 505 */         this.w.add(this.t);
/* 506 */         for (k = 0; k < 4; k++) {
/* 507 */           if (this.e.size > k) {
/* 508 */             this.w.add(((PlaceConfig[])this.e.items)[k]);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/* 513 */         i = (j >= 3 && this.e.size > 4) ? 1 : 0;
/* 514 */         this.w.add(((PlaceConfig[])this.e.items)[0]);
/*     */         
/* 516 */         if (this.e.size > 1) {
/*     */           
/* 518 */           if (j == 0) {
/* 519 */             this.w.add(this.t);
/*     */           }
/*     */ 
/*     */           
/* 523 */           int n = (k = j - 1) + 2;
/* 524 */           if (k <= 0) {
/*     */ 
/*     */             
/* 527 */             n = 3;
/* 528 */             if (3 >= this.e.size)
/*     */             {
/* 530 */               n = this.e.size - 1;
/*     */             }
/* 532 */             for (m = 1; m <= n; m++) {
/* 533 */               this.w.add(((PlaceConfig[])this.e.items)[m]);
/* 534 */               if (j == m) {
/* 535 */                 this.w.add(this.t);
/*     */               }
/*     */             } 
/*     */           } else {
/*     */             
/* 540 */             if (n >= this.e.size)
/*     */             {
/*     */               
/* 543 */               k = (n = this.e.size - 1) - 2;
/*     */             }
/* 545 */             if (k <= 0) k = 1; 
/* 546 */             for (m = k; m <= n; m++) {
/* 547 */               this.w.add(((PlaceConfig[])this.e.items)[m]);
/* 548 */               if (j == m) {
/* 549 */                 this.w.add(this.t);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 555 */           this.w.add(this.t);
/*     */         } 
/*     */       } 
/*     */       
/* 559 */       k = 1;
/* 560 */       if (j >= 0) {
/* 561 */         if (((PlaceConfig[])this.e.items)[j] == null) {
/* 562 */           StringBuilder stringBuilder = new StringBuilder();
/* 563 */           for (m = 0; m < ((PlaceConfig[])this.e.items).length; m++) {
/* 564 */             PlaceConfig placeConfig = ((PlaceConfig[])this.e.items)[m];
/* 565 */             stringBuilder.append("- ").append(String.valueOf(m)).append(": ").append(String.valueOf((placeConfig == null) ? "null" : Integer.valueOf(placeConfig.place))).append("\n");
/*     */           } 
/* 567 */           throw new IllegalArgumentException("'standingBefore' index " + j + " out of " + ((PlaceConfig[])this.e.items).length + " items in array of size " + this.e.size + " is null:\n" + stringBuilder);
/*     */         } 
/*     */ 
/*     */         
/* 571 */         if ((k = (((PlaceConfig[])this.e.items)[j]).place) < 200) {
/* 572 */           k++;
/* 573 */         } else if (k == 200) {
/*     */           
/* 575 */           if (this.e.size > j + 1) {
/* 576 */             PlaceConfig placeConfig = ((PlaceConfig[])this.e.items)[j + 1];
/*     */             try {
/* 578 */               k = placeConfig.place;
/* 579 */             } catch (Exception exception) {
/* 580 */               throw new IllegalArgumentException("failed to get first percentage place after 200: current place is 200, placeConfigs[" + (j + 1) + "] is null", exception);
/*     */             } 
/*     */           } else {
/*     */             
/* 584 */             k = 100000000;
/*     */           } 
/*     */         } else {
/* 587 */           k += 1000000;
/*     */         } 
/*     */       } 
/*     */       
/* 591 */       if (this.c) {
/* 592 */         this.x.clear();
/* 593 */         for (Array.ArrayIterator<Actor> arrayIterator = this.f.getChildren().iterator(); arrayIterator.hasNext(); ) { Actor actor = arrayIterator.next();
/* 594 */           this.x.add(actor); }
/*     */ 
/*     */         
/* 597 */         if (this.t == null) {
/* 598 */           throw new IllegalStateException("localPlayerPlaceConfig is null");
/*     */         }
/* 600 */         if (this.t.listItem == null) {
/* 601 */           throw new IllegalStateException("localPlayerPlaceConfig.listItem is null");
/*     */         }
/* 603 */         this.t.listItem.setup((String)null, l, k, (Drawable)null);
/*     */         
/* 605 */         float f = 150.0F;
/* 606 */         m = 0; byte b;
/* 607 */         for (b = 0; b < this.w.size; b++) {
/* 608 */           if (b == 1 && i) {
/* 609 */             f -= 24.0F;
/*     */           }
/*     */           
/*     */           PlaceConfig placeConfig;
/* 613 */           if ((placeConfig = ((PlaceConfig[])this.w.items)[b]) == this.t) {
/* 614 */             m = 1;
/*     */           }
/*     */           
/* 617 */           if (placeConfig.listItem == null) {
/* 618 */             placeConfig.listItem = (ListItem)this.s.obtain();
/* 619 */             ListItem.a(placeConfig.listItem, placeConfig);
/* 620 */             placeConfig.listItem.setPosition(0.0F, 128.0F);
/* 621 */             placeConfig.listItem.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 622 */             placeConfig.listItem.setup(placeConfig.nickname, placeConfig.score, placeConfig.place, placeConfig.hasPfp ? (Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.loadWebTexture(Config.AVATAR_WEB_TEXTURES_URL + placeConfig.playerId.toLowerCase(Locale.US) + "-32.png")) : null);
/*     */           } 
/* 624 */           if (m && placeConfig != this.t)
/*     */           {
/* 626 */             if (placeConfig.place <= 200) {
/* 627 */               placeConfig.listItem.setup((String)null, -1L, placeConfig.place + 1, (Drawable)null);
/*     */             } else {
/* 629 */               placeConfig.listItem.setup((String)null, -1L, placeConfig.place + 1000000, (Drawable)null);
/*     */             } 
/*     */           }
/*     */           
/* 633 */           placeConfig.listItem.clearActions();
/* 634 */           placeConfig.listItem.addAction((Action)Actions.parallel(
/* 635 */                 (Action)Actions.fadeIn(0.3F), 
/* 636 */                 (Action)Actions.moveTo(0.0F, f, 0.3F)));
/*     */ 
/*     */           
/* 639 */           this.f.addActor((Actor)placeConfig.listItem);
/* 640 */           f -= 32.0F;
/*     */ 
/*     */           
/* 643 */           this.x.removeValue(placeConfig.listItem, true);
/*     */         } 
/*     */ 
/*     */         
/* 647 */         for (b = 0; b < this.x.size; b++) {
/*     */           ListItem listItem;
/* 649 */           if (ListItem.a(listItem = ((ListItem[])this.x.items)[b]) == this.t) {
/* 650 */             throw new IllegalStateException("trying to remove localPlayerPlaceConfig");
/*     */           }
/*     */           
/* 653 */           listItem.clearActions();
/* 654 */           listItem.addAction((Action)Actions.sequence(
/* 655 */                 (Action)Actions.parallel(
/* 656 */                   (Action)Actions.moveTo(0.0F, -32.0F + (i ? false : 24), 0.3F), 
/* 657 */                   (Action)Actions.fadeOut(0.3F)), 
/*     */                 
/* 659 */                 (Action)Actions.run(() -> {
/*     */                     paramListItem.remove();
/*     */                     
/*     */                     (ListItem.a(paramListItem)).listItem = null;
/*     */                     ListItem.b(paramListItem).setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-user"));
/*     */                     this.s.free(paramListItem);
/*     */                   })));
/*     */         } 
/* 667 */         this.x.clear();
/*     */       } 
/*     */       
/* 670 */       if (i) {
/* 671 */         this.o.clearActions();
/* 672 */         this.o.addAction((Action)Actions.fadeIn(0.3F));
/*     */       }
/*     */       else {
/*     */         
/* 676 */         this.o.clearActions();
/* 677 */         this.o.addAction((Action)Actions.fadeOut(0.3F));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 683 */       boolean bool = false;
/*     */       
/* 685 */       if (j == -1) {
/*     */         
/* 687 */         m = 1;
/*     */       } else {
/*     */         PlaceConfig placeConfig;
/*     */         
/* 691 */         if ((placeConfig = ((PlaceConfig[])this.e.items)[j]).place < 200) {
/* 692 */           m = placeConfig.place + 1;
/*     */         } else {
/*     */           long l2;
/* 695 */           bool = true;
/*     */           
/* 697 */           long l1 = placeConfig.score;
/*     */           
/* 699 */           if ((i = (placeConfig.place == 200) ? placeConfig.place : MathUtils.round(placeConfig.place / 1000000.0F * 0.01F * this.d)) < 200) {
/* 700 */             i = 200;
/*     */           }
/*     */           
/*     */           PlaceConfig placeConfig1;
/*     */           
/* 705 */           if ((placeConfig1 = (PlaceConfig)((this.e.size > j + 1) ? ((PlaceConfig[])this.e.items)[j + 1] : null)) == null) {
/*     */             
/* 707 */             l2 = 0L;
/* 708 */             m = this.d;
/*     */           } else {
/* 710 */             l2 = m.score;
/*     */             
/* 712 */             if ((m = MathUtils.round(m.place / 1000000.0F * 0.01F * this.d)) < 201) {
/* 713 */               m = 201;
/*     */             }
/*     */           } 
/*     */           
/*     */           long l3;
/* 718 */           if ((l3 = l1 - l2) < 1L) l3 = 1L; 
/* 719 */           float f = (float)(l - l2) / (float)l3;
/*     */           
/* 721 */           m = MathUtils.round((i - m) * f) + m + 1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 726 */       A.setLength(0);
/* 727 */       if (bool) {
/* 728 */         A.append("~");
/*     */       }
/* 730 */       A.append(StringFormatter.commaSeparatedNumber(m));
/*     */       
/* 732 */       this.h.setText((CharSequence)A);
/*     */       
/* 734 */       this.t.listItem.setZIndex(999);
/*     */       
/* 736 */       if (j == -1) {
/* 737 */         this.j.setText(Game.i.localeManager.i18n.get("leader"));
/* 738 */         this.m.setText("-");
/*     */       } else {
/* 740 */         A.setLength(0);
/* 741 */         A.append(Game.i.localeManager.i18n.get("top_leaderboard_top")).append(' ');
/* 742 */         if (k < 1000000) {
/*     */           float f;
/* 744 */           if ((f = k / (this.d + 1.0F) * 100.0F) < 0.1F) {
/* 745 */             f = 0.1F;
/*     */           }
/*     */           int n;
/* 748 */           if ((n = MathUtils.floor(f * 10.0F)) > 9) {
/* 749 */             A.append(MathUtils.floor(f)).append('%');
/*     */           } else {
/* 751 */             A.append("0.").append(n).append('%');
/*     */           } 
/*     */         } else {
/* 754 */           A.append(k / 1000000).append('%');
/*     */         } 
/* 756 */         this.j.setText((CharSequence)A);
/*     */         
/* 758 */         PlaceConfig placeConfig = ((PlaceConfig[])this.e.items)[j];
/* 759 */         this.m.setText((CharSequence)StringFormatter.commaSeparatedNumber(placeConfig.score - l));
/*     */       } 
/*     */       
/* 762 */       c(); return;
/* 763 */     } catch (Exception exception) {
/* 764 */       a.e("LiveLeaderboard#rebuildList failed", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 770 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */   
/*     */   private class PlaceConfig {
/*     */     public long score;
/*     */     public String nickname;
/*     */     public String playerId;
/*     */     public boolean hasPfp;
/*     */     public int place;
/*     */     public LiveLeaderboard.ListItem listItem;
/*     */     
/*     */     private PlaceConfig(LiveLeaderboard this$0) {}
/*     */   }
/*     */   
/*     */   private class ListItem
/*     */     extends Group {
/*     */     private Image k;
/*     */     private Label l;
/*     */     private Label m;
/*     */     private Label n;
/*     */     private boolean o;
/*     */     private LiveLeaderboard.PlaceConfig p;
/*     */     
/*     */     public ListItem(LiveLeaderboard this$0, boolean param1Boolean) {
/* 794 */       this.o = param1Boolean;
/*     */       
/* 796 */       setTransform(false);
/* 797 */       setTouchable(Touchable.disabled);
/*     */       
/* 799 */       setSize(320.0F, 30.0F);
/*     */       
/*     */       Image image1;
/* 802 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(128.0F, 0.0F);
/* 803 */       image1.setSize(64.0F, 30.0F);
/* 804 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 805 */       addActor((Actor)image1);
/*     */ 
/*     */       
/* 808 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setSize(128.0F, 30.0F);
/* 809 */       image1.setPosition(-32.0F, 0.0F);
/* 810 */       image1.setColor(MaterialColor.LIGHT_BLUE.P800.r, MaterialColor.LIGHT_BLUE.P800.g, MaterialColor.LIGHT_BLUE.P800.b, 0.4F);
/* 811 */       addActor((Actor)image1);
/*     */       
/*     */       Image image2;
/* 814 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setSize(128.0F, 30.0F);
/* 815 */       image2.setPosition(192.0F, 0.0F);
/* 816 */       image2.setColor(MaterialColor.LIGHT_BLUE.P800.r, MaterialColor.LIGHT_BLUE.P800.g, MaterialColor.LIGHT_BLUE.P800.b, 0.4F);
/* 817 */       addActor((Actor)image2);
/*     */       
/* 819 */       this.k = new Image((Drawable)Game.i.assetManager.getDrawable("icon-user"));
/* 820 */       this.k.setPosition(98.0F, 0.0F);
/* 821 */       this.k.setSize(30.0F, 30.0F);
/* 822 */       this.k.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 823 */       addActor((Actor)this.k);
/*     */       
/* 825 */       this.l = (Label)new LimitedWidthLabel("", 24, 21, 200.0F);
/* 826 */       this.l.setAlignment(16);
/* 827 */       this.l.setSize(118.0F, 30.0F);
/* 828 */       this.l.setPosition(-32.0F, 0.0F);
/* 829 */       addActor((Actor)this.l);
/*     */       
/* 831 */       this.m = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 832 */       this.m.setSize(118.0F, 30.0F);
/* 833 */       this.m.setPosition(202.0F, 0.0F);
/* 834 */       addActor((Actor)this.m);
/*     */       
/* 836 */       this.n = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 837 */       this.n.setSize(64.0F, 30.0F);
/* 838 */       this.n.setPosition(128.0F, 0.0F);
/* 839 */       this.n.setAlignment(1);
/* 840 */       addActor((Actor)this.n);
/*     */       
/* 842 */       if (param1Boolean) {
/* 843 */         image1.setPosition(-64.0F, 0.0F);
/* 844 */         image1.setSize(160.0F, 30.0F);
/* 845 */         image1.setColor(MaterialColor.GREEN.P800.r, MaterialColor.GREEN.P800.g, MaterialColor.GREEN.P800.b, 0.78F);
/*     */         
/* 847 */         image2.setSize(160.0F, 30.0F);
/* 848 */         image2.setColor(MaterialColor.GREEN.P800.r, MaterialColor.GREEN.P800.g, MaterialColor.GREEN.P800.b, 0.78F);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setup(String param1String, long param1Long, int param1Int, Drawable param1Drawable) {
/* 853 */       if (param1String != null) {
/* 854 */         this.l.setText(param1String);
/*     */       }
/* 856 */       if (param1Long >= 0L) this.m.setText((CharSequence)StringFormatter.commaSeparatedNumber(param1Long));
/*     */       
/* 858 */       if (param1Int >= 1000000) {
/* 859 */         this.n.setText((param1Int / 1000000) + "%");
/*     */       } else {
/* 861 */         this.n.setTextFromInt(param1Int);
/*     */       } 
/*     */       
/* 864 */       if (this.o) {
/* 865 */         this.n.setColor(Color.WHITE);
/*     */       }
/* 867 */       else if (param1Int <= 200) {
/* 868 */         this.n.setColor(MaterialColor.AMBER.P300);
/*     */       } else {
/* 870 */         this.n.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */       } 
/*     */ 
/*     */       
/* 874 */       if (param1Drawable != null) {
/* 875 */         this.k.setDrawable(param1Drawable);
/* 876 */         this.k.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\LiveLeaderboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */