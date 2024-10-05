/*      */ package com.esotericsoftware.kryonet.rmi;
/*      */ 
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoException;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.Serializer;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.esotericsoftware.kryo.serializers.FieldSerializer;
/*      */ import com.esotericsoftware.kryo.util.IntMap;
/*      */ import com.esotericsoftware.kryo.util.Util;
/*      */ import com.esotericsoftware.kryonet.Connection;
/*      */ import com.esotericsoftware.kryonet.FrameworkMessage;
/*      */ import com.esotericsoftware.kryonet.KryoNetException;
/*      */ import com.esotericsoftware.kryonet.Listener;
/*      */ import com.esotericsoftware.kryonet.util.ObjectIntMap;
/*      */ import com.esotericsoftware.minlog.Log;
/*      */ import com.esotericsoftware.reflectasm.MethodAccess;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.locks.Condition;
/*      */ import java.util.concurrent.locks.ReentrantLock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ObjectSpace
/*      */ {
/*      */   private static final int returnValueMask = 128;
/*      */   private static final int returnExceptionMask = 64;
/*      */   private static final int responseIdMask = 63;
/*   85 */   private static final Object instancesLock = new Object();
/*   86 */   static ObjectSpace[] instances = new ObjectSpace[0];
/*   87 */   private static final HashMap<Class<?>, CachedMethod[]> methodCache = (HashMap)new HashMap<>();
/*      */   
/*      */   private static boolean useAsm = true;
/*   90 */   final IntMap<Object> idToObject = new IntMap();
/*   91 */   final ObjectIntMap<Object> objectToID = new ObjectIntMap();
/*   92 */   Connection[] connections = new Connection[0];
/*   93 */   final Object connectionsLock = new Object();
/*      */   Executor executor;
/*      */   
/*   96 */   private final Listener invokeListener = new Listener()
/*      */     {
/*      */       public void received(final Connection connection, Object param1Object) {
/*   99 */         if (!(param1Object instanceof ObjectSpace.InvokeMethod))
/*      */           return; 
/*  101 */         if (ObjectSpace.this.connections != null) {
/*  102 */           byte b = 0; int i = ObjectSpace.this.connections.length;
/*  103 */           for (; b < i && 
/*  104 */             connection != ObjectSpace.this.connections[b]; b++);
/*      */           
/*  106 */           if (b == i) {
/*      */             return;
/*      */           }
/*      */         } 
/*  110 */         final ObjectSpace.InvokeMethod invokeMethod = (ObjectSpace.InvokeMethod)param1Object;
/*      */         final Object target;
/*  112 */         if ((object = ObjectSpace.this.idToObject.get(invokeMethod.objectID)) == null) {
/*  113 */           if (Log.WARN) {
/*  114 */             Log.warn("kryonet", "Ignoring remote invocation request for unknown object ID: " + invokeMethod.objectID);
/*      */           }
/*      */           
/*      */           return;
/*      */         } 
/*  119 */         if (ObjectSpace.this.executor == null) {
/*  120 */           ObjectSpace.this.invoke(connection, object, invokeMethod); return;
/*      */         } 
/*  122 */         ObjectSpace.this.executor.execute(new Runnable()
/*      */             {
/*      */               public void run() {
/*  125 */                 ObjectSpace.this.invoke(connection, target, invokeMethod);
/*      */               }
/*      */             });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void disconnected(Connection param1Connection) {
/*  133 */         ObjectSpace.this.removeConnection(param1Connection);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ObjectSpace() {
/*  143 */     synchronized (instancesLock) {
/*      */       ObjectSpace[] arrayOfObjectSpace1, arrayOfObjectSpace2;
/*      */       
/*  146 */       (arrayOfObjectSpace2 = new ObjectSpace[(arrayOfObjectSpace1 = instances).length + 1])[0] = this;
/*  147 */       System.arraycopy(arrayOfObjectSpace1, 0, arrayOfObjectSpace2, 1, arrayOfObjectSpace1.length);
/*  148 */       instances = arrayOfObjectSpace2;
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ObjectSpace(Connection paramConnection) {
/*  157 */     this();
/*  158 */     addConnection(paramConnection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExecutor(Executor paramExecutor) {
/*  170 */     this.executor = paramExecutor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void register(int paramInt, Object paramObject) {
/*  185 */     if (paramInt == Integer.MAX_VALUE) {
/*  186 */       throw new IllegalArgumentException("objectID cannot be Integer.MAX_VALUE.");
/*      */     }
/*  188 */     if (paramObject == null) {
/*  189 */       throw new NullPointerException("object to register cannot be null.");
/*      */     }
/*      */     
/*  192 */     this.idToObject.put(paramInt, paramObject);
/*  193 */     this.objectToID.put(paramObject, paramInt);
/*  194 */     if (Log.TRACE) {
/*  195 */       Log.trace("kryonet", "Object registered with ObjectSpace as " + paramInt + ": " + paramObject);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove(int paramInt) {
/*      */     Object object;
/*  205 */     if ((object = this.idToObject.remove(paramInt)) != null)
/*  206 */       this.objectToID.remove(object, 0); 
/*  207 */     if (Log.TRACE) {
/*  208 */       Log.trace("kryonet", "Object " + paramInt + " removed from ObjectSpace: " + object);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove(Object paramObject) {
/*  217 */     if (!this.idToObject.containsValue(paramObject, true))
/*      */       return; 
/*  219 */     int i = this.idToObject.findKey(paramObject, true, -1);
/*  220 */     this.idToObject.remove(i);
/*  221 */     this.objectToID.remove(paramObject, 0);
/*  222 */     if (Log.TRACE) {
/*  223 */       Log.trace("kryonet", "Object " + i + " removed from ObjectSpace: " + paramObject);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  232 */     null = this.connections;
/*  233 */     for (byte b = 0; b < null.length; b++) {
/*  234 */       null[b].removeListener(this.invokeListener);
/*      */     }
/*  236 */     synchronized (instancesLock) {
/*      */       ArrayList<?> arrayList;
/*      */       
/*  239 */       (arrayList = new ArrayList(Arrays.asList((Object[])instances))).remove(this);
/*  240 */       instances = arrayList.<ObjectSpace>toArray(new ObjectSpace[arrayList.size()]);
/*      */     } 
/*      */     
/*  243 */     if (Log.TRACE) {
/*  244 */       Log.trace("kryonet", "Closed ObjectSpace.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addConnection(Connection paramConnection) {
/*  252 */     if (paramConnection == null) {
/*  253 */       throw new NullPointerException("connection cannot be null.");
/*      */     }
/*  255 */     synchronized (this.connectionsLock) {
/*      */       Connection[] arrayOfConnection;
/*      */       
/*  258 */       (arrayOfConnection = new Connection[this.connections.length + 1])[0] = paramConnection;
/*  259 */       System.arraycopy(this.connections, 0, arrayOfConnection, 1, this.connections.length);
/*      */       
/*  261 */       this.connections = arrayOfConnection;
/*      */     } 
/*      */     
/*  264 */     paramConnection.addListener(this.invokeListener);
/*      */     
/*  266 */     if (Log.TRACE) {
/*  267 */       Log.trace("kryonet", "Added connection to ObjectSpace: " + paramConnection);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeConnection(Connection paramConnection) {
/*  275 */     if (paramConnection == null) {
/*  276 */       throw new NullPointerException("connection cannot be null.");
/*      */     }
/*  278 */     paramConnection.removeListener(this.invokeListener);
/*      */     
/*  280 */     synchronized (this.connectionsLock) {
/*      */       ArrayList<?> arrayList;
/*      */       
/*  283 */       (arrayList = new ArrayList(Arrays.asList((Object[])this.connections))).remove(paramConnection);
/*  284 */       this.connections = arrayList.<Connection>toArray(new Connection[arrayList.size()]);
/*      */     } 
/*      */     
/*  287 */     if (Log.TRACE) {
/*  288 */       Log.trace("kryonet", "Removed connection from ObjectSpace: " + paramConnection);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void invoke(Connection paramConnection, Object paramObject, InvokeMethod paramInvokeMethod) {
/*  303 */     if (Log.DEBUG) {
/*  304 */       String str = "";
/*  305 */       if (paramInvokeMethod.args != null)
/*      */       {
/*  307 */         str = (str = Arrays.deepToString(paramInvokeMethod.args)).substring(1, str.length() - 1);
/*      */       }
/*  309 */       Log.debug("kryonet", paramConnection + " received: " + paramObject
/*      */           
/*  311 */           .getClass().getSimpleName() + "#" + paramInvokeMethod.cachedMethod.method
/*  312 */           .getName() + "(" + str + ")");
/*      */     } 
/*      */     
/*      */     byte b;
/*      */     
/*  317 */     boolean bool1 = (((b = paramInvokeMethod.responseData) & 0x80) == 128) ? true : false;
/*      */     
/*  319 */     boolean bool2 = ((b & 0x40) == 64) ? true : false;
/*      */     
/*  321 */     int j = b & 0x3F;
/*      */     
/*  323 */     CachedMethod cachedMethod = paramInvokeMethod.cachedMethod;
/*      */     
/*      */     try {
/*  326 */       paramObject = cachedMethod.invoke(paramObject, paramInvokeMethod.args);
/*  327 */     } catch (InvocationTargetException invocationTargetException) {
/*  328 */       if (bool2)
/*  329 */       { paramObject = invocationTargetException.getCause(); }
/*      */       else
/*  331 */       { throw new KryoNetException("Error invoking method: " + cachedMethod.method
/*  332 */             .getDeclaringClass().getName() + "." + cachedMethod.method
/*  333 */             .getName(), invocationTargetException); } 
/*  334 */     } catch (Exception exception) {
/*  335 */       throw new KryoNetException("Error invoking method: " + cachedMethod.method
/*  336 */           .getDeclaringClass().getName() + "." + cachedMethod.method
/*  337 */           .getName(), exception);
/*      */     } 
/*      */     
/*  340 */     if (j == 0) {
/*      */       return;
/*      */     }
/*      */     InvokeMethodResult invokeMethodResult;
/*  344 */     (invokeMethodResult = new InvokeMethodResult()).objectID = paramInvokeMethod.objectID;
/*  345 */     invokeMethodResult.responseID = (byte)j;
/*      */ 
/*      */     
/*  348 */     if (!bool1 && 
/*  349 */       !paramInvokeMethod.cachedMethod.method.getReturnType().isPrimitive()) {
/*  350 */       invokeMethodResult.result = null;
/*      */     } else {
/*  352 */       invokeMethodResult.result = paramObject;
/*      */     } 
/*      */     
/*  355 */     int i = paramConnection.sendTCP(invokeMethodResult);
/*  356 */     if (Log.DEBUG) {
/*  357 */       Log.debug("kryonet", paramConnection + " sent TCP: " + paramObject + " (" + i + ")");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T getRemoteObject(Connection paramConnection, int paramInt, Class<T> paramClass) {
/*  368 */     return (T)getRemoteObject(paramConnection, paramInt, new Class[] { paramClass });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static RemoteObject getRemoteObject(Connection paramConnection, int paramInt, Class<?>... paramVarArgs) {
/*  397 */     if (paramConnection == null)
/*  398 */       throw new NullPointerException("connection cannot be null."); 
/*  399 */     if (paramVarArgs == null)
/*  400 */       throw new NullPointerException("ifaces cannot be null."); 
/*      */     Class[] arrayOfClass;
/*  402 */     (arrayOfClass = new Class[paramVarArgs.length + 1])[0] = RemoteObject.class;
/*  403 */     System.arraycopy(paramVarArgs, 0, arrayOfClass, 1, paramVarArgs.length);
/*  404 */     return (RemoteObject)Proxy.newProxyInstance(ObjectSpace.class
/*  405 */         .getClassLoader(), arrayOfClass, new RemoteInvocationHandler(paramConnection, paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   private static class RemoteInvocationHandler
/*      */     implements InvocationHandler
/*      */   {
/*      */     private final Connection connection;
/*      */     
/*      */     final int objectID;
/*  415 */     private int timeoutMillis = 3000;
/*      */     private boolean nonBlocking;
/*      */     private boolean transmitReturnValue = true;
/*      */     private boolean transmitExceptions = true;
/*      */     private boolean remoteToString;
/*      */     private boolean udp;
/*      */     private Byte lastResponseID;
/*  422 */     private byte nextResponseId = 1;
/*      */     
/*      */     private final Listener responseListener;
/*  425 */     final ReentrantLock lock = new ReentrantLock();
/*  426 */     final Condition responseCondition = this.lock.newCondition();
/*  427 */     final ObjectSpace.InvokeMethodResult[] responseTable = new ObjectSpace.InvokeMethodResult[64];
/*  428 */     final boolean[] pendingResponses = new boolean[64];
/*      */ 
/*      */ 
/*      */     
/*      */     public RemoteInvocationHandler(Connection param1Connection, final int objectID) {
/*  433 */       this.connection = param1Connection;
/*  434 */       this.objectID = objectID;
/*      */       
/*  436 */       this.responseListener = new Listener()
/*      */         {
/*      */           public void received(Connection param2Connection, Object param2Object) {
/*  439 */             if (!(param2Object instanceof ObjectSpace.InvokeMethodResult)) {
/*      */               return;
/*      */             }
/*  442 */             if ((null = (ObjectSpace.InvokeMethodResult)param2Object).objectID != objectID) {
/*      */               return;
/*      */             }
/*  445 */             byte b = null.responseID;
/*  446 */             synchronized (this) {
/*  447 */               if (ObjectSpace.RemoteInvocationHandler.this.pendingResponses[b]) {
/*  448 */                 ObjectSpace.RemoteInvocationHandler.this.responseTable[b] = null;
/*      */               }
/*      */             } 
/*  451 */             ObjectSpace.RemoteInvocationHandler.this.lock.lock();
/*      */             try {
/*  453 */               ObjectSpace.RemoteInvocationHandler.this.responseCondition.signalAll(); return;
/*      */             } finally {
/*  455 */               ObjectSpace.RemoteInvocationHandler.this.lock.unlock();
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void disconnected(Connection param2Connection) {
/*  461 */             ObjectSpace.RemoteInvocationHandler.this.close();
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void connected(Connection param2Connection) {}
/*      */ 
/*      */ 
/*      */           
/*      */           public void idle(Connection param2Connection) {}
/*      */         };
/*  472 */       param1Connection.addListener(this.responseListener);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object<?> param1Object, Method param1Method, Object[] param1ArrayOfObject) {
/*  479 */       if ((param1Object = (Object<?>)param1Method.getDeclaringClass()) == RemoteObject.class) {
/*      */         
/*  481 */         switch (param1Object = (Object<?>)param1Method.getName()) {
/*      */           case "close":
/*  483 */             close();
/*  484 */             return null;
/*      */           case "setResponseTimeout":
/*  486 */             this.timeoutMillis = ((Integer)param1ArrayOfObject[0]).intValue();
/*  487 */             return null;
/*      */           case "setNonBlocking":
/*  489 */             this.nonBlocking = ((Boolean)param1ArrayOfObject[0]).booleanValue();
/*  490 */             return null;
/*      */           case "setTransmitReturnValue":
/*  492 */             this.transmitReturnValue = ((Boolean)param1ArrayOfObject[0]).booleanValue();
/*  493 */             return null;
/*      */           case "setUDP":
/*  495 */             this.udp = ((Boolean)param1ArrayOfObject[0]).booleanValue();
/*  496 */             return null;
/*      */           case "setTransmitExceptions":
/*  498 */             this.transmitExceptions = ((Boolean)param1ArrayOfObject[0]).booleanValue();
/*  499 */             return null;
/*      */           case "setRemoteToString":
/*  501 */             this.remoteToString = ((Boolean)param1ArrayOfObject[0]).booleanValue();
/*  502 */             return null;
/*      */           case "waitForLastResponse":
/*  504 */             if (this.lastResponseID == null) {
/*  505 */               throw new IllegalStateException("There is no last response to wait for.");
/*      */             }
/*  507 */             return waitForResponse(this.lastResponseID.byteValue());
/*      */           case "hasLastResponse":
/*  509 */             if (this.lastResponseID == null) {
/*  510 */               throw new IllegalStateException("There is no last response.");
/*      */             }
/*  512 */             synchronized (this) {
/*  513 */               return Boolean.valueOf((this.responseTable[this.lastResponseID.byteValue()] != null));
/*      */             } 
/*      */           case "getLastResponseID":
/*  516 */             if (this.lastResponseID == null) {
/*  517 */               throw new IllegalStateException("There is no last response ID.");
/*      */             }
/*  519 */             return this.lastResponseID;
/*      */           case "waitForResponse":
/*  521 */             if (!this.transmitReturnValue && !this.transmitExceptions && this.nonBlocking)
/*      */             {
/*  523 */               throw new IllegalStateException("This RemoteObject is currently set to ignore all responses.");
/*      */             }
/*  525 */             return waitForResponse(((Byte)param1ArrayOfObject[0]).byteValue());
/*      */           case "hasResponse":
/*  527 */             synchronized (this) {
/*  528 */               return Boolean.valueOf((this.responseTable[((Byte)param1ArrayOfObject[0]).byteValue()] != null));
/*      */             } 
/*      */           case "getConnection":
/*  531 */             return this.connection;
/*      */         } 
/*      */         
/*  534 */         throw new KryoNetException("Invocation handler could not find RemoteObject method. Check ObjectSpace.java");
/*      */       } 
/*  536 */       if (!this.remoteToString && param1Object == Object.class && param1Method
/*  537 */         .getName().equals("toString")) {
/*  538 */         return "<proxy>";
/*      */       }
/*      */       
/*  541 */       ((ObjectSpace.InvokeMethod)(param1Object = (Object<?>)new ObjectSpace.InvokeMethod())).objectID = this.objectID;
/*  542 */       ((ObjectSpace.InvokeMethod)param1Object).args = param1ArrayOfObject;
/*      */       
/*  544 */       ObjectSpace.CachedMethod[] arrayOfCachedMethod = ObjectSpace.getMethods(this.connection
/*  545 */           .getEndPoint().getKryo(), param1Method
/*  546 */           .getDeclaringClass()); byte b; int i;
/*  547 */       for (b = 0, i = arrayOfCachedMethod.length; b < i; b++) {
/*      */         ObjectSpace.CachedMethod cachedMethod;
/*  549 */         if ((cachedMethod = arrayOfCachedMethod[b]).method.equals(param1Method)) {
/*  550 */           ((ObjectSpace.InvokeMethod)param1Object).cachedMethod = cachedMethod;
/*      */           break;
/*      */         } 
/*      */       } 
/*  554 */       if (((ObjectSpace.InvokeMethod)param1Object).cachedMethod == null) {
/*  555 */         throw new KryoNetException("Method not found: " + param1Method);
/*      */       }
/*      */ 
/*      */       
/*  559 */       b = (!this.udp && (this.transmitReturnValue || this.transmitExceptions || !this.nonBlocking)) ? 1 : 0;
/*      */       
/*  561 */       i = 0;
/*  562 */       if (b != 0) {
/*  563 */         synchronized (this) {
/*      */ 
/*      */           
/*  566 */           i = this.nextResponseId = (byte)(this.nextResponseId + 1);
/*  567 */           if (this.nextResponseId > 63)
/*  568 */             this.nextResponseId = 1; 
/*  569 */           this.pendingResponses[i] = true;
/*      */         } 
/*      */         
/*  572 */         int k = i;
/*  573 */         if (this.transmitReturnValue)
/*  574 */           k = (byte)(k | 0x80); 
/*  575 */         if (this.transmitExceptions)
/*  576 */           k = (byte)(k | 0x40); 
/*  577 */         ((ObjectSpace.InvokeMethod)param1Object).responseData = k;
/*      */       } else {
/*  579 */         ((ObjectSpace.InvokeMethod)param1Object).responseData = 0;
/*      */       } 
/*      */ 
/*      */       
/*  583 */       int j = this.udp ? this.connection.sendUDP(param1Object) : this.connection.sendTCP(param1Object);
/*  584 */       if (Log.DEBUG) {
/*  585 */         String str = "";
/*  586 */         if (param1ArrayOfObject != null)
/*      */         {
/*  588 */           str = (str = Arrays.deepToString(param1ArrayOfObject)).substring(1, str.length() - 1);
/*      */         }
/*  590 */         Log.debug("kryonet", this.connection + " sent " + (this.udp ? "UDP" : "TCP") + ": " + param1Method
/*      */             
/*  592 */             .getDeclaringClass().getSimpleName() + "#" + param1Method
/*  593 */             .getName() + "(" + str + ") (" + j + ")");
/*      */       } 
/*      */ 
/*      */       
/*  597 */       this.lastResponseID = Byte.valueOf((byte)(((ObjectSpace.InvokeMethod)param1Object).responseData & 0x3F));
/*      */       
/*  599 */       if (this.nonBlocking || this.udp) {
/*      */         Class<?> clazz;
/*  601 */         if ((clazz = param1Method.getReturnType()).isPrimitive()) {
/*  602 */           if (clazz == int.class)
/*  603 */             return Integer.valueOf(0); 
/*  604 */           if (clazz == boolean.class)
/*  605 */             return Boolean.FALSE; 
/*  606 */           if (clazz == float.class)
/*  607 */             return Float.valueOf(0.0F); 
/*  608 */           if (clazz == char.class)
/*  609 */             return Character.valueOf(false); 
/*  610 */           if (clazz == long.class)
/*  611 */             return Long.valueOf(0L); 
/*  612 */           if (clazz == short.class)
/*  613 */             return Short.valueOf((short)0); 
/*  614 */           if (clazz == byte.class)
/*  615 */             return Byte.valueOf((byte)0); 
/*  616 */           if (clazz == double.class)
/*  617 */             return Double.valueOf(0.0D); 
/*      */         } 
/*  619 */         return null;
/*      */       } 
/*      */       try {
/*      */         Object object;
/*  623 */         if (object = waitForResponse(this.lastResponseID.byteValue()) instanceof Exception) {
/*  624 */           throw (Exception)object;
/*      */         }
/*  626 */         param1Object = (Object<?>)object; return param1Object;
/*  627 */       } catch (TimeoutException timeoutException) {
/*  628 */         throw new TimeoutException("Response timed out: " + param1Method
/*  629 */             .getDeclaringClass().getName() + "." + param1Method
/*  630 */             .getName());
/*      */       } finally {
/*  632 */         synchronized (this) {
/*  633 */           this.pendingResponses[i] = false;
/*  634 */           this.responseTable[i] = null;
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     private Object waitForResponse(byte param1Byte) {
/*  640 */       if (this.connection.getEndPoint().getUpdateThread() == 
/*  641 */         Thread.currentThread()) {
/*  642 */         throw new IllegalStateException("Cannot wait for a RMI response on the connection's update thread.");
/*      */       }
/*      */       
/*  645 */       long l = System.currentTimeMillis() + this.timeoutMillis;
/*      */       while (true) {
/*      */         ObjectSpace.InvokeMethodResult invokeMethodResult;
/*  648 */         long l1 = l - System.currentTimeMillis();
/*      */         
/*  650 */         synchronized (this) {
/*  651 */           invokeMethodResult = this.responseTable[param1Byte];
/*      */         } 
/*  653 */         if (invokeMethodResult != null) {
/*  654 */           this.lastResponseID = null;
/*  655 */           return invokeMethodResult.result;
/*      */         } 
/*  657 */         if (l1 <= 0L) {
/*  658 */           throw new TimeoutException("Response timed out.");
/*      */         }
/*  660 */         this.lock.lock();
/*      */         try {
/*  662 */           this.responseCondition.await(l1, TimeUnit.MILLISECONDS);
/*      */         }
/*  664 */         catch (InterruptedException interruptedException) {
/*  665 */           Thread.currentThread().interrupt();
/*  666 */           throw new KryoNetException(interruptedException);
/*      */         } finally {
/*  668 */           this.lock.unlock();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     void close() {
/*  675 */       this.connection.removeListener(this.responseListener);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class InvokeMethod
/*      */     implements KryoSerializable, FrameworkMessage
/*      */   {
/*      */     public int objectID;
/*      */ 
/*      */     
/*      */     public ObjectSpace.CachedMethod cachedMethod;
/*      */ 
/*      */     
/*      */     public Object[] args;
/*      */ 
/*      */     
/*      */     public byte responseData;
/*      */ 
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/*  697 */       param1Output.writeInt(this.objectID, true);
/*  698 */       param1Output.writeInt(this.cachedMethod.methodClassID, true);
/*  699 */       param1Output.writeByte(this.cachedMethod.methodIndex);
/*      */       
/*  701 */       Serializer<?>[] arrayOfSerializer = this.cachedMethod.serializers;
/*  702 */       Object[] arrayOfObject = this.args; byte b; int i;
/*  703 */       for (b = 0, i = arrayOfSerializer.length; b < i; b++) {
/*      */         Serializer<?> serializer;
/*  705 */         if ((serializer = arrayOfSerializer[b]) != null) {
/*  706 */           param1Kryo.writeObjectOrNull(param1Output, arrayOfObject[b], serializer);
/*      */         } else {
/*  708 */           param1Kryo.writeClassAndObject(param1Output, arrayOfObject[b]);
/*      */         } 
/*      */       } 
/*  711 */       param1Output.writeByte(this.responseData);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/*  716 */       this.objectID = param1Input.readInt(true);
/*      */       
/*  718 */       int i = param1Input.readInt(true);
/*      */       
/*  720 */       Class clazz = param1Kryo.getRegistration(i).getType();
/*      */       
/*  722 */       byte b = param1Input.readByte();
/*      */       try {
/*  724 */         this.cachedMethod = ObjectSpace.getMethods(param1Kryo, clazz)[b];
/*  725 */       } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  726 */         throw new KryoException("Invalid method index " + b + " for class: " + clazz
/*  727 */             .getName());
/*      */       } 
/*      */       
/*  730 */       Serializer<?>[] arrayOfSerializer = this.cachedMethod.serializers;
/*  731 */       Class[] arrayOfClass = this.cachedMethod.method.getParameterTypes();
/*  732 */       Object[] arrayOfObject = new Object[arrayOfSerializer.length];
/*  733 */       this.args = arrayOfObject; byte b1; int j;
/*  734 */       for (b1 = 0, j = arrayOfObject.length; b1 < j; b1++) {
/*      */         Serializer<?> serializer;
/*  736 */         if ((serializer = arrayOfSerializer[b1]) != null) {
/*  737 */           arrayOfObject[b1] = param1Kryo.readObjectOrNull(param1Input, arrayOfClass[b1], serializer);
/*      */         } else {
/*      */           
/*  740 */           arrayOfObject[b1] = param1Kryo.readClassAndObject(param1Input);
/*      */         } 
/*      */       } 
/*  743 */       this.responseData = param1Input.readByte();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class InvokeMethodResult
/*      */     implements FrameworkMessage
/*      */   {
/*      */     public int objectID;
/*      */     
/*      */     public byte responseID;
/*      */     
/*      */     public Object result;
/*      */   }
/*      */ 
/*      */   
/*      */   static CachedMethod[] getMethods(Kryo paramKryo, Class<?> paramClass) {
/*      */     CachedMethod[] arrayOfCachedMethod2;
/*  761 */     if ((arrayOfCachedMethod2 = methodCache.get(paramClass)) != null) {
/*  762 */       return arrayOfCachedMethod2;
/*      */     }
/*  764 */     ArrayList<? super Method> arrayList = new ArrayList();
/*  765 */     Class<?> clazz = paramClass;
/*      */     do {
/*  767 */       Collections.addAll(arrayList, clazz.getDeclaredMethods());
/*      */     }
/*  769 */     while (clazz != null && (clazz = clazz.getSuperclass()) != Object.class);
/*      */ 
/*      */ 
/*      */     
/*  773 */     ArrayList<Method> arrayList1 = new ArrayList(Math.max(1, arrayList.size())); int i;
/*  774 */     for (byte b1 = 0; b1 < i; b1++) {
/*      */       Method method;
/*      */       int j;
/*  777 */       if (!Modifier.isStatic(j = (method = arrayList.get(b1)).getModifiers()))
/*      */       {
/*  779 */         if (!Modifier.isPrivate(j))
/*      */         {
/*  781 */           if (!method.isSynthetic())
/*      */           {
/*  783 */             arrayList1.add(method); }  } 
/*      */       }
/*      */     } 
/*  786 */     Collections.sort(arrayList1, new Comparator<Method>()
/*      */         {
/*      */           public final int compare(Method param1Method1, Method param1Method2)
/*      */           {
/*      */             int i;
/*  791 */             if ((i = param1Method1.getName().compareTo(param1Method2.getName())) != 0)
/*  792 */               return i; 
/*  793 */             Class[] arrayOfClass1 = param1Method1.getParameterTypes();
/*  794 */             Class[] arrayOfClass2 = param1Method2.getParameterTypes();
/*  795 */             if (arrayOfClass1.length > arrayOfClass2.length)
/*  796 */               return 1; 
/*  797 */             if (arrayOfClass1.length < arrayOfClass2.length) {
/*  798 */               return -1;
/*      */             }
/*  800 */             for (byte b = 0; b < arrayOfClass1.length; b++) {
/*      */ 
/*      */               
/*  803 */               if ((i = arrayOfClass1[b].getName().compareTo(arrayOfClass2[b].getName())) != 0)
/*  804 */                 return i; 
/*      */             } 
/*  806 */             throw new RuntimeException("Two methods with same signature!");
/*      */           }
/*      */         });
/*      */     
/*  810 */     MethodAccess methodAccess = null;
/*  811 */     if (useAsm && !Util.isAndroid && Modifier.isPublic(paramClass.getModifiers())) {
/*  812 */       methodAccess = MethodAccess.get(paramClass);
/*      */     }
/*      */     
/*  815 */     CachedMethod[] arrayOfCachedMethod1 = new CachedMethod[i = arrayList1.size()];
/*  816 */     for (byte b2 = 0; b2 < i; b2++) {
/*      */       Method method;
/*  818 */       Class[] arrayOfClass = (method = arrayList1.get(b2)).getParameterTypes();
/*      */       
/*  820 */       CachedMethod cachedMethod = null;
/*  821 */       if (methodAccess != null) {
/*      */         try {
/*      */           AsmCachedMethod asmCachedMethod;
/*  824 */           (asmCachedMethod = new AsmCachedMethod())
/*  825 */             .methodAccessIndex = methodAccess.getIndex(method.getName(), arrayOfClass);
/*  826 */           asmCachedMethod.methodAccess = methodAccess;
/*  827 */           cachedMethod = asmCachedMethod;
/*  828 */         } catch (RuntimeException runtimeException) {}
/*      */       }
/*      */ 
/*      */       
/*  832 */       if (cachedMethod == null)
/*  833 */         cachedMethod = new CachedMethod(); 
/*  834 */       cachedMethod.method = method;
/*  835 */       cachedMethod
/*  836 */         .methodClassID = paramKryo.getRegistration(method.getDeclaringClass()).getId();
/*  837 */       cachedMethod.methodIndex = b2;
/*      */ 
/*      */       
/*  840 */       cachedMethod.serializers = (Serializer<?>[])new Serializer[arrayOfClass.length]; int j; byte b;
/*  841 */       for (b = 0, j = arrayOfClass.length; b < j; b++) {
/*  842 */         if (paramKryo.isFinal(arrayOfClass[b]))
/*  843 */           cachedMethod.serializers[b] = paramKryo
/*  844 */             .getSerializer(arrayOfClass[b]); 
/*      */       } 
/*  846 */       arrayOfCachedMethod1[b2] = cachedMethod;
/*      */     } 
/*  848 */     methodCache.put(paramClass, arrayOfCachedMethod1);
/*  849 */     return arrayOfCachedMethod1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Object getRegisteredObject(Connection paramConnection, int paramInt) {
/*  857 */     ObjectSpace[] arrayOfObjectSpace = instances; byte b; int i;
/*  858 */     for (b = 0, i = arrayOfObjectSpace.length; b < i; b++) {
/*      */       ObjectSpace objectSpace;
/*      */       
/*  861 */       Connection[] arrayOfConnection = (objectSpace = arrayOfObjectSpace[b]).connections;
/*  862 */       for (byte b1 = 0; b1 < arrayOfConnection.length; b1++) {
/*  863 */         if (arrayOfConnection[b1] == paramConnection) {
/*      */           Object object;
/*      */ 
/*      */           
/*  867 */           if ((object = objectSpace.idToObject.get(paramInt)) != null)
/*  868 */             return object; 
/*      */         } 
/*      */       } 
/*  871 */     }  return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int getRegisteredID(Connection paramConnection, Object paramObject) {
/*  880 */     ObjectSpace[] arrayOfObjectSpace = instances; byte b; int i;
/*  881 */     for (b = 0, i = arrayOfObjectSpace.length; b < i; b++) {
/*      */       ObjectSpace objectSpace;
/*      */       
/*  884 */       Connection[] arrayOfConnection = (objectSpace = arrayOfObjectSpace[b]).connections;
/*  885 */       for (byte b1 = 0; b1 < arrayOfConnection.length; b1++) {
/*  886 */         if (arrayOfConnection[b1] == paramConnection) {
/*      */           int j;
/*      */ 
/*      */           
/*  890 */           if ((j = objectSpace.objectToID.get(paramObject, 2147483647)) != Integer.MAX_VALUE)
/*  891 */             return j; 
/*      */         } 
/*      */       } 
/*  894 */     }  return Integer.MAX_VALUE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerClasses(Kryo paramKryo) {
/*  904 */     paramKryo.register(Object[].class);
/*  905 */     paramKryo.register(InvokeMethod.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     FieldSerializer<InvokeMethodResult> fieldSerializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  925 */     (fieldSerializer = new FieldSerializer<InvokeMethodResult>(paramKryo, InvokeMethodResult.class) { public final void write(Kryo param1Kryo, Output param1Output, ObjectSpace.InvokeMethodResult param1InvokeMethodResult) { super.write(param1Kryo, param1Output, param1InvokeMethodResult); param1Output.writeInt(param1InvokeMethodResult.objectID, true); } public final ObjectSpace.InvokeMethodResult read(Kryo param1Kryo, Input param1Input, Class<? extends ObjectSpace.InvokeMethodResult> param1Class) { ObjectSpace.InvokeMethodResult invokeMethodResult; (invokeMethodResult = (ObjectSpace.InvokeMethodResult)super.read(param1Kryo, param1Input, param1Class)).objectID = param1Input.readInt(true); return invokeMethodResult; } }).removeField("objectID");
/*  926 */     paramKryo.register(InvokeMethodResult.class, (Serializer)fieldSerializer);
/*      */     
/*  928 */     paramKryo.register(InvocationHandler.class, new Serializer()
/*      */         {
/*      */           public final void write(Kryo param1Kryo, Output param1Output, Object param1Object)
/*      */           {
/*  932 */             ObjectSpace.RemoteInvocationHandler remoteInvocationHandler = (ObjectSpace.RemoteInvocationHandler)Proxy.getInvocationHandler(param1Object);
/*  933 */             param1Output.writeInt(remoteInvocationHandler.objectID, true);
/*      */           }
/*      */ 
/*      */           
/*      */           public final Object read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*  938 */             int i = param1Input.readInt(true);
/*      */             
/*      */             Connection connection;
/*  941 */             if ((connection = (Connection)param1Kryo.getContext().get("connection")) == null) {
/*  942 */               throw new KryoException("Connection in kryo context cannot be null", new NullPointerException());
/*      */             }
/*      */             
/*  945 */             Object object = ObjectSpace.getRegisteredObject(connection, i);
/*  946 */             if (Log.WARN && object == null) {
/*  947 */               Log.warn("kryonet", "Unknown object ID " + i + " for connection: " + connection);
/*      */             }
/*  949 */             return object;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setAsm(boolean paramBoolean) {
/*  959 */     useAsm = paramBoolean;
/*      */   }
/*      */   
/*      */   static class CachedMethod
/*      */   {
/*      */     Method method;
/*      */     int methodClassID;
/*      */     int methodIndex;
/*      */     Serializer<?>[] serializers;
/*      */     
/*      */     public Object invoke(Object param1Object, Object[] param1ArrayOfObject) {
/*  970 */       return this.method.invoke(param1Object, param1ArrayOfObject);
/*      */     }
/*      */   }
/*      */   
/*      */   static class AsmCachedMethod extends CachedMethod {
/*      */     MethodAccess methodAccess;
/*  976 */     int methodAccessIndex = -1;
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object param1Object, Object[] param1ArrayOfObject) {
/*      */       try {
/*  982 */         return this.methodAccess.invoke(param1Object, this.methodAccessIndex, param1ArrayOfObject);
/*  983 */       } catch (Exception exception) {
/*  984 */         throw new InvocationTargetException(exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class RemoteObjectSerializer
/*      */     extends Serializer
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Object param1Object) {
/*      */       Connection connection;
/* 1001 */       if ((connection = (Connection)param1Kryo.getContext().get("connection")) == null) {
/* 1002 */         throw new KryoException("Connection in kryo context cannot be null", new NullPointerException());
/*      */       }
/*      */       
/*      */       int i;
/* 1006 */       if ((i = ObjectSpace.getRegisteredID(connection, param1Object)) == Integer.MAX_VALUE) {
/* 1007 */         throw new KryoNetException("Object not found in an ObjectSpace: " + param1Object);
/*      */       }
/* 1009 */       param1Output.writeInt(i, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(Kryo param1Kryo, Input param1Input, Class<?> param1Class) {
/* 1014 */       int i = param1Input.readInt(true);
/*      */       
/*      */       Connection connection;
/* 1017 */       if ((connection = (Connection)param1Kryo.getContext().get("connection")) == null) {
/* 1018 */         throw new KryoException("Connection in kryo context cannot be null", new NullPointerException());
/*      */       }
/*      */       
/* 1021 */       return ObjectSpace.getRemoteObject(connection, i, param1Class);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\rmi\ObjectSpace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */