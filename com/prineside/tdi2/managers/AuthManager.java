/*      */ package com.prineside.tdi2.managers;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Input;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.IssuedItems;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*      */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Auth;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.screens.account.AccountScreen;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.TextInputOverlay;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.TextureRegionConfig;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ 
/*      */ @REGS(serializer = AuthManager.Serializer.class)
/*      */ public class AuthManager extends Manager.ManagerWithListeners<AuthManager.AuthManagerListener> {
/*   42 */   private static final TLog b = TLog.forClass(AuthManager.class);
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<AuthManager> {
/*      */     public AuthManager read() {
/*   46 */       return Game.i.authManager;
/*      */     }
/*      */   }
/*      */   
/*   50 */   public enum XpStatus { BONUS,
/*   51 */     NORMAL,
/*   52 */     REDUCED; static {
/*      */     
/*   54 */     } public static final XpStatus[] values = values(); }
/*      */ 
/*      */   
/*      */   public enum SignInStatus {
/*   58 */     NOT_SIGNED_IN,
/*   59 */     SIGNED_IN,
/*   60 */     SIGNED_IN_OFFLINE;
/*      */   }
/*      */   
/*      */   public enum SaveGameResult {
/*   64 */     MAX_SLOTS_USED,
/*   65 */     INVALID_SLOT_ID,
/*   66 */     SUCCESS,
/*   67 */     OTHER_ERROR;
/*      */   }
/*      */   
/*      */   public enum PasswordResetResult {
/*   71 */     USER_NOT_FOUND,
/*   72 */     TOO_MANY_ATTEMPTS,
/*   73 */     SUCCESS,
/*   74 */     OTHER_ERROR;
/*      */   }
/*      */   
/*      */   public enum ConfirmEmailResult {
/*   78 */     SUCCESS,
/*   79 */     TOO_MANY_ATTEMPTS,
/*   80 */     ALREADY_CONFIRMED,
/*   81 */     OTHER_ERROR;
/*      */   }
/*      */   
/*      */   public enum SignInResult {
/*   85 */     USER_NOT_FOUND,
/*   86 */     WRONG_PASSWORD,
/*   87 */     SUCCESS,
/*   88 */     PASSWORD_NOT_SET,
/*   89 */     OTP_REQUIRED,
/*   90 */     OTHER_ERROR;
/*      */   }
/*      */   
/*      */   public enum GoogleSignInResult {
/*   94 */     SUCCESS,
/*   95 */     OTP_REQUIRED,
/*   96 */     SIGN_UP_REQUIRED,
/*   97 */     OTHER_ERROR;
/*      */   }
/*      */   
/*      */   public enum SignUpResult {
/*  101 */     INVALID_LOGIN,
/*  102 */     INVALID_PASSWORD,
/*  103 */     INVALID_EMAIL,
/*  104 */     TOO_MANY_ATTEMPTS,
/*  105 */     NICKNAME_ALREADY_EXISTS,
/*  106 */     EMAIL_ALREADY_EXISTS,
/*  107 */     SUCCESS,
/*  108 */     OTHER_ERROR;
/*      */   }
/*      */   
/*  111 */   private SignInStatus c = SignInStatus.NOT_SIGNED_IN;
/*      */ 
/*      */   
/*      */   public int lastStateUpdateTimestamp;
/*      */   
/*  116 */   public Array<String> localXpPlayedLevels = new Array(String.class);
/*      */ 
/*      */   
/*  119 */   private Array<ObjectConsumer<NewsResponse>> d = new Array();
/*      */   
/*      */   private NewsResponse e;
/*      */   
/*      */   private boolean f;
/*      */   
/*      */   public boolean gameUpdateNotificationShown = false;
/*      */   
/*      */   private float g;
/*  128 */   private HttpQueuedRequest h = null;
/*  129 */   private Array<HttpQueuedRequest> i = new Array(true, 1, HttpQueuedRequest.class);
/*      */   
/*      */   public AuthManager() {
/*  132 */     fallBackToOfflineCache();
/*      */   }
/*      */   
/*      */   public SP_Auth.SessionData getSessionData() {
/*  136 */     return (SettingsPrefs.i()).auth.sessionData;
/*      */   }
/*      */   
/*      */   public boolean isPasswordSet() {
/*  140 */     return (getSessionData()).passwordSet;
/*      */   }
/*      */   
/*      */   public String getEmailHint() {
/*  144 */     return (getSessionData()).emailHint;
/*      */   }
/*      */   @Null
/*      */   public String getSteamAccountId() {
/*  148 */     return (getSessionData()).steamAccountId;
/*      */   }
/*      */   
/*      */   private static boolean b() {
/*  152 */     return (Game.isLoaded() && Game.i.settingsManager.isInDebugMode() && Game.i.settingsManager.isInDebugDetailedMode());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*  157 */     loadStateFromServer((String)null, (Runnable)null);
/*      */ 
/*      */     
/*  160 */     addListener(new AuthManagerListener.AuthManagerListenerAdapter(this)
/*      */         {
/*      */           public void signInStatusUpdated()
/*      */           {
/*  164 */             Runnable runnable = () -> {
/*      */                 AuthManager.a(this.a, (AuthManager.NewsResponse)null);
/*      */                 
/*      */                 this.a.getNews(());
/*      */               };
/*      */             
/*  170 */             if (AuthManager.a(this.a)) {
/*      */ 
/*      */               
/*  173 */               this.a.getNews(param1NewsResponse -> param1Runnable.run());
/*      */               
/*      */               return;
/*      */             } 
/*      */             
/*  178 */             runnable.run();
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasUnsavedProgressForCloud() {
/*  185 */     return (SettingsPrefs.i()).auth.isHasUnsavedProgressForCloud();
/*      */   }
/*      */   
/*      */   public void notifyNeedCloudSave(boolean paramBoolean) {
/*  189 */     if ((SettingsPrefs.i()).auth.isHasUnsavedProgressForCloud() != paramBoolean) {
/*  190 */       (SettingsPrefs.i()).auth.setHasUnsavedProgressForCloud(paramBoolean);
/*  191 */       SettingsPrefs.i().requireSave();
/*      */     } 
/*      */   }
/*      */   public Array<TextureRegionConfig> getProfileLevelTextures(int paramInt) {
/*      */     String str2;
/*  196 */     if (paramInt <= 0) paramInt = 1;
/*      */     
/*  198 */     Array<TextureRegionConfig> array = new Array(true, 1, TextureRegionConfig.class);
/*      */ 
/*      */     
/*  201 */     if (paramInt >= 150) {
/*  202 */       str2 = "max";
/*      */     } else {
/*  204 */       str2 = String.valueOf(paramInt / 5 + 1);
/*      */     } 
/*  206 */     array.add(new TextureRegionConfig((TextureRegion)Game.i.assetManager.getTextureRegion("player-level-" + str2)));
/*      */     
/*      */     String str1;
/*  209 */     int i = (str1 = String.valueOf(paramInt)).length();
/*      */ 
/*      */ 
/*      */     
/*  213 */     float f = (64 - i * 12) * 0.5F - 2.0F;
/*      */     
/*  215 */     for (byte b = 0; b < str1.length(); b++) {
/*  216 */       char c = str1.charAt(b);
/*  217 */       ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getTextureRegion("player-level-digit-" + c);
/*  218 */       TextureRegionConfig textureRegionConfig = new TextureRegionConfig((TextureRegion)atlasTextureRegion, (f + b * 12.0F) * 0.015625F, 0.296875F, 0.125F, 0.171875F, 0.25F, 0.34375F);
/*  219 */       array.add(textureRegionConfig);
/*      */     } 
/*      */     
/*  222 */     return array;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean anyRequestRunning() {
/*  227 */     Game.i.assertInMainThread();
/*      */     
/*  229 */     return (this.h != null || this.i.size != 0);
/*      */   }
/*      */   
/*      */   public void queueRequest(HttpQueuedRequest paramHttpQueuedRequest) {
/*  233 */     Game.i.assertInMainThread();
/*  234 */     if (b()) {
/*  235 */       b.i("Net: queueRequest: " + HttpQueuedRequest.a(paramHttpQueuedRequest), new Object[0]);
/*      */     }
/*  237 */     if (!anyRequestRunning()) {
/*  238 */       if (b()) {
/*  239 */         b.i("     queueRequest: starting request", new Object[0]);
/*      */       }
/*  241 */       this.i.add(paramHttpQueuedRequest);
/*  242 */       d(); return;
/*      */     } 
/*  244 */     this.i.add(paramHttpQueuedRequest);
/*  245 */     if (b()) b.i("     queueRequest: other request in progress, waiting", new Object[0]);
/*      */   
/*      */   }
/*      */   
/*      */   private void c() {
/*  250 */     Game.i.assertInMainThread();
/*      */     
/*      */     try {
/*  253 */       if (this.h != null) {
/*  254 */         HttpQueuedRequest httpQueuedRequest = this.h;
/*  255 */         this.h = null;
/*  256 */         Gdx.net.cancelHttpRequest(HttpQueuedRequest.b(httpQueuedRequest));
/*      */       } 
/*  258 */       this.i.clear(); return;
/*  259 */     } catch (Exception exception) {
/*  260 */       b.e("failed to cancel all requests", new Object[] { exception });
/*      */       return;
/*      */     } 
/*      */   }
/*      */   private void d() {
/*  265 */     Game.i.assertInMainThread();
/*      */     
/*  267 */     if (this.i.size > 0) {
/*  268 */       if (this.h != null)
/*      */       {
/*  270 */         Gdx.net.cancelHttpRequest(HttpQueuedRequest.b(this.h));
/*      */       }
/*      */       
/*  273 */       this.h = (HttpQueuedRequest)this.i.removeIndex(0);
/*  274 */       if (b()) b.i("Net: starting request: " + HttpQueuedRequest.a(this.h), new Object[0]);
/*      */       
/*  276 */       HttpQueuedRequest httpQueuedRequest = this.h;
/*  277 */       Gdx.net.sendHttpRequest(HttpQueuedRequest.b(this.h), new Net.HttpResponseListener(this, httpQueuedRequest)
/*      */           {
/*      */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*  280 */               String str = param1HttpResponse.getResultAsString();
/*      */               
/*  282 */               Threads.i().runOnMainThread(() -> {
/*      */                     if (AuthManager.d(this.b))
/*      */                       AuthManager.a().i("Net: success: " + AuthManager.HttpQueuedRequest.a(param1HttpQueuedRequest) + ", " + param1String, new Object[0]); 
/*      */                     long l = Game.getRealTickCount();
/*      */                     AuthManager.HttpQueuedRequest.c(param1HttpQueuedRequest).finished(true, param1String);
/*      */                     AuthManager.a(this.b, (AuthManager.HttpQueuedRequest)null);
/*      */                     AuthManager.b(this.b);
/*      */                     if (Game.i.debugManager != null)
/*      */                       Game.i.debugManager.registerFrameJob("AuthManager-handleRequest-" + AuthManager.HttpQueuedRequest.a(param1HttpQueuedRequest), Game.getRealTickCount() - l); 
/*      */                   });
/*      */             }
/*      */             
/*      */             public void failed(Throwable param1Throwable) {
/*  295 */               Threads.i().postRunnable(() -> {
/*      */                     AuthManager.a().e("Net: failed: " + AuthManager.HttpQueuedRequest.a(AuthManager.c(this.b)), new Object[] { param1Throwable });
/*      */                     AuthManager.HttpQueuedRequest.c(param1HttpQueuedRequest).finished(false, null);
/*      */                     AuthManager.a(this.b, (AuthManager.HttpQueuedRequest)null);
/*      */                     AuthManager.b(this.b);
/*      */                   });
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public void cancelled() {
/*  306 */               Threads.i().postRunnable(() -> {
/*      */                     AuthManager.a().e("Net: canceled: " + AuthManager.HttpQueuedRequest.a(param1HttpQueuedRequest), new Object[0]);
/*      */                     AuthManager.HttpQueuedRequest.c(param1HttpQueuedRequest).finished(false, null);
/*      */                     AuthManager.a(this.b, (AuthManager.HttpQueuedRequest)null);
/*      */                     AuthManager.b(this.b);
/*      */                   });
/*      */             }
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reloadPlayerId() {
/*  320 */     (getSessionData()).playerId = null;
/*  321 */     SettingsPrefs.i().requireSave();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public String getInviteCode() {
/*  328 */     return (getSessionData()).inviteCode;
/*      */   }
/*      */   @Null
/*      */   public String getInvitedById() {
/*  332 */     return (getSessionData()).invitedBy;
/*      */   }
/*      */   
/*      */   public String getPlayerIdCached() {
/*  336 */     if ((getSessionData()).playerId != null) {
/*  337 */       return (getSessionData()).playerId;
/*      */     }
/*  339 */     if ((SettingsPrefs.i()).auth.getOfflinePlayerId() != null) {
/*  340 */       return (SettingsPrefs.i()).auth.getOfflinePlayerId();
/*      */     }
/*  342 */     return "G-0000-0000-000000";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerId() {
/*  348 */     Game.i.assertInMainThread();
/*      */     
/*  350 */     if (isSignedIn()) {
/*  351 */       return (getSessionData()).playerId;
/*      */     }
/*      */     SP_Auth sP_Auth;
/*  354 */     if ((sP_Auth = (SettingsPrefs.i()).auth).getOfflinePlayerId() == null) {
/*      */       
/*  356 */       sP_Auth.setOfflinePlayerId("G-" + FastRandom.generateUniqueDistinguishableId());
/*  357 */       SettingsPrefs.i().requireSave();
/*      */       
/*  359 */       b.i("generated new offline playerId: " + sP_Auth.getOfflinePlayerId(), new Object[0]);
/*      */     } 
/*      */     
/*  362 */     return sP_Auth.getOfflinePlayerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSignedIn() {
/*  370 */     return (getSessionId() != null && (this.c == SignInStatus.SIGNED_IN || this.c == SignInStatus.SIGNED_IN_OFFLINE));
/*      */   }
/*      */   @Null
/*      */   public String getSessionId() {
/*  374 */     return (getSessionData()).sessionId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCloudSaveSlotId() {
/*  381 */     return (SettingsPrefs.i()).auth.cloudSaveSlotId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCloudSaveSlotTimestamp() {
/*  388 */     if ((SettingsPrefs.i()).auth.cloudSaveSlotId == -1) {
/*  389 */       return -1;
/*      */     }
/*  391 */     return (SettingsPrefs.i()).auth.cloudSaveSlotTimestamp;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(int paramInt1, int paramInt2) {
/*  396 */     Game.i.assertInMainThread();
/*      */     
/*  398 */     (SettingsPrefs.i()).auth.cloudSaveSlotId = paramInt1;
/*  399 */     (SettingsPrefs.i()).auth.cloudSaveSlotTimestamp = paramInt2;
/*  400 */     SettingsPrefs.i().requireSave();
/*      */   }
/*      */   
/*      */   private void e() {
/*  404 */     Game.i.assertInMainThread();
/*      */     
/*  406 */     if (!Game.i.progressManager.existsAnyProgress())
/*  407 */       getCloudSavedGamesList(paramJsonValue -> {
/*      */             if (paramJsonValue == null)
/*      */               return; 
/*      */             int i = 0;
/*      */             int j = -1;
/*      */             JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator();
/*      */             while (jsonIterator.hasNext()) {
/*      */               JsonValue jsonValue;
/*      */               int m = (jsonValue = jsonIterator.next()).getInt("slotId");
/*      */               int k;
/*      */               if ((k = jsonValue.getInt("slotTimestamp")) > i) {
/*      */                 j = m;
/*      */                 i = k;
/*      */               } 
/*      */             } 
/*      */             if (j != -1) {
/*      */               int k = j;
/*      */               Dialog.i().showConfirm(Game.i.localeManager.i18n.get("load_from_cloud_confirm"), ());
/*      */             } 
/*      */           }); 
/*      */   } @Null
/*      */   public String getProgressOwnerPlayerId() {
/*  429 */     return (ProgressPrefs.i()).auth.getProgressOwnerId();
/*      */   }
/*      */   @Null
/*      */   public String getProgressOwnerPlayerNickname() {
/*  433 */     return (ProgressPrefs.i()).auth.getProgressOwnerNickname();
/*      */   }
/*      */   
/*      */   private static void a(String paramString, Runnable paramRunnable) {
/*      */     String str;
/*  438 */     if ((str = (ProgressPrefs.i()).auth.getProgressOwnerId()) == null || str.equals(paramString)) {
/*      */       
/*  440 */       b.i("preferences owner confirmed: " + str, new Object[0]);
/*  441 */       paramRunnable.run();
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/*  449 */     b.e("owner id: " + str, new Object[0]);
/*      */     
/*  451 */     if ((paramString = (ProgressPrefs.i()).auth.getProgressOwnerNickname()) == null) {
/*  452 */       paramString = "unknown";
/*      */     }
/*  454 */     paramString = Game.i.localeManager.i18n.format("current_progress_owner_mismatch_alert", new Object[] { paramString });
/*  455 */     Dialog.i().showAlert(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public void signInWithSteam(ObjectConsumer<SignInResponse> paramObjectConsumer) {
/*  460 */     Game.i.actionResolver.requestSteamAuthTicket(paramString -> {
/*      */           if (paramString == null) {
/*      */             if (paramObjectConsumer != null) {
/*      */               paramObjectConsumer.accept((new SignInResponse(SignInResult.OTHER_ERROR)).setErrorMessage("Steam auth ticket is null"));
/*      */               return;
/*      */             } 
/*      */           } else {
/*      */             Game.i.httpManager.post(Config.AUTH_SIGN_IN_STEAM_URL).param("ticket", paramString).listener(()).send();
/*      */           } 
/*      */         });
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
/*      */   public void signInWithGoogle(String paramString, ObjectConsumer<GoogleSignInResult> paramObjectConsumer) {
/*  530 */     Game.i.assertInMainThread();
/*      */     
/*  532 */     for (byte b = 0; b < this.i.size; b++) {
/*  533 */       if (HttpQueuedRequest.a(((HttpQueuedRequest[])this.i.items)[b]).equals("signInWithGoogle")) {
/*  534 */         b.e("skipped signInWithGoogle - request already queued", new Object[0]);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/*  540 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SIGN_IN_GOOGLE_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/*  543 */     (hashMap = new HashMap<>()).put("token", paramString);
/*  544 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/*  546 */     queueRequest(new HttpQueuedRequest("signInWithGoogle", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 String str1;
/*      */                 String str2;
/*      */                 if (b()) {
/*      */                   b.i("Response: " + paramString, new Object[0]);
/*      */                 }
/*      */                 JsonValue jsonValue;
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   GoogleSignInResult googleSignInResult = GoogleSignInResult.valueOf(jsonValue.getString("signInResult"));
/*      */                   switch (null.b[googleSignInResult.ordinal()]) {
/*      */                     case 1:
/*      */                       str2 = jsonValue.getString("otpRequestId");
/*      */                       str1 = jsonValue.getString("nickname");
/*      */                       signInShowOtpForm(str2, str1, ());
/*      */                       return;
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
/*      */                     case 2:
/*      */                       Game.i.analyticsManager.logSignedIn("google");
/*      */                       loadStateFromServer(str1.getString("sessionid"), ());
/*      */                       return;
/*      */                   } 
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
/*      */                   if (paramObjectConsumer != null) {
/*      */                     Threads.i().runOnMainThread(());
/*      */                   }
/*      */                 } else {
/*      */                   b.e("failed to sign in: " + str2, new Object[0]);
/*      */                   Threads.i().runOnMainThread(());
/*      */                   return;
/*      */                 } 
/*  603 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 Threads.i().runOnMainThread(());
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Error while signing in", new Object[0]);
/*      */               Threads.i().runOnMainThread(());
/*      */             } 
/*      */           }));
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
/*      */   public void postRender(float paramFloat) {
/*  627 */     String str = getSessionId();
/*  628 */     this.g += paramFloat;
/*  629 */     if ((getSignInStatus() == SignInStatus.SIGNED_IN && str != null) || (getSignInStatus() == SignInStatus.NOT_SIGNED_IN && this.g > 1.0F))
/*      */     {
/*  631 */       if (this.d.size != 0)
/*      */       {
/*  633 */         if (!this.f) {
/*  634 */           this.f = true;
/*      */           
/*  636 */           if (b()) b.i("requesting latest news...", new Object[0]); 
/*      */           Net.HttpRequest httpRequest;
/*  638 */           (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_LATEST_NEWS_URL);
/*      */           
/*      */           HashMap<Object, Object> hashMap;
/*  641 */           (hashMap = new HashMap<>()).put("locale", Game.i.localeManager.getLocale());
/*  642 */           if (str != null) {
/*  643 */             hashMap.put("sessionid", str);
/*      */           }
/*  645 */           httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */           
/*  647 */           queueRequest(new HttpQueuedRequest("getLatestNews", httpRequest, (paramBoolean, paramString) -> {
/*      */                   if (paramBoolean) {
/*      */                     try {
/*      */                       if (b()) {
/*      */                         b.i(paramString, new Object[0]);
/*      */                       }
/*      */                       
/*      */                       JsonValue jsonValue;
/*      */                       
/*      */                       if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                         try {
/*      */                           NewsResponse newsResponse;
/*      */                           (newsResponse = new NewsResponse()).cachedAt = Game.getTimestampSeconds();
/*      */                           newsResponse.body = jsonValue.get("news").getString("body");
/*      */                           newsResponse.title = jsonValue.get("news").getString("title");
/*      */                           newsResponse.id = jsonValue.get("news").getInt("id", 0);
/*      */                           newsResponse.networkRequiredVersion = jsonValue.getInt("network_min_required_version");
/*      */                           newsResponse.lastVersion = jsonValue.getInt("last_version");
/*      */                           newsResponse.seasonNumber = jsonValue.getInt("season_number", 1);
/*      */                           newsResponse.seasonPosition = jsonValue.getInt("season_position", 0);
/*      */                           newsResponse.seasonPlayerCount = jsonValue.getInt("season_player_count", 0);
/*      */                           if ((jsonValue = jsonValue.get("issuedItems")) != null) {
/*      */                             JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator();
/*      */                             while (jsonIterator.hasNext()) {
/*      */                               JsonValue jsonValue1 = jsonIterator.next();
/*      */                               newsResponse.itemsFromServer.add(IssuedItems.fromJson(jsonValue1));
/*      */                             } 
/*      */                           } 
/*      */                           this.e = newsResponse;
/*      */                           for (byte b = 0; b < this.d.size; b++) {
/*      */                             ((ObjectConsumer)this.d.get(b)).accept(newsResponse);
/*      */                           }
/*  679 */                         } catch (Exception exception) {
/*      */                           b.e("failed to parse news", new Object[] { exception });
/*      */                         } 
/*      */                         
/*      */                         this.f = false;
/*      */                         this.d.clear();
/*      */                       } else {
/*      */                         b.e("can't retrieve news: " + exception, new Object[0]);
/*      */                         this.f = false;
/*      */                         this.d.clear();
/*      */                         return;
/*      */                       } 
/*  691 */                     } catch (Exception exception) {
/*      */                       b.e("Failed to parse response", new Object[] { exception });
/*      */                       this.f = false;
/*      */                       this.d.clear();
/*      */                       return;
/*      */                     } 
/*      */                   } else {
/*      */                     b.e("can't retrieve news", new Object[0]);
/*      */                     this.f = false;
/*      */                     this.d.clear();
/*      */                   } 
/*      */                 }));
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void f() {
/*  711 */     if (getCloudSaveSlotId() != -1) {
/*  712 */       getCloudSavedGamesList(paramJsonValue -> {
/*      */             if (paramJsonValue == null) {
/*      */               b.e("failed to load saved games list in checkIfCloudSaveGameDiffers", new Object[0]);
/*      */               return;
/*      */             } 
/*      */             boolean bool = false;
/*      */             JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator();
/*      */             while (jsonIterator.hasNext()) {
/*      */               JsonValue jsonValue;
/*      */               int i = (jsonValue = jsonIterator.next()).getInt("slotId");
/*      */               if (getCloudSaveSlotId() == i) {
/*      */                 bool = true;
/*      */                 int j;
/*      */                 if ((j = jsonValue.getInt("slotTimestamp")) > getCloudSaveSlotTimestamp()) {
/*      */                   Dialog.i().showConfirmWithCallbacks(Game.i.localeManager.i18n.get("newer_cloud_save_load_confirm"), (), ());
/*      */                 }
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */             if (!bool) {
/*      */               a(-1, 0);
/*      */               b.e("locally cached saved game slot ID not found", new Object[0]);
/*      */             } 
/*      */           });
/*      */     }
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
/*      */   public void loadStateFromServer(@Null String paramString, @Null Runnable paramRunnable) {
/*  756 */     if (Game.i.actionResolver.isAppModified() || Config.isHeadless() || Config.isModdingMode()) {
/*  757 */       b.i("loadStateFromServer - app is modified or headless", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  761 */     Game.i.assertInMainThread();
/*      */     
/*  763 */     if (paramString == null)
/*      */     {
/*  765 */       paramString = (SettingsPrefs.i()).auth.sessionData.sessionId;
/*      */     }
/*  767 */     if (paramString != null) {
/*      */       Net.HttpRequest httpRequest;
/*      */       
/*  770 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_GET_SESSION_INFO_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/*  773 */       (hashMap = new HashMap<>()).put("sessionid", paramString);
/*  774 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */       
/*  776 */       if (b()) b.i("getting status of session " + paramString, new Object[0]);
/*      */       
/*  778 */       queueRequest(new HttpQueuedRequest("loadStateFromServer", httpRequest, (paramBoolean, paramString) -> {
/*      */               if (paramBoolean) {
/*      */                 try {
/*      */                   if (b()) {
/*      */                     b.i(paramString, new Object[0]);
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   JsonValue jsonValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                     a((jsonValue = jsonValue.get("sessionData")).getString("playerid"), ());
/*      */                   } else {
/*      */                     b.e("can't load session: " + paramString, new Object[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     a(SignInStatus.NOT_SIGNED_IN);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     if (paramRunnable != null) {
/*      */                       paramRunnable.run();
/*      */                     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     return;
/*      */                   } 
/*  828 */                 } catch (Exception exception) {
/*      */                   b.e("Exception: " + exception.getMessage(), new Object[] { exception }); fallBackToOfflineCache(); if (paramRunnable != null)
/*      */                     paramRunnable.run(); 
/*      */                   return;
/*      */                 } 
/*      */               } else {
/*      */                 b.e("Error continuing session", new Object[0]);
/*      */                 fallBackToOfflineCache();
/*      */                 if (paramRunnable != null)
/*      */                   paramRunnable.run(); 
/*      */               } 
/*      */             }));
/*      */       return;
/*      */     } 
/*  842 */     a(SignInStatus.NOT_SIGNED_IN);
/*  843 */     if (paramRunnable != null) paramRunnable.run();
/*      */   
/*      */   }
/*      */   
/*      */   public long getLastLoadFromCloudTimestamp() {
/*  848 */     return (getSessionData()).lastLoadFromCloudTimestamp;
/*      */   }
/*      */   
/*      */   private void g() {
/*      */     String str;
/*  853 */     if ((str = getProgressOwnerPlayerId()) == null || str.length() != getPlayerId().length()) {
/*      */       ProgressPrefs progressPrefs;
/*      */       
/*  856 */       (progressPrefs = ProgressPrefs.i()).auth.setProgressOwnerId(getPlayerId());
/*  857 */       progressPrefs.auth.setProgressOwnerNickname(getNickname());
/*  858 */       progressPrefs.requireSave();
/*      */       
/*  860 */       b.i("owner id saved in preferences: " + getPlayerId(), new Object[0]); return;
/*      */     } 
/*  862 */     b.i("owner id not changed: " + getPlayerId(), new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onSteamAuthFinished() {}
/*      */ 
/*      */   
/*      */   private void a(SignInStatus paramSignInStatus) {
/*  871 */     Game.i.assertInMainThread();
/*      */     
/*  873 */     SignInStatus signInStatus = this.c;
/*  874 */     this.c = paramSignInStatus;
/*      */     
/*  876 */     if (paramSignInStatus == SignInStatus.SIGNED_IN)
/*      */     {
/*  878 */       g();
/*      */     }
/*      */     
/*  881 */     if (signInStatus == paramSignInStatus) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  886 */     if (b()) b.i("signIn status: " + String.valueOf(paramSignInStatus), new Object[0]);
/*      */     
/*  888 */     this.a.begin();
/*  889 */     for (byte b = 0; b < this.a.size; b++) {
/*  890 */       ((AuthManagerListener)this.a.get(b)).signInStatusUpdated();
/*      */     }
/*  892 */     this.a.end();
/*      */     
/*  894 */     if (Game.isLoaded()) {
/*      */       String str;
/*  896 */       switch (null.a[paramSignInStatus.ordinal()]) { case 1:
/*  897 */           str = Game.i.localeManager.i18n.get("signed_in_online_as") + " " + getNickname(); break;
/*  898 */         case 2: str = Game.i.localeManager.i18n.get("signed_in_offline_as") + " " + getNickname(); break;
/*  899 */         default: str = Game.i.localeManager.i18n.get("not_signed_in"); break; }
/*      */       
/*  901 */       Notifications.i().add(str, (Drawable)Game.i.assetManager.getDrawable("icon-user"), null, StaticSoundType.NOTIFICATION);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void signOut() {
/*  906 */     if (Config.isHeadless())
/*      */       return; 
/*  908 */     Game.i.assertInMainThread();
/*      */     
/*  910 */     if (b()) b.i("cancel requests (signOut)", new Object[0]); 
/*  911 */     c();
/*      */     
/*  913 */     if (isSignedIn()) {
/*      */       Net.HttpRequest httpRequest;
/*      */       
/*  916 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SIGN_OUT_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/*  919 */       (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/*      */       
/*  921 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*  922 */       Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*      */           {
/*      */             public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*  925 */               AuthManager.a().i("signOut response: " + param1HttpResponse.getResultAsString(), new Object[0]);
/*      */             }
/*      */ 
/*      */             
/*      */             public void failed(Throwable param1Throwable) {
/*  930 */               AuthManager.a().e("signOut failed", new Object[] { param1Throwable });
/*      */             }
/*      */ 
/*      */             
/*      */             public void cancelled() {
/*  935 */               AuthManager.a().e("signOut cancelled", new Object[0]);
/*      */             }
/*      */           });
/*      */     } 
/*      */     
/*  940 */     clearLocalSessionData();
/*      */   }
/*      */ 
/*      */   
/*      */   public void clearLocalSessionData() {
/*  945 */     (SettingsPrefs.i()).auth.sessionData = new SP_Auth.SessionData();
/*  946 */     SettingsPrefs.i().requireSave();
/*  947 */     a(SignInStatus.NOT_SIGNED_IN);
/*      */     
/*  949 */     Game.i.actionResolver.signOutGoogle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fallBackToOfflineCache() {
/*  957 */     Game.i.assertInMainThread();
/*      */     
/*  959 */     if (getSessionId() == null) {
/*  960 */       if (b()) b.i("fallBackToOfflineCache - no offline cache, signing out", new Object[0]); 
/*  961 */       signOut(); return;
/*      */     } 
/*  963 */     a(SignInStatus.SIGNED_IN_OFFLINE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addProfileStatusLocal(String paramString1, String paramString2, int paramInt) {
/*  974 */     Preconditions.checkNotNull(paramString1, "reason can not be null");
/*  975 */     Preconditions.checkNotNull(paramString2, "statusId can not be null");
/*      */     
/*  977 */     b.i("addProfileStatusLocal " + paramString2 + " " + paramInt, new Object[0]);
/*  978 */     boolean bool = false;
/*      */     
/*  980 */     Array array = (SettingsPrefs.i()).auth.sessionData.profileStatuses;
/*  981 */     for (byte b = 0; b < array.size; b++) {
/*  982 */       ProfileStatus profileStatus = (ProfileStatus)array.get(b);
/*  983 */       if (paramString2.equals(profileStatus.id)) {
/*  984 */         bool = true;
/*  985 */         b.i("- found existing: " + profileStatus.expiresAt, new Object[0]);
/*  986 */         if (profileStatus.expiresAt == -1 || paramInt == -1) {
/*  987 */           b.i("- enabling permanently", new Object[0]);
/*  988 */           profileStatus.expiresAt = -1; break;
/*      */         } 
/*  990 */         b.i("- adding duration", new Object[0]);
/*  991 */         profileStatus.expiresAt += paramInt;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  996 */     if (!bool) {
/*  997 */       b.i("- new status", new Object[0]);
/*      */       ProfileStatus profileStatus;
/*  999 */       (profileStatus = new ProfileStatus()).id = paramString2;
/* 1000 */       profileStatus.expiresAt = (paramInt == -1) ? -1 : (Game.getTimestampSeconds() + paramInt);
/* 1001 */       profileStatus.receivedAt = Game.getTimestampSeconds();
/* 1002 */       profileStatus.reason = paramString1;
/* 1003 */       array.add(profileStatus);
/*      */     } 
/*      */     
/* 1006 */     SettingsPrefs.i().requireSave();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean checkIncorrectSessionIdApiResponse(JsonValue paramJsonValue) {
/*      */     try {
/* 1014 */       if (paramJsonValue.getString("status", "success").equals("error")) {
/*      */         
/* 1016 */         if (paramJsonValue.getBoolean("invalid_sessionid", false)) {
/*      */           
/* 1018 */           b.e("server told us that session ID is invalid", new Object[0]);
/*      */           String str;
/* 1020 */           if ((str = paramJsonValue.getString("sessionid", "")).equals(Game.i.authManager.getSessionId())) {
/* 1021 */             b.e("currently set session ID is invalid, resetting", new Object[0]);
/* 1022 */             Game.i.authManager.clearLocalSessionData();
/* 1023 */             return false;
/*      */           } 
/* 1025 */           b.e("some other session ID is invalid, skipping", new Object[0]);
/* 1026 */           return true;
/*      */         } 
/*      */         
/* 1029 */         return true;
/*      */       } 
/*      */       
/* 1032 */       return true;
/*      */     }
/* 1034 */     catch (Exception exception) {
/* 1035 */       b.e("checkIncorrectSessionIdApiResponse failed", new Object[] { exception });
/* 1036 */       return true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isProfileStatusActive(String paramString) {
/* 1041 */     Array array = (SettingsPrefs.i()).auth.sessionData.profileStatuses;
/* 1042 */     for (byte b = 0; b < array.size; b++) {
/* 1043 */       ProfileStatus profileStatus = (ProfileStatus)array.get(b);
/* 1044 */       if (paramString.equals(profileStatus.id) && (profileStatus.expiresAt == -1 || profileStatus.expiresAt > Game.getTimestampSeconds())) {
/* 1045 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 1049 */     return false;
/*      */   }
/*      */   
/*      */   public int getMaxCloudSaveSlots() {
/* 1053 */     byte b = 3;
/* 1054 */     if (isProfileStatusActive("premium")) {
/* 1055 */       b = 7;
/*      */     }
/* 1057 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   public void linkSteamAccount(ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1062 */     Preconditions.checkNotNull(paramObjectConsumer);
/*      */     
/* 1064 */     if (!isSignedIn()) {
/* 1065 */       paramObjectConsumer.accept(Boolean.FALSE);
/*      */       
/*      */       return;
/*      */     } 
/* 1069 */     Game.i.actionResolver.requestSteamAuthTicket(paramString -> {
/*      */           if (paramString != null) {
/*      */             b.i("steam ticket: " + paramString, new Object[0]);
/*      */             
/*      */             Net.HttpRequest httpRequest;
/*      */             (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_LINK_STEAM_URL);
/*      */             HashMap<Object, Object> hashMap;
/*      */             (hashMap = new HashMap<>()).put("sessionid", Game.i.authManager.getSessionId());
/*      */             hashMap.put("locale", Game.i.localeManager.getLocale());
/*      */             hashMap.put("ticket", paramString);
/*      */             httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */             Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer)
/*      */                 {
/*      */                   public void handleHttpResponse(Net.HttpResponse param1HttpResponse)
/*      */                   {
/* 1084 */                     String str = param1HttpResponse.getResultAsString();
/* 1085 */                     AuthManager.a().i("linkSteamAccount server: " + str, new Object[0]);
/* 1086 */                     Threads.i().runOnMainThread(() -> {
/*      */                           try {
/*      */                             String str;
/*      */                             
/*      */                             JsonValue jsonValue;
/*      */                             
/*      */                             if ((jsonValue = (new JsonReader()).parse(param1String)).getString("status").equals("success")) {
/*      */                               Notifications.i().add(Game.i.localeManager.i18n.get("success_to_link_steam"), null, MaterialColor.GREEN.P800, StaticSoundType.SUCCESS);
/*      */                               
/*      */                               if ((str = jsonValue.getString("double_gain_status_error", null)) != null) {
/*      */                                 Notifications.i().add(str, null, null, null);
/*      */                               }
/*      */                               this.b.loadStateFromServer((String)null, ());
/*      */                             } else {
/*      */                               Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_link_steam") + "\n" + str.getString("message"), null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */                               param1ObjectConsumer.accept(Boolean.FALSE);
/*      */                               return;
/*      */                             } 
/* 1104 */                           } catch (Exception exception) {
/*      */                             AuthManager.a().e("failed to parse response from server: " + param1String, new Object[] { exception });
/*      */                             Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_link_steam") + "\nServer error - invalid response", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */                           } 
/*      */                         });
/*      */                   }
/*      */ 
/*      */                   
/*      */                   public void failed(Throwable param1Throwable) {
/* 1113 */                     AuthManager.a().e("failed to get account settings", new Object[] { param1Throwable });
/* 1114 */                     Threads.i().runOnMainThread(() -> Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_link_steam") + "\nRequest failed, check your Internet connection", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL));
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   public void cancelled() {
/* 1121 */                     Threads.i().runOnMainThread(() -> Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_link_steam") + "\nRequest cancelled", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL));
/*      */                   }
/*      */                 });
/*      */             return;
/*      */           } 
/*      */           b.i("requestSteamAuthTicket returned null", new Object[0]);
/*      */           Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_link_steam") + "\nClient::requestSteamAuthTicket failed", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */           paramObjectConsumer.accept(Boolean.FALSE);
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SignInStatus getSignInStatus() {
/* 1136 */     return this.c;
/*      */   }
/*      */   
/*      */   public String getNickname() {
/* 1140 */     if (!isSignedIn()) {
/* 1141 */       return "Guest";
/*      */     }
/* 1143 */     return (getSessionData()).nickname;
/*      */   }
/*      */ 
/*      */   
/*      */   public TextureRegion getAvatar(int paramInt) {
/* 1148 */     if (paramInt != 32 && paramInt != 64 && paramInt != 128) {
/* 1149 */       paramInt = 64;
/*      */     }
/*      */     
/* 1152 */     SP_Auth.SessionData sessionData = getSessionData();
/* 1153 */     if ((this.c == SignInStatus.SIGNED_IN || this.c == SignInStatus.SIGNED_IN_OFFLINE) && sessionData.hasAvatar && sessionData.playerId != null) {
/* 1154 */       return Game.i.assetManager.loadWebTexture(Config.AVATAR_WEB_TEXTURES_URL + sessionData.playerId.toLowerCase(Locale.US) + "-" + paramInt + ".png", true);
/*      */     }
/* 1156 */     return (TextureRegion)Game.i.assetManager.getTextureRegion("icon-user");
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAvatarWebUrl(String paramString, int paramInt) {
/* 1161 */     return Config.AVATAR_WEB_TEXTURES_URL + paramString.toLowerCase(Locale.US) + "-" + paramInt + ".png";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void linkAccountStatus(String paramString, ObjectConsumer<String> paramObjectConsumer) {
/* 1168 */     Preconditions.checkNotNull(paramString, "dataJson is null");
/* 1169 */     Preconditions.checkNotNull(paramObjectConsumer, "cb is null");
/*      */     
/*      */     Net.HttpRequest httpRequest;
/* 1172 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_LINK_ACCOUNT_STATUS_URL);
/*      */     HashMap<Object, Object> hashMap;
/* 1174 */     (hashMap = new HashMap<>()).put("sessionid", Game.i.authManager.getSessionId());
/* 1175 */     hashMap.put("locale", Game.i.localeManager.getLocale());
/* 1176 */     hashMap.put("data", paramString);
/*      */     
/* 1178 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/* 1179 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramObjectConsumer)
/*      */         {
/*      */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 1182 */             String str = param1HttpResponse.getResultAsString();
/* 1183 */             AuthManager.a().i("linkAccountStatus server: " + str, new Object[0]);
/* 1184 */             Threads.i().runOnMainThread(() -> {
/*      */                   try {
/*      */                     JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(param1String)).getString("status").equals("success")) {
/*      */                       param1ObjectConsumer.accept(null);
/*      */                     } else {
/*      */                       param1ObjectConsumer.accept(jsonValue.getString("message"));
/*      */                       return;
/*      */                     } 
/* 1192 */                   } catch (Exception exception) {
/*      */                     AuthManager.a().e("failed to parse response from server: " + param1String, new Object[] { exception });
/*      */                     param1ObjectConsumer.accept("Server error - invalid response");
/*      */                   } 
/*      */                 });
/*      */           }
/*      */ 
/*      */           
/*      */           public void failed(Throwable param1Throwable) {
/* 1201 */             AuthManager.a().e("failed to get account settings", new Object[] { param1Throwable });
/* 1202 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept("Request failed, check your Internet connection"));
/*      */           }
/*      */ 
/*      */           
/*      */           public void cancelled() {
/* 1207 */             Threads.i().runOnMainThread(() -> param1ObjectConsumer.accept("Request cancelled"));
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void backupProgressToServer() {
/*      */     try {
/* 1214 */       Game.i.assertInMainThread();
/*      */       
/* 1216 */       if (this.c != SignInStatus.SIGNED_IN) {
/* 1217 */         b.i("progress backup: canceled, not signed in", new Object[0]);
/*      */       }
/*      */       
/* 1220 */       if (Game.i.progressManager.isDeveloperModeEnabled()) {
/* 1221 */         b.i("progress backup: canceled, dev mode", new Object[0]);
/*      */         return;
/*      */       } 
/* 1224 */       if (Config.isHeadless()) {
/*      */         return;
/*      */       }
/* 1227 */       if (!Game.i.progressManager.hasAnyItem()) {
/* 1228 */         b.i("progress backup: canceled, no items", new Object[0]);
/*      */         
/*      */         return;
/*      */       } 
/* 1232 */       if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1233 */         b.i("progress backup: canceled, modified game", new Object[0]);
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*      */       Net.HttpRequest httpRequest;
/*      */       
/* 1241 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_BACKUP_PROGRESS_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/* 1244 */       (hashMap = new HashMap<>()).put("sessionid", String.valueOf(getSessionId()));
/* 1245 */       hashMap.put("gameStartHash", Game.i.progressManager.getGameStartHash());
/* 1246 */       hashMap.put("progress", Game.i.preferencesManager.progressPrefsToBase64());
/*      */       
/* 1248 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */       
/* 1250 */       queueRequest(new HttpQueuedRequest("backupProgressToServer", httpRequest, (paramBoolean, paramString) -> {
/*      */               if (paramBoolean) {
/*      */                 b.i("progress backup: response: " + paramString, new Object[0]); return;
/*      */               } 
/*      */               b.e("progress backup: failed", new Object[0]);
/*      */             }));
/*      */       return;
/* 1257 */     } catch (Exception exception) {
/* 1258 */       b.e("backupProgressToServer failed", new Object[] { exception });
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveGameToServer(int paramInt, ObjectConsumer<SaveGameResult> paramObjectConsumer) {
/* 1266 */     Game.i.assertInMainThread();
/*      */     
/* 1268 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/* 1269 */       Notifications.i().add("Could not save game to cloud while being in Developer mode, please reset your progress first", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/* 1273 */     if (Config.isHeadless()) {
/*      */       return;
/*      */     }
/* 1276 */     if (!Game.i.progressManager.hasAnyItem()) {
/* 1277 */       b.e("empty items, save to cloud disabled", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1282 */     if (this.c == SignInStatus.SIGNED_IN) {
/* 1283 */       if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1284 */         Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*      */       Net.HttpRequest httpRequest;
/*      */       
/* 1292 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SAVE_GAME_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/* 1295 */       (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/* 1296 */       hashMap.put("gameStartHash", Game.i.progressManager.getGameStartHash());
/* 1297 */       hashMap.put("timeInGame", String.valueOf(Game.i.statisticsManager.getTimeSpentInGameSinceStart()));
/* 1298 */       if (paramInt != -1) {
/* 1299 */         hashMap.put("slotId", String.valueOf(paramInt));
/*      */       }
/*      */       
/* 1302 */       hashMap.put("data", Game.i.preferencesManager.progressPrefsToBase64());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1310 */       String str = HttpParametersUtils.convertHttpParameters(hashMap);
/* 1311 */       b.i(str, new Object[0]);
/* 1312 */       httpRequest.setContent(str);
/*      */       
/* 1314 */       queueRequest(new HttpQueuedRequest("saveGameToServer", httpRequest, (paramBoolean, paramString) -> {
/*      */               if (paramBoolean) {
/*      */                 try {
/*      */                   b.i("save response: " + paramString, new Object[0]);
/*      */                   
/*      */                   JsonValue jsonValue;
/*      */                   
/*      */                   if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                     a(jsonValue.getInt("slotId"), jsonValue.getInt("slotTimestamp"));
/*      */                     
/*      */                     loadStateFromServer((String)null, (Runnable)null);
/*      */                     
/*      */                     if (paramObjectConsumer != null) {
/*      */                       paramObjectConsumer.accept(SaveGameResult.SUCCESS);
/*      */                     }
/*      */                     
/*      */                     Notifications.i().add(Game.i.localeManager.i18n.get("game_saved_to_cloud"), (Drawable)Game.i.assetManager.getDrawable("icon-info"), MaterialColor.GREEN.P800, StaticSoundType.NOTIFICATION);
/*      */                     notifyNeedCloudSave(false);
/*      */                   } else {
/*      */                     b.e("can't save game: " + paramString, new Object[0]);
/*      */                     if (paramObjectConsumer != null) {
/*      */                       SaveGameResult saveGameResult = SaveGameResult.OTHER_ERROR;
/*      */                       try {
/*      */                         saveGameResult = SaveGameResult.valueOf(jsonValue.getString("saveGameResult"));
/* 1338 */                       } catch (Exception exception) {}
/*      */                       paramObjectConsumer.accept(saveGameResult);
/*      */                     } 
/*      */                     return;
/*      */                   } 
/* 1343 */                 } catch (Exception exception) {
/*      */                   b.e("Failed to parse response", new Object[] { exception }); if (paramObjectConsumer != null)
/*      */                     paramObjectConsumer.accept(SaveGameResult.OTHER_ERROR);  return;
/*      */                 } 
/*      */               } else {
/*      */                 b.e("Error while saving game", new Object[0]); if (paramObjectConsumer != null)
/*      */                   paramObjectConsumer.accept(SaveGameResult.OTHER_ERROR); 
/*      */               } 
/*      */             })); return;
/*      */     } 
/* 1353 */     b.e("can't save game to cloud, not signed in", new Object[0]);
/* 1354 */     if (paramObjectConsumer != null) paramObjectConsumer.accept(SaveGameResult.OTHER_ERROR);
/*      */   
/*      */   }
/*      */   
/*      */   public void deleteGameFromServer(int paramInt, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1359 */     if (Config.isHeadless())
/* 1360 */       return;  Preconditions.checkNotNull(paramObjectConsumer);
/*      */     
/* 1362 */     if (this.c == SignInStatus.SIGNED_IN) {
/*      */       Net.HttpRequest httpRequest;
/* 1364 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_DELETE_GAME_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/* 1367 */       (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/* 1368 */       hashMap.put("slotId", String.valueOf(paramInt));
/*      */       
/* 1370 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */       
/* 1372 */       queueRequest(new HttpQueuedRequest("deleteGameFromServer", httpRequest, (paramBoolean, paramString) -> {
/*      */               if (paramBoolean) {
/*      */                 try {
/*      */                   if (b()) {
/*      */                     b.i(paramString, new Object[0]);
/*      */                   }
/*      */                   JsonValue jsonValue;
/*      */                   if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                     paramObjectConsumer.accept(Boolean.TRUE);
/*      */                   } else {
/*      */                     b.e("can't delete game: " + paramString, new Object[0]);
/*      */                     paramObjectConsumer.accept(Boolean.FALSE);
/*      */                     return;
/*      */                   } 
/* 1386 */                 } catch (Exception exception) {
/*      */                   b.e("Failed to parse response", new Object[] { exception }); paramObjectConsumer.accept(Boolean.FALSE); return;
/*      */                 } 
/*      */               } else {
/*      */                 b.e("Error while deleting game", new Object[0]);
/*      */                 paramObjectConsumer.accept(Boolean.FALSE);
/*      */               } 
/*      */             }));
/*      */       return;
/*      */     } 
/* 1396 */     b.e("not signed in, can't delete saved game", new Object[0]);
/* 1397 */     paramObjectConsumer.accept(Boolean.FALSE);
/*      */   }
/*      */ 
/*      */   
/*      */   public void loadSavedGameFromServer(int paramInt) {
/* 1402 */     if (Config.isHeadless())
/*      */       return; 
/* 1404 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/* 1405 */       Notifications.i().add("Could not load game while being in Developer mode, please reset your progress first", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/* 1409 */     if (this.c == SignInStatus.SIGNED_IN) {
/*      */       Net.HttpRequest httpRequest;
/* 1411 */       (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_LOAD_GAME_URL);
/*      */       
/*      */       HashMap<Object, Object> hashMap;
/* 1414 */       (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/* 1415 */       hashMap.put("slotId", String.valueOf(paramInt));
/*      */       
/* 1417 */       httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */       
/* 1419 */       queueRequest(new HttpQueuedRequest("loadSavedGameFromServer", httpRequest, (paramBoolean, paramString) -> {
/*      */               if (paramBoolean) {
/*      */                 try {
/*      */                   String str;
/*      */                   
/*      */                   if (b()) {
/*      */                     b.i(paramString, new Object[0]);
/*      */                   }
/*      */                   
/*      */                   JsonValue jsonValue;
/*      */                   
/*      */                   if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                     int i;
/*      */                     
/*      */                     if ((i = jsonValue.get("savedGame").getInt("gameBuild")) > 207) {
/*      */                       Notifications.i().add(Game.i.localeManager.i18n.get("cant_load_from_cloud_need_update"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */                       
/*      */                       return;
/*      */                     } 
/*      */                     
/*      */                     (getSessionData()).lastLoadFromCloudTimestamp = Game.getTimestampMillis();
/*      */                     SettingsPrefs.i().requireSave();
/*      */                     str = Game.i.authManager.getSessionId();
/*      */                     if (b()) {
/*      */                       b.i("current session: " + str, new Object[0]);
/*      */                     }
/*      */                     JsonValue jsonValue1 = jsonValue.get("savedGame").get("data");
/*      */                     if (b()) {
/*      */                       b.i("loading saved game from compact base64 " + jsonValue1.asString(), new Object[0]);
/*      */                     }
/*      */                     Game.i.preferencesManager.fromBase64(jsonValue1.asString());
/*      */                     a(jsonValue.get("savedGame").getInt("slotId"), jsonValue.get("savedGame").getInt("slotTimestamp"));
/*      */                     Game.i.preferencesManager.reapplyAllPreferences();
/*      */                     Game.i.authManager.loadStateFromServer(str, (Runnable)null);
/*      */                     AccountScreen.goToScreen();
/*      */                     if ((SettingsPrefs.i()).auth.isHasUnsavedProgressForCloud()) {
/*      */                       (SettingsPrefs.i()).auth.setHasUnsavedProgressForCloud(false);
/*      */                       SettingsPrefs.i().requireSave();
/*      */                     } 
/*      */                     if (b()) {
/*      */                       b.i("new session: " + Game.i.authManager.getSessionId(), new Object[0]);
/*      */                     }
/*      */                     Notifications.i().add(Game.i.localeManager.i18n.get("game_loaded_from_cloud"), (Drawable)Game.i.assetManager.getDrawable("icon-info"), null, StaticSoundType.NOTIFICATION);
/*      */                   } else {
/*      */                     b.e("can't load game: " + str, new Object[0]);
/*      */                     return;
/*      */                   } 
/* 1466 */                 } catch (Exception exception) {
/*      */                   b.e("Failed to parse response", new Object[] { exception }); return;
/*      */                 } 
/*      */               } else {
/*      */                 b.e("Failed to load saved game from server", new Object[0]);
/*      */               } 
/*      */             })); return;
/*      */     } 
/* 1474 */     b.e("not signed in, can't load saved game", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleAutoSave() {
/* 1480 */     if (isAutoSavesEnabled()) {
/* 1481 */       saveGameToServer(getCloudSaveSlotId(), paramSaveGameResult -> {
/*      */             if (paramSaveGameResult == SaveGameResult.MAX_SLOTS_USED || paramSaveGameResult == SaveGameResult.INVALID_SLOT_ID) {
/*      */               setAutoSavesEnabled(false);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/* 1489 */     backupProgressToServer();
/*      */   }
/*      */   
/*      */   public void requestNicknameChange(String paramString, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1493 */     if (getSessionId() == null) {
/* 1494 */       if (paramObjectConsumer != null) paramObjectConsumer.accept(Boolean.FALSE);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1499 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_NICKNAME_CHANGE_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 1502 */     (hashMap = new HashMap<>()).put("nickname", paramString);
/* 1503 */     if (getSessionId() != null) {
/* 1504 */       hashMap.put("sessionid", getSessionId());
/*      */     }
/* 1506 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1508 */     queueRequest(new HttpQueuedRequest("changeNickname", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b())
/*      */                   b.i("Response: " + paramString, new Object[0]); 
/*      */                 JsonValue jsonValue;
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   loadStateFromServer((String)null, (paramObjectConsumer != null) ? (()) : null);
/*      */                 } else {
/*      */                   b.e("failed to change nickname: " + paramString, new Object[0]);
/*      */                   Notifications.i().add(jsonValue.getString("message", Game.i.localeManager.i18n.get("unknown_error")), null, MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */                   if (paramObjectConsumer != null)
/*      */                     paramObjectConsumer.accept(Boolean.FALSE); 
/*      */                   return;
/*      */                 } 
/* 1523 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 Notifications.i().add(Game.i.localeManager.i18n.get("unknown_error"), null, MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */                 if (paramObjectConsumer != null)
/*      */                   paramObjectConsumer.accept(Boolean.FALSE); 
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to get cloud saves", new Object[0]);
/*      */               Notifications.i().add(Game.i.localeManager.i18n.get("unknown_error"), null, MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(Boolean.FALSE); 
/*      */             } 
/*      */           })); } public void createPasteBin(String paramString1, String paramString2, ObjectConsumer<PasteBinResponse> paramObjectConsumer) {
/* 1537 */     if (!isSignedIn() || getPlayerId() == null) {
/* 1538 */       paramObjectConsumer.accept(new PasteBinResponse(false, "Not signed in", null));
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1543 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_PASTEBIN_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 1546 */     (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/* 1547 */     hashMap.put("description", paramString1);
/* 1548 */     hashMap.put("contents", paramString2);
/*      */     
/* 1550 */     paramString1 = HttpParametersUtils.convertHttpParameters(hashMap);
/* 1551 */     httpRequest.setContent(paramString1);
/*      */     
/* 1553 */     queueRequest(new HttpQueuedRequest("createPasteBin", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 JsonValue jsonValue = (new JsonReader()).parse(paramString);
/*      */                 
/*      */                 if ("success".equals(jsonValue.getString("status"))) {
/*      */                   Threads.i().runOnMainThread(());
/*      */                 } else {
/*      */                   b.e("paste bin failed: " + paramString, new Object[0]);
/*      */                   
/*      */                   Threads.i().runOnMainThread(());
/*      */                   
/*      */                   return;
/*      */                 } 
/* 1567 */               } catch (Exception exception) {
/*      */                 Threads.i().runOnMainThread(());
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               Threads.i().runOnMainThread(());
/*      */             } 
/*      */           }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void resetPassword(String paramString, ObjectConsumer<PasswordResetResult> paramObjectConsumer) {
/* 1582 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1583 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1588 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_PASSWORD_RESET_URL);
/*      */     HashMap<Object, Object> hashMap;
/* 1590 */     (hashMap = new HashMap<>()).put("emailOrNickname", paramString);
/* 1591 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1593 */     queueRequest(new HttpQueuedRequest("resetPassword", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b())
/*      */                   b.i("Response: " + paramString, new Object[0]);  JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   if (paramObjectConsumer != null) {
/*      */                     paramObjectConsumer.accept(PasswordResetResult.SUCCESS);
/*      */                   } else {
/*      */                     return;
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("failed to reset password: " + paramString, new Object[0]);
/*      */                   if (paramObjectConsumer != null)
/*      */                   { 
/*      */                     try { paramObjectConsumer.accept(PasswordResetResult.valueOf(jsonValue.getString("passwordResetResult"))); }
/* 1608 */                     catch (Exception exception) { paramObjectConsumer.accept(PasswordResetResult.OTHER_ERROR); return; }
/*      */                      }
/*      */                   else { return; }
/*      */                 
/*      */                 } 
/* 1613 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 if (paramObjectConsumer != null) {
/*      */                   paramObjectConsumer.accept(PasswordResetResult.OTHER_ERROR);
/*      */                 }
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to reset password", new Object[0]);
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(PasswordResetResult.OTHER_ERROR); 
/*      */             } 
/*      */           }));
/*      */   }
/*      */   
/*      */   public void setPassword(String paramString, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1629 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1630 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/* 1634 */     if (!isSignedIn() || getSessionId() == null) {
/* 1635 */       b.e("setPassword cancelled - player not signed in", new Object[0]);
/* 1636 */       paramObjectConsumer.accept(Boolean.FALSE);
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1640 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_PASSWORD_SET_URL);
/*      */     HashMap<Object, Object> hashMap;
/* 1642 */     (hashMap = new HashMap<>()).put("password", paramString);
/* 1643 */     hashMap.put("sessionid", getSessionId());
/* 1644 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1646 */     queueRequest(new HttpQueuedRequest("setPassword", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b()) {
/*      */                   b.i("Response: " + paramString, new Object[0]);
/*      */                 }
/*      */                 JsonValue jsonValue;
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   try {
/*      */                     (Game.i.preferencesManager.getSettingsPrefs()).auth.sessionData.passwordSet = true;
/* 1656 */                   } catch (Exception exception) {} if (paramObjectConsumer != null) {
/*      */                     paramObjectConsumer.accept(Boolean.TRUE);
/*      */                   } else {
/*      */                     return;
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("failed to set password: " + paramString, new Object[0]); if (paramObjectConsumer != null)
/*      */                     paramObjectConsumer.accept(Boolean.FALSE); 
/*      */                   return;
/*      */                 } 
/* 1666 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 if (paramObjectConsumer != null) {
/*      */                   paramObjectConsumer.accept(Boolean.FALSE);
/*      */                 }
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to set password", new Object[0]);
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(Boolean.FALSE); 
/*      */             } 
/*      */           }));
/*      */   }
/*      */   
/*      */   public void confirmEmail(ObjectConsumer<ConfirmEmailResult> paramObjectConsumer) {
/* 1682 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1683 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/*      */     String str;
/* 1688 */     if ((str = getSessionId()) == null) {
/* 1689 */       b.e("can't confirmEmail - no session id", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1694 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_CONFIRM_EMAIL_URL);
/*      */     HashMap<Object, Object> hashMap;
/* 1696 */     (hashMap = new HashMap<>()).put("sessionid", str);
/* 1697 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1699 */     queueRequest(new HttpQueuedRequest("confirmEmail", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b())
/*      */                   b.i("Response: " + paramString, new Object[0]);  JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   if (paramObjectConsumer != null) {
/*      */                     paramObjectConsumer.accept(ConfirmEmailResult.SUCCESS);
/*      */                   } else {
/*      */                     return;
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("failed to reset password: " + paramString, new Object[0]);
/*      */                   if (paramObjectConsumer != null)
/*      */                   { 
/*      */                     try { paramObjectConsumer.accept(ConfirmEmailResult.valueOf(jsonValue.getString("statusCode"))); }
/* 1714 */                     catch (Exception exception) { paramObjectConsumer.accept(ConfirmEmailResult.OTHER_ERROR); return; }
/*      */                      }
/*      */                   else { return; }
/*      */                 
/*      */                 } 
/* 1719 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 if (paramObjectConsumer != null) {
/*      */                   paramObjectConsumer.accept(ConfirmEmailResult.OTHER_ERROR);
/*      */                 }
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to confirm email", new Object[0]);
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(ConfirmEmailResult.OTHER_ERROR); 
/*      */             } 
/*      */           }));
/*      */   }
/*      */   
/*      */   public void signUpWithSteam(String paramString1, String paramString2, String paramString3, ObjectConsumer<SignUpResult> paramObjectConsumer) {
/* 1735 */     Preconditions.checkNotNull(paramString1, "nickname can not be null");
/* 1736 */     Preconditions.checkNotNull(paramString2, "email can not be null");
/* 1737 */     Preconditions.checkNotNull(paramObjectConsumer, "callback can not be null");
/*      */     
/* 1739 */     if (Config.isHeadless())
/*      */       return; 
/* 1741 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1742 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/* 1746 */     Game.i.actionResolver.requestSteamAuthTicket(paramString4 -> {
/*      */           if (paramString4 == null) {
/*      */             b.e("failed to get Steam auth ticket", new Object[0]);
/*      */             paramObjectConsumer.accept(SignUpResult.OTHER_ERROR);
/*      */             return;
/*      */           } 
/*      */           Game.i.httpManager.post(Config.AUTH_SIGN_UP_STEAM_URL).param("ticket", paramString4).param("nickname", paramString1).param("email", paramString2).param("inviteCode", paramString3).listener(()).send();
/*      */         });
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
/*      */   public void signInEnterOTP(String paramString1, String paramString2, ObjectConsumer<ObjectPair<Boolean, String>> paramObjectConsumer) {
/* 1801 */     Preconditions.checkNotNull(paramObjectConsumer, "callback");
/*      */     
/*      */     Net.HttpRequest httpRequest;
/* 1804 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SIGN_IN_CONFIRM_OTP_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 1807 */     (hashMap = new HashMap<>()).put("otpRequestId", paramString2);
/* 1808 */     hashMap.put("code", paramString1);
/*      */     
/* 1810 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1812 */     queueRequest(new HttpQueuedRequest("signInEnterOTP", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b()) {
/*      */                   b.i("Response: " + paramString, new Object[0]);
/*      */                 }
/*      */                 
/*      */                 JsonValue jsonValue;
/*      */                 
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   Game.i.analyticsManager.logSignedIn("otp");
/*      */                   
/*      */                   loadStateFromServer(jsonValue.getString("sessionid"), ());
/*      */                 } else {
/*      */                   b.e("OTP validation failed: " + paramString, new Object[0]);
/*      */                   paramObjectConsumer.accept(new ObjectPair(Boolean.FALSE, jsonValue.getString("message")));
/*      */                   return;
/*      */                 } 
/* 1830 */               } catch (Exception exception) {
/*      */                 b.e("failed to handle OTP response", new Object[] { exception });
/*      */                 paramObjectConsumer.accept(new ObjectPair(Boolean.FALSE, exception.getMessage()));
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("request failed", new Object[0]);
/*      */               paramObjectConsumer.accept(new ObjectPair(Boolean.FALSE, "Request failed"));
/*      */             } 
/*      */           }));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void signInShowOtpForm(String paramString1, String paramString2, ObjectConsumer<SignInResponse> paramObjectConsumer) {
/* 1845 */     String str = Game.i.localeManager.i18n.format("otp_code_prompt_title", new Object[] { paramString2 });
/* 1846 */     TextInputOverlay.i().show(new Input.TextInputListener(this, paramString1, paramString2, paramObjectConsumer)
/*      */         {
/*      */           public void input(String param1String) {
/* 1849 */             if (param1String.length() != 6 || !param1String.matches("[0-9]+")) {
/* 1850 */               Notifications.i().add("Incorrect code - must be 6 digits long", null, null, StaticSoundType.FAIL);
/* 1851 */               this.d.signInShowOtpForm(this.a, this.b, this.c); return;
/*      */             } 
/* 1853 */             this.d.signInEnterOTP(param1String, this.a, param1ObjectPair -> {
/*      */                   if (((Boolean)param1ObjectPair.first).booleanValue()) {
/*      */                     if (param1ObjectConsumer != null) {
/*      */                       param1ObjectConsumer.accept(new AuthManager.SignInResponse(AuthManager.SignInResult.SUCCESS));
/*      */                       return;
/*      */                     } 
/*      */                   } else {
/*      */                     if (param1ObjectPair.second != null) {
/*      */                       Notifications.i().add((CharSequence)param1ObjectPair.second, null, null, StaticSoundType.FAIL);
/*      */                     }
/*      */                     this.d.signInShowOtpForm(param1String1, param1String2, param1ObjectConsumer);
/*      */                   } 
/*      */                 });
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void canceled() {
/* 1871 */             if (this.c != null) this.c.accept(new AuthManager.SignInResponse(AuthManager.SignInResult.OTHER_ERROR));
/*      */           
/*      */           }
/*      */         }str, "", "Enter code from your Authenticator app");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void signIn(String paramString1, String paramString2, ObjectConsumer<SignInResponse> paramObjectConsumer) {
/* 1880 */     if (Config.isHeadless())
/*      */       return; 
/* 1882 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 1883 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1888 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SIGN_IN_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 1891 */     (hashMap = new HashMap<>()).put("login", paramString1);
/* 1892 */     hashMap.put("password", paramString2);
/*      */     
/* 1894 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1896 */     queueRequest(new HttpQueuedRequest("signIn", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 String str;
/*      */                 
/*      */                 if (b()) {
/*      */                   b.i("Response: " + paramString, new Object[0]);
/*      */                 }
/*      */                 
/*      */                 JsonValue jsonValue;
/*      */                 
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   if (jsonValue.getString("signInResult").equals("OTP_REQUIRED")) {
/*      */                     paramString = jsonValue.getString("otpRequestId");
/*      */                     
/*      */                     str = jsonValue.getString("nickname");
/*      */                     
/*      */                     signInShowOtpForm(paramString, str, paramObjectConsumer);
/*      */                   } else {
/*      */                     Game.i.analyticsManager.logSignedIn("password");
/*      */                     
/*      */                     loadStateFromServer(str.getString("sessionid"), ());
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("failed to sign in: " + paramString, new Object[0]);
/*      */                   signOut();
/*      */                   if (paramObjectConsumer != null)
/*      */                   { 
/*      */                     try { paramObjectConsumer.accept(new SignInResponse(SignInResult.valueOf(str.getString("signInResult")))); }
/* 1925 */                     catch (Exception exception) { paramObjectConsumer.accept((new SignInResponse(SignInResult.OTHER_ERROR)).setErrorMessage(exception.getMessage())); return; }
/*      */                      }
/*      */                   else { return; }
/*      */                 
/*      */                 } 
/* 1930 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 signOut();
/*      */                 if (paramObjectConsumer != null) {
/*      */                   paramObjectConsumer.accept((new SignInResponse(SignInResult.OTHER_ERROR)).setErrorMessage(exception.getMessage()));
/*      */                 }
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to sign in", new Object[0]);
/*      */               signOut();
/*      */               if (paramObjectConsumer != null) {
/*      */                 paramObjectConsumer.accept((new SignInResponse(SignInResult.OTHER_ERROR)).setErrorMessage("Request failed"));
/*      */               }
/*      */             } 
/*      */           }));
/*      */   }
/*      */ 
/*      */   
/*      */   public void getCloudSavedGamesList(ObjectConsumer<JsonValue> paramObjectConsumer)
/*      */   {
/* 1951 */     if (Config.isHeadless())
/*      */       return; 
/* 1953 */     if (this.c != SignInStatus.SIGNED_IN) {
/* 1954 */       b.e("unable to load list of cloud saved games while not signed in", new Object[0]);
/* 1955 */       if (paramObjectConsumer != null) paramObjectConsumer.accept(null);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 1960 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GET_SAVED_GAMES_LIST_URL);
/* 1961 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 1962 */     if (getSessionId() == null) {
/* 1963 */       throw new RuntimeException("sessionId is null");
/*      */     }
/* 1965 */     hashMap.put("sessionid", getSessionId());
/* 1966 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 1968 */     queueRequest(new HttpQueuedRequest("getCloudSavedGamesList", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b())
/*      */                   b.i("Response: " + paramString, new Object[0]);  JsonValue jsonValue; if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   if (paramObjectConsumer != null) {
/*      */                     paramObjectConsumer.accept(jsonValue.get("savedGames"));
/*      */                   } else {
/*      */                     return;
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("failed to load saved games: " + paramString, new Object[0]); if (paramObjectConsumer != null)
/*      */                     paramObjectConsumer.accept(null);  return;
/*      */                 } 
/* 1982 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 if (paramObjectConsumer != null)
/*      */                   paramObjectConsumer.accept(null); 
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to get cloud saves", new Object[0]);
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(null); 
/*      */             } 
/*      */           })); } public void setAutoSavesEnabled(boolean paramBoolean) {
/* 1994 */     if ((SettingsPrefs.i()).auth.autoSavesEnabled != paramBoolean) {
/* 1995 */       (SettingsPrefs.i()).auth.autoSavesEnabled = paramBoolean;
/* 1996 */       SettingsPrefs.i().requireSave();
/*      */       
/* 1998 */       this.a.begin();
/* 1999 */       for (byte b = 0; b < this.a.size; b++) {
/* 2000 */         ((AuthManagerListener)this.a.get(b)).autoSaveModeChanged();
/*      */       }
/* 2002 */       this.a.end();
/*      */       
/* 2004 */       if (paramBoolean) {
/* 2005 */         Notifications.i().add(Game.i.localeManager.i18n.get("auto_saves_enabled"), (Drawable)Game.i.assetManager.getDrawable("icon-info"), MaterialColor.GREEN.P800, StaticSoundType.NOTIFICATION); return;
/*      */       } 
/* 2007 */       Notifications.i().add(Game.i.localeManager.i18n.get("auto_saves_disabled"), (Drawable)Game.i.assetManager.getDrawable("icon-info"), MaterialColor.AMBER.P800, StaticSoundType.NOTIFICATION);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAutoSavesEnabled() {
/* 2013 */     if (Game.i.progressManager.isDeveloperModeEnabled()) {
/* 2014 */       return false;
/*      */     }
/* 2016 */     return (SettingsPrefs.i()).auth.autoSavesEnabled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void signUp(String paramString1, String paramString2, String paramString3, String paramString4, ObjectConsumer<SignUpResult> paramObjectConsumer) {
/* 2027 */     if (Config.isHeadless())
/*      */       return; 
/* 2029 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 2030 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/*      */     Net.HttpRequest httpRequest;
/* 2035 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.AUTH_SIGN_UP_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 2038 */     (hashMap = new HashMap<>()).put("login", paramString1);
/* 2039 */     hashMap.put("password", paramString2);
/* 2040 */     hashMap.put("email", paramString3);
/* 2041 */     hashMap.put("inviteCode", paramString4);
/*      */     
/* 2043 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */     
/* 2045 */     queueRequest(new HttpQueuedRequest("signUp", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b()) {
/*      */                   b.i("Response: " + paramString, new Object[0]);
/*      */                 }
/*      */                 
/*      */                 JsonValue jsonValue;
/*      */                 
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   Game.i.analyticsManager.logSignedUp("password");
/*      */                   
/*      */                   loadStateFromServer(jsonValue.getString("sessionid"), ());
/*      */                 } else {
/*      */                   b.e("failed to sign up: " + paramString, new Object[0]);
/*      */                   
/*      */                   signOut();
/*      */                   
/*      */                   if (paramObjectConsumer != null)
/*      */                   { 
/*      */                     try { paramObjectConsumer.accept(SignUpResult.valueOf(jsonValue.getString("signUpResult"))); }
/* 2066 */                     catch (Exception exception) { paramObjectConsumer.accept(SignUpResult.OTHER_ERROR); return; }
/*      */                      }
/*      */                   else { return; }
/*      */                 
/*      */                 } 
/* 2071 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 signOut();
/*      */                 if (paramObjectConsumer != null) {
/*      */                   paramObjectConsumer.accept(SignUpResult.OTHER_ERROR);
/*      */                 }
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("Failed to sign up", new Object[0]);
/*      */               signOut();
/*      */               if (paramObjectConsumer != null)
/*      */                 paramObjectConsumer.accept(SignUpResult.OTHER_ERROR); 
/*      */             } 
/*      */           }));
/*      */   }
/*      */   
/*      */   public void signUpWithGoogle(String paramString1, String paramString2, ObjectConsumer<SignUpResult> paramObjectConsumer) {
/* 2089 */     Preconditions.checkNotNull(paramString1, "nickname can not be null");
/* 2090 */     Preconditions.checkNotNull(paramObjectConsumer, "callback can not be null");
/*      */     
/* 2092 */     if (Config.isHeadless())
/*      */       return; 
/* 2094 */     if (Game.i.actionResolver.isAppModified() || Config.isModdingMode()) {
/* 2095 */       Notifications.i().add(Game.i.localeManager.i18n.get("app_is_modified"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*      */       
/*      */       return;
/*      */     } 
/* 2099 */     Game.i.actionResolver.requestGoogleAuth(paramString3 -> {
/*      */           if (paramString3 == null) {
/*      */             b.e("failed to get Google auth ticket", new Object[0]);
/*      */             paramObjectConsumer.accept(SignUpResult.OTHER_ERROR);
/*      */             return;
/*      */           } 
/*      */           Game.i.httpManager.post(Config.AUTH_SIGN_UP_GOOGLE_URL).param("ticket", paramString3).param("nickname", paramString1).param("inviteCode", paramString2).listener(()).send();
/*      */         });
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
/*      */   public void getNews(ObjectConsumer<NewsResponse> paramObjectConsumer) {
/* 2150 */     if (Config.isHeadless())
/*      */       return; 
/* 2152 */     Game.i.assertInMainThread();
/*      */     
/* 2154 */     if (this.e != null) {
/*      */       
/* 2156 */       if (Game.getTimestampSeconds() - this.e.cachedAt < 600) {
/* 2157 */         paramObjectConsumer.accept(this.e);
/*      */         return;
/*      */       } 
/* 2160 */       this.e = null;
/*      */     } 
/*      */ 
/*      */     
/* 2164 */     this.d.add(paramObjectConsumer);
/*      */   }
/*      */   
/*      */   public void receiveIssuedItemsFromServer(ObjectConsumer<ReceivedIssuedItemsResponse> paramObjectConsumer) {
/* 2168 */     if (Config.isHeadless() || getSessionId() == null)
/*      */       return; 
/* 2170 */     Game.i.assertInMainThread();
/*      */     
/*      */     Net.HttpRequest httpRequest;
/* 2173 */     (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.RECEIVE_ISSUED_ITEMS_URL);
/*      */     
/*      */     HashMap<Object, Object> hashMap;
/* 2176 */     (hashMap = new HashMap<>()).put("sessionid", getSessionId());
/* 2177 */     httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*      */ 
/*      */     
/* 2180 */     if (this.e != null) {
/* 2181 */       this.e.itemsFromServer.clear();
/*      */     }
/*      */     
/* 2184 */     queueRequest(new HttpQueuedRequest("receiveIssuedItemsFromServer", httpRequest, (paramBoolean, paramString) -> {
/*      */             if (paramBoolean) {
/*      */               try {
/*      */                 if (b()) {
/*      */                   b.i(paramString, new Object[0]);
/*      */                 }
/*      */                 JsonValue jsonValue;
/*      */                 if ((jsonValue = (new JsonReader()).parse(paramString)).getString("status").equals("success")) {
/*      */                   try {
/*      */                     ReceivedIssuedItemsResponse receivedIssuedItemsResponse = new ReceivedIssuedItemsResponse(this);
/*      */                     if ((jsonValue = jsonValue.get("issuedItems")) != null) {
/*      */                       JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator();
/*      */                       while (jsonIterator.hasNext()) {
/*      */                         JsonValue jsonValue1 = jsonIterator.next();
/*      */                         receivedIssuedItemsResponse.items.add(IssuedItems.fromJson(jsonValue1));
/*      */                       } 
/*      */                     } 
/*      */                     paramObjectConsumer.accept(receivedIssuedItemsResponse);
/* 2202 */                   } catch (Exception exception) {
/*      */                     b.e("failed to parse receiveIssuedItemsFromServer", new Object[] { exception });
/*      */                   } 
/*      */                 } else {
/*      */                   b.e("can't retrieve receiveIssuedItemsFromServer: " + exception, new Object[0]);
/*      */                   return;
/*      */                 } 
/* 2209 */               } catch (Exception exception) {
/*      */                 b.e("Failed to parse response", new Object[] { exception });
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               b.e("can't retrieve receiveIssuedItemsFromServer", new Object[0]);
/*      */             } 
/*      */           }));
/*      */   }
/*      */   
/*      */   public static interface AuthManagerListener {
/*      */     void signInStatusUpdated();
/*      */     
/*      */     void autoSaveModeChanged();
/*      */     
/*      */     void stateUpdated();
/*      */     
/*      */     public static abstract class AuthManagerListenerAdapter
/*      */       implements AuthManagerListener {
/*      */       public void signInStatusUpdated() {}
/*      */       
/*      */       public void autoSaveModeChanged() {}
/*      */       
/*      */       public void stateUpdated() {}
/*      */     }
/*      */   }
/*      */   
/*      */   public static class NewsResponse {
/*      */     public int id;
/*      */     public String title;
/*      */     public String body;
/*      */     public int networkRequiredVersion;
/*      */     public int lastVersion;
/* 2242 */     public int seasonNumber = 1;
/*      */     
/*      */     public int seasonPosition;
/*      */     public int seasonPlayerCount;
/* 2246 */     public Array<IssuedItems> itemsFromServer = new Array(IssuedItems.class);
/*      */     public int cachedAt; }
/*      */   
/*      */   public class ReceivedIssuedItemsResponse { public Array<IssuedItems> items;
/*      */     
/*      */     public ReceivedIssuedItemsResponse(AuthManager this$0) {
/* 2252 */       this.items = new Array(IssuedItems.class);
/*      */     } }
/*      */   
/*      */   public static class HttpQueuedRequest {
/*      */     private String a;
/*      */     private Net.HttpRequest b;
/*      */     private Listener c;
/*      */     
/*      */     public HttpQueuedRequest(String param1String, Net.HttpRequest param1HttpRequest, Listener param1Listener) {
/* 2261 */       this.a = param1String;
/* 2262 */       this.b = param1HttpRequest;
/* 2263 */       this.c = param1Listener;
/*      */     }
/*      */     
/*      */     public static interface Listener {
/*      */       void finished(boolean param2Boolean, String param2String);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ProfileStatus {
/*      */     public String id;
/*      */     public int receivedAt;
/*      */     public int expiresAt;
/*      */     public String reason;
/*      */   }
/*      */   
/*      */   public static class PasteBinResponse {
/*      */     public boolean success;
/*      */     public String errorDescription;
/*      */     public String link;
/*      */     
/*      */     public PasteBinResponse() {}
/*      */     
/*      */     public PasteBinResponse(boolean param1Boolean, String param1String1, String param1String2) {
/* 2286 */       this.success = param1Boolean;
/* 2287 */       this.errorDescription = param1String1;
/* 2288 */       this.link = param1String2;
/*      */     } }
/*      */   
/*      */   public static class SignInResponse { public AuthManager.SignInResult result;
/*      */     public String otpRequestId;
/*      */     @Null
/*      */     public String errorMessage;
/*      */     
/*      */     public SignInResponse() {}
/*      */     
/*      */     public SignInResponse(AuthManager.SignInResult param1SignInResult) {
/* 2299 */       this.result = param1SignInResult;
/*      */     }
/*      */     public SignInResponse(AuthManager.SignInResult param1SignInResult, String param1String) {
/* 2302 */       this.result = param1SignInResult;
/* 2303 */       this.otpRequestId = param1String;
/*      */     }
/*      */     @Null
/*      */     public String getErrorMessage() {
/* 2307 */       return this.errorMessage;
/*      */     }
/*      */     
/*      */     public SignInResponse setErrorMessage(String param1String) {
/* 2311 */       this.errorMessage = param1String;
/* 2312 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   public static interface Listener {
/*      */     void finished(boolean param1Boolean, String param1String);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\AuthManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */