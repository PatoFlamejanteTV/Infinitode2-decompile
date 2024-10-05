/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamRemoteStorage
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum RemoteStoragePlatform {
/*   9 */     None(0),
/*  10 */     Windows(1),
/*  11 */     OSX(2),
/*  12 */     PS3(4),
/*  13 */     Linux(8),
/*  14 */     Reserved2(16),
/*  15 */     Android(32),
/*  16 */     IOS(64),
/*     */     
/*  18 */     All(-1);
/*     */     
/*     */     private final int mask;
/*  21 */     private static final RemoteStoragePlatform[] values = values();
/*     */     
/*     */     RemoteStoragePlatform(int param1Int1) {
/*  24 */       this.mask = param1Int1;
/*     */     } static {
/*     */     
/*     */     } static RemoteStoragePlatform[] byMask(int param1Int) {
/*     */       int i;
/*  29 */       RemoteStoragePlatform[] arrayOfRemoteStoragePlatform1 = new RemoteStoragePlatform[i = Integer.bitCount(param1Int)];
/*     */       
/*  31 */       byte b1 = 0; RemoteStoragePlatform[] arrayOfRemoteStoragePlatform2; int j; byte b2;
/*  32 */       for (j = (arrayOfRemoteStoragePlatform2 = values).length, b2 = 0; b2 < j; b2++) {
/*  33 */         RemoteStoragePlatform remoteStoragePlatform; if (((remoteStoragePlatform = arrayOfRemoteStoragePlatform2[b2]).mask & param1Int) != 0) {
/*  34 */           arrayOfRemoteStoragePlatform1[b1++] = remoteStoragePlatform;
/*     */         }
/*     */       } 
/*     */       
/*  38 */       return arrayOfRemoteStoragePlatform1;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum UGCReadAction {
/*  43 */     ContinueReadingUntilFinished,
/*  44 */     ContinueReading,
/*  45 */     Close;
/*     */   }
/*     */   
/*     */   public enum PublishedFileVisibility {
/*  49 */     Public,
/*  50 */     FriendsOnly,
/*  51 */     Private;
/*     */   }
/*     */   
/*     */   public enum WorkshopFileType {
/*  55 */     Community,
/*  56 */     Microtransaction,
/*  57 */     Collection,
/*  58 */     Art,
/*  59 */     Video,
/*  60 */     Screenshot,
/*  61 */     Game,
/*  62 */     Software,
/*  63 */     Concept,
/*  64 */     WebGuide,
/*  65 */     IntegratedGuide,
/*  66 */     Merch,
/*  67 */     ControllerBinding,
/*  68 */     SteamworksAccessInvite,
/*  69 */     SteamVideo,
/*  70 */     GameManagedItem;
/*     */     
/*  72 */     private static final WorkshopFileType[] values = values(); static {
/*     */     
/*     */     } static WorkshopFileType byOrdinal(int param1Int) {
/*  75 */       return values[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public SteamRemoteStorage(SteamRemoteStorageCallback paramSteamRemoteStorageCallback) {
/*  80 */     super(SteamRemoteStorageNative.createCallback(new SteamRemoteStorageCallbackAdapter(paramSteamRemoteStorageCallback)));
/*     */   }
/*     */   
/*     */   public boolean fileWrite(String paramString, ByteBuffer paramByteBuffer) {
/*  84 */     checkBuffer(paramByteBuffer);
/*  85 */     return SteamRemoteStorageNative.fileWrite(paramString, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public int fileRead(String paramString, ByteBuffer paramByteBuffer) {
/*  89 */     checkBuffer(paramByteBuffer);
/*  90 */     return SteamRemoteStorageNative.fileRead(paramString, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public SteamAPICall fileWriteAsync(String paramString, ByteBuffer paramByteBuffer) {
/*  94 */     checkBuffer(paramByteBuffer);
/*  95 */     return new SteamAPICall(SteamRemoteStorageNative.fileWriteAsync(this.callback, paramString, paramByteBuffer, paramByteBuffer
/*  96 */           .position(), paramByteBuffer.remaining()));
/*     */   }
/*     */   
/*     */   public SteamAPICall fileReadAsync(String paramString, int paramInt1, int paramInt2) {
/* 100 */     return new SteamAPICall(SteamRemoteStorageNative.fileReadAsync(this.callback, paramString, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public boolean fileReadAsyncComplete(SteamAPICall paramSteamAPICall, ByteBuffer paramByteBuffer, int paramInt) {
/* 104 */     return SteamRemoteStorageNative.fileReadAsyncComplete(paramSteamAPICall.handle, paramByteBuffer, paramByteBuffer.position(), paramInt);
/*     */   }
/*     */   
/*     */   public boolean fileForget(String paramString) {
/* 108 */     return SteamRemoteStorageNative.fileForget(paramString);
/*     */   }
/*     */   
/*     */   public boolean fileDelete(String paramString) {
/* 112 */     return SteamRemoteStorageNative.fileDelete(paramString);
/*     */   }
/*     */   
/*     */   public SteamAPICall fileShare(String paramString) {
/* 116 */     return new SteamAPICall(SteamRemoteStorageNative.fileShare(this.callback, paramString));
/*     */   }
/*     */   
/*     */   public boolean setSyncPlatforms(String paramString, RemoteStoragePlatform paramRemoteStoragePlatform) {
/* 120 */     return SteamRemoteStorageNative.setSyncPlatforms(paramString, paramRemoteStoragePlatform.mask);
/*     */   }
/*     */   
/*     */   public SteamUGCFileWriteStreamHandle fileWriteStreamOpen(String paramString) {
/* 124 */     return new SteamUGCFileWriteStreamHandle(SteamRemoteStorageNative.fileWriteStreamOpen(paramString));
/*     */   }
/*     */   
/*     */   public boolean fileWriteStreamWriteChunk(SteamUGCFileWriteStreamHandle paramSteamUGCFileWriteStreamHandle, ByteBuffer paramByteBuffer) {
/* 128 */     return SteamRemoteStorageNative.fileWriteStreamWriteChunk(paramSteamUGCFileWriteStreamHandle.handle, paramByteBuffer, paramByteBuffer
/* 129 */         .position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public boolean fileWriteStreamClose(SteamUGCFileWriteStreamHandle paramSteamUGCFileWriteStreamHandle) {
/* 133 */     return SteamRemoteStorageNative.fileWriteStreamClose(paramSteamUGCFileWriteStreamHandle.handle);
/*     */   }
/*     */   
/*     */   public boolean fileWriteStreamCancel(SteamUGCFileWriteStreamHandle paramSteamUGCFileWriteStreamHandle) {
/* 137 */     return SteamRemoteStorageNative.fileWriteStreamCancel(paramSteamUGCFileWriteStreamHandle.handle);
/*     */   }
/*     */   
/*     */   public boolean fileExists(String paramString) {
/* 141 */     return SteamRemoteStorageNative.fileExists(paramString);
/*     */   }
/*     */   
/*     */   public boolean filePersisted(String paramString) {
/* 145 */     return SteamRemoteStorageNative.filePersisted(paramString);
/*     */   }
/*     */   
/*     */   public int getFileSize(String paramString) {
/* 149 */     return SteamRemoteStorageNative.getFileSize(paramString);
/*     */   }
/*     */   
/*     */   public long getFileTimestamp(String paramString) {
/* 153 */     return SteamRemoteStorageNative.getFileTimestamp(paramString);
/*     */   }
/*     */   
/*     */   public RemoteStoragePlatform[] getSyncPlatforms(String paramString) {
/*     */     int i;
/* 158 */     return RemoteStoragePlatform.byMask(i = SteamRemoteStorageNative.getSyncPlatforms(paramString));
/*     */   }
/*     */   
/*     */   public int getFileCount() {
/* 162 */     return SteamRemoteStorageNative.getFileCount();
/*     */   }
/*     */   
/*     */   public String getFileNameAndSize(int paramInt, int[] paramArrayOfint) {
/* 166 */     return SteamRemoteStorageNative.getFileNameAndSize(paramInt, paramArrayOfint);
/*     */   }
/*     */   
/*     */   public boolean getQuota(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 170 */     return SteamRemoteStorageNative.getQuota(paramArrayOflong1, paramArrayOflong2);
/*     */   }
/*     */   
/*     */   public boolean isCloudEnabledForAccount() {
/* 174 */     return SteamRemoteStorageNative.isCloudEnabledForAccount();
/*     */   }
/*     */   
/*     */   public boolean isCloudEnabledForApp() {
/* 178 */     return SteamRemoteStorageNative.isCloudEnabledForApp();
/*     */   }
/*     */   
/*     */   public void setCloudEnabledForApp(boolean paramBoolean) {
/* 182 */     SteamRemoteStorageNative.setCloudEnabledForApp(paramBoolean);
/*     */   }
/*     */   
/*     */   public SteamAPICall ugcDownload(SteamUGCHandle paramSteamUGCHandle, int paramInt) {
/* 186 */     return new SteamAPICall(SteamRemoteStorageNative.ugcDownload(this.callback, paramSteamUGCHandle.handle, paramInt));
/*     */   }
/*     */   
/*     */   public boolean getUGCDownloadProgress(SteamUGCHandle paramSteamUGCHandle, int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 190 */     return SteamRemoteStorageNative.getUGCDownloadProgress(paramSteamUGCHandle.handle, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */   
/*     */   public int ugcRead(SteamUGCHandle paramSteamUGCHandle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, UGCReadAction paramUGCReadAction) {
/* 194 */     return SteamRemoteStorageNative.ugcRead(paramSteamUGCHandle.handle, paramByteBuffer, paramByteBuffer
/* 195 */         .position(), paramInt1, paramInt2, paramUGCReadAction.ordinal());
/*     */   }
/*     */   
/*     */   public int getCachedUGCCount() {
/* 199 */     return SteamRemoteStorageNative.getCachedUGCCount();
/*     */   }
/*     */   
/*     */   public SteamUGCHandle getCachedUGCHandle(int paramInt) {
/* 203 */     return new SteamUGCHandle(SteamRemoteStorageNative.getCachedUGCHandle(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamAPICall publishWorkshopFile(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, PublishedFileVisibility paramPublishedFileVisibility, String[] paramArrayOfString, WorkshopFileType paramWorkshopFileType) {
/* 211 */     return new SteamAPICall(SteamRemoteStorageNative.publishWorkshopFile(this.callback, paramString1, paramString2, paramInt, paramString3, paramString4, paramPublishedFileVisibility
/*     */           
/* 213 */           .ordinal(), paramArrayOfString, (paramArrayOfString != null) ? paramArrayOfString.length : 0, paramWorkshopFileType.ordinal()));
/*     */   }
/*     */   
/*     */   public SteamPublishedFileUpdateHandle createPublishedFileUpdateRequest(SteamPublishedFileID paramSteamPublishedFileID) {
/* 217 */     return new SteamPublishedFileUpdateHandle(
/* 218 */         SteamRemoteStorageNative.createPublishedFileUpdateRequest(paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public boolean updatePublishedFileFile(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, String paramString) {
/* 222 */     return SteamRemoteStorageNative.updatePublishedFileFile(paramSteamPublishedFileUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean updatePublishedFilePreviewFile(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, String paramString) {
/* 226 */     return SteamRemoteStorageNative.updatePublishedFilePreviewFile(paramSteamPublishedFileUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean updatePublishedFileTitle(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, String paramString) {
/* 230 */     return SteamRemoteStorageNative.updatePublishedFileTitle(paramSteamPublishedFileUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean updatePublishedFileDescription(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, String paramString) {
/* 234 */     return SteamRemoteStorageNative.updatePublishedFileDescription(paramSteamPublishedFileUpdateHandle.handle, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updatePublishedFileVisibility(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, PublishedFileVisibility paramPublishedFileVisibility) {
/* 240 */     return SteamRemoteStorageNative.updatePublishedFileVisibility(paramSteamPublishedFileUpdateHandle.handle, paramPublishedFileVisibility.ordinal());
/*     */   }
/*     */   
/*     */   public boolean updatePublishedFileTags(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle, String[] paramArrayOfString) {
/* 244 */     return SteamRemoteStorageNative.updatePublishedFileTags(paramSteamPublishedFileUpdateHandle.handle, paramArrayOfString, (paramArrayOfString != null) ? paramArrayOfString.length : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public SteamAPICall commitPublishedFileUpdate(SteamPublishedFileUpdateHandle paramSteamPublishedFileUpdateHandle) {
/* 249 */     return new SteamAPICall(SteamRemoteStorageNative.commitPublishedFileUpdate(this.callback, paramSteamPublishedFileUpdateHandle.handle));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamRemoteStorage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */