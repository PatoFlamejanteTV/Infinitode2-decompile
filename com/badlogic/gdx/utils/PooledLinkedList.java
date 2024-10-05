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
/*     */ public class PooledLinkedList<T>
/*     */ {
/*     */   private Item<T> head;
/*     */   private Item<T> tail;
/*     */   private Item<T> iter;
/*     */   private Item<T> curr;
/*     */   
/*     */   static final class Item<T>
/*     */   {
/*     */     public T payload;
/*     */     public Item<T> next;
/*     */     public Item<T> prev;
/*     */   }
/*  32 */   private int size = 0;
/*     */   
/*     */   private final Pool<Item<T>> pool;
/*     */   
/*     */   public PooledLinkedList(int paramInt) {
/*  37 */     this.pool = (Pool)new Pool<Item<Item<T>>>(16, paramInt)
/*     */       {
/*     */         protected PooledLinkedList.Item<T> newObject() {
/*  40 */           return new PooledLinkedList.Item<>();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(T paramT) {
/*     */     Item<T> item;
/*  48 */     (item = this.pool.obtain()).payload = paramT;
/*  49 */     item.next = null;
/*  50 */     item.prev = null;
/*     */     
/*  52 */     if (this.head == null) {
/*  53 */       this.head = item;
/*  54 */       this.tail = item;
/*  55 */       this.size++;
/*     */       
/*     */       return;
/*     */     } 
/*  59 */     item.prev = this.tail;
/*  60 */     this.tail.next = item;
/*  61 */     this.tail = item;
/*  62 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFirst(T paramT) {
/*     */     Item<T> item;
/*  68 */     (item = this.pool.obtain()).payload = paramT;
/*  69 */     item.next = this.head;
/*  70 */     item.prev = null;
/*     */     
/*  72 */     if (this.head != null) {
/*  73 */       this.head.prev = item;
/*     */     } else {
/*  75 */       this.tail = item;
/*     */     } 
/*     */     
/*  78 */     this.head = item;
/*     */     
/*  80 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  85 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void iter() {
/*  90 */     this.iter = this.head;
/*     */   }
/*     */ 
/*     */   
/*     */   public void iterReverse() {
/*  95 */     this.iter = this.tail;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public T next() {
/* 102 */     if (this.iter == null) return null;
/*     */     
/* 104 */     T t = this.iter.payload;
/* 105 */     this.curr = this.iter;
/* 106 */     this.iter = this.iter.next;
/* 107 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public T previous() {
/* 114 */     if (this.iter == null) return null;
/*     */     
/* 116 */     T t = this.iter.payload;
/* 117 */     this.curr = this.iter;
/* 118 */     this.iter = this.iter.prev;
/* 119 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 124 */     if (this.curr == null)
/*     */       return; 
/* 126 */     this.size--;
/*     */     
/* 128 */     Item<T> item1 = this.curr;
/* 129 */     Item<T> item2 = this.curr.next;
/* 130 */     Item<T> item3 = this.curr.prev;
/* 131 */     this.pool.free(this.curr);
/* 132 */     this.curr = null;
/*     */     
/* 134 */     if (this.size == 0) {
/* 135 */       this.head = null;
/* 136 */       this.tail = null;
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     if (item1 == this.head) {
/* 141 */       item2.prev = null;
/* 142 */       this.head = item2;
/*     */       
/*     */       return;
/*     */     } 
/* 146 */     if (item1 == this.tail) {
/* 147 */       item3.next = null;
/* 148 */       this.tail = item3;
/*     */       
/*     */       return;
/*     */     } 
/* 152 */     item3.next = item2;
/* 153 */     item2.prev = item3;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T removeLast() {
/* 158 */     if (this.tail == null) {
/* 159 */       return null;
/*     */     }
/*     */     
/* 162 */     T t = this.tail.payload;
/*     */     
/* 164 */     this.size--;
/*     */     
/* 166 */     Item<T> item = this.tail.prev;
/* 167 */     this.pool.free(this.tail);
/*     */     
/* 169 */     if (this.size == 0) {
/* 170 */       this.head = null;
/* 171 */       this.tail = null;
/*     */     } else {
/* 173 */       this.tail = item;
/* 174 */       this.tail.next = null;
/*     */     } 
/*     */     
/* 177 */     return t;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 181 */     iter();
/*     */     
/* 183 */     while (next() != null)
/* 184 */       remove(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\PooledLinkedList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */