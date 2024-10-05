/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BooleanArray
/*     */ {
/*     */   public boolean[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public BooleanArray() {
/*  35 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public BooleanArray(int paramInt) {
/*  40 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BooleanArray(boolean paramBoolean, int paramInt) {
/*  47 */     this.ordered = paramBoolean;
/*  48 */     this.items = new boolean[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BooleanArray(BooleanArray paramBooleanArray) {
/*  55 */     this.ordered = paramBooleanArray.ordered;
/*  56 */     this.size = paramBooleanArray.size;
/*  57 */     this.items = new boolean[this.size];
/*  58 */     System.arraycopy(paramBooleanArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BooleanArray(boolean[] paramArrayOfboolean) {
/*  64 */     this(true, paramArrayOfboolean, 0, paramArrayOfboolean.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BooleanArray(boolean paramBoolean, boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/*  72 */     this(paramBoolean, paramInt2);
/*  73 */     this.size = paramInt2;
/*  74 */     System.arraycopy(paramArrayOfboolean, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(boolean paramBoolean) {
/*  78 */     boolean[] arrayOfBoolean = this.items;
/*  79 */     if (this.size == arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  80 */     arrayOfBoolean[this.size++] = paramBoolean;
/*     */   }
/*     */   
/*     */   public void add(boolean paramBoolean1, boolean paramBoolean2) {
/*  84 */     boolean[] arrayOfBoolean = this.items;
/*  85 */     if (this.size + 1 >= arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  86 */     arrayOfBoolean[this.size] = paramBoolean1;
/*  87 */     arrayOfBoolean[this.size + 1] = paramBoolean2;
/*  88 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  92 */     boolean[] arrayOfBoolean = this.items;
/*  93 */     if (this.size + 2 >= arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  94 */     arrayOfBoolean[this.size] = paramBoolean1;
/*  95 */     arrayOfBoolean[this.size + 1] = paramBoolean2;
/*  96 */     arrayOfBoolean[this.size + 2] = paramBoolean3;
/*  97 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 101 */     boolean[] arrayOfBoolean = this.items;
/* 102 */     if (this.size + 3 >= arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 103 */     arrayOfBoolean[this.size] = paramBoolean1;
/* 104 */     arrayOfBoolean[this.size + 1] = paramBoolean2;
/* 105 */     arrayOfBoolean[this.size + 2] = paramBoolean3;
/* 106 */     arrayOfBoolean[this.size + 3] = paramBoolean4;
/* 107 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(BooleanArray paramBooleanArray) {
/* 111 */     addAll(paramBooleanArray.items, 0, paramBooleanArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(BooleanArray paramBooleanArray, int paramInt1, int paramInt2) {
/* 115 */     if (paramInt1 + paramInt2 > paramBooleanArray.size)
/* 116 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramBooleanArray.size); 
/* 117 */     addAll(paramBooleanArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(boolean... paramVarArgs) {
/* 121 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 125 */     boolean[] arrayOfBoolean = this.items;
/*     */     int i;
/* 127 */     if ((i = this.size + paramInt2) > arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 128 */     System.arraycopy(paramArrayOfboolean, paramInt1, arrayOfBoolean, this.size, paramInt2);
/* 129 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public boolean get(int paramInt) {
/* 133 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 134 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, boolean paramBoolean) {
/* 138 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 139 */     this.items[paramInt] = paramBoolean;
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, boolean paramBoolean) {
/* 143 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 144 */     boolean[] arrayOfBoolean = this.items;
/* 145 */     if (this.size == arrayOfBoolean.length) arrayOfBoolean = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 146 */     if (this.ordered) {
/* 147 */       System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 149 */       arrayOfBoolean[this.size] = arrayOfBoolean[paramInt];
/* 150 */     }  this.size++;
/* 151 */     arrayOfBoolean[paramInt] = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 157 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/*     */     int i;
/* 159 */     if ((i = this.size + paramInt2) > this.items.length) this.items = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 160 */     System.arraycopy(this.items, paramInt1, this.items, paramInt1 + paramInt2, this.size - paramInt1);
/* 161 */     this.size = i;
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 165 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 166 */     if (paramInt2 >= this.size) throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
/*     */     
/* 168 */     boolean arrayOfBoolean[], bool = (arrayOfBoolean = this.items)[paramInt1];
/* 169 */     arrayOfBoolean[paramInt1] = arrayOfBoolean[paramInt2];
/* 170 */     arrayOfBoolean[paramInt2] = bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeIndex(int paramInt) {
/* 175 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 177 */     boolean arrayOfBoolean[], bool = (arrayOfBoolean = this.items)[paramInt];
/* 178 */     this.size--;
/* 179 */     if (this.ordered) {
/* 180 */       System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, this.size - paramInt);
/*     */     } else {
/* 182 */       arrayOfBoolean[paramInt] = arrayOfBoolean[this.size];
/* 183 */     }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 188 */     int i = this.size;
/* 189 */     if (paramInt2 >= i) throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size); 
/* 190 */     if (paramInt1 > paramInt2) throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2); 
/* 191 */     int j = paramInt2 - paramInt1 + 1, k = i - j;
/* 192 */     if (this.ordered) {
/* 193 */       System.arraycopy(this.items, paramInt1 + j, this.items, paramInt1, i - paramInt1 + j);
/*     */     } else {
/* 195 */       paramInt2 = Math.max(k, paramInt2 + 1);
/* 196 */       System.arraycopy(this.items, paramInt2, this.items, paramInt1, i - paramInt2);
/*     */     } 
/* 198 */     this.size = k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(BooleanArray paramBooleanArray) {
/* 205 */     int i = this.size, j = i;
/* 206 */     boolean[] arrayOfBoolean = this.items; byte b; int k;
/* 207 */     for (b = 0, k = paramBooleanArray.size; b < k; b++) {
/* 208 */       boolean bool = paramBooleanArray.get(b);
/* 209 */       for (byte b1 = 0; b1 < i; b1++) {
/* 210 */         if (bool == arrayOfBoolean[b1]) {
/* 211 */           removeIndex(b1);
/* 212 */           i--;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 217 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean pop() {
/* 222 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean peek() {
/* 227 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean first() {
/* 232 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 233 */     return this.items[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 238 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 243 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 247 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean[] shrink() {
/* 254 */     if (this.items.length != this.size) resize(this.size); 
/* 255 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean[] ensureCapacity(int paramInt) {
/* 262 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 264 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 265 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean[] setSize(int paramInt) {
/* 271 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 272 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 273 */     this.size = paramInt;
/* 274 */     return this.items;
/*     */   }
/*     */   
/*     */   protected boolean[] resize(int paramInt) {
/* 278 */     boolean[] arrayOfBoolean1 = new boolean[paramInt];
/*     */     boolean[] arrayOfBoolean2;
/* 280 */     System.arraycopy(arrayOfBoolean2 = this.items, 0, arrayOfBoolean1, 0, Math.min(this.size, paramInt));
/* 281 */     this.items = arrayOfBoolean1;
/* 282 */     return arrayOfBoolean1;
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 286 */     boolean[] arrayOfBoolean = this.items; byte b; int i, j;
/* 287 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 288 */       int k = i - b;
/* 289 */       boolean bool = arrayOfBoolean[b];
/* 290 */       arrayOfBoolean[b] = arrayOfBoolean[k];
/* 291 */       arrayOfBoolean[k] = bool;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 296 */     boolean[] arrayOfBoolean = this.items;
/* 297 */     for (int i = this.size - 1; i >= 0; i--) {
/* 298 */       int j = MathUtils.random(i);
/* 299 */       boolean bool = arrayOfBoolean[i];
/* 300 */       arrayOfBoolean[i] = arrayOfBoolean[j];
/* 301 */       arrayOfBoolean[j] = bool;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 308 */     if (this.size > paramInt) this.size = paramInt;
/*     */   
/*     */   }
/*     */   
/*     */   public boolean random() {
/* 313 */     if (this.size == 0) return false; 
/* 314 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public boolean[] toArray() {
/* 318 */     boolean[] arrayOfBoolean = new boolean[this.size];
/* 319 */     System.arraycopy(this.items, 0, arrayOfBoolean, 0, this.size);
/* 320 */     return arrayOfBoolean;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 324 */     if (!this.ordered) return super.hashCode(); 
/* 325 */     boolean[] arrayOfBoolean = this.items;
/* 326 */     int i = 1; byte b; int j;
/* 327 */     for (b = 0, j = this.size; b < j; b++)
/* 328 */       i = i * 31 + (arrayOfBoolean[b] ? 1231 : 1237); 
/* 329 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 334 */     if (paramObject == this) return true; 
/* 335 */     if (!this.ordered) return false; 
/* 336 */     if (!(paramObject instanceof BooleanArray)) return false;
/*     */     
/* 338 */     if (!((BooleanArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 340 */     if ((i = this.size) != ((BooleanArray)paramObject).size) return false; 
/* 341 */     boolean[] arrayOfBoolean = this.items; paramObject = ((BooleanArray)paramObject).items;
/* 342 */     for (byte b = 0; b < i; b++) {
/* 343 */       if (arrayOfBoolean[b] != paramObject[b]) return false; 
/* 344 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 348 */     if (this.size == 0) return "[]"; 
/* 349 */     boolean[] arrayOfBoolean = this.items;
/*     */     StringBuilder stringBuilder;
/* 351 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 352 */     stringBuilder.append(arrayOfBoolean[0]);
/* 353 */     for (byte b = 1; b < this.size; b++) {
/* 354 */       stringBuilder.append(", ");
/* 355 */       stringBuilder.append(arrayOfBoolean[b]);
/*     */     } 
/* 357 */     stringBuilder.append(']');
/* 358 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 362 */     if (this.size == 0) return ""; 
/* 363 */     boolean[] arrayOfBoolean = this.items;
/*     */     StringBuilder stringBuilder;
/* 365 */     (stringBuilder = new StringBuilder(32)).append(arrayOfBoolean[0]);
/* 366 */     for (byte b = 1; b < this.size; b++) {
/* 367 */       stringBuilder.append(paramString);
/* 368 */       stringBuilder.append(arrayOfBoolean[b]);
/*     */     } 
/* 370 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static BooleanArray with(boolean... paramVarArgs) {
/* 375 */     return new BooleanArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\BooleanArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */