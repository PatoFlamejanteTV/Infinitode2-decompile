/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamUtils extends SteamInterface {
/*     */   private final SteamUtilsCallbackAdapter callbackAdapter;
/*     */   
/*     */   public enum SteamAPICallFailure {
/*   9 */     None(-1),
/*  10 */     SteamGone(0),
/*  11 */     NetworkFailure(1),
/*  12 */     InvalidHandle(2),
/*  13 */     MismatchedCallback(3); private final int code; static {
/*     */     
/*     */     }
/*  16 */     private static final SteamAPICallFailure[] values = values();
/*     */     
/*     */     SteamAPICallFailure(int param1Int1) {
/*  19 */       this.code = param1Int1; } static SteamAPICallFailure byValue(int param1Int) {
/*     */       SteamAPICallFailure[] arrayOfSteamAPICallFailure;
/*     */       int i;
/*     */       byte b;
/*  23 */       for (i = (arrayOfSteamAPICallFailure = values).length, b = 0; b < i; b++) {
/*  24 */         SteamAPICallFailure steamAPICallFailure; if ((steamAPICallFailure = arrayOfSteamAPICallFailure[b]).code == param1Int) {
/*  25 */           return steamAPICallFailure;
/*     */         }
/*     */       } 
/*  28 */       return None;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum NotificationPosition {
/*  33 */     TopLeft,
/*  34 */     TopRight,
/*  35 */     BottomLeft,
/*  36 */     BottomRight;
/*     */   }
/*     */   
/*     */   public enum FloatingGamepadTextInputMode {
/*  40 */     ModeSingleLine,
/*  41 */     ModeMultipleLines,
/*  42 */     ModeEmail,
/*  43 */     ModeNumeric;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamUtils(SteamUtilsCallback paramSteamUtilsCallback) {
/*  49 */     this.callbackAdapter = new SteamUtilsCallbackAdapter(paramSteamUtilsCallback);
/*  50 */     setCallback(SteamUtilsNative.createCallback(this.callbackAdapter));
/*     */   }
/*     */   
/*     */   public int getSecondsSinceAppActive() {
/*  54 */     return SteamUtilsNative.getSecondsSinceAppActive();
/*     */   }
/*     */   
/*     */   public int getSecondsSinceComputerActive() {
/*  58 */     return SteamUtilsNative.getSecondsSinceComputerActive();
/*     */   }
/*     */   
/*     */   public SteamUniverse getConnectedUniverse() {
/*  62 */     return SteamUniverse.byValue(SteamUtilsNative.getConnectedUniverse());
/*     */   }
/*     */   
/*     */   public int getServerRealTime() {
/*  66 */     return SteamUtilsNative.getServerRealTime();
/*     */   }
/*     */   
/*     */   public int getImageWidth(int paramInt) {
/*  70 */     return SteamUtilsNative.getImageWidth(paramInt);
/*     */   }
/*     */   
/*     */   public int getImageHeight(int paramInt) {
/*  74 */     return SteamUtilsNative.getImageHeight(paramInt);
/*     */   }
/*     */   
/*     */   public boolean getImageSize(int paramInt, int[] paramArrayOfint) {
/*  78 */     return SteamUtilsNative.getImageSize(paramInt, paramArrayOfint);
/*     */   }
/*     */   
/*     */   public boolean getImageRGBA(int paramInt, ByteBuffer paramByteBuffer) {
/*  82 */     checkBuffer(paramByteBuffer);
/*  83 */     return SteamUtilsNative.getImageRGBA(paramInt, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public int getAppID() {
/*  87 */     return SteamUtilsNative.getAppID();
/*     */   }
/*     */   
/*     */   public void setOverlayNotificationPosition(NotificationPosition paramNotificationPosition) {
/*  91 */     SteamUtilsNative.setOverlayNotificationPosition(paramNotificationPosition.ordinal());
/*     */   }
/*     */   
/*     */   public boolean isAPICallCompleted(SteamAPICall paramSteamAPICall, boolean[] paramArrayOfboolean) {
/*  95 */     return SteamUtilsNative.isAPICallCompleted(paramSteamAPICall.handle, paramArrayOfboolean);
/*     */   }
/*     */   
/*     */   public SteamAPICallFailure getAPICallFailureReason(SteamAPICall paramSteamAPICall) {
/*  99 */     return SteamAPICallFailure.byValue(SteamUtilsNative.getAPICallFailureReason(paramSteamAPICall.handle));
/*     */   }
/*     */   
/*     */   public void setWarningMessageHook(SteamAPIWarningMessageHook paramSteamAPIWarningMessageHook) {
/* 103 */     this.callbackAdapter.setWarningMessageHook(paramSteamAPIWarningMessageHook);
/* 104 */     SteamUtilsNative.enableWarningMessageHook(this.callback, (paramSteamAPIWarningMessageHook != null));
/*     */   }
/*     */   
/*     */   public boolean isOverlayEnabled() {
/* 108 */     return SteamUtilsNative.isOverlayEnabled();
/*     */   }
/*     */   
/*     */   public boolean isSteamRunningOnSteamDeck() {
/* 112 */     return SteamUtilsNative.isSteamRunningOnSteamDeck();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean showFloatingGamepadTextInput(FloatingGamepadTextInputMode paramFloatingGamepadTextInputMode, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 118 */     return SteamUtilsNative.showFloatingGamepadTextInput(paramFloatingGamepadTextInputMode.ordinal(), paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dismissFloatingGamepadTextInput() {
/* 123 */     return SteamUtilsNative.dismissFloatingGamepadTextInput();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */