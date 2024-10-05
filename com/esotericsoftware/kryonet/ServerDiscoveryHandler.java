/*    */ package com.esotericsoftware.kryonet;
/*    */ 
/*    */ import java.net.InetSocketAddress;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.channels.DatagramChannel;
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
/*    */ public interface ServerDiscoveryHandler
/*    */ {
/* 31 */   public static final ByteBuffer emptyBuffer = ByteBuffer.allocate(0);
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
/*    */   default boolean onDiscoverHost(DatagramChannel paramDatagramChannel, InetSocketAddress paramInetSocketAddress) {
/* 46 */     paramDatagramChannel.send(emptyBuffer, paramInetSocketAddress);
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\ServerDiscoveryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */