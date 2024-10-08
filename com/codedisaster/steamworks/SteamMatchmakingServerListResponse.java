/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public abstract class SteamMatchmakingServerListResponse
/*    */   extends SteamInterface {
/*    */   public enum Response {
/*  6 */     ServerResponded,
/*  7 */     ServerFailedToRespond,
/*  8 */     NoServersListedOnMasterServer;
/*    */     
/* 10 */     private static final Response[] values = values();
/*    */     
/*    */     static Response byOrdinal(int param1Int) {
/* 13 */       return values[param1Int];
/*    */     } static {
/*    */     
/*    */     } }
/*    */   protected SteamMatchmakingServerListResponse() {
/* 18 */     super(-1L);
/* 19 */     this.callback = createProxy(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void serverResponded(long paramLong, int paramInt) {
/* 25 */     serverResponded(new SteamServerListRequest(paramLong), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void serverFailedToRespond(long paramLong, int paramInt) {
/* 31 */     serverFailedToRespond(new SteamServerListRequest(paramLong), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void refreshComplete(long paramLong, int paramInt) {
/* 37 */     refreshComplete(new SteamServerListRequest(paramLong), Response.byOrdinal(paramInt));
/*    */   }
/*    */   
/*    */   public abstract void serverResponded(SteamServerListRequest paramSteamServerListRequest, int paramInt);
/*    */   
/*    */   public abstract void serverFailedToRespond(SteamServerListRequest paramSteamServerListRequest, int paramInt);
/*    */   
/*    */   public abstract void refreshComplete(SteamServerListRequest paramSteamServerListRequest, Response paramResponse);
/*    */   
/*    */   private static native long createProxy(SteamMatchmakingServerListResponse paramSteamMatchmakingServerListResponse);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamMatchmakingServerListResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */