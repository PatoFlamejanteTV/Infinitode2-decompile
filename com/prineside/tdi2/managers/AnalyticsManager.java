/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.pay.Transaction;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = AnalyticsManager.Serializer.class)
/*     */ public final class AnalyticsManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*     */   public static final boolean TIME_SERIES_DB_ENABLED = false;
/*     */   public static final int MAX_QUEUE_SIZE = 500;
/*     */   public static final int HEARTBEAT_INTERVAL = 50;
/*     */   public static final int FLUSH_INTERVAL = 60;
/*     */   public static final int FLUSH_CHECK_INTERVAL = 10;
/*     */   private final boolean a;
/*     */   private int b;
/*     */   
/*     */   static {
/*  28 */     TLog.forClass(AnalyticsManager.class);
/*     */   }
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<AnalyticsManager> {
/*     */     public AnalyticsManager read() {
/*  33 */       return Game.i.analyticsManager;
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
/*     */   
/*     */   public AnalyticsManager() {
/*  49 */     Game.getTimestampSeconds();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     this.a = (!Game.i.actionResolver.isAppModified() && !Config.isHeadless());
/*  57 */     FastRandom.getLongUUID();
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
/*     */   public final void setup() {
/*     */     Event event;
/* 140 */     Event.a(event = new Event("game_start", (byte)0), "os", Gdx.app.getType().name());
/* 141 */     Event.a(event, "locale", Game.i.actionResolver.getDefaultLocale());
/* 142 */     Event.a(event, "osv", Gdx.app.getVersion());
/* 143 */     Event.a(event, "loading_time", Long.valueOf(Game.getRealTickCount()));
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
/*     */   public final void logLevelStarted(String paramString1, String paramString2) {
/* 275 */     if (!this.a)
/*     */       return;  Event event;
/* 277 */     Event.a(event = new Event("levelStarted", (byte)0), "type", paramString1);
/* 278 */     Event.a(event, "levelName", paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logLevelFinished(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 283 */     if (!this.a)
/*     */       return;  Event event;
/* 285 */     Event.a(event = new Event("levelFinished", (byte)0), "type", paramString1);
/* 286 */     Event.a(event, "levelName", paramString2);
/* 287 */     Event.a(event, "realTime", Integer.valueOf(paramInt1));
/* 288 */     Event.a(event, "inGameTime", Integer.valueOf(paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void logCurrencyReceived(String paramString1, String paramString2, int paramInt) {
/* 294 */     if (!this.a)
/*     */       return;  Event event;
/* 296 */     Event.a(event = new Event("currencyReceived", (byte)0), "currencyName", paramString1);
/* 297 */     Event.a(event, "source", paramString2);
/* 298 */     Event.a(event, "amount", Integer.valueOf(paramInt));
/*     */ 
/*     */     
/* 301 */     Game.i.actionResolver.logCurrencyReceived(paramString1, paramString2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logCurrencySpent(String paramString1, String paramString2, int paramInt) {
/* 306 */     if (!this.a)
/*     */       return;  Event event;
/* 308 */     Event.a(event = new Event("currencySpent", (byte)0), "onItem", paramString1);
/* 309 */     Event.a(event, "currencyName", paramString2);
/* 310 */     Event.a(event, "amount", Integer.valueOf(paramInt));
/*     */ 
/*     */     
/* 313 */     Game.i.actionResolver.logCurrencySpent(paramString1, paramString2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logShopOfferPurchased(String paramString1, int paramInt1, String paramString2, int paramInt2) {
/* 318 */     if (!this.a)
/* 319 */       return;  Game.i.actionResolver.logShopOfferPurchased(paramString1, paramInt1, paramString2, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logSignedIn(String paramString) {
/* 324 */     if (!this.a)
/*     */       return;  Event event;
/* 326 */     Event.a(event = new Event("signedIn", (byte)0), "method", paramString);
/*     */     
/* 328 */     Game.i.actionResolver.logLogined(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logSignedUp(String paramString) {
/* 333 */     if (!this.a)
/*     */       return;  Event event;
/* 335 */     Event.a(event = new Event("signedUp", (byte)0), "method", paramString);
/*     */     
/* 337 */     Game.i.actionResolver.logSignedUp(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logCustomEvent(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject) {
/* 342 */     if (!this.a)
/* 343 */       return;  Event event = new Event(paramString, (byte)0); byte b;
/* 344 */     for (b = 0; b < paramArrayOfString.length; b += 2) {
/* 345 */       Event.a(event, paramArrayOfString[b], paramArrayOfString[b + 1]);
/*     */     }
/* 347 */     for (b = 0; b < paramArrayOfObject.length; b += 2) {
/* 348 */       Event.a(event, (String)paramArrayOfObject[b], paramArrayOfObject[b + 1]);
/*     */     }
/*     */ 
/*     */     
/* 352 */     Game.i.actionResolver.logCustomEvent(paramString, paramArrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logIAP(Config.ProductId paramProductId, Transaction paramTransaction) {
/* 357 */     if (!this.a)
/*     */       return;  Event event;
/* 359 */     Event.a(event = new Event("iap", (byte)0), "product", paramProductId.name());
/* 360 */     Event.a(event, "order", paramTransaction.getOrderId());
/*     */     
/* 362 */     Game.i.actionResolver.logIAP(paramProductId, paramTransaction);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void logRewardedVideoViewed(PurchaseManager.RewardingAdsType paramRewardingAdsType) {
/* 367 */     if (!this.a)
/*     */       return;  Event event;
/* 369 */     Event.a(event = new Event("videoWatched", (byte)0), "type", paramRewardingAdsType.name());
/* 370 */     Event.a(event, "c", Integer.valueOf(1));
/*     */     
/* 372 */     Game.i.actionResolver.logRewardedVideoViewed(paramRewardingAdsType);
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
/*     */   public final void preRender(float paramFloat) {
/* 385 */     if (!this.a)
/*     */       return; 
/* 387 */     if (Game.getTimestampSeconds() - this.b >= 50) {
/*     */       Event event;
/* 389 */       Event.a(event = new Event("player_online", (byte)0), "screen", Game.i.screenManager.getCurrentScreen().getClass().getSimpleName());
/*     */       
/* 391 */       this.b = Game.getTimestampSeconds();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class Event
/*     */   {
/* 397 */     private final Array<Object> a = new Array(true, 2);
/* 398 */     private final Array<String> b = new Array(true, 2, String.class);
/*     */ 
/*     */     
/*     */     private Event(String param1String) {
/* 402 */       if (param1String.startsWith("_")) {
/* 403 */         throw new IllegalArgumentException("measurement name can not start with _");
/*     */       }
/*     */ 
/*     */       
/* 407 */       Game.getTimestampSeconds();
/*     */     }
/*     */     
/*     */     private void a(String param1String1, String param1String2) {
/* 411 */       if (param1String1.startsWith("_")) {
/* 412 */         throw new IllegalArgumentException("key can not start with _");
/*     */       }
/* 414 */       if (param1String2 == null)
/*     */         return; 
/* 416 */       param1String1 = param1String1.replaceAll(" ", "").replaceAll("\n", "");
/* 417 */       param1String2 = param1String2.replaceAll("\n", " ").replaceAll("'", "").replaceAll("\"", "");
/*     */       
/* 419 */       this.b.add(param1String1);
/* 420 */       this.b.add(param1String2);
/*     */     }
/*     */     
/*     */     private void a(String param1String, Object param1Object) {
/* 424 */       if (param1String.startsWith("_")) {
/* 425 */         throw new IllegalArgumentException("key can not start with _");
/*     */       }
/* 427 */       if (param1Object == null)
/*     */         return; 
/* 429 */       param1String = param1String.replaceAll(" ", "").replaceAll("\n", "");
/* 430 */       if (param1Object instanceof String) {
/* 431 */         param1Object = ((String)param1Object).replaceAll("\n", " ").replaceAll("'", "").replaceAll("\"", "");
/*     */       }
/*     */       
/* 434 */       this.a.add(param1String);
/* 435 */       this.a.add(param1Object);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\AnalyticsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */