/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.BasicLevelLootBonusType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public final class PP_BasicLevel
/*     */   implements PrefSubcategory {
/*  24 */   private static final TLog a = TLog.forClass(PP_BasicLevel.class);
/*     */   
/*  26 */   private final ObjectSet<String> b = new ObjectSet();
/*  27 */   private final ObjectSet<String> c = new ObjectSet();
/*  28 */   private final ObjectMap<String, Long> d = new ObjectMap();
/*  29 */   private final ObjectMap<String, LevelStats> e = new ObjectMap();
/*  30 */   private final ObjectMap<String, LevelLootBonus> f = new ObjectMap();
/*     */   private int g;
/*     */   
/*     */   public final int getPlayTimeSinceLevelLootBonusUpdate() {
/*  34 */     return this.g;
/*     */   }
/*     */   
/*     */   public final synchronized void setPlayTimeSinceLevelLootBonusUpdate(int paramInt) {
/*  38 */     this.g = paramInt;
/*     */   }
/*     */   @Null
/*     */   public final LevelLootBonus getLevelLootBonus(String paramString) {
/*  42 */     return (LevelLootBonus)this.f.get(paramString, null);
/*     */   }
/*     */   
/*     */   public final synchronized void setLevelLootBonuses(ObjectMap<String, LevelLootBonus> paramObjectMap) {
/*  46 */     this.f.clear();
/*  47 */     this.f.putAll(paramObjectMap);
/*     */   }
/*     */   
/*     */   public final long getQuestSavedValue(String paramString) {
/*  51 */     return ((Long)this.d.get(paramString, Long.valueOf(0L))).longValue();
/*     */   }
/*     */   
/*     */   public final synchronized void setQuestSavedValue(String paramString, long paramLong) {
/*  55 */     this.d.put(paramString, Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public final synchronized void removeQuestSavedValue(String paramString) {
/*  59 */     this.d.remove(paramString);
/*     */   }
/*     */   
/*     */   public final boolean isQuestCompleted(String paramString) {
/*  63 */     return this.b.contains(paramString);
/*     */   }
/*     */   
/*     */   public final synchronized void setQuestCompleted(String paramString, boolean paramBoolean) {
/*  67 */     if (paramBoolean) {
/*  68 */       this.b.add(paramString); return;
/*     */     } 
/*  70 */     this.b.remove(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isQuestEverCompleted(String paramString) {
/*  75 */     return this.c.contains(paramString);
/*     */   }
/*     */   
/*     */   public final synchronized void setQuestEverCompleted(String paramString, boolean paramBoolean) {
/*  79 */     if (paramBoolean) {
/*  80 */       this.c.add(paramString); return;
/*     */     } 
/*  82 */     this.c.remove(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isLevelPurchased(String paramString) {
/*  87 */     return (a(paramString)).purchased;
/*     */   }
/*     */   
/*     */   public final boolean isLevelPurchasedOrPlayed(String paramString) {
/*     */     LevelStats levelStats;
/*  92 */     if ((levelStats = a(paramString)).purchased || levelStats.maxPlayingTime != 0) return true;  return false;
/*     */   }
/*     */   
/*     */   public final synchronized void setLevelPurchased(String paramString, boolean paramBoolean) {
/*  96 */     (a(paramString)).purchased = paramBoolean;
/*     */   }
/*     */   
/*     */   public final int getLevelStartsCount(String paramString) {
/* 100 */     return (a(paramString)).gameStartsCount;
/*     */   }
/*     */   
/*     */   public final int getLevelMaxReachedWave(String paramString) {
/* 104 */     return (a(paramString)).maxReachedWave;
/*     */   }
/*     */   
/*     */   public final synchronized void setLevelMaxReachedWave(String paramString, int paramInt) {
/* 108 */     (a(paramString)).maxReachedWave = paramInt;
/*     */   }
/*     */   
/*     */   public final int getLevelMaxPlayingTime(String paramString) {
/* 112 */     return (a(paramString)).maxPlayingTime;
/*     */   }
/*     */   
/*     */   public final synchronized void setLevelMaxPlayingTime(String paramString, int paramInt) {
/* 116 */     (a(paramString)).maxPlayingTime = paramInt;
/*     */   }
/*     */   
/*     */   public final long getLevelMaxScore(String paramString) {
/* 120 */     return (a(paramString)).maxScore;
/*     */   }
/*     */   
/*     */   public final synchronized void setLevelMaxScore(String paramString, long paramLong) {
/* 124 */     (a(paramString)).maxScore = paramLong;
/*     */   }
/*     */   
/*     */   public final synchronized void addLevelGameStartsCount(String paramString, int paramInt) {
/* 128 */     (a(paramString)).gameStartsCount += paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void load(PrefMap paramPrefMap) {
/* 133 */     this.b.clear();
/* 134 */     this.c.clear();
/* 135 */     this.d.clear();
/* 136 */     this.e.clear();
/* 137 */     this.f.clear();
/*     */     
/* 139 */     this.g = 0;
/*     */     String str1;
/* 141 */     if ((str1 = paramPrefMap.get("playTimeSinceLevelLootBonusUpdate", null)) != null) {
/*     */       try {
/* 143 */         this.g = Integer.parseInt(str1);
/* 144 */         if (this.g < 0) {
/* 145 */           this.g = 0;
/*     */         }
/* 147 */       } catch (Exception exception) {
/* 148 */         a.e("failed to parse playTimeSinceLevelLootBonusUpdate: " + str1, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/*     */     String str2;
/* 153 */     if ((str2 = paramPrefMap.get("basicLevelLootBonuses", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 156 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str2)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/* 158 */             this.f.put(jsonValue1.name, LevelLootBonus.fromJson(jsonValue1));
/* 159 */           } catch (Exception exception) {
/* 160 */             a.e("failed to parse LevelLootBonus: " + jsonValue1.asString(), new Object[] { exception });
/*     */           }  }
/*     */       
/* 163 */       } catch (Exception exception) {
/* 164 */         a.e("failed to parse json: " + str2, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 170 */     if ((str1 = paramPrefMap.get("basicLevelCompletedQuests", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 173 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 174 */           this.b.add(jsonValue1.asString()); }
/*     */       
/* 176 */       } catch (Exception exception) {
/* 177 */         a.e("failed to parse json: " + str1, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/*     */     String str3;
/* 182 */     if ((str3 = paramPrefMap.get("basicLevelEverCompletedQuests", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 185 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str3)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 186 */           this.c.add(jsonValue1.asString()); }
/*     */       
/* 188 */       } catch (Exception exception) {
/* 189 */         a.e("failed to parse json: " + str3, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 193 */     for (ObjectSet.ObjectSetIterator<String> objectSetIterator = this.b.iterator(); objectSetIterator.hasNext(); ) { String str = objectSetIterator.next();
/* 194 */       if (!this.c.contains(str)) {
/* 195 */         this.c.add(str);
/*     */       } }
/*     */ 
/*     */     
/*     */     String str4;
/*     */     
/* 201 */     if ((str4 = paramPrefMap.get("basicLevels", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 204 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str4)).iterator(); jsonIterator.hasNext(); ) {
/* 205 */           JsonValue jsonValue1; str3 = (jsonValue1 = jsonIterator.next()).getString("n");
/*     */           
/*     */           LevelStats levelStats;
/* 208 */           (levelStats = a(str3)).maxScore = jsonValue1.getLong("ms", 0L);
/* 209 */           levelStats.maxReachedWave = jsonValue1.getInt("mrw", 0);
/* 210 */           levelStats.maxPlayingTime = jsonValue1.getInt("mpt", 0);
/* 211 */           levelStats.purchased = jsonValue1.getBoolean("p", false);
/* 212 */           levelStats.gameStartsCount = jsonValue1.getInt("gsc", 0);
/*     */ 
/*     */ 
/*     */           
/* 216 */           if ((jsonValue1 = jsonValue1.get("sv")) != null) {
/* 217 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue2 = jsonIterator1.next();
/*     */               try {
/* 219 */                 this.d.put(jsonValue2.name, Long.valueOf(jsonValue2.asLong()));
/* 220 */               } catch (Exception exception) {
/* 221 */                 a.e("failed to load quest '" + jsonValue2.name + "' savedValue", new Object[] { exception });
/*     */               }  }
/*     */           
/*     */           }
/*     */         } 
/* 226 */       } catch (Exception exception) {
/* 227 */         a.e("failed to parse json: " + str4, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/*     */     String str5;
/*     */     
/* 233 */     if ((str5 = paramPrefMap.get("basicLevelsQuestSavedValues", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 236 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str5)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 237 */           this.d.put(jsonValue1.name, Long.valueOf(jsonValue1.asLong())); }
/*     */          return;
/* 239 */       } catch (Exception exception) {
/* 240 */         a.e("failed to parse json: " + str5, new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 247 */     if (Config.isHeadless())
/*     */       return; 
/* 249 */     paramPrefMap.set("playTimeSinceLevelLootBonusUpdate", Integer.toString(this.g));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     if (this.f.size != 0) {
/* 255 */       Json json1 = new Json(JsonWriter.OutputType.minimal);
/* 256 */       StringWriter stringWriter1 = new StringWriter();
/* 257 */       json1.setWriter(stringWriter1);
/* 258 */       json1.writeObjectStart();
/* 259 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = this.f.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 260 */         json1.writeObjectStart((String)entry.key);
/* 261 */         ((LevelLootBonus)entry.value).toJson(json1);
/* 262 */         json1.writeObjectEnd(); }
/*     */       
/* 264 */       json1.writeObjectEnd();
/* 265 */       paramPrefMap.set("basicLevelLootBonuses", stringWriter1.toString());
/*     */     } 
/*     */     
/* 268 */     if (this.b.size != 0) {
/*     */       
/* 270 */       Json json1 = new Json(JsonWriter.OutputType.minimal);
/* 271 */       StringWriter stringWriter1 = new StringWriter();
/* 272 */       json1.setWriter(stringWriter1);
/* 273 */       json1.writeArrayStart();
/* 274 */       for (ObjectSet.ObjectSetIterator<String> objectSetIterator = this.b.iterator(); objectSetIterator.hasNext(); ) { String str = objectSetIterator.next();
/* 275 */         json1.writeValue(str); }
/*     */       
/* 277 */       json1.writeArrayEnd();
/* 278 */       paramPrefMap.set("basicLevelCompletedQuests", stringWriter1.toString());
/*     */     } 
/*     */     
/* 281 */     if (this.c.size != 0) {
/* 282 */       Json json1 = new Json(JsonWriter.OutputType.minimal);
/* 283 */       StringWriter stringWriter1 = new StringWriter();
/* 284 */       json1.setWriter(stringWriter1);
/* 285 */       json1.writeArrayStart();
/* 286 */       for (ObjectSet.ObjectSetIterator<String> objectSetIterator = this.c.iterator(); objectSetIterator.hasNext(); ) { String str = objectSetIterator.next();
/* 287 */         json1.writeValue(str); }
/*     */       
/* 289 */       json1.writeArrayEnd();
/* 290 */       paramPrefMap.set("basicLevelEverCompletedQuests", stringWriter1.toString());
/*     */     } 
/*     */ 
/*     */     
/* 294 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 295 */     StringWriter stringWriter = new StringWriter();
/* 296 */     json.setWriter(stringWriter);
/* 297 */     json.writeArrayStart();
/*     */     Array array1;
/* 299 */     (array1 = this.e.keys().toArray()).sort();
/*     */     
/* 301 */     for (byte b1 = 0; b1 < array1.size; b1++) {
/* 302 */       String str = (String)array1.get(b1);
/*     */       LevelStats levelStats;
/* 304 */       if ((levelStats = (LevelStats)this.e.get(str)) != null && !levelStats.isEmpty()) {
/* 305 */         json.writeObjectStart();
/* 306 */         json.writeValue("n", str);
/* 307 */         json.writeValue("p", Boolean.valueOf(levelStats.purchased));
/* 308 */         json.writeValue("gsc", Integer.valueOf(levelStats.gameStartsCount));
/* 309 */         json.writeValue("mrw", Integer.valueOf(levelStats.maxReachedWave));
/* 310 */         json.writeValue("mpt", Integer.valueOf(levelStats.maxPlayingTime));
/* 311 */         json.writeValue("ms", Long.valueOf(levelStats.maxScore));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 322 */         json.writeObjectEnd();
/*     */       } 
/*     */     } 
/* 325 */     json.writeArrayEnd();
/* 326 */     paramPrefMap.set("basicLevels", stringWriter.toString());
/*     */ 
/*     */     
/* 329 */     json = new Json(JsonWriter.OutputType.minimal);
/* 330 */     stringWriter = new StringWriter();
/* 331 */     json.setWriter(stringWriter);
/* 332 */     json.writeObjectStart();
/*     */     Array array2;
/* 334 */     (array2 = this.d.keys().toArray()).sort();
/* 335 */     for (byte b2 = 0; b2 < array2.size; b2++) {
/* 336 */       String str = (String)array2.get(b2);
/*     */       Long long_;
/* 338 */       if ((long_ = (Long)this.d.get(str, null)) != null && long_.longValue() != 0L) {
/* 339 */         json.writeValue(str, long_);
/*     */       }
/*     */     } 
/* 342 */     json.writeObjectEnd();
/* 343 */     paramPrefMap.set("basicLevelsQuestSavedValues", stringWriter.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LevelStats a(String paramString) {
/*     */     LevelStats levelStats;
/* 351 */     if ((levelStats = (LevelStats)this.e.get(paramString, null)) == null) {
/* 352 */       levelStats = new LevelStats((byte)0);
/* 353 */       this.e.put(paramString, levelStats);
/*     */     } 
/* 355 */     return levelStats;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class LevelStats
/*     */   {
/*     */     public boolean purchased;
/*     */     public int gameStartsCount;
/*     */     public int maxReachedWave;
/*     */     
/*     */     public final boolean isEmpty() {
/* 366 */       return (!this.purchased && this.gameStartsCount == 0 && this.maxReachedWave == 0 && this.maxPlayingTime == 0 && this.maxScore == 0L);
/*     */     }
/*     */     public int maxPlayingTime; public long maxScore;
/*     */     private LevelStats() {} }
/*     */   
/*     */   public static class LevelLootBonus { public BasicLevelLootBonusType type;
/*     */     public float multiplier;
/*     */     
/*     */     public LevelLootBonus() {}
/*     */     
/*     */     public LevelLootBonus(BasicLevelLootBonusType param1BasicLevelLootBonusType, float param1Float) {
/* 377 */       this.type = param1BasicLevelLootBonusType;
/* 378 */       this.multiplier = param1Float;
/*     */     }
/*     */     
/*     */     public Drawable getIconDrawable() {
/* 382 */       switch (PP_BasicLevel.null.a[this.type.ordinal()]) {
/*     */         case 1:
/* 384 */           return (Drawable)Game.i.assetManager.getDrawable("dust-item");
/*     */         
/*     */         case 2:
/* 387 */           return Game.i.assetManager.getDrawable("resource-scalar").tint(Game.i.resourceManager.getColor(ResourceType.SCALAR));
/*     */         
/*     */         case 3:
/* 390 */           return Game.i.assetManager.getDrawable("resource-vector").tint(Game.i.resourceManager.getColor(ResourceType.VECTOR));
/*     */         
/*     */         case 4:
/* 393 */           return Game.i.assetManager.getDrawable("resource-matrix").tint(Game.i.resourceManager.getColor(ResourceType.MATRIX));
/*     */         
/*     */         case 5:
/* 396 */           return Game.i.assetManager.getDrawable("resource-tensor").tint(Game.i.resourceManager.getColor(ResourceType.TENSOR));
/*     */         
/*     */         case 6:
/* 399 */           return Game.i.assetManager.getDrawable("resource-infiar").tint(Game.i.resourceManager.getColor(ResourceType.INFIAR));
/*     */         
/*     */         case 7:
/* 402 */           return Game.i.assetManager.getDrawable("icon-money").tint(MaterialColor.GREEN.P500);
/*     */       } 
/*     */       
/* 405 */       return (Drawable)Game.i.assetManager.getDrawable("icon-question");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static LevelLootBonus fromJson(JsonValue param1JsonValue) {
/*     */       LevelLootBonus levelLootBonus;
/* 412 */       (levelLootBonus = new LevelLootBonus()).type = BasicLevelLootBonusType.valueOf(param1JsonValue.getString("type"));
/* 413 */       levelLootBonus.multiplier = param1JsonValue.getFloat("multiplier", 2.0F);
/*     */       
/* 415 */       return levelLootBonus;
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 419 */       param1Json.writeValue("type", this.type.name());
/* 420 */       param1Json.writeValue("multiplier", Float.valueOf(this.multiplier));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 425 */       return LevelLootBonus.class.getSimpleName() + " (type: " + this.type.name() + ", multiplier: " + this.multiplier + ")";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_BasicLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */