/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
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
/*     */ public class ObjectMap<K, V>
/*     */   implements Iterable<ObjectMap.Entry<K, V>>
/*     */ {
/*  44 */   static final Object dummy = new Object();
/*     */ 
/*     */ 
/*     */   
/*     */   public int size;
/*     */ 
/*     */   
/*     */   K[] keyTable;
/*     */ 
/*     */   
/*     */   V[] valueTable;
/*     */ 
/*     */   
/*     */   float loadFactor;
/*     */ 
/*     */   
/*     */   int threshold;
/*     */ 
/*     */   
/*     */   protected int shift;
/*     */ 
/*     */   
/*     */   protected int mask;
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap() {
/*  71 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap(int paramInt) {
/*  77 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap(int paramInt, float paramFloat) {
/*  84 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  85 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  86 */     this.loadFactor = paramFloat;
/*     */     
/*  88 */     paramInt = tableSize(paramInt, paramFloat);
/*  89 */     this.threshold = (int)(paramInt * paramFloat);
/*  90 */     this.mask = paramInt - 1;
/*  91 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  93 */     this.keyTable = (K[])new Object[paramInt];
/*  94 */     this.valueTable = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectMap(ObjectMap<? extends K, ? extends V> paramObjectMap) {
/*  99 */     this((int)(paramObjectMap.keyTable.length * paramObjectMap.loadFactor), paramObjectMap.loadFactor);
/* 100 */     System.arraycopy(paramObjectMap.keyTable, 0, this.keyTable, 0, paramObjectMap.keyTable.length);
/* 101 */     System.arraycopy(paramObjectMap.valueTable, 0, this.valueTable, 0, paramObjectMap.valueTable.length);
/* 102 */     this.size = paramObjectMap.size;
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
/*     */   @Null
/*     */   public V put(K paramK, @Null V paramV) {
/*     */     V v;
/*     */     int i;
/* 139 */     if ((i = locateKey(paramK)) >= 0) {
/* 140 */       v = this.valueTable[i];
/* 141 */       this.valueTable[i] = paramV;
/* 142 */       return v;
/*     */     } 
/* 144 */     i = -(i + 1);
/* 145 */     this.keyTable[i] = (K)v;
/* 146 */     this.valueTable[i] = paramV;
/* 147 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(ObjectMap<? extends K, ? extends V> paramObjectMap) {
/* 152 */     ensureCapacity(paramObjectMap.size);
/* 153 */     K[] arrayOfK = paramObjectMap.keyTable;
/* 154 */     V[] arrayOfV = paramObjectMap.valueTable; byte b;
/*     */     int i;
/* 156 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 158 */       if ((k = arrayOfK[b]) != null) put(k, arrayOfV[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(K paramK, @Null V paramV) {
/* 164 */     K[] arrayOfK = this.keyTable; int i;
/* 165 */     for (i = place(paramK);; i = i + 1 & this.mask) {
/* 166 */       if (arrayOfK[i] == null) {
/* 167 */         arrayOfK[i] = paramK;
/* 168 */         this.valueTable[i] = paramV;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public <T extends K> V get(T paramT) {
/* 177 */     for (int i = place((K)paramT);; i = i + 1 & this.mask) {
/*     */       K k;
/* 179 */       if ((k = this.keyTable[i]) == null) return null; 
/* 180 */       if (k.equals(paramT)) return this.valueTable[i];
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public V get(K paramK, @Null V paramV) {
/* 186 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/* 188 */       if ((k = this.keyTable[i]) == null) return paramV; 
/* 189 */       if (k.equals(paramK)) return this.valueTable[i]; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V remove(K paramK) {
/*     */     int i;
/* 196 */     if ((i = locateKey(paramK)) < 0) return null; 
/* 197 */     K[] arrayOfK = this.keyTable;
/*     */     
/* 199 */     V arrayOfV[], v = (arrayOfV = this.valueTable)[i];
/* 200 */     int j = this.mask, k = i + 1 & j;
/* 201 */     while ((paramK = arrayOfK[k]) != null) {
/* 202 */       int m = place(paramK);
/* 203 */       if ((k - m & j) > (i - m & j)) {
/* 204 */         arrayOfK[i] = paramK;
/* 205 */         arrayOfV[i] = arrayOfV[k];
/* 206 */         i = k;
/*     */       } 
/* 208 */       k = k + 1 & j;
/*     */     } 
/* 210 */     arrayOfK[i] = null;
/* 211 */     arrayOfV[i] = null;
/* 212 */     this.size--;
/* 213 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 218 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 223 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 230 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 231 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 232 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 237 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 238 */     if (this.keyTable.length <= paramInt) {
/* 239 */       clear();
/*     */       return;
/*     */     } 
/* 242 */     this.size = 0;
/* 243 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 247 */     if (this.size == 0)
/* 248 */       return;  this.size = 0;
/* 249 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/* 250 */     Arrays.fill((Object[])this.valueTable, (Object)null);
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
/*     */     //   #258	-> 0
/*     */     //   #259	-> 5
/*     */     //   #260	-> 9
/*     */     //   #261	-> 14
/*     */     //   #262	-> 23
/*     */     //   #261	-> 37
/*     */     //   #263	-> 43
/*     */     //   #264	-> 50
/*     */     //   #265	-> 59
/*     */     //   #264	-> 68
/*     */     //   #267	-> 77
/*     */     //   #268	-> 86
/*     */     //   #267	-> 98
/*     */     //   #270	-> 104
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
/* 274 */     return (locateKey(paramK) >= 0);
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
/*     */     //   #283	-> 0
/*     */     //   #284	-> 5
/*     */     //   #285	-> 9
/*     */     //   #286	-> 14
/*     */     //   #287	-> 23
/*     */     //   #286	-> 39
/*     */     //   #288	-> 45
/*     */     //   #289	-> 52
/*     */     //   #290	-> 61
/*     */     //   #289	-> 75
/*     */     //   #292	-> 84
/*     */     //   #293	-> 93
/*     */     //   #292	-> 110
/*     */     //   #295	-> 116
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
/*     */   public void ensureCapacity(int paramInt) {
/* 301 */     paramInt = tableSize(this.size + paramInt, this.loadFactor);
/* 302 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   final void resize(int paramInt) {
/* 306 */     int i = this.keyTable.length;
/* 307 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 308 */     this.mask = paramInt - 1;
/* 309 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 311 */     K[] arrayOfK = this.keyTable;
/* 312 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 314 */     this.keyTable = (K[])new Object[paramInt];
/* 315 */     this.valueTable = (V[])new Object[paramInt];
/*     */     
/* 317 */     if (this.size > 0)
/* 318 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 320 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfV[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 326 */     int i = this.size;
/* 327 */     K[] arrayOfK = this.keyTable;
/* 328 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 329 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */ 
/*     */       
/* 332 */       i += k.hashCode(); V v;
/*     */       K k;
/* 334 */       if ((k = arrayOfK[b]) != null && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 337 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 341 */     if (paramObject == this) return true; 
/* 342 */     if (!(paramObject instanceof ObjectMap)) return false;
/*     */     
/* 344 */     if (((ObjectMap)(paramObject = paramObject)).size != this.size) return false; 
/* 345 */     K[] arrayOfK = this.keyTable;
/* 346 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 347 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 349 */       if ((k = arrayOfK[b]) != null) {
/*     */         V v;
/* 351 */         if ((v = arrayOfV[b]) == null)
/* 352 */         { if (paramObject.get(k, dummy) != null) return false;
/*     */            }
/* 354 */         else if (!v.equals(paramObject.get(k))) { return false; }
/*     */       
/*     */       } 
/*     */     } 
/* 358 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(@Null Object paramObject) {
/* 363 */     if (paramObject == this) return true; 
/* 364 */     if (!(paramObject instanceof ObjectMap)) return false;
/*     */     
/* 366 */     if (((ObjectMap)(paramObject = paramObject)).size != this.size) return false; 
/* 367 */     K[] arrayOfK = this.keyTable;
/* 368 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 369 */     for (b = 0, i = arrayOfK.length; b < i; b++) {
/*     */       K k;
/* 371 */       if ((k = arrayOfK[b]) != null && arrayOfV[b] != paramObject.get(k, (V)dummy)) return false; 
/*     */     } 
/* 373 */     return true;
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 377 */     return toString(paramString, false);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 381 */     return toString(", ", true);
/*     */   }
/*     */   
/*     */   private String toString(String paramString, boolean paramBoolean) {
/* 385 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 386 */     StringBuilder stringBuilder = new StringBuilder(32);
/* 387 */     if (paramBoolean) stringBuilder.append('{'); 
/* 388 */     K[] arrayOfK = this.keyTable;
/* 389 */     V[] arrayOfV = this.valueTable;
/* 390 */     int i = arrayOfK.length;
/* 391 */     while (i-- > 0) {
/*     */       K k;
/* 393 */       if ((k = arrayOfK[i]) != null) {
/* 394 */         stringBuilder.append((k == this) ? "(this)" : k);
/* 395 */         stringBuilder.append('=');
/* 396 */         V v = arrayOfV[i];
/* 397 */         stringBuilder.append((v == this) ? "(this)" : v); break;
/*     */       } 
/*     */     } 
/* 400 */     while (i-- > 0) {
/*     */       K k;
/* 402 */       if ((k = arrayOfK[i]) != null) {
/* 403 */         stringBuilder.append(paramString);
/* 404 */         stringBuilder.append((k == this) ? "(this)" : k);
/* 405 */         stringBuilder.append('=');
/* 406 */         V v = arrayOfV[i];
/* 407 */         stringBuilder.append((v == this) ? "(this)" : v);
/*     */       } 
/* 409 */     }  if (paramBoolean) stringBuilder.append('}'); 
/* 410 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Entries<K, V> iterator() {
/* 414 */     return entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entries<K, V> entries() {
/* 419 */     return new Entries<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 424 */     return new Values<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 429 */     return new Keys<>(this);
/*     */   }
/*     */   
/*     */   public static int tableSize(int paramInt, float paramFloat) {
/* 433 */     if (paramInt < 0) throw new IllegalArgumentException("capacity must be >= 0: " + paramInt); 
/*     */     int i;
/* 435 */     if ((i = nextPowerOfTwo(Math.max(2, (int)Math.ceil((paramInt / paramFloat))))) > 1073741824) throw new IllegalArgumentException("The required capacity is too large: " + paramInt); 
/* 436 */     return i;
/*     */   }
/*     */   
/*     */   public static int nextPowerOfTwo(int paramInt) {
/* 440 */     if (paramInt == 0) return 1; 
/* 441 */     paramInt--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 447 */     return (paramInt = (paramInt = (paramInt = (paramInt = (paramInt = paramInt | paramInt >> 1) | paramInt >> 2) | paramInt >> 4) | paramInt >> 8) | paramInt >> 16) + 1;
/*     */   }
/*     */   
/*     */   public static class Entry<K, V> { public K key;
/*     */     @Null
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 455 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
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
/* 467 */       this.map = param1ObjectMap;
/* 468 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 472 */       this.currentIndex = -1;
/* 473 */       this.nextIndex = -1;
/* 474 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       K[] arrayOfK;
/* 479 */       for (int i = (arrayOfK = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 480 */         if (arrayOfK[this.nextIndex] != null) {
/* 481 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 485 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 490 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 491 */       K[] arrayOfK = this.map.keyTable;
/* 492 */       V[] arrayOfV = this.map.valueTable;
/* 493 */       int j = this.map.mask, k = i + 1 & j;
/*     */       K k1;
/* 495 */       while ((k1 = arrayOfK[k]) != null) {
/* 496 */         int m = this.map.place(k1);
/* 497 */         if ((k - m & j) > (i - m & j)) {
/* 498 */           arrayOfK[i] = k1;
/* 499 */           arrayOfV[i] = arrayOfV[k];
/* 500 */           i = k;
/*     */         } 
/* 502 */         k = k + 1 & j;
/*     */       } 
/* 504 */       arrayOfK[i] = null;
/* 505 */       arrayOfV[i] = null;
/* 506 */       this.map.size--;
/* 507 */       if (i != this.currentIndex) this.nextIndex--; 
/* 508 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K, V> extends MapIterator<K, V, Entry<K, V>> {
/* 513 */     ObjectMap.Entry<K, V> entry = new ObjectMap.Entry<>();
/*     */     
/*     */     public Entries(ObjectMap<K, V> param1ObjectMap) {
/* 516 */       super(param1ObjectMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public ObjectMap.Entry<K, V> next() {
/* 521 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 522 */       K[] arrayOfK = this.map.keyTable;
/* 523 */       this.entry.key = arrayOfK[this.nextIndex];
/* 524 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 525 */       this.currentIndex = this.nextIndex;
/* 526 */       findNextIndex();
/* 527 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 531 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Entries<K, V> iterator() {
/* 535 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<Object, V, V> {
/*     */     public Values(ObjectMap<?, V> param1ObjectMap) {
/* 541 */       super((ObjectMap)param1ObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 545 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     @Null
/*     */     public V next() {
/* 550 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 551 */       V v = this.map.valueTable[this.nextIndex];
/* 552 */       this.currentIndex = this.nextIndex;
/* 553 */       findNextIndex();
/* 554 */       return v;
/*     */     }
/*     */     
/*     */     public Values<V> iterator() {
/* 558 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<V> toList() {
/* 563 */       return toList(new ArrayList<>(this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public <T extends java.util.List<V>> T toList(T param1T) {
/* 568 */       while (this.hasNext)
/* 569 */         param1T.add(next()); 
/* 570 */       return param1T;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K, Object, K> {
/*     */     public Keys(ObjectMap<K, ?> param1ObjectMap) {
/* 576 */       super((ObjectMap)param1ObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 580 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 584 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 585 */       K k = this.map.keyTable[this.nextIndex];
/* 586 */       this.currentIndex = this.nextIndex;
/* 587 */       findNextIndex();
/* 588 */       return k;
/*     */     }
/*     */     
/*     */     public Keys<K> iterator() {
/* 592 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<K> toList() {
/* 597 */       return toList(new ArrayList<>(this.map.size));
/*     */     }
/*     */ 
/*     */     
/*     */     public <T extends java.util.List<K>> T toList(T param1T) {
/* 602 */       while (this.hasNext)
/* 603 */         param1T.add(next()); 
/* 604 */       return param1T;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\ObjectMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */