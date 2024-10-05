/*      */ package com.prineside.tdi2.screens;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.global.ScreenResize;
/*      */ import com.prineside.tdi2.managers.AuthManager;
/*      */ import com.prineside.tdi2.managers.DailyQuestManager;
/*      */ import com.prineside.tdi2.managers.MapManager;
/*      */ import com.prineside.tdi2.managers.MessageManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.FancyButton;
/*      */ import com.prineside.tdi2.ui.actors.HorizontalSlider;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.actors.TableButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.ui.components.RatingForm;
/*      */ import com.prineside.tdi2.ui.shared.DailyLootOverlay;
/*      */ import com.prineside.tdi2.ui.shared.DailyQuestOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.DifficultyModeOverlay;
/*      */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*      */ import com.prineside.tdi2.ui.shared.MainMenuUiScene;
/*      */ import com.prineside.tdi2.ui.shared.MessagesOverlay;
/*      */ import com.prineside.tdi2.ui.shared.MusicListOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.ProfileSummary;
/*      */ import com.prineside.tdi2.ui.shared.ResourcesAndMoney;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.ui.shared.WebBrowser;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.QuadDrawableStack;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ 
/*      */ public class MainMenuScreen
/*      */   extends Screen
/*      */ {
/*   77 */   private static final TLog a = TLog.forClass(MainMenuScreen.class);
/*      */ 
/*      */   
/*      */   public static final String TT_FIRST_LAUNCH_LEVEL_SELECT = "MainMenuScreen.firstLaunchHint";
/*      */ 
/*      */   
/*      */   public static final String TT_ENDLESS_DIFFICULTY_BUTTON = "MainMenu.endlessModeHint";
/*      */   
/*   85 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "MainMenuScreen trophies");
/*   86 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "MainMenuScreen main");
/*   87 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 103, "MainMenuScreen launchFade");
/*      */   
/*      */   @Null
/*      */   private UiManager.UiLayer e;
/*      */   
/*      */   private ComplexButton f;
/*      */   
/*      */   private Group g;
/*      */   
/*      */   private Table h;
/*      */   
/*      */   private Label i;
/*      */   
/*      */   private Label j;
/*      */   
/*      */   private ComplexButton k;
/*      */   
/*      */   private ComplexButton l;
/*      */   
/*      */   private Image m;
/*      */   
/*      */   private Label n;
/*      */   private Image o;
/*      */   private Image p;
/*      */   private Label q;
/*      */   private ComplexButton r;
/*      */   private Label s;
/*      */   private Label t;
/*      */   private float u;
/*      */   private DailyQuestManager.DailyQuestLevel v;
/*      */   private Table w;
/*  118 */   private int x = 0;
/*  119 */   private final Vector2 y = new Vector2();
/*      */   
/*  121 */   private final MessageManager.MessageManagerListener z = (MessageManager.MessageManagerListener)new MessageManager.MessageManagerListener.Adapter(this)
/*      */     {
/*      */       public void messagesUpdated() {
/*  124 */         Threads.i().runOnMainThread(() -> MainMenuScreen.a(param1MainMenuScreen));
/*      */       }
/*      */     };
/*      */   
/*      */   private final Listener<ScreenResize> A = paramScreenResize -> b();
/*      */   
/*      */   private void a() {
/*  131 */     this.b.getTable().clearChildren();
/*      */     
/*  133 */     MainMenuUiScene.i().rebuildIfNeeded();
/*      */     
/*  135 */     this.b.getTable().clear();
/*  136 */     this.b.getTable().add(MainMenuUiScene.i().getContents()).expand().fill().width(Game.i.uiManager.stage.getWidth());
/*      */   }
/*      */   
/*      */   public MainMenuScreen() {
/*  140 */     this(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MainMenuScreen(boolean paramBoolean) {
/*  210 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/*      */       
/*  212 */       a.i("app is modified", new Object[0]);
/*      */     } else {
/*  214 */       a.i("app is not modified", new Object[0]);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  233 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*  234 */     Game.i.researchManager.updateAndValidateStarBranch();
/*      */ 
/*      */     
/*  237 */     Game.i.uiManager.hideAllComponents();
/*  238 */     Game.i.uiManager.setAsInputHandler();
/*      */     
/*  240 */     ResourcesAndMoney.i()
/*  241 */       .setVisible(true);
/*      */     
/*  243 */     InventoryOverlay.i()
/*  244 */       .hideWithToggleButton(true);
/*      */     
/*  246 */     ProfileSummary.i()
/*  247 */       .setVisibleClickEnabled(true, true);
/*      */     
/*  249 */     b();
/*      */ 
/*      */     
/*  252 */     Game.i.progressManager.givePendingBonuses();
/*      */ 
/*      */     
/*  255 */     Game.i.progressManager.checkSpecialTrophiesGiven();
/*  256 */     Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */     
/*  258 */     Game.EVENTS.getListeners(ScreenResize.class).add(this.A);
/*      */     
/*  260 */     if (Game.getTimestampSeconds() - Game.i.authManager.lastStateUpdateTimestamp > 30) {
/*  261 */       Game.i.authManager.loadStateFromServer(null, null);
/*      */     }
/*      */     
/*  264 */     Game.i.achievementManager.updateGlobal();
/*      */     
/*  266 */     Timer.schedule(new Timer.Task(this)
/*      */         {
/*      */           public void run() {
/*  269 */             Game.i.progressManager.giveDoubleGainIfNecessary();
/*      */           }
/*      */         },  3.0F);
/*      */ 
/*      */     
/*  274 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.PRT) > 7200.0D)
/*      */     {
/*  276 */       if (Game.i.authManager.getProgressOwnerPlayerId() == null)
/*      */       {
/*  278 */         if (!TooltipsOverlay.i().isTagShown("MainMenu.signInSuggestionWithProgress")) {
/*  279 */           TooltipsOverlay.i().showText("MainMenu.signInSuggestionWithProgress", (Actor)(ProfileSummary.i()).hintLabel, Game.i.localeManager.i18n.get("tooltip_has_progress_sign_in_suggestion"), (ProfileSummary.i()).uiLayer.mainUiLayer, (ProfileSummary.i()).uiLayer.zIndex + 1, 4);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     this.d.getTable().setTouchable(Touchable.disabled);
/*  288 */     if (paramBoolean) {
/*  289 */       this.d.getTable().setVisible(true);
/*      */       Image image;
/*  291 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  292 */       this.d.getTable().add((Actor)image).grow();
/*      */       
/*  294 */       this.d.getTable().addAction((Action)Actions.fadeOut(0.8F)); return;
/*      */     } 
/*  296 */     this.d.getTable().setVisible(false);
/*      */   }
/*      */   
/*      */   private void b() {
/*      */     String str2;
/*  301 */     long l = Game.getTimestampMillis();
/*      */ 
/*      */     
/*      */     Table table1;
/*      */     
/*  306 */     (table1 = this.c.getTable()).clearChildren(true);
/*      */ 
/*      */     
/*  309 */     table1.add().size(300.0F, 128.0F).colspan(3).top().left().row();
/*  310 */     table1.add().expand().fill().colspan(3).row();
/*      */ 
/*      */     
/*  313 */     this.w = new Table();
/*  314 */     this.w.setName("MM-layout-bottomLeft");
/*  315 */     table1.add((Actor)this.w).bottom().left().expandX();
/*      */ 
/*      */     
/*  318 */     this.l = new ComplexButton(Game.i.localeManager.i18n.get("mailbox"), Game.i.assetManager.getLabelStyle(24), () -> MessagesOverlay.i().show());
/*  319 */     this.l.setName("main_menu_messages_button");
/*  320 */     this.l.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-letter"), 21.0F, 14.0F, 64.0F, 64.0F);
/*  321 */     this.l.setLabel(109.0F, 50.0F, 100.0F, 20.0F, 8);
/*      */     
/*  323 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("icon-letter"));
/*  324 */     this.m.setPosition(21.0F, 14.0F);
/*  325 */     this.m.setSize(64.0F, 64.0F);
/*  326 */     this.m.setOrigin(32.0F, 32.0F);
/*  327 */     this.l.addActor((Actor)this.m);
/*      */     
/*  329 */     this.n = new Label("No new messages", Game.i.assetManager.getLabelStyle(21));
/*  330 */     this.n.setPosition(109.0F, 20.0F);
/*  331 */     this.n.setSize(100.0F, 20.0F);
/*  332 */     this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  333 */     this.l.addActor((Actor)this.n);
/*      */     
/*  335 */     this.o = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"));
/*  336 */     this.o.setPosition(72.0F, 52.0F);
/*  337 */     this.o.setSize(21.5F, 24.5F);
/*  338 */     this.o.setVisible(false);
/*  339 */     this.l.addActor((Actor)this.o);
/*      */     
/*  341 */     this.p = new Image((Drawable)Game.i.assetManager.getDrawable("circle"));
/*  342 */     this.p.setPosition(65.0F, 6.0F);
/*  343 */     this.p.setSize(28.0F, 28.0F);
/*  344 */     this.p.setColor(new Color(18357120));
/*  345 */     this.p.setVisible(false);
/*  346 */     this.l.addActor((Actor)this.p);
/*      */     
/*  348 */     this.q = new Label("0", Game.i.assetManager.getLabelStyle(18));
/*  349 */     this.q.setPosition(65.0F, 6.0F);
/*  350 */     this.q.setSize(28.0F, 28.0F);
/*  351 */     this.q.setAlignment(1);
/*  352 */     this.l.addActor((Actor)this.q);
/*      */     
/*  354 */     this.w.add((Actor)this.l).size(300.0F, 92.0F).padBottom(11.0F).padLeft(36.0F).left().row();
/*      */ 
/*      */     
/*  357 */     this.k = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> Game.i.authManager.getNews(()));
/*      */ 
/*      */ 
/*      */     
/*  361 */     this.k.setName("main_menu_news_button");
/*  362 */     this.k.setBackground((Drawable)new QuadDrawable(new QuadActor(new Color[] { new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F) }new float[] { 4.0F, 0.0F, 0.0F, 92.0F, 192.0F, 88.0F, 192.0F, 0.0F })), 0.0F, 0.0F, 192.0F, 92.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  376 */     this.k.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800
/*  377 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P800
/*  378 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_BLUE.P800
/*  379 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */ 
/*      */     
/*  382 */     this.k.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-book-opened"), 21.0F, 14.0F, 64.0F, 64.0F);
/*  383 */     this.k.setLabel(109.0F, 50.0F, 100.0F, 20.0F, 8);
/*      */     
/*  385 */     this.t = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  386 */     this.t.setPosition(109.0F, 20.0F);
/*  387 */     this.t.setSize(100.0F, 20.0F);
/*  388 */     this.t.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  389 */     this.k.addActor((Actor)this.t);
/*      */     
/*  391 */     this.w.add((Actor)this.k).size(300.0F, 92.0F).padBottom(11.0F).padLeft(36.0F).left().row();
/*      */ 
/*      */     
/*  394 */     this.r = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_SEASONAL_LEADERBOARD_URL, null);
/*      */           WebBrowser.i().setVisible(true);
/*      */         });
/*  398 */     this.r.setName("main_menu_season_button");
/*  399 */     this.r.setBackground((Drawable)new QuadDrawable(new QuadActor(new Color[] { new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F) }new float[] { 0.0F, 0.0F, 4.0F, 92.0F, 192.0F, 92.0F, 192.0F, 4.0F })), 0.0F, 0.0F, 192.0F, 92.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  413 */     this.r.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800
/*  414 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P800
/*  415 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_BLUE.P800
/*  416 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */ 
/*      */     
/*  419 */     this.r.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-leaf"), 21.0F, 14.0F, 64.0F, 64.0F);
/*  420 */     this.r.setLabel(109.0F, 50.0F, 100.0F, 20.0F, 8);
/*      */     
/*  422 */     this.s = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  423 */     this.s.setPosition(109.0F, 20.0F);
/*  424 */     this.s.setSize(100.0F, 20.0F);
/*  425 */     this.s.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  426 */     this.r.addActor((Actor)this.s);
/*  427 */     this.w.add((Actor)this.r).size(300.0F, 92.0F).padBottom(64.0F).padLeft(36.0F).left().row();
/*      */     
/*  429 */     d();
/*      */     
/*  431 */     Table table2 = new Table();
/*  432 */     this.w.add((Actor)table2).padLeft(36.0F).padBottom(36.0F);
/*      */     
/*      */     MenuButton menuButton4;
/*      */     
/*  436 */     (menuButton4 = new MenuButton(false, (Drawable)Game.i.assetManager.getDrawable("icon-music-player"), Game.i.localeManager.i18n.get("mainMenu_musicPlayerButton"), () -> MusicListOverlay.i().show())).setName("main_menu_music_player_button");
/*  437 */     table2.add((Actor)menuButton4).size(134.0F);
/*      */ 
/*      */     
/*  440 */     if (!Game.i.ratingManager.shouldRateButtonBeVisible()) {
/*  441 */       table2.add();
/*  442 */       table2.add();
/*      */     } else {
/*  444 */       CharSequence charSequence1 = StringFormatter.fitToWidth(Game.i.localeManager.i18n.get("rate_this_game"), 256.0F, (BitmapFont)Game.i.assetManager.getFont(24), ".");
/*      */       ComplexButton complexButton;
/*  446 */       (complexButton = new ComplexButton(charSequence1, Game.i.assetManager.getLabelStyle(24), () -> RatingForm.i().showRatePrompt())).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-star"), 102.0F, 46.0F, 64.0F, 64.0F);
/*  447 */       complexButton.setLabel(0.0F, 19.0F, 268.0F, 18.0F, 1);
/*  448 */       complexButton.setBackground((Drawable)new QuadDrawableStack(new Array((Object[])new QuadDrawableStack.QuadActorConfig[] { new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 4.0F, 4.0F, 124.0F, 131.0F, 126.0F, 131.0F, 0.0F }), 0.0F, 0.0F, 131.0F, 126.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 126.0F, 131.0F, 128.0F, 127.0F, 4.0F }), 131.0F, 0.0F, 131.0F, 128.0F) })), 3.0F, 3.0F, 262.0F, 128.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  462 */       complexButton.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800
/*  463 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_GREEN.P800
/*  464 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_GREEN.P800
/*  465 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */ 
/*      */       
/*  468 */       table2.add((Actor)complexButton).size(268.0F, 134.0F).colspan(2).row();
/*      */     } 
/*      */     
/*  471 */     table2.row();
/*      */ 
/*      */     
/*  474 */     menuButton4 = new MenuButton(true, (Drawable)Game.i.assetManager.getDrawable("icon-tools"), Game.i.localeManager.i18n.get("mainMenu_settingsButton"), () -> Game.i.screenManager.goToSettingsScreen());
/*  475 */     table2.add((Actor)menuButton4).size(134.0F);
/*      */ 
/*      */ 
/*      */     
/*  479 */     String str1 = Game.i.localeManager.i18n.get("mainMenu_handbookButton");
/*  480 */     MenuButton menuButton3 = new MenuButton(false, (Drawable)Game.i.assetManager.getDrawable("icon-book-closed"), str1, () -> Game.i.actionResolver.openHandbook());
/*  481 */     table2.add((Actor)menuButton3).size(134.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  676 */     menuButton3 = new MenuButton(true, (Drawable)Game.i.assetManager.getDrawable("icon-info-square"), Game.i.localeManager.i18n.get("mainMenu_aboutButton"), () -> Game.i.screenManager.goToAboutScreen());
/*  677 */     table2.add((Actor)menuButton3).size(134.0F);
/*      */ 
/*      */ 
/*      */     
/*  681 */     (table2 = new Table()).setName("MM-layout-bottomCenter");
/*  682 */     table1.add((Actor)table2).width(342.0F).bottom();
/*      */     
/*  684 */     table2.add().expand().fill().row();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  703 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.ENDLESS_I) {
/*      */       int k;
/*      */       
/*  706 */       if ((k = MathUtils.round((float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.ENDLESS_MODE_DIFFICULTY) * 100.0F)) != 150) {
/*      */         Group group;
/*  708 */         (group = new Group()).setTransform(false);
/*  709 */         group.setSize(342.0F, 100.0F);
/*  710 */         table2.add((Actor)group).bottom().center().padBottom(20.0F).size(342.0F, 120.0F).row();
/*      */         
/*      */         Label label1;
/*  713 */         (label1 = new Label(Game.i.localeManager.i18n.get("difficulty") + ": " + Game.i.progressManager.getDifficultyModeDiffMultiplier(DifficultyMode.ENDLESS_I) + "%", Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/*  714 */         label1.setPosition(2.0F, 70.0F);
/*  715 */         label1.setSize(342.0F, 20.0F);
/*  716 */         label1.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  717 */         group.addActor((Actor)label1);
/*      */         
/*      */         Label label2;
/*  720 */         (label2 = new Label(Game.i.localeManager.i18n.get("difficulty") + ": " + Game.i.progressManager.getDifficultyModeDiffMultiplier(DifficultyMode.ENDLESS_I) + "%", Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/*  721 */         label2.setPosition(0.0F, 72.0F);
/*  722 */         label2.setSize(342.0F, 20.0F);
/*  723 */         group.addActor((Actor)label2);
/*      */         
/*      */         Label label3;
/*  726 */         (label3 = new Label((new StringBuilder("150")).toString(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  727 */         label3.setPosition(4.0F, 36.0F);
/*  728 */         label3.setSize(100.0F, 20.0F);
/*  729 */         group.addActor((Actor)label3);
/*      */ 
/*      */         
/*  732 */         (label3 = new Label(k, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  733 */         label3.setPosition(238.0F, 36.0F);
/*  734 */         label3.setSize(100.0F, 20.0F);
/*  735 */         label3.setAlignment(16);
/*  736 */         group.addActor((Actor)label3);
/*      */ 
/*      */ 
/*      */         
/*      */         HorizontalSlider horizontalSlider;
/*      */ 
/*      */ 
/*      */         
/*  744 */         (horizontalSlider = new HorizontalSlider(342.0F, (Game.i.progressManager.getDifficultyModeDiffMultiplier(DifficultyMode.ENDLESS_I) * 0.01F), 1.5D, Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.ENDLESS_MODE_DIFFICULTY), paramDouble -> { int i = MathUtils.round((float)paramDouble.doubleValue() * 20.0F) * 5; paramLabel1.setText(Game.i.localeManager.i18n.get("difficulty") + ": " + i + "%"); paramLabel2.setText((CharSequence)paramLabel1.getText()); Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.ENDLESS_MODE_DIFFICULTY, i / 100.0D); })).setNotifyOnDrag(true);
/*  745 */         horizontalSlider.setSize(342.0F, 80.0F);
/*  746 */         group.addActor((Actor)horizontalSlider);
/*      */       } 
/*      */     } 
/*      */     
/*      */     ComplexButton complexButton2;
/*  751 */     (complexButton2 = new ComplexButton(Game.i.progressManager.getDifficultyName(Game.i.progressManager.getDifficultyMode()).toUpperCase(), Game.i.assetManager.getLabelStyle(36), () -> DifficultyModeOverlay.i().setVisible(true))).setLabel(0.0F, 53.0F, 342.0F, 27.0F, 1);
/*  752 */     table2.add((Actor)complexButton2).bottom().center().padBottom(40.0F).size(342.0F, 120.0F);
/*      */     
/*  754 */     if (Game.i.progressManager.difficultyModeAvailable(DifficultyMode.ENDLESS_I) && !TooltipsOverlay.i().isTagShown("MainMenu.endlessModeHint")) {
/*  755 */       TooltipsOverlay.i().showText("MainMenu.endlessModeHint", (Actor)complexButton2, Game.i.localeManager.i18n.get("tooltip_difficulty_mode_button"), this.c.mainUiLayer, this.c.zIndex + 1, 2);
/*      */     }
/*      */     
/*      */     Label label;
/*  759 */     (label = new Label(Game.i.localeManager.i18n.get("game_mode"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  760 */     label.setPosition(0.0F, 24.0F);
/*  761 */     label.setSize(342.0F, 21.0F);
/*  762 */     label.setAlignment(1);
/*  763 */     complexButton2.addActor((Actor)label);
/*      */     
/*  765 */     switch (null.a[Game.i.progressManager.getDifficultyMode().ordinal()]) {
/*      */       case 1:
/*  767 */         complexButton2.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800
/*  768 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_GREEN.P800
/*  769 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_GREEN.P800
/*  770 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), Color.WHITE);
/*      */ 
/*      */         
/*  773 */         complexButton2.setBackground((Drawable)new QuadDrawableStack(new Array((Object[])new QuadDrawableStack.QuadActorConfig[] { new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 12.0F, 0.0F, 117.0F, 131.0F, 105.0F, 131.0F, 0.0F }), 0.0F, 0.0F, 131.0F, 117.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 105.0F, 131.0F, 117.0F, 127.0F, 12.0F }), 131.0F, 0.0F, 131.0F, 117.0F) })), 40.0F, 0.0F, 262.0F, 117.0F);
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/*  791 */         complexButton2.setBackgroundColors(MaterialColor.ORANGE.P800
/*  792 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.ORANGE.P800
/*  793 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.ORANGE.P800
/*  794 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), Color.WHITE);
/*      */ 
/*      */         
/*  797 */         complexButton2.setBackground((Drawable)new QuadDrawableStack(new Array((Object[])new QuadDrawableStack.QuadActorConfig[] { new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 2.0F, 0.0F, 106.0F, 15.0F, 105.0F, 19.0F, 0.0F }), 0.0F, 14.0F, 19.0F, 106.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 2.0F, 0.0F, 106.0F, 15.0F, 105.0F, 19.0F, 0.0F }), 20.0F, 12.0F, 19.0F, 106.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 12.0F, 0.0F, 117.0F, 131.0F, 105.0F, 131.0F, 0.0F }), 40.0F, 0.0F, 131.0F, 117.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 105.0F, 131.0F, 117.0F, 127.0F, 12.0F }), 171.0F, 0.0F, 131.0F, 117.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 4.0F, 105.0F, 19.0F, 106.0F, 15.0F, 2.0F }), 303.0F, 12.0F, 19.0F, 106.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 4.0F, 105.0F, 19.0F, 106.0F, 15.0F, 2.0F }), 323.0F, 14.0F, 19.0F, 106.0F) })), 0.0F, 0.0F, 342.0F, 120.0F);
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/*  841 */         complexButton2.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800
/*  842 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P800
/*  843 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_BLUE.P800
/*  844 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), Color.WHITE);
/*      */ 
/*      */         
/*  847 */         complexButton2.setBackground((Drawable)new QuadDrawableStack(new Array((Object[])new QuadDrawableStack.QuadActorConfig[] { new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 2.0F, 0.0F, 106.0F, 15.0F, 105.0F, 19.0F, 0.0F }), 0.0F, 12.0F, 19.0F, 106.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 4.0F, 12.0F, 0.0F, 117.0F, 131.0F, 105.0F, 131.0F, 0.0F }), 20.0F, 0.0F, 131.0F, 117.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 105.0F, 131.0F, 117.0F, 127.0F, 12.0F }), 151.0F, 0.0F, 131.0F, 117.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 4.0F, 105.0F, 19.0F, 106.0F, 15.0F, 2.0F }), 283.0F, 12.0F, 19.0F, 106.0F) })), 20.0F, 0.0F, 302.0F, 118.0F);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Table table3;
/*  882 */     (table3 = new Table()).setName("MM-layout-bottomRight");
/*  883 */     table1.add((Actor)table3).bottom().right().expandX();
/*      */ 
/*      */     
/*  886 */     this.f = new ComplexButton(Game.i.localeManager.i18n.get("daily_quest"), Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           if (this.v != null) {
/*      */             DailyQuestOverlay.i().show(this.v);
/*      */           }
/*      */         });
/*  891 */     this.f.setBackground((Drawable)new QuadDrawable(new QuadActor(new Color[] { new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F) }new float[] { 0.0F, 0.0F, 0.0F, 88.0F, 192.0F, 92.0F, 188.0F, 0.0F })), 108.0F, 0.0F, 192.0F, 92.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  905 */     this.f.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800
/*  906 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_GREEN.P800
/*  907 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_GREEN.P800
/*  908 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */ 
/*      */     
/*  911 */     this.f.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-clock"), 214.0F, 14.0F, 64.0F, 64.0F);
/*  912 */     this.f.setLabel(90.0F, 50.0F, 100.0F, 20.0F, 16);
/*      */     
/*  914 */     this.h = new Table();
/*  915 */     this.h.setSize(400.0F, 20.0F);
/*  916 */     this.h.setPosition(-210.0F, 20.0F);
/*  917 */     this.f.addActor((Actor)this.h);
/*      */     
/*  919 */     this.g = new Group();
/*  920 */     this.g.setTransform(false);
/*  921 */     this.g.setSize(300.0F, 92.0F);
/*  922 */     this.f.addActor((Actor)this.g);
/*      */     
/*  924 */     e();
/*      */     
/*  926 */     table3.add((Actor)this.f).size(300.0F, 92.0F).padBottom(10.0F).padRight(36.0F).right().row();
/*      */     
/*      */     ComplexButton complexButton3;
/*      */     
/*  930 */     (complexButton3 = new ComplexButton(Game.i.localeManager.i18n.get("daily_loot"), Game.i.assetManager.getLabelStyle(24), () -> DailyLootOverlay.i().show())).setBackground((Drawable)new QuadDrawable(new QuadActor(new Color[] { new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 0.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F), new Color(1.0F, 1.0F, 1.0F, 1.0F) }new float[] { 0.0F, 4.0F, 0.0F, 92.0F, 188.0F, 92.0F, 192.0F, 0.0F })), 108.0F, 0.0F, 192.0F, 92.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  944 */     complexButton3.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800
/*  945 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_GREEN.P800
/*  946 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_GREEN.P800
/*  947 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */ 
/*      */     
/*  950 */     complexButton3.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-calendar"), 214.0F, 14.0F, 64.0F, 64.0F);
/*  951 */     complexButton3.setLabel(90.0F, 50.0F, 100.0F, 20.0F, 16);
/*      */     
/*      */     String str3;
/*  954 */     if ((str3 = Game.i.dailyQuestManager.getDailyLootCurrentQuest()).equals("_resetQuests")) {
/*      */       
/*  956 */       str2 = Game.i.localeManager.i18n.get("daily_loot_quest_reset_quests");
/*      */     } else {
/*      */       BasicLevelQuestConfig basicLevelQuestConfig;
/*      */       
/*  960 */       if ((basicLevelQuestConfig = Game.i.basicLevelManager.getRegularQuestById(str3)) == null) {
/*  961 */         str2 = "Quest " + str3 + " not found";
/*      */       } else {
/*  963 */         str2 = basicLevelQuestConfig.getTitle(false, true) + " - " + Game.i.localeManager.i18n.get("level") + " " + basicLevelQuestConfig.level.name;
/*      */       } 
/*      */     } 
/*      */     
/*  967 */     (label = new Label(str2, Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 20.0F);
/*  968 */     label.setPosition(90.0F, 20.0F);
/*  969 */     label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  970 */     label.setAlignment(16);
/*  971 */     complexButton3.addActor((Actor)label);
/*      */     
/*  973 */     if (Game.i.dailyQuestManager.isTodayDailyLootQuestCompleted()) {
/*      */       Image image;
/*  975 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("main-menu-check-outline"))).setSize(48.0F, 48.0F);
/*  976 */       image.setPosition(248.0F, 14.0F);
/*  977 */       complexButton3.addActor((Actor)image);
/*      */     } else {
/*      */       Image image;
/*  980 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setSize(32.25F, 36.75F);
/*  981 */       image.setPosition(273.0F, 63.0F);
/*  982 */       complexButton3.addActor((Actor)image);
/*      */       
/*  984 */       image.addAction((Action)Actions.forever((Action)Actions.sequence(
/*  985 */               (Action)Actions.alpha(0.8F, 0.5F), 
/*  986 */               (Action)Actions.alpha(1.0F, 0.5F))));
/*      */     } 
/*      */ 
/*      */     
/*  990 */     table3.add((Actor)complexButton3).size(300.0F, 92.0F).padBottom(64.0F).padRight(36.0F).right().row();
/*      */     
/*  992 */     table1 = new Table();
/*  993 */     table3.add((Actor)table1).padRight(36.0F).padBottom(36.0F);
/*      */ 
/*      */     
/*  996 */     MenuButton menuButton2 = new MenuButton(false, (Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), Game.i.localeManager.i18n.get("mainMenu_continueButton"), () -> {
/*      */           GameStateSystem.ContinueGameStatus continueGameStatus;
/*      */           
/*      */           if (GameStateSystem.savedGameExists() && (continueGameStatus = GameStateSystem.continueSavedGame()) != GameStateSystem.ContinueGameStatus.SUCCESS) {
/*      */             GameStateSystem.deleteSavedGame();
/*      */             
/*      */             Game.i.screenManager.goToMainMenu();
/*      */             
/*      */             String str = "continue_game_status_" + continueGameStatus.name();
/*      */             Dialog.i().showAlert(Game.i.localeManager.i18n.get(str));
/*      */           } 
/*      */         });
/* 1008 */     ReplayManager.ReplayHeader replayHeader = GameStateSystem.getSavedGameInfo();
/* 1009 */     if (!GameStateSystem.savedGameExists() || replayHeader == null) {
/*      */       
/* 1011 */       menuButton2.setEnabled(false);
/*      */     } else {
/* 1013 */       menuButton2.setEnabled(true);
/* 1014 */       menuButton2.flavor = 1;
/* 1015 */       menuButton2.setupBackgroundDrawables();
/*      */       
/*      */       try {
/*      */         TextureRegion textureRegion;
/* 1019 */         label = null;
/* 1020 */         if (replayHeader.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 1021 */           textureRegion = Game.i.basicLevelManager.getLevel(replayHeader.basicLevelName).getPreview();
/* 1022 */         } else if (replayHeader.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/* 1023 */           textureRegion = (Game.i.userMapManager.getUserMap(replayHeader.userMapId)).map.getPreview().getTextureRegion();
/*      */         } 
/* 1025 */         if (textureRegion != null) {
/*      */           Group group;
/*      */ 
/*      */ 
/*      */           
/* 1030 */           (group = new Group()).setTransform(false);
/* 1031 */           group.setSize(174.0F, 128.0F);
/* 1032 */           group.setPosition(-184.0F, 2.0F);
/* 1033 */           menuButton2.addActor((Actor)group);
/*      */           
/*      */           Image image2;
/* 1036 */           (image2 = new Image((Drawable)Game.i.assetManager.getQuad("ui.mainMenu.continueButtonLevelInfo"))).setSize(174.0F, 128.0F);
/* 1037 */           group.addActor((Actor)image2);
/*      */           
/*      */           Image image1;
/* 1040 */           (image1 = new Image(textureRegion)).setPosition(9.0F, 6.0F);
/* 1041 */           image1.setSize(155.0F, 115.0F);
/* 1042 */           group.addActor((Actor)image1);
/*      */           
/*      */           Image image3;
/* 1045 */           (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-corner-top-right"))).setSize(139.2F, 102.4F);
/* 1046 */           image3.setColor(Config.BACKGROUND_COLOR.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/* 1047 */           image3.setPosition(image1.getX() - 1.0F, image1.getY() - 1.0F);
/* 1048 */           group.addActor((Actor)image3);
/*      */           
/* 1050 */           Label label1 = new Label("", Game.i.assetManager.getLabelStyle(18));
/* 1051 */           if (replayHeader.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 1052 */             label1.setText(replayHeader.basicLevelName);
/*      */           } else {
/* 1054 */             label1.setText((Game.i.userMapManager.getUserMap(replayHeader.userMapId)).name);
/*      */           } 
/* 1056 */           label1.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 1057 */           label1.setPosition(10.0F, 52.0F);
/* 1058 */           group.addActor((Actor)label1);
/*      */           
/* 1060 */           Label label2 = new Label("", Game.i.assetManager.getLabelStyle(18));
/* 1061 */           if (replayHeader.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 1062 */             label2.setText(Game.i.localeManager.i18n.get("basic_level"));
/*      */           } else {
/* 1064 */             label2.setText(Game.i.localeManager.i18n.get("custom_map"));
/*      */           } 
/* 1066 */           label2.setColor(1.0F, 1.0F, 1.0F, 0.78F);
/* 1067 */           label2.setPosition(10.0F, 32.0F);
/* 1068 */           group.addActor((Actor)label2);
/*      */ 
/*      */           
/* 1071 */           (label1 = new Label("", Game.i.assetManager.getLabelStyle(18))).setText(Game.i.progressManager.getDifficultyName(replayHeader.difficultyMode));
/* 1072 */           label1.setColor(Game.i.progressManager.getDifficultyModeColor(replayHeader.difficultyMode));
/* 1073 */           label1.setPosition(10.0F, 12.0F);
/* 1074 */           group.addActor((Actor)label1);
/*      */ 
/*      */           
/* 1077 */           (label1 = new Label("", Game.i.assetManager.getLabelStyle(18))).setText((CharSequence)StringFormatter.digestTime((int)replayHeader.playRealTime));
/* 1078 */           label1.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 1079 */           label1.setPosition(10.0F, 100.0F);
/* 1080 */           label1.setSize(154.0F, 15.0F);
/* 1081 */           label1.setAlignment(16);
/* 1082 */           group.addActor((Actor)label1);
/*      */         } 
/* 1084 */       } catch (Exception exception) {
/* 1085 */         a.e("failed to show continued game info", new Object[] { exception });
/*      */       } 
/*      */     } 
/* 1088 */     table1.add((Actor)menuButton2).size(134.0F);
/*      */ 
/*      */     
/* 1091 */     CharSequence charSequence = StringFormatter.fitToWidth(Game.i.localeManager.i18n.get("mainMenu_newGameButton"), 256.0F, (BitmapFont)Game.i.assetManager.getFont(24), ".");
/*      */     ComplexButton complexButton1;
/* 1093 */     (complexButton1 = new ComplexButton(charSequence, Game.i.assetManager.getLabelStyle(24), () -> Game.i.screenManager.goToLevelSelectScreen())).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-joystick"), 102.0F, 46.0F, 64.0F, 64.0F);
/* 1094 */     complexButton1.setLabel(0.0F, 19.0F, 268.0F, 18.0F, 1);
/* 1095 */     complexButton1.setBackground((Drawable)new QuadDrawableStack(new Array((Object[])new QuadDrawableStack.QuadActorConfig[] { new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 4.0F, 4.0F, 124.0F, 131.0F, 126.0F, 131.0F, 0.0F }), 0.0F, 0.0F, 131.0F, 126.0F), new QuadDrawableStack.QuadActorConfig(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 126.0F, 131.0F, 128.0F, 127.0F, 4.0F }), 131.0F, 0.0F, 131.0F, 128.0F) })), 3.0F, 3.0F, 262.0F, 128.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1109 */     if (!GameStateSystem.savedGameExists()) {
/* 1110 */       complexButton1.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800
/* 1111 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_GREEN.P800
/* 1112 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_GREEN.P800
/* 1113 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */     }
/*      */     else {
/*      */       
/* 1117 */       complexButton1.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800
/* 1118 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P800
/* 1119 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), MaterialColor.LIGHT_BLUE.P800
/* 1120 */           .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), new Color(741092556));
/*      */     } 
/*      */ 
/*      */     
/* 1124 */     complexButton1.setName("main_menu_new_game_button");
/* 1125 */     table1.add((Actor)complexButton1).size(268.0F, 134.0F).colspan(2).row();
/*      */     
/* 1127 */     if (!Game.i.progressManager.existsAnyProgress() && !TooltipsOverlay.i().isTagShown("MainMenuScreen.firstLaunchHint"))
/*      */     {
/* 1129 */       TooltipsOverlay.i().showText("MainMenuScreen.firstLaunchHint", (Actor)complexButton1, Game.i.localeManager.i18n.get("tooltip_first_start_button_highlight"), this.c.mainUiLayer, this.c.zIndex + 1, 2);
/*      */     }
/*      */ 
/*      */     
/* 1133 */     MenuButton menuButton1 = new MenuButton(true, (Drawable)Game.i.assetManager.getDrawable("icon-statistics"), Game.i.localeManager.i18n.get("mainMenu_statisticsButton"), () -> Game.i.screenManager.goToStatisticsScreen());
/* 1134 */     table1.add((Actor)menuButton1).size(134.0F);
/*      */     
/*      */     int j;
/* 1137 */     if ((j = Game.i.achievementManager.countAchievementsToRedeem()) > 0) {
/*      */       Image image;
/* 1139 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setSize(43.0F, 49.0F);
/* 1140 */       image.setPosition(97.0F, 91.0F);
/* 1141 */       menuButton1.addActor((Actor)image);
/*      */       
/* 1143 */       image.addAction((Action)Actions.forever((Action)Actions.sequence(
/* 1144 */               (Action)Actions.alpha(0.8F, 0.5F), 
/* 1145 */               (Action)Actions.alpha(1.0F, 0.5F))));
/*      */       
/*      */       Label label1;
/*      */       
/* 1149 */       (label1 = new Label(String.valueOf(j), Game.i.assetManager.getLabelStyle(21))).setSize(43.0F, 49.0F);
/* 1150 */       label1.setPosition(97.0F, 93.0F);
/* 1151 */       label1.setAlignment(1);
/* 1152 */       menuButton1.addActor((Actor)label1);
/*      */     } 
/*      */ 
/*      */     
/* 1156 */     MenuButton menuButton5 = new MenuButton(false, (Drawable)Game.i.assetManager.getDrawable("icon-research"), Game.i.localeManager.i18n.get("mainMenu_researchesButton"), () -> Game.i.screenManager.goToResearchesScreen());
/* 1157 */     table1.add((Actor)menuButton5).size(134.0F);
/*      */ 
/*      */     
/* 1160 */     Game.i.researchManager.updateAfforableResearchesCount();
/*      */     int i;
/* 1162 */     if ((i = Game.i.researchManager.getAfforableResearchesCount()) > 0) {
/*      */       Image image;
/* 1164 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setSize(43.0F, 49.0F);
/* 1165 */       image.setPosition(97.0F, 91.0F);
/* 1166 */       menuButton5.addActor((Actor)image);
/*      */       
/* 1168 */       image.addAction((Action)Actions.forever((Action)Actions.sequence(
/* 1169 */               (Action)Actions.alpha(0.8F, 0.5F), 
/* 1170 */               (Action)Actions.alpha(1.0F, 0.5F))));
/*      */       
/*      */       Label label1;
/*      */       
/* 1174 */       (label1 = new Label(String.valueOf(i), Game.i.assetManager.getLabelStyle(21))).setSize(43.0F, 49.0F);
/* 1175 */       label1.setPosition(97.0F, 93.0F);
/* 1176 */       label1.setAlignment(1);
/* 1177 */       menuButton5.addActor((Actor)label1);
/*      */     } 
/*      */ 
/*      */     
/* 1181 */     MenuButton menuButton6 = new MenuButton(true, (Drawable)Game.i.assetManager.getDrawable("icon-edit"), Game.i.localeManager.i18n.get("mainMenu_mapEditorButton"), null);
/* 1182 */     table1.add((Actor)menuButton6).size(134.0F);
/*      */     
/* 1184 */     if (Game.i.userMapManager.isMapEditorAvailable()) {
/* 1185 */       menuButton6.setClickHandler(() -> Game.i.screenManager.goToCustomMapSelectScreen());
/*      */     } else {
/* 1187 */       menuButton6.setClickHandler(() -> {
/*      */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("unlock_feature_by_installing_according_research"));
/*      */             
/*      */             Game.i.screenManager.goToResearchesScreenFocusOnResearch(ResearchType.STORYLINE_BUBBLE_SORT);
/*      */           });
/* 1192 */       menuButton6.flavor = 2;
/* 1193 */       menuButton6.setupBackgroundDrawables();
/*      */     } 
/*      */     
/* 1196 */     if (Config.isModdingMode()) {
/* 1197 */       this.k.setVisible(false);
/* 1198 */       this.f.setVisible(false);
/* 1199 */       this.g.setVisible(false);
/* 1200 */       this.h.setVisible(false);
/* 1201 */       this.i.setVisible(false);
/* 1202 */       this.j.setVisible(false);
/* 1203 */       this.r.setVisible(false);
/* 1204 */       this.s.setVisible(false);
/* 1205 */       this.t.setVisible(false);
/* 1206 */       complexButton3.setVisible(false);
/*      */     } 
/*      */     
/* 1209 */     a();
/* 1210 */     c();
/* 1211 */     Game.i.messageManager.addListener(this.z);
/*      */     
/* 1213 */     if (this.e != null) {
/*      */       
/* 1215 */       this.e.getTable().clear();
/*      */       
/*      */       Table table4;
/* 1218 */       (table4 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.78F)));
/* 1219 */       this.e.getTable().add((Actor)table4).row();
/*      */       
/* 1221 */       Table table5 = new Table();
/* 1222 */       table4.add((Actor)table5).pad(10.0F).row();
/*      */       
/* 1224 */       Label label1 = new Label("Connected to the Beta server", Game.i.assetManager.getLabelStyle(30));
/* 1225 */       table5.add((Actor)label1).row();
/* 1226 */       label1 = new Label("Anything you do here won't affect your main account nor its progress.", Game.i.assetManager.getLabelStyle(24));
/* 1227 */       table5.add((Actor)label1).row();
/*      */       
/* 1229 */       if (Game.i.authManager.isSignedIn()) {
/*      */         
/* 1231 */         table1 = new Table();
/* 1232 */         table5.add((Actor)table1).row();
/*      */         
/* 1234 */         label1 = new Label("Loading...", Game.i.assetManager.getLabelStyle(24));
/* 1235 */         table1.add((Actor)label1).row();
/*      */         
/* 1237 */         Game.i.httpManager.post(Config.GET_BETA_ACCOUNT_LINK_STATUS_URL)
/* 1238 */           .param("sessionid", Game.i.authManager.getSessionId())
/* 1239 */           .listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable) -> {
/*      */               String str = paramHttpResponse.getResultAsString();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               Threads.i().runOnMainThread(());
/* 1328 */             }).send();
/*      */       } else {
/*      */         
/* 1331 */         label1 = new Label("You can create a new account on this Beta server (or multiple, for testing purposes).", Game.i.assetManager.getLabelStyle(24));
/* 1332 */         table5.add((Actor)label1).row();
/* 1333 */         label1 = new Label("If you want to receive a Beta tester badge on your main account:", Game.i.assetManager.getLabelStyle(24));
/* 1334 */         table5.add((Actor)label1).row();
/* 1335 */         label1 = new Label("1. Create a beta account and sign in", Game.i.assetManager.getLabelStyle(24));
/* 1336 */         table5.add((Actor)label1).row();
/* 1337 */         label1 = new Label("2. A form will appear here, asking you to link your main account - fill it in", Game.i.assetManager.getLabelStyle(24));
/* 1338 */         table5.add((Actor)label1).row();
/* 1339 */         label1 = new Label("Use a single account to report issues and progress through this Beta version of the game.", Game.i.assetManager.getLabelStyle(24));
/* 1340 */         table5.add((Actor)label1).row();
/* 1341 */         label1 = new Label("Most active Beta testers will receive the Beta tester badge at the end of testing if they have linked their main account", Game.i.assetManager.getLabelStyle(24));
/* 1342 */         table5.add((Actor)label1).row();
/*      */       } 
/*      */     } 
/*      */     
/* 1346 */     a.d("rebuild took " + (Game.getTimestampMillis() - l) + "ms", new Object[0]);
/*      */   }
/*      */   
/*      */   private void c() {
/* 1350 */     Game.i.messageManager.processLocalMessages();
/*      */     
/*      */     MessageManager messageManager;
/*      */     
/*      */     int i;
/* 1355 */     if ((i = (messageManager = Game.i.messageManager).getUnreadMessageCount()) > 0) {
/*      */       
/* 1357 */       this.l.setIconLabelColors(Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P700, Color.GRAY);
/* 1358 */       this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1359 */       this.o.setVisible(true);
/* 1360 */       String str = Game.i.localeManager.i18n.get("unread_message_count");
/* 1361 */       this.n.setText(str + " " + i);
/* 1362 */       this.m.setVisible(true);
/*      */       
/* 1364 */       this.m.clearActions();
/* 1365 */       this.m.addAction((Action)Actions.forever(
/* 1366 */             (Action)Actions.sequence(
/* 1367 */               (Action)Actions.scaleTo(1.0F, 1.0F), 
/* 1368 */               (Action)Actions.alpha(0.56F), 
/* 1369 */               (Action)Actions.parallel((Action)Actions.scaleTo(1.7F, 1.7F, 0.8F), (Action)Actions.alpha(0.0F, 0.8F)), 
/* 1370 */               (Action)Actions.delay(0.5F))));
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1375 */       this.l.setIconLabelColors(new Color(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P700, Color.GRAY);
/* 1376 */       this.n.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1377 */       this.n.setText(Game.i.localeManager.i18n.get("no_new_messages"));
/* 1378 */       this.m.setVisible(false);
/* 1379 */       this.o.setVisible(false);
/*      */     } 
/*      */     
/* 1382 */     if (messageManager.getTotalMessageCount() == 0) {
/*      */       
/* 1384 */       this.p.setVisible(false);
/* 1385 */       this.q.setVisible(false);
/*      */       return;
/*      */     } 
/* 1388 */     this.p.setVisible(true);
/* 1389 */     this.q.setVisible(true);
/* 1390 */     this.q.setTextFromInt(messageManager.getTotalMessageCount());
/*      */   }
/*      */ 
/*      */   
/*      */   private void d() {
/* 1395 */     this.t.setText("");
/*      */     
/* 1397 */     this.k.clearActions();
/* 1398 */     this.k.addAction((Action)Actions.sequence(
/* 1399 */           (Action)Actions.fadeIn(0.5F)));
/*      */     
/* 1401 */     this.k.setText(Game.i.localeManager.i18n.get("loading..."));
/* 1402 */     this.r.setText(Game.i.localeManager.i18n.get("loading..."));
/*      */     
/* 1404 */     Game.i.authManager.getNews(paramNewsResponse -> {
/*      */           if (paramNewsResponse == null) {
/*      */             this.k.clearActions();
/*      */             
/*      */             this.k.addAction((Action)Actions.fadeOut(0.5F));
/*      */             
/*      */             this.r.clearActions();
/*      */             
/*      */             this.r.addAction((Action)Actions.fadeOut(0.5F));
/*      */             
/*      */             return;
/*      */           } 
/*      */           
/*      */           try {
/*      */             if (!Game.i.authManager.gameUpdateNotificationShown) {
/*      */               Game.i.authManager.gameUpdateNotificationShown = true;
/*      */               
/*      */               if (207 < paramNewsResponse.networkRequiredVersion) {
/*      */                 Notifications.i().add(Game.i.localeManager.i18n.get("update_game_for_leaderboards"), (Drawable)Game.i.assetManager.getDrawable("icon-exclamation-triangle"), MaterialColor.ORANGE.P800, StaticSoundType.NOTIFICATION);
/*      */               } else if (207 < paramNewsResponse.lastVersion) {
/*      */                 Notifications.i().add(Game.i.localeManager.i18n.get("game_update_available"), (Drawable)Game.i.assetManager.getDrawable("icon-info-square"), MaterialColor.GREEN.P800, StaticSoundType.NOTIFICATION);
/*      */               } 
/*      */             } 
/*      */             
/*      */             String str1 = paramNewsResponse.title;
/*      */             
/*      */             String str2 = paramNewsResponse.body;
/*      */             
/*      */             if (str1.length() > 24) {
/*      */               str1 = str1.substring(0, 24) + "...";
/*      */             }
/*      */             
/*      */             this.k.setText(str1);
/*      */             
/*      */             String[] arrayOfString = str2.trim().split("\n");
/*      */             
/*      */             StringBuilder stringBuilder;
/*      */             
/*      */             if ((stringBuilder = new StringBuilder(arrayOfString[0])).length() > 48) {
/*      */               String[] arrayOfString1 = stringBuilder.toString().split(" ");
/*      */               stringBuilder = new StringBuilder();
/*      */               int i = (arrayOfString1 = arrayOfString1).length;
/*      */               byte b = 0;
/*      */               while (b < i) {
/*      */                 String str = arrayOfString1[b];
/*      */                 if (stringBuilder.length() + str.length() <= 48) {
/*      */                   if (stringBuilder.length() != 0) {
/*      */                     stringBuilder.append(' ');
/*      */                   }
/*      */                   stringBuilder.append(str);
/*      */                   b++;
/*      */                 } 
/*      */               } 
/*      */               stringBuilder.append("...");
/*      */             } 
/*      */             this.t.setText(stringBuilder.toString());
/*      */             this.r.setText(Game.i.localeManager.i18n.format("season_formatted", new Object[] { Integer.valueOf(paramNewsResponse.seasonNumber) }));
/*      */             if (paramNewsResponse.seasonPosition > 0 && paramNewsResponse.seasonPlayerCount > 0) {
/*      */               (stringBuilder = new StringBuilder()).append(StringFormatter.commaSeparatedNumber(paramNewsResponse.seasonPosition));
/*      */               stringBuilder.append(" / ");
/*      */               stringBuilder.append(StringFormatter.commaSeparatedNumber(paramNewsResponse.seasonPlayerCount));
/*      */               stringBuilder.append(" - ");
/*      */               int i = MathUtils.ceil(paramNewsResponse.seasonPosition / paramNewsResponse.seasonPlayerCount * 100.0F);
/*      */               stringBuilder.append(Game.i.localeManager.i18n.format("top_percent", new Object[] { Integer.valueOf(i) }));
/*      */               this.s.setText((CharSequence)stringBuilder);
/*      */             } else if (Game.i.authManager.isSignedIn()) {
/*      */               this.s.setText(Game.i.localeManager.i18n.get("not_ranked"));
/*      */             } else {
/*      */               this.s.setText(Game.i.localeManager.i18n.get("sign_in_to_get_ranked"));
/*      */             } 
/*      */             if (Game.i.progressManager.existsAnyProgress() && (int)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LAST_AUTO_SHOWN_NEWS_ID) < paramNewsResponse.id) {
/*      */               Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.LAST_AUTO_SHOWN_NEWS_ID, paramNewsResponse.id);
/*      */               (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_NEWS_URL + paramNewsResponse.id, null);
/*      */               WebBrowser.i().setVisible(true);
/*      */             } 
/*      */             return;
/* 1480 */           } catch (Exception exception) {
/*      */             a.e("failed to set last news", new Object[] { exception });
/*      */             this.k.clearActions();
/*      */             this.k.addAction((Action)Actions.fadeOut(0.5F));
/*      */             this.r.clearActions();
/*      */             this.r.addAction((Action)Actions.fadeOut(0.5F));
/*      */             return;
/*      */           } 
/*      */         });
/*      */   }
/*      */   private void e() {
/* 1491 */     this.f.setEnabled(false);
/* 1492 */     this.h.clear();
/* 1493 */     this.g.clear();
/*      */     
/* 1495 */     this.h.add().height(1.0F).expandX().fillX();
/*      */     
/*      */     Label label;
/* 1498 */     (label = new Label(Game.i.localeManager.i18n.get("time_left") + ": ", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1499 */     this.h.add((Actor)label);
/*      */     
/* 1501 */     this.j = new Label(Game.i.localeManager.i18n.get("loading..."), Game.i.assetManager.getLabelStyle(21));
/* 1502 */     this.j.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1503 */     this.h.add((Actor)this.j);
/*      */     
/* 1505 */     this.i = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 1506 */     this.i.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1507 */     this.h.add((Actor)this.i);
/*      */     
/* 1509 */     Game.i.dailyQuestManager.getCurrentDayLevel(paramDailyQuestLevel -> {
/*      */           paramDailyQuestLevel.validate();
/*      */           this.v = paramDailyQuestLevel;
/*      */           BasicLevel basicLevel;
/*      */           if ((basicLevel = Game.i.basicLevelManager.getLevel(paramDailyQuestLevel.getLevelName())) == null) {
/*      */             throw new IllegalStateException("Basic level " + paramDailyQuestLevel.getLevelName() + " not found");
/*      */           }
/*      */           this.f.setEnabled(true);
/*      */           if (paramDailyQuestLevel.wasCompleted()) {
/*      */             Image image;
/*      */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("main-menu-check-outline"))).setSize(48.0F, 48.0F);
/*      */             image.setPosition(248.0F, 14.0F);
/*      */             this.g.addActor((Actor)image);
/*      */           } else {
/*      */             Image image;
/*      */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setSize(32.25F, 36.75F);
/*      */             image.setPosition(273.0F, 63.0F);
/*      */             this.g.addActor((Actor)image);
/*      */             image.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(0.8F, 0.5F), (Action)Actions.alpha(1.0F, 0.5F))));
/*      */           } 
/*      */           Image image2;
/*      */           (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-main-menu-dq-preview"))).setPosition(130.0F, 99.0F);
/*      */           image2.setSize(170.0F, 138.0F);
/*      */           this.g.addActor((Actor)image2);
/*      */           MapManager.MapPreview mapPreview = Game.i.basicLevelManager.getLevel(paramDailyQuestLevel.getLevelName()).getMap().getPreview();
/*      */           Image image1;
/*      */           (image1 = new Image(mapPreview.getTextureRegion())).setSize(155.0F, 115.0F);
/*      */           image1.setPosition(139.0F, 113.0F);
/*      */           this.g.addActor((Actor)image1);
/*      */           Game.i.dailyQuestManager.getLeaderboards(Game.i.dailyQuestManager.getCurrentDayDate(), ());
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/* 1594 */     this.y.setZero();
/* 1595 */     Vector2 vector2 = this.w.localToStageCoordinates(this.y);
/* 1596 */     if (this.x < 3 && (vector2.x < -150.0F || vector2.x > 150.0F || vector2.y < -150.0F || vector2.y > 150.0F)) {
/*      */       
/* 1598 */       this.x++;
/* 1599 */       a.e("broken layout, fixing (" + this.x + "): " + vector2.x + ", " + vector2.y, new Object[0]);
/* 1600 */       b();
/*      */     } 
/*      */     
/* 1603 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 1604 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 1605 */     Gdx.gl.glClear(16640);
/*      */     
/* 1607 */     if (Game.isLoaded() && Game.i.settingsManager.isEscButtonJustPressed() && !Dialog.i().isVisible()) {
/*      */       
/* 1609 */       Dialog.i().showConfirm(Game.i.localeManager.i18n.get("exit_game_confirm"), Game::exit);
/* 1610 */       (Dialog.i()).ignoreEscForFrame = true;
/*      */     } 
/*      */ 
/*      */     
/* 1614 */     if (this.v != null && this.j != null) {
/* 1615 */       this.u += paramFloat;
/* 1616 */       if (this.u >= 1.0F) {
/* 1617 */         this.u--;
/*      */         
/*      */         int i;
/* 1620 */         if ((i = this.v.endTimestamp - Game.getTimestampSeconds()) <= 0) {
/* 1621 */           e(); return;
/*      */         } 
/* 1623 */         this.j.setText((CharSequence)StringFormatter.digestTime(i));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1631 */     Game.i.uiManager.removeLayer(this.c);
/* 1632 */     Game.i.uiManager.removeLayer(this.b);
/* 1633 */     Game.i.uiManager.removeLayer(this.d);
/* 1634 */     if (this.e != null) {
/* 1635 */       Game.i.uiManager.removeLayer(this.e);
/*      */     }
/*      */     
/* 1638 */     Game.EVENTS.getListeners(ScreenResize.class).remove(this.A);
/* 1639 */     Game.i.messageManager.removeListener(this.z);
/* 1640 */     a.i("disposed", new Object[0]);
/*      */   }
/*      */   
/*      */   private static class MenuButton
/*      */     extends TableButton
/*      */   {
/*      */     public static final float SIZE = 134.0F;
/*      */     public static final int FLAVOR_NORMAL = 0;
/*      */     public static final int FLAVOR_GREEN = 1;
/*      */     public static final int FLAVOR_GREY = 2;
/* 1650 */     public int flavor = 0;
/*      */     
/*      */     private boolean k;
/*      */     
/*      */     public MenuButton(boolean param1Boolean, Drawable param1Drawable, CharSequence param1CharSequence, Runnable param1Runnable) {
/* 1655 */       super(param1Runnable);
/*      */ 
/*      */       
/* 1658 */       this.k = param1Boolean;
/*      */       
/* 1660 */       setupBackgroundDrawables();
/*      */       
/*      */       Image image;
/* 1663 */       (image = new Image(param1Drawable)).setPosition(35.0F, 46.0F);
/* 1664 */       image.setSize(64.0F, 64.0F);
/* 1665 */       addActor((Actor)image);
/*      */       
/*      */       LimitedWidthLabel limitedWidthLabel;
/* 1668 */       (limitedWidthLabel = new LimitedWidthLabel(param1CharSequence, 21, 18, 110.0F)).setPosition(0.0F, 18.0F);
/* 1669 */       limitedWidthLabel.setSize(134.0F, 18.0F);
/* 1670 */       limitedWidthLabel.setAlignment(1);
/* 1671 */       addActor((Actor)limitedWidthLabel);
/*      */     }
/*      */     
/*      */     public void setupBackgroundDrawables() {
/* 1675 */       String str = this.k ? "a" : "b";
/* 1676 */       switch (this.flavor) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 1:
/* 1681 */           str = str + "Green";
/*      */           break;
/*      */         
/*      */         case 2:
/* 1685 */           str = str + "Grey";
/*      */           break;
/*      */       } 
/*      */       
/* 1689 */       setBackgroundDrawables((Drawable)Game.i.assetManager
/* 1690 */           .getQuad("screen.mainMenu.squareButton." + str + ".normal"), (Drawable)Game.i.assetManager
/* 1691 */           .getQuad("screen.mainMenu.squareButton." + str + ".active"), (Drawable)Game.i.assetManager
/* 1692 */           .getQuad("screen.mainMenu.squareButton." + str + ".hover"), (Drawable)Game.i.assetManager
/* 1693 */           .getQuad("screen.mainMenu.squareButton." + str + ".disabled"));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\MainMenuScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */