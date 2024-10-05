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
/*     */ public class LongArray
/*     */ {
/*     */   public long[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public LongArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public LongArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new long[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongArray(LongArray paramLongArray) {
/*  53 */     this.ordered = paramLongArray.ordered;
/*  54 */     this.size = paramLongArray.size;
/*  55 */     this.items = new long[this.size];
/*  56 */     System.arraycopy(paramLongArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LongArray(long[] paramArrayOflong) {
/*  62 */     this(true, paramArrayOflong, 0, paramArrayOflong.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongArray(boolean paramBoolean, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOflong, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(long paramLong) {
/*  76 */     long[] arrayOfLong = this.items;
/*  77 */     if (this.size == arrayOfLong.length) arrayOfLong = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  78 */     arrayOfLong[this.size++] = paramLong;
/*     */   }
/*     */   
/*     */   public void add(long paramLong1, long paramLong2) {
/*  82 */     long[] arrayOfLong = this.items;
/*  83 */     if (this.size + 1 >= arrayOfLong.length) arrayOfLong = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  84 */     arrayOfLong[this.size] = paramLong1;
/*  85 */     arrayOfLong[this.size + 1] = paramLong2;
/*  86 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(long paramLong1, long paramLong2, long paramLong3) {
/*  90 */     long[] arrayOfLong = this.items;
/*  91 */     if (this.size + 2 >= arrayOfLong.length) arrayOfLong = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  92 */     arrayOfLong[this.size] = paramLong1;
/*  93 */     arrayOfLong[this.size + 1] = paramLong2;
/*  94 */     arrayOfLong[this.size + 2] = paramLong3;
/*  95 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  99 */     long[] arrayOfLong = this.items;
/* 100 */     if (this.size + 3 >= arrayOfLong.length) arrayOfLong = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 101 */     arrayOfLong[this.size] = paramLong1;
/* 102 */     arrayOfLong[this.size + 1] = paramLong2;
/* 103 */     arrayOfLong[this.size + 2] = paramLong3;
/* 104 */     arrayOfLong[this.size + 3] = paramLong4;
/* 105 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(LongArray paramLongArray) {
/* 109 */     addAll(paramLongArray.items, 0, paramLongArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(LongArray paramLongArray, int paramInt1, int paramInt2) {
/* 113 */     if (paramInt1 + paramInt2 > paramLongArray.size)
/* 114 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramLongArray.size); 
/* 115 */     addAll(paramLongArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(long... paramVarArgs) {
/* 119 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 123 */     long[] arrayOfLong = this.items;
/*     */     int i;
/* 125 */     if ((i = this.size + paramInt2) > arrayOfLong.length) arrayOfLong = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 126 */     System.arraycopy(paramArrayOflong, paramInt1, arrayOfLong, this.size, paramInt2);
/* 127 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public long get(int paramInt) {
/* 131 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 132 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, long paramLong) {
/* 136 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 137 */     this.items[paramInt] = paramLong;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt, long paramLong) {
/* 141 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 142 */     this.items[paramInt] = this.items[paramInt] + paramLong;
/*     */   }
/*     */   
/*     */   public void incr(long paramLong) {
/* 146 */     long[] arrayOfLong = this.items; byte b; int i;
/* 147 */     for (b = 0, i = this.size; b < i; b++)
/* 148 */       arrayOfLong[b] = arrayOfLong[b] + paramLong; 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt, long paramLong) {
/* 152 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 153 */     this.items[paramInt] = this.items[paramInt] * paramLong;
/*     */   }
/*     */   
/*     */   public void mul(long paramLong) {
/* 157 */     long[] arrayOfLong = this.items; byte b; int i;
/* 158 */     for (b = 0, i = this.size; b < i; b++)
/* 159 */       arrayOfLong[b] = arrayOfLong[b] * paramLong; 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, long paramLong) {
/* 163 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 164 */     long[] arrayOfLong = this.items;
/* 165 */     if (this.size == arrayOfLong.length) arrayOfLong = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 166 */     if (this.ordered) {
/* 167 */       System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 169 */       arrayOfLong[this.size] = arrayOfLong[paramInt];
/* 170 */     }  this.size++;
/* 171 */     arrayOfLong[paramInt] = paramLong;
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
/* 188 */     long arrayOfLong[], l = (arrayOfLong = this.items)[paramInt1];
/* 189 */     arrayOfLong[paramInt1] = arrayOfLong[paramInt2];
/* 190 */     arrayOfLong[paramInt2] = l;
/*     */   }
/*     */   
/*     */   public boolean contains(long paramLong) {
/* 194 */     int i = this.size - 1;
/* 195 */     long[] arrayOfLong = this.items;
/* 196 */     while (i >= 0) {
/* 197 */       if (arrayOfLong[i--] == paramLong) return true; 
/* 198 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(long paramLong) {
/* 202 */     long[] arrayOfLong = this.items; byte b; int i;
/* 203 */     for (b = 0, i = this.size; b < i; b++) {
/* 204 */       if (arrayOfLong[b] == paramLong) return b; 
/* 205 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(char paramChar) {
/* 209 */     long[] arrayOfLong = this.items;
/* 210 */     for (int i = this.size - 1; i >= 0; i--) {
/* 211 */       if (arrayOfLong[i] == paramChar) return i; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(long paramLong) {
/* 216 */     long[] arrayOfLong = this.items; byte b; int i;
/* 217 */     for (b = 0, i = this.size; b < i; b++) {
/* 218 */       if (arrayOfLong[b] == paramLong) {
/* 219 */         removeIndex(b);
/* 220 */         return true;
/*     */       } 
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public long removeIndex(int paramInt) {
/* 228 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 230 */     long arrayOfLong[], l = (arrayOfLong = this.items)[paramInt];
/* 231 */     this.size--;
/* 232 */     if (this.ordered) {
/* 233 */       System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, this.size - paramInt);
/*     */     } else {
/* 235 */       arrayOfLong[paramInt] = arrayOfLong[this.size];
/* 236 */     }  return l;
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
/*     */   public boolean removeAll(LongArray paramLongArray) {
/* 258 */     int i = this.size, j = i;
/* 259 */     long[] arrayOfLong = this.items; byte b; int k;
/* 260 */     for (b = 0, k = paramLongArray.size; b < k; b++) {
/* 261 */       long l = paramLongArray.get(b);
/* 262 */       for (byte b1 = 0; b1 < i; b1++) {
/* 263 */         if (l == arrayOfLong[b1]) {
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
/*     */   public long pop() {
/* 275 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public long peek() {
/* 280 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public long first() {
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
/*     */   public long[] shrink() {
/* 307 */     if (this.items.length != this.size) resize(this.size); 
/* 308 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] ensureCapacity(int paramInt) {
/* 315 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 317 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 318 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] setSize(int paramInt) {
/* 324 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 325 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 326 */     this.size = paramInt;
/* 327 */     return this.items;
/*     */   }
/*     */   
/*     */   protected long[] resize(int paramInt) {
/* 331 */     long[] arrayOfLong1 = new long[paramInt];
/*     */     long[] arrayOfLong2;
/* 333 */     System.arraycopy(arrayOfLong2 = this.items, 0, arrayOfLong1, 0, Math.min(this.size, paramInt));
/* 334 */     this.items = arrayOfLong1;
/* 335 */     return arrayOfLong1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 339 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 343 */     long[] arrayOfLong = this.items; byte b; int i, j;
/* 344 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 345 */       int k = i - b;
/* 346 */       long l = arrayOfLong[b];
/* 347 */       arrayOfLong[b] = arrayOfLong[k];
/* 348 */       arrayOfLong[k] = l;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 353 */     long[] arrayOfLong = this.items;
/* 354 */     for (int i = this.size - 1; i >= 0; i--) {
/* 355 */       int j = MathUtils.random(i);
/* 356 */       long l = arrayOfLong[i];
/* 357 */       arrayOfLong[i] = arrayOfLong[j];
/* 358 */       arrayOfLong[j] = l;
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
/*     */   public long random() {
/* 370 */     if (this.size == 0) return 0L; 
/* 371 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public long[] toArray() {
/* 375 */     long[] arrayOfLong = new long[this.size];
/* 376 */     System.arraycopy(this.items, 0, arrayOfLong, 0, this.size);
/* 377 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (!this.ordered) return super.hashCode(); 
/* 382 */     long[] arrayOfLong = this.items;
/* 383 */     int i = 1; byte b; int j;
/* 384 */     for (b = 0, j = this.size; b < j; b++) {
/* 385 */       long l = arrayOfLong[b];
/* 386 */       i = i * 31 + (int)(l ^ l >>> 32L);
/*     */     } 
/* 388 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 392 */     if (paramObject == this) return true; 
/* 393 */     if (!this.ordered) return false; 
/* 394 */     if (!(paramObject instanceof LongArray)) return false;
/*     */     
/* 396 */     if (!((LongArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 398 */     if ((i = this.size) != ((LongArray)paramObject).size) return false; 
/* 399 */     long[] arrayOfLong = this.items; paramObject = ((LongArray)paramObject).items;
/* 400 */     for (byte b = 0; b < i; b++) {
/* 401 */       if (arrayOfLong[b] != paramObject[b]) return false; 
/* 402 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 406 */     if (this.size == 0) return "[]"; 
/* 407 */     long[] arrayOfLong = this.items;
/*     */     StringBuilder stringBuilder;
/* 409 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 410 */     stringBuilder.append(arrayOfLong[0]);
/* 411 */     for (byte b = 1; b < this.size; b++) {
/* 412 */       stringBuilder.append(", ");
/* 413 */       stringBuilder.append(arrayOfLong[b]);
/*     */     } 
/* 415 */     stringBuilder.append(']');
/* 416 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 420 */     if (this.size == 0) return ""; 
/* 421 */     long[] arrayOfLong = this.items;
/*     */     StringBuilder stringBuilder;
/* 423 */     (stringBuilder = new StringBuilder(32)).append(arrayOfLong[0]);
/* 424 */     for (byte b = 1; b < this.size; b++) {
/* 425 */       stringBuilder.append(paramString);
/* 426 */       stringBuilder.append(arrayOfLong[b]);
/*     */     } 
/* 428 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static LongArray with(long... paramVarArgs) {
/* 433 */     return new LongArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\LongArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */