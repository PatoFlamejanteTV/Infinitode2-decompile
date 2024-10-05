package com.codedisaster.steamworks;

public interface SteamRemoteStorageCallback {
  void onFileShareResult(SteamUGCHandle paramSteamUGCHandle, String paramString, SteamResult paramSteamResult);
  
  void onDownloadUGCResult(SteamUGCHandle paramSteamUGCHandle, SteamResult paramSteamResult);
  
  void onPublishFileResult(SteamPublishedFileID paramSteamPublishedFileID, boolean paramBoolean, SteamResult paramSteamResult);
  
  void onUpdatePublishedFileResult(SteamPublishedFileID paramSteamPublishedFileID, boolean paramBoolean, SteamResult paramSteamResult);
  
  void onPublishedFileSubscribed(SteamPublishedFileID paramSteamPublishedFileID, int paramInt);
  
  void onPublishedFileUnsubscribed(SteamPublishedFileID paramSteamPublishedFileID, int paramInt);
  
  void onPublishedFileDeleted(SteamPublishedFileID paramSteamPublishedFileID, int paramInt);
  
  void onFileWriteAsyncComplete(SteamResult paramSteamResult);
  
  void onFileReadAsyncComplete(SteamAPICall paramSteamAPICall, SteamResult paramSteamResult, int paramInt1, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamRemoteStorageCallback.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */