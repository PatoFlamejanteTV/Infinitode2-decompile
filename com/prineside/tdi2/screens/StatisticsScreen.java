/*     */ package com.prineside.tdi2.screens;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntFloatMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class StatisticsScreen
/*     */   extends Screen
/*     */ {
/*  57 */   private static final TLog a = TLog.forClass(StatisticsScreen.class);
/*     */   
/*  59 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "StatisticsScreen main"); private ScrollPane c; private RectButton d; private RectButton e; private RectButton f; private RectButton g; private RectButton h; private Table i;
/*     */   private Image j;
/*     */   
/*  62 */   private enum MainTabType { ALL_TIME,
/*  63 */     BY_GAME,
/*  64 */     MAX_ONE_GAME,
/*  65 */     ACHIEVEMENTS,
/*  66 */     EARNINGS; }
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
/*  79 */   private MainTabType k = MainTabType.ALL_TIME;
/*  80 */   private ReplayManager.ReplayRecord l = null;
/*     */   
/*     */   private Label.LabelStyle m;
/*     */   
/*     */   private Drawable n;
/*  85 */   private static final StringBuilder o = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatisticsScreen() {
/*  91 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */ 
/*     */     
/*  94 */     Game.i.uiManager.hideAllComponents();
/*  95 */     Game.i.uiManager.setAsInputHandler();
/*     */     
/*  97 */     ScreenTitle.i()
/*  98 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-statistics"))
/*  99 */       .setText(Game.i.localeManager.i18n.get("statistics_title"))
/* 100 */       .setVisible(true);
/*     */     
/* 102 */     BackButton.i()
/* 103 */       .setVisible(true)
/* 104 */       .setText(null)
/* 105 */       .setClickHandler(() -> Game.i.screenManager.goToMainMenu());
/*     */     
/* 107 */     this.m = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/* 108 */     this.n = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*     */     
/* 110 */     Table table1 = this.b.getTable();
/*     */     
/* 112 */     Table table2 = new Table();
/* 113 */     table1.add((Actor)table2).padLeft(40.0F).padRight(40.0F).padTop(160.0F).width(320.0F).minHeight(100.0F).expandY().fillY();
/*     */     
/* 115 */     this.d = new RectButton(Game.i.localeManager.i18n.get("statistics_subtitle_all_time"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           this.k = MainTabType.ALL_TIME;
/*     */           a();
/*     */         });
/* 119 */     this.d.setSize(320.0F, 64.0F);
/* 120 */     this.d.setBackground((Drawable)new QuadDrawable(new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE)), 0.0F, 0.0F, 320.0F, 64.0F);
/* 121 */     this.d.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.07F), new Color(1.0F, 1.0F, 1.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 122 */     this.d.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/* 123 */     table2.add((Actor)this.d).top().row();
/*     */     
/* 125 */     this.e = new RectButton(Game.i.localeManager.i18n.get("statistics_subtitle_by_game"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           this.l = null;
/*     */           this.k = MainTabType.BY_GAME;
/*     */           a();
/*     */         });
/* 130 */     this.e.setSize(320.0F, 64.0F);
/* 131 */     this.e.setBackground((Drawable)new QuadDrawable(new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE)), 0.0F, 0.0F, 320.0F, 64.0F);
/* 132 */     this.e.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.07F), new Color(1.0F, 1.0F, 1.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 133 */     this.e.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/* 134 */     table2.add((Actor)this.e).top().padTop(4.0F).row();
/*     */     
/* 136 */     this.f = new RectButton(Game.i.localeManager.i18n.get("statistics_subtitle_max_per_game"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           this.k = MainTabType.MAX_ONE_GAME;
/*     */           a();
/*     */         });
/* 140 */     this.f.setSize(320.0F, 64.0F);
/* 141 */     this.f.setBackground((Drawable)new QuadDrawable(new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE)), 0.0F, 0.0F, 320.0F, 64.0F);
/* 142 */     this.f.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.07F), new Color(1.0F, 1.0F, 1.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 143 */     this.f.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/* 144 */     table2.add((Actor)this.f).top().padTop(4.0F).row();
/*     */     
/* 146 */     this.g = new RectButton(Game.i.localeManager.i18n.get("statistics_subtitle_achievements"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           this.k = MainTabType.ACHIEVEMENTS;
/*     */           a();
/*     */         });
/* 150 */     this.g.setSize(320.0F, 64.0F);
/* 151 */     this.g.setBackground((Drawable)new QuadDrawable(new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE)), 0.0F, 0.0F, 320.0F, 64.0F);
/* 152 */     this.g.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.07F), new Color(1.0F, 1.0F, 1.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 153 */     this.g.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/* 154 */     table2.add((Actor)this.g).top().padTop(4.0F).row();
/*     */     
/* 156 */     this.j = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"));
/* 157 */     this.j.setSize(32.25F, 36.75F);
/* 158 */     this.j.setPosition(277.75F, 11.0F);
/* 159 */     if (Game.i.achievementManager.countAchievementsToRedeem() == 0) {
/* 160 */       this.j.setVisible(false);
/*     */     }
/* 162 */     this.g.addActor((Actor)this.j);
/*     */     
/* 164 */     this.h = new RectButton(Game.i.localeManager.i18n.get("statistics_subtitle_earned_items"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           Array array = Game.i.progressManager.getIssuedPrizes();
/*     */           byte b = 0;
/*     */           while (b < array.size && b != 50) {
/*     */             ((IssuedItems)array.get(b)).shown = false;
/*     */             b++;
/*     */           } 
/*     */           Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*     */         });
/* 173 */     this.h.setSize(320.0F, 64.0F);
/* 174 */     this.h.setBackground((Drawable)new QuadDrawable(new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE)), 0.0F, 0.0F, 320.0F, 64.0F);
/* 175 */     this.h.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.07F), new Color(1.0F, 1.0F, 1.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 176 */     this.h.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/* 177 */     table2.add((Actor)this.h).expandY().top().padTop(4.0F).row();
/*     */     
/* 179 */     table2 = new Table();
/* 180 */     this.c = new ScrollPane((Actor)table2);
/* 181 */     UiUtils.enableMouseMoveScrollFocus(this.c);
/*     */     
/* 183 */     table1.add((Actor)this.c).padRight(40.0F).fill().expand();
/*     */     
/* 185 */     table2.add().top().left().height(160.0F).fillX().expandX().row();
/* 186 */     this.i = new Table();
/* 187 */     table2.add((Actor)this.i).expandX().fillX().padBottom(160.0F).row();
/* 188 */     table2.add().fill().expand();
/*     */     
/* 190 */     a();
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
/*     */   public void show() {
/* 209 */     super.show();
/* 210 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.c);
/*     */   }
/*     */   
/*     */   private void a(Table paramTable, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     Table table;
/* 215 */     (table = new Table()).setBackground(this.n);
/*     */     
/* 217 */     LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(paramCharSequence1, 24, 21, 240.0F);
/* 218 */     table.add((Actor)limitedWidthLabel).maxWidth(240.0F).padLeft(16.0F);
/*     */     
/*     */     Label label;
/* 221 */     (label = new Label(paramCharSequence2, this.m)).setAlignment(16);
/* 222 */     table.add((Actor)label).padRight(16.0F).expandX().fillX();
/*     */     
/* 224 */     paramTable.add((Actor)table).fillX().expandX().height(48.0F).padBottom(4.0F).row();
/*     */   }
/*     */   
/*     */   private void a(Table paramTable, StatisticsType paramStatisticsType, IntFloatMap paramIntFloatMap) {
/* 228 */     if (!paramIntFloatMap.containsKey(paramStatisticsType.ordinal()))
/*     */       return; 
/* 230 */     a(paramTable, Game.i.statisticsManager.getStatisticsTitle(paramStatisticsType), (CharSequence)StringFormatter.commaSeparatedNumber((long)paramIntFloatMap.get(paramStatisticsType.ordinal(), 0.0F)));
/*     */   }
/*     */   
/*     */   private void b(Table paramTable, StatisticsType paramStatisticsType, IntFloatMap paramIntFloatMap) {
/* 234 */     if (!paramIntFloatMap.containsKey(paramStatisticsType.ordinal()))
/*     */       return; 
/* 236 */     a(paramTable, Game.i.statisticsManager.getStatisticsTitle(paramStatisticsType), (CharSequence)StringFormatter.digestTime((int)paramIntFloatMap.get(paramStatisticsType.ordinal(), 0.0F)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Table paramTable, IntFloatMap paramIntFloatMap) {
/* 241 */     a(paramTable, StatisticsType.CG, paramIntFloatMap);
/* 242 */     a(paramTable, StatisticsType.EK, paramIntFloatMap);
/* 243 */     a(paramTable, StatisticsType.EP, paramIntFloatMap);
/* 244 */     a(paramTable, StatisticsType.GPG, paramIntFloatMap);
/*     */     
/* 246 */     a(paramTable, StatisticsType.WD, paramIntFloatMap);
/* 247 */     a(paramTable, StatisticsType.SG, paramIntFloatMap);
/*     */     
/* 249 */     if (Game.i.minerManager.isMinerOpened(MinerType.SCALAR, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG, paramIntFloatMap); 
/* 250 */     if (Game.i.minerManager.isMinerOpened(MinerType.SCALAR, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG_S, paramIntFloatMap); 
/* 251 */     if (Game.i.minerManager.isMinerOpened(MinerType.VECTOR, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG_V, paramIntFloatMap); 
/* 252 */     if (Game.i.minerManager.isMinerOpened(MinerType.MATRIX, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG_M, paramIntFloatMap); 
/* 253 */     if (Game.i.minerManager.isMinerOpened(MinerType.TENSOR, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG_T, paramIntFloatMap); 
/* 254 */     if (Game.i.minerManager.isMinerOpened(MinerType.INFIAR, (GameValueProvider)Game.i.gameValueManager.getSnapshot())) a(paramTable, StatisticsType.RG_I, paramIntFloatMap);
/*     */     
/* 256 */     a(paramTable, StatisticsType.TB, paramIntFloatMap);
/* 257 */     a(paramTable, StatisticsType.TS, paramIntFloatMap);
/* 258 */     a(paramTable, StatisticsType.TU, paramIntFloatMap);
/* 259 */     a(paramTable, StatisticsType.TMS, paramIntFloatMap);
/* 260 */     a(paramTable, StatisticsType.TDD, paramIntFloatMap);
/* 261 */     a(paramTable, StatisticsType.GS, paramIntFloatMap);
/* 262 */     b(paramTable, StatisticsType.PT, paramIntFloatMap);
/* 263 */     b(paramTable, StatisticsType.PRT, paramIntFloatMap);
/* 264 */     a(paramTable, StatisticsType.WC, paramIntFloatMap);
/* 265 */     b(paramTable, StatisticsType.WCST, paramIntFloatMap);
/* 266 */     a(paramTable, StatisticsType.WCGC, paramIntFloatMap);
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(Table paramTable, IntFloatMap paramIntFloatMap) {
/* 271 */     Table table2, table1 = new Table(); TowerType[] arrayOfTowerType3; int j; byte b2;
/* 272 */     for (j = (arrayOfTowerType3 = TowerType.values).length, b2 = 0; b2 < j; ) { TowerType towerType = arrayOfTowerType3[b2];
/* 273 */       StatisticsType statisticsType = Game.i.towerManager.getMoneySpentStatisticType(towerType);
/* 274 */       if (paramIntFloatMap.get(statisticsType.ordinal(), 0.0F) != 0.0F) {
/*     */         Image image;
/*     */         
/* 277 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Game.i.towerManager.getFactory(towerType).getColor());
/* 278 */         table1.add((Actor)image).size(24.0F, 24.0F).padRight(16.0F);
/*     */         
/* 280 */         Label label = new Label(Game.i.towerManager.getFactory(towerType).getTitle(), this.m);
/* 281 */         table1.add((Actor)label).expandX().fillX().row();
/*     */       }  b2++; }
/*     */     
/*     */     byte b1;
/* 285 */     if (b1 = (Game.i.uiManager.getScreenWidth() / Game.i.uiManager.getScreenHeight() < 1.5F) ? 1 : 0)
/*     */     {
/* 287 */       paramTable.add((Actor)table1).fillX().expandX().padBottom(64.0F).row();
/*     */     }
/* 289 */     float f1 = b1 ? 220.0F : 300.0F;
/*     */ 
/*     */     
/* 292 */     if (b1) {
/* 293 */       table2 = paramTable;
/*     */     } else {
/*     */       
/* 296 */       table2 = new Table();
/* 297 */       paramTable.add((Actor)table2);
/*     */       
/* 299 */       paramTable.add((Actor)table1).padLeft(80.0F);
/*     */     } 
/*     */ 
/*     */     
/*     */     Label label2;
/*     */ 
/*     */     
/* 306 */     (label2 = new Label(Game.i.localeManager.i18n.get("statistics_TB"), this.m)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 307 */     table2.add((Actor)label2).height(64.0F).padBottom(16.0F).row();
/*     */     
/* 309 */     PieChartActor pieChartActor2 = new PieChartActor();
/* 310 */     Array array2 = new Array(PieChart.ChartEntryConfig.class);
/* 311 */     float f3 = 0.0F; TowerType[] arrayOfTowerType1;
/* 312 */     for (int i = (arrayOfTowerType1 = TowerType.values).length; b1 < i; ) { TowerType towerType = arrayOfTowerType1[b1];
/* 313 */       StatisticsType statisticsType = Game.i.towerManager.getBuiltStatisticType(towerType);
/*     */       float f;
/* 315 */       if ((f = paramIntFloatMap.get(statisticsType.ordinal(), 0.0F)) > 0.0D) {
/*     */         
/* 317 */         f3 += f;
/*     */         
/* 319 */         array2.add(new PieChart.ChartEntryConfig(Game.i.towerManager
/* 320 */               .getFactory(towerType).getColor(), f, 0.0F));
/*     */       } 
/*     */       
/*     */       b1++; }
/*     */     
/* 325 */     if (f3 == 0.0F) {
/* 326 */       array2.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 100.0F, 0.0F));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     pieChartActor2.setConfigs(array2);
/* 333 */     table2.add((Actor)pieChartActor2).size(f1, f1).row();
/*     */     
/*     */     Label label1;
/*     */     
/* 337 */     (label1 = new Label(Game.i.localeManager.i18n.get("damage_by_tower"), this.m)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 338 */     table2.add((Actor)label1).height(64.0F).padBottom(16.0F).padTop(64.0F).row();
/*     */     
/* 340 */     PieChartActor pieChartActor1 = new PieChartActor();
/* 341 */     Array array1 = new Array(PieChart.ChartEntryConfig.class);
/* 342 */     float f2 = 0.0F; TowerType[] arrayOfTowerType2; int k; byte b3;
/* 343 */     for (k = (arrayOfTowerType2 = TowerType.values).length, b3 = 0; b3 < k; ) { TowerType towerType = arrayOfTowerType2[b3];
/* 344 */       StatisticsType statisticsType = Game.i.towerManager.getDamageDealtStatisticType(towerType);
/*     */       float f;
/* 346 */       if ((f = paramIntFloatMap.get(statisticsType.ordinal(), 0.0F)) > 0.0F) {
/*     */         
/* 348 */         f2 += f;
/*     */         
/* 350 */         array1.add(new PieChart.ChartEntryConfig(Game.i.towerManager
/* 351 */               .getFactory(towerType).getColor(), f, 0.0F));
/*     */       } 
/*     */       
/*     */       b3++; }
/*     */     
/* 356 */     if (f2 == 0.0F) {
/* 357 */       array1.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 100.0F, 0.0F));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     pieChartActor1.setConfigs(array1);
/* 364 */     table2.add((Actor)pieChartActor1).size(f1, f1).row();
/*     */   }
/*     */   
/*     */   private static void a(Table paramTable) {
/*     */     Image image;
/* 369 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 370 */     paramTable.add((Actor)image).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Table paramTable, IntFloatMap paramIntFloatMap) {
/* 380 */     boolean bool = Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.EXTENDED_STATISTICS);
/*     */     
/*     */     Label label5;
/*     */     
/* 384 */     (label5 = new Label(Game.i.localeManager.i18n.get("towers"), Game.i.assetManager.getLabelStyle(36))).setAlignment(8);
/* 385 */     label5.setColor(MaterialColor.AMBER.P500);
/* 386 */     paramTable.add((Actor)label5).height(48.0F).colspan(2).fillX();
/*     */     
/* 388 */     if (bool) {
/*     */       Image image;
/* 390 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 391 */       paramTable.add((Actor)image).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */       
/*     */       Label label;
/* 394 */       (label = new Label(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-damage>/<@icon-coin>"), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 395 */       paramTable.add((Actor)label).height(48.0F).right();
/*     */     } 
/*     */     
/*     */     Image image4;
/* 399 */     (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 400 */     paramTable.add((Actor)image4).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */     
/*     */     Label label4;
/* 403 */     (label4 = new Label(Game.i.localeManager.i18n.get("built"), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 404 */     paramTable.add((Actor)label4).height(48.0F).right();
/*     */     
/*     */     Image image3;
/* 407 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 408 */     paramTable.add((Actor)image3).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */     
/*     */     Label label3;
/* 411 */     (label3 = new Label(Game.i.localeManager.i18n.get("statistics_money_spent"), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 412 */     paramTable.add((Actor)label3).height(48.0F).right();
/*     */     
/*     */     Image image2;
/* 415 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 416 */     paramTable.add((Actor)image2).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */     
/*     */     Label label2;
/* 419 */     (label2 = new Label(Game.i.localeManager.i18n.get("damage"), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 420 */     paramTable.add((Actor)label2).height(48.0F).right();
/*     */     
/*     */     Image image1;
/* 423 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 424 */     paramTable.add((Actor)image1).width(2.0F).fillY().padLeft(16.0F).padRight(16.0F);
/*     */     
/*     */     Label label1;
/* 427 */     (label1 = new Label(Game.i.localeManager.i18n.get("kills"), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 428 */     paramTable.add((Actor)label1).height(48.0F).padRight(16.0F).right();
/*     */     
/* 430 */     paramTable.row(); TowerType[] arrayOfTowerType;
/*     */     int i;
/*     */     byte b;
/* 433 */     for (i = (arrayOfTowerType = TowerType.values).length, b = 0; b < i; ) { TowerType towerType = arrayOfTowerType[b];
/* 434 */       StatisticsType statisticsType = Game.i.towerManager.getMoneySpentStatisticType(towerType);
/* 435 */       if (paramIntFloatMap.get(statisticsType.ordinal(), 0.0F) != 0.0F) {
/*     */         Image image;
/*     */         
/* 438 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.07F);
/* 439 */         paramTable.add((Actor)image).fillX().height(2.0F).colspan(bool ? 12 : 10).row();
/*     */         
/* 441 */         StatisticsType statisticsType1 = Game.i.towerManager.getBuiltStatisticType(towerType);
/* 442 */         StatisticsType statisticsType2 = Game.i.towerManager.getDamageDealtStatisticType(towerType);
/* 443 */         StatisticsType statisticsType3 = Game.i.towerManager.getEnemiesKilledStatisticsType(towerType);
/*     */         
/* 445 */         Tower.Factory factory = Game.i.towerManager.getFactory(towerType);
/*     */         
/* 447 */         Actor actor = Game.i.towerManager.getFactory(towerType).createIconActor(48.0F);
/* 448 */         paramTable.add(actor).height(48.0F).width(48.0F);
/*     */         
/* 450 */         Color color = factory.getColor().cpy().lerp(Color.WHITE, 0.28F);
/* 451 */         String str = factory.getTitle();
/*     */         Label label7;
/* 453 */         (label7 = new Label(Game.i.assetManager.replaceRegionAliasesWithChars(str), this.m)).setColor(color);
/* 454 */         paramTable.add((Actor)label7).height(48.0F).growX().padLeft(8.0F);
/*     */         
/* 456 */         a(paramTable);
/*     */         
/* 458 */         if (bool) {
/*     */           
/* 460 */           (label7 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((long)(paramIntFloatMap.get(statisticsType2.ordinal(), 0.0F) / paramIntFloatMap.get(statisticsType.ordinal(), 0.0F))), this.m)).setColor(color);
/* 461 */           label7.setAlignment(16);
/* 462 */           paramTable.add((Actor)label7).height(48.0F).growX().right();
/*     */           
/* 464 */           a(paramTable);
/*     */         } 
/*     */ 
/*     */         
/* 468 */         (label7 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((long)paramIntFloatMap.get(statisticsType1.ordinal(), 0.0F)), this.m)).setColor(color);
/* 469 */         label7.setAlignment(16);
/* 470 */         paramTable.add((Actor)label7).height(48.0F).growX().right();
/*     */         
/* 472 */         a(paramTable);
/*     */         
/*     */         Label label6;
/* 475 */         (label6 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((long)paramIntFloatMap.get(statisticsType.ordinal(), 0.0F)), this.m)).setColor(color);
/* 476 */         label6.setAlignment(16);
/* 477 */         paramTable.add((Actor)label6).height(48.0F).growX().right();
/*     */         
/* 479 */         a(paramTable);
/*     */ 
/*     */         
/* 482 */         (label6 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((long)paramIntFloatMap.get(statisticsType2.ordinal(), 0.0F)), this.m)).setColor(color);
/* 483 */         label6.setAlignment(16);
/* 484 */         paramTable.add((Actor)label6).height(48.0F).growX().right();
/*     */         
/* 486 */         a(paramTable);
/*     */ 
/*     */         
/* 489 */         (label6 = new Label((CharSequence)StringFormatter.commaSeparatedNumber((long)paramIntFloatMap.get(statisticsType3.ordinal(), 0.0F)), this.m)).setColor(color);
/* 490 */         label6.setAlignment(16);
/* 491 */         paramTable.add((Actor)label6).height(48.0F).growX().right().padRight(16.0F);
/*     */         
/* 493 */         paramTable.row();
/*     */       }  b++; }
/*     */      } private void a() { Table table1; IntFloatMap intFloatMap1; byte b1; Drawable drawable1; IntFloatMap intFloatMap2; FancyButton fancyButton1; StatisticsType[] arrayOfStatisticsType1; Table table3; AchievementType[] arrayOfAchievementType2; Table table2; AchievementType[] arrayOfAchievementType1; StatisticsType[] arrayOfStatisticsType2; Table table6; Runnable runnable; int k; Table table5; int j; Table table4; int i, m; Table table9; Label label2; Table table8; byte b3; Table table7; byte b2; Label label1; Drawable drawable2; byte b5; FancyButton fancyButton2; Label label3; byte b4;
/*     */     Table table10;
/*     */     ComplexButton complexButton;
/*     */     Color color;
/* 499 */     this.i.clear();
/*     */     
/* 501 */     this.d.setEnabled(true);
/* 502 */     this.e.setEnabled(true);
/* 503 */     this.f.setEnabled(true);
/* 504 */     this.h.setEnabled(true);
/* 505 */     this.g.setEnabled(true);
/*     */     
/* 507 */     switch (null.a[this.k.ordinal()]) {
/*     */       case 1:
/* 509 */         this.d.setEnabled(false);
/*     */ 
/*     */         
/* 512 */         table1 = new Table();
/* 513 */         this.i.add((Actor)table1).width(600.0F).padRight(40.0F);
/*     */         
/* 515 */         intFloatMap2 = new IntFloatMap();
/* 516 */         for (m = (arrayOfStatisticsType2 = StatisticsType.values).length, b5 = 0; b5 < m; ) { StatisticsType statisticsType = arrayOfStatisticsType2[b5];
/* 517 */           intFloatMap2.put(statisticsType.ordinal(), (float)Game.i.statisticsManager.getAllTime(statisticsType)); b5++; }
/*     */         
/* 519 */         a(table1, intFloatMap2);
/*     */ 
/*     */         
/* 522 */         table6 = new Table();
/* 523 */         this.i.add((Actor)table6).top().fillX().expandX().minHeight(100.0F).row();
/*     */         
/* 525 */         b(table6, intFloatMap2);
/*     */ 
/*     */         
/* 528 */         table9 = new Table();
/* 529 */         this.i.add((Actor)table9).expandX().fillX().colspan(2).padTop(8.0F).row();
/*     */         
/* 531 */         c(table9, intFloatMap2);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 2:
/* 536 */         this.e.setEnabled(false);
/*     */         
/* 538 */         if (this.l == null) {
/*     */           Array array1;
/*     */           
/* 541 */           if ((array1 = Game.i.replayManager.getAllRecordIds()).size == 0) {
/* 542 */             this.i.add((Actor)new Label(Game.i.localeManager.i18n.get("no_replays_found"), Game.i.assetManager.getLabelStyle(30))).row();
/*     */             break;
/*     */           } 
/* 545 */           Array array2 = new Array(); byte b;
/* 546 */           for (b = 0; b < array1.size; b++) {
/*     */             ReplayManager.ReplayRecord replayRecord;
/* 548 */             if ((replayRecord = Game.i.replayManager.getRecord((String)array1.get(b))) != null) {
/* 549 */               array2.add(replayRecord);
/*     */             }
/*     */           } 
/* 552 */           array2.sort((paramReplayRecord1, paramReplayRecord2) -> (paramReplayRecord1.startTimestamp == paramReplayRecord2.startTimestamp) ? 0 : ((paramReplayRecord1.startTimestamp < paramReplayRecord2.startTimestamp) ? 1 : -1));
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 557 */           for (b = 0; b < array2.size; b++) {
/* 558 */             ReplayManager.ReplayRecord replayRecord = (ReplayManager.ReplayRecord)array2.get(b);
/*     */             
/*     */             Table table;
/* 561 */             (table = new Table()).setBackground(this.n);
/*     */             
/* 563 */             o.setLength(0);
/* 564 */             if (GameStateSystem.GameMode.isBasicLevel(replayRecord.gameMode)) {
/* 565 */               o.append(Game.i.localeManager.i18n.get("level")).append(" ").append(replayRecord.levelName);
/*     */             } else {
/* 567 */               o.append(Game.i.localeManager.i18n.get("custom_map"));
/*     */             } 
/*     */             
/* 570 */             o.append(", ").append(Game.i.localeManager.i18n.get("defeated").toLowerCase(Locale.ENGLISH))
/* 571 */               .append(" ").append(replayRecord.defeatedWaves).append(" ")
/* 572 */               .append(Game.i.localeManager.i18n.get("waves"));
/*     */             
/* 574 */             o.append(" [#888888FF]- ").append(Game.i.progressManager.getDifficultyName(replayRecord.difficultyMode)).append("[]");
/*     */             
/* 576 */             LabelButton labelButton = new LabelButton((CharSequence)o, this.m, () -> {
/*     */                   this.l = paramReplayRecord;
/*     */                   a();
/*     */                 });
/* 580 */             table.add((Actor)labelButton).padLeft(16.0F);
/*     */             
/* 582 */             Date date = new Date(replayRecord.startTimestamp);
/* 583 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US);
/*     */             Label label;
/* 585 */             (label = new Label(simpleDateFormat.format(date), this.m)).setAlignment(16);
/* 586 */             table.add((Actor)label).padRight(16.0F).expandX().fillX();
/*     */             
/* 588 */             this.i.add((Actor)table).fillX().expandX().height(64.0F).padBottom(4.0F).row();
/*     */           } 
/*     */           return;
/*     */         } 
/* 592 */         table1 = new Table();
/* 593 */         this.i.add((Actor)table1).left().fillX().padBottom(4.0F).row();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 598 */         fancyButton1 = (new FancyButton("regularButton.a", () -> { this.l = null; a(); })).withLabel(24, Game.i.localeManager.i18n.get("back_to_replays_list"));
/* 599 */         table1.add((Actor)fancyButton1).width(256.0F).colspan(2).height(56.0F).left().row();
/*     */         
/* 601 */         table6 = null;
/*     */         
/* 603 */         if (Game.i.progressManager.isDeveloperModeEnabled()) {
/* 604 */           runnable = (() -> {
/*     */               try {
/*     */                 GameStateSystem.startReplayAsRealRun(this.l, true); return;
/* 607 */               } catch (Exception exception) {
/*     */                 a.e("parsing failed", new Object[] { exception });
/*     */                 
/*     */                 Threads.i().runOnMainThread(());
/*     */                 return;
/*     */               } 
/*     */             });
/*     */         }
/* 615 */         (label2 = new Label(this.l.id, Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 616 */         table1.add((Actor)label2).growX();
/* 617 */         label2.setTouchable(Touchable.enabled);
/* 618 */         label2.addListener((EventListener)new ClickListener(this)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 621 */                 Gdx.app.getClipboard().setContents((StatisticsScreen.a(this.a)).id);
/* 622 */                 Notifications.i().add(Game.i.localeManager.i18n.get("copied_to_clipboard"), null, null, null);
/*     */               }
/*     */             });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 633 */         fancyButton2 = (new FancyButton("regularButton.b", () -> { try { GameStateSystem.startReplay(this.l); return; } catch (Exception exception) { a.e("parsing failed", new Object[] { exception }); Threads.i().runOnMainThread(()); return; }  }runnable)).withLabel(24, "Replay");
/* 634 */         table1.add((Actor)fancyButton2).width(200.0F).height(56.0F).padRight(40.0F).padLeft(16.0F);
/*     */ 
/*     */         
/* 637 */         table10 = new Table();
/* 638 */         this.i.add((Actor)table10).width(600.0F).padRight(40.0F);
/*     */         
/* 640 */         a(table10, this.l.statistics);
/*     */ 
/*     */         
/* 643 */         table1 = new Table();
/* 644 */         this.i.add((Actor)table1).top().fillX().expandX().minHeight(100.0F).row();
/*     */         
/* 646 */         b(table1, this.l.statistics);
/*     */ 
/*     */         
/* 649 */         table8 = new Table();
/* 650 */         this.i.add((Actor)table8).expandX().fillX().colspan(2).padTop(8.0F).row();
/*     */         
/* 652 */         c(table8, this.l.statistics);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 658 */         this.f.setEnabled(false);
/*     */         
/* 660 */         intFloatMap1 = new IntFloatMap();
/* 661 */         for (k = (arrayOfStatisticsType1 = StatisticsType.values).length, b3 = 0; b3 < k; ) { StatisticsType statisticsType = arrayOfStatisticsType1[b3];
/* 662 */           intFloatMap1.put(statisticsType.ordinal(), (float)Game.i.statisticsManager.getMaxOneGame(statisticsType));
/*     */           
/*     */           b3++; }
/*     */         
/* 666 */         table3 = new Table();
/* 667 */         this.i.add((Actor)table3).width(600.0F).padRight(40.0F);
/*     */         
/* 669 */         a(table3, intFloatMap1);
/*     */ 
/*     */         
/* 672 */         table5 = new Table();
/* 673 */         this.i.add((Actor)table5).top().fillX().expandX().minHeight(100.0F).row();
/*     */         
/* 675 */         b(table5, intFloatMap1);
/*     */ 
/*     */         
/* 678 */         table7 = new Table();
/* 679 */         this.i.add((Actor)table7).expandX().fillX().colspan(2).padTop(8.0F).row();
/*     */         
/* 681 */         c(table7, intFloatMap1);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 686 */         this.g.setEnabled(false);
/*     */         
/* 688 */         b1 = 0;
/* 689 */         for (j = (arrayOfAchievementType2 = AchievementType.values).length, b2 = 0; b2 < j; ) { AchievementType achievementType = arrayOfAchievementType2[b2];
/* 690 */           if (Game.i.achievementManager.isRequirementMet(achievementType)) {
/* 691 */             b1++;
/*     */           }
/*     */           b2++; }
/*     */         
/* 695 */         table2 = new Table();
/*     */         
/* 697 */         table4 = new Table();
/* 698 */         table2.add((Actor)table4).expandX().fillX().top().left();
/*     */         
/* 700 */         label1 = new Label(Game.i.localeManager.i18n.get("achievements") + " [#8BC34A]" + b1 + " / " + AchievementType.values.length + "[]", Game.i.assetManager.getLabelStyle(36));
/* 701 */         table4.add((Actor)label1).top().left().expandX().row();
/*     */ 
/*     */         
/* 704 */         (label3 = new Label(Game.i.localeManager.i18n.get("achievements_screen_hint"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 705 */         table4.add((Actor)label3).top().left().expandX().padBottom(15.0F).row();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 710 */         (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("do_synchronize"), Game.i.assetManager.getLabelStyle(30), () -> Game.i.achievementManager.syncAchievementsWithPlatform())).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-restart"), 128.0F, 8.0F, 48.0F, 48.0F);
/* 711 */         complexButton.setLabel(0.0F, 0.0F, 120.0F, 64.0F, 16);
/* 712 */         complexButton.setIconLabelColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P300, MaterialColor.LIGHT_GREEN.P700, MaterialColor.GREY.P500);
/* 713 */         table2.add((Actor)complexButton).top().right().width(192.0F).height(64.0F);
/*     */         
/* 715 */         this.i.add((Actor)table2).expandX().fillX().row();
/*     */         
/* 717 */         drawable1 = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 718 */         drawable2 = Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_GREEN.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.1F));
/* 719 */         color = new Color(1.0F, 1.0F, 1.0F, 0.14F);
/* 720 */         for (i = (arrayOfAchievementType1 = AchievementType.values).length, b4 = 0; b4 < i; ) { AchievementType achievementType = arrayOfAchievementType1[b4];
/* 721 */           Table table11 = new Table();
/* 722 */           if (Game.i.achievementManager.isRequirementMet(achievementType)) {
/* 723 */             table11.setBackground(drawable2);
/*     */           } else {
/* 725 */             table11.setBackground(drawable1);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           ComplexButton complexButton1;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 737 */           (complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { if (!Game.i.achievementManager.isRedeemed(paramAchievementType)) { Game.i.achievementManager.redeem(paramAchievementType); this.j.setVisible((Game.i.achievementManager.countAchievementsToRedeem() > 0)); a(); }  })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 80.0F, 90.0F, 80.0F, 80.0F, 0.0F })), 0.0F, 0.0F, 90.0F, 80.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 743 */           complexButton1.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P900, MaterialColor.LIGHT_GREEN.P700, color);
/* 744 */           complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-gift"), 20.0F, 16.0F, 48.0F, 48.0F);
/* 745 */           if (!Game.i.achievementManager.isRequirementMet(achievementType)) {
/* 746 */             complexButton1.setVisible(false);
/*     */           }
/* 748 */           else if (Game.i.achievementManager.isRedeemed(achievementType)) {
/* 749 */             complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-check"), 20.0F, 16.0F, 48.0F, 48.0F);
/* 750 */             complexButton1.setEnabled(false);
/*     */           } 
/*     */           
/* 753 */           table11.add((Actor)complexButton1).size(90.0F, 80.0F);
/*     */           
/* 755 */           Table table12 = new Table();
/*     */           
/* 757 */           Label label = new Label(Game.i.achievementManager.getName(achievementType), Game.i.assetManager.getLabelStyle(24));
/* 758 */           if (Game.i.achievementManager.isRequirementMet(achievementType)) {
/* 759 */             label.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */           }
/* 761 */           table12.add((Actor)label).top().left().height(25.0F).expandX().padTop(15.0F).row();
/*     */           
/* 763 */           label = new Label("?????", Game.i.assetManager.getLabelStyle(21));
/* 764 */           if (Game.i.achievementManager.isRequirementMet(achievementType) || !(Game.i.achievementManager.configs[achievementType.ordinal()]).hidden) {
/* 765 */             label.setText(Game.i.achievementManager.getDescription(achievementType));
/*     */           }
/* 767 */           label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 768 */           table12.add((Actor)label).padTop(5.0F).height(20.0F).top().left().padBottom(15.0F).row();
/*     */           
/* 770 */           table11.add((Actor)table12).height(80.0F).padLeft(15.0F).expandX().fillX();
/*     */           
/* 772 */           if ((Game.i.achievementManager.configs[achievementType.ordinal()]).required > 1) {
/*     */             Label label4;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 778 */             (label4 = new Label(StringFormatter.commaSeparatedNumber(Game.i.achievementManager.getCurrentProgress(achievementType)) + " / " + StringFormatter.commaSeparatedNumber((Game.i.achievementManager.configs[achievementType.ordinal()]).required), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 779 */             table11.add((Actor)label4).width(200.0F).padRight(15.0F);
/*     */           } else {
/* 781 */             table11.add().height(1.0F).width(200.0F).padRight(15.0F);
/*     */           } 
/*     */           
/* 784 */           this.i.add((Actor)table11).expandX().fillX().padBottom(5.0F).row();
/*     */           b4++; }
/*     */         
/*     */         break;
/*     */     }  }
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
/* 799 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 800 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 801 */     Gdx.gl.glClear(16640);
/*     */     
/* 803 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*     */       
/* 805 */       Game.i.screenManager.goToMainMenu();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resize(int paramInt1, int paramInt2) {
/* 812 */     if (paramInt1 > 0 && paramInt2 > 0) {
/* 813 */       a();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 819 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\StatisticsScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */