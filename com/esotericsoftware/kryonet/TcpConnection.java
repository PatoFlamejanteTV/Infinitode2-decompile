/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import com.esotericsoftware.kryonet.serialization.Serialization;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.SocketException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.SelectionKey;
/*     */ import java.nio.channels.Selector;
/*     */ import java.nio.channels.SocketChannel;
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
/*     */ class TcpConnection
/*     */ {
/*     */   SocketChannel socketChannel;
/*  44 */   int keepAliveMillis = 8000;
/*     */   
/*     */   final ByteBuffer readBuffer;
/*  47 */   int timeoutMillis = 12000; final ByteBuffer writeBuffer; boolean bufferPositionFix;
/*  48 */   float idleThreshold = 0.1F;
/*     */   final Serialization serialization;
/*     */   private SelectionKey selectionKey;
/*     */   private volatile long lastWriteTime;
/*     */   private volatile long lastReadTime;
/*     */   private int currentObjectLength;
/*  54 */   private final Object writeLock = new Object();
/*     */ 
/*     */   
/*     */   public TcpConnection(Serialization paramSerialization, int paramInt1, int paramInt2) {
/*  58 */     this.serialization = paramSerialization;
/*  59 */     this.writeBuffer = ByteBuffer.allocate(paramInt1);
/*  60 */     this.readBuffer = ByteBuffer.allocate(paramInt2);
/*  61 */     this.readBuffer.flip();
/*     */   }
/*     */ 
/*     */   
/*     */   public SelectionKey accept(Selector paramSelector, SocketChannel paramSocketChannel) {
/*  66 */     this.writeBuffer.clear();
/*  67 */     this.readBuffer.clear();
/*  68 */     this.readBuffer.flip();
/*  69 */     this.currentObjectLength = 0;
/*     */     try {
/*  71 */       this.socketChannel = paramSocketChannel;
/*  72 */       paramSocketChannel.configureBlocking(false);
/*     */       Socket socket;
/*  74 */       (socket = paramSocketChannel.socket()).setTcpNoDelay(true);
/*     */       
/*  76 */       this.selectionKey = paramSocketChannel.register(paramSelector, 1);
/*     */ 
/*     */       
/*  79 */       if (Log.DEBUG) {
/*  80 */         Log.debug("kryonet", "Port " + paramSocketChannel.socket().getLocalPort() + "/TCP connected to: " + paramSocketChannel
/*     */             
/*  82 */             .socket().getRemoteSocketAddress());
/*     */       }
/*     */       
/*  85 */       this.lastReadTime = this.lastWriteTime = System.currentTimeMillis();
/*     */       
/*  87 */       return this.selectionKey;
/*  88 */     } catch (IOException iOException) {
/*  89 */       close();
/*  90 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void connect(Selector paramSelector, SocketAddress paramSocketAddress, int paramInt) {
/*  96 */     close();
/*  97 */     this.writeBuffer.clear();
/*  98 */     this.readBuffer.clear();
/*  99 */     this.readBuffer.flip();
/* 100 */     this.currentObjectLength = 0;
/*     */     
/*     */     try {
/*     */       SocketChannel socketChannel;
/*     */       Socket socket;
/* 105 */       (socket = (socketChannel = paramSelector.provider().openSocketChannel()).socket()).setTcpNoDelay(true);
/*     */       
/* 107 */       socket.connect(paramSocketAddress, paramInt);
/*     */       
/* 109 */       socketChannel.configureBlocking(false);
/* 110 */       this.socketChannel = socketChannel;
/*     */       
/* 112 */       this.selectionKey = socketChannel.register(paramSelector, 1);
/*     */       
/* 114 */       this.selectionKey.attach(this);
/*     */       
/* 116 */       if (Log.DEBUG) {
/* 117 */         Log.debug("kryonet", "Port " + socketChannel.socket().getLocalPort() + "/TCP connected to: " + socketChannel
/*     */             
/* 119 */             .socket().getRemoteSocketAddress());
/*     */       }
/*     */       
/* 122 */       this.lastReadTime = this.lastWriteTime = System.currentTimeMillis(); return;
/* 123 */     } catch (IOException iOException) {
/* 124 */       close();
/* 125 */       throw new IOException("Unable to connect to: " + paramSocketAddress, iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object readObject(Connection paramConnection) {
/*     */     SocketChannel socketChannel;
/* 131 */     if ((socketChannel = this.socketChannel) == null) {
/* 132 */       throw new SocketException("Connection is closed.");
/*     */     }
/* 134 */     if (this.currentObjectLength == 0) {
/*     */       
/* 136 */       int m = this.serialization.getLengthLength();
/* 137 */       if (this.readBuffer.remaining() < m) {
/* 138 */         this.readBuffer.compact();
/* 139 */         int n = socketChannel.read(this.readBuffer);
/* 140 */         this.readBuffer.flip();
/* 141 */         if (n == -1)
/* 142 */           throw new SocketException("Connection is closed."); 
/* 143 */         this.lastReadTime = System.currentTimeMillis();
/*     */         
/* 145 */         if (this.readBuffer.remaining() < m)
/* 146 */           return null; 
/*     */       } 
/* 148 */       this.currentObjectLength = this.serialization.readLength(this.readBuffer);
/*     */       
/* 150 */       if (this.currentObjectLength <= 0) {
/* 151 */         throw new KryoNetException("Invalid object length: " + this.currentObjectLength);
/*     */       }
/* 153 */       if (this.currentObjectLength > this.readBuffer.capacity()) {
/* 154 */         throw new KryoNetException("Unable to read object larger than read buffer: " + this.currentObjectLength);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 159 */     int j = this.currentObjectLength;
/* 160 */     if (this.readBuffer.remaining() < j) {
/*     */       
/* 162 */       this.readBuffer.compact();
/* 163 */       int m = socketChannel.read(this.readBuffer);
/* 164 */       this.readBuffer.flip();
/* 165 */       if (m == -1)
/* 166 */         throw new SocketException("Connection is closed."); 
/* 167 */       this.lastReadTime = System.currentTimeMillis();
/*     */       
/* 169 */       if (this.readBuffer.remaining() < j)
/* 170 */         return null; 
/*     */     } 
/* 172 */     this.currentObjectLength = 0;
/*     */     
/* 174 */     int k = this.readBuffer.position();
/* 175 */     int i = this.readBuffer.limit();
/* 176 */     this.readBuffer.limit(k + j);
/*     */     
/*     */     try {
/* 179 */       object = this.serialization.read(paramConnection, this.readBuffer);
/* 180 */     } catch (Exception object) {
/* 181 */       throw new KryoNetException("Error during deserialization.", object);
/*     */     } 
/*     */     
/* 184 */     this.readBuffer.limit(i);
/* 185 */     if (this.readBuffer.position() - k != j) {
/* 186 */       throw new KryoNetException("Incorrect number of bytes (" + (k + j - this.readBuffer
/* 187 */           .position()) + " remaining) used to deserialize object: " + object);
/*     */     }
/*     */     
/* 190 */     return object;
/*     */   }
/*     */   
/*     */   public void writeOperation() {
/* 194 */     synchronized (this.writeLock) {
/* 195 */       if (writeToSocket())
/*     */       {
/* 197 */         this.selectionKey.interestOps(1);
/*     */       }
/* 199 */       this.lastWriteTime = System.currentTimeMillis();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private boolean writeToSocket() {
/*     */     SocketChannel socketChannel;
/* 205 */     if ((socketChannel = this.socketChannel) == null) {
/* 206 */       throw new SocketException("Connection is closed.");
/*     */     }
/*     */     ByteBuffer byteBuffer;
/* 209 */     (byteBuffer = this.writeBuffer).flip();
/* 210 */     while (byteBuffer.hasRemaining()) {
/* 211 */       if (this.bufferPositionFix) {
/* 212 */         byteBuffer.compact();
/* 213 */         byteBuffer.flip();
/*     */       } 
/* 215 */       if (socketChannel.write(byteBuffer) == 0)
/*     */         break; 
/*     */     } 
/* 218 */     byteBuffer.compact();
/*     */     
/* 220 */     return (byteBuffer.position() == 0);
/*     */   }
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
/*     */   public int send(Connection paramConnection, Object paramObject) {
/*     */     SocketChannel socketChannel;
/* 235 */     if ((socketChannel = this.socketChannel) == null)
/* 236 */       throw new SocketException("Connection is closed."); 
/* 237 */     synchronized (this.writeLock) {
/*     */       
/* 239 */       int j = this.writeBuffer.position();
/* 240 */       int k = this.serialization.getLengthLength();
/*     */ 
/*     */       
/*     */       try {
/* 244 */         this.writeBuffer.position(this.writeBuffer.position() + k);
/*     */ 
/*     */         
/* 247 */         this.serialization.write(paramConnection, this.writeBuffer, paramObject);
/* 248 */       } catch (Throwable throwable) {
/* 249 */         throw new KryoNetException("Error serializing object of type: " + paramObject
/* 250 */             .getClass().getName(), throwable);
/*     */       } 
/* 252 */       int i = this.writeBuffer.position();
/*     */ 
/*     */       
/* 255 */       this.writeBuffer.position(j);
/* 256 */       this.serialization.writeLength(this.writeBuffer, i - k - j);
/* 257 */       this.writeBuffer.position(i);
/*     */ 
/*     */       
/* 260 */       if (j == 0 && !writeToSocket()) {
/*     */ 
/*     */         
/* 263 */         this.selectionKey.interestOps(5);
/*     */       }
/*     */       else {
/*     */         
/* 267 */         this.selectionKey.selector().wakeup();
/*     */       } 
/*     */       
/* 270 */       if (Log.DEBUG || Log.TRACE) {
/*     */         
/* 272 */         float f = this.writeBuffer.position() / this.writeBuffer.capacity();
/* 273 */         if (Log.DEBUG && f > 0.75F) {
/* 274 */           Log.debug("kryonet", " TCP write buffer is approaching capacity: " + f + "%");
/*     */         
/*     */         }
/* 277 */         else if (Log.TRACE && f > 0.25F) {
/* 278 */           Log.trace("kryonet", " TCP write buffer utilization: " + f + "%");
/*     */         } 
/*     */       } 
/*     */       
/* 282 */       this.lastWriteTime = System.currentTimeMillis();
/* 283 */       return i - j;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() {
/*     */     try {
/* 289 */       if (this.socketChannel != null) {
/* 290 */         this.socketChannel.close();
/* 291 */         this.socketChannel = null;
/* 292 */         if (this.selectionKey != null)
/* 293 */           this.selectionKey.selector().wakeup(); 
/*     */       }  return;
/* 295 */     } catch (IOException iOException) {
/* 296 */       if (Log.DEBUG)
/* 297 */         Log.debug("kryonet", "Unable to close TCP connection.", iOException); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public boolean needsKeepAlive(long paramLong) {
/* 302 */     return (this.socketChannel != null && this.keepAliveMillis > 0 && paramLong - this.lastWriteTime > this.keepAliveMillis);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTimedOut(long paramLong) {
/* 307 */     return (this.socketChannel != null && this.timeoutMillis > 0 && paramLong - this.lastReadTime > this.timeoutMillis);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\TcpConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */