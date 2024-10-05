/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamUtilsCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamUtilsCallback>
/*    */ {
/*    */   private SteamAPIWarningMessageHook messageHook;
/*    */   
/*    */   SteamUtilsCallbackAdapter(SteamUtilsCallback paramSteamUtilsCallback) {
/*  9 */     super(paramSteamUtilsCallback);
/*    */   }
/*    */   
/*    */   void setWarningMessageHook(SteamAPIWarningMessageHook paramSteamAPIWarningMessageHook) {
/* 13 */     this.messageHook = paramSteamAPIWarningMessageHook;
/*    */   }
/*    */   
/*    */   void onWarningMessage(int paramInt, String paramString) {
/* 17 */     if (this.messageHook != null) {
/* 18 */       this.messageHook.onWarningMessage(paramInt, paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   void onSteamShutdown() {
/* 23 */     this.callback.onSteamShutdown();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUtilsCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */