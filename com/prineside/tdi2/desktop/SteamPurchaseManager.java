/*     */ package com.prineside.tdi2.desktop;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.pay.Information;
/*     */ import com.badlogic.gdx.pay.InvalidItemException;
/*     */ import com.badlogic.gdx.pay.PurchaseManager;
/*     */ import com.badlogic.gdx.pay.PurchaseManagerConfig;
/*     */ import com.badlogic.gdx.pay.PurchaseObserver;
/*     */ import com.badlogic.gdx.pay.Transaction;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.codedisaster.steamworks.SteamID;
/*     */ import com.codedisaster.steamworks.SteamNativeHandle;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ public class SteamPurchaseManager implements PurchaseManager {
/*  26 */   private static final TLog a = TLog.forClass(SteamPurchaseManager.class);
/*     */   
/*     */   private PurchaseObserver b;
/*     */   
/*     */   private boolean c;
/*     */   
/*  32 */   private final Map<String, SteamProductInfo> d = new ConcurrentHashMap<>();
/*     */   
/*     */   public SteamPurchaseManager() {
/*  35 */     a.i("construct", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public String storeName() {
/*  40 */     return "Steam";
/*     */   }
/*     */ 
/*     */   
/*     */   public void install(PurchaseObserver paramPurchaseObserver, PurchaseManagerConfig paramPurchaseManagerConfig, boolean paramBoolean) {
/*  45 */     a.i("install", new Object[0]);
/*  46 */     this.b = paramPurchaseObserver;
/*     */ 
/*     */     
/*  49 */     this.c = false;
/*  50 */     Game.i.authManager.addListener(new AuthManager.AuthManagerListener.AuthManagerListenerAdapter(this)
/*     */         {
/*     */           public void signInStatusUpdated() {
/*  53 */             Gdx.app.postRunnable(() -> SteamPurchaseManager.a(this.a));
/*     */           }
/*     */ 
/*     */           
/*     */           public void stateUpdated() {
/*  58 */             Gdx.app.postRunnable(() -> SteamPurchaseManager.a(this.a));
/*     */           }
/*     */         });
/*  61 */     c();
/*     */   }
/*     */   
/*     */   public void onMicroTxnAuthorization(int paramInt, long paramLong, boolean paramBoolean) {
/*  65 */     if (!paramBoolean) {
/*     */       
/*  67 */       Gdx.app.postRunnable(() -> this.b.handlePurchaseCanceled());
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     Net.HttpRequest httpRequest;
/*     */     
/*  75 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.STEAM_TXN_FINALIZE_URL);
/*     */     
/*     */     HashMap<Object, Object> hashMap;
/*  78 */     (hashMap = new HashMap<>()).put("orderID", paramLong);
/*  79 */     hashMap.put("locale", Game.i.localeManager.getLocale());
/*  80 */     hashMap.put("steamLanguage", DesktopLauncher.steamApps.getCurrentGameLanguage());
/*  81 */     hashMap.put("steamAccountID", SteamID.getNativeHandle((SteamNativeHandle)DesktopLauncher.steamUser.getSteamID()));
/*  82 */     hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*  83 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */     
/*  85 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */         {
/*     */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*  88 */             String str = param1HttpResponse.getResultAsString();
/*  89 */             SteamPurchaseManager.a().i("Finalize transaction response:", new Object[0]);
/*  90 */             SteamPurchaseManager.a().i(str, new Object[0]);
/*     */             
/*     */             try {
/*  93 */               JsonValue jsonValue = (new JsonReader()).parse(str);
/*  94 */               if ("success".equals(jsonValue.getString("status"))) {
/*     */                 Transaction transaction;
/*  96 */                 (transaction = new Transaction()).setStoreName(this.a.storeName());
/*  97 */                 transaction.setIdentifier(jsonValue.get("order").getString("product_type"));
/*  98 */                 transaction.setOrderId(jsonValue.get("order").getString("id"));
/*  99 */                 transaction.setPurchaseCost(jsonValue.get("order").getInt("price", 0));
/* 100 */                 transaction.setPurchaseTime(new Date(jsonValue.get("order").getInt("created_at", (int)((new Date()).getTime() / 1000L)) * 1000L));
/* 101 */                 transaction.setPurchaseCostCurrency(jsonValue.get("order").getString("currency", "USD"));
/* 102 */                 transaction.setPurchaseText(jsonValue.get("order").getString("description", ""));
/* 103 */                 Gdx.app.postRunnable(() -> SteamPurchaseManager.b(this.a).handlePurchase(param1Transaction));
/*     */               }
/*     */               else {
/*     */                 
/* 107 */                 SteamPurchaseManager.a().e("not successful request for purchase finalize: " + str, new Object[0]);
/* 108 */                 Gdx.app.postRunnable(() -> SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Can't finalize purchase: " + param1JsonValue.getString("message"))));
/*     */                 
/*     */                 return;
/*     */               } 
/* 112 */             } catch (Exception exception) {
/* 113 */               SteamPurchaseManager.a().e("failed to parse purchase finalization response: " + str, new Object[] { exception });
/* 114 */               Gdx.app.postRunnable(() -> SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Failed to parse response: " + param1String, param1Exception)));
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void failed(Throwable param1Throwable) {
/* 122 */             SteamPurchaseManager.a().e("failed to send finalization request", new Object[] { param1Throwable });
/* 123 */             Gdx.app.postRunnable(() -> SteamPurchaseManager.b(this.a).handlePurchaseError(param1Throwable));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void cancelled() {
/* 130 */             SteamPurchaseManager.a().e("cancelled finalization request", new Object[0]);
/* 131 */             Gdx.app.postRunnable(() -> SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Finalization request cancelled")));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 139 */     this.c = false;
/* 140 */     this.d.clear();
/*     */   }
/*     */   
/*     */   private void c() {
/* 144 */     Gdx.app.postRunnable(() -> {
/*     */           if (!Game.i.authManager.isSignedIn() || Game.i.authManager.getSessionId() == null) {
/*     */             b();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           if (Game.i.authManager.getSteamAccountId() == null) {
/*     */             b();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           Net.HttpRequest httpRequest;
/*     */           
/*     */           (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.STEAM_TXN_PRODUCT_LIST_URL);
/*     */           
/*     */           HashMap<Object, Object> hashMap;
/*     */           
/*     */           (hashMap = new HashMap<>()).put("locale", Game.i.localeManager.getLocale());
/*     */           
/*     */           hashMap.put("steamLanguage", DesktopLauncher.steamApps.getCurrentGameLanguage());
/*     */           
/*     */           hashMap.put("steamAccountID", SteamID.getNativeHandle((SteamNativeHandle)DesktopLauncher.steamUser.getSteamID()));
/*     */           hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*     */           httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */           Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */               {
/*     */                 public void handleHttpResponse(Net.HttpResponse param1HttpResponse)
/*     */                 {
/* 174 */                   String str = param1HttpResponse.getResultAsString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 180 */                   SteamPurchaseManager.c(this.a).clear();
/*     */                   try {
/* 182 */                     JsonValue jsonValue = (new JsonReader()).parse(str);
/* 183 */                     if ("success".equals(jsonValue.getString("status"))) {
/* 184 */                       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.get("products").iterator(); jsonIterator.hasNext(); ) {
/* 185 */                         JsonValue jsonValue1; String str1 = (jsonValue1 = jsonIterator.next()).getString("gameProductId");
/*     */ 
/*     */                         
/* 188 */                         SteamPurchaseManager.SteamProductInfo steamProductInfo = new SteamPurchaseManager.SteamProductInfo(jsonValue1.getInt("id"), jsonValue1.getString("localPricing"));
/*     */                         
/* 190 */                         SteamPurchaseManager.c(this.a).put(str1, steamProductInfo);
/*     */                       } 
/*     */                       
/* 193 */                       SteamPurchaseManager.d(this.a);
/*     */                     } else {
/* 195 */                       SteamPurchaseManager.a().e("not successful request for product list: " + str, new Object[0]);
/* 196 */                       SteamPurchaseManager.e(this.a);
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/*     */                       return;
/*     */                     } 
/* 203 */                   } catch (Exception exception) {
/* 204 */                     SteamPurchaseManager.a().e("failed to retrieve product list: " + str, new Object[] { exception });
/* 205 */                     SteamPurchaseManager.e(this.a);
/*     */                   } 
/*     */                 }
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
/*     */                 public void failed(Throwable param1Throwable) {
/* 225 */                   SteamPurchaseManager.a().e("request product list failed", new Object[] { param1Throwable });
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void cancelled() {
/* 230 */                   SteamPurchaseManager.a().e("request product list cancelled", new Object[0]);
/*     */                 }
/*     */               });
/*     */         });
/*     */   }
/*     */   
/*     */   private void d() {
/* 237 */     if (!this.c) {
/* 238 */       this.c = true;
/* 239 */       this.b.handleInstall();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean installed() {
/* 245 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 250 */     if (this.b != null) {
/*     */       
/* 252 */       this.b = null;
/*     */       
/* 254 */       Gdx.app.debug("SteamPurchaseManager", "disposed observer and config");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.c = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void purchase(String paramString) {
/*     */     SteamProductInfo steamProductInfo;
/* 266 */     if ((steamProductInfo = this.d.get(paramString)) == null) {
/* 267 */       this.b.handlePurchaseError((Throwable)new InvalidItemException(paramString));
/*     */       return;
/*     */     } 
/*     */     Net.HttpRequest httpRequest;
/* 271 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.STEAM_TXN_START_URL);
/*     */     
/*     */     HashMap<Object, Object> hashMap;
/* 274 */     (hashMap = new HashMap<>()).put("locale", Game.i.localeManager.getLocale());
/* 275 */     hashMap.put("productIdentifier", paramString);
/* 276 */     hashMap.put("dbId", steamProductInfo.productId);
/* 277 */     hashMap.put("steamLanguage", DesktopLauncher.steamApps.getCurrentGameLanguage());
/* 278 */     hashMap.put("steamAccountID", SteamID.getNativeHandle((SteamNativeHandle)DesktopLauncher.steamUser.getSteamID()));
/* 279 */     hashMap.put("sessionid", Game.i.authManager.getSessionId());
/* 280 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*     */     
/* 282 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*     */         {
/*     */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 285 */             String str = param1HttpResponse.getResultAsString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 292 */               JsonValue jsonValue = (new JsonReader()).parse(str);
/* 293 */               if (!"success".equals(jsonValue.getString("status"))) {
/*     */ 
/*     */                 
/* 296 */                 SteamPurchaseManager.a().e("not successful request for purchase start: " + str, new Object[0]);
/* 297 */                 SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Can't start purchase: " + jsonValue.getString("message")));
/*     */               }  return;
/* 299 */             } catch (Exception exception) {
/* 300 */               SteamPurchaseManager.a().e("failed to parse purchase start response: " + str, new Object[] { exception });
/* 301 */               SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Failed to parse response: " + str, exception));
/*     */               return;
/*     */             } 
/*     */           }
/*     */           
/*     */           public void failed(Throwable param1Throwable) {
/* 307 */             SteamPurchaseManager.a().e("purchase start failed", new Object[] { param1Throwable });
/* 308 */             SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Request failed", param1Throwable));
/*     */           }
/*     */ 
/*     */           
/*     */           public void cancelled() {
/* 313 */             SteamPurchaseManager.a().e("purchase start cancelled", new Object[0]);
/* 314 */             SteamPurchaseManager.b(this.a).handlePurchaseError(new RuntimeException("Request cancelled"));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void purchaseRestore() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Information getInformation(String paramString) {
/*     */     SteamProductInfo steamProductInfo;
/* 328 */     return ((steamProductInfo = this.d.get(paramString)) == null) ? Information.UNAVAILABLE : steamProductInfo.information;
/*     */   }
/*     */   
/*     */   public static final class SteamProductInfo {
/*     */     public Information information;
/*     */     public int productId;
/*     */     
/*     */     public SteamProductInfo(int param1Int, String param1String) {
/* 336 */       this.information = new Information("", "", param1String);
/* 337 */       this.productId = param1Int;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\SteamPurchaseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */