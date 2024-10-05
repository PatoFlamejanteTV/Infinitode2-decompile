/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamMatchmakingServers
/*    */   extends SteamInterface
/*    */ {
/*    */   public SteamMatchmakingServers() {
/*  7 */     super(-1L);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestInternetServerList(int paramInt, SteamMatchmakingKeyValuePair[] paramArrayOfSteamMatchmakingKeyValuePair, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 13 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestInternetServerList(paramInt, paramArrayOfSteamMatchmakingKeyValuePair, paramArrayOfSteamMatchmakingKeyValuePair.length, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestLANServerList(int paramInt, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 20 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestLANServerList(paramInt, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestFriendsServerList(int paramInt, SteamMatchmakingKeyValuePair[] paramArrayOfSteamMatchmakingKeyValuePair, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 26 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestFriendsServerList(paramInt, paramArrayOfSteamMatchmakingKeyValuePair, paramArrayOfSteamMatchmakingKeyValuePair.length, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestFavoritesServerList(int paramInt, SteamMatchmakingKeyValuePair[] paramArrayOfSteamMatchmakingKeyValuePair, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 33 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestFavoritesServerList(paramInt, paramArrayOfSteamMatchmakingKeyValuePair, paramArrayOfSteamMatchmakingKeyValuePair.length, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestHistoryServerList(int paramInt, SteamMatchmakingKeyValuePair[] paramArrayOfSteamMatchmakingKeyValuePair, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 40 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestHistoryServerList(paramInt, paramArrayOfSteamMatchmakingKeyValuePair, paramArrayOfSteamMatchmakingKeyValuePair.length, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SteamServerListRequest requestSpectatorServerList(int paramInt, SteamMatchmakingKeyValuePair[] paramArrayOfSteamMatchmakingKeyValuePair, SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse) {
/* 47 */     return new SteamServerListRequest(SteamMatchmakingServersNative.requestSpectatorServerList(paramInt, paramArrayOfSteamMatchmakingKeyValuePair, paramArrayOfSteamMatchmakingKeyValuePair.length, paramSteamMatchmakingServerListResponse.callback));
/*    */   }
/*    */ 
/*    */   
/*    */   public void releaseRequest(SteamServerListRequest paramSteamServerListRequest) {
/* 52 */     SteamMatchmakingServersNative.releaseRequest(paramSteamServerListRequest.handle);
/*    */   }
/*    */   
/*    */   public boolean getServerDetails(SteamServerListRequest paramSteamServerListRequest, int paramInt, SteamMatchmakingGameServerItem paramSteamMatchmakingGameServerItem) {
/* 56 */     return SteamMatchmakingServersNative.getServerDetails(paramSteamServerListRequest.handle, paramInt, paramSteamMatchmakingGameServerItem);
/*    */   }
/*    */   
/*    */   public void cancelQuery(SteamServerListRequest paramSteamServerListRequest) {
/* 60 */     SteamMatchmakingServersNative.cancelQuery(paramSteamServerListRequest.handle);
/*    */   }
/*    */   
/*    */   public void refreshQuery(SteamServerListRequest paramSteamServerListRequest) {
/* 64 */     SteamMatchmakingServersNative.refreshQuery(paramSteamServerListRequest.handle);
/*    */   }
/*    */   
/*    */   public boolean isRefreshing(SteamServerListRequest paramSteamServerListRequest) {
/* 68 */     return SteamMatchmakingServersNative.isRefreshing(paramSteamServerListRequest.handle);
/*    */   }
/*    */   
/*    */   public int getServerCount(SteamServerListRequest paramSteamServerListRequest) {
/* 72 */     return SteamMatchmakingServersNative.getServerCount(paramSteamServerListRequest.handle);
/*    */   }
/*    */   
/*    */   public void refreshServer(SteamServerListRequest paramSteamServerListRequest, int paramInt) {
/* 76 */     SteamMatchmakingServersNative.refreshServer(paramSteamServerListRequest.handle, paramInt);
/*    */   }
/*    */   
/*    */   public SteamServerQuery pingServer(int paramInt, short paramShort, SteamMatchmakingPingResponse paramSteamMatchmakingPingResponse) {
/* 80 */     return new SteamServerQuery(SteamMatchmakingServersNative.pingServer(paramInt, paramShort, paramSteamMatchmakingPingResponse.callback));
/*    */   }
/*    */   
/*    */   public SteamServerQuery playerDetails(int paramInt, short paramShort, SteamMatchmakingPlayersResponse paramSteamMatchmakingPlayersResponse) {
/* 84 */     return new SteamServerQuery(SteamMatchmakingServersNative.playerDetails(paramInt, paramShort, paramSteamMatchmakingPlayersResponse.callback));
/*    */   }
/*    */   
/*    */   public SteamServerQuery serverRules(int paramInt, short paramShort, SteamMatchmakingRulesResponse paramSteamMatchmakingRulesResponse) {
/* 88 */     return new SteamServerQuery(SteamMatchmakingServersNative.serverRules(paramInt, paramShort, paramSteamMatchmakingRulesResponse.callback));
/*    */   }
/*    */   
/*    */   public void cancelServerQuery(SteamServerQuery paramSteamServerQuery) {
/* 92 */     SteamMatchmakingServersNative.cancelServerQuery(paramSteamServerQuery.handle);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamMatchmakingServers.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */