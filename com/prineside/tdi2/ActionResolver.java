/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.audio.AudioDevice;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.pay.PurchaseManager;
/*     */ import com.badlogic.gdx.pay.Transaction;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.managers.MusicManager;
/*     */ import com.prineside.tdi2.managers.PurchaseManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.FileChooser;
/*     */ import com.prineside.tdi2.utils.IntPair;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.logging.PlatformLogger;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ public interface ActionResolver {
/*     */   FileHandle getLogFile();
/*     */   
/*     */   PlatformLogger createPlatformLogger();
/*     */   
/*     */   boolean isAppModified();
/*     */   
/*     */   ObjectMap<String, String> getDeviceInfo();
/*     */   
/*     */   String getShortDeviceInfo();
/*     */   
/*     */   PurchaseManager getPurchaseManager();
/*     */   
/*     */   @Null
/*     */   IntPair getBestScreenResolution();
/*     */   
/*     */   AudioDevice newAudioDevice(int paramInt, boolean paramBoolean);
/*     */   
/*     */   MusicManager getCachedMusicManager();
/*     */   
/*     */   void onExit();
/*     */   
/*     */   int[] getScreenSafeAreaInsets();
/*     */   
/*     */   void parseHtml(String paramString);
/*     */   
/*     */   int getWindowsGraphicsScale();
/*     */   
/*     */   void setFpsLimit(int paramInt);
/*     */   
/*     */   InitConfigManager getInitConfigManager();
/*     */   
/*     */   HashSet<Class<?>> getClasses(String paramString);
/*     */   
/*     */   void getMobilePasswordInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3);
/*     */   
/*     */   boolean rewardAdsAvailable();
/*     */   
/*     */   boolean canShowRewardAd();
/*     */   
/*     */   int getSecondsTillCanShowRewardAd();
/*     */   
/*     */   void showRewardAd(ObjectConsumer<Boolean> paramObjectConsumer, PurchaseManager.RewardingAdsType paramRewardingAdsType);
/*     */   
/*     */   void showInterstitialAd(ObjectConsumer<Boolean> paramObjectConsumer);
/*     */   
/*     */   boolean hasGoogleAuth();
/*     */   
/*     */   boolean isSignedInWithGoogle();
/*     */   
/*     */   void requestGoogleAuth(ObjectConsumer<String> paramObjectConsumer);
/*     */   
/*     */   void signOutGoogle();
/*     */   
/*     */   void requestLogin();
/*     */   
/*     */   void logCurrencyReceived(String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   void logCurrencySpent(String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   void logLogined(String paramString);
/*     */   
/*     */   void logSignedUp(String paramString);
/*     */   
/*     */   void logCustomEvent(String paramString, String[] paramArrayOfString);
/*     */   
/*     */   void logIAP(Config.ProductId paramProductId, Transaction paramTransaction);
/*     */   
/*     */   void logRewardedVideoViewed(PurchaseManager.RewardingAdsType paramRewardingAdsType);
/*     */   
/*     */   void logShopOfferPurchased(String paramString1, int paramInt1, String paramString2, int paramInt2);
/*     */   
/*     */   void logShopOffersSkipped(int paramInt);
/*     */   
/*     */   void logScreenChange(String paramString);
/*     */   
/*     */   boolean hasNotifications();
/*     */   
/*     */   void addNotification(int paramInt, String paramString1, String paramString2, long paramLong);
/*     */   
/*     */   void clearNotification(int paramInt);
/*     */   
/*     */   void unlockAchievement(AchievementType paramAchievementType);
/*     */   
/*     */   void openHandbook();
/*     */   
/*     */   void openSupportPage();
/*     */   
/*     */   boolean doubleGainEnabledBySteamGamePurchase();
/*     */   
/*     */   void handleThreadExceptions(Thread paramThread);
/*     */   
/*     */   void generateDeviceReport(Json paramJson);
/*     */   
/*     */   String glGetStringi(int paramInt1, int paramInt2);
/*     */   
/*     */   ClassLoadingStrategy getByteBuddyClassLoadingStrategy();
/*     */   
/*     */   void handleTextFieldFocus(FocusListener.FocusEvent paramFocusEvent, TextField paramTextField, boolean paramBoolean);
/*     */   
/*     */   void requestSteamAuthTicket(ObjectConsumer<String> paramObjectConsumer);
/*     */   
/*     */   String getDefaultLocale();
/*     */   
/*     */   boolean personalizedAdsSupported();
/*     */   
/*     */   boolean personalizedAdsEnabled();
/*     */   
/*     */   void setPersonalizedAds(boolean paramBoolean);
/*     */   
/*     */   @Null
/*     */   FileChooser getFileChooser();
/*     */   
/*     */   public static abstract class ActionResolverAdapter implements ActionResolver {
/* 142 */     public PurchaseManager getPurchaseManager() { return null; } private ActionResolver.InitConfigManager a; public int[] getScreenSafeAreaInsets() {
/* 143 */       return new int[4]; } @Null
/* 144 */     public IntPair getBestScreenResolution() { return null; }
/*     */      public void setFpsLimit(int param1Int) {} public int getWindowsGraphicsScale() {
/* 146 */       return -1;
/*     */     }
/*     */     public void parseHtml(String param1String) {
/* 149 */       throw new RuntimeException("Not available on this platform");
/*     */     }
/*     */     
/*     */     public MusicManager getCachedMusicManager() {
/* 153 */       throw new UnsupportedOperationException("Not implemented");
/*     */     } public boolean hasNotifications() {
/* 155 */       return false;
/*     */     }
/*     */     public void addNotification(int param1Int, String param1String1, String param1String2, long param1Long) {}
/*     */     public void clearNotification(int param1Int) {}
/*     */     
/*     */     public void requestLogin() {}
/*     */     
/*     */     public void generateDeviceReport(Json param1Json) {}
/*     */     
/*     */     public ActionResolver.InitConfigManager getInitConfigManager() {
/* 165 */       if (this.a == null) {
/* 166 */         this.a = new ActionResolver.InitConfigManager();
/*     */       }
/*     */       
/* 169 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void getMobilePasswordInput(Input.TextInputListener param1TextInputListener, String param1String1, String param1String2, String param1String3) {
/* 174 */       throw new RuntimeException("Only for mobile devices");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean rewardAdsAvailable() {
/* 179 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canShowRewardAd() {
/* 184 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasGoogleAuth() {
/* 189 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSignedInWithGoogle() {
/* 194 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void requestGoogleAuth(ObjectConsumer<String> param1ObjectConsumer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void signOutGoogle() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logCurrencyReceived(String param1String1, String param1String2, int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logCurrencySpent(String param1String1, String param1String2, int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logLogined(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logSignedUp(String param1String) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logShopOfferPurchased(String param1String1, int param1Int1, String param1String2, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logShopOffersSkipped(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void logScreenChange(String param1String) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSecondsTillCanShowRewardAd() {
/* 244 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void showRewardAd(ObjectConsumer<Boolean> param1ObjectConsumer, PurchaseManager.RewardingAdsType param1RewardingAdsType) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void showInterstitialAd(ObjectConsumer<Boolean> param1ObjectConsumer) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAppModified() {
/* 259 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logCustomEvent(String param1String, String[] param1ArrayOfString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void logIAP(Config.ProductId param1ProductId, Transaction param1Transaction) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void logRewardedVideoViewed(PurchaseManager.RewardingAdsType param1RewardingAdsType) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public HashSet<Class<?>> getClasses(String param1String) {
/* 279 */       throw new RuntimeException("Not implemented on this platform");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onExit() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public AudioDevice newAudioDevice(int param1Int, boolean param1Boolean) {
/* 289 */       return Gdx.audio.newAudioDevice(param1Int, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public void unlockAchievement(AchievementType param1AchievementType) {}
/*     */ 
/*     */     
/*     */     public void openHandbook() {
/* 297 */       Gdx.net.openURI(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.WIKI_URL));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean doubleGainEnabledBySteamGamePurchase() {
/* 302 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void openSupportPage() {
/* 307 */       Gdx.net.openURI("https://prineside.com/support.html");
/* 308 */       Gdx.app.getClipboard().setContents("sup.prineside@gmail.com");
/* 309 */       Notifications.i().addSuccess("Contact us: sup.prineside@gmail.com");
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleThreadExceptions(Thread param1Thread) {}
/*     */     
/*     */     public ClassLoadingStrategy getByteBuddyClassLoadingStrategy() {
/* 316 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleTextFieldFocus(FocusListener.FocusEvent param1FocusEvent, TextField param1TextField, boolean param1Boolean) {}
/*     */ 
/*     */     
/*     */     public void requestSteamAuthTicket(ObjectConsumer<String> param1ObjectConsumer) {}
/*     */     
/*     */     public String getDefaultLocale() {
/* 326 */       return Locale.getDefault().toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean personalizedAdsSupported() {
/* 331 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean personalizedAdsEnabled() {
/* 336 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setPersonalizedAds(boolean param1Boolean) {}
/*     */   }
/*     */ 
/*     */   
/*     */   static ActionResolver createDummy(FileHandle paramFileHandle, PlatformLogger paramPlatformLogger) {
/* 346 */     Preconditions.checkNotNull(paramFileHandle, "logFile can not be null");
/* 347 */     Preconditions.checkNotNull(paramPlatformLogger, "logger can not be null");
/*     */     
/* 349 */     return new ActionResolverAdapter(paramFileHandle, paramPlatformLogger)
/*     */       {
/*     */         public FileHandle getLogFile() {
/* 352 */           return this.a;
/*     */         }
/*     */ 
/*     */         
/*     */         public PlatformLogger createPlatformLogger() {
/* 357 */           return this.b;
/*     */         }
/*     */ 
/*     */         
/*     */         public ObjectMap<String, String> getDeviceInfo() {
/* 362 */           return new ObjectMap();
/*     */         }
/*     */ 
/*     */         
/*     */         public String getShortDeviceInfo() {
/* 367 */           return "dummy";
/*     */         }
/*     */ 
/*     */         
/*     */         public String glGetStringi(int param1Int1, int param1Int2) {
/* 372 */           return "";
/*     */         }
/*     */ 
/*     */         
/*     */         public FileChooser getFileChooser() {
/* 377 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public static class InitConfigManager
/*     */   {
/*     */     public static final String INIT_CONFIG_FILE = "i2-config.json";
/*     */     private int[] a;
/*     */     private boolean b;
/*     */     
/*     */     private static String a() {
/*     */       try {
/*     */         File file;
/* 391 */         if (!(file = new File("i2-config.json")).exists()) return "{}"; 
/* 392 */         FileInputStream fileInputStream = new FileInputStream(file);
/*     */         BufferedReader bufferedReader;
/* 394 */         String str = (bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"))).readLine();
/* 395 */         StringBuilder stringBuilder = new StringBuilder();
/* 396 */         while (str != null) {
/* 397 */           stringBuilder.append(str).append("\n");
/* 398 */           str = bufferedReader.readLine();
/*     */         } 
/*     */         
/* 401 */         return stringBuilder.toString();
/* 402 */       } catch (Exception exception) {
/* 403 */         TLog.forClass(ActionResolver.class).e("loadConfigsJsonFromFile failed", new Object[] { exception });
/*     */ 
/*     */         
/* 406 */         return "{}";
/*     */       } 
/*     */     }
/*     */     private static void a(String param1String) {
/*     */       try {
/* 411 */         File file = new File("i2-config.json");
/*     */         FileWriter fileWriter;
/* 413 */         (fileWriter = new FileWriter(file)).write(param1String);
/* 414 */         fileWriter.close(); return;
/* 415 */       } catch (Exception exception) {
/* 416 */         TLog.forClass(ActionResolver.class).e("failed to save init configs", new Object[] { exception });
/*     */         return;
/*     */       } 
/*     */     }
/*     */     public void saveIfRequired() {
/* 421 */       if (this.b) {
/* 422 */         b();
/*     */       }
/*     */     }
/*     */     
/*     */     private void b() {
/* 427 */       this.b = false;
/*     */       
/* 429 */       Json json = new Json(JsonWriter.OutputType.json);
/* 430 */       StringWriter stringWriter = new StringWriter();
/* 431 */       json.setWriter(stringWriter);
/*     */       
/* 433 */       json.writeObjectStart();
/* 434 */       int[] arrayOfInt = c(); SettingsManager.InitConfig[] arrayOfInitConfig; int i; byte b;
/* 435 */       for (i = (arrayOfInitConfig = SettingsManager.InitConfig.values).length, b = 0; b < i; ) { SettingsManager.InitConfig initConfig = arrayOfInitConfig[b];
/*     */         int j;
/* 437 */         if ((j = arrayOfInt[initConfig.ordinal()]) != getDefault(initConfig))
/* 438 */           json.writeValue(initConfig.name(), Integer.valueOf(j)); 
/*     */         b++; }
/*     */       
/* 441 */       json.writeObjectEnd();
/*     */       
/* 443 */       a(stringWriter.toString());
/*     */       
/* 445 */       TLog.forClass(ActionResolver.class).i("saved init configs", new Object[0]);
/*     */     }
/*     */     
/*     */     private int[] c() {
/* 449 */       if (this.a == null) {
/* 450 */         int[] arrayOfInt = new int[SettingsManager.InitConfig.values.length]; SettingsManager.InitConfig[] arrayOfInitConfig;
/*     */         int i;
/*     */         byte b;
/* 453 */         for (i = (arrayOfInitConfig = SettingsManager.InitConfig.values).length, b = 0; b < i; ) { SettingsManager.InitConfig initConfig = arrayOfInitConfig[b];
/* 454 */           arrayOfInt[initConfig.ordinal()] = getDefault(initConfig);
/*     */           
/*     */           b++; }
/*     */         
/*     */         JsonValue jsonValue;
/* 459 */         if ((jsonValue = (new JsonReader()).parse(a())) != null) {
/* 460 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */             try {
/* 462 */               SettingsManager.InitConfig initConfig = SettingsManager.InitConfig.valueOf(jsonValue1.name);
/* 463 */               int j = jsonValue1.asInt();
/* 464 */               arrayOfInt[initConfig.ordinal()] = j;
/* 465 */             } catch (Exception exception) {
/* 466 */               TLog.forClass(ActionResolver.class).e("unknown init config key or value is invalid: " + jsonValue1.name, new Object[0]);
/*     */             }  }
/*     */         
/*     */         }
/*     */         
/* 471 */         this.a = arrayOfInt;
/*     */       } 
/*     */       
/* 474 */       return this.a;
/*     */     }
/*     */     
/*     */     public boolean isAvailable(SettingsManager.InitConfig param1InitConfig) {
/* 478 */       return false;
/*     */     }
/*     */     
/*     */     public int get(SettingsManager.InitConfig param1InitConfig) {
/* 482 */       return c()[param1InitConfig.ordinal()];
/*     */     }
/*     */     
/*     */     public void set(SettingsManager.InitConfig param1InitConfig, int param1Int) {
/* 486 */       if (c()[param1InitConfig.ordinal()] != param1Int) {
/* 487 */         c()[param1InitConfig.ordinal()] = param1Int;
/* 488 */         this.b = true;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getDefault(SettingsManager.InitConfig param1InitConfig) {
/* 493 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ActionResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */