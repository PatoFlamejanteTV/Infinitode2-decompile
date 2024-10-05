/*    */ package com.badlogic.gdx.net;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SocketHints
/*    */ {
/* 26 */   public int connectTimeout = 5000;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public int performancePrefConnectionTime = 0;
/* 35 */   public int performancePrefLatency = 1;
/* 36 */   public int performancePrefBandwidth = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   public int trafficClass = 20;
/*    */   
/*    */   public boolean keepAlive = true;
/*    */   
/*    */   public boolean tcpNoDelay = true;
/*    */   
/* 54 */   public int sendBufferSize = 4096;
/*    */   
/* 56 */   public int receiveBufferSize = 4096;
/*    */   
/*    */   public boolean linger = false;
/*    */   
/* 60 */   public int lingerDuration = 0;
/*    */ 
/*    */   
/* 63 */   public int socketTimeout = 0;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\SocketHints.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */