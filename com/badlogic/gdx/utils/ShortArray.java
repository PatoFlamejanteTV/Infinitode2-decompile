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
/*     */ public class ShortArray
/*     */ {
/*     */   public short[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public ShortArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new short[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray(ShortArray paramShortArray) {
/*  53 */     this.ordered = paramShortArray.ordered;
/*  54 */     this.size = paramShortArray.size;
/*  55 */     this.items = new short[this.size];
/*  56 */     System.arraycopy(paramShortArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray(short[] paramArrayOfshort) {
/*  62 */     this(true, paramArrayOfshort, 0, paramArrayOfshort.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortArray(boolean paramBoolean, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOfshort, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt) {
/*  77 */     short[] arrayOfShort = this.items;
/*  78 */     if (this.size == arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  79 */     arrayOfShort[this.size++] = (short)paramInt;
/*     */   }
/*     */   
/*     */   public void add(short paramShort) {
/*  83 */     short[] arrayOfShort = this.items;
/*  84 */     if (this.size == arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  85 */     arrayOfShort[this.size++] = paramShort;
/*     */   }
/*     */   
/*     */   public void add(short paramShort1, short paramShort2) {
/*  89 */     short[] arrayOfShort = this.items;
/*  90 */     if (this.size + 1 >= arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  91 */     arrayOfShort[this.size] = paramShort1;
/*  92 */     arrayOfShort[this.size + 1] = paramShort2;
/*  93 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(short paramShort1, short paramShort2, short paramShort3) {
/*  97 */     short[] arrayOfShort = this.items;
/*  98 */     if (this.size + 2 >= arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  99 */     arrayOfShort[this.size] = paramShort1;
/* 100 */     arrayOfShort[this.size + 1] = paramShort2;
/* 101 */     arrayOfShort[this.size + 2] = paramShort3;
/* 102 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(short paramShort1, short paramShort2, short paramShort3, short paramShort4) {
/* 106 */     short[] arrayOfShort = this.items;
/* 107 */     if (this.size + 3 >= arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 108 */     arrayOfShort[this.size] = paramShort1;
/* 109 */     arrayOfShort[this.size + 1] = paramShort2;
/* 110 */     arrayOfShort[this.size + 2] = paramShort3;
/* 111 */     arrayOfShort[this.size + 3] = paramShort4;
/* 112 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(ShortArray paramShortArray) {
/* 116 */     addAll(paramShortArray.items, 0, paramShortArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(ShortArray paramShortArray, int paramInt1, int paramInt2) {
/* 120 */     if (paramInt1 + paramInt2 > paramShortArray.size)
/* 121 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramShortArray.size); 
/* 122 */     addAll(paramShortArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(short... paramVarArgs) {
/* 126 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 130 */     short[] arrayOfShort = this.items;
/*     */     int i;
/* 132 */     if ((i = this.size + paramInt2) > arrayOfShort.length) arrayOfShort = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 133 */     System.arraycopy(paramArrayOfshort, paramInt1, arrayOfShort, this.size, paramInt2);
/* 134 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public short get(int paramInt) {
/* 138 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 139 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, short paramShort) {
/* 143 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 144 */     this.items[paramInt] = paramShort;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt, short paramShort) {
/* 148 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 149 */     this.items[paramInt] = (short)(this.items[paramInt] + paramShort);
/*     */   }
/*     */   
/*     */   public void incr(short paramShort) {
/* 153 */     short[] arrayOfShort = this.items; byte b; int i;
/* 154 */     for (b = 0, i = this.size; b < i; b++)
/* 155 */       arrayOfShort[b] = (short)(arrayOfShort[b] + paramShort); 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt, short paramShort) {
/* 159 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 160 */     this.items[paramInt] = (short)(this.items[paramInt] * paramShort);
/*     */   }
/*     */   
/*     */   public void mul(short paramShort) {
/* 164 */     short[] arrayOfShort = this.items; byte b; int i;
/* 165 */     for (b = 0, i = this.size; b < i; b++)
/* 166 */       arrayOfShort[b] = (short)(arrayOfShort[b] * paramShort); 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, short paramShort) {
/* 170 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 171 */     short[] arrayOfShort = this.items;
/* 172 */     if (this.size == arrayOfShort.length) arrayOfShort = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 173 */     if (this.ordered) {
/* 174 */       System.arraycopy(arrayOfShort, paramInt, arrayOfShort, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 176 */       arrayOfShort[this.size] = arrayOfShort[paramInt];
/* 177 */     }  this.size++;
/* 178 */     arrayOfShort[paramInt] = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 184 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/*     */     int i;
/* 186 */     if ((i = this.size + paramInt2) > this.items.length) this.items = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 187 */     System.arraycopy(this.items, paramInt1, this.items, paramInt1 + paramInt2, this.size - paramInt1);
/* 188 */     this.size = i;
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 192 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 193 */     if (paramInt2 >= this.size) throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
/*     */     
/* 195 */     short arrayOfShort[], s = (arrayOfShort = this.items)[paramInt1];
/* 196 */     arrayOfShort[paramInt1] = arrayOfShort[paramInt2];
/* 197 */     arrayOfShort[paramInt2] = s;
/*     */   }
/*     */   
/*     */   public boolean contains(short paramShort) {
/* 201 */     int i = this.size - 1;
/* 202 */     short[] arrayOfShort = this.items;
/* 203 */     while (i >= 0) {
/* 204 */       if (arrayOfShort[i--] == paramShort) return true; 
/* 205 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(short paramShort) {
/* 209 */     short[] arrayOfShort = this.items; byte b; int i;
/* 210 */     for (b = 0, i = this.size; b < i; b++) {
/* 211 */       if (arrayOfShort[b] == paramShort) return b; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(char paramChar) {
/* 216 */     short[] arrayOfShort = this.items;
/* 217 */     for (int i = this.size - 1; i >= 0; i--) {
/* 218 */       if (arrayOfShort[i] == paramChar) return i; 
/* 219 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(short paramShort) {
/* 223 */     short[] arrayOfShort = this.items; byte b; int i;
/* 224 */     for (b = 0, i = this.size; b < i; b++) {
/* 225 */       if (arrayOfShort[b] == paramShort) {
/* 226 */         removeIndex(b);
/* 227 */         return true;
/*     */       } 
/*     */     } 
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public short removeIndex(int paramInt) {
/* 235 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 237 */     short arrayOfShort[], s = (arrayOfShort = this.items)[paramInt];
/* 238 */     this.size--;
/* 239 */     if (this.ordered) {
/* 240 */       System.arraycopy(arrayOfShort, paramInt + 1, arrayOfShort, paramInt, this.size - paramInt);
/*     */     } else {
/* 242 */       arrayOfShort[paramInt] = arrayOfShort[this.size];
/* 243 */     }  return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 248 */     int i = this.size;
/* 249 */     if (paramInt2 >= i) throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size); 
/* 250 */     if (paramInt1 > paramInt2) throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2); 
/* 251 */     int j = paramInt2 - paramInt1 + 1, k = i - j;
/* 252 */     if (this.ordered) {
/* 253 */       System.arraycopy(this.items, paramInt1 + j, this.items, paramInt1, i - paramInt1 + j);
/*     */     } else {
/* 255 */       paramInt2 = Math.max(k, paramInt2 + 1);
/* 256 */       System.arraycopy(this.items, paramInt2, this.items, paramInt1, i - paramInt2);
/*     */     } 
/* 258 */     this.size = k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(ShortArray paramShortArray) {
/* 265 */     int i = this.size, j = i;
/* 266 */     short[] arrayOfShort = this.items; byte b; int k;
/* 267 */     for (b = 0, k = paramShortArray.size; b < k; b++) {
/* 268 */       short s = paramShortArray.get(b);
/* 269 */       for (byte b1 = 0; b1 < i; b1++) {
/* 270 */         if (s == arrayOfShort[b1]) {
/* 271 */           removeIndex(b1);
/* 272 */           i--;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 277 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public short pop() {
/* 282 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public short peek() {
/* 287 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public short first() {
/* 292 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 293 */     return this.items[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 298 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 303 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 307 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short[] shrink() {
/* 314 */     if (this.items.length != this.size) resize(this.size); 
/* 315 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short[] ensureCapacity(int paramInt) {
/* 322 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 324 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 325 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short[] setSize(int paramInt) {
/* 331 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 332 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 333 */     this.size = paramInt;
/* 334 */     return this.items;
/*     */   }
/*     */   
/*     */   protected short[] resize(int paramInt) {
/* 338 */     short[] arrayOfShort1 = new short[paramInt];
/*     */     short[] arrayOfShort2;
/* 340 */     System.arraycopy(arrayOfShort2 = this.items, 0, arrayOfShort1, 0, Math.min(this.size, paramInt));
/* 341 */     this.items = arrayOfShort1;
/* 342 */     return arrayOfShort1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 346 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 350 */     short[] arrayOfShort = this.items; byte b; int i, j;
/* 351 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 352 */       int k = i - b;
/* 353 */       short s = arrayOfShort[b];
/* 354 */       arrayOfShort[b] = arrayOfShort[k];
/* 355 */       arrayOfShort[k] = s;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 360 */     short[] arrayOfShort = this.items;
/* 361 */     for (int i = this.size - 1; i >= 0; i--) {
/* 362 */       int j = MathUtils.random(i);
/* 363 */       short s = arrayOfShort[i];
/* 364 */       arrayOfShort[i] = arrayOfShort[j];
/* 365 */       arrayOfShort[j] = s;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 372 */     if (this.size > paramInt) this.size = paramInt;
/*     */   
/*     */   }
/*     */   
/*     */   public short random() {
/* 377 */     if (this.size == 0) return 0; 
/* 378 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public short[] toArray() {
/* 382 */     short[] arrayOfShort = new short[this.size];
/* 383 */     System.arraycopy(this.items, 0, arrayOfShort, 0, this.size);
/* 384 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 388 */     if (!this.ordered) return super.hashCode(); 
/* 389 */     short[] arrayOfShort = this.items;
/* 390 */     int i = 1; byte b; int j;
/* 391 */     for (b = 0, j = this.size; b < j; b++)
/* 392 */       i = i * 31 + arrayOfShort[b]; 
/* 393 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 397 */     if (paramObject == this) return true; 
/* 398 */     if (!this.ordered) return false; 
/* 399 */     if (!(paramObject instanceof ShortArray)) return false;
/*     */     
/* 401 */     if (!((ShortArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 403 */     if ((i = this.size) != ((ShortArray)paramObject).size) return false; 
/* 404 */     short[] arrayOfShort = this.items; paramObject = ((ShortArray)paramObject).items;
/* 405 */     for (byte b = 0; b < i; b++) {
/* 406 */       if (arrayOfShort[b] != paramObject[b]) return false; 
/* 407 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 411 */     if (this.size == 0) return "[]"; 
/* 412 */     short[] arrayOfShort = this.items;
/*     */     StringBuilder stringBuilder;
/* 414 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 415 */     stringBuilder.append(arrayOfShort[0]);
/* 416 */     for (byte b = 1; b < this.size; b++) {
/* 417 */       stringBuilder.append(", ");
/* 418 */       stringBuilder.append(arrayOfShort[b]);
/*     */     } 
/* 420 */     stringBuilder.append(']');
/* 421 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 425 */     if (this.size == 0) return ""; 
/* 426 */     short[] arrayOfShort = this.items;
/*     */     StringBuilder stringBuilder;
/* 428 */     (stringBuilder = new StringBuilder(32)).append(arrayOfShort[0]);
/* 429 */     for (byte b = 1; b < this.size; b++) {
/* 430 */       stringBuilder.append(paramString);
/* 431 */       stringBuilder.append(arrayOfShort[b]);
/*     */     } 
/* 433 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static ShortArray with(short... paramVarArgs) {
/* 438 */     return new ShortArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ShortArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */