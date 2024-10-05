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
/*     */ 
/*     */ public class IntFloatMap
/*     */   implements Iterable<IntFloatMap.Entry>
/*     */ {
/*     */   public int size;
/*     */   int[] keyTable;
/*     */   float[] valueTable;
/*     */   float zeroValue;
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
/*     */   public IntFloatMap() {
/*  74 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntFloatMap(int paramInt) {
/*  81 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntFloatMap(int paramInt, float paramFloat) {
/*  88 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  89 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  90 */     this.loadFactor = paramFloat;
/*     */     
/*  92 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  93 */     this.threshold = (int)(paramInt * paramFloat);
/*  94 */     this.mask = paramInt - 1;
/*  95 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  97 */     this.keyTable = new int[paramInt];
/*  98 */     this.valueTable = new float[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public IntFloatMap(IntFloatMap paramIntFloatMap) {
/* 103 */     this((int)(paramIntFloatMap.keyTable.length * paramIntFloatMap.loadFactor), paramIntFloatMap.loadFactor);
/* 104 */     System.arraycopy(paramIntFloatMap.keyTable, 0, this.keyTable, 0, paramIntFloatMap.keyTable.length);
/* 105 */     System.arraycopy(paramIntFloatMap.valueTable, 0, this.valueTable, 0, paramIntFloatMap.valueTable.length);
/* 106 */     this.size = paramIntFloatMap.size;
/* 107 */     this.zeroValue = paramIntFloatMap.zeroValue;
/* 108 */     this.hasZeroValue = paramIntFloatMap.hasZeroValue;
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
/* 126 */     return (int)(paramInt * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int locateKey(int paramInt) {
/* 132 */     int[] arrayOfInt = this.keyTable;
/* 133 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 135 */       if ((j = arrayOfInt[i]) == 0) return -(i + 1); 
/* 136 */       if (j == paramInt) return i; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(int paramInt, float paramFloat) {
/* 141 */     if (paramInt == 0) {
/* 142 */       this.zeroValue = paramFloat;
/* 143 */       if (!this.hasZeroValue) {
/* 144 */         this.hasZeroValue = true;
/* 145 */         this.size++;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     int i;
/* 150 */     if ((i = locateKey(paramInt)) >= 0) {
/* 151 */       this.valueTable[i] = paramFloat;
/*     */       return;
/*     */     } 
/* 154 */     i = -(i + 1);
/* 155 */     this.keyTable[i] = paramInt;
/* 156 */     this.valueTable[i] = paramFloat;
/* 157 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1);
/*     */   
/*     */   }
/*     */   
/*     */   public float put(int paramInt, float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 163 */     if (paramInt == 0) {
/* 164 */       float f1 = this.zeroValue;
/* 165 */       this.zeroValue = paramFloat1;
/* 166 */       if (!this.hasZeroValue) {
/* 167 */         this.hasZeroValue = true;
/* 168 */         this.size++;
/* 169 */         return paramFloat2;
/*     */       } 
/* 171 */       return f1;
/*     */     } 
/*     */     int i;
/* 174 */     if ((i = locateKey(paramInt)) >= 0) {
/* 175 */       f = this.valueTable[i];
/* 176 */       this.valueTable[i] = paramFloat1;
/* 177 */       return f;
/*     */     } 
/* 179 */     i = -(i + 1);
/* 180 */     this.keyTable[i] = f;
/* 181 */     this.valueTable[i] = paramFloat1;
/* 182 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 183 */     return paramFloat2;
/*     */   }
/*     */   
/*     */   public void putAll(IntFloatMap paramIntFloatMap) {
/* 187 */     ensureCapacity(paramIntFloatMap.size);
/* 188 */     if (paramIntFloatMap.hasZeroValue) put(0, paramIntFloatMap.zeroValue); 
/* 189 */     int[] arrayOfInt = paramIntFloatMap.keyTable;
/* 190 */     float[] arrayOfFloat = paramIntFloatMap.valueTable; byte b; int i;
/* 191 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 193 */       if ((j = arrayOfInt[b]) != 0) put(j, arrayOfFloat[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(int paramInt, float paramFloat) {
/* 199 */     int[] arrayOfInt = this.keyTable; int i;
/* 200 */     for (i = place(paramInt);; i = i + 1 & this.mask) {
/* 201 */       if (arrayOfInt[i] == 0) {
/* 202 */         arrayOfInt[i] = paramInt;
/* 203 */         this.valueTable[i] = paramFloat;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float get(int paramInt, float paramFloat) {
/* 211 */     if (paramInt == 0) return this.hasZeroValue ? this.zeroValue : paramFloat;
/*     */     
/* 213 */     return ((paramInt = locateKey(paramInt)) >= 0) ? this.valueTable[paramInt] : paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAndIncrement(int paramInt, float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 219 */     if (paramInt == 0) {
/* 220 */       if (!this.hasZeroValue) {
/* 221 */         this.hasZeroValue = true;
/* 222 */         this.zeroValue = paramFloat1 + paramFloat2;
/* 223 */         this.size++;
/* 224 */         return paramFloat1;
/*     */       } 
/* 226 */       float f1 = this.zeroValue;
/* 227 */       this.zeroValue += paramFloat2;
/* 228 */       return f1;
/*     */     } 
/*     */     int i;
/* 231 */     if ((i = locateKey(paramInt)) >= 0) {
/* 232 */       f = this.valueTable[i];
/* 233 */       this.valueTable[i] = this.valueTable[i] + paramFloat2;
/* 234 */       return f;
/*     */     } 
/* 236 */     i = -(i + 1);
/* 237 */     this.keyTable[i] = f;
/* 238 */     this.valueTable[i] = paramFloat1 + paramFloat2;
/* 239 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 240 */     return paramFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float remove(int paramInt, float paramFloat) {
/* 246 */     if (paramInt == 0) {
/* 247 */       if (!this.hasZeroValue) return paramFloat; 
/* 248 */       this.hasZeroValue = false;
/* 249 */       this.size--;
/* 250 */       return this.zeroValue;
/*     */     } 
/*     */     
/*     */     int i;
/* 254 */     if ((i = locateKey(paramInt)) < 0) return paramFloat; 
/* 255 */     int[] arrayOfInt = this.keyTable;
/*     */     
/* 257 */     float arrayOfFloat[], f = (arrayOfFloat = this.valueTable)[i];
/* 258 */     int j = this.mask, k = i + 1 & j;
/* 259 */     while ((paramInt = arrayOfInt[k]) != 0) {
/* 260 */       int m = place(paramInt);
/* 261 */       if ((k - m & j) > (i - m & j)) {
/* 262 */         arrayOfInt[i] = paramInt;
/* 263 */         arrayOfFloat[i] = arrayOfFloat[k];
/* 264 */         i = k;
/*     */       } 
/* 266 */       k = k + 1 & j;
/*     */     } 
/* 268 */     arrayOfInt[i] = 0;
/* 269 */     this.size--;
/* 270 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 275 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 280 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 287 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 288 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 289 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 294 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 295 */     if (this.keyTable.length <= paramInt) {
/* 296 */       clear();
/*     */       return;
/*     */     } 
/* 299 */     this.size = 0;
/* 300 */     this.hasZeroValue = false;
/* 301 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 305 */     if (this.size == 0)
/* 306 */       return;  Arrays.fill(this.keyTable, 0);
/* 307 */     this.size = 0;
/* 308 */     this.hasZeroValue = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(float paramFloat) {
/* 314 */     if (this.hasZeroValue && this.zeroValue == paramFloat) return true; 
/* 315 */     int[] arrayOfInt = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 317 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 318 */       if (arrayOfInt[i] != 0 && arrayOfFloat[i] == paramFloat) return true; 
/* 319 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(float paramFloat1, float paramFloat2) {
/* 325 */     if (this.hasZeroValue && Math.abs(this.zeroValue - paramFloat1) <= paramFloat2) return true; 
/* 326 */     int[] arrayOfInt = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 328 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 329 */       if (arrayOfInt[i] != 0 && Math.abs(arrayOfFloat[i] - paramFloat1) <= paramFloat2) return true; 
/* 330 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(int paramInt) {
/* 334 */     if (paramInt == 0) return this.hasZeroValue; 
/* 335 */     return (locateKey(paramInt) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int findKey(float paramFloat, int paramInt) {
/* 341 */     if (this.hasZeroValue && this.zeroValue == paramFloat) return 0; 
/* 342 */     int[] arrayOfInt = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 344 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 345 */       if (arrayOfInt[i] != 0 && arrayOfFloat[i] == paramFloat) return arrayOfInt[i]; 
/* 346 */     }  return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int findKey(float paramFloat1, float paramFloat2, int paramInt) {
/* 352 */     if (this.hasZeroValue && Math.abs(this.zeroValue - paramFloat1) <= paramFloat2) return 0; 
/* 353 */     int[] arrayOfInt = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 355 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 356 */       if (arrayOfInt[i] != 0 && Math.abs(arrayOfFloat[i] - paramFloat1) <= paramFloat2) return arrayOfInt[i]; 
/* 357 */     }  return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 363 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 364 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 368 */     int i = this.keyTable.length;
/* 369 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 370 */     this.mask = paramInt - 1;
/* 371 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 373 */     int[] arrayOfInt = this.keyTable;
/* 374 */     float[] arrayOfFloat = this.valueTable;
/*     */     
/* 376 */     this.keyTable = new int[paramInt];
/* 377 */     this.valueTable = new float[paramInt];
/*     */     
/* 379 */     if (this.size > 0)
/* 380 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         int j;
/* 382 */         if ((j = arrayOfInt[paramInt]) != 0) putResize(j, arrayOfFloat[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 388 */     int i = this.size;
/* 389 */     if (this.hasZeroValue) i += NumberUtils.floatToRawIntBits(this.zeroValue); 
/* 390 */     int[] arrayOfInt = this.keyTable;
/* 391 */     float[] arrayOfFloat = this.valueTable; byte b; int j;
/* 392 */     for (b = 0, j = arrayOfInt.length; b < j; b++) {
/*     */       int k;
/* 394 */       if ((k = arrayOfInt[b]) != 0) i += k * 31 + NumberUtils.floatToRawIntBits(arrayOfFloat[b]); 
/*     */     } 
/* 396 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 400 */     if (paramObject == this) return true; 
/* 401 */     if (!(paramObject instanceof IntFloatMap)) return false;
/*     */     
/* 403 */     if (((IntFloatMap)(paramObject = paramObject)).size != this.size) return false; 
/* 404 */     if (((IntFloatMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 405 */     if (this.hasZeroValue && 
/* 406 */       ((IntFloatMap)paramObject).zeroValue != this.zeroValue) return false;
/*     */     
/* 408 */     int[] arrayOfInt = this.keyTable;
/* 409 */     float[] arrayOfFloat = this.valueTable; byte b; int i;
/* 410 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 412 */       if ((j = arrayOfInt[b]) != 0) {
/*     */         float f;
/* 414 */         if ((f = paramObject.get(j, 0.0F)) == 0.0F && !paramObject.containsKey(j)) return false; 
/* 415 */         if (f != arrayOfFloat[b]) return false; 
/*     */       } 
/*     */     } 
/* 418 */     return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 422 */     if (this.size == 0) return "[]"; 
/*     */     java.lang.StringBuilder stringBuilder;
/* 424 */     (stringBuilder = new java.lang.StringBuilder(32)).append('[');
/* 425 */     int[] arrayOfInt = this.keyTable;
/* 426 */     float[] arrayOfFloat = this.valueTable;
/* 427 */     int i = arrayOfInt.length;
/* 428 */     if (this.hasZeroValue) {
/* 429 */       stringBuilder.append("0=");
/* 430 */       stringBuilder.append(this.zeroValue);
/*     */     } else {
/* 432 */       while (i-- > 0) {
/*     */         int j;
/* 434 */         if ((j = arrayOfInt[i]) != 0) {
/* 435 */           stringBuilder.append(j);
/* 436 */           stringBuilder.append('=');
/* 437 */           stringBuilder.append(arrayOfFloat[i]); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 441 */     while (i-- > 0) {
/*     */       int j;
/* 443 */       if ((j = arrayOfInt[i]) != 0) {
/* 444 */         stringBuilder.append(", ");
/* 445 */         stringBuilder.append(j);
/* 446 */         stringBuilder.append('=');
/* 447 */         stringBuilder.append(arrayOfFloat[i]);
/*     */       } 
/* 449 */     }  stringBuilder.append(']');
/* 450 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<Entry> iterator() {
/* 454 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries entries() {
/* 462 */     if (Collections.allocateIterators) return new Entries(this); 
/* 463 */     if (this.entries1 == null) {
/* 464 */       this.entries1 = new Entries(this);
/* 465 */       this.entries2 = new Entries(this);
/*     */     } 
/* 467 */     if (!this.entries1.valid) {
/* 468 */       this.entries1.reset();
/* 469 */       this.entries1.valid = true;
/* 470 */       this.entries2.valid = false;
/* 471 */       return this.entries1;
/*     */     } 
/* 473 */     this.entries2.reset();
/* 474 */     this.entries2.valid = true;
/* 475 */     this.entries1.valid = false;
/* 476 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values values() {
/* 484 */     if (Collections.allocateIterators) return new Values(this); 
/* 485 */     if (this.values1 == null) {
/* 486 */       this.values1 = new Values(this);
/* 487 */       this.values2 = new Values(this);
/*     */     } 
/* 489 */     if (!this.values1.valid) {
/* 490 */       this.values1.reset();
/* 491 */       this.values1.valid = true;
/* 492 */       this.values2.valid = false;
/* 493 */       return this.values1;
/*     */     } 
/* 495 */     this.values2.reset();
/* 496 */     this.values2.valid = true;
/* 497 */     this.values1.valid = false;
/* 498 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys keys() {
/* 506 */     if (Collections.allocateIterators) return new Keys(this); 
/* 507 */     if (this.keys1 == null) {
/* 508 */       this.keys1 = new Keys(this);
/* 509 */       this.keys2 = new Keys(this);
/*     */     } 
/* 511 */     if (!this.keys1.valid) {
/* 512 */       this.keys1.reset();
/* 513 */       this.keys1.valid = true;
/* 514 */       this.keys2.valid = false;
/* 515 */       return this.keys1;
/*     */     } 
/* 517 */     this.keys2.reset();
/* 518 */     this.keys2.valid = true;
/* 519 */     this.keys1.valid = false;
/* 520 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry {
/*     */     public int key;
/*     */     public float value;
/*     */     
/*     */     public String toString() {
/* 528 */       return this.key + "=" + this.value;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator
/*     */   {
/*     */     private static final int INDEX_ILLEGAL = -2;
/*     */     static final int INDEX_ZERO = -1;
/*     */     public boolean hasNext;
/*     */     final IntFloatMap map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(IntFloatMap param1IntFloatMap) {
/* 543 */       this.map = param1IntFloatMap;
/* 544 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 548 */       this.currentIndex = -2;
/* 549 */       this.nextIndex = -1;
/* 550 */       if (this.map.hasZeroValue) {
/* 551 */         this.hasNext = true; return;
/*     */       } 
/* 553 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       int[] arrayOfInt;
/* 558 */       for (int i = (arrayOfInt = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 559 */         if (arrayOfInt[this.nextIndex] != 0) {
/* 560 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 564 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 569 */       if ((i = this.currentIndex) == -1 && this.map.hasZeroValue)
/* 570 */       { this.map.hasZeroValue = false; }
/* 571 */       else { if (i < 0) {
/* 572 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 574 */         int[] arrayOfInt = this.map.keyTable;
/* 575 */         float[] arrayOfFloat = this.map.valueTable;
/* 576 */         int j = this.map.mask, k = i + 1 & j; int m;
/* 577 */         while ((m = arrayOfInt[k]) != 0) {
/* 578 */           int n = this.map.place(m);
/* 579 */           if ((k - n & j) > (i - n & j)) {
/* 580 */             arrayOfInt[i] = m;
/* 581 */             arrayOfFloat[i] = arrayOfFloat[k];
/* 582 */             i = k;
/*     */           } 
/* 584 */           k = k + 1 & j;
/*     */         } 
/* 586 */         arrayOfInt[i] = 0;
/* 587 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 589 */       this.currentIndex = -2;
/* 590 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries extends MapIterator implements Iterable<Entry>, Iterator<Entry> {
/* 595 */     private final IntFloatMap.Entry entry = new IntFloatMap.Entry();
/*     */     
/*     */     public Entries(IntFloatMap param1IntFloatMap) {
/* 598 */       super(param1IntFloatMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public IntFloatMap.Entry next() {
/* 603 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 604 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 605 */       int[] arrayOfInt = this.map.keyTable;
/* 606 */       if (this.nextIndex == -1) {
/* 607 */         this.entry.key = 0;
/* 608 */         this.entry.value = this.map.zeroValue;
/*     */       } else {
/* 610 */         this.entry.key = arrayOfInt[this.nextIndex];
/* 611 */         this.entry.value = this.map.valueTable[this.nextIndex];
/*     */       } 
/* 613 */       this.currentIndex = this.nextIndex;
/* 614 */       findNextIndex();
/* 615 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 619 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 620 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Iterator<IntFloatMap.Entry> iterator() {
/* 624 */       return this;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 628 */       super.remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator {
/*     */     public Values(IntFloatMap param1IntFloatMap) {
/* 634 */       super(param1IntFloatMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 638 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 639 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public float next() {
/* 643 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 644 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 645 */       float f = (this.nextIndex == -1) ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
/* 646 */       this.currentIndex = this.nextIndex;
/* 647 */       findNextIndex();
/* 648 */       return f;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 652 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public FloatArray toArray() {
/* 657 */       FloatArray floatArray = new FloatArray(true, this.map.size);
/* 658 */       while (this.hasNext)
/* 659 */         floatArray.add(next()); 
/* 660 */       return floatArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public FloatArray toArray(FloatArray param1FloatArray) {
/* 665 */       while (this.hasNext)
/* 666 */         param1FloatArray.add(next()); 
/* 667 */       return param1FloatArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys extends MapIterator {
/*     */     public Keys(IntFloatMap param1IntFloatMap) {
/* 673 */       super(param1IntFloatMap);
/*     */     }
/*     */     
/*     */     public int next() {
/* 677 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 678 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 679 */       boolean bool = (this.nextIndex == -1) ? false : this.map.keyTable[this.nextIndex];
/* 680 */       this.currentIndex = this.nextIndex;
/* 681 */       findNextIndex();
/* 682 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 687 */       IntArray intArray = new IntArray(true, this.map.size);
/* 688 */       while (this.hasNext)
/* 689 */         intArray.add(next()); 
/* 690 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 695 */       while (this.hasNext)
/* 696 */         param1IntArray.add(next()); 
/* 697 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IntFloatMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */