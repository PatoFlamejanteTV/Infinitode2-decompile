/*      */ package com.prineside.tdi2.ui.components;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.MapPrestigeConfig;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.items.ResourceItem;
/*      */ import com.prineside.tdi2.managers.LeaderBoardManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.PurchaseManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.systems.GameUiSystem;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.ItemCell;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.ItemDescriptionDialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class GameOverOverlay implements Disposable {
/*   58 */   private static final TLog a = TLog.forClass(GameOverOverlay.class);
/*      */ 
/*      */ 
/*      */   
/*   62 */   public static final String[] HINT_ALIASES = new String[72]; static {
/*   63 */     for (byte b = 0; b < HINT_ALIASES.length; b++)
/*   64 */       HINT_ALIASES[b] = "hint_msg_" + (b + 1); 
/*      */   }
/*      */   
/*   67 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 170, "GameOverOverlay overlay", true);
/*   68 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 171, "GameOverOverlay main");
/*      */   
/*      */   private MapPrestigeOverlay d;
/*      */   
/*      */   private final Group e;
/*      */   
/*      */   private final Table f;
/*      */   
/*      */   private final Label g;
/*      */   
/*      */   private final Label h;
/*      */   private final Label i;
/*      */   private final Label j;
/*      */   private final Label k;
/*      */   private final Image l;
/*      */   private final Group m;
/*      */   private final Label n;
/*      */   private final Label o;
/*      */   private final Label p;
/*      */   private final Label q;
/*      */   private final Label r;
/*      */   private final Label s;
/*      */   private Group t;
/*      */   private Group u;
/*      */   private ComplexButton v;
/*      */   private ComplexButton w;
/*      */   private ComplexButton x;
/*      */   private Label y;
/*      */   private ComplexButton z;
/*      */   private Group A;
/*      */   private Label B;
/*      */   private Label C;
/*  100 */   private int D = -1;
/*      */   
/*      */   private final GameSystemProvider E;
/*      */   
/*      */   private boolean F;
/*      */   private Array<GameOverItemStack> G;
/*      */   private boolean H;
/*  107 */   private Array<ItemCell> I = new Array();
/*      */   
/*      */   public GameOverOverlay(GameSystemProvider paramGameSystemProvider) {
/*  110 */     this.E = paramGameSystemProvider;
/*      */     
/*      */     Image image8;
/*  113 */     (image8 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  114 */     (image8.getColor()).a = 0.78F;
/*  115 */     this.b.getTable().add((Actor)image8).expand().fill();
/*      */     
/*      */     Group group;
/*  118 */     (group = new Group()).setOrigin(600.0F, 380.0F);
/*  119 */     this.c.getTable().add((Actor)group).padBottom(80.0F).size(1200.0F, 700.0F);
/*      */     
/*  121 */     this.e = new Group();
/*  122 */     this.e.setOrigin(600.0F, 350.0F);
/*  123 */     this.e.setSize(1200.0F, 700.0F);
/*  124 */     group.addActor((Actor)this.e);
/*      */     
/*  126 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 8.0F, 0.0F, 0.0F, 700.0F, 1200.0F, 688.0F, 1192.0F, 0.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  132 */     this.e.addActor((Actor)quadActor);
/*      */ 
/*      */     
/*  135 */     this.f = new Table();
/*  136 */     this.f.setWidth(1200.0F);
/*      */     
/*      */     ScrollPane scrollPane;
/*  139 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.f));
/*  140 */     scrollPane.setSize(1198.0F, 428.0F);
/*  141 */     scrollPane.setPosition(1.0F, 21.0F);
/*  142 */     scrollPane.setCullingArea(null);
/*  143 */     this.e.addActor((Actor)scrollPane);
/*      */     
/*      */     Image image7;
/*  146 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize(1150.0F, 32.0F);
/*  147 */     image7.setColor(new Color(791621631));
/*  148 */     image7.setPosition(25.0F, 418.0F);
/*  149 */     image7.setTouchable(Touchable.disabled);
/*  150 */     this.e.addActor((Actor)image7);
/*      */ 
/*      */     
/*  153 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setSize(1150.0F, 32.0F);
/*  154 */     image7.setColor(new Color(791621631));
/*  155 */     image7.setPosition(25.0F, 20.0F);
/*  156 */     image7.setTouchable(Touchable.disabled);
/*  157 */     this.e.addActor((Actor)image7);
/*      */     
/*      */     Label label3;
/*      */     
/*  161 */     (label3 = new Label(Game.i.localeManager.i18n.get("game_over"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  162 */     label3.setPosition(80.0F, 618.0F);
/*  163 */     label3.setSize(100.0F, 32.0F);
/*  164 */     this.e.addActor((Actor)label3);
/*      */     
/*  166 */     this.g = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  167 */     this.g.setPosition(80.0F, 576.0F);
/*  168 */     this.g.setSize(100.0F, 32.0F);
/*  169 */     this.e.addActor((Actor)this.g);
/*      */ 
/*      */     
/*  172 */     (label3 = new Label(Game.i.progressManager.getDifficultyName(paramGameSystemProvider.gameState.difficultyMode), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(Game.i.progressManager.getDifficultyModeColor(paramGameSystemProvider.gameState.difficultyMode));
/*  173 */     label3.setPosition(80.0F, 618.0F);
/*  174 */     label3.setSize(1020.0F, 32.0F);
/*  175 */     label3.setAlignment(16);
/*  176 */     this.e.addActor((Actor)label3);
/*      */     
/*  178 */     this.h = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  179 */     this.h.setPosition(80.0F, 576.0F);
/*  180 */     this.h.setSize(1020.0F, 32.0F);
/*  181 */     this.h.setAlignment(16);
/*  182 */     this.e.addActor((Actor)this.h);
/*      */ 
/*      */     
/*  185 */     (label3 = new Label(Game.i.localeManager.i18n.get("game_over_defeated_waves_hint"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(250.0F, 480.0F);
/*  186 */     label3.setSize(100.0F, 15.0F);
/*  187 */     label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  188 */     label3.setAlignment(1);
/*  189 */     this.e.addActor((Actor)label3);
/*      */     
/*  191 */     this.q = new Label(Game.i.localeManager.i18n.get("new_record") + "!", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  192 */     this.q.setPosition(250.0F, 454.0F);
/*  193 */     this.q.setSize(100.0F, 15.0F);
/*  194 */     this.q.setColor(MaterialColor.AMBER.P500);
/*  195 */     this.q.setAlignment(1);
/*  196 */     this.q.setVisible(false);
/*  197 */     this.e.addActor((Actor)this.q);
/*      */ 
/*      */     
/*  200 */     (label3 = new Label(Game.i.localeManager.i18n.get("score"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(550.0F, 473.0F);
/*  201 */     label3.setSize(100.0F, 15.0F);
/*  202 */     label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  203 */     label3.setAlignment(1);
/*  204 */     this.e.addActor((Actor)label3);
/*      */     
/*  206 */     this.r = new Label(Game.i.localeManager.i18n.get("new_record") + "!", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  207 */     this.r.setPosition(550.0F, 447.0F);
/*  208 */     this.r.setSize(100.0F, 15.0F);
/*  209 */     this.r.setColor(MaterialColor.AMBER.P500);
/*  210 */     this.r.setAlignment(1);
/*  211 */     this.r.setVisible(false);
/*  212 */     this.e.addActor((Actor)this.r);
/*      */ 
/*      */     
/*  215 */     (label3 = new Label(Game.i.localeManager.i18n.get("duration"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(850.0F, 480.0F);
/*  216 */     label3.setSize(100.0F, 15.0F);
/*  217 */     label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  218 */     label3.setAlignment(1);
/*  219 */     this.e.addActor((Actor)label3);
/*      */     
/*  221 */     this.s = new Label(Game.i.localeManager.i18n.get("new_record") + "!", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  222 */     this.s.setPosition(850.0F, 454.0F);
/*  223 */     this.s.setSize(100.0F, 15.0F);
/*  224 */     this.s.setColor(MaterialColor.AMBER.P500);
/*  225 */     this.s.setAlignment(1);
/*  226 */     this.s.setVisible(false);
/*  227 */     this.e.addActor((Actor)this.s);
/*      */     
/*  229 */     this.i = new Label("15,918", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(60), Color.WHITE));
/*  230 */     this.i.setPosition(550.0F, 503.0F);
/*  231 */     this.i.setSize(100.0F, 48.0F);
/*  232 */     this.i.setAlignment(1);
/*  233 */     this.e.addActor((Actor)this.i);
/*      */     
/*  235 */     this.j = new Label("57", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  236 */     this.j.setPosition(250.0F, 509.0F);
/*  237 */     this.j.setSize(100.0F, 26.0F);
/*  238 */     this.j.setAlignment(1);
/*  239 */     this.e.addActor((Actor)this.j);
/*      */     
/*  241 */     this.k = new Label("17m 56s", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  242 */     this.k.setPosition(850.0F, 509.0F);
/*  243 */     this.k.setSize(100.0F, 26.0F);
/*  244 */     this.k.setAlignment(1);
/*  245 */     this.e.addActor((Actor)this.k);
/*      */ 
/*      */     
/*  248 */     this.l = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"));
/*  249 */     this.l.setPosition(587.0F, 638.0F);
/*  250 */     this.l.setSize(32.0F, 32.0F);
/*  251 */     this.l.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  252 */     this.l.setOrigin(1);
/*  253 */     this.l.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/*  254 */     this.e.addActor((Actor)this.l);
/*      */     
/*  256 */     this.m = new Group();
/*  257 */     this.m.setSize(286.0F, 144.0F);
/*  258 */     this.m.setPosition(457.0F, 635.0F);
/*  259 */     this.m.setOrigin(1);
/*  260 */     this.m.setVisible(false);
/*  261 */     this.e.addActor((Actor)this.m);
/*      */     
/*      */     Image image6;
/*  264 */     (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-game-over-leaderboards-rank"))).setSize(286.0F, 144.0F);
/*  265 */     this.m.addActor((Actor)image6);
/*      */     
/*      */     Table table2;
/*  268 */     (table2 = new Table()).setPosition(0.0F, 35.0F);
/*  269 */     table2.setSize(286.0F, 90.0F);
/*  270 */     this.m.addActor((Actor)table2);
/*      */ 
/*      */     
/*  273 */     Table table3 = new Table();
/*  274 */     table2.add((Actor)table3).row();
/*      */     
/*      */     Image image9;
/*  277 */     (image9 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  278 */     table3.add((Actor)image9).size(32.0F, 32.0F);
/*      */     
/*      */     Label label4;
/*  281 */     (label4 = new Label(Game.i.localeManager.i18n.get("leaderboard"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  282 */     table3.add((Actor)label4).height(32.0F).padLeft(8.0F).padRight(8.0F);
/*      */ 
/*      */     
/*  285 */     table3 = new Table();
/*  286 */     table2.add((Actor)table3).row();
/*      */     
/*  288 */     this.n = new Label("1234", Game.i.assetManager.getLabelStyle(30));
/*  289 */     table3.add((Actor)this.n);
/*      */     
/*  291 */     this.o = new Label(" / 9876", Game.i.assetManager.getLabelStyle(24));
/*  292 */     table3.add((Actor)this.o);
/*      */ 
/*      */     
/*  295 */     this.p = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  296 */     this.p.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  297 */     table2.add((Actor)this.p).row();
/*      */ 
/*      */     
/*  300 */     this.t = new Group();
/*  301 */     this.t.setTransform(false);
/*  302 */     this.t.setSize(113.0F, 415.0F);
/*  303 */     this.t.setPosition(1193.0F, 114.0F);
/*  304 */     this.e.addActor((Actor)this.t);
/*      */ 
/*      */     
/*  307 */     this.u = new Group();
/*  308 */     this.u.setVisible(false);
/*  309 */     this.u.setTransform(false);
/*  310 */     this.u.setSize(127.0F, 420.0F);
/*  311 */     this.u.setPosition(-120.0F, 114.0F);
/*  312 */     this.e.addActor((Actor)this.u);
/*      */     
/*      */     Image image5;
/*  315 */     (image5 = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.adsRayBg"))).setSize(126.0F, 326.0F);
/*  316 */     image5.setPosition(-8.0F, 92.0F);
/*  317 */     this.u.addActor((Actor)image5);
/*      */     
/*  319 */     this
/*      */       
/*  321 */       .v = (new ComplexButton("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> d())).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.adsButton"), 0.0F, 0.0F, 117.0F, 100.0F).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("rewarding-ad"), 19.0F, 20.0F, 64.0F, 64.0F);
/*  322 */     this.v.setPosition(10.0F, 0.0F);
/*  323 */     this.v.setSize(117.0F, 100.0F);
/*  324 */     this.v.setBackgroundColors(MaterialColor.PURPLE.P700, MaterialColor.PURPLE.P800, MaterialColor.PURPLE.P500, Color.GRAY);
/*  325 */     this.u.addActor((Actor)this.v);
/*      */     
/*      */     Label label2;
/*  328 */     (label2 = new Label("+25%", Game.i.assetManager.getLabelStyle(18))).setPosition(21.0F, 31.0F);
/*  329 */     label2.setSize(64.0F, 13.0F);
/*  330 */     label2.setColor(MaterialColor.PURPLE.P700);
/*  331 */     label2.setAlignment(1);
/*  332 */     this.v.addActor((Actor)label2);
/*      */     
/*      */     Image image4;
/*  335 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("game-over-ad-button-glow"))).setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  336 */     image4.setPosition(-22.0F, -16.0F);
/*  337 */     image4.setSize(143.0F, 132.0F);
/*  338 */     image4.setTouchable(Touchable.disabled);
/*  339 */     image4.addAction((Action)Actions.forever(
/*  340 */           (Action)Actions.sequence(
/*  341 */             (Action)Actions.alpha(0.0F, 0.5F), 
/*  342 */             (Action)Actions.alpha(1.0F, 0.5F))));
/*      */ 
/*      */     
/*  345 */     this.v.addActor((Actor)image4);
/*  346 */     image4.setZIndex(this.v.background.getZIndex() + 1);
/*      */ 
/*      */ 
/*      */     
/*  350 */     String str2 = Game.i.localeManager.i18n.get("back_to_menu");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  360 */     (complexButton = (new ComplexButton(str2, Game.i.assetManager.getLabelStyle((str2.length() > 12) ? 18 : 21), () -> { if (GameStateSystem.GameMode.isBasicLevel(paramGameSystemProvider.gameState.gameMode)) { Game.i.screenManager.goToLevelSelectScreen(); return; }  Game.i.screenManager.goToCustomMapSelectScreen(); })).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.btnHome"), 0.0F, 0.0F, 157.0F, 125.0F).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-house"), 46.0F, 43.0F, 64.0F, 64.0F)).setBackgroundColors(MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P600, MaterialColor.GREY.P800);
/*  361 */     complexButton.setLabel(46.0F, 18.0F, 64.0F, 16.0F, 1);
/*  362 */     complexButton.setPosition(183.0F, -27.0F);
/*  363 */     complexButton.setSize(157.0F, 125.0F);
/*  364 */     this.e.addActor((Actor)complexButton);
/*      */ 
/*      */     
/*  367 */     String str1 = Game.i.localeManager.i18n.get("researches");
/*  368 */     this
/*      */ 
/*      */ 
/*      */       
/*  372 */       .z = (new ComplexButton(str1, Game.i.assetManager.getLabelStyle((str1.length() > 12) ? 18 : 21), () -> Game.i.screenManager.goToResearchesScreen())).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.btnResearch"), 0.0F, 0.0F, 157.0F, 125.0F).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-research"), 46.0F, 43.0F, 64.0F, 64.0F);
/*  373 */     this.z.setBackgroundColors(MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P600, MaterialColor.GREY.P800);
/*  374 */     this.z.setLabel(46.0F, 18.0F, 64.0F, 16.0F, 1);
/*  375 */     this.z.setPosition(360.0F, -27.0F);
/*  376 */     this.z.setSize(157.0F, 125.0F);
/*  377 */     this.e.addActor((Actor)this.z);
/*      */ 
/*      */     
/*  380 */     str1 = Game.i.localeManager.i18n.get("restart");
/*  381 */     this
/*      */ 
/*      */ 
/*      */       
/*  385 */       .w = (new ComplexButton(str1, Game.i.assetManager.getLabelStyle((str1.length() > 12) ? 18 : 21), () -> paramGameSystemProvider.gameState.restartGame(false))).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.btnRestart"), 0.0F, 0.0F, 157.0F, 125.0F).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-restart"), 51.0F, 43.0F, 64.0F, 64.0F);
/*  386 */     this.w.setBackgroundColors(new Color(-1454365441), new Color(-1756946177), new Color(-378654209), MaterialColor.GREY.P800);
/*  387 */     this.w.setLabel(51.0F, 18.0F, 64.0F, 16.0F, 1);
/*  388 */     this.w.setPosition(683.0F, -27.0F);
/*  389 */     this.w.setSize(157.0F, 125.0F);
/*  390 */     this.e.addActor((Actor)this.w);
/*      */ 
/*      */     
/*  393 */     str1 = Game.i.localeManager.i18n.get("next_level_button");
/*  394 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  401 */       .x = (new ComplexButton(str1, Game.i.assetManager.getLabelStyle((str1.length() > 12) ? 18 : 21), () -> { BasicLevel basicLevel; if ((basicLevel = a()) != null && Game.i.basicLevelManager.isOpened(basicLevel)) Game.i.screenManager.startNewLevelWithAbilitySelection(GameStateSystem.GameMode.BASIC_LEVELS, basicLevel.name);  })).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.btnNextLevel"), 0.0F, 0.0F, 157.0F, 125.0F).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-rewind"), 51.0F, 43.0F, 64.0F, 64.0F);
/*  402 */     this.x.setBackgroundColors(MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900, MaterialColor.LIGHT_GREEN.P600, MaterialColor.GREY.P800);
/*  403 */     this.x.setLabel(51.0F, 18.0F, 64.0F, 16.0F, 1);
/*  404 */     this.x.setPosition(860.0F, -27.0F);
/*  405 */     this.x.setSize(157.0F, 125.0F);
/*  406 */     this.e.addActor((Actor)this.x);
/*      */     
/*  408 */     this.y = new Label("", Game.i.assetManager.getLabelStyle(18));
/*  409 */     this.y.setAlignment(1);
/*  410 */     this.y.setPosition(865.0F, -54.0F);
/*  411 */     this.y.setSize(152.0F, 16.0F);
/*  412 */     this.y.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  413 */     this.e.addActor((Actor)this.y);
/*      */ 
/*      */     
/*  416 */     this.A = new Group();
/*  417 */     this.A.setTransform(false);
/*  418 */     this.A.setSize(1200.0F, 95.0F);
/*  419 */     this.A.setPosition(0.0F, -180.0F);
/*  420 */     this.e.addActor((Actor)this.A);
/*      */     
/*      */     Table table1;
/*  423 */     (table1 = new Table()).setSize(1200.0F, 15.0F);
/*  424 */     table1.setPosition(0.0F, 80.0F);
/*  425 */     this.A.addActor((Actor)table1);
/*      */     
/*      */     Image image3;
/*  428 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setColor(new Color(1669871871));
/*  429 */     table1.add((Actor)image3).size(360.0F, 2.0F);
/*      */     
/*      */     Label label1;
/*  432 */     (label1 = new Label(Game.i.localeManager.i18n.get("hint_box_title"), Game.i.assetManager.getLabelStyle(21))).setColor(new Color(-1983886849));
/*  433 */     table1.add((Actor)label1).height(15.0F).padLeft(8.0F).padRight(8.0F);
/*      */     
/*      */     Image image2;
/*  436 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(new Color(1669871871));
/*  437 */     table1.add((Actor)image2).size(360.0F, 2.0F);
/*      */     
/*      */     Image image1;
/*  440 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-radial-bottom"))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  441 */     image1.setSize(720.0F, 82.0F);
/*  442 */     image1.setPosition(220.0F, 1.0F);
/*  443 */     this.A.addActor((Actor)image1);
/*      */     
/*  445 */     this.B = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  446 */     this.B.setAlignment(1);
/*  447 */     this.B.setSize(900.0F, 84.0F);
/*  448 */     this.B.setPosition(150.0F, 2.0F);
/*  449 */     this.B.setWrap(true);
/*  450 */     this.B.setColor(new Color(-588396289));
/*  451 */     this.A.addActor((Actor)this.B);
/*      */ 
/*      */     
/*  454 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-horizontal"))).setColor(new Color(1669871871));
/*  455 */     image1.setSize(720.0F, 2.0F);
/*  456 */     image1.setPosition(220.0F, 0.0F);
/*  457 */     this.A.addActor((Actor)image1);
/*      */     
/*  459 */     this.C = new Label("", Game.i.assetManager.getLabelStyle(18));
/*  460 */     this.C.setPosition(0.0F, -24.0F);
/*  461 */     this.C.setSize(1200.0F, 15.0F);
/*  462 */     this.C.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  463 */     this.C.setAlignment(1);
/*  464 */     this.A.addActor((Actor)this.C);
/*      */     
/*  466 */     this.A.setTouchable(Touchable.enabled);
/*  467 */     this.A.addListener((EventListener)new ClickListener(this)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  470 */             GameOverOverlay.a(this.a);
/*      */           }
/*      */         });
/*      */     
/*  474 */     this.b.getTable().setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  475 */     this.b.getTable().setVisible(false);
/*  476 */     this.e.setScale(0.0F);
/*  477 */     this.c.getTable().setVisible(false);
/*      */   }
/*      */   
/*      */   private BasicLevel a() {
/*  481 */     if (this.E.gameState.basicLevelName != null && this.E.gameState.dailyQuestLevel == null) {
/*      */       BasicLevel basicLevel;
/*  483 */       if ((basicLevel = Game.i.basicLevelManager.getLevel(this.E.gameState.basicLevelName)).dailyQuest) {
/*  484 */         return null;
/*      */       }
/*      */       
/*  487 */       return Game.i.basicLevelManager.getNextVisibleLevel(basicLevel);
/*      */     } 
/*  489 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int a(int paramInt) {
/*  494 */     return StrictMath.round(paramInt * 0.2501F);
/*      */   }
/*      */   
/*      */   private IssuedItems b() {
/*  498 */     IssuedItems issuedItems = new IssuedItems(Game.i.progressManager.isPremiumStatusActive() ? IssuedItems.IssueReason.PREMIUM_REWARD_VIDEO : IssuedItems.IssueReason.REWARD_VIDEO, Game.getTimestampSeconds());
/*  499 */     for (byte b = 0; b < this.G.size; b++) {
/*      */       ItemStack itemStack;
/*  501 */       if ((itemStack = (ItemStack)this.G.get(b)).getItem().getType() == ItemType.GREEN_PAPER || itemStack.getItem().getType() == ItemType.RESOURCE || itemStack.getItem().getType() == ItemType.BIT_DUST) {
/*      */         int i;
/*      */         
/*  504 */         if ((i = a(itemStack.getCount())) > 0) {
/*  505 */           itemStack = new ItemStack(itemStack.getItem(), i);
/*  506 */           issuedItems.items.add(itemStack);
/*      */         } 
/*      */       } 
/*      */     } 
/*  510 */     ProgressManager.compressStacksArray(issuedItems.items);
/*      */     
/*  512 */     return issuedItems;
/*      */   }
/*      */   
/*      */   private void c() {
/*  516 */     this.H = true;
/*      */     
/*  518 */     IssuedItems issuedItems = b(); byte b;
/*  519 */     for (b = 0; b < issuedItems.items.size; b++) {
/*  520 */       ItemStack itemStack = (ItemStack)issuedItems.items.get(b);
/*  521 */       Game.i.progressManager.addItemStack(itemStack, "game_over_ad_reward");
/*      */     } 
/*  523 */     Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*      */ 
/*      */     
/*  526 */     for (b = 0; b < issuedItems.items.size; b++) {
/*  527 */       ItemStack itemStack = (ItemStack)issuedItems.items.get(b);
/*  528 */       for (byte b1 = 0; b1 < this.I.size; b1++) {
/*      */         ItemCell itemCell;
/*  530 */         if ((itemCell = (ItemCell)this.I.get(b1)).getItem() == itemStack.getItem()) {
/*  531 */           itemCell.setCount(itemCell.getCount() + a(itemCell.getCount()));
/*      */           
/*      */           Label label;
/*  534 */           (label = new Label("+25%", Game.i.assetManager.getLabelStyle(21))).addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.alpha(0.78F, 0.3F), (Action)Actions.alpha(1.0F, 0.3F))));
/*  535 */           label.setAlignment(16);
/*  536 */           label.setPosition(96.0F, 108.0F);
/*  537 */           label.setSize(20.0F, 20.0F);
/*  538 */           itemCell.overlay.addActor((Actor)label);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*  545 */     if (this.G != null && !this.H) {
/*  546 */       this.H = true;
/*  547 */       this.u.setVisible(false);
/*      */       
/*  549 */       Game.i.purchaseManager.showRewardingAd(PurchaseManager.RewardingAdsType.END_GAME, paramBoolean -> {
/*      */             if (paramBoolean.booleanValue()) {
/*      */               c();
/*      */               return;
/*      */             } 
/*      */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("something_wrong_try_later"));
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void show(Array<GameOverItemStack> paramArray, MapPrestigeConfig paramMapPrestigeConfig) {
/*  565 */     String str = "game_over_reason_" + this.E.gameState.gameOverReason.name();
/*  566 */     this.g.setText(Game.i.localeManager.i18n.get(str));
/*      */     
/*  568 */     if (this.E.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*  569 */       this.h.setText(Game.i.localeManager.i18n.get("level") + " " + this.E.gameState.basicLevelName);
/*  570 */       this.h.setColor((Game.i.basicLevelManager.getLevelStage(this.E.gameState.basicLevelName)).color);
/*  571 */     } else if (this.E.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/*  572 */       this.h.setText(Game.i.localeManager.i18n.get("custom_map"));
/*  573 */       this.h.setColor(Color.WHITE);
/*      */     } 
/*      */     
/*  576 */     int i = this.E.wave.getCompletedWavesCount();
/*  577 */     long l = this.E.gameState.getScore();
/*  578 */     int j = (int)this.E.statistics.getCurrentGameStatistic(StatisticsType.PRT);
/*      */     
/*  580 */     this.i.setText((CharSequence)StringFormatter.commaSeparatedNumber(l));
/*  581 */     this.j.setText((CharSequence)StringFormatter.commaSeparatedNumber(i));
/*  582 */     this.k.setText(StringFormatter.timePassed(j, true, false));
/*      */     
/*  584 */     if (this.E.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*      */       
/*  586 */       BasicLevel basicLevel1 = Game.i.basicLevelManager.getLevel(this.E.gameState.basicLevelName);
/*      */       
/*  588 */       this.q.setVisible(((ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(basicLevel1.name) < i));
/*  589 */       this.s.setVisible(((ProgressPrefs.i()).basicLevel.getLevelMaxPlayingTime(basicLevel1.name) < j));
/*  590 */       this.r.setVisible(((ProgressPrefs.i()).basicLevel.getLevelMaxScore(basicLevel1.name) < l));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  599 */       int[] arrayOfInt = basicLevel1.getStarMilestoneWaves();
/*  600 */       j = 0; byte b;
/*  601 */       for (b = 0; b < arrayOfInt.length; b++) {
/*  602 */         if (arrayOfInt[b] != 0 && this.E.wave.getCompletedWavesCount() >= arrayOfInt[b]) {
/*  603 */           j++;
/*      */         }
/*      */       } 
/*  606 */       for (b = 0; b < basicLevel1.quests.size; b++) {
/*      */         BasicLevelQuestConfig basicLevelQuestConfig;
/*  608 */         if ((basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel1.quests.items)[b]).isCompleted()) {
/*  609 */           for (byte b1 = 0; b1 < basicLevelQuestConfig.prizes.size; b1++) {
/*      */             ItemStack itemStack;
/*  611 */             if ((itemStack = ((ItemStack[])basicLevelQuestConfig.prizes.items)[b1]).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/*  612 */               j += itemStack.getCount();
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*  617 */       a.i(j + " stars", new Object[0]);
/*      */       
/*      */       ParticlesCanvas particlesCanvas;
/*  620 */       (particlesCanvas = new ParticlesCanvas()).setSize(3120.0F, 64.0F);
/*  621 */       particlesCanvas.setPosition(520.0F, 626.0F);
/*  622 */       this.e.addActor((Actor)particlesCanvas);
/*      */       
/*      */       Image image;
/*  625 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(48.0F, 48.0F);
/*  626 */       image.setPosition(520.0F, 566.0F);
/*  627 */       if (j <= 0) {
/*  628 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */       } else {
/*  630 */         image.setColor(MaterialColor.AMBER.P400);
/*  631 */         image.setOrigin(24.0F, 24.0F);
/*  632 */         image.addAction((Action)Actions.sequence(
/*  633 */               (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  634 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F, (Interpolation)Interpolation.swingOut)));
/*      */       } 
/*      */       
/*  637 */       this.e.addActor((Actor)image);
/*      */ 
/*      */       
/*  640 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(64.0F, 64.0F);
/*  641 */       image.setPosition(568.0F, 566.0F);
/*  642 */       if (j < 2) {
/*  643 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */       } else {
/*  645 */         image.setColor(MaterialColor.AMBER.P400);
/*  646 */         image.setOrigin(32.0F, 32.0F);
/*  647 */         image.addAction((Action)Actions.sequence(
/*  648 */               (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  649 */               (Action)Actions.delay(0.6F), 
/*  650 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F, (Interpolation)Interpolation.swingOut)));
/*      */       } 
/*      */       
/*  653 */       this.e.addActor((Actor)image);
/*      */ 
/*      */       
/*  656 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(48.0F, 48.0F);
/*  657 */       image.setPosition(632.0F, 566.0F);
/*  658 */       if (j < 3) {
/*  659 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */       } else {
/*  661 */         image.setColor(MaterialColor.AMBER.P400);
/*  662 */         image.setOrigin(24.0F, 24.0F);
/*  663 */         image.addAction((Action)Actions.sequence(
/*  664 */               (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  665 */               (Action)Actions.delay(1.2F), 
/*  666 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F, (Interpolation)Interpolation.swingOut)));
/*      */       } 
/*      */       
/*  669 */       this.e.addActor((Actor)image);
/*      */       
/*  671 */       if (j > 0) {
/*      */         ParticleEffectPool particleEffectPool;
/*      */         
/*      */         ParticleEffectPool.PooledEffect pooledEffect;
/*  675 */         ((ParticleEmitter)(pooledEffect = (ParticleEffectPool.PooledEffect)(particleEffectPool = Game.i.assetManager.getParticleEffectPool("game-over-stars.prt")).obtain()).getEmitters().first()).setMinParticleCount(8);
/*  676 */         ((ParticleEmitter)pooledEffect.getEmitters().first()).setMaxParticleCount(8);
/*  677 */         particlesCanvas.addParticle((ParticleEffect)pooledEffect, 24.0F, 24.0F);
/*      */         
/*  679 */         if (j >= 2) {
/*  680 */           Timer.schedule(new Timer.Task(this, particleEffectPool, particlesCanvas)
/*      */               {
/*      */                 public void run() {
/*      */                   ParticleEffectPool.PooledEffect pooledEffect;
/*  684 */                   ((ParticleEmitter)(pooledEffect = (ParticleEffectPool.PooledEffect)this.a.obtain()).getEmitters().first()).setMinParticleCount(16);
/*  685 */                   ((ParticleEmitter)pooledEffect.getEmitters().first()).setMaxParticleCount(16);
/*  686 */                   this.b.addParticle((ParticleEffect)pooledEffect, 80.0F, 32.0F);
/*      */                 }
/*      */               }0.6F);
/*      */         }
/*  690 */         if (j >= 3) {
/*  691 */           Timer.schedule(new Timer.Task(this, particleEffectPool, particlesCanvas)
/*      */               {
/*      */                 public void run() {
/*      */                   ParticleEffectPool.PooledEffect pooledEffect;
/*  695 */                   ((ParticleEmitter)(pooledEffect = (ParticleEffectPool.PooledEffect)this.a.obtain()).getEmitters().first()).setMinParticleCount(24);
/*  696 */                   ((ParticleEmitter)pooledEffect.getEmitters().first()).setMaxParticleCount(24);
/*  697 */                   this.b.addParticle((ParticleEffect)pooledEffect, 136.0F, 24.0F);
/*      */                 }
/*      */               }1.2F);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  705 */     Game.i.researchManager.updateAfforableResearchesCount();
/*      */     int k;
/*  707 */     if ((k = Game.i.researchManager.getAfforableResearchesCount()) > 0) {
/*      */       Image image;
/*      */       
/*  710 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setPosition(129.0F, 98.0F);
/*  711 */       image.setSize(32.25F, 36.75F);
/*  712 */       this.z.addActor((Actor)image);
/*      */       
/*      */       Label label;
/*  715 */       (label = new Label(k, Game.i.assetManager.getLabelStyle(18))).setAlignment(1);
/*  716 */       label.setSize(23.0F, 13.0F);
/*  717 */       label.setPosition(133.0F, 110.0F);
/*  718 */       this.z.addActor((Actor)label);
/*      */     } 
/*      */     
/*      */     BasicLevel basicLevel;
/*  722 */     if ((basicLevel = a()) != null) {
/*  723 */       this.y.setText(Game.i.localeManager.i18n.get("level") + " " + basicLevel.name);
/*  724 */       this.x.setEnabled(Game.i.basicLevelManager.isOpened(basicLevel));
/*      */     } else {
/*  726 */       this.x.setEnabled(false);
/*      */     } 
/*      */ 
/*      */     
/*  730 */     this.l.setVisible(false);
/*  731 */     this.m.setVisible(false);
/*      */     
/*  733 */     if (this.E.statistics.getCurrentGameStatistic(StatisticsType.PT) > 10.0D)
/*      */     {
/*  735 */       if ((this.E.gameState.difficultyMode == DifficultyMode.NORMAL || DifficultyMode.isEndless(this.E.gameState.difficultyMode)) && Game.i.authManager.isSignedIn() && this.E.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS && !(Game.i.basicLevelManager.getLevel(this.E.gameState.basicLevelName)).dailyQuest) {
/*      */         
/*  737 */         this.l.setVisible(true);
/*  738 */         Game.i.leaderBoardManager.getLeaderboardsAdvanceRank(GameStateSystem.GameMode.BASIC_LEVELS, this.E.gameState.difficultyMode, this.E.gameState.basicLevelName, ReplayManager.LeaderboardsMode.score, this.E.gameState.getScore(), paramLeaderboardsRankResult -> {
/*      */               float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*      */               
/*      */               this.n.setText(String.valueOf(paramLeaderboardsRankResult.rank));
/*      */               
/*      */               if (paramLeaderboardsRankResult.success) {
/*      */                 this.o.setText(" / " + paramLeaderboardsRankResult.total);
/*      */                 
/*      */                 if (paramLeaderboardsRankResult.rank == 1) {
/*      */                   this.p.setText(Game.i.localeManager.i18n.get("leader") + "!");
/*      */                 } else {
/*      */                   int i;
/*      */                   
/*      */                   if ((i = MathUtils.ceil(paramLeaderboardsRankResult.rank / paramLeaderboardsRankResult.total * 100.0F)) <= 0) {
/*      */                     i = 1;
/*      */                   }
/*      */                   
/*      */                   if (i > 100) {
/*      */                     i = 100;
/*      */                   }
/*      */                   
/*      */                   this.p.setText(Game.i.localeManager.i18n.format("top_percent", new Object[] { Integer.valueOf(i) }));
/*      */                 } 
/*      */                 
/*      */                 this.l.setVisible(false);
/*      */                 
/*      */                 this.m.clearActions();
/*      */                 
/*      */                 this.m.setVisible(true);
/*      */                 
/*      */                 this.m.setTransform(true);
/*      */                 
/*      */                 this.m.addAction((Action)Actions.sequence((Action)Actions.scaleTo(0.0F, 0.0F), (Action)Actions.parallel((Action)Actions.sequence((Action)Actions.delay(0.1F * f), (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), (Action)Actions.run(())));
/*      */                 return;
/*      */               } 
/*      */               this.l.setVisible(false);
/*      */               this.m.setVisible(false);
/*      */             });
/*      */       } 
/*      */     }
/*  778 */     this.f.clear();
/*      */     
/*  780 */     if (paramArray.size != 0) {
/*  781 */       float f1 = 1.0F + (float)this.E.gameValue.getPercentValueAsMultiplier(GameValueType.GREEN_PAPERS_BONUS);
/*  782 */       float f2 = 1.0F;
/*      */       
/*  784 */       if (Game.i.progressManager.isDoubleGainEnabled()) {
/*  785 */         f1 *= 2.0F;
/*  786 */         f2 = 2.0F;
/*      */       } 
/*      */       
/*  789 */       if (this.E.gameState.isDailyQuestAndNotCompleted()) {
/*  790 */         f1 *= 0.1F;
/*  791 */         f2 *= 0.1F;
/*      */       } 
/*      */       
/*  794 */       String str1 = Game.i.localeManager.i18n.get("received_items").toUpperCase();
/*  795 */       if (f1 != 1.0F || f2 != 1.0F) {
/*  796 */         str1 = str1 + " ( ";
/*  797 */         if (f1 != 1.0F) {
/*  798 */           str1 = str1 + "[#66BB6A]<@icon-money>x" + (StrictMath.round(f1 * 100.0F) / 100.0F) + "[]";
/*      */         }
/*  800 */         if (f2 != 1.0F) {
/*  801 */           str1 = str1 + " [#29B6F6]<@icon-cubes-stacked>x" + (StrictMath.round(f2 * 100.0F) / 100.0F) + "[]";
/*      */         }
/*  803 */         str1 = str1 + " )";
/*      */       } 
/*      */       
/*      */       Label label;
/*  807 */       (label = new Label(Game.i.assetManager.replaceRegionAliasesWithChars(str1), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setAlignment(1);
/*  808 */       this.f.add((Actor)label).padBottom(16.0F).padTop(24.0F).row();
/*      */       
/*  810 */       Table table = new Table();
/*  811 */       this.f.add((Actor)table);
/*      */       
/*  813 */       k = 0;
/*  814 */       byte b3 = 0;
/*      */       Array array;
/*  816 */       (array = new Array(paramArray)).sort(ProgressManager.ITEM_RARITY_COMPARATOR);
/*      */       
/*  818 */       f1 = 0.25F;
/*  819 */       byte b1 = 0;
/*  820 */       for (byte b2 = 0; b2 < array.size; b2++) {
/*  821 */         GameOverItemStack gameOverItemStack = (GameOverItemStack)array.get(b2);
/*      */         
/*  823 */         ItemCell itemCell = new ItemCell();
/*  824 */         this.I.add(itemCell);
/*  825 */         itemCell.setColRow(k, b3);
/*  826 */         itemCell.setItemStack(gameOverItemStack);
/*  827 */         itemCell.setCovered(gameOverItemStack.covered);
/*  828 */         itemCell.addListener((EventListener)new ClickListener(this, gameOverItemStack)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  831 */                 ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/*      */               }
/*      */             });
/*  834 */         if (gameOverItemStack.isDailyLoot || gameOverItemStack.isDoubled) {
/*  835 */           if (gameOverItemStack.isDailyLoot)
/*      */           {
/*  837 */             itemCell.setSelected(true);
/*      */           }
/*      */           
/*  840 */           if (gameOverItemStack.isDailyLoot) {
/*      */             
/*  842 */             itemCell.setCornerText(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-calendar>"));
/*      */           } else {
/*      */             
/*  845 */             itemCell.setCornerText("x2");
/*      */           } 
/*      */         } 
/*  848 */         table.add((Actor)itemCell);
/*  849 */         k++;
/*  850 */         if (k == 8) {
/*  851 */           k = 0;
/*  852 */           table.row();
/*  853 */           b3++;
/*      */         } 
/*      */         
/*  856 */         if (gameOverItemStack.covered) {
/*  857 */           itemCell.addAction((Action)Actions.sequence(
/*  858 */                 (Action)Actions.delay(f1), 
/*  859 */                 (Action)Actions.run(() -> paramItemCell.reveal())));
/*      */           
/*      */           float f;
/*      */           
/*  863 */           if ((f = 0.6F - b1 * 0.05F) < 0.05F) {
/*  864 */             f = 0.05F;
/*      */           }
/*  866 */           f1 += f;
/*  867 */           b1++;
/*      */         } else {
/*  869 */           itemCell.shine(true, false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  874 */     this.f.row();
/*  875 */     this.f.add().height(100.0F).width(1.0F);
/*      */ 
/*      */     
/*  878 */     this.G = paramArray;
/*      */     IssuedItems issuedItems;
/*  880 */     if ((issuedItems = b()).items.size > 0) {
/*  881 */       if (Game.i.progressManager.isPremiumStatusActive()) {
/*  882 */         this.u.setVisible(false);
/*      */         
/*  884 */         (ProgressPrefs.i()).progress.registerVideoWatched();
/*  885 */         ProgressPrefs.i().requireSave();
/*      */         
/*  887 */         c();
/*  888 */         Notifications.i().add(Game.i.localeManager.i18n.get("end_game_auto_reward_received"), (Drawable)Game.i.assetManager.getDrawable("icon-crown"), MaterialColor.LIGHT_GREEN.P800, StaticSoundType.SUCCESS);
/*      */       }
/*  890 */       else if (!this.H && this.E.statistics
/*      */ 
/*      */         
/*  893 */         .getCurrentGameStatistic(StatisticsType.PRT) > 120.0D && Game.i.purchaseManager
/*  894 */         .canShowRewardingAd(PurchaseManager.RewardingAdsType.END_GAME)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  899 */         this.u.setVisible(true);
/*      */       } else {
/*  901 */         this.u.setVisible(false);
/*      */       } 
/*      */       
/*      */       Table table;
/*      */       
/*  906 */       (table = new Table()).setSize(91.0F, 320.0F);
/*  907 */       table.setPosition(12.0F, 110.0F);
/*  908 */       this.u.addActor((Actor)table);
/*      */       
/*  910 */       table.add().width(1.0F).growY().row();
/*      */       
/*  912 */       for (int m = issuedItems.items.size - 1; m >= 0; m--) {
/*      */         ResourceItem resourceItem; ItemStack itemStack;
/*  914 */         Actor actor = (itemStack = (ItemStack)issuedItems.items.get(m)).getItem().generateIcon(32.0F, false);
/*  915 */         Label label = new Label((CharSequence)StringFormatter.compactNumber(itemStack.getCount(), false), Game.i.assetManager.getLabelStyle(18));
/*  916 */         switch (null.a[itemStack.getItem().getType().ordinal()]) { case 1:
/*  917 */             label.setColor(MaterialColor.GREEN.P500); break;
/*      */           case 2:
/*  919 */             resourceItem = (ResourceItem)itemStack.getItem();
/*  920 */             label.setColor(Game.i.resourceManager.getColor(resourceItem.resourceType));
/*      */             break; }
/*      */ 
/*      */         
/*  924 */         label.setAlignment(16);
/*  925 */         table.add((Actor)label).growX().height(32.0F).padBottom(16.0F).padRight(8.0F);
/*  926 */         table.add(actor).size(32.0F).padBottom(14.0F).row();
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  931 */     this.t.clear();
/*  932 */     if (paramMapPrestigeConfig != null) {
/*      */       ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  956 */       (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> { if (this.d == null) { this.d = new MapPrestigeOverlay(); this.d.listeners.add(new MapPrestigeOverlay.MapPrestigeOverlayListener(this) { public void prestigeConfirmed() { GameOverOverlay.b(this.a).setEnabled(false); } public boolean affectsGameState() { return false; } public int getConstantId() { return 0; } }); }  this.d.show(paramMapPrestigeConfig); })).setBackground((Drawable)Game.i.assetManager.getQuad("ui.gameOverOverlay.prestigeButton"), 0.0F, 0.0F, 117.0F, 100.0F);
/*  957 */       complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-dollar"), 34.0F, 16.0F, 64.0F, 64.0F);
/*  958 */       complexButton.setSize(117.0F, 100.0F);
/*  959 */       this.t.addActor((Actor)complexButton);
/*      */       
/*      */       Label label;
/*  962 */       (label = new Label(paramMapPrestigeConfig.getTotalBonus() + "%", Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/*  963 */       label.setColor(MaterialColor.LIGHT_BLUE.P300);
/*  964 */       label.setSize(100.0F, 20.0F);
/*  965 */       label.setPosition(11.0F, 124.0F);
/*  966 */       this.t.addActor((Actor)label);
/*      */       
/*  968 */       int m = paramMapPrestigeConfig.getCrownsCount();
/*  969 */       int[][] arrayOfInt = { { 45, 162, 32 }, { 41, 200, 40 }, { 37, 245, 48 }, { 33, 295, 56 }, { 29, 351, 64 } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  976 */       for (k = 0; k < 5; k++) {
/*  977 */         int n = k + 1;
/*      */         
/*      */         Image image;
/*  980 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"))).setPosition(arrayOfInt[k][0], arrayOfInt[k][1]);
/*  981 */         image.setSize(arrayOfInt[k][2], arrayOfInt[k][2]);
/*  982 */         if (m >= n) {
/*  983 */           image.setColor(MaterialColor.LIGHT_BLUE.P500);
/*      */         } else {
/*  985 */           image.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*      */         } 
/*  987 */         this.t.addActor((Actor)image);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  992 */     this.A.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  993 */     this.A.addAction((Action)Actions.sequence(
/*  994 */           (Action)Actions.delay(0.5F), 
/*  995 */           (Action)Actions.alpha(1.0F, 0.75F)));
/*      */     
/*  997 */     e();
/*      */     
/*  999 */     a(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void e() {
/* 1004 */     if (this.D == -1) {
/* 1005 */       i = FastRandom.getFairInt(HINT_ALIASES.length);
/*      */     
/*      */     }
/* 1008 */     else if ((i = this.D + 1) >= HINT_ALIASES.length) {
/* 1009 */       i = 0;
/*      */     } 
/*      */     
/* 1012 */     this.D = i;
/*      */     
/* 1014 */     this.B.clearActions();
/* 1015 */     int i = i;
/* 1016 */     this.B.addAction((Action)Actions.sequence(
/* 1017 */           (Action)Actions.fadeOut(0.3F), 
/* 1018 */           (Action)Actions.run(() -> {
/*      */               String str2 = HINT_ALIASES[paramInt];
/*      */               
/*      */               CharSequence charSequence = Game.i.assetManager.replaceRegionAliasesWithChars(Game.i.localeManager.i18n.get(str2));
/*      */               
/*      */               this.B.setSize(900.0F, 84.0F);
/*      */               
/*      */               this.B.setPosition(150.0F, 2.0F);
/*      */               
/*      */               float f;
/*      */               
/*      */               if ((f = StringFormatter.calculateWidth(charSequence, (BitmapFont)Game.i.assetManager.getFont(24))) < 1620.0D) {
/*      */                 this.B.setStyle(Game.i.assetManager.getLabelStyle(24));
/*      */               } else {
/*      */                 this.B.setStyle(Game.i.assetManager.getLabelStyle(21));
/*      */                 if ((f = StringFormatter.calculateWidth(charSequence, (BitmapFont)Game.i.assetManager.getFont(21))) > 1620.0D) {
/*      */                   this.B.setSize(1200.0F, 84.0F);
/*      */                   this.B.setPosition(0.0F, 2.0F);
/*      */                 } 
/*      */               } 
/*      */               this.B.setText(charSequence);
/*      */               String str1 = (paramInt + 1) + "/" + HINT_ALIASES.length;
/*      */               str1 = Game.i.localeManager.i18n.format("hint_box_stats", new Object[] { str1 });
/*      */               this.C.setText(str1);
/* 1042 */             }), (Action)Actions.fadeIn(0.5F)));
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1047 */     if (paramBoolean) {
/* 1048 */       UiUtils.bouncyShowOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.e); return;
/*      */     } 
/* 1050 */     UiUtils.bouncyHideOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.e);
/*      */   }
/*      */ 
/*      */   
/*      */   public void minimize() {
/* 1055 */     this.E._input.enableAllInput();
/*      */     
/* 1057 */     GameUiSystem.ScreenshotModeConfig screenshotModeConfig = new GameUiSystem.ScreenshotModeConfig();
/* 1058 */     this.E._gameUi.setUiScreenshotMode(screenshotModeConfig);
/*      */     
/* 1060 */     a(false);
/*      */   }
/*      */   
/*      */   public void maximize() {
/* 1064 */     a(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1069 */     this.F = true;
/* 1070 */     if (this.d != null) {
/* 1071 */       this.d.dispose();
/*      */     }
/* 1073 */     Game.i.uiManager.removeLayer(this.b);
/* 1074 */     Game.i.uiManager.removeLayer(this.c);
/*      */   }
/*      */   
/*      */   public boolean isDisposed() {
/* 1078 */     return this.F;
/*      */   }
/*      */   
/*      */   public static class GameOverItemStack extends ItemStack {
/*      */     public boolean isDailyLoot;
/*      */     public boolean isDoubled;
/*      */     
/*      */     public GameOverItemStack(ItemStack param1ItemStack) {
/* 1086 */       super(param1ItemStack);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\GameOverOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */