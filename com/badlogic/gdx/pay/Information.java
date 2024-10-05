/*     */ package com.badlogic.gdx.pay;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Information
/*     */ {
/*  17 */   public static final Information UNAVAILABLE = new Information(null, null, null);
/*     */ 
/*     */   
/*     */   private final String localName;
/*     */   
/*     */   private final String localDescription;
/*     */   
/*     */   private final String localPricing;
/*     */   
/*     */   @Deprecated
/*     */   private Integer priceInCents;
/*     */   
/*     */   private Double priceAsDouble;
/*     */   
/*     */   private String priceCurrencyCode;
/*     */   
/*     */   private FreeTrialPeriod freeTrialPeriod;
/*     */ 
/*     */   
/*     */   public Information(String paramString1, String paramString2, String paramString3) {
/*  37 */     this.localName = paramString1;
/*  38 */     this.localDescription = paramString2;
/*  39 */     this.localPricing = paramString3;
/*     */   }
/*     */   
/*     */   private Information(Builder paramBuilder) {
/*  43 */     this.localName = paramBuilder.localName;
/*  44 */     this.localDescription = paramBuilder.localDescription;
/*  45 */     this.localPricing = paramBuilder.localPricing;
/*  46 */     this.priceInCents = paramBuilder.priceInCents;
/*  47 */     this.priceAsDouble = paramBuilder.priceAsDouble;
/*  48 */     this.priceCurrencyCode = paramBuilder.priceCurrencyCode;
/*  49 */     this.freeTrialPeriod = paramBuilder.freeTrialPeriod;
/*     */   }
/*     */   
/*     */   public static Builder newBuilder() {
/*  53 */     return new Builder();
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
/*     */   @Deprecated
/*     */   public final Integer getPriceInCents() {
/*  66 */     return this.priceInCents;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final FreeTrialPeriod getFreeTrialPeriod() {
/*  75 */     return this.freeTrialPeriod;
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
/*     */   public final Double getPriceAsDouble() {
/*  96 */     return this.priceAsDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getPriceCurrencyCode() {
/* 105 */     return this.priceCurrencyCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getLocalName() {
/* 112 */     return this.localName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getLocalDescription() {
/* 119 */     return this.localDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getLocalPricing() {
/* 126 */     return this.localPricing;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 131 */     if (this == paramObject) return true; 
/* 132 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 134 */     paramObject = paramObject;
/*     */     
/* 136 */     if ((this.localName != null) ? !this.localName.equals(((Information)paramObject).localName) : (((Information)paramObject).localName != null))
/* 137 */       return false; 
/* 138 */     if ((this.localDescription != null) ? !this.localDescription.equals(((Information)paramObject).localDescription) : (((Information)paramObject).localDescription != null))
/* 139 */       return false; 
/* 140 */     return !((this.localPricing != null) ? !this.localPricing.equals(((Information)paramObject).localPricing) : (((Information)paramObject).localPricing != null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 146 */     int i = (this.localName != null) ? this.localName.hashCode() : 0;
/* 147 */     i = i * 31 + ((this.localDescription != null) ? this.localDescription.hashCode() : 0);
/*     */     
/* 149 */     return i = i * 31 + ((this.localPricing != null) ? this.localPricing.hashCode() : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 154 */     return "Information{localName='" + this.localName + '\'' + ", localDescription='" + this.localDescription + '\'' + ", localPricing='" + this.localPricing + '\'' + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Builder
/*     */   {
/*     */     private String localName;
/*     */     
/*     */     private String localDescription;
/*     */     
/*     */     private String localPricing;
/*     */     
/*     */     @Deprecated
/*     */     private Integer priceInCents;
/*     */     
/*     */     private Double priceAsDouble;
/*     */     
/*     */     private String priceCurrencyCode;
/*     */     
/*     */     private FreeTrialPeriod freeTrialPeriod;
/*     */ 
/*     */     
/*     */     private Builder() {}
/*     */     
/*     */     public final Builder localName(String param1String) {
/* 179 */       this.localName = param1String;
/* 180 */       return this;
/*     */     }
/*     */     
/*     */     public final Builder localDescription(String param1String) {
/* 184 */       this.localDescription = param1String;
/* 185 */       return this;
/*     */     }
/*     */     
/*     */     public final Builder freeTrialPeriod(FreeTrialPeriod param1FreeTrialPeriod) {
/* 189 */       this.freeTrialPeriod = param1FreeTrialPeriod;
/* 190 */       return this;
/*     */     }
/*     */     
/*     */     public final Builder localPricing(String param1String) {
/* 194 */       this.localPricing = param1String;
/* 195 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public final Builder priceInCents(Integer param1Integer) {
/* 204 */       this.priceInCents = param1Integer;
/* 205 */       return this;
/*     */     }
/*     */     
/*     */     public final Builder priceAsDouble(Double param1Double) {
/* 209 */       this.priceAsDouble = param1Double;
/* 210 */       return this;
/*     */     }
/*     */     
/*     */     public final Builder priceCurrencyCode(String param1String) {
/* 214 */       this.priceCurrencyCode = param1String;
/* 215 */       return this;
/*     */     }
/*     */     
/*     */     public final Information build() {
/* 219 */       return new Information(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\Information.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */