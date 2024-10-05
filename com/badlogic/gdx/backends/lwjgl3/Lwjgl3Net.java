/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ import com.badlogic.gdx.Net;
/*    */ import com.badlogic.gdx.net.NetJavaImpl;
/*    */ import com.badlogic.gdx.net.NetJavaServerSocketImpl;
/*    */ import com.badlogic.gdx.net.NetJavaSocketImpl;
/*    */ import com.badlogic.gdx.net.ServerSocket;
/*    */ import com.badlogic.gdx.net.ServerSocketHints;
/*    */ import com.badlogic.gdx.net.Socket;
/*    */ import com.badlogic.gdx.net.SocketHints;
/*    */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*    */ import java.awt.Desktop;
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
/*    */ public class Lwjgl3Net
/*    */   implements Net
/*    */ {
/*    */   NetJavaImpl netJavaImpl;
/*    */   
/*    */   public Lwjgl3Net(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration) {
/* 39 */     this.netJavaImpl = new NetJavaImpl(paramLwjgl3ApplicationConfiguration.maxNetThreads);
/*    */   }
/*    */ 
/*    */   
/*    */   public void sendHttpRequest(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener) {
/* 44 */     this.netJavaImpl.sendHttpRequest(paramHttpRequest, paramHttpResponseListener);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelHttpRequest(Net.HttpRequest paramHttpRequest) {
/* 49 */     this.netJavaImpl.cancelHttpRequest(paramHttpRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isHttpRequestPending(Net.HttpRequest paramHttpRequest) {
/* 54 */     return this.netJavaImpl.isHttpRequestPending(paramHttpRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public ServerSocket newServerSocket(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 59 */     return (ServerSocket)new NetJavaServerSocketImpl(paramProtocol, paramString, paramInt, paramServerSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public ServerSocket newServerSocket(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints) {
/* 64 */     return (ServerSocket)new NetJavaServerSocketImpl(paramProtocol, paramInt, paramServerSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public Socket newClientSocket(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints) {
/* 69 */     return (Socket)new NetJavaSocketImpl(paramProtocol, paramString, paramInt, paramSocketHints);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean openURI(String paramString) {
/* 74 */     if (SharedLibraryLoader.isMac)
/*    */       try {
/* 76 */         (new ProcessBuilder(new String[] { "open", (new URI(paramString)).toString() })).start();
/* 77 */         return true;
/* 78 */       } catch (Throwable throwable) {
/* 79 */         return false;
/*    */       }  
/* 81 */     if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
/*    */       try {
/* 83 */         Desktop.getDesktop().browse(new URI(paramString));
/* 84 */         return true;
/* 85 */       } catch (Throwable throwable) {
/* 86 */         return false;
/*    */       }  
/* 88 */     if (SharedLibraryLoader.isLinux) {
/*    */       try {
/* 90 */         (new ProcessBuilder(new String[] { "xdg-open", (new URI(paramString)).toString() })).start();
/* 91 */         return true;
/* 92 */       } catch (Throwable throwable) {
/* 93 */         return false;
/*    */       } 
/*    */     }
/* 96 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Net.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */