/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamAPICall
/*    */   extends SteamNativeHandle {
/*    */   SteamAPICall(long paramLong) {
/*  6 */     super(paramLong);
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 10 */     return (this.handle != 0L);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamAPICall.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */