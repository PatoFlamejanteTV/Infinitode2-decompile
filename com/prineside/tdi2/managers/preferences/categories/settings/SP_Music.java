/*     */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.prineside.tdi2.managers.MusicManager;
/*     */ import com.prineside.tdi2.managers.music.CachedMusicManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public class SP_Music
/*     */   implements PrefSubcategory
/*     */ {
/*     */   public SP_Music() {
/*  20 */     this.thumbsUpMusicHashes = new IntArray();
/*  21 */     this.menuThemeSources = new Array(false, 1, MusicManager.MusicSource.class);
/*     */     
/*  23 */     this.menuThemeSources.add(MusicManager.MusicSource.DEFAULT);
/*     */     
/*  25 */     this.cacheStatuses = new Array(false, 1, CachedMusicManager.CacheStatus.class);
/*     */   }
/*     */   private static final TLog a = TLog.forClass(SP_Music.class); public IntArray thumbsUpMusicHashes;
/*     */   public void load(PrefMap paramPrefMap) {
/*  29 */     this.thumbsUpMusicHashes.clear();
/*     */     
/*     */     try {
/*     */       String str1;
/*  33 */       if ((str1 = paramPrefMap.get("thumbsUpMusicHashes", null)) != null) {
/*     */         JsonValue jsonValue;
/*  35 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  36 */           this.thumbsUpMusicHashes.add(jsonValue1.asInt()); }
/*     */       
/*     */       } 
/*  39 */     } catch (Exception exception) {
/*  40 */       a.e("failed to load thumbsUpMusicHashes", new Object[] { exception });
/*     */     } 
/*     */     
/*  43 */     this.menuThemeSources.clear();
/*     */     String str;
/*  45 */     if ((str = paramPrefMap.get("menuThemeSources", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  48 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) {
/*  49 */           JsonValue jsonValue1; MusicManager.MusicSource musicSource = MusicManager.MusicSource.fromJson(jsonValue1 = jsonIterator.next());
/*  50 */           this.menuThemeSources.add(musicSource);
/*     */         } 
/*  52 */       } catch (Exception exception) {
/*  53 */         a.e("failed to load menuThemeSources from preferences", new Object[] { exception });
/*     */       } 
/*     */     }
/*  56 */     if (this.menuThemeSources.size == 0) {
/*  57 */       this.menuThemeSources.add(MusicManager.MusicSource.DEFAULT);
/*     */     }
/*     */     
/*  60 */     this.cacheStatuses.clear();
/*     */     
/*  62 */     if ((str = paramPrefMap.get("cachedMusicStatus", null)) != null) {
/*     */       JsonValue jsonValue;
/*     */       
/*  65 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */         try {
/*  67 */           CachedMusicManager.CacheStatus cacheStatus = CachedMusicManager.CacheStatus.fromJson(jsonValue1);
/*  68 */           this.cacheStatuses.add(cacheStatus);
/*  69 */         } catch (Exception exception) {} }
/*     */     
/*     */     } 
/*     */   }
/*     */   public Array<MusicManager.MusicSource> menuThemeSources; public Array<CachedMusicManager.CacheStatus> cacheStatuses;
/*     */   
/*     */   public synchronized void save(PrefMap paramPrefMap) {
/*  76 */     if (this.thumbsUpMusicHashes.size != 0) {
/*  77 */       Json json1 = new Json(JsonWriter.OutputType.json);
/*  78 */       StringWriter stringWriter1 = new StringWriter();
/*  79 */       json1.setWriter(stringWriter1);
/*     */       
/*  81 */       json1.writeArrayStart();
/*  82 */       for (byte b1 = 0; b1 < this.thumbsUpMusicHashes.size; b1++) {
/*  83 */         json1.writeValue(Integer.valueOf(this.thumbsUpMusicHashes.items[b1]));
/*     */       }
/*  85 */       json1.writeArrayEnd();
/*  86 */       paramPrefMap.set("thumbsUpMusicHashes", stringWriter1.toString());
/*     */     } 
/*     */     
/*  89 */     Json json = new Json(JsonWriter.OutputType.json);
/*  90 */     StringWriter stringWriter = new StringWriter();
/*  91 */     json.setWriter(stringWriter);
/*  92 */     json.writeArrayStart(); byte b;
/*  93 */     for (b = 0; b < this.menuThemeSources.size; b++) {
/*  94 */       MusicManager.MusicSource musicSource = ((MusicManager.MusicSource[])this.menuThemeSources.items)[b];
/*  95 */       json.writeObjectStart();
/*  96 */       musicSource.toJson(json);
/*  97 */       json.writeObjectEnd();
/*     */     } 
/*  99 */     json.writeArrayEnd();
/* 100 */     paramPrefMap.set("menuThemeSources", stringWriter.toString());
/*     */     
/* 102 */     if (this.cacheStatuses.size != 0) {
/* 103 */       json = new Json(JsonWriter.OutputType.minimal);
/* 104 */       stringWriter = new StringWriter();
/* 105 */       json.setWriter(stringWriter);
/* 106 */       json.writeArrayStart();
/*     */       
/* 108 */       for (b = 0; b < this.cacheStatuses.size; b++) {
/* 109 */         json.writeObjectStart();
/* 110 */         ((CachedMusicManager.CacheStatus[])this.cacheStatuses.items)[b].toJson(json);
/* 111 */         json.writeObjectEnd();
/*     */       } 
/* 113 */       json.writeArrayEnd();
/*     */       
/* 115 */       paramPrefMap.set("cachedMusicStatus", stringWriter.toString());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Music.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */