/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.BasicLevelStage;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_DailyQuest;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.tiles.TargetTile;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ 
/*      */ @REGS(serializer = DailyQuestManager.Serializer.class)
/*      */ public class DailyQuestManager extends Manager.ManagerAdapter {
/*      */   public static final String LEVEL_NAME_PREFIX = "DQ";
/*   50 */   private static final TLog a = TLog.forClass(DailyQuestManager.class); public static final String RESET_QUESTS_QUEST_ID = "_resetQuests";
/*      */   private DailyQuestLevel b;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<DailyQuestManager> { public DailyQuestManager read() {
/*   54 */       return Game.i.dailyQuestManager;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   63 */   private final Date c = new Date();
/*   64 */   private static final Calendar d = Calendar.getInstance(TimeZone.getTimeZone("GMT")); private static final SimpleDateFormat e;
/*      */   
/*      */   static {
/*   67 */     (e = new SimpleDateFormat("yyyy-MM-dd", Locale.US)).setTimeZone(TimeZone.getTimeZone("GMT"));
/*      */   }
/*      */   
/*   70 */   private final DelayedRemovalArray<DailyQuestLeaderboards> f = new DelayedRemovalArray(DailyQuestLeaderboards.class);
/*      */   
/*      */   public int dailyLootMinBonusPerMonth;
/*      */   
/*      */   public int dailyLootMaxBonusPerMonth;
/*   75 */   public Array<DailyLootDayConfig> dailyLootDayConfigs = new Array(DailyLootDayConfig.class);
/*      */   
/*   77 */   private static final StringBuilder g = new StringBuilder();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDailyLootCurrentDayIndex() {
/*   97 */     d();
/*      */     
/*   99 */     return (ProgressPrefs.i()).dailyQuest.getDailyLootCurrentDayIndex();
/*      */   }
/*      */   
/*      */   public int getDailyLootCurrentMonthIndex() {
/*  103 */     return (ProgressPrefs.i()).dailyQuest.getDailyLootCurrentDayIndex() / this.dailyLootDayConfigs.size;
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
/*      */   private void d() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: invokevirtual getCurrentDayDate : ()Ljava/lang/String;
/*      */     //   4: astore_1
/*      */     //   5: iconst_0
/*      */     //   6: istore_2
/*      */     //   7: invokestatic i : ()Lcom/prineside/tdi2/managers/preferences/categories/ProgressPrefs;
/*      */     //   10: getfield dailyQuest : Lcom/prineside/tdi2/managers/preferences/categories/progress/PP_DailyQuest;
/*      */     //   13: dup
/*      */     //   14: astore_3
/*      */     //   15: invokevirtual getDailyLootCurrentDay : ()Ljava/lang/String;
/*      */     //   18: ifnull -> 69
/*      */     //   21: aload_3
/*      */     //   22: invokevirtual getDailyLootCurrentDay : ()Ljava/lang/String;
/*      */     //   25: aload_1
/*      */     //   26: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   29: ifne -> 71
/*      */     //   32: aload_3
/*      */     //   33: invokevirtual getDailyLootLastCompletedDay : ()Ljava/lang/String;
/*      */     //   36: ifnull -> 69
/*      */     //   39: aload_3
/*      */     //   40: invokevirtual getDailyLootLastCompletedDay : ()Ljava/lang/String;
/*      */     //   43: aload_3
/*      */     //   44: invokevirtual getDailyLootCurrentDay : ()Ljava/lang/String;
/*      */     //   47: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   50: ifeq -> 69
/*      */     //   53: aload_3
/*      */     //   54: dup
/*      */     //   55: invokevirtual getDailyLootCurrentDayIndex : ()I
/*      */     //   58: iconst_1
/*      */     //   59: iadd
/*      */     //   60: invokevirtual setDailyLootCurrentDayIndex : (I)V
/*      */     //   63: invokestatic i : ()Lcom/prineside/tdi2/managers/preferences/categories/ProgressPrefs;
/*      */     //   66: invokevirtual requireSave : ()V
/*      */     //   69: iconst_1
/*      */     //   70: istore_2
/*      */     //   71: iload_2
/*      */     //   72: ifne -> 82
/*      */     //   75: aload_3
/*      */     //   76: invokevirtual getDailyLootCurrentQuest : ()Ljava/lang/String;
/*      */     //   79: ifnonnull -> 100
/*      */     //   82: aload_3
/*      */     //   83: aload_1
/*      */     //   84: invokevirtual setDailyLootCurrentDay : (Ljava/lang/String;)V
/*      */     //   87: aload_3
/*      */     //   88: invokestatic e : ()Ljava/lang/String;
/*      */     //   91: invokevirtual setDailyLootCurrentQuest : (Ljava/lang/String;)V
/*      */     //   94: invokestatic i : ()Lcom/prineside/tdi2/managers/preferences/categories/ProgressPrefs;
/*      */     //   97: invokevirtual requireSave : ()V
/*      */     //   100: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #110	-> 0
/*      */     //   #111	-> 5
/*      */     //   #112	-> 7
/*      */     //   #114	-> 14
/*      */     //   #117	-> 21
/*      */     //   #119	-> 32
/*      */     //   #121	-> 53
/*      */     //   #122	-> 63
/*      */     //   #124	-> 69
/*      */     //   #127	-> 71
/*      */     //   #128	-> 82
/*      */     //   #129	-> 87
/*      */     //   #130	-> 94
/*      */     //   #132	-> 100
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
/*      */   public String getDailyLootCurrentQuest() {
/*  135 */     d();
/*      */     PP_DailyQuest pP_DailyQuest;
/*  137 */     if ((pP_DailyQuest = (ProgressPrefs.i()).dailyQuest).getDailyLootCurrentQuest() == null) {
/*      */       
/*  139 */       pP_DailyQuest.setDailyLootCurrentQuest(e());
/*  140 */       ProgressPrefs.i().requireSave();
/*  141 */       Preconditions.checkNotNull(pP_DailyQuest.getDailyLootCurrentQuest(), "getDailyLootRandomQuest() returned null");
/*      */     } 
/*      */     
/*  144 */     return pP_DailyQuest.getDailyLootCurrentQuest();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public int getDailyLootDaysInRow() {
/*  149 */     d();
/*      */     
/*  151 */     return (ProgressPrefs.i()).dailyQuest.getDailyLootDaysInRow();
/*      */   }
/*      */   
/*      */   public int getSecondsTillNextDailyLoot() {
/*  155 */     d();
/*      */     
/*  157 */     long l1 = System.currentTimeMillis();
/*  158 */     d.setTimeInMillis(l1);
/*  159 */     d.set(11, 0);
/*  160 */     d.set(12, 0);
/*  161 */     d.set(13, 0);
/*  162 */     d.set(14, 0);
/*  163 */     long l2 = l1 - d.getTimeInMillis();
/*      */     
/*  165 */     return 86400 - (int)(l2 / 1000L);
/*      */   }
/*      */   
/*      */   public boolean isTodayDailyLootQuestCompleted() {
/*  169 */     d();
/*      */     
/*  171 */     return getCurrentDayDate().equals((ProgressPrefs.i()).dailyQuest.getDailyLootLastCompletedDay());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IssuedItems setDailyLootQuestCompleted() {
/*  178 */     String str = getCurrentDayDate();
/*      */     PP_DailyQuest pP_DailyQuest;
/*  180 */     if ((pP_DailyQuest = (ProgressPrefs.i()).dailyQuest).getDailyLootLastCompletedDay() != null && pP_DailyQuest.getDailyLootLastCompletedDay().equals(str)) return null;
/*      */     
/*  182 */     pP_DailyQuest.setDailyLootLastCompletedDay(str);
/*  183 */     ProgressPrefs.i().requireSave();
/*      */     
/*      */     DailyLootDayConfig dailyLootDayConfig;
/*  186 */     int i = (dailyLootDayConfig = ((DailyLootDayConfig[])this.dailyLootDayConfigs.items)[pP_DailyQuest.getDailyLootCurrentDayIndex() % this.dailyLootDayConfigs.size]).getCount(pP_DailyQuest.getDailyLootCurrentDayIndex() / this.dailyLootDayConfigs.size);
/*      */     
/*      */     IssuedItems issuedItems;
/*  189 */     (issuedItems = new IssuedItems(IssuedItems.IssueReason.DAILY_LOOT, Game.getTimestampSeconds())).dailyLootDate = str;
/*      */     
/*  191 */     issuedItems.items.add(new ItemStack(dailyLootDayConfig.item, i));
/*  192 */     Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  193 */     Game.i.progressManager.addItemArray(issuedItems.items, "daily_loot");
/*      */     
/*  195 */     return issuedItems;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String e() {
/*  202 */     Array array = new Array(); byte b;
/*  203 */     for (b = 0; b < Game.i.basicLevelManager.stagesOrdered.size; b++) {
/*      */       BasicLevelStage basicLevelStage;
/*  205 */       if ((basicLevelStage = ((BasicLevelStage[])Game.i.basicLevelManager.stagesOrdered.items)[b]).regular) {
/*  206 */         for (byte b1 = 0; b1 < basicLevelStage.levels.size; b1++) {
/*      */           BasicLevel basicLevel;
/*  208 */           if (!(basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[b1]).fixedQuests)
/*      */           {
/*  210 */             if (Game.i.basicLevelManager.isOpened(basicLevel) && Game.i.basicLevelManager.isLevelVisible(basicLevel)) {
/*  211 */               for (byte b2 = 0; b2 < basicLevel.quests.size; b2++) {
/*  212 */                 if (!((BasicLevelQuestConfig[])basicLevel.quests.items)[b2].isCompleted()) {
/*  213 */                   array.add((((BasicLevelQuestConfig[])basicLevel.quests.items)[b2]).id);
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             }
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  222 */     if (array.size == 0) {
/*      */       
/*  224 */       for (b = 0; b < Game.i.basicLevelManager.stagesOrdered.size; b++) {
/*      */         BasicLevelStage basicLevelStage;
/*  226 */         if ((basicLevelStage = ((BasicLevelStage[])Game.i.basicLevelManager.stagesOrdered.items)[b]).regular) {
/*  227 */           for (byte b1 = 0; b1 < basicLevelStage.levels.size; b1++) {
/*  228 */             BasicLevel basicLevel = ((BasicLevel[])basicLevelStage.levels.items)[b1];
/*  229 */             for (byte b2 = 0; b2 < basicLevel.quests.size; b2++) {
/*  230 */               if (!((BasicLevelQuestConfig[])basicLevel.quests.items)[b2].isCompleted()) {
/*  231 */                 return (((BasicLevelQuestConfig[])basicLevel.quests.items)[b2]).id;
/*      */               }
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  238 */       return "_resetQuests";
/*      */     } 
/*      */     
/*  241 */     if (array.size > 3) {
/*  242 */       return (String)array.get(FastRandom.getFairInt(array.size / 2 - 1));
/*      */     }
/*  244 */     return (String)array.random();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setup() {
/*  251 */     JsonValue jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/daily-loot.json"));
/*  252 */     this.dailyLootMinBonusPerMonth = jsonValue.getInt("minBonusPerMonth");
/*  253 */     this.dailyLootMaxBonusPerMonth = jsonValue.getInt("maxBonusPerMonth");
/*  254 */     this.dailyLootDayConfigs.clear();
/*  255 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.get("days").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  256 */       this.dailyLootDayConfigs.add(DailyLootDayConfig.fromJson(jsonValue1)); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DailyQuestLevel f() {
/*      */     int i;
/*  265 */     String str = getCurrentDayDate();
/*      */     
/*      */     PP_DailyQuest pP_DailyQuest;
/*      */     
/*  269 */     if ((pP_DailyQuest = (ProgressPrefs.i()).dailyQuest).getLastLoadedQuestDate() != null && pP_DailyQuest.getLastLoadedQuestDate().equals(str)) {
/*      */       
/*  271 */       i = pP_DailyQuest.getLastLoadedQuestId();
/*      */     } else {
/*      */       
/*  274 */       Array array = new Array();
/*  275 */       for (Array.ArrayIterator<BasicLevel> arrayIterator = Game.i.basicLevelManager.levelsOrdered.iterator(); arrayIterator.hasNext();) {
/*  276 */         if ((basicLevel = arrayIterator.next()).dailyQuest) {
/*  277 */           array.add(basicLevel.name);
/*      */         }
/*      */       } 
/*      */       
/*      */       String str1;
/*  282 */       i = Integer.parseInt((str1 = (String)array.random()).substring(2));
/*  283 */       if (pP_DailyQuest.getLastLoadedQuestDate() != null && pP_DailyQuest.getLastLoadedQuestId() == i && array.size > 1) {
/*      */         String str2;
/*      */         
/*  286 */         i = Integer.parseInt((str2 = (String)array.random()).substring(2));
/*  287 */         a.i("quest " + str1 + " was selected for the last time, fallback to " + str2, new Object[0]);
/*      */       } 
/*  289 */       a.i("selected quest " + i + " out of " + array.size, new Object[0]);
/*      */     } 
/*      */     
/*      */     DailyQuestLevel dailyQuestLevel;
/*  293 */     (dailyQuestLevel = new DailyQuestLevel()).setForDate(str);
/*  294 */     dailyQuestLevel.questId = i;
/*      */     try {
/*  296 */       dailyQuestLevel.endTimestamp = (int)(e.parse(getNextDayDate()).getTime() / 1000L);
/*  297 */     } catch (ParseException parseException) {}
/*  298 */     DailyQuestLevel.a(dailyQuestLevel, "DQ" + i);
/*  299 */     dailyQuestLevel.isLocalFallback = true;
/*      */ 
/*      */     
/*  302 */     pP_DailyQuest.setLastLoadedQuestDate(str);
/*  303 */     pP_DailyQuest.setLastLoadedQuestId(i);
/*  304 */     ProgressPrefs.i().requireSave();
/*      */     
/*  306 */     return dailyQuestLevel;
/*      */   }
/*      */   
/*      */   public String getCurrentDayDate() {
/*  310 */     long l = Game.getTimestampMillis();
/*  311 */     this.c.setTime(l);
/*  312 */     return e.format(this.c);
/*      */   }
/*      */   
/*      */   public String getNextDayDate() {
/*  316 */     long l = Game.getTimestampMillis() + 86400000L;
/*  317 */     this.c.setTime(l);
/*  318 */     return e.format(this.c);
/*      */   }
/*      */   
/*      */   public DailyQuestLevel getDailyQuestLevelCache() {
/*  322 */     String str = getCurrentDayDate();
/*      */     
/*  324 */     if (this.b != null && !this.b.getForDate().equals(str))
/*      */     {
/*  326 */       this.b = null;
/*      */     }
/*      */     
/*  329 */     if (this.b != null && !this.b.isLocalFallback)
/*      */     {
/*  331 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*  335 */     this.b = f();
/*      */     
/*  337 */     return this.b;
/*      */   }
/*      */   
/*      */   public void getDailyQuestHashFromServer(int paramInt, ObjectConsumer<String> paramObjectConsumer) {
/*      */     Net.HttpRequest httpRequest;
/*  342 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_DAILY_QUEST_HASH_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/*  345 */     (hashMap = new HashMap<>()).put("id", paramInt);
/*  346 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  348 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer) {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*  350 */             String str = param1HttpResponse.getResultAsString();
/*      */             try {
/*      */               JsonValue jsonValue;
/*  353 */               if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*      */                 
/*  355 */                 String str1 = jsonValue.getString("hash");
/*  356 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1String));
/*      */               } else {
/*  358 */                 DailyQuestManager.a().e("failed to get daily quest hash: " + str, new Object[0]);
/*  359 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null)); return;
/*      */               } 
/*  361 */             } catch (Exception exception) {
/*  362 */               DailyQuestManager.a().e("failed to get daily quest hash: " + str, new Object[] { exception });
/*  363 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */             } 
/*      */           }
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/*  368 */             DailyQuestManager.a().e("Error while getting daily quest hash", new Object[] { param1Throwable });
/*  369 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */           }
/*      */           
/*      */           public void cancelled() {
/*  373 */             DailyQuestManager.a().e("Timeout while getting daily quest", new Object[0]);
/*  374 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getCurrentDayLevel(ObjectConsumer<DailyQuestLevel> paramObjectConsumer) {
/*  385 */     String str = getCurrentDayDate();
/*      */     
/*  387 */     if (this.b != null && !this.b.getForDate().equals(str))
/*      */     {
/*  389 */       this.b = null;
/*      */     }
/*      */     
/*  392 */     if (this.b != null && !this.b.isLocalFallback) {
/*      */       
/*  394 */       paramObjectConsumer.accept(this.b);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  399 */     a.i("requesting from server", new Object[0]);
/*  400 */     this.b = f();
/*      */     try {
/*      */       Net.HttpRequest httpRequest;
/*  403 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_DAILY_QUEST_INFO_URL);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  409 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer) {
/*      */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */               try {
/*  412 */                 String str = param1HttpResponse.getResultAsString();
/*      */ 
/*      */                 
/*      */                 JsonValue jsonValue;
/*      */                 
/*  417 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*      */                   
/*  419 */                   Threads.i().runOnMainThread(() -> {
/*      */                         try {
/*      */                           if ((param1JsonValue = param1JsonValue.get("data")).getInt("min_build") > 207) {
/*      */                             Notifications.i().add(Game.i.localeManager.i18n.get("game_needs_update_for_daily_quests"), null, MaterialColor.ORANGE.P800, null);
/*      */                             
/*      */                             param1ObjectConsumer.accept(DailyQuestManager.a(this.b));
/*      */                             
/*      */                             return;
/*      */                           } 
/*      */                           
/*      */                           DailyQuestManager.DailyQuestLevel dailyQuestLevel;
/*      */                           
/*      */                           (dailyQuestLevel = new DailyQuestManager.DailyQuestLevel()).setForDate(param1JsonValue.getString("date"));
/*      */                           
/*      */                           dailyQuestLevel.endTimestamp = param1JsonValue.getInt("end_timestamp");
/*      */                           
/*      */                           if (Game.getTimestampSeconds() - 60 > dailyQuestLevel.endTimestamp || Game.getTimestampSeconds() + 60 < dailyQuestLevel.endTimestamp - 86400) {
/*      */                             Notifications.i().add("Error: incorrect device time", null, MaterialColor.ORANGE.P800, null);
/*      */                             
/*      */                             param1ObjectConsumer.accept(DailyQuestManager.a(this.b));
/*      */                             
/*      */                             return;
/*      */                           } 
/*      */                           
/*      */                           JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.get("prize_first_place").iterator();
/*      */                           
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             
/*      */                             dailyQuestLevel.prizesFirstPlace.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           
/*      */                           jsonIterator = param1JsonValue.get("prize_second_place").iterator();
/*      */                           
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             
/*      */                             dailyQuestLevel.prizesSecondPlace.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           
/*      */                           jsonIterator = param1JsonValue.get("prize_third_place").iterator();
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             dailyQuestLevel.prizesThirdPlace.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           jsonIterator = param1JsonValue.get("prize_top_3_percent").iterator();
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             dailyQuestLevel.prizesTop3Percent.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           jsonIterator = param1JsonValue.get("prize_top_10_percent").iterator();
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             dailyQuestLevel.prizesTop10Percent.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           jsonIterator = param1JsonValue.get("prize_top_30_percent").iterator();
/*      */                           while (jsonIterator.hasNext()) {
/*      */                             JsonValue jsonValue = jsonIterator.next();
/*      */                             dailyQuestLevel.prizesTop30Percent.add(ItemStack.fromJson(jsonValue));
/*      */                           } 
/*      */                           int i = param1JsonValue.getInt("daily_quest");
/*      */                           dailyQuestLevel.questId = i;
/*      */                           String str = this.b.getDailyQuestHash(i);
/*      */                           if (!param1JsonValue.getString("data_hash").equals(str)) {
/*      */                             DailyQuestManager.a().i("loaded DQ " + i + " hash differ, loading from server", new Object[0]);
/*      */                             this.b.loadAndStoreDailyQuestFromServer(i, ());
/*      */                           } else {
/*      */                             DailyQuestManager.DailyQuestLevel.a(dailyQuestLevel, (Game.i.basicLevelManager.getLevel("DQ" + i)).name);
/*      */                             DailyQuestManager.a(this.b, dailyQuestLevel);
/*      */                             param1ObjectConsumer.accept(dailyQuestLevel);
/*      */                             return;
/*      */                           } 
/*  491 */                         } catch (Exception exception) {
/*      */                           DailyQuestManager.a().e("failed to parse daily quest map", new Object[] { exception });
/*      */                           
/*      */                           param1ObjectConsumer.accept(DailyQuestManager.a(this.b));
/*      */                         } 
/*      */                       });
/*      */                 } else {
/*  498 */                   DailyQuestManager.a().e("can't retrieve daily quest: " + str, new Object[0]);
/*  499 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(DailyQuestManager.a(this.b))); return;
/*      */                 } 
/*  501 */               } catch (Exception exception) {
/*  502 */                 DailyQuestManager.a().e("Failed to parse response", new Object[] { exception });
/*  503 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(DailyQuestManager.a(this.b)));
/*      */               } 
/*      */             }
/*      */             
/*      */             public void failed(Throwable param1Throwable) {
/*  508 */               DailyQuestManager.a().e("Error while getting daily quest", new Object[] { param1Throwable });
/*  509 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(DailyQuestManager.a(this.b)));
/*      */             }
/*      */             
/*      */             public void cancelled() {
/*  513 */               DailyQuestManager.a().e("Timeout while getting daily quest", new Object[0]);
/*  514 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(DailyQuestManager.a(this.b))); }
/*      */           });
/*      */       return;
/*  517 */     } catch (Exception exception) {
/*      */       
/*  519 */       a.e("Failed to get daily quest", new Object[] { exception });
/*  520 */       Threads.i().runOnMainThread(() -> paramObjectConsumer.accept(this.b));
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDailyQuestHash(int paramInt) {
/*      */     FileHandle fileHandle;
/*  529 */     if (!(fileHandle = Gdx.files.local("levels/DQ" + paramInt + ".json")).exists())
/*      */     {
/*  531 */       fileHandle = Gdx.files.internal("levels/DQ" + paramInt + ".json");
/*      */     }
/*      */     
/*  534 */     if (fileHandle.exists()) {
/*  535 */       String str = "";
/*      */       FileHandle fileHandle1;
/*  537 */       if ((fileHandle1 = Gdx.files.local("levels/maps/DQ" + paramInt + ".json")).exists()) {
/*  538 */         str = fileHandle1.readString("UTF-8");
/*      */       }
/*  540 */       return StringFormatter.md5Hash("{\"configuration\":" + fileHandle
/*  541 */           .readString("UTF-8") + ",\"map\":" + str + "}");
/*      */     } 
/*      */ 
/*      */     
/*  545 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeLoadedDailyQuestMapIfMd5HashDiffers(int paramInt, String paramString) {
/*      */     FileHandle fileHandle;
/*  552 */     if ((fileHandle = Gdx.files.local("levels/DQ" + paramInt + ".json")).exists()) {
/*  553 */       String str = "";
/*      */       FileHandle fileHandle1;
/*  555 */       if ((fileHandle1 = Gdx.files.local("levels/maps/DQ" + paramInt + ".json")).exists()) {
/*  556 */         str = fileHandle1.readString("UTF-8");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  562 */       if (!(str = StringFormatter.md5Hash("{\"configuration\":" + fileHandle.readString("UTF-8") + ",\"map\":" + str + "}")).equals(paramString)) {
/*  563 */         a.i("hash mismatch for quest level " + paramInt + " on disk, removing", new Object[0]);
/*  564 */         fileHandle.delete();
/*  565 */         if (fileHandle1.exists()) fileHandle1.delete(); 
/*  566 */         Game.i.basicLevelManager.unloadLevel("DQ" + paramInt);
/*      */       } else {
/*  568 */         a.i("hash match for quest level " + paramInt + " on disk", new Object[0]); return;
/*      */       } 
/*      */     } else {
/*  571 */       a.i("local DQ config not exists", new Object[0]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadAndStoreDailyQuestFromServer(int paramInt, ObjectConsumer<BasicLevel> paramObjectConsumer) {
/*      */     Net.HttpRequest httpRequest;
/*  580 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_DAILY_QUEST_MAP_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/*  583 */     (hashMap = new HashMap<>()).put("id", String.valueOf(paramInt));
/*  584 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  586 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer, paramInt) {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */             try {
/*  589 */               String str = param1HttpResponse.getResultAsString();
/*      */               
/*      */               JsonValue jsonValue;
/*  592 */               if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*      */                 
/*  594 */                 Threads.i().runOnMainThread(() -> {
/*      */                       long l = Game.getRealTickCount();
/*      */ 
/*      */                       
/*      */                       try {
/*      */                         String str = (param1JsonValue = param1JsonValue.get("data")).get("configuration").getString("name");
/*      */ 
/*      */                         
/*      */                         Gdx.files.local("levels/" + str + ".json").writeString(param1JsonValue.get("configuration").toJson(JsonWriter.OutputType.json), false, "UTF-8");
/*      */ 
/*      */                         
/*      */                         Gdx.files.local("levels/maps/" + str + ".json").writeString(param1JsonValue.get("map").toJson(JsonWriter.OutputType.json), false, "UTF-8");
/*      */                         
/*      */                         Game.i.basicLevelManager.loadAndRegisterLevelFromJson(param1JsonValue.get("configuration"));
/*      */                         
/*      */                         param1ObjectConsumer.accept(Game.i.basicLevelManager.getLevel("DQ" + param1Int));
/*  610 */                       } catch (Exception exception) {
/*      */                         DailyQuestManager.a().e("failed to store daily quest map", new Object[] { exception });
/*      */                         param1ObjectConsumer.accept(null);
/*      */                       } 
/*      */                       if (Game.i.debugManager != null)
/*      */                         Game.i.debugManager.registerFrameJob("DailyQuestManager-storeDQ", Game.getRealTickCount() - l); 
/*      */                     });
/*      */               } else {
/*  618 */                 DailyQuestManager.a().e("failed to get daily quest map: " + str, new Object[0]);
/*  619 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null)); return;
/*      */               } 
/*  621 */             } catch (Exception exception) {
/*  622 */               DailyQuestManager.a().e("failed to parse daily quest map", new Object[] { exception });
/*  623 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/*  629 */             DailyQuestManager.a().e("failed to get daily quest map", new Object[] { param1Throwable });
/*  630 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */           }
/*      */ 
/*      */           
/*      */           public void cancelled() {
/*  635 */             DailyQuestManager.a().e("failed (cancelled) to get daily quest map", new Object[0]);
/*  636 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(null));
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void setLastCompletedDailyQuestTimestamp(int paramInt) {
/*  642 */     (ProgressPrefs.i()).dailyQuest.setLastCompletedDailyQuestTimestamp(paramInt);
/*  643 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */   
/*      */   public void startDailyLevel() {
/*  647 */     getCurrentDayLevel(this::a);
/*      */   }
/*      */   
/*      */   private void a(DailyQuestLevel paramDailyQuestLevel) {
/*  651 */     if (!paramDailyQuestLevel.wasCompleted()) {
/*      */       
/*  653 */       BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(paramDailyQuestLevel.getLevelName()); byte b;
/*  654 */       for (b = 0; b < basicLevel.quests.size; b++) {
/*      */         BasicLevelQuestConfig basicLevelQuestConfig;
/*  656 */         if ((basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(b)).isCompleted()) {
/*  657 */           basicLevelQuestConfig.setCompleted(false);
/*      */         }
/*      */       } 
/*  660 */       for (b = 0; b < basicLevel.waveQuests.size; b++) {
/*      */         BasicLevel.WaveQuest waveQuest;
/*  662 */         if ((waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b)).isCompleted()) {
/*  663 */           waveQuest.setCompleted(false);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  668 */     Game.i.screenManager.startNewDailyLevel(paramDailyQuestLevel);
/*      */   }
/*      */ 
/*      */   
/*      */   public void getLeaderboards(String paramString, ObjectConsumer<DailyQuestLeaderboards> paramObjectConsumer) {
/*  673 */     null = new DailyQuestLeaderboards(false, paramString, Game.i.authManager.getPlayerId());
/*  674 */     synchronized (this.f) {
/*  675 */       this.f.begin();
/*  676 */       for (byte b = 0; b < this.f.size; b++) {
/*  677 */         DailyQuestLeaderboards dailyQuestLeaderboards = ((DailyQuestLeaderboards[])this.f.items)[b];
/*  678 */         if (Game.getTimestampSeconds() - dailyQuestLeaderboards.requestTimestamp > 30) {
/*      */           
/*  680 */           this.f.removeIndex(b);
/*      */         }
/*  682 */         else if (dailyQuestLeaderboards.date.equals(paramString) && ((
/*  683 */           !Game.i.authManager.isSignedIn() && dailyQuestLeaderboards.playerId == null) || (Game.i.authManager.isSignedIn() && dailyQuestLeaderboards.playerId != null && dailyQuestLeaderboards.playerId.equals(Game.i.authManager.getPlayerId())))) {
/*      */ 
/*      */           
/*  686 */           paramObjectConsumer.accept(dailyQuestLeaderboards);
/*      */ 
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  696 */       this.f.end();
/*      */     } 
/*  698 */     Object object = SYNTHETIC_LOCAL_VARIABLE_3;
/*      */     
/*      */     try {
/*      */       Net.HttpRequest httpRequest;
/*  702 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_DAILY_QUEST_LEADERBOARDS_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/*  705 */       (hashMap = new HashMap<>()).put("date", paramString);
/*      */       
/*  707 */       String str = null;
/*  708 */       if (Game.i.authManager.isSignedIn() && (
/*      */         
/*  710 */         str = Game.i.authManager.getPlayerId()) != null) hashMap.put("playerid", str);
/*      */       
/*  712 */       str = str;
/*      */       
/*  714 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*  715 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramString, str, paramObjectConsumer, (DailyQuestLeaderboards)object) {
/*      */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */               try {
/*  718 */                 String str = param1HttpResponse.getResultAsString();
/*      */ 
/*      */                 
/*      */                 JsonValue jsonValue;
/*      */                 
/*  723 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*      */                   
/*  725 */                   null = new DailyQuestManager.DailyQuestLeaderboards(true, this.a, this.b);
/*      */                   
/*  727 */                   if (jsonValue.has("player")) {
/*  728 */                     JsonValue jsonValue2 = jsonValue.get("player");
/*  729 */                     null.player = new DailyQuestManager.LeaderboardsRank(true, false, this.a, this.b, (byte)0);
/*  730 */                     null.player.total = jsonValue2.getInt("total");
/*  731 */                     null.player.rank = jsonValue2.getInt("rank");
/*  732 */                     null.player.score = jsonValue2.getLong("score");
/*      */                   } 
/*      */                   
/*  735 */                   JsonValue jsonValue1 = jsonValue.get("leaderboards");
/*  736 */                   byte b = 1;
/*  737 */                   for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue2 = jsonIterator.next();
/*  738 */                     null.entries.add(new LeaderBoardManager.LeaderboardsEntry(jsonValue2
/*  739 */                           .getString("playerid"), jsonValue2
/*  740 */                           .getString("nickname"), jsonValue2
/*  741 */                           .getLong("score"), b++, jsonValue2
/*      */                           
/*  743 */                           .getBoolean("hasPfp", false), jsonValue2
/*  744 */                           .getInt("level", 1))); }
/*      */ 
/*      */ 
/*      */                   
/*  748 */                   synchronized (DailyQuestManager.b(this.e)) {
/*  749 */                     DailyQuestManager.b(this.e).add(null);
/*      */                   } 
/*  751 */                   DailyQuestManager.a().i("lb cache - stored " + ((DailyQuestManager.DailyQuestLeaderboards)str).date + " " + ((DailyQuestManager.DailyQuestLeaderboards)str).playerId + " ", new Object[0]);
/*      */                   
/*  753 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1DailyQuestLeaderboards));
/*      */                 } else {
/*      */                   
/*  756 */                   DailyQuestManager.a().e("can't retrieve leaderboards: " + str, new Object[0]);
/*  757 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1DailyQuestLeaderboards)); return;
/*      */                 } 
/*  759 */               } catch (Exception exception) {
/*  760 */                 DailyQuestManager.a().e("Failed to parse response", new Object[] { exception });
/*  761 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1DailyQuestLeaderboards));
/*      */               } 
/*      */             }
/*      */             public void failed(Throwable param1Throwable) {
/*  765 */               DailyQuestManager.a().e("Error while getting leaderboards", new Object[] { param1Throwable });
/*  766 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1DailyQuestLeaderboards));
/*      */             }
/*      */             
/*  769 */             public void cancelled() { DailyQuestManager.a().e("Timeout while getting leaderboards", new Object[0]);
/*  770 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1DailyQuestLeaderboards)); }
/*      */           });
/*      */       return;
/*  773 */     } catch (Exception exception) {
/*      */       
/*  775 */       a.e("Failed to get leaderboards", new Object[] { exception });
/*  776 */       paramObjectConsumer.accept(object);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @REGS
/*      */   public static class DailyQuestLevel
/*      */     implements KryoSerializable
/*      */   {
/*      */     public boolean isLocalFallback;
/*      */     
/*      */     public int questId;
/*      */     private String a;
/*      */     public String forDate;
/*      */     public int forDateTimestamp;
/*      */     public int endTimestamp;
/*  793 */     public Array<ItemStack> prizesFirstPlace = new Array(ItemStack.class);
/*  794 */     public Array<ItemStack> prizesSecondPlace = new Array(ItemStack.class);
/*  795 */     public Array<ItemStack> prizesThirdPlace = new Array(ItemStack.class);
/*  796 */     public Array<ItemStack> prizesTop3Percent = new Array(ItemStack.class);
/*  797 */     public Array<ItemStack> prizesTop10Percent = new Array(ItemStack.class);
/*  798 */     public Array<ItemStack> prizesTop30Percent = new Array(ItemStack.class);
/*      */ 
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/*  802 */       param1Output.writeBoolean(this.isLocalFallback);
/*  803 */       param1Output.writeInt(this.questId);
/*  804 */       param1Kryo.writeObjectOrNull(param1Output, this.a, String.class);
/*  805 */       param1Kryo.writeObjectOrNull(param1Output, this.forDate, String.class);
/*  806 */       param1Output.writeInt(this.forDateTimestamp);
/*  807 */       param1Output.writeInt(this.endTimestamp);
/*  808 */       param1Kryo.writeObject(param1Output, this.prizesFirstPlace);
/*  809 */       param1Kryo.writeObject(param1Output, this.prizesSecondPlace);
/*  810 */       param1Kryo.writeObject(param1Output, this.prizesThirdPlace);
/*  811 */       param1Kryo.writeObject(param1Output, this.prizesTop3Percent);
/*  812 */       param1Kryo.writeObject(param1Output, this.prizesTop10Percent);
/*  813 */       param1Kryo.writeObject(param1Output, this.prizesTop30Percent);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/*  818 */       this.isLocalFallback = param1Input.readBoolean();
/*  819 */       this.questId = param1Input.readInt();
/*  820 */       this.a = (String)param1Kryo.readObjectOrNull(param1Input, String.class);
/*  821 */       this.forDate = (String)param1Kryo.readObjectOrNull(param1Input, String.class);
/*  822 */       this.forDateTimestamp = param1Input.readInt();
/*  823 */       this.endTimestamp = param1Input.readInt();
/*  824 */       this.prizesFirstPlace = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*  825 */       this.prizesSecondPlace = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*  826 */       this.prizesThirdPlace = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*  827 */       this.prizesTop3Percent = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*  828 */       this.prizesTop10Percent = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*  829 */       this.prizesTop30Percent = (Array<ItemStack>)param1Kryo.readObject(param1Input, Array.class);
/*      */     }
/*      */     
/*      */     public String getLevelName() {
/*  833 */       return this.a;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean wasCompleted() {
/*  840 */       return (this.forDateTimestamp <= (ProgressPrefs.i()).dailyQuest.getLastCompletedDailyQuestTimestamp());
/*      */     }
/*      */     
/*      */     public void setCompleted() {
/*  844 */       Game.i.dailyQuestManager.setLastCompletedDailyQuestTimestamp(this.forDateTimestamp);
/*      */     }
/*      */     
/*      */     public void validate() {
/*  848 */       BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(this.a);
/*      */ 
/*      */       
/*  851 */       if (!this.a.equals("DQ" + this.questId)) {
/*  852 */         throw new IllegalStateException("Name must be DQ" + this.questId + ", got " + this.a);
/*      */       }
/*      */       
/*  855 */       if (!basicLevel.dailyQuest) {
/*  856 */         throw new IllegalStateException("BasicLevel.dailyQuest must be true");
/*      */       }
/*      */ 
/*      */       
/*  860 */       boolean bool = false;
/*  861 */       if (basicLevel.quests.size != 0) {
/*      */         
/*  863 */         if (basicLevel.quests.size != 1) {
/*  864 */           throw new IllegalStateException("level must contain only one quest, " + basicLevel.quests.size + " found");
/*      */         }
/*      */         
/*      */         BasicLevelQuestConfig basicLevelQuestConfig;
/*  868 */         if (!(basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(0)).id.startsWith("Q:" + this.a + ":")) {
/*  869 */           throw new IllegalStateException("quest name must start with Q:" + this.a + ":");
/*      */         }
/*  871 */         bool = true;
/*      */       } 
/*      */       
/*  874 */       if (basicLevel.waveQuests.size != 0) {
/*      */         
/*  876 */         if (bool) {
/*  877 */           throw new IllegalStateException("level must contain only one quest but it contains regular & wave quests");
/*      */         }
/*  879 */         if (basicLevel.waveQuests.size != 1) {
/*  880 */           throw new IllegalStateException("level must contain only one quest, " + basicLevel.waveQuests.size + " found");
/*      */         }
/*      */         
/*      */         BasicLevel.WaveQuest waveQuest;
/*  884 */         if (!(waveQuest = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(0)).id.startsWith("WQ:" + this.a + ":")) {
/*  885 */           throw new IllegalStateException("quest name must start with WQ:" + this.a + ":");
/*      */         }
/*  887 */         bool = true;
/*      */       } 
/*      */       
/*  890 */       if (!bool) {
/*  891 */         throw new IllegalStateException("no quests found");
/*      */       }
/*      */       
/*      */       TargetTile targetTile;
/*      */       
/*  896 */       if (!(targetTile = basicLevel.getMap().getTargetTileOrThrow()).isUseStockGameValues()) {
/*  897 */         throw new IllegalStateException("base must disable researches & trophies");
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
/*      */     public int getForDateTimestamp() {
/*  913 */       return this.forDateTimestamp;
/*      */     }
/*      */     
/*      */     public void setForDate(String param1String) {
/*  917 */       this.forDate = param1String;
/*      */       try {
/*  919 */         this.forDateTimestamp = (int)(DailyQuestManager.b().parse(param1String).getTime() / 1000L); return;
/*  920 */       } catch (ParseException parseException) {
/*  921 */         (param1String = null).printStackTrace();
/*      */         return;
/*      */       } 
/*      */     }
/*      */     
/*      */     public String getForDate() {
/*  927 */       return this.forDate;
/*      */     }
/*      */     
/*      */     public CharSequence getQuestName() {
/*      */       BasicLevelQuestConfig basicLevelQuestConfig;
/*      */       BasicLevel basicLevel;
/*  933 */       if ((basicLevel = Game.i.basicLevelManager.getLevel(getLevelName())).quests.size != 0) {
/*      */         
/*  935 */         basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(0);
/*  936 */         DailyQuestManager.c().setLength(0);
/*  937 */         DailyQuestManager.c().append(basicLevelQuestConfig.getTitle(false, false)).append(": ").append(basicLevelQuestConfig.formatValueForUi(basicLevelQuestConfig.requiredValue));
/*  938 */         return (CharSequence)DailyQuestManager.c();
/*      */       } 
/*      */       
/*  941 */       BasicLevel.WaveQuest waveQuest = (BasicLevel.WaveQuest)((BasicLevel)basicLevelQuestConfig).waveQuests.get(0);
/*  942 */       DailyQuestManager.c().setLength(0);
/*  943 */       DailyQuestManager.c().append(Game.i.localeManager.i18n.get("defeat_waves")).append(": ").append(waveQuest.waves);
/*  944 */       return (CharSequence)DailyQuestManager.c();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Array<ItemStack> getQuestRewards() {
/*      */       BasicLevel basicLevel;
/*  951 */       if ((basicLevel = Game.i.basicLevelManager.getLevel(getLevelName())).quests.size != 0)
/*      */       {
/*  953 */         return ((BasicLevelQuestConfig)basicLevel.quests.get(0)).prizes;
/*      */       }
/*  955 */       return ((BasicLevel.WaveQuest)basicLevel.waveQuests.get(0)).prizes;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class DailyQuestLeaderboards
/*      */   {
/*      */     public boolean success;
/*      */     public String date;
/*      */     public String playerId;
/*      */     public int requestTimestamp;
/*  966 */     public DailyQuestManager.LeaderboardsRank player = null;
/*  967 */     public Array<LeaderBoardManager.LeaderboardsEntry> entries = new Array();
/*      */     
/*      */     public DailyQuestLeaderboards(boolean param1Boolean, String param1String1, String param1String2) {
/*  970 */       this.success = param1Boolean;
/*  971 */       this.date = param1String1;
/*  972 */       this.playerId = param1String2;
/*  973 */       this.requestTimestamp = Game.getTimestampSeconds();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class LeaderboardsRank
/*      */   {
/*      */     public boolean success;
/*      */     public int requestTimestamp;
/*      */     public boolean isAdvance;
/*      */     public String boardDate;
/*      */     public String playerId;
/*      */     public int rank;
/*      */     public long score;
/*      */     public int total;
/*      */     
/*      */     private LeaderboardsRank(boolean param1Boolean1, boolean param1Boolean2, String param1String1, String param1String2) {
/*  989 */       this.isAdvance = param1Boolean2;
/*  990 */       this.playerId = param1String2;
/*  991 */       this.success = param1Boolean1;
/*  992 */       this.boardDate = param1String1;
/*      */       
/*  994 */       this.requestTimestamp = Game.getTimestampSeconds();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DailyLootDayConfig {
/*      */     public Item item;
/*      */     public int count;
/*      */     public double monthlyBonus;
/*      */     
/*      */     public int getCount(int param1Int) {
/* 1004 */       param1Int = this.count + (int)(this.monthlyBonus * param1Int + 1.0E-4D);
/* 1005 */       if (Game.i.progressManager.isDoubleGainEnabled()) {
/* 1006 */         param1Int <<= 1;
/*      */       }
/* 1008 */       return param1Int;
/*      */     }
/*      */     
/*      */     public static DailyLootDayConfig fromJson(JsonValue param1JsonValue) {
/*      */       DailyLootDayConfig dailyLootDayConfig;
/* 1013 */       (dailyLootDayConfig = new DailyLootDayConfig()).item = Item.fromJson(param1JsonValue.get("item"));
/* 1014 */       dailyLootDayConfig.count = param1JsonValue.getInt("count");
/* 1015 */       dailyLootDayConfig.monthlyBonus = param1JsonValue.getInt("monthlyBonus");
/*      */       
/* 1017 */       return dailyLootDayConfig;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\DailyQuestManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */