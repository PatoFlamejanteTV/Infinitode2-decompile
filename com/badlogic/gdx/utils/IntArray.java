/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ public class IntArray
/*     */ {
/*     */   public int[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public IntArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new int[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(IntArray paramIntArray) {
/*  53 */     this.ordered = paramIntArray.ordered;
/*  54 */     this.size = paramIntArray.size;
/*  55 */     this.items = new int[this.size];
/*  56 */     System.arraycopy(paramIntArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(int[] paramArrayOfint) {
/*  62 */     this(true, paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray(boolean paramBoolean, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOfint, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(int paramInt) {
/*  76 */     int[] arrayOfInt = this.items;
/*  77 */     if (this.size == arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  78 */     arrayOfInt[this.size++] = paramInt;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2) {
/*  82 */     int[] arrayOfInt = this.items;
/*  83 */     if (this.size + 1 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  84 */     arrayOfInt[this.size] = paramInt1;
/*  85 */     arrayOfInt[this.size + 1] = paramInt2;
/*  86 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2, int paramInt3) {
/*  90 */     int[] arrayOfInt = this.items;
/*  91 */     if (this.size + 2 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  92 */     arrayOfInt[this.size] = paramInt1;
/*  93 */     arrayOfInt[this.size + 1] = paramInt2;
/*  94 */     arrayOfInt[this.size + 2] = paramInt3;
/*  95 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  99 */     int[] arrayOfInt = this.items;
/* 100 */     if (this.size + 3 >= arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 101 */     arrayOfInt[this.size] = paramInt1;
/* 102 */     arrayOfInt[this.size + 1] = paramInt2;
/* 103 */     arrayOfInt[this.size + 2] = paramInt3;
/* 104 */     arrayOfInt[this.size + 3] = paramInt4;
/* 105 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray) {
/* 109 */     addAll(paramIntArray.items, 0, paramIntArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(IntArray paramIntArray, int paramInt1, int paramInt2) {
/* 113 */     if (paramInt1 + paramInt2 > paramIntArray.size)
/* 114 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramIntArray.size); 
/* 115 */     addAll(paramIntArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(int... paramVarArgs) {
/* 119 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 123 */     int[] arrayOfInt = this.items;
/*     */     int i;
/* 125 */     if ((i = this.size + paramInt2) > arrayOfInt.length) arrayOfInt = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 126 */     System.arraycopy(paramArrayOfint, paramInt1, arrayOfInt, this.size, paramInt2);
/* 127 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public int get(int paramInt) {
/* 131 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 132 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt1, int paramInt2) {
/* 136 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 137 */     this.items[paramInt1] = paramInt2;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt1, int paramInt2) {
/* 141 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 142 */     this.items[paramInt1] = this.items[paramInt1] + paramInt2;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt) {
/* 146 */     int[] arrayOfInt = this.items; byte b; int i;
/* 147 */     for (b = 0, i = this.size; b < i; b++)
/* 148 */       arrayOfInt[b] = arrayOfInt[b] + paramInt; 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt1, int paramInt2) {
/* 152 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 153 */     this.items[paramInt1] = this.items[paramInt1] * paramInt2;
/*     */   }
/*     */   
/*     */   public void mul(int paramInt) {
/* 157 */     int[] arrayOfInt = this.items; byte b; int i;
/* 158 */     for (b = 0, i = this.size; b < i; b++)
/* 159 */       arrayOfInt[b] = arrayOfInt[b] * paramInt; 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt1, int paramInt2) {
/* 163 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/* 164 */     int[] arrayOfInt = this.items;
/* 165 */     if (this.size == arrayOfInt.length) arrayOfInt = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 166 */     if (this.ordered) {
/* 167 */       System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
/*     */     } else {
/* 169 */       arrayOfInt[this.size] = arrayOfInt[paramInt1];
/* 170 */     }  this.size++;
/* 171 */     arrayOfInt[paramInt1] = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 177 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/*     */     int i;
/* 179 */     if ((i = this.size + paramInt2) > this.items.length) this.items = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 180 */     System.arraycopy(this.items, paramInt1, this.items, paramInt1 + paramInt2, this.size - paramInt1);
/* 181 */     this.size = i;
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 185 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 186 */     if (paramInt2 >= this.size) throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
/*     */     
/* 188 */     int arrayOfInt[], i = (arrayOfInt = this.items)[paramInt1];
/* 189 */     arrayOfInt[paramInt1] = arrayOfInt[paramInt2];
/* 190 */     arrayOfInt[paramInt2] = i;
/*     */   }
/*     */   
/*     */   public boolean contains(int paramInt) {
/* 194 */     int i = this.size - 1;
/* 195 */     int[] arrayOfInt = this.items;
/* 196 */     while (i >= 0) {
/* 197 */       if (arrayOfInt[i--] == paramInt) return true; 
/* 198 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(int paramInt) {
/* 202 */     int[] arrayOfInt = this.items; byte b; int i;
/* 203 */     for (b = 0, i = this.size; b < i; b++) {
/* 204 */       if (arrayOfInt[b] == paramInt) return b; 
/* 205 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(int paramInt) {
/* 209 */     int[] arrayOfInt = this.items;
/* 210 */     for (int i = this.size - 1; i >= 0; i--) {
/* 211 */       if (arrayOfInt[i] == paramInt) return i; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(int paramInt) {
/* 216 */     int[] arrayOfInt = this.items; byte b; int i;
/* 217 */     for (b = 0, i = this.size; b < i; b++) {
/* 218 */       if (arrayOfInt[b] == paramInt) {
/* 219 */         removeIndex(b);
/* 220 */         return true;
/*     */       } 
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeIndex(int paramInt) {
/* 228 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 230 */     int arrayOfInt[], i = (arrayOfInt = this.items)[paramInt];
/* 231 */     this.size--;
/* 232 */     if (this.ordered) {
/* 233 */       System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
/*     */     } else {
/* 235 */       arrayOfInt[paramInt] = arrayOfInt[this.size];
/* 236 */     }  return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 241 */     int i = this.size;
/* 242 */     if (paramInt2 >= i) throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size); 
/* 243 */     if (paramInt1 > paramInt2) throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2); 
/* 244 */     int j = paramInt2 - paramInt1 + 1, k = i - j;
/* 245 */     if (this.ordered) {
/* 246 */       System.arraycopy(this.items, paramInt1 + j, this.items, paramInt1, i - paramInt1 + j);
/*     */     } else {
/* 248 */       paramInt2 = Math.max(k, paramInt2 + 1);
/* 249 */       System.arraycopy(this.items, paramInt2, this.items, paramInt1, i - paramInt2);
/*     */     } 
/* 251 */     this.size = k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(IntArray paramIntArray) {
/* 258 */     int i = this.size, j = i;
/* 259 */     int[] arrayOfInt = this.items; byte b; int k;
/* 260 */     for (b = 0, k = paramIntArray.size; b < k; b++) {
/* 261 */       int m = paramIntArray.get(b);
/* 262 */       for (byte b1 = 0; b1 < i; b1++) {
/* 263 */         if (m == arrayOfInt[b1]) {
/* 264 */           removeIndex(b1);
/* 265 */           i--;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 270 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public int pop() {
/* 275 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public int peek() {
/* 280 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public int first() {
/* 285 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 286 */     return this.items[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 291 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 296 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 300 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] shrink() {
/* 307 */     if (this.items.length != this.size) resize(this.size); 
/* 308 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] ensureCapacity(int paramInt) {
/* 315 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 317 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 318 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] setSize(int paramInt) {
/* 324 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 325 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 326 */     this.size = paramInt;
/* 327 */     return this.items;
/*     */   }
/*     */   
/*     */   protected int[] resize(int paramInt) {
/* 331 */     int[] arrayOfInt1 = new int[paramInt];
/*     */     int[] arrayOfInt2;
/* 333 */     System.arraycopy(arrayOfInt2 = this.items, 0, arrayOfInt1, 0, Math.min(this.size, paramInt));
/* 334 */     this.items = arrayOfInt1;
/* 335 */     return arrayOfInt1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 339 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 343 */     int[] arrayOfInt = this.items; byte b; int i, j;
/* 344 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 345 */       int k = i - b;
/* 346 */       int m = arrayOfInt[b];
/* 347 */       arrayOfInt[b] = arrayOfInt[k];
/* 348 */       arrayOfInt[k] = m;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 353 */     int[] arrayOfInt = this.items;
/* 354 */     for (int i = this.size - 1; i >= 0; i--) {
/* 355 */       int j = MathUtils.random(i);
/* 356 */       int k = arrayOfInt[i];
/* 357 */       arrayOfInt[i] = arrayOfInt[j];
/* 358 */       arrayOfInt[j] = k;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 365 */     if (this.size > paramInt) this.size = paramInt;
/*     */   
/*     */   }
/*     */   
/*     */   public int random() {
/* 370 */     if (this.size == 0) return 0; 
/* 371 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public int[] toArray() {
/* 375 */     int[] arrayOfInt = new int[this.size];
/* 376 */     System.arraycopy(this.items, 0, arrayOfInt, 0, this.size);
/* 377 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (!this.ordered) return super.hashCode(); 
/* 382 */     int[] arrayOfInt = this.items;
/* 383 */     int i = 1; byte b; int j;
/* 384 */     for (b = 0, j = this.size; b < j; b++)
/* 385 */       i = i * 31 + arrayOfInt[b]; 
/* 386 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 390 */     if (paramObject == this) return true; 
/* 391 */     if (!this.ordered) return false; 
/* 392 */     if (!(paramObject instanceof IntArray)) return false;
/*     */     
/* 394 */     if (!((IntArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 396 */     if ((i = this.size) != ((IntArray)paramObject).size) return false; 
/* 397 */     int[] arrayOfInt = this.items; paramObject = ((IntArray)paramObject).items;
/* 398 */     for (byte b = 0; b < i; b++) {
/* 399 */       if (arrayOfInt[b] != paramObject[b]) return false; 
/* 400 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 404 */     if (this.size == 0) return "[]"; 
/* 405 */     int[] arrayOfInt = this.items;
/*     */     StringBuilder stringBuilder;
/* 407 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 408 */     stringBuilder.append(arrayOfInt[0]);
/* 409 */     for (byte b = 1; b < this.size; b++) {
/* 410 */       stringBuilder.append(", ");
/* 411 */       stringBuilder.append(arrayOfInt[b]);
/*     */     } 
/* 413 */     stringBuilder.append(']');
/* 414 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 418 */     if (this.size == 0) return ""; 
/* 419 */     int[] arrayOfInt = this.items;
/*     */     StringBuilder stringBuilder;
/* 421 */     (stringBuilder = new StringBuilder(32)).append(arrayOfInt[0]);
/* 422 */     for (byte b = 1; b < this.size; b++) {
/* 423 */       stringBuilder.append(paramString);
/* 424 */       stringBuilder.append(arrayOfInt[b]);
/*     */     } 
/* 426 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static IntArray with(int... paramVarArgs) {
/* 431 */     return new IntArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IntArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */