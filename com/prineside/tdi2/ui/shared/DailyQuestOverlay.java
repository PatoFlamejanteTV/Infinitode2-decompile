/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.DailyQuestManager;
/*     */ import com.prineside.tdi2.managers.LeaderBoardManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public final class DailyQuestOverlay extends UiManager.UiComponent.Adapter {
/*  42 */   private static final TLog a = TLog.forClass(DailyQuestOverlay.class);
/*     */   public static DailyQuestOverlay i() {
/*  44 */     return (DailyQuestOverlay)Game.i.uiManager.getComponent(DailyQuestOverlay.class);
/*     */   }
/*     */   
/*  47 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SHARED_COMPONENTS, 110, "DailyQuestOverlay tint", true); private Group d; private Label e; private Table f; private Label g; private Label h; private Group i; private Group j; private Group k; private Group l; private Label m; private Label n; private Label o; private ScrollPane p; private Image q; private Label r;
/*  48 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 111, "DailyQuestOverlay main"); private Label s; private Table t; private Table u; private Group[] v; private Label w; private Label x; private Label y; private Label z; private Label A; private LabelButton B; private Label C; private ComplexButton D; private float E;
/*     */   private DailyQuestManager.DailyQuestLevel F;
/*     */   
/*  51 */   private enum RankPrizesRow { FIRST,
/*  52 */     SECOND,
/*  53 */     THIRD,
/*  54 */     TOP_3,
/*  55 */     TOP_10,
/*  56 */     TOP_30; }
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
/*  93 */   private static final StringBuilder G = new StringBuilder();
/*     */   
/*     */   public DailyQuestOverlay() {
/*     */     Image image2;
/*  97 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  98 */     (image2.getColor()).a = 0.78F;
/*  99 */     this.b.getTable().add((Actor)image2).expand().fill();
/* 100 */     this.b.getTable().setTouchable(Touchable.enabled);
/* 101 */     this.b.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 104 */             this.a.hide();
/* 105 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           }
/*     */         });
/*     */     
/*     */     Group group2;
/* 110 */     (group2 = new Group()).setTransform(false);
/* 111 */     group2.setOrigin(650.0F, 488.5F);
/* 112 */     this.c.getTable().add((Actor)group2).size(1300.0F, 977.0F);
/*     */     
/* 114 */     this.d = new Group(this)
/*     */       {
/*     */         public void act(float param1Float) {
/* 117 */           super.act(param1Float);
/*     */           
/* 119 */           if (this.c) {
/* 120 */             DailyQuestOverlay.a(this.k, param1Float);
/* 121 */             if (DailyQuestOverlay.a(this.k) >= 1.0F) {
/* 122 */               DailyQuestOverlay.b(this.k, 0.0F);
/* 123 */               DailyQuestOverlay.b(this.k);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/* 128 */     this.d.setTransform(true);
/* 129 */     this.d.setOrigin(650.0F, 488.5F);
/* 130 */     this.d.setSize(1300.0F, 977.0F);
/* 131 */     group2.addActor((Actor)this.d);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor2;
/*     */ 
/*     */ 
/*     */     
/* 140 */     (quadActor2 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 16.0F, 26.0F, 16.0F, 952.0F, 546.0F, 961.0F, 546.0F, 0.0F })).setSize(546.0F, 961.0F);
/* 141 */     this.d.addActor((Actor)quadActor2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     (quadActor2 = new QuadActor(new Color(791621631), new float[] { 0.0F, 32.0F, 0.0F, 970.0F, 530.0F, 977.0F, 530.0F, 19.0F })).setSize(530.0F, 977.0F);
/* 150 */     this.d.addActor((Actor)quadActor2);
/*     */     
/* 152 */     this.w = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 153 */     this.w.setPosition(40.0F, 914.0F);
/* 154 */     this.w.setSize(100.0F, 23.0F);
/* 155 */     this.d.addActor((Actor)this.w);
/*     */     
/* 157 */     this.e = new Label("2019-04-26 (" + Game.i.localeManager.i18n.get("in_progress").toLowerCase(Locale.ENGLISH) + ")", Game.i.assetManager.getLabelStyle(21));
/* 158 */     this.e.setPosition(40.0F, 882.0F);
/* 159 */     this.e.setSize(100.0F, 16.0F);
/* 160 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 161 */     this.d.addActor((Actor)this.e);
/*     */     
/*     */     Image image1;
/* 164 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(0.0F, 198.0F);
/* 165 */     image1.setSize(530.0F, 662.0F);
/* 166 */     image1.setColor(new Color(724249599));
/* 167 */     this.d.addActor((Actor)image1);
/*     */     
/* 169 */     this.f = new Table();
/* 170 */     this.p = new ScrollPane((Actor)this.f);
/* 171 */     UiUtils.enableMouseMoveScrollFocus(this.p);
/* 172 */     this.p.setPosition(0.0F, 198.0F);
/* 173 */     this.p.setSize(530.0F, 662.0F);
/* 174 */     this.d.addActor((Actor)this.p);
/*     */ 
/*     */     
/* 177 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 178 */     image1.setPosition(0.0F, 850.0F);
/* 179 */     image1.setSize(530.0F, 10.0F);
/* 180 */     image1.setTouchable(Touchable.disabled);
/* 181 */     this.d.addActor((Actor)image1);
/*     */ 
/*     */     
/* 184 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 185 */     image1.setPosition(0.0F, 198.0F);
/* 186 */     image1.setSize(530.0F, 10.0F);
/* 187 */     image1.setTouchable(Touchable.disabled);
/* 188 */     this.d.addActor((Actor)image1);
/*     */     
/* 190 */     this.h = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 191 */     this.h.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 192 */     this.h.setPosition(40.0F, 157.0F);
/* 193 */     this.h.setSize(100.0F, 16.0F);
/* 194 */     this.d.addActor((Actor)this.h);
/*     */ 
/*     */     
/* 197 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(530.0F, 64.0F);
/* 198 */     image1.setPosition(0.0F, 69.0F);
/* 199 */     image1.setColor(new Color(673720575));
/* 200 */     this.d.addActor((Actor)image1);
/*     */     
/* 202 */     this.j = new Group();
/* 203 */     this.j.setTransform(false);
/* 204 */     this.j.setSize(530.0F, 64.0F);
/* 205 */     this.j.setPosition(0.0F, 69.0F);
/* 206 */     this.j.setVisible(false);
/* 207 */     this.d.addActor((Actor)this.j);
/*     */     
/* 209 */     this.x = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 210 */     this.x.setPosition(40.0F, 0.0F);
/* 211 */     this.x.setSize(100.0F, 64.0F);
/* 212 */     this.j.addActor((Actor)this.x);
/*     */     
/* 214 */     this.i = new Group();
/* 215 */     this.i.setTransform(false);
/* 216 */     this.i.setSize(530.0F, 64.0F);
/* 217 */     this.i.setPosition(0.0F, 69.0F);
/* 218 */     this.i.setVisible(false);
/* 219 */     this.d.addActor((Actor)this.i);
/*     */     
/* 221 */     this.m = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 222 */     this.m.setPosition(40.0F, 0.0F);
/* 223 */     this.m.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 224 */     this.m.setSize(50.0F, 64.0F);
/* 225 */     this.m.setAlignment(1);
/* 226 */     this.i.addActor((Actor)this.m);
/*     */     
/* 228 */     this.n = (Label)new LimitedWidthLabel("", 30, 24, 280.0F);
/* 229 */     this.n.setPosition(122.0F, 0.0F);
/* 230 */     this.n.setSize(100.0F, 64.0F);
/* 231 */     this.i.addActor((Actor)this.n);
/*     */     
/* 233 */     this.o = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 234 */     this.o.setAlignment(16);
/* 235 */     this.o.setPosition(390.0F, 0.0F);
/* 236 */     this.o.setSize(100.0F, 64.0F);
/* 237 */     this.i.addActor((Actor)this.o);
/*     */     
/*     */     Table table1;
/* 240 */     (table1 = new Table()).setPosition(312.0F, 149.0F);
/* 241 */     table1.setSize(177.0F, 32.0F);
/* 242 */     this.d.addActor((Actor)table1);
/*     */     
/* 244 */     table1.add().height(32.0F).expandX().fillX();
/*     */     
/*     */     Image image4;
/* 247 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-skill-point"))).setColor(MaterialColor.CYAN.P500);
/* 248 */     table1.add((Actor)image4).size(32.0F, 32.0F).padRight(8.0F);
/*     */     
/* 250 */     this.s = new Label("-", Game.i.assetManager.getLabelStyle(24));
/* 251 */     this.s.setColor(MaterialColor.CYAN.P500);
/* 252 */     table1.add((Actor)this.s).height(32.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor1;
/*     */ 
/*     */ 
/*     */     
/* 261 */     (quadActor1 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 25.0F, 0.0F, 25.0F, 970.0F, 717.0F, 956.0F, 725.0F, 27.0F })).setPosition(570.0F, 0.0F);
/* 262 */     quadActor1.setSize(725.0F, 970.0F);
/* 263 */     this.d.addActor((Actor)quadActor1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     (quadActor1 = new QuadActor(new Color(791621631), new float[] { 0.0F, 19.0F, 0.0F, 977.0F, 710.0F, 967.0F, 710.0F, 42.0F })).setSize(710.0F, 977.0F);
/* 272 */     quadActor1.setPosition(570.0F, 0.0F);
/* 273 */     this.d.addActor((Actor)quadActor1);
/*     */     
/*     */     Group group1;
/* 276 */     (group1 = new Group()).setTransform(false);
/* 277 */     group1.setPosition(570.0F, 0.0F);
/* 278 */     group1.setSize(710.0F, 977.0F);
/* 279 */     this.d.addActor((Actor)group1);
/*     */ 
/*     */     
/* 282 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-exclamation-triangle"))).setSize(64.0F, 64.0F);
/* 283 */     image4.setPosition(40.0F, 882.0F);
/* 284 */     group1.addActor((Actor)image4);
/*     */     
/*     */     Table table2;
/* 287 */     (table2 = new Table()).setPosition(128.0F, 882.0F);
/* 288 */     table2.setSize(500.0F, 64.0F);
/* 289 */     group1.addActor((Actor)table2);
/*     */     
/* 291 */     this.y = new Label("", Game.i.assetManager.getLabelStyle(36));
/* 292 */     table2.add((Actor)this.y).left().padRight(16.0F);
/*     */     
/* 294 */     this.g = new Label("00:00:00", Game.i.assetManager.getLabelStyle(21));
/* 295 */     this.g.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 296 */     table2.add((Actor)this.g).expand().padTop(8.0F).left();
/*     */     
/*     */     Image image3;
/* 299 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(0.0F, 796.0F);
/* 300 */     image3.setSize(710.0F, 64.0F);
/* 301 */     image3.setColor(new Color(623191551));
/* 302 */     group1.addActor((Actor)image3);
/*     */     
/* 304 */     this.q = new Image();
/* 305 */     this.q.setPosition(40.0F, 808.0F);
/* 306 */     this.q.setSize(40.0F, 40.0F);
/* 307 */     group1.addActor((Actor)this.q);
/*     */     
/* 309 */     this.r = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 310 */     this.r.setPosition(96.0F, 796.0F);
/* 311 */     this.r.setSize(100.0F, 64.0F);
/* 312 */     group1.addActor((Actor)this.r);
/*     */     
/* 314 */     this.z = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 315 */     this.z.setPosition(40.0F, 732.0F);
/* 316 */     this.z.setSize(100.0F, 64.0F);
/* 317 */     group1.addActor((Actor)this.z);
/*     */     
/* 319 */     this.t = new Table();
/* 320 */     this.t.setSize(710.0F, 140.0F);
/* 321 */     this.t.setPosition(0.0F, 587.0F);
/* 322 */     group1.addActor((Actor)this.t);
/*     */     
/* 324 */     this.l = new Group();
/* 325 */     this.l.setTransform(false);
/* 326 */     this.l.setSize(710.0F, 796.0F);
/* 327 */     this.l.setVisible(false);
/* 328 */     this.l.setTouchable(Touchable.childrenOnly);
/* 329 */     group1.addActor((Actor)this.l);
/*     */     
/* 331 */     this.k = new Group();
/* 332 */     this.k.setTransform(false);
/* 333 */     this.k.setSize(710.0F, 796.0F);
/* 334 */     this.k.setVisible(false);
/* 335 */     this.k.setTouchable(Touchable.childrenOnly);
/* 336 */     group1.addActor((Actor)this.k);
/*     */     
/* 338 */     this.A = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 339 */     this.A.setPosition(40.0F, 506.0F);
/* 340 */     this.A.setSize(100.0F, 64.0F);
/* 341 */     this.k.addActor((Actor)this.A);
/*     */     
/* 343 */     this.B = new LabelButton("", Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI("https://infinitode-2.fandom.com/wiki/Daily_quests"));
/* 344 */     this.B.setPosition(510.0F, 506.0F);
/* 345 */     this.B.setSize(160.0F, 64.0F);
/* 346 */     this.B.setAlignment(16);
/* 347 */     this.k.addActor((Actor)this.B);
/*     */     
/* 349 */     this.v = new Group[(RankPrizesRow.values()).length];
/* 350 */     float f = 458.0F; RankPrizesRow[] arrayOfRankPrizesRow; int i; byte b;
/* 351 */     for (i = (arrayOfRankPrizesRow = RankPrizesRow.values()).length, b = 0; b < i; ) { RankPrizesRow rankPrizesRow = arrayOfRankPrizesRow[b];
/*     */       Image image;
/* 353 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 354 */       image.setPosition(0.0F, f);
/* 355 */       image.setSize(710.0F, 48.0F);
/* 356 */       this.k.addActor((Actor)image);
/*     */       
/* 358 */       Group group = new Group();
/* 359 */       this.v[rankPrizesRow.ordinal()] = group;
/* 360 */       group.setTransform(false);
/* 361 */       group.setPosition(0.0F, f);
/* 362 */       group.setSize(48.0F, 710.0F);
/* 363 */       this.k.addActor((Actor)group);
/* 364 */       f -= 52.0F;
/*     */       
/*     */       b++; }
/*     */     
/* 368 */     this.C = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 369 */     this.C.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 370 */     this.C.setPosition(40.0F, 157.0F);
/* 371 */     this.C.setSize(100.0F, 16.0F);
/* 372 */     group1.addActor((Actor)this.C);
/*     */     
/* 374 */     this.u = new Table();
/* 375 */     this.u.setPosition(40.0F, 68.0F);
/* 376 */     this.u.setSize(320.0F, 72.0F);
/* 377 */     group1.addActor((Actor)this.u);
/*     */     
/*     */     PaddedImageButton paddedImageButton;
/* 380 */     (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> hide(), MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P400, MaterialColor.LIGHT_BLUE.P600)).setPosition(1228.0F, 914.0F);
/* 381 */     paddedImageButton.setSize(96.0F, 96.0F);
/* 382 */     paddedImageButton.setIconPosition(16.0F, 16.0F);
/* 383 */     paddedImageButton.setIconSize(64.0F, 64.0F);
/* 384 */     this.d.addActor((Actor)paddedImageButton);
/*     */     
/* 386 */     this.D = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           if (GameStateSystem.savedGameExists()) {
/*     */             Dialog.i().showConfirm(Game.i.localeManager.i18n.get("saved_game_will_be_lost_confirm"), ());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           hide();
/*     */           
/*     */           Game.i.dailyQuestManager.startDailyLevel();
/*     */         });
/*     */     
/* 398 */     this.D.setPosition(1063.0F, 65.0F);
/* 399 */     this.D.setSize(235.0F, 92.0F);
/* 400 */     this.D.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-daily-quest-play-button"), 0.0F, 0.0F, 235.0F, 92.0F);
/* 401 */     this.D.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-joystick"), 29.0F, 26.0F, 48.0F, 48.0F);
/* 402 */     this.D.setLabel(90.0F, 11.0F, 100.0F, 82.0F, 8);
/* 403 */     this.d.addActor((Actor)this.D);
/*     */     
/* 405 */     this.b.getTable().setVisible(false);
/* 406 */     this.c.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private static void a(CharSequence paramCharSequence, Group paramGroup, Array<ItemStack> paramArray) {
/* 410 */     paramGroup.clear();
/*     */     
/*     */     Label label;
/* 413 */     (label = new Label(paramCharSequence, Game.i.assetManager.getLabelStyle(24))).setPosition(40.0F, 0.0F);
/* 414 */     label.setSize(100.0F, 48.0F);
/* 415 */     paramGroup.addActor((Actor)label);
/*     */     
/*     */     Table table;
/* 418 */     (table = new Table()).setPosition(140.0F, 0.0F);
/* 419 */     table.setSize(570.0F, 48.0F);
/* 420 */     paramGroup.addActor((Actor)table);
/*     */     
/* 422 */     for (byte b = 0; b < paramArray.size; b++) {
/* 423 */       Actor actor = ((ItemStack)paramArray.get(b)).getItem().generateIcon(32.0F, false);
/* 424 */       table.add(actor).size(32.0F, 32.0F).padRight(6.0F);
/*     */       
/* 426 */       Label label1 = new Label("x" + StringFormatter.commaSeparatedNumber(((ItemStack)paramArray.get(b)).getCount()), Game.i.assetManager.getLabelStyle(21));
/* 427 */       table.add((Actor)label1).padRight(20.0F);
/*     */     } 
/*     */     
/* 430 */     table.add().height(48.0F).expandX().fillX();
/*     */   }
/*     */   
/*     */   public final void show(DailyQuestManager.DailyQuestLevel paramDailyQuestLevel) {
/* 434 */     Game.i.assertInMainThread();
/* 435 */     setVisible(true);
/*     */     
/* 437 */     this.w.setText(Game.i.localeManager.i18n.get("leaderboard"));
/* 438 */     this.x.setText(Game.i.localeManager.i18n.get("sign_in_to_get_ranked"));
/* 439 */     this.y.setText(Game.i.localeManager.i18n.get("daily_quest"));
/* 440 */     this.z.setText(Game.i.localeManager.i18n.get("complete_daily_quest_for_rewards"));
/* 441 */     this.A.setText(Game.i.localeManager.i18n.get("get_ranked_daily_to_win_more"));
/* 442 */     this.B.setText(Game.i.localeManager.i18n.get("rules"));
/* 443 */     this.C.setText(Game.i.localeManager.i18n.get("all_time_top_players"));
/* 444 */     this.D.setText(Game.i.localeManager.i18n.get("play"));
/*     */     
/* 446 */     this.F = paramDailyQuestLevel;
/*     */     
/* 448 */     a.i("fallback: " + String.valueOf(paramDailyQuestLevel.isLocalFallback), new Object[0]);
/* 449 */     a.i("name: " + String.valueOf(paramDailyQuestLevel.getLevelName()), new Object[0]);
/* 450 */     a.i("date: " + String.valueOf(paramDailyQuestLevel.forDate), new Object[0]);
/*     */     
/* 452 */     this.q.setDrawable((Drawable)Game.i.assetManager.getDrawable(paramDailyQuestLevel.wasCompleted() ? "checkbox-checked" : "checkbox"));
/* 453 */     this.r.setText(paramDailyQuestLevel.getQuestName());
/*     */     
/* 455 */     a();
/*     */ 
/*     */     
/* 458 */     this.t.clearChildren();
/* 459 */     Array array = paramDailyQuestLevel.getQuestRewards();
/* 460 */     for (byte b = 0; b < array.size; b++) {
/* 461 */       ItemStack itemStack = (ItemStack)array.get(b);
/*     */       ItemCell itemCell;
/* 463 */       (itemCell = new ItemCell()).setTouchable(Touchable.enabled);
/* 464 */       itemCell.setItemStack(itemStack);
/* 465 */       itemCell.setColRow(b, 0);
/* 466 */       itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 469 */               ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/*     */             }
/*     */           });
/* 472 */       this.t.add((Actor)itemCell).size(128.0F, 140.0F);
/*     */     } 
/*     */     
/* 475 */     if (paramDailyQuestLevel.isLocalFallback) {
/*     */       
/* 477 */       this.l.setVisible(true);
/* 478 */       this.k.setVisible(false);
/*     */     } else {
/*     */       
/* 481 */       this.l.setVisible(false);
/* 482 */       this.k.setVisible(true);
/*     */       
/* 484 */       a(Game.i.localeManager.i18n.get("first_short"), this.v[RankPrizesRow.FIRST.ordinal()], paramDailyQuestLevel.prizesFirstPlace);
/* 485 */       a(Game.i.localeManager.i18n.get("second_short"), this.v[RankPrizesRow.SECOND.ordinal()], paramDailyQuestLevel.prizesSecondPlace);
/* 486 */       a(Game.i.localeManager.i18n.get("third_short"), this.v[RankPrizesRow.THIRD.ordinal()], paramDailyQuestLevel.prizesThirdPlace);
/* 487 */       a(Game.i.localeManager.i18n.format("top_percent", new Object[] { "3" }), this.v[RankPrizesRow.TOP_3.ordinal()], paramDailyQuestLevel.prizesTop3Percent);
/* 488 */       a(Game.i.localeManager.i18n.format("top_percent", new Object[] { "10" }), this.v[RankPrizesRow.TOP_10.ordinal()], paramDailyQuestLevel.prizesTop10Percent);
/* 489 */       a(Game.i.localeManager.i18n.format("top_percent", new Object[] { "30" }), this.v[RankPrizesRow.TOP_30.ordinal()], paramDailyQuestLevel.prizesTop30Percent);
/*     */     } 
/*     */ 
/*     */     
/* 493 */     Game.i.leaderBoardManager.getSkillPointLeaderboards(paramSkillPointsLeaderboardsResult -> {
/*     */           this.u.clearChildren();
/*     */           
/*     */           if (paramSkillPointsLeaderboardsResult.success) {
/*     */             if (paramSkillPointsLeaderboardsResult.player != null) {
/*     */               this.s.setTextFromInt(paramSkillPointsLeaderboardsResult.player.score);
/*     */             }
/*     */             
/*     */             for (byte b = 0; b < paramSkillPointsLeaderboardsResult.entries.size; b++) {
/*     */               LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = (LeaderBoardManager.LeaderboardsEntry)paramSkillPointsLeaderboardsResult.entries.get(b);
/*     */               
/*     */               Group group;
/*     */               
/*     */               (group = new Group()).setTransform(false);
/*     */               
/*     */               this.u.add((Actor)group).size(320.0F, 24.0F).row();
/*     */               
/*     */               LimitedWidthLabel limitedWidthLabel;
/*     */               
/*     */               (limitedWidthLabel = new LimitedWidthLabel(leaderboardsEntry.nickname, 21, 21, 240.0F)).setPosition(0.0F, 0.0F);
/*     */               
/*     */               limitedWidthLabel.setSize(100.0F, 24.0F);
/*     */               
/*     */               group.addActor((Actor)limitedWidthLabel);
/*     */               
/*     */               Table table;
/*     */               (table = new Table()).setPosition(160.0F, 0.0F);
/*     */               table.setSize(160.0F, 24.0F);
/*     */               group.addActor((Actor)table);
/*     */               table.add().height(32.0F).expandX().fillX();
/*     */               Image image;
/*     */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-skill-point"))).setColor(MaterialColor.CYAN.P500);
/*     */               table.add((Actor)image).size(24.0F, 24.0F).padRight(8.0F);
/*     */               Label label1;
/*     */               (label1 = new Label((CharSequence)StringFormatter.commaSeparatedNumber(leaderboardsEntry.score), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.CYAN.P500);
/*     */               table.add((Actor)label1).height(24.0F);
/*     */             } 
/*     */             return;
/*     */           } 
/*     */           this.s.setText("-");
/*     */           Label label;
/*     */           (label = new Label(Game.i.localeManager.i18n.get("failed_to_load"), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/*     */           this.u.add((Actor)label);
/*     */         });
/* 537 */     setLeaderBoardDate(Game.i.dailyQuestManager.getCurrentDayDate());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 542 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void a() {
/* 546 */     if (this.F == null)
/*     */       return; 
/*     */     int i;
/* 549 */     if ((i = this.F.endTimestamp - Game.getTimestampSeconds()) < 0) {
/*     */       
/* 551 */       this.g.setText("--");
/* 552 */       this.g.setVisible(true);
/*     */       return;
/*     */     } 
/* 555 */     this.g.setText((CharSequence)StringFormatter.digestTime(i));
/* 556 */     this.g.setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setLeaderBoardDate(String paramString) {
/* 561 */     this.f.clearChildren();
/*     */     
/*     */     Image image;
/* 564 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"))).setOrigin(32.0F, 32.0F);
/* 565 */     image.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/* 566 */     this.f.add((Actor)image).size(64.0F, 64.0F);
/*     */     
/* 568 */     String str = paramString;
/* 569 */     if (paramString.equals(Game.i.dailyQuestManager.getCurrentDayDate())) {
/* 570 */       str = str + " (" + Game.i.localeManager.i18n.get("in_progress") + ")";
/*     */     }
/* 572 */     this.e.setText(str);
/*     */     
/* 574 */     Game.i.dailyQuestManager.getLeaderboards(paramString, paramDailyQuestLeaderboards -> {
/*     */           this.f.clearChildren();
/*     */           
/*     */           if (paramDailyQuestLeaderboards.success) {
/*     */             float f = 0.0F;
/*     */             
/*     */             int i;
/*     */             
/*     */             for (i = 0; i < paramDailyQuestLeaderboards.entries.size; i++) {
/*     */               LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = (LeaderBoardManager.LeaderboardsEntry)paramDailyQuestLeaderboards.entries.get(i);
/*     */               
/*     */               Group group;
/*     */               
/*     */               (group = new Group()).setTransform(false);
/*     */               
/*     */               group.setSize(530.0F, 64.0F);
/*     */               
/*     */               this.f.add((Actor)group).row();
/*     */               
/*     */               f += 64.0F;
/*     */               if (i % 2 == 0) {
/*     */                 Image image1;
/*     */                 (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(623191551));
/*     */                 image1.setSize(530.0F, 64.0F);
/*     */                 group.addActor((Actor)image1);
/*     */               } 
/*     */               Label label2;
/*     */               (label2 = new Label(String.valueOf(i + 1), Game.i.assetManager.getLabelStyle(24))).setPosition(40.0F, 0.0F);
/*     */               label2.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */               label2.setSize(40.0F, 64.0F);
/*     */               label2.setAlignment(1);
/*     */               group.addActor((Actor)label2);
/*     */               Image image = new Image();
/*     */               if (leaderboardsEntry.hasProfilePicture) {
/*     */                 image.setDrawable((Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.loadWebTexture(Config.AVATAR_WEB_TEXTURES_URL + leaderboardsEntry.playerId.toLowerCase(Locale.US) + "-32.png")));
/*     */               } else {
/*     */                 image.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-user"));
/*     */                 image.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */               } 
/*     */               image.setPosition(92.0F, 16.0F);
/*     */               image.setSize(32.0F, 32.0F);
/*     */               group.addActor((Actor)image);
/*     */               LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(leaderboardsEntry.nickname, 30, 24, 240.0F);
/*     */               if (leaderboardsEntry.nickname.equals(Game.i.authManager.getNickname())) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.GREEN.P500);
/*     */               } else if (leaderboardsEntry.rank == 1) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P500);
/*     */               } else if (leaderboardsEntry.rank == 2) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P300);
/*     */               } else if (leaderboardsEntry.rank == 3) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P100);
/*     */               } 
/*     */               limitedWidthLabel.setPosition(140.0F, 0.0F);
/*     */               limitedWidthLabel.setSize(100.0F, 64.0F);
/*     */               limitedWidthLabel.setTouchable(Touchable.enabled);
/*     */               limitedWidthLabel.addListener((EventListener)new ClickListener(this, leaderboardsEntry)
/*     */                   {
/*     */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*     */                     {
/* 633 */                       (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_PLAYER_PROFILE_URL + this.a.playerId, null);
/* 634 */                       WebBrowser.i().setVisible(true);
/* 635 */                       LeaderboardsOverlay.i().hide();
/*     */                     }
/*     */                   });
/*     */               group.addActor((Actor)limitedWidthLabel);
/*     */               Label label1;
/*     */               (label1 = new Label((CharSequence)StringFormatter.commaSeparatedNumber(leaderboardsEntry.score), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/*     */               label1.setPosition(390.0F, 0.0F);
/*     */               label1.setSize(100.0F, 64.0F);
/*     */               group.addActor((Actor)label1);
/*     */             } 
/*     */             if (f < this.p.getHeight()) {
/*     */               this.f.add().size(530.0F, this.p.getHeight() - f);
/*     */             }
/*     */             if (paramDailyQuestLeaderboards.player == null) {
/*     */               this.i.setVisible(false);
/*     */               this.j.setVisible(true);
/*     */               this.h.setText(Game.i.localeManager.i18n.get("your_rank"));
/*     */             } else {
/*     */               if (paramDailyQuestLeaderboards.player.rank == 1) {
/*     */                 this.h.setText(Game.i.localeManager.i18n.get("your_rank") + " - " + Game.i.localeManager.i18n.get("leader") + "!");
/*     */               } else {
/*     */                 if ((i = MathUtils.ceil(paramDailyQuestLeaderboards.player.rank / paramDailyQuestLeaderboards.player.total * 100.0F)) < 0) {
/*     */                   i = 0;
/*     */                 }
/*     */                 if (i > 100) {
/*     */                   i = 100;
/*     */                 }
/*     */                 G.setLength(0);
/*     */                 G.append(Game.i.localeManager.i18n.get("your_rank"));
/*     */                 G.append(" - ");
/*     */                 G.append(Game.i.localeManager.i18n.format("top_percent", new Object[] { Integer.valueOf(i) }));
/*     */                 this.h.setText((CharSequence)G);
/*     */               } 
/*     */               this.n.setText(Game.i.authManager.getNickname());
/*     */               this.m.setText((paramDailyQuestLeaderboards.player.rank == 0) ? "?" : String.valueOf(paramDailyQuestLeaderboards.player.rank));
/*     */               this.o.setText((CharSequence)StringFormatter.commaSeparatedNumber(paramDailyQuestLeaderboards.player.score));
/*     */               this.i.setVisible(true);
/*     */               this.j.setVisible(false);
/*     */               return;
/*     */             } 
/*     */           } else {
/*     */             Label label;
/*     */             (label = new Label(Game.i.localeManager.i18n.get("failed_to_load"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/*     */             label.setColor(MaterialColor.ORANGE.P500);
/*     */             label.setAlignment(1);
/*     */             this.f.add((Actor)label).width(400.0F);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setVisible(boolean paramBoolean) {
/* 693 */     if (paramBoolean) {
/* 694 */       UiUtils.bouncyShowOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d); return;
/*     */     } 
/* 696 */     UiUtils.bouncyHideOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\DailyQuestOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */