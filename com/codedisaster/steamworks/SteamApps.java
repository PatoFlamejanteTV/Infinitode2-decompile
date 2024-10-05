/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SteamApps
/*    */   extends SteamInterface
/*    */ {
/*    */   public boolean isSubscribed() {
/* 11 */     return SteamAppsNative.isSubscribed();
/*    */   }
/*    */   
/*    */   public boolean isLowViolence() {
/* 15 */     return SteamAppsNative.isLowViolence();
/*    */   }
/*    */   
/*    */   public boolean isCybercafe() {
/* 19 */     return SteamAppsNative.isCybercafe();
/*    */   }
/*    */   
/*    */   public boolean isVACBanned() {
/* 23 */     return SteamAppsNative.isVACBanned();
/*    */   }
/*    */   
/*    */   public String getCurrentGameLanguage() {
/* 27 */     return SteamAppsNative.getCurrentGameLanguage();
/*    */   }
/*    */   
/*    */   public String getAvailableGameLanguages() {
/* 31 */     return SteamAppsNative.getAvailableGameLanguages();
/*    */   }
/*    */   
/*    */   public boolean isSubscribedApp(int paramInt) {
/* 35 */     return SteamAppsNative.isSubscribedApp(paramInt);
/*    */   }
/*    */   
/*    */   public boolean isDlcInstalled(int paramInt) {
/* 39 */     return SteamAppsNative.isDlcInstalled(paramInt);
/*    */   }
/*    */   
/*    */   public int getEarliestPurchaseUnixTime(int paramInt) {
/* 43 */     return SteamAppsNative.getEarliestPurchaseUnixTime(paramInt);
/*    */   }
/*    */   
/*    */   public boolean isSubscribedFromFreeWeekend() {
/* 47 */     return SteamAppsNative.isSubscribedFromFreeWeekend();
/*    */   }
/*    */   
/*    */   public int getDLCCount() {
/* 51 */     return SteamAppsNative.getDLCCount();
/*    */   }
/*    */   
/*    */   public void installDLC(int paramInt) {
/* 55 */     SteamAppsNative.installDLC(paramInt);
/*    */   }
/*    */   
/*    */   public void uninstallDLC(int paramInt) {
/* 59 */     SteamAppsNative.uninstallDLC(paramInt);
/*    */   }
/*    */   
/*    */   public SteamID getAppOwner() {
/* 63 */     return new SteamID(SteamAppsNative.getAppOwner());
/*    */   }
/*    */   
/*    */   public int getAppBuildId() {
/* 67 */     return SteamAppsNative.getAppBuildId();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamApps.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */