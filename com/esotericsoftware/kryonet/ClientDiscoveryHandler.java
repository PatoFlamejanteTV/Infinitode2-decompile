/*    */ package com.esotericsoftware.kryonet;
/*    */ 
/*    */ import java.net.DatagramPacket;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ClientDiscoveryHandler
/*    */ {
/*    */   default DatagramPacket onRequestNewDatagramPacket() {
/* 36 */     return new DatagramPacket(new byte[0], 0);
/*    */   }
/*    */   
/*    */   default void onDiscoveredHost(DatagramPacket paramDatagramPacket) {}
/*    */   
/*    */   default void onFinally() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\ClientDiscoveryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */