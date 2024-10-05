/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import com.esotericsoftware.kryonet.serialization.Serialization;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.SocketException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.DatagramChannel;
/*     */ import java.nio.channels.SelectionKey;
/*     */ import java.nio.channels.Selector;
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
/*     */ public class UdpConnection
/*     */ {
/*     */   public static boolean androidFixDisabled = false;
/*     */   InetSocketAddress connectedAddress;
/*     */   DatagramChannel datagramChannel;
/*  54 */   int keepAliveMillis = 19000;
/*     */   
/*     */   final ByteBuffer readBuffer;
/*     */   final ByteBuffer writeBuffer;
/*  58 */   private final Object writeLock = new Object(); private final Serialization serialization; private SelectionKey selectionKey;
/*     */   private long lastCommunicationTime;
/*     */   
/*     */   public UdpConnection(Serialization paramSerialization, int paramInt) {
/*  62 */     this.serialization = paramSerialization;
/*  63 */     this.readBuffer = ByteBuffer.allocate(paramInt);
/*  64 */     this.writeBuffer = ByteBuffer.allocateDirect(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(Selector paramSelector, InetSocketAddress paramInetSocketAddress) {
/*  69 */     close();
/*  70 */     this.readBuffer.clear();
/*  71 */     this.writeBuffer.clear();
/*     */     try {
/*  73 */       this.datagramChannel = paramSelector.provider().openDatagramChannel();
/*  74 */       this.datagramChannel.socket().bind(paramInetSocketAddress);
/*  75 */       this.datagramChannel.configureBlocking(false);
/*  76 */       this.selectionKey = this.datagramChannel.register(paramSelector, 1);
/*     */ 
/*     */       
/*  79 */       this.lastCommunicationTime = System.currentTimeMillis(); return;
/*  80 */     } catch (IOException iOException) {
/*  81 */       close();
/*  82 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void connect(Selector paramSelector, InetSocketAddress paramInetSocketAddress) {
/*  88 */     close();
/*  89 */     this.readBuffer.clear();
/*  90 */     this.writeBuffer.clear();
/*     */     try {
/*  92 */       this.datagramChannel = paramSelector.provider().openDatagramChannel();
/*  93 */       this.datagramChannel.socket().bind(null);
/*  94 */       this.datagramChannel.socket().connect(paramInetSocketAddress);
/*  95 */       this.datagramChannel.configureBlocking(false);
/*     */       
/*  97 */       this.selectionKey = this.datagramChannel.register(paramSelector, 1);
/*     */ 
/*     */       
/* 100 */       this.lastCommunicationTime = System.currentTimeMillis();
/*     */       
/* 102 */       this.connectedAddress = paramInetSocketAddress; return;
/* 103 */     } catch (IOException iOException1) {
/* 104 */       close();
/*     */       
/*     */       IOException iOException2;
/* 107 */       (iOException2 = new IOException("Unable to connect to: " + paramInetSocketAddress)).initCause(iOException1);
/* 108 */       throw iOException2;
/*     */     } 
/*     */   }
/*     */   
/*     */   public InetSocketAddress readFromAddress() {
/*     */     DatagramChannel datagramChannel;
/* 114 */     if ((datagramChannel = this.datagramChannel) == null)
/* 115 */       throw new SocketException("Connection is closed."); 
/* 116 */     this.lastCommunicationTime = System.currentTimeMillis();
/*     */     
/* 118 */     if (androidFixDisabled || !datagramChannel.isConnected()) {
/* 119 */       return (InetSocketAddress)datagramChannel.receive(this.readBuffer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     datagramChannel.read(this.readBuffer);
/* 126 */     return this.connectedAddress;
/*     */   }
/*     */   
/*     */   public Object readObject(Connection paramConnection) {
/* 130 */     this.readBuffer.flip();
/*     */     
/*     */     try {
/* 133 */       Object object = this.serialization.read(paramConnection, this.readBuffer);
/* 134 */       if (this.readBuffer.hasRemaining()) {
/* 135 */         throw new KryoNetException("Incorrect number of bytes (" + this.readBuffer
/* 136 */             .remaining() + " remaining) used to deserialize object: " + object);
/*     */       }
/*     */       
/* 139 */       object = object; return object;
/* 140 */     } catch (Exception exception) {
/* 141 */       throw new KryoNetException("Error during deserialization.", exception);
/*     */     } finally {
/*     */       
/* 144 */       this.readBuffer.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int send(Connection paramConnection, Object paramObject, SocketAddress paramSocketAddress) {
/*     */     DatagramChannel datagramChannel;
/* 154 */     if ((datagramChannel = this.datagramChannel) == null)
/* 155 */       throw new SocketException("Connection is closed."); 
/* 156 */     synchronized (this.writeLock) {
/*     */       try {
/*     */         try {
/* 159 */           this.serialization.write(paramConnection, this.writeBuffer, paramObject);
/* 160 */         } catch (Exception exception) {
/* 161 */           throw new KryoNetException("Error serializing object of type: " + paramObject
/*     */               
/* 163 */               .getClass().getName(), exception);
/*     */         } 
/*     */         
/* 166 */         this.writeBuffer.flip();
/* 167 */         int i = this.writeBuffer.limit();
/* 168 */         datagramChannel.send(this.writeBuffer, paramSocketAddress);
/*     */         
/* 170 */         this.lastCommunicationTime = System.currentTimeMillis();
/*     */         
/*     */         boolean bool;
/* 173 */         i = (bool = !this.writeBuffer.hasRemaining() ? true : false) ? i : -1; return i;
/*     */       } finally {
/* 175 */         this.writeBuffer.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() {
/* 181 */     this.connectedAddress = null;
/*     */     try {
/* 183 */       if (this.datagramChannel != null) {
/* 184 */         this.datagramChannel.close();
/* 185 */         this.datagramChannel = null;
/* 186 */         if (this.selectionKey != null)
/* 187 */           this.selectionKey.selector().wakeup(); 
/*     */       }  return;
/* 189 */     } catch (IOException iOException) {
/* 190 */       if (Log.DEBUG)
/* 191 */         Log.debug("kryonet", "Unable to close UDP connection.", iOException); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public boolean needsKeepAlive(long paramLong) {
/* 196 */     return (this.connectedAddress != null && this.keepAliveMillis > 0 && paramLong - this.lastCommunicationTime > this.keepAliveMillis);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\UdpConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */