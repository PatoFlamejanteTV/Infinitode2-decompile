/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamUserStatsCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamUserStatsCallback>
/*    */ {
/*    */   SteamUserStatsCallbackAdapter(SteamUserStatsCallback paramSteamUserStatsCallback) {
/*  7 */     super(paramSteamUserStatsCallback);
/*    */   }
/*    */   
/*    */   void onUserStatsReceived(long paramLong1, long paramLong2, int paramInt) {
/* 11 */     this.callback.onUserStatsReceived(paramLong1, new SteamID(paramLong2), SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onUserStatsStored(long paramLong, int paramInt) {
/* 15 */     this.callback.onUserStatsStored(paramLong, SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onUserStatsUnloaded(long paramLong) {
/* 19 */     this.callback.onUserStatsUnloaded(new SteamID(paramLong));
/*    */   }
/*    */ 
/*    */   
/*    */   void onUserAchievementStored(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
/* 24 */     this.callback.onUserAchievementStored(paramLong, paramBoolean, paramString, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   void onLeaderboardFindResult(long paramLong, boolean paramBoolean) {
/* 28 */     this.callback.onLeaderboardFindResult(new SteamLeaderboardHandle(paramLong), paramBoolean);
/*    */   }
/*    */   
/*    */   void onLeaderboardScoresDownloaded(long paramLong1, long paramLong2, int paramInt) {
/* 32 */     this.callback.onLeaderboardScoresDownloaded(new SteamLeaderboardHandle(paramLong1), new SteamLeaderboardEntriesHandle(paramLong2), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void onLeaderboardScoreUploaded(boolean paramBoolean1, long paramLong, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3) {
/* 38 */     this.callback.onLeaderboardScoreUploaded(paramBoolean1, new SteamLeaderboardHandle(paramLong), paramInt1, paramBoolean2, paramInt2, paramInt3);
/*    */   }
/*    */ 
/*    */   
/*    */   void onNumberOfCurrentPlayersReceived(boolean paramBoolean, int paramInt) {
/* 43 */     this.callback.onNumberOfCurrentPlayersReceived(paramBoolean, paramInt);
/*    */   }
/*    */   
/*    */   void onGlobalStatsReceived(long paramLong, int paramInt) {
/* 47 */     this.callback.onGlobalStatsReceived(paramLong, SteamResult.byValue(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUserStatsCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */