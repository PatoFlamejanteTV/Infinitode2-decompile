/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamUser
/*     */   extends SteamInterface
/*     */ {
/*     */   public enum VoiceResult {
/*   9 */     OK,
/*  10 */     NotInitialized,
/*  11 */     NotRecording,
/*  12 */     NoData,
/*  13 */     BufferTooSmall,
/*  14 */     DataCorrupted,
/*  15 */     Restricted,
/*  16 */     UnsupportedCodec,
/*  17 */     ReceiverOutOfDate,
/*  18 */     ReceiverDidNotAnswer;
/*     */     
/*  20 */     private static final VoiceResult[] values = values();
/*     */     
/*     */     static VoiceResult byOrdinal(int param1Int) {
/*  23 */       return values[param1Int];
/*     */     } static {
/*     */     
/*     */     } }
/*     */   public SteamUser(SteamUserCallback paramSteamUserCallback) {
/*  28 */     super(SteamUserNative.createCallback(new SteamUserCallbackAdapter(paramSteamUserCallback)));
/*     */   }
/*     */   
/*     */   public SteamID getSteamID() {
/*  32 */     return new SteamID(SteamUserNative.getSteamID());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int initiateGameConnection(ByteBuffer paramByteBuffer, SteamID paramSteamID, int paramInt, short paramShort, boolean paramBoolean) {
/*  39 */     if (!paramByteBuffer.isDirect()) {
/*  40 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/*  46 */     if ((i = SteamUserNative.initiateGameConnection(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramSteamID.handle, paramInt, paramShort, paramBoolean)) > 0) {
/*  47 */       paramByteBuffer.limit(i);
/*     */     }
/*     */     
/*  50 */     return i;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void terminateGameConnection(int paramInt, short paramShort) {
/*  55 */     SteamUserNative.terminateGameConnection(paramInt, paramShort);
/*     */   }
/*     */   
/*     */   public void startVoiceRecording() {
/*  59 */     SteamUserNative.startVoiceRecording();
/*     */   }
/*     */   
/*     */   public void stopVoiceRecording() {
/*  63 */     SteamUserNative.stopVoiceRecording();
/*     */   }
/*     */ 
/*     */   
/*     */   public VoiceResult getAvailableVoice(int[] paramArrayOfint) {
/*     */     int i;
/*  69 */     return VoiceResult.byOrdinal(i = SteamUserNative.getAvailableVoice(paramArrayOfint));
/*     */   }
/*     */ 
/*     */   
/*     */   public VoiceResult getVoice(ByteBuffer paramByteBuffer, int[] paramArrayOfint) {
/*  74 */     if (!paramByteBuffer.isDirect()) {
/*  75 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/*     */     int i;
/*     */     
/*  80 */     return VoiceResult.byOrdinal(i = SteamUserNative.getVoice(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramArrayOfint));
/*     */   }
/*     */ 
/*     */   
/*     */   public VoiceResult decompressVoice(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int[] paramArrayOfint, int paramInt) {
/*  85 */     if (!paramByteBuffer1.isDirect()) {
/*  86 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/*  89 */     if (!paramByteBuffer2.isDirect()) {
/*  90 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/*  98 */     return VoiceResult.byOrdinal(i = SteamUserNative.decompressVoice(paramByteBuffer1, paramByteBuffer1.position(), paramByteBuffer1.remaining(), paramByteBuffer2, paramByteBuffer2.position(), paramByteBuffer2.remaining(), paramArrayOfint, paramInt));
/*     */   }
/*     */   
/*     */   public int getVoiceOptimalSampleRate() {
/* 102 */     return SteamUserNative.getVoiceOptimalSampleRate();
/*     */   }
/*     */ 
/*     */   
/*     */   public SteamAuthTicket getAuthSessionTicket(ByteBuffer paramByteBuffer, int[] paramArrayOfint) {
/* 107 */     if (!paramByteBuffer.isDirect()) {
/* 108 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 114 */     if ((i = SteamUserNative.getAuthSessionTicket(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramArrayOfint)) != 0L) {
/* 115 */       paramByteBuffer.limit(paramArrayOfint[0]);
/*     */     }
/*     */     
/* 118 */     return new SteamAuthTicket(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public SteamAuth.BeginAuthSessionResult beginAuthSession(ByteBuffer paramByteBuffer, SteamID paramSteamID) {
/* 123 */     if (!paramByteBuffer.isDirect()) {
/* 124 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 130 */     return SteamAuth.BeginAuthSessionResult.byOrdinal(i = SteamUserNative.beginAuthSession(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramSteamID.handle));
/*     */   }
/*     */   
/*     */   public void endAuthSession(SteamID paramSteamID) {
/* 134 */     SteamUserNative.endAuthSession(paramSteamID.handle);
/*     */   }
/*     */   
/*     */   public void cancelAuthTicket(SteamAuthTicket paramSteamAuthTicket) {
/* 138 */     SteamUserNative.cancelAuthTicket((int)paramSteamAuthTicket.handle);
/*     */   }
/*     */   
/*     */   public SteamAuth.UserHasLicenseForAppResult userHasLicenseForApp(SteamID paramSteamID, int paramInt) {
/* 142 */     return SteamAuth.UserHasLicenseForAppResult.byOrdinal(
/* 143 */         SteamUserNative.userHasLicenseForApp(paramSteamID.handle, paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public SteamAPICall requestEncryptedAppTicket(ByteBuffer paramByteBuffer) {
/* 148 */     if (!paramByteBuffer.isDirect()) {
/* 149 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 152 */     return new SteamAPICall(SteamUserNative.requestEncryptedAppTicket(this.callback, paramByteBuffer, paramByteBuffer
/* 153 */           .position(), paramByteBuffer.remaining()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getEncryptedAppTicket(ByteBuffer paramByteBuffer, int[] paramArrayOfint) {
/* 158 */     if (!paramByteBuffer.isDirect()) {
/* 159 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 162 */     return SteamUserNative.getEncryptedAppTicket(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramArrayOfint);
/*     */   }
/*     */   
/*     */   public boolean isBehindNAT() {
/* 166 */     return SteamUserNative.isBehindNAT();
/*     */   }
/*     */   
/*     */   public void advertiseGame(SteamID paramSteamID, int paramInt, short paramShort) {
/* 170 */     SteamUserNative.advertiseGame(paramSteamID.handle, paramInt, paramShort);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */