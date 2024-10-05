/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamNetworking extends SteamInterface {
/*     */   private final boolean isServer;
/*     */   
/*     */   public enum P2PSend {
/*   9 */     Unreliable,
/*  10 */     UnreliableNoDelay,
/*  11 */     Reliable,
/*  12 */     ReliableWithBuffering;
/*     */   }
/*     */   
/*     */   public enum P2PSessionError {
/*  16 */     None,
/*  17 */     NotRunningApp,
/*  18 */     NoRightsToApp,
/*  19 */     DestinationNotLoggedIn,
/*  20 */     Timeout;
/*     */     
/*  22 */     private static final P2PSessionError[] values = values();
/*     */     
/*     */     public static P2PSessionError byOrdinal(int param1Int) {
/*  25 */       return values[param1Int];
/*     */     }
/*     */     static {
/*     */     
/*     */     } }
/*     */   
/*     */   public static class P2PSessionState { byte connectionActive;
/*     */     byte connecting;
/*     */     byte sessionError;
/*     */     byte usingRelay;
/*     */     int bytesQueuedForSend;
/*     */     int packetsQueuedForSend;
/*     */     int remoteIP;
/*     */     short remotePort;
/*     */     
/*     */     public boolean isConnectionActive() {
/*  41 */       return (this.connectionActive != 0);
/*     */     }
/*     */     
/*     */     public boolean isConnecting() {
/*  45 */       return (this.connecting != 0);
/*     */     }
/*     */     
/*     */     public SteamNetworking.P2PSessionError getLastSessionError() {
/*  49 */       return SteamNetworking.P2PSessionError.byOrdinal(this.sessionError);
/*     */     }
/*     */     
/*     */     public boolean isUsingRelay() {
/*  53 */       return (this.usingRelay != 0);
/*     */     }
/*     */     
/*     */     public int getBytesQueuedForSend() {
/*  57 */       return this.bytesQueuedForSend;
/*     */     }
/*     */     
/*     */     public int getPacketsQueuedForSend() {
/*  61 */       return this.packetsQueuedForSend;
/*     */     }
/*     */     
/*     */     public int getRemoteIP() {
/*  65 */       return this.remoteIP;
/*     */     }
/*     */     
/*     */     public short getRemotePort() {
/*  69 */       return this.remotePort;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*  74 */   private final int[] tmpIntResult = new int[1];
/*  75 */   private final long[] tmpLongResult = new long[1];
/*     */   
/*     */   public SteamNetworking(SteamNetworkingCallback paramSteamNetworkingCallback) {
/*  78 */     this(false, SteamNetworkingNative.createCallback(new SteamNetworkingCallbackAdapter(paramSteamNetworkingCallback)));
/*     */   }
/*     */   
/*     */   SteamNetworking(boolean paramBoolean, long paramLong) {
/*  82 */     super(paramLong);
/*  83 */     this.isServer = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendP2PPacket(SteamID paramSteamID, ByteBuffer paramByteBuffer, P2PSend paramP2PSend, int paramInt) {
/*  89 */     if (!paramByteBuffer.isDirect()) {
/*  90 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/*  93 */     return SteamNetworkingNative.sendP2PPacket(this.isServer, paramSteamID.handle, paramByteBuffer, paramByteBuffer
/*  94 */         .position(), paramByteBuffer.remaining(), paramP2PSend.ordinal(), paramInt);
/*     */   }
/*     */   
/*     */   public boolean isP2PPacketAvailable(int paramInt, int[] paramArrayOfint) {
/*  98 */     return SteamNetworkingNative.isP2PPacketAvailable(this.isServer, paramArrayOfint, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readP2PPacket(SteamID paramSteamID, ByteBuffer paramByteBuffer, int paramInt) {
/* 109 */     if (!paramByteBuffer.isDirect()) {
/* 110 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 113 */     if (SteamNetworkingNative.readP2PPacket(this.isServer, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), this.tmpIntResult, this.tmpLongResult, paramInt)) {
/* 114 */       paramSteamID.handle = this.tmpLongResult[0];
/* 115 */       return this.tmpIntResult[0];
/*     */     } 
/*     */     
/* 118 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean acceptP2PSessionWithUser(SteamID paramSteamID) {
/* 122 */     return SteamNetworkingNative.acceptP2PSessionWithUser(this.isServer, paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean closeP2PSessionWithUser(SteamID paramSteamID) {
/* 126 */     return SteamNetworkingNative.closeP2PSessionWithUser(this.isServer, paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public boolean closeP2PChannelWithUser(SteamID paramSteamID, int paramInt) {
/* 130 */     return SteamNetworkingNative.closeP2PChannelWithUser(this.isServer, paramSteamID.handle, paramInt);
/*     */   }
/*     */   
/*     */   public boolean getP2PSessionState(SteamID paramSteamID, P2PSessionState paramP2PSessionState) {
/* 134 */     return SteamNetworkingNative.getP2PSessionState(this.isServer, paramSteamID.handle, paramP2PSessionState);
/*     */   }
/*     */   
/*     */   public boolean allowP2PPacketRelay(boolean paramBoolean) {
/* 138 */     return SteamNetworkingNative.allowP2PPacketRelay(this.isServer, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamNetworking.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */