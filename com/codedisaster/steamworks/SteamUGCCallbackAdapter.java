/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamUGCCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamUGCCallback>
/*    */ {
/*    */   SteamUGCCallbackAdapter(SteamUGCCallback paramSteamUGCCallback) {
/*  7 */     super(paramSteamUGCCallback);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void onUGCQueryCompleted(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
/* 13 */     this.callback.onUGCQueryCompleted(new SteamUGCQuery(paramLong), paramInt1, paramInt2, paramBoolean, 
/* 14 */         SteamResult.byValue(paramInt3));
/*    */   }
/*    */   
/*    */   void onSubscribeItem(long paramLong, int paramInt) {
/* 18 */     this.callback.onSubscribeItem(new SteamPublishedFileID(paramLong), SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onUnsubscribeItem(long paramLong, int paramInt) {
/* 22 */     this.callback.onUnsubscribeItem(new SteamPublishedFileID(paramLong), SteamResult.byValue(paramInt));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void onRequestUGCDetails(long paramLong1, int paramInt1, String paramString1, String paramString2, long paramLong2, long paramLong3, String paramString3, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong4, int paramInt4, int paramInt5) {
/*    */     SteamUGCDetails steamUGCDetails;
/* 31 */     (steamUGCDetails = new SteamUGCDetails()).publishedFileID = paramLong1;
/* 32 */     steamUGCDetails.result = paramInt1;
/* 33 */     steamUGCDetails.title = paramString1;
/* 34 */     steamUGCDetails.description = paramString2;
/* 35 */     steamUGCDetails.fileHandle = paramLong2;
/* 36 */     steamUGCDetails.previewFileHandle = paramLong3;
/* 37 */     steamUGCDetails.fileName = paramString3;
/* 38 */     steamUGCDetails.votesUp = paramInt2;
/* 39 */     steamUGCDetails.votesDown = paramInt3;
/* 40 */     steamUGCDetails.ownerID = paramLong4;
/* 41 */     steamUGCDetails.timeCreated = paramInt4;
/* 42 */     steamUGCDetails.timeUpdated = paramInt5;
/*    */     
/* 44 */     this.callback.onRequestUGCDetails(steamUGCDetails, SteamResult.byValue(paramInt1));
/*    */   }
/*    */   
/*    */   void onCreateItem(long paramLong, boolean paramBoolean, int paramInt) {
/* 48 */     this.callback.onCreateItem(new SteamPublishedFileID(paramLong), paramBoolean, SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onSubmitItemUpdate(long paramLong, boolean paramBoolean, int paramInt) {
/* 52 */     this.callback.onSubmitItemUpdate(new SteamPublishedFileID(paramLong), paramBoolean, 
/* 53 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onDownloadItemResult(int paramInt1, long paramLong, int paramInt2) {
/* 57 */     this.callback.onDownloadItemResult(paramInt1, new SteamPublishedFileID(paramLong), SteamResult.byValue(paramInt2));
/*    */   }
/*    */   
/*    */   void onUserFavoriteItemsListChanged(long paramLong, boolean paramBoolean, int paramInt) {
/* 61 */     this.callback.onUserFavoriteItemsListChanged(new SteamPublishedFileID(paramLong), paramBoolean, 
/* 62 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onSetUserItemVote(long paramLong, boolean paramBoolean, int paramInt) {
/* 66 */     this.callback.onSetUserItemVote(new SteamPublishedFileID(paramLong), paramBoolean, SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onGetUserItemVote(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {
/* 70 */     this.callback.onGetUserItemVote(new SteamPublishedFileID(paramLong), paramBoolean1, paramBoolean2, paramBoolean3, 
/* 71 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onStartPlaytimeTracking(int paramInt) {
/* 75 */     this.callback.onStartPlaytimeTracking(SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onStopPlaytimeTracking(int paramInt) {
/* 79 */     this.callback.onStopPlaytimeTracking(SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onStopPlaytimeTrackingForAllItems(int paramInt) {
/* 83 */     this.callback.onStopPlaytimeTrackingForAllItems(SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onDeleteItem(long paramLong, int paramInt) {
/* 87 */     this.callback.onDeleteItem(new SteamPublishedFileID(paramLong), SteamResult.byValue(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUGCCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */