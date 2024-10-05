/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.ConcurrentModificationException;
/*    */ import java.util.NoSuchElementException;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ public class IndexedIterator<R, S, I extends ReversibleIterator<Integer>>
/*    */   implements ReversibleIndexedIterator<R>
/*    */ {
/*    */   private final I iterator;
/*    */   private final Indexed<S> items;
/*    */   private int lastIndex;
/*    */   private int modificationCount;
/*    */   
/*    */   public IndexedIterator(Indexed<S> paramIndexed, I paramI) {
/* 16 */     this.items = paramIndexed;
/* 17 */     this.iterator = paramI;
/* 18 */     this.lastIndex = -1;
/* 19 */     this.modificationCount = paramIndexed.modificationCount();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 24 */     return this.iterator.isReversed();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 29 */     return this.iterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public R next() {
/* 34 */     if (this.modificationCount != this.items.modificationCount()) {
/* 35 */       throw new ConcurrentModificationException();
/*    */     }
/*    */     
/* 38 */     this.lastIndex = ((Integer)this.iterator.next()).intValue();
/*    */     
/* 40 */     return (R)this.items.get(this.lastIndex);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 45 */     if (this.lastIndex == -1) {
/* 46 */       throw new NoSuchElementException();
/*    */     }
/*    */     
/* 49 */     if (this.modificationCount != this.items.modificationCount()) {
/* 50 */       throw new ConcurrentModificationException();
/*    */     }
/*    */     
/* 53 */     this.items.removeAt(this.lastIndex);
/* 54 */     this.lastIndex = -1;
/* 55 */     this.modificationCount = this.items.modificationCount();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIndex() {
/* 60 */     if (this.lastIndex < 0) {
/* 61 */       throw new NoSuchElementException();
/*    */     }
/* 63 */     return this.lastIndex;
/*    */   }
/*    */   
/*    */   public void forEachRemaining(Consumer<? super R> paramConsumer) {
/* 67 */     while (hasNext())
/* 68 */       paramConsumer.accept(next()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\IndexedIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */