/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.events.game.BestReplayLoadFromServer;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class StatisticsChart implements Disposable {
/*     */   private TabType c;
/*     */   private Group d;
/*  38 */   private static final TLog a = TLog.forClass(StatisticsChart.class); private Group e;
/*     */   private Label f;
/*  40 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 104, "StatisticsChart"); private Group g; private boolean h;
/*     */   private boolean i;
/*     */   
/*  43 */   private enum TabType { SCORE,
/*  44 */     COINS,
/*  45 */     INFO;
/*     */     
/*  47 */     public static final TabType[] values = values();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private Label[] j = new Label[5];
/*  61 */   private Label[] k = new Label[5];
/*  62 */   private Label[] l = new Label[5];
/*  63 */   private Image[] m = new Image[5];
/*     */   
/*     */   private GameSystemProvider n;
/*     */   
/*  67 */   private static final StringBuilder o = new StringBuilder();
/*     */   
/*     */   public StatisticsChart(GameSystemProvider paramGameSystemProvider) {
/*  70 */     this.n = paramGameSystemProvider;
/*     */     
/*     */     Group group2;
/*  73 */     (group2 = new Group()).setTransform(false);
/*  74 */     group2.setTouchable(Touchable.childrenOnly);
/*     */ 
/*     */     
/*  77 */     this.d = new Group();
/*  78 */     this.d.setTransform(false);
/*  79 */     this.d.setSize(87.0F, 96.0F);
/*  80 */     this.d.setPosition(64.0F, 178.0F);
/*  81 */     group2.addActor((Actor)this.d);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor3;
/*     */ 
/*     */ 
/*     */     
/*  89 */     (quadActor3 = new QuadActor(new Color(522133503), new float[] { 0.0F, 0.0F, 3.0F, 22.0F, 45.0F, 22.0F, 48.0F, 0.0F })).setPosition(17.0F, 74.0F);
/*  90 */     this.d.addActor((Actor)quadActor3);
/*     */     
/*  92 */     quadActor3 = new QuadActor(new Color(724249599), new float[] { 6.0F, 3.0F, 0.0F, 78.0F, 87.0F, 80.0F, 80.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     this.d.addActor((Actor)quadActor3);
/*     */     
/*     */     Image image2;
/* 101 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-statistics"))).setPosition(18.0F, 16.0F);
/* 102 */     image2.setSize(48.0F, 48.0F);
/* 103 */     this.d.addActor((Actor)image2);
/*     */     
/* 105 */     this.d.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 108 */             this.a.setVisible(true);
/* 109 */             StatisticsChart.a(this.a, false);
/*     */           }
/*     */         });
/*     */     
/* 113 */     if (HotKeyHintLabel.isEnabled()) {
/* 114 */       HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_STATS_PANE), 18.0F, 54.0F);
/* 115 */       this.d.addActor((Actor)hotKeyHintLabel);
/*     */     } 
/*     */     
/* 118 */     this.e = new Group();
/* 119 */     this.e.setTransform(false);
/* 120 */     this.e.setTouchable(Touchable.childrenOnly);
/* 121 */     group2.addActor((Actor)this.e);
/*     */     
/* 123 */     this.b.getTable().add((Actor)group2).padLeft(824.0F).size(584.0F, 274.0F).expand().top().left();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor2;
/*     */ 
/*     */ 
/*     */     
/* 132 */     (quadActor2 = new QuadActor(new Color(505290495), new float[] { 0.0F, 0.0F, 6.0F, 24.0F, 378.0F, 24.0F, 385.0F, 0.0F })).setPosition(62.0F, 250.0F);
/* 133 */     this.e.addActor((Actor)quadActor2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor1;
/*     */ 
/*     */ 
/*     */     
/* 142 */     (quadActor1 = new QuadActor(new Color(724249599), new float[] { 9.0F, 0.0F, 0.0F, 205.0F, 514.0F, 201.0F, 505.0F, 5.0F })).setPosition(0.0F, 48.0F);
/* 143 */     this.e.addActor((Actor)quadActor1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     (quadActor1 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.14F), new float[] { 2.0F, 0.0F, 0.0F, 36.0F, 480.0F, 36.0F, 480.0F, 0.0F })).setTextureRegion((TextureRegion)Game.i.assetManager.getTextureRegion("gradient-left"));
/* 153 */     quadActor1.setPosition(2.0F, 168.0F);
/* 154 */     this.e.addActor((Actor)quadActor1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     (quadActor1 = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.14F), new float[] { 2.0F, 0.0F, 0.0F, 36.0F, 480.0F, 36.0F, 480.0F, 0.0F })).setTextureRegion((TextureRegion)Game.i.assetManager.getTextureRegion("gradient-left"));
/* 163 */     quadActor1.setPosition(5.0F, 96.0F);
/* 164 */     this.e.addActor((Actor)quadActor1);
/*     */     
/*     */     Table table;
/*     */     
/* 168 */     (table = new Table()).setPosition(286.0F, 8.0F);
/* 169 */     table.setSize(108.0F, 32.0F);
/* 170 */     this.e.addActor((Actor)table);
/*     */     
/* 172 */     table.add().expandX().fillX();
/*     */     
/*     */     Image image1;
/* 175 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-clock"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 176 */     table.add((Actor)image1).size(32.0F);
/*     */     
/* 178 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 179 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 180 */     table.add((Actor)this.f).height(32.0F).padLeft(6.0F);
/*     */     
/*     */     Group group1;
/*     */     
/* 184 */     (group1 = new Group()).setPosition(36.0F, 60.0F);
/* 185 */     group1.setTransform(false);
/* 186 */     this.e.addActor((Actor)group1);
/*     */     
/* 188 */     for (byte b = 0; b < 5; b++) {
/*     */       Table table1;
/* 190 */       (table1 = new Table()).setSize(445.0F, 36.0F);
/* 191 */       table1.setPosition(0.0F, 144.0F - b * 36.0F);
/* 192 */       group1.addActor((Actor)table1);
/*     */       
/* 194 */       this.j[b] = new Label("Title", Game.i.assetManager.getLabelStyle(21));
/* 195 */       table1.add((Actor)this.j[b]).height(36.0F);
/*     */       
/* 197 */       table1.add().expandX().fillX();
/*     */       
/* 199 */       this.l[b] = new Label("1,23K", Game.i.assetManager.getLabelStyle(21));
/* 200 */       table1.add((Actor)this.l[b]).height(36.0F);
/*     */       
/* 202 */       this.m[b] = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"));
/* 203 */       table1.add((Actor)this.m[b]).size(21.0F).padLeft(3.0F);
/*     */       
/* 205 */       this.k[b] = new Label("999K", Game.i.assetManager.getLabelStyle(24));
/* 206 */       this.k[b].setAlignment(16);
/* 207 */       table1.add((Actor)this.k[b]).height(36.0F).minWidth(75.0F).padLeft(16.0F);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     ComplexButton complexButton;
/*     */ 
/*     */     
/* 215 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> { setVisible(false); this.i = false; })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 5.0F, 4.0F, 0.0F, 43.0F, 88.0F, 44.0F, 86.0F, 0.0F })), 23.0F, 13.0F, 88.0F, 44.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     complexButton.setBackgroundColors(new Color(508719359), new Color(406936063), new Color(627345663), Color.WHITE);
/* 222 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"), 53.0F, 20.0F, 32.0F, 32.0F);
/* 223 */     complexButton.setSize(120.0F, 60.0F);
/* 224 */     complexButton.setPosition(394.0F, -13.0F);
/* 225 */     this.e.addActor((Actor)complexButton);
/*     */     
/* 227 */     if (HotKeyHintLabel.isEnabled()) {
/* 228 */       HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_STATS_PANE), 132.0F, 29.0F);
/* 229 */       complexButton.addActor((Actor)hotKeyHintLabel);
/*     */     } 
/*     */ 
/*     */     
/* 233 */     this.g = new Group();
/* 234 */     this.g.setTransform(false);
/* 235 */     this.g.setSize(74.0F, 206.0F);
/* 236 */     this.g.setPosition(510.0F, 47.0F);
/* 237 */     this.e.addActor((Actor)this.g);
/*     */ 
/*     */ 
/*     */     
/* 241 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_STATISTICS_CHART_VISIBLE) == 0.0D) {
/* 242 */       this.e.setPosition(0.0F, 276.0F);
/* 243 */       this.e.setVisible(false);
/*     */     } else {
/* 245 */       this.h = true;
/*     */     } 
/*     */     
/* 248 */     setTabType(TabType.SCORE);
/*     */     
/* 250 */     update();
/*     */     
/* 252 */     paramGameSystemProvider._gameUi.sideMenu.addListener((SideMenu.SideMenuListener)new SideMenu.SideMenuListener.SideMenuListenerAdapter(this, paramGameSystemProvider) {
/* 253 */           private final Timer.Task c = new Timer.Task(this)
/*     */             {
/*     */               public void run() {
/*     */                 try {
/* 257 */                   if (this.a.a._gameUi == null || this.a.a._gameUi.sideMenu == null) {
/* 258 */                     StatisticsChart.a().w("skip delayedHandler - already disposed?", new Object[0]);
/*     */                     return;
/*     */                   } 
/* 261 */                   if (!StatisticsChart.a(this.a.b))
/* 262 */                   { if (this.a.a._gameUi.sideMenu.isOffscreen() || !this.a.a._gameUi.sideMenu.isVisible()) {
/*     */                       
/* 264 */                       if (StatisticsChart.b(this.a.b))
/* 265 */                       { this.a.b.setVisible(true); }
/*     */                       else { return; }
/*     */                     
/*     */                     } else {
/* 269 */                       if (this.a.b.isVisible())
/* 270 */                       { this.a.b.setVisible(false);
/* 271 */                         StatisticsChart.a(this.a.b, true); }  return;
/*     */                     }  }
/*     */                   else { return; }
/*     */                 
/* 275 */                 } catch (Exception exception) {
/* 276 */                   StatisticsChart.a().w("delayedHandler failed", new Object[] { exception });
/*     */                 } 
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           public void offscreenStartingToChange() {
/* 283 */             if (!this.c.isScheduled()) Timer.schedule(this.c, 0.05F);
/*     */           
/*     */           }
/*     */           
/*     */           public void visibilityChanged() {
/* 288 */             if (!this.c.isScheduled()) Timer.schedule(this.c, 0.05F);
/*     */           
/*     */           }
/*     */         });
/* 292 */     paramGameSystemProvider.events.getListeners(BestReplayLoadFromServer.class).add(paramBestReplayLoadFromServer -> {
/*     */           this.c = null;
/*     */           if (paramGameSystemProvider.statistics != null) {
/*     */             setTabType(TabType.SCORE);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static boolean b() {
/*     */     float f;
/* 302 */     return ((f = Game.i.settingsManager.getScaledViewportHeight() / 1080.0F * Game.i.uiManager.getScreenWidth() / (Game.i.uiManager.getScreenHeight() + 1.0F)) >= 2.25F);
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 306 */     return this.h;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 310 */     Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_STATISTICS_CHART_VISIBLE, paramBoolean ? 1.0D : 0.0D);
/*     */     
/* 312 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 314 */     if (paramBoolean) {
/* 315 */       this.e.setVisible(true);
/* 316 */       this.e.clearActions();
/* 317 */       this.e.addAction((Action)Actions.moveTo(0.0F, 0.0F, 0.15F * f));
/*     */       
/* 319 */       this.d.clearActions();
/* 320 */       this.d.addAction((Action)Actions.moveTo(64.0F, 274.0F, 0.15F * f));
/*     */       
/* 322 */       if (!b()) this.n._gameUi.sideMenu.setOffscreen(true); 
/*     */     } else {
/* 324 */       this.e.clearActions();
/* 325 */       this.e.addAction(
/* 326 */           (Action)Actions.sequence(
/* 327 */             (Action)Actions.moveTo(0.0F, 276.0F, 0.15F * f), 
/* 328 */             (Action)Actions.hide()));
/*     */ 
/*     */ 
/*     */       
/* 332 */       this.d.clearActions();
/* 333 */       this.d.addAction((Action)Actions.moveTo(64.0F, 178.0F, 0.15F * f));
/*     */     } 
/*     */     
/* 336 */     this.h = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTabType(TabType paramTabType) {
/* 340 */     for (byte b = 0; b < 5; b++) {
/* 341 */       this.j[b].setColor(Color.WHITE);
/*     */     }
/*     */     
/* 344 */     if (this.c != paramTabType) {
/*     */       
/* 346 */       switch (null.a[paramTabType.ordinal()]) {
/*     */         case 1:
/* 348 */           this.j[0].setText(Game.i.localeManager.i18n.get("stats_chart_score"));
/* 349 */           this.j[0].setStyle(Game.i.assetManager.getLabelStyle(24));
/* 350 */           this.j[1].setText(Game.i.localeManager.i18n.get("stats_chart_killed_enemies"));
/* 351 */           this.j[2].setText(Game.i.localeManager.i18n.get("stats_chart_mining"));
/* 352 */           this.j[3].setText(Game.i.localeManager.i18n.get("stats_chart_wave_calls"));
/* 353 */           this.j[4].setText(Game.i.localeManager.i18n.get("stats_chart_waves_cleared"));
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 358 */           this.j[0].setText(Game.i.localeManager.i18n.get("stats_chart_coins"));
/* 359 */           this.j[0].setStyle(Game.i.assetManager.getLabelStyle(24));
/* 360 */           this.j[1].setText(Game.i.localeManager.i18n.get("stats_chart_killed_enemies"));
/* 361 */           this.j[2].setText(Game.i.localeManager.i18n.get("stats_chart_bounties"));
/* 362 */           this.j[3].setText(Game.i.localeManager.i18n.get("stats_chart_wave_calls"));
/* 363 */           this.j[4].setText(Game.i.localeManager.i18n.get("stats_chart_other"));
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 368 */           replayRecord = this.n.statistics.getBestReplay();
/* 369 */           this.j[0].setText(Game.i.localeManager.i18n.get("stats_chart_comparison_hint"));
/* 370 */           this.j[0].setStyle(Game.i.assetManager.getLabelStyle(21));
/* 371 */           if (replayRecord != null) {
/* 372 */             Date date = new Date(replayRecord.startTimestamp);
/* 373 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US);
/* 374 */             this.j[1].setText(simpleDateFormat.format(date));
/* 375 */             this.j[1].setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */           } 
/* 377 */           this.j[2].setText(Game.i.localeManager.i18n.get("stats_chart_waves"));
/* 378 */           this.j[3].setText(Game.i.localeManager.i18n.get("stats_chart_score"));
/* 379 */           this.j[4].setText(Game.i.localeManager.i18n.get("stats_chart_playing_time"));
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 386 */       this.g.clear();
/* 387 */       ReplayManager.ReplayRecord replayRecord = this.n.statistics.getBestReplay();
/*     */       
/* 389 */       for (byte b1 = 0; b1 < 3; b1++) {
/* 390 */         TabType tabType = TabType.values[b1];
/* 391 */         if (replayRecord != null || tabType != TabType.INFO) {
/*     */           QuadActor quadActor;
/*     */ 
/*     */           
/*     */           Image image;
/*     */           
/* 397 */           if (paramTabType == tabType) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 405 */             (quadActor = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 60.0F, 74.0F, 60.0F, 72.0F, 0.0F })).setPosition(-b1 * 2.0F - 8.0F, 142.0F - b1 * 68.0F);
/*     */ 
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */ 
/*     */             
/* 413 */             (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.21F), new float[] { 0.0F, 0.0F, 2.0F, 60.0F, 64.0F, 60.0F, 62.0F, 0.0F })).setPosition(10.0F - b1 * 2.0F, 142.0F - b1 * 68.0F);
/*     */           } 
/* 415 */           this.g.addActor((Actor)quadActor);
/*     */           
/* 417 */           quadActor.setTouchable(Touchable.enabled);
/* 418 */           quadActor.addListener((EventListener)new ClickListener(this, tabType)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 421 */                   this.b.setTabType(this.a);
/*     */                 }
/*     */               });
/*     */ 
/*     */           
/* 426 */           switch (null.a[tabType.ordinal()]) { case 1:
/* 427 */               image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star")); break;
/* 428 */             case 2: image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-coin")); break;
/* 429 */             case 3: image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info")); break;
/* 430 */             default: image = new Image((Drawable)Game.i.assetManager.getDrawable("blank")); break; }
/*     */           
/* 432 */           image.setSize(48.0F, 48.0F);
/* 433 */           if (paramTabType == tabType) {
/* 434 */             image.setPosition(18.0F - b1 * 2.0F - 10.0F, 148.0F - b1 * 68.0F);
/*     */           } else {
/* 436 */             image.setPosition(18.0F - b1 * 2.0F, 148.0F - b1 * 68.0F);
/* 437 */             image.setColor(new Color(508719359));
/*     */           } 
/* 439 */           image.setTouchable(Touchable.disabled);
/* 440 */           this.g.addActor((Actor)image);
/*     */         } 
/*     */       } 
/*     */       
/* 444 */       this.c = paramTabType;
/*     */     } 
/*     */     
/* 447 */     update();
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 451 */     update();
/*     */   }
/*     */   
/*     */   private void a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean) {
/* 455 */     this.l[4].setVisible(true);
/* 456 */     this.m[4].setVisible(true);
/* 457 */     if (paramBoolean) {
/* 458 */       this.l[4].setColor(MaterialColor.LIGHT_GREEN.P500);
/* 459 */       this.m[4].setColor(MaterialColor.LIGHT_GREEN.P500);
/* 460 */       this.m[4].setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"));
/*     */     } else {
/* 462 */       this.l[4].setColor(MaterialColor.ORANGE.P500);
/* 463 */       this.m[4].setColor(MaterialColor.ORANGE.P500);
/* 464 */       this.m[4].setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/*     */     } 
/* 466 */     this.l[4].setText(paramCharSequence);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, long paramLong) {
/* 470 */     if (paramLong != 0L) {
/* 471 */       this.l[paramInt].setVisible(true);
/* 472 */       this.m[paramInt].setVisible(true);
/* 473 */       if (paramLong > 0L) {
/* 474 */         this.l[paramInt].setColor(MaterialColor.LIGHT_GREEN.P500);
/* 475 */         this.m[paramInt].setColor(MaterialColor.LIGHT_GREEN.P500);
/* 476 */         this.m[paramInt].setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"));
/*     */       } else {
/* 478 */         this.l[paramInt].setColor(MaterialColor.ORANGE.P500);
/* 479 */         this.m[paramInt].setColor(MaterialColor.ORANGE.P500);
/* 480 */         this.m[paramInt].setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/*     */       } 
/* 482 */       this.l[paramInt].setText((CharSequence)StringFormatter.compactNumber(paramLong, false));
/*     */     } 
/*     */   }
/*     */   public void update() {
/*     */     ReplayManager.ReplayRecord.ChartFrames.FrameValues frameValues;
/* 487 */     if (!this.e.isVisible())
/*     */       return; 
/* 489 */     ReplayManager.ReplayRecord.ChartFrames chartFrames = this.n.statistics.getCurrentReplayChart();
/*     */     
/* 491 */     for (byte b = 0; b < 5; b++) {
/* 492 */       this.l[b].setVisible(false);
/* 493 */       this.m[b].setVisible(false);
/*     */     } 
/*     */     
/* 496 */     if (this.c == TabType.SCORE) {
/*     */       ReplayManager.ReplayRecord.ChartFrames.FrameValues frameValues1;
/*     */       
/* 499 */       long l = (frameValues1 = this.n.statistics.getCurrentReplayChartValues()).sKilledEnemies + frameValues1.sMining + frameValues1.sWaveCalls + frameValues1.sWavesCleared;
/*     */       
/* 501 */       for (byte b1 = 0; b1 < 5; b1++) {
/* 502 */         this.k[b1].setVisible(true);
/*     */       }
/*     */       
/* 505 */       this.k[0].setText((CharSequence)StringFormatter.compactNumber(l, false));
/* 506 */       this.k[1].setText((CharSequence)StringFormatter.compactNumber(frameValues1.sKilledEnemies, false));
/* 507 */       this.k[2].setText((CharSequence)StringFormatter.compactNumber(frameValues1.sMining, false));
/* 508 */       this.k[3].setText((CharSequence)StringFormatter.compactNumber(frameValues1.sWaveCalls, false));
/* 509 */       this.k[4].setText((CharSequence)StringFormatter.compactNumber(frameValues1.sWavesCleared, false));
/*     */       int i;
/*     */       ReplayManager.ReplayRecord replayRecord;
/* 512 */       if ((replayRecord = this.n.statistics.getBestReplay()) != null && (
/*     */         
/* 514 */         i = chartFrames.frames.size - 1) >= 0)
/*     */       {
/* 516 */         ReplayManager.ReplayRecord.ChartFrames chartFrames1 = replayRecord.chartFrames;
/* 517 */         frameValues = ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])chartFrames.frames.items)[i];
/* 518 */         ReplayManager.ReplayRecord.ChartFrames.FrameValues frameValues2 = (chartFrames1.frames.size > i) ? ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])chartFrames1.frames.items)[i] : ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])chartFrames1.frames.items)[chartFrames1.frames.size - 1];
/*     */         
/* 520 */         long l1 = frameValues.sKilledEnemies + frameValues.sMining + frameValues.sWaveCalls + frameValues.sWavesCleared;
/* 521 */         long l2 = frameValues2.sKilledEnemies + frameValues2.sMining + frameValues2.sWaveCalls + frameValues2.sWavesCleared;
/* 522 */         a(0, l1 - l2);
/* 523 */         a(1, frameValues.sKilledEnemies - frameValues2.sKilledEnemies);
/* 524 */         a(2, frameValues.sMining - frameValues2.sMining);
/* 525 */         a(3, frameValues.sWaveCalls - frameValues2.sWaveCalls);
/* 526 */         a(4, frameValues.sWavesCleared - frameValues2.sWavesCleared);
/*     */       }
/*     */     
/* 529 */     } else if (this.c == TabType.COINS) {
/*     */       ReplayManager.ReplayRecord.ChartFrames.FrameValues frameValues1;
/*     */       
/* 532 */       int i = (frameValues1 = this.n.statistics.getCurrentReplayChartValues()).cBounties + frameValues1.cKilledEnemies + frameValues1.cOther + frameValues1.cWaveCalls;
/*     */       
/* 534 */       for (byte b1 = 0; b1 < 5; b1++) {
/* 535 */         this.k[b1].setVisible(true);
/*     */       }
/*     */       
/* 538 */       this.k[0].setText((CharSequence)StringFormatter.compactNumber(i, false));
/* 539 */       this.k[1].setText((CharSequence)StringFormatter.compactNumber(frameValues1.cKilledEnemies, false));
/* 540 */       this.k[2].setText((CharSequence)StringFormatter.compactNumber(frameValues1.cBounties, false));
/* 541 */       this.k[3].setText((CharSequence)StringFormatter.compactNumber(frameValues1.cWaveCalls, false));
/* 542 */       this.k[4].setText((CharSequence)StringFormatter.compactNumber(frameValues1.cOther, false));
/*     */       ReplayManager.ReplayRecord replayRecord;
/*     */       int j;
/* 545 */       if ((replayRecord = this.n.statistics.getBestReplay()) != null && (
/*     */         
/* 547 */         j = ((ReplayManager.ReplayRecord.ChartFrames)frameValues).frames.size - 1) >= 0) {
/*     */         
/* 549 */         ReplayManager.ReplayRecord.ChartFrames chartFrames1 = replayRecord.chartFrames;
/* 550 */         ReplayManager.ReplayRecord.ChartFrames.FrameValues frameValues2 = ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])((ReplayManager.ReplayRecord.ChartFrames)frameValues).frames.items)[j];
/* 551 */         frameValues = (chartFrames1.frames.size > j) ? ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])chartFrames1.frames.items)[j] : ((ReplayManager.ReplayRecord.ChartFrames.FrameValues[])chartFrames1.frames.items)[chartFrames1.frames.size - 1];
/*     */         
/* 553 */         int k = frameValues2.cKilledEnemies + frameValues2.cWaveCalls + frameValues2.cBounties + frameValues2.cOther;
/* 554 */         int m = frameValues.cKilledEnemies + frameValues.cWaveCalls + frameValues.cBounties + frameValues.cOther;
/* 555 */         a(0, (k - m));
/* 556 */         a(1, (frameValues2.cKilledEnemies - frameValues.cKilledEnemies));
/* 557 */         a(2, (frameValues2.cBounties - frameValues.cBounties));
/* 558 */         a(3, (frameValues2.cWaveCalls - frameValues.cWaveCalls));
/* 559 */         a(4, (frameValues2.cOther - frameValues.cOther));
/*     */       } 
/*     */     } else {
/* 562 */       ReplayManager.ReplayRecord replayRecord; if (this.c == TabType.INFO && (
/*     */         
/* 564 */         replayRecord = this.n.statistics.getBestReplay()) != null) {
/* 565 */         this.j[2].setText(Game.i.localeManager.i18n.get("stats_chart_waves"));
/* 566 */         this.j[3].setText(Game.i.localeManager.i18n.get("stats_chart_score"));
/* 567 */         this.j[4].setText(Game.i.localeManager.i18n.get("stats_chart_playing_time"));
/*     */         
/* 569 */         int i = (int)((replayRecord.chartFrames.frames.size * Config.REPLAY_CHARTS_INTERVAL) / this.n.gameValue.getTickRate());
/* 570 */         this.k[2].setTextFromInt(replayRecord.defeatedWaves);
/* 571 */         this.k[3].setText((CharSequence)StringFormatter.commaSeparatedNumber(replayRecord.score));
/* 572 */         this.k[4].setText((CharSequence)StringFormatter.digestTime(i));
/*     */         
/* 574 */         this.k[0].setVisible(false);
/* 575 */         this.k[1].setVisible(false);
/* 576 */         a(2, (this.n.wave.getCompletedWavesCount() - replayRecord.defeatedWaves));
/* 577 */         a(3, this.n.gameState.getScore() - replayRecord.score);
/*     */         
/* 579 */         o.setLength(0);
/*     */         
/*     */         int j, k;
/* 582 */         if ((k = (j = (int)(this.n.statistics.replayChartFrameCounter / this.n.gameValue.getTickRate())) - i) < 0) {
/* 583 */           k = -k;
/* 584 */           o.append('-').append(StringFormatter.digestTime(k));
/* 585 */           a(4, (CharSequence)o, false);
/*     */         } else {
/* 587 */           o.append(StringFormatter.digestTime(k));
/* 588 */           a(4, (CharSequence)o, true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 594 */     this.f.setText((CharSequence)StringFormatter.digestTimeWithZeroHours(this.n.statistics.replayChartFrameCounter / this.n.gameValue.getTickRate(), false));
/*     */   }
/*     */   
/*     */   public void finalFadeOut() {
/* 598 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 600 */     this.b.getTable().setTouchable(Touchable.disabled);
/* 601 */     this.b.getTable().clearActions();
/* 602 */     this.b.getTable().addAction((Action)Actions.alpha(0.0F, f * 1.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 607 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\StatisticsChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */