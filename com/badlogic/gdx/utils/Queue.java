/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
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
/*     */ public class Queue<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   protected T[] values;
/*  32 */   protected int head = 0;
/*     */ 
/*     */ 
/*     */   
/*  36 */   protected int tail = 0;
/*     */ 
/*     */   
/*  39 */   public int size = 0;
/*     */   
/*     */   private transient QueueIterable iterable;
/*     */ 
/*     */   
/*     */   public Queue() {
/*  45 */     this(16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue(int paramInt) {
/*  51 */     this.values = (T[])new Object[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue(int paramInt, Class<T> paramClass) {
/*  58 */     this.values = (T[])ArrayReflection.newInstance(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLast(@Null T paramT) {
/*  64 */     T[] arrayOfT = this.values;
/*     */     
/*  66 */     if (this.size == arrayOfT.length) {
/*  67 */       resize(arrayOfT.length << 1);
/*  68 */       arrayOfT = this.values;
/*     */     } 
/*     */     
/*  71 */     arrayOfT[this.tail++] = paramT;
/*  72 */     if (this.tail == arrayOfT.length) {
/*  73 */       this.tail = 0;
/*     */     }
/*  75 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(@Null T paramT) {
/*  82 */     T[] arrayOfT = this.values;
/*     */     
/*  84 */     if (this.size == arrayOfT.length) {
/*  85 */       resize(arrayOfT.length << 1);
/*  86 */       arrayOfT = this.values;
/*     */     } 
/*     */     
/*  89 */     int i = this.head;
/*  90 */     i--;
/*  91 */     if (i == -1) {
/*  92 */       i = arrayOfT.length - 1;
/*     */     }
/*  94 */     arrayOfT[i] = paramT;
/*     */     
/*  96 */     this.head = i;
/*  97 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 103 */     paramInt = this.size + paramInt;
/* 104 */     if (this.values.length < paramInt) {
/* 105 */       resize(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void resize(int paramInt) {
/* 111 */     T[] arrayOfT = this.values;
/* 112 */     int i = this.head;
/* 113 */     int j = this.tail;
/*     */     
/* 115 */     Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(arrayOfT.getClass().getComponentType(), paramInt);
/* 116 */     if (i < j) {
/*     */       
/* 118 */       System.arraycopy(arrayOfT, i, arrayOfObject, 0, j - i);
/* 119 */     } else if (this.size > 0) {
/*     */       
/* 121 */       int k = arrayOfT.length - i;
/* 122 */       System.arraycopy(arrayOfT, i, arrayOfObject, 0, k);
/* 123 */       System.arraycopy(arrayOfT, 0, arrayOfObject, k, j);
/*     */     } 
/* 125 */     this.values = (T[])arrayOfObject;
/* 126 */     this.head = 0;
/* 127 */     this.tail = this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T removeFirst() {
/* 134 */     if (this.size == 0)
/*     */     {
/* 136 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 141 */     T arrayOfT[], t = (arrayOfT = this.values)[this.head];
/* 142 */     arrayOfT[this.head] = null;
/* 143 */     this.head++;
/* 144 */     if (this.head == arrayOfT.length) {
/* 145 */       this.head = 0;
/*     */     }
/* 147 */     this.size--;
/*     */     
/* 149 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T removeLast() {
/* 157 */     if (this.size == 0) {
/* 158 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/*     */     
/* 161 */     T[] arrayOfT = this.values;
/* 162 */     int i = this.tail;
/* 163 */     i--;
/* 164 */     if (i == -1) {
/* 165 */       i = arrayOfT.length - 1;
/*     */     }
/* 167 */     T t = arrayOfT[i];
/* 168 */     arrayOfT[i] = null;
/* 169 */     this.tail = i;
/* 170 */     this.size--;
/*     */     
/* 172 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(T paramT, boolean paramBoolean) {
/* 179 */     if (this.size == 0) return -1; 
/* 180 */     T[] arrayOfT = this.values;
/* 181 */     int i = this.head, j = this.tail;
/* 182 */     if (paramBoolean || paramT == null)
/* 183 */     { if (i < j)
/* 184 */       { for (int k = i; k < j; k++) {
/* 185 */           if (arrayOfT[k] == paramT) return k - i; 
/*     */         }  }
/* 187 */       else { int k; int m; for (k = i, m = arrayOfT.length; k < m; k++) {
/* 188 */           if (arrayOfT[k] == paramT) return k - i; 
/* 189 */         }  for (k = 0; k < j; k++) {
/* 190 */           if (arrayOfT[k] == paramT) return k + arrayOfT.length - i; 
/*     */         }  }
/*     */        }
/* 193 */     else if (i < j)
/* 194 */     { for (int k = i; k < j; k++) {
/* 195 */         if (paramT.equals(arrayOfT[k])) return k - i; 
/*     */       }  }
/* 197 */     else { int k; int m; for (k = i, m = arrayOfT.length; k < m; k++) {
/* 198 */         if (paramT.equals(arrayOfT[k])) return k - i; 
/* 199 */       }  for (k = 0; k < j; k++) {
/* 200 */         if (paramT.equals(arrayOfT[k])) return k + arrayOfT.length - i; 
/*     */       }  }
/*     */     
/* 203 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeValue(T paramT, boolean paramBoolean) {
/*     */     int i;
/* 211 */     if ((i = indexOf(paramT, paramBoolean)) == -1) return false; 
/* 212 */     removeIndex(i);
/* 213 */     return true;
/*     */   }
/*     */   
/*     */   public T removeIndex(int paramInt) {
/*     */     T t;
/* 218 */     if (paramInt < 0) throw new IndexOutOfBoundsException("index can't be < 0: " + paramInt); 
/* 219 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
/*     */     
/* 221 */     T[] arrayOfT = this.values;
/* 222 */     int i = this.head, j = this.tail;
/* 223 */     paramInt += i;
/*     */     
/* 225 */     if (i < j) {
/* 226 */       t = arrayOfT[paramInt];
/* 227 */       System.arraycopy(arrayOfT, paramInt + 1, arrayOfT, paramInt, j - paramInt);
/* 228 */       arrayOfT[j] = null;
/* 229 */       this.tail--;
/* 230 */     } else if (paramInt >= arrayOfT.length) {
/* 231 */       paramInt -= arrayOfT.length;
/* 232 */       t = arrayOfT[paramInt];
/* 233 */       System.arraycopy(arrayOfT, paramInt + 1, arrayOfT, paramInt, j - paramInt);
/* 234 */       this.tail--;
/*     */     } else {
/* 236 */       t = arrayOfT[paramInt];
/* 237 */       System.arraycopy(arrayOfT, i, arrayOfT, i + 1, paramInt - i);
/* 238 */       arrayOfT[i] = null;
/* 239 */       this.head++;
/* 240 */       if (this.head == arrayOfT.length) {
/* 241 */         this.head = 0;
/*     */       }
/*     */     } 
/* 244 */     this.size--;
/* 245 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 250 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 255 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T first() {
/* 263 */     if (this.size == 0)
/*     */     {
/* 265 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/* 267 */     return this.values[this.head];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T last() {
/* 275 */     if (this.size == 0)
/*     */     {
/* 277 */       throw new NoSuchElementException("Queue is empty.");
/*     */     }
/* 279 */     T[] arrayOfT = this.values;
/* 280 */     int i = this.tail;
/* 281 */     i--;
/* 282 */     if (i == -1) {
/* 283 */       i = arrayOfT.length - 1;
/*     */     }
/* 285 */     return arrayOfT[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(int paramInt) {
/* 292 */     if (paramInt < 0) throw new IndexOutOfBoundsException("index can't be < 0: " + paramInt); 
/* 293 */     if (paramInt >= this.size) throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size); 
/* 294 */     T[] arrayOfT = this.values;
/*     */ 
/*     */     
/* 297 */     if ((paramInt = this.head + paramInt) >= arrayOfT.length) {
/* 298 */       paramInt -= arrayOfT.length;
/*     */     }
/* 300 */     return arrayOfT[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 306 */     if (this.size == 0)
/* 307 */       return;  T[] arrayOfT = this.values;
/* 308 */     int i = this.head;
/* 309 */     int j = this.tail;
/*     */     
/* 311 */     if (i < j) {
/*     */       
/* 313 */       for (i = i; i < j; i++) {
/* 314 */         arrayOfT[i] = null;
/*     */       }
/*     */     } else {
/*     */       
/* 318 */       for (i = i; i < arrayOfT.length; i++) {
/* 319 */         arrayOfT[i] = null;
/*     */       }
/* 321 */       for (i = 0; i < j; i++) {
/* 322 */         arrayOfT[i] = null;
/*     */       }
/*     */     } 
/* 325 */     this.head = 0;
/* 326 */     this.tail = 0;
/* 327 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 335 */     if (Collections.allocateIterators) return new QueueIterator<>(this, true); 
/* 336 */     if (this.iterable == null) this.iterable = new QueueIterable(this); 
/* 337 */     return this.iterable.iterator();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 341 */     if (this.size == 0) {
/* 342 */       return "[]";
/*     */     }
/* 344 */     T[] arrayOfT = this.values;
/* 345 */     int i = this.head;
/* 346 */     int j = this.tail;
/*     */     
/*     */     StringBuilder stringBuilder;
/* 349 */     (stringBuilder = new StringBuilder(64)).append('[');
/* 350 */     stringBuilder.append(arrayOfT[i]);
/* 351 */     for (i = (i + 1) % arrayOfT.length; i != j; i = (i + 1) % arrayOfT.length) {
/* 352 */       stringBuilder.append(", ").append(arrayOfT[i]);
/*     */     }
/* 354 */     stringBuilder.append(']');
/* 355 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 359 */     if (this.size == 0) return ""; 
/* 360 */     T[] arrayOfT = this.values;
/* 361 */     int i = this.head;
/* 362 */     int j = this.tail;
/*     */     
/*     */     StringBuilder stringBuilder;
/* 365 */     (stringBuilder = new StringBuilder(64)).append(arrayOfT[i]);
/* 366 */     for (i = (i + 1) % arrayOfT.length; i != j; i = (i + 1) % arrayOfT.length)
/* 367 */       stringBuilder.append(paramString).append(arrayOfT[i]); 
/* 368 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 372 */     int i = this.size;
/*     */     T[] arrayOfT;
/* 374 */     int j = (arrayOfT = this.values).length;
/* 375 */     int k = this.head;
/*     */     
/* 377 */     int m = i + 1;
/* 378 */     for (byte b = 0; b < i; b++) {
/* 379 */       T t = arrayOfT[k];
/*     */       
/* 381 */       m *= 31;
/* 382 */       if (t != null) m += t.hashCode();
/*     */       
/* 384 */       k++;
/* 385 */       if (k == j) k = 0;
/*     */     
/*     */     } 
/* 388 */     return m;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 392 */     if (this == paramObject) return true; 
/* 393 */     if (paramObject == null || !(paramObject instanceof Queue)) return false;
/*     */     
/* 395 */     paramObject = paramObject;
/* 396 */     int j = this.size;
/*     */     
/* 398 */     if (((Queue)paramObject).size != j) return false;
/*     */     
/*     */     T[] arrayOfT1;
/* 401 */     int k = (arrayOfT1 = this.values).length;
/*     */     T[] arrayOfT2;
/* 403 */     int m = (arrayOfT2 = ((Queue)paramObject).values).length;
/*     */     
/* 405 */     int n = this.head;
/* 406 */     int i = ((Queue)paramObject).head;
/* 407 */     for (byte b = 0; b < j; ) {
/* 408 */       T t1 = arrayOfT1[n];
/* 409 */       T t2 = arrayOfT2[i];
/*     */       
/* 411 */       if ((t1 == null) ? (t2 == null) : t1.equals(t2)) {
/* 412 */         n++;
/* 413 */         i++;
/* 414 */         if (n == k) n = 0; 
/* 415 */         if (i == m) i = 0;  b++;
/*     */       }  return false;
/* 417 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equalsIdentity(Object paramObject) {
/* 422 */     if (this == paramObject) return true; 
/* 423 */     if (paramObject == null || !(paramObject instanceof Queue)) return false;
/*     */     
/* 425 */     paramObject = paramObject;
/* 426 */     int j = this.size;
/*     */     
/* 428 */     if (((Queue)paramObject).size != j) return false;
/*     */     
/*     */     T[] arrayOfT1;
/* 431 */     int k = (arrayOfT1 = this.values).length;
/*     */     T[] arrayOfT2;
/* 433 */     int m = (arrayOfT2 = ((Queue)paramObject).values).length;
/*     */     
/* 435 */     int n = this.head;
/* 436 */     int i = ((Queue)paramObject).head;
/* 437 */     for (byte b = 0; b < j; b++) {
/* 438 */       if (arrayOfT1[n] != arrayOfT2[i]) return false; 
/* 439 */       n++;
/* 440 */       i++;
/* 441 */       if (n == k) n = 0; 
/* 442 */       if (i == m) i = 0; 
/*     */     } 
/* 444 */     return true;
/*     */   }
/*     */   
/*     */   public static class QueueIterator<T>
/*     */     implements Iterable<T>, Iterator<T>
/*     */   {
/*     */     private final Queue<T> queue;
/*     */     private final boolean allowRemove;
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public QueueIterator(Queue<T> param1Queue) {
/* 456 */       this(param1Queue, true);
/*     */     }
/*     */     
/*     */     public QueueIterator(Queue<T> param1Queue, boolean param1Boolean) {
/* 460 */       this.queue = param1Queue;
/* 461 */       this.allowRemove = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 465 */       if (!this.valid)
/*     */       {
/* 467 */         throw new GdxRuntimeException("#iterator() cannot be used nested.");
/*     */       }
/* 469 */       return (this.index < this.queue.size);
/*     */     }
/*     */     
/*     */     public T next() {
/* 473 */       if (this.index >= this.queue.size) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 474 */       if (!this.valid)
/*     */       {
/* 476 */         throw new GdxRuntimeException("#iterator() cannot be used nested.");
/*     */       }
/* 478 */       return this.queue.get(this.index++);
/*     */     }
/*     */     
/*     */     public void remove() {
/* 482 */       if (!this.allowRemove) throw new GdxRuntimeException("Remove not allowed."); 
/* 483 */       this.index--;
/* 484 */       this.queue.removeIndex(this.index);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 488 */       this.index = 0;
/*     */     }
/*     */     
/*     */     public Iterator<T> iterator() {
/* 492 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class QueueIterable<T>
/*     */     implements Iterable<T> {
/*     */     private final Queue<T> queue;
/*     */     private final boolean allowRemove;
/*     */     private Queue.QueueIterator iterator1;
/*     */     private Queue.QueueIterator iterator2;
/*     */     
/*     */     public QueueIterable(Queue<T> param1Queue) {
/* 504 */       this(param1Queue, true);
/*     */     }
/*     */     
/*     */     public QueueIterable(Queue<T> param1Queue, boolean param1Boolean) {
/* 508 */       this.queue = param1Queue;
/* 509 */       this.allowRemove = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<T> iterator() {
/* 514 */       if (Collections.allocateIterators) return new Queue.QueueIterator<>(this.queue, this.allowRemove);
/*     */ 
/*     */       
/* 517 */       if (this.iterator1 == null) {
/* 518 */         this.iterator1 = new Queue.QueueIterator<>(this.queue, this.allowRemove);
/* 519 */         this.iterator2 = new Queue.QueueIterator<>(this.queue, this.allowRemove);
/*     */       } 
/*     */ 
/*     */       
/* 523 */       if (!this.iterator1.valid) {
/* 524 */         this.iterator1.index = 0;
/* 525 */         this.iterator1.valid = true;
/* 526 */         this.iterator2.valid = false;
/* 527 */         return this.iterator1;
/*     */       } 
/* 529 */       this.iterator2.index = 0;
/* 530 */       this.iterator2.valid = true;
/* 531 */       this.iterator1.valid = false;
/* 532 */       return this.iterator2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Queue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */