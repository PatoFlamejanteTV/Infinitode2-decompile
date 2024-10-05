/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamScreenshotsCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamScreenshotsCallback>
/*    */ {
/*    */   SteamScreenshotsCallbackAdapter(SteamScreenshotsCallback paramSteamScreenshotsCallback) {
/*  7 */     super(paramSteamScreenshotsCallback);
/*    */   }
/*    */   
/*    */   void onScreenshotReady(int paramInt1, int paramInt2) {
/* 11 */     this.callback.onScreenshotReady(new SteamScreenshotHandle(paramInt1), SteamResult.byValue(paramInt2));
/*    */   }
/*    */   
/*    */   void onScreenshotRequested() {
/* 15 */     this.callback.onScreenshotRequested();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamScreenshotsCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */