/*     */ package com.vladsch.flexmark.util.collection;
/*     */ import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.Indexed;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class OrderedSet<E> implements Iterable<E>, Set<E> {
/*     */   private final HashMap<E, Integer> keyMap;
/*     */   final ArrayList<E> valueList;
/*     */   private final CollectionHost<E> host;
/*     */   
/*     */   public OrderedSet() {
/*  20 */     this(0);
/*     */   }
/*     */   private Indexed<E> indexedProxy; private Indexed<E> allowConcurrentModsIndexedProxy; private final BitSet validIndices; private int modificationCount;
/*     */   public OrderedSet(int paramInt) {
/*  24 */     this(paramInt, null);
/*     */   }
/*     */   
/*     */   public OrderedSet(CollectionHost<E> paramCollectionHost) {
/*  28 */     this(0, paramCollectionHost);
/*     */   }
/*     */   
/*     */   public OrderedSet(int paramInt, CollectionHost<E> paramCollectionHost) {
/*  32 */     this.keyMap = new HashMap<>(paramInt);
/*  33 */     this.valueList = new ArrayList<>(paramInt);
/*  34 */     this.validIndices = new BitSet();
/*  35 */     this.host = paramCollectionHost;
/*  36 */     this.modificationCount = Integer.MIN_VALUE;
/*  37 */     this.indexedProxy = null;
/*  38 */     this.allowConcurrentModsIndexedProxy = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitSet indexBitSet(Iterable<? extends E> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: new java/util/BitSet
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_1
/*     */     //   15: aload_1
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 50
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore_3
/*     */     //   31: aload_0
/*     */     //   32: aload_3
/*     */     //   33: invokevirtual indexOf : (Ljava/lang/Object;)I
/*     */     //   36: dup
/*     */     //   37: istore_3
/*     */     //   38: iconst_m1
/*     */     //   39: if_icmpeq -> 47
/*     */     //   42: aload_2
/*     */     //   43: iload_3
/*     */     //   44: invokevirtual set : (I)V
/*     */     //   47: goto -> 15
/*     */     //   50: aload_2
/*     */     //   51: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #42	-> 0
/*     */     //   #43	-> 8
/*     */     //   #44	-> 31
/*     */     //   #45	-> 37
/*     */     //   #46	-> 42
/*     */     //   #48	-> 47
/*     */     //   #49	-> 50
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitSet differenceBitSet(Iterable<? extends E> paramIterable) {
/*  53 */     return differenceBitSet(paramIterable.iterator());
/*     */   }
/*     */   
/*     */   public BitSet differenceBitSet(Iterator<? extends E> paramIterator) {
/*  57 */     BitSet bitSet = new BitSet();
/*  58 */     byte b = 0;
/*  59 */     while (paramIterator.hasNext()) {
/*  60 */       E e = paramIterator.next();
/*     */       
/*     */       int i;
/*  63 */       if ((i = indexOf(e)) != b) {
/*  64 */         bitSet.set(i);
/*     */       }
/*  66 */       b++;
/*     */     } 
/*  68 */     return bitSet;
/*     */   }
/*     */   
/*     */   public BitSet keyDifferenceBitSet(Iterable<? extends Map.Entry<? extends E, ?>> paramIterable) {
/*  72 */     return keyDifferenceBitSet(paramIterable.iterator());
/*     */   }
/*     */   
/*     */   public BitSet keyDifferenceBitSet(Iterator<? extends Map.Entry<? extends E, ?>> paramIterator) {
/*  76 */     BitSet bitSet = new BitSet();
/*  77 */     byte b = 0;
/*  78 */     while (paramIterator.hasNext()) {
/*  79 */       Map.Entry entry = paramIterator.next();
/*     */       int i;
/*  81 */       if ((i = indexOf(entry.getKey())) != b) {
/*  82 */         bitSet.set(i);
/*     */       }
/*  84 */       b++;
/*     */     } 
/*  86 */     return bitSet;
/*     */   }
/*     */   
/*     */   public BitSet valueDifferenceBitSet(Iterable<? extends Map.Entry<?, ? extends E>> paramIterable) {
/*  90 */     return valueDifferenceBitSet(paramIterable.iterator());
/*     */   }
/*     */   
/*     */   public BitSet valueDifferenceBitSet(Iterator<? extends Map.Entry<?, ? extends E>> paramIterator) {
/*  94 */     BitSet bitSet = new BitSet();
/*  95 */     byte b = 0;
/*  96 */     while (paramIterator.hasNext()) {
/*  97 */       Map.Entry entry = paramIterator.next();
/*     */       int i;
/*  99 */       if ((i = indexOf(entry.getValue())) != b) {
/* 100 */         bitSet.set(i);
/*     */       }
/* 102 */       b++;
/*     */     } 
/* 104 */     return bitSet;
/*     */   }
/*     */   
/*     */   private class IndexedProxy implements Indexed<E> {
/*     */     private final boolean allowConcurrentMods;
/*     */     
/*     */     public IndexedProxy(boolean param1Boolean) {
/* 111 */       this.allowConcurrentMods = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public E get(int param1Int) {
/* 116 */       return OrderedSet.this.getValue(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int param1Int, E param1E) {
/* 121 */       OrderedSet.this.setValueAt(param1Int, param1E, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public void removeAt(int param1Int) {
/* 126 */       OrderedSet.this.removeIndexHosted(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 131 */       return OrderedSet.this.valueList.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public int modificationCount() {
/* 136 */       return this.allowConcurrentMods ? 0 : OrderedSet.this.getIteratorModificationCount();
/*     */     }
/*     */   }
/*     */   
/*     */   public Indexed<E> getIndexedProxy() {
/* 141 */     if (this.indexedProxy != null) return this.indexedProxy; 
/* 142 */     this.indexedProxy = new IndexedProxy(false);
/* 143 */     return this.indexedProxy;
/*     */   }
/*     */   
/*     */   public Indexed<E> getConcurrentModsIndexedProxy() {
/* 147 */     if (this.allowConcurrentModsIndexedProxy != null) return this.allowConcurrentModsIndexedProxy; 
/* 148 */     this.allowConcurrentModsIndexedProxy = new IndexedProxy(true);
/* 149 */     return this.allowConcurrentModsIndexedProxy;
/*     */   }
/*     */   
/*     */   public int getModificationCount() {
/* 153 */     return this.modificationCount;
/*     */   }
/*     */   
/*     */   int getIteratorModificationCount() {
/* 157 */     return (this.host != null) ? this.host.getIteratorModificationCount() : this.modificationCount;
/*     */   }
/*     */   
/*     */   public static <T1> T1 ifNull(T1 paramT11, T1 paramT12) {
/* 161 */     return (paramT11 == null) ? paramT12 : paramT11;
/*     */   }
/*     */   
/*     */   public boolean inHostUpdate() {
/* 165 */     return (this.host != null && this.host.skipHostUpdate());
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 169 */     return ((Integer)ifNull(this.keyMap.get(paramObject), Integer.valueOf(-1))).intValue();
/*     */   }
/*     */   
/*     */   public boolean isValidIndex(int paramInt) {
/* 173 */     return (paramInt >= 0 && paramInt < this.valueList.size() && this.validIndices.get(paramInt));
/*     */   }
/*     */   
/*     */   public void validateIndex(int paramInt) {
/* 177 */     if (!isValidIndex(paramInt)) {
/* 178 */       throw new IndexOutOfBoundsException("Index " + paramInt + " is not valid, size=" + this.valueList.size() + " validIndices[" + paramInt + "]=" + this.validIndices.get(paramInt));
/*     */     }
/*     */   }
/*     */   
/*     */   public E getValue(int paramInt) {
/* 183 */     validateIndex(paramInt);
/* 184 */     return this.valueList.get(paramInt);
/*     */   }
/*     */   
/*     */   public E getValueOrNull(int paramInt) {
/* 188 */     return isValidIndex(paramInt) ? this.valueList.get(paramInt) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 193 */     return this.keyMap.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 198 */     return this.keyMap.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 203 */     return this.keyMap.containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public List<E> getValueList() {
/* 207 */     return this.valueList;
/*     */   }
/*     */   
/*     */   public List<E> values() {
/* 211 */     if (!isSparse()) return this.valueList; 
/* 212 */     ArrayList<E> arrayList = new ArrayList();
/* 213 */     for (ReversibleIterator<Object> reversibleIterator = iterable().iterator(); reversibleIterator.hasNext(); ) { Object object = reversibleIterator.next(); arrayList.add(object); }
/* 214 */      return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setValueAt(int paramInt, E paramE, Object paramObject) {
/*     */     int i;
/* 220 */     if ((i = indexOf(paramE)) != -1) {
/* 221 */       if (paramInt != i) {
/* 222 */         throw new IllegalStateException("Trying to add existing element " + paramE + "[" + i + "] at index " + paramInt);
/*     */       }
/*     */       
/* 225 */       return false;
/*     */     } 
/* 227 */     if (paramInt < this.valueList.size())
/* 228 */     { if (this.validIndices.get(paramInt))
/*     */       {
/* 230 */         throw new IllegalStateException("Trying to add new element " + paramE + " at index " + paramInt + ", already occupied by " + this.valueList.get(paramInt));
/*     */       
/*     */       } }
/*     */     
/* 234 */     else if (paramInt > this.valueList.size()) { addNulls(paramInt - 1); }
/*     */ 
/*     */ 
/*     */     
/* 238 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 239 */       this.host.adding(paramInt, paramE, paramObject);
/*     */     }
/*     */     
/* 242 */     this.keyMap.put(paramE, Integer.valueOf(paramInt));
/* 243 */     this.valueList.set(paramInt, paramE);
/* 244 */     this.validIndices.set(paramInt);
/*     */     
/* 246 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSparse() {
/* 251 */     return (this.validIndices.nextClearBit(0) < this.valueList.size());
/*     */   }
/*     */   
/*     */   public void addNull() {
/* 255 */     addNulls(this.valueList.size());
/*     */   }
/*     */   
/*     */   public void addNulls(int paramInt) {
/* 259 */     assert paramInt >= this.valueList.size();
/*     */     
/* 261 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 262 */       this.host.addingNulls(paramInt);
/*     */     }
/*     */     
/* 265 */     this.modificationCount++;
/*     */ 
/*     */ 
/*     */     
/* 269 */     for (; this.valueList.size() <= paramInt; this.valueList.add(null));
/*     */   }
/*     */   
/*     */   public ReversibleIterator<Integer> indexIterator() {
/* 273 */     return (ReversibleIterator<Integer>)new BitSetIterator(this.validIndices);
/*     */   }
/*     */   
/*     */   public ReversibleIterator<Integer> reversedIndexIterator() {
/* 277 */     return (ReversibleIterator<Integer>)new BitSetIterator(this.validIndices, true);
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Integer> indexIterable() {
/* 281 */     return (ReversibleIterable<Integer>)new BitSetIterable(this.validIndices);
/*     */   }
/*     */   
/*     */   public ReversibleIterable<Integer> reversedIndexIterable() {
/* 285 */     return (ReversibleIterable<Integer>)new BitSetIterable(this.validIndices, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public ReversibleIndexedIterator<E> iterator() {
/* 290 */     return (ReversibleIndexedIterator<E>)new IndexedIterator(getIndexedProxy(), indexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIndexedIterator<E> reversedIterator() {
/* 294 */     return (ReversibleIndexedIterator<E>)new IndexedIterator(getIndexedProxy(), reversedIndexIterator());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<E> iterable() {
/* 298 */     return (ReversibleIterable<E>)new IndexedIterable(getIndexedProxy(), indexIterable());
/*     */   }
/*     */   
/*     */   public ReversibleIterable<E> reversedIterable() {
/* 302 */     return (ReversibleIterable<E>)new IndexedIterable(getIndexedProxy(), reversedIndexIterable());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 308 */     Object[] arrayOfObject = new Object[this.keyMap.size()];
/* 309 */     byte b1 = -1;
/* 310 */     byte b2 = -1;
/* 311 */     while (b1 + 1 < this.valueList.size()) {
/* 312 */       if (this.validIndices.get(++b1))
/* 313 */         arrayOfObject[++b2] = this.valueList.get(b1); 
/*     */     } 
/* 315 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 321 */     T[] arrayOfT = paramArrayOfT;
/*     */     
/* 323 */     if (paramArrayOfT.length < this.keyMap.size()) {
/* 324 */       arrayOfT = (paramArrayOfT.getClass() == Object[].class) ? (T[])new Object[this.keyMap.size()] : (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.keyMap.size());
/*     */     }
/*     */     
/* 327 */     byte b1 = -1;
/* 328 */     byte b2 = -1;
/* 329 */     while (b1 + 1 < this.valueList.size()) {
/* 330 */       if (this.validIndices.get(++b1)) {
/* 331 */         arrayOfT[++b2] = (T)this.valueList.get(b1);
/*     */       }
/*     */     } 
/* 334 */     if (arrayOfT.length > ++b2) {
/* 335 */       arrayOfT[b2] = null;
/*     */     }
/*     */     
/* 338 */     return arrayOfT;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 343 */     return add(paramE, null);
/*     */   }
/*     */   
/*     */   public boolean add(E paramE, Object paramObject) {
/* 347 */     if (this.keyMap.containsKey(paramE)) return false;
/*     */     
/* 349 */     int i = this.valueList.size();
/*     */     
/* 351 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 352 */       this.host.adding(i, paramE, paramObject);
/*     */     }
/*     */     
/* 355 */     this.modificationCount++;
/* 356 */     this.keyMap.put(paramE, Integer.valueOf(i));
/* 357 */     this.valueList.add(paramE);
/* 358 */     this.validIndices.set(i);
/* 359 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeIndex(int paramInt) {
/* 363 */     return (removeIndexHosted(paramInt) != null);
/*     */   }
/*     */   public Object removeIndexHosted(int paramInt) {
/*     */     E e2;
/* 367 */     validateIndex(paramInt);
/*     */     
/* 369 */     E e1 = this.valueList.get(paramInt);
/*     */     
/* 371 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 372 */       e2 = (E)this.host.removing(paramInt, e1);
/*     */     } else {
/* 374 */       e2 = e1;
/*     */     } 
/*     */     
/* 377 */     this.modificationCount++;
/* 378 */     this.keyMap.remove(e1);
/*     */     
/* 380 */     if (this.keyMap.size() == 0) {
/* 381 */       if (this.host != null && !this.host.skipHostUpdate()) {
/* 382 */         this.host.clearing();
/*     */       }
/* 384 */       this.valueList.clear();
/* 385 */       this.validIndices.clear();
/*     */     } else {
/* 387 */       if (this.host == null && paramInt == this.valueList.size() - 1) {
/* 388 */         this.valueList.remove(paramInt);
/*     */       }
/* 390 */       this.validIndices.clear(paramInt);
/*     */     } 
/*     */     
/* 393 */     return e2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 398 */     return (removeHosted(paramObject) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeHosted(Object paramObject) {
/* 403 */     if ((paramObject = this.keyMap.get(paramObject)) == null) return null; 
/* 404 */     return removeIndexHosted(paramObject.intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 409 */     for (Object object : paramCollection) {
/* 410 */       if (!this.keyMap.containsKey(object)) {
/* 411 */         return false;
/*     */       }
/*     */     } 
/* 414 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: iconst_1
/*     */     //   1: newarray boolean
/*     */     //   3: dup
/*     */     //   4: iconst_0
/*     */     //   5: iconst_0
/*     */     //   6: bastore
/*     */     //   7: astore_2
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_1
/*     */     //   15: aload_1
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 46
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore_3
/*     */     //   31: aload_0
/*     */     //   32: aload_3
/*     */     //   33: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   36: ifeq -> 43
/*     */     //   39: aload_2
/*     */     //   40: iconst_0
/*     */     //   41: iconst_1
/*     */     //   42: bastore
/*     */     //   43: goto -> 15
/*     */     //   46: aload_2
/*     */     //   47: iconst_0
/*     */     //   48: baload
/*     */     //   49: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #419	-> 0
/*     */     //   #420	-> 8
/*     */     //   #421	-> 31
/*     */     //   #422	-> 43
/*     */     //   #423	-> 46
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/*     */     BitSet bitSet;
/* 429 */     (bitSet = new BitSet(this.valueList.size())).set(0, this.valueList.size());
/* 430 */     bitSet.and(this.validIndices);
/*     */     
/* 432 */     for (Object object : paramCollection) {
/*     */       int j;
/* 434 */       if ((j = indexOf(object)) != -1) {
/* 435 */         bitSet.clear(j);
/*     */       }
/*     */     } 
/*     */     
/*     */     int i;
/*     */     
/* 441 */     if ((i = this.valueList.size()) == 0) return false; 
/* 442 */     boolean bool = false;
/* 443 */     while (i-- > 0 && (
/*     */       
/* 445 */       i = bitSet.previousSetBit(i)) != -1) {
/* 446 */       remove(this.valueList.get(i));
/* 447 */       bool = true;
/*     */     } 
/*     */     
/* 450 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 455 */     boolean bool = false;
/* 456 */     for (Object object : paramCollection) {
/* 457 */       if (this.keyMap.containsKey(object) && 
/* 458 */         remove(object)) bool = true;
/*     */     
/*     */     } 
/* 461 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 466 */     if (this.host != null && !this.host.skipHostUpdate()) {
/* 467 */       this.host.clearing();
/*     */     }
/*     */     
/* 470 */     this.modificationCount++;
/* 471 */     this.keyMap.clear();
/* 472 */     this.valueList.clear();
/* 473 */     this.validIndices.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 478 */     if (this == paramObject) return true; 
/* 479 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 481 */     paramObject = paramObject;
/*     */     
/* 483 */     if (size() != paramObject.size()) return false; 
/* 484 */     paramObject = paramObject.iterator();
/* 485 */     for (ReversibleIndexedIterator<E> reversibleIndexedIterator = iterator(); reversibleIndexedIterator.hasNext(); ) { E e = reversibleIndexedIterator.next();
/* 486 */       Object object = paramObject.next();
/* 487 */       if (!e.equals(object)) return false;  }
/*     */     
/* 489 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 494 */     int i = this.keyMap.hashCode();
/* 495 */     i = i * 31 + this.valueList.hashCode();
/*     */     
/* 497 */     return i = i * 31 + this.validIndices.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public BitSet getValidIndices() {
/* 502 */     return this.validIndices;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\OrderedSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */