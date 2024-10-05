/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.util.IntMap;
/*     */ import com.esotericsoftware.kryonet.serialization.KryoSerialization;
/*     */ import com.esotericsoftware.kryonet.serialization.Serialization;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.nio.channels.CancelledKeyException;
/*     */ import java.nio.channels.SelectionKey;
/*     */ import java.nio.channels.Selector;
/*     */ import java.nio.channels.ServerSocketChannel;
/*     */ import java.nio.channels.SocketChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
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
/*     */ public class Server
/*     */   implements EndPoint
/*     */ {
/*     */   public static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
/*     */   public static final int DEFAULT_OBJECT_BUFFER_SIZE = 2048;
/*     */   private final Serialization serialization;
/*     */   private final int writeBufferSize;
/*     */   private final int objectBufferSize;
/*     */   private final Selector selector;
/*     */   private int emptySelects;
/*     */   private ServerSocketChannel serverChannel;
/*     */   private UdpConnection udp;
/*  71 */   private Connection[] connections = new Connection[0];
/*  72 */   private final IntMap<Connection> pendingConnections = new IntMap();
/*  73 */   Listener[] listeners = new Listener[0];
/*  74 */   private final Object listenerLock = new Object();
/*  75 */   private int nextConnectionID = 1;
/*     */   private volatile boolean shutdown;
/*  77 */   private final Object updateLock = new Object();
/*     */   private Thread updateThread;
/*     */   private ServerDiscoveryHandler discoveryHandler;
/*     */   
/*  81 */   private final Listener dispatchListener = new Listener()
/*     */     {
/*     */       public void connected(Connection param1Connection) {
/*  84 */         Listener[] arrayOfListener = Server.this.listeners; byte b; int i;
/*  85 */         for (b = 0, i = arrayOfListener.length; b < i; b++) {
/*  86 */           arrayOfListener[b].connected(param1Connection);
/*     */         }
/*     */       }
/*     */       
/*     */       public void disconnected(Connection param1Connection) {
/*  91 */         Server.this.removeConnection(param1Connection);
/*  92 */         Listener[] arrayOfListener = Server.this.listeners; byte b; int i;
/*  93 */         for (b = 0, i = arrayOfListener.length; b < i; b++) {
/*  94 */           arrayOfListener[b].disconnected(param1Connection);
/*     */         }
/*     */       }
/*     */       
/*     */       public void received(Connection param1Connection, Object param1Object) {
/*  99 */         Listener[] arrayOfListener = Server.this.listeners; byte b; int i;
/* 100 */         for (b = 0, i = arrayOfListener.length; b < i; b++) {
/* 101 */           arrayOfListener[b].received(param1Connection, param1Object);
/*     */         }
/*     */       }
/*     */       
/*     */       public void idle(Connection param1Connection) {
/* 106 */         Listener[] arrayOfListener = Server.this.listeners; byte b; int i;
/* 107 */         for (b = 0, i = arrayOfListener.length; b < i; b++) {
/* 108 */           arrayOfListener[b].idle(param1Connection);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Server() {
/* 117 */     this(16384, 2048);
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
/*     */   public Server(int paramInt1, int paramInt2) {
/* 147 */     this(paramInt1, paramInt2, (Serialization)new KryoSerialization());
/*     */   }
/*     */ 
/*     */   
/*     */   public Server(int paramInt1, int paramInt2, Serialization paramSerialization) {
/* 152 */     this.writeBufferSize = paramInt1;
/* 153 */     this.objectBufferSize = paramInt2;
/* 154 */     this.serialization = paramSerialization;
/*     */     
/* 156 */     this.discoveryHandler = new ServerDiscoveryHandler() {
/*     */       
/*     */       };
/*     */     try {
/* 160 */       this.selector = Selector.open(); return;
/* 161 */     } catch (IOException iOException) {
/* 162 */       throw new RuntimeException("Error opening the selector.", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDiscoveryHandler(ServerDiscoveryHandler paramServerDiscoveryHandler) {
/* 168 */     this.discoveryHandler = paramServerDiscoveryHandler;
/*     */   }
/*     */   
/*     */   public Serialization getSerialization() {
/* 172 */     return this.serialization;
/*     */   }
/*     */ 
/*     */   
/*     */   public Kryo getKryo() {
/* 177 */     if (this.serialization instanceof KryoSerialization)
/* 178 */       return ((KryoSerialization)this.serialization).getKryo();  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(int paramInt) {
/* 189 */     bind(new InetSocketAddress(paramInt), (InetSocketAddress)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(int paramInt1, int paramInt2) {
/* 200 */     bind(new InetSocketAddress(paramInt1), new InetSocketAddress(paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2) {
/* 209 */     close();
/* 210 */     synchronized (this.updateLock) {
/* 211 */       this.selector.wakeup();
/*     */       try {
/* 213 */         this.serverChannel = this.selector.provider().openServerSocketChannel();
/* 214 */         this.serverChannel.socket().bind(paramInetSocketAddress1);
/* 215 */         this.serverChannel.configureBlocking(false);
/* 216 */         this.serverChannel.register(this.selector, 16);
/* 217 */         if (Log.DEBUG) {
/* 218 */           Log.debug("kryonet", "Accepting connections on port: " + paramInetSocketAddress1 + "/TCP");
/*     */         }
/*     */         
/* 221 */         if (paramInetSocketAddress2 != null) {
/* 222 */           this.udp = new UdpConnection(this.serialization, this.objectBufferSize);
/* 223 */           this.udp.bind(this.selector, paramInetSocketAddress2);
/* 224 */           if (Log.DEBUG) {
/* 225 */             Log.debug("kryonet", "Accepting connections on port: " + paramInetSocketAddress2 + "/UDP");
/*     */           }
/*     */         } 
/* 228 */       } catch (IOException iOException) {
/* 229 */         close();
/* 230 */         throw iOException;
/*     */       } 
/*     */     } 
/* 233 */     if (Log.INFO) {
/* 234 */       Log.info("kryonet", "Server opened.");
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
/*     */   public void update(int paramInt) {
/*     */     Object object;
/* 248 */     this.updateThread = Thread.currentThread();
/*     */     
/*     */     /* monitor enter BinaryOperatorExpression{ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} = FieldReferenceExpression{lastType=ObjectType{java/lang/Object}, expression=ThisExpression{ObjectType{com/esotericsoftware/kryonet/Server}}, name=updateLock, descriptor=Ljava/lang/Object;}} */
/*     */     
/*     */     /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/* 253 */     long l1 = System.currentTimeMillis();
/*     */     
/* 255 */     if (paramInt > 0) {
/* 256 */       paramInt = this.selector.select(paramInt);
/*     */     } else {
/* 258 */       paramInt = this.selector.selectNow();
/*     */     } 
/* 260 */     if (paramInt == 0) {
/* 261 */       this.emptySelects++;
/* 262 */       if (this.emptySelects == 100) {
/* 263 */         this.emptySelects = 0;
/*     */ 
/*     */         
/* 266 */         long l = System.currentTimeMillis() - l1;
/*     */         try {
/* 268 */           if (l < 25L)
/* 269 */             Thread.sleep(25L - l); 
/* 270 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */     } else {
/*     */       
/* 274 */       this.emptySelects = 0;
/*     */       Set<SelectionKey> set;
/* 276 */       synchronized (set = this.selector.selectedKeys()) {
/* 277 */         UdpConnection udpConnection = this.udp;
/* 278 */         Iterator<SelectionKey> iterator = set.iterator();
/* 279 */         while (iterator.hasNext()) {
/* 280 */           keepAlive();
/* 281 */           SelectionKey selectionKey = iterator.next();
/* 282 */           iterator.remove();
/*     */           
/* 284 */           Connection connection = (Connection)selectionKey.attachment(); try {
/*     */             Object object1, object2;
/* 286 */             int j = selectionKey.readyOps();
/*     */             
/* 288 */             if (connection != null) {
/*     */               
/* 290 */               if (udpConnection != null && connection.udpRemoteAddress == null) {
/*     */                 
/* 292 */                 connection.close();
/*     */                 continue;
/*     */               } 
/* 295 */               if ((j & 0x1) == 1) {
/*     */                 
/*     */                 try {
/*     */ 
/*     */                   
/* 300 */                   while ((object2 = connection.tcp.readObject(connection)) != null) {
/*     */                     
/* 302 */                     if (Log.DEBUG) {
/*     */ 
/*     */ 
/*     */                       
/* 306 */                       String str = (object2 == null) ? "null" : object2.getClass().getSimpleName();
/* 307 */                       if (!(object2 instanceof FrameworkMessage)) {
/* 308 */                         Log.debug("kryonet", connection + " received TCP: " + str);
/*     */                       
/*     */                       }
/* 311 */                       else if (Log.TRACE) {
/* 312 */                         Log.trace("kryonet", connection + " received TCP: " + str);
/*     */                       } 
/*     */                     } 
/*     */ 
/*     */                     
/* 317 */                     connection.notifyReceived(object2);
/*     */                   } 
/* 319 */                 } catch (IOException null) {
/* 320 */                   if (Log.TRACE) {
/* 321 */                     Log.trace("kryonet", "Unable to read TCP from: " + connection, (Throwable)object2);
/*     */ 
/*     */                   
/*     */                   }
/* 325 */                   else if (Log.DEBUG) {
/* 326 */                     Log.debug("kryonet", connection + " update: " + object2
/*     */                         
/* 328 */                         .getMessage());
/*     */                   } 
/* 330 */                   connection.close();
/* 331 */                 } catch (KryoNetException null) {
/* 332 */                   if (Log.ERROR) {
/* 333 */                     Log.error("kryonet", "Error reading TCP from connection: " + connection, (Throwable)object2);
/*     */                   }
/*     */ 
/*     */                   
/* 337 */                   connection.close();
/*     */                 } 
/*     */               }
/* 340 */               if ((j & 0x4) == 4) {
/*     */                 try {
/* 342 */                   connection.tcp.writeOperation();
/* 343 */                 } catch (IOException null) {
/* 344 */                   if (Log.TRACE) {
/* 345 */                     Log.trace("kryonet", "Unable to write TCP to connection: " + connection, (Throwable)object2);
/*     */ 
/*     */                   
/*     */                   }
/* 349 */                   else if (Log.DEBUG) {
/* 350 */                     Log.debug("kryonet", connection + " update: " + object2
/*     */                         
/* 352 */                         .getMessage());
/*     */                   } 
/* 354 */                   connection.close();
/*     */                 } 
/*     */               }
/*     */               
/*     */               continue;
/*     */             } 
/* 360 */             if ((j & 0x10) == 16) {
/*     */               
/* 362 */               if ((object2 = this.serverChannel) == null) {
/*     */                 continue;
/*     */               }
/*     */               try {
/*     */                 SocketChannel socketChannel;
/* 367 */                 if ((socketChannel = object2.accept()) != null)
/* 368 */                   acceptOperation(socketChannel); 
/* 369 */               } catch (IOException iOException) {
/* 370 */                 if (Log.DEBUG) {
/* 371 */                   Log.debug("kryonet", "Unable to accept new connection.", iOException);
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/*     */               continue;
/*     */             } 
/*     */             
/* 379 */             if (udpConnection == null) {
/* 380 */               selectionKey.channel().close();
/*     */               
/*     */               continue;
/*     */             } 
/*     */             try {
/* 385 */               object2 = udpConnection.readFromAddress();
/* 386 */             } catch (IOException iOException) {
/* 387 */               if (Log.WARN)
/* 388 */                 Log.warn("kryonet", "Error reading UDP data.", iOException); 
/*     */               continue;
/*     */             } 
/* 391 */             if (object2 == null) {
/*     */               continue;
/*     */             }
/* 394 */             Connection[] arrayOfConnection1 = this.connections; int k;
/* 395 */             for (j = 0, k = arrayOfConnection1.length; j < k; j++) {
/* 396 */               Connection connection1 = arrayOfConnection1[j];
/* 397 */               if (object2
/* 398 */                 .equals(connection1.udpRemoteAddress)) {
/* 399 */                 connection = connection1;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */             
/*     */             try {
/* 406 */               object1 = udpConnection.readObject(connection);
/* 407 */             } catch (KryoNetException kryoNetException) {
/* 408 */               if (Log.WARN) {
/* 409 */                 if (connection != null) {
/* 410 */                   if (Log.ERROR) {
/* 411 */                     Log.error("kryonet", "Error reading UDP from connection: " + connection, kryoNetException);
/*     */                   }
/*     */                   
/*     */                   continue;
/*     */                 } 
/* 416 */                 Log.warn("kryonet", "Error reading UDP from unregistered address: " + object2, kryoNetException);
/*     */               } 
/*     */ 
/*     */               
/*     */               continue;
/*     */             } 
/*     */ 
/*     */             
/* 424 */             if (object1 instanceof FrameworkMessage) {
/* 425 */               if (object1 instanceof FrameworkMessage.RegisterUDP) {
/*     */ 
/*     */ 
/*     */                 
/* 429 */                 k = ((FrameworkMessage.RegisterUDP)object1).connectionID;
/*     */                 
/*     */                 Connection connection1;
/* 432 */                 if ((connection1 = (Connection)this.pendingConnections.remove(k)) != null) {
/* 433 */                   if (connection1.udpRemoteAddress != null)
/*     */                     continue; 
/* 435 */                   connection1.udpRemoteAddress = (InetSocketAddress)object2;
/* 436 */                   addConnection(connection1);
/* 437 */                   connection1.sendTCP(new FrameworkMessage.RegisterUDP());
/* 438 */                   if (Log.DEBUG) {
/* 439 */                     Log.debug("kryonet", "Port " + udpConnection.datagramChannel
/*     */                         
/* 441 */                         .socket().getLocalPort() + "/UDP connected to: " + object2);
/*     */                   }
/*     */                   
/* 444 */                   connection1.notifyConnected();
/*     */                   continue;
/*     */                 } 
/* 447 */                 if (Log.DEBUG) {
/* 448 */                   Log.debug("kryonet", "Ignoring incoming RegisterUDP with invalid connection ID: " + k);
/*     */                 }
/*     */                 
/*     */                 continue;
/*     */               } 
/* 453 */               if (object1 instanceof FrameworkMessage.DiscoverHost) {
/*     */                 
/*     */                 try {
/* 456 */                   boolean bool = this.discoveryHandler.onDiscoverHost(udpConnection.datagramChannel, (InetSocketAddress)object2);
/*     */                   
/* 458 */                   if (Log.DEBUG && bool) {
/* 459 */                     Log.debug("kryonet", "Responded to host discovery from: " + object2);
/*     */                   }
/*     */                 }
/* 462 */                 catch (IOException iOException) {
/* 463 */                   if (Log.WARN) {
/* 464 */                     Log.warn("kryonet", "Error replying to host discovery from: " + object2, iOException);
/*     */                   }
/*     */                 } 
/*     */ 
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */             } 
/*     */             
/* 473 */             if (connection != null) {
/* 474 */               if (Log.DEBUG) {
/*     */                 
/* 476 */                 String str = (object1 == null) ? "null" : object1.getClass().getSimpleName();
/* 477 */                 if (object1 instanceof FrameworkMessage) {
/* 478 */                   if (Log.TRACE) {
/* 479 */                     Log.trace("kryonet", connection + " received UDP: " + str);
/*     */                   }
/*     */                 }
/*     */                 else {
/*     */                   
/* 484 */                   Log.debug("kryonet", connection + " received UDP: " + str);
/*     */                 } 
/*     */               } 
/* 487 */               connection.notifyReceived(object1);
/*     */               continue;
/*     */             } 
/* 490 */             if (Log.DEBUG) {
/* 491 */               Log.debug("kryonet", "Ignoring UDP from unregistered address: " + object2);
/*     */             }
/*     */           }
/* 494 */           catch (CancelledKeyException cancelledKeyException) {
/* 495 */             if (connection != null) {
/* 496 */               connection.close(); continue;
/*     */             } 
/* 498 */             selectionKey.channel().close();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 503 */     long l2 = System.currentTimeMillis();
/* 504 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 505 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 507 */       if ((connection = arrayOfConnection[b]).tcp.isTimedOut(l2)) {
/* 508 */         if (Log.DEBUG)
/* 509 */           Log.debug("kryonet", connection + " timed out."); 
/* 510 */         connection.close();
/*     */       }
/* 512 */       else if (connection.tcp.needsKeepAlive(l2)) {
/* 513 */         connection.sendTCP(FrameworkMessage.keepAlive);
/*     */       } 
/* 515 */       if (connection.isIdle())
/* 516 */         connection.notifyIdle(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void keepAlive() {
/* 521 */     long l = System.currentTimeMillis();
/* 522 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 523 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 525 */       if ((connection = arrayOfConnection[b]).tcp.needsKeepAlive(l)) {
/* 526 */         connection.sendTCP(FrameworkMessage.keepAlive);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 532 */     if (Log.TRACE)
/* 533 */       Log.trace("kryonet", "Server thread started."); 
/* 534 */     this.shutdown = false;
/* 535 */     while (!this.shutdown) {
/*     */       try {
/* 537 */         update(250);
/* 538 */       } catch (IOException iOException) {
/* 539 */         if (Log.ERROR)
/* 540 */           Log.error("kryonet", "Error updating server connections.", iOException); 
/* 541 */         close();
/*     */       } 
/*     */     } 
/* 544 */     if (Log.TRACE) {
/* 545 */       Log.trace("kryonet", "Server thread stopped.");
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
/*     */   public void start() {
/* 558 */     (new Thread(this, "Server")).start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 563 */     if (this.shutdown)
/*     */       return; 
/* 565 */     this.shutdown = true;
/* 566 */     close();
/* 567 */     if (Log.TRACE)
/* 568 */       Log.trace("kryonet", "Server thread stopping."); 
/*     */   }
/*     */   
/*     */   private void acceptOperation(SocketChannel paramSocketChannel) {
/*     */     Connection connection;
/* 573 */     (connection = newConnection()).initialize(this.serialization, this.writeBufferSize, this.objectBufferSize);
/* 574 */     connection.endPoint = this;
/*     */     UdpConnection udpConnection;
/* 576 */     if ((udpConnection = this.udp) != null) {
/* 577 */       connection.udp = udpConnection;
/*     */     }
/*     */     try {
/*     */       SelectionKey selectionKey;
/* 581 */       (selectionKey = connection.tcp.accept(this.selector, paramSocketChannel)).attach(connection);
/*     */       
/* 583 */       int i = this.nextConnectionID++;
/* 584 */       if (this.nextConnectionID == -1)
/* 585 */         this.nextConnectionID = 1; 
/* 586 */       connection.id = i;
/* 587 */       connection.setConnected(true);
/* 588 */       connection.addListener(this.dispatchListener);
/*     */       
/* 590 */       if (udpConnection == null) {
/* 591 */         addConnection(connection);
/*     */       } else {
/* 593 */         this.pendingConnections.put(i, connection);
/*     */       } 
/*     */       FrameworkMessage.RegisterTCP registerTCP;
/* 596 */       (registerTCP = new FrameworkMessage.RegisterTCP()).connectionID = i;
/* 597 */       connection.sendTCP(registerTCP);
/*     */       
/* 599 */       if (udpConnection == null)
/* 600 */         connection.notifyConnected();  return;
/* 601 */     } catch (IOException iOException) {
/* 602 */       connection.close();
/* 603 */       if (Log.DEBUG) {
/* 604 */         Log.debug("kryonet", "Unable to accept TCP connection.", iOException);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Connection newConnection() {
/* 613 */     return new Connection();
/*     */   }
/*     */   
/*     */   private void addConnection(Connection paramConnection) {
/*     */     Connection[] arrayOfConnection;
/* 618 */     (arrayOfConnection = new Connection[this.connections.length + 1])[0] = paramConnection;
/* 619 */     System.arraycopy(this.connections, 0, arrayOfConnection, 1, this.connections.length);
/* 620 */     this.connections = arrayOfConnection;
/*     */   }
/*     */ 
/*     */   
/*     */   void removeConnection(Connection paramConnection) {
/*     */     ArrayList<?> arrayList;
/* 626 */     (arrayList = new ArrayList(Arrays.asList((Object[])this.connections))).remove(paramConnection);
/* 627 */     this.connections = arrayList.<Connection>toArray(new Connection[arrayList.size()]);
/*     */     
/* 629 */     this.pendingConnections.remove(paramConnection.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAllTCP(Object paramObject) {
/* 636 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 637 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 639 */       (connection = arrayOfConnection[b]).sendTCP(paramObject);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendToAllExceptTCP(int paramInt, Object paramObject) {
/* 644 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 645 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 647 */       if ((connection = arrayOfConnection[b]).id != paramInt)
/* 648 */         connection.sendTCP(paramObject); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendToTCP(int paramInt, Object paramObject) {
/* 653 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 654 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 656 */       if ((connection = arrayOfConnection[b]).id == paramInt) {
/* 657 */         connection.sendTCP(paramObject);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendToAllUDP(Object paramObject) {
/* 664 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 665 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 667 */       (connection = arrayOfConnection[b]).sendUDP(paramObject);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendToAllExceptUDP(int paramInt, Object paramObject) {
/* 672 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 673 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 675 */       if ((connection = arrayOfConnection[b]).id != paramInt)
/* 676 */         connection.sendUDP(paramObject); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendToUDP(int paramInt, Object paramObject) {
/* 681 */     Connection[] arrayOfConnection = this.connections; byte b; int i;
/* 682 */     for (b = 0, i = arrayOfConnection.length; b < i; b++) {
/*     */       Connection connection;
/* 684 */       if ((connection = arrayOfConnection[b]).id == paramInt) {
/* 685 */         connection.sendUDP(paramObject);
/*     */         return;
/*     */       } 
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
/*     */   public void addListener(Listener paramListener) {
/* 699 */     if (paramListener == null)
/* 700 */       throw new NullPointerException("listener cannot be null."); 
/* 701 */     synchronized (this.listenerLock) {
/*     */       Listener[] arrayOfListener1;
/* 703 */       int i = (arrayOfListener1 = this.listeners).length;
/* 704 */       for (byte b = 0; b < i; b++) {
/* 705 */         if (paramListener == arrayOfListener1[b])
/*     */           return; 
/*     */       }  Listener[] arrayOfListener2;
/* 708 */       (arrayOfListener2 = new Listener[i + 1])[0] = paramListener;
/* 709 */       System.arraycopy(arrayOfListener1, 0, arrayOfListener2, 1, i);
/* 710 */       this.listeners = arrayOfListener2;
/*     */     } 
/* 712 */     if (Log.TRACE) {
/* 713 */       Log.trace("kryonet", "Server listener added: " + paramListener
/* 714 */           .getClass().getName());
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(Listener paramListener) {
/* 719 */     if (paramListener == null)
/* 720 */       throw new NullPointerException("listener cannot be null."); 
/* 721 */     synchronized (this.listenerLock) {
/*     */       Listener[] arrayOfListener1;
/*     */       int i;
/* 724 */       Listener[] arrayOfListener2 = new Listener[(i = (arrayOfListener1 = this.listeners).length) - 1];
/* 725 */       for (byte b1 = 0, b2 = 0; b1 < i; b1++) {
/* 726 */         Listener listener = arrayOfListener1[b1];
/* 727 */         if (paramListener != listener) {
/*     */           
/* 729 */           if (b2 == i - 1)
/*     */             return; 
/* 731 */           arrayOfListener2[b2++] = listener;
/*     */         } 
/* 733 */       }  this.listeners = arrayOfListener2;
/*     */     } 
/* 735 */     if (Log.TRACE) {
/* 736 */       Log.trace("kryonet", "Server listener removed: " + paramListener
/* 737 */           .getClass().getName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     Object object;
/* 745 */     Connection[] arrayOfConnection = this.connections;
/* 746 */     if (Log.INFO && arrayOfConnection.length > 0)
/* 747 */       Log.info("kryonet", "Closing server connections...");  byte b; int i;
/* 748 */     for (b = 0, i = arrayOfConnection.length; b < i; b++)
/* 749 */       arrayOfConnection[b].close(); 
/* 750 */     new Connection[0];
/*     */     
/*     */     ServerSocketChannel serverSocketChannel;
/* 753 */     if ((serverSocketChannel = this.serverChannel) != null) {
/*     */       try {
/* 755 */         serverSocketChannel.close();
/* 756 */         if (Log.INFO)
/* 757 */           Log.info("kryonet", "Server closed."); 
/* 758 */       } catch (IOException iOException) {
/* 759 */         if (Log.DEBUG)
/* 760 */           Log.debug("kryonet", "Unable to close server.", iOException); 
/*     */       } 
/* 762 */       this.serverChannel = null;
/*     */     } 
/*     */     
/*     */     UdpConnection udpConnection;
/* 766 */     if ((udpConnection = this.udp) != null) {
/* 767 */       udpConnection.close();
/* 768 */       this.udp = null;
/*     */     } 
/*     */ 
/*     */     
/*     */     /* monitor enter BinaryOperatorExpression{ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} = FieldReferenceExpression{lastType=ObjectType{java/lang/Object}, expression=ThisExpression{ObjectType{com/esotericsoftware/kryonet/Server}}, name=updateLock, descriptor=Ljava/lang/Object;}} */
/*     */     
/*     */     /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */     
/* 776 */     this.selector.wakeup();
/*     */     try {
/* 778 */       this.selector.selectNow(); return;
/* 779 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 787 */     close();
/* 788 */     this.selector.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public Thread getUpdateThread() {
/* 793 */     return this.updateThread;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<Connection> getConnections() {
/* 801 */     return Collections.unmodifiableCollection(Arrays.asList(this.connections));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\Server.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */