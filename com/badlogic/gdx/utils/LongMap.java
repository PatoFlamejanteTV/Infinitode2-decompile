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
/*     */ public class LongMap<V>
/*     */   implements Iterable<LongMap.Entry<V>>
/*     */ {
/*     */   public int size;
/*     */   long[] keyTable;
/*     */   V[] valueTable;
/*     */   V zeroValue;
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
/*     */   public LongMap() {
/*  74 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LongMap(int paramInt) {
/*  80 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongMap(int paramInt, float paramFloat) {
/*  87 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  88 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  89 */     this.loadFactor = paramFloat;
/*     */     
/*  91 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  92 */     this.threshold = (int)(paramInt * paramFloat);
/*  93 */     this.mask = paramInt - 1;
/*  94 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  96 */     this.keyTable = new long[paramInt];
/*  97 */     this.valueTable = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public LongMap(LongMap<? extends V> paramLongMap) {
/* 102 */     this((int)(paramLongMap.keyTable.length * paramLongMap.loadFactor), paramLongMap.loadFactor);
/* 103 */     System.arraycopy(paramLongMap.keyTable, 0, this.keyTable, 0, paramLongMap.keyTable.length);
/* 104 */     System.arraycopy(paramLongMap.valueTable, 0, this.valueTable, 0, paramLongMap.valueTable.length);
/* 105 */     this.size = paramLongMap.size;
/* 106 */     this.zeroValue = paramLongMap.zeroValue;
/* 107 */     this.hasZeroValue = paramLongMap.hasZeroValue;
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
/*     */   protected int place(long paramLong) {
/* 125 */     return (int)((paramLong ^ paramLong >>> 32L) * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int locateKey(long paramLong) {
/* 131 */     long[] arrayOfLong = this.keyTable; int i;
/* 132 */     for (i = place(paramLong);; i = i + 1 & this.mask) {
/*     */       long l;
/* 134 */       if ((l = arrayOfLong[i]) == 0L) return -(i + 1); 
/* 135 */       if (l == paramLong) return i; 
/*     */     } 
/*     */   } @Null
/*     */   public V put(long paramLong, @Null V paramV) {
/*     */     V v;
/* 140 */     if (paramLong == 0L) {
/* 141 */       V v1 = this.zeroValue;
/* 142 */       this.zeroValue = paramV;
/* 143 */       if (!this.hasZeroValue) {
/* 144 */         this.hasZeroValue = true;
/* 145 */         this.size++;
/*     */       } 
/* 147 */       return v1;
/*     */     } 
/*     */     int i;
/* 150 */     if ((i = locateKey(paramLong)) >= 0) {
/* 151 */       v = this.valueTable[i];
/* 152 */       this.valueTable[i] = paramV;
/* 153 */       return v;
/*     */     } 
/* 155 */     i = -(i + 1);
/* 156 */     this.keyTable[i] = v;
/* 157 */     this.valueTable[i] = paramV;
/* 158 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 159 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(LongMap<? extends V> paramLongMap) {
/* 163 */     ensureCapacity(paramLongMap.size);
/* 164 */     if (paramLongMap.hasZeroValue) put(0L, paramLongMap.zeroValue); 
/* 165 */     long[] arrayOfLong = paramLongMap.keyTable;
/* 166 */     V[] arrayOfV = paramLongMap.valueTable; byte b; int i;
/* 167 */     for (b = 0, i = arrayOfLong.length; b < i; b++) {
/*     */       long l;
/* 169 */       if ((l = arrayOfLong[b]) != 0L) put(l, arrayOfV[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(long paramLong, @Null V paramV) {
/* 175 */     long[] arrayOfLong = this.keyTable; int i;
/* 176 */     for (i = place(paramLong);; i = i + 1 & this.mask) {
/* 177 */       if (arrayOfLong[i] == 0L) {
/* 178 */         arrayOfLong[i] = paramLong;
/* 179 */         this.valueTable[i] = paramV;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public V get(long paramLong) {
/* 186 */     if (paramLong == 0L) return this.hasZeroValue ? this.zeroValue : null; 
/*     */     int i;
/* 188 */     return ((i = locateKey(paramLong)) >= 0) ? this.valueTable[i] : null;
/*     */   }
/*     */   
/*     */   public V get(long paramLong, @Null V paramV) {
/* 192 */     if (paramLong == 0L) return this.hasZeroValue ? this.zeroValue : paramV; 
/*     */     int i;
/* 194 */     return ((i = locateKey(paramLong)) >= 0) ? this.valueTable[i] : paramV;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V remove(long paramLong) {
/* 199 */     if (paramLong == 0L) {
/* 200 */       if (!this.hasZeroValue) return null; 
/* 201 */       this.hasZeroValue = false;
/* 202 */       V v1 = this.zeroValue;
/* 203 */       this.zeroValue = null;
/* 204 */       this.size--;
/* 205 */       return v1;
/*     */     } 
/*     */     
/*     */     int i;
/* 209 */     if ((i = locateKey(paramLong)) < 0) return null; 
/* 210 */     long[] arrayOfLong = this.keyTable;
/*     */     
/* 212 */     V arrayOfV[], v = (arrayOfV = this.valueTable)[i];
/* 213 */     int j = this.mask, k = i + 1 & j;
/* 214 */     while ((paramLong = arrayOfLong[k]) != 0L) {
/* 215 */       int m = place(paramLong);
/* 216 */       if ((k - m & j) > (i - m & j)) {
/* 217 */         arrayOfLong[i] = paramLong;
/* 218 */         arrayOfV[i] = arrayOfV[k];
/* 219 */         i = k;
/*     */       } 
/* 221 */       k = k + 1 & j;
/*     */     } 
/* 223 */     arrayOfLong[i] = 0L;
/* 224 */     arrayOfV[i] = null;
/* 225 */     this.size--;
/* 226 */     return v;
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
/* 256 */     this.hasZeroValue = false;
/* 257 */     this.zeroValue = null;
/* 258 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 262 */     if (this.size == 0)
/* 263 */       return;  this.size = 0;
/* 264 */     Arrays.fill(this.keyTable, 0L);
/* 265 */     Arrays.fill((Object[])this.valueTable, (Object)null);
/* 266 */     this.zeroValue = null;
/* 267 */     this.hasZeroValue = false;
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
/*     */   public boolean containsValue(@Null Object paramObject, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore_3
/*     */     //   5: aload_1
/*     */     //   6: ifnonnull -> 64
/*     */     //   9: aload_0
/*     */     //   10: getfield hasZeroValue : Z
/*     */     //   13: ifeq -> 25
/*     */     //   16: aload_0
/*     */     //   17: getfield zeroValue : Ljava/lang/Object;
/*     */     //   20: ifnonnull -> 25
/*     */     //   23: iconst_1
/*     */     //   24: ireturn
/*     */     //   25: aload_0
/*     */     //   26: getfield keyTable : [J
/*     */     //   29: astore_2
/*     */     //   30: aload_3
/*     */     //   31: arraylength
/*     */     //   32: iconst_1
/*     */     //   33: isub
/*     */     //   34: istore_1
/*     */     //   35: iload_1
/*     */     //   36: iflt -> 61
/*     */     //   39: aload_2
/*     */     //   40: iload_1
/*     */     //   41: laload
/*     */     //   42: lconst_0
/*     */     //   43: lcmp
/*     */     //   44: ifeq -> 55
/*     */     //   47: aload_3
/*     */     //   48: iload_1
/*     */     //   49: aaload
/*     */     //   50: ifnonnull -> 55
/*     */     //   53: iconst_1
/*     */     //   54: ireturn
/*     */     //   55: iinc #1, -1
/*     */     //   58: goto -> 35
/*     */     //   61: goto -> 152
/*     */     //   64: iload_2
/*     */     //   65: ifeq -> 105
/*     */     //   68: aload_1
/*     */     //   69: aload_0
/*     */     //   70: getfield zeroValue : Ljava/lang/Object;
/*     */     //   73: if_acmpne -> 78
/*     */     //   76: iconst_1
/*     */     //   77: ireturn
/*     */     //   78: aload_3
/*     */     //   79: arraylength
/*     */     //   80: iconst_1
/*     */     //   81: isub
/*     */     //   82: istore_2
/*     */     //   83: iload_2
/*     */     //   84: iflt -> 102
/*     */     //   87: aload_3
/*     */     //   88: iload_2
/*     */     //   89: aaload
/*     */     //   90: aload_1
/*     */     //   91: if_acmpne -> 96
/*     */     //   94: iconst_1
/*     */     //   95: ireturn
/*     */     //   96: iinc #2, -1
/*     */     //   99: goto -> 83
/*     */     //   102: goto -> 152
/*     */     //   105: aload_0
/*     */     //   106: getfield hasZeroValue : Z
/*     */     //   109: ifeq -> 125
/*     */     //   112: aload_1
/*     */     //   113: aload_0
/*     */     //   114: getfield zeroValue : Ljava/lang/Object;
/*     */     //   117: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   120: ifeq -> 125
/*     */     //   123: iconst_1
/*     */     //   124: ireturn
/*     */     //   125: aload_3
/*     */     //   126: arraylength
/*     */     //   127: iconst_1
/*     */     //   128: isub
/*     */     //   129: istore_2
/*     */     //   130: iload_2
/*     */     //   131: iflt -> 152
/*     */     //   134: aload_1
/*     */     //   135: aload_3
/*     */     //   136: iload_2
/*     */     //   137: aaload
/*     */     //   138: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   141: ifeq -> 146
/*     */     //   144: iconst_1
/*     */     //   145: ireturn
/*     */     //   146: iinc #2, -1
/*     */     //   149: goto -> 130
/*     */     //   152: iconst_0
/*     */     //   153: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #275	-> 0
/*     */     //   #276	-> 5
/*     */     //   #277	-> 9
/*     */     //   #278	-> 25
/*     */     //   #279	-> 30
/*     */     //   #280	-> 39
/*     */     //   #279	-> 55
/*     */     //   #281	-> 61
/*     */     //   #282	-> 68
/*     */     //   #283	-> 78
/*     */     //   #284	-> 87
/*     */     //   #283	-> 96
/*     */     //   #286	-> 105
/*     */     //   #287	-> 125
/*     */     //   #288	-> 134
/*     */     //   #287	-> 146
/*     */     //   #290	-> 152
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
/*     */   public boolean containsKey(long paramLong) {
/* 295 */     if (paramLong == 0L) return this.hasZeroValue; 
/* 296 */     return (locateKey(paramLong) >= 0);
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
/*     */   public long findKey(@Null Object paramObject, boolean paramBoolean, long paramLong) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore #5
/*     */     //   6: aload_1
/*     */     //   7: ifnonnull -> 69
/*     */     //   10: aload_0
/*     */     //   11: getfield hasZeroValue : Z
/*     */     //   14: ifeq -> 26
/*     */     //   17: aload_0
/*     */     //   18: getfield zeroValue : Ljava/lang/Object;
/*     */     //   21: ifnonnull -> 26
/*     */     //   24: lconst_0
/*     */     //   25: lreturn
/*     */     //   26: aload_0
/*     */     //   27: getfield keyTable : [J
/*     */     //   30: astore_2
/*     */     //   31: aload #5
/*     */     //   33: arraylength
/*     */     //   34: iconst_1
/*     */     //   35: isub
/*     */     //   36: istore_1
/*     */     //   37: iload_1
/*     */     //   38: iflt -> 66
/*     */     //   41: aload_2
/*     */     //   42: iload_1
/*     */     //   43: laload
/*     */     //   44: lconst_0
/*     */     //   45: lcmp
/*     */     //   46: ifeq -> 60
/*     */     //   49: aload #5
/*     */     //   51: iload_1
/*     */     //   52: aaload
/*     */     //   53: ifnonnull -> 60
/*     */     //   56: aload_2
/*     */     //   57: iload_1
/*     */     //   58: laload
/*     */     //   59: lreturn
/*     */     //   60: iinc #1, -1
/*     */     //   63: goto -> 37
/*     */     //   66: goto -> 171
/*     */     //   69: iload_2
/*     */     //   70: ifeq -> 117
/*     */     //   73: aload_1
/*     */     //   74: aload_0
/*     */     //   75: getfield zeroValue : Ljava/lang/Object;
/*     */     //   78: if_acmpne -> 83
/*     */     //   81: lconst_0
/*     */     //   82: lreturn
/*     */     //   83: aload #5
/*     */     //   85: arraylength
/*     */     //   86: iconst_1
/*     */     //   87: isub
/*     */     //   88: istore_2
/*     */     //   89: iload_2
/*     */     //   90: iflt -> 114
/*     */     //   93: aload #5
/*     */     //   95: iload_2
/*     */     //   96: aaload
/*     */     //   97: aload_1
/*     */     //   98: if_acmpne -> 108
/*     */     //   101: aload_0
/*     */     //   102: getfield keyTable : [J
/*     */     //   105: iload_2
/*     */     //   106: laload
/*     */     //   107: lreturn
/*     */     //   108: iinc #2, -1
/*     */     //   111: goto -> 89
/*     */     //   114: goto -> 171
/*     */     //   117: aload_0
/*     */     //   118: getfield hasZeroValue : Z
/*     */     //   121: ifeq -> 137
/*     */     //   124: aload_1
/*     */     //   125: aload_0
/*     */     //   126: getfield zeroValue : Ljava/lang/Object;
/*     */     //   129: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   132: ifeq -> 137
/*     */     //   135: lconst_0
/*     */     //   136: lreturn
/*     */     //   137: aload #5
/*     */     //   139: arraylength
/*     */     //   140: iconst_1
/*     */     //   141: isub
/*     */     //   142: istore_2
/*     */     //   143: iload_2
/*     */     //   144: iflt -> 171
/*     */     //   147: aload_1
/*     */     //   148: aload #5
/*     */     //   150: iload_2
/*     */     //   151: aaload
/*     */     //   152: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   155: ifeq -> 165
/*     */     //   158: aload_0
/*     */     //   159: getfield keyTable : [J
/*     */     //   162: iload_2
/*     */     //   163: laload
/*     */     //   164: lreturn
/*     */     //   165: iinc #2, -1
/*     */     //   168: goto -> 143
/*     */     //   171: lload_3
/*     */     //   172: lreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #304	-> 0
/*     */     //   #305	-> 6
/*     */     //   #306	-> 10
/*     */     //   #307	-> 26
/*     */     //   #308	-> 31
/*     */     //   #309	-> 41
/*     */     //   #308	-> 60
/*     */     //   #310	-> 66
/*     */     //   #311	-> 73
/*     */     //   #312	-> 83
/*     */     //   #313	-> 93
/*     */     //   #312	-> 108
/*     */     //   #315	-> 117
/*     */     //   #316	-> 137
/*     */     //   #317	-> 147
/*     */     //   #316	-> 165
/*     */     //   #319	-> 171
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
/*     */   public void ensureCapacity(int paramInt) {
/* 325 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 326 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 330 */     int i = this.keyTable.length;
/* 331 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 332 */     this.mask = paramInt - 1;
/* 333 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 335 */     long[] arrayOfLong = this.keyTable;
/* 336 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 338 */     this.keyTable = new long[paramInt];
/* 339 */     this.valueTable = (V[])new Object[paramInt];
/*     */     
/* 341 */     if (this.size > 0)
/* 342 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         long l;
/* 344 */         if ((l = arrayOfLong[paramInt]) != 0L) putResize(l, arrayOfV[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 350 */     int i = this.size;
/* 351 */     if (this.hasZeroValue && this.zeroValue != null) i += this.zeroValue.hashCode(); 
/* 352 */     long[] arrayOfLong = this.keyTable;
/* 353 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 354 */     for (b = 0, j = arrayOfLong.length; b < j; b++) {
/*     */ 
/*     */       
/* 357 */       i = (int)(i + l * 31L); V v;
/*     */       long l;
/* 359 */       if ((l = arrayOfLong[b]) != 0L && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 362 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 366 */     if (paramObject == this) return true; 
/* 367 */     if (!(paramObject instanceof LongMap)) return false;
/*     */     
/* 369 */     if (((LongMap)(paramObject = paramObject)).size != this.size) return false; 
/* 370 */     if (((LongMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 371 */     if (this.hasZeroValue) {
/* 372 */       if (((LongMap)paramObject).zeroValue == null)
/* 373 */       { if (this.zeroValue != null) return false;
/*     */          }
/* 375 */       else if (!((LongMap)paramObject).zeroValue.equals(this.zeroValue)) { return false; }
/*     */     
/*     */     }
/* 378 */     long[] arrayOfLong = this.keyTable;
/* 379 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 380 */     for (b = 0, i = arrayOfLong.length; b < i; b++) {
/*     */       long l;
/* 382 */       if ((l = arrayOfLong[b]) != 0L) {
/*     */         V v;
/* 384 */         if ((v = arrayOfV[b]) == null)
/* 385 */         { if (paramObject.get(l, ObjectMap.dummy) != null) return false;
/*     */            }
/* 387 */         else if (!v.equals(paramObject.get(l))) { return false; }
/*     */       
/*     */       } 
/*     */     } 
/* 391 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(@Null Object paramObject) {
/* 396 */     if (paramObject == this) return true; 
/* 397 */     if (!(paramObject instanceof LongMap)) return false;
/*     */     
/* 399 */     if (((LongMap)(paramObject = paramObject)).size != this.size) return false; 
/* 400 */     if (((LongMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 401 */     if (this.hasZeroValue && this.zeroValue != ((LongMap)paramObject).zeroValue) return false; 
/* 402 */     long[] arrayOfLong = this.keyTable;
/* 403 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 404 */     for (b = 0, i = arrayOfLong.length; b < i; b++) {
/*     */       long l;
/* 406 */       if ((l = arrayOfLong[b]) != 0L && arrayOfV[b] != paramObject.get(l, (V)ObjectMap.dummy)) return false; 
/*     */     } 
/* 408 */     return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 412 */     if (this.size == 0) return "[]"; 
/*     */     java.lang.StringBuilder stringBuilder;
/* 414 */     (stringBuilder = new java.lang.StringBuilder(32)).append('[');
/* 415 */     long[] arrayOfLong = this.keyTable;
/* 416 */     V[] arrayOfV = this.valueTable;
/* 417 */     int i = arrayOfLong.length;
/* 418 */     if (this.hasZeroValue) {
/* 419 */       stringBuilder.append("0=");
/* 420 */       stringBuilder.append(this.zeroValue);
/*     */     } else {
/* 422 */       while (i-- > 0) {
/*     */         long l;
/* 424 */         if ((l = arrayOfLong[i]) != 0L) {
/* 425 */           stringBuilder.append(l);
/* 426 */           stringBuilder.append('=');
/* 427 */           stringBuilder.append(arrayOfV[i]); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 431 */     while (i-- > 0) {
/*     */       long l;
/* 433 */       if ((l = arrayOfLong[i]) != 0L) {
/* 434 */         stringBuilder.append(", ");
/* 435 */         stringBuilder.append(l);
/* 436 */         stringBuilder.append('=');
/* 437 */         stringBuilder.append(arrayOfV[i]);
/*     */       } 
/* 439 */     }  stringBuilder.append(']');
/* 440 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<Entry<V>> iterator() {
/* 444 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<V> entries() {
/* 452 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 453 */     if (this.entries1 == null) {
/* 454 */       this.entries1 = new Entries(this);
/* 455 */       this.entries2 = new Entries(this);
/*     */     } 
/* 457 */     if (!this.entries1.valid) {
/* 458 */       this.entries1.reset();
/* 459 */       this.entries1.valid = true;
/* 460 */       this.entries2.valid = false;
/* 461 */       return this.entries1;
/*     */     } 
/* 463 */     this.entries2.reset();
/* 464 */     this.entries2.valid = true;
/* 465 */     this.entries1.valid = false;
/* 466 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 474 */     if (Collections.allocateIterators) return new Values<>(this); 
/* 475 */     if (this.values1 == null) {
/* 476 */       this.values1 = new Values(this);
/* 477 */       this.values2 = new Values(this);
/*     */     } 
/* 479 */     if (!this.values1.valid) {
/* 480 */       this.values1.reset();
/* 481 */       this.values1.valid = true;
/* 482 */       this.values2.valid = false;
/* 483 */       return this.values1;
/*     */     } 
/* 485 */     this.values2.reset();
/* 486 */     this.values2.valid = true;
/* 487 */     this.values1.valid = false;
/* 488 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys keys() {
/* 496 */     if (Collections.allocateIterators) return new Keys(this); 
/* 497 */     if (this.keys1 == null) {
/* 498 */       this.keys1 = new Keys(this);
/* 499 */       this.keys2 = new Keys(this);
/*     */     } 
/* 501 */     if (!this.keys1.valid) {
/* 502 */       this.keys1.reset();
/* 503 */       this.keys1.valid = true;
/* 504 */       this.keys2.valid = false;
/* 505 */       return this.keys1;
/*     */     } 
/* 507 */     this.keys2.reset();
/* 508 */     this.keys2.valid = true;
/* 509 */     this.keys1.valid = false;
/* 510 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry<V> { public long key;
/*     */     @Null
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 518 */       return this.key + "=" + this.value;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class MapIterator<V>
/*     */   {
/*     */     private static final int INDEX_ILLEGAL = -2;
/*     */     static final int INDEX_ZERO = -1;
/*     */     public boolean hasNext;
/*     */     final LongMap<V> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(LongMap<V> param1LongMap) {
/* 533 */       this.map = param1LongMap;
/* 534 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 538 */       this.currentIndex = -2;
/* 539 */       this.nextIndex = -1;
/* 540 */       if (this.map.hasZeroValue) {
/* 541 */         this.hasNext = true; return;
/*     */       } 
/* 543 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       long[] arrayOfLong;
/* 548 */       for (int i = (arrayOfLong = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 549 */         if (arrayOfLong[this.nextIndex] != 0L) {
/* 550 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 554 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 559 */       if ((i = this.currentIndex) == -1 && this.map.hasZeroValue)
/* 560 */       { this.map.hasZeroValue = false;
/* 561 */         this.map.zeroValue = null; }
/* 562 */       else { if (i < 0) {
/* 563 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 565 */         long[] arrayOfLong = this.map.keyTable;
/* 566 */         V[] arrayOfV = this.map.valueTable;
/* 567 */         int j = this.map.mask, k = i + 1 & j;
/*     */         long l;
/* 569 */         while ((l = arrayOfLong[k]) != 0L) {
/* 570 */           int m = this.map.place(l);
/* 571 */           if ((k - m & j) > (i - m & j)) {
/* 572 */             arrayOfLong[i] = l;
/* 573 */             arrayOfV[i] = arrayOfV[k];
/* 574 */             i = k;
/*     */           } 
/* 576 */           k = k + 1 & j;
/*     */         } 
/* 578 */         arrayOfLong[i] = 0L;
/* 579 */         arrayOfV[i] = null;
/* 580 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 582 */       this.currentIndex = -2;
/* 583 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
/* 588 */     private final LongMap.Entry<V> entry = new LongMap.Entry<>();
/*     */     
/*     */     public Entries(LongMap<V> param1LongMap) {
/* 591 */       super(param1LongMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public LongMap.Entry<V> next() {
/* 596 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 597 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 598 */       long[] arrayOfLong = this.map.keyTable;
/* 599 */       if (this.nextIndex == -1) {
/* 600 */         this.entry.key = 0L;
/* 601 */         this.entry.value = this.map.zeroValue;
/*     */       } else {
/* 603 */         this.entry.key = arrayOfLong[this.nextIndex];
/* 604 */         this.entry.value = this.map.valueTable[this.nextIndex];
/*     */       } 
/* 606 */       this.currentIndex = this.nextIndex;
/* 607 */       findNextIndex();
/* 608 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 612 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 613 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Iterator<LongMap.Entry<V>> iterator() {
/* 617 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<V> implements Iterable<V>, Iterator<V> {
/*     */     public Values(LongMap<V> param1LongMap) {
/* 623 */       super(param1LongMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 627 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 628 */       return this.hasNext;
/*     */     } @Null
/*     */     public V next() {
/*     */       V v;
/* 632 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 633 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested.");
/*     */       
/* 635 */       if (this.nextIndex == -1) {
/* 636 */         v = this.map.zeroValue;
/*     */       } else {
/* 638 */         v = this.map.valueTable[this.nextIndex];
/* 639 */       }  this.currentIndex = this.nextIndex;
/* 640 */       findNextIndex();
/* 641 */       return v;
/*     */     }
/*     */     
/*     */     public Iterator<V> iterator() {
/* 645 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<V> toArray() {
/* 650 */       Array<V> array = new Array(true, this.map.size);
/* 651 */       while (this.hasNext)
/* 652 */         array.add(next()); 
/* 653 */       return array;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys extends MapIterator {
/*     */     public Keys(LongMap<V> param1LongMap) {
/* 659 */       super(param1LongMap);
/*     */     }
/*     */     
/*     */     public long next() {
/* 663 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 664 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 665 */       long l = (this.nextIndex == -1) ? 0L : this.map.keyTable[this.nextIndex];
/* 666 */       this.currentIndex = this.nextIndex;
/* 667 */       findNextIndex();
/* 668 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     public LongArray toArray() {
/* 673 */       LongArray longArray = new LongArray(true, this.map.size);
/* 674 */       while (this.hasNext)
/* 675 */         longArray.add(next()); 
/* 676 */       return longArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public LongArray toArray(LongArray param1LongArray) {
/* 681 */       while (this.hasNext)
/* 682 */         param1LongArray.add(next()); 
/* 683 */       return param1LongArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\LongMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */