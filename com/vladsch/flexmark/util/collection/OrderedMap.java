/*     */ package com.vladsch.flexmark.util.collection;
/*     */ import com.vladsch.flexmark.util.collection.iteration.Indexed;
/*     */ import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.IndexedIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ public class OrderedMap<K, V> implements Iterable<Map.Entry<K, V>>, Map<K, V> {
/*     */   final OrderedSet<K> keySet;
/*     */   private final ArrayList<V> valueList;
/*     */   private final CollectionHost<K> host;
/*     */   
/*     */   public OrderedMap() {
/*  21 */     this(0, null);
/*     */   }
/*     */   boolean inUpdate; private Indexed<Map.Entry<K, V>> indexedEntryProxy; private Indexed<V> indexedValueProxy;
/*     */   public OrderedMap(int paramInt) {
/*  25 */     this(paramInt, null);
/*     */   }
/*     */   
/*     */   public OrderedMap(CollectionHost<K> paramCollectionHost) {
/*  29 */     this(0, paramCollectionHost);
/*     */   }
/*     */   
/*     */   public OrderedMap(int paramInt, CollectionHost<K> paramCollectionHost) {
/*  33 */     this.valueList = new ArrayList<>(paramInt);
/*  34 */     this.host = paramCollectionHost;
/*  35 */     this.indexedEntryProxy = null;
/*  36 */     this.indexedValueProxy = null;
/*  37 */     this.keySet = new OrderedSet<>(paramInt, new CollectionHost<K>()
/*     */         {
/*     */           public void adding(int param1Int, K param1K, Object param1Object) {
/*  40 */             OrderedMap.this.adding(param1Int, param1K, param1Object);
/*     */           }
/*     */ 
/*     */           
/*     */           public Object removing(int param1Int, K param1K) {
/*  45 */             return OrderedMap.this.removing(param1Int, param1K);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clearing() {
/*  50 */             OrderedMap.this.clearing();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void addingNulls(int param1Int) {
/*  56 */             OrderedMap.this.addingNull(param1Int);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean skipHostUpdate() {
/*  61 */             return OrderedMap.this.inUpdate;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getIteratorModificationCount() {
/*  66 */             return OrderedMap.this.getModificationCount();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public Indexed<Map.Entry<K, V>> getIndexedEntryProxy() {
/*  72 */     if (this.indexedEntryProxy != null) return this.indexedEntryProxy; 
/*  73 */     this.indexedEntryProxy = new Indexed<Map.Entry<K, V>>()
/*     */       {
/*     */         public Map.Entry<K, V> get(int param1Int) {
/*  76 */           return OrderedMap.this.getEntry(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int param1Int, Map.Entry<K, V> param1Entry) {
/*  81 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void removeAt(int param1Int) {
/*  86 */           OrderedMap.this.keySet.removeIndexHosted(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/*  91 */           return OrderedMap.this.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public int modificationCount() {
/*  96 */           return OrderedMap.this.getModificationCount();
/*     */         }
/*     */       };
/*     */     
/* 100 */     return this.indexedEntryProxy;
/*     */   }
/*     */   
/*     */   public Indexed<V> getIndexedValueProxy() {
/* 104 */     if (this.indexedValueProxy != null) return this.indexedValueProxy; 
/* 105 */     this.indexedValueProxy = new Indexed<V>()
/*     */       {
/*     */         public V get(int param1Int) {
/* 108 */           return (V)OrderedMap.this.getValue(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int param1Int, V param1V) {
/* 113 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void removeAt(int param1Int) {
/* 118 */           OrderedMap.this.keySet.removeIndexHosted(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 123 */           return OrderedMap.this.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public int modificationCount() {
/* 128 */           return OrderedMap.this.getModificationCount();
/*     */         }
/*     */       };
/*     */     
/* 132 */     return this.indexedValueProxy;
/*     */   }
/*     */   
/*     */   Map.Entry<K, V> getEntry(int paramInt) {
/* 136 */     return new MapEntry<>(this.keySet.getValue(paramInt), this.valueList.get(paramInt));
/*     */   }
/*     */   
/*     */   public int getModificationCount() {
/* 140 */     return this.keySet.getModificationCount();
/*     */   }
/*     */   
/*     */   void adding(int paramInt, K paramK, Object paramObject) {
/* 144 */     if (paramObject == null) throw new IllegalArgumentException(); 
/* 145 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 146 */       this.host.adding(paramInt, paramK, paramObject);
/*     */     }
/*     */     
/* 149 */     this.valueList.add((V)paramObject);
/*     */   }
/*     */   
/*     */   void addingNull(int paramInt) {
/* 153 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 154 */       this.host.addingNulls(paramInt);
/*     */     }
/* 156 */     addNulls(paramInt);
/*     */   }
/*     */   
/*     */   Object removing(int paramInt, K paramK) {
/* 160 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 161 */       this.host.removing(paramInt, paramK);
/*     */     }
/* 163 */     return this.valueList.get(paramInt);
/*     */   }
/*     */   
/*     */   void clearing() {
/* 167 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 168 */       this.host.clearing();
/*     */     }
/* 170 */     this.valueList.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 175 */     return this.keySet.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 180 */     return this.keySet.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 186 */     return this.keySet.contains(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 192 */     int i = this.valueList.indexOf(paramObject);
/* 193 */     return this.keySet.isValidIndex(i);
/*     */   }
/*     */   
/*     */   public void addNull() {
/* 197 */     addNulls(this.valueList.size());
/*     */   }
/*     */   
/*     */   public void addNulls(int paramInt) {
/* 201 */     if (paramInt < this.valueList.size())
/* 202 */       throw new IllegalArgumentException("addNulls(" + paramInt + ") called when valueList size is " + this.valueList.size()); 
/* 203 */     for (; this.valueList.size() <= paramInt; this.valueList.add(null));
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/*     */     int i;
/* 209 */     return ((i = this.keySet.indexOf(paramObject)) == -1) ? null : this.valueList.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*     */     int i;
/* 215 */     if ((i = this.keySet.indexOf(paramK)) == -1) {
/* 216 */       this.keySet.add(paramK, paramV);
/* 217 */       return null;
/*     */     } 
/*     */     
/* 220 */     paramK = (K)this.valueList.get(i);
/* 221 */     this.valueList.set(i, paramV);
/* 222 */     return (V)paramK;
/*     */   }
/*     */   
/*     */   public V computeIfMissing(K paramK, Function<? super K, ? extends V> paramFunction) {
/*     */     int i;
/* 227 */     if ((i = this.keySet.indexOf(paramK)) == -1) {
/* 228 */       paramFunction = (Function<? super K, ? extends V>)paramFunction.apply(paramK);
/* 229 */       this.keySet.add(paramK, paramFunction);
/* 230 */       return (V)paramFunction;
/*     */     } 
/*     */     
/* 233 */     return this.valueList.get(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 239 */     return (V)this.keySet.removeHosted(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 244 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 245 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public void addAll(Collection<? extends Map.Entry<? extends K, ? extends V>> paramCollection) {
/* 250 */     for (Map.Entry<? extends K, ? extends V> entry : paramCollection) {
/* 251 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 257 */     this.keySet.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedSet<K> keySet() {
/* 263 */     return this.keySet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 269 */     if (!this.keySet.isSparse()) {
/* 270 */       return this.valueList;
/*     */     }
/*     */     
/* 273 */     ArrayList<V> arrayList = new ArrayList(this.keySet.size());
/* 274 */     ReversibleIterator<Integer> reversibleIterator = this.keySet.indexIterator();
/* 275 */     while (reversibleIterator.hasNext()) {
/* 276 */       arrayList.add(this.valueList.get(((Integer)reversibleIterator.next()).intValue()));
/*     */     }
/* 278 */     return arrayList;
/*     */   }
/*     */   
/*     */   public K getKey(int paramInt) {
/* 282 */     if (!this.keySet.isValidIndex(paramInt)) return null; 
/* 283 */     return this.keySet.getValueList().get(paramInt);
/*     */   }
/*     */   
/*     */   public V getValue(int paramInt) {
/* 287 */     if (!this.keySet.isValidIndex(paramInt)) return null; 
/* 288 */     return this.valueList.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedSet<Map.Entry<K, V>> entrySet() {
/* 295 */     this.inUpdate = true;
/* 296 */     OrderedSet<Map.Entry<K, V>> orderedSet = new OrderedSet(this.keySet.size(), new EntryCollectionHost<>());
/* 297 */     ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIterator = entryIterator();
/* 298 */     while (reversibleIndexedIterator.hasNext()) {
/* 299 */       orderedSet.add(reversibleIndexedIterator.next());
/*     */     }
/*     */ 
/*     */     
/* 303 */     this.inUpdate = false;
/*     */     
/* 305 */     return orderedSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Map.Entry<K, V>> entries() {
/* 310 */     ArrayList<Map.Entry<K, V>> arrayList = new ArrayList();
/* 311 */     ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIterator = entryIterator();
/* 312 */     while (reversibleIndexedIterator.hasNext()) {
/* 313 */       arrayList.add(reversibleIndexedIterator.next());
/*     */     }
/* 315 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<K> keys() {
/* 320 */     return this.keySet.values();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<V> valueIterator() {
/* 324 */     return (ReversibleIndexedIterator<V>)new IndexedIterator(getIndexedValueProxy(), this.keySet.indexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<V> reversedValueIterator() {
/* 328 */     return (ReversibleIndexedIterator<V>)new IndexedIterator(getIndexedValueProxy(), this.keySet.reversedIndexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<K> keyIterator() {
/* 332 */     return this.keySet.iterator();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<K> reversedKeyIterator() {
/* 336 */     return this.keySet.reversedIterator();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> entryIterator() {
/* 340 */     return (ReversibleIndexedIterator<Map.Entry<K, V>>)new IndexedIterator(getIndexedEntryProxy(), this.keySet.indexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> reversedEntryIterator() {
/* 344 */     return (ReversibleIndexedIterator<Map.Entry<K, V>>)new IndexedIterator(getIndexedEntryProxy(), this.keySet.reversedIndexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> reversedIterator() {
/* 348 */     return reversedEntryIterator();
/*     */   }
/*     */   
/*     */   public ReversibleIterable<V> valueIterable() {
/* 352 */     return (ReversibleIterable<V>)new IndexedIterable(getIndexedValueProxy(), this.keySet.indexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<V> reversedValueIterable() {
/* 356 */     return (ReversibleIterable<V>)new IndexedIterable(getIndexedValueProxy(), this.keySet.reversedIndexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<K> keyIterable() {
/* 360 */     return this.keySet.iterable();
/*     */   }
/*     */   
/*     */   public ReversibleIterable<K> reversedKeyIterable() {
/* 364 */     return this.keySet.reversedIterable();
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Map.Entry<K, V>> entryIterable() {
/* 368 */     return (ReversibleIterable<Map.Entry<K, V>>)new IndexedIterable(getIndexedEntryProxy(), this.keySet.indexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Map.Entry<K, V>> reversedEntryIterable() {
/* 372 */     return (ReversibleIterable<Map.Entry<K, V>>)new IndexedIterable(getIndexedEntryProxy(), this.keySet.reversedIndexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Map.Entry<K, V>> reversedIterable() {
/* 376 */     return reversedEntryIterable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> iterator() {
/* 386 */     return entryIterator();
/*     */   }
/*     */   
/*     */   public void forEach(Consumer<? super Map.Entry<K, V>> paramConsumer) {
/* 390 */     ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIterator = iterator();
/* 391 */     while (reversibleIndexedIterator.hasNext()) {
/* 392 */       paramConsumer.accept(reversibleIndexedIterator.next());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 398 */     if (this == paramObject) return true; 
/* 399 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 401 */     paramObject = paramObject;
/*     */     
/* 403 */     if (size() != paramObject.size()) return false; 
/* 404 */     return entrySet().equals(paramObject.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 409 */     int i = this.keySet.hashCode();
/*     */     
/* 411 */     return i = i * 31 + this.valueList.hashCode();
/*     */   }
/*     */   
/*     */   private class EntryCollectionHost<KK extends K, VV extends V> implements CollectionHost<Map.Entry<KK, VV>> { private EntryCollectionHost() {}
/*     */     
/*     */     public void adding(int param1Int, Map.Entry<KK, VV> param1Entry, Object param1Object) {
/* 417 */       assert param1Object == null;
/* 418 */       OrderedMap.this.keySet.add(param1Entry.getKey(), param1Entry.getValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Object removing(int param1Int, Map.Entry<KK, VV> param1Entry) {
/* 423 */       OrderedMap.this.keySet.removeIndex(param1Int);
/* 424 */       return param1Entry;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clearing() {
/* 429 */       OrderedMap.this.keySet.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public void addingNulls(int param1Int) {
/* 434 */       OrderedMap.this.keySet.addNulls(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean skipHostUpdate() {
/* 439 */       return OrderedMap.this.inUpdate;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIteratorModificationCount() {
/* 444 */       return OrderedMap.this.getModificationCount();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\OrderedMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */