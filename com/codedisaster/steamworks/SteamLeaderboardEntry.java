/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SteamLeaderboardEntry
/*    */ {
/*    */   long steamIDUser;
/*    */   int globalRank;
/*    */   int score;
/*    */   int details;
/*    */   
/*    */   public SteamID getSteamIDUser() {
/* 14 */     return new SteamID(this.steamIDUser);
/*    */   }
/*    */   
/*    */   public int getGlobalRank() {
/* 18 */     return this.globalRank;
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 22 */     return this.score;
/*    */   }
/*    */   
/*    */   public int getNumDetails() {
/* 26 */     return this.details;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamLeaderboardEntry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */