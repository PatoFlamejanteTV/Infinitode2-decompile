/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.DailyQuestManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public class DailyLootOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static DailyLootOverlay i() {
/*  28 */     return (DailyLootOverlay)Game.i.uiManager.getComponent(DailyLootOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  33 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 150, "DailyLootOverlay main");
/*     */   
/*     */   private final Label b;
/*     */   
/*     */   private final ScrollPane c;
/*     */   
/*     */   private final Group d;
/*     */   
/*     */   private final Table e;
/*     */   private final Table f;
/*     */   private final Label g;
/*     */   private final Label h;
/*     */   private final Label i;
/*     */   private final Image j;
/*     */   private final Label k;
/*     */   private final Label l;
/*     */   private final ComplexButton m;
/*     */   private float n;
/*     */   private boolean o;
/*  52 */   private static final StringBuilder p = new StringBuilder();
/*     */ 
/*     */   
/*     */   public DailyLootOverlay() {
/*     */     Group group;
/*  57 */     (group = new Group()).setTransform(false);
/*  58 */     group.setOrigin(488.0F, 435.5F);
/*  59 */     this.a.getTable().add((Actor)group).size(976.0F, 871.0F);
/*     */     
/*  61 */     this.d = new Group();
/*  62 */     this.d.setOrigin(488.0F, 435.5F);
/*  63 */     group.addActor((Actor)this.d);
/*     */     
/*  65 */     QuadActor quadActor2 = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 871.0F, 976.0F, 858.0F, 976.0F, 13.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     this.d.addActor((Actor)quadActor2);
/*     */     
/*  73 */     this.e = new Table();
/*  74 */     this.c = new ScrollPane((Actor)this.e, Game.i.assetManager.getScrollPaneStyle(16.0F));
/*  75 */     UiUtils.enableMouseMoveScrollFocus(this.c);
/*  76 */     this.c.setPosition(0.0F, 175.0F);
/*  77 */     this.c.setSize(976.0F, 654.0F);
/*  78 */     this.d.addActor((Actor)this.c);
/*     */     
/*     */     Image image2;
/*  81 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(new Color(724249599));
/*  82 */     image2.setSize(976.0F, 64.0F);
/*  83 */     image2.setPosition(0.0F, 766.0F);
/*  84 */     image2.setTouchable(Touchable.disabled);
/*  85 */     this.d.addActor((Actor)image2);
/*     */     
/*  87 */     this.b = new Label("", Game.i.assetManager.getLabelStyle(36));
/*  88 */     this.b.setSize(100.0F, 29.0F);
/*  89 */     this.b.setPosition(40.0F, 800.0F);
/*  90 */     this.d.addActor((Actor)this.b);
/*     */     
/*  92 */     this.f = new Table();
/*  93 */     this.f.setSize(294.0F, 64.0F);
/*  94 */     this.f.setPosition(642.0F, 765.0F);
/*  95 */     this.d.addActor((Actor)this.f);
/*     */ 
/*     */     
/*  98 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  99 */     image2.setSize(976.0F, 12.0F);
/* 100 */     image2.setPosition(0.0F, 175.0F);
/* 101 */     image2.setTouchable(Touchable.disabled);
/* 102 */     this.d.addActor((Actor)image2);
/*     */ 
/*     */     
/* 105 */     QuadActor quadActor1 = new QuadActor(new Color(858993663), new float[] { 0.0F, 0.0F, 0.0F, 175.0F, 976.0F, 175.0F, 976.0F, 13.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     this.d.addActor((Actor)quadActor1);
/*     */     
/* 113 */     this.g = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 114 */     this.g.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 115 */     this.g.setSize(100.0F, 22.0F);
/* 116 */     this.g.setPosition(40.0F, 127.0F);
/* 117 */     this.d.addActor((Actor)this.g);
/*     */     
/* 119 */     this.h = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 120 */     this.h.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 121 */     this.h.setSize(100.0F, 22.0F);
/* 122 */     this.h.setPosition(40.0F, 99.0F);
/* 123 */     this.d.addActor((Actor)this.h);
/*     */     
/* 125 */     this.i = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 126 */     this.i.setSize(100.0F, 22.0F);
/* 127 */     this.i.setPosition(836.0F, 127.0F);
/* 128 */     this.i.setAlignment(16);
/* 129 */     this.d.addActor((Actor)this.i);
/*     */     
/*     */     Image image1;
/* 132 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("checkbox"))).setSize(48.0F, 48.0F);
/* 133 */     image1.setPosition(34.0F, 35.0F);
/* 134 */     this.d.addActor((Actor)image1);
/*     */     
/* 136 */     this.j = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 137 */     this.j.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 138 */     this.j.setSize(32.0F, 32.0F);
/* 139 */     this.j.setPosition(44.0F, 49.0F);
/* 140 */     this.d.addActor((Actor)this.j);
/*     */     
/* 142 */     this.k = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 143 */     this.k.setSize(100.0F, 18.0F);
/* 144 */     this.k.setPosition(95.0F, 63.0F);
/* 145 */     this.d.addActor((Actor)this.k);
/*     */     
/* 147 */     this.l = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 148 */     this.l.setSize(100.0F, 18.0F);
/* 149 */     this.l.setPosition(95.0F, 36.0F);
/* 150 */     this.l.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 151 */     this.d.addActor((Actor)this.l);
/*     */     
/* 153 */     this.m = new ComplexButton(Game.i.localeManager.i18n.get("play"), Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           String str;
/*     */           
/*     */           if ((str = Game.i.dailyQuestManager.getDailyLootCurrentQuest()).equals("_resetQuests")) {
/*     */             QuestPrestigeOverlay.i().show();
/*     */             setVisible(false);
/*     */             return;
/*     */           } 
/*     */           BasicLevelQuestConfig basicLevelQuestConfig = Game.i.basicLevelManager.getRegularQuestById(str);
/*     */           Game.i.screenManager.goToLevelSelectScreenShowLevel(basicLevelQuestConfig.level);
/*     */         });
/* 164 */     this.m.setPosition(743.0F, 21.0F);
/* 165 */     this.m.setSize(247.0F, 93.0F);
/* 166 */     this.m.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-map-prestige-button-right"), 0.0F, 0.0F, 247.0F, 93.0F);
/* 167 */     this.m.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-joystick"), 21.0F, 19.0F, 48.0F, 48.0F);
/* 168 */     this.m.setLabel(80.0F, 30.0F, 100.0F, 23.0F, 8);
/* 169 */     this.d.addActor((Actor)this.m);
/*     */     
/* 171 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void show() {
/* 175 */     this.b.setText(Game.i.localeManager.i18n.get("daily_loot"));
/* 176 */     this.h.setText(Game.i.localeManager.i18n.get("daily_loot_hint"));
/*     */     
/* 178 */     this.f.clear();
/* 179 */     int i = Game.i.dailyQuestManager.getDailyLootCurrentMonthIndex();
/* 180 */     int j = Game.i.dailyQuestManager.getDailyLootCurrentDayIndex();
/*     */     Label label;
/* 182 */     (label = new Label(Game.i.localeManager.i18n.get("month") + ": " + (i + 1), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/* 183 */     this.f.add((Actor)label).top().right().expandX().fillX().row();
/*     */     
/* 185 */     int k = Game.i.dailyQuestManager.dailyLootMinBonusPerMonth * i;
/*     */     int m;
/* 187 */     if ((m = Game.i.dailyQuestManager.dailyLootMaxBonusPerMonth * i) > 0) {
/*     */       Label label1;
/* 189 */       (label1 = new Label("[#888888]" + Game.i.localeManager.i18n.get("bonus") + ": [][#8BC34A]+" + k + " - " + m + "%[]", Game.i.assetManager.getLabelStyle(21))).setAlignment(16);
/* 190 */       this.f.add((Actor)label1).top().right().row();
/*     */     } 
/* 192 */     if (Game.i.progressManager.isDoubleGainEnabled()) {
/*     */       Label label1;
/* 194 */       (label1 = new Label("[#FFC107]" + Game.i.localeManager.i18n.get("double_gain_title") + ": x2[]", Game.i.assetManager.getLabelStyle(21))).setAlignment(16);
/* 195 */       this.f.add((Actor)label1).top().right().row();
/*     */     } 
/*     */ 
/*     */     
/* 199 */     this.e.clear();
/* 200 */     this.e.add().width(1.0F).height(32.0F).row();
/*     */     
/* 202 */     for (m = i; m <= i + 1; m++) {
/* 203 */       Table table2 = new Table();
/* 204 */       this.e.add((Actor)table2).expandX().fillX().padTop(16.0F).padBottom(8.0F).row();
/*     */       Label label1;
/* 206 */       (label1 = new Label(Game.i.localeManager.i18n.get("month") + " " + (m + 1), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 207 */       table2.add((Actor)label1).padLeft(40.0F);
/* 208 */       if (m != 0) {
/*     */         
/* 210 */         (label1 = new Label(Game.i.localeManager.i18n.get("bonus") + ": +" + (Game.i.dailyQuestManager.dailyLootMinBonusPerMonth * m) + "-" + (Game.i.dailyQuestManager.dailyLootMaxBonusPerMonth * m) + "%", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 211 */         table2.add((Actor)label1).padLeft(16.0F);
/*     */       } 
/* 213 */       table2.add().height(1.0F).expandX().fillX();
/*     */       
/* 215 */       Table table1 = new Table();
/* 216 */       for (byte b = 0; b < Game.i.dailyQuestManager.dailyLootDayConfigs.size; b++) {
/* 217 */         DailyQuestManager.DailyLootDayConfig dailyLootDayConfig = ((DailyQuestManager.DailyLootDayConfig[])Game.i.dailyQuestManager.dailyLootDayConfigs.items)[b];
/*     */         
/* 219 */         if (b % 7 == 0) {
/* 220 */           table1.row();
/*     */         }
/*     */         
/*     */         Group group;
/* 224 */         (group = new Group()).setTransform(false);
/* 225 */         table1.add((Actor)group).size(128.0F, 140.0F);
/*     */         
/* 227 */         ItemCell itemCell = new ItemCell();
/* 228 */         int n = dailyLootDayConfig.getCount(m);
/* 229 */         itemCell.setItem(dailyLootDayConfig.item, n);
/* 230 */         itemCell.setColRow(b % 7, b / 7);
/* 231 */         int i1 = m * Game.i.dailyQuestManager.dailyLootDayConfigs.size + b;
/* 232 */         itemCell.setCornerText(i1 + 1);
/* 233 */         boolean bool = false;
/* 234 */         if (i1 < j)
/*     */         {
/* 236 */           bool = true;
/*     */         }
/* 238 */         itemCell.addListener((EventListener)new ClickListener(this, dailyLootDayConfig, n)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 241 */                 ItemDescriptionDialog.i().showWithCount(this.a.item, this.b);
/*     */               }
/*     */             });
/* 244 */         if (j == i1) {
/*     */           
/* 246 */           if (Game.i.dailyQuestManager.isTodayDailyLootQuestCompleted()) {
/* 247 */             bool = true;
/*     */           }
/*     */           
/* 250 */           itemCell.setSelected(true);
/*     */         } 
/* 252 */         group.addActor((Actor)itemCell);
/*     */         
/* 254 */         if (bool) {
/* 255 */           Image image = new Image();
/* 256 */           if ((b % 7 + b / 7) % 2 == 0) {
/* 257 */             image.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-a"));
/*     */           } else {
/* 259 */             image.setDrawable((Drawable)Game.i.assetManager.getDrawable("item-cell-b"));
/*     */           } 
/* 261 */           image.setSize(128.0F, 140.0F);
/* 262 */           image.setColor(0.05F, 0.05F, 0.05F, 0.56F);
/* 263 */           group.addActor((Actor)image);
/*     */ 
/*     */           
/* 266 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 267 */           image.setSize(64.0F, 64.0F);
/* 268 */           image.setPosition(32.0F, 38.0F);
/* 269 */           group.addActor((Actor)image);
/*     */         } 
/*     */       } 
/* 272 */       this.e.add((Actor)table1).row();
/*     */     } 
/* 274 */     this.e.add().width(1.0F).height(104.0F).row();
/*     */ 
/*     */     
/* 277 */     this.g.setText(Game.i.localeManager.i18n.format("daily_loot_current_day_title", new Object[] { Integer.valueOf(j + 1) }));
/*     */     
/*     */     String str;
/* 280 */     if ((str = Game.i.dailyQuestManager.getDailyLootCurrentQuest()).equals("_resetQuests")) {
/*     */       
/* 282 */       this.l.setText("");
/* 283 */       this.k.setText(Game.i.localeManager.i18n.get("daily_loot_quest_reset_quests"));
/*     */     } else {
/*     */       
/* 286 */       BasicLevelQuestConfig basicLevelQuestConfig = Game.i.basicLevelManager.getRegularQuestById(str);
/* 287 */       this.l.setText(Game.i.localeManager.i18n.get("level") + ": " + basicLevelQuestConfig.level.name);
/* 288 */       p.setLength(0);
/* 289 */       p.append(basicLevelQuestConfig.getTitle(true, true));
/* 290 */       if (basicLevelQuestConfig.getRequiredValue(Game.i.gameValueManager.getSnapshot()) > 1L) {
/* 291 */         p.append(": [#8BC34A]").append(basicLevelQuestConfig.formatValueForUi(basicLevelQuestConfig.getRequiredValue(Game.i.gameValueManager.getSnapshot()))).append("[]");
/*     */       }
/* 293 */       this.k.setText((CharSequence)p);
/*     */     } 
/* 295 */     this.j.setVisible(Game.i.dailyQuestManager.isTodayDailyLootQuestCompleted());
/*     */     
/* 297 */     if (Game.i.dailyQuestManager.isTodayDailyLootQuestCompleted()) {
/* 298 */       this.m.setVisible(false);
/*     */     } else {
/* 300 */       this.m.setVisible(true);
/* 301 */       if (str.equals("_resetQuests")) {
/* 302 */         this.m.setText(Game.i.localeManager.i18n.get("quests_reset_button"));
/* 303 */         this.m.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/*     */       } else {
/* 305 */         this.m.setText(Game.i.localeManager.i18n.get("play"));
/* 306 */         this.m.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-joystick"));
/*     */       } 
/*     */     } 
/*     */     
/* 310 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 314 */     if (paramBoolean) {
/* 315 */       DarkOverlay.i().addCallerOverlayLayer("DailyLootOverlay", this.a.zIndex - 1, () -> {
/*     */             setVisible(false);
/*     */             return true;
/*     */           });
/* 319 */       UiUtils.bouncyShowOverlay(null, (Actor)this.a.getTable(), this.d);
/* 320 */       Game.i.uiManager.stage.setScrollFocus((Actor)this.c);
/*     */     } else {
/* 322 */       DarkOverlay.i().removeCaller("DailyLootOverlay");
/* 323 */       UiUtils.bouncyHideOverlay(null, (Actor)this.a.getTable(), this.d);
/*     */     } 
/*     */     
/* 326 */     this.o = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 331 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRender(float paramFloat) {
/* 336 */     if (this.o) {
/* 337 */       this.n += paramFloat;
/* 338 */       if (this.n >= 1.0F) {
/* 339 */         this.n--;
/*     */         
/* 341 */         p.setLength(0);
/* 342 */         p.append("[#888888]").append(Game.i.localeManager.i18n.get("daily_loot_next_in")).append("[] ");
/* 343 */         p.append(StringFormatter.digestTime(Game.i.dailyQuestManager.getSecondsTillNextDailyLoot()));
/* 344 */         this.i.setText((CharSequence)p);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\DailyLootOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */