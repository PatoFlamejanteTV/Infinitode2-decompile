/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Research;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.items.ResourceItem;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public class ResearchScreenInventory
/*     */   extends Group
/*     */   implements Disposable
/*     */ {
/*     */   public static final float WIDTH = 292.0F;
/*     */   public static final float HEIGHT = 780.0F;
/*     */   private boolean k = false;
/*  34 */   private Array<Item> l = new Array(true, 1, Item.class);
/*  35 */   private Array<Label> m = new Array(true, 1, Label.class);
/*  36 */   private Array<PaddedImageButton> n = new Array(true, 1, PaddedImageButton.class);
/*     */   
/*     */   private ProgressManager.ProgressManagerListener o;
/*     */   
/*     */   public ResearchScreenInventory() {
/*  41 */     this.l.add(Item.D.GREEN_PAPER);
/*  42 */     this.l.add(Item.D.ACCELERATOR);
/*  43 */     this.l.add(Item.D.RESOURCE_SCALAR);
/*  44 */     this.l.add(Item.D.RESOURCE_VECTOR);
/*  45 */     this.l.add(Item.D.RESOURCE_MATRIX);
/*  46 */     this.l.add(Item.D.RESOURCE_TENSOR);
/*  47 */     this.l.add(Item.D.RESOURCE_INFIAR);
/*  48 */     this.l.add(Item.D.BLUEPRINT_AGILITY);
/*  49 */     this.l.add(Item.D.BLUEPRINT_EXPERIENCE);
/*  50 */     this.l.add(Item.D.BLUEPRINT_POWER);
/*  51 */     this.l.add(Item.D.BLUEPRINT_SPECIAL_I);
/*  52 */     this.l.add(Item.D.BLUEPRINT_SPECIAL_II);
/*  53 */     this.l.add(Item.D.BLUEPRINT_SPECIAL_III);
/*  54 */     this.l.add(Item.D.BLUEPRINT_SPECIAL_IV);
/*  55 */     this.l.add(Item.D.PRESTIGE_TOKEN);
/*  56 */     this.l.add(Item.D.BIT_DUST);
/*     */     
/*  58 */     setSize(292.0F, 780.0F);
/*  59 */     setTransform(false);
/*     */     Image image;
/*  61 */     (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.researchScreenInventory.background"))).setSize(292.0F, 780.0F);
/*  62 */     addActor((Actor)image);
/*     */     
/*     */     Label label;
/*  65 */     (label = new Label(Game.i.localeManager.i18n.get("inventory"), Game.i.assetManager.getLabelStyle(21))).setPosition(23.0F, 740.0F);
/*  66 */     label.setSize(100.0F, 14.0F);
/*  67 */     label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  68 */     addActor((Actor)label);
/*     */ 
/*     */     
/*  71 */     for (byte b = 0; b < this.l.size; b++) {
/*     */       Group group;
/*  73 */       (group = new Group()).setTransform(false);
/*  74 */       group.setPosition(0.0F, 688.0F - b * 38.0F);
/*  75 */       addActor((Actor)group);
/*     */       
/*  77 */       if (b % 2 == 0) {
/*     */         Image image1;
/*  79 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.04F);
/*  80 */         image1.setSize(205.0F, 38.0F);
/*  81 */         group.addActor((Actor)image1);
/*     */       } 
/*     */       
/*     */       Item item;
/*     */       Actor actor;
/*  86 */       (actor = (item = (Item)this.l.get(b)).generateIcon(30.0F, false)).setPosition(24.0F, 4.0F);
/*  87 */       group.addActor(actor);
/*     */       
/*  89 */       Label label1 = new Label("0", Game.i.assetManager.getLabelStyle(21));
/*  90 */       group.addActor((Actor)label1);
/*  91 */       label1.setAlignment(16);
/*  92 */       label1.setWidth(182.0F);
/*  93 */       label1.setHeight(38.0F);
/*  94 */       this.m.add(label1);
/*     */       
/*     */       PaddedImageButton paddedImageButton;
/*  97 */       (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("small-circle"), null, Color.WHITE, Color.WHITE, Color.WHITE)).setSize(64.0F, 38.0F);
/*  98 */       paddedImageButton.setIconSize(10.0F, 10.0F);
/*  99 */       paddedImageButton.setIconPosition(8.0F, 14.0F);
/* 100 */       group.addActor((Actor)paddedImageButton);
/* 101 */       this.n.add(paddedImageButton);
/*     */     } 
/*     */     
/* 104 */     this.k = true;
/*     */ 
/*     */     
/* 107 */     this.o = (ProgressManager.ProgressManagerListener)new ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter(this)
/*     */       {
/*     */         public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 110 */           for (param1Int1 = 0; param1Int1 < (ResearchScreenInventory.a(this.a)).size; param1Int1++) {
/* 111 */             if (((Item)ResearchScreenInventory.a(this.a).get(param1Int1)).sameAs(param1Item)) {
/* 112 */               ResearchScreenInventory.a(this.a, true);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/* 118 */     Game.i.progressManager.addListener(this.o);
/*     */   }
/*     */   
/*     */   public void preRender(float paramFloat) {
/* 122 */     if (this.k) {
/* 123 */       update();
/* 124 */       this.k = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 130 */     ObjectIntMap objectIntMap = new ObjectIntMap();
/* 131 */     ObjectMap objectMap = new ObjectMap();
/*     */     
/* 133 */     Array array = Game.i.researchManager.getInstances(); byte b;
/* 134 */     for (b = 0; b < array.size; b++) {
/* 135 */       Research research = (Research)array.get(b);
/*     */       boolean bool;
/* 137 */       if (!(bool = Game.i.researchManager.canStartResearching(research, false))) {
/* 138 */         boolean bool1 = false;
/* 139 */         if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.EASY || Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL) {
/* 140 */           if (!research.isMaxNormalLevel()) {
/* 141 */             bool1 = true;
/*     */           
/*     */           }
/*     */         }
/* 145 */         else if (!research.isMaxEndlessLevel()) {
/* 146 */           bool1 = true;
/*     */         } 
/*     */         
/* 149 */         if (bool1) {
/*     */           
/* 151 */           bool = true;
/* 152 */           if (research.priceInStars > 0) {
/*     */             
/* 154 */             boolean bool2 = false; byte b1;
/* 155 */             for (b1 = 0; b1 < research.linksToParents.size; b1++) {
/*     */               Research.ResearchLink researchLink;
/* 157 */               if ((researchLink = (Research.ResearchLink)research.linksToParents.get(b1)).parent.getInstalledLevel() > 0) {
/* 158 */                 bool2 = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 162 */             for (b1 = 0; b1 < research.linksToChildren.size; b1++) {
/*     */               Research.ResearchLink researchLink;
/* 164 */               if ((researchLink = (Research.ResearchLink)research.linksToChildren.get(b1)).child.getInstalledLevel() > 0) {
/* 165 */                 bool2 = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 169 */             if (!bool2) {
/* 170 */               bool = false;
/*     */             }
/*     */             
/* 173 */             if (Game.i.researchManager.getUnusedStarsCount() < research.priceInStars) {
/* 174 */               bool = false;
/*     */             }
/*     */           } else {
/*     */             
/* 178 */             for (byte b1 = 0; b1 < research.linksToParents.size; b1++) {
/*     */               Research.ResearchLink researchLink;
/* 180 */               if ((researchLink = (Research.ResearchLink)research.linksToParents.get(b1)).requiredLevels > researchLink.parent.getInstalledLevel()) {
/*     */                 
/* 182 */                 bool = false;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 188 */           if (bool) {
/*     */             Array array1;
/*     */ 
/*     */             
/* 192 */             if (research.levels.length > research.getInstalledLevel()) {
/*     */               
/* 194 */               array1 = (research.levels[research.getInstalledLevel()]).price;
/*     */             } else {
/*     */               
/* 197 */               array1 = research.endlessLevel.getPrice(research.getInstalledLevel() + 1);
/*     */             } 
/*     */             
/* 200 */             for (byte b1 = 0; b1 < array1.size; b1++) {
/*     */               ItemStack itemStack;
/* 202 */               if ((itemStack = ((ItemStack[])array1.items)[b1]).getItem().getType() == ItemType.GREEN_PAPER) {
/* 203 */                 if (itemStack.getCount() > Game.i.progressManager.getGreenPapers())
/*     */                 {
/* 205 */                   objectIntMap.getAndIncrement(Item.D.GREEN_PAPER, 0, 1);
/*     */                 }
/* 207 */               } else if (itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 208 */                 ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 209 */                 if (itemStack.getCount() > Game.i.progressManager.getResources(resourceItem.resourceType))
/*     */                 {
/* 211 */                   objectIntMap.getAndIncrement(resourceItem, 0, 1);
/*     */                 
/*     */                 }
/*     */               }
/* 215 */               else if (itemStack.getCount() > Game.i.progressManager.getItemsCount(itemStack.getItem())) {
/* 216 */                 objectIntMap.getAndIncrement(itemStack.getItem(), 0, 1);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 224 */       if (research.priceInStars == 0) {
/*     */         Array array1;
/* 226 */         if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*     */           
/* 228 */           array1 = research.getCumulativePrice(research.getInstalledLevel(), research.maxEndlessLevel, false);
/*     */         } else {
/*     */           
/* 231 */           array1 = research.getCumulativePrice(research.getInstalledLevel(), research.levels.length, false);
/*     */         } 
/* 233 */         for (bool = false; bool < array1.size; bool++) {
/* 234 */           ItemStack itemStack = (ItemStack)array1.get(bool);
/*     */           
/* 236 */           long l = (l = ((Long)objectMap.get(itemStack.getItem(), Long.valueOf(0L))).longValue()) + itemStack.getCount();
/* 237 */           objectMap.put(itemStack.getItem(), Long.valueOf(l));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 242 */     for (b = 0; b < this.l.size; b++) {
/* 243 */       Item item = (Item)this.l.get(b);
/* 244 */       Label label = (Label)this.m.get(b);
/*     */       
/* 246 */       int i = Game.i.progressManager.getItemsCount(item);
/* 247 */       label.setText((CharSequence)StringFormatter.commaSeparatedNumber(i));
/*     */       
/* 249 */       PaddedImageButton paddedImageButton = (PaddedImageButton)this.n.get(b);
/* 250 */       int j = objectIntMap.get(item, 0);
/* 251 */       paddedImageButton.setVisible(true);
/* 252 */       if (j == 0) {
/* 253 */         paddedImageButton.setColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*     */       }
/* 255 */       else if (j == 1) {
/* 256 */         paddedImageButton.setColors(MaterialColor.YELLOW.P500, MaterialColor.YELLOW.P200, MaterialColor.YELLOW.P700);
/* 257 */       } else if (j <= 3) {
/* 258 */         paddedImageButton.setColors(MaterialColor.AMBER.P500, MaterialColor.AMBER.P200, MaterialColor.AMBER.P700);
/* 259 */       } else if (j <= 10) {
/* 260 */         paddedImageButton.setColors(MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P200, MaterialColor.ORANGE.P700);
/*     */       } else {
/* 262 */         paddedImageButton.setColors(MaterialColor.RED.P500, MaterialColor.RED.P200, MaterialColor.RED.P700);
/*     */       } 
/*     */ 
/*     */       
/* 266 */       long l = ((Long)objectMap.get(item, Long.valueOf(0L))).longValue();
/*     */       
/* 268 */       paddedImageButton.setClickHandler(() -> {
/*     */             String str1 = paramItem.getTitle().toString();
/*     */             String str2 = StringFormatter.compactNumber(paramLong, false).toString();
/*     */             str1 = str1 + "\n[#888888]";
/*     */             str1 = str1 + Game.i.localeManager.i18n.format("item_required_for_full_research_tooltip", new Object[] { str2 });
/*     */             str1 = str1 + "[]";
/*     */             if (paramInt != 0) {
/*     */               str1 = str1 + "\n[#FFD54F]";
/*     */               str1 = str1 + Game.i.localeManager.i18n.format("item_required_by_research_count_tooltip", new Object[] { Integer.valueOf(paramInt) });
/*     */               str1 = str1 + "[]";
/*     */             } 
/*     */             TooltipsOverlay.i().showText("resourceRequiredByResearch", (Actor)paramPaddedImageButton, str1, UiManager.MainUiLayer.SCREEN, 110, 8);
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 288 */     Game.i.progressManager.removeListener(this.o);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\ResearchScreenInventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */