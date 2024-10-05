/*      */ package com.prineside.tdi2.screens;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.InputAdapter;
/*      */ import com.badlogic.gdx.InputMultiplexer;
/*      */ import com.badlogic.gdx.InputProcessor;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
/*      */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.CameraController;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.managers.GameValueManager;
/*      */ import com.prineside.tdi2.managers.ResearchManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.SideMenu;
/*      */ import com.prineside.tdi2.ui.components.ResearchMenu;
/*      */ import com.prineside.tdi2.ui.components.ResearchScreenInventory;
/*      */ import com.prineside.tdi2.ui.shared.BackButton;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.ProfileSummary;
/*      */ import com.prineside.tdi2.ui.shared.ResourcesAndMoney;
/*      */ import com.prineside.tdi2.utils.DrawUtils;
/*      */ import com.prineside.tdi2.utils.IntRectangle;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class ResearchesScreen extends Screen {
/*   63 */   private static final TLog a = TLog.forClass(ResearchesScreen.class);
/*      */   
/*   65 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 104, "ResearchesScreen inventory");
/*   66 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 106, "ResearchesScreen");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   74 */   private final InputMultiplexer d = new InputMultiplexer();
/*      */   
/*      */   private OrthographicCamera e;
/*      */   
/*      */   public CameraController cameraController;
/*   79 */   private static final Color f = MaterialColor.TEAL.P500;
/*   80 */   private static final Color g = new Color(1.0F, 1.0F, 1.0F, 0.21F);
/*   81 */   private static final Color h = MaterialColor.RED.P800;
/*      */ 
/*      */   
/*   84 */   private static final Color i = MaterialColor.TEAL.P500;
/*   85 */   private static final Color j = MaterialColor.AMBER.P500;
/*   86 */   private static final Color k = MaterialColor.GREY.P700;
/*   87 */   private static final Color l = MaterialColor.PURPLE.P300;
/*   88 */   private static final Color m = MaterialColor.PURPLE.P600;
/*      */   
/*   90 */   private static final Color n = new Color(1.0F, 1.0F, 1.0F, 0.14F);
/*   91 */   private static final Color o = MaterialColor.LIGHT_BLUE.P500;
/*      */   
/*      */   private TextureRegion p;
/*      */   
/*      */   private TextureRegion q;
/*      */   private TextureRegion r;
/*      */   private TextureRegion s;
/*      */   private TextureRegion t;
/*      */   private TextureRegion u;
/*      */   private TextureRegion v;
/*      */   private TextureRegion w;
/*      */   private TextureRegion x;
/*      */   private TextureRegion y;
/*      */   private BitmapFont z;
/*      */   private BitmapFont A;
/*      */   private SideMenu B;
/*      */   private ResearchMenu C;
/*      */   private boolean D = true;
/*      */   private ResearchScreenInventory E;
/*      */   private Group F;
/*      */   private Label G;
/*      */   private ParticleEffect H;
/*      */   private ParticleEffectPool I;
/*  114 */   private DelayedRemovalArray<ParticleEffectPool.PooledEffect> J = new DelayedRemovalArray(false, 1, ParticleEffectPool.PooledEffect.class);
/*  115 */   private final DelayedRemovalArray<ItemStack> K = new DelayedRemovalArray(true, 1, ItemStack.class);
/*      */   
/*  117 */   public Research hoveredResearch = null;
/*  118 */   public Research selectedResearch = null;
/*      */   
/*  120 */   private float L = 0.0F;
/*  121 */   private static final float[] M = new float[9];
/*  122 */   private static final StringBuilder N = new StringBuilder();
/*      */   
/*      */   private PolygonSpriteBatch O;
/*      */   
/*  126 */   private final _ResearchManagerListener P = new _ResearchManagerListener((byte)0);
/*  127 */   private final DelayedRemovalArray<ResearchesScreenListener> Q = new DelayedRemovalArray(false, 1);
/*      */   
/*  129 */   private static final IntRectangle R = new IntRectangle();
/*  130 */   private static final Color S = new Color();
/*      */   
/*      */   private float T;
/*      */   
/*      */   private static void b() {
/*  135 */     Array array = Game.i.researchManager.getInstances();
/*  136 */     boolean bool = (Game.i.progressManager.getDifficultyMode() != DifficultyMode.NORMAL) ? true : false;
/*  137 */     for (byte b = 0; b < array.size; b++) {
/*      */       Research research;
/*  139 */       if ((research = ((Research[])array.items)[b]).type == ResearchType.ROOT || research.unlocksTower) {
/*  140 */         research.setInstalledLevel(1);
/*  141 */       } else if (research.type
/*  142 */         .name().endsWith("MAX_EXP_LEVEL") || research.type
/*  143 */         .name().endsWith("MAX_UPGRADE_LEVEL") || research.type
/*  144 */         .name().startsWith("MINER_TYPE_") || research.type
/*  145 */         .name().startsWith("MODIFIER_TYPE_") || research.type
/*  146 */         .name().startsWith("STORYLINE_")) {
/*      */         
/*  148 */         research.setInstalledLevel(bool ? research.maxEndlessLevel : research.levels.length);
/*      */       } else {
/*  150 */         research.setInstalledLevel(0);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void c() {
/*  156 */     Array array = Game.i.researchManager.getInstances();
/*  157 */     boolean bool = (Game.i.progressManager.getDifficultyMode() != DifficultyMode.NORMAL) ? true : false;
/*  158 */     for (byte b = 0; b < array.size; b++) {
/*  159 */       Research research = ((Research[])array.items)[b];
/*      */       int i;
/*  161 */       if ((i = (bool ? research.maxEndlessLevel : research.levels.length) / 2) <= 0) i = 1; 
/*  162 */       if (research.getInstalledLevel() < i) {
/*  163 */         research.setInstalledLevel(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void d() {
/*  169 */     Array array = Game.i.researchManager.getInstances();
/*  170 */     boolean bool = (Game.i.progressManager.getDifficultyMode() != DifficultyMode.NORMAL) ? true : false;
/*  171 */     for (byte b = 0; b < array.size; b++) {
/*      */       Research research;
/*  173 */       (research = ((Research[])array.items)[b]).setInstalledLevel(bool ? research.maxEndlessLevel : research.levels.length);
/*      */     } 
/*      */   }
/*      */   
/*      */   public ResearchesScreen() {
/*  178 */     this(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ResearchesScreen(ResearchType paramResearchType) {
/*  184 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     
/*  186 */     ScreenTitle.i().setVisible(true)
/*  187 */       .setText(Game.i.localeManager.i18n.get("researches"))
/*  188 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-research"));
/*      */     
/*  190 */     ResourcesAndMoney.i().setVisible(false);
/*      */     
/*  192 */     ProfileSummary.i().setVisible(false);
/*      */     
/*  194 */     BackButton.i().setClickHandler(() -> Game.i.screenManager.goToMainMenu())
/*  195 */       .setText(null)
/*  196 */       .setVisible(true);
/*      */     
/*  198 */     InventoryOverlay.i()
/*  199 */       .hideWithToggleButton(true);
/*      */     
/*  201 */     Game.i.researchManager.updateAndValidateStarBranch();
/*      */     
/*  203 */     this.p = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-background");
/*  204 */     this.q = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-background-small");
/*  205 */     this.r = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-background-invisible");
/*  206 */     this.s = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-infinitode-1-logo");
/*  207 */     this.t = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-selection");
/*  208 */     this.u = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-selection-small");
/*  209 */     this.v = (TextureRegion)Game.i.assetManager.getTextureRegion("blank");
/*  210 */     this.w = (TextureRegion)Game.i.assetManager.getTextureRegion("particle-triangle");
/*  211 */     this.y = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-star");
/*  212 */     this.x = (TextureRegion)Game.i.assetManager.getTextureRegion("global-upgrades-icon-level-overlay");
/*  213 */     this.z = (BitmapFont)Game.i.assetManager.getFont(21);
/*  214 */     this.A = (BitmapFont)Game.i.assetManager.getFont(24);
/*      */ 
/*      */     
/*  217 */     this.e = new OrthographicCamera(Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*  218 */     this.cameraController = new CameraController(this.e, Game.i.researchManager.getMapWidth(), Game.i.researchManager.getMapHeight());
/*  219 */     this.cameraController.setScreenSize(Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*  220 */     this.cameraController.setZoomBoundaries(2.0F, 1.75F);
/*  221 */     this.cameraController.zoom = 4.0D;
/*  222 */     this.cameraController.lookAt((Game.i.researchManager.getMapWidth() / 2), (Game.i.researchManager.getMapHeight() / 2));
/*  223 */     this.e.update();
/*      */ 
/*      */     
/*  226 */     this.d.addProcessor((InputProcessor)Game.i.uiManager.stage);
/*  227 */     this.d.addProcessor(this.cameraController.getInputProcessor());
/*  228 */     this.d.addProcessor((InputProcessor)new InputAdapter(this) {
/*  229 */           private final Vector2 a = new Vector2();
/*      */ 
/*      */           
/*      */           public boolean mouseMoved(int param1Int1, int param1Int2) {
/*  233 */             this.a.set(param1Int1, param1Int2);
/*  234 */             this.b.cameraController.screenToMap(this.a);
/*  235 */             this.a.x += Game.i.researchManager.getMapMinX();
/*  236 */             this.a.y += Game.i.researchManager.getMapMinY();
/*      */             
/*      */             Array array;
/*  239 */             for (Array.ArrayIterator<Research> arrayIterator = (array = Game.i.researchManager.getInstances()).iterator(); arrayIterator.hasNext(); ) { Research research = arrayIterator.next();
/*  240 */               if (ResearchesScreen.a(this.b, research, this.a) && Game.i.researchManager.isVisible(research)) {
/*  241 */                 ResearchesScreen.a(this.b, research);
/*  242 */                 return false;
/*      */               }  }
/*      */             
/*  245 */             ResearchesScreen.a(this.b, (Research)null);
/*      */             
/*  247 */             return false;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  252 */             this.a.set(param1Int1, param1Int2);
/*  253 */             this.b.cameraController.screenToMap(this.a);
/*  254 */             this.a.x += Game.i.researchManager.getMapMinX();
/*  255 */             this.a.y += Game.i.researchManager.getMapMinY();
/*      */             
/*      */             Array array;
/*  258 */             for (Array.ArrayIterator<Research> arrayIterator = (array = Game.i.researchManager.getInstances()).iterator(); arrayIterator.hasNext(); ) { Research research = arrayIterator.next();
/*  259 */               if (ResearchesScreen.a(this.b, research, this.a) && Game.i.researchManager.isVisible(research)) {
/*  260 */                 ResearchesScreen.b(this.b, research);
/*      */                 
/*  262 */                 return false;
/*      */               }  }
/*      */             
/*  265 */             ResearchesScreen.b(this.b, null);
/*      */             
/*  267 */             return false;
/*      */           }
/*      */         });
/*      */ 
/*      */     
/*  272 */     this.B = new SideMenu(600.0F);
/*  273 */     this.B.sideShadow.setVisible(false);
/*      */     
/*      */     Image image1;
/*      */     
/*  277 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-research-menu-top"))).setSize(600.0F, 15.0F);
/*  278 */     image1.setColor(new Color(724249599));
/*  279 */     image1.setPosition(0.0F, 978.0F);
/*  280 */     image1.setTouchable(Touchable.disabled);
/*  281 */     this.B.getBackgroundContainer().addActor((Actor)image1);
/*      */ 
/*      */     
/*  284 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 978.0F);
/*  285 */     image1.setColor(new Color(724249599));
/*  286 */     image1.setTouchable(Touchable.disabled);
/*  287 */     this.B.getBackgroundContainer().addActor((Actor)image1);
/*      */     
/*  289 */     this.C = new ResearchMenu(this.B, this);
/*      */     
/*      */     Group group;
/*      */     
/*  293 */     (group = new Group()).setTransform(false);
/*  294 */     group.setTouchable(Touchable.enabled);
/*  295 */     group.addListener((EventListener)new ClickListener(this)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  298 */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("research_tip_stars"));
/*      */           }
/*      */         });
/*  301 */     this.c.getTable().add((Actor)group).size(200.0F, 32.0F).expand().top().left().padTop(109.0F).padLeft(136.0F);
/*      */     
/*  303 */     if (Config.isModdingMode()) {
/*      */       PaddedImageButton paddedImageButton1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  315 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-restart"), () -> Game.i.researchManager.reloadNew(), MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setPosition(0.0F, -64.0F);
/*  316 */       paddedImageButton1.setSize(64.0F, 64.0F);
/*  317 */       paddedImageButton1.setIconSize(48.0F, 48.0F);
/*  318 */       paddedImageButton1.setIconPosition(8.0F, 8.0F);
/*  319 */       group.addActor((Actor)paddedImageButton1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  326 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-density-low"), () -> { b(); Game.i.researchManager.checkResearchesStatus(false); Notifications.i().add("Minimal research enabled", null, null, StaticSoundType.SUCCESS); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setPosition(64.0F, -64.0F);
/*  327 */       paddedImageButton1.setSize(64.0F, 64.0F);
/*  328 */       paddedImageButton1.setIconSize(48.0F, 48.0F);
/*  329 */       paddedImageButton1.setIconPosition(8.0F, 8.0F);
/*  330 */       group.addActor((Actor)paddedImageButton1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  338 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-density-medium"), () -> { b(); c(); Game.i.researchManager.checkResearchesStatus(false); Notifications.i().add("Average research enabled", null, null, StaticSoundType.SUCCESS); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setPosition(128.0F, -64.0F);
/*  339 */       paddedImageButton1.setSize(64.0F, 64.0F);
/*  340 */       paddedImageButton1.setIconSize(48.0F, 48.0F);
/*  341 */       paddedImageButton1.setIconPosition(8.0F, 8.0F);
/*  342 */       group.addActor((Actor)paddedImageButton1);
/*      */ 
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton2;
/*      */ 
/*      */       
/*  349 */       (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-density-high"), () -> { d(); Game.i.researchManager.checkResearchesStatus(false); Notifications.i().add("Full research enabled", null, null, StaticSoundType.SUCCESS); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setPosition(192.0F, -64.0F);
/*  350 */       paddedImageButton2.setSize(64.0F, 64.0F);
/*  351 */       paddedImageButton2.setIconSize(48.0F, 48.0F);
/*  352 */       paddedImageButton2.setIconPosition(8.0F, 8.0F);
/*  353 */       group.addActor((Actor)paddedImageButton2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  370 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-backpack-arrow-down"), () -> { String str = GameValueManager.createSnapshot(null, Game.i.progressManager.getDifficultyMode(), false, Game.i.basicLevelManager.getLevel("1.1"), false, false, Game.i.progressManager.createProgressSnapshotForState()).toJson(); a.i(str, new Object[0]); Gdx.app.getClipboard().setContents(str); Notifications.i().add("Game value snapshot saved to clipboard", null, null, StaticSoundType.SUCCESS); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setPosition(256.0F, -64.0F);
/*  371 */       paddedImageButton1.setSize(64.0F, 64.0F);
/*  372 */       paddedImageButton1.setIconSize(48.0F, 48.0F);
/*  373 */       paddedImageButton1.setIconPosition(8.0F, 8.0F);
/*  374 */       group.addActor((Actor)paddedImageButton1);
/*      */     } 
/*      */     
/*      */     Image image2;
/*  378 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setPosition(0.0F, 0.0F);
/*  379 */     image2.setSize(32.0F, 32.0F);
/*  380 */     image2.setColor(MaterialColor.AMBER.P500);
/*  381 */     group.addActor((Actor)image2);
/*      */     
/*  383 */     this.G = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  384 */     this.G.setPosition(42.0F, 0.0F);
/*  385 */     this.G.setSize(100.0F, 32.0F);
/*  386 */     this.G.setColor(MaterialColor.AMBER.P500);
/*  387 */     group.addActor((Actor)this.G);
/*      */     
/*  389 */     updateStarsCount();
/*      */     
/*  391 */     this.F = new Group();
/*  392 */     this.F.setTransform(false);
/*  393 */     this.F.setSize(292.0F, 117.0F);
/*  394 */     this.F.setTouchable(Touchable.childrenOnly);
/*      */     
/*  396 */     (image2 = new Image((Drawable)Game.i.assetManager.getQuad("ui.researchScreenInventory.toggleButton"))).setSize(292.0F, 117.0F);
/*  397 */     this.F.addActor((Actor)image2);
/*      */ 
/*      */     
/*  400 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-backpack"))).setSize(64.0F, 64.0F);
/*  401 */     image2.setPosition(123.0F, 27.0F);
/*  402 */     this.F.addActor((Actor)image2);
/*      */     
/*      */     Actor actor;
/*  405 */     (actor = new Actor()).setTouchable(Touchable.enabled);
/*  406 */     actor.setSize(128.0F, 117.0F);
/*  407 */     actor.setPosition(92.0F, 0.0F);
/*  408 */     actor.addListener((EventListener)new InputListener(this, image2) {
/*      */           private boolean a;
/*      */           
/*      */           private void a() {
/*  412 */             if (this.a) {
/*  413 */               this.b.setColor(MaterialColor.LIGHT_BLUE.P300); return;
/*      */             } 
/*  415 */             this.b.setColor(Color.WHITE);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  421 */             this.a = true;
/*  422 */             a();
/*      */           }
/*      */ 
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  427 */             this.a = false;
/*  428 */             a();
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  433 */             ResearchesScreen.a(this.c, true);
/*  434 */             return true;
/*      */           }
/*      */         });
/*  437 */     this.F.addActor(actor);
/*      */     
/*  439 */     this.b.getTable().addActor((Actor)this.F);
/*      */     
/*  441 */     this.E = new ResearchScreenInventory();
/*  442 */     this.b.getTable().addActor((Actor)this.E);
/*      */ 
/*      */     
/*      */     PaddedImageButton paddedImageButton;
/*      */     
/*  447 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right-hollow"), () -> this.D = false, Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500)).setIconPosition(79.0F, 25.0F);
/*  448 */     paddedImageButton.setIconSize(48.0F, 48.0F);
/*  449 */     paddedImageButton.setSize(205.0F, 96.0F);
/*  450 */     this.E.addActor((Actor)paddedImageButton);
/*      */ 
/*      */     
/*  453 */     this.H = new ParticleEffect();
/*  454 */     this.H.load(Gdx.files.internal("particles/research.prt"), Game.i.assetManager.getTextureRegion("icon-research").getAtlas());
/*  455 */     this.H.setEmittersCleanUpBlendFunction(false);
/*      */     
/*  457 */     this.I = Game.i.assetManager.getParticleEffectPool("research-completed.prt");
/*      */ 
/*      */     
/*  460 */     Game.i.researchManager.addListener((ResearchManager.ResearchManagerListener)this.P);
/*      */     
/*  462 */     if (paramResearchType != null) {
/*  463 */       Research research = Game.i.researchManager.getResearchInstance(paramResearchType);
/*  464 */       this.cameraController.setZoom(this.cameraController.getMinZoom());
/*  465 */       this.cameraController.lookAt((research.x - Game.i.researchManager.getMapMinX()), (research.y - Game.i.researchManager.getMapMinY()));
/*  466 */       b(research);
/*      */     } 
/*      */ 
/*      */     
/*  470 */     this.O = new PolygonSpriteBatch();
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
/*      */   public void updateStarsCount() {
/*  492 */     Game.i.researchManager.updateAndValidateStarBranch();
/*  493 */     this.G.setTextFromInt(Game.i.researchManager.getUnusedStarsCount());
/*      */   }
/*      */   
/*      */   public void addListener(ResearchesScreenListener paramResearchesScreenListener) {
/*  497 */     if (paramResearchesScreenListener == null) {
/*  498 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  501 */     if (!this.Q.contains(paramResearchesScreenListener, true)) {
/*  502 */       this.Q.add(paramResearchesScreenListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(ResearchesScreenListener paramResearchesScreenListener) {
/*  507 */     if (paramResearchesScreenListener == null) {
/*  508 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  511 */     this.Q.removeValue(paramResearchesScreenListener, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void show() {
/*  516 */     Gdx.input.setInputProcessor((InputProcessor)this.d);
/*      */ 
/*      */     
/*  519 */     Game.i.uiManager.stage.setScrollFocus(null);
/*      */   }
/*      */   
/*      */   private static boolean a(Research paramResearch, Vector2 paramVector2) {
/*  523 */     float f = (paramResearch.small ? 64 : 110) * 0.5F;
/*  524 */     return (paramVector2.x > paramResearch.x - f && paramVector2.x < paramResearch.x + f && paramVector2.y > paramResearch.y - f && paramVector2.y < paramResearch.y + f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Research paramResearch) {
/*  532 */     if (paramResearch == this.hoveredResearch)
/*      */       return; 
/*  534 */     this.hoveredResearch = paramResearch;
/*      */     
/*  536 */     this.Q.begin(); byte b; int i;
/*  537 */     for (b = 0, i = this.Q.size; b < i; b++) {
/*  538 */       ((ResearchesScreenListener)this.Q.get(b)).hoveredResearchChanged();
/*      */     }
/*  540 */     this.Q.end();
/*      */   }
/*      */   
/*      */   private void b(Research paramResearch) {
/*  544 */     if (paramResearch == this.selectedResearch)
/*      */       return; 
/*  546 */     this.selectedResearch = paramResearch;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  563 */     this.Q.begin(); byte b; int i;
/*  564 */     for (b = 0, i = this.Q.size; b < i; b++) {
/*  565 */       ((ResearchesScreenListener)this.Q.get(b)).selectedResearchChanged();
/*      */     }
/*  567 */     this.Q.end();
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
/*      */   public void startSelectedResearch() {
/*  583 */     if (Game.i.researchManager.getCurrentResearching() == this.selectedResearch) {
/*      */       
/*  585 */       int i = Game.i.progressManager.countAcceleratorsNeeded((int)(Game.i.researchManager.getMillisToResearchingEnd() / 1000L));
/*  586 */       if (!Game.i.progressManager.removeAccelerators(i)) {
/*      */         
/*  588 */         Threads.i().postRunnable(() -> Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_accelerators")));
/*      */       } else {
/*      */         
/*  591 */         Game.i.researchManager.finishCurrentResearch();
/*      */         return;
/*      */       } 
/*      */     } else {
/*  595 */       if (this.selectedResearch.isMaxNormalLevel() && this.selectedResearch.type == ResearchType.DEVELOPER_MODE) {
/*      */         
/*  597 */         Threads.i().postRunnable(() -> Dialog.i().showAlert(Game.i.localeManager.i18n.get("disable_developer_mode_hint"))); return;
/*      */       } 
/*  599 */       if (this.selectedResearch.isMaxEndlessLevel()) {
/*      */         return;
/*      */       }
/*  602 */       Runnable runnable = () -> {
/*      */           try {
/*      */             if (this.selectedResearch != null) {
/*      */               Game.i.researchManager.tryStartResearching(this.selectedResearch, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (this.selectedResearch.type == ResearchType.DEVELOPER_MODE) {
/*      */                 Threads.i().postRunnable(());
/*      */               } else {
/*      */                 Game.i.researchManager.startResearching(this.selectedResearch, true);
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             this.C.update();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             return;
/*  638 */           } catch (com.prineside.tdi2.managers.ResearchManager.StartResearchingException startResearchingException2) {
/*      */             ResearchManager.StartResearchingException startResearchingException1;
/*      */             a(startResearchingException1 = null);
/*      */             return;
/*      */           } 
/*      */         };
/*  644 */       if (GameStateSystem.savedGameExists())
/*      */         
/*      */         try {
/*  647 */           if (this.selectedResearch != null) {
/*      */             
/*  649 */             Game.i.researchManager.tryStartResearching(this.selectedResearch, false, null);
/*      */ 
/*      */             
/*  652 */             Threads.i().postRunnable(() -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("saved_game_will_be_lost_confirm"), ()));
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           return;
/*  659 */         } catch (com.prineside.tdi2.managers.ResearchManager.StartResearchingException startResearchingException) {
/*      */           
/*  661 */           a((ResearchManager.StartResearchingException)(runnable = null));
/*      */           return;
/*      */         }  
/*  664 */       runnable.run();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(ResearchManager.StartResearchingException paramStartResearchingException) {
/*      */     StringBuilder stringBuilder;
/*  672 */     (stringBuilder = new StringBuilder()).append(Game.i.localeManager.i18n.get("cant_start_research")).append(":\n");
/*  673 */     for (byte b = 0; b < paramStartResearchingException.reasons.size && 
/*  674 */       b != 2; b++) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  679 */       ResearchManager.StartResearchFailReason startResearchFailReason = (ResearchManager.StartResearchFailReason)paramStartResearchingException.reasons.get(b);
/*  680 */       String str = "start_research_fail_reason_" + startResearchFailReason.name();
/*  681 */       stringBuilder.append(Game.i.localeManager.i18n.get(str)).append("\n");
/*      */     } 
/*  683 */     Threads.i().postRunnable(() -> Dialog.i().showAlert((CharSequence)paramStringBuilder));
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  688 */     Color color1 = Game.i.assetManager.getColor("menu_background");
/*  689 */     Gdx.gl.glClearColor(color1.r, color1.g, color1.b, color1.a);
/*  690 */     Gdx.gl.glClear(16640);
/*      */     
/*  692 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*      */       
/*  694 */       Game.i.screenManager.goToMainMenu();
/*      */       
/*      */       return;
/*      */     } 
/*  698 */     if (Gdx.input.isKeyJustPressed(66) && 
/*  699 */       this.selectedResearch != null && !Dialog.i().isVisible()) {
/*  700 */       startSelectedResearch();
/*  701 */       this.T = 0.5F;
/*      */     } 
/*      */     
/*  704 */     if (Gdx.input.isKeyPressed(66)) {
/*  705 */       this.T -= paramFloat;
/*  706 */       if (this.T <= 0.0F) {
/*  707 */         if (this.selectedResearch != null && !Dialog.i().isVisible()) {
/*  708 */           startSelectedResearch();
/*  709 */           this.T = 0.05F;
/*      */         } else {
/*  711 */           this.T = 1000.0F;
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  717 */     if (this.D) {
/*  718 */       this.E.preRender(paramFloat);
/*  719 */       if (this.B.isOffscreen() || !this.B.isVisible()) {
/*  720 */         this.E.setPosition(this.c.getTable().getWidth() - 227.0F, 204.0F);
/*      */       } else {
/*  722 */         this.E.setPosition(this.c.getTable().getWidth() - 227.0F - 600.0F + this.B.getWrapper().getX(), 204.0F);
/*      */       } 
/*  724 */       this.F.setVisible(false);
/*  725 */       this.E.setVisible(true);
/*      */     } else {
/*  727 */       this.F.setVisible(true);
/*  728 */       this.E.setVisible(false);
/*  729 */       if (this.B.isOffscreen() || !this.B.isVisible()) {
/*  730 */         this.F.setPosition(this.c.getTable().getWidth() - 227.0F, 204.0F);
/*      */       } else {
/*  732 */         this.F.setPosition(this.c.getTable().getWidth() - 227.0F - 600.0F + this.B.getWrapper().getX(), 204.0F);
/*      */       } 
/*      */     } 
/*      */     
/*  736 */     SpriteBatch spriteBatch = Game.i.renderingManager.batch;
/*      */     
/*  738 */     boolean bool = (this.cameraController.zoom < 2.0D) ? true : false;
/*      */     
/*  740 */     this.e.update();
/*  741 */     this.cameraController.realUpdate(paramFloat);
/*      */     
/*  743 */     int i = Game.i.researchManager.getMapMinX();
/*  744 */     int j = Game.i.researchManager.getMapMinY();
/*      */ 
/*      */     
/*  747 */     this.O.begin();
/*  748 */     this.O.setProjectionMatrix(this.e.combined);
/*  749 */     this.O.enableBlending();
/*      */     
/*  751 */     Array array1 = Game.i.researchManager.getPolygonSprites();
/*  752 */     Array array2 = Game.i.researchManager.getLinks();
/*  753 */     Array array3 = Game.i.researchManager.getInstances();
/*      */     
/*  755 */     for (byte b2 = 0; b2 < array1.size; b2++) {
/*  756 */       if ((((ResearchManager.PolygonConfig[])array1.items)[b2]).visibleWith == null || (((ResearchManager.PolygonConfig[])array1.items)[b2]).visibleWith.getInstalledLevel() > 0) {
/*  757 */         (((ResearchManager.PolygonConfig[])array1.items)[b2]).sprite.draw(this.O);
/*      */       }
/*      */     } 
/*      */     
/*  761 */     this.O.end();
/*      */     
/*  763 */     spriteBatch.setProjectionMatrix(this.e.combined);
/*  764 */     spriteBatch.begin();
/*  765 */     spriteBatch.setBlendFunction(770, 771);
/*      */     
/*  767 */     Color color3 = f;
/*  768 */     Color color2 = i;
/*      */ 
/*      */     
/*  771 */     this.L = (this.L + paramFloat * 0.25F) % 1.0F;
/*  772 */     for (Array.ArrayIterator<Research.ResearchLink> arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) { Research.ResearchLink researchLink = arrayIterator.next();
/*  773 */       if (Game.i.researchManager.isVisible(researchLink.parent) && Game.i.researchManager.isVisible(researchLink.child)) {
/*      */ 
/*      */ 
/*      */         
/*  777 */         R.minX = StrictMath.min(researchLink.child.x - i, researchLink.parent.x - i);
/*  778 */         R.minY = StrictMath.min(researchLink.child.y - j, researchLink.parent.y - j);
/*  779 */         R.maxX = StrictMath.max(researchLink.child.x - i, researchLink.parent.x - i);
/*  780 */         R.maxY = StrictMath.max(researchLink.child.y - j, researchLink.parent.y - j);
/*      */         
/*  782 */         if (this.cameraController.isIntRectVisible(R)) {
/*      */           Color color;
/*      */ 
/*      */ 
/*      */           
/*  787 */           if ((researchLink.parent.priceInStars > 0 && researchLink.child.getInstalledLevel() > 0) || (researchLink.child.priceInStars > 0 && researchLink.parent.getInstalledLevel() > 0)) {
/*      */             
/*  789 */             color = color3;
/*      */           } else {
/*      */             boolean bool1;
/*  792 */             if (bool1 = researchLink.isVisible()) {
/*      */               
/*  794 */               color = color3;
/*      */             
/*      */             }
/*  797 */             else if (researchLink.parent.getInstalledLevel() != 0) {
/*      */               
/*  799 */               color = h;
/*      */             } else {
/*  801 */               color = g;
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*  806 */           M[0] = (researchLink.parent.x - i);
/*  807 */           M[1] = (researchLink.parent.y - j);
/*  808 */           M[2] = color.toFloatBits();
/*      */           
/*  810 */           M[3] = (researchLink.pivotX - i);
/*  811 */           M[4] = (researchLink.pivotY - j);
/*  812 */           M[5] = M[2];
/*      */           
/*  814 */           M[6] = (researchLink.child.x - i);
/*  815 */           M[7] = (researchLink.child.y - j);
/*  816 */           M[8] = M[2];
/*      */           
/*  818 */           DrawUtils.texturedMultiLine((Batch)spriteBatch, 6.0F, this.v, M);
/*      */ 
/*      */           
/*  821 */           if (bool && researchLink.child.priceInStars == 0) {
/*  822 */             for (byte b = 0; b < 3; b++) {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  827 */               float f1, f2, f3, f4 = (this.L + 0.333F * b) % 1.0F;
/*  828 */               if (M[0] == M[3] && M[1] == M[4]) {
/*      */                 
/*  830 */                 f1 = (M[6] - M[3]) * f4 + M[3];
/*  831 */                 f2 = (M[7] - M[4]) * f4 + M[4];
/*  832 */                 f3 = PMath.getAngleBetweenPoints(M[3], M[4], M[6], M[7]);
/*  833 */               } else if (M[6] == M[3] && M[7] == M[4]) {
/*      */                 
/*  835 */                 f1 = (M[3] - M[0]) * f4 + M[0];
/*  836 */                 f2 = (M[4] - M[1]) * f4 + M[1];
/*  837 */                 f3 = PMath.getAngleBetweenPoints(M[0], M[1], M[3], M[4]);
/*      */               }
/*  839 */               else if (f4 < 0.5F) {
/*  840 */                 f1 = (M[3] - M[0]) * f4 * 2.0F + M[0];
/*  841 */                 f2 = (M[4] - M[1]) * f4 * 2.0F + M[1];
/*  842 */                 f3 = PMath.getAngleBetweenPoints(M[0], M[1], M[3], M[4]);
/*      */               } else {
/*  844 */                 f1 = (M[6] - M[3]) * (f4 - 0.5F) * 2.0F + M[3];
/*  845 */                 f2 = (M[7] - M[4]) * (f4 - 0.5F) * 2.0F + M[4];
/*  846 */                 f3 = PMath.getAngleBetweenPoints(M[3], M[4], M[6], M[7]);
/*      */               } 
/*      */ 
/*      */               
/*  850 */               Vector2 vector2 = new Vector2();
/*  851 */               PMath.getPointByAngleFromPoint(f1, f2, f3 - 180.0F, 2.0F, vector2);
/*  852 */               spriteBatch.setColor(Config.BACKGROUND_COLOR);
/*  853 */               spriteBatch.draw(this.w, vector2.x - 8.0F, vector2.y - 8.0F, 8.0F, 8.0F, 16.0F, 16.0F, 1.0F, 1.0F, f3);
/*      */               
/*  855 */               PMath.getPointByAngleFromPoint(f1, f2, f3, 3.0F, vector2);
/*  856 */               spriteBatch.draw(this.w, vector2.x - 8.0F, vector2.y - 8.0F, 8.0F, 8.0F, 16.0F, 16.0F, 1.0F, 1.0F, f3);
/*  857 */               spriteBatch.setColor(color);
/*  858 */               spriteBatch.draw(this.w, f1 - 8.0F, f2 - 8.0F, 8.0F, 8.0F, 16.0F, 16.0F, 1.0F, 1.0F, f3);
/*      */             } 
/*  860 */             spriteBatch.setColor(Color.WHITE);
/*      */           } 
/*      */ 
/*      */           
/*  864 */           if (bool && !researchLink.isVisible() && researchLink.requiredLevels > 1) {
/*  865 */             float f1 = researchLink.requiredLevelsLabelX - 130.0F - i;
/*  866 */             float f2 = researchLink.requiredLevelsLabelY - 20.0F - j;
/*      */             
/*  868 */             N.setLength(0);
/*  869 */             N.append(researchLink.parent.getInstalledLevel());
/*  870 */             N.append("/");
/*  871 */             N.append(researchLink.requiredLevels);
/*      */             
/*  873 */             this.z.setColor(Color.BLACK);
/*  874 */             this.z.draw((Batch)spriteBatch, (CharSequence)N, f1 + 2.0F, f2 + 28.0F - 2.0F, 260.0F, 1, false);
/*  875 */             this.z.setColor(Color.WHITE);
/*  876 */             this.z.draw((Batch)spriteBatch, (CharSequence)N, f1, f2 + 28.0F, 260.0F, 1, false);
/*      */           } 
/*      */         } 
/*      */       }  }
/*      */      int k;
/*  881 */     for (byte b1 = 0; b1 < k; b1++) {
/*      */       Research research1;
/*  883 */       float f1 = ((research1 = (Research)array3.get(b1)).x - i);
/*  884 */       float f2 = (research1.y - j);
/*      */       
/*  886 */       byte b = research1.small ? 64 : 110;
/*  887 */       float f3 = f1 - b * 0.5F;
/*  888 */       float f4 = f2 - b * 0.5F;
/*      */       
/*  890 */       R.minX = (int)f3;
/*  891 */       R.minY = (int)f4;
/*  892 */       R.maxX = R.minX + b;
/*  893 */       R.maxY = R.minY + b;
/*      */       
/*  895 */       if (this.cameraController.isIntRectVisible(R)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  900 */         float f = research1.small ? 80.0F : 120.0F;
/*  901 */         TextureRegion textureRegion = research1.small ? this.u : this.t;
/*  902 */         if (this.selectedResearch == research1) {
/*      */           
/*  904 */           spriteBatch.setColor(o);
/*  905 */           spriteBatch.draw(textureRegion, f1 - f * 0.5F, f2 - f * 0.5F, f, f);
/*  906 */         } else if (this.hoveredResearch == research1) {
/*      */           
/*  908 */           spriteBatch.setColor(n);
/*  909 */           spriteBatch.draw(textureRegion, f1 - f * 0.5F, f2 - f * 0.5F, f, f);
/*      */         } 
/*      */         
/*  912 */         if (!Game.i.researchManager.isVisible(research1)) {
/*  913 */           spriteBatch.setColor(1.0F, 1.0F, 1.0F, 0.07F);
/*  914 */           spriteBatch.draw(this.r, f3, f4, b, b);
/*  915 */           if (research1.endlessOnly) {
/*  916 */             if (!research1.small) {
/*      */               
/*  918 */               spriteBatch.draw(this.s, f1 - 28.0F, f2 - 28.0F + 12.0F, 56.0F, 56.0F);
/*      */               
/*      */               ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/*  921 */               (resourcePackBitmapFont = Game.i.assetManager.getFont(18)).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/*  922 */               resourcePackBitmapFont.draw((Batch)spriteBatch, Game.i.localeManager.i18n.get("difficulty_mode_ENDLESS_I"), f1, f2 - 10.0F, 1.0F, 1, false);
/*  923 */               resourcePackBitmapFont.setColor(Color.WHITE);
/*      */             } else {
/*      */               
/*  926 */               spriteBatch.draw(this.s, f1 - 20.0F, f2 - 20.0F, 40.0F, 40.0F);
/*      */             } 
/*      */           }
/*      */         } else {
/*      */           Color color;
/*      */           
/*      */           boolean bool1;
/*      */           
/*  934 */           if (bool1 = Game.i.researchManager.canStartResearching(research1, false)) {
/*      */             float f6;
/*      */             
/*  937 */             if ((f6 = (float)(Game.getTimestampMillis() % 1000L) * 0.001F) < 0.5F) {
/*  938 */               f6 *= 2.0F;
/*      */             } else {
/*  940 */               f6 = 1.0F - (f6 - 0.5F) * 2.0F;
/*      */             } 
/*  942 */             S.set(l).lerp(m, f6);
/*  943 */             color = S;
/*      */           
/*      */           }
/*  946 */           else if (research1.getInstalledLevel() == 0) {
/*      */             
/*  948 */             color = k;
/*      */           
/*      */           }
/*  951 */           else if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.EASY || Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL) {
/*  952 */             if (research1.isMaxNormalLevel()) {
/*  953 */               color = j;
/*      */             } else {
/*  955 */               color = color2;
/*      */             }
/*      */           
/*      */           }
/*  959 */           else if (research1.isMaxEndlessLevel()) {
/*  960 */             color = j;
/*      */           } else {
/*  962 */             color = color2;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  967 */           spriteBatch.setColor(color);
/*  968 */           spriteBatch.draw(research1.small ? this.q : this.p, f3, f4, b, b);
/*      */ 
/*      */           
/*  971 */           if (research1.getInstalledLevel() == 0) {
/*      */             
/*  973 */             spriteBatch.setColor(k);
/*      */           } else {
/*      */             
/*  976 */             spriteBatch.setColor(Color.WHITE);
/*      */           } 
/*  978 */           float f5 = research1.small ? 32.0F : 80.0F;
/*  979 */           research1.category.getIcon().draw((Batch)spriteBatch, f1 - f5 * 0.5F, f2 - f5 * 0.5F, f5, f5);
/*      */ 
/*      */           
/*  982 */           if (bool) {
/*  983 */             int m = research1.levels.length;
/*  984 */             if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) m = research1.maxEndlessLevel;
/*      */             
/*  986 */             if (m > 1 && research1.getInstalledLevel() != 0) {
/*  987 */               spriteBatch.setColor(color);
/*  988 */               spriteBatch.draw(this.x, f3 + 44.0F, f4 - 13.0F, 61.0F, 33.0F);
/*      */               
/*  990 */               N.setLength(0);
/*  991 */               N.append('L');
/*  992 */               if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*      */                 
/*  994 */                 N.append(research1.getInstalledLevel());
/*      */               }
/*  996 */               else if (research1.getInstalledLevel() > research1.levels.length) {
/*  997 */                 N.append(research1.levels.length);
/*      */               } else {
/*  999 */                 N.append(research1.getInstalledLevel());
/*      */               } 
/*      */ 
/*      */               
/* 1003 */               if (bool1) {
/*      */                 
/* 1005 */                 this.z.setColor(Color.BLACK);
/* 1006 */                 this.z.draw((Batch)spriteBatch, (CharSequence)N, f3 + 48.0F + 2.0F + 2.0F, f4 + 32.0F - 2.0F - 20.0F, 48.0F, 16, false);
/* 1007 */                 this.z.setColor(Color.WHITE);
/* 1008 */                 this.z.draw((Batch)spriteBatch, (CharSequence)N, f3 + 48.0F + 2.0F, f4 + 32.0F - 20.0F, 48.0F, 16, false);
/*      */               } else {
/*      */                 
/* 1011 */                 this.z.setColor(Color.BLACK);
/* 1012 */                 this.z.draw((Batch)spriteBatch, (CharSequence)N, f3 + 48.0F + 2.0F, f4 + 32.0F - 20.0F, 48.0F, 16, false);
/* 1013 */                 this.z.setColor(Color.WHITE);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1019 */           if (bool && research1.priceInStars > 0) {
/* 1020 */             N.setLength(0);
/* 1021 */             N.append(research1.priceInStars);
/*      */             
/* 1023 */             f5 = f1 + b * 0.35F;
/* 1024 */             f1 = f2 + b * 0.1F;
/*      */             
/* 1026 */             spriteBatch.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 1027 */             spriteBatch.draw(this.y, f5 - 5.0F, f1 - 5.0F, 34.0F, 34.0F);
/* 1028 */             spriteBatch.setColor(MaterialColor.AMBER.P400);
/* 1029 */             spriteBatch.draw(this.y, f5, f1, 24.0F, 24.0F);
/*      */ 
/*      */ 
/*      */             
/* 1033 */             this.A.setColor(MaterialColor.AMBER.P400);
/* 1034 */             this.A.draw((Batch)spriteBatch, (CharSequence)N, f5 + 32.0F, f1 + 21.0F, 100.0F, 8, false);
/*      */           } 
/*      */ 
/*      */           
/* 1038 */           spriteBatch.setColor(Color.WHITE);
/* 1039 */           if (this.cameraController.zoom <= 1.5D && this.selectedResearch != research1) {
/*      */             boolean bool2;
/* 1041 */             if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/* 1042 */               bool2 = research1.isMaxEndlessLevel();
/*      */             } else {
/* 1044 */               bool2 = research1.isMaxNormalLevel();
/*      */             } 
/*      */             
/* 1047 */             if (!bool2) {
/* 1048 */               this.K.clear();
/* 1049 */               if (research1.getInstalledLevel() >= research1.levels.length) {
/*      */                 
/* 1051 */                 this.K.addAll(research1.endlessLevel.getPrice(research1.getInstalledLevel() + 1));
/*      */               } else {
/*      */                 
/* 1054 */                 Research.ResearchLevel researchLevel = research1.levels[research1.getInstalledLevel()];
/* 1055 */                 this.K.addAll(researchLevel.price);
/*      */               } 
/*      */               
/* 1058 */               this.K.begin();
/* 1059 */               for (byte b3 = 0; b3 < this.K.size; b3++) {
/* 1060 */                 ItemStack itemStack = ((ItemStack[])this.K.items)[b3];
/* 1061 */                 int m = Game.i.progressManager.getItemsCount(itemStack.getItem());
/*      */                 
/* 1063 */                 if (itemStack.getCount() <= m || itemStack.getItem().getIconDrawable() == null) {
/* 1064 */                   this.K.removeIndex(b3);
/*      */                 }
/*      */               } 
/* 1067 */               this.K.end();
/*      */               
/* 1069 */               if (this.K.size != 0) {
/*      */ 
/*      */ 
/*      */                 
/* 1073 */                 f2 = this.K.size * 20.0F + (this.K.size - 1) * 4.0F;
/* 1074 */                 float f6 = f3 - 20.0F;
/* 1075 */                 float f7 = f4 + b - 10.0F - 20.0F;
/*      */                 
/* 1077 */                 spriteBatch.setColor(color);
/* 1078 */                 (spriteBatch.getColor()).a = 0.14F;
/* 1079 */                 spriteBatch.setColor(spriteBatch.getColor());
/* 1080 */                 spriteBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f6 - 4.0F, f7 - f2 + 20.0F - 5.0F, 30.0F, f2 + 10.0F);
/* 1081 */                 spriteBatch.setColor(Color.WHITE);
/*      */                 
/* 1083 */                 for (byte b4 = 0; b4 < this.K.size && 
/* 1084 */                   b4 != 4; b4++) {
/*      */                   
/* 1086 */                   ItemStack itemStack = (ItemStack)this.K.get(b4);
/*      */                   
/* 1088 */                   float f8 = f7 - b4 * 24.0F;
/* 1089 */                   spriteBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 1090 */                   itemStack.getItem().getIconDrawable().draw((Batch)spriteBatch, f6 + 2.0F, f8 - 2.0F, 20.0F, 20.0F);
/* 1091 */                   spriteBatch.setColor(Color.WHITE);
/* 1092 */                   itemStack.getItem().getIconDrawable().draw((Batch)spriteBatch, f6, f8, 20.0F, 20.0F);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1099 */     }  spriteBatch.setColor(Color.WHITE);
/* 1100 */     spriteBatch.end();
/*      */     
/*      */     Research research;
/*      */     
/* 1104 */     if ((research = Game.i.researchManager.getCurrentResearching()) != null) {
/*      */       
/* 1106 */       spriteBatch.begin();
/* 1107 */       float f1 = (research.x - i);
/* 1108 */       float f2 = (research.y - j);
/* 1109 */       this.H.setPosition(f1, f2);
/* 1110 */       this.H.draw((Batch)spriteBatch, paramFloat);
/* 1111 */       spriteBatch.end();
/*      */     } 
/*      */     
/* 1114 */     if (this.J.size != 0) {
/* 1115 */       spriteBatch.begin();
/* 1116 */       spriteBatch.setBlendFunction(770, 1);
/* 1117 */       this.J.begin();
/* 1118 */       for (k = 0; k < this.J.size; k++) {
/*      */         ParticleEffectPool.PooledEffect pooledEffect;
/* 1120 */         (pooledEffect = ((ParticleEffectPool.PooledEffect[])this.J.items)[k]).draw((Batch)spriteBatch, paramFloat);
/* 1121 */         if (pooledEffect.isComplete()) {
/* 1122 */           this.J.removeIndex(k);
/*      */         }
/*      */       } 
/* 1125 */       this.J.end();
/* 1126 */       spriteBatch.end();
/*      */     } 
/*      */     
/* 1129 */     spriteBatch.setColor(Color.WHITE);
/* 1130 */     spriteBatch.setBlendFunction(770, 771);
/*      */     
/* 1132 */     this.C.draw(paramFloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public void resize(int paramInt1, int paramInt2) {
/* 1137 */     if (paramInt1 > 0 && paramInt2 > 0) {
/* 1138 */       this.cameraController.setScreenSize(paramInt1, paramInt2);
/*      */     }
/* 1140 */     super.resize(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1145 */     Game.i.researchManager.removeListener((ResearchManager.ResearchManagerListener)this.P);
/* 1146 */     this.B.dispose();
/*      */     
/* 1148 */     this.O.dispose();
/* 1149 */     this.C.dispose();
/* 1150 */     this.E.dispose();
/*      */     
/* 1152 */     Game.i.uiManager.removeLayer(this.c);
/* 1153 */     Game.i.uiManager.removeLayer(this.b);
/*      */   }
/*      */   
/*      */   private class _ResearchManagerListener extends ResearchManager.ResearchManagerListener.ResearchManagerListenerAdapter { private _ResearchManagerListener(ResearchesScreen this$0) {}
/*      */     
/*      */     public void researchStarted(Research param1Research, long param1Long) {
/* 1159 */       ResearchesScreen.a().i("research started: " + param1Research.type.name() + ", ends in " + param1Long + "ms", new Object[0]);
/* 1160 */       this.a.updateStarsCount();
/*      */     }
/*      */ 
/*      */     
/*      */     public void researchCompleted(Research param1Research) {
/* 1165 */       this.a.updateStarsCount();
/*      */       
/* 1167 */       int i = Game.i.researchManager.getMapMinX();
/* 1168 */       int j = Game.i.researchManager.getMapMinY();
/* 1169 */       float f2 = (param1Research.x - i);
/* 1170 */       float f1 = (param1Research.y - j);
/*      */       
/*      */       ParticleEffectPool.PooledEffect pooledEffect;
/* 1173 */       (pooledEffect = (ParticleEffectPool.PooledEffect)ResearchesScreen.a(this.a).obtain()).setPosition(f2, f1);
/* 1174 */       pooledEffect.start();
/* 1175 */       ResearchesScreen.b(this.a).add(pooledEffect);
/*      */     } }
/*      */ 
/*      */   
/*      */   public static interface ResearchesScreenListener {
/*      */     void selectedResearchChanged();
/*      */     
/*      */     void hoveredResearchChanged();
/*      */     
/*      */     public static abstract class ResearchesScreenListenerAdapter implements ResearchesScreenListener {
/*      */       public void selectedResearchChanged() {}
/*      */       
/*      */       public void hoveredResearchChanged() {}
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\ResearchesScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */