/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.systems.QuestSystem;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.ref.SoftReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicLevel
/*     */ {
/*  29 */   private static final TLog a = TLog.forClass(BasicLevel.class);
/*     */   
/*     */   public String name;
/*     */   public String stageName;
/*     */   public int stagePosition;
/*  34 */   public DifficultyMode forcedDifficulty = null;
/*     */   public int seed;
/*  36 */   public int fastForwardFrame = 0;
/*     */   
/*     */   public boolean hasLeaderboards;
/*     */   
/*     */   public boolean notAffectsStatistics;
/*     */   public boolean achievementsDisabled;
/*     */   public boolean customWaves;
/*     */   public boolean fixedQuests;
/*     */   public boolean isBonus;
/*     */   public boolean dailyQuest;
/*  46 */   public final Array<Requirement> openRequirements = new Array(Requirement.class);
/*  47 */   public final Array<Requirement> showRequirements = new Array(Requirement.class);
/*     */   public int priceInMoney;
/*  49 */   public final int[] priceInResources = new int[ResourceType.values.length];
/*  50 */   public final Array<BasicLevelQuestConfig> quests = new Array(BasicLevelQuestConfig.class);
/*  51 */   public final Array<WaveQuest> waveQuests = new Array(WaveQuest.class);
/*     */   public WaveTemplates.PredefinedWaveTemplate[] enemyWaves;
/*  53 */   public float difficultyExpectedPlaytime = 1.0F;
/*     */   
/*  55 */   private SoftReference<Map> b = null;
/*     */ 
/*     */   
/*     */   @Null
/*     */   public BonusStagesConfig bonusStagesConfig;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPurchased() {
/*  64 */     return (ProgressPrefs.i()).basicLevel.isLevelPurchased(this.name);
/*     */   }
/*     */   
/*     */   public boolean isPurchasedOrPlayed() {
/*  68 */     return (ProgressPrefs.i()).basicLevel.isLevelPurchasedOrPlayed(this.name);
/*     */   }
/*     */   
/*     */   public BasicLevel clone(String paramString) {
/*  72 */     Json json = new Json(JsonWriter.OutputType.json);
/*  73 */     StringWriter stringWriter = new StringWriter();
/*  74 */     json.setWriter(stringWriter);
/*     */     
/*  76 */     json.writeObjectStart();
/*  77 */     toJson(json);
/*  78 */     json.writeObjectEnd();
/*     */     
/*     */     BasicLevel basicLevel;
/*     */     JsonValue jsonValue;
/*  82 */     (basicLevel = fromJson(jsonValue = (new JsonReader()).parse(stringWriter.toString()))).name = paramString;
/*  83 */     basicLevel.b = null;
/*  84 */     if (this.bonusStagesConfig != null) {
/*  85 */       basicLevel.bonusStagesConfig = this.bonusStagesConfig.cpy();
/*     */     }
/*     */     
/*  88 */     AssetManager.localOrInternalFile("levels/maps/" + this.name + ".json").copyTo(Gdx.files
/*  89 */         .local("levels/maps/" + paramString + ".json"));
/*     */ 
/*     */     
/*  92 */     basicLevel.saveToDisk();
/*     */     
/*  94 */     return basicLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasicLevel createNew(String paramString) {
/*     */     BasicLevel basicLevel;
/* 100 */     (basicLevel = new BasicLevel()).name = paramString;
/* 101 */     basicLevel.stageName = "-1";
/* 102 */     basicLevel.seed = FastRandom.getFairInt(8999) + 1000;
/*     */     
/* 104 */     return basicLevel;
/*     */   }
/*     */   
/*     */   public void saveToDisk() {
/* 108 */     Json json = new Json(JsonWriter.OutputType.json);
/* 109 */     StringWriter stringWriter = new StringWriter();
/* 110 */     json.setWriter(stringWriter);
/*     */     
/* 112 */     json.writeObjectStart();
/* 113 */     toJson(json);
/* 114 */     json.writeObjectEnd();
/*     */     
/* 116 */     Gdx.files.local("levels/" + this.name + ".json").writeString((new JsonReader()).parse(stringWriter.toString()).prettyPrint(JsonWriter.OutputType.json, 2), false, "UTF-8");
/*     */ 
/*     */     
/* 119 */     if (!Gdx.files.internal("levels/maps/" + this.name + ".json").exists() && !Gdx.files.local("levels/maps/" + this.name + ".json").exists()) {
/* 120 */       Map map = new Map(3, 3);
/*     */       
/* 122 */       json = new Json(JsonWriter.OutputType.json);
/* 123 */       stringWriter = new StringWriter();
/* 124 */       json.setWriter(stringWriter);
/* 125 */       json.writeObjectStart();
/* 126 */       map.toJson(json);
/* 127 */       json.writeObjectEnd();
/*     */       
/* 129 */       String str = (new JsonReader()).parse((new JsonReader()).parse(stringWriter.toString()).prettyPrint(JsonWriter.OutputType.json, 2)).prettyPrint(JsonWriter.OutputType.json, 2);
/* 130 */       Gdx.files.local("levels/maps/" + this.name + ".json").writeString(str, false, "UTF-8");
/* 131 */       a.i("created dummy map for level " + this.name, new Object[0]);
/*     */     } 
/* 133 */     a.i("level " + this.name + " saved on disk", new Object[0]);
/*     */   }
/*     */   
/*     */   public String toJsonStringEverything() {
/* 137 */     Json json = new Json(JsonWriter.OutputType.json);
/* 138 */     StringWriter stringWriter = new StringWriter();
/* 139 */     json.setWriter(stringWriter);
/*     */     
/* 141 */     json.writeObjectStart();
/*     */     
/* 143 */     json.writeValue("_type", "BASIC_LEVEL_FULL");
/* 144 */     json.writeObjectStart("configuration");
/* 145 */     toJson(json);
/* 146 */     json.writeObjectEnd();
/*     */     
/* 148 */     json.writeObjectStart("map");
/* 149 */     getMap().toJson(json);
/* 150 */     json.writeObjectEnd();
/*     */     
/* 152 */     json.writeObjectEnd();
/*     */     
/* 154 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 161 */     paramJson.writeValue("name", this.name);
/* 162 */     paramJson.writeValue("stage", this.stageName);
/* 163 */     if (this.stagePosition != 0) paramJson.writeValue("stagePosition", Integer.valueOf(this.stagePosition)); 
/* 164 */     paramJson.writeValue("seed", Integer.valueOf(this.seed));
/* 165 */     if (this.hasLeaderboards) paramJson.writeValue("hasLeaderboards", Boolean.TRUE); 
/* 166 */     if (this.notAffectsStatistics) paramJson.writeValue("notAffectsStatistics", Boolean.TRUE); 
/* 167 */     if (this.achievementsDisabled) paramJson.writeValue("achievementsDisabled", Boolean.TRUE); 
/* 168 */     if (this.dailyQuest) paramJson.writeValue("dailyQuest", Boolean.TRUE); 
/* 169 */     if (this.forcedDifficulty != null) paramJson.writeValue("forcedDifficulty", this.forcedDifficulty.name()); 
/* 170 */     if (this.fixedQuests) paramJson.writeValue("fixedQuests", Boolean.TRUE); 
/* 171 */     if (this.isBonus) paramJson.writeValue("isBonus", Boolean.TRUE); 
/* 172 */     if (this.customWaves) paramJson.writeValue("customWaves", Boolean.TRUE); 
/* 173 */     if (this.fastForwardFrame > 0) paramJson.writeValue("fastForwardFrame", Integer.valueOf(this.fastForwardFrame));
/*     */     
/* 175 */     if (this.openRequirements.size != 0) {
/* 176 */       paramJson.writeArrayStart("openRequirements");
/* 177 */       for (byte b1 = 0; b1 < this.openRequirements.size; b1++) {
/* 178 */         paramJson.writeObjectStart();
/* 179 */         ((Requirement[])this.openRequirements.items)[b1].toJson(paramJson);
/* 180 */         paramJson.writeObjectEnd();
/*     */       } 
/* 182 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 185 */     if (this.showRequirements.size != 0) {
/* 186 */       paramJson.writeArrayStart("showRequirements");
/* 187 */       for (byte b1 = 0; b1 < this.showRequirements.size; b1++) {
/* 188 */         paramJson.writeObjectStart();
/* 189 */         ((Requirement[])this.showRequirements.items)[b1].toJson(paramJson);
/* 190 */         paramJson.writeObjectEnd();
/*     */       } 
/* 192 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 195 */     boolean bool = false;
/* 196 */     if (this.priceInMoney > 0)
/* 197 */       bool = true;  int arrayOfInt[], i;
/*     */     byte b;
/* 199 */     for (i = (arrayOfInt = this.priceInResources).length, b = 0; b < i; b++) {
/* 200 */       int j; if ((j = arrayOfInt[b]) > 0) {
/* 201 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 205 */     if (bool) {
/* 206 */       paramJson.writeArrayStart("price");
/* 207 */       if (this.priceInMoney > 0) {
/* 208 */         paramJson.writeObjectStart();
/* 209 */         paramJson.writeValue("type", "MONEY");
/* 210 */         paramJson.writeValue("amount", Integer.valueOf(this.priceInMoney));
/* 211 */         paramJson.writeObjectEnd();
/*     */       } 
/* 213 */       for (byte b1 = 0; b1 < this.priceInResources.length; b1++) {
/* 214 */         if (this.priceInResources[b1] > 0) {
/* 215 */           paramJson.writeObjectStart();
/* 216 */           paramJson.writeValue("type", "RESOURCE");
/* 217 */           paramJson.writeValue("name", ResourceType.values[b1].name());
/* 218 */           paramJson.writeValue("amount", Integer.valueOf(this.priceInResources[b1]));
/* 219 */           paramJson.writeObjectEnd();
/*     */         } 
/*     */       } 
/* 222 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 225 */     if (this.quests.size != 0) {
/* 226 */       paramJson.writeArrayStart("quests");
/* 227 */       for (byte b1 = 0; b1 < this.quests.size; b1++) {
/* 228 */         paramJson.writeObjectStart();
/* 229 */         ((BasicLevelQuestConfig[])this.quests.items)[b1].toJson(paramJson);
/* 230 */         paramJson.writeObjectEnd();
/*     */       } 
/* 232 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 235 */     if (this.waveQuests.size != 0) {
/* 236 */       paramJson.writeArrayStart("waveQuests");
/* 237 */       for (byte b1 = 0; b1 < this.waveQuests.size; b1++) {
/* 238 */         paramJson.writeObjectStart();
/* 239 */         ((WaveQuest[])this.waveQuests.items)[b1].toJson(paramJson);
/* 240 */         paramJson.writeObjectEnd();
/*     */       } 
/* 242 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 245 */     paramJson.writeValue("difficultyExpectedPlaytime", Float.valueOf(this.difficultyExpectedPlaytime));
/*     */     
/* 247 */     if (this.enemyWaves != null && this.enemyWaves.length != 0) {
/* 248 */       paramJson.writeArrayStart("enemyWaves");
/* 249 */       for (byte b1 = 0; b1 < this.enemyWaves.length; b1++) {
/* 250 */         paramJson.writeObjectStart();
/* 251 */         this.enemyWaves[b1].toJson(paramJson);
/* 252 */         paramJson.writeObjectEnd();
/*     */       } 
/* 254 */       paramJson.writeArrayEnd();
/*     */     } 
/*     */     
/* 257 */     if (this.bonusStagesConfig != null) {
/* 258 */       paramJson.writeObjectStart("bonusStagesConfig");
/* 259 */       this.bonusStagesConfig.toJson(paramJson);
/* 260 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BasicLevel createNewFromFullJson(String paramString) {
/*     */     try {
/* 266 */       JsonValue jsonValue = (new JsonReader()).parse(paramString);
/* 267 */       if ("BASIC_LEVEL_FULL".equals(jsonValue.getString("_type"))) {
/*     */         JsonValue jsonValue1;
/* 269 */         BasicLevel basicLevel = fromJson(jsonValue1 = jsonValue.get("configuration"));
/*     */         
/* 271 */         jsonValue = jsonValue.get("map");
/* 272 */         basicLevel.setMap(Map.fromJson(jsonValue));
/*     */         
/* 274 */         return basicLevel;
/*     */       } 
/* 276 */       throw new IllegalArgumentException("Invalid json - must be of type BASIC_LEVEL_FULL");
/*     */     }
/* 278 */     catch (Exception exception) {
/* 279 */       a.e("failed to create level from json:", new Object[0]);
/* 280 */       a.e(paramString, new Object[0]);
/* 281 */       throw new IllegalArgumentException("Invalid json string", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BasicLevel fromJson(JsonValue paramJsonValue) {
/*     */     BasicLevel basicLevel;
/* 287 */     (basicLevel = new BasicLevel()).name = paramJsonValue.getString("name");
/* 288 */     basicLevel.stageName = paramJsonValue.getString("stage");
/* 289 */     basicLevel.stagePosition = paramJsonValue.getInt("stagePosition", 0);
/* 290 */     basicLevel.seed = paramJsonValue.getInt("seed");
/* 291 */     basicLevel.hasLeaderboards = paramJsonValue.getBoolean("hasLeaderboards", false);
/* 292 */     basicLevel.achievementsDisabled = paramJsonValue.getBoolean("achievementsDisabled", false);
/* 293 */     basicLevel.notAffectsStatistics = paramJsonValue.getBoolean("notAffectsStatistics", false);
/* 294 */     basicLevel.dailyQuest = paramJsonValue.getBoolean("dailyQuest", false);
/* 295 */     if (paramJsonValue.has("forcedDifficulty") && paramJsonValue.getString("forcedDifficulty").length() > 0) {
/* 296 */       basicLevel.forcedDifficulty = DifficultyMode.valueOf(paramJsonValue.getString("forcedDifficulty"));
/*     */     }
/* 298 */     basicLevel.fixedQuests = paramJsonValue.getBoolean("fixedQuests", false);
/* 299 */     basicLevel.isBonus = paramJsonValue.getBoolean("isBonus", false);
/* 300 */     basicLevel.customWaves = paramJsonValue.getBoolean("customWaves", false);
/* 301 */     basicLevel.fastForwardFrame = paramJsonValue.getInt("fastForwardFrame", 0);
/*     */     
/*     */     JsonValue jsonValue1;
/*     */     
/* 305 */     if ((jsonValue1 = paramJsonValue.get("openRequirements")) != null) {
/* 306 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 307 */         basicLevel.openRequirements.add(Requirement.fromJson(jsonValue)); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 313 */     if ((jsonValue1 = paramJsonValue.get("showRequirements")) != null) {
/* 314 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { jsonValue1 = jsonIterator.next();
/* 315 */         basicLevel.showRequirements.add(Requirement.fromJson(jsonValue1)); }
/*     */     
/*     */     }
/*     */     
/*     */     JsonValue jsonValue2;
/*     */     
/* 321 */     if ((jsonValue2 = paramJsonValue.get("price")) != null) {
/* 322 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) {
/*     */         String str;
/*     */         
/* 325 */         if ((str = (jsonValue2 = jsonIterator.next()).getString("type")).equals("MONEY")) {
/* 326 */           basicLevel.priceInMoney = jsonValue2.getInt("amount"); continue;
/* 327 */         }  if (str.equals("RESOURCE")) {
/* 328 */           ResourceType resourceType = ResourceType.valueOf(jsonValue2.getString("name"));
/* 329 */           basicLevel.priceInResources[resourceType.ordinal()] = jsonValue2.getInt("amount");
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 336 */     if ((jsonValue1 = paramJsonValue.get("quests")) != null) {
/* 337 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) {
/* 338 */         JsonValue jsonValue; BasicLevelQuestConfig basicLevelQuestConfig = BasicLevelQuestConfig.fromJson(jsonValue = jsonIterator.next(), basicLevel);
/* 339 */         basicLevel.quests.add(basicLevelQuestConfig);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 345 */     if ((jsonValue2 = paramJsonValue.get("waveQuests")) != null) {
/* 346 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 347 */         basicLevel.waveQuests.add(WaveQuest.fromJson(basicLevel, jsonValue)); }
/*     */     
/*     */     }
/*     */ 
/*     */     
/* 352 */     basicLevel.difficultyExpectedPlaytime = paramJsonValue.getFloat("difficultyExpectedPlaytime", 1.0F);
/*     */     
/*     */     JsonValue jsonValue3;
/*     */     
/* 356 */     if ((jsonValue3 = paramJsonValue.get("enemyWaves")) != null && jsonValue3.size != 0) {
/* 357 */       basicLevel.enemyWaves = new WaveTemplates.PredefinedWaveTemplate[jsonValue3.size];
/* 358 */       byte b = 0;
/* 359 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue3.iterator(); jsonIterator.hasNext(); ) { jsonValue2 = jsonIterator.next();
/* 360 */         basicLevel.enemyWaves[b] = WaveTemplates.PredefinedWaveTemplate.fromJson(jsonValue2);
/* 361 */         b++; }
/*     */     
/*     */     } 
/*     */     
/*     */     JsonValue jsonValue4;
/*     */     
/* 367 */     if ((jsonValue4 = paramJsonValue.get("bonusStagesConfig")) != null) {
/* 368 */       basicLevel.bonusStagesConfig = BonusStagesConfig.fromJson(jsonValue4);
/*     */     }
/*     */     
/* 371 */     return basicLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getStarMilestoneWaves() {
/* 378 */     int[] arrayOfInt = new int[3];
/* 379 */     byte b1 = 0; byte b2;
/* 380 */     label15: for (b2 = 0; b2 < this.waveQuests.size; b2++) {
/* 381 */       WaveQuest waveQuest = (WaveQuest)this.waveQuests.get(b2);
/* 382 */       for (byte b = 0; b < waveQuest.prizes.size; b++) {
/* 383 */         if (((ItemStack)waveQuest.prizes.get(b)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 384 */           arrayOfInt[b1] = waveQuest.waves;
/* 385 */           b1++;
/* 386 */           if (b1 != 3)
/*     */             continue;  break label15;
/*     */         }  continue;
/*     */       } 
/*     */     } 
/* 391 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public float getDifficultyExpectedPlaytime() {
/* 395 */     return this.difficultyExpectedPlaytime;
/*     */   }
/*     */   
/*     */   public synchronized Map reloadMap() {
/* 399 */     if (Game.i.screenManager != null && Game.i.screenManager.getCurrentScreen() instanceof com.prineside.tdi2.screens.GameScreen) a.i("reloadMap " + this.name, new Object[0]); 
/*     */     try {
/* 401 */       String str = "levels/maps/" + this.name + ".json";
/*     */       FileHandle fileHandle;
/* 403 */       if (!(fileHandle = Gdx.files.local(str)).exists()) {
/* 404 */         fileHandle = Gdx.files.internal(str);
/*     */       }
/*     */       
/*     */       JsonValue jsonValue;
/* 408 */       Map map = Map.fromJson(jsonValue = (new JsonReader()).parse(fileHandle));
/* 409 */       this.b = new SoftReference<>(map);
/*     */ 
/*     */       
/* 412 */       return map;
/* 413 */     } catch (Exception exception) {
/* 414 */       throw new RuntimeException("Failed to load map for level " + this.name, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map getMap() {
/* 419 */     Map map = null;
/* 420 */     if (this.b != null) {
/* 421 */       map = this.b.get();
/*     */     }
/* 423 */     if (map != null) return map;
/*     */     
/* 425 */     return reloadMap();
/*     */   }
/*     */   
/*     */   public void setMap(Map paramMap) {
/* 429 */     this.b = new SoftReference<>(paramMap);
/*     */   }
/*     */   
/*     */   public Array<EnemyType> getAllowedEnemies() {
/* 433 */     return getMap().getAllowedEnemies();
/*     */   }
/*     */   
/*     */   public TextureRegion getPreview() {
/* 437 */     return getMap().getPreview().getTextureRegion();
/*     */   }
/*     */   
/*     */   public BasicLevelQuestConfig getQuest(String paramString) {
/* 441 */     for (byte b = 0; b < this.quests.size; b++) {
/* 442 */       if (((BasicLevelQuestConfig)this.quests.get(b)).getId().equals(paramString)) {
/* 443 */         return (BasicLevelQuestConfig)this.quests.get(b);
/*     */       }
/*     */     } 
/* 446 */     throw new IllegalArgumentException("Quest " + paramString + " not found");
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 451 */     return "BasicLevel@" + Integer.toHexString(hashCode()) + " (name: " + this.name + ")";
/*     */   }
/*     */   
/*     */   public WaveQuest getWaveQuest(String paramString) {
/* 455 */     for (byte b = 0; b < this.waveQuests.size; b++) {
/* 456 */       if (((WaveQuest)this.waveQuests.get(b)).id.equals(paramString)) {
/* 457 */         return (WaveQuest)this.waveQuests.get(b);
/*     */       }
/*     */     } 
/* 460 */     throw new IllegalArgumentException("Quest " + paramString + " not found");
/*     */   }
/*     */   
/*     */   public static class WaveQuest
/*     */   {
/*     */     public BasicLevel basicLevel;
/*     */     public String id;
/*     */     public int waves;
/* 468 */     public Array<ItemStack> prizes = new Array(ItemStack.class);
/*     */     
/*     */     public WaveQuest(BasicLevel param1BasicLevel, String param1String, int param1Int) {
/* 471 */       this.basicLevel = param1BasicLevel;
/* 472 */       this.id = param1String;
/* 473 */       this.waves = param1Int;
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 477 */       param1Json.writeValue("id", this.id);
/* 478 */       param1Json.writeValue("waves", Integer.valueOf(this.waves));
/* 479 */       param1Json.writeArrayStart("prizes");
/* 480 */       for (byte b = 0; b < this.prizes.size; b++) {
/* 481 */         param1Json.writeObjectStart();
/* 482 */         ((ItemStack[])this.prizes.items)[b].toJson(param1Json);
/* 483 */         param1Json.writeObjectEnd();
/*     */       } 
/* 485 */       param1Json.writeArrayEnd();
/*     */     }
/*     */     
/*     */     public static WaveQuest fromJson(BasicLevel param1BasicLevel, JsonValue param1JsonValue) {
/* 489 */       String str = param1JsonValue.getString("id");
/* 490 */       int i = param1JsonValue.getInt("waves");
/* 491 */       WaveQuest waveQuest = new WaveQuest(param1BasicLevel, str, i);
/*     */ 
/*     */       
/* 494 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (param1JsonValue = param1JsonValue.get("prizes")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 495 */         waveQuest.prizes.add(ItemStack.fromJson(jsonValue)); }
/*     */ 
/*     */       
/* 498 */       return waveQuest;
/*     */     }
/*     */     
/*     */     public QuestSystem.BasicLevelWaveQuest createIngameQuest(GameSystemProvider param1GameSystemProvider) {
/* 502 */       return new QuestSystem.BasicLevelWaveQuest(this.basicLevel, this, param1GameSystemProvider);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isCompleted() {
/* 509 */       return Game.i.basicLevelManager.isQuestCompleted(this.id);
/*     */     }
/*     */     
/*     */     public void setCompleted(boolean param1Boolean) {
/* 513 */       Game.i.basicLevelManager.setQuestCompleted(this.id, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\BasicLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */