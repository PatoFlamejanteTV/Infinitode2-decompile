/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class IndexedItemIterable<R> implements ReversibleIndexedIterable<R> {
/*    */   private final Indexed<R> items;
/*    */   private final boolean reversed;
/*    */   
/*    */   public IndexedItemIterable(Indexed<R> paramIndexed) {
/* 10 */     this(paramIndexed, false);
/*    */   }
/*    */   
/*    */   public IndexedItemIterable(Indexed<R> paramIndexed, boolean paramBoolean) {
/* 14 */     this.items = paramIndexed;
/* 15 */     this.reversed = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 20 */     return this.reversed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterator<R> iterator() {
/* 26 */     return new IndexedItemIterator<>(this.items, this.reversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterable<R> reversed() {
/* 32 */     return new IndexedItemIterable(this.items, !this.reversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIndexedIterator<R> reversedIterator() {
/* 38 */     return new IndexedItemIterator<>(this.items, !this.reversed);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\IndexedItemIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */