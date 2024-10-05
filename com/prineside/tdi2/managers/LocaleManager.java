/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.CharArray;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.PropertiesUtils;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.I18NBundle;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Properties;
/*     */ 
/*     */ @REGS(serializer = LocaleManager.Serializer.class)
/*     */ public class LocaleManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*  38 */   private static final TLog a = TLog.forClass(LocaleManager.class); public I18NBundle i18n;
/*     */   private final Array<Locale> b;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<LocaleManager> { public LocaleManager read() {
/*  42 */       return Game.i.localeManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private final Object c = new Object();
/*     */   
/*  52 */   private final DelayedRemovalArray<LocaleManagerListener> d = new DelayedRemovalArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocaleManager() {
/*  59 */     boolean bool = false;
/*  60 */     if (!Gdx.files.local("i18n/MainBundle.properties").exists()) {
/*  61 */       a.i("main file not found in local directory", new Object[0]);
/*  62 */       bool = true;
/*     */     } else {
/*     */       
/*  65 */       FileHandle fileHandle = Gdx.files.local("i18n/MainBundle.properties");
/*     */       try {
/*     */         String str;
/*  68 */         if ((str = fileHandle.reader(1024, "UTF-8").readLine()).startsWith("#B")) {
/*  69 */           int i = Integer.parseInt(str.substring(2).trim());
/*  70 */           if (207 != i) {
/*  71 */             a.i("main local file build does not match: " + i + " != 207", new Object[0]);
/*  72 */             bool = true;
/*     */           } else {
/*  74 */             a.i("main local file is good", new Object[0]);
/*     */           } 
/*     */         } else {
/*  77 */           a.i("main local file doesn't start with a '#B'", new Object[0]);
/*  78 */           bool = true;
/*     */         } 
/*  80 */       } catch (Exception exception) {
/*  81 */         a.e("failed to read first line of local main file", new Object[] { exception });
/*  82 */         bool = true;
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     if (bool) {
/*     */       JsonValue jsonValue;
/*  88 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/locales.json"))).iterator(); jsonIterator.hasNext();) {
/*     */         
/*  90 */         if ((str = (jsonValue1 = jsonIterator.next()).asString()).startsWith("MainBundle")) {
/*     */           try {
/*  92 */             String str1 = Gdx.files.internal("i18n/" + str).reader(1024, "UTF-8").readLine();
/*  93 */             null = Gdx.files.internal("i18n/" + str).readString("UTF-8");
/*  94 */             if (str1.startsWith("#B")) {
/*     */               
/*  96 */               int i = null.indexOf("\n");
/*  97 */               null = null.substring(i + 1);
/*     */             } 
/*     */             
/* 100 */             synchronized (this.c) {
/* 101 */               Gdx.files.local("i18n/" + str).writeString("#B207\n" + null, false, "UTF-8");
/* 102 */               if (str.equals("MainBundle_id_ID.properties")) {
/* 103 */                 Gdx.files.local("i18n/MainBundle_in_ID.properties").writeString("#B207\n" + null, false, "UTF-8");
/*     */               }
/*     */             } 
/* 106 */             a.i("copied " + str + " to the local directory", new Object[0]);
/* 107 */           } catch (Exception exception) {
/* 108 */             a.e("failed to copy " + str, new Object[0]);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 115 */     this.b = new Array();
/*     */     
/* 117 */     if (Config.isHeadless()) {
/* 118 */       this.b.add(new Locale("en_US", "English"));
/*     */     } else {
/*     */       JsonValue jsonValue;
/* 121 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/locales.json"))).iterator(); jsonIterator.hasNext();) {
/*     */         
/* 123 */         if ((str1 = (jsonValue1 = jsonIterator.next()).asString()).startsWith("MainBundle") && (
/*     */           
/* 125 */           str2 = str1.substring(10, str1.length() - 11)).length() != 0) {
/*     */           java.util.Locale locale;
/* 127 */           if (str2.charAt(0) == '_') {
/* 128 */             str2 = str2.substring(1);
/*     */           }
/*     */ 
/*     */           
/*     */           String[] arrayOfString2;
/*     */ 
/*     */           
/* 135 */           if ((arrayOfString2 = str2.split("_")).length == 1) {
/* 136 */             locale = new java.util.Locale(arrayOfString2[0]);
/*     */           } else {
/* 138 */             locale = new java.util.Locale(arrayOfString2[0], arrayOfString2[1]);
/*     */           } 
/* 140 */           String str4 = locale.getDisplayLanguage() + " (" + str2 + ")";
/*     */           
/*     */           FileHandle fileHandle;
/*     */           String arrayOfString1[], str3;
/*     */           int i;
/*     */           byte b;
/* 146 */           for (i = (arrayOfString1 = arrayOfString1 = (str3 = (fileHandle = Gdx.files.local("i18n/" + str1)).readString("UTF-8")).split("\n")).length, b = 0; b < i; ) {
/*     */             String str;
/*     */             String[] arrayOfString;
/* 149 */             if ((arrayOfString = (str = arrayOfString1[b]).split("=")).length > 1 && arrayOfString[0].equals("NAME_OF_THE_LANGUAGE")) {
/*     */               
/* 151 */               str4 = arrayOfString[1].trim();
/*     */               break;
/*     */             } 
/*     */             b++;
/*     */           } 
/* 156 */           this.b.add(new Locale(str2, str4));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 162 */     a.i("loaded", new Object[0]);
/*     */   }
/*     */   
/*     */   public void downloadFreshTranslationsAsync() {
/* 166 */     if (Config.isHeadless()) {
/*     */       return;
/*     */     }
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
/*     */     Thread thread;
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
/* 245 */     (thread = new Thread(() -> { String str1 = getLocale(); a.i("locale: " + str1, new Object[0]); String str2 = StringFormatter.md5Hash(Gdx.files.local("i18n/MainBundle.properties").readString("UTF-8")); String str3 = null; if (!str1.equals("en_US")) str3 = StringFormatter.md5Hash(Gdx.files.local("i18n/MainBundle_" + str1 + ".properties").readString("UTF-8"));  Net.HttpRequest httpRequest; (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.SITE_URL + "/?m=api&a=downloadTranslations&v=207"); HashMap<Object, Object> hashMap; (hashMap = new HashMap<>()).put("build", "207"); hashMap.put("locale", str1); hashMap.put("mainHash", str2); if (str3 != null) hashMap.put("selectedLocaleHash", str3);  httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap)); a.i("downloading fresh translations for " + str1, new Object[0]); Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, str1) { public void handleHttpResponse(Net.HttpResponse param1HttpResponse) { String str = param1HttpResponse.getResultAsString(); try { boolean bool = false; JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(str)).getString("status").equals("success")) { JsonValue jsonValue1; for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue1 = jsonValue.get("files")).iterator(); jsonIterator.hasNext(); ) { String str3; JsonValue jsonValue2; String str2 = (jsonValue2 = jsonIterator.next()).getString("locale"); String str1 = jsonValue2.getString("contents"); if (str2.equals("en_US")) { str3 = "i18n/MainBundle.properties"; } else { str3 = "i18n/MainBundle_" + str2 + ".properties"; }  synchronized (LocaleManager.a(this.b)) { Gdx.files.local(str3).writeString(str1, false, "UTF-8"); LocaleManager.b().i("updated translations for " + str2, new Object[0]); bool = true; }  }  } else { LocaleManager.b().e(str, new Object[0]); }  if (bool) { Threads.i().runOnMainThread(() -> this.b.setLocale(this.b.getLocale(), false)); } else { LocaleManager.b().i("locales are up to date", new Object[0]); return; }  } catch (Exception exception) { LocaleManager.b().e("Failed to download fresh translations", new Object[] { exception }); }  } public void failed(Throwable param1Throwable) { LocaleManager.b().e("Failed to download fresh translations for " + this.a, new Object[] { param1Throwable }); } public void cancelled() { LocaleManager.b().e("Failed to download fresh translations for " + this.a + " - canceled", new Object[0]); } }); })).setDaemon(true);
/* 246 */     thread.start();
/* 247 */     CrashHandler.handleThreadExceptionsForgiving(thread);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatNthEnemy(int paramInt) {
/* 254 */     return this.i18n.format("every_nth_enemy", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatNthShot(int paramInt) {
/* 262 */     switch (paramInt) { case 2:
/* 263 */         return this.i18n.get("second_shot");
/* 264 */       case 3: return this.i18n.get("third_shot");
/* 265 */       case 4: return this.i18n.get("fourth_shot");
/* 266 */       case 5: return this.i18n.get("fifth_shot");
/* 267 */       case 6: return this.i18n.get("sixth_shot");
/* 268 */       case 7: return this.i18n.get("seventh_shot");
/* 269 */       case 8: return this.i18n.get("eighth_shot");
/* 270 */       case 9: return this.i18n.get("ninth_shot");
/* 271 */       case 10: return this.i18n.get("tenth_shot"); }
/* 272 */      return this.i18n.format("nth", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<Locale> getAvailableLocales() {
/*     */     Array<Locale> array;
/* 278 */     (array = new Array(Locale.class)).addAll(this.b);
/*     */     
/* 280 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/* 285 */     reload();
/* 286 */     Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*     */         {
/*     */           public void reloaded() {
/* 289 */             this.a.reload();
/*     */           }
/*     */         });
/*     */   }
/*     */   public static interface LocaleManagerListener {
/*     */     void localeChanged(); }
/*     */   public void reload() {
/* 296 */     java.util.Locale locale = new java.util.Locale("en", "US");
/* 297 */     if ((SettingsPrefs.i()).locale.localeName != null) {
/*     */       String[] arrayOfString;
/*     */       
/* 300 */       if ((arrayOfString = (SettingsPrefs.i()).locale.localeName.split("_")).length == 2 && arrayOfString[0].length() == 2 && arrayOfString[1].length() == 2) {
/* 301 */         locale = new java.util.Locale(arrayOfString[0], arrayOfString[1]);
/*     */       } else {
/*     */         
/* 304 */         (SettingsPrefs.i()).locale.localeName = null;
/* 305 */         SettingsPrefs.i().requireSave();
/* 306 */         a.e("invalid locale in preferences: " + Arrays.toString((Object[])arrayOfString), new Object[0]);
/*     */       } 
/*     */     } 
/*     */     
/* 310 */     this.i18n = I18NBundle.createBundle(Gdx.files.local("i18n/MainBundle"), locale);
/*     */     
/* 312 */     String str = this.i18n.getLocale().getLanguage() + "_" + this.i18n.getLocale().getCountry();
/* 313 */     a.i("Locale set to: " + locale.getLanguage() + "_" + locale.getCountry() + ", real locale: " + str, new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     downloadFreshTranslationsAsync();
/*     */     
/* 322 */     c();
/*     */   }
/*     */   
/*     */   public void addListener(LocaleManagerListener paramLocaleManagerListener) {
/* 326 */     if (paramLocaleManagerListener == null) {
/* 327 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 330 */     if (!this.d.contains(paramLocaleManagerListener, true)) {
/* 331 */       this.d.add(paramLocaleManagerListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public CharArray getAllLocalesChars() {
/*     */     IntSet intSet;
/* 337 */     (intSet = new IntSet()).add(10);
/* 338 */     intSet.add(32);
/* 339 */     CharArray charArray = new CharArray();
/*     */     
/*     */     Array array;
/* 342 */     (array = new Array()).add("i18n/MainBundle.properties"); byte b;
/* 343 */     for (b = 0; b < this.b.size; b++) {
/* 344 */       array.add("i18n/MainBundle_" + ((Locale)this.b.get(b)).alias + ".properties");
/*     */     }
/*     */     
/*     */     try {
/* 348 */       for (b = 0; b < array.size; b++) {
/* 349 */         a.i("getting chars from " + (String)array.get(b), new Object[0]);
/* 350 */         FileHandle fileHandle = Gdx.files.local((String)array.get(b));
/*     */         
/*     */         ObjectMap objectMap;
/* 353 */         PropertiesUtils.load(objectMap = new ObjectMap(), fileHandle.reader("UTF-8"));
/*     */         
/* 355 */         byte b1 = 0;
/* 356 */         CharArray charArray1 = new CharArray();
/* 357 */         for (ObjectMap.Values<Object> values = objectMap.values().iterator(); values.hasNext(); ) {
/*     */           String str; char[] arrayOfChar; int i;
/*     */           byte b2;
/* 360 */           for (i = (arrayOfChar = arrayOfChar = (str = (String)(str = (String)values.next())).toCharArray()).length, b2 = 0; b2 < i; ) { char c = arrayOfChar[b2];
/* 361 */             if (!intSet.contains(c)) {
/* 362 */               intSet.add(c);
/* 363 */               charArray.add(c);
/* 364 */               charArray1.add(c);
/* 365 */               b1++;
/*     */             } 
/*     */             
/*     */             b2++; }
/*     */ 
/*     */           
/* 371 */           for (i = (arrayOfChar = arrayOfChar = (str = str.toUpperCase()).toCharArray()).length, b2 = 0; b2 < i; ) { char c = arrayOfChar[b2];
/* 372 */             if (!intSet.contains(c)) {
/* 373 */               intSet.add(c);
/* 374 */               charArray.add(c);
/* 375 */               charArray1.add(c);
/* 376 */               b1++;
/*     */             }  b2++; }
/*     */         
/*     */         } 
/* 380 */         a.i("added " + b1 + " chars (" + charArray1.toString("") + ")", new Object[0]);
/*     */       } 
/* 382 */     } catch (Exception exception) {
/* 383 */       a.e("failed to get all chars", new Object[] { exception });
/*     */     } 
/* 385 */     charArray.sort();
/*     */     
/* 387 */     return charArray;
/*     */   }
/*     */   
/*     */   public ObjectMap<String, CharArray> getAllLocalesCharsPerFile() {
/*     */     Array array;
/* 392 */     (array = new Array()).add("i18n/MainBundle.properties");
/* 393 */     for (byte b = 0; b < this.b.size; b++) {
/* 394 */       array.add("i18n/MainBundle_" + ((Locale)this.b.get(b)).alias + ".properties");
/*     */     }
/*     */     
/* 397 */     ObjectMap<String, CharArray> objectMap = new ObjectMap();
/*     */     try {
/* 399 */       for (byte b1 = 0; b1 < array.size; b1++) {
/*     */         IntSet intSet;
/* 401 */         (intSet = new IntSet()).add(10);
/* 402 */         intSet.add(32);
/* 403 */         CharArray charArray1 = new CharArray();
/*     */         
/* 405 */         a.i("getting chars from " + (String)array.get(b1), new Object[0]);
/* 406 */         FileHandle fileHandle = Gdx.files.local((String)array.get(b1));
/*     */         
/*     */         ObjectMap objectMap1;
/* 409 */         PropertiesUtils.load(objectMap1 = new ObjectMap(), fileHandle.reader("UTF-8"));
/*     */         
/* 411 */         byte b2 = 0;
/* 412 */         CharArray charArray2 = new CharArray();
/* 413 */         for (ObjectMap.Values<Object> values = objectMap1.values().iterator(); values.hasNext(); ) {
/*     */           String str1; char[] arrayOfChar; int i;
/*     */           byte b3;
/* 416 */           for (i = (arrayOfChar = arrayOfChar = (str1 = (String)(str1 = (String)values.next())).toCharArray()).length, b3 = 0; b3 < i; ) { char c = arrayOfChar[b3];
/* 417 */             if (!intSet.contains(c)) {
/* 418 */               intSet.add(c);
/* 419 */               charArray1.add(c);
/* 420 */               charArray2.add(c);
/* 421 */               b2++;
/*     */             } 
/*     */             
/*     */             b3++; }
/*     */ 
/*     */           
/* 427 */           for (i = (arrayOfChar = arrayOfChar = (str1 = str1.toUpperCase()).toCharArray()).length, b3 = 0; b3 < i; ) { char c = arrayOfChar[b3];
/* 428 */             if (!intSet.contains(c)) {
/* 429 */               intSet.add(c);
/* 430 */               charArray1.add(c);
/* 431 */               charArray2.add(c);
/* 432 */               b2++;
/*     */             }  b3++; }
/*     */         
/*     */         } 
/* 436 */         charArray1.sort();
/* 437 */         a.i("added " + b2 + " chars (" + charArray2.toString("") + ")", new Object[0]);
/*     */         
/*     */         String str;
/*     */         
/* 441 */         if ((str = (str = ((String)array.get(b1)).substring(5)).substring(0, str.length() - 11)).equals("MainBundle")) {
/* 442 */           str = "main";
/*     */         } else {
/* 444 */           str = str.substring(11);
/*     */         } 
/* 446 */         objectMap.put(str, charArray1);
/*     */       } 
/* 448 */     } catch (Exception exception) {
/* 449 */       a.e("failed to get all chars", new Object[] { exception });
/*     */     } 
/*     */     
/* 452 */     return objectMap;
/*     */   }
/*     */   
/*     */   private void c() {
/* 456 */     this.d.begin(); byte b; int i;
/* 457 */     for (b = 0, i = this.d.size; b < i; b++) {
/* 458 */       ((LocaleManagerListener)this.d.get(b)).localeChanged();
/*     */     }
/* 460 */     this.d.end();
/*     */   }
/*     */   
/*     */   static boolean a() {
/* 464 */     return ((SettingsPrefs.i()).locale.localeName != null);
/*     */   }
/*     */   
/*     */   public void setLocale(String paramString, boolean paramBoolean) {
/* 468 */     a.i("setLocale " + paramString, new Object[0]);
/* 469 */     boolean bool = false;
/* 470 */     for (Array.ArrayIterator<Locale> arrayIterator = this.b.iterator(); arrayIterator.hasNext();) {
/* 471 */       if ((locale1 = arrayIterator.next()).alias.equals(paramString)) {
/* 472 */         bool = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 477 */     if (!bool) {
/* 478 */       a.e("Invalid locale: " + paramString, new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 482 */     (SettingsPrefs.i()).locale.localeName = paramString;
/* 483 */     SettingsPrefs.i().requireSave();
/*     */ 
/*     */     
/* 486 */     String[] arrayOfString = paramString.split("_");
/* 487 */     java.util.Locale locale = new java.util.Locale(arrayOfString[0], arrayOfString[1]);
/* 488 */     this.i18n = I18NBundle.createBundle(Gdx.files.local("i18n/MainBundle"), locale);
/*     */     
/* 490 */     a.i("Locale set to '" + paramString + "'", new Object[0]);
/*     */     
/* 492 */     c();
/*     */     
/* 494 */     if (paramBoolean) downloadFreshTranslationsAsync();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String getLocale() {
/* 501 */     return ((SettingsPrefs.i()).locale.localeName == null) ? "en_US" : (SettingsPrefs.i()).locale.localeName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void test() {
/* 507 */     for (Array.ArrayIterator<Locale> arrayIterator = this.b.iterator(); arrayIterator.hasNext(); ) {
/* 508 */       Locale locale; String[] arrayOfString = (locale = arrayIterator.next()).alias.split("_");
/* 509 */       java.util.Locale locale1 = new java.util.Locale(arrayOfString[0], arrayOfString[1]);
/* 510 */       I18NBundle i18NBundle = I18NBundle.createBundle(Gdx.files.local("i18n/MainBundle"), locale1);
/*     */       
/*     */       try {
/* 513 */         File file = new File("i18n/MainBundle.properties");
/* 514 */         FileInputStream fileInputStream = new FileInputStream(file);
/*     */         Properties properties;
/* 516 */         (properties = new Properties()).load(fileInputStream);
/* 517 */         fileInputStream.close();
/*     */         
/* 519 */         Enumeration<Object> enumeration = properties.keys();
/* 520 */         while (enumeration.hasMoreElements()) {
/* 521 */           String str = (String)enumeration.nextElement();
/*     */           try {
/* 523 */             i18NBundle.get(str);
/* 524 */           } catch (Exception exception) {
/* 525 */             a.e("failed to get key '" + str + "' from locale " + locale.alias + " - " + exception.getMessage(), new Object[0]);
/*     */           } 
/*     */         } 
/* 528 */       } catch (Exception exception) {
/* 529 */         a.e("failed to test locale properties", new Object[] { exception });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */   
/*     */   public static class Locale
/*     */   {
/*     */     public final String name;
/*     */     
/*     */     public final String alias;
/*     */     
/*     */     public final String localeLanguage;
/*     */ 
/*     */     
/*     */     public Locale(String param1String1, String param1String2) {
/* 548 */       this.alias = param1String1;
/* 549 */       this.name = param1String2;
/*     */       
/* 551 */       String[] arrayOfString = param1String1.split("_");
/* 552 */       this.localeLanguage = arrayOfString[0];
/*     */       
/* 554 */       LocaleManager.b().i("Registered '" + this.localeLanguage + "' " + param1String1 + " " + param1String2, new Object[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\LocaleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */