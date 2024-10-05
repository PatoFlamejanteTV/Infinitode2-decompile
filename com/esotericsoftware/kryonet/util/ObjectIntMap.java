/*     */ package com.esotericsoftware.kryonet.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.util.IntArray;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjectIntMap<K>
/*     */   implements Iterable<ObjectIntMap.Entry<K>>
/*     */ {
/*     */   public int size;
/*     */   K[] keyTable;
/*     */   int[] valueTable;
/*     */   float loadFactor;
/*     */   int threshold;
/*     */   protected int shift;
/*     */   protected int mask;
/*     */   
/*     */   public ObjectIntMap() {
/*  92 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectIntMap(int paramInt) {
/* 103 */     this(paramInt, 0.8F);
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
/*     */   public ObjectIntMap(int paramInt, float paramFloat) {
/* 116 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F) {
/* 117 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat);
/*     */     }
/* 119 */     this.loadFactor = paramFloat;
/*     */     
/* 121 */     paramInt = tableSize(paramInt, paramFloat);
/* 122 */     this.threshold = (int)(paramInt * paramFloat);
/* 123 */     this.mask = paramInt - 1;
/* 124 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 126 */     this.keyTable = (K[])new Object[paramInt];
/* 127 */     this.valueTable = new int[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectIntMap(ObjectIntMap<? extends K> paramObjectIntMap) {
/* 132 */     this((int)(paramObjectIntMap.keyTable.length * paramObjectIntMap.loadFactor), paramObjectIntMap.loadFactor);
/* 133 */     System.arraycopy(paramObjectIntMap.keyTable, 0, this.keyTable, 0, paramObjectIntMap.keyTable.length);
/* 134 */     System.arraycopy(paramObjectIntMap.valueTable, 0, this.valueTable, 0, paramObjectIntMap.valueTable.length);
/*     */     
/* 136 */     this.size = paramObjectIntMap.size;
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
/*     */   protected int place(K paramK) {
/* 162 */     return (int)(paramK.hashCode() * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int locateKey(K paramK) {
/* 171 */     if (paramK == null)
/* 172 */       throw new IllegalArgumentException("key cannot be null."); 
/* 173 */     K[] arrayOfK = this.keyTable;
/* 174 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/* 176 */       if ((k = arrayOfK[i]) == null)
/* 177 */         return -(i + 1); 
/* 178 */       if (k.equals(paramK)) {
/* 179 */         return i;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(K paramK, int paramInt) {
/*     */     int i;
/* 186 */     if ((i = locateKey(paramK)) >= 0) {
/* 187 */       this.valueTable[i] = paramInt;
/*     */       return;
/*     */     } 
/* 190 */     i = -(i + 1);
/* 191 */     this.keyTable[i] = paramK;
/* 192 */     this.valueTable[i] = paramInt;
/* 193 */     if (++this.size >= this.threshold)
/* 194 */       resize(this.keyTable.length << 1); 
/*     */   }
/*     */   
/*     */   public void putAll(ObjectIntMap<? extends K> paramObjectIntMap) {
/* 198 */     ensureCapacity(paramObjectIntMap.size);
/* 199 */     K[] arrayOfK = paramObjectIntMap.keyTable;
/* 200 */     int[] arrayOfInt = paramObjectIntMap.valueTable; byte b;
/*     */     int i;
/* 202 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 204 */       if ((k = arrayOfK[b]) != null) {
/* 205 */         put(k, arrayOfInt[b]);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, int paramInt) {
/* 211 */     K[] arrayOfK = this.keyTable; int i;
/* 212 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 213 */       if (arrayOfK[i] == null) {
/* 214 */         arrayOfK[i] = paramK;
/* 215 */         this.valueTable[i] = paramInt;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(K paramK, int paramInt) {
/*     */     int i;
/* 227 */     return ((i = locateKey(paramK)) < 0) ? paramInt : this.valueTable[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAndIncrement(K paramK, int paramInt1, int paramInt2) {
/*     */     int i, j;
/* 237 */     if ((j = locateKey(paramK)) >= 0) {
/* 238 */       i = this.valueTable[j];
/* 239 */       this.valueTable[j] = this.valueTable[j] + paramInt2;
/* 240 */       return i;
/*     */     } 
/* 242 */     j = -(j + 1);
/* 243 */     this.keyTable[j] = i;
/* 244 */     this.valueTable[j] = paramInt1 + paramInt2;
/* 245 */     if (++this.size >= this.threshold)
/* 246 */       resize(this.keyTable.length << 1); 
/* 247 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public int remove(K paramK, int paramInt) {
/*     */     int i;
/* 252 */     if ((i = locateKey(paramK)) < 0)
/* 253 */       return paramInt; 
/* 254 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 256 */     int arrayOfInt[], j = (arrayOfInt = this.valueTable)[i];
/* 257 */     int k = this.mask, m = i + 1 & k;
/* 258 */     while ((paramK = arrayOfK[m]) != null) {
/* 259 */       int n = place(paramK);
/* 260 */       if ((m - n & k) > (i - n & k)) {
/* 261 */         arrayOfK[i] = paramK;
/* 262 */         arrayOfInt[i] = arrayOfInt[m];
/* 263 */         i = m;
/*     */       } 
/* 265 */       m = m + 1 & k;
/*     */     } 
/* 267 */     arrayOfK[i] = null;
/* 268 */     this.size--;
/* 269 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 274 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 279 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 289 */     if (paramInt < 0) {
/* 290 */       throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt);
/*     */     }
/* 292 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 293 */     if (this.keyTable.length > paramInt) {
/* 294 */       resize(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/* 302 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 303 */     if (this.keyTable.length <= paramInt) {
/* 304 */       clear();
/*     */       return;
/*     */     } 
/* 307 */     this.size = 0;
/* 308 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 312 */     if (this.size == 0)
/*     */       return; 
/* 314 */     this.size = 0;
/* 315 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(int paramInt) {
/* 324 */     K[] arrayOfK = this.keyTable;
/*     */     int[] arrayOfInt;
/* 326 */     for (int i = (arrayOfInt = this.valueTable).length - 1; i >= 0; i--) {
/* 327 */       if (arrayOfK[i] != null && arrayOfInt[i] == paramInt)
/* 328 */         return true; 
/* 329 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(K paramK) {
/* 333 */     return (locateKey(paramK) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K findKey(int paramInt) {
/* 343 */     K[] arrayOfK = this.keyTable;
/*     */     int[] arrayOfInt;
/* 345 */     for (int i = (arrayOfInt = this.valueTable).length - 1; i >= 0; i--) {
/*     */       K k;
/* 347 */       if ((k = arrayOfK[i]) != null && arrayOfInt[i] == paramInt)
/* 348 */         return k; 
/*     */     } 
/* 350 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 359 */     paramInt = tableSize(this.size + paramInt, this.loadFactor);
/* 360 */     if (this.keyTable.length < paramInt)
/* 361 */       resize(paramInt); 
/*     */   }
/*     */   
/*     */   final void resize(int paramInt) {
/* 365 */     int i = this.keyTable.length;
/* 366 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 367 */     this.mask = paramInt - 1;
/* 368 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 370 */     K[] arrayOfK = this.keyTable;
/* 371 */     int[] arrayOfInt = this.valueTable;
/*     */     
/* 373 */     this.keyTable = (K[])new Object[paramInt];
/* 374 */     this.valueTable = new int[paramInt];
/*     */     
/* 376 */     if (this.size > 0)
/* 377 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 379 */         if ((k = arrayOfK[paramInt]) != null) {
/* 380 */           putResize(k, arrayOfInt[paramInt]);
/*     */         }
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 386 */     int i = this.size;
/* 387 */     K[] arrayOfK = this.keyTable;
/* 388 */     int[] arrayOfInt = this.valueTable; byte b; int j;
/* 389 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */       K k;
/* 391 */       if ((k = arrayOfK[b]) != null)
/* 392 */         i += k.hashCode() + arrayOfInt[b]; 
/*     */     } 
/* 394 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 398 */     if (paramObject == this)
/* 399 */       return true; 
/* 400 */     if (!(paramObject instanceof ObjectIntMap)) {
/* 401 */       return false;
/*     */     }
/* 403 */     if (((ObjectIntMap)(paramObject = paramObject)).size != this.size)
/* 404 */       return false; 
/* 405 */     K[] arrayOfK = this.keyTable;
/* 406 */     int[] arrayOfInt = this.valueTable; byte b; int i;
/* 407 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 409 */       if ((k = arrayOfK[b]) != null) {
/*     */         int j;
/* 411 */         if ((j = paramObject.get(k, 0)) == 0 && !paramObject.containsKey(k))
/* 412 */           return false; 
/* 413 */         if (j != arrayOfInt[b])
/* 414 */           return false; 
/*     */       } 
/*     */     } 
/* 417 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 421 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 425 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   private String toString(String paramString, boolean paramBoolean) {
/* 429 */     if (this.size == 0)
/* 430 */       return paramBoolean ? "{}" : ""; 
/* 431 */     StringBuilder stringBuilder = new StringBuilder(32);
/* 432 */     if (paramBoolean)
/* 433 */       stringBuilder.append('{'); 
/* 434 */     K[] arrayOfK = this.keyTable;
/* 435 */     int[] arrayOfInt = this.valueTable;
/* 436 */     int i = arrayOfK.length;
/* 437 */     while (i-- > 0) {
/*     */       K k;
/* 439 */       if ((k = arrayOfK[i]) != null) {
/*     */         
/* 441 */         stringBuilder.append(k);
/* 442 */         stringBuilder.append('=');
/* 443 */         stringBuilder.append(arrayOfInt[i]); break;
/*     */       } 
/*     */     } 
/* 446 */     while (i-- > 0) {
/*     */       K k;
/* 448 */       if ((k = arrayOfK[i]) != null) {
/*     */         
/* 450 */         stringBuilder.append(paramString);
/* 451 */         stringBuilder.append(k);
/* 452 */         stringBuilder.append('=');
/* 453 */         stringBuilder.append(arrayOfInt[i]);
/*     */       } 
/* 455 */     }  if (paramBoolean)
/* 456 */       stringBuilder.append('}'); 
/* 457 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K> iterator() {
/* 461 */     return entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entries<K> entries() {
/* 466 */     return new Entries<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Values values() {
/* 471 */     return new Values(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 476 */     return new Keys<>(this);
/*     */   }
/*     */   
/*     */   private static int tableSize(int paramInt, float paramFloat) {
/* 480 */     if (paramInt < 0) {
/* 481 */       throw new IllegalArgumentException("capacity must be >= 0: " + paramInt);
/*     */     }
/*     */     
/*     */     int i;
/* 485 */     if ((i = nextPowerOfTwo(Math.max(2, (int)Math.ceil((paramInt / paramFloat))))) > 1073741824) {
/* 486 */       throw new IllegalArgumentException("The required capacity is too large: " + paramInt);
/*     */     }
/* 488 */     return i;
/*     */   }
/*     */   
/*     */   private static int nextPowerOfTwo(int paramInt) {
/* 492 */     if (paramInt == 0)
/* 493 */       return 1; 
/* 494 */     paramInt--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 500 */     return (paramInt = (paramInt = (paramInt = (paramInt = (paramInt = paramInt | paramInt >> 1) | paramInt >> 2) | paramInt >> 4) | paramInt >> 8) | paramInt >> 16) + 1;
/*     */   }
/*     */   
/*     */   public static class Entry<K> {
/*     */     public K key;
/*     */     public int value;
/*     */     
/*     */     public String toString() {
/* 508 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator<K> {
/*     */     public boolean hasNext;
/*     */     final ObjectIntMap<K> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(ObjectIntMap<K> param1ObjectIntMap) {
/* 520 */       this.map = param1ObjectIntMap;
/* 521 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 525 */       this.currentIndex = -1;
/* 526 */       this.nextIndex = -1;
/* 527 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 532 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 533 */         if (arrayOfK[this.nextIndex] != null) {
/* 534 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 538 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 543 */       if ((i = this.currentIndex) < 0) {
/* 544 */         throw new IllegalStateException("next must be called before remove.");
/*     */       }
/* 546 */       K[] arrayOfK = this.map.keyTable;
/* 547 */       int[] arrayOfInt = this.map.valueTable;
/* 548 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 550 */       while ((k1 = arrayOfK[k]) != null) {
/* 551 */         int m = this.map.place(k1);
/* 552 */         if ((k - m & j) > (i - m & j)) {
/* 553 */           arrayOfK[i] = k1;
/* 554 */           arrayOfInt[i] = arrayOfInt[k];
/* 555 */           i = k;
/*     */         } 
/* 557 */         k = k + 1 & j;
/*     */       } 
/* 559 */       arrayOfK[i] = null;
/* 560 */       this.map.size--;
/* 561 */       if (i != this.currentIndex)
/* 562 */         this.nextIndex--; 
/* 563 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K>
/*     */     extends MapIterator<K> implements Iterable<Entry<K>>, Iterator<Entry<K>> {
/* 569 */     ObjectIntMap.Entry<K> entry = new ObjectIntMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectIntMap<K> param1ObjectIntMap) {
/* 572 */       super(param1ObjectIntMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ObjectIntMap.Entry<K> next() {
/* 580 */       if (!this.hasNext)
/* 581 */         throw new NoSuchElementException(); 
/* 582 */       if (!this.valid)
/* 583 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 584 */       K[] arrayOfK = this.map.keyTable;
/* 585 */       this.entry.key = arrayOfK[this.nextIndex];
/* 586 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 587 */       this.currentIndex = this.nextIndex;
/* 588 */       findNextIndex();
/* 589 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 593 */       if (!this.valid)
/* 594 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 595 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Entries<K> iterator() {
/* 599 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator<Object> {
/*     */     public Values(ObjectIntMap<?> param1ObjectIntMap) {
/* 605 */       super(param1ObjectIntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 609 */       if (!this.valid)
/* 610 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 611 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public int next() {
/* 615 */       if (!this.hasNext)
/* 616 */         throw new NoSuchElementException(); 
/* 617 */       if (!this.valid)
/* 618 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 619 */       int i = this.map.valueTable[this.nextIndex];
/* 620 */       this.currentIndex = this.nextIndex;
/* 621 */       findNextIndex();
/* 622 */       return i;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 626 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 631 */       IntArray intArray = new IntArray(true, this.map.size);
/* 632 */       while (this.hasNext)
/* 633 */         intArray.add(next()); 
/* 634 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 639 */       while (this.hasNext)
/* 640 */         param1IntArray.add(next()); 
/* 641 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K>
/*     */     extends MapIterator<K> implements Iterable<K>, Iterator<K> {
/*     */     public Keys(ObjectIntMap<K> param1ObjectIntMap) {
/* 648 */       super(param1ObjectIntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 652 */       if (!this.valid)
/* 653 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 654 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 658 */       if (!this.hasNext)
/* 659 */         throw new NoSuchElementException(); 
/* 660 */       if (!this.valid)
/* 661 */         throw new KryoException("#iterator() cannot be used nested."); 
/* 662 */       K k = this.map.keyTable[this.nextIndex];
/* 663 */       this.currentIndex = this.nextIndex;
/* 664 */       findNextIndex();
/* 665 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 669 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<K> toList() {
/* 674 */       return toList(new ArrayList<>(this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public <T extends java.util.List<K>> T toList(T param1T) {
/* 679 */       while (this.hasNext)
/* 680 */         param1T.add(next()); 
/* 681 */       return param1T;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryone\\util\ObjectIntMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */