/*      */ package com.prineside.tdi2.ui.components;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.MapPrestigeConfig;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.BaseHealthChange;
/*      */ import com.prineside.tdi2.events.game.BonusPointsUpdate;
/*      */ import com.prineside.tdi2.events.game.BonusSelect;
/*      */ import com.prineside.tdi2.events.game.BonusStagesConfigSet;
/*      */ import com.prineside.tdi2.events.game.CoinsChange;
/*      */ import com.prineside.tdi2.events.game.ForceWaveAvailabilityChange;
/*      */ import com.prineside.tdi2.events.game.GameSpeedChange;
/*      */ import com.prineside.tdi2.events.game.MapDrawModeChange;
/*      */ import com.prineside.tdi2.events.game.MdpsUpdate;
/*      */ import com.prineside.tdi2.events.game.RewardingAdBecameAvailable;
/*      */ import com.prineside.tdi2.events.game.RewardingAdRegistered;
/*      */ import com.prineside.tdi2.events.game.ScoreChange;
/*      */ import com.prineside.tdi2.events.game.WaveStatusChange;
/*      */ import com.prineside.tdi2.events.global.ScreenResize;
/*      */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.BonusSystem;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.systems.GameUiSystem;
/*      */ import com.prineside.tdi2.systems.WaveSystem;
/*      */ import com.prineside.tdi2.ui.actors.ButtonHoldHint;
/*      */ import com.prineside.tdi2.ui.actors.GameplayBonusSummary;
/*      */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Objects;
/*      */ 
/*      */ public class MainUi implements Disposable {
/*   66 */   private static final TLog a = TLog.forClass(MainUi.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   73 */   private static final Rectangle b = new Rectangle(160.0F, 16.0F, 128.0F, 144.0F);
/*   74 */   private static final Rectangle c = new Rectangle(480.0F, 79.0F, 160.0F, 48.0F);
/*   75 */   private static final Rectangle d = new Rectangle(640.0F, 79.0F, 160.0F, 48.0F);
/*   76 */   private static final Rectangle e = new Rectangle(324.0F, 35.0F, 156.0F, 40.0F);
/*   77 */   private static final Rectangle f = new Rectangle(324.0F, -6.0F, 156.0F, 40.0F);
/*   78 */   private static final Rectangle g = new Rectangle(0.0F, 0.0F, 192.0F, 192.0F);
/*   79 */   private static final Rectangle h = new Rectangle(270.0F, 100.0F, 112.0F, 112.0F);
/*   80 */   private static final Rectangle i = new Rectangle(320.0F, 79.0F, 160.0F, 48.0F);
/*   81 */   private static final Rectangle j = new Rectangle(192.0F, 0.0F, 128.0F, 128.0F);
/*      */   
/*   83 */   private final UiManager.UiLayer k = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "MainUi particles");
/*   84 */   private final UiManager.UiLayer l = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "MainUi custom elements");
/*   85 */   private final UiManager.UiLayer m = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "MainUi");
/*   86 */   private final UiManager.UiLayer n = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "MainUi boss hp lines");
/*      */   
/*      */   private GameSystemProvider o;
/*      */   
/*      */   public ParticlesCanvas particlesCanvas;
/*      */   
/*      */   public Group customElementsContainer;
/*      */   
/*      */   private final Label p;
/*      */   
/*      */   private final Label q;
/*      */   
/*      */   private final Label r;
/*      */   
/*      */   private final Label s;
/*      */   
/*      */   private final Group t;
/*      */   private final Group u;
/*      */   private final Label v;
/*      */   private final Image w;
/*      */   private final Label x;
/*      */   private final Table y;
/*      */   private final Actor z;
/*      */   private int A;
/*      */   private final PaddedImageButton B;
/*      */   private boolean C;
/*      */   private final Image D;
/*      */   private final Image E;
/*      */   private final Label F;
/*      */   private final Label G;
/*      */   private final Image H;
/*      */   private final Image I;
/*      */   private final Image J;
/*      */   private final PaddedImageButton K;
/*      */   private final PaddedImageButton L;
/*      */   private int M;
/*      */   private int N;
/*  123 */   private static final StringBuilder O = new StringBuilder();
/*      */   private final PaddedImageButton P;
/*      */   private final Group Q;
/*      */   private final Group R;
/*      */   private final Group S;
/*      */   private final Group T;
/*      */   private final Group U;
/*      */   private final Group V;
/*      */   private final Group W;
/*      */   private final PaddedImageButton X;
/*      */   private final Image Y;
/*      */   public GameplayBonusSummary gameplayBonusGroup;
/*      */   public Table bossHpLinesTable;
/*  136 */   public Array<BossHpBar> bossHpBars = new Array(true, 1, BossHpBar.class);
/*      */   
/*      */   private final Image Z;
/*      */   
/*      */   private final ParticlesCanvas aa;
/*      */   
/*      */   private final ParticleEffect ab;
/*      */   
/*      */   private final Drawable ac;
/*      */   private final Drawable ad;
/*      */   private final Drawable ae;
/*      */   private final Drawable af;
/*      */   private boolean ag;
/*      */   private float ah;
/*      */   private boolean ai;
/*      */   private float aj;
/*  152 */   private int ak = -1;
/*      */ 
/*      */   
/*      */   private final Listener<ScreenResize> al;
/*      */   
/*  157 */   private final Runnable am = this::updateMdps;
/*  158 */   private final Runnable an = this::updateScore;
/*  159 */   private final Runnable ao = this::updateMoney;
/*  160 */   private final Runnable ap = this::updateHealth;
/*  161 */   private final Runnable aq = this::updateWave;
/*  162 */   private final Runnable ar = this::updateGameSpeedButton;
/*  163 */   private final Runnable as = this::updateForceWaveButton;
/*  164 */   private final Runnable at = this::a;
/*      */   
/*      */   public MainUi(GameSystemProvider paramGameSystemProvider) {
/*  167 */     this.o = paramGameSystemProvider;
/*      */     
/*  169 */     this.ai = TooltipsOverlay.i().isTagShown("MainUi.detailedMode");
/*  170 */     if (paramGameSystemProvider.gameState.basicLevelName != null && paramGameSystemProvider.gameState.basicLevelName.startsWith("0.")) {
/*  171 */       this.ai = true;
/*      */     }
/*  173 */     a.i("detailedModeTooltipDisabled " + this.ai, new Object[0]);
/*      */ 
/*      */     
/*  176 */     this.particlesCanvas = new ParticlesCanvas();
/*  177 */     this.k.getTable().add((Actor)this.particlesCanvas).expand().fill();
/*  178 */     this.k.getTable().setTouchable(Touchable.disabled);
/*      */     
/*  180 */     this.customElementsContainer = new Group();
/*  181 */     this.customElementsContainer.setTransform(false);
/*  182 */     this.l.getTable().add((Actor)this.customElementsContainer).expand().fill();
/*  183 */     this.l.getTable().setTouchable(Touchable.disabled);
/*      */     
/*  185 */     this.al = (paramScreenResize -> {
/*      */         this.particlesCanvas.setSize(Game.i.uiManager.viewport.getWorldWidth(), Game.i.uiManager.viewport.getWorldHeight());
/*      */         
/*      */         this.customElementsContainer.setSize(Game.i.uiManager.viewport.getWorldWidth(), Game.i.uiManager.viewport.getWorldHeight());
/*      */       });
/*  190 */     Game.EVENTS.getListeners(ScreenResize.class).add(this.al);
/*      */     
/*      */     Table table1;
/*      */     
/*  194 */     (table1 = this.m.getTable()).setName("main_game_ui");
/*      */     
/*      */     Group group;
/*  197 */     (group = new Group()).setTransform(false);
/*  198 */     group.setSize(840.0F, 160.0F);
/*  199 */     group.setTouchable(Touchable.childrenOnly);
/*  200 */     table1.add((Actor)group).expand().top().left().row();
/*      */ 
/*      */     
/*      */     PaddedImageButton paddedImageButton;
/*      */ 
/*      */     
/*  206 */     (paddedImageButton = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-pause"), () -> paramGameSystemProvider.gameState.pauseGame(), Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600)).setIconPosition(32.0F, 32.0F).setIconSize(96.0F, 96.0F)).setName("game_pause_button");
/*  207 */     paddedImageButton.setSize(160.0F, 160.0F);
/*  208 */     group.addActor((Actor)paddedImageButton);
/*      */     
/*  210 */     this.aa = new ParticlesCanvas();
/*  211 */     this.aa.setPosition(117.0F, 46.0F);
/*  212 */     this.aa.setSize(1.0F, 1.0F);
/*  213 */     this.aa.setVisible(false);
/*  214 */     paddedImageButton.addActor((Actor)this.aa);
/*      */     
/*  216 */     this.ab = new ParticleEffect();
/*  217 */     this.ab.load(Gdx.files.internal("particles/pause-menu-ad-icon.prt"), Game.i.assetManager.getTextureRegion("particle-snowflake").getAtlas());
/*  218 */     this.ab.setEmittersCleanUpBlendFunction(false);
/*      */     
/*  220 */     this.Z = new Image((Drawable)Game.i.assetManager.getDrawable("ui-pause-button-video-ad-icon"));
/*  221 */     this.Z.setSize(48.0F, 48.0F);
/*  222 */     this.Z.setOrigin(24.0F, 24.0F);
/*  223 */     this.Z.setPosition(93.0F, 38.0F);
/*  224 */     this.Z.setTouchable(Touchable.disabled);
/*  225 */     this.Z.setVisible(false);
/*  226 */     paddedImageButton.addActor((Actor)this.Z);
/*      */ 
/*      */     
/*  229 */     this
/*      */       
/*  231 */       .P = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-easel"), () -> paramGameSystemProvider._mapRendering.switchMapDrawMode(), Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600)).setIconPosition(16.0F, 16.0F).setIconSize(96.0F, 96.0F);
/*  232 */     this.P.setName("map_draw_mode_button");
/*  233 */     this.P.setOrigin(b.width / 2.0F, b.height / 2.0F);
/*  234 */     this.P.setSize(b.width, b.height);
/*  235 */     this.P.setPosition(b.x, b.y);
/*      */     
/*  237 */     paramGameSystemProvider.events.getListeners(MapDrawModeChange.class).add(paramMapDrawModeChange -> {
/*      */           if (paramGameSystemProvider.gameState.basicLevelName == null || !paramGameSystemProvider.gameState.basicLevelName.startsWith("0.")) {
/*      */             TooltipsOverlay.i().markTagShown("MainUi.detailedMode");
/*      */           }
/*      */           TooltipsOverlay.i().hideEntry("MainUi.detailedMode");
/*      */           this.ai = true;
/*  243 */         }).setDescription("MainUi - hides detailed mode tooltip");
/*      */     
/*  245 */     if (HotKeyHintLabel.isEnabled()) {
/*  246 */       HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.SWITCH_DRAW_MODE), 64.0F, 112.0F);
/*  247 */       this.P.addActor((Actor)hotKeyHintLabel);
/*      */     } 
/*      */     
/*  250 */     group.addActor((Actor)this.P);
/*      */ 
/*      */     
/*  253 */     this.T = new Group();
/*  254 */     this.T.setTransform(false);
/*  255 */     this.T.setPosition(e.x, e.y);
/*  256 */     this.T.setSize(e.width, e.height);
/*  257 */     this.T.setOrigin(e.width / 2.0F, e.height / 2.0F);
/*  258 */     group.addActor((Actor)this.T);
/*      */     
/*  260 */     this.Y = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star-hollow"));
/*  261 */     this.Y.setPosition(0.0F, 0.0F);
/*  262 */     this.Y.setSize(40.0F, 40.0F);
/*  263 */     this.Y.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  264 */     this.T.addActor((Actor)this.Y);
/*      */     
/*      */     Table table2;
/*  267 */     (table2 = new Table()).setSize(400.0F, 40.0F);
/*  268 */     this.T.addActor((Actor)table2);
/*      */     
/*  270 */     this.p = new Label("000", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  271 */     this.p.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  272 */     table2.add((Actor)this.p).top().left().padLeft(56.0F).height(40.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  278 */     if (paramGameSystemProvider.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS && Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.PRESTIGE_MODE)) {
/*      */       Image image;
/*      */       
/*  281 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"))).setColor(MaterialColor.AMBER.P500);
/*  282 */       table2.add((Actor)image).size(40.0F).padLeft(32.0F);
/*      */       
/*      */       Label label;
/*  285 */       (label = new Label((CharSequence)StringFormatter.commaSeparatedNumber(MapPrestigeConfig.getMaxPrestigeScore(paramGameSystemProvider.gameState.averageDifficulty, paramGameSystemProvider.map.getMap().getTargetTileOrThrow().isUseStockGameValues())), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(MaterialColor.AMBER.P500);
/*  286 */       table2.add((Actor)label).top().left().padLeft(16.0F).height(40.0F);
/*      */     } 
/*      */     
/*  289 */     table2.add().height(40.0F).expandX().fillX();
/*      */ 
/*      */     
/*  292 */     this.U = new Group();
/*  293 */     this.U.setTransform(false);
/*  294 */     this.U.setPosition(f.x, f.y);
/*  295 */     this.U.setSize(f.width, f.height);
/*  296 */     this.U.setOrigin(f.width / 2.0F, f.height / 2.0F);
/*  297 */     group.addActor((Actor)this.U);
/*      */     
/*      */     Image image3;
/*  300 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-mdps"))).setPosition(0.0F, 0.0F);
/*  301 */     image3.setSize(40.0F, 40.0F);
/*  302 */     image3.setColor(MaterialColor.PURPLE.P300);
/*  303 */     this.U.addActor((Actor)image3);
/*      */     
/*  305 */     this.q = new Label("0", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  306 */     this.q.setColor(MaterialColor.PURPLE.P300);
/*  307 */     this.q.setPosition(56.0F, 0.0F);
/*  308 */     this.q.setSize(100.0F, 40.0F);
/*  309 */     this.U.addActor((Actor)this.q);
/*      */ 
/*      */     
/*  312 */     this.V = new Group();
/*  313 */     this.V.setTransform(false);
/*  314 */     this.V.setPosition(i.x, i.y);
/*  315 */     this.V.setSize(i.width, i.height);
/*  316 */     this.V.setOrigin(i.width / 2.0F, i.height / 2.0F);
/*  317 */     group.addActor((Actor)this.V);
/*      */ 
/*      */     
/*  320 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"))).setPosition(0.0F, 0.0F);
/*  321 */     image3.setSize(48.0F, 48.0F);
/*  322 */     image3.setColor(Color.WHITE);
/*  323 */     this.V.addActor((Actor)image3);
/*      */     
/*  325 */     this.r = new Label("123", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  326 */     this.r.setPosition(60.0F, 0.0F);
/*  327 */     this.r.setSize(100.0F, 48.0F);
/*  328 */     this.V.addActor((Actor)this.r);
/*      */ 
/*      */     
/*  331 */     this.Q = new Group();
/*  332 */     this.Q.setTransform(false);
/*  333 */     this.Q.setPosition(c.x, c.y);
/*  334 */     this.Q.setSize(c.width, c.height);
/*  335 */     this.Q.setOrigin(c.width / 2.0F, c.height / 2.0F);
/*  336 */     group.addActor((Actor)this.Q);
/*      */     
/*      */     Image image2;
/*  339 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("game-ui-health-icon"))).setPosition(0.0F, 0.0F);
/*  340 */     image2.setSize(48.0F, 48.0F);
/*  341 */     this.Q.addActor((Actor)image2);
/*      */     
/*  343 */     this.t = new Group();
/*  344 */     this.t.setTransform(false);
/*  345 */     this.t.setPosition(60.0F, 0.0F);
/*  346 */     this.t.setSize(100.0F, 48.0F);
/*  347 */     this.t.setOrigin(0.0F, 24.0F);
/*  348 */     this.Q.addActor((Actor)this.t);
/*      */     
/*  350 */     this.u = new Group();
/*  351 */     this.u.setTransform(false);
/*  352 */     this.u.setPosition(60.0F, 0.0F);
/*  353 */     this.u.setSize(100.0F, 48.0F);
/*  354 */     this.Q.addActor((Actor)this.u);
/*      */     
/*  356 */     this.s = new Label("456", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  357 */     this.s.setSize(100.0F, 48.0F);
/*  358 */     this.t.addActor((Actor)this.s);
/*      */ 
/*      */     
/*  361 */     this.R = new Group();
/*  362 */     this.R.setTransform(false);
/*  363 */     this.R.setPosition(d.x, d.y);
/*  364 */     this.R.setSize(d.width, d.height);
/*  365 */     this.R.setOrigin(d.width / 2.0F, d.height / 2.0F);
/*  366 */     group.addActor((Actor)this.R);
/*      */ 
/*      */     
/*  369 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("game-ui-coin-icon"))).setPosition(0.0F, 0.0F);
/*  370 */     image2.setSize(48.0F, 48.0F);
/*  371 */     this.R.addActor((Actor)image2);
/*      */     
/*  373 */     this.v = new Label("789", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  374 */     this.v.setPosition(60.0F, 0.0F);
/*  375 */     this.v.setSize(100.0F, 48.0F);
/*  376 */     this.R.addActor((Actor)this.v);
/*      */     
/*  378 */     this.w = new Image((Drawable)Game.i.assetManager.getDrawable("icon-x2"));
/*  379 */     this.w.setSize(40.0F, 40.0F);
/*  380 */     this.w.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  381 */     this.w.setPosition(648.0F, 35.0F);
/*  382 */     this.w.setVisible(false);
/*  383 */     group.addActor((Actor)this.w);
/*      */     
/*  385 */     this.y = new Table();
/*  386 */     this.y.setVisible(false);
/*  387 */     this.y.setPosition(700.0F, 35.0F);
/*  388 */     this.y.setSize(150.0F, 40.0F);
/*  389 */     group.addActor((Actor)this.y);
/*      */     
/*  391 */     this.x = new Label("789", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  392 */     this.x.setColor(MaterialColor.LIGHT_GREEN.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*  393 */     this.x.setAlignment(8);
/*  394 */     this.y.add((Actor)this.x).height(40.0F);
/*      */ 
/*      */     
/*  397 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(MaterialColor.LIGHT_GREEN.P300.cpy().mul(1.0F, 1.0F, 1.0F, 0.21F));
/*  398 */     this.y.add((Actor)image2).size(20.0F).padLeft(4.0F);
/*      */     
/*  400 */     this.y.add().height(1.0F).growX();
/*      */     
/*  402 */     this.z = new Actor();
/*  403 */     this.z.setTouchable(Touchable.enabled);
/*  404 */     this.z.addListener((EventListener)new ClickListener(this, image2)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  407 */             TooltipsOverlay.i().showText("_generic_", (Actor)this.a, Game.i.localeManager.i18n.get("double_multiplier_timer_hint"), (MainUi.a(this.b)).mainUiLayer, (MainUi.a(this.b)).zIndex + 1, 4);
/*      */           }
/*      */ 
/*      */           
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  412 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*  413 */             MainUi.b(this.b).setColor(MaterialColor.LIGHT_GREEN.P300);
/*  414 */             (MainUi.c(this.b).getColor()).a = 1.0F;
/*      */           }
/*      */ 
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  419 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*  420 */             MainUi.b(this.b).setColor(MaterialColor.LIGHT_GREEN.P500);
/*  421 */             (MainUi.c(this.b).getColor()).a = 0.56F;
/*      */           }
/*      */         });
/*  424 */     this.z.setSize(200.0F, 72.0F);
/*  425 */     this.z.setPosition(624.0F, 19.0F);
/*  426 */     group.addActor(this.z);
/*      */ 
/*      */ 
/*      */     
/*  430 */     (group = new Group()).setTransform(false);
/*  431 */     group.setSize(320.0F, 621.0F);
/*  432 */     group.setTouchable(Touchable.childrenOnly);
/*  433 */     table1.add((Actor)group).expand().bottom().left();
/*      */ 
/*      */     
/*  436 */     this.S = new Group();
/*  437 */     this.S.setTransform(false);
/*  438 */     this.S.setPosition(g.x, g.y);
/*  439 */     this.S.setSize(g.width, g.height);
/*  440 */     this.S.setOrigin(g.width / 2.0F, g.height / 2.0F);
/*  441 */     group.addActor((Actor)this.S);
/*      */     
/*  443 */     this.D = new Image((Drawable)Game.i.assetManager.getDrawable("icon-stopwatch"));
/*  444 */     this.D.setPosition(32.0F, 32.0F);
/*  445 */     this.D.setSize(128.0F, 128.0F);
/*  446 */     this.D.setTouchable(Touchable.disabled);
/*  447 */     this.S.addActor((Actor)this.D);
/*      */     
/*  449 */     this.B = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-stopwatch"), null, Color.WHITE, Color.WHITE, Color.WHITE);
/*  450 */     this.B.setName("next_wave_call_button");
/*  451 */     this.B.addListener((EventListener)new InputListener(this, paramGameSystemProvider) {
/*  452 */           private final Timer.Task c = new Timer.Task(this)
/*      */             {
/*      */               public void run() {
/*  455 */                 this.a.a.wave.setAutoForceWaveEnabled(true);
/*  456 */                 this.a.b.updateForceWaveButton();
/*      */                 
/*  458 */                 if (!this.a.a.gameState.isFastForwarding()) {
/*  459 */                   this.a.a._sound.playStatic(StaticSoundType.AUTO_FORCE_WAVE);
/*      */                 }
/*      */                 
/*  462 */                 if (MainUi.null.a(this.a) != null) {
/*  463 */                   (MainUi.null.a(this.a)).disappearing = true;
/*  464 */                   MainUi.null.a(this.a, null);
/*      */                 } 
/*      */               }
/*      */             };
/*      */           private ButtonHoldHint d;
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  471 */             if (param1Int2 == 0) {
/*  472 */               if (this.c.isScheduled()) {
/*  473 */                 this.c.cancel();
/*      */               }
/*  475 */               Timer.schedule(this.c, 0.35F);
/*      */ 
/*      */               
/*  478 */               this.d = new ButtonHoldHint(param1Float1, param1Float2, 0.35F);
/*  479 */               MainUi.d(this.b).addActor((Actor)this.d);
/*  480 */             } else if (param1Int2 == 1) {
/*      */               
/*  482 */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/*  483 */                 if (this.c.isScheduled()) {
/*  484 */                   this.c.cancel();
/*      */                 }
/*  486 */                 this.c.run();
/*      */               } 
/*      */             } 
/*  489 */             return true;
/*      */           }
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  493 */             if (this.c.isScheduled()) {
/*      */               
/*  495 */               if (MainUi.e(this.b) && this.a.wave.isForceWaveAvailable()) this.a.wave.forceNextWaveAction(); 
/*  496 */               this.a.wave.setAutoForceWaveEnabled(false);
/*  497 */               this.b.updateForceWaveButton();
/*      */             } 
/*  499 */             this.c.cancel();
/*      */             
/*  501 */             if (this.d != null) {
/*  502 */               ButtonHoldHint buttonHoldHint = this.d;
/*  503 */               Objects.requireNonNull(buttonHoldHint); Threads.i().postRunnable(buttonHoldHint::remove);
/*  504 */               this.d = null;
/*      */             } 
/*      */           }
/*      */         });
/*  508 */     this.B.setSize(192.0F, 192.0F);
/*  509 */     this.B.setIconSize(128.0F, 128.0F);
/*  510 */     this.B.setIconPosition(32.0F, 32.0F);
/*  511 */     this.B.setDisabledColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*      */     
/*      */     Image image1;
/*  514 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark-white"))).setSize(20.0F, 20.0F);
/*  515 */     image1.setPosition(32.0F, 32.0F);
/*  516 */     this.B.addActor((Actor)image1);
/*      */     
/*  518 */     this.S.addActor((Actor)this.B);
/*      */     
/*  520 */     if (HotKeyHintLabel.isEnabled()) {
/*      */       HotKeyHintLabel hotKeyHintLabel;
/*  522 */       (hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.CALL_WAVE), 96.0F, 12.0F)).addVariant(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_AUTO_WAVE_CALL));
/*  523 */       this.B.addActor((Actor)hotKeyHintLabel);
/*      */     } 
/*      */     
/*  526 */     this.E = new Image((Drawable)Game.i.assetManager.getDrawable("ui-stopwatch-timer-background"));
/*  527 */     this.E.setPosition(119.0F, 32.0F);
/*  528 */     this.E.setSize(42.0F, 42.0F);
/*  529 */     this.E.setTouchable(Touchable.disabled);
/*  530 */     this.S.addActor((Actor)this.E);
/*      */     
/*  532 */     this.F = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  533 */     this.F.setSize(50.0F, 24.0F);
/*  534 */     this.F.setPosition(128.0F, 42.0F);
/*  535 */     this.F.setTouchable(Touchable.disabled);
/*  536 */     this.S.addActor((Actor)this.F);
/*      */     
/*  538 */     this.I = new Image((Drawable)Game.i.assetManager.getDrawable("ui-auto-force-wave-overlay"));
/*  539 */     this.I.setTouchable(Touchable.disabled);
/*  540 */     this.I.setPosition(32.0F, 32.0F);
/*  541 */     this.I.setSize(137.0F, 93.0F);
/*  542 */     this.S.addActor((Actor)this.I);
/*      */     
/*  544 */     this.G = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), MaterialColor.YELLOW.P500));
/*  545 */     this.G.setPosition(0.0F, 166.0F);
/*  546 */     this.G.setSize(113.0F, 32.0F);
/*  547 */     this.G.setTouchable(Touchable.disabled);
/*  548 */     this.G.setAlignment(16);
/*  549 */     this.S.addActor((Actor)this.G);
/*      */     
/*  551 */     this.H = new Image((Drawable)Game.i.assetManager.getDrawable("game-ui-coin-icon"));
/*  552 */     this.H.setPosition(120.0F, 169.0F);
/*  553 */     this.H.setSize(24.0F, 24.0F);
/*  554 */     this.H.setTouchable(Touchable.disabled);
/*  555 */     this.S.addActor((Actor)this.H);
/*      */ 
/*      */     
/*  558 */     this.ac = (Drawable)Game.i.assetManager.getDrawable("icon-speed-pause");
/*  559 */     this.ad = (Drawable)Game.i.assetManager.getDrawable("icon-speed-low");
/*  560 */     this.ae = (Drawable)Game.i.assetManager.getDrawable("icon-speed-medium");
/*  561 */     this.af = (Drawable)Game.i.assetManager.getDrawable("icon-speed-high");
/*      */     
/*  563 */     this.W = new Group();
/*  564 */     this.W.setName("game_speed_toggle_button");
/*  565 */     this.W.setTransform(false);
/*  566 */     this.W.setPosition(j.x, j.y);
/*  567 */     this.W.setSize(j.width, j.height);
/*  568 */     this.W.setOrigin(j.width / 2.0F, j.height / 2.0F);
/*  569 */     group.addActor((Actor)this.W);
/*      */     
/*  571 */     this.J = new Image((Drawable)Game.i.assetManager.getDrawable("icon-speed-pause"));
/*  572 */     this.J.setPosition(32.0F, 32.0F);
/*  573 */     this.J.setSize(96.0F, 96.0F);
/*  574 */     this.J.setTouchable(Touchable.disabled);
/*  575 */     this.W.addActor((Actor)this.J);
/*      */     
/*  577 */     this.K = new PaddedImageButton(this.ad, null, Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600);
/*  578 */     this.K.addListener((EventListener)new InputListener(this, paramGameSystemProvider) {
/*  579 */           private final Timer.Task b = new Timer.Task(this)
/*      */             {
/*      */               public void run() {
/*  582 */                 float f = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SLOW_MOTION_PAUSE) == 0.0D) ? 0.0F : 0.0667F;
/*  583 */                 this.a.a.gameState.setGameSpeed(f);
/*      */                 
/*  585 */                 if (MainUi.null.a(this.a) != null) {
/*      */                   
/*  587 */                   (MainUi.null.a(this.a)).disappearing = true;
/*  588 */                   MainUi.null.a(this.a, null);
/*      */                 } 
/*      */               }
/*      */             };
/*      */           
/*      */           private ButtonHoldHint c;
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  596 */             if (param1Int2 == 0) {
/*  597 */               if (this.b.isScheduled()) {
/*  598 */                 this.b.cancel();
/*      */               }
/*  600 */               Timer.schedule(this.b, 0.25F);
/*  601 */               this.c = new ButtonHoldHint(param1Float1, param1Float2, 0.25F);
/*  602 */               MainUi.f(this.d).addActor((Actor)this.c);
/*  603 */             } else if (param1Int2 == 1) {
/*      */               
/*  605 */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/*  606 */                 if (this.b.isScheduled()) {
/*  607 */                   this.b.cancel();
/*      */                 }
/*  609 */                 this.b.run();
/*      */               } 
/*      */             } 
/*      */             
/*  613 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  618 */             if (this.b.isScheduled())
/*      */             {
/*  620 */               this.a.gameState.switchGameSpeed();
/*      */             }
/*  622 */             this.b.cancel();
/*      */             
/*  624 */             if (this.c != null) {
/*  625 */               ButtonHoldHint buttonHoldHint = this.c;
/*  626 */               Objects.requireNonNull(buttonHoldHint); Threads.i().postRunnable(buttonHoldHint::remove);
/*  627 */               this.c = null;
/*      */             } 
/*      */           }
/*      */         });
/*      */     
/*  632 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark-white"))).setSize(20.0F, 20.0F);
/*  633 */     image1.setPosition(7.0F, 32.0F);
/*  634 */     this.K.addActor((Actor)image1);
/*  635 */     this.K.setSize(128.0F, 128.0F);
/*  636 */     this.K.setIconSize(96.0F, 96.0F);
/*  637 */     this.K.setIconPosition(32.0F, 32.0F);
/*  638 */     this.K.setPosition(0.0F, 0.0F);
/*  639 */     this.W.addActor((Actor)this.K);
/*      */     
/*  641 */     if (HotKeyHintLabel.isEnabled()) {
/*      */       HotKeyHintLabel hotKeyHintLabel;
/*  643 */       (hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.PAUSE_GAME), 80.0F, 12.0F)).addVariant(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.SPEED_DOWN));
/*  644 */       hotKeyHintLabel.addVariant(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.SPEED_UP));
/*  645 */       this.K.addActor((Actor)hotKeyHintLabel);
/*      */     } 
/*      */     
/*  648 */     this.L = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-step-forward"), () -> paramGameSystemProvider.gameState.requireUpdate(), Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600);
/*      */ 
/*      */     
/*  651 */     this.L.setSize(112.0F, 92.0F);
/*  652 */     this.L.setIconSize(40.0F, 40.0F);
/*  653 */     this.L.setIconPosition(36.0F, 26.0F);
/*  654 */     this.L.setPosition(270.0F, 120.0F);
/*  655 */     this.L.setVisible(false);
/*  656 */     group.addActor((Actor)this.L);
/*      */ 
/*      */     
/*  659 */     this.X = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-letter"), () -> paramGameSystemProvider._gameUi.storylineMessages.show(), Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P700);
/*  660 */     this.X.setName("story_line_messages_button");
/*  661 */     this.X.setIconPosition(24.0F, 32.0F);
/*  662 */     this.X.setIconSize(64.0F, 64.0F);
/*  663 */     this.X.setSize(h.width, h.height);
/*  664 */     this.X.setPosition(h.x, h.y);
/*  665 */     this.X.setOrigin(h.width / 2.0F, h.height / 2.0F);
/*  666 */     this.X.setVisible(false);
/*  667 */     group.addActor((Actor)this.X);
/*      */ 
/*      */     
/*  670 */     this.gameplayBonusGroup = new GameplayBonusSummary(paramGameSystemProvider);
/*  671 */     this.gameplayBonusGroup.setPosition(360.0F, 40.0F);
/*  672 */     this.gameplayBonusGroup.setVisible(false);
/*  673 */     group.addActor((Actor)this.gameplayBonusGroup);
/*      */ 
/*      */     
/*  676 */     this.bossHpLinesTable = new Table();
/*  677 */     this.bossHpLinesTable.setTouchable(Touchable.disabled);
/*  678 */     this.n.getTable().add((Actor)this.bossHpLinesTable).padTop(120.0F).height(240.0F).width(660.0F).row();
/*  679 */     this.n.getTable().add().width(1.0F).growY();
/*      */ 
/*      */     
/*  682 */     a(false);
/*  683 */     updateAll();
/*      */     
/*  685 */     paramGameSystemProvider.events.getListeners(MdpsUpdate.class).add(paramMdpsUpdate -> Game.i.uiManager.runOnStageActOnce(this.am)).setDescription("MainUi - updates MDPS in UI");
/*  686 */     paramGameSystemProvider.events.getListeners(BonusPointsUpdate.class).add(this::a).setDescription("MainUi - updates bonus menu and shows the overlay if needed");
/*  687 */     paramGameSystemProvider.events.getListeners(BonusSelect.class).add(paramBonusSelect -> updateGameplayBonus()).setDescription("MainUi - updates bonus menu");
/*  688 */     paramGameSystemProvider.events.getListeners(BonusStagesConfigSet.class).add(paramBonusStagesConfigSet -> updateGameplayBonus()).setDescription("MainUi - updates bonus menu");
/*      */     
/*  690 */     paramGameSystemProvider.events.getListeners(ScoreChange.class).add(paramScoreChange -> Game.i.uiManager.runOnStageActOnce(this.an)).setDescription("MainUi - updates score in UI");
/*  691 */     paramGameSystemProvider.events.getListeners(CoinsChange.class).add(paramCoinsChange -> Game.i.uiManager.runOnStageActOnce(this.ao)).setDescription("MainUi - updates coins in UI");
/*  692 */     paramGameSystemProvider.events.getListeners(WaveStatusChange.class).add(paramWaveStatusChange -> Game.i.uiManager.runOnStageActOnce(this.aq));
/*  693 */     paramGameSystemProvider.events.getListeners(ForceWaveAvailabilityChange.class).add(paramForceWaveAvailabilityChange -> Game.i.uiManager.runOnStageActOnce(this.as));
/*  694 */     paramGameSystemProvider.events.getListeners(BaseHealthChange.class).add(paramBaseHealthChange -> Game.i.uiManager.runOnStageActOnce(this.ap)).setDescription("MainUi - updates HP in UI");
/*  695 */     paramGameSystemProvider.events.getListeners(GameSpeedChange.class).add(paramGameSpeedChange -> Game.i.uiManager.runOnStageActOnce(this.ar)).setDescription("MainUi - updates game speed button");
/*  696 */     paramGameSystemProvider.events.getListeners(RewardingAdBecameAvailable.class).add(paramRewardingAdBecameAvailable -> Game.i.uiManager.runOnStageActOnce(this.at)).setDescription("MainUi - updates ad icon");
/*  697 */     paramGameSystemProvider.events.getListeners(RewardingAdRegistered.class).add(paramRewardingAdRegistered -> Game.i.uiManager.runOnStageActOnce(this.at)).setDescription("MainUi - updates ad icon");
/*      */   }
/*      */   
/*      */   private void a(BonusPointsUpdate paramBonusPointsUpdate) {
/*  701 */     updateGameplayBonus();
/*      */     
/*  703 */     if (this.o.gameState.replayMode) {
/*      */       return;
/*      */     }
/*      */     BonusSystem.BonusStage bonusStage;
/*  707 */     if ((Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOW_BONUS_SELECTION_IMMEDIATELY) != 0.0D || (this.o.bonus.getStagesConfig()).forceImmediateSelection) && (
/*      */       
/*  709 */       bonusStage = this.o.bonus.getStageToChooseBonusFor()) != null && 
/*  710 */       this.ak != bonusStage.getNumber()) {
/*  711 */       this.ak = bonusStage.getNumber();
/*      */       
/*  713 */       boolean bool = false; BonusSystem.BonusStage bonusStage1;
/*  714 */       if (this.o.bonus.isAutoSelectionOnSingleBonus() && (
/*      */         
/*  716 */         bonusStage1 = this.o.bonus.getStageToChooseBonusFor()) != null && (bonusStage1.getBonusesToChooseFrom()).size == 1 && ((GameplayMod)bonusStage1.getBonusesToChooseFrom().first()).getNotSatisfiedPreconditions(this.o) == null) {
/*  717 */         this.o.bonus.selectBonusAction(0);
/*  718 */         bool = true;
/*      */       } 
/*      */ 
/*      */       
/*  722 */       if (!bool && 
/*  723 */         !this.o._gameUi.gameplayBonusesOverlay.isVisible()) {
/*  724 */         this.o._gameUi.gameplayBonusesOverlay.show();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBossHpBar(BossHpBar paramBossHpBar) {
/*  733 */     if (!this.bossHpBars.contains(paramBossHpBar, true)) {
/*  734 */       this.bossHpBars.add(paramBossHpBar);
/*  735 */       layoutBossHpBars();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void removeBossHpBar(BossHpBar paramBossHpBar) {
/*  740 */     if (this.bossHpBars.removeValue(paramBossHpBar, true)) {
/*  741 */       layoutBossHpBars();
/*      */     }
/*      */   }
/*      */   
/*      */   public void layoutBossHpBars() {
/*  746 */     this.bossHpLinesTable.clear();
/*  747 */     byte b1 = 0;
/*  748 */     Cell cell = null;
/*  749 */     for (byte b2 = 0; b2 < this.bossHpBars.size; b2++) {
/*  750 */       cell = this.bossHpLinesTable.add((Actor)this.bossHpBars.get(b2));
/*  751 */       b1++;
/*      */       
/*  753 */       if (b1 % 2 == 0) {
/*  754 */         cell.padLeft(36.0F).row();
/*  755 */         this.bossHpLinesTable.add().width(1.0F).height(8.0F).row();
/*      */       } 
/*      */     } 
/*  758 */     if (b1 % 2 == 1) {
/*  759 */       cell.colspan(2);
/*      */     }
/*  761 */     this.bossHpLinesTable.row();
/*  762 */     this.bossHpLinesTable.add().width(1.0F).growY();
/*      */   }
/*      */   
/*      */   public void showHealthDelta(int paramInt) {
/*  766 */     this.t.clearActions();
/*  767 */     this.t.setTransform(true);
/*  768 */     this.t.addAction((Action)Actions.sequence(
/*  769 */           (Action)Actions.scaleTo(1.3F, 1.3F), 
/*  770 */           (Action)Actions.scaleTo(1.0F, 1.0F, 0.25F), 
/*  771 */           (Action)Actions.run(() -> this.t.setTransform(false))));
/*      */ 
/*      */     
/*  774 */     Label label = new Label("0", Game.i.assetManager.getLabelStyle(30));
/*  775 */     if (paramInt <= 0) {
/*  776 */       label.setColor(MaterialColor.GREY.P500);
/*      */     } else {
/*  778 */       label.setText("-" + paramInt);
/*  779 */       label.setColor(MaterialColor.RED.P300);
/*      */     } 
/*  781 */     label.setPosition(0.0F, -18.0F);
/*  782 */     label.addAction((Action)Actions.sequence(
/*  783 */           (Action)Actions.parallel(
/*  784 */             (Action)Actions.moveBy(0.0F, -32.0F, 0.35F), 
/*  785 */             (Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.fadeOut(0.25F), (Action)Actions.removeActor()))));
/*      */ 
/*      */     
/*  788 */     this.u.addActor((Actor)label);
/*      */   }
/*      */   
/*      */   private void a() {
/*  792 */     if (Game.i.progressManager.isPremiumStatusActive()) {
/*  793 */       this.Z.setVisible(false);
/*      */       
/*      */       return;
/*      */     } 
/*  797 */     if (this.o.loot.isRewardingAdAvailableInReality() && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.ENABLE_PAUSE_AD_ICON) != 0.0D) {
/*  798 */       if (!this.Z.isVisible()) {
/*  799 */         this.Z.setVisible(true);
/*  800 */         this.Z.clearActions();
/*  801 */         this.Z.addAction((Action)Actions.parallel(
/*  802 */               (Action)Actions.sequence(
/*  803 */                 (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  804 */                 (Action)Actions.scaleTo(1.0F, 1.0F, 0.2F, (Interpolation)Interpolation.swingOut)), 
/*      */               
/*  806 */               (Action)Actions.forever(
/*  807 */                 (Action)Actions.sequence(
/*  808 */                   (Action)Actions.color(MaterialColor.LIGHT_GREEN.P800, 0.6F), 
/*  809 */                   (Action)Actions.color(MaterialColor.LIGHT_GREEN.P300, 0.4F)))));
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  814 */         this.aa.setVisible(true);
/*  815 */         this.aa.clearActions();
/*  816 */         this.aa.addAction((Action)Actions.sequence(
/*  817 */               (Action)Actions.delay(3.0F), 
/*  818 */               (Action)Actions.fadeOut(1.5F)));
/*      */ 
/*      */         
/*  821 */         this.aa.clearParticles();
/*  822 */         this.aa.addParticle(this.ab, 0.0F, 0.0F); return;
/*      */       } 
/*      */     } else {
/*  825 */       this.Z.clearActions();
/*  826 */       this.Z.setVisible(false);
/*  827 */       this.aa.clearActions();
/*  828 */       this.aa.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void postSetup() {
/*  834 */     if (!this.o.gameValue.getBooleanValue(GameValueType.MDPS_COUNTER)) {
/*  835 */       this.U.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelStarsIcon(int paramInt) {
/*  843 */     this.Y.addAction((Action)Actions.sequence(
/*  844 */           (Action)Actions.parallel(
/*  845 */             (Action)Actions.moveTo(-12.0F, -12.0F, 0.25F, (Interpolation)Interpolation.exp5In), 
/*  846 */             (Action)Actions.sizeTo(64.0F, 64.0F, 0.25F, (Interpolation)Interpolation.exp5In), 
/*  847 */             (Action)Actions.color(MaterialColor.YELLOW.P500, 0.25F)), 
/*      */           
/*  849 */           (Action)Actions.parallel(
/*  850 */             (Action)Actions.moveTo(0.0F, 0.0F, 0.5F, (Interpolation)Interpolation.exp5In), 
/*  851 */             (Action)Actions.sizeTo(40.0F, 40.0F, 0.5F, (Interpolation)Interpolation.exp5In), 
/*  852 */             (Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, 0.56F), 1.0F))));
/*      */ 
/*      */     
/*  855 */     switch (paramInt) { case 0:
/*  856 */         this.Y.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-star-hollow")); break;
/*  857 */       case 1: this.Y.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-star")); break;
/*  858 */       case 2: this.Y.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-two-stars")); break;
/*  859 */       case 3: this.Y.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-three-stars"));
/*      */         break; }
/*      */     
/*  862 */     if (this.o.gameState.basicLevelName != null && !this.o.gameState.basicLevelName.startsWith("0.")) {
/*  863 */       if (paramInt == 1 && 
/*  864 */         !TooltipsOverlay.i().isTagShown("MainUi.oneStar")) {
/*  865 */         TooltipsOverlay.i().showText("MainUi.oneStar", (Actor)this.Y, Game.i.localeManager.i18n.get("tooltip_level_one_star"), this.m.mainUiLayer, this.m.zIndex + 1, 4);
/*      */       }
/*      */       
/*  868 */       if (paramInt == 3 && 
/*  869 */         !TooltipsOverlay.i().isTagShown("MainUi.threeStars")) {
/*  870 */         TooltipsOverlay.i().hideEntry("MainUi.oneStar");
/*  871 */         TooltipsOverlay.i().showText("MainUi.threeStars", (Actor)this.Y, Game.i.localeManager.i18n.get("tooltip_level_three_stars"), this.m.mainUiLayer, this.m.zIndex + 1, 4);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void finalFadeOut() {
/*  878 */     this.m.getTable().setTouchable(Touchable.disabled);
/*  879 */     this.m.getTable().clearActions();
/*  880 */     this.m.getTable().addAction((Action)Actions.alpha(0.0F, 1.0F));
/*      */     
/*  882 */     this.ag = true;
/*      */     
/*  884 */     TooltipsOverlay.i().hideEntry("MainUi.detailedMode");
/*  885 */     TooltipsOverlay.i().hideEntry("MainUi.oneStar");
/*  886 */     TooltipsOverlay.i().hideEntry("MainUi.threeStars");
/*  887 */     this.ai = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUiScreenshotMode(GameUiSystem.ScreenshotModeConfig paramScreenshotModeConfig) {}
/*      */ 
/*      */   
/*      */   public boolean gameSpeedButtonVisible() {
/*  895 */     if (this.ag) return false;
/*      */     
/*  897 */     return this.W.isVisible();
/*      */   }
/*      */   
/*      */   public boolean nextWaveButtonVisible() {
/*  901 */     if (this.ag) return false;
/*      */     
/*  903 */     return this.S.isVisible();
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/*  907 */     this.C = paramBoolean;
/*      */     
/*  909 */     if (paramBoolean) {
/*  910 */       this.B.setColors(Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600); return;
/*      */     } 
/*  912 */     if (this.o.wave.isAutoForceWaveEnabled()) {
/*      */       
/*  914 */       this.B.setColors(Color.WHITE, MaterialColor.GREY.P400, MaterialColor.GREY.P500);
/*      */       return;
/*      */     } 
/*  917 */     Color color = this.B.getDisabledColor();
/*  918 */     this.B.setColors(color, color, color);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void hideGameSpeedButton() {
/*  924 */     this.W.clearActions();
/*  925 */     this.W.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showGameSpeedButton(boolean paramBoolean, @Null Runnable paramRunnable) {
/*  929 */     this.W.clearActions();
/*  930 */     this.W.setVisible(true);
/*  931 */     this.W.setTransform(false);
/*      */     
/*  933 */     if (paramBoolean) {
/*  934 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.W, j, Game.i.localeManager.i18n
/*  935 */           .get("main_ui_game_speed_button_title"), Game.i.localeManager.i18n
/*  936 */           .get("main_ui_game_speed_button_description"), () -> {
/*      */             updateGameSpeedButton(); if (paramRunnable != null)
/*      */               paramRunnable.run(); 
/*      */           }); return;
/*      */     } 
/*  941 */     if (paramRunnable != null) paramRunnable.run(); 
/*  942 */     updateGameSpeedButton();
/*      */   }
/*      */ 
/*      */   
/*      */   public void hideCoins() {
/*  947 */     this.R.clearActions();
/*  948 */     this.R.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showCoins(boolean paramBoolean, @Null Runnable paramRunnable) {
/*  952 */     this.R.clearActions();
/*  953 */     this.R.setVisible(true);
/*  954 */     this.R.setTransform(false);
/*      */     
/*  956 */     if (paramBoolean) {
/*  957 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.R, d, Game.i.localeManager.i18n
/*  958 */           .get("coins"), Game.i.localeManager.i18n
/*  959 */           .get("main_ui_coins_description"), paramRunnable); return;
/*      */     } 
/*  961 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideMessagesButton() {
/*  966 */     this.X.clearActions();
/*  967 */     this.X.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showMessagesButton(boolean paramBoolean, @Null Runnable paramRunnable) {
/*  971 */     this.X.clearActions();
/*  972 */     this.X.setVisible(true);
/*  973 */     this.X.setTransform(false);
/*      */     
/*  975 */     if (paramBoolean)
/*  976 */     { this.o._gameUi.uiElementsEmphasizer.show((Actor)this.X, h, Game.i.localeManager.i18n
/*  977 */           .get("messages"), Game.i.localeManager.i18n
/*  978 */           .get("main_ui_messages_button_description"), paramRunnable); }
/*      */     
/*  980 */     else if (paramRunnable != null) { paramRunnable.run(); }
/*      */ 
/*      */     
/*  983 */     this.L.setVisible(false);
/*      */   }
/*      */   
/*      */   public void hideScore() {
/*  987 */     this.T.clearActions();
/*  988 */     this.T.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showScore(boolean paramBoolean, @Null Runnable paramRunnable) {
/*  992 */     this.T.clearActions();
/*  993 */     this.T.setVisible(true);
/*  994 */     this.T.setTransform(false);
/*      */     
/*  996 */     if (paramBoolean) {
/*  997 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.T, e, Game.i.localeManager.i18n
/*  998 */           .get("score"), Game.i.localeManager.i18n
/*  999 */           .get("main_ui_score_description"), paramRunnable); return;
/*      */     } 
/* 1001 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideWaveNumber() {
/* 1006 */     this.V.clearActions();
/* 1007 */     this.V.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showWaveNumber(boolean paramBoolean, @Null Runnable paramRunnable) {
/* 1011 */     this.V.clearActions();
/* 1012 */     this.V.setVisible(true);
/* 1013 */     this.V.setTransform(false);
/*      */     
/* 1015 */     if (paramBoolean) {
/* 1016 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.V, i, Game.i.localeManager.i18n
/* 1017 */           .get("main_ui_wave_title"), Game.i.localeManager.i18n
/* 1018 */           .get("main_ui_wave_description"), paramRunnable); return;
/*      */     } 
/* 1020 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideHealth() {
/* 1025 */     this.Q.clearActions();
/* 1026 */     this.Q.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showHealth(boolean paramBoolean, @Null Runnable paramRunnable) {
/* 1030 */     this.Q.clearActions();
/* 1031 */     this.Q.setVisible(true);
/* 1032 */     this.Q.setTransform(false);
/*      */     
/* 1034 */     if (paramBoolean) {
/* 1035 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.Q, c, Game.i.localeManager.i18n
/* 1036 */           .get("main_ui_health_title"), Game.i.localeManager.i18n
/* 1037 */           .get("main_ui_health_description"), paramRunnable); return;
/*      */     } 
/* 1039 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideDrawModeButton() {
/* 1044 */     this.P.clearActions();
/* 1045 */     this.P.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showDrawModeButton(boolean paramBoolean, @Null Runnable paramRunnable) {
/* 1049 */     this.P.clearActions();
/* 1050 */     this.P.setVisible(true);
/* 1051 */     this.P.setTransform(false);
/*      */     
/* 1053 */     if (paramBoolean) {
/* 1054 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.P, b, Game.i.localeManager.i18n
/* 1055 */           .get("main_ui_drawing_mode_title"), Game.i.localeManager.i18n
/* 1056 */           .get("main_ui_drawing_mode_description"), paramRunnable); return;
/*      */     } 
/* 1058 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideNextWaveButton() {
/* 1063 */     this.S.clearActions();
/* 1064 */     this.S.setVisible(false);
/* 1065 */     this.o.wave.setAutoForceWaveEnabled(false);
/*      */   }
/*      */   
/*      */   public void hideMdps() {
/* 1069 */     this.U.clearActions();
/* 1070 */     this.U.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showMdps(boolean paramBoolean, @Null Runnable paramRunnable) {
/* 1074 */     this.U.clearActions();
/* 1075 */     this.U.setVisible(true);
/* 1076 */     this.U.setTransform(false);
/*      */     
/* 1078 */     if (paramBoolean) {
/* 1079 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.U, f, Game.i.localeManager.i18n
/* 1080 */           .get("main_ui_mdps_title"), Game.i.localeManager.i18n
/* 1081 */           .get("main_ui_mdps_description"), paramRunnable); return;
/*      */     } 
/* 1083 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void showNextWaveButton(boolean paramBoolean, @Null Runnable paramRunnable) {
/* 1088 */     this.S.clearActions();
/* 1089 */     this.S.setVisible(true);
/* 1090 */     this.S.setTransform(false);
/*      */     
/* 1092 */     if (paramBoolean) {
/* 1093 */       this.o._gameUi.uiElementsEmphasizer.show((Actor)this.S, g, Game.i.localeManager.i18n
/* 1094 */           .get("main_ui_wave_call_title"), Game.i.localeManager.i18n
/* 1095 */           .get("main_ui_wave_call_description"), paramRunnable); return;
/*      */     } 
/* 1097 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void updateGameSpeedButton() {
/*      */     float f;
/* 1103 */     if ((f = this.o.gameState.getNonAnimatedGameSpeed()) <= 0.0667F) {
/* 1104 */       this.K.setIcon(this.ac);
/*      */       
/* 1106 */       if (this.K.isVisible()) {
/* 1107 */         this.J.clearActions();
/* 1108 */         this.J.addAction((Action)Actions.show());
/* 1109 */         this.J.addAction((Action)Actions.forever((Action)Actions.parallel(
/* 1110 */                 (Action)Actions.sequence((Action)Actions.alpha(0.78F), (Action)Actions.alpha(0.0F, 1.0F)), 
/* 1111 */                 (Action)Actions.sequence((Action)Actions.moveTo(32.0F, 32.0F), (Action)Actions.moveTo(8.0F, 8.0F, 1.0F)), 
/* 1112 */                 (Action)Actions.sequence((Action)Actions.sizeTo(96.0F, 96.0F), (Action)Actions.sizeTo(144.0F, 144.0F, 1.0F)))));
/*      */       } else {
/*      */         
/* 1115 */         this.J.setVisible(false);
/*      */       } 
/*      */     } else {
/* 1118 */       if (f <= 1.0F) {
/* 1119 */         this.K.setIcon(this.ad);
/* 1120 */       } else if (f <= 2.0F) {
/* 1121 */         this.K.setIcon(this.ae);
/*      */       } else {
/* 1123 */         this.K.setIcon(this.af);
/*      */       } 
/*      */       
/* 1126 */       this.J.clearActions();
/* 1127 */       this.J.addAction((Action)Actions.sequence((Action)Actions.alpha(0.0F, 0.2F), (Action)Actions.hide()));
/*      */     } 
/*      */ 
/*      */     
/* 1131 */     this.L.setVisible((Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SLOW_MOTION_PAUSE) == 0.0D && this.o.gameState.getGameSpeed() == 0.0F && !this.X.isVisible()));
/*      */   }
/*      */   
/*      */   public void updateForceWaveButton() {
/*      */     boolean bool;
/* 1136 */     if (bool = this.o.wave.isForceWaveAvailable()) {
/*      */       
/* 1138 */       a(true);
/* 1139 */       this.D.clearActions();
/* 1140 */       this.D.addAction((Action)Actions.show());
/* 1141 */       this.D.addAction((Action)Actions.forever((Action)Actions.parallel(
/* 1142 */               (Action)Actions.sequence((Action)Actions.alpha(0.78F), (Action)Actions.alpha(0.0F, 1.0F)), 
/* 1143 */               (Action)Actions.sequence((Action)Actions.moveTo(32.0F, 32.0F), (Action)Actions.moveTo(0.0F, 0.0F, 1.0F)), 
/* 1144 */               (Action)Actions.sequence((Action)Actions.sizeTo(128.0F, 128.0F), (Action)Actions.sizeTo(192.0F, 192.0F, 1.0F)))));
/*      */     }
/*      */     else {
/*      */       
/* 1148 */       a(false);
/* 1149 */       this.D.clearActions();
/* 1150 */       this.D.addAction((Action)Actions.sequence((Action)Actions.alpha(0.0F, 0.2F), (Action)Actions.hide()));
/*      */     } 
/*      */ 
/*      */     
/* 1154 */     if (this.o.wave.isAutoForceWaveEnabled()) {
/* 1155 */       this.I.setVisible(true); return;
/*      */     } 
/* 1157 */     this.I.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateScore() {
/* 1162 */     this.p.setText((CharSequence)StringFormatter.commaSeparatedNumber(this.o.gameState.getScore()));
/*      */   }
/*      */   
/*      */   public void updateMoney() {
/* 1166 */     this.v.setText((CharSequence)StringFormatter.commaSeparatedNumber(this.o.gameState.getMoney()));
/*      */   }
/*      */   
/*      */   public void updateHealth() {
/*      */     int i;
/* 1171 */     if ((i = this.o.gameState.getHealth()) < 0) i = 0; 
/* 1172 */     O.setLength(0);
/* 1173 */     O.append(i);
/* 1174 */     this.s.setText((CharSequence)O);
/*      */   }
/*      */   
/*      */   public void updateWave() {
/* 1178 */     O.setLength(0);
/* 1179 */     O.append((this.o.wave.wave == null) ? 1 : this.o.wave.wave.waveNumber);
/* 1180 */     this.r.setText((CharSequence)O);
/*      */   }
/*      */   
/*      */   public void updateMdps() {
/* 1184 */     this.q.setText((CharSequence)StringFormatter.compactNumber(this.o.damage.getTowersMaxDps(), false));
/*      */   }
/*      */   
/*      */   public void updateGameplayBonus() {
/* 1188 */     if (this.o.bonus.isEnabled()) {
/* 1189 */       this.gameplayBonusGroup.setVisible(true);
/* 1190 */       this.gameplayBonusGroup.update(); return;
/*      */     } 
/* 1192 */     this.gameplayBonusGroup.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateAll() {
/* 1197 */     updateScore();
/* 1198 */     updateMoney();
/* 1199 */     updateWave();
/* 1200 */     updateHealth();
/* 1201 */     updateMdps();
/* 1202 */     updateForceWaveButton();
/* 1203 */     updateGameSpeedButton();
/* 1204 */     updateGameplayBonus();
/*      */   }
/*      */   
/*      */   public void draw(float paramFloat) {
/* 1208 */     if (this.o.wave.status != WaveSystem.Status.NOT_STARTED) {
/*      */       int j;
/*      */       
/* 1211 */       if ((j = (int)this.o.wave.getTimeToNextWave()) == 0) {
/* 1212 */         this.E.setVisible(false);
/* 1213 */         this.F.setVisible(false);
/* 1214 */       } else if (j != this.M) {
/* 1215 */         O.setLength(0);
/* 1216 */         O.append(j);
/* 1217 */         this.F.setText((CharSequence)O);
/* 1218 */         this.F.setVisible(true);
/* 1219 */         this.E.setVisible(true);
/*      */       } 
/* 1221 */       this.M = j;
/*      */ 
/*      */ 
/*      */       
/* 1225 */       if ((j = this.o.wave.getForceWaveBonus()) == 0) {
/* 1226 */         this.H.setVisible(false);
/* 1227 */         this.G.setVisible(false);
/* 1228 */       } else if (j != this.N) {
/* 1229 */         O.setLength(0);
/* 1230 */         O.append('+');
/* 1231 */         O.append(j);
/* 1232 */         if (this.o.wave.isForceWaveDoubleBonus()) {
/* 1233 */           O.append(" (x2)");
/*      */         }
/* 1235 */         this.G.setText((CharSequence)O);
/* 1236 */         this.H.setVisible(true);
/* 1237 */         this.G.setVisible(true);
/*      */       } 
/* 1239 */       this.N = j;
/*      */     } else {
/* 1241 */       this.E.setVisible(false);
/* 1242 */       this.F.setVisible(false);
/* 1243 */       this.H.setVisible(false);
/* 1244 */       this.G.setVisible(false);
/*      */     } 
/*      */     
/* 1247 */     this.aj += paramFloat;
/* 1248 */     if (this.aj > 1.0F) {
/* 1249 */       a();
/*      */       
/* 1251 */       this.aj = 0.0F;
/*      */     } 
/*      */     
/*      */     int i;
/* 1255 */     if ((i = (int)this.o.gameState.getDoubleSpeedTimeLeft()) > 0) {
/* 1256 */       if (!this.w.isVisible()) {
/* 1257 */         this.w.setVisible(true);
/* 1258 */         this.y.setVisible(true);
/* 1259 */         this.z.setVisible(true);
/*      */       } 
/*      */       
/* 1262 */       if (i != this.A) {
/* 1263 */         this.A = i;
/* 1264 */         StringBuilder stringBuilder = StringFormatter.digestTime(i);
/* 1265 */         this.x.setText((CharSequence)stringBuilder);
/*      */       } 
/*      */     } else {
/* 1268 */       this.w.setVisible(false);
/* 1269 */       this.y.setVisible(false);
/* 1270 */       this.z.setVisible(false);
/*      */     } 
/*      */ 
/*      */     
/* 1274 */     if (!this.ai && this.o.gameState.isGameRealTimePasses()) {
/* 1275 */       this.ah += paramFloat;
/* 1276 */       if (this.ah > 180.0F) {
/*      */         
/* 1278 */         TooltipsOverlay.i().showText("MainUi.detailedMode", (Actor)this.P, Game.i.localeManager.i18n.get("tooltip_detailed_mode"), this.m.mainUiLayer, this.m.zIndex + 1, 4);
/* 1279 */         this.ai = true;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1286 */     Game.EVENTS.getListeners(ScreenResize.class).remove(this.al);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1292 */     Game.i.uiManager.removeLayer(this.m);
/* 1293 */     Game.i.uiManager.removeLayer(this.k);
/* 1294 */     Game.i.uiManager.removeLayer(this.l);
/* 1295 */     Game.i.uiManager.removeLayer(this.n);
/*      */     
/* 1297 */     this.o = null;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MainUi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */