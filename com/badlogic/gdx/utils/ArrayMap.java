/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
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
/*     */ public class ArrayMap<K, V>
/*     */   implements Iterable<ObjectMap.Entry<K, V>>
/*     */ {
/*     */   public K[] keys;
/*     */   public V[] values;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   private transient Entries entries1;
/*     */   private transient Entries entries2;
/*     */   private transient Values values1;
/*     */   private transient Values values2;
/*     */   private transient Keys keys1;
/*     */   private transient Keys keys2;
/*     */   
/*     */   public ArrayMap() {
/*  45 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayMap(int paramInt) {
/*  50 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayMap(boolean paramBoolean, int paramInt) {
/*  57 */     this.ordered = paramBoolean;
/*  58 */     this.keys = (K[])new Object[paramInt];
/*  59 */     this.values = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayMap(boolean paramBoolean, int paramInt, Class paramClass1, Class paramClass2) {
/*  67 */     this.ordered = paramBoolean;
/*  68 */     this.keys = (K[])ArrayReflection.newInstance(paramClass1, paramInt);
/*  69 */     this.values = (V[])ArrayReflection.newInstance(paramClass2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayMap(Class paramClass1, Class paramClass2) {
/*  74 */     this(false, 16, paramClass1, paramClass2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayMap(ArrayMap paramArrayMap) {
/*  81 */     this(paramArrayMap.ordered, paramArrayMap.size, paramArrayMap.keys.getClass().getComponentType(), paramArrayMap.values.getClass().getComponentType());
/*  82 */     this.size = paramArrayMap.size;
/*  83 */     System.arraycopy(paramArrayMap.keys, 0, this.keys, 0, this.size);
/*  84 */     System.arraycopy(paramArrayMap.values, 0, this.values, 0, this.size);
/*     */   }
/*     */   
/*     */   public int put(K paramK, V paramV) {
/*     */     int i;
/*  89 */     if ((i = indexOfKey(paramK)) == -1) {
/*  90 */       if (this.size == this.keys.length) resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  91 */       i = this.size++;
/*     */     } 
/*  93 */     this.keys[i] = paramK;
/*  94 */     this.values[i] = paramV;
/*  95 */     return i;
/*     */   }
/*     */   
/*     */   public int put(K paramK, V paramV, int paramInt) {
/*     */     int i;
/* 100 */     if ((i = indexOfKey(paramK)) != -1) {
/* 101 */       removeIndex(i);
/* 102 */     } else if (this.size == this.keys.length) {
/* 103 */       resize(Math.max(8, (int)(this.size * 1.75F)));
/* 104 */     }  System.arraycopy(this.keys, paramInt, this.keys, paramInt + 1, this.size - paramInt);
/* 105 */     System.arraycopy(this.values, paramInt, this.values, paramInt + 1, this.size - paramInt);
/* 106 */     this.keys[paramInt] = paramK;
/* 107 */     this.values[paramInt] = paramV;
/* 108 */     this.size++;
/* 109 */     return paramInt;
/*     */   }
/*     */   
/*     */   public void putAll(ArrayMap<? extends K, ? extends V> paramArrayMap) {
/* 113 */     putAll(paramArrayMap, 0, paramArrayMap.size);
/*     */   }
/*     */   
/*     */   public void putAll(ArrayMap<? extends K, ? extends V> paramArrayMap, int paramInt1, int paramInt2) {
/* 117 */     if (paramInt1 + paramInt2 > paramArrayMap.size)
/* 118 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArrayMap.size); 
/*     */     int i;
/* 120 */     if ((i = this.size + paramInt2 - paramInt1) >= this.keys.length) resize(Math.max(8, (int)(i * 1.75F))); 
/* 121 */     System.arraycopy(paramArrayMap.keys, paramInt1, this.keys, this.size, paramInt2);
/* 122 */     System.arraycopy(paramArrayMap.values, paramInt1, this.values, this.size, paramInt2);
/* 123 */     this.size += paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public V get(K paramK) {
/* 129 */     return get(paramK, null);
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public V get(K paramK, @Null V paramV) {
/* 135 */     K[] arrayOfK = this.keys;
/* 136 */     int i = this.size - 1;
/* 137 */     if (paramK == null)
/* 138 */     { for (; i >= 0; i--) {
/* 139 */         if (arrayOfK[i] == paramK) return this.values[i]; 
/*     */       }  }
/* 141 */     else { for (; i >= 0; i--) {
/* 142 */         if (paramK.equals(arrayOfK[i])) return this.values[i]; 
/*     */       }  }
/* 144 */      return paramV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public K getKey(V paramV, boolean paramBoolean) {
/* 151 */     V[] arrayOfV = this.values;
/* 152 */     int i = this.size - 1;
/* 153 */     if (paramBoolean || paramV == null)
/* 154 */     { for (; i >= 0; i--) {
/* 155 */         if (arrayOfV[i] == paramV) return this.keys[i]; 
/*     */       }  }
/* 157 */     else { for (; i >= 0; i--) {
/* 158 */         if (paramV.equals(arrayOfV[i])) return this.keys[i]; 
/*     */       }  }
/* 160 */      return null;
/*     */   }
/*     */   
/*     */   public K getKeyAt(int paramInt) {
/* 164 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 165 */     return this.keys[paramInt];
/*     */   }
/*     */   
/*     */   public V getValueAt(int paramInt) {
/* 169 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 170 */     return this.values[paramInt];
/*     */   }
/*     */   
/*     */   public K firstKey() {
/* 174 */     if (this.size == 0) throw new IllegalStateException("Map is empty."); 
/* 175 */     return this.keys[0];
/*     */   }
/*     */   
/*     */   public V firstValue() {
/* 179 */     if (this.size == 0) throw new IllegalStateException("Map is empty."); 
/* 180 */     return this.values[0];
/*     */   }
/*     */   
/*     */   public void setKey(int paramInt, K paramK) {
/* 184 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 185 */     this.keys[paramInt] = paramK;
/*     */   }
/*     */   
/*     */   public void setValue(int paramInt, V paramV) {
/* 189 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 190 */     this.values[paramInt] = paramV;
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, K paramK, V paramV) {
/* 194 */     if (paramInt > this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 195 */     if (this.size == this.keys.length) resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 196 */     if (this.ordered) {
/* 197 */       System.arraycopy(this.keys, paramInt, this.keys, paramInt + 1, this.size - paramInt);
/* 198 */       System.arraycopy(this.values, paramInt, this.values, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 200 */       this.keys[this.size] = this.keys[paramInt];
/* 201 */       this.values[this.size] = this.values[paramInt];
/*     */     } 
/* 203 */     this.size++;
/* 204 */     this.keys[paramInt] = paramK;
/* 205 */     this.values[paramInt] = paramV;
/*     */   }
/*     */   
/*     */   public boolean containsKey(K paramK) {
/* 209 */     K[] arrayOfK = this.keys;
/* 210 */     int i = this.size - 1;
/* 211 */     if (paramK == null)
/* 212 */     { while (i >= 0) {
/* 213 */         if (arrayOfK[i--] == paramK) return true; 
/*     */       }  }
/* 215 */     else { while (i >= 0) {
/* 216 */         if (paramK.equals(arrayOfK[i--])) return true; 
/*     */       }  }
/* 218 */      return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(V paramV, boolean paramBoolean) {
/* 223 */     V[] arrayOfV = this.values;
/* 224 */     int i = this.size - 1;
/* 225 */     if (paramBoolean || paramV == null)
/* 226 */     { while (i >= 0) {
/* 227 */         if (arrayOfV[i--] == paramV) return true; 
/*     */       }  }
/* 229 */     else { while (i >= 0) {
/* 230 */         if (paramV.equals(arrayOfV[i--])) return true; 
/*     */       }  }
/* 232 */      return false;
/*     */   }
/*     */   
/*     */   public int indexOfKey(K paramK) {
/* 236 */     K[] arrayOfK = this.keys;
/* 237 */     if (paramK == null)
/* 238 */     { byte b; int i; for (b = 0, i = this.size; b < i; b++) {
/* 239 */         if (arrayOfK[b] == paramK) return b; 
/*     */       }  }
/* 241 */     else { byte b; int i; for (b = 0, i = this.size; b < i; b++) {
/* 242 */         if (paramK.equals(arrayOfK[b])) return b; 
/*     */       }  }
/* 244 */      return -1;
/*     */   }
/*     */   
/*     */   public int indexOfValue(V paramV, boolean paramBoolean) {
/* 248 */     V[] arrayOfV = this.values;
/* 249 */     if (paramBoolean || paramV == null)
/* 250 */     { int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 251 */         if (arrayOfV[paramBoolean] == paramV) return paramBoolean; 
/*     */       }  }
/* 253 */     else { int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 254 */         if (paramV.equals(arrayOfV[paramBoolean])) return paramBoolean; 
/*     */       }  }
/* 256 */      return -1;
/*     */   } @Null
/*     */   public V removeKey(K paramK) {
/*     */     V v;
/* 260 */     K[] arrayOfK = this.keys;
/* 261 */     if (paramK == null) {
/* 262 */       byte b; int i; for (b = 0, i = this.size; b < i; b++) {
/* 263 */         if (arrayOfK[b] == paramK) {
/* 264 */           v = this.values[b];
/* 265 */           removeIndex(b);
/* 266 */           return v;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 270 */       byte b; int i; for (b = 0, i = this.size; b < i; b++) {
/* 271 */         if (v.equals(arrayOfK[b])) {
/* 272 */           v = this.values[b];
/* 273 */           removeIndex(b);
/* 274 */           return v;
/*     */         } 
/*     */       } 
/*     */     } 
/* 278 */     return null;
/*     */   }
/*     */   
/*     */   public boolean removeValue(V paramV, boolean paramBoolean) {
/* 282 */     V[] arrayOfV = this.values;
/* 283 */     if (paramBoolean || paramV == null) {
/* 284 */       int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 285 */         if (arrayOfV[paramBoolean] == paramV) {
/* 286 */           removeIndex(paramBoolean);
/* 287 */           return true;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 291 */       int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 292 */         if (paramV.equals(arrayOfV[paramBoolean])) {
/* 293 */           removeIndex(paramBoolean);
/* 294 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 298 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeIndex(int paramInt) {
/* 303 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException(String.valueOf(paramInt)); 
/* 304 */     K[] arrayOfK = this.keys;
/* 305 */     this.size--;
/* 306 */     if (this.ordered) {
/* 307 */       System.arraycopy(arrayOfK, paramInt + 1, arrayOfK, paramInt, this.size - paramInt);
/* 308 */       System.arraycopy(this.values, paramInt + 1, this.values, paramInt, this.size - paramInt);
/*     */     } else {
/* 310 */       arrayOfK[paramInt] = arrayOfK[this.size];
/* 311 */       this.values[paramInt] = this.values[this.size];
/*     */     } 
/* 313 */     arrayOfK[this.size] = null;
/* 314 */     this.values[this.size] = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 319 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 324 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public K peekKey() {
/* 329 */     return this.keys[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public V peekValue() {
/* 334 */     return this.values[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/* 339 */     if (this.keys.length <= paramInt) {
/* 340 */       clear();
/*     */       return;
/*     */     } 
/* 343 */     this.size = 0;
/* 344 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 348 */     Arrays.fill((Object[])this.keys, 0, this.size, (Object)null);
/* 349 */     Arrays.fill((Object[])this.values, 0, this.size, (Object)null);
/* 350 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink() {
/* 356 */     if (this.keys.length == this.size)
/* 357 */       return;  resize(this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 363 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 365 */     if ((paramInt = this.size + paramInt) > this.keys.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/*     */   }
/*     */   
/*     */   protected void resize(int paramInt) {
/* 369 */     Object[] arrayOfObject2 = (Object[])ArrayReflection.newInstance(this.keys.getClass().getComponentType(), paramInt);
/* 370 */     System.arraycopy(this.keys, 0, arrayOfObject2, 0, Math.min(this.size, arrayOfObject2.length));
/* 371 */     this.keys = (K[])arrayOfObject2;
/*     */     
/* 373 */     Object[] arrayOfObject1 = (Object[])ArrayReflection.newInstance(this.values.getClass().getComponentType(), paramInt);
/* 374 */     System.arraycopy(this.values, 0, arrayOfObject1, 0, Math.min(this.size, arrayOfObject1.length));
/* 375 */     this.values = (V[])arrayOfObject1; } public void reverse() {
/*     */     byte b;
/*     */     int i;
/*     */     int j;
/* 379 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 380 */       int k = i - b;
/* 381 */       K k1 = this.keys[b];
/* 382 */       this.keys[b] = this.keys[k];
/* 383 */       this.keys[k] = k1;
/*     */       
/* 385 */       V v = this.values[b];
/* 386 */       this.values[b] = this.values[k];
/* 387 */       this.values[k] = v;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 392 */     for (int i = this.size - 1; i >= 0; i--) {
/* 393 */       int j = MathUtils.random(i);
/* 394 */       K k = this.keys[i];
/* 395 */       this.keys[i] = this.keys[j];
/* 396 */       this.keys[j] = k;
/*     */       
/* 398 */       V v = this.values[i];
/* 399 */       this.values[i] = this.values[j];
/* 400 */       this.values[j] = v;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 407 */     if (this.size <= paramInt)
/* 408 */       return;  for (int i = paramInt; i < this.size; i++) {
/* 409 */       this.keys[i] = null;
/* 410 */       this.values[i] = null;
/*     */     } 
/* 412 */     this.size = paramInt;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 416 */     K[] arrayOfK = this.keys;
/* 417 */     V[] arrayOfV = this.values;
/* 418 */     int i = 0; byte b; int j;
/* 419 */     for (b = 0, j = this.size; b < j; b++) {
/* 420 */       K k = arrayOfK[b];
/* 421 */       V v = arrayOfV[b];
/* 422 */       if (k != null) i += k.hashCode() * 31; 
/* 423 */       if (v != null) i += v.hashCode(); 
/*     */     } 
/* 425 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 429 */     if (paramObject == this) return true; 
/* 430 */     if (!(paramObject instanceof ArrayMap)) return false;
/*     */     
/* 432 */     if (((ArrayMap)(paramObject = paramObject)).size != this.size) return false; 
/* 433 */     K[] arrayOfK = this.keys;
/* 434 */     V[] arrayOfV = this.values; byte b; int i;
/* 435 */     for (b = 0, i = this.size; b < i; b++) {
/* 436 */       K k = arrayOfK[b];
/*     */       V v;
/* 438 */       if ((v = arrayOfV[b]) == null)
/* 439 */       { if (paramObject.get(k, ObjectMap.dummy) != null) return false;
/*     */          }
/* 441 */       else if (!v.equals(paramObject.get(k))) { return false; }
/*     */     
/*     */     } 
/* 444 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(Object paramObject) {
/* 449 */     if (paramObject == this) return true; 
/* 450 */     if (!(paramObject instanceof ArrayMap)) return false;
/*     */     
/* 452 */     if (((ArrayMap)(paramObject = paramObject)).size != this.size) return false; 
/* 453 */     K[] arrayOfK = this.keys;
/* 454 */     V[] arrayOfV = this.values; byte b; int i;
/* 455 */     for (b = 0, i = this.size; b < i; b++) {
/* 456 */       if (arrayOfV[b] != paramObject.get(arrayOfK[b], (V)ObjectMap.dummy)) return false; 
/* 457 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 461 */     if (this.size == 0) return "{}"; 
/* 462 */     K[] arrayOfK = this.keys;
/* 463 */     V[] arrayOfV = this.values;
/*     */     StringBuilder stringBuilder;
/* 465 */     (stringBuilder = new StringBuilder(32)).append('{');
/* 466 */     stringBuilder.append(arrayOfK[0]);
/* 467 */     stringBuilder.append('=');
/* 468 */     stringBuilder.append(arrayOfV[0]);
/* 469 */     for (byte b = 1; b < this.size; b++) {
/* 470 */       stringBuilder.append(", ");
/* 471 */       stringBuilder.append(arrayOfK[b]);
/* 472 */       stringBuilder.append('=');
/* 473 */       stringBuilder.append(arrayOfV[b]);
/*     */     } 
/* 475 */     stringBuilder.append('}');
/* 476 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<ObjectMap.Entry<K, V>> iterator() {
/* 480 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<K, V> entries() {
/* 489 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 490 */     if (this.entries1 == null) {
/* 491 */       this.entries1 = new Entries<>(this);
/* 492 */       this.entries2 = new Entries<>(this);
/*     */     } 
/* 494 */     if (!this.entries1.valid) {
/* 495 */       this.entries1.index = 0;
/* 496 */       this.entries1.valid = true;
/* 497 */       this.entries2.valid = false;
/* 498 */       return this.entries1;
/*     */     } 
/* 500 */     this.entries2.index = 0;
/* 501 */     this.entries2.valid = true;
/* 502 */     this.entries1.valid = false;
/* 503 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 512 */     if (Collections.allocateIterators) return new Values<>(this); 
/* 513 */     if (this.values1 == null) {
/* 514 */       this.values1 = new Values(this);
/* 515 */       this.values2 = new Values(this);
/*     */     } 
/* 517 */     if (!this.values1.valid) {
/* 518 */       this.values1.index = 0;
/* 519 */       this.values1.valid = true;
/* 520 */       this.values2.valid = false;
/* 521 */       return this.values1;
/*     */     } 
/* 523 */     this.values2.index = 0;
/* 524 */     this.values2.valid = true;
/* 525 */     this.values1.valid = false;
/* 526 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 535 */     if (Collections.allocateIterators) return new Keys<>(this); 
/* 536 */     if (this.keys1 == null) {
/* 537 */       this.keys1 = new Keys(this);
/* 538 */       this.keys2 = new Keys(this);
/*     */     } 
/* 540 */     if (!this.keys1.valid) {
/* 541 */       this.keys1.index = 0;
/* 542 */       this.keys1.valid = true;
/* 543 */       this.keys2.valid = false;
/* 544 */       return this.keys1;
/*     */     } 
/* 546 */     this.keys2.index = 0;
/* 547 */     this.keys2.valid = true;
/* 548 */     this.keys1.valid = false;
/* 549 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entries<K, V> implements Iterable<ObjectMap.Entry<K, V>>, Iterator<ObjectMap.Entry<K, V>> {
/*     */     private final ArrayMap<K, V> map;
/* 554 */     ObjectMap.Entry<K, V> entry = new ObjectMap.Entry<>();
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public Entries(ArrayMap<K, V> param1ArrayMap) {
/* 559 */       this.map = param1ArrayMap;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 563 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 564 */       return (this.index < this.map.size);
/*     */     }
/*     */     
/*     */     public Iterator<ObjectMap.Entry<K, V>> iterator() {
/* 568 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectMap.Entry<K, V> next() {
/* 573 */       if (this.index >= this.map.size) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 574 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 575 */       this.entry.key = this.map.keys[this.index];
/* 576 */       this.entry.value = this.map.values[this.index++];
/* 577 */       return this.entry;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 581 */       this.index--;
/* 582 */       this.map.removeIndex(this.index);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 586 */       this.index = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> implements Iterable<V>, Iterator<V> {
/*     */     private final ArrayMap<Object, V> map;
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public Values(ArrayMap<Object, V> param1ArrayMap) {
/* 596 */       this.map = param1ArrayMap;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 600 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 601 */       return (this.index < this.map.size);
/*     */     }
/*     */     
/*     */     public Iterator<V> iterator() {
/* 605 */       return this;
/*     */     }
/*     */     
/*     */     public V next() {
/* 609 */       if (this.index >= this.map.size) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 610 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 611 */       return this.map.values[this.index++];
/*     */     }
/*     */     
/*     */     public void remove() {
/* 615 */       this.index--;
/* 616 */       this.map.removeIndex(this.index);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 620 */       this.index = 0;
/*     */     }
/*     */     
/*     */     public Array<V> toArray() {
/* 624 */       return new Array<>(true, this.map.values, this.index, this.map.size - this.index);
/*     */     }
/*     */     
/*     */     public Array<V> toArray(Array<V> param1Array) {
/* 628 */       param1Array.addAll(this.map.values, this.index, this.map.size - this.index);
/* 629 */       return param1Array;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> implements Iterable<K>, Iterator<K> {
/*     */     private final ArrayMap<K, Object> map;
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public Keys(ArrayMap<K, Object> param1ArrayMap) {
/* 639 */       this.map = param1ArrayMap;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 643 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 644 */       return (this.index < this.map.size);
/*     */     }
/*     */     
/*     */     public Iterator<K> iterator() {
/* 648 */       return this;
/*     */     }
/*     */     
/*     */     public K next() {
/* 652 */       if (this.index >= this.map.size) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 653 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 654 */       return this.map.keys[this.index++];
/*     */     }
/*     */     
/*     */     public void remove() {
/* 658 */       this.index--;
/* 659 */       this.map.removeIndex(this.index);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 663 */       this.index = 0;
/*     */     }
/*     */     
/*     */     public Array<K> toArray() {
/* 667 */       return new Array<>(true, this.map.keys, this.index, this.map.size - this.index);
/*     */     }
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 671 */       param1Array.addAll(this.map.keys, this.index, this.map.size - this.index);
/* 672 */       return param1Array;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ArrayMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */