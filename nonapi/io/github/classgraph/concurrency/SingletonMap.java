/*     */ package nonapi.io.github.classgraph.concurrency;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
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
/*     */ public abstract class SingletonMap<K, V, E extends Exception>
/*     */ {
/*  55 */   private final ConcurrentMap<K, SingletonHolder<V>> map = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract V newInstance(K paramK, LogNode paramLogNode) throws E, InterruptedException;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NullSingletonException
/*     */     extends Exception
/*     */   {
/*     */     static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public <K> NullSingletonException(K param1K) {
/*  73 */       super("newInstance returned null for key " + param1K);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NewInstanceException
/*     */     extends Exception
/*     */   {
/*     */     static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <K> NewInstanceException(K param1K, Throwable param1Throwable) {
/*  93 */       super("newInstance threw an exception for key " + param1K + " : " + param1Throwable, param1Throwable);
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
/*     */   private static class SingletonHolder<V>
/*     */   {
/*     */     private volatile V singleton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     private final CountDownLatch initialized = new CountDownLatch(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void set(V param1V) {
/* 125 */       if (this.initialized.getCount() < 1L)
/*     */       {
/* 127 */         throw new IllegalArgumentException("Singleton already initialized");
/*     */       }
/* 129 */       this.singleton = param1V;
/* 130 */       this.initialized.countDown();
/* 131 */       if (this.initialized.getCount() != 0L)
/*     */       {
/* 133 */         throw new IllegalArgumentException("Singleton initialized more than once");
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
/*     */     V get() {
/* 145 */       this.initialized.await();
/* 146 */       return this.singleton;
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
/*     */     private SingletonHolder() {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(K paramK, LogNode paramLogNode, NewInstanceFactory<V, E> paramNewInstanceFactory) throws E, InterruptedException, NullSingletonException, NewInstanceException {
/* 214 */     SingletonHolder<Object> singletonHolder = (SingletonHolder)this.map.get(paramK);
/*     */     
/* 216 */     V v = null;
/* 217 */     if (singletonHolder != null) {
/*     */       
/* 219 */       v = (V)singletonHolder.get();
/*     */     }
/*     */     else {
/*     */       
/* 223 */       singletonHolder = new SingletonHolder<>();
/*     */       SingletonHolder<Object> singletonHolder1;
/* 225 */       if ((singletonHolder1 = (SingletonHolder)this.map.putIfAbsent(paramK, singletonHolder)) != null) {
/*     */ 
/*     */         
/* 228 */         v = (V)singletonHolder1.get();
/*     */       } else {
/*     */         
/*     */         try {
/* 232 */           if (paramNewInstanceFactory != null) {
/*     */             
/* 234 */             v = paramNewInstanceFactory.newInstance();
/*     */           } else {
/*     */             
/* 237 */             v = newInstance(paramK, paramLogNode);
/*     */           }
/*     */         
/* 240 */         } catch (Throwable throwable) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 245 */           singletonHolder.set((Object)v);
/* 246 */           throw new NewInstanceException(paramK, throwable);
/*     */         } 
/* 248 */         singletonHolder.set((Object)v);
/*     */       } 
/*     */     } 
/* 251 */     if (v == null) {
/* 252 */       throw new NullSingletonException(paramK);
/*     */     }
/* 254 */     return v;
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
/*     */ 
/*     */   
/*     */   public V get(K paramK, LogNode paramLogNode) throws E, InterruptedException, NullSingletonException, NewInstanceException {
/* 286 */     return get(paramK, paramLogNode, null);
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
/*     */   public List<V> values() {
/* 298 */     ArrayList<Map.Entry<?, SingletonHolder<Map.Entry>>> arrayList = new ArrayList(this.map.size());
/* 299 */     for (Iterator<Map.Entry> iterator = this.map.entrySet().iterator(); iterator.hasNext();) {
/*     */       
/* 301 */       if ((entry = ((SingletonHolder<Map.Entry>)(entry = iterator.next()).getValue()).get()) != null) {
/* 302 */         arrayList.add(entry);
/*     */       }
/*     */     } 
/* 305 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 314 */     return this.map.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map.Entry<K, V>> entries() {
/* 325 */     ArrayList<Map.Entry<K, V>> arrayList = new ArrayList(this.map.size());
/* 326 */     for (Map.Entry<K, SingletonHolder<V>> entry : this.map.entrySet()) {
/* 327 */       arrayList.add(new AbstractMap.SimpleEntry<>(entry.getKey(), ((SingletonHolder)entry.getValue()).get()));
/*     */     }
/* 329 */     return arrayList;
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
/*     */   public V remove(K paramK) {
/*     */     SingletonHolder<V> singletonHolder;
/* 344 */     return ((singletonHolder = (SingletonHolder)this.map.remove(paramK)) == null) ? null : singletonHolder.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 349 */     this.map.clear();
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface NewInstanceFactory<V, E extends Exception> {
/*     */     V newInstance() throws E, InterruptedException;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\concurrency\SingletonMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */