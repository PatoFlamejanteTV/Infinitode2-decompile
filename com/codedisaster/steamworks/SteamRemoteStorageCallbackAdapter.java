/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ class SteamRemoteStorageCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamRemoteStorageCallback>
/*    */ {
/*    */   SteamRemoteStorageCallbackAdapter(SteamRemoteStorageCallback paramSteamRemoteStorageCallback) {
/*  7 */     super(paramSteamRemoteStorageCallback);
/*    */   }
/*    */   
/*    */   void onFileShareResult(long paramLong, String paramString, int paramInt) {
/* 11 */     this.callback.onFileShareResult(new SteamUGCHandle(paramLong), paramString, 
/* 12 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onDownloadUGCResult(long paramLong, int paramInt) {
/* 16 */     this.callback.onDownloadUGCResult(new SteamUGCHandle(paramLong), SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onPublishFileResult(long paramLong, boolean paramBoolean, int paramInt) {
/* 20 */     this.callback.onPublishFileResult(new SteamPublishedFileID(paramLong), paramBoolean, 
/* 21 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onUpdatePublishedFileResult(long paramLong, boolean paramBoolean, int paramInt) {
/* 25 */     this.callback.onUpdatePublishedFileResult(new SteamPublishedFileID(paramLong), paramBoolean, 
/* 26 */         SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onPublishedFileSubscribed(long paramLong, int paramInt) {
/* 30 */     this.callback.onPublishedFileSubscribed(new SteamPublishedFileID(paramLong), paramInt);
/*    */   }
/*    */   
/*    */   void onPublishedFileUnsubscribed(long paramLong, int paramInt) {
/* 34 */     this.callback.onPublishedFileUnsubscribed(new SteamPublishedFileID(paramLong), paramInt);
/*    */   }
/*    */   
/*    */   void onPublishedFileDeleted(long paramLong, int paramInt) {
/* 38 */     this.callback.onPublishedFileDeleted(new SteamPublishedFileID(paramLong), paramInt);
/*    */   }
/*    */   
/*    */   void onFileWriteAsyncComplete(int paramInt) {
/* 42 */     this.callback.onFileWriteAsyncComplete(SteamResult.byValue(paramInt));
/*    */   }
/*    */   
/*    */   void onFileReadAsyncComplete(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 46 */     this.callback.onFileReadAsyncComplete(new SteamAPICall(paramLong), 
/* 47 */         SteamResult.byValue(paramInt1), paramInt2, paramInt3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamRemoteStorageCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */