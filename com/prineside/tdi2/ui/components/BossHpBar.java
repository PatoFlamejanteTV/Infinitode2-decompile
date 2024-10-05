/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ 
/*     */ public final class BossHpBar extends Group {
/*     */   public static final float WIDTH = 304.0F;
/*     */   public static final float HEIGHT = 52.0F;
/*     */   public static final float MAIN_BAR_WIDTH = 300.0F;
/*     */   public Image backgroundImage;
/*     */   public LabelWithShadow nameLabel;
/*     */   public Image iconImage;
/*     */   public Image iconImageShadow;
/*     */   public Table effectIconsTable;
/*     */   public LabelWithShadow hpLabelCurrent;
/*     */   public LabelWithShadow hpLabelMax;
/*     */   public Group largeBarContainer;
/*     */   
/*     */   public BossHpBar() {
/*  19 */     Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 106, "Tooltip");
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
/*  47 */     this.k = new Array(true, 1, Drawable.class);
/*  48 */     this.l = "Dummy";
/*     */ 
/*     */     
/*  51 */     setTransform(false);
/*     */     
/*  53 */     setSize(304.0F, 52.0F);
/*  54 */     this.backgroundImage = new Image();
/*  55 */     this.backgroundImage.setSize(304.0F, 28.0F);
/*  56 */     addActor((Actor)this.backgroundImage);
/*     */     
/*     */     Table table;
/*     */     
/*  60 */     (table = new Table()).setPosition(26.0F, 30.0F);
/*  61 */     table.setSize(269.0F, 22.0F);
/*  62 */     addActor((Actor)table);
/*     */     
/*  64 */     this
/*  65 */       .nameLabel = (new LabelWithShadow("Dummy", Game.i.assetManager.getLabelStyle(21))).setShadowColor(new Color(0.0F, 0.0F, 0.0F, 1.0F)).setShadowShift(0.0F, -2.0F);
/*  66 */     this.nameLabel.setPosition(26.0F, 34.0F);
/*  67 */     table.add((Actor)this.nameLabel);
/*     */     
/*  69 */     this.effectIconsTable = new Table();
/*  70 */     table.add((Actor)this.effectIconsTable).padLeft(4.0F);
/*     */     
/*  72 */     table.add().height(1.0F).growX();
/*     */     
/*  74 */     this
/*  75 */       .hpLabelCurrent = (new LabelWithShadow("", Game.i.assetManager.getLabelStyle(21))).setShadowColor(new Color(0.0F, 0.0F, 0.0F, 1.0F)).setShadowShift(0.0F, -2.0F);
/*  76 */     table.add((Actor)this.hpLabelCurrent);
/*     */     
/*  78 */     this
/*  79 */       .hpLabelMax = (new LabelWithShadow("", Game.i.assetManager.getLabelStyle(18))).setShadowColor(new Color(0.0F, 0.0F, 0.0F, 1.0F)).setShadowShift(0.0F, -2.0F);
/*  80 */     table.add((Actor)this.hpLabelMax).padLeft(2.0F);
/*     */ 
/*     */     
/*  83 */     this.barBackgroundLarge = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineLargeBg"));
/*  84 */     this.barBackgroundLarge.setPosition(2.0F, 14.0F);
/*  85 */     this.barBackgroundLarge.setSize(300.0F, 12.0F);
/*  86 */     addActor((Actor)this.barBackgroundLarge);
/*     */     
/*  88 */     this.largeBarContainer = (Group)new GroupClipping();
/*  89 */     this.largeBarContainer.setTransform(false);
/*  90 */     this.largeBarContainer.setPosition(2.0F, 14.0F);
/*  91 */     this.largeBarContainer.setSize(300.0F, 12.0F);
/*  92 */     addActor((Actor)this.largeBarContainer);
/*     */     
/*  94 */     this.barLarge = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineLarge"));
/*  95 */     this.barLarge.setSize(300.0F, 12.0F);
/*  96 */     this.largeBarContainer.addActor((Actor)this.barLarge);
/*     */ 
/*     */     
/*  99 */     this.iconImageShadow = new Image();
/* 100 */     this.iconImageShadow.setPosition(-13.0F, 15.0F);
/* 101 */     this.iconImageShadow.setSize(32.0F, 32.0F);
/* 102 */     this.iconImageShadow.setColor(0.0F, 0.0F, 0.0F, 1.0F);
/* 103 */     addActor((Actor)this.iconImageShadow);
/*     */     
/* 105 */     this.iconImage = new Image();
/* 106 */     this.iconImage.setPosition(-15.0F, 17.0F);
/* 107 */     this.iconImage.setSize(32.0F, 32.0F);
/* 108 */     addActor((Actor)this.iconImage);
/*     */ 
/*     */     
/* 111 */     this.barBackgroundSmallOne = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineSmallBg"));
/* 112 */     this.barBackgroundSmallOne.setPosition(6.0F, 8.0F);
/* 113 */     this.barBackgroundSmallOne.setSize(292.0F, 4.0F);
/* 114 */     addActor((Actor)this.barBackgroundSmallOne);
/*     */     
/* 116 */     this.smallBarOneContainer = (Group)new GroupClipping();
/* 117 */     this.smallBarOneContainer.setTransform(false);
/* 118 */     this.smallBarOneContainer.setPosition(6.0F, 8.0F);
/* 119 */     this.smallBarOneContainer.setSize(292.0F, 4.0F);
/* 120 */     addActor((Actor)this.smallBarOneContainer);
/*     */     
/* 122 */     this.barSmallOne = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineSmall"));
/* 123 */     this.barSmallOne.setSize(292.0F, 4.0F);
/* 124 */     this.smallBarOneContainer.addActor((Actor)this.barSmallOne);
/*     */ 
/*     */     
/* 127 */     this.barBackgroundSmallTwo = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineSmallBg"));
/* 128 */     this.barBackgroundSmallTwo.setPosition(8.0F, 2.0F);
/* 129 */     this.barBackgroundSmallTwo.setSize(288.0F, 4.0F);
/* 130 */     addActor((Actor)this.barBackgroundSmallTwo);
/*     */     
/* 132 */     this.smallBarTwoContainer = (Group)new GroupClipping();
/* 133 */     this.smallBarTwoContainer.setTransform(false);
/* 134 */     this.smallBarTwoContainer.setPosition(8.0F, 2.0F);
/* 135 */     this.smallBarTwoContainer.setSize(288.0F, 4.0F);
/* 136 */     addActor((Actor)this.smallBarTwoContainer);
/*     */     
/* 138 */     this.barSmallTwo = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.lineSmall"));
/* 139 */     this.barSmallTwo.setSize(288.0F, 4.0F);
/* 140 */     this.smallBarTwoContainer.addActor((Actor)this.barSmallTwo);
/*     */ 
/*     */     
/* 143 */     this.marksGroup = new Group();
/* 144 */     this.marksGroup.setTransform(false);
/* 145 */     this.marksGroup.setPosition(2.0F, 12.0F);
/* 146 */     addActor((Actor)this.marksGroup);
/*     */     
/* 148 */     setSmallBarsCount(0);
/* 149 */     setLabelsColor(Color.WHITE);
/* 150 */     setMainBarColor(Color.DARK_GRAY, Color.GRAY);
/*     */   }
/*     */   public Image barBackgroundLarge; public Image barLarge; public Group smallBarOneContainer; public Image barBackgroundSmallOne; public Image barSmallOne; public Group smallBarTwoContainer; public Image barBackgroundSmallTwo; public Image barSmallTwo; public Group marksGroup; private final Array<Drawable> k; private String l;
/*     */   public final BossHpBar setLabelsColor(Color paramColor) {
/* 154 */     this.nameLabel.setColor(paramColor);
/* 155 */     this.hpLabelCurrent.setColor(paramColor);
/* 156 */     this.hpLabelMax.setColor(paramColor);
/* 157 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setMainBarColor(Color paramColor1, Color paramColor2) {
/* 161 */     this.barBackgroundLarge.setColor(paramColor1);
/* 162 */     this.barLarge.setColor(paramColor2);
/* 163 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setFirstSmallBarColor(Color paramColor1, Color paramColor2) {
/* 167 */     this.barBackgroundSmallOne.setColor(paramColor1);
/* 168 */     this.barSmallOne.setColor(paramColor2);
/* 169 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setSecondSmallBarColor(Color paramColor1, Color paramColor2) {
/* 173 */     this.barBackgroundSmallTwo.setColor(paramColor1);
/* 174 */     this.barSmallTwo.setColor(paramColor2);
/* 175 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BossHpBar setSmallBarsCount(int paramInt) {
/* 182 */     if (paramInt < 0) {
/* 183 */       paramInt = 0;
/* 184 */     } else if (paramInt > 2) {
/* 185 */       paramInt = 2;
/*     */     } 
/*     */     
/* 188 */     this.barBackgroundSmallOne.setVisible(false);
/* 189 */     this.barSmallOne.setVisible(false);
/* 190 */     this.barBackgroundSmallTwo.setVisible(false);
/* 191 */     this.barSmallTwo.setVisible(false);
/*     */     
/* 193 */     switch (paramInt) {
/*     */       case 0:
/* 195 */         this.backgroundImage.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.bgOneLine"));
/*     */         break;
/*     */       
/*     */       case 1:
/* 199 */         this.barBackgroundSmallOne.setVisible(true);
/* 200 */         this.barSmallOne.setVisible(true);
/* 201 */         this.backgroundImage.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.bgTwoLines"));
/*     */         break;
/*     */       
/*     */       case 2:
/* 205 */         this.barBackgroundSmallOne.setVisible(true);
/* 206 */         this.barSmallOne.setVisible(true);
/* 207 */         this.barBackgroundSmallTwo.setVisible(true);
/* 208 */         this.barSmallTwo.setVisible(true);
/* 209 */         this.backgroundImage.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.bgThreeLines"));
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 214 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setBossName(String paramString) {
/* 218 */     Preconditions.checkNotNull(paramString, "Name is null");
/* 219 */     if (!this.l.equals(paramString)) {
/* 220 */       this.l = paramString;
/* 221 */       this.nameLabel.setText(paramString);
/*     */     } 
/* 223 */     return this;
/*     */   }
/*     */   
/*     */   public final String getBossName() {
/* 227 */     return this.l;
/*     */   }
/*     */   
/*     */   public final BossHpBar setIcon(Drawable paramDrawable) {
/* 231 */     this.iconImage.setDrawable(paramDrawable);
/* 232 */     this.iconImageShadow.setDrawable(paramDrawable);
/* 233 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setMainHP(double paramDouble1, double paramDouble2) {
/* 237 */     String str1 = StringFormatter.compactNumber(paramDouble1, false).toString();
/* 238 */     String str2 = "/ " + StringFormatter.compactNumber(paramDouble2, false).toString() + " HP";
/* 239 */     this.hpLabelCurrent.setText(str1);
/* 240 */     this.hpLabelMax.setText(str2);
/*     */     
/* 242 */     float f = MathUtils.clamp((float)(paramDouble1 / paramDouble2), 0.0F, 1.0F) * 300.0F;
/* 243 */     this.largeBarContainer.setWidth(f);
/*     */     
/* 245 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setSmallBarOneProgress(double paramDouble) {
/* 249 */     this.smallBarOneContainer.setWidth((float)paramDouble * 292.0F);
/* 250 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar setSmallBarTwoProgress(double paramDouble) {
/* 254 */     this.smallBarTwoContainer.setWidth((float)paramDouble * 288.0F);
/* 255 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar clearMarks() {
/* 259 */     this.marksGroup.clear();
/* 260 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar addMark(float paramFloat) {
/*     */     Image image;
/* 265 */     (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.bossHpBar.mark"))).setSize(10.0F, 7.0F);
/* 266 */     image.setPosition(paramFloat * 300.0F - 5.0F, 0.0F);
/* 267 */     this.marksGroup.addActor((Actor)image);
/* 268 */     return this;
/*     */   }
/*     */   
/*     */   public final BossHpBar addEffectIcon(Drawable paramDrawable) {
/* 272 */     Image image = new Image(paramDrawable);
/* 273 */     this.effectIconsTable.add((Actor)image).size(22.0F);
/* 274 */     this.k.add(paramDrawable);
/* 275 */     return this;
/*     */   }
/*     */   
/*     */   public final Array<Drawable> getEffectIcons() {
/* 279 */     return this.k;
/*     */   }
/*     */   
/*     */   public final boolean isEffectIconExists(Drawable paramDrawable) {
/* 283 */     return this.k.contains(paramDrawable, true);
/*     */   }
/*     */   
/*     */   public final BossHpBar clearEffectIcons() {
/* 287 */     this.effectIconsTable.clear();
/* 288 */     this.k.clear();
/* 289 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\BossHpBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */