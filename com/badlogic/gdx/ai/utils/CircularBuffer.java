/*     */ package com.badlogic.gdx.ai.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
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
/*     */ public class CircularBuffer<T>
/*     */ {
/*     */   private T[] items;
/*     */   private boolean resizable;
/*     */   private int head;
/*     */   private int tail;
/*     */   private int size;
/*     */   
/*     */   public CircularBuffer() {
/*  33 */     this(16, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularBuffer(int paramInt) {
/*  39 */     this(paramInt, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularBuffer(int paramInt, boolean paramBoolean) {
/*  47 */     this.items = (T[])new Object[paramInt];
/*  48 */     this.resizable = paramBoolean;
/*  49 */     this.head = 0;
/*  50 */     this.tail = 0;
/*  51 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean store(T paramT) {
/*  58 */     if (this.size == this.items.length) {
/*  59 */       if (!this.resizable) return false;
/*     */ 
/*     */       
/*  62 */       resize(Math.max(8, (int)(this.items.length * 1.75F)));
/*     */     } 
/*  64 */     this.size++;
/*  65 */     this.items[this.tail++] = paramT;
/*  66 */     if (this.tail == this.items.length) this.tail = 0; 
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T read() {
/*  73 */     if (this.size > 0) {
/*  74 */       this.size--;
/*  75 */       T t = this.items[this.head];
/*  76 */       this.items[this.head] = null;
/*  77 */       if (++this.head == this.items.length) this.head = 0; 
/*  78 */       return t;
/*     */     } 
/*     */     
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  86 */     T[] arrayOfT = this.items;
/*  87 */     if (this.tail > this.head) {
/*  88 */       int i = this.head, j = this.tail;
/*     */       do {
/*  90 */         arrayOfT[i++] = null;
/*  91 */       } while (i < j);
/*  92 */     } else if (this.size > 0) {
/*  93 */       int i; int j; for (i = this.head, j = arrayOfT.length; i < j; i++)
/*  94 */         arrayOfT[i] = null; 
/*  95 */       for (i = 0, j = this.tail; i < j; i++)
/*  96 */         arrayOfT[i] = null; 
/*     */     } 
/*  98 */     this.head = 0;
/*  99 */     this.tail = 0;
/* 100 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 105 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 110 */     return (this.size == this.items.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 115 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isResizable() {
/* 120 */     return this.resizable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResizable(boolean paramBoolean) {
/* 126 */     this.resizable = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 133 */     paramInt = this.size + paramInt;
/* 134 */     if (this.items.length < paramInt) resize(paramInt);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resize(int paramInt) {
/* 141 */     Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(this.items.getClass().getComponentType(), paramInt);
/* 142 */     if (this.tail > this.head) {
/* 143 */       System.arraycopy(this.items, this.head, arrayOfObject, 0, this.size);
/* 144 */     } else if (this.size > 0) {
/* 145 */       System.arraycopy(this.items, this.head, arrayOfObject, 0, this.items.length - this.head);
/* 146 */       System.arraycopy(this.items, 0, arrayOfObject, this.items.length - this.head, this.tail);
/*     */     } 
/* 148 */     this.head = 0;
/* 149 */     this.tail = this.size;
/* 150 */     this.items = (T[])arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\CircularBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */