/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamMatchmaking
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum LobbyType {
/*   9 */     Private,
/*  10 */     FriendsOnly,
/*  11 */     Public,
/*  12 */     Invisible,
/*  13 */     PrivateUnique;
/*     */   }
/*     */   
/*     */   public enum LobbyComparison {
/*  17 */     EqualToOrLessThan(-2),
/*  18 */     LessThan(-1),
/*  19 */     Equal(0),
/*  20 */     GreaterThan(1),
/*  21 */     EqualToOrGreaterThan(2),
/*  22 */     NotEqual(3);
/*     */     
/*     */     private final int value;
/*     */     
/*     */     LobbyComparison(int param1Int1) {
/*  27 */       this.value = param1Int1;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum LobbyDistanceFilter {
/*  32 */     Close,
/*  33 */     Default,
/*  34 */     Far,
/*  35 */     Worldwide;
/*     */   }
/*     */   
/*     */   public enum ChatRoomEnterResponse {
/*  39 */     Success(1),
/*  40 */     DoesntExist(2),
/*  41 */     NotAllowed(3),
/*  42 */     Full(4),
/*  43 */     Error(5),
/*  44 */     Banned(6),
/*  45 */     Limited(7),
/*  46 */     ClanDisabled(8),
/*  47 */     CommunityBan(9),
/*  48 */     MemberBlockedYou(10),
/*  49 */     YouBlockedMember(11),
/*  50 */     RatelimitExceeded(15); private final int code; static {
/*     */     
/*     */     }
/*  53 */     private static final ChatRoomEnterResponse[] values = values();
/*     */     
/*     */     ChatRoomEnterResponse(int param1Int1) {
/*  56 */       this.code = param1Int1; } static ChatRoomEnterResponse byValue(int param1Int) {
/*     */       ChatRoomEnterResponse[] arrayOfChatRoomEnterResponse;
/*     */       int i;
/*     */       byte b;
/*  60 */       for (i = (arrayOfChatRoomEnterResponse = values).length, b = 0; b < i; b++) {
/*  61 */         ChatRoomEnterResponse chatRoomEnterResponse; if ((chatRoomEnterResponse = arrayOfChatRoomEnterResponse[b]).code == param1Int) {
/*  62 */           return chatRoomEnterResponse;
/*     */         }
/*     */       } 
/*  65 */       return Error;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum ChatMemberStateChange {
/*  70 */     Entered(1),
/*  71 */     Left(2),
/*  72 */     Disconnected(4),
/*  73 */     Kicked(8),
/*  74 */     Banned(16);
/*     */     
/*     */     private final int bits;
/*     */     
/*     */     ChatMemberStateChange(int param1Int1) {
/*  79 */       this.bits = param1Int1;
/*     */     }
/*     */     
/*     */     static boolean isSet(ChatMemberStateChange param1ChatMemberStateChange, int param1Int) {
/*  83 */       return ((param1ChatMemberStateChange.bits & param1Int) == param1ChatMemberStateChange.bits);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum ChatEntryType {
/*  88 */     Invalid(0),
/*  89 */     ChatMsg(1),
/*  90 */     Typing(2),
/*  91 */     InviteGame(3),
/*  92 */     Emote(4),
/*  93 */     LeftConversation(6),
/*  94 */     Entered(7),
/*  95 */     WasKicked(8),
/*  96 */     WasBanned(9),
/*  97 */     Disconnected(10),
/*  98 */     HistoricalChat(11),
/*  99 */     Reserved1(12),
/* 100 */     Reserved2(13),
/* 101 */     LinkBlocked(14);
/*     */     
/*     */     private final int code;
/* 104 */     private static final ChatEntryType[] values = values(); static {
/*     */     
/*     */     }
/* 107 */     ChatEntryType(int param1Int1) { this.code = param1Int1; } static ChatEntryType byValue(int param1Int) {
/*     */       ChatEntryType[] arrayOfChatEntryType;
/*     */       int i;
/*     */       byte b;
/* 111 */       for (i = (arrayOfChatEntryType = values).length, b = 0; b < i; b++) {
/* 112 */         ChatEntryType chatEntryType; if ((chatEntryType = arrayOfChatEntryType[b]).code == param1Int) {
/* 113 */           return chatEntryType;
/*     */         }
/*     */       } 
/* 116 */       return Invalid;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ChatEntry
/*     */   {
/*     */     private long steamIDUser;
/*     */     private int chatEntryType;
/*     */     
/*     */     public SteamID getSteamIDUser() {
/* 126 */       return new SteamID(this.steamIDUser);
/*     */     }
/*     */     
/*     */     public SteamMatchmaking.ChatEntryType getChatEntryType() {
/* 130 */       return SteamMatchmaking.ChatEntryType.byValue(this.chatEntryType);
/*     */     }
/*     */   }
/*     */   
/*     */   public SteamMatchmaking(SteamMatchmakingCallback paramSteamMatchmakingCallback) {
/* 135 */     super(SteamMatchmakingNative.createCallback(new SteamMatchmakingCallbackAdapter(paramSteamMatchmakingCallback)));
/*     */   }
/*     */   
/*     */   public int getFavoriteGameCount() {
/* 139 */     return SteamMatchmakingNative.getFavoriteGameCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFavoriteGame(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, short[] paramArrayOfshort1, short[] paramArrayOfshort2, int[] paramArrayOfint3, int[] paramArrayOfint4) {
/* 144 */     return SteamMatchmakingNative.getFavoriteGame(paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfshort1, paramArrayOfshort2, paramArrayOfint3, paramArrayOfint4);
/*     */   }
/*     */   
/*     */   public int addFavoriteGame(int paramInt1, int paramInt2, short paramShort1, short paramShort2, int paramInt3, int paramInt4) {
/* 148 */     return SteamMatchmakingNative.addFavoriteGame(paramInt1, paramInt2, paramShort1, paramShort2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public boolean removeFavoriteGame(int paramInt1, int paramInt2, short paramShort1, short paramShort2, int paramInt3) {
/* 152 */     return SteamMatchmakingNative.removeFavoriteGame(paramInt1, paramInt2, paramShort1, paramShort2, paramInt3);
/*     */   }
/*     */   
/*     */   public SteamAPICall requestLobbyList() {
/* 156 */     return new SteamAPICall(SteamMatchmakingNative.requestLobbyList(this.callback));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRequestLobbyListStringFilter(String paramString1, String paramString2, LobbyComparison paramLobbyComparison) {
/* 162 */     SteamMatchmakingNative.addRequestLobbyListStringFilter(paramString1, paramString2, paramLobbyComparison.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRequestLobbyListNumericalFilter(String paramString, int paramInt, LobbyComparison paramLobbyComparison) {
/* 168 */     SteamMatchmakingNative.addRequestLobbyListNumericalFilter(paramString, paramInt, paramLobbyComparison.value);
/*     */   }
/*     */   
/*     */   public void addRequestLobbyListNearValueFilter(String paramString, int paramInt) {
/* 172 */     SteamMatchmakingNative.addRequestLobbyListNearValueFilter(paramString, paramInt);
/*     */   }
/*     */   
/*     */   public void addRequestLobbyListFilterSlotsAvailable(int paramInt) {
/* 176 */     SteamMatchmakingNative.addRequestLobbyListFilterSlotsAvailable(paramInt);
/*     */   }
/*     */   
/*     */   public void addRequestLobbyListDistanceFilter(LobbyDistanceFilter paramLobbyDistanceFilter) {
/* 180 */     SteamMatchmakingNative.addRequestLobbyListDistanceFilter(paramLobbyDistanceFilter.ordinal());
/*     */   }
/*     */   
/*     */   public void addRequestLobbyListResultCountFilter(int paramInt) {
/* 184 */     SteamMatchmakingNative.addRequestLobbyListResultCountFilter(paramInt);
/*     */   }
/*     */   
/*     */   public void addRequestLobbyListCompatibleMembersFilter(SteamID paramSteamID) {
/* 188 */     SteamMatchmakingNative.addRequestLobbyListCompatibleMembersFilter(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public SteamID getLobbyByIndex(int paramInt) {
/* 192 */     return new SteamID(SteamMatchmakingNative.getLobbyByIndex(paramInt));
/*     */   }
/*     */   
/*     */   public SteamAPICall createLobby(LobbyType paramLobbyType, int paramInt) {
/* 196 */     return new SteamAPICall(SteamMatchmakingNative.createLobby(this.callback, paramLobbyType.ordinal(), paramInt));
/*     */   }
/*     */   
/*     */   public SteamAPICall joinLobby(SteamID paramSteamID) {
/* 200 */     return new SteamAPICall(SteamMatchmakingNative.joinLobby(this.callback, paramSteamID.handle));
/*     */   }
/*     */   
/*     */   public void leaveLobby(SteamID paramSteamID) {
/* 204 */     SteamMatchmakingNative.leaveLobby(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean inviteUserToLobby(SteamID paramSteamID1, SteamID paramSteamID2) {
/* 208 */     return SteamMatchmakingNative.inviteUserToLobby(paramSteamID1.handle, paramSteamID2.handle);
/*     */   }
/*     */   
/*     */   public int getNumLobbyMembers(SteamID paramSteamID) {
/* 212 */     return SteamMatchmakingNative.getNumLobbyMembers(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public SteamID getLobbyMemberByIndex(SteamID paramSteamID, int paramInt) {
/* 216 */     return new SteamID(SteamMatchmakingNative.getLobbyMemberByIndex(paramSteamID.handle, paramInt));
/*     */   }
/*     */   
/*     */   public String getLobbyData(SteamID paramSteamID, String paramString) {
/* 220 */     return SteamMatchmakingNative.getLobbyData(paramSteamID.handle, paramString);
/*     */   }
/*     */   
/*     */   public boolean setLobbyData(SteamID paramSteamID, String paramString1, String paramString2) {
/* 224 */     return SteamMatchmakingNative.setLobbyData(paramSteamID.handle, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public boolean setLobbyData(SteamID paramSteamID, SteamMatchmakingKeyValuePair paramSteamMatchmakingKeyValuePair) {
/* 228 */     return SteamMatchmakingNative.setLobbyData(paramSteamID.handle, paramSteamMatchmakingKeyValuePair.getKey(), paramSteamMatchmakingKeyValuePair.getValue());
/*     */   }
/*     */   
/*     */   public String getLobbyMemberData(SteamID paramSteamID1, SteamID paramSteamID2, String paramString) {
/* 232 */     return SteamMatchmakingNative.getLobbyMemberData(paramSteamID1.handle, paramSteamID2.handle, paramString);
/*     */   }
/*     */   
/*     */   public void setLobbyMemberData(SteamID paramSteamID, String paramString1, String paramString2) {
/* 236 */     SteamMatchmakingNative.setLobbyMemberData(paramSteamID.handle, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public void setLobbyMemberData(SteamID paramSteamID, SteamMatchmakingKeyValuePair paramSteamMatchmakingKeyValuePair) {
/* 240 */     SteamMatchmakingNative.setLobbyMemberData(paramSteamID.handle, paramSteamMatchmakingKeyValuePair.getKey(), paramSteamMatchmakingKeyValuePair.getValue());
/*     */   }
/*     */   
/*     */   public int getLobbyDataCount(SteamID paramSteamID) {
/* 244 */     return SteamMatchmakingNative.getLobbyDataCount(paramSteamID.handle);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLobbyDataByIndex(SteamID paramSteamID, int paramInt, SteamMatchmakingKeyValuePair paramSteamMatchmakingKeyValuePair) {
/* 249 */     return SteamMatchmakingNative.getLobbyDataByIndex(paramSteamID.handle, paramInt, paramSteamMatchmakingKeyValuePair);
/*     */   }
/*     */   
/*     */   public boolean deleteLobbyData(SteamID paramSteamID, String paramString) {
/* 253 */     return SteamMatchmakingNative.deleteLobbyData(paramSteamID.handle, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendLobbyChatMsg(SteamID paramSteamID, ByteBuffer paramByteBuffer) {
/* 261 */     if (!paramByteBuffer.isDirect()) {
/* 262 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 265 */     return SteamMatchmakingNative.sendLobbyChatMsg(paramSteamID.handle, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public boolean sendLobbyChatMsg(SteamID paramSteamID, String paramString) {
/* 269 */     return SteamMatchmakingNative.sendLobbyChatMsg(paramSteamID.handle, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLobbyChatEntry(SteamID paramSteamID, int paramInt, ChatEntry paramChatEntry, ByteBuffer paramByteBuffer) {
/* 279 */     if (!paramByteBuffer.isDirect()) {
/* 280 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 283 */     return SteamMatchmakingNative.getLobbyChatEntry(paramSteamID.handle, paramInt, paramChatEntry, paramByteBuffer, paramByteBuffer
/* 284 */         .position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public boolean requestLobbyData(SteamID paramSteamID) {
/* 288 */     return SteamMatchmakingNative.requestLobbyData(paramSteamID.handle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLobbyGameServer(SteamID paramSteamID1, int paramInt, short paramShort, SteamID paramSteamID2) {
/* 293 */     SteamMatchmakingNative.setLobbyGameServer(paramSteamID1.handle, paramInt, paramShort, paramSteamID2.handle);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLobbyGameServer(SteamID paramSteamID1, int[] paramArrayOfint, short[] paramArrayOfshort, SteamID paramSteamID2) {
/* 298 */     long[] arrayOfLong = new long[1];
/*     */     
/* 300 */     if (SteamMatchmakingNative.getLobbyGameServer(paramSteamID1.handle, paramArrayOfint, paramArrayOfshort, arrayOfLong)) {
/* 301 */       paramSteamID2.handle = arrayOfLong[0];
/* 302 */       return true;
/*     */     } 
/*     */     
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   public boolean setLobbyMemberLimit(SteamID paramSteamID, int paramInt) {
/* 309 */     return SteamMatchmakingNative.setLobbyMemberLimit(paramSteamID.handle, paramInt);
/*     */   }
/*     */   
/*     */   public int getLobbyMemberLimit(SteamID paramSteamID) {
/* 313 */     return SteamMatchmakingNative.getLobbyMemberLimit(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean setLobbyType(SteamID paramSteamID, LobbyType paramLobbyType) {
/* 317 */     return SteamMatchmakingNative.setLobbyType(paramSteamID.handle, paramLobbyType.ordinal());
/*     */   }
/*     */   
/*     */   public boolean setLobbyJoinable(SteamID paramSteamID, boolean paramBoolean) {
/* 321 */     return SteamMatchmakingNative.setLobbyJoinable(paramSteamID.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public SteamID getLobbyOwner(SteamID paramSteamID) {
/* 325 */     return new SteamID(SteamMatchmakingNative.getLobbyOwner(paramSteamID.handle));
/*     */   }
/*     */   
/*     */   public boolean setLobbyOwner(SteamID paramSteamID1, SteamID paramSteamID2) {
/* 329 */     return SteamMatchmakingNative.setLobbyOwner(paramSteamID1.handle, paramSteamID2.handle);
/*     */   }
/*     */   
/*     */   public boolean setLinkedLobby(SteamID paramSteamID1, SteamID paramSteamID2) {
/* 333 */     return SteamMatchmakingNative.setLinkedLobby(paramSteamID1.handle, paramSteamID2.handle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamMatchmaking.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */