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
/*     */ public class ObjectFloatMap<K>
/*     */   implements Iterable<ObjectFloatMap.Entry<K>>
/*     */ {
/*     */   public int size;
/*     */   K[] keyTable;
/*     */   float[] valueTable;
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
/*     */   public ObjectFloatMap() {
/*  71 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectFloatMap(int paramInt) {
/*  77 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectFloatMap(int paramInt, float paramFloat) {
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
/*  94 */     this.valueTable = new float[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectFloatMap(ObjectFloatMap<? extends K> paramObjectFloatMap) {
/*  99 */     this((int)Math.floor((paramObjectFloatMap.keyTable.length * paramObjectFloatMap.loadFactor)), paramObjectFloatMap.loadFactor);
/* 100 */     System.arraycopy(paramObjectFloatMap.keyTable, 0, this.keyTable, 0, paramObjectFloatMap.keyTable.length);
/* 101 */     System.arraycopy(paramObjectFloatMap.valueTable, 0, this.valueTable, 0, paramObjectFloatMap.valueTable.length);
/* 102 */     this.size = paramObjectFloatMap.size;
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
/*     */   public void put(K paramK, float paramFloat) {
/*     */     int i;
/* 137 */     if ((i = locateKey(paramK)) >= 0) {
/* 138 */       this.valueTable[i] = paramFloat;
/*     */       return;
/*     */     } 
/* 141 */     i = -(i + 1);
/* 142 */     this.keyTable[i] = paramK;
/* 143 */     this.valueTable[i] = paramFloat;
/* 144 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1);
/*     */   
/*     */   }
/*     */   
/*     */   public float put(K paramK, float paramFloat1, float paramFloat2) {
/*     */     float f;
/*     */     int i;
/* 151 */     if ((i = locateKey(paramK)) >= 0) {
/* 152 */       f = this.valueTable[i];
/* 153 */       this.valueTable[i] = paramFloat1;
/* 154 */       return f;
/*     */     } 
/* 156 */     i = -(i + 1);
/* 157 */     this.keyTable[i] = f;
/* 158 */     this.valueTable[i] = paramFloat1;
/* 159 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 160 */     return paramFloat2;
/*     */   }
/*     */   
/*     */   public void putAll(ObjectFloatMap<? extends K> paramObjectFloatMap) {
/* 164 */     ensureCapacity(paramObjectFloatMap.size);
/* 165 */     K[] arrayOfK = paramObjectFloatMap.keyTable;
/* 166 */     float[] arrayOfFloat = paramObjectFloatMap.valueTable; byte b;
/*     */     int i;
/* 168 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 170 */       if ((k = arrayOfK[b]) != null) put(k, arrayOfFloat[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, float paramFloat) {
/* 176 */     K[] arrayOfK = this.keyTable; int i;
/* 177 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 178 */       if (arrayOfK[i] == null) {
/* 179 */         arrayOfK[i] = paramK;
/* 180 */         this.valueTable[i] = paramFloat;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float get(K paramK, float paramFloat) {
/*     */     int i;
/* 190 */     return ((i = locateKey(paramK)) < 0) ? paramFloat : this.valueTable[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAndIncrement(K paramK, float paramFloat1, float paramFloat2) {
/*     */     float f;
/*     */     int i;
/* 197 */     if ((i = locateKey(paramK)) >= 0) {
/* 198 */       f = this.valueTable[i];
/* 199 */       this.valueTable[i] = this.valueTable[i] + paramFloat2;
/* 200 */       return f;
/*     */     } 
/* 202 */     i = -(i + 1);
/* 203 */     this.keyTable[i] = f;
/* 204 */     this.valueTable[i] = paramFloat1 + paramFloat2;
/* 205 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 206 */     return paramFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float remove(K paramK, float paramFloat) {
/*     */     int i;
/* 213 */     if ((i = locateKey(paramK)) < 0) return paramFloat; 
/* 214 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 216 */     float arrayOfFloat[], f = (arrayOfFloat = this.valueTable)[i];
/* 217 */     int j = this.mask, k = i + 1 & j;
/* 218 */     while ((paramK = arrayOfK[k]) != null) {
/* 219 */       int m = place(paramK);
/* 220 */       if ((k - m & j) > (i - m & j)) {
/* 221 */         arrayOfK[i] = paramK;
/* 222 */         arrayOfFloat[i] = arrayOfFloat[k];
/* 223 */         i = k;
/*     */       } 
/* 225 */       k = k + 1 & j;
/*     */     } 
/* 227 */     arrayOfK[i] = null;
/* 228 */     this.size--;
/* 229 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 234 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 239 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 246 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 247 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 248 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 253 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 254 */     if (this.keyTable.length <= paramInt) {
/* 255 */       clear();
/*     */       return;
/*     */     } 
/* 258 */     this.size = 0;
/* 259 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 263 */     if (this.size == 0)
/* 264 */       return;  this.size = 0;
/* 265 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(float paramFloat) {
/* 271 */     K[] arrayOfK = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 273 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 274 */       if (arrayOfK[i] != null && arrayOfFloat[i] == paramFloat) return true; 
/* 275 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(float paramFloat1, float paramFloat2) {
/* 281 */     K[] arrayOfK = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 283 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/* 284 */       if (arrayOfK[i] != null && Math.abs(arrayOfFloat[i] - paramFloat1) <= paramFloat2) return true; 
/* 285 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean containsKey(K paramK) {
/* 289 */     return (locateKey(paramK) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public K findKey(float paramFloat) {
/* 295 */     K[] arrayOfK = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 297 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/*     */       K k;
/* 299 */       if ((k = arrayOfK[i]) != null && arrayOfFloat[i] == paramFloat) return k; 
/*     */     } 
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public K findKey(float paramFloat1, float paramFloat2) {
/* 307 */     K[] arrayOfK = this.keyTable;
/*     */     float[] arrayOfFloat;
/* 309 */     for (int i = (arrayOfFloat = this.valueTable).length - 1; i >= 0; i--) {
/*     */       K k;
/* 311 */       if ((k = arrayOfK[i]) != null && Math.abs(arrayOfFloat[i] - paramFloat1) <= paramFloat2) return k; 
/*     */     } 
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 319 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 320 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   final void resize(int paramInt) {
/* 324 */     int i = this.keyTable.length;
/* 325 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 326 */     this.mask = paramInt - 1;
/* 327 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 329 */     K[] arrayOfK = this.keyTable;
/* 330 */     float[] arrayOfFloat = this.valueTable;
/*     */     
/* 332 */     this.keyTable = (K[])new Object[paramInt];
/* 333 */     this.valueTable = new float[paramInt];
/*     */     
/* 335 */     if (this.size > 0)
/* 336 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 338 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfFloat[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 344 */     int i = this.size;
/* 345 */     K[] arrayOfK = this.keyTable;
/* 346 */     float[] arrayOfFloat = this.valueTable; byte b; int j;
/* 347 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */       K k;
/* 349 */       if ((k = arrayOfK[b]) != null) i += k.hashCode() + NumberUtils.floatToRawIntBits(arrayOfFloat[b]); 
/*     */     } 
/* 351 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 355 */     if (paramObject == this) return true; 
/* 356 */     if (!(paramObject instanceof ObjectFloatMap)) return false;
/*     */     
/* 358 */     if (((ObjectFloatMap)(paramObject = paramObject)).size != this.size) return false; 
/* 359 */     K[] arrayOfK = this.keyTable;
/* 360 */     float[] arrayOfFloat = this.valueTable; byte b; int i;
/* 361 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 363 */       if ((k = arrayOfK[b]) != null) {
/*     */         float f;
/* 365 */         if ((f = paramObject.get(k, 0.0F)) == 0.0F && !paramObject.containsKey(k)) return false; 
/* 366 */         if (f != arrayOfFloat[b]) return false; 
/*     */       } 
/*     */     } 
/* 369 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 373 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 377 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   private String toString(String paramString, boolean paramBoolean) {
/* 381 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 382 */     java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(32);
/* 383 */     if (paramBoolean) stringBuilder.append('{'); 
/* 384 */     K[] arrayOfK = this.keyTable;
/* 385 */     float[] arrayOfFloat = this.valueTable;
/* 386 */     int i = arrayOfK.length;
/* 387 */     while (i-- > 0) {
/*     */       K k;
/* 389 */       if ((k = arrayOfK[i]) != null) {
/* 390 */         stringBuilder.append(k);
/* 391 */         stringBuilder.append('=');
/* 392 */         stringBuilder.append(arrayOfFloat[i]); break;
/*     */       } 
/*     */     } 
/* 395 */     while (i-- > 0) {
/*     */       K k;
/* 397 */       if ((k = arrayOfK[i]) != null) {
/* 398 */         stringBuilder.append(paramString);
/* 399 */         stringBuilder.append(k);
/* 400 */         stringBuilder.append('=');
/* 401 */         stringBuilder.append(arrayOfFloat[i]);
/*     */       } 
/* 403 */     }  if (paramBoolean) stringBuilder.append('}'); 
/* 404 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K> iterator() {
/* 408 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<K> entries() {
/* 416 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 417 */     if (this.entries1 == null) {
/* 418 */       this.entries1 = new Entries(this);
/* 419 */       this.entries2 = new Entries(this);
/*     */     } 
/* 421 */     if (!this.entries1.valid) {
/* 422 */       this.entries1.reset();
/* 423 */       this.entries1.valid = true;
/* 424 */       this.entries2.valid = false;
/* 425 */       return this.entries1;
/*     */     } 
/* 427 */     this.entries2.reset();
/* 428 */     this.entries2.valid = true;
/* 429 */     this.entries1.valid = false;
/* 430 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values values() {
/* 438 */     if (Collections.allocateIterators) return new Values(this); 
/* 439 */     if (this.values1 == null) {
/* 440 */       this.values1 = new Values(this);
/* 441 */       this.values2 = new Values(this);
/*     */     } 
/* 443 */     if (!this.values1.valid) {
/* 444 */       this.values1.reset();
/* 445 */       this.values1.valid = true;
/* 446 */       this.values2.valid = false;
/* 447 */       return this.values1;
/*     */     } 
/* 449 */     this.values2.reset();
/* 450 */     this.values2.valid = true;
/* 451 */     this.values1.valid = false;
/* 452 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 460 */     if (Collections.allocateIterators) return new Keys<>(this); 
/* 461 */     if (this.keys1 == null) {
/* 462 */       this.keys1 = new Keys(this);
/* 463 */       this.keys2 = new Keys(this);
/*     */     } 
/* 465 */     if (!this.keys1.valid) {
/* 466 */       this.keys1.reset();
/* 467 */       this.keys1.valid = true;
/* 468 */       this.keys2.valid = false;
/* 469 */       return this.keys1;
/*     */     } 
/* 471 */     this.keys2.reset();
/* 472 */     this.keys2.valid = true;
/* 473 */     this.keys1.valid = false;
/* 474 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry<K> {
/*     */     public K key;
/*     */     public float value;
/*     */     
/*     */     public String toString() {
/* 482 */       return (new java.lang.StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator<K> {
/*     */     public boolean hasNext;
/*     */     final ObjectFloatMap<K> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(ObjectFloatMap<K> param1ObjectFloatMap) {
/* 494 */       this.map = param1ObjectFloatMap;
/* 495 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 499 */       this.currentIndex = -1;
/* 500 */       this.nextIndex = -1;
/* 501 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 506 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 507 */         if (arrayOfK[this.nextIndex] != null) {
/* 508 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 512 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 517 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 518 */       K[] arrayOfK = this.map.keyTable;
/* 519 */       float[] arrayOfFloat = this.map.valueTable;
/* 520 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 522 */       while ((k1 = arrayOfK[k]) != null) {
/* 523 */         int m = this.map.place(k1);
/* 524 */         if ((k - m & j) > (i - m & j)) {
/* 525 */           arrayOfK[i] = k1;
/* 526 */           arrayOfFloat[i] = arrayOfFloat[k];
/* 527 */           i = k;
/*     */         } 
/* 529 */         k = k + 1 & j;
/*     */       } 
/* 531 */       arrayOfK[i] = null;
/* 532 */       this.map.size--;
/* 533 */       if (i != this.currentIndex) this.nextIndex--; 
/* 534 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K> extends MapIterator<K> implements Iterable<Entry<K>>, Iterator<Entry<K>> {
/* 539 */     ObjectFloatMap.Entry<K> entry = new ObjectFloatMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectFloatMap<K> param1ObjectFloatMap) {
/* 542 */       super(param1ObjectFloatMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectFloatMap.Entry<K> next() {
/* 547 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 548 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 549 */       K[] arrayOfK = this.map.keyTable;
/* 550 */       this.entry.key = arrayOfK[this.nextIndex];
/* 551 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 552 */       this.currentIndex = this.nextIndex;
/* 553 */       findNextIndex();
/* 554 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 558 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 559 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Entries<K> iterator() {
/* 563 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values extends MapIterator<Object> {
/*     */     public Values(ObjectFloatMap<?> param1ObjectFloatMap) {
/* 569 */       super(param1ObjectFloatMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 573 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 574 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public float next() {
/* 578 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 579 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 580 */       float f = this.map.valueTable[this.nextIndex];
/* 581 */       this.currentIndex = this.nextIndex;
/* 582 */       findNextIndex();
/* 583 */       return f;
/*     */     }
/*     */     
/*     */     public Values iterator() {
/* 587 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public FloatArray toArray() {
/* 592 */       FloatArray floatArray = new FloatArray(true, this.map.size);
/* 593 */       while (this.hasNext)
/* 594 */         floatArray.add(next()); 
/* 595 */       return floatArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public FloatArray toArray(FloatArray param1FloatArray) {
/* 600 */       while (this.hasNext)
/* 601 */         param1FloatArray.add(next()); 
/* 602 */       return param1FloatArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K> implements Iterable<K>, Iterator<K> {
/*     */     public Keys(ObjectFloatMap<K> param1ObjectFloatMap) {
/* 608 */       super(param1ObjectFloatMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 612 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 613 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 617 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 618 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 619 */       K k = this.map.keyTable[this.nextIndex];
/* 620 */       this.currentIndex = this.nextIndex;
/* 621 */       findNextIndex();
/* 622 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 626 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray() {
/* 631 */       return toArray(new Array<>(true, this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 636 */       while (this.hasNext)
/* 637 */         param1Array.add(next()); 
/* 638 */       return param1Array;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ObjectFloatMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */