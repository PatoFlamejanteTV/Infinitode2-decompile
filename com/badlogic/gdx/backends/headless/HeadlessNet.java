/*    */ package com.badlogic.gdx.backends.headless;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.Net;
/*    */ import com.badlogic.gdx.net.NetJavaImpl;
/*    */ import com.badlogic.gdx.net.NetJavaServerSocketImpl;
/*    */ import com.badlogic.gdx.net.NetJavaSocketImpl;
/*    */ import com.badlogic.gdx.net.ServerSocket;
/*    */ import com.badlogic.gdx.net.ServerSocketHints;
/*    */ import com.badlogic.gdx.net.Socket;
/*    */ import com.badlogic.gdx.net.SocketHints;
/*    */ import java.awt.Desktop;
/*    */ import java.awt.GraphicsEnvironment;
/*    */ import java.net.URI;
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
/*    */ public class HeadlessNet
/*    */   implements Net
/*    */ {
/*    */   NetJavaImpl netJavaImpl;
/*    */   
/*    */   public HeadlessNet(HeadlessApplicationConfiguration paramHeadlessApplicationConfiguration) {
/* 41 */     this.netJavaImpl = new NetJavaImpl(paramHeadlessApplicationConfiguration.maxNetThreads);
/*    */   }
/*    */ 
/*    */   
/*    */   public void sendHttpRequest(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener) {
/* 46 */     this.netJavaImpl.sendHttpRequest(paramHttpRequest, paramHttpResponseListener);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelHttpRequest(Net.HttpRequest paramHttpRequest) {
/* 51 */     this.netJavaImpl.cancelHttpRequest(paramHttpRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isHttpRequestPending(Net.HttpRequest paramHttpRequest) {
/* 56 */     return this.netJavaImpl.isHttpRequestPending(paramHttpRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public ServerSocket newServerSocket(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 61 */     return (ServerSocket)new NetJavaServerSocketImpl(paramProtocol, paramString, paramInt, paramServerSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public ServerSocket newServerSocket(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 66 */     return (ServerSocket)new NetJavaServerSocketImpl(paramProtocol, paramInt, paramServerSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket newClientSocket(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints) {
/* 71 */     return (Socket)new NetJavaSocketImpl(paramProtocol, paramString, paramInt, paramSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean openURI(String paramString) {
/* 76 */     boolean bool = false;
/*    */     try {
/* 78 */       if (!GraphicsEnvironment.isHeadless() && Desktop.isDesktopSupported()) {
/* 79 */         if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
/* 80 */           Desktop.getDesktop().browse(URI.create(paramString));
/* 81 */           bool = true;
/*    */         } 
/*    */       } else {
/* 84 */         Gdx.app.error("HeadlessNet", "Opening URIs on this environment is not supported. Ignoring.");
/*    */       } 
/* 86 */     } catch (Throwable throwable) {
/* 87 */       Gdx.app.error("HeadlessNet", "Failed to open URI. ", throwable);
/*    */     } 
/* 89 */     return bool;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\HeadlessNet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */