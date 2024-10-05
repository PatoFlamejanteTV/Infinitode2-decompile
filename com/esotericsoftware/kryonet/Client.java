/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryonet.serialization.KryoSerialization;
/*     */ import com.esotericsoftware.kryonet.serialization.Serialization;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.InterfaceAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.CancelledKeyException;
/*     */ import java.nio.channels.SelectionKey;
/*     */ import java.nio.channels.Selector;
/*     */ import java.security.AccessControlException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class Client
/*     */   extends Connection
/*     */   implements EndPoint
/*     */ {
/*     */   public static final int DEFAULT_WRITE_BUFFER_SIZE = 8192;
/*     */   public static final int DEFAULT_OBJECT_BUUFER_SIZE = 2048;
/*     */   private final Serialization serialization;
/*     */   private Selector selector;
/*     */   private int emptySelects;
/*     */   private volatile boolean tcpRegistered;
/*     */   private volatile boolean udpRegistered;
/*     */   
/*     */   static {
/*     */     try {
/*  66 */       System.setProperty("java.net.preferIPv6Addresses", "false"); return;
/*  67 */     } catch (AccessControlException accessControlException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   private final Object tcpRegistrationLock = new Object();
/*  79 */   private final Object udpRegistrationLock = new Object();
/*     */   private volatile boolean shutdown;
/*  81 */   private final Object updateLock = new Object();
/*     */   
/*     */   private Thread updateThread;
/*     */   
/*     */   private int connectTimeout;
/*     */   
/*     */   private InetAddress connectHost;
/*     */   
/*     */   private int connectTcpPort;
/*     */   private int connectUdpPort;
/*     */   private boolean isClosed;
/*     */   private ClientDiscoveryHandler discoveryHandler;
/*     */   
/*     */   public Client() {
/*  95 */     this(8192, 2048);
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
/*     */   public Client(int paramInt1, int paramInt2) {
/* 125 */     this(paramInt1, paramInt2, (Serialization)new KryoSerialization());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Client(int paramInt1, int paramInt2, Serialization paramSerialization) {
/* 131 */     this.endPoint = this;
/*     */     
/* 133 */     this.serialization = paramSerialization;
/*     */     
/* 135 */     this.discoveryHandler = new ClientDiscoveryHandler() {
/*     */       
/*     */       };
/* 138 */     initialize(paramSerialization, paramInt1, paramInt2);
/*     */     
/*     */     try {
/* 141 */       this.selector = Selector.open(); return;
/* 142 */     } catch (IOException iOException) {
/* 143 */       throw new RuntimeException("Error opening selector.", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDiscoveryHandler(ClientDiscoveryHandler paramClientDiscoveryHandler) {
/* 149 */     this.discoveryHandler = paramClientDiscoveryHandler;
/*     */   }
/*     */ 
/*     */   
/*     */   public Kryo getKryo() {
/* 154 */     if (this.serialization instanceof KryoSerialization)
/* 155 */       return ((KryoSerialization)this.serialization).getKryo();  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(String paramString, int paramInt) {
/* 165 */     connect(500, InetAddress.getByName(paramString), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(int paramInt1, String paramString, int paramInt2) {
/* 175 */     connect(paramInt1, InetAddress.getByName(paramString), paramInt2, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 185 */     connect(paramInt1, InetAddress.getByName(paramString), paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(int paramInt1, InetAddress paramInetAddress, int paramInt2) {
/* 195 */     connect(paramInt1, paramInetAddress, paramInt2, -1);
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
/*     */   public void connect(int paramInt1, InetAddress paramInetAddress, int paramInt2, int paramInt3) {
/* 215 */     if (paramInetAddress == null)
/* 216 */       throw new NullPointerException("host cannot be null."); 
/* 217 */     if (Thread.currentThread() == getUpdateThread()) {
/* 218 */       throw new IllegalStateException("Cannot connect on the connection's update thread.");
/*     */     }
/*     */     
/* 221 */     this.connectTimeout = paramInt1;
/* 222 */     this.connectHost = paramInetAddress;
/* 223 */     this.connectTcpPort = paramInt2;
/* 224 */     this.connectUdpPort = paramInt3;
/* 225 */     close();
/* 226 */     if (Log.INFO)
/* 227 */       if (paramInt3 != -1) {
/* 228 */         Log.info("kryonet", "Connecting: " + paramInetAddress + ":" + paramInt2 + "/" + paramInt3);
/*     */       } else {
/*     */         
/* 231 */         Log.info("kryonet", "Connecting: " + paramInetAddress + ":" + paramInt2);
/*     */       }  
/* 233 */     this.id = -1; try {
/*     */       long l;
/* 235 */       if (paramInt3 != -1) {
/* 236 */         this
/* 237 */           .udp = new UdpConnection(this.serialization, this.tcp.readBuffer.capacity());
/*     */       }
/*     */       
/* 240 */       synchronized (this.updateLock) {
/* 241 */         this.tcpRegistered = false;
/* 242 */         this.selector.wakeup();
/* 243 */         l = System.currentTimeMillis() + paramInt1;
/* 244 */         this.tcp.connect(this.selector, new InetSocketAddress(paramInetAddress, paramInt2), paramInt1);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 249 */       synchronized (this.tcpRegistrationLock) {
/* 250 */         while (!this.tcpRegistered && System.currentTimeMillis() < l) {
/*     */           try {
/* 252 */             this.tcpRegistrationLock.wait(100L);
/* 253 */           } catch (InterruptedException interruptedException) {}
/*     */         } 
/*     */         
/* 256 */         if (!this.tcpRegistered) {
/* 257 */           throw new SocketTimeoutException("Connected, but timed out during TCP registration.\nNote: Client#update(int) must be called in a separate thread during connect.");
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 263 */       if (paramInt3 != -1) {
/* 264 */         InetSocketAddress inetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt3);
/*     */         
/* 266 */         synchronized (this.updateLock) {
/* 267 */           this.udpRegistered = false;
/* 268 */           this.selector.wakeup();
/* 269 */           this.udp.connect(this.selector, inetSocketAddress);
/*     */         } 
/*     */ 
/*     */         
/* 273 */         synchronized (this.udpRegistrationLock) {
/* 274 */           while (!this.udpRegistered && 
/* 275 */             System.currentTimeMillis() < l) {
/*     */             FrameworkMessage.RegisterUDP registerUDP;
/* 277 */             (registerUDP = new FrameworkMessage.RegisterUDP()).connectionID = this.id;
/* 278 */             this.udp.send(this, registerUDP, inetSocketAddress);
/*     */             try {
/* 280 */               this.udpRegistrationLock.wait(100L);
/* 281 */             } catch (InterruptedException interruptedException) {}
/*     */           } 
/*     */           
/* 284 */           if (!this.udpRegistered)
/* 285 */             throw new SocketTimeoutException("Connected, but timed out during UDP registration: " + paramInetAddress + ":" + paramInt3); 
/*     */         } 
/*     */       } else {
/*     */         return;
/*     */       } 
/* 290 */     } catch (IOException iOException) {
/* 291 */       close();
/* 292 */       throw iOException;
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
/*     */   public void reconnect() {
/* 304 */     reconnect(this.connectTimeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reconnect(int paramInt) {
/* 315 */     if (this.connectHost == null) {
/* 316 */       throw new IllegalStateException("This client has never been connected.");
/*     */     }
/* 318 */     connect(paramInt, this.connectHost, this.connectTcpPort, this.connectUdpPort);
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
/*     */   public void update(int paramInt) {
/*     */     Object object;
/* 332 */     this.updateThread = Thread.currentThread();
/*     */     
/*     */     /* monitor enter BinaryOperatorExpression{ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} = FieldReferenceExpression{lastType=ObjectType{java/lang/Object}, expression=ThisExpression{ObjectType{com/esotericsoftware/kryonet/Client}}, name=updateLock, descriptor=Ljava/lang/Object;}} */
/*     */     
/*     */     /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/* 337 */     long l = System.currentTimeMillis();
/*     */     
/* 339 */     if (paramInt > 0) {
/* 340 */       paramInt = this.selector.select(paramInt);
/*     */     } else {
/* 342 */       paramInt = this.selector.selectNow();
/*     */     } 
/* 344 */     if (paramInt == 0) {
/* 345 */       this.emptySelects++;
/* 346 */       if (this.emptySelects == 100) {
/* 347 */         this.emptySelects = 0;
/*     */ 
/*     */         
/* 350 */         long l1 = System.currentTimeMillis() - l;
/*     */         try {
/* 352 */           if (l1 < 25L)
/* 353 */             Thread.sleep(25L - l1); 
/* 354 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */     } else {
/*     */       
/* 358 */       this.emptySelects = 0;
/* 359 */       this.isClosed = false;
/*     */       Set<SelectionKey> set;
/* 361 */       synchronized (set = this.selector.selectedKeys()) {
/* 362 */         Iterator<SelectionKey> iterator = set.iterator();
/* 363 */         while (iterator.hasNext()) {
/* 364 */           keepAlive();
/* 365 */           SelectionKey selectionKey = iterator.next();
/* 366 */           iterator.remove();
/*     */           try {
/*     */             int i;
/* 369 */             if (((i = selectionKey.readyOps()) & 0x1) == 1) {
/* 370 */               if (selectionKey.attachment() == this.tcp)
/*     */               { Object object1;
/*     */                 
/* 373 */                 while ((object1 = this.tcp.readObject(this)) != null) {
/*     */                   
/* 375 */                   if (!this.tcpRegistered) {
/* 376 */                     if (object1 instanceof FrameworkMessage.RegisterTCP) {
/* 377 */                       this.id = ((FrameworkMessage.RegisterTCP)object1).connectionID;
/* 378 */                       synchronized (this.tcpRegistrationLock) {
/* 379 */                         this.tcpRegistered = true;
/* 380 */                         this.tcpRegistrationLock.notifyAll();
/* 381 */                         if (Log.TRACE) {
/* 382 */                           Log.trace("kryonet", this + " received TCP: RegisterTCP");
/*     */                         }
/* 384 */                         if (this.udp == null)
/* 385 */                           setConnected(true); 
/*     */                       } 
/* 387 */                       if (this.udp == null)
/* 388 */                         notifyConnected(); 
/*     */                     } 
/*     */                     continue;
/*     */                   } 
/* 392 */                   if (this.udp != null && !this.udpRegistered) {
/* 393 */                     if (object1 instanceof FrameworkMessage.RegisterUDP) {
/* 394 */                       synchronized (this.udpRegistrationLock) {
/* 395 */                         this.udpRegistered = true;
/* 396 */                         this.udpRegistrationLock.notifyAll();
/* 397 */                         if (Log.TRACE) {
/* 398 */                           Log.trace("kryonet", this + " received UDP: RegisterUDP");
/*     */                         }
/* 400 */                         if (Log.DEBUG) {
/* 401 */                           Log.debug("kryonet", "Port " + this.udp.datagramChannel
/*     */                               
/* 403 */                               .socket()
/* 404 */                               .getLocalPort() + "/UDP connected to: " + this.udp.connectedAddress);
/*     */                         }
/*     */ 
/*     */                         
/* 408 */                         setConnected(true);
/*     */                       } 
/* 410 */                       notifyConnected();
/*     */                     } 
/*     */                     continue;
/*     */                   } 
/* 414 */                   if (this.isConnected) {
/*     */                     
/* 416 */                     if (Log.DEBUG) {
/*     */ 
/*     */ 
/*     */                       
/* 420 */                       String str = (object1 == null) ? "null" : object1.getClass().getSimpleName();
/* 421 */                       if (!(object1 instanceof FrameworkMessage)) {
/* 422 */                         Log.debug("kryonet", this + " received TCP: " + str);
/*     */                       
/*     */                       }
/* 425 */                       else if (Log.TRACE) {
/* 426 */                         Log.trace("kryonet", this + " received TCP: " + str);
/*     */                       } 
/*     */                     } 
/*     */ 
/*     */                     
/* 431 */                     notifyReceived(object1);
/*     */                   } 
/*     */                 }  }
/* 434 */               else { if (this.udp.readFromAddress() == null)
/*     */                   continue; 
/*     */                 Object object1;
/* 437 */                 if ((object1 = this.udp.readObject(this)) == null)
/*     */                   continue; 
/* 439 */                 if (Log.DEBUG) {
/*     */ 
/*     */                   
/* 442 */                   String str = (object1 == null) ? "null" : object1.getClass().getSimpleName();
/* 443 */                   Log.debug("kryonet", this + " received UDP: " + str);
/*     */                 } 
/*     */                 
/* 446 */                 notifyReceived(object1); }
/*     */             
/*     */             }
/* 449 */             if ((i & 0x4) == 4)
/* 450 */               this.tcp.writeOperation(); 
/* 451 */           } catch (CancelledKeyException cancelledKeyException) {}
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 457 */     if (this.isConnected) {
/* 458 */       long l1 = System.currentTimeMillis();
/* 459 */       if (this.tcp.isTimedOut(l1)) {
/* 460 */         if (Log.DEBUG)
/* 461 */           Log.debug("kryonet", this + " timed out."); 
/* 462 */         close();
/*     */       } else {
/* 464 */         keepAlive();
/* 465 */       }  if (isIdle())
/* 466 */         notifyIdle(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   void keepAlive() {
/* 471 */     if (!this.isConnected)
/*     */       return; 
/* 473 */     long l = System.currentTimeMillis();
/* 474 */     if (this.tcp.needsKeepAlive(l))
/* 475 */       sendTCP(FrameworkMessage.keepAlive); 
/* 476 */     if (this.udp != null && this.udpRegistered && this.udp.needsKeepAlive(l)) {
/* 477 */       sendUDP(FrameworkMessage.keepAlive);
/*     */     }
/*     */   }
/*     */   
/*     */   public void run() {
/* 482 */     if (Log.TRACE)
/* 483 */       Log.trace("kryonet", "Client thread started."); 
/* 484 */     this.shutdown = false;
/* 485 */     while (!this.shutdown) {
/*     */       try {
/* 487 */         update(250);
/* 488 */       } catch (IOException iOException) {
/* 489 */         if (Log.TRACE) {
/* 490 */           if (this.isConnected)
/* 491 */           { Log.trace("kryonet", "Unable to update connection: " + this, iOException); }
/*     */           else
/*     */           
/* 494 */           { Log.trace("kryonet", "Unable to update connection.", iOException); } 
/* 495 */         } else if (Log.DEBUG) {
/* 496 */           if (this.isConnected) {
/* 497 */             Log.debug("kryonet", this + " update: " + iOException.getMessage());
/*     */           } else {
/* 499 */             Log.debug("kryonet", "Unable to update connection: " + iOException
/* 500 */                 .getMessage());
/*     */           } 
/* 502 */         }  close();
/* 503 */       } catch (KryoNetException kryoNetException) {
/* 504 */         this.lastProtocolError = kryoNetException;
/* 505 */         if (Log.ERROR)
/* 506 */           if (this.isConnected) {
/* 507 */             Log.error("kryonet", "Error updating connection: " + this, kryoNetException);
/*     */           } else {
/*     */             
/* 510 */             Log.error("kryonet", "Error updating connection.", kryoNetException);
/*     */           }  
/* 512 */         close();
/* 513 */         throw kryoNetException;
/*     */       } 
/*     */     } 
/* 516 */     if (Log.TRACE) {
/* 517 */       Log.trace("kryonet", "Client thread stopped.");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/* 523 */     if (this.updateThread != null) {
/* 524 */       this.shutdown = true;
/*     */       try {
/* 526 */         this.updateThread.join(5000L);
/* 527 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */     
/* 530 */     this.updateThread = new Thread(this, "Client");
/* 531 */     this.updateThread.setDaemon(true);
/* 532 */     this.updateThread.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 537 */     if (this.shutdown)
/*     */       return; 
/* 539 */     close();
/* 540 */     if (Log.TRACE)
/* 541 */       Log.trace("kryonet", "Client thread stopping."); 
/* 542 */     this.shutdown = true;
/* 543 */     this.selector.wakeup();
/*     */   }
/*     */   
/*     */   public void close() {
/*     */     Object object;
/* 548 */     super.close();
/*     */     
/*     */     /* monitor enter BinaryOperatorExpression{ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} = FieldReferenceExpression{lastType=ObjectType{java/lang/Object}, expression=ThisExpression{ObjectType{com/esotericsoftware/kryonet/Client}}, name=updateLock, descriptor=Ljava/lang/Object;}} */
/*     */     
/*     */     /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */     
/* 554 */     if (!this.isClosed) {
/* 555 */       this.isClosed = true;
/* 556 */       this.selector.wakeup();
/*     */       
/*     */       try {
/* 559 */         this.selector.selectNow(); return;
/* 560 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 569 */     close();
/* 570 */     this.selector.close();
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
/*     */   public void addListener(Listener paramListener) {
/* 582 */     super.addListener(paramListener);
/* 583 */     if (Log.TRACE) {
/* 584 */       Log.trace("kryonet", "Client listener added.");
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(Listener paramListener) {
/* 589 */     super.removeListener(paramListener);
/* 590 */     if (Log.TRACE) {
/* 591 */       Log.trace("kryonet", "Client listener removed.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeepAliveUDP(int paramInt) {
/* 602 */     if (this.udp == null)
/* 603 */       throw new IllegalStateException("Not connected via UDP."); 
/* 604 */     this.udp.keepAliveMillis = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public Thread getUpdateThread() {
/* 609 */     return this.updateThread;
/*     */   }
/*     */   
/*     */   public Serialization getSerialization() {
/* 613 */     return this.serialization;
/*     */   }
/*     */ 
/*     */   
/*     */   private void broadcast(int paramInt, DatagramSocket paramDatagramSocket) {
/* 618 */     ByteBuffer byteBuffer = ByteBuffer.allocate(64);
/* 619 */     this.serialization.write(null, byteBuffer, new FrameworkMessage.DiscoverHost());
/* 620 */     byteBuffer.flip();
/* 621 */     byte[] arrayOfByte = new byte[byteBuffer.limit()];
/* 622 */     byteBuffer.get(arrayOfByte);
/*     */ 
/*     */     
/* 625 */     Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
/* 626 */     while (enumeration.hasMoreElements()) {
/*     */       NetworkInterface networkInterface;
/*     */       
/* 629 */       if (!(networkInterface = enumeration.nextElement()).isLoopback() && networkInterface.isUp())
/*     */       {
/*     */ 
/*     */         
/* 633 */         for (Iterator<InterfaceAddress> iterator = networkInterface
/* 634 */           .getInterfaceAddresses().iterator(); iterator.hasNext();) {
/*     */           
/* 636 */           if ((inetAddress = (interfaceAddress = iterator.next()).getBroadcast()) != null)
/*     */           {
/*     */             
/* 639 */             paramDatagramSocket.send(new DatagramPacket(arrayOfByte, arrayOfByte.length, inetAddress, paramInt));
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 644 */     if (Log.DEBUG) {
/* 645 */       Log.debug("kryonet", "Broadcasted host discovery on port: " + paramInt);
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
/*     */   
/*     */   public InetAddress discoverHost(int paramInt1, int paramInt2) {
/* 659 */     DatagramSocket datagramSocket = null;
/*     */     try {
/* 661 */       datagramSocket = new DatagramSocket();
/* 662 */       broadcast(paramInt1, datagramSocket);
/* 663 */       datagramSocket.setSoTimeout(paramInt2);
/*     */       
/* 665 */       DatagramPacket datagramPacket = this.discoveryHandler.onRequestNewDatagramPacket();
/*     */       try {
/* 667 */         datagramSocket.receive(datagramPacket);
/* 668 */       } catch (SocketTimeoutException socketTimeoutException) {
/* 669 */         if (Log.INFO)
/* 670 */           Log.info("kryonet", "Host discovery timed out."); 
/* 671 */         datagramPacket = null; return (InetAddress)datagramPacket;
/*     */       } 
/* 673 */       if (Log.INFO)
/* 674 */         Log.info("kryonet", "Discovered server: " + datagramPacket.getAddress()); 
/* 675 */       this.discoveryHandler.onDiscoveredHost(datagramPacket);
/* 676 */       return datagramPacket.getAddress();
/* 677 */     } catch (IOException iOException) {
/* 678 */       if (Log.ERROR)
/* 679 */         Log.error("kryonet", "Host discovery failed.", iOException); 
/* 680 */       iOException = null; return (InetAddress)iOException;
/*     */     } finally {
/* 682 */       if (datagramSocket != null)
/* 683 */         datagramSocket.close(); 
/* 684 */       this.discoveryHandler.onFinally();
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
/*     */   public List<InetAddress> discoverHosts(int paramInt1, int paramInt2) {
/* 697 */     ArrayList<InetAddress> arrayList = new ArrayList();
/* 698 */     DatagramSocket datagramSocket = null;
/*     */     try {
/* 700 */       datagramSocket = new DatagramSocket();
/* 701 */       broadcast(paramInt1, datagramSocket);
/* 702 */       datagramSocket.setSoTimeout(paramInt2);
/*     */       while (true) {
/*     */         ArrayList<InetAddress> arrayList1;
/* 705 */         DatagramPacket datagramPacket = this.discoveryHandler.onRequestNewDatagramPacket();
/*     */         try {
/* 707 */           datagramSocket.receive(datagramPacket);
/* 708 */         } catch (SocketTimeoutException socketTimeoutException) {
/* 709 */           if (Log.INFO)
/* 710 */             Log.info("kryonet", "Host discovery timed out."); 
/* 711 */           arrayList1 = arrayList; return arrayList1;
/*     */         } 
/* 713 */         if (Log.INFO)
/* 714 */           Log.info("kryonet", "Discovered server: " + arrayList1
/* 715 */               .getAddress()); 
/* 716 */         this.discoveryHandler.onDiscoveredHost((DatagramPacket)arrayList1);
/* 717 */         arrayList.add(arrayList1.getAddress());
/*     */       } 
/* 719 */     } catch (IOException iOException) {
/* 720 */       if (Log.ERROR)
/* 721 */         Log.error("kryonet", "Host discovery failed.", iOException); 
/* 722 */       return arrayList;
/*     */     } finally {
/* 724 */       if (datagramSocket != null)
/* 725 */         datagramSocket.close(); 
/* 726 */       this.discoveryHandler.onFinally();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */