/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.EnumSet;
/*     */ 
/*     */ public class SteamUGC
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum UserUGCList {
/*  10 */     Published,
/*  11 */     VotedOn,
/*  12 */     VotedUp,
/*  13 */     VotedDown,
/*  14 */     WillVoteLater,
/*  15 */     Favorited,
/*  16 */     Subscribed,
/*  17 */     UsedOrPlayed,
/*  18 */     Followed;
/*     */   }
/*     */   
/*     */   public enum MatchingUGCType {
/*  22 */     Items(0),
/*  23 */     ItemsMtx(1),
/*  24 */     ItemsReadyToUse(2),
/*  25 */     Collections(3),
/*  26 */     Artwork(4),
/*  27 */     Videos(5),
/*  28 */     Screenshots(6),
/*  29 */     AllGuides(7),
/*  30 */     WebGuides(8),
/*  31 */     IntegratedGuides(9),
/*  32 */     UsableInGame(10),
/*  33 */     ControllerBindings(11),
/*  34 */     GameManagedItems(12),
/*  35 */     All(-1);
/*     */     
/*     */     private final int value;
/*     */     
/*     */     MatchingUGCType(int param1Int1) {
/*  40 */       this.value = param1Int1;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum UserUGCListSortOrder {
/*  45 */     CreationOrderDesc,
/*  46 */     CreationOrderAsc,
/*  47 */     TitleAsc,
/*  48 */     LastUpdatedDesc,
/*  49 */     SubscriptionDateDesc,
/*  50 */     VoteScoreDesc,
/*  51 */     ForModeration;
/*     */   }
/*     */   
/*     */   public enum UGCQueryType {
/*  55 */     RankedByVote,
/*  56 */     RankedByPublicationDate,
/*  57 */     AcceptedForGameRankedByAcceptanceDate,
/*  58 */     RankedByTrend,
/*  59 */     FavoritedByFriendsRankedByPublicationDate,
/*  60 */     CreatedByFriendsRankedByPublicationDate,
/*  61 */     RankedByNumTimesReported,
/*  62 */     CreatedByFollowedUsersRankedByPublicationDate,
/*  63 */     NotYetRated,
/*  64 */     RankedByTotalVotesAsc,
/*  65 */     RankedByVotesUp,
/*  66 */     RankedByTextSearch,
/*  67 */     RankedByTotalUniqueSubscriptions,
/*  68 */     RankedByPlaytimeTrend,
/*  69 */     RankedByTotalPlaytime,
/*  70 */     RankedByAveragePlaytimeTrend,
/*  71 */     RankedByLifetimeAveragePlaytime,
/*  72 */     RankedByPlaytimeSessionsTrend,
/*  73 */     RankedByLifetimePlaytimeSessions;
/*     */   }
/*     */   
/*     */   public enum ItemUpdateStatus {
/*  77 */     Invalid,
/*  78 */     PreparingConfig,
/*  79 */     PreparingContent,
/*  80 */     UploadingContent,
/*  81 */     UploadingPreviewFile,
/*  82 */     CommittingChanges;
/*     */     
/*  84 */     private static final ItemUpdateStatus[] values = values();
/*     */     
/*     */     static ItemUpdateStatus byOrdinal(int param1Int) {
/*  87 */       return values[param1Int];
/*     */     }
/*     */     static {
/*     */     
/*     */     } }
/*     */   
/*     */   public static class ItemUpdateInfo { long bytesProcessed;
/*     */     long bytesTotal;
/*     */     
/*     */     public long getBytesProcessed() {
/*  97 */       return this.bytesProcessed;
/*     */     }
/*     */     
/*     */     public long getBytesTotal() {
/* 101 */       return this.bytesTotal;
/*     */     } }
/*     */ 
/*     */   
/*     */   public enum ItemState {
/* 106 */     None(0),
/* 107 */     Subscribed(1),
/* 108 */     LegacyItem(2),
/* 109 */     Installed(4),
/* 110 */     NeedsUpdate(8),
/* 111 */     Downloading(16),
/* 112 */     DownloadPending(32);
/*     */     
/*     */     private final int bits;
/* 115 */     private static final ItemState[] values = values(); static {
/*     */     
/*     */     } ItemState(int param1Int1) {
/* 118 */       this.bits = param1Int1;
/*     */     }
/*     */     
/*     */     static Collection<ItemState> fromBits(int param1Int) {
/* 122 */       EnumSet<ItemState> enumSet = EnumSet.noneOf(ItemState.class); ItemState[] arrayOfItemState; int i;
/*     */       byte b;
/* 124 */       for (i = (arrayOfItemState = values).length, b = 0; b < i; ) { ItemState itemState = arrayOfItemState[b];
/* 125 */         if ((param1Int & itemState.bits) == itemState.bits) {
/* 126 */           enumSet.add(itemState);
/*     */         }
/*     */         b++; }
/*     */       
/* 130 */       return enumSet;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum ItemStatistic {
/* 135 */     NumSubscriptions,
/* 136 */     NumFavorites,
/* 137 */     NumFollowers,
/* 138 */     NumUniqueSubscriptions,
/* 139 */     NumUniqueFavorites,
/* 140 */     NumUniqueFollowers,
/* 141 */     NumUniqueWebsiteViews,
/* 142 */     ReportScore,
/* 143 */     NumSecondsPlayed,
/* 144 */     NumPlaytimeSessions,
/* 145 */     NumComments,
/* 146 */     NumSecondsPlayedDuringTimePeriod,
/* 147 */     NumPlaytimeSessionsDuringTimePeriod;
/*     */   }
/*     */   
/*     */   public enum ItemPreviewType {
/* 151 */     Image(0),
/* 152 */     YouTubeVideo(1),
/* 153 */     Sketchfab(2),
/* 154 */     EnvironmentMap_HorizontalCross(3),
/* 155 */     EnvironmentMap_LatLong(4),
/* 156 */     ReservedMax(255),
/*     */     
/* 158 */     UnknownPreviewType_NotImplementedByAPI(-1);
/*     */     
/*     */     private final int value;
/* 161 */     private static final ItemPreviewType[] values = values(); static {
/*     */     
/*     */     }
/* 164 */     ItemPreviewType(int param1Int1) { this.value = param1Int1; } static ItemPreviewType byValue(int param1Int) {
/*     */       ItemPreviewType[] arrayOfItemPreviewType;
/*     */       int i;
/*     */       byte b;
/* 168 */       for (i = (arrayOfItemPreviewType = values).length, b = 0; b < i; b++) {
/* 169 */         ItemPreviewType itemPreviewType; if ((itemPreviewType = arrayOfItemPreviewType[b]).value == param1Int) {
/* 170 */           return itemPreviewType;
/*     */         }
/*     */       } 
/* 173 */       return UnknownPreviewType_NotImplementedByAPI;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ItemInstallInfo
/*     */   {
/*     */     private String folder;
/*     */     private int sizeOnDisk;
/*     */     
/*     */     public String getFolder() {
/* 184 */       return this.folder;
/*     */     }
/*     */     
/*     */     public int getSizeOnDisk() {
/* 188 */       return this.sizeOnDisk;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ItemDownloadInfo
/*     */   {
/*     */     long bytesDownloaded;
/*     */     long bytesTotal;
/*     */     
/*     */     public long getBytesDownloaded() {
/* 198 */       return this.bytesDownloaded;
/*     */     }
/*     */     
/*     */     public long getBytesTotal() {
/* 202 */       return this.bytesTotal;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ItemAdditionalPreview
/*     */   {
/*     */     private String urlOrVideoID;
/*     */     private String originalFileName;
/*     */     private int previewType;
/*     */     
/*     */     public String getUrlOrVideoID() {
/* 214 */       return this.urlOrVideoID;
/*     */     }
/*     */     
/*     */     public String getOriginalFileName() {
/* 218 */       return this.originalFileName;
/*     */     }
/*     */     
/*     */     public SteamUGC.ItemPreviewType getPreviewType() {
/* 222 */       return SteamUGC.ItemPreviewType.byValue(this.previewType);
/*     */     }
/*     */   }
/*     */   
/*     */   public SteamUGC(SteamUGCCallback paramSteamUGCCallback) {
/* 227 */     super(SteamUGCNative.createCallback(new SteamUGCCallbackAdapter(paramSteamUGCCallback)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamUGCQuery createQueryUserUGCRequest(int paramInt1, UserUGCList paramUserUGCList, MatchingUGCType paramMatchingUGCType, UserUGCListSortOrder paramUserUGCListSortOrder, int paramInt2, int paramInt3, int paramInt4) {
/* 234 */     return new SteamUGCQuery(SteamUGCNative.createQueryUserUGCRequest(paramInt1, paramUserUGCList.ordinal(), paramMatchingUGCType
/* 235 */           .value, paramUserUGCListSortOrder.ordinal(), paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamUGCQuery createQueryAllUGCRequest(UGCQueryType paramUGCQueryType, MatchingUGCType paramMatchingUGCType, int paramInt1, int paramInt2, int paramInt3) {
/* 241 */     return new SteamUGCQuery(SteamUGCNative.createQueryAllUGCRequest(paramUGCQueryType.ordinal(), paramMatchingUGCType.value, paramInt1, paramInt2, paramInt3));
/*     */   }
/*     */ 
/*     */   
/*     */   public SteamUGCQuery createQueryUGCDetailsRequest(SteamPublishedFileID paramSteamPublishedFileID) {
/*     */     long[] arrayOfLong;
/* 247 */     (arrayOfLong = new long[1])[0] = paramSteamPublishedFileID.handle;
/* 248 */     return new SteamUGCQuery(SteamUGCNative.createQueryUGCDetailsRequest(arrayOfLong, 1));
/*     */   }
/*     */   
/*     */   public SteamUGCQuery createQueryUGCDetailsRequest(Collection<SteamPublishedFileID> paramCollection) {
/*     */     int i;
/* 253 */     long[] arrayOfLong = new long[i = paramCollection.size()];
/*     */     
/* 255 */     byte b = 0;
/* 256 */     for (SteamPublishedFileID steamPublishedFileID : paramCollection) {
/* 257 */       arrayOfLong[b++] = steamPublishedFileID.handle;
/*     */     }
/*     */     
/* 260 */     return new SteamUGCQuery(SteamUGCNative.createQueryUGCDetailsRequest(arrayOfLong, i));
/*     */   }
/*     */   
/*     */   public SteamAPICall sendQueryUGCRequest(SteamUGCQuery paramSteamUGCQuery) {
/* 264 */     return new SteamAPICall(SteamUGCNative.sendQueryUGCRequest(this.callback, paramSteamUGCQuery.handle));
/*     */   }
/*     */   
/*     */   public boolean getQueryUGCResult(SteamUGCQuery paramSteamUGCQuery, int paramInt, SteamUGCDetails paramSteamUGCDetails) {
/* 268 */     return SteamUGCNative.getQueryUGCResult(paramSteamUGCQuery.handle, paramInt, paramSteamUGCDetails);
/*     */   }
/*     */   
/*     */   public String getQueryUGCPreviewURL(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 272 */     return SteamUGCNative.getQueryUGCPreviewURL(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public String getQueryUGCMetadata(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 276 */     return SteamUGCNative.getQueryUGCMetadata(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public long getQueryUGCStatistic(SteamUGCQuery paramSteamUGCQuery, int paramInt, ItemStatistic paramItemStatistic) {
/* 280 */     return SteamUGCNative.getQueryUGCStatistic(paramSteamUGCQuery.handle, paramInt, paramItemStatistic.ordinal());
/*     */   }
/*     */   
/*     */   public int getQueryUGCNumAdditionalPreviews(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 284 */     return SteamUGCNative.getQueryUGCNumAdditionalPreviews(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getQueryUGCAdditionalPreview(SteamUGCQuery paramSteamUGCQuery, int paramInt1, int paramInt2, ItemAdditionalPreview paramItemAdditionalPreview) {
/* 290 */     return SteamUGCNative.getQueryUGCAdditionalPreview(paramSteamUGCQuery.handle, paramInt1, paramInt2, paramItemAdditionalPreview);
/*     */   }
/*     */   
/*     */   public int getQueryUGCNumKeyValueTags(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 294 */     return SteamUGCNative.getQueryUGCNumKeyValueTags(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public boolean getQueryUGCKeyValueTag(SteamUGCQuery paramSteamUGCQuery, int paramInt1, int paramInt2, String[] paramArrayOfString) {
/* 298 */     return SteamUGCNative.getQueryUGCKeyValueTag(paramSteamUGCQuery.handle, paramInt1, paramInt2, paramArrayOfString);
/*     */   }
/*     */   
/*     */   public boolean releaseQueryUserUGCRequest(SteamUGCQuery paramSteamUGCQuery) {
/* 302 */     return SteamUGCNative.releaseQueryUserUGCRequest(paramSteamUGCQuery.handle);
/*     */   }
/*     */   
/*     */   public boolean addRequiredTag(SteamUGCQuery paramSteamUGCQuery, String paramString) {
/* 306 */     return SteamUGCNative.addRequiredTag(paramSteamUGCQuery.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean addExcludedTag(SteamUGCQuery paramSteamUGCQuery, String paramString) {
/* 310 */     return SteamUGCNative.addExcludedTag(paramSteamUGCQuery.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setReturnOnlyIDs(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 314 */     return SteamUGCNative.setReturnOnlyIDs(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnKeyValueTags(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 318 */     return SteamUGCNative.setReturnKeyValueTags(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnLongDescription(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 322 */     return SteamUGCNative.setReturnLongDescription(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnMetadata(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 326 */     return SteamUGCNative.setReturnMetadata(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnChildren(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 330 */     return SteamUGCNative.setReturnChildren(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnAdditionalPreviews(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 334 */     return SteamUGCNative.setReturnAdditionalPreviews(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnTotalOnly(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 338 */     return SteamUGCNative.setReturnTotalOnly(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setReturnPlaytimeStats(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 342 */     return SteamUGCNative.setReturnPlaytimeStats(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public boolean setLanguage(SteamUGCQuery paramSteamUGCQuery, String paramString) {
/* 346 */     return SteamUGCNative.setLanguage(paramSteamUGCQuery.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setAllowCachedResponse(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 350 */     return SteamUGCNative.setAllowCachedResponse(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public boolean setCloudFileNameFilter(SteamUGCQuery paramSteamUGCQuery, String paramString) {
/* 354 */     return SteamUGCNative.setCloudFileNameFilter(paramSteamUGCQuery.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setMatchAnyTag(SteamUGCQuery paramSteamUGCQuery, boolean paramBoolean) {
/* 358 */     return SteamUGCNative.setMatchAnyTag(paramSteamUGCQuery.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean setSearchText(SteamUGCQuery paramSteamUGCQuery, String paramString) {
/* 362 */     return SteamUGCNative.setSearchText(paramSteamUGCQuery.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setRankedByTrendDays(SteamUGCQuery paramSteamUGCQuery, int paramInt) {
/* 366 */     return SteamUGCNative.setRankedByTrendDays(paramSteamUGCQuery.handle, paramInt);
/*     */   }
/*     */   
/*     */   public boolean addRequiredKeyValueTag(SteamUGCQuery paramSteamUGCQuery, String paramString1, String paramString2) {
/* 370 */     return SteamUGCNative.addRequiredKeyValueTag(paramSteamUGCQuery.handle, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public SteamAPICall requestUGCDetails(SteamPublishedFileID paramSteamPublishedFileID, int paramInt) {
/* 375 */     return new SteamAPICall(SteamUGCNative.requestUGCDetails(this.callback, paramSteamPublishedFileID.handle, paramInt));
/*     */   }
/*     */   
/*     */   public SteamAPICall createItem(int paramInt, SteamRemoteStorage.WorkshopFileType paramWorkshopFileType) {
/* 379 */     return new SteamAPICall(SteamUGCNative.createItem(this.callback, paramInt, paramWorkshopFileType.ordinal()));
/*     */   }
/*     */   
/*     */   public SteamUGCUpdateHandle startItemUpdate(int paramInt, SteamPublishedFileID paramSteamPublishedFileID) {
/* 383 */     return new SteamUGCUpdateHandle(SteamUGCNative.startItemUpdate(paramInt, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public boolean setItemTitle(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 387 */     return SteamUGCNative.setItemTitle(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setItemDescription(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 391 */     return SteamUGCNative.setItemDescription(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setItemUpdateLanguage(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 395 */     return SteamUGCNative.setItemUpdateLanguage(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setItemMetadata(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 399 */     return SteamUGCNative.setItemMetadata(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemVisibility(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, SteamRemoteStorage.PublishedFileVisibility paramPublishedFileVisibility) {
/* 405 */     return SteamUGCNative.setItemVisibility(paramSteamUGCUpdateHandle.handle, paramPublishedFileVisibility.ordinal());
/*     */   }
/*     */   
/*     */   public boolean setItemTags(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String[] paramArrayOfString) {
/* 409 */     return SteamUGCNative.setItemTags(paramSteamUGCUpdateHandle.handle, paramArrayOfString, paramArrayOfString.length);
/*     */   }
/*     */   
/*     */   public boolean setItemContent(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 413 */     return SteamUGCNative.setItemContent(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setItemPreview(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 417 */     return SteamUGCNative.setItemPreview(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean removeItemKeyValueTags(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 421 */     return SteamUGCNative.removeItemKeyValueTags(paramSteamUGCUpdateHandle.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean addItemKeyValueTag(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString1, String paramString2) {
/* 425 */     return SteamUGCNative.addItemKeyValueTag(paramSteamUGCUpdateHandle.handle, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public SteamAPICall submitItemUpdate(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, String paramString) {
/* 429 */     if (paramString == null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 434 */       paramString = "";
/*     */     }
/* 436 */     return new SteamAPICall(SteamUGCNative.submitItemUpdate(this.callback, paramSteamUGCUpdateHandle.handle, paramString));
/*     */   }
/*     */   
/*     */   public ItemUpdateStatus getItemUpdateProgress(SteamUGCUpdateHandle paramSteamUGCUpdateHandle, ItemUpdateInfo paramItemUpdateInfo) {
/* 440 */     long[] arrayOfLong = new long[2];
/* 441 */     ItemUpdateStatus itemUpdateStatus = ItemUpdateStatus.byOrdinal(SteamUGCNative.getItemUpdateProgress(paramSteamUGCUpdateHandle.handle, arrayOfLong));
/* 442 */     paramItemUpdateInfo.bytesProcessed = arrayOfLong[0];
/* 443 */     paramItemUpdateInfo.bytesTotal = arrayOfLong[1];
/* 444 */     return itemUpdateStatus;
/*     */   }
/*     */   
/*     */   public SteamAPICall setUserItemVote(SteamPublishedFileID paramSteamPublishedFileID, boolean paramBoolean) {
/* 448 */     return new SteamAPICall(SteamUGCNative.setUserItemVote(this.callback, paramSteamPublishedFileID.handle, paramBoolean));
/*     */   }
/*     */   
/*     */   public SteamAPICall getUserItemVote(SteamPublishedFileID paramSteamPublishedFileID) {
/* 452 */     return new SteamAPICall(SteamUGCNative.getUserItemVote(this.callback, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public SteamAPICall addItemToFavorites(int paramInt, SteamPublishedFileID paramSteamPublishedFileID) {
/* 456 */     return new SteamAPICall(SteamUGCNative.addItemToFavorites(this.callback, paramInt, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public SteamAPICall removeItemFromFavorites(int paramInt, SteamPublishedFileID paramSteamPublishedFileID) {
/* 460 */     return new SteamAPICall(SteamUGCNative.removeItemFromFavorites(this.callback, paramInt, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public SteamAPICall subscribeItem(SteamPublishedFileID paramSteamPublishedFileID) {
/* 464 */     return new SteamAPICall(SteamUGCNative.subscribeItem(this.callback, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public SteamAPICall unsubscribeItem(SteamPublishedFileID paramSteamPublishedFileID) {
/* 468 */     return new SteamAPICall(SteamUGCNative.unsubscribeItem(this.callback, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public int getNumSubscribedItems() {
/* 472 */     return SteamUGCNative.getNumSubscribedItems();
/*     */   }
/*     */   
/*     */   public int getSubscribedItems(SteamPublishedFileID[] paramArrayOfSteamPublishedFileID) {
/*     */     long[] arrayOfLong;
/* 477 */     int i = SteamUGCNative.getSubscribedItems(arrayOfLong = new long[paramArrayOfSteamPublishedFileID.length], paramArrayOfSteamPublishedFileID.length);
/*     */     
/* 479 */     for (byte b = 0; b < i; b++) {
/* 480 */       paramArrayOfSteamPublishedFileID[b] = new SteamPublishedFileID(arrayOfLong[b]);
/*     */     }
/*     */     
/* 483 */     return i;
/*     */   }
/*     */   
/*     */   public Collection<ItemState> getItemState(SteamPublishedFileID paramSteamPublishedFileID) {
/* 487 */     return ItemState.fromBits(SteamUGCNative.getItemState(paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public boolean getItemInstallInfo(SteamPublishedFileID paramSteamPublishedFileID, ItemInstallInfo paramItemInstallInfo) {
/* 491 */     return SteamUGCNative.getItemInstallInfo(paramSteamPublishedFileID.handle, paramItemInstallInfo);
/*     */   }
/*     */   
/*     */   public boolean getItemDownloadInfo(SteamPublishedFileID paramSteamPublishedFileID, ItemDownloadInfo paramItemDownloadInfo) {
/* 495 */     long[] arrayOfLong = new long[2];
/* 496 */     if (SteamUGCNative.getItemDownloadInfo(paramSteamPublishedFileID.handle, arrayOfLong)) {
/* 497 */       paramItemDownloadInfo.bytesDownloaded = arrayOfLong[0];
/* 498 */       paramItemDownloadInfo.bytesTotal = arrayOfLong[1];
/* 499 */       return true;
/*     */     } 
/* 501 */     return false;
/*     */   }
/*     */   
/*     */   public SteamAPICall deleteItem(SteamPublishedFileID paramSteamPublishedFileID) {
/* 505 */     return new SteamAPICall(SteamUGCNative.deleteItem(this.callback, paramSteamPublishedFileID.handle));
/*     */   }
/*     */   
/*     */   public boolean downloadItem(SteamPublishedFileID paramSteamPublishedFileID, boolean paramBoolean) {
/* 509 */     return SteamUGCNative.downloadItem(paramSteamPublishedFileID.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean initWorkshopForGameServer(int paramInt, String paramString) {
/* 513 */     return SteamUGCNative.initWorkshopForGameServer(paramInt, paramString);
/*     */   }
/*     */   
/*     */   public void suspendDownloads(boolean paramBoolean) {
/* 517 */     SteamUGCNative.suspendDownloads(paramBoolean);
/*     */   }
/*     */   
/*     */   public SteamAPICall startPlaytimeTracking(SteamPublishedFileID[] paramArrayOfSteamPublishedFileID) {
/* 521 */     long[] arrayOfLong = new long[paramArrayOfSteamPublishedFileID.length];
/*     */     
/* 523 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 524 */       arrayOfLong[b] = (paramArrayOfSteamPublishedFileID[b]).handle;
/*     */     }
/*     */     
/* 527 */     return new SteamAPICall(SteamUGCNative.startPlaytimeTracking(this.callback, arrayOfLong, arrayOfLong.length));
/*     */   }
/*     */   
/*     */   public SteamAPICall stopPlaytimeTracking(SteamPublishedFileID[] paramArrayOfSteamPublishedFileID) {
/* 531 */     long[] arrayOfLong = new long[paramArrayOfSteamPublishedFileID.length];
/*     */     
/* 533 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 534 */       arrayOfLong[b] = (paramArrayOfSteamPublishedFileID[b]).handle;
/*     */     }
/*     */     
/* 537 */     return new SteamAPICall(SteamUGCNative.stopPlaytimeTracking(this.callback, arrayOfLong, arrayOfLong.length));
/*     */   }
/*     */   
/*     */   public SteamAPICall stopPlaytimeTrackingForAllItems() {
/* 541 */     return new SteamAPICall(SteamUGCNative.stopPlaytimeTrackingForAllItems(this.callback));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUGC.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */