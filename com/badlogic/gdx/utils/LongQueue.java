/*     */ package com.badlogic.gdx.utils;
/*     */ 
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
/*     */ public class LongQueue
/*     */ {
/*     */   protected long[] values;
/*  29 */   protected int head = 0;
/*     */ 
/*     */ 
/*     */   
/*  33 */   protected int tail = 0;
/*     */ 
/*     */   
/*  36 */   public int size = 0;
/*     */ 
/*     */   
/*     */   public LongQueue() {
/*  40 */     this(16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LongQueue(int paramInt) {
/*  46 */     this.values = new long[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLast(long paramLong) {
/*  51 */     long[] arrayOfLong = this.values;
/*     */     
/*  53 */     if (this.size == arrayOfLong.length) {
/*  54 */       resize(arrayOfLong.length << 1);
/*  55 */       arrayOfLong = this.values;
/*     */     } 
/*     */     
/*  58 */     arrayOfLong[this.tail++] = paramLong;
/*  59 */     if (this.tail == arrayOfLong.length) {
/*  60 */       this.tail = 0;
/*     */     }
/*  62 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(long paramLong) {
/*  68 */     long[] arrayOfLong = this.values;
/*     */     
/*  70 */     if (this.size == arrayOfLong.length) {
/*  71 */       resize(arrayOfLong.length << 1);
/*  72 */       arrayOfLong = this.values;
/*     */     } 
/*     */     
/*  75 */     int i = this.head;
/*  76 */     i--;
/*  77 */     if (i == -1) {
/*  78 */       i = arrayOfLong.length - 1;
/*     */     }
/*  80 */     arrayOfLong[i] = paramLong;
/*     */     
/*  82 */     this.head = i;
/*  83 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/*  89 */     paramInt = this.size + paramInt;
/*  90 */     if (this.values.length < paramInt) {
/*  91 */       resize(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void resize(int paramInt) {
/*  97 */     long[] arrayOfLong2 = this.values;
/*  98 */     int i = this.head;
/*  99 */     int j = this.tail;
/*     */     
/* 101 */     long[] arrayOfLong1 = new long[paramInt];
/* 102 */     if (i < j) {
/*     */       
/* 104 */       System.arraycopy(arrayOfLong2, i, arrayOfLong1, 0, j - i);
/* 105 */     } else if (this.size > 0) {
/*     */       
/* 107 */       int k = arrayOfLong2.length - i;
/* 108 */       System.arraycopy(arrayOfLong2, i, arrayOfLong1, 0, k);
/* 109 */       System.arraycopy(arrayOfLong2, 0, arrayOfLong1, k, j);
/*     */     } 
/* 111 */     this.values = arrayOfLong1;
/* 112 */     this.head = 0;
/* 113 */     this.tail = this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long removeFirst() {
/* 120 */     if (this.size == 0)
/*     */     {
/* 122 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 127 */     long arrayOfLong[], l = (arrayOfLong = this.values)[this.head];
/* 128 */     this.head++;
/* 129 */     if (this.head == arrayOfLong.length) {
/* 130 */       this.head = 0;
/*     */     }
/* 132 */     this.size--;
/*     */     
/* 134 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long removeLast() {
/* 142 */     if (this.size == 0) {
/* 143 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/*     */     
/* 146 */     long[] arrayOfLong = this.values;
/* 147 */     int i = this.tail;
/* 148 */     i--;
/* 149 */     if (i == -1) {
/* 150 */       i = arrayOfLong.length - 1;
/*     */     }
/* 152 */     long l = arrayOfLong[i];
/* 153 */     this.tail = i;
/* 154 */     this.size--;
/*     */     
/* 156 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(long paramLong) {
/* 162 */     if (this.size == 0) return -1; 
/* 163 */     long[] arrayOfLong = this.values;
/* 164 */     int i = this.head, j = this.tail;
/* 165 */     if (i < j)
/* 166 */     { for (int k = i; k < j; k++) {
/* 167 */         if (arrayOfLong[k] == paramLong) return k - i; 
/*     */       }  }
/* 169 */     else { int k; int m; for (k = i, m = arrayOfLong.length; k < m; k++) {
/* 170 */         if (arrayOfLong[k] == paramLong) return k - i; 
/* 171 */       }  for (k = 0; k < j; k++) {
/* 172 */         if (arrayOfLong[k] == paramLong) return k + arrayOfLong.length - i; 
/*     */       }  }
/* 174 */      return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeValue(long paramLong) {
/*     */     int i;
/* 181 */     if ((i = indexOf(paramLong)) == -1) return false; 
/* 182 */     removeIndex(i);
/* 183 */     return true;
/*     */   }
/*     */   
/*     */   public long removeIndex(int paramInt) {
/*     */     long l;
/* 188 */     if (paramInt < 0) throw new IndexOutOfBoundsException("index can't be < 0: " + paramInt); 
/* 189 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 191 */     long[] arrayOfLong = this.values;
/* 192 */     int i = this.head, j = this.tail;
/* 193 */     paramInt += i;
/*     */     
/* 195 */     if (i < j) {
/* 196 */       l = arrayOfLong[paramInt];
/* 197 */       System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, j - paramInt);
/* 198 */       this.tail--;
/* 199 */     } else if (paramInt >= arrayOfLong.length) {
/* 200 */       paramInt -= arrayOfLong.length;
/* 201 */       l = arrayOfLong[paramInt];
/* 202 */       System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, j - paramInt);
/* 203 */       this.tail--;
/*     */     } else {
/* 205 */       l = arrayOfLong[paramInt];
/* 206 */       System.arraycopy(arrayOfLong, i, arrayOfLong, i + 1, paramInt - i);
/* 207 */       this.head++;
/* 208 */       if (this.head == arrayOfLong.length) {
/* 209 */         this.head = 0;
/*     */       }
/*     */     } 
/* 212 */     this.size--;
/* 213 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 218 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 223 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long first() {
/* 231 */     if (this.size == 0)
/*     */     {
/* 233 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/* 235 */     return this.values[this.head];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long last() {
/* 243 */     if (this.size == 0)
/*     */     {
/* 245 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/* 247 */     long[] arrayOfLong = this.values;
/* 248 */     int i = this.tail;
/* 249 */     i--;
/* 250 */     if (i == -1) {
/* 251 */       i = arrayOfLong.length - 1;
/*     */     }
/* 253 */     return arrayOfLong[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long get(int paramInt) {
/* 260 */     if (paramInt < 0) throw new IndexOutOfBoundsException("index can't be < 0: " + paramInt); 
/* 261 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 262 */     long[] arrayOfLong = this.values;
/*     */ 
/*     */     
/* 265 */     if ((paramInt = this.head + paramInt) >= arrayOfLong.length) {
/* 266 */       paramInt -= arrayOfLong.length;
/*     */     }
/* 268 */     return arrayOfLong[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 273 */     if (this.size == 0)
/*     */       return; 
/* 275 */     this.head = 0;
/* 276 */     this.tail = 0;
/* 277 */     this.size = 0;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 281 */     if (this.size == 0) {
/* 282 */       return "[]";
/*     */     }
/* 284 */     long[] arrayOfLong = this.values;
/* 285 */     int i = this.head;
/* 286 */     int j = this.tail;
/*     */     
/*     */     StringBuilder stringBuilder;
/* 289 */     (stringBuilder = new StringBuilder(64)).append('[');
/* 290 */     stringBuilder.append(arrayOfLong[i]);
/* 291 */     for (i = (i + 1) % arrayOfLong.length; i != j; i = (i + 1) % arrayOfLong.length) {
/* 292 */       stringBuilder.append(", ").append(arrayOfLong[i]);
/*     */     }
/* 294 */     stringBuilder.append(']');
/* 295 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 299 */     if (this.size == 0) return ""; 
/* 300 */     long[] arrayOfLong = this.values;
/* 301 */     int i = this.head;
/* 302 */     int j = this.tail;
/*     */     
/*     */     StringBuilder stringBuilder;
/* 305 */     (stringBuilder = new StringBuilder(64)).append(arrayOfLong[i]);
/* 306 */     for (i = (i + 1) % arrayOfLong.length; i != j; i = (i + 1) % arrayOfLong.length)
/* 307 */       stringBuilder.append(paramString).append(arrayOfLong[i]); 
/* 308 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 312 */     int i = this.size;
/*     */     long[] arrayOfLong;
/* 314 */     int j = (arrayOfLong = this.values).length;
/* 315 */     int k = this.head;
/*     */     
/* 317 */     int m = i + 1;
/* 318 */     for (byte b = 0; b < i; b++) {
/* 319 */       long l = arrayOfLong[k];
/*     */       
/* 321 */       m += (int)(l ^ l >>> 32L) * 31;
/*     */       
/* 323 */       k++;
/* 324 */       if (k == j) k = 0;
/*     */     
/*     */     } 
/* 327 */     return m;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 331 */     if (this == paramObject) return true; 
/* 332 */     if (paramObject == null || !(paramObject instanceof LongQueue)) return false;
/*     */     
/* 334 */     paramObject = paramObject;
/* 335 */     int j = this.size;
/*     */     
/* 337 */     if (((LongQueue)paramObject).size != j) return false;
/*     */     
/*     */     long[] arrayOfLong1;
/* 340 */     int k = (arrayOfLong1 = this.values).length;
/*     */     long[] arrayOfLong2;
/* 342 */     int m = (arrayOfLong2 = ((LongQueue)paramObject).values).length;
/*     */     
/* 344 */     int n = this.head;
/* 345 */     int i = ((LongQueue)paramObject).head;
/* 346 */     for (byte b = 0; b < j; b++) {
/* 347 */       if (arrayOfLong1[n] != arrayOfLong2[i]) return false; 
/* 348 */       n++;
/* 349 */       i++;
/* 350 */       if (n == k) n = 0; 
/* 351 */       if (i == m) i = 0; 
/*     */     } 
/* 353 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\LongQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */