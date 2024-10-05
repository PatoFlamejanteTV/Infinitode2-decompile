/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Research;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.TrophyType;
/*      */ import com.prineside.tdi2.items.GameValueGlobalItem;
/*      */ import com.prineside.tdi2.items.GameValueLevelItem;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.QuadRegion;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ 
/*      */ @REGS(serializer = GameValueManager.Serializer.class)
/*      */ public class GameValueManager
/*      */   extends Manager.ManagerAdapter {
/*   45 */   private static final TLog a = TLog.forClass(GameValueManager.class);
/*      */   
/*   47 */   public static final Color ICON_BACKGROUND_COLOR = new Color(252645375); private boolean b;
/*      */   private final GameValueStockConfig[] c;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<GameValueManager> { public GameValueManager read() {
/*   51 */       return Game.i.gameValueManager;
/*      */     } }
/*      */   
/*      */   public enum ValueUnits {
/*   55 */     UNITS,
/*   56 */     SECONDS,
/*   57 */     UNITS_PER_SECOND,
/*   58 */     PERCENTS_PER_SECOND,
/*   59 */     PERCENTS,
/*   60 */     BOOLEAN;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d = true;
/*      */ 
/*      */   
/*   68 */   private final GameValuesSnapshot e = new GameValuesSnapshot();
/*   69 */   private final GameValuesSnapshot f = new GameValuesSnapshot();
/*      */   
/*   71 */   private static final StringBuilder g = new StringBuilder();
/*   72 */   private static final StringBuilder h = new StringBuilder();
/*      */   
/*   74 */   private final DelayedRemovalArray<GameValueManagerListener> i = new DelayedRemovalArray(false, 1);
/*      */   
/*   76 */   private final _ResearchManagerListener j = new _ResearchManagerListener((byte)0);
/*   77 */   private final _ProgressManagerListener k = new _ProgressManagerListener((byte)0);
/*      */   
/*      */   public GameValueManager() {
/*   80 */     this.c = new GameValueStockConfig[GameValueType.values.length]; GameValueType[] arrayOfGameValueType; int i; byte b;
/*   81 */     for (i = (arrayOfGameValueType = GameValueType.values).length, b = 0; b < i; ) { GameValueType gameValueType = arrayOfGameValueType[b];
/*   82 */       this.c[gameValueType.ordinal()] = new GameValueStockConfig();
/*   83 */       (this.c[gameValueType.ordinal()]).type = gameValueType;
/*      */       b++; }
/*      */   
/*      */   }
/*      */   private void b() {
/*   88 */     if (this.d) {
/*   89 */       c();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*   95 */     if (!Config.isHeadless()) {
/*   96 */       Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*      */           {
/*      */             public void reloaded() {
/*   99 */               this.a.requireRecalculation();
/*      */             }
/*      */           });
/*  102 */       Game.i.researchManager.addListener(this.j);
/*  103 */       Game.i.progressManager.addListener(this.k);
/*      */     }  GameValueStockConfig[] arrayOfGameValueStockConfig; int i;
/*      */     byte b;
/*  106 */     for (i = (arrayOfGameValueStockConfig = this.c).length, b = 0; b < i; b++) {
/*  107 */       GameValueStockConfig gameValueStockConfig; (gameValueStockConfig = arrayOfGameValueStockConfig[b]).stockValue = 0.0D;
/*      */     } 
/*      */     
/*      */     JsonValue jsonValue;
/*  111 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/game-values.json"))).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*      */       try {
/*  113 */         GameValueType gameValueType = GameValueType.valueOf(jsonValue1.name);
/*      */         
/*      */         GameValueStockConfig gameValueStockConfig;
/*  116 */         (gameValueStockConfig = this.c[gameValueType.ordinal()]).stockValue = jsonValue1.get("default").asDouble();
/*  117 */         gameValueStockConfig.units = ValueUnits.valueOf(jsonValue1.get("units").asString());
/*  118 */         gameValueStockConfig.titleAlias = "gv_title_" + gameValueType.name();
/*  119 */         if (gameValueStockConfig.units == ValueUnits.BOOLEAN) {
/*  120 */           gameValueStockConfig.disabledTitleAlias = "gv_title_disabled_" + gameValueType.name();
/*      */         }
/*      */         
/*  123 */         jsonValue1.getString("flags", "");
/*      */ 
/*      */       
/*      */       }
/*  127 */       catch (Exception exception) {
/*  128 */         a.e("failed to load game value config '" + jsonValue1.name + "'", new Object[] { exception });
/*      */       }  }
/*      */ 
/*      */     
/*  132 */     requireRecalculation();
/*      */     
/*  134 */     this.b = true;
/*      */   }
/*      */   
/*      */   public void addListener(GameValueManagerListener paramGameValueManagerListener) {
/*  138 */     if (paramGameValueManagerListener == null) {
/*  139 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  142 */     if (!this.i.contains(paramGameValueManagerListener, true)) {
/*  143 */       this.i.add(paramGameValueManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(GameValueManagerListener paramGameValueManagerListener) {
/*  148 */     if (paramGameValueManagerListener == null) {
/*  149 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  152 */     this.i.removeValue(paramGameValueManagerListener, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCheatingReason(Array<GvSnapDiff> paramArray) {
/*  157 */     for (byte b = 0; b < paramArray.size; b++) {
/*      */       GvSnapDiff gvSnapDiff;
/*  159 */       if ((gvSnapDiff = ((GvSnapDiff[])paramArray.items)[b]).type == GvSnapDiff.Type.GV_NOT_IN_ORIG && 
/*  160 */         gvSnapDiff.effect.source == GameValueEffect.Source.STOCK) {
/*  161 */         GameValueStockConfig gameValueStockConfig = this.c[gvSnapDiff.effect.type.ordinal()];
/*  162 */         return gameValueStockConfig.type.name() + " " + gvSnapDiff.effect.delta + " != stock " + gameValueStockConfig.stockValue;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  167 */     return null;
/*      */   }
/*      */   
/*      */   public void requireRecalculation() {
/*  171 */     this.d = true;
/*      */   }
/*      */   
/*      */   private void c() {
/*  175 */     if (!this.b) throw new IllegalStateException("Manager is not set up yet");
/*      */ 
/*      */     
/*  178 */     ProgressManager.ProgressSnapshotForState progressSnapshotForState = Game.i.progressManager.createProgressSnapshotForState();
/*  179 */     createSnapshot(this.e, Game.i.progressManager.getDifficultyMode(), false, null, false, false, progressSnapshotForState);
/*  180 */     if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode())) {
/*  181 */       this.f.from(this.e);
/*      */     } else {
/*  183 */       createSnapshot(this.f, DifficultyMode.ENDLESS_I, false, null, false, false, progressSnapshotForState);
/*      */     } 
/*  185 */     this.d = false;
/*      */ 
/*      */     
/*  188 */     this.i.begin(); byte b; int i;
/*  189 */     for (b = 0, i = this.i.size; b < i; b++) {
/*  190 */       ((GameValueManagerListener)this.i.get(b)).gameValuesRecalculated();
/*      */     }
/*  192 */     this.i.end();
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
/*      */   public Array<GameValueEffect> getCurrentEffects() {
/*  219 */     if (!this.b) throw new IllegalStateException("Manager is not set up yet");
/*      */     
/*  221 */     return (Array<GameValueEffect>)(createSnapshot(null, Game.i.progressManager
/*      */         
/*  223 */         .getDifficultyMode(), true, null, false, false, Game.i.progressManager
/*      */ 
/*      */ 
/*      */         
/*  227 */         .createProgressSnapshotForState())).effects;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder formatEffectValue(double paramDouble, ValueUnits paramValueUnits) {
/*  235 */     g.setLength(0);
/*      */     
/*  237 */     if (paramValueUnits == ValueUnits.BOOLEAN)
/*      */     {
/*  239 */       return g.append((paramDouble <= 0.0D) ? "false" : "true");
/*      */     }
/*      */     
/*  242 */     if (paramDouble > 0.0D) g.append("+");
/*      */ 
/*      */     
/*  245 */     if (paramDouble % 1.0D == 0.0D) {
/*      */       
/*  247 */       g.append((int)paramDouble);
/*      */     } else {
/*      */       
/*  250 */       g.append(StringFormatter.compactNumber(paramDouble, true));
/*      */     } 
/*      */     
/*  253 */     switch (null.a[paramValueUnits.ordinal()]) { case 1:
/*  254 */         g.append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND")); break;
/*  255 */       case 2: g.append('%'); break;
/*  256 */       case 3: g.append("/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND")); break;
/*  257 */       case 4: g.append("%/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*      */         break; }
/*      */     
/*  260 */     return g;
/*      */   }
/*      */   
/*      */   public StringBuilder formatEffectTitleValue(double paramDouble, GameValueType paramGameValueType) {
/*  264 */     g.setLength(0);
/*      */     
/*      */     GameValueStockConfig gameValueStockConfig;
/*      */     
/*  268 */     if ((gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(paramGameValueType)).units == ValueUnits.BOOLEAN) {
/*      */       
/*  270 */       if (paramDouble <= 0.0D) {
/*  271 */         g.append(Game.i.gameValueManager.getDisabledTitle(paramGameValueType));
/*      */       } else {
/*  273 */         g.append(Game.i.gameValueManager.getTitle(paramGameValueType));
/*      */       } 
/*  275 */       return g;
/*      */     } 
/*  277 */     g.append(Game.i.gameValueManager.getTitle(paramGameValueType)).append(' ');
/*  278 */     if (paramDouble > 0.0D) g.append("+");
/*      */ 
/*      */     
/*  281 */     if (paramDouble % 1.0D == 0.0D) {
/*      */       
/*  283 */       g.append((int)paramDouble);
/*      */     } else {
/*      */       
/*  286 */       g.append(StringFormatter.compactNumber(paramDouble, true));
/*      */     } 
/*      */     
/*  289 */     switch (null.a[gameValueStockConfig.units.ordinal()]) {
/*      */       case 1:
/*  291 */         g.append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*      */         break;
/*      */       case 2:
/*  294 */         g.append('%');
/*      */         break;
/*      */       case 3:
/*  297 */         g.append("/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*      */         break;
/*      */       case 4:
/*  300 */         g.append("%/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  305 */     return g;
/*      */   }
/*      */ 
/*      */   
/*      */   public GameValueStockConfig getStockValueConfig(GameValueType paramGameValueType) {
/*  310 */     return this.c[paramGameValueType.ordinal()];
/*      */   }
/*      */   
/*      */   public StringBuilder getTitle(GameValueType paramGameValueType) {
/*  314 */     h.setLength(0);
/*  315 */     String str = (getStockValueConfig(paramGameValueType)).titleAlias;
/*  316 */     str = Game.i.localeManager.i18n.get(str);
/*  317 */     h.append(Game.i.assetManager.replaceRegionAliasesWithChars(str));
/*      */     
/*  319 */     return h;
/*      */   }
/*      */   
/*      */   public StringBuilder getDisabledTitle(GameValueType paramGameValueType) {
/*      */     GameValueStockConfig gameValueStockConfig;
/*  324 */     if ((gameValueStockConfig = getStockValueConfig(paramGameValueType)).units != ValueUnits.BOOLEAN) {
/*  325 */       a.e("Game value " + paramGameValueType + " is not BOOLEAN, can't return disabled title - falling back to the default", new Object[0]);
/*  326 */       return getTitle(paramGameValueType);
/*      */     } 
/*      */     
/*  329 */     h.setLength(0);
/*  330 */     String str = gameValueStockConfig.disabledTitleAlias;
/*  331 */     h.append(Game.i.localeManager.i18n.get(str));
/*      */     
/*  333 */     return h;
/*      */   }
/*      */   
/*      */   public ValueUnits getUnits(GameValueType paramGameValueType) {
/*  337 */     return (getStockValueConfig(paramGameValueType)).units;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GameValuesSnapshot getSnapshot() {
/*  344 */     b();
/*      */     
/*  346 */     return this.e;
/*      */   }
/*      */   
/*      */   public GameValuesSnapshot getEndlessSnapshot() {
/*  350 */     b();
/*      */     
/*  352 */     return this.f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GameValuesSnapshot createSnapshot(@Null GameValuesSnapshot paramGameValuesSnapshot, DifficultyMode paramDifficultyMode, boolean paramBoolean1, BasicLevel paramBasicLevel, boolean paramBoolean2, boolean paramBoolean3, ProgressManager.ProgressSnapshotForState paramProgressSnapshotForState) {
/*  363 */     if (!Game.isLoaded()) throw new IllegalStateException("Game is not loaded yet");
/*      */     
/*  365 */     if (paramGameValuesSnapshot == null) {
/*  366 */       paramGameValuesSnapshot = new GameValuesSnapshot();
/*      */     } else {
/*      */       
/*  369 */       paramGameValuesSnapshot.effects.clear();
/*      */     } 
/*      */     
/*  372 */     if (paramBasicLevel != null && paramBasicLevel.forcedDifficulty != null) {
/*  373 */       paramDifficultyMode = paramBasicLevel.forcedDifficulty;
/*      */     }
/*  375 */     boolean bool = DifficultyMode.isEndless(paramDifficultyMode);
/*      */     
/*      */     GameValueStockConfig[] arrayOfGameValueStockConfig;
/*      */     int i, j;
/*  379 */     for (i = (arrayOfGameValueStockConfig = arrayOfGameValueStockConfig = Game.i.gameValueManager.c).length, j = 0; j < i; ) { GameValueStockConfig gameValueStockConfig = arrayOfGameValueStockConfig[j];
/*  380 */       paramGameValuesSnapshot.values[gameValueStockConfig.type.ordinal()] = gameValueStockConfig.stockValue;
/*  381 */       if (paramBoolean1) {
/*      */         GameValueEffect gameValueEffect;
/*  383 */         (gameValueEffect = new GameValueEffect()).delta = gameValueStockConfig.stockValue;
/*  384 */         gameValueEffect.type = gameValueStockConfig.type;
/*  385 */         gameValueEffect.source = GameValueEffect.Source.STOCK;
/*  386 */         paramGameValuesSnapshot.effects.add(gameValueEffect);
/*      */       } 
/*      */       j++; }
/*      */     
/*  390 */     Array<Research> array = Game.i.researchManager.getInstances();
/*  391 */     if (paramBoolean2) {
/*      */       
/*  393 */       if (paramBoolean3)
/*      */       {
/*  395 */         for (i = 0; i < array.size; i++) {
/*  396 */           Research research = ((Research[])array.items)[i];
/*  397 */           if (bool || !research.endlessOnly) {
/*      */             int m;
/*      */             
/*  400 */             if ((m = paramProgressSnapshotForState.getResearchInstalledLevel(research.type)) != 0 && research.cantBeIgnoredOnUserMaps) {
/*  401 */               if (!bool && m > research.levels.length)
/*      */               {
/*  403 */                 m = research.levels.length;
/*      */               }
/*  405 */               Array array1 = research.getEffects(m);
/*  406 */               for (paramBoolean2 = false; paramBoolean2 < array1.size; paramBoolean2++) {
/*  407 */                 GameValueEffect gameValueEffect = ((GameValueEffect[])array1.items)[paramBoolean2];
/*  408 */                 paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] = paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] + gameValueEffect.delta;
/*      */                 
/*  410 */                 if (paramBoolean1) {
/*      */                   GameValueEffect gameValueEffect1;
/*  412 */                   (gameValueEffect1 = new GameValueEffect()).setup(gameValueEffect.type, gameValueEffect.delta, GameValueEffect.Source.RESEARCH);
/*  413 */                   gameValueEffect1.researchType = research.type;
/*  414 */                   paramGameValuesSnapshot.effects.add(gameValueEffect1);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } else {
/*  422 */       for (i = 0; i < array.size; i++) {
/*  423 */         Research research = ((Research[])array.items)[i];
/*  424 */         if (bool || !research.endlessOnly) {
/*      */           int n;
/*      */           
/*  427 */           if ((n = paramProgressSnapshotForState.getResearchInstalledLevel(research.type)) != 0) {
/*  428 */             if (!bool && n > research.levels.length)
/*      */             {
/*  430 */               n = research.levels.length;
/*      */             }
/*      */             
/*  433 */             Array array1 = research.getEffects(n);
/*  434 */             for (paramBoolean2 = false; paramBoolean2 < array1.size; paramBoolean2++) {
/*  435 */               GameValueEffect gameValueEffect = ((GameValueEffect[])array1.items)[paramBoolean2];
/*  436 */               paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] = paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] + gameValueEffect.delta;
/*      */               
/*  438 */               if (paramBoolean1) {
/*      */                 GameValueEffect gameValueEffect1;
/*  440 */                 (gameValueEffect1 = new GameValueEffect()).setup(gameValueEffect.type, gameValueEffect.delta, GameValueEffect.Source.RESEARCH);
/*  441 */                 gameValueEffect1.researchType = research.type;
/*  442 */                 paramGameValuesSnapshot.effects.add(gameValueEffect1);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }  TrophyManager.TrophyConfig[] arrayOfTrophyConfig1;
/*      */       TrophyManager.TrophyConfig[] arrayOfTrophyConfig2;
/*      */       byte b2;
/*  450 */       for (int m = (arrayOfTrophyConfig2 = arrayOfTrophyConfig1 = Game.i.trophyManager.getConfigs()).length; b2 < m; ) { TrophyManager.TrophyConfig trophyConfig = arrayOfTrophyConfig2[b2];
/*  451 */         if (paramProgressSnapshotForState.isTrophyReceived(trophyConfig.type)) {
/*  452 */           for (paramBoolean3 = false; paramBoolean3 < trophyConfig.gameValues.size; paramBoolean3++) {
/*  453 */             GameValueEffect gameValueEffect = ((GameValueEffect[])trophyConfig.gameValues.items)[paramBoolean3];
/*      */             
/*  455 */             paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] = paramGameValuesSnapshot.values[gameValueEffect.type.ordinal()] + gameValueEffect.delta;
/*      */             
/*  457 */             if (paramBoolean1) {
/*      */               GameValueEffect gameValueEffect1;
/*  459 */               (gameValueEffect1 = new GameValueEffect()).setup(gameValueEffect.type, gameValueEffect.delta, GameValueEffect.Source.TROPHY);
/*  460 */               gameValueEffect1.trophyType = trophyConfig.type;
/*  461 */               paramGameValuesSnapshot.effects.add(gameValueEffect1);
/*      */             } 
/*      */           } 
/*      */         }
/*      */         
/*      */         b2++; }
/*      */       
/*  468 */       for (byte b1 = 0; b1 < Game.i.basicLevelManager.levelsOrdered.size; b1++) {
/*  469 */         BasicLevel basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[b1];
/*      */ 
/*      */         
/*  472 */         for (b2 = 0; b2 < basicLevel.quests.size; b2++) {
/*  473 */           BasicLevelQuestConfig basicLevelQuestConfig = ((BasicLevelQuestConfig[])basicLevel.quests.items)[b2];
/*  474 */           if (paramProgressSnapshotForState.isQuestEverCompleted(basicLevelQuestConfig.id)) {
/*  475 */             for (paramBoolean3 = false; paramBoolean3 < basicLevelQuestConfig.prizes.size; paramBoolean3++) {
/*      */               ItemStack itemStack;
/*  477 */               if ((itemStack = ((ItemStack[])basicLevelQuestConfig.prizes.items)[paramBoolean3]).getItem().getType() == ItemType.GAME_VALUE_GLOBAL) {
/*  478 */                 GameValueGlobalItem gameValueGlobalItem = (GameValueGlobalItem)itemStack.getItem();
/*      */                 
/*  480 */                 paramGameValuesSnapshot.values[gameValueGlobalItem.gameValueType.ordinal()] = paramGameValuesSnapshot.values[gameValueGlobalItem.gameValueType.ordinal()] + gameValueGlobalItem.delta;
/*      */                 
/*  482 */                 if (paramBoolean1) {
/*      */                   GameValueEffect gameValueEffect;
/*  484 */                   (gameValueEffect = new GameValueEffect()).setup(gameValueGlobalItem.gameValueType, gameValueGlobalItem.delta, GameValueEffect.Source.LEVEL_QUEST);
/*  485 */                   gameValueEffect.questId = basicLevelQuestConfig.id;
/*  486 */                   paramGameValuesSnapshot.effects.add(gameValueEffect);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  494 */         for (b2 = 0; b2 < basicLevel.waveQuests.size; b2++) {
/*  495 */           BasicLevel.WaveQuest waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b2);
/*  496 */           if (paramProgressSnapshotForState.isQuestEverCompleted(waveQuest.id)) {
/*  497 */             for (paramBoolean3 = false; paramBoolean3 < waveQuest.prizes.size; paramBoolean3++) {
/*      */               ItemStack itemStack;
/*  499 */               if ((itemStack = ((ItemStack[])waveQuest.prizes.items)[paramBoolean3]).getItem().getType() == ItemType.GAME_VALUE_GLOBAL) {
/*  500 */                 GameValueGlobalItem gameValueGlobalItem = (GameValueGlobalItem)itemStack.getItem();
/*      */                 
/*  502 */                 paramGameValuesSnapshot.values[gameValueGlobalItem.gameValueType.ordinal()] = paramGameValuesSnapshot.values[gameValueGlobalItem.gameValueType.ordinal()] + gameValueGlobalItem.delta;
/*      */                 
/*  504 */                 if (paramBoolean1) {
/*      */                   GameValueEffect gameValueEffect;
/*  506 */                   (gameValueEffect = new GameValueEffect()).setup(gameValueGlobalItem.gameValueType, gameValueGlobalItem.delta, GameValueEffect.Source.LEVEL_WAVE_QUEST);
/*  507 */                   gameValueEffect.questId = waveQuest.id;
/*  508 */                   paramGameValuesSnapshot.effects.add(gameValueEffect);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  518 */     if (paramBasicLevel != null) {
/*      */ 
/*      */       
/*  521 */       for (i = 0; i < paramBasicLevel.quests.size; i++) {
/*  522 */         BasicLevelQuestConfig basicLevelQuestConfig = ((BasicLevelQuestConfig[])paramBasicLevel.quests.items)[i];
/*  523 */         if (paramProgressSnapshotForState.isQuestEverCompleted(basicLevelQuestConfig.id)) {
/*  524 */           for (byte b = 0; b < basicLevelQuestConfig.prizes.size; b++) {
/*      */             ItemStack itemStack;
/*  526 */             if ((itemStack = ((ItemStack[])basicLevelQuestConfig.prizes.items)[b]).getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/*  527 */               GameValueLevelItem gameValueLevelItem = (GameValueLevelItem)itemStack.getItem();
/*      */               
/*  529 */               paramGameValuesSnapshot.values[gameValueLevelItem.gameValueType.ordinal()] = paramGameValuesSnapshot.values[gameValueLevelItem.gameValueType.ordinal()] + gameValueLevelItem.delta;
/*      */               
/*  531 */               if (paramBoolean1) {
/*      */                 GameValueEffect gameValueEffect;
/*  533 */                 (gameValueEffect = new GameValueEffect()).setup(gameValueLevelItem.gameValueType, gameValueLevelItem.delta, GameValueEffect.Source.LEVEL_QUEST);
/*  534 */                 gameValueEffect.questId = basicLevelQuestConfig.id;
/*  535 */                 paramGameValuesSnapshot.effects.add(gameValueEffect);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  543 */       for (i = 0; i < paramBasicLevel.waveQuests.size; i++) {
/*  544 */         BasicLevel.WaveQuest waveQuest = ((BasicLevel.WaveQuest[])paramBasicLevel.waveQuests.items)[i];
/*  545 */         if (paramProgressSnapshotForState.isQuestEverCompleted(waveQuest.id)) {
/*  546 */           for (byte b = 0; b < waveQuest.prizes.size; b++) {
/*      */             ItemStack itemStack;
/*  548 */             if ((itemStack = ((ItemStack[])waveQuest.prizes.items)[b]).getItem().getType() == ItemType.GAME_VALUE_LEVEL) {
/*  549 */               GameValueLevelItem gameValueLevelItem = (GameValueLevelItem)itemStack.getItem();
/*      */               
/*  551 */               paramGameValuesSnapshot.values[gameValueLevelItem.gameValueType.ordinal()] = paramGameValuesSnapshot.values[gameValueLevelItem.gameValueType.ordinal()] + gameValueLevelItem.delta;
/*      */               
/*  553 */               if (paramBoolean1) {
/*      */                 GameValueEffect gameValueEffect;
/*  555 */                 (gameValueEffect = new GameValueEffect()).setup(gameValueLevelItem.gameValueType, gameValueLevelItem.delta, GameValueEffect.Source.LEVEL_WAVE_QUEST);
/*  556 */                 gameValueEffect.questId = waveQuest.id;
/*  557 */                 paramGameValuesSnapshot.effects.add(gameValueEffect);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  567 */     j = 1; GameValueType[] arrayOfGameValueType;
/*  568 */     for (int k = (arrayOfGameValueType = GameValueType.values).length; paramBoolean2 < k; ) { GameValueType gameValueType = arrayOfGameValueType[paramBoolean2];
/*  569 */       j = j * 31 + (int)(paramGameValuesSnapshot.values[gameValueType.ordinal()] * 1000.0D); paramBoolean2++; }
/*      */     
/*  571 */     paramGameValuesSnapshot.hash = j;
/*      */     
/*  573 */     return paramGameValuesSnapshot;
/*      */   } public void test() {
/*      */     GameValueType[] arrayOfGameValueType;
/*      */     int i;
/*      */     byte b;
/*  578 */     for (i = (arrayOfGameValueType = GameValueType.values).length, b = 0; b < i; ) { GameValueType gameValueType = arrayOfGameValueType[b];
/*  579 */       getStockValueConfig(gameValueType);
/*      */       b++; }
/*      */   
/*      */   }
/*      */   
/*      */   public static class GameValueStockConfig {
/*      */     public GameValueType type;
/*      */     public String titleAlias;
/*      */     @Null
/*      */     public String disabledTitleAlias;
/*      */     public double stockValue;
/*      */     public GameValueManager.ValueUnits units;
/*      */     private Quad a;
/*      */     
/*      */     public Quad getIcon() {
/*  594 */       if (this.a == null) {
/*  595 */         this.a = Game.i.assetManager.getQuad("gv." + this.type.name());
/*      */       }
/*      */       
/*  598 */       return this.a;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Quad createIconForBackground(Color param1Color) {
/*  606 */       Quad quad = new Quad(getIcon(), true);
/*  607 */       for (byte b = 0; b < (quad.getRegions()).size; b++) {
/*  608 */         QuadRegion quadRegion = (QuadRegion)quad.getRegions().get(b);
/*  609 */         if ("shadow".equals(quadRegion.getQuadName())) {
/*  610 */           quadRegion.setSameCornerColors(param1Color);
/*  611 */           quadRegion.setColorMode((byte)2);
/*      */         } 
/*      */       } 
/*  614 */       return quad;
/*      */     }
/*      */     
/*      */     public Quad createIconForBackgroundWithColor(Color param1Color1, Color param1Color2) {
/*  618 */       Quad quad = new Quad(getIcon(), true);
/*  619 */       for (byte b = 0; b < (quad.getRegions()).size; b++) {
/*  620 */         QuadRegion quadRegion = (QuadRegion)quad.getRegions().get(b);
/*  621 */         if ("shadow".equals(quadRegion.getQuadName())) {
/*  622 */           quadRegion.setSameCornerColors(param1Color1);
/*  623 */           quadRegion.setColorMode((byte)2);
/*      */         } else {
/*  625 */           quadRegion.setSameCornerColors(param1Color2);
/*  626 */           quadRegion.setColorMode((byte)2);
/*      */         } 
/*      */       } 
/*  629 */       return quad;
/*      */     } }
/*      */   @REGS
/*      */   public static class GameValueEffect implements KryoSerializable { public GameValueType type; public double delta; public Source source; @NAGS
/*      */     public ResearchType researchType; @NAGS
/*      */     public TrophyType trophyType; @NAGS
/*      */     public String questId;
/*      */     
/*      */     @REGS
/*  638 */     public enum Source { STOCK,
/*  639 */       LEVEL_STOCK,
/*  640 */       RESEARCH,
/*  641 */       TROPHY,
/*  642 */       LEVEL_QUEST,
/*  643 */       LEVEL_WAVE_QUEST,
/*      */       
/*  645 */       BASE_TILE,
/*  646 */       CORE_TILE,
/*  647 */       BOSS_TILE,
/*  648 */       GV_TILE,
/*  649 */       CUSTOM;
/*      */       
/*  651 */       public static final Source[] values = values();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       static {
/*      */       
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/*  669 */       param1Kryo.writeObjectOrNull(param1Output, this.type, GameValueType.class);
/*  670 */       param1Output.writeDouble(this.delta);
/*  671 */       param1Kryo.writeObjectOrNull(param1Output, this.source, Source.class);
/*  672 */       param1Kryo.writeObjectOrNull(param1Output, this.researchType, ResearchType.class);
/*  673 */       param1Kryo.writeObjectOrNull(param1Output, this.trophyType, TrophyType.class);
/*  674 */       param1Kryo.writeObjectOrNull(param1Output, this.questId, String.class);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/*  679 */       this.type = (GameValueType)param1Kryo.readObjectOrNull(param1Input, GameValueType.class);
/*  680 */       this.delta = param1Input.readDouble();
/*  681 */       this.source = (Source)param1Kryo.readObjectOrNull(param1Input, Source.class);
/*  682 */       this.researchType = (ResearchType)param1Kryo.readObjectOrNull(param1Input, ResearchType.class);
/*  683 */       this.trophyType = (TrophyType)param1Kryo.readObjectOrNull(param1Input, TrophyType.class);
/*  684 */       this.questId = (String)param1Kryo.readObjectOrNull(param1Input, String.class);
/*      */     }
/*      */     
/*      */     public GameValueEffect() {}
/*      */     
/*      */     public GameValueEffect(GameValueType param1GameValueType, double param1Double) {
/*  690 */       this.type = param1GameValueType;
/*  691 */       this.delta = param1Double;
/*      */     }
/*      */     
/*      */     public GameValueEffect(GameValueEffect param1GameValueEffect) {
/*  695 */       from(param1GameValueEffect);
/*      */     }
/*      */     
/*      */     public void from(GameValueEffect param1GameValueEffect) {
/*  699 */       this.type = param1GameValueEffect.type;
/*  700 */       this.delta = param1GameValueEffect.delta;
/*  701 */       this.source = param1GameValueEffect.source;
/*  702 */       this.researchType = param1GameValueEffect.researchType;
/*  703 */       this.trophyType = param1GameValueEffect.trophyType;
/*  704 */       this.questId = param1GameValueEffect.questId;
/*      */     }
/*      */     
/*      */     public boolean sameAs(GameValueEffect param1GameValueEffect) {
/*  708 */       if (param1GameValueEffect.type != this.type) return false; 
/*  709 */       if (param1GameValueEffect.delta != this.delta) return false; 
/*  710 */       if (param1GameValueEffect.source != this.source) return false; 
/*  711 */       if (param1GameValueEffect.researchType != this.researchType) return false; 
/*  712 */       if (param1GameValueEffect.trophyType != this.trophyType) return false; 
/*  713 */       if (param1GameValueEffect.questId != null && !param1GameValueEffect.questId.equals(this.questId)) return false;
/*      */       
/*  715 */       return true;
/*      */     }
/*      */     
/*      */     public void setup(GameValueType param1GameValueType, double param1Double, Source param1Source) {
/*  719 */       this.type = param1GameValueType;
/*  720 */       this.delta = param1Double;
/*  721 */       this.source = param1Source;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  726 */       String str = this.type.name() + " " + ((this.delta > 0.0D) ? "+" : "") + this.delta;
/*  727 */       if (this.source != null) {
/*  728 */         str = str + " (source: " + this.source.name() + ")";
/*      */       }
/*  730 */       if (this.researchType != null) {
/*  731 */         str = str + " research: " + this.researchType.name();
/*      */       }
/*  733 */       if (this.trophyType != null) {
/*  734 */         str = str + " trophy: " + this.trophyType.name();
/*      */       }
/*  736 */       if (this.questId != null) {
/*  737 */         str = str + " quest: " + this.questId;
/*      */       }
/*  739 */       return str;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public enum Source
/*      */   {
/*      */     STOCK, LEVEL_STOCK, RESEARCH, TROPHY, LEVEL_QUEST, LEVEL_WAVE_QUEST, BASE_TILE, CORE_TILE, BOSS_TILE, GV_TILE, CUSTOM;
/*      */ 
/*      */ 
/*      */     
/*      */     public static final Source[] values = values();
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static final class GameValuesSnapshot
/*      */     implements KryoSerializable, GameValueProvider
/*      */   {
/*  768 */     public double[] values = new double[GameValueType.values.length];
/*      */     public int hash;
/*  770 */     public DelayedRemovalArray<GameValueManager.GameValueEffect> effects = new DelayedRemovalArray(GameValueManager.GameValueEffect.class);
/*      */ 
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/*  774 */       param1Output.writeInt(this.hash);
/*  775 */       param1Kryo.writeObject(param1Output, this.values);
/*  776 */       param1Kryo.writeObject(param1Output, this.effects);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/*  781 */       this.hash = param1Input.readInt();
/*  782 */       this.values = (double[])param1Kryo.readObject(param1Input, double[].class);
/*  783 */       this.effects = (DelayedRemovalArray<GameValueManager.GameValueEffect>)param1Kryo.readObject(param1Input, DelayedRemovalArray.class);
/*      */     }
/*      */     
/*      */     public GameValuesSnapshot() {}
/*      */     
/*      */     public GameValuesSnapshot(GameValuesSnapshot param1GameValuesSnapshot) {
/*  789 */       System.arraycopy(param1GameValuesSnapshot.values, 0, this.values, 0, this.values.length);
/*  790 */       this.hash = param1GameValuesSnapshot.hash;
/*  791 */       this.effects.addAll((Array)param1GameValuesSnapshot.effects);
/*      */     }
/*      */     
/*      */     public final void from(GameValuesSnapshot param1GameValuesSnapshot) {
/*  795 */       System.arraycopy(param1GameValuesSnapshot.values, 0, this.values, 0, this.values.length);
/*  796 */       this.hash = param1GameValuesSnapshot.hash;
/*  797 */       this.effects.clear();
/*  798 */       this.effects.addAll((Array)param1GameValuesSnapshot.effects);
/*      */     }
/*      */     
/*      */     public final String toJson() {
/*  802 */       StringWriter stringWriter = new StringWriter();
/*      */       Json json;
/*  804 */       (json = new Json(JsonWriter.OutputType.json)).setWriter(stringWriter);
/*  805 */       json.writeObjectStart();
/*  806 */       json.writeValue("hash", Integer.valueOf(this.hash));
/*  807 */       json.writeObjectStart("values");
/*  808 */       for (byte b = 0; b < this.values.length; b++) {
/*      */         double d;
/*  810 */         if ((d = this.values[b]) != 0.0D) {
/*  811 */           GameValueType gameValueType = GameValueType.values[b];
/*  812 */           json.writeValue(gameValueType.name(), Double.valueOf(d));
/*      */         } 
/*      */       } 
/*  815 */       json.writeObjectEnd();
/*      */       
/*  817 */       json.writeObjectEnd();
/*      */       
/*  819 */       return stringWriter.toString();
/*      */     }
/*      */     
/*      */     public static GameValuesSnapshot fromJson(String param1String) {
/*  823 */       JsonValue jsonValue = (new JsonReader()).parse(param1String);
/*      */       
/*      */       GameValuesSnapshot gameValuesSnapshot;
/*  826 */       (gameValuesSnapshot = new GameValuesSnapshot()).hash = jsonValue.getInt("hash");
/*  827 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.get("values").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*      */         try {
/*  829 */           GameValueType gameValueType = GameValueType.valueOf(jsonValue1.name);
/*  830 */           double d = jsonValue1.asDouble();
/*  831 */           gameValuesSnapshot.values[gameValueType.ordinal()] = d;
/*  832 */         } catch (Exception exception) {
/*  833 */           GameValueManager.a().e("failed to parse " + jsonValue1.toString(), new Object[0]);
/*      */         }  }
/*      */ 
/*      */       
/*  837 */       return gameValuesSnapshot;
/*      */     }
/*      */ 
/*      */     
/*      */     public final double getValue(GameValueType param1GameValueType) {
/*  842 */       return this.values[param1GameValueType.ordinal()];
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean getBooleanValue(GameValueType param1GameValueType) {
/*  847 */       return (this.values[param1GameValueType.ordinal()] != 0.0D);
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getIntValue(GameValueType param1GameValueType) {
/*  852 */       return (int)getValue(param1GameValueType);
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getIntValueSum(GameValueType param1GameValueType1, GameValueType param1GameValueType2) {
/*  857 */       return (int)(this.values[param1GameValueType1.ordinal()] + this.values[param1GameValueType2.ordinal()]);
/*      */     }
/*      */ 
/*      */     
/*      */     public final float getFloatValue(GameValueType param1GameValueType) {
/*  862 */       return (float)this.values[param1GameValueType.ordinal()];
/*      */     }
/*      */ 
/*      */     
/*      */     public final float getFloatValueSum(GameValueType param1GameValueType1, GameValueType param1GameValueType2) {
/*  867 */       return (float)(this.values[param1GameValueType1.ordinal()] + this.values[param1GameValueType2.ordinal()]);
/*      */     }
/*      */ 
/*      */     
/*      */     public final double getPercentValueAsMultiplier(GameValueType param1GameValueType) {
/*  872 */       return this.values[param1GameValueType.ordinal()] * 0.01D;
/*      */     }
/*      */ 
/*      */     
/*      */     public final double getPercentValueAsMultiplierSum(GameValueType param1GameValueType1, GameValueType param1GameValueType2) {
/*  877 */       return (this.values[param1GameValueType1.ordinal()] + this.values[param1GameValueType2.ordinal()]) * 0.01D;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final double getPercentValueAsMultiplierSumAll(GameValueType[] param1ArrayOfGameValueType) {
/*  883 */       double d = 0.0D; int i; byte b;
/*  884 */       for (i = (param1ArrayOfGameValueType = param1ArrayOfGameValueType).length, b = 0; b < i; ) { GameValueType gameValueType = param1ArrayOfGameValueType[b];
/*  885 */         d += this.values[gameValueType.ordinal()];
/*      */         b++; }
/*      */       
/*  888 */       return d * 0.01D;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/*      */       StringBuilder stringBuilder;
/*  895 */       (stringBuilder = new StringBuilder()).append("GameValuesSnapshot: {\n"); GameValueType[] arrayOfGameValueType; int i; byte b;
/*  896 */       for (i = (arrayOfGameValueType = GameValueType.values).length, b = 0; b < i; ) { GameValueType gameValueType = arrayOfGameValueType[b];
/*  897 */         stringBuilder.append("  ").append(gameValueType.name()).append(" = ").append(this.values[gameValueType.ordinal()]).append("\n"); b++; }
/*      */       
/*  899 */       stringBuilder.append("}");
/*      */       
/*  901 */       return stringBuilder.toString();
/*      */     }
/*      */     
/*      */     public final Array<GameValueManager.GvSnapDiff> getDifferences(GameValuesSnapshot param1GameValuesSnapshot) {
/*  905 */       Array<GameValueManager.GvSnapDiff> array = new Array(GameValueManager.GvSnapDiff.class);
/*      */       
/*  907 */       if (param1GameValuesSnapshot.hash != this.hash) {
/*  908 */         array.add(new GameValueManager.GvSnapDiff(GameValueManager.GvSnapDiff.Type.GLOBAL_HASH, this.hash, param1GameValuesSnapshot.hash));
/*      */       }
/*      */       
/*  911 */       for (byte b1 = 0; b1 < this.values.length; b1++) {
/*  912 */         if (this.values[b1] != param1GameValuesSnapshot.values[b1]) {
/*  913 */           array.add(new GameValueManager.GvSnapDiff(GameValueManager.GvSnapDiff.Type.GV_RESULT, this.values[b1], param1GameValuesSnapshot.values[b1]));
/*      */         }
/*      */       } 
/*      */       
/*  917 */       if (param1GameValuesSnapshot.effects.size != this.effects.size) {
/*  918 */         array.add(new GameValueManager.GvSnapDiff(GameValueManager.GvSnapDiff.Type.GV_COUNT, this.effects.size, param1GameValuesSnapshot.effects.size));
/*      */       }
/*      */       
/*  921 */       Array array1 = new Array(false, this.effects.size, GameValueManager.GameValueEffect.class); byte b2;
/*  922 */       for (b2 = 0; b2 < this.effects.size; b2++) {
/*  923 */         array1.add(new GameValueManager.GameValueEffect(((GameValueManager.GameValueEffect[])this.effects.items)[b2]));
/*      */       }
/*      */       
/*  926 */       for (b2 = 0; b2 < param1GameValuesSnapshot.effects.size; b2++) {
/*  927 */         GameValueManager.GameValueEffect gameValueEffect = ((GameValueManager.GameValueEffect[])param1GameValuesSnapshot.effects.items)[b2];
/*      */         
/*  929 */         boolean bool = false;
/*  930 */         for (byte b = 0; b < array1.size; b++) {
/*  931 */           if (((GameValueManager.GameValueEffect[])array1.items)[b].sameAs(gameValueEffect)) {
/*  932 */             array1.removeIndex(b);
/*  933 */             bool = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  938 */         if (!bool) {
/*  939 */           array.add(new GameValueManager.GvSnapDiff(GameValueManager.GvSnapDiff.Type.GV_NOT_IN_ORIG, gameValueEffect));
/*      */         }
/*      */       } 
/*      */       
/*  943 */       for (b2 = 0; b2 < array1.size; b2++) {
/*  944 */         array.add(new GameValueManager.GvSnapDiff(GameValueManager.GvSnapDiff.Type.GV_NOT_IN_TO, ((GameValueManager.GameValueEffect[])array1.items)[b2]));
/*      */       }
/*      */       
/*  947 */       return array;
/*      */     }
/*      */     
/*      */     public final void printDifferences(String param1String1, String param1String2, GameValuesSnapshot param1GameValuesSnapshot, StringBuilder param1StringBuilder) {
/*  951 */       if (param1GameValuesSnapshot.hash != this.hash) {
/*  952 */         param1StringBuilder.append("hash (")
/*  953 */           .append(param1String2)
/*  954 */           .append(") ")
/*  955 */           .append(String.valueOf(param1GameValuesSnapshot.hash))
/*  956 */           .append(" != (")
/*  957 */           .append(param1String1)
/*  958 */           .append(") ")
/*  959 */           .append(String.valueOf(this.hash))
/*  960 */           .append("\n");
/*      */       }
/*      */       
/*  963 */       for (byte b1 = 0; b1 < this.values.length; b1++) {
/*  964 */         if (this.values[b1] != param1GameValuesSnapshot.values[b1]) {
/*  965 */           param1StringBuilder.append("value ")
/*  966 */             .append(GameValueType.values[b1].name())
/*  967 */             .append(" ")
/*  968 */             .append(String.valueOf(param1GameValuesSnapshot.values[b1]))
/*  969 */             .append(" != ")
/*  970 */             .append(String.valueOf(this.values[b1]))
/*  971 */             .append("\n");
/*      */         }
/*      */       } 
/*      */       
/*  975 */       if (param1GameValuesSnapshot.effects.size != this.effects.size) {
/*  976 */         param1StringBuilder.append("effects count ")
/*  977 */           .append(String.valueOf(param1GameValuesSnapshot.effects.size))
/*  978 */           .append(" != ")
/*  979 */           .append(String.valueOf(this.effects.size))
/*  980 */           .append("\n");
/*      */       }
/*      */       
/*  983 */       Array array = new Array(false, this.effects.size, GameValueManager.GameValueEffect.class); byte b2;
/*  984 */       for (b2 = 0; b2 < this.effects.size; b2++) {
/*  985 */         array.add(new GameValueManager.GameValueEffect(((GameValueManager.GameValueEffect[])this.effects.items)[b2]));
/*      */       }
/*      */       
/*  988 */       for (b2 = 0; b2 < param1GameValuesSnapshot.effects.size; b2++) {
/*  989 */         GameValueManager.GameValueEffect gameValueEffect = ((GameValueManager.GameValueEffect[])param1GameValuesSnapshot.effects.items)[b2];
/*      */         
/*  991 */         boolean bool = false;
/*  992 */         for (byte b = 0; b < array.size; b++) {
/*  993 */           if (((GameValueManager.GameValueEffect[])array.items)[b].sameAs(gameValueEffect)) {
/*  994 */             array.removeIndex(b);
/*  995 */             bool = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1000 */         if (!bool) {
/* 1001 */           param1StringBuilder.append("not found effect in ").append(param1String1).append(": ")
/* 1002 */             .append(gameValueEffect.toString())
/* 1003 */             .append("\n");
/*      */         }
/*      */       } 
/*      */       
/* 1007 */       for (b2 = 0; b2 < array.size; b2++)
/* 1008 */         param1StringBuilder.append("not found effect in ").append(param1String2).append(": ")
/* 1009 */           .append(((GameValueManager.GameValueEffect[])array.items)[b2].toString())
/* 1010 */           .append("\n"); 
/*      */     }
/*      */   }
/*      */   
/*      */   private class _ResearchManagerListener extends ResearchManager.ResearchManagerListener.ResearchManagerListenerAdapter {
/*      */     private _ResearchManagerListener(GameValueManager this$0) {}
/*      */     
/*      */     public void researchesUpdated() {
/* 1018 */       this.a.requireRecalculation();
/*      */     }
/*      */   }
/*      */   
/*      */   private class _ProgressManagerListener extends ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter { private _ProgressManagerListener(GameValueManager this$0) {}
/*      */     
/*      */     public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 1025 */       if (param1Item.getType() == ItemType.TROPHY)
/* 1026 */         this.a.requireRecalculation(); 
/*      */     } }
/*      */   public static class GvSnapDiff { public Type type;
/*      */     public double vOrig;
/*      */     public double vTo;
/*      */     public GameValueManager.GameValueEffect effect;
/*      */     
/* 1033 */     public enum Type { GLOBAL_HASH,
/* 1034 */       GV_COUNT,
/* 1035 */       GV_RESULT,
/* 1036 */       GV_NOT_IN_ORIG,
/* 1037 */       GV_NOT_IN_TO; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public GvSnapDiff(Type param1Type, double param1Double1, double param1Double2) {
/* 1046 */       this.type = param1Type;
/* 1047 */       this.vOrig = param1Double1;
/* 1048 */       this.vTo = param1Double2;
/*      */     }
/*      */     
/*      */     public GvSnapDiff(Type param1Type, GameValueManager.GameValueEffect param1GameValueEffect) {
/* 1052 */       this.type = param1Type;
/* 1053 */       this.effect = param1GameValueEffect;
/*      */     } }
/*      */ 
/*      */   
/*      */   public enum Type {
/*      */     GLOBAL_HASH, GV_COUNT, GV_RESULT, GV_NOT_IN_ORIG, GV_NOT_IN_TO;
/*      */   }
/*      */   
/*      */   public static interface GameValueManagerListener {
/*      */     void gameValuesRecalculated();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\GameValueManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */