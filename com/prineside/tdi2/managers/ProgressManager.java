/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntIntMap;
/*      */ import com.badlogic.gdx.utils.IntSet;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectFloatMap;
/*      */ import com.badlogic.gdx.utils.ObjectIntMap;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.kryo.FixedInput;
/*      */ import com.prineside.kryo.FixedOutput;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.BasicLevelStage;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.CraftRecipe;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Gate;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.configs.ShopOfferValues;
/*      */ import com.prineside.tdi2.enums.AbilityType;
/*      */ import com.prineside.tdi2.enums.BlueprintType;
/*      */ import com.prineside.tdi2.enums.BossTileType;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.CaseType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemCategoryType;
/*      */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.ModifierType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TrophyType;
/*      */ import com.prineside.tdi2.events.global.GameLoad;
/*      */ import com.prineside.tdi2.items.BlueprintItem;
/*      */ import com.prineside.tdi2.items.CaseItem;
/*      */ import com.prineside.tdi2.items.RandomBarrierItem;
/*      */ import com.prineside.tdi2.items.RandomTileItem;
/*      */ import com.prineside.tdi2.items.ResourceItem;
/*      */ import com.prineside.tdi2.items.TileItem;
/*      */ import com.prineside.tdi2.items.TrophyItem;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Inventory;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Progress;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Research;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.tiles.BossTile;
/*      */ import com.prineside.tdi2.tiles.CoreTile;
/*      */ import com.prineside.tdi2.ui.shared.IssuedPrizesOverlay;
/*      */ import com.prineside.tdi2.ui.shared.LuckyWheelOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.OpenedPackOverlay;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ 
/*      */ @REGS(serializer = ProgressManager.Serializer.class)
/*      */ public class ProgressManager extends Manager.ManagerAdapter {
/*      */   public static final int VIDEO_WATCHES_FOR_DOUBLE_GAIN = 500;
/*      */   public static final int VIDEO_WATCHES_FOR_LUCKY_SHOT = 20;
/*      */   public static final int DIFFICULTY_MULTIPLIER_EASY = 80;
/*      */   public static final int DIFFICULTY_MULTIPLIER_NORMAL = 100;
/*      */   private Array<IssuedItems> b;
/*  103 */   private static final TLog a = TLog.forClass(ProgressManager.class);
/*      */   private boolean c;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<ProgressManager> { public ProgressManager read() {
/*  107 */       return Game.i.progressManager;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class ConditionalCompensation
/*      */   {
/*      */     public int id;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ConditionalCompensation(int param1Int) {
/*  123 */       this.id = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public abstract boolean handle();
/*      */   }
/*      */   
/*  130 */   public static final ConditionalCompensation[] CONDITIONAL_COMPENSATIONS = new ConditionalCompensation[] { new ConditionalCompensation(10177)
/*      */       {
/*      */         
/*      */         public boolean handle()
/*      */         {
/*  135 */           if (Game.i.statisticsManager.getAllTime(StatisticsType.PQR) >= 3.0D) {
/*      */             IssuedItems issuedItems;
/*  137 */             (issuedItems = new IssuedItems(IssuedItems.IssueReason.FAILURE_COMPENSATION, Game.getTimestampSeconds())).failureCompensationDescription = "For 3+ Prestige quest resets before update 1.8.5";
/*  138 */             issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 2450));
/*  139 */             issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 500));
/*  140 */             issuedItems.items.add(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 3));
/*  141 */             Game.i.progressManager.addItemArray(issuedItems.items, "compensation");
/*  142 */             Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  143 */             Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*  144 */             return true;
/*      */           } 
/*  146 */           return false;
/*      */         }
/*      */       }, new ConditionalCompensation(10202)
/*      */       {
/*      */ 
/*      */         
/*      */         public boolean handle()
/*      */         {
/*  154 */           int i = (ProgressPrefs.i()).dailyQuest.getDailyLootDaysInRow();
/*      */ 
/*      */ 
/*      */           
/*  158 */           ProgressManager.a().i("compensating " + i + " DQ days in row", new Object[0]);
/*  159 */           if (i >= 3) {
/*      */             IssuedItems issuedItems;
/*  161 */             (issuedItems = new IssuedItems(IssuedItems.IssueReason.FAILURE_COMPENSATION, Game.getTimestampSeconds())).failureCompensationDescription = "For " + i + " days streak of daily quests (this feature has been removed in 1.9.0)";
/*      */             
/*  163 */             issuedItems.items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i * 1000));
/*  164 */             issuedItems.items.add(new ItemStack((Item)Item.D.ACCELERATOR, i << 1));
/*  165 */             if (i > 365) {
/*  166 */               issuedItems.items.add(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 4));
/*  167 */               issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 500));
/*  168 */               issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 500));
/*      */             } 
/*  170 */             if (i > 180) {
/*  171 */               issuedItems.items.add(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 3));
/*  172 */               issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 300));
/*  173 */               issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 300));
/*      */             } 
/*  175 */             if (i > 90) {
/*  176 */               issuedItems.items.add(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 2));
/*  177 */               issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 200));
/*  178 */               issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 200));
/*      */             } 
/*  180 */             if (i > 45) {
/*  181 */               issuedItems.items.add(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1));
/*  182 */               issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 100));
/*  183 */               issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 100));
/*      */             } 
/*  185 */             if (i > 21) {
/*  186 */               issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, 50));
/*  187 */               issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, 50));
/*      */             } 
/*  189 */             issuedItems.items.add(new ItemStack((Item)Item.D.F_RANDOM_TILE.create(1.0F), i / 2));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  197 */             i = i;
/*  198 */             while (i > 0) {
/*  199 */               if (i >= 16) {
/*  200 */                 issuedItems.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.CYAN, false), 1));
/*  201 */                 i -= 16; continue;
/*  202 */               }  if (i >= 8) {
/*  203 */                 issuedItems.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.ORANGE, false), 1));
/*  204 */                 i -= 8; continue;
/*  205 */               }  if (i >= 4) {
/*  206 */                 issuedItems.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.PURPLE, false), 1));
/*  207 */                 i -= 4; continue;
/*  208 */               }  if (i >= 2) {
/*  209 */                 issuedItems.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.BLUE, false), 1));
/*  210 */                 i -= 2; continue;
/*      */               } 
/*  212 */               issuedItems.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.GREEN, false), 1));
/*  213 */               i--;
/*      */             } 
/*      */ 
/*      */             
/*  217 */             ProgressManager.compressStacksArray(issuedItems.items);
/*  218 */             Game.i.progressManager.addItemArray(issuedItems.items, "compensation");
/*  219 */             Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  220 */             Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*  221 */             return true;
/*      */           } 
/*  223 */           return false;
/*      */         }
/*      */       } };
/*      */   public static final Comparator<? super ItemStack> ITEM_RARITY_COMPARATOR;
/*      */   
/*      */   static {
/*  229 */     ITEM_RARITY_COMPARATOR = ((paramItemStack1, paramItemStack2) -> Integer.compare(paramItemStack2.getItem().getRarity().ordinal(), paramItemStack1.getItem().getRarity().ordinal()));
/*      */   }
/*  231 */   private static final Color[] d = new Color[] { new Color(1013530111), new Color(1247523071), new Color(-1874878721), new Color(-814213633), new Color(413710591) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  238 */   private static final Color[] e = new Color[] { MaterialColor.GREEN.P400, MaterialColor.INDIGO.P300, MaterialColor.PURPLE.P300, MaterialColor.ORANGE.P500, MaterialColor.CYAN.P500 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  245 */   private static final Color[] f = new Color[] { new Color(779956991), new Color(1247523071), (new Color(-1038590977))
/*      */ 
/*      */       
/*  248 */       .lerp(0.2F, 0.3F, 0.3F, 1.0F, 0.25F), new Color(-814213633), new Color(413710591) };
/*      */ 
/*      */ 
/*      */   
/*  252 */   private static final Color[] g = new Color[] { MaterialColor.GREEN.P400, MaterialColor.INDIGO.P300, MaterialColor.PINK.P400
/*      */ 
/*      */       
/*  255 */       .cpy().lerp(0.2F, 0.3F, 0.3F, 1.0F, 0.25F), MaterialColor.ORANGE.P500, MaterialColor.CYAN.P500 };
/*      */ 
/*      */ 
/*      */   
/*  259 */   private static final String[] h = new String[] { "rarity_COMMON", "rarity_RARE", "rarity_VERY_RARE", "rarity_EPIC", "rarity_LEGENDARY" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  266 */   private static final String[] i = new String[] { "icon-star", "icon-two-stars", "icon-three-stars", "icon-four-stars", "icon-five-stars" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VideoAdViewBonus[] videoAdViewBonuses;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  276 */   private final DelayedRemovalArray<ProgressManagerListener> j = new DelayedRemovalArray(false, 1);
/*  277 */   private final _GameValueManagerListener k = new _GameValueManagerListener((byte)0);
/*      */   
/*      */   private ItemStack[] l;
/*  280 */   private static final Array<ItemStack> m = new Array(ItemStack.class); public static final int VIDEO_AD_BONUSES_CYCLE_LENGTH = 300;
/*      */   
/*      */   public ProgressManager() {
/*  283 */     if (!Config.isHeadless()) {
/*  284 */       Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> Timer.schedule(new Timer.Task(this)
/*      */             {
/*      */               public void run()
/*      */               {
/*  288 */                 ProgressManager.b(this.a);
/*      */               }
/*      */             },  2.0F));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeIssuedItemsLog() {
/*  296 */     this.b.clear();
/*  297 */     this.c = false;
/*  298 */     Gdx.files.local(PreferencesManager.getIssuedItemsFilePath()).delete();
/*      */   }
/*      */   
/*      */   public Array<IssuedItems> getIssuedItems() {
/*  302 */     if (this.b == null) {
/*  303 */       this.b = new Array(true, 1, IssuedItems.class);
/*      */       
/*      */       try {
/*      */         FileHandle fileHandle;
/*      */         
/*  308 */         if ((fileHandle = Gdx.files.local(PreferencesManager.getIssuedItemsFilePath())).exists()) {
/*      */           JsonValue jsonValue;
/*  310 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(fileHandle.readString("UTF-8"))).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*      */             try {
/*  312 */               IssuedItems issuedItems = IssuedItems.fromJson(jsonValue1);
/*  313 */               this.b.add(issuedItems);
/*  314 */             } catch (Exception exception) {
/*  315 */               a.i("failed to load issued prizes log", new Object[] { exception });
/*  316 */               this.c = true;
/*      */             }
/*      */              }
/*      */         
/*      */         } 
/*  321 */       } catch (Exception exception) {
/*  322 */         a.i("failed to load issued prizes log", new Object[] { exception });
/*  323 */         this.c = true;
/*      */       } 
/*      */     } 
/*      */     
/*  327 */     return this.b;
/*      */   }
/*      */   
/*      */   private static void b() {
/*  331 */     PP_Progress pP_Progress = (ProgressPrefs.i()).progress; ConditionalCompensation[] arrayOfConditionalCompensation; int i; byte b;
/*  332 */     for (i = (arrayOfConditionalCompensation = CONDITIONAL_COMPENSATIONS).length, b = 0; b < i; ) { ConditionalCompensation conditionalCompensation = arrayOfConditionalCompensation[b];
/*  333 */       if (!pP_Progress.isConditionalCompensationHandled(conditionalCompensation.id)) {
/*  334 */         a.i("handling conditional compensation #" + conditionalCompensation.id, new Object[0]);
/*  335 */         boolean bool = conditionalCompensation.handle();
/*  336 */         a.i("  #" + conditionalCompensation.id + " - " + (bool ? "compensation given" : "conditions not met"), new Object[0]);
/*  337 */         pP_Progress.addHandledConditionalCompensation(conditionalCompensation.id);
/*  338 */         ProgressPrefs.i().requireSave();
/*      */       } 
/*      */       b++; }
/*      */   
/*      */   }
/*      */   private static int a(int paramInt) {
/*  344 */     if (paramInt < 100) {
/*  345 */       paramInt -= paramInt % 10;
/*  346 */     } else if (paramInt < 500) {
/*  347 */       paramInt -= paramInt % 50;
/*  348 */     } else if (paramInt < 1000) {
/*  349 */       paramInt -= paramInt % 100;
/*  350 */     } else if (paramInt < 5000) {
/*  351 */       paramInt -= paramInt % 500;
/*  352 */     } else if (paramInt < 10000) {
/*  353 */       paramInt -= paramInt % 1000;
/*      */     } else {
/*  355 */       paramInt -= paramInt % 5000;
/*      */     } 
/*      */     
/*  358 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleGameOverShopOffersRotation(GameSystemProvider paramGameSystemProvider) {
/*      */     PP_Progress pP_Progress;
/*  364 */     (pP_Progress = (ProgressPrefs.i()).progress).setPlayTimeUntilShopOffersUpdate(pP_Progress.getPlayTimeUntilShopOffersUpdate() - (int)paramGameSystemProvider.statistics.getStatistic(StatisticsType.PT));
/*  365 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */ 
/*      */   
/*      */   public Array<ShopOffer> getShopOffers() {
/*      */     PP_Progress pP_Progress;
/*  371 */     if ((pP_Progress = (ProgressPrefs.i()).progress).getShopOffers() == null || (pP_Progress.getShopOffers()).size == 0 || pP_Progress.getPlayTimeUntilShopOffersUpdate() <= 0) {
/*  372 */       generateNewShopOffers();
/*      */     }
/*      */     
/*  375 */     return pP_Progress.getShopOffers();
/*      */   }
/*      */   
/*      */   public int getSecondsPlayedCorrectedForShop() {
/*  379 */     int m, i = (int)Game.i.statisticsManager.getAllTime(StatisticsType.PRT);
/*  380 */     int j = (int)(Game.i.statisticsManager.getAllTime(StatisticsType.PT) / 3.0999999046325684D);
/*  381 */     if (i < j / 2 || Game.i.statisticsManager.getAllTime(StatisticsType.PRT) > 5.4E7D || Game.i.statisticsManager.getAllTime(StatisticsType.PRT) <= 0.0D) {
/*      */       
/*  383 */       a.i("=========== Broken PRT or no progress, falling back to PT (PRT: " + i + " / PT: " + j + ")", new Object[0]);
/*  384 */       i = j;
/*      */     } 
/*  386 */     a.i("=========== secondsPlayed: " + i + ", according to in-game time: " + (int)(Game.i.statisticsManager.getAllTime(StatisticsType.PT) / 3.0999999046325684D) + ", diff: " + (i / (float)(Game.i.statisticsManager.getAllTime(StatisticsType.PT) / 3.0999999046325684D)), new Object[0]);
/*      */     
/*  388 */     j = 0;
/*  389 */     Array<Research> array = Game.i.researchManager.getInstances(); int k;
/*  390 */     for (k = 0; k < array.size; k++) {
/*      */       Research research;
/*  392 */       if ((research = (Research)array.get(k)).priceInStars == 0 && 
/*  393 */         research.type != ResearchType.DEVELOPER_MODE) {
/*  394 */         j += research.getInstalledLevel();
/*      */       }
/*      */     } 
/*  397 */     k = (int)(5597.885740693629D + -1399506.3291685237D / (i / 60.0D / 60.0D + 252.32019149803534D));
/*      */ 
/*      */     
/*  400 */     if (j > 5500) {
/*  401 */       m = i / 60 / 60;
/*      */     
/*      */     }
/*  404 */     else if ((m = MathUtils.round((float)((-1399506.32D + -252.32D * j + 1412457.08D) / (j - 5597.88D)))) < 0) {
/*  405 */       m = 0;
/*      */     } 
/*      */     
/*  408 */     a.i("=========== installed research: " + j + ", expected compared to other players: " + k, new Object[0]);
/*  409 */     a.i("=========== playtime: " + (i / 60.0F / 60.0F) + ", expected compared to other players: " + m, new Object[0]);
/*      */     
/*  411 */     if (i <= 0) {
/*  412 */       i = 1;
/*      */     }
/*  414 */     if (j < 4800) {
/*      */       
/*  416 */       float f = (float)((-146468.59D + -29.76D * j + 145673.11D) / (j - 4894.93D));
/*  417 */       a.i("=========== dev playtime according to research: " + StringFormatter.compactNumberWithPrecision(f, 1) + "h, raw multiplier: " + StringFormatter.compactNumberWithPrecision((f * 60.0F * 60.0F / i), 2), new Object[0]);
/*      */       
/*  419 */       if (f >= 1.0F && (
/*      */         
/*  421 */         f = f * 60.0F * 60.0F / i) < 1.0F) {
/*      */         
/*  423 */         float f1 = (f + 0.2F) / 1.2F;
/*      */         
/*  425 */         if ((i = (int)(i * f1)) <= 0) {
/*  426 */           i = 1;
/*      */         }
/*  428 */         a.i("=========== adjusting playtime: " + f1 + ", raw difference: " + f + ", final: " + (i / 60.0F / 60.0F), new Object[0]);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  433 */     return i;
/*      */   }
/*      */   
/*      */   public void generateNewShopOffers() {
/*  437 */     PP_Progress pP_Progress = (ProgressPrefs.i()).progress;
/*  438 */     Array array1 = new Array(true, 1, ShopOffer.class);
/*  439 */     pP_Progress.setPlayTimeUntilShopOffersUpdate(3600);
/*  440 */     pP_Progress.setCurrentShopOffersAreAfterSkip(false);
/*      */     
/*  442 */     RandomXS128 randomXS128 = pP_Progress.getOtherItemsRandom();
/*      */ 
/*      */     
/*  445 */     int i = getSecondsPlayedCorrectedForShop();
/*      */ 
/*      */     
/*  448 */     ObjectIntMap objectIntMap = new ObjectIntMap();
/*  449 */     ObjectMap objectMap = new ObjectMap();
/*      */     
/*  451 */     Array<Research> array = Game.i.researchManager.getInstances();
/*  452 */     int j = getItemsCount((Item)Item.D.BIT_DUST);
/*  453 */     for (byte b1 = 0; b1 < array.size; b1++) {
/*  454 */       Research research = (Research)array.get(b1);
/*      */       boolean bool;
/*  456 */       if (!(bool = Game.i.researchManager.canStartResearching(research, false)) && 
/*  457 */         !research.isMaxEndlessLevel()) {
/*      */         
/*  459 */         bool = true;
/*  460 */         if (research.priceInStars > 0) {
/*      */           
/*  462 */           boolean bool1 = false; byte b;
/*  463 */           for (b = 0; b < research.linksToParents.size; b++) {
/*      */             Research.ResearchLink researchLink;
/*  465 */             if ((researchLink = (Research.ResearchLink)research.linksToParents.get(b)).parent.getInstalledLevel() > 0) {
/*  466 */               bool1 = true;
/*      */               break;
/*      */             } 
/*      */           } 
/*  470 */           for (b = 0; b < research.linksToChildren.size; b++) {
/*      */             Research.ResearchLink researchLink;
/*  472 */             if ((researchLink = (Research.ResearchLink)research.linksToChildren.get(b)).child.getInstalledLevel() > 0) {
/*  473 */               bool1 = true;
/*      */               break;
/*      */             } 
/*      */           } 
/*  477 */           if (!bool1) {
/*  478 */             bool = false;
/*      */           }
/*      */           
/*  481 */           if (Game.i.researchManager.getUnusedStarsCount() < research.priceInStars) {
/*  482 */             bool = false;
/*      */           }
/*      */         } else {
/*      */           
/*  486 */           for (byte b = 0; b < research.linksToParents.size; b++) {
/*      */             Research.ResearchLink researchLink;
/*  488 */             if ((researchLink = (Research.ResearchLink)research.linksToParents.get(b)).requiredLevels > researchLink.parent.getInstalledLevel()) {
/*      */               
/*  490 */               bool = false;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*  496 */         if (bool) {
/*      */           Array array4;
/*      */           
/*  499 */           if (research.levels.length > research.getInstalledLevel()) {
/*      */             
/*  501 */             array4 = (research.levels[research.getInstalledLevel()]).price;
/*      */           } else {
/*      */             
/*  504 */             array4 = research.endlessLevel.getPrice(research.getInstalledLevel() + 1);
/*      */           } 
/*      */           
/*  507 */           for (byte b = 0; b < array4.size; b++) {
/*      */             ItemStack itemStack;
/*  509 */             if ((itemStack = ((ItemStack[])array4.items)[b]).getItem().getType() == ItemType.RESOURCE) {
/*  510 */               ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/*  511 */               if (itemStack.getCount() > Game.i.progressManager.getResources(resourceItem.resourceType))
/*      */               {
/*  513 */                 objectIntMap.getAndIncrement(resourceItem, 0, itemStack.getCount());
/*      */               }
/*  515 */             } else if (itemStack.getItem().getType() == ItemType.BIT_DUST) {
/*      */               
/*  517 */               if (itemStack.getCount() > j) {
/*  518 */                 objectIntMap.getAndIncrement(itemStack.getItem(), 0, itemStack.getCount());
/*      */               } else {
/*  520 */                 j -= itemStack.getCount();
/*      */               }
/*      */             
/*      */             }
/*  524 */             else if (itemStack.getCount() > Game.i.progressManager.getItemsCount(itemStack.getItem())) {
/*  525 */               objectIntMap.getAndIncrement(itemStack.getItem(), 0, itemStack.getCount());
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  533 */       if (research.priceInStars == 0) {
/*      */         
/*  535 */         Array array4 = research.getCumulativePrice(research.getInstalledLevel(), research.maxEndlessLevel, false);
/*  536 */         for (byte b = 0; b < array4.size; b++) {
/*  537 */           ItemStack itemStack = (ItemStack)array4.get(b);
/*      */           
/*  539 */           long l = (l = ((Long)objectMap.get(itemStack.getItem(), Long.valueOf(0L))).longValue()) + itemStack.getCount();
/*  540 */           objectMap.put(itemStack.getItem(), Long.valueOf(l));
/*      */         } 
/*      */       } 
/*      */     } 
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
/*      */     
/*  567 */     ObjectFloatMap<Item> objectFloatMap1 = new ObjectFloatMap();
/*  568 */     ObjectFloatMap<Item> objectFloatMap2 = new ObjectFloatMap();
/*      */     BlueprintItem[] arrayOfBlueprintItem;
/*      */     byte b2;
/*  571 */     for (arrayOfBlueprintItem = new BlueprintItem[] { Item.D.BLUEPRINT_AGILITY, Item.D.BLUEPRINT_EXPERIENCE, Item.D.BLUEPRINT_POWER }, b2 = 0; b2 < 3; ) { BlueprintItem blueprintItem = arrayOfBlueprintItem[b2];
/*  572 */       float f1 = ShopOfferValues.REGULAR_BLUEPRINT_VALUE.calculate(i);
/*  573 */       float f2 = ShopOfferValues.REGULAR_BLUEPRINT_QUANTITY.calculate(i);
/*  574 */       objectFloatMap1.put(blueprintItem, f1);
/*  575 */       objectFloatMap2.put(blueprintItem, f2);
/*      */       
/*      */       b2++; }
/*      */     
/*  579 */     for (arrayOfBlueprintItem = new BlueprintItem[] { Item.D.BLUEPRINT_SPECIAL_I, Item.D.BLUEPRINT_SPECIAL_II, Item.D.BLUEPRINT_SPECIAL_III, Item.D.BLUEPRINT_SPECIAL_IV }, b2 = 0; b2 < 4; ) { float f1, f2; BlueprintItem blueprintItem = arrayOfBlueprintItem[b2];
/*      */ 
/*      */       
/*  582 */       switch (null.a[blueprintItem.getBlueprintType().ordinal()]) {
/*      */         case 1:
/*  584 */           f1 = 1.0F;
/*  585 */           f2 = 7.0F;
/*      */           break;
/*      */         
/*      */         case 2:
/*  589 */           f1 = 3.6F;
/*  590 */           f2 = 4.0F;
/*      */           break;
/*      */         
/*      */         case 3:
/*  594 */           f1 = 12.24F;
/*  595 */           f2 = 2.0F;
/*      */           break;
/*      */         
/*      */         case 4:
/*  599 */           f1 = 36.72F;
/*  600 */           f2 = 1.0F;
/*      */           break;
/*      */         
/*      */         default:
/*  604 */           f1 = 1.0F;
/*  605 */           f2 = 0.5F;
/*      */           break;
/*      */       } 
/*  608 */       f1 *= 0.8F;
/*      */       
/*  610 */       objectFloatMap1.put(blueprintItem, ShopOfferValues.SPECIAL_BLUEPRINT_VALUE.calculate(i) * f1);
/*  611 */       objectFloatMap2.put(blueprintItem, ShopOfferValues.SPECIAL_BLUEPRINT_QUANTITY.calculate(i) * f2);
/*      */       
/*      */       b2++; }
/*      */ 
/*      */     
/*  616 */     objectFloatMap1.put(Item.D.ACCELERATOR, ShopOfferValues.ACCELERATOR_VALUE.calculate(i) * 0.90000004F);
/*      */ 
/*      */     
/*  619 */     objectFloatMap1.put(Item.D.GREEN_PAPER, ShopOfferValues.GREEN_PAPERS_VALUE.calculate(i));
/*  620 */     objectFloatMap2.put(Item.D.GREEN_PAPER, ShopOfferValues.GREEN_PAPERS_QUANTITY.calculate(i));
/*      */     ResourceItem[] arrayOfResourceItem;
/*      */     byte b3;
/*  623 */     for (arrayOfResourceItem = new ResourceItem[] { Item.D.RESOURCE_SCALAR, Item.D.RESOURCE_VECTOR, Item.D.RESOURCE_MATRIX, Item.D.RESOURCE_TENSOR, Item.D.RESOURCE_INFIAR }, b3 = 0; b3 < 5; ) { float f1; ResourceItem resourceItem = arrayOfResourceItem[b3];
/*      */       
/*  625 */       switch (null.b[resourceItem.resourceType.ordinal()]) {
/*      */         case 1:
/*  627 */           f1 = 1.0F;
/*      */           break;
/*      */         
/*      */         case 2:
/*  631 */           f1 = 1.3F;
/*      */           break;
/*      */         
/*      */         case 3:
/*  635 */           f1 = 1.6F;
/*      */           break;
/*      */         
/*      */         case 4:
/*  639 */           f1 = 1.9F;
/*      */           break;
/*      */         
/*      */         case 5:
/*  643 */           f1 = 2.2F;
/*      */           break;
/*      */         
/*      */         default:
/*  647 */           f1 = 1.0F;
/*      */           break;
/*      */       } 
/*      */       
/*  651 */       objectFloatMap1.put(resourceItem, ShopOfferValues.RESOURCE_VALUE.calculate(i) * f1 * 0.2F);
/*      */       
/*      */       b3++; }
/*      */ 
/*      */     
/*  656 */     float f = ((f = (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE)) - 1.0F) * 0.65F + 1.0F;
/*  657 */     a.i("bdRate " + f, new Object[0]);
/*  658 */     objectFloatMap1.put(Item.D.BIT_DUST, ShopOfferValues.BIT_DUST_VALUE.calculate(i) / f * 0.8F);
/*  659 */     objectFloatMap2.put(Item.D.BIT_DUST, ShopOfferValues.BIT_DUST_QUANTITY.calculate(i) * f * 0.8F);
/*      */     
/*      */     byte b4;
/*  662 */     for (CaseItem[] arrayOfCaseItem = { Item.D.F_CASE.create(CaseType.GREEN, false), Item.D.F_CASE.create(CaseType.BLUE, false), Item.D.F_CASE.create(CaseType.PURPLE, false), Item.D.F_CASE.create(CaseType.ORANGE, false), Item.D.F_CASE.create(CaseType.CYAN, false) }; b4 < 5; ) { float f1; byte b; CaseItem caseItem = arrayOfCaseItem[b4];
/*      */ 
/*      */ 
/*      */       
/*  666 */       switch (null.c[caseItem.caseType.ordinal()]) {
/*      */         case 1:
/*  668 */           f1 = 3.0F;
/*  669 */           b = 5;
/*      */           break;
/*      */         
/*      */         case 2:
/*  673 */           f1 = 8.0F;
/*  674 */           b = 4;
/*      */           break;
/*      */         
/*      */         case 3:
/*  678 */           f1 = 21.0F;
/*  679 */           b = 3;
/*      */           break;
/*      */         
/*      */         case 4:
/*  683 */           f1 = 55.0F;
/*  684 */           b = 2;
/*      */           break;
/*      */         
/*      */         case 5:
/*  688 */           f1 = 150.0F;
/*  689 */           b = 1;
/*      */           break;
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
/*      */ 
/*      */         
/*      */         default:
/*  716 */           f1 = 1.0F;
/*  717 */           b = 1;
/*      */           break;
/*      */       } 
/*      */       
/*  721 */       objectFloatMap1.put(caseItem, ShopOfferValues.CASE_VALUE.calculate(i) * 0.0033333334F * f1);
/*  722 */       objectFloatMap2.put(caseItem, ShopOfferValues.CASE_QUANTITY.calculate(i) * b);
/*      */       b4++; }
/*      */     
/*  725 */     Array array2 = new Array(ShopOffer.class);
/*  726 */     Array array3 = new Array(ShopOffer.class);
/*  727 */     for (b4 = 0; b4 < 3; b4++) {
/*      */       byte b8;
/*  729 */       for (Item[] arrayOfItem2 = { (Item)Item.D.BLUEPRINT_AGILITY, (Item)Item.D.BLUEPRINT_EXPERIENCE, (Item)Item.D.BLUEPRINT_POWER, (Item)Item.D.BLUEPRINT_SPECIAL_I, (Item)Item.D.BLUEPRINT_SPECIAL_II, (Item)Item.D.BLUEPRINT_SPECIAL_III, (Item)Item.D.BLUEPRINT_SPECIAL_IV }; b8 < 7; ) { Item item = arrayOfItem2[b8];
/*  730 */         int k = objectIntMap.get(item, 0);
/*  731 */         long l = ((Long)objectMap.get(item, Long.valueOf(0L))).longValue();
/*      */         
/*  733 */         if (k != 0) {
/*      */           ShopOffer shopOffer;
/*      */           
/*  736 */           if ((shopOffer = a(item, randomXS128, objectFloatMap1, objectFloatMap2, true)) != null) {
/*  737 */             array3.add(shopOffer);
/*      */           }
/*      */           
/*  740 */           if (k > 40)
/*      */           {
/*      */             
/*  743 */             if ((shopOffer = a(item, randomXS128, objectFloatMap1, objectFloatMap2, true)) != null) {
/*  744 */               array3.add(shopOffer);
/*      */             }
/*      */           }
/*      */         } 
/*      */         
/*  749 */         if (l != 0L) {
/*      */           ShopOffer shopOffer;
/*      */           
/*  752 */           if ((shopOffer = a(item, randomXS128, objectFloatMap1, objectFloatMap2, false)) != null) {
/*  753 */             array2.add(shopOffer);
/*      */           }
/*      */         } 
/*      */         
/*      */         b8++; }
/*      */       
/*  759 */       for (byte b7 = 0; b7 < 2; b7++) {
/*  760 */         for (Item[] arrayOfItem = { (Item)Item.D.F_CASE.create(CaseType.GREEN, false), (Item)Item.D.F_CASE.create(CaseType.BLUE, false), (Item)Item.D.F_CASE.create(CaseType.PURPLE, false), (Item)Item.D.F_CASE.create(CaseType.ORANGE, false), (Item)Item.D.F_CASE.create(CaseType.CYAN, false) }; i < 5; ) { Item item = arrayOfItem[i];
/*      */           ShopOffer shopOffer;
/*  762 */           if ((shopOffer = a(item, randomXS128, objectFloatMap1, objectFloatMap2, false)) != null) {
/*  763 */             array2.add(shopOffer);
/*      */           }
/*      */           i++; }
/*      */       
/*      */       } 
/*  768 */       for (Item[] arrayOfItem1 = { (Item)Item.D.F_CASE.create(CaseType.ORANGE, false), (Item)Item.D.F_CASE.create(CaseType.CYAN, false) }; b8 < 2; ) { Item item = arrayOfItem1[b8];
/*      */         ShopOffer shopOffer;
/*  770 */         if ((shopOffer = a(item, randomXS128, objectFloatMap1, objectFloatMap2, false)) != null) {
/*  771 */           array3.add(shopOffer);
/*      */         }
/*      */         
/*      */         b8++; }
/*      */       
/*  776 */       if (Game.i.progressManager.getItemsCount((Item)Item.D.GREEN_PAPER) < 950000000) {
/*  777 */         for (byte b = 0; b < 2; b++) {
/*      */           ShopOffer shopOffer;
/*  779 */           if ((shopOffer = a((Item)Item.D.GREEN_PAPER, randomXS128, objectFloatMap1, objectFloatMap2, false)) != null) {
/*  780 */             array2.add(shopOffer);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  786 */       if (Game.i.progressManager.difficultyModeAvailable(DifficultyMode.ENDLESS_I)) {
/*  787 */         int k = objectIntMap.get(Item.D.BIT_DUST, 0);
/*  788 */         long l = ((Long)objectMap.get(Item.D.BIT_DUST, Long.valueOf(0L))).longValue();
/*  789 */         if (k != 0) {
/*      */           ShopOffer shopOffer1;
/*  791 */           if ((shopOffer1 = a((Item)Item.D.BIT_DUST, randomXS128, objectFloatMap1, objectFloatMap2, true)) != null) {
/*  792 */             array3.add(shopOffer1);
/*      */           }
/*      */           
/*  795 */           if (k > 50)
/*      */           {
/*      */             
/*  798 */             if ((shopOffer1 = a((Item)Item.D.BIT_DUST, randomXS128, objectFloatMap1, objectFloatMap2, true)) != null)
/*  799 */               array3.add(shopOffer1); 
/*      */           }
/*      */         } 
/*      */         ShopOffer shopOffer;
/*  803 */         if (l > 10L && (
/*      */           
/*  805 */           shopOffer = a((Item)Item.D.BIT_DUST, randomXS128, objectFloatMap1, objectFloatMap2, false)) != null) {
/*  806 */           array2.add(shopOffer);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  813 */     for (b4 = 0; b4 < array2.size; b4++) {
/*  814 */       array2.swap(b4, randomXS128.nextInt(array2.size));
/*      */     }
/*  816 */     for (b4 = 0; b4 < array3.size; b4++) {
/*  817 */       array3.swap(b4, randomXS128.nextInt(array3.size));
/*      */     }
/*      */ 
/*      */     
/*  821 */     byte b5 = 0;
/*      */     
/*  823 */     for (byte b6 = 0; b6 < 'È' && 
/*  824 */       array1.size < 6; ) {
/*      */       ShopOffer shopOffer;
/*      */       
/*  827 */       if (array2.size != 0 && 
/*  828 */         randomXS128.nextFloat() > 0.7F && (
/*      */         
/*  830 */         (shopOffer = (ShopOffer)array2.removeIndex(0)).price.getItem() != Item.D.ACCELERATOR || b5 < 3)) {
/*  831 */         boolean bool = false;
/*  832 */         for (byte b = 0; b < array1.size; b++) {
/*      */           ShopOffer shopOffer1;
/*  834 */           if ((shopOffer1 = (ShopOffer)array1.get(b)).item.getItem().sameAs(shopOffer.item.getItem()) && shopOffer1.price.getItem().sameAs(shopOffer.price.getItem())) {
/*  835 */             bool = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*  839 */         if (!bool) {
/*  840 */           array1.add(shopOffer);
/*  841 */           if (shopOffer.price.getItem() == Item.D.ACCELERATOR) {
/*  842 */             b5++;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  848 */       if (array1.size < 6) {
/*      */ 
/*      */         
/*  851 */         if (array3.size != 0 && (
/*      */           
/*  853 */           (shopOffer = (ShopOffer)array3.removeIndex(0)).price.getItem() != Item.D.ACCELERATOR || b5 < 3)) {
/*  854 */           boolean bool = false;
/*  855 */           for (byte b = 0; b < array1.size; b++) {
/*      */             ShopOffer shopOffer1;
/*  857 */             if ((shopOffer1 = (ShopOffer)array1.get(b)).item.getItem().sameAs(shopOffer.item.getItem()) && shopOffer1.price.getItem().sameAs(shopOffer.price.getItem())) {
/*  858 */               bool = true;
/*      */               break;
/*      */             } 
/*      */           } 
/*  862 */           if (!bool) {
/*  863 */             array1.add(shopOffer);
/*  864 */             if (shopOffer.price.getItem() == Item.D.ACCELERATOR) {
/*  865 */               b5++;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/*  870 */         if (array2.size != 0 || array3.size != 0) {
/*      */           b6++;
/*      */         }
/*      */       } 
/*      */     } 
/*  875 */     pP_Progress.setShopOffers(array1);
/*  876 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */   @Null
/*      */   private ShopOffer a(Item paramItem, RandomXS128 paramRandomXS128, ObjectFloatMap<Item> paramObjectFloatMap1, ObjectFloatMap<Item> paramObjectFloatMap2, boolean paramBoolean) {
/*      */     float f;
/*  881 */     if ((f = paramObjectFloatMap2.get(paramItem, 0.0F)) > 0.0F) {
/*  882 */       float f3 = 0.8F + paramRandomXS128.nextFloat() * 0.4F; int i;
/*  883 */       for (i = 0; i < 5 && 
/*  884 */         paramRandomXS128.nextFloat() > 0.4F; i++) {
/*  885 */         f3 += paramRandomXS128.nextFloat() * 0.6F;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  892 */       i = MathUtils.round(f * f3);
/*      */ 
/*      */       
/*  895 */       Array array = new Array(true, 1, Item.class); byte b;
/*  896 */       for (b = 0; b < 6; b++) {
/*  897 */         array.add(Item.D.GREEN_PAPER);
/*      */       }
/*      */       
/*  900 */       b = (Gdx.app.getType() == Application.ApplicationType.Desktop) ? 1 : 0;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  905 */       int j = 9;
/*  906 */       if (b != 0) {
/*      */         int m;
/*      */         
/*  909 */         if ((m = getAccelerators()) < 10) {
/*  910 */           j = 1;
/*  911 */         } else if (m < 30) {
/*  912 */           j = 2;
/*  913 */         } else if (m < 80) {
/*  914 */           j = 3;
/*  915 */         } else if (m < 150) {
/*  916 */           j = 4;
/*  917 */         } else if (m < 220) {
/*  918 */           j = 5;
/*  919 */         } else if (m < 340) {
/*  920 */           j = 6;
/*  921 */         } else if (m < 500) {
/*  922 */           j = 7;
/*  923 */         } else if (m < 700) {
/*  924 */           j = 8;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*      */       int k;
/*      */ 
/*      */       
/*  932 */       if ((k = (int)Game.i.statisticsManager.getAllTime(StatisticsType.SOP)) < 40)
/*      */       {
/*  934 */         if ((j = MathUtils.round(j * k / 40.0F)) < 2) {
/*  935 */           j = 2;
/*  936 */         } else if (j > 9) {
/*  937 */           j = 9;
/*      */         } 
/*      */       }
/*      */       
/*  941 */       for (k = 0; k < j; k++) {
/*  942 */         array.add(Item.D.ACCELERATOR);
/*  943 */         if (paramBoolean && paramRandomXS128.nextFloat() > 0.4F) {
/*  944 */           array.add(Item.D.ACCELERATOR);
/*      */         }
/*      */       } 
/*  947 */       if (isResourceOpened(ResourceType.SCALAR)) {
/*  948 */         for (k = 0; k < 5; k++) {
/*  949 */           array.add(Item.D.RESOURCE_SCALAR);
/*      */         }
/*      */       } else {
/*  952 */         array.add(Item.D.GREEN_PAPER);
/*      */       } 
/*  954 */       if (isResourceOpened(ResourceType.VECTOR)) {
/*  955 */         for (k = 0; k < 4; k++) {
/*  956 */           array.add(Item.D.RESOURCE_VECTOR);
/*      */         }
/*      */       } else {
/*  959 */         array.add(Item.D.GREEN_PAPER);
/*      */       } 
/*  961 */       if (isResourceOpened(ResourceType.MATRIX)) {
/*  962 */         for (k = 0; k < 3; k++) {
/*  963 */           array.add(Item.D.RESOURCE_MATRIX);
/*      */         }
/*      */       } else {
/*  966 */         array.add(Item.D.GREEN_PAPER);
/*      */       } 
/*  968 */       if (isResourceOpened(ResourceType.TENSOR)) {
/*  969 */         for (k = 0; k < 2; k++) {
/*  970 */           array.add(Item.D.RESOURCE_TENSOR);
/*      */         }
/*      */       } else {
/*  973 */         array.add(Item.D.GREEN_PAPER);
/*      */       } 
/*      */       
/*  976 */       if (isResourceOpened(ResourceType.INFIAR)) {
/*  977 */         for (k = 0; k < 2; k++) {
/*  978 */           array.add(Item.D.RESOURCE_INFIAR);
/*      */         }
/*      */       } else {
/*  981 */         array.add(Item.D.GREEN_PAPER);
/*      */       } 
/*      */       
/*  984 */       Item item = (Item)array.get(paramRandomXS128.nextInt(array.size));
/*  985 */       while (item.sameAs(paramItem)) {
/*  986 */         if (array.size == 0) {
/*  987 */           return null;
/*      */         }
/*      */         
/*  990 */         int m = paramRandomXS128.nextInt(array.size);
/*  991 */         item = (Item)array.removeIndex(m);
/*      */       } 
/*      */       
/*  994 */       if (item instanceof com.prineside.tdi2.items.AcceleratorItem) {
/*      */         
/*  996 */         f3 *= 1.5F;
/*  997 */         i = MathUtils.round(i * 1.5F);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1002 */       float f2 = (float)((f2 = paramObjectFloatMap1.get(paramItem, 0.0F) * i) * 2.2D);
/*      */       float f1;
/* 1004 */       if ((f1 = paramObjectFloatMap1.get(item, 0.0F)) > 0.0F && f2 > 0.0F) {
/*      */         int n;
/*      */ 
/*      */ 
/*      */         
/* 1009 */         if ((n = MathUtils.round((f3 - 1.0F) / 0.5F)) <= 0) {
/* 1010 */           n = 0;
/* 1011 */         } else if (n == 1 || n == 2) {
/* 1012 */           n = 5;
/* 1013 */         } else if (n == 3 || n == 4) {
/* 1014 */           n = 10;
/* 1015 */         } else if (n == 5 || n == 6) {
/* 1016 */           n = 15;
/* 1017 */         } else if (n == 7 || n == 8) {
/* 1018 */           n = 20;
/*      */         } else {
/* 1020 */           n = 25;
/*      */         } 
/* 1022 */         if (paramRandomXS128.nextFloat() < 0.05F) {
/*      */           
/* 1024 */           n += 25 + paramRandomXS128.nextInt(3) * 5;
/* 1025 */           if (paramRandomXS128.nextFloat() < 0.1F) {
/* 1026 */             n += 5 + paramRandomXS128.nextInt(2) * 5;
/*      */           }
/*      */         } 
/* 1029 */         if (n > 75) {
/* 1030 */           n = 75;
/*      */         }
/*      */         
/*      */         long l;
/* 1034 */         if ((l = Math.round(f2 / f1)) > 500000000L)
/*      */         {
/* 1036 */           return null;
/*      */         }
/*      */         
/* 1039 */         int m = (int)l, i1 = m;
/*      */ 
/*      */         
/* 1042 */         if (n != 0) {
/* 1043 */           m = MathUtils.ceil(m * (100 - n) * 0.01F);
/*      */         }
/*      */ 
/*      */         
/* 1047 */         if (item == Item.D.ACCELERATOR)
/*      */         {
/* 1049 */           m = 1 + MathUtils.ceil((int)Math.pow(m, 0.92D));
/*      */         }
/*      */ 
/*      */         
/* 1053 */         int i2 = Game.i.progressManager.getItemsCount(item);
/* 1054 */         if (item == Item.D.GREEN_PAPER) {
/*      */           int i3;
/* 1056 */           i2 = Math.max(i3 = Game.i.purchaseManager.getPapersHourBasePrice(2147483647, 1.0F), i2);
/* 1057 */         } else if (item == Item.D.ACCELERATOR) {
/* 1058 */           i2 = Math.max(i2, 40);
/*      */         } else {
/*      */           double d;
/*      */ 
/*      */           
/* 1063 */           if ((d = Game.i.statisticsManager.getAllTime(StatisticsType.RG)) < 3000.0D) {
/* 1064 */             j = 500;
/* 1065 */           } else if (d < 20000.0D) {
/* 1066 */             j = 700;
/* 1067 */           } else if (d < 50000.0D) {
/* 1068 */             j = 1000;
/* 1069 */           } else if (d < 120000.0D) {
/* 1070 */             j = 2000;
/* 1071 */           } else if (d < 250000.0D) {
/* 1072 */             j = 3000;
/* 1073 */           } else if (d < 500000.0D) {
/* 1074 */             j = 4000;
/* 1075 */           } else if (d < 1000000.0D) {
/* 1076 */             j = 5000;
/*      */           } else {
/* 1078 */             j = 6000;
/*      */           } 
/* 1080 */           i2 = Math.max(i2, j);
/*      */         } 
/*      */         
/* 1083 */         float f5 = 0.0F;
/* 1084 */         if (m > i2 * 1.35F) {
/*      */ 
/*      */           
/* 1087 */           float f8 = (f8 = i2 / m) * (0.75F + paramRandomXS128.nextFloat() * 0.6F);
/*      */ 
/*      */           
/* 1090 */           if ((j = MathUtils.round(i * f8)) <= 0) {
/* 1091 */             return null;
/*      */           }
/*      */           
/* 1094 */           float f7 = j / i;
/*      */           int i3;
/* 1096 */           if ((i3 = MathUtils.round(m * f7)) <= 0) {
/* 1097 */             return null;
/*      */           }
/*      */           
/* 1100 */           f5 = f7;
/* 1101 */           i1 = MathUtils.round(i1 * f7);
/* 1102 */           m = i3;
/* 1103 */           i = j;
/*      */         } 
/*      */ 
/*      */         
/* 1107 */         m = b(m);
/* 1108 */         i = b(i);
/*      */ 
/*      */ 
/*      */         
/* 1112 */         if ((n = 100 - MathUtils.ceil(1.0F / i1 / m * 100.0F)) <= 2) {
/* 1113 */           n = 0;
/*      */         }
/*      */         
/* 1116 */         if (paramItem == Item.D.GREEN_PAPER)
/*      */         {
/* 1118 */           if (item == Item.D.ACCELERATOR) {
/*      */             
/* 1120 */             int i3 = (int)(Game.i.purchaseManager.getPapersHourBasePrice() / 30L * m);
/* 1121 */             if (i < i3) {
/*      */ 
/*      */               
/* 1124 */               i = b(i = (int)(i3 * (1.0F + paramRandomXS128.nextFloat() * 0.4F)));
/* 1125 */               a.i("  " + i, new Object[0]);
/*      */             } 
/* 1127 */           } else if (item instanceof ResourceItem) {
/*      */             
/* 1129 */             Array array1 = new Array(true, 1, ItemStack.class);
/* 1130 */             item.addSellItems(array1);
/* 1131 */             for (j = 0; j < array1.size; j++) {
/*      */               ItemStack itemStack;
/* 1133 */               if ((itemStack = (ItemStack)array1.get(j)).getItem() == Item.D.GREEN_PAPER) {
/* 1134 */                 int i3 = itemStack.getCount() * m;
/* 1135 */                 if (i < i3) {
/*      */ 
/*      */                   
/* 1138 */                   i = b(i = (int)(i3 * (1.2F + paramRandomXS128.nextFloat() * 0.6F)));
/* 1139 */                   a.i("  " + i, new Object[0]);
/*      */                 } 
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/* 1147 */         if (b != 0 && item == Item.D.ACCELERATOR && 
/* 1148 */           getAccelerators() < m)
/*      */         {
/* 1150 */           return null;
/*      */         }
/*      */ 
/*      */         
/* 1154 */         float f6 = 0.0F;
/*      */         float f4;
/* 1156 */         if (i2 > 0 && (
/*      */ 
/*      */           
/* 1159 */           f4 = m / i2) < 0.03F) {
/*      */           
/* 1161 */           float f7 = 0.03F / f4;
/*      */ 
/*      */           
/* 1164 */           if (item == Item.D.ACCELERATOR) {
/* 1165 */             f7 = Math.min(f7, 2.0F);
/*      */           }
/* 1167 */           if (f7 > 4.0F) {
/* 1168 */             f7 = 4.0F;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/* 1173 */           f6 = f7 = f7 + paramRandomXS128.nextFloat();
/*      */           
/* 1175 */           m = MathUtils.round(m * f7);
/* 1176 */           i = MathUtils.round(i * f7);
/*      */           
/* 1178 */           m = b(m);
/* 1179 */           i = b(i);
/*      */         } 
/*      */ 
/*      */         
/* 1183 */         ItemStack itemStack1 = new ItemStack(item, m);
/* 1184 */         ItemStack itemStack2 = new ItemStack(paramItem, i);
/*      */         ShopOffer shopOffer;
/* 1186 */         (shopOffer = new ShopOffer(itemStack1, itemStack2, n)).reducedDueToLargePrice = f5;
/* 1187 */         shopOffer.increasedDueToLowPrice = f6;
/* 1188 */         return shopOffer;
/*      */       } 
/*      */     } 
/*      */     
/* 1192 */     return null;
/*      */   }
/*      */   
/*      */   private static int b(int paramInt) {
/* 1196 */     if (paramInt < 100)
/* 1197 */       return paramInt; 
/* 1198 */     if (paramInt < 1000)
/* 1199 */       return MathUtils.round(paramInt * 0.1F) * 10; 
/* 1200 */     if (paramInt < 10000)
/* 1201 */       return MathUtils.round(paramInt * 0.01F) * 100; 
/* 1202 */     if (paramInt < 100000)
/* 1203 */       return MathUtils.round(paramInt * 0.001F) * 1000; 
/* 1204 */     if (paramInt < 1000000) {
/* 1205 */       return MathUtils.round(paramInt * 1.0E-4F) * 10000;
/*      */     }
/* 1207 */     return MathUtils.round(paramInt * 1.0E-5F) * 100000;
/*      */   }
/*      */ 
/*      */   
/*      */   public void generateNewLuckyWheel() {
/*      */     PP_Progress pP_Progress;
/* 1213 */     if ((pP_Progress = (ProgressPrefs.i()).progress).isLuckyWheelSpinAvailable()) {
/* 1214 */       a.e("Spin available, can't rebuild", new Object[0]);
/*      */       return;
/*      */     } 
/* 1217 */     ProgressPrefs.i().requireSave();
/*      */     
/* 1219 */     InventoryStatistics inventoryStatistics = getInventoryStatistics();
/* 1220 */     RandomXS128 randomXS128 = pP_Progress.getLuckyWheelWheelRandom();
/*      */     
/* 1222 */     pP_Progress.setLuckyWheelCurrentMultiplier(1);
/*      */ 
/*      */     
/* 1225 */     Array array1 = new Array(LuckyWheelOverlay.WheelOption.class);
/*      */     
/*      */     float f;
/* 1228 */     if ((f = (float)Game.i.statisticsManager.getAllTime(StatisticsType.PT)) > 0.0F) {
/* 1229 */       float f1 = 1.0F / f / 60.0F / 20.0F;
/* 1230 */       float f2 = 1.0F / f / 60.0F / 50.0F;
/*      */       
/*      */       float f3;
/*      */       
/* 1234 */       if ((f3 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.GPG) * f1) < 1000.0F) f3 = 1000.0F; 
/* 1235 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.GREEN_PAPER, 
/* 1236 */               a((int)(f3 * 1.5F))), 5.0F));
/*      */       
/* 1238 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.GREEN_PAPER, 
/* 1239 */               a((int)f3)), 10.0F));
/*      */       
/* 1241 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.GREEN_PAPER, 
/* 1242 */               a((int)(f3 * 0.5F))), 15.0F));
/*      */ 
/*      */       
/*      */       float f4;
/*      */       
/* 1247 */       if ((f4 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.RG_S) * f2) < 200.0F) f4 = 200.0F; 
/* 1248 */       if (isResourceOpened(ResourceType.SCALAR)) {
/* 1249 */         array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_SCALAR, 
/* 1250 */                 a(StrictMath.round(f4))), 10.0F));
/*      */       }
/*      */       
/*      */       float f5;
/*      */       
/* 1255 */       if ((f5 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.RG_V) * f2) < 200.0F) f5 = 200.0F; 
/* 1256 */       if (isResourceOpened(ResourceType.VECTOR)) {
/* 1257 */         array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_VECTOR, 
/* 1258 */                 a(StrictMath.round(f5))), 9.0F));
/*      */       }
/*      */       
/*      */       float f6;
/*      */       
/* 1263 */       if ((f6 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.RG_M) * f2) < 150.0F) f6 = 150.0F; 
/* 1264 */       if (isResourceOpened(ResourceType.MATRIX)) {
/* 1265 */         array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_MATRIX, 
/* 1266 */                 a(StrictMath.round(f6))), 8.0F));
/*      */       }
/*      */       
/*      */       float f7;
/*      */       
/* 1271 */       if ((f7 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.RG_T) * f2) < 150.0F) f7 = 150.0F; 
/* 1272 */       if (isResourceOpened(ResourceType.TENSOR)) {
/* 1273 */         array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_TENSOR, 
/* 1274 */                 a(StrictMath.round(f7))), 7.0F));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1279 */       if ((f2 = (float)Game.i.statisticsManager.getAllTime(StatisticsType.RG_I) * f2) < 100.0F) f2 = 100.0F; 
/* 1280 */       if (isResourceOpened(ResourceType.INFIAR)) {
/* 1281 */         array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_INFIAR, 
/* 1282 */                 a(StrictMath.round(f2))), 6.0F));
/*      */       }
/*      */     } 
/*      */     
/* 1286 */     array1.add(new LuckyWheelOverlay.WheelOption(null, 7.0F, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1291 */     array1.add(new LuckyWheelOverlay.WheelOption(null, 3.0F, 3));
/*      */ 
/*      */     
/*      */     int j;
/*      */ 
/*      */     
/* 1297 */     for (BlueprintType[] arrayOfBlueprintType = { BlueprintType.EXPERIENCE, BlueprintType.AGILITY, BlueprintType.POWER }; j < 3; ) { BlueprintType blueprintType = arrayOfBlueprintType[j];
/* 1298 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_BLUEPRINT
/* 1299 */               .create(blueprintType), 10), 10.0F));
/*      */       
/*      */       j++; }
/*      */     
/* 1303 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_I, 3), 7.0F));
/*      */ 
/*      */     
/* 1306 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_II, 2), 6.0F));
/*      */ 
/*      */     
/* 1309 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_III, 1), 5.0F));
/*      */ 
/*      */ 
/*      */     
/* 1313 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.ABILITY_TOKEN, 1), 6.0F));
/*      */ 
/*      */     
/* 1316 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.ABILITY_TOKEN, 2), 3.0F));
/*      */ 
/*      */     
/* 1319 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.BDFTPG) > 0.0D) {
/* 1320 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, 3), 10.0F));
/*      */ 
/*      */       
/* 1323 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, 5), 5.0F));
/*      */ 
/*      */       
/* 1326 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, 7), 3.0F));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1331 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.CASE_KEY_BLUE, 5), 10.0F));
/*      */ 
/*      */     
/* 1334 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.CASE_KEY_PURPLE, 5), 8.0F));
/*      */ 
/*      */     
/* 1337 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.CASE_KEY_ORANGE, 5), 6.0F));
/*      */ 
/*      */     
/* 1340 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.CASE_KEY_CYAN, 5), 4.0F));
/*      */ 
/*      */ 
/*      */     
/* 1344 */     FastRandom.random.setSeed(randomXS128.nextInt(500000));
/* 1345 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_RANDOM_TILE
/* 1346 */             .create(0.3F), 6), 10.0F));
/*      */     
/* 1348 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_RANDOM_TILE
/* 1349 */             .create(0.5F), 5), 9.0F));
/*      */     
/* 1351 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_RANDOM_TILE
/* 1352 */             .create(0.7F), 4), 8.0F));
/*      */     
/* 1354 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_RANDOM_TILE
/* 1355 */             .create(0.9F), 3), 7.0F));
/*      */     
/* 1357 */     for (byte b1 = 0; b1 < 10; b1++) {
/*      */       float f1;
/* 1359 */       if ((f1 = (b1 + 1) / 10.0F * 2.0F) > 1.0F) f1 = 1.0F; 
/* 1360 */       j = 1;
/* 1361 */       if (f1 < 0.2F) {
/* 1362 */         j = 3;
/* 1363 */       } else if (f1 < 0.4F) {
/* 1364 */         j = 2;
/*      */       } 
/* 1366 */       if (FastRandom.random.nextFloat() < 0.8F) {
/* 1367 */         j = (int)(j * 2.0F);
/*      */       }
/* 1369 */       if (FastRandom.random.nextFloat() < 0.6F) {
/* 1370 */         j = (int)(j * 1.5F);
/*      */       }
/* 1372 */       if (FastRandom.random.nextFloat() < 0.4F) {
/* 1373 */         j = (int)(j * 1.3F);
/*      */       }
/*      */       
/* 1376 */       array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_TILE
/* 1377 */               .create(Game.i.tileManager.createRandomTile(f1, FastRandom.random, inventoryStatistics)), j), 10.0F - f1 * 5.0F));
/*      */     } 
/*      */ 
/*      */     
/* 1381 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE
/* 1382 */             .create(CaseType.GREEN, false), 1), 8.0F));
/*      */ 
/*      */     
/* 1385 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE
/* 1386 */             .create(CaseType.BLUE, false), 1), 6.0F));
/*      */ 
/*      */     
/* 1389 */     array1.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE
/* 1390 */             .create(CaseType.PURPLE, false), 1), 4.0F));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1395 */     array1.add(new LuckyWheelOverlay.WheelOption(
/* 1396 */           ItemManager.generateItemByRarity(FastRandom.random, RarityType.COMMON, 1.0F, 16.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, false, inventoryStatistics), 10.0F));
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
/*      */ 
/*      */ 
/*      */     
/* 1411 */     if ((((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem().getType() == ItemType.TILE) {
/*      */       TileItem tileItem1;
/*      */       
/* 1414 */       if ((tileItem1 = (TileItem)(((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem()).tile.type == TileType.PLATFORM || tileItem1.tile.type == TileType.ROAD) {
/* 1415 */         (((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.setCount(5);
/*      */       }
/*      */     } 
/* 1418 */     array1.add(new LuckyWheelOverlay.WheelOption(
/* 1419 */           ItemManager.generateItemByRarity(FastRandom.random, RarityType.RARE, 1.0F, 8.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, false, inventoryStatistics), 8.0F));
/*      */ 
/*      */     
/* 1422 */     if ((((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem().getType() == ItemType.TILE) {
/*      */       TileItem tileItem1;
/*      */       
/* 1425 */       if ((tileItem1 = (TileItem)(((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem()).tile.type == TileType.PLATFORM) {
/* 1426 */         (((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.setCount(4);
/*      */       }
/*      */     } 
/* 1429 */     array1.add(new LuckyWheelOverlay.WheelOption(
/* 1430 */           ItemManager.generateItemByRarity(FastRandom.random, RarityType.VERY_RARE, 1.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, false, inventoryStatistics), 6.0F));
/*      */ 
/*      */     
/* 1433 */     if ((((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem().getType() == ItemType.TILE) {
/*      */       TileItem tileItem1;
/*      */       
/* 1436 */       if ((tileItem1 = (TileItem)(((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem()).tile.type == TileType.PLATFORM) {
/* 1437 */         (((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.setCount(3);
/*      */       }
/*      */     } 
/* 1440 */     array1.add(new LuckyWheelOverlay.WheelOption(
/* 1441 */           ItemManager.generateItemByRarity(FastRandom.random, RarityType.EPIC, 1.0F, 2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, false, inventoryStatistics), 4.0F));
/*      */ 
/*      */     
/* 1444 */     if ((((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem().getType() == ItemType.TILE) {
/*      */       TileItem tileItem1;
/*      */       
/* 1447 */       if ((tileItem1 = (TileItem)(((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.getItem()).tile.type == TileType.PLATFORM) {
/* 1448 */         (((LuckyWheelOverlay.WheelOption[])array1.items)[array1.size - 1]).item.setCount(3);
/*      */       }
/*      */     } 
/*      */     
/* 1452 */     Array array2 = new Array(LuckyWheelOverlay.WheelOption.class);
/*      */ 
/*      */     
/* 1455 */     Array<Research> array = Game.i.researchManager.getInstances();
/* 1456 */     Array array3 = new Array(Research.ResearchLevel.class); int k;
/* 1457 */     for (k = 0; k < array.size; k++) {
/*      */       Research research;
/* 1459 */       if (!(research = ((Research[])array.items)[k]).isMaxNormalLevel() && 
/* 1460 */         Game.i.researchManager.canStartResearching(research, true))
/*      */       {
/* 1462 */         if (!Game.i.researchManager.canStartResearching(research, false))
/*      */         {
/* 1464 */           array3.add(research.levels[research.getInstalledLevel()]);
/*      */         }
/*      */       }
/*      */     } 
/*      */     
/* 1469 */     if (array3.size > 0) {
/*      */       
/* 1471 */       for (k = array3.size - 1; k >= 0; k--) {
/* 1472 */         int n = randomXS128.nextInt(k + 1);
/* 1473 */         array3.swap(k, n);
/*      */       } 
/* 1475 */       for (k = 0; k < StrictMath.min(array3.size, 5); k++) {
/* 1476 */         for (byte b = 0; b < (((Research.ResearchLevel[])array3.items)[k]).price.size; b++) {
/* 1477 */           ItemStack itemStack = ((ItemStack[])(((Research.ResearchLevel[])array3.items)[k]).price.items)[b];
/*      */           int n;
/* 1479 */           if ((n = getItemsCount(itemStack.getItem())) < itemStack.getCount())
/*      */           {
/* 1481 */             if (itemStack.getItem().getType() == ItemType.GREEN_PAPER || itemStack.getItem().getType() == ItemType.RESOURCE || itemStack.getItem().getType() == ItemType.BLUEPRINT) {
/* 1482 */               array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack(itemStack), 6.0F - itemStack
/* 1483 */                     .getItem().getRarity().ordinal()));
/*      */             }
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1492 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.BDFTPG) > 0.0D) {
/* 1493 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, 10), 4.0F));
/*      */ 
/*      */       
/* 1496 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, 15), 2.5F));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1502 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.BDFTPG) > 0.0D && 
/* 1503 */       getResources(ResourceType.INFIAR) < 5000) {
/* 1504 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_INFIAR, 1000), 6.0F));
/*      */ 
/*      */       
/* 1507 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_INFIAR, 2000), 2.0F));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1514 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE
/* 1515 */             .create(CaseType.ORANGE, false), 2), 3.0F));
/*      */ 
/*      */     
/* 1518 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE
/* 1519 */             .create(CaseType.CYAN, false), 1), 2.0F));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1528 */     array2.add(new LuckyWheelOverlay.WheelOption(null, 7.0F, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1533 */     array2.add(new LuckyWheelOverlay.WheelOption(null, 3.0F, 3));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1539 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.LOOT_BOOST, 1), 5.0F));
/*      */ 
/*      */ 
/*      */     
/* 1543 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 2), 1.0F));
/*      */ 
/*      */ 
/*      */     
/* 1547 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1), 3.0F));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1553 */     CoreTile coreTile = ((CoreTile.CoreTileFactory)Game.i.tileManager.getFactory(TileType.CORE)).createRandom(0.5F, FastRandom.random);
/* 1554 */     array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_TILE
/* 1555 */             .create((Tile)coreTile), 1), 2.0F));
/*      */ 
/*      */     
/* 1558 */     if (FastRandom.random.nextFloat() < 0.15F) {
/* 1559 */       coreTile = ((CoreTile.CoreTileFactory)Game.i.tileManager.getFactory(TileType.CORE)).createRandom(0.7F, FastRandom.random);
/* 1560 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_TILE
/* 1561 */               .create((Tile)coreTile), 1), 1.0F));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1567 */     TileItem tileItem = Item.D.F_TILE.create(Game.i.tileManager.getFactory(TileType.ROAD).create());
/* 1568 */     if (getItemsCount((Item)tileItem) < 50)
/*      */     {
/* 1570 */       array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)tileItem, 10), 2.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1578 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.BROOT_BOSS, false) && 
/* 1579 */       !Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.SNAKE_BOSS_HEAD, false) && 
/* 1580 */       !Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.METAPHOR_BOSS, false) && 
/* 1581 */       !Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.MOBCHAIN_BOSS_HEAD, false) && 
/* 1582 */       !Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.CONSTRUCTOR_BOSS, false)) {
/*      */       byte b; BossTileType[] arrayOfBossTileType;
/*      */       int n;
/* 1585 */       for (n = (arrayOfBossTileType = BossTileType.values).length, b = 0; b < n; ) {
/* 1586 */         BossTileType bossTileType; if ((bossTileType = arrayOfBossTileType[b]) != BossTileType.CUSTOM && bossTileType != BossTileType.ONE) {
/*      */ 
/*      */           
/* 1589 */           TileItem tileItem1 = Item.D.F_TILE.create((Tile)((BossTile.BossTileFactory)Game.i.tileManager.getFactory(TileType.BOSS)).createWithTileType(bossTileType));
/* 1590 */           if (getItemsCount((Item)tileItem1) == 0)
/* 1591 */             array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)tileItem1, 1), 1.5F)); 
/*      */         } 
/*      */         b++;
/*      */       } 
/*      */     } 
/*      */     byte b2;
/*      */     BossType[] arrayOfBossType;
/*      */     int m;
/* 1599 */     for (m = (arrayOfBossType = BossType.values).length, b2 = 0; b2 < m; ) { BossType bossType = arrayOfBossType[b2];
/* 1600 */       EnemyType enemyType = null;
/* 1601 */       switch (null.d[bossType.ordinal()]) { case 1:
/* 1602 */           enemyType = EnemyType.BROOT_BOSS; break;
/* 1603 */         case 2: enemyType = EnemyType.SNAKE_BOSS_HEAD; break;
/* 1604 */         case 3: enemyType = EnemyType.METAPHOR_BOSS; break;
/* 1605 */         case 4: enemyType = EnemyType.MOBCHAIN_BOSS_HEAD; break;
/* 1606 */         case 5: enemyType = EnemyType.CONSTRUCTOR_BOSS; break; }
/*      */       
/* 1608 */       if (enemyType != null && !Game.i.enemyManager.isEnemyTypeNewForPlayer(enemyType, false)) {
/*      */         BossTile bossTile;
/* 1610 */         (bossTile = ((BossTile.BossTileFactory)Game.i.tileManager.getFactory(TileType.BOSS)).createWithTileType(BossTileType.ONE)).oneBossType = bossType;
/* 1611 */         TileItem tileItem1 = Item.D.F_TILE.create((Tile)bossTile);
/*      */         
/* 1613 */         if (getItemsCount((Item)tileItem1) == 0) {
/* 1614 */           array2.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)tileItem1, 1), 1.5F));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*      */       b2++; }
/*      */ 
/*      */ 
/*      */     
/* 1623 */     Array array4 = new Array(LuckyWheelOverlay.WheelOption.class);
/* 1624 */     m = (randomXS128.nextFloat() < 0.33F) ? 3 : 2;
/* 1625 */     b2 = 0;
/*      */     int i;
/* 1627 */     for (i = array2.size - 1; i >= 0; i--) {
/* 1628 */       int n = randomXS128.nextInt(i + 1);
/* 1629 */       array2.swap(i, n);
/*      */     } 
/* 1631 */     while (array4.size < m && 
/* 1632 */       array2.size != 0) {
/*      */       LuckyWheelOverlay.WheelOption wheelOption;
/*      */       
/* 1635 */       if ((wheelOption = (LuckyWheelOverlay.WheelOption)array2.removeIndex(0)).item != null && wheelOption.item.getItem().getRarity() == RarityType.LEGENDARY) {
/* 1636 */         if (b2 < 2)
/* 1637 */         { b2++; } else { continue; } 
/* 1638 */       } else if (array4.size == m - 1 && b2 == 0) {
/*      */         
/* 1640 */         for (byte b = 0; b < array2.size; b++) {
/* 1641 */           if ((((LuckyWheelOverlay.WheelOption[])array2.items)[b]).item != null && (((LuckyWheelOverlay.WheelOption[])array2.items)[b]).item.getItem().getRarity() == RarityType.LEGENDARY) {
/* 1642 */             wheelOption = (LuckyWheelOverlay.WheelOption)array2.removeIndex(b);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1648 */       array4.add(wheelOption);
/*      */     } 
/*      */ 
/*      */     
/* 1652 */     for (i = array1.size - 1; i >= 0; i--) {
/* 1653 */       int n = randomXS128.nextInt(i + 1);
/* 1654 */       array1.swap(i, n);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1660 */     while (array4.size < 8) {
/*      */       LuckyWheelOverlay.WheelOption wheelOption;
/* 1662 */       if ((wheelOption = (LuckyWheelOverlay.WheelOption)array1.removeIndex(0)).item != null && wheelOption.item.getItem().getRarity() == RarityType.LEGENDARY)
/* 1663 */         if (b2 < 3) {
/* 1664 */           b2++;
/*      */         } else {
/*      */           continue;
/* 1667 */         }   array4.add(wheelOption);
/*      */       
/* 1669 */       if (array4.size == 7)
/*      */       {
/* 1671 */         if (randomXS128.nextFloat() < 0.5F) {
/* 1672 */           boolean bool = false;
/* 1673 */           for (byte b = 0; b < array4.size; b++) {
/* 1674 */             if ((((LuckyWheelOverlay.WheelOption[])array4.items)[b]).wheelMultiplier != 0) {
/* 1675 */               bool = true;
/*      */               break;
/*      */             } 
/*      */           } 
/* 1679 */           if (!bool)
/*      */           {
/* 1681 */             array4.add(new LuckyWheelOverlay.WheelOption(null, 5.0F, 2));
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1687 */     for (i = 0; i < array4.size; i++) {
/*      */       LuckyWheelOverlay.WheelOption wheelOption;
/* 1689 */       if ((wheelOption = ((LuckyWheelOverlay.WheelOption[])array4.items)[i]).item != null) {
/* 1690 */         if (wheelOption.item.getItem().getType() == ItemType.GREEN_PAPER && wheelOption.item.getCount() > 100000) {
/* 1691 */           wheelOption.item.setCount(100000);
/* 1692 */         } else if (wheelOption.item.getItem().getType() == ItemType.RESOURCE && wheelOption.item.getCount() > 20000) {
/* 1693 */           wheelOption.item.setCount(20000);
/* 1694 */         } else if (wheelOption.item.getItem().getType() == ItemType.BLUEPRINT && wheelOption.item.getCount() > 1000) {
/* 1695 */           wheelOption.item.setCount(1000);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1700 */     i = 1;
/* 1701 */     if (FastRandom.random.nextFloat() < 0.15F) {
/* 1702 */       i = 2;
/* 1703 */     } else if (FastRandom.random.nextFloat() < 0.05F) {
/* 1704 */       i = 3;
/*      */     } 
/* 1706 */     if (i != 1) {
/* 1707 */       for (byte b = 0; b < array4.size; b++) {
/*      */         LuckyWheelOverlay.WheelOption wheelOption;
/* 1709 */         if ((wheelOption = ((LuckyWheelOverlay.WheelOption[])array4.items)[b]).item != null && wheelOption.item.getCount() > 1) {
/* 1710 */           wheelOption.item.setCount(wheelOption.item.getCount() * i);
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/* 1715 */     if (FastRandom.random.nextFloat() < 0.015F) {
/*      */       int i1;
/* 1717 */       array4.clear();
/*      */       
/* 1719 */       boolean bool1 = (f > 86400.0F) ? true : false;
/* 1720 */       boolean bool2 = (f > 900000.0F) ? true : false;
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
/*      */ 
/*      */ 
/*      */       
/* 1735 */       LuckyWheelOverlay.WheelOption[] arrayOfWheelOption = { new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BLUEPRINT_SPECIAL_I, bool2 ? 3 : (bool1 ? 2 : 1)), 10.0F), new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.RESOURCE_INFIAR, bool2 ? 400 : (bool1 ? 200 : 100)), 10.0F), new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.F_CASE.create(bool2 ? CaseType.CYAN : (bool1 ? CaseType.ORANGE : CaseType.PURPLE), false), 1), 10.0F), new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.BIT_DUST, bool2 ? 10 : (bool1 ? 5 : 1)), 10.0F), new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.GREEN_PAPER, bool2 ? 20000 : (bool1 ? 5000 : 1000)), 10.0F) };
/*      */ 
/*      */       
/* 1738 */       int n = FastRandom.random.nextInt(5);
/* 1739 */       LuckyWheelOverlay.WheelOption wheelOption2 = arrayOfWheelOption[n];
/* 1740 */       array4.add(wheelOption2);
/* 1741 */       wheelOption2.item.setCount(MathUtils.ceil(wheelOption2.item.getCount() * 0.5F));
/*      */       
/*      */       do {
/* 1744 */         i1 = FastRandom.random.nextInt(5);
/* 1745 */       } while (n == i1);
/*      */       
/*      */       LuckyWheelOverlay.WheelOption wheelOption1;
/* 1748 */       (wheelOption1 = arrayOfWheelOption[i1]).chance *= 0.5F;
/* 1749 */       array4.add(wheelOption1);
/*      */       
/* 1751 */       array4.add(new LuckyWheelOverlay.WheelOption(new ItemStack((Item)Item.D.GREEN_PAPER, 1), 1.0F));
/*      */       byte b;
/* 1753 */       for (b = 0; b < 2; b++) {
/* 1754 */         array4.add(new LuckyWheelOverlay.WheelOption(null, 4.0F, 3));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1760 */       for (b = 0; b < 5; b++) {
/* 1761 */         array4.add(new LuckyWheelOverlay.WheelOption(null, 7.0F, 2));
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1770 */     double d = Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.LUCKY_WHEEL_BONUS_X2_CHANCE);
/* 1771 */     if (FastRandom.random.nextFloat() < d) {
/* 1772 */       array4.add(new LuckyWheelOverlay.WheelOption(null, 10.0F, 2));
/*      */     }
/*      */     
/* 1775 */     array4.sort((paramWheelOption1, paramWheelOption2) -> Float.compare(paramWheelOption1.chance, paramWheelOption2.chance));
/* 1776 */     for (i = 0; i < array4.size / 2; i += 2) {
/* 1777 */       array4.swap(i, array4.size - 1 - i);
/*      */     }
/*      */     
/* 1780 */     pP_Progress.setLuckyWheelOptions(array4);
/* 1781 */     pP_Progress.setLuckyWheelLastRotation(0.0F);
/* 1782 */     pP_Progress.setLuckyWheelLastWeaponAngle(0.0F);
/* 1783 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */   
/*      */   public Array<LuckyWheelOverlay.WheelOption> getLuckyWheelOptions() {
/* 1787 */     if ((ProgressPrefs.i()).progress.getLuckyWheelOptions() == null || ((ProgressPrefs.i()).progress.getLuckyWheelOptions()).size == 0) {
/* 1788 */       generateNewLuckyWheel();
/*      */     }
/*      */     
/* 1791 */     return (ProgressPrefs.i()).progress.getLuckyWheelOptions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLuckyWheelSpinAvailable() {
/* 1798 */     return (ProgressPrefs.i()).progress.isLuckyWheelSpinAvailable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSecondsTillLuckyWheelSpinAvailable() {
/*      */     long l;
/* 1806 */     int i = (int)((l = Game.getTimestampMillis() - Game.i.authManager.getLastLoadFromCloudTimestamp()) / 1000L);
/*      */     
/* 1808 */     return Math.max(i = 45 - i, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLuckyWheelRespinPriceTokens() {
/* 1815 */     if ((ProgressPrefs.i()).progress.isLuckyWheelSpinAvailable()) return 0;
/*      */     
/* 1817 */     Array<LuckyWheelOverlay.WheelOption> array = getLuckyWheelOptions();
/* 1818 */     if (c()) {
/* 1819 */       return 0;
/*      */     }
/*      */     
/* 1822 */     if ((ProgressPrefs.i()).progress.getLuckyWheelCurrentMultiplier() >= 4)
/*      */     {
/* 1824 */       return 0;
/*      */     }
/*      */     
/* 1827 */     if (array.size >= 6) {
/* 1828 */       return 2;
/*      */     }
/* 1830 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean c() {
/* 1835 */     Array<LuckyWheelOverlay.WheelOption> array = getLuckyWheelOptions();
/*      */     
/* 1837 */     byte b1 = 0; byte b2;
/* 1838 */     for (b2 = 0; b2 < array.size; b2++) {
/* 1839 */       if (((LuckyWheelOverlay.WheelOption)array.get(b2)).item != null) {
/* 1840 */         b1++;
/*      */       }
/*      */     } 
/* 1843 */     if (b1 == 0) return true;
/*      */ 
/*      */     
/* 1846 */     if (b1 == 1) {
/* 1847 */       for (b2 = 0; b2 < array.size; b2++) {
/* 1848 */         if (((LuckyWheelOverlay.WheelOption)array.get(b2)).item != null && 
/* 1849 */           ((LuckyWheelOverlay.WheelOption)array.get(b2)).item.getItem().getType() == ItemType.GREEN_PAPER && ((LuckyWheelOverlay.WheelOption)array.get(b2)).item.getCount() < 500)
/*      */         {
/* 1851 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1857 */     return false;
/*      */   }
/*      */   public int getLuckyWheelRespinPriceAccelerators() {
/*      */     int i;
/* 1861 */     if ((ProgressPrefs.i()).progress.isLuckyWheelSpinAvailable()) return 0;
/*      */     
/* 1863 */     Array<LuckyWheelOverlay.WheelOption> array = getLuckyWheelOptions();
/*      */     
/* 1865 */     if (c()) {
/* 1866 */       return 0;
/*      */     }
/*      */ 
/*      */     
/* 1870 */     if (array.size >= 7) {
/* 1871 */       i = 10;
/* 1872 */     } else if (array.size == 6) {
/* 1873 */       i = 20;
/* 1874 */     } else if (array.size == 5) {
/* 1875 */       i = 30;
/* 1876 */     } else if (array.size == 4) {
/* 1877 */       i = 40;
/* 1878 */     } else if (array.size == 3) {
/* 1879 */       i = 50;
/*      */     } else {
/* 1881 */       i = 0;
/*      */     } 
/*      */     
/* 1884 */     if (i) {
/*      */       
/* 1886 */       byte b1 = 0;
/* 1887 */       for (byte b2 = 0; b2 < array.size; b2++) {
/* 1888 */         if (((LuckyWheelOverlay.WheelOption)array.get(b2)).item == null) {
/* 1889 */           b1++;
/*      */         }
/*      */       } 
/* 1892 */       if (b1 >= 3) {
/* 1893 */         i += (b1 - 3) * 10;
/*      */       }
/* 1895 */       if ((ProgressPrefs.i()).progress.getLuckyWheelCurrentMultiplier() > 1) {
/* 1896 */         a.i("respin mult " + (ProgressPrefs.i()).progress.getLuckyWheelCurrentMultiplier(), new Object[0]);
/* 1897 */         i += ((ProgressPrefs.i()).progress.getLuckyWheelCurrentMultiplier() - 1) * 5;
/*      */       } 
/*      */     } 
/* 1900 */     return i;
/*      */   }
/*      */   
/*      */   public VideoAdViewBonus[] getVideoAdViewBonuses() {
/* 1904 */     if (this.videoAdViewBonuses == null) {
/* 1905 */       this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1911 */         .videoAdViewBonuses = new VideoAdViewBonus[] { new VideoAdViewBonus(30, new ItemStack((Item)Item.D.LOOT_BOOST, 1)), new VideoAdViewBonus(70, new ItemStack((Item)Item.D.F_CASE.create(CaseType.CYAN, false), 1)), new VideoAdViewBonus(110, new ItemStack((Item)Item.D.ACCELERATOR, 30)), new VideoAdViewBonus(150, new ItemStack((Item)Item.D.RESEARCH_TOKEN, 1)), new VideoAdViewBonus(200, new ItemStack((Item)Item.D.ACCELERATOR, 50)), new VideoAdViewBonus(250, new ItemStack((Item)Item.D.F_CASE.create(CaseType.CYAN, false), 2)), new VideoAdViewBonus(300, new ItemStack((Item)Item.D.ACCELERATOR, 300), true) };
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1916 */     return this.videoAdViewBonuses;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getLootBoostTimeLeft() {
/* 1921 */     return (ProgressPrefs.i()).progress.getLootBoostTimeLeft();
/*      */   }
/*      */   
/*      */   public int getMaxCraftQueueSize() {
/* 1925 */     return StrictMath.min(Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.CRAFTING_QUEUE_MAX_SIZE), 6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void startCrafting(CraftRecipe paramCraftRecipe, Array<Item> paramArray, int paramInt) {
/* 1935 */     if (paramCraftRecipe == null) throw new IllegalArgumentException("recipe is null"); 
/* 1936 */     if (paramCraftRecipe.ingredients.size != paramArray.size) throw new IllegalArgumentException("ingredients.size != recipe.ingredients.size (" + paramArray.size + ", " + paramCraftRecipe.ingredients.size + ")"); 
/* 1937 */     if (paramInt < 0 || paramInt > paramCraftRecipe.getMaxQueueStackWithGVs()) throw new IllegalArgumentException("count must be 1 <=> " + paramCraftRecipe.getMaxQueueStackWithGVs() + ", " + paramInt + " given");
/*      */     
/*      */     byte b;
/* 1940 */     for (b = 0; b < paramCraftRecipe.ingredients.size; b++) {
/* 1941 */       CraftRecipe.Ingredient ingredient = ((CraftRecipe.Ingredient[])paramCraftRecipe.ingredients.items)[b];
/* 1942 */       if (((Item[])paramArray.items)[b] == null) throw new IllegalArgumentException("ingredient " + b + " is null");
/*      */       
/* 1944 */       if (ingredient.fits(((Item[])paramArray.items)[b])) {
/*      */         
/* 1946 */         int i = ingredient.getCountWithGVs() * paramInt;
/*      */         int j;
/* 1948 */         if ((j = Game.i.progressManager.getItemsCount(((Item[])paramArray.items)[b])) < i) {
/* 1949 */           throw new IllegalStateException("not enough of " + String.valueOf(((Item[])paramArray.items)[b]) + " to craft " + paramInt + " items (" + j + "/" + i + ")");
/*      */         }
/*      */       } else {
/* 1952 */         throw new IllegalArgumentException("ingredient " + b + " doesn't fit recipe (" + String.valueOf(((Item[])paramArray.items)[b]) + ")");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1957 */     for (b = 0; b < paramCraftRecipe.ingredients.size; b++) {
/* 1958 */       CraftRecipe.Ingredient ingredient = ((CraftRecipe.Ingredient[])paramCraftRecipe.ingredients.items)[b];
/* 1959 */       removeItems(((Item[])paramArray.items)[b], ingredient.getCountWithGVs() * paramInt);
/*      */     } 
/*      */ 
/*      */     
/* 1963 */     addItems(paramCraftRecipe.result.getItem(), paramCraftRecipe.result.getCount() * paramInt, "crafted");
/*      */   }
/*      */   
/*      */   public void removeAllItems() {
/* 1967 */     (ProgressPrefs.i()).inventory.removeAllItems();
/*      */   }
/*      */   
/*      */   public int getAcceleratorsRequiredToShortenTime(float paramFloat) {
/* 1971 */     return MathUtils.ceil(paramFloat / 600.0F);
/*      */   }
/*      */   
/*      */   public static RarityType getRarityFromQuality(float paramFloat) {
/* 1975 */     if (paramFloat >= 1.0F) return RarityType.LEGENDARY; 
/* 1976 */     if (paramFloat < 0.0F) return RarityType.COMMON;
/*      */     
/* 1978 */     return RarityType.values[MathUtils.floor(paramFloat * RarityType.values.length)];
/*      */   }
/*      */   
/*      */   public static float getMinQuality(RarityType paramRarityType) {
/* 1982 */     return paramRarityType.ordinal() * 0.2F;
/*      */   }
/*      */   
/*      */   public static float getMaxQuality(RarityType paramRarityType) {
/* 1986 */     return paramRarityType.ordinal() * 0.2F + 0.2F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float globalQualityToRarityQualuty(float paramFloat) {
/* 1993 */     return MathUtils.clamp(paramFloat % 0.2F * 5.0F, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public Color[] getRarityColors() {
/* 1997 */     if (Game.i.settingsManager.cvdFriendlyColors()) {
/* 1998 */       return f;
/*      */     }
/* 2000 */     return d;
/*      */   }
/*      */ 
/*      */   
/*      */   public Color[] getRarityBrightColors() {
/* 2005 */     if (Game.i.settingsManager.cvdFriendlyColors()) {
/* 2006 */       return g;
/*      */     }
/* 2008 */     return e;
/*      */   }
/*      */ 
/*      */   
/*      */   public Color getRarityColor(RarityType paramRarityType) {
/* 2013 */     return getRarityColors()[paramRarityType.ordinal()];
/*      */   }
/*      */   
/*      */   public String getRarityIcon(RarityType paramRarityType) {
/* 2017 */     return i[paramRarityType.ordinal()];
/*      */   }
/*      */   
/*      */   public Color getRarityBrightColor(RarityType paramRarityType) {
/* 2021 */     return getRarityBrightColors()[paramRarityType.ordinal()];
/*      */   }
/*      */   
/*      */   public String getRarityName(RarityType paramRarityType) {
/* 2025 */     String str = h[paramRarityType.ordinal()];
/*      */     
/* 2027 */     return Game.i.localeManager.i18n.get(str);
/*      */   }
/*      */   
/*      */   public boolean difficultyModeAvailable(DifficultyMode paramDifficultyMode) {
/* 2031 */     if (DifficultyMode.isEndless(paramDifficultyMode) && !Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.ENDLESS_MODE)) {
/* 2032 */       return false;
/*      */     }
/*      */     
/* 2035 */     return true;
/*      */   }
/*      */   
/*      */   public DifficultyMode getDifficultyMode() {
/* 2039 */     return (ProgressPrefs.i()).progress.getDifficultyMode();
/*      */   }
/*      */   
/*      */   public void setDifficultyMode(DifficultyMode paramDifficultyMode) {
/* 2043 */     if ((ProgressPrefs.i()).progress.getDifficultyMode() != paramDifficultyMode) {
/* 2044 */       (ProgressPrefs.i()).progress.setDifficultyMode(paramDifficultyMode);
/* 2045 */       ProgressPrefs.i().requireSave();
/* 2046 */       Game.i.gameValueManager.requireRecalculation();
/*      */     } 
/*      */   }
/*      */   
/*      */   public Color getDifficultyModeColor(DifficultyMode paramDifficultyMode) {
/* 2051 */     switch (null.e[paramDifficultyMode.ordinal()]) { case 1:
/* 2052 */         return MaterialColor.LIGHT_GREEN.P500;
/* 2053 */       case 2: return MaterialColor.LIGHT_BLUE.P500;
/* 2054 */       case 3: return MaterialColor.AMBER.P500; }
/*      */ 
/*      */     
/* 2057 */     return Color.WHITE;
/*      */   }
/*      */   
/*      */   public String getDifficultyName(DifficultyMode paramDifficultyMode) {
/* 2061 */     String str = "difficulty_mode_" + paramDifficultyMode;
/* 2062 */     return Game.i.localeManager.i18n.get(str);
/*      */   }
/*      */   
/*      */   public static int clampModeDifficulty(DifficultyMode paramDifficultyMode, int paramInt, @Null BasicLevel paramBasicLevel, boolean paramBoolean1, boolean paramBoolean2, ProgressSnapshotForState paramProgressSnapshotForState) {
/* 2066 */     switch (null.e[paramDifficultyMode.ordinal()]) {
/*      */       case 1:
/* 2068 */         return 80;
/*      */       case 2:
/* 2070 */         return 100;
/*      */     } 
/* 2072 */     GameValueManager.GameValuesSnapshot gameValuesSnapshot = GameValueManager.createSnapshot(null, paramDifficultyMode, false, paramBasicLevel, paramBoolean1, paramBoolean2, paramProgressSnapshotForState);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2080 */     return clampModeDifficultyGVP(paramDifficultyMode, paramInt, gameValuesSnapshot);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int clampModeDifficultyGVP(DifficultyMode paramDifficultyMode, int paramInt, GameValueProvider paramGameValueProvider) {
/* 2085 */     switch (null.e[paramDifficultyMode.ordinal()]) {
/*      */       case 1:
/* 2087 */         return 80;
/*      */       case 2:
/* 2089 */         return 100;
/*      */     } 
/* 2091 */     return MathUtils.clamp(paramInt, 150, 
/*      */ 
/*      */         
/* 2094 */         MathUtils.round((float)paramGameValueProvider.getPercentValueAsMultiplier(GameValueType.ENDLESS_MODE_DIFFICULTY) * 100.0F));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDifficultyModeDiffMultiplier(DifficultyMode paramDifficultyMode) {
/* 2100 */     int i = 100;
/* 2101 */     switch (null.e[paramDifficultyMode.ordinal()]) { case 1:
/* 2102 */         i = 87; break;
/* 2103 */       case 3: i = MathUtils.round((float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.ENDLESS_MODE_DIFFICULTY) * 100.0F);
/*      */         break; }
/*      */     
/* 2106 */     return clampModeDifficultyGVP(paramDifficultyMode, i, Game.i.gameValueManager.getSnapshot());
/*      */   }
/*      */   
/*      */   public static float getDifficultyModePrizeMultiplier(DifficultyMode paramDifficultyMode) {
/* 2110 */     switch (null.e[paramDifficultyMode.ordinal()]) { case 2:
/* 2111 */         return 1.0F;
/* 2112 */       case 1: return 0.75F;
/* 2113 */       case 3: return 1.5F; }
/*      */ 
/*      */     
/* 2116 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean openPack(Item paramItem, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 2123 */     if (paramInt <= 0) throw new IllegalArgumentException("incorrect count " + paramInt);
/*      */     
/* 2125 */     if (!paramItem.canBeUnpacked()) {
/* 2126 */       throw new IllegalArgumentException("Item can't be unpacked: " + paramItem.getType());
/*      */     }
/*      */     
/* 2129 */     if (removeItems(paramItem, paramInt)) {
/*      */       IssuedItems issuedItems;
/* 2131 */       if (paramItem.getType() == ItemType.RANDOM_TILE) {
/*      */         
/* 2133 */         RandomTileItem randomTileItem = (RandomTileItem)paramItem;
/*      */         
/* 2135 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.RANDOM_TILE_PACK, Game.getTimestampSeconds())).randomTilePackQuality = randomTileItem.quality;
/* 2136 */       } else if (paramItem.getType() == ItemType.CASE) {
/*      */         
/* 2138 */         CaseItem caseItem = (CaseItem)paramItem;
/*      */         
/* 2140 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.CASE, Game.getTimestampSeconds())).caseType = caseItem.caseType;
/*      */       }
/* 2142 */       else if (paramItem.getType() == ItemType.RANDOM_TELEPORT) {
/*      */         
/* 2144 */         issuedItems = new IssuedItems(IssuedItems.IssueReason.RANDOM_TELEPORT_PACK, Game.getTimestampSeconds());
/* 2145 */       } else if (paramItem.getType() == ItemType.RANDOM_BARRIER) {
/*      */         
/* 2147 */         RandomBarrierItem randomBarrierItem = (RandomBarrierItem)paramItem;
/*      */         
/* 2149 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.RANDOM_BARRIER_PACK, Game.getTimestampSeconds())).randomBarrierPackQuality = randomBarrierItem.quality;
/*      */       } else {
/* 2151 */         throw new IllegalStateException("Not implemented for unpacking: " + paramItem.getType().name());
/*      */       } 
/*      */       
/* 2154 */       issuedItems.massUnpackCount = paramInt;
/*      */       
/* 2156 */       InventoryStatistics inventoryStatistics = Game.i.progressManager.getInventoryStatistics().cpy(); byte b;
/* 2157 */       for (b = 0; b < paramInt; b++) {
/* 2158 */         Array array = paramItem.openPack(inventoryStatistics);
/* 2159 */         issuedItems.items.addAll(array);
/* 2160 */         for (byte b1 = 0; b1 < array.size; b1++) {
/* 2161 */           ItemStack itemStack = ((ItemStack[])array.items)[b1];
/* 2162 */           inventoryStatistics.countItem(itemStack.getItem(), itemStack.getCount());
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2167 */       if ((b = (issuedItems.items.size > 50) ? 1 : 0) != 0) {
/* 2168 */         compressStacksArray(issuedItems.items);
/*      */       }
/* 2170 */       issuedItems.items.sort(ItemStack.SORT_COMPARATOR_RARITY_ASC);
/*      */       
/* 2172 */       Game.i.progressManager.addItemArray(issuedItems.items, "pack_open_" + paramItem.getAnalyticName());
/* 2173 */       Game.i.progressManager.addIssuedPrizes(issuedItems, paramBoolean2);
/*      */       
/* 2175 */       if (paramBoolean1) {
/* 2176 */         OpenedPackOverlay.i().show(issuedItems.items, b);
/*      */       }
/*      */       
/* 2179 */       return b;
/*      */     } 
/* 2181 */     Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_items"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/* 2182 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long calculateProgressHash() {
/* 2192 */     long l = (l = (31 + getAccelerators())) * 31L + getGreenPapers(); ResourceType[] arrayOfResourceType; int i; byte b;
/* 2193 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 2194 */       l = l * 31L + getResources(resourceType);
/*      */       b++; }
/*      */     
/* 2197 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean existsAnyProgress() {
/* 2205 */     if (getGreenPapers() != 0) return true;
/*      */ 
/*      */     
/* 2208 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.PT) != 0.0D) return true;
/*      */ 
/*      */     
/* 2211 */     if ((ProgressPrefs.i()).purchase.hasAnyTransaction()) return true;
/*      */     
/* 2213 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/* 2218 */     if (!Config.isHeadless()) {
/* 2219 */       Game.i.gameValueManager.addListener(this.k);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2224 */       Game.i.authManager.addListener(new AuthManager.AuthManagerListener.AuthManagerListenerAdapter(this)
/*      */           {
/*      */             public void signInStatusUpdated() {
/* 2227 */               if (Game.i.authManager.isProfileStatusActive("double_gain")) {
/* 2228 */                 this.a.enableDoubleGainPermanently();
/*      */               }
/*      */             }
/*      */           });
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addListener(ProgressManagerListener paramProgressManagerListener) {
/* 2236 */     if (paramProgressManagerListener == null) {
/* 2237 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/* 2240 */     if (!this.j.contains(paramProgressManagerListener, true)) {
/* 2241 */       this.j.add(paramProgressManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(ProgressManagerListener paramProgressManagerListener) {
/* 2246 */     if (paramProgressManagerListener == null) {
/* 2247 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/* 2250 */     this.j.removeValue(paramProgressManagerListener, true); } public boolean areModifiersOpened() {
/*      */     ModifierType[] arrayOfModifierType;
/*      */     int i;
/*      */     byte b;
/* 2254 */     for (i = (arrayOfModifierType = ModifierType.values).length, b = 0; b < i; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 2255 */       if (Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.modifierManager.getCountGameValue(modifierType)) > 0) {
/* 2256 */         return true;
/*      */       }
/*      */       b++; }
/*      */     
/* 2260 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomValue(String paramString1, @Null String paramString2) {
/* 2269 */     (ProgressPrefs.i()).custom.setValue(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public String getCustomValue(String paramString1, @Null String paramString2) {
/* 2279 */     return (ProgressPrefs.i()).custom.getValue(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getCustomKeys() {
/* 2286 */     return (ProgressPrefs.i()).custom.getKeys();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isResourceOpened(ResourceType paramResourceType) {
/* 2293 */     switch (null.b[paramResourceType.ordinal()]) { case 1:
/* 2294 */         return (Game.i.researchManager.getResearchInstance(ResearchType.MINER_TYPE_SCALAR).getInstalledLevel() > 0);
/* 2295 */       case 2: return (Game.i.researchManager.getResearchInstance(ResearchType.MINER_TYPE_VECTOR).getInstalledLevel() > 0);
/* 2296 */       case 3: return (Game.i.researchManager.getResearchInstance(ResearchType.MINER_TYPE_MATRIX).getInstalledLevel() > 0);
/* 2297 */       case 4: return (Game.i.researchManager.getResearchInstance(ResearchType.MINER_TYPE_TENSOR).getInstalledLevel() > 0);
/* 2298 */       case 5: return (Game.i.researchManager.getResearchInstance(ResearchType.MINER_TYPE_INFIAR).getInstalledLevel() > 0); }
/*      */     
/* 2300 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getExtraDecryptingSlotsCount() {
/*      */     int i;
/* 2306 */     if ((i = Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.DECRYPTING_QUEUE_MAX_SIZE)) < 0) return 0; 
/* 2307 */     if (i > 2) return 2;
/*      */     
/* 2309 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean areAbilitiesOpened() {
/* 2316 */     return (Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.ABILITY_FIREBALL_MAX_PER_GAME) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ItemStack addItemToStacksArray(Array<ItemStack> paramArray, Item paramItem, int paramInt) {
/* 2324 */     for (byte b = 0; b < paramArray.size; b++) {
/*      */       ItemStack itemStack1;
/* 2326 */       if ((itemStack1 = (ItemStack)paramArray.get(b)).getItem().sameAs(paramItem)) {
/* 2327 */         itemStack1.setCount(PMath.addWithoutOverflow(itemStack1.getCount(), paramInt));
/*      */         
/* 2329 */         return itemStack1;
/*      */       } 
/*      */     } 
/* 2332 */     ItemStack itemStack = new ItemStack(paramItem, paramInt);
/* 2333 */     paramArray.add(itemStack);
/*      */     
/* 2335 */     return itemStack;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ItemStack removeItemFromStacksArray(Array<ItemStack> paramArray, Item paramItem, int paramInt) {
/* 2342 */     Preconditions.checkArgument((paramInt > 0), "Count must be > 0, %s given", paramInt);
/*      */     
/*      */     ItemStack itemStack;
/* 2345 */     if ((itemStack = getItemStackFromArray(paramArray, paramItem)) != null && itemStack.getCount() >= paramInt) {
/* 2346 */       itemStack.setCount(itemStack.getCount() - paramInt);
/* 2347 */       return itemStack;
/*      */     } 
/* 2349 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ItemStack getItemStackFromArray(Array<ItemStack> paramArray, Item paramItem) {
/* 2354 */     for (byte b = 0; b < paramArray.size; b++) {
/*      */       ItemStack itemStack;
/* 2356 */       if ((itemStack = (ItemStack)paramArray.get(b)).getItem().sameAs(paramItem)) {
/* 2357 */         return itemStack;
/*      */       }
/*      */     } 
/* 2360 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void compressStacksArray(Array<ItemStack> paramArray) {
/* 2367 */     for (int i = paramArray.size - 1; i >= 0; i--) {
/* 2368 */       boolean bool = false;
/* 2369 */       for (byte b = 0; b < i; b++) {
/* 2370 */         ItemStack itemStack1 = (ItemStack)paramArray.get(i);
/* 2371 */         ItemStack itemStack2 = (ItemStack)paramArray.get(b);
/*      */         
/* 2373 */         if (itemStack1.getItem().sameAs(itemStack2.getItem())) {
/*      */           
/* 2375 */           itemStack2.setCount(PMath.addWithoutOverflow(itemStack1.getCount(), itemStack2.getCount()));
/* 2376 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 2381 */       if (bool)
/*      */       {
/* 2383 */         paramArray.removeIndex(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addItems(Item paramItem, int paramInt, @Null String paramString) {
/* 2394 */     int i = getItemsCount(paramItem);
/*      */     
/* 2396 */     (ProgressPrefs.i()).inventory.addItems(paramItem, paramInt);
/* 2397 */     ProgressPrefs.i().requireSave();
/*      */     
/* 2399 */     this.j.begin(); byte b;
/* 2400 */     for (b = 0; b < this.j.size; b++) {
/* 2401 */       ((ProgressManagerListener)this.j.get(b)).itemsChanged(paramItem, i, paramInt);
/*      */     }
/* 2403 */     this.j.end();
/*      */     
/* 2405 */     if (paramItem instanceof Item.UsableItem && (
/* 2406 */       (Item.UsableItem)paramItem).autoUseWhenAdded())
/*      */     {
/* 2408 */       for (b = 0; b < paramInt; b++) {
/* 2409 */         ((Item.UsableItem)paramItem).useItem();
/* 2410 */         String str = Game.i.localeManager.i18n.get("item_used_notification") + " " + paramItem.getTitle();
/* 2411 */         Notifications.i().add(str, null, null, null);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 2416 */     Game.i.authManager.notifyNeedCloudSave(true);
/*      */ 
/*      */     
/* 2419 */     if (paramString != null) {
/* 2420 */       Game.i.analyticsManager.logCurrencyReceived(paramItem.getAnalyticName(), paramString, paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addItemStack(ItemStack paramItemStack, @Null String paramString) {
/* 2427 */     addItems(paramItemStack.getItem(), paramItemStack.getCount(), paramString);
/*      */   }
/*      */   
/*      */   public void addItemArray(Array<ItemStack> paramArray, String paramString) {
/* 2431 */     for (byte b = 0; b < paramArray.size; b++) {
/* 2432 */       addItemStack((ItemStack)paramArray.get(b), paramString);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getItemsCount(Item paramItem) {
/* 2437 */     return (ProgressPrefs.i()).inventory.getItemsCount(paramItem);
/*      */   }
/*      */   
/*      */   private ItemStack a(Item paramItem) {
/* 2441 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(paramItem.getType());
/* 2442 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/* 2443 */       if (((ItemStack)delayedRemovalArray.get(b)).getItem().sameAs(paramItem)) {
/* 2444 */         return (ItemStack)delayedRemovalArray.get(b);
/*      */       }
/*      */     } 
/*      */     
/* 2448 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean removeItems(Item paramItem, int paramInt) {
/*      */     PP_Inventory.ItemRemoveResult itemRemoveResult;
/* 2454 */     if ((itemRemoveResult = (ProgressPrefs.i()).inventory.removeItems(paramItem, paramInt)).removedRequiredAmount) {
/*      */       
/* 2456 */       if (itemRemoveResult.remainingCount == 0)
/*      */       {
/* 2458 */         setStarred(paramItem, false);
/*      */       }
/*      */       
/* 2461 */       int i = itemRemoveResult.remainingCount + paramInt;
/* 2462 */       this.j.begin();
/* 2463 */       for (byte b = 0; b < this.j.size; b++) {
/* 2464 */         ((ProgressManagerListener)this.j.get(b)).itemsChanged(paramItem, i, -paramInt);
/*      */       }
/* 2466 */       this.j.end();
/*      */     } 
/*      */     
/* 2469 */     return itemRemoveResult.removedRequiredAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean sellItems(Item paramItem, int paramInt) {
/* 2477 */     if (paramItem == null) return false; 
/*      */     ItemStack itemStack;
/* 2479 */     if ((itemStack = a(paramItem)) == null || itemStack.getCount() < paramInt) return false; 
/* 2480 */     if (!paramItem.canBeSold()) return false; 
/* 2481 */     if (isStarred(paramItem)) return false;
/*      */     
/* 2483 */     synchronized (m) {
/* 2484 */       m.clear();
/* 2485 */       paramItem.addSellItems(m);
/* 2486 */       for (byte b = 0; b < m.size; b++) {
/*      */         ItemStack itemStack1;
/* 2488 */         (itemStack1 = ((ItemStack[])m.items)[b]).setCount(PMath.multiplyWithoutOverflow(itemStack1.getCount(), paramInt));
/*      */       } 
/* 2490 */       addItemArray(m, "sell");
/* 2491 */       m.clear();
/*      */     } 
/*      */     
/* 2494 */     removeItems(paramItem, paramInt);
/*      */     
/* 2496 */     return true;
/*      */   }
/*      */   
/*      */   public boolean hasAnyItem() {
/* 2500 */     return (ProgressPrefs.i()).inventory.hasAnyItem();
/*      */   }
/*      */   
/*      */   public boolean isStarred(Item paramItem) {
/* 2504 */     return (ProgressPrefs.i()).inventory.isStarred(paramItem);
/*      */   }
/*      */   
/*      */   public void setStarred(Item paramItem, boolean paramBoolean) {
/*      */     boolean bool;
/* 2509 */     if (bool = (ProgressPrefs.i()).inventory.setStarred(paramItem, paramBoolean)) {
/* 2510 */       ProgressPrefs.i().requireSave();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Item getItem(Item paramItem) {
/* 2518 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(paramItem.getType());
/* 2519 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/* 2520 */       if (((ItemStack[])((Array)delayedRemovalArray).items)[b].getItem().sameAs(paramItem)) {
/* 2521 */         return ((ItemStack[])((Array)delayedRemovalArray).items)[b].getItem();
/*      */       }
/*      */     } 
/*      */     
/* 2525 */     return null;
/*      */   }
/*      */   
/*      */   public DelayedRemovalArray<ItemStack> getItemsByType(ItemType paramItemType) {
/* 2529 */     return (ProgressPrefs.i()).inventory.getItemsByType(paramItemType);
/*      */   }
/*      */   
/*      */   public DelayedRemovalArray<ItemStack> getItemsByCategory(ItemCategoryType paramItemCategoryType) {
/* 2533 */     return (ProgressPrefs.i()).inventory.getItemsByCategory(paramItemCategoryType);
/*      */   }
/*      */   
/*      */   public DelayedRemovalArray<ItemStack> getItemsBySubcategory(ItemSubcategoryType paramItemSubcategoryType) {
/* 2537 */     return (ProgressPrefs.i()).inventory.getItemsBySubcategory(paramItemSubcategoryType);
/*      */   }
/*      */ 
/*      */   
/*      */   public void addResources(ResourceType paramResourceType, int paramInt, String paramString) {
/* 2542 */     addItems((Item)Item.D.F_RESOURCE.create(paramResourceType), paramInt, paramString);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public void setResources(ResourceType paramResourceType, int paramInt) {
/* 2547 */     int i = getResources(paramResourceType);
/* 2548 */     if (paramInt < i) {
/* 2549 */       removeResources(paramResourceType, i - paramInt); return;
/* 2550 */     }  if (paramInt > i) {
/* 2551 */       addResources(paramResourceType, paramInt - i, null);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean removeResources(ResourceType paramResourceType, int paramInt) {
/* 2556 */     if (paramInt == 0) return true;
/*      */     
/* 2558 */     if (!removeItems((Item)Item.D.F_RESOURCE.create(paramResourceType), paramInt)) {
/* 2559 */       return false;
/*      */     }
/*      */     
/* 2562 */     Game.i.statisticsManager.registerDelta(StatisticsType.RS, paramInt);
/* 2563 */     switch (null.b[paramResourceType.ordinal()]) { case 1:
/* 2564 */         Game.i.statisticsManager.registerDelta(StatisticsType.RS_S, paramInt); break;
/* 2565 */       case 2: Game.i.statisticsManager.registerDelta(StatisticsType.RS_V, paramInt); break;
/* 2566 */       case 3: Game.i.statisticsManager.registerDelta(StatisticsType.RS_M, paramInt); break;
/* 2567 */       case 4: Game.i.statisticsManager.registerDelta(StatisticsType.RS_T, paramInt); break;
/* 2568 */       case 5: Game.i.statisticsManager.registerDelta(StatisticsType.RS_I, paramInt);
/*      */         break; }
/*      */     
/* 2571 */     return true;
/*      */   }
/*      */   
/*      */   public int getResources(ResourceType paramResourceType) {
/* 2575 */     return getItemsCount((Item)Item.D.F_RESOURCE.create(paramResourceType));
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addTiles(Tile paramTile, int paramInt) {
/* 2581 */     addItems((Item)Item.D.F_TILE.create(paramTile), paramInt, null);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addGates(Gate paramGate, int paramInt) {
/* 2587 */     addItems((Item)Item.D.F_GATE.create(paramGate), paramInt, null);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addAbilities(AbilityType paramAbilityType, int paramInt) {
/* 2593 */     addItems((Item)Item.D.F_ABILITY.create(paramAbilityType), paramInt, null);
/*      */   }
/*      */   
/*      */   public void setAbilities(AbilityType paramAbilityType, int paramInt) {
/* 2597 */     int i = getAbilities(paramAbilityType);
/* 2598 */     if (paramInt < i) {
/* 2599 */       removeAbilities(paramAbilityType, i - paramInt); return;
/* 2600 */     }  if (paramInt > i) {
/* 2601 */       addAbilities(paramAbilityType, paramInt - i);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean removeAbilities(AbilityType paramAbilityType, int paramInt) {
/* 2606 */     if (paramInt == 0) return true;
/*      */ 
/*      */     
/* 2609 */     if ((paramInt = Math.min(paramInt, getItemsCount((Item)Item.D.F_ABILITY.create(paramAbilityType)))) == 0) return false;
/*      */     
/* 2611 */     return removeItems((Item)Item.D.F_ABILITY.create(paramAbilityType), paramInt);
/*      */   }
/*      */   
/*      */   public int getAbilities(AbilityType paramAbilityType) {
/* 2615 */     return getItemsCount((Item)Item.D.F_ABILITY.create(paramAbilityType));
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setMoney(int paramInt) {
/* 2621 */     int i = getGreenPapers();
/* 2622 */     if (paramInt < i) {
/* 2623 */       removeGreenPapers(i - paramInt); return;
/* 2624 */     }  if (paramInt > i) {
/* 2625 */       addGreenPapers(paramInt - i, null);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getGreenPapers() {
/* 2630 */     return getItemsCount((Item)Item.D.GREEN_PAPER);
/*      */   }
/*      */   
/*      */   public void addGreenPapers(int paramInt, String paramString) {
/* 2634 */     addItems((Item)Item.D.GREEN_PAPER, paramInt, paramString);
/*      */   }
/*      */   
/*      */   public boolean removeGreenPapers(int paramInt) {
/* 2638 */     if (paramInt == 0) return true;
/*      */     
/*      */     boolean bool;
/* 2641 */     if (bool = removeItems((Item)Item.D.GREEN_PAPER, paramInt)) {
/* 2642 */       Game.i.statisticsManager.registerDelta(StatisticsType.GPS, paramInt);
/*      */     }
/*      */     
/* 2645 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setAccelerators(int paramInt) {
/* 2651 */     int i = getGreenPapers();
/* 2652 */     if (paramInt < i) {
/* 2653 */       removeAccelerators(i - paramInt); return;
/* 2654 */     }  if (paramInt > i) {
/* 2655 */       addAccelerators(paramInt - i, null);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getAccelerators() {
/* 2660 */     return getItemsCount((Item)Item.D.ACCELERATOR);
/*      */   }
/*      */   
/*      */   public void addAccelerators(int paramInt, String paramString) {
/* 2664 */     addItems((Item)Item.D.ACCELERATOR, paramInt, paramString);
/*      */   }
/*      */   
/*      */   public boolean removeAccelerators(int paramInt) {
/* 2668 */     if (paramInt == 0) return true;
/*      */     
/* 2670 */     return removeItems((Item)Item.D.ACCELERATOR, paramInt);
/*      */   }
/*      */   
/*      */   public void addIssuedPrizes(IssuedItems paramIssuedItems, boolean paramBoolean) {
/* 2674 */     if (!paramBoolean) {
/* 2675 */       paramIssuedItems.shown = true;
/*      */     }
/*      */     
/* 2678 */     paramIssuedItems.items.sort(ITEM_RARITY_COMPARATOR);
/*      */     Array<IssuedItems> array;
/* 2680 */     (array = getIssuedItems()).insert(0, paramIssuedItems);
/*      */ 
/*      */     
/* 2683 */     if (array.size > 50) {
/* 2684 */       array.setSize(50);
/*      */     }
/* 2686 */     this.c = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Array<IssuedItems> getIssuedPrizes() {
/* 2693 */     return getIssuedItems();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void showNewlyIssuedPrizesPopup() {
/* 2700 */     byte b1 = 0;
/*      */     
/* 2702 */     Array<IssuedItems> array = getIssuedItems();
/* 2703 */     for (byte b2 = 0; b2 < array.size; b2++) {
/* 2704 */       if (!((IssuedItems)array.get(b2)).shown) {
/* 2705 */         b1 = 1;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 2710 */     if (b1) {
/* 2711 */       Array array1 = new Array();
/* 2712 */       for (b1 = 0; b1 < array.size; b1++) {
/* 2713 */         if (!((IssuedItems)array.get(b1)).shown) {
/* 2714 */           ((IssuedItems)array.get(b1)).shown = true;
/* 2715 */           array1.add(array.get(b1));
/*      */         } 
/*      */       } 
/*      */       
/* 2719 */       IssuedPrizesOverlay.i().show(array1);
/* 2720 */       this.c = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void postRender(float paramFloat) {
/* 2726 */     if (this.c) {
/* 2727 */       this.c = false;
/*      */ 
/*      */       
/* 2730 */       Array<IssuedItems> array = getIssuedItems();
/* 2731 */       array = new Array(array);
/* 2732 */       Threads.i().runAsync(() -> {
/*      */             Json json = new Json(JsonWriter.OutputType.minimal);
/*      */             StringWriter stringWriter = new StringWriter();
/*      */             json.setWriter(stringWriter);
/*      */             json.writeArrayStart();
/*      */             for (byte b = 0; b < paramArray.size; b++) {
/*      */               json.writeObjectStart();
/*      */               ((IssuedItems)paramArray.get(b)).toJson(json);
/*      */               json.writeObjectEnd();
/*      */             } 
/*      */             json.writeArrayEnd();
/*      */             synchronized (this) {
/*      */               Gdx.files.local(PreferencesManager.getIssuedItemsFilePath()).writeString(stringWriter.toString(), false);
/*      */               return;
/*      */             } 
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int countAcceleratorsNeeded(int paramInt) {
/* 2755 */     return (int)StrictMath.ceil(StrictMath.pow((paramInt / 60.0F / 5.0F), 0.75D));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void givePendingBonuses() {
/* 2763 */     if (!(ProgressPrefs.i()).progress.isBonusGivenForRegByInvite() && 
/* 2764 */       Game.i.authManager.getInvitedById() != null)
/*      */     {
/* 2766 */       if (Game.i.basicLevelManager.isOpened(Game.i.basicLevelManager.getLevel("2.1"))) {
/*      */         
/* 2768 */         addItems((Item)Item.D.F_CASE
/* 2769 */             .create(CaseType.PURPLE, true), 1, "been_invited");
/*      */ 
/*      */         
/*      */         IssuedItems issuedItems;
/*      */ 
/*      */         
/* 2775 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.SIGNED_UP_BY_INVITE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.F_CASE
/* 2776 */               .create(CaseType.PURPLE, true), 1));
/*      */ 
/*      */         
/* 2779 */         addIssuedPrizes(issuedItems, true);
/*      */         
/* 2781 */         (ProgressPrefs.i()).progress.setBonusGivenForRegByInvite(true);
/* 2782 */         ProgressPrefs.i().requireSave();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public ProgressSnapshotForState createProgressSnapshotForState() {
/* 2789 */     ProgressSnapshotForState progressSnapshotForState = new ProgressSnapshotForState();
/*      */     
/* 2791 */     PP_Research pP_Research = (ProgressPrefs.i()).research; ResearchType[] arrayOfResearchType; int i; byte b;
/* 2792 */     for (i = (arrayOfResearchType = ResearchType.values).length, b = 0; b < i; ) { ResearchType researchType = arrayOfResearchType[b];
/*      */       int j;
/* 2794 */       if ((j = pP_Research.getInstalledLevel(researchType)) > 0) {
/* 2795 */         ProgressSnapshotForState.a(progressSnapshotForState).put(researchType.ordinal(), j);
/*      */       }
/*      */       b++; }
/*      */     
/* 2799 */     Array<TrophyType> array = Game.i.trophyManager.getReceivedTrophies();
/* 2800 */     for (i = 0; i < array.size; i++) {
/* 2801 */       ProgressSnapshotForState.b(progressSnapshotForState).add(((TrophyType)array.get(i)).ordinal());
/*      */     }
/*      */     
/* 2804 */     for (i = 0; i < Game.i.basicLevelManager.levelsOrdered.size; i++) {
/* 2805 */       BasicLevel basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[i];
/*      */       
/*      */       byte b1;
/* 2808 */       for (b1 = 0; b1 < basicLevel.quests.size; b1++) {
/*      */         BasicLevelQuestConfig basicLevelQuestConfig;
/* 2810 */         if ((basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel.quests.items)[b1]).wasEverCompleted()) {
/* 2811 */           for (byte b2 = 0; b2 < basicLevelQuestConfig.prizes.size; b2++) {
/*      */             ItemStack itemStack;
/* 2813 */             if ((itemStack = ((ItemStack[])basicLevelQuestConfig.prizes.items)[b2]).getItem().getType() == ItemType.GAME_VALUE_GLOBAL || itemStack.getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/* 2814 */               ProgressSnapshotForState.c(progressSnapshotForState).add(basicLevelQuestConfig.id);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/* 2822 */       for (b1 = 0; b1 < basicLevel.waveQuests.size; b1++) {
/*      */         BasicLevel.WaveQuest waveQuest;
/* 2824 */         if ((waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b1)).isCompleted()) {
/* 2825 */           for (byte b2 = 0; b2 < waveQuest.prizes.size; b2++) {
/*      */             ItemStack itemStack;
/* 2827 */             if ((itemStack = ((ItemStack[])waveQuest.prizes.items)[b2]).getItem().getType() == ItemType.GAME_VALUE_GLOBAL || itemStack.getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/* 2828 */               ProgressSnapshotForState.c(progressSnapshotForState).add(waveQuest.id);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 2836 */     progressSnapshotForState.statsPlayTimeCasesLoot = MathUtils.round((float)Game.i.statisticsManager.getAllTime(StatisticsType.PTCL));
/* 2837 */     progressSnapshotForState.statsPlayRealTime = MathUtils.round((float)Game.i.statisticsManager.getAllTime(StatisticsType.PRT));
/* 2838 */     progressSnapshotForState.statsQueuedCasesGiven = MathUtils.round((float)Game.i.statisticsManager.getAllTime(StatisticsType.EQCG));
/*      */     
/* 2840 */     return progressSnapshotForState;
/*      */   }
/*      */   
/*      */   public void disableDoubleGainTemp() {
/* 2844 */     (ProgressPrefs.i()).progress.setDoubleGainEnabled(false);
/* 2845 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */   
/*      */   public void enableDoubleGainPermanently() {
/* 2849 */     if (!(ProgressPrefs.i()).progress.isDoubleGainEnabled()) {
/* 2850 */       (ProgressPrefs.i()).progress.setDoubleGainEnabled(true);
/* 2851 */       ProgressPrefs.i().requireSave();
/*      */       
/* 2853 */       this.j.begin(); byte b; int i;
/* 2854 */       for (b = 0, i = this.j.size; b < i; b++) {
/* 2855 */         ((ProgressManagerListener)this.j.get(b)).doubleGainEnabled();
/*      */       }
/* 2857 */       this.j.end();
/*      */       
/* 2859 */       Notifications.i().add(Game.i.localeManager.i18n.get("double_gain_enabled_permanently"), (Drawable)Game.i.assetManager.getDrawable("money-pack-double-gain"), MaterialColor.GREEN.P800, StaticSoundType.SUCCESS);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void giveDoubleGainIfNecessary() {
/* 2864 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop && Game.i.actionResolver.doubleGainEnabledBySteamGamePurchase() && 
/* 2865 */       !(ProgressPrefs.i()).progress.isSteamRewardReceived()) {
/* 2866 */       a.i("eligible for free DG, reward not received", new Object[0]);
/* 2867 */       if (hasPermanentDoubleGain()) {
/*      */         IssuedItems issuedItems;
/*      */ 
/*      */         
/* 2871 */         (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, 30000));
/* 2872 */         issuedItems.items.add(new ItemStack((Item)Item.D.ACCELERATOR, 300));
/* 2873 */         issuedItems.items.add(new ItemStack((Item)Item.D.RARITY_BOOST, 10));
/* 2874 */         issuedItems.items.add(new ItemStack((Item)Item.D.LUCKY_SHOT_TOKEN, 10));
/*      */         
/* 2876 */         addIssuedPrizes(issuedItems, true);
/* 2877 */         addItemArray(issuedItems.items, "steam_game_purchase_reward");
/* 2878 */         showNewlyIssuedPrizesPopup();
/*      */         
/* 2880 */         Notifications.i().add("Double Gain was already enabled, please take these items instead. Thank you for playing Infinitode 2 on Steam!", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.LIGHT_GREEN.P800, StaticSoundType.SUCCESS);
/*      */       } else {
/*      */         
/* 2883 */         enableDoubleGainPermanently();
/* 2884 */         Notifications.i().add("Double Gain enabled, thank you for playing Infinitode 2 on Steam!", (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.LIGHT_GREEN.P800, StaticSoundType.SUCCESS);
/*      */       } 
/* 2886 */       (ProgressPrefs.i()).progress.setSteamRewardReceived(true);
/* 2887 */       ProgressPrefs.i().requireSave();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTempDoubleGainDurationLeft() {
/*      */     int i;
/* 2894 */     if ((i = (ProgressPrefs.i()).progress.getTempDoubleGainEndDate() - Game.getTimestampSeconds()) < 0) i = 0;
/*      */     
/* 2896 */     return i;
/*      */   }
/*      */   
/*      */   public boolean enableDoubleGainTemporary(int paramInt) {
/*      */     PP_Progress pP_Progress;
/* 2901 */     if (!(pP_Progress = (ProgressPrefs.i()).progress).isDoubleGainEnabled()) {
/* 2902 */       if (hasTemporaryDoubleGain()) {
/*      */         
/* 2904 */         pP_Progress.setTempDoubleGainEndDate(pP_Progress.getTempDoubleGainEndDate() + paramInt);
/*      */       } else {
/*      */         
/* 2907 */         pP_Progress.setTempDoubleGainStartDate(Game.getTimestampSeconds());
/* 2908 */         pP_Progress.setTempDoubleGainEndDate(Game.getTimestampSeconds() + paramInt);
/*      */       } 
/* 2910 */       ProgressPrefs.i().requireSave();
/*      */       
/* 2912 */       this.j.begin(); byte b; int i;
/* 2913 */       for (b = 0, i = this.j.size; b < i; b++) {
/* 2914 */         ((ProgressManagerListener)this.j.get(b)).doubleGainEnabled();
/*      */       }
/* 2916 */       this.j.end();
/*      */       
/* 2918 */       String str = Game.i.localeManager.i18n.format("double_gain_enabled_timed", new Object[] { StringFormatter.timePassed(paramInt, false, true) });
/* 2919 */       Notifications.i().add(str, (Drawable)Game.i.assetManager.getDrawable("money-pack-double-gain"), MaterialColor.GREEN.P800, StaticSoundType.SUCCESS);
/*      */       
/* 2921 */       return true;
/*      */     } 
/*      */     
/* 2924 */     Notifications.i().add(Game.i.localeManager.i18n.get("double_gain_enabled_permanently"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */     
/* 2926 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPermanentDoubleGain() {
/* 2934 */     return (ProgressPrefs.i()).progress.isDoubleGainEnabled();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasTemporaryDoubleGain() {
/*      */     int i;
/* 2942 */     if ((i = Game.getTimestampSeconds()) >= (ProgressPrefs.i()).progress.getTempDoubleGainStartDate() && i <= (ProgressPrefs.i()).progress.getTempDoubleGainEndDate()) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleGainEnabled() {
/* 2949 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DOUBLE_GAIN_DISABLED_MANUALLY) != 0.0D) return false;
/*      */     
/* 2951 */     return (hasPermanentDoubleGain() || hasTemporaryDoubleGain());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPremiumStatusActive() {
/* 2958 */     if (Config.isHeadless()) return false;
/*      */     
/* 2960 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PREMIUM_STATUS_DISABLED_MANUALLY) != 0.0D) {
/* 2961 */       return false;
/*      */     }
/*      */     
/* 2964 */     return Game.i.authManager.isProfileStatusActive("premium");
/*      */   }
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
/*      */ 
/*      */   
/*      */   public IssuedItems getRegularRewardingAdItems(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   3: getfield statisticsManager : Lcom/prineside/tdi2/managers/StatisticsManager;
/*      */     //   6: getstatic com/prineside/tdi2/enums/StatisticsType.PT : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   9: invokevirtual getAllTime : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*      */     //   12: d2f
/*      */     //   13: fstore_2
/*      */     //   14: dconst_1
/*      */     //   15: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   18: getfield statisticsManager : Lcom/prineside/tdi2/managers/StatisticsManager;
/*      */     //   21: getstatic com/prineside/tdi2/enums/StatisticsType.RVW : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   24: invokevirtual getAllTime : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*      */     //   27: ldc2_w 1000.0
/*      */     //   30: ddiv
/*      */     //   31: dadd
/*      */     //   32: dup2
/*      */     //   33: dstore_3
/*      */     //   34: ldc2_w 2.0
/*      */     //   37: dcmpl
/*      */     //   38: ifle -> 45
/*      */     //   41: ldc2_w 2.0
/*      */     //   44: dstore_3
/*      */     //   45: dload_3
/*      */     //   46: fload_2
/*      */     //   47: f2d
/*      */     //   48: ddiv
/*      */     //   49: ldc2_w 720.0
/*      */     //   52: dmul
/*      */     //   53: dstore_3
/*      */     //   54: new com/prineside/tdi2/IssuedItems
/*      */     //   57: dup
/*      */     //   58: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   61: getfield progressManager : Lcom/prineside/tdi2/managers/ProgressManager;
/*      */     //   64: invokevirtual isPremiumStatusActive : ()Z
/*      */     //   67: ifeq -> 76
/*      */     //   70: getstatic com/prineside/tdi2/IssuedItems$IssueReason.PREMIUM_REWARD_VIDEO : Lcom/prineside/tdi2/IssuedItems$IssueReason;
/*      */     //   73: goto -> 79
/*      */     //   76: getstatic com/prineside/tdi2/IssuedItems$IssueReason.REWARD_VIDEO : Lcom/prineside/tdi2/IssuedItems$IssueReason;
/*      */     //   79: invokestatic getTimestampSeconds : ()I
/*      */     //   82: invokespecial <init> : (Lcom/prineside/tdi2/IssuedItems$IssueReason;I)V
/*      */     //   85: astore #5
/*      */     //   87: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   90: getfield statisticsManager : Lcom/prineside/tdi2/managers/StatisticsManager;
/*      */     //   93: getstatic com/prineside/tdi2/enums/StatisticsType.GPG : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   96: invokevirtual getAllTime : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*      */     //   99: d2f
/*      */     //   100: dup
/*      */     //   101: fstore #6
/*      */     //   103: f2d
/*      */     //   104: dload_3
/*      */     //   105: dmul
/*      */     //   106: d2i
/*      */     //   107: dup
/*      */     //   108: istore #6
/*      */     //   110: sipush #500
/*      */     //   113: if_icmpge -> 121
/*      */     //   116: sipush #500
/*      */     //   119: istore #6
/*      */     //   121: aload #5
/*      */     //   123: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   126: new com/prineside/tdi2/ItemStack
/*      */     //   129: dup
/*      */     //   130: getstatic com/prineside/tdi2/Item$D.GREEN_PAPER : Lcom/prineside/tdi2/items/GreenPaperItem;
/*      */     //   133: iload #6
/*      */     //   135: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   138: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   141: aload_0
/*      */     //   142: getfield l : [Lcom/prineside/tdi2/ItemStack;
/*      */     //   145: ifnonnull -> 2043
/*      */     //   148: aload_0
/*      */     //   149: bipush #124
/*      */     //   151: anewarray com/prineside/tdi2/ItemStack
/*      */     //   154: dup
/*      */     //   155: iconst_0
/*      */     //   156: new com/prineside/tdi2/ItemStack
/*      */     //   159: dup
/*      */     //   160: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   163: iconst_1
/*      */     //   164: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   167: aastore
/*      */     //   168: dup
/*      */     //   169: iconst_1
/*      */     //   170: new com/prineside/tdi2/ItemStack
/*      */     //   173: dup
/*      */     //   174: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   177: iconst_2
/*      */     //   178: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   181: aastore
/*      */     //   182: dup
/*      */     //   183: iconst_2
/*      */     //   184: new com/prineside/tdi2/ItemStack
/*      */     //   187: dup
/*      */     //   188: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_SPECIAL_I : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   191: iconst_1
/*      */     //   192: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   195: aastore
/*      */     //   196: dup
/*      */     //   197: iconst_3
/*      */     //   198: new com/prineside/tdi2/ItemStack
/*      */     //   201: dup
/*      */     //   202: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   205: iconst_2
/*      */     //   206: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   209: aastore
/*      */     //   210: dup
/*      */     //   211: iconst_4
/*      */     //   212: new com/prineside/tdi2/ItemStack
/*      */     //   215: dup
/*      */     //   216: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   219: iconst_1
/*      */     //   220: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   223: aastore
/*      */     //   224: dup
/*      */     //   225: iconst_5
/*      */     //   226: new com/prineside/tdi2/ItemStack
/*      */     //   229: dup
/*      */     //   230: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   233: iconst_5
/*      */     //   234: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   237: aastore
/*      */     //   238: dup
/*      */     //   239: bipush #6
/*      */     //   241: new com/prineside/tdi2/ItemStack
/*      */     //   244: dup
/*      */     //   245: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   248: iconst_2
/*      */     //   249: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   252: aastore
/*      */     //   253: dup
/*      */     //   254: bipush #7
/*      */     //   256: new com/prineside/tdi2/ItemStack
/*      */     //   259: dup
/*      */     //   260: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   263: iconst_1
/*      */     //   264: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   267: aastore
/*      */     //   268: dup
/*      */     //   269: bipush #8
/*      */     //   271: new com/prineside/tdi2/ItemStack
/*      */     //   274: dup
/*      */     //   275: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   278: iconst_1
/*      */     //   279: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   282: aastore
/*      */     //   283: dup
/*      */     //   284: bipush #9
/*      */     //   286: new com/prineside/tdi2/ItemStack
/*      */     //   289: dup
/*      */     //   290: getstatic com/prineside/tdi2/Item$D.LUCKY_SHOT_TOKEN : Lcom/prineside/tdi2/items/LuckyShotTokenItem;
/*      */     //   293: iconst_1
/*      */     //   294: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   297: aastore
/*      */     //   298: dup
/*      */     //   299: bipush #10
/*      */     //   301: new com/prineside/tdi2/ItemStack
/*      */     //   304: dup
/*      */     //   305: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   308: iconst_5
/*      */     //   309: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   312: aastore
/*      */     //   313: dup
/*      */     //   314: bipush #11
/*      */     //   316: new com/prineside/tdi2/ItemStack
/*      */     //   319: dup
/*      */     //   320: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   323: iconst_2
/*      */     //   324: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   327: aastore
/*      */     //   328: dup
/*      */     //   329: bipush #12
/*      */     //   331: new com/prineside/tdi2/ItemStack
/*      */     //   334: dup
/*      */     //   335: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   338: iconst_1
/*      */     //   339: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   342: aastore
/*      */     //   343: dup
/*      */     //   344: bipush #13
/*      */     //   346: new com/prineside/tdi2/ItemStack
/*      */     //   349: dup
/*      */     //   350: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   353: fconst_1
/*      */     //   354: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   357: iconst_1
/*      */     //   358: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   361: aastore
/*      */     //   362: dup
/*      */     //   363: bipush #14
/*      */     //   365: new com/prineside/tdi2/ItemStack
/*      */     //   368: dup
/*      */     //   369: getstatic com/prineside/tdi2/Item$D.ABILITY_TOKEN : Lcom/prineside/tdi2/items/AbilityTokenItem;
/*      */     //   372: iconst_1
/*      */     //   373: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   376: aastore
/*      */     //   377: dup
/*      */     //   378: bipush #15
/*      */     //   380: new com/prineside/tdi2/ItemStack
/*      */     //   383: dup
/*      */     //   384: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   387: iconst_5
/*      */     //   388: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   391: aastore
/*      */     //   392: dup
/*      */     //   393: bipush #16
/*      */     //   395: new com/prineside/tdi2/ItemStack
/*      */     //   398: dup
/*      */     //   399: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   402: iconst_1
/*      */     //   403: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   406: aastore
/*      */     //   407: dup
/*      */     //   408: bipush #17
/*      */     //   410: new com/prineside/tdi2/ItemStack
/*      */     //   413: dup
/*      */     //   414: getstatic com/prineside/tdi2/Item$D.RANDOM_TELEPORT : Lcom/prineside/tdi2/items/RandomTeleportItem;
/*      */     //   417: iconst_1
/*      */     //   418: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   421: aastore
/*      */     //   422: dup
/*      */     //   423: bipush #18
/*      */     //   425: new com/prineside/tdi2/ItemStack
/*      */     //   428: dup
/*      */     //   429: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   432: iconst_2
/*      */     //   433: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   436: aastore
/*      */     //   437: dup
/*      */     //   438: bipush #19
/*      */     //   440: new com/prineside/tdi2/ItemStack
/*      */     //   443: dup
/*      */     //   444: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   447: iconst_1
/*      */     //   448: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   451: aastore
/*      */     //   452: dup
/*      */     //   453: bipush #20
/*      */     //   455: new com/prineside/tdi2/ItemStack
/*      */     //   458: dup
/*      */     //   459: getstatic com/prineside/tdi2/Item$D.CASE_KEY_ORANGE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   462: iconst_1
/*      */     //   463: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   466: aastore
/*      */     //   467: dup
/*      */     //   468: bipush #21
/*      */     //   470: new com/prineside/tdi2/ItemStack
/*      */     //   473: dup
/*      */     //   474: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   477: iconst_2
/*      */     //   478: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   481: aastore
/*      */     //   482: dup
/*      */     //   483: bipush #22
/*      */     //   485: new com/prineside/tdi2/ItemStack
/*      */     //   488: dup
/*      */     //   489: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   492: fconst_1
/*      */     //   493: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   496: iconst_1
/*      */     //   497: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   500: aastore
/*      */     //   501: dup
/*      */     //   502: bipush #23
/*      */     //   504: new com/prineside/tdi2/ItemStack
/*      */     //   507: dup
/*      */     //   508: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   511: iconst_2
/*      */     //   512: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   515: aastore
/*      */     //   516: dup
/*      */     //   517: bipush #24
/*      */     //   519: new com/prineside/tdi2/ItemStack
/*      */     //   522: dup
/*      */     //   523: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   526: iconst_1
/*      */     //   527: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   530: aastore
/*      */     //   531: dup
/*      */     //   532: bipush #25
/*      */     //   534: new com/prineside/tdi2/ItemStack
/*      */     //   537: dup
/*      */     //   538: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   541: iconst_2
/*      */     //   542: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   545: aastore
/*      */     //   546: dup
/*      */     //   547: bipush #26
/*      */     //   549: new com/prineside/tdi2/ItemStack
/*      */     //   552: dup
/*      */     //   553: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   556: iconst_5
/*      */     //   557: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   560: aastore
/*      */     //   561: dup
/*      */     //   562: bipush #27
/*      */     //   564: new com/prineside/tdi2/ItemStack
/*      */     //   567: dup
/*      */     //   568: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   571: iconst_3
/*      */     //   572: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   575: aastore
/*      */     //   576: dup
/*      */     //   577: bipush #28
/*      */     //   579: new com/prineside/tdi2/ItemStack
/*      */     //   582: dup
/*      */     //   583: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   586: iconst_1
/*      */     //   587: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   590: aastore
/*      */     //   591: dup
/*      */     //   592: bipush #29
/*      */     //   594: new com/prineside/tdi2/ItemStack
/*      */     //   597: dup
/*      */     //   598: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   601: iconst_3
/*      */     //   602: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   605: aastore
/*      */     //   606: dup
/*      */     //   607: bipush #30
/*      */     //   609: new com/prineside/tdi2/ItemStack
/*      */     //   612: dup
/*      */     //   613: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   616: iconst_5
/*      */     //   617: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   620: aastore
/*      */     //   621: dup
/*      */     //   622: bipush #31
/*      */     //   624: new com/prineside/tdi2/ItemStack
/*      */     //   627: dup
/*      */     //   628: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   631: iconst_2
/*      */     //   632: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   635: aastore
/*      */     //   636: dup
/*      */     //   637: bipush #32
/*      */     //   639: new com/prineside/tdi2/ItemStack
/*      */     //   642: dup
/*      */     //   643: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   646: iconst_1
/*      */     //   647: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   650: aastore
/*      */     //   651: dup
/*      */     //   652: bipush #33
/*      */     //   654: new com/prineside/tdi2/ItemStack
/*      */     //   657: dup
/*      */     //   658: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   661: iconst_5
/*      */     //   662: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   665: aastore
/*      */     //   666: dup
/*      */     //   667: bipush #34
/*      */     //   669: new com/prineside/tdi2/ItemStack
/*      */     //   672: dup
/*      */     //   673: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   676: iconst_1
/*      */     //   677: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   680: aastore
/*      */     //   681: dup
/*      */     //   682: bipush #35
/*      */     //   684: new com/prineside/tdi2/ItemStack
/*      */     //   687: dup
/*      */     //   688: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   691: iconst_5
/*      */     //   692: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   695: aastore
/*      */     //   696: dup
/*      */     //   697: bipush #36
/*      */     //   699: new com/prineside/tdi2/ItemStack
/*      */     //   702: dup
/*      */     //   703: getstatic com/prineside/tdi2/Item$D.CASE_KEY_CYAN : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   706: iconst_1
/*      */     //   707: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   710: aastore
/*      */     //   711: dup
/*      */     //   712: bipush #37
/*      */     //   714: new com/prineside/tdi2/ItemStack
/*      */     //   717: dup
/*      */     //   718: getstatic com/prineside/tdi2/Item$D.RANDOM_TELEPORT : Lcom/prineside/tdi2/items/RandomTeleportItem;
/*      */     //   721: iconst_1
/*      */     //   722: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   725: aastore
/*      */     //   726: dup
/*      */     //   727: bipush #38
/*      */     //   729: new com/prineside/tdi2/ItemStack
/*      */     //   732: dup
/*      */     //   733: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   736: fconst_1
/*      */     //   737: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   740: iconst_1
/*      */     //   741: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   744: aastore
/*      */     //   745: dup
/*      */     //   746: bipush #39
/*      */     //   748: new com/prineside/tdi2/ItemStack
/*      */     //   751: dup
/*      */     //   752: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   755: iconst_5
/*      */     //   756: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   759: aastore
/*      */     //   760: dup
/*      */     //   761: bipush #40
/*      */     //   763: new com/prineside/tdi2/ItemStack
/*      */     //   766: dup
/*      */     //   767: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   770: iconst_1
/*      */     //   771: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   774: aastore
/*      */     //   775: dup
/*      */     //   776: bipush #41
/*      */     //   778: new com/prineside/tdi2/ItemStack
/*      */     //   781: dup
/*      */     //   782: getstatic com/prineside/tdi2/Item$D.LUCKY_SHOT_TOKEN : Lcom/prineside/tdi2/items/LuckyShotTokenItem;
/*      */     //   785: iconst_1
/*      */     //   786: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   789: aastore
/*      */     //   790: dup
/*      */     //   791: bipush #42
/*      */     //   793: new com/prineside/tdi2/ItemStack
/*      */     //   796: dup
/*      */     //   797: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   800: iconst_2
/*      */     //   801: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   804: aastore
/*      */     //   805: dup
/*      */     //   806: bipush #43
/*      */     //   808: new com/prineside/tdi2/ItemStack
/*      */     //   811: dup
/*      */     //   812: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   815: iconst_2
/*      */     //   816: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   819: aastore
/*      */     //   820: dup
/*      */     //   821: bipush #44
/*      */     //   823: new com/prineside/tdi2/ItemStack
/*      */     //   826: dup
/*      */     //   827: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   830: iconst_1
/*      */     //   831: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   834: aastore
/*      */     //   835: dup
/*      */     //   836: bipush #45
/*      */     //   838: new com/prineside/tdi2/ItemStack
/*      */     //   841: dup
/*      */     //   842: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   845: iconst_5
/*      */     //   846: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   849: aastore
/*      */     //   850: dup
/*      */     //   851: bipush #46
/*      */     //   853: new com/prineside/tdi2/ItemStack
/*      */     //   856: dup
/*      */     //   857: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   860: iconst_2
/*      */     //   861: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   864: aastore
/*      */     //   865: dup
/*      */     //   866: bipush #47
/*      */     //   868: new com/prineside/tdi2/ItemStack
/*      */     //   871: dup
/*      */     //   872: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   875: iconst_2
/*      */     //   876: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   879: aastore
/*      */     //   880: dup
/*      */     //   881: bipush #48
/*      */     //   883: new com/prineside/tdi2/ItemStack
/*      */     //   886: dup
/*      */     //   887: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   890: iconst_1
/*      */     //   891: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   894: aastore
/*      */     //   895: dup
/*      */     //   896: bipush #49
/*      */     //   898: new com/prineside/tdi2/ItemStack
/*      */     //   901: dup
/*      */     //   902: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   905: iconst_1
/*      */     //   906: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   909: aastore
/*      */     //   910: dup
/*      */     //   911: bipush #50
/*      */     //   913: new com/prineside/tdi2/ItemStack
/*      */     //   916: dup
/*      */     //   917: getstatic com/prineside/tdi2/Item$D.ABILITY_TOKEN : Lcom/prineside/tdi2/items/AbilityTokenItem;
/*      */     //   920: iconst_1
/*      */     //   921: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   924: aastore
/*      */     //   925: dup
/*      */     //   926: bipush #51
/*      */     //   928: new com/prineside/tdi2/ItemStack
/*      */     //   931: dup
/*      */     //   932: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   935: iconst_5
/*      */     //   936: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   939: aastore
/*      */     //   940: dup
/*      */     //   941: bipush #52
/*      */     //   943: new com/prineside/tdi2/ItemStack
/*      */     //   946: dup
/*      */     //   947: getstatic com/prineside/tdi2/Item$D.CASE_KEY_ORANGE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   950: iconst_1
/*      */     //   951: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   954: aastore
/*      */     //   955: dup
/*      */     //   956: bipush #53
/*      */     //   958: new com/prineside/tdi2/ItemStack
/*      */     //   961: dup
/*      */     //   962: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   965: iconst_5
/*      */     //   966: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   969: aastore
/*      */     //   970: dup
/*      */     //   971: bipush #54
/*      */     //   973: new com/prineside/tdi2/ItemStack
/*      */     //   976: dup
/*      */     //   977: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   980: fconst_1
/*      */     //   981: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   984: iconst_1
/*      */     //   985: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   988: aastore
/*      */     //   989: dup
/*      */     //   990: bipush #55
/*      */     //   992: new com/prineside/tdi2/ItemStack
/*      */     //   995: dup
/*      */     //   996: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   999: iconst_5
/*      */     //   1000: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1003: aastore
/*      */     //   1004: dup
/*      */     //   1005: bipush #56
/*      */     //   1007: new com/prineside/tdi2/ItemStack
/*      */     //   1010: dup
/*      */     //   1011: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1014: iconst_1
/*      */     //   1015: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1018: aastore
/*      */     //   1019: dup
/*      */     //   1020: bipush #57
/*      */     //   1022: new com/prineside/tdi2/ItemStack
/*      */     //   1025: dup
/*      */     //   1026: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1029: iconst_2
/*      */     //   1030: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1033: aastore
/*      */     //   1034: dup
/*      */     //   1035: bipush #58
/*      */     //   1037: new com/prineside/tdi2/ItemStack
/*      */     //   1040: dup
/*      */     //   1041: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_SPECIAL_I : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1044: iconst_1
/*      */     //   1045: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1048: aastore
/*      */     //   1049: dup
/*      */     //   1050: bipush #59
/*      */     //   1052: new com/prineside/tdi2/ItemStack
/*      */     //   1055: dup
/*      */     //   1056: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1059: iconst_2
/*      */     //   1060: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1063: aastore
/*      */     //   1064: dup
/*      */     //   1065: bipush #60
/*      */     //   1067: new com/prineside/tdi2/ItemStack
/*      */     //   1070: dup
/*      */     //   1071: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1074: iconst_1
/*      */     //   1075: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1078: aastore
/*      */     //   1079: dup
/*      */     //   1080: bipush #61
/*      */     //   1082: new com/prineside/tdi2/ItemStack
/*      */     //   1085: dup
/*      */     //   1086: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1089: iconst_1
/*      */     //   1090: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1093: aastore
/*      */     //   1094: dup
/*      */     //   1095: bipush #62
/*      */     //   1097: new com/prineside/tdi2/ItemStack
/*      */     //   1100: dup
/*      */     //   1101: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1104: iconst_5
/*      */     //   1105: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1108: aastore
/*      */     //   1109: dup
/*      */     //   1110: bipush #63
/*      */     //   1112: new com/prineside/tdi2/ItemStack
/*      */     //   1115: dup
/*      */     //   1116: getstatic com/prineside/tdi2/Item$D.RANDOM_TELEPORT : Lcom/prineside/tdi2/items/RandomTeleportItem;
/*      */     //   1119: iconst_1
/*      */     //   1120: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1123: aastore
/*      */     //   1124: dup
/*      */     //   1125: bipush #64
/*      */     //   1127: new com/prineside/tdi2/ItemStack
/*      */     //   1130: dup
/*      */     //   1131: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1134: iconst_1
/*      */     //   1135: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1138: aastore
/*      */     //   1139: dup
/*      */     //   1140: bipush #65
/*      */     //   1142: new com/prineside/tdi2/ItemStack
/*      */     //   1145: dup
/*      */     //   1146: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_SPECIAL_II : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1149: iconst_1
/*      */     //   1150: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1153: aastore
/*      */     //   1154: dup
/*      */     //   1155: bipush #66
/*      */     //   1157: new com/prineside/tdi2/ItemStack
/*      */     //   1160: dup
/*      */     //   1161: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1164: iconst_5
/*      */     //   1165: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1168: aastore
/*      */     //   1169: dup
/*      */     //   1170: bipush #67
/*      */     //   1172: new com/prineside/tdi2/ItemStack
/*      */     //   1175: dup
/*      */     //   1176: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1179: iconst_2
/*      */     //   1180: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1183: aastore
/*      */     //   1184: dup
/*      */     //   1185: bipush #68
/*      */     //   1187: new com/prineside/tdi2/ItemStack
/*      */     //   1190: dup
/*      */     //   1191: getstatic com/prineside/tdi2/Item$D.CASE_KEY_ORANGE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1194: iconst_1
/*      */     //   1195: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1198: aastore
/*      */     //   1199: dup
/*      */     //   1200: bipush #69
/*      */     //   1202: new com/prineside/tdi2/ItemStack
/*      */     //   1205: dup
/*      */     //   1206: getstatic com/prineside/tdi2/Item$D.LUCKY_SHOT_TOKEN : Lcom/prineside/tdi2/items/LuckyShotTokenItem;
/*      */     //   1209: iconst_1
/*      */     //   1210: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1213: aastore
/*      */     //   1214: dup
/*      */     //   1215: bipush #70
/*      */     //   1217: new com/prineside/tdi2/ItemStack
/*      */     //   1220: dup
/*      */     //   1221: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1224: iconst_5
/*      */     //   1225: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1228: aastore
/*      */     //   1229: dup
/*      */     //   1230: bipush #71
/*      */     //   1232: new com/prineside/tdi2/ItemStack
/*      */     //   1235: dup
/*      */     //   1236: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1239: iconst_2
/*      */     //   1240: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1243: aastore
/*      */     //   1244: dup
/*      */     //   1245: bipush #72
/*      */     //   1247: new com/prineside/tdi2/ItemStack
/*      */     //   1250: dup
/*      */     //   1251: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1254: iconst_1
/*      */     //   1255: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1258: aastore
/*      */     //   1259: dup
/*      */     //   1260: bipush #73
/*      */     //   1262: new com/prineside/tdi2/ItemStack
/*      */     //   1265: dup
/*      */     //   1266: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1269: iconst_5
/*      */     //   1270: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1273: aastore
/*      */     //   1274: dup
/*      */     //   1275: bipush #74
/*      */     //   1277: new com/prineside/tdi2/ItemStack
/*      */     //   1280: dup
/*      */     //   1281: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1284: iconst_3
/*      */     //   1285: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1288: aastore
/*      */     //   1289: dup
/*      */     //   1290: bipush #75
/*      */     //   1292: new com/prineside/tdi2/ItemStack
/*      */     //   1295: dup
/*      */     //   1296: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1299: iconst_1
/*      */     //   1300: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1303: aastore
/*      */     //   1304: dup
/*      */     //   1305: bipush #76
/*      */     //   1307: new com/prineside/tdi2/ItemStack
/*      */     //   1310: dup
/*      */     //   1311: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1314: iconst_1
/*      */     //   1315: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1318: aastore
/*      */     //   1319: dup
/*      */     //   1320: bipush #77
/*      */     //   1322: new com/prineside/tdi2/ItemStack
/*      */     //   1325: dup
/*      */     //   1326: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1329: iconst_5
/*      */     //   1330: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1333: aastore
/*      */     //   1334: dup
/*      */     //   1335: bipush #78
/*      */     //   1337: new com/prineside/tdi2/ItemStack
/*      */     //   1340: dup
/*      */     //   1341: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   1344: fconst_1
/*      */     //   1345: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   1348: iconst_1
/*      */     //   1349: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1352: aastore
/*      */     //   1353: dup
/*      */     //   1354: bipush #79
/*      */     //   1356: new com/prineside/tdi2/ItemStack
/*      */     //   1359: dup
/*      */     //   1360: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1363: iconst_3
/*      */     //   1364: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1367: aastore
/*      */     //   1368: dup
/*      */     //   1369: bipush #80
/*      */     //   1371: new com/prineside/tdi2/ItemStack
/*      */     //   1374: dup
/*      */     //   1375: getstatic com/prineside/tdi2/Item$D.CASE_KEY_CYAN : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1378: iconst_1
/*      */     //   1379: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1382: aastore
/*      */     //   1383: dup
/*      */     //   1384: bipush #81
/*      */     //   1386: new com/prineside/tdi2/ItemStack
/*      */     //   1389: dup
/*      */     //   1390: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1393: iconst_1
/*      */     //   1394: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1397: aastore
/*      */     //   1398: dup
/*      */     //   1399: bipush #82
/*      */     //   1401: new com/prineside/tdi2/ItemStack
/*      */     //   1404: dup
/*      */     //   1405: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1408: iconst_2
/*      */     //   1409: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1412: aastore
/*      */     //   1413: dup
/*      */     //   1414: bipush #83
/*      */     //   1416: new com/prineside/tdi2/ItemStack
/*      */     //   1419: dup
/*      */     //   1420: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1423: iconst_2
/*      */     //   1424: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1427: aastore
/*      */     //   1428: dup
/*      */     //   1429: bipush #84
/*      */     //   1431: new com/prineside/tdi2/ItemStack
/*      */     //   1434: dup
/*      */     //   1435: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1438: iconst_1
/*      */     //   1439: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1442: aastore
/*      */     //   1443: dup
/*      */     //   1444: bipush #85
/*      */     //   1446: new com/prineside/tdi2/ItemStack
/*      */     //   1449: dup
/*      */     //   1450: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1453: iconst_5
/*      */     //   1454: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1457: aastore
/*      */     //   1458: dup
/*      */     //   1459: bipush #86
/*      */     //   1461: new com/prineside/tdi2/ItemStack
/*      */     //   1464: dup
/*      */     //   1465: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   1468: fconst_1
/*      */     //   1469: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   1472: iconst_1
/*      */     //   1473: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1476: aastore
/*      */     //   1477: dup
/*      */     //   1478: bipush #87
/*      */     //   1480: new com/prineside/tdi2/ItemStack
/*      */     //   1483: dup
/*      */     //   1484: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1487: iconst_5
/*      */     //   1488: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1491: aastore
/*      */     //   1492: dup
/*      */     //   1493: bipush #88
/*      */     //   1495: new com/prineside/tdi2/ItemStack
/*      */     //   1498: dup
/*      */     //   1499: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1502: iconst_1
/*      */     //   1503: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1506: aastore
/*      */     //   1507: dup
/*      */     //   1508: bipush #89
/*      */     //   1510: new com/prineside/tdi2/ItemStack
/*      */     //   1513: dup
/*      */     //   1514: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1517: iconst_2
/*      */     //   1518: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1521: aastore
/*      */     //   1522: dup
/*      */     //   1523: bipush #90
/*      */     //   1525: new com/prineside/tdi2/ItemStack
/*      */     //   1528: dup
/*      */     //   1529: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1532: iconst_2
/*      */     //   1533: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1536: aastore
/*      */     //   1537: dup
/*      */     //   1538: bipush #91
/*      */     //   1540: new com/prineside/tdi2/ItemStack
/*      */     //   1543: dup
/*      */     //   1544: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1547: iconst_3
/*      */     //   1548: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1551: aastore
/*      */     //   1552: dup
/*      */     //   1553: bipush #92
/*      */     //   1555: new com/prineside/tdi2/ItemStack
/*      */     //   1558: dup
/*      */     //   1559: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1562: iconst_1
/*      */     //   1563: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1566: aastore
/*      */     //   1567: dup
/*      */     //   1568: bipush #93
/*      */     //   1570: new com/prineside/tdi2/ItemStack
/*      */     //   1573: dup
/*      */     //   1574: getstatic com/prineside/tdi2/Item$D.ABILITY_TOKEN : Lcom/prineside/tdi2/items/AbilityTokenItem;
/*      */     //   1577: iconst_1
/*      */     //   1578: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1581: aastore
/*      */     //   1582: dup
/*      */     //   1583: bipush #94
/*      */     //   1585: new com/prineside/tdi2/ItemStack
/*      */     //   1588: dup
/*      */     //   1589: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1592: iconst_1
/*      */     //   1593: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1596: aastore
/*      */     //   1597: dup
/*      */     //   1598: bipush #95
/*      */     //   1600: new com/prineside/tdi2/ItemStack
/*      */     //   1603: dup
/*      */     //   1604: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1607: iconst_2
/*      */     //   1608: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1611: aastore
/*      */     //   1612: dup
/*      */     //   1613: bipush #96
/*      */     //   1615: new com/prineside/tdi2/ItemStack
/*      */     //   1618: dup
/*      */     //   1619: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1622: iconst_1
/*      */     //   1623: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1626: aastore
/*      */     //   1627: dup
/*      */     //   1628: bipush #97
/*      */     //   1630: new com/prineside/tdi2/ItemStack
/*      */     //   1633: dup
/*      */     //   1634: getstatic com/prineside/tdi2/Item$D.LUCKY_SHOT_TOKEN : Lcom/prineside/tdi2/items/LuckyShotTokenItem;
/*      */     //   1637: iconst_1
/*      */     //   1638: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1641: aastore
/*      */     //   1642: dup
/*      */     //   1643: bipush #98
/*      */     //   1645: new com/prineside/tdi2/ItemStack
/*      */     //   1648: dup
/*      */     //   1649: getstatic com/prineside/tdi2/Item$D.RANDOM_TELEPORT : Lcom/prineside/tdi2/items/RandomTeleportItem;
/*      */     //   1652: iconst_1
/*      */     //   1653: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1656: aastore
/*      */     //   1657: dup
/*      */     //   1658: bipush #99
/*      */     //   1660: new com/prineside/tdi2/ItemStack
/*      */     //   1663: dup
/*      */     //   1664: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1667: iconst_5
/*      */     //   1668: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1671: aastore
/*      */     //   1672: dup
/*      */     //   1673: bipush #100
/*      */     //   1675: new com/prineside/tdi2/ItemStack
/*      */     //   1678: dup
/*      */     //   1679: getstatic com/prineside/tdi2/Item$D.CASE_KEY_ORANGE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1682: iconst_1
/*      */     //   1683: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1686: aastore
/*      */     //   1687: dup
/*      */     //   1688: bipush #101
/*      */     //   1690: new com/prineside/tdi2/ItemStack
/*      */     //   1693: dup
/*      */     //   1694: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1697: iconst_5
/*      */     //   1698: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1701: aastore
/*      */     //   1702: dup
/*      */     //   1703: bipush #102
/*      */     //   1705: new com/prineside/tdi2/ItemStack
/*      */     //   1708: dup
/*      */     //   1709: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_SPECIAL_I : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1712: iconst_1
/*      */     //   1713: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1716: aastore
/*      */     //   1717: dup
/*      */     //   1718: bipush #103
/*      */     //   1720: new com/prineside/tdi2/ItemStack
/*      */     //   1723: dup
/*      */     //   1724: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   1727: fconst_1
/*      */     //   1728: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   1731: iconst_1
/*      */     //   1732: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1735: aastore
/*      */     //   1736: dup
/*      */     //   1737: bipush #104
/*      */     //   1739: new com/prineside/tdi2/ItemStack
/*      */     //   1742: dup
/*      */     //   1743: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1746: iconst_1
/*      */     //   1747: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1750: aastore
/*      */     //   1751: dup
/*      */     //   1752: bipush #105
/*      */     //   1754: new com/prineside/tdi2/ItemStack
/*      */     //   1757: dup
/*      */     //   1758: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1761: iconst_3
/*      */     //   1762: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1765: aastore
/*      */     //   1766: dup
/*      */     //   1767: bipush #106
/*      */     //   1769: new com/prineside/tdi2/ItemStack
/*      */     //   1772: dup
/*      */     //   1773: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1776: iconst_5
/*      */     //   1777: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1780: aastore
/*      */     //   1781: dup
/*      */     //   1782: bipush #107
/*      */     //   1784: new com/prineside/tdi2/ItemStack
/*      */     //   1787: dup
/*      */     //   1788: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1791: iconst_1
/*      */     //   1792: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1795: aastore
/*      */     //   1796: dup
/*      */     //   1797: bipush #108
/*      */     //   1799: new com/prineside/tdi2/ItemStack
/*      */     //   1802: dup
/*      */     //   1803: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1806: iconst_1
/*      */     //   1807: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1810: aastore
/*      */     //   1811: dup
/*      */     //   1812: bipush #109
/*      */     //   1814: new com/prineside/tdi2/ItemStack
/*      */     //   1817: dup
/*      */     //   1818: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1821: iconst_2
/*      */     //   1822: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1825: aastore
/*      */     //   1826: dup
/*      */     //   1827: bipush #110
/*      */     //   1829: new com/prineside/tdi2/ItemStack
/*      */     //   1832: dup
/*      */     //   1833: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1836: iconst_5
/*      */     //   1837: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1840: aastore
/*      */     //   1841: dup
/*      */     //   1842: bipush #111
/*      */     //   1844: new com/prineside/tdi2/ItemStack
/*      */     //   1847: dup
/*      */     //   1848: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_EXPERIENCE : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1851: iconst_2
/*      */     //   1852: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1855: aastore
/*      */     //   1856: dup
/*      */     //   1857: bipush #112
/*      */     //   1859: new com/prineside/tdi2/ItemStack
/*      */     //   1862: dup
/*      */     //   1863: getstatic com/prineside/tdi2/Item$D.CASE_KEY_PURPLE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1866: iconst_1
/*      */     //   1867: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1870: aastore
/*      */     //   1871: dup
/*      */     //   1872: bipush #113
/*      */     //   1874: new com/prineside/tdi2/ItemStack
/*      */     //   1877: dup
/*      */     //   1878: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1881: iconst_2
/*      */     //   1882: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1885: aastore
/*      */     //   1886: dup
/*      */     //   1887: bipush #114
/*      */     //   1889: new com/prineside/tdi2/ItemStack
/*      */     //   1892: dup
/*      */     //   1893: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_SPECIAL_II : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1896: iconst_1
/*      */     //   1897: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1900: aastore
/*      */     //   1901: dup
/*      */     //   1902: bipush #115
/*      */     //   1904: new com/prineside/tdi2/ItemStack
/*      */     //   1907: dup
/*      */     //   1908: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   1911: iconst_5
/*      */     //   1912: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1915: aastore
/*      */     //   1916: dup
/*      */     //   1917: bipush #116
/*      */     //   1919: new com/prineside/tdi2/ItemStack
/*      */     //   1922: dup
/*      */     //   1923: getstatic com/prineside/tdi2/Item$D.CASE_KEY_BLUE : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1926: iconst_1
/*      */     //   1927: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1930: aastore
/*      */     //   1931: dup
/*      */     //   1932: bipush #117
/*      */     //   1934: new com/prineside/tdi2/ItemStack
/*      */     //   1937: dup
/*      */     //   1938: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   1941: fconst_1
/*      */     //   1942: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   1945: iconst_1
/*      */     //   1946: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1949: aastore
/*      */     //   1950: dup
/*      */     //   1951: bipush #118
/*      */     //   1953: new com/prineside/tdi2/ItemStack
/*      */     //   1956: dup
/*      */     //   1957: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_POWER : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   1960: iconst_2
/*      */     //   1961: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1964: aastore
/*      */     //   1965: dup
/*      */     //   1966: bipush #119
/*      */     //   1968: new com/prineside/tdi2/ItemStack
/*      */     //   1971: dup
/*      */     //   1972: getstatic com/prineside/tdi2/Item$D.ACCELERATOR : Lcom/prineside/tdi2/items/AcceleratorItem;
/*      */     //   1975: iconst_1
/*      */     //   1976: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1979: aastore
/*      */     //   1980: dup
/*      */     //   1981: bipush #120
/*      */     //   1983: new com/prineside/tdi2/ItemStack
/*      */     //   1986: dup
/*      */     //   1987: getstatic com/prineside/tdi2/Item$D.CASE_KEY_CYAN : Lcom/prineside/tdi2/items/CaseKeyItem;
/*      */     //   1990: iconst_1
/*      */     //   1991: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   1994: aastore
/*      */     //   1995: dup
/*      */     //   1996: bipush #121
/*      */     //   1998: new com/prineside/tdi2/ItemStack
/*      */     //   2001: dup
/*      */     //   2002: getstatic com/prineside/tdi2/Item$D.BIT_DUST : Lcom/prineside/tdi2/items/BitDustItem;
/*      */     //   2005: iconst_5
/*      */     //   2006: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   2009: aastore
/*      */     //   2010: dup
/*      */     //   2011: bipush #122
/*      */     //   2013: new com/prineside/tdi2/ItemStack
/*      */     //   2016: dup
/*      */     //   2017: getstatic com/prineside/tdi2/Item$D.BLUEPRINT_AGILITY : Lcom/prineside/tdi2/items/BlueprintItem;
/*      */     //   2020: iconst_2
/*      */     //   2021: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   2024: aastore
/*      */     //   2025: dup
/*      */     //   2026: bipush #123
/*      */     //   2028: new com/prineside/tdi2/ItemStack
/*      */     //   2031: dup
/*      */     //   2032: getstatic com/prineside/tdi2/Item$D.RESEARCH_TOKEN : Lcom/prineside/tdi2/items/ResearchTokenItem;
/*      */     //   2035: iconst_1
/*      */     //   2036: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   2039: aastore
/*      */     //   2040: putfield l : [Lcom/prineside/tdi2/ItemStack;
/*      */     //   2043: iload_1
/*      */     //   2044: aload_0
/*      */     //   2045: getfield l : [Lcom/prineside/tdi2/ItemStack;
/*      */     //   2048: dup_x1
/*      */     //   2049: arraylength
/*      */     //   2050: irem
/*      */     //   2051: aaload
/*      */     //   2052: invokevirtual cpy : ()Lcom/prineside/tdi2/ItemStack;
/*      */     //   2055: dup
/*      */     //   2056: astore_1
/*      */     //   2057: ifnull -> 2224
/*      */     //   2060: fload_2
/*      */     //   2061: ldc 216000.0
/*      */     //   2063: fcmpl
/*      */     //   2064: ifle -> 2085
/*      */     //   2067: aload_1
/*      */     //   2068: dup
/*      */     //   2069: invokevirtual getCount : ()I
/*      */     //   2072: i2f
/*      */     //   2073: ldc 1.6
/*      */     //   2075: fmul
/*      */     //   2076: invokestatic round : (F)I
/*      */     //   2079: invokevirtual setCount : (I)V
/*      */     //   2082: goto -> 2132
/*      */     //   2085: fload_2
/*      */     //   2086: ldc 36000.0
/*      */     //   2088: fcmpl
/*      */     //   2089: ifle -> 2110
/*      */     //   2092: aload_1
/*      */     //   2093: dup
/*      */     //   2094: invokevirtual getCount : ()I
/*      */     //   2097: i2f
/*      */     //   2098: ldc 1.4
/*      */     //   2100: fmul
/*      */     //   2101: invokestatic round : (F)I
/*      */     //   2104: invokevirtual setCount : (I)V
/*      */     //   2107: goto -> 2132
/*      */     //   2110: fload_2
/*      */     //   2111: ldc 7200.0
/*      */     //   2113: fcmpl
/*      */     //   2114: ifle -> 2132
/*      */     //   2117: aload_1
/*      */     //   2118: dup
/*      */     //   2119: invokevirtual getCount : ()I
/*      */     //   2122: i2f
/*      */     //   2123: ldc 1.2
/*      */     //   2125: fmul
/*      */     //   2126: invokestatic round : (F)I
/*      */     //   2129: invokevirtual setCount : (I)V
/*      */     //   2132: aload_1
/*      */     //   2133: invokevirtual getItem : ()Lcom/prineside/tdi2/Item;
/*      */     //   2136: invokevirtual getType : ()Lcom/prineside/tdi2/enums/ItemType;
/*      */     //   2139: getstatic com/prineside/tdi2/enums/ItemType.BIT_DUST : Lcom/prineside/tdi2/enums/ItemType;
/*      */     //   2142: if_acmpne -> 2215
/*      */     //   2145: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   2148: getfield progressManager : Lcom/prineside/tdi2/managers/ProgressManager;
/*      */     //   2151: getstatic com/prineside/tdi2/enums/DifficultyMode.ENDLESS_I : Lcom/prineside/tdi2/enums/DifficultyMode;
/*      */     //   2154: invokevirtual difficultyModeAvailable : (Lcom/prineside/tdi2/enums/DifficultyMode;)Z
/*      */     //   2157: ifeq -> 2186
/*      */     //   2160: aload #5
/*      */     //   2162: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   2165: new com/prineside/tdi2/ItemStack
/*      */     //   2168: dup
/*      */     //   2169: getstatic com/prineside/tdi2/Item$D.F_RANDOM_TILE : Lcom/prineside/tdi2/items/RandomTileItem$RandomTileItemFactory;
/*      */     //   2172: fconst_1
/*      */     //   2173: invokevirtual create : (F)Lcom/prineside/tdi2/items/RandomTileItem;
/*      */     //   2176: iconst_1
/*      */     //   2177: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   2180: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   2183: goto -> 2224
/*      */     //   2186: aload_1
/*      */     //   2187: dup
/*      */     //   2188: invokevirtual getCount : ()I
/*      */     //   2191: i2f
/*      */     //   2192: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   2195: getfield gameValueManager : Lcom/prineside/tdi2/managers/GameValueManager;
/*      */     //   2198: invokevirtual getSnapshot : ()Lcom/prineside/tdi2/managers/GameValueManager$GameValuesSnapshot;
/*      */     //   2201: getstatic com/prineside/tdi2/enums/GameValueType.BIT_DUST_DROP_RATE : Lcom/prineside/tdi2/enums/GameValueType;
/*      */     //   2204: invokevirtual getPercentValueAsMultiplier : (Lcom/prineside/tdi2/enums/GameValueType;)D
/*      */     //   2207: d2f
/*      */     //   2208: fmul
/*      */     //   2209: invokestatic round : (F)I
/*      */     //   2212: invokevirtual setCount : (I)V
/*      */     //   2215: aload #5
/*      */     //   2217: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   2220: aload_1
/*      */     //   2221: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   2224: iconst_5
/*      */     //   2225: anewarray com/prineside/tdi2/enums/StatisticsType
/*      */     //   2228: dup
/*      */     //   2229: iconst_0
/*      */     //   2230: getstatic com/prineside/tdi2/enums/StatisticsType.RG_I : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   2233: aastore
/*      */     //   2234: dup
/*      */     //   2235: iconst_1
/*      */     //   2236: getstatic com/prineside/tdi2/enums/StatisticsType.RG_T : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   2239: aastore
/*      */     //   2240: dup
/*      */     //   2241: iconst_2
/*      */     //   2242: getstatic com/prineside/tdi2/enums/StatisticsType.RG_M : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   2245: aastore
/*      */     //   2246: dup
/*      */     //   2247: iconst_3
/*      */     //   2248: getstatic com/prineside/tdi2/enums/StatisticsType.RG_V : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   2251: aastore
/*      */     //   2252: dup
/*      */     //   2253: iconst_4
/*      */     //   2254: getstatic com/prineside/tdi2/enums/StatisticsType.RG_S : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   2257: aastore
/*      */     //   2258: astore_1
/*      */     //   2259: iconst_0
/*      */     //   2260: istore_2
/*      */     //   2261: iload_2
/*      */     //   2262: iconst_5
/*      */     //   2263: if_icmpge -> 2410
/*      */     //   2266: aload_1
/*      */     //   2267: iload_2
/*      */     //   2268: aaload
/*      */     //   2269: astore #6
/*      */     //   2271: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*      */     //   2274: getfield statisticsManager : Lcom/prineside/tdi2/managers/StatisticsManager;
/*      */     //   2277: aload #6
/*      */     //   2279: invokevirtual getAllTime : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*      */     //   2282: d2f
/*      */     //   2283: f2d
/*      */     //   2284: dload_3
/*      */     //   2285: dmul
/*      */     //   2286: ldc2_w 1.5
/*      */     //   2289: dmul
/*      */     //   2290: d2i
/*      */     //   2291: dup
/*      */     //   2292: istore #7
/*      */     //   2294: iconst_5
/*      */     //   2295: if_icmple -> 2404
/*      */     //   2298: getstatic com/prineside/tdi2/Item$D.RESOURCE_SCALAR : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2301: astore #8
/*      */     //   2303: getstatic com/prineside/tdi2/managers/ProgressManager$5.f : [I
/*      */     //   2306: aload #6
/*      */     //   2308: invokevirtual ordinal : ()I
/*      */     //   2311: iaload
/*      */     //   2312: tableswitch default -> 2385, 1 -> 2348, 2 -> 2356, 3 -> 2364, 4 -> 2372, 5 -> 2380
/*      */     //   2348: getstatic com/prineside/tdi2/Item$D.RESOURCE_SCALAR : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2351: astore #8
/*      */     //   2353: goto -> 2385
/*      */     //   2356: getstatic com/prineside/tdi2/Item$D.RESOURCE_VECTOR : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2359: astore #8
/*      */     //   2361: goto -> 2385
/*      */     //   2364: getstatic com/prineside/tdi2/Item$D.RESOURCE_MATRIX : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2367: astore #8
/*      */     //   2369: goto -> 2385
/*      */     //   2372: getstatic com/prineside/tdi2/Item$D.RESOURCE_TENSOR : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2375: astore #8
/*      */     //   2377: goto -> 2385
/*      */     //   2380: getstatic com/prineside/tdi2/Item$D.RESOURCE_INFIAR : Lcom/prineside/tdi2/items/ResourceItem;
/*      */     //   2383: astore #8
/*      */     //   2385: aload #5
/*      */     //   2387: getfield items : Lcom/badlogic/gdx/utils/Array;
/*      */     //   2390: new com/prineside/tdi2/ItemStack
/*      */     //   2393: dup
/*      */     //   2394: aload #8
/*      */     //   2396: iload #7
/*      */     //   2398: invokespecial <init> : (Lcom/prineside/tdi2/Item;I)V
/*      */     //   2401: invokevirtual add : (Ljava/lang/Object;)V
/*      */     //   2404: iinc #2, 1
/*      */     //   2407: goto -> 2261
/*      */     //   2410: aload #5
/*      */     //   2412: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #2968	-> 0
/*      */     //   #2969	-> 14
/*      */     //   #2970	-> 33
/*      */     //   #2971	-> 45
/*      */     //   #2973	-> 54
/*      */     //   #2976	-> 87
/*      */     //   #2977	-> 101
/*      */     //   #2978	-> 108
/*      */     //   #2979	-> 116
/*      */     //   #2981	-> 121
/*      */     //   #2986	-> 141
/*      */     //   #2987	-> 148
/*      */     //   #3001	-> 354
/*      */     //   #3010	-> 493
/*      */     //   #3026	-> 737
/*      */     //   #3042	-> 981
/*      */     //   #3066	-> 1345
/*      */     //   #3074	-> 1469
/*      */     //   #3091	-> 1728
/*      */     //   #3105	-> 1942
/*      */     //   #3115	-> 2043
/*      */     //   #3116	-> 2056
/*      */     //   #3117	-> 2060
/*      */     //   #3118	-> 2067
/*      */     //   #3119	-> 2085
/*      */     //   #3120	-> 2092
/*      */     //   #3121	-> 2110
/*      */     //   #3122	-> 2117
/*      */     //   #3124	-> 2132
/*      */     //   #3125	-> 2145
/*      */     //   #3127	-> 2160
/*      */     //   #3130	-> 2186
/*      */     //   #3134	-> 2215
/*      */     //   #3139	-> 2224
/*      */     //   #3146	-> 2271
/*      */     //   #3147	-> 2292
/*      */     //   #3148	-> 2298
/*      */     //   #3149	-> 2303
/*      */     //   #3150	-> 2348
/*      */     //   #3151	-> 2356
/*      */     //   #3152	-> 2364
/*      */     //   #3153	-> 2372
/*      */     //   #3154	-> 2380
/*      */     //   #3156	-> 2385
/*      */     //   #3139	-> 2404
/*      */     //   #3163	-> 2410
/*      */   }
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
/*      */ 
/*      */   
/*      */   public int getGameStartGameVersion() {
/* 3172 */     return (ProgressPrefs.i()).progress.getGameStartGameVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getGameStartTimestamp() {
/* 3179 */     return (ProgressPrefs.i()).progress.getGameStartTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGameStartHash() {
/* 3186 */     return (ProgressPrefs.i()).progress.getGameStartHash();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void enableDeveloperMode() {
/* 3192 */     if (!isDeveloperModeEnabled())
/*      */     {
/* 3194 */       Game.i.researchManager.setInstalledLevel(ResearchType.DEVELOPER_MODE, 1, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDeveloperModeEnabled() {
/* 3201 */     if (Config.isModdingMode()) return true; 
/* 3202 */     return (Game.i.gameValueManager != null && Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.DEVELOPER_MODE));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkSpecialTrophiesGiven() {
/* 3209 */     IssuedItems issuedItems = new IssuedItems(IssuedItems.IssueReason.REGULAR_REWARD, Game.getTimestampSeconds());
/*      */     
/* 3211 */     DelayedRemovalArray<ItemStack> delayedRemovalArray = getItemsByType(ItemType.TROPHY);
/*      */ 
/*      */     
/* 3214 */     for (Array.ArrayIterator<BasicLevel> arrayIterator = Game.i.basicLevelManager.levelsOrdered.iterator(); arrayIterator.hasNext();) {
/* 3215 */       for (Array.ArrayIterator<BasicLevel.WaveQuest> arrayIterator1 = (basicLevel = arrayIterator.next()).waveQuests.iterator(); arrayIterator1.hasNext();) {
/* 3216 */         if ((waveQuest = arrayIterator1.next()).isCompleted()) {
/* 3217 */           for (Array.ArrayIterator<ItemStack> arrayIterator2 = waveQuest.prizes.iterator(); arrayIterator2.hasNext();) {
/* 3218 */             if ((itemStack = arrayIterator2.next()).getItem().getType() == ItemType.TROPHY) {
/* 3219 */               TrophyItem trophyItem = (TrophyItem)itemStack.getItem();
/* 3220 */               boolean bool = false;
/* 3221 */               for (byte b1 = 0; b1 < delayedRemovalArray.size; b1++) {
/* 3222 */                 TrophyItem trophyItem1 = (TrophyItem)((ItemStack[])delayedRemovalArray.items)[b1].getItem();
/* 3223 */                 if (trophyItem.trophyType == trophyItem1.trophyType) {
/* 3224 */                   bool = true;
/*      */                   break;
/*      */                 } 
/*      */               } 
/* 3228 */               if (!bool) {
/* 3229 */                 a.i("restoring trophy for completed quest " + waveQuest + " " + trophyItem.trophyType, new Object[0]);
/* 3230 */                 TrophyItem trophyItem1 = Item.D.F_TROPHY.create(trophyItem.trophyType);
/* 3231 */                 itemStack = new ItemStack((Item)trophyItem1, 1);
/* 3232 */                 issuedItems.items.add(itemStack);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3240 */     boolean bool1 = false;
/* 3241 */     boolean bool2 = false;
/* 3242 */     boolean bool3 = false;
/* 3243 */     boolean bool4 = false;
/*      */     byte b;
/* 3245 */     for (b = 0; b < delayedRemovalArray.size; b++) {
/*      */       TrophyItem trophyItem;
/* 3247 */       if ((trophyItem = (TrophyItem)((ItemStack[])delayedRemovalArray.items)[b].getItem()).trophyType == TrophyType.SPECIAL_DEVELOPER) {
/* 3248 */         bool1 = true;
/* 3249 */       } else if (trophyItem.trophyType == TrophyType.SPECIAL_MASTER) {
/* 3250 */         bool2 = true;
/* 3251 */       } else if (trophyItem.trophyType == TrophyType.SPECIAL_MILLION) {
/* 3252 */         bool3 = true;
/* 3253 */       } else if (trophyItem.trophyType == TrophyType.SPECIAL_STORYLINE) {
/* 3254 */         bool4 = true;
/*      */       } 
/*      */     } 
/*      */     
/* 3258 */     if (!bool1 && (
/* 3259 */       isDeveloperModeEnabled() || Game.i.researchManager.canStartResearching(Game.i.researchManager.getInstance(ResearchType.DEVELOPER_MODE), true))) {
/*      */       
/* 3261 */       TrophyItem trophyItem = Item.D.F_TROPHY.create(TrophyType.SPECIAL_DEVELOPER);
/* 3262 */       ItemStack itemStack = new ItemStack((Item)trophyItem, 1);
/* 3263 */       issuedItems.items.add(itemStack);
/*      */     } 
/* 3265 */     if (!bool2) {
/* 3266 */       b = 1;
/* 3267 */       for (byte b1 = 0; b1 < Game.i.basicLevelManager.stagesOrdered.size; b1++) {
/*      */         BasicLevelStage basicLevelStage;
/* 3269 */         if ((basicLevelStage = ((BasicLevelStage[])Game.i.basicLevelManager.stagesOrdered.items)[b1]).name.equals("1") || basicLevelStage.name.equals("2") || basicLevelStage.name.equals("3") || basicLevelStage.name.equals("4") || basicLevelStage.name.equals("5"))
/*      */         {
/* 3271 */           for (byte b2 = 0; b2 < basicLevelStage.levels.size; b2++) {
/* 3272 */             BasicLevel basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[b2];
/*      */             
/* 3274 */             if (b2 < 8 && !Game.i.basicLevelManager.isMastered(basicLevel)) {
/* 3275 */               b = 0;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/* 3281 */       if (b != 0) {
/* 3282 */         TrophyItem trophyItem = Item.D.F_TROPHY.create(TrophyType.SPECIAL_MASTER);
/* 3283 */         ItemStack itemStack = new ItemStack((Item)trophyItem, 1);
/* 3284 */         issuedItems.items.add(itemStack);
/*      */       } 
/*      */     } 
/* 3287 */     if (!bool3 && 
/* 3288 */       Game.i.statisticsManager.getMaxOneGame(StatisticsType.SG) >= 1000000.0D) {
/* 3289 */       TrophyItem trophyItem = Item.D.F_TROPHY.create(TrophyType.SPECIAL_MILLION);
/* 3290 */       ItemStack itemStack = new ItemStack((Item)trophyItem, 1);
/* 3291 */       issuedItems.items.add(itemStack);
/*      */     } 
/*      */     
/* 3294 */     if (!bool4 && 
/* 3295 */       Game.i.basicLevelManager.getGainedStarsOnLevel(Game.i.basicLevelManager.getLevel("5.8")) >= 3) {
/* 3296 */       TrophyItem trophyItem = Item.D.F_TROPHY.create(TrophyType.SPECIAL_STORYLINE);
/* 3297 */       ItemStack itemStack = new ItemStack((Item)trophyItem, 1);
/* 3298 */       issuedItems.items.add(itemStack);
/*      */     } 
/*      */ 
/*      */     
/* 3302 */     if (issuedItems.items.size != 0) {
/* 3303 */       addIssuedPrizes(issuedItems, true);
/* 3304 */       Game.i.progressManager.addItemArray(issuedItems.items, "trophy");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InventoryStatistics getInventoryStatistics() {
/*      */     InventoryStatistics inventoryStatistics;
/* 3315 */     (inventoryStatistics = new InventoryStatistics()).lootBoostTimeLeft = (ProgressPrefs.i()).progress.getLootBoostTimeLeft();
/*      */     
/* 3317 */     Array array = (ProgressPrefs.i()).inventory.getAllItems();
/* 3318 */     for (byte b = 0; b < array.size; b++) {
/* 3319 */       ItemStack itemStack = ((ItemStack[])array.items)[b];
/* 3320 */       inventoryStatistics.countItem(itemStack.getItem(), itemStack.getCount());
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 3325 */     return inventoryStatistics;
/*      */   }
/*      */   
/*      */   public static interface ProgressManagerListener {
/*      */     void itemsChanged(Item param1Item, int param1Int1, int param1Int2);
/*      */     
/*      */     void doubleGainEnabled();
/*      */     
/*      */     void developerConsoleEnabled();
/*      */     
/*      */     public static abstract class ProgressManagerListenerAdapter implements ProgressManagerListener {
/*      */       public void itemsChanged(Item param2Item, int param2Int1, int param2Int2) {}
/*      */       
/*      */       public void doubleGainEnabled() {}
/*      */       
/*      */       public void developerConsoleEnabled() {}
/*      */     }
/*      */   }
/*      */   
/*      */   private class _GameValueManagerListener implements GameValueManager.GameValueManagerListener {
/*      */     private boolean a = false;
/*      */     
/*      */     public void gameValuesRecalculated() {
/* 3348 */       if (Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.DEVELOPER_MODE)) {
/* 3349 */         if (!this.a) {
/*      */           
/* 3351 */           this.a = true;
/*      */           
/* 3353 */           ProgressManager.a(this.b).begin(); byte b; int i;
/* 3354 */           for (b = 0, i = (ProgressManager.a(this.b)).size; b < i; b++) {
/* 3355 */             ((ProgressManager.ProgressManagerListener)ProgressManager.a(this.b).get(b)).developerConsoleEnabled();
/*      */           }
/* 3357 */           ProgressManager.a(this.b).end();
/*      */           
/* 3359 */           this.b.checkSpecialTrophiesGiven();
/*      */           return;
/*      */         } 
/* 3362 */       } else if (this.a) {
/*      */         
/* 3364 */         this.a = false;
/*      */       } 
/*      */     }
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
/*      */     private _GameValueManagerListener(ProgressManager this$0) {}
/*      */   }
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
/*      */   public static class CraftingQueueItem
/*      */   {
/*      */     public ItemStack result;
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
/*      */     public Array<ItemStack> ingredients;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public float duration;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public float timePassed;
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
/*      */     public CraftingQueueItem() {
/* 3446 */       this.ingredients = new Array(ItemStack.class);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float getTimePassed() {
/* 3452 */       return this.timePassed;
/*      */     }
/*      */     
/*      */     public float getTotalTime() {
/* 3456 */       return this.duration * this.count;
/*      */     }
/*      */     
/*      */     public int getCraftedCount() {
/* 3460 */       if (getTimeLeft() == 0.0F) {
/* 3461 */         return this.count;
/*      */       }
/* 3463 */       return (int)(this.timePassed / this.duration);
/*      */     }
/*      */ 
/*      */     
/*      */     public float getTimeLeft() {
/* 3468 */       float f = getTotalTime();
/* 3469 */       if (this.timePassed >= f) {
/* 3470 */         return 0.0F;
/*      */       }
/* 3472 */       return f - this.timePassed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static CraftingQueueItem fromJson(JsonValue param1JsonValue) {
/*      */       CraftingQueueItem craftingQueueItem;
/* 3479 */       (craftingQueueItem = new CraftingQueueItem()).result = ItemStack.fromJson(param1JsonValue.get("result"));
/*      */       JsonValue jsonValue;
/* 3481 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = param1JsonValue.get("ingredients")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 3482 */         craftingQueueItem.ingredients.add(ItemStack.fromJson(jsonValue1)); }
/*      */       
/* 3484 */       craftingQueueItem.count = param1JsonValue.getInt("count");
/* 3485 */       craftingQueueItem.duration = param1JsonValue.getInt("duration");
/* 3486 */       craftingQueueItem.timePassed = param1JsonValue.getInt("timePassed");
/*      */       
/* 3488 */       return craftingQueueItem;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void toJson(Json param1Json) {
/* 3495 */       param1Json.writeObjectStart("result");
/* 3496 */       this.result.toJson(param1Json);
/* 3497 */       param1Json.writeObjectEnd();
/*      */       
/* 3499 */       param1Json.writeArrayStart("ingredients");
/* 3500 */       for (byte b = 0; b < this.ingredients.size; b++) {
/* 3501 */         param1Json.writeObjectStart();
/* 3502 */         ((ItemStack[])this.ingredients.items)[b].toJson(param1Json);
/* 3503 */         param1Json.writeObjectEnd();
/*      */       } 
/* 3505 */       param1Json.writeArrayEnd();
/*      */       
/* 3507 */       param1Json.writeValue("count", Integer.valueOf(this.count));
/* 3508 */       param1Json.writeValue("duration", Float.valueOf(this.duration));
/* 3509 */       param1Json.writeValue("timePassed", Float.valueOf(this.timePassed));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class VideoAdViewBonus {
/*      */     public int views;
/*      */     public ItemStack item;
/*      */     public boolean doubleGain;
/*      */     
/*      */     public VideoAdViewBonus(int param1Int, ItemStack param1ItemStack) {
/* 3519 */       this.views = param1Int;
/* 3520 */       this.item = param1ItemStack;
/*      */     }
/*      */     
/*      */     public VideoAdViewBonus(int param1Int, ItemStack param1ItemStack, boolean param1Boolean) {
/* 3524 */       this(param1Int, param1ItemStack);
/* 3525 */       this.doubleGain = param1Boolean;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class ShopOffer
/*      */   {
/*      */     public ItemStack price;
/*      */     public ItemStack item;
/*      */     public int discountPercent;
/*      */     public boolean purchased;
/*      */     public float reducedDueToLargePrice;
/*      */     public float increasedDueToLowPrice;
/*      */     
/*      */     public ShopOffer() {}
/*      */     
/*      */     public ShopOffer(ItemStack param1ItemStack1, ItemStack param1ItemStack2) {
/* 3542 */       this.price = param1ItemStack1;
/* 3543 */       this.item = param1ItemStack2;
/*      */     }
/*      */     
/*      */     public ShopOffer(ItemStack param1ItemStack1, ItemStack param1ItemStack2, int param1Int) {
/* 3547 */       this.price = param1ItemStack1;
/* 3548 */       this.item = param1ItemStack2;
/* 3549 */       this.discountPercent = param1Int;
/*      */     }
/*      */     
/*      */     public static ShopOffer fromJson(JsonValue param1JsonValue) {
/*      */       ShopOffer shopOffer;
/* 3554 */       (shopOffer = new ShopOffer()).price = ItemStack.fromJson(param1JsonValue.get("price"));
/* 3555 */       shopOffer.item = ItemStack.fromJson(param1JsonValue.get("item"));
/* 3556 */       shopOffer.discountPercent = param1JsonValue.getInt("discountPercent", 0);
/* 3557 */       shopOffer.purchased = param1JsonValue.getBoolean("purchased", false);
/* 3558 */       return shopOffer;
/*      */     }
/*      */     
/*      */     public void toJson(Json param1Json) {
/* 3562 */       param1Json.writeObjectStart("price");
/* 3563 */       this.price.toJson(param1Json);
/* 3564 */       param1Json.writeObjectEnd();
/* 3565 */       param1Json.writeObjectStart("item");
/* 3566 */       this.item.toJson(param1Json);
/* 3567 */       param1Json.writeObjectEnd();
/* 3568 */       if (this.purchased) {
/* 3569 */         param1Json.writeValue("purchased", Boolean.TRUE);
/*      */       }
/* 3571 */       if (this.discountPercent != 0)
/* 3572 */         param1Json.writeValue("discountPercent", Integer.valueOf(this.discountPercent)); 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static class InventoryStatistics
/*      */     implements KryoSerializable {
/* 3579 */     public int[] byTileType = new int[TileType.values.length];
/*      */     
/*      */     public float lootBoostTimeLeft;
/*      */     public int rarityBoostsCount;
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/* 3585 */       param1Kryo.writeObject(param1Output, this.byTileType);
/* 3586 */       param1Output.writeFloat(this.lootBoostTimeLeft);
/* 3587 */       param1Output.writeVarInt(this.rarityBoostsCount, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/* 3592 */       this.byTileType = (int[])param1Kryo.readObject(param1Input, int[].class);
/* 3593 */       this.lootBoostTimeLeft = param1Input.readFloat();
/* 3594 */       this.rarityBoostsCount = param1Input.readVarInt(true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public InventoryStatistics cpy() {
/* 3600 */       InventoryStatistics inventoryStatistics = new InventoryStatistics();
/* 3601 */       System.arraycopy(this.byTileType, 0, inventoryStatistics.byTileType, 0, this.byTileType.length);
/* 3602 */       inventoryStatistics.lootBoostTimeLeft = this.lootBoostTimeLeft;
/* 3603 */       inventoryStatistics.rarityBoostsCount = this.rarityBoostsCount;
/* 3604 */       return inventoryStatistics;
/*      */     }
/*      */     
/*      */     public void countItem(Item param1Item, int param1Int) {
/* 3608 */       if (param1Int <= 0) throw new IllegalArgumentException("Invalid count: " + param1Int);
/*      */       
/* 3610 */       switch (ProgressManager.null.g[param1Item.getType().ordinal()]) {
/*      */         case 1:
/* 3612 */           a((TileItem)param1Item, param1Int);
/*      */           return;
/*      */         
/*      */         case 2:
/* 3616 */           this.rarityBoostsCount += param1Int;
/*      */           return;
/*      */         
/*      */         case 3:
/* 3620 */           this.lootBoostTimeLeft += 7200.0F * param1Int;
/*      */           break;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void a(TileItem param1TileItem, int param1Int) {
/* 3627 */       this.byTileType[param1TileItem.tile.type.ordinal()] = this.byTileType[param1TileItem.tile.type.ordinal()] + param1Int;
/*      */     }
/*      */     
/*      */     public void reset() {
/* 3631 */       Arrays.fill(this.byTileType, 0);
/* 3632 */       this.lootBoostTimeLeft = 0.0F;
/* 3633 */       this.rarityBoostsCount = 0;
/*      */     } }
/*      */   @REGS
/*      */   public static final class ProgressSnapshotForState implements KryoSerializable { private IntIntMap a;
/*      */     private IntSet b;
/*      */     private ObjectSet<String> c;
/*      */     public int statsPlayTimeCasesLoot;
/*      */     public int statsPlayRealTime;
/*      */     public int statsQueuedCasesGiven;
/*      */     
/*      */     public ProgressSnapshotForState() {
/* 3644 */       this.a = new IntIntMap();
/* 3645 */       this.b = new IntSet();
/* 3646 */       this.c = new ObjectSet();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 3655 */       param1Kryo.writeObject(param1Output, this.a);
/* 3656 */       param1Kryo.writeObject(param1Output, this.b);
/* 3657 */       param1Kryo.writeObject(param1Output, this.c);
/* 3658 */       param1Output.writeVarInt(this.statsPlayTimeCasesLoot, true);
/* 3659 */       param1Output.writeVarInt(this.statsPlayRealTime, true);
/* 3660 */       param1Output.writeVarInt(this.statsQueuedCasesGiven, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 3665 */       this.a = (IntIntMap)param1Kryo.readObject(param1Input, IntIntMap.class);
/* 3666 */       this.b = (IntSet)param1Kryo.readObject(param1Input, IntSet.class);
/* 3667 */       this.c = (ObjectSet<String>)param1Kryo.readObject(param1Input, ObjectSet.class);
/* 3668 */       this.statsPlayTimeCasesLoot = param1Input.readVarInt(true);
/* 3669 */       this.statsPlayRealTime = param1Input.readVarInt(true);
/* 3670 */       this.statsQueuedCasesGiven = param1Input.readVarInt(true);
/*      */     }
/*      */     
/*      */     public final int getResearchCount() {
/* 3674 */       return this.a.size;
/*      */     }
/*      */     
/*      */     public final int getResearchLevelsCount() {
/* 3678 */       int i = 0;
/* 3679 */       for (IntIntMap.Entry entry : this.a) {
/* 3680 */         i += entry.value;
/*      */       }
/* 3682 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void validate() {
/* 3687 */       int i = 0;
/* 3688 */       Array<Research> array = Game.i.researchManager.getInstances();
/* 3689 */       for (byte b = 0; b < array.size; b++) {
/*      */         Research research; int j;
/* 3691 */         if ((research = (Research)array.get(b)).priceInStars != 0 && (
/*      */           
/* 3693 */           j = this.a.get(research.type.ordinal(), 0)) != 0) {
/* 3694 */           i += research.priceInStars;
/*      */         }
/*      */       } 
/*      */       
/* 3698 */       if (i > Game.i.basicLevelManager.getMaxStarsCount()) {
/* 3699 */         throw new IllegalStateException("Installed research exceeds max possible star count " + i + " / " + Game.i.basicLevelManager.getMaxStarsCount());
/*      */       }
/*      */ 
/*      */       
/* 3703 */       ObjectSet<ResearchType> objectSet = new ObjectSet();
/* 3704 */       boolean bool = true;
/* 3705 */       while (bool) {
/* 3706 */         bool = false;
/* 3707 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*      */           Research research;
/* 3709 */           if ((research = ((Research[])array.items)[b1]).priceInStars > 0 && this.a.get(research.type.ordinal(), 0) > 0) {
/* 3710 */             objectSet.clear();
/* 3711 */             if (!ResearchManager.isLinkedToRoot(research, this.a, objectSet))
/*      */             {
/* 3713 */               throw new IllegalStateException("Installed research " + research.type + " is not linked to the root of the tree");
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     public final boolean sameAs(ProgressSnapshotForState param1ProgressSnapshotForState) {
/* 3721 */       if (this.a.size != param1ProgressSnapshotForState.a.size) {
/* 3722 */         return false;
/*      */       }
/* 3724 */       if (this.b.size != param1ProgressSnapshotForState.b.size) {
/* 3725 */         return false;
/*      */       }
/* 3727 */       if (this.c.size != param1ProgressSnapshotForState.c.size) {
/* 3728 */         return false;
/*      */       }
/* 3730 */       if (this.statsPlayTimeCasesLoot != param1ProgressSnapshotForState.statsPlayTimeCasesLoot) {
/* 3731 */         return false;
/*      */       }
/* 3733 */       if (this.statsPlayRealTime != param1ProgressSnapshotForState.statsPlayRealTime) {
/* 3734 */         return false;
/*      */       }
/* 3736 */       if (this.statsQueuedCasesGiven != param1ProgressSnapshotForState.statsQueuedCasesGiven) {
/* 3737 */         return false;
/*      */       }
/*      */       
/* 3740 */       for (IntIntMap.Entry entry : this.a) {
/* 3741 */         if (this.a.get(entry.key, -1) != param1ProgressSnapshotForState.a.get(entry.key, -1)) {
/* 3742 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 3746 */       IntSet.IntSetIterator intSetIterator = this.b.iterator();
/* 3747 */       while (intSetIterator.hasNext) {
/* 3748 */         int i = intSetIterator.next();
/* 3749 */         if (!param1ProgressSnapshotForState.b.contains(i)) {
/* 3750 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 3754 */       ObjectSet.ObjectSetIterator objectSetIterator = this.c.iterator();
/* 3755 */       while (objectSetIterator.hasNext) {
/* 3756 */         if (!param1ProgressSnapshotForState.c.contains(objectSetIterator.next())) {
/* 3757 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 3761 */       return true;
/*      */     }
/*      */     
/*      */     public final int getResearchInstalledLevel(ResearchType param1ResearchType) {
/* 3765 */       return this.a.get(param1ResearchType.ordinal(), 0);
/*      */     }
/*      */     
/*      */     public final boolean isTrophyReceived(TrophyType param1TrophyType) {
/* 3769 */       return this.b.contains(param1TrophyType.ordinal());
/*      */     }
/*      */     
/*      */     public final boolean isQuestEverCompleted(String param1String) {
/* 3773 */       return this.c.contains(param1String);
/*      */     }
/*      */     
/*      */     public final void fromBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 3777 */       this.a.clear();
/* 3778 */       this.b.clear();
/* 3779 */       this.c.clear();
/*      */       
/*      */       FixedInput fixedInput;
/* 3782 */       (fixedInput = new FixedInput(param1ArrayOfbyte, param1Int1, param1Int2)).readByte();
/* 3783 */       param1Int1 = fixedInput.readVarInt(true);
/* 3784 */       for (param1Int2 = 0; param1Int2 < param1Int1; param1Int2++) {
/* 3785 */         int j = fixedInput.readVarInt(true);
/* 3786 */         byte b1 = fixedInput.readByte();
/* 3787 */         this.a.put(j, b1);
/*      */       } 
/* 3789 */       param1Int2 = fixedInput.readVarInt(true); int i;
/* 3790 */       for (i = 0; i < param1Int2; i++) {
/* 3791 */         int j = fixedInput.readVarInt(true);
/* 3792 */         this.b.add(j);
/*      */       } 
/* 3794 */       i = fixedInput.readVarInt(true);
/* 3795 */       for (byte b = 0; b < i; b++) {
/* 3796 */         String str = fixedInput.readString();
/* 3797 */         this.c.add(str);
/*      */       } 
/*      */       
/* 3800 */       this.statsPlayTimeCasesLoot = fixedInput.readVarInt(true);
/* 3801 */       this.statsPlayRealTime = fixedInput.readVarInt(true);
/* 3802 */       this.statsQueuedCasesGiven = fixedInput.readVarInt(true);
/*      */     }
/*      */     
/*      */     public final byte[] toBytes() {
/*      */       FixedOutput fixedOutput;
/* 3807 */       (fixedOutput = new FixedOutput(256, -1)).writeByte(1);
/* 3808 */       fixedOutput.writeVarInt(this.a.size, true);
/* 3809 */       for (IntIntMap.Entry entry : this.a) {
/* 3810 */         fixedOutput.writeVarInt(entry.key, true);
/* 3811 */         fixedOutput.writeByte(entry.value);
/*      */       } 
/* 3813 */       fixedOutput.writeVarInt(this.b.size, true);
/* 3814 */       IntSet.IntSetIterator intSetIterator = this.b.iterator();
/* 3815 */       while (intSetIterator.hasNext) {
/* 3816 */         fixedOutput.writeVarInt(intSetIterator.next(), true);
/*      */       }
/*      */       
/* 3819 */       fixedOutput.writeVarInt(this.c.size, true);
/* 3820 */       ObjectSet.ObjectSetIterator objectSetIterator = this.c.iterator();
/* 3821 */       while (objectSetIterator.hasNext) {
/* 3822 */         fixedOutput.writeString((String)objectSetIterator.next());
/*      */       }
/* 3824 */       fixedOutput.writeVarInt(this.statsPlayTimeCasesLoot, true);
/* 3825 */       fixedOutput.writeVarInt(this.statsPlayRealTime, true);
/* 3826 */       fixedOutput.writeVarInt(this.statsQueuedCasesGiven, true);
/*      */       
/* 3828 */       return fixedOutput.toBytes();
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ProgressManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */