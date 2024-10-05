/*     */ package com.badlogic.gdx.net;
/*     */ 
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NetJavaSocketImpl
/*     */   implements Socket
/*     */ {
/*     */   private Socket socket;
/*     */   
/*     */   public NetJavaSocketImpl(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints) {
/*     */     try {
/*  37 */       this.socket = new Socket();
/*  38 */       applyHints(paramSocketHints);
/*     */ 
/*     */       
/*  41 */       InetSocketAddress inetSocketAddress = new InetSocketAddress(paramString, paramInt);
/*  42 */       if (paramSocketHints != null) {
/*  43 */         this.socket.connect(inetSocketAddress, paramSocketHints.connectTimeout);
/*     */       } else {
/*  45 */         this.socket.connect(inetSocketAddress); return;
/*     */       } 
/*  47 */     } catch (Exception exception) {
/*  48 */       throw new GdxRuntimeException("Error making a socket connection to " + paramString + ":" + paramInt, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public NetJavaSocketImpl(Socket paramSocket, SocketHints paramSocketHints) {
/*  53 */     this.socket = paramSocket;
/*  54 */     applyHints(paramSocketHints);
/*     */   }
/*     */   
/*     */   private void applyHints(SocketHints paramSocketHints) {
/*  58 */     if (paramSocketHints != null) {
/*     */       try {
/*  60 */         this.socket.setPerformancePreferences(paramSocketHints.performancePrefConnectionTime, paramSocketHints.performancePrefLatency, paramSocketHints.performancePrefBandwidth);
/*     */         
/*  62 */         this.socket.setTrafficClass(paramSocketHints.trafficClass);
/*  63 */         this.socket.setTcpNoDelay(paramSocketHints.tcpNoDelay);
/*  64 */         this.socket.setKeepAlive(paramSocketHints.keepAlive);
/*  65 */         this.socket.setSendBufferSize(paramSocketHints.sendBufferSize);
/*  66 */         this.socket.setReceiveBufferSize(paramSocketHints.receiveBufferSize);
/*  67 */         this.socket.setSoLinger(paramSocketHints.linger, paramSocketHints.lingerDuration);
/*  68 */         this.socket.setSoTimeout(paramSocketHints.socketTimeout); return;
/*  69 */       } catch (Exception exception) {
/*  70 */         throw new GdxRuntimeException("Error setting socket hints.", exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnected() {
/*  77 */     if (this.socket != null) {
/*  78 */       return this.socket.isConnected();
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() {
/*     */     try {
/*  87 */       return this.socket.getInputStream();
/*  88 */     } catch (Exception exception) {
/*  89 */       throw new GdxRuntimeException("Error getting input stream from socket.", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream getOutputStream() {
/*     */     try {
/*  96 */       return this.socket.getOutputStream();
/*  97 */     } catch (Exception exception) {
/*  98 */       throw new GdxRuntimeException("Error getting output stream from socket.", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRemoteAddress() {
/* 104 */     return this.socket.getRemoteSocketAddress().toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 109 */     if (this.socket != null)
/*     */       try {
/* 111 */         this.socket.close();
/* 112 */         this.socket = null; return;
/* 113 */       } catch (Exception exception) {
/* 114 */         throw new GdxRuntimeException("Error closing socket.", exception);
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\NetJavaSocketImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */