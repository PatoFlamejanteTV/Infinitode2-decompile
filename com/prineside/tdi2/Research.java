/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResearchCategoryType;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.items.BlueprintItem;
/*     */ import com.prineside.tdi2.items.ResourceItem;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Research;
/*     */ import com.prineside.tdi2.utils.CRC;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ 
/*     */ 
/*     */ public final class Research
/*     */ {
/*  32 */   private static final TLog a = TLog.forClass(Research.class);
/*  33 */   public final Array<ResearchLink> linksToParents = new Array(ResearchLink.class);
/*  34 */   public final Array<ResearchLink> linksToChildren = new Array(ResearchLink.class);
/*     */   
/*     */   public final ResearchType type;
/*     */   
/*     */   public static final int RESET_RESEARCH_STATE_AVAILABLE = 0;
/*     */   public static final int RESET_RESEARCH_STATE_HAS_CHILD = 1;
/*     */   public static final int RESET_RESEARCH_STATE_NOT_INSTALLED = 2;
/*     */   public static final int RESET_RESEARCH_STATE_NOT_SUITABLE = 3;
/*     */   public static final int RESET_RESEARCH_STATE_STAR_BRANCH = 4;
/*     */   public static final int RESET_RESEARCH_STATE_NOT_ENOUGH_ACCELERATORS = 5;
/*     */   public final ResearchCategory category;
/*     */   public final ResearchLevel[] levels;
/*     */   @Null
/*     */   public EndlessResearchLevel endlessLevel;
/*     */   public int maxEndlessLevel;
/*     */   public int endlessPriceLevel;
/*     */   public boolean endlessOnly;
/*     */   public float endlessPriceExp;
/*     */   public int x;
/*     */   public int y;
/*     */   public float distanceToCenter;
/*     */   public boolean cantBeIgnoredOnUserMaps = false;
/*     */   public boolean small = false;
/*  57 */   public int priceInStars = 0;
/*     */   
/*     */   public TowerType relatedToTowerType;
/*     */   public boolean unlocksTower;
/*     */   private final String b;
/*  62 */   private static final StringBuilder c = new StringBuilder();
/*     */   
/*  64 */   private static final Array<ItemStack> d = new Array();
/*     */   
/*     */   public Research(ResearchType paramResearchType, ResearchCategory paramResearchCategory, ResearchLevel[] paramArrayOfResearchLevel, int paramInt) {
/*  67 */     if (paramArrayOfResearchLevel.length == 0) {
/*  68 */       throw new IllegalArgumentException("upgrade " + paramResearchType.name() + " must have at least one level");
/*     */     }
/*     */     
/*  71 */     if (paramInt < paramArrayOfResearchLevel.length) {
/*  72 */       throw new IllegalArgumentException("upgrade " + paramResearchType.name() + " must have maxEndlessLevel >= " + paramArrayOfResearchLevel.length);
/*     */     }
/*     */     
/*  75 */     this.type = paramResearchType;
/*  76 */     this.maxEndlessLevel = paramInt;
/*  77 */     this.endlessPriceLevel = paramInt;
/*  78 */     this.category = paramResearchCategory;
/*  79 */     this.levels = paramArrayOfResearchLevel;
/*     */     
/*  81 */     if (paramInt != paramArrayOfResearchLevel.length) {
/*     */       
/*  83 */       int j = 0;
/*  84 */       int k = 1;
/*  85 */       int i = 0;
/*  86 */       BlueprintType blueprintType = null;
/*  87 */       for (byte b1 = 0; b1 < paramArrayOfResearchLevel.length; b1++) {
/*  88 */         ResearchLevel researchLevel = paramArrayOfResearchLevel[b1];
/*  89 */         int m = 0;
/*  90 */         for (byte b = 0; b < researchLevel.price.size; b++) {
/*     */           ItemStack itemStack;
/*  92 */           if ((itemStack = ((ItemStack[])researchLevel.price.items)[b]).getItem().getType() == ItemType.GREEN_PAPER) {
/*  93 */             m += (int)(itemStack.getCount() * 0.65F);
/*  94 */           } else if (itemStack.getItem().getType() == ItemType.RESOURCE) {
/*  95 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/*  96 */             m += (3 + resourceItem.resourceType.ordinal()) * 3 * itemStack.getCount();
/*  97 */           } else if (blueprintType == null && itemStack.getItem().getType() == ItemType.BLUEPRINT) {
/*     */             BlueprintItem blueprintItem;
/*  99 */             if ((blueprintItem = (BlueprintItem)itemStack.getItem()).getRarity() == RarityType.COMMON) {
/* 100 */               blueprintType = blueprintItem.getBlueprintType();
/*     */             }
/* 102 */           } else if (itemStack.getItem().getType() == ItemType.PRESTIGE_TOKEN) {
/* 103 */             i = itemStack.getCount();
/*     */           } 
/*     */         } 
/* 106 */         k = k * 31 + m;
/* 107 */         j += m;
/*     */       } 
/* 109 */       j /= paramArrayOfResearchLevel.length;
/*     */       
/* 111 */       GameValueManager.GameValueEffect[] arrayOfGameValueEffect = new GameValueManager.GameValueEffect[(paramArrayOfResearchLevel[paramArrayOfResearchLevel.length - 1]).effects.length];
/* 112 */       for (byte b2 = 0; b2 < (paramArrayOfResearchLevel[paramArrayOfResearchLevel.length - 1]).effects.length; b2++) {
/* 113 */         arrayOfGameValueEffect[b2] = new GameValueManager.GameValueEffect(((paramArrayOfResearchLevel[paramArrayOfResearchLevel.length - 1]).effects[b2]).type, ((paramArrayOfResearchLevel[paramArrayOfResearchLevel.length - 1]).effects[b2]).delta);
/*     */       }
/*     */       
/* 116 */       this.endlessLevel = new EndlessResearchLevel(this, j, k, blueprintType, i, arrayOfGameValueEffect);
/*     */     } 
/* 118 */     long l = CRC.calculateCRC(CRC.Parameters.CRC32, paramResearchType.name().getBytes(StandardCharsets.UTF_8));
/* 119 */     this.b = Long.toHexString(l);
/*     */     
/* 121 */     if (paramResearchType.name().startsWith("TOWER_")) {
/* 122 */       String[] arrayOfString = paramResearchType.name().split("_");
/*     */       try {
/* 124 */         if (arrayOfString[1].equals("TYPE")) {
/*     */           
/* 126 */           this.relatedToTowerType = TowerType.valueOf(arrayOfString[2]);
/* 127 */           this.unlocksTower = true;
/*     */         } else {
/* 129 */           this.relatedToTowerType = TowerType.valueOf(arrayOfString[1]); return;
/*     */         } 
/* 131 */       } catch (Exception exception) {
/* 132 */         a.e("Unknown tower type for " + paramResearchType.name(), new Object[0]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Research fromJson(l paraml) {
/* 138 */     String str1 = null;
/* 139 */     String str2 = null;
/* 140 */     int i = 0;
/* 141 */     int j = 0;
/* 142 */     int k = 0;
/* 143 */     boolean bool1 = false;
/* 144 */     boolean bool2 = false;
/* 145 */     float f = 1.0F;
/* 146 */     int m = -1;
/* 147 */     boolean bool3 = false;
/* 148 */     int n = 0;
/* 149 */     Array array = new Array(ResearchLevel.class);
/*     */     
/* 151 */     while (paraml.g() != o.c) {
/*     */       String str4; byte b;
/*     */       String str3;
/* 154 */       switch (str3 = paraml.u()) {
/*     */         case "category":
/* 156 */           str2 = paraml.i();
/*     */           continue;
/*     */         
/*     */         case "name":
/* 160 */           str1 = paraml.i();
/*     */           continue;
/*     */         
/*     */         case "x":
/* 164 */           i = paraml.b(0);
/*     */           continue;
/*     */         
/*     */         case "y":
/* 168 */           j = paraml.b(0);
/*     */           continue;
/*     */         
/*     */         case "maxEndlessModeLevels":
/* 172 */           k = paraml.b(0);
/*     */           continue;
/*     */         
/*     */         case "starsPrice":
/* 176 */           n = paraml.b(0);
/*     */           continue;
/*     */         
/*     */         case "cantBeIgnoredOnUserMaps":
/* 180 */           paraml.g();
/* 181 */           bool1 = paraml.M();
/*     */           continue;
/*     */         
/*     */         case "endlessOnly":
/* 185 */           paraml.g();
/* 186 */           bool2 = paraml.M();
/*     */           continue;
/*     */         
/*     */         case "small":
/* 190 */           paraml.g();
/* 191 */           bool3 = paraml.M();
/*     */           continue;
/*     */         
/*     */         case "epe":
/* 195 */           paraml.g();
/* 196 */           f = paraml.J();
/*     */           continue;
/*     */         
/*     */         case "epl":
/* 200 */           m = paraml.b(0);
/*     */           continue;
/*     */         
/*     */         case "levels":
/* 204 */           paraml.g();
/* 205 */           b = 1;
/* 206 */           while (paraml.g() != o.e) {
/*     */             ResearchLevel researchLevel;
/* 208 */             (researchLevel = ResearchLevel.fromJson(paraml)).number = b++;
/* 209 */             array.add(researchLevel);
/*     */           } 
/*     */           continue;
/*     */       } 
/*     */ 
/*     */       
/* 215 */       paraml.g();
/* 216 */       paraml.j();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     ResearchType researchType = ResearchType.valueOf(str1);
/* 223 */     ResearchCategory researchCategory = Game.i.researchManager.getCategory(ResearchCategoryType.valueOf(str2));
/*     */     
/*     */     Research research;
/* 226 */     (research = new Research(researchType, researchCategory, (ResearchLevel[])array.toArray(), k)).endlessOnly = bool2;
/* 227 */     research.endlessPriceExp = f;
/*     */     int i1;
/* 229 */     if ((i1 = m) != -1) {
/* 230 */       if (i1 > research.maxEndlessLevel) {
/* 231 */         a.e("endless mode price level is " + i1 + " while max is " + research.maxEndlessLevel + " for " + researchType.name(), new Object[0]);
/* 232 */         i1 = research.maxEndlessLevel;
/*     */       } 
/* 234 */       research.endlessPriceLevel = i1;
/*     */     } 
/* 236 */     research.x = i;
/* 237 */     research.y = j;
/* 238 */     research.cantBeIgnoredOnUserMaps = bool1;
/* 239 */     research.small = bool3;
/* 240 */     research.priceInStars = n;
/*     */     
/* 242 */     return research;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMaxLevel() {
/* 249 */     return Math.max(this.levels.length, this.maxEndlessLevel);
/*     */   }
/*     */   
/*     */   public final int getMaxRegularLevel() {
/* 253 */     return this.levels.length;
/*     */   }
/*     */   
/*     */   public final int getInstalledLevel() {
/* 257 */     return (ProgressPrefs.i()).research.getInstalledLevel(this.type);
/*     */   }
/*     */   
/*     */   public final void setInstalledLevel(int paramInt) {
/* 261 */     PP_Research pP_Research = (ProgressPrefs.i()).research;
/* 262 */     short s = (short)paramInt;
/* 263 */     if (paramInt > 32767) {
/* 264 */       s = Short.MAX_VALUE;
/* 265 */     } else if (paramInt < 0) {
/* 266 */       s = 0;
/*     */     } 
/* 268 */     if (pP_Research.getInstalledLevel(this.type) != s) {
/* 269 */       pP_Research.setInstalledLevel(this.type, s);
/* 270 */       ProgressPrefs.i().requireSave();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final String getShortName() {
/* 275 */     return this.b;
/*     */   }
/*     */   
/*     */   public final StringBuilder getTitle() {
/* 279 */     if (!isUnlocksTower() && getRelatedToTowerType() != null) {
/* 280 */       c.setLength(0);
/* 281 */       c.append(this.category.getTitle()).append(" (").append(Game.i.towerManager.getTitle(getRelatedToTowerType())).append(")");
/* 282 */       return c;
/*     */     } 
/* 284 */     c.setLength(0);
/* 285 */     c.append(this.category.getTitle());
/* 286 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 291 */     return this.category.getDescription();
/*     */   }
/*     */   
/*     */   public final int resetForAcceleratorsState() {
/*     */     int i;
/* 296 */     if ((i = getResetPrice()) == 0) return 3;
/*     */     
/* 298 */     if (this.priceInStars > 0) {
/* 299 */       return 4;
/*     */     }
/*     */     
/* 302 */     for (Array.ArrayIterator<ResearchLink> arrayIterator = this.linksToChildren.iterator(); arrayIterator.hasNext();) {
/* 303 */       if ((researchLink = arrayIterator.next()).child.getInstalledLevel() > 0) {
/* 304 */         return 1;
/*     */       }
/*     */     } 
/* 307 */     if (getInstalledLevel() == 0) return 2; 
/* 308 */     if (Game.i.progressManager.getAccelerators() < i) return 5;
/*     */     
/* 310 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getResetPrice() {
/* 318 */     Array<ItemStack> array = getCumulativePrice(0, getInstalledLevel(), false);
/* 319 */     double d = 0.0D;
/* 320 */     for (Array.ArrayIterator<ItemStack> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) {
/* 321 */       ItemStack itemStack; double d1 = (itemStack = arrayIterator.next()).getItem().getPriceInAcceleratorsForResearchReset(itemStack.getCount());
/*     */       
/* 323 */       d += d1;
/*     */     } 
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 329 */     return i = MathUtils.clamp(i = MathUtils.round((float)Math.pow(d, 0.9D)), 0, 400);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<ItemStack> getCumulativePrice(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 336 */     paramInt1 = Math.max(paramInt1, 0);
/* 337 */     paramInt2 = Math.min(paramInt2, this.maxEndlessLevel);
/*     */     
/* 339 */     d.clear();
/*     */     
/* 341 */     PP_Research pP_Research = (ProgressPrefs.i()).research;
/* 342 */     for (; ++paramInt1 <= paramInt2; paramInt1++) {
/* 343 */       if (paramBoolean && pP_Research.isLevelInstalledForToken(this.type, paramInt1)) {
/* 344 */         ProgressManager.addItemToStacksArray(d, (Item)Item.D.RESEARCH_TOKEN_USED, 1);
/*     */       } else {
/*     */         Array<ItemStack> array;
/*     */ 
/*     */         
/* 349 */         if (paramInt1 - 1 < this.levels.length) {
/* 350 */           array = (this.levels[paramInt1 - 1]).price;
/*     */         } else {
/* 352 */           array = this.endlessLevel.getPrice(paramInt1);
/*     */         } 
/* 354 */         for (byte b = 0; b < array.size; b++) {
/* 355 */           ItemStack itemStack = ((ItemStack[])array.items)[b];
/* 356 */           ProgressManager.addItemToStacksArray(d, itemStack.getItem(), itemStack.getCount());
/*     */         } 
/*     */       } 
/*     */     } 
/* 360 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<GameValueManager.GameValueEffect> getEffects(int paramInt) {
/* 367 */     if (paramInt <= 0 || paramInt > this.maxEndlessLevel) {
/* 368 */       throw new IllegalArgumentException("Invalid research level '" + paramInt + "' for " + this.type.name() + ", max: " + this.maxEndlessLevel);
/*     */     }
/*     */     
/* 371 */     Array<GameValueManager.GameValueEffect> array = new Array(GameValueManager.GameValueEffect.class);
/* 372 */     int i = paramInt;
/* 373 */     if (paramInt >= this.levels.length)
/*     */     {
/* 375 */       i = this.levels.length; } 
/*     */     int j;
/* 377 */     for (j = 0; j < i; j++) {
/* 378 */       for (byte b = 0; b < (this.levels[j]).effects.length; b++) {
/* 379 */         GameValueManager.GameValueEffect gameValueEffect = (this.levels[j]).effects[b];
/*     */         
/* 381 */         boolean bool = false;
/* 382 */         for (Array.ArrayIterator<GameValueManager.GameValueEffect> arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 383 */           if ((gameValueEffect1 = arrayIterator.next()).type == gameValueEffect.type) {
/*     */             
/* 385 */             gameValueEffect1.delta += gameValueEffect.delta;
/* 386 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 390 */         if (!bool)
/*     */         {
/* 392 */           array.add(new GameValueManager.GameValueEffect(gameValueEffect.type, gameValueEffect.delta));
/*     */         }
/*     */       } 
/*     */     } 
/* 396 */     if (i != paramInt) {
/*     */       
/* 398 */       j = paramInt - this.levels.length;
/* 399 */       for (byte b = 0; b < this.endlessLevel.effects.length; b++) {
/* 400 */         GameValueManager.GameValueEffect gameValueEffect = this.endlessLevel.effects[b];
/*     */         
/* 402 */         boolean bool = false;
/* 403 */         for (Array.ArrayIterator<GameValueManager.GameValueEffect> arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 404 */           if ((gameValueEffect1 = arrayIterator.next()).type == gameValueEffect.type) {
/*     */             
/* 406 */             gameValueEffect1.delta += gameValueEffect.delta * j;
/* 407 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 411 */         if (!bool)
/*     */         {
/* 413 */           array.add(new GameValueManager.GameValueEffect(gameValueEffect.type, gameValueEffect.delta * j));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 418 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isMaxNormalLevel() {
/* 425 */     return (this.endlessOnly || getInstalledLevel() >= this.levels.length);
/*     */   }
/*     */   
/*     */   public final boolean isMaxEndlessLevel() {
/* 429 */     return (getInstalledLevel() >= this.maxEndlessLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final TowerType getRelatedToTowerType() {
/* 436 */     return this.relatedToTowerType;
/*     */   }
/*     */   
/*     */   public final boolean isUnlocksTower() {
/* 440 */     return this.unlocksTower;
/*     */   }
/*     */   
/*     */   public static final class ResearchLink
/*     */   {
/*     */     public final Research parent;
/*     */     public final Research child;
/*     */     public final int requiredLevels;
/*     */     public int pivotX;
/*     */     public int pivotY;
/*     */     public final float requiredLevelsLabelPos;
/*     */     public final int requiredLevelsLabelX;
/*     */     public final int requiredLevelsLabelY;
/*     */     
/*     */     public ResearchLink(Research param1Research1, Research param1Research2, int param1Int1, int param1Int2, int param1Int3, float param1Float) {
/* 455 */       this.parent = param1Research1;
/* 456 */       this.child = param1Research2;
/* 457 */       this.requiredLevels = param1Int1;
/* 458 */       this.pivotX = param1Int2;
/* 459 */       this.pivotY = param1Int3;
/* 460 */       this.requiredLevelsLabelPos = param1Float;
/*     */ 
/*     */       
/* 463 */       float f1 = PMath.getDistanceBetweenPoints(param1Research2.x, param1Research2.y, param1Int2, param1Int3);
/* 464 */       float f2 = PMath.getDistanceBetweenPoints(param1Research1.x, param1Research1.y, param1Int2, param1Int3);
/* 465 */       float f3 = f1 + f2;
/*     */ 
/*     */       
/* 468 */       if ((param1Float = param1Float * f3) < f1) {
/*     */         
/* 470 */         f1 = param1Float / f1;
/* 471 */         this.requiredLevelsLabelX = (int)(param1Research2.x + (param1Int2 - param1Research2.x) * f1);
/* 472 */         this.requiredLevelsLabelY = (int)(param1Research2.y + (param1Int3 - param1Research2.y) * f1);
/*     */         return;
/*     */       } 
/* 475 */       f1 = (param1Float - f1) / f2;
/* 476 */       this.requiredLevelsLabelX = (int)(param1Int2 + (param1Research1.x - param1Int2) * f1);
/* 477 */       this.requiredLevelsLabelY = (int)(param1Int3 + (param1Research1.y - param1Int3) * f1);
/*     */     }
/*     */ 
/*     */     
/*     */     public static ResearchLink fromJson(l param1l) {
/* 482 */       Research research1 = null;
/* 483 */       Research research2 = null;
/* 484 */       int i = 1;
/* 485 */       float f = 0.5F;
/* 486 */       int j = 0;
/* 487 */       int k = 0;
/*     */       
/* 489 */       while (param1l.g() != o.c) {
/*     */         String str;
/*     */         
/* 492 */         switch (str = param1l.u()) {
/*     */           case "parent":
/* 494 */             research1 = Game.i.researchManager.getInstancePreSetup(ResearchType.valueOf(param1l.i()));
/*     */             continue;
/*     */           
/*     */           case "child":
/* 498 */             research2 = Game.i.researchManager.getInstancePreSetup(ResearchType.valueOf(param1l.i()));
/*     */             continue;
/*     */           
/*     */           case "requiredLevels":
/* 502 */             i = param1l.b(i);
/*     */             continue;
/*     */           
/*     */           case "requiredLevelsLabelPos":
/* 506 */             param1l.g();
/* 507 */             f = param1l.J();
/*     */             continue;
/*     */           
/*     */           case "pivotX":
/* 511 */             j = param1l.b(j);
/*     */             continue;
/*     */           
/*     */           case "pivotY":
/* 515 */             k = param1l.b(k);
/*     */             continue;
/*     */         } 
/*     */         
/* 519 */         Research.a().i("skip link field " + str, new Object[0]);
/* 520 */         param1l.g();
/* 521 */         param1l.j();
/*     */       } 
/*     */ 
/*     */       
/* 525 */       if (research1 == null) {
/* 526 */         throw new IllegalArgumentException("Link parent not set");
/*     */       }
/* 528 */       if (research2 == null) {
/* 529 */         throw new IllegalArgumentException("Link child not set");
/*     */       }
/* 531 */       return new ResearchLink(research1, research2, i, j, k, f);
/*     */     }
/*     */     
/*     */     public final boolean isVisible() {
/* 535 */       return (this.requiredLevels <= this.parent.getInstalledLevel());
/*     */     } }
/*     */   
/*     */   public static class ResearchLevel {
/*     */     public int number;
/*     */     public int researchDuration;
/*     */     
/*     */     public ResearchLevel() {
/* 543 */       this.price = new Array(ItemStack.class);
/*     */     }
/*     */     public GameValueManager.GameValueEffect[] effects; public Array<ItemStack> price; public Requirement[] requirements;
/*     */     public static ResearchLevel fromJson(l param1l) {
/* 547 */       ResearchLevel researchLevel = new ResearchLevel();
/*     */       
/* 549 */       Array array1 = new Array(GameValueManager.GameValueEffect.class);
/* 550 */       Array array2 = new Array(Requirement.class);
/*     */       
/* 552 */       while (param1l.g() != o.c) {
/*     */ 
/*     */         
/* 555 */         switch (null = param1l.u()) {
/*     */           case "effects":
/* 557 */             param1l.g();
/* 558 */             while (param1l.g() != o.c) {
/* 559 */               null = param1l.u();
/*     */               
/* 561 */               param1l.g();
/* 562 */               double d = param1l.K();
/*     */               
/*     */               try {
/* 565 */                 GameValueType gameValueType = GameValueType.valueOf(null);
/* 566 */                 array1.add(new GameValueManager.GameValueEffect(gameValueType, d));
/* 567 */               } catch (Exception exception) {
/* 568 */                 Research.a().e("failed loading gv " + null, new Object[] { exception });
/*     */               } 
/*     */             } 
/*     */ 
/*     */           
/*     */           case "price":
/* 574 */             param1l.g();
/* 575 */             while (param1l.g() != o.c) {
/* 576 */               BlueprintType blueprintType; null = param1l.u();
/*     */               
/* 578 */               int i = param1l.b(0);
/* 579 */               switch (null) {
/*     */                 case "money":
/* 581 */                   researchLevel.price.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*     */                   continue;
/*     */                 
/*     */                 case "PRESTIGE_TOKEN":
/* 585 */                   researchLevel.price.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, i));
/*     */                   continue;
/*     */                 
/*     */                 case "ACCELERATOR":
/* 589 */                   researchLevel.price.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*     */                   continue;
/*     */                 
/*     */                 case "BIT_DUST":
/* 593 */                   researchLevel.price.add(new ItemStack((Item)Item.D.BIT_DUST, i));
/*     */                   continue;
/*     */               } 
/*     */               
/* 597 */               if (null.startsWith("bp_")) {
/*     */                 
/* 599 */                 blueprintType = BlueprintType.valueOf(null.substring(3));
/* 600 */                 researchLevel.price.add(new ItemStack((Item)Item.D.F_BLUEPRINT.create(blueprintType), i));
/*     */                 continue;
/*     */               } 
/* 603 */               researchLevel.price.add(new ItemStack((Item)Item.D.F_RESOURCE.create(ResourceType.valueOf((String)blueprintType)), i));
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case "requirements":
/* 611 */             param1l.g();
/* 612 */             while (param1l.g() != o.e) {
/* 613 */               array2.add(Requirement.fromJson(param1l));
/*     */             }
/*     */ 
/*     */           
/*     */           case "researchDuration":
/* 618 */             researchLevel.researchDuration = param1l.b(0);
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 623 */       researchLevel.requirements = (Requirement[])array2.toArray();
/* 624 */       researchLevel.effects = (GameValueManager.GameValueEffect[])array1.toArray();
/*     */       
/* 626 */       return researchLevel;
/*     */     }
/*     */   }
/*     */   
/* 630 */   private static final Array<ItemStack> e = new Array(ItemStack.class);
/*     */   private static int b(int paramInt) {
/* 632 */     if (paramInt < 10)
/* 633 */       return paramInt; 
/* 634 */     if (paramInt < 100)
/* 635 */       return paramInt / 5 * 5; 
/* 636 */     if (paramInt < 1000) {
/* 637 */       return paramInt / 10 * 10;
/*     */     }
/* 639 */     return paramInt / 50 * 50;
/*     */   }
/*     */   
/*     */   public class EndlessResearchLevel
/*     */   {
/*     */     public final GameValueManager.GameValueEffect[] effects;
/*     */     public final int priceBase;
/*     */     public final int randomSeed;
/*     */     public final int prestigeTokens;
/*     */     public BlueprintType blueprintType;
/*     */     
/*     */     public EndlessResearchLevel(Research this$0, int param1Int1, int param1Int2, BlueprintType param1BlueprintType, int param1Int3, GameValueManager.GameValueEffect[] param1ArrayOfGameValueEffect) {
/* 651 */       this.prestigeTokens = param1Int3;
/* 652 */       this.priceBase = param1Int1;
/* 653 */       this.randomSeed = param1Int2;
/* 654 */       this.effects = param1ArrayOfGameValueEffect;
/* 655 */       this.blueprintType = param1BlueprintType;
/*     */     }
/*     */     
/*     */     public Array<ItemStack> getPrice(int param1Int) {
/* 659 */       int i = this.a.levels.length;
/*     */       
/* 661 */       if (param1Int <= i) {
/* 662 */         throw new IllegalArgumentException("level must be > " + i);
/*     */       }
/*     */       
/* 665 */       Research.b().clear();
/*     */       
/* 667 */       int j = Math.min(this.a.endlessPriceLevel, param1Int);
/* 668 */       FastRandom.random.setSeed((this.randomSeed * 31 + param1Int));
/*     */       
/* 670 */       if (this.prestigeTokens > 0) {
/* 671 */         int k = this.prestigeTokens + MathUtils.ceil((float)(this.prestigeTokens * 0.1D * (j - 1)));
/* 672 */         if (param1Int > this.a.endlessPriceLevel)
/*     */         {
/* 674 */           k += (int)(k * 0.025F * (param1Int - this.a.endlessPriceLevel));
/*     */         }
/*     */         
/* 677 */         Research.b().add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, k));
/*     */       } else {
/* 679 */         BlueprintType blueprintType; int n = FastRandom.random.nextInt(2);
/*     */ 
/*     */         
/* 682 */         j -= i;
/* 683 */         float f2 = 1.0F + j * (0.0085F + FastRandom.random.nextFloat() * 0.0015F);
/* 684 */         float f1 = 1.0F + j / i * 0.2F;
/*     */         
/* 686 */         int k = (int)StrictMath.pow(StrictMath.pow((this.priceBase * f1), f2) * 0.6D, this.a.endlessPriceExp);
/* 687 */         if (param1Int > this.a.endlessPriceLevel)
/*     */         {
/* 689 */           k += (int)(k * 0.075F * (param1Int - this.a.endlessPriceLevel));
/*     */         }
/*     */         
/* 692 */         j = Research.a((int)(((n == 0) ? (k * 1.3F) : k) * 1.4F));
/* 693 */         Research.b().add(new ItemStack((Item)Item.D.GREEN_PAPER, j));
/*     */ 
/*     */         
/* 696 */         ResourceType resourceType = ResourceType.values[FastRandom.random.nextInt(ResourceType.values.length)];
/* 697 */         if (FastRandom.random.nextFloat() < 0.25F)
/*     */         {
/* 699 */           resourceType = ResourceType.INFIAR;
/*     */         }
/* 701 */         double d = StrictMath.pow((((n == 1) ? (k * 1.3F) : k) * 0.5F), (0.99F + FastRandom.random.nextFloat() * 0.02F)) * 0.25D;
/*     */         
/* 703 */         switch (Research.null.a[resourceType.ordinal()]) {
/*     */           case 1:
/* 705 */             Research.b().add(new ItemStack((Item)Item.D.RESOURCE_SCALAR, Research.a((int)(d * 1.5D))));
/*     */             break;
/*     */           
/*     */           case 2:
/* 709 */             Research.b().add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, Research.a((int)(d * 1.25D))));
/*     */             break;
/*     */           
/*     */           case 3:
/* 713 */             Research.b().add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, Research.a((int)d)));
/*     */             break;
/*     */           
/*     */           case 4:
/* 717 */             Research.b().add(new ItemStack((Item)Item.D.RESOURCE_TENSOR, Research.a((int)(d * 0.9D))));
/*     */             break;
/*     */           
/*     */           case 5:
/* 721 */             Research.b().add(new ItemStack((Item)Item.D.RESOURCE_INFIAR, Research.a((int)(d * 0.8D))));
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 727 */         int m = 6500 + FastRandom.random.nextInt(1200);
/* 728 */         if (k > m) {
/*     */           
/* 730 */           if ((m = (k - m) / (550 + FastRandom.random.nextInt(150))) <= 0) m = 1;
/*     */           
/* 732 */           m = Research.a(m);
/* 733 */           Research.b().add(new ItemStack((Item)Item.D.BIT_DUST, m));
/*     */         } 
/*     */ 
/*     */         
/* 737 */         if (this.blueprintType != null) {
/* 738 */           BlueprintItem blueprintItem = Item.D.F_BLUEPRINT.create(this.blueprintType);
/* 739 */           param1Int += (int)(k * 5.0E-4D);
/* 740 */           Research.b().add(new ItemStack((Item)blueprintItem, param1Int));
/*     */         } 
/*     */         
/* 743 */         m = 0;
/* 744 */         for (param1Int = 0; param1Int < 54 && 
/* 745 */           k > 7000 + param1Int * (2000 + param1Int * 500); param1Int++) {
/* 746 */           m++;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 752 */         if (m >= 27) {
/* 753 */           blueprintType = BlueprintType.SPECIAL_IV;
/* 754 */           m /= 27;
/* 755 */         } else if (m >= 9) {
/* 756 */           blueprintType = BlueprintType.SPECIAL_III;
/* 757 */           m /= 9;
/* 758 */         } else if (m >= 3) {
/* 759 */           blueprintType = BlueprintType.SPECIAL_II;
/* 760 */           m /= 3;
/*     */         } else {
/* 762 */           blueprintType = BlueprintType.SPECIAL_I;
/*     */         } 
/* 764 */         if (m != 0) {
/* 765 */           BlueprintItem blueprintItem = Item.D.F_BLUEPRINT.create(blueprintType);
/* 766 */           Research.b().add(new ItemStack((Item)blueprintItem, m));
/*     */         } 
/*     */       } 
/*     */       
/* 770 */       FastRandom.random.setSeed(FastRandom.getInt(10000));
/*     */       
/* 772 */       return Research.b();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Research.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */