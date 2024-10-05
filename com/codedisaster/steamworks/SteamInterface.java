/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ import java.nio.Buffer;
/*    */ 
/*    */ abstract class SteamInterface
/*    */ {
/*    */   protected long callback;
/*    */   
/*    */   SteamInterface() {
/* 10 */     this(0L);
/*    */   }
/*    */   
/*    */   SteamInterface(long paramLong) {
/* 14 */     this.callback = paramLong;
/*    */   }
/*    */   
/*    */   void setCallback(long paramLong) {
/* 18 */     this.callback = paramLong;
/*    */   }
/*    */   
/*    */   public void dispose() {
/* 22 */     deleteCallback(this.callback);
/*    */   }
/*    */   
/*    */   void checkBuffer(Buffer paramBuffer) {
/* 26 */     if (!paramBuffer.isDirect()) {
/* 27 */       throw new SteamException("Direct buffer required.");
/*    */     }
/*    */   }
/*    */   
/*    */   void checkArray(byte[] paramArrayOfbyte, int paramInt) {
/* 32 */     if (paramArrayOfbyte.length < paramInt)
/* 33 */       throw new SteamException("Array too small, " + paramArrayOfbyte.length + " found but " + paramInt + " expected."); 
/*    */   }
/*    */   
/*    */   protected static native void deleteCallback(long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */