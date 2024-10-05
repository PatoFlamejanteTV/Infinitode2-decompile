/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class IndexedIterable<R, S, I extends ReversibleIterable<Integer>> implements ReversibleIndexedIterable<R> {
/*    */   private final ReversibleIterable<Integer> iterable;
/*    */   private final Indexed<S> items;
/*    */   
/*    */   public IndexedIterable(Indexed<S> paramIndexed, I paramI) {
/* 10 */     this.items = paramIndexed;
/* 11 */     this.iterable = (ReversibleIterable<Integer>)paramI;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 16 */     return this.iterable.isReversed();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterator<R> iterator() {
/* 22 */     return new IndexedIterator<>(this.items, this.iterable.iterator());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterable<R> reversed() {
/* 28 */     return new IndexedIterable(this.items, (I)this.iterable.reversed());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterator<R> reversedIterator() {
/* 34 */     return new IndexedIterator<>(this.items, this.iterable.reversedIterator());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\IndexedIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */