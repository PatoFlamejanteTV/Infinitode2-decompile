/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
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
/*  74 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectIntMap(int paramInt) {
/*  80 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectIntMap(int paramInt, float paramFloat) {
/*  87 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  88 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  89 */     this.loadFactor = paramFloat;
/*     */     
/*  91 */     paramInt = ObjectMap.tableSize(paramInt, paramFloat);
/*  92 */     this.threshold = (int)(paramInt * paramFloat);
/*  93 */     this.mask = paramInt - 1;
/*  94 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  96 */     this.keyTable = (K[])new Object[paramInt];
/*  97 */     this.valueTable = new int[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectIntMap(ObjectIntMap<? extends K> paramObjectIntMap) {
/* 102 */     this((int)(paramObjectIntMap.keyTable.length * paramObjectIntMap.loadFactor), paramObjectIntMap.loadFactor);
/* 103 */     System.arraycopy(paramObjectIntMap.keyTable, 0, this.keyTable, 0, paramObjectIntMap.keyTable.length);
/* 104 */     System.arraycopy(paramObjectIntMap.valueTable, 0, this.valueTable, 0, paramObjectIntMap.valueTable.length);
/* 105 */     this.size = paramObjectIntMap.size;
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
/* 123 */     return (int)(paramK.hashCode() * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int locateKey(K paramK) {
/* 129 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 130 */     K[] arrayOfK = this.keyTable;
/* 131 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/* 133 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/* 134 */       if (k.equals(paramK)) return i;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(K paramK, int paramInt) {
/*     */     int i;
/* 141 */     if ((i = locateKey(paramK)) >= 0) {
/* 142 */       this.valueTable[i] = paramInt;
/*     */       return;
/*     */     } 
/* 145 */     i = -(i + 1);
/* 146 */     this.keyTable[i] = paramK;
/* 147 */     this.valueTable[i] = paramInt;
/* 148 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/*     */   }
/*     */   
/*     */   public void putAll(ObjectIntMap<? extends K> paramObjectIntMap) {
/* 152 */     ensureCapacity(paramObjectIntMap.size);
/* 153 */     K[] arrayOfK = paramObjectIntMap.keyTable;
/* 154 */     int[] arrayOfInt = paramObjectIntMap.valueTable; byte b;
/*     */     int i;
/* 156 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 158 */       if ((k = arrayOfK[b]) != null) put(k, arrayOfInt[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, int paramInt) {
/* 164 */     K[] arrayOfK = this.keyTable; int i;
/* 165 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 166 */       if (arrayOfK[i] == null) {
/* 167 */         arrayOfK[i] = paramK;
/* 168 */         this.valueTable[i] = paramInt;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(K paramK, int paramInt) {
/*     */     int i;
/* 177 */     return ((i = locateKey(paramK)) < 0) ? paramInt : this.valueTable[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAndIncrement(K paramK, int paramInt1, int paramInt2) {
/*     */     int i, j;
/* 184 */     if ((j = locateKey(paramK)) >= 0) {
/* 185 */       i = this.valueTable[j];
/* 186 */       this.valueTable[j] = this.valueTable[j] + paramInt2;
/* 187 */       return i;
/*     */     } 
/* 189 */     j = -(j + 1);
/* 190 */     this.keyTable[j] = i;
/* 191 */     this.valueTable[j] = paramInt1 + paramInt2;
/* 192 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 193 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public int remove(K paramK, int paramInt) {
/*     */     int i;
/* 198 */     if ((i = locateKey(paramK)) < 0) return paramInt; 
/* 199 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 201 */     int arrayOfInt[], j = (arrayOfInt = this.valueTable)[i];
/* 202 */     int k = this.mask, m = i + 1 & k;
/* 203 */     while ((paramK = arrayOfK[m]) != null) {
/* 204 */       int n = place(paramK);
/* 205 */       if ((m - n & k) > (i - n & k)) {
/* 206 */         arrayOfK[i] = paramK;
/* 207 */         arrayOfInt[i] = arrayOfInt[m];
/* 208 */         i = m;
/*     */       } 
/* 210 */       m = m + 1 & k;
/*     */     } 
/* 212 */     arrayOfK[i] = null;
/* 213 */     this.size--;
/* 214 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 219 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 224 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 231 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 232 */     paramInt = ObjectMap.tableSize(paramInt, this.loadFactor);
/* 233 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 238 */     paramInt = ObjectMap.tableSize(paramInt, this.loadFactor);
/* 239 */     if (this.keyTable.length <= paramInt) {
/* 240 */       clear();
/*     */       return;
/*     */     } 
/* 243 */     this.size = 0;
/* 244 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 248 */     if (this.size == 0)
/* 249 */       return;  this.size = 0;
/* 250 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(int paramInt) {
/* 256 */     K[] arrayOfK = this.keyTable;
/*     */     int[] arrayOfInt;
/* 258 */     for (int i = (arrayOfInt = this.valueTable).length - 1; i >= 0; i--) {
/* 259 */       if (arrayOfK[i] != null && arrayOfInt[i] == paramInt) return true; 
/* 260 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(K paramK) {
/* 264 */     return (locateKey(paramK) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public K findKey(int paramInt) {
/* 271 */     K[] arrayOfK = this.keyTable;
/*     */     int[] arrayOfInt;
/* 273 */     for (int i = (arrayOfInt = this.valueTable).length - 1; i >= 0; i--) {
/*     */       K k;
/* 275 */       if ((k = arrayOfK[i]) != null && arrayOfInt[i] == paramInt) return k; 
/*     */     } 
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 283 */     paramInt = ObjectMap.tableSize(this.size + paramInt, this.loadFactor);
/* 284 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   final void resize(int paramInt) {
/* 288 */     int i = this.keyTable.length;
/* 289 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 290 */     this.mask = paramInt - 1;
/* 291 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 293 */     K[] arrayOfK = this.keyTable;
/* 294 */     int[] arrayOfInt = this.valueTable;
/*     */     
/* 296 */     this.keyTable = (K[])new Object[paramInt];
/* 297 */     this.valueTable = new int[paramInt];
/*     */     
/* 299 */     if (this.size > 0)
/* 300 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 302 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfInt[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 308 */     int i = this.size;
/* 309 */     K[] arrayOfK = this.keyTable;
/* 310 */     int[] arrayOfInt = this.valueTable; byte b; int j;
/* 311 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */       K k;
/* 313 */       if ((k = arrayOfK[b]) != null) i += k.hashCode() + arrayOfInt[b]; 
/*     */     } 
/* 315 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 319 */     if (paramObject == this) return true; 
/* 320 */     if (!(paramObject instanceof ObjectIntMap)) return false;
/*     */     
/* 322 */     if (((ObjectIntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 323 */     K[] arrayOfK = this.keyTable;
/* 324 */     int[] arrayOfInt = this.valueTable; byte b; int i;
/* 325 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 327 */       if ((k = arrayOfK[b]) != null) {
/*     */         int j;
/* 329 */         if ((j = paramObject.get(k, 0)) == 0 && !paramObject.containsKey(k)) return false; 
/* 330 */         if (j != arrayOfInt[b]) return false; 
/*     */       } 
/*     */     } 
/* 333 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 337 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 341 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   private String toString(String paramString, boolean paramBoolean) {
/* 345 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 346 */     StringBuilder stringBuilder = new StringBuilder(32);
/* 347 */     if (paramBoolean) stringBuilder.append('{'); 
/* 348 */     K[] arrayOfK = this.keyTable;
/* 349 */     int[] arrayOfInt = this.valueTable;
/* 350 */     int i = arrayOfK.length;
/* 351 */     while (i-- > 0) {
/*     */       K k;
/* 353 */       if ((k = arrayOfK[i]) != null) {
/* 354 */         stringBuilder.append(k);
/* 355 */         stringBuilder.append('=');
/* 356 */         stringBuilder.append(arrayOfInt[i]); break;
/*     */       } 
/*     */     } 
/* 359 */     while (i-- > 0) {
/*     */       K k;
/* 361 */       if ((k = arrayOfK[i]) != null) {
/* 362 */         stringBuilder.append(paramString);
/* 363 */         stringBuilder.append(k);
/* 364 */         stringBuilder.append('=');
/* 365 */         stringBuilder.append(arrayOfInt[i]);
/*     */       } 
/* 367 */     }  if (paramBoolean) stringBuilder.append('}'); 
/* 368 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K> iterator() {
/* 372 */     return entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entries<K> entries() {
/* 377 */     return new Entries<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Values values() {
/* 382 */     return new Values(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 387 */     return new Keys<>(this);
/*     */   }
/*     */   
/*     */   public static class Entry<K> {
/*     */     public K key;
/*     */     public int value;
/*     */     
/*     */     public String toString() {
/* 395 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
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
/* 407 */       this.map = param1ObjectIntMap;
/* 408 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 412 */       this.currentIndex = -1;
/* 413 */       this.nextIndex = -1;
/* 414 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 419 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 420 */         if (arrayOfK[this.nextIndex] != null) {
/* 421 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 425 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 430 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 431 */       K[] arrayOfK = this.map.keyTable;
/* 432 */       int[] arrayOfInt = this.map.valueTable;
/* 433 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 435 */       while ((k1 = arrayOfK[k]) != null) {
/* 436 */         int m = this.map.place(k1);
/* 437 */         if ((k - m & j) > (i - m & j)) {
/* 438 */           arrayOfK[i] = k1;
/* 439 */           arrayOfInt[i] = arrayOfInt[k];
/* 440 */           i = k;
/*     */         } 
/* 442 */         k = k + 1 & j;
/*     */       } 
/* 444 */       arrayOfK[i] = null;
/* 445 */       this.map.size--;
/* 446 */       if (i != this.currentIndex) this.nextIndex--; 
/* 447 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K> extends MapIterator<K> implements Iterable<Entry<K>>, Iterator<Entry<K>> {
/* 452 */     ObjectIntMap.Entry<K> entry = new ObjectIntMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectIntMap<K> param1ObjectIntMap) {
/* 455 */       super(param1ObjectIntMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectIntMap.Entry<K> next() {
/* 460 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 461 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 462 */       K[] arrayOfK = this.map.keyTable;
/* 463 */       this.entry.key = arrayOfK[this.nextIndex];
/* 464 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 465 */       this.currentIndex = this.nextIndex;
/* 466 */       findNextIndex();
/* 467 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 471 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 472 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Entries<K> iterator() {
/* 476 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator<Object> {
/*     */     public Values(ObjectIntMap<?> param1ObjectIntMap) {
/* 482 */       super(param1ObjectIntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 486 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 487 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public int next() {
/* 491 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 492 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 493 */       int i = this.map.valueTable[this.nextIndex];
/* 494 */       this.currentIndex = this.nextIndex;
/* 495 */       findNextIndex();
/* 496 */       return i;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 500 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 505 */       IntArray intArray = new IntArray(true, this.map.size);
/* 506 */       while (this.hasNext)
/* 507 */         intArray.add(next()); 
/* 508 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 513 */       while (this.hasNext)
/* 514 */         param1IntArray.add(next()); 
/* 515 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K> implements Iterable<K>, Iterator<K> {
/*     */     public Keys(ObjectIntMap<K> param1ObjectIntMap) {
/* 521 */       super(param1ObjectIntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 525 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 526 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 530 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 531 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 532 */       K k = this.map.keyTable[this.nextIndex];
/* 533 */       this.currentIndex = this.nextIndex;
/* 534 */       findNextIndex();
/* 535 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 539 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<K> toList() {
/* 544 */       return toList(new ArrayList<>(this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public <T extends java.util.List<K>> T toList(T param1T) {
/* 549 */       while (this.hasNext)
/* 550 */         param1T.add(next()); 
/* 551 */       return param1T;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\ObjectIntMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */