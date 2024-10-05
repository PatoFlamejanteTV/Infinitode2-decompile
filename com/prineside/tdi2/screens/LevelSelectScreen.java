/*      */ package com.prineside.tdi2.screens;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntSet;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.SnapshotArray;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.BasicLevelStage;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.Requirement;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.Resource;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.enums.BasicLevelLootBonusType;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.RequirementType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.managers.LeaderBoardManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_BasicLevel;
/*      */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Auth;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.FancyButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*      */ import com.prineside.tdi2.ui.actors.OverlayContinueButton;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.ui.shared.BackButton;
/*      */ import com.prineside.tdi2.ui.shared.DarkOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*      */ import com.prineside.tdi2.ui.shared.ItemDescriptionDialog;
/*      */ import com.prineside.tdi2.ui.shared.LeaderboardsOverlay;
/*      */ import com.prineside.tdi2.ui.shared.LevelConfigurationEditor;
/*      */ import com.prineside.tdi2.ui.shared.LevelStagesEditor;
/*      */ import com.prineside.tdi2.ui.shared.QuestPrestigeOverlay;
/*      */ import com.prineside.tdi2.ui.shared.ResourcesAndMoney;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.ui.shared.WavesTimelineOverlay;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class LevelSelectScreen extends Screen {
/*   92 */   private static final TLog a = TLog.forClass(LevelSelectScreen.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   99 */   private static final Color b = MaterialColor.GREY.P800;
/*  100 */   private static final Color c = MaterialColor.GREY.P900;
/*  101 */   private static final Color d = MaterialColor.GREY.P700;
/*  102 */   private static final Color e = MaterialColor.GREEN.P600;
/*  103 */   private static final Color f = MaterialColor.GREEN.P900;
/*  104 */   private static final Color g = MaterialColor.BLUE_GREY.P500;
/*  105 */   private static final Color h = MaterialColor.BLUE_GREY.P600;
/*  106 */   private static final Color i = MaterialColor.BLUE_GREY.P400;
/*  107 */   private static final Color j = MaterialColor.YELLOW.P500;
/*  108 */   private static final Color k = MaterialColor.YELLOW.P600;
/*  109 */   private static final Color l = MaterialColor.YELLOW.P400;
/*      */   
/*      */   private Label.LabelStyle m;
/*      */   
/*      */   private Label.LabelStyle n;
/*      */   
/*      */   private Label.LabelStyle o;
/*      */   
/*      */   private Label.LabelStyle p;
/*      */   private Group q;
/*      */   private ScrollPane r;
/*      */   private ParticleEffectPool s;
/*      */   private LevelMenuOverlay t;
/*  122 */   private ObjectMap<String, LevelElement> u = new ObjectMap();
/*      */ 
/*      */   
/*      */   private boolean v;
/*      */   
/*  127 */   private final UiManager.UiLayer w = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 100, "LevelSelectScreen main", true);
/*  128 */   private final UiManager.UiLayer x = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "LevelSelectScreen scroll gradients");
/*  129 */   private final UiManager.UiLayer y = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 103, "LevelSelectScreen level menu overlay"); private final ObjectConsumer<LeaderBoardManager.BasicLevelsTopLeaderboards> z;
/*      */   public LevelSelectScreen() {
/*  131 */     this.z = (paramBasicLevelsTopLeaderboards -> {
/*      */         if (paramBasicLevelsTopLeaderboards.success) {
/*      */           ObjectMap.Entries<ObjectMap.Entry> entries = paramBasicLevelsTopLeaderboards.leaderboards.iterator();
/*      */ 
/*      */           
/*      */           while (entries.hasNext()) {
/*      */             ObjectMap.Entry entry = entries.next();
/*      */             
/*      */             if (this.u.containsKey(entry.key)) {
/*      */               ((LevelElement)this.u.get(entry.key)).setTopLeaderboards((Array<LeaderBoardManager.LeaderboardsEntry>)entry.value);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       });
/*      */     
/*  146 */     Game.i.uiManager.hideAllComponents();
/*      */     
/*  148 */     ResourcesAndMoney.i()
/*  149 */       .setVisible(true);
/*      */     
/*  151 */     InventoryOverlay.i()
/*  152 */       .hideWithToggleButton(true);
/*      */     
/*  154 */     ScreenTitle.i()
/*  155 */       .setText(Game.i.localeManager.i18n.get("level_select_title"))
/*  156 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-joystick"))
/*  157 */       .setVisible(true);
/*      */     
/*  159 */     BackButton.i()
/*  160 */       .setVisible(true)
/*  161 */       .setText(null)
/*  162 */       .setClickHandler(() -> o());
/*      */     
/*  164 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     
/*  166 */     TooltipsOverlay.i().markTagShown("MainMenuScreen.firstLaunchHint");
/*      */ 
/*      */     
/*  169 */     this.s = Game.i.assetManager.getParticleEffectPool("dust-n-sparks-bg.prt");
/*      */     
/*  171 */     this.m = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE);
/*  172 */     this.n = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  173 */     this.o = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE);
/*  174 */     this.p = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*      */     
/*  176 */     this.q = new Group();
/*  177 */     this.q.setTransform(false);
/*      */     
/*  179 */     this.r = new ScrollPane((Actor)this.q);
/*  180 */     UiUtils.enableMouseMoveScrollFocus(this.r);
/*  181 */     this.r.setScrollingDisabled(true, false);
/*  182 */     this.w.getTable().add((Actor)this.r).expand().fill();
/*      */ 
/*      */     
/*  185 */     this.x.getTable().setTouchable(Touchable.disabled);
/*      */     
/*      */     Image image;
/*  188 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(Config.BACKGROUND_COLOR);
/*  189 */     this.x.getTable().add((Actor)image).fillX().height(128.0F).row();
/*      */     
/*  191 */     this.x.getTable().add().expand();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  196 */     this.t = new LevelMenuOverlay((byte)0);
/*      */ 
/*      */     
/*  199 */     Game.i.progressManager.checkSpecialTrophiesGiven();
/*  200 */     Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */   }
/*      */   
/*      */   public LevelSelectScreen(BasicLevel paramBasicLevel) {
/*  204 */     this();
/*      */     
/*  206 */     LevelMenuOverlay.a(this.t, paramBasicLevel);
/*  207 */     LevelMenuOverlay.a(this.t, true, false);
/*      */   }
/*      */   
/*      */   private void m() {
/*  211 */     Game.i.uiManager.setAsInputHandler();
/*  212 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.r);
/*      */   }
/*      */   
/*      */   private void n() {
/*  216 */     this.u.clear();
/*      */     
/*  218 */     float f1 = this.r.getScrollY();
/*      */     
/*  220 */     this.q.clear();
/*      */ 
/*      */     
/*  223 */     byte b1 = 0;
/*      */     
/*  225 */     float f2, f3 = (f2 = Game.i.uiManager.getRegularLayerWidth()) + Game.i.uiManager.getScreenSafeMargin() * 2.0F;
/*      */     
/*  227 */     float f4 = this.w.getTable().getHeight();
/*  228 */     float f5 = 0.0F;
/*      */     
/*  230 */     while (f5 + 320.0F <= f2 - 80.0F) {
/*  231 */       b1++;
/*  232 */       f5 += 340.0F;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  238 */     f5 = b1 * 320.0F + 20.0F * (b1 - 1);
/*      */     
/*  240 */     f2 = (f2 - f5) / 2.0F + Game.i.uiManager.getScreenSafeMargin();
/*  241 */     float f6 = 128.0F;
/*      */     
/*  243 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/*      */       FancyButton fancyButton;
/*      */ 
/*      */       
/*  247 */       (fancyButton = new FancyButton("regularButton.a", () -> LevelStagesEditor.i().show())).setSize(192.0F, 48.0F);
/*  248 */       fancyButton.add((Actor)new Label("Stage editor", Game.i.assetManager.getLabelStyle(21)));
/*  249 */       fancyButton.setPosition(f2, 128.0F);
/*  250 */       this.q.addActor((Actor)fancyButton);
/*  251 */       f6 = 176.0F;
/*      */     } 
/*      */     
/*  254 */     for (byte b2 = 0; b2 < Game.i.basicLevelManager.stagesOrdered.size; b2++) {
/*  255 */       BasicLevelStage basicLevelStage = (BasicLevelStage)Game.i.basicLevelManager.stagesOrdered.get(b2);
/*  256 */       if (Game.i.basicLevelManager.isStageVisible(basicLevelStage)) {
/*      */         
/*  258 */         boolean bool = basicLevelStage.name.equals("A");
/*  259 */         float f = f6;
/*      */         
/*  261 */         if (bool) f6 += 16.0F;
/*      */         
/*      */         Group group;
/*  264 */         (group = new Group()).setTransform(false);
/*  265 */         this.q.addActor((Actor)group);
/*      */         
/*      */         StageHeader stageHeader;
/*      */         
/*  269 */         (stageHeader = new StageHeader(this, f5, basicLevelStage)).setPosition(f2, f6);
/*  270 */         this.q.addActor((Actor)stageHeader);
/*  271 */         f6 += stageHeader.getHeight();
/*      */ 
/*      */         
/*  274 */         byte b3 = 0; byte b4;
/*  275 */         for (b4 = 0; b4 < basicLevelStage.levels.size; b4++) {
/*  276 */           BasicLevel basicLevel = (BasicLevel)basicLevelStage.levels.get(b4);
/*  277 */           if (Game.i.basicLevelManager.isLevelVisible(basicLevel)) {
/*      */             
/*  279 */             LevelElement levelElement = new LevelElement(this, basicLevel.name, false);
/*  280 */             this.u.put(basicLevel.name, levelElement);
/*  281 */             levelElement.setPosition(f2 + b3 * 340.0F, f6);
/*  282 */             this.q.addActor((Actor)levelElement);
/*      */             
/*  284 */             b3++;
/*  285 */             if (b3 == b1) {
/*  286 */               b3 = 0;
/*  287 */               f6 += 260.0F;
/*      */             } 
/*      */           } 
/*      */         } 
/*  291 */         if (basicLevelStage.name.equals("0")) {
/*      */           
/*  293 */           b4 = 0;
/*  294 */           Array array = (Game.i.basicLevelManager.getStage("0")).levels;
/*  295 */           for (byte b = 0; b < array.size; b++) {
/*      */             BasicLevel basicLevel;
/*  297 */             boolean bool1 = ((basicLevel = (BasicLevel)array.get(b)).quests.size != 0 && !((BasicLevelQuestConfig)basicLevel.quests.get(0)).isCompleted()) ? true : false;
/*  298 */             if (Game.i.basicLevelManager.isLevelVisible(basicLevel) && bool1) {
/*      */               
/*  300 */               b4 = 1;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*  305 */           if (b4 != 0) {
/*      */             Group group1;
/*      */             
/*  308 */             (group1 = new Group()).setTransform(false);
/*  309 */             group1.setTouchable(Touchable.enabled);
/*  310 */             group1.setPosition(f2 + b3 * 340.0F, f6);
/*  311 */             group1.setSize(320.0F, 240.0F);
/*  312 */             group1.setName("level_select_skip_tutorials_button");
/*  313 */             this.q.addActor((Actor)group1);
/*      */             
/*      */             Table table;
/*  316 */             (table = new Table()).setSize(320.0F, 240.0F);
/*  317 */             table.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*  318 */             group1.addActor((Actor)table);
/*      */             
/*      */             Group group2;
/*  321 */             (group2 = new Group()).setTransform(false);
/*  322 */             table.add((Actor)group2).size(64.0F, 64.0F).row();
/*      */ 
/*      */             
/*  325 */             for (byte b5 = 0; b5 < 3; b5++) {
/*      */               Image image1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  332 */               (image1 = new Image(this, (Drawable)Game.i.assetManager.getDrawable("icon-rewind")) { public void act(float param1Float) { super.act(0.011111111F); } }).setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  333 */               image1.setSize(64.0F, 64.0F);
/*  334 */               image1.setScale(0.5F);
/*  335 */               image1.setOrigin(32.0F, 32.0F);
/*  336 */               image1.addAction(
/*  337 */                   (Action)Actions.sequence(
/*  338 */                     (Action)Actions.delay(b5 * 2.0F * 0.3333F), 
/*  339 */                     (Action)Actions.forever((Action)Actions.sequence(
/*  340 */                         (Action)Actions.moveTo(-96.0F, 0.0F), 
/*  341 */                         (Action)Actions.alpha(0.0F), 
/*  342 */                         (Action)Actions.scaleTo(0.5F, 0.5F), 
/*  343 */                         (Action)Actions.parallel(
/*  344 */                           (Action)Actions.moveTo(96.0F, 0.0F, 2.0F), 
/*  345 */                           (Action)Actions.sequence(
/*  346 */                             (Action)Actions.parallel(
/*  347 */                               (Action)Actions.alpha(0.28F, 1.0F), 
/*  348 */                               (Action)Actions.scaleTo(1.0F, 1.0F, 1.0F)), 
/*      */                             
/*  350 */                             (Action)Actions.parallel(
/*  351 */                               (Action)Actions.alpha(0.0F, 1.0F), 
/*  352 */                               (Action)Actions.scaleTo(0.5F, 0.5F, 1.0F))))))));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  359 */               group2.addActor((Actor)image1);
/*      */             } 
/*      */             
/*      */             Image image;
/*  363 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-rewind"))).setColor(MaterialColor.LIGHT_BLUE.P500);
/*  364 */             image.setSize(64.0F, 64.0F);
/*  365 */             group2.addActor((Actor)image);
/*      */             
/*      */             Label label;
/*  368 */             (label = new Label(Game.i.localeManager.i18n.get("skip_tutorials"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P500);
/*  369 */             table.add((Actor)label).padTop(16.0F).padLeft(40.0F).padRight(40.0F);
/*      */ 
/*      */             
/*  372 */             group1.addListener((EventListener)new ClickListener(this)
/*      */                 {
/*      */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  375 */                     Dialog.i().showConfirm(Game.i.localeManager.i18n.get("skip_tutorials_confirm"), () -> {
/*      */                           Array array = (Game.i.basicLevelManager.getStage("0")).levels;
/*      */                           
/*      */                           for (byte b = 0; b < array.size; b++) {
/*      */                             BasicLevel basicLevel = (BasicLevel)array.get(b);
/*      */                             if (Game.i.basicLevelManager.isLevelVisible(basicLevel)) {
/*      */                               Game.i.basicLevelManager.setPurchased(basicLevel);
/*      */                               for (byte b1 = 0; b1 < basicLevel.quests.size; b1++) {
/*      */                                 BasicLevelQuestConfig basicLevelQuestConfig;
/*      */                                 (basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(b1)).setCompleted(true);
/*      */                               } 
/*      */                             } 
/*      */                           } 
/*      */                           Game.i.screenManager.goToLevelSelectScreen();
/*      */                         });
/*      */                   }
/*      */                 });
/*  392 */             b3++;
/*  393 */             if (b3 == b1) {
/*  394 */               b3 = 0;
/*  395 */               f6 += 260.0F;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  400 */         if (b3 != 0)
/*      */         {
/*  402 */           f6 += 260.0F;
/*      */         }
/*      */         
/*  405 */         if (bool) {
/*      */ 
/*      */ 
/*      */           
/*  409 */           float f7 = (f6 = f6 + 16.0F) - f;
/*  410 */           group.setPosition(0.0F, f);
/*  411 */           group.setSize(f3, f7);
/*      */           
/*      */           Image image;
/*  414 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.05F, 0.02F, 0.0F, 0.4F);
/*  415 */           image.setSize(f3, f6 - f);
/*  416 */           group.addActor((Actor)image);
/*      */           
/*      */           ParticlesCanvas particlesCanvas;
/*  419 */           (particlesCanvas = new ParticlesCanvas()).setSize(f3, f7);
/*  420 */           particlesCanvas.scissors = true;
/*      */           
/*      */           ParticleEffectPool.PooledEffect pooledEffect;
/*  423 */           Array array = (pooledEffect = (ParticleEffectPool.PooledEffect)this.s.obtain()).getEmitters();
/*  424 */           for (bool = false; bool < array.size; bool++) {
/*      */             ParticleEmitter particleEmitter;
/*  426 */             (particleEmitter = (ParticleEmitter)array.get(bool)).getSpawnWidth().setHigh(f3);
/*  427 */             particleEmitter.getXOffsetValue().setLow(-f3 * 0.5F);
/*  428 */             particleEmitter.getEmission().scale(f3 / 512.0F);
/*      */           } 
/*  430 */           particlesCanvas.addParticle((ParticleEffect)pooledEffect, f3 * 0.5F, 0.0F);
/*  431 */           group.addActor((Actor)particlesCanvas);
/*      */ 
/*      */ 
/*      */           
/*      */           QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */           
/*  439 */           (quadActor1 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.14F), new float[] { 0.0F, 10.0F, 0.0F, 24.0F, f3, 24.0F, f3, 4.0F })).setPosition(0.0F, f7 - 15.0F - 8.0F);
/*  440 */           group.addActor((Actor)quadActor1);
/*      */ 
/*      */ 
/*      */           
/*      */           QuadActor quadActor3;
/*      */ 
/*      */ 
/*      */           
/*  448 */           (quadActor3 = new QuadActor(Config.BACKGROUND_COLOR, new float[] { 0.0F, 16.0F, 0.0F, 16.0F, f3, 16.0F, f3, 0.0F })).setPosition(0.0F, f7 - 15.0F);
/*  449 */           group.addActor((Actor)quadActor3);
/*      */ 
/*      */ 
/*      */           
/*      */           QuadActor quadActor2;
/*      */ 
/*      */ 
/*      */           
/*  457 */           (quadActor2 = new QuadActor(Config.BACKGROUND_COLOR, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f3, 16.0F, f3, 0.0F })).setPosition(0.0F, -1.0F);
/*  458 */           group.addActor((Actor)quadActor2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  478 */           this.q.addActor((Actor)group);
/*      */         } else {
/*  480 */           group.remove();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  486 */     if ((f6 = f6 + 128.0F) < f4) f6 = f4; 
/*  487 */     this.q.setSize(f3, f6);
/*      */ 
/*      */     
/*  490 */     for (Array.ArrayIterator<Actor> arrayIterator = this.q.getChildren().iterator(); arrayIterator.hasNext();) {
/*  491 */       (actor = arrayIterator.next()).setPosition(actor.getX(), f6 - actor.getY() - actor.getHeight());
/*      */     }
/*      */ 
/*      */     
/*  495 */     this.r.layout();
/*  496 */     this.r.setScrollY(f1);
/*      */ 
/*      */     
/*  499 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL || DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*  500 */       Game.i.leaderBoardManager.getBasicLevelsTopLeaderboards(this.z);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void show() {
/*  508 */     super.show();
/*      */     
/*  510 */     m();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean o() {
/*  517 */     if (AbilitySelectionOverlay.i().isVisible()) {
/*      */       
/*  519 */       AbilitySelectionOverlay.i().hide();
/*      */     }
/*  521 */     else if (LevelMenuOverlay.a(this.t)) {
/*      */       
/*  523 */       LevelMenuOverlay.a(this.t, false, false);
/*      */     } else {
/*      */       
/*  526 */       Game.i.screenManager.goToMainMenu();
/*  527 */       return true;
/*      */     } 
/*      */     
/*  530 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  535 */     Color color = Game.i.assetManager.getColor("menu_background");
/*  536 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/*  537 */     Gdx.gl.glClear(16640);
/*      */     
/*  539 */     if (Game.i.settingsManager.isEscButtonJustPressed() && 
/*  540 */       o()) {
/*      */       return;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void resize(int paramInt1, int paramInt2) {
/*  548 */     super.resize(paramInt1, paramInt2);
/*      */     
/*  550 */     if (paramInt1 > 0 && paramInt2 > 0) {
/*  551 */       n();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/*  557 */     this.v = true;
/*      */     
/*  559 */     Game.i.uiManager.removeLayer(this.w);
/*  560 */     Game.i.uiManager.removeLayer(this.x);
/*  561 */     Game.i.uiManager.removeLayer(this.y);
/*      */     
/*  563 */     Game.i.leaderBoardManager.removeBasicLevelsTopLeaderboardsRetriever(this.z);
/*      */     
/*  565 */     this.t.dispose();
/*      */   }
/*      */   
/*      */   private class StageHeader
/*      */     extends Group
/*      */   {
/*      */     StageHeader(LevelSelectScreen this$0, float param1Float, BasicLevelStage param1BasicLevelStage) {
/*  572 */       setTransform(false);
/*      */       
/*  574 */       setSize(param1Float, 100.0F);
/*      */       
/*      */       Table table;
/*  577 */       (table = new Table()).setTouchable(Touchable.disabled);
/*  578 */       table.setFillParent(true);
/*  579 */       addActor((Actor)table);
/*      */       
/*      */       Label label2;
/*  582 */       (label2 = new Label(Game.i.localeManager.i18n.get("level_stage") + " " + param1BasicLevelStage.name, LevelSelectScreen.a(this$0))).setColor(param1BasicLevelStage.color);
/*  583 */       table.add((Actor)label2).bottom().left().padBottom(30.0F);
/*      */       
/*  585 */       label2 = new Label(param1BasicLevelStage.getTitle(), LevelSelectScreen.b(this$0));
/*  586 */       table.add((Actor)label2).expand().bottom().left().padLeft(16.0F).padBottom(33.0F);
/*      */ 
/*      */       
/*  589 */       (label2 = new Label(String.valueOf(Game.i.basicLevelManager.getGainedStarsOnStage(param1BasicLevelStage)), LevelSelectScreen.c(this$0))).setColor(param1BasicLevelStage.color);
/*  590 */       table.add((Actor)label2).bottom().right().padBottom(30.0F);
/*      */       
/*      */       Label label1;
/*  593 */       (label1 = new Label(" / " + Game.i.basicLevelManager.getMaxStars(param1BasicLevelStage, true), LevelSelectScreen.d(this$0))).setColor(param1BasicLevelStage.color);
/*  594 */       (label1.getColor()).a = 0.56F;
/*  595 */       table.add((Actor)label1).bottom().right().padBottom(33.0F);
/*      */       
/*      */       Image image;
/*  598 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star-stack"))).setColor(param1BasicLevelStage.color);
/*  599 */       table.add((Actor)image).bottom().right().padLeft(16.0F).padBottom(23.0F);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class LevelElement
/*      */     extends Group
/*      */   {
/*      */     private String l;
/*      */     private boolean m = false;
/*      */     private boolean n = false;
/*      */     private Image o;
/*      */     private Image p;
/*      */     private Group q;
/*      */     
/*      */     LevelElement(LevelSelectScreen this$0, String param1String, boolean param1Boolean) {
/*  615 */       setTransform(false);
/*      */       
/*  617 */       BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(param1String);
/*  618 */       BasicLevelStage basicLevelStage = Game.i.basicLevelManager.getStage(basicLevel.stageName);
/*  619 */       this.l = param1String;
/*  620 */       setSize(320.0F, 240.0F);
/*      */       
/*  622 */       boolean bool = Game.i.basicLevelManager.isOpened(basicLevel);
/*      */       
/*  624 */       if (!param1Boolean) {
/*  625 */         setName("level_select_level_" + basicLevel.name);
/*      */       }
/*      */ 
/*      */       
/*  629 */       if (param1Boolean) {
/*      */         Image image1;
/*      */ 
/*      */ 
/*      */         
/*  634 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-thumb-shadow-right"))).setSize(14.0F, 216.0F);
/*  635 */         image1.setPosition(320.0F, -14.0F);
/*  636 */         addActor((Actor)image1);
/*      */ 
/*      */         
/*  639 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-thumb-shadow-bottom"))).setSize(284.0F, 14.0F);
/*  640 */         image1.setPosition(36.0F, -14.0F);
/*  641 */         addActor((Actor)image1);
/*      */       } else {
/*      */         Image image1;
/*  644 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  645 */         image1.setSize(320.0F, 240.0F);
/*  646 */         image1.setPosition(10.0F, -10.0F);
/*  647 */         addActor((Actor)image1);
/*      */       } 
/*      */ 
/*      */       
/*  651 */       this.o = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  652 */       this.o.setSize(320.0F, 240.0F);
/*  653 */       addActor((Actor)this.o);
/*      */       
/*      */       Image image;
/*  656 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(310.0F, 230.0F);
/*  657 */       image.setColor(Config.BACKGROUND_COLOR);
/*  658 */       image.setPosition(5.0F, 5.0F);
/*  659 */       addActor((Actor)image);
/*      */ 
/*      */ 
/*      */       
/*  663 */       (image = new Image(basicLevel.getPreview())).setSize(310.0F, 230.0F);
/*  664 */       image.setPosition(5.0F, 5.0F);
/*  665 */       addActor((Actor)image);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  675 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-thumb-inner-shadow"))).setSize(310.0F, 185.0F);
/*  676 */       image.setPosition(5.0F, 5.0F);
/*  677 */       addActor((Actor)image);
/*      */ 
/*      */       
/*  680 */       if (!bool) {
/*      */         
/*  682 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(310.0F, 230.0F);
/*  683 */         image.setPosition(5.0F, 5.0F);
/*  684 */         image.setColor(Config.BACKGROUND_COLOR);
/*  685 */         (image.getColor()).a = 0.9F;
/*  686 */         addActor((Actor)image);
/*      */       } 
/*      */ 
/*      */       
/*  690 */       if (bool && !Game.i.basicLevelManager.playedBefore(basicLevel)) {
/*      */         
/*  692 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-new-level-tag"))).setSize(92.0F, 92.0F);
/*  693 */         image.setPosition(228.0F, 148.0F);
/*  694 */         addActor((Actor)image);
/*      */       } 
/*      */       
/*      */       PP_BasicLevel.LevelLootBonus levelLootBonus;
/*  698 */       if ((levelLootBonus = (ProgressPrefs.i()).basicLevel.getLevelLootBonus(param1String)) != null) {
/*  699 */         if (levelLootBonus.multiplier >= 3.4F) {
/*      */           ParticleEffectPool.PooledEffect pooledEffect; ParticlesCanvas particlesCanvas;
/*  701 */           (particlesCanvas = new ParticlesCanvas()).setSize(320.0F, 240.0F);
/*  702 */           addActor((Actor)particlesCanvas);
/*      */ 
/*      */           
/*  705 */           if (levelLootBonus.type == BasicLevelLootBonusType.GREEN_PAPERS) {
/*  706 */             pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("level-preview-loot-papers.p").obtain();
/*      */           } else {
/*  708 */             pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("level-preview-loot.p").obtain();
/*  709 */             switch (LevelSelectScreen.null.a[levelLootBonus.type.ordinal()]) {
/*      */               case 1:
/*  711 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-scalar")) }));
/*      */                 break;
/*      */               
/*      */               case 2:
/*  715 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-vector")) }));
/*      */                 break;
/*      */               
/*      */               case 3:
/*  719 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-matrix")) }));
/*      */                 break;
/*      */               
/*      */               case 4:
/*  723 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-tensor")) }));
/*      */                 break;
/*      */               
/*      */               case 5:
/*  727 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-infiar")) }));
/*      */                 break;
/*      */               
/*      */               case 6:
/*  731 */                 ((ParticleEmitter)pooledEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("dust-item")) }));
/*      */                 break;
/*      */             } 
/*      */           
/*      */           } 
/*  736 */           if (pooledEffect != null) {
/*  737 */             particlesCanvas.addParticle((ParticleEffect)pooledEffect, 0.0F, 240.0F);
/*      */           }
/*      */         } 
/*      */         
/*      */         Image image1;
/*      */         
/*  743 */         (image1 = new Image((Drawable)Game.i.assetManager.getQuad("screen.levelSelect.lootBoostOverlay"))).setPosition(203.0F, 186.0F);
/*  744 */         addActor((Actor)image1);
/*      */         
/*      */         Image image2;
/*  747 */         (image2 = new Image(levelLootBonus.getIconDrawable())).setSize(32.0F, 32.0F);
/*  748 */         image2.setPosition(227.0F, 199.0F);
/*  749 */         addActor((Actor)image2);
/*      */         
/*      */         Label label1;
/*  752 */         (label1 = new Label("x" + StringFormatter.compactNumberWithPrecisionTrimZeros(levelLootBonus.multiplier, 1, true), Game.i.assetManager.getLabelStyle(24))).setPosition(255.0F, 204.0F);
/*  753 */         label1.setSize(56.0F, 20.0F);
/*  754 */         label1.setAlignment(1);
/*  755 */         label1.setColor(MaterialColor.LIGHT_GREEN.P400);
/*  756 */         addActor((Actor)label1);
/*      */       } 
/*      */       
/*      */       Table table;
/*      */       
/*  761 */       (table = new Table()).setPosition(16.0F, 18.0F);
/*  762 */       table.setSize(304.0F, 26.0F);
/*  763 */       addActor((Actor)table);
/*      */       
/*  765 */       Label label = new Label(basicLevel.name, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  766 */       table.add((Actor)label).bottom().left();
/*      */       
/*  768 */       if (basicLevel.isBonus) {
/*  769 */         Label label1 = new Label("bonus", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), MaterialColor.AMBER.P500));
/*  770 */         table.add((Actor)label1).bottom().left().padLeft(8.0F).padBottom(4.0F);
/*      */       } 
/*      */       
/*  773 */       table.add().expandX().fillX();
/*      */       
/*  775 */       if (!bool) label.setColor(1.0F, 1.0F, 1.0F, 0.2F);
/*      */       
/*  777 */       if (bool) {
/*      */ 
/*      */         
/*  780 */         int i = Game.i.basicLevelManager.getGainedStarsOnLevel(basicLevel);
/*      */ 
/*      */         
/*      */         Image image1;
/*      */         
/*  785 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(32.0F, 32.0F);
/*  786 */         image1.setPosition(202.0F, 21.0F);
/*  787 */         if (i >= 3) {
/*  788 */           image1.setColor(basicLevelStage.color);
/*      */         } else {
/*  790 */           image1.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*      */         } 
/*  792 */         addActor((Actor)image1);
/*      */ 
/*      */         
/*  795 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(32.0F, 32.0F);
/*  796 */         image1.setPosition(236.0F, 21.0F);
/*  797 */         if (i >= 2) {
/*  798 */           image1.setColor(basicLevelStage.color);
/*      */         } else {
/*  800 */           image1.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*      */         } 
/*  802 */         addActor((Actor)image1);
/*      */ 
/*      */         
/*  805 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(32.0F, 32.0F);
/*  806 */         image1.setPosition(270.0F, 21.0F);
/*  807 */         if (i > 0) {
/*  808 */           image1.setColor(basicLevelStage.color);
/*      */         } else {
/*  810 */           image1.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*      */         } 
/*  812 */         addActor((Actor)image1);
/*      */         
/*      */         Label label2;
/*      */         
/*  816 */         (label2 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((ProgressPrefs.i()).basicLevel.getLevelMaxScore(param1String)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(100.0F, 20.0F);
/*  817 */         label2.setPosition(200.0F, 90.0F);
/*  818 */         label2.setAlignment(20);
/*  819 */         addActor((Actor)label2);
/*      */         
/*      */         Label label1;
/*      */         
/*  823 */         (label1 = new Label(String.valueOf((ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(param1String)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(62.0F, 20.0F);
/*  824 */         label1.setPosition(200.0F, 56.0F);
/*  825 */         label1.setAlignment(20);
/*  826 */         addActor((Actor)label1);
/*      */         
/*      */         Image image2;
/*  829 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"))).setSize(32.0F, 32.0F);
/*  830 */         image2.setPosition(270.0F, 55.0F);
/*  831 */         addActor((Actor)image2);
/*      */ 
/*      */         
/*  834 */         this.q = new Group();
/*  835 */         this.q.setSize(160.0F, 240.0F);
/*  836 */         this.q.setTransform(false);
/*  837 */         this.q.setVisible(false);
/*  838 */         addActor((Actor)this.q);
/*      */       } else {
/*      */         Table table2;
/*      */         
/*  842 */         (table2 = new Table()).setFillParent(true);
/*  843 */         addActor((Actor)table2);
/*      */ 
/*      */         
/*  846 */         for (bool = false; bool < basicLevel.openRequirements.size; bool++) {
/*      */           Requirement requirement;
/*  848 */           if ((requirement = (Requirement)basicLevel.openRequirements.get(bool)).type == RequirementType.STAGE_STARS) {
/*  849 */             Table table4 = new Table();
/*  850 */             BasicLevelStage basicLevelStage1 = Game.i.basicLevelManager.getStage(requirement.stageName);
/*  851 */             int i = Game.i.basicLevelManager.getGainedStarsOnStage(basicLevelStage1);
/*      */             
/*  853 */             Label label2 = new Label(i + " / ", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  854 */             if (requirement.stageStars > i) {
/*      */               
/*  856 */               label2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */             } else {
/*      */               
/*  859 */               label2.setColor(basicLevelStage1.color);
/*      */             } 
/*  861 */             table4.add((Actor)label2);
/*      */             
/*  863 */             Label label1 = new Label(String.valueOf(requirement.stageStars), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), basicLevelStage1.color));
/*  864 */             table4.add((Actor)label1);
/*      */             
/*      */             Image image2;
/*  867 */             (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star-stack"))).setColor(basicLevelStage1.color);
/*  868 */             table4.add((Actor)image2).size(48.0F).padLeft(8.0F);
/*      */             
/*  870 */             table2.add((Actor)table4).padBottom(8.0F).row();
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  875 */         Table table1 = new Table();
/*      */         
/*  877 */         for (byte b2 = 0; b2 < basicLevel.openRequirements.size; b2++) {
/*      */           Requirement requirement;
/*      */           
/*  880 */           if ((requirement = (Requirement)basicLevel.openRequirements.get(b2)).type != RequirementType.STAGE_STARS) {
/*      */             
/*  882 */             Image image2 = new Image((Drawable)Game.i.assetManager.getDrawable(requirement.getIconTextureName()));
/*  883 */             table1.add((Actor)image2).size(32.0F).padLeft(4.0F).padRight(4.0F);
/*      */             
/*  885 */             if (requirement.isSatisfied()) {
/*      */               
/*  887 */               image2.setColor(basicLevelStage.color);
/*      */             } else {
/*      */               
/*  890 */               image2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */             } 
/*      */           } 
/*      */         } 
/*  894 */         if (table1.hasChildren()) {
/*  895 */           table2.add((Actor)table1).padBottom(8.0F).row();
/*      */         }
/*      */ 
/*      */         
/*  899 */         Table table3 = new Table();
/*  900 */         for (byte b1 = 0; b1 < basicLevel.priceInResources.length; b1++) {
/*  901 */           if (basicLevel.priceInResources[b1] > 0) {
/*  902 */             Image image2 = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[b1]));
/*  903 */             table3.add((Actor)image2).size(32.0F).padLeft(4.0F).padRight(4.0F);
/*      */             
/*  905 */             if (basicLevel.priceInResources[b1] > Game.i.progressManager.getResources(ResourceType.values[b1])) {
/*      */               
/*  907 */               image2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */             } else {
/*      */               
/*  910 */               image2.setColor(basicLevelStage.color);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  915 */         if (basicLevel.priceInMoney > 0) {
/*  916 */           Image image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"));
/*  917 */           table3.add((Actor)image2).size(32.0F).padLeft(4.0F).padRight(4.0F);
/*      */           
/*  919 */           if (basicLevel.priceInMoney > Game.i.progressManager.getGreenPapers()) {
/*      */             
/*  921 */             image2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */           } else {
/*      */             
/*  924 */             image2.setColor(basicLevelStage.color);
/*      */           } 
/*      */         } 
/*      */         
/*  928 */         table2.add((Actor)table3);
/*      */ 
/*      */         
/*  931 */         Array array = Game.i.researchManager.getInstances(); byte b3;
/*  932 */         label153: for (b3 = 0; b3 < array.size; b3++) {
/*      */           Research research;
/*  934 */           if ((research = ((Research[])array.items)[b3]).isUnlocksTower() && research.getInstalledLevel() == 0) {
/*      */             int i; Requirement[] arrayOfRequirement; byte b;
/*  936 */             for (i = (arrayOfRequirement = (research.levels[0]).requirements).length, b = 0; b < i; ) {
/*  937 */               Requirement requirement; if ((requirement = arrayOfRequirement[b]).type == RequirementType.OPENED_LEVEL && requirement.openedLevelName
/*  938 */                 .equals(basicLevel.name)) {
/*      */                 Image image3;
/*      */                 
/*  941 */                 (image3 = new Image((Drawable)Game.i.towerManager.getFactory(research.relatedToTowerType).getShadowTextures())).setPosition(238.0F, -14.0F);
/*  942 */                 image3.setSize(96.0F, 96.0F);
/*  943 */                 image3.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  944 */                 addActor((Actor)image3);
/*      */                 
/*  946 */                 TextureRegion textureRegion = Game.i.towerManager.getFactory(research.relatedToTowerType).getIconTexture();
/*      */                 Image image2;
/*  948 */                 (image2 = new Image(textureRegion)).setSize(96.0F, 96.0F);
/*  949 */                 image2.setPosition(238.0F, -14.0F);
/*  950 */                 addActor((Actor)image2);
/*      */                 
/*      */                 break label153;
/*      */               } 
/*      */               
/*      */               b++;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         Image image1;
/*  960 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lock-vertical"))).setSize(48.0F, 48.0F);
/*  961 */         image1.setPosition(141.0F, -17.0F);
/*  962 */         image1.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  963 */         addActor((Actor)image1);
/*      */         
/*  965 */         this.p = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lock-vertical"));
/*  966 */         this.p.setSize(48.0F, 48.0F);
/*  967 */         this.p.setPosition(136.0F, -12.0F);
/*  968 */         addActor((Actor)this.p);
/*      */       } 
/*      */       
/*  971 */       if (!param1Boolean) {
/*      */         
/*  973 */         boolean bool1 = false;
/*  974 */         SP_Auth.SessionData sessionData = (SettingsPrefs.i()).auth.sessionData; byte b;
/*  975 */         for (b = 0; b < sessionData.xpPlayedLevels.size; b++) {
/*  976 */           if (((String[])sessionData.xpPlayedLevels.items)[b].equals(basicLevel.name)) {
/*  977 */             bool1 = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*  981 */         for (b = 0; b < Game.i.authManager.localXpPlayedLevels.size; b++) {
/*  982 */           if (((String[])Game.i.authManager.localXpPlayedLevels.items)[b].equals(basicLevel.name)) {
/*  983 */             bool1 = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  988 */         boolean bool2 = basicLevel.name.equals(sessionData.bonusXpLevel);
/*  989 */         if (bool1) {
/*      */           QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  996 */           (quadActor = new QuadActor(MaterialColor.ORANGE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.28F), new float[] { 0.0F, 0.0F, 0.0F, 32.0F, 100.0F, 32.0F, 92.0F, 0.0F })).setPosition(5.0F, 58.0F);
/*  997 */           addActor((Actor)quadActor);
/*      */           
/*  999 */           int i = MathUtils.round((1.0F - sessionData.playedLevelXpCoeff) * 100.0F);
/*      */           Label label1;
/* 1001 */           (label1 = new Label("-" + i + "% XP", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 1002 */           label1.setPosition(16.0F, 58.0F);
/* 1003 */           label1.setSize(90.0F, 32.0F);
/* 1004 */           addActor((Actor)label1);
/* 1005 */         } else if (bool2) {
/*      */           QuadActor quadActor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1013 */           (quadActor = new QuadActor(MaterialColor.LIGHT_GREEN.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.4F), new float[] { 0.0F, 0.0F, 0.0F, 32.0F, 100.0F, 32.0F, 92.0F, 0.0F })).setPosition(5.0F, 58.0F);
/* 1014 */           addActor((Actor)quadActor);
/*      */           
/* 1016 */           int i = MathUtils.round((sessionData.bonusLevelXpCoeff - 1.0F) * 100.0F);
/*      */           Label label1;
/* 1018 */           (label1 = new Label("+" + i + "% XP", Game.i.assetManager.getLabelStyle(21))).setColor(Color.WHITE);
/* 1019 */           label1.setPosition(16.0F, 58.0F);
/* 1020 */           label1.setSize(90.0F, 32.0F);
/* 1021 */           label1.addAction((Action)Actions.forever(
/* 1022 */                 (Action)Actions.sequence(
/* 1023 */                   (Action)Actions.color(Color.WHITE, 0.6F), 
/* 1024 */                   (Action)Actions.color(MaterialColor.LIGHT_GREEN.P500, 0.6F))));
/*      */ 
/*      */           
/* 1027 */           addActor((Actor)label1);
/*      */         } 
/*      */       } 
/*      */       
/* 1031 */       if (!param1Boolean) {
/* 1032 */         setTouchable(Touchable.enabled);
/*      */         
/* 1034 */         addListener((EventListener)new ClickListener(this, this$0, basicLevel)
/*      */             {
/*      */               public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 1037 */                 Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/* 1038 */                 LevelSelectScreen.LevelMenuOverlay.a(LevelSelectScreen.e(this.b.k), this.a);
/* 1039 */                 LevelSelectScreen.LevelMenuOverlay.a(LevelSelectScreen.e(this.b.k), true, false);
/*      */               }
/*      */ 
/*      */               
/*      */               public boolean touchDown(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 1044 */                 LevelSelectScreen.LevelElement.a(this.b, true);
/* 1045 */                 LevelSelectScreen.LevelElement.a(this.b);
/*      */                 
/* 1047 */                 return super.touchDown(param2InputEvent, param2Float1, param2Float2, param2Int1, param2Int2);
/*      */               }
/*      */ 
/*      */               
/*      */               public void touchUp(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 1052 */                 LevelSelectScreen.LevelElement.a(this.b, false);
/* 1053 */                 LevelSelectScreen.LevelElement.a(this.b);
/*      */                 
/* 1055 */                 super.touchUp(param2InputEvent, param2Float1, param2Float2, param2Int1, param2Int2);
/*      */               }
/*      */ 
/*      */               
/*      */               public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1060 */                 if (param2Int == -1) {
/* 1061 */                   LevelSelectScreen.LevelElement.b(this.b, true);
/* 1062 */                   LevelSelectScreen.LevelElement.a(this.b);
/*      */                 } 
/*      */                 
/* 1065 */                 super.enter(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*      */               }
/*      */ 
/*      */               
/*      */               public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1070 */                 if (param2Int == -1) {
/* 1071 */                   LevelSelectScreen.LevelElement.b(this.b, false);
/* 1072 */                   LevelSelectScreen.LevelElement.a(this.b);
/*      */                 } 
/*      */                 
/* 1075 */                 super.exit(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*      */               }
/*      */             });
/*      */       } 
/*      */       
/* 1080 */       e();
/*      */     }
/*      */     
/*      */     public void setTopLeaderboards(Array<LeaderBoardManager.LeaderboardsEntry> param1Array) {
/* 1084 */       if (this.q != null && param1Array.size != 0) {
/* 1085 */         this.q.setVisible(true);
/* 1086 */         this.q.clearChildren();
/*      */         
/*      */         Image image;
/*      */         
/* 1090 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"))).setSize(32.0F, 32.0F);
/* 1091 */         image.setPosition(16.0F, 196.0F);
/* 1092 */         this.q.addActor((Actor)image);
/*      */ 
/*      */         
/* 1095 */         for (byte b = 0; b < param1Array.size; b++) {
/* 1096 */           LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = (LeaderBoardManager.LeaderboardsEntry)param1Array.get(b);
/*      */           
/* 1098 */           float f = 1.0F - b * 0.25F;
/*      */           
/*      */           LimitedWidthLabel limitedWidthLabel2;
/* 1101 */           (limitedWidthLabel2 = new LimitedWidthLabel(leaderboardsEntry.nickname, 21, 21, 240.0F)).setColor(0.0F, 0.0F, 0.0F, 0.56F * f);
/* 1102 */           limitedWidthLabel2.setPosition(59.0F, 198.0F - b * 26.0F - 2.0F);
/* 1103 */           this.q.addActor((Actor)limitedWidthLabel2);
/*      */           
/*      */           LimitedWidthLabel limitedWidthLabel1;
/* 1106 */           (limitedWidthLabel1 = new LimitedWidthLabel(leaderboardsEntry.nickname, 21, 21, 240.0F)).setPosition(57.0F, 198.0F - b * 26.0F);
/* 1107 */           limitedWidthLabel1.setColor(1.0F, 1.0F, 1.0F, f);
/* 1108 */           this.q.addActor((Actor)limitedWidthLabel1);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     private BasicLevel d() {
/* 1114 */       return Game.i.basicLevelManager.getLevel(this.l);
/*      */     }
/*      */     
/*      */     private void e() {
/* 1118 */       this.o.clearActions();
/*      */       
/* 1120 */       BasicLevel basicLevel = d();
/*      */       boolean bool;
/* 1122 */       if (bool = Game.i.basicLevelManager.isOpened(basicLevel)) {
/*      */         
/* 1124 */         if (Game.i.basicLevelManager.isMastered(basicLevel)) {
/*      */           
/* 1126 */           if (this.m) {
/* 1127 */             this.o.setColor(LevelSelectScreen.a()); return;
/*      */           } 
/* 1129 */           if (this.n) {
/* 1130 */             this.o.setColor(LevelSelectScreen.b()); return;
/*      */           } 
/* 1132 */           this.o.setColor(LevelSelectScreen.c());
/*      */           
/*      */           return;
/*      */         } 
/*      */         
/* 1137 */         if (this.m) {
/* 1138 */           this.o.setColor(LevelSelectScreen.d()); return;
/*      */         } 
/* 1140 */         if (this.n) {
/* 1141 */           this.o.setColor(LevelSelectScreen.e()); return;
/*      */         } 
/* 1143 */         this.o.setColor(LevelSelectScreen.f());
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1149 */       if (this.m) {
/* 1150 */         this.o.setColor(LevelSelectScreen.g()); return;
/*      */       } 
/* 1152 */       if (this.n) {
/* 1153 */         this.o.setColor(LevelSelectScreen.h());
/*      */         return;
/*      */       } 
/* 1156 */       if (Game.i.basicLevelManager.canBePurchased(basicLevel)) {
/*      */         
/* 1158 */         this.o.addAction((Action)Actions.forever((Action)Actions.sequence(
/* 1159 */                 (Action)Actions.color(LevelSelectScreen.i(), 0.5F), 
/* 1160 */                 (Action)Actions.color(LevelSelectScreen.j(), 0.5F))));
/*      */         
/* 1162 */         this.p.addAction((Action)Actions.forever((Action)Actions.sequence(
/* 1163 */                 (Action)Actions.color(LevelSelectScreen.i(), 0.5F), 
/* 1164 */                 (Action)Actions.color(LevelSelectScreen.j(), 0.5F))));
/*      */         return;
/*      */       } 
/* 1167 */       this.o.setColor(LevelSelectScreen.k());
/* 1168 */       this.p.setColor(LevelSelectScreen.k());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class LevelMenuOverlay
/*      */     implements Disposable
/*      */   {
/*      */     private boolean b;
/*      */     
/*      */     @Null
/*      */     private GameSystemProvider c;
/*      */     
/*      */     private Group d;
/*      */     
/*      */     private LevelMenuOverlay(LevelSelectScreen this$0) {
/*      */       Group group;
/* 1185 */       (group = new Group()).setTransform(false);
/* 1186 */       group.setOrigin(600.0F, 380.0F);
/* 1187 */       LevelSelectScreen.f(LevelSelectScreen.this).getTable().add((Actor)group).size(1200.0F, 760.0F);
/*      */       
/* 1189 */       this.d = new Group();
/* 1190 */       this.d.setTransform(true);
/* 1191 */       this.d.setOrigin(600.0F, 380.0F);
/* 1192 */       this.d.setSize(1200.0F, 760.0F);
/* 1193 */       group.addActor((Actor)this.d);
/*      */       
/* 1195 */       LevelSelectScreen.f(LevelSelectScreen.this).getTable().setVisible(false);
/* 1196 */       this.b = false;
/*      */     }
/*      */ 
/*      */     
/*      */     private void a(BasicLevel param1BasicLevel) {
/* 1201 */       BasicLevelStage basicLevelStage = Game.i.basicLevelManager.getStage(param1BasicLevel.stageName);
/* 1202 */       this.d.clearChildren();
/*      */ 
/*      */       
/*      */       try {
/* 1206 */         this
/*      */ 
/*      */           
/* 1209 */           .c = new GameSystemProvider((new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.GAME, true)).disableScripts());
/* 1210 */         this.c.createSystems();
/* 1211 */         GameScreen.configureSystemsBeforeSetup(this.c, null, false, false, false, 0L, param1BasicLevel, null, Game.i.progressManager
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1220 */             .getDifficultyMode(), Game.i.progressManager
/* 1221 */             .getDifficultyModeDiffMultiplier(Game.i.progressManager.getDifficultyMode()), GameStateSystem.GameMode.BASIC_LEVELS, null, Game.i.progressManager
/*      */ 
/*      */             
/* 1224 */             .createProgressSnapshotForState(), Game.i.progressManager
/* 1225 */             .getInventoryStatistics(), null);
/*      */ 
/*      */         
/* 1228 */         this.c.setupSystems();
/* 1229 */       } catch (Exception exception) {
/* 1230 */         this.c = null;
/* 1231 */         LevelSelectScreen.l().e("failed to create GSP for level menu", new Object[] { exception });
/*      */       } 
/*      */ 
/*      */       
/* 1235 */       QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 22.0F, 10.0F, 748.0F, 1200.0F, 760.0F, 1200.0F, 0.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1241 */       this.d.addActor((Actor)quadActor);
/*      */       
/*      */       LevelSelectScreen.LevelElement levelElement;
/*      */       
/* 1245 */       (levelElement = new LevelSelectScreen.LevelElement(this.a, param1BasicLevel.name, true)).setPosition(-29.0F, 549.0F);
/* 1246 */       this.d.addActor((Actor)levelElement);
/*      */       
/*      */       Label label;
/*      */       
/* 1250 */       (label = new Label(Game.i.localeManager.i18n.get("level") + " " + param1BasicLevel.name, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE))).setPosition(330.0F, 662.0F);
/* 1251 */       label.setColor(basicLevelStage.color);
/* 1252 */       this.d.addActor((Actor)label);
/*      */       
/* 1254 */       if (Game.i.basicLevelManager.mapEditingAvailable()) {
/*      */         PaddedImageButton paddedImageButton1;
/*      */ 
/*      */ 
/*      */         
/* 1259 */         (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-tools"), () -> { LevelConfigurationEditor.i().showForLevel(param1BasicLevel); a(false, false); }MaterialColor.PURPLE.P700, MaterialColor.PURPLE.P600, MaterialColor.PURPLE.P800)).setSize(64.0F, 64.0F);
/* 1260 */         paddedImageButton1.setIconSize(48.0F, 48.0F);
/* 1261 */         paddedImageButton1.setIconPosition(8.0F, 8.0F);
/* 1262 */         paddedImageButton1.setPosition(1020.0F, 646.0F);
/* 1263 */         this.d.addActor((Actor)paddedImageButton1);
/*      */         
/*      */         PaddedImageButton paddedImageButton2;
/*      */         
/* 1267 */         (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-edit"), () -> Game.i.screenManager.goToMapEditorScreenBasicLevel(param1BasicLevel), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setSize(64.0F, 64.0F);
/* 1268 */         paddedImageButton2.setIconSize(48.0F, 48.0F);
/* 1269 */         paddedImageButton2.setIconPosition(8.0F, 8.0F);
/* 1270 */         paddedImageButton2.setPosition(1100.0F, 646.0F);
/* 1271 */         this.d.addActor((Actor)paddedImageButton2);
/*      */       } 
/*      */       
/* 1274 */       if (Game.i.basicLevelManager.isOpened(param1BasicLevel)) {
/*      */ 
/*      */ 
/*      */         
/* 1278 */         int i = Game.i.basicLevelManager.getGainedStarsOnLevel(param1BasicLevel);
/*      */ 
/*      */         
/* 1281 */         int[] arrayOfInt = param1BasicLevel.getStarMilestoneWaves();
/*      */         
/* 1283 */         for (byte b1 = 0; b1 < 3; b1++) {
/*      */           Image image;
/* 1285 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setPosition(50.0F + 66.0F * b1, 460.0F);
/* 1286 */           image.setSize(64.0F, 64.0F);
/* 1287 */           if (i >= 3 - b1) {
/* 1288 */             image.setColor(basicLevelStage.color);
/*      */           } else {
/* 1290 */             image.setColor(new Color(488447487));
/*      */           } 
/* 1292 */           this.d.addActor((Actor)image);
/*      */           
/* 1294 */           if (i < 3 - b1)
/*      */           {
/* 1296 */             if (arrayOfInt[2 - b1] != 0) {
/*      */               Label label4;
/* 1298 */               (label4 = new Label(String.valueOf(arrayOfInt[2 - b1]), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(64.0F, 64.0F);
/* 1299 */               label4.setPosition(50.0F + 66.0F * b1, 457.0F);
/* 1300 */               label4.setAlignment(1);
/* 1301 */               this.d.addActor((Actor)label4);
/*      */             } 
/*      */           }
/*      */         } 
/*      */         
/*      */         Table table1;
/*      */         
/* 1308 */         (table1 = new Table()).setPosition(0.0F, 400.0F);
/* 1309 */         table1.setSize(300.0F, 48.0F);
/* 1310 */         this.d.addActor((Actor)table1);
/*      */         
/* 1312 */         Image image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"));
/* 1313 */         table1.add((Actor)image1).size(48.0F).padRight(12.0F);
/*      */         
/* 1315 */         Label label1 = new Label(String.valueOf((ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(param1BasicLevel.name)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/* 1316 */         table1.add((Actor)label1);
/*      */         
/*      */         Table table2;
/*      */         
/* 1320 */         (table2 = new Table()).setPosition(0.0F, 354.0F);
/* 1321 */         table2.setSize(300.0F, 48.0F);
/* 1322 */         this.d.addActor((Actor)table2);
/*      */         
/* 1324 */         Image image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-trophy"));
/* 1325 */         table2.add((Actor)image2).size(32.0F).padRight(12.0F);
/*      */         
/* 1327 */         Label label3 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((ProgressPrefs.i()).basicLevel.getLevelMaxScore(param1BasicLevel.name)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 1328 */         table2.add((Actor)label3);
/*      */         
/* 1330 */         if (Game.i.minerManager.minersAndEnergyAvailable()) {
/*      */           Label label4;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1336 */           (label4 = new Label(Game.i.localeManager.i18n.get("resources").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setPosition(0.0F, 318.0F);
/* 1337 */           label4.setSize(300.0F, 20.0F);
/* 1338 */           label4.setAlignment(4);
/* 1339 */           label4.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1340 */           this.d.addActor((Actor)label4);
/*      */           
/* 1342 */           Map map = param1BasicLevel.getMap();
/* 1343 */           byte b3 = 0;
/*      */ 
/*      */           
/*      */           Array array;
/*      */ 
/*      */           
/* 1349 */           (array = new Array(true, 1, SourceTile.class)).addAll(map.getTilesByType(SourceTile.class));
/* 1350 */           array.sort((param1SourceTile1, param1SourceTile2) -> {
/*      */                 int i = 0;
/*      */                 
/*      */                 int j = 0;
/*      */                 for (byte b1 = 0; b1 < ResourceType.values.length; b1++) {
/*      */                   i += param1SourceTile1.getResourcesCount(ResourceType.values[b1]);
/*      */                   j += param1SourceTile2.getResourcesCount(ResourceType.values[b1]);
/*      */                 } 
/*      */                 if (i == 0) {
/*      */                   i = 1;
/*      */                 }
/*      */                 if (j == 0) {
/*      */                   j = 1;
/*      */                 }
/*      */                 float f1 = 0.0F;
/*      */                 float f2 = 0.0F;
/*      */                 for (byte b2 = 0; b2 < ResourceType.values.length; b2++) {
/*      */                   float f3 = param1SourceTile1.getResourcesCount(ResourceType.values[b2]) / i;
/*      */                   float f4 = param1SourceTile2.getResourcesCount(ResourceType.values[b2]) / j;
/*      */                   f1 += f3 * ((b2 << 1) + 1);
/*      */                   f2 += f4 * ((b2 << 1) + 1);
/*      */                 } 
/*      */                 return Float.compare(f2 * param1SourceTile2.getResourceDensity(), f1 * param1SourceTile1.getResourceDensity());
/*      */               });
/* 1374 */           for (byte b4 = 0; b4 < array.size; ) {
/*      */             SourceTile sourceTile;
/* 1376 */             float f1 = (sourceTile = ((SourceTile[])array.items)[b4]).getResourceDensity();
/*      */             
/* 1378 */             int j = 0; ResourceType[] arrayOfResourceType1; int k; byte b6;
/* 1379 */             for (k = (arrayOfResourceType1 = ResourceType.values).length, b6 = 0; b6 < k; ) { ResourceType resourceType = arrayOfResourceType1[b6];
/* 1380 */               j += sourceTile.getResourcesCount(resourceType);
/*      */               b6++; }
/*      */             
/*      */             Image image;
/* 1384 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(40.0F, 293.0F - b3 * 10.0F);
/* 1385 */             image.setSize(220.0F, 8.0F);
/* 1386 */             image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 1387 */             this.d.addActor((Actor)image);
/*      */ 
/*      */             
/* 1390 */             float f2 = 0.0F; byte b5; ResourceType[] arrayOfResourceType2; int m;
/* 1391 */             for (m = (arrayOfResourceType2 = ResourceType.values).length, b5 = 0; b5 < m; ) { ResourceType resourceType = arrayOfResourceType2[b5];
/*      */               int n;
/* 1393 */               if ((n = sourceTile.getResourcesCount(resourceType)) > 0) {
/* 1394 */                 float f = n / j;
/*      */                 
/*      */                 Image image3;
/* 1397 */                 (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(f1 * f * 220.0F, 8.0F);
/* 1398 */                 image3.setPosition(f2 + 40.0F, 293.0F - b3 * 10.0F);
/* 1399 */                 image3.setColor(Game.i.resourceManager.getColor(resourceType));
/* 1400 */                 this.d.addActor((Actor)image3);
/*      */                 
/* 1402 */                 if (f2 > 0.0F) {
/*      */                   Image image4;
/* 1404 */                   (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(2.0F, 8.0F);
/* 1405 */                   image4.setPosition((int)(f2 + 40.0F), 293.0F - b3 * 10.0F);
/* 1406 */                   image4.setColor(new Color(791621631));
/* 1407 */                   this.d.addActor((Actor)image4);
/*      */                 } 
/* 1409 */                 f2 += f * f1 * 220.0F;
/*      */               } 
/*      */               b5++; }
/*      */             
/* 1413 */             b3++;
/* 1414 */             if (b3 != 16) {
/*      */               b4++;
/*      */             }
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1447 */         if (param1BasicLevel.hasLeaderboards && (Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL || DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) && Game.i.authManager.isSignedIn()) {
/*      */           
/* 1449 */           (table2 = new Table()).setPosition(0.0F, 104.0F);
/* 1450 */           table2.setSize(300.0F, 24.0F);
/* 1451 */           this.d.addActor((Actor)table2);
/*      */ 
/*      */           
/* 1454 */           (label3 = new Label(Game.i.localeManager.i18n.get("level_selection_overlay_xp_gain").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setAlignment(1);
/* 1455 */           label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1456 */           table2.add((Actor)label3).height(24.0F);
/*      */           
/*      */           Image image;
/* 1459 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1460 */           table2.add((Actor)image).size(24.0F).padLeft(6.0F);
/*      */           
/* 1462 */           boolean bool = false;
/* 1463 */           SP_Auth.SessionData sessionData = (SettingsPrefs.i()).auth.sessionData; byte b;
/* 1464 */           for (b = 0; b < sessionData.xpPlayedLevels.size; b++) {
/* 1465 */             if (((String[])sessionData.xpPlayedLevels.items)[b].equals(param1BasicLevel.name)) {
/* 1466 */               bool = true;
/*      */               break;
/*      */             } 
/*      */           } 
/* 1470 */           for (b = 0; b < Game.i.authManager.localXpPlayedLevels.size; b++) {
/* 1471 */             if (((String[])Game.i.authManager.localXpPlayedLevels.items)[b].equals(param1BasicLevel.name)) {
/* 1472 */               bool = true;
/*      */               break;
/*      */             } 
/*      */           } 
/* 1476 */           boolean bool1 = param1BasicLevel.name.equals(sessionData.bonusXpLevel);
/*      */           
/* 1478 */           Color color = Color.WHITE;
/* 1479 */           int j = 100;
/*      */           
/* 1481 */           if (bool) {
/* 1482 */             j = MathUtils.round(sessionData.playedLevelXpCoeff * 100.0F);
/* 1483 */             color = MaterialColor.ORANGE.P500;
/* 1484 */           } else if (bool1) {
/* 1485 */             j = MathUtils.round(sessionData.bonusLevelXpCoeff * 100.0F);
/* 1486 */             color = MaterialColor.LIGHT_GREEN.P500;
/*      */           } 
/* 1488 */           if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode()))
/*      */           {
/* 1490 */             j = MathUtils.round(j * 0.5F);
/*      */           }
/*      */           
/*      */           Label label4;
/* 1494 */           (label4 = new Label(j + "% XP", Game.i.assetManager.getLabelStyle(36))).setColor(color);
/* 1495 */           label4.setTouchable(Touchable.disabled);
/* 1496 */           label4.setAlignment(4);
/* 1497 */           label4.setPosition(0.0F, 64.0F);
/* 1498 */           label4.setSize(300.0F, 20.0F);
/* 1499 */           this.d.addActor((Actor)label4);
/*      */           
/*      */           Group group;
/* 1502 */           (group = new Group()).setTransform(false);
/* 1503 */           group.setTouchable(Touchable.enabled);
/* 1504 */           bool = bool;
/* 1505 */           group.addListener((EventListener)new ClickListener(this, bool, bool1, image)
/*      */               {
/*      */                 public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 1508 */                   String str = Game.i.localeManager.i18n.get("level_selection_overlay_xp_tooltip");
/* 1509 */                   if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/* 1510 */                     String str1 = StringFormatter.timePassed(MathUtils.round(2700.0F), false, false);
/* 1511 */                     str = str + "\n" + Game.i.localeManager.i18n.format("level_selection_overlay_xp_tooltip_endless", new Object[] { str1 });
/*      */                   } 
/* 1513 */                   if (this.a) {
/* 1514 */                     str = str + "\n[#FFB74D]" + Game.i.localeManager.i18n.get("level_selection_overlay_xp_status_played") + "[]";
/* 1515 */                   } else if (this.b) {
/* 1516 */                     str = str + "\n[#AED581]" + Game.i.localeManager.i18n.get("level_selection_overlay_xp_status_bonus") + "[]";
/*      */                   } 
/* 1518 */                   TooltipsOverlay.i().showText("_generic_", (Actor)this.c, str, (LevelSelectScreen.f(this.d.a)).mainUiLayer, (LevelSelectScreen.f(this.d.a)).zIndex + 1, 2);
/*      */                 }
/*      */               });
/* 1521 */           group.setPosition(30.0F, 30.0F);
/* 1522 */           group.setSize(240.0F, 120.0F);
/* 1523 */           this.d.addActor((Actor)group);
/*      */         } 
/*      */ 
/*      */         
/* 1527 */         if (param1BasicLevel.waveQuests.size != 0) {
/*      */           WaveQuestsLine waveQuestsLine;
/* 1529 */           (waveQuestsLine = new WaveQuestsLine(param1BasicLevel, (byte)0)).setPosition(330.0F, 476.0F);
/* 1530 */           this.d.addActor((Actor)waveQuestsLine);
/*      */         } else {
/*      */           Label label4;
/* 1533 */           (label4 = new Label(Game.i.localeManager.i18n.get("level_has_no_wave_milestones"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1534 */           label4.setSize(870.0F, 176.0F);
/* 1535 */           label4.setPosition(330.0F, 476.0F);
/* 1536 */           label4.setAlignment(1);
/* 1537 */           this.d.addActor((Actor)label4);
/*      */         } 
/*      */         
/*      */         Label label2;
/*      */         
/* 1542 */         (label2 = new Label(Game.i.localeManager.i18n.get("enemies").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1543 */         label2.setPosition(330.0F, 440.0F);
/* 1544 */         this.d.addActor((Actor)label2);
/*      */         
/* 1546 */         for (byte b2 = 0; b2 < (param1BasicLevel.getAllowedEnemies()).size; b2++) {
/* 1547 */           EnemyType enemyType = (EnemyType)param1BasicLevel.getAllowedEnemies().get(b2);
/*      */           Image image;
/* 1549 */           (image = new Image(Game.i.enemyManager.getFactory(enemyType).getTexture())).setSize(40.0F, 40.0F);
/* 1550 */           image.setPosition(327.0F + b2 * 54.0F, 386.0F);
/* 1551 */           this.d.addActor((Actor)image);
/*      */         } 
/*      */ 
/*      */         
/* 1555 */         DifficultyMode difficultyMode2 = Game.i.progressManager.getDifficultyMode();
/* 1556 */         if (param1BasicLevel.forcedDifficulty != null) {
/* 1557 */           difficultyMode2 = param1BasicLevel.forcedDifficulty;
/*      */         }
/* 1559 */         DifficultyMode difficultyMode1 = difficultyMode2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1571 */         (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("waves"), Game.i.assetManager.getLabelStyle(24), () -> { Map map; (map = param1BasicLevel.getMap().cpy()).multiplyPortalsDifficulty(Game.i.progressManager.getDifficultyModeDiffMultiplier(param1DifficultyMode) * 0.01F); try { WavesTimelineOverlay.i().setConfiguration(this.c.wave.generateWavesTimelineConfigurationBasicLevel(param1BasicLevel, map, 1)); WavesTimelineOverlay.i().setVisible(true); return; } catch (Exception exception) { throw new IllegalStateException("Failed to show wavesTimelineOverlay for level " + param1BasicLevel.name, exception); }  })).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-waves-timeline-button"), 0.0F, 0.0F, 193.0F, 76.0F);
/* 1572 */         complexButton.setSize(193.0F, 76.0F);
/* 1573 */         complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-wave"), 20.0F, 28.0F, 32.0F, 32.0F);
/* 1574 */         complexButton.setLabel(68.0F, 34.0F, 100.0F, 19.0F, 8);
/* 1575 */         complexButton.setPosition(1027.0F, 370.0F);
/* 1576 */         if (param1BasicLevel.customWaves) {
/* 1577 */           complexButton.setVisible(false);
/*      */         }
/* 1579 */         if (this.c != null) {
/* 1580 */           this.d.addActor((Actor)complexButton);
/*      */         }
/*      */ 
/*      */         
/* 1584 */         if (param1BasicLevel.quests.size != 0) {
/*      */           Label label4;
/* 1586 */           (label4 = new Label(Game.i.localeManager.i18n.get("quests").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1587 */           label4.setPosition(330.0F, 348.0F);
/* 1588 */           label4.setSize(100.0F, 21.0F);
/* 1589 */           this.d.addActor((Actor)label4);
/*      */           
/* 1591 */           byte b3 = 0;
/* 1592 */           for (byte b4 = 0; b4 < param1BasicLevel.quests.size; b4++) {
/* 1593 */             if (((BasicLevelQuestConfig)param1BasicLevel.quests.get(b4)).isCompleted()) {
/* 1594 */               b3++;
/*      */             }
/*      */           } 
/*      */           Label label5;
/* 1598 */           (label5 = new Label(Game.i.localeManager.i18n.get("completed").toUpperCase() + ": " + b3 + " / " + param1BasicLevel.quests.size, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1599 */           label5.setPosition(1060.0F, 348.0F);
/* 1600 */           label5.setSize(100.0F, 21.0F);
/* 1601 */           label5.setAlignment(16);
/* 1602 */           this.d.addActor((Actor)label5);
/*      */           
/*      */           QuestsList questsList;
/* 1605 */           (questsList = new QuestsList(param1BasicLevel, (byte)0)).setPosition(330.0F, 116.0F);
/* 1606 */           this.d.addActor((Actor)questsList);
/*      */           
/*      */           Image image;
/* 1609 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-vertical-scroll-hint"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1610 */           image.setSize(20.0F, 136.0F);
/* 1611 */           image.setPosition(1168.0F, 160.0F);
/* 1612 */           image.setTouchable(Touchable.disabled);
/* 1613 */           this.d.addActor((Actor)image);
/*      */         } 
/*      */         
/* 1616 */         if (param1BasicLevel.getMap().getTargetTile(false) != null) {
/* 1617 */           OverlayContinueButton overlayContinueButton; if (param1BasicLevel.hasLeaderboards && (Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL || DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode()))) {
/*      */             
/* 1619 */             if (Game.i.authManager.isSignedIn()) {
/*      */               QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1632 */               (quadActor1 = new QuadActor(new Color[] { new Color(-272617728), new Color(-272617728), new Color(-272617657), new Color(-272617657) }, new float[] { 0.0F, 11.0F, 0.0F, 77.0F, 518.0F, 82.0F, 489.0F, 0.0F })).setSize(518.0F, 82.0F);
/* 1633 */               quadActor1.setPosition(331.0F, 20.0F);
/* 1634 */               this.d.addActor((Actor)quadActor1);
/*      */               
/*      */               Label label4;
/* 1637 */               (label4 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(733.0F, 65.0F);
/* 1638 */               label4.setSize(73.0F, 21.0F);
/* 1639 */               label4.setAlignment(16);
/* 1640 */               this.d.addActor((Actor)label4);
/*      */               
/*      */               Label label5;
/* 1643 */               (label5 = new Label("", Game.i.assetManager.getLabelStyle(21))).setPosition(733.0F, 39.0F);
/* 1644 */               label5.setSize(73.0F, 21.0F);
/* 1645 */               label5.setAlignment(16);
/* 1646 */               label5.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1647 */               this.d.addActor((Actor)label5);
/*      */ 
/*      */               
/* 1650 */               Game.i.leaderBoardManager.getLeaderboardsRank(GameStateSystem.GameMode.BASIC_LEVELS, difficultyMode2, param1BasicLevel.name, ReplayManager.LeaderboardsMode.score, param1LeaderboardsRankResult -> {
/*      */                     if (param1LeaderboardsRankResult.success) {
/*      */                       if (param1LeaderboardsRankResult.rank <= 0) {
/*      */                         param1Label1.setText("? / " + param1LeaderboardsRankResult.total);
/*      */                         
/*      */                         param1Label2.setText(Game.i.localeManager.i18n.get("play_to_get_ranked"));
/*      */                         
/*      */                         return;
/*      */                       } 
/*      */                       
/*      */                       param1Label1.setText(param1LeaderboardsRankResult.rank + " / " + param1LeaderboardsRankResult.total);
/*      */                       
/*      */                       if (param1LeaderboardsRankResult.rank == 1) {
/*      */                         param1Label2.setText(Game.i.localeManager.i18n.get("leader") + "!");
/*      */                         return;
/*      */                       } 
/*      */                       int i = MathUtils.ceil(param1LeaderboardsRankResult.rank / param1LeaderboardsRankResult.total * 100.0F);
/*      */                       param1Label2.setText(Game.i.localeManager.i18n.format("top_percent", new Object[] { Integer.valueOf(i) }));
/*      */                     } 
/*      */                   });
/*      */             } 
/*      */             ComplexButton complexButton1;
/* 1672 */             (complexButton1 = new ComplexButton(Game.i.localeManager.i18n.get("leaderboards"), Game.i.assetManager.getLabelStyle(24), () -> LeaderboardsOverlay.i().show(param1BasicLevel, ReplayManager.LeaderboardsMode.score))).setSize(480.0F, 82.0F);
/* 1673 */             complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-crown"), 24.0F, 20.0F, 48.0F, 48.0F);
/* 1674 */             complexButton1.setIconLabelColors(MaterialColor.AMBER.P500, MaterialColor.AMBER.P500, MaterialColor.AMBER.P500, Color.WHITE);
/* 1675 */             complexButton1.setLabel(86.0F, 20.0F, 200.0F, 48.0F, 8);
/* 1676 */             complexButton1.setPosition(331.0F, 20.0F);
/* 1677 */             this.d.addActor((Actor)complexButton1);
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1682 */           if (param1BasicLevel.getMap().getTargetTileOrThrow().isDisableAbilities() || !Game.i.abilityManager.isAnyAbilityOpened()) {
/*      */             
/* 1684 */             overlayContinueButton = new OverlayContinueButton(Game.i.localeManager.i18n.get("play"), "icon-triangle-right", MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, () -> {
/*      */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   Runnable runnable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   (runnable = (())).run();
/*      */                 });
/*      */           } else {
/* 1703 */             overlayContinueButton = new OverlayContinueButton(Game.i.localeManager.i18n.get("continue"), "icon-triangle-right", MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, () -> {
/*      */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   Runnable runnable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   (runnable = (())).run();
/*      */                 });
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1735 */           overlayContinueButton.setName("level_select_overlay_continue_button");
/* 1736 */           overlayContinueButton.setPosition(812.0F, -13.0F);
/* 1737 */           this.d.addActor((Actor)overlayContinueButton);
/*      */         } 
/*      */       } else {
/*      */         OverlayContinueButton overlayContinueButton;
/* 1741 */         float f = 610.0F;
/* 1742 */         if (param1BasicLevel.openRequirements.size != 0) {
/*      */           Label label1;
/*      */           
/* 1745 */           (label1 = new Label(Game.i.localeManager.i18n.get("requirements").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1746 */           label1.setPosition(330.0F, 610.0F);
/* 1747 */           this.d.addActor((Actor)label1);
/*      */           
/* 1749 */           f = 540.0F;
/*      */           
/* 1751 */           for (byte b1 = 0; b1 < param1BasicLevel.openRequirements.size; b1++) {
/* 1752 */             Image image3; Requirement requirement = (Requirement)param1BasicLevel.openRequirements.get(b1);
/*      */             
/*      */             Image image2;
/*      */             
/* 1756 */             (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(870.0F, 52.0F);
/* 1757 */             image2.setPosition(330.0F, f);
/* 1758 */             image2.setColor(new Color(0.0F, 0.0F, 0.0F, 0.14F));
/* 1759 */             this.d.addActor((Actor)image2);
/*      */             
/*      */             Image image1;
/*      */             
/* 1763 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(requirement.getIconTextureName()))).setSize(32.0F, 32.0F);
/* 1764 */             image1.setPosition(340.0F, f + 10.0F);
/* 1765 */             this.d.addActor((Actor)image1);
/*      */ 
/*      */             
/* 1768 */             StringBuilder stringBuilder1 = requirement.getTitle(true);
/*      */ 
/*      */             
/*      */             Label label2;
/*      */ 
/*      */             
/* 1774 */             (label2 = new Label((CharSequence)stringBuilder1, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 52.0F);
/* 1775 */             label2.setPosition(382.0F, f);
/* 1776 */             this.d.addActor((Actor)label2);
/*      */             
/*      */             StringBuilder stringBuilder2;
/* 1779 */             if ((stringBuilder2 = requirement.getFormattedValue()).length() > 0) {
/*      */               Label label3;
/* 1781 */               (label3 = new Label((CharSequence)stringBuilder2, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setPosition(944.0F, f);
/* 1782 */               label3.setSize(160.0F, 52.0F);
/* 1783 */               label3.setAlignment(16);
/* 1784 */               this.d.addActor((Actor)label3);
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/* 1789 */             if (requirement.isSatisfied()) {
/*      */               
/* 1791 */               (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setColor(MaterialColor.GREEN.P500);
/*      */             } else {
/*      */               
/* 1794 */               (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-times"))).setColor(MaterialColor.ORANGE.P500);
/*      */             } 
/* 1796 */             image3.setSize(32.0F, 32.0F);
/* 1797 */             image3.setPosition(1120.0F, f + 10.0F);
/* 1798 */             this.d.addActor((Actor)image3);
/*      */ 
/*      */             
/* 1801 */             if (requirement.type == RequirementType.STARS || requirement.type == RequirementType.OPENED_LEVEL || requirement.type == RequirementType.RESEARCH) {
/*      */               EyeButton eyeButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1823 */               (eyeButton = new EyeButton(() -> { if (param1Requirement.type == RequirementType.RESEARCH) { Game.i.screenManager.goToResearchesScreenFocusOnResearch(param1Requirement.researchType); return; }  if (param1Requirement.type == RequirementType.STARS) { if ((basicLevel = Game.i.basicLevelManager.getLevel(param1Requirement.levelName)) != null) { LevelSelectScreen.e(this.a).a(basicLevel); LevelSelectScreen.e(this.a).a(true, false); }  return; }  BasicLevel basicLevel; if (((Requirement)basicLevel).type == RequirementType.OPENED_LEVEL && (basicLevel = Game.i.basicLevelManager.getLevel(((Requirement)basicLevel).openedLevelName)) != null) { LevelSelectScreen.e(this.a).a(basicLevel); LevelSelectScreen.e(this.a).a(true, false); }  }(byte)0)).setPosition(1200.0F, f);
/* 1824 */               this.d.addActor((Actor)eyeButton);
/*      */             } 
/*      */             
/* 1827 */             f -= 56.0F;
/*      */           } 
/*      */         } 
/*      */         
/* 1831 */         byte b = 0;
/* 1832 */         if (param1BasicLevel.priceInMoney > 0) {
/* 1833 */           b = 1;
/*      */         } else {
/* 1835 */           for (byte b1 = 0; b1 < param1BasicLevel.priceInResources.length; b1++) {
/* 1836 */             if (param1BasicLevel.priceInResources[b1] > 0) {
/* 1837 */               b = 1;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 1843 */         if (b) {
/*      */           Label label1;
/*      */           
/* 1846 */           (label1 = new Label(Game.i.localeManager.i18n.get("price").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1847 */           label1.setPosition(330.0F, f);
/* 1848 */           this.d.addActor((Actor)label1);
/*      */           
/* 1850 */           f -= 70.0F;
/*      */           
/* 1852 */           boolean bool1 = true;
/* 1853 */           for (b = 0; b < param1BasicLevel.priceInResources.length; b++) {
/* 1854 */             if (param1BasicLevel.priceInResources[b] > 0) {
/*      */               
/* 1856 */               float f1 = bool1 ? 330.0F : 767.0F;
/*      */               
/*      */               Image image1;
/* 1859 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(433.0F, 52.0F);
/* 1860 */               image1.setPosition(f1, f);
/* 1861 */               image1.setColor(new Color(0.0F, 0.0F, 0.0F, 0.14F));
/* 1862 */               this.d.addActor((Actor)image1);
/*      */               
/*      */               Image image2;
/*      */               
/* 1866 */               (image2 = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[b]))).setColor(Game.i.resourceManager.getColor(ResourceType.values[b]));
/* 1867 */               image2.setSize(32.0F, 32.0F);
/* 1868 */               image2.setPosition(f1 + 10.0F, f + 10.0F);
/* 1869 */               this.d.addActor((Actor)image2);
/*      */               
/*      */               Label label2;
/*      */               
/* 1873 */               (label2 = new Label(Game.i.resourceManager.getName(ResourceType.values[b]), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Game.i.resourceManager.getColor(ResourceType.values[b])))).setPosition(f1 + 52.0F, f);
/* 1874 */               label2.setSize(100.0F, 52.0F);
/* 1875 */               this.d.addActor((Actor)label2);
/*      */               
/*      */               int i;
/*      */               
/* 1879 */               if ((i = Game.i.progressManager.getResources(ResourceType.values[b])) > param1BasicLevel.priceInResources[b]) {
/* 1880 */                 i = param1BasicLevel.priceInResources[b];
/*      */               }
/*      */               
/* 1883 */               String str = StringFormatter.commaSeparatedNumber(i) + " / " + StringFormatter.commaSeparatedNumber(param1BasicLevel.priceInResources[b]);
/*      */               
/* 1885 */               (label1 = new Label(str, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 52.0F);
/* 1886 */               label1.setAlignment(16);
/*      */               
/* 1888 */               if (bool1) {
/* 1889 */                 label1.setPosition(f1 + 320.0F, f);
/*      */               } else {
/* 1891 */                 label1.setPosition(f1 + 320.0F - 28.0F, f);
/*      */               } 
/*      */               
/* 1894 */               if (Game.i.progressManager.getResources(ResourceType.values[b]) < param1BasicLevel.priceInResources[b]) {
/* 1895 */                 label1.setColor(MaterialColor.ORANGE.P500);
/*      */               } else {
/* 1897 */                 label1.setColor(Color.WHITE);
/*      */               } 
/* 1899 */               this.d.addActor((Actor)label1);
/*      */ 
/*      */               
/* 1902 */               if (bool1 = !bool1 ? true : false) {
/* 1903 */                 f -= 56.0F;
/*      */               }
/*      */             } 
/*      */           } 
/* 1907 */           if (param1BasicLevel.priceInMoney > 0) {
/* 1908 */             float f1 = bool1 ? 330.0F : 767.0F;
/*      */             
/*      */             Image image1;
/* 1911 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(433.0F, 52.0F);
/* 1912 */             image1.setPosition(f1, f);
/* 1913 */             image1.setColor(new Color(0.0F, 0.0F, 0.0F, 0.14F));
/* 1914 */             this.d.addActor((Actor)image1);
/*      */             
/*      */             Image image2;
/*      */             
/* 1918 */             (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setSize(32.0F, 32.0F);
/* 1919 */             image2.setPosition(f1 + 10.0F, f + 10.0F);
/* 1920 */             this.d.addActor((Actor)image2);
/*      */             
/*      */             Label label3;
/*      */             
/* 1924 */             (label3 = new Label(Game.i.localeManager.i18n.get("green_papers_short"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setPosition(f1 + 52.0F, f);
/* 1925 */             label3.setSize(100.0F, 52.0F);
/* 1926 */             this.d.addActor((Actor)label3);
/*      */             
/*      */             int i;
/*      */             
/* 1930 */             if ((i = Game.i.progressManager.getGreenPapers()) > param1BasicLevel.priceInMoney) {
/* 1931 */               i = param1BasicLevel.priceInMoney;
/*      */             }
/*      */             
/* 1934 */             String str = StringFormatter.commaSeparatedNumber(i) + " / " + StringFormatter.commaSeparatedNumber(param1BasicLevel.priceInMoney);
/*      */             Label label2;
/* 1936 */             (label2 = new Label(str, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 52.0F);
/* 1937 */             label2.setAlignment(16);
/*      */             
/* 1939 */             if (bool1) {
/* 1940 */               label2.setPosition(f1 + 320.0F, f);
/*      */             } else {
/* 1942 */               label2.setPosition(f1 + 320.0F - 28.0F, f);
/*      */             } 
/*      */             
/* 1945 */             if (Game.i.progressManager.getGreenPapers() < param1BasicLevel.priceInMoney) {
/* 1946 */               label2.setColor(MaterialColor.ORANGE.P500);
/*      */             } else {
/* 1948 */               label2.setColor(Color.WHITE);
/*      */             } 
/* 1950 */             this.d.addActor((Actor)label2);
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         boolean bool;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1963 */         if (bool = Game.i.basicLevelManager.canBePurchased(param1BasicLevel)) {
/*      */           
/* 1965 */           overlayContinueButton = new OverlayContinueButton(Game.i.localeManager.i18n.get("unlock"), "icon-lock", MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, () -> {
/*      */                 if (param1BasicLevel.priceInMoney > 0) {
/*      */                   Game.i.progressManager.removeGreenPapers(param1BasicLevel.priceInMoney);
/*      */                 }
/*      */                 
/*      */                 for (byte b = 0; b < param1BasicLevel.priceInResources.length; b++) {
/*      */                   if (param1BasicLevel.priceInResources[b] > 0) {
/*      */                     Game.i.progressManager.removeResources(ResourceType.values[b], param1BasicLevel.priceInResources[b]);
/*      */                   }
/*      */                 } 
/*      */                 
/*      */                 Game.i.basicLevelManager.setPurchased(param1BasicLevel);
/*      */                 
/*      */                 LevelSelectScreen.i(this.a);
/*      */                 
/*      */                 LevelSelectScreen.e(this.a).a(param1BasicLevel);
/*      */                 LevelSelectScreen.e(this.a).a(true, false);
/*      */                 Game.i.soundManager.playStatic(StaticSoundType.SUCCESS);
/*      */               });
/*      */         } else {
/* 1985 */           overlayContinueButton = new OverlayContinueButton(Game.i.localeManager.i18n.get("unlock"), "icon-lock", MaterialColor.ORANGE.P800, MaterialColor.ORANGE.P900, MaterialColor.ORANGE.P700, () -> {
/*      */                 Game.i.soundManager.playStatic(StaticSoundType.FAIL);
/*      */                 
/*      */                 for (byte b = 0; b < param1BasicLevel.openRequirements.size; b++) {
/*      */                   Requirement requirement;
/*      */                   
/*      */                   if (!(requirement = (Requirement)param1BasicLevel.openRequirements.get(b)).isSatisfied()) {
/*      */                     Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_all_conditions_are_met"));
/*      */                     
/*      */                     return;
/*      */                   } 
/*      */                   if (Game.i.progressManager.getGreenPapers() < param1BasicLevel.priceInMoney) {
/*      */                     Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_green_papers"));
/*      */                     return;
/*      */                   } 
/*      */                   Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_resources"));
/*      */                 } 
/*      */               });
/*      */         } 
/* 2004 */         overlayContinueButton.setPosition(812.0F, -13.0F);
/* 2005 */         this.d.addActor((Actor)overlayContinueButton);
/*      */       } 
/*      */ 
/*      */       
/* 2009 */       if (Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.PRESTIGE_MODE)) {
/*      */         ComplexButton complexButton;
/* 2011 */         (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> QuestPrestigeOverlay.i().show())).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-game-over-prestige-button"), 0.0F, 0.0F, 113.0F, 110.0F);
/* 2012 */         complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-crown"), 31.0F, 21.0F, 64.0F, 64.0F);
/* 2013 */         complexButton.setSize(113.0F, 100.0F);
/* 2014 */         complexButton.setPosition(1200.0F, 230.0F);
/* 2015 */         this.d.addActor((Actor)complexButton);
/*      */       } 
/*      */     }
/*      */     
/*      */     private void a(boolean param1Boolean1, boolean param1Boolean2) {
/* 2020 */       if (LevelSelectScreen.g(this.a))
/* 2021 */         return;  float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*      */       
/* 2023 */       if (param1Boolean2) {
/*      */         
/* 2025 */         if (param1Boolean1) {
/* 2026 */           DarkOverlay.i().addCaller("LevelSelectScreen levelMenu", UiManager.MainUiLayer.SCREEN, 102, () -> {
/*      */                 a(false, false);
/*      */                 return true;
/*      */               });
/* 2030 */           LevelSelectScreen.f(this.a).getTable().setVisible(true);
/*      */           
/* 2032 */           LevelSelectScreen.f(this.a).getTable().setTouchable(Touchable.childrenOnly);
/*      */           
/* 2034 */           this.d.clearActions();
/* 2035 */           this.d.addAction((Action)Actions.sequence(
/* 2036 */                 (Action)Actions.scaleTo(1.0F, 1.0F), 
/* 2037 */                 (Action)Actions.moveTo(-Game.i.settingsManager.getScaledViewportHeight() * 2.0F, 0.0F), 
/* 2038 */                 (Action)Actions.moveTo(0.0F, 0.0F, 0.2F * f)));
/*      */         } else {
/*      */           
/* 2041 */           DarkOverlay.i().removeCaller("LevelSelectScreen levelMenu");
/* 2042 */           LevelSelectScreen.f(this.a).getTable().setTouchable(Touchable.disabled);
/*      */           
/* 2044 */           this.d.clearActions();
/* 2045 */           this.d.addAction((Action)Actions.sequence(
/* 2046 */                 (Action)Actions.moveTo(-Game.i.settingsManager.getScaledViewportHeight() * 2.0F, 0.0F, 0.2F * f), 
/* 2047 */                 (Action)Actions.run(() -> LevelSelectScreen.f(this.a).getTable().setVisible(false))));
/*      */         }
/*      */       
/*      */       }
/* 2051 */       else if (param1Boolean1) {
/* 2052 */         DarkOverlay.i().addCaller("LevelSelectScreen levelMenu", UiManager.MainUiLayer.SCREEN, 102, () -> {
/*      */               a(false, false);
/*      */               return true;
/*      */             });
/* 2056 */         LevelSelectScreen.f(this.a).getTable().setVisible(true);
/* 2057 */         LevelSelectScreen.f(this.a).getTable().setTouchable(Touchable.childrenOnly);
/*      */         
/* 2059 */         this.d.clearActions();
/* 2060 */         this.d.addAction((Action)Actions.sequence(
/* 2061 */               (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 2062 */               (Action)Actions.moveTo(0.0F, 0.0F), 
/* 2063 */               (Action)Actions.parallel(
/* 2064 */                 (Action)Actions.sequence(
/* 2065 */                   (Action)Actions.delay(0.1F), 
/* 2066 */                   (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), 
/*      */                 
/* 2068 */                 (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut))));
/*      */       }
/*      */       else {
/*      */         
/* 2072 */         DarkOverlay.i().removeCaller("LevelSelectScreen levelMenu");
/* 2073 */         LevelSelectScreen.f(this.a).getTable().setTouchable(Touchable.disabled);
/*      */         
/* 2075 */         this.d.clearActions();
/* 2076 */         this.d.addAction((Action)Actions.sequence(
/* 2077 */               (Action)Actions.parallel(
/* 2078 */                 (Action)Actions.sequence(
/* 2079 */                   (Action)Actions.delay(0.07F * f), 
/* 2080 */                   (Action)Actions.scaleBy(0.0F, -this.d.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*      */                 
/* 2082 */                 (Action)Actions.scaleBy(-this.d.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*      */               
/* 2084 */               (Action)Actions.run(() -> LevelSelectScreen.f(this.a).getTable().setVisible(false))));
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2089 */       this.b = param1Boolean1;
/*      */       
/* 2091 */       if (!param1Boolean1) {
/* 2092 */         LevelSelectScreen.h(this.a);
/*      */       }
/*      */     }
/*      */     
/*      */     private boolean a() {
/* 2097 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public void dispose() {
/* 2102 */       DarkOverlay.i().removeCaller("LevelSelectScreen levelMenu");
/*      */     }
/*      */     
/*      */     private class EyeButton
/*      */       extends Group {
/*      */       private boolean k;
/*      */       private boolean l;
/*      */       private QuadActor m;
/*      */       
/*      */       private EyeButton(LevelSelectScreen.LevelMenuOverlay this$0, Runnable param2Runnable) {
/* 2112 */         setTransform(false);
/*      */         
/* 2114 */         setSize(92.0F, 52.0F);
/*      */         
/*      */         Color color;
/* 2117 */         (color = MaterialColor.LIGHT_BLUE.P900.cpy()).a = 0.56F;
/* 2118 */         QuadActor quadActor = new QuadActor(color, new float[] { 0.0F, -9.0F, 0.0F, 38.0F, 84.0F, 52.0F, 72.0F, 0.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2124 */         addActor((Actor)quadActor);
/*      */         
/* 2126 */         this.m = new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 52.0F, 84.0F, 52.0F, 72.0F, 0.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2132 */         this.m.setPosition(8.0F, 0.0F);
/* 2133 */         addActor((Actor)this.m);
/*      */         
/*      */         Image image;
/* 2136 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-eye"))).setSize(32.0F, 32.0F);
/* 2137 */         image.setPosition(30.0F, 10.0F);
/* 2138 */         addActor((Actor)image);
/*      */         
/* 2140 */         setTouchable(Touchable.enabled);
/* 2141 */         addListener((EventListener)new ClickListener(this, LevelSelectScreen.LevelMenuOverlay.this, param2Runnable)
/*      */             {
/*      */               public void clicked(InputEvent param3InputEvent, float param3Float1, float param3Float2) {
/* 2144 */                 this.a.run();
/* 2145 */                 Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */               }
/*      */ 
/*      */               
/*      */               public boolean touchDown(InputEvent param3InputEvent, float param3Float1, float param3Float2, int param3Int1, int param3Int2) {
/* 2150 */                 LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b, true);
/* 2151 */                 LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b);
/*      */                 
/* 2153 */                 return super.touchDown(param3InputEvent, param3Float1, param3Float2, param3Int1, param3Int2);
/*      */               }
/*      */ 
/*      */               
/*      */               public void touchUp(InputEvent param3InputEvent, float param3Float1, float param3Float2, int param3Int1, int param3Int2) {
/* 2158 */                 LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b, false);
/* 2159 */                 LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b);
/*      */                 
/* 2161 */                 super.touchUp(param3InputEvent, param3Float1, param3Float2, param3Int1, param3Int2);
/*      */               }
/*      */ 
/*      */               
/*      */               public void enter(InputEvent param3InputEvent, float param3Float1, float param3Float2, int param3Int, Actor param3Actor) {
/* 2166 */                 if (param3Int == -1) {
/* 2167 */                   LevelSelectScreen.LevelMenuOverlay.EyeButton.b(this.b, true);
/* 2168 */                   LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b);
/*      */                 } 
/*      */                 
/* 2171 */                 super.enter(param3InputEvent, param3Float1, param3Float2, param3Int, param3Actor);
/*      */               }
/*      */ 
/*      */               
/*      */               public void exit(InputEvent param3InputEvent, float param3Float1, float param3Float2, int param3Int, Actor param3Actor) {
/* 2176 */                 if (param3Int == -1) {
/* 2177 */                   LevelSelectScreen.LevelMenuOverlay.EyeButton.b(this.b, false);
/* 2178 */                   LevelSelectScreen.LevelMenuOverlay.EyeButton.a(this.b);
/*      */                 } 
/*      */                 
/* 2181 */                 super.exit(param3InputEvent, param3Float1, param3Float2, param3Int, param3Actor);
/*      */               }
/*      */             });
/*      */         
/* 2185 */         d();
/*      */       }
/*      */       
/*      */       private void d() {
/* 2189 */         if (this.k) {
/* 2190 */           this.m.setColor(MaterialColor.LIGHT_BLUE.P900); return;
/* 2191 */         }  if (this.l) {
/* 2192 */           this.m.setColor(MaterialColor.LIGHT_BLUE.P700); return;
/*      */         } 
/* 2194 */         this.m.setColor(MaterialColor.LIGHT_BLUE.P800);
/*      */       }
/*      */     }
/*      */     
/*      */     private class WaveQuestsLine
/*      */       extends Group {
/*      */       private WaveQuestsLine(LevelSelectScreen.LevelMenuOverlay this$0, BasicLevel param2BasicLevel) {
/* 2201 */         setTransform(false);
/* 2202 */         BasicLevelStage basicLevelStage = Game.i.basicLevelManager.getStage(param2BasicLevel.stageName);
/*      */         
/* 2204 */         setSize(870.0F, 176.0F);
/*      */ 
/*      */         
/* 2207 */         Array array = new Array();
/* 2208 */         for (byte b2 = 0; b2 < param2BasicLevel.waveQuests.size; b2++) {
/* 2209 */           BasicLevel.WaveQuest waveQuest = (BasicLevel.WaveQuest)param2BasicLevel.waveQuests.get(b2);
/*      */           WaveMilestoneConfig waveMilestoneConfig;
/* 2211 */           (waveMilestoneConfig = new WaveMilestoneConfig((byte)0)).a = waveQuest.waves;
/* 2212 */           waveMilestoneConfig.b = waveQuest;
/* 2213 */           array.add(waveMilestoneConfig);
/*      */         } 
/*      */         WaveBossSupplier waveBossSupplier;
/* 2216 */         if ((waveBossSupplier = param2BasicLevel.getMap().getBossWaves()) != null) {
/* 2217 */           LevelSelectScreen.l().i("bossWaves exists " + waveBossSupplier, new Object[0]);
/* 2218 */           for (byte b5 = 0; b5 < 'È'; b5++) {
/*      */             BossType bossType;
/* 2220 */             if ((bossType = waveBossSupplier.getWaveBoss(b5)) != null) {
/* 2221 */               LevelSelectScreen.l().i("- " + b5 + " " + bossType, new Object[0]);
/*      */             }
/*      */           } 
/* 2224 */           IntSet intSet = new IntSet(); byte b6;
/* 2225 */           for (b6 = 0; b6 < array.size; b6++) {
/* 2226 */             WaveMilestoneConfig waveMilestoneConfig = (WaveMilestoneConfig)array.get(b6);
/*      */             BossType bossType;
/* 2228 */             if ((bossType = waveBossSupplier.getWaveBoss(waveMilestoneConfig.a)) != null) {
/* 2229 */               waveMilestoneConfig.c = bossType;
/* 2230 */               intSet.add(waveMilestoneConfig.a);
/*      */             } 
/*      */           } 
/*      */           
/* 2234 */           for (b6 = 0; b6 < 'Ϩ'; b6++) {
/*      */             BossType bossType;
/* 2236 */             if ((bossType = waveBossSupplier.getWaveBoss(b6)) != null && !intSet.contains(b6)) {
/*      */               WaveMilestoneConfig waveMilestoneConfig;
/* 2238 */               (waveMilestoneConfig = new WaveMilestoneConfig((byte)0)).a = b6;
/* 2239 */               waveMilestoneConfig.c = bossType;
/* 2240 */               array.add(waveMilestoneConfig);
/*      */             } 
/*      */           } 
/*      */         } 
/* 2244 */         array.sort((param2WaveMilestoneConfig1, param2WaveMilestoneConfig2) -> Integer.compare(param2WaveMilestoneConfig1.a, param2WaveMilestoneConfig2.a));
/*      */ 
/*      */         
/*      */         Group group;
/*      */         
/* 2249 */         (group = new Group()).setTransform(false);
/*      */         
/*      */         ScrollPane scrollPane;
/*      */         
/* 2253 */         UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)group));
/* 2254 */         scrollPane.setSize(868.0F, 176.0F);
/* 2255 */         scrollPane.setPosition(1.0F, 0.0F);
/* 2256 */         addActor((Actor)scrollPane);
/*      */ 
/*      */         
/*      */         Image image3;
/*      */ 
/*      */         
/* 2262 */         (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(new Color(791621631));
/* 2263 */         image3.setSize(80.0F, 176.0F);
/* 2264 */         image3.setTouchable(Touchable.disabled);
/* 2265 */         addActor((Actor)image3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2275 */         int j = ((WaveMilestoneConfig)array.get(array.size - 1)).a;
/*      */ 
/*      */ 
/*      */         
/* 2279 */         int k = 0;
/* 2280 */         int m = 9999;
/* 2281 */         for (byte b4 = 0; b4 < array.size; b4++) {
/* 2282 */           int n = ((WaveMilestoneConfig)array.get(b4)).a - k;
/* 2283 */           k = ((WaveMilestoneConfig)array.get(b4)).a;
/* 2284 */           if (n < m) {
/* 2285 */             m = n;
/*      */           }
/*      */         } 
/* 2288 */         if (m > 10) {
/* 2289 */           m = 10;
/*      */         }
/*      */         
/* 2292 */         float f4 = (float)StrictMath.ceil((50.0F / m));
/* 2293 */         float f5 = j * f4;
/*      */         
/*      */         Image image1;
/*      */         
/* 2297 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(f5, 5.0F);
/* 2298 */         image1.setColor(new Color(488447487));
/* 2299 */         image1.setPosition(80.0F, 133.0F);
/* 2300 */         group.addActor((Actor)image1);
/*      */         
/*      */         int i;
/* 2303 */         if ((i = (ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(param2BasicLevel.name)) - k > 14)
/*      */         {
/* 2305 */           i = k + 14;
/*      */         }
/*      */         
/* 2308 */         if (i != 0) {
/*      */           Image image;
/* 2310 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(i * f4, 5.0F);
/* 2311 */           image.setColor(basicLevelStage.color);
/* 2312 */           image.setPosition(80.0F, 133.0F);
/* 2313 */           group.addActor((Actor)image);
/*      */           
/* 2315 */           if (i != (ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(param2BasicLevel.name)) {
/*      */             
/* 2317 */             float f = 80.0F + (k + 7) * f4 - 17.0F;
/*      */             
/*      */             Image image5;
/* 2320 */             (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(45.0F, 5.0F);
/* 2321 */             image5.setColor(new Color(791621631));
/* 2322 */             image5.setPosition(f - 5.0F, 133.0F);
/* 2323 */             group.addActor((Actor)image5);
/*      */             
/* 2325 */             for (byte b = 0; b < 3; b++) {
/*      */               Image image6;
/*      */               
/* 2328 */               (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(5.0F, 5.0F);
/* 2329 */               image6.setColor(basicLevelStage.color);
/* 2330 */               image6.setPosition(f + 5.0F + (b * 10), 133.0F);
/* 2331 */               group.addActor((Actor)image6);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2337 */         float f3 = 80.0F + i * f4;
/*      */         Image image2;
/* 2339 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("small-triangle-mark-bottom"))).setSize(10.0F, 5.0F);
/* 2340 */         image2.setPosition(f3 - 5.0F, 140.0F);
/* 2341 */         image2.setColor(basicLevelStage.color);
/* 2342 */         group.addActor((Actor)image2);
/*      */         
/*      */         Table table;
/* 2345 */         (table = new Table()).setSize(200.0F, 24.0F);
/* 2346 */         table.setPosition(f3 - 100.0F, 150.0F);
/* 2347 */         group.addActor((Actor)table);
/*      */         
/*      */         Image image4;
/* 2350 */         (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"))).setColor(basicLevelStage.color);
/* 2351 */         table.add((Actor)image4).size(24.0F).padRight(8.0F);
/*      */         
/*      */         Label label;
/* 2354 */         (label = new Label(String.valueOf((ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(param2BasicLevel.name)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(basicLevelStage.color);
/* 2355 */         table.add((Actor)label);
/*      */         
/* 2357 */         for (byte b1 = 0; b1 < array.size; b1++) {
/* 2358 */           WaveMilestoneConfig waveMilestoneConfig = (WaveMilestoneConfig)array.get(b1);
/*      */           
/* 2360 */           float f6 = 80.0F + f4 * waveMilestoneConfig.a;
/*      */           
/* 2362 */           Image image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-milestone-top"));
/* 2363 */           if (waveMilestoneConfig.b != null && waveMilestoneConfig.b.isCompleted()) {
/*      */             
/* 2365 */             image.setColor(basicLevelStage.color);
/* 2366 */             image.getColor().lerp(new Color(488447487), 0.44F);
/*      */           }
/*      */           else {
/*      */             
/* 2370 */             image.setColor(new Color(488447487));
/*      */           } 
/* 2372 */           image.setPosition(f6 - 24.0F, 114.0F);
/* 2373 */           image.setSize(48.0F, 13.0F);
/* 2374 */           group.addActor((Actor)image);
/*      */ 
/*      */           
/* 2377 */           (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(488447487));
/*      */ 
/*      */           
/* 2380 */           float f7 = 36.0F;
/* 2381 */           if (waveMilestoneConfig.b != null) {
/* 2382 */             int n = waveMilestoneConfig.b.prizes.size;
/* 2383 */             for (byte b = 0; b < waveMilestoneConfig.b.prizes.size; b++) {
/* 2384 */               if (((ItemStack[])waveMilestoneConfig.b.prizes.items)[b].getItem() instanceof com.prineside.tdi2.items.StarItem) {
/*      */                 
/* 2386 */                 n--;
/*      */                 break;
/*      */               } 
/*      */             } 
/* 2390 */             f7 = 36.0F + n * 26.0F;
/*      */           } 
/* 2392 */           if (waveMilestoneConfig.c != null) {
/* 2393 */             f7 += 58.0F;
/*      */           }
/*      */           
/* 2396 */           image4.setPosition(f6 - 24.0F, 114.0F - f7);
/* 2397 */           image4.setSize(48.0F, f7);
/* 2398 */           group.addActor((Actor)image4);
/*      */           
/* 2400 */           if (waveMilestoneConfig.b != null && waveMilestoneConfig.b.isCompleted()) {
/*      */             Image image5;
/*      */             
/* 2403 */             (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(image.getColor());
/* 2404 */             image5.setPosition(f6 - 24.0F, 78.0F);
/* 2405 */             image5.setSize(48.0F, 36.0F);
/* 2406 */             group.addActor((Actor)image5);
/*      */           } 
/*      */           
/*      */           Label label1;
/*      */           
/* 2411 */           (label1 = new Label(String.valueOf(waveMilestoneConfig.a), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(48.0F, 10.0F);
/* 2412 */           label1.setAlignment(4);
/* 2413 */           label1.setPosition(f6 - 24.0F, 90.0F);
/* 2414 */           group.addActor((Actor)label1);
/*      */ 
/*      */           
/* 2417 */           if (waveMilestoneConfig.c != null) {
/*      */             Image image5;
/* 2419 */             (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("level-select-wave-marker-boss-frame"))).setSize(67.0F, 58.0F);
/* 2420 */             image5.setPosition(f6 - 28.0F, 38.0F);
/* 2421 */             group.addActor((Actor)image5);
/*      */ 
/*      */             
/* 2424 */             (image = new Image((LevelSelectScreen.LevelMenuOverlay.b(LevelSelectScreen.LevelMenuOverlay.this) == null) ? (TextureRegion)Game.i.assetManager.getTextureRegion("icon-question") : (LevelSelectScreen.LevelMenuOverlay.b(LevelSelectScreen.LevelMenuOverlay.this)).wave.getWaveProcessorFactory(waveMilestoneConfig.c).getIconTexture())).setSize(32.0F, 32.0F);
/* 2425 */             image.setPosition(f6 - 16.0F, 48.0F);
/* 2426 */             group.addActor((Actor)image);
/*      */           } 
/*      */ 
/*      */           
/* 2430 */           if (waveMilestoneConfig.b != null) {
/* 2431 */             float f = 62.0F;
/* 2432 */             if (waveMilestoneConfig.c != null) {
/* 2433 */               f = 8.0F;
/*      */             }
/* 2435 */             byte b5 = 0;
/* 2436 */             for (byte b6 = 0; b6 < waveMilestoneConfig.b.prizes.size; b6++) {
/*      */               Actor actor;
/*      */               ItemStack itemStack;
/* 2439 */               if ((itemStack = (ItemStack)waveMilestoneConfig.b.prizes.get(b6)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/*      */                 Actor actor1;
/*      */                 
/* 2442 */                 (actor1 = itemStack.getItem().generateIcon(24.0F, false)).setPosition(f6 - 17.0F, 125.0F);
/* 2443 */                 actor1.setColor(new Color(791621631));
/* 2444 */                 group.addActor(actor1);
/*      */ 
/*      */                 
/* 2447 */                 (actor1 = itemStack.getItem().generateIcon(24.0F, false)).setPosition(f6 - 7.0F, 125.0F);
/* 2448 */                 actor1.setColor(new Color(791621631));
/* 2449 */                 group.addActor(actor1);
/*      */ 
/*      */                 
/* 2452 */                 (actor = itemStack.getItem().generateIcon(24.0F, false)).setPosition(f6 - 12.0F, 125.0F);
/* 2453 */                 if (waveMilestoneConfig.b.isCompleted())
/*      */                 {
/* 2455 */                   actor.setColor(basicLevelStage.color);
/*      */                 }
/*      */                 
/* 2458 */                 group.addActor(actor);
/*      */               } else {
/*      */                 Actor actor1;
/*      */                 
/* 2462 */                 (actor1 = actor.getItem().generateIcon(24.0F, true)).setPosition(f6 - 12.0F, f - b5 * 26.0F);
/* 2463 */                 group.addActor(actor1);
/*      */                 
/* 2465 */                 actor1.setTouchable(Touchable.enabled);
/* 2466 */                 actor1.addListener((EventListener)new ClickListener(this, LevelSelectScreen.LevelMenuOverlay.this, waveMilestoneConfig, (ItemStack)actor)
/*      */                     {
/*      */                       public void clicked(InputEvent param3InputEvent, float param3Float1, float param3Float2) {
/* 2469 */                         if (this.a.b.isCompleted()) {
/* 2470 */                           ItemDescriptionDialog.i().showWithCount(this.b.getItem(), this.b.getCount());
/*      */                         } else {
/* 2472 */                           ItemDescriptionDialog.i().show(this.b.getItem());
/*      */                         } 
/* 2474 */                         Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                       }
/*      */                     });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2486 */                 b5++;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 2492 */         SnapshotArray snapshotArray = group.getChildren();
/* 2493 */         float f1 = 0.0F;
/* 2494 */         for (byte b3 = 0; b3 < snapshotArray.size; b3++) {
/*      */           float f;
/* 2496 */           if ((f = ((Actor)snapshotArray.get(b3)).getX() + ((Actor)snapshotArray.get(b3)).getWidth()) > f1) {
/* 2497 */             f1 = f;
/*      */           }
/*      */         } 
/*      */         
/* 2501 */         f1 += 40.0F;
/* 2502 */         group.setSize(f1, 176.0F);
/*      */         
/* 2504 */         scrollPane.layout();
/*      */         float f2;
/* 2506 */         if ((f2 = f3 - 435.0F) > 0.0F) scrollPane.setScrollX(f2); 
/*      */       }
/*      */       
/*      */       private class WaveMilestoneConfig
/*      */       {
/*      */         int a;
/*      */         BasicLevel.WaveQuest b;
/*      */         BossType c;
/*      */         
/*      */         private WaveMilestoneConfig(LevelSelectScreen.LevelMenuOverlay.WaveQuestsLine this$0) {}
/*      */       }
/*      */     }
/*      */     
/*      */     private class QuestsList
/*      */       extends Group {
/*      */       private QuestsList(LevelSelectScreen.LevelMenuOverlay this$0, BasicLevel param2BasicLevel) {
/* 2522 */         setTransform(false);
/*      */         
/* 2524 */         setSize(870.0F, 222.0F);
/*      */ 
/*      */         
/*      */         float f1;
/*      */ 
/*      */         
/* 2530 */         if ((f1 = (f1 = param2BasicLevel.quests.size * 54.0F) + 52.0F) < 220.0F) {
/* 2531 */           f1 = 220.0F;
/*      */         }
/*      */         
/*      */         Group group;
/* 2535 */         (group = new Group()).setTransform(false);
/* 2536 */         group.setSize(870.0F, f1);
/*      */         
/*      */         ScrollPane scrollPane;
/* 2539 */         UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)group));
/* 2540 */         scrollPane.setPosition(0.0F, 1.0F);
/* 2541 */         scrollPane.setSize(870.0F, 220.0F);
/* 2542 */         addActor((Actor)scrollPane);
/*      */ 
/*      */         
/*      */         Image image;
/*      */         
/* 2547 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(new Color(791621631));
/* 2548 */         image.setSize(870.0F, 52.0F);
/* 2549 */         image.setTouchable(Touchable.disabled);
/* 2550 */         addActor((Actor)image);
/*      */ 
/*      */         
/* 2553 */         byte b1 = 0;
/* 2554 */         int i = Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.REGULAR_QUESTS_SLOTS);
/* 2555 */         boolean bool = true;
/* 2556 */         for (byte b2 = 0; b2 < param2BasicLevel.waveQuests.size; b2++) {
/* 2557 */           if (!((BasicLevel.WaveQuest[])param2BasicLevel.waveQuests.items)[b2].isCompleted()) {
/* 2558 */             bool = false;
/*      */             break;
/*      */           } 
/*      */         } 
/* 2562 */         if (bool) {
/* 2563 */           i++;
/*      */         }
/*      */         
/* 2566 */         float f2 = 0.0F;
/*      */         
/* 2568 */         Array array = new Array(ItemStack.class);
/* 2569 */         for (byte b3 = 0; b3 < param2BasicLevel.quests.size; b3++) {
/* 2570 */           Cell cell; BasicLevelQuestConfig basicLevelQuestConfig = (BasicLevelQuestConfig)param2BasicLevel.quests.get(b3);
/* 2571 */           float f = f1 - b3 * 54.0F - 52.0F;
/*      */           
/*      */           Image image1;
/* 2574 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(0.0F, 0.0F, 0.0F, 0.14F));
/* 2575 */           image1.setSize(870.0F, 52.0F);
/* 2576 */           image1.setPosition(0.0F, f);
/* 2577 */           group.addActor((Actor)image1);
/*      */           
/* 2579 */           if (basicLevelQuestConfig.isCompleted()) {
/*      */             Color color;
/* 2581 */             (color = MaterialColor.GREEN.P500.cpy()).a = 0.07F;
/* 2582 */             image1.setColor(color);
/*      */ 
/*      */ 
/*      */             
/* 2586 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-right"))).setColor(MaterialColor.GREEN.P500);
/* 2587 */             (image1.getColor()).a = 0.28F;
/* 2588 */             image1.setSize(870.0F, 52.0F);
/* 2589 */             image1.setPosition(0.0F, f);
/* 2590 */             group.addActor((Actor)image1);
/*      */ 
/*      */           
/*      */           }
/* 2594 */           else if (f2 == 0.0F) {
/* 2595 */             f2 = f;
/*      */           } 
/*      */ 
/*      */           
/*      */           Table table;
/*      */           
/* 2601 */           (table = new Table()).setSize(870.0F, 52.0F);
/* 2602 */           table.setPosition(0.0F, f);
/* 2603 */           group.addActor((Actor)table);
/*      */           
/* 2605 */           boolean bool1 = (b1 >= i && !basicLevelQuestConfig.isScripted()) ? true : false;
/*      */ 
/*      */           
/* 2608 */           Label label1 = new Label(bool1 ? "[#777777]???????[]" : basicLevelQuestConfig.getTitle(true, true), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 2609 */           table.add((Actor)label1).padLeft(12.0F).padRight(12.0F);
/*      */ 
/*      */           
/* 2612 */           array.clear();
/* 2613 */           array.addAll(basicLevelQuestConfig.getPrizes(Game.i.gameValueManager.getSnapshot()));
/* 2614 */           int j = basicLevelQuestConfig.getExtraDustInEndless((GameValueProvider)Game.i.gameValueManager.getSnapshot());
/* 2615 */           if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode()) && j > 0) {
/* 2616 */             array.add(new ItemStack((Item)Item.D.BIT_DUST, j));
/*      */           }
/* 2618 */           for (j = 0; j < array.size; j++) {
/*      */             Image image2;
/*      */             
/*      */             float f3, f4;
/*      */             
/*      */             ItemStack itemStack;
/* 2624 */             if ((itemStack = ((ItemStack[])array.items)[j])
/*      */               
/* 2626 */               .getItem() instanceof com.prineside.tdi2.items.StarItem || itemStack.getItem().getType() == ItemType.GREEN_PAPER || itemStack.getItem().getType() == ItemType.ACCELERATOR) {
/*      */ 
/*      */ 
/*      */               
/* 2630 */               Actor actor = itemStack.getItem().generateIcon(32.0F, true);
/* 2631 */               f3 = 32.0F;
/*      */               
/* 2633 */               f4 = 0.0F;
/* 2634 */               actor.setTouchable(Touchable.enabled);
/* 2635 */               actor.addListener((EventListener)new ClickListener(this, LevelSelectScreen.LevelMenuOverlay.this, basicLevelQuestConfig, itemStack)
/*      */                   {
/*      */                     public void clicked(InputEvent param3InputEvent, float param3Float1, float param3Float2) {
/* 2638 */                       if (this.a.isCompleted()) {
/* 2639 */                         ItemDescriptionDialog.i().showWithCount(this.b.getItem(), this.b.getCount());
/*      */                       } else {
/* 2641 */                         ItemDescriptionDialog.i().show(this.b.getItem());
/*      */                       } 
/* 2643 */                       Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                     }
/*      */                   });
/*      */             } else {
/*      */               
/* 2648 */               image2 = new Image(Game.i.uiManager.getItemCellRarityCoat(itemStack.getItem().getRarity(), j % 2));
/* 2649 */               f3 = 29.0F;
/*      */               
/* 2651 */               f4 = 2.0F;
/*      */             } 
/* 2653 */             image2.setSize(f3, 32.0F);
/*      */             
/*      */             Group group1;
/* 2656 */             (group1 = new Group()).setTransform(false);
/* 2657 */             group1.addActor((Actor)image2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2667 */             table.add((Actor)group1).size(f3, 32.0F).padLeft(f4).padRight(f4 + 2.0F);
/*      */           } 
/*      */           
/* 2670 */           table.add().expand();
/*      */ 
/*      */           
/* 2673 */           if ((j = Game.i.basicLevelManager.getQuestSkipPrice(basicLevelQuestConfig)) > 0)
/*      */           {
/* 2675 */             if (!Game.i.dailyQuestManager.getDailyLootCurrentQuest().equals(basicLevelQuestConfig.id)) {
/*      */               PaddedImageButton paddedImageButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2687 */               (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-double-triangle-right"), () -> { String str = Game.i.localeManager.i18n.format("regular_quest_skip_confirm", new Object[] { Integer.valueOf(param2Int) }); Dialog.i().showConfirm(str, ()); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600)).setIconSize(32.0F, 32.0F);
/* 2688 */               paddedImageButton.setIconPosition(16.0F, 10.0F);
/* 2689 */               table.add((Actor)paddedImageButton).size(64.0F, 52.0F).padRight(15.0F);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/* 2694 */           Label label2 = new Label(bool1 ? "[#777777]??? / ???[]" : basicLevelQuestConfig.formatValueForUiWithRequiredValue(basicLevelQuestConfig.getCurrentValue(Game.i.gameValueManager.getSnapshot()), basicLevelQuestConfig.getRequiredValue(Game.i.gameValueManager.getSnapshot()), true), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 2695 */           table.add((Actor)label2);
/*      */ 
/*      */ 
/*      */           
/* 2699 */           if (basicLevelQuestConfig.isCompleted()) {
/*      */             Image image2;
/* 2701 */             (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setColor(MaterialColor.GREEN.P500);
/* 2702 */             cell = table.add((Actor)image2);
/*      */           } else {
/* 2704 */             cell = table.add();
/*      */           } 
/* 2706 */           cell.size(32.0F).padRight(40.0F).padLeft(12.0F);
/*      */           
/* 2708 */           if (!basicLevelQuestConfig.isCompleted()) {
/* 2709 */             b1++;
/*      */           }
/*      */         } 
/*      */         
/* 2713 */         if (f2 != 0.0F)
/* 2714 */           scrollPane.scrollTo(0.0F, f2, 1.0F, 1.0F, false, true); 
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\LevelSelectScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */