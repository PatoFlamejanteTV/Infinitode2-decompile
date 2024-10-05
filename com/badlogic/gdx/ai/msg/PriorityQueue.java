/*     */ package com.badlogic.gdx.ai.msg;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
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
/*     */ public class PriorityQueue<E extends Comparable<E>>
/*     */ {
/*     */   private static final int DEFAULT_INITIAL_CAPACITY = 11;
/*     */   private static final double CAPACITY_RATIO_LOW = 1.5D;
/*     */   private static final double CAPACITY_RATIO_HI = 2.0D;
/*     */   private Object[] queue;
/*     */   private ObjectSet<E> set;
/*     */   private boolean uniqueness;
/*  71 */   private int size = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public PriorityQueue() {
/*  76 */     this(11);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PriorityQueue(int paramInt) {
/*  84 */     this.queue = new Object[paramInt];
/*  85 */     this.set = new ObjectSet(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getUniqueness() {
/*  90 */     return this.uniqueness;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUniqueness(boolean paramBoolean) {
/*  95 */     this.uniqueness = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 106 */     if (paramE == null) throw new IllegalArgumentException("Element cannot be null."); 
/* 107 */     if (this.uniqueness && !this.set.add(paramE)) return false; 
/*     */     int i;
/* 109 */     if ((i = this.size) >= this.queue.length) growToSize(i + 1); 
/* 110 */     this.size = i + 1;
/* 111 */     if (i == 0) {
/* 112 */       this.queue[0] = paramE;
/*     */     } else {
/* 114 */       siftUp(i, paramE);
/* 115 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E peek() {
/* 123 */     return (E)((this.size == 0) ? null : (Comparable)this.queue[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/* 133 */     return (E)((paramInt >= this.size) ? null : (Comparable)this.queue[paramInt]);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 138 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 143 */     for (byte b = 0; b < this.size; b++)
/* 144 */       this.queue[b] = null; 
/* 145 */     this.size = 0;
/* 146 */     this.set.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E poll() {
/* 154 */     if (this.size == 0) return null; 
/* 155 */     int i = --this.size;
/* 156 */     Comparable comparable1 = (Comparable)this.queue[0];
/* 157 */     Comparable comparable2 = (Comparable)this.queue[i];
/* 158 */     this.queue[i] = null;
/* 159 */     if (i != 0) siftDown(0, (E)comparable2); 
/* 160 */     if (this.uniqueness) this.set.remove(comparable1); 
/* 161 */     return (E)comparable1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void siftUp(int paramInt, E paramE) {
/* 171 */     while (paramInt > 0) {
/* 172 */       int i = paramInt - 1 >>> 1;
/* 173 */       Comparable comparable = (Comparable)this.queue[i];
/* 174 */       if (paramE.compareTo(comparable) < 0) {
/* 175 */         this.queue[paramInt] = comparable;
/* 176 */         paramInt = i;
/*     */       } 
/* 178 */     }  this.queue[paramInt] = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void siftDown(int paramInt, E paramE) {
/* 188 */     int i = this.size >>> 1;
/* 189 */     while (paramInt < i) {
/* 190 */       int j = (paramInt << 1) + 1;
/* 191 */       Comparable<Comparable> comparable = (Comparable)this.queue[j];
/*     */       int k;
/* 193 */       if ((k = j + 1) < this.size && comparable.compareTo((Comparable)this.queue[k]) > 0) comparable = (Comparable<Comparable>)this.queue[j = k]; 
/* 194 */       if (paramE.compareTo(comparable) > 0) {
/* 195 */         this.queue[paramInt] = comparable;
/* 196 */         paramInt = j;
/*     */       } 
/* 198 */     }  this.queue[paramInt] = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void growToSize(int paramInt) {
/* 205 */     if (paramInt < 0) {
/* 206 */       throw new GdxRuntimeException("Capacity upper limit exceeded.");
/*     */     }
/*     */     
/*     */     int i;
/* 210 */     if ((i = (int)(((i = this.queue.length) < 64) ? ((i + 1) * 2.0D) : (i * 1.5D))) < 0)
/* 211 */       i = Integer.MAX_VALUE; 
/* 212 */     if (i < paramInt) i = paramInt; 
/* 213 */     Object[] arrayOfObject = new Object[i];
/* 214 */     System.arraycopy(this.queue, 0, arrayOfObject, 0, this.size);
/* 215 */     this.queue = arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\msg\PriorityQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */