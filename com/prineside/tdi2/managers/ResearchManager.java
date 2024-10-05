/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.PolygonRegion;
/*      */ import com.badlogic.gdx.graphics.g2d.PolygonSprite;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.g3d.Model;
/*      */ import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
/*      */ import com.badlogic.gdx.math.EarClippingTriangulator;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.IntIntMap;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.ShortArray;
/*      */ import com.badlogic.gdx.utils.TimeUtils;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Requirement;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.ResearchCategory;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.enums.AchievementType;
/*      */ import com.prineside.tdi2.enums.BlueprintType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.ResearchCategoryType;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.events.global.GameLoad;
/*      */ import com.prineside.tdi2.items.ResourceItem;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Research;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.JsonHandler;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.IOException;
/*      */ 
/*      */ @REGS(serializer = ResearchManager.Serializer.class)
/*      */ public class ResearchManager extends Manager.ManagerAdapter {
/*   61 */   private static final TLog a = TLog.forClass(ResearchManager.class);
/*      */   public static final int MAP_SIZE = 8192;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<ResearchManager> { public ResearchManager read() {
/*   65 */       return Game.i.researchManager;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   71 */   private final Array<Research> b = new Array(true, ResearchType.values.length, Research.class);
/*   72 */   private final ObjectMap<ResearchCategoryType, ResearchCategory> c = new ObjectMap();
/*   73 */   private final Array<Research.ResearchLink> d = new Array();
/*   74 */   private final Array<PolygonConfig> e = new Array(PolygonConfig.class);
/*      */   
/*      */   private int f;
/*      */   
/*      */   private int g;
/*      */   
/*      */   private int h;
/*      */   private int i;
/*      */   private int j;
/*      */   private int k;
/*      */   private boolean l = false;
/*      */   private float m;
/*      */   private int n;
/*      */   private int o;
/*   88 */   private final StartResearchingException p = new StartResearchingException();
/*   89 */   private final DelayedRemovalArray<ResearchManagerListener> q = new DelayedRemovalArray(false, 1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInstalledLevel(ResearchType paramResearchType) {
/*   96 */     return (ProgressPrefs.i()).research.getInstalledLevel(paramResearchType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVisible(Research paramResearch) {
/*  104 */     if (paramResearch.endlessOnly && !DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode()))
/*      */     {
/*  106 */       return false;
/*      */     }
/*      */     
/*  109 */     if (Config.isModdingMode()) return true;
/*      */     
/*      */     TowerType towerType;
/*  112 */     if ((towerType = paramResearch.getRelatedToTowerType()) == null)
/*      */     {
/*  114 */       return true;
/*      */     }
/*      */     
/*  117 */     if (Game.i.towerManager.getFactory(towerType).isAvailable(Game.i.gameValueManager.getSnapshot()))
/*      */     {
/*  119 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  123 */     if (paramResearch.isUnlocksTower())
/*      */     {
/*  125 */       return (((Research.ResearchLink)paramResearch.linksToParents.first()).parent.getInstalledLevel() > 0);
/*      */     }
/*      */     
/*  128 */     return false;
/*      */   }
/*      */   
/*      */   private void b() {
/*  132 */     if (!this.l) {
/*  133 */       throw new IllegalStateException("manager is not set up yet");
/*      */     }
/*      */   }
/*      */   
/*      */   public Research getInstance(ResearchType paramResearchType) {
/*  138 */     b();
/*      */     
/*  140 */     return ((Research[])this.b.items)[paramResearchType.ordinal()];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Research getInstancePreSetup(ResearchType paramResearchType) {
/*  147 */     return ((Research[])this.b.items)[paramResearchType.ordinal()];
/*      */   }
/*      */   
/*      */   public Array<Research> getInstances() {
/*  151 */     b();
/*      */     
/*  153 */     return this.b;
/*      */   }
/*      */   
/*      */   public Array<Research.ResearchLink> getLinks() {
/*  157 */     b();
/*      */     
/*  159 */     return this.d;
/*      */   }
/*      */   
/*      */   public Array<PolygonConfig> getPolygonSprites() {
/*  163 */     b();
/*      */     
/*  165 */     return this.e;
/*      */   }
/*      */   
/*      */   public void resetResearchForAccelerators(Research paramResearch) {
/*      */     int i;
/*  170 */     if ((i = paramResearch.resetForAcceleratorsState()) != 0) {
/*  171 */       a.e("can not be reset now " + paramResearch.type + " state " + i, new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  176 */     if ((i = paramResearch.getResetPrice()) > 0) {
/*  177 */       Array<ItemStack> array = paramResearch.getCumulativePrice(0, paramResearch.getInstalledLevel(), true);
/*  178 */       if (Game.i.progressManager.removeAccelerators(i)) {
/*  179 */         paramResearch.setInstalledLevel(0);
/*  180 */         if ((paramResearch.levels[0]).price.size == 0)
/*      */         {
/*  182 */           paramResearch.setInstalledLevel(1);
/*      */         }
/*      */         
/*  185 */         for (i = 0; i < array.size; i++) {
/*  186 */           if (((ItemStack)array.get(i)).getItem().getType() == ItemType.ACCELERATOR) {
/*  187 */             array.removeIndex(i);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  192 */         (ProgressPrefs.i()).research.resetLevelsInstalledForTokens(paramResearch.type);
/*  193 */         ProgressPrefs.i().requireSave();
/*      */         
/*  195 */         Game.i.progressManager.addItemArray(array, "research_reset_refund");
/*      */         
/*  197 */         a.i("reset " + paramResearch.type + " for accelerators", new Object[0]);
/*      */         
/*  199 */         g();
/*      */       } else {
/*  201 */         Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_accelerators")); return;
/*      */       } 
/*      */     } else {
/*  204 */       a.e("reset price is " + i, new Object[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c() {
/*  209 */     b();
/*      */     
/*  211 */     int i = 0;
/*  212 */     byte b1 = 0;
/*  213 */     int j = 0;
/*  214 */     for (byte b2 = 0; b2 < this.b.size; b2++) {
/*      */       Research research;
/*  216 */       if ((research = ((Research[])this.b.items)[b2]).getInstalledLevel() > 0) {
/*  217 */         i += research.getInstalledLevel();
/*  218 */         b1++;
/*      */         
/*  220 */         if (research.priceInStars == 0) {
/*  221 */           boolean bool = false;
/*      */           
/*  223 */           if (research.type == ResearchType.DECRYPTING_QUEUE_SIZE) {
/*      */             
/*  225 */             bool = true;
/*      */           } else {
/*  227 */             Research.ResearchLevel researchLevel = research.levels[0];
/*  228 */             for (byte b = 0; b < researchLevel.price.size; b++) {
/*      */               ItemStack itemStack;
/*  230 */               if ((itemStack = ((ItemStack[])researchLevel.price.items)[b]).getItem().getType() == ItemType.PRESTIGE_TOKEN) {
/*  231 */                 bool = true;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*  237 */           if (!bool && !research.endlessOnly) {
/*  238 */             j += Math.min(research.getInstalledLevel(), research.levels.length);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  244 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.RC) < b1) {
/*  245 */       Game.i.statisticsManager.registerValue(StatisticsType.RC, b1);
/*      */     }
/*  247 */     if (Game.i.statisticsManager.getAllTime(StatisticsType.RCL) < i) {
/*  248 */       Game.i.statisticsManager.registerValue(StatisticsType.RCL, i);
/*      */     }
/*      */     
/*  251 */     Game.i.achievementManager.setProgress(AchievementType.FIVE_HUNDRED_RESEARCH, b1);
/*  252 */     Game.i.achievementManager.setProgress(AchievementType.FULL_REGULAR_RESEARCH, j);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetUp() {
/*  258 */     return this.l;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setup() {
/*  264 */     if (!Config.isHeadless()) {
/*  265 */       Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*      */           {
/*      */             public void reloaded() {
/*  268 */               this.a.reloadNew();
/*  269 */               this.a.checkResearchesStatus(false);
/*      */             }
/*      */           });
/*      */     }
/*  273 */     reloadNew();
/*      */     
/*  275 */     if (!Config.isHeadless())
/*      */     {
/*  277 */       addListener(new ResearchManagerListener.ResearchManagerListenerAdapter(this)
/*      */           {
/*      */             public void researchCompleted(Research param1Research) {
/*  280 */               Game.i.analyticsManager.logCustomEvent("research_completed", new String[] { "type", param1Research.type.name(), "level", String.valueOf(param1Research.getInstalledLevel()) }, (Object[])new String[0]);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*  286 */     this.l = true;
/*      */     
/*  288 */     if (!Config.isHeadless()) {
/*  289 */       Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> {
/*      */             checkResearchesStatus(false);
/*      */             updateAndValidateStarBranch();
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void installAllResearches() {
/*  298 */     b();
/*      */     
/*  300 */     for (Array.ArrayIterator<Research> arrayIterator = this.b.iterator(); arrayIterator.hasNext();) {
/*  301 */       if (!(research = arrayIterator.next()).endlessOnly && 
/*  302 */         research.getInstalledLevel() < research.levels.length) research.setInstalledLevel(research.levels.length);
/*      */     
/*      */     } 
/*  305 */     g();
/*  306 */     c();
/*      */   }
/*      */   
/*      */   public void installAllEndlessResearches() {
/*  310 */     b();
/*      */     
/*  312 */     for (Array.ArrayIterator<Research> arrayIterator = this.b.iterator(); arrayIterator.hasNext();) {
/*  313 */       if ((research = arrayIterator.next()).getInstalledLevel() < research.maxEndlessLevel) research.setInstalledLevel(research.maxEndlessLevel);
/*      */     
/*      */     } 
/*  316 */     g();
/*  317 */     c();
/*      */   }
/*      */   
/*      */   public void updateAfforableResearchesCount() {
/*  321 */     b();
/*      */     
/*  323 */     this.n = 0;
/*  324 */     for (byte b = 0; b < this.b.size; b++) {
/*  325 */       if (canStartResearching(((Research[])this.b.items)[b], false)) {
/*  326 */         this.n++;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getAfforableResearchesCount() {
/*  332 */     return this.n;
/*      */   }
/*      */   
/*      */   public boolean isLinkedToRoot(Research paramResearch, ObjectSet<ResearchType> paramObjectSet) {
/*  336 */     if (paramResearch.type == ResearchType.ROOT) return true; 
/*  337 */     paramObjectSet.add(paramResearch.type);
/*      */     
/*  339 */     if (paramResearch.getInstalledLevel() == 0) return false; 
/*      */     byte b;
/*  341 */     for (b = 0; b < paramResearch.linksToParents.size; b++) {
/*  342 */       Research research = (((Research.ResearchLink[])paramResearch.linksToParents.items)[b]).parent;
/*  343 */       if (!paramObjectSet.contains(research.type) && 
/*  344 */         isLinkedToRoot(research, paramObjectSet)) {
/*  345 */         return true;
/*      */       }
/*      */     } 
/*      */     
/*  349 */     for (b = 0; b < paramResearch.linksToChildren.size; b++) {
/*  350 */       Research research = (((Research.ResearchLink[])paramResearch.linksToChildren.items)[b]).child;
/*  351 */       if (!paramObjectSet.contains(research.type) && 
/*  352 */         isLinkedToRoot(research, paramObjectSet)) {
/*  353 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  358 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isLinkedToRoot(Research paramResearch, IntIntMap paramIntIntMap, ObjectSet<ResearchType> paramObjectSet) {
/*  362 */     if (paramResearch.type == ResearchType.ROOT) return true; 
/*  363 */     paramObjectSet.add(paramResearch.type);
/*      */     
/*  365 */     if (paramIntIntMap.get(paramResearch.type.ordinal(), 0) == 0) return false; 
/*      */     byte b;
/*  367 */     for (b = 0; b < paramResearch.linksToParents.size; b++) {
/*  368 */       Research research = (((Research.ResearchLink[])paramResearch.linksToParents.items)[b]).parent;
/*  369 */       if (!paramObjectSet.contains(research.type) && 
/*  370 */         isLinkedToRoot(research, paramIntIntMap, paramObjectSet)) {
/*  371 */         return true;
/*      */       }
/*      */     } 
/*      */     
/*  375 */     for (b = 0; b < paramResearch.linksToChildren.size; b++) {
/*  376 */       Research research = (((Research.ResearchLink[])paramResearch.linksToChildren.items)[b]).child;
/*  377 */       if (!paramObjectSet.contains(research.type) && 
/*  378 */         isLinkedToRoot(research, paramIntIntMap, paramObjectSet)) {
/*  379 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  384 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d() {
/*  392 */     boolean bool1 = false;
/*      */     
/*  394 */     ObjectSet<ResearchType> objectSet = new ObjectSet();
/*  395 */     boolean bool2 = true;
/*  396 */     while (bool2) {
/*  397 */       bool2 = false;
/*  398 */       for (byte b = 0; b < this.b.size; b++) {
/*      */         Research research;
/*  400 */         if ((research = ((Research[])this.b.items)[b]).priceInStars > 0 && research.getInstalledLevel() > 0) {
/*  401 */           objectSet.clear();
/*  402 */           if (!isLinkedToRoot(research, objectSet)) {
/*      */             
/*  404 */             a.e("reverting " + research.type + " - not linked to ROOT", new Object[0]);
/*  405 */             research.setInstalledLevel(0);
/*  406 */             bool1 = true;
/*  407 */             bool2 = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  414 */     return bool1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean e() {
/*  422 */     boolean bool = false;
/*      */     
/*  424 */     int i = Game.i.basicLevelManager.getGainedStars();
/*      */     
/*  426 */     int j = 0;
/*      */     
/*  428 */     for (byte b = 0; b < this.b.size; b++) {
/*      */       
/*  430 */       if ((((Research[])this.b.items)[b]).priceInStars > 0 && ((Research[])this.b.items)[b].getInstalledLevel() > 0) {
/*  431 */         j += (((Research[])this.b.items)[b]).priceInStars;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  436 */     this.o = i - j;
/*      */     
/*  438 */     if (this.o < 0) {
/*  439 */       a.i("unused stars count: " + this.o, new Object[0]);
/*      */ 
/*      */       
/*  442 */       Array array = new Array(Research.class);
/*  443 */       for (i = 0; i < this.b.size; i++) {
/*  444 */         if ((((Research[])this.b.items)[i]).priceInStars > 0 && ((Research[])this.b.items)[i].getInstalledLevel() != 0) {
/*  445 */           array.add(((Research[])this.b.items)[i]);
/*      */         }
/*      */       } 
/*      */       
/*  449 */       array.sort((paramResearch1, paramResearch2) -> Float.compare(paramResearch1.distanceToCenter, paramResearch2.distanceToCenter));
/*  450 */       for (i = 0; i < array.size; ) {
/*      */         Research research;
/*  452 */         (research = ((Research[])array.items)[i]).setInstalledLevel(0);
/*  453 */         bool = true;
/*  454 */         a.e("reverting " + research.type.name() + " - exceeds amount of stars", new Object[0]);
/*  455 */         this.o += research.priceInStars;
/*  456 */         if (this.o < 0) {
/*      */           i++;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  462 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAndValidateStarBranch() {
/*  471 */     b();
/*      */     
/*  473 */     boolean bool1 = true;
/*  474 */     boolean bool2 = false;
/*  475 */     while (bool1) {
/*  476 */       bool1 = false;
/*  477 */       if (d()) {
/*  478 */         bool1 = true;
/*      */       }
/*  480 */       if (e()) {
/*  481 */         bool1 = true;
/*      */       }
/*  483 */       if (bool1) {
/*  484 */         bool2 = true;
/*      */       }
/*      */     } 
/*      */     
/*  488 */     if (bool2) {
/*  489 */       g();
/*  490 */       c();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void installRecursiveFree(int paramInt) {
/*  495 */     b();
/*      */     
/*  497 */     Game.i.statisticsManager.registerDelta(StatisticsType.TDD, 1.0E8D); TowerType[] arrayOfTowerType; int i; byte b;
/*  498 */     for (i = (arrayOfTowerType = TowerType.values).length, b = 0; b < i; ) { TowerType towerType = arrayOfTowerType[b];
/*  499 */       Game.i.statisticsManager.registerDelta(Game.i.towerManager.getDamageDealtStatisticType(towerType), 1.0E8D);
/*      */       b++; }
/*      */     
/*  502 */     int[] arrayOfInt1 = { 0 };
/*  503 */     int[] arrayOfInt2 = { 0, 0, 0, 0, 0 };
/*  504 */     a(getInstance(ResearchType.ROOT), paramInt, arrayOfInt1, arrayOfInt2);
/*      */     
/*  506 */     g();
/*  507 */     c();
/*      */   }
/*      */   
/*      */   private void a(Research paramResearch, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  511 */     if (paramResearch.priceInStars > 0)
/*  512 */       return;  if (paramResearch.type == ResearchType.PRESTIGE)
/*      */       return; 
/*  514 */     for (Array.ArrayIterator<Research.ResearchLink> arrayIterator = paramResearch.linksToChildren.iterator(); arrayIterator.hasNext(); ) {
/*      */       Research.ResearchLink researchLink; Research research; Research.ResearchLevel[] arrayOfResearchLevel; int i; byte b;
/*  516 */       for (i = (arrayOfResearchLevel = (research = (researchLink = arrayIterator.next()).child).levels).length, b = 0; b < i; ) { Research.ResearchLevel researchLevel = arrayOfResearchLevel[b];
/*  517 */         boolean bool = true; byte b1;
/*  518 */         for (b1 = 0; b1 < researchLevel.price.size; b1++) {
/*      */           ItemStack itemStack;
/*  520 */           if ((itemStack = ((ItemStack[])researchLevel.price.items)[b1]).getItem().getType() == ItemType.RESOURCE && ((ResourceItem)itemStack.getItem()).resourceType.ordinal() > paramInt) {
/*      */             
/*  522 */             bool = false;
/*      */             break;
/*      */           } 
/*      */         } 
/*  526 */         if (bool && 
/*  527 */           Game.i.researchManager.canStartResearching(research, true)) {
/*  528 */           for (b1 = 0; b1 < researchLevel.price.size; b1++) {
/*      */             ItemStack itemStack;
/*  530 */             if ((itemStack = ((ItemStack[])researchLevel.price.items)[b1]).getItem().getType() == ItemType.GREEN_PAPER) {
/*  531 */               paramArrayOfint1[0] = paramArrayOfint1[0] + itemStack.getCount();
/*  532 */             } else if (itemStack.getItem().getType() == ItemType.RESOURCE) {
/*  533 */               ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/*  534 */               paramArrayOfint2[resourceItem.resourceType.ordinal()] = paramArrayOfint2[resourceItem.resourceType.ordinal()] + itemStack.getCount();
/*      */             } 
/*      */           } 
/*      */           
/*  538 */           research.setInstalledLevel(researchLevel.number);
/*      */         } 
/*      */         
/*      */         b++; }
/*      */       
/*  543 */       a(research, paramInt, paramArrayOfint1, paramArrayOfint2);
/*      */     } 
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
/*      */   public int getLoadedConfigHash() {
/*  557 */     int i = (i = (i = (i = (i = (i = 31 + this.f) * 31 + this.g) * 31 + this.h) * 31 + this.i) * 31 + this.j) * 31 + this.k;
/*      */     byte b1;
/*  559 */     for (b1 = 0; b1 < this.d.size; b1++) {
/*  560 */       Research.ResearchLink researchLink = (Research.ResearchLink)this.d.get(b1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  568 */       i = (i = (i = (i = (i = (i = (i = (i = i * 31 + researchLink.pivotX) * 31 + researchLink.pivotY) * 31 + researchLink.parent.type.ordinal()) * 31 + researchLink.child.type.ordinal()) * 31 + researchLink.requiredLevels) * 31 + researchLink.requiredLevelsLabelX) * 31 + researchLink.requiredLevelsLabelY) * 31 + (int)(researchLink.requiredLevelsLabelPos * 100.0F);
/*      */     } 
/*  570 */     for (b1 = 0; b1 < this.b.size; b1++) {
/*  571 */       Research research = (Research)this.b.get(b1);
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
/*  585 */       i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = i * 31 + research.type.ordinal()) * 31 + research.category.alias.ordinal()) * 31 + research.priceInStars) * 31 + research.x) * 31 + research.y) * 31 + research.maxEndlessLevel) * 31 + research.endlessPriceLevel) * 31 + (int)research.distanceToCenter) * 31 + (research.cantBeIgnoredOnUserMaps ? 1 : 0)) * 31 + (research.unlocksTower ? 1 : 0)) * 31 + (int)(research.endlessPriceExp * 100.0F)) * 31 + (research.endlessOnly ? 1 : 0)) * 31 + (research.small ? 1 : 0)) * 31 + ((research.relatedToTowerType == null) ? -1 : research.relatedToTowerType.ordinal());
/*      */       byte b3;
/*  587 */       for (b3 = 0; b3 < research.linksToChildren.size; b3++) {
/*  588 */         Research.ResearchLink researchLink = (Research.ResearchLink)research.linksToChildren.get(b3);
/*      */         
/*  590 */         i = (i = i * 31 + researchLink.parent.type.ordinal()) * 31 + researchLink.child.type.ordinal();
/*      */       } 
/*  592 */       for (b3 = 0; b3 < research.linksToParents.size; b3++) {
/*  593 */         Research.ResearchLink researchLink = (Research.ResearchLink)research.linksToParents.get(b3);
/*      */         
/*  595 */         i = (i = i * 31 + researchLink.parent.type.ordinal()) * 31 + researchLink.child.type.ordinal();
/*      */       } 
/*  597 */       if (research.endlessLevel != null)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  602 */         i = (i = (i = (i = (i = i * 31 + research.endlessLevel.prestigeTokens) * 31 + research.endlessLevel.priceBase) * 31 + research.endlessLevel.randomSeed) * 31 + research.endlessLevel.effects.length) * 31 + ((research.endlessLevel.blueprintType == null) ? -1 : research.endlessLevel.blueprintType.ordinal()); }  Research.ResearchLevel[] arrayOfResearchLevel; int k;
/*      */       byte b4;
/*  604 */       for (k = (arrayOfResearchLevel = research.levels).length, b4 = 0; b4 < k; ) { Research.ResearchLevel researchLevel = arrayOfResearchLevel[b4];
/*      */         
/*  606 */         i = (i = i * 31 + researchLevel.number) * 31 + researchLevel.researchDuration; GameValueManager.GameValueEffect[] arrayOfGameValueEffect; int m; byte b;
/*  607 */         for (m = (arrayOfGameValueEffect = researchLevel.effects).length, b = 0; b < m; ) { GameValueManager.GameValueEffect gameValueEffect = arrayOfGameValueEffect[b];
/*      */           
/*  609 */           i = (i = i * 31 + gameValueEffect.type.ordinal()) * 31 + (int)(gameValueEffect.delta * 100.0D); b++; }
/*      */          Requirement[] arrayOfRequirement;
/*  611 */         for (m = (arrayOfRequirement = researchLevel.requirements).length, b = 0; b < m; ) { Requirement requirement = arrayOfRequirement[b];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  621 */           i = (i = (i = (i = (i = (i = (i = (i = (i = (i = i * 31 + requirement.type.ordinal()) * 31 + requirement.researchLevel) * 31 + ((requirement.researchType == null) ? -1 : requirement.researchType.ordinal())) * 31 + ((requirement.statisticsType == null) ? -1 : requirement.statisticsType.ordinal())) * 31 + requirement.levelStars) * 31 + requirement.stageStars) * 31 + (int)(requirement.statisticsValue * 100.0D)) * 31 + ((requirement.levelName == null) ? -1 : requirement.levelName.length())) * 31 + ((requirement.stageName == null) ? -1 : requirement.stageName.length())) * 31 + ((requirement.openedLevelName == null) ? -1 : requirement.openedLevelName.length()); b++; }
/*      */          b4++; }
/*      */     
/*      */     }  ResearchCategoryType[] arrayOfResearchCategoryType;
/*      */     int j;
/*      */     byte b2;
/*  627 */     for (j = (arrayOfResearchCategoryType = ResearchCategoryType.values).length, b2 = 0; b2 < j; ) { ResearchCategoryType researchCategoryType = arrayOfResearchCategoryType[b2];
/*  628 */       ResearchCategory researchCategory = (ResearchCategory)this.c.get(researchCategoryType);
/*      */ 
/*      */ 
/*      */       
/*  632 */       i = (i = (i = (i = i * 31 + researchCategory.alias.ordinal()) * 31 + researchCategory.titleAlias.length()) * 31 + researchCategory.descriptionAlias.length()) * 31 + researchCategory.getIconString().length();
/*      */       b2++; }
/*      */     
/*  635 */     return i;
/*      */   }
/*      */   
/*      */   public void reloadNew() {
/*  639 */     this.d.clear();
/*  640 */     this.b.clear();
/*  641 */     this.c.clear();
/*  642 */     this.e.clear();
/*      */     
/*  644 */     this.b.setSize(ResearchType.values.length);
/*      */     
/*  646 */     this.f = Integer.MAX_VALUE;
/*  647 */     this.g = Integer.MIN_VALUE;
/*  648 */     this.h = Integer.MAX_VALUE;
/*  649 */     this.i = Integer.MIN_VALUE;
/*      */     
/*      */     try {
/*      */       l l;
/*  653 */       (l = JsonHandler.i().getMapper().a(Gdx.files.internal("res/researches.json").reader())).g();
/*  654 */       while (l.g() != o.c) {
/*      */         PolygonConfig polygonConfig; String str;
/*  656 */         switch (str = l.u()) {
/*      */           case "categories":
/*  658 */             l.g();
/*  659 */             while (l.g() != o.e) {
/*  660 */               ResearchCategory researchCategory = ResearchCategory.fromJson(l);
/*  661 */               this.c.put(researchCategory.alias, researchCategory);
/*      */             } 
/*      */             continue;
/*      */           
/*      */           case "researches":
/*  666 */             l.g();
/*  667 */             while (l.g() != o.e) {
/*  668 */               Research research = Research.fromJson(l);
/*  669 */               if (((Research[])this.b.items)[research.type.ordinal()] != null) {
/*  670 */                 throw new IllegalArgumentException("Research of type " + research.type + " defined multiple times");
/*      */               }
/*  672 */               this.b.set(research.type.ordinal(), research);
/*      */               
/*  674 */               if (research.x < this.f) this.f = research.x; 
/*  675 */               if (research.x > this.g) this.g = research.x; 
/*  676 */               if (research.y < this.h) this.h = research.y; 
/*  677 */               if (research.y > this.i) this.i = research.y;
/*      */             
/*      */             } 
/*      */             continue;
/*      */           case "links":
/*  682 */             l.g();
/*  683 */             while (l.g() != o.e) {
/*      */               Research.ResearchLink researchLink;
/*  685 */               (researchLink = Research.ResearchLink.fromJson(l)).child.linksToParents.add(researchLink);
/*  686 */               researchLink.parent.linksToChildren.add(researchLink);
/*  687 */               this.d.add(researchLink);
/*      */             } 
/*      */             continue;
/*      */           
/*      */           case "polygons":
/*  692 */             if (!Config.isHeadless()) {
/*  693 */               l.g();
/*  694 */               while (l.g() != o.e) {
/*      */                 
/*  696 */                 if ((polygonConfig = PolygonConfig.fromJson(l)) != null) {
/*  697 */                   this.e.add(polygonConfig);
/*      */                 }
/*      */               } 
/*      */               continue;
/*      */             } 
/*  702 */             l.g();
/*  703 */             l.j();
/*      */             continue;
/*      */         } 
/*      */ 
/*      */         
/*  708 */         a.e("not implemented, skipping: " + polygonConfig, new Object[0]);
/*  709 */         l.g();
/*  710 */         l.j();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  715 */       l.close();
/*      */       
/*  717 */       this.j = this.g - this.f;
/*  718 */       this.k = this.i - this.h;
/*      */       
/*  720 */       if (this.l && !Config.isHeadless()) {
/*  721 */         g();
/*  722 */         c();
/*  723 */         updateAndValidateStarBranch();
/*      */       }  return;
/*  725 */     } catch (IOException iOException) {
/*  726 */       throw new RuntimeException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public ResearchCategory getCategory(ResearchCategoryType paramResearchCategoryType) {
/*  731 */     return (ResearchCategory)this.c.get(paramResearchCategoryType);
/*      */   }
/*      */   
/*      */   public void reload() {
/*  735 */     this.d.clear();
/*  736 */     this.b.clear();
/*  737 */     this.c.clear();
/*  738 */     this.e.clear();
/*      */     
/*  740 */     this.f = Integer.MAX_VALUE;
/*  741 */     this.g = Integer.MIN_VALUE;
/*  742 */     this.h = Integer.MAX_VALUE;
/*  743 */     this.i = Integer.MIN_VALUE;
/*      */ 
/*      */     
/*      */     JsonValue jsonValue;
/*      */     
/*  748 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/researches.json"))).get("categories").iterator(); jsonIterator1.hasNext(); ) {
/*  749 */       JsonValue jsonValue1; String str1 = (jsonValue1 = jsonIterator1.next()).getString("alias");
/*  750 */       String str2 = "research_title_" + str1;
/*  751 */       String str3 = "research_description_" + str1;
/*  752 */       ResearchCategoryType researchCategoryType = ResearchCategoryType.valueOf(str1);
/*      */       
/*  754 */       String str4 = jsonValue1.getString("icon");
/*  755 */       this.c.put(researchCategoryType, new ResearchCategory(researchCategoryType, str2, str3, str4));
/*      */     } 
/*      */ 
/*      */     
/*  759 */     this.b.setSize(ResearchType.values.length);
/*  760 */     byte b = 0; JsonValue.JsonIterator<JsonValue> jsonIterator2;
/*  761 */     for (jsonIterator2 = jsonValue.get("researches").iterator(); jsonIterator2.hasNext(); ) {
/*  762 */       JsonValue jsonValue1; ResearchType researchType = ResearchType.valueOf((jsonValue1 = jsonIterator2.next()).getString("name"));
/*      */       
/*  764 */       if (!jsonValue1.has("category")) {
/*  765 */         throw new IllegalStateException("Research " + researchType.name() + " has no category");
/*      */       }
/*  767 */       ResearchCategory researchCategory = (ResearchCategory)this.c.get(ResearchCategoryType.valueOf(jsonValue1.getString("category")));
/*  768 */       int i = jsonValue1.getInt("maxEndlessModeLevels");
/*      */       
/*  770 */       if (((Research[])this.b.items)[researchType.ordinal()] != null) {
/*  771 */         throw new RuntimeException("Research " + researchType.name() + " already exists");
/*      */       }
/*      */       
/*  774 */       Array array = new Array(Research.ResearchLevel.class);
/*  775 */       byte b1 = 1;
/*  776 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.get("levels").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue2 = jsonIterator.next();
/*      */         
/*  778 */         Array array1 = new Array(GameValueManager.GameValueEffect.class);
/*  779 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator3 = jsonValue2.get("effects").iterator(); jsonIterator3.hasNext(); ) { JsonValue jsonValue4 = jsonIterator3.next();
/*      */           try {
/*  781 */             GameValueType gameValueType = GameValueType.valueOf(jsonValue4.name);
/*  782 */             array1.add(new GameValueManager.GameValueEffect(gameValueType, jsonValue4.asDouble()));
/*  783 */           } catch (Exception exception) {
/*  784 */             a.e("failed loading gv " + jsonValue4.name + " for " + researchType.name() + " in research " + researchType.name(), new Object[] { exception });
/*      */           }  }
/*      */ 
/*      */ 
/*      */         
/*  789 */         int k = jsonValue2.getInt("researchDuration", 0);
/*      */ 
/*      */         
/*  792 */         Array array2 = new Array(Requirement.class);
/*      */         JsonValue jsonValue3;
/*  794 */         if ((jsonValue3 = jsonValue2.get("requirements")) != null) {
/*  795 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator4 = jsonValue3.iterator(); jsonIterator4.hasNext(); ) { JsonValue jsonValue4 = jsonIterator4.next();
/*  796 */             array2.add(Requirement.fromJson(jsonValue4)); }
/*      */         
/*      */         }
/*      */         
/*      */         try {
/*      */           Research.ResearchLevel researchLevel;
/*      */           
/*  803 */           (researchLevel = new Research.ResearchLevel()).number = b1;
/*  804 */           researchLevel.researchDuration = k;
/*  805 */           researchLevel.effects = (GameValueManager.GameValueEffect[])array1.toArray();
/*      */           
/*  807 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator4 = jsonValue2.get("price").iterator(); jsonIterator4.hasNext(); ) {
/*  808 */             JsonValue jsonValue4; if ((jsonValue4 = jsonIterator4.next()).name.equals("money")) {
/*      */               
/*  810 */               researchLevel.price.add(new ItemStack((Item)Item.D.GREEN_PAPER, jsonValue4.asInt())); continue;
/*  811 */             }  if (jsonValue4.name.startsWith("bp_")) {
/*      */               
/*  813 */               BlueprintType blueprintType = BlueprintType.valueOf(jsonValue4.name.substring(3));
/*  814 */               researchLevel.price.add(new ItemStack((Item)Item.D.F_BLUEPRINT.create(blueprintType), jsonValue4.asInt())); continue;
/*  815 */             }  if (jsonValue4.name.equals("PRESTIGE_TOKEN")) {
/*      */               
/*  817 */               researchLevel.price.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, jsonValue4.asInt())); continue;
/*  818 */             }  if (jsonValue4.name.equals("ACCELERATOR")) {
/*  819 */               researchLevel.price.add(new ItemStack((Item)Item.D.ACCELERATOR, jsonValue4.asInt()));
/*      */               continue;
/*      */             } 
/*  822 */             researchLevel.price.add(new ItemStack((Item)Item.D.F_RESOURCE.create(ResourceType.valueOf(jsonValue4.name)), jsonValue4.asInt()));
/*      */           } 
/*      */ 
/*      */           
/*  826 */           researchLevel.requirements = (Requirement[])array2.toArray();
/*      */           
/*  828 */           array.add(researchLevel);
/*  829 */         } catch (Exception exception) {
/*  830 */           throw new RuntimeException("Failed to add research level for " + researchType.name(), exception);
/*      */         } 
/*      */         
/*  833 */         b1++; }
/*      */       
/*      */       Research research;
/*  836 */       (research = new Research(researchType, researchCategory, (Research.ResearchLevel[])array.toArray(), i)).endlessOnly = jsonValue1.getBoolean("endlessOnly", false);
/*  837 */       research.endlessPriceExp = jsonValue1.getFloat("epe", 1.0F);
/*      */       int j;
/*  839 */       if ((j = jsonValue1.getInt("epl", -1)) != -1) {
/*  840 */         if (j > research.maxEndlessLevel) {
/*  841 */           a.e("endless mode price level is " + j + " while max is " + research.maxEndlessLevel + " for " + researchType.name(), new Object[0]);
/*  842 */           j = research.maxEndlessLevel;
/*      */         } 
/*  844 */         research.endlessPriceLevel = j;
/*      */       } 
/*  846 */       research.x = jsonValue1.getInt("x");
/*  847 */       research.y = jsonValue1.getInt("y");
/*      */ 
/*      */ 
/*      */       
/*  851 */       research.cantBeIgnoredOnUserMaps = jsonValue1.getBoolean("cantBeIgnoredOnUserMaps", false);
/*  852 */       research.small = jsonValue1.getBoolean("small", false);
/*  853 */       research.priceInStars = jsonValue1.getInt("starsPrice", 0);
/*  854 */       this.b.set(research.type.ordinal(), research);
/*      */       
/*  856 */       if (research.x < this.f) this.f = research.x; 
/*  857 */       if (research.x > this.g) this.g = research.x; 
/*  858 */       if (research.y < this.h) this.h = research.y; 
/*  859 */       if (research.y > this.i) this.i = research.y;
/*      */       
/*  861 */       research.distanceToCenter = 1.0F - PMath.getDistanceBetweenPoints(research.x, research.y, 4096.0F, 4096.0F) / 8192.0F * 1.4142F;
/*  862 */       b++;
/*      */     } 
/*      */     
/*  865 */     if (b != ResearchType.values.length) {
/*  866 */       throw new RuntimeException("Number of upgrade types (" + ResearchType.values.length + ") doesn't match the number in JSON file (" + b + ")");
/*      */     }
/*      */ 
/*      */     
/*  870 */     for (jsonIterator2 = jsonValue.get("links").iterator(); jsonIterator2.hasNext(); ) { JsonValue jsonValue1 = jsonIterator2.next();
/*  871 */       Research research1 = ((Research[])this.b.items)[ResearchType.valueOf(jsonValue1.getString("parent")).ordinal()];
/*  872 */       Research research2 = ((Research[])this.b.items)[ResearchType.valueOf(jsonValue1.getString("child")).ordinal()];
/*  873 */       Research.ResearchLink researchLink = new Research.ResearchLink(research1, research2, jsonValue1.getInt("requiredLevels"), jsonValue1.getInt("pivotX"), jsonValue1.getInt("pivotY"), jsonValue1.getFloat("requiredLevelsLabelPos"));
/*  874 */       research1.linksToChildren.add(researchLink);
/*  875 */       research2.linksToParents.add(researchLink);
/*  876 */       this.d.add(researchLink); }
/*      */ 
/*      */ 
/*      */     
/*  880 */     if (!Config.isHeadless() && 
/*  881 */       jsonValue.has("polygons")) {
/*  882 */       ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getBlankWhiteTextureRegion();
/*  883 */       EarClippingTriangulator earClippingTriangulator = new EarClippingTriangulator();
/*  884 */       Color color = new Color();
/*      */       
/*  886 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.get("polygons").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*      */         try {
/*  888 */           String str1 = jsonValue1.getString("color");
/*  889 */           String str2 = jsonValue1.getString("visibleWith", "");
/*  890 */           JsonValue jsonValue2 = jsonValue1.get("points");
/*      */           
/*  892 */           FloatArray floatArray = new FloatArray();
/*  893 */           int i = Integer.MAX_VALUE;
/*  894 */           int j = Integer.MAX_VALUE;
/*  895 */           int k = Integer.MIN_VALUE;
/*  896 */           int m = Integer.MIN_VALUE;
/*  897 */           int n = atlasTextureRegion.getRegionHeight();
/*      */           
/*  899 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator3 = jsonValue2.iterator(); jsonIterator3.hasNext(); ) {
/*  900 */             JsonValue jsonValue3; int i2 = (jsonValue3 = jsonIterator3.next()).getInt(0);
/*  901 */             int i1 = jsonValue3.getInt(1);
/*  902 */             if (i2 < i) i = i2; 
/*  903 */             if (i2 > k) k = i2; 
/*  904 */             if (i1 < j) j = i1; 
/*  905 */             if (i1 > m) m = i1; 
/*  906 */             floatArray.add(i2, i1);
/*      */           } 
/*  908 */           float f1 = (k - i);
/*  909 */           float f2 = (m - j);
/*  910 */           for (byte b1 = 0; b1 < floatArray.size; b1 += 2) {
/*  911 */             floatArray.items[b1] = (floatArray.items[b1] - i) / f1 * n;
/*  912 */             floatArray.items[b1 + 1] = (floatArray.items[b1 + 1] - j) / f2 * n;
/*      */           } 
/*  914 */           ShortArray shortArray = earClippingTriangulator.computeTriangles(floatArray);
/*      */           
/*  916 */           PolygonRegion polygonRegion = new PolygonRegion((TextureRegion)atlasTextureRegion, floatArray.toArray(), shortArray.toArray());
/*      */           PolygonSprite polygonSprite;
/*  918 */           (polygonSprite = new PolygonSprite(polygonRegion)).setBounds((i - this.f), (j - this.h), (k - i), (m - j));
/*      */           
/*  920 */           Color.rgba8888ToColor(color, PMath.parseUnsignedInt(str1.substring(1), 16));
/*  921 */           polygonSprite.setColor(color);
/*      */           
/*      */           PolygonConfig polygonConfig;
/*  924 */           (polygonConfig = new PolygonConfig()).sprite = polygonSprite;
/*  925 */           if (str2.length() > 0) polygonConfig.visibleWith = ((Research[])this.b.items)[ResearchType.valueOf(str2).ordinal()];
/*      */           
/*  927 */           this.e.add(polygonConfig);
/*  928 */         } catch (Exception exception) {
/*  929 */           a.e("failed to load polygon for researches", new Object[] { exception });
/*      */         }  }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  935 */     this.j = this.g - this.f;
/*  936 */     this.k = this.i - this.h;
/*      */     
/*  938 */     if (this.l && !Config.isHeadless()) {
/*  939 */       g();
/*  940 */       c();
/*  941 */       updateAndValidateStarBranch();
/*      */     } 
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
/*      */   public Model create3dGraphModel() {
/*  962 */     b();
/*      */     
/*      */     ModelBuilder modelBuilder;
/*  965 */     (modelBuilder = new ModelBuilder()).begin();
/*      */ 
/*      */ 
/*      */     
/*  969 */     return modelBuilder.end();
/*      */   }
/*      */   
/*      */   public boolean hasInstalledParents(Research paramResearch) {
/*  973 */     b();
/*      */ 
/*      */     
/*  976 */     if (paramResearch.linksToParents.size == 0)
/*      */     {
/*  978 */       return true;
/*      */     }
/*      */     Array.ArrayIterator<Research.ResearchLink> arrayIterator;
/*  981 */     for (arrayIterator = paramResearch.linksToParents.iterator(); arrayIterator.hasNext();) {
/*  982 */       if ((researchLink = arrayIterator.next()).parent.getInstalledLevel() != 0) {
/*  983 */         return true;
/*      */       }
/*      */     } 
/*      */     
/*  987 */     if (paramResearch.priceInStars > 0)
/*      */     {
/*  989 */       for (arrayIterator = paramResearch.linksToChildren.iterator(); arrayIterator.hasNext();) {
/*  990 */         if ((researchLink = arrayIterator.next()).child.getInstalledLevel() != 0) {
/*  991 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  997 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkResearchesStatus(boolean paramBoolean) {
/* 1006 */     b();
/*      */     
/* 1008 */     for (byte b = 0; b < this.b.size; b++) {
/*      */       Research research;
/*      */       
/* 1011 */       if ((research = ((Research[])this.b.items)[b]).priceInStars <= 0) {
/*      */         int i;
/* 1013 */         label26: for (i = research.getInstalledLevel(); i < research.levels.length; i++) {
/*      */           Research.ResearchLevel researchLevel;
/*      */           
/* 1016 */           if ((researchLevel = research.levels[i]).price.size == 0) {
/*      */             Requirement[] arrayOfRequirement; int j;
/*      */             byte b1;
/* 1019 */             for (j = (arrayOfRequirement = researchLevel.requirements).length, b1 = 0; b1 < j; ) {
/* 1020 */               Requirement requirement; if ((requirement = arrayOfRequirement[b1]).isSatisfied()) {
/*      */                 b1++;
/*      */                 continue;
/*      */               } 
/*      */               continue label26;
/*      */             } 
/* 1026 */             if (hasInstalledParents(research)) {
/*      */ 
/*      */               
/* 1029 */               setInstalledLevel(research.type, i + 1, true);
/*      */ 
/*      */               
/* 1032 */               if (paramBoolean)
/* 1033 */                 a(research); 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   } private void a(Research paramResearch) {
/* 1040 */     if (Game.i.uiManager != null && this.l) Notifications.i().add(Game.i.localeManager.i18n.get("research_completed") + ": " + paramResearch.getTitle(), (Drawable)Game.i.assetManager.getDrawable("icon-research"), null, StaticSoundType.RESEARCH);
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public void preRender(float paramFloat) {
/* 1046 */     if (this.l) {
/* 1047 */       this.m += paramFloat;
/* 1048 */       if (this.m > 1.0F) {
/* 1049 */         f();
/* 1050 */         this.m = 0.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void f() {
/* 1060 */     b();
/*      */     
/*      */     PP_Research pP_Research;
/* 1063 */     if ((pP_Research = (ProgressPrefs.i()).research).getCurrentlyResearching() != null) {
/*      */       
/* 1065 */       if (getInstance(pP_Research.getCurrentlyResearching()).isMaxEndlessLevel()) {
/*      */         
/* 1067 */         a.e("current research can't have higher level, aborting", new Object[0]);
/* 1068 */         pP_Research.setCurrentlyResearching(null);
/* 1069 */         ProgressPrefs.i().requireSave();
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1074 */       if (pP_Research.getCurrentResearchEndTime() <= TimeUtils.millis()) {
/*      */         
/* 1076 */         setInstalledLevel(pP_Research.getCurrentlyResearching(), getInstance(pP_Research.getCurrentlyResearching()).getInstalledLevel() + 1, true);
/* 1077 */         a(getInstance(pP_Research.getCurrentlyResearching()));
/*      */         
/* 1079 */         pP_Research.setCurrentlyResearching(null);
/* 1080 */         ProgressPrefs.i().requireSave();
/*      */ 
/*      */         
/* 1083 */         checkResearchesStatus(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Research getCurrentResearching() {
/* 1092 */     b();
/*      */     
/*      */     PP_Research pP_Research;
/* 1095 */     if ((pP_Research = (ProgressPrefs.i()).research).getCurrentlyResearching() != null && pP_Research.getCurrentResearchEndTime() > TimeUtils.millis()) return getInstance(pP_Research.getCurrentlyResearching());  return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void finishCurrentResearch() {
/* 1102 */     b();
/*      */     
/* 1104 */     if (getCurrentResearching() != null) {
/* 1105 */       (ProgressPrefs.i()).research.setCurrentResearchEndTime(TimeUtils.millis() - 1L);
/* 1106 */       ProgressPrefs.i().requireSave();
/* 1107 */       f();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getMillisToResearchingEnd() {
/* 1115 */     b();
/*      */     
/* 1117 */     if ((ProgressPrefs.i()).research.getCurrentlyResearching() == null) return 0L;
/*      */     
/*      */     long l;
/* 1120 */     if ((l = (ProgressPrefs.i()).research.getCurrentResearchEndTime() - TimeUtils.millis()) < 0L) return 0L;
/*      */     
/* 1122 */     return l;
/*      */   }
/*      */   
/*      */   public boolean canResearchForToken(Research paramResearch, boolean paramBoolean) {
/* 1126 */     if (paramResearch.priceInStars > 0)
/*      */     {
/* 1128 */       return false;
/*      */     }
/*      */     
/* 1131 */     if (!paramBoolean && 
/* 1132 */       !canStartResearching(paramResearch, true))
/*      */     {
/* 1134 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1138 */     for (paramBoolean = false; paramBoolean < paramResearch.levels.length; paramBoolean++) {
/* 1139 */       Research.ResearchLevel researchLevel = paramResearch.levels[paramBoolean];
/* 1140 */       for (byte b = 0; b < researchLevel.price.size; b++) {
/*      */         ItemType itemType;
/* 1142 */         if ((itemType = ((ItemStack[])researchLevel.price.items)[b].getItem().getType()) == ItemType.PRESTIGE_TOKEN || itemType == ItemType.ACCELERATOR)
/*      */         {
/* 1144 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1149 */     if (paramResearch.type == ResearchType.DECRYPTING_QUEUE_SIZE)
/*      */     {
/* 1151 */       return false;
/*      */     }
/*      */     
/* 1154 */     if (paramResearch.type == ResearchType.DEVELOPER_MODE) {
/* 1155 */       return false;
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
/* 1168 */     return true;
/*      */   }
/*      */   
/*      */   public boolean researchForToken(Research paramResearch) {
/* 1172 */     if (!canResearchForToken(paramResearch, false)) return false;
/*      */     
/* 1174 */     if (Game.i.progressManager.removeItems((Item)Item.D.RESEARCH_TOKEN, 1)) {
/* 1175 */       Game.i.analyticsManager.logCurrencySpent("research_" + paramResearch.type, "research_token", 1);
/* 1176 */       this.q.begin();
/* 1177 */       for (byte b = 0; b < this.q.size; b++) {
/* 1178 */         ((ResearchManagerListener)this.q.get(b)).researchStarted(paramResearch, 0L);
/*      */       }
/* 1180 */       this.q.end();
/*      */       
/* 1182 */       setInstalledLevel(paramResearch.type, paramResearch.getInstalledLevel() + 1, true);
/* 1183 */       (ProgressPrefs.i()).research.addLevelInstalledForTokens(paramResearch.type, paramResearch.getInstalledLevel());
/*      */       
/* 1185 */       a(paramResearch);
/*      */       
/* 1187 */       (ProgressPrefs.i()).research.setCurrentlyResearching(null);
/* 1188 */       ProgressPrefs.i().requireSave();
/*      */ 
/*      */       
/* 1191 */       checkResearchesStatus(true);
/*      */       
/* 1193 */       return true;
/*      */     } 
/* 1195 */     return false;
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
/*      */   public boolean startResearching(Research paramResearch, boolean paramBoolean) {
/* 1207 */     b();
/*      */     
/*      */     try {
/* 1210 */       tryStartResearching(paramResearch, false, null);
/* 1211 */     } catch (StartResearchingException startResearchingException) {
/* 1212 */       a.e("unable to start researching " + paramResearch.type.name(), new Object[] { startResearchingException });
/* 1213 */       for (byte b = 0; b < startResearchingException.reasons.size; b++) {
/* 1214 */         a.e("reason: " + startResearchingException.reasons.get(b), new Object[0]);
/*      */       }
/*      */       
/* 1217 */       throw startResearchingException;
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
/* 1228 */     if (paramBoolean) {
/*      */       Array array;
/*      */       
/* 1231 */       if (paramResearch.getInstalledLevel() < paramResearch.levels.length) {
/* 1232 */         array = (paramResearch.levels[paramResearch.getInstalledLevel()]).price;
/*      */       } else {
/* 1234 */         if (paramResearch.endlessLevel == null) {
/* 1235 */           throw new IllegalArgumentException("research.endlessLevel is null");
/*      */         }
/* 1237 */         array = paramResearch.endlessLevel.getPrice(paramResearch.getInstalledLevel() + 1);
/*      */       } 
/*      */       
/* 1240 */       for (byte b = 0; b < array.size; b++) {
/* 1241 */         ItemStack itemStack = ((ItemStack[])array.items)[b];
/* 1242 */         Game.i.progressManager.removeItems(itemStack.getItem(), itemStack.getCount());
/*      */       } 
/*      */     } 
/*      */     
/* 1246 */     (ProgressPrefs.i()).research.setCurrentlyResearching(paramResearch.type);
/* 1247 */     long l = getResearchingDuration(paramResearch);
/* 1248 */     (ProgressPrefs.i()).research.setCurrentResearchEndTime(TimeUtils.millis() + l);
/* 1249 */     ProgressPrefs.i().requireSave();
/*      */ 
/*      */     
/* 1252 */     this.q.begin();
/* 1253 */     for (paramBoolean = false; paramBoolean < this.q.size; paramBoolean++) {
/* 1254 */       ((ResearchManagerListener)this.q.get(paramBoolean)).researchStarted(paramResearch, l);
/*      */     }
/* 1256 */     this.q.end();
/*      */     
/* 1258 */     f();
/*      */     
/* 1260 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void tryStartResearching(Research paramResearch, boolean paramBoolean, StartResearchingException paramStartResearchingException) {
/*      */     boolean bool;
/* 1268 */     b();
/*      */     
/* 1270 */     if (paramStartResearchingException == null) paramStartResearchingException = new StartResearchingException(); 
/* 1271 */     paramStartResearchingException.reasons.clear();
/*      */     
/* 1273 */     if (getCurrentResearching() != null) {
/* 1274 */       paramStartResearchingException.reasons.add(StartResearchFailReason.OTHER_RESEARCH_IN_PROGRESS);
/*      */     }
/*      */ 
/*      */     
/* 1278 */     if (Game.i.progressManager.getDifficultyMode() == DifficultyMode.EASY || Game.i.progressManager.getDifficultyMode() == DifficultyMode.NORMAL) {
/*      */       
/* 1280 */       bool = paramResearch.isMaxNormalLevel();
/*      */     } else {
/*      */       
/* 1283 */       bool = paramResearch.isMaxEndlessLevel();
/*      */     } 
/*      */     
/* 1286 */     if (paramResearch.getInstalledLevel() >= paramResearch.levels.length && paramResearch.endlessLevel == null) {
/* 1287 */       bool = true;
/*      */     }
/*      */     
/* 1290 */     if (bool) {
/* 1291 */       paramStartResearchingException.reasons.add(StartResearchFailReason.MAX_LEVEL);
/*      */     }
/*      */     
/* 1294 */     if (paramResearch.priceInStars > 0) {
/*      */       
/* 1296 */       boolean bool1 = false; byte b;
/* 1297 */       for (b = 0; b < paramResearch.linksToParents.size; b++) {
/*      */         Research.ResearchLink researchLink;
/* 1299 */         if ((researchLink = (Research.ResearchLink)paramResearch.linksToParents.get(b)).parent.getInstalledLevel() > 0) {
/* 1300 */           bool1 = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1304 */       for (b = 0; b < paramResearch.linksToChildren.size; b++) {
/*      */         Research.ResearchLink researchLink;
/* 1306 */         if ((researchLink = (Research.ResearchLink)paramResearch.linksToChildren.get(b)).child.getInstalledLevel() > 0) {
/* 1307 */           bool1 = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1311 */       if (!bool1) {
/* 1312 */         paramStartResearchingException.reasons.add(StartResearchFailReason.REQUIRES_PREVIOUS_RESEARCHES);
/*      */       }
/*      */       
/* 1315 */       if (Game.i.researchManager.getUnusedStarsCount() < paramResearch.priceInStars) {
/* 1316 */         paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_STARS);
/*      */       }
/*      */     } else {
/*      */       
/* 1320 */       for (byte b = 0; b < paramResearch.linksToParents.size; b++) {
/*      */         Research.ResearchLink researchLink;
/* 1322 */         if ((researchLink = (Research.ResearchLink)paramResearch.linksToParents.get(b)).requiredLevels > researchLink.parent.getInstalledLevel()) {
/*      */           
/* 1324 */           paramStartResearchingException.reasons.add(StartResearchFailReason.REQUIRES_PREVIOUS_RESEARCHES);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1330 */     if (!bool) {
/* 1331 */       byte b; Requirement requirement; if (paramResearch.levels.length > paramResearch.getInstalledLevel()) {
/*      */         
/* 1333 */         Research.ResearchLevel researchLevel = paramResearch.levels[paramResearch.getInstalledLevel()];
/*      */         
/* 1335 */         if (!paramBoolean) {
/* 1336 */           for (byte b1 = 0; b1 < researchLevel.price.size; b1++) {
/*      */             ItemStack itemStack;
/* 1338 */             if ((itemStack = ((ItemStack[])researchLevel.price.items)[b1]).getItem().getType() == ItemType.GREEN_PAPER) {
/* 1339 */               if (itemStack.getCount() > Game.i.progressManager.getGreenPapers())
/*      */               {
/* 1341 */                 paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_MONEY);
/*      */               }
/* 1343 */             } else if (itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 1344 */               ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 1345 */               if (itemStack.getCount() > Game.i.progressManager.getResources(resourceItem.resourceType))
/*      */               {
/* 1347 */                 if (!paramStartResearchingException.reasons.contains(StartResearchFailReason.NOT_ENOUGH_RESOURCES, true)) {
/* 1348 */                   paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_RESOURCES);
/*      */                 }
/*      */               }
/*      */             }
/* 1352 */             else if (itemStack.getCount() > Game.i.progressManager.getItemsCount(itemStack.getItem()) && 
/* 1353 */               !paramStartResearchingException.reasons.contains(StartResearchFailReason.NOT_ENOUGH_ITEMS, true)) {
/* 1354 */               paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_ITEMS);
/*      */             } 
/*      */           } 
/*      */         }
/*      */         
/*      */         Requirement[] arrayOfRequirement;
/* 1360 */         for (int i = (arrayOfRequirement = researchLevel.requirements).length; b < i; b++) {
/* 1361 */           if (!(requirement = arrayOfRequirement[b]).isSatisfied()) {
/*      */             
/* 1363 */             paramStartResearchingException.reasons.add(StartResearchFailReason.REQUIREMENT_NOT_SATISFIED);
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1369 */       } else if (requirement == null) {
/* 1370 */         Array array = b.endlessLevel.getPrice(b.getInstalledLevel() + 1);
/* 1371 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*      */           ItemStack itemStack;
/* 1373 */           if ((itemStack = ((ItemStack[])array.items)[b1]).getItem().getType() == ItemType.GREEN_PAPER) {
/* 1374 */             if (itemStack.getCount() > Game.i.progressManager.getGreenPapers())
/*      */             {
/* 1376 */               paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_MONEY);
/*      */             }
/* 1378 */           } else if (itemStack.getItem().getType() == ItemType.RESOURCE) {
/* 1379 */             ResourceItem resourceItem = (ResourceItem)itemStack.getItem();
/* 1380 */             if (itemStack.getCount() > Game.i.progressManager.getResources(resourceItem.resourceType))
/*      */             {
/* 1382 */               if (!paramStartResearchingException.reasons.contains(StartResearchFailReason.NOT_ENOUGH_RESOURCES, true)) {
/* 1383 */                 paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_RESOURCES);
/*      */               }
/*      */             }
/*      */           }
/* 1387 */           else if (itemStack.getCount() > Game.i.progressManager.getItemsCount(itemStack.getItem()) && 
/* 1388 */             !paramStartResearchingException.reasons.contains(StartResearchFailReason.NOT_ENOUGH_ITEMS, true)) {
/* 1389 */             paramStartResearchingException.reasons.add(StartResearchFailReason.NOT_ENOUGH_ITEMS);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1397 */     if (paramStartResearchingException.reasons.size != 0) {
/* 1398 */       throw paramStartResearchingException;
/*      */     }
/*      */   }
/*      */   
/*      */   public void resetStarResearches() {
/* 1403 */     b();
/*      */     
/* 1405 */     if (Game.i.researchManager.getResetStarResearchesAcceleratorPrice() > 0) {
/* 1406 */       int i = Game.i.researchManager.getResetStarResearchesAcceleratorPrice();
/* 1407 */       if (Game.i.progressManager.removeAccelerators(i)) {
/* 1408 */         Game.i.analyticsManager.logCurrencySpent("reset_star_research", "accelerator", i);
/* 1409 */         for (i = 0; i < this.b.size; i++) {
/* 1410 */           if ((((Research[])this.b.items)[i]).priceInStars > 0 && ((Research[])this.b.items)[i].getInstalledLevel() > 0) {
/* 1411 */             ((Research[])this.b.items)[i].setInstalledLevel(0);
/*      */           }
/*      */         } 
/* 1414 */         g(); return;
/*      */       } 
/* 1416 */       Notifications.i().add(Game.i.localeManager.i18n.get("not_enough_accelerators"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canStartResearching(Research paramResearch, boolean paramBoolean) {
/* 1422 */     b();
/*      */     
/*      */     try {
/* 1425 */       tryStartResearching(paramResearch, paramBoolean, this.p);
/* 1426 */     } catch (StartResearchingException startResearchingException) {
/* 1427 */       return false;
/*      */     } 
/*      */     
/* 1430 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getResearchingDuration(Research paramResearch) {
/* 1437 */     b();
/*      */     
/* 1439 */     if (paramResearch.isMaxNormalLevel())
/*      */     {
/* 1441 */       return 0L;
/*      */     }
/*      */     
/*      */     Research.ResearchLevel researchLevel;
/*      */     
/* 1446 */     return ((researchLevel = paramResearch.levels[paramResearch.getInstalledLevel()]).researchDuration * 1000);
/*      */   }
/*      */ 
/*      */   
/*      */   private void g() {
/* 1451 */     updateAndValidateStarBranch();
/*      */     
/* 1453 */     Game.i.authManager.notifyNeedCloudSave(true);
/*      */     
/* 1455 */     this.q.begin(); byte b; int i;
/* 1456 */     for (b = 0, i = this.q.size; b < i; b++) {
/* 1457 */       ((ResearchManagerListener)this.q.get(b)).researchesUpdated();
/*      */     }
/* 1459 */     this.q.end();
/*      */   }
/*      */   
/*      */   public void addListener(ResearchManagerListener paramResearchManagerListener) {
/* 1463 */     if (paramResearchManagerListener == null) {
/* 1464 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/* 1467 */     if (!this.q.contains(paramResearchManagerListener, true)) {
/* 1468 */       this.q.add(paramResearchManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(ResearchManagerListener paramResearchManagerListener) {
/* 1473 */     if (paramResearchManagerListener == null) {
/* 1474 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/* 1477 */     this.q.removeValue(paramResearchManagerListener, true);
/*      */   }
/*      */   
/*      */   public int getMapMinX() {
/* 1481 */     return this.f;
/*      */   }
/*      */   
/*      */   public int getMapMaxX() {
/* 1485 */     return this.g;
/*      */   }
/*      */   
/*      */   public int getMapMinY() {
/* 1489 */     return this.h;
/*      */   }
/*      */   
/*      */   public int getMapMaxY() {
/* 1493 */     return this.i;
/*      */   }
/*      */   
/*      */   public int getMapWidth() {
/* 1497 */     return this.j;
/*      */   }
/*      */   
/*      */   public int getMapHeight() {
/* 1501 */     return this.k;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInstalledLevel(ResearchType paramResearchType, int paramInt, boolean paramBoolean) {
/* 1509 */     b();
/*      */     
/*      */     Research research;
/* 1512 */     if ((research = getResearchInstance(paramResearchType)).maxEndlessLevel < paramInt) {
/* 1513 */       throw new IllegalArgumentException("Level for " + paramResearchType.name() + " is too high (" + paramInt + "), max research level is " + research.maxEndlessLevel);
/*      */     }
/* 1515 */     research.setInstalledLevel(paramInt);
/*      */     
/* 1517 */     if (paramBoolean) {
/* 1518 */       this.q.begin();
/* 1519 */       for (byte b = 0; b < paramInt; b++) {
/* 1520 */         ((ResearchManagerListener)this.q.get(b)).researchCompleted(research);
/*      */       }
/* 1522 */       this.q.end();
/*      */     } 
/*      */     
/* 1525 */     g();
/* 1526 */     c();
/*      */   }
/*      */   
/*      */   public Research getResearchInstance(ResearchType paramResearchType) {
/* 1530 */     b();
/*      */     
/* 1532 */     return ((Research[])this.b.items)[paramResearchType.ordinal()];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getUnusedStarsCount() {
/* 1539 */     return this.o;
/*      */   }
/*      */   
/*      */   public int getResetStarResearchesAcceleratorPrice() {
/* 1543 */     b();
/*      */     
/* 1545 */     byte b1 = 0;
/* 1546 */     for (byte b2 = 0; b2 < this.b.size; b2++) {
/* 1547 */       if ((((Research[])this.b.items)[b2]).priceInStars > 0 && ((Research[])this.b.items)[b2].getInstalledLevel() > 0) {
/* 1548 */         b1++;
/*      */       }
/*      */     } 
/*      */     
/* 1552 */     return b1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void test() {
/* 1557 */     for (byte b = 0; b < this.b.size; exception++) {
/* 1558 */       Research research = (Research)this.b.get(b);
/*      */       try {
/* 1560 */         research.getDescription();
/* 1561 */         research.getTitle();
/* 1562 */         research.category.getDescription();
/* 1563 */         research.category.getTitle();
/* 1564 */       } catch (Exception exception) {
/* 1565 */         a.e("Test: failed for research type " + research.type.name(), new Object[0]);
/* 1566 */         throw exception;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {}
/*      */ 
/*      */   
/*      */   public enum StartResearchFailReason
/*      */   {
/* 1577 */     OTHER_RESEARCH_IN_PROGRESS,
/* 1578 */     NOT_VISIBLE,
/* 1579 */     MAX_LEVEL,
/* 1580 */     REQUIRES_PREVIOUS_RESEARCHES,
/* 1581 */     NOT_ENOUGH_MONEY,
/* 1582 */     NOT_ENOUGH_RESOURCES,
/* 1583 */     NOT_ENOUGH_STARS,
/* 1584 */     NOT_ENOUGH_ITEMS,
/* 1585 */     REQUIREMENT_NOT_SATISFIED;
/*      */     
/* 1587 */     public static final StartResearchFailReason[] values = values();
/*      */     static {
/*      */     
/*      */     } }
/* 1591 */   public static final class StartResearchingException extends RuntimeException { public final Array<ResearchManager.StartResearchFailReason> reasons = new Array(); }
/*      */ 
/*      */   
/*      */   public static interface ResearchManagerListener {
/*      */     void researchesUpdated();
/*      */     
/*      */     void researchStarted(Research param1Research, long param1Long);
/*      */     
/*      */     void researchCompleted(Research param1Research);
/*      */     
/*      */     public static abstract class ResearchManagerListenerAdapter implements ResearchManagerListener {
/*      */       public void researchesUpdated() {}
/*      */       
/*      */       public void researchStarted(Research param2Research, long param2Long) {}
/*      */       
/*      */       public void researchCompleted(Research param2Research) {}
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PolygonConfig {
/* 1611 */     private static final EarClippingTriangulator a = new EarClippingTriangulator();
/* 1612 */     private static final Color b = new Color();
/*      */     public PolygonSprite sprite;
/*      */     public Research visibleWith;
/*      */     
/*      */     @Null
/*      */     public static PolygonConfig fromJson(l param1l) {
/* 1618 */       ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getBlankWhiteTextureRegion();
/*      */       
/* 1620 */       String str1 = null;
/* 1621 */       String str2 = null;
/*      */       
/* 1623 */       FloatArray floatArray = new FloatArray();
/* 1624 */       int i = Integer.MAX_VALUE;
/* 1625 */       int j = Integer.MAX_VALUE;
/* 1626 */       int k = Integer.MIN_VALUE;
/* 1627 */       int m = Integer.MIN_VALUE;
/* 1628 */       int n = atlasTextureRegion.getRegionHeight();
/*      */       
/* 1630 */       while (param1l.g() != o.c) {
/*      */         int i1; String str;
/* 1632 */         switch (str = param1l.u()) {
/*      */           case "color":
/* 1634 */             str1 = param1l.i();
/*      */             continue;
/*      */           
/*      */           case "visibleWith":
/* 1638 */             str2 = param1l.i();
/*      */             continue;
/*      */           
/*      */           case "points":
/* 1642 */             param1l.g();
/* 1643 */             while (param1l.g() != o.e) {
/* 1644 */               i1 = param1l.b(0);
/* 1645 */               int i2 = param1l.b(0);
/*      */               
/* 1647 */               if (i1 < i) i = i1; 
/* 1648 */               if (i1 > k) k = i1; 
/* 1649 */               if (i2 < j) j = i2; 
/* 1650 */               if (i2 > m) m = i2; 
/* 1651 */               floatArray.add(i1, i2);
/*      */               
/* 1653 */               param1l.g();
/*      */             } 
/*      */             continue;
/*      */         } 
/*      */         
/* 1658 */         ResearchManager.a().i("skip " + i1, new Object[0]);
/* 1659 */         param1l.g();
/* 1660 */         param1l.j();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1666 */         float f1 = (k - i);
/* 1667 */         float f2 = (m - j);
/* 1668 */         for (byte b = 0; b < floatArray.size; b += 2) {
/* 1669 */           floatArray.items[b] = (floatArray.items[b] - i) / f1 * n;
/* 1670 */           floatArray.items[b + 1] = (floatArray.items[b + 1] - j) / f2 * n;
/*      */         } 
/* 1672 */         ShortArray shortArray = a.computeTriangles(floatArray);
/*      */         
/* 1674 */         PolygonRegion polygonRegion = new PolygonRegion((TextureRegion)atlasTextureRegion, floatArray.toArray(), shortArray.toArray());
/*      */         PolygonSprite polygonSprite;
/* 1676 */         (polygonSprite = new PolygonSprite(polygonRegion)).setBounds((i - Game.i.researchManager.getMapMinX()), (j - Game.i.researchManager.getMapMinY()), (k - i), (m - j));
/*      */         
/* 1678 */         Color.rgba8888ToColor(b, PMath.parseUnsignedInt(str1.substring(1), 16));
/* 1679 */         polygonSprite.setColor(b);
/*      */         
/*      */         PolygonConfig polygonConfig;
/* 1682 */         (polygonConfig = new PolygonConfig()).sprite = polygonSprite;
/* 1683 */         if (str2 != null && str2.length() != 0) {
/* 1684 */           polygonConfig.visibleWith = Game.i.researchManager.getInstancePreSetup(ResearchType.valueOf(str2));
/*      */         }
/*      */         
/* 1687 */         return polygonConfig;
/* 1688 */       } catch (Exception exception) {
/* 1689 */         ResearchManager.a().e("failed to load polygon", new Object[] { exception });
/* 1690 */         return null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ResearchManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */