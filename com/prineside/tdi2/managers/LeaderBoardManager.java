/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ @REGS(serializer = LeaderBoardManager.Serializer.class)
/*     */ public class LeaderBoardManager extends Manager.ManagerAdapter {
/*     */   private SkillPointsLeaderboardsResult b;
/*  28 */   private static final TLog a = TLog.forClass(LeaderBoardManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<LeaderBoardManager> {
/*     */     public LeaderBoardManager read() {
/*  32 */       return Game.i.leaderBoardManager;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private final Array<LeaderboardsResult> c = new Array(false, 1, LeaderboardsResult.class);
/*  41 */   private final Array<LeaderboardsRankResult> d = new Array(false, 1, LeaderboardsRankResult.class);
/*  42 */   private BasicLevelsTopLeaderboards e = new BasicLevelsTopLeaderboards(false);
/*     */   
/*     */   private boolean f = true;
/*     */   
/*  46 */   private DelayedRemovalArray<ObjectConsumer<BasicLevelsTopLeaderboards>> g = new DelayedRemovalArray(ObjectConsumer.class);
/*     */   
/*     */   private boolean h;
/*     */   
/*     */   public void setup() {
/*  51 */     Game.i.authManager.getNews(paramNewsResponse -> {
/*     */           if (paramNewsResponse != null && 207 < paramNewsResponse.networkRequiredVersion) {
/*     */             this.f = false;
/*     */             a.i("submit disabled - too low game version", new Object[0]);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeBasicLevelsTopLeaderboardsRetriever(ObjectConsumer<BasicLevelsTopLeaderboards> paramObjectConsumer) {
/*  67 */     this.g.removeValue(paramObjectConsumer, true);
/*     */   }
/*     */   
/*     */   private void a(BasicLevelsTopLeaderboards paramBasicLevelsTopLeaderboards) {
/*  71 */     this.g.begin();
/*  72 */     for (byte b = 0; b < this.g.size; b++) {
/*  73 */       ((ObjectConsumer[])this.g.items)[b].accept(paramBasicLevelsTopLeaderboards);
/*     */     }
/*  75 */     this.g.end();
/*  76 */     this.g.clear();
/*     */   }
/*     */   
/*     */   public void getBasicLevelsTopLeaderboards(ObjectConsumer<BasicLevelsTopLeaderboards> paramObjectConsumer) {
/*  80 */     DifficultyMode difficultyMode = Game.i.progressManager.getDifficultyMode();
/*     */ 
/*     */     
/*  83 */     if (this.e.success && this.e.difficultyMode == difficultyMode && Game.getTimestampSeconds() - this.e.requestTimestamp < 120) {
/*     */ 
/*     */       
/*  86 */       paramObjectConsumer.accept(this.e);
/*     */       
/*     */       return;
/*     */     } 
/*  90 */     if (!this.g.contains(paramObjectConsumer, true)) {
/*  91 */       this.g.add(paramObjectConsumer);
/*     */     }
/*     */     
/*  94 */     if (this.h) {
/*     */       return;
/*     */     }
/*     */     
/*  98 */     this.h = true;
/*     */     
/* 100 */     BasicLevelsTopLeaderboards basicLevelsTopLeaderboards = this.e;
/*     */     
/*     */     try {
/*     */       Net.HttpRequest httpRequest;
/* 104 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_BASIC_LEVELS_TOP_LEADERBOARDS_URL);
/*     */       HashMap<Object, Object> hashMap;
/* 106 */       (hashMap = new HashMap<>()).put("mode", ReplayManager.LeaderboardsMode.score.name());
/* 107 */       hashMap.put("difficulty", difficultyMode.name());
/* 108 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 109 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, difficultyMode, basicLevelsTopLeaderboards) {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 111 */               LeaderBoardManager.a(this.c, false);
/*     */               try {
/*     */                 LeaderBoardManager.BasicLevelsTopLeaderboards basicLevelsTopLeaderboards;
/* 114 */                 String str = param1HttpResponse.getResultAsString();
/*     */ 
/*     */ 
/*     */                 
/*     */                 JsonValue jsonValue;
/*     */ 
/*     */ 
/*     */                 
/* 122 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*     */ 
/*     */                   
/* 125 */                   (basicLevelsTopLeaderboards = new LeaderBoardManager.BasicLevelsTopLeaderboards(true)).difficultyMode = this.a;
/*     */ 
/*     */                   
/* 128 */                   for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = jsonValue.get("levels")).iterator(); jsonIterator.hasNext(); ) {
/* 129 */                     JsonValue jsonValue1; String str1 = (jsonValue1 = jsonIterator.next()).getString("level");
/*     */                     
/* 131 */                     jsonValue1 = jsonValue1.get("leaderboards");
/* 132 */                     Array array = new Array();
/* 133 */                     byte b = 1;
/* 134 */                     for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) {
/* 135 */                       JsonValue jsonValue2; String str2 = (jsonValue2 = jsonIterator1.next()).getString("playerid");
/* 136 */                       String str3 = jsonValue2.getString("nickname");
/* 137 */                       long l = jsonValue2.getLong("score");
/*     */                       
/* 139 */                       LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = new LeaderBoardManager.LeaderboardsEntry(str2, str3, l, b++, false, 1);
/* 140 */                       array.add(leaderboardsEntry);
/*     */                     } 
/*     */                     
/* 143 */                     basicLevelsTopLeaderboards.leaderboards.put(str1, array);
/*     */                   } 
/*     */                   
/* 146 */                   Threads.i().runOnMainThread(() -> {
/*     */                         LeaderBoardManager.b(this.c, param1BasicLevelsTopLeaderboards);
/*     */ 
/*     */                         
/*     */                         LeaderBoardManager.a(this.c);
/*     */                         
/*     */                         LeaderBoardManager.a(this.c, param1BasicLevelsTopLeaderboards);
/*     */                       });
/*     */                 } else {
/* 155 */                   LeaderBoardManager.a().e("can't retrieve leaderboards: " + basicLevelsTopLeaderboards, new Object[0]);
/* 156 */                   Threads.i().runOnMainThread(() -> LeaderBoardManager.a(this.c, param1BasicLevelsTopLeaderboards)); return;
/*     */                 } 
/* 158 */               } catch (Exception exception) {
/* 159 */                 LeaderBoardManager.a().e("Failed to parse response", new Object[] { exception });
/* 160 */                 Threads.i().runOnMainThread(() -> LeaderBoardManager.a(this.c, param1BasicLevelsTopLeaderboards));
/*     */               } 
/*     */             }
/*     */             public void failed(Throwable param1Throwable) {
/* 164 */               LeaderBoardManager.a(this.c, false);
/* 165 */               LeaderBoardManager.a().e("Error while getting leaderboards", new Object[] { param1Throwable });
/* 166 */               Threads.i().runOnMainThread(() -> LeaderBoardManager.a(this.c, param1BasicLevelsTopLeaderboards));
/*     */             }
/*     */             
/* 169 */             public void cancelled() { LeaderBoardManager.a(this.c, false);
/* 170 */               LeaderBoardManager.a().e("Timeout while getting leaderboards", new Object[0]);
/* 171 */               Threads.i().runOnMainThread(() -> LeaderBoardManager.a(this.c, param1BasicLevelsTopLeaderboards)); }
/*     */           });
/*     */       return;
/* 174 */     } catch (Exception exception) {
/*     */       
/* 176 */       this.h = false;
/* 177 */       a.e("Failed to get leaderboards", new Object[] { exception });
/* 178 */       a(basicLevelsTopLeaderboards);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getLeaderboards(GameStateSystem.GameMode paramGameMode, DifficultyMode paramDifficultyMode, String paramString, ReplayManager.LeaderboardsMode paramLeaderboardsMode, ObjectConsumer<LeaderboardsResult> paramObjectConsumer) {
/* 184 */     LeaderboardsResult leaderboardsResult1 = new LeaderboardsResult(paramGameMode, paramDifficultyMode, paramString, Game.i.authManager.getPlayerId(), false, paramLeaderboardsMode, (byte)0);
/* 185 */     for (byte b = 0; b < this.c.size; b++) {
/*     */       LeaderboardsResult leaderboardsResult;
/* 187 */       if ((leaderboardsResult = ((LeaderboardsResult[])this.c.items)[b]).gameMode == paramGameMode && leaderboardsResult.difficultyMode == paramDifficultyMode && leaderboardsResult.mapName.equals(paramString) && paramLeaderboardsMode == leaderboardsResult.mode && ((
/* 188 */         !Game.i.authManager.isSignedIn() && leaderboardsResult.playerId == null) || (Game.i.authManager.isSignedIn() && leaderboardsResult.playerId != null && leaderboardsResult.playerId.equals(Game.i.authManager.getPlayerId())))) {
/*     */         
/* 190 */         if (Game.getTimestampSeconds() - leaderboardsResult.requestTimestamp < 30) {
/*     */ 
/*     */           
/* 193 */           paramObjectConsumer.accept(leaderboardsResult);
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 198 */         leaderboardsResult1 = leaderboardsResult;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     LeaderboardsResult leaderboardsResult2 = leaderboardsResult1;
/*     */     
/*     */     try {
/*     */       Net.HttpRequest httpRequest;
/* 208 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_LEADERBOARDS_URL);
/*     */       
/*     */       HashMap<Object, Object> hashMap;
/* 211 */       (hashMap = new HashMap<>()).put("gamemode", paramGameMode.name());
/* 212 */       hashMap.put("difficulty", Game.i.progressManager.getDifficultyMode().name());
/* 213 */       hashMap.put("mapname", String.valueOf(paramString));
/* 214 */       hashMap.put("mode", paramLeaderboardsMode.name());
/*     */       
/* 216 */       if (Game.i.authManager.isSignedIn()) {
/* 217 */         hashMap.put("playerid", Game.i.authManager.getPlayerId());
/*     */       }
/*     */       
/* 220 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 221 */       String str = Game.i.authManager.getPlayerId();
/*     */       
/* 223 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramGameMode, paramDifficultyMode, paramString, str, paramLeaderboardsMode, paramObjectConsumer, leaderboardsResult2) { public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */               try {
/*     */                 LeaderBoardManager.LeaderboardsResult leaderboardsResult;
/* 226 */                 String str = param1HttpResponse.getResultAsString();
/*     */                 
/*     */                 JsonValue jsonValue;
/* 229 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*     */                   
/* 231 */                   leaderboardsResult = new LeaderBoardManager.LeaderboardsResult(this.a, this.b, this.c, this.d, true, this.e, (byte)0);
/*     */                   
/* 233 */                   if (jsonValue.has("player")) {
/* 234 */                     JsonValue jsonValue2 = jsonValue.get("player");
/* 235 */                     leaderboardsResult.player = new LeaderBoardManager.LeaderboardsRankResult(true, this.b, this.e, false, this.a, this.c, this.d, (byte)0);
/* 236 */                     leaderboardsResult.player.total = jsonValue2.getInt("total");
/* 237 */                     leaderboardsResult.player.rank = jsonValue2.getInt("rank");
/* 238 */                     leaderboardsResult.player.score = jsonValue2.getLong("score");
/*     */                   } 
/*     */                   
/* 241 */                   JsonValue jsonValue1 = jsonValue.get("leaderboards");
/* 242 */                   byte b = 1;
/* 243 */                   for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue2 = jsonIterator.next();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 250 */                     LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = new LeaderBoardManager.LeaderboardsEntry(jsonValue2.getString("playerid"), jsonValue2.getString("nickname"), jsonValue2.getLong("score"), b++, jsonValue2.getBoolean("hasPfp", false), jsonValue2.getInt("level", 1));
/*     */ 
/*     */                     
/* 253 */                     if ((jsonValue2 = jsonValue2.get("pinnedBadge")) != null) {
/* 254 */                       leaderboardsEntry.badgeIconTexture = jsonValue2.getString("iconImg");
/* 255 */                       leaderboardsEntry.badgeIconColor = Color.valueOf(jsonValue2.getString("iconColor", "FFFFFF"));
/* 256 */                       leaderboardsEntry.badgeOverlayTexture = jsonValue2.getString("overlayImg", null);
/* 257 */                       leaderboardsEntry.badgeOverlayColor = Color.valueOf(jsonValue2.getString("overlayColor", "FFFFFF"));
/*     */                     } 
/* 259 */                     leaderboardsResult.entries.add(leaderboardsEntry); }
/*     */ 
/*     */                   
/* 262 */                   Threads.i().runOnMainThread(() -> {
/*     */                         LeaderBoardManager.b(this.h).add(param1LeaderboardsResult);
/*     */                         
/*     */                         LeaderBoardManager.a(this.h);
/*     */                         
/*     */                         param1ObjectConsumer.accept(param1LeaderboardsResult);
/*     */                       });
/*     */                 } else {
/* 270 */                   LeaderBoardManager.a().e("can't retrieve leaderboards: " + leaderboardsResult, new Object[0]);
/* 271 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsResult)); return;
/*     */                 } 
/* 273 */               } catch (Exception exception) {
/* 274 */                 LeaderBoardManager.a().e("Failed to parse response", new Object[] { exception });
/* 275 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsResult));
/*     */               } 
/*     */             }
/*     */             public void failed(Throwable param1Throwable) {
/* 279 */               LeaderBoardManager.a().e("Error while getting leaderboards", new Object[] { param1Throwable });
/* 280 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsResult));
/*     */             }
/*     */             
/* 283 */             public void cancelled() { LeaderBoardManager.a().e("Timeout while getting leaderboards", new Object[0]);
/* 284 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsResult)); } }
/*     */         );
/*     */       return;
/* 287 */     } catch (Exception exception) {
/*     */       
/* 289 */       a.e("Failed to get leaderboards", new Object[] { exception });
/* 290 */       paramObjectConsumer.accept(leaderboardsResult2);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getSkillPointLeaderboards(ObjectConsumer<SkillPointsLeaderboardsResult> paramObjectConsumer) {
/* 296 */     SkillPointsLeaderboardsResult skillPointsLeaderboardsResult = new SkillPointsLeaderboardsResult(Game.i.authManager.getPlayerId(), false, (byte)0);
/* 297 */     if (this.b != null && ((
/* 298 */       !Game.i.authManager.isSignedIn() && this.b.playerId == null) || (Game.i.authManager.isSignedIn() && this.b.playerId != null && this.b.playerId.equals(Game.i.authManager.getPlayerId())))) {
/*     */       
/* 300 */       if (Game.getTimestampSeconds() - this.b.requestTimestamp < 30) {
/*     */ 
/*     */ 
/*     */         
/* 304 */         paramObjectConsumer.accept(this.b);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 309 */       skillPointsLeaderboardsResult = this.b;
/*     */     } 
/*     */     
/* 312 */     skillPointsLeaderboardsResult = skillPointsLeaderboardsResult;
/*     */     
/*     */     try {
/*     */       Net.HttpRequest httpRequest;
/* 316 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_SKILL_POINT_LEADER_BOARD_URL);
/*     */       
/* 318 */       if (Game.i.authManager.isSignedIn()) {
/*     */         HashMap<Object, Object> hashMap;
/* 320 */         (hashMap = new HashMap<>()).put("playerid", Game.i.authManager.getPlayerId());
/* 321 */         httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */       } 
/*     */       
/* 324 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer, skillPointsLeaderboardsResult) {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */               try {
/* 327 */                 String str = param1HttpResponse.getResultAsString();
/*     */                 
/*     */                 JsonValue jsonValue;
/* 330 */                 if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*     */                   
/* 332 */                   Threads.i().runOnMainThread(() -> {
/*     */                         LeaderBoardManager.SkillPointsLeaderboardsResult skillPointsLeaderboardsResult = new LeaderBoardManager.SkillPointsLeaderboardsResult(Game.i.authManager.getPlayerId(), true, (byte)0);
/*     */ 
/*     */                         
/*     */                         if (param1JsonValue.has("player")) {
/*     */                           JsonValue jsonValue1 = param1JsonValue.get("player");
/*     */                           
/*     */                           skillPointsLeaderboardsResult.player = new LeaderBoardManager.SkillPointsLeaderboardsRank(true, Game.i.authManager.getPlayerId(), (byte)0);
/*     */                           
/*     */                           skillPointsLeaderboardsResult.player.score = jsonValue1.getInt("score");
/*     */                         } 
/*     */                         
/*     */                         JsonValue jsonValue = param1JsonValue.get("leaderboards");
/*     */                         
/*     */                         byte b = 1;
/*     */                         
/*     */                         JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator();
/*     */                         
/*     */                         while (jsonIterator.hasNext()) {
/*     */                           JsonValue jsonValue1 = jsonIterator.next();
/*     */                           
/*     */                           skillPointsLeaderboardsResult.entries.add(new LeaderBoardManager.LeaderboardsEntry(jsonValue1.getString("playerid"), jsonValue1.getString("nickname"), jsonValue1.getInt("score"), b++, jsonValue1.getBoolean("hasPfp", false), jsonValue1.getInt("level", 1)));
/*     */                         } 
/*     */                         
/*     */                         LeaderBoardManager.a(this.c, skillPointsLeaderboardsResult);
/*     */                         
/*     */                         LeaderBoardManager.a(this.c);
/*     */                         
/*     */                         param1ObjectConsumer.accept(skillPointsLeaderboardsResult);
/*     */                       });
/*     */                 } else {
/* 363 */                   LeaderBoardManager.a().e("can't retrieve skill point leaderboards: " + str, new Object[0]);
/* 364 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1SkillPointsLeaderboardsResult)); return;
/*     */                 } 
/* 366 */               } catch (Exception exception) {
/* 367 */                 LeaderBoardManager.a().e("Failed to parse response", new Object[] { exception });
/* 368 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1SkillPointsLeaderboardsResult));
/*     */               } 
/*     */             }
/*     */             public void failed(Throwable param1Throwable) {
/* 372 */               LeaderBoardManager.a().e("Error while getting skill point leaderboards", new Object[] { param1Throwable });
/* 373 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1SkillPointsLeaderboardsResult));
/*     */             }
/*     */             
/* 376 */             public void cancelled() { LeaderBoardManager.a().e("Timeout while getting skill point leaderboards", new Object[0]);
/* 377 */               Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1SkillPointsLeaderboardsResult)); }
/*     */           });
/*     */       return;
/* 380 */     } catch (Exception exception) {
/*     */       
/* 382 */       a.e("Failed to get skill point leaderboards", new Object[] { exception });
/* 383 */       paramObjectConsumer.accept(skillPointsLeaderboardsResult);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getLeaderboardsRank(GameStateSystem.GameMode paramGameMode, DifficultyMode paramDifficultyMode, String paramString, ReplayManager.LeaderboardsMode paramLeaderboardsMode, ObjectConsumer<LeaderboardsRankResult> paramObjectConsumer) {
/* 389 */     LeaderboardsRankResult leaderboardsRankResult1 = new LeaderboardsRankResult(false, paramDifficultyMode, paramLeaderboardsMode, false, paramGameMode, paramString, Game.i.authManager.getPlayerId(), (byte)0);
/* 390 */     for (byte b = 0; b < this.d.size; b++) {
/*     */       LeaderboardsRankResult leaderboardsRankResult;
/* 392 */       if ((leaderboardsRankResult = ((LeaderboardsRankResult[])this.d.items)[b]).gameMode == paramGameMode && leaderboardsRankResult.mapName.equals(paramString) && paramLeaderboardsMode == leaderboardsRankResult.mode && ((
/* 393 */         !Game.i.authManager.isSignedIn() && leaderboardsRankResult.playerId == null) || (Game.i.authManager.isSignedIn() && leaderboardsRankResult.playerId != null && leaderboardsRankResult.playerId.equals(Game.i.authManager.getPlayerId())))) {
/*     */         
/* 395 */         if (Game.getTimestampSeconds() - leaderboardsRankResult.requestTimestamp < 30) {
/*     */ 
/*     */ 
/*     */           
/* 399 */           paramObjectConsumer.accept(leaderboardsRankResult);
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 404 */         leaderboardsRankResult1 = leaderboardsRankResult;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 410 */     LeaderboardsRankResult leaderboardsRankResult2 = leaderboardsRankResult1;
/*     */     
/* 412 */     if (Game.i.authManager.isSignedIn() && Game.i.authManager.getPlayerId() != null) {
/*     */       try {
/*     */         Net.HttpRequest httpRequest;
/*     */         
/* 416 */         (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_LEADERBOARDS_RANK_URL);
/*     */         
/*     */         HashMap<Object, Object> hashMap;
/* 419 */         (hashMap = new HashMap<>()).put("gamemode", paramGameMode.name());
/* 420 */         hashMap.put("difficulty", paramDifficultyMode.name());
/* 421 */         hashMap.put("mapname", String.valueOf(paramString));
/* 422 */         hashMap.put("mode", paramLeaderboardsMode.name());
/* 423 */         hashMap.put("playerid", Game.i.authManager.getPlayerId());
/*     */         
/* 425 */         httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 426 */         Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramDifficultyMode, paramLeaderboardsMode, paramGameMode, paramString, paramObjectConsumer, leaderboardsRankResult2) {
/*     */               public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */                 try {
/* 429 */                   String str = param1HttpResponse.getResultAsString();
/*     */                   
/*     */                   JsonValue jsonValue;
/* 432 */                   if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*     */                     
/* 434 */                     Threads.i().runOnMainThread(() -> {
/*     */                           param1JsonValue = param1JsonValue.get("player");
/*     */                           
/*     */                           LeaderBoardManager.LeaderboardsRankResult leaderboardsRankResult;
/*     */                           
/*     */                           (leaderboardsRankResult = new LeaderBoardManager.LeaderboardsRankResult(true, param1DifficultyMode, param1LeaderboardsMode, false, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0)).rank = param1JsonValue.getInt("rank");
/*     */                           
/*     */                           leaderboardsRankResult.score = param1JsonValue.getLong("score");
/*     */                           
/*     */                           leaderboardsRankResult.total = param1JsonValue.getInt("total");
/*     */                           LeaderBoardManager.c(this.g).add(leaderboardsRankResult);
/*     */                           LeaderBoardManager.a(this.g);
/*     */                           param1ObjectConsumer.accept(leaderboardsRankResult);
/*     */                         });
/*     */                   } else {
/* 449 */                     LeaderBoardManager.a().e("can't retrieve leaderboards rank: " + str, new Object[0]);
/* 450 */                     Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsRankResult)); return;
/*     */                   } 
/* 452 */                 } catch (Exception exception) {
/* 453 */                   LeaderBoardManager.a().e("Failed to parse response", new Object[] { exception });
/* 454 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsRankResult));
/*     */                 } 
/*     */               }
/*     */               public void failed(Throwable param1Throwable) {
/* 458 */                 LeaderBoardManager.a().e("Error while getting leaderboards rank", new Object[] { param1Throwable });
/* 459 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsRankResult));
/*     */               }
/*     */               
/* 462 */               public void cancelled() { LeaderBoardManager.a().e("Timeout while getting leaderboards rank", new Object[0]);
/* 463 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(param1LeaderboardsRankResult)); }
/*     */             });
/*     */         return;
/* 466 */       } catch (Exception exception) {
/*     */         
/* 468 */         a.e("Failed to get leaderboards rank", new Object[] { exception });
/* 469 */         paramObjectConsumer.accept(leaderboardsRankResult2);
/*     */         return;
/*     */       } 
/*     */     }
/* 473 */     a.e("not signed in, can't get rank", new Object[0]);
/* 474 */     paramObjectConsumer.accept(leaderboardsRankResult2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void getLeaderboardsAdvanceRank(GameStateSystem.GameMode paramGameMode, DifficultyMode paramDifficultyMode, String paramString, ReplayManager.LeaderboardsMode paramLeaderboardsMode, long paramLong, ObjectConsumer<LeaderboardsRankResult> paramObjectConsumer) {
/* 479 */     if (Game.i.authManager.isSignedIn()) {
/*     */       
/* 481 */       if (!this.f) {
/* 482 */         a.e("submit disabled, can't get advance rank", new Object[0]);
/* 483 */         paramObjectConsumer.accept(new LeaderboardsRankResult(false, paramDifficultyMode, paramLeaderboardsMode, true, paramGameMode, paramString, Game.i.authManager.getPlayerId(), (byte)0));
/*     */         
/*     */         return;
/*     */       } 
/*     */       try {
/*     */         Net.HttpRequest httpRequest;
/* 489 */         (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_LEADERBOARDS_ADVANCE_RANK_URL);
/*     */         
/*     */         HashMap<Object, Object> hashMap;
/* 492 */         (hashMap = new HashMap<>()).put("gamemode", paramGameMode.name());
/* 493 */         hashMap.put("difficulty", Game.i.progressManager.getDifficultyMode().name());
/* 494 */         hashMap.put("mapname", String.valueOf(paramString));
/* 495 */         hashMap.put("mode", paramLeaderboardsMode.name());
/* 496 */         hashMap.put("playerid", Game.i.authManager.getPlayerId());
/* 497 */         hashMap.put("score", String.valueOf(paramLong));
/*     */         
/* 499 */         httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 500 */         Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramDifficultyMode, paramLeaderboardsMode, paramGameMode, paramString, paramObjectConsumer) {
/*     */               public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */                 try {
/* 503 */                   String str = param1HttpResponse.getResultAsString();
/*     */                   
/*     */                   JsonValue jsonValue;
/* 506 */                   if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) {
/*     */                     
/* 508 */                     Threads.i().runOnMainThread(() -> {
/*     */                           param1JsonValue = param1JsonValue.get("player");
/*     */                           
/*     */                           LeaderBoardManager.LeaderboardsRankResult leaderboardsRankResult;
/*     */                           
/*     */                           (leaderboardsRankResult = new LeaderBoardManager.LeaderboardsRankResult(true, param1DifficultyMode, param1LeaderboardsMode, true, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0)).rank = param1JsonValue.getInt("rank");
/*     */                           
/*     */                           leaderboardsRankResult.total = param1JsonValue.getInt("total");
/*     */                           param1ObjectConsumer.accept(leaderboardsRankResult);
/*     */                         });
/*     */                   } else {
/* 519 */                     LeaderBoardManager.a().e("can't retrieve advance leaderboards rank: " + str, new Object[0]);
/* 520 */                     Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(new LeaderBoardManager.LeaderboardsRankResult(false, param1DifficultyMode, param1LeaderboardsMode, true, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0))); return;
/*     */                   } 
/* 522 */                 } catch (Exception exception) {
/* 523 */                   LeaderBoardManager.a().e("Failed to parse response", new Object[] { exception });
/* 524 */                   Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(new LeaderBoardManager.LeaderboardsRankResult(false, param1DifficultyMode, param1LeaderboardsMode, true, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0)));
/*     */                 } 
/*     */               }
/*     */               public void failed(Throwable param1Throwable) {
/* 528 */                 LeaderBoardManager.a().e("Error while getting advance leaderboards rank", new Object[] { param1Throwable });
/* 529 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(new LeaderBoardManager.LeaderboardsRankResult(false, param1DifficultyMode, param1LeaderboardsMode, true, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0)));
/*     */               }
/*     */               
/* 532 */               public void cancelled() { LeaderBoardManager.a().e("Timeout while getting advance leaderboards rank", new Object[0]);
/* 533 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(new LeaderBoardManager.LeaderboardsRankResult(false, param1DifficultyMode, param1LeaderboardsMode, true, param1GameMode, param1String, Game.i.authManager.getPlayerId(), (byte)0))); }
/*     */             });
/*     */         return;
/* 536 */       } catch (Exception exception) {
/*     */         
/* 538 */         a.e("Failed to get advance leaderboards rank", new Object[] { exception });
/* 539 */         paramObjectConsumer.accept(new LeaderboardsRankResult(false, paramDifficultyMode, paramLeaderboardsMode, true, paramGameMode, paramString, Game.i.authManager.getPlayerId(), (byte)0));
/*     */         return;
/*     */       } 
/*     */     } 
/* 543 */     a.e("not signed in, can't get advance rank", new Object[0]);
/* 544 */     paramObjectConsumer.accept(new LeaderboardsRankResult(false, paramDifficultyMode, paramLeaderboardsMode, true, paramGameMode, paramString, Game.i.authManager.getPlayerId(), (byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BasicLevelsTopLeaderboards
/*     */   {
/*     */     public boolean success;
/*     */     public DifficultyMode difficultyMode;
/*     */     public int requestTimestamp;
/* 553 */     public ObjectMap<String, Array<LeaderBoardManager.LeaderboardsEntry>> leaderboards = new ObjectMap();
/*     */     
/*     */     public BasicLevelsTopLeaderboards(boolean param1Boolean) {
/* 556 */       this.success = param1Boolean;
/* 557 */       this.requestTimestamp = Game.getTimestampSeconds();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 564 */       param1Json.writeValue("rt", Integer.valueOf(this.requestTimestamp));
/* 565 */       param1Json.writeValue("dm", this.difficultyMode.name());
/*     */       
/* 567 */       param1Json.writeArrayStart("l");
/* 568 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = this.leaderboards.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 569 */         param1Json.writeArrayStart((String)entry.key);
/* 570 */         Array array = (Array)entry.value;
/* 571 */         for (byte b = 0; b < array.size; b++) {
/* 572 */           param1Json.writeObjectStart();
/* 573 */           ((LeaderBoardManager.LeaderboardsEntry)array.get(b)).toJson(param1Json);
/* 574 */           param1Json.writeObjectEnd();
/*     */         } 
/* 576 */         param1Json.writeArrayEnd(); }
/*     */       
/* 578 */       param1Json.writeArrayEnd();
/*     */     }
/*     */ 
/*     */     
/*     */     public static BasicLevelsTopLeaderboards fromJson(JsonValue param1JsonValue) {
/*     */       BasicLevelsTopLeaderboards basicLevelsTopLeaderboards;
/* 584 */       (basicLevelsTopLeaderboards = new BasicLevelsTopLeaderboards(true)).requestTimestamp = param1JsonValue.getInt("rt");
/* 585 */       basicLevelsTopLeaderboards.difficultyMode = DifficultyMode.valueOf(param1JsonValue.getString("dm"));
/*     */ 
/*     */       
/* 588 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (param1JsonValue = param1JsonValue.get("l")).iterator(); jsonIterator.hasNext(); ) {
/* 589 */         JsonValue jsonValue; String str = (jsonValue = jsonIterator.next()).name;
/* 590 */         Array array = new Array();
/* 591 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue1 = jsonIterator1.next();
/* 592 */           array.add(LeaderBoardManager.LeaderboardsEntry.fromJson(jsonValue1)); }
/*     */         
/* 594 */         basicLevelsTopLeaderboards.leaderboards.put(str, array);
/*     */       } 
/*     */       
/* 597 */       return basicLevelsTopLeaderboards;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SkillPointsLeaderboardsResult
/*     */   {
/*     */     public boolean success;
/*     */     public int requestTimestamp;
/*     */     public String playerId;
/* 607 */     public LeaderBoardManager.SkillPointsLeaderboardsRank player = null;
/* 608 */     public Array<LeaderBoardManager.LeaderboardsEntry> entries = new Array();
/*     */     
/*     */     private SkillPointsLeaderboardsResult(String param1String, boolean param1Boolean) {
/* 611 */       this.playerId = param1String;
/* 612 */       this.success = param1Boolean;
/*     */       
/* 614 */       this.requestTimestamp = Game.getTimestampSeconds();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LeaderboardsResult
/*     */   {
/*     */     public boolean success;
/*     */     public int requestTimestamp;
/*     */     public GameStateSystem.GameMode gameMode;
/*     */     public DifficultyMode difficultyMode;
/*     */     public String mapName;
/*     */     public String playerId;
/*     */     public ReplayManager.LeaderboardsMode mode;
/* 627 */     public LeaderBoardManager.LeaderboardsRankResult player = null;
/* 628 */     public Array<LeaderBoardManager.LeaderboardsEntry> entries = new Array();
/*     */     
/*     */     private LeaderboardsResult(GameStateSystem.GameMode param1GameMode, DifficultyMode param1DifficultyMode, String param1String1, String param1String2, boolean param1Boolean, ReplayManager.LeaderboardsMode param1LeaderboardsMode) {
/* 631 */       this.gameMode = param1GameMode;
/* 632 */       this.difficultyMode = param1DifficultyMode;
/* 633 */       this.mapName = param1String1;
/* 634 */       this.playerId = param1String2;
/* 635 */       this.success = param1Boolean;
/* 636 */       this.mode = param1LeaderboardsMode;
/*     */       
/* 638 */       this.requestTimestamp = Game.getTimestampSeconds();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 645 */       if (!this.success) throw new IllegalStateException("This result is failed, can't save to json");
/*     */       
/* 647 */       param1Json.writeValue("rt", Integer.valueOf(this.requestTimestamp));
/*     */       
/* 649 */       param1Json.writeValue("gm", this.gameMode.name());
/* 650 */       param1Json.writeValue("dm", this.difficultyMode.name());
/* 651 */       param1Json.writeValue("mn", this.mapName);
/* 652 */       if (this.playerId != null) param1Json.writeValue("pi", this.playerId); 
/* 653 */       param1Json.writeValue("m", this.mode.name());
/* 654 */       if (this.player != null) {
/* 655 */         param1Json.writeObjectStart("p");
/* 656 */         this.player.toJson(param1Json);
/* 657 */         param1Json.writeObjectEnd();
/*     */       } 
/* 659 */       param1Json.writeArrayStart("e");
/* 660 */       for (byte b = 0; b < this.entries.size; b++) {
/* 661 */         param1Json.writeObjectStart();
/* 662 */         ((LeaderBoardManager.LeaderboardsEntry)this.entries.get(b)).toJson(param1Json);
/* 663 */         param1Json.writeObjectEnd();
/*     */       } 
/* 665 */       param1Json.writeArrayEnd();
/*     */     }
/*     */     
/*     */     public static LeaderboardsResult fromJson(JsonValue param1JsonValue) {
/* 669 */       GameStateSystem.GameMode gameMode = GameStateSystem.GameMode.valueOf(param1JsonValue.getString("gm"));
/* 670 */       String str1 = param1JsonValue.getString("mn");
/* 671 */       String str2 = param1JsonValue.getString("pi", null);
/* 672 */       ReplayManager.LeaderboardsMode leaderboardsMode = ReplayManager.LeaderboardsMode.valueOf(param1JsonValue.getString("m"));
/* 673 */       DifficultyMode difficultyMode = DifficultyMode.NORMAL;
/*     */       try {
/* 675 */         difficultyMode = DifficultyMode.valueOf(param1JsonValue.getString("dm"));
/* 676 */       } catch (Exception exception) {}
/*     */       
/* 678 */       LeaderboardsResult leaderboardsResult = new LeaderboardsResult(gameMode, difficultyMode, str1, str2, true, leaderboardsMode);
/* 679 */       if (param1JsonValue.has("p")) {
/* 680 */         leaderboardsResult.player = LeaderBoardManager.LeaderboardsRankResult.fromJson(param1JsonValue.get("p"));
/*     */       }
/*     */       
/*     */       JsonValue jsonValue;
/* 684 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = param1JsonValue.get("e")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 685 */         leaderboardsResult.entries.add(LeaderBoardManager.LeaderboardsEntry.fromJson(jsonValue1)); }
/*     */ 
/*     */       
/* 688 */       leaderboardsResult.requestTimestamp = param1JsonValue.getInt("rt");
/*     */       
/* 690 */       return leaderboardsResult;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LeaderboardsEntry {
/*     */     public String playerId;
/*     */     public String nickname;
/*     */     public boolean hasProfilePicture;
/*     */     public int profileLevel;
/*     */     public long score;
/*     */     public int rank;
/*     */     public String badgeIconTexture;
/*     */     public Color badgeIconColor;
/*     */     public String badgeOverlayTexture;
/*     */     public Color badgeOverlayColor;
/*     */     
/*     */     public LeaderboardsEntry(String param1String1, String param1String2, long param1Long, int param1Int1, boolean param1Boolean, int param1Int2) {
/* 707 */       this.playerId = param1String1;
/* 708 */       this.nickname = param1String2;
/* 709 */       this.score = param1Long;
/* 710 */       this.rank = param1Int1;
/* 711 */       this.hasProfilePicture = param1Boolean;
/* 712 */       this.profileLevel = param1Int2;
/* 713 */       if (this.profileLevel <= 0) {
/* 714 */         this.profileLevel = 1;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 722 */       param1Json.writeValue("p", this.playerId);
/* 723 */       param1Json.writeValue("n", this.nickname);
/* 724 */       param1Json.writeValue("s", Long.valueOf(this.score));
/* 725 */       param1Json.writeValue("r", Integer.valueOf(this.rank));
/* 726 */       param1Json.writeValue("hpp", Boolean.valueOf(this.hasProfilePicture));
/* 727 */       param1Json.writeValue("pl", Integer.valueOf(this.profileLevel));
/* 728 */       if (this.badgeIconTexture != null) param1Json.writeValue("bit", this.badgeIconTexture); 
/* 729 */       if (this.badgeIconColor != null) param1Json.writeValue("bic", this.badgeIconColor.toString()); 
/* 730 */       if (this.badgeOverlayTexture != null) param1Json.writeValue("bot", this.badgeOverlayTexture); 
/* 731 */       if (this.badgeOverlayColor != null) param1Json.writeValue("boc", this.badgeOverlayColor);
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static LeaderboardsEntry fromJson(JsonValue param1JsonValue) {
/*     */       LeaderboardsEntry leaderboardsEntry;
/* 743 */       (leaderboardsEntry = new LeaderboardsEntry(param1JsonValue.getString("p"), param1JsonValue.getString("n"), param1JsonValue.getLong("s"), param1JsonValue.getInt("r"), param1JsonValue.getBoolean("hpp"), param1JsonValue.getInt("pl"))).badgeIconTexture = param1JsonValue.getString("bit", null);
/* 744 */       leaderboardsEntry.badgeIconColor = Color.valueOf(param1JsonValue.getString("bic", "FFFFFFFF"));
/* 745 */       leaderboardsEntry.badgeOverlayTexture = param1JsonValue.getString("bot", null);
/* 746 */       leaderboardsEntry.badgeOverlayColor = Color.valueOf(param1JsonValue.getString("boc", "FFFFFFFF"));
/*     */       
/* 748 */       return leaderboardsEntry;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SkillPointsLeaderboardsRank
/*     */   {
/*     */     public boolean success;
/*     */     
/*     */     public int requestTimestamp;
/*     */     public String playerId;
/*     */     public int score;
/*     */     
/*     */     private SkillPointsLeaderboardsRank(boolean param1Boolean, String param1String) {
/* 762 */       this.playerId = param1String;
/* 763 */       this.success = param1Boolean;
/*     */       
/* 765 */       this.requestTimestamp = Game.getTimestampSeconds();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LeaderboardsRankResult
/*     */   {
/*     */     public boolean success;
/*     */     public int requestTimestamp;
/*     */     public ReplayManager.LeaderboardsMode mode;
/*     */     public boolean isAdvance;
/*     */     public GameStateSystem.GameMode gameMode;
/*     */     public DifficultyMode difficultyMode;
/*     */     public String mapName;
/*     */     public String playerId;
/*     */     public int rank;
/*     */     public long score;
/*     */     public int total;
/*     */     
/*     */     private LeaderboardsRankResult(boolean param1Boolean1, DifficultyMode param1DifficultyMode, ReplayManager.LeaderboardsMode param1LeaderboardsMode, boolean param1Boolean2, GameStateSystem.GameMode param1GameMode, String param1String1, String param1String2) {
/* 784 */       this.isAdvance = param1Boolean2;
/* 785 */       this.difficultyMode = param1DifficultyMode;
/* 786 */       this.gameMode = param1GameMode;
/* 787 */       this.mapName = param1String1;
/* 788 */       this.playerId = param1String2;
/* 789 */       this.success = param1Boolean1;
/* 790 */       this.mode = param1LeaderboardsMode;
/*     */       
/* 792 */       this.requestTimestamp = Game.getTimestampSeconds();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 799 */       if (!this.success) throw new IllegalStateException("This result is failed, can't save to json"); 
/* 800 */       if (this.isAdvance) throw new IllegalStateException("This result is advance, can't save to json");
/*     */       
/* 802 */       param1Json.writeValue("rt", Integer.valueOf(this.requestTimestamp));
/*     */       
/* 804 */       param1Json.writeValue("m", this.mode.name());
/* 805 */       param1Json.writeValue("a", Boolean.FALSE);
/* 806 */       param1Json.writeValue("gm", this.gameMode.name());
/* 807 */       param1Json.writeValue("dm", this.difficultyMode.name());
/* 808 */       param1Json.writeValue("mn", this.mapName);
/* 809 */       param1Json.writeValue("pi", this.playerId);
/* 810 */       param1Json.writeValue("r", Integer.valueOf(this.rank));
/* 811 */       param1Json.writeValue("s", Long.valueOf(this.score));
/* 812 */       param1Json.writeValue("t", Integer.valueOf(this.total));
/*     */     }
/*     */     
/*     */     public static LeaderboardsRankResult fromJson(JsonValue param1JsonValue) {
/* 816 */       ReplayManager.LeaderboardsMode leaderboardsMode = ReplayManager.LeaderboardsMode.valueOf(param1JsonValue.getString("m"));
/* 817 */       GameStateSystem.GameMode gameMode = GameStateSystem.GameMode.valueOf(param1JsonValue.getString("gm"));
/* 818 */       DifficultyMode difficultyMode = DifficultyMode.NORMAL;
/*     */       try {
/* 820 */         difficultyMode = DifficultyMode.valueOf(param1JsonValue.getString("dm"));
/* 821 */       } catch (Exception exception) {}
/* 822 */       String str1 = param1JsonValue.getString("mn");
/* 823 */       String str2 = param1JsonValue.getString("pi");
/* 824 */       boolean bool = param1JsonValue.getBoolean("a");
/*     */       
/*     */       LeaderboardsRankResult leaderboardsRankResult;
/*     */       
/* 828 */       (leaderboardsRankResult = new LeaderboardsRankResult(true, difficultyMode, leaderboardsMode, bool, gameMode, str1, str2)).score = param1JsonValue.getLong("s");
/* 829 */       leaderboardsRankResult.rank = param1JsonValue.getInt("r");
/* 830 */       leaderboardsRankResult.total = param1JsonValue.getInt("t");
/*     */       
/* 832 */       leaderboardsRankResult.requestTimestamp = param1JsonValue.getInt("rt");
/*     */       
/* 834 */       return leaderboardsRankResult;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\LeaderBoardManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */