/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class CuckooObjectMap<K, V>
/*     */ {
/*     */   private static final int PRIME2 = -1105259343;
/*     */   private static final int PRIME3 = -1262997959;
/*     */   private static final int PRIME4 = -825114047;
/*  42 */   static Random random = new Random();
/*     */   
/*     */   public int size;
/*     */   
/*     */   K[] keyTable;
/*     */   V[] valueTable;
/*     */   int capacity;
/*     */   int stashSize;
/*     */   private float loadFactor;
/*     */   private int hashShift;
/*     */   private int mask;
/*     */   private int threshold;
/*     */   private int stashCapacity;
/*     */   private int pushIterations;
/*     */   private boolean isBigTable;
/*     */   
/*     */   public CuckooObjectMap() {
/*  59 */     this(32, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CuckooObjectMap(int paramInt) {
/*  65 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CuckooObjectMap(int paramInt, float paramFloat) {
/*  71 */     if (paramInt < 0) throw new IllegalArgumentException("initialCapacity must be >= 0: " + paramInt); 
/*  72 */     if (paramInt > 1073741824) throw new IllegalArgumentException("initialCapacity is too large: " + paramInt); 
/*  73 */     this.capacity = nextPowerOfTwo(paramInt);
/*     */     
/*  75 */     if (paramFloat <= 0.0F) throw new IllegalArgumentException("loadFactor must be > 0: " + paramFloat); 
/*  76 */     this.loadFactor = paramFloat;
/*     */ 
/*     */     
/*  79 */     this.isBigTable = (this.capacity >>> 16 != 0);
/*     */     
/*  81 */     this.threshold = (int)(this.capacity * paramFloat);
/*  82 */     this.mask = this.capacity - 1;
/*  83 */     this.hashShift = 31 - Integer.numberOfTrailingZeros(this.capacity);
/*  84 */     this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(this.capacity)) << 1);
/*  85 */     this.pushIterations = Math.max(Math.min(this.capacity, 8), (int)Math.sqrt(this.capacity) / 8);
/*     */     
/*  87 */     this.keyTable = (K[])new Object[this.capacity + this.stashCapacity];
/*  88 */     this.valueTable = (V[])new Object[this.keyTable.length];
/*     */   }
/*     */ 
/*     */   
/*     */   public CuckooObjectMap(CuckooObjectMap<? extends K, ? extends V> paramCuckooObjectMap) {
/*  93 */     this(paramCuckooObjectMap.capacity, paramCuckooObjectMap.loadFactor);
/*  94 */     this.stashSize = paramCuckooObjectMap.stashSize;
/*  95 */     System.arraycopy(paramCuckooObjectMap.keyTable, 0, this.keyTable, 0, paramCuckooObjectMap.keyTable.length);
/*  96 */     System.arraycopy(paramCuckooObjectMap.valueTable, 0, this.valueTable, 0, paramCuckooObjectMap.valueTable.length);
/*  97 */     this.size = paramCuckooObjectMap.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 102 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 103 */     return put_internal(paramK, paramV);
/*     */   }
/*     */   
/*     */   private V put_internal(K paramK, V paramV) {
/*     */     V v;
/* 108 */     K k4, arrayOfK[] = this.keyTable;
/* 109 */     int i = this.mask;
/* 110 */     boolean bool = this.isBigTable;
/*     */     
/*     */     int j;
/*     */     
/* 114 */     i = (j = paramK.hashCode()) & i;
/* 115 */     K k1 = arrayOfK[i];
/* 116 */     if (paramK.equals(k1)) {
/* 117 */       V v1 = this.valueTable[i];
/* 118 */       this.valueTable[i] = paramV;
/* 119 */       return v1;
/*     */     } 
/*     */     
/* 122 */     int k = hash2(j);
/* 123 */     K k2 = arrayOfK[k];
/* 124 */     if (paramK.equals(k2)) {
/* 125 */       V v1 = this.valueTable[k];
/* 126 */       this.valueTable[k] = paramV;
/* 127 */       return v1;
/*     */     } 
/*     */     
/* 130 */     int m = hash3(j);
/* 131 */     K k3 = arrayOfK[m];
/* 132 */     if (paramK.equals(k3)) {
/* 133 */       V v1 = this.valueTable[m];
/* 134 */       this.valueTable[m] = paramV;
/* 135 */       return v1;
/*     */     } 
/*     */     
/* 138 */     int n = -1;
/* 139 */     Object object = null;
/* 140 */     if (bool) {
/* 141 */       n = hash4(j);
/* 142 */       k4 = arrayOfK[n];
/* 143 */       if (paramK.equals(k4)) {
/* 144 */         V v1 = this.valueTable[n];
/* 145 */         this.valueTable[n] = paramV;
/* 146 */         return v1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 151 */     for (int i1 = (j = this.capacity) + this.stashSize; j < i1; j++) {
/* 152 */       if (paramK.equals(arrayOfK[j])) {
/* 153 */         v = this.valueTable[j];
/* 154 */         this.valueTable[j] = paramV;
/* 155 */         return v;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 160 */     if (k1 == null) {
/* 161 */       arrayOfK[i] = (K)v;
/* 162 */       this.valueTable[i] = paramV;
/* 163 */       if (this.size++ >= this.threshold) resize(this.capacity << 1); 
/* 164 */       return null;
/*     */     } 
/*     */     
/* 167 */     if (k2 == null) {
/* 168 */       arrayOfK[k] = (K)v;
/* 169 */       this.valueTable[k] = paramV;
/* 170 */       if (this.size++ >= this.threshold) resize(this.capacity << 1); 
/* 171 */       return null;
/*     */     } 
/*     */     
/* 174 */     if (k3 == null) {
/* 175 */       arrayOfK[m] = (K)v;
/* 176 */       this.valueTable[m] = paramV;
/* 177 */       if (this.size++ >= this.threshold) resize(this.capacity << 1); 
/* 178 */       return null;
/*     */     } 
/*     */     
/* 181 */     if (bool && k4 == null) {
/* 182 */       arrayOfK[n] = (K)v;
/* 183 */       this.valueTable[n] = paramV;
/* 184 */       if (this.size++ >= this.threshold) resize(this.capacity << 1); 
/* 185 */       return null;
/*     */     } 
/*     */     
/* 188 */     push((K)v, paramV, i, k1, k, k2, m, k3, n, k4);
/* 189 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(CuckooObjectMap<K, V> paramCuckooObjectMap) {
/* 193 */     ensureCapacity(paramCuckooObjectMap.size);
/* 194 */     for (Entry entry : paramCuckooObjectMap.entries()) {
/* 195 */       put(entry.key, entry.value);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void putResize(K paramK, V paramV) {
/* 202 */     int i, j = (i = paramK.hashCode()) & this.mask;
/*     */     K k1;
/* 204 */     if ((k1 = this.keyTable[j]) == null) {
/* 205 */       this.keyTable[j] = paramK;
/* 206 */       this.valueTable[j] = paramV;
/* 207 */       if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */       
/*     */       return;
/*     */     } 
/* 211 */     int k = hash2(i);
/*     */     K k2;
/* 213 */     if ((k2 = this.keyTable[k]) == null) {
/* 214 */       this.keyTable[k] = paramK;
/* 215 */       this.valueTable[k] = paramV;
/* 216 */       if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */       
/*     */       return;
/*     */     } 
/* 220 */     int m = hash3(i);
/*     */     K k3;
/* 222 */     if ((k3 = this.keyTable[m]) == null) {
/* 223 */       this.keyTable[m] = paramK;
/* 224 */       this.valueTable[m] = paramV;
/* 225 */       if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */       
/*     */       return;
/*     */     } 
/* 229 */     int n = -1;
/* 230 */     Object object = null;
/*     */     
/* 232 */     n = hash4(i);
/*     */     K k4;
/* 234 */     if (this.isBigTable && (k4 = this.keyTable[n]) == null) {
/* 235 */       this.keyTable[n] = paramK;
/* 236 */       this.valueTable[n] = paramV;
/* 237 */       if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/* 242 */     push(paramK, paramV, j, k1, k, k2, m, k3, n, k4);
/*     */   }
/*     */   
/*     */   private void push(K paramK1, V paramV, int paramInt1, K paramK2, int paramInt2, K paramK3, int paramInt3, K paramK4, int paramInt4, K paramK5) {
/*     */     K k;
/*     */     V v;
/* 248 */     K[] arrayOfK = this.keyTable;
/* 249 */     V[] arrayOfV = this.valueTable;
/* 250 */     int i = this.mask;
/* 251 */     boolean bool = this.isBigTable;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     byte b1 = 0; int j = this.pushIterations;
/* 257 */     byte b2 = bool ? 4 : 3;
/*     */     
/*     */     while (true) {
/* 260 */       switch (random.nextInt(b2)) {
/*     */         case 0:
/* 262 */           k = paramK2;
/* 263 */           v = arrayOfV[paramInt1];
/* 264 */           arrayOfK[paramInt1] = paramK1;
/* 265 */           arrayOfV[paramInt1] = paramV;
/*     */           break;
/*     */         case 1:
/* 268 */           k = paramK3;
/* 269 */           v = arrayOfV[paramInt2];
/* 270 */           arrayOfK[paramInt2] = paramK1;
/* 271 */           arrayOfV[paramInt2] = paramV;
/*     */           break;
/*     */         case 2:
/* 274 */           k = paramK4;
/* 275 */           v = arrayOfV[paramInt3];
/* 276 */           arrayOfK[paramInt3] = paramK1;
/* 277 */           arrayOfV[paramInt3] = paramV;
/*     */           break;
/*     */         default:
/* 280 */           k = paramK5;
/* 281 */           v = arrayOfV[paramInt4];
/* 282 */           arrayOfK[paramInt4] = paramK1;
/* 283 */           arrayOfV[paramInt4] = paramV;
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/*     */       int m;
/* 289 */       paramInt1 = (m = k.hashCode()) & i;
/*     */       
/* 291 */       if ((paramK2 = arrayOfK[paramInt1]) == null) {
/* 292 */         arrayOfK[paramInt1] = k;
/* 293 */         arrayOfV[paramInt1] = v;
/* 294 */         if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */         
/*     */         return;
/*     */       } 
/* 298 */       paramInt2 = hash2(m);
/*     */       
/* 300 */       if ((paramK3 = arrayOfK[paramInt2]) == null) {
/* 301 */         arrayOfK[paramInt2] = k;
/* 302 */         arrayOfV[paramInt2] = v;
/* 303 */         if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */         
/*     */         return;
/*     */       } 
/* 307 */       paramInt3 = hash3(m);
/*     */       
/* 309 */       if ((paramK4 = arrayOfK[paramInt3]) == null) {
/* 310 */         arrayOfK[paramInt3] = k;
/* 311 */         arrayOfV[paramInt3] = v;
/* 312 */         if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 317 */       paramInt4 = hash4(m);
/*     */       
/* 319 */       if (bool && (paramK5 = arrayOfK[paramInt4]) == null) {
/* 320 */         arrayOfK[paramInt4] = k;
/* 321 */         arrayOfV[paramInt4] = v;
/* 322 */         if (this.size++ >= this.threshold) resize(this.capacity << 1);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 327 */       if (++b1 != j) {
/*     */         
/* 329 */         K k1 = k;
/* 330 */         paramV = v; continue;
/*     */       }  break;
/*     */     } 
/* 333 */     putStash(k, v);
/*     */   }
/*     */   
/*     */   private void putStash(K paramK, V paramV) {
/* 337 */     if (this.stashSize == this.stashCapacity) {
/*     */       
/* 339 */       resize(this.capacity << 1);
/* 340 */       put_internal(paramK, paramV);
/*     */       
/*     */       return;
/*     */     } 
/* 344 */     int i = this.capacity + this.stashSize;
/* 345 */     this.keyTable[i] = paramK;
/* 346 */     this.valueTable[i] = paramV;
/* 347 */     this.stashSize++;
/* 348 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(K paramK) {
/* 353 */     int i, j = (i = paramK.hashCode()) & this.mask;
/* 354 */     if (!paramK.equals(this.keyTable[j])) {
/* 355 */       j = hash2(i);
/* 356 */       if (!paramK.equals(this.keyTable[j])) {
/* 357 */         j = hash3(i);
/* 358 */         if (!paramK.equals(this.keyTable[j])) {
/* 359 */           if (this.isBigTable) {
/* 360 */             j = hash4(i);
/* 361 */             if (!paramK.equals(this.keyTable[j])) return getStash(paramK); 
/*     */           } else {
/* 363 */             return getStash(paramK);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 368 */     return this.valueTable[j];
/*     */   }
/*     */   
/*     */   private V getStash(K paramK) {
/* 372 */     K[] arrayOfK = this.keyTable; int i;
/* 373 */     for (int j = (i = this.capacity) + this.stashSize; i < j; i++) {
/* 374 */       if (paramK.equals(arrayOfK[i])) return this.valueTable[i]; 
/* 375 */     }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(K paramK, V paramV) {
/* 381 */     int i, j = (i = paramK.hashCode()) & this.mask;
/* 382 */     if (!paramK.equals(this.keyTable[j])) {
/* 383 */       j = hash2(i);
/* 384 */       if (!paramK.equals(this.keyTable[j])) {
/* 385 */         j = hash3(i);
/* 386 */         if (!paramK.equals(this.keyTable[j])) {
/* 387 */           if (this.isBigTable) {
/* 388 */             j = hash4(i);
/* 389 */             if (!paramK.equals(this.keyTable[j])) return getStash(paramK, paramV); 
/*     */           } else {
/* 391 */             return getStash(paramK, paramV);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 396 */     return this.valueTable[j];
/*     */   }
/*     */   
/*     */   private V getStash(K paramK, V paramV) {
/* 400 */     K[] arrayOfK = this.keyTable; int i;
/* 401 */     for (int j = (i = this.capacity) + this.stashSize; i < j; i++) {
/* 402 */       if (paramK.equals(arrayOfK[i])) return this.valueTable[i]; 
/* 403 */     }  return paramV;
/*     */   }
/*     */   
/*     */   public V remove(K paramK) {
/*     */     V v;
/* 408 */     int i, j = (i = paramK.hashCode()) & this.mask;
/* 409 */     if (paramK.equals(this.keyTable[j])) {
/* 410 */       this.keyTable[j] = null;
/* 411 */       v = this.valueTable[j];
/* 412 */       this.valueTable[j] = null;
/* 413 */       this.size--;
/* 414 */       return v;
/*     */     } 
/*     */     
/* 417 */     j = hash2(i);
/* 418 */     if (v.equals(this.keyTable[j])) {
/* 419 */       this.keyTable[j] = null;
/* 420 */       v = this.valueTable[j];
/* 421 */       this.valueTable[j] = null;
/* 422 */       this.size--;
/* 423 */       return v;
/*     */     } 
/*     */     
/* 426 */     j = hash3(i);
/* 427 */     if (v.equals(this.keyTable[j])) {
/* 428 */       this.keyTable[j] = null;
/* 429 */       v = this.valueTable[j];
/* 430 */       this.valueTable[j] = null;
/* 431 */       this.size--;
/* 432 */       return v;
/*     */     } 
/*     */     
/* 435 */     if (this.isBigTable) {
/* 436 */       j = hash4(i);
/* 437 */       if (v.equals(this.keyTable[j])) {
/* 438 */         this.keyTable[j] = null;
/* 439 */         v = this.valueTable[j];
/* 440 */         this.valueTable[j] = null;
/* 441 */         this.size--;
/* 442 */         return v;
/*     */       } 
/*     */     } 
/*     */     
/* 446 */     return removeStash((K)v);
/*     */   }
/*     */   
/*     */   V removeStash(K paramK) {
/* 450 */     K[] arrayOfK = this.keyTable; int i;
/* 451 */     for (int j = (i = this.capacity) + this.stashSize; i < j; i++) {
/* 452 */       if (paramK.equals(arrayOfK[i])) {
/* 453 */         V v = this.valueTable[i];
/* 454 */         removeStashIndex(i);
/* 455 */         this.size--;
/* 456 */         return v;
/*     */       } 
/*     */     } 
/* 459 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void removeStashIndex(int paramInt) {
/* 464 */     this.stashSize--;
/* 465 */     int i = this.capacity + this.stashSize;
/* 466 */     if (paramInt < i) {
/* 467 */       this.keyTable[paramInt] = this.keyTable[i];
/* 468 */       this.valueTable[paramInt] = this.valueTable[i];
/* 469 */       this.valueTable[i] = null; return;
/*     */     } 
/* 471 */     this.valueTable[paramInt] = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 477 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 478 */     if (this.size > paramInt) paramInt = this.size; 
/* 479 */     if (this.capacity <= paramInt)
/* 480 */       return;  paramInt = nextPowerOfTwo(paramInt);
/* 481 */     resize(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/* 486 */     if (this.capacity <= paramInt) {
/* 487 */       clear();
/*     */       return;
/*     */     } 
/* 490 */     this.size = 0;
/* 491 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 495 */     K[] arrayOfK = this.keyTable;
/* 496 */     V[] arrayOfV = this.valueTable;
/* 497 */     for (int i = this.capacity + this.stashSize; i-- > 0; ) {
/* 498 */       arrayOfK[i] = null;
/* 499 */       arrayOfV[i] = null;
/*     */     } 
/* 501 */     this.size = 0;
/* 502 */     this.stashSize = 0;
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
/*     */   public boolean containsValue(Object paramObject, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore_3
/*     */     //   5: aload_1
/*     */     //   6: ifnonnull -> 48
/*     */     //   9: aload_0
/*     */     //   10: getfield keyTable : [Ljava/lang/Object;
/*     */     //   13: astore_2
/*     */     //   14: aload_0
/*     */     //   15: getfield capacity : I
/*     */     //   18: aload_0
/*     */     //   19: getfield stashSize : I
/*     */     //   22: iadd
/*     */     //   23: istore_1
/*     */     //   24: iload_1
/*     */     //   25: iinc #1, -1
/*     */     //   28: ifle -> 45
/*     */     //   31: aload_2
/*     */     //   32: iload_1
/*     */     //   33: aaload
/*     */     //   34: ifnull -> 24
/*     */     //   37: aload_3
/*     */     //   38: iload_1
/*     */     //   39: aaload
/*     */     //   40: ifnonnull -> 24
/*     */     //   43: iconst_1
/*     */     //   44: ireturn
/*     */     //   45: goto -> 110
/*     */     //   48: iload_2
/*     */     //   49: ifeq -> 81
/*     */     //   52: aload_0
/*     */     //   53: getfield capacity : I
/*     */     //   56: aload_0
/*     */     //   57: getfield stashSize : I
/*     */     //   60: iadd
/*     */     //   61: istore_2
/*     */     //   62: iload_2
/*     */     //   63: iinc #2, -1
/*     */     //   66: ifle -> 78
/*     */     //   69: aload_3
/*     */     //   70: iload_2
/*     */     //   71: aaload
/*     */     //   72: aload_1
/*     */     //   73: if_acmpne -> 62
/*     */     //   76: iconst_1
/*     */     //   77: ireturn
/*     */     //   78: goto -> 110
/*     */     //   81: aload_0
/*     */     //   82: getfield capacity : I
/*     */     //   85: aload_0
/*     */     //   86: getfield stashSize : I
/*     */     //   89: iadd
/*     */     //   90: istore_2
/*     */     //   91: iload_2
/*     */     //   92: iinc #2, -1
/*     */     //   95: ifle -> 110
/*     */     //   98: aload_1
/*     */     //   99: aload_3
/*     */     //   100: iload_2
/*     */     //   101: aaload
/*     */     //   102: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   105: ifeq -> 91
/*     */     //   108: iconst_1
/*     */     //   109: ireturn
/*     */     //   110: iconst_0
/*     */     //   111: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #510	-> 0
/*     */     //   #511	-> 5
/*     */     //   #512	-> 9
/*     */     //   #513	-> 14
/*     */     //   #514	-> 31
/*     */     //   #515	-> 45
/*     */     //   #516	-> 52
/*     */     //   #517	-> 69
/*     */     //   #519	-> 81
/*     */     //   #520	-> 98
/*     */     //   #522	-> 110
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
/* 527 */     int i, j = (i = paramK.hashCode()) & this.mask;
/* 528 */     if (!paramK.equals(this.keyTable[j])) {
/* 529 */       j = hash2(i);
/* 530 */       if (!paramK.equals(this.keyTable[j])) {
/* 531 */         j = hash3(i);
/* 532 */         if (!paramK.equals(this.keyTable[j])) {
/* 533 */           if (this.isBigTable) {
/* 534 */             j = hash4(i);
/* 535 */             if (!paramK.equals(this.keyTable[j])) return containsKeyStash(paramK); 
/*     */           } else {
/* 537 */             return containsKeyStash(paramK);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 542 */     return true;
/*     */   }
/*     */   
/*     */   private boolean containsKeyStash(K paramK) {
/* 546 */     K[] arrayOfK = this.keyTable; int i;
/* 547 */     for (int j = (i = this.capacity) + this.stashSize; i < j; i++) {
/* 548 */       if (paramK.equals(arrayOfK[i])) return true; 
/* 549 */     }  return false;
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
/*     */   public K findKey(Object paramObject, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore_3
/*     */     //   5: aload_1
/*     */     //   6: ifnonnull -> 50
/*     */     //   9: aload_0
/*     */     //   10: getfield keyTable : [Ljava/lang/Object;
/*     */     //   13: astore_2
/*     */     //   14: aload_0
/*     */     //   15: getfield capacity : I
/*     */     //   18: aload_0
/*     */     //   19: getfield stashSize : I
/*     */     //   22: iadd
/*     */     //   23: istore_1
/*     */     //   24: iload_1
/*     */     //   25: iinc #1, -1
/*     */     //   28: ifle -> 47
/*     */     //   31: aload_2
/*     */     //   32: iload_1
/*     */     //   33: aaload
/*     */     //   34: ifnull -> 24
/*     */     //   37: aload_3
/*     */     //   38: iload_1
/*     */     //   39: aaload
/*     */     //   40: ifnonnull -> 24
/*     */     //   43: aload_2
/*     */     //   44: iload_1
/*     */     //   45: aaload
/*     */     //   46: areturn
/*     */     //   47: goto -> 122
/*     */     //   50: iload_2
/*     */     //   51: ifeq -> 88
/*     */     //   54: aload_0
/*     */     //   55: getfield capacity : I
/*     */     //   58: aload_0
/*     */     //   59: getfield stashSize : I
/*     */     //   62: iadd
/*     */     //   63: istore_2
/*     */     //   64: iload_2
/*     */     //   65: iinc #2, -1
/*     */     //   68: ifle -> 85
/*     */     //   71: aload_3
/*     */     //   72: iload_2
/*     */     //   73: aaload
/*     */     //   74: aload_1
/*     */     //   75: if_acmpne -> 64
/*     */     //   78: aload_0
/*     */     //   79: getfield keyTable : [Ljava/lang/Object;
/*     */     //   82: iload_2
/*     */     //   83: aaload
/*     */     //   84: areturn
/*     */     //   85: goto -> 122
/*     */     //   88: aload_0
/*     */     //   89: getfield capacity : I
/*     */     //   92: aload_0
/*     */     //   93: getfield stashSize : I
/*     */     //   96: iadd
/*     */     //   97: istore_2
/*     */     //   98: iload_2
/*     */     //   99: iinc #2, -1
/*     */     //   102: ifle -> 122
/*     */     //   105: aload_1
/*     */     //   106: aload_3
/*     */     //   107: iload_2
/*     */     //   108: aaload
/*     */     //   109: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   112: ifeq -> 98
/*     */     //   115: aload_0
/*     */     //   116: getfield keyTable : [Ljava/lang/Object;
/*     */     //   119: iload_2
/*     */     //   120: aaload
/*     */     //   121: areturn
/*     */     //   122: aconst_null
/*     */     //   123: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #557	-> 0
/*     */     //   #558	-> 5
/*     */     //   #559	-> 9
/*     */     //   #560	-> 14
/*     */     //   #561	-> 31
/*     */     //   #562	-> 47
/*     */     //   #563	-> 54
/*     */     //   #564	-> 71
/*     */     //   #566	-> 88
/*     */     //   #567	-> 105
/*     */     //   #569	-> 122
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
/* 576 */     if ((paramInt = this.size + paramInt) >= this.threshold) resize(nextPowerOfTwo((int)(paramInt / this.loadFactor))); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 580 */     int i = this.capacity + this.stashSize;
/*     */     
/* 582 */     this.capacity = paramInt;
/* 583 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 584 */     this.mask = paramInt - 1;
/* 585 */     this.hashShift = 31 - Integer.numberOfTrailingZeros(paramInt);
/* 586 */     this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(paramInt)) << 1);
/* 587 */     this.pushIterations = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
/*     */ 
/*     */     
/* 590 */     this.isBigTable = (this.capacity >>> 16 != 0);
/*     */     
/* 592 */     K[] arrayOfK = this.keyTable;
/* 593 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 595 */     this.keyTable = (K[])new Object[paramInt + this.stashCapacity];
/* 596 */     this.valueTable = (V[])new Object[paramInt + this.stashCapacity];
/*     */     
/* 598 */     paramInt = this.size;
/* 599 */     this.size = 0;
/* 600 */     this.stashSize = 0;
/* 601 */     if (paramInt > 0) {
/* 602 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         K k;
/* 604 */         if ((k = arrayOfK[paramInt]) != null) putResize(k, arrayOfV[paramInt]);
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private int hash2(int paramInt) {
/* 611 */     return ((paramInt = paramInt * -1105259343) ^ paramInt >>> this.hashShift) & this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   private int hash3(int paramInt) {
/* 616 */     return ((paramInt = paramInt * -1262997959) ^ paramInt >>> this.hashShift) & this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   private int hash4(int paramInt) {
/* 621 */     return ((paramInt = paramInt * -825114047) ^ paramInt >>> this.hashShift) & this.mask;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 625 */     if (this.size == 0) return "{}"; 
/*     */     StringBuilder stringBuilder;
/* 627 */     (stringBuilder = new StringBuilder(32)).append('{');
/* 628 */     K[] arrayOfK = this.keyTable;
/* 629 */     V[] arrayOfV = this.valueTable;
/* 630 */     int i = arrayOfK.length;
/* 631 */     while (i-- > 0) {
/*     */       K k;
/* 633 */       if ((k = arrayOfK[i]) != null) {
/* 634 */         stringBuilder.append(k);
/* 635 */         stringBuilder.append('=');
/* 636 */         stringBuilder.append(arrayOfV[i]); break;
/*     */       } 
/*     */     } 
/* 639 */     while (i-- > 0) {
/*     */       K k;
/* 641 */       if ((k = arrayOfK[i]) != null) {
/* 642 */         stringBuilder.append(", ");
/* 643 */         stringBuilder.append(k);
/* 644 */         stringBuilder.append('=');
/* 645 */         stringBuilder.append(arrayOfV[i]);
/*     */       } 
/* 647 */     }  stringBuilder.append('}');
/* 648 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entries<K, V> entries() {
/* 653 */     return new Entries<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 658 */     return new Values<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Keys<K> keys() {
/* 663 */     return new Keys<>(this);
/*     */   }
/*     */   
/*     */   public static class Entry<K, V> {
/*     */     public K key;
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 671 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapIterator<K, V> {
/*     */     public boolean hasNext;
/*     */     final CuckooObjectMap<K, V> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     
/*     */     public MapIterator(CuckooObjectMap<K, V> param1CuckooObjectMap) {
/* 682 */       this.map = param1CuckooObjectMap;
/* 683 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 687 */       this.currentIndex = -1;
/* 688 */       this.nextIndex = -1;
/* 689 */       advance();
/*     */     }
/*     */     
/*     */     void advance() {
/* 693 */       this.hasNext = false;
/* 694 */       K[] arrayOfK = this.map.keyTable;
/* 695 */       for (int i = this.map.capacity + this.map.stashSize; ++this.nextIndex < i;) {
/* 696 */         if (arrayOfK[this.nextIndex] != null) {
/* 697 */           this.hasNext = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void remove() {
/* 704 */       if (this.currentIndex < 0) throw new IllegalStateException("next must be called before remove."); 
/* 705 */       if (this.currentIndex >= this.map.capacity) {
/* 706 */         this.map.removeStashIndex(this.currentIndex);
/* 707 */         this.nextIndex = this.currentIndex - 1;
/* 708 */         advance();
/*     */       } else {
/* 710 */         this.map.keyTable[this.currentIndex] = null;
/* 711 */         this.map.valueTable[this.currentIndex] = null;
/*     */       } 
/* 713 */       this.currentIndex = -1;
/* 714 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<K, V> extends MapIterator<K, V> implements Iterable<Entry<K, V>>, Iterator<Entry<K, V>> {
/* 719 */     CuckooObjectMap.Entry<K, V> entry = new CuckooObjectMap.Entry<>();
/*     */     
/*     */     public Entries(CuckooObjectMap<K, V> param1CuckooObjectMap) {
/* 722 */       super(param1CuckooObjectMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public CuckooObjectMap.Entry<K, V> next() {
/* 727 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 728 */       K[] arrayOfK = this.map.keyTable;
/* 729 */       this.entry.key = arrayOfK[this.nextIndex];
/* 730 */       this.entry.value = this.map.valueTable[this.nextIndex];
/* 731 */       this.currentIndex = this.nextIndex;
/* 732 */       advance();
/* 733 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 737 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Iterator<CuckooObjectMap.Entry<K, V>> iterator() {
/* 741 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<Object, V> implements Iterable<V>, Iterator<V> {
/*     */     public Values(CuckooObjectMap<?, V> param1CuckooObjectMap) {
/* 747 */       super((CuckooObjectMap)param1CuckooObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 751 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public V next() {
/* 755 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 756 */       V v = this.map.valueTable[this.nextIndex];
/* 757 */       this.currentIndex = this.nextIndex;
/* 758 */       advance();
/* 759 */       return v;
/*     */     }
/*     */     
/*     */     public Iterator<V> iterator() {
/* 763 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<V> toArray() {
/* 768 */       ArrayList<V> arrayList = new ArrayList(this.map.size);
/* 769 */       while (this.hasNext)
/* 770 */         arrayList.add(next()); 
/* 771 */       return arrayList;
/*     */     }
/*     */ 
/*     */     
/*     */     public void toArray(ArrayList<V> param1ArrayList) {
/* 776 */       while (this.hasNext)
/* 777 */         param1ArrayList.add(next()); 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys<K> extends MapIterator<K, Object> implements Iterable<K>, Iterator<K> {
/*     */     public Keys(CuckooObjectMap<K, ?> param1CuckooObjectMap) {
/* 783 */       super((CuckooObjectMap)param1CuckooObjectMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 787 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 791 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 792 */       K k = this.map.keyTable[this.nextIndex];
/* 793 */       this.currentIndex = this.nextIndex;
/* 794 */       advance();
/* 795 */       return k;
/*     */     }
/*     */     
/*     */     public Iterator<K> iterator() {
/* 799 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<K> toArray() {
/* 804 */       ArrayList<K> arrayList = new ArrayList(this.map.size);
/* 805 */       while (this.hasNext)
/* 806 */         arrayList.add(next()); 
/* 807 */       return arrayList;
/*     */     }
/*     */   }
/*     */   
/*     */   public static int nextPowerOfTwo(int paramInt) {
/* 812 */     if (paramInt == 0) return 1; 
/* 813 */     paramInt--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 819 */     return (paramInt = (paramInt = (paramInt = (paramInt = (paramInt = paramInt | paramInt >> 1) | paramInt >> 2) | paramInt >> 4) | paramInt >> 8) | paramInt >> 16) + 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\CuckooObjectMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */