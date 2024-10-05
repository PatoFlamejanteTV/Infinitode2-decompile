/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamHTTPCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamHTTPCallback>
/*    */ {
/*    */   SteamHTTPCallbackAdapter(SteamHTTPCallback paramSteamHTTPCallback) {
/*  7 */     super(paramSteamHTTPCallback);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void onHTTPRequestCompleted(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 13 */     this.callback.onHTTPRequestCompleted(new SteamHTTPRequestHandle(paramLong1), paramLong2, paramBoolean, 
/* 14 */         SteamHTTP.HTTPStatusCode.byValue(paramInt1), paramInt2);
/*    */   }
/*    */   
/*    */   void onHTTPRequestHeadersReceived(long paramLong1, long paramLong2) {
/* 18 */     this.callback.onHTTPRequestHeadersReceived(new SteamHTTPRequestHandle(paramLong1), paramLong2);
/*    */   }
/*    */   
/*    */   void onHTTPRequestDataReceived(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
/* 22 */     this.callback.onHTTPRequestDataReceived(new SteamHTTPRequestHandle(paramLong1), paramLong2, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamHTTPCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */