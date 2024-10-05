/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SteamMatchmakingServerNetAdr
/*    */ {
/*    */   short connectionPort;
/*    */   short queryPort;
/*    */   int ip;
/*    */   
/*    */   SteamMatchmakingServerNetAdr() {}
/*    */   
/*    */   public SteamMatchmakingServerNetAdr(int paramInt, short paramShort1, short paramShort2) {
/* 14 */     this.ip = paramInt;
/* 15 */     this.queryPort = paramShort1;
/* 16 */     this.connectionPort = paramShort2;
/*    */   }
/*    */   
/*    */   public short getConnectionPort() {
/* 20 */     return this.connectionPort;
/*    */   }
/*    */   
/*    */   public short getQueryPort() {
/* 24 */     return this.queryPort;
/*    */   }
/*    */   
/*    */   public int getIP() {
/* 28 */     return this.ip;
/*    */   }
/*    */   
/*    */   public String getConnectionAddressString() {
/* 32 */     return toString(this.ip, this.connectionPort);
/*    */   }
/*    */   
/*    */   public String getQueryAddressString() {
/* 36 */     return toString(this.ip, this.queryPort);
/*    */   }
/*    */   
/*    */   private static String toString(int paramInt, short paramShort) {
/* 40 */     return String.format("%d.%d.%d.%d:%d", new Object[] {
/* 41 */           Integer.valueOf(paramInt >>> 24), Integer.valueOf(paramInt >> 16 & 0xFF), Integer.valueOf(paramInt >> 8 & 0xFF), Integer.valueOf(paramInt & 0xFF), Short.valueOf(paramShort)
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamMatchmakingServerNetAdr.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */