/*    */ package com.badlogic.gdx.net;
/*    */ 
/*    */ import com.badlogic.gdx.Net;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.ServerSocket;
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
/*    */ public class NetJavaServerSocketImpl
/*    */   implements ServerSocket
/*    */ {
/*    */   private Net.Protocol protocol;
/*    */   private ServerSocket server;
/*    */   
/*    */   public NetJavaServerSocketImpl(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 35 */     this(paramProtocol, null, paramInt, paramServerSocketHints);
/*    */   }
/*    */   
/*    */   public NetJavaServerSocketImpl(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 39 */     this.protocol = paramProtocol;
/*    */     
/*    */     try {
/*    */       InetSocketAddress inetSocketAddress;
/*    */       
/* 44 */       this.server = new ServerSocket();
/* 45 */       if (paramServerSocketHints != null) {
/* 46 */         this.server.setPerformancePreferences(paramServerSocketHints.performancePrefConnectionTime, paramServerSocketHints.performancePrefLatency, paramServerSocketHints.performancePrefBandwidth);
/*    */         
/* 48 */         this.server.setReuseAddress(paramServerSocketHints.reuseAddress);
/* 49 */         this.server.setSoTimeout(paramServerSocketHints.acceptTimeout);
/* 50 */         this.server.setReceiveBufferSize(paramServerSocketHints.receiveBufferSize);
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 55 */       if (paramString != null) {
/* 56 */         inetSocketAddress = new InetSocketAddress(paramString, paramInt);
/*    */       } else {
/* 58 */         inetSocketAddress = new InetSocketAddress(paramInt);
/*    */       } 
/*    */       
/* 61 */       if (paramServerSocketHints != null) {
/* 62 */         this.server.bind(inetSocketAddress, paramServerSocketHints.backlog);
/*    */       } else {
/* 64 */         this.server.bind(inetSocketAddress); return;
/*    */       } 
/* 66 */     } catch (Exception exception) {
/* 67 */       throw new GdxRuntimeException("Cannot create a server socket at port " + paramInt + ".", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Net.Protocol getProtocol() {
/* 73 */     return this.protocol;
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket accept(SocketHints paramSocketHints) {
/*    */     try {
/* 79 */       return new NetJavaSocketImpl(this.server.accept(), paramSocketHints);
/* 80 */     } catch (Exception exception) {
/* 81 */       throw new GdxRuntimeException("Error accepting socket.", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 87 */     if (this.server != null)
/*    */       try {
/* 89 */         this.server.close();
/* 90 */         this.server = null; return;
/* 91 */       } catch (Exception exception) {
/* 92 */         throw new GdxRuntimeException("Error closing server.", exception);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\NetJavaServerSocketImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */