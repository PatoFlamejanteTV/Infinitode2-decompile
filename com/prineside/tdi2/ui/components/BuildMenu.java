/*      */ package com.prineside.tdi2.ui.components;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Miner;
/*      */ import com.prineside.tdi2.Modifier;
/*      */ import com.prineside.tdi2.Resource;
/*      */ import com.prineside.tdi2.SpaceTileBonus;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*      */ import com.prineside.tdi2.enums.MinerType;
/*      */ import com.prineside.tdi2.enums.ModifierType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.events.game.BuildingRemove;
/*      */ import com.prineside.tdi2.events.game.CoinsChange;
/*      */ import com.prineside.tdi2.events.game.MapElementSelect;
/*      */ import com.prineside.tdi2.events.game.MinerPlace;
/*      */ import com.prineside.tdi2.events.game.MinerRemove;
/*      */ import com.prineside.tdi2.events.game.MinerSell;
/*      */ import com.prineside.tdi2.events.game.ModifierPlace;
/*      */ import com.prineside.tdi2.events.game.ModifierSell;
/*      */ import com.prineside.tdi2.events.game.TowerPlace;
/*      */ import com.prineside.tdi2.events.game.TowersDefaultAimStrategyChange;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
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
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.ui.actors.AimStrategySelector;
/*      */ import com.prineside.tdi2.ui.actors.EffectTooltip;
/*      */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.SideMenu;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ 
/*      */ public class BuildMenu
/*      */   implements Disposable {
/*   70 */   private static final Color a = new Color(1.0F, 1.0F, 1.0F, 0.07F);
/*   71 */   private static final Color b = Color.WHITE;
/*   72 */   private static final Color c = MaterialColor.RED.P400;
/*   73 */   private static final Color d = MaterialColor.LIGHT_BLUE.P800;
/*   74 */   private static final Color e = MaterialColor.LIGHT_BLUE.P700;
/*   75 */   private static final Color f = MaterialColor.LIGHT_BLUE.P900; private final SideMenu h; private TabType i; private boolean j; private final Label k; private final Label l; private final Table m; private final SideMenu.SideMenuContainer n; private final Group o; private final Group p; private final Group q; private final Image r; private final Image s; private PaddedImageButton t; private final AimStrategySelector u; private final TileResources v;
/*   76 */   private static final Color g = MaterialColor.RED.P800; private final Label w; private final Group x; private final Group y; private final Group z; private Group A;
/*      */   private Group B;
/*      */   private BuildButton C;
/*      */   private boolean D;
/*      */   private boolean E;
/*      */   private Label F;
/*      */   private Label G;
/*      */   private Group H;
/*      */   private Group I;
/*      */   private Group J;
/*      */   
/*   87 */   enum TabType { TOWERS,
/*   88 */     MODIFIERS,
/*   89 */     MINERS; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  126 */   private Group[] K = new Group[ResourceType.values.length];
/*  127 */   private Label[] L = new Label[ResourceType.values.length];
/*  128 */   private Image[][] M = new Image[GeneralizedTowerStatType.values.length][5];
/*  129 */   private Label[] N = new Label[EnemyType.mainEnemyTypes.length];
/*  130 */   private Enemy[] O = new Enemy[EnemyType.mainEnemyTypes.length];
/*      */   
/*  132 */   private static final StringBuilder P = new StringBuilder();
/*      */   
/*      */   private BuildButton Q;
/*      */   
/*      */   private boolean R;
/*      */   
/*  138 */   private final ObjectMap<TowerType, BuildButton> S = new ObjectMap();
/*      */ 
/*      */   
/*  141 */   private final ObjectMap<ModifierType, BuildButton> T = new ObjectMap();
/*      */ 
/*      */   
/*  144 */   private final ObjectMap<MinerType, BuildButton> U = new ObjectMap();
/*      */ 
/*      */   
/*      */   private final GameSystemProvider V;
/*      */ 
/*      */   
/*  150 */   private final _SideMenuListener W = new _SideMenuListener((byte)0);
/*      */   
/*  152 */   private final Runnable X = this::m;
/*      */   
/*  154 */   private static final ObjectSet<SpaceTileBonusType> Y = new ObjectSet();
/*      */   
/*      */   public BuildMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  157 */     this.h = paramSideMenu;
/*      */     
/*  159 */     this.V = paramGameSystemProvider;
/*      */     
/*  161 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */ 
/*      */     
/*  164 */     this.n = paramSideMenu.createContainer("BuildMenu");
/*  165 */     this.n.setName("build_menu_container");
/*      */     
/*      */     Group group2;
/*      */     
/*  169 */     (group2 = new Group()).setTransform(false);
/*  170 */     group2.setSize(600.0F, 335.0F);
/*  171 */     group2.setPosition(0.0F, Game.i.settingsManager.getScaledViewportHeight() - 335.0F);
/*  172 */     this.n.addActor((Actor)group2);
/*      */     
/*  174 */     this.r = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  175 */     this.r.setColor(new Color(606348543));
/*  176 */     this.r.setTouchable(Touchable.disabled);
/*  177 */     this.r.setSize(600.0F, 335.0F);
/*  178 */     group2.addActor((Actor)this.r);
/*      */ 
/*      */     
/*  181 */     this.k = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  182 */     this.k.setSize(520.0F, 26.0F);
/*  183 */     this.k.setPosition(40.0F, 249.0F);
/*  184 */     group2.addActor((Actor)this.k);
/*      */ 
/*      */     
/*  187 */     this.l = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  188 */     this.l.setSize(520.0F, 100.0F);
/*  189 */     this.l.setPosition(40.0F, 139.0F);
/*  190 */     this.l.setAlignment(10);
/*  191 */     this.l.setWrap(true);
/*  192 */     group2.addActor((Actor)this.l);
/*      */ 
/*      */     
/*  195 */     this.m = new Table();
/*  196 */     this.m.setPosition(0.0F, 99.0F);
/*  197 */     this.m.setSize(600.0F, 64.0F);
/*  198 */     group2.addActor((Actor)this.m);
/*      */ 
/*      */     
/*  201 */     this.v = new TileResources(600.0F);
/*  202 */     this.v.setPosition(0.0F, 103.0F);
/*  203 */     group2.addActor((Actor)this.v);
/*      */ 
/*      */ 
/*      */     
/*  207 */     this.B = new Group();
/*  208 */     this.B.setTouchable(Touchable.childrenOnly);
/*  209 */     this.B.setTransform(false);
/*  210 */     this.B.setPosition(-140.0F, 168.0F);
/*  211 */     paramSideMenu.getBackgroundContainer().addActor((Actor)this.B);
/*      */     
/*  213 */     PaddedImageButton paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-details-toggle-button"), () -> b(true), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900);
/*  214 */     this.B.addActor((Actor)paddedImageButton1);
/*      */     
/*      */     Image image2;
/*  217 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info"))).setColor(Color.WHITE);
/*  218 */     image2.setSize(64.0F, 64.0F);
/*  219 */     image2.setPosition(34.0F, 114.0F);
/*  220 */     image2.setTouchable(Touchable.disabled);
/*  221 */     this.B.addActor((Actor)image2);
/*      */ 
/*      */     
/*  224 */     this.A = new Group();
/*  225 */     this.A.setTransform(false);
/*  226 */     this.A.setPosition(0.0F, 214.0F);
/*  227 */     this.A.setSize(472.0F, 761.0F);
/*  228 */     this.A.setTouchable(Touchable.enabled);
/*  229 */     paramSideMenu.getBackgroundContainer().addActor((Actor)this.A);
/*      */ 
/*      */     
/*  232 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-details-top"))).setSize(450.0F, 11.0F);
/*  233 */     image2.setPosition(0.0F, 750.0F);
/*  234 */     image2.setTouchable(Touchable.disabled);
/*  235 */     this.A.addActor((Actor)image2);
/*      */ 
/*      */     
/*  238 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-details-center"))).setSize(450.0F, 719.0F);
/*  239 */     image2.setPosition(0.0F, 31.0F);
/*  240 */     image2.setTouchable(Touchable.disabled);
/*  241 */     this.A.addActor((Actor)image2);
/*      */ 
/*      */     
/*  244 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-details-bottom"))).setSize(450.0F, 31.0F);
/*  245 */     image2.setTouchable(Touchable.disabled);
/*  246 */     this.A.addActor((Actor)image2);
/*      */ 
/*      */     
/*  249 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-details-right"))).setSize(22.0F, 576.0F);
/*  250 */     image2.setTouchable(Touchable.disabled);
/*  251 */     image2.setPosition(450.0F, 31.0F);
/*  252 */     this.A.addActor((Actor)image2);
/*      */ 
/*      */     
/*  255 */     this.F = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  256 */     this.F.setPosition(40.0F, 677.0F);
/*  257 */     this.F.setSize(300.0F, 40.0F);
/*  258 */     this.A.addActor((Actor)this.F);
/*      */     
/*  260 */     this.G = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  261 */     this.G.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  262 */     this.G.setPosition(40.0F, 591.0F);
/*  263 */     this.G.setSize(370.0F, 76.0F);
/*  264 */     this.G.setAlignment(10);
/*  265 */     this.G.setWrap(true);
/*  266 */     this.A.addActor((Actor)this.G);
/*      */ 
/*      */     
/*  269 */     this.H = new Group();
/*  270 */     this.H.setTransform(false);
/*  271 */     this.A.addActor((Actor)this.H);
/*      */ 
/*      */     
/*  274 */     Label.LabelStyle labelStyle1 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*  275 */     for (byte b2 = 0; b2 < GeneralizedTowerStatType.values.length; b2++) {
/*  276 */       float f = 552.0F - b2 * 28.0F;
/*      */       Label label;
/*  278 */       (label = new Label(Game.i.towerManager.getGeneralizedTowerStatName(GeneralizedTowerStatType.values[b2]), labelStyle1)).setPosition(40.0F, f);
/*  279 */       label.setSize(200.0F, 24.0F);
/*  280 */       this.H.addActor((Actor)label);
/*      */       
/*  282 */       Color color1 = Game.i.towerManager.getGeneralizedTowerStatColor(GeneralizedTowerStatType.values[b2]);
/*  283 */       this.M[b2] = new Image[5];
/*  284 */       for (byte b = 0; b < 5; b++) {
/*  285 */         this.M[b2][b] = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  286 */         this.M[b2][b].setPosition(386.0F - b * 28.0F, f);
/*  287 */         this.M[b2][b].setSize(24.0F, 24.0F);
/*  288 */         this.M[b2][b].setColor(color1);
/*  289 */         this.H.addActor((Actor)this.M[b2][b]);
/*      */       } 
/*      */     } 
/*      */     
/*      */     Label label2;
/*      */     
/*  295 */     (label2 = new Label(Game.i.localeManager.i18n.get("build_menu_effectiveness_against_enemies"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  296 */     label2.setPosition(40.0F, 335.0F);
/*  297 */     label2.setSize(370.0F, 76.0F);
/*  298 */     label2.setAlignment(10);
/*  299 */     label2.setWrap(true);
/*  300 */     this.H.addActor((Actor)label2);
/*      */     
/*  302 */     Label.LabelStyle labelStyle2 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*  303 */     for (byte b4 = 0; b4 < EnemyType.mainEnemyTypes.length; b4++) {
/*  304 */       EnemyType enemyType = EnemyType.mainEnemyTypes[b4];
/*      */       
/*      */       Enemy enemy;
/*  307 */       (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).S = paramGameSystemProvider;
/*  308 */       this.O[b4] = enemy;
/*      */       
/*      */       Image[] arrayOfImage;
/*  311 */       (arrayOfImage = new Image[EnemyType.values.length])[b4] = new Image(paramGameSystemProvider.enemy.getTexture(enemy.type));
/*  312 */       arrayOfImage[b4].setSize(40.0F, 40.0F);
/*  313 */       arrayOfImage[b4].setPosition(32.0F + (b4 % 3) * 128.0F + 12.0F, 320.0F - (b4 / 3) * 48.0F + 12.0F);
/*  314 */       this.H.addActor((Actor)arrayOfImage[b4]);
/*      */       
/*  316 */       this.N[b4] = new Label("100", labelStyle2);
/*  317 */       this.N[b4].setSize(64.0F, 64.0F);
/*  318 */       this.N[b4].setPosition(104.0F + (b4 % 3) * 128.0F, 320.0F - (b4 / 3) * 48.0F);
/*  319 */       this.H.addActor((Actor)this.N[b4]);
/*      */     } 
/*      */ 
/*      */     
/*  323 */     this.I = new Group();
/*  324 */     this.I.setTransform(false);
/*  325 */     this.A.addActor((Actor)this.I);
/*      */     
/*      */     Label label4;
/*      */     
/*  329 */     (label4 = new Label(Game.i.localeManager.i18n.get("resource_item"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), new Color(1.0F, 1.0F, 1.0F, 0.14F)))).setSize(131.0F, 32.0F);
/*  330 */     label4.setPosition(40.0F, 570.0F);
/*  331 */     this.I.addActor((Actor)label4);
/*      */     
/*      */     Label label5;
/*  334 */     (label5 = new Label(Game.i.localeManager.i18n.get("speed"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), new Color(1.0F, 1.0F, 1.0F, 0.14F)))).setSize(131.0F, 32.0F);
/*  335 */     label5.setPosition(279.0F, 570.0F);
/*  336 */     label5.setAlignment(16);
/*  337 */     this.I.addActor((Actor)label5);
/*      */ 
/*      */     
/*  340 */     Color color = new Color(808464639);
/*  341 */     for (byte b1 = 0; b1 < ResourceType.values.length; b1++) {
/*  342 */       ResourceType resourceType = ResourceType.values[b1];
/*      */       
/*  344 */       Group group = new Group();
/*  345 */       this.K[b1] = group;
/*  346 */       group.setSize(450.0F, 52.0F);
/*  347 */       group.setPosition(0.0F, 514.0F - b1 * 56.0F);
/*  348 */       this.I.addActor((Actor)group);
/*      */       
/*      */       Image image;
/*  351 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(324.0F, 52.0F);
/*  352 */       image.setColor(color);
/*  353 */       group.addActor((Actor)image);
/*      */ 
/*      */       
/*  356 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(122.0F, 52.0F);
/*  357 */       image.setPosition(328.0F, 0.0F);
/*  358 */       image.setColor(color);
/*  359 */       group.addActor((Actor)image);
/*      */ 
/*      */       
/*  362 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[b1]))).setSize(32.0F, 32.0F);
/*  363 */       image.setPosition(40.0F, 10.0F);
/*  364 */       image.setColor(Game.i.resourceManager.getColor(resourceType));
/*  365 */       group.addActor((Actor)image);
/*      */       
/*      */       Label label7;
/*  368 */       (label7 = new Label(Game.i.resourceManager.getName(resourceType), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(100.0F, 52.0F);
/*  369 */       label7.setPosition(82.0F, 0.0F);
/*  370 */       label7.setColor(Game.i.resourceManager.getColor(resourceType));
/*  371 */       group.addActor((Actor)label7);
/*      */       
/*  373 */       Label label6 = new Label("1.23", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  374 */       this.L[b1] = label6;
/*  375 */       label6.setSize(82.0F, 52.0F);
/*  376 */       label6.setPosition(328.0F, 0.0F);
/*  377 */       label6.setAlignment(16);
/*  378 */       group.addActor((Actor)label6);
/*      */     } 
/*      */ 
/*      */     
/*  382 */     this.J = new Group();
/*  383 */     this.J.setTransform(false);
/*  384 */     this.A.addActor((Actor)this.J);
/*      */     
/*      */     Table table3;
/*      */     
/*  388 */     (table3 = new Table()).setTransform(true);
/*  389 */     table3.setTouchable(Touchable.disabled);
/*  390 */     table3.setPosition(0.0F, 57.0F);
/*  391 */     table3.setSize(450.0F, 40.0F);
/*  392 */     table3.setOrigin(250.0F, 20.0F);
/*  393 */     table3.addAction((Action)Actions.forever(
/*  394 */           (Action)Actions.sequence(
/*  395 */             (Action)Actions.rotateTo(5.0F, 0.2F, (Interpolation)Interpolation.pow2), 
/*  396 */             (Action)Actions.rotateTo(-5.0F, 0.2F, (Interpolation)Interpolation.pow2), 
/*  397 */             (Action)Actions.rotateTo(0.0F, 0.2F, (Interpolation)Interpolation.pow2), 
/*  398 */             (Action)Actions.delay(2.0F))));
/*      */ 
/*      */     
/*  401 */     this.A.addActor((Actor)table3);
/*      */     
/*      */     Image image3;
/*  404 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(MaterialColor.AMBER.P500);
/*  405 */     table3.add((Actor)image3).size(40.0F).padRight(10.0F);
/*      */     
/*      */     Label label3;
/*  408 */     (label3 = new Label(Game.i.localeManager.i18n.get("tap_again_to_build"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(MaterialColor.AMBER.P500);
/*  409 */     table3.add((Actor)label3);
/*      */     
/*      */     PaddedImageButton paddedImageButton3;
/*      */     
/*  413 */     (paddedImageButton3 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> b(false), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setSize(96.0F, 120.0F);
/*  414 */     paddedImageButton3.setPosition(354.0F, 0.0F);
/*  415 */     paddedImageButton3.setIconSize(40.0F, 40.0F);
/*  416 */     paddedImageButton3.setIconPosition(16.0F, 65.0F);
/*  417 */     this.A.addActor((Actor)paddedImageButton3);
/*      */     
/*  419 */     this.D = true;
/*  420 */     a(false);
/*      */     
/*  422 */     this.E = true;
/*  423 */     b(false);
/*      */ 
/*      */ 
/*      */     
/*  427 */     this.x = new Group();
/*  428 */     this.x.setTransform(false);
/*  429 */     this.x.setSize(600.0F, 80.0F);
/*  430 */     group2.addActor((Actor)this.x);
/*      */     
/*  432 */     this.t = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-inactive-left"), () -> a(TabType.MODIFIERS), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900);
/*  433 */     this.t.setName("build_menu_modifiers_tab_button");
/*  434 */     this.t.setPosition(42.0F, 4.0F);
/*  435 */     this.t.setIconSize(228.0F, 72.0F);
/*  436 */     this.t.setSize(228.0F, 72.0F);
/*      */     
/*  438 */     this.x.addActor((Actor)this.t);
/*      */     
/*      */     Image image4;
/*  441 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-modifier"))).setSize(54.0F, 54.0F);
/*  442 */     image4.setPosition(87.0F, 9.0F);
/*  443 */     image4.setTouchable(Touchable.disabled);
/*  444 */     this.t.addActor((Actor)image4);
/*      */     
/*      */     Table table4;
/*  447 */     (table4 = new Table()).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-active"));
/*  448 */     table4.setSize(312.0F, 80.0F);
/*  449 */     table4.setPosition(248.0F, 0.0F);
/*  450 */     this.x.addActor((Actor)table4);
/*      */     
/*  452 */     table4.add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("icon-tower-top"))).size(54.0F, 54.0F).padRight(16.0F);
/*  453 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("towers").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).padRight(4.0F);
/*      */ 
/*      */     
/*  456 */     this.y = new Group();
/*  457 */     this.y.setTransform(false);
/*  458 */     this.y.setSize(600.0F, 80.0F);
/*  459 */     group2.addActor((Actor)this.y);
/*      */ 
/*      */     
/*  462 */     (table4 = new Table()).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-active"));
/*  463 */     table4.setSize(312.0F, 80.0F);
/*  464 */     table4.setPosition(40.0F, 0.0F);
/*  465 */     this.y.addActor((Actor)table4);
/*      */     
/*  467 */     table4.add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("icon-modifier"))).size(54.0F, 54.0F).padRight(16.0F);
/*  468 */     table4.add((Actor)new Label(Game.i.localeManager.i18n.get("modifiers").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).padRight(4.0F);
/*      */     
/*      */     PaddedImageButton paddedImageButton2;
/*  471 */     (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-inactive-right"), () -> a(TabType.TOWERS), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setPosition(330.0F, 4.0F);
/*  472 */     paddedImageButton2.setSize(228.0F, 72.0F);
/*  473 */     paddedImageButton2.setIconSize(228.0F, 72.0F);
/*  474 */     this.y.addActor((Actor)paddedImageButton2);
/*      */     
/*      */     Image image1;
/*  477 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-tower-top"))).setSize(54.0F, 54.0F);
/*  478 */     image1.setPosition(87.0F, 9.0F);
/*  479 */     image1.setTouchable(Touchable.disabled);
/*  480 */     paddedImageButton2.addActor((Actor)image1);
/*      */ 
/*      */     
/*  483 */     this.z = new Group();
/*  484 */     this.z.setTransform(false);
/*  485 */     this.z.setSize(600.0F, 80.0F);
/*  486 */     group2.addActor((Actor)this.z);
/*      */     
/*      */     Table table2;
/*  489 */     (table2 = new Table()).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-active"));
/*  490 */     table2.setSize(312.0F, 80.0F);
/*  491 */     table2.setPosition(248.0F, 0.0F);
/*  492 */     this.z.addActor((Actor)table2);
/*      */     
/*  494 */     table2.add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("icon-miner-top"))).size(54.0F, 54.0F).padRight(16.0F);
/*  495 */     table2.add((Actor)new Label(Game.i.localeManager.i18n.get("miners").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).padRight(4.0F);
/*      */ 
/*      */     
/*  498 */     this.s = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-tab-background"));
/*  499 */     this.s.setSize(600.0F, Game.i.settingsManager.getScaledViewportHeight() - 335.0F);
/*  500 */     this.s.setTouchable(Touchable.disabled);
/*  501 */     this.n.addActor((Actor)this.s);
/*      */ 
/*      */     
/*  504 */     this.o = new Group();
/*  505 */     this.o.setTransform(false);
/*  506 */     this.o.setSize(600.0F, Game.i.settingsManager.getScaledViewportHeight() - 335.0F);
/*  507 */     this.n.addActor((Actor)this.o);
/*      */     
/*      */     Group group1;
/*      */     
/*  511 */     (group1 = new Group()).setTransform(false);
/*  512 */     group1.setName("build_menu_default_aim_strategy");
/*  513 */     group1.setPosition(0.0F, 628.0F + i);
/*  514 */     group1.setSize(600.0F, 70.0F);
/*  515 */     this.o.addActor((Actor)group1);
/*      */     
/*      */     Label label1;
/*  518 */     (label1 = new Label(Game.i.localeManager.i18n.get("default_target").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  519 */     label1.setPosition(40.0F, 52.0F);
/*  520 */     label1.setSize(210.0F, 18.0F);
/*  521 */     group1.addActor((Actor)label1);
/*      */     
/*  523 */     this.w = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  524 */     this.w.setPosition(40.0F, 18.0F);
/*  525 */     this.w.setSize(210.0F, 23.0F);
/*  526 */     group1.addActor((Actor)this.w);
/*      */     
/*  528 */     this.u = new AimStrategySelector();
/*  529 */     this.u.setPosition(250.0F, 0.0F);
/*  530 */     this.u.addListener(paramAimStrategy -> paramGameSystemProvider.tower.setDefaultAimStrategy(paramAimStrategy));
/*      */ 
/*      */     
/*  533 */     group1.addActor((Actor)this.u);
/*      */     
/*      */     Table table1;
/*      */     
/*  537 */     (table1 = new Table()).setName("build_menu_tower_build_buttons");
/*      */     
/*  539 */     int j = (TowerType.values.length - 1) / 4 + 1;
/*      */     float f1;
/*      */     byte b3;
/*  542 */     float f2 = (b3 = ((f1 = 40.0F + j * 131.0F - 4.0F) > (i + 600)) ? 1 : 0) ? 20.0F : 40.0F;
/*      */     
/*      */     Image image8;
/*  545 */     (image8 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setTouchable(Touchable.disabled);
/*  546 */     image8.setSize(600.0F, (i + 600));
/*  547 */     image8.setColor(new Color(724249599));
/*  548 */     this.o.addActor((Actor)image8);
/*      */     
/*      */     ScrollPane scrollPane2;
/*  551 */     UiUtils.enableMouseMoveScrollFocus(scrollPane2 = new ScrollPane((Actor)table1, Game.i.assetManager.getScrollPaneStyle(20.0F)));
/*  552 */     scrollPane2.setSize(600.0F, (i + 600));
/*  553 */     scrollPane2.setOverscroll(false, false);
/*  554 */     scrollPane2.setSmoothScrolling(false);
/*  555 */     scrollPane2.setFadeScrollBars(false);
/*  556 */     scrollPane2.addListener((EventListener)new InputListener(this, scrollPane2)
/*      */         {
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  560 */               this.a.getStage().setScrollFocus((Actor)this.a); return;
/*  561 */             } catch (Exception exception) {
/*      */               return;
/*      */             } 
/*      */           }
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  568 */               this.a.getStage().setScrollFocus(null); return;
/*  569 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  }
/*      */         });
/*  573 */     this.o.addActor((Actor)scrollPane2);
/*      */     
/*      */     Image image7;
/*  576 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize(b3 ? 580.0F : 600.0F, 10.0F);
/*  577 */     image7.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*  578 */     image7.setPosition(0.0F, (i + 600) - 10.0F);
/*  579 */     this.o.addActor((Actor)image7);
/*      */     
/*  581 */     b3 = 0; int k; TowerType[] arrayOfTowerType; byte b5;
/*  582 */     for (k = (arrayOfTowerType = TowerType.values).length, b5 = 0; b5 < k; ) { TowerType towerType = arrayOfTowerType[b5];
/*      */       BuildButton buildButton;
/*  584 */       (buildButton = new BuildButton(this, Game.i.towerManager.getFactory(towerType).createIconActor(128.0F))).setName("build_menu_tower_build_button_" + towerType.name());
/*  585 */       buildButton.b(0);
/*  586 */       buildButton.a(-1);
/*  587 */       buildButton.k = TabType.TOWERS;
/*  588 */       buildButton.l = towerType;
/*  589 */       Cell cell = table1.add((Actor)buildButton).size(127.0F, 127.0F).padBottom(4.0F).padRight(4.0F);
/*  590 */       b3++;
/*  591 */       if (b3 <= 4)
/*      */       {
/*  593 */         cell.padTop(40.0F);
/*      */       }
/*  595 */       if (b3 % 4 == 1)
/*      */       {
/*  597 */         cell.padLeft(40.0F);
/*      */       }
/*  599 */       if (b3 % 4 == 0) {
/*      */         
/*  601 */         cell.padRight(f2);
/*  602 */         table1.row();
/*      */       } 
/*  604 */       if ((b3 - 1) / 4 + 1 == j)
/*      */       {
/*  606 */         cell.padBottom(StrictMath.max((i + 600) - f1, 40.0F));
/*      */       }
/*      */       
/*  609 */       this.S.put(towerType, buildButton);
/*      */ 
/*      */       
/*  612 */       buildButton.addListener((EventListener)new ClickListener(this, buildButton, paramGameSystemProvider)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  615 */               if (BuildMenu.a(this.c) == this.a) {
/*      */                 
/*  617 */                 this.b.tower.buildTowerActionOnSelectedTile((BuildMenu.a(this.c)).l); return;
/*      */               } 
/*  619 */               BuildMenu.a(this.c, this.a);
/*      */             }
/*      */           });
/*      */ 
/*      */       
/*  624 */       if (HotKeyHintLabel.isEnabled()) {
/*  625 */         SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_BASIC;
/*  626 */         switch (null.a[towerType.ordinal()]) { case 1:
/*  627 */             hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_BASIC; break;
/*  628 */           case 2: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_SNIPER; break;
/*  629 */           case 3: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_CANNON; break;
/*  630 */           case 4: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_FREEZING; break;
/*  631 */           case 5: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_AIR; break;
/*  632 */           case 6: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_SPLASH; break;
/*  633 */           case 7: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_BLAST; break;
/*  634 */           case 8: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_MULTISHOT; break;
/*  635 */           case 9: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_MINIGUN; break;
/*  636 */           case 10: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_VENOM; break;
/*  637 */           case 11: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_TESLA; break;
/*  638 */           case 12: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_MISSILE; break;
/*  639 */           case 13: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_LASER; break;
/*  640 */           case 14: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_GAUSS; break;
/*  641 */           case 15: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_CRUSHER; break;
/*  642 */           case 16: hotkeyAction = SettingsManager.HotkeyAction.BUILD_TOWER_FLAMETHROWER; break; }
/*      */         
/*  644 */         HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(hotkeyAction), 12.0F, 102.0F, 8);
/*  645 */         buildButton.addActor((Actor)hotKeyHintLabel);
/*      */       } 
/*      */       
/*      */       b5++; }
/*      */     
/*  650 */     this.p = new Group();
/*  651 */     this.p.setTransform(false);
/*  652 */     this.p.setSize(600.0F, Game.i.settingsManager.getScaledViewportHeight() - 335.0F);
/*  653 */     this.n.addActor((Actor)this.p);
/*      */     
/*      */     Table table5;
/*      */     
/*  657 */     (table5 = new Table()).setName("build_menu_modifier_build_buttons");
/*      */     
/*  659 */     j = (ModifierType.values.length - 1) / 4 + 1;
/*      */ 
/*      */     
/*  662 */     f2 = ((b3 = ((f1 = 40.0F + j * 131.0F - 4.0F) > 725.0F + i) ? 1 : 0) != 0) ? 20.0F : 40.0F;
/*      */     
/*      */     Image image6;
/*      */     
/*  666 */     (image6 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setTouchable(Touchable.disabled);
/*  667 */     image6.setSize(600.0F, 725.0F + i);
/*  668 */     image6.setColor(new Color(724249599));
/*  669 */     this.p.addActor((Actor)image6);
/*      */     
/*      */     ScrollPane scrollPane1;
/*  672 */     UiUtils.enableMouseMoveScrollFocus(scrollPane1 = new ScrollPane((Actor)table5, Game.i.assetManager.getScrollPaneStyle(20.0F)));
/*  673 */     scrollPane1.setSize(600.0F, 725.0F + i);
/*  674 */     scrollPane1.setOverscroll(false, false);
/*  675 */     scrollPane1.setSmoothScrolling(false);
/*  676 */     scrollPane1.setFadeScrollBars(false);
/*  677 */     scrollPane1.addListener((EventListener)new InputListener(this, scrollPane1)
/*      */         {
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  681 */               this.a.getStage().setScrollFocus((Actor)this.a); return;
/*  682 */             } catch (Exception exception) {
/*      */               return;
/*      */             } 
/*      */           }
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  689 */               this.a.getStage().setScrollFocus(null); return;
/*  690 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  }
/*      */         });
/*  694 */     this.p.addActor((Actor)scrollPane1);
/*      */     
/*      */     Image image5;
/*  697 */     (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize((b3 != 0) ? 580.0F : 600.0F, 10.0F);
/*  698 */     image5.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*  699 */     image5.setPosition(0.0F, 725.0F + i - 10.0F);
/*  700 */     this.p.addActor((Actor)image5);
/*      */     
/*  702 */     b3 = 0; ModifierType[] arrayOfModifierType; int m; byte b6;
/*  703 */     for (m = (arrayOfModifierType = ModifierType.values).length, b6 = 0; b6 < m; ) { ModifierType modifierType = arrayOfModifierType[b6];
/*      */ 
/*      */       
/*      */       BuildButton buildButton;
/*      */ 
/*      */       
/*  709 */       (buildButton = new BuildButton(this, Game.i.modifierManager.getFactory(modifierType).createIconActor(128.0F))).setName("build_menu_modifier_build_button_" + modifierType.name());
/*  710 */       buildButton.k = TabType.MODIFIERS;
/*  711 */       buildButton.n = modifierType;
/*      */       
/*  713 */       this.T.put(modifierType, buildButton);
/*      */       
/*  715 */       buildButton.addListener((EventListener)new ClickListener(this, buildButton, paramGameSystemProvider)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  718 */               if (BuildMenu.a(this.c) == this.a) {
/*      */                 
/*  720 */                 this.b.modifier.buildModifierActionAtSelectedTile((BuildMenu.a(this.c)).n); return;
/*      */               } 
/*  722 */               BuildMenu.a(this.c, this.a);
/*      */             }
/*      */           });
/*      */ 
/*      */       
/*  727 */       Cell cell = table5.add((Actor)buildButton).size(127.0F, 127.0F).padBottom(4.0F).padRight(4.0F);
/*      */       
/*  729 */       if (HotKeyHintLabel.isEnabled()) {
/*  730 */         SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_BALANCE;
/*  731 */         switch (null.b[modifierType.ordinal()]) { case 1:
/*  732 */             hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_BALANCE; break;
/*  733 */           case 2: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_SEARCH; break;
/*  734 */           case 3: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_POWER; break;
/*  735 */           case 4: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_DAMAGE; break;
/*  736 */           case 5: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_ATTACK_SPEED; break;
/*  737 */           case 6: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_MINING_SPEED; break;
/*  738 */           case 7: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_BOUNTY; break;
/*  739 */           case 8: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_EXPERIENCE; break; }
/*      */         
/*  741 */         HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(hotkeyAction), 12.0F, 102.0F, 8);
/*  742 */         buildButton.addActor((Actor)hotKeyHintLabel);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  749 */       b3++;
/*  750 */       if (b3 <= 4)
/*      */       {
/*  752 */         cell.padTop(40.0F);
/*      */       }
/*  754 */       if (b3 % 4 == 1)
/*      */       {
/*  756 */         cell.padLeft(40.0F);
/*      */       }
/*  758 */       if (b3 % 4 == 0) {
/*      */         
/*  760 */         cell.padRight(f2);
/*  761 */         table5.row();
/*      */       } 
/*  763 */       if ((b3 - 1) / 4 + 1 == j)
/*      */       {
/*  765 */         cell.padBottom(StrictMath.max(725.0F + i - f1, 40.0F));
/*      */       }
/*      */       
/*      */       b6++; }
/*      */     
/*  770 */     this.q = new Group();
/*  771 */     this.q.setTransform(false);
/*  772 */     this.q.setSize(600.0F, 745.0F);
/*  773 */     this.n.addActor((Actor)this.q);
/*      */     
/*      */     Table table6;
/*      */     
/*  777 */     (table6 = new Table()).setName("build_menu_miner_build_buttons");
/*      */     
/*  779 */     j = (MinerType.values.length - 1) / 4 + 1;
/*      */ 
/*      */     
/*  782 */     f2 = ((b3 = ((f1 = 40.0F + j * 131.0F - 4.0F) > 725.0F + i) ? 1 : 0) != 0) ? 20.0F : 40.0F;
/*      */ 
/*      */     
/*  785 */     (image5 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setTouchable(Touchable.disabled);
/*  786 */     image5.setSize(600.0F, 725.0F + i);
/*  787 */     image5.setColor(new Color(724249599));
/*  788 */     this.q.addActor((Actor)image5);
/*      */     
/*      */     ScrollPane scrollPane3;
/*  791 */     UiUtils.enableMouseMoveScrollFocus(scrollPane3 = new ScrollPane((Actor)table6, Game.i.assetManager.getScrollPaneStyle(20.0F)));
/*  792 */     scrollPane3.setSize(600.0F, 725.0F + i);
/*  793 */     scrollPane3.setOverscroll(false, false);
/*  794 */     scrollPane3.setSmoothScrolling(false);
/*  795 */     scrollPane3.setFadeScrollBars(false);
/*  796 */     scrollPane3.addListener((EventListener)new InputListener(this, scrollPane3)
/*      */         {
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  800 */               this.a.getStage().setScrollFocus((Actor)this.a); return;
/*  801 */             } catch (Exception exception) {
/*      */               return;
/*      */             } 
/*      */           }
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*      */             try {
/*  808 */               this.a.getStage().setScrollFocus(null); return;
/*  809 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  }
/*      */         });
/*  813 */     this.q.addActor((Actor)scrollPane3);
/*      */ 
/*      */     
/*  816 */     (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize((b3 != 0) ? 580.0F : 600.0F, 10.0F);
/*  817 */     image5.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*  818 */     image5.setPosition(0.0F, 725.0F + i - 10.0F);
/*  819 */     this.q.addActor((Actor)image5);
/*      */     
/*  821 */     b3 = 0; MinerType[] arrayOfMinerType; int n; byte b7;
/*  822 */     for (n = (arrayOfMinerType = MinerType.values).length, b7 = 0; b7 < n; ) { MinerType minerType = arrayOfMinerType[b7];
/*      */ 
/*      */       
/*      */       BuildButton buildButton;
/*      */       
/*  827 */       (buildButton = new BuildButton(this, Game.i.minerManager.getFactory(minerType).createIconActor(128.0F))).setName("build_menu_miner_build_button_" + minerType.name());
/*  828 */       buildButton.k = TabType.MINERS;
/*  829 */       buildButton.m = minerType;
/*      */       
/*  831 */       this.U.put(minerType, buildButton);
/*      */       
/*  833 */       buildButton.addListener((EventListener)new ClickListener(this, buildButton, paramGameSystemProvider)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  836 */               if (BuildMenu.a(this.c) == this.a) {
/*      */                 
/*  838 */                 this.b.miner.buildMinerActionForSelectedTile((BuildMenu.a(this.c)).m); return;
/*      */               } 
/*  840 */               BuildMenu.a(this.c, this.a);
/*      */             }
/*      */           });
/*      */ 
/*      */       
/*  845 */       Cell cell = table6.add((Actor)buildButton).size(127.0F, 127.0F).padBottom(4.0F).padRight(4.0F);
/*      */       
/*  847 */       if (HotKeyHintLabel.isEnabled()) {
/*  848 */         SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.BUILD_MODIFIER_BALANCE;
/*  849 */         switch (null.c[minerType.ordinal()]) { case 1:
/*  850 */             hotkeyAction = SettingsManager.HotkeyAction.BUILD_MINER_SCALAR; break;
/*  851 */           case 2: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MINER_VECTOR; break;
/*  852 */           case 3: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MINER_MATRIX; break;
/*  853 */           case 4: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MINER_TENSOR; break;
/*  854 */           case 5: hotkeyAction = SettingsManager.HotkeyAction.BUILD_MINER_INFIAR; break; }
/*      */         
/*  856 */         HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(hotkeyAction), 12.0F, 102.0F, 8);
/*  857 */         buildButton.addActor((Actor)hotKeyHintLabel);
/*      */       } 
/*      */       
/*  860 */       b3++;
/*  861 */       if (b3 <= 4)
/*      */       {
/*  863 */         cell.padTop(40.0F);
/*      */       }
/*  865 */       if (b3 % 4 == 1)
/*      */       {
/*  867 */         cell.padLeft(40.0F);
/*      */       }
/*  869 */       if (b3 % 4 == 0) {
/*      */         
/*  871 */         cell.padRight(f2);
/*  872 */         table6.row();
/*      */       } 
/*  874 */       if ((b3 - 1) / 4 + 1 == j)
/*      */       {
/*  876 */         cell.padBottom(StrictMath.max(725.0F + i - f1, 40.0F));
/*      */       }
/*      */       
/*      */       b7++; }
/*      */     
/*  881 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.W);
/*      */ 
/*      */     
/*  884 */     paramGameSystemProvider.events.getListeners(CoinsChange.class).add(paramCoinsChange -> Game.i.uiManager.runOnStageActOnce(this.X));
/*      */     
/*  886 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*      */           Tile tile = paramGameSystemProvider._gameMapSelection.getSelectedTile();
/*      */           
/*      */           i();
/*  890 */           c((tile != null && ((tile.type == TileType.PLATFORM && ((PlatformTile)tile).building == null) || (tile.type == TileType.SOURCE && ((SourceTile)tile).miner == null))));
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  896 */     paramGameSystemProvider.events.getListeners(TowerPlace.class).add(paramTowerPlace -> {
/*      */           if (paramTowerPlace.getTower().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             c(false);
/*      */           }
/*      */         });
/*  901 */     paramGameSystemProvider.events.getListeners(ModifierPlace.class).add(paramModifierPlace -> {
/*      */           if (paramModifierPlace.getModifier().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             c(false);
/*      */           }
/*      */         });
/*  906 */     paramGameSystemProvider.events.getListeners(MinerPlace.class).add(paramMinerPlace -> {
/*      */           if (paramMinerPlace.getMiner().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             c(false);
/*      */           }
/*      */         });
/*  911 */     paramGameSystemProvider.events.getListeners(BuildingRemove.class).add(paramBuildingRemove -> {
/*      */           if (paramBuildingRemove.getOldTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             c(true);
/*      */           }
/*      */         });
/*  916 */     paramGameSystemProvider.events.getListeners(MinerRemove.class).add(paramMinerRemove -> {
/*      */           if (paramMinerRemove.getOldTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             c(true);
/*      */           }
/*      */         });
/*  921 */     paramGameSystemProvider.events.getListeners(TowersDefaultAimStrategyChange.class).add(paramTowersDefaultAimStrategyChange -> n());
/*      */ 
/*      */     
/*  924 */     paramGameSystemProvider.events.getListeners(ModifierSell.class).add(paramModifierSell -> Game.i.uiManager.runOnStageActOnce(this.X));
/*  925 */     paramGameSystemProvider.events.getListeners(MinerSell.class).add(paramMinerSell -> Game.i.uiManager.runOnStageActOnce(this.X));
/*      */     
/*  927 */     this.n.hide();
/*      */   }
/*      */   
/*      */   public void postSetup() {
/*  931 */     m();
/*  932 */     a(TabType.TOWERS);
/*  933 */     n();
/*      */   }
/*      */   
/*      */   private void i() {
/*      */     Tile tile;
/*  938 */     if ((tile = this.V._gameMapSelection.getSelectedTile()) != null) {
/*  939 */       PlatformTile platformTile; boolean bool = Game.i.minerManager.minersAndEnergyAvailable();
/*  940 */       if (this.V.gameValue
/*  941 */         .getIntValue(GameValueType.MINER_COUNT_SCALAR) != 0 || this.V.gameValue
/*  942 */         .getIntValue(GameValueType.MINER_COUNT_VECTOR) != 0 || this.V.gameValue
/*  943 */         .getIntValue(GameValueType.MINER_COUNT_MATRIX) != 0 || this.V.gameValue
/*  944 */         .getIntValue(GameValueType.MINER_COUNT_TENSOR) != 0 || this.V.gameValue
/*  945 */         .getIntValue(GameValueType.MINER_COUNT_INFIAR) != 0)
/*      */       {
/*  947 */         bool = true;
/*      */       }
/*  949 */       if (tile.type == TileType.SOURCE && !bool) {
/*      */         
/*  951 */         this.k.setText(Game.i.localeManager.i18n.get("unknown").toUpperCase());
/*  952 */         this.l.setText(Game.i.localeManager.i18n.get("description_not_available"));
/*  953 */         a((TabType)null);
/*  954 */         this.m.setVisible(false); return;
/*      */       } 
/*  956 */       this.k.setText((CharSequence)StringFormatter.toUpperCase(tile.getTitle()));
/*  957 */       this.l.setText(tile.getDescription());
/*      */       
/*  959 */       if (tile.type == TileType.PLATFORM) {
/*      */         
/*  961 */         platformTile = (PlatformTile)tile;
/*      */         
/*  963 */         if (this.i != TabType.TOWERS && this.i != TabType.MODIFIERS) {
/*  964 */           a(TabType.TOWERS);
/*      */         }
/*      */ 
/*      */         
/*  968 */         this.v.setVisible(false);
/*  969 */         this.m.setVisible(true);
/*  970 */         this.m.clearChildren();
/*      */         
/*  972 */         if (platformTile.bonusType != null && platformTile.bonusLevel > 0) {
/*      */           EffectTooltip effectTooltip;
/*  974 */           (effectTooltip = new EffectTooltip((Drawable)Game.i.assetManager.getDrawable(SpaceTileBonus.getIconName(platformTile.bonusType)), (CharSequence)SpaceTileBonus.getDetailedName(platformTile.bonusType, platformTile.bonusLevel))).setHint(Game.i.localeManager.i18n.get("tile_effect"));
/*  975 */           effectTooltip.setColor(SpaceTileBonus.getBrightColor(platformTile.bonusType));
/*  976 */           this.m.add((Actor)effectTooltip);
/*      */         } 
/*      */         
/*  979 */         k(); return;
/*  980 */       }  if (((Tile)platformTile).type == TileType.SOURCE) {
/*      */         
/*  982 */         SourceTile sourceTile = (SourceTile)platformTile;
/*      */         
/*  984 */         if (this.i != TabType.MINERS) {
/*  985 */           a(TabType.MINERS);
/*      */         }
/*      */ 
/*      */         
/*  989 */         this.m.setVisible(false);
/*  990 */         this.v.setVisible(true);
/*      */         
/*  992 */         this.v.setTile(sourceTile);
/*      */         
/*  994 */         k();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(BuildButton paramBuildButton) {
/* 1001 */     if (this.Q != null) {
/* 1002 */       this.Q.a(false);
/*      */     }
/* 1004 */     this.Q = paramBuildButton;
/* 1005 */     if (paramBuildButton != null) {
/* 1006 */       paramBuildButton.a(true);
/*      */     }
/* 1008 */     k();
/*      */     
/* 1010 */     if (paramBuildButton != null) {
/* 1011 */       b(this.Q);
/* 1012 */       a(true); return;
/*      */     } 
/* 1014 */     a(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void j() {
/* 1019 */     this.B.clearActions();
/* 1020 */     this.A.clearActions();
/*      */     
/*      */     boolean bool;
/*      */     
/* 1024 */     if (!(bool = (this.D && this.R) ? true : false) || this.E) {
/*      */       
/* 1026 */       this.B.setTouchable(Touchable.disabled);
/* 1027 */       if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 1028 */         this.B.addAction((Action)Actions.sequence((Action)Actions.moveTo(0.0F, 150.0F, 0.1F), (Action)Actions.hide()));
/*      */       } else {
/* 1030 */         this.B.setPosition(0.0F, 150.0F);
/* 1031 */         this.B.setVisible(false);
/*      */       } 
/*      */     } else {
/*      */       
/* 1035 */       this.B.setTouchable(Touchable.childrenOnly);
/* 1036 */       this.B.setVisible(true);
/* 1037 */       if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 1038 */         this.B.addAction((Action)Actions.moveTo(-140.0F, 168.0F, 0.1F));
/*      */       } else {
/* 1040 */         this.B.setPosition(-140.0F, 168.0F);
/*      */       } 
/*      */     } 
/*      */     
/* 1044 */     if (bool && this.E) {
/*      */       
/* 1046 */       this.A.setTouchable(Touchable.enabled);
/* 1047 */       this.A.setVisible(true);
/* 1048 */       if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 1049 */         this.A.addAction((Action)Actions.moveTo(-472.0F, 214.0F, 0.15F)); return;
/*      */       } 
/* 1051 */       this.A.setPosition(-472.0F, 214.0F);
/*      */       
/*      */       return;
/*      */     } 
/* 1055 */     this.A.setTouchable(Touchable.disabled);
/* 1056 */     if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 1057 */       this.A.addAction((Action)Actions.sequence((Action)Actions.moveTo(0.0F, 214.0F, 0.15F), (Action)Actions.hide())); return;
/*      */     } 
/* 1059 */     this.A.setPosition(0.0F, 214.0F);
/* 1060 */     this.A.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1069 */     if (this.D != paramBoolean) {
/* 1070 */       this.D = paramBoolean;
/* 1071 */       j();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(boolean paramBoolean) {
/* 1079 */     if (this.E != paramBoolean) {
/* 1080 */       this.E = paramBoolean;
/* 1081 */       j();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void b(BuildButton paramBuildButton) {
/* 1086 */     if (paramBuildButton == null)
/*      */       return; 
/* 1088 */     if (this.C != paramBuildButton) {
/* 1089 */       this.H.setVisible(false);
/* 1090 */       this.I.setVisible(false);
/* 1091 */       this.J.setVisible(false);
/*      */       
/* 1093 */       if (paramBuildButton.k == TabType.TOWERS) {
/*      */         
/* 1095 */         this.H.setVisible(true);
/*      */         
/* 1097 */         Tower.Factory factory = Game.i.towerManager.getFactory(paramBuildButton.l);
/* 1098 */         this.F.setText(factory.getTitle());
/* 1099 */         this.G.setText(factory.getDescription());
/*      */         
/* 1101 */         this.H.setVisible(true);
/*      */         GeneralizedTowerStatType[] arrayOfGeneralizedTowerStatType;
/*      */         int j;
/* 1104 */         for (int i = (arrayOfGeneralizedTowerStatType = GeneralizedTowerStatType.values).length; j < i; ) { GeneralizedTowerStatType generalizedTowerStatType = arrayOfGeneralizedTowerStatType[j];
/* 1105 */           int k = factory.getGeneralizedStat(generalizedTowerStatType);
/* 1106 */           for (byte b = 0; b < 5; b++) {
/* 1107 */             this.M[generalizedTowerStatType.ordinal()][b].setVisible((b + 1 <= k));
/*      */           }
/*      */           
/*      */           j++; }
/*      */         
/* 1112 */         byte b1 = 0; EnemyType[] arrayOfEnemyType; byte b2;
/* 1113 */         for (j = (arrayOfEnemyType = EnemyType.mainEnemyTypes).length, b2 = 0; b2 < j; b2++) {
/* 1114 */           int k = (int)(this.O[b1].getTowerDamageMultiplier(paramBuildButton.l) * 100.0F);
/* 1115 */           P.setLength(0);
/* 1116 */           P.append(k);
/* 1117 */           this.N[b1].setText((CharSequence)P);
/*      */           
/* 1119 */           if (k <= 0) {
/* 1120 */             this.N[b1].setColor(MaterialColor.RED.P500);
/* 1121 */           } else if (k < 100) {
/* 1122 */             this.N[b1].setColor(MaterialColor.ORANGE.P600);
/* 1123 */           } else if (k > 100) {
/* 1124 */             this.N[b1].setColor(MaterialColor.GREEN.P500);
/*      */           } else {
/* 1126 */             this.N[b1].setColor(MaterialColor.YELLOW.P500);
/*      */           } 
/* 1128 */           b1++;
/*      */         } 
/* 1130 */       } else if (paramBuildButton.k == TabType.MINERS) {
/*      */         
/* 1132 */         Miner.Factory factory = Game.i.minerManager.getFactory(paramBuildButton.m);
/* 1133 */         this.F.setText(factory.getTitle());
/* 1134 */         this.G.setText(factory.getDescription());
/*      */         
/* 1136 */         this.I.setVisible(true); ResourceType[] arrayOfResourceType; int i;
/*      */         byte b;
/* 1138 */         for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 1139 */           if (factory.canMineResource(resourceType)) {
/* 1140 */             this.K[resourceType.ordinal()].setVisible(true);
/* 1141 */             this.L[resourceType.ordinal()].setText((CharSequence)StringFormatter.compactNumber(factory.getBaseMiningSpeed((GameValueProvider)this.V.gameValue), true));
/*      */           } else {
/* 1143 */             this.K[resourceType.ordinal()].setVisible(false);
/*      */           }  b++; }
/*      */       
/* 1146 */       } else if (paramBuildButton.k == TabType.MODIFIERS) {
/*      */         
/* 1148 */         Modifier.Factory factory = Game.i.modifierManager.getFactory(paramBuildButton.n);
/* 1149 */         this.F.setText(factory.getTitle());
/* 1150 */         this.G.setText(factory.getDescription((GameValueProvider)this.V.gameValue));
/*      */         
/* 1152 */         this.J.setVisible(true);
/*      */       } 
/*      */       
/* 1155 */       this.C = paramBuildButton;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void k() {
/* 1163 */     this.V.map.hideTowerRangeHint();
/*      */     
/* 1165 */     Y.clear();
/*      */     
/* 1167 */     if (this.R)
/*      */     {
/* 1169 */       if (this.Q != null)
/*      */       {
/* 1171 */         if (this.Q.k == TabType.TOWERS) {
/*      */           
/* 1173 */           Tile tile = this.V._gameMapSelection.getSelectedTile();
/*      */           Tower tower;
/* 1175 */           (tower = Game.i.towerManager.getFactory(this.Q.l).create()).setRegistered(this.V);
/*      */           
/* 1177 */           if (tile.type == TileType.PLATFORM && ((PlatformTile)tile).building == null) {
/*      */             
/* 1179 */             tower.setTile((PlatformTile)tile);
/* 1180 */             tower.updateCache();
/* 1181 */             if (tower.rangeInPixels != 0.0F) {
/* 1182 */               this.V.map.showTowerRangeHint(tile.center.x, tile.center.y, tower.minRangeInPixels, tower.rangeInPixels);
/*      */             }
/* 1184 */             tower.setTile(null);
/*      */           }  byte b;
/*      */           SpaceTileBonusType[] arrayOfSpaceTileBonusType;
/*      */           int i;
/* 1188 */           for (i = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b = 0; b < i; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b];
/* 1189 */             if (Game.i.towerManager.getFactory(tower.type).receivesSpaceTileBonus(spaceTileBonusType)) {
/* 1190 */               Y.add(spaceTileBonusType);
/*      */             }
/*      */             b++; }
/*      */           
/* 1194 */           tower.setUnregistered();
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/* 1200 */     boolean bool = false; ObjectSet.ObjectSetIterator<SpaceTileBonusType> objectSetIterator1;
/* 1201 */     for (objectSetIterator1 = Y.iterator(); objectSetIterator1.hasNext(); ) { SpaceTileBonusType spaceTileBonusType = objectSetIterator1.next();
/* 1202 */       if (!this.V._mapRendering.spaceTileBonusesToDrawColoredOnFreeTiles.contains(spaceTileBonusType)) {
/* 1203 */         this.V._mapRendering.spaceTileBonusesToDrawColoredOnFreeTiles.add(spaceTileBonusType);
/* 1204 */         bool = true;
/*      */       }  }
/*      */ 
/*      */     
/* 1208 */     for (ObjectSet.ObjectSetIterator<SpaceTileBonusType> objectSetIterator2 = (objectSetIterator1 = this.V._mapRendering.spaceTileBonusesToDrawColoredOnFreeTiles.iterator()).iterator(); objectSetIterator2.hasNext(); ) { SpaceTileBonusType spaceTileBonusType = objectSetIterator2.next();
/* 1209 */       if (!Y.contains(spaceTileBonusType)) {
/* 1210 */         objectSetIterator1.remove();
/* 1211 */         bool = true;
/*      */       }  }
/*      */     
/* 1214 */     if (bool) {
/* 1215 */       this.V._mapRendering.forceTilesRedraw(false);
/*      */     }
/*      */ 
/*      */     
/* 1219 */     j();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void l() {
/* 1226 */     this.R = (!this.h.isOffscreen() && this.j);
/* 1227 */     k();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(TabType paramTabType) {
/* 1235 */     this.o.setVisible(false);
/* 1236 */     this.p.setVisible(false);
/* 1237 */     this.q.setVisible(false);
/* 1238 */     this.x.setVisible(false);
/* 1239 */     this.y.setVisible(false);
/* 1240 */     this.z.setVisible(false);
/*      */     
/* 1242 */     if (paramTabType == TabType.TOWERS) {
/* 1243 */       this.o.setVisible(true);
/* 1244 */       this.x.setVisible(true);
/* 1245 */     } else if (paramTabType == TabType.MODIFIERS) {
/* 1246 */       this.p.setVisible(true);
/* 1247 */       this.y.setVisible(true);
/*      */       
/* 1249 */       TooltipsOverlay.i().markTagShown("BuildMenu.modifiersTab");
/* 1250 */       TooltipsOverlay.i().hideEntry("BuildMenu.modifiersTab");
/* 1251 */     } else if (paramTabType == TabType.MINERS) {
/* 1252 */       this.q.setVisible(true);
/* 1253 */       this.z.setVisible(true);
/*      */     } 
/*      */ 
/*      */     
/* 1257 */     this.r.setVisible((paramTabType != null));
/* 1258 */     this.s.setVisible((paramTabType != null));
/*      */     
/* 1260 */     this.i = paramTabType;
/* 1261 */     a((BuildButton)null);
/* 1262 */     m();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void m() {
/* 1269 */     int i = this.V.gameState.getMoney();
/* 1270 */     if (this.i == TabType.TOWERS) {
/*      */       boolean bool;
/*      */       
/* 1273 */       if (!(bool = Game.i.progressManager.areModifiersOpened())) {
/*      */         ModifierType[] arrayOfModifierType; int k; byte b1;
/* 1275 */         for (k = (arrayOfModifierType = ModifierType.values).length, b1 = 0; b1 < k; ) { ModifierType modifierType = arrayOfModifierType[b1];
/* 1276 */           if (this.V.gameValue.getIntValue(Game.i.modifierManager.getCountGameValue(modifierType)) > 0) {
/* 1277 */             bool = true; break;
/*      */           } 
/*      */           b1++; }
/*      */       
/*      */       } 
/* 1282 */       if (bool) {
/* 1283 */         this.t.setVisible(true);
/*      */         
/* 1285 */         if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.TT_MODIFIER_TAB_SHOWN) == 0.0D) {
/*      */           
/* 1287 */           if (!TooltipsOverlay.i().isTagShown("BuildMenu.modifiersTab") && !TooltipsOverlay.i().isVisible("BuildMenu.modifiersTab")) {
/* 1288 */             TooltipsOverlay.i().showText("BuildMenu.modifiersTab", (Actor)this.t, Game.i.localeManager.i18n.get("tooltip_modifiers_tab"), this.h.uiLayer.mainUiLayer, this.h.uiLayer.zIndex + 1, 4);
/*      */           }
/*      */         } else {
/*      */           
/* 1292 */           this.t.updateColors();
/*      */         } 
/*      */       } else {
/* 1295 */         this.t.setVisible(false);
/*      */       }  TowerType[] arrayOfTowerType; int j;
/*      */       byte b;
/* 1298 */       for (j = (arrayOfTowerType = TowerType.values).length, b = 0; b < j; ) { TowerType towerType = arrayOfTowerType[b];
/* 1299 */         int k = Game.i.towerManager.getFactory(towerType).getBuildPrice(this.V);
/*      */         
/*      */         BuildButton buildButton;
/* 1302 */         if ((buildButton = (BuildButton)this.S.get(towerType)) != null)
/*      */         
/* 1304 */         { buildButton.b(k);
/* 1305 */           if (i < k) {
/* 1306 */             buildButton.b(false);
/*      */           } else {
/* 1308 */             buildButton.b(true);
/*      */           } 
/*      */           
/* 1311 */           bool = Game.i.towerManager.getFactory(towerType).isAvailable((GameValueProvider)this.V.gameValue);
/* 1312 */           buildButton.c(bool); }  b++; }
/*      */        return;
/* 1314 */     }  if (this.i == TabType.MINERS) {
/* 1315 */       MinerType[] arrayOfMinerType; int j; byte b; for (j = (arrayOfMinerType = MinerType.values).length, b = 0; b < j; ) { MinerType minerType = arrayOfMinerType[b];
/* 1316 */         int k = this.V.miner.getBuildPrice(minerType);
/*      */         BuildButton buildButton;
/* 1318 */         if ((buildButton = (BuildButton)this.U.get(minerType)) != null) {
/*      */ 
/*      */ 
/*      */           
/* 1322 */           buildButton.b(k);
/* 1323 */           buildButton.a(this.V.miner.getBuildableMinersCount(minerType));
/* 1324 */           buildButton.c((this.V.miner.getMaxMinersCount(minerType) > 0));
/* 1325 */           if (i < k || BuildButton.a(buildButton) == 0) {
/* 1326 */             buildButton.b(false);
/*      */           } else {
/* 1328 */             buildButton.b(true);
/*      */           } 
/*      */           
/* 1331 */           if (Game.i.minerManager.isMinerOpened(minerType, (GameValueProvider)this.V.gameValue))
/* 1332 */           { buildButton.setVisible(true); }
/*      */           else
/* 1334 */           { buildButton.setVisible(false); } 
/*      */         }  b++; }
/*      */        return;
/* 1337 */     }  if (this.i == TabType.MODIFIERS) {
/* 1338 */       ModifierType[] arrayOfModifierType; int j; byte b; for (j = (arrayOfModifierType = ModifierType.values).length, b = 0; b < j; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 1339 */         int k = this.V.modifier.getBuildPrice(modifierType);
/*      */         BuildButton buildButton;
/* 1341 */         if ((buildButton = (BuildButton)this.T.get(modifierType)) != null) {
/*      */ 
/*      */ 
/*      */           
/* 1345 */           buildButton.b(k);
/* 1346 */           buildButton.a(this.V.modifier.getBuildableModifiersCount(modifierType));
/* 1347 */           buildButton.c((this.V.modifier.getMaxModifiersCount(modifierType) > 0));
/* 1348 */           if (i < k || BuildButton.a(buildButton) == 0) {
/* 1349 */             buildButton.b(false);
/*      */           } else {
/* 1351 */             buildButton.b(true);
/*      */           } 
/*      */           
/* 1354 */           boolean bool = Game.i.modifierManager.getFactory(modifierType).isAvailable((GameValueProvider)this.V.gameValue);
/* 1355 */           buildButton.c(bool);
/*      */         } 
/*      */         b++; }
/*      */     
/*      */     } 
/*      */   } private void n() {
/* 1361 */     this.w.setText(Game.i.towerManager.getAimStrategyName(this.V.tower.getDefaultAimStrategy()).toUpperCase());
/* 1362 */     this.u.setStrategy(this.V.tower.getDefaultAimStrategy(), true, false);
/*      */   }
/*      */   
/*      */   private void c(boolean paramBoolean) {
/* 1366 */     if (this.j != paramBoolean) {
/* 1367 */       this.j = paramBoolean;
/* 1368 */       if (paramBoolean) {
/* 1369 */         m();
/* 1370 */         this.n.show();
/*      */       } else {
/* 1372 */         this.n.hide();
/*      */       } 
/* 1374 */       l();
/*      */     } 
/*      */     
/* 1377 */     this.n.setLabelOverTitleTilePos(this.V._gameMapSelection.getSelectedTile());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {}
/*      */ 
/*      */ 
/*      */   
/*      */   private class BuildButton
/*      */     extends Group
/*      */   {
/*      */     private boolean o;
/*      */     
/*      */     private boolean p;
/*      */     
/*      */     private boolean q;
/*      */     
/*      */     private boolean r;
/*      */     
/*      */     private boolean s;
/*      */     
/* 1399 */     private int t = -1;
/* 1400 */     private int u = -1;
/*      */     
/*      */     BuildMenu.TabType k;
/*      */     
/*      */     TowerType l;
/*      */     
/*      */     MinerType m;
/*      */     ModifierType n;
/*      */     private final Image v;
/*      */     private final Actor w;
/*      */     private final Image x;
/*      */     private final Image y;
/*      */     private final Image z;
/*      */     private final Label A;
/*      */     private final Label B;
/*      */     private final Drawable C;
/*      */     private final Drawable D;
/*      */     
/*      */     BuildButton(BuildMenu this$0, Actor param1Actor) {
/* 1419 */       setTransform(false);
/* 1420 */       setTouchable(Touchable.enabled);
/*      */ 
/*      */ 
/*      */       
/* 1424 */       this.C = (Drawable)Game.i.assetManager.getDrawable("build-selection");
/* 1425 */       this.D = (Drawable)Game.i.assetManager.getDrawable("build-selection-count");
/*      */       
/* 1427 */       setSize(127.0F, 127.0F);
/*      */       
/* 1429 */       this.v = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 1430 */       this.v.setSize(127.0F, 127.0F);
/* 1431 */       this.v.setVisible(false);
/* 1432 */       this.v.setColor(BuildMenu.a());
/* 1433 */       addActor((Actor)this.v);
/*      */       
/* 1435 */       this.w = param1Actor;
/* 1436 */       param1Actor.setSize(128.0F, 128.0F);
/* 1437 */       param1Actor.setTouchable(Touchable.disabled);
/* 1438 */       addActor(param1Actor);
/*      */       
/* 1440 */       this.x = new Image((Drawable)Game.i.assetManager.getDrawable("build-selection-count-overlay"));
/* 1441 */       this.x.setSize(141.0F, 141.0F);
/* 1442 */       this.x.setVisible(false);
/* 1443 */       addActor((Actor)this.x);
/*      */       
/* 1445 */       this.z = new Image((Drawable)Game.i.assetManager.getDrawable("build-selection-hover"));
/* 1446 */       this.z.setSize(127.0F, 127.0F);
/* 1447 */       this.z.setVisible(false);
/* 1448 */       addActor((Actor)this.z);
/*      */       
/* 1450 */       this.y = new Image();
/* 1451 */       this.y.setSize(141.0F, 141.0F);
/* 1452 */       this.y.setVisible(false);
/* 1453 */       this.y.setPosition(-3.0F, -11.0F);
/* 1454 */       addActor((Actor)this.y);
/*      */       
/* 1456 */       this.B = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), MaterialColor.YELLOW.P500));
/* 1457 */       this.B.setSize(120.0F, 32.0F);
/* 1458 */       this.B.setAlignment(8);
/* 1459 */       this.B.setTouchable(Touchable.disabled);
/* 1460 */       addActor((Actor)this.B);
/*      */       
/* 1462 */       this.A = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 1463 */       this.A.setSize(120.0F, 32.0F);
/* 1464 */       this.A.setAlignment(16);
/* 1465 */       this.A.setTouchable(Touchable.disabled);
/* 1466 */       addActor((Actor)this.A);
/*      */       
/* 1468 */       addListener((EventListener)new InputListener(this, this$0)
/*      */           {
/*      */             public boolean touchDown(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 1471 */               BuildMenu.BuildButton.a(this.a, true);
/* 1472 */               BuildMenu.BuildButton.b(this.a);
/*      */               
/* 1474 */               return true;
/*      */             }
/*      */ 
/*      */             
/*      */             public void touchUp(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 1479 */               BuildMenu.BuildButton.a(this.a, false);
/* 1480 */               BuildMenu.BuildButton.b(this.a);
/*      */             }
/*      */ 
/*      */             
/*      */             public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1485 */               BuildMenu.BuildButton.b(this.a, true);
/* 1486 */               BuildMenu.BuildButton.b(this.a);
/*      */             }
/*      */ 
/*      */             
/*      */             public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1491 */               BuildMenu.BuildButton.b(this.a, false);
/* 1492 */               BuildMenu.BuildButton.b(this.a);
/*      */             }
/*      */           });
/*      */       
/* 1496 */       d();
/*      */     }
/*      */     
/*      */     private void d() {
/* 1500 */       if (this.u < 0) {
/*      */         
/* 1502 */         this.y.setDrawable(this.C);
/* 1503 */         this.x.setVisible(false);
/*      */         
/* 1505 */         this.B.setVisible(false);
/* 1506 */         this.x.setVisible(false);
/*      */       } else {
/*      */         
/* 1509 */         this.y.setDrawable(this.D);
/*      */         
/* 1511 */         BuildMenu.b().setLength(0);
/* 1512 */         BuildMenu.b().append('x').append(this.u);
/* 1513 */         this.B.setText((CharSequence)BuildMenu.b());
/*      */         
/* 1515 */         if (this.u == 0) {
/* 1516 */           this.B.setColor(MaterialColor.RED.P500);
/*      */         } else {
/* 1518 */           this.B.setColor(MaterialColor.YELLOW.P500);
/*      */         } 
/*      */         
/* 1521 */         this.B.setVisible(true);
/* 1522 */         this.x.setVisible(true);
/*      */       } 
/*      */       
/* 1525 */       if (this.p && this.o) {
/* 1526 */         if (this.s) {
/* 1527 */           this.y.setColor(BuildMenu.c());
/* 1528 */         } else if (this.r) {
/* 1529 */           this.y.setColor(BuildMenu.d());
/*      */         } else {
/* 1531 */           this.y.setColor(BuildMenu.e());
/*      */         } 
/*      */       } else {
/* 1534 */         this.y.setColor(BuildMenu.f());
/*      */       } 
/*      */       
/* 1537 */       if (this.p) {
/* 1538 */         this.A.setVisible(true);
/* 1539 */         if (this.o) {
/* 1540 */           this.v.setVisible(true);
/* 1541 */           this.A.setColor(BuildMenu.g());
/*      */         } else {
/* 1543 */           this.v.setVisible(false);
/* 1544 */           this.A.setColor(BuildMenu.h());
/*      */         } 
/*      */       } else {
/* 1547 */         this.v.setVisible(false);
/* 1548 */         this.A.setVisible(false);
/*      */       } 
/*      */       
/* 1551 */       if (this.p && this.o) {
/* 1552 */         this.w.setColor(Color.WHITE);
/*      */       } else {
/* 1554 */         this.w.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */       } 
/*      */       
/* 1557 */       if (this.q) {
/* 1558 */         this.y.setVisible(true);
/* 1559 */         setZIndex(99);
/* 1560 */         this.A.setPosition(4.0F, -2.0F);
/* 1561 */         this.B.setPosition(6.0F, 0.0F);
/* 1562 */         this.z.setVisible(false);
/* 1563 */         this.A.setColor(Color.WHITE);
/*      */         
/* 1565 */         this.x.setPosition(-3.0F, -11.0F); return;
/*      */       } 
/* 1567 */       this.y.setVisible(false);
/* 1568 */       this.A.setPosition(0.0F, 2.0F);
/* 1569 */       this.B.setPosition(10.0F, 4.0F);
/* 1570 */       this.z.setVisible(this.r);
/* 1571 */       this.x.setPosition(0.0F, -8.0F);
/*      */     }
/*      */ 
/*      */     
/*      */     final void a(int param1Int) {
/* 1576 */       this.u = param1Int;
/*      */       
/* 1578 */       d();
/*      */     }
/*      */     
/*      */     final void a(boolean param1Boolean) {
/* 1582 */       this.q = param1Boolean;
/*      */       
/* 1584 */       d();
/*      */     }
/*      */     
/*      */     final void b(boolean param1Boolean) {
/* 1588 */       this.o = param1Boolean;
/*      */       
/* 1590 */       d();
/*      */     }
/*      */     
/*      */     final void c(boolean param1Boolean) {
/* 1594 */       this.p = param1Boolean;
/* 1595 */       setTouchable(param1Boolean ? Touchable.enabled : Touchable.disabled);
/*      */       
/* 1597 */       d();
/*      */     }
/*      */     
/*      */     final void b(int param1Int) {
/* 1601 */       if (this.t != param1Int) {
/* 1602 */         BuildMenu.b().setLength(0);
/* 1603 */         BuildMenu.b().append(param1Int);
/* 1604 */         this.A.setText((CharSequence)BuildMenu.b());
/* 1605 */         this.t = param1Int;
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class _SideMenuListener extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*      */     private _SideMenuListener(BuildMenu this$0) {}
/*      */     
/*      */     public void offscreenChanged() {
/* 1613 */       BuildMenu.b(this.a);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\BuildMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */