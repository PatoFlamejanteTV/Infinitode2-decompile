/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ public class SteamUserStats
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum LeaderboardDataRequest {
/*   7 */     Global,
/*   8 */     GlobalAroundUser,
/*   9 */     Friends,
/*  10 */     Users;
/*     */   }
/*     */   
/*     */   public enum LeaderboardDisplayType {
/*  14 */     None,
/*  15 */     Numeric,
/*  16 */     TimeSeconds,
/*  17 */     TimeMilliSeconds;
/*     */   }
/*     */   
/*     */   public enum LeaderboardSortMethod {
/*  21 */     None,
/*  22 */     Ascending,
/*  23 */     Descending;
/*     */   }
/*     */   
/*     */   public enum LeaderboardUploadScoreMethod {
/*  27 */     None,
/*  28 */     KeepBest,
/*  29 */     ForceUpdate;
/*     */   }
/*     */   
/*     */   public SteamUserStats(SteamUserStatsCallback paramSteamUserStatsCallback) {
/*  33 */     super(SteamUserStatsNative.createCallback(new SteamUserStatsCallbackAdapter(paramSteamUserStatsCallback)));
/*     */   }
/*     */   
/*     */   public boolean requestCurrentStats() {
/*  37 */     return SteamUserStatsNative.requestCurrentStats();
/*     */   }
/*     */   
/*     */   public int getStatI(String paramString, int paramInt) {
/*  41 */     int[] arrayOfInt = new int[1];
/*  42 */     if (SteamUserStatsNative.getStat(paramString, arrayOfInt)) {
/*  43 */       return arrayOfInt[0];
/*     */     }
/*  45 */     return paramInt;
/*     */   }
/*     */   
/*     */   public boolean setStatI(String paramString, int paramInt) {
/*  49 */     return SteamUserStatsNative.setStat(paramString, paramInt);
/*     */   }
/*     */   
/*     */   public float getStatF(String paramString, float paramFloat) {
/*  53 */     float[] arrayOfFloat = new float[1];
/*  54 */     if (SteamUserStatsNative.getStat(paramString, arrayOfFloat)) {
/*  55 */       return arrayOfFloat[0];
/*     */     }
/*  57 */     return paramFloat;
/*     */   }
/*     */   
/*     */   public boolean setStatF(String paramString, float paramFloat) {
/*  61 */     return SteamUserStatsNative.setStat(paramString, paramFloat);
/*     */   }
/*     */   
/*     */   public boolean isAchieved(String paramString, boolean paramBoolean) {
/*  65 */     boolean[] arrayOfBoolean = new boolean[1];
/*  66 */     if (SteamUserStatsNative.getAchievement(paramString, arrayOfBoolean)) {
/*  67 */       return arrayOfBoolean[0];
/*     */     }
/*  69 */     return paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean setAchievement(String paramString) {
/*  73 */     return SteamUserStatsNative.setAchievement(paramString);
/*     */   }
/*     */   
/*     */   public boolean clearAchievement(String paramString) {
/*  77 */     return SteamUserStatsNative.clearAchievement(paramString);
/*     */   }
/*     */   
/*     */   public boolean storeStats() {
/*  81 */     return SteamUserStatsNative.storeStats();
/*     */   }
/*     */   
/*     */   public boolean indicateAchievementProgress(String paramString, int paramInt1, int paramInt2) {
/*  85 */     return SteamUserStatsNative.indicateAchievementProgress(paramString, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public int getNumAchievements() {
/*  89 */     return SteamUserStatsNative.getNumAchievements();
/*     */   }
/*     */   
/*     */   public String getAchievementName(int paramInt) {
/*  93 */     return SteamUserStatsNative.getAchievementName(paramInt);
/*     */   }
/*     */   
/*     */   public boolean resetAllStats(boolean paramBoolean) {
/*  97 */     return SteamUserStatsNative.resetAllStats(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamAPICall findOrCreateLeaderboard(String paramString, LeaderboardSortMethod paramLeaderboardSortMethod, LeaderboardDisplayType paramLeaderboardDisplayType) {
/* 104 */     return new SteamAPICall(SteamUserStatsNative.findOrCreateLeaderboard(this.callback, paramString, paramLeaderboardSortMethod
/* 105 */           .ordinal(), paramLeaderboardDisplayType.ordinal()));
/*     */   }
/*     */   
/*     */   public SteamAPICall findLeaderboard(String paramString) {
/* 109 */     return new SteamAPICall(SteamUserStatsNative.findLeaderboard(this.callback, paramString));
/*     */   }
/*     */   
/*     */   public String getLeaderboardName(SteamLeaderboardHandle paramSteamLeaderboardHandle) {
/* 113 */     return SteamUserStatsNative.getLeaderboardName(paramSteamLeaderboardHandle.handle);
/*     */   }
/*     */   
/*     */   public int getLeaderboardEntryCount(SteamLeaderboardHandle paramSteamLeaderboardHandle) {
/* 117 */     return SteamUserStatsNative.getLeaderboardEntryCount(paramSteamLeaderboardHandle.handle);
/*     */   }
/*     */   
/*     */   public LeaderboardSortMethod getLeaderboardSortMethod(SteamLeaderboardHandle paramSteamLeaderboardHandle) {
/* 121 */     return LeaderboardSortMethod.values()[SteamUserStatsNative.getLeaderboardSortMethod(paramSteamLeaderboardHandle.handle)];
/*     */   }
/*     */   
/*     */   public LeaderboardDisplayType getLeaderboardDisplayType(SteamLeaderboardHandle paramSteamLeaderboardHandle) {
/* 125 */     return LeaderboardDisplayType.values()[SteamUserStatsNative.getLeaderboardDisplayType(paramSteamLeaderboardHandle.handle)];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamAPICall downloadLeaderboardEntries(SteamLeaderboardHandle paramSteamLeaderboardHandle, LeaderboardDataRequest paramLeaderboardDataRequest, int paramInt1, int paramInt2) {
/* 133 */     return new SteamAPICall(SteamUserStatsNative.downloadLeaderboardEntries(this.callback, paramSteamLeaderboardHandle.handle, paramLeaderboardDataRequest
/* 134 */           .ordinal(), paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamAPICall downloadLeaderboardEntriesForUsers(SteamLeaderboardHandle paramSteamLeaderboardHandle, SteamID[] paramArrayOfSteamID) {
/*     */     int i;
/* 141 */     long[] arrayOfLong = new long[i = paramArrayOfSteamID.length];
/*     */     
/* 143 */     for (byte b = 0; b < i; b++) {
/* 144 */       arrayOfLong[b] = (paramArrayOfSteamID[b]).handle;
/*     */     }
/*     */     
/* 147 */     return new SteamAPICall(SteamUserStatsNative.downloadLeaderboardEntriesForUsers(this.callback, paramSteamLeaderboardHandle.handle, arrayOfLong, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDownloadedLeaderboardEntry(SteamLeaderboardEntriesHandle paramSteamLeaderboardEntriesHandle, int paramInt, SteamLeaderboardEntry paramSteamLeaderboardEntry, int[] paramArrayOfint) {
/* 158 */     if (paramArrayOfint == null)
/* 159 */       return SteamUserStatsNative.getDownloadedLeaderboardEntry(paramSteamLeaderboardEntriesHandle.handle, paramInt, paramSteamLeaderboardEntry); 
/* 160 */     return SteamUserStatsNative.getDownloadedLeaderboardEntry(paramSteamLeaderboardEntriesHandle.handle, paramInt, paramSteamLeaderboardEntry, paramArrayOfint, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamAPICall uploadLeaderboardScore(SteamLeaderboardHandle paramSteamLeaderboardHandle, LeaderboardUploadScoreMethod paramLeaderboardUploadScoreMethod, int paramInt, int[] paramArrayOfint) {
/* 170 */     return new SteamAPICall((paramArrayOfint == null) ? 
/* 171 */         SteamUserStatsNative.uploadLeaderboardScore(this.callback, paramSteamLeaderboardHandle.handle, paramLeaderboardUploadScoreMethod.ordinal(), paramInt) : 
/* 172 */         SteamUserStatsNative.uploadLeaderboardScore(this.callback, paramSteamLeaderboardHandle.handle, paramLeaderboardUploadScoreMethod.ordinal(), paramInt, paramArrayOfint, paramArrayOfint.length));
/*     */   }
/*     */   
/*     */   public SteamAPICall getNumberOfCurrentPlayers() {
/* 176 */     return new SteamAPICall(SteamUserStatsNative.getNumberOfCurrentPlayers(this.callback));
/*     */   }
/*     */   
/*     */   public SteamAPICall requestGlobalStats(int paramInt) {
/* 180 */     return new SteamAPICall(SteamUserStatsNative.requestGlobalStats(this.callback, paramInt));
/*     */   }
/*     */   
/*     */   public long getGlobalStat(String paramString, long paramLong) {
/* 184 */     long[] arrayOfLong = new long[1];
/* 185 */     if (SteamUserStatsNative.getGlobalStat(paramString, arrayOfLong)) {
/* 186 */       return arrayOfLong[0];
/*     */     }
/* 188 */     return paramLong;
/*     */   }
/*     */   
/*     */   public double getGlobalStat(String paramString, double paramDouble) {
/* 192 */     double[] arrayOfDouble = new double[1];
/* 193 */     if (SteamUserStatsNative.getGlobalStat(paramString, arrayOfDouble)) {
/* 194 */       return arrayOfDouble[0];
/*     */     }
/* 196 */     return paramDouble;
/*     */   }
/*     */   
/*     */   public int getGlobalStatHistory(String paramString, long[] paramArrayOflong) {
/* 200 */     return SteamUserStatsNative.getGlobalStatHistory(paramString, paramArrayOflong, paramArrayOflong.length);
/*     */   }
/*     */   
/*     */   public int getGlobalStatHistory(String paramString, double[] paramArrayOfdouble) {
/* 204 */     return SteamUserStatsNative.getGlobalStatHistory(paramString, paramArrayOfdouble, paramArrayOfdouble.length);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUserStats.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */