/*     */ package com.badlogic.gdx.utils;
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
/*     */   public final int max;
/*     */   public int peak;
/*     */   private final Array<T> freeObjects;
/*     */   
/*     */   public Pool() {
/*  32 */     this(16, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public Pool(int paramInt) {
/*  37 */     this(paramInt, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pool(int paramInt1, int paramInt2) {
/*  44 */     this.freeObjects = new Array<>(false, paramInt1);
/*  45 */     this.max = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract T newObject();
/*     */ 
/*     */   
/*     */   public T obtain() {
/*  53 */     return (this.freeObjects.size == 0) ? newObject() : this.freeObjects.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free(T paramT) {
/*  62 */     if (paramT == null) throw new IllegalArgumentException("object cannot be null."); 
/*  63 */     if (this.freeObjects.size < this.max) {
/*  64 */       this.freeObjects.add(paramT);
/*  65 */       this.peak = Math.max(this.peak, this.freeObjects.size);
/*  66 */       reset(paramT); return;
/*     */     } 
/*  68 */     discard(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fill(int paramInt) {
/*  76 */     for (byte b = 0; b < paramInt; b++) {
/*  77 */       if (this.freeObjects.size < this.max) this.freeObjects.add(newObject()); 
/*  78 */     }  this.peak = Math.max(this.peak, this.freeObjects.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void reset(T paramT) {
/*  84 */     if (paramT instanceof Poolable) ((Poolable)paramT).reset();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void discard(T paramT) {
/*  90 */     reset(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void freeAll(Array<T> paramArray) {
/*  98 */     if (paramArray == null) throw new IllegalArgumentException("objects cannot be null."); 
/*  99 */     Array<T> array = this.freeObjects;
/* 100 */     int i = this.max; byte b; int j;
/* 101 */     for (b = 0, j = paramArray.size; b < j; b++) {
/*     */       T t;
/* 103 */       if ((t = paramArray.get(b)) != null)
/* 104 */         if (array.size < i) {
/* 105 */           array.add(t);
/* 106 */           reset(t);
/*     */         } else {
/* 108 */           discard(t);
/*     */         }  
/*     */     } 
/* 111 */     this.peak = Math.max(this.peak, array.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 116 */     Array<T> array = this.freeObjects; byte b; int i;
/* 117 */     for (b = 0, i = array.size; b < i; b++)
/* 118 */       discard(array.get(b)); 
/* 119 */     array.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFree() {
/* 124 */     return this.freeObjects.size;
/*     */   }
/*     */   
/*     */   public static interface Poolable {
/*     */     void reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Pool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */