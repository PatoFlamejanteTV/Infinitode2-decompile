/*      */ package com.prineside.tdi2.screens;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.LongArray;
/*      */ import com.badlogic.gdx.utils.ShortArray;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.managers.AssetManager;
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
/*      */ import com.prineside.tdi2.scene2d.ui.Widget;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.shared.BackButton;
/*      */ import com.prineside.tdi2.utils.BitVector;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.LinkedList;
/*      */ import java.util.concurrent.Executors;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.ThreadPoolExecutor;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ 
/*      */ public class TicTacToeScreen
/*      */   extends Screen {
/*   49 */   private static final TLog a = TLog.forClass(TicTacToeScreen.class);
/*      */ 
/*      */   
/*      */   public static boolean LOG_AI_ACTIONS = true;
/*      */ 
/*      */   
/*      */   public static boolean PRINT_AI_ACTIONS = true;
/*      */ 
/*      */   
/*   58 */   private static final Color b = MaterialColor.LIGHT_GREEN.P500;
/*   59 */   private static final Color c = MaterialColor.LIGHT_BLUE.P500;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   78 */   private final Ai[] d = new Ai[20];
/*   79 */   private final Rules[] e = new Rules[20]; private boolean f; private Ai g; private double h; private int i; private int j; private byte k; private final UiManager.UiLayer l; private final UiManager.UiLayer m; private Rules n; private byte o; private static GameReplay p; private final Array<GameReplay> q; private Board r; private Board s; private final Array<Label> t; private final Array<EndGameResult> u; private final int[] v; private final Table w; private final Label x; public TicTacToeScreen() {
/*   80 */     for (byte b = 0; b < 20; b++) {
/*      */       float f;
/*      */       
/*   83 */       if ((f = b / 19.0F) <= 0.3F) {
/*   84 */         float f1 = f / 0.3F;
/*   85 */         this.d[b] = new AiMixin(new Level3Ai((byte)2, (byte)0), 1.0F - f1, new Level4Ai((byte)2), f1);
/*   86 */       } else if (f <= 0.6F) {
/*   87 */         float f1 = (f - 0.3F) / 0.3F;
/*   88 */         this.d[b] = new AiMixin(new Level4Ai((byte)2), 1.0F - f1, new Level5Ai((byte)2), f1);
/*      */       } else {
/*   90 */         this.d[b] = new Level5Ai((byte)2);
/*      */       } 
/*   92 */       this.d[b] = new Level5Ai((byte)2);
/*      */       
/*   94 */       switch (b) { case 0: case 1:
/*      */         case 2:
/*   96 */           this.e[b] = new Rules((short)3, (short)3); break;
/*      */         case 3: case 4:
/*   98 */           this.e[b] = new Rules((short)5, (short)4); break;
/*      */         case 5: case 6: case 7:
/*  100 */           this.e[b] = new Rules((short)5, (short)4); break;
/*      */         case 8: case 9: case 10:
/*  102 */           this.e[b] = new Rules((short)6, (short)4); break;
/*      */         case 11: case 12:
/*  104 */           this.e[b] = new Rules((short)7, (short)4); break;
/*      */         case 13: case 14: case 15:
/*  106 */           this.e[b] = new Rules((short)8, (short)5); break;
/*      */         case 16: case 17: case 18: case 19:
/*  108 */           this.e[b] = new Rules((short)9, (short)5); break; }
/*      */       
/*  110 */       this.e[b] = new Rules((short)6, (short)4);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  115 */     this.f = false;
/*      */     
/*  117 */     this.g = null;
/*      */     
/*  119 */     this.h = 0.0D;
/*  120 */     this.i = 0;
/*      */     
/*  122 */     this.j = 0;
/*      */ 
/*      */     
/*  125 */     this.l = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 99, "TicTacToeScreen main");
/*  126 */     this.m = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "TicTacToeScreen main");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  131 */     this.q = new Array(true, 1, GameReplay.class);
/*      */ 
/*      */ 
/*      */     
/*  135 */     this.t = new Array(true, 8, Label.class);
/*  136 */     this.u = new Array(true, 8, EndGameResult.class);
/*  137 */     this.v = new int[3];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  167 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     
/*  169 */     Game.i.uiManager.hideAllComponents();
/*  170 */     Game.i.uiManager.setAsInputHandler();
/*      */     
/*  172 */     BackButton.i()
/*  173 */       .setVisible(true)
/*  174 */       .setText(null)
/*  175 */       .setClickHandler(this::h);
/*      */ 
/*      */     
/*  178 */     Level1Ai.a().setSeed(9001L);
/*  179 */     this.O = new Thread(() -> {
/*      */           while (true) {
/*      */             if (this.P != null) {
/*      */               long l1 = Game.getRealTickCount();
/*      */               
/*      */               this.s.copyFieldFrom(this.r);
/*      */               
/*      */               short s = this.P.makeMove(this.s);
/*      */               long l2 = Game.getRealTickCount() - l1;
/*      */               this.P = null;
/*      */               AiRunResult aiRunResult;
/*      */               (aiRunResult = new AiRunResult()).c = l2;
/*      */               aiRunResult.a = s;
/*      */               if (s < 0 || s >= this.r.cellCount) {
/*      */                 aiRunResult.b = "incorrect cell index " + s;
/*      */               } else if (this.r.getCell(s) != 0) {
/*      */                 aiRunResult.b = "cell " + s + " already occupied by " + ((this.r.getCell(s) == 1) ? "cross" : "circle");
/*      */               } 
/*      */               this.Q.accept(aiRunResult);
/*      */             } 
/*      */             try {
/*      */               Thread.sleep(2L);
/*  201 */             } catch (InterruptedException interruptedException) {
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }"TicTacToe AI");
/*  206 */     this.O.setDaemon(true);
/*  207 */     this.O.start();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  212 */     Table table1 = new Table();
/*  213 */     Table table2 = new Table();
/*  214 */     table1.add((Actor)table2).width(600.0F).padLeft(20.0F).padTop(20.0F).row();
/*  215 */     table1.add().growY().row();
/*      */     
/*  217 */     Widget widget = new Widget(this)
/*      */       {
/*      */         public void draw(Batch param1Batch, float param1Float) {
/*  220 */           validate();
/*      */           
/*  222 */           param1Float = getX();
/*  223 */           float f = getY();
/*      */ 
/*      */ 
/*      */           
/*  227 */           ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).blank;
/*      */           
/*  229 */           for (byte b = 0; b < (TicTacToeScreen.a(this.j)).size; b++) {
/*      */             TicTacToeScreen.EndGameResult endGameResult;
/*  231 */             if ((endGameResult = ((TicTacToeScreen.EndGameResult[])(TicTacToeScreen.a(this.j)).items)[b]).a == 1) {
/*  232 */               param1Batch.setColor(TicTacToeScreen.a());
/*  233 */             } else if (endGameResult.a == 2) {
/*  234 */               param1Batch.setColor(TicTacToeScreen.b());
/*      */             } else {
/*  236 */               param1Batch.setColor(0.28F, 0.28F, 0.28F, 1.0F);
/*      */             } 
/*  238 */             param1Batch.draw((TextureRegion)atlasTextureRegion, param1Float + 6.0F * b, f, 5.0F, (float)(endGameResult.b / 20.0D) * 150.0F);
/*      */           } 
/*  240 */           param1Batch.setColor(Color.WHITE);
/*      */         }
/*      */       };
/*  243 */     table2.add((Actor)widget).size(600.0F, 150.0F).row();
/*      */     
/*  245 */     Table table3 = new Table();
/*  246 */     table2.add((Actor)table3).width(600.0F).padTop(20.0F);
/*      */     
/*  248 */     this.x = new Label("0", Game.i.assetManager.getLabelStyle(30));
/*  249 */     this.x.setAlignment(1);
/*  250 */     this.x.setColor(b);
/*  251 */     table3.add((Actor)this.x).width(200.0F);
/*      */     
/*  253 */     this.z = new Label("0", Game.i.assetManager.getLabelStyle(30));
/*  254 */     this.z.setAlignment(1);
/*  255 */     this.z.setColor(new Color(0.56F, 0.56F, 0.56F, 1.0F));
/*  256 */     table3.add((Actor)this.z).width(200.0F);
/*      */     
/*  258 */     this.y = new Label("0", Game.i.assetManager.getLabelStyle(30));
/*  259 */     this.y.setAlignment(1);
/*  260 */     this.y.setColor(c);
/*  261 */     table3.add((Actor)this.y).width(200.0F);
/*      */     
/*  263 */     table3.row();
/*      */     
/*      */     Label label;
/*  266 */     (label = new Label("Player", Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  267 */     table3.add((Actor)label);
/*      */ 
/*      */     
/*  270 */     (label = new Label("Draws", Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  271 */     table3.add((Actor)label);
/*      */ 
/*      */     
/*  274 */     (label = new Label("Ensor", Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  275 */     table3.add((Actor)label);
/*      */     
/*  277 */     this.A = new Table();
/*  278 */     table1.add((Actor)this.A).width(600.0F);
/*  279 */     this.l.getTable().add((Actor)table1).padLeft(20.0F).padBottom(180.0F).width(600.0F).growY();
/*  280 */     this.l.getTable().add().grow();
/*      */     
/*  282 */     this.I = (Drawable)Game.i.assetManager.getDrawable("icon-minus");
/*  283 */     this.J = (Drawable)Game.i.assetManager.getDrawable("icon-plus");
/*      */     
/*  285 */     this.C = new Label("", Game.i.assetManager.getDebugLabelStyle());
/*  286 */     this.C.setColor(MaterialColor.LIGHT_GREEN.P500);
/*  287 */     this.C.setAlignment(1);
/*  288 */     this.m.getTable().add((Actor)this.C).padBottom(15.0F).row();
/*      */     
/*  290 */     this.D = new Label("", Game.i.assetManager.getDebugLabelStyle());
/*  291 */     this.m.getTable().add((Actor)this.D).padBottom(15.0F).row();
/*      */     
/*  293 */     this.B = new Image((Drawable)Game.i.assetManager.getDrawable("icon-sand-clock"));
/*  294 */     this.B.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/*      */     Group group;
/*  296 */     (group = new Group()).addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/*  297 */     this.B.setSize(32.0F, 32.0F);
/*  298 */     this.B.setOrigin(16.0F, 16.0F);
/*  299 */     group.setOrigin(16.0F, 16.0F);
/*  300 */     group.addActor((Actor)this.B);
/*  301 */     this.m.getTable().add((Actor)group).padBottom(15.0F).size(32.0F).row();
/*      */     
/*  303 */     this.w = new Table();
/*  304 */     this.m.getTable().add((Actor)this.w).row();
/*      */ 
/*      */     
/*  307 */     this.H = new Table();
/*  308 */     this.m.getTable().add((Actor)this.H).padTop(15.0F).row();
/*      */     
/*  310 */     RectButton rectButton = new RectButton("New game", Game.i.assetManager.getDebugLabelStyle(), () -> {
/*      */           if (e()) {
/*      */             c(0);
/*      */           }
/*      */         });
/*  315 */     this.H.add((Actor)rectButton).width(128.0F).height(48.0F);
/*  316 */     this.H.setVisible(false);
/*      */     
/*  318 */     c(0);
/*  319 */     g();
/*      */   }
/*      */   private final Label y; private final Label z; private final Table A; private final Image B; private final Label C; private final Label D; private Image[] E; private Image[] F; private static float[] G; private final Table H; private final Drawable I; private final Drawable J; private Ai K; private long L; private long M; private long N; private final Thread O; private Ai P; private ObjectConsumer<AiRunResult> Q;
/*      */   
/*      */   private static void b(int paramInt) {
/*  324 */     if (paramInt < 0 || paramInt >= G.length)
/*  325 */       return;  G[paramInt] = 1.0F;
/*      */   }
/*      */   
/*      */   private boolean e() {
/*  329 */     return (this.h < 20.0D);
/*      */   }
/*      */   
/*      */   private void f() {
/*  333 */     if (this.n.fieldSize <= 8) {
/*  334 */       this.r = new FixedSizeSmallBoard(this.n);
/*  335 */       this.s = new FixedSizeSmallBoard(this.n);
/*      */     } else {
/*  337 */       this.r = new DynamicSizeBoard(this.n);
/*  338 */       this.s = new DynamicSizeBoard(this.n);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  346 */     this.E = new Image[this.n.fieldSize * this.n.fieldSize];
/*  347 */     this.F = new Image[this.n.fieldSize * this.n.fieldSize];
/*  348 */     G = new float[this.n.fieldSize * this.n.fieldSize];
/*  349 */     for (short s = 0; s < this.E.length; s = (short)(s + 1)) {
/*  350 */       short s1 = s;
/*  351 */       this.E[s] = new Image();
/*  352 */       this.E[s].setTouchable(Touchable.enabled);
/*  353 */       this.E[s].addListener((EventListener)new ClickListener(this, s1)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  356 */               if (TicTacToeScreen.b(this.b) == 2 && 
/*  357 */                 TicTacToeScreen.c(this.b).getCell(this.a) == 0) {
/*  358 */                 TicTacToeScreen.c(this.b).setCell(this.a, (byte)1);
/*  359 */                 (TicTacToeScreen.c()).a.add(new IntPair(this.a, 1));
/*  360 */                 TicTacToeScreen.d().i("player made manual move in " + ((float)(Game.getRealTickCount() - TicTacToeScreen.d(this.b)) * 0.001F) + " ms", new Object[0]);
/*  361 */                 TicTacToeScreen.a(this.b, Game.getRealTickCount() - TicTacToeScreen.d(this.b));
/*  362 */                 TicTacToeScreen.a(this.b, 1);
/*      */               } 
/*      */             }
/*      */           });
/*      */ 
/*      */       
/*  368 */       this.F[s] = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  369 */       this.F[s].setColor(MaterialColor.LIGHT_BLUE.P900);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  376 */     TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable("blank");
/*      */     
/*  378 */     this.w.clear();
/*  379 */     for (byte b = 0; b < this.n.fieldSize; b++) {
/*  380 */       byte b1; for (b1 = 0; b1 < this.n.fieldSize; b1++) {
/*  381 */         int i = a(b1, b);
/*      */         
/*      */         Group group;
/*  384 */         (group = new Group()).setTransform(false);
/*      */         
/*  386 */         this.F[i].setSize(64.0F, 64.0F);
/*  387 */         (this.F[i].getColor()).a = 0.0F;
/*  388 */         group.addActor((Actor)this.F[i]);
/*      */         
/*      */         Label label;
/*  391 */         (label = new Label(i, Game.i.assetManager.getDebugLabelStyle())).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  392 */         label.setSize(64.0F, 64.0F);
/*  393 */         label.setAlignment(1);
/*  394 */         group.addActor((Actor)label);
/*      */         
/*  396 */         this.E[i].setSize(48.0F, 48.0F);
/*  397 */         this.E[i].setOrigin(24.0F, 24.0F);
/*  398 */         this.E[i].setPosition(8.0F, 8.0F);
/*  399 */         group.addActor((Actor)this.E[i]);
/*  400 */         this.w.add((Actor)group).size(64.0F);
/*  401 */         if (b1 != this.n.fieldSize - 1) {
/*      */           Image image;
/*  403 */           (image = new Image((Drawable)textureRegionDrawable)).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  404 */           this.w.add((Actor)image).width(2.0F).height(64.0F);
/*      */         } 
/*      */       } 
/*  407 */       this.w.row();
/*  408 */       if (b != this.n.fieldSize - 1) {
/*  409 */         for (b1 = 0; b1 < this.n.fieldSize; b1++) {
/*      */           Image image;
/*  411 */           (image = new Image((Drawable)textureRegionDrawable)).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  412 */           this.w.add((Actor)image).size(64.0F, 2.0F);
/*  413 */           if (b1 != this.n.fieldSize - 1) {
/*      */             
/*  415 */             (image = new Image((Drawable)textureRegionDrawable)).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  416 */             this.w.add((Actor)image).width(2.0F).height(2.0F);
/*      */           } 
/*      */         } 
/*  419 */         this.w.row();
/*      */       } 
/*      */     }  } private void c(int paramInt) { Image[] arrayOfImage;
/*      */     int i;
/*      */     byte b;
/*      */     double d;
/*  425 */     Game.i.assertInMainThread();
/*      */     
/*  427 */     this.j = paramInt;
/*      */     
/*  429 */     switch (this.j) {
/*      */       case 0:
/*  431 */         this.i++;
/*  432 */         this.N = 0L;
/*  433 */         this.M = 0L;
/*      */         
/*  435 */         this.n = this.e[(int)this.h];
/*  436 */         p = new GameReplay((byte)0);
/*      */ 
/*      */         
/*  439 */         this.o = (this.o == 1) ? 2 : 1;
/*      */         
/*  441 */         f();
/*  442 */         this.D.setText("Game starts");
/*  443 */         this.H.setVisible(false);
/*      */         
/*  445 */         for (i = (arrayOfImage = this.E).length, b = 0; b < i; b++) {
/*  446 */           Image image; (image = arrayOfImage[b]).clearActions();
/*  447 */           image.addAction(
/*  448 */               (Action)Actions.scaleTo(1.0F, 1.0F));
/*      */         } 
/*      */ 
/*      */         
/*  452 */         this.K = this.d[(int)this.h];
/*      */ 
/*      */         
/*  455 */         GameReplay.a(p, "using ai: " + this.K);
/*      */         
/*  457 */         g();
/*  458 */         a("Round " + this.i + ": " + ((this.o == 2) ? "Ensor" : "Player") + " moves first");
/*      */         return;
/*      */ 
/*      */       
/*      */       case 1:
/*  463 */         this.D.setText("Ensor's move");
/*  464 */         k();
/*      */         return;
/*      */       
/*      */       case 2:
/*  468 */         this.D.setText("Player's move");
/*  469 */         k();
/*  470 */         this.L = Game.getRealTickCount();
/*      */         return;
/*      */       
/*      */       case 3:
/*  474 */         this.D.setText("Ensor's AI running");
/*      */         return;
/*      */       
/*      */       case 4:
/*  478 */         this.D.setText("Player's AI running");
/*      */         return;
/*      */       
/*      */       case 5:
/*  482 */         this.D.setText("Game over, " + ((this.k == 0) ? "tie" : ((this.k == 1) ? "player wins" : "Ensor wins")));
/*  483 */         a.i("player sum time: " + this.N, new Object[0]);
/*  484 */         a.i("ensor sum time: " + this.M, new Object[0]);
/*      */ 
/*      */         
/*  487 */         d = 0.0D;
/*  488 */         if (this.k == 2) {
/*  489 */           a("Round " + this.i + ": [#FF9800]Ensor[] wins");
/*  490 */           d = -0.4D;
/*  491 */         } else if (this.k == 1) {
/*  492 */           a("Round " + this.i + ": [#8BC34A]Player[] wins");
/*  493 */           d = 1.0D;
/*      */           
/*  495 */           this.q.add(p);
/*  496 */           if (this.q.size > 5) {
/*  497 */             this.q.removeIndex(0);
/*      */           
/*      */           }
/*      */         }
/*  501 */         else if (this.M > this.N) {
/*      */           double d1;
/*  503 */           if ((d1 = this.M / this.N) > 5.0D) {
/*  504 */             a("Round " + this.i + ": [#8BC34A]Player[] wins by draw, he was x" + StringFormatter.compactNumberWithPrecision(d1, 1) + " faster");
/*  505 */             d = 0.04D;
/*      */           } else {
/*  507 */             a("Round " + this.i + ": draw but Player was x" + StringFormatter.compactNumberWithPrecision(d1, 1) + " faster");
/*      */           } 
/*      */         } else {
/*      */           double d1;
/*  511 */           if ((d1 = this.N / this.M) > 5.0D) {
/*  512 */             a("Round " + this.i + ": [#FF9800]Ensor[] wins by draw, he was x" + StringFormatter.compactNumberWithPrecision(d1, 1) + " faster");
/*  513 */             d = -0.01D;
/*      */           } else {
/*  515 */             a("Round " + this.i + ": draw but Ensor was x" + StringFormatter.compactNumberWithPrecision(d1, 1) + " faster");
/*      */           } 
/*      */         } 
/*      */         
/*  519 */         this.h = MathUtils.clamp(this.h + d, 0.0D, 20.0D);
/*  520 */         a(this.k, this.N, this.M, d, this.h);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  534 */         g();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  541 */         this.H.setVisible(true);
/*      */         break;
/*      */     }  }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void g() {
/*  550 */     String str = "Round: " + this.i + ", score: " + MathUtils.round((float)this.h * 5.0F) + " / " + MathUtils.round(100.0F) + "\nPlace " + this.n.winCondition + " marks in a row to win the game";
/*  551 */     this.C.setText(str);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(byte paramByte, long paramLong1, long paramLong2, double paramDouble1, double paramDouble2) {
/*      */     EndGameResult endGameResult;
/*  558 */     (endGameResult = new EndGameResult((byte)0)).a = paramByte;
/*      */     
/*  560 */     endGameResult.b = paramDouble2;
/*  561 */     this.u.add(endGameResult);
/*      */     
/*  563 */     if (this.u.size == 101) {
/*  564 */       this.u.removeIndex(0);
/*      */     }
/*      */     
/*  567 */     this.v[paramByte] = this.v[paramByte] + 1;
/*      */     
/*  569 */     this.x.setTextFromInt(this.v[1]);
/*  570 */     this.z.setTextFromInt(this.v[0]);
/*  571 */     this.y.setTextFromInt(this.v[2]);
/*      */   }
/*      */   
/*      */   private void a(String paramString) {
/*  575 */     Threads.i().runOnMainThread(() -> {
/*      */           Label label;
/*      */           (label = new Label(paramString, Game.i.assetManager.getDebugLabelStyle())).setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*      */           this.t.add(label);
/*      */           if (this.t.size == 20) {
/*      */             this.t.removeIndex(0);
/*      */           }
/*      */           this.A.clear();
/*      */           this.A.add().growY().row();
/*      */           for (byte b = 0; b < this.t.size; b++) {
/*      */             float f = MathUtils.clamp((f = (b + 1 + 20 - this.t.size) / 20.0F) + 0.05F, 0.0F, 1.0F);
/*      */             ((Label)this.t.get(b)).clearActions();
/*      */             ((Label)this.t.get(b)).addAction((Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, f * 0.56F), 0.3F));
/*      */             this.A.add((Actor)this.t.get(b)).growX().row();
/*      */           } 
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
/*      */   private int a(int paramInt1, int paramInt2) {
/*  602 */     return paramInt2 * this.n.fieldSize + paramInt1;
/*      */   }
/*      */   
/*      */   private void h() {
/*  606 */     Game.i.screenManager.goToSettingsScreen();
/*      */   }
/*      */   
/*      */   private void a(Ai paramAi, ObjectConsumer<AiRunResult> paramObjectConsumer) {
/*  610 */     this.P = paramAi;
/*  611 */     this.Q = paramObjectConsumer;
/*      */   }
/*      */   
/*      */   private void i() {
/*  615 */     c(3);
/*      */     
/*  617 */     a(this.K, paramAiRunResult -> {
/*      */           if (paramAiRunResult.b != null) {
/*      */             a.e("Error: " + paramAiRunResult.b, new Object[0]);
/*      */           } else if (this.r.getCell(paramAiRunResult.a) == 0) {
/*      */             this.r.setCell(paramAiRunResult.a, (byte)2);
/*      */             p.a.add(new IntPair(paramAiRunResult.a, 2));
/*      */           } else {
/*      */             a.e("can't make move for Ensor - cell is already occupied", new Object[0]);
/*      */           } 
/*      */           this.M += paramAiRunResult.c;
/*      */           Threads.i().runOnMainThread(());
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void j() {
/*  634 */     c(4);
/*      */     
/*  636 */     a(this.g, paramAiRunResult -> {
/*      */           if (paramAiRunResult.b != null) {
/*      */             a.e(paramAiRunResult.b, new Object[0]);
/*      */           } else if (this.r.getCell(paramAiRunResult.a) == 0) {
/*      */             this.r.setCell(paramAiRunResult.a, (byte)1);
/*      */             p.a.add(new IntPair(paramAiRunResult.a, 1));
/*      */           } else {
/*      */             a.e("can't make move for Player - cell is already occupied", new Object[0]);
/*      */           } 
/*      */           this.N += paramAiRunResult.c;
/*      */           Threads.i().runOnMainThread(());
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void k() {
/*  653 */     boolean bool = this.r.hasEmptyCells();
/*      */     
/*      */     ShortArray shortArray;
/*  656 */     if ((shortArray = this.r.getFittingWinnerMask()) != null) {
/*      */       
/*  658 */       this.k = this.r.getCell(shortArray.first());
/*      */ 
/*      */       
/*  661 */       for (bool = false; bool < shortArray.size; bool++) {
/*  662 */         short s = shortArray.items[bool];
/*  663 */         this.E[s].clearActions();
/*  664 */         this.E[s].addAction((Action)Actions.sequence(
/*  665 */               (Action)Actions.scaleTo(1.3F, 1.3F, 0.2F), 
/*  666 */               (Action)Actions.scaleTo(1.0F, 1.0F, 1.0F)));
/*      */       } 
/*      */ 
/*      */       
/*  670 */       c(5); return;
/*  671 */     }  if (!bool) {
/*      */       
/*  673 */       this.k = 0;
/*  674 */       c(5);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/*  680 */     Color color = Game.i.assetManager.getColor("menu_background");
/*  681 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/*  682 */     Gdx.gl.glClear(16640);
/*      */     
/*  684 */     if (Game.i.settingsManager.isEscButtonJustPressed())
/*      */     {
/*  686 */       h();
/*      */     }
/*      */     
/*      */     short s;
/*  690 */     for (s = 0; s < this.r.cellCount; s = (short)(s + 1)) {
/*      */       byte b;
/*  692 */       if ((b = this.r.getCell(s)) == 1) {
/*  693 */         this.E[s].setDrawable(this.J);
/*  694 */         this.E[s].setColor(b);
/*  695 */       } else if (b == 2) {
/*  696 */         this.E[s].setDrawable(this.I);
/*  697 */         this.E[s].setColor(c);
/*      */       } else {
/*  699 */         this.E[s].setDrawable(null);
/*      */       } 
/*      */     } 
/*      */     
/*  703 */     for (s = 0; s < this.r.cellCount; s++) {
/*  704 */       if (this.j == 2 || this.j == 4) {
/*  705 */         this.F[s].setColor(MaterialColor.LIGHT_GREEN.P900);
/*      */       } else {
/*  707 */         this.F[s].setColor(MaterialColor.LIGHT_BLUE.P900);
/*      */       } 
/*  709 */       (this.F[s].getColor()).a = G[s];
/*  710 */       G[s] = G[s] * 0.9F;
/*      */     } 
/*      */ 
/*      */     
/*  714 */     this.B.setVisible(false);
/*  715 */     this.B.clearActions();
/*  716 */     this.B.addAction(
/*  717 */         (Action)Actions.alpha(0.0F, 0.1F));
/*      */     
/*  719 */     switch (this.j) {
/*      */       case 0:
/*  721 */         if (this.o == 2) {
/*  722 */           c(1); return;
/*      */         } 
/*  724 */         c(2);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 1:
/*  729 */         i();
/*      */         return;
/*      */       
/*      */       case 2:
/*  733 */         if (this.g != null) {
/*  734 */           j();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       case 3:
/*      */       case 4:
/*  740 */         this.B.setVisible(true);
/*  741 */         this.B.clearActions();
/*  742 */         this.B.addAction(
/*  743 */             (Action)Actions.alpha(1.0F, 0.1F));
/*      */         break;
/*      */     } 
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
/*      */   public void dispose() {
/*  758 */     Game.i.uiManager.removeLayer(this.l);
/*  759 */     Game.i.uiManager.removeLayer(this.m);
/*  760 */     if (this.O != null)
/*  761 */       this.O.interrupt(); 
/*      */   }
/*      */   
/*      */   public static abstract class Board
/*      */   {
/*      */     public final TicTacToeScreen.Rules rules;
/*      */     public final short cellCount;
/*      */     
/*      */     public Board(Board param1Board) {
/*  770 */       this.rules = param1Board.rules;
/*  771 */       this.cellCount = (short)(param1Board.rules.fieldSize * param1Board.rules.fieldSize);
/*      */     }
/*      */     
/*      */     public Board(TicTacToeScreen.Rules param1Rules) {
/*  775 */       this.rules = param1Rules;
/*  776 */       this.cellCount = (short)(param1Rules.fieldSize * param1Rules.fieldSize);
/*      */     }
/*      */     public abstract Board cpy();
/*      */     public abstract boolean hasSameField(Board param1Board);
/*      */     public abstract int getTotalTickCount();
/*      */     public abstract void copyFieldFrom(Board param1Board);
/*      */     public abstract byte getCell(short param1Short);
/*      */     public abstract void setCell(short param1Short, byte param1Byte);
/*      */     public abstract byte getWinner();
/*      */     public abstract ShortArray getFittingWinnerMask();
/*      */     public abstract ShortArray getFittingWinnerMaskAsync(long[] param1ArrayOflong);
/*      */     public abstract byte getWinnerAsync(long[] param1ArrayOflong);
/*      */     
/*      */     public abstract int getFittingWinnerMasksCountAsync(long[] param1ArrayOflong, byte param1Byte);
/*      */     
/*      */     public final boolean hasEmptyCells() {
/*  792 */       return (getTotalTickCount() != this.cellCount);
/*      */     }
/*      */     
/*      */     public final boolean isEmpty() {
/*  796 */       return (getTotalTickCount() == 0);
/*      */     }
/*      */     
/*      */     public final short getCellIdx(short param1Short1, short param1Short2) {
/*  800 */       return this.rules.getCellIdx(param1Short1, param1Short2);
/*      */     }
/*      */     
/*      */     public final byte getCellByXY(short param1Short1, short param1Short2) {
/*  804 */       return getCell(getCellIdx(param1Short1, param1Short2));
/*      */     }
/*      */     
/*      */     public final byte getOpponent(byte param1Byte) {
/*  808 */       return (param1Byte == 1) ? 2 : 1;
/*      */     }
/*      */     
/*      */     public final String getPlayerName(byte param1Byte) {
/*  812 */       switch (param1Byte) { case 2:
/*  813 */           return "Ensor";
/*  814 */         case 1: return "Player"; }
/*  815 */        return "None";
/*      */     }
/*      */ 
/*      */     
/*      */     public final TicTacToeScreen.Rules getRules() {
/*  820 */       return this.rules;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  825 */       StringBuilder stringBuilder = new StringBuilder();
/*  826 */       for (short s = 0; s < this.rules.fieldSize; s = (short)(s + 1)) {
/*  827 */         for (short s1 = 0; s1 < this.rules.fieldSize; s1 = (short)(s1 + 1)) {
/*  828 */           switch (getCellByXY(s1, s)) { case 0:
/*  829 */               stringBuilder.append('.'); break;
/*  830 */             case 2: stringBuilder.append('-'); break;
/*  831 */             case 1: stringBuilder.append('+'); break; }
/*      */         
/*      */         } 
/*  834 */         stringBuilder.append("\n");
/*      */       } 
/*  836 */       return stringBuilder.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class FixedSizeSmallBoard
/*      */     extends Board
/*      */   {
/*      */     private long a;
/*      */ 
/*      */     
/*      */     private long b;
/*      */ 
/*      */     
/*      */     private static void a(TicTacToeScreen.Rules param1Rules) {
/*  852 */       if (param1Rules.fieldSize > 8) {
/*  853 */         throw new IllegalArgumentException("Field size can not exceed 8");
/*      */       }
/*      */     }
/*      */     
/*      */     public FixedSizeSmallBoard(TicTacToeScreen.Board param1Board) {
/*  858 */       super(param1Board);
/*  859 */       a(param1Board.rules);
/*  860 */       copyFieldFrom(param1Board);
/*      */     }
/*      */     
/*      */     public FixedSizeSmallBoard(TicTacToeScreen.Rules param1Rules) {
/*  864 */       super(param1Rules);
/*  865 */       a(param1Rules);
/*      */     }
/*      */ 
/*      */     
/*      */     public final TicTacToeScreen.Board cpy() {
/*  870 */       return new FixedSizeSmallBoard(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean hasSameField(TicTacToeScreen.Board param1Board) {
/*  875 */       param1Board = param1Board;
/*  876 */       return (this.a == ((FixedSizeSmallBoard)param1Board).a && this.b == ((FixedSizeSmallBoard)param1Board).b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getTotalTickCount() {
/*  881 */       return Long.bitCount(this.a) + Long.bitCount(this.b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void copyFieldFrom(TicTacToeScreen.Board param1Board) {
/*  886 */       param1Board = param1Board;
/*  887 */       this.a = ((FixedSizeSmallBoard)param1Board).a;
/*  888 */       this.b = ((FixedSizeSmallBoard)param1Board).b;
/*      */     }
/*      */     
/*      */     private static boolean a(long param1Long, int param1Int) {
/*  892 */       return ((param1Long & 1L << param1Int) != 0L);
/*      */     }
/*      */     
/*      */     private static long b(long param1Long, int param1Int) {
/*  896 */       return param1Long | 1L << param1Int;
/*      */     }
/*      */     
/*      */     private static long c(long param1Long, int param1Int) {
/*  900 */       return param1Long & (1L << param1Int ^ 0xFFFFFFFFFFFFFFFFL);
/*      */     }
/*      */ 
/*      */     
/*      */     public final byte getCell(short param1Short) {
/*  905 */       if (a(this.a, param1Short))
/*  906 */         return 1; 
/*  907 */       if (a(this.b, param1Short)) {
/*  908 */         return 2;
/*      */       }
/*  910 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void setCell(short param1Short, byte param1Byte) {
/*  916 */       switch (param1Byte) {
/*      */         case 0:
/*  918 */           this.a = c(this.a, param1Short);
/*  919 */           this.b = c(this.b, param1Short);
/*      */           return;
/*      */         
/*      */         case 1:
/*  923 */           this.a = b(this.a, param1Short);
/*  924 */           this.b = c(this.b, param1Short);
/*      */           return;
/*      */         
/*      */         case 2:
/*  928 */           this.a = c(this.a, param1Short);
/*  929 */           this.b = b(this.b, param1Short);
/*      */           break;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final byte getWinner() {
/*      */       ShortArray shortArray;
/*  940 */       if ((shortArray = getFittingWinnerMask()) == null) {
/*  941 */         return 0;
/*      */       }
/*  943 */       return getCell(shortArray.items[0]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final ShortArray getFittingWinnerMask() {
/*  949 */       return getFittingWinnerMaskAsync(null);
/*      */     }
/*      */ 
/*      */     
/*      */     public final ShortArray getFittingWinnerMaskAsync(long[] param1ArrayOflong) {
/*  954 */       if (getTotalTickCount() + 2 < this.rules.winCondition << 1)
/*      */       {
/*  956 */         return null;
/*      */       }
/*      */       
/*  959 */       for (byte b = 0; b < (TicTacToeScreen.Rules.a(this.rules)).size; b++) {
/*      */         long l;
/*  961 */         if (((l = (TicTacToeScreen.Rules.a(this.rules)).items[b]) & this.a) == l)
/*      */         {
/*  963 */           return ((ShortArray[])(TicTacToeScreen.Rules.b(this.rules)).items)[b];
/*      */         }
/*  965 */         if ((l & this.b) == l)
/*      */         {
/*  967 */           return ((ShortArray[])(TicTacToeScreen.Rules.b(this.rules)).items)[b];
/*      */         }
/*      */       } 
/*      */       
/*  971 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public final byte getWinnerAsync(long[] param1ArrayOflong) {
/*  976 */       if (getTotalTickCount() + 2 < this.rules.winCondition << 1)
/*      */       {
/*  978 */         return 0;
/*      */       }
/*      */       
/*  981 */       for (byte b = 0; b < (TicTacToeScreen.Rules.a(this.rules)).size; b++) {
/*      */         long l;
/*  983 */         if (((l = (TicTacToeScreen.Rules.a(this.rules)).items[b]) & this.a) == l)
/*      */         {
/*  985 */           return 1;
/*      */         }
/*  987 */         if ((l & this.b) == l)
/*      */         {
/*  989 */           return 2;
/*      */         }
/*      */       } 
/*      */       
/*  993 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getFittingWinnerMasksCountAsync(long[] param1ArrayOflong, byte param1Byte) {
/*  998 */       long l = (param1Byte == 1) ? this.a : this.b;
/*      */       
/* 1000 */       byte b = 0;
/* 1001 */       for (param1Byte = 0; param1Byte < (TicTacToeScreen.Rules.a(this.rules)).size; param1Byte++) {
/*      */         long l1;
/* 1003 */         if (((l1 = (TicTacToeScreen.Rules.a(this.rules)).items[param1Byte]) & l) == l1) {
/* 1004 */           b++;
/*      */         }
/*      */       } 
/* 1007 */       return b;
/*      */     } }
/*      */   
/*      */   public static final class DynamicSizeBoard extends Board {
/*      */     private final BitVector a;
/*      */     private final BitVector b;
/*      */     private static long[] c;
/*      */     
/*      */     public DynamicSizeBoard(TicTacToeScreen.Board param1Board) {
/* 1016 */       super(param1Board);
/* 1017 */       this.a = new BitVector(this.cellCount);
/* 1018 */       this.b = new BitVector(this.cellCount);
/* 1019 */       copyFieldFrom(param1Board);
/*      */     }
/*      */     
/*      */     public DynamicSizeBoard(TicTacToeScreen.Rules param1Rules) {
/* 1023 */       super(param1Rules);
/* 1024 */       this.a = new BitVector(this.cellCount);
/* 1025 */       this.b = new BitVector(this.cellCount);
/*      */     }
/*      */ 
/*      */     
/*      */     public final TicTacToeScreen.Board cpy() {
/* 1030 */       return new DynamicSizeBoard(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean hasSameField(TicTacToeScreen.Board param1Board) {
/* 1035 */       param1Board = param1Board;
/* 1036 */       return (this.b.exactlyTheSame(((DynamicSizeBoard)param1Board).b) && this.a.exactlyTheSame(((DynamicSizeBoard)param1Board).a));
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getTotalTickCount() {
/* 1041 */       return this.a.cardinality() + this.b.cardinality();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void copyFieldFrom(TicTacToeScreen.Board param1Board) {
/* 1046 */       param1Board = param1Board;
/* 1047 */       for (byte b = 0; b < this.cellCount; b++) {
/* 1048 */         this.a.unsafeSetValue(b, ((DynamicSizeBoard)param1Board).a.unsafeGet(b));
/* 1049 */         this.b.unsafeSetValue(b, ((DynamicSizeBoard)param1Board).b.unsafeGet(b));
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public final byte getCell(short param1Short) {
/* 1055 */       if (this.a.unsafeGet(param1Short))
/* 1056 */         return 1; 
/* 1057 */       if (this.b.unsafeGet(param1Short)) {
/* 1058 */         return 2;
/*      */       }
/* 1060 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void setCell(short param1Short, byte param1Byte) {
/* 1066 */       switch (param1Byte) { case 0:
/* 1067 */           this.a.unsafeSetValue(param1Short, false); this.b.unsafeSetValue(param1Short, false); return;
/* 1068 */         case 1: this.a.unsafeSetValue(param1Short, true); this.b.unsafeSetValue(param1Short, false); return;
/* 1069 */         case 2: this.a.unsafeSetValue(param1Short, false); this.b.unsafeSetValue(param1Short, true);
/*      */           break; }
/*      */     
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
/*      */     public final byte getWinner() {
/*      */       ShortArray shortArray;
/* 1091 */       if ((shortArray = getFittingWinnerMask()) == null) {
/* 1092 */         return 0;
/*      */       }
/* 1094 */       return getCell(shortArray.items[0]);
/*      */     }
/*      */     private static void a(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
/*      */       byte b;
/*      */       int i;
/* 1099 */       for (b = 0, i = param1ArrayOflong1.length; b < i; b++)
/* 1100 */         param1ArrayOflong1[b] = param1ArrayOflong1[b] & param1ArrayOflong2[b]; 
/*      */     }
/*      */     public static boolean exactlyTheSame(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
/*      */       byte b;
/*      */       int i;
/* 1105 */       for (b = 0, i = param1ArrayOflong1.length; b < i; b++) {
/* 1106 */         if (param1ArrayOflong1[b] != param1ArrayOflong2[b])
/* 1107 */           return false; 
/*      */       } 
/* 1109 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final ShortArray getFittingWinnerMask() {
/* 1116 */       if (c == null || c.length != this.a.words.length) {
/* 1117 */         c = new long[this.a.words.length];
/*      */       }
/* 1119 */       return getFittingWinnerMaskAsync(c);
/*      */     }
/*      */     
/*      */     public final long[] createThreadSafeBits() {
/* 1123 */       return new long[this.a.words.length];
/*      */     }
/*      */ 
/*      */     
/*      */     public final ShortArray getFittingWinnerMaskAsync(long[] param1ArrayOflong) {
/* 1128 */       if (getTotalTickCount() + 2 < this.rules.winCondition << 1)
/*      */       {
/* 1130 */         return null;
/*      */       }
/*      */       
/* 1133 */       for (byte b = 0; b < (TicTacToeScreen.Rules.c(this.rules)).size; b++) {
/* 1134 */         BitVector bitVector = ((BitVector[])(TicTacToeScreen.Rules.c(this.rules)).items)[b];
/* 1135 */         System.arraycopy(this.a.words, 0, param1ArrayOflong, 0, param1ArrayOflong.length);
/* 1136 */         a(param1ArrayOflong, bitVector.words);
/* 1137 */         if (exactlyTheSame(param1ArrayOflong, bitVector.words))
/*      */         {
/* 1139 */           return ((ShortArray[])(TicTacToeScreen.Rules.b(this.rules)).items)[b];
/*      */         }
/* 1141 */         System.arraycopy(this.b.words, 0, param1ArrayOflong, 0, param1ArrayOflong.length);
/* 1142 */         a(param1ArrayOflong, bitVector.words);
/* 1143 */         if (exactlyTheSame(param1ArrayOflong, bitVector.words))
/*      */         {
/* 1145 */           return ((ShortArray[])(TicTacToeScreen.Rules.b(this.rules)).items)[b];
/*      */         }
/*      */       } 
/*      */       
/* 1149 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public final byte getWinnerAsync(long[] param1ArrayOflong) {
/* 1154 */       if (getTotalTickCount() + 2 < this.rules.winCondition << 1)
/*      */       {
/* 1156 */         return 0;
/*      */       }
/*      */       
/* 1159 */       for (byte b = 0; b < (TicTacToeScreen.Rules.c(this.rules)).size; b++) {
/* 1160 */         BitVector bitVector = ((BitVector[])(TicTacToeScreen.Rules.c(this.rules)).items)[b];
/* 1161 */         System.arraycopy(this.a.words, 0, param1ArrayOflong, 0, param1ArrayOflong.length);
/* 1162 */         a(param1ArrayOflong, bitVector.words);
/* 1163 */         if (exactlyTheSame(param1ArrayOflong, bitVector.words))
/*      */         {
/* 1165 */           return 1;
/*      */         }
/* 1167 */         System.arraycopy(this.b.words, 0, param1ArrayOflong, 0, param1ArrayOflong.length);
/* 1168 */         a(param1ArrayOflong, bitVector.words);
/* 1169 */         if (exactlyTheSame(param1ArrayOflong, bitVector.words))
/*      */         {
/* 1171 */           return 2;
/*      */         }
/*      */       } 
/*      */       
/* 1175 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getFittingWinnerMasksCountAsync(long[] param1ArrayOflong, byte param1Byte) {
/* 1180 */       BitVector bitVector = (param1Byte == 1) ? this.a : this.b;
/* 1181 */       byte b1 = 0;
/* 1182 */       for (byte b2 = 0; b2 < (TicTacToeScreen.Rules.c(this.rules)).size; b2++) {
/* 1183 */         BitVector bitVector1 = ((BitVector[])(TicTacToeScreen.Rules.c(this.rules)).items)[b2];
/* 1184 */         System.arraycopy(bitVector.words, 0, param1ArrayOflong, 0, param1ArrayOflong.length);
/* 1185 */         a(param1ArrayOflong, bitVector1.words);
/* 1186 */         if (exactlyTheSame(param1ArrayOflong, bitVector1.words)) {
/* 1187 */           b1++;
/*      */         }
/*      */       } 
/* 1190 */       return b1;
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class Rules
/*      */   {
/*      */     public final short fieldSize;
/*      */     public final short winCondition;
/* 1198 */     private final Array<ShortArray> a = new Array(true, 8, ShortArray.class);
/* 1199 */     private final Array<BitVector> b = new Array(true, 8, BitVector.class);
/* 1200 */     private final LongArray c = new LongArray(8);
/*      */     
/*      */     public Rules(short param1Short1, short param1Short2) {
/* 1203 */       this.fieldSize = param1Short1;
/* 1204 */       this.winCondition = param1Short2;
/* 1205 */       a();
/*      */     }
/*      */     
/*      */     public final short getCellIdx(short param1Short1, short param1Short2) {
/* 1209 */       return (short)(param1Short2 * this.fieldSize + param1Short1);
/*      */     }
/*      */ 
/*      */     
/*      */     private void a() {
/* 1214 */       this.a.clear();
/* 1215 */       this.b.clear();
/* 1216 */       this.c.clear();
/*      */       
/*      */       short s;
/* 1219 */       for (s = 0; s < this.fieldSize; s = (short)(s + 1)) {
/* 1220 */         for (short s1 = 0; s1 <= this.fieldSize - this.winCondition; s1 = (short)(s1 + 1)) {
/* 1221 */           ShortArray shortArray = new ShortArray(); short s2;
/* 1222 */           for (s2 = s1; s2 < s1 + this.winCondition; s2 = (short)(s2 + 1)) {
/* 1223 */             shortArray.add(getCellIdx(s2, s));
/*      */           }
/* 1225 */           this.a.add(shortArray);
/*      */         } 
/*      */       } 
/*      */       
/* 1229 */       for (s = 0; s < this.fieldSize; s = (short)(s + 1)) {
/* 1230 */         for (short s1 = 0; s1 <= this.fieldSize - this.winCondition; s1 = (short)(s1 + 1)) {
/* 1231 */           ShortArray shortArray = new ShortArray(); short s2;
/* 1232 */           for (s2 = s1; s2 < s1 + this.winCondition; s2 = (short)(s2 + 1)) {
/* 1233 */             shortArray.add(getCellIdx(s, s2));
/*      */           }
/* 1235 */           this.a.add(shortArray);
/*      */         } 
/*      */       }  short[][] arrayOfShort;
/*      */       byte b;
/* 1239 */       for (arrayOfShort = new short[][] { { 1, 1 }, , { 1, -1 },  }, b = 0; b < 2; ) { short[] arrayOfShort1 = arrayOfShort[b]; short s1;
/* 1240 */         for (s1 = 0; s1 < this.fieldSize; s1 = (short)(s1 + 1)) {
/* 1241 */           short s2; for (s2 = 0; s2 < this.fieldSize; s2 = (short)(s2 + 1)) {
/* 1242 */             ShortArray shortArray = new ShortArray();
/* 1243 */             short s3 = s2;
/* 1244 */             short s4 = s1;
/*      */             while (true) {
/* 1246 */               shortArray.add(getCellIdx(s3, s4));
/* 1247 */               if (shortArray.size != this.winCondition) {
/*      */ 
/*      */ 
/*      */                 
/* 1251 */                 s3 = (short)(s3 + arrayOfShort1[0]);
/* 1252 */                 s4 = (short)(s4 + arrayOfShort1[1]);
/* 1253 */                 if (s3 < 0 || s4 < 0 || s3 >= this.fieldSize || s4 >= this.fieldSize)
/*      */                   break;  continue;
/*      */               }  break;
/* 1256 */             }  if (shortArray.size == this.winCondition) {
/* 1257 */               this.a.add(shortArray);
/*      */             }
/*      */           } 
/*      */         } 
/*      */         b++; }
/*      */       
/* 1263 */       for (Array.ArrayIterator<ShortArray> arrayIterator = this.a.iterator(); arrayIterator.hasNext(); ) { ShortArray shortArray = arrayIterator.next();
/* 1264 */         BitVector bitVector = new BitVector(this.fieldSize * this.fieldSize);
/* 1265 */         for (byte b1 = 0; b1 < shortArray.size; b1++) {
/* 1266 */           bitVector.unsafeSet(shortArray.items[b1]);
/*      */         }
/* 1268 */         this.b.add(bitVector);
/*      */         
/* 1270 */         if (this.fieldSize <= 8) {
/* 1271 */           long l = 0L;
/* 1272 */           for (byte b2 = 0; b2 < shortArray.size; b2++) {
/* 1273 */             l |= 1L << shortArray.items[b2];
/*      */           }
/* 1275 */           this.c.add(l);
/*      */         }  }
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class AiRunResult
/*      */   {
/*      */     short a;
/*      */     String b;
/*      */     long c;
/*      */   }
/*      */   
/*      */   private static final class AiMixin
/*      */     implements Ai
/*      */   {
/*      */     private TicTacToeScreen.Ai a;
/*      */     private TicTacToeScreen.Ai b;
/*      */     private float c;
/*      */     private float d;
/*      */     
/*      */     public AiMixin(TicTacToeScreen.Ai param1Ai1, float param1Float1, TicTacToeScreen.Ai param1Ai2, float param1Float2) {
/* 1298 */       this.a = param1Ai1;
/* 1299 */       this.b = param1Ai2;
/* 1300 */       this.c = param1Float1;
/* 1301 */       this.d = param1Float2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/* 1306 */       if (this.c == 0.0F) {
/* 1307 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "running " + this.b.getClass().getSimpleName());
/* 1308 */         return this.b.makeMove(param1Board);
/* 1309 */       }  if (this.d == 0.0F) {
/* 1310 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "running " + this.a.getClass().getSimpleName());
/* 1311 */         return this.a.makeMove(param1Board);
/*      */       } 
/* 1313 */       if (TicTacToeScreen.Level1Ai.a().nextFloat() * (this.c + this.d) < this.c) {
/* 1314 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "running " + this.a.getClass().getSimpleName());
/* 1315 */         return this.a.makeMove(param1Board);
/*      */       } 
/* 1317 */       TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "running " + this.b.getClass().getSimpleName());
/* 1318 */       return this.b.makeMove(param1Board);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1325 */       return "Mixin " + this.a.getClass().getSimpleName() + " " + this.c + " / " + this.b.getClass().getSimpleName() + " " + this.d;
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Level1Ai
/*      */     implements Ai {
/* 1331 */     private static final RandomXS128 a = new RandomXS128();
/*      */     
/* 1333 */     private final ShortArray b = new ShortArray();
/*      */     private final byte c;
/*      */     
/*      */     public Level1Ai(byte param1Byte) {
/* 1337 */       this.c = param1Byte;
/*      */     }
/*      */     
/*      */     private static boolean a(TicTacToeScreen.Board param1Board) {
/* 1341 */       return (param1Board.getTotalTickCount() == param1Board.cellCount - 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/* 1346 */       if (param1Board.isEmpty()) {
/*      */         
/* 1348 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L1 - making random first move");
/* 1349 */         return (short)a.nextInt(param1Board.cellCount);
/*      */       } 
/*      */       
/* 1352 */       short s1 = 0;
/* 1353 */       byte b = 0; short s2;
/* 1354 */       for (s2 = 0; s2 < param1Board.cellCount; s2 = (short)(s2 + 1)) {
/*      */         byte b1;
/* 1356 */         if ((b1 = param1Board.getCell(s2)) != 0) {
/* 1357 */           if (b1 == this.c) {
/* 1358 */             s1++;
/*      */           } else {
/* 1360 */             b++;
/*      */           } 
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1366 */       if (s1 > b) {
/* 1367 */         s2 = this.c;
/*      */       } else {
/* 1369 */         s2 = param1Board.getOpponent(this.c);
/*      */       } 
/* 1371 */       this.b.clear(); short s3;
/* 1372 */       for (s3 = 0; s3 < param1Board.rules.fieldSize; s3 = (short)(s3 + 1)) {
/* 1373 */         for (s1 = 0; s1 < param1Board.rules.fieldSize; s1 = (short)(s1 + 1)) {
/*      */           
/* 1375 */           if ((b = param1Board.getCellByXY(s3, s1)) == 0) {
/* 1376 */             b = 0; short s;
/* 1377 */             label57: for (s = -1; s <= 1; s = (short)(s + 1)) {
/* 1378 */               short s4; for (s4 = -1; s4 <= 1; s4 = (short)(s4 + 1)) {
/* 1379 */                 if (s != 0 || s4 != 0) {
/* 1380 */                   short s5 = (short)(s3 + s);
/* 1381 */                   short s6 = (short)(s1 + s4);
/* 1382 */                   if (s5 >= 0 && s5 < param1Board.rules.fieldSize && s6 >= 0 && s6 < param1Board.rules.fieldSize)
/*      */                   {
/* 1384 */                     if (param1Board.getCellByXY(s5, s6) == s2) {
/* 1385 */                       b = 1; break label57;
/*      */                     }  } 
/*      */                 } 
/*      */               } 
/*      */             } 
/* 1390 */             if (b != 0) {
/* 1391 */               this.b.add(param1Board.getCellIdx(s3, s1));
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1397 */       if (this.b.size == 0) {
/* 1398 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L1 - making random first move (fallback)");
/* 1399 */         return (short)a.nextInt(param1Board.cellCount);
/*      */       } 
/* 1401 */       TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L1 - making random move near " + ((s2 == this.c) ? "us" : "opponent"));
/* 1402 */       return this.b.get(a.nextInt(this.b.size));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1408 */       return getClass().getSimpleName();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Level2Ai
/*      */     implements Ai {
/*      */     private final byte a;
/* 1415 */     private final ShortArray b = new ShortArray();
/*      */     private final TicTacToeScreen.Level1Ai c;
/*      */     
/*      */     public Level2Ai(byte param1Byte) {
/* 1419 */       this.a = param1Byte;
/* 1420 */       this.c = new TicTacToeScreen.Level1Ai((byte)2);
/*      */     }
/*      */     
/*      */     public final short tryWin(TicTacToeScreen.Board param1Board) {
/* 1424 */       this.b.clear();
/* 1425 */       for (short s = 0; s < param1Board.cellCount; s = (short)(s + 1)) {
/* 1426 */         if (param1Board.getCell(s) == 0) {
/* 1427 */           param1Board.setCell(s, this.a);
/* 1428 */           byte b = param1Board.getWinner();
/* 1429 */           param1Board.setCell(s, (byte)0);
/* 1430 */           if (b == this.a) {
/* 1431 */             this.b.add(s);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1437 */       if (this.b.size == 0) {
/* 1438 */         return -1;
/*      */       }
/* 1440 */       return this.b.items[TicTacToeScreen.Level1Ai.a().nextInt(this.b.size)];
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/*      */       short s;
/* 1447 */       if ((s = tryWin(param1Board)) != -1) {
/* 1448 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L2 - trying to win");
/* 1449 */         return s;
/*      */       } 
/*      */       
/* 1452 */       return this.c.makeMove(param1Board);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1457 */       return getClass().getSimpleName();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Level3Ai
/*      */     implements Ai {
/*      */     private final byte a;
/*      */     private final TicTacToeScreen.Level1Ai b;
/*      */     private final TicTacToeScreen.Level2Ai c;
/*      */     
/*      */     private Level3Ai(byte param1Byte) {
/* 1468 */       this.a = param1Byte;
/* 1469 */       this.b = new TicTacToeScreen.Level1Ai(param1Byte);
/* 1470 */       this.c = new TicTacToeScreen.Level2Ai(param1Byte);
/*      */     }
/*      */     
/*      */     private short a(TicTacToeScreen.Board param1Board) {
/* 1474 */       byte b = param1Board.getOpponent(this.a);
/* 1475 */       for (short s = 0; s < param1Board.cellCount; s = (short)(s + 1)) {
/* 1476 */         if (param1Board.getCell(s) == 0) {
/* 1477 */           param1Board.setCell(s, b);
/* 1478 */           byte b1 = param1Board.getWinner();
/* 1479 */           param1Board.setCell(s, (byte)0);
/* 1480 */           if (b1 == b) {
/* 1481 */             return s;
/*      */           }
/*      */         } 
/*      */       } 
/* 1485 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     private short b(TicTacToeScreen.Board param1Board) {
/* 1490 */       if (param1Board.isEmpty() || TicTacToeScreen.Level1Ai.a(this.b, param1Board)) {
/* 1491 */         return this.b.makeMove(param1Board);
/*      */       }
/*      */       
/*      */       short s;
/*      */       
/* 1496 */       if ((s = this.c.tryWin(param1Board)) != -1) {
/* 1497 */         return s;
/*      */       }
/*      */ 
/*      */       
/* 1501 */       return a(param1Board);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/*      */       short s;
/* 1508 */       if ((s = b(param1Board)) != -1) {
/* 1509 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L3 - trying to win or counter");
/* 1510 */         return s;
/*      */       } 
/*      */       
/* 1513 */       return this.b.makeMove(param1Board);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1518 */       return getClass().getSimpleName();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Level4Ai
/*      */     implements Ai {
/*      */     private final byte a;
/* 1525 */     private final ShortArray b = new ShortArray();
/*      */     private final TicTacToeScreen.Level2Ai c;
/*      */     private final TicTacToeScreen.Level3Ai d;
/*      */     
/*      */     public Level4Ai(byte param1Byte) {
/* 1530 */       this.a = param1Byte;
/* 1531 */       this.c = new TicTacToeScreen.Level2Ai(param1Byte);
/* 1532 */       this.d = new TicTacToeScreen.Level3Ai(param1Byte, (byte)0);
/*      */     }
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/*      */       short s;
/* 1538 */       if ((s = TicTacToeScreen.Level3Ai.a(this.d, param1Board)) != -1) {
/*      */         
/* 1540 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L4 - trying to win or counter");
/* 1541 */         return s;
/*      */       } 
/*      */ 
/*      */       
/* 1545 */       this.b.clear();
/* 1546 */       for (s = 0; s < param1Board.cellCount; s = (short)(s + 1)) {
/*      */         byte b1;
/* 1548 */         if ((b1 = param1Board.getCell(s)) == 0) {
/* 1549 */           this.b.add(s);
/*      */         }
/*      */       } 
/* 1552 */       this.b.shuffle();
/*      */       
/* 1554 */       s = 0;
/* 1555 */       byte b = 0; short s1;
/* 1556 */       for (s1 = 0; s1 < param1Board.cellCount; s1 = (short)(s1 + 1)) {
/*      */         byte b1;
/* 1558 */         if ((b1 = param1Board.getCell(s1)) == this.a) {
/* 1559 */           s++;
/* 1560 */         } else if (b1 != 0) {
/* 1561 */           b++;
/*      */         } 
/*      */       } 
/*      */       
/* 1565 */       if (s > b) {
/* 1566 */         for (s1 = 0; s1 < this.b.size; s1++) {
/* 1567 */           short s2 = this.b.items[s1];
/* 1568 */           param1Board.setCell(s2, this.a);
/* 1569 */           s = this.c.tryWin(param1Board);
/* 1570 */           param1Board.setCell(s2, (byte)0);
/* 1571 */           if (s != -1) {
/* 1572 */             TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L4 - winning in 2 turns");
/* 1573 */             return s;
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/* 1578 */         s1 = param1Board.getOpponent(this.a); short s2;
/* 1579 */         for (s2 = 0; s2 < param1Board.cellCount; s2 = (short)(s2 + 1)) {
/*      */           
/* 1581 */           if ((s = param1Board.getCell(s2)) == 0) {
/* 1582 */             param1Board.setCell(s2, s1);
/* 1583 */             s = TicTacToeScreen.Level3Ai.b(this.d, param1Board);
/* 1584 */             param1Board.setCell(s2, (byte)0);
/* 1585 */             if (s != -1) {
/* 1586 */               TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L4 - countering in 2 turns");
/* 1587 */               return s;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1593 */       return this.d.makeMove(param1Board);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1598 */       return getClass().getSimpleName();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Level5Ai
/*      */     implements Ai
/*      */   {
/*      */     private final byte a;
/*      */ 
/*      */     
/*      */     private int b;
/*      */     
/*      */     private final TicTacToeScreen.Level3Ai c;
/*      */     
/*      */     private final ThreadPoolExecutor d;
/*      */ 
/*      */     
/*      */     public Level5Ai(byte param1Byte) {
/* 1618 */       this.a = param1Byte;
/* 1619 */       this.c = new TicTacToeScreen.Level3Ai(param1Byte, (byte)0);
/*      */       
/* 1621 */       this.d = (ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
/*      */     }
/*      */     
/*      */     private void a(TicTacToeScreen.Board param1Board, byte param1Byte, int param1Int, SimResult param1SimResult) {
/* 1625 */       ShortArray shortArray = new ShortArray();
/* 1626 */       a(param1Board, shortArray);
/* 1627 */       for (byte b = 0; b < shortArray.size; b++) {
/* 1628 */         short s = shortArray.items[b];
/* 1629 */         param1Board.setCell(s, param1Byte);
/*      */         byte b1;
/* 1631 */         if ((b1 = param1Board.getWinnerAsync(param1SimResult.b)) != 0) {
/*      */           
/* 1633 */           double d = Math.pow(1.0D, (param1Int == 0) ? 1.0D : (0.75D * (param1Int - 1))) / shortArray.size;
/* 1634 */           int i = param1Board.getFittingWinnerMasksCountAsync(param1SimResult.b, b1);
/* 1635 */           d *= Math.pow(10.0D, (i - 1));
/*      */ 
/*      */ 
/*      */           
/* 1639 */           param1SimResult.c[b1 - 1] = param1SimResult.c[b1 - 1] + d;
/*      */         }
/* 1641 */         else if (param1Board.hasEmptyCells()) {
/*      */           
/* 1643 */           if (param1Int != this.b) {
/* 1644 */             a(param1Board, param1Board.getOpponent(param1Byte), param1Int + 1, param1SimResult);
/*      */           } else {
/* 1646 */             param1SimResult.e++;
/*      */           } 
/*      */         } else {
/*      */           
/* 1650 */           param1SimResult.d++;
/*      */         } 
/*      */         
/* 1653 */         param1Board.setCell(s, (byte)0);
/*      */       } 
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
/* 1668 */     private static final byte[] e = new byte[16]; static {
/* 1669 */       byte b = 0;
/* 1670 */       for (byte b1 = -1; b1 <= 1; b1++) {
/* 1671 */         for (byte b2 = -1; b2 <= 1; b2++) {
/* 1672 */           if (b2 != 0 || b1 != 0) {
/* 1673 */             e[b++] = (byte)b1;
/* 1674 */             e[b++] = (byte)b2;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     private static void a(TicTacToeScreen.Board param1Board, ShortArray param1ShortArray) {
/* 1680 */       short s = param1Board.rules.fieldSize;
/* 1681 */       for (short s1 = 0; s1 < s; s1 = (short)(s1 + 1)) {
/* 1682 */         short s2; for (s2 = 0; s2 < s; s2 = (short)(s2 + 1)) {
/* 1683 */           if (param1Board.getCellByXY(s2, s1) == 0) {
/* 1684 */             boolean bool = false;
/* 1685 */             for (byte b = 0; b < e.length; b += 2) {
/* 1686 */               short s3 = (short)(e[b] + s2);
/*      */               short s4;
/* 1688 */               if ((s4 = (short)(e[b + 1] + s1)) >= 0 && s4 < s && s3 >= 0 && s3 < s && 
/* 1689 */                 param1Board.getCellByXY(s3, s4) != 0) {
/* 1690 */                 bool = true;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/* 1695 */             if (bool) {
/* 1696 */               param1ShortArray.add(param1Board.getCellIdx(s2, s1));
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public final short makeMove(TicTacToeScreen.Board param1Board) {
/*      */       short s;
/* 1706 */       if ((s = TicTacToeScreen.Level3Ai.a(this.c, param1Board)) != -1) {
/*      */         
/* 1708 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L5 - tryWinOrCounter");
/* 1709 */         return s;
/*      */       } 
/*      */       
/* 1712 */       s = 0; int i;
/* 1713 */       for (i = 0; i < param1Board.cellCount; i = (short)(i + 1)) {
/* 1714 */         if (param1Board.getCell(i) == this.a) {
/* 1715 */           s++;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1720 */       if ((i = (i = param1Board.getTotalTickCount()) - s) == 1 && s == 0) {
/*      */         
/* 1722 */         boolean bool = (this.a == 2) ? true : true; short s1;
/* 1723 */         for (s1 = 0; s1 < param1Board.rules.fieldSize; s1 = (short)(s1 + 1)) {
/* 1724 */           short s2; for (s2 = 0; s2 < param1Board.rules.fieldSize; s2 = (short)(s2 + 1)) {
/* 1725 */             short s3 = param1Board.getCellIdx(s1, s2);
/* 1726 */             if (param1Board.getCell(s3) == bool) {
/*      */               
/* 1728 */               s = (short)((s1 < param1Board.rules.fieldSize / 2) ? (s1 + 1) : (s1 - 1));
/* 1729 */               short s4 = (short)((s2 < param1Board.rules.fieldSize / 2) ? (s2 + 1) : (s2 - 1));
/* 1730 */               return param1Board.getCellIdx(s, s4);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1735 */       if (i == s) {
/*      */         
/* 1737 */         this.b = 3;
/*      */       } else {
/*      */         
/* 1740 */         this.b = 4;
/*      */       } 
/* 1742 */       if (param1Board.rules.fieldSize <= 5) {
/* 1743 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L5 - small field, increase depth");
/* 1744 */         this.b += 2;
/*      */       } 
/*      */       
/* 1747 */       if (param1Board.getTotalTickCount() + 5 < param1Board.rules.winCondition << 1) {
/*      */ 
/*      */         
/* 1750 */         TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L5 - no possible winner yet, increase depth");
/* 1751 */         this.b += 2;
/*      */       } 
/*      */       
/* 1754 */       TicTacToeScreen.GameReplay.a(TicTacToeScreen.c(), "L5 - setting maxDepth to " + this.b);
/*      */       
/* 1756 */       ShortArray shortArray = new ShortArray();
/* 1757 */       a(param1Board, shortArray);
/* 1758 */       shortArray.shuffle();
/*      */       
/* 1760 */       Array array2 = new Array(true, shortArray.size, SimResult.class);
/* 1761 */       byte b = param1Board.getOpponent(this.a);
/* 1762 */       LinkedList<Future<?>> linkedList = new LinkedList();
/* 1763 */       AtomicInteger atomicInteger = new AtomicInteger();
/* 1764 */       for (byte b1 = 0; b1 < shortArray.size; b1++) {
/*      */         SimResult simResult1;
/* 1766 */         (simResult1 = new SimResult((byte)0)).b = (param1Board instanceof TicTacToeScreen.DynamicSizeBoard) ? ((TicTacToeScreen.DynamicSizeBoard)param1Board).createThreadSafeBits() : null;
/* 1767 */         simResult1.a = shortArray.items[b1];
/* 1768 */         array2.add(simResult1);
/*      */         
/*      */         TicTacToeScreen.Board board;
/* 1771 */         (board = param1Board.cpy()).setCell(simResult1.a, this.a);
/* 1772 */         linkedList.add(this.d.submit(() -> {
/*      */                 a(param1Board, param1Byte, 0, param1SimResult);
/*      */                 
/*      */                 param1AtomicInteger.addAndGet(1);
/*      */                 TicTacToeScreen.a(param1SimResult.a);
/*      */               }));
/*      */       } 
/* 1779 */       for (Future<?> future : linkedList) {
/*      */         try {
/* 1781 */           future.get();
/* 1782 */         } catch (Exception exception2) {
/* 1783 */           Exception exception1; (exception1 = null).printStackTrace();
/*      */         } 
/*      */       } 
/*      */       
/* 1787 */       double d = -1.7976931348623157E308D;
/* 1788 */       Array array1 = new Array(true, 1, SimResult.class);
/* 1789 */       for (Array.ArrayIterator<SimResult> arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) {
/* 1790 */         SimResult simResult1; SimResult.a(simResult1 = arrayIterator.next(), this.a); SimResult.a(simResult1, b);
/*      */         
/* 1792 */         double d1 = SimResult.a(simResult1, this.a) * 0.015D - SimResult.a(simResult1, b) * 0.1D;
/*      */         
/* 1794 */         if (d < d1) {
/* 1795 */           d = d1;
/* 1796 */           array1.clear();
/* 1797 */           array1.add(simResult1); continue;
/* 1798 */         }  if (d == d1) {
/* 1799 */           array1.add(simResult1);
/*      */         }
/*      */       } 
/*      */       
/*      */       SimResult simResult;
/*      */       
/* 1805 */       return (simResult = (SimResult)array1.random()).a;
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1810 */       return getClass().getSimpleName();
/*      */     }
/*      */     private static final class SimResult { short a; long[] b; final double[] c; int d;
/*      */       int e;
/*      */       
/*      */       private SimResult() {
/* 1816 */         this.c = new double[2];
/*      */       }
/*      */ 
/*      */       
/*      */       private double a(byte param2Byte) {
/* 1821 */         return this.c[param2Byte - 1];
/*      */       } }
/*      */   
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
/*      */   private static class Node
/*      */     implements Comparable<Node>
/*      */   {
/*      */     private byte a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private TicTacToeScreen.Board b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private short c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Array<Node> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int compareTo(Node param1Node) {
/* 2036 */       return Double.compare(0.0D, 0.0D);
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
/*      */     public String toString() {
/* 2050 */       return "Node (player: " + ((this.a == 2) ? "Ensor" : "Player") + ", move: " + this.c + ", children: " + this.d.size + ", numVisits: 0" + ", uct: 0.0" + ", victories: 0" + ", draws: 0" + ", loses: 0" + ", winner: 0" + ", field: \n" + this.b + ")";
/*      */     }
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
/*      */   private static final class TicTacToeSimulator
/*      */   {
/*      */     private TicTacToeSimulator() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
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
/*      */   private static class MCTSBestMoveFinder
/*      */   {
/*      */     static {
/*      */     
/*      */     }
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
/*      */   private static final class MiniMaxCombined
/*      */   {
/*      */     static {
/*      */     
/*      */     }
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
/*      */   private static final class EndGameResult
/*      */   {
/*      */     byte a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     double b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private EndGameResult() {}
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
/*      */   private static final class GameReplay
/*      */   {
/* 2524 */     Array<IntPair> a = new Array(true, 1, IntPair.class);
/*      */     private IntMap<Array<String>> b;
/*      */     
/*      */     private synchronized void a(String param1String) {
/* 2528 */       if (TicTacToeScreen.LOG_AI_ACTIONS) {
/* 2529 */         if (this.b == null) {
/* 2530 */           this.b = new IntMap();
/*      */         }
/*      */         Array array;
/* 2533 */         if ((array = (Array)this.b.get(this.a.size)) == null) {
/* 2534 */           array = new Array(true, 1, String.class);
/* 2535 */           this.b.put(this.a.size, array);
/*      */         } 
/* 2537 */         array.add(param1String);
/*      */       } 
/* 2539 */       if (TicTacToeScreen.PRINT_AI_ACTIONS)
/* 2540 */         TicTacToeScreen.d().i("ai: " + param1String, new Object[0]); 
/*      */     }
/*      */     
/*      */     private GameReplay() {}
/*      */   }
/*      */   
/*      */   public static interface Ai {
/*      */     short makeMove(TicTacToeScreen.Board param1Board);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\TicTacToeScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */