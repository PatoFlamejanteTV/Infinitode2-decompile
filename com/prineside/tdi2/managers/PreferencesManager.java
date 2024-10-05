/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.global.PostRender;
/*     */ import com.prineside.tdi2.managers.preferences.LegacyPreferences;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.RegularPrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = PreferencesManager.Serializer.class)
/*     */ public class PreferencesManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*     */   public static final String PROGRESS_PREFS_FILE_PATH_DEV = "cache/saves_dev/progress.txt";
/*  70 */   private static final TLog a = TLog.forClass(PreferencesManager.class);
/*     */   public static final String SETTINGS_PREFS_FILE_PATH_DEV = "cache/saves_dev/settings.txt";
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<PreferencesManager> { public PreferencesManager read() {
/*  74 */       return Game.i.preferencesManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b = false;
/*     */   
/*  82 */   private final DelayedRemovalArray<PreferencesManagerListener> c = new DelayedRemovalArray(false, 1);
/*     */   
/*     */   private boolean d;
/*     */   
/*     */   private final LegacyPreferences e;
/*  87 */   private ProgressPrefs f = new ProgressPrefs();
/*  88 */   private SettingsPrefs g = new SettingsPrefs();
/*     */ 
/*     */   
/*  91 */   private final RegularPrefMap h = new RegularPrefMap((byte)1);
/*  92 */   private final RegularPrefMap i = new RegularPrefMap((byte)2);
/*     */   
/*  94 */   private volatile RegularPrefMap j = new RegularPrefMap((byte)1);
/*  95 */   private volatile RegularPrefMap k = new RegularPrefMap((byte)2);
/*  96 */   private int l = 0;
/*     */   @Null
/*     */   private Long m;
/*     */   
/*     */   public PreferencesManager() {
/* 101 */     this.e = new LegacyPreferences();
/*     */   }
/*     */   
/*     */   public static String getSettingsPrefsFilePath() {
/* 105 */     if (Config.isModdingMode()) {
/* 106 */       return "saves_mod/settings.sav";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 111 */     return "saves/settings.sav";
/*     */   }
/*     */   
/*     */   public static String getProgressPrefsFilePath() {
/* 115 */     if (Config.isModdingMode()) {
/* 116 */       return "saves_mod/progress.sav";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 121 */     return "saves/progress.sav";
/*     */   }
/*     */   
/*     */   public static String getSavesDirPath() {
/* 125 */     if (Config.isModdingMode()) {
/* 126 */       return "saves_mod/";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 131 */     return "saves/";
/*     */   }
/*     */   
/*     */   public static String getSavedGameFilePath() {
/* 135 */     return getSavesDirPath() + "saved-game.bin";
/*     */   }
/*     */   
/*     */   public static String getIssuedItemsFilePath() {
/* 139 */     return getSavesDirPath() + "issued-items-log.json";
/*     */   }
/*     */   
/*     */   public static String getReplaysDirPath() {
/* 143 */     return getSavesDirPath() + "replays/";
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/* 148 */     this.d = true;
/*     */ 
/*     */     
/* 151 */     FileHandle fileHandle1 = Gdx.files.local(getSettingsPrefsFilePath());
/* 152 */     FileHandle fileHandle2 = Gdx.files.local(getProgressPrefsFilePath());
/* 153 */     if (fileHandle1.exists() || fileHandle2.exists()) {
/*     */ 
/*     */       
/* 156 */       if (fileHandle1.exists()) {
/* 157 */         byte[] arrayOfByte = fileHandle1.readBytes();
/*     */         try {
/* 159 */           this.i.fromBytes(arrayOfByte, 0, arrayOfByte.length);
/* 160 */           this.g.load((PrefMap)this.i);
/* 161 */           this.i.clear();
/* 162 */         } catch (Exception exception) {
/* 163 */           a.e("Failed to load settings preferences from file, skipping it", new Object[] { exception });
/*     */         } 
/*     */       } 
/* 166 */       if (fileHandle2.exists()) {
/* 167 */         byte[] arrayOfByte = fileHandle2.readBytes();
/*     */         try {
/* 169 */           this.h.fromBytes(arrayOfByte, 0, arrayOfByte.length);
/* 170 */           this.f.load((PrefMap)this.h);
/* 171 */           this.h.clear();
/* 172 */         } catch (Exception exception) {
/* 173 */           a.e("Failed to load progress preferences from file, skipping it", new Object[] { exception });
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       Array<ObjectPair<String, HashMap<String, String>>> array;
/*     */       
/* 179 */       if ((array = this.e.getLocallyStoredPrefs()) != null) {
/*     */         
/* 181 */         boolean bool = false;
/* 182 */         for (byte b = 0; b < array.size; str++) {
/*     */           String str; ObjectPair objectPair;
/* 184 */           if (((String)(objectPair = (ObjectPair)array.get(b)).first).equals("Progress")) {
/* 185 */             str = (String)((HashMap)objectPair.second).get("_migrated_1_9_0");
/* 186 */             if ("true".equals(str)) {
/* 187 */               bool = true;
/*     */             }
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 193 */         if (bool) {
/* 194 */           a.i("found a migration tag in the legacy preferences, skipping migration", new Object[0]);
/*     */         } else {
/*     */           try {
/* 197 */             a.i("found " + array.size + " legacy preference categories in local storage, migrating them...", new Object[0]);
/* 198 */             fromLegacy(array, true);
/* 199 */             a.i("successfully migrated legacy local preferences, adding a migration tag", new Object[0]);
/*     */             
/*     */             LegacyPreferences.SafePreferences safePreferences;
/*     */             
/* 203 */             (safePreferences = this.e.getPropertiesInstance(Config.LEGACY_PREFERENCES_NAME_PROGRESS)).set("_migrated_1_9_0", "true");
/* 204 */             safePreferences.flush();
/*     */           
/*     */           }
/* 207 */           catch (Exception exception) {
/* 208 */             a.e("failed to migrate legacy preferences", new Object[] { exception });
/*     */           } 
/*     */         } 
/*     */       } else {
/* 212 */         a.i("no preferences found and no legacy preferences to migrate - clean run", new Object[0]);
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     Game.i.screenManager.addListener(new ScreenManager.ScreenManagerListener(this)
/*     */         {
/*     */           public void screenChanged() {
/* 219 */             this.a.saveNowIfRequired();
/*     */           }
/*     */         });
/*     */     
/* 223 */     Gdx.app.addLifecycleListener(new LifecycleListener(this)
/*     */         {
/*     */           public void pause() {
/* 226 */             PreferencesManager.a().i("pause", new Object[0]);
/* 227 */             this.a.saveNowIfRequired();
/*     */           }
/*     */ 
/*     */           
/*     */           public void resume() {
/* 232 */             PreferencesManager.a().i("resume", new Object[0]);
/*     */           }
/*     */ 
/*     */           
/*     */           public void dispose() {
/* 237 */             PreferencesManager.a().i("dispose", new Object[0]);
/* 238 */             this.a.saveNowIfRequired();
/*     */           }
/*     */         });
/*     */     
/* 242 */     Game.EVENTS.getListeners(PostRender.class).addWithPriority(new Listener<PostRender>(this)
/*     */         {
/*     */           public void handleEvent(PostRender param1PostRender) {
/* 245 */             if (PreferencesManager.a(this.a).isSaveRequired() || PreferencesManager.b(this.a).isSaveRequired()) {
/*     */               
/* 247 */               long l = 2000L;
/* 248 */               if (Game.i.screenManager.getCurrentScreen() instanceof com.prineside.tdi2.screens.GameScreen) {
/* 249 */                 l = 30000L;
/*     */               }
/*     */               
/* 252 */               if (PreferencesManager.c(this.a) == null)
/*     */               
/* 254 */               { PreferencesManager.a(this.a, Long.valueOf(Game.getTimestampMillis())); }
/* 255 */               else { if (Game.getTimestampMillis() - PreferencesManager.c(this.a).longValue() > l) {
/*     */                   
/* 257 */                   PreferencesManager.a().i("triggering regular save (by timer)", new Object[] { Long.valueOf(Game.getTimestampMillis() - PreferencesManager.c(this.a).longValue()), Long.valueOf(l) });
/* 258 */                   PreferencesManager.a(this.a, (Long)null);
/* 259 */                   long l1 = Game.getRealTickCount();
/* 260 */                   this.a.saveNowIfRequired();
/* 261 */                   PreferencesManager.a().i("--- saved in: " + StringFormatter.compactNumberWithPrecision(((float)(Game.getRealTickCount() - l1) / 1000.0F), 1) + "ms", new Object[0]);
/*     */                 }  return; }
/*     */             
/*     */             } else {
/* 265 */               PreferencesManager.a(this.a, (Long)null);
/*     */             } 
/*     */           }
/* 268 */         }-3000).setName("PreferencesManager - handles auto save").setDescription("Must be called last to make sure nothing will mutate preferences and cause a lock");
/*     */   }
/*     */   
/*     */   public LegacyPreferences getLegacyPreferences() {
/* 272 */     return this.e;
/*     */   }
/*     */   @Null
/*     */   public RegularPrefMap getPrefMapForProgressSaveFile() {
/* 276 */     RegularPrefMap regularPrefMap = new RegularPrefMap((byte)1);
/*     */     FileHandle fileHandle;
/* 278 */     if ((fileHandle = Gdx.files.local(getProgressPrefsFilePath())).exists()) {
/* 279 */       byte[] arrayOfByte = fileHandle.readBytes();
/*     */       try {
/* 281 */         regularPrefMap.fromBytes(arrayOfByte, 0, arrayOfByte.length);
/* 282 */         return regularPrefMap;
/* 283 */       } catch (Exception exception) {
/* 284 */         a.e("getPrefMapForProgressSaveFile: failed to load progress preferences from file", new Object[] { exception });
/* 285 */         return null;
/*     */       } 
/*     */     } 
/* 288 */     a.i("getPrefMapForProgressSaveFile - save file " + getProgressPrefsFilePath() + " not exists", new Object[0]);
/* 289 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public RegularPrefMap getPrefMapForSettingsSaveFile() {
/* 295 */     a.e("getPrefMapForSettingsSaveFile disabled", new Object[0]);
/* 296 */     return null;
/*     */   }
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
/*     */   
/*     */   public ProgressPrefs getProgressPrefs() {
/* 320 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SettingsPrefs getSettingsPrefs() {
/* 328 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromLegacy(Array<ObjectPair<String, HashMap<String, String>>> paramArray, boolean paramBoolean) {
/* 336 */     a.i("fromLegacy called", new Object[0]);
/*     */     
/* 338 */     RegularPrefMap regularPrefMap1 = new RegularPrefMap((byte)1);
/* 339 */     RegularPrefMap regularPrefMap2 = paramBoolean ? new RegularPrefMap((byte)2) : null;
/*     */     
/* 341 */     HashMap hashMap1 = null;
/* 342 */     HashMap hashMap2 = null;
/* 343 */     HashMap hashMap3 = null;
/* 344 */     HashMap hashMap4 = null;
/*     */     
/* 346 */     byte b1 = 0;
/* 347 */     byte b2 = 0;
/*     */     
/* 349 */     for (byte b3 = 0; b3 < paramArray.size; b3++) {
/* 350 */       ObjectPair objectPair = (ObjectPair)paramArray.get(b3);
/* 351 */       if ("Progress".equals(objectPair.first)) {
/* 352 */         hashMap1 = (HashMap)objectPair.second;
/* 353 */         for (Map.Entry entry : ((HashMap)objectPair.second).entrySet()) {
/* 354 */           regularPrefMap1.set((String)entry.getKey(), (String)entry.getValue());
/* 355 */           b1++;
/*     */         } 
/* 357 */       } else if ("Settings".equals(objectPair.first)) {
/* 358 */         hashMap2 = (HashMap)objectPair.second;
/* 359 */         if (paramBoolean) {
/* 360 */           for (Map.Entry entry : ((HashMap)objectPair.second).entrySet()) {
/* 361 */             regularPrefMap2.set((String)entry.getKey(), (String)entry.getValue());
/* 362 */             b2++;
/*     */           } 
/*     */         } else {
/* 365 */           a.i("ignoring legacy settings", new Object[0]);
/*     */         } 
/* 367 */       } else if ("Statistics".equals(objectPair.first)) {
/* 368 */         hashMap3 = (HashMap)objectPair.second;
/* 369 */       } else if ("UserMaps".equals(objectPair.first)) {
/* 370 */         hashMap4 = (HashMap)objectPair.second;
/*     */       } else {
/* 372 */         a.e("skipping unknown legacy properties " + (String)objectPair.first, new Object[0]);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 377 */     if (hashMap2 != null) {
/* 378 */       regularPrefMap1.set("gameStartGameVersion", (String)hashMap2.get("gameStartGameVersion"));
/* 379 */       regularPrefMap1.set("gameStartTimestamp", (String)hashMap2.get("gameStartTimestamp"));
/* 380 */       regularPrefMap1.set("gameStartHash", (String)hashMap2.get("gameStartHash"));
/*     */     } else {
/* 382 */       a.i("no legacy settings - skipped migration of individual fields", new Object[0]);
/*     */     } 
/* 384 */     if (hashMap3 != null) {
/* 385 */       regularPrefMap1.set("statsAllTime", (String)hashMap3.get("allTime"));
/* 386 */       regularPrefMap1.set("statsMaxOneGame", (String)hashMap3.get("maxOneGame"));
/*     */       String str;
/* 388 */       if ((str = (String)hashMap3.get("issuedPrizes")) != null) {
/* 389 */         Gdx.files.local(getIssuedItemsFilePath()).writeString(str, false, "UTF-8");
/*     */       }
/*     */     } else {
/* 392 */       a.i("no legacy statistics - skipped migration of individual fields", new Object[0]);
/*     */     } 
/* 394 */     if (hashMap4 != null) {
/* 395 */       regularPrefMap1.set("userMaps", (String)hashMap4.get("slots"));
/*     */     } else {
/* 397 */       a.i("no legacy statistics - skipped migration of individual fields", new Object[0]);
/*     */     } 
/* 399 */     if (regularPrefMap2 != null && hashMap1 != null) {
/* 400 */       regularPrefMap2.set("sentGameReplaysToServer", (String)hashMap1.get("sentGameReplaysToServer"));
/*     */     }
/*     */     
/* 403 */     this.f.load((PrefMap)regularPrefMap1);
/* 404 */     this.f.requireSave();
/* 405 */     if (paramBoolean) {
/* 406 */       this.g.load((PrefMap)regularPrefMap2);
/* 407 */       this.g.requireSave();
/*     */     } 
/* 409 */     a.i("fromLegacy finished:", new Object[0]);
/* 410 */     a.i("- " + b1 + " progress properties migrated", new Object[0]);
/* 411 */     a.i("- " + b2 + " settings properties migrated", new Object[0]);
/* 412 */     a.i("- " + paramArray.size + " legacy property categories", new Object[0]);
/* 413 */     saveNowIfRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveNowIfRequired() {
/* 420 */     if (!this.d) {
/* 421 */       a.i("skipped save - manager not set up yet", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 426 */     if (this.f.isSaveRequired()) {
/* 427 */       long l = Game.getRealTickCount();
/* 428 */       RegularPrefMap regularPrefMap = this.j;
/* 429 */       this.j = null;
/* 430 */       if (regularPrefMap != null) {
/* 431 */         regularPrefMap.clear();
/* 432 */         this.f.saveAsync((PrefMap)regularPrefMap, () -> Threads.i().runAsync(()), paramException -> Threads.i().runOnMainThread(()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 450 */         this.f.setSaveRequired(false);
/* 451 */         a.i("real lag progress: " + StringFormatter.compactNumberWithPrecision(((float)(Game.getRealTickCount() - l) / 1000.0F), 2) + "ms", new Object[0]);
/*     */       } else {
/* 453 */         a.i("skipped progress save - already saving", new Object[0]);
/*     */       } 
/*     */     } 
/* 456 */     if (this.g.isSaveRequired()) {
/* 457 */       long l = Game.getRealTickCount();
/* 458 */       RegularPrefMap regularPrefMap = this.k;
/* 459 */       this.k = null;
/* 460 */       if (regularPrefMap != null) {
/* 461 */         regularPrefMap.clear();
/* 462 */         this.g.saveAsync((PrefMap)regularPrefMap, () -> Threads.i().runAsync(()), paramException -> Threads.i().runOnMainThread(()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 479 */         this.g.setSaveRequired(false);
/* 480 */         a.i("real lag settings: " + StringFormatter.compactNumberWithPrecision(((float)(Game.getRealTickCount() - l) / 1000.0F), 2) + "ms", new Object[0]); return;
/*     */       } 
/* 482 */       a.i("skipped settings save - already saving", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadFromUrl(String paramString, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 495 */     a.i("loading preferences from " + paramString, new Object[0]);
/*     */     try {
/*     */       Net.HttpRequest httpRequest;
/* 498 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(paramString);
/*     */       
/* 500 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer) {
/*     */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 502 */               String str = param1HttpResponse.getResultAsString();
/* 503 */               PreferencesManager.a().i(str, new Object[0]);
/* 504 */               Threads.i().runOnMainThread(() -> {
/*     */                     try {
/*     */                       JsonValue jsonValue;
/*     */                       
/*     */                       int i;
/*     */                       
/*     */                       if ((i = (jsonValue = (new JsonReader()).parse(param1String)).getInt("build")) > 207) {
/*     */                         PreferencesManager.a().e("backup is build " + i, new Object[0]);
/*     */                         Notifications.i().add(Game.i.localeManager.i18n.get("cant_load_from_cloud_need_update"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*     */                         if (param1ObjectConsumer != null) {
/*     */                           param1ObjectConsumer.accept(Boolean.FALSE);
/*     */                         }
/*     */                         return;
/*     */                       } 
/*     */                       String str = jsonValue.getString("progress");
/*     */                       this.b.fromBase64(str);
/*     */                       if (param1ObjectConsumer != null) {
/*     */                         param1ObjectConsumer.accept(Boolean.TRUE);
/*     */                       }
/*     */                       return;
/* 524 */                     } catch (Exception exception) {
/*     */                       PreferencesManager.a().e("failed to load backup", new Object[] { exception });
/*     */                       if (param1ObjectConsumer != null) {
/*     */                         param1ObjectConsumer.accept(Boolean.FALSE);
/*     */                       }
/*     */                       return;
/*     */                     } 
/*     */                   });
/*     */             }
/*     */             
/*     */             public void failed(Throwable param1Throwable) {
/* 535 */               PreferencesManager.a().e("failed to send backup request", new Object[] { param1Throwable });
/* 536 */               if (this.a != null) {
/* 537 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(Boolean.FALSE));
/*     */               }
/*     */             }
/*     */ 
/*     */             
/*     */             public void cancelled() {
/* 543 */               PreferencesManager.a().e("canceled to send backup request", new Object[0]);
/* 544 */               if (this.a != null)
/* 545 */                 Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept(Boolean.FALSE)); 
/*     */             }
/*     */           });
/*     */       return;
/* 549 */     } catch (Exception exception) {
/* 550 */       a.e("failed to send backup request", new Object[] { exception });
/* 551 */       if (paramObjectConsumer != null) {
/* 552 */         Threads.i().runOnMainThread(() -> paramObjectConsumer.accept(Boolean.FALSE));
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBase64(String paramString) {
/* 564 */     byte[] arrayOfByte = Base64Coder.decode(paramString);
/* 565 */     fromBytes(arrayOfByte, 0, arrayOfByte.length);
/*     */   }
/*     */   
/*     */   public void fromBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     RegularPrefMap.BinarySaveInfo binarySaveInfo;
/* 570 */     if ((binarySaveInfo = RegularPrefMap.getBinarySaveInfo(paramArrayOfbyte, paramInt1, paramInt2)).valid) {
/*     */       
/* 572 */       a.i("fromBytes - detected new save format: " + binarySaveInfo, new Object[0]);
/* 573 */       if (binarySaveInfo.type == 1) {
/* 574 */         a.i("detected progress preferences", new Object[0]);
/* 575 */         this.h.clear();
/*     */         try {
/* 577 */           this.h.fromBytes(paramArrayOfbyte, paramInt1, paramInt2);
/* 578 */           this.f.load((PrefMap)this.h);
/* 579 */           this.f.requireSave();
/* 580 */           reapplyAllPreferences();
/* 581 */           saveNowIfRequired(); return;
/* 582 */         } catch (Exception null) {
/* 583 */           a.e("fromBytes failed (progress)", new Object[] { exception }); return;
/*     */         } 
/* 585 */       }  if (binarySaveInfo.type == 2) {
/* 586 */         a.i("detected settings preferences", new Object[0]);
/* 587 */         this.i.clear();
/*     */         try {
/* 589 */           this.i.fromBytes((byte[])exception, paramInt1, paramInt2);
/* 590 */           this.g.load((PrefMap)this.i);
/* 591 */           this.g.requireSave();
/* 592 */           reapplyAllPreferences();
/* 593 */           saveNowIfRequired(); return;
/* 594 */         } catch (Exception exception) {
/* 595 */           a.e("fromBytes failed (settings)", new Object[] { exception }); return;
/*     */         } 
/*     */       } 
/* 598 */       a.e("fromBytes - new preferences format but unknown type: " + binarySaveInfo, new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 602 */     a.i("fromBytes - not a new save format, trying legacy: " + binarySaveInfo, new Object[0]);
/* 603 */     Array<ObjectPair<String, HashMap<String, String>>> array = this.e.fromBytes((byte[])exception, paramInt1, paramInt2);
/* 604 */     fromLegacy(array, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String progressPrefsToBase64() {
/* 609 */     this.h.clear();
/* 610 */     getProgressPrefs().save((PrefMap)this.h);
/* 611 */     return this.h.toBase64();
/*     */   }
/*     */   
/*     */   public String settingsPrefsToBase64() {
/* 615 */     this.i.clear();
/* 616 */     getProgressPrefs().save((PrefMap)this.i);
/* 617 */     return this.i.toBase64();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 622 */     saveNowIfRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(PreferencesManagerListener paramPreferencesManagerListener) {
/* 628 */     if (paramPreferencesManagerListener == null) {
/* 629 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 632 */     if (!this.c.contains(paramPreferencesManagerListener, true)) {
/* 633 */       this.c.add(paramPreferencesManagerListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(PreferencesManagerListener paramPreferencesManagerListener) {
/* 638 */     if (paramPreferencesManagerListener == null) {
/* 639 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 642 */     this.c.removeValue(paramPreferencesManagerListener, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reapplyAllPreferences() {
/* 648 */     if (this.b) {
/* 649 */       throw new IllegalStateException("Calling reapplyAllPreferences from PreferencesManagerListener.reloaded");
/*     */     }
/*     */     
/*     */     try {
/* 653 */       this.b = true;
/* 654 */       this.c.begin(); byte b; int i;
/* 655 */       for (b = 0, i = this.c.size; b < i; b++) {
/* 656 */         ((PreferencesManagerListener)this.c.get(b)).reloaded();
/*     */       }
/* 658 */       this.c.end();
/* 659 */       this.b = false; return;
/*     */     } finally {
/* 661 */       this.b = false;
/*     */     } 
/*     */   }
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
/*     */   
/*     */   public void resetProgress() {
/* 676 */     Game.i.progressManager.removeIssuedItemsLog();
/* 677 */     this.f = new ProgressPrefs();
/* 678 */     Gdx.files.local(getProgressPrefsFilePath()).delete();
/* 679 */     Gdx.files.local("cache/saves_dev/progress.txt").delete();
/*     */     
/* 681 */     Game.i.replayManager.deleteAllReplays();
/*     */     
/* 683 */     (SettingsPrefs.i()).auth.setNoCloudSaveSlot();
/* 684 */     SettingsPrefs.i().requireSave();
/*     */     
/* 686 */     a.i("all progress preferences removed", new Object[0]);
/*     */     
/* 688 */     reapplyAllPreferences();
/*     */   }
/*     */   
/*     */   public static interface PreferencesManagerListener {
/*     */     void reloaded();
/*     */     
/*     */     public static class PreferencesManagerListenerAdapter implements PreferencesManagerListener {
/*     */       public void reloaded() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\PreferencesManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */