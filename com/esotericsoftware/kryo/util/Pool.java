/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
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
/*     */ public abstract class Pool<T>
/*     */ {
/*     */   private final Queue<T> freeObjects;
/*     */   private int peak;
/*     */   
/*     */   public Pool(boolean paramBoolean1, boolean paramBoolean2) {
/*  40 */     this(paramBoolean1, paramBoolean2, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pool(boolean paramBoolean1, boolean paramBoolean2, final int maximumCapacity) {
/*     */     ArrayDeque<T> arrayDeque;
/*  47 */     if (paramBoolean1) {
/*  48 */       LinkedBlockingQueue<T> linkedBlockingQueue = new LinkedBlockingQueue<T>(maximumCapacity)
/*     */         {
/*     */           public boolean add(T param1T) {
/*  51 */             return offer((E)param1T);
/*     */           }
/*     */         };
/*  54 */     } else if (paramBoolean2) {
/*  55 */       LinkedList<T> linkedList = new LinkedList<T>() {
/*     */           public boolean add(T param1T) {
/*  57 */             if (size() >= maximumCapacity) return false; 
/*  58 */             super.add(param1T);
/*  59 */             return true;
/*     */           }
/*     */         };
/*     */     } else {
/*  63 */       arrayDeque = new ArrayDeque<T>() {
/*     */           public boolean offer(T param1T) {
/*  65 */             if (size() >= maximumCapacity) return false; 
/*  66 */             super.offer(param1T);
/*  67 */             return true;
/*     */           }
/*     */         };
/*     */     } 
/*  71 */     this.freeObjects = paramBoolean2 ? new SoftReferenceQueue<>((Queue)arrayDeque) : arrayDeque;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract T create();
/*     */ 
/*     */   
/*     */   public T obtain() {
/*     */     T t;
/*  80 */     return ((t = this.freeObjects.poll()) != null) ? t : create();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free(T paramT) {
/*  89 */     if (paramT == null) throw new IllegalArgumentException("object cannot be null."); 
/*  90 */     reset(paramT);
/*  91 */     if (!this.freeObjects.offer(paramT) && this.freeObjects instanceof SoftReferenceQueue) {
/*  92 */       ((SoftReferenceQueue)this.freeObjects).cleanOne();
/*  93 */       this.freeObjects.offer(paramT);
/*     */     } 
/*  95 */     this.peak = Math.max(this.peak, this.freeObjects.size());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void reset(T paramT) {
/* 101 */     if (paramT instanceof Poolable) ((Poolable)paramT).reset();
/*     */   
/*     */   }
/*     */   
/*     */   public void clear() {
/* 106 */     this.freeObjects.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clean() {
/* 114 */     if (this.freeObjects instanceof SoftReferenceQueue) ((SoftReferenceQueue)this.freeObjects).clean();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFree() {
/* 122 */     return this.freeObjects.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPeak() {
/* 130 */     return this.peak;
/*     */   }
/*     */   
/*     */   public void resetPeak() {
/* 134 */     this.peak = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface Poolable
/*     */   {
/*     */     void reset();
/*     */   }
/*     */   
/*     */   static class SoftReferenceQueue<T>
/*     */     implements Queue<T>
/*     */   {
/*     */     private final Queue<SoftReference<T>> delegate;
/*     */     
/*     */     public SoftReferenceQueue(Queue<SoftReference<T>> param1Queue) {
/* 149 */       this.delegate = param1Queue;
/*     */     }
/*     */     
/*     */     public T poll() {
/*     */       while (true) {
/*     */         SoftReference<SoftReference> softReference;
/* 155 */         if ((softReference = (SoftReference)this.delegate.poll()) == null) return null;
/*     */         
/* 157 */         if ((softReference = softReference.get()) != null) return (T)softReference; 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean offer(T param1T) {
/* 162 */       return this.delegate.add(new SoftReference<>(param1T));
/*     */     }
/*     */     
/*     */     public int size() {
/* 166 */       return this.delegate.size();
/*     */     }
/*     */     
/*     */     public void clear() {
/* 170 */       this.delegate.clear();
/*     */     }
/*     */     
/*     */     void cleanOne() {
/* 174 */       for (Iterator<SoftReference<T>> iterator = this.delegate.iterator(); iterator.hasNext();) {
/* 175 */         if (((SoftReference)iterator.next()).get() == null) {
/* 176 */           iterator.remove();
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     void clean() {
/* 183 */       this.delegate.removeIf(param1SoftReference -> (param1SoftReference.get() == null));
/*     */     }
/*     */     
/*     */     public boolean add(T param1T) {
/* 187 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 191 */       return false;
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 195 */       return false;
/*     */     }
/*     */     
/*     */     public Iterator<T> iterator() {
/* 199 */       return null;
/*     */     }
/*     */     
/*     */     public T remove() {
/* 203 */       return null;
/*     */     }
/*     */     
/*     */     public Object[] toArray() {
/* 207 */       return null;
/*     */     }
/*     */     
/*     */     public T element() {
/* 211 */       return null;
/*     */     }
/*     */     
/*     */     public T peek() {
/* 215 */       return null;
/*     */     }
/*     */     
/*     */     public <E> E[] toArray(E[] param1ArrayOfE) {
/* 219 */       return null;
/*     */     }
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 223 */       return false;
/*     */     }
/*     */     
/*     */     public boolean containsAll(Collection param1Collection) {
/* 227 */       return false;
/*     */     }
/*     */     
/*     */     public boolean addAll(Collection<? extends T> param1Collection) {
/* 231 */       return false;
/*     */     }
/*     */     
/*     */     public boolean removeAll(Collection param1Collection) {
/* 235 */       return false;
/*     */     }
/*     */     
/*     */     public boolean retainAll(Collection param1Collection) {
/* 239 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\Pool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */