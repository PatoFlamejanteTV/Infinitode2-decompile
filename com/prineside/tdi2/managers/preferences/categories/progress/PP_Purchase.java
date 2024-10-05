/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.pay.Transaction;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.PurchaseManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Date;
/*     */ 
/*     */ public final class PP_Purchase
/*     */   implements PrefSubcategory {
/*  21 */   private static final TLog a = TLog.forClass(PP_Purchase.class);
/*     */   
/*  23 */   private final Array<Transaction> b = new Array();
/*  24 */   private final Array<String> c = new Array(false, 8, String.class);
/*  25 */   private final IntArray[] d = new IntArray[PurchaseManager.RewardingAdsType.values.length]; public PP_Purchase() { PurchaseManager.RewardingAdsType[] arrayOfRewardingAdsType; int i;
/*     */     byte b;
/*  27 */     for (i = (arrayOfRewardingAdsType = PurchaseManager.RewardingAdsType.values).length, b = 0; b < i; ) { PurchaseManager.RewardingAdsType rewardingAdsType = arrayOfRewardingAdsType[b];
/*  28 */       this.d[rewardingAdsType.ordinal()] = new IntArray();
/*     */       b++; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final IntArray getRewardingAdWatchTimestamps(PurchaseManager.RewardingAdsType paramRewardingAdsType) {
/*  36 */     return this.d[paramRewardingAdsType.ordinal()];
/*     */   }
/*     */   
/*     */   public final synchronized void addRewardingAdWatchTimestamp(PurchaseManager.RewardingAdsType paramRewardingAdsType, int paramInt) {
/*     */     IntArray intArray;
/*  41 */     (intArray = this.d[paramRewardingAdsType.ordinal()]).add(Game.getTimestampSeconds());
/*  42 */     if (intArray.size > paramInt)
/*     */     {
/*  44 */       intArray.removeIndex(0);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void addValidatedTransaction(String paramString) {
/*  49 */     if (this.c.contains(paramString, false)) {
/*  50 */       this.c.add(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<String> getValidatedTransactions() {
/*  58 */     return this.c;
/*     */   }
/*     */   
/*     */   public final boolean hasAnyTransaction() {
/*  62 */     return (this.b.size != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<Transaction> getTransactions() {
/*  69 */     return this.b;
/*     */   }
/*     */   
/*     */   public final synchronized void addTransaction(Transaction paramTransaction) {
/*  73 */     this.b.add(paramTransaction);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(PrefMap paramPrefMap) {
/*  78 */     this.b.clear();
/*  79 */     this.c.clear(); PurchaseManager.RewardingAdsType[] arrayOfRewardingAdsType; int i; byte b2;
/*  80 */     for (i = (arrayOfRewardingAdsType = PurchaseManager.RewardingAdsType.values).length, b2 = 0; b2 < i; ) { PurchaseManager.RewardingAdsType rewardingAdsType = arrayOfRewardingAdsType[b2];
/*  81 */       this.d[rewardingAdsType.ordinal()].clear();
/*     */       b2++; }
/*     */     
/*     */     String str1;
/*  85 */     if ((str1 = paramPrefMap.get("purchaseTransactions", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/*  88 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           Transaction transaction;
/*  90 */           (transaction = new Transaction()).setIdentifier(jsonValue1.getString("identifier"));
/*  91 */           transaction.setStoreName(jsonValue1.getString("storeName"));
/*  92 */           transaction.setOrderId(jsonValue1.getString("orderId"));
/*  93 */           transaction.setRequestId(jsonValue1.getString("requestId"));
/*  94 */           transaction.setUserId(jsonValue1.getString("userId"));
/*  95 */           transaction.setPurchaseTime(new Date(jsonValue1.getLong("purchaseTime")));
/*  96 */           transaction.setPurchaseText(jsonValue1.getString("purchaseText"));
/*  97 */           transaction.setPurchaseCost(jsonValue1.getInt("purchaseCost"));
/*  98 */           transaction.setPurchaseCostCurrency(jsonValue1.getString("purchaseCostCurrency"));
/*  99 */           transaction.setReversalTime(new Date(jsonValue1.getLong("reversalTime")));
/* 100 */           transaction.setReversalText(jsonValue1.getString("reversalText"));
/* 101 */           transaction.setTransactionData(jsonValue1.getString("transactionData"));
/* 102 */           transaction.setTransactionDataSignature(jsonValue1.getString("transactionDataSignature"));
/*     */           
/* 104 */           this.b.add(transaction); }
/*     */       
/* 106 */       } catch (Exception exception) {
/* 107 */         a.e("failed to load transactions", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/*     */     String str2;
/* 112 */     if ((str2 = paramPrefMap.get("purchaseValidatedTransactions", null)) != null)
/*     */       try {
/*     */         JsonValue jsonValue;
/* 115 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str2)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 116 */           this.c.add(jsonValue1.asString()); }
/*     */       
/* 118 */       } catch (Exception exception) {
/* 119 */         a.e("failed to load validated transactions", new Object[] { exception });
/*     */       }  
/*     */     byte b1;
/*     */     IntArray[] arrayOfIntArray;
/* 123 */     for (int j = (arrayOfIntArray = this.d).length; b1 < j; b1++) {
/* 124 */       IntArray intArray; (intArray = arrayOfIntArray[b1]).clear();
/*     */     } 
/*     */     
/*     */     String str3;
/* 128 */     if ((str3 = paramPrefMap.get("rewardingAdsWatchTimestamps", null)) != null) {
/*     */       try {
/* 130 */         JsonValue jsonValue = (new JsonReader()).parse(str3);
/* 131 */         b1 = 0;
/* 132 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 133 */           if (b1 < this.d.length) {
/*     */             
/* 135 */             IntArray intArray = this.d[b1++];
/* 136 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) { jsonValue = jsonIterator1.next();
/* 137 */               intArray.add(jsonValue.asInt()); } 
/*     */           }  }
/*     */          return;
/* 140 */       } catch (Exception exception) {
/* 141 */         a.e("failed to load rewardingAdsWatchTimestamps", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 148 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 149 */     StringWriter stringWriter = new StringWriter();
/* 150 */     json.setWriter(stringWriter);
/*     */ 
/*     */     
/* 153 */     ObjectSet objectSet = new ObjectSet();
/* 154 */     json.writeArrayStart(); byte b1;
/* 155 */     for (b1 = 0; b1 < this.b.size; b1++) {
/* 156 */       Transaction transaction = (Transaction)this.b.get(b1);
/* 157 */       String str = transaction.getStoreName() + "|" + transaction.getOrderId();
/* 158 */       if (!objectSet.contains(str)) {
/*     */ 
/*     */         
/* 161 */         objectSet.add(str);
/*     */         
/* 163 */         json.writeObjectStart();
/* 164 */         json.writeValue("identifier", transaction.getIdentifier());
/* 165 */         json.writeValue("storeName", transaction.getStoreName());
/* 166 */         json.writeValue("orderId", transaction.getOrderId());
/* 167 */         json.writeValue("requestId", transaction.getRequestId());
/* 168 */         json.writeValue("userId", transaction.getUserId());
/* 169 */         json.writeValue("purchaseTime", Long.valueOf((transaction.getPurchaseTime() != null) ? transaction.getPurchaseTime().getTime() : 0L));
/* 170 */         json.writeValue("purchaseText", transaction.getPurchaseText());
/* 171 */         json.writeValue("purchaseCost", Integer.valueOf(transaction.getPurchaseCost()));
/* 172 */         json.writeValue("purchaseCostCurrency", transaction.getPurchaseCostCurrency());
/* 173 */         json.writeValue("reversalTime", Long.valueOf((transaction.getReversalTime() != null) ? transaction.getReversalTime().getTime() : 0L));
/* 174 */         json.writeValue("reversalText", transaction.getReversalText());
/* 175 */         json.writeValue("transactionData", transaction.getTransactionData());
/* 176 */         json.writeValue("transactionDataSignature", transaction.getTransactionDataSignature());
/* 177 */         json.writeObjectEnd();
/*     */       } 
/* 179 */     }  json.writeArrayEnd();
/* 180 */     paramPrefMap.set("purchaseTransactions", stringWriter.toString());
/*     */ 
/*     */     
/* 183 */     json = new Json(JsonWriter.OutputType.minimal);
/* 184 */     stringWriter = new StringWriter();
/* 185 */     json.setWriter(stringWriter);
/* 186 */     json.writeArrayStart();
/* 187 */     for (b1 = 0; b1 < this.c.size; b1++) {
/* 188 */       json.writeValue(this.c.get(b1));
/*     */     }
/* 190 */     json.writeArrayEnd();
/* 191 */     paramPrefMap.set("purchaseValidatedTransactions", stringWriter.toString());
/*     */ 
/*     */     
/* 194 */     json = new Json(JsonWriter.OutputType.minimal);
/* 195 */     stringWriter = new StringWriter();
/* 196 */     json.setWriter(stringWriter);
/* 197 */     json.writeArrayStart(); IntArray[] arrayOfIntArray; int i; byte b2;
/* 198 */     for (i = (arrayOfIntArray = this.d).length, b2 = 0; b2 < i; ) { IntArray intArray = arrayOfIntArray[b2];
/* 199 */       json.writeArrayStart();
/* 200 */       for (byte b = 0; b < intArray.size; b++) {
/* 201 */         json.writeValue(Integer.valueOf(intArray.items[b]));
/*     */       }
/* 203 */       json.writeArrayEnd(); b2++; }
/*     */     
/* 205 */     json.writeArrayEnd();
/* 206 */     paramPrefMap.set("rewardingAdsWatchTimestamps", stringWriter.toString());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Purchase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */