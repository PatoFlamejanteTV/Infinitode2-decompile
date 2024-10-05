/*     */ package com.badlogic.gdx.pay;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Transaction
/*     */ {
/*     */   public static final String REVERSAL_TEXT_CANCELLED = "Cancelled";
/*     */   public static final String REVERSAL_TEXT_REFUNDED = "Refunded";
/*     */   private String identifier;
/*     */   private String storeName;
/*     */   private String orderId;
/*  36 */   private String requestId = null;
/*  37 */   private String userId = null;
/*     */ 
/*     */   
/*     */   private Date purchaseTime;
/*     */ 
/*     */   
/*     */   private String purchaseText;
/*     */ 
/*     */   
/*     */   private int purchaseCost;
/*     */ 
/*     */   
/*     */   private String purchaseCostCurrency;
/*     */ 
/*     */   
/*     */   private Date reversalTime;
/*     */   
/*     */   private String reversalText;
/*     */   
/*     */   private String transactionData;
/*     */   
/*     */   private String transactionDataSignature;
/*     */ 
/*     */   
/*     */   public final String getIdentifier() {
/*  62 */     return this.identifier;
/*     */   }
/*     */   
/*     */   public final void setIdentifier(String paramString) {
/*  66 */     this.identifier = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getStoreName() {
/*  71 */     return this.storeName;
/*     */   }
/*     */   
/*     */   public final void setStoreName(String paramString) {
/*  75 */     this.storeName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getOrderId() {
/*  81 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public final void setOrderId(String paramString) {
/*  85 */     this.orderId = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getRequestId() {
/*  91 */     return this.requestId;
/*     */   }
/*     */   
/*     */   public final void setRequestId(String paramString) {
/*  95 */     this.requestId = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getUserId() {
/* 100 */     return this.userId;
/*     */   }
/*     */   
/*     */   public final void setUserId(String paramString) {
/* 104 */     this.userId = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPurchased() {
/* 109 */     return (this.reversalTime == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Date getPurchaseTime() {
/* 114 */     return this.purchaseTime;
/*     */   }
/*     */   
/*     */   public final void setPurchaseTime(Date paramDate) {
/* 118 */     this.purchaseTime = paramDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getPurchaseText() {
/* 123 */     return this.purchaseText;
/*     */   }
/*     */   
/*     */   public final void setPurchaseText(String paramString) {
/* 127 */     this.purchaseText = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getPurchaseCost() {
/* 135 */     return this.purchaseCost;
/*     */   }
/*     */   
/*     */   public final void setPurchaseCost(int paramInt) {
/* 139 */     this.purchaseCost = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getPurchaseCostCurrency() {
/* 145 */     return this.purchaseCostCurrency;
/*     */   }
/*     */   
/*     */   public final void setPurchaseCostCurrency(String paramString) {
/* 149 */     this.purchaseCostCurrency = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Date getReversalTime() {
/* 154 */     return this.reversalTime;
/*     */   }
/*     */   
/*     */   public final void setReversalTime(Date paramDate) {
/* 158 */     this.reversalTime = paramDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getReversalText() {
/* 163 */     return this.reversalText;
/*     */   }
/*     */   
/*     */   public final void setReversalText(String paramString) {
/* 167 */     this.reversalText = paramString;
/*     */   }
/*     */   
/*     */   public final String getTransactionData() {
/* 171 */     return this.transactionData;
/*     */   }
/*     */   
/*     */   public final void setTransactionData(String paramString) {
/* 175 */     this.transactionData = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getTransactionDataSignature() {
/* 180 */     return this.transactionDataSignature;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setTransactionDataSignature(String paramString) {
/* 185 */     this.transactionDataSignature = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 191 */     return "Transaction{identifier='" + this.identifier + '\'' + ", storeName='" + this.storeName + '\'' + ", orderId='" + this.orderId + '\'' + ", requestId='" + this.requestId + '\'' + ", userId='" + this.userId + '\'' + ", purchaseTime=" + this.purchaseTime + ", purchaseText='" + this.purchaseText + '\'' + ", purchaseCost=" + this.purchaseCost + ", purchaseCostCurrency='" + this.purchaseCostCurrency + '\'' + ", reversalTime=" + this.reversalTime + ", reversalText='" + this.reversalText + '\'' + ", transactionData='" + this.transactionData + '\'' + ", transactionDataSignature='" + this.transactionDataSignature + '\'' + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\Transaction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */