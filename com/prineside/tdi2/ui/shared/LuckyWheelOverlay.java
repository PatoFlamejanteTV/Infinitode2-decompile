/*      */ package com.prineside.tdi2.ui.shared;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.math.Vector3;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.enums.ShapeType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*      */ import com.prineside.tdi2.shapes.Circle;
/*      */ import com.prineside.tdi2.shapes.PieChart;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*      */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.actors.TrailMultilineActor;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ public final class LuckyWheelOverlay extends UiManager.UiComponent.Adapter {
/*   52 */   private static final TLog a = TLog.forClass(LuckyWheelOverlay.class);
/*      */   public static LuckyWheelOverlay i() {
/*   54 */     return (LuckyWheelOverlay)Game.i.uiManager.getComponent(LuckyWheelOverlay.class);
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
/*   66 */   private static final Interpolation b = Interpolation.sine;
/*      */   
/*      */   private static final Color c;
/*   69 */   private static final Color d = (c = MaterialColor.YELLOW.P600).cpy().mul(1.0F, 1.0F, 1.0F, 0.28F);
/*      */   private static final Color e;
/*   71 */   private static final Color f = (e = MaterialColor.YELLOW.P300).cpy().mul(1.0F, 1.0F, 1.0F, 0.56F);
/*      */   
/*   73 */   private final UiManager.UiLayer g = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 90, "LuckyWheelOverlay tint");
/*   74 */   private final UiManager.UiLayer h = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 91, "LuckyWheelOverlay main");
/*      */   
/*      */   private Color[] i;
/*      */   
/*      */   private Color[] j;
/*      */   private Color[] k;
/*      */   private Color[] l;
/*      */   private final Group m;
/*      */   private final Group n;
/*      */   private final ParticlesCanvas o;
/*      */   private final Group p;
/*      */   private final Group q;
/*      */   private final PieChartActor r;
/*      */   private final PieChartActor s;
/*      */   private final Group t;
/*      */   private final Image u;
/*      */   private final Table v;
/*      */   private final Label w;
/*   92 */   private int x = -1;
/*      */   
/*      */   private boolean y;
/*   95 */   private final Array<WheelOptionConfig> z = new Array(WheelOptionConfig.class);
/*      */   
/*      */   private float A;
/*      */   
/*      */   private boolean B;
/*      */   
/*      */   private boolean C;
/*      */   private float D;
/*      */   private float E;
/*      */   private float F;
/*      */   private float G;
/*      */   private float H;
/*      */   private float I;
/*      */   private boolean J;
/*      */   private boolean K;
/*      */   private float L;
/*  111 */   private float M = 0.0F;
/*      */   private final Group N;
/*  113 */   private final TrailMultilineActor[] O = new TrailMultilineActor[5];
/*  114 */   private final Image[] P = new Image[5];
/*  115 */   private float Q = 0.0F;
/*      */   
/*      */   private final ParticleEffectPool R;
/*      */   
/*  119 */   private static final Vector2 S = new Vector2();
/*      */   
/*      */   private float T;
/*      */   private boolean U;
/*      */   
/*      */   public LuckyWheelOverlay() {
/*      */     Image image4;
/*  126 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  127 */     (image4.getColor()).a = 0.78F;
/*  128 */     this.g.getTable().add((Actor)image4).expand().fill();
/*  129 */     this.g.getTable().setTouchable(Touchable.enabled);
/*  130 */     this.g.getTable().addListener((EventListener)new ClickListener(this)
/*      */         {
/*      */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  133 */             if (!LuckyWheelOverlay.a(this.a) && !LuckyWheelOverlay.b(this.a)) {
/*  134 */               this.a.setVisible(false);
/*      */             }
/*      */           }
/*      */         });
/*      */     
/*      */     Group group2;
/*  140 */     (group2 = new Group()).setTransform(false);
/*  141 */     group2.setOrigin(240.0F, 240.0F);
/*  142 */     this.h.getTable().add((Actor)group2).size(480.0F, 480.0F);
/*      */     
/*  144 */     this.m = new Group();
/*  145 */     this.m.setTransform(true);
/*  146 */     this.m.setOrigin(240.0F, 240.0F);
/*  147 */     this.m.setSize(480.0F, 480.0F);
/*  148 */     group2.addActor((Actor)this.m);
/*      */     
/*  150 */     this.o = new ParticlesCanvas();
/*  151 */     this.o.setSize(480.0F, 480.0F);
/*  152 */     this.m.addActor((Actor)this.o);
/*      */ 
/*      */     
/*  155 */     this.n = new Group();
/*  156 */     this.n.setOrigin(240.0F, 240.0F);
/*  157 */     this.n.setSize(480.0F, 480.0F);
/*  158 */     this.m.addActor((Actor)this.n);
/*      */     
/*  160 */     this.R = Game.i.assetManager.getParticleEffectPool("lucky-wheel-hit.prt");
/*      */     
/*  162 */     this.r = new PieChartActor();
/*  163 */     this.r.setSegmentCount(360);
/*  164 */     this.r.chart.setShadowSegments(-1);
/*  165 */     this.r.chart.setFadeToOut(true);
/*  166 */     this.r.setSize(640.0F, 640.0F);
/*  167 */     this.r.setPosition(-80.0F, -80.0F);
/*  168 */     this.n.addActor((Actor)this.r);
/*      */     
/*      */     Image image3;
/*  171 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setSize(292.0F, 292.0F);
/*  172 */     image3.setPosition(94.0F, 94.0F);
/*  173 */     image3.setColor(Config.BACKGROUND_COLOR);
/*  174 */     this.n.addActor((Actor)image3);
/*      */     
/*  176 */     this.s = new PieChartActor();
/*  177 */     this.s.setSegmentCount(360);
/*  178 */     this.s.setSize(280.0F, 280.0F);
/*  179 */     this.s.setPosition(100.0F, 100.0F);
/*  180 */     this.s.chart.setShadowSegments(-1);
/*  181 */     this.n.addActor((Actor)this.s);
/*      */     
/*      */     Circle circle;
/*  184 */     (circle = (Circle)Game.i.shapeManager.getFactory(ShapeType.CIRCLE).obtain()).setup(240.0F, 240.0F, 0.0F, 128.0F, 360, Config.BACKGROUND_COLOR.toFloatBits(), Config.BACKGROUND_COLOR.toFloatBits());
/*      */ 
/*      */ 
/*      */     
/*      */     Actor actor2;
/*      */ 
/*      */     
/*  191 */     (actor2 = new Actor(this, circle) { public void draw(Batch param1Batch, float param1Float) { this.j.draw(param1Batch); } }).setSize(256.0F, 256.0F);
/*  192 */     this.n.addActor(actor2);
/*      */     
/*  194 */     this.p = new Group();
/*  195 */     this.p.setTransform(false);
/*  196 */     this.p.setSize(480.0F, 480.0F);
/*  197 */     this.n.addActor((Actor)this.p);
/*      */     
/*      */     Image image2;
/*      */     
/*  201 */     (image2 = new Image((Drawable)Game.i.assetManager.getQuad("towers.GAUSS.base"))).setSize(128.0F, 128.0F);
/*  202 */     image2.setPosition(176.0F, 176.0F);
/*  203 */     this.m.addActor((Actor)image2);
/*      */     
/*  205 */     for (byte b2 = 0; b2 < this.O.length; b2++) {
/*  206 */       this.O[b2] = new TrailMultilineActor();
/*  207 */       this.O[b2].setup(MaterialColor.ORANGE.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.0F), 8.0F, 0.4F, 0.0F);
/*  208 */       this.O[b2].setPosition(240.0F, 267.0F + b2 * 12.0F);
/*  209 */       this.m.addActor((Actor)this.O[b2]);
/*      */     } 
/*      */     
/*  212 */     this.N = new Group();
/*  213 */     this.N.setTransform(true);
/*  214 */     this.N.setSize(28.0F, 105.0F);
/*  215 */     this.N.setOrigin(14.0F, 21.0F);
/*  216 */     this.N.setPosition(226.0F, 219.0F);
/*  217 */     this.m.addActor((Actor)this.N);
/*      */     
/*      */     Image image1;
/*  220 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tower-gauss-weapon"))).setSize(28.0F, 105.0F);
/*  221 */     this.N.addActor((Actor)image1);
/*      */     
/*  223 */     for (byte b1 = 0; b1 < this.P.length; b1++) {
/*  224 */       this.P[b1] = new Image((Drawable)Game.i.assetManager.getDrawable("tower-gauss-weapon-glow"));
/*  225 */       this.P[b1].setPosition(-4.0F, 36.0F + b1 * 12.0F);
/*  226 */       this.P[b1].setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  227 */       this.N.addActor((Actor)this.P[b1]);
/*      */     } 
/*      */     
/*      */     Group group1;
/*      */     
/*  232 */     (group1 = new Group()).setTouchable(Touchable.enabled);
/*  233 */     group1.setTransform(false);
/*  234 */     group1.setSize(100.0F, 480.0F);
/*  235 */     group1.setPosition(580.0F, 0.0F);
/*  236 */     this.m.addActor((Actor)group1);
/*      */ 
/*      */ 
/*      */     
/*      */     QuadActor quadActor;
/*      */ 
/*      */ 
/*      */     
/*  244 */     (quadActor = new QuadActor(Color.WHITE, new float[] { 2.0F, 4.0F, 0.0F, 442.0F, 22.0F, 448.0F, 24.0F, 0.0F })).setSize(24.0F, 448.0F);
/*  245 */     quadActor.setPosition(38.0F, 16.0F);
/*  246 */     quadActor.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  247 */     group1.addActor((Actor)quadActor);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  255 */     (quadActor = new QuadActor(Color.WHITE, new float[] { 2.0F, 4.0F, 0.0F, 442.0F, 10.0F, 446.0F, 9.0F, 3.0F })).setSize(10.0F, 446.0F);
/*  256 */     quadActor.setPosition(38.0F, 16.0F);
/*  257 */     quadActor.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  258 */     group1.addActor((Actor)quadActor);
/*      */     
/*  260 */     this.t = new Group();
/*  261 */     this.t.setTransform(false);
/*  262 */     this.t.setSize(100.0F, 64.0F);
/*  263 */     this.t.setPosition(0.0F, 416.0F);
/*  264 */     this.t.setPosition(0.0F, 416.0F);
/*  265 */     this.t.setTouchable(Touchable.enabled);
/*  266 */     this.t.addListener((EventListener)new InputListener(this)
/*      */         {
/*      */           private float a;
/*      */           
/*  270 */           private int b = 0;
/*      */ 
/*      */           
/*      */           private float a(float param1Float) {
/*  274 */             if ((param1Float = this.a - param1Float) < 0.0F) {
/*  275 */               param1Float = 0.0F;
/*  276 */             } else if (param1Float > 416.0F) {
/*  277 */               param1Float = 416.0F;
/*      */             } 
/*      */             
/*  280 */             return param1Float;
/*      */           }
/*      */           
/*      */           private void b(float param1Float) {
/*  284 */             float f = a(param1Float);
/*  285 */             LuckyWheelOverlay.c(this.c).setPosition(0.0F, 416.0F - f);
/*      */ 
/*      */ 
/*      */             
/*  289 */             if ((f = this.a - param1Float) < 0.0F) {
/*  290 */               f = 0.0F;
/*  291 */             } else if (f > 416.0F) {
/*  292 */               f = 416.0F;
/*      */             } 
/*  294 */             f /= 416.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  303 */             FastRandom.getFairInt(2);
/*  304 */             StaticSoundType staticSoundType = StaticSoundType.SPRING_TENSION_2;
/*      */             
/*  306 */             if (f > 0.96D && this.b < 7) {
/*  307 */               this.b = 7;
/*  308 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.68F, 1.165F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*  309 */               Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_1, 0.3F, 1.16F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  310 */             }  if (f > 0.86D && this.b < 6) {
/*  311 */               this.b = 6;
/*  312 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.65F, 1.125F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*  313 */               Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_1, 0.25F, 1.12F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  314 */             }  if (f > 0.75D && this.b < 5) {
/*  315 */               this.b = 5;
/*  316 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.62F, 1.09F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*  317 */               Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_1, 0.2F, 1.09F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  318 */             }  if (f > 0.63D && this.b < 4) {
/*  319 */               this.b = 4;
/*  320 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.59F, 1.06F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*  321 */               Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_1, 0.15F, 1.06F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  322 */             }  if (f > 0.5D && this.b < 3) {
/*  323 */               this.b = 3;
/*  324 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.56F, 1.035F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*  325 */               Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_1, 0.1F, 1.03F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  326 */             }  if (f > 0.36D && this.b < 2) {
/*  327 */               this.b = 2;
/*  328 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.53F, 1.015F + FastRandom.getFloat() * 0.05F, 1.0F, false); return;
/*  329 */             }  if (f > 0.205D && this.b <= 0) {
/*  330 */               this.b = 1;
/*  331 */               Game.i.soundManager.playStaticParameterized(staticSoundType, 0.5F, 1.0F + FastRandom.getFloat() * 0.05F, 1.0F, false);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  337 */             if (LuckyWheelOverlay.a(this.c) || !Game.i.progressManager.isLuckyWheelSpinAvailable()) {
/*  338 */               return false;
/*      */             }
/*      */             
/*  341 */             param1InputEvent.cancel();
/*      */             
/*  343 */             this.b = 0;
/*  344 */             LuckyWheelOverlay.a(this.c, false);
/*  345 */             this.a = param1InputEvent.getStageY();
/*      */             
/*  347 */             return true;
/*      */           }
/*      */ 
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  352 */             if (!LuckyWheelOverlay.d(this.c)) {
/*      */               return;
/*      */             }
/*      */             float f;
/*  356 */             if ((f = (f = a(param1InputEvent.getStageY())) / 416.0F) > 0.2F)
/*      */             {
/*  358 */               LuckyWheelOverlay.a(this.c, f);
/*      */             }
/*      */             
/*  361 */             LuckyWheelOverlay.c(this.c).clearActions();
/*  362 */             LuckyWheelOverlay.c(this.c).addAction(
/*  363 */                 (Action)Actions.parallel(
/*  364 */                   (Action)Actions.moveTo(0.0F, 416.0F, 0.2F, (Interpolation)Interpolation.pow3In), 
/*  365 */                   (Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.run(() -> Game.i.soundManager.playStaticParameterized(StaticSoundType.SPRING_TENSION_RELEASE, Math.min(param1Float * 2.0F, 0.8F), 1.0F, 1.0F, false)))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  375 */             b(param1InputEvent.getStageY());
/*      */           }
/*      */         });
/*  378 */     group1.addActor((Actor)this.t);
/*      */     
/*      */     Actor actor1;
/*  381 */     (actor1 = new Actor()).setSize(164.0F, 128.0F);
/*  382 */     actor1.setPosition(-32.0F, -32.0F);
/*  383 */     actor1.setTouchable(Touchable.enabled);
/*  384 */     this.t.addActor(actor1);
/*      */     
/*  386 */     this.u = new Image((Drawable)Game.i.assetManager.getDrawable("ui-lucky-wheel-handle"));
/*  387 */     this.u.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  388 */     this.u.setSize(100.0F, 64.0F);
/*  389 */     this.u.setTouchable(Touchable.disabled);
/*  390 */     this.t.addActor((Actor)this.u);
/*      */ 
/*      */     
/*  393 */     this.q = new Group();
/*  394 */     this.q.setTransform(false);
/*  395 */     this.q.setSize(640.0F, 128.0F);
/*  396 */     this.q.setPosition(-80.0F, -224.0F);
/*  397 */     this.m.addActor((Actor)this.q);
/*      */     
/*  399 */     this.v = new Table();
/*  400 */     this.v.setSize(640.0F, 96.0F);
/*  401 */     this.v.setPosition(-80.0F, 192.0F);
/*  402 */     this.v.background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.76F)));
/*  403 */     this.m.addActor((Actor)this.v);
/*      */     
/*      */     Label label;
/*  406 */     (label = new Label(Game.i.localeManager.i18n.get("lucky_shot_disabled_after_cloud_load"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  407 */     label.setColor(MaterialColor.AMBER.P300);
/*  408 */     label.setAlignment(1);
/*  409 */     this.v.add((Actor)label).width(600.0F).row();
/*      */     
/*  411 */     this.w = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  412 */     this.v.add((Actor)this.w).padTop(8.0F);
/*      */     
/*  414 */     this.g.getTable().setVisible(false);
/*  415 */     this.h.getTable().setVisible(false);
/*      */     
/*  417 */     h();
/*      */   }
/*      */   
/*      */   private float b() {
/*  421 */     return this.B ? this.A : (ProgressPrefs.i()).progress.getLuckyWheelLastRotation();
/*      */   }
/*      */   
/*      */   private float c() {
/*  425 */     return this.B ? this.M : (ProgressPrefs.i()).progress.getLuckyWheelLastWeaponAngle();
/*      */   }
/*      */   
/*      */   private void a(float paramFloat) {
/*  429 */     if (!Game.i.progressManager.isLuckyWheelSpinAvailable()) {
/*  430 */       a.e("spin not available", new Object[0]);
/*      */       return;
/*      */     } 
/*  433 */     if (Game.i.progressManager.getSecondsTillLuckyWheelSpinAvailable() > 0) {
/*  434 */       a.e("spin is not yet available", new Object[0]);
/*      */       return;
/*      */     } 
/*  437 */     a.i("spin", new Object[0]);
/*      */     
/*  439 */     (ProgressPrefs.i()).progress.setLuckyWheelSpinInProgress(true);
/*  440 */     (ProgressPrefs.i()).progress.setLuckyWheelSpinAvailable(false);
/*      */     
/*  442 */     this.B = true;
/*  443 */     this.E = (ProgressPrefs.i()).progress.getLuckyWheelLastRotation();
/*  444 */     this.D = this.E + ((int)(paramFloat * 5.0F) + 3) * 360.0F + (ProgressPrefs.i()).progress.getLuckyWheelSpinRandom().nextFloat() * 360.0F;
/*  445 */     this.G = (ProgressPrefs.i()).progress.getLuckyWheelLastWeaponAngle();
/*  446 */     this.F = this.G - ((int)(paramFloat * 3.0F) + 1) * 360.0F - (ProgressPrefs.i()).progress.getLuckyWheelSpinRandom().nextFloat() * 360.0F;
/*  447 */     this.I = 0.0F;
/*  448 */     this.H = 2.5F + (float)StrictMath.random() * 0.5F + 3.0F * paramFloat;
/*      */     
/*  450 */     (ProgressPrefs.i()).progress.setLuckyWheelLastRotation(this.D);
/*  451 */     (ProgressPrefs.i()).progress.setLuckyWheelLastWeaponAngle(this.F);
/*      */     
/*  453 */     ProgressPrefs.i().requireSave();
/*      */     
/*  455 */     f();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*  462 */     a.i("prepareRespin", new Object[0]);
/*      */     
/*  464 */     (ProgressPrefs.i()).progress.setLuckyWheelSpinAvailable(true);
/*  465 */     ProgressPrefs.i().requireSave();
/*      */ 
/*      */     
/*  468 */     Array array = new Array(WheelOptionConfig.class); byte b1;
/*  469 */     for (b1 = 0; b1 < this.z.size; b1++) {
/*  470 */       if ((((WheelOptionConfig[])this.z.items)[b1]).wasHit) {
/*  471 */         array.add(((WheelOptionConfig[])this.z.items)[b1]);
/*      */       }
/*      */     } 
/*  474 */     if (array.size == 0) {
/*      */       
/*  476 */       rebuild();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  481 */     for (b1 = 0; b1 < this.z.size; b1++) {
/*      */       WheelOptionConfig wheelOptionConfig;
/*  483 */       WheelOptionConfig.a(wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b1]).clearActions();
/*      */       
/*  485 */       if (array.contains(wheelOptionConfig, true)) {
/*      */         
/*  487 */         WheelOptionConfig.a(wheelOptionConfig).addAction((Action)Actions.scaleTo(0.0F, 0.0F, 0.5F, b));
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  492 */         wheelOptionConfig.respinPrepareFromAngle = WheelOptionConfig.b(wheelOptionConfig);
/*  493 */         WheelOptionConfig.a(wheelOptionConfig).addAction((Action)Actions.parallel(
/*  494 */               (Action)Actions.alpha(1.0F, 0.5F, b), 
/*  495 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.5F, b)));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  503 */     FloatArray floatArray = new FloatArray(); byte b2;
/*  504 */     for (b2 = 0; b2 < array.size; b2++) {
/*  505 */       floatArray.add((WheelOptionConfig.c(((WheelOptionConfig[])array.items)[b2])).chance);
/*  506 */       (WheelOptionConfig.c(((WheelOptionConfig[])array.items)[b2])).chance = 0.0F;
/*      */     } 
/*  508 */     g();
/*  509 */     for (b2 = 0; b2 < array.size; b2++) {
/*  510 */       (WheelOptionConfig.c(((WheelOptionConfig[])array.items)[b2])).chance = floatArray.items[b2];
/*      */     }
/*      */ 
/*      */     
/*  514 */     this.J = true;
/*  515 */     this.L = 0.0F;
/*      */ 
/*      */     
/*  518 */     f();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e() {
/*  525 */     a.i("prepareNextWheel", new Object[0]);
/*      */     
/*  527 */     this.K = true;
/*  528 */     f();
/*      */     
/*  530 */     this.n.clearActions();
/*  531 */     this.n.addAction((Action)Actions.sequence(
/*  532 */           (Action)Actions.scaleTo(0.0F, 0.0F, 0.3F, (Interpolation)Interpolation.pow2In), 
/*  533 */           (Action)Actions.run(() -> {
/*      */               Game.i.progressManager.generateNewLuckyWheel();
/*      */               
/*      */               (ProgressPrefs.i()).progress.setLuckyWheelSpinAvailable(true);
/*      */               ProgressPrefs.i().requireSave();
/*      */               this.o.clearParticles();
/*      */               rebuild();
/*  540 */             }), (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F, (Interpolation)Interpolation.pow2Out), 
/*  541 */           (Action)Actions.run(() -> {
/*      */               this.K = false;
/*      */               f();
/*      */             })));
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(WheelOptionConfig paramWheelOptionConfig) {
/*  549 */     a.i("onSpinFinished", new Object[0]);
/*      */     
/*  551 */     (ProgressPrefs.i()).progress.setLuckyWheelSpinInProgress(false);
/*  552 */     ProgressPrefs.i().requireSave();
/*      */     
/*      */     Array array;
/*      */     
/*  556 */     if (!(array = Game.i.progressManager.getLuckyWheelOptions()).removeValue(WheelOptionConfig.c(paramWheelOptionConfig), true)) {
/*  557 */       throw new IllegalStateException("can't remove last hit option from manager");
/*      */     }
/*      */     
/*  560 */     if (array.size < 5)
/*      */     {
/*  562 */       for (int i = array.size - 1; i >= 0; i--) {
/*  563 */         if ((((WheelOption[])array.items)[i]).wheelMultiplier != 0) {
/*  564 */           WheelOption wheelOption = (WheelOption)array.removeIndex(i);
/*      */ 
/*      */           
/*  567 */           for (byte b = 0; b < this.z.size; b++) {
/*  568 */             if (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b]) == wheelOption) {
/*  569 */               (((WheelOptionConfig[])this.z.items)[b]).wasHit = true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  576 */     if ((WheelOptionConfig.c(paramWheelOptionConfig)).wheelMultiplier == 0) {
/*      */       IssuedItems issuedItems;
/*      */       
/*  579 */       (issuedItems = new IssuedItems(IssuedItems.IssueReason.LUCKY_SHOT, Game.getTimestampSeconds())).items.add((WheelOptionConfig.c(paramWheelOptionConfig)).item);
/*  580 */       Game.i.progressManager.addIssuedPrizes(issuedItems, false);
/*  581 */       Game.i.progressManager.addItemStack((WheelOptionConfig.c(paramWheelOptionConfig)).item, "lucky_wheel");
/*      */     } else {
/*      */       byte b;
/*      */       
/*  585 */       for (b = 0; b < array.size; b++) {
/*  586 */         if ((((WheelOption[])array.items)[b]).item != null && (((WheelOption[])array.items)[b]).item.getItem().affectedByLuckyWheelMultiplier()) {
/*  587 */           (((WheelOption[])array.items)[b]).item.setCount(PMath.multiplyWithoutOverflow((((WheelOption[])array.items)[b]).item.getCount(), (WheelOptionConfig.c(paramWheelOptionConfig)).wheelMultiplier));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  592 */       for (b = 0; b < this.z.size; b++) {
/*  593 */         if ((WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b])).item != null && 
/*  594 */           WheelOptionConfig.d(((WheelOptionConfig[])this.z.items)[b]) != null) {
/*  595 */           WheelOptionConfig.d(((WheelOptionConfig[])this.z.items)[b]).setText("x" + (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b])).item.getCount());
/*  596 */           WheelOptionConfig.d(((WheelOptionConfig[])this.z.items)[b]).clearActions();
/*  597 */           WheelOptionConfig.d(((WheelOptionConfig[])this.z.items)[b]).addAction((Action)Actions.sequence((Action)Actions.scaleTo(1.5F, 1.5F, 0.3F), (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F)));
/*      */         } 
/*      */       } 
/*      */       
/*  601 */       (ProgressPrefs.i()).progress.setLuckyWheelCurrentMultiplier((ProgressPrefs.i()).progress.getLuckyWheelCurrentMultiplier() * (WheelOptionConfig.c(paramWheelOptionConfig)).wheelMultiplier);
/*  602 */       ProgressPrefs.i().requireSave();
/*      */       
/*  604 */       d();
/*      */     } 
/*      */     
/*  607 */     f();
/*      */   }
/*      */   
/*      */   private void f() {
/*  611 */     this.q.clear();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  619 */     this.y = false;
/*  620 */     if (this.B || this.J || this.K) {
/*  621 */       this.y = false; return;
/*      */     } 
/*  623 */     if (Game.i.progressManager.isLuckyWheelSpinAvailable()) {
/*      */       
/*  625 */       this.y = true;
/*      */       return;
/*      */     } 
/*  628 */     this.y = false;
/*  629 */     int i = Game.i.progressManager.getLuckyWheelRespinPriceTokens();
/*  630 */     int j = Game.i.progressManager.getLuckyWheelRespinPriceAccelerators();
/*      */     
/*  632 */     if (i > 0 || j > 0) {
/*      */       Table table;
/*  634 */       (table = new Table()).setSize((i > 0) ? 392.0F : 192.0F, 42.0F);
/*  635 */       table.setPosition((i > 0) ? 248.0F : 448.0F, 86.0F);
/*  636 */       this.q.addActor((Actor)table);
/*      */       
/*      */       Image image;
/*  639 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-restart"))).setColor(MaterialColor.GREEN.P300);
/*  640 */       table.add((Actor)image).size(32.0F).padRight(6.0F);
/*      */       
/*      */       Label label;
/*  643 */       (label = new Label(Game.i.localeManager.i18n.get("lucky_shot_respin_title"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P300);
/*  644 */       table.add((Actor)label);
/*      */       
/*  646 */       if (i > 0) {
/*  647 */         ComplexButton complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */               int i = Game.i.progressManager.getLuckyWheelRespinPriceTokens();
/*      */               if (Game.i.progressManager.removeItems((Item)Item.D.LUCKY_SHOT_TOKEN, i)) {
/*      */                 Game.i.analyticsManager.logCurrencySpent("lucky_wheel_respin", "lucky_shot_token", i);
/*      */                 d();
/*      */                 return;
/*      */               } 
/*      */               Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_tokens"), null, null, null);
/*      */             });
/*      */         Table table4;
/*  657 */         (table4 = new Table()).setSize(192.0F, 80.0F);
/*  658 */         complexButton1.addActor((Actor)table4);
/*      */         
/*  660 */         Image image4 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"));
/*  661 */         table4.add((Actor)image4).size(48.0F).padRight(6.0F);
/*      */         
/*  663 */         Label label4 = new Label("x" + i, Game.i.assetManager.getLabelStyle(30));
/*  664 */         table4.add((Actor)label4);
/*      */         
/*  666 */         complexButton1.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 3.0F, 80.0F, 189.0F, 77.0F, 192.0F, 3.0F })), 0.0F, 0.0F, 192.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  672 */         complexButton1.setBackgroundColors(MaterialColor.GREEN.P800
/*  673 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.GREEN.P900
/*  674 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.GREEN.P700
/*  675 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.RED.P800
/*  676 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*      */         
/*  678 */         complexButton1.setSize(192.0F, 80.0F);
/*  679 */         complexButton1.setPosition(248.0F, 0.0F);
/*  680 */         this.q.addActor((Actor)complexButton1);
/*      */       } 
/*      */       
/*  683 */       if (j > 0) {
/*  684 */         ComplexButton complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */               int i = Game.i.progressManager.getLuckyWheelRespinPriceAccelerators();
/*      */               if (Game.i.progressManager.removeItems((Item)Item.D.ACCELERATOR, i)) {
/*      */                 Game.i.analyticsManager.logCurrencySpent("lucky_wheel_respin", "accelerator", i);
/*      */                 d();
/*      */                 return;
/*      */               } 
/*      */               Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_accelerators"), null, null, null);
/*      */             });
/*      */         Table table4;
/*  694 */         (table4 = new Table()).setSize(192.0F, 80.0F);
/*  695 */         complexButton1.addActor((Actor)table4);
/*      */         
/*  697 */         Image image4 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"));
/*  698 */         table4.add((Actor)image4).size(48.0F).padRight(6.0F);
/*      */         
/*  700 */         Label label4 = new Label("x" + j, Game.i.assetManager.getLabelStyle(30));
/*  701 */         table4.add((Actor)label4);
/*      */         
/*  703 */         complexButton1.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 3.0F, 3.0F, 0.0F, 77.0F, 192.0F, 80.0F, 189.0F, 0.0F })), 0.0F, 0.0F, 192.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  709 */         complexButton1.setBackgroundColors(MaterialColor.GREEN.P800
/*  710 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.GREEN.P900
/*  711 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.GREEN.P700
/*  712 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.RED.P800
/*  713 */             .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*      */         
/*  715 */         complexButton1.setSize(192.0F, 80.0F);
/*  716 */         complexButton1.setPosition(448.0F, 0.0F);
/*  717 */         this.q.addActor((Actor)complexButton1);
/*      */       } 
/*      */     } 
/*      */     
/*      */     Table table2;
/*  722 */     (table2 = new Table()).setSize(192.0F, 42.0F);
/*  723 */     table2.setPosition(0.0F, 86.0F);
/*  724 */     this.q.addActor((Actor)table2);
/*      */     
/*      */     Image image2;
/*  727 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lucky-wheel-plus"))).setColor(MaterialColor.LIGHT_BLUE.P300);
/*  728 */     table2.add((Actor)image2).size(32.0F).padRight(6.0F);
/*      */     
/*      */     Label label3;
/*  731 */     (label3 = new Label(Game.i.localeManager.i18n.get("lucky_shot_new_wheel_title"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P300);
/*  732 */     table2.add((Actor)label3);
/*      */     
/*  734 */     ComplexButton complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */           if (Game.i.progressManager.removeItems((Item)Item.D.LUCKY_SHOT_TOKEN, 1)) {
/*      */             Game.i.analyticsManager.logCurrencySpent("lucky_wheel_spin", "lucky_shot_token", 1);
/*      */             e();
/*      */             return;
/*      */           } 
/*      */           Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_tokens"), null, null, null);
/*      */         });
/*      */     Table table3;
/*  743 */     (table3 = new Table()).setSize(192.0F, 80.0F);
/*  744 */     complexButton.addActor((Actor)table3);
/*      */     
/*  746 */     Image image3 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"));
/*  747 */     table3.add((Actor)image3).size(48.0F).padRight(6.0F);
/*      */     
/*  749 */     Label label1 = new Label("x1", Game.i.assetManager.getLabelStyle(30));
/*  750 */     table3.add((Actor)label1);
/*      */     
/*  752 */     complexButton.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 3.0F, 3.0F, 0.0F, 77.0F, 192.0F, 80.0F, 189.0F, 0.0F })), 0.0F, 0.0F, 192.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  758 */     complexButton.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800
/*  759 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.LIGHT_BLUE.P900
/*  760 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.LIGHT_BLUE.P700
/*  761 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.RED.P800
/*  762 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*      */     
/*  764 */     complexButton.setSize(192.0F, 80.0F);
/*  765 */     complexButton.setPosition(0.0F, 0.0F);
/*  766 */     this.q.addActor((Actor)complexButton);
/*      */     
/*      */     Table table1;
/*      */     
/*  770 */     (table1 = new Table()).setTouchable(Touchable.disabled);
/*  771 */     table1.setPosition(0.0F, 140.0F);
/*  772 */     table1.setSize(this.q.getWidth(), 48.0F);
/*  773 */     this.q.addActor((Actor)table1);
/*      */     
/*  775 */     Image image1 = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-shot-token"));
/*  776 */     table1.add((Actor)image1).size(48.0F).padRight(10.0F);
/*      */     
/*      */     Label label2;
/*  779 */     (label2 = new Label(Game.i.progressManager.getItemsCount((Item)Item.D.LUCKY_SHOT_TOKEN), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.78F);
/*  780 */     table1.add((Actor)label2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void g() {
/*  786 */     if (this.z.size == 0)
/*      */       return; 
/*  788 */     float f1 = 0.0F;
/*  789 */     for (byte b1 = 0; b1 < this.z.size; b1++) {
/*  790 */       f1 += (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b1])).chance;
/*      */     }
/*  792 */     float f2 = 360.0F / f1;
/*  793 */     f1 = 0.0F;
/*  794 */     for (byte b2 = 0; b2 < this.z.size; b2++) {
/*  795 */       WheelOptionConfig wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b2];
/*      */       
/*  797 */       float f = f1;
/*  798 */       f1 += (WheelOptionConfig.c(wheelOptionConfig)).chance * f2;
/*  799 */       WheelOptionConfig.a(wheelOptionConfig, f);
/*  800 */       WheelOptionConfig.b(wheelOptionConfig, f1);
/*  801 */       WheelOptionConfig.c(wheelOptionConfig, (f + f1) * 0.5F);
/*      */     } 
/*  803 */     WheelOptionConfig.b(((WheelOptionConfig[])this.z.items)[this.z.size - 1], 360.0F);
/*      */   }
/*      */   
/*      */   private void h() {
/*  807 */     this.i = Game.i.progressManager.getRarityColors();
/*  808 */     this.j = Game.i.progressManager.getRarityBrightColors();
/*  809 */     this.k = new Color[this.i.length];
/*  810 */     this.l = new Color[this.i.length];
/*  811 */     for (byte b = 0; b < RarityType.values.length; b++) {
/*  812 */       this.k[b] = this.i[b].cpy().mul(1.0F, 1.0F, 1.0F, 0.28F);
/*  813 */       this.l[b] = this.j[b].cpy().mul(1.0F, 1.0F, 1.0F, 0.56F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void rebuild() {
/*  818 */     Array array2 = Game.i.progressManager.getLuckyWheelOptions();
/*      */     
/*  820 */     this.z.clear();
/*  821 */     for (byte b2 = 0; b2 < array2.size; b2++) {
/*      */       WheelOptionConfig wheelOptionConfig;
/*  823 */       WheelOptionConfig.a(wheelOptionConfig = new WheelOptionConfig(), ((WheelOption[])array2.items)[b2]);
/*  824 */       this.z.add(wheelOptionConfig);
/*      */     } 
/*      */     
/*  827 */     h();
/*      */ 
/*      */     
/*  830 */     g();
/*      */ 
/*      */     
/*  833 */     float f = 0.0F;
/*  834 */     Array array3 = new Array(PieChart.ChartEntryConfig.class);
/*  835 */     for (byte b1 = 0; b1 < this.z.size; b1++) {
/*      */       Color color;
/*  837 */       if ((WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b1])).wheelMultiplier == 0) {
/*  838 */         color = this.k[(WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b1])).item.getItem().getRarity().ordinal()];
/*      */       } else {
/*  840 */         color = d;
/*      */       } 
/*      */       PieChart.ChartEntryConfig chartEntryConfig;
/*  843 */       (chartEntryConfig = new PieChart.ChartEntryConfig(color, (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b1])).chance, 0.0F)).userObject = ((WheelOptionConfig[])this.z.items)[b1];
/*  844 */       array3.add(chartEntryConfig);
/*  845 */       WheelOptionConfig.a(((WheelOptionConfig[])this.z.items)[b1], chartEntryConfig);
/*  846 */       f += (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b1])).chance;
/*      */     } 
/*  848 */     this.r.setConfigs(array3);
/*  849 */     this.r.chart.requestVerticesRebuild();
/*      */     
/*  851 */     Array array1 = new Array(PieChart.ChartEntryConfig.class);
/*  852 */     for (byte b3 = 0; b3 < this.z.size; b3++) {
/*      */       Color color;
/*  854 */       if ((WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b3])).wheelMultiplier == 0) {
/*  855 */         color = this.i[(WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b3])).item.getItem().getRarity().ordinal()];
/*      */       } else {
/*  857 */         color = c;
/*      */       } 
/*      */       PieChart.ChartEntryConfig chartEntryConfig;
/*  860 */       (chartEntryConfig = new PieChart.ChartEntryConfig(color, (WheelOptionConfig.c(((WheelOptionConfig[])this.z.items)[b3])).chance, 0.0F)).userObject = ((WheelOptionConfig[])this.z.items)[b3];
/*  861 */       array1.add(chartEntryConfig);
/*  862 */       WheelOptionConfig.b(((WheelOptionConfig[])this.z.items)[b3], chartEntryConfig);
/*      */     } 
/*  864 */     this.s.setConfigs(array1);
/*  865 */     this.s.chart.requestVerticesRebuild();
/*      */ 
/*      */ 
/*      */     
/*  869 */     this.p.clear();
/*  870 */     for (byte b4 = 0; b4 < this.z.size; b4++) {
/*      */       WheelOptionConfig wheelOptionConfig;
/*      */       
/*  873 */       float f1 = WheelOptionConfig.b(wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b4]) - 90.0F;
/*      */       
/*      */       Group group;
/*  876 */       (group = new Group()).addListener((EventListener)new ClickListener(this, wheelOptionConfig)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  879 */               if ((LuckyWheelOverlay.WheelOptionConfig.c(this.a)).item != null) {
/*  880 */                 ItemDescriptionDialog.i().showWithCount((LuckyWheelOverlay.WheelOptionConfig.c(this.a)).item.getItem(), (LuckyWheelOverlay.WheelOptionConfig.c(this.a)).item.getCount());
/*      */               }
/*      */             }
/*      */           });
/*      */       
/*  885 */       group.setTransform(true);
/*  886 */       group.setSize(80.0F, 80.0F);
/*  887 */       group.setOrigin(40.0F, 40.0F);
/*      */       
/*  889 */       this.p.addActor((Actor)group);
/*  890 */       WheelOptionConfig.a(wheelOptionConfig, group);
/*      */       
/*  892 */       if ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) {
/*  893 */         Actor actor = (WheelOptionConfig.c(wheelOptionConfig)).item.getItem().generateIcon(80.0F, true);
/*  894 */         group.addActor(actor);
/*      */         
/*  896 */         WheelOptionConfig.a(wheelOptionConfig, new Label("x" + (WheelOptionConfig.c(wheelOptionConfig)).item.getCount(), Game.i.assetManager.getLabelStyle(24)));
/*  897 */         WheelOptionConfig.d(wheelOptionConfig).setAlignment(1);
/*  898 */         WheelOptionConfig.d(wheelOptionConfig).setSize(80.0F, 32.0F);
/*  899 */         WheelOptionConfig.d(wheelOptionConfig).setPosition(0.0F, -32.0F);
/*  900 */         group.addActor((Actor)WheelOptionConfig.d(wheelOptionConfig));
/*      */       }
/*  902 */       else if ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 2) {
/*      */         Image image;
/*  904 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-wheel-x2"))).setSize(80.0F, 80.0F);
/*  905 */         group.addActor((Actor)image);
/*      */       } else {
/*      */         Image image;
/*  908 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("lucky-wheel-x3"))).setSize(80.0F, 80.0F);
/*  909 */         group.addActor((Actor)image);
/*      */       } 
/*      */ 
/*      */       
/*  913 */       int i = StrictMath.round((WheelOptionConfig.c(wheelOptionConfig)).chance / f * 100.0F);
/*      */       Label label;
/*  915 */       (label = new Label(i + "%", Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/*  916 */       label.setSize(80.0F, 24.0F);
/*  917 */       label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  918 */       label.setPosition(0.0F, -94.0F);
/*  919 */       group.addActor((Actor)label);
/*  920 */       if ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) {
/*  921 */         label.setColor(Game.i.progressManager.getRarityBrightColor((WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity()));
/*      */       } else {
/*  923 */         label.setColor(e);
/*      */       } 
/*  925 */       WheelOptionConfig.b(wheelOptionConfig, label);
/*  926 */       label.addAction((Action)Actions.sequence(
/*  927 */             (Action)Actions.alpha(0.0F), 
/*  928 */             (Action)Actions.alpha(1.0F, 0.2F), 
/*  929 */             (Action)Actions.delay(1.5F), 
/*  930 */             (Action)Actions.alpha(0.0F, 1.0F)));
/*      */ 
/*      */ 
/*      */       
/*  934 */       wheelOptionConfig.setItemContainerAngle(f1);
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
/*  952 */     this.x = -1;
/*      */ 
/*      */     
/*  955 */     f();
/*      */   }
/*      */   
/*      */   public final void setVisible(boolean paramBoolean) {
/*  959 */     if (!paramBoolean && (this.B || this.J || this.K)) {
/*  960 */       a.e("can't hide while spinning / preparing", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  964 */     if (paramBoolean) {
/*  965 */       rebuild();
/*  966 */       UiUtils.bouncyShowOverlayWithCallback((Actor)this.g.getTable(), (Actor)this.h.getTable(), this.m, () -> this.m.setTransform(true));
/*      */       
/*  968 */       if (!this.U)
/*      */       {
/*  970 */         if ((ProgressPrefs.i()).progress.isLuckyWheelSpinInProgress()) {
/*      */           
/*  972 */           a.e("showing lucky wheel while spin in progress", new Object[0]);
/*      */           
/*  974 */           Game.i.progressManager.removeItems((Item)Item.D.LUCKY_SHOT_TOKEN, 1);
/*  975 */           (ProgressPrefs.i()).progress.setLuckyWheelSpinAvailable(true);
/*  976 */           ProgressPrefs.i().requireSave();
/*      */           
/*  978 */           a(0.3F + (float)Math.random() * 0.6F);
/*      */         } 
/*      */       }
/*      */     } else {
/*  982 */       UiUtils.bouncyHideOverlay((Actor)this.g.getTable(), (Actor)this.h.getTable(), this.m);
/*      */     } 
/*      */     
/*  985 */     this.U = paramBoolean;
/*      */   }
/*      */   
/*      */   private int a(float paramFloat1, float paramFloat2) {
/*  989 */     byte b = -1;
/*      */     
/*  991 */     paramFloat2 = ((paramFloat2 = paramFloat1 - paramFloat2 + 90.0F) % 360.0F + 360.0F) % 360.0F;
/*      */     
/*  993 */     for (byte b1 = 0; b1 < this.z.size; b1++) {
/*      */       WheelOptionConfig wheelOptionConfig;
/*  995 */       float f2 = StrictMath.min(WheelOptionConfig.e(wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b1]), WheelOptionConfig.f(wheelOptionConfig));
/*  996 */       float f1 = StrictMath.max(WheelOptionConfig.e(wheelOptionConfig), WheelOptionConfig.f(wheelOptionConfig));
/*      */       
/*  998 */       if (paramFloat2 >= f2 && paramFloat2 <= f1) {
/*      */         
/* 1000 */         b = b1;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1004 */     if (b == -1) {
/* 1005 */       throw new IllegalStateException("Invalid weapon rotation " + paramFloat1 + ", wheelOptions.size " + this.z.size);
/*      */     }
/*      */     
/* 1008 */     return b;
/*      */   }
/*      */   
/*      */   private void j() {
/* 1012 */     if (this.z.size == 0) {
/* 1013 */       a.e("wheelOptions is empty, rebuilding", new Object[0]);
/* 1014 */       rebuild();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1019 */     if (this.J) {
/*      */       
/* 1021 */       this.L += 0.03332F;
/* 1022 */       if (this.L >= 1.0F) {
/*      */         
/* 1024 */         this.J = false;
/* 1025 */         rebuild();
/*      */       } else {
/*      */         
/* 1028 */         float f1 = b.apply(this.L);
/*      */         
/*      */         byte b1;
/* 1031 */         for (b1 = 0; b1 < this.z.size; b1++) {
/*      */           WheelOptionConfig wheelOptionConfig;
/* 1033 */           if ((wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b1]).wasHit) {
/*      */             
/* 1035 */             float f2 = (WheelOptionConfig.c(wheelOptionConfig)).chance * (1.0F - f1);
/* 1036 */             WheelOptionConfig.g(wheelOptionConfig).setValue(f2);
/* 1037 */             WheelOptionConfig.h(wheelOptionConfig).setValue(f2);
/*      */           } 
/*      */         } 
/* 1040 */         this.s.chart.requestVerticesRebuild();
/* 1041 */         this.r.chart.requestVerticesRebuild();
/*      */ 
/*      */         
/* 1044 */         for (b1 = 0; b1 < this.z.size; b1++) {
/*      */           WheelOptionConfig wheelOptionConfig;
/*      */           
/* 1047 */           if (!(wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[b1]).wasHit) {
/* 1048 */             float f2 = PMath.getDistanceBetweenAngles(wheelOptionConfig.respinPrepareFromAngle, WheelOptionConfig.b(wheelOptionConfig));
/*      */             float f3;
/* 1050 */             Vector3 vector3 = WheelOptionConfig.getPosRotForAngle(f3 = wheelOptionConfig.respinPrepareFromAngle + f2 * f1 - 90.0F);
/* 1051 */             WheelOptionConfig.a(wheelOptionConfig).setPosition(vector3.x, vector3.y);
/* 1052 */             WheelOptionConfig.a(wheelOptionConfig).setRotation(vector3.z);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1059 */     if (this.B) {
/* 1060 */       Vector2 vector2; this.I += 0.01666F;
/*      */       
/*      */       int i;
/*      */       
/* 1064 */       if ((i = a(this.M, this.A)) != this.x) {
/*      */         
/* 1066 */         Game.i.soundManager.playStatic(StaticSoundType.TICK);
/*      */         
/* 1068 */         if (this.x != -1) {
/* 1069 */           WheelOptionConfig wheelOptionConfig1 = ((WheelOptionConfig[])this.z.items)[this.x];
/* 1070 */           (((PieChart.ChartEntryConfig[])(this.s.getConfigs()).items)[this.x]).color = ((WheelOptionConfig.c(wheelOptionConfig1)).wheelMultiplier == 0) ? this.i[(WheelOptionConfig.c(wheelOptionConfig1)).item.getItem().getRarity().ordinal()] : c;
/* 1071 */           (((PieChart.ChartEntryConfig[])(this.r.getConfigs()).items)[this.x]).color = ((WheelOptionConfig.c(wheelOptionConfig1)).wheelMultiplier == 0) ? this.k[(WheelOptionConfig.c(wheelOptionConfig1)).item.getItem().getRarity().ordinal()] : d;
/*      */         } 
/* 1073 */         this.x = i;
/*      */         
/* 1075 */         WheelOptionConfig wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[this.x];
/* 1076 */         (((PieChart.ChartEntryConfig[])(this.s.getConfigs()).items)[i]).color = ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) ? this.j[(WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity().ordinal()] : e;
/* 1077 */         (((PieChart.ChartEntryConfig[])(this.r.getConfigs()).items)[i]).color = ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) ? this.l[(WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity().ordinal()] : f;
/*      */         
/* 1079 */         this.s.chart.requestVerticesRebuild();
/* 1080 */         this.r.chart.requestVerticesRebuild();
/*      */       } 
/*      */       
/* 1083 */       float f1 = this.I / this.H;
/*      */       
/* 1085 */       if (this.H - 1.3F < this.I && 
/* 1086 */         !this.C) {
/* 1087 */         Game.i.soundManager.playStaticParameterized(StaticSoundType.SHOT_GAUSS_CHARGE, 0.7F, 0.75F, 0.0F, false);
/* 1088 */         this.C = true;
/*      */       } 
/*      */       
/* 1091 */       if (f1 >= 1.0F) {
/*      */         Color color2, color3;
/* 1093 */         this.Q = 1.0F;
/* 1094 */         this.B = false;
/* 1095 */         this.C = false;
/*      */         
/*      */         BulletSmokeMultiLine bulletSmokeMultiLine;
/*      */         
/* 1099 */         (bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.getFactory(ShapeType.BULLET_SMOKE_MULTI_LINE).obtain()).setTexture((TextureRegion)Game.i.assetManager.getTextureRegion("bullet-trace-smoke"), false, (FastRandom.getFloat() < 0.5F));
/*      */         
/* 1101 */         bulletSmokeMultiLine.maxSegmentWidth = 25.6F;
/* 1102 */         bulletSmokeMultiLine.nodesDisperseTime = 3.0F;
/* 1103 */         bulletSmokeMultiLine.maxAlpha = 0.56F;
/* 1104 */         Vector2 vector21 = new Vector2();
/* 1105 */         PMath.getPointByAngleFromPoint(240.0F, 240.0F, this.M, 24.0F, vector21);
/* 1106 */         float f3 = vector21.x, f4 = vector21.y;
/* 1107 */         PMath.getPointByAngleFromPoint(240.0F, 240.0F, this.M, 960.0F, vector21);
/* 1108 */         bulletSmokeMultiLine.setup(f3, f4, vector21.x, vector21.y);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         Actor actor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1129 */         (actor = new Actor(this, bulletSmokeMultiLine, 0.01666F) { public void draw(Batch param1Batch, float param1Float) { this.j.update(this.k); if (this.j.isFinished()) { this.j.free(); remove(); return; }  param1Batch.end(); param1Batch.setBlendFunction(770, 1); param1Batch.begin(); this.j.draw(param1Batch); param1Batch.end(); param1Batch.setBlendFunction(770, 771); param1Batch.begin(); } }).setSize(1.0F, 1.0F);
/* 1130 */         this.m.addActor(actor);
/*      */ 
/*      */ 
/*      */         
/*      */         WheelOptionConfig wheelOptionConfig;
/*      */ 
/*      */         
/* 1137 */         if ((WheelOptionConfig.c(wheelOptionConfig = ((WheelOptionConfig[])this.z.items)[this.x])).wheelMultiplier == 0) {
/* 1138 */           color2 = this.j[(WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity().ordinal()].cpy().add(0.14F, 0.14F, 0.14F, 1.0F);
/* 1139 */           color3 = this.l[(WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity().ordinal()].cpy().add(0.0F, 0.0F, 0.0F, 1.0F);
/*      */         } else {
/* 1141 */           color2 = e.cpy().add(0.14F, 0.14F, 0.14F, 1.0F);
/* 1142 */           color3 = f.cpy().add(0.0F, 0.0F, 0.0F, 1.0F);
/*      */         } 
/* 1144 */         (((PieChart.ChartEntryConfig[])(this.s.getConfigs()).items)[this.x]).color = color2;
/* 1145 */         (((PieChart.ChartEntryConfig[])(this.r.getConfigs()).items)[this.x]).color = color3;
/* 1146 */         this.s.chart.requestVerticesRebuild();
/* 1147 */         this.r.chart.requestVerticesRebuild();
/*      */         
/* 1149 */         Game.i.soundManager.playStaticParameterized(StaticSoundType.SHOT_GAUSS, 0.5F, 1.0F, 0.0F, false);
/*      */         
/* 1151 */         if ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) {
/* 1152 */           Game.i.soundManager.playRarity((WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity());
/*      */         } else {
/* 1154 */           Game.i.soundManager.playStatic(StaticSoundType.SUCCESS);
/*      */         } 
/*      */ 
/*      */         
/* 1158 */         for (byte b1 = 0; b1 < this.z.size; b1++) {
/*      */           WheelOptionConfig wheelOptionConfig1;
/* 1160 */           WheelOptionConfig.a(wheelOptionConfig1 = ((WheelOptionConfig[])this.z.items)[b1]).clearActions();
/*      */           
/* 1162 */           WheelOptionConfig.i(wheelOptionConfig1).clearActions();
/* 1163 */           WheelOptionConfig.i(wheelOptionConfig1).addAction((Action)Actions.alpha(0.0F, 0.2F));
/*      */           
/* 1165 */           if (wheelOptionConfig == wheelOptionConfig1) {
/* 1166 */             WheelOptionConfig.a(wheelOptionConfig1).addAction(
/* 1167 */                 (Action)Actions.parallel(
/* 1168 */                   (Action)Actions.scaleTo(1.1F, 1.1F, 0.2F)));
/*      */           }
/*      */           else {
/*      */             
/* 1172 */             WheelOptionConfig.a(wheelOptionConfig1).addAction(
/* 1173 */                 (Action)Actions.parallel(
/* 1174 */                   (Action)Actions.scaleTo(0.9F, 0.9F, 0.2F), 
/* 1175 */                   (Action)Actions.alpha(0.56F, 0.2F)));
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1182 */         Color color1 = ((WheelOptionConfig.c(wheelOptionConfig)).wheelMultiplier == 0) ? Game.i.progressManager.getRarityBrightColor((WheelOptionConfig.c(wheelOptionConfig)).item.getItem().getRarity()) : e;
/*      */         ParticleEffectPool.PooledEffect pooledEffect;
/* 1184 */         ((ParticleEmitter)(pooledEffect = (ParticleEffectPool.PooledEffect)this.R.obtain()).getEmitters().first()).getTint().setColors(new float[] { color1.r, color1.g, color1.b });
/* 1185 */         ((ParticleEmitter)pooledEffect.getEmitters().first()).getAngle().setHighMin(WheelOptionConfig.e(wheelOptionConfig) + this.n.getRotation());
/* 1186 */         ((ParticleEmitter)pooledEffect.getEmitters().first()).getAngle().setHighMax(WheelOptionConfig.f(wheelOptionConfig) + this.n.getRotation());
/* 1187 */         float f2 = StrictMath.abs(PMath.getDistanceBetweenAngles(WheelOptionConfig.f(wheelOptionConfig), WheelOptionConfig.e(wheelOptionConfig)));
/* 1188 */         ((ParticleEmitter)pooledEffect.getEmitters().first()).getEmission().setHigh(f2 / 30.0F * 300.0F);
/* 1189 */         this.o.addParticle((ParticleEffect)pooledEffect, 240.0F, 240.0F);
/*      */         
/* 1191 */         this.N.clearActions();
/* 1192 */         this.N.setTransform(true);
/* 1193 */         vector2 = new Vector2();
/* 1194 */         PMath.getPointByAngleFromPoint(0.0F, 0.0F, this.N.getRotation() + 180.0F, 15.0F, vector2);
/* 1195 */         this.N.addAction((Action)Actions.sequence(
/* 1196 */               (Action)Actions.moveTo(226.0F + vector2.x, 219.0F + vector2.y), 
/* 1197 */               (Action)Actions.moveTo(226.0F, 219.0F, 0.3F, (Interpolation)Interpolation.exp5In)));
/*      */         
/* 1199 */         wheelOptionConfig.wasHit = true;
/*      */         
/* 1201 */         a(wheelOptionConfig);
/*      */       } else {
/*      */         
/* 1204 */         this.A = this.E + Interpolation.exp10Out.apply(vector2) * (this.D - this.E);
/* 1205 */         this.Q = vector2 * 1.25F;
/*      */         
/* 1207 */         this.M = this.G + Interpolation.smoother.apply(vector2) * (this.F - this.G);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1213 */       this.Q *= 0.98334F;
/*      */     } 
/* 1215 */     if (this.Q > 1.0F) this.Q = 1.0F;
/*      */     
/* 1217 */     this.A = (this.A % 360.0F + 360.0F) % 360.0F;
/*      */ 
/*      */     
/* 1220 */     this.n.setRotation(b());
/*      */ 
/*      */     
/* 1223 */     this.N.setRotation(c());
/* 1224 */     float f = (this.Q - 0.25F) / 0.75F;
/* 1225 */     for (byte b = 0; b < this.O.length; b++) {
/* 1226 */       float f1 = 0.0F;
/* 1227 */       float f2 = 1.0F / this.O.length * b;
/* 1228 */       if (f > f2)
/*      */       {
/*      */         
/* 1231 */         if ((f1 = (f - f2) * this.O.length) < 0.0F) {
/* 1232 */           f1 = 0.0F;
/* 1233 */         } else if (f1 > 1.0F) {
/* 1234 */           f1 = 1.0F;
/*      */         } 
/*      */       }
/*      */       
/* 1238 */       S.set(0.0F, 1.0F).rotateDeg(c()).scl(27.0F + b * 12.0F);
/* 1239 */       ((this.O[b]).trail.getColor()).a = f1;
/* 1240 */       this.O[b].setPosition(240.0F + S.x, 240.0F + S.y);
/*      */       
/* 1242 */       this.P[b].setColor(1.0F, 1.0F, 1.0F, f1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void hide() {
/* 1248 */     setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postRender(float paramFloat) {
/* 1253 */     if (this.U) {
/*      */       int i;
/* 1255 */       if ((i = Game.i.progressManager.getSecondsTillLuckyWheelSpinAvailable()) <= 0) {
/* 1256 */         this.v.setVisible(false);
/*      */       } else {
/*      */         
/* 1259 */         this.w.setText(StringFormatter.timePassed(i, false, false));
/* 1260 */         this.v.setVisible(true);
/*      */       } 
/*      */       
/* 1263 */       if (this.y && i <= 0) {
/* 1264 */         this.t.setTouchable(Touchable.enabled);
/* 1265 */         this.u.setColor(MaterialColor.LIGHT_BLUE.P500);
/*      */       } else {
/* 1267 */         this.t.setTouchable(Touchable.disabled);
/* 1268 */         this.u.setColor(MaterialColor.GREY.P600);
/*      */       } 
/*      */       
/* 1271 */       this.T += paramFloat;
/* 1272 */       while (this.T > 0.01666F) {
/* 1273 */         j();
/* 1274 */         this.T -= 0.01666F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static class WheelOptionConfig
/*      */   {
/*      */     private LuckyWheelOverlay.WheelOption a;
/*      */     private float b;
/*      */     private float c;
/*      */     private float d;
/*      */     private Group e;
/*      */     private Label f;
/*      */     private Label g;
/*      */     private PieChart.ChartEntryConfig h;
/*      */     private PieChart.ChartEntryConfig i;
/*      */     public boolean wasHit;
/*      */     public float respinPrepareFromAngle;
/* 1293 */     public static Vector3 helperVector3 = new Vector3();
/*      */     
/*      */     public static Vector3 getPosRotForAngle(float param1Float) {
/* 1296 */       LuckyWheelOverlay.a().set(0.0F, 1.0F).rotateDeg(param1Float).scl(230.0F);
/* 1297 */       float f1 = 240.0F + (LuckyWheelOverlay.a()).x;
/* 1298 */       float f2 = 240.0F + (LuckyWheelOverlay.a()).y;
/*      */       
/* 1300 */       helperVector3.x = f1 - 40.0F;
/* 1301 */       helperVector3.y = f2 - 40.0F;
/* 1302 */       helperVector3.z = param1Float;
/*      */       
/* 1304 */       return helperVector3;
/*      */     }
/*      */     
/*      */     public void setItemContainerAngle(float param1Float) {
/* 1308 */       Vector3 vector3 = getPosRotForAngle(param1Float);
/* 1309 */       this.e.setPosition(vector3.x, vector3.y);
/* 1310 */       this.e.setRotation(vector3.z);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class WheelOption {
/*      */     public ItemStack item;
/*      */     public float chance;
/*      */     public int wheelMultiplier;
/*      */     
/*      */     public WheelOption(ItemStack param1ItemStack, float param1Float) {
/* 1320 */       this.item = param1ItemStack;
/* 1321 */       this.chance = param1Float;
/*      */     }
/*      */     
/*      */     public WheelOption(ItemStack param1ItemStack, float param1Float, int param1Int) {
/* 1325 */       this.item = param1ItemStack;
/* 1326 */       this.chance = param1Float;
/* 1327 */       this.wheelMultiplier = param1Int;
/*      */     }
/*      */     
/*      */     public void toJson(Json param1Json) {
/* 1331 */       if (this.item != null) {
/* 1332 */         param1Json.writeObjectStart("item");
/* 1333 */         this.item.toJson(param1Json);
/* 1334 */         param1Json.writeObjectEnd();
/*      */       } 
/* 1336 */       param1Json.writeValue("chance", Float.valueOf(this.chance));
/* 1337 */       if (this.wheelMultiplier != 0) param1Json.writeValue("wheelMultiplier", Integer.valueOf(this.wheelMultiplier)); 
/*      */     }
/*      */     
/*      */     public static WheelOption fromJson(JsonValue param1JsonValue) {
/* 1341 */       ItemStack itemStack = null;
/* 1342 */       if (param1JsonValue.get("item") != null) {
/* 1343 */         itemStack = ItemStack.fromJson(param1JsonValue.get("item"));
/*      */       }
/* 1345 */       float f = param1JsonValue.getFloat("chance");
/* 1346 */       int i = param1JsonValue.getInt("wheelMultiplier", 0);
/*      */       
/* 1348 */       return new WheelOption(itemStack, f, i);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1353 */       return "(chance: " + StringFormatter.compactNumberWithPrecisionTrimZeros(this.chance, 2, false) + ", wheelMultiplier: " + this.wheelMultiplier + ", item: " + this.item + ")";
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LuckyWheelOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */