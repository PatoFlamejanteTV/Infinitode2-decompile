/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.BasicLevelManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class QuestPrestigeOverlay extends UiManager.UiComponent.Adapter {
/*  24 */   private static final TLog a = TLog.forClass(QuestPrestigeOverlay.class);
/*     */   public static QuestPrestigeOverlay i() {
/*  26 */     return (QuestPrestigeOverlay)Game.i.uiManager.getComponent(QuestPrestigeOverlay.class);
/*     */   }
/*     */   
/*  29 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 175, "QuestPrestigeOverlay overlay");
/*  30 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 176, "QuestPrestigeOverlay main");
/*     */   
/*     */   private final Group d;
/*     */   
/*     */   private Image e;
/*     */   private Label f;
/*     */   private Group g;
/*     */   private Table h;
/*     */   private ComplexButton i;
/*     */   
/*     */   public QuestPrestigeOverlay() {
/*     */     Image image2;
/*  42 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  43 */     (image2.getColor()).a = 0.78F;
/*  44 */     this.b.getTable().add((Actor)image2).expand().fill();
/*  45 */     this.b.getTable().setTouchable(Touchable.enabled);
/*  46 */     this.b.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  49 */             this.a.setVisible(false);
/*     */           }
/*     */         });
/*     */     
/*     */     Group group;
/*  54 */     (group = new Group()).setOrigin(338.0F, 198.0F);
/*  55 */     this.c.getTable().add((Actor)group).size(676.0F, 396.0F);
/*     */     
/*  57 */     this.d = new Group();
/*  58 */     this.d.setOrigin(338.0F, 198.0F);
/*  59 */     this.d.setSize(676.0F, 396.0F);
/*  60 */     group.addActor((Actor)this.d);
/*     */     
/*  62 */     QuadActor quadActor = new QuadActor(new Color(724249599), new float[] { 0.0F, 0.0F, 0.0F, 396.0F, 676.0F, 385.0F, 676.0F, 9.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     this.d.addActor((Actor)quadActor);
/*     */     
/*     */     Label label;
/*     */     
/*  72 */     (label = new Label(Game.i.localeManager.i18n.get("gv_title_PRESTIGE_MODE"), Game.i.assetManager.getLabelStyle(36))).setPosition(40.0F, 325.0F);
/*  73 */     label.setSize(100.0F, 28.0F);
/*  74 */     this.d.addActor((Actor)label);
/*     */ 
/*     */     
/*  77 */     (label = new Label(Game.i.localeManager.i18n.get("quests_prestige_description"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  78 */     label.setSize(100.0F, 16.0F);
/*  79 */     label.setPosition(40.0F, 299.0F);
/*  80 */     this.d.addActor((Actor)label);
/*     */     
/*     */     Image image1;
/*     */     
/*  84 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(560.0F, 16.0F);
/*  85 */     image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  86 */     image1.setPosition(40.0F, 170.0F);
/*  87 */     this.d.addActor((Actor)image1);
/*     */     
/*  89 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  90 */     this.e.setSize(560.0F, 16.0F);
/*  91 */     this.e.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  92 */     this.e.setPosition(40.0F, 170.0F);
/*  93 */     this.d.addActor((Actor)this.e);
/*     */     
/*  95 */     for (byte b = 0; b < 3; b++) {
/*     */       Image image;
/*  97 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(4.0F, 16.0F);
/*  98 */       float f = 177.0F + 141.0F * b;
/*  99 */       if (b == 0) {
/* 100 */         f = 153.0F;
/*     */       }
/* 102 */       image.setPosition(f, 170.0F);
/* 103 */       image.setColor(new Color(724249599));
/* 104 */       this.d.addActor((Actor)image);
/*     */     } 
/*     */     
/* 107 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 108 */     this.f.setPosition(40.0F, 102.0F);
/* 109 */     this.f.setSize(100.0F, 20.0F);
/* 110 */     this.d.addActor((Actor)this.f);
/*     */     
/* 112 */     this.g = new Group();
/* 113 */     this.g.setTransform(false);
/* 114 */     this.g.setSize(495.0F, 66.0F);
/* 115 */     this.g.setPosition(141.0F, 190.0F);
/* 116 */     this.d.addActor((Actor)this.g);
/*     */ 
/*     */     
/* 119 */     this.h = new Table();
/* 120 */     this.h.setPosition(486.0F, 94.0F);
/* 121 */     this.h.setSize(150.0F, 48.0F);
/* 122 */     this.d.addActor((Actor)this.h);
/*     */     
/*     */     ComplexButton complexButton;
/*     */     
/* 126 */     (complexButton = new ComplexButton(Game.i.localeManager.i18n.get("back"), Game.i.assetManager.getLabelStyle(30), () -> setVisible(false))).setSize(255.0F, 93.0F);
/* 127 */     complexButton.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-map-prestige-button-left"), 0.0F, 0.0F, 255.0F, 93.0F);
/* 128 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-left"), 18.0F, 19.0F, 48.0F, 48.0F);
/* 129 */     complexButton.setLabel(77.0F, 30.0F, 100.0F, 23.0F, 8);
/* 130 */     complexButton.setPosition(-13.0F, -9.0F);
/* 131 */     this.d.addActor((Actor)complexButton);
/*     */     
/* 133 */     this.i = new ComplexButton(Game.i.localeManager.i18n.get("quests_reset_button"), Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           String str = Game.i.localeManager.i18n.get("quests_prestige_confirm");
/*     */ 
/*     */           
/*     */           Dialog.i().showConfirm(str, ());
/*     */         });
/*     */     
/* 140 */     this.i.setSize(247.0F, 93.0F);
/* 141 */     this.i.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-map-prestige-button-right"), 0.0F, 0.0F, 247.0F, 93.0F);
/* 142 */     this.i.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-dollar"), 21.0F, 19.0F, 48.0F, 48.0F);
/* 143 */     this.i.setLabel(80.0F, 30.0F, 100.0F, 23.0F, 8);
/* 144 */     this.i.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, MaterialColor.GREY.P800);
/* 145 */     this.i.setPosition(443.0F, -9.0F);
/* 146 */     this.d.addActor((Actor)this.i);
/*     */ 
/*     */ 
/*     */     
/* 150 */     this.b.getTable().setVisible(false);
/* 151 */     this.c.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void show() {
/* 155 */     int i = Game.i.basicLevelManager.getPrestigeMaxCompletedQuests();
/*     */     
/*     */     int j;
/*     */     double d;
/* 159 */     int m = (int)((d = (j = Game.i.basicLevelManager.getPrestigeCompletedQuests()) / i) * 100.0D + 1.0E-4D);
/*     */ 
/*     */     
/* 162 */     this.e.setSize((float)(d * 560.0D), 16.0F);
/* 163 */     a.i("completed " + j + "/" + i + " (" + m + "%)", new Object[0]);
/*     */     
/* 165 */     this.g.clear();
/* 166 */     int k = 0;
/* 167 */     BasicLevelManager.QuestsPrestigeMilestone[] arrayOfQuestsPrestigeMilestone = Game.i.basicLevelManager.getQuestsPrestigeMilestones();
/* 168 */     for (byte b = 0; b < arrayOfQuestsPrestigeMilestone.length; b++) {
/* 169 */       BasicLevelManager.QuestsPrestigeMilestone questsPrestigeMilestone = arrayOfQuestsPrestigeMilestone[b];
/*     */       
/* 171 */       float f = 141.0F * b;
/* 172 */       if (b == 0) {
/* 173 */         f = -24.0F;
/*     */       }
/*     */       Image image2;
/* 176 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-quests-prestige-milestone-mark"))).setPosition(f, 0.0F);
/* 177 */       image2.setSize(74.0F, 66.0F);
/* 178 */       this.g.addActor((Actor)image2);
/*     */       
/*     */       Table table;
/* 181 */       (table = new Table()).setSize(74.0F, 40.0F);
/* 182 */       table.setPosition(f, 14.0F);
/* 183 */       this.g.addActor((Actor)table);
/*     */       
/* 185 */       Image image1 = new Image((Drawable)Game.i.assetManager.getDrawable("prestige-token"));
/* 186 */       table.add((Actor)image1).size(24.0F);
/*     */       
/* 188 */       Label label1 = new Label(questsPrestigeMilestone.tokensCount, Game.i.assetManager.getLabelStyle(21));
/* 189 */       table.add((Actor)label1).padLeft(4.0F).row();
/*     */       
/* 191 */       Label label2 = new Label(questsPrestigeMilestone.percentage + "%", Game.i.assetManager.getLabelStyle(21));
/* 192 */       table.add((Actor)label2).colspan(2);
/*     */       
/* 194 */       if (m >= questsPrestigeMilestone.percentage) {
/*     */         
/* 196 */         label1.setColor(Color.WHITE);
/* 197 */         image2.setColor(MaterialColor.LIGHT_BLUE.P800.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/* 198 */         k = questsPrestigeMilestone.tokensCount;
/*     */       } else {
/* 200 */         label1.setColor(MaterialColor.LIGHT_BLUE.P300);
/* 201 */         image2.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     String str = Game.i.localeManager.i18n.get("quests_prestige_quests_completed") + ": [#4FC3F7]" + StringFormatter.commaSeparatedNumber(j) + " / " + StringFormatter.commaSeparatedNumber(i) + "[] (" + m + "%)";
/* 209 */     this.f.setText(str);
/*     */ 
/*     */     
/* 212 */     this.h.clear();
/* 213 */     this.h.add().height(1.0F).expandX().fillX();
/* 214 */     Image image = new Image((Drawable)Game.i.assetManager.getDrawable("prestige-token"));
/* 215 */     this.h.add((Actor)image).size(48.0F);
/*     */     
/*     */     Label label;
/* 218 */     (label = new Label(k, Game.i.assetManager.getLabelStyle(36))).setColor(MaterialColor.LIGHT_BLUE.P300);
/* 219 */     this.h.add((Actor)label).padLeft(8.0F);
/*     */ 
/*     */     
/* 222 */     boolean bool = (k > 0) ? true : false;
/* 223 */     this.i.setEnabled(bool);
/*     */     
/* 225 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 229 */     if (paramBoolean) {
/* 230 */       UiUtils.bouncyShowOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d); return;
/*     */     } 
/* 232 */     UiUtils.bouncyHideOverlay((Actor)this.b.getTable(), (Actor)this.c.getTable(), this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 238 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\QuestPrestigeOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */