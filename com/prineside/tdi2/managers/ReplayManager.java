/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntFloatMap;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.kryo.FixedInput;
/*      */ import com.prineside.kryo.FixedOutput;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Replay;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.systems.StateSystem;
/*      */ import com.prineside.tdi2.systems.StatisticsSystem;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.util.HashMap;
/*      */ 
/*      */ @REGS(serializer = ReplayManager.Serializer.class)
/*      */ public class ReplayManager
/*      */   extends Manager.ManagerAdapter {
/*   50 */   private static final TLog a = TLog.forClass(ReplayManager.class);
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<ReplayManager> {
/*      */     public ReplayManager read() {
/*   54 */       return Game.i.replayManager;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum LeaderboardsMode
/*      */   {
/*   60 */     score,
/*   61 */     waves; static {
/*      */     
/*   63 */     } public static final LeaderboardsMode[] values = values();
/*      */   }
/*      */   
/*   66 */   private final ObjectMap<String, SoftReference<ReplayRecord>> b = new ObjectMap();
/*      */   
/*   68 */   public static FixedOutput helperOutput = new FixedOutput(65536, -1);
/*      */   
/*   70 */   private int c = 1;
/*      */ 
/*      */   
/*      */   public void setup() {
/*   74 */     if (!Config.isHeadless()) {
/*   75 */       Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*      */           {
/*      */             public void reloaded() {
/*   78 */               ReplayManager.a(this.a);
/*      */             }
/*      */           });
/*      */       
/*   82 */       Game.i.authManager.getNews(paramNewsResponse -> {
/*      */             if (paramNewsResponse != null) {
/*      */               this.c = paramNewsResponse.networkRequiredVersion;
/*      */             }
/*      */             
/*      */             sendUnsentReplaysToTheServer();
/*      */           });
/*      */     } 
/*      */     
/*   91 */     b();
/*      */   }
/*      */   
/*      */   public void deleteAllReplays() {
/*   95 */     Array<String> array = getAllRecordIds();
/*   96 */     for (byte b = 0; b < array.size; b++) {
/*   97 */       Gdx.files.local(PreferencesManager.getReplaysDirPath() + ((String[])array.items)[b] + ".rpl").delete();
/*      */     }
/*   99 */     (SettingsPrefs.i()).replay.sentReplayIds.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   private void b() {
/*  104 */     this.b.clear();
/*      */   }
/*      */   
/*      */   private void c() {
/*  108 */     Array<String> array = getAllRecordIds();
/*      */     ObjectSet objectSet;
/*  110 */     (objectSet = new ObjectSet()).addAll(array);
/*      */     
/*  112 */     array = (SettingsPrefs.i()).replay.sentReplayIds;
/*  113 */     Array array1 = new Array(true, 1, String.class);
/*  114 */     a.i("checking " + array.size + " replay records for existence on disk", new Object[0]);
/*  115 */     a.i(array.toString(", "), new Object[0]); byte b;
/*  116 */     for (b = 0; b < array.size; b++) {
/*  117 */       String str = (String)array.get(b);
/*  118 */       if (!objectSet.contains(str)) {
/*  119 */         array1.add(str);
/*      */       }
/*      */     } 
/*      */     
/*  123 */     if (array1.size != 0) {
/*  124 */       a.i("removing " + array1.size + " replay IDs from the list of sent replays - no replay file exists on disk", new Object[0]);
/*  125 */       for (b = 0; b < array1.size; b++) {
/*  126 */         array.removeValue(array1.get(b), false);
/*      */       }
/*  128 */       SettingsPrefs.i().requireSave();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*  136 */     Array array1 = new Array(String.class);
/*  137 */     Array<String> array = getAllRecordIds();
/*      */ 
/*      */     
/*  140 */     IntMap intMap = new IntMap();
/*  141 */     for (byte b1 = 0; b1 < array.size; b1++) {
/*      */       ReplayRecord replayRecord;
/*  143 */       if ((replayRecord = getRecord(((String[])array.items)[b1])) != null && 
/*  144 */         Config.isCompatibleWithBuild(replayRecord.build)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  149 */         int i = (i = (i = replayRecord.difficultyMode.ordinal()) * 31 + replayRecord.gameMode.ordinal()) * 31 + ((replayRecord.levelName == null) ? 0 : replayRecord.levelName.hashCode());
/*      */         
/*      */         ObjectPair objectPair;
/*  152 */         if ((objectPair = (ObjectPair)intMap.get(i, null)) == null || ((Long)objectPair.second).longValue() < replayRecord.score) {
/*  153 */           intMap.put(i, new ObjectPair(replayRecord.id, Long.valueOf(replayRecord.score)));
/*      */         }
/*      */       } 
/*      */     } 
/*  157 */     for (IntMap.Entry entry : intMap) {
/*  158 */       array1.add(((ObjectPair)entry.value).first);
/*      */     }
/*      */     
/*  161 */     a.i("preserving " + array1.size + " replays", new Object[0]);
/*      */ 
/*      */     
/*  164 */     Array array2 = new Array(ObjectPair.class); byte b2;
/*  165 */     for (b2 = 0; b2 < array.size; b2++) {
/*  166 */       ReplayRecord replayRecord = getRecord(((String[])array.items)[b2]);
/*  167 */       if (!array1.contains(replayRecord.id, true))
/*      */       {
/*  169 */         array2.add(new ObjectPair(replayRecord.id, Long.valueOf(replayRecord.saveTimestamp)));
/*      */       }
/*      */     } 
/*  172 */     array2.sort((paramObjectPair1, paramObjectPair2) -> Long.compare(((Long)paramObjectPair2.second).longValue(), ((Long)paramObjectPair1.second).longValue()));
/*      */ 
/*      */     
/*  175 */     for (b2 = 20; b2 < array2.size; b2++) {
/*  176 */       String str = (String)(((ObjectPair[])array2.items)[b2]).first;
/*  177 */       this.b.remove(str);
/*      */       try {
/*  179 */         Gdx.files.local(PreferencesManager.getReplaysDirPath() + str + ".rpl").delete();
/*  180 */         a.i("removed " + str + " as obsolete", new Object[0]);
/*  181 */       } catch (Exception exception) {}
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadAndStoreBestReplayFromServer(String paramString, ObjectConsumer<ReplayRecord> paramObjectConsumer) {
/*  269 */     a.i("requesting best replay from server for level " + paramString, new Object[0]);
/*      */     
/*  271 */     if (Game.i.authManager.getSignInStatus() != AuthManager.SignInStatus.SIGNED_IN) {
/*  272 */       a.w("player is not signed in, skipping best replay request", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/*  277 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_BEST_GAME_REPLAY_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/*  280 */     (hashMap = new HashMap<>()).put("map", paramString);
/*  281 */     hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*  282 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  284 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramString, paramObjectConsumer) {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */             try {
/*  287 */               String str = param1HttpResponse.getResultAsString();
/*      */               
/*      */               JsonValue jsonValue;
/*  290 */               if ((jsonValue = (new JsonReader()).parse(str)).getString("status", "error").equals("success")) {
/*      */                 
/*  292 */                 Threads.i().runOnMainThread(() -> {
/*      */                       try {
/*      */                         SP_Replay sP_Replay = (SettingsPrefs.i()).replay;
/*      */                         
/*      */                         ReplayManager.ReplayRecord replayRecord = ReplayManager.ReplayRecord.fromCompactString(param1JsonValue.getString("replay"));
/*      */                         
/*      */                         if (this.c.getRecord(replayRecord.id) != null) {
/*      */                           ReplayManager.a().i("skilled loading best replay from server (" + param1String + ", " + replayRecord.id + ") - already stored locally", new Object[0]);
/*      */                           
/*      */                           return;
/*      */                         } 
/*      */                         
/*      */                         if (replayRecord.chartFrames.version != 2) {
/*      */                           ReplayManager.a().i("skilled loading best replay from server (" + param1String + ", " + replayRecord.id + ") - chartFrames version differ (" + replayRecord.chartFrames.version + ", 2" + ")", new Object[0]);
/*      */                           return;
/*      */                         } 
/*      */                         replayRecord.saveLocally();
/*      */                         boolean bool = false;
/*      */                         for (byte b = 0; b < sP_Replay.sentReplayIds.size; b++) {
/*      */                           if (((String[])sP_Replay.sentReplayIds.items)[b].equals(replayRecord.id)) {
/*      */                             bool = true;
/*      */                             break;
/*      */                           } 
/*      */                         } 
/*      */                         if (!bool) {
/*      */                           sP_Replay.sentReplayIds.add(replayRecord.id);
/*      */                           SettingsPrefs.i().requireSave();
/*      */                         } 
/*      */                         if (param1ObjectConsumer != null) {
/*      */                           param1ObjectConsumer.accept(replayRecord);
/*      */                         }
/*      */                         return;
/*  324 */                       } catch (Exception exception) {
/*      */                         ReplayManager.a().e("failed to load best replay from server", new Object[] { exception });
/*      */                         return;
/*      */                       } 
/*      */                     });
/*      */               } else {
/*  330 */                 ReplayManager.a().w("Failed to load best replay from server: %s", new Object[] { str }); return;
/*      */               } 
/*  332 */             } catch (Exception exception) {
/*  333 */               ReplayManager.a().e("Exception: " + exception.getMessage(), new Object[] { exception });
/*      */             } 
/*      */           }
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/*  338 */             ReplayManager.a().e("Failed", new Object[] { param1Throwable });
/*      */           }
/*      */           
/*      */           public void cancelled() {
/*  342 */             ReplayManager.a().e("Cancelled", new Object[0]);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String saveReplay(GameSystemProvider paramGameSystemProvider) {
/*      */     ReplayRecord replayRecord;
/*  352 */     (replayRecord = ReplayRecord.fromState(paramGameSystemProvider)).saveLocally();
/*  353 */     this.b.put(replayRecord.id, new SoftReference<>(replayRecord));
/*      */     
/*  355 */     return replayRecord.id;
/*      */   }
/*      */   
/*      */   public void sendReplayToServer(String paramString, ObjectConsumer<ReplaySendStatus> paramObjectConsumer) {
/*  359 */     if (!Game.i.authManager.isSignedIn()) {
/*  360 */       a.w("replay won't be sent - not signed in", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  364 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/*  365 */       a.i("skipped sendReplayToServer - dev mode", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     ReplayRecord replayRecord;
/*  370 */     if ((replayRecord = getRecord(paramString)) == null) {
/*  371 */       a.e("can't get record " + paramString, new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  375 */     if (replayRecord.getStateBytes() == null) {
/*  376 */       a.e(paramString + " is cleaned up and no longer has a state", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  380 */     if (replayRecord.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/*  381 */       a.e(paramString + " is a custom map", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  385 */     if (replayRecord.difficultyMode != DifficultyMode.NORMAL && replayRecord.difficultyMode != DifficultyMode.ENDLESS_I) {
/*  386 */       a.e(paramString + " has " + replayRecord.difficultyMode + " difficulty, won't be sent to the server", new Object[0]);
/*  387 */       (SettingsPrefs.i()).replay.sentReplayIds.add(paramString);
/*  388 */       SettingsPrefs.i().requireSave();
/*      */       
/*      */       return;
/*      */     } 
/*  392 */     if (GameStateSystem.GameMode.isBasicLevel(replayRecord.gameMode)) {
/*      */       try {
/*  394 */         if (!(Game.i.basicLevelManager.getLevel(replayRecord.levelName)).hasLeaderboards) {
/*  395 */           a.e(paramString + " hasn't leaderboards, skipping", new Object[0]);
/*  396 */           (SettingsPrefs.i()).replay.sentReplayIds.add(paramString);
/*  397 */           SettingsPrefs.i().requireSave();
/*      */           return;
/*      */         } 
/*  400 */       } catch (Exception exception) {
/*  401 */         a.e("failed to get level " + replayRecord.levelName, new Object[] { exception });
/*  402 */         (SettingsPrefs.i()).replay.sentReplayIds.add(paramString);
/*  403 */         SettingsPrefs.i().requireSave();
/*      */         
/*      */         return;
/*      */       } 
/*      */     }
/*  408 */     a.i(paramString + " is not sent yet", new Object[0]);
/*      */     
/*      */     try {
/*  411 */       if (replayRecord.build < this.c) {
/*      */         
/*  413 */         a.i(paramString + " has too low version, skipping", new Object[0]);
/*  414 */         (SettingsPrefs.i()).replay.sentReplayIds.add(paramString);
/*  415 */         SettingsPrefs.i().requireSave();
/*      */       } else {
/*      */         Net.HttpRequest httpRequest;
/*  418 */         (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GAME_REPLAY_REPORT_URL);
/*      */         
/*  420 */         Json json = new Json(JsonWriter.OutputType.json);
/*  421 */         StringWriter stringWriter = new StringWriter();
/*  422 */         json.setWriter(stringWriter);
/*      */ 
/*      */         
/*  425 */         json.writeObjectStart();
/*  426 */         json.writeValue("build", Integer.valueOf(replayRecord.build));
/*  427 */         json.writeValue("id", replayRecord.id);
/*  428 */         json.writeValue("os", Gdx.app.getType().name());
/*  429 */         json.writeValue("playRealTime", Integer.valueOf(replayRecord.playRealTime));
/*  430 */         json.writeValue("gameMode", replayRecord.gameMode.name());
/*  431 */         json.writeValue("difficultyMode", replayRecord.difficultyMode.name());
/*  432 */         json.writeValue("modeDifficultyMultiplier", Integer.valueOf(replayRecord.modeDifficultyMultiplier));
/*  433 */         if (replayRecord.levelName != null) json.writeValue("levelName", replayRecord.levelName); 
/*  434 */         json.writeValue("profileXp", Integer.valueOf(replayRecord.profileXp));
/*  435 */         json.writeValue("defeatedWaves", Integer.valueOf(replayRecord.defeatedWaves));
/*  436 */         json.writeValue("score", Long.valueOf(replayRecord.score));
/*  437 */         json.writeValue("record", replayRecord.toCompactString());
/*  438 */         json.writeObjectEnd();
/*      */         
/*      */         HashMap<Object, Object> hashMap;
/*  441 */         (hashMap = new HashMap<>()).put("report", stringWriter.toString());
/*  442 */         hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*  443 */         httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */         
/*  445 */         Game.getRealTickCount();
/*  446 */         Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramString, paramObjectConsumer) {
/*      */               public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */                 try {
/*  449 */                   String str = param1HttpResponse.getResultAsString();
/*  450 */                   ReplayManager.a().i(str, new Object[0]);
/*      */                   JsonValue jsonValue;
/*  452 */                   if ((jsonValue = (new JsonReader()).parse(str)).getString("status", "error").equals("success")) {
/*      */                     
/*  454 */                     Threads.i().runOnMainThread(() -> {
/*      */                           ReplayManager.a().i("Success: " + param1String1, new Object[0]);
/*      */                           
/*      */                           (SettingsPrefs.i()).replay.sentReplayIds.add(param1String2);
/*      */                           
/*      */                           SettingsPrefs.i().requireSave();
/*      */                           
/*      */                           if (param1ObjectConsumer != null && param1JsonValue.get("xpGained") != null) {
/*      */                             ReplayManager.ReplaySendStatus replaySendStatus;
/*      */                             (replaySendStatus = new ReplayManager.ReplaySendStatus()).regularXpGained = param1JsonValue.get("xpGained").getInt("regular", 0);
/*      */                             replaySendStatus.bonusXpGained = param1JsonValue.get("xpGained").getInt("bonus", 0);
/*      */                             replaySendStatus.bonusXpLeft = param1JsonValue.get("xpGained").getBoolean("bonusLeft", false);
/*      */                             replaySendStatus.regularXpLeft = param1JsonValue.get("xpGained").getBoolean("regularLeft", true);
/*      */                             param1ObjectConsumer.accept(replaySendStatus);
/*      */                           } 
/*      */                           ReplayManager.b(this.c);
/*      */                         });
/*      */                   } else {
/*  472 */                     ReplayManager.a().e("Error: " + str, new Object[0]); return;
/*      */                   } 
/*  474 */                 } catch (Exception exception) {
/*  475 */                   ReplayManager.a().e("Exception: " + exception.getMessage(), new Object[] { exception });
/*      */                 } 
/*      */               }
/*      */               
/*      */               public void failed(Throwable param1Throwable) {
/*  480 */                 ReplayManager.a().e("Failed", new Object[] { param1Throwable });
/*      */               }
/*      */               
/*      */               public void cancelled() {
/*  484 */                 ReplayManager.a().e("Cancelled", new Object[0]); }
/*      */             });
/*      */         return;
/*      */       } 
/*  488 */     } catch (Exception exception) {
/*      */       
/*  490 */       a.i("Failed to send replay to the server (" + exception.getMessage() + ")", new Object[0]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public ReplayRecord getRecord(String paramString) {
/*  498 */     if (this.b.containsKey(paramString)) {
/*      */       ReplayRecord replayRecord;
/*  500 */       if ((replayRecord = ((SoftReference<ReplayRecord>)this.b.get(paramString)).get()) != null) {
/*  501 */         return replayRecord;
/*      */       }
/*      */       
/*  504 */       this.b.remove(paramString);
/*      */     } 
/*      */ 
/*      */     
/*  508 */     if (paramString.contains(".")) {
/*  509 */       throw new IllegalArgumentException("Replay ID should not contain dots, " + paramString + " given");
/*      */     }
/*      */     
/*  512 */     String str = PreferencesManager.getReplaysDirPath() + paramString + ".rpl";
/*      */     FileHandle fileHandle;
/*  514 */     if ((fileHandle = Gdx.files.local(str)).exists() && !fileHandle.isDirectory()) {
/*      */       try {
/*      */         byte[] arrayOfByte;
/*  517 */         if ((arrayOfByte = fileHandle.readBytes()).length == 0) {
/*  518 */           throw new IllegalStateException("zero bytes read");
/*      */         }
/*      */         
/*  521 */         ReplayRecord replayRecord = ReplayRecord.fromBytes(arrayOfByte, 0, arrayOfByte.length);
/*  522 */         this.b.put(paramString, new SoftReference<>(replayRecord));
/*      */         
/*  524 */         return replayRecord;
/*  525 */       } catch (Exception exception) {
/*  526 */         a.e("failed to load replay record - removing", new Object[] { exception });
/*  527 */         this.b.remove(paramString);
/*      */         
/*      */         try {
/*  530 */           fileHandle.delete();
/*  531 */         } catch (Exception exception1) {}
/*      */         
/*  533 */         return null;
/*      */       } 
/*      */     }
/*  536 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public Array<String> getAllRecordIds() {
/*  541 */     Array<String> array = new Array(String.class);
/*      */     
/*      */     FileHandle fileHandle;
/*  544 */     if ((fileHandle = Gdx.files.local(PreferencesManager.getReplaysDirPath())).exists() && fileHandle.isDirectory()) {
/*      */       FileHandle[] arrayOfFileHandle; int i; byte b;
/*  546 */       for (i = (arrayOfFileHandle = arrayOfFileHandle = fileHandle.list()).length, b = 0; b < i; b++) {
/*  547 */         FileHandle fileHandle1; if ((fileHandle1 = arrayOfFileHandle[b]).name().endsWith(".rpl")) {
/*  548 */           array.add(fileHandle1.name().substring(0, fileHandle1.name().length() - 4));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  553 */     return array;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendUnsentReplaysToTheServer() {
/*  561 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/*  562 */       a.i("skipped sendUnsentReplaysToTheServer - dev mode", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  566 */     if (Config.isHeadless())
/*  567 */       return;  if (Game.i.actionResolver.isAppModified())
/*  568 */       return;  if (Config.isModdingMode())
/*  569 */       return;  if (!Game.i.authManager.isSignedIn())
/*      */       return; 
/*  571 */     a.i("sending unsent replays...", new Object[0]);
/*      */     
/*  573 */     byte b1 = 0;
/*  574 */     Array<String> array = getAllRecordIds();
/*  575 */     for (byte b2 = 0; b2 < array.size; ) {
/*  576 */       String str = (String)array.get(b2);
/*  577 */       if (!(SettingsPrefs.i()).replay.sentReplayIds.contains(str, false)) {
/*      */         
/*  579 */         b1++;
/*  580 */         sendReplayToServer(str, null);
/*      */       } 
/*      */ 
/*      */       
/*  584 */       if (b1 != 100) {
/*      */         b2++;
/*      */       }
/*      */     } 
/*      */     
/*  589 */     d();
/*  590 */     c();
/*      */   }
/*      */   
/*      */   public static class ReplaySendStatus {
/*      */     public int regularXpGained;
/*      */     public int bonusXpGained;
/*      */     public boolean bonusXpLeft;
/*      */     public boolean regularXpLeft; }
/*      */   
/*      */   public static class ReplayHeader { public int build;
/*      */     public DifficultyMode difficultyMode;
/*      */     public long seed;
/*      */     public int modeDifficultyMultiplier;
/*      */     public GameStateSystem.GameMode gameMode;
/*      */     public AbilitySelectionOverlay.SelectedAbilitiesConfiguration abilitiesConfiguration;
/*      */     public boolean canLootCases;
/*      */     public boolean lootBoostEnabled;
/*      */     public boolean rarityBoostEnabled;
/*      */     @Null
/*      */     public String basicLevelName;
/*      */     @Null
/*      */     public String userMapId;
/*  612 */     public int userMapSeed = 0; @Null
/*      */     public BossType[] customMapBossTypes; public long gameStartTs;
/*      */     public ProgressManager.ProgressSnapshotForState progressSnapshot;
/*      */     public ProgressManager.InventoryStatistics inventoryStatistics;
/*      */     @Null
/*      */     public DailyQuestManager.DailyQuestLevel dailyQuestLevel;
/*      */     public float playRealTime;
/*      */     public long updateNumber;
/*      */     public int continuedGameApproxStateHash;
/*      */     public int actionsCount;
/*  622 */     public Array<StateSystem.ActionUpdatePair> actions = new Array(true, 1, StateSystem.ActionUpdatePair.class);
/*      */ 
/*      */ 
/*      */     
/*      */     public static ReplayHeader fromBytes(Input param1Input) {
/*  627 */       ReplayHeader replayHeader = new ReplayHeader();
/*      */       try {
/*  629 */         param1Input.setPosition(0);
/*      */         
/*  631 */         NetworkManager.KryoForState kryoForState = Game.i.networkManager.getFullKryo();
/*  632 */         replayHeader.build = param1Input.readVarInt(true);
/*  633 */         replayHeader.difficultyMode = (DifficultyMode)kryoForState.readObject(param1Input, DifficultyMode.class);
/*  634 */         replayHeader.seed = param1Input.readLong();
/*  635 */         replayHeader.modeDifficultyMultiplier = param1Input.readVarInt(true);
/*  636 */         replayHeader.gameMode = (GameStateSystem.GameMode)kryoForState.readObject(param1Input, GameStateSystem.GameMode.class);
/*  637 */         replayHeader.abilitiesConfiguration = (AbilitySelectionOverlay.SelectedAbilitiesConfiguration)kryoForState.readObjectOrNull(param1Input, AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/*  638 */         replayHeader.canLootCases = param1Input.readBoolean();
/*  639 */         replayHeader.lootBoostEnabled = param1Input.readBoolean();
/*  640 */         replayHeader.rarityBoostEnabled = param1Input.readBoolean();
/*      */         
/*  642 */         replayHeader.basicLevelName = null;
/*  643 */         replayHeader.userMapId = null;
/*  644 */         replayHeader.customMapBossTypes = null;
/*      */         
/*  646 */         if (replayHeader.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*  647 */           replayHeader.basicLevelName = param1Input.readString();
/*  648 */         } else if (replayHeader.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/*  649 */           replayHeader.userMapId = param1Input.readString();
/*  650 */           replayHeader.userMapSeed = param1Input.readInt();
/*  651 */           replayHeader.customMapBossTypes = (BossType[])kryoForState.readObjectOrNull(param1Input, BossType[].class);
/*      */         } 
/*      */         
/*  654 */         replayHeader.gameStartTs = param1Input.readLong();
/*  655 */         replayHeader.progressSnapshot = (ProgressManager.ProgressSnapshotForState)kryoForState.readObject(param1Input, ProgressManager.ProgressSnapshotForState.class);
/*  656 */         replayHeader.inventoryStatistics = (ProgressManager.InventoryStatistics)kryoForState.readObject(param1Input, ProgressManager.InventoryStatistics.class);
/*  657 */         replayHeader.dailyQuestLevel = (DailyQuestManager.DailyQuestLevel)kryoForState.readObjectOrNull(param1Input, DailyQuestManager.DailyQuestLevel.class);
/*      */         
/*  659 */         replayHeader.playRealTime = param1Input.readFloat();
/*  660 */         replayHeader.updateNumber = param1Input.readVarInt(true);
/*  661 */         replayHeader.continuedGameApproxStateHash = param1Input.readInt();
/*  662 */         replayHeader.actionsCount = param1Input.readVarInt(true);
/*      */         
/*  664 */         for (byte b = 0; b < replayHeader.actionsCount; b++) {
/*  665 */           StateSystem.ActionUpdatePair actionUpdatePair = (StateSystem.ActionUpdatePair)kryoForState.readObject(param1Input, StateSystem.ActionUpdatePair.class);
/*  666 */           replayHeader.actions.add(actionUpdatePair);
/*      */         } 
/*      */         
/*  669 */         return replayHeader;
/*  670 */       } catch (Exception exception) {
/*  671 */         throw new IllegalArgumentException("Invalid replay format", exception);
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ReplayRecord
/*      */   {
/*      */     public byte version;
/*      */     
/*      */     public int build;
/*      */     public String id;
/*      */     public GameStateSystem.GameMode gameMode;
/*  684 */     public DifficultyMode difficultyMode = DifficultyMode.NORMAL;
/*      */     
/*      */     public int modeDifficultyMultiplier;
/*      */     
/*      */     public String levelName;
/*      */     public int playRealTime;
/*      */     public int defeatedWaves;
/*      */     public long score;
/*      */     public long startTimestamp;
/*      */     public long saveTimestamp;
/*      */     public int profileXp;
/*      */     public IntFloatMap statistics;
/*      */     public ChartFrames chartFrames;
/*      */     private byte[] a;
/*      */     
/*      */     public static ReplayRecord fromState(GameSystemProvider param1GameSystemProvider) {
/*      */       ReplayRecord replayRecord;
/*  701 */       (replayRecord = new ReplayRecord()).build = 207;
/*  702 */       replayRecord.id = param1GameSystemProvider.gameState.replayId;
/*  703 */       replayRecord.gameMode = param1GameSystemProvider.gameState.gameMode;
/*  704 */       replayRecord.difficultyMode = param1GameSystemProvider.gameState.difficultyMode;
/*  705 */       replayRecord.modeDifficultyMultiplier = param1GameSystemProvider.gameState.modeDifficultyMultiplier;
/*  706 */       if (GameStateSystem.GameMode.isBasicLevel(param1GameSystemProvider.gameState.gameMode)) {
/*  707 */         replayRecord.levelName = param1GameSystemProvider.gameState.basicLevelName;
/*  708 */       } else if (param1GameSystemProvider.gameState.gameMode == GameStateSystem.GameMode.USER_MAPS) {
/*  709 */         replayRecord.levelName = param1GameSystemProvider.gameState.userMapId;
/*      */       } 
/*  711 */       replayRecord.playRealTime = (int)param1GameSystemProvider.gameState.playRealTime;
/*  712 */       replayRecord.defeatedWaves = param1GameSystemProvider.wave.getCompletedWavesCount();
/*  713 */       replayRecord.score = param1GameSystemProvider.gameState.getScore();
/*  714 */       replayRecord.startTimestamp = param1GameSystemProvider.gameState.gameStartTimestamp;
/*  715 */       replayRecord.saveTimestamp = Game.getTimestampMillis();
/*  716 */       replayRecord.profileXp = param1GameSystemProvider.gameState.pxpExperience;
/*      */       
/*  718 */       replayRecord.statistics = new IntFloatMap();
/*  719 */       double[] arrayOfDouble = param1GameSystemProvider.statistics.getCurrentGameStatistics(); StatisticsType[] arrayOfStatisticsType; int i; byte b;
/*  720 */       for (i = (arrayOfStatisticsType = StatisticsType.values).length, b = 0; b < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/*  721 */         if (arrayOfDouble[statisticsType.ordinal()] != 0.0D)
/*  722 */           replayRecord.statistics.put(statisticsType.ordinal(), (float)arrayOfDouble[statisticsType.ordinal()]); 
/*      */         b++; }
/*      */       
/*  725 */       replayRecord.chartFrames = param1GameSystemProvider.statistics.getCurrentReplayChart().cpy();
/*  726 */       replayRecord.a = param1GameSystemProvider.gameState.getStateBytes().toBytes();
/*      */       
/*  728 */       return replayRecord;
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] toBytes() {
/*      */       FixedOutput fixedOutput;
/*  734 */       (fixedOutput = ReplayManager.helperOutput).clear();
/*      */ 
/*      */       
/*  737 */       fixedOutput.writeInt(152630033);
/*  738 */       fixedOutput.writeByte(4);
/*      */       
/*  740 */       fixedOutput.writeVarInt(this.build, true);
/*  741 */       fixedOutput.writeString(this.id);
/*  742 */       fixedOutput.writeVarInt(this.gameMode.ordinal(), true);
/*  743 */       fixedOutput.writeVarInt(this.difficultyMode.ordinal(), true);
/*  744 */       fixedOutput.writeVarInt(this.modeDifficultyMultiplier, true);
/*  745 */       fixedOutput.writeString(this.levelName);
/*  746 */       fixedOutput.writeVarInt(this.playRealTime, true);
/*  747 */       fixedOutput.writeVarInt(this.defeatedWaves, true);
/*  748 */       fixedOutput.writeVarLong(this.score, true);
/*  749 */       fixedOutput.writeLong(this.startTimestamp);
/*  750 */       fixedOutput.writeLong(this.saveTimestamp);
/*  751 */       fixedOutput.writeVarInt(this.profileXp, true);
/*      */ 
/*      */       
/*  754 */       fixedOutput.writeVarInt(this.statistics.size, true);
/*  755 */       IntFloatMap.Keys keys = this.statistics.keys();
/*  756 */       while (keys.hasNext) {
/*  757 */         int i = keys.next();
/*  758 */         fixedOutput.writeVarInt(i, true);
/*  759 */         fixedOutput.writeFloat(this.statistics.get(i, 0.0F));
/*      */       } 
/*      */       
/*  762 */       this.chartFrames.write(fixedOutput);
/*      */       
/*  764 */       fixedOutput.writeVarInt(this.a.length, true);
/*  765 */       fixedOutput.writeBytes(this.a);
/*      */       
/*  767 */       return fixedOutput.toBytes();
/*      */     }
/*      */ 
/*      */     
/*      */     private void a(FixedInput param1FixedInput) {
/*  772 */       int i = param1FixedInput.position();
/*  773 */       int j = 1;
/*      */       int k;
/*  775 */       if ((k = param1FixedInput.readInt()) == 152630033) {
/*      */         
/*  777 */         j = param1FixedInput.readByte();
/*      */       } else {
/*      */         
/*  780 */         param1FixedInput.setPosition(i);
/*      */       } 
/*      */       
/*  783 */       this.build = param1FixedInput.readVarInt(true);
/*  784 */       this.id = param1FixedInput.readString();
/*  785 */       this.gameMode = GameStateSystem.GameMode.values[param1FixedInput.readVarInt(true)];
/*  786 */       this.difficultyMode = DifficultyMode.values[param1FixedInput.readVarInt(true)];
/*  787 */       this.modeDifficultyMultiplier = (j >= 2) ? param1FixedInput.readVarInt(true) : 100;
/*  788 */       this.levelName = param1FixedInput.readString();
/*  789 */       this.playRealTime = param1FixedInput.readVarInt(true);
/*  790 */       this.defeatedWaves = param1FixedInput.readVarInt(true);
/*  791 */       this.score = param1FixedInput.readVarLong(true);
/*  792 */       this.startTimestamp = param1FixedInput.readLong();
/*  793 */       this.saveTimestamp = param1FixedInput.readLong();
/*  794 */       this.profileXp = param1FixedInput.readVarInt(true);
/*      */ 
/*      */       
/*  797 */       i = param1FixedInput.readVarInt(true);
/*  798 */       this.statistics = new IntFloatMap(i);
/*  799 */       for (j = 0; j < i; j++) {
/*  800 */         k = param1FixedInput.readVarInt(true);
/*  801 */         this.statistics.put(k, param1FixedInput.readFloat());
/*      */       } 
/*      */       
/*  804 */       this.chartFrames = ChartFrames.fromBytes(param1FixedInput);
/*      */       
/*  806 */       j = param1FixedInput.readVarInt(true);
/*  807 */       this.a = param1FixedInput.readBytes(j);
/*      */     }
/*      */     
/*      */     public static ReplayRecord fromBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*      */       ReplayRecord replayRecord;
/*  812 */       (replayRecord = new ReplayRecord()).a(new FixedInput(param1ArrayOfbyte, param1Int1, param1Int2));
/*      */       
/*  814 */       return replayRecord;
/*      */     }
/*      */     
/*      */     public static ReplayRecord fromCompactString(String param1String) {
/*      */       ReplayRecord replayRecord;
/*  819 */       (replayRecord = new ReplayRecord()).a(new FixedInput(StringFormatter.fromCompactBase64(param1String)));
/*      */       
/*  821 */       return replayRecord;
/*      */     }
/*      */     
/*      */     public byte[] getStateBytes() {
/*  825 */       return this.a;
/*      */     }
/*      */     
/*      */     public void saveLocally() {
/*  829 */       byte[] arrayOfByte = toBytes();
/*  830 */       Gdx.files.local(PreferencesManager.getReplaysDirPath() + this.id + ".rpl").writeBytes(arrayOfByte, false);
/*      */       
/*  832 */       ReplayManager.a().i("saved " + this.id + " locally", new Object[0]);
/*      */     }
/*      */     
/*      */     public String toCompactString() {
/*      */       byte[] arrayOfByte;
/*  837 */       return StringFormatter.toCompactBase64(arrayOfByte = toBytes(), 0, arrayOfByte.length);
/*      */     }
/*      */     
/*      */     @REGS
/*      */     public static class ChartFrames
/*      */       implements KryoSerializable {
/*      */       public static final int MAX_FRAME_COUNT = 2000;
/*  844 */       public int version = 2;
/*  845 */       public Array<FrameValues> frames = new Array(true, 1, FrameValues.class);
/*      */       
/*  847 */       private static final FixedOutput a = new FixedOutput(4096, -1);
/*  848 */       private static final FixedOutput b = new FixedOutput(1024, -1);
/*  849 */       private static final FixedInput c = new FixedInput();
/*  850 */       private static final FixedInput d = new FixedInput();
/*      */       
/*      */       public void write(FixedOutput param2FixedOutput) {
/*  853 */         param2FixedOutput.writeVarInt(this.version, true);
/*      */ 
/*      */         
/*  856 */         b.clear();
/*      */ 
/*      */         
/*  859 */         b.writeVarInt(this.frames.size, true);
/*  860 */         for (byte b = 0; b < this.frames.size; b++) {
/*  861 */           ((FrameValues[])this.frames.items)[b].write(b);
/*      */         }
/*      */         
/*  864 */         param2FixedOutput.writeVarInt(b.position(), true);
/*  865 */         param2FixedOutput.writeBytes(b.getBuffer(), 0, b.position());
/*      */       }
/*      */ 
/*      */       
/*      */       public void read(FixedInput param2FixedInput) {
/*  870 */         this.version = param2FixedInput.readVarInt(true);
/*      */         
/*  872 */         int i = param2FixedInput.readVarInt(true);
/*  873 */         byte[] arrayOfByte = param2FixedInput.readBytes(i);
/*      */         
/*  875 */         this.frames.clear();
/*  876 */         if (this.version == 2) {
/*      */           
/*  878 */           c.setBuffer(arrayOfByte);
/*  879 */           int j = c.readVarInt(true);
/*  880 */           for (i = 0; i < j; i++) {
/*      */             FrameValues frameValues;
/*  882 */             (frameValues = new FrameValues()).read(c);
/*  883 */             this.frames.add(frameValues);
/*      */           }  return;
/*      */         } 
/*  886 */         ReplayManager.a().i("skipped reading replay ChartFrames data - version mismatch (" + this.version + ", 2" + ")", new Object[0]);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void write(Kryo param2Kryo, Output param2Output) {
/*  892 */         a.clear();
/*  893 */         write(a);
/*  894 */         param2Output.writeVarInt(a.position(), true);
/*  895 */         param2Output.writeBytes(a.getBuffer(), 0, a.position());
/*      */       }
/*      */ 
/*      */       
/*      */       public void read(Kryo param2Kryo, Input param2Input) {
/*  900 */         int i = param2Input.readVarInt(true);
/*  901 */         byte[] arrayOfByte = param2Input.readBytes(i);
/*  902 */         d.setBuffer(arrayOfByte);
/*  903 */         read(d);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public static ChartFrames fromBytes(FixedInput param2FixedInput) {
/*  909 */         ChartFrames chartFrames = new ChartFrames();
/*      */         try {
/*  911 */           chartFrames.read(param2FixedInput);
/*  912 */         } catch (Exception exception) {
/*  913 */           ReplayManager.a().e("failed to load chart frames, fallback", new Object[] { exception });
/*  914 */           chartFrames = new ChartFrames();
/*      */         } 
/*  916 */         return chartFrames;
/*      */       }
/*      */ 
/*      */       
/*      */       public ChartFrames cpy() {
/*      */         ChartFrames chartFrames;
/*  922 */         (chartFrames = new ChartFrames()).version = this.version;
/*  923 */         for (byte b = 0; b < this.frames.size; b++) {
/*  924 */           chartFrames.frames.add(((FrameValues[])this.frames.items)[b].cpy());
/*      */         }
/*      */         
/*  927 */         return chartFrames;
/*      */       }
/*      */       
/*      */       public void addFrame(GameSystemProvider param2GameSystemProvider) {
/*  931 */         if (this.frames.size < 2000) {
/*  932 */           this.frames.add(generateFrameValues(param2GameSystemProvider).cpy());
/*      */         }
/*      */       }
/*      */       
/*      */       public static FrameValues generateFrameValues(GameSystemProvider param2GameSystemProvider) {
/*  937 */         StatisticsSystem statisticsSystem = param2GameSystemProvider.statistics;
/*      */         
/*      */         FrameValues frameValues;
/*  940 */         (frameValues = new FrameValues()).cBounties = (int)statisticsSystem.getCurrentGameStatistic(StatisticsType.CG_B);
/*  941 */         frameValues.cKilledEnemies = (int)statisticsSystem.getCurrentGameStatistic(StatisticsType.CG_EK);
/*  942 */         frameValues.cWaveCalls = (int)statisticsSystem.getCurrentGameStatistic(StatisticsType.CG_WC);
/*  943 */         frameValues.cOther = (int)statisticsSystem.getCurrentGameStatistic(StatisticsType.CG_PG) + (int)statisticsSystem.getCurrentGameStatistic(StatisticsType.CG_U);
/*      */         
/*  945 */         frameValues.sKilledEnemies = (long)statisticsSystem.getCurrentGameStatistic(StatisticsType.SG_EK);
/*  946 */         frameValues.sMining = (long)statisticsSystem.getCurrentGameStatistic(StatisticsType.SG_RM);
/*  947 */         frameValues.sWaveCalls = (long)statisticsSystem.getCurrentGameStatistic(StatisticsType.SG_WCA);
/*  948 */         frameValues.sWavesCleared = (long)statisticsSystem.getCurrentGameStatistic(StatisticsType.SG_WCL);
/*      */         
/*  950 */         frameValues.wave = (param2GameSystemProvider.wave.wave == null) ? 1 : param2GameSystemProvider.wave.wave.waveNumber;
/*  951 */         frameValues.mdps = (float)param2GameSystemProvider.damage.getTowersMaxDps();
/*      */         
/*  953 */         return frameValues;
/*      */       }
/*      */       
/*      */       public static class FrameValues {
/*      */         public int cBounties;
/*      */         public int cKilledEnemies;
/*      */         public int cWaveCalls;
/*      */         public int cOther;
/*      */         public long sKilledEnemies;
/*      */         public long sMining;
/*      */         public long sWaveCalls;
/*      */         public long sWavesCleared;
/*      */         public int wave;
/*      */         public float mdps;
/*      */         
/*      */         public void write(FixedOutput param3FixedOutput) {
/*  969 */           param3FixedOutput.writeVarInt(this.cBounties, true);
/*  970 */           param3FixedOutput.writeVarInt(this.cKilledEnemies, true);
/*  971 */           param3FixedOutput.writeVarInt(this.cWaveCalls, true);
/*  972 */           param3FixedOutput.writeVarInt(this.cOther, true);
/*  973 */           param3FixedOutput.writeVarLong(this.sKilledEnemies, true);
/*  974 */           param3FixedOutput.writeVarLong(this.sMining, true);
/*  975 */           param3FixedOutput.writeVarLong(this.sWaveCalls, true);
/*  976 */           param3FixedOutput.writeVarLong(this.sWavesCleared, true);
/*  977 */           param3FixedOutput.writeVarInt(this.wave, true);
/*  978 */           param3FixedOutput.writeFloat(this.mdps);
/*      */         }
/*      */         
/*      */         public void read(FixedInput param3FixedInput) {
/*  982 */           this.cBounties = param3FixedInput.readVarInt(true);
/*  983 */           this.cKilledEnemies = param3FixedInput.readVarInt(true);
/*  984 */           this.cWaveCalls = param3FixedInput.readVarInt(true);
/*  985 */           this.cOther = param3FixedInput.readVarInt(true);
/*  986 */           this.sKilledEnemies = param3FixedInput.readVarLong(true);
/*  987 */           this.sMining = param3FixedInput.readVarLong(true);
/*  988 */           this.sWaveCalls = param3FixedInput.readVarLong(true);
/*  989 */           this.sWavesCleared = param3FixedInput.readVarLong(true);
/*  990 */           this.wave = param3FixedInput.readVarInt(true);
/*  991 */           this.mdps = param3FixedInput.readFloat();
/*      */         }
/*      */ 
/*      */         
/*      */         public FrameValues cpy() {
/*      */           FrameValues frameValues;
/*  997 */           (frameValues = new FrameValues()).cBounties = this.cBounties;
/*  998 */           frameValues.cKilledEnemies = this.cKilledEnemies;
/*  999 */           frameValues.cWaveCalls = this.cWaveCalls;
/* 1000 */           frameValues.cOther = this.cOther;
/* 1001 */           frameValues.sKilledEnemies = this.sKilledEnemies;
/* 1002 */           frameValues.sMining = this.sMining;
/* 1003 */           frameValues.sWaveCalls = this.sWaveCalls;
/* 1004 */           frameValues.sWavesCleared = this.sWavesCleared;
/* 1005 */           frameValues.wave = this.wave;
/* 1006 */           frameValues.mdps = this.mdps;
/*      */           
/* 1008 */           return frameValues;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ReplayManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */