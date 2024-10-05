/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjectLongMap<K>
/*     */   implements Iterable<ObjectLongMap.Entry<K>>
/*     */ {
/*     */   public int size;
/*     */   K[] keyTable;
/*     */   long[] valueTable;
/*     */   float loadFactor;
/*     */   int threshold;
/*     */   protected int shift;
/*     */   protected int mask;
/*     */   transient Entries entries1;
/*     */   transient Entries entries2;
/*     */   transient Values values1;
/*     */   transient Values values2;
/*     */   transient Keys keys1;
/*     */   transient Keys keys2;
/*     */   
/*     */   public ObjectLongMap() {
/*  71 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectLongMap(int paramInt) {
/*  77 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectLongMap(int paramInt, float paramFloat) {
/*  84 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  85 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  86 */     this.loadFactor = paramFloat;
/*     */     
/*  88 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  89 */     this.threshold = (int)(paramInt * paramFloat);
/*  90 */     this.mask = paramInt - 1;
/*  91 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  93 */     this.keyTable = (K[])new Object[paramInt];
/*  94 */     this.valueTable = new long[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectLongMap(ObjectLongMap<? extends K> paramObjectLongMap) {
/*  99 */     this((int)(paramObjectLongMap.keyTable.length * paramObjectLongMap.loadFactor), paramObjectLongMap.loadFactor);
/* 100 */     System.arraycopy(paramObjectLongMap.keyTable, 0, this.keyTable, 0, paramObjectLongMap.keyTable.length);
/* 101 */     System.arraycopy(paramObjectLongMap.valueTable, 0, this.valueTable, 0, paramObjectLongMap.valueTable.length);
/* 102 */     this.size = paramObjectLongMap.size;
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
/*     */   protected int place(K paramK) {
/* 120 */     return (int)(paramK.hashCode() * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int locateKey(K paramK) {
/* 126 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 127 */     K[] arrayOfK = this.keyTable;
/* 128 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/* 130 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/* 131 */       if (k.equals(paramK)) return i; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(K paramK, long paramLong) {
/*     */     int i;
/* 137 */     if ((i = locateKey(paramK)) >= 0) {
/* 138 */       this.valueTable[i] = paramLong;
/*     */       return;
/*     */     } 
/* 141 */     i = -(i + 1);
/* 142 */     this.keyTable[i] = paramK;
/* 143 */     this.valueTable[i] = paramLong;
/* 144 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1);
/*     */   
/*     */   }
/*     */   
/*     */   public long put(K paramK, long paramLong1, long paramLong2) {
/*     */     int i;
/* 150 */     if ((i = locateKey(paramK)) >= 0) {
/* 151 */       long l = this.valueTable[i];
/* 152 */       this.valueTable[i] = paramLong1;
/* 153 */       return l;
/*     */     } 
/* 155 */     i = -(i + 1);
/* 156 */     this.keyTable[i] = paramK;
/* 157 */     this.valueTable[i] = paramLong1;
/* 158 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 159 */     return paramLong2;
/*     */   }
/*     */   
/*     */   public void putAll(ObjectLongMap<? extends K> paramObjectLongMap) {
/* 163 */     ensureCapacity(paramObjectLongMap.size);
/* 164 */     K[] arrayOfK = paramObjectLongMap.keyTable;
/* 165 */     long[] arrayOfLong = paramObjectLongMap.valueTable; byte b;
/*     */     int i;
/* 167 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 169 */       if ((k = arrayOfK[b]) != null) put(k, arrayOfLong[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, long paramLong) {
/* 175 */     K[] arrayOfK = this.keyTable; int i;
/* 176 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 177 */       if (arrayOfK[i] == null) {
/* 178 */         arrayOfK[i] = paramK;
/* 179 */         this.valueTable[i] = paramLong;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long get(K paramK, long paramLong) {
/*     */     int i;
/* 188 */     return ((i = locateKey(paramK)) < 0) ? paramLong : this.valueTable[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAndIncrement(K paramK, long paramLong1, long paramLong2) {
/*     */     int i;
/* 195 */     if ((i = locateKey(paramK)) >= 0) {
/* 196 */       long l = this.valueTable[i];
/* 197 */       this.valueTable[i] = this.valueTable[i] + paramLong2;
/* 198 */       return l;
/*     */     } 
/* 200 */     i = -(i + 1);
/* 201 */     this.keyTable[i] = paramK;
/* 202 */     this.valueTable[i] = paramLong1 + paramLong2;
/* 203 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 204 */     return paramLong1;
/*     */   }
/*     */ 
/*     */   
/*     */   public long remove(K paramK, long paramLong) {
/*     */     int i;
/* 210 */     if ((i = locateKey(paramK)) < 0) return paramLong; 
/* 211 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 213 */     long arrayOfLong[], l = (arrayOfLong = this.valueTable)[i];
/* 214 */     int j = this.mask, k = i + 1 & j;
/* 215 */     while ((paramK = arrayOfK[k]) != null) {
/* 216 */       int m = place(paramK);
/* 217 */       if ((k - m & j) > (i - m & j)) {
/* 218 */         arrayOfK[i] = paramK;
/* 219 */         arrayOfLong[i] = arrayOfLong[k];
/* 220 */         i = k;
/*     */       } 
/* 222 */       k = k + 1 & j;
/*     */     } 
/* 224 */     arrayOfK[i] = null;
/* 225 */     this.size--;
/* 226 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 231 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 236 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 243 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 244 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 245 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 250 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 251 */     if (this.keyTable.length <= paramInt) {
/* 252 */       clear();
/*     */       return;
/*     */     } 
/* 255 */     this.size = 0;
/* 256 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 260 */     if (this.size == 0)
/* 261 */       return;  this.size = 0;
/* 262 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(long paramLong) {
/* 268 */     K[] arrayOfK = this.keyTable;
/*     */     long[] arrayOfLong;
/* 270 */     for (int i = (arrayOfLong = this.valueTable).length - 1; i >= 0; i--) {
/* 271 */       if (arrayOfK[i] != null && arrayOfLong[i] == paramLong) return true; 
/* 272 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(K paramK) {
/* 276 */     return (locateKey(paramK) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public K findKey(long paramLong) {
/* 282 */     K[] arrayOfK = this.keyTable;
/*     */     long[] arrayOfLong;
/* 284 */     for (int i = (arrayOfLong = this.valueTable).length - 1; i >= 0; i--) {
/*     */       K k;
/* 286 */       if ((k = arrayOfK[i]) != null && arrayOfLong[i] == paramLong) return k; 
/*     */     } 
/* 288 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 294 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 295 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   final void resize(int paramInt) {
/* 299 */     int i = this.keyTable.length;
/* 300 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 301 */     this.mask = paramInt - 1;
/* 302 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 304 */     K[] arrayOfK = this.keyTable;
/* 305 */     long[] arrayOfLong = this.valueTable;
/*     */     
/* 307 */     this.keyTable = (K[])new Object[paramInt];
/* 308 */     this.valueTable = new long[paramInt];
/*     */     
/* 310 */     if (this.size > 0)
/* 311 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 313 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfLong[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 319 */     int i = this.size;
/* 320 */     K[] arrayOfK = this.keyTable;
/* 321 */     long[] arrayOfLong = this.valueTable; byte b; int j;
/* 322 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */       K k;
/* 324 */       if ((k = arrayOfK[b]) != null) i = (int)(i + k.hashCode() + arrayOfLong[b]); 
/*     */     } 
/* 326 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 330 */     if (paramObject == this) return true; 
/* 331 */     if (!(paramObject instanceof ObjectLongMap)) return false;
/*     */     
/* 333 */     if (((ObjectLongMap)(paramObject = paramObject)).size != this.size) return false; 
/* 334 */     K[] arrayOfK = this.keyTable;
/* 335 */     long[] arrayOfLong = this.valueTable; byte b; int i;
/* 336 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 338 */       if ((k = arrayOfK[b]) != null) {
/*     */         long l;
/* 340 */         if ((l = paramObject.get(k, 0L)) == 0L && !paramObject.containsKey(k)) return false; 
/* 341 */         if (l != arrayOfLong[b]) return false; 
/*     */       } 
/*     */     } 
/* 344 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 348 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 352 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   private String toString(String paramString, boolean paramBoolean) {
/* 356 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 357 */     java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(32);
/* 358 */     if (paramBoolean) stringBuilder.append('{'); 
/* 359 */     K[] arrayOfK = this.keyTable;
/* 360 */     long[] arrayOfLong = this.valueTable;
/* 361 */     int i = arrayOfK.length;
/* 362 */     while (i-- > 0) {
/*     */       K k;
/* 364 */       if ((k = arrayOfK[i]) != null) {
/* 365 */         stringBuilder.append(k);
/* 366 */         stringBuilder.append('=');
/* 367 */         stringBuilder.append(arrayOfLong[i]); break;
/*     */       } 
/*     */     } 
/* 370 */     while (i-- > 0) {
/*     */       K k;
/* 372 */       if ((k = arrayOfK[i]) != null) {
/* 373 */         stringBuilder.append(paramString);
/* 374 */         stringBuilder.append(k);
/* 375 */         stringBuilder.append('=');
/* 376 */         stringBuilder.append(arrayOfLong[i]);
/*     */       } 
/* 378 */     }  if (paramBoolean) stringBuilder.append('}'); 
/* 379 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K> iterator() {
/* 383 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<K> entries() {
/* 391 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 392 */     if (this.entries1 == null) {
/* 393 */       this.entries1 = new Entries(this);
/* 394 */       this.entries2 = new Entries(this);
/*     */     } 
/* 396 */     if (!this.entries1.valid) {
/* 397 */       this.entries1.reset();
/* 398 */       this.entries1.valid = true;
/* 399 */       this.entries2.valid = false;
/* 400 */       return this.entries1;
/*     */     } 
/* 402 */     this.entries2.reset();
/* 403 */     this.entries2.valid = true;
/* 404 */     this.entries1.valid = false;
/* 405 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values values() {
/* 413 */     if (Collections.allocateIterators) return new Values(this); 
/* 414 */     if (this.values1 == null) {
/* 415 */       this.values1 = new Values(this);
/* 416 */       this.values2 = new Values(this);
/*     */     } 
/* 418 */     if (!this.values1.valid) {
/* 419 */       this.values1.reset();
/* 420 */       this.values1.valid = true;
/* 421 */       this.values2.valid = false;
/* 422 */       return this.values1;
/*     */     } 
/* 424 */     this.values2.reset();
/* 425 */     this.values2.valid = true;
/* 426 */     this.values1.valid = false;
/* 427 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 435 */     if (Collections.allocateIterators) return new Keys<>(this); 
/* 436 */     if (this.keys1 == null) {
/* 437 */       this.keys1 = new Keys(this);
/* 438 */       this.keys2 = new Keys(this);
/*     */     } 
/* 440 */     if (!this.keys1.valid) {
/* 441 */       this.keys1.reset();
/* 442 */       this.keys1.valid = true;
/* 443 */       this.keys2.valid = false;
/* 444 */       return this.keys1;
/*     */     } 
/* 446 */     this.keys2.reset();
/* 447 */     this.keys2.valid = true;
/* 448 */     this.keys1.valid = false;
/* 449 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry<K> {
/*     */     public K key;
/*     */     public long value;
/*     */     
/*     */     public String toString() {
/* 457 */       return (new java.lang.StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator<K> {
/*     */     public boolean hasNext;
/*     */     final ObjectLongMap<K> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(ObjectLongMap<K> param1ObjectLongMap) {
/* 469 */       this.map = param1ObjectLongMap;
/* 470 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 474 */       this.currentIndex = -1;
/* 475 */       this.nextIndex = -1;
/* 476 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 481 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 482 */         if (arrayOfK[this.nextIndex] != null) {
/* 483 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 487 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 492 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 493 */       K[] arrayOfK = this.map.keyTable;
/* 494 */       long[] arrayOfLong = this.map.valueTable;
/* 495 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 497 */       while ((k1 = arrayOfK[k]) != null) {
/* 498 */         int m = this.map.place(k1);
/* 499 */         if ((k - m & j) > (i - m & j)) {
/* 500 */           arrayOfK[i] = k1;
/* 501 */           arrayOfLong[i] = arrayOfLong[k];
/* 502 */           i = k;
/*     */         } 
/* 504 */         k = k + 1 & j;
/*     */       } 
/* 506 */       arrayOfK[i] = null;
/* 507 */       this.map.size--;
/* 508 */       if (i != this.currentIndex) this.nextIndex--; 
/* 509 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K> extends MapIterator<K> implements Iterable<Entry<K>>, Iterator<Entry<K>> {
/* 514 */     ObjectLongMap.Entry<K> entry = new ObjectLongMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectLongMap<K> param1ObjectLongMap) {
/* 517 */       super(param1ObjectLongMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectLongMap.Entry<K> next() {
/* 522 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 523 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 524 */       K[] arrayOfK = this.map.keyTable;
/* 525 */       this.entry.key = arrayOfK[this.nextIndex];
/* 526 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 527 */       this.currentIndex = this.nextIndex;
/* 528 */       findNextIndex();
/* 529 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 533 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 534 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Entries<K> iterator() {
/* 538 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator<Object> {
/*     */     public Values(ObjectLongMap<?> param1ObjectLongMap) {
/* 544 */       super(param1ObjectLongMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 548 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 549 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public long next() {
/* 553 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 554 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 555 */       long l = this.map.valueTable[this.nextIndex];
/* 556 */       this.currentIndex = this.nextIndex;
/* 557 */       findNextIndex();
/* 558 */       return l;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 562 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public LongArray toArray() {
/* 567 */       LongArray longArray = new LongArray(true, this.map.size);
/* 568 */       while (this.hasNext)
/* 569 */         longArray.add(next()); 
/* 570 */       return longArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public LongArray toArray(LongArray param1LongArray) {
/* 575 */       while (this.hasNext)
/* 576 */         param1LongArray.add(next()); 
/* 577 */       return param1LongArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K> implements Iterable<K>, Iterator<K> {
/*     */     public Keys(ObjectLongMap<K> param1ObjectLongMap) {
/* 583 */       super(param1ObjectLongMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 587 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 588 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 592 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 593 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 594 */       K k = this.map.keyTable[this.nextIndex];
/* 595 */       this.currentIndex = this.nextIndex;
/* 596 */       findNextIndex();
/* 597 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 601 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray() {
/* 606 */       return toArray(new Array<>(true, this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 611 */       while (this.hasNext)
/* 612 */         param1Array.add(next()); 
/* 613 */       return param1Array;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ObjectLongMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */