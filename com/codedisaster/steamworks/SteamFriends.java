/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.util.Collection;
/*     */ 
/*     */ public class SteamFriends
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum FriendRelationship {
/*   9 */     None,
/*  10 */     Blocked,
/*  11 */     Recipient,
/*  12 */     Friend,
/*  13 */     RequestInitiator,
/*  14 */     Ignored,
/*  15 */     IgnoredFriend,
/*  16 */     Suggested_DEPRECATED,
/*  17 */     Max;
/*     */     
/*  19 */     private static final FriendRelationship[] values = values();
/*     */     
/*     */     static FriendRelationship byOrdinal(int param1Int) {
/*  22 */       return values[param1Int];
/*     */     }
/*     */     static {
/*     */     
/*     */     } }
/*  27 */   public enum PersonaState { Offline,
/*  28 */     Online,
/*  29 */     Busy,
/*  30 */     Away,
/*  31 */     Snooze,
/*  32 */     LookingToTrade,
/*  33 */     LookingToPlay,
/*  34 */     Invisible;
/*     */     
/*  36 */     private static final PersonaState[] values = values(); static {
/*     */     
/*     */     } static PersonaState byOrdinal(int param1Int) {
/*  39 */       return values[param1Int];
/*     */     } }
/*     */ 
/*     */   
/*     */   public enum FriendFlags
/*     */   {
/*  45 */     None(0),
/*  46 */     Blocked(1),
/*  47 */     FriendshipRequested(2),
/*  48 */     Immediate(4),
/*  49 */     ClanMember(8),
/*  50 */     OnGameServer(16),
/*     */ 
/*     */     
/*  53 */     RequestingFriendship(128),
/*  54 */     RequestingInfo(256),
/*  55 */     Ignored(512),
/*  56 */     IgnoredFriend(1024),
/*     */     
/*  58 */     ChatMember(4096),
/*  59 */     All(65535);
/*     */     
/*     */     private final int bits;
/*     */     
/*     */     FriendFlags(int param1Int1) {
/*  64 */       this.bits = param1Int1;
/*     */     }
/*     */     
/*     */     static int asBits(Collection<FriendFlags> param1Collection) {
/*  68 */       int i = 0;
/*  69 */       for (FriendFlags friendFlags : param1Collection) {
/*  70 */         i |= friendFlags.bits;
/*     */       }
/*  72 */       return i;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum PersonaChange
/*     */   {
/*  78 */     Name(1),
/*  79 */     Status(2),
/*  80 */     ComeOnline(4),
/*  81 */     GoneOffline(8),
/*  82 */     GamePlayed(16),
/*  83 */     GameServer(32),
/*  84 */     Avatar(64),
/*  85 */     JoinedSource(128),
/*  86 */     LeftSource(256),
/*  87 */     RelationshipChanged(512),
/*  88 */     NameFirstSet(1024),
/*  89 */     Broadcast(2048),
/*  90 */     Nickname(4096),
/*  91 */     SteamLevel(8192),
/*  92 */     RichPresence(16384);
/*     */     
/*     */     private final int bits;
/*     */     
/*     */     PersonaChange(int param1Int1) {
/*  97 */       this.bits = param1Int1;
/*     */     }
/*     */     
/*     */     static boolean isSet(PersonaChange param1PersonaChange, int param1Int) {
/* 101 */       return ((param1PersonaChange.bits & param1Int) == param1PersonaChange.bits);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FriendGameInfo
/*     */   {
/*     */     private long gameID;
/*     */     private int gameIP;
/*     */     private short gamePort;
/*     */     private short queryPort;
/*     */     private long steamIDLobby;
/*     */     
/*     */     public long getGameID() {
/* 114 */       return this.gameID;
/*     */     }
/*     */     
/*     */     public int getGameIP() {
/* 118 */       return this.gameIP;
/*     */     }
/*     */     
/*     */     public short getGamePort() {
/* 122 */       return this.gamePort;
/*     */     }
/*     */     
/*     */     public short getQueryPort() {
/* 126 */       return this.queryPort;
/*     */     }
/*     */     
/*     */     public SteamID getSteamIDLobby() {
/* 130 */       return new SteamID(this.steamIDLobby);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum OverlayDialog
/*     */   {
/* 136 */     Friends("Friends"),
/* 137 */     Community("Community"),
/* 138 */     Players("Players"),
/* 139 */     Settings("Settings"),
/* 140 */     OfficialGameGroup("OfficialGameGroup"),
/* 141 */     Stats("Stats"),
/* 142 */     Achievements("Achievements");
/*     */     
/*     */     private final String id;
/*     */     
/*     */     OverlayDialog(String param1String1) {
/* 147 */       this.id = param1String1;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum OverlayToUserDialog
/*     */   {
/* 153 */     SteamID("steamid"),
/* 154 */     Chat("chat"),
/* 155 */     JoinTrade("jointrade"),
/* 156 */     Stats("stats"),
/* 157 */     Achievements("achievements"),
/* 158 */     FriendAdd("friendadd"),
/* 159 */     FriendRemove("friendremove"),
/* 160 */     FriendRequestAccept("friendrequestaccept"),
/* 161 */     FriendRequestIgnore("friendrequestignore");
/*     */     
/*     */     private final String id;
/*     */     
/*     */     OverlayToUserDialog(String param1String1) {
/* 166 */       this.id = param1String1;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum OverlayToStoreFlag
/*     */   {
/* 172 */     None,
/* 173 */     AddToCart,
/* 174 */     AddToCartAndShow;
/*     */   }
/*     */   
/*     */   public enum OverlayToWebPageMode {
/* 178 */     Default,
/* 179 */     Modal;
/*     */   }
/*     */   
/*     */   public SteamFriends(SteamFriendsCallback paramSteamFriendsCallback) {
/* 183 */     super(SteamFriendsNative.createCallback(new SteamFriendsCallbackAdapter(paramSteamFriendsCallback)));
/*     */   }
/*     */   
/*     */   public String getPersonaName() {
/* 187 */     return SteamFriendsNative.getPersonaName();
/*     */   }
/*     */   
/*     */   public SteamAPICall setPersonaName(String paramString) {
/* 191 */     return new SteamAPICall(SteamFriendsNative.setPersonaName(this.callback, paramString));
/*     */   }
/*     */   
/*     */   public PersonaState getPersonaState() {
/* 195 */     return PersonaState.byOrdinal(SteamFriendsNative.getPersonaState());
/*     */   }
/*     */   
/*     */   public int getFriendCount(FriendFlags paramFriendFlags) {
/* 199 */     return SteamFriendsNative.getFriendCount(paramFriendFlags.bits);
/*     */   }
/*     */   
/*     */   public int getFriendCount(Collection<FriendFlags> paramCollection) {
/* 203 */     return SteamFriendsNative.getFriendCount(FriendFlags.asBits(paramCollection));
/*     */   }
/*     */   
/*     */   public SteamID getFriendByIndex(int paramInt, FriendFlags paramFriendFlags) {
/* 207 */     return new SteamID(SteamFriendsNative.getFriendByIndex(paramInt, paramFriendFlags.bits));
/*     */   }
/*     */   
/*     */   public SteamID getFriendByIndex(int paramInt, Collection<FriendFlags> paramCollection) {
/* 211 */     return new SteamID(SteamFriendsNative.getFriendByIndex(paramInt, FriendFlags.asBits(paramCollection)));
/*     */   }
/*     */   
/*     */   public FriendRelationship getFriendRelationship(SteamID paramSteamID) {
/* 215 */     return FriendRelationship.byOrdinal(SteamFriendsNative.getFriendRelationship(paramSteamID.handle));
/*     */   }
/*     */   
/*     */   public PersonaState getFriendPersonaState(SteamID paramSteamID) {
/* 219 */     return PersonaState.byOrdinal(SteamFriendsNative.getFriendPersonaState(paramSteamID.handle));
/*     */   }
/*     */   
/*     */   public String getFriendPersonaName(SteamID paramSteamID) {
/* 223 */     return SteamFriendsNative.getFriendPersonaName(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean getFriendGamePlayed(SteamID paramSteamID, FriendGameInfo paramFriendGameInfo) {
/* 227 */     return SteamFriendsNative.getFriendGamePlayed(paramSteamID.handle, paramFriendGameInfo);
/*     */   }
/*     */   
/*     */   public void setInGameVoiceSpeaking(SteamID paramSteamID, boolean paramBoolean) {
/* 231 */     SteamFriendsNative.setInGameVoiceSpeaking(paramSteamID.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public int getSmallFriendAvatar(SteamID paramSteamID) {
/* 235 */     return SteamFriendsNative.getSmallFriendAvatar(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public int getMediumFriendAvatar(SteamID paramSteamID) {
/* 239 */     return SteamFriendsNative.getMediumFriendAvatar(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public int getLargeFriendAvatar(SteamID paramSteamID) {
/* 243 */     return SteamFriendsNative.getLargeFriendAvatar(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean requestUserInformation(SteamID paramSteamID, boolean paramBoolean) {
/* 247 */     return SteamFriendsNative.requestUserInformation(paramSteamID.handle, paramBoolean);
/*     */   }
/*     */   
/*     */   public void activateGameOverlay(OverlayDialog paramOverlayDialog) {
/* 251 */     SteamFriendsNative.activateGameOverlay(paramOverlayDialog.id);
/*     */   }
/*     */   
/*     */   public void activateGameOverlayToUser(OverlayToUserDialog paramOverlayToUserDialog, SteamID paramSteamID) {
/* 255 */     SteamFriendsNative.activateGameOverlayToUser(paramOverlayToUserDialog.id, paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public void activateGameOverlayToWebPage(String paramString, OverlayToWebPageMode paramOverlayToWebPageMode) {
/* 259 */     SteamFriendsNative.activateGameOverlayToWebPage(paramString, paramOverlayToWebPageMode.ordinal());
/*     */   }
/*     */   
/*     */   public void activateGameOverlayToStore(int paramInt, OverlayToStoreFlag paramOverlayToStoreFlag) {
/* 263 */     SteamFriendsNative.activateGameOverlayToStore(paramInt, paramOverlayToStoreFlag.ordinal());
/*     */   }
/*     */   
/*     */   public void setPlayedWith(SteamID paramSteamID) {
/* 267 */     SteamFriendsNative.setPlayedWith(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public void activateGameOverlayInviteDialog(SteamID paramSteamID) {
/* 271 */     SteamFriendsNative.activateGameOverlayInviteDialog(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean setRichPresence(String paramString1, String paramString2) {
/* 275 */     return SteamFriendsNative.setRichPresence(paramString1, (paramString2 != null) ? paramString2 : "");
/*     */   }
/*     */   
/*     */   public void clearRichPresence() {
/* 279 */     SteamFriendsNative.clearRichPresence();
/*     */   }
/*     */   
/*     */   public String getFriendRichPresence(SteamID paramSteamID, String paramString) {
/* 283 */     return SteamFriendsNative.getFriendRichPresence(paramSteamID.handle, paramString);
/*     */   }
/*     */   
/*     */   public int getFriendRichPresenceKeyCount(SteamID paramSteamID) {
/* 287 */     return SteamFriendsNative.getFriendRichPresenceKeyCount(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public String getFriendRichPresenceKeyByIndex(SteamID paramSteamID, int paramInt) {
/* 291 */     return SteamFriendsNative.getFriendRichPresenceKeyByIndex(paramSteamID.handle, paramInt);
/*     */   }
/*     */   
/*     */   public void requestFriendRichPresence(SteamID paramSteamID) {
/* 295 */     SteamFriendsNative.requestFriendRichPresence(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean inviteUserToGame(SteamID paramSteamID, String paramString) {
/* 299 */     return SteamFriendsNative.inviteUserToGame(paramSteamID.handle, paramString);
/*     */   }
/*     */   
/*     */   public int getCoplayFriendCount() {
/* 303 */     return SteamFriendsNative.getCoplayFriendCount();
/*     */   }
/*     */   
/*     */   public SteamID getCoplayFriend(int paramInt) {
/* 307 */     return new SteamID(SteamFriendsNative.getCoplayFriend(paramInt));
/*     */   }
/*     */   
/*     */   public int getFriendCoplayTime(SteamID paramSteamID) {
/* 311 */     return SteamFriendsNative.getFriendCoplayTime(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public int getFriendCoplayGame(SteamID paramSteamID) {
/* 315 */     return SteamFriendsNative.getFriendCoplayGame(paramSteamID.handle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamFriends.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */