/*      */ package com.prineside.tdi2.tiles;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Animation;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.IntIntMap;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemDataType;
/*      */ import com.prineside.tdi2.enums.ItemSortingType;
/*      */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*      */ import com.prineside.tdi2.enums.PredefinedCoreTileType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TriggeredActionType;
/*      */ import com.prineside.tdi2.managers.AssetManager;
/*      */ import com.prineside.tdi2.managers.GameValueManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*      */ import com.prineside.tdi2.ui.actors.AnimatedImage;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*      */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ @REGS
/*      */ public final class CoreTile extends Tile {
/*   72 */   private static final TLog c = TLog.forClass(CoreTile.class);
/*      */   
/*      */   public static final int MAX_LEVEL = 256;
/*      */   public static final int FIXED_LEVEL_XP_REQUIREMENT = 1000;
/*      */   public static final int[] LEVEL_EXPERIENCE;
/*      */   
/*      */   static {
/*   79 */     (LEVEL_EXPERIENCE = new int[257])[0] = 0;
/*   80 */     LEVEL_EXPERIENCE[1] = 0; int i;
/*   81 */     for (i = 2; i < 257; i++) {
/*   82 */       LEVEL_EXPERIENCE[i] = (i - 2) * 10 + (i - 2) / 10 * 10 + 180;
/*      */     }
/*      */   }
/*      */   
/*   86 */   public static final int[] LEVEL_EXPERIENCE_MILESTONES = new int[257];
/*      */   static {
/*   88 */     i = 0;
/*   89 */     for (byte b = 0; b <= 'Ā'; b++) {
/*   90 */       i += LEVEL_EXPERIENCE[b];
/*   91 */       LEVEL_EXPERIENCE_MILESTONES[b] = i;
/*      */     } 
/*      */   }
/*      */   
/*   95 */   private static final Color[] d = new Color[] { MaterialColor.RED.P500, MaterialColor.PINK.P500, MaterialColor.PURPLE.P400, MaterialColor.DEEP_PURPLE.P300, MaterialColor.BLUE.P500, MaterialColor.CYAN.P500, MaterialColor.GREEN.P500, MaterialColor.LIME.P500, MaterialColor.YELLOW.P500, MaterialColor.ORANGE.P500 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public enum Tier
/*      */   {
/*  110 */     REGULAR,
/*  111 */     RARE,
/*  112 */     LEGENDARY;
/*      */     
/*  114 */     public static final Tier[] values = values();
/*      */     static {
/*      */     
/*  117 */     } } public static final int[] TIER_COLS = new int[] { 3, 4, 4 };
/*  118 */   public static final int[] TIER_ROWS = new int[] { 4, 4, 5 };
/*      */   
/*      */   @REGS
/*      */   public enum LinkDirection {
/*  122 */     TOP_LEFT,
/*  123 */     TOP,
/*  124 */     TOP_RIGHT,
/*  125 */     LEFT,
/*  126 */     RIGHT,
/*  127 */     BOTTOM_LEFT,
/*  128 */     BOTTOM,
/*  129 */     BOTTOM_RIGHT;
/*      */     
/*  131 */     public static final LinkDirection[] values = values(); static {
/*      */     
/*      */     } public static LinkDirection getOpposite(LinkDirection param1LinkDirection) {
/*  134 */       switch (CoreTile.null.a[param1LinkDirection.ordinal()]) { case 1:
/*  135 */           return BOTTOM;
/*  136 */         case 2: return RIGHT;
/*  137 */         case 3: return LEFT;
/*  138 */         case 4: return TOP;
/*  139 */         case 5: return BOTTOM_RIGHT;
/*  140 */         case 6: return BOTTOM_LEFT;
/*  141 */         case 7: return TOP_RIGHT;
/*  142 */         case 8: return TOP_LEFT; }
/*  143 */        return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public static int getDeltaCol(LinkDirection param1LinkDirection) {
/*  148 */       if (param1LinkDirection == LEFT || param1LinkDirection == TOP_LEFT || param1LinkDirection == BOTTOM_LEFT)
/*  149 */         return -1; 
/*  150 */       if (param1LinkDirection == RIGHT || param1LinkDirection == TOP_RIGHT || param1LinkDirection == BOTTOM_RIGHT) {
/*  151 */         return 1;
/*      */       }
/*  153 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public static int getDeltaRow(LinkDirection param1LinkDirection) {
/*  158 */       if (param1LinkDirection == BOTTOM || param1LinkDirection == BOTTOM_LEFT || param1LinkDirection == BOTTOM_RIGHT)
/*  159 */         return 1; 
/*  160 */       if (param1LinkDirection == TOP || param1LinkDirection == TOP_LEFT || param1LinkDirection == TOP_RIGHT) {
/*  161 */         return -1;
/*      */       }
/*  163 */       return 0;
/*      */     }
/*      */   }
/*      */   
/*  167 */   public static final int[] LINK_DIRECTION_BITS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128 };
/*      */   
/*  169 */   public PredefinedCoreTileType predefinedType = null;
/*      */ 
/*      */   
/*  172 */   private String e = "";
/*      */   private String f;
/*  174 */   private Tier g = Tier.REGULAR;
/*  175 */   private float h = 1.0F;
/*      */   private boolean i = false;
/*  177 */   private Array<Upgrade> j = new Array(Upgrade.class);
/*      */   @NAGS
/*  179 */   private int k = -1;
/*  180 */   private static final Color[] l = new Color[4];
/*      */   
/*      */   @NAGS
/*  183 */   public float timeDrawn = 0.0F; @NAGS
/*      */   public ParticleEffectPool.PooledEffect upgradeAvailableParticleEffect;
/*  185 */   public float doubleSpeedTimeLeft = 0.0F;
/*  186 */   private int m = 1;
/*      */   private float n;
/*      */   private float o;
/*      */   private float p;
/*  190 */   private IntIntMap q = new IntIntMap();
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  194 */     super.write(paramKryo, paramOutput);
/*  195 */     paramKryo.writeObjectOrNull(paramOutput, this.predefinedType, PredefinedCoreTileType.class);
/*  196 */     paramKryo.writeObject(paramOutput, this.e);
/*  197 */     paramKryo.writeObjectOrNull(paramOutput, this.f, String.class);
/*  198 */     paramKryo.writeObject(paramOutput, this.g);
/*  199 */     paramOutput.writeFloat(this.h);
/*  200 */     paramOutput.writeBoolean(this.i);
/*  201 */     paramKryo.writeObject(paramOutput, this.j);
/*  202 */     paramOutput.writeFloat(this.doubleSpeedTimeLeft);
/*  203 */     paramOutput.writeVarInt(this.m, true);
/*  204 */     paramOutput.writeFloat(this.n);
/*  205 */     paramOutput.writeFloat(this.o);
/*  206 */     paramOutput.writeFloat(this.p);
/*  207 */     paramKryo.writeObject(paramOutput, this.q);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  212 */     super.read(paramKryo, paramInput);
/*  213 */     this.predefinedType = (PredefinedCoreTileType)paramKryo.readObjectOrNull(paramInput, PredefinedCoreTileType.class);
/*  214 */     this.e = (String)paramKryo.readObject(paramInput, String.class);
/*  215 */     this.f = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  216 */     this.g = (Tier)paramKryo.readObject(paramInput, Tier.class);
/*  217 */     this.h = paramInput.readFloat();
/*  218 */     this.i = paramInput.readBoolean();
/*  219 */     this.j = (Array<Upgrade>)paramKryo.readObject(paramInput, Array.class);
/*  220 */     this.doubleSpeedTimeLeft = paramInput.readFloat();
/*  221 */     this.m = paramInput.readVarInt(true);
/*  222 */     this.n = paramInput.readFloat();
/*  223 */     this.o = paramInput.readFloat();
/*  224 */     this.p = paramInput.readFloat();
/*  225 */     this.q = (IntIntMap)paramKryo.readObject(paramInput, IntIntMap.class);
/*      */   }
/*      */   private CoreTile() {
/*  228 */     super(TileType.CORE);
/*      */   }
/*      */   
/*      */   public final void getData(IntArray paramIntArray) {
/*  232 */     if (this.predefinedType != null) paramIntArray.add(ItemDataType.TILE_PREDEFINED_CORE_TYPE.ordinal(), this.predefinedType.ordinal());
/*      */   
/*      */   }
/*      */   
/*      */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  237 */     super.setRegistered(paramGameSystemProvider);
/*      */     
/*  239 */     setExperience(this.n);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float getExperienceGeneration() {
/*  247 */     if (this.predefinedType == null) return this.h;
/*      */     
/*  249 */     return (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).h;
/*      */   }
/*      */   
/*      */   public final void setExperienceGeneration(float paramFloat) {
/*  253 */     if (this.predefinedType != null) throw new IllegalStateException("can't edit predefined core");
/*      */     
/*  255 */     this.h = paramFloat;
/*  256 */     this.k = -1;
/*      */   }
/*      */   
/*      */   public final boolean isXpLevelRequirementFixed() {
/*  260 */     return this.i;
/*      */   }
/*      */   
/*      */   public final void setXpLevelRequirementFixed(boolean paramBoolean) {
/*  264 */     this.i = paramBoolean;
/*  265 */     this.k = -1;
/*      */   }
/*      */   
/*      */   public final String getName() {
/*  269 */     if (this.predefinedType != null) {
/*  270 */       return (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).e;
/*      */     }
/*  272 */     return this.e;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Tier getTier() {
/*  277 */     if (this.predefinedType != null) {
/*  278 */       return (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).g;
/*      */     }
/*  280 */     return this.g;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setTier(Tier paramTier) {
/*  285 */     if (this.predefinedType != null) throw new IllegalStateException("can't edit predefined core");
/*      */     
/*  287 */     this.g = paramTier;
/*      */     
/*  289 */     this.k = -1;
/*      */   }
/*      */   
/*      */   public final void setTierKeepLayout(Tier paramTier) {
/*  293 */     if (this.predefinedType != null) throw new IllegalStateException("can't edit predefined core");
/*      */     
/*  295 */     if (this.g != paramTier) {
/*      */       
/*  297 */       int i = TIER_COLS[this.g.ordinal()];
/*  298 */       int j = TIER_ROWS[this.g.ordinal()];
/*  299 */       int k = TIER_COLS[paramTier.ordinal()];
/*  300 */       int m = TIER_ROWS[paramTier.ordinal()];
/*  301 */       if (i != k) {
/*  302 */         Upgrade[][] arrayOfUpgrade = new Upgrade[j][i]; byte b;
/*  303 */         for (b = 0; b < j; b++) {
/*  304 */           for (byte b1 = 0; b1 < i; b1++) {
/*  305 */             int n = getUpgradeIdx(this.g, b1, b);
/*      */             Upgrade upgrade;
/*  307 */             if ((upgrade = (Upgrade)((this.j.size > n) ? this.j.get(n) : null)) != null) {
/*  308 */               arrayOfUpgrade[b][b1] = upgrade.cloneUpgrade();
/*      */             }
/*      */           } 
/*      */         } 
/*  312 */         this.j.clear();
/*  313 */         this.j.setSize(k * m);
/*      */         
/*  315 */         for (b = 0; b < m; b++) {
/*  316 */           for (byte b1 = 0; b1 < k; b1++) {
/*  317 */             Upgrade upgrade; if (b < arrayOfUpgrade.length && b1 < (arrayOfUpgrade[b]).length && (
/*      */               
/*  319 */               upgrade = arrayOfUpgrade[b][b1]) != null) {
/*  320 */               int n = getUpgradeIdx(paramTier, b1, b);
/*  321 */               this.j.set(n, upgrade);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  328 */       this.g = paramTier;
/*      */       
/*  330 */       this.k = -1;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void addSellItems(Array<ItemStack> paramArray) {
/*  336 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, ((getTier().ordinal() << 1) + 2) * 500));
/*      */     
/*  338 */     switch (null.b[getTier().ordinal()]) {
/*      */       case 1:
/*  340 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_SCALAR, 200));
/*  341 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, 100));
/*      */         return;
/*      */       
/*      */       case 2:
/*  345 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_VECTOR, 200));
/*  346 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, 100));
/*  347 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_TENSOR, 50));
/*      */         return;
/*      */       
/*      */       case 3:
/*  351 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_MATRIX, 200));
/*  352 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_TENSOR, 100));
/*  353 */         paramArray.add(new ItemStack((Item)Item.D.RESOURCE_INFIAR, 50));
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final double getPrestigeScore() {
/*  361 */     switch (null.c[getRarity().ordinal()]) { case 1:
/*  362 */         return 0.05D;
/*  363 */       case 2: return 0.6D;
/*  364 */       case 3: return 7.5D; }
/*      */     
/*  366 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public final Array<Upgrade> getUpgrades() {
/*  370 */     if (this.predefinedType != null) {
/*  371 */       return (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).j;
/*      */     }
/*  373 */     return this.j;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final CharSequence getTitle() {
/*  379 */     return getName();
/*      */   }
/*      */   
/*      */   public final void setName(String paramString) {
/*  383 */     if (this.predefinedType != null) throw new IllegalStateException("can't edit predefined core");
/*      */     
/*  385 */     this.e = paramString;
/*      */   }
/*      */   
/*      */   public final String getIcon() {
/*  389 */     if (this.predefinedType != null) {
/*  390 */       return (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).f;
/*      */     }
/*  392 */     return this.f;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setIcon(String paramString) {
/*  397 */     if (this.predefinedType != null) throw new IllegalStateException("can't edit predefined core");
/*      */     
/*  399 */     this.f = paramString;
/*  400 */     this.k = -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public final CharSequence getDescription() {
/*  405 */     return Game.i.tileManager.F.CORE.getTierDescription(getTier());
/*      */   }
/*      */ 
/*      */   
/*      */   public final RarityType getRarity() {
/*  410 */     switch (null.b[getTier().ordinal()]) { case 1:
/*  411 */         return RarityType.VERY_RARE;
/*  412 */       case 2: return RarityType.EPIC;
/*  413 */       case 3: return RarityType.LEGENDARY; }
/*      */ 
/*      */     
/*  416 */     return RarityType.COMMON;
/*      */   }
/*      */   
/*      */   public final int getUpgradeCols() {
/*  420 */     return TIER_COLS[getTier().ordinal()];
/*      */   }
/*      */   
/*      */   public final int getUpgradeRows() {
/*  424 */     return TIER_ROWS[getTier().ordinal()];
/*      */   }
/*      */   
/*      */   public final boolean isValidUpgradePos(int paramInt1, int paramInt2) {
/*  428 */     Tier tier = getTier();
/*  429 */     return (paramInt1 >= 0 && paramInt1 < TIER_COLS[tier.ordinal()] && paramInt2 >= 0 && paramInt2 < TIER_ROWS[tier.ordinal()]);
/*      */   }
/*      */   
/*      */   public final float getExperience() {
/*  433 */     return this.n;
/*      */   }
/*      */   
/*      */   public final int getLevel() {
/*  437 */     return this.m;
/*      */   }
/*      */   
/*      */   public final float getNextLevelExperience() {
/*  441 */     return this.o;
/*      */   }
/*      */   
/*      */   public final float getCurrentLevelExperience() {
/*  445 */     return this.p;
/*      */   }
/*      */   
/*      */   public final int getUpgradeInstallLevelByIdx(int paramInt) {
/*  449 */     return this.q.get(paramInt, 0);
/*      */   }
/*      */   
/*      */   public final int getUpgradeInstallLevel(int paramInt1, int paramInt2) {
/*  453 */     return getUpgradeInstallLevelByIdx(getUpgradeIdx(getTier(), paramInt1, paramInt2));
/*      */   }
/*      */   
/*      */   public final void setUpgradeInstallLevel(int paramInt1, int paramInt2, int paramInt3) {
/*  457 */     if (paramInt3 != 0) {
/*  458 */       this.q.put(getUpgradeIdx(getTier(), paramInt1, paramInt2), paramInt3); return;
/*      */     } 
/*  460 */     this.q.remove(getUpgradeIdx(getTier(), paramInt1, paramInt2), 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean hasSomethingToUpgrade() {
/*  465 */     int i = getFreeUpgradePoints();
/*      */     
/*  467 */     int j = getUpgradeCols();
/*  468 */     int k = getUpgradeRows();
/*      */     
/*  470 */     int m = this.S.gameState.getMoney();
/*  471 */     for (byte b = 0; b < k; b++) {
/*  472 */       for (byte b1 = 0; b1 < j; b1++) {
/*      */         Upgrade upgrade;
/*  474 */         if ((upgrade = getUpgrade(b1, b)) != null) {
/*      */           int n;
/*      */           
/*  477 */           if ((n = getUpgradeInstallLevel(b1, b)) < upgrade.upgradeLevels.size) {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  482 */             Upgrade.UpgradeLevel upgradeLevel = ((Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[n];
/*      */             
/*      */             boolean bool;
/*  485 */             if ((bool = upgrade.costsCoins ? ((upgradeLevel.price <= m) ? true : false) : ((upgradeLevel.price <= i) ? true : false)) && canUpgradeBeInstalled(b1, b))
/*  486 */               return true; 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  491 */     return false;
/*      */   }
/*      */   
/*      */   public final int getFreeUpgradePoints() {
/*  495 */     int i = getLevel() - 1;
/*  496 */     int j = 0;
/*      */     
/*  498 */     int k = getUpgradeCols();
/*  499 */     int m = getUpgradeRows();
/*  500 */     for (byte b = 0; b < m; b++) {
/*  501 */       for (byte b1 = 0; b1 < k; b1++) {
/*      */         Upgrade upgrade;
/*  503 */         if ((upgrade = getUpgrade(b1, b)) != null && !upgrade.costsCoins) {
/*      */           
/*  505 */           int n = getUpgradeInstallLevel(b1, b);
/*  506 */           for (byte b2 = 0; b2 < n; b2++) {
/*  507 */             j += (((Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[b2]).price;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  512 */     return i - j;
/*      */   }
/*      */   
/*      */   private int a(int paramInt) {
/*  516 */     if (this.i) {
/*  517 */       return (paramInt - 1) * 1000;
/*      */     }
/*  519 */     return LEVEL_EXPERIENCE_MILESTONES[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setExperience(float paramFloat) {
/*  528 */     this.n = paramFloat;
/*      */     
/*  530 */     if (this.m != 256) {
/*      */       
/*  532 */       for (int i = this.m + 1; i <= 256 && 
/*  533 */         (int)this.n >= a(i); i++)
/*      */       {
/*  535 */         this.m = i;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  543 */       if (this.m != 256) {
/*      */         
/*  545 */         if (this.i) {
/*  546 */           this.o = 1000.0F;
/*      */         } else {
/*  548 */           this.o = LEVEL_EXPERIENCE[this.m + 1];
/*      */         } 
/*      */       } else {
/*      */         
/*  552 */         this.o = 0.0F;
/*      */       } 
/*      */     } 
/*      */     
/*  556 */     this.p = this.n - a(this.m);
/*      */   }
/*      */   
/*      */   public static int getUpgradeIdx(Tier paramTier, int paramInt1, int paramInt2) {
/*  560 */     int j = TIER_COLS[paramTier.ordinal()];
/*  561 */     int i = TIER_ROWS[paramTier.ordinal()];
/*  562 */     if (paramInt1 < 0 || paramInt1 >= j) throw new IllegalArgumentException("core tier has max " + (j - 1) + " col idx, " + paramInt1 + " given"); 
/*  563 */     if (paramInt2 < 0 || paramInt2 >= i) throw new IllegalArgumentException("core tier has max " + (i - 1) + " row idx, " + paramInt2 + " given");
/*      */     
/*  565 */     return paramInt2 * j + paramInt1;
/*      */   }
/*      */   
/*      */   public final Upgrade getUpgrade(int paramInt1, int paramInt2) {
/*  569 */     Array<Upgrade> array = (this.predefinedType == null) ? this.j : (CoreTileFactory.a(Game.i.tileManager.F.CORE)[this.predefinedType.ordinal()]).j;
/*      */     
/*  571 */     paramInt1 = getUpgradeIdx(getTier(), paramInt1, paramInt2);
/*  572 */     if (array.size > paramInt1) {
/*  573 */       return ((Upgrade[])array.items)[paramInt1];
/*      */     }
/*  575 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private int b() {
/*  580 */     if (this.k == -1) {
/*  581 */       this.k = generateSeedSalt();
/*      */     }
/*      */     
/*  584 */     return this.k;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean canUpgradeBeInstalled(int paramInt1, int paramInt2) {
/*      */     Upgrade upgrade;
/*  591 */     if ((upgrade = getUpgrade(paramInt1, paramInt2)).starting)
/*      */     {
/*  593 */       return true;
/*      */     }
/*      */     
/*  596 */     int i = getUpgradeCols();
/*  597 */     int j = getUpgradeRows(); LinkDirection[] arrayOfLinkDirection; int k;
/*      */     byte b;
/*  599 */     for (k = (arrayOfLinkDirection = LinkDirection.values).length, b = 0; b < k; b++) {
/*      */       LinkDirection linkDirection;
/*  601 */       int m = LinkDirection.getDeltaCol(linkDirection = arrayOfLinkDirection[b]) + paramInt1;
/*  602 */       int n = LinkDirection.getDeltaRow(linkDirection) + paramInt2; Upgrade upgrade1;
/*  603 */       if (m >= 0 && m < i && n >= 0 && n < j && (
/*      */         
/*  605 */         upgrade1 = getUpgrade(m, n)) != null && 
/*  606 */         getUpgradeInstallLevel(m, n) != 0)
/*      */       {
/*  608 */         if (upgrade1.hasLink(LinkDirection.getOpposite(linkDirection)))
/*      */         {
/*  610 */           return true;
/*      */         }
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  618 */     return false;
/*      */   }
/*      */   
/*      */   public final void setUpgrade(int paramInt1, int paramInt2, Upgrade paramUpgrade) {
/*  622 */     if (this.predefinedType != null) throw new IllegalStateException("Can't change upgrades of predefined Cores");
/*      */     
/*  624 */     paramInt1 = getUpgradeIdx(getTier(), paramInt1, paramInt2);
/*  625 */     while (this.j.size <= paramInt1) {
/*  626 */       this.j.add(null);
/*      */     }
/*  628 */     this.j.set(paramInt1, paramUpgrade);
/*      */     
/*  630 */     this.k = -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int generateSeedSalt() {
/*  639 */     int i = (i = (i = 31 + ((this.predefinedType == null) ? 0 : this.predefinedType.ordinal())) * 31 + getTier().ordinal()) * 31 + (int)(getExperienceGeneration() * 100.0F);
/*      */     
/*  641 */     Array<Upgrade> array = getUpgrades();
/*  642 */     for (byte b = 0; b < array.size; b++) {
/*  643 */       if (((Upgrade[])array.items)[b] == null) {
/*  644 */         i *= 31;
/*      */       } else {
/*  646 */         i = i * 31 + ((Upgrade[])array.items)[b].generateHash();
/*      */       } 
/*      */     } 
/*      */     
/*  650 */     return i;
/*      */   }
/*      */   
/*      */   public final Color[] getBaseColors() {
/*  654 */     FastRandom.random.setSeed(b());
/*  655 */     l[0] = d[FastRandom.random.nextInt(d.length)];
/*  656 */     l[1] = d[FastRandom.random.nextInt(d.length)];
/*  657 */     l[2] = d[FastRandom.random.nextInt(d.length)];
/*  658 */     l[3] = d[FastRandom.random.nextInt(d.length)];
/*      */     
/*  660 */     return l;
/*      */   }
/*      */   
/*      */   public final Color getSphereColor() {
/*  664 */     switch (null.b[getTier().ordinal()]) { case 1:
/*  665 */         return MaterialColor.PURPLE.P500;
/*  666 */       case 2: return MaterialColor.ORANGE.P700;
/*  667 */       case 3: return MaterialColor.CYAN.P600; }
/*      */ 
/*      */     
/*  670 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean sameAs(Tile paramTile) {
/*  675 */     if (!super.sameAs(paramTile)) return false;
/*      */     
/*  677 */     paramTile = paramTile;
/*      */     
/*  679 */     if (this.predefinedType != null && ((CoreTile)paramTile).predefinedType == this.predefinedType) return true;
/*      */     
/*  681 */     if (((CoreTile)paramTile).predefinedType != this.predefinedType) return false; 
/*  682 */     if (((CoreTile)paramTile).g != this.g) return false; 
/*  683 */     if (!((CoreTile)paramTile).e.equals(this.e)) return false;
/*      */     
/*  685 */     if (((CoreTile)paramTile).f == null && this.f != null) return false; 
/*  686 */     if (((CoreTile)paramTile).f != null && this.f == null) return false; 
/*  687 */     if (this.f != null && !((CoreTile)paramTile).f.equals(this.f)) return false;
/*      */     
/*  689 */     if (((CoreTile)paramTile).h != this.h) return false; 
/*  690 */     if (((CoreTile)paramTile).i != this.i) return false; 
/*  691 */     if (((CoreTile)paramTile).j.size != this.j.size) return false;
/*      */     
/*  693 */     for (byte b = 0; b < this.j.size; b++) {
/*  694 */       if ((((Upgrade[])this.j.items)[b] == null && ((Upgrade[])((CoreTile)paramTile).j.items)[b] != null) || (((Upgrade[])this.j.items)[b] != null && ((Upgrade[])((CoreTile)paramTile).j.items)[b] == null) || (((Upgrade[])this.j.items)[b] != null && 
/*      */ 
/*      */         
/*  697 */         !((Upgrade[])this.j.items)[b].sameAs(((Upgrade[])((CoreTile)paramTile).j.items)[b])))
/*      */       {
/*  699 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  703 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap, MapRenderingSystem.DrawMode paramDrawMode) {
/*  708 */     super.drawStatic(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramMap, paramDrawMode);
/*      */     
/*  710 */     Color[] arrayOfColor = getBaseColors();
/*  711 */     for (byte b = 0; b < 4; b++) {
/*  712 */       if ((getTier() != Tier.REGULAR || (b != 0 && b != 1)) && (
/*  713 */         getTier() != Tier.RARE || (b != 2 && b != 3))) {
/*      */         
/*  715 */         paramBatch.setColor(arrayOfColor[b]);
/*  716 */         paramBatch.draw(CoreTileFactory.b(Game.i.tileManager.F.CORE)[b], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       } 
/*      */     } 
/*  719 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MapRenderingSystem.DrawMode paramDrawMode) {
/*  724 */     Preconditions.checkArgument((paramFloat1 >= 0.0F), "Delta time must be >= 0, %s provided", Float.valueOf(paramFloat1));
/*  725 */     this.timeDrawn += paramFloat1;
/*      */     
/*  727 */     paramFloat1 = paramFloat4 * 0.0078125F;
/*  728 */     paramFloat4 = paramFloat5 * 0.0078125F;
/*      */     
/*  730 */     paramBatch.setColor(getSphereColor());
/*      */     
/*  732 */     if (this.timeDrawn < 0.0F) {
/*  733 */       throw new IllegalStateException("timeDrawn is " + this.timeDrawn);
/*      */     }
/*      */     
/*  736 */     TextureRegion textureRegion = (TextureRegion)CoreTileFactory.c(Game.i.tileManager.F.CORE).getKeyFrame(this.timeDrawn, true);
/*  737 */     paramBatch.draw(textureRegion, paramFloat2 + 32.0F * paramFloat1, paramFloat3 + 32.0F * paramFloat4, 64.0F * paramFloat1, 64.0F * paramFloat4);
/*      */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/*      */     String str;
/*  740 */     if ((str = getIcon()) != null && (
/*      */       
/*  742 */       atlasTextureRegion = Game.i.assetManager.getTextureRegionSetThrowing(str, false)) != null) {
/*  743 */       paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.65F);
/*  744 */       paramBatch.draw((TextureRegion)atlasTextureRegion, paramFloat2 + 42.24F * paramFloat1, paramFloat3 + 42.24F * paramFloat4, 43.52F * paramFloat1, 43.52F * paramFloat4);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  754 */     if (this.S != null && this.S.gameState != null && paramDrawMode == MapRenderingSystem.DrawMode.DETAILED) {
/*      */       int i;
/*  756 */       if ((i = getFreeUpgradePoints()) > 7) i = 7; 
/*  757 */       for (byte b = 0; b < i; b++) {
/*  758 */         paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  759 */         paramBatch.draw(
/*  760 */             (TextureRegion)(AssetManager.TextureRegions.i()).particlePentagon, paramFloat2 + 12.0F * paramFloat1, paramFloat3 + 12.0F * paramFloat4 + (b << 7) * 0.125F * paramFloat4, 12.0F * paramFloat1, 12.0F * paramFloat4);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  768 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */   }
/*      */ 
/*      */   
/*      */   public final Group generateUiIcon(float paramFloat) {
/*  773 */     paramFloat /= 128.0F;
/*      */     Group group;
/*  775 */     (group = new Group()).setTransform(false);
/*      */     
/*  777 */     Color[] arrayOfColor = getBaseColors();
/*  778 */     for (byte b = 0; b < 4; b++) {
/*  779 */       if ((getTier() != Tier.REGULAR || (b != 0 && b != 1)) && (
/*  780 */         getTier() != Tier.RARE || (b != 2 && b != 3))) {
/*      */         Image image;
/*      */         
/*  783 */         (image = new Image(CoreTileFactory.b(Game.i.tileManager.F.CORE)[b])).setSize(128.0F * paramFloat, 128.0F * paramFloat);
/*  784 */         image.setColor(arrayOfColor[b]);
/*  785 */         group.addActor((Actor)image);
/*      */       } 
/*      */     } 
/*      */     AnimatedImage animatedImage;
/*  789 */     (animatedImage = new AnimatedImage(CoreTileFactory.c(Game.i.tileManager.F.CORE))).setSize(64.0F * paramFloat, 64.0F * paramFloat);
/*  790 */     animatedImage.setPosition(32.0F * paramFloat, 32.0F * paramFloat);
/*  791 */     animatedImage.setColor(getSphereColor());
/*  792 */     group.addActor((Actor)animatedImage);
/*      */     
/*      */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/*      */     String str;
/*  796 */     if ((str = getIcon()) != null && (
/*      */       
/*  798 */       atlasTextureRegion = Game.i.assetManager.getTextureRegionSetThrowing(str, false)) != null) {
/*      */       Image image;
/*  800 */       (image = new Image((TextureRegion)atlasTextureRegion)).setSize(42.24F * paramFloat, 42.24F * paramFloat);
/*  801 */       image.setPosition(42.66624F * paramFloat, 42.666622F * paramFloat);
/*  802 */       image.setColor(1.0F, 1.0F, 1.0F, 0.65F);
/*  803 */       group.addActor((Actor)image);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  808 */     return group;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void toJson(Json paramJson) {
/*  813 */     super.toJson(paramJson);
/*      */     
/*  815 */     paramJson.writeObjectStart("d");
/*  816 */     paramJson.writeValue("n", this.e);
/*  817 */     if (this.f != null) paramJson.writeValue("icon", this.f); 
/*  818 */     paramJson.writeValue("t", getTier());
/*  819 */     paramJson.writeValue("eg", Float.valueOf(this.h));
/*  820 */     paramJson.writeValue("flx", Boolean.valueOf(this.i));
/*      */     
/*  822 */     if (this.predefinedType != null) {
/*  823 */       paramJson.writeValue("pt", this.predefinedType.name());
/*      */     } else {
/*  825 */       paramJson.writeArrayStart("u");
/*      */       
/*      */       int i;
/*  828 */       for (i = this.j.size - 1; i >= 0 && (
/*  829 */         (Upgrade[])this.j.items)[i] == null; i--) {
/*  830 */         this.j.size = i;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  836 */       for (i = 0; i < this.j.size && 
/*  837 */         i < getUpgradeCols() * getUpgradeRows(); i++) {
/*      */         
/*  839 */         if (((Upgrade[])this.j.items)[i] == null) {
/*  840 */           paramJson.writeValue(null);
/*      */         } else {
/*  842 */           paramJson.writeObjectStart();
/*  843 */           ((Upgrade[])this.j.items)[i].toJson(paramJson);
/*  844 */           paramJson.writeObjectEnd();
/*      */         } 
/*      */       } 
/*  847 */       paramJson.writeArrayEnd();
/*      */     } 
/*      */     
/*  850 */     paramJson.writeObjectEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   public final ItemSubcategoryType getInventorySubcategory() {
/*  855 */     return ItemSubcategoryType.ME_SPECIAL;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/*  860 */     if (paramItemSortingType == ItemSortingType.KIND) {
/*      */       int i;
/*      */       
/*  863 */       if (this.predefinedType != null) {
/*  864 */         i = 15000 + this.predefinedType.ordinal() * 10;
/*      */       } else {
/*  866 */         i = 15000 + 300 + getRarity().ordinal() * 10;
/*      */       } 
/*      */       
/*  869 */       return i;
/*      */     } 
/*  871 */     return getRarity().ordinal() * 1000 + 5 - getTier().ordinal() + 100;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isRoadType() {
/*  877 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void from(Tile paramTile) {
/*  882 */     super.from(paramTile);
/*  883 */     paramTile = paramTile;
/*      */     
/*  885 */     this.e = ((CoreTile)paramTile).e;
/*  886 */     this.f = ((CoreTile)paramTile).f;
/*  887 */     this.g = ((CoreTile)paramTile).g;
/*  888 */     this.h = ((CoreTile)paramTile).h;
/*  889 */     this.i = ((CoreTile)paramTile).i;
/*      */     
/*  891 */     this.j.clear();
/*  892 */     if (((CoreTile)paramTile).predefinedType == null) {
/*  893 */       this.predefinedType = null;
/*  894 */       for (byte b = 0; b < ((CoreTile)paramTile).j.size; b++) {
/*  895 */         if (((Upgrade[])((CoreTile)paramTile).j.items)[b] == null) {
/*  896 */           this.j.add(null);
/*      */         } else {
/*  898 */           this.j.add(((Upgrade[])((CoreTile)paramTile).j.items)[b].cloneUpgrade());
/*      */         } 
/*      */       }  return;
/*      */     } 
/*  902 */     this.predefinedType = ((CoreTile)paramTile).predefinedType;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*  908 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*      */ 
/*      */     
/*  911 */     int i = getUpgradeCols();
/*  912 */     int j = getUpgradeRows();
/*      */     
/*  914 */     float f1 = paramTable.getWidth();
/*      */ 
/*      */     
/*  917 */     float f2 = i * 80.0F;
/*  918 */     float f3 = j * 80.0F;
/*  919 */     float f4 = 1.0F;
/*  920 */     if (f2 > f1) {
/*  921 */       f4 = f1 / f2;
/*  922 */       f2 = f1;
/*  923 */       f3 *= f4;
/*      */     } 
/*      */     
/*  926 */     int k = ((Integer)paramMapEditorItemInfoMenu.customData.get("coreTileMenuSelectedCol", Integer.valueOf(-1))).intValue();
/*  927 */     int m = ((Integer)paramMapEditorItemInfoMenu.customData.get("coreTileMenuSelectedRow", Integer.valueOf(-1))).intValue();
/*      */     
/*      */     Group group;
/*  930 */     (group = new Group()).setTransform(false);
/*  931 */     paramTable.add((Actor)group).size(f2, f3).row();
/*      */     
/*  933 */     for (byte b = 0; b < j; b++) {
/*  934 */       for (byte b1 = 0; b1 < i; b1++) {
/*      */         Upgrade upgrade1;
/*  936 */         if ((upgrade1 = getUpgrade(b1, b)) != null) {
/*      */           Group group1;
/*      */           
/*  939 */           (group1 = new Group()).setDebug(true);
/*  940 */           group1.setTransform(false);
/*  941 */           group1.setPosition(b1 * 80.0F * f4, f3 - (b + 1) * 80.0F * f4);
/*      */ 
/*      */ 
/*      */           
/*  945 */           byte b2 = b1;
/*  946 */           int n = b;
/*  947 */           group1.addListener((EventListener)new ClickListener(this, paramMapEditorItemInfoMenu, b2, n)
/*      */               {
/*      */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  950 */                   this.a.customData.put("coreTileMenuSelectedCol", Integer.valueOf(this.b));
/*  951 */                   this.a.customData.put("coreTileMenuSelectedRow", Integer.valueOf(this.c));
/*  952 */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*  953 */                   this.a.update();
/*      */                 }
/*      */               });
/*  956 */           group.addActor((Actor)group1);
/*      */           
/*      */           Image image;
/*  959 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(64.0F * f4, 64.0F * f4);
/*  960 */           image.setPosition(8.0F * f4, 8.0F * f4);
/*  961 */           image.setColor(new Color(269488383));
/*  962 */           group1.addActor((Actor)image);
/*      */           
/*  964 */           if (upgrade1.isAction) {
/*      */             Group group2;
/*  966 */             (group2 = Game.i.triggeredActionManager.generateIcon(upgrade1.getActionType(), 48.0F * f4, Color.WHITE)).setPosition(16.0F * f4, 16.0F * f4);
/*  967 */             group1.addActor((Actor)group2);
/*      */           } else {
/*  969 */             GameValueManager.GameValueStockConfig gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(upgrade1.getGameValueType());
/*      */             
/*      */             Image image1;
/*  972 */             (image1 = new Image((Drawable)gameValueStockConfig.getIcon())).setPosition(16.0F * f4, 16.0F * f4);
/*  973 */             image1.setSize(48.0F * f4, 48.0F * f4);
/*  974 */             group1.addActor((Actor)image1);
/*      */           } 
/*      */           LinkDirection[] arrayOfLinkDirection;
/*      */           byte b3;
/*  978 */           for (n = (arrayOfLinkDirection = LinkDirection.values).length, b3 = 0; b3 < n; ) { LinkDirection linkDirection = arrayOfLinkDirection[b3];
/*  979 */             if (upgrade1.hasLink(linkDirection)) {
/*      */               Image image1;
/*  981 */               (image1 = new Image()).setSize(16.0F * f4, 16.0F * f4);
/*      */               
/*  983 */               switch (null.a[linkDirection.ordinal()]) { case 1:
/*  984 */                   image1.setPosition(32.0F * f4, 72.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top")); break;
/*  985 */                 case 4: image1.setPosition(32.0F * f4, -8.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom")); break;
/*  986 */                 case 2: image1.setPosition(-8.0F * f4, 32.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-left")); break;
/*  987 */                 case 3: image1.setPosition(72.0F * f4, 32.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-right")); break;
/*  988 */                 case 5: image1.setPosition(-8.0F * f4, 72.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-left")); break;
/*  989 */                 case 6: image1.setPosition(72.0F * f4, 72.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-right")); break;
/*  990 */                 case 7: image1.setPosition(-8.0F * f4, -8.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-left")); break;
/*  991 */                 case 8: image1.setPosition(72.0F * f4, -8.0F * f4); image1.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-right"));
/*      */                   break; }
/*      */               
/*  994 */               group1.addActor((Actor)image1);
/*      */             } 
/*      */             b3++; }
/*      */           
/*  998 */           if (b1 == k && b == m) {
/*      */             Image image1;
/*      */             
/* 1001 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("ui-core-menu-upgrade-selection"))).setSize(74.0F * f4, 74.0F * f4);
/* 1002 */             image1.setPosition(3.0F * f4, 3.0F * f4);
/* 1003 */             group1.addActor((Actor)image1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1009 */     Upgrade upgrade = null;
/* 1010 */     if (k >= 0 && k < TIER_COLS[this.g.ordinal()] && m >= 0 && m < TIER_ROWS[this.g.ordinal()]) {
/* 1011 */       upgrade = getUpgrade(k, m);
/*      */     }
/*      */     
/* 1014 */     if (upgrade != null) {
/* 1015 */       String str1, str2; float f5 = (((Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[0]).delta;
/* 1016 */       float f6 = (((Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[upgrade.upgradeLevels.size - 1]).delta;
/*      */       
/* 1018 */       if (upgrade.isAction) {
/* 1019 */         if (f5 == f6) {
/* 1020 */           str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(f5, 2, true).toString();
/*      */         } else {
/* 1022 */           str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(f5, 2, true).toString() + " / " + StringFormatter.compactNumberWithPrecisionTrimZeros(f6, 2, true).toString();
/*      */         }
/*      */       
/* 1025 */       } else if (f5 == f6) {
/* 1026 */         str1 = Game.i.gameValueManager.formatEffectValue(f5, Game.i.gameValueManager.getUnits(upgrade.getGameValueType())).toString();
/*      */       } else {
/*      */         
/* 1029 */         str1 = Game.i.gameValueManager.formatEffectValue(f5, Game.i.gameValueManager.getUnits(upgrade.getGameValueType())).toString() + " / " + Game.i.gameValueManager.formatEffectValue(f6, Game.i.gameValueManager.getUnits(upgrade.getGameValueType())).toString();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1034 */       Color color = Game.i.tileManager.F.CORE.getTierColor(getTier());
/* 1035 */       if (upgrade.isAction) {
/* 1036 */         str1 = "\n[#" + color.toString() + "]" + str1 + "[]";
/* 1037 */         str2 = Game.i.triggeredActionManager.getTitleAlias(upgrade.getActionType());
/* 1038 */         str2 = Game.i.localeManager.i18n.format(str2, new Object[] { str1 });
/*      */       } else {
/*      */         
/* 1041 */         str2 = Game.i.gameValueManager.getTitle(upgrade.getGameValueType()) + "\n[#" + color.toString() + "]" + str1 + "[]";
/*      */       } 
/*      */       
/*      */       Label label;
/*      */       
/* 1046 */       (label = new Label(str2, Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 1047 */       label.setWrap(true);
/* 1048 */       paramTable.add((Actor)label).padTop(8.0F).growX().minHeight(52.0F).row();
/*      */       return;
/*      */     } 
/* 1051 */     paramTable.add().padTop(8.0F).width(1.0F).height(52.0F).row();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 1057 */     paramItemCreationOverlay.label("Predefined type");
/* 1058 */     SelectBox selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle);
/*      */     Array array;
/* 1060 */     (array = new Array()).add("None"); PredefinedCoreTileType[] arrayOfPredefinedCoreTileType; int j;
/* 1061 */     for (int i = (arrayOfPredefinedCoreTileType = PredefinedCoreTileType.values).length; j < i; ) { PredefinedCoreTileType predefinedCoreTileType = arrayOfPredefinedCoreTileType[j];
/* 1062 */       array.add(predefinedCoreTileType.name()); j++; }
/*      */     
/* 1064 */     selectBox.setItems(array);
/* 1065 */     selectBox.setSelected((this.predefinedType == null) ? "None" : this.predefinedType.name());
/* 1066 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramItemCreationOverlay)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1069 */             if (((String)this.a.getSelected()).equals("None")) {
/* 1070 */               this.c.predefinedType = null;
/*      */             } else {
/* 1072 */               this.c.predefinedType = PredefinedCoreTileType.valueOf((String)this.a.getSelected());
/*      */             } 
/* 1074 */             this.b.updateForm();
/*      */           }
/*      */         });
/* 1077 */     paramItemCreationOverlay.selectBox(selectBox);
/*      */     
/* 1079 */     if (this.predefinedType == null) {
/* 1080 */       paramItemCreationOverlay.label("Tier");
/* 1081 */       SelectBox selectBox1 = new SelectBox(paramItemCreationOverlay.selectBoxStyle);
/* 1082 */       array = new Array(); Tier[] arrayOfTier; int m;
/* 1083 */       for (j = (arrayOfTier = Tier.values).length, m = 0; m < j; ) { Tier tier = arrayOfTier[m];
/* 1084 */         array.add(tier.name()); m++; }
/*      */       
/* 1086 */       selectBox1.setItems(array);
/* 1087 */       selectBox1.setSelected(getTier().name());
/* 1088 */       selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1, paramItemCreationOverlay)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1091 */               this.c.setTierKeepLayout(CoreTile.Tier.valueOf((String)this.a.getSelected()));
/* 1092 */               this.b.updateForm();
/*      */             }
/*      */           });
/* 1095 */       paramItemCreationOverlay.selectBox(selectBox1);
/*      */       
/* 1097 */       paramItemCreationOverlay.label("Name");
/* 1098 */       paramItemCreationOverlay.textField(String.valueOf(getName()), paramString -> {
/*      */             try {
/*      */               setName(paramString); paramItemCreationOverlay.updateItemIcon();
/*      */               return;
/* 1102 */             } catch (Exception exception) {
/*      */               c.e("bad value: " + paramString, new Object[0]);
/*      */               return;
/*      */             } 
/*      */           });
/* 1107 */       paramItemCreationOverlay.label("Icon");
/* 1108 */       paramItemCreationOverlay.textField((getIcon() == null) ? "" : getIcon(), paramString -> {
/*      */             try {
/*      */               if (paramString.equals(""))
/*      */                 paramString = null; 
/*      */               setIcon(paramString);
/*      */               paramItemCreationOverlay.updateItemIcon();
/*      */               return;
/* 1115 */             } catch (Exception exception) {
/*      */               c.e("bad value: " + paramString, new Object[0]);
/*      */               return;
/*      */             } 
/*      */           });
/* 1120 */       paramItemCreationOverlay.label("XP generation");
/* 1121 */       paramItemCreationOverlay.textField(String.valueOf(getExperienceGeneration()), paramString -> {
/*      */             try {
/*      */               setExperienceGeneration(Float.valueOf(paramString).floatValue()); paramItemCreationOverlay.updateItemIcon();
/*      */               return;
/* 1125 */             } catch (Exception exception) {
/*      */               c.e("bad value: " + paramString, new Object[0]);
/*      */               return;
/*      */             } 
/*      */           });
/* 1130 */       paramItemCreationOverlay.toggle("Fixed XP levels (1000 XP)", isXpLevelRequirementFixed(), paramBoolean -> {
/*      */             setXpLevelRequirementFixed(paramBoolean.booleanValue());
/*      */             
/*      */             paramItemCreationOverlay.updateForm();
/*      */           });
/* 1135 */       paramItemCreationOverlay.label("Upgrades");
/*      */       
/* 1137 */       Table table = new Table();
/* 1138 */       paramItemCreationOverlay.form.add((Actor)table).top().left().pad(10.0F).top().left().row();
/*      */       
/*      */       Group group;
/* 1141 */       (group = new Group()).setTransform(false);
/*      */       
/*      */       byte b;
/*      */       int k;
/* 1145 */       for (b = 0, k = getUpgradeRows(); b < k; b++) {
/* 1146 */         for (byte b1 = 0; b1 < m; b1++) {
/* 1147 */           Upgrade upgrade = getUpgrade(b1, b);
/*      */           
/* 1149 */           float f1 = b1 * 64.0F + b1 * 32.0F;
/* 1150 */           float f2 = (getUpgradeRows() - 1) * 96.0F - b * 96.0F;
/*      */           
/* 1152 */           if (paramItemCreationOverlay.customIntA == b1 && paramItemCreationOverlay.customIntB == b) {
/*      */             Image image1;
/*      */             
/* 1155 */             (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(68.0F, 68.0F);
/* 1156 */             image1.setPosition(f1 - 2.0F, f2 - 2.0F);
/* 1157 */             group.addActor((Actor)image1);
/*      */           } 
/*      */           
/*      */           Image image;
/* 1161 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(64.0F, 64.0F);
/* 1162 */           image.setPosition(f1, f2);
/* 1163 */           image.setTouchable(Touchable.enabled);
/*      */           
/* 1165 */           byte b2 = b1;
/* 1166 */           byte b3 = b;
/* 1167 */           image.addListener((EventListener)new ClickListener(this, paramItemCreationOverlay, b2, b3)
/*      */               {
/*      */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 1170 */                   this.a.customIntA = this.b;
/* 1171 */                   this.a.customIntB = this.c;
/*      */                   
/* 1173 */                   this.a.updateForm();
/* 1174 */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*      */                 }
/*      */               });
/* 1177 */           group.addActor((Actor)image);
/*      */           
/* 1179 */           if (upgrade == null) {
/*      */             
/* 1181 */             image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */           } else {
/*      */             
/* 1184 */             if (upgrade.starting) {
/* 1185 */               image.setColor(MaterialColor.LIGHT_GREEN.P800);
/*      */             } else {
/* 1187 */               image.setColor(MaterialColor.LIGHT_BLUE.P800);
/*      */             } 
/*      */             
/* 1190 */             if (upgrade.isAction) {
/*      */               Group group1;
/*      */               
/* 1193 */               (group1 = Game.i.triggeredActionManager.generateIcon(upgrade.getActionType(), 51.2F, new Color(1.0F, 1.0F, 1.0F, 0.78F))).setPosition(f1 + 6.4F, f2 + 6.4F);
/* 1194 */               group1.setTouchable(Touchable.disabled);
/* 1195 */               group.addActor((Actor)group1);
/*      */             } else {
/*      */               Quad quad;
/*      */               
/* 1199 */               (quad = new Quad(Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType()).getIcon(), true)).multiplyRegionColors(new Color(1.0F, 1.0F, 1.0F, 0.78F));
/*      */               Image image1;
/* 1201 */               (image1 = new Image((Drawable)quad)).setTouchable(Touchable.disabled);
/* 1202 */               image1.setPosition(f1 + 6.4F, f2 + 6.4F);
/* 1203 */               image1.setSize(51.2F, 51.2F);
/* 1204 */               group.addActor((Actor)image1);
/*      */             } 
/*      */             
/* 1207 */             String str = "L" + upgrade.upgradeLevels.size;
/* 1208 */             if (upgrade.costsCoins) {
/* 1209 */               str = str + " <@icon-coin>";
/*      */             }
/* 1211 */             str = Game.i.assetManager.replaceRegionAliasesWithChars(str).toString();
/*      */             
/*      */             Label label1;
/* 1214 */             (label1 = new Label(str, Game.i.assetManager.getLabelStyle(21))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 1215 */             label1.setPosition(f1 + 3.0F + 2.0F, f2 - 2.0F);
/* 1216 */             label1.setTouchable(Touchable.disabled);
/* 1217 */             group.addActor((Actor)label1);
/*      */             
/*      */             Label label2;
/* 1220 */             (label2 = new Label(str, Game.i.assetManager.getLabelStyle(21))).setPosition(f1 + 3.0F, f2);
/* 1221 */             label2.setTouchable(Touchable.disabled);
/* 1222 */             group.addActor((Actor)label2);
/*      */ 
/*      */             
/* 1225 */             if (upgrade.hasLink(LinkDirection.LEFT)) {
/*      */               Image image1;
/* 1227 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-left"))).setSize(32.0F, 32.0F);
/* 1228 */               image1.setPosition(f1 - 32.0F, f2 + 32.0F - 16.0F);
/* 1229 */               group.addActor((Actor)image1);
/*      */             } 
/* 1231 */             if (upgrade.hasLink(LinkDirection.RIGHT)) {
/*      */               Image image1;
/* 1233 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-right"))).setSize(32.0F, 32.0F);
/* 1234 */               image1.setPosition(f1 + 64.0F, f2 + 32.0F - 16.0F);
/* 1235 */               group.addActor((Actor)image1);
/*      */             } 
/* 1237 */             if (upgrade.hasLink(LinkDirection.TOP)) {
/*      */               Image image1;
/* 1239 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top"))).setSize(32.0F, 32.0F);
/* 1240 */               image1.setPosition(f1 + 32.0F - 16.0F, f2 + 64.0F);
/* 1241 */               group.addActor((Actor)image1);
/*      */             } 
/* 1243 */             if (upgrade.hasLink(LinkDirection.BOTTOM)) {
/*      */               Image image1;
/* 1245 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom"))).setSize(32.0F, 32.0F);
/* 1246 */               image1.setPosition(f1 + 32.0F - 16.0F, f2 - 32.0F);
/* 1247 */               group.addActor((Actor)image1);
/*      */             } 
/* 1249 */             if (upgrade.hasLink(LinkDirection.TOP_LEFT)) {
/*      */               Image image1;
/* 1251 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-left"))).setSize(32.0F, 32.0F);
/* 1252 */               image1.setPosition(f1 - 32.0F, f2 + 64.0F);
/* 1253 */               group.addActor((Actor)image1);
/*      */             } 
/* 1255 */             if (upgrade.hasLink(LinkDirection.TOP_RIGHT)) {
/*      */               Image image1;
/* 1257 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-right"))).setSize(32.0F, 32.0F);
/* 1258 */               image1.setPosition(f1 + 64.0F, f2 + 64.0F);
/* 1259 */               group.addActor((Actor)image1);
/*      */             } 
/* 1261 */             if (upgrade.hasLink(LinkDirection.BOTTOM_LEFT)) {
/*      */               Image image1;
/* 1263 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-left"))).setSize(32.0F, 32.0F);
/* 1264 */               image1.setPosition(f1 - 32.0F, f2 - 32.0F);
/* 1265 */               group.addActor((Actor)image1);
/*      */             } 
/* 1267 */             if (upgrade.hasLink(LinkDirection.BOTTOM_RIGHT)) {
/*      */               Image image1;
/* 1269 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-right"))).setSize(32.0F, 32.0F);
/* 1270 */               image1.setPosition(f1 + 64.0F, f2 - 32.0F);
/* 1271 */               group.addActor((Actor)image1);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1276 */       table.add((Actor)group).size(
/* 1277 */           getUpgradeCols() * 64.0F + (getUpgradeCols() - 1) * 32.0F, 
/* 1278 */           getUpgradeRows() * 64.0F + (getUpgradeRows() - 1) * 32.0F)
/* 1279 */         .padRight(16.0F);
/*      */ 
/*      */ 
/*      */       
/* 1283 */       if (isValidUpgradePos(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB)) {
/*      */         
/* 1285 */         Table table1 = new Table();
/* 1286 */         table.add((Actor)table1);
/*      */         
/*      */         Upgrade upgrade;
/*      */         
/* 1290 */         if ((upgrade = getUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB)) == null) {
/*      */           
/* 1292 */           RectButton rectButton = new RectButton("Add upgrade", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */                 Upgrade upgrade = new Upgrade(false, false, GameValueType.COINS_GENERATION, null, null, 0, false);
/*      */                 setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, upgrade);
/*      */                 paramItemCreationOverlay.updateForm();
/*      */               });
/* 1297 */           table1.add((Actor)rectButton).size(200.0F, 48.0F);
/*      */           return;
/*      */         } 
/* 1300 */         RectButton rectButton1 = new RectButton("Remove upgrade", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */               setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, null);
/*      */               paramItemCreationOverlay.updateForm();
/*      */             });
/* 1304 */         table1.add((Actor)rectButton1).size(200.0F, 48.0F).top().left().row();
/*      */ 
/*      */         
/* 1307 */         LabelToggleButton labelToggleButton1 = new LabelToggleButton("Is action", upgrade.isAction, 24, 24.0F, false, paramBoolean -> {
/*      */               paramUpgrade.isAction = paramBoolean.booleanValue();
/*      */               setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, paramUpgrade);
/*      */               paramItemCreationOverlay.updateForm();
/*      */             });
/* 1312 */         table1.add((Actor)labelToggleButton1).top().left().padTop(8.0F).padBottom(8.0F).row();
/*      */         
/* 1314 */         if (upgrade.isAction) {
/*      */           
/* 1316 */           SelectBox selectBox2 = new SelectBox(paramItemCreationOverlay.selectBoxStyle);
/* 1317 */           Array array1 = new Array(TriggeredActionType.class); TriggeredActionType[] arrayOfTriggeredActionType; int i1; byte b2;
/* 1318 */           for (i1 = (arrayOfTriggeredActionType = TriggeredActionType.values).length, b2 = 0; b2 < i1; ) { TriggeredActionType triggeredActionType = arrayOfTriggeredActionType[b2];
/* 1319 */             array1.add(triggeredActionType); b2++; }
/*      */           
/* 1321 */           selectBox2.setItems(array1);
/* 1322 */           selectBox2.setSelected(upgrade.getActionType());
/* 1323 */           selectBox2.addListener((EventListener)new ChangeListener(this, upgrade, selectBox2, paramItemCreationOverlay)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1326 */                   this.a.setActionType((TriggeredActionType)this.b.getSelected());
/* 1327 */                   this.d.setUpgrade(this.c.customIntA, this.c.customIntB, this.a);
/* 1328 */                   this.c.updateForm();
/*      */                 }
/*      */               });
/* 1331 */           table1.add((Actor)selectBox2).height(48.0F).width(320.0F).top().left().row();
/*      */         } else {
/*      */           
/* 1334 */           SelectBox selectBox2 = new SelectBox(paramItemCreationOverlay.selectBoxStyle);
/* 1335 */           Array array1 = new Array(GameValueType.class); GameValueType[] arrayOfGameValueType; int i1; byte b2;
/* 1336 */           for (i1 = (arrayOfGameValueType = GameValueType.values).length, b2 = 0; b2 < i1; ) { GameValueType gameValueType = arrayOfGameValueType[b2];
/* 1337 */             array1.add(gameValueType); b2++; }
/*      */           
/* 1339 */           selectBox2.setItems(array1);
/* 1340 */           selectBox2.setSelected(upgrade.getGameValueType());
/* 1341 */           selectBox2.addListener((EventListener)new ChangeListener(this, upgrade, selectBox2, paramItemCreationOverlay)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1344 */                   this.a.setGameValueType((GameValueType)this.b.getSelected());
/* 1345 */                   this.d.setUpgrade(this.c.customIntA, this.c.customIntB, this.a);
/* 1346 */                   this.c.updateForm();
/*      */                 }
/*      */               });
/* 1349 */           table1.add((Actor)selectBox2).height(48.0F).width(320.0F).top().left().row();
/*      */         } 
/*      */         
/* 1352 */         Table table2 = new Table();
/* 1353 */         table1.add((Actor)table2).row();
/*      */         
/* 1355 */         Table table3 = new Table();
/* 1356 */         table2.add((Actor)table3);
/*      */         
/* 1358 */         Table table4 = new Table();
/* 1359 */         table2.add((Actor)table4).padLeft(30.0F);
/*      */ 
/*      */         
/* 1362 */         LabelToggleButton labelToggleButton2 = paramItemCreationOverlay.toggle(false, "Starting", upgrade.starting, paramBoolean -> {
/*      */               paramUpgrade.starting = paramBoolean.booleanValue();
/*      */               
/*      */               setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, paramUpgrade);
/*      */               paramItemCreationOverlay.updateForm();
/*      */             });
/* 1368 */         table3.add((Actor)labelToggleButton2).height(48.0F).top().left().row();
/*      */ 
/*      */         
/* 1371 */         LabelToggleButton labelToggleButton3 = paramItemCreationOverlay.toggle(false, "Costs coins", upgrade.costsCoins, paramBoolean -> {
/*      */               paramUpgrade.costsCoins = paramBoolean.booleanValue();
/*      */               
/*      */               setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, paramUpgrade);
/*      */               paramItemCreationOverlay.updateForm();
/*      */             });
/* 1377 */         table3.add((Actor)labelToggleButton3).height(48.0F).top().left().row();
/*      */ 
/*      */         
/* 1380 */         Table table6 = new Table();
/* 1381 */         table4.add((Actor)table6); LinkDirection[] arrayOfLinkDirection;
/*      */         byte b1;
/* 1383 */         for (int n = (arrayOfLinkDirection = LinkDirection.values).length; b1 < n; ) { LinkDirection linkDirection = arrayOfLinkDirection[b1];
/* 1384 */           String str = "blank";
/* 1385 */           switch (null.a[linkDirection.ordinal()]) {
/*      */             case 1:
/* 1387 */               str = "tiny-arrow-top";
/*      */               break;
/*      */             case 2:
/* 1390 */               str = "tiny-arrow-left";
/*      */               break;
/*      */             case 3:
/* 1393 */               str = "tiny-arrow-right";
/*      */               break;
/*      */             case 4:
/* 1396 */               str = "tiny-arrow-bottom";
/*      */               break;
/*      */             case 5:
/* 1399 */               str = "tiny-arrow-top-left";
/*      */               break;
/*      */             case 6:
/* 1402 */               str = "tiny-arrow-top-right";
/*      */               break;
/*      */             case 7:
/* 1405 */               str = "tiny-arrow-bottom-left";
/*      */               break;
/*      */             case 8:
/* 1408 */               str = "tiny-arrow-bottom-right";
/*      */               break;
/*      */           } 
/* 1411 */           Image image = new Image((Drawable)Game.i.assetManager.getDrawable(str));
/* 1412 */           if (!upgrade.hasLink(linkDirection)) {
/* 1413 */             image.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */           }
/* 1415 */           image.setTouchable(Touchable.enabled);
/* 1416 */           if (linkDirection == LinkDirection.RIGHT) {
/* 1417 */             table6.add();
/*      */           }
/* 1419 */           table6.add((Actor)image).size(32.0F).pad(8.0F);
/* 1420 */           image.addListener((EventListener)new ClickListener(this, upgrade, linkDirection, paramItemCreationOverlay)
/*      */               {
/*      */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 1423 */                   this.a.setHasLink(this.b, !this.a.hasLink(this.b));
/* 1424 */                   this.d.setUpgrade(this.c.customIntA, this.c.customIntB, this.a);
/* 1425 */                   this.c.updateForm();
/*      */                 }
/*      */               });
/* 1428 */           if (linkDirection == LinkDirection.TOP_RIGHT || linkDirection == LinkDirection.RIGHT) {
/* 1429 */             table6.row();
/*      */           }
/*      */           
/*      */           b1++; }
/*      */         
/* 1434 */         Table table5 = new Table();
/* 1435 */         table1.row();
/* 1436 */         table1.add((Actor)table5).top().left();
/*      */ 
/*      */         
/* 1439 */         table5.add();
/*      */         
/*      */         Label label;
/* 1442 */         (label = new Label("Delta", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1443 */         table5.add((Actor)label).height(40.0F).padBottom(2.0F);
/*      */ 
/*      */         
/* 1446 */         (label = new Label("Price", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 1447 */         table5.add((Actor)label).height(40.0F).padBottom(2.0F);
/*      */         
/* 1449 */         table5.add();
/*      */         
/* 1451 */         table5.row();
/*      */         
/* 1453 */         for (b1 = 0; b1 < upgrade.upgradeLevels.size; b1++) {
/* 1454 */           byte b2 = b1;
/*      */           
/* 1456 */           Upgrade.UpgradeLevel upgradeLevel = ((Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[b1];
/*      */ 
/*      */           
/* 1459 */           Label label1 = new Label(b1 + 1, Game.i.assetManager.getLabelStyle(21));
/* 1460 */           table5.add((Actor)label1).minWidth(40.0F).padRight(8.0F);
/*      */           
/*      */           TextFieldXPlatform textFieldXPlatform;
/*      */           
/* 1464 */           (textFieldXPlatform = new TextFieldXPlatform(upgradeLevel.delta, paramItemCreationOverlay.textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform, upgrade, b2, paramItemCreationOverlay)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1467 */                   String str = this.a.getText();
/*      */                   try {
/* 1469 */                     (((CoreTile.Upgrade.UpgradeLevel[])this.b.upgradeLevels.items)[this.c]).delta = Float.parseFloat(str);
/* 1470 */                     this.e.setUpgrade(this.d.customIntA, this.d.customIntB, this.b);
/* 1471 */                   } catch (Exception exception) {
/* 1472 */                     CoreTile.a().e("bad value: " + str, new Object[0]);
/*      */                   } 
/* 1474 */                   this.d.updateItemIcon();
/*      */                 }
/*      */               });
/* 1477 */           table5.add((Actor)textFieldXPlatform).minWidth(60.0F).height(40.0F).padLeft(2.0F).padBottom(2.0F);
/*      */ 
/*      */ 
/*      */           
/* 1481 */           (textFieldXPlatform = new TextFieldXPlatform(upgradeLevel.price, paramItemCreationOverlay.textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform, upgrade, b2, paramItemCreationOverlay)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1484 */                   String str = this.a.getText();
/*      */                   try {
/* 1486 */                     (((CoreTile.Upgrade.UpgradeLevel[])this.b.upgradeLevels.items)[this.c]).price = Integer.parseInt(str);
/* 1487 */                     this.e.setUpgrade(this.d.customIntA, this.d.customIntB, this.b);
/* 1488 */                   } catch (Exception exception) {
/* 1489 */                     CoreTile.a().e("bad value: " + str, new Object[0]);
/*      */                   } 
/* 1491 */                   this.d.updateItemIcon();
/*      */                 }
/*      */               });
/* 1494 */           table5.add((Actor)textFieldXPlatform).minWidth(60.0F).height(40.0F).padLeft(2.0F).padBottom(2.0F);
/*      */ 
/*      */           
/* 1497 */           if (b1 == 0) {
/*      */             
/* 1499 */             table5.add();
/*      */           } else {
/*      */             ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1506 */             (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> { paramUpgrade.upgradeLevels.removeIndex(paramInt); setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, paramUpgrade); paramItemCreationOverlay.updateForm(); })).setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 40.0F, 40.0F);
/* 1507 */             complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 32.0F, 32.0F);
/* 1508 */             table5.add((Actor)complexButton).size(40.0F).padLeft(2.0F);
/*      */           } 
/*      */           
/* 1511 */           table5.row();
/*      */         } 
/*      */ 
/*      */         
/* 1515 */         RectButton rectButton2 = new RectButton("Add new level", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */               paramUpgrade.upgradeLevels.add(new Upgrade.UpgradeLevel(0.0F, 1));
/*      */               setUpgrade(paramItemCreationOverlay.customIntA, paramItemCreationOverlay.customIntB, paramUpgrade);
/*      */               paramItemCreationOverlay.updateForm();
/*      */             });
/* 1520 */         table5.add((Actor)rectButton2).size(164.0F, 40.0F).colspan(3).top().left();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static class CoreTileFactory
/*      */     extends Tile.Factory.AbstractFactory<CoreTile> {
/* 1527 */     private TextureRegion[] a = new TextureRegion[4];
/* 1528 */     private CoreTile[] b = new CoreTile[PredefinedCoreTileType.values.length];
/*      */     
/*      */     private Animation<ResourcePack.AtlasTextureRegion> c;
/*      */     
/*      */     public CoreTileFactory() {
/* 1533 */       super(TileType.CORE);
/*      */       
/*      */       JsonValue jsonValue;
/*      */       
/* 1537 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/core-tiles.json"))).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*      */         try {
/* 1539 */           PredefinedCoreTileType predefinedCoreTileType = PredefinedCoreTileType.valueOf(jsonValue1.name);
/* 1540 */           this.b[predefinedCoreTileType.ordinal()] = fromJson(jsonValue1);
/*      */         }
/* 1542 */         catch (Exception exception) {
/* 1543 */           CoreTile.a().e("failed to load predefined core tile '" + jsonValue1.name + "'", new Object[] { exception });
/*      */         }  }
/*      */     
/*      */     }
/*      */ 
/*      */     
/*      */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/* 1550 */       if (param1Float < 0.4F) return 0;
/*      */       
/* 1552 */       if (param1Float < 0.6F)
/* 1553 */         return 10; 
/* 1554 */       if (param1Float < 0.8F) {
/* 1555 */         return 2;
/*      */       }
/* 1557 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setupAssets() {
/* 1563 */       this.a[0] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-core-left");
/* 1564 */       this.a[1] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-core-right");
/* 1565 */       this.a[2] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-core-top");
/* 1566 */       this.a[3] = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-type-core-bottom");
/*      */       
/* 1568 */       this.c = new Animation(0.033F, Game.i.assetManager.getTextureRegions("3d-sphere"), Animation.PlayMode.LOOP);
/*      */     }
/*      */ 
/*      */     
/*      */     public CoreTile create() {
/* 1573 */       return new CoreTile((byte)0);
/*      */     }
/*      */ 
/*      */     
/*      */     public CoreTile createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/*      */       int i;
/* 1579 */       CoreTile coreTile = create();
/*      */       
/* 1581 */       if (param1Float < 0.6F) {
/* 1582 */         CoreTile.a(coreTile, CoreTile.Tier.REGULAR);
/* 1583 */       } else if (param1Float < 0.8F) {
/* 1584 */         CoreTile.a(coreTile, CoreTile.Tier.RARE);
/*      */       } else {
/* 1586 */         CoreTile.a(coreTile, CoreTile.Tier.LEGENDARY);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1594 */       switch (CoreTile.null.b[CoreTile.a(coreTile).ordinal()]) {
/*      */ 
/*      */         
/*      */         case 1:
/* 1598 */           switch (i = param1RandomXS128.nextInt(2)) {
/*      */             case 0:
/* 1600 */               coreTile.predefinedType = PredefinedCoreTileType.ALPHA;
/*      */               break;
/*      */             
/*      */             case 1:
/* 1604 */               coreTile.predefinedType = PredefinedCoreTileType.BETA;
/*      */               break;
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/* 1613 */           switch (i = param1RandomXS128.nextInt(2)) {
/*      */             case 0:
/* 1615 */               coreTile.predefinedType = PredefinedCoreTileType.DELTA;
/*      */               break;
/*      */             
/*      */             case 1:
/* 1619 */               coreTile.predefinedType = PredefinedCoreTileType.THETA;
/*      */               break;
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */ 
/*      */         
/*      */         case 3:
/* 1628 */           switch (i = param1RandomXS128.nextInt(2)) {
/*      */             case 0:
/* 1630 */               coreTile.predefinedType = PredefinedCoreTileType.ZETA;
/*      */               break;
/*      */             
/*      */             case 1:
/* 1634 */               coreTile.predefinedType = PredefinedCoreTileType.XI;
/*      */               break;
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1643 */       return coreTile;
/*      */     }
/*      */     
/*      */     public CharSequence getTierDescription(CoreTile.Tier param1Tier) {
/* 1647 */       switch (CoreTile.null.b[param1Tier.ordinal()]) { case 1:
/* 1648 */           return Game.i.progressManager.getRarityName(RarityType.VERY_RARE);
/* 1649 */         case 2: return Game.i.progressManager.getRarityName(RarityType.EPIC);
/* 1650 */         case 3: return Game.i.progressManager.getRarityName(RarityType.LEGENDARY); }
/*      */ 
/*      */       
/* 1653 */       return null;
/*      */     }
/*      */     
/*      */     public Color getTierColor(CoreTile.Tier param1Tier) {
/* 1657 */       switch (CoreTile.null.b[param1Tier.ordinal()]) { case 1:
/* 1658 */           return MaterialColor.PURPLE.P400;
/* 1659 */         case 2: return MaterialColor.ORANGE.P500;
/* 1660 */         case 3: return MaterialColor.CYAN.P500; }
/*      */ 
/*      */       
/* 1663 */       return null;
/*      */     }
/*      */     
/*      */     public float getExperienceGeneration(CoreTile param1CoreTile, GameValueProvider param1GameValueProvider) {
/* 1667 */       return param1CoreTile.getExperienceGeneration() * (float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.CORES_LEVEL_UP_SPEED);
/*      */     }
/*      */ 
/*      */     
/*      */     public CoreTile fromJson(JsonValue param1JsonValue) {
/* 1672 */       CoreTile coreTile = (CoreTile)super.fromJson(param1JsonValue);
/*      */ 
/*      */ 
/*      */       
/* 1676 */       if ((param1JsonValue = param1JsonValue.get("d")).has("pt")) {
/* 1677 */         coreTile.predefinedType = PredefinedCoreTileType.valueOf(param1JsonValue.getString("pt"));
/*      */       }
/* 1679 */       CoreTile.a(coreTile, param1JsonValue.getString("n", ""));
/* 1680 */       CoreTile.b(coreTile, param1JsonValue.getString("icon", null));
/* 1681 */       CoreTile.a(coreTile, param1JsonValue.getFloat("eg", 1.0F));
/* 1682 */       CoreTile.a(coreTile, param1JsonValue.getBoolean("flx", false));
/* 1683 */       CoreTile.a(coreTile, CoreTile.Tier.valueOf(param1JsonValue.getString("t")));
/*      */       
/* 1685 */       if ((param1JsonValue = param1JsonValue.get("u")) != null) {
/* 1686 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 1687 */           JsonValue jsonValue; if ((jsonValue = jsonIterator.next()).isNull()) {
/* 1688 */             CoreTile.b(coreTile).add(null); continue;
/*      */           } 
/* 1690 */           CoreTile.b(coreTile).add(CoreTile.Upgrade.fromJson(jsonValue));
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1695 */       return coreTile;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static class Upgrade
/*      */     implements KryoSerializable
/*      */   {
/*      */     public boolean starting;
/*      */ 
/*      */     
/*      */     public boolean isAction;
/*      */ 
/*      */     
/*      */     private GameValueType a;
/*      */ 
/*      */     
/*      */     private TriggeredActionType b;
/*      */ 
/*      */     
/*      */     public boolean costsCoins;
/*      */ 
/*      */     
/*      */     public int links;
/*      */ 
/*      */     
/* 1724 */     public Array<UpgradeLevel> upgradeLevels = new Array(true, 1, UpgradeLevel.class);
/*      */ 
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/* 1728 */       param1Output.writeBoolean(this.starting);
/* 1729 */       param1Output.writeBoolean(this.isAction);
/* 1730 */       param1Kryo.writeObjectOrNull(param1Output, this.a, GameValueType.class);
/* 1731 */       param1Kryo.writeObjectOrNull(param1Output, this.b, TriggeredActionType.class);
/* 1732 */       param1Output.writeBoolean(this.costsCoins);
/* 1733 */       param1Output.writeInt(this.links);
/* 1734 */       param1Kryo.writeObject(param1Output, this.upgradeLevels);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/* 1739 */       this.starting = param1Input.readBoolean();
/* 1740 */       this.isAction = param1Input.readBoolean();
/* 1741 */       this.a = (GameValueType)param1Kryo.readObjectOrNull(param1Input, GameValueType.class);
/* 1742 */       this.b = (TriggeredActionType)param1Kryo.readObjectOrNull(param1Input, TriggeredActionType.class);
/* 1743 */       this.costsCoins = param1Input.readBoolean();
/* 1744 */       this.links = param1Input.readInt();
/* 1745 */       this.upgradeLevels = (Array<UpgradeLevel>)param1Kryo.readObject(param1Input, Array.class);
/*      */     }
/*      */     
/*      */     public Upgrade() {}
/*      */     
/*      */     public Upgrade(boolean param1Boolean1, boolean param1Boolean2, GameValueType param1GameValueType, TriggeredActionType param1TriggeredActionType, Array<UpgradeLevel> param1Array, int param1Int, boolean param1Boolean3) {
/* 1751 */       this.starting = param1Boolean1;
/* 1752 */       this.isAction = param1Boolean2;
/* 1753 */       this.b = param1TriggeredActionType;
/* 1754 */       this.a = param1GameValueType;
/* 1755 */       this.links = param1Int;
/* 1756 */       this.costsCoins = param1Boolean3;
/*      */       
/* 1758 */       if (param1Array == null)
/*      */       {
/* 1760 */         (param1Array = new Array(UpgradeLevel.class)).add(new UpgradeLevel(5.0F, 1));
/*      */       }
/* 1762 */       this.upgradeLevels.addAll(param1Array);
/*      */     }
/*      */     
/*      */     public GameValueType getGameValueType() {
/* 1766 */       if (this.isAction) throw new IllegalStateException("upgrade is an action");
/*      */       
/* 1768 */       return (this.a == null) ? GameValueType.DUMMY : this.a;
/*      */     }
/*      */     
/*      */     public void setGameValueType(GameValueType param1GameValueType) {
/* 1772 */       if (param1GameValueType == null) throw new IllegalStateException("type is null"); 
/* 1773 */       if (this.isAction) throw new IllegalStateException("upgrade is an action");
/*      */       
/* 1775 */       this.a = param1GameValueType;
/*      */     }
/*      */     
/*      */     public TriggeredActionType getActionType() {
/* 1779 */       if (!this.isAction) throw new IllegalStateException("upgrade is a GameValue");
/*      */       
/* 1781 */       return (this.b == null) ? TriggeredActionType.DUMMY : this.b;
/*      */     }
/*      */     
/*      */     public void setActionType(TriggeredActionType param1TriggeredActionType) {
/* 1785 */       if (param1TriggeredActionType == null) throw new IllegalStateException("type is null"); 
/* 1786 */       if (!this.isAction) throw new IllegalStateException("upgrade is a GameValue");
/*      */       
/* 1788 */       this.b = param1TriggeredActionType;
/*      */     }
/*      */     
/*      */     public void toJson(Json param1Json) {
/* 1792 */       param1Json.writeValue("s", Boolean.valueOf(this.starting));
/* 1793 */       param1Json.writeValue("ia", Boolean.valueOf(this.isAction));
/* 1794 */       if (this.a != null) param1Json.writeValue("gv", this.a.name()); 
/* 1795 */       if (this.b != null) param1Json.writeValue("a", this.b.name()); 
/* 1796 */       param1Json.writeValue("l", Integer.valueOf(this.links));
/* 1797 */       param1Json.writeValue("cc", Boolean.valueOf(this.costsCoins));
/* 1798 */       param1Json.writeArrayStart("ul");
/* 1799 */       for (byte b = 0; b < this.upgradeLevels.size; b++) {
/* 1800 */         param1Json.writeObjectStart();
/* 1801 */         ((UpgradeLevel[])this.upgradeLevels.items)[b].toJson(param1Json);
/* 1802 */         param1Json.writeObjectEnd();
/*      */       } 
/* 1804 */       param1Json.writeArrayEnd();
/*      */     }
/*      */     public static Upgrade fromJson(JsonValue param1JsonValue) {
/*      */       int i;
/* 1808 */       boolean bool1 = param1JsonValue.getBoolean("s");
/* 1809 */       boolean bool2 = param1JsonValue.getBoolean("ia", false);
/* 1810 */       GameValueType gameValueType = null;
/* 1811 */       TriggeredActionType triggeredActionType = null;
/* 1812 */       if (bool2) {
/*      */         
/*      */         try {
/* 1815 */           triggeredActionType = TriggeredActionType.valueOf(param1JsonValue.getString("a", TriggeredActionType.GIVE_COINS.name()));
/* 1816 */         } catch (Exception exception) {
/* 1817 */           triggeredActionType = TriggeredActionType.GIVE_COINS;
/* 1818 */           CoreTile.a().e("failed to load action type from json (" + param1JsonValue.getString("a") + ", fallback to GIVE_COINS\n" + param1JsonValue, new Object[] { exception });
/*      */         } 
/*      */       } else {
/*      */         
/*      */         try {
/* 1823 */           gameValueType = GameValueType.valueOf(param1JsonValue.getString("gv", GameValueType.EMOJI_ENEMIES.name()));
/* 1824 */         } catch (Exception exception) {
/* 1825 */           gameValueType = GameValueType.EMOJI_ENEMIES;
/* 1826 */           CoreTile.a().e("failed to load GV type from json (" + param1JsonValue.getString("gv") + ", fallback to EMOJI_ENEMIES\n" + param1JsonValue, new Object[] { exception });
/*      */         } 
/*      */       } 
/* 1829 */       int j = param1JsonValue.getInt("l");
/* 1830 */       boolean bool3 = param1JsonValue.getBoolean("cc", false);
/*      */       
/* 1832 */       Array<UpgradeLevel> array = new Array(UpgradeLevel.class);
/* 1833 */       if (param1JsonValue.get("d") != null && param1JsonValue.get("p") != null) {
/*      */         
/* 1835 */         float f = param1JsonValue.getFloat("d");
/* 1836 */         i = param1JsonValue.getInt("p");
/*      */         
/*      */         UpgradeLevel upgradeLevel;
/* 1839 */         (upgradeLevel = new UpgradeLevel()).delta = f;
/* 1840 */         upgradeLevel.price = i;
/* 1841 */         array.add(upgradeLevel);
/*      */       } else {
/*      */         JsonValue jsonValue;
/*      */         
/* 1845 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = i.get("ul")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 1846 */           array.add(UpgradeLevel.fromJson(jsonValue1)); }
/*      */       
/*      */       } 
/*      */       
/* 1850 */       return new Upgrade(bool1, bool2, gameValueType, triggeredActionType, array, j, bool3);
/*      */     }
/*      */     
/*      */     public boolean sameAs(Upgrade param1Upgrade) {
/* 1854 */       if (param1Upgrade.starting != this.starting) return false; 
/* 1855 */       if (param1Upgrade.isAction != this.isAction) return false; 
/* 1856 */       if (this.isAction)
/* 1857 */       { if (param1Upgrade.b != this.b) return false;
/*      */          }
/* 1859 */       else if (param1Upgrade.a != this.a) { return false; }
/*      */ 
/*      */       
/* 1862 */       if (param1Upgrade.links != this.links) return false; 
/* 1863 */       if (param1Upgrade.costsCoins != this.costsCoins) return false; 
/* 1864 */       if (param1Upgrade.upgradeLevels.size != this.upgradeLevels.size) return false; 
/* 1865 */       for (byte b = 0; b < this.upgradeLevels.size; b++) {
/* 1866 */         if ((((UpgradeLevel[])param1Upgrade.upgradeLevels.items)[b]).price != (((UpgradeLevel[])this.upgradeLevels.items)[b]).price || (((UpgradeLevel[])param1Upgrade.upgradeLevels.items)[b]).delta != (((UpgradeLevel[])this.upgradeLevels.items)[b]).delta) {
/* 1867 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 1871 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int generateHash() {
/* 1881 */       int i = (i = (i = (i = (i = 31 + (this.starting ? 1 : 0)) * 31 + (this.isAction ? 1 : 0)) * 31 + ((this.a == null) ? this.b.ordinal() : this.a.ordinal())) * 31 + this.links) * 31 + (this.costsCoins ? 1 : 0);
/* 1882 */       for (byte b = 0; b < this.upgradeLevels.size; b++) {
/* 1883 */         UpgradeLevel upgradeLevel = ((UpgradeLevel[])this.upgradeLevels.items)[b];
/*      */         
/* 1885 */         i = (i = i * 31 + upgradeLevel.price) * 31 + (int)(upgradeLevel.delta * 1000.0F);
/*      */       } 
/* 1887 */       return i;
/*      */     }
/*      */     
/*      */     public Upgrade cloneUpgrade() {
/* 1891 */       Array<UpgradeLevel> array = new Array(UpgradeLevel.class);
/* 1892 */       for (byte b = 0; b < this.upgradeLevels.size; b++) {
/* 1893 */         array.add(((UpgradeLevel[])this.upgradeLevels.items)[b].cpy());
/*      */       }
/* 1895 */       return new Upgrade(this.starting, this.isAction, this.a, this.b, array, this.links, this.costsCoins);
/*      */     }
/*      */     
/*      */     public boolean hasLink(CoreTile.LinkDirection param1LinkDirection) {
/* 1899 */       return ((this.links & CoreTile.LINK_DIRECTION_BITS[param1LinkDirection.ordinal()]) != 0);
/*      */     }
/*      */     
/*      */     public void setHasLink(CoreTile.LinkDirection param1LinkDirection, boolean param1Boolean) {
/* 1903 */       if (param1Boolean) {
/* 1904 */         this.links |= CoreTile.LINK_DIRECTION_BITS[param1LinkDirection.ordinal()]; return;
/*      */       } 
/* 1906 */       int i = CoreTile.LINK_DIRECTION_BITS[param1LinkDirection.ordinal()];
/* 1907 */       this.links = (this.links | i) ^ i;
/*      */     }
/*      */     
/*      */     @REGS
/*      */     public static class UpgradeLevel
/*      */       implements KryoSerializable
/*      */     {
/*      */       public float delta;
/*      */       public int price;
/*      */       
/*      */       public UpgradeLevel() {}
/*      */       
/*      */       public UpgradeLevel(float param2Float, int param2Int) {
/* 1920 */         this.delta = param2Float;
/* 1921 */         this.price = param2Int;
/*      */       }
/*      */ 
/*      */       
/*      */       public void write(Kryo param2Kryo, Output param2Output) {
/* 1926 */         param2Output.writeFloat(this.delta);
/* 1927 */         param2Output.writeVarInt(this.price, true);
/*      */       }
/*      */ 
/*      */       
/*      */       public void read(Kryo param2Kryo, Input param2Input) {
/* 1932 */         this.delta = param2Input.readFloat();
/* 1933 */         this.price = param2Input.readVarInt(true);
/*      */       }
/*      */       
/*      */       public UpgradeLevel cpy() {
/*      */         UpgradeLevel upgradeLevel;
/* 1938 */         (upgradeLevel = new UpgradeLevel()).delta = this.delta;
/* 1939 */         upgradeLevel.price = this.price;
/*      */         
/* 1941 */         return upgradeLevel;
/*      */       }
/*      */       
/*      */       public void toJson(Json param2Json) {
/* 1945 */         param2Json.writeValue("d", Float.valueOf(this.delta));
/* 1946 */         param2Json.writeValue("p", Integer.valueOf(this.price));
/*      */       }
/*      */       
/*      */       public static UpgradeLevel fromJson(JsonValue param2JsonValue) {
/*      */         UpgradeLevel upgradeLevel;
/* 1951 */         (upgradeLevel = new UpgradeLevel()).delta = param2JsonValue.getFloat("d");
/* 1952 */         upgradeLevel.price = param2JsonValue.getInt("p");
/*      */         
/* 1954 */         return upgradeLevel; } } } @REGS public static class UpgradeLevel implements KryoSerializable { public static UpgradeLevel fromJson(JsonValue param1JsonValue) { UpgradeLevel upgradeLevel; (upgradeLevel = new UpgradeLevel()).delta = param1JsonValue.getFloat("d"); upgradeLevel.price = param1JsonValue.getInt("p"); return upgradeLevel; }
/*      */ 
/*      */     
/*      */     public float delta;
/*      */     public int price;
/*      */     
/*      */     public UpgradeLevel() {}
/*      */     
/*      */     public UpgradeLevel(float param1Float, int param1Int) {
/*      */       this.delta = param1Float;
/*      */       this.price = param1Int;
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/*      */       param1Output.writeFloat(this.delta);
/*      */       param1Output.writeVarInt(this.price, true);
/*      */     }
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/*      */       this.delta = param1Input.readFloat();
/*      */       this.price = param1Input.readVarInt(true);
/*      */     }
/*      */     
/*      */     public UpgradeLevel cpy() {
/*      */       UpgradeLevel upgradeLevel;
/*      */       (upgradeLevel = new UpgradeLevel()).delta = this.delta;
/*      */       upgradeLevel.price = this.price;
/*      */       return upgradeLevel;
/*      */     }
/*      */     
/*      */     public void toJson(Json param1Json) {
/*      */       param1Json.writeValue("d", Float.valueOf(this.delta));
/*      */       param1Json.writeValue("p", Integer.valueOf(this.price));
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\CoreTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */