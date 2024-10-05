/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntArray
/*     */ {
/*     */   public int[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public IntArray() {
/*  34 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntArray(int paramInt) {
/*  39 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(boolean paramBoolean, int paramInt) {
/*  46 */     this.ordered = paramBoolean;
/*  47 */     this.items = new int[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(IntArray paramIntArray) {
/*  54 */     this.ordered = paramIntArray.ordered;
/*  55 */     this.size = paramIntArray.size;
/*  56 */     this.items = new int[this.size];
/*  57 */     System.arraycopy(paramIntArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(int[] paramArrayOfint) {
/*  63 */     this(true, paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(boolean paramBoolean, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  71 */     this(paramBoolean, paramInt2);
/*  72 */     this.size = paramInt2;
/*  73 */     System.arraycopy(paramArrayOfint, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(int paramInt) {
/*  77 */     int[] arrayOfInt = this.items;
/*  78 */     if (this.size == arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  79 */     arrayOfInt[this.size++] = paramInt;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2) {
/*  83 */     int[] arrayOfInt = this.items;
/*  84 */     if (this.size + 1 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  85 */     arrayOfInt[this.size] = paramInt1;
/*  86 */     arrayOfInt[this.size + 1] = paramInt2;
/*  87 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2, int paramInt3) {
/*  91 */     int[] arrayOfInt = this.items;
/*  92 */     if (this.size + 2 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  93 */     arrayOfInt[this.size] = paramInt1;
/*  94 */     arrayOfInt[this.size + 1] = paramInt2;
/*  95 */     arrayOfInt[this.size + 2] = paramInt3;
/*  96 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 100 */     int[] arrayOfInt = this.items;
/* 101 */     if (this.size + 3 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 102 */     arrayOfInt[this.size] = paramInt1;
/* 103 */     arrayOfInt[this.size + 1] = paramInt2;
/* 104 */     arrayOfInt[this.size + 2] = paramInt3;
/* 105 */     arrayOfInt[this.size + 3] = paramInt4;
/* 106 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray) {
/* 110 */     addAll(paramIntArray, 0, paramIntArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray, int paramInt1, int paramInt2) {
/* 114 */     if (paramInt1 + paramInt2 > paramIntArray.size)
/* 115 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramIntArray.size); 
/* 116 */     addAll(paramIntArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(int... paramVarArgs) {
/* 120 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 124 */     int[] arrayOfInt = this.items;
/*     */     int i;
/* 126 */     if ((i = this.size + paramInt2) > arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(i * 1.75F))); 
/* 127 */     System.arraycopy(paramArrayOfint, paramInt1, arrayOfInt, this.size, paramInt2);
/* 128 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public int get(int paramInt) {
/* 132 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 133 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt1, int paramInt2) {
/* 137 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 138 */     this.items[paramInt1] = paramInt2;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt1, int paramInt2) {
/* 142 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 143 */     this.items[paramInt1] = this.items[paramInt1] + paramInt2;
/*     */   }
/*     */   
/*     */   public void mul(int paramInt1, int paramInt2) {
/* 147 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 148 */     this.items[paramInt1] = this.items[paramInt1] * paramInt2;
/*     */   }
/*     */   
/*     */   public void insert(int paramInt1, int paramInt2) {
/* 152 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/* 153 */     int[] arrayOfInt = this.items;
/* 154 */     if (this.size == arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 155 */     if (this.ordered) {
/* 156 */       System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
/*     */     } else {
/* 158 */       arrayOfInt[this.size] = arrayOfInt[paramInt1];
/* 159 */     }  this.size++;
/* 160 */     arrayOfInt[paramInt1] = paramInt2;
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 164 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 165 */     if (paramInt2 >= this.size) throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
/*     */     
/* 167 */     int arrayOfInt[], i = (arrayOfInt = this.items)[paramInt1];
/* 168 */     arrayOfInt[paramInt1] = arrayOfInt[paramInt2];
/* 169 */     arrayOfInt[paramInt2] = i;
/*     */   }
/*     */   
/*     */   public boolean contains(int paramInt) {
/* 173 */     int i = this.size - 1;
/* 174 */     int[] arrayOfInt = this.items;
/* 175 */     while (i >= 0) {
/* 176 */       if (arrayOfInt[i--] == paramInt) return true; 
/* 177 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(int paramInt) {
/* 181 */     int[] arrayOfInt = this.items; byte b; int i;
/* 182 */     for (b = 0, i = this.size; b < i; b++) {
/* 183 */       if (arrayOfInt[b] == paramInt) return b; 
/* 184 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(int paramInt) {
/* 188 */     int[] arrayOfInt = this.items;
/* 189 */     for (int i = this.size - 1; i >= 0; i--) {
/* 190 */       if (arrayOfInt[i] == paramInt) return i; 
/* 191 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(int paramInt) {
/* 195 */     int[] arrayOfInt = this.items; byte b; int i;
/* 196 */     for (b = 0, i = this.size; b < i; b++) {
/* 197 */       if (arrayOfInt[b] == paramInt) {
/* 198 */         removeIndex(b);
/* 199 */         return true;
/*     */       } 
/*     */     } 
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeIndex(int paramInt) {
/* 207 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 209 */     int arrayOfInt[], i = (arrayOfInt = this.items)[paramInt];
/* 210 */     this.size--;
/* 211 */     if (this.ordered) {
/* 212 */       System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
/*     */     } else {
/* 214 */       arrayOfInt[paramInt] = arrayOfInt[this.size];
/* 215 */     }  return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 220 */     int i = this.size;
/* 221 */     if (paramInt2 >= i) throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size); 
/* 222 */     if (paramInt1 > paramInt2) throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2); 
/* 223 */     int j = paramInt2 - paramInt1 + 1, k = i - j;
/* 224 */     if (this.ordered) {
/* 225 */       System.arraycopy(this.items, paramInt1 + j, this.items, paramInt1, i - paramInt1 + j);
/*     */     } else {
/* 227 */       paramInt2 = Math.max(k, paramInt2 + 1);
/* 228 */       System.arraycopy(this.items, paramInt2, this.items, paramInt1, i - paramInt2);
/*     */     } 
/* 230 */     this.size = k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(IntArray paramIntArray) {
/* 237 */     int i = this.size, j = i;
/* 238 */     int[] arrayOfInt = this.items; byte b; int k;
/* 239 */     for (b = 0, k = paramIntArray.size; b < k; b++) {
/* 240 */       int m = paramIntArray.get(b);
/* 241 */       for (byte b1 = 0; b1 < i; b1++) {
/* 242 */         if (m == arrayOfInt[b1]) {
/* 243 */           removeIndex(b1);
/* 244 */           i--;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 249 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public int pop() {
/* 254 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public int peek() {
/* 259 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public int first() {
/* 264 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 265 */     return this.items[0];
/*     */   }
/*     */   
/*     */   public void clear() {
/* 269 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] shrink() {
/* 276 */     if (this.items.length != this.size) resize(this.size); 
/* 277 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] ensureCapacity(int paramInt) {
/* 284 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 286 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(8, paramInt)); 
/* 287 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] setSize(int paramInt) {
/* 293 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 294 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 295 */     this.size = paramInt;
/* 296 */     return this.items;
/*     */   }
/*     */   
/*     */   protected int[] resize(int paramInt) {
/* 300 */     int[] arrayOfInt1 = new int[paramInt];
/*     */     int[] arrayOfInt2;
/* 302 */     System.arraycopy(arrayOfInt2 = this.items, 0, arrayOfInt1, 0, Math.min(this.size, paramInt));
/* 303 */     this.items = arrayOfInt1;
/* 304 */     return arrayOfInt1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 308 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 312 */     int[] arrayOfInt = this.items; byte b; int i, j;
/* 313 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 314 */       int k = i - b;
/* 315 */       int m = arrayOfInt[b];
/* 316 */       arrayOfInt[b] = arrayOfInt[k];
/* 317 */       arrayOfInt[k] = m;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 324 */     if (this.size > paramInt) this.size = paramInt; 
/*     */   }
/*     */   
/*     */   public int[] toArray() {
/* 328 */     int[] arrayOfInt = new int[this.size];
/* 329 */     System.arraycopy(this.items, 0, arrayOfInt, 0, this.size);
/* 330 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 334 */     if (!this.ordered) return super.hashCode(); 
/* 335 */     int[] arrayOfInt = this.items;
/* 336 */     int i = 1; byte b; int j;
/* 337 */     for (b = 0, j = this.size; b < j; b++)
/* 338 */       i = i * 31 + arrayOfInt[b]; 
/* 339 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 343 */     if (paramObject == this) return true; 
/* 344 */     if (!this.ordered) return false; 
/* 345 */     if (!(paramObject instanceof IntArray)) return false;
/*     */     
/* 347 */     if (!((IntArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 349 */     if ((i = this.size) != ((IntArray)paramObject).size) return false; 
/* 350 */     int[] arrayOfInt = this.items;
/* 351 */     paramObject = ((IntArray)paramObject).items;
/* 352 */     for (byte b = 0; b < i; b++) {
/* 353 */       if (arrayOfInt[b] != paramObject[b]) return false; 
/* 354 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 358 */     if (this.size == 0) return "[]"; 
/* 359 */     int[] arrayOfInt = this.items;
/*     */     StringBuilder stringBuilder;
/* 361 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 362 */     stringBuilder.append(arrayOfInt[0]);
/* 363 */     for (byte b = 1; b < this.size; b++) {
/* 364 */       stringBuilder.append(", ");
/* 365 */       stringBuilder.append(arrayOfInt[b]);
/*     */     } 
/* 367 */     stringBuilder.append(']');
/* 368 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 372 */     if (this.size == 0) return ""; 
/* 373 */     int[] arrayOfInt = this.items;
/*     */     StringBuilder stringBuilder;
/* 375 */     (stringBuilder = new StringBuilder(32)).append(arrayOfInt[0]);
/* 376 */     for (byte b = 1; b < this.size; b++) {
/* 377 */       stringBuilder.append(paramString);
/* 378 */       stringBuilder.append(arrayOfInt[b]);
/*     */     } 
/* 380 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static IntArray with(int... paramVarArgs) {
/* 385 */     return new IntArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\IntArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */