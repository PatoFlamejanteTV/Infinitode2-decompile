/*      */ package com.prineside.tdi2.ui.components;
/*      */ import com.badlogic.gdx.InputAdapter;
/*      */ import com.badlogic.gdx.InputProcessor;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.SpaceTileBonus;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.enums.BuildingType;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TowerStatType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.events.game.BuildingRemove;
/*      */ import com.prineside.tdi2.events.game.CoinsChange;
/*      */ import com.prineside.tdi2.events.game.MapElementSelect;
/*      */ import com.prineside.tdi2.events.game.TowerAbilityChange;
/*      */ import com.prineside.tdi2.events.game.TowerAimStrategyChange;
/*      */ import com.prineside.tdi2.events.game.TowerCustomButtonPress;
/*      */ import com.prineside.tdi2.events.game.TowerExperienceChange;
/*      */ import com.prineside.tdi2.events.game.TowerLevelUp;
/*      */ import com.prineside.tdi2.events.game.TowerPlace;
/*      */ import com.prineside.tdi2.events.game.TowerUpgrade;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.TowerManager;
/*      */ import com.prineside.tdi2.managers.TowerStatManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.TowerSystem;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.ui.actors.AimStrategySelector;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.EffectTooltip;
/*      */ import com.prineside.tdi2.ui.actors.ExpLine;
/*      */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.actors.SideMenu;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class TowerMenu implements Disposable {
/*   70 */   private static final TLog a = TLog.forClass(TowerMenu.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   75 */   private static final Rectangle b = new Rectangle(40.0F, 209.0F, 520.0F, 66.0F);
/*   76 */   private static final Rectangle c = new Rectangle(40.0F, 319.0F, 520.0F, 151.0F);
/*      */   
/*      */   private final SideMenu d;
/*      */   private final SideMenu.SideMenuContainer e;
/*      */   private final LabelToggleButton f;
/*      */   private HotKeyHintLabel g;
/*      */   private final Label h;
/*      */   private final Label i;
/*      */   private final Label j;
/*      */   private final Label k;
/*      */   private final Label l;
/*      */   private final Table m;
/*      */   private final Label n;
/*      */   private final ExpLine o;
/*      */   private final Label p;
/*   91 */   private final CharacteristicCell[] q = new CharacteristicCell[8];
/*   92 */   private final TowerAbilityButton[] r = new TowerAbilityButton[6];
/*      */   
/*      */   private final UpgradeSubmenu s;
/*      */   
/*      */   private final AimStrategySelector t;
/*      */   
/*      */   private final ComplexButton u;
/*      */   private final SellButton v;
/*      */   private final Group w;
/*      */   private final Group x;
/*      */   private final Group y;
/*      */   private Table z;
/*      */   private Label A;
/*      */   private Label B;
/*      */   private Image C;
/*      */   private Label D;
/*      */   private Image E;
/*      */   private Label F;
/*      */   private Table G;
/*      */   private float H;
/*      */   private float I;
/*      */   private float J;
/*      */   private float K;
/*      */   private int L;
/*      */   private boolean M;
/*      */   private boolean N;
/*      */   private boolean O;
/*  119 */   private int P = -1;
/*  120 */   private float Q = 0.0F;
/*      */   
/*      */   private boolean R;
/*  123 */   private short S = -1;
/*      */   
/*      */   private float T;
/*      */   
/*      */   private boolean U;
/*      */   private boolean V = false;
/*  129 */   private ObjectMap<String, Object> W = new ObjectMap();
/*      */   
/*      */   private Group X;
/*      */   private InputProcessor Y;
/*      */   private Group Z;
/*  134 */   private final Runnable aa = this::d;
/*      */ 
/*      */   
/*      */   private final GameSystemProvider ab;
/*      */   
/*  139 */   private static final StringBuilder ac = new StringBuilder();
/*  140 */   private static final Vector2 ad = new Vector2();
/*      */   
/*      */   public TowerMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  143 */     this.ab = paramGameSystemProvider;
/*      */     
/*  145 */     this.d = paramSideMenu;
/*      */ 
/*      */     
/*  148 */     this.e = paramSideMenu.createContainer("TowerMenu");
/*      */     
/*  150 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */     
/*      */     Group group2;
/*      */     
/*  154 */     (group2 = new Group()).setTransform(false);
/*  155 */     group2.setSize(600.0F, 335.0F);
/*  156 */     group2.setPosition(0.0F, 745.0F + i);
/*  157 */     this.e.addActor((Actor)group2);
/*      */     
/*  159 */     this.G = new Table();
/*  160 */     this.G.setSize(366.0F, 32.0F);
/*  161 */     this.G.setPosition(40.0F, 281.0F);
/*  162 */     group2.addActor((Actor)this.G);
/*      */ 
/*      */     
/*  165 */     this.f = new LabelToggleButton("", true, 36, 30.0F, false, null);
/*  166 */     this.f.onToggle = (paramBoolean -> {
/*      */         if (paramGameSystemProvider.tower.canTowersBeManuallyDisabled()) {
/*      */           paramGameSystemProvider.tower.toggleTowerEnabledAction();
/*      */           
/*      */           return;
/*      */         } 
/*      */         Notifications.i().add(Game.i.localeManager.i18n.get("towers_can_not_be_disabled"), null, null, StaticSoundType.FAIL);
/*      */         this.f.setEnabled(true);
/*      */       });
/*  175 */     this.f.normalColor = Color.WHITE.cpy();
/*  176 */     this.f.hoverColor = MaterialColor.LIGHT_BLUE.P300.cpy();
/*  177 */     this.f.updateColor();
/*  178 */     this.f.setSize(366.0F, 26.0F);
/*  179 */     this.f.setPosition(40.0F, 249.0F);
/*  180 */     group2.addActor((Actor)this.f);
/*      */     
/*  182 */     if (HotKeyHintLabel.isEnabled()) {
/*  183 */       this.g = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_TOWER_ENABLED), 380.0F, 5.0F, 8);
/*  184 */       this.f.addActor((Actor)this.g);
/*      */     } 
/*      */     
/*  187 */     this.w = new Group();
/*  188 */     this.w.setName("tower_menu_experience");
/*  189 */     this.w.setTransform(false);
/*  190 */     this.w.setPosition(b.x, b.y);
/*  191 */     this.w.setSize(b.width, b.height);
/*  192 */     this.w.setOrigin(b.width / 2.0F, b.height / 2.0F);
/*  193 */     this.w.setTouchable(Touchable.disabled);
/*  194 */     group2.addActor((Actor)this.w);
/*      */ 
/*      */     
/*  197 */     this.h = new Label("L10", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  198 */     this.h.setSize(40.0F, 26.0F);
/*  199 */     this.h.setPosition(480.0F, 40.0F);
/*  200 */     this.h.setAlignment(16);
/*  201 */     this.h.setTouchable(Touchable.disabled);
/*  202 */     this.w.addActor((Actor)this.h);
/*      */ 
/*      */     
/*  205 */     this.o = new ExpLine();
/*  206 */     this.o.setPosition(0.0F, 0.0F);
/*  207 */     this.w.addActor((Actor)this.o);
/*      */     
/*  209 */     this.j = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  210 */     this.j.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  211 */     this.j.setSize(159.0F, 24.0F);
/*  212 */     this.j.setPosition(10.0F, 0.0F);
/*  213 */     this.j.setAlignment(8);
/*  214 */     this.w.addActor((Actor)this.j);
/*      */     
/*  216 */     this.i = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  217 */     this.i.setColor(Color.WHITE);
/*  218 */     this.i.setSize(159.0F, 24.0F);
/*  219 */     this.i.setPosition(8.0F, 0.0F);
/*  220 */     this.i.setAlignment(8);
/*  221 */     this.w.addActor((Actor)this.i);
/*      */ 
/*      */     
/*  224 */     this.k = new Label("53 / 90 XP", Game.i.assetManager.getLabelStyle(24));
/*      */     
/*  226 */     this.k.setPosition(0.0F, 0.0F);
/*  227 */     this.k.setSize(520.0F, 24.0F);
/*  228 */     this.k.setAlignment(16);
/*  229 */     this.w.addActor((Actor)this.k);
/*      */     
/*  231 */     this.l = new Label("+0 XP/s", Game.i.assetManager.getLabelStyle(21));
/*  232 */     this.l.setColor(MaterialColor.AMBER.P800);
/*  233 */     this.l.setPosition(0.0F, -26.0F);
/*  234 */     this.l.setSize(520.0F, 24.0F);
/*  235 */     this.l.setAlignment(16);
/*  236 */     this.w.addActor((Actor)this.l);
/*      */ 
/*      */     
/*  239 */     this.z = new Table();
/*  240 */     this.z.setPosition(40.0F, 172.0F);
/*  241 */     this.z.setSize(520.0F, 24.0F);
/*  242 */     group2.addActor((Actor)this.z);
/*      */     
/*      */     Image image;
/*  245 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-mdps"))).setColor(MaterialColor.PURPLE.P300);
/*  246 */     this.z.add((Actor)image).size(24.0F).padRight(8.0F);
/*      */     
/*  248 */     this.A = new Label("0", Game.i.assetManager.getLabelStyle(21));
/*  249 */     this.A.setColor(MaterialColor.PURPLE.P300);
/*  250 */     this.z.add((Actor)this.A).height(24.0F).padRight(16.0F);
/*      */ 
/*      */     
/*  253 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-skull-and-bones"))).setColor(MaterialColor.RED.P300);
/*  254 */     this.z.add((Actor)image).size(24.0F).padRight(8.0F);
/*      */     
/*  256 */     this.B = new Label("0", Game.i.assetManager.getLabelStyle(21));
/*  257 */     this.B.setColor(MaterialColor.RED.P300);
/*  258 */     this.z.add((Actor)this.B).height(24.0F).padRight(16.0F);
/*      */     
/*  260 */     this.E = new Image((Drawable)Game.i.assetManager.getDrawable("icon-damage"));
/*  261 */     this.E.setColor(MaterialColor.GREY.P600);
/*  262 */     this.z.add((Actor)this.E).size(24.0F).padRight(8.0F);
/*      */     
/*  264 */     this.F = new Label("0", Game.i.assetManager.getLabelStyle(21));
/*  265 */     this.F.setColor(MaterialColor.GREY.P600);
/*  266 */     this.z.add((Actor)this.F).height(24.0F).padRight(16.0F);
/*      */     
/*  268 */     this.C = new Image((Drawable)Game.i.assetManager.getDrawable("icon-coin"));
/*  269 */     this.C.setColor(MaterialColor.AMBER.P300);
/*  270 */     this.z.add((Actor)this.C).size(24.0F).padRight(8.0F);
/*      */     
/*  272 */     this.D = new Label("0", Game.i.assetManager.getLabelStyle(21));
/*  273 */     this.D.setColor(MaterialColor.AMBER.P300);
/*  274 */     this.z.add((Actor)this.D).height(24.0F).padRight(16.0F);
/*      */     
/*  276 */     this.z.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */     
/*  279 */     this.m = new Table();
/*  280 */     this.m.setPosition(0.0F, 99.0F);
/*  281 */     this.m.setSize(600.0F, 64.0F);
/*  282 */     group2.addActor((Actor)this.m);
/*      */     
/*  284 */     this.n = new Label(Game.i.localeManager.i18n.get("no_tile_effects"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  285 */     this.n.setPosition(0.0F, 115.0F);
/*  286 */     this.n.setSize(600.0F, 64.0F);
/*  287 */     this.n.setAlignment(1);
/*  288 */     group2.addActor((Actor)this.n);
/*      */     
/*  290 */     Label.LabelStyle labelStyle = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*      */     
/*      */     Label label3;
/*      */     
/*  294 */     (label3 = new Label(Game.i.localeManager.i18n.get("characteristics").toUpperCase(), labelStyle)).setSize(150.0F, 15.0F);
/*  295 */     label3.setPosition(40.0F, 806.0F + i);
/*  296 */     this.e.addActor((Actor)label3);
/*      */     
/*      */     Table table1;
/*  299 */     (table1 = new Table()).setSize(150.0F, 30.0F);
/*  300 */     table1.setPosition(410.0F, 800.0F + i);
/*  301 */     this.e.addActor((Actor)table1);
/*      */     
/*  303 */     Table table2 = new Table();
/*  304 */     table1.add((Actor)table2).expand().bottom().right();
/*      */     
/*      */     Label label2;
/*  307 */     (label2 = new Label("PWR: ", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  308 */     label2.setAlignment(20);
/*  309 */     table2.add((Actor)label2).height(30.0F).bottom().right();
/*      */     
/*  311 */     this.p = new Label("000", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  312 */     this.p.setColor(MaterialColor.AMBER.P500);
/*  313 */     this.p.setAlignment(20);
/*  314 */     table2.add((Actor)this.p).height(30.0F).bottom().right();
/*      */     
/*  316 */     for (byte b = 0; b < 8; b++) {
/*  317 */       this.q[b] = new CharacteristicCell(this);
/*  318 */       this.q[b].setPosition(40.0F + (b % 2) * 262.0F, 725.0F - (b / 2) * 68.0F + i);
/*  319 */       this.e.addActor((Actor)this.q[b]);
/*      */     } 
/*      */ 
/*      */     
/*  323 */     this.X = new Group();
/*  324 */     this.X.setTransform(false);
/*  325 */     this.X.setSize(600.0F, 132.0F);
/*  326 */     this.X.setPosition(0.0F, 513.0F);
/*  327 */     this.X.setTouchable(Touchable.childrenOnly);
/*  328 */     this.e.addActor((Actor)this.X);
/*      */ 
/*      */     
/*  331 */     this.x = new Group();
/*  332 */     this.x.setTransform(false);
/*  333 */     this.x.setPosition(c.x, c.y);
/*  334 */     this.x.setSize(c.width, c.height);
/*  335 */     this.x.setOrigin(c.width / 2.0F, c.height / 2.0F);
/*  336 */     this.x.setName("tower_menu_abilities");
/*  337 */     this.e.addActor((Actor)this.x);
/*      */     
/*  339 */     this.y = new Group();
/*  340 */     this.y.setTransform(false);
/*  341 */     this.y.setSize(c.width, 30.0F);
/*  342 */     this.x.addActor((Actor)this.y);
/*      */     
/*      */     Label label1;
/*  345 */     (label1 = new Label(Game.i.localeManager.i18n.get("abilities").toUpperCase(), labelStyle)).setSize(150.0F, 15.0F);
/*  346 */     if (HotKeyHintLabel.isEnabled()) {
/*  347 */       label1.setPosition(0.0F, 150.0F);
/*      */     } else {
/*  349 */       label1.setPosition(0.0F, 136.0F);
/*      */     } 
/*  351 */     this.x.addActor((Actor)label1);
/*      */     
/*  353 */     for (i = 0; i < 6; i++) {
/*  354 */       this.r[i] = new TowerAbilityButton(i);
/*  355 */       this.r[i].setPosition(i * 88.0F, 38.0F);
/*  356 */       this.x.addActor((Actor)this.r[i]);
/*      */       
/*  358 */       int j = i;
/*  359 */       this.r[i].addListener(new TowerAbilityButton.AbilityButtonListener(this, paramGameSystemProvider, j)
/*      */           {
/*      */             public void abilityConfirmed() {
/*  362 */               if (TowerMenu.a(this.c) != null) {
/*  363 */                 this.a.tower.selectTowerAbilityAction(TowerMenu.a(this.c), this.b);
/*  364 */                 TowerMenu.a(this.c, -1);
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             public void globalAbilityConfirmed() {
/*  370 */               if (TowerMenu.a(this.c) != null) {
/*  371 */                 this.a.tower.selectGlobalTowerAbilityAction(TowerMenu.a(this.c), this.b);
/*  372 */                 TowerMenu.a(this.c, -1);
/*      */               } 
/*      */             }
/*      */           });
/*      */       
/*  377 */       this.r[i].addListener((EventListener)new ClickListener(this, j)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  380 */               TowerMenu.b(this.b).setButtonSelected(false);
/*  381 */               TowerMenu.a(this.b, this.a);
/*      */             }
/*      */ 
/*      */             
/*      */             public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  386 */               if (param1Int == -1) {
/*  387 */                 TowerMenu.a(this.b, this.a);
/*      */               }
/*  389 */               super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             }
/*      */ 
/*      */             
/*      */             public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  394 */               if (param1Int == -1) {
/*  395 */                 TowerMenu.a(this.b, -1);
/*      */               }
/*  397 */               super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             }
/*      */           });
/*      */       
/*  401 */       if (HotKeyHintLabel.isEnabled()) {
/*  402 */         SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_1;
/*      */         
/*  404 */         switch (i) { case 0:
/*  405 */             hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_1; break;
/*  406 */           case 1: hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_2; break;
/*  407 */           case 2: hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_3; break;
/*  408 */           case 3: hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_4; break;
/*  409 */           case 4: hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_5; break;
/*  410 */           case 5: hotkeyAction = SettingsManager.HotkeyAction.TOWER_ABILITY_6; break; }
/*      */         
/*  412 */         HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(hotkeyAction), 40.0F, 90.0F);
/*      */         
/*  414 */         this.r[i].addActor((Actor)hotKeyHintLabel);
/*      */       } 
/*      */     } 
/*      */     
/*      */     Group group1;
/*      */     
/*  420 */     (group1 = new Group()).setName("tower_menu_upgrade");
/*  421 */     group1.setTransform(false);
/*  422 */     group1.setSize(600.0F, 300.0F);
/*  423 */     this.e.addActor((Actor)group1);
/*      */ 
/*      */     
/*  426 */     (label1 = new Label(Game.i.localeManager.i18n.get("upgrade_level").toUpperCase(), labelStyle)).setSize(150.0F, 15.0F);
/*  427 */     label1.setPosition(40.0F, 267.0F);
/*  428 */     group1.addActor((Actor)label1);
/*      */     
/*  430 */     this.s = new UpgradeSubmenu();
/*  431 */     this.s.addListener(new UpgradeSubmenu.UpgradeSubmenuListener(this, paramGameSystemProvider)
/*      */         {
/*      */           public void upgradeButtonStateChanged(boolean param1Boolean) {
/*  434 */             TowerMenu.a(this.b, -1);
/*  435 */             TowerMenu.a(this.b, true);
/*      */           }
/*      */ 
/*      */           
/*      */           public void upgradeButtonConfirmed() {
/*      */             Tower tower;
/*  441 */             if ((tower = TowerMenu.a(this.b)) != null) {
/*  442 */               this.a.tower.upgradeTowerAction(tower);
/*  443 */               TowerMenu.a(this.b, -1);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void globalUpgradeButtonConfirmed() {
/*      */             Tower tower;
/*  450 */             if ((tower = TowerMenu.a(this.b)) != null) {
/*  451 */               int i = this.a.tower.getGlobalUpgradePrice(tower.type);
/*  452 */               String str = Game.i.localeManager.i18n.get("upgrade_all_towers_by_type_confirm") + " <@game-ui-coin-icon>[#FDD835]" + StringFormatter.commaSeparatedNumber(i) + "[]";
/*  453 */               Dialog.i().showConfirm(Game.i.assetManager.replaceRegionAliasesWithChars(str), () -> {
/*      */                     param1GameSystemProvider.tower.globalUpgradeTowerAction(param1Tower.type);
/*      */                     TowerMenu.a(this.b, true);
/*      */                   });
/*      */             } 
/*      */           }
/*      */         });
/*  460 */     this.s.setPosition(0.0F, 132.0F);
/*  461 */     this.s.upgradeButton.setName("tower_menu_upgrade_button");
/*  462 */     group1.addActor((Actor)this.s);
/*      */ 
/*      */     
/*  465 */     this.t = new AimStrategySelector();
/*  466 */     this.t.setName("tower_menu_aim_strategy");
/*  467 */     this.t.setPosition(40.0F, 40.0F);
/*  468 */     this.t.addListener(paramAimStrategy -> {
/*      */           Tower tower;
/*      */           if ((tower = c()) != null) {
/*      */             paramGameSystemProvider.tower.setTowerAimStrategyAction(tower, paramAimStrategy);
/*      */             paramGameSystemProvider._gameUi.tooltip.show(Game.i.towerManager.getAimStrategyName(paramAimStrategy));
/*      */           } 
/*      */         });
/*  475 */     this.e.addActor((Actor)this.t);
/*      */ 
/*      */     
/*  478 */     this.u = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> {
/*      */           if (this.U) {
/*      */             cancelUsingCustomButton();
/*      */             return;
/*      */           } 
/*      */           Tower tower;
/*      */           if ((tower = c()) != null && tower.hasCustomButton()) {
/*      */             if (tower.isCustomButtonNeedMapPoint()) {
/*      */               startUsingCustomButton();
/*      */               return;
/*      */             } 
/*      */             paramGameSystemProvider.tower.customTowerButtonAction(tower, 0, 0);
/*      */           } 
/*      */         });
/*  492 */     this.u.setLabel(80.0F, 20.0F, 200.0F, 40.0F, 8);
/*  493 */     this.u.label.setWrap(true);
/*  494 */     this.u.icon.setSize(40.0F, 40.0F);
/*  495 */     this.u.icon.setPosition(20.0F, 20.0F);
/*  496 */     this.u.setPosition(40.0F, 40.0F);
/*  497 */     this.u.setSize(309.0F, 80.0F);
/*  498 */     this.u.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 80.0F, 309.0F, 80.0F, 283.0F, 0.0F })), 0.0F, 0.0F, 309.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  507 */     this.e.addActor((Actor)this.u);
/*      */ 
/*      */     
/*  510 */     this.v = new SellButton(() -> {
/*      */           Tower tower;
/*      */           if ((tower = c()) != null) {
/*      */             if (tower.isOutOfOrder()) {
/*      */               Notifications.i().add(Game.i.localeManager.i18n.get("not_possible_at_the_moment"), null, null, StaticSoundType.FAIL);
/*      */               return;
/*      */             } 
/*      */             paramGameSystemProvider.tower.sellTowerAction(tower);
/*      */           } 
/*      */         });
/*  520 */     this.v.setName("tower_menu_sell_button");
/*  521 */     this.v.setPosition(368.0F, 40.0F);
/*  522 */     this.e.addActor((Actor)this.v);
/*      */ 
/*      */ 
/*      */     
/*  526 */     paramSideMenu.addListener((SideMenu.SideMenuListener)new _SideMenuListener((byte)0));
/*      */ 
/*      */     
/*  529 */     paramGameSystemProvider.events.getListeners(TowerPlace.class).add(paramTowerPlace -> {
/*      */           if (paramTowerPlace.getTower().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             this.M = true;
/*      */             
/*      */             a(true);
/*      */           } 
/*      */         });
/*  536 */     paramGameSystemProvider.events.getListeners(TowerLevelUp.class).add(paramTowerLevelUp -> {
/*      */           Tower tower = c();
/*      */           if (paramTowerLevelUp.getTower() == tower) {
/*      */             this.M = true;
/*      */           }
/*      */         });
/*  542 */     paramGameSystemProvider.events.getListeners(TowerUpgrade.class).add(paramTowerUpgrade -> this.M = true);
/*      */ 
/*      */     
/*  545 */     paramGameSystemProvider.events.getListeners(TowerAimStrategyChange.class).add(paramTowerAimStrategyChange -> {
/*      */           Tower tower = c();
/*      */           if (paramTowerAimStrategyChange.getTower() == tower) {
/*      */             e();
/*      */           }
/*      */         });
/*  551 */     paramGameSystemProvider.events.getListeners(TowerAbilityChange.class).add(paramTowerAbilityChange -> {
/*      */           Tower tower = c();
/*      */           if (paramTowerAbilityChange.getTower() == tower) {
/*      */             this.M = true;
/*      */           }
/*      */         });
/*  557 */     paramGameSystemProvider.events.getListeners(TowerCustomButtonPress.class).add(paramTowerCustomButtonPress -> this.M = true);
/*      */ 
/*      */     
/*  560 */     paramGameSystemProvider.events.getListeners(BuildingRemove.class).add(paramBuildingRemove -> {
/*      */           if (paramBuildingRemove.getOldTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             a(false);
/*      */           }
/*      */         });
/*      */     
/*  566 */     paramGameSystemProvider.events.getListeners(CoinsChange.class).add(paramCoinsChange -> Game.i.uiManager.runOnStageActOnce(this.aa));
/*  567 */     paramGameSystemProvider.events.getListeners(TowerExperienceChange.class).add(paramTowerExperienceChange -> {
/*      */           Tower tower = c();
/*      */           if (paramTowerExperienceChange.getTower() == tower) {
/*      */             this.N = true;
/*      */           }
/*      */         });
/*  573 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*      */           Tile tile;
/*      */           
/*      */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.PLATFORM && ((PlatformTile)tile).building != null && ((PlatformTile)tile).building.buildingType == BuildingType.TOWER) {
/*      */             this.s.setButtonSelected(false);
/*      */             this.M = true;
/*      */             a(true);
/*      */             return;
/*      */           } 
/*      */           a(false);
/*      */         });
/*  584 */     this.e.hide();
/*      */     
/*  586 */     this.Y = (InputProcessor)new InputAdapter(this, paramGameSystemProvider)
/*      */       {
/*      */         public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  589 */           if (this.a._input == null) return false;
/*      */           
/*      */           Tower tower;
/*  592 */           if ((tower = TowerMenu.a(this.b)) != null && TowerMenu.c(this.b)) {
/*  593 */             TowerMenu.a().set(param1Int1, param1Int2);
/*  594 */             this.a._input.getCameraController().screenToMap(TowerMenu.a());
/*  595 */             if (TowerMenu.c(this.b)) {
/*  596 */               this.a.tower.customTowerButtonAction(TowerMenu.a(this.b), (int)(TowerMenu.a()).x, (int)(TowerMenu.a()).y);
/*      */             }
/*      */           } 
/*      */           
/*  600 */           this.b.cancelUsingCustomButton();
/*  601 */           return false;
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   public void startUsingCustomButton() {
/*  607 */     if (this.U) {
/*  608 */       a.e("been using custom button, canceling", new Object[0]);
/*  609 */       cancelUsingCustomButton();
/*      */     } 
/*      */     
/*  612 */     this.U = true;
/*  613 */     this.ab._input.setupInputMultiplexer(true, true, false).addProcessor(this.Y);
/*  614 */     e();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cancelUsingCustomButton() {
/*  621 */     this.ab._input.enableAllInput();
/*  622 */     this.U = false;
/*  623 */     e();
/*      */   }
/*      */   
/*      */   public boolean isVisible() {
/*  627 */     return this.e.isVisible();
/*      */   }
/*      */   
/*      */   private void a(int paramInt) {
/*  631 */     if (this.P != paramInt) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  639 */       this.P = paramInt;
/*  640 */       this.M = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Tower c() {
/*      */     Tile tile;
/*  649 */     if ((tile = this.ab._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.PLATFORM) {
/*      */       PlatformTile platformTile;
/*  651 */       if ((platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*  652 */         return (Tower)platformTile.building;
/*      */       }
/*  654 */       return null;
/*      */     } 
/*      */     
/*  657 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: invokespecial c : ()Lcom/prineside/tdi2/Tower;
/*      */     //   4: dup
/*      */     //   5: astore_1
/*      */     //   6: ifnull -> 63
/*      */     //   9: aload_1
/*      */     //   10: invokevirtual getUpgradeLevel : ()B
/*      */     //   13: aload_1
/*      */     //   14: invokevirtual getMaxUpgradeLevel : ()B
/*      */     //   17: if_icmplt -> 27
/*      */     //   20: aload_0
/*      */     //   21: getfield s : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*      */     //   24: goto -> 59
/*      */     //   27: aload_0
/*      */     //   28: getfield s : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*      */     //   31: aload_0
/*      */     //   32: getfield ab : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   35: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   38: invokevirtual getMoney : ()I
/*      */     //   41: aload_0
/*      */     //   42: getfield ab : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   45: getfield tower : Lcom/prineside/tdi2/systems/TowerSystem;
/*      */     //   48: aload_1
/*      */     //   49: invokevirtual getUpgradePrice : (Lcom/prineside/tdi2/Tower;)I
/*      */     //   52: if_icmplt -> 59
/*      */     //   55: iconst_1
/*      */     //   56: goto -> 60
/*      */     //   59: iconst_0
/*      */     //   60: invokevirtual a : (Z)V
/*      */     //   63: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #665	-> 0
/*      */     //   #667	-> 5
/*      */     //   #668	-> 9
/*      */     //   #670	-> 20
/*      */     //   #673	-> 27
/*      */     //   #676	-> 63
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e() {
/*  679 */     Tower tower = c();
/*      */     
/*  681 */     this.u.setVisible(false);
/*  682 */     if (tower != null) {
/*  683 */       if (!tower.canAim()) {
/*  684 */         this.t.setVisible(false);
/*  685 */         if (tower.hasCustomButton()) {
/*      */           
/*  687 */           this.u.setVisible(true);
/*  688 */           tower.updateCustomButton(this.u, this.U); return;
/*      */         } 
/*      */       } else {
/*  691 */         this.t.setVisible(true);
/*  692 */         this.t.setStrategy(tower.aimStrategy, true, false);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void hideTowerExperience() {
/*  698 */     this.w.clearActions();
/*  699 */     this.w.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showTowerExperience(boolean paramBoolean, Runnable paramRunnable) {
/*  703 */     this.w.clearActions();
/*  704 */     this.w.setVisible(true);
/*  705 */     this.w.setTransform(false);
/*      */     
/*  707 */     if (paramBoolean) {
/*  708 */       this.ab._gameUi.uiElementsEmphasizer.show((Actor)this.w, b, Game.i.localeManager.i18n
/*  709 */           .get("tower_menu_ui_experience_title"), Game.i.localeManager.i18n
/*  710 */           .get("tower_menu_ui_experience_description"), paramRunnable); return;
/*      */     } 
/*  712 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void hideTowerAbilities() {
/*  717 */     this.x.clearActions();
/*  718 */     this.x.setVisible(false);
/*      */   }
/*      */   
/*      */   public void showTowerAbilities(boolean paramBoolean, Runnable paramRunnable) {
/*  722 */     this.x.clearActions();
/*  723 */     this.x.setVisible(true);
/*  724 */     this.x.setTransform(false);
/*      */     
/*  726 */     if (paramBoolean) {
/*  727 */       this.ab._gameUi.uiElementsEmphasizer.show((Actor)this.x, c, Game.i.localeManager.i18n
/*  728 */           .get("tower_menu_ui_abilities_title"), Game.i.localeManager.i18n
/*  729 */           .get("tower_menu_ui_abilities_description"), paramRunnable); return;
/*      */     } 
/*  731 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public void draw(float paramFloat) {
/*  736 */     if (!isVisible()) {
/*      */       return;
/*      */     }
/*      */     Tower tower;
/*  740 */     if ((tower = c()) != null) {
/*  741 */       if (this.L != tower.getSellPrice()) {
/*  742 */         this.M = true;
/*      */ 
/*      */         
/*  745 */         if (Dialog.i().isVisible() && Dialog.i().getLastConfirmId().equals("sellButton")) {
/*  746 */           Dialog.i().hide();
/*      */         }
/*      */       } 
/*  749 */       this.f.setEnabled(!tower.outOfOrder.hasReason("ManuallyDisabled"));
/*      */       
/*  751 */       this.Q += paramFloat;
/*  752 */       if (this.Q > 0.5F) {
/*  753 */         this.Q = 0.0F;
/*  754 */         this.O = true;
/*      */       } 
/*      */ 
/*      */       
/*  758 */       short s = this.ab.map.getDirtyTileGeneration((Tile)tower.getTile());
/*  759 */       if (this.S != s) {
/*  760 */         this.M = true;
/*  761 */         this.S = s;
/*      */       } 
/*  763 */       if (this.T != tower.loopAbilityDamageBuffer) {
/*  764 */         this.T = tower.loopAbilityDamageBuffer;
/*  765 */         this.M = true;
/*      */       } 
/*      */     } 
/*      */     
/*  769 */     if (this.M) {
/*  770 */       h();
/*      */     }
/*  772 */     if (this.V != this.ab.gameState.isDoubleSpeedActive()) {
/*  773 */       this.V = !this.V;
/*  774 */       this.N = true;
/*      */     } 
/*  776 */     if (this.N) {
/*  777 */       g();
/*      */     }
/*  779 */     if (this.O) {
/*  780 */       f();
/*      */     }
/*  782 */     if (tower != null) {
/*  783 */       tower.fillTowerMenu(this.X, this.W);
/*      */     }
/*      */   }
/*      */   
/*      */   private void f() {
/*      */     Tower tower;
/*  789 */     if (this.z.isVisible() && (
/*      */       
/*  791 */       tower = c()) != null && (this.H != tower.mdps || this.I != tower.enemiesKilled || this.K != tower.damageGiven || this.J != (int)tower.bonusCoinsBrought)) {
/*  792 */       this.H = tower.mdps;
/*  793 */       this.I = tower.enemiesKilled;
/*  794 */       this.J = (int)tower.bonusCoinsBrought;
/*  795 */       this.K = tower.damageGiven;
/*      */       
/*  797 */       this.A.setText((CharSequence)StringFormatter.compactNumber(tower.mdps, false));
/*  798 */       this.F.setText((CharSequence)StringFormatter.compactNumber(tower.damageGiven, false));
/*      */       
/*  800 */       if (this.J == 0.0F) {
/*  801 */         this.D.setVisible(false);
/*  802 */         this.C.setVisible(false);
/*      */       } else {
/*  804 */         ac.setLength(0);
/*  805 */         if (tower.bonusCoinsBrought > 0.0F) {
/*  806 */           ac.append('+').append(StringFormatter.compactNumber((int)tower.bonusCoinsBrought, false));
/*      */         } else {
/*  808 */           ac.append(StringFormatter.compactNumber((int)tower.bonusCoinsBrought, false));
/*      */         } 
/*  810 */         this.D.setText((CharSequence)ac);
/*      */         
/*  812 */         this.D.setVisible(true);
/*  813 */         this.C.setVisible(true);
/*      */       } 
/*  815 */       this.B.setText((CharSequence)StringFormatter.compactNumber(tower.enemiesKilled, false));
/*      */     } 
/*      */ 
/*      */     
/*  819 */     this.O = false;
/*      */   }
/*      */   
/*      */   private void g() {
/*      */     Tower tower;
/*  824 */     if ((tower = c()) != null) {
/*      */       
/*  826 */       ac.setLength(0);
/*  827 */       ac.append('L').append(tower.getLevel());
/*  828 */       this.h.setText((CharSequence)ac);
/*      */ 
/*      */       
/*  831 */       if (tower.nextLevelExperience == 0.0F) {
/*  832 */         this.o.setCoeff(1.0F);
/*      */       } else {
/*  834 */         this.o.setCoeff(tower.currentLevelExperience / tower.nextLevelExperience);
/*      */       } 
/*      */ 
/*      */       
/*  838 */       ac.setLength(0);
/*  839 */       if (tower.nextLevelExperience != 0.0F) {
/*  840 */         ac.append((int)tower.currentLevelExperience).append(" / ").append((int)tower.nextLevelExperience).append(" XP");
/*  841 */         this.k.setText((CharSequence)ac);
/*      */         
/*  843 */         this.i.setVisible(false);
/*  844 */         this.j.setVisible(false);
/*      */       } else {
/*  846 */         this.k.setText("MAX XP");
/*      */         
/*  848 */         ac.setLength(0);
/*  849 */         ac.append("+");
/*      */         long l;
/*  851 */         if ((l = ((int)tower.experience - Tower.LEVEL_EXPERIENCE_MILESTONES[tower.getLevel()])) > 1000000000L) {
/*  852 */           ac.append("bazillion");
/*      */         } else {
/*  854 */           ac.append(StringFormatter.commaSeparatedNumber(l));
/*      */         } 
/*  856 */         this.i.setText((CharSequence)ac);
/*  857 */         this.j.setText((CharSequence)ac);
/*      */         
/*  859 */         this.i.setVisible(true);
/*  860 */         this.j.setVisible(true);
/*      */       } 
/*      */ 
/*      */       
/*  864 */       if (tower.experienceGeneration == 0.0F) {
/*  865 */         this.l.setVisible(false);
/*      */       } else {
/*  867 */         ac.setLength(0);
/*  868 */         ac.append('+');
/*  869 */         ac.append(StringFormatter.compactNumber(tower.experienceGeneration, true));
/*  870 */         if (this.ab.gameState.isDoubleSpeedActive()) {
/*  871 */           ac.append(" [#BBBBBB]x2[]");
/*      */         }
/*  873 */         ac.append(" XP/s");
/*  874 */         this.l.setText((CharSequence)ac);
/*  875 */         this.l.setVisible(true);
/*      */       } 
/*      */     } 
/*      */     
/*  879 */     this.N = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void h() {
/*  886 */     this.W.clear();
/*  887 */     this.X.clearChildren();
/*  888 */     this.G.clear();
/*      */     
/*      */     Tower tower;
/*  891 */     if ((tower = c()) != null) {
/*  892 */       this.e.setLabelOverTitleTilePos(this.ab._gameMapSelection.getSelectedTile());
/*      */       
/*  894 */       Tower.Factory factory = Game.i.towerManager.getFactory(tower.type);
/*  895 */       PlatformTile platformTile = tower.getTile();
/*      */       
/*  897 */       TowerStatType[] arrayOfTowerStatType1 = Game.i.towerManager.getStatTypes(tower.type);
/*      */       
/*  899 */       float f1 = tower.getRange();
/*  900 */       float f2 = tower.getMinRange();
/*  901 */       float f3 = tower.getPowerCombinedMultiplier();
/*  902 */       float[] arrayOfFloat = new float[arrayOfTowerStatType1.length];
/*  903 */       int j = 0; TowerStatType[] arrayOfTowerStatType2; int m; byte b1;
/*  904 */       for (m = (arrayOfTowerStatType2 = arrayOfTowerStatType1).length, b1 = 0; b1 < m; ) { TowerStatType towerStatType = arrayOfTowerStatType2[b1];
/*  905 */         arrayOfFloat[j++] = tower.getStat(towerStatType);
/*      */         
/*      */         b1++; }
/*      */       
/*  909 */       if (tower.affectedByLoopAbility != null) {
/*  910 */         Table table = new Table();
/*  911 */         this.G.add((Actor)table).padRight(15.0F);
/*      */         
/*      */         Image image1;
/*  914 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-loop"))).setColor(MaterialColor.GREEN.P500);
/*  915 */         table.add((Actor)image1).size(24.0F).padRight(6.0F);
/*      */         
/*      */         Label label;
/*  918 */         (label = new Label((CharSequence)StringFormatter.compactNumber(tower.loopAbilityDamageBuffer, false), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.GREEN.P500);
/*  919 */         table.add((Actor)label);
/*      */         
/*      */         Image image2;
/*  922 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  923 */         table.add((Actor)image2).size(24.0F).padLeft(6.0F);
/*  924 */         table.setTouchable(Touchable.enabled);
/*  925 */         table.addListener((EventListener)new ClickListener(this)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  928 */                 TooltipsOverlay.i().showText("loop_ability_tower_menu_hint", (Actor)TowerMenu.d(this.a), Game.i.localeManager.i18n.get("loop_ability_tower_menu_hint"), UiManager.MainUiLayer.SCREEN, 106, 4);
/*      */               }
/*      */             });
/*      */       } 
/*  932 */       this.G.add().height(1.0F).growX();
/*      */ 
/*      */       
/*  935 */       this.f.setText((CharSequence)StringFormatter.toUpperCase(factory.getTitle()));
/*  936 */       this.f.setEnabled(!tower.outOfOrder.hasReason("ManuallyDisabled"));
/*  937 */       this.f.toggleImage.setVisible(this.ab.tower.canTowersBeManuallyDisabled());
/*  938 */       if (this.g != null) {
/*  939 */         this.g.setVisible(this.ab.tower.canTowersBeManuallyDisabled());
/*      */       }
/*  941 */       g();
/*      */ 
/*      */       
/*  944 */       this.m.clearChildren();
/*  945 */       if (platformTile.bonusType != null && platformTile.bonusLevel > 0) {
/*      */         EffectTooltip effectTooltip;
/*  947 */         (effectTooltip = new EffectTooltip((Drawable)Game.i.assetManager.getDrawable(SpaceTileBonus.getIconName(platformTile.bonusType)), (CharSequence)SpaceTileBonus.getDetailedName(platformTile.bonusType, platformTile.bonusLevel))).setHint(Game.i.localeManager.i18n.get("tile_effect"));
/*  948 */         effectTooltip.setColor(SpaceTileBonus.getBrightColor(platformTile.bonusType));
/*  949 */         this.m.add((Actor)effectTooltip);
/*      */         
/*  951 */         this.n.setVisible(false);
/*      */       } else {
/*  953 */         this.n.setVisible(true);
/*      */       } 
/*      */ 
/*      */       
/*  957 */       j = 0;
/*  958 */       for (m = (arrayOfTowerStatType2 = arrayOfTowerStatType1).length, b1 = 0; b1 < m; ) { TowerStatType towerStatType = arrayOfTowerStatType2[b1];
/*      */         TowerStatManager.TowerStat towerStat;
/*  960 */         if ((towerStat = Game.i.towerStatManager.getInstance(towerStatType)).isVisible()) {
/*  961 */           this.q[j].a(tower.type, towerStatType, tower.getStat(towerStatType));
/*  962 */           this.q[j].setVisible(true);
/*  963 */           j++;
/*      */         }  b1++; }
/*      */       
/*      */       int k;
/*  967 */       for (k = j; k < 8; k++) {
/*  968 */         this.q[k].setVisible(false);
/*      */       }
/*      */       
/*  971 */       k = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*  972 */       if (this.Z != null) {
/*  973 */         this.Z.remove();
/*  974 */         this.Z = null;
/*      */       } 
/*      */ 
/*      */       
/*  978 */       if (k > 100) {
/*  979 */         float f = 725.0F - ((j + 1) / 2) * 68.0F + k - 32.0F - 20.0F;
/*      */         
/*  981 */         this.Z = new Group();
/*  982 */         this.Z.setTransform(false);
/*  983 */         this.Z.setPosition(0.0F, f);
/*  984 */         this.Z.setSize(600.0F, 100.0F);
/*  985 */         this.e.addActor((Actor)this.Z);
/*      */         
/*      */         Table table;
/*  988 */         (table = new Table()).setSize(600.0F, 100.0F);
/*  989 */         this.Z.addActor((Actor)table);
/*      */         EnemyType[] arrayOfEnemyType;
/*  991 */         for (int i2 = (arrayOfEnemyType = EnemyType.mainEnemyTypes).length; k < i2; ) { EnemyType enemyType = arrayOfEnemyType[k];
/*      */           Group group;
/*  993 */           (group = new Group()).setTransform(false);
/*  994 */           table.add((Actor)group).size(42.0F, 100.0F);
/*      */           
/*      */           Image image;
/*  997 */           (image = new Image(this.ab.enemy.getTexture(enemyType))).setPosition(5.0F, 47.0F);
/*  998 */           image.setSize(32.0F, 32.0F);
/*  999 */           group.addActor((Actor)image);
/*      */           
/*      */           float f4;
/*      */           
/* 1003 */           int i3 = MathUtils.round((f4 = this.ab.tower.towerEnemyDamageMultiplier[enemyType.ordinal()][tower.type.ordinal()]) * 100.0F);
/* 1004 */           ac.setLength(0);
/* 1005 */           ac.append(i3);
/*      */           
/*      */           Label label;
/* 1008 */           (label = new Label((CharSequence)ac, Game.i.assetManager.getLabelStyle(18))).setAlignment(1);
/* 1009 */           label.setSize(42.0F, 24.0F);
/* 1010 */           label.setPosition(0.0F, 12.0F);
/* 1011 */           group.addActor((Actor)label);
/*      */           
/* 1013 */           if (i3 <= 0) {
/* 1014 */             label.setColor(MaterialColor.RED.P500);
/* 1015 */           } else if (i3 < 100) {
/* 1016 */             label.setColor(MaterialColor.ORANGE.P600);
/* 1017 */           } else if (i3 > 100) {
/* 1018 */             label.setColor(MaterialColor.GREEN.P500);
/*      */           } else {
/* 1020 */             label.setColor(MaterialColor.YELLOW.P500);
/*      */           } 
/*      */           
/*      */           k++; }
/*      */       
/*      */       } 
/* 1026 */       Tower.AbilityConfig[] arrayOfAbilityConfig = factory.getAbilityConfigs(this.ab, tower);
/* 1027 */       for (b1 = 0; b1 < 6; b1++) {
/*      */         TowerAbilityButton towerAbilityButton;
/*      */         
/* 1030 */         (towerAbilityButton = this.r[b1]).b(tower.isAbilityInstalled(b1));
/* 1031 */         towerAbilityButton.a((Drawable)factory.getShadowTextures(), (Drawable)factory.getBaseTextures(), (Drawable)factory.getAbilityTextures(b1));
/*      */         
/* 1033 */         if (b1 != 3) {
/*      */           
/* 1035 */           towerAbilityButton.a(tower.canAbilityBeInstalled(b1));
/*      */         } else {
/*      */           
/* 1038 */           towerAbilityButton.a(false);
/*      */         } 
/*      */       } 
/*      */       
/* 1042 */       for (b1 = 0; b1 < 6; b1++) {
/* 1043 */         this.r[b1].setSelected(false);
/*      */       }
/*      */ 
/*      */       
/* 1047 */       this.y.clear();
/*      */       
/* 1049 */       Array array = new Array();
/* 1050 */       int n = this.ab.tower.towerAbilityIdxToCategory[0];
/* 1051 */       int i = 0;
/* 1052 */       for (k = 1; k < 6; k++) {
/*      */         int i2;
/* 1054 */         if ((i2 = this.ab.tower.towerAbilityIdxToCategory[k]) != n) {
/*      */           
/* 1056 */           array.add(new IntPair(i, k - 1));
/* 1057 */           n = i2;
/* 1058 */           i = k;
/*      */         } 
/*      */       } 
/* 1061 */       array.add(new IntPair(i, 5));
/* 1062 */       for (Array.ArrayIterator<IntPair> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) {
/* 1063 */         IntPair intPair; int i2 = (intPair = arrayIterator.next()).a;
/* 1064 */         int i3 = intPair.b;
/* 1065 */         int i4 = this.ab.tower.towerAbilityIdxToCategory[i2];
/* 1066 */         TowerSystem.TowerAbilityCategoryRule towerAbilityCategoryRule = this.ab.tower.towerAbilityCategoryRules[i4];
/*      */         
/* 1068 */         float f5 = (i2 * 88);
/* 1069 */         float f4 = ((i3 - i2 + 1) * 80 + (i3 - i2 << 3));
/*      */         Image image;
/* 1071 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(f4, 4.0F);
/* 1072 */         image.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1073 */         image.setPosition(f5, 26.0F);
/* 1074 */         this.y.addActor((Actor)image);
/*      */         
/* 1076 */         ac.setLength(0);
/* 1077 */         for (byte b3 = 0; b3 < towerAbilityCategoryRule.requiredXpLevels.size; b3++) {
/* 1078 */           j = towerAbilityCategoryRule.requiredXpLevels.get(b3);
/* 1079 */           if (ac.length != 0) {
/* 1080 */             ac.append(" / ");
/*      */           }
/* 1082 */           ac.append('L').append(j);
/*      */         } 
/*      */         
/*      */         Label label;
/* 1086 */         (label = new Label((CharSequence)ac, Game.i.assetManager.getLabelStyle(24))).setSize(f4, 17.0F);
/* 1087 */         label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1088 */         label.setAlignment(1);
/* 1089 */         label.setPosition(f5, 0.0F);
/* 1090 */         this.y.addActor((Actor)label);
/*      */       } 
/*      */ 
/*      */       
/* 1094 */       if (this.P != -1) {
/* 1095 */         ac.setLength(0);
/* 1096 */         ac.append("[#FFC107]").append(arrayOfAbilityConfig[this.P].getName()).append("[]\n");
/* 1097 */         ac.append(arrayOfAbilityConfig[this.P].getDescription());
/* 1098 */         if (this.P == 3) {
/* 1099 */           ac.append("\n").append("[#FFC107]").append(Game.i.localeManager.i18n.format("unlocks_at_lvl", new Object[] { Integer.valueOf(10) })).append("[]");
/*      */         }
/*      */         
/* 1102 */         this.d.showSideTooltip((CharSequence)ac, this.x.getY() + this.r[this.P].getY() + this.r[this.P].getHeight() * 0.5F);
/* 1103 */         this.r[this.P].setSelected(true);
/*      */       } else {
/* 1105 */         this.d.hideSideTooltip();
/*      */       } 
/*      */ 
/*      */       
/* 1109 */       if (this.P != -1 && !tower.isAbilityInstalled(this.P)) {
/* 1110 */         tower.installedAbilities[this.P] = true;
/* 1111 */         tower.updateCache();
/*      */         
/* 1113 */         f1 = tower.getRange();
/* 1114 */         f2 = tower.getMinRange();
/* 1115 */         f3 = tower.getPowerCombinedMultiplier();
/* 1116 */         j = 0; TowerStatType[] arrayOfTowerStatType; int i2; byte b3;
/* 1117 */         for (i2 = (arrayOfTowerStatType = arrayOfTowerStatType1).length, b3 = 0; b3 < i2; ) { TowerStatType towerStatType = arrayOfTowerStatType[b3];
/* 1118 */           arrayOfFloat[j++] = tower.getStat(towerStatType);
/*      */           b3++; }
/*      */         
/* 1121 */         tower.installedAbilities[this.P] = false;
/* 1122 */         tower.updateCache();
/*      */       } 
/*      */ 
/*      */       
/* 1126 */       byte b = tower.getMaxUpgradeLevel();
/* 1127 */       this.s.a(tower.getUpgradeLevel(), b);
/* 1128 */       if (tower.getUpgradeLevel() < b) {
/*      */         
/* 1130 */         int i2 = this.ab.tower.getUpgradePrice(tower);
/* 1131 */         this.s.a(i2);
/*      */       } else {
/*      */         
/* 1134 */         this.s.a(-1);
/*      */       } 
/*      */       
/* 1137 */       if (this.s.isButtonSelected() && tower.getUpgradeLevel() < tower.getMaxUpgradeLevel()) {
/*      */         
/* 1139 */         byte b3 = tower.getUpgradeLevel();
/* 1140 */         tower.setUpgradeLevel((byte)(b3 + 1));
/* 1141 */         tower.updateCache();
/*      */         
/* 1143 */         f1 = tower.getRange();
/* 1144 */         f2 = tower.getMinRange();
/* 1145 */         f3 = tower.getPowerCombinedMultiplier();
/* 1146 */         j = 0; TowerStatType[] arrayOfTowerStatType; int i2; byte b4;
/* 1147 */         for (i2 = (arrayOfTowerStatType = arrayOfTowerStatType1).length, b4 = 0; b4 < i2; ) { TowerStatType towerStatType = arrayOfTowerStatType[b4];
/* 1148 */           arrayOfFloat[j++] = tower.getStat(towerStatType);
/*      */           b4++; }
/*      */         
/* 1151 */         tower.setUpgradeLevel(b3);
/* 1152 */         tower.updateCache();
/*      */       } else {
/*      */         CharacteristicCell[] arrayOfCharacteristicCell; int i2; byte b3;
/* 1155 */         for (i2 = (arrayOfCharacteristicCell = this.q).length, b3 = 0; b3 < i2; b3++) {
/* 1156 */           CharacteristicCell characteristicCell; (characteristicCell = arrayOfCharacteristicCell[b3]).d();
/*      */         } 
/*      */       } 
/*      */       
/* 1160 */       d();
/*      */ 
/*      */       
/* 1163 */       if (tower.getPowerCombinedMultiplier() != f3) {
/*      */         
/* 1165 */         ac.setLength(0);
/* 1166 */         ac.append("+").append(
/* 1167 */             StringFormatter.compactNumberWithPrecisionTrimZeros(((tower.getPowerCombinedMultiplier() - 1.0F) * 100.0F), 1, false))
/* 1168 */           .append("[#4CAF50] +").append(
/* 1169 */             StringFormatter.compactNumberWithPrecisionTrimZeros(((f3 - tower.getPowerCombinedMultiplier()) * 100.0F), 1, false))
/* 1170 */           .append("[]%");
/*      */         
/* 1172 */         this.p.setText((CharSequence)ac);
/*      */       } else {
/*      */         
/* 1175 */         ac.setLength(0);
/* 1176 */         ac.append("+").append(StringFormatter.compactNumberWithPrecisionTrimZeros(((tower.getPowerCombinedMultiplier() - 1.0F) * 100.0F), 1, false)).append("%");
/* 1177 */         this.p.setText((CharSequence)ac);
/*      */       } 
/* 1179 */       j = 0; TowerStatType[] arrayOfTowerStatType3; int i1; byte b2;
/* 1180 */       for (i1 = (arrayOfTowerStatType3 = arrayOfTowerStatType1).length, b2 = 0; b2 < i1; ) { TowerStatType towerStatType = arrayOfTowerStatType3[b2]; byte b3; CharacteristicCell[] arrayOfCharacteristicCell; int i2;
/* 1181 */         for (i2 = (arrayOfCharacteristicCell = this.q).length, b3 = 0; b3 < i2; b3++) {
/* 1182 */           CharacteristicCell characteristicCell; if (CharacteristicCell.a(characteristicCell = arrayOfCharacteristicCell[b3]) == towerStatType) {
/* 1183 */             if (arrayOfFloat[j] != tower.getStat(towerStatType)) {
/*      */               
/* 1185 */               characteristicCell.a(arrayOfFloat[j]);
/*      */             } else {
/* 1187 */               characteristicCell.d();
/*      */             } 
/*      */           }
/*      */         } 
/* 1191 */         j++;
/*      */         b2++; }
/*      */       
/* 1194 */       if (f1 != tower.getRange() || f2 != tower.getMinRange()) {
/* 1195 */         this.ab.map.showTowerRangeHint((tower.getTile()).center.x, (tower.getTile()).center.y, f2 * 128.0F, f1 * 128.0F);
/*      */       } else {
/* 1197 */         this.ab.map.hideTowerRangeHint();
/*      */       } 
/*      */ 
/*      */       
/* 1201 */       e();
/*      */ 
/*      */       
/* 1204 */       if (tower.isSellFullRefundStillActive()) {
/* 1205 */         this.v.setColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700);
/*      */       } else {
/* 1207 */         this.v.setColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700);
/*      */       } 
/* 1209 */       this.v.setPrice(tower.getSellPrice());
/* 1210 */       this.L = tower.getSellPrice();
/*      */       
/* 1212 */       f();
/*      */     } 
/*      */     
/* 1215 */     this.M = false;
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1219 */     if (this.R != paramBoolean) {
/* 1220 */       this.R = paramBoolean;
/* 1221 */       if (paramBoolean) {
/* 1222 */         this.e.show();
/* 1223 */         this.M = true;
/*      */         
/* 1225 */         this.z.setVisible(true); return;
/*      */       } 
/* 1227 */       this.e.hide();
/* 1228 */       this.s.setButtonSelected(false);
/* 1229 */       this.d.hideSideTooltip();
/* 1230 */       a(-1);
/* 1231 */       this.ab.map.hideTowerRangeHint();
/* 1232 */       this.W.clear();
/*      */       
/* 1234 */       if (this.U) {
/* 1235 */         cancelUsingCustomButton();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class _SideMenuListener
/*      */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter
/*      */   {
/*      */     private _SideMenuListener(TowerMenu this$0) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void offscreenChanged() {
/* 1256 */       if (TowerMenu.e(this.a).isOffscreen()) {
/* 1257 */         TowerMenu.a(this.a, -1);
/*      */       }
/* 1259 */       TowerMenu.a(this.a, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public void sideTooltipHidden() {
/* 1264 */       TowerMenu.b(this.a, -1);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class CharacteristicCell
/*      */     extends Group
/*      */   {
/*      */     private final Image l;
/*      */     
/*      */     private final Image m;
/*      */     
/*      */     private final Image n;
/*      */     
/*      */     private final Label o;
/*      */     
/*      */     private final Label p;
/*      */     private final Label q;
/*      */     private final Label r;
/*      */     private final Image s;
/*      */     private TowerStatType t;
/*      */     private float u;
/*      */     private float v;
/*      */     private final GlyphLayout w;
/*      */     
/* 1289 */     private final ClickListener x = new ClickListener(this)
/*      */       {
/*      */         public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1292 */           super.enter(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*      */           
/* 1294 */           if (isOver()) {
/* 1295 */             if (TowerMenu.CharacteristicCell.a(this.a) == null)
/* 1296 */               return;  TowerStatManager.TowerStat towerStat = Game.i.towerStatManager.getInstance(TowerMenu.CharacteristicCell.a(this.a));
/*      */             
/*      */             StringBuilder stringBuilder;
/* 1299 */             (stringBuilder = new StringBuilder()).append("[#4DB6AC]");
/* 1300 */             stringBuilder.append(towerStat.getName());
/* 1301 */             stringBuilder.append("[]");
/*      */ 
/*      */ 
/*      */             
/* 1305 */             TowerType towerType = tower.type; Tower tower;
/*      */             CharSequence charSequence;
/* 1307 */             if ((tower = TowerMenu.a(this.a.k)) != null && (charSequence = Game.i.towerManager.getFactory(towerType).getStatMoreInfo(TowerMenu.CharacteristicCell.a(this.a), (GameValueProvider)(TowerMenu.f(this.a.k)).gameValue, tower)) != null) {
/* 1308 */               stringBuilder.append("\n");
/* 1309 */               stringBuilder.append(charSequence);
/*      */             } 
/*      */             
/* 1312 */             TowerMenu.e(this.a.k).showSideTooltip((CharSequence)stringBuilder, this.a.getY() + this.a.getHeight() * 0.5F);
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1318 */           super.exit(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*      */           
/* 1320 */           TowerMenu.e(this.a.k).hideSideTooltip();
/*      */         }
/*      */       };
/*      */     
/*      */     CharacteristicCell(TowerMenu this$0) {
/* 1325 */       setSize(258.0F, 64.0F);
/* 1326 */       setTransform(false);
/* 1327 */       setTouchable(Touchable.enabled);
/*      */       
/*      */       Image image;
/* 1330 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(258.0F, 64.0F);
/* 1331 */       image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 1332 */       addActor((Actor)image);
/*      */       
/* 1334 */       this.l = new Image((Drawable)Game.i.assetManager.getDrawable("tower-menu-stat-line"));
/* 1335 */       this.l.setHeight(64.0F);
/* 1336 */       addActor((Actor)this.l);
/*      */       
/* 1338 */       this.m = new Image((Drawable)Game.i.assetManager.getDrawable("tower-menu-stat-line"));
/* 1339 */       this.m.setHeight(64.0F);
/* 1340 */       this.m.setVisible(false);
/* 1341 */       this.m.setColor(Color.WHITE);
/* 1342 */       addActor((Actor)this.m);
/*      */       
/* 1344 */       this.n = new Image();
/* 1345 */       this.n.setSize(48.0F, 48.0F);
/* 1346 */       this.n.setPosition(8.0F, 8.0F);
/* 1347 */       addActor((Actor)this.n);
/*      */       
/* 1349 */       this.w = new GlyphLayout((BitmapFont)Game.i.assetManager.getFont(21), "", Color.WHITE, 120.0F, 8, true);
/*      */       
/* 1351 */       this.o = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 1352 */       this.o.setPosition(64.0F, 0.0F);
/* 1353 */       this.o.setSize(120.0F, 64.0F);
/* 1354 */       this.o.setWrap(true);
/* 1355 */       addActor((Actor)this.o);
/*      */       
/* 1357 */       this.s = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"));
/* 1358 */       this.s.setSize(20.0F, 20.0F);
/* 1359 */       this.s.setColor(MaterialColor.TEAL.P500);
/* 1360 */       this.s.setPosition(-10.0F, 24.0F);
/* 1361 */       this.s.setVisible(false);
/* 1362 */       addActor((Actor)this.s);
/*      */       
/* 1364 */       this.p = new Label("1.23", Game.i.assetManager.getLabelStyle(24));
/* 1365 */       this.p.setPosition(194.0F, 0.0F);
/* 1366 */       this.p.setSize(48.0F, 64.0F);
/* 1367 */       this.p.setAlignment(16);
/* 1368 */       addActor((Actor)this.p);
/*      */       
/* 1370 */       this.q = new Label("tiles/s", Game.i.assetManager.getLabelStyle(18));
/* 1371 */       this.q.setPosition(194.0F, 3.0F);
/* 1372 */       this.q.setSize(48.0F, 16.0F);
/* 1373 */       this.q.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1374 */       this.q.setAlignment(16);
/* 1375 */       addActor((Actor)this.q);
/*      */       
/* 1377 */       this.r = new Label("+1.12", Game.i.assetManager.getLabelStyle(21));
/* 1378 */       this.r.setPosition(194.0F, 32.0F);
/* 1379 */       this.r.setSize(48.0F, 32.0F);
/* 1380 */       this.r.setAlignment(16);
/* 1381 */       this.r.setVisible(false);
/* 1382 */       addActor((Actor)this.r);
/*      */     }
/*      */     
/*      */     final void a(TowerType param1TowerType, TowerStatType param1TowerStatType, float param1Float) {
/* 1386 */       this.t = param1TowerStatType;
/* 1387 */       this.u = param1Float;
/*      */       
/* 1389 */       TowerManager.TowerStatConfig towerStatConfig = Game.i.towerManager.getStatConfig(param1TowerType, param1TowerStatType);
/* 1390 */       TowerStatManager.TowerStat towerStat = Game.i.towerStatManager.getInstance(param1TowerStatType);
/*      */       
/* 1392 */       this.n.setDrawable((Drawable)Game.i.assetManager.getDrawable(towerStat.getIconDrawableAlias()));
/* 1393 */       String str = towerStat.getName();
/* 1394 */       this.w.setText((BitmapFont)Game.i.assetManager.getFont(21), str, Color.WHITE, 120.0F, 8, true);
/*      */       
/* 1396 */       clearListeners();
/*      */       
/* 1398 */       boolean bool = false;
/* 1399 */       if (this.w.height > 60.0F) {
/*      */         
/* 1401 */         TowerMenu.b().setLength(0);
/* 1402 */         TowerMenu.b().append(str).append("...");
/* 1403 */         while (this.w.height > 60.0F) {
/* 1404 */           TowerMenu.b().setLength((TowerMenu.b()).length - 5);
/* 1405 */           TowerMenu.b().append("...");
/* 1406 */           this.w.setText((BitmapFont)Game.i.assetManager.getFont(21), (CharSequence)TowerMenu.b(), Color.WHITE, 120.0F, 8, true);
/*      */         } 
/* 1408 */         this.o.setText((CharSequence)TowerMenu.b());
/* 1409 */         bool = true;
/*      */       } else {
/* 1411 */         this.o.setText(str);
/*      */       } 
/*      */       CharSequence charSequence;
/*      */       Tower tower;
/* 1415 */       if ((tower = TowerMenu.a(this.k)) != null && (
/*      */         
/* 1417 */         charSequence = Game.i.towerManager.getFactory(param1TowerType).getStatMoreInfo(this.t, (GameValueProvider)(TowerMenu.f(this.k)).gameValue, tower)) != null) {
/* 1418 */         bool = true;
/*      */       }
/*      */ 
/*      */       
/* 1422 */       if (bool) {
/* 1423 */         this.s.setVisible(true);
/* 1424 */         addListener((EventListener)this.x);
/*      */       } else {
/* 1426 */         this.s.setVisible(false);
/*      */       } 
/*      */       
/* 1429 */       if (towerStatConfig.rounding == 0) {
/* 1430 */         this.p.setText((CharSequence)StringFormatter.compactNumber(param1Float, true));
/*      */       } else {
/* 1432 */         this.p.setText((CharSequence)StringFormatter.compactNumber(param1Float, false));
/*      */       } 
/* 1434 */       if (towerStat.unitsAlias != null) {
/* 1435 */         this.q.setText(Game.i.localeManager.i18n.get(towerStat.unitsAlias));
/* 1436 */         this.q.setVisible(true);
/*      */       } else {
/* 1438 */         this.q.setText("");
/*      */       } 
/*      */       
/* 1441 */       if (!towerStatConfig.unique) {
/* 1442 */         this.n.setColor(Color.WHITE);
/* 1443 */         this.o.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */       } else {
/* 1445 */         this.n.setColor(MaterialColor.AMBER.P600);
/* 1446 */         this.o.setColor(MaterialColor.AMBER.P600);
/*      */       } 
/* 1448 */       this.p.setColor(Color.WHITE);
/*      */       
/* 1450 */       this.l.setColor(towerStat.getColor());
/*      */       float f;
/* 1452 */       if ((f = Game.i.towerManager.getStatBarCoeff(param1TowerStatType, param1Float, (TowerMenu.f(this.k)).tower.getMaxPossibleStat(param1TowerStatType)) * 258.0F) > 258.0F) f = 258.0F; 
/* 1453 */       this.l.setWidth(f);
/*      */     }
/*      */     
/*      */     final void a(float param1Float) {
/* 1457 */       if (param1Float == this.u) {
/* 1458 */         d();
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1463 */       this.v = param1Float;
/*      */       
/* 1465 */       float f = Game.i.towerManager.getStatBarCoeff(this.t, this.u, (TowerMenu.f(this.k)).tower.getMaxPossibleStat(this.t)) * 258.0F;
/*      */       
/* 1467 */       param1Float = (param1Float = Game.i.towerManager.getStatBarCoeff(this.t, param1Float, (TowerMenu.f(this.k)).tower.getMaxPossibleStat(this.t)) * 258.0F) - f;
/*      */       
/* 1469 */       if (f < 258.0F) {
/* 1470 */         if (f + param1Float > 258.0F) {
/* 1471 */           param1Float = 258.0F - f;
/*      */         }
/*      */         
/* 1474 */         this.m.clearActions();
/* 1475 */         this.m.setVisible(true);
/* 1476 */         this.m.addAction((Action)Actions.alpha(1.0F, 0.3F));
/* 1477 */         this.m.setPosition(f, 0.0F);
/* 1478 */         this.m.setWidth(param1Float);
/*      */       } else {
/* 1480 */         this.m.clearActions();
/* 1481 */         this.m.setVisible(false);
/*      */       } 
/*      */       
/* 1484 */       this.p.setY(-8.0F);
/* 1485 */       this.q.setVisible(false);
/* 1486 */       TowerMenu.b().setLength(0);
/* 1487 */       if (this.v > this.u) TowerMenu.b().append('+'); 
/* 1488 */       TowerMenu.b().append(StringFormatter.compactNumber((this.v - this.u), true));
/* 1489 */       this.r.setVisible(true);
/* 1490 */       this.r.setText((CharSequence)TowerMenu.b());
/* 1491 */       if (this.v < this.u) {
/* 1492 */         this.r.setColor(MaterialColor.RED.P500); return;
/*      */       } 
/* 1494 */       this.r.setColor(MaterialColor.GREEN.P500);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void d() {
/* 1500 */       this.m.clearActions();
/* 1501 */       this.m.addAction((Action)Actions.sequence(
/* 1502 */             (Action)Actions.alpha(0.0F, 0.3F), 
/* 1503 */             (Action)Actions.hide()));
/*      */ 
/*      */       
/* 1506 */       this.p.setY(0.0F);
/* 1507 */       this.q.setVisible(true);
/* 1508 */       this.r.setVisible(false);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\TowerMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */