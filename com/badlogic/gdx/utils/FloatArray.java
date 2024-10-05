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
/*     */ public class FloatArray
/*     */ {
/*     */   public float[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public FloatArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new float[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatArray(FloatArray paramFloatArray) {
/*  53 */     this.ordered = paramFloatArray.ordered;
/*  54 */     this.size = paramFloatArray.size;
/*  55 */     this.items = new float[this.size];
/*  56 */     System.arraycopy(paramFloatArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatArray(float[] paramArrayOffloat) {
/*  62 */     this(true, paramArrayOffloat, 0, paramArrayOffloat.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatArray(boolean paramBoolean, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOffloat, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(float paramFloat) {
/*  76 */     float[] arrayOfFloat = this.items;
/*  77 */     if (this.size == arrayOfFloat.length) arrayOfFloat = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  78 */     arrayOfFloat[this.size++] = paramFloat;
/*     */   }
/*     */   
/*     */   public void add(float paramFloat1, float paramFloat2) {
/*  82 */     float[] arrayOfFloat = this.items;
/*  83 */     if (this.size + 1 >= arrayOfFloat.length) arrayOfFloat = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  84 */     arrayOfFloat[this.size] = paramFloat1;
/*  85 */     arrayOfFloat[this.size + 1] = paramFloat2;
/*  86 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  90 */     float[] arrayOfFloat = this.items;
/*  91 */     if (this.size + 2 >= arrayOfFloat.length) arrayOfFloat = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  92 */     arrayOfFloat[this.size] = paramFloat1;
/*  93 */     arrayOfFloat[this.size + 1] = paramFloat2;
/*  94 */     arrayOfFloat[this.size + 2] = paramFloat3;
/*  95 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  99 */     float[] arrayOfFloat = this.items;
/* 100 */     if (this.size + 3 >= arrayOfFloat.length) arrayOfFloat = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 101 */     arrayOfFloat[this.size] = paramFloat1;
/* 102 */     arrayOfFloat[this.size + 1] = paramFloat2;
/* 103 */     arrayOfFloat[this.size + 2] = paramFloat3;
/* 104 */     arrayOfFloat[this.size + 3] = paramFloat4;
/* 105 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(FloatArray paramFloatArray) {
/* 109 */     addAll(paramFloatArray.items, 0, paramFloatArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(FloatArray paramFloatArray, int paramInt1, int paramInt2) {
/* 113 */     if (paramInt1 + paramInt2 > paramFloatArray.size)
/* 114 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramFloatArray.size); 
/* 115 */     addAll(paramFloatArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(float... paramVarArgs) {
/* 119 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 123 */     float[] arrayOfFloat = this.items;
/*     */     int i;
/* 125 */     if ((i = this.size + paramInt2) > arrayOfFloat.length) arrayOfFloat = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 126 */     System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, this.size, paramInt2);
/* 127 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public float get(int paramInt) {
/* 131 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 132 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, float paramFloat) {
/* 136 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 137 */     this.items[paramInt] = paramFloat;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt, float paramFloat) {
/* 141 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 142 */     this.items[paramInt] = this.items[paramInt] + paramFloat;
/*     */   }
/*     */   
/*     */   public void incr(float paramFloat) {
/* 146 */     float[] arrayOfFloat = this.items; byte b; int i;
/* 147 */     for (b = 0, i = this.size; b < i; b++)
/* 148 */       arrayOfFloat[b] = arrayOfFloat[b] + paramFloat; 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt, float paramFloat) {
/* 152 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 153 */     this.items[paramInt] = this.items[paramInt] * paramFloat;
/*     */   }
/*     */   
/*     */   public void mul(float paramFloat) {
/* 157 */     float[] arrayOfFloat = this.items; byte b; int i;
/* 158 */     for (b = 0, i = this.size; b < i; b++)
/* 159 */       arrayOfFloat[b] = arrayOfFloat[b] * paramFloat; 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, float paramFloat) {
/* 163 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 164 */     float[] arrayOfFloat = this.items;
/* 165 */     if (this.size == arrayOfFloat.length) arrayOfFloat = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 166 */     if (this.ordered) {
/* 167 */       System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 169 */       arrayOfFloat[this.size] = arrayOfFloat[paramInt];
/* 170 */     }  this.size++;
/* 171 */     arrayOfFloat[paramInt] = paramFloat;
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
/* 188 */     float arrayOfFloat[], f = (arrayOfFloat = this.items)[paramInt1];
/* 189 */     arrayOfFloat[paramInt1] = arrayOfFloat[paramInt2];
/* 190 */     arrayOfFloat[paramInt2] = f;
/*     */   }
/*     */   
/*     */   public boolean contains(float paramFloat) {
/* 194 */     int i = this.size - 1;
/* 195 */     float[] arrayOfFloat = this.items;
/* 196 */     while (i >= 0) {
/* 197 */       if (arrayOfFloat[i--] == paramFloat) return true; 
/* 198 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(float paramFloat) {
/* 202 */     float[] arrayOfFloat = this.items; byte b; int i;
/* 203 */     for (b = 0, i = this.size; b < i; b++) {
/* 204 */       if (arrayOfFloat[b] == paramFloat) return b; 
/* 205 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(float paramFloat) {
/* 209 */     float[] arrayOfFloat = this.items;
/* 210 */     for (int i = this.size - 1; i >= 0; i--) {
/* 211 */       if (arrayOfFloat[i] == paramFloat) return i; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(float paramFloat) {
/* 216 */     float[] arrayOfFloat = this.items; byte b; int i;
/* 217 */     for (b = 0, i = this.size; b < i; b++) {
/* 218 */       if (arrayOfFloat[b] == paramFloat) {
/* 219 */         removeIndex(b);
/* 220 */         return true;
/*     */       } 
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float removeIndex(int paramInt) {
/* 228 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 230 */     float arrayOfFloat[], f = (arrayOfFloat = this.items)[paramInt];
/* 231 */     this.size--;
/* 232 */     if (this.ordered) {
/* 233 */       System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, this.size - paramInt);
/*     */     } else {
/* 235 */       arrayOfFloat[paramInt] = arrayOfFloat[this.size];
/* 236 */     }  return f;
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
/*     */   public boolean removeAll(FloatArray paramFloatArray) {
/* 258 */     int i = this.size, j = i;
/* 259 */     float[] arrayOfFloat = this.items; byte b; int k;
/* 260 */     for (b = 0, k = paramFloatArray.size; b < k; b++) {
/* 261 */       float f = paramFloatArray.get(b);
/* 262 */       for (byte b1 = 0; b1 < i; b1++) {
/* 263 */         if (f == arrayOfFloat[b1]) {
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
/*     */   public float pop() {
/* 275 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public float peek() {
/* 280 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public float first() {
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
/*     */   public float[] shrink() {
/* 307 */     if (this.items.length != this.size) resize(this.size); 
/* 308 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] ensureCapacity(int paramInt) {
/* 315 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 317 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 318 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] setSize(int paramInt) {
/* 324 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 325 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 326 */     this.size = paramInt;
/* 327 */     return this.items;
/*     */   }
/*     */   
/*     */   protected float[] resize(int paramInt) {
/* 331 */     float[] arrayOfFloat1 = new float[paramInt];
/*     */     float[] arrayOfFloat2;
/* 333 */     System.arraycopy(arrayOfFloat2 = this.items, 0, arrayOfFloat1, 0, Math.min(this.size, paramInt));
/* 334 */     this.items = arrayOfFloat1;
/* 335 */     return arrayOfFloat1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 339 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 343 */     float[] arrayOfFloat = this.items; byte b; int i, j;
/* 344 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 345 */       int k = i - b;
/* 346 */       float f = arrayOfFloat[b];
/* 347 */       arrayOfFloat[b] = arrayOfFloat[k];
/* 348 */       arrayOfFloat[k] = f;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 353 */     float[] arrayOfFloat = this.items;
/* 354 */     for (int i = this.size - 1; i >= 0; i--) {
/* 355 */       int j = MathUtils.random(i);
/* 356 */       float f = arrayOfFloat[i];
/* 357 */       arrayOfFloat[i] = arrayOfFloat[j];
/* 358 */       arrayOfFloat[j] = f;
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
/*     */   public float random() {
/* 370 */     if (this.size == 0) return 0.0F; 
/* 371 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public float[] toArray() {
/* 375 */     float[] arrayOfFloat = new float[this.size];
/* 376 */     System.arraycopy(this.items, 0, arrayOfFloat, 0, this.size);
/* 377 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (!this.ordered) return super.hashCode(); 
/* 382 */     float[] arrayOfFloat = this.items;
/* 383 */     int i = 1; byte b; int j;
/* 384 */     for (b = 0, j = this.size; b < j; b++)
/* 385 */       i = i * 31 + NumberUtils.floatToRawIntBits(arrayOfFloat[b]); 
/* 386 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 391 */     if (paramObject == this) return true; 
/* 392 */     if (!this.ordered) return false; 
/* 393 */     if (!(paramObject instanceof FloatArray)) return false;
/*     */     
/* 395 */     if (!((FloatArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 397 */     if ((i = this.size) != ((FloatArray)paramObject).size) return false; 
/* 398 */     float[] arrayOfFloat = this.items; paramObject = ((FloatArray)paramObject).items;
/* 399 */     for (byte b = 0; b < i; b++) {
/* 400 */       if (arrayOfFloat[b] != paramObject[b]) return false; 
/* 401 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject, float paramFloat) {
/* 406 */     if (paramObject == this) return true; 
/* 407 */     if (!(paramObject instanceof FloatArray)) return false; 
/* 408 */     paramObject = paramObject;
/*     */     int i;
/* 410 */     if ((i = this.size) != ((FloatArray)paramObject).size) return false; 
/* 411 */     if (!this.ordered) return false; 
/* 412 */     if (!((FloatArray)paramObject).ordered) return false; 
/* 413 */     float[] arrayOfFloat = this.items; paramObject = ((FloatArray)paramObject).items;
/* 414 */     for (byte b = 0; b < i; b++) {
/* 415 */       if (Math.abs(arrayOfFloat[b] - paramObject[b]) > paramFloat) return false; 
/* 416 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 420 */     if (this.size == 0) return "[]"; 
/* 421 */     float[] arrayOfFloat = this.items;
/*     */     StringBuilder stringBuilder;
/* 423 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 424 */     stringBuilder.append(arrayOfFloat[0]);
/* 425 */     for (byte b = 1; b < this.size; b++) {
/* 426 */       stringBuilder.append(", ");
/* 427 */       stringBuilder.append(arrayOfFloat[b]);
/*     */     } 
/* 429 */     stringBuilder.append(']');
/* 430 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 434 */     if (this.size == 0) return ""; 
/* 435 */     float[] arrayOfFloat = this.items;
/*     */     StringBuilder stringBuilder;
/* 437 */     (stringBuilder = new StringBuilder(32)).append(arrayOfFloat[0]);
/* 438 */     for (byte b = 1; b < this.size; b++) {
/* 439 */       stringBuilder.append(paramString);
/* 440 */       stringBuilder.append(arrayOfFloat[b]);
/*     */     } 
/* 442 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static FloatArray with(float... paramVarArgs) {
/* 447 */     return new FloatArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\FloatArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */