/*    */ package com.esotericsoftware.kryonet.util;
/*    */ 
/*    */ import com.esotericsoftware.kryonet.Connection;
/*    */ import com.esotericsoftware.kryonet.Listener;
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
/*    */ public abstract class TcpIdleSender
/*    */   implements Listener
/*    */ {
/*    */   boolean started;
/*    */   
/*    */   public void idle(Connection paramConnection) {
/* 30 */     if (!this.started) {
/* 31 */       this.started = true;
/* 32 */       start();
/*    */     } 
/*    */     Object object;
/* 35 */     if ((object = next()) == null) {
/* 36 */       paramConnection.removeListener(this); return;
/*    */     } 
/* 38 */     paramConnection.sendTCP(object);
/*    */   }
/*    */   
/*    */   protected void start() {}
/*    */   
/*    */   protected abstract Object next();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryone\\util\TcpIdleSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */