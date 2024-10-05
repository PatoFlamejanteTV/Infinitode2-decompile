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
/*     */   
/*     */   public IntMap() {
/*  75 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntMap(int paramInt) {
/*  82 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntMap(int paramInt, float paramFloat) {
/*  89 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  90 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  91 */     this.loadFactor = paramFloat;
/*     */     
/*  93 */     paramInt = ObjectMap.tableSize(paramInt, paramFloat);
/*  94 */     this.threshold = (int)(paramInt * paramFloat);
/*  95 */     this.mask = paramInt - 1;
/*  96 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  98 */     this.keyTable = new int[paramInt];
/*  99 */     this.valueTable = (V[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public IntMap(IntMap<? extends V> paramIntMap) {
/* 104 */     this((int)(paramIntMap.keyTable.length * paramIntMap.loadFactor), paramIntMap.loadFactor);
/* 105 */     System.arraycopy(paramIntMap.keyTable, 0, this.keyTable, 0, paramIntMap.keyTable.length);
/* 106 */     System.arraycopy(paramIntMap.valueTable, 0, this.valueTable, 0, paramIntMap.valueTable.length);
/* 107 */     this.size = paramIntMap.size;
/* 108 */     this.zeroValue = paramIntMap.zeroValue;
/* 109 */     this.hasZeroValue = paramIntMap.hasZeroValue;
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
/* 127 */     return (int)(paramInt * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int locateKey(int paramInt) {
/* 133 */     int[] arrayOfInt = this.keyTable;
/* 134 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 136 */       if ((j = arrayOfInt[i]) == 0) return -(i + 1); 
/* 137 */       if (j == paramInt) return i; 
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public V put(int paramInt, @Null V paramV) {
/*     */     V v;
/* 143 */     if (paramInt == 0) {
/* 144 */       V v1 = this.zeroValue;
/* 145 */       this.zeroValue = paramV;
/* 146 */       if (!this.hasZeroValue) {
/* 147 */         this.hasZeroValue = true;
/* 148 */         this.size++;
/*     */       } 
/* 150 */       return v1;
/*     */     } 
/*     */     int i;
/* 153 */     if ((i = locateKey(paramInt)) >= 0) {
/* 154 */       v = this.valueTable[i];
/* 155 */       this.valueTable[i] = paramV;
/* 156 */       return v;
/*     */     } 
/* 158 */     i = -(i + 1);
/* 159 */     this.keyTable[i] = v;
/* 160 */     this.valueTable[i] = paramV;
/* 161 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(IntMap<? extends V> paramIntMap) {
/* 166 */     ensureCapacity(paramIntMap.size);
/* 167 */     if (paramIntMap.hasZeroValue) put(0, paramIntMap.zeroValue); 
/* 168 */     int[] arrayOfInt = paramIntMap.keyTable;
/* 169 */     V[] arrayOfV = paramIntMap.valueTable; byte b; int i;
/* 170 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 172 */       if ((j = arrayOfInt[b]) != 0) put(j, arrayOfV[b]);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putResize(int paramInt, @Null V paramV) {
/* 178 */     int[] arrayOfInt = this.keyTable; int i;
/* 179 */     for (i = place(paramInt);; i = i + 1 & this.mask) {
/* 180 */       if (arrayOfInt[i] == 0) {
/* 181 */         arrayOfInt[i] = paramInt;
/* 182 */         this.valueTable[i] = paramV;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public V get(int paramInt) {
/* 189 */     if (paramInt == 0) return this.hasZeroValue ? this.zeroValue : null; 
/* 190 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 192 */       if ((j = this.keyTable[i]) == 0) return null; 
/* 193 */       if (j == paramInt) return this.valueTable[i]; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public V get(int paramInt, @Null V paramV) {
/* 198 */     if (paramInt == 0) return this.hasZeroValue ? this.zeroValue : null; 
/* 199 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 201 */       if ((j = this.keyTable[i]) == 0) return paramV; 
/* 202 */       if (j == paramInt) return this.valueTable[i]; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V remove(int paramInt) {
/* 208 */     if (paramInt == 0) {
/* 209 */       if (!this.hasZeroValue) return null; 
/* 210 */       this.hasZeroValue = false;
/* 211 */       V v1 = this.zeroValue;
/* 212 */       this.zeroValue = null;
/* 213 */       this.size--;
/* 214 */       return v1;
/*     */     } 
/*     */     
/*     */     int i;
/* 218 */     if ((i = locateKey(paramInt)) < 0) return null; 
/* 219 */     int[] arrayOfInt = this.keyTable;
/*     */     
/* 221 */     V arrayOfV[], v = (arrayOfV = this.valueTable)[i];
/* 222 */     int j = this.mask, k = i + 1 & j;
/* 223 */     while ((paramInt = arrayOfInt[k]) != 0) {
/* 224 */       int m = place(paramInt);
/* 225 */       if ((k - m & j) > (i - m & j)) {
/* 226 */         arrayOfInt[i] = paramInt;
/* 227 */         arrayOfV[i] = arrayOfV[k];
/* 228 */         i = k;
/*     */       } 
/* 230 */       k = k + 1 & j;
/*     */     } 
/* 232 */     arrayOfInt[i] = 0;
/* 233 */     this.size--;
/* 234 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 239 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 244 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 251 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 252 */     paramInt = ObjectMap.tableSize(paramInt, this.loadFactor);
/* 253 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 258 */     paramInt = ObjectMap.tableSize(paramInt, this.loadFactor);
/* 259 */     if (this.keyTable.length <= paramInt) {
/* 260 */       clear();
/*     */       return;
/*     */     } 
/* 263 */     this.size = 0;
/* 264 */     this.hasZeroValue = false;
/* 265 */     this.zeroValue = null;
/* 266 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 270 */     if (this.size == 0)
/* 271 */       return;  this.size = 0;
/* 272 */     Arrays.fill(this.keyTable, 0);
/* 273 */     Arrays.fill((Object[])this.valueTable, (Object)null);
/* 274 */     this.zeroValue = null;
/* 275 */     this.hasZeroValue = false;
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
/*     */     //   #283	-> 0
/*     */     //   #284	-> 5
/*     */     //   #285	-> 9
/*     */     //   #286	-> 25
/*     */     //   #287	-> 30
/*     */     //   #288	-> 39
/*     */     //   #287	-> 53
/*     */     //   #289	-> 59
/*     */     //   #290	-> 66
/*     */     //   #291	-> 76
/*     */     //   #292	-> 85
/*     */     //   #291	-> 94
/*     */     //   #294	-> 103
/*     */     //   #295	-> 123
/*     */     //   #296	-> 132
/*     */     //   #295	-> 144
/*     */     //   #298	-> 150
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
/* 303 */     if (paramInt == 0) return this.hasZeroValue; 
/* 304 */     return (locateKey(paramInt) >= 0);
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
/*     */     //   #312	-> 0
/*     */     //   #313	-> 6
/*     */     //   #314	-> 10
/*     */     //   #315	-> 26
/*     */     //   #316	-> 31
/*     */     //   #317	-> 41
/*     */     //   #316	-> 58
/*     */     //   #318	-> 64
/*     */     //   #319	-> 71
/*     */     //   #320	-> 81
/*     */     //   #321	-> 91
/*     */     //   #320	-> 106
/*     */     //   #323	-> 115
/*     */     //   #324	-> 135
/*     */     //   #325	-> 145
/*     */     //   #324	-> 163
/*     */     //   #327	-> 169
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
/* 333 */     paramInt = ObjectMap.tableSize(this.size + paramInt, this.loadFactor);
/* 334 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 338 */     int i = this.keyTable.length;
/* 339 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 340 */     this.mask = paramInt - 1;
/* 341 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 343 */     int[] arrayOfInt = this.keyTable;
/* 344 */     V[] arrayOfV = this.valueTable;
/*     */     
/* 346 */     this.keyTable = new int[paramInt];
/* 347 */     this.valueTable = (V[])new Object[paramInt];
/*     */     
/* 349 */     if (this.size > 0)
/* 350 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         int j;
/* 352 */         if ((j = arrayOfInt[paramInt]) != 0) putResize(j, arrayOfV[paramInt]);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 358 */     int i = this.size;
/* 359 */     if (this.hasZeroValue && this.zeroValue != null) i += this.zeroValue.hashCode(); 
/* 360 */     int[] arrayOfInt = this.keyTable;
/* 361 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 362 */     for (b = 0, j = arrayOfInt.length; b < j; b++) {
/*     */ 
/*     */       
/* 365 */       i += k * 31; V v;
/*     */       int k;
/* 367 */       if ((k = arrayOfInt[b]) != 0 && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 370 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 374 */     if (paramObject == this) return true; 
/* 375 */     if (!(paramObject instanceof IntMap)) return false;
/*     */     
/* 377 */     if (((IntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 378 */     if (((IntMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 379 */     if (this.hasZeroValue) {
/* 380 */       if (((IntMap)paramObject).zeroValue == null)
/* 381 */       { if (this.zeroValue != null) return false;
/*     */          }
/* 383 */       else if (!((IntMap)paramObject).zeroValue.equals(this.zeroValue)) { return false; }
/*     */     
/*     */     }
/* 386 */     int[] arrayOfInt = this.keyTable;
/* 387 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 388 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 390 */       if ((j = arrayOfInt[b]) != 0) {
/*     */         V v;
/* 392 */         if ((v = arrayOfV[b]) == null)
/* 393 */         { if (paramObject.get(j, ObjectMap.dummy) != null) return false;
/*     */            }
/* 395 */         else if (!v.equals(paramObject.get(j))) { return false; }
/*     */       
/*     */       } 
/*     */     } 
/* 399 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(@Null Object paramObject) {
/* 404 */     if (paramObject == this) return true; 
/* 405 */     if (!(paramObject instanceof IntMap)) return false;
/*     */     
/* 407 */     if (((IntMap)(paramObject = paramObject)).size != this.size) return false; 
/* 408 */     if (((IntMap)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 409 */     if (this.hasZeroValue && this.zeroValue != ((IntMap)paramObject).zeroValue) return false; 
/* 410 */     int[] arrayOfInt = this.keyTable;
/* 411 */     V[] arrayOfV = this.valueTable; byte b; int i;
/* 412 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 414 */       if ((j = arrayOfInt[b]) != 0 && arrayOfV[b] != paramObject.get(j, (V)ObjectMap.dummy)) return false; 
/*     */     } 
/* 416 */     return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 420 */     if (this.size == 0) return "[]"; 
/*     */     StringBuilder stringBuilder;
/* 422 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 423 */     int[] arrayOfInt = this.keyTable;
/* 424 */     V[] arrayOfV = this.valueTable;
/* 425 */     int i = arrayOfInt.length;
/* 426 */     if (this.hasZeroValue) {
/* 427 */       stringBuilder.append("0=");
/* 428 */       stringBuilder.append(this.zeroValue);
/*     */     } else {
/* 430 */       while (i-- > 0) {
/*     */         int j;
/* 432 */         if ((j = arrayOfInt[i]) != 0) {
/* 433 */           stringBuilder.append(j);
/* 434 */           stringBuilder.append('=');
/* 435 */           stringBuilder.append(arrayOfV[i]); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 439 */     while (i-- > 0) {
/*     */       int j;
/* 441 */       if ((j = arrayOfInt[i]) != 0) {
/* 442 */         stringBuilder.append(", ");
/* 443 */         stringBuilder.append(j);
/* 444 */         stringBuilder.append('=');
/* 445 */         stringBuilder.append(arrayOfV[i]);
/*     */       } 
/* 447 */     }  stringBuilder.append(']');
/* 448 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Iterator<Entry<V>> iterator() {
/* 452 */     return entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entries<V> entries() {
/* 457 */     return new Entries<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Values<V> values() {
/* 462 */     return new Values<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Keys keys() {
/* 467 */     return new Keys(this);
/*     */   }
/*     */   
/*     */   public static class Entry<V> { public int key;
/*     */     @Null
/*     */     public V value;
/*     */     
/*     */     public String toString() {
/* 475 */       return this.key + "=" + this.value;
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
/* 490 */       this.map = param1IntMap;
/* 491 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 495 */       this.currentIndex = -2;
/* 496 */       this.nextIndex = -1;
/* 497 */       if (this.map.hasZeroValue) {
/* 498 */         this.hasNext = true; return;
/*     */       } 
/* 500 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       int[] arrayOfInt;
/* 505 */       for (int i = (arrayOfInt = this.map.keyTable).length; ++this.nextIndex < i;) {
/* 506 */         if (arrayOfInt[this.nextIndex] != 0) {
/* 507 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 511 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 516 */       if ((i = this.currentIndex) == -1 && this.map.hasZeroValue)
/* 517 */       { this.map.hasZeroValue = false; }
/* 518 */       else { if (i < 0) {
/* 519 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 521 */         int[] arrayOfInt = this.map.keyTable;
/* 522 */         V[] arrayOfV = this.map.valueTable;
/* 523 */         int j = this.map.mask, k = i + 1 & j; int m;
/* 524 */         while ((m = arrayOfInt[k]) != 0) {
/* 525 */           int n = this.map.place(m);
/* 526 */           if ((k - n & j) > (i - n & j)) {
/* 527 */             arrayOfInt[i] = m;
/* 528 */             arrayOfV[i] = arrayOfV[k];
/* 529 */             i = k;
/*     */           } 
/* 531 */           k = k + 1 & j;
/*     */         } 
/* 533 */         arrayOfInt[i] = 0;
/* 534 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 536 */       this.currentIndex = -2;
/* 537 */       this.map.size--;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
/* 542 */     private final IntMap.Entry<V> entry = new IntMap.Entry<>();
/*     */     
/*     */     public Entries(IntMap<V> param1IntMap) {
/* 545 */       super(param1IntMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public IntMap.Entry<V> next() {
/* 550 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 551 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 552 */       int[] arrayOfInt = this.map.keyTable;
/* 553 */       if (this.nextIndex == -1) {
/* 554 */         this.entry.key = 0;
/* 555 */         this.entry.value = this.map.zeroValue;
/*     */       } else {
/* 557 */         this.entry.key = arrayOfInt[this.nextIndex];
/* 558 */         this.entry.value = this.map.valueTable[this.nextIndex];
/*     */       } 
/* 560 */       this.currentIndex = this.nextIndex;
/* 561 */       findNextIndex();
/* 562 */       return this.entry;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 566 */       if (!this.valid) throw new KryoException("#iterator() cannot be used nested."); 
/* 567 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public Iterator<IntMap.Entry<V>> iterator() {
/* 571 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Values<V> extends MapIterator<V> implements Iterable<V>, Iterator<V> {
/*     */     public Values(IntMap<V> param1IntMap) {
/* 577 */       super(param1IntMap);
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 581 */       return this.hasNext;
/*     */     }
/*     */     @Null
/*     */     public V next() {
/*     */       V v;
/* 586 */       if (!this.hasNext) throw new NoSuchElementException();
/*     */       
/* 588 */       if (this.nextIndex == -1) {
/* 589 */         v = this.map.zeroValue;
/*     */       } else {
/* 591 */         v = this.map.valueTable[this.nextIndex];
/* 592 */       }  this.currentIndex = this.nextIndex;
/* 593 */       findNextIndex();
/* 594 */       return v;
/*     */     }
/*     */     
/*     */     public Iterator<V> iterator() {
/* 598 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<V> toList() {
/* 603 */       ArrayList<V> arrayList = new ArrayList(this.map.size);
/* 604 */       while (this.hasNext)
/* 605 */         arrayList.add(next()); 
/* 606 */       return arrayList;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Keys extends MapIterator {
/*     */     public Keys(IntMap<V> param1IntMap) {
/* 612 */       super(param1IntMap);
/*     */     }
/*     */     
/*     */     public int next() {
/* 616 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 617 */       boolean bool = (this.nextIndex == -1) ? false : this.map.keyTable[this.nextIndex];
/* 618 */       this.currentIndex = this.nextIndex;
/* 619 */       findNextIndex();
/* 620 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 625 */       IntArray intArray = new IntArray(true, this.map.size);
/* 626 */       while (this.hasNext)
/* 627 */         intArray.add(next()); 
/* 628 */       return intArray;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray(IntArray param1IntArray) {
/* 633 */       while (this.hasNext)
/* 634 */         param1IntArray.add(next()); 
/* 635 */       return param1IntArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\IntMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */