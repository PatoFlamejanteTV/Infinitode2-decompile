/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
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
/*     */ public class Array<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   public T[] items;
/*     */   public int size;
/*     */   public boolean ordered;
/*     */   private transient ArrayIterable<T> iterable;
/*     */   private transient Predicate.PredicateIterable<T> predicateIterable;
/*     */   
/*     */   public Array() {
/*  43 */     this(true, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array(int paramInt) {
/*  48 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array(boolean paramBoolean, int paramInt) {
/*  55 */     this.ordered = paramBoolean;
/*  56 */     this.items = (T[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array(boolean paramBoolean, int paramInt, Class paramClass) {
/*  64 */     this.ordered = paramBoolean;
/*  65 */     this.items = (T[])ArrayReflection.newInstance(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array(Class paramClass) {
/*  70 */     this(true, 16, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array(Array<? extends T> paramArray) {
/*  77 */     this(paramArray.ordered, paramArray.size, paramArray.items.getClass().getComponentType());
/*  78 */     this.size = paramArray.size;
/*  79 */     System.arraycopy(paramArray.items, 0, this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array(T[] paramArrayOfT) {
/*  86 */     this(true, paramArrayOfT, 0, paramArrayOfT.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array(boolean paramBoolean, T[] paramArrayOfT, int paramInt1, int paramInt2) {
/*  94 */     this(paramBoolean, paramInt2, paramArrayOfT.getClass().getComponentType());
/*  95 */     this.size = paramInt2;
/*  96 */     System.arraycopy(paramArrayOfT, paramInt1, this.items, 0, this.size);
/*     */   }
/*     */   
/*     */   public void add(T paramT) {
/* 100 */     T[] arrayOfT = this.items;
/* 101 */     if (this.size == arrayOfT.length) arrayOfT = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 102 */     arrayOfT[this.size++] = paramT;
/*     */   }
/*     */   
/*     */   public void add(T paramT1, T paramT2) {
/* 106 */     T[] arrayOfT = this.items;
/* 107 */     if (this.size + 1 >= arrayOfT.length) arrayOfT = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 108 */     arrayOfT[this.size] = paramT1;
/* 109 */     arrayOfT[this.size + 1] = paramT2;
/* 110 */     this.size += 2;
/*     */   }
/*     */   
/*     */   public void add(T paramT1, T paramT2, T paramT3) {
/* 114 */     T[] arrayOfT = this.items;
/* 115 */     if (this.size + 2 >= arrayOfT.length) arrayOfT = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 116 */     arrayOfT[this.size] = paramT1;
/* 117 */     arrayOfT[this.size + 1] = paramT2;
/* 118 */     arrayOfT[this.size + 2] = paramT3;
/* 119 */     this.size += 3;
/*     */   }
/*     */   
/*     */   public void add(T paramT1, T paramT2, T paramT3, T paramT4) {
/* 123 */     T[] arrayOfT = this.items;
/* 124 */     if (this.size + 3 >= arrayOfT.length) arrayOfT = resize(Math.max(8, (int)(this.size * 1.8F))); 
/* 125 */     arrayOfT[this.size] = paramT1;
/* 126 */     arrayOfT[this.size + 1] = paramT2;
/* 127 */     arrayOfT[this.size + 2] = paramT3;
/* 128 */     arrayOfT[this.size + 3] = paramT4;
/* 129 */     this.size += 4;
/*     */   }
/*     */   
/*     */   public void addAll(Array<? extends T> paramArray) {
/* 133 */     addAll(paramArray.items, 0, paramArray.size);
/*     */   }
/*     */   
/*     */   public void addAll(Array<? extends T> paramArray, int paramInt1, int paramInt2) {
/* 137 */     if (paramInt1 + paramInt2 > paramArray.size)
/* 138 */       throw new IllegalArgumentException("start + count must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArray.size); 
/* 139 */     addAll(paramArray.items, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void addAll(T... paramVarArgs) {
/* 143 */     addAll(paramVarArgs, 0, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   public void addAll(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 147 */     T[] arrayOfT = this.items;
/*     */     int i;
/* 149 */     if ((i = this.size + paramInt2) > arrayOfT.length) arrayOfT = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 150 */     System.arraycopy(paramArrayOfT, paramInt1, arrayOfT, this.size, paramInt2);
/* 151 */     this.size = i;
/*     */   }
/*     */   
/*     */   public T get(int paramInt) {
/* 155 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 156 */     return this.items[paramInt];
/*     */   }
/*     */   
/*     */   public void set(int paramInt, T paramT) {
/* 160 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 161 */     this.items[paramInt] = paramT;
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, T paramT) {
/* 165 */     if (paramInt > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size); 
/* 166 */     T[] arrayOfT = this.items;
/* 167 */     if (this.size == arrayOfT.length) arrayOfT = resize(Math.max(8, (int)(this.size * 1.75F))); 
/* 168 */     if (this.ordered) {
/* 169 */       System.arraycopy(arrayOfT, paramInt, arrayOfT, paramInt + 1, this.size - paramInt);
/*     */     } else {
/* 171 */       arrayOfT[this.size] = arrayOfT[paramInt];
/* 172 */     }  this.size++;
/* 173 */     arrayOfT[paramInt] = paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 179 */     if (paramInt1 > this.size) throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size); 
/*     */     int i;
/* 181 */     if ((i = this.size + paramInt2) > this.items.length) this.items = resize(Math.max(Math.max(8, i), (int)(this.size * 1.75F))); 
/* 182 */     System.arraycopy(this.items, paramInt1, this.items, paramInt1 + paramInt2, this.size - paramInt1);
/* 183 */     this.size = i;
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 187 */     if (paramInt1 >= this.size) throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size); 
/* 188 */     if (paramInt2 >= this.size) throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
/*     */     
/* 190 */     T arrayOfT[], t = (arrayOfT = this.items)[paramInt1];
/* 191 */     arrayOfT[paramInt1] = arrayOfT[paramInt2];
/* 192 */     arrayOfT[paramInt2] = t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(@Null T paramT, boolean paramBoolean) {
/* 199 */     T[] arrayOfT = this.items;
/* 200 */     int i = this.size - 1;
/* 201 */     if (paramBoolean || paramT == null)
/* 202 */     { while (i >= 0) {
/* 203 */         if (arrayOfT[i--] == paramT) return true; 
/*     */       }  }
/* 205 */     else { while (i >= 0) {
/* 206 */         if (paramT.equals(arrayOfT[i--])) return true; 
/*     */       }  }
/* 208 */      return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Array<? extends T> paramArray, boolean paramBoolean) {
/* 215 */     T[] arrayOfT = paramArray.items; int i; byte b;
/* 216 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 217 */       if (!contains(arrayOfT[b], paramBoolean)) return false; 
/* 218 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAny(Array<? extends T> paramArray, boolean paramBoolean) {
/* 225 */     T[] arrayOfT = paramArray.items; int i; byte b;
/* 226 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 227 */       if (contains(arrayOfT[b], paramBoolean)) return true; 
/* 228 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(@Null T paramT, boolean paramBoolean) {
/* 236 */     T[] arrayOfT = this.items;
/* 237 */     if (paramBoolean || paramT == null)
/* 238 */     { int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 239 */         if (arrayOfT[paramBoolean] == paramT) return paramBoolean; 
/*     */       }  }
/* 241 */     else { int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 242 */         if (paramT.equals(arrayOfT[paramBoolean])) return paramBoolean; 
/*     */       }  }
/* 244 */      return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastIndexOf(@Null T paramT, boolean paramBoolean) {
/* 253 */     T[] arrayOfT = this.items;
/* 254 */     if (paramBoolean || paramT == null)
/* 255 */     { for (int i = this.size - 1; i >= 0; i--) {
/* 256 */         if (arrayOfT[i] == paramT) return i; 
/*     */       }  }
/* 258 */     else { for (int i = this.size - 1; i >= 0; i--) {
/* 259 */         if (paramT.equals(arrayOfT[i])) return i; 
/*     */       }  }
/* 261 */      return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeValue(@Null T paramT, boolean paramBoolean) {
/* 269 */     T[] arrayOfT = this.items;
/* 270 */     if (paramBoolean || paramT == null) {
/* 271 */       int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 272 */         if (arrayOfT[paramBoolean] == paramT) {
/* 273 */           removeIndex(paramBoolean);
/* 274 */           return true;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 278 */       int i; for (paramBoolean = false, i = this.size; paramBoolean < i; paramBoolean++) {
/* 279 */         if (paramT.equals(arrayOfT[paramBoolean])) {
/* 280 */           removeIndex(paramBoolean);
/* 281 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 285 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public T removeIndex(int paramInt) {
/* 290 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 292 */     T arrayOfT[], t = (arrayOfT = this.items)[paramInt];
/* 293 */     this.size--;
/* 294 */     if (this.ordered) {
/* 295 */       System.arraycopy(arrayOfT, paramInt + 1, arrayOfT, paramInt, this.size - paramInt);
/*     */     } else {
/* 297 */       arrayOfT[paramInt] = arrayOfT[this.size];
/* 298 */     }  arrayOfT[this.size] = null;
/* 299 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 304 */     int i = this.size;
/* 305 */     if (paramInt2 >= i) throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size); 
/* 306 */     if (paramInt1 > paramInt2) throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2); 
/* 307 */     T[] arrayOfT = this.items;
/* 308 */     int j = paramInt2 - paramInt1 + 1, k = i - j;
/* 309 */     if (this.ordered) {
/* 310 */       System.arraycopy(arrayOfT, paramInt1 + j, arrayOfT, paramInt1, i - paramInt1 + j);
/*     */     } else {
/* 312 */       paramInt2 = Math.max(k, paramInt2 + 1);
/* 313 */       System.arraycopy(arrayOfT, paramInt2, arrayOfT, paramInt1, i - paramInt2);
/*     */     } 
/* 315 */     for (paramInt2 = k; paramInt2 < i; paramInt2++)
/* 316 */       arrayOfT[paramInt2] = null; 
/* 317 */     this.size = k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Array<? extends T> paramArray, boolean paramBoolean) {
/* 325 */     int i = this.size, j = i;
/* 326 */     T[] arrayOfT = this.items;
/* 327 */     if (paramBoolean) {
/* 328 */       int k; for (paramBoolean = false, k = paramArray.size; paramBoolean < k; paramBoolean++) {
/* 329 */         T t = paramArray.get(paramBoolean);
/* 330 */         for (byte b = 0; b < i; b++) {
/* 331 */           if (t == arrayOfT[b]) {
/* 332 */             removeIndex(b);
/* 333 */             i--; break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       int k;
/* 339 */       for (paramBoolean = false, k = paramArray.size; paramBoolean < k; paramBoolean++) {
/* 340 */         T t = paramArray.get(paramBoolean);
/* 341 */         for (byte b = 0; b < i; b++) {
/* 342 */           if (t.equals(arrayOfT[b])) {
/* 343 */             removeIndex(b);
/* 344 */             i--;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 350 */     return (i != j);
/*     */   }
/*     */ 
/*     */   
/*     */   public T pop() {
/* 355 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 356 */     this.size--;
/* 357 */     T t = this.items[this.size];
/* 358 */     this.items[this.size] = null;
/* 359 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public T peek() {
/* 364 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 365 */     return this.items[this.size - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public T first() {
/* 370 */     if (this.size == 0) throw new IllegalStateException("Array is empty."); 
/* 371 */     return this.items[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 376 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 381 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 385 */     Arrays.fill((Object[])this.items, 0, this.size, (Object)null);
/* 386 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] shrink() {
/* 393 */     if (this.items.length != this.size) resize(this.size); 
/* 394 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] ensureCapacity(int paramInt) {
/* 401 */     if (paramInt < 0) throw new IllegalArgumentException("additionalCapacity must be >= 0: " + paramInt);
/*     */     
/* 403 */     if ((paramInt = this.size + paramInt) > this.items.length) resize(Math.max(Math.max(8, paramInt), (int)(this.size * 1.75F))); 
/* 404 */     return this.items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] setSize(int paramInt) {
/* 410 */     truncate(paramInt);
/* 411 */     if (paramInt > this.items.length) resize(Math.max(8, paramInt)); 
/* 412 */     this.size = paramInt;
/* 413 */     return this.items;
/*     */   }
/*     */ 
/*     */   
/*     */   protected T[] resize(int paramInt) {
/*     */     T[] arrayOfT;
/* 419 */     Object[] arrayOfObject = (Object[])ArrayReflection.newInstance((arrayOfT = this.items).getClass().getComponentType(), paramInt);
/* 420 */     System.arraycopy(arrayOfT, 0, arrayOfObject, 0, Math.min(this.size, arrayOfObject.length));
/* 421 */     this.items = (T[])arrayOfObject;
/* 422 */     return (T[])arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort() {
/* 428 */     Sort.instance().sort((Object[])this.items, 0, this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sort(Comparator<? super T> paramComparator) {
/* 433 */     Sort.instance().sort(this.items, paramComparator, 0, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T selectRanked(Comparator<T> paramComparator, int paramInt) {
/* 444 */     if (paramInt <= 0) {
/* 445 */       throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
/*     */     }
/* 447 */     return Select.instance().select(this.items, paramComparator, paramInt, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int selectRankedIndex(Comparator<T> paramComparator, int paramInt) {
/* 456 */     if (paramInt <= 0) {
/* 457 */       throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
/*     */     }
/* 459 */     return Select.instance().selectIndex(this.items, paramComparator, paramInt, this.size);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 463 */     T[] arrayOfT = this.items; byte b; int i, j;
/* 464 */     for (b = 0, i = this.size - 1, j = this.size / 2; b < j; b++) {
/* 465 */       int k = i - b;
/* 466 */       T t = arrayOfT[b];
/* 467 */       arrayOfT[b] = arrayOfT[k];
/* 468 */       arrayOfT[k] = t;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 473 */     T[] arrayOfT = this.items;
/* 474 */     for (int i = this.size - 1; i >= 0; i--) {
/* 475 */       int j = MathUtils.random(i);
/* 476 */       T t = arrayOfT[i];
/* 477 */       arrayOfT[i] = arrayOfT[j];
/* 478 */       arrayOfT[j] = t;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayIterator<T> iterator() {
/* 487 */     if (Collections.allocateIterators) return new ArrayIterator<>(this, true); 
/* 488 */     if (this.iterable == null) this.iterable = new ArrayIterable<>(this); 
/* 489 */     return this.iterable.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<T> select(Predicate<T> paramPredicate) {
/* 497 */     if (Collections.allocateIterators) return new Predicate.PredicateIterable<>(this, paramPredicate); 
/* 498 */     if (this.predicateIterable == null) {
/* 499 */       this.predicateIterable = new Predicate.PredicateIterable<>(this, paramPredicate);
/*     */     } else {
/* 501 */       this.predicateIterable.set(this, paramPredicate);
/* 502 */     }  return this.predicateIterable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(int paramInt) {
/* 508 */     if (paramInt < 0) throw new IllegalArgumentException("newSize must be >= 0: " + paramInt); 
/* 509 */     if (this.size <= paramInt)
/* 510 */       return;  for (int i = paramInt; i < this.size; i++)
/* 511 */       this.items[i] = null; 
/* 512 */     this.size = paramInt;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T random() {
/* 517 */     if (this.size == 0) return null; 
/* 518 */     return this.items[MathUtils.random(0, this.size - 1)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] toArray() {
/* 524 */     return toArray((Class)this.items.getClass().getComponentType());
/*     */   }
/*     */   
/*     */   public <V> V[] toArray(Class<V> paramClass) {
/* 528 */     Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(paramClass, this.size);
/* 529 */     System.arraycopy(this.items, 0, arrayOfObject, 0, this.size);
/* 530 */     return (V[])arrayOfObject;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 534 */     if (!this.ordered) return super.hashCode(); 
/* 535 */     T[] arrayOfT = this.items;
/* 536 */     int i = 1; byte b; int j;
/* 537 */     for (b = 0, j = this.size; b < j; b++) {
/* 538 */       i *= 31;
/*     */       T t;
/* 540 */       if ((t = arrayOfT[b]) != null) i += t.hashCode(); 
/*     */     } 
/* 542 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 547 */     if (paramObject == this) return true; 
/* 548 */     if (!this.ordered) return false; 
/* 549 */     if (!(paramObject instanceof Array)) return false;
/*     */     
/* 551 */     if (!((Array)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 553 */     if ((i = this.size) != ((Array)paramObject).size) return false; 
/* 554 */     T[] arrayOfT = this.items; paramObject = ((Array)paramObject).items;
/* 555 */     for (byte b = 0; b < i; ) {
/* 556 */       T t = arrayOfT[b]; Object object = paramObject[b];
/* 557 */       if ((t == null) ? (object == null) : t.equals(object)) { b++; continue; }  return false;
/*     */     } 
/* 559 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(Object paramObject) {
/* 564 */     if (paramObject == this) return true; 
/* 565 */     if (!this.ordered) return false; 
/* 566 */     if (!(paramObject instanceof Array)) return false;
/*     */     
/* 568 */     if (!((Array)(paramObject = paramObject)).ordered) return false; 
/*     */     int i;
/* 570 */     if ((i = this.size) != ((Array)paramObject).size) return false; 
/* 571 */     T[] arrayOfT = this.items; paramObject = ((Array)paramObject).items;
/* 572 */     for (byte b = 0; b < i; b++) {
/* 573 */       if (arrayOfT[b] != paramObject[b]) return false; 
/* 574 */     }  return true;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 578 */     if (this.size == 0) return "[]"; 
/* 579 */     T[] arrayOfT = this.items;
/*     */     StringBuilder stringBuilder;
/* 581 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 582 */     stringBuilder.append(arrayOfT[0]);
/* 583 */     for (byte b = 1; b < this.size; b++) {
/* 584 */       stringBuilder.append(", ");
/* 585 */       stringBuilder.append(arrayOfT[b]);
/*     */     } 
/* 587 */     stringBuilder.append(']');
/* 588 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 592 */     if (this.size == 0) return ""; 
/* 593 */     T[] arrayOfT = this.items;
/*     */     StringBuilder stringBuilder;
/* 595 */     (stringBuilder = new StringBuilder(32)).append(arrayOfT[0]);
/* 596 */     for (byte b = 1; b < this.size; b++) {
/* 597 */       stringBuilder.append(paramString);
/* 598 */       stringBuilder.append(arrayOfT[b]);
/*     */     } 
/* 600 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> Array<T> of(Class<T> paramClass) {
/* 605 */     return new Array<>(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> Array<T> of(boolean paramBoolean, int paramInt, Class<T> paramClass) {
/* 610 */     return new Array<>(paramBoolean, paramInt, paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> Array<T> with(T... paramVarArgs) {
/* 615 */     return new Array<>(paramVarArgs);
/*     */   }
/*     */   
/*     */   public static class ArrayIterator<T>
/*     */     implements Iterable<T>, Iterator<T>
/*     */   {
/*     */     private final Array<T> array;
/*     */     private final boolean allowRemove;
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public ArrayIterator(Array<T> param1Array) {
/* 627 */       this(param1Array, true);
/*     */     }
/*     */     
/*     */     public ArrayIterator(Array<T> param1Array, boolean param1Boolean) {
/* 631 */       this.array = param1Array;
/* 632 */       this.allowRemove = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 636 */       if (!this.valid)
/*     */       {
/* 638 */         throw new GdxRuntimeException("#iterator() cannot be used nested.");
/*     */       }
/* 640 */       return (this.index < this.array.size);
/*     */     }
/*     */     
/*     */     public T next() {
/* 644 */       if (this.index >= this.array.size) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 645 */       if (!this.valid)
/*     */       {
/* 647 */         throw new GdxRuntimeException("#iterator() cannot be used nested.");
/*     */       }
/* 649 */       return this.array.items[this.index++];
/*     */     }
/*     */     
/*     */     public void remove() {
/* 653 */       if (!this.allowRemove) throw new GdxRuntimeException("Remove not allowed."); 
/* 654 */       this.index--;
/* 655 */       this.array.removeIndex(this.index);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 659 */       this.index = 0;
/*     */     }
/*     */     
/*     */     public ArrayIterator<T> iterator() {
/* 663 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ArrayIterable<T>
/*     */     implements Iterable<T> {
/*     */     private final Array<T> array;
/*     */     private final boolean allowRemove;
/*     */     private transient Array.ArrayIterator<T> iterator1;
/*     */     private transient Array.ArrayIterator<T> iterator2;
/*     */     
/*     */     public ArrayIterable(Array<T> param1Array) {
/* 675 */       this(param1Array, true);
/*     */     }
/*     */     
/*     */     public ArrayIterable(Array<T> param1Array, boolean param1Boolean) {
/* 679 */       this.array = param1Array;
/* 680 */       this.allowRemove = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public Array.ArrayIterator<T> iterator() {
/* 685 */       if (Collections.allocateIterators) return new Array.ArrayIterator<>(this.array, this.allowRemove);
/*     */ 
/*     */       
/* 688 */       if (this.iterator1 == null) {
/* 689 */         this.iterator1 = new Array.ArrayIterator<>(this.array, this.allowRemove);
/* 690 */         this.iterator2 = new Array.ArrayIterator<>(this.array, this.allowRemove);
/*     */       } 
/*     */ 
/*     */       
/* 694 */       if (!this.iterator1.valid) {
/* 695 */         this.iterator1.index = 0;
/* 696 */         this.iterator1.valid = true;
/* 697 */         this.iterator2.valid = false;
/* 698 */         return this.iterator1;
/*     */       } 
/* 700 */       this.iterator2.index = 0;
/* 701 */       this.iterator2.valid = true;
/* 702 */       this.iterator1.valid = false;
/* 703 */       return this.iterator2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Array.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */