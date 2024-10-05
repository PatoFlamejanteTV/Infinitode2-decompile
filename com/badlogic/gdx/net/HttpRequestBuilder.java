/*     */ package com.badlogic.gdx.net;
/*     */ 
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import java.io.InputStream;
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
/*     */ public class HttpRequestBuilder
/*     */ {
/*  37 */   public static String baseUrl = "";
/*     */ 
/*     */   
/*  40 */   public static int defaultTimeout = 1000;
/*     */ 
/*     */   
/*  43 */   public static Json json = new Json();
/*     */   
/*     */   private Net.HttpRequest httpRequest;
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder newRequest() {
/*  49 */     if (this.httpRequest != null) {
/*  50 */       throw new IllegalStateException("A new request has already been started. Call HttpRequestBuilder.build() first.");
/*     */     }
/*     */     
/*  53 */     this.httpRequest = (Net.HttpRequest)Pools.obtain(Net.HttpRequest.class);
/*  54 */     this.httpRequest.setTimeOut(defaultTimeout);
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder method(String paramString) {
/*  60 */     validate();
/*  61 */     this.httpRequest.setMethod(paramString);
/*  62 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder url(String paramString) {
/*  69 */     validate();
/*  70 */     this.httpRequest.setUrl(baseUrl + paramString);
/*  71 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder timeout(int paramInt) {
/*  78 */     validate();
/*  79 */     this.httpRequest.setTimeOut(paramInt);
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder followRedirects(boolean paramBoolean) {
/*  85 */     validate();
/*  86 */     this.httpRequest.setFollowRedirects(paramBoolean);
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder includeCredentials(boolean paramBoolean) {
/*  92 */     validate();
/*  93 */     this.httpRequest.setIncludeCredentials(paramBoolean);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder header(String paramString1, String paramString2) {
/*  99 */     validate();
/* 100 */     this.httpRequest.setHeader(paramString1, paramString2);
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder content(String paramString) {
/* 106 */     validate();
/* 107 */     this.httpRequest.setContent(paramString);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder content(InputStream paramInputStream, long paramLong) {
/* 113 */     validate();
/* 114 */     this.httpRequest.setContent(paramInputStream, paramLong);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder formEncodedContent(Map<String, String> paramMap) {
/* 120 */     validate();
/* 121 */     this.httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
/* 122 */     String str = HttpParametersUtils.convertHttpParameters(paramMap);
/* 123 */     this.httpRequest.setContent(str);
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder jsonContent(Object paramObject) {
/* 130 */     validate();
/* 131 */     this.httpRequest.setHeader("Content-Type", "application/json");
/* 132 */     paramObject = json.toJson(paramObject);
/* 133 */     this.httpRequest.setContent((String)paramObject);
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestBuilder basicAuthentication(String paramString1, String paramString2) {
/* 139 */     validate();
/* 140 */     this.httpRequest.setHeader("Authorization", "Basic " + Base64Coder.encodeString(paramString1 + ":" + paramString2));
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Net.HttpRequest build() {
/* 147 */     validate();
/* 148 */     Net.HttpRequest httpRequest = this.httpRequest;
/* 149 */     this.httpRequest = null;
/* 150 */     return httpRequest;
/*     */   }
/*     */   
/*     */   private void validate() {
/* 154 */     if (this.httpRequest == null)
/* 155 */       throw new IllegalStateException("A new request has not been started yet. Call HttpRequestBuilder.newRequest() first."); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\HttpRequestBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */