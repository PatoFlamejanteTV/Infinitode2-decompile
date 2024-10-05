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
/*     */ public class ByteArray
/*     */ {
/*     */   public byte[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   
/*     */   public ByteArray() {
/*  33 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteArray(int paramInt) {
/*  38 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArray(boolean paramBoolean, int paramInt) {
/*  45 */     this.ordered = paramBoolean;
/*  46 */     this.items = new byte[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArray(ByteArray paramByteArray) {
/*  53 */     this.ordered = paramByteArray.ordered;
/*  54 */     this.size = paramByteArray.size;
/*  55 */     this.items = new byte[this.size];
/*  56 */     System.arraycopy(paramByteArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArray(byte[] paramArrayOfbyte) {
/*  62 */     this(true, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArray(boolean paramBoolean, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  70 */     this(paramBoolean, paramInt2);
/*  71 */     this.size = paramInt2;
/*  72 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.items, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public void add(byte paramByte) {
/*  76 */     byte[] arrayOfByte = this.items;
/*  77 */     if (this.size == arrayOfByte.length) arrayOfByte = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  78 */     arrayOfByte[this.size++] = paramByte;
/*     */   }
/*     */   
/*     */   public void add(byte paramByte1, byte paramByte2) {
/*  82 */     byte[] arrayOfByte = this.items;
/*  83 */     if (this.size + 1 >= arrayOfByte.length) arrayOfByte = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  84 */     arrayOfByte[this.size] = paramByte1;
/*  85 */     arrayOfByte[this.size + 1] = paramByte2;
/*  86 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(byte paramByte1, byte paramByte2, byte paramByte3) {
/*  90 */     byte[] arrayOfByte = this.items;
/*  91 */     if (this.size + 2 >= arrayOfByte.length) arrayOfByte = resize(Math.max(8, (int)(this.size * 1.75F))); 
/*  92 */     arrayOfByte[this.size] = paramByte1;
/*  93 */     arrayOfByte[this.size + 1] = paramByte2;
/*  94 */     arrayOfByte[this.size + 2] = paramByte3;
/*  95 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
/*  99 */     byte[] arrayOfByte = this.items;
/* 100 */     if (this.size + 3 >= arrayOfByte.length) arrayOfByte = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 101 */     arrayOfByte[this.size] = paramByte1;
/* 102 */     arrayOfByte[this.size + 1] = paramByte2;
/* 103 */     arrayOfByte[this.size + 2] = paramByte3;
/* 104 */     arrayOfByte[this.size + 3] = paramByte4;
/* 105 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(ByteArray paramByteArray) {
/* 109 */     addAll(paramByteArray.items, 0, paramByteArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(ByteArray paramByteArray, int paramInt1, int paramInt2) {
/* 113 */     if (paramInt1 + paramInt2 > paramByteArray.size)
/* 114 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramByteArray.size); 
/* 115 */     addAll(paramByteArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(byte... paramVarArgs) {
/* 119 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 123 */     byte[] arrayOfByte = this.items;
/*     */     int i;
/* 125 */     if ((i = this.size + paramInt2) > arrayOfByte.length) arrayOfByte = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 126 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, this.size, paramInt2);
/* 127 */     this.size += paramInt2;
/*     */   }
/*     */   
/*     */   public byte get(int paramInt) {
/* 131 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 132 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, byte paramByte) {
/* 136 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 137 */     this.items[paramInt] = paramByte;
/*     */   }
/*     */   
/*     */   public void incr(int paramInt, byte paramByte) {
/* 141 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 142 */     this.items[paramInt] = (byte)(this.items[paramInt] + paramByte);
/*     */   }
/*     */   
/*     */   public void incr(byte paramByte) {
/* 146 */     byte[] arrayOfByte = this.items; byte b; int i;
/* 147 */     for (b = 0, i = this.size; b < i; b++)
/* 148 */       arrayOfByte[b] = (byte)(arrayOfByte[b] + paramByte); 
/*     */   }
/*     */   
/*     */   public void mul(int paramInt, byte paramByte) {
/* 152 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 153 */     this.items[paramInt] = (byte)(this.items[paramInt] * paramByte);
/*     */   }
/*     */   
/*     */   public void mul(byte paramByte) {
/* 157 */     byte[] arrayOfByte = this.items; byte b; int i;
/* 158 */     for (b = 0, i = this.size; b < i; b++)
/* 159 */       arrayOfByte[b] = (byte)(arrayOfByte[b] * paramByte); 
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, byte paramByte) {
/* 163 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 164 */     byte[] arrayOfByte = this.items;
/* 165 */     if (this.size == arrayOfByte.length) arrayOfByte = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 166 */     if (this.ordered) {
/* 167 */       System.arraycopy(arrayOfByte, paramInt, arrayOfByte, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 169 */       arrayOfByte[this.size] = arrayOfByte[paramInt];
/* 170 */     }  this.size++;
/* 171 */     arrayOfByte[paramInt] = paramByte;
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
/* 188 */     byte arrayOfByte[], b = (arrayOfByte = this.items)[paramInt1];
/* 189 */     arrayOfByte[paramInt1] = arrayOfByte[paramInt2];
/* 190 */     arrayOfByte[paramInt2] = b;
/*     */   }
/*     */   
/*     */   public boolean contains(byte paramByte) {
/* 194 */     int i = this.size - 1;
/* 195 */     byte[] arrayOfByte = this.items;
/* 196 */     while (i >= 0) {
/* 197 */       if (arrayOfByte[i--] == paramByte) return true; 
/* 198 */     }  return false;
/*     */   }
/*     */   
/*     */   public int indexOf(byte paramByte) {
/* 202 */     byte[] arrayOfByte = this.items; byte b; int i;
/* 203 */     for (b = 0, i = this.size; b < i; b++) {
/* 204 */       if (arrayOfByte[b] == paramByte) return b; 
/* 205 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int lastIndexOf(byte paramByte) {
/* 209 */     byte[] arrayOfByte = this.items;
/* 210 */     for (int i = this.size - 1; i >= 0; i--) {
/* 211 */       if (arrayOfByte[i] == paramByte) return i; 
/* 212 */     }  return -1;
/*     */   }
/*     */   
/*     */   public boolean removeValue(byte paramByte) {
/* 216 */     byte[] arrayOfByte = this.items; byte b; int i;
/* 217 */     for (b = 0, i = this.size; b < i; b++) {
/* 218 */       if (arrayOfByte[b] == paramByte) {
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
/* 230 */     byte arrayOfByte[], b = (arrayOfByte = this.items)[paramInt];
/* 231 */     this.size--;
/* 232 */     if (this.ordered) {
/* 233 */       System.arraycopy(arrayOfByte, paramInt + 1, arrayOfByte, paramInt, this.size - paramInt);
/*     */     } else {
/* 235 */       arrayOfByte[paramInt] = arrayOfByte[this.size];
/* 236 */     }  return b;
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
/*     */   public boolean removeAll(ByteArray paramByteArray) {
/* 258 */     int i = this.size, j = i;
/* 259 */     byte[] arrayOfByte = this.items; byte b; int k;
/* 260 */     for (b = 0, k = paramByteArray.size; b < k; b++) {
/* 261 */       byte b1 = paramByteArray.get(b);
/* 262 */       for (byte b2 = 0; b2 < i; b2++) {
/* 263 */         if (b1 == arrayOfByte[b2]) {
/* 264 */           removeIndex(b2);
/* 265 */           i--;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 270 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte pop() {
/* 275 */     return this.items[--this.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public byte peek() {
/* 280 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public byte first() {
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
/*     */   public byte[] shrink() {
/* 307 */     if (this.items.length != this.size) resize(this.size); 
/* 308 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] ensureCapacity(int paramInt) {
/* 315 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 317 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 318 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] setSize(int paramInt) {
/* 324 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 325 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 326 */     this.size = paramInt;
/* 327 */     return this.items;
/*     */   }
/*     */   
/*     */   protected byte[] resize(int paramInt) {
/* 331 */     byte[] arrayOfByte1 = new byte[paramInt];
/*     */     byte[] arrayOfByte2;
/* 333 */     System.arraycopy(arrayOfByte2 = this.items, 0, arrayOfByte1, 0, Math.min(this.size, paramInt));
/* 334 */     this.items = arrayOfByte1;
/* 335 */     return arrayOfByte1;
/*     */   }
/*     */   
/*     */   public void sort() {
/* 339 */     Arrays.sort(this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 343 */     byte[] arrayOfByte = this.items; byte b; int i, j;
/* 344 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 345 */       int k = i - b;
/* 346 */       byte b1 = arrayOfByte[b];
/* 347 */       arrayOfByte[b] = arrayOfByte[k];
/* 348 */       arrayOfByte[k] = b1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 353 */     byte[] arrayOfByte = this.items;
/* 354 */     for (int i = this.size - 1; i >= 0; i--) {
/* 355 */       int j = MathUtils.random(i);
/* 356 */       byte b = arrayOfByte[i];
/* 357 */       arrayOfByte[i] = arrayOfByte[j];
/* 358 */       arrayOfByte[j] = b;
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
/*     */   public byte random() {
/* 370 */     if (this.size == 0) return 0; 
/* 371 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */   
/*     */   public byte[] toArray() {
/* 375 */     byte[] arrayOfByte = new byte[this.size];
/* 376 */     System.arraycopy(this.items, 0, arrayOfByte, 0, this.size);
/* 377 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (!this.ordered) return super.hashCode(); 
/* 382 */     byte[] arrayOfByte = this.items;
/* 383 */     int i = 1; byte b; int j;
/* 384 */     for (b = 0, j = this.size; b < j; b++)
/* 385 */       i = i * 31 + arrayOfByte[b]; 
/* 386 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 391 */     if (paramObject == this) return true; 
/* 392 */     if (!this.ordered) return false; 
/* 393 */     if (!(paramObject instanceof ByteArray)) return false;
/*     */     
/* 395 */     if (!((ByteArray)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 397 */     if ((i = this.size) != ((ByteArray)paramObject).size) return false; 
/* 398 */     byte[] arrayOfByte = this.items; paramObject = ((ByteArray)paramObject).items;
/* 399 */     for (byte b = 0; b < i; b++) {
/* 400 */       if (arrayOfByte[b] != paramObject[b]) return false; 
/* 401 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 405 */     if (this.size == 0) return "[]"; 
/* 406 */     byte[] arrayOfByte = this.items;
/*     */     StringBuilder stringBuilder;
/* 408 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 409 */     stringBuilder.append(arrayOfByte[0]);
/* 410 */     for (byte b = 1; b < this.size; b++) {
/* 411 */       stringBuilder.append(", ");
/* 412 */       stringBuilder.append(arrayOfByte[b]);
/*     */     } 
/* 414 */     stringBuilder.append(']');
/* 415 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 419 */     if (this.size == 0) return ""; 
/* 420 */     byte[] arrayOfByte = this.items;
/*     */     StringBuilder stringBuilder;
/* 422 */     (stringBuilder = new StringBuilder(32)).append(arrayOfByte[0]);
/* 423 */     for (byte b = 1; b < this.size; b++) {
/* 424 */       stringBuilder.append(paramString);
/* 425 */       stringBuilder.append(arrayOfByte[b]);
/*     */     } 
/* 427 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static ByteArray with(byte... paramVarArgs) {
/* 432 */     return new ByteArray(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ByteArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */