/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public class IntSet
/*     */ {
/*     */   public int size;
/*     */   int[] keyTable;
/*     */   boolean hasZeroValue;
/*     */   private final float loadFactor;
/*     */   private int threshold;
/*     */   protected int shift;
/*     */   protected int mask;
/*     */   private transient IntSetIterator iterator1;
/*     */   private transient IntSetIterator iterator2;
/*     */   
/*     */   public IntSet() {
/*  67 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntSet(int paramInt) {
/*  73 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntSet(int paramInt, float paramFloat) {
/*  80 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  81 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  82 */     this.loadFactor = paramFloat;
/*     */     
/*  84 */     paramInt = ObjectSet.tableSize(paramInt, paramFloat);
/*  85 */     this.threshold = (int)(paramInt * paramFloat);
/*  86 */     this.mask = paramInt - 1;
/*  87 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  89 */     this.keyTable = new int[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public IntSet(IntSet paramIntSet) {
/*  94 */     this((int)(paramIntSet.keyTable.length * paramIntSet.loadFactor), paramIntSet.loadFactor);
/*  95 */     System.arraycopy(paramIntSet.keyTable, 0, this.keyTable, 0, paramIntSet.keyTable.length);
/*  96 */     this.size = paramIntSet.size;
/*  97 */     this.hasZeroValue = paramIntSet.hasZeroValue;
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
/* 115 */     return (int)(paramInt * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int locateKey(int paramInt) {
/* 121 */     int[] arrayOfInt = this.keyTable;
/* 122 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/*     */       int j;
/* 124 */       if ((j = arrayOfInt[i]) == 0) return -(i + 1); 
/* 125 */       if (j == paramInt) return i;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean add(int paramInt) {
/* 131 */     if (paramInt == 0) {
/* 132 */       if (this.hasZeroValue) return false; 
/* 133 */       this.hasZeroValue = true;
/* 134 */       this.size++;
/* 135 */       return true;
/*     */     } 
/*     */     int i;
/* 138 */     if ((i = locateKey(paramInt)) >= 0) return false; 
/* 139 */     i = -(i + 1);
/* 140 */     this.keyTable[i] = paramInt;
/* 141 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray) {
/* 146 */     addAll(paramIntArray.items, 0, paramIntArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray, int paramInt1, int paramInt2) {
/* 150 */     if (paramInt1 + paramInt2 > paramIntArray.size)
/* 151 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramIntArray.size); 
/* 152 */     addAll(paramIntArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(int... paramVarArgs) {
/* 156 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 160 */     ensureCapacity(paramInt2);
/* 161 */     for (int i = paramInt1; i < paramInt1; i++)
/* 162 */       add(paramArrayOfint[i]); 
/*     */   }
/*     */   
/*     */   public void addAll(IntSet paramIntSet) {
/* 166 */     ensureCapacity(paramIntSet.size);
/* 167 */     if (paramIntSet.hasZeroValue) add(0); 
/* 168 */     int[] arrayOfInt = paramIntSet.keyTable; byte b; int i;
/* 169 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/*     */       int j;
/* 171 */       if ((j = arrayOfInt[b]) != 0) add(j);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addResize(int paramInt) {
/* 177 */     int[] arrayOfInt = this.keyTable;
/* 178 */     for (int i = place(paramInt);; i = i + 1 & this.mask) {
/* 179 */       if (arrayOfInt[i] == 0) {
/* 180 */         arrayOfInt[i] = paramInt;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(int paramInt) {
/* 188 */     if (paramInt == 0) {
/* 189 */       if (!this.hasZeroValue) return false; 
/* 190 */       this.hasZeroValue = false;
/* 191 */       this.size--;
/* 192 */       return true;
/*     */     } 
/*     */     
/*     */     int i;
/* 196 */     if ((i = locateKey(paramInt)) < 0) return false; 
/* 197 */     int[] arrayOfInt = this.keyTable;
/* 198 */     int j = this.mask, k = i + 1 & j;
/* 199 */     while ((paramInt = arrayOfInt[k]) != 0) {
/* 200 */       int m = place(paramInt);
/* 201 */       if ((k - m & j) > (i - m & j)) {
/* 202 */         arrayOfInt[i] = paramInt;
/* 203 */         i = k;
/*     */       } 
/* 205 */       k = k + 1 & j;
/*     */     } 
/* 207 */     arrayOfInt[i] = 0;
/* 208 */     this.size--;
/* 209 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 214 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 219 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 226 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 227 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 228 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 233 */     paramInt = ObjectSet.tableSize(paramInt, this.loadFactor);
/* 234 */     if (this.keyTable.length <= paramInt) {
/* 235 */       clear();
/*     */       return;
/*     */     } 
/* 238 */     this.size = 0;
/* 239 */     this.hasZeroValue = false;
/* 240 */     resize(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 244 */     if (this.size == 0)
/* 245 */       return;  this.size = 0;
/* 246 */     Arrays.fill(this.keyTable, 0);
/* 247 */     this.hasZeroValue = false;
/*     */   }
/*     */   
/*     */   public boolean contains(int paramInt) {
/* 251 */     if (paramInt == 0) return this.hasZeroValue; 
/* 252 */     return (locateKey(paramInt) >= 0);
/*     */   }
/*     */   
/*     */   public int first() {
/* 256 */     if (this.hasZeroValue) return 0; 
/* 257 */     int[] arrayOfInt = this.keyTable; byte b; int i;
/* 258 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/* 259 */       if (arrayOfInt[b] != 0) return arrayOfInt[b]; 
/* 260 */     }  throw new IllegalStateException("IntSet is empty.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 266 */     paramInt = ObjectSet.tableSize(this.size + paramInt, this.loadFactor);
/* 267 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 271 */     int i = this.keyTable.length;
/* 272 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 273 */     this.mask = paramInt - 1;
/* 274 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/* 276 */     int[] arrayOfInt = this.keyTable;
/*     */     
/* 278 */     this.keyTable = new int[paramInt];
/*     */     
/* 280 */     if (this.size > 0)
/* 281 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         int j;
/* 283 */         if ((j = arrayOfInt[paramInt]) != 0) addResize(j);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 289 */     int i = this.size;
/* 290 */     int[] arrayOfInt = this.keyTable; byte b; int j;
/* 291 */     for (b = 0, j = arrayOfInt.length; b < j; b++) {
/*     */       int k;
/* 293 */       if ((k = arrayOfInt[b]) != 0) i += k; 
/*     */     } 
/* 295 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 299 */     if (!(paramObject instanceof IntSet)) return false;
/*     */     
/* 301 */     if (((IntSet)(paramObject = paramObject)).size != this.size) return false; 
/* 302 */     if (((IntSet)paramObject).hasZeroValue != this.hasZeroValue) return false; 
/* 303 */     int[] arrayOfInt = this.keyTable; byte b; int i;
/* 304 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/* 305 */       if (arrayOfInt[b] != 0 && !paramObject.contains(arrayOfInt[b])) return false; 
/* 306 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 310 */     if (this.size == 0) return "[]"; 
/*     */     java.lang.StringBuilder stringBuilder;
/* 312 */     (stringBuilder = new java.lang.StringBuilder(32)).append('[');
/*     */     
/* 314 */     int arrayOfInt[], i = (arrayOfInt = this.keyTable).length;
/* 315 */     if (this.hasZeroValue) {
/* 316 */       stringBuilder.append("0");
/*     */     } else {
/* 318 */       while (i-- > 0) {
/*     */         int j;
/* 320 */         if ((j = arrayOfInt[i]) != 0) {
/* 321 */           stringBuilder.append(j); break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 325 */     while (i-- > 0) {
/*     */       int j;
/* 327 */       if ((j = arrayOfInt[i]) != 0) {
/* 328 */         stringBuilder.append(", ");
/* 329 */         stringBuilder.append(j);
/*     */       } 
/* 331 */     }  stringBuilder.append(']');
/* 332 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntSetIterator iterator() {
/* 340 */     if (Collections.allocateIterators) return new IntSetIterator(this); 
/* 341 */     if (this.iterator1 == null) {
/* 342 */       this.iterator1 = new IntSetIterator(this);
/* 343 */       this.iterator2 = new IntSetIterator(this);
/*     */     } 
/* 345 */     if (!this.iterator1.valid) {
/* 346 */       this.iterator1.reset();
/* 347 */       this.iterator1.valid = true;
/* 348 */       this.iterator2.valid = false;
/* 349 */       return this.iterator1;
/*     */     } 
/* 351 */     this.iterator2.reset();
/* 352 */     this.iterator2.valid = true;
/* 353 */     this.iterator1.valid = false;
/* 354 */     return this.iterator2;
/*     */   }
/*     */   
/*     */   public static IntSet with(int... paramVarArgs) {
/*     */     IntSet intSet;
/* 359 */     (intSet = new IntSet()).addAll(paramVarArgs);
/* 360 */     return intSet;
/*     */   }
/*     */   
/*     */   public static class IntSetIterator {
/*     */     private static final int INDEX_ILLEGAL = -2;
/*     */     private static final int INDEX_ZERO = -1;
/*     */     public boolean hasNext;
/*     */     final IntSet set;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public IntSetIterator(IntSet param1IntSet) {
/* 373 */       this.set = param1IntSet;
/* 374 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 378 */       this.currentIndex = -2;
/* 379 */       this.nextIndex = -1;
/* 380 */       if (this.set.hasZeroValue) {
/* 381 */         this.hasNext = true; return;
/*     */       } 
/* 383 */       findNextIndex();
/*     */     }
/*     */     
/*     */     void findNextIndex() {
/*     */       int[] arrayOfInt;
/* 388 */       for (int i = (arrayOfInt = this.set.keyTable).length; ++this.nextIndex < i;) {
/* 389 */         if (arrayOfInt[this.nextIndex] != 0) {
/* 390 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 394 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 399 */       if ((i = this.currentIndex) == -1 && this.set.hasZeroValue)
/* 400 */       { this.set.hasZeroValue = false; }
/* 401 */       else { if (i < 0) {
/* 402 */           throw new IllegalStateException("next must be called before remove.");
/*     */         }
/* 404 */         int[] arrayOfInt = this.set.keyTable;
/* 405 */         int j = this.set.mask, k = i + 1 & j; int m;
/* 406 */         while ((m = arrayOfInt[k]) != 0) {
/* 407 */           int n = this.set.place(m);
/* 408 */           if ((k - n & j) > (i - n & j)) {
/* 409 */             arrayOfInt[i] = m;
/* 410 */             i = k;
/*     */           } 
/* 412 */           k = k + 1 & j;
/*     */         } 
/* 414 */         arrayOfInt[i] = 0;
/* 415 */         if (i != this.currentIndex) this.nextIndex--;  }
/*     */       
/* 417 */       this.currentIndex = -2;
/* 418 */       this.set.size--;
/*     */     }
/*     */     
/*     */     public int next() {
/* 422 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 423 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 424 */       boolean bool = (this.nextIndex == -1) ? false : this.set.keyTable[this.nextIndex];
/* 425 */       this.currentIndex = this.nextIndex;
/* 426 */       findNextIndex();
/* 427 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntArray toArray() {
/* 432 */       IntArray intArray = new IntArray(true, this.set.size);
/* 433 */       while (this.hasNext)
/* 434 */         intArray.add(next()); 
/* 435 */       return intArray;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IntSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */