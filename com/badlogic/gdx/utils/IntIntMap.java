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
/*     */ public class IntIntMap
/*     */   implements Iterable<IntIntMap.Entry>
/*     */ {
/*     */   public int size;
/*     */   int[] keyTable;
/*     */   int[] valueTable;
/*     */   int zeroValue;
/*     */   boolean hasZeroValue;
/*     */   private final float loadFactor;
/*     */   private int threshold;
/*     */   protected int shift;
/*     */   protected int mask;
/*     */   private transient Entries entries1;
/*     */   private transient Entries entries2;
/*     */   private transient Values values1;
/*     */   private transient Values values2;
/*     */   private transient Keys keys1;
/*     */   private transient Keys keys2;
/*     */   
/*     */   public IntIntMap() {
/*  73 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntIntMap(int paramInt) {
/*  79 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntIntMap(int paramInt, float paramFloat) {
/*  86 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  87 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  88 */     this.loadFactor = paramFloat;
/*     */     
/*  90 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  91 */     this.threshold = (int)(paramInt * paramFloat);
/*  92 */     this.mask = paramInt - 1;
/*  93 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  95 */     this.keyTable = new int[paramInt];
/*  96 */     this.valueTable = new int[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public IntIntMap(IntIntMap paramIntIntMap) {
/* 101 */     this((int)(paramIntIntMap.keyTable.length * paramIntIntMap.loadFactor), paramIntIntMap.loadFactor);
/* 102 */     System.arraycopy(paramIntIntMap.keyTable, 0, this.keyTable, 0, paramIntIntMap.keyTable.length);
/* 103 */     System.arraycopy(paramIntIntMap.valueTable, 0, this.valueTable, 0, paramIntIntMap.valueTable.length);
/* 104 */     this.size = paramIntIntMap.size;
/* 105 */     this.zeroValue = paramIntIntMap.zeroValue;
/* 106 */     this.hasZeroValue = paramIntIntMap.hasZeroValue;
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
/*     */   protected int place(int paramInt) {
/* 124 */     return (int)(paramInt * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int locateKey(int paramInt) {
/* 130 */     int[] arrayOfInt = this.keyTable;
/* 131 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 133 */       if ((j = arrayOfInt[i]) == 0) return -(i + 1); 
/* 134 */       if (j == paramInt) return i; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(int paramInt1, int paramInt2) {
/* 139 */     if (paramInt1 == 0) {
/* 140 */       this.zeroValue = paramInt2;
/* 141 */       if (!this.hasZeroValue) {
/* 142 */         this.hasZeroValue = true;
/* 143 */         this.size++;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     int i;
/* 148 */     if ((i = locateKey(paramInt1)) >= 0) {
/* 149 */       this.valueTable[i] = paramInt2;
/*     */       return;
/*     */     } 
/* 152 */     i = -(i + 1);
/* 153 */     this.keyTable[i] = paramInt1;
/* 154 */     this.valueTable[i] = paramInt2;
/* 155 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1);
/*     */   
/*     */   }
/*     */   
/*     */   public int put(int paramInt1, int paramInt2, int paramInt3) {
/* 160 */     if (paramInt1 == 0) {
/* 161 */       int j = this.zeroValue;
/* 162 */       this.zeroValue = paramInt2;
/* 163 */       if (!this.hasZeroValue) {
/* 164 */         this.hasZeroValue = true;
/* 165 */         this.size++;
/* 166 */         return paramInt3;
/*     */       } 
/* 168 */       return j;
/*     */     } 
/*     */     int i;
/* 171 */     if ((i = locateKey(paramInt1)) >= 0) {
/* 172 */       paramInt1 = this.valueTable[i];
/* 173 */       this.valueTable[i] = paramInt2;
/* 174 */       return paramInt1;
/*     */     } 
/* 176 */     i = -(i + 1);
/* 177 */     this.keyTable[i] = paramInt1;
/* 178 */     this.valueTable[i] = paramInt2;
/* 179 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 180 */     return paramInt3;
/*     */   }
/*     */   
/*     */   public void putAll(IntIntMap paramIntIntMap) {
/* 184 */     ensureCapacity(paramIntIntMap.size);
/* 185 */     if (paramIntIntMap.hasZeroValue) put(0, paramIntIntMap.zeroValue); 
/* 186 */     int[] arrayOfInt2 = paramIntIntMap.keyTable;
/* 187 */     int[] arrayOfInt1 = paramIntIntMap.valueTable; byte b; int i;
/* 188 */     for (b = 0, i = arrayOfInt2.length; b < i; b++) {
/*     */       int j;
/* 190 */       if ((j = arrayOfInt2[b]) != 0) put(j, arrayOfInt1[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(int paramInt1, int paramInt2) {
/* 196 */     int[] arrayOfInt = this.keyTable; int i;
/* 197 */     for (i = place(paramInt1);; i = i + 1 & this.mask) {
/* 198 */       if (arrayOfInt[i] == 0) {
/* 199 */         arrayOfInt[i] = paramInt1;
/* 200 */         this.valueTable[i] = paramInt2;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int get(int paramInt1, int paramInt2) {
/* 207 */     if (paramInt1 == 0) return this.hasZeroValue ? this.zeroValue : paramInt2;
/*     */     
/* 209 */     return ((paramInt1 = locateKey(paramInt1)) >= 0) ? this.valueTable[paramInt1] : paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAndIncrement(int paramInt1, int paramInt2, int paramInt3) {
/* 215 */     if (paramInt1 == 0) {
/* 216 */       if (!this.hasZeroValue) {
/* 217 */         this.hasZeroValue = true;
/* 218 */         this.zeroValue = paramInt2 + paramInt3;
/* 219 */         this.size++;
/* 220 */         return paramInt2;
/*     */       } 
/* 222 */       int j = this.zeroValue;
/* 223 */       this.zeroValue += paramInt3;
/* 224 */       return j;
/*     */     } 
/*     */     int i;
/* 227 */     if ((i = locateKey(paramInt1)) >= 0) {
/* 228 */       paramInt1 = this.valueTable[i];
/* 229 */       this.valueTable[i] = this.valueTable[i] + paramInt3;
/* 230 */       return paramInt1;
/*     */     } 
/* 232 */     i = -(i + 1);
/* 233 */     this.keyTable[i] = paramInt1;
/* 234 */     this.valueTable[i] = paramInt2 + paramInt3;
/* 235 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 236 */     return paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(int paramInt1, int paramInt2) {
/* 241 */     if (paramInt1 == 0) {
/* 242 */       if (!this.hasZeroValue) return paramInt2; 
/* 243 */       this.hasZeroValue = false;
/* 244 */       this.size--;
/* 245 */       return this.zeroValue;
/*     */     } 
/*     */     
/*     */     int i;
/* 249 */     if ((i = locateKey(paramInt1)) < 0) return paramInt2; 
/* 250 */     int[] arrayOfInt1 = this.keyTable;
/*     */     
/* 252 */     int arrayOfInt2[], j = (arrayOfInt2 = this.valueTable)[i], k = this.mask, m = i + 1 & k;
/* 253 */     while ((paramInt1 = arrayOfInt1[m]) != 0) {
/* 254 */       int n = place(paramInt1);
/* 255 */       if ((m - n & k) > (i - n & k)) {
/* 256 */         arrayOfInt1[i] = paramInt1;
/* 257 */         arrayOfInt2[i] = arrayOfInt2[m];
/* 258 */         i = m;
/*     */       } 
/* 260 */       m = m + 1 & k;
/*     */     } 
/* 262 */     arrayOfInt1[i] = 0;
/* 263 */     this.size--;
/* 264 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 269 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 274 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 281 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 282 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 283 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 288 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 289 */     if (this.keyTable.length <= paramInt) {
/* 290 */       clear();
/*     */       return;
/*     */     } 
/* 293 */     this.size = 0;
/* 294 */     this.hasZeroValue = false;
/* 295 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 299 */     if (this.size == 0)
/* 300 */       return;  Arrays.fill(this.keyTable, 0);
/* 301 */     this.size = 0;
/* 302 */     this.hasZeroValue = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(int paramInt) {
/* 308 */     if (this.hasZeroValue && this.zeroValue == paramInt) return true; 
/* 309 */     int[] arrayOfInt1 = this.keyTable;
/*     */     int[] arrayOfInt2;
/* 311 */     for (int i = (arrayOfInt2 = this.valueTable).length - 1; i >= 0; i--) {
/* 312 */       if (arrayOfInt1[i] != 0 && arrayOfInt2[i] == paramInt) return true; 
/* 313 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(int paramInt) {
/* 317 */     if (paramInt == 0) return this.hasZeroValue; 
/* 318 */     return (locateKey(paramInt) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int findKey(int paramInt1, int paramInt2) {
/* 324 */     if (this.hasZeroValue && this.zeroValue == paramInt1) return 0; 
/* 325 */     int[] arrayOfInt1 = this.keyTable;
/*     */     int[] arrayOfInt2;
/* 327 */     for (int i = (arrayOfInt2 = this.valueTable).length - 1; i >= 0; i--) {
/*     */       int j;
/* 329 */       if ((j = arrayOfInt1[i]) != 0 && arrayOfInt2[i] == paramInt1) return j; 
/*     */     } 
/* 331 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 337 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 338 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 342 */     int i = this.keyTable.length;
/* 343 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 344 */     this.mask = paramInt - 1;
/* 345 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 347 */     int[] arrayOfInt1 = this.keyTable;
/* 348 */     int[] arrayOfInt2 = this.valueTable;
/*     */     
/* 350 */     this.keyTable = new int[paramInt];
/* 351 */     this.valueTable = new int[paramInt];
/*     */     
/* 353 */     if (this.size > 0)
/* 354 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         int j;
/* 356 */         if ((j = arrayOfInt1[paramInt]) != 0) putResize(j, arrayOfInt2[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 362 */     int i = this.size;
/* 363 */     if (this.hasZeroValue) i += this.zeroValue; 
/* 364 */     int[] arrayOfInt1 = this.keyTable;
/* 365 */     int[] arrayOfInt2 = this.valueTable; byte b; int j;
/* 366 */     for (b = 0, j = arrayOfInt1.length; b < j; b++) {
/*     */       int k;
/* 368 */       if ((k = arrayOfInt1[b]) != 0) i += k * 31 + arrayOfInt2[b]; 
/*     */     } 
/* 370 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 374 */     if (paramObject == this) return true; 
/* 375 */     if (!(paramObject instanceof IntIntMap)) return false;
/*     */     
/* 377 */     if (((IntIntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 378 */     if (((IntIntMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 379 */     if (this.hasZeroValue && 
/* 380 */       ((IntIntMap)paramObject).zeroValue != this.zeroValue) return false;
/*     */     
/* 382 */     int[] arrayOfInt1 = this.keyTable;
/* 383 */     int[] arrayOfInt2 = this.valueTable; byte b; int i;
/* 384 */     for (b = 0, i = arrayOfInt1.length; b < i; b++) {
/*     */       int j;
/* 386 */       if ((j = arrayOfInt1[b]) != 0) {
/*     */         int k;
/* 388 */         if ((k = paramObject.get(j, 0)) == 0 && !paramObject.containsKey(j)) return false; 
/* 389 */         if (k != arrayOfInt2[b]) return false; 
/*     */       } 
/*     */     } 
/* 392 */     return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 396 */     if (this.size == 0) return "[]"; 
/*     */     java.lang.StringBuilder stringBuilder;
/* 398 */     (stringBuilder = new java.lang.StringBuilder(32)).append('[');
/* 399 */     int[] arrayOfInt1 = this.keyTable;
/* 400 */     int[] arrayOfInt2 = this.valueTable;
/* 401 */     int i = arrayOfInt1.length;
/* 402 */     if (this.hasZeroValue) {
/* 403 */       stringBuilder.append("0=");
/* 404 */       stringBuilder.append(this.zeroValue);
/*     */     } else {
/* 406 */       while (i-- > 0) {
/*     */         int j;
/* 408 */         if ((j = arrayOfInt1[i]) != 0) {
/* 409 */           stringBuilder.append(j);
/* 410 */           stringBuilder.append('=');
/* 411 */           stringBuilder.append(arrayOfInt2[i]); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 415 */     while (i-- > 0) {
/*     */       int j;
/* 417 */       if ((j = arrayOfInt1[i]) != 0) {
/* 418 */         stringBuilder.append(", ");
/* 419 */         stringBuilder.append(j);
/* 420 */         stringBuilder.append('=');
/* 421 */         stringBuilder.append(arrayOfInt2[i]);
/*     */       } 
/* 423 */     }  stringBuilder.append(']');
/* 424 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<Entry> iterator() {
/* 428 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries entries() {
/* 436 */     if (Collections.allocateIterators) return new Entries(this); 
/* 437 */     if (this.entries1 == null) {
/* 438 */       this.entries1 = new Entries(this);
/* 439 */       this.entries2 = new Entries(this);
/*     */     } 
/* 441 */     if (!this.entries1.valid) {
/* 442 */       this.entries1.reset();
/* 443 */       this.entries1.valid = true;
/* 444 */       this.entries2.valid = false;
/* 445 */       return this.entries1;
/*     */     } 
/* 447 */     this.entries2.reset();
/* 448 */     this.entries2.valid = true;
/* 449 */     this.entries1.valid = false;
/* 450 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values values() {
/* 458 */     if (Collections.allocateIterators) return new Values(this); 
/* 459 */     if (this.values1 == null) {
/* 460 */       this.values1 = new Values(this);
/* 461 */       this.values2 = new Values(this);
/*     */     } 
/* 463 */     if (!this.values1.valid) {
/* 464 */       this.values1.reset();
/* 465 */       this.values1.valid = true;
/* 466 */       this.values2.valid = false;
/* 467 */       return this.values1;
/*     */     } 
/* 469 */     this.values2.reset();
/* 470 */     this.values2.valid = true;
/* 471 */     this.values1.valid = false;
/* 472 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys keys() {
/* 480 */     if (Collections.allocateIterators) return new Keys(this); 
/* 481 */     if (this.keys1 == null) {
/* 482 */       this.keys1 = new Keys(this);
/* 483 */       this.keys2 = new Keys(this);
/*     */     } 
/* 485 */     if (!this.keys1.valid) {
/* 486 */       this.keys1.reset();
/* 487 */       this.keys1.valid = true;
/* 488 */       this.keys2.valid = false;
/* 489 */       return this.keys1;
/*     */     } 
/* 491 */     this.keys2.reset();
/* 492 */     this.keys2.valid = true;
/* 493 */     this.keys1.valid = false;
/* 494 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry {
/*     */     public int key;
/*     */     public int value;
/*     */     
/*     */     public String toString() {
/* 502 */       return this.key + "=" + this.value;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator
/*     */   {
/*     */     private static final int INDEX_ILLEGAL = -2;
/*     */     static final int INDEX_ZERO = -1;
/*     */     public boolean hasNext;
/*     */     final IntIntMap map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(IntIntMap param1IntIntMap) {
/* 517 */       this.map = param1IntIntMap;
/* 518 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 522 */       this.currentIndex = -2;
/* 523 */       this.nextIndex = -1;
/* 524 */       if (this.map.hasZeroValue) {
/* 525 */         this.hasNext = true; return;
/*     */       } 
/* 527 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       int[] arrayOfInt;
/* 532 */       for (int i = (arrayOfInt = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 533 */         if (arrayOfInt[this.nextIndex] != 0) {
/* 534 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 538 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 543 */       if ((i = this.currentIndex) == -1 && this.map.hasZeroValue)
/* 544 */       { this.map.hasZeroValue = false; }
/* 545 */       else { if (i < 0) {
/* 546 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 548 */         int[] arrayOfInt1 = this.map.keyTable;
/* 549 */         int[] arrayOfInt2 = this.map.valueTable;
/* 550 */         int j = this.map.mask, k = i + 1 & j; int m;
/* 551 */         while ((m = arrayOfInt1[k]) != 0) {
/* 552 */           int n = this.map.place(m);
/* 553 */           if ((k - n & j) > (i - n & j)) {
/* 554 */             arrayOfInt1[i] = m;
/* 555 */             arrayOfInt2[i] = arrayOfInt2[k];
/* 556 */             i = k;
/*     */           } 
/* 558 */           k = k + 1 & j;
/*     */         } 
/* 560 */         arrayOfInt1[i] = 0;
/* 561 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 563 */       this.currentIndex = -2;
/* 564 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries extends MapIterator implements Iterable<Entry>, Iterator<Entry> {
/* 569 */     private final IntIntMap.Entry entry = new IntIntMap.Entry();
/*     */     
/*     */     public Entries(IntIntMap param1IntIntMap) {
/* 572 */       super(param1IntIntMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public IntIntMap.Entry next() {
/* 577 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 578 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 579 */       int[] arrayOfInt = this.map.keyTable;
/* 580 */       if (this.nextIndex == -1) {
/* 581 */         this.entry.key = 0;
/* 582 */         this.entry.value = this.map.zeroValue;
/*     */       } else {
/* 584 */         this.entry.key = arrayOfInt[this.nextIndex];
/* 585 */         this.entry.value = this.map.valueTable[this.nextIndex];
/*     */       } 
/* 587 */       this.currentIndex = this.nextIndex;
/* 588 */       findNextIndex();
/* 589 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 593 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 594 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Iterator<IntIntMap.Entry> iterator() {
/* 598 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator {
/*     */     public Values(IntIntMap param1IntIntMap) {
/* 604 */       super(param1IntIntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 608 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 609 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public int next() {
/* 613 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 614 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 615 */       int i = (this.nextIndex == -1) ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
/* 616 */       this.currentIndex = this.nextIndex;
/* 617 */       findNextIndex();
/* 618 */       return i;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 622 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 627 */       IntArray intArray = new IntArray(true, this.map.size);
/* 628 */       while (this.hasNext)
/* 629 */         intArray.add(next()); 
/* 630 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 635 */       while (this.hasNext)
/* 636 */         param1IntArray.add(next()); 
/* 637 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys extends MapIterator {
/*     */     public Keys(IntIntMap param1IntIntMap) {
/* 643 */       super(param1IntIntMap);
/*     */     }
/*     */     
/*     */     public int next() {
/* 647 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 648 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 649 */       boolean bool = (this.nextIndex == -1) ? false : this.map.keyTable[this.nextIndex];
/* 650 */       this.currentIndex = this.nextIndex;
/* 651 */       findNextIndex();
/* 652 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 657 */       IntArray intArray = new IntArray(true, this.map.size);
/* 658 */       while (this.hasNext)
/* 659 */         intArray.add(next()); 
/* 660 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 665 */       while (this.hasNext)
/* 666 */         param1IntArray.add(next()); 
/* 667 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IntIntMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */