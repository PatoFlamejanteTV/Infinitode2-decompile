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
/*     */ public class IntMap<V>
/*     */   implements Iterable<IntMap.Entry<V>>
/*     */ {
/*     */   public int size;
/*     */   int[] keyTable;
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
/*     */   public IntMap() {
/*  74 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntMap(int paramInt) {
/*  81 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntMap(int paramInt, float paramFloat) {
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
/*  98 */     this.valueTable = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public IntMap(IntMap<? extends V> paramIntMap) {
/* 103 */     this((int)(paramIntMap.keyTable.length * paramIntMap.loadFactor), paramIntMap.loadFactor);
/* 104 */     System.arraycopy(paramIntMap.keyTable, 0, this.keyTable, 0, paramIntMap.keyTable.length);
/* 105 */     System.arraycopy(paramIntMap.valueTable, 0, this.valueTable, 0, paramIntMap.valueTable.length);
/* 106 */     this.size = paramIntMap.size;
/* 107 */     this.zeroValue = paramIntMap.zeroValue;
/* 108 */     this.hasZeroValue = paramIntMap.hasZeroValue;
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
/*     */   } @Null
/*     */   public V put(int paramInt, @Null V paramV) {
/*     */     V v;
/* 141 */     if (paramInt == 0) {
/* 142 */       V v1 = this.zeroValue;
/* 143 */       this.zeroValue = paramV;
/* 144 */       if (!this.hasZeroValue) {
/* 145 */         this.hasZeroValue = true;
/* 146 */         this.size++;
/*     */       } 
/* 148 */       return v1;
/*     */     } 
/*     */     int i;
/* 151 */     if ((i = locateKey(paramInt)) >= 0) {
/* 152 */       v = this.valueTable[i];
/* 153 */       this.valueTable[i] = paramV;
/* 154 */       return v;
/*     */     } 
/* 156 */     i = -(i + 1);
/* 157 */     this.keyTable[i] = v;
/* 158 */     this.valueTable[i] = paramV;
/* 159 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 160 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(IntMap<? extends V> paramIntMap) {
/* 164 */     ensureCapacity(paramIntMap.size);
/* 165 */     if (paramIntMap.hasZeroValue) put(0, paramIntMap.zeroValue); 
/* 166 */     int[] arrayOfInt = paramIntMap.keyTable;
/* 167 */     V[] arrayOfV = paramIntMap.valueTable; byte b; int i;
/* 168 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 170 */       if ((j = arrayOfInt[b]) != 0) put(j, arrayOfV[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(int paramInt, @Null V paramV) {
/* 176 */     int[] arrayOfInt = this.keyTable; int i;
/* 177 */     for (i = place(paramInt);; i = i + 1 & this.mask) {
/* 178 */       if (arrayOfInt[i] == 0) {
/* 179 */         arrayOfInt[i] = paramInt;
/* 180 */         this.valueTable[i] = paramV;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public V get(int paramInt) {
/* 187 */     if (paramInt == 0) return this.hasZeroValue ? this.zeroValue : null;
/*     */     
/* 189 */     return ((paramInt = locateKey(paramInt)) >= 0) ? this.valueTable[paramInt] : null;
/*     */   }
/*     */   
/*     */   public V get(int paramInt, @Null V paramV) {
/* 193 */     if (paramInt == 0) return this.hasZeroValue ? this.zeroValue : paramV;
/*     */     
/* 195 */     return ((paramInt = locateKey(paramInt)) >= 0) ? this.valueTable[paramInt] : paramV;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V remove(int paramInt) {
/* 200 */     if (paramInt == 0) {
/* 201 */       if (!this.hasZeroValue) return null; 
/* 202 */       this.hasZeroValue = false;
/* 203 */       V v1 = this.zeroValue;
/* 204 */       this.zeroValue = null;
/* 205 */       this.size--;
/* 206 */       return v1;
/*     */     } 
/*     */     
/*     */     int i;
/* 210 */     if ((i = locateKey(paramInt)) < 0) return null; 
/* 211 */     int[] arrayOfInt = this.keyTable;
/*     */     
/* 213 */     V arrayOfV[], v = (arrayOfV = this.valueTable)[i];
/* 214 */     int j = this.mask, k = i + 1 & j;
/* 215 */     while ((paramInt = arrayOfInt[k]) != 0) {
/* 216 */       int m = place(paramInt);
/* 217 */       if ((k - m & j) > (i - m & j)) {
/* 218 */         arrayOfInt[i] = paramInt;
/* 219 */         arrayOfV[i] = arrayOfV[k];
/* 220 */         i = k;
/*     */       } 
/* 222 */       k = k + 1 & j;
/*     */     } 
/* 224 */     arrayOfInt[i] = 0;
/* 225 */     arrayOfV[i] = null;
/* 226 */     this.size--;
/* 227 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 232 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 237 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 244 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 245 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 246 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 251 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 252 */     if (this.keyTable.length <= paramInt) {
/* 253 */       clear();
/*     */       return;
/*     */     } 
/* 256 */     this.size = 0;
/* 257 */     this.hasZeroValue = false;
/* 258 */     this.zeroValue = null;
/* 259 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 263 */     if (this.size == 0)
/* 264 */       return;  this.size = 0;
/* 265 */     Arrays.fill(this.keyTable, 0);
/* 266 */     Arrays.fill((Object[])this.valueTable, (Object)null);
/* 267 */     this.zeroValue = null;
/* 268 */     this.hasZeroValue = false;
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
/*     */     //   6: ifnonnull -> 62
/*     */     //   9: aload_0
/*     */     //   10: getfield hasZeroValue : Z
/*     */     //   13: ifeq -> 25
/*     */     //   16: aload_0
/*     */     //   17: getfield zeroValue : Ljava/lang/Object;
/*     */     //   20: ifnonnull -> 25
/*     */     //   23: iconst_1
/*     */     //   24: ireturn
/*     */     //   25: aload_0
/*     */     //   26: getfield keyTable : [I
/*     */     //   29: astore_2
/*     */     //   30: aload_3
/*     */     //   31: arraylength
/*     */     //   32: iconst_1
/*     */     //   33: isub
/*     */     //   34: istore_1
/*     */     //   35: iload_1
/*     */     //   36: iflt -> 59
/*     */     //   39: aload_2
/*     */     //   40: iload_1
/*     */     //   41: iaload
/*     */     //   42: ifeq -> 53
/*     */     //   45: aload_3
/*     */     //   46: iload_1
/*     */     //   47: aaload
/*     */     //   48: ifnonnull -> 53
/*     */     //   51: iconst_1
/*     */     //   52: ireturn
/*     */     //   53: iinc #1, -1
/*     */     //   56: goto -> 35
/*     */     //   59: goto -> 150
/*     */     //   62: iload_2
/*     */     //   63: ifeq -> 103
/*     */     //   66: aload_1
/*     */     //   67: aload_0
/*     */     //   68: getfield zeroValue : Ljava/lang/Object;
/*     */     //   71: if_acmpne -> 76
/*     */     //   74: iconst_1
/*     */     //   75: ireturn
/*     */     //   76: aload_3
/*     */     //   77: arraylength
/*     */     //   78: iconst_1
/*     */     //   79: isub
/*     */     //   80: istore_2
/*     */     //   81: iload_2
/*     */     //   82: iflt -> 100
/*     */     //   85: aload_3
/*     */     //   86: iload_2
/*     */     //   87: aaload
/*     */     //   88: aload_1
/*     */     //   89: if_acmpne -> 94
/*     */     //   92: iconst_1
/*     */     //   93: ireturn
/*     */     //   94: iinc #2, -1
/*     */     //   97: goto -> 81
/*     */     //   100: goto -> 150
/*     */     //   103: aload_0
/*     */     //   104: getfield hasZeroValue : Z
/*     */     //   107: ifeq -> 123
/*     */     //   110: aload_1
/*     */     //   111: aload_0
/*     */     //   112: getfield zeroValue : Ljava/lang/Object;
/*     */     //   115: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   118: ifeq -> 123
/*     */     //   121: iconst_1
/*     */     //   122: ireturn
/*     */     //   123: aload_3
/*     */     //   124: arraylength
/*     */     //   125: iconst_1
/*     */     //   126: isub
/*     */     //   127: istore_2
/*     */     //   128: iload_2
/*     */     //   129: iflt -> 150
/*     */     //   132: aload_1
/*     */     //   133: aload_3
/*     */     //   134: iload_2
/*     */     //   135: aaload
/*     */     //   136: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   139: ifeq -> 144
/*     */     //   142: iconst_1
/*     */     //   143: ireturn
/*     */     //   144: iinc #2, -1
/*     */     //   147: goto -> 128
/*     */     //   150: iconst_0
/*     */     //   151: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #276	-> 0
/*     */     //   #277	-> 5
/*     */     //   #278	-> 9
/*     */     //   #279	-> 25
/*     */     //   #280	-> 30
/*     */     //   #281	-> 39
/*     */     //   #280	-> 53
/*     */     //   #282	-> 59
/*     */     //   #283	-> 66
/*     */     //   #284	-> 76
/*     */     //   #285	-> 85
/*     */     //   #284	-> 94
/*     */     //   #287	-> 103
/*     */     //   #288	-> 123
/*     */     //   #289	-> 132
/*     */     //   #288	-> 144
/*     */     //   #291	-> 150
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
/*     */   public boolean containsKey(int paramInt) {
/* 296 */     if (paramInt == 0) return this.hasZeroValue; 
/* 297 */     return (locateKey(paramInt) >= 0);
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
/*     */   public int findKey(@Null Object paramObject, boolean paramBoolean, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield valueTable : [Ljava/lang/Object;
/*     */     //   4: astore #4
/*     */     //   6: aload_1
/*     */     //   7: ifnonnull -> 67
/*     */     //   10: aload_0
/*     */     //   11: getfield hasZeroValue : Z
/*     */     //   14: ifeq -> 26
/*     */     //   17: aload_0
/*     */     //   18: getfield zeroValue : Ljava/lang/Object;
/*     */     //   21: ifnonnull -> 26
/*     */     //   24: iconst_0
/*     */     //   25: ireturn
/*     */     //   26: aload_0
/*     */     //   27: getfield keyTable : [I
/*     */     //   30: astore_2
/*     */     //   31: aload #4
/*     */     //   33: arraylength
/*     */     //   34: iconst_1
/*     */     //   35: isub
/*     */     //   36: istore_1
/*     */     //   37: iload_1
/*     */     //   38: iflt -> 64
/*     */     //   41: aload_2
/*     */     //   42: iload_1
/*     */     //   43: iaload
/*     */     //   44: ifeq -> 58
/*     */     //   47: aload #4
/*     */     //   49: iload_1
/*     */     //   50: aaload
/*     */     //   51: ifnonnull -> 58
/*     */     //   54: aload_2
/*     */     //   55: iload_1
/*     */     //   56: iaload
/*     */     //   57: ireturn
/*     */     //   58: iinc #1, -1
/*     */     //   61: goto -> 37
/*     */     //   64: goto -> 169
/*     */     //   67: iload_2
/*     */     //   68: ifeq -> 115
/*     */     //   71: aload_1
/*     */     //   72: aload_0
/*     */     //   73: getfield zeroValue : Ljava/lang/Object;
/*     */     //   76: if_acmpne -> 81
/*     */     //   79: iconst_0
/*     */     //   80: ireturn
/*     */     //   81: aload #4
/*     */     //   83: arraylength
/*     */     //   84: iconst_1
/*     */     //   85: isub
/*     */     //   86: istore_2
/*     */     //   87: iload_2
/*     */     //   88: iflt -> 112
/*     */     //   91: aload #4
/*     */     //   93: iload_2
/*     */     //   94: aaload
/*     */     //   95: aload_1
/*     */     //   96: if_acmpne -> 106
/*     */     //   99: aload_0
/*     */     //   100: getfield keyTable : [I
/*     */     //   103: iload_2
/*     */     //   104: iaload
/*     */     //   105: ireturn
/*     */     //   106: iinc #2, -1
/*     */     //   109: goto -> 87
/*     */     //   112: goto -> 169
/*     */     //   115: aload_0
/*     */     //   116: getfield hasZeroValue : Z
/*     */     //   119: ifeq -> 135
/*     */     //   122: aload_1
/*     */     //   123: aload_0
/*     */     //   124: getfield zeroValue : Ljava/lang/Object;
/*     */     //   127: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   130: ifeq -> 135
/*     */     //   133: iconst_0
/*     */     //   134: ireturn
/*     */     //   135: aload #4
/*     */     //   137: arraylength
/*     */     //   138: iconst_1
/*     */     //   139: isub
/*     */     //   140: istore_2
/*     */     //   141: iload_2
/*     */     //   142: iflt -> 169
/*     */     //   145: aload_1
/*     */     //   146: aload #4
/*     */     //   148: iload_2
/*     */     //   149: aaload
/*     */     //   150: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   153: ifeq -> 163
/*     */     //   156: aload_0
/*     */     //   157: getfield keyTable : [I
/*     */     //   160: iload_2
/*     */     //   161: iaload
/*     */     //   162: ireturn
/*     */     //   163: iinc #2, -1
/*     */     //   166: goto -> 141
/*     */     //   169: iload_3
/*     */     //   170: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #305	-> 0
/*     */     //   #306	-> 6
/*     */     //   #307	-> 10
/*     */     //   #308	-> 26
/*     */     //   #309	-> 31
/*     */     //   #310	-> 41
/*     */     //   #309	-> 58
/*     */     //   #311	-> 64
/*     */     //   #312	-> 71
/*     */     //   #313	-> 81
/*     */     //   #314	-> 91
/*     */     //   #313	-> 106
/*     */     //   #316	-> 115
/*     */     //   #317	-> 135
/*     */     //   #318	-> 145
/*     */     //   #317	-> 163
/*     */     //   #320	-> 169
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
/* 326 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 327 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 331 */     int i = this.keyTable.length;
/* 332 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 333 */     this.mask = paramInt - 1;
/* 334 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 336 */     int[] arrayOfInt = this.keyTable;
/* 337 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 339 */     this.keyTable = new int[paramInt];
/* 340 */     this.valueTable = (V[])new Object[paramInt];
/*     */     
/* 342 */     if (this.size > 0)
/* 343 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         int j;
/* 345 */         if ((j = arrayOfInt[paramInt]) != 0) putResize(j, arrayOfV[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 351 */     int i = this.size;
/* 352 */     if (this.hasZeroValue && this.zeroValue != null) i += this.zeroValue.hashCode(); 
/* 353 */     int[] arrayOfInt = this.keyTable;
/* 354 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 355 */     for (b = 0, j = arrayOfInt.length; b < j; b++) {
/*     */ 
/*     */       
/* 358 */       i += k * 31; int k;
/*     */       V v;
/* 360 */       if ((k = arrayOfInt[b]) != 0 && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 363 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 367 */     if (paramObject == this) return true; 
/* 368 */     if (!(paramObject instanceof IntMap)) return false;
/*     */     
/* 370 */     if (((IntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 371 */     if (((IntMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 372 */     if (this.hasZeroValue) {
/* 373 */       if (((IntMap)paramObject).zeroValue == null)
/* 374 */       { if (this.zeroValue != null) return false;
/*     */          }
/* 376 */       else if (!((IntMap)paramObject).zeroValue.equals(this.zeroValue)) { return false; }
/*     */     
/*     */     }
/* 379 */     int[] arrayOfInt = this.keyTable;
/* 380 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 381 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 383 */       if ((j = arrayOfInt[b]) != 0) {
/*     */         V v;
/* 385 */         if ((v = arrayOfV[b]) == null)
/* 386 */         { if (paramObject.get(j, ObjectMap.dummy) != null) return false;
/*     */            }
/* 388 */         else if (!v.equals(paramObject.get(j))) { return false; }
/*     */       
/*     */       } 
/*     */     } 
/* 392 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(@Null Object paramObject) {
/* 397 */     if (paramObject == this) return true; 
/* 398 */     if (!(paramObject instanceof IntMap)) return false;
/*     */     
/* 400 */     if (((IntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 401 */     if (((IntMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 402 */     if (this.hasZeroValue && this.zeroValue != ((IntMap)paramObject).zeroValue) return false; 
/* 403 */     int[] arrayOfInt = this.keyTable;
/* 404 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 405 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 407 */       if ((j = arrayOfInt[b]) != 0 && arrayOfV[b] != paramObject.get(j, (V)ObjectMap.dummy)) return false; 
/*     */     } 
/* 409 */     return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 413 */     if (this.size == 0) return "[]"; 
/*     */     java.lang.StringBuilder stringBuilder;
/* 415 */     (stringBuilder = new java.lang.StringBuilder(32)).append('[');
/* 416 */     int[] arrayOfInt = this.keyTable;
/* 417 */     V[] arrayOfV = this.valueTable;
/* 418 */     int i = arrayOfInt.length;
/* 419 */     if (this.hasZeroValue) {
/* 420 */       stringBuilder.append("0=");
/* 421 */       stringBuilder.append(this.zeroValue);
/*     */     } else {
/* 423 */       while (i-- > 0) {
/*     */         int j;
/* 425 */         if ((j = arrayOfInt[i]) != 0) {
/* 426 */           stringBuilder.append(j);
/* 427 */           stringBuilder.append('=');
/* 428 */           stringBuilder.append(arrayOfV[i]); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 432 */     while (i-- > 0) {
/*     */       int j;
/* 434 */       if ((j = arrayOfInt[i]) != 0) {
/* 435 */         stringBuilder.append(", ");
/* 436 */         stringBuilder.append(j);
/* 437 */         stringBuilder.append('=');
/* 438 */         stringBuilder.append(arrayOfV[i]);
/*     */       } 
/* 440 */     }  stringBuilder.append(']');
/* 441 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<Entry<V>> iterator() {
/* 445 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Entries<V> entries() {
/* 453 */     if (Collections.allocateIterators) return new Entries<>(this); 
/* 454 */     if (this.entries1 == null) {
/* 455 */       this.entries1 = new Entries(this);
/* 456 */       this.entries2 = new Entries(this);
/*     */     } 
/* 458 */     if (!this.entries1.valid) {
/* 459 */       this.entries1.reset();
/* 460 */       this.entries1.valid = true;
/* 461 */       this.entries2.valid = false;
/* 462 */       return this.entries1;
/*     */     } 
/* 464 */     this.entries2.reset();
/* 465 */     this.entries2.valid = true;
/* 466 */     this.entries1.valid = false;
/* 467 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 475 */     if (Collections.allocateIterators) return new Values<>(this); 
/* 476 */     if (this.values1 == null) {
/* 477 */       this.values1 = new Values(this);
/* 478 */       this.values2 = new Values(this);
/*     */     } 
/* 480 */     if (!this.values1.valid) {
/* 481 */       this.values1.reset();
/* 482 */       this.values1.valid = true;
/* 483 */       this.values2.valid = false;
/* 484 */       return this.values1;
/*     */     } 
/* 486 */     this.values2.reset();
/* 487 */     this.values2.valid = true;
/* 488 */     this.values1.valid = false;
/* 489 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Keys keys() {
/* 497 */     if (Collections.allocateIterators) return new Keys(this); 
/* 498 */     if (this.keys1 == null) {
/* 499 */       this.keys1 = new Keys(this);
/* 500 */       this.keys2 = new Keys(this);
/*     */     } 
/* 502 */     if (!this.keys1.valid) {
/* 503 */       this.keys1.reset();
/* 504 */       this.keys1.valid = true;
/* 505 */       this.keys2.valid = false;
/* 506 */       return this.keys1;
/*     */     } 
/* 508 */     this.keys2.reset();
/* 509 */     this.keys2.valid = true;
/* 510 */     this.keys1.valid = false;
/* 511 */     return this.keys2;
/*     */   }
/*     */   
/*     */   public static class Entry<V> { public int key;
/*     */     @Null
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 519 */       return this.key + "=" + this.value;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class MapIterator<V>
/*     */   {
/*     */     private static final int INDEX_ILLEGAL = -2;
/*     */     static final int INDEX_ZERO = -1;
/*     */     public boolean hasNext;
/*     */     final IntMap<V> map;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public MapIterator(IntMap<V> param1IntMap) {
/* 534 */       this.map = param1IntMap;
/* 535 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 539 */       this.currentIndex = -2;
/* 540 */       this.nextIndex = -1;
/* 541 */       if (this.map.hasZeroValue) {
/* 542 */         this.hasNext = true; return;
/*     */       } 
/* 544 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       int[] arrayOfInt;
/* 549 */       for (int i = (arrayOfInt = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 550 */         if (arrayOfInt[this.nextIndex] != 0) {
/* 551 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 555 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 560 */       if ((i = this.currentIndex) == -1 && this.map.hasZeroValue)
/* 561 */       { this.map.hasZeroValue = false;
/* 562 */         this.map.zeroValue = null; }
/* 563 */       else { if (i < 0) {
/* 564 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 566 */         int[] arrayOfInt = this.map.keyTable;
/* 567 */         V[] arrayOfV = this.map.valueTable;
/* 568 */         int j = this.map.mask, k = i + 1 & j; int m;
/* 569 */         while ((m = arrayOfInt[k]) != 0) {
/* 570 */           int n = this.map.place(m);
/* 571 */           if ((k - n & j) > (i - n & j)) {
/* 572 */             arrayOfInt[i] = m;
/* 573 */             arrayOfV[i] = arrayOfV[k];
/* 574 */             i = k;
/*     */           } 
/* 576 */           k = k + 1 & j;
/*     */         } 
/* 578 */         arrayOfInt[i] = 0;
/* 579 */         arrayOfV[i] = null;
/* 580 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 582 */       this.currentIndex = -2;
/* 583 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
/* 588 */     private final IntMap.Entry<V> entry = new IntMap.Entry<>();
/*     */     
/*     */     public Entries(IntMap<V> param1IntMap) {
/* 591 */       super(param1IntMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public IntMap.Entry<V> next() {
/* 596 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 597 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 598 */       int[] arrayOfInt = this.map.keyTable;
/* 599 */       if (this.nextIndex == -1) {
/* 600 */         this.entry.key = 0;
/* 601 */         this.entry.value = this.map.zeroValue;
/*     */       } else {
/* 603 */         this.entry.key = arrayOfInt[this.nextIndex];
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
/*     */     public Iterator<IntMap.Entry<V>> iterator() {
/* 617 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<V> implements Iterable<V>, Iterator<V> {
/*     */     public Values(IntMap<V> param1IntMap) {
/* 623 */       super(param1IntMap);
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
/*     */     public Keys(IntMap<V> param1IntMap) {
/* 659 */       super(param1IntMap);
/*     */     }
/*     */     
/*     */     public int next() {
/* 663 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 664 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 665 */       boolean bool = (this.nextIndex == -1) ? false : this.map.keyTable[this.nextIndex];
/* 666 */       this.currentIndex = this.nextIndex;
/* 667 */       findNextIndex();
/* 668 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 673 */       IntArray intArray = new IntArray(true, this.map.size);
/* 674 */       while (this.hasNext)
/* 675 */         intArray.add(next()); 
/* 676 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 681 */       while (this.hasNext)
/* 682 */         param1IntArray.add(next()); 
/* 683 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IntMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */