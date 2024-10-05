/*     */ package com.badlogic.gdx.pay;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ public class PurchaseManagerConfig
/*     */ {
/*     */   public static final String STORE_NAME_ANDROID_GOOGLE = "GooglePlay";
/*     */   public static final String STORE_NAME_ANDROID_AMAZON = "Amazon";
/*     */   public static final String STORE_NAME_ANDROID_HUAWEI = "Huawei";
/*     */   public static final String STORE_NAME_ANDROID_SAMSUNG = "Samsung";
/*     */   public static final String STORE_NAME_ANDROID_NOKIA = "Nokia";
/*     */   public static final String STORE_NAME_ANDROID_SLIDEME = "SlideME";
/*     */   public static final String STORE_NAME_ANDROID_APTOIDE = "Aptoide";
/*     */   public static final String STORE_NAME_ANDROID_APPLAND = "Appland";
/*     */   public static final String STORE_NAME_ANDROID_YANDEX = "Yandex";
/*     */   public static final String STORE_NAME_IOS_APPLE = "AppleiOS";
/*     */   public static final String STORE_NAME_DESKTOP_APPLE = "AppleMac";
/*     */   public static final String STORE_NAME_DESKTOP_STEAM = "Steam";
/*     */   public static final String STORE_NAME_DESKTOP_WINDOWS = "Windows";
/*     */   public static final String STORE_NAME_GWT_GOOGLEWALLET = "GwtGoogleWallet";
/*  53 */   private List<Offer> offers = new ArrayList<>(16);
/*  54 */   private Map<String, Object> storeParams = new HashMap<>(16);
/*     */ 
/*     */   
/*     */   public synchronized void addOffer(Offer paramOffer) {
/*  58 */     this.offers.add(paramOffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Offer getOffer(String paramString) {
/*  63 */     for (byte b = 0; b < this.offers.size(); b++) {
/*  64 */       if (((Offer)this.offers.get(b)).getIdentifier().equals(paramString)) {
/*  65 */         return this.offers.get(b);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   public synchronized boolean hasAnyOfferWithType(OfferType paramOfferType) {
/*  74 */     for (Iterator<Offer> iterator = this.offers.iterator(); iterator.hasNext();) {
/*  75 */       if ((offer = iterator.next()).getType() == paramOfferType) {
/*  76 */         return true;
/*     */       }
/*     */     } 
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Offer getOfferForStore(String paramString1, String paramString2) {
/*  84 */     for (byte b = 0; b < this.offers.size(); b++) {
/*  85 */       if (((Offer)this.offers.get(b)).getIdentifierForStore(paramString1).equals(paramString2)) {
/*  86 */         return this.offers.get(b);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  91 */     return null;
/*     */   }
/*     */   
/*     */   public synchronized Offer getOffer(int paramInt) {
/*  95 */     return this.offers.get(paramInt);
/*     */   }
/*     */   
/*     */   public synchronized int getOfferCount() {
/*  99 */     return this.offers.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void addStoreParam(String paramString, Object paramObject) {
/* 108 */     this.storeParams.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object getStoreParam(String paramString) {
/* 117 */     return this.storeParams.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\PurchaseManagerConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */