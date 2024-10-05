/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamAuthTicket
/*    */   extends SteamNativeHandle {
/*    */   static final long AuthTicketInvalid = 0L;
/*    */   
/*    */   SteamAuthTicket(long paramLong) {
/*  8 */     super(paramLong);
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 12 */     return (this.handle != 0L);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamAuthTicket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */