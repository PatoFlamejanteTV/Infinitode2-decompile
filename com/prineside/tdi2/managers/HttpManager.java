/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ @REGS(serializer = GateManager.Serializer.class)
/*     */ public final class HttpManager
/*     */   extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<HttpManager> {
/*     */     public HttpManager read() {
/*  20 */       return Game.i.httpManager;
/*     */     } }
/*     */   
/*     */   public final PreparedRequest prepareRequest(String paramString1, String paramString2) {
/*  24 */     return (new PreparedRequest(paramString1, (byte)0)).url(paramString2);
/*     */   }
/*     */   
/*     */   public final PreparedRequest post(String paramString) {
/*  28 */     return prepareRequest("POST", paramString);
/*     */   }
/*     */   
/*     */   public final PreparedRequest get(String paramString) {
/*  32 */     return prepareRequest("GET", paramString);
/*     */   }
/*     */   
/*     */   public static interface RequestListener {
/*     */     void onFinish(boolean param1Boolean1, @Null Net.HttpResponse param1HttpResponse, boolean param1Boolean2, @Null Throwable param1Throwable); }
/*     */   
/*     */   public final class PreparedRequest { private final Net.HttpRequest a;
/*     */     
/*     */     private PreparedRequest(HttpManager this$0, String param1String) {
/*  41 */       Preconditions.checkNotNull(param1String);
/*  42 */       this.a = new Net.HttpRequest(param1String);
/*     */     } @Null
/*     */     private HttpManager.RequestListener b; @Null
/*     */     private HashMap<String, String> c; public final Net.HttpRequest getHttp() {
/*  46 */       return this.a;
/*     */     }
/*     */     
/*     */     public final PreparedRequest url(String param1String) {
/*  50 */       Preconditions.checkNotNull(param1String);
/*  51 */       this.a.setUrl(param1String);
/*  52 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final PreparedRequest timeOut(int param1Int) {
/*  59 */       this.a.setTimeOut(param1Int);
/*  60 */       return this;
/*     */     }
/*     */     
/*     */     public final PreparedRequest param(String param1String1, String param1String2) {
/*  64 */       Preconditions.checkNotNull(param1String1, "key can not be null (%s, %s)", param1String1, param1String2);
/*  65 */       Preconditions.checkNotNull(param1String2, "value can not be null (%s, %s)", param1String1, param1String2);
/*  66 */       if (this.c == null) {
/*  67 */         this.c = new HashMap<>();
/*     */       }
/*  69 */       this.c.put(param1String1, param1String2);
/*  70 */       return this;
/*     */     }
/*     */     
/*     */     public final PreparedRequest params(ObjectMap<String, String> param1ObjectMap) {
/*  74 */       Preconditions.checkNotNull(param1ObjectMap);
/*  75 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = param1ObjectMap.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  76 */         param((String)entry.key, (String)entry.value); }
/*     */       
/*  78 */       return this;
/*     */     }
/*     */     
/*     */     public final PreparedRequest listener(HttpManager.RequestListener param1RequestListener) {
/*  82 */       this.b = param1RequestListener;
/*  83 */       return this;
/*     */     }
/*     */     
/*     */     public final PreparedRequest send() {
/*  87 */       Net.HttpResponseListener httpResponseListener = null;
/*  88 */       if (this.b != null) {
/*  89 */         httpResponseListener = new Net.HttpResponseListener(this)
/*     */           {
/*     */             public void handleHttpResponse(Net.HttpResponse param2HttpResponse) {
/*  92 */               HttpManager.PreparedRequest.a(this.a).onFinish(true, param2HttpResponse, false, null);
/*     */             }
/*     */ 
/*     */             
/*     */             public void failed(Throwable param2Throwable) {
/*  97 */               HttpManager.PreparedRequest.a(this.a).onFinish(false, null, false, param2Throwable);
/*     */             }
/*     */ 
/*     */             
/*     */             public void cancelled() {
/* 102 */               HttpManager.PreparedRequest.a(this.a).onFinish(false, null, true, null);
/*     */             }
/*     */           };
/*     */       }
/* 106 */       if (this.c != null) {
/* 107 */         this.a.setContent(HttpParametersUtils.convertHttpParameters(this.c));
/*     */       }
/* 109 */       Gdx.net.sendHttpRequest(this.a, httpResponseListener);
/* 110 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\HttpManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */