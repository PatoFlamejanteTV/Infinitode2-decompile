/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamNetworkingCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamNetworkingCallback>
/*    */ {
/*    */   SteamNetworkingCallbackAdapter(SteamNetworkingCallback paramSteamNetworkingCallback) {
/*  7 */     super(paramSteamNetworkingCallback);
/*    */   }
/*    */   
/*    */   void onP2PSessionConnectFail(long paramLong, int paramInt) {
/* 11 */     SteamID steamID = new SteamID(paramLong);
/* 12 */     this.callback.onP2PSessionConnectFail(steamID, SteamNetworking.P2PSessionError.byOrdinal(paramInt));
/*    */   }
/*    */   
/*    */   void onP2PSessionRequest(long paramLong) {
/* 16 */     SteamID steamID = new SteamID(paramLong);
/* 17 */     this.callback.onP2PSessionRequest(steamID);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamNetworkingCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */