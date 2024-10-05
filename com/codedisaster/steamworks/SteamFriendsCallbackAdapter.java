/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamFriendsCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamFriendsCallback>
/*    */ {
/*  6 */   private static final SteamFriends.PersonaChange[] personaChangeValues = SteamFriends.PersonaChange.values();
/*    */   
/*    */   SteamFriendsCallbackAdapter(SteamFriendsCallback paramSteamFriendsCallback) {
/*  9 */     super(paramSteamFriendsCallback);
/*    */   }
/*    */   
/*    */   void onSetPersonaNameResponse(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 13 */     this.callback.onSetPersonaNameResponse(paramBoolean1, paramBoolean2, SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onPersonaStateChange(long paramLong, int paramInt) {
/* 17 */     SteamID steamID = new SteamID(paramLong); SteamFriends.PersonaChange[] arrayOfPersonaChange; int i; byte b;
/* 18 */     for (i = (arrayOfPersonaChange = personaChangeValues).length, b = 0; b < i; b++) {
/* 19 */       SteamFriends.PersonaChange personaChange; if (SteamFriends.PersonaChange.isSet(personaChange = arrayOfPersonaChange[b], paramInt)) {
/* 20 */         this.callback.onPersonaStateChange(steamID, personaChange);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void onGameOverlayActivated(boolean paramBoolean) {
/* 26 */     this.callback.onGameOverlayActivated(paramBoolean);
/*    */   }
/*    */   
/*    */   void onGameLobbyJoinRequested(long paramLong1, long paramLong2) {
/* 30 */     this.callback.onGameLobbyJoinRequested(new SteamID(paramLong1), new SteamID(paramLong2));
/*    */   }
/*    */   
/*    */   void onAvatarImageLoaded(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 34 */     this.callback.onAvatarImageLoaded(new SteamID(paramLong), paramInt1, paramInt2, paramInt3);
/*    */   }
/*    */   
/*    */   void onFriendRichPresenceUpdate(long paramLong, int paramInt) {
/* 38 */     this.callback.onFriendRichPresenceUpdate(new SteamID(paramLong), paramInt);
/*    */   }
/*    */   
/*    */   void onGameRichPresenceJoinRequested(long paramLong, String paramString) {
/* 42 */     this.callback.onGameRichPresenceJoinRequested(new SteamID(paramLong), paramString);
/*    */   }
/*    */   
/*    */   void onGameServerChangeRequested(String paramString1, String paramString2) {
/* 46 */     this.callback.onGameServerChangeRequested(paramString1, paramString2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamFriendsCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */