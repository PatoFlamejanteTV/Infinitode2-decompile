/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameListener;
/*     */ import com.prineside.tdi2.ListenerGroup;
/*     */ import com.prineside.tdi2.MapPrestigeConfig;
/*     */ import com.prineside.tdi2.UserMap;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class MapPrestigeOverlay implements Disposable {
/*  30 */   private static final TLog a = TLog.forClass(MapPrestigeOverlay.class);
/*     */   
/*  32 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 175, "MapPrestigeOverlay overlay");
/*  33 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 176, "MapPrestigeOverlay main");
/*     */   
/*     */   private final Group d;
/*     */   
/*  37 */   public ListenerGroup<MapPrestigeOverlayListener> listeners = new ListenerGroup(MapPrestigeOverlayListener.class);
/*     */   
/*     */   private Image e;
/*  40 */   private Image[] f = new Image[5];
/*     */   
/*     */   private Label g;
/*     */   
/*     */   private Table h;
/*     */   private Label i;
/*     */   private Table j;
/*     */   private Label k;
/*     */   private Table l;
/*     */   private Label m;
/*     */   private Table n;
/*     */   private Label o;
/*     */   private Table p;
/*     */   private Label q;
/*     */   private Table r;
/*     */   private Label s;
/*     */   private Table t;
/*     */   private Table u;
/*     */   private Label v;
/*     */   private Label w;
/*     */   private QuadActor x;
/*     */   private Table y;
/*     */   private ComplexButton z;
/*     */   private MapPrestigeConfig A;
/*     */   
/*     */   public MapPrestigeOverlay() {
/*     */     Image image4;
/*  67 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  68 */     (image4.getColor()).a = 0.78F;
/*  69 */     this.b.getTable().add((Actor)image4).expand().fill();
/*  70 */     this.b.getTable().setTouchable(Touchable.enabled);
/*  71 */     this.b.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  74 */             MapPrestigeOverlay.a(this.a, false);
/*     */           }
/*     */         });
/*     */     
/*     */     Group group;
/*  79 */     (group = new Group()).setOrigin(320.0F, 428.5F);
/*  80 */     this.c.getTable().add((Actor)group).size(640.0F, 857.0F);
/*     */     
/*  82 */     this.d = new Group();
/*  83 */     this.d.setOrigin(320.0F, 428.5F);
/*  84 */     this.d.setSize(640.0F, 857.0F);
/*  85 */     group.addActor((Actor)this.d);
/*     */     
/*  87 */     QuadActor quadActor2 = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 857.0F, 640.0F, 844.0F, 640.0F, 10.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.d.addActor((Actor)quadActor2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     (quadActor2 = new QuadActor(new Color(724249599), new float[] { 0.0F, 3.0F, 0.0F, 187.0F, 252.0F, 190.0F, 249.0F, 0.0F })).setPosition(438.0F, 709.0F);
/* 103 */     this.d.addActor((Actor)quadActor2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     (quadActor2 = new QuadActor(new Color(387389439), new float[] { 0.0F, 3.0F, 0.0F, 176.0F, 239.0F, 179.0F, 236.0F, 0.0F })).setPosition(444.0F, 714.0F);
/* 112 */     this.d.addActor((Actor)quadActor2);
/*     */     
/* 114 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 115 */     this.e.setSize(236.0F, 173.0F);
/* 116 */     this.e.setPosition(444.0F, 717.0F);
/* 117 */     this.d.addActor((Actor)this.e);
/*     */     
/*     */     Label label5;
/*     */     
/* 121 */     (label5 = new Label(Game.i.localeManager.i18n.get("gv_title_PRESTIGE_MODE"), Game.i.assetManager.getLabelStyle(36))).setPosition(40.0F, 785.0F);
/* 122 */     label5.setSize(100.0F, 27.0F);
/* 123 */     this.d.addActor((Actor)label5);
/*     */ 
/*     */     
/* 126 */     (label5 = new Label(Game.i.localeManager.i18n.get("map_prestige_description"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 127 */     label5.setSize(100.0F, 16.0F);
/* 128 */     label5.setPosition(40.0F, 759.0F);
/* 129 */     this.d.addActor((Actor)label5);
/*     */     
/* 131 */     for (byte b = 0; b < 5; b++) {
/* 132 */       this.f[b] = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 133 */       this.f[b].setSize(32.0F, 32.0F);
/* 134 */       this.f[b].setPosition(40.0F + 36.0F * b, 712.0F);
/* 135 */       this.d.addActor((Actor)this.f[b]);
/*     */     } 
/*     */     
/* 138 */     this.g = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 139 */     this.g.setSize(100.0F, 18.0F);
/* 140 */     this.g.setPosition(227.0F, 719.0F);
/* 141 */     this.g.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 142 */     this.d.addActor((Actor)this.g);
/*     */     
/*     */     Image image3;
/* 145 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(623191551));
/* 146 */     image3.setSize(640.0F, 493.0F);
/* 147 */     image3.setPosition(0.0F, 157.0F);
/* 148 */     this.d.addActor((Actor)image3);
/*     */ 
/*     */     
/* 151 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setSize(640.0F, 16.0F);
/* 152 */     image3.setPosition(0.0F, 634.0F);
/* 153 */     image3.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 154 */     this.d.addActor((Actor)image3);
/*     */ 
/*     */     
/* 157 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setSize(640.0F, 16.0F);
/* 158 */     image3.setPosition(0.0F, 157.0F);
/* 159 */     image3.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 160 */     this.d.addActor((Actor)image3);
/*     */     
/*     */     Label label4;
/*     */     
/* 164 */     (label4 = new Label(Game.i.localeManager.i18n.get("map_price"), Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 56.0F);
/* 165 */     label4.setPosition(40.0F, 650.0F);
/* 166 */     this.d.addActor((Actor)label4);
/*     */     
/* 168 */     this.h = new Table();
/* 169 */     this.h.setPosition(300.0F, 650.0F);
/* 170 */     this.h.setSize(300.0F, 56.0F);
/* 171 */     this.d.addActor((Actor)this.h);
/*     */ 
/*     */ 
/*     */     
/*     */     Image image2;
/*     */ 
/*     */     
/* 178 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.07F);
/* 179 */     image2.setSize(640.0F, 56.0F);
/* 180 */     image2.setPosition(0.0F, 593.0F);
/* 181 */     this.d.addActor((Actor)image2);
/*     */     
/*     */     Label label3;
/* 184 */     (label3 = new Label(Game.i.localeManager.i18n.get("map_prestige_base_bonus"), Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 56.0F);
/* 185 */     label3.setPosition(40.0F, 593.0F);
/* 186 */     label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 187 */     this.d.addActor((Actor)label3);
/*     */     
/*     */     Table table;
/* 190 */     (table = new Table()).setSize(300.0F, 56.0F);
/* 191 */     table.setPosition(300.0F, 593.0F);
/* 192 */     this.d.addActor((Actor)table);
/*     */     
/* 194 */     table.add().height(1.0F).expandX().fillX();
/*     */     Label label6;
/* 196 */     (label6 = new Label("50%", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P300);
/* 197 */     table.add((Actor)label6);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     this.i = new Label(Game.i.localeManager.i18n.get("map_prestige_difficulty_bonus"), Game.i.assetManager.getLabelStyle(24));
/* 203 */     this.i.setSize(100.0F, 56.0F);
/* 204 */     this.i.setPosition(40.0F, 537.0F);
/* 205 */     this.d.addActor((Actor)this.i);
/*     */     
/* 207 */     this.j = new Table();
/* 208 */     this.j.setSize(300.0F, 56.0F);
/* 209 */     this.j.setPosition(300.0F, 537.0F);
/* 210 */     this.d.addActor((Actor)this.j);
/*     */ 
/*     */     
/*     */     Image image1;
/*     */     
/* 215 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.07F);
/* 216 */     image1.setSize(640.0F, 56.0F);
/* 217 */     image1.setPosition(0.0F, 481.0F);
/* 218 */     this.d.addActor((Actor)image1);
/*     */     
/* 220 */     this.k = new Label(Game.i.localeManager.i18n.get("map_prestige_no_abilities"), Game.i.assetManager.getLabelStyle(24));
/* 221 */     this.k.setSize(100.0F, 56.0F);
/* 222 */     this.k.setPosition(40.0F, 481.0F);
/* 223 */     this.d.addActor((Actor)this.k);
/*     */     
/* 225 */     this.l = new Table();
/* 226 */     this.l.setSize(300.0F, 56.0F);
/* 227 */     this.l.setPosition(300.0F, 481.0F);
/* 228 */     this.d.addActor((Actor)this.l);
/*     */ 
/*     */ 
/*     */     
/* 232 */     this.m = new Label(Game.i.localeManager.i18n.get("map_prestige_no_research"), Game.i.assetManager.getLabelStyle(24));
/* 233 */     this.m.setSize(100.0F, 56.0F);
/* 234 */     this.m.setPosition(40.0F, 425.0F);
/* 235 */     this.d.addActor((Actor)this.m);
/*     */     
/* 237 */     this.n = new Table();
/* 238 */     this.n.setSize(300.0F, 56.0F);
/* 239 */     this.n.setPosition(300.0F, 425.0F);
/* 240 */     this.d.addActor((Actor)this.n);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.07F);
/* 246 */     image1.setSize(640.0F, 56.0F);
/* 247 */     image1.setPosition(0.0F, 369.0F);
/* 248 */     this.d.addActor((Actor)image1);
/*     */     
/* 250 */     this.o = new Label(Game.i.localeManager.i18n.get("map_prestige_walkable_platforms"), Game.i.assetManager.getLabelStyle(24));
/* 251 */     this.o.setSize(100.0F, 56.0F);
/* 252 */     this.o.setPosition(40.0F, 369.0F);
/* 253 */     this.d.addActor((Actor)this.o);
/*     */     
/* 255 */     this.p = new Table();
/* 256 */     this.p.setSize(300.0F, 56.0F);
/* 257 */     this.p.setPosition(300.0F, 369.0F);
/* 258 */     this.d.addActor((Actor)this.p);
/*     */ 
/*     */ 
/*     */     
/* 262 */     this.q = new Label(Game.i.localeManager.i18n.get("map_prestige_no_bounty"), Game.i.assetManager.getLabelStyle(24));
/* 263 */     this.q.setSize(100.0F, 56.0F);
/* 264 */     this.q.setPosition(40.0F, 313.0F);
/* 265 */     this.d.addActor((Actor)this.q);
/*     */     
/* 267 */     this.r = new Table();
/* 268 */     this.r.setSize(300.0F, 56.0F);
/* 269 */     this.r.setPosition(300.0F, 313.0F);
/* 270 */     this.d.addActor((Actor)this.r);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 275 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.07F);
/* 276 */     image1.setSize(640.0F, 56.0F);
/* 277 */     image1.setPosition(0.0F, 257.0F);
/* 278 */     this.d.addActor((Actor)image1);
/*     */     
/* 280 */     this.s = new Label(Game.i.localeManager.i18n.get("map_prestige_no_miners"), Game.i.assetManager.getLabelStyle(24));
/* 281 */     this.s.setSize(100.0F, 56.0F);
/* 282 */     this.s.setPosition(40.0F, 257.0F);
/* 283 */     this.d.addActor((Actor)this.s);
/*     */     
/* 285 */     this.t = new Table();
/* 286 */     this.t.setSize(300.0F, 56.0F);
/* 287 */     this.t.setPosition(300.0F, 257.0F);
/* 288 */     this.d.addActor((Actor)this.t);
/*     */     
/*     */     Label label2;
/*     */     
/* 292 */     (label2 = new Label(Game.i.localeManager.i18n.get("score"), Game.i.assetManager.getLabelStyle(24))).setPosition(40.0F, 215.0F);
/* 293 */     label2.setSize(100.0F, 18.0F);
/* 294 */     this.d.addActor((Actor)label2);
/*     */     
/* 296 */     this.u = new Table();
/* 297 */     this.u.setSize(250.0F, 34.0F);
/* 298 */     this.u.setPosition(231.0F, 207.0F);
/* 299 */     this.d.addActor((Actor)this.u);
/*     */     
/* 301 */     this.v = new Label("", Game.i.assetManager.getLabelStyle(36));
/* 302 */     this.v.setSize(71.0F, 27.0F);
/* 303 */     this.v.setPosition(529.0F, 208.0F);
/* 304 */     this.v.setAlignment(16);
/* 305 */     this.d.addActor((Actor)this.v);
/*     */     
/* 307 */     this.w = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 308 */     this.w.setSize(71.0F, 19.0F);
/* 309 */     this.w.setAlignment(16);
/* 310 */     this.w.setPosition(529.0F, 178.0F);
/* 311 */     this.w.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 312 */     this.d.addActor((Actor)this.w);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor1;
/*     */ 
/*     */ 
/*     */     
/* 320 */     (quadActor1 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 0.0F, 0.0F, 0.0F, 20.0F, 442.0F, 20.0F, 439.0F, 0.0F })).setPosition(39.0F, 178.0F);
/* 321 */     this.d.addActor((Actor)quadActor1);
/*     */     
/* 323 */     this.x = new QuadActor(MaterialColor.LIGHT_BLUE.P500, new float[] { 0.0F, 0.0F, 0.0F, 20.0F, 442.0F, 20.0F, 439.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     this.x.setPosition(39.0F, 178.0F);
/* 330 */     this.d.addActor((Actor)this.x);
/*     */     
/*     */     Label label1;
/*     */     
/* 334 */     (label1 = new Label(Game.i.localeManager.i18n.get("map_prestige_total"), Game.i.assetManager.getLabelStyle(30))).setSize(71.0F, 22.0F);
/* 335 */     label1.setPosition(40.0F, 105.0F);
/* 336 */     this.d.addActor((Actor)label1);
/*     */     
/* 338 */     this.y = new Table();
/* 339 */     this.y.setPosition(228.0F, 95.0F);
/* 340 */     this.y.setSize(372.0F, 45.0F);
/* 341 */     this.d.addActor((Actor)this.y);
/*     */     
/*     */     ComplexButton complexButton;
/*     */     
/* 345 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("back"), Game.i.assetManager.getLabelStyle(30), () -> a(false))).setSize(255.0F, 93.0F);
/* 346 */     complexButton.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-map-prestige-button-left"), 0.0F, 0.0F, 255.0F, 93.0F);
/* 347 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-left"), 18.0F, 19.0F, 48.0F, 48.0F);
/* 348 */     complexButton.setLabel(77.0F, 30.0F, 100.0F, 23.0F, 8);
/* 349 */     complexButton.setPosition(-13.0F, -9.0F);
/* 350 */     this.d.addActor((Actor)complexButton);
/*     */     
/* 352 */     this.z = new ComplexButton(Game.i.localeManager.i18n.get("sell_button"), Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           String str = Game.i.localeManager.i18n.format("map_prestige_confirm", new Object[] { Integer.valueOf(this.A.getFinalPrestigeTokens()) });
/*     */ 
/*     */ 
/*     */           
/*     */           Dialog.i().showConfirm(str, ());
/*     */ 
/*     */ 
/*     */           
/*     */           Dialog.i().makeConfirmButtonDisabled(2);
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 366 */     this.z.setSize(247.0F, 93.0F);
/* 367 */     this.z.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-map-prestige-button-right"), 0.0F, 0.0F, 247.0F, 93.0F);
/* 368 */     this.z.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-dollar"), 21.0F, 19.0F, 48.0F, 48.0F);
/* 369 */     this.z.setLabel(80.0F, 30.0F, 100.0F, 23.0F, 8);
/* 370 */     this.z.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, MaterialColor.GREY.P800);
/* 371 */     this.z.setPosition(407.0F, -9.0F);
/* 372 */     this.d.addActor((Actor)this.z);
/*     */   }
/*     */   
/*     */   public static interface MapPrestigeOverlayListener extends GameListener {
/*     */     void prestigeConfirmed(); }
/*     */   
/*     */   public void show(MapPrestigeConfig paramMapPrestigeConfig) {
/* 379 */     a.i(paramMapPrestigeConfig.describe(), new Object[0]);
/* 380 */     this.A = paramMapPrestigeConfig;
/*     */     
/* 382 */     UserMap userMap = Game.i.userMapManager.getUserMap(paramMapPrestigeConfig.userMapId);
/* 383 */     int j = paramMapPrestigeConfig.getTotalBonus();
/* 384 */     int k = paramMapPrestigeConfig.getCrownsCount();
/*     */     
/* 386 */     if (userMap != null) {
/* 387 */       this.e.setVisible(true);
/* 388 */       this.e.setDrawable((Drawable)new TextureRegionDrawable(userMap.map.getPreview().getTextureRegion()));
/*     */     } else {
/* 390 */       this.e.setVisible(false);
/* 391 */       a.e("user map " + paramMapPrestigeConfig.userMapId + " not found for preview", new Object[0]);
/*     */     } 
/*     */ 
/*     */     
/* 395 */     for (byte b = 0; b < this.f.length; b++) {
/* 396 */       if (k >= b + 1) {
/* 397 */         this.f[b].setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */       } else {
/* 399 */         this.f[b].setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*     */       } 
/*     */     } 
/* 402 */     this.g.setText(j + "%");
/*     */ 
/*     */     
/* 405 */     this.h.clear();
/* 406 */     this.h.add().height(1.0F).expandX().fillX();
/*     */     
/* 408 */     Image image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 409 */     this.h.add((Actor)image2).size(32.0F).padRight(12.0F);
/*     */     
/* 411 */     Label label3 = new Label((int)paramMapPrestigeConfig.mapPrice, Game.i.assetManager.getLabelStyle(24));
/* 412 */     this.h.add((Actor)label3);
/*     */     
/* 414 */     (label3 = new Label("." + (int)StrictMath.round(paramMapPrestigeConfig.mapPrice % 1.0D * 1000.0D), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 415 */     this.h.add((Actor)label3).padLeft(4.0F);
/*     */ 
/*     */     
/* 418 */     this.i.setText(Game.i.localeManager.i18n.get("map_prestige_difficulty_bonus") + " (" + paramMapPrestigeConfig.averageDifficulty + "%)");
/* 419 */     if (paramMapPrestigeConfig.getDifficultyBonus() == 0) {
/* 420 */       this.i.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } else {
/* 422 */       this.i.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } 
/* 424 */     this.j.clear();
/* 425 */     this.j.add().height(1.0F).expandX().fillX();
/*     */ 
/*     */     
/* 428 */     (label3 = new Label(paramMapPrestigeConfig.getDifficultyBonus() + "%", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P500);
/* 429 */     this.j.add((Actor)label3);
/*     */     
/* 431 */     if (paramMapPrestigeConfig.getDifficultyBonus() < 50) {
/*     */       
/* 433 */       (label3 = new Label("/ 50%", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 434 */       this.j.add((Actor)label3).padLeft(6.0F);
/*     */     } 
/*     */ 
/*     */     
/* 438 */     this.l.clear();
/* 439 */     this.l.add().height(1.0F).expandX().fillX();
/*     */     
/* 441 */     label3 = new Label("10%", Game.i.assetManager.getLabelStyle(24));
/* 442 */     this.l.add((Actor)label3);
/* 443 */     if (paramMapPrestigeConfig.noAbilities) {
/* 444 */       this.k.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 445 */       label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } else {
/* 447 */       this.k.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 448 */       label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } 
/*     */ 
/*     */     
/* 452 */     this.n.clear();
/* 453 */     this.n.add().height(1.0F).expandX().fillX();
/*     */     
/* 455 */     label3 = new Label("40%", Game.i.assetManager.getLabelStyle(24));
/* 456 */     this.n.add((Actor)label3);
/* 457 */     if (paramMapPrestigeConfig.noResearch) {
/* 458 */       this.m.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 459 */       label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } else {
/* 461 */       this.m.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 462 */       label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } 
/*     */ 
/*     */     
/* 466 */     this.p.clear();
/* 467 */     this.p.add().height(1.0F).expandX().fillX();
/*     */     
/* 469 */     label3 = new Label("10%", Game.i.assetManager.getLabelStyle(24));
/* 470 */     this.p.add((Actor)label3);
/* 471 */     if (paramMapPrestigeConfig.walkablePlatforms) {
/* 472 */       this.o.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 473 */       label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } else {
/* 475 */       this.o.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 476 */       label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } 
/*     */ 
/*     */     
/* 480 */     this.r.clear();
/* 481 */     this.r.add().height(1.0F).expandX().fillX();
/*     */     
/* 483 */     label3 = new Label("20%", Game.i.assetManager.getLabelStyle(24));
/* 484 */     this.r.add((Actor)label3);
/* 485 */     if (paramMapPrestigeConfig.noBounty) {
/* 486 */       this.q.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 487 */       label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } else {
/* 489 */       this.q.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 490 */       label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } 
/*     */ 
/*     */     
/* 494 */     this.t.clear();
/* 495 */     this.t.add().height(1.0F).expandX().fillX();
/*     */     
/* 497 */     label3 = new Label("20%", Game.i.assetManager.getLabelStyle(24));
/* 498 */     this.t.add((Actor)label3);
/* 499 */     if (paramMapPrestigeConfig.noMiners) {
/* 500 */       this.s.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 501 */       label3.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */     } else {
/* 503 */       this.s.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 504 */       label3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */     } 
/*     */     
/*     */     float f;
/*     */     
/* 509 */     if ((f = (float)paramMapPrestigeConfig.score / paramMapPrestigeConfig.getMaxPrestigeScore()) > 1.0F) f = 1.0F; 
/* 510 */     this.x.setVertexPositions(new float[] { 0.0F, 0.0F, 0.0F, 20.0F, 439.0F * f + 3.0F, 20.0F, 439.0F * f, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 517 */     int i = StrictMath.round(f * 100.0F);
/* 518 */     this.v.setText("x" + (i / 100) + "." + (i % 100 / 10) + (i % 10));
/* 519 */     this.w.setText("=" + j + "%");
/*     */     
/* 521 */     this.u.clear();
/* 522 */     this.u.add().height(1.0F).expandX().fillX();
/*     */     
/*     */     Label label2;
/* 525 */     (label2 = new Label((CharSequence)StringFormatter.commaSeparatedNumber(paramMapPrestigeConfig.score), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_BLUE.P300);
/* 526 */     this.u.add((Actor)label2);
/*     */     
/* 528 */     label2 = new Label("/ " + StringFormatter.commaSeparatedNumber(paramMapPrestigeConfig.getMaxPrestigeScore()), Game.i.assetManager.getLabelStyle(21));
/* 529 */     this.u.add((Actor)label2).padLeft(12.0F);
/*     */ 
/*     */     
/* 532 */     this.y.clear();
/* 533 */     this.y.add().height(1.0F).expandX().fillX();
/*     */ 
/*     */     
/* 536 */     (label2 = new Label((int)paramMapPrestigeConfig.mapPrice + "." + StrictMath.round(paramMapPrestigeConfig.mapPrice % 1.0D * 1000.0D) + " + " + j + "% = ", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 537 */     this.y.add((Actor)label2);
/*     */     
/* 539 */     Image image1 = new Image((Drawable)Game.i.assetManager.getDrawable("prestige-token"));
/* 540 */     this.y.add((Actor)image1).size(48.0F);
/*     */     
/*     */     Label label1;
/* 543 */     (label1 = new Label(paramMapPrestigeConfig.getFinalPrestigeTokens(), Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.LIGHT_BLUE.P300);
/* 544 */     this.y.add((Actor)label1).padLeft(8.0F);
/*     */     
/* 546 */     boolean bool = (paramMapPrestigeConfig.getFinalPrestigeTokens() > 0 && Game.i.userMapManager.getUserMap(paramMapPrestigeConfig.userMapId) != null) ? true : false;
/* 547 */     this.z.setEnabled(bool);
/*     */     
/* 549 */     a(true);
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 553 */     if (paramBoolean) {
/* 554 */       UiUtils.bouncyShowOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d); return;
/*     */     } 
/* 556 */     UiUtils.bouncyHideOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 562 */     Game.i.uiManager.removeLayer(this.b);
/* 563 */     Game.i.uiManager.removeLayer(this.c);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MapPrestigeOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */