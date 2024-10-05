/*     */ package com.esotericsoftware.kryonet;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.BiConsumer;
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
/*     */ public interface Listener
/*     */ {
/*     */   default void connected(Connection paramConnection) {}
/*     */   
/*     */   default void disconnected(Connection paramConnection) {}
/*     */   
/*     */   default void received(Connection paramConnection, Object paramObject) {}
/*     */   
/*     */   default void idle(Connection paramConnection) {}
/*     */   
/*     */   public static abstract class ConnectionListener
/*     */     implements Listener
/*     */   {
/*     */     public abstract void disconnected(Connection param1Connection);
/*     */     
/*     */     public abstract void connected(Connection param1Connection);
/*     */     
/*     */     public void received(Connection param1Connection, Object param1Object) {}
/*     */     
/*     */     public void idle(Connection param1Connection) {}
/*     */   }
/*     */   
/*     */   public static class TypeListener
/*     */     implements Listener
/*     */   {
/* 107 */     private final HashMap<Class<?>, BiConsumer> listeners = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void received(Connection param1Connection, Object param1Object) {
/* 116 */       if (this.listeners.containsKey(param1Object.getClass())) {
/* 117 */         ((BiConsumer<Connection, Object>)this.listeners.get(param1Object.getClass())).accept(param1Connection, param1Object);
/*     */       }
/*     */     }
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
/*     */     public <T> void addTypeHandler(Class<T> param1Class, BiConsumer<? super Connection, ? super T> param1BiConsumer) {
/* 131 */       this.listeners.put(param1Class, param1BiConsumer);
/*     */     }
/*     */     
/*     */     public <T> void removeTypeHandler(Class<T> param1Class) {
/* 135 */       this.listeners.remove(param1Class);
/*     */     }
/*     */     
/*     */     public int size() {
/* 139 */       return this.listeners.size();
/*     */     }
/*     */     
/*     */     public void clear() {
/* 143 */       this.listeners.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class QueuedListener
/*     */     implements Listener
/*     */   {
/*     */     final Listener listener;
/*     */ 
/*     */ 
/*     */     
/*     */     public QueuedListener(Listener param1Listener) {
/* 157 */       if (param1Listener == null)
/* 158 */         throw new NullPointerException("listener cannot be null."); 
/* 159 */       this.listener = param1Listener;
/*     */     }
/*     */ 
/*     */     
/*     */     public void connected(final Connection connection) {
/* 164 */       queue(new Runnable()
/*     */           {
/*     */             public void run() {
/* 167 */               Listener.QueuedListener.this.listener.connected(connection);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public void disconnected(final Connection connection) {
/* 174 */       queue(new Runnable()
/*     */           {
/*     */             public void run() {
/* 177 */               Listener.QueuedListener.this.listener.disconnected(connection);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public void received(final Connection connection, final Object object) {
/* 184 */       queue(new Runnable()
/*     */           {
/*     */             public void run() {
/* 187 */               Listener.QueuedListener.this.listener.received(connection, object);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public void idle(final Connection connection) {
/* 194 */       queue(new Runnable()
/*     */           {
/*     */             public void run() {
/* 197 */               Listener.QueuedListener.this.listener.idle(connection);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void queue(Runnable param1Runnable);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ThreadedListener
/*     */     extends QueuedListener
/*     */   {
/*     */     protected final ExecutorService threadPool;
/*     */ 
/*     */     
/*     */     public ThreadedListener(Listener param1Listener) {
/* 215 */       this(param1Listener, Executors.newFixedThreadPool(1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ThreadedListener(Listener param1Listener, ExecutorService param1ExecutorService) {
/* 223 */       super(param1Listener);
/* 224 */       if (param1ExecutorService == null)
/* 225 */         throw new NullPointerException("threadPool cannot be null."); 
/* 226 */       this.threadPool = param1ExecutorService;
/*     */     }
/*     */ 
/*     */     
/*     */     public void queue(Runnable param1Runnable) {
/* 231 */       this.threadPool.execute(param1Runnable);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class LagListener
/*     */     extends QueuedListener
/*     */   {
/*     */     private final ScheduledExecutorService threadPool;
/*     */     
/*     */     private final int lagMillisMin;
/*     */     
/*     */     private final int lagMillisMax;
/* 244 */     final LinkedList<Runnable> runnables = new LinkedList<>();
/*     */ 
/*     */     
/*     */     public LagListener(int param1Int1, int param1Int2, Listener param1Listener) {
/* 248 */       super(param1Listener);
/* 249 */       this.lagMillisMin = param1Int1;
/* 250 */       this.lagMillisMax = param1Int2;
/* 251 */       this.threadPool = Executors.newScheduledThreadPool(1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void queue(Runnable param1Runnable) {
/* 256 */       synchronized (this.runnables) {
/* 257 */         this.runnables.addFirst(param1Runnable);
/*     */       } 
/*     */       
/* 260 */       int i = this.lagMillisMin + (int)(Math.random() * (this.lagMillisMax - this.lagMillisMin));
/* 261 */       this.threadPool.schedule(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 265 */               synchronized (Listener.LagListener.this.runnables) {
/* 266 */                 Runnable runnable = Listener.LagListener.this.runnables.removeLast();
/*     */               } 
/* 268 */               SYNTHETIC_LOCAL_VARIABLE_1.run();
/*     */             }
/*     */           },  i, TimeUnit.MILLISECONDS);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\Listener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */