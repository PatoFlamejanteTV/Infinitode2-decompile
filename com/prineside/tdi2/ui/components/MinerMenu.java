/*      */ package com.prineside.tdi2.ui.components;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Miner;
/*      */ import com.prineside.tdi2.Resource;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.events.game.CoinsChange;
/*      */ import com.prineside.tdi2.events.game.MapElementSelect;
/*      */ import com.prineside.tdi2.events.game.MinerMineItem;
/*      */ import com.prineside.tdi2.events.game.MinerPlace;
/*      */ import com.prineside.tdi2.events.game.MinerRemove;
/*      */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*      */ import com.prineside.tdi2.events.game.MinerUpgrade;
/*      */ import com.prineside.tdi2.events.game.NextWaveForce;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.modifiers.MiningSpeedModifier;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.ui.actors.ExpLine;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.SideMenu;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import java.util.Locale;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MinerMenu
/*      */   implements Disposable
/*      */ {
/*      */   private final SideMenu.SideMenuContainer a;
/*      */   private boolean b;
/*      */   private final Label c;
/*      */   private final Label d;
/*      */   private final ExpLine e;
/*      */   private final TileResources f;
/*      */   private final Group g;
/*      */   private final Image h;
/*      */   private final Image i;
/*      */   private final Label j;
/*      */   private final Label k;
/*      */   private final Label l;
/*      */   private final Label m;
/*      */   private final ScrollPane n;
/*      */   private final Table o;
/*   75 */   private final Group[] p = new Group[ResourceType.values.length];
/*   76 */   private final Image[] q = new Image[ResourceType.values.length];
/*   77 */   private final Label[] r = new Label[ResourceType.values.length];
/*   78 */   private final Image[] s = new Image[ResourceType.values.length];
/*   79 */   private final Label[] t = new Label[ResourceType.values.length];
/*   80 */   private final Label[] u = new Label[ResourceType.values.length];
/*   81 */   private final Label[] v = new Label[ResourceType.values.length];
/*      */   private final Label w;
/*      */   private final Label x;
/*      */   private final Label y;
/*   85 */   private final Array<Actor> z = new Array(true, 1, Actor.class);
/*      */   private final Image A;
/*      */   private final Label B;
/*   88 */   private final Array<Actor> C = new Array(true, 1, Actor.class);
/*      */   
/*      */   private final Image D;
/*      */   
/*      */   private final Image E;
/*      */   
/*      */   private final Image F;
/*      */   
/*      */   private final Image G;
/*      */   
/*      */   private final Image H;
/*      */   private final Label I;
/*      */   private final Label J;
/*      */   private final Label K;
/*      */   private final Label L;
/*      */   private Table M;
/*      */   private final Label N;
/*      */   private final Label O;
/*      */   private final UpgradeSubmenu P;
/*      */   private final SellButton Q;
/*      */   private final GameSystemProvider R;
/*  109 */   private final _SideMenuListener S = new _SideMenuListener((byte)0);
/*      */   
/*  111 */   private final Runnable T = this::d;
/*  112 */   private final Runnable U = this::c;
/*      */ 
/*      */   
/*  115 */   private static final StringBuilder W = new StringBuilder(); private final Runnable V = () -> {
/*      */       c();
/*      */       a(true);
/*  118 */     }; public MinerMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) { this.R = paramGameSystemProvider;
/*      */     
/*  120 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.S);
/*      */     
/*  122 */     paramGameSystemProvider.events.getListeners(MinerUpgrade.class).add(paramMinerUpgrade -> Game.i.uiManager.runOnStageActOnce(this.U));
/*  123 */     paramGameSystemProvider.events.getListeners(MinerMineItem.class).add(this::a).setDescription("MinerMenu - updates menu if currently selected");
/*  124 */     paramGameSystemProvider.events.getListeners(MinerResourceChange.class).add(this::a).setDescription("MinerMenu - updates menu if currently selected");
/*  125 */     paramGameSystemProvider.events.getListeners(NextWaveForce.class).add(this::a).setDescription("MinerMenu - updates menu if currently selected");
/*  126 */     paramGameSystemProvider.events.getListeners(CoinsChange.class).add(paramCoinsChange -> Game.i.uiManager.runOnStageActOnce(this.T));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  131 */     this.a = paramSideMenu.createContainer("MinerMenu");
/*  132 */     this.a.setName("miner_menu_container");
/*      */     
/*  134 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */     
/*  136 */     this.M = new Table();
/*  137 */     this.M.setSize(366.0F, 32.0F);
/*  138 */     this.M.setPosition(40.0F, 994.0F + i + 32.0F);
/*  139 */     this.a.addActor((Actor)this.M);
/*      */ 
/*      */     
/*  142 */     this.c = new Label("VCTR", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  143 */     this.c.setSize(520.0F, 26.0F);
/*  144 */     this.c.setPosition(40.0F, 994.0F + i);
/*  145 */     this.a.addActor((Actor)this.c);
/*      */ 
/*      */     
/*  148 */     this.e = new ExpLine();
/*  149 */     this.e.setPosition(40.0F, 954.0F + i);
/*  150 */     this.a.addActor((Actor)this.e);
/*      */     
/*      */     Image image2;
/*      */     
/*  154 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-exp-line-cap"))).setSize(72.0F, 48.0F);
/*  155 */     image2.setPosition(395.0F, 954.0F + i);
/*  156 */     image2.setColor(new Color(623191551));
/*  157 */     this.a.addActor((Actor)image2);
/*      */     
/*  159 */     this.h = new Image((Drawable)Game.i.assetManager.getDrawable("icon-tools"));
/*  160 */     this.h.setSize(32.0F, 32.0F);
/*  161 */     this.h.setPosition(415.0F, 962.0F + i);
/*  162 */     this.a.addActor((Actor)this.h);
/*      */     
/*  164 */     this.i = new Image((Drawable)Game.i.assetManager.getDrawable("resource-vector"));
/*  165 */     this.i.setSize(32.0F, 32.0F);
/*  166 */     this.i.setPosition(415.0F, 962.0F + i);
/*  167 */     this.a.addActor((Actor)this.i);
/*      */ 
/*      */     
/*  170 */     this.j = new Label(Game.i.localeManager.i18n.get("miner_menu_status_installing").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  171 */     this.j.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  172 */     this.j.setSize(159.0F, 16.0F);
/*  173 */     this.j.setPosition(233.0F, 985.0F + i);
/*  174 */     this.j.setAlignment(16);
/*  175 */     this.a.addActor((Actor)this.j);
/*      */     
/*  177 */     this.k = new Label(Game.i.localeManager.i18n.get("miner_menu_status_mining").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  178 */     this.k.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  179 */     this.k.setSize(159.0F, 16.0F);
/*  180 */     this.k.setPosition(233.0F, 985.0F + i);
/*  181 */     this.k.setAlignment(16);
/*  182 */     this.a.addActor((Actor)this.k);
/*      */     
/*  184 */     this.m = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(18), Color.WHITE));
/*  185 */     this.m.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  186 */     this.m.setSize(159.0F, 24.0F);
/*  187 */     this.m.setPosition(50.0F, 954.0F + i - 2.0F);
/*  188 */     this.m.setAlignment(8);
/*  189 */     this.a.addActor((Actor)this.m);
/*      */     
/*  191 */     this.l = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(18), Color.WHITE));
/*  192 */     this.l.setColor(Color.WHITE);
/*  193 */     this.l.setSize(159.0F, 24.0F);
/*  194 */     this.l.setPosition(48.0F, 954.0F + i);
/*  195 */     this.l.setAlignment(8);
/*  196 */     this.a.addActor((Actor)this.l);
/*      */ 
/*      */     
/*  199 */     this.d = new Label("99%", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  200 */     this.d.setAlignment(1);
/*  201 */     this.d.setSize(71.0F, 48.0F);
/*  202 */     this.d.setPosition(489.0F, 954.0F + i);
/*  203 */     this.a.addActor((Actor)this.d);
/*      */ 
/*      */     
/*  206 */     this.f = new TileResources(600.0F);
/*  207 */     this.f.setPosition(0.0F, 848.0F + i);
/*  208 */     this.a.addActor((Actor)this.f);
/*      */ 
/*      */     
/*  211 */     this.g = new Group();
/*  212 */     this.g.setTransform(false);
/*  213 */     this.g.setPosition(0.0F, 802.0F + i);
/*  214 */     this.g.setSize(600.0F, 40.0F);
/*  215 */     this.g.setVisible(false);
/*  216 */     this.g.setTouchable(Touchable.enabled);
/*  217 */     this.a.addActor((Actor)this.g);
/*      */ 
/*      */     
/*  220 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-horizontal"))).setColor(MaterialColor.ORANGE.P300.cpy().mul(1.0F, 1.0F, 1.0F, 0.07F));
/*  221 */     image2.setSize(600.0F, 40.0F);
/*  222 */     this.g.addActor((Actor)image2);
/*      */     
/*      */     Table table1;
/*  225 */     (table1 = new Table()).setSize(600.0F, 40.0F);
/*  226 */     this.g.addActor((Actor)table1);
/*      */     
/*      */     Image image4;
/*  229 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-pickaxe"))).setColor(MaterialColor.ORANGE.P300);
/*  230 */     table1.add((Actor)image4).size(32.0F).padRight(8.0F);
/*      */     
/*      */     Label label3;
/*  233 */     (label3 = new Label(Game.i.localeManager.i18n.get("source_tile_depleted"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.ORANGE.P300);
/*  234 */     table1.add((Actor)label3);
/*      */     
/*      */     Image image3;
/*  237 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  238 */     table1.add((Actor)image3).size(24.0F).padLeft(8.0F);
/*      */     
/*  240 */     this.g.addListener((EventListener)new ClickListener(this, image3, paramSideMenu)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  243 */             TooltipsOverlay.i().showText("_generic_", (Actor)this.a, Game.i.localeManager.i18n.get("source_tile_depleted_description"), this.b.uiLayer.mainUiLayer, this.b.uiLayer.zIndex + 1, 4);
/*      */           }
/*      */         });
/*      */     
/*      */     Group group;
/*  248 */     (group = new Group()).setTransform(false);
/*  249 */     group.setSize(600.0F, 531.0F);
/*  250 */     group.setPosition(0.0F, (i + 271));
/*  251 */     this.a.addActor((Actor)group);
/*      */ 
/*      */ 
/*      */     
/*  255 */     Label.LabelStyle labelStyle1 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), new Color(1.0F, 1.0F, 1.0F, 0.56F));
/*      */     
/*      */     Label label2;
/*  258 */     (label2 = new Label(Game.i.localeManager.i18n.get("resource_item").toUpperCase(), labelStyle1)).setPosition(40.0F, 492.0F);
/*  259 */     label2.setSize(100.0F, 40.0F);
/*  260 */     group.addActor((Actor)label2);
/*      */ 
/*      */     
/*  263 */     (label2 = new Label(Game.i.localeManager.i18n.get("mined").toUpperCase(), labelStyle1)).setPosition(178.0F, 492.0F);
/*  264 */     label2.setSize(106.0F, 40.0F);
/*  265 */     label2.setAlignment(16);
/*  266 */     group.addActor((Actor)label2);
/*      */ 
/*      */     
/*  269 */     (label2 = new Label(Game.i.localeManager.i18n.get("mined_items").toUpperCase(), labelStyle1)).setPosition(342.0F, 492.0F);
/*  270 */     label2.setSize(218.0F, 40.0F);
/*  271 */     label2.setAlignment(1);
/*  272 */     group.addActor((Actor)label2);
/*      */     
/*  274 */     Color color = new Color(808464639);
/*  275 */     Label.LabelStyle labelStyle2 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE);
/*  276 */     Label.LabelStyle labelStyle3 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*  277 */     for (byte b = 0; b < ResourceType.values.length; b++) {
/*  278 */       Group group1 = new Group();
/*  279 */       this.p[b] = group1;
/*      */       
/*  281 */       group1.setTransform(false);
/*  282 */       group1.setTouchable(Touchable.disabled);
/*  283 */       group1.setSize(300.0F, 55.0F);
/*  284 */       group1.setPosition(0.0F, 437.0F - b * 59.0F);
/*  285 */       group.addActor((Actor)group1);
/*      */ 
/*      */       
/*      */       Image image;
/*      */ 
/*      */       
/*  291 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(174.0F, 55.0F);
/*  292 */       image.setColor(color);
/*  293 */       group1.addActor((Actor)image);
/*      */ 
/*      */       
/*  296 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(122.0F, 55.0F);
/*  297 */       image.setX(178.0F);
/*  298 */       image.setColor(color);
/*  299 */       group1.addActor((Actor)image);
/*      */ 
/*      */       
/*  302 */       image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[b]));
/*  303 */       this.q[b] = image;
/*  304 */       image.setSize(32.0F, 32.0F);
/*  305 */       image.setPosition(40.0F, 12.0F);
/*  306 */       group1.addActor((Actor)image);
/*      */ 
/*      */       
/*  309 */       Label label6 = new Label(Game.i.resourceManager.getName(ResourceType.values[b]), labelStyle2);
/*  310 */       this.r[b] = label6;
/*  311 */       label6.setSize(88.0F, 21.0F);
/*  312 */       label6.setPosition(86.0F, 23.0F);
/*  313 */       group1.addActor((Actor)label6);
/*      */ 
/*      */       
/*  316 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(16.0F, 16.0F);
/*  317 */       image.setPosition(84.0F, 7.0F);
/*  318 */       group1.addActor((Actor)image);
/*  319 */       this.s[b] = image;
/*      */       
/*      */       Label label5;
/*  322 */       (label5 = new Label("10", Game.i.assetManager.getLabelStyle(16))).setPosition(102.0F, 6.0F);
/*  323 */       label5.setSize(50.0F, 16.0F);
/*  324 */       group1.addActor((Actor)label5);
/*  325 */       this.t[b] = label5;
/*      */       
/*  327 */       this.u[b] = new Label("123", labelStyle3);
/*  328 */       this.u[b].setPosition(178.0F, 0.0F);
/*  329 */       this.u[b].setSize(106.0F, 55.0F);
/*  330 */       this.u[b].setAlignment(16);
/*  331 */       group1.addActor((Actor)this.u[b]);
/*      */       
/*  333 */       this.v[b] = new Label("", Game.i.assetManager.getLabelStyle(18));
/*  334 */       this.v[b].setColor(MaterialColor.AMBER.P500);
/*  335 */       this.v[b].setPosition(178.0F, 7.0F);
/*  336 */       this.v[b].setSize(106.0F, 17.0F);
/*  337 */       this.v[b].setAlignment(16);
/*  338 */       group1.addActor((Actor)this.v[b]);
/*      */     } 
/*      */ 
/*      */     
/*  342 */     this.o = new Table();
/*  343 */     this.n = new ScrollPane((Actor)this.o, Game.i.assetManager.getScrollPaneStyle(0.0F));
/*  344 */     UiUtils.enableMouseMoveScrollFocus(this.n);
/*  345 */     this.n.setSize(238.0F, (i + 311));
/*  346 */     this.n.setPosition(332.0F, (191 - i));
/*  347 */     this.n.setScrollingDisabled(true, false);
/*  348 */     this.n.setOverscroll(false, false);
/*  349 */     UiUtils.enableMouseMoveScrollFocus(this.n);
/*      */     
/*  351 */     group.addActor((Actor)this.n);
/*      */     
/*      */     Image image5;
/*  354 */     (image5 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize(238.0F, 10.0F);
/*  355 */     image5.setPosition(332.0F, 492.0F);
/*  356 */     image5.setColor(new Color(724249599));
/*  357 */     group.addActor((Actor)image5);
/*      */     
/*      */     Image image6;
/*  360 */     (image6 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setSize(238.0F, 10.0F);
/*  361 */     image6.setPosition(332.0F, 191.0F);
/*  362 */     image6.setColor(new Color(724249599));
/*  363 */     group.addActor((Actor)image6);
/*      */     
/*      */     Image image8;
/*  366 */     (image8 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setPosition(40.0F, 145.0F);
/*  367 */     image8.setSize(32.0F, 32.0F);
/*  368 */     group.addActor((Actor)image8);
/*      */     
/*      */     Table table2;
/*  371 */     (table2 = new Table()).setPosition(86.0F, 159.0F);
/*  372 */     table2.setSize(214.0F, 21.0F);
/*  373 */     group.addActor((Actor)table2);
/*      */     
/*  375 */     this.w = new Label("2.81k", Game.i.assetManager.getLabelStyle(21));
/*  376 */     table2.add((Actor)this.w);
/*      */     
/*      */     Label label4;
/*  379 */     (label4 = new Label(Game.i.localeManager.i18n.get("points_per_minute_short"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  380 */     table2.add((Actor)label4).padLeft(8.0F);
/*      */     
/*  382 */     table2.add().height(1.0F).growX();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  387 */     (table2 = new Table()).setPosition(86.0F, 138.0F);
/*  388 */     table2.setSize(214.0F, 17.0F);
/*  389 */     group.addActor((Actor)table2);
/*      */     
/*  391 */     this.x = new Label("44.8k", Game.i.assetManager.getLabelStyle(18));
/*  392 */     table2.add((Actor)this.x);
/*      */ 
/*      */     
/*  395 */     (label4 = new Label(Game.i.localeManager.i18n.get("score_gained_in_total_suffix"), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  396 */     table2.add((Actor)label4).padLeft(6.0F);
/*      */     
/*  398 */     table2.add().height(1.0F).growX();
/*      */ 
/*      */ 
/*      */     
/*  402 */     this.L = new Label(Game.i.localeManager.i18n.get("miner_speed_hint_no_modifiers_or_double_speed"), Game.i.assetManager.getLabelStyle(21));
/*  403 */     this.L.setPosition(167.0F, 0.0F);
/*  404 */     this.L.setSize(274.0F, 80.0F);
/*  405 */     this.L.setWrap(true);
/*  406 */     this.L.setAlignment(1);
/*  407 */     this.L.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  408 */     group.addActor((Actor)this.L);
/*      */     
/*      */     Label label1;
/*  411 */     (label1 = new Label(Game.i.localeManager.i18n.get("mining_speed").toUpperCase(Locale.US), labelStyle1)).setPosition(40.0F, 91.0F);
/*  412 */     label1.setSize(218.0F, 17.0F);
/*  413 */     label1.setAlignment(8);
/*  414 */     group.addActor((Actor)label1);
/*      */     
/*      */     Image image1;
/*  417 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 80.0F);
/*  418 */     image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  419 */     group.addActor((Actor)image1);
/*      */     
/*  421 */     this.A = new Image((Drawable)Game.i.assetManager.getQuad("ui.minerMenu.speedCellBg"));
/*  422 */     this.A.setColor(new Color(6904974));
/*  423 */     this.A.setPosition(138.0F, 0.0F);
/*  424 */     this.A.setSize(178.0F, 80.0F);
/*  425 */     group.addActor((Actor)this.A);
/*      */     
/*  427 */     this.z.add(this.A);
/*      */     
/*  429 */     this.D = new Image((Drawable)Game.i.assetManager.getQuad("ui.minerMenu.speedCellBg"));
/*  430 */     this.D.setColor(new Color(-7405466));
/*  431 */     this.D.setPosition(288.0F, 0.0F);
/*  432 */     this.D.setSize(178.0F, 80.0F);
/*  433 */     group.addActor((Actor)this.D);
/*      */     
/*  435 */     this.C.add(this.D);
/*      */     
/*      */     Image image7;
/*  438 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-pickaxe"))).setPosition(40.0F, 36.0F);
/*  439 */     image7.setSize(30.0F, 30.0F);
/*  440 */     group.addActor((Actor)image7);
/*      */ 
/*      */     
/*  443 */     (label4 = new Label(Game.i.localeManager.i18n.get("miner_menu_base_speed_hint").toUpperCase(Locale.US), Game.i.assetManager.getLabelStyle(18))).setPosition(40.0F, 13.0F);
/*  444 */     label4.setSize(100.0F, 17.0F);
/*  445 */     label4.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  446 */     group.addActor((Actor)label4);
/*      */     
/*  448 */     this.y = new Label("5.61", Game.i.assetManager.getLabelStyle(24));
/*  449 */     this.y.setPosition(76.0F, 36.0F);
/*  450 */     this.y.setSize(100.0F, 30.0F);
/*  451 */     group.addActor((Actor)this.y);
/*      */ 
/*      */ 
/*      */     
/*  455 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-modifier-mining-speed-research"))).setPosition(176.0F, 34.0F);
/*  456 */     image7.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  457 */     image7.setSize(30.0F, 30.0F);
/*  458 */     group.addActor((Actor)image7);
/*      */     
/*  460 */     this.z.add(image7);
/*      */ 
/*      */     
/*  463 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-modifier-mining-speed-research"))).setPosition(176.0F, 36.0F);
/*  464 */     image7.setColor(new Color(1303817471));
/*  465 */     image7.setSize(30.0F, 30.0F);
/*  466 */     group.addActor((Actor)image7);
/*      */     
/*  468 */     this.z.add(image7);
/*      */ 
/*      */     
/*  471 */     (label4 = new Label(Game.i.localeManager.i18n.get("modifiers").toUpperCase(Locale.US), labelStyle1)).setPosition(143.0F, 13.0F);
/*  472 */     label4.setSize(150.0F, 17.0F);
/*  473 */     label4.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  474 */     label4.setAlignment(1);
/*  475 */     group.addActor((Actor)label4);
/*      */     
/*  477 */     this.z.add(label4);
/*      */     
/*  479 */     this.B = new Label("+200%", Game.i.assetManager.getLabelStyle(24));
/*  480 */     this.B.setSize(100.0F, 30.0F);
/*  481 */     this.B.setPosition(213.0F, 36.0F);
/*  482 */     group.addActor((Actor)this.B);
/*  483 */     this.z.add(this.B);
/*      */ 
/*      */     
/*  486 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setSize(20.0F, 20.0F);
/*  487 */     image7.setPosition(301.0F, 64.0F);
/*  488 */     image7.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  489 */     group.addActor((Actor)image7);
/*  490 */     this.z.add(image7);
/*      */ 
/*      */     
/*  493 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setSize(20.0F, 20.0F);
/*  494 */     image7.setPosition(301.0F, 66.0F);
/*  495 */     image7.setColor(new Color(9865471));
/*  496 */     group.addActor((Actor)image7);
/*  497 */     this.z.add(image7);
/*      */     
/*      */     Actor actor;
/*  500 */     (actor = new Actor()).setPosition(138.0F, 0.0F);
/*  501 */     actor.setSize(165.0F, 80.0F);
/*  502 */     actor.setTouchable(Touchable.enabled);
/*  503 */     group.addActor(actor);
/*  504 */     this.z.add(actor);
/*      */     
/*  506 */     actor.addListener((EventListener)new ClickListener(this, paramGameSystemProvider, actor)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*      */             Miner miner;
/*  510 */             if ((miner = MinerMenu.a(this.c)) != null) {
/*  511 */               int i = this.a.miner.getMiningSpeedModifierCount(miner);
/*  512 */               MinerMenu.a().setLength(0);
/*  513 */               MinerMenu.a().append(Game.i.localeManager.i18n
/*  514 */                   .format("miner_is_connected_to_mining_speed_mods", new Object[] { Integer.valueOf(i)
/*  515 */                     })).append("\n");
/*      */               
/*  517 */               MinerMenu.a().append(Game.i.localeManager.i18n
/*  518 */                   .get("mining_speed_mods_tooltip"))
/*  519 */                 .append("\n");
/*      */               
/*  521 */               Table table2 = new Table();
/*      */               Label label;
/*  523 */               (label = new Label((CharSequence)MinerMenu.a(), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  524 */               label.setAlignment(1);
/*  525 */               table2.add((Actor)label).minWidth(300.0F).growX().row();
/*      */               
/*  527 */               Table table1 = MiningSpeedModifier.createEfficiencyTable(this.a, i);
/*  528 */               table2.add((Actor)table1).growX().row();
/*      */               
/*  530 */               TooltipsOverlay.i().showActor("miner_menu_modifiers_speed_hint", this.b, (Actor)table2, UiManager.MainUiLayer.SCREEN, 106, 2);
/*      */             } 
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  538 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setSize(20.0F, 20.0F);
/*  539 */     image7.setPosition(451.0F, 64.0F);
/*  540 */     image7.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  541 */     group.addActor((Actor)image7);
/*  542 */     this.C.add(image7);
/*      */ 
/*      */     
/*  545 */     (image7 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setSize(20.0F, 20.0F);
/*  546 */     image7.setPosition(451.0F, 66.0F);
/*  547 */     image7.setColor(new Color(-4126721));
/*  548 */     group.addActor((Actor)image7);
/*  549 */     this.C.add(image7);
/*      */     
/*  551 */     this.C.add(this.D);
/*      */     
/*  553 */     this.F = new Image((Drawable)Game.i.assetManager.getDrawable("icon-x2"));
/*  554 */     this.F.setPosition(323.0F, 17.0F);
/*  555 */     this.F.setSize(38.0F, 38.0F);
/*  556 */     this.F.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  557 */     group.addActor((Actor)this.F);
/*  558 */     this.C.add(this.F);
/*      */     
/*  560 */     this.E = new Image((Drawable)Game.i.assetManager.getDrawable("icon-x2"));
/*  561 */     this.E.setPosition(323.0F, 19.0F);
/*  562 */     this.E.setSize(38.0F, 38.0F);
/*  563 */     group.addActor((Actor)this.E);
/*  564 */     this.C.add(this.E);
/*      */     
/*  566 */     this.I = new Label("05:31", Game.i.assetManager.getLabelStyle(24));
/*  567 */     this.I.setPosition(372.0F, 29.0F);
/*  568 */     this.I.setSize(67.0F, 20.0F);
/*  569 */     group.addActor((Actor)this.I);
/*  570 */     this.C.add(this.I);
/*      */     
/*  572 */     this.H = new Image((Drawable)Game.i.assetManager.getDrawable("icon-x2"));
/*  573 */     this.H.setPosition(318.0F, 1.0F);
/*  574 */     this.H.setSize(38.0F, 38.0F);
/*  575 */     this.H.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  576 */     group.addActor((Actor)this.H);
/*  577 */     this.C.add(this.H);
/*      */     
/*  579 */     this.G = new Image((Drawable)Game.i.assetManager.getDrawable("icon-x2"));
/*  580 */     this.G.setPosition(318.0F, 3.0F);
/*  581 */     this.G.setSize(38.0F, 38.0F);
/*  582 */     group.addActor((Actor)this.G);
/*  583 */     this.C.add(this.G);
/*      */     
/*  585 */     this.J = new Label("05:31", Game.i.assetManager.getLabelStyle(24));
/*  586 */     this.J.setPosition(366.0F, 14.0F);
/*  587 */     this.J.setSize(67.0F, 20.0F);
/*  588 */     group.addActor((Actor)this.J);
/*  589 */     this.C.add(this.J);
/*      */ 
/*      */     
/*  592 */     (actor = new Actor()).setPosition(302.0F, 0.0F);
/*  593 */     actor.setSize(165.0F, 80.0F);
/*  594 */     actor.setTouchable(Touchable.enabled);
/*  595 */     group.addActor(actor);
/*  596 */     this.C.add(actor);
/*      */     
/*  598 */     actor.addListener((EventListener)new ClickListener(this, paramGameSystemProvider, actor)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*      */             Miner miner;
/*  602 */             if ((miner = MinerMenu.a(this.c)) != null) {
/*  603 */               MinerMenu.a().setLength(0);
/*      */               
/*  605 */               if (miner.doubleSpeedTimeLeft > 0.0F) {
/*  606 */                 MinerMenu.a().append(Game.i.localeManager.i18n.get("miner_double_speed_hint_individual")).append("\n");
/*      */               }
/*  608 */               if (this.a.miner.bonusDoubleMiningSpeedTimeLeft > 0.0F) {
/*  609 */                 MinerMenu.a().append(Game.i.localeManager.i18n.get("miner_double_speed_hint_global")).append("\n");
/*      */               }
/*      */               
/*  612 */               TooltipsOverlay.i().showText("miner_menu_double_speed_hint", this.b, (CharSequence)MinerMenu.a(), UiManager.MainUiLayer.SCREEN, 106, 2);
/*      */             } 
/*      */           }
/*      */         });
/*      */ 
/*      */     
/*  618 */     this.K = new Label("[#888888]=[] 5.61", Game.i.assetManager.getLabelStyle(30));
/*  619 */     this.K.setAlignment(16);
/*  620 */     this.K.setSize(103.0F, 25.0F);
/*  621 */     this.K.setPosition(457.0F, 33.0F);
/*  622 */     group.addActor((Actor)this.K);
/*      */ 
/*      */     
/*  625 */     (label4 = new Label("/" + Game.i.localeManager.i18n.get("TIME_CHAR_MINUTE"), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  626 */     label4.setAlignment(16);
/*  627 */     label4.setSize(54.0F, 16.0F);
/*  628 */     label4.setPosition(506.0F, 15.0F);
/*  629 */     group.addActor((Actor)label4);
/*      */     
/*  631 */     this.N = new Label("+1.2", Game.i.assetManager.getLabelStyle(21));
/*  632 */     this.N.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  633 */     this.N.setPosition(76.0F, 66.0F);
/*  634 */     this.N.setSize(100.0F, 21.0F);
/*  635 */     group.addActor((Actor)this.N);
/*      */     
/*  637 */     this.O = new Label("+1.2", Game.i.assetManager.getLabelStyle(21));
/*  638 */     this.O.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  639 */     this.O.setPosition(478.0F, 66.0F);
/*  640 */     this.O.setSize(82.0F, 21.0F);
/*  641 */     this.O.setAlignment(16);
/*  642 */     group.addActor((Actor)this.O);
/*      */ 
/*      */     
/*  645 */     this.P = new UpgradeSubmenu();
/*  646 */     this.P.addListener(new UpgradeSubmenu.UpgradeSubmenuListener(this, paramGameSystemProvider)
/*      */         {
/*      */           public void upgradeButtonStateChanged(boolean param1Boolean) {
/*  649 */             MinerMenu.b(this.b);
/*      */           }
/*      */ 
/*      */           
/*      */           public void upgradeButtonConfirmed() {
/*      */             Miner miner;
/*  655 */             if ((miner = MinerMenu.a(this.b)) != null) {
/*  656 */               this.a.miner.upgradeMinerAction(miner);
/*  657 */               MinerMenu.b(this.b);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void globalUpgradeButtonConfirmed() {
/*      */             Miner miner;
/*  664 */             if ((miner = MinerMenu.a(this.b)) != null) {
/*  665 */               int i = this.a.miner.getGlobalUpgradePrice(miner.type);
/*  666 */               String str = Game.i.localeManager.i18n.get("upgrade_all_miners_by_type_confirm") + " <@game-ui-coin-icon>[#FDD835]" + StringFormatter.commaSeparatedNumber(i) + "[]";
/*  667 */               Dialog.i().showConfirm(Game.i.assetManager.replaceRegionAliasesWithChars(str), () -> {
/*      */                     param1GameSystemProvider.miner.globalUpgradeMinerAction(param1Miner.type);
/*      */                     MinerMenu.b(this.b);
/*      */                   });
/*      */             } 
/*      */           }
/*      */         });
/*  674 */     this.P.setPosition(0.0F, 132.0F);
/*  675 */     this.a.addActor((Actor)this.P);
/*      */ 
/*      */     
/*  678 */     this.Q = new SellButton(() -> {
/*      */           Miner miner;
/*      */           if ((miner = b()) != null) {
/*      */             paramGameSystemProvider.miner.sellMinerAction(miner);
/*      */           }
/*      */         });
/*  684 */     this.Q.setPosition(368.0F, 40.0F);
/*  685 */     this.a.addActor((Actor)this.Q);
/*      */     
/*  687 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*      */           Tile tile;
/*      */           
/*      */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SOURCE && ((SourceTile)tile).miner != null) {
/*      */             this.P.setButtonSelected(false);
/*      */             c();
/*      */             a(true);
/*      */           } else {
/*      */             a(false);
/*      */           } 
/*      */           e();
/*      */         });
/*  699 */     paramGameSystemProvider.events.getListeners(MinerPlace.class).add(paramMinerPlace -> {
/*      */           if (paramMinerPlace.getMiner().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             a(true);
/*      */             
/*      */             e();
/*      */             Game.i.uiManager.runOnStageActOnce(this.V);
/*      */           } 
/*      */         });
/*  707 */     paramGameSystemProvider.events.getListeners(MinerRemove.class).add(paramMinerRemove -> {
/*      */           if (paramMinerRemove.getOldTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*      */             a(false);
/*      */             e();
/*      */           } 
/*      */         }); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Miner b() {
/*      */     Tile tile;
/*  720 */     if ((tile = this.R._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SOURCE) {
/*  721 */       return ((SourceTile)tile).miner;
/*      */     }
/*  723 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void c() {
/*  728 */     if (this.R == null || this.R.map == null)
/*      */       return; 
/*  730 */     this.M.clear();
/*      */     
/*      */     Tile tile;
/*  733 */     if ((tile = this.R._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SOURCE && ((SourceTile)tile).miner != null) {
/*  734 */       this.a.setLabelOverTitleTilePos(tile);
/*      */       
/*      */       SourceTile sourceTile;
/*  737 */       Miner miner = (sourceTile = (SourceTile)tile).miner;
/*      */       
/*  739 */       this.g.setVisible(sourceTile.isDepleted());
/*      */       
/*  741 */       this.x.setText((CharSequence)StringFormatter.compactNumber(miner.totalScoreGained, false));
/*      */       
/*  743 */       float f = this.R.miner.calculateScorePerMinute(miner);
/*  744 */       this.w.setText((CharSequence)StringFormatter.compactNumber(f, true));
/*      */ 
/*      */ 
/*      */       
/*  748 */       if (miner.affectedByLoopAbility != null) {
/*  749 */         Table table = new Table();
/*  750 */         this.M.add((Actor)table).padRight(15.0F);
/*      */         
/*      */         Image image1;
/*  753 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-loop"))).setColor(MaterialColor.GREEN.P500);
/*  754 */         table.add((Actor)image1).size(24.0F).padRight(6.0F);
/*      */         
/*      */         Label label;
/*  757 */         (label = new Label((CharSequence)StringFormatter.compactNumber(miner.loopAbilityResourceBuffer, false), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.GREEN.P500);
/*  758 */         table.add((Actor)label);
/*      */         
/*      */         Image image2;
/*  761 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  762 */         table.add((Actor)image2).size(24.0F).padLeft(6.0F);
/*  763 */         table.setTouchable(Touchable.enabled);
/*  764 */         table.addListener((EventListener)new ClickListener(this)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  767 */                 TooltipsOverlay.i().showText("loop_ability_miner_menu_hint", (Actor)MinerMenu.c(this.a), Game.i.localeManager.i18n.get("loop_ability_miner_menu_hint"), UiManager.MainUiLayer.SCREEN, 106, 4);
/*      */               }
/*      */             });
/*      */       } 
/*  771 */       this.M.add().height(1.0F).growX();
/*      */ 
/*      */       
/*  774 */       Miner.Factory factory = Game.i.minerManager.getFactory(miner.type);
/*  775 */       this.c.setText(factory.getTitle());
/*      */ 
/*      */       
/*  778 */       this.f.setTile(sourceTile);
/*      */       
/*      */       int i;
/*  781 */       for (i = 0; i < ResourceType.values.length; i++) {
/*  782 */         ResourceType resourceType = ResourceType.values[i];
/*  783 */         if (factory.canMineResource(resourceType)) {
/*  784 */           this.p[i].setVisible(true);
/*      */           
/*  786 */           long l = this.R.gameState.calculateFinalScore(this.R.miner.getResourceMinedRawScore(resourceType), StatisticsType.SG_RM);
/*  787 */           this.t[i].setText((CharSequence)StringFormatter.compactNumber(l, false));
/*      */           
/*  789 */           int j = (miner.getTile()).minedResources[i];
/*  790 */           int k = 0;
/*  791 */           if (this.R.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS)
/*      */           {
/*  793 */             if ((k = j - miner.getTile().getResourcesCount(resourceType)) < 0) {
/*  794 */               k = 0;
/*      */             } else {
/*  796 */               j -= k;
/*      */             } 
/*      */           }
/*  799 */           if (k > 0) {
/*  800 */             W.setLength(0);
/*  801 */             W.append('+').append(StringFormatter.compactNumber(k, false));
/*  802 */             this.v[i].setText((CharSequence)W);
/*  803 */             this.v[i].setVisible(true);
/*  804 */             this.u[i].setY(24.0F);
/*  805 */             this.u[i].setHeight(22.0F);
/*      */           } else {
/*  807 */             this.v[i].setVisible(false);
/*  808 */             this.u[i].setY(0.0F);
/*  809 */             this.u[i].setHeight(55.0F);
/*      */           } 
/*  811 */           this.u[i].setText((CharSequence)StringFormatter.compactNumber(j, false));
/*      */           
/*  813 */           if (sourceTile.getResourcesCount(resourceType) > 0 || (miner.getTile()).minedResources[i] > 0) {
/*      */ 
/*      */             
/*  816 */             this.t[i].setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  817 */             this.s[i].setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  818 */             this.u[i].setColor(Color.WHITE);
/*  819 */             this.q[i].setColor(Game.i.resourceManager.getColor(resourceType));
/*  820 */             this.r[i].setColor(Game.i.resourceManager.getColor(resourceType));
/*      */           }
/*      */           else {
/*      */             
/*  824 */             this.t[i].setColor(0.14F, 0.14F, 0.14F, 1.0F);
/*  825 */             this.s[i].setColor(0.14F, 0.14F, 0.14F, 1.0F);
/*  826 */             this.u[i].setColor(0.14F, 0.14F, 0.14F, 1.0F);
/*  827 */             this.q[i].setColor(0.14F, 0.14F, 0.14F, 1.0F);
/*  828 */             this.r[i].setColor(0.14F, 0.14F, 0.14F, 1.0F);
/*      */           } 
/*      */         } else {
/*  831 */           this.p[i].setVisible(false);
/*      */         } 
/*      */       } 
/*      */       
/*  835 */       if (this.P.isButtonSelected() && miner.getUpgradeLevel() < this.R.miner.getMaxUpgradeLevel(miner.type)) {
/*      */         
/*  837 */         float f1 = this.R.miner.getMiningSpeed(miner, miner.getUpgradeLevel());
/*      */         
/*      */         float f2;
/*  840 */         if ((f2 = this.R.miner.getMiningSpeed(miner, miner.getUpgradeLevel() + 1) - f1) >= 0.0F) {
/*  841 */           if (miner.doubleSpeedTimeLeft > 0.0F) {
/*  842 */             f2 *= 2.0F;
/*      */           }
/*  844 */           W.setLength(0);
/*  845 */           W.append('+');
/*  846 */           W.append(StringFormatter.compactNumber((f2 * 60.0F), true));
/*  847 */           this.O.setText((CharSequence)W);
/*      */           
/*  849 */           f1 = this.R.miner.getBaseMiningSpeed(miner, miner.getUpgradeLevel());
/*  850 */           f2 = this.R.miner.getBaseMiningSpeed(miner, miner.getUpgradeLevel() + 1) - f1;
/*  851 */           W.setLength(0);
/*  852 */           W.append('+');
/*  853 */           W.append(StringFormatter.compactNumber((f2 * 60.0F), true));
/*  854 */           this.N.setText((CharSequence)W);
/*      */           
/*  856 */           this.N.setVisible(true);
/*  857 */           this.O.setVisible(true);
/*      */         } else {
/*  859 */           this.N.setVisible(false);
/*  860 */           this.O.setVisible(false);
/*      */         } 
/*      */       } else {
/*      */         
/*  864 */         this.N.setVisible(false);
/*  865 */         this.O.setVisible(false);
/*      */       } 
/*      */ 
/*      */       
/*  869 */       this.o.clearChildren();
/*  870 */       this.o.add().width(1.0F).height(10.0F).row();
/*  871 */       i = this.R.loot.getLootSlots(miner.type);
/*  872 */       Array array = this.R.loot.getSourceMinedItems(miner.getTile().getX(), miner.getTile().getY());
/*  873 */       for (byte b = 0; b < i; b++) {
/*      */         Group group;
/*  875 */         (group = new Group()).setTransform(false);
/*      */         Image image;
/*  877 */         (image = new Image((Drawable)Game.i.assetManager.getQuad((b % 2 == 0) ? "ui.minerMenu.itemCell.a" : "ui.minerMenu.itemCell.b"))).setSize(70.0F, 70.0F);
/*  878 */         group.addActor((Actor)image);
/*  879 */         if (array != null && array.size > b) {
/*  880 */           image.setColor(new Color(808464639));
/*      */           
/*      */           Image image1;
/*  883 */           (image1 = new Image((Drawable)Game.i.assetManager.getQuad((b % 2 == 0) ? "ui.minerMenu.itemCell.aRarityTint" : "ui.minerMenu.itemCell.bRarityTint"))).setSize(70.0F, 70.0F);
/*  884 */           image1.setColor(Game.i.progressManager.getRarityColor(((ItemStack)array.get(b)).getItem().getRarity()));
/*  885 */           group.addActor((Actor)image1);
/*      */           
/*      */           Actor actor;
/*  888 */           (actor = ((ItemStack)array.get(b)).getItem().generateIcon(48.0F, true)).setPosition(11.0F, 11.0F);
/*  889 */           group.addActor(actor);
/*      */           
/*      */           Label label;
/*  892 */           (label = new Label((CharSequence)StringFormatter.compactNumber(((ItemStack)array.get(b)).getCount(), false), Game.i.assetManager.getLabelStyle(18))).setPosition(37.0F, 5.0F);
/*  893 */           label.setSize(27.0F, 16.0F);
/*  894 */           label.setAlignment(16);
/*  895 */           group.addActor((Actor)label);
/*      */         } else {
/*  897 */           image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */         } 
/*      */         
/*  900 */         Cell cell = this.o.add((Actor)group).size(70.0F).padBottom(4.0F);
/*  901 */         if (b % 3 != 2) {
/*  902 */           cell.padRight(4.0F);
/*      */         }
/*  904 */         if ((b + 1) % 3 == 0) {
/*  905 */           this.o.row();
/*      */         }
/*      */       } 
/*  908 */       this.o.row();
/*  909 */       this.o.add().width(1.0F).minHeight(10.0F).growY();
/*      */ 
/*      */       
/*  912 */       this.P.a(miner.getUpgradeLevel(), this.R.miner.getMaxUpgradeLevel(miner.type));
/*  913 */       if (miner.getUpgradeLevel() < this.R.miner.getMaxUpgradeLevel(miner.type)) {
/*      */         
/*  915 */         this.P.a(this.R.miner.getUpgradePrice(miner));
/*      */       } else {
/*      */         
/*  918 */         this.P.a(-1);
/*      */       } 
/*  920 */       d();
/*      */ 
/*      */       
/*  923 */       this.Q.setPrice(miner.getSellPrice());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*      */     Miner miner;
/*  929 */     if ((miner = b()) != null) {
/*  930 */       this.P.a((this.R.gameState
/*  931 */           .getMoney() >= this.R.miner.getUpgradePrice(miner) && miner
/*  932 */           .getUpgradeLevel() < this.R.miner.getMaxUpgradeLevel(miner.type)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  942 */     if (this.b) {
/*      */       Miner miner;
/*  944 */       if ((miner = b()) != null) {
/*  945 */         float f2 = 0.0F;
/*  946 */         if (miner.isPrepared()) {
/*      */           
/*  948 */           if (miner.nextMinedResourceType != null) {
/*  949 */             f2 = miner.getVisualMiningProgress();
/*      */             
/*  951 */             this.e.setColor(Game.i.resourceManager.getColor(miner.nextMinedResourceType));
/*  952 */             this.i.setColor(Game.i.resourceManager.getColor(miner.nextMinedResourceType));
/*  953 */             this.i.setDrawable((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[miner.nextMinedResourceType.ordinal()]));
/*      */           } 
/*  955 */           this.i.setVisible(true);
/*  956 */           this.h.setVisible(false);
/*  957 */           this.k.setVisible(true);
/*  958 */           this.j.setVisible(false);
/*      */           
/*  960 */           W.setLength(0);
/*  961 */           W.append((int)(f2 * 100.0F));
/*  962 */           W.append('%');
/*  963 */           this.d.setText((CharSequence)W);
/*      */         }
/*      */         else {
/*      */           
/*  967 */           if ((f2 = miner.getPreparationProgress()) < 0.0F || f2 > 1.0F) {
/*  968 */             throw new IllegalStateException("Preparation progress " + f2);
/*      */           }
/*  970 */           this.e.setColor(MaterialColor.GREY.P500);
/*  971 */           this.i.setVisible(false);
/*  972 */           this.h.setVisible(true);
/*  973 */           this.k.setVisible(false);
/*  974 */           this.j.setVisible(true);
/*      */           
/*  976 */           this.d.setText((CharSequence)StringFormatter.digestTime((int)miner.getInstallTimeLeft()));
/*      */         } 
/*      */         
/*  979 */         this.e.setCoeff(f2);
/*      */         
/*      */         boolean bool;
/*      */         
/*  983 */         if (bool = (miner.doubleSpeedTimeLeft > 0.0F || this.R.miner.bonusDoubleMiningSpeedTimeLeft > 0.0F) ? true : false) {
/*  984 */           W.setLength(0);
/*  985 */           if (miner.doubleSpeedTimeLeft > 0.0F) {
/*  986 */             W.append("x2: ");
/*  987 */             W.append(StringFormatter.digestTime(StrictMath.round(miner.doubleSpeedTimeLeft)));
/*      */           } 
/*  989 */           if (this.R.miner.bonusDoubleMiningSpeedTimeLeft > 0.0F) {
/*  990 */             if (W.length != 0) {
/*  991 */               W.append(" / ");
/*      */             }
/*  993 */             W.append("Bonus x2: ");
/*  994 */             W.append(StringFormatter.digestTime(StrictMath.round(this.R.miner.bonusDoubleMiningSpeedTimeLeft)));
/*      */           } 
/*  996 */           this.l.setText((CharSequence)W);
/*  997 */           this.m.setText((CharSequence)W);
/*  998 */           this.l.setVisible(true);
/*  999 */           this.m.setVisible(true);
/*      */         } else {
/* 1001 */           this.l.setVisible(false);
/* 1002 */           this.m.setVisible(false);
/*      */         } 
/*      */ 
/*      */         
/* 1006 */         this.y.setText((CharSequence)StringFormatter.compactNumber((this.R.miner.getBaseMiningSpeed(miner, miner.getUpgradeLevel()) * 60.0F), true));
/*      */         
/* 1008 */         float f1 = this.R.miner.getMiningSpeed(miner, miner.getUpgradeLevel()) * 60.0F;
/* 1009 */         if (miner.doubleSpeedTimeLeft > 0.0F) {
/* 1010 */           f1 *= 2.0F;
/*      */         }
/* 1012 */         W.setLength(0);
/* 1013 */         W.append("[#888888]=[] ").append(StringFormatter.compactNumber(f1, true));
/* 1014 */         this.K.setText((CharSequence)W);
/*      */         
/* 1016 */         if (this.R.miner.getMiningSpeedModifierCount(miner) != 0) {
/* 1017 */           f1 = this.R.miner.getMiningSpeedModifierMultiplier(miner);
/* 1018 */           for (byte b1 = 0; b1 < this.z.size; b1++) {
/* 1019 */             ((Actor)this.z.get(b1)).setVisible(true);
/*      */           }
/* 1021 */           W.setLength(0);
/* 1022 */           W.append('+').append(MathUtils.round((f1 - 1.0F) * 100.0F)).append('%');
/* 1023 */           this.B.setText((CharSequence)W);
/*      */         } else {
/* 1025 */           for (byte b1 = 0; b1 < this.z.size; b1++) {
/* 1026 */             ((Actor)this.z.get(b1)).setVisible(false);
/*      */           }
/*      */         } 
/*      */         
/* 1030 */         byte b = 0;
/* 1031 */         if (miner.doubleSpeedTimeLeft > 0.0F) {
/* 1032 */           b++;
/*      */         }
/* 1034 */         if (this.R.miner.bonusDoubleMiningSpeedTimeLeft > 0.0F) {
/* 1035 */           b++;
/*      */         }
/* 1037 */         if (b == 0) {
/* 1038 */           for (byte b1 = 0; b1 < this.C.size; b1++) {
/* 1039 */             ((Actor)this.C.get(b1)).setVisible(false);
/*      */           }
/*      */         } else {
/* 1042 */           for (byte b1 = 0; b1 < this.C.size; b1++) {
/* 1043 */             ((Actor)this.C.get(b1)).setVisible(true);
/*      */           }
/*      */           
/* 1046 */           if (b == 1) {
/* 1047 */             this.I.setPosition(372.0F, 29.0F);
/* 1048 */             this.F.setPosition(323.0F, 17.0F);
/* 1049 */             this.E.setPosition(323.0F, 19.0F);
/*      */             
/* 1051 */             this.G.setVisible(false);
/* 1052 */             this.H.setVisible(false);
/* 1053 */             this.J.setVisible(false);
/*      */             
/* 1055 */             if (miner.doubleSpeedTimeLeft > 0.0F) {
/* 1056 */               this.I.setText((CharSequence)StringFormatter.digestTime((int)miner.doubleSpeedTimeLeft));
/*      */             } else {
/* 1058 */               this.I.setText((CharSequence)StringFormatter.digestTime((int)this.R.miner.bonusDoubleMiningSpeedTimeLeft));
/*      */             } 
/*      */           } else {
/* 1061 */             this.I.setPosition(378.0F, 44.0F);
/* 1062 */             this.F.setPosition(329.0F, 32.0F);
/* 1063 */             this.E.setPosition(329.0F, 34.0F);
/*      */             
/* 1065 */             this.I.setText((CharSequence)StringFormatter.digestTime((int)miner.doubleSpeedTimeLeft));
/* 1066 */             this.J.setText((CharSequence)StringFormatter.digestTime((int)this.R.miner.bonusDoubleMiningSpeedTimeLeft));
/*      */           } 
/*      */         } 
/*      */         
/* 1070 */         this.L.setVisible((this.R.miner.getMiningSpeedModifierCount(miner) == 0 && b == 0)); return;
/*      */       } 
/* 1072 */       this.e.setCoeff(0.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void e() {
/* 1078 */     TooltipsOverlay.i().hideEntry("miner_menu_modifiers_speed_hint");
/* 1079 */     TooltipsOverlay.i().hideEntry("miner_menu_double_speed_hint");
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1083 */     if (this.b != paramBoolean) {
/* 1084 */       this.b = paramBoolean;
/* 1085 */       if (paramBoolean) {
/* 1086 */         this.a.show();
/* 1087 */         c();
/*      */       } else {
/* 1089 */         if (Game.i.uiManager.stage.getScrollFocus() == this.n) {
/* 1090 */           Game.i.uiManager.stage.setScrollFocus(null);
/*      */         }
/* 1092 */         this.a.hide();
/*      */       } 
/* 1094 */       e();
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
/*      */   private void a(MinerResourceChange paramMinerResourceChange) {
/* 1107 */     if (this.b && b() == paramMinerResourceChange.getMiner()) {
/* 1108 */       Game.i.uiManager.runOnStageActOnce(this.U);
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(NextWaveForce paramNextWaveForce) {
/* 1113 */     if (this.b) {
/* 1114 */       Game.i.uiManager.runOnStageActOnce(this.U);
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(MinerMineItem paramMinerMineItem) {
/* 1119 */     if (this.b && b() == paramMinerMineItem.getMiner())
/* 1120 */       Game.i.uiManager.runOnStageActOnce(this.U); 
/*      */   }
/*      */   
/*      */   private class _SideMenuListener extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*      */     private _SideMenuListener(MinerMenu this$0) {}
/*      */     
/*      */     public void offscreenChanged() {
/* 1127 */       MinerMenu.b(this.a);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MinerMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */