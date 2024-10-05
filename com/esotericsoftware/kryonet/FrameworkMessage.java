/*    */ package com.esotericsoftware.kryonet;
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
/*    */ public interface FrameworkMessage
/*    */ {
/* 32 */   public static final KeepAlive keepAlive = new KeepAlive();
/*    */   
/*    */   public static class RegisterTCP implements FrameworkMessage {
/*    */     public int connectionID;
/*    */   }
/*    */   
/*    */   public static class RegisterUDP implements FrameworkMessage {
/*    */     public int connectionID;
/*    */   }
/*    */   
/*    */   public static class KeepAlive implements FrameworkMessage {}
/*    */   
/*    */   public static class DiscoverHost implements FrameworkMessage {}
/*    */   
/*    */   public static class Ping implements FrameworkMessage {
/*    */     public int id;
/*    */     public boolean isReply;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\FrameworkMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */