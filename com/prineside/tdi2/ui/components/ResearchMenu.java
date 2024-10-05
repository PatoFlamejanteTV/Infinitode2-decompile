/*      */ package com.prineside.tdi2.ui.components;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Requirement;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TowerStatType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.managers.GameValueManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.ResearchManager;
/*      */ import com.prineside.tdi2.managers.TowerStatManager;
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
/*      */ import com.prineside.tdi2.screens.ResearchesScreen;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.actors.SideMenu;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.ItemDescriptionDialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public class ResearchMenu implements Disposable {
/*   49 */   private static final TLog a = TLog.forClass(ResearchMenu.class);
/*      */ 
/*      */   
/*   52 */   private static final Color b = new Color(808464639);
/*      */   
/*      */   private final SideMenu c;
/*      */   
/*      */   private final ResearchesScreen d;
/*      */   
/*      */   private final SideMenu.SideMenuContainer e;
/*      */   
/*      */   private boolean f;
/*      */   
/*      */   private final Label.LabelStyle g;
/*      */   
/*      */   private final Label.LabelStyle h;
/*      */   
/*      */   private final LimitedWidthLabel i;
/*      */   
/*      */   private final Label j;
/*      */   private final Label k;
/*      */   private final Label l;
/*      */   private final Group m;
/*      */   private final Group n;
/*      */   private final Group o;
/*      */   private final Group p;
/*      */   private final Image q;
/*      */   private final Image r;
/*      */   private final Label s;
/*      */   private final Image t;
/*      */   private final Label u;
/*      */   private final Label v;
/*      */   private final Image w;
/*      */   private final Label x;
/*      */   private float y;
/*      */   private ComplexButton z;
/*      */   private ComplexButton A;
/*      */   private ComplexButton B;
/*   87 */   private Color C = Color.WHITE;
/*   88 */   private Color D = Color.WHITE;
/*   89 */   private Color E = Color.WHITE;
/*      */   
/*      */   private boolean F = false;
/*      */   private boolean G = false;
/*   93 */   private final _SideMenuListener H = new _SideMenuListener((byte)0);
/*   94 */   private final _ResearchesScreenListener I = new _ResearchesScreenListener((byte)0);
/*   95 */   private final _ResearchManagerListener J = new _ResearchManagerListener((byte)0);
/*      */   
/*   97 */   private static final StringBuilder K = new StringBuilder();
/*      */   
/*      */   public ResearchMenu(SideMenu paramSideMenu, ResearchesScreen paramResearchesScreen) {
/*  100 */     this.c = paramSideMenu;
/*  101 */     this.d = paramResearchesScreen;
/*      */     
/*  103 */     this.h = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  104 */     this.g = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*      */ 
/*      */     
/*  107 */     this.e = paramSideMenu.createContainer("ResearchMenu");
/*  108 */     this.e.hide();
/*      */ 
/*      */     
/*  111 */     this.i = new LimitedWidthLabel("", 36, 30, 440.0F);
/*  112 */     this.i.setSize(520.0F, 26.0F);
/*  113 */     this.i.setPosition(40.0F, 903.0F);
/*  114 */     this.e.addActor((Actor)this.i);
/*      */ 
/*      */     
/*  117 */     this.j = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  118 */     this.j.setSize(440.0F, 60.0F);
/*  119 */     this.j.setPosition(40.0F, 835.0F);
/*  120 */     this.j.setWrap(true);
/*  121 */     this.j.setAlignment(10);
/*  122 */     this.e.addActor((Actor)this.j);
/*      */ 
/*      */     
/*  125 */     this.k = new Label("L1", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), MaterialColor.AMBER.P500));
/*  126 */     this.k.setSize(520.0F, 26.0F);
/*  127 */     this.k.setPosition(40.0F, 903.0F);
/*  128 */     this.k.setAlignment(16);
/*  129 */     this.e.addActor((Actor)this.k);
/*      */     
/*  131 */     this.l = new Label("/ 10", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*  132 */     this.l.setSize(520.0F, 26.0F);
/*  133 */     this.l.setPosition(40.0F, 867.0F);
/*  134 */     this.l.setAlignment(16);
/*  135 */     this.l.setColor(MaterialColor.AMBER.P500);
/*  136 */     this.l.getColor().mul(1.0F, 1.0F, 1.0F, 0.56F);
/*  137 */     this.e.addActor((Actor)this.l);
/*      */ 
/*      */ 
/*      */     
/*  141 */     this.m = new Group();
/*  142 */     this.m.setTransform(false);
/*  143 */     this.m.setSize(600.0F, 825.0F);
/*  144 */     this.e.addActor((Actor)this.m);
/*      */ 
/*      */     
/*  147 */     Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(30);
/*  148 */     if (Game.i.localeManager.i18n.get("reset_branch").length() > 14) {
/*  149 */       labelStyle = Game.i.assetManager.getLabelStyle(24);
/*      */     }
/*  151 */     this.z = new ComplexButton(Game.i.localeManager.i18n.get("reset_branch").toUpperCase(), labelStyle, () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.format("reset_research_branch_for_accelerators", new Object[] { Integer.valueOf(Game.i.researchManager.getResetStarResearchesAcceleratorPrice()) }), ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  184 */     this.A = new ComplexButton(Game.i.localeManager.i18n.get("reset").toUpperCase(), Game.i.assetManager.getLabelStyle(30), () -> {
/*      */           try {
/*      */             Research research;
/*      */             int i;
/*      */             if ((i = (research = paramResearchesScreen.selectedResearch).resetForAcceleratorsState()) == 0) {
/*      */               Array array;
/*      */               (array = new Array(ItemStack.class)).addAll(research.getCumulativePrice(0, research.getInstalledLevel(), true));
/*      */               Dialog.i().showConfirm(Game.i.localeManager.i18n.format("reset_research_confirm", new Object[] { Integer.valueOf(research.getResetPrice()) }), ());
/*      */               Dialog.i().setItemsHintForVisibleDialog(array);
/*      */             } else {
/*      */               int j;
/*      */               String str = null;
/*      */               switch (i) {
/*      */                 case 1:
/*      */                   str = Game.i.localeManager.i18n.get("reset_research_unavailable_HAS_CHILD");
/*      */                   break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 case 4:
/*      */                   str = Game.i.localeManager.i18n.get("reset_research_unavailable_STAR_BRANCH");
/*      */                   break;
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 case 5:
/*      */                   j = research.getResetPrice();
/*      */                   str = Game.i.localeManager.i18n.get("reset_research_unavailable_NOT_ENOUGH_ACCELERATORS") + " (<@time-accelerator>[#FFC107]" + j + "[])";
/*      */                   break;
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (str == null) {
/*      */                 str = Game.i.localeManager.i18n.get("reset_research_unavailable_NOT_SUITABLE");
/*      */               }
/*      */               Dialog.i().showAlert(Game.i.assetManager.replaceRegionAliasesWithChars(str));
/*      */               return;
/*      */             } 
/*  227 */           } catch (Exception exception) {
/*      */             a.e("failed to reset", new Object[] { exception });
/*      */           } 
/*      */         }); ComplexButton[] arrayOfComplexButton; byte b;
/*  231 */     for (arrayOfComplexButton = new ComplexButton[] { this.z, this.A }, b = 0; b < 2; b++) {
/*  232 */       ComplexButton complexButton; (complexButton = arrayOfComplexButton[b]).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, new Color(1.0F, 1.0F, 1.0F, 0.56F));
/*  233 */       complexButton.setLabel(74.0F, 0.0F, 184.0F, 64.0F, 16);
/*  234 */       complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-restart"), 274.0F, 12.0F, 40.0F, 40.0F);
/*  235 */       complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 22.0F, 64.0F, 338.0F, 64.0F, 338.0F, 0.0F })), 0.0F, 0.0F, 338.0F, 64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  243 */       complexButton.setBackgroundColors(MaterialColor.ORANGE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.ORANGE.P900.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.ORANGE.P700.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.GREY.P800);
/*  244 */       complexButton.setSize(338.0F, 64.0F);
/*  245 */       complexButton.setPosition(222.0F, 146.0F);
/*  246 */       this.e.addActor((Actor)complexButton);
/*      */     } 
/*      */ 
/*      */     
/*  250 */     this.n = new Group();
/*  251 */     this.n.setTransform(false);
/*  252 */     this.n.setTouchable(Touchable.enabled);
/*  253 */     this.n.setSize(338.0F, 80.0F);
/*  254 */     this.n.setPosition(40.0F, 40.0F);
/*  255 */     this.e.addActor((Actor)this.n);
/*      */     
/*  257 */     this.n.addListener((EventListener)new ClickListener(this, paramResearchesScreen)
/*      */         {
/*      */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  260 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             
/*  262 */             if (param1Int == -1) {
/*  263 */               ResearchMenu.a(this.b, true);
/*  264 */               ResearchMenu.a(this.b);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  270 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             
/*  272 */             if (param1Int == -1) {
/*  273 */               ResearchMenu.a(this.b, false);
/*  274 */               ResearchMenu.a(this.b);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  280 */             if (param1Int1 == -1) {
/*  281 */               ResearchMenu.b(this.b, true);
/*  282 */               ResearchMenu.a(this.b);
/*      */             } 
/*      */             
/*  285 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*      */           }
/*      */ 
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  290 */             if (param1Int1 == -1) {
/*  291 */               ResearchMenu.b(this.b, false);
/*  292 */               ResearchMenu.a(this.b);
/*      */             } 
/*      */             
/*  295 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*      */           }
/*      */ 
/*      */           
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  300 */             if (this.a.selectedResearch != null)
/*      */             {
/*  302 */               this.a.startSelectedResearch();
/*      */             }
/*      */           }
/*      */         });
/*      */     
/*  307 */     this.q = new Image((Drawable)Game.i.assetManager.getDrawable("ui-upgrade-button"));
/*  308 */     this.q.setSize(338.0F, 80.0F);
/*  309 */     this.n.addActor((Actor)this.q);
/*      */     
/*  311 */     this.r = new Image((Drawable)Game.i.assetManager.getDrawable("icon-research"));
/*  312 */     this.r.setSize(40.0F, 40.0F);
/*  313 */     this.r.setPosition(20.0F, 20.0F);
/*  314 */     this.n.addActor((Actor)this.r);
/*      */     
/*  316 */     this.s = new Label(Game.i.localeManager.i18n.get("do_research"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  317 */     this.s.setPosition(80.0F, 0.0F);
/*  318 */     this.s.setSize(100.0F, 80.0F);
/*  319 */     this.n.addActor((Actor)this.s);
/*      */     
/*  321 */     HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(new int[] { 66 }, 80.0F, 6.0F, 8);
/*  322 */     this.n.addActor((Actor)hotKeyHintLabel);
/*      */     
/*  324 */     this.o = new Group();
/*  325 */     this.o.setTransform(false);
/*  326 */     this.e.addActor((Actor)this.o);
/*      */     
/*  328 */     this.t = new Image((Drawable)Game.i.assetManager.getDrawable("icon-clock"));
/*  329 */     this.t.setSize(24.0F, 24.0F);
/*  330 */     this.t.setPosition(120.0F, 50.0F);
/*  331 */     this.t.setTouchable(Touchable.disabled);
/*  332 */     this.o.addActor((Actor)this.t);
/*      */     
/*  334 */     this.u = new Label("30:00:00", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  335 */     this.u.setSize(112.0F, 24.0F);
/*  336 */     this.u.setPosition(152.0F, 50.0F);
/*  337 */     this.u.setAlignment(8);
/*  338 */     this.u.setTouchable(Touchable.disabled);
/*  339 */     this.o.addActor((Actor)this.u);
/*      */ 
/*      */     
/*  342 */     this.B = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), null);
/*  343 */     this.B.setSize(180.0F, 80.0F);
/*  344 */     this.B.setPosition(380.0F, 40.0F);
/*  345 */     this.B.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 26.0F, 80.0F, 180.0F, 80.0F, 180.0F, 0.0F })), 0.0F, 0.0F, 180.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  351 */     this.B.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, MaterialColor.GREY.P900);
/*  352 */     this.B.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("research-token"), 64.0F, 8.0F, 64.0F, 64.0F);
/*  353 */     this.B.setIconLabelShadowEnabled(true);
/*  354 */     this.e.addActor((Actor)this.B);
/*      */ 
/*      */     
/*  357 */     this.p = new Group();
/*  358 */     this.p.setTransform(false);
/*  359 */     this.e.addActor((Actor)this.p);
/*      */     
/*      */     Label label;
/*  362 */     (label = new Label("for", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(70.0F, 80.0F);
/*  363 */     label.setPosition(378.0F, 40.0F);
/*  364 */     label.setAlignment(1);
/*  365 */     this.p.addActor((Actor)label);
/*      */     
/*      */     Image image2;
/*  368 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-time-accelerator"))).setSize(40.0F, 40.0F);
/*  369 */     image2.setPosition(455.0F, 60.0F);
/*  370 */     image2.setColor(MaterialColor.YELLOW.P500);
/*  371 */     this.p.addActor((Actor)image2);
/*      */     
/*  373 */     this.v = new Label("100", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), MaterialColor.YELLOW.P500));
/*  374 */     this.v.setSize(60.0F, 80.0F);
/*  375 */     this.v.setPosition(500.0F, 40.0F);
/*  376 */     this.v.setColor(MaterialColor.YELLOW.P500);
/*  377 */     this.p.addActor((Actor)this.v);
/*      */     
/*      */     Image image3;
/*  380 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(522133503));
/*  381 */     image3.setSize(520.0F, 8.0F);
/*  382 */     image3.setPosition(40.0F, 140.0F);
/*  383 */     this.p.addActor((Actor)image3);
/*      */     
/*  385 */     this.w = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  386 */     this.w.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  387 */     this.w.setSize(520.0F, 8.0F);
/*  388 */     this.w.setPosition(40.0F, 140.0F);
/*  389 */     this.p.addActor((Actor)this.w);
/*      */ 
/*      */     
/*  392 */     (label = new Label(Game.i.localeManager.i18n.get("researching..."), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setPosition(40.0F, 160.0F);
/*  393 */     label.setSize(200.0F, 30.0F);
/*  394 */     this.p.addActor((Actor)label);
/*      */     
/*      */     Image image1;
/*  397 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-clock"))).setSize(32.0F, 32.0F);
/*  398 */     image1.setPosition(420.0F, 159.0F);
/*  399 */     this.p.addActor((Actor)image1);
/*      */     
/*  401 */     this.x = new Label("00:30", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  402 */     this.x.setPosition(510.0F, 160.0F);
/*  403 */     this.x.setSize(50.0F, 30.0F);
/*  404 */     this.x.setAlignment(16);
/*  405 */     this.p.addActor((Actor)this.x);
/*      */     
/*  407 */     this.p.setVisible(false);
/*      */     
/*  409 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.H);
/*  410 */     paramResearchesScreen.addListener((ResearchesScreen.ResearchesScreenListener)this.I);
/*  411 */     Game.i.researchManager.addListener((ResearchManager.ResearchManagerListener)this.J);
/*      */   }
/*      */   
/*      */   private void a() {
/*  415 */     if (this.F) {
/*  416 */       this.q.setColor(this.E); return;
/*  417 */     }  if (this.G) {
/*  418 */       this.q.setColor(this.D); return;
/*      */     } 
/*  420 */     this.q.setColor(this.C);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float a(Array<GameValueManager.GameValueEffect> paramArray, Group paramGroup, float paramFloat) {
/*  428 */     boolean bool = true;
/*  429 */     for (Array.ArrayIterator<GameValueManager.GameValueEffect> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { GameValueManager.GameValueEffect gameValueEffect = arrayIterator.next();
/*  430 */       StringBuilder stringBuilder = Game.i.gameValueManager.getTitle(gameValueEffect.type);
/*  431 */       GameValueManager.ValueUnits valueUnits = Game.i.gameValueManager.getUnits(gameValueEffect.type);
/*      */       
/*  433 */       if (!bool) {
/*  434 */         paramFloat -= 4.0F;
/*      */       }
/*  436 */       paramFloat -= 52.0F;
/*      */       
/*  438 */       if (valueUnits == GameValueManager.ValueUnits.BOOLEAN) {
/*      */         Image image;
/*      */         
/*  441 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/*  442 */         image.setPosition(0.0F, paramFloat);
/*  443 */         image.setColor(b);
/*  444 */         paramGroup.addActor((Actor)image);
/*      */         
/*      */         LimitedWidthLabel limitedWidthLabel;
/*  447 */         (limitedWidthLabel = new LimitedWidthLabel((CharSequence)stringBuilder, 24, 18, 520.0F)).setSize(520.0F, 52.0F);
/*  448 */         limitedWidthLabel.setPosition(40.0F, paramFloat);
/*  449 */         limitedWidthLabel.setColor(MaterialColor.GREEN.P500);
/*  450 */         paramGroup.addActor((Actor)limitedWidthLabel);
/*      */       } else {
/*      */         Image image;
/*      */         
/*  454 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(455.0F, 52.0F);
/*  455 */         image.setColor(b);
/*  456 */         image.setPosition(0.0F, paramFloat);
/*  457 */         paramGroup.addActor((Actor)image);
/*      */ 
/*      */         
/*  460 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(b);
/*  461 */         image.setSize(141.0F, 52.0F);
/*  462 */         image.setPosition(459.0F, paramFloat);
/*  463 */         paramGroup.addActor((Actor)image);
/*      */         
/*      */         LimitedWidthLabel limitedWidthLabel;
/*  466 */         (limitedWidthLabel = new LimitedWidthLabel((CharSequence)stringBuilder, 24, 18, 410.0F)).setSize(410.0F, 52.0F);
/*  467 */         limitedWidthLabel.setPosition(40.0F, paramFloat);
/*  468 */         limitedWidthLabel.setColor(Color.WHITE);
/*  469 */         paramGroup.addActor((Actor)limitedWidthLabel);
/*      */         
/*  471 */         StringBuilder stringBuilder1 = Game.i.gameValueManager.formatEffectValue(gameValueEffect.delta, valueUnits);
/*      */         
/*      */         Label label;
/*  474 */         (label = new Label((CharSequence)stringBuilder1, this.g)).setSize(101.0F, 52.0F);
/*  475 */         label.setPosition(459.0F, paramFloat);
/*  476 */         label.setAlignment(16);
/*  477 */         label.setColor(MaterialColor.GREEN.P500);
/*  478 */         paramGroup.addActor((Actor)label);
/*      */       } 
/*  480 */       bool = false; }
/*      */ 
/*      */     
/*  483 */     return paramFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*      */     Research research;
/*  491 */     if ((research = Game.i.researchManager.getCurrentResearching()) == null) {
/*      */       return;
/*      */     }
/*  494 */     int i = Game.i.progressManager.countAcceleratorsNeeded((int)(Game.i.researchManager.getMillisToResearchingEnd() / 1000L));
/*  495 */     K.setLength(0);
/*  496 */     K.append(i);
/*  497 */     this.v.setText((CharSequence)K);
/*      */ 
/*      */     
/*  500 */     i = (int)(Game.i.researchManager.getMillisToResearchingEnd() / 1000L);
/*  501 */     Research.ResearchLevel researchLevel = research.levels[research.getInstalledLevel()];
/*      */     
/*  503 */     this.w.setWidth(520.0F * (1.0F - i / researchLevel.researchDuration));
/*      */ 
/*      */     
/*  506 */     this.x.setText((CharSequence)StringFormatter.digestTime(i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  513 */     if (this.d.selectedResearch != null && Game.i.researchManager.getCurrentResearching() == this.d.selectedResearch) {
/*      */       
/*  515 */       this.y += paramFloat;
/*  516 */       if (this.y > 1.0F) {
/*  517 */         b();
/*  518 */         this.y = 0.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void update() {
/*  524 */     Research research = this.d.selectedResearch;
/*      */     
/*  526 */     this.B.setVisible(false);
/*      */     
/*  528 */     if (research != null) {
/*      */       boolean bool;
/*  530 */       Array array = new Array(Label.class);
/*      */       
/*  532 */       this.A.setVisible(false);
/*  533 */       this.z.setVisible(false);
/*      */       
/*  535 */       if (research.priceInStars > 0 && Game.i.researchManager.getResetStarResearchesAcceleratorPrice() > 0) {
/*  536 */         this.z.setVisible(true);
/*  537 */       } else if (research.getInstalledLevel() > 0) {
/*  538 */         this.A.setVisible(true);
/*      */         
/*      */         int m;
/*  541 */         if ((m = research.resetForAcceleratorsState()) == 0) {
/*      */           
/*  543 */           this.A.setBackgroundColors(MaterialColor.ORANGE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.ORANGE.P900.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.ORANGE.P700.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F), MaterialColor.GREY.P800);
/*      */         } else {
/*      */           
/*  546 */           this.A.setBackgroundColors(MaterialColor.GREY.P800, MaterialColor.GREY.P900, MaterialColor.GREY.P700, Color.GRAY);
/*      */         } 
/*      */       } 
/*      */       
/*  550 */       StringBuilder stringBuilder = research.getTitle();
/*  551 */       this.i.setText((CharSequence)stringBuilder);
/*      */       
/*  553 */       this.j.setText(research.getDescription());
/*      */       
/*  555 */       int i = research.getInstalledLevel();
/*  556 */       int j = research.maxEndlessLevel;
/*  557 */       if (!DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*      */         
/*  559 */         j = research.levels.length;
/*  560 */         if (i > research.levels.length) {
/*  561 */           i = research.levels.length;
/*      */         }
/*      */       } 
/*  564 */       if (j > 1 && i > 0) {
/*      */         
/*  566 */         K.setLength(0);
/*  567 */         this.k.setText((CharSequence)K.append('L').append(i));
/*  568 */         this.k.setVisible(true);
/*      */         
/*  570 */         K.setLength(0);
/*  571 */         this.l.setText((CharSequence)K.append("Max L").append(j));
/*  572 */         this.l.setVisible(true);
/*      */       } else {
/*  574 */         this.k.setVisible(false);
/*  575 */         this.l.setVisible(false);
/*      */       } 
/*      */ 
/*      */       
/*  579 */       this.m.clearChildren();
/*  580 */       float f = 793.0F;
/*      */ 
/*      */       
/*  583 */       Array<GameValueManager.GameValueEffect> array1 = new Array();
/*  584 */       if (i == 0) {
/*      */         
/*  586 */         array1.addAll((Object[])(research.levels[0]).effects);
/*      */       } else {
/*      */         
/*  589 */         array1.addAll(research.getEffects(i));
/*      */       } 
/*      */       
/*  592 */       if (array1.size != 0) {
/*      */         Label label;
/*      */ 
/*      */         
/*  596 */         (label = new Label(Game.i.localeManager.i18n.get("effects").toUpperCase(), this.h)).setSize(520.0F, 52.0F);
/*  597 */         label.setPosition(40.0F, 741.0F);
/*  598 */         this.m.addActor((Actor)label);
/*      */         
/*  600 */         f = a(array1, this.m, 741.0F);
/*      */         
/*  602 */         if (i > 0 && !research.isMaxEndlessLevel()) {
/*      */           
/*  604 */           bool = false;
/*  605 */           array1.clear();
/*  606 */           if (research.isMaxNormalLevel() && DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*      */             
/*  608 */             bool = true;
/*  609 */             if (research.endlessLevel == null) {
/*      */               
/*  611 */               Research.ResearchLevel researchLevel = research.levels[i];
/*  612 */               array1.addAll((Object[])researchLevel.effects);
/*      */             } else {
/*  614 */               array1.addAll((Object[])research.endlessLevel.effects);
/*      */             } 
/*  616 */           } else if (!research.isMaxNormalLevel()) {
/*      */             
/*  618 */             bool = true;
/*  619 */             Research.ResearchLevel researchLevel = research.levels[i];
/*  620 */             array1.addAll((Object[])researchLevel.effects);
/*      */           } 
/*      */           
/*  623 */           if (bool) {
/*  624 */             f -= 52.0F;
/*      */             Label label1;
/*  626 */             (label1 = new Label(Game.i.localeManager.i18n.get("next_level").toUpperCase(), this.h)).setSize(520.0F, 52.0F);
/*  627 */             label1.setPosition(40.0F, f);
/*  628 */             this.m.addActor((Actor)label1);
/*      */             
/*  630 */             f = a(array1, this.m, f);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  636 */       if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*  637 */         bool = research.isMaxEndlessLevel();
/*      */       } else {
/*  639 */         bool = research.isMaxNormalLevel();
/*      */       } 
/*  641 */       if (i == 0 || !bool) {
/*      */         
/*  643 */         f -= 52.0F;
/*      */         Label label;
/*  645 */         (label = new Label(Game.i.localeManager.i18n.get("research_requirements").toUpperCase(), this.h)).setSize(520.0F, 52.0F);
/*  646 */         label.setPosition(40.0F, f);
/*  647 */         this.m.addActor((Actor)label);
/*      */         
/*  649 */         boolean bool2 = true;
/*      */         
/*  651 */         if (i == 0)
/*      */         {
/*      */           
/*  654 */           if ((i = research.linksToParents.size) != 0) {
/*      */             
/*  656 */             if (research.priceInStars > 0) {
/*  657 */               i = 1;
/*      */             }
/*      */             
/*  660 */             int m = 0;
/*      */             
/*  662 */             f -= 52.0F;
/*  663 */             bool2 = false;
/*      */             Array.ArrayIterator<Research.ResearchLink> arrayIterator;
/*  665 */             for (arrayIterator = research.linksToParents.iterator(); arrayIterator.hasNext();) {
/*  666 */               if ((researchLink = arrayIterator.next()).parent.getInstalledLevel() >= researchLink.requiredLevels) {
/*  667 */                 m++;
/*      */               }
/*      */             } 
/*      */             
/*  671 */             if (research.priceInStars > 0)
/*      */             {
/*  673 */               for (arrayIterator = research.linksToChildren.iterator(); arrayIterator.hasNext();) {
/*  674 */                 if ((researchLink = arrayIterator.next()).child.getInstalledLevel() >= researchLink.requiredLevels) {
/*  675 */                   m++;
/*      */                 }
/*      */               } 
/*      */             }
/*      */             
/*  680 */             if (m > i) {
/*  681 */               m = i;
/*      */             }
/*      */             
/*      */             Image image;
/*  685 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/*  686 */             image.setColor(b);
/*  687 */             image.setPosition(0.0F, f);
/*  688 */             this.m.addActor((Actor)image);
/*      */             
/*      */             Label label1;
/*  691 */             (label1 = new Label(Game.i.localeManager.i18n.get("previous_researches"), this.g)).setSize(410.0F, 52.0F);
/*  692 */             label1.setPosition(40.0F, f);
/*  693 */             label1.setColor(Color.WHITE);
/*  694 */             this.m.addActor((Actor)label1);
/*      */             
/*  696 */             K.setLength(0);
/*  697 */             K.append(m).append(" / ").append(i);
/*      */             
/*      */             Label label2;
/*  700 */             (label2 = new Label((CharSequence)K, this.g)).setSize(101.0F, 52.0F);
/*  701 */             label2.setPosition(459.0F, f);
/*  702 */             label2.setAlignment(16);
/*  703 */             this.m.addActor((Actor)label2);
/*      */             
/*  705 */             if (m == i) {
/*      */               
/*  707 */               label2.setColor(MaterialColor.GREEN.P500);
/*      */             } else {
/*      */               
/*  710 */               label2.setColor(MaterialColor.ORANGE.P500);
/*  711 */               array.add(label1);
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*  717 */         Array array2 = new Array(ItemStack.class);
/*  718 */         if (research.getInstalledLevel() >= research.levels.length) {
/*      */           
/*  720 */           array2.addAll(research.endlessLevel.getPrice(research.getInstalledLevel() + 1));
/*      */         } else {
/*      */           
/*  723 */           Research.ResearchLevel researchLevel = research.levels[research.getInstalledLevel()];
/*  724 */           array2.addAll(researchLevel.price);
/*      */           
/*  726 */           if (researchLevel.requirements.length != 0) {
/*      */             Requirement[] arrayOfRequirement; int m; byte b1;
/*  728 */             for (m = (arrayOfRequirement = researchLevel.requirements).length, b1 = 0; b1 < m; ) { Requirement requirement = arrayOfRequirement[b1];
/*  729 */               if (!bool2) {
/*  730 */                 f -= 4.0F;
/*      */               }
/*  732 */               f -= 52.0F;
/*  733 */               bool2 = false;
/*      */               
/*      */               Image image;
/*  736 */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/*  737 */               image.setColor(b);
/*  738 */               image.setPosition(0.0F, f);
/*  739 */               this.m.addActor((Actor)image);
/*      */               
/*      */               Label label1;
/*  742 */               (label1 = new Label((CharSequence)requirement.getTitle(true), this.g)).setSize(410.0F, 52.0F);
/*  743 */               label1.setPosition(40.0F, f);
/*  744 */               label1.setColor(Color.WHITE);
/*  745 */               this.m.addActor((Actor)label1);
/*      */               
/*      */               Label label2;
/*  748 */               (label2 = new Label((CharSequence)requirement.getFormattedValue(), this.g)).setSize(101.0F, 52.0F);
/*  749 */               label2.setPosition(459.0F, f);
/*  750 */               label2.setAlignment(16);
/*  751 */               this.m.addActor((Actor)label2);
/*      */               
/*  753 */               if (requirement.isSatisfied()) {
/*      */                 
/*  755 */                 label2.setColor(MaterialColor.GREEN.P500);
/*      */               } else {
/*      */                 
/*  758 */                 label2.setColor(MaterialColor.ORANGE.P500);
/*  759 */                 array.add(label1);
/*      */               } 
/*      */               
/*      */               b1++; }
/*      */           
/*      */           } 
/*  765 */           if (research.getInstalledLevel() == 0 && research.priceInStars > 0) {
/*  766 */             if (!bool2) {
/*  767 */               f -= 4.0F;
/*      */             }
/*  769 */             f -= 52.0F;
/*  770 */             bool2 = false;
/*      */             
/*      */             Image image;
/*  773 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/*  774 */             image.setColor(b);
/*  775 */             image.setPosition(0.0F, f);
/*  776 */             this.m.addActor((Actor)image);
/*      */             
/*      */             Label label1;
/*  779 */             (label1 = new Label(Game.i.localeManager.i18n.get("stars"), this.g)).setSize(410.0F, 52.0F);
/*  780 */             label1.setPosition(40.0F, f);
/*  781 */             label1.setColor(Color.WHITE);
/*  782 */             this.m.addActor((Actor)label1);
/*      */             
/*      */             Label label2;
/*  785 */             (label2 = new Label("", this.g)).setSize(101.0F, 52.0F);
/*  786 */             label2.setPosition(459.0F, f);
/*  787 */             label2.setAlignment(16);
/*  788 */             this.m.addActor((Actor)label2);
/*      */             
/*      */             int m;
/*  791 */             if ((m = Game.i.researchManager.getUnusedStarsCount()) >= research.priceInStars) {
/*      */               
/*  793 */               label2.setColor(MaterialColor.GREEN.P500);
/*  794 */               label2.setText(research.priceInStars + " / " + research.priceInStars);
/*      */             } else {
/*      */               
/*  797 */               label2.setColor(MaterialColor.ORANGE.P500);
/*  798 */               label2.setText(m + " / " + research.priceInStars);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  804 */         boolean bool1 = true;
/*  805 */         for (byte b = 0; b < array2.size; b++) {
/*  806 */           ItemStack itemStack = ((ItemStack[])array2.items)[b];
/*  807 */           int m = Game.i.progressManager.getItemsCount(itemStack.getItem());
/*      */           
/*  809 */           float f1 = 0.0F;
/*  810 */           if (bool1) {
/*  811 */             f -= 52.0F;
/*  812 */             if (!bool2) {
/*  813 */               f -= 4.0F;
/*      */             }
/*      */           } else {
/*  816 */             f1 = 302.0F;
/*      */           } 
/*  818 */           bool2 = false;
/*      */           
/*      */           Image image;
/*  821 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(298.0F, 52.0F);
/*  822 */           image.setColor(b);
/*  823 */           image.setPosition(f1, f);
/*  824 */           image.setTouchable(Touchable.enabled);
/*  825 */           image.addListener((EventListener)new ClickListener(this, itemStack)
/*      */               {
/*      */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  828 */                   ItemDescriptionDialog.i().show(this.a.getItem());
/*      */                 }
/*      */               });
/*  831 */           this.m.addActor((Actor)image);
/*      */           
/*      */           Actor actor;
/*  834 */           (actor = itemStack.getItem().generateIcon(40.0F, false)).setSize(40.0F, 40.0F);
/*  835 */           if (bool1) {
/*  836 */             actor.setPosition(f1 + 40.0F - 4.0F, f + 10.0F - 4.0F);
/*      */           } else {
/*  838 */             actor.setPosition(f1 + 12.0F - 4.0F, f + 10.0F - 4.0F);
/*      */           } 
/*  840 */           actor.setTouchable(Touchable.disabled);
/*  841 */           this.m.addActor(actor);
/*      */           
/*  843 */           K.setLength(0);
/*  844 */           K.append(StringFormatter.compactNumber(m, false));
/*  845 */           K.append(" / ");
/*  846 */           K.append(StringFormatter.compactNumber(itemStack.getCount(), false));
/*      */           
/*  848 */           Label label1 = new Label((CharSequence)K, this.g);
/*  849 */           if (itemStack.getCount() > m) {
/*  850 */             label1.setColor(MaterialColor.ORANGE.P500);
/*      */           } else {
/*  852 */             label1.setColor(Color.WHITE);
/*      */           } 
/*  854 */           if (bool1) {
/*  855 */             label1.setSize(286.0F, 52.0F);
/*      */           } else {
/*  857 */             label1.setSize(258.0F, 52.0F);
/*      */           } 
/*  859 */           label1.setPosition(f1, f);
/*  860 */           label1.setAlignment(16);
/*  861 */           label1.setTouchable(Touchable.disabled);
/*  862 */           this.m.addActor((Actor)label1);
/*      */           
/*  864 */           bool1 = !bool1 ? true : false;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  874 */       this.s.setPosition(80.0F, 0.0F);
/*  875 */       if (Game.i.researchManager.getCurrentResearching() == research) {
/*      */         
/*  877 */         this.o.setVisible(false);
/*  878 */         this.p.setVisible(true);
/*      */ 
/*      */         
/*  881 */         this.C = MaterialColor.YELLOW.P900;
/*  882 */         this.E = MaterialColor.AMBER.P900;
/*  883 */         this.D = MaterialColor.YELLOW.P800;
/*      */         
/*  885 */         this.r.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-time-accelerator"));
/*  886 */         this.s.setText(Game.i.localeManager.i18n.get("finish_now").toUpperCase());
/*      */         
/*  888 */         this.n.setVisible(true);
/*      */         
/*  890 */         b();
/*      */       } else {
/*      */         
/*  893 */         this.p.setVisible(false);
/*      */ 
/*      */         
/*  896 */         if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*  897 */           bool = research.isMaxEndlessLevel();
/*      */         } else {
/*  899 */           bool = research.isMaxNormalLevel();
/*      */         } 
/*      */         
/*  902 */         if (!bool) {
/*      */           
/*  904 */           this.o.setVisible(true);
/*  905 */           this.n.setVisible(true);
/*      */           
/*  907 */           if (Game.i.researchManager.canStartResearching(research, false)) {
/*  908 */             this.C = MaterialColor.LIGHT_BLUE.P800;
/*  909 */             this.E = MaterialColor.LIGHT_BLUE.P900;
/*  910 */             this.D = MaterialColor.LIGHT_BLUE.P700;
/*      */           } else {
/*      */             
/*  913 */             this.C = MaterialColor.RED.P800;
/*  914 */             this.E = MaterialColor.RED.P900;
/*  915 */             this.D = MaterialColor.RED.P700;
/*      */           } 
/*      */           
/*  918 */           this.r.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-research"));
/*  919 */           if (research.getInstalledLevel() == 0) {
/*      */             
/*  921 */             this.s.setText(Game.i.localeManager.i18n.get("do_research").toUpperCase());
/*      */           } else {
/*      */             
/*  924 */             this.s.setText(Game.i.localeManager.i18n.get("do_research").toUpperCase() + " L" + (research.getInstalledLevel() + 1));
/*      */           } 
/*      */           
/*  927 */           if (research.levels.length > research.getInstalledLevel()) {
/*      */             Research.ResearchLevel researchLevel;
/*      */             
/*  930 */             if ((researchLevel = research.levels[research.getInstalledLevel()]).researchDuration <= 0) {
/*  931 */               this.u.setVisible(false);
/*  932 */               this.t.setVisible(false);
/*      */             } else {
/*  934 */               this.u.setVisible(true);
/*  935 */               this.t.setVisible(true);
/*  936 */               this.u.setText((CharSequence)StringFormatter.digestTime(researchLevel.researchDuration));
/*      */               
/*  938 */               this.s.setPosition(80.0F, 10.0F);
/*      */             } 
/*      */           } else {
/*      */             
/*  942 */             this.u.setVisible(false);
/*  943 */             this.t.setVisible(false);
/*      */           } 
/*      */ 
/*      */           
/*  947 */           if (Game.i.researchManager.canResearchForToken(research, true)) {
/*      */             
/*  949 */             this.B.setVisible(true);
/*  950 */             if (Game.i.progressManager.getItemsCount((Item)Item.D.RESEARCH_TOKEN) > 0) {
/*      */               
/*  952 */               if (Game.i.researchManager.canResearchForToken(research, false)) {
/*      */                 
/*  954 */                 this.B.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  955 */                 this.B.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, Color.WHITE);
/*  956 */                 this.B.setClickHandler(() -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("research_for_token_confirm"), ()));
/*      */               
/*      */               }
/*      */               else {
/*      */ 
/*      */                 
/*  962 */                 this.B.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  963 */                 this.B.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.28F), Color.WHITE);
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  968 */                 this.B.setClickHandler(() -> {
/*      */                       for (byte b = 0; b < paramArray.size; b++) {
/*      */                         ((Label)paramArray.get(b)).clearActions();
/*      */ 
/*      */ 
/*      */                         
/*      */                         ((Label)paramArray.get(b)).addAction((Action)Actions.sequence((Action)Actions.alpha(0.3F, 0.25F), (Action)Actions.alpha(1.0F, 0.25F), (Action)Actions.alpha(0.3F, 0.25F), (Action)Actions.alpha(1.0F, 0.25F)));
/*      */                       } 
/*      */ 
/*      */ 
/*      */                       
/*      */                       Notifications.i().add(Game.i.localeManager.i18n.get("start_research_fail_reason_REQUIREMENT_NOT_SATISFIED"), null, null, StaticSoundType.FAIL);
/*      */                     });
/*      */               } 
/*      */             } else {
/*  983 */               this.B.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  984 */               this.B.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.28F), Color.WHITE);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  989 */               this.B.setClickHandler(() -> Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_tokens"), null, null, StaticSoundType.FAIL));
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/*  994 */           this.o.setVisible(false);
/*  995 */           if (research.type == ResearchType.DEVELOPER_MODE) {
/*      */             
/*  997 */             this.C = MaterialColor.RED.P800;
/*  998 */             this.E = MaterialColor.RED.P900;
/*  999 */             this.D = MaterialColor.RED.P700;
/*      */             
/* 1001 */             this.r.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 1002 */             this.s.setText(Game.i.localeManager.i18n.get("disable").toUpperCase());
/*      */             
/* 1004 */             this.n.setVisible(true);
/*      */           } else {
/* 1006 */             this.n.setVisible(false);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1011 */       a();
/*      */       TowerType[] arrayOfTowerType;
/*      */       int k;
/* 1014 */       for (k = (arrayOfTowerType = TowerType.values).length, i = 0; i < k; ) { Label label; TowerType towerType = arrayOfTowerType[i];
/* 1015 */         if (research.levels.length == 1 && (research.levels[0]).effects.length == 1 && ((research.levels[0]).effects[0]).type == Game.i.towerManager.getTowerGameValueType(towerType)) {
/*      */           
/* 1017 */           GameValueManager.GameValuesSnapshot gameValuesSnapshot = GameValueManager.createSnapshot(null, Game.i.progressManager
/*      */               
/* 1019 */               .getDifficultyMode(), false, null, true, false, new ProgressManager.ProgressSnapshotForState());
/*      */ 
/*      */           
/*      */           int m;
/*      */           
/*      */           TowerStatType[] arrayOfTowerStatType1, arrayOfTowerStatType2;
/*      */           
/*      */           byte b;
/*      */           
/* 1028 */           for (m = (arrayOfTowerStatType2 = arrayOfTowerStatType1 = Game.i.towerManager.getStatTypes(towerType)).length, b = 0; b < m; ) { TowerStatType towerStatType = arrayOfTowerStatType2[b];
/* 1029 */             TowerStatManager.TowerStat towerStat = Game.i.towerStatManager.getInstance(towerStatType);
/*      */             
/* 1031 */             float f1 = Game.i.towerManager.getStatFromConfig(towerType, towerStatType, 0, 1, (GameValueProvider)Game.i.gameValueManager.getSnapshot());
/* 1032 */             float f2 = Game.i.towerManager.getStatFromConfig(towerType, towerStatType, 0, 1, (GameValueProvider)gameValuesSnapshot);
/*      */             
/* 1034 */             float f3 = 0.0F; TowerType[] arrayOfTowerType1; int n; byte b1;
/* 1035 */             for (n = (arrayOfTowerType1 = TowerType.values).length, b1 = 0; b1 < n; ) { TowerType towerType1 = arrayOfTowerType1[b1]; float f6;
/* 1036 */               if (Game.i.towerManager.hasStat(towerType1, towerStatType) && (
/*      */                 
/* 1038 */                 f6 = Game.i.towerManager.getStatFromConfig(towerType1, towerStatType, 0, 1, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) > f3) {
/* 1039 */                 f3 = f6;
/*      */               }
/*      */               
/*      */               b1++; }
/*      */             
/* 1044 */             f -= 52.0F;
/*      */             
/*      */             Group group;
/* 1047 */             (group = new Group()).setSize(600.0F, 48.0F);
/* 1048 */             group.setPosition(0.0F, f);
/* 1049 */             this.m.addActor((Actor)group);
/*      */ 
/*      */ 
/*      */             
/*      */             Image image2;
/*      */ 
/*      */ 
/*      */             
/* 1057 */             (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setHeight(48.0F);
/*      */             float f4;
/* 1059 */             if ((f4 = f2 / f3 * 600.0F) > 600.0F) f4 = 600.0F; 
/* 1060 */             image2.setWidth(f4);
/* 1061 */             image2.setColor(towerStat.getColor());
/* 1062 */             (image2.getColor()).a = 0.42F;
/* 1063 */             group.addActor((Actor)image2);
/*      */             
/*      */             Image image3;
/* 1066 */             (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setHeight(48.0F);
/*      */             float f5;
/* 1068 */             if ((f5 = f1 / f3 * 600.0F) > 600.0F) f5 = 600.0F; 
/* 1069 */             image3.setWidth(f5 - f4);
/* 1070 */             image3.setPosition(f4, 0.0F);
/* 1071 */             image3.setColor(towerStat.getColor());
/* 1072 */             (image3.getColor()).a = 0.78F;
/* 1073 */             group.addActor((Actor)image3);
/*      */             
/*      */             Image image1;
/* 1076 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(towerStat.getIconDrawableAlias()))).setSize(32.0F, 32.0F);
/* 1077 */             image1.setPosition(48.0F, 8.0F);
/* 1078 */             group.addActor((Actor)image1);
/*      */             
/*      */             Label label2;
/* 1081 */             (label2 = new Label(towerStat.getName(), Game.i.assetManager.getLabelStyle(21))).setPosition(104.0F, 0.0F);
/* 1082 */             label2.setSize(320.0F, 48.0F);
/* 1083 */             label2.setWrap(true);
/* 1084 */             group.addActor((Actor)label2);
/*      */             
/*      */             Table table;
/* 1087 */             (table = new Table()).setPosition(0.0F, 0.0F);
/* 1088 */             table.setSize(560.0F, 48.0F);
/* 1089 */             group.addActor((Actor)table);
/*      */             
/* 1091 */             table.add().height(64.0F).expandX().fillX();
/*      */             
/* 1093 */             label = new Label(StringFormatter.compactNumber(f2, true) + " ->  ", Game.i.assetManager.getLabelStyle(21));
/* 1094 */             table.add((Actor)label).height(48.0F);
/* 1095 */             label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */             
/* 1097 */             Label label1 = new Label((CharSequence)StringFormatter.compactNumber(f1, true), Game.i.assetManager.getLabelStyle(24));
/* 1098 */             table.add((Actor)label1).height(48.0F);
/*      */             
/* 1100 */             if ((Game.i.towerManager.getStatConfig(towerType, towerStatType)).unique) {
/* 1101 */               (image2.getColor()).a = 0.28F;
/* 1102 */               (image3.getColor()).a = 0.42F;
/* 1103 */               image1.setColor(MaterialColor.AMBER.P600);
/* 1104 */               label2.setColor(MaterialColor.AMBER.P600);
/*      */             } 
/*      */             b++; }
/*      */           
/*      */           break;
/*      */         } 
/*      */         label++; }
/*      */       
/* 1112 */       if (research.type == ResearchType.ROOT) {
/*      */         
/* 1114 */         f -= 52.0F;
/*      */         
/* 1116 */         K.setLength(0);
/*      */         
/* 1118 */         int m = 0;
/* 1119 */         k = 0;
/*      */         
/* 1121 */         boolean bool1 = DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode());
/* 1122 */         array1 = Game.i.researchManager.getInstances();
/* 1123 */         for (byte b = 0; b < array1.size; b++) {
/*      */           Research research1;
/* 1125 */           if ((research1 = (Research)array1.get(b)).priceInStars == 0 && 
/* 1126 */             research1.type != ResearchType.DEVELOPER_MODE)
/*      */           {
/* 1128 */             if (bool1) {
/* 1129 */               m += research1.getInstalledLevel();
/* 1130 */               k += research1.getMaxLevel();
/*      */             } else {
/* 1132 */               m += Math.min(research1.getMaxRegularLevel(), research1.getInstalledLevel());
/* 1133 */               k += research1.getMaxRegularLevel();
/*      */             } 
/*      */           }
/*      */         } 
/* 1137 */         float f1 = m / k;
/*      */         
/*      */         Image image2;
/* 1140 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 1141 */         image2.setPosition(0.0F, f);
/* 1142 */         this.m.addActor((Actor)image2);
/*      */         
/*      */         Image image3;
/* 1145 */         (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F * f1, 52.0F);
/* 1146 */         image3.setPosition(0.0F, f);
/* 1147 */         this.m.addActor((Actor)image3);
/*      */         
/* 1149 */         if (bool1) {
/* 1150 */           image2.setColor(MaterialColor.DEEP_ORANGE.P900.cpy().lerp(Color.BLACK, 0.1F));
/* 1151 */           image3.setColor(MaterialColor.DEEP_ORANGE.P800);
/*      */         } else {
/* 1153 */           image2.setColor(MaterialColor.BLUE.P900.cpy().lerp(Color.BLACK, 0.1F));
/* 1154 */           image3.setColor(MaterialColor.BLUE.P800);
/*      */         } 
/*      */         
/* 1157 */         K.append(StringFormatter.commaSeparatedNumber(m)).append(" / ").append(StringFormatter.commaSeparatedNumber(k));
/*      */         
/*      */         Image image1;
/* 1160 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-research"))).setSize(32.0F, 32.0F);
/* 1161 */         image1.setPosition(40.0F, f + 10.0F);
/* 1162 */         this.m.addActor((Actor)image1);
/*      */         
/*      */         Label label1;
/* 1165 */         (label1 = new Label(Game.i.progressManager.getDifficultyName(Game.i.progressManager.getDifficultyMode()), this.g)).setPosition(84.0F, f);
/* 1166 */         label1.setSize(100.0F, 52.0F);
/* 1167 */         this.m.addActor((Actor)label1);
/*      */         
/*      */         Label label2;
/* 1170 */         (label2 = new Label((CharSequence)K, this.g)).setSize(101.0F, 52.0F);
/* 1171 */         label2.setPosition(459.0F, f);
/* 1172 */         label2.setAlignment(16);
/* 1173 */         this.m.addActor((Actor)label2);
/*      */         
/* 1175 */         this.A.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1181 */     if (this.f != paramBoolean) {
/* 1182 */       this.f = paramBoolean;
/* 1183 */       if (paramBoolean) {
/* 1184 */         this.e.show();
/* 1185 */         update(); return;
/*      */       } 
/* 1187 */       this.e.hide();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1194 */     this.c.removeListener((SideMenu.SideMenuListener)this.H);
/* 1195 */     this.d.removeListener((ResearchesScreen.ResearchesScreenListener)this.I);
/* 1196 */     Game.i.researchManager.removeListener((ResearchManager.ResearchManagerListener)this.J);
/*      */   }
/*      */   
/*      */   private class _SideMenuListener extends SideMenu.SideMenuListener.SideMenuListenerAdapter { private _SideMenuListener(ResearchMenu this$0) {}
/*      */     
/*      */     public void offscreenChanged() {
/* 1202 */       this.a.update();
/*      */     } }
/*      */   
/*      */   private class _ResearchesScreenListener extends ResearchesScreen.ResearchesScreenListener.ResearchesScreenListenerAdapter {
/*      */     private _ResearchesScreenListener(ResearchMenu this$0) {}
/*      */     
/*      */     public void selectedResearchChanged() {
/* 1209 */       if ((ResearchMenu.b(this.a)).selectedResearch == null) {
/* 1210 */         ResearchMenu.c(this.a, false); return;
/*      */       } 
/* 1212 */       ResearchMenu.c(this.a, true);
/* 1213 */       this.a.update();
/*      */     }
/*      */   }
/*      */   
/*      */   private class _ResearchManagerListener extends ResearchManager.ResearchManagerListener.ResearchManagerListenerAdapter {
/*      */     private _ResearchManagerListener(ResearchMenu this$0) {}
/*      */     
/*      */     public void researchesUpdated() {
/* 1221 */       this.a.update();
/*      */     }
/*      */ 
/*      */     
/*      */     public void researchStarted(Research param1Research, long param1Long) {
/* 1226 */       this.a.update();
/*      */     }
/*      */ 
/*      */     
/*      */     public void researchCompleted(Research param1Research) {
/* 1231 */       this.a.update();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\ResearchMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */