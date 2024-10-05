/*     */ package com.vladsch.flexmark.util.collection;
/*     */ import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.BitSetIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.Indexed;
/*     */ import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Paired;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class OrderedMultiMap<K, V> implements Iterable<Map.Entry<K, V>>, Map<K, V> {
/*     */   private final OrderedSet<K> keySet;
/*     */   private final OrderedSet<V> valueSet;
/*     */   private final CollectionHost<Paired<K, V>> host;
/*     */   
/*     */   public OrderedMultiMap() {
/*  21 */     this(0, null);
/*     */   }
/*     */   boolean isInKeyUpdate; boolean isInValueUpdate; private Indexed<Map.Entry<K, V>> indexedProxy;
/*     */   public OrderedMultiMap(int paramInt) {
/*  25 */     this(paramInt, null);
/*     */   }
/*     */   
/*     */   public OrderedMultiMap(CollectionHost<Paired<K, V>> paramCollectionHost) {
/*  29 */     this(0, paramCollectionHost);
/*     */   }
/*     */   
/*     */   public OrderedMultiMap(int paramInt, CollectionHost<Paired<K, V>> paramCollectionHost) {
/*  33 */     this.host = paramCollectionHost;
/*  34 */     this.indexedProxy = null;
/*  35 */     this.valueSet = new OrderedSet<>(paramInt, new CollectionHost<V>()
/*     */         {
/*     */           public void adding(int param1Int, V param1V, Object param1Object) {
/*  38 */             OrderedMultiMap.this.addingValue(param1Int, param1V, param1Object);
/*     */           }
/*     */ 
/*     */           
/*     */           public Object removing(int param1Int, V param1V) {
/*  43 */             return OrderedMultiMap.this.removingValue(param1Int, param1V);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clearing() {
/*  48 */             OrderedMultiMap.this.clear();
/*     */           }
/*     */ 
/*     */           
/*     */           public void addingNulls(int param1Int) {
/*  53 */             OrderedMultiMap.this.addingNullValue(param1Int);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean skipHostUpdate() {
/*  58 */             return OrderedMultiMap.this.isInKeyUpdate;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getIteratorModificationCount() {
/*  63 */             return OrderedMultiMap.this.getModificationCount();
/*     */           }
/*     */         });
/*     */     
/*  67 */     this.keySet = new OrderedSet<>(paramInt, new CollectionHost<K>()
/*     */         {
/*     */           public void adding(int param1Int, K param1K, Object param1Object) {
/*  70 */             OrderedMultiMap.this.addingKey(param1Int, param1K, param1Object);
/*     */           }
/*     */ 
/*     */           
/*     */           public Object removing(int param1Int, K param1K) {
/*  75 */             return OrderedMultiMap.this.removingKey(param1Int, param1K);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clearing() {
/*  80 */             OrderedMultiMap.this.clear();
/*     */           }
/*     */ 
/*     */           
/*     */           public void addingNulls(int param1Int) {
/*  85 */             OrderedMultiMap.this.addingNullKey(param1Int);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean skipHostUpdate() {
/*  90 */             return OrderedMultiMap.this.isInValueUpdate;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getIteratorModificationCount() {
/*  95 */             return OrderedMultiMap.this.getModificationCount();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public Indexed<Map.Entry<K, V>> getIndexedProxy() {
/* 101 */     if (this.indexedProxy != null) return this.indexedProxy; 
/* 102 */     this.indexedProxy = new Indexed<Map.Entry<K, V>>()
/*     */       {
/*     */         public Map.Entry<K, V> get(int param1Int) {
/* 105 */           return OrderedMultiMap.this.getEntry(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int param1Int, Map.Entry<K, V> param1Entry) {
/* 110 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void removeAt(int param1Int) {
/* 115 */           OrderedMultiMap.this.removeEntryIndex(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 120 */           return OrderedMultiMap.this.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public int modificationCount() {
/* 125 */           return OrderedMultiMap.this.getModificationCount();
/*     */         }
/*     */       };
/*     */     
/* 129 */     return this.indexedProxy;
/*     */   }
/*     */   
/*     */   Map.Entry<K, V> getEntry(int paramInt) {
/* 133 */     return new MapEntry<>(this.keySet.getValueOrNull(paramInt), this.valueSet.getValueOrNull(paramInt));
/*     */   }
/*     */   
/*     */   public int getModificationCount() {
/* 137 */     return (int)(this.keySet.getModificationCount() + this.valueSet.getModificationCount());
/*     */   }
/*     */ 
/*     */   
/*     */   void addingKey(int paramInt, K paramK, Object paramObject) {
/* 142 */     assert !this.isInValueUpdate;
/*     */     
/* 144 */     this.isInValueUpdate = true;
/* 145 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 146 */       this.host.adding(paramInt, new Pair(paramK, paramObject), null);
/*     */     }
/* 148 */     if (paramObject == null) { this.valueSet.addNulls(paramInt); }
/* 149 */     else { this.valueSet.add((V)paramObject); }
/* 150 */      this.isInValueUpdate = false;
/*     */   }
/*     */   
/*     */   void addingNullKey(int paramInt) {
/* 154 */     assert !this.isInValueUpdate;
/*     */     
/* 156 */     this.isInValueUpdate = true;
/* 157 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 158 */       this.host.addingNulls(paramInt);
/*     */     }
/* 160 */     for (; valueSet().size() <= paramInt; this.valueSet.add(null));
/* 161 */     this.isInValueUpdate = false;
/*     */   }
/*     */   
/*     */   Object removingKey(int paramInt, K paramK) {
/* 165 */     assert !this.isInValueUpdate;
/*     */     
/* 167 */     this.isInValueUpdate = true;
/* 168 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 169 */       this.host.removing(paramInt, new Pair(paramK, null));
/*     */     }
/* 171 */     Object object = this.valueSet.removeIndexHosted(paramInt);
/* 172 */     this.isInValueUpdate = false;
/* 173 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   void addingValue(int paramInt, V paramV, Object paramObject) {
/* 178 */     assert !this.isInKeyUpdate;
/*     */     
/* 180 */     this.isInKeyUpdate = true;
/* 181 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 182 */       this.host.adding(paramInt, new Pair(paramObject, paramV), null);
/*     */     }
/* 184 */     if (paramObject == null) { this.keySet.addNulls(paramInt); }
/* 185 */     else { this.keySet.add((K)paramObject); }
/* 186 */      this.isInKeyUpdate = false;
/*     */   }
/*     */   
/*     */   void addingNullValue(int paramInt) {
/* 190 */     assert !this.isInKeyUpdate;
/*     */     
/* 192 */     this.isInKeyUpdate = true;
/* 193 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 194 */       this.host.addingNulls(paramInt);
/*     */     }
/* 196 */     for (; this.keySet.size() <= paramInt; this.keySet.add(null));
/* 197 */     this.isInKeyUpdate = false;
/*     */   }
/*     */   
/*     */   Object removingValue(int paramInt, V paramV) {
/* 201 */     assert !this.isInKeyUpdate;
/*     */     
/* 203 */     this.isInKeyUpdate = true;
/* 204 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 205 */       this.host.removing(paramInt, new Pair(null, paramV));
/*     */     }
/* 207 */     Object object = this.keySet.removeIndexHosted(paramInt);
/* 208 */     this.isInKeyUpdate = false;
/* 209 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 214 */     return this.keySet.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 219 */     return this.keySet.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 224 */     return this.keySet.contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 229 */     int i = this.valueSet.indexOf(paramObject);
/* 230 */     return this.keySet.isValidIndex(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 235 */     return getKeyValue(paramObject);
/*     */   }
/*     */   
/*     */   public V getKeyValue(Object paramObject) {
/*     */     int i;
/* 240 */     return ((i = this.keySet.indexOf(paramObject)) == -1) ? null : this.valueSet.getValue(i);
/*     */   }
/*     */   
/*     */   public K getValueKey(Object paramObject) {
/*     */     int i;
/* 245 */     return ((i = this.valueSet.indexOf(paramObject)) == -1) ? null : this.keySet.getValue(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 250 */     return putKeyValue(paramK, paramV);
/*     */   }
/*     */   
/*     */   public void addNullEntry(int paramInt) {
/* 254 */     this.isInKeyUpdate = true;
/* 255 */     this.isInValueUpdate = true;
/*     */     
/* 257 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 258 */       this.host.addingNulls(paramInt);
/*     */     }
/* 260 */     this.keySet.addNulls(paramInt);
/* 261 */     this.valueSet.addNulls(paramInt);
/*     */     
/* 263 */     this.isInValueUpdate = false;
/* 264 */     this.isInKeyUpdate = false;
/*     */   }
/*     */   
/*     */   public boolean putEntry(Map.Entry<K, V> paramEntry) {
/* 268 */     return addKeyValue(paramEntry.getKey(), paramEntry.getValue());
/*     */   }
/*     */   
/*     */   public boolean putKeyValueEntry(Map.Entry<K, V> paramEntry) {
/* 272 */     return addKeyValue(paramEntry.getKey(), paramEntry.getValue());
/*     */   }
/*     */   
/*     */   public boolean putValueKeyEntry(Map.Entry<V, K> paramEntry) {
/* 276 */     return addKeyValue(paramEntry.getValue(), paramEntry.getKey());
/*     */   }
/*     */   
/*     */   public boolean putKeyValuePair(Paired<K, V> paramPaired) {
/* 280 */     return addKeyValue((K)paramPaired.getFirst(), (V)paramPaired.getSecond());
/*     */   }
/*     */   
/*     */   public boolean putValueKeyPair(Paired<V, K> paramPaired) {
/* 284 */     return addKeyValue((K)paramPaired.getSecond(), (V)paramPaired.getFirst());
/*     */   }
/*     */   
/*     */   public V putKeyValue(K paramK, V paramV) {
/* 288 */     return !addKeyValue(paramK, paramV) ? paramV : null;
/*     */   }
/*     */   
/*     */   public K putValueKey(V paramV, K paramK) {
/* 292 */     return !addKeyValue(paramK, paramV) ? paramK : null;
/*     */   }
/*     */   
/*     */   private boolean addKeyValue(K paramK, V paramV) {
/* 296 */     int i = this.keySet.indexOf(paramK);
/* 297 */     int j = this.valueSet.indexOf(paramV);
/*     */     
/* 299 */     if (i == -1 && j == -1) {
/*     */       
/* 301 */       this.isInKeyUpdate = true;
/* 302 */       this.isInValueUpdate = true;
/* 303 */       if (this.host != null && !this.host.skipHostUpdate()) {
/* 304 */         this.host.adding(this.keySet.getValueList().size(), new Pair(paramK, paramV), null);
/*     */       }
/*     */       
/* 307 */       if (paramK == null) { this.keySet.addNull(); }
/* 308 */       else { this.keySet.add(paramK, paramV); }
/*     */       
/* 310 */       if (paramK == null) { this.valueSet.addNull(); }
/* 311 */       else { this.valueSet.add(paramV, paramK); }
/*     */       
/* 313 */       this.isInValueUpdate = false;
/* 314 */       this.isInKeyUpdate = false;
/*     */       
/* 316 */       return true;
/*     */     } 
/*     */     
/* 319 */     if (i == -1) {
/* 320 */       this.isInKeyUpdate = true;
/* 321 */       this.isInValueUpdate = true;
/* 322 */       if (this.host != null && !this.host.skipHostUpdate()) {
/* 323 */         this.host.adding(j, new Pair(paramK, paramV), null);
/*     */       }
/*     */       
/* 326 */       if (paramK == null) { this.keySet.removeIndex(j); }
/* 327 */       else { this.keySet.setValueAt(j, paramK, paramV); }
/*     */       
/* 329 */       this.isInValueUpdate = false;
/* 330 */       this.isInKeyUpdate = false;
/* 331 */       return true;
/*     */     } 
/*     */     
/* 334 */     if (j == -1) {
/* 335 */       this.isInKeyUpdate = true;
/* 336 */       this.isInValueUpdate = true;
/* 337 */       if (this.host != null && !this.host.skipHostUpdate()) {
/* 338 */         this.host.adding(i, new Pair(paramK, paramV), null);
/*     */       }
/*     */       
/* 341 */       if (paramK == null) { this.valueSet.removeIndex(j); }
/* 342 */       else { this.valueSet.setValueAt(i, paramV, paramK); }
/*     */       
/* 344 */       this.isInValueUpdate = false;
/* 345 */       return true;
/*     */     } 
/*     */     
/* 348 */     if (j != i) {
/* 349 */       throw new IllegalStateException("keySet[" + i + "]=" + paramK + " and valueSet[" + j + "]=" + paramV + " are out of sync");
/*     */     }
/*     */     
/* 352 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 357 */     return removeKey(paramObject);
/*     */   }
/*     */   
/*     */   public Map.Entry<K, V> removeEntry(Map.Entry<K, V> paramEntry) {
/*     */     boolean bool;
/* 362 */     return (bool = removeEntryIndex(-1, paramEntry.getKey(), paramEntry.getValue())) ? paramEntry : null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean removeEntryIndex(int paramInt) {
/* 367 */     return removeEntryIndex(paramInt, this.keySet.getValueOrNull(paramInt), this.valueSet.getValueOrNull(paramInt));
/*     */   }
/*     */   
/*     */   private boolean removeEntryIndex(int paramInt, K paramK, V paramV) {
/* 371 */     int i = this.keySet.indexOf(paramK);
/* 372 */     int j = this.valueSet.indexOf(paramV);
/*     */     
/* 374 */     if (i != j) {
/* 375 */       throw new IllegalStateException("keySet[" + i + "]=" + paramK + " and valueSet[" + j + "]=" + paramV + " are out of sync");
/*     */     }
/*     */     
/* 378 */     if (paramInt != -1 && i != paramInt) {
/* 379 */       throw new IllegalStateException("removeEntryIndex " + paramInt + " does not match keySet[" + i + "]=" + paramK + " and valueSet[" + j + "]=" + paramV + " are out of sync");
/*     */     }
/*     */     
/* 382 */     if (i != -1) {
/* 383 */       this.isInKeyUpdate = true;
/* 384 */       this.isInValueUpdate = true;
/* 385 */       if (this.host != null && !this.host.skipHostUpdate()) {
/* 386 */         this.host.removing(i, new Pair(paramK, paramV));
/*     */       }
/* 388 */       this.keySet.removeHosted(paramK);
/* 389 */       this.valueSet.removeHosted(paramV);
/* 390 */       this.isInValueUpdate = false;
/* 391 */       this.isInKeyUpdate = false;
/* 392 */       return true;
/*     */     } 
/* 394 */     return false;
/*     */   }
/*     */   
/*     */   public V removeKey(Object paramObject) {
/* 398 */     this.isInKeyUpdate = true; int i;
/* 399 */     if (this.host != null && !this.host.skipHostUpdate() && (
/*     */       
/* 401 */       i = this.keySet.indexOf(paramObject)) != -1) {
/* 402 */       this.host.removing(i, new Pair(paramObject, this.valueSet.isValidIndex(i) ? this.valueSet.getValue(i) : null));
/*     */     }
/*     */     
/* 405 */     Object object = this.keySet.removeHosted(paramObject);
/* 406 */     this.isInKeyUpdate = false;
/* 407 */     return (V)object;
/*     */   }
/*     */   
/*     */   public K removeValue(Object paramObject) {
/* 411 */     this.isInValueUpdate = true;
/* 412 */     int i = this.valueSet.indexOf(paramObject);
/* 413 */     if (this.host != null && !this.host.skipHostUpdate() && 
/* 414 */       i != -1) {
/* 415 */       this.host.removing(i, new Pair(this.keySet.isValidIndex(i) ? this.keySet.getValue(i) : null, paramObject));
/*     */     }
/*     */     
/* 418 */     paramObject = this.valueSet.removeHosted(paramObject);
/* 419 */     this.isInValueUpdate = false;
/* 420 */     return (K)paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 425 */     putAllKeyValues(paramMap);
/*     */   }
/*     */   
/*     */   public void putAllKeyValues(Map<? extends K, ? extends V> paramMap) {
/* 429 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 430 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public void putAllValueKeys(Map<? extends V, ? extends K> paramMap) {
/* 435 */     for (Map.Entry<? extends V, ? extends K> entry : paramMap.entrySet()) {
/* 436 */       putValueKey((V)entry.getKey(), (K)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 442 */     this.isInValueUpdate = true;
/* 443 */     this.isInKeyUpdate = true;
/*     */     
/* 445 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 446 */       this.host.clearing();
/*     */     }
/* 448 */     this.keySet.clear();
/* 449 */     this.valueSet.clear();
/*     */     
/* 451 */     this.isInKeyUpdate = false;
/* 452 */     this.isInValueUpdate = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedSet<K> keySet() {
/* 458 */     return this.keySet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 464 */     if (!this.keySet.isSparse()) {
/* 465 */       return this.valueSet;
/*     */     }
/*     */     
/*     */     ArrayList<V> arrayList;
/* 469 */     (arrayList = new ArrayList<>(this.keySet.size())).addAll(this.valueSet);
/* 470 */     return arrayList;
/*     */   }
/*     */   
/*     */   public OrderedSet<V> valueSet() {
/* 474 */     return this.valueSet;
/*     */   }
/*     */   
/*     */   public Collection<K> keys() {
/* 478 */     if (!this.keySet.isSparse()) {
/* 479 */       return this.keySet;
/*     */     }
/*     */     
/*     */     ArrayList<K> arrayList;
/* 483 */     (arrayList = new ArrayList<>(this.valueSet.size())).addAll(this.keySet);
/* 484 */     return arrayList;
/*     */   }
/*     */   
/*     */   public K getKey(int paramInt) {
/* 488 */     if (!this.keySet.isValidIndex(paramInt)) return null; 
/* 489 */     return this.keySet.getValueList().get(paramInt);
/*     */   }
/*     */   
/*     */   public V getValue(int paramInt) {
/* 493 */     if (!this.valueSet.isValidIndex(paramInt)) return null; 
/* 494 */     return this.valueSet.getValue(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedSet<Map.Entry<K, V>> entrySet() {
/* 500 */     return keyValueEntrySet();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<V> valueIterator() {
/* 504 */     return this.valueSet.iterator();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<V> reversedValueIterator() {
/* 508 */     return this.valueSet.reversedIterator();
/*     */   }
/*     */   
/*     */   public ReversibleIterable<V> valueIterable() {
/* 512 */     return (ReversibleIterable<V>)new IndexedIterable(this.valueSet.getIndexedProxy(), this.valueSet.indexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<V> reversedValueIterable() {
/* 516 */     return (ReversibleIterable<V>)new IndexedIterable(this.valueSet.getIndexedProxy(), this.valueSet.reversedIndexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<K> keyIterator() {
/* 520 */     return keySet().iterator();
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<K> reversedKeyIterator() {
/* 524 */     return keySet().reversedIterator();
/*     */   }
/*     */   
/*     */   public ReversibleIterable<K> keyIterable() {
/* 528 */     return (ReversibleIterable<K>)new IndexedIterable(this.keySet.getIndexedProxy(), this.keySet.indexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<K> reversedKeyIterable() {
/* 532 */     return (ReversibleIterable<K>)new IndexedIterable(this.keySet.getIndexedProxy(), this.keySet.reversedIndexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> entrySetIterator() {
/* 536 */     BitSet bitSet = getKeyValueUnionSet();
/* 537 */     return (ReversibleIndexedIterator<Map.Entry<K, V>>)new IndexedIterator(getIndexedProxy(), (ReversibleIterator)new BitSetIterator(bitSet));
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<Map.Entry<K, V>> reversedEntrySetIterator() {
/* 541 */     BitSet bitSet = getKeyValueUnionSet();
/* 542 */     return (ReversibleIndexedIterator<Map.Entry<K, V>>)new IndexedIterator(getIndexedProxy(), (ReversibleIterator)new BitSetIterator(bitSet, true));
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Map.Entry<K, V>> entrySetIterable() {
/* 546 */     BitSet bitSet = getKeyValueUnionSet();
/* 547 */     return (ReversibleIterable<Map.Entry<K, V>>)new IndexedIterable(getIndexedProxy(), (ReversibleIterable)new BitSetIterable(bitSet));
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Map.Entry<K, V>> reversedEntrySetIterable() {
/* 551 */     BitSet bitSet = getKeyValueUnionSet();
/* 552 */     return (ReversibleIterable<Map.Entry<K, V>>)new IndexedIterable(getIndexedProxy(), (ReversibleIterable)new BitSetIterable(bitSet));
/*     */   }
/*     */   
/*     */   private BitSet getKeyValueUnionSet() {
/*     */     BitSet bitSet;
/* 557 */     (bitSet = new BitSet(this.keySet.size())).or(this.keySet.getValidIndices());
/* 558 */     bitSet.or(this.valueSet.getValidIndices());
/* 559 */     return bitSet;
/*     */   }
/*     */   
/*     */   private BitSet getKeyValueIntersectionSet() {
/*     */     BitSet bitSet;
/* 564 */     (bitSet = new BitSet(this.keySet.size())).or(this.keySet.getValidIndices());
/* 565 */     bitSet.and(this.valueSet.getValidIndices());
/* 566 */     return bitSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Map.Entry<K, V>> iterator() {
/* 576 */     return (Iterator<Map.Entry<K, V>>)entrySetIterator();
/*     */   }
/*     */   
/*     */   public void forEach(Consumer<? super Map.Entry<K, V>> paramConsumer) {
/* 580 */     ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIterator = entrySetIterator();
/* 581 */     while (reversibleIndexedIterator.hasNext()) {
/* 582 */       paramConsumer.accept(reversibleIndexedIterator.next());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedSet<Map.Entry<K, V>> keyValueEntrySet() {
/* 588 */     this.isInValueUpdate = true;
/* 589 */     this.isInKeyUpdate = true;
/*     */     
/* 591 */     OrderedSet<Map.Entry<K, V>> orderedSet = new OrderedSet(this.keySet.size(), new CollectionHost<Map.Entry<Map.Entry<K, V>, V>>()
/*     */         {
/*     */           public void adding(int param1Int, Map.Entry<K, V> param1Entry, Object param1Object) {
/* 594 */             assert param1Object == null;
/* 595 */             OrderedMultiMap.this.putKeyValue(param1Entry.getKey(), param1Entry.getValue());
/*     */           }
/*     */ 
/*     */           
/*     */           public Object removing(int param1Int, Map.Entry<K, V> param1Entry) {
/*     */             boolean bool;
/* 601 */             return (bool = OrderedMultiMap.this.removeEntryIndex(param1Int, param1Entry.getKey(), param1Entry.getValue())) ? param1Entry : null;
/*     */           }
/*     */ 
/*     */           
/*     */           public void clearing() {
/* 606 */             OrderedMultiMap.this.clear();
/*     */           }
/*     */ 
/*     */           
/*     */           public void addingNulls(int param1Int) {
/* 611 */             OrderedMultiMap.this.addNullEntry(param1Int);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean skipHostUpdate() {
/* 616 */             return (OrderedMultiMap.this.isInKeyUpdate || OrderedMultiMap.this.isInValueUpdate);
/*     */           }
/*     */ 
/*     */           
/*     */           public int getIteratorModificationCount() {
/* 621 */             return OrderedMultiMap.this.getModificationCount();
/*     */           }
/*     */         });
/*     */     
/* 625 */     ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIterator = entrySetIterator();
/* 626 */     while (reversibleIndexedIterator.hasNext()) {
/* 627 */       orderedSet.add(reversibleIndexedIterator.next());
/*     */     }
/*     */ 
/*     */     
/* 631 */     this.isInValueUpdate = false;
/* 632 */     this.isInKeyUpdate = false;
/*     */     
/* 634 */     return orderedSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 639 */     if (this == paramObject) return true; 
/* 640 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 642 */     paramObject = paramObject;
/*     */     
/* 644 */     if (size() != paramObject.size()) return false; 
/* 645 */     return entrySet().equals(paramObject.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 650 */     int i = this.keySet.hashCode();
/*     */     
/* 652 */     return i = i * 31 + this.valueSet.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\OrderedMultiMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */