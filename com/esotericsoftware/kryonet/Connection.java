/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import com.esotericsoftware.kryonet.serialization.Serialization;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketException;
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
/*     */ public class Connection
/*     */ {
/*  52 */   int id = -1;
/*     */   private String name;
/*     */   EndPoint endPoint;
/*     */   TcpConnection tcp;
/*     */   UdpConnection udp;
/*     */   InetSocketAddress udpRemoteAddress;
/*  58 */   private Listener[] listeners = new Listener[0];
/*  59 */   private final Object listenerLock = new Object();
/*     */   
/*     */   private int lastPingID;
/*     */   
/*     */   private long lastPingSendTime;
/*     */   
/*     */   private int returnTripTime;
/*     */   
/*     */   volatile boolean isConnected;
/*     */   volatile KryoNetException lastProtocolError;
/*     */   private Object arbitraryData;
/*     */   
/*     */   void initialize(Serialization paramSerialization, int paramInt1, int paramInt2) {
/*  72 */     this.tcp = new TcpConnection(paramSerialization, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getID() {
/*  82 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnected() {
/*  90 */     return this.isConnected;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KryoNetException getLastProtocolError() {
/*  99 */     return this.lastProtocolError;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sendTCP(Object paramObject) {
/* 109 */     if (paramObject == null)
/* 110 */       throw new NullPointerException("object to send cannot be null."); 
/*     */     try {
/*     */       int i;
/* 113 */       if ((i = this.tcp.send(this, paramObject)) == 0) {
/* 114 */         if (Log.TRACE)
/* 115 */           Log.trace("kryonet", this + " TCP had nothing to send."); 
/* 116 */       } else if (Log.DEBUG) {
/*     */         
/* 118 */         String str = (paramObject == null) ? "null" : paramObject.getClass().getSimpleName();
/* 119 */         if (!(paramObject instanceof FrameworkMessage)) {
/* 120 */           Log.debug("kryonet", this + " sent TCP: " + str + " (" + i + ")");
/*     */         }
/* 122 */         else if (Log.TRACE) {
/* 123 */           Log.trace("kryonet", this + " sent TCP: " + str + " (" + i + ")");
/*     */         } 
/*     */       } 
/*     */       
/* 127 */       return i;
/* 128 */     } catch (IOException iOException) {
/* 129 */       if (Log.DEBUG) {
/* 130 */         Log.debug("kryonet", "Unable to send TCP with connection: " + this, iOException);
/*     */       }
/* 132 */       close();
/* 133 */       return 0;
/* 134 */     } catch (KryoNetException kryoNetException) {
/* 135 */       if (Log.ERROR) {
/* 136 */         Log.error("kryonet", "Unable to send TCP with connection: " + this, kryoNetException);
/*     */       }
/* 138 */       close();
/* 139 */       return 0;
/*     */     } 
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
/*     */   public int sendUDP(Object paramObject) {
/* 152 */     if (paramObject == null)
/* 153 */       throw new NullPointerException("object to send cannot be null."); 
/*     */     InetSocketAddress inetSocketAddress;
/* 155 */     if ((inetSocketAddress = this.udpRemoteAddress) == null && this.udp != null)
/* 156 */       inetSocketAddress = this.udp.connectedAddress; 
/* 157 */     if (inetSocketAddress == null && this.isConnected) {
/* 158 */       throw new IllegalStateException("This connection is not connected via UDP.");
/*     */     }
/*     */     
/*     */     try {
/* 162 */       if (inetSocketAddress == null) {
/* 163 */         throw new SocketException("Connection is closed.");
/*     */       }
/*     */       int i;
/* 166 */       if ((i = this.udp.send(this, paramObject, inetSocketAddress)) == 0) {
/* 167 */         if (Log.TRACE)
/* 168 */           Log.trace("kryonet", this + " UDP had nothing to send."); 
/* 169 */       } else if (Log.DEBUG) {
/* 170 */         if (i != -1) {
/*     */           
/* 172 */           String str = (paramObject == null) ? "null" : paramObject.getClass().getSimpleName();
/* 173 */           if (!(paramObject instanceof FrameworkMessage)) {
/* 174 */             Log.debug("kryonet", this + " sent UDP: " + str + " (" + i + ")");
/*     */           }
/* 176 */           else if (Log.TRACE) {
/* 177 */             Log.trace("kryonet", this + " sent UDP: " + str + " (" + i + ")");
/*     */           } 
/*     */         } else {
/*     */           
/* 181 */           Log.debug("kryonet", this + " was unable to send, UDP socket buffer full.");
/*     */         } 
/*     */       } 
/* 184 */       return i;
/* 185 */     } catch (IOException iOException) {
/* 186 */       if (Log.DEBUG) {
/* 187 */         Log.debug("kryonet", "Unable to send UDP with connection: " + this, iOException);
/*     */       }
/* 189 */       close();
/* 190 */       return 0;
/* 191 */     } catch (KryoNetException kryoNetException) {
/* 192 */       if (Log.ERROR) {
/* 193 */         Log.error("kryonet", "Unable to send UDP with connection: " + this, kryoNetException);
/*     */       }
/* 195 */       close();
/* 196 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() {
/* 201 */     boolean bool = this.isConnected;
/* 202 */     this.isConnected = false;
/* 203 */     this.tcp.close();
/* 204 */     if (this.udp != null && this.udp.connectedAddress != null)
/* 205 */       this.udp.close(); 
/* 206 */     if (bool) {
/* 207 */       notifyDisconnected();
/* 208 */       if (Log.INFO)
/* 209 */         Log.info("kryonet", this + " disconnected."); 
/*     */     } 
/* 211 */     setConnected(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateReturnTripTime() {
/*     */     FrameworkMessage.Ping ping;
/* 223 */     (ping = new FrameworkMessage.Ping()).id = this.lastPingID++;
/* 224 */     this.lastPingSendTime = System.currentTimeMillis();
/* 225 */     sendTCP(ping);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReturnTripTime() {
/* 234 */     return this.returnTripTime;
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
/*     */   public void setKeepAliveTCP(int paramInt) {
/* 247 */     this.tcp.keepAliveMillis = paramInt;
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
/*     */ 
/*     */   
/*     */   public void setTimeout(int paramInt) {
/* 263 */     this.tcp.timeoutMillis = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(Listener paramListener) {
/* 274 */     if (paramListener == null)
/* 275 */       throw new NullPointerException("listener cannot be null."); 
/* 276 */     synchronized (this.listenerLock) {
/*     */       Listener[] arrayOfListener1;
/* 278 */       int i = (arrayOfListener1 = this.listeners).length;
/* 279 */       for (byte b = 0; b < i; b++) {
/* 280 */         if (paramListener == arrayOfListener1[b])
/*     */           return; 
/*     */       }  Listener[] arrayOfListener2;
/* 283 */       (arrayOfListener2 = new Listener[i + 1])[0] = paramListener;
/* 284 */       System.arraycopy(arrayOfListener1, 0, arrayOfListener2, 1, i);
/* 285 */       this.listeners = arrayOfListener2;
/*     */     } 
/* 287 */     if (Log.TRACE)
/* 288 */       Log.trace("kryonet", "Connection listener added: " + paramListener
/* 289 */           .getClass().getName()); 
/*     */   }
/*     */   
/*     */   public void removeListener(Listener paramListener) {
/* 293 */     if (paramListener == null)
/* 294 */       throw new NullPointerException("listener cannot be null."); 
/* 295 */     synchronized (this.listenerLock) {
/*     */       Listener[] arrayOfListener1;
/*     */       int i;
/* 298 */       if ((i = (arrayOfListener1 = this.listeners).length) == 0)
/*     */         return; 
/* 300 */       Listener[] arrayOfListener2 = new Listener[i - 1];
/* 301 */       for (byte b1 = 0, b2 = 0; b1 < i; b1++) {
/* 302 */         Listener listener = arrayOfListener1[b1];
/* 303 */         if (paramListener != listener) {
/*     */           
/* 305 */           if (b2 == i - 1)
/*     */             return; 
/* 307 */           arrayOfListener2[b2++] = listener;
/*     */         } 
/* 309 */       }  this.listeners = arrayOfListener2;
/*     */     } 
/* 311 */     if (Log.TRACE)
/* 312 */       Log.trace("kryonet", "Connection listener removed: " + paramListener
/* 313 */           .getClass().getName());  } void notifyConnected() {
/*     */     SocketChannel socketChannel;
/*     */     Socket socket;
/*     */     InetSocketAddress inetSocketAddress;
/* 317 */     if (Log.INFO && (
/*     */       
/* 319 */       socketChannel = this.tcp.socketChannel) != null && (
/*     */       
/* 321 */       socket = this.tcp.socketChannel.socket()) != null && (
/*     */ 
/*     */       
/* 324 */       inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress()) != null) {
/* 325 */       Log.info("kryonet", this + " connected: " + inetSocketAddress
/* 326 */           .getAddress());
/*     */     }
/*     */ 
/*     */     
/* 330 */     Listener[] arrayOfListener = this.listeners; byte b; int i;
/* 331 */     for (b = 0, i = arrayOfListener.length; b < i; b++)
/* 332 */       arrayOfListener[b].connected(this); 
/*     */   }
/*     */   
/*     */   void notifyDisconnected() {
/* 336 */     Listener[] arrayOfListener = this.listeners; byte b; int i;
/* 337 */     for (b = 0, i = arrayOfListener.length; b < i; b++)
/* 338 */       arrayOfListener[b].disconnected(this); 
/*     */   }
/*     */   
/*     */   void notifyIdle() {
/* 342 */     Listener[] arrayOfListener = this.listeners; byte b; int i;
/* 343 */     for (b = 0, i = arrayOfListener.length; b < i; ) {
/* 344 */       arrayOfListener[b].idle(this);
/* 345 */       if (isIdle())
/*     */         b++; 
/*     */     } 
/*     */   }
/*     */   
/*     */   void notifyReceived(Object paramObject) {
/* 351 */     if (paramObject instanceof FrameworkMessage.Ping) {
/*     */       FrameworkMessage.Ping ping;
/* 353 */       if ((ping = (FrameworkMessage.Ping)paramObject).isReply) {
/* 354 */         if (ping.id == this.lastPingID - 1) {
/* 355 */           this.returnTripTime = (int)(System.currentTimeMillis() - this.lastPingSendTime);
/*     */           
/* 357 */           if (Log.TRACE) {
/* 358 */             Log.trace("kryonet", this + " return trip time: " + this.returnTripTime);
/*     */           }
/*     */         } 
/*     */       } else {
/* 362 */         ping.isReply = true;
/* 363 */         sendTCP(ping);
/*     */       } 
/*     */     } 
/* 366 */     Listener[] arrayOfListener = this.listeners; byte b; int i;
/* 367 */     for (b = 0, i = arrayOfListener.length; b < i; b++) {
/* 368 */       arrayOfListener[b].received(this, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EndPoint getEndPoint() {
/* 376 */     return this.endPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InetSocketAddress getRemoteAddressTCP() {
/*     */     Socket socket;
/*     */     SocketChannel socketChannel;
/* 385 */     if ((socketChannel = this.tcp.socketChannel) != null && (
/*     */       
/* 387 */       socket = this.tcp.socketChannel.socket()) != null) {
/* 388 */       return (InetSocketAddress)socket.getRemoteSocketAddress();
/*     */     }
/*     */     
/* 391 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InetSocketAddress getRemoteAddressUDP() {
/*     */     InetSocketAddress inetSocketAddress;
/* 400 */     if ((inetSocketAddress = this.udp.connectedAddress) != null)
/* 401 */       return inetSocketAddress; 
/* 402 */     return this.udpRemoteAddress;
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
/*     */   public void setBufferPositionFix(boolean paramBoolean) {
/* 414 */     this.tcp.bufferPositionFix = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 425 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTcpWriteBufferSize() {
/* 433 */     return this.tcp.writeBuffer.position();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIdle() {
/* 440 */     if (this.tcp.writeBuffer.position() / this.tcp.writeBuffer
/* 441 */       .capacity() < this.tcp.idleThreshold) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdleThreshold(float paramFloat) {
/* 450 */     this.tcp.idleThreshold = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 460 */     if (this.name != null)
/* 461 */       return this.name; 
/* 462 */     return "Connection " + this.id;
/*     */   }
/*     */   
/*     */   void setConnected(boolean paramBoolean) {
/* 466 */     this.isConnected = paramBoolean;
/* 467 */     if (paramBoolean && this.name == null)
/* 468 */       this.name = "Connection " + this.id; 
/*     */   }
/*     */   
/*     */   public Object getArbitraryData() {
/* 472 */     return this.arbitraryData;
/*     */   }
/*     */   
/*     */   public void setArbitraryData(Object paramObject) {
/* 476 */     this.arbitraryData = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 481 */     return 31 + this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 486 */     if (this == paramObject)
/* 487 */       return true; 
/* 488 */     if (paramObject == null)
/* 489 */       return false; 
/* 490 */     if (getClass() != paramObject.getClass())
/* 491 */       return false; 
/* 492 */     paramObject = paramObject;
/* 493 */     return (this.id == ((Connection)paramObject).id);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\Connection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */