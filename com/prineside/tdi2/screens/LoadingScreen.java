/*     */ package com.prineside.tdi2.screens;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.viewport.ScreenViewport;
/*     */ import com.badlogic.gdx.utils.viewport.Viewport;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.GameSyncLoader;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class LoadingScreen extends Screen {
/*  24 */   private static final TLog a = TLog.forClass(LoadingScreen.class);
/*     */   
/*     */   private final GameSyncLoader b;
/*     */   
/*     */   private final Texture c;
/*     */   
/*     */   private final Texture d;
/*     */   
/*     */   private final Texture e;
/*     */   
/*     */   private final Texture f;
/*     */   
/*     */   private final ScreenViewport g;
/*     */   
/*     */   private final Stage h;
/*     */   
/*     */   private Image i;
/*     */   
/*     */   private Label j;
/*     */   
/*     */   private final Table k;
/*     */   private final Image l;
/*     */   private final Group m;
/*     */   private final Image n;
/*     */   private final Image o;
/*     */   private float p;
/*     */   private boolean q;
/*     */   private float r;
/*     */   private boolean s;
/*     */   
/*     */   public LoadingScreen(GameSyncLoader paramGameSyncLoader) {
/*  55 */     this.b = paramGameSyncLoader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     paramGameSyncLoader.addListener(new GameSyncLoader.SyncExecutionListener(this, paramGameSyncLoader)
/*     */         {
/*     */           
/*     */           public void startedTask(GameSyncLoader.Task param1Task1, GameSyncLoader.Task param1Task2)
/*     */           {
/*  66 */             LoadingScreen.a(this.b).setWidth(384.0F * this.a.getProgress());
/*  67 */             LoadingScreen.b(this.b).setText(param1Task1.title);
/*     */           }
/*     */ 
/*     */           
/*     */           public void done() {
/*  72 */             LoadingScreen.a(this.b, true);
/*     */           }
/*     */         });
/*     */     
/*     */     Pixmap pixmap;
/*     */     
/*  78 */     (pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888)).setColor(Color.WHITE);
/*  79 */     pixmap.fill();
/*  80 */     this.f = new Texture(pixmap);
/*  81 */     pixmap.dispose();
/*     */     
/*  83 */     this.d = new Texture(Gdx.files.internal("res/loading-brand.png"), Pixmap.Format.RGBA8888, false);
/*  84 */     this.d.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*  85 */     this.e = new Texture(Gdx.files.internal("res/loading-brand-name.png"), Pixmap.Format.RGBA8888, false);
/*  86 */     this.e.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */     
/*  88 */     Color color = new Color(0.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  90 */     this.c = new Texture(Gdx.files.internal("res/loading-logo.png"), Pixmap.Format.RGBA8888, false);
/*  91 */     this.c.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */ 
/*     */     
/*  94 */     this.g = new ScreenViewport();
/*  95 */     this.h = new Stage((Viewport)this.g, (Batch)Game.i.renderingManager.batch);
/*     */ 
/*     */ 
/*     */     
/*  99 */     this.k = new Table();
/* 100 */     this.k.setFillParent(true);
/* 101 */     this.h.addActor((Actor)this.k);
/*     */ 
/*     */     
/* 104 */     Image image2 = new Image(this.c);
/* 105 */     this.k.add((Actor)image2).size(256.0F).padTop(220.0F).row();
/*     */ 
/*     */     
/* 108 */     Group group = new Group();
/* 109 */     this.k.add((Actor)group).size(384.0F, 16.0F).padTop(48.0F).row();
/*     */ 
/*     */     
/* 112 */     this.j = new Label("", new Label.LabelStyle(Game.i.defaultSmallFuturaFont, MaterialColor.GREY.P600));
/* 113 */     this.j.setAlignment(8);
/* 114 */     this.k.add((Actor)this.j).width(384.0F).padTop(8.0F).padBottom(120.0F).row();
/*     */ 
/*     */     
/* 117 */     Image image4 = new Image(this.d);
/* 118 */     this.k.add((Actor)image4).size(128.0F).padBottom(32.0F).row();
/*     */ 
/*     */     
/* 121 */     String str = "Infinitode 2\nv.R.1.9.1 (b 207)\n" + (Runtime.getRuntime().maxMemory() / 1024L / 1024L) + "Mb / " + (Config.getMaxTextureSize() / 1024) + "k / " + (Game.i.actionResolver.isAppModified() ? "M" : "C") + (Config.isModdingMode() ? ("(" + Config.getModId() + ")") : "") + " / " + Game.i.actionResolver.getShortDeviceInfo();
/*     */     Label label;
/* 123 */     (label = new Label(str, new Label.LabelStyle(Game.i.defaultSmallFuturaFont, new Color(0.28F, 0.28F, 0.28F, 1.0F)))).setAlignment(1);
/* 124 */     this.k.add((Actor)label).colspan(2).width(384.0F).row();
/*     */     
/*     */     Image image3;
/* 127 */     (image3 = new Image(this.f)).setColor(Color.BLACK);
/* 128 */     image3.setSize(384.0F, 8.0F);
/* 129 */     group.addActor((Actor)image3);
/*     */     
/* 131 */     this.i = new Image(this.f);
/* 132 */     this.i.setColor(MaterialColor.CYAN.P400.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F));
/* 133 */     this.i.setSize(0.0F, 8.0F);
/* 134 */     group.addActor((Actor)this.i);
/*     */ 
/*     */     
/* 137 */     this.l = new Image(this.f);
/* 138 */     this.l.setColor(color);
/* 139 */     this.l.setSize(this.g.getWorldWidth(), this.g.getWorldHeight());
/* 140 */     this.h.addActor((Actor)this.l);
/*     */ 
/*     */     
/* 143 */     this.m = new Group();
/* 144 */     this.m.setSize(290.0F, 356.0F);
/* 145 */     this.m.setOrigin(1);
/* 146 */     this.h.addActor((Actor)this.m);
/*     */     
/* 148 */     this.n = new Image(this.d);
/* 149 */     this.n.setSize(290.0F, 290.0F);
/* 150 */     this.n.setOrigin(1);
/* 151 */     this.n.setPosition(0.0F, 66.0F);
/* 152 */     this.m.addActor((Actor)this.n);
/*     */     
/* 154 */     this.o = new Image(this.e);
/* 155 */     this.o.setSize(254.0F, 56.0F);
/* 156 */     this.o.setOrigin(1);
/* 157 */     this.o.setPosition(18.0F, 0.0F);
/* 158 */     this.m.addActor((Actor)this.o);
/*     */     
/*     */     Image image1;
/* 161 */     (image1 = new Image(this.d)).setSize(290.0F, 290.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield s : Z
/*     */     //   4: ifeq -> 8
/*     */     //   7: return
/*     */     //   8: new com/badlogic/gdx/graphics/Color
/*     */     //   11: dup
/*     */     //   12: fconst_0
/*     */     //   13: fconst_0
/*     */     //   14: fconst_0
/*     */     //   15: fconst_1
/*     */     //   16: invokespecial <init> : (FFFF)V
/*     */     //   19: astore_2
/*     */     //   20: aload_0
/*     */     //   21: getfield q : Z
/*     */     //   24: ifeq -> 117
/*     */     //   27: aload_0
/*     */     //   28: getfield r : F
/*     */     //   31: fconst_0
/*     */     //   32: fcmpl
/*     */     //   33: ifne -> 50
/*     */     //   36: aload_0
/*     */     //   37: dup
/*     */     //   38: getfield r : F
/*     */     //   41: ldc 0.01
/*     */     //   43: fadd
/*     */     //   44: putfield r : F
/*     */     //   47: goto -> 60
/*     */     //   50: aload_0
/*     */     //   51: dup
/*     */     //   52: getfield r : F
/*     */     //   55: fload_1
/*     */     //   56: fadd
/*     */     //   57: putfield r : F
/*     */     //   60: aload_0
/*     */     //   61: getfield k : Lcom/prineside/tdi2/scene2d/ui/Table;
/*     */     //   64: invokevirtual clearActions : ()V
/*     */     //   67: aload_0
/*     */     //   68: getfield k : Lcom/prineside/tdi2/scene2d/ui/Table;
/*     */     //   71: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   74: fconst_1
/*     */     //   75: aload_0
/*     */     //   76: getfield r : F
/*     */     //   79: ldc 0.3
/*     */     //   81: fdiv
/*     */     //   82: fsub
/*     */     //   83: fconst_0
/*     */     //   84: fconst_1
/*     */     //   85: invokestatic clamp : (FFF)F
/*     */     //   88: putfield a : F
/*     */     //   91: aload_0
/*     */     //   92: getfield r : F
/*     */     //   95: ldc 0.3
/*     */     //   97: fcmpl
/*     */     //   98: ifle -> 117
/*     */     //   101: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   104: getfield screenManager : Lcom/prineside/tdi2/managers/ScreenManager;
/*     */     //   107: iconst_1
/*     */     //   108: invokevirtual goToMainMenuJustLaunched : (Z)V
/*     */     //   111: aload_0
/*     */     //   112: iconst_1
/*     */     //   113: putfield s : Z
/*     */     //   116: return
/*     */     //   117: getstatic com/badlogic/gdx/Gdx.gl : Lcom/badlogic/gdx/graphics/GL20;
/*     */     //   120: aload_2
/*     */     //   121: getfield r : F
/*     */     //   124: aload_2
/*     */     //   125: getfield g : F
/*     */     //   128: aload_2
/*     */     //   129: getfield b : F
/*     */     //   132: aload_2
/*     */     //   133: getfield a : F
/*     */     //   136: invokeinterface glClearColor : (FFFF)V
/*     */     //   141: getstatic com/badlogic/gdx/Gdx.gl : Lcom/badlogic/gdx/graphics/GL20;
/*     */     //   144: sipush #16640
/*     */     //   147: invokeinterface glClear : (I)V
/*     */     //   152: aload_0
/*     */     //   153: getfield p : F
/*     */     //   156: ldc 3.0
/*     */     //   158: fcmpl
/*     */     //   159: ifle -> 173
/*     */     //   162: aload_0
/*     */     //   163: getfield b : Lcom/prineside/tdi2/utils/GameSyncLoader;
/*     */     //   166: ldc2_w 30
/*     */     //   169: invokevirtual iterateWithTimeout : (J)Z
/*     */     //   172: pop
/*     */     //   173: aload_0
/*     */     //   174: getfield l : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   177: aload_0
/*     */     //   178: getfield g : Lcom/badlogic/gdx/utils/viewport/ScreenViewport;
/*     */     //   181: invokevirtual getWorldWidth : ()F
/*     */     //   184: aload_0
/*     */     //   185: getfield g : Lcom/badlogic/gdx/utils/viewport/ScreenViewport;
/*     */     //   188: invokevirtual getWorldHeight : ()F
/*     */     //   191: invokevirtual setSize : (FF)V
/*     */     //   194: aload_0
/*     */     //   195: getfield m : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   198: aload_0
/*     */     //   199: getfield g : Lcom/badlogic/gdx/utils/viewport/ScreenViewport;
/*     */     //   202: invokevirtual getWorldWidth : ()F
/*     */     //   205: ldc 0.5
/*     */     //   207: fmul
/*     */     //   208: aload_0
/*     */     //   209: getfield m : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   212: invokevirtual getWidth : ()F
/*     */     //   215: ldc 0.5
/*     */     //   217: fmul
/*     */     //   218: fsub
/*     */     //   219: aload_0
/*     */     //   220: getfield g : Lcom/badlogic/gdx/utils/viewport/ScreenViewport;
/*     */     //   223: invokevirtual getWorldHeight : ()F
/*     */     //   226: ldc 0.5
/*     */     //   228: fmul
/*     */     //   229: aload_0
/*     */     //   230: getfield m : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   233: invokevirtual getHeight : ()F
/*     */     //   236: ldc 0.5
/*     */     //   238: fmul
/*     */     //   239: fsub
/*     */     //   240: invokevirtual setPosition : (FF)V
/*     */     //   243: aload_0
/*     */     //   244: getfield p : F
/*     */     //   247: ldc 3.0
/*     */     //   249: fdiv
/*     */     //   250: dup
/*     */     //   251: fstore_2
/*     */     //   252: fconst_1
/*     */     //   253: fcmpl
/*     */     //   254: ifle -> 276
/*     */     //   257: aload_0
/*     */     //   258: getfield m : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   261: iconst_0
/*     */     //   262: invokevirtual setVisible : (Z)V
/*     */     //   265: aload_0
/*     */     //   266: getfield l : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   269: iconst_0
/*     */     //   270: invokevirtual setVisible : (Z)V
/*     */     //   273: goto -> 560
/*     */     //   276: aload_0
/*     */     //   277: getfield m : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   280: iconst_1
/*     */     //   281: invokevirtual setVisible : (Z)V
/*     */     //   284: aload_0
/*     */     //   285: getfield l : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   288: iconst_1
/*     */     //   289: invokevirtual setVisible : (Z)V
/*     */     //   292: fload_2
/*     */     //   293: f2d
/*     */     //   294: ldc2_w 0.9
/*     */     //   297: dcmpl
/*     */     //   298: ifle -> 328
/*     */     //   301: aload_0
/*     */     //   302: getfield l : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   305: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   308: fconst_1
/*     */     //   309: fload_2
/*     */     //   310: ldc 0.9
/*     */     //   312: fsub
/*     */     //   313: ldc 0.1
/*     */     //   315: fdiv
/*     */     //   316: fsub
/*     */     //   317: fconst_0
/*     */     //   318: fconst_1
/*     */     //   319: invokestatic clamp : (FFF)F
/*     */     //   322: putfield a : F
/*     */     //   325: goto -> 339
/*     */     //   328: aload_0
/*     */     //   329: getfield l : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   332: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   335: fconst_1
/*     */     //   336: putfield a : F
/*     */     //   339: fload_2
/*     */     //   340: f2d
/*     */     //   341: ldc2_w 0.05
/*     */     //   344: dcmpg
/*     */     //   345: iflt -> 436
/*     */     //   348: fload_2
/*     */     //   349: f2d
/*     */     //   350: ldc2_w 0.4
/*     */     //   353: dcmpg
/*     */     //   354: ifge -> 377
/*     */     //   357: aload_0
/*     */     //   358: getfield n : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   361: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   364: fload_2
/*     */     //   365: ldc 0.05
/*     */     //   367: fsub
/*     */     //   368: ldc 0.35
/*     */     //   370: fdiv
/*     */     //   371: putfield a : F
/*     */     //   374: goto -> 447
/*     */     //   377: fload_2
/*     */     //   378: f2d
/*     */     //   379: ldc2_w 0.8
/*     */     //   382: dcmpg
/*     */     //   383: ifge -> 400
/*     */     //   386: aload_0
/*     */     //   387: getfield n : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   390: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   393: fconst_1
/*     */     //   394: putfield a : F
/*     */     //   397: goto -> 447
/*     */     //   400: fload_2
/*     */     //   401: f2d
/*     */     //   402: ldc2_w 0.95
/*     */     //   405: dcmpg
/*     */     //   406: ifge -> 436
/*     */     //   409: aload_0
/*     */     //   410: getfield n : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   413: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   416: fconst_1
/*     */     //   417: fload_2
/*     */     //   418: ldc 0.8
/*     */     //   420: fsub
/*     */     //   421: ldc 0.15
/*     */     //   423: fdiv
/*     */     //   424: fsub
/*     */     //   425: fconst_0
/*     */     //   426: fconst_1
/*     */     //   427: invokestatic clamp : (FFF)F
/*     */     //   430: putfield a : F
/*     */     //   433: goto -> 447
/*     */     //   436: aload_0
/*     */     //   437: getfield n : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   440: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   443: fconst_0
/*     */     //   444: putfield a : F
/*     */     //   447: aload_0
/*     */     //   448: getfield n : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   451: ldc 0.85
/*     */     //   453: ldc 0.15
/*     */     //   455: fload_2
/*     */     //   456: fmul
/*     */     //   457: fadd
/*     */     //   458: invokevirtual setScale : (F)V
/*     */     //   461: fload_2
/*     */     //   462: f2d
/*     */     //   463: ldc2_w 0.2
/*     */     //   466: dcmpg
/*     */     //   467: ifge -> 484
/*     */     //   470: aload_0
/*     */     //   471: getfield o : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   474: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   477: fconst_0
/*     */     //   478: putfield a : F
/*     */     //   481: goto -> 560
/*     */     //   484: fload_2
/*     */     //   485: f2d
/*     */     //   486: ldc2_w 0.6
/*     */     //   489: dcmpg
/*     */     //   490: ifge -> 513
/*     */     //   493: aload_0
/*     */     //   494: getfield o : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   497: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   500: fload_2
/*     */     //   501: ldc 0.2
/*     */     //   503: fsub
/*     */     //   504: ldc 0.4
/*     */     //   506: fdiv
/*     */     //   507: putfield a : F
/*     */     //   510: goto -> 560
/*     */     //   513: fload_2
/*     */     //   514: f2d
/*     */     //   515: ldc2_w 0.8
/*     */     //   518: dcmpg
/*     */     //   519: ifge -> 536
/*     */     //   522: aload_0
/*     */     //   523: getfield o : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   526: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   529: fconst_1
/*     */     //   530: putfield a : F
/*     */     //   533: goto -> 560
/*     */     //   536: aload_0
/*     */     //   537: getfield o : Lcom/prineside/tdi2/scene2d/ui/Image;
/*     */     //   540: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   543: fconst_1
/*     */     //   544: fload_2
/*     */     //   545: ldc 0.8
/*     */     //   547: fsub
/*     */     //   548: ldc 0.2
/*     */     //   550: fdiv
/*     */     //   551: fsub
/*     */     //   552: fconst_0
/*     */     //   553: fconst_1
/*     */     //   554: invokestatic clamp : (FFF)F
/*     */     //   557: putfield a : F
/*     */     //   560: aload_0
/*     */     //   561: getfield h : Lcom/prineside/tdi2/scene2d/Stage;
/*     */     //   564: fload_1
/*     */     //   565: invokevirtual act : (F)V
/*     */     //   568: aload_0
/*     */     //   569: getfield h : Lcom/prineside/tdi2/scene2d/Stage;
/*     */     //   572: invokevirtual draw : ()V
/*     */     //   575: aload_0
/*     */     //   576: dup
/*     */     //   577: getfield p : F
/*     */     //   580: fload_1
/*     */     //   581: fadd
/*     */     //   582: putfield p : F
/*     */     //   585: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #166	-> 0
/*     */     //   #168	-> 8
/*     */     //   #170	-> 20
/*     */     //   #172	-> 27
/*     */     //   #174	-> 36
/*     */     //   #176	-> 50
/*     */     //   #178	-> 60
/*     */     //   #179	-> 67
/*     */     //   #183	-> 91
/*     */     //   #184	-> 101
/*     */     //   #185	-> 111
/*     */     //   #186	-> 116
/*     */     //   #190	-> 117
/*     */     //   #191	-> 141
/*     */     //   #193	-> 152
/*     */     //   #194	-> 162
/*     */     //   #197	-> 173
/*     */     //   #198	-> 194
/*     */     //   #199	-> 202
/*     */     //   #200	-> 223
/*     */     //   #198	-> 240
/*     */     //   #203	-> 243
/*     */     //   #204	-> 251
/*     */     //   #205	-> 257
/*     */     //   #206	-> 265
/*     */     //   #208	-> 276
/*     */     //   #209	-> 284
/*     */     //   #212	-> 292
/*     */     //   #213	-> 301
/*     */     //   #215	-> 328
/*     */     //   #219	-> 339
/*     */     //   #221	-> 348
/*     */     //   #223	-> 357
/*     */     //   #224	-> 377
/*     */     //   #226	-> 386
/*     */     //   #227	-> 400
/*     */     //   #229	-> 409
/*     */     //   #232	-> 436
/*     */     //   #234	-> 447
/*     */     //   #237	-> 461
/*     */     //   #238	-> 470
/*     */     //   #239	-> 484
/*     */     //   #240	-> 493
/*     */     //   #241	-> 513
/*     */     //   #242	-> 522
/*     */     //   #245	-> 536
/*     */     //   #249	-> 560
/*     */     //   #250	-> 568
/*     */     //   #252	-> 575
/*     */     //   #253	-> 585
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(int paramInt1, int paramInt2) {
/* 257 */     super.resize(paramInt1, paramInt2);
/*     */     
/* 259 */     if (paramInt1 > 0 && paramInt2 > 0) {
/* 260 */       a.i("resize " + paramInt2 + " " + Gdx.graphics.getBackBufferHeight(), new Object[0]);
/*     */       
/* 262 */       paramInt1 = Gdx.graphics.getBackBufferWidth();
/* 263 */       paramInt2 = Gdx.graphics.getBackBufferHeight();
/*     */       
/* 265 */       float f = 1080.0F / Gdx.graphics.getHeight();
/* 266 */       this.g.setUnitsPerPixel(f);
/* 267 */       this.g.update(paramInt1, paramInt2, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 273 */     this.c.dispose();
/* 274 */     this.d.dispose();
/* 275 */     this.e.dispose();
/* 276 */     this.h.dispose();
/* 277 */     this.f.dispose();
/*     */     
/* 279 */     a.i("disposed", new Object[0]);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\LoadingScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */