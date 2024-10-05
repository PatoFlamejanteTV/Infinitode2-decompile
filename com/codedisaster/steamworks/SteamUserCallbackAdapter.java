/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamUserCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamUserCallback>
/*    */ {
/*    */   SteamUserCallbackAdapter(SteamUserCallback paramSteamUserCallback) {
/*  7 */     super(paramSteamUserCallback);
/*    */   }
/*    */   
/*    */   void onAuthSessionTicket(long paramLong, int paramInt) {
/* 11 */     this.callback.onAuthSessionTicket(new SteamAuthTicket(paramLong), SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onValidateAuthTicket(long paramLong1, int paramInt, long paramLong2) {
/* 15 */     this.callback.onValidateAuthTicket(new SteamID(paramLong1), 
/* 16 */         SteamAuth.AuthSessionResponse.byOrdinal(paramInt), new SteamID(paramLong2));
/*    */   }
/*    */   
/*    */   void onMicroTxnAuthorization(int paramInt, long paramLong, boolean paramBoolean) {
/* 20 */     this.callback.onMicroTxnAuthorization(paramInt, paramLong, paramBoolean);
/*    */   }
/*    */   
/*    */   void onEncryptedAppTicket(int paramInt) {
/* 24 */     this.callback.onEncryptedAppTicket(SteamResult.byValue(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUserCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */