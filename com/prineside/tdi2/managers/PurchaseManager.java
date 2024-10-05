/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.pay.Information;
/*      */ import com.badlogic.gdx.pay.Offer;
/*      */ import com.badlogic.gdx.pay.OfferType;
/*      */ import com.badlogic.gdx.pay.PurchaseManagerConfig;
/*      */ import com.badlogic.gdx.pay.PurchaseObserver;
/*      */ import com.badlogic.gdx.pay.Transaction;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.global.GameLoad;
/*      */ import com.prineside.tdi2.items.DoubleGainShardItem;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Purchase;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ 
/*      */ @REGS(serializer = PurchaseManager.Serializer.class)
/*      */ public class PurchaseManager
/*      */   extends Manager.ManagerAdapter {
/*   48 */   private static final TLog a = TLog.forClass(PurchaseManager.class);
/*      */   public com.badlogic.gdx.pay.PurchaseManager purchaseManager;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<PurchaseManager> { public PurchaseManager read() {
/*   52 */       return Game.i.purchaseManager;
/*      */     } }
/*      */ 
/*      */   
/*      */   public enum RewardingAdsType
/*      */   {
/*   58 */     END_GAME,
/*   59 */     REGULAR,
/*      */     
/*   61 */     LOOT_MULTIPLIER;
/*      */     
/*   63 */     public static final RewardingAdsType[] values = values(); static {
/*      */     
/*   65 */     } } public final RewardingAdConfig[] rewardingAdConfigs = new RewardingAdConfig[RewardingAdsType.values.length];
/*      */   
/*      */   private IapOffersConfig b;
/*      */   
/*      */   private long c;
/*   70 */   private final DelayedRemovalArray<PurchaseManagerListener> d = new DelayedRemovalArray(false, 1);
/*      */   
/*      */   public String getPurchaseIdentifier(Config.ProductId paramProductId) {
/*   73 */     if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/*   74 */       switch (null.a[paramProductId.ordinal()]) { case 1:
/*   75 */           return "double_gain_infinitode2";
/*   76 */         case 2: return "pack_tiny_infinitode2";
/*   77 */         case 3: return "pack_small_infinitode2";
/*   78 */         case 4: return "pack_medium_infinitode2";
/*   79 */         case 5: return "pack_large_infinitode2";
/*   80 */         case 6: return "pack_huge_infinitode2";
/*   81 */         case 7: return "accelerator_pack_tiny_infinitode2";
/*   82 */         case 8: return "accelerator_pack_small_infinitode2";
/*   83 */         case 9: return "accelerator_pack_medium_infinitode2";
/*   84 */         case 10: return "accelerator_pack_large_infinitode2";
/*   85 */         case 11: return "accelerator_pack_huge2_infinitode2"; }
/*      */ 
/*      */     
/*      */     } else {
/*   89 */       switch (null.a[paramProductId.ordinal()]) { case 1:
/*   90 */           return "double_gain";
/*   91 */         case 2: return "pack_tiny";
/*   92 */         case 3: return "pack_small";
/*   93 */         case 4: return "pack_medium";
/*   94 */         case 5: return "pack_large";
/*   95 */         case 6: return "pack_huge";
/*   96 */         case 7: return "accelerator_pack_tiny";
/*   97 */         case 8: return "accelerator_pack_small";
/*   98 */         case 9: return "accelerator_pack_medium";
/*   99 */         case 10: return "accelerator_pack_large";
/*  100 */         case 11: return "accelerator_pack_huge"; }
/*      */     
/*      */     } 
/*  103 */     return null;
/*      */   }
/*      */   
/*      */   public Config.ProductId getProductId(String paramString) {
/*  107 */     if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/*  108 */       switch (paramString) { case "double_gain_infinitode2":
/*  109 */           return Config.ProductId.DOUBLE_GAIN;
/*  110 */         case "pack_tiny_infinitode2": return Config.ProductId.PACK_TINY;
/*  111 */         case "pack_small_infinitode2": return Config.ProductId.PACK_SMALL;
/*  112 */         case "pack_medium_infinitode2": return Config.ProductId.PACK_MEDIUM;
/*  113 */         case "pack_large_infinitode2": return Config.ProductId.PACK_LARGE;
/*  114 */         case "pack_huge_infinitode2": return Config.ProductId.PACK_HUGE;
/*  115 */         case "accelerator_pack_tiny_infinitode2": return Config.ProductId.ACCELERATOR_PACK_TINY;
/*  116 */         case "accelerator_pack_small_infinitode2": return Config.ProductId.ACCELERATOR_PACK_SMALL;
/*  117 */         case "accelerator_pack_medium_infinitode2": return Config.ProductId.ACCELERATOR_PACK_MEDIUM;
/*  118 */         case "accelerator_pack_large_infinitode2": return Config.ProductId.ACCELERATOR_PACK_LARGE;
/*  119 */         case "accelerator_pack_huge2_infinitode2": return Config.ProductId.ACCELERATOR_PACK_HUGE; }
/*      */     
/*      */     } else {
/*  122 */       switch (paramString) { case "double_gain":
/*  123 */           return Config.ProductId.DOUBLE_GAIN;
/*  124 */         case "pack_tiny": return Config.ProductId.PACK_TINY;
/*  125 */         case "pack_small": return Config.ProductId.PACK_SMALL;
/*  126 */         case "pack_medium": return Config.ProductId.PACK_MEDIUM;
/*  127 */         case "pack_large": return Config.ProductId.PACK_LARGE;
/*  128 */         case "pack_huge": return Config.ProductId.PACK_HUGE;
/*  129 */         case "accelerator_pack_tiny": return Config.ProductId.ACCELERATOR_PACK_TINY;
/*  130 */         case "accelerator_pack_small": return Config.ProductId.ACCELERATOR_PACK_SMALL;
/*  131 */         case "accelerator_pack_medium": return Config.ProductId.ACCELERATOR_PACK_MEDIUM;
/*  132 */         case "accelerator_pack_large": return Config.ProductId.ACCELERATOR_PACK_LARGE;
/*  133 */         case "accelerator_pack_huge": return Config.ProductId.ACCELERATOR_PACK_HUGE; }
/*      */     
/*      */     } 
/*  136 */     return null;
/*      */   }
/*      */   
/*      */   public PurchaseManager() {
/*  140 */     this.rewardingAdConfigs[RewardingAdsType.END_GAME.ordinal()] = new RewardingAdConfig(90, 1, 90);
/*      */ 
/*      */     
/*  143 */     this.rewardingAdConfigs[RewardingAdsType.REGULAR.ordinal()] = new RewardingAdConfig(14400, 10, 300);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  149 */     this.rewardingAdConfigs[RewardingAdsType.LOOT_MULTIPLIER.ordinal()] = new RewardingAdConfig(88, 1, 89);
/*      */ 
/*      */ 
/*      */     
/*  153 */     this.purchaseManager = Game.i.actionResolver.getPurchaseManager();
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
/*      */   public boolean rewardingAdsAvailable() {
/*  230 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.ENABLE_REWARDING_ADS) == 0.0D) return false; 
/*  231 */     if (!"true".equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.ADS_ENABLED))) return false;
/*      */     
/*  233 */     return (Game.i.actionResolver.rewardAdsAvailable() || Game.i.progressManager.isPremiumStatusActive());
/*      */   }
/*      */   
/*      */   public boolean canShowRewardingAd(RewardingAdsType paramRewardingAdsType) {
/*  237 */     if (!rewardingAdsAvailable()) return false;
/*      */     
/*  239 */     if (Game.i.actionResolver.canShowRewardAd() || Game.i.progressManager.isPremiumStatusActive()) {
/*  240 */       return (getSecondsTillAdIsReady(paramRewardingAdsType) == 0);
/*      */     }
/*  242 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean noIAPAbility() {
/*  252 */     return "true".equals(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_NOT_AVAILABLE_IN_COUNTRY));
/*      */   }
/*      */   
/*      */   public int getSecondsTillAdIsReady(RewardingAdsType paramRewardingAdsType) {
/*  256 */     RewardingAdConfig rewardingAdConfig = this.rewardingAdConfigs[paramRewardingAdsType.ordinal()];
/*  257 */     IntArray intArray = (ProgressPrefs.i()).purchase.getRewardingAdWatchTimestamps(paramRewardingAdsType);
/*      */     
/*  259 */     int i = Game.getTimestampSeconds();
/*      */     
/*  261 */     int j = Game.i.actionResolver.getSecondsTillCanShowRewardAd();
/*  262 */     int k = 0;
/*  263 */     int m = 0;
/*      */     
/*  265 */     if (intArray.size == rewardingAdConfig.maxViewsPerPeriod)
/*      */     {
/*      */       
/*  268 */       if ((k = intArray.items[0] + rewardingAdConfig.periodLength - i) < 0) k = 0; 
/*      */     }
/*  270 */     if (intArray.size != 0)
/*      */     {
/*      */       
/*  273 */       if ((m = intArray.items[intArray.size - 1] + rewardingAdConfig.minViewDelay - i) < 0) m = 0;
/*      */     
/*      */     }
/*  276 */     return StrictMath.max(j, StrictMath.max(k, m));
/*      */   }
/*      */   
/*      */   private void a(RewardingAdsType paramRewardingAdsType) {
/*  280 */     RewardingAdConfig rewardingAdConfig = this.rewardingAdConfigs[paramRewardingAdsType.ordinal()];
/*  281 */     (ProgressPrefs.i()).purchase.addRewardingAdWatchTimestamp(paramRewardingAdsType, rewardingAdConfig.maxViewsPerPeriod);
/*  282 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */   public void showRewardingAd(RewardingAdsType paramRewardingAdsType, ObjectConsumer<Boolean> paramObjectConsumer) {
/*      */     Runnable runnable;
/*  286 */     if (canShowRewardingAd(paramRewardingAdsType)) {
/*  287 */       if (Game.i.progressManager.isPremiumStatusActive()) {
/*      */         
/*  289 */         Game.i.statisticsManager.registerDelta(StatisticsType.RVW, 1.0D);
/*  290 */         (ProgressPrefs.i()).progress.registerVideoWatched();
/*  291 */         ProgressPrefs.i().requireSave();
/*      */         
/*  293 */         paramObjectConsumer.accept(Boolean.TRUE);
/*      */ 
/*      */         
/*  296 */         a(paramRewardingAdsType); return;
/*      */       } 
/*  298 */       runnable = (() -> {
/*      */           Game.i.statisticsManager.registerDelta(StatisticsType.RVW, 1.0D);
/*      */           
/*      */           (ProgressPrefs.i()).progress.registerVideoWatched();
/*      */           
/*      */           Game.i.analyticsManager.logRewardedVideoViewed(paramRewardingAdsType);
/*      */           
/*      */           paramObjectConsumer.accept(Boolean.TRUE);
/*      */           ProgressPrefs.i().requireSave();
/*      */         });
/*  308 */       Game.i.actionResolver.showRewardAd(paramBoolean -> paramBoolean.booleanValue(), paramRewardingAdsType);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  314 */       runnable.run();
/*      */ 
/*      */       
/*  317 */       a(paramRewardingAdsType);
/*      */       return;
/*      */     } 
/*  320 */     a.i(getSecondsTillAdIsReady(paramRewardingAdsType) + " seconds till ad is ready " + rewardingAdsAvailable() + " " + Game.i.actionResolver.canShowRewardAd() + " " + getSecondsTillAdIsReady(paramRewardingAdsType), new Object[0]);
/*  321 */     runnable.accept(Boolean.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*  327 */     Runnable runnable = () -> {
/*      */         Array array1 = (ProgressPrefs.i()).purchase.getTransactions();
/*      */         Array array2 = (ProgressPrefs.i()).purchase.getValidatedTransactions();
/*      */         for (byte b = 0; b < array1.size; b++) {
/*      */           Transaction transaction = (Transaction)array1.get(b);
/*      */           if (!array2.contains(transaction.getStoreName() + ";" + ((Game.i.authManager.getSessionId() == null) ? "g" : "u") + ";" + transaction.getOrderId(), false)) {
/*      */             a(transaction);
/*      */           }
/*      */         } 
/*      */       };
/*  337 */     if (Game.isLoaded()) {
/*  338 */       Threads.i().postRunnable(runnable); return;
/*      */     } 
/*  340 */     Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> Threads.i().postRunnable(paramRunnable));
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
/*      */   public int getPapersHourBasePrice(int paramInt, float paramFloat) {
/*  393 */     long l = (long)Game.i.statisticsManager.getAllTime(StatisticsType.GPG);
/*  394 */     float f = (float)(Game.i.statisticsManager.getAllTime(StatisticsType.PT) / 4.0D / 60.0D / 60.0D);
/*  395 */     int i = 0;
/*  396 */     if (f > 0.0F) {
/*  397 */       i = (int)((float)l / f);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  402 */     if (i < 0) {
/*  403 */       i = 0;
/*  404 */     } else if (i > paramInt) {
/*  405 */       i = paramInt;
/*      */     } 
/*      */     
/*  408 */     paramInt = 10000;
/*  409 */     if (10000 < i) {
/*  410 */       paramInt = i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  417 */     if ((paramInt = MathUtils.round(paramInt * paramFloat)) > 100000000) {
/*  418 */       paramInt -= paramInt % 10000000;
/*  419 */     } else if (paramInt > 10000000) {
/*  420 */       paramInt -= paramInt % 1000000;
/*  421 */     } else if (paramInt > 1000000) {
/*  422 */       paramInt -= paramInt % 100000;
/*  423 */     } else if (paramInt > 100000) {
/*  424 */       paramInt -= paramInt % 10000;
/*      */     } else {
/*  426 */       paramInt -= paramInt % 1000;
/*      */     } 
/*      */     
/*  429 */     return paramInt;
/*      */   }
/*      */   
/*      */   public int getPapersHourBasePrice() {
/*  433 */     int i = 200000;
/*      */     
/*      */     try {
/*  436 */       i = MathUtils.clamp(i = Integer.parseInt(Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_GREEN_PAPER_MAX_PER_HOUR)), 100000, 5000000);
/*  437 */     } catch (Exception exception) {
/*  438 */       a.e("failed to parse dynamic setting", new Object[] { exception });
/*      */     } 
/*      */ 
/*      */     
/*  442 */     float f = 1.0F + (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.SHOP_PURCHASE_BONUS);
/*      */     
/*  444 */     return getPapersHourBasePrice(i, f);
/*      */   }
/*      */   
/*      */   private void a(Transaction paramTransaction) {
/*  448 */     if (!Game.i.authManager.isSignedIn() || Game.i.authManager.getSessionId() == null)
/*      */       return; 
/*  450 */     double d = (1.0F + (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.SHOP_PURCHASE_BONUS));
/*  451 */     int i = getPapersHourBasePrice();
/*      */     
/*      */     Net.HttpRequest httpRequest;
/*  454 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.IAP_VALIDATION_URL);
/*      */     
/*  456 */     Json json = new Json(JsonWriter.OutputType.json);
/*  457 */     StringWriter stringWriter = new StringWriter();
/*  458 */     json.setWriter(stringWriter);
/*      */     
/*  460 */     String str = paramTransaction.getStoreName() + ";" + ((Game.i.authManager.getSessionId() == null) ? "g" : "u") + ";" + paramTransaction.getOrderId();
/*  461 */     a.i("validating " + str, new Object[0]);
/*      */     
/*  463 */     json.writeObjectStart();
/*  464 */     json.writeValue("identifier", paramTransaction.getIdentifier());
/*  465 */     json.writeValue("purchaseCost", Integer.valueOf(paramTransaction.getPurchaseCost()));
/*  466 */     json.writeValue("storeName", paramTransaction.getStoreName());
/*  467 */     json.writeValue("orderId", paramTransaction.getOrderId());
/*  468 */     json.writeValue("requestId", paramTransaction.getRequestId());
/*  469 */     json.writeValue("userId", paramTransaction.getUserId());
/*  470 */     json.writeValue("purchaseTime", (paramTransaction.getPurchaseTime() == null) ? null : Integer.valueOf((int)(paramTransaction.getPurchaseTime().getTime() / 1000L)));
/*  471 */     json.writeValue("purchaseText", paramTransaction.getPurchaseText());
/*  472 */     json.writeValue("purchaseCostCurrency", paramTransaction.getPurchaseCostCurrency());
/*  473 */     json.writeValue("reversalTime", (paramTransaction.getReversalTime() == null) ? null : Integer.valueOf((int)(paramTransaction.getReversalTime().getTime() / 1000L)));
/*  474 */     json.writeValue("reversalText", paramTransaction.getReversalText());
/*  475 */     json.writeValue("transactionData", paramTransaction.getTransactionData());
/*  476 */     json.writeValue("transactionDataSignature", paramTransaction.getTransactionDataSignature());
/*  477 */     json.writeObjectEnd();
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/*  480 */     (hashMap = new HashMap<>()).put("transaction", stringWriter.toString());
/*  481 */     hashMap.put("purchaseMultiplier", String.valueOf(d));
/*  482 */     hashMap.put("papersPerHour", String.valueOf(i));
/*  483 */     hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*  484 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  486 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, str) {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */             try {
/*  489 */               String str = param1HttpResponse.getResultAsString();
/*  490 */               PurchaseManager.a().i(str, new Object[0]);
/*      */               JsonValue jsonValue;
/*  492 */               if ((jsonValue = (new JsonReader()).parse(str)).getString("status", "error").equals("success")) {
/*      */                 
/*  494 */                 Threads.i().runOnMainThread(() -> {
/*      */                       PurchaseManager.a().i("Log IAP Success: " + param1String1, new Object[0]);
/*      */ 
/*      */                       
/*      */                       (ProgressPrefs.i()).purchase.addValidatedTransaction(param1String2);
/*      */                       
/*      */                       ProgressPrefs.i().requireSave();
/*      */                     });
/*      */               } else {
/*  503 */                 PurchaseManager.a().e("Log IAP Error: " + str, new Object[0]); return;
/*      */               } 
/*  505 */             } catch (Exception exception) {
/*  506 */               PurchaseManager.a().e("Log IAP Exception: " + exception.getMessage(), new Object[] { exception });
/*      */             } 
/*      */           }
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/*  511 */             PurchaseManager.a().e("Log IAP Failed", new Object[] { param1Throwable });
/*      */           }
/*      */           
/*      */           public void cancelled() {
/*  515 */             PurchaseManager.a().e("Log IAP Cancelled", new Object[0]);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public IapOffersConfig getIapOfferConfig() {
/*  521 */     if (this.b != null && Game.getTimestampMillis() - this.c < 60000L)
/*      */     {
/*  523 */       return this.b;
/*      */     }
/*      */     
/*  526 */     IapOffersConfig iapOffersConfig = new IapOffersConfig();
/*      */     try {
/*      */       String str;
/*  529 */       if ((str = Game.i.settingsManager.getDynamicSetting(SettingsManager.DynamicSetting.IAP_OFFERS)) != null && str.length() != 0) {
/*  530 */         iapOffersConfig.readFromJson(str);
/*      */       }
/*  532 */     } catch (Throwable throwable) {
/*  533 */       a.w("failed to load IAP_OFFERS dynamic setting, using default values", new Object[0]);
/*      */     } 
/*  535 */     this.b = iapOffersConfig;
/*  536 */     this.c = Game.getTimestampMillis();
/*      */     
/*  538 */     return iapOffersConfig;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*  543 */     if (this.purchaseManager != null) {
/*  544 */       a.i("Has manager", new Object[0]);
/*      */       
/*      */       PurchaseManagerConfig purchaseManagerConfig;
/*      */       
/*  548 */       (purchaseManagerConfig = new PurchaseManagerConfig()).addOffer((new Offer()).setType(OfferType.ENTITLEMENT).setIdentifier(getPurchaseIdentifier(Config.ProductId.DOUBLE_GAIN)));
/*  549 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.PACK_TINY)));
/*  550 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.PACK_SMALL)));
/*  551 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.PACK_MEDIUM)));
/*  552 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.PACK_LARGE)));
/*  553 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.PACK_HUGE)));
/*  554 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_TINY)));
/*  555 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_MEDIUM)));
/*  556 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_SMALL)));
/*  557 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_LARGE)));
/*  558 */       purchaseManagerConfig.addOffer((new Offer()).setType(OfferType.CONSUMABLE).setIdentifier(getPurchaseIdentifier(Config.ProductId.ACCELERATOR_PACK_HUGE)));
/*      */       
/*  560 */       purchaseManagerConfig.addStoreParam("GooglePlay", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA/U+ICp4sQUINhFRq+JaoetZReLuOOb1m1b5qPlxqeSRhGdu0HruaniHqz/96r81gxS14nCWMsBcV6qHQMj54rgPAAUVwMOY9tnf4ET5ObjwxgSpSsa0219FG9r6SbJyyNNOcR7O+4wefwtLItFwt8ItW3IOasyxyEb4frqK6PLiQNs6hTHtANYULlv4UrvTNoijvhLBGL8N2GO5pNMIwwI7GNp+VecmSG/xKD+4E7kZR1F0ZxSew03Zrz0UiVikk3Lgks4WoEwevwNi44OU/P7oqYFDDoHDh81xf+hK8MQ3ijPa8u3EBARBFYN0mc3Hl9w0lrpiKx19PE5yZ48IoUQIDAQAB");
/*      */ 
/*      */       
/*  563 */       this.purchaseManager.install(new PurchaseObserver(this)
/*      */           {
/*      */             public void handleInstall() {
/*  566 */               PurchaseManager.a().i("handleInstall", new Object[0]);
/*      */             }
/*      */ 
/*      */             
/*      */             public void handleInstallError(Throwable param1Throwable) {
/*  571 */               PurchaseManager.a().i("handleInstallError", new Object[0]);
/*  572 */               param1Throwable.printStackTrace();
/*      */             }
/*      */             
/*      */             public void handleRestore(Transaction[] param1ArrayOfTransaction)
/*      */             {
/*  577 */               PurchaseManager.a().i("handleRestore - " + param1ArrayOfTransaction.length + " transactions", new Object[0]); Transaction[] arrayOfTransaction; int i; byte b;
/*  578 */               for (i = (arrayOfTransaction = param1ArrayOfTransaction).length, b = 0; b < i; ) { Transaction transaction = arrayOfTransaction[b];
/*  579 */                 PurchaseManager.a().i(transaction.getIdentifier(), new Object[0]);
/*      */                 b++; }
/*      */               
/*  582 */               Threads.i().runOnMainThread(() -> {
/*      */                     PurchaseManager.a(this.a).begin(); byte b = 0; int i = (PurchaseManager.a(this.a)).size; while (b < i) {
/*      */                       Transaction[] arrayOfTransaction;
/*      */                       int j = (arrayOfTransaction = param1ArrayOfTransaction).length;
/*      */                       for (byte b1 = 0; b1 < j; b1++) {
/*      */                         Transaction transaction = arrayOfTransaction[b1];
/*      */                         ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).purchased(transaction);
/*      */                       } 
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*      */                     PurchaseManager.a(this.a).begin();
/*      */                     b = 0;
/*      */                     i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).gotResponse("handleRestore", param1ArrayOfTransaction);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*  601 */                   }); } public void handleRestoreError(Throwable param1Throwable) { PurchaseManager.a().e("handleRestoreError", new Object[] { param1Throwable });
/*      */               
/*  603 */               Threads.i().runOnMainThread(() -> {
/*      */                     PurchaseManager.a(this.a).begin();
/*      */                     byte b = 0;
/*      */                     int i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).gotResponse("handleRestoreError", param1Throwable);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*      */                   }); }
/*      */             
/*  614 */             public void handlePurchase(Transaction param1Transaction) { PurchaseManager.a().i("handlePurchase " + param1Transaction.getIdentifier(), new Object[0]);
/*      */               
/*  616 */               Threads.i().runOnMainThread(() -> {
/*      */                     PurchaseManager.a(this.a).begin();
/*      */                     byte b = 0;
/*      */                     int i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).purchased(param1Transaction);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*      */                     PurchaseManager.a(this.a).begin();
/*      */                     b = 0;
/*      */                     i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).gotResponse("handlePurchase", param1Transaction);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*  633 */                   }); } public void handlePurchaseError(Throwable param1Throwable) { PurchaseManager.a().e("handlePurchaseError", new Object[] { param1Throwable });
/*      */               
/*  635 */               Threads.i().runOnMainThread(() -> {
/*      */                     PurchaseManager.a(this.a).begin();
/*      */                     byte b = 0;
/*      */                     int i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).gotResponse("handlePurchaseError", param1Throwable);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*      */                   }); }
/*      */             
/*  646 */             public void handlePurchaseCanceled() { PurchaseManager.a().i("handlePurchaseCanceled", new Object[0]);
/*      */               
/*  648 */               Threads.i().runOnMainThread(() -> {
/*      */                     PurchaseManager.a(this.a).begin(); byte b = 0;
/*      */                     int i = (PurchaseManager.a(this.a)).size;
/*      */                     while (b < i) {
/*      */                       ((PurchaseManager.PurchaseManagerListener)PurchaseManager.a(this.a).get(b)).gotResponse("handlePurchaseCanceled", null);
/*      */                       b++;
/*      */                     } 
/*      */                     PurchaseManager.a(this.a).end();
/*      */                   }); } }purchaseManagerConfig, true);
/*      */     } else {
/*  658 */       a.i("Has no manager :(", new Object[0]);
/*      */     } 
/*      */     
/*  661 */     Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*      */         {
/*      */           public void reloaded() {
/*  664 */             PurchaseManager.b(this.a);
/*      */           }
/*      */         });
/*  667 */     b();
/*      */ 
/*      */     
/*  670 */     addListener(new PurchaseManagerListener(this) { public void purchased(Transaction param1Transaction) {
/*      */             ItemStack itemStack;
/*      */             IssuedItems issuedItems;
/*  673 */             if (Gdx.app.getType() == Application.ApplicationType.Android)
/*      */             {
/*  675 */               if (!param1Transaction.getOrderId().startsWith("GPA.")) {
/*  676 */                 PurchaseManager.a().e("invalid getOrderId: " + param1Transaction.getOrderId(), new Object[0]);
/*      */                 
/*      */                 return;
/*      */               } 
/*      */             }
/*      */             try {
/*  682 */               PurchaseManager.a(this.a, param1Transaction);
/*  683 */             } catch (Exception exception) {
/*  684 */               PurchaseManager.a().e("failed to send IAP for validation", new Object[] { exception });
/*      */             } 
/*      */             
/*  687 */             PurchaseManager.IapOffersConfig iapOffersConfig = this.a.getIapOfferConfig();
/*  688 */             Config.ProductId productId = this.a.getProductId(param1Transaction.getIdentifier());
/*  689 */             switch (PurchaseManager.null.a[productId.ordinal()]) {
/*      */               case 1:
/*  691 */                 if (Game.i.progressManager.hasTemporaryDoubleGain()) {
/*      */                   
/*  693 */                   int j = DoubleGainShardItem.getAcceleratorsForDuration(Game.i.progressManager.getTempDoubleGainDurationLeft());
/*  694 */                   Game.i.progressManager.addItems((Item)Item.D.ACCELERATOR, j, "double_gain_iap_temp_refund");
/*      */                 } 
/*      */                 
/*  697 */                 Game.i.authManager.addProfileStatusLocal("transaction|" + param1Transaction.getStoreName().toLowerCase(Locale.US) + "|" + param1Transaction.getOrderId().toLowerCase(Locale.US), "double_gain", -1);
/*  698 */                 Game.i.progressManager.enableDoubleGainPermanently();
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 2:
/*  705 */                 i = iapOffersConfig.getPurchaseBaseAmount(productId) + iapOffersConfig.getBonusPurchaseAmount(productId);
/*  706 */                 Game.i.progressManager.addGreenPapers(i, "iap_pack_tiny");
/*      */ 
/*      */                 
/*  709 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*      */                 
/*  711 */                 if ((itemStack = iapOffersConfig.getAdditionalItem(productId)) != null) {
/*  712 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  713 */                   Game.i.progressManager.addItemStack(itemStack, "iap_pack_tiny");
/*      */                 } 
/*  715 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  716 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 3:
/*  722 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  723 */                 Game.i.progressManager.addGreenPapers(i, "iap_pack_small");
/*      */ 
/*      */                 
/*  726 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*      */                 
/*  728 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  729 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  730 */                   Game.i.progressManager.addItemStack(itemStack, "iap_pack_small");
/*      */                 } 
/*  732 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  733 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 4:
/*  739 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  740 */                 Game.i.progressManager.addGreenPapers(i, "iap_pack_medium");
/*      */ 
/*      */                 
/*  743 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*      */                 
/*  745 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  746 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  747 */                   Game.i.progressManager.addItemStack(itemStack, "iap_pack_medium");
/*      */                 } 
/*  749 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  750 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 5:
/*  756 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  757 */                 Game.i.progressManager.addGreenPapers(i, "iap_pack_large");
/*      */ 
/*      */                 
/*  760 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*      */                 
/*  762 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  763 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  764 */                   Game.i.progressManager.addItemStack(itemStack, "iap_pack_large");
/*      */                 } 
/*  766 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  767 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 6:
/*  773 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  774 */                 Game.i.progressManager.addGreenPapers(i, "iap_pack_huge");
/*      */ 
/*      */                 
/*  777 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.GREEN_PAPER, i));
/*      */                 
/*  779 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  780 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  781 */                   Game.i.progressManager.addItemStack(itemStack, "iap_pack_huge");
/*      */                 } 
/*  783 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  784 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 7:
/*  790 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  791 */                 Game.i.progressManager.addAccelerators(i, "iap_acc_tiny");
/*      */ 
/*      */                 
/*  794 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*      */                 
/*  796 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  797 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  798 */                   Game.i.progressManager.addItemStack(itemStack, "iap_acc_tiny");
/*      */                 } 
/*  800 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  801 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 8:
/*  807 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  808 */                 Game.i.progressManager.addAccelerators(i, "iap_acc_small");
/*      */ 
/*      */                 
/*  811 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*      */                 
/*  813 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  814 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  815 */                   Game.i.progressManager.addItemStack(itemStack, "iap_acc_small");
/*      */                 } 
/*  817 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  818 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 9:
/*  824 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  825 */                 Game.i.progressManager.addAccelerators(i, "iap_acc_medium");
/*      */ 
/*      */                 
/*  828 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*      */                 
/*  830 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  831 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  832 */                   Game.i.progressManager.addItemStack(itemStack, "iap_acc_medium");
/*      */                 } 
/*  834 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  835 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 10:
/*  841 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  842 */                 Game.i.progressManager.addAccelerators(i, "iap_acc_large");
/*      */ 
/*      */                 
/*  845 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*      */                 
/*  847 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  848 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  849 */                   Game.i.progressManager.addItemStack(itemStack, "iap_acc_large");
/*      */                 } 
/*  851 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  852 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */ 
/*      */ 
/*      */               
/*      */               case 11:
/*  858 */                 i = itemStack.getPurchaseBaseAmount(productId) + itemStack.getBonusPurchaseAmount(productId);
/*  859 */                 Game.i.progressManager.addAccelerators(i, "iap_acc_huge");
/*      */ 
/*      */                 
/*  862 */                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.PURCHASE, Game.getTimestampSeconds())).items.add(new ItemStack((Item)Item.D.ACCELERATOR, i));
/*      */                 
/*  864 */                 if ((itemStack = itemStack.getAdditionalItem(productId)) != null) {
/*  865 */                   issuedItems.items.add(new ItemStack(itemStack));
/*  866 */                   Game.i.progressManager.addItemStack(itemStack, "iap_acc_huge");
/*      */                 } 
/*  868 */                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*  869 */                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*      */                 break;
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  875 */             int i = 0;
/*      */             PP_Purchase pP_Purchase;
/*  877 */             Array array = (pP_Purchase = (ProgressPrefs.i()).purchase).getTransactions();
/*  878 */             for (byte b = 0; b < array.size; b++) {
/*      */               Transaction transaction;
/*  880 */               if ((transaction = (Transaction)array.get(b)).getStoreName().equals(param1Transaction.getStoreName()) && transaction.getOrderId().equals(param1Transaction.getOrderId())) {
/*  881 */                 i = 1;
/*  882 */                 PurchaseManager.a().i("skipped storing transaction " + param1Transaction + " - already stored", new Object[0]);
/*      */                 break;
/*      */               } 
/*      */             } 
/*  886 */             if (i == 0) {
/*      */               try {
/*  888 */                 if ("GooglePlay".equals(param1Transaction.getStoreName())) {
/*  889 */                   if (!param1Transaction.getOrderId().startsWith("GPA.")) {
/*  890 */                     PurchaseManager.a().e("invalid GooglePlay order id: %s, account may be banned", new Object[] { param1Transaction.getOrderId() });
/*      */                   } else {
/*  892 */                     PurchaseManager.a().d("GooglePlay order ID looks valid", new Object[0]);
/*      */                   } 
/*      */                 }
/*  895 */               } catch (Exception exception) {}
/*  896 */               pP_Purchase.addTransaction(param1Transaction);
/*  897 */               ProgressPrefs.i().requireSave();
/*      */             } 
/*      */             
/*  900 */             Game.i.analyticsManager.logIAP(productId, param1Transaction);
/*      */           }
/*      */ 
/*      */           
/*      */           public void gotResponse(String param1String, Object param1Object) {
/*  905 */             if (param1String.equals("handlePurchaseError")) {
/*      */               
/*  907 */               PurchaseManager.a().e("handlePurchaseError - trying restore", new Object[0]);
/*  908 */               this.a.purchaseManager.purchaseRestore();
/*      */             } 
/*      */           } }
/*      */       );
/*      */   }
/*      */   
/*      */   public boolean isPurchasesEnabled() {
/*  915 */     return (this.purchaseManager != null && this.purchaseManager.installed());
/*      */   }
/*      */   
/*      */   public void addListener(PurchaseManagerListener paramPurchaseManagerListener) {
/*  919 */     if (paramPurchaseManagerListener == null) {
/*  920 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  923 */     if (!this.d.contains(paramPurchaseManagerListener, true)) {
/*  924 */       this.d.add(paramPurchaseManagerListener);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeListener(PurchaseManagerListener paramPurchaseManagerListener) {
/*  929 */     if (paramPurchaseManagerListener == null) {
/*  930 */       throw new IllegalArgumentException("listener is null");
/*      */     }
/*      */     
/*  933 */     this.d.removeValue(paramPurchaseManagerListener, true);
/*      */   }
/*      */   
/*      */   public static final class RewardingAdConfig {
/*      */     public int periodLength;
/*      */     public int maxViewsPerPeriod;
/*      */     public int minViewDelay;
/*      */     
/*      */     public RewardingAdConfig(int param1Int1, int param1Int2, int param1Int3) {
/*  942 */       if (param1Int2 <= 0) throw new IllegalArgumentException("maxViewsPerPeriod must be > 0: " + param1Int2);
/*      */       
/*  944 */       this.periodLength = param1Int1;
/*  945 */       this.maxViewsPerPeriod = param1Int2;
/*  946 */       this.minViewDelay = param1Int3;
/*      */     } }
/*      */   public static interface PurchaseManagerListener { void purchased(Transaction param1Transaction);
/*      */     void gotResponse(String param1String, Object param1Object);
/*      */     public static abstract class PurchaseManagerListenerAdapter implements PurchaseManagerListener {
/*      */       public void purchased(Transaction param2Transaction) {}
/*      */       public void gotResponse(String param2String, Object param2Object) {}
/*      */     } }
/*      */   public static final class IapOffersConfig { public float paperTinyAmount; public float paperSmallAmount; public float paperMediumAmount; public float paperLargeAmount; public float paperHugeAmount;
/*      */     public int paperTinyBonus;
/*      */     public int paperSmallBonus;
/*      */     public int paperMediumBonus;
/*      */     public int paperLargeBonus;
/*      */     public int paperHugeBonus;
/*      */     public int accTinyAmount;
/*      */     public int accSmallAmount;
/*      */     public int accMediumAmount;
/*      */     public int accLargeAmount;
/*      */     public int accHugeAmount;
/*      */     
/*      */     public IapOffersConfig() {
/*  967 */       this.paperTinyAmount = 1.0F;
/*  968 */       this.paperSmallAmount = 3.0F;
/*  969 */       this.paperMediumAmount = 10.0F;
/*  970 */       this.paperLargeAmount = 25.0F;
/*  971 */       this.paperHugeAmount = 50.0F;
/*  972 */       this.paperTinyBonus = 0;
/*  973 */       this.paperSmallBonus = 15;
/*  974 */       this.paperMediumBonus = 35;
/*  975 */       this.paperLargeBonus = 50;
/*  976 */       this.paperHugeBonus = 100;
/*  977 */       this.accTinyAmount = 100;
/*  978 */       this.accSmallAmount = 300;
/*  979 */       this.accMediumAmount = 1000;
/*  980 */       this.accLargeAmount = 2500;
/*  981 */       this.accHugeAmount = 5000;
/*  982 */       this.accTinyBonus = 0;
/*  983 */       this.accSmallBonus = 15;
/*  984 */       this.accMediumBonus = 35;
/*  985 */       this.accLargeBonus = 50;
/*  986 */       this.accHugeBonus = 100;
/*  987 */       this.paperTinyItem = null;
/*  988 */       this.paperSmallItem = new ItemStack((Item)Item.D.RARITY_BOOST, 1);
/*  989 */       this.paperMediumItem = new ItemStack((Item)Item.D.RARITY_BOOST, 3);
/*  990 */       this.paperLargeItem = new ItemStack((Item)Item.D.RARITY_BOOST, 10);
/*  991 */       this.paperHugeItem = new ItemStack((Item)Item.D.RARITY_BOOST, 25);
/*  992 */       this.accTinyItem = null;
/*  993 */       this.accSmallItem = null;
/*  994 */       this.accMediumItem = null;
/*  995 */       this.accLargeItem = null;
/*  996 */       this.accHugeItem = null;
/*      */     } public int accTinyBonus; public int accSmallBonus; public int accMediumBonus; public int accLargeBonus; public int accHugeBonus; public ItemStack paperTinyItem; public ItemStack paperSmallItem; public ItemStack paperMediumItem; public ItemStack paperLargeItem; public ItemStack paperHugeItem; public ItemStack accTinyItem; public ItemStack accSmallItem; public ItemStack accMediumItem; public ItemStack accLargeItem; public ItemStack accHugeItem;
/*      */     public final void readFromJson(String param1String) {
/*      */       try {
/* 1000 */         JsonValue jsonValue = (new JsonReader()).parse(param1String);
/* 1001 */         this.paperTinyAmount = jsonValue.getFloat("paperTinyAmount", this.paperTinyAmount);
/* 1002 */         this.paperSmallAmount = jsonValue.getFloat("paperSmallAmount", this.paperSmallAmount);
/* 1003 */         this.paperMediumAmount = jsonValue.getFloat("paperMediumAmount", this.paperMediumAmount);
/* 1004 */         this.paperLargeAmount = jsonValue.getFloat("paperLargeAmount", this.paperLargeAmount);
/* 1005 */         this.paperHugeAmount = jsonValue.getFloat("paperHugeAmount", this.paperHugeAmount);
/* 1006 */         this.paperTinyBonus = jsonValue.getInt("paperTinyBonus", this.paperTinyBonus);
/* 1007 */         this.paperSmallBonus = jsonValue.getInt("paperSmallBonus", this.paperSmallBonus);
/* 1008 */         this.paperMediumBonus = jsonValue.getInt("paperMediumBonus", this.paperMediumBonus);
/* 1009 */         this.paperLargeBonus = jsonValue.getInt("paperLargeBonus", this.paperLargeBonus);
/* 1010 */         this.paperHugeBonus = jsonValue.getInt("paperHugeBonus", this.paperHugeBonus);
/* 1011 */         this.accTinyAmount = jsonValue.getInt("accTinyAmount", this.accTinyAmount);
/* 1012 */         this.accSmallAmount = jsonValue.getInt("accSmallAmount", this.accSmallAmount);
/* 1013 */         this.accMediumAmount = jsonValue.getInt("accMediumAmount", this.accMediumAmount);
/* 1014 */         this.accLargeAmount = jsonValue.getInt("accLargeAmount", this.accLargeAmount);
/* 1015 */         this.accHugeAmount = jsonValue.getInt("accHugeAmount", this.accHugeAmount);
/* 1016 */         this.accTinyBonus = jsonValue.getInt("accTinyBonus", this.accTinyBonus);
/* 1017 */         this.accSmallBonus = jsonValue.getInt("accSmallBonus", this.accSmallBonus);
/* 1018 */         this.accMediumBonus = jsonValue.getInt("accMediumBonus", this.accMediumBonus);
/* 1019 */         this.accLargeBonus = jsonValue.getInt("accLargeBonus", this.accLargeBonus);
/* 1020 */         this.accHugeBonus = jsonValue.getInt("accHugeBonus", this.accHugeBonus);
/* 1021 */         if (jsonValue.get("paperTinyItem") != null) {
/* 1022 */           this.paperTinyItem = ItemStack.fromJsonOrNull(jsonValue.get("paperTinyItem"));
/*      */         }
/* 1024 */         if (jsonValue.get("paperSmallItem") != null) {
/* 1025 */           this.paperSmallItem = ItemStack.fromJsonOrNull(jsonValue.get("paperSmallItem"));
/*      */         }
/* 1027 */         if (jsonValue.get("paperMediumItem") != null) {
/* 1028 */           this.paperMediumItem = ItemStack.fromJsonOrNull(jsonValue.get("paperMediumItem"));
/*      */         }
/* 1030 */         if (jsonValue.get("paperLargeItem") != null) {
/* 1031 */           this.paperLargeItem = ItemStack.fromJsonOrNull(jsonValue.get("paperLargeItem"));
/*      */         }
/* 1033 */         if (jsonValue.get("paperHugeItem") != null) {
/* 1034 */           this.paperHugeItem = ItemStack.fromJsonOrNull(jsonValue.get("paperHugeItem"));
/*      */         }
/* 1036 */         if (jsonValue.get("accTinyItem") != null) {
/* 1037 */           this.accTinyItem = ItemStack.fromJsonOrNull(jsonValue.get("accTinyItem"));
/*      */         }
/* 1039 */         if (jsonValue.get("accSmallItem") != null) {
/* 1040 */           this.accSmallItem = ItemStack.fromJsonOrNull(jsonValue.get("accSmallItem"));
/*      */         }
/* 1042 */         if (jsonValue.get("accMediumItem") != null) {
/* 1043 */           this.accMediumItem = ItemStack.fromJsonOrNull(jsonValue.get("accMediumItem"));
/*      */         }
/* 1045 */         if (jsonValue.get("accLargeItem") != null) {
/* 1046 */           this.accLargeItem = ItemStack.fromJsonOrNull(jsonValue.get("accLargeItem"));
/*      */         }
/* 1048 */         if (jsonValue.get("accHugeItem") != null)
/* 1049 */           this.accHugeItem = ItemStack.fromJsonOrNull(jsonValue.get("accHugeItem")); 
/*      */         return;
/* 1051 */       } catch (Exception exception) {
/* 1052 */         PurchaseManager.a().e("failed to parse IapOffersConfig json, using default values", new Object[] { exception });
/*      */         return;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final int getPurchaseBonus(Config.ProductId param1ProductId) {
/* 1060 */       switch (PurchaseManager.null.a[param1ProductId.ordinal()]) {
/*      */         
/*      */         case 2:
/* 1063 */           return this.paperTinyBonus;
/*      */         
/*      */         case 3:
/* 1066 */           return this.paperSmallBonus;
/*      */         
/*      */         case 4:
/* 1069 */           return this.paperMediumBonus;
/*      */         
/*      */         case 5:
/* 1072 */           return this.paperLargeBonus;
/*      */         
/*      */         case 6:
/* 1075 */           return this.paperHugeBonus;
/*      */ 
/*      */         
/*      */         case 7:
/* 1079 */           return this.accTinyBonus;
/*      */         
/*      */         case 8:
/* 1082 */           return this.accSmallBonus;
/*      */         
/*      */         case 9:
/* 1085 */           return this.accMediumBonus;
/*      */         
/*      */         case 10:
/* 1088 */           return this.accLargeBonus;
/*      */         
/*      */         case 11:
/* 1091 */           return this.accHugeBonus;
/*      */       } 
/*      */       
/* 1094 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final int getPurchaseBaseAmount(Config.ProductId param1ProductId) {
/* 1100 */       int i = Game.i.purchaseManager.getPapersHourBasePrice();
/* 1101 */       switch (PurchaseManager.null.a[param1ProductId.ordinal()]) {
/*      */         
/*      */         case 2:
/* 1104 */           return MathUtils.round(i * this.paperTinyAmount);
/*      */         
/*      */         case 3:
/* 1107 */           return MathUtils.round(i * this.paperSmallAmount);
/*      */         
/*      */         case 4:
/* 1110 */           return MathUtils.round(i * this.paperMediumAmount);
/*      */         
/*      */         case 5:
/* 1113 */           return MathUtils.round(i * this.paperLargeAmount);
/*      */         
/*      */         case 6:
/* 1116 */           return MathUtils.round(i * this.paperHugeAmount);
/*      */ 
/*      */         
/*      */         case 7:
/* 1120 */           return this.accTinyAmount;
/*      */         
/*      */         case 8:
/* 1123 */           return this.accSmallAmount;
/*      */         
/*      */         case 9:
/* 1126 */           return this.accMediumAmount;
/*      */         
/*      */         case 10:
/* 1129 */           return this.accLargeAmount;
/*      */         
/*      */         case 11:
/* 1132 */           return this.accHugeAmount;
/*      */       } 
/*      */       
/* 1135 */       throw new IllegalArgumentException("Invalid product id: " + param1ProductId);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int getBonusPurchaseAmount(Config.ProductId param1ProductId) {
/* 1144 */       int j = getPurchaseBaseAmount(param1ProductId);
/* 1145 */       int i = getPurchaseBonus(param1ProductId);
/* 1146 */       return MathUtils.round(j * i * 0.01F);
/*      */     }
/*      */     @Null
/*      */     public final ItemStack getAdditionalItem(Config.ProductId param1ProductId) {
/* 1150 */       switch (PurchaseManager.null.a[param1ProductId.ordinal()]) { case 2:
/* 1151 */           return this.paperTinyItem;
/* 1152 */         case 3: return this.paperSmallItem;
/* 1153 */         case 4: return this.paperMediumItem;
/* 1154 */         case 5: return this.paperLargeItem;
/* 1155 */         case 6: return this.paperHugeItem;
/* 1156 */         case 7: return this.accTinyItem;
/* 1157 */         case 8: return this.accSmallItem;
/* 1158 */         case 9: return this.accMediumItem;
/* 1159 */         case 10: return this.accLargeItem;
/* 1160 */         case 11: return this.accHugeItem; }
/* 1161 */        return null;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\PurchaseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */