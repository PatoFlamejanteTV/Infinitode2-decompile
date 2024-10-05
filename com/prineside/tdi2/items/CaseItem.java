/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.ItemManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public class CaseItem extends Item {
/*     */   public CaseType caseType;
/*     */   public boolean containsPapers;
/*     */   @NAGS
/*     */   private String a;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     paramKryo.writeObject(paramOutput, this.caseType);
/*  50 */     paramOutput.writeBoolean(this.containsPapers);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  55 */     this.caseType = (CaseType)paramKryo.readObject(paramInput, CaseType.class);
/*  56 */     this.containsPapers = paramInput.readBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   private CaseItem() {}
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   private CaseItem(CaseType paramCaseType, boolean paramBoolean) {
/*  67 */     if (paramCaseType == null) throw new IllegalArgumentException("CaseType is null"); 
/*  68 */     this.caseType = paramCaseType;
/*  69 */     this.containsPapers = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  74 */     paramItem = paramItem;
/*  75 */     return Item.D.F_CASE.create(((CaseItem)paramItem).caseType, ((CaseItem)paramItem).containsPapers);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  82 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.caseType.ordinal());
/*  83 */     intArray.add(ItemDataType.CASE_CONTAINS_PAPERS.ordinal(), this.containsPapers ? 1 : 0);
/*     */     
/*  85 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  90 */     return "case_" + this.caseType;
/*     */   }
/*     */   
/*     */   public Color getColor() {
/*  94 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/*  95 */         return MaterialColor.GREEN.P500;
/*  96 */       case 2: return MaterialColor.INDIGO.P400;
/*  97 */       case 3: return MaterialColor.ORANGE.P500;
/*  98 */       case 4: return MaterialColor.PURPLE.P400;
/*  99 */       case 5: return MaterialColor.CYAN.P500;
/* 100 */       case 6: return MaterialColor.PINK.P600; }
/*     */ 
/*     */     
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public int getItemCount() {
/* 107 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/* 108 */         return 4;
/* 109 */       case 2: return 5;
/* 110 */       case 4: return 6;
/* 111 */       case 3: return 7;
/* 112 */       case 5: return 8;
/* 113 */       case 6: return 3; }
/* 114 */      return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] getItemRarityChances() {
/* 119 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/* 120 */         return new int[] { 88, 12, 0, 0, 0 };
/* 121 */       case 2: return new int[] { 70, 25, 5, 0, 0 };
/* 122 */       case 4: return new int[] { 51, 34, 12, 3, 0 };
/* 123 */       case 3: return new int[] { 29, 38, 18, 12, 3 };
/* 124 */       case 5: return new int[] { 14, 30, 24, 20, 12 };
/* 125 */       case 6: return new int[] { 100, 0, 0, 0, 0 }; }
/*     */ 
/*     */     
/* 128 */     return null;
/*     */   }
/*     */   
/*     */   public RarityType getGuaranteedItemType() {
/* 132 */     switch (null.a[this.caseType.ordinal()]) { case 4:
/* 133 */         return RarityType.VERY_RARE;
/* 134 */       case 3: return RarityType.EPIC;
/* 135 */       case 5: return RarityType.LEGENDARY; }
/*     */ 
/*     */     
/* 138 */     return null;
/*     */   }
/*     */   
/*     */   public int getCasePriceInKeys() {
/* 142 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/* 143 */         return 0;
/* 144 */       case 2: return 10;
/* 145 */       case 4: return 10;
/* 146 */       case 3: return 10;
/* 147 */       case 5: return 10; }
/* 148 */      return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCasePriceInPapers() {
/* 153 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/* 154 */         return 7000;
/* 155 */       case 2: return 7500;
/* 156 */       case 4: return 30000;
/* 157 */       case 3: return 120000; }
/* 158 */      return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCasePriceInAccelerators() {
/* 163 */     if (this.caseType == CaseType.CYAN) {
/* 164 */       return 100;
/*     */     }
/* 166 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item cpy() {
/* 172 */     return Item.D.F_CASE.create(this.caseType, this.containsPapers);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeUnpacked() {
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   public Array<ItemStack> openPack(ProgressManager.InventoryStatistics paramInventoryStatistics) {
/*     */     boolean bool;
/* 182 */     Array<ItemStack> array = new Array(false, 8, ItemStack.class);
/*     */     
/* 184 */     RandomXS128 randomXS128 = (ProgressPrefs.i()).progress.getCaseRandom(this.caseType);
/* 185 */     IntArray intArray = new IntArray();
/*     */     
/* 187 */     switch (null.a[this.caseType.ordinal()]) {
/*     */       case 1:
/* 189 */         intArray.add(88, RarityType.COMMON.ordinal());
/* 190 */         intArray.add(12, RarityType.RARE.ordinal());
/*     */         
/* 192 */         bool = false;
/* 193 */         while (array.size != 4) {
/* 194 */           if (this.containsPapers && !bool) {
/*     */             
/* 196 */             ProgressManager.addItemToStacksArray(array, Item.D.GREEN_PAPER, (8 + randomXS128.nextInt(5)) * 100);
/* 197 */             bool = true; continue;
/*     */           } 
/* 199 */           int i = PMath.getByChance(randomXS128, intArray);
/* 200 */           float f = randomXS128.nextFloat();
/*     */ 
/*     */           
/* 203 */           ItemStack itemStack = ItemManager.generateItemByRarity(randomXS128, RarityType.values[i], f, 1.0F, 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 208 */               Game.i.progressManager.isResourceOpened(ResourceType.SCALAR) ? 1.0F : 0.0F, 1.0F, 
/*     */               
/* 210 */               (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE), 0.0F, 
/*     */               
/* 212 */               (i >= RarityType.RARE.ordinal()) ? 2.0F : 0.0F, false, paramInventoryStatistics);
/*     */ 
/*     */ 
/*     */           
/* 216 */           boolean bool1 = false;
/* 217 */           for (byte b = 0; b < array.size; b++) {
/* 218 */             if (((ItemStack[])array.items)[b].getItem().sameAs(itemStack.getItem())) {
/* 219 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 223 */           if (!bool1 && itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 224 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 225 */             if (!Game.i.progressManager.isResourceOpened(resourceItem.resourceType)) {
/* 226 */               bool1 = true;
/*     */             }
/*     */           } 
/* 229 */           if (!bool1) {
/* 230 */             array.add(itemStack);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 235 */         if (this.containsPapers) {
/*     */           
/* 237 */           int i = randomXS128.nextInt(3);
/* 238 */           ProgressManager.addItemToStacksArray(array, 
/*     */               
/* 240 */               (i == 0) ? Item.D.BLUEPRINT_AGILITY : ((i == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 2 + randomXS128
/* 241 */               .nextInt(3));
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 248 */         intArray.add(70, RarityType.COMMON.ordinal());
/* 249 */         intArray.add(25, RarityType.RARE.ordinal());
/* 250 */         intArray.add(5, RarityType.VERY_RARE.ordinal());
/*     */         
/* 252 */         bool = false;
/* 253 */         while (array.size != 5) {
/* 254 */           if (this.containsPapers && !bool) {
/*     */             
/* 256 */             array.add(new ItemStack(Item.D.GREEN_PAPER, (20 + randomXS128.nextInt(11)) * 100));
/* 257 */             bool = true; continue;
/*     */           } 
/* 259 */           int i = PMath.getByChance(randomXS128, intArray);
/* 260 */           float f1 = randomXS128.nextFloat();
/* 261 */           float f2 = 1.0F;
/* 262 */           if (i == RarityType.COMMON.ordinal()) {
/* 263 */             f2 = 2.0F;
/*     */           }
/*     */           
/* 266 */           ItemStack itemStack = ItemManager.generateItemByRarity(randomXS128, RarityType.values[i], f1, f2, 1.0F, 1.0F, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 273 */               (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE), 0.0F, 
/*     */               
/* 275 */               (i >= RarityType.VERY_RARE.ordinal()) ? 2.0F : 0.0F, false, paramInventoryStatistics);
/*     */ 
/*     */ 
/*     */           
/* 279 */           boolean bool1 = false;
/* 280 */           for (byte b = 0; b < array.size; b++) {
/* 281 */             if (((ItemStack[])array.items)[b].getItem().sameAs(itemStack.getItem())) {
/* 282 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 286 */           if (!bool1 && itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 287 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 288 */             if (!Game.i.progressManager.isResourceOpened(resourceItem.resourceType)) {
/* 289 */               bool1 = true;
/*     */             }
/*     */           } 
/* 292 */           if (!bool1) {
/* 293 */             array.add(itemStack);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 298 */         if (this.containsPapers) {
/*     */ 
/*     */           
/* 301 */           int i = randomXS128.nextInt(3), j = i;
/* 302 */           while (j == i) {
/* 303 */             j = randomXS128.nextInt(3);
/*     */           }
/* 305 */           ProgressManager.addItemToStacksArray(array, 
/* 306 */               (i == 0) ? Item.D.BLUEPRINT_AGILITY : ((i == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 3 + randomXS128
/* 307 */               .nextInt(4));
/*     */           
/* 309 */           ProgressManager.addItemToStacksArray(array, 
/* 310 */               (j == 0) ? Item.D.BLUEPRINT_AGILITY : ((j == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 3 + randomXS128
/* 311 */               .nextInt(4));
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 318 */         intArray.add(51, RarityType.COMMON.ordinal());
/* 319 */         intArray.add(34, RarityType.RARE.ordinal());
/* 320 */         intArray.add(12, RarityType.VERY_RARE.ordinal());
/* 321 */         intArray.add(3, RarityType.EPIC.ordinal());
/*     */         
/* 323 */         bool = false;
/* 324 */         while (array.size != 6) {
/* 325 */           int i; if (this.containsPapers && !bool) {
/*     */             
/* 327 */             array.add(new ItemStack(Item.D.GREEN_PAPER, (25 + randomXS128.nextInt(11)) * 200));
/* 328 */             bool = true;
/*     */             continue;
/*     */           } 
/* 331 */           if (array.size == 1) {
/* 332 */             i = RarityType.VERY_RARE.ordinal();
/*     */           } else {
/* 334 */             i = PMath.getByChance(randomXS128, intArray);
/*     */           } 
/*     */           
/* 337 */           float f1 = randomXS128.nextFloat();
/* 338 */           float f2 = 1.0F;
/* 339 */           if (i == RarityType.COMMON.ordinal()) {
/* 340 */             f2 = 4.0F;
/* 341 */           } else if (i == RarityType.RARE.ordinal()) {
/* 342 */             f2 = 2.0F;
/*     */           } 
/*     */           
/* 345 */           ItemStack itemStack = ItemManager.generateItemByRarity(randomXS128, RarityType.values[i], f1, f2, 1.0F, 1.0F, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 352 */               (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE), 0.0F, 
/*     */               
/* 354 */               (i >= RarityType.EPIC.ordinal()) ? 2.0F : 0.0F, false, paramInventoryStatistics);
/*     */ 
/*     */ 
/*     */           
/* 358 */           boolean bool1 = false;
/* 359 */           for (byte b = 0; b < array.size; b++) {
/* 360 */             if (((ItemStack[])array.items)[b].getItem().sameAs(itemStack.getItem())) {
/* 361 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 365 */           if (!bool1 && itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 366 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 367 */             if (!Game.i.progressManager.isResourceOpened(resourceItem.resourceType)) {
/* 368 */               bool1 = true;
/*     */             }
/*     */           } 
/* 371 */           if (!bool1) {
/* 372 */             array.add(itemStack);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 377 */         if (this.containsPapers) {
/*     */ 
/*     */           
/* 380 */           int i = randomXS128.nextInt(3), j = i;
/* 381 */           while (j == i) {
/* 382 */             j = randomXS128.nextInt(3);
/*     */           }
/* 384 */           ProgressManager.addItemToStacksArray(array, 
/* 385 */               (i == 0) ? Item.D.BLUEPRINT_AGILITY : ((i == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 4 + randomXS128
/* 386 */               .nextInt(5));
/*     */           
/* 388 */           ProgressManager.addItemToStacksArray(array, 
/* 389 */               (j == 0) ? Item.D.BLUEPRINT_AGILITY : ((j == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 4 + randomXS128
/* 390 */               .nextInt(5));
/*     */           
/* 392 */           ProgressManager.addItemToStacksArray(array, Item.D.BLUEPRINT_SPECIAL_I, 1);
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 401 */         intArray.add(29, RarityType.COMMON.ordinal());
/* 402 */         intArray.add(38, RarityType.RARE.ordinal());
/* 403 */         intArray.add(18, RarityType.VERY_RARE.ordinal());
/* 404 */         intArray.add(12, RarityType.EPIC.ordinal());
/* 405 */         intArray.add(3, RarityType.LEGENDARY.ordinal());
/*     */         
/* 407 */         bool = false;
/* 408 */         while (array.size != 7) {
/* 409 */           int i; if (this.containsPapers && !bool) {
/*     */             
/* 411 */             array.add(new ItemStack(Item.D.GREEN_PAPER, (25 + randomXS128.nextInt(11)) * 500));
/* 412 */             bool = true;
/*     */             continue;
/*     */           } 
/* 415 */           if (array.size == 1) {
/* 416 */             i = RarityType.EPIC.ordinal();
/*     */           } else {
/* 418 */             i = PMath.getByChance(randomXS128, intArray);
/*     */           } 
/*     */           
/* 421 */           float f1 = randomXS128.nextFloat();
/* 422 */           float f2 = 1.0F;
/* 423 */           if (i == RarityType.COMMON.ordinal()) {
/* 424 */             f2 = 8.0F;
/* 425 */           } else if (i == RarityType.RARE.ordinal()) {
/* 426 */             f2 = 4.0F;
/* 427 */           } else if (i == RarityType.VERY_RARE.ordinal()) {
/* 428 */             f2 = 2.0F;
/*     */           } 
/*     */           
/* 431 */           ItemStack itemStack = ItemManager.generateItemByRarity(randomXS128, RarityType.values[i], f1, f2, 1.0F, 1.0F, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 438 */               (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE), 0.0F, 
/*     */               
/* 440 */               (i >= RarityType.LEGENDARY.ordinal()) ? 2.0F : 0.0F, false, paramInventoryStatistics);
/*     */ 
/*     */ 
/*     */           
/* 444 */           boolean bool1 = false;
/* 445 */           for (byte b = 0; b < array.size; b++) {
/* 446 */             if (((ItemStack[])array.items)[b].getItem().sameAs(itemStack.getItem())) {
/* 447 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 451 */           if (!bool1 && itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 452 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 453 */             if (!Game.i.progressManager.isResourceOpened(resourceItem.resourceType)) {
/* 454 */               bool1 = true;
/*     */             }
/*     */           } 
/* 457 */           if (!bool1) {
/* 458 */             array.add(itemStack);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 463 */         if (this.containsPapers) {
/*     */ 
/*     */           
/* 466 */           int i = randomXS128.nextInt(3), j = i;
/* 467 */           while (j == i) {
/* 468 */             j = randomXS128.nextInt(3);
/*     */           }
/* 470 */           ProgressManager.addItemToStacksArray(array, 
/* 471 */               (i == 0) ? Item.D.BLUEPRINT_AGILITY : ((i == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 6 + randomXS128
/* 472 */               .nextInt(7));
/*     */           
/* 474 */           ProgressManager.addItemToStacksArray(array, 
/* 475 */               (j == 0) ? Item.D.BLUEPRINT_AGILITY : ((j == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 6 + randomXS128
/* 476 */               .nextInt(7));
/*     */           
/* 478 */           ProgressManager.addItemToStacksArray(array, Item.D.BLUEPRINT_SPECIAL_I, 1 + randomXS128
/*     */               
/* 480 */               .nextInt(3));
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 487 */         intArray.add(14, RarityType.COMMON.ordinal());
/* 488 */         intArray.add(30, RarityType.RARE.ordinal());
/* 489 */         intArray.add(24, RarityType.VERY_RARE.ordinal());
/* 490 */         intArray.add(20, RarityType.EPIC.ordinal());
/* 491 */         intArray.add(12, RarityType.LEGENDARY.ordinal());
/*     */         
/* 493 */         bool = false;
/* 494 */         while (array.size != 8) {
/* 495 */           int i; if (this.containsPapers && !bool) {
/*     */             
/* 497 */             array.add(new ItemStack(Item.D.GREEN_PAPER, (28 + randomXS128.nextInt(5)) * 1000));
/* 498 */             bool = true;
/*     */             continue;
/*     */           } 
/* 501 */           if (array.size == 1) {
/* 502 */             i = RarityType.LEGENDARY.ordinal();
/*     */           } else {
/* 504 */             i = PMath.getByChance(randomXS128, intArray);
/*     */           } 
/*     */           
/* 507 */           float f1 = randomXS128.nextFloat();
/* 508 */           float f2 = 1.0F;
/* 509 */           if (i == RarityType.COMMON.ordinal()) {
/* 510 */             f2 = 16.0F;
/* 511 */           } else if (i == RarityType.RARE.ordinal()) {
/* 512 */             f2 = 8.0F;
/* 513 */           } else if (i == RarityType.VERY_RARE.ordinal()) {
/* 514 */             f2 = 4.0F;
/* 515 */           } else if (i == RarityType.EPIC.ordinal()) {
/* 516 */             f2 = 2.0F;
/*     */           } 
/*     */           
/* 519 */           ItemStack itemStack = ItemManager.generateItemByRarity(randomXS128, RarityType.values[i], f1, f2, 1.0F, 1.0F, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 526 */               (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE), 0.0F, 0.0F, false, paramInventoryStatistics);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 532 */           boolean bool1 = false;
/* 533 */           for (byte b = 0; b < array.size; b++) {
/* 534 */             if (((ItemStack[])array.items)[b].getItem().sameAs(itemStack.getItem())) {
/* 535 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 539 */           if (!bool1 && itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 540 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 541 */             if (!Game.i.progressManager.isResourceOpened(resourceItem.resourceType)) {
/* 542 */               bool1 = true;
/*     */             }
/*     */           } 
/* 545 */           if (!bool1) {
/* 546 */             array.add(itemStack);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 551 */         if (this.containsPapers) {
/*     */ 
/*     */           
/* 554 */           int i = randomXS128.nextInt(3), j = i;
/* 555 */           while (j == i) {
/* 556 */             j = randomXS128.nextInt(3);
/*     */           }
/* 558 */           ProgressManager.addItemToStacksArray(array, 
/* 559 */               (i == 0) ? Item.D.BLUEPRINT_AGILITY : ((i == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 8 + randomXS128
/* 560 */               .nextInt(9));
/*     */           
/* 562 */           ProgressManager.addItemToStacksArray(array, 
/* 563 */               (j == 0) ? Item.D.BLUEPRINT_AGILITY : ((j == 1) ? Item.D.BLUEPRINT_EXPERIENCE : Item.D.BLUEPRINT_POWER), 8 + randomXS128
/* 564 */               .nextInt(9));
/*     */           
/* 566 */           ProgressManager.addItemToStacksArray(array, Item.D.BLUEPRINT_SPECIAL_II, 1);
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 6:
/* 575 */         array.add(new ItemStack(Item.D.F_BLUEPRINT.create(BlueprintType.AGILITY), 38 + randomXS128.nextInt(19)));
/* 576 */         array.add(new ItemStack(Item.D.F_BLUEPRINT.create(BlueprintType.POWER), 38 + randomXS128.nextInt(19)));
/* 577 */         array.add(new ItemStack(Item.D.F_BLUEPRINT.create(BlueprintType.EXPERIENCE), 38 + randomXS128.nextInt(19)));
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 583 */     ProgressPrefs.i().requireSave();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 591 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 596 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 601 */     return ItemType.CASE;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 606 */     return ItemCategoryType.PACKS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 611 */     return ItemSubcategoryType.P_DECRYPTED;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 616 */     if (this.a == null) {
/* 617 */       this.a = "item_title_CASE_" + this.caseType.name();
/*     */     }
/*     */     
/* 620 */     return Game.i.localeManager.i18n.get(this.a);
/*     */   }
/*     */   
/*     */   public float getDecryptionTime() {
/* 624 */     switch (null.a[this.caseType.ordinal()]) {
/*     */       case 1:
/* 626 */         return 5400.0F;
/*     */       case 2:
/* 628 */         return 10800.0F;
/*     */       case 4:
/* 630 */         return 21600.0F;
/*     */       case 3:
/* 632 */         return 43200.0F;
/*     */       case 5:
/* 634 */         return 64800.0F;
/*     */       case 6:
/* 636 */         return 21600.0F;
/*     */     } 
/* 638 */     return 86400.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 644 */     return Game.i.localeManager.i18n.get("item_description_CASE");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 649 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/* 650 */         return RarityType.COMMON;
/* 651 */       case 2: return RarityType.RARE;
/* 652 */       case 4: return RarityType.VERY_RARE;
/* 653 */       case 3: return RarityType.EPIC;
/* 654 */       case 5: return RarityType.LEGENDARY;
/* 655 */       case 6: return RarityType.EPIC; }
/*     */ 
/*     */     
/* 658 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 663 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 665 */     return (((CaseItem)paramItem).caseType == this.caseType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 670 */     super.toJson(paramJson);
/*     */     
/* 672 */     paramJson.writeValue("caseType", this.caseType.toString());
/* 673 */     paramJson.writeValue("containsPapers", Boolean.valueOf(this.containsPapers));
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIconDrawable() {
/* 678 */     return CaseItemFactory.a(Item.D.F_CASE)[this.caseType.ordinal()][0];
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Group group;
/* 684 */     (group = new Group()).setTransform(false);
/* 685 */     group.setSize(paramFloat, paramFloat);
/*     */     
/* 687 */     Drawable drawable = CaseItemFactory.a(Item.D.F_CASE)[this.caseType.ordinal()][0];
/*     */     
/* 689 */     if (paramBoolean) {
/*     */       Image image1;
/* 691 */       (image1 = new Image(drawable)).setSize(paramFloat, paramFloat);
/* 692 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 693 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 694 */       group.addActor((Actor)image1);
/*     */     } 
/*     */     
/*     */     Image image;
/* 698 */     (image = new Image(drawable)).setSize(paramFloat, paramFloat);
/* 699 */     group.addActor((Actor)image);
/*     */     
/* 701 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 706 */     paramItemCreationOverlay.label("Case type");
/*     */     SelectBox selectBox;
/* 708 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])CaseType.values);
/* 709 */     selectBox.setSelected(this.caseType);
/* 710 */     selectBox.addListener((EventListener)new ChangeListener(this, paramItemCreationOverlay, selectBox)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 713 */             this.a.currentItem = Item.D.F_CASE.create((CaseType)this.b.getSelected(), this.c.containsPapers);
/* 714 */             this.a.updateItemIcon();
/*     */           }
/*     */         });
/* 717 */     paramItemCreationOverlay.selectBox(selectBox);
/*     */     
/* 719 */     paramItemCreationOverlay.toggle("Contains papers", this.containsPapers, paramBoolean -> {
/*     */           paramItemCreationOverlay.currentItem = Item.D.F_CASE.create(this.caseType, paramBoolean.booleanValue());
/*     */           paramItemCreationOverlay.updateForm();
/*     */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */         });
/*     */   }
/*     */   
/*     */   public static class CaseItemFactory implements Item.Factory<CaseItem> {
/* 727 */     private final CaseItem[][] a = new CaseItem[CaseType.values.length][2];
/*     */     
/* 729 */     private final Drawable[][] b = new Drawable[CaseType.values.length][2]; public CaseItemFactory() { CaseType[] arrayOfCaseType;
/*     */       int i;
/*     */       byte b;
/* 732 */       for (i = (arrayOfCaseType = CaseType.values).length, b = 0; b < i; ) { CaseType caseType = arrayOfCaseType[b];
/* 733 */         this.a[caseType.ordinal()][0] = new CaseItem(caseType, false, (byte)0);
/* 734 */         this.a[caseType.ordinal()][1] = new CaseItem(caseType, true, (byte)0);
/*     */         b++; }
/*     */        }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 740 */       if (Game.i.assetManager != null) {
/* 741 */         this.b[CaseType.GREEN.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-green");
/* 742 */         this.b[CaseType.BLUE.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-blue");
/* 743 */         this.b[CaseType.ORANGE.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-orange");
/* 744 */         this.b[CaseType.PURPLE.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-purple");
/* 745 */         this.b[CaseType.CYAN.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-cyan");
/* 746 */         this.b[CaseType.BLUEPRINT.ordinal()][0] = (Drawable)Game.i.assetManager.getDrawable("chest-pink");
/*     */         
/* 748 */         this.b[CaseType.GREEN.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-green-encrypted");
/* 749 */         this.b[CaseType.BLUE.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-blue-encrypted");
/* 750 */         this.b[CaseType.ORANGE.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-orange-encrypted");
/* 751 */         this.b[CaseType.PURPLE.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-purple-encrypted");
/* 752 */         this.b[CaseType.CYAN.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-cyan-encrypted");
/* 753 */         this.b[CaseType.BLUEPRINT.ordinal()][1] = (Drawable)Game.i.assetManager.getDrawable("chest-pink-encrypted");
/*     */       } 
/*     */     }
/*     */     
/*     */     public CaseItem create(CaseType param1CaseType, boolean param1Boolean) {
/* 758 */       if (param1CaseType == null) {
/* 759 */         throw new IllegalArgumentException("CaseType is null");
/*     */       }
/*     */       
/* 762 */       return this.a[param1CaseType.ordinal()][param1Boolean ? 1 : 0];
/*     */     }
/*     */ 
/*     */     
/*     */     public CaseItem fromJson(JsonValue param1JsonValue) {
/* 767 */       return create(
/* 768 */           CaseType.valueOf(param1JsonValue.getString("caseType")), param1JsonValue
/* 769 */           .getBoolean("containsPapers", true));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CaseItem createDefault() {
/* 775 */       return create(CaseType.values[0], false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\CaseItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */