/*    */ package com.badlogic.gdx.pay;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Offer
/*    */ {
/*    */   private OfferType type;
/*    */   private String identifier;
/* 33 */   private Map<String, String> identifierForStores = new HashMap<>(16);
/*    */   
/*    */   public synchronized OfferType getType() {
/* 36 */     return this.type;
/*    */   }
/*    */   
/*    */   public synchronized Offer setType(OfferType paramOfferType) {
/* 40 */     this.type = paramOfferType;
/*    */ 
/*    */     
/* 43 */     return this;
/*    */   }
/*    */   
/*    */   public synchronized String getIdentifier() {
/* 47 */     return this.identifier;
/*    */   }
/*    */   
/*    */   public synchronized Offer setIdentifier(String paramString) {
/* 51 */     this.identifier = paramString;
/*    */ 
/*    */     
/* 54 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized String getIdentifierForStore(String paramString) {
/* 59 */     if ((paramString = this.identifierForStores.get(paramString)) != null) {
/* 60 */       return paramString;
/*    */     }
/*    */     
/* 63 */     return this.identifier;
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Set<Map.Entry<String, String>> getIdentifierForStores() {
/* 68 */     return this.identifierForStores.entrySet();
/*    */   }
/*    */   
/*    */   public synchronized Offer putIdentifierForStore(String paramString1, String paramString2) {
/* 72 */     this.identifierForStores.put(paramString1, paramString2);
/*    */ 
/*    */     
/* 75 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 80 */     return "Offer{type=" + this.type + ", identifier='" + this.identifier + '\'' + ", identifierForStores=" + this.identifierForStores + '}';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\Offer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */