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
/*     */ public class CharArray
/*     */ {
/*     */   public char[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public CharArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new char[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArray(CharArray paramCharArray) {
/*  53 */     this.ordered = paramCharArray.ordered;
/*  54 */     this.size = paramCharArray.size;
/*  55 */     this.items = new char[this.size];
/*  56 */     System.arraycopy(paramCharArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArray(char[] paramArrayOfchar) {
/*  62 */     this(true, paramArrayOfchar, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArray(boolean paramBoolean, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOfchar, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(char paramChar) {
/*  76 */     char[] arrayOfChar = this.items;
/*  77 */     if (this.size == arrayOfChar.length) arrayOfChar = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  78 */     arrayOfChar[this.size++] = paramChar;
/*     */   }
/*     */   
/*     */   public void add(char paramChar1, char paramChar2) {
/*  82 */     char[] arrayOfChar = this.items;
/*  83 */     if (this.size + 1 >= arrayOfChar.length) arrayOfChar = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  84 */     arrayOfChar[this.size] = paramChar1;
/*  85 */     arrayOfChar[this.size + 1] = paramChar2;
/*  86 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(char paramChar1, char paramChar2, char paramChar3) {
/*  90 */     char[] arrayOfChar = this.items;
/*  91 */     if (this.size + 2 >= arrayOfChar.length) arrayOfChar = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  92 */     arrayOfChar[this.size] = paramChar1;
/*  93 */     arrayOfChar[this.size + 1] = paramChar2;
/*  94 */     arrayOfChar[this.size + 2] = paramChar3;
/*  95 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(char paramChar1, char paramChar2, char paramChar3, char paramChar4) {
/*  99 */     char[] arrayOfChar = this.items;
/* 100 */     if (this.size + 3 >= arrayOfChar.length) arrayOfChar = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 101 */     arrayOfChar[this.size] = paramChar1;
/* 102 */     arrayOfChar[this.size + 1] = paramChar2;
/* 103 */     arrayOfChar[this.size + 2] = paramChar3;
/* 104 */     arrayOfChar[this.size + 3] = paramChar4;
/* 105 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(CharArray paramCharArray) {
/* 109 */     addAll(paramCharArray.items, 0, paramCharArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(CharArray paramCharArray, int paramInt1, int paramInt2) {
/* 113 */     if (paramInt1 + paramInt2 > paramCharArray.size)
/* 114 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramCharArray.size); 
/* 115 */     addAll(paramCharArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(char... paramVarArgs) {
/* 119 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 123 */     char[] arrayOfChar = this.items;
/*     */     int i;
/* 125 */     if ((i = this.size + paramInt2) > arrayOfChar.length) arrayOfChar = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 126 */     System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, this.size, paramInt2);
/* 127 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public char get(int paramInt) {
/* 131 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 132 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, char paramChar) {
/* 136 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 137 */     this.items[paramInt] = paramChar;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt, char paramChar) {
/* 141 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 142 */     this.items[paramInt] = (char)(this.items[paramInt] + paramChar);
/*     */   }
/*     */   
/*     */   public void incr(char paramChar) {
/* 146 */     char[] arrayOfChar = this.items; byte b; int i;
/* 147 */     for (b = 0, i = this.size; b < i; b++)
/* 148 */       arrayOfChar[b] = (char)(arrayOfChar[b] + paramChar); 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt, char paramChar) {
/* 152 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 153 */     this.items[paramInt] = (char)(this.items[paramInt] * paramChar);
/*     */   }
/*     */   
/*     */   public void mul(char paramChar) {
/* 157 */     char[] arrayOfChar = this.items; byte b; int i;
/* 158 */     for (b = 0, i = this.size; b < i; b++)
/* 159 */       arrayOfChar[b] = (char)(arrayOfChar[b] * paramChar); 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, char paramChar) {
/* 163 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 164 */     char[] arrayOfChar = this.items;
/* 165 */     if (this.size == arrayOfChar.length) arrayOfChar = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 166 */     if (this.ordered) {
/* 167 */       System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 169 */       arrayOfChar[this.size] = arrayOfChar[paramInt];
/* 170 */     }  this.size++;
/* 171 */     arrayOfChar[paramInt] = paramChar;
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
/* 188 */     char arrayOfChar[], c = (arrayOfChar = this.items)[paramInt1];
/* 189 */     arrayOfChar[paramInt1] = arrayOfChar[paramInt2];
/* 190 */     arrayOfChar[paramInt2] = c;
/*     */   }
/*     */   
/*     */   public boolean contains(char paramChar) {
/* 194 */     int i = this.size - 1;
/* 195 */     char[] arrayOfChar = this.items;
/* 196 */     while (i >= 0) {
/* 197 */       if (arrayOfChar[i--] == paramChar) return true; 
/* 198 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(char paramChar) {
/* 202 */     char[] arrayOfChar = this.items; byte b; int i;
/* 203 */     for (b = 0, i = this.size; b < i; b++) {
/* 204 */       if (arrayOfChar[b] == paramChar) return b; 
/* 205 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(char paramChar) {
/* 209 */     char[] arrayOfChar = this.items;
/* 210 */     for (int i = this.size - 1; i >= 0; i--) {
/* 211 */       if (arrayOfChar[i] == paramChar) return i; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(char paramChar) {
/* 216 */     char[] arrayOfChar = this.items; byte b; int i;
/* 217 */     for (b = 0, i = this.size; b < i; b++) {
/* 218 */       if (arrayOfChar[b] == paramChar) {
/* 219 */         removeIndex(b);
/* 220 */         return true;
/*     */       } 
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public char removeIndex(int paramInt) {
/* 228 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 230 */     char arrayOfChar[], c = (arrayOfChar = this.items)[paramInt];
/* 231 */     this.size--;
/* 232 */     if (this.ordered) {
/* 233 */       System.arraycopy(arrayOfChar, paramInt + 1, arrayOfChar, paramInt, this.size - paramInt);
/*     */     } else {
/* 235 */       arrayOfChar[paramInt] = arrayOfChar[this.size];
/* 236 */     }  return c;
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
/*     */   public boolean removeAll(CharArray paramCharArray) {
/* 258 */     int i = this.size, j = i;
/* 259 */     char[] arrayOfChar = this.items; byte b; int k;
/* 260 */     for (b = 0, k = paramCharArray.size; b < k; b++) {
/* 261 */       char c = paramCharArray.get(b);
/* 262 */       for (byte b1 = 0; b1 < i; b1++) {
/* 263 */         if (c == arrayOfChar[b1]) {
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
/*     */   public char pop() {
/* 275 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public char peek() {
/* 280 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public char first() {
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
/*     */   public char[] shrink() {
/* 307 */     if (this.items.length != this.size) resize(this.size); 
/* 308 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] ensureCapacity(int paramInt) {
/* 315 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 317 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 318 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] setSize(int paramInt) {
/* 324 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 325 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 326 */     this.size = paramInt;
/* 327 */     return this.items;
/*     */   }
/*     */   
/*     */   protected char[] resize(int paramInt) {
/* 331 */     char[] arrayOfChar1 = new char[paramInt];
/*     */     char[] arrayOfChar2;
/* 333 */     System.arraycopy(arrayOfChar2 = this.items, 0, arrayOfChar1, 0, Math.min(this.size, paramInt));
/* 334 */     this.items = arrayOfChar1;
/* 335 */     return arrayOfChar1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 339 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 343 */     char[] arrayOfChar = this.items; byte b; int i, j;
/* 344 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 345 */       int k = i - b;
/* 346 */       char c = arrayOfChar[b];
/* 347 */       arrayOfChar[b] = arrayOfChar[k];
/* 348 */       arrayOfChar[k] = c;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 353 */     char[] arrayOfChar = this.items;
/* 354 */     for (int i = this.size - 1; i >= 0; i--) {
/* 355 */       int j = MathUtils.random(i);
/* 356 */       char c = arrayOfChar[i];
/* 357 */       arrayOfChar[i] = arrayOfChar[j];
/* 358 */       arrayOfChar[j] = c;
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
/*     */   public char random() {
/* 370 */     if (this.size == 0) return Character.MIN_VALUE; 
/* 371 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public char[] toArray() {
/* 375 */     char[] arrayOfChar = new char[this.size];
/* 376 */     System.arraycopy(this.items, 0, arrayOfChar, 0, this.size);
/* 377 */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (!this.ordered) return super.hashCode(); 
/* 382 */     char[] arrayOfChar = this.items;
/* 383 */     int i = 1; byte b; int j;
/* 384 */     for (b = 0, j = this.size; b < j; b++)
/* 385 */       i = i * 31 + arrayOfChar[b]; 
/* 386 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 391 */     if (paramObject == this) return true; 
/* 392 */     if (!this.ordered) return false; 
/* 393 */     if (!(paramObject instanceof CharArray)) return false;
/*     */     
/* 395 */     if (!((CharArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 397 */     if ((i = this.size) != ((CharArray)paramObject).size) return false; 
/* 398 */     char[] arrayOfChar = this.items; paramObject = ((CharArray)paramObject).items;
/* 399 */     for (byte b = 0; b < i; b++) {
/* 400 */       if (arrayOfChar[b] != paramObject[b]) return false; 
/* 401 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 405 */     if (this.size == 0) return "[]"; 
/* 406 */     char[] arrayOfChar = this.items;
/*     */     StringBuilder stringBuilder;
/* 408 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 409 */     stringBuilder.append(arrayOfChar[0]);
/* 410 */     for (byte b = 1; b < this.size; b++) {
/* 411 */       stringBuilder.append(", ");
/* 412 */       stringBuilder.append(arrayOfChar[b]);
/*     */     } 
/* 414 */     stringBuilder.append(']');
/* 415 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 419 */     if (this.size == 0) return ""; 
/* 420 */     char[] arrayOfChar = this.items;
/*     */     StringBuilder stringBuilder;
/* 422 */     (stringBuilder = new StringBuilder(32)).append(arrayOfChar[0]);
/* 423 */     for (byte b = 1; b < this.size; b++) {
/* 424 */       stringBuilder.append(paramString);
/* 425 */       stringBuilder.append(arrayOfChar[b]);
/*     */     } 
/* 427 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharArray with(char... paramVarArgs) {
/* 432 */     return new CharArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\CharArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */