/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
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
/*     */ public class ObjectSet<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   public int size;
/*     */   T[] keyTable;
/*     */   float loadFactor;
/*     */   int threshold;
/*     */   protected int shift;
/*     */   protected int mask;
/*     */   private transient ObjectSetIterator iterator1;
/*     */   private transient ObjectSetIterator iterator2;
/*     */   
/*     */   public ObjectSet() {
/*  68 */     this(51, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet(int paramInt) {
/*  74 */     this(paramInt, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet(int paramInt, float paramFloat) {
/*  81 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F)
/*  82 */       throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + paramFloat); 
/*  83 */     this.loadFactor = paramFloat;
/*     */     
/*  85 */     paramInt = tableSize(paramInt, paramFloat);
/*  86 */     this.threshold = (int)(paramInt * paramFloat);
/*  87 */     this.mask = paramInt - 1;
/*  88 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/*     */     
/*  90 */     this.keyTable = (T[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectSet(ObjectSet<? extends T> paramObjectSet) {
/*  95 */     this((int)(paramObjectSet.keyTable.length * paramObjectSet.loadFactor), paramObjectSet.loadFactor);
/*  96 */     System.arraycopy(paramObjectSet.keyTable, 0, this.keyTable, 0, paramObjectSet.keyTable.length);
/*  97 */     this.size = paramObjectSet.size;
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
/*     */   protected int place(T paramT) {
/* 115 */     return (int)(paramT.hashCode() * -7046029254386353131L >>> this.shift);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int locateKey(T paramT) {
/* 121 */     if (paramT == null) throw new IllegalArgumentException("key cannot be null."); 
/* 122 */     T[] arrayOfT = this.keyTable;
/* 123 */     for (int i = place(paramT);; i = i + 1 & this.mask) {
/*     */       T t;
/* 125 */       if ((t = arrayOfT[i]) == null) return -(i + 1); 
/* 126 */       if (t.equals(paramT)) return i;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(T paramT) {
/*     */     int i;
/* 134 */     if ((i = locateKey(paramT)) >= 0) return false; 
/* 135 */     i = -(i + 1);
/* 136 */     this.keyTable[i] = paramT;
/* 137 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   public void addAll(Array<? extends T> paramArray) {
/* 142 */     addAll(paramArray.items, 0, paramArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(Array<? extends T> paramArray, int paramInt1, int paramInt2) {
/* 146 */     if (paramInt1 + paramInt2 > paramArray.size)
/* 147 */       throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArray.size); 
/* 148 */     addAll(paramArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean addAll(T... paramVarArgs) {
/* 152 */     return addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public boolean addAll(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 156 */     ensureCapacity(paramInt2);
/* 157 */     int i = this.size;
/* 158 */     for (int j = paramInt1; j < paramInt1; j++)
/* 159 */       add(paramArrayOfT[j]); 
/* 160 */     return (i != this.size);
/*     */   }
/*     */   
/*     */   public void addAll(ObjectSet<T> paramObjectSet) {
/* 164 */     ensureCapacity(paramObjectSet.size);
/* 165 */     T[] arrayOfT = paramObjectSet.keyTable; byte b; int i;
/* 166 */     for (b = 0, i = arrayOfT.length; b < i; b++) {
/*     */       T t;
/* 168 */       if ((t = arrayOfT[b]) != null) add(t);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addResize(T paramT) {
/* 174 */     T[] arrayOfT = this.keyTable;
/* 175 */     for (int i = place(paramT);; i = i + 1 & this.mask) {
/* 176 */       if (arrayOfT[i] == null) {
/* 177 */         arrayOfT[i] = paramT;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(T paramT) {
/*     */     int i;
/* 186 */     if ((i = locateKey(paramT)) < 0) return false; 
/* 187 */     T[] arrayOfT = this.keyTable;
/* 188 */     int j = this.mask, k = i + 1 & j;
/* 189 */     while ((paramT = arrayOfT[k]) != null) {
/* 190 */       int m = place(paramT);
/* 191 */       if ((k - m & j) > (i - m & j)) {
/* 192 */         arrayOfT[i] = paramT;
/* 193 */         i = k;
/*     */       } 
/* 195 */       k = k + 1 & j;
/*     */     } 
/* 197 */     arrayOfT[i] = null;
/* 198 */     this.size--;
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 204 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 209 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shrink(int paramInt) {
/* 216 */     if (paramInt < 0) throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt); 
/* 217 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 218 */     if (this.keyTable.length > paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/* 225 */     paramInt = tableSize(paramInt, this.loadFactor);
/* 226 */     if (this.keyTable.length <= paramInt) {
/* 227 */       clear();
/*     */       return;
/*     */     } 
/* 230 */     this.size = 0;
/* 231 */     resize(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 237 */     if (this.size == 0)
/* 238 */       return;  this.size = 0;
/* 239 */     Arrays.fill((Object[])this.keyTable, (Object)null);
/*     */   }
/*     */   
/*     */   public boolean contains(T paramT) {
/* 243 */     return (locateKey(paramT) >= 0);
/*     */   }
/*     */   @Null
/*     */   public T get(T paramT) {
/*     */     int i;
/* 248 */     return ((i = locateKey(paramT)) < 0) ? null : this.keyTable[i];
/*     */   }
/*     */   
/*     */   public T first() {
/* 252 */     T[] arrayOfT = this.keyTable; byte b; int i;
/* 253 */     for (b = 0, i = arrayOfT.length; b < i; b++) {
/* 254 */       if (arrayOfT[b] != null) return arrayOfT[b]; 
/* 255 */     }  throw new IllegalStateException("ObjectSet is empty.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 261 */     paramInt = tableSize(this.size + paramInt, this.loadFactor);
/* 262 */     if (this.keyTable.length < paramInt) resize(paramInt); 
/*     */   }
/*     */   
/*     */   private void resize(int paramInt) {
/* 266 */     int i = this.keyTable.length;
/* 267 */     this.threshold = (int)(paramInt * this.loadFactor);
/* 268 */     this.mask = paramInt - 1;
/* 269 */     this.shift = Long.numberOfLeadingZeros(this.mask);
/* 270 */     T[] arrayOfT = this.keyTable;
/*     */     
/* 272 */     this.keyTable = (T[])new Object[paramInt];
/*     */     
/* 274 */     if (this.size > 0)
/* 275 */       for (paramInt = 0; paramInt < i; paramInt++) {
/*     */         T t;
/* 277 */         if ((t = arrayOfT[paramInt]) != null) addResize(t);
/*     */       
/*     */       }  
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 283 */     int i = this.size;
/* 284 */     T[] arrayOfT = this.keyTable; byte b; int j;
/* 285 */     for (b = 0, j = arrayOfT.length; b < j; b++) {
/*     */       T t;
/* 287 */       if ((t = arrayOfT[b]) != null) i += t.hashCode(); 
/*     */     } 
/* 289 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 293 */     if (!(paramObject instanceof ObjectSet)) return false;
/*     */     
/* 295 */     if (((ObjectSet)(paramObject = paramObject)).size != this.size) return false; 
/* 296 */     T[] arrayOfT = this.keyTable; byte b; int i;
/* 297 */     for (b = 0, i = arrayOfT.length; b < i; b++) {
/* 298 */       if (arrayOfT[b] != null && !paramObject.contains(arrayOfT[b])) return false; 
/* 299 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 303 */     return "{" + toString(", ") + '}';
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 307 */     if (this.size == 0) return ""; 
/* 308 */     java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(32);
/*     */     T[] arrayOfT;
/* 310 */     int i = (arrayOfT = this.keyTable).length;
/* 311 */     while (i-- > 0) {
/*     */       T t;
/* 313 */       if ((t = arrayOfT[i]) != null) {
/* 314 */         stringBuilder.append((t == this) ? "(this)" : t); break;
/*     */       } 
/*     */     } 
/* 317 */     while (i-- > 0) {
/*     */       T t;
/* 319 */       if ((t = arrayOfT[i]) != null) {
/* 320 */         stringBuilder.append(paramString);
/* 321 */         stringBuilder.append((t == this) ? "(this)" : t);
/*     */       } 
/* 323 */     }  return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSetIterator<T> iterator() {
/* 331 */     if (Collections.allocateIterators) return new ObjectSetIterator<>(this); 
/* 332 */     if (this.iterator1 == null) {
/* 333 */       this.iterator1 = new ObjectSetIterator(this);
/* 334 */       this.iterator2 = new ObjectSetIterator(this);
/*     */     } 
/* 336 */     if (!this.iterator1.valid) {
/* 337 */       this.iterator1.reset();
/* 338 */       this.iterator1.valid = true;
/* 339 */       this.iterator2.valid = false;
/* 340 */       return this.iterator1;
/*     */     } 
/* 342 */     this.iterator2.reset();
/* 343 */     this.iterator2.valid = true;
/* 344 */     this.iterator1.valid = false;
/* 345 */     return this.iterator2;
/*     */   }
/*     */   
/*     */   public static <T> ObjectSet<T> with(T... paramVarArgs) {
/*     */     ObjectSet<T> objectSet;
/* 350 */     (objectSet = new ObjectSet<>()).addAll(paramVarArgs);
/* 351 */     return objectSet;
/*     */   }
/*     */   
/*     */   static int tableSize(int paramInt, float paramFloat) {
/* 355 */     if (paramInt < 0) throw new IllegalArgumentException("capacity must be >= 0: " + paramInt); 
/*     */     int i;
/* 357 */     if ((i = MathUtils.nextPowerOfTwo(Math.max(2, (int)Math.ceil((paramInt / paramFloat))))) > 1073741824) throw new IllegalArgumentException("The required capacity is too large: " + paramInt); 
/* 358 */     return i;
/*     */   }
/*     */   
/*     */   public static class ObjectSetIterator<K> implements Iterable<K>, Iterator<K> {
/*     */     public boolean hasNext;
/*     */     final ObjectSet<K> set;
/*     */     int nextIndex;
/*     */     int currentIndex;
/*     */     boolean valid = true;
/*     */     
/*     */     public ObjectSetIterator(ObjectSet<K> param1ObjectSet) {
/* 369 */       this.set = param1ObjectSet;
/* 370 */       reset();
/*     */     }
/*     */     
/*     */     public void reset() {
/* 374 */       this.currentIndex = -1;
/* 375 */       this.nextIndex = -1;
/* 376 */       findNextIndex();
/*     */     }
/*     */     
/*     */     private void findNextIndex() {
/* 380 */       T[] arrayOfT = this.set.keyTable;
/* 381 */       for (int i = this.set.keyTable.length; ++this.nextIndex < i;) {
/* 382 */         if (arrayOfT[this.nextIndex] != null) {
/* 383 */           this.hasNext = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 387 */       this.hasNext = false;
/*     */     }
/*     */     
/*     */     public void remove() {
/*     */       int i;
/* 392 */       if ((i = this.currentIndex) < 0) throw new IllegalStateException("next must be called before remove."); 
/* 393 */       T[] arrayOfT = this.set.keyTable;
/* 394 */       int j = this.set.mask, k = i + 1 & j;
/*     */       T t;
/* 396 */       while ((t = arrayOfT[k]) != null) {
/* 397 */         int m = this.set.place((K)t);
/* 398 */         if ((k - m & j) > (i - m & j)) {
/* 399 */           arrayOfT[i] = t;
/* 400 */           i = k;
/*     */         } 
/* 402 */         k = k + 1 & j;
/*     */       } 
/* 404 */       arrayOfT[i] = null;
/* 405 */       this.set.size--;
/* 406 */       if (i != this.currentIndex) this.nextIndex--; 
/* 407 */       this.currentIndex = -1;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 411 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 412 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 416 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 417 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 418 */       T t = this.set.keyTable[this.nextIndex];
/* 419 */       this.currentIndex = this.nextIndex;
/* 420 */       findNextIndex();
/* 421 */       return (K)t;
/*     */     }
/*     */     
/*     */     public ObjectSetIterator<K> iterator() {
/* 425 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 430 */       while (this.hasNext)
/* 431 */         param1Array.add(next()); 
/* 432 */       return param1Array;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array<K> toArray() {
/* 437 */       return toArray(new Array<>(true, this.set.size));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ObjectSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */