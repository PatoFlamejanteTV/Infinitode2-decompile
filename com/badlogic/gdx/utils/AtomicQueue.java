/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import java.util.concurrent.atomic.AtomicReferenceArray;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AtomicQueue<T>
/*    */ {
/* 32 */   private final AtomicInteger writeIndex = new AtomicInteger();
/* 33 */   private final AtomicInteger readIndex = new AtomicInteger();
/*    */   private final AtomicReferenceArray<T> queue;
/*    */   
/*    */   public AtomicQueue(int paramInt) {
/* 37 */     this.queue = new AtomicReferenceArray<>(paramInt);
/*    */   }
/*    */   
/*    */   private int next(int paramInt) {
/* 41 */     return (paramInt + 1) % this.queue.length();
/*    */   }
/*    */   
/*    */   public boolean put(@Null T paramT) {
/* 45 */     int i = this.writeIndex.get();
/* 46 */     int j = this.readIndex.get();
/*    */     int k;
/* 48 */     if ((k = next(i)) == j) return false; 
/* 49 */     this.queue.set(i, paramT);
/* 50 */     this.writeIndex.set(k);
/* 51 */     return true;
/*    */   }
/*    */   @Null
/*    */   public T poll() {
/* 55 */     int i = this.readIndex.get();
/* 56 */     int j = this.writeIndex.get();
/* 57 */     if (i == j) return null; 
/* 58 */     j = this.queue.get(i);
/* 59 */     this.readIndex.set(next(i));
/* 60 */     return j;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\AtomicQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */