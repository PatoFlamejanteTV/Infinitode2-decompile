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
/*     */ public class ObjectMap<K, V>
/*     */   implements Iterable<ObjectMap.Entry<K, V>>
/*     */ {
/*  42 */   static final Object dummy = new Object();
/*     */ 
/*     */   
/*     */   public int size;
/*     */   
/*     */   K[] keyTable;
/*     */   
/*     */   V[] valueTable;
/*     */   
/*     */   float loadFactor;
/*     */   
/*     */   int threshold;
/*     */   
/*     */   protected int shift;
/*     */   
/*     */   protected int mask;
/*     */   
/*     */   transient Entries entries1;
/*     */   
/*     */   transient Entries entries2;
/*     */   
/*     */   transient Values values1;
/*     */   
/*     */   transient Values values2;
/*     */   
/*     */   transient Keys keys1;
/*     */   
/*     */   transient Keys keys2;
/*     */ 
/*     */   
/*     */   public ObjectMap() {
/*  73 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap(int paramInt) {
/*  79 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap(int paramInt, float paramFloat) {
/*  86 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  87 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  88 */     this.loadFactor = paramFloat;
/*     */     
/*  90 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  91 */     this.threshold = (int)(paramInt * paramFloat);
/*  92 */     this.mask = paramInt - 1;
/*  93 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  95 */     this.keyTable = (K[])new Object[paramInt];
/*  96 */     this.valueTable = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectMap(ObjectMap<? extends K, ? extends V> paramObjectMap) {
/* 101 */     this((int)(paramObjectMap.keyTable.length * paramObjectMap.loadFactor), paramObjectMap.loadFactor);
/* 102 */     System.arraycopy(paramObjectMap.keyTable, 0, this.keyTable, 0, paramObjectMap.keyTable.length);
/* 103 */     System.arraycopy(paramObjectMap.valueTable, 0, this.valueTable, 0, paramObjectMap.valueTable.length);
/* 104 */     this.size = paramObjectMap.size;
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
/* 122 */     return (int)(paramK.hashCode() * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int locateKey(K paramK) {
/* 128 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 129 */     K[] arrayOfK = this.keyTable;
/* 130 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/* 132 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/* 133 */       if (k.equals(paramK)) return i; 
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public V put(K paramK, @Null V paramV) {
/*     */     V v;
/*     */     int i;
/* 140 */     if ((i = locateKey(paramK)) >= 0) {
/* 141 */       v = this.valueTable[i];
/* 142 */       this.valueTable[i] = paramV;
/* 143 */       return v;
/*     */     } 
/* 145 */     i = -(i + 1);
/* 146 */     this.keyTable[i] = (K)v;
/* 147 */     this.valueTable[i] = paramV;
/* 148 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(ObjectMap<? extends K, ? extends V> paramObjectMap) {
/* 153 */     ensureCapacity(paramObjectMap.size);
/* 154 */     K[] arrayOfK = paramObjectMap.keyTable;
/* 155 */     V[] arrayOfV = paramObjectMap.valueTable; byte b;
/*     */     int i;
/* 157 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 159 */       if ((k = arrayOfK[b]) != null) put(k, arrayOfV[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, @Null V paramV) {
/* 165 */     K[] arrayOfK = this.keyTable; int i;
/* 166 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 167 */       if (arrayOfK[i] == null) {
/* 168 */         arrayOfK[i] = paramK;
/* 169 */         this.valueTable[i] = paramV;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public <T extends K> V get(T paramT) {
/*     */     int i;
/* 178 */     return ((i = locateKey((K)paramT)) < 0) ? null : this.valueTable[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(K paramK, @Null V paramV) {
/*     */     int i;
/* 184 */     return ((i = locateKey(paramK)) < 0) ? paramV : this.valueTable[i];
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V remove(K paramK) {
/*     */     int i;
/* 190 */     if ((i = locateKey(paramK)) < 0) return null; 
/* 191 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 193 */     V arrayOfV[], v = (arrayOfV = this.valueTable)[i];
/* 194 */     int j = this.mask, k = i + 1 & j;
/* 195 */     while ((paramK = arrayOfK[k]) != null) {
/* 196 */       int m = place(paramK);
/* 197 */       if ((k - m & j) > (i - m & j)) {
/* 198 */         arrayOfK[i] = paramK;
/* 199 */         arrayOfV[i] = arrayOfV[k];
/* 200 */         i = k;
/*     */       } 
/* 202 */       k = k + 1 & j;
/*     */     } 
/* 204 */     arrayOfK[i] = null;
/* 205 */     arrayOfV[i] = null;
/* 206 */     this.size--;
/* 207 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 212 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 217 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 224 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 225 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 226 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 231 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 232 */     if (this.keyTable.length <= paramInt) {
/* 233 */       clear();
/*     */       return;
/*     */     } 
/* 236 */     this.size = 0;
/* 237 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 241 */     if (this.size == 0)
/* 242 */       return;  this.size = 0;
/* 243 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/* 244 */     Arrays.fill((Object[])this.valueTable, (Object)null);
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
/*     */   public boolean containsValue(@Null Object paramObject, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore_3
/*     */     //   5: aload_1
/*     */     //   6: ifnonnull -> 46
/*     */     //   9: aload_0
/*     */     //   10: getfield keyTable : [Ljava/lang/Object;
/*     */     //   13: astore_2
/*     */     //   14: aload_3
/*     */     //   15: arraylength
/*     */     //   16: iconst_1
/*     */     //   17: isub
/*     */     //   18: istore_1
/*     */     //   19: iload_1
/*     */     //   20: iflt -> 43
/*     */     //   23: aload_2
/*     */     //   24: iload_1
/*     */     //   25: aaload
/*     */     //   26: ifnull -> 37
/*     */     //   29: aload_3
/*     */     //   30: iload_1
/*     */     //   31: aaload
/*     */     //   32: ifnonnull -> 37
/*     */     //   35: iconst_1
/*     */     //   36: ireturn
/*     */     //   37: iinc #1, -1
/*     */     //   40: goto -> 19
/*     */     //   43: goto -> 104
/*     */     //   46: iload_2
/*     */     //   47: ifeq -> 77
/*     */     //   50: aload_3
/*     */     //   51: arraylength
/*     */     //   52: iconst_1
/*     */     //   53: isub
/*     */     //   54: istore_2
/*     */     //   55: iload_2
/*     */     //   56: iflt -> 74
/*     */     //   59: aload_3
/*     */     //   60: iload_2
/*     */     //   61: aaload
/*     */     //   62: aload_1
/*     */     //   63: if_acmpne -> 68
/*     */     //   66: iconst_1
/*     */     //   67: ireturn
/*     */     //   68: iinc #2, -1
/*     */     //   71: goto -> 55
/*     */     //   74: goto -> 104
/*     */     //   77: aload_3
/*     */     //   78: arraylength
/*     */     //   79: iconst_1
/*     */     //   80: isub
/*     */     //   81: istore_2
/*     */     //   82: iload_2
/*     */     //   83: iflt -> 104
/*     */     //   86: aload_1
/*     */     //   87: aload_3
/*     */     //   88: iload_2
/*     */     //   89: aaload
/*     */     //   90: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   93: ifeq -> 98
/*     */     //   96: iconst_1
/*     */     //   97: ireturn
/*     */     //   98: iinc #2, -1
/*     */     //   101: goto -> 82
/*     */     //   104: iconst_0
/*     */     //   105: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #252	-> 0
/*     */     //   #253	-> 5
/*     */     //   #254	-> 9
/*     */     //   #255	-> 14
/*     */     //   #256	-> 23
/*     */     //   #255	-> 37
/*     */     //   #257	-> 43
/*     */     //   #258	-> 50
/*     */     //   #259	-> 59
/*     */     //   #258	-> 68
/*     */     //   #261	-> 77
/*     */     //   #262	-> 86
/*     */     //   #261	-> 98
/*     */     //   #264	-> 104
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
/*     */   public boolean containsKey(K paramK) {
/* 268 */     return (locateKey(paramK) >= 0);
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
/*     */   @Null
/*     */   public K findKey(@Null Object paramObject, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore_3
/*     */     //   5: aload_1
/*     */     //   6: ifnonnull -> 48
/*     */     //   9: aload_0
/*     */     //   10: getfield keyTable : [Ljava/lang/Object;
/*     */     //   13: astore_2
/*     */     //   14: aload_3
/*     */     //   15: arraylength
/*     */     //   16: iconst_1
/*     */     //   17: isub
/*     */     //   18: istore_1
/*     */     //   19: iload_1
/*     */     //   20: iflt -> 45
/*     */     //   23: aload_2
/*     */     //   24: iload_1
/*     */     //   25: aaload
/*     */     //   26: ifnull -> 39
/*     */     //   29: aload_3
/*     */     //   30: iload_1
/*     */     //   31: aaload
/*     */     //   32: ifnonnull -> 39
/*     */     //   35: aload_2
/*     */     //   36: iload_1
/*     */     //   37: aaload
/*     */     //   38: areturn
/*     */     //   39: iinc #1, -1
/*     */     //   42: goto -> 19
/*     */     //   45: goto -> 116
/*     */     //   48: iload_2
/*     */     //   49: ifeq -> 84
/*     */     //   52: aload_3
/*     */     //   53: arraylength
/*     */     //   54: iconst_1
/*     */     //   55: isub
/*     */     //   56: istore_2
/*     */     //   57: iload_2
/*     */     //   58: iflt -> 81
/*     */     //   61: aload_3
/*     */     //   62: iload_2
/*     */     //   63: aaload
/*     */     //   64: aload_1
/*     */     //   65: if_acmpne -> 75
/*     */     //   68: aload_0
/*     */     //   69: getfield keyTable : [Ljava/lang/Object;
/*     */     //   72: iload_2
/*     */     //   73: aaload
/*     */     //   74: areturn
/*     */     //   75: iinc #2, -1
/*     */     //   78: goto -> 57
/*     */     //   81: goto -> 116
/*     */     //   84: aload_3
/*     */     //   85: arraylength
/*     */     //   86: iconst_1
/*     */     //   87: isub
/*     */     //   88: istore_2
/*     */     //   89: iload_2
/*     */     //   90: iflt -> 116
/*     */     //   93: aload_1
/*     */     //   94: aload_3
/*     */     //   95: iload_2
/*     */     //   96: aaload
/*     */     //   97: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   100: ifeq -> 110
/*     */     //   103: aload_0
/*     */     //   104: getfield keyTable : [Ljava/lang/Object;
/*     */     //   107: iload_2
/*     */     //   108: aaload
/*     */     //   109: areturn
/*     */     //   110: iinc #2, -1
/*     */     //   113: goto -> 89
/*     */     //   116: aconst_null
/*     */     //   117: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #276	-> 0
/*     */     //   #277	-> 5
/*     */     //   #278	-> 9
/*     */     //   #279	-> 14
/*     */     //   #280	-> 23
/*     */     //   #279	-> 39
/*     */     //   #281	-> 45
/*     */     //   #282	-> 52
/*     */     //   #283	-> 61
/*     */     //   #282	-> 75
/*     */     //   #285	-> 84
/*     */     //   #286	-> 93
/*     */     //   #285	-> 110
/*     */     //   #288	-> 116
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
/* 305 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 307 */     this.keyTable = (K[])new Object[paramInt];
/* 308 */     this.valueTable = (V[])new Object[paramInt];
/*     */     
/* 310 */     if (this.size > 0)
/* 311 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 313 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfV[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 319 */     int i = this.size;
/* 320 */     K[] arrayOfK = this.keyTable;
/* 321 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 322 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */ 
/*     */       
/* 325 */       i += k.hashCode(); V v;
/*     */       K k;
/* 327 */       if ((k = arrayOfK[b]) != null && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 330 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 334 */     if (paramObject == this) return true; 
/* 335 */     if (!(paramObject instanceof ObjectMap)) return false;
/*     */     
/* 337 */     if (((ObjectMap)(paramObject = paramObject)).size != this.size) return false; 
/* 338 */     K[] arrayOfK = this.keyTable;
/* 339 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 340 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 342 */       if ((k = arrayOfK[b]) != null) {
/*     */         V v;
/* 344 */         if ((v = arrayOfV[b]) == null)
/* 345 */         { if (paramObject.get(k, dummy) != null) return false;
/*     */            }
/* 347 */         else if (!v.equals(paramObject.get(k))) { return false; }
/*     */       
/*     */       } 
/*     */     } 
/* 351 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(@Null Object paramObject) {
/* 356 */     if (paramObject == this) return true; 
/* 357 */     if (!(paramObject instanceof ObjectMap)) return false;
/*     */     
/* 359 */     if (((ObjectMap)(paramObject = paramObject)).size != this.size) return false; 
/* 360 */     K[] arrayOfK = this.keyTable;
/* 361 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 362 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 364 */       if ((k = arrayOfK[b]) != null && arrayOfV[b] != paramObject.get(k, (V)dummy)) return false; 
/*     */     } 
/* 366 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 370 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 374 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   protected String toString(String paramString, boolean paramBoolean) {
/* 378 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 379 */     java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(32);
/* 380 */     if (paramBoolean) stringBuilder.append('{'); 
/* 381 */     K[] arrayOfK = this.keyTable;
/* 382 */     V[] arrayOfV = this.valueTable;
/* 383 */     int i = arrayOfK.length;
/* 384 */     while (i-- > 0) {
/*     */       K k;
/* 386 */       if ((k = arrayOfK[i]) != null) {
/* 387 */         stringBuilder.append((k == this) ? "(this)" : k);
/* 388 */         stringBuilder.append('=');
/* 389 */         V v = arrayOfV[i];
/* 390 */         stringBuilder.append((v == this) ? "(this)" : v); break;
/*     */       } 
/*     */     } 
/* 393 */     while (i-- > 0) {
/*     */       K k;
/* 395 */       if ((k = arrayOfK[i]) != null) {
/* 396 */         stringBuilder.append(paramString);
/* 397 */         stringBuilder.append((k == this) ? "(this)" : k);
/* 398 */         stringBuilder.append('=');
/* 399 */         V v = arrayOfV[i];
/* 400 */         stringBuilder.append((v == this) ? "(this)" : v);
/*     */       } 
/* 402 */     }  if (paramBoolean) stringBuilder.append('}'); 
/* 403 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K, V> iterator() {
/* 407 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<K, V> entries() {
/* 415 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 416 */     if (this.entries1 == null) {
/* 417 */       this.entries1 = new Entries<>(this);
/* 418 */       this.entries2 = new Entries<>(this);
/*     */     } 
/* 420 */     if (!this.entries1.valid) {
/* 421 */       this.entries1.reset();
/* 422 */       this.entries1.valid = true;
/* 423 */       this.entries2.valid = false;
/* 424 */       return this.entries1;
/*     */     } 
/* 426 */     this.entries2.reset();
/* 427 */     this.entries2.valid = true;
/* 428 */     this.entries1.valid = false;
/* 429 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 437 */     if (Collections.allocateIterators) return new Values<>(this); 
/* 438 */     if (this.values1 == null) {
/* 439 */       this.values1 = new Values(this);
/* 440 */       this.values2 = new Values(this);
/*     */     } 
/* 442 */     if (!this.values1.valid) {
/* 443 */       this.values1.reset();
/* 444 */       this.values1.valid = true;
/* 445 */       this.values2.valid = false;
/* 446 */       return this.values1;
/*     */     } 
/* 448 */     this.values2.reset();
/* 449 */     this.values2.valid = true;
/* 450 */     this.values1.valid = false;
/* 451 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 459 */     if (Collections.allocateIterators) return new Keys<>(this); 
/* 460 */     if (this.keys1 == null) {
/* 461 */       this.keys1 = new Keys(this);
/* 462 */       this.keys2 = new Keys(this);
/*     */     } 
/* 464 */     if (!this.keys1.valid) {
/* 465 */       this.keys1.reset();
/* 466 */       this.keys1.valid = true;
/* 467 */       this.keys2.valid = false;
/* 468 */       return this.keys1;
/*     */     } 
/* 470 */     this.keys2.reset();
/* 471 */     this.keys2.valid = true;
/* 472 */     this.keys1.valid = false;
/* 473 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry<K, V> { public K key;
/*     */     @Null
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 481 */       return (new java.lang.StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     } }
/*     */ 
/*     */   
/*     */   private static abstract class MapIterator<K, V, I> implements Iterable<I>, Iterator<I> {
/*     */     public boolean hasNext;
/*     */     final ObjectMap<K, V> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(ObjectMap<K, V> param1ObjectMap) {
/* 493 */       this.map = param1ObjectMap;
/* 494 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 498 */       this.currentIndex = -1;
/* 499 */       this.nextIndex = -1;
/* 500 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 505 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 506 */         if (arrayOfK[this.nextIndex] != null) {
/* 507 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 511 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 516 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 517 */       K[] arrayOfK = this.map.keyTable;
/* 518 */       V[] arrayOfV = this.map.valueTable;
/* 519 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 521 */       while ((k1 = arrayOfK[k]) != null) {
/* 522 */         int m = this.map.place(k1);
/* 523 */         if ((k - m & j) > (i - m & j)) {
/* 524 */           arrayOfK[i] = k1;
/* 525 */           arrayOfV[i] = arrayOfV[k];
/* 526 */           i = k;
/*     */         } 
/* 528 */         k = k + 1 & j;
/*     */       } 
/* 530 */       arrayOfK[i] = null;
/* 531 */       arrayOfV[i] = null;
/* 532 */       this.map.size--;
/* 533 */       if (i != this.currentIndex) this.nextIndex--; 
/* 534 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K, V> extends MapIterator<K, V, Entry<K, V>> {
/* 539 */     ObjectMap.Entry<K, V> entry = new ObjectMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectMap<K, V> param1ObjectMap) {
/* 542 */       super(param1ObjectMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectMap.Entry<K, V> next() {
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
/*     */     public Entries<K, V> iterator() {
/* 563 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<Object, V, V> {
/*     */     public Values(ObjectMap<?, V> param1ObjectMap) {
/* 569 */       super((ObjectMap)param1ObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 573 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 574 */       return this.hasNext;
/*     */     }
/*     */     @Null
/*     */     public V next() {
/* 578 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 579 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 580 */       V v = this.map.valueTable[this.nextIndex];
/* 581 */       this.currentIndex = this.nextIndex;
/* 582 */       findNextIndex();
/* 583 */       return v;
/*     */     }
/*     */     
/*     */     public Values<V> iterator() {
/* 587 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<V> toArray() {
/* 592 */       return toArray(new Array<>(true, this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<V> toArray(Array<V> param1Array) {
/* 597 */       while (this.hasNext)
/* 598 */         param1Array.add(next()); 
/* 599 */       return param1Array;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K, Object, K> {
/*     */     public Keys(ObjectMap<K, ?> param1ObjectMap) {
/* 605 */       super((ObjectMap)param1ObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 609 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 610 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 614 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 615 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 616 */       K k = this.map.keyTable[this.nextIndex];
/* 617 */       this.currentIndex = this.nextIndex;
/* 618 */       findNextIndex();
/* 619 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 623 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray() {
/* 628 */       return toArray(new Array<>(true, this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 633 */       while (this.hasNext)
/* 634 */         param1Array.add(next()); 
/* 635 */       return param1Array;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ObjectMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */