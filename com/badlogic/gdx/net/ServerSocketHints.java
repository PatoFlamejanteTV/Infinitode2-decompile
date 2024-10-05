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
/*    */ 
/*    */ 
/*    */ public class ServerSocketHints
/*    */ {
/* 28 */   public int backlog = 16;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   public int performancePrefConnectionTime = 0;
/*    */   
/* 38 */   public int performancePrefLatency = 1;
/*    */   
/* 40 */   public int performancePrefBandwidth = 0;
/*    */   
/*    */   public boolean reuseAddress = true;
/*    */   
/* 44 */   public int acceptTimeout = 5000;
/*    */   
/* 46 */   public int receiveBufferSize = 4096;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\ServerSocketHints.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */