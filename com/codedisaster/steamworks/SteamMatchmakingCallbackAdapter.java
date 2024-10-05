/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ 
/*    */ class SteamMatchmakingCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamMatchmakingCallback>
/*    */ {
/*  7 */   private static final SteamMatchmaking.ChatMemberStateChange[] stateChangeValues = SteamMatchmaking.ChatMemberStateChange.values();
/*    */   
/*    */   SteamMatchmakingCallbackAdapter(SteamMatchmakingCallback paramSteamMatchmakingCallback) {
/* 10 */     super(paramSteamMatchmakingCallback);
/*    */   }
/*    */   
/*    */   void onFavoritesListChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6) {
/* 14 */     this.callback.onFavoritesListChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramInt6);
/*    */   }
/*    */   
/*    */   void onLobbyInvite(long paramLong1, long paramLong2, long paramLong3) {
/* 18 */     this.callback.onLobbyInvite(new SteamID(paramLong1), new SteamID(paramLong2), paramLong3);
/*    */   }
/*    */   
/*    */   void onLobbyEnter(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2) {
/* 22 */     this.callback.onLobbyEnter(new SteamID(paramLong), paramInt1, paramBoolean, 
/* 23 */         SteamMatchmaking.ChatRoomEnterResponse.byValue(paramInt2));
/*    */   }
/*    */   
/*    */   void onLobbyDataUpdate(long paramLong1, long paramLong2, boolean paramBoolean) {
/* 27 */     this.callback.onLobbyDataUpdate(new SteamID(paramLong1), new SteamID(paramLong2), paramBoolean);
/*    */   }
/*    */   
/*    */   void onLobbyChatUpdate(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/* 31 */     SteamID steamID1 = new SteamID(paramLong1);
/* 32 */     SteamID steamID2 = new SteamID(paramLong2);
/* 33 */     SteamID steamID3 = new SteamID(paramLong3); SteamMatchmaking.ChatMemberStateChange[] arrayOfChatMemberStateChange; int i; byte b;
/* 34 */     for (i = (arrayOfChatMemberStateChange = stateChangeValues).length, b = 0; b < i; b++) {
/* 35 */       SteamMatchmaking.ChatMemberStateChange chatMemberStateChange; if (SteamMatchmaking.ChatMemberStateChange.isSet(chatMemberStateChange = arrayOfChatMemberStateChange[b], paramInt)) {
/* 36 */         this.callback.onLobbyChatUpdate(steamID1, steamID2, steamID3, chatMemberStateChange);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void onLobbyChatMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
/* 42 */     this.callback.onLobbyChatMessage(new SteamID(paramLong1), new SteamID(paramLong2), 
/* 43 */         SteamMatchmaking.ChatEntryType.byValue(paramInt1), paramInt2);
/*    */   }
/*    */   
/*    */   void onLobbyGameCreated(long paramLong1, long paramLong2, int paramInt, short paramShort) {
/* 47 */     this.callback.onLobbyGameCreated(new SteamID(paramLong1), new SteamID(paramLong2), paramInt, paramShort);
/*    */   }
/*    */   
/*    */   void onLobbyMatchList(int paramInt) {
/* 51 */     this.callback.onLobbyMatchList(paramInt);
/*    */   }
/*    */   
/*    */   void onLobbyKicked(long paramLong1, long paramLong2, boolean paramBoolean) {
/* 55 */     this.callback.onLobbyKicked(new SteamID(paramLong1), new SteamID(paramLong2), paramBoolean);
/*    */   }
/*    */   
/*    */   void onLobbyCreated(int paramInt, long paramLong) {
/* 59 */     this.callback.onLobbyCreated(SteamResult.byValue(paramInt), new SteamID(paramLong));
/*    */   }
/*    */   
/*    */   void onFavoritesListAccountsUpdated(int paramInt) {
/* 63 */     this.callback.onFavoritesListAccountsUpdated(SteamResult.byValue(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamMatchmakingCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */