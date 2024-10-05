/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.net.HttpParametersUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS(serializer = SecretCodeManager.Serializer.class)
/*     */ public class SecretCodeManager
/*     */   extends Manager.ManagerAdapter {
/*  27 */   private static final TLog a = TLog.forClass(SecretCodeManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<SecretCodeManager> {
/*     */     public SecretCodeManager read() {
/*  31 */       return Game.i.secretCodeManager;
/*     */     } }
/*     */   
/*     */   public enum CodeValidationResultCode {
/*  35 */     NOT_EXISTS,
/*  36 */     APPLIED,
/*  37 */     ALREADY_USED,
/*  38 */     PROCESSING,
/*  39 */     ERROR,
/*  40 */     GAME_BUILD_MISMATCH;
/*     */   }
/*     */   
/*     */   public boolean isBuildCompatible(int paramInt) {
/*  44 */     if (207 < paramInt) {
/*  45 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  49 */     if (paramInt < 18) {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public void applyCode(String paramString) {
/*  57 */     if (Config.isHeadless())
/*     */       return; 
/*  59 */     if (paramString.equals("unlocklocales")) {
/*  60 */       Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UNLOCK_ALL_LOCALES, 1.0D);
/*  61 */       Dialog.i().showAlert("All locales unlocked");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  66 */     if (!paramString.matches("[A-Za-z0-9]+")) {
/*  67 */       Dialog.i().showAlert(Game.i.localeManager.i18n.get("code_not_exists"));
/*     */       
/*     */       return;
/*     */     } 
/*  71 */     paramString = paramString.toLowerCase(Locale.ENGLISH);
/*     */     
/*     */     try {
/*  74 */       if (a(paramString)) {
/*     */         
/*  76 */         Dialog.i().showAlert(Game.i.localeManager.i18n.get("code_already_used"));
/*     */       } else {
/*     */         try {
/*     */           Net.HttpRequest httpRequest;
/*     */ 
/*     */ 
/*     */           
/*  83 */           (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.SECRET_CODE_APPLICATION_URL);
/*     */           
/*     */           HashMap<Object, Object> hashMap;
/*  86 */           (hashMap = new HashMap<>()).put("code", paramString);
/*  87 */           hashMap.put("playerid", Game.i.authManager.getPlayerId());
/*  88 */           if (Game.i.authManager.getSessionId() != null) {
/*  89 */             hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*     */           }
/*  91 */           hashMap.put("locale", Game.i.localeManager.getLocale());
/*     */           
/*  93 */           httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*  94 */           Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this, paramString) {
/*     */                 public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*     */                   try {
/*  97 */                     String str = param1HttpResponse.getResultAsString();
/*  98 */                     SecretCodeManager.a().i(str, new Object[0]);
/*     */                     
/* 100 */                     Threads.i().runOnMainThread(() -> {
/*     */                           try {
/*     */                             JsonValue jsonValue;
/*     */                             
/*     */                             if ((jsonValue = (new JsonReader()).parse(param1String1)).getString("status").equals("success")) {
/*     */                               int i = jsonValue.getInt("build");
/*     */                               
/*     */                               if (this.b.isBuildCompatible(i)) {
/*     */                                 SecretCodeManager.a(this.b, param1String2);
/*     */                                 
/*     */                                 JsonValue jsonValue1 = jsonValue.get("contents");
/*     */                                 
/*     */                                 Array array2 = new Array();
/*     */                                 
/*     */                                 JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator();
/*     */                                 
/*     */                                 while (jsonIterator.hasNext()) {
/*     */                                   JsonValue jsonValue2;
/*     */                                   
/*     */                                   ItemStack itemStack = ItemStack.fromJson(jsonValue2 = jsonIterator.next());
/*     */                                   
/*     */                                   Game.i.progressManager.addItemStack(itemStack, "secret_code");
/*     */                                   
/*     */                                   array2.add(itemStack);
/*     */                                 } 
/*     */                                 
/*     */                                 Array array1 = new Array();
/*     */                                 
/*     */                                 for (byte b = 0; b < array2.size; b++) {
/*     */                                   ItemStack itemStack = (ItemStack)array2.get(b);
/*     */                                   
/*     */                                   boolean bool = false;
/*     */                                   for (byte b1 = 0; b1 < array1.size; b1++) {
/*     */                                     if (((ItemStack)array1.get(b1)).getItem().sameAs(itemStack.getItem())) {
/*     */                                       ((ItemStack)array1.get(b1)).setCount(PMath.addWithoutOverflow(((ItemStack)array1.get(b1)).getCount(), itemStack.getCount()));
/*     */                                       bool = true;
/*     */                                       break;
/*     */                                     } 
/*     */                                   } 
/*     */                                   if (!bool) {
/*     */                                     array1.add(new ItemStack(itemStack));
/*     */                                   }
/*     */                                 } 
/*     */                                 IssuedItems issuedItems;
/*     */                                 (issuedItems = new IssuedItems(IssuedItems.IssueReason.SECRET_CODE, Game.getTimestampSeconds())).items.addAll(array1);
/*     */                                 issuedItems.secretCode = param1String2;
/*     */                                 issuedItems.secretCodeDescription = jsonValue.getString("message", "Success!");
/*     */                                 Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*     */                                 Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*     */                                 Game.i.analyticsManager.logCustomEvent("secret_code", new String[0], (Object[])new String[] { "code", param1String2 });
/*     */                               } else {
/*     */                                 Dialog.i().showAlert(Game.i.localeManager.i18n.get("code_is_deprecated"));
/*     */                                 return;
/*     */                               } 
/*     */                             } else {
/*     */                               Threads.i().runOnMainThread(());
/*     */                             } 
/*     */                             return;
/* 158 */                           } catch (Throwable throwable) {
/*     */                             SecretCodeManager.a().e("Exception: " + throwable.getMessage(), new Object[] { throwable });
/*     */                             
/*     */                             Threads.i().runOnMainThread(());
/*     */                           } 
/*     */                         });
/*     */                     return;
/* 165 */                   } catch (Exception exception) {
/* 166 */                     SecretCodeManager.a().e("Exception: " + exception.getMessage(), new Object[] { exception });
/*     */                     return;
/*     */                   } 
/*     */                 } public void failed(Throwable param1Throwable) {
/* 170 */                   SecretCodeManager.a().i("Error redeeming secret code: " + param1Throwable.getMessage(), new Object[0]);
/* 171 */                   Threads.i().runOnMainThread(() -> Dialog.i().showAlert("Error, please try again later"));
/*     */                 }
/*     */                 public void cancelled() {
/* 174 */                   SecretCodeManager.a().i("Timeout while redeeming secret code", new Object[0]);
/* 175 */                   Threads.i().runOnMainThread(() -> Dialog.i().showAlert("Error, please try again later"));
/*     */                 }
/*     */               });
/* 178 */         } catch (Exception exception) {
/*     */           
/* 180 */           a.e("Failed", new Object[] { exception });
/* 181 */           Dialog.i().showAlert("Error, please try again later"); return;
/*     */         } 
/*     */       } 
/* 184 */     } catch (Exception exception) {
/*     */       
/* 186 */       Dialog.i().showAlert(Game.i.localeManager.i18n.get("code_not_exists"));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean a(String paramString) {
/* 191 */     return (ProgressPrefs.i()).secretCode.isCodeApplied(paramString);
/*     */   } public static class CodeValidationResult {
/*     */     public String message; public Array<ItemStack> contents; public SecretCodeManager.CodeValidationResultCode code; }
/*     */   private void b(String paramString) {
/* 195 */     if (a(paramString))
/*     */       return; 
/* 197 */     (ProgressPrefs.i()).secretCode.setCodeApplied(paramString);
/* 198 */     ProgressPrefs.i().requireSave();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\SecretCodeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */