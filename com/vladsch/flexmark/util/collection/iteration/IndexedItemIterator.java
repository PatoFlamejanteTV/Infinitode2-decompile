/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.ConcurrentModificationException;
/*    */ import java.util.NoSuchElementException;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ public class IndexedItemIterator<R>
/*    */   implements ReversibleIndexedIterator<R>
/*    */ {
/*    */   private final Indexed<R> items;
/*    */   private final boolean reversed;
/*    */   private int next;
/*    */   private int last;
/*    */   private int modificationCount;
/*    */   
/*    */   public IndexedItemIterator(Indexed<R> paramIndexed) {
/* 17 */     this(paramIndexed, false);
/*    */   }
/*    */   
/*    */   public IndexedItemIterator(Indexed<R> paramIndexed, boolean paramBoolean) {
/* 21 */     this.items = paramIndexed;
/* 22 */     this.reversed = paramBoolean;
/* 23 */     this.next = this.reversed ? (paramIndexed.size() - 1) : 0;
/*    */ 
/*    */     
/* 26 */     if (this.next >= paramIndexed.size()) this.next = -1;
/*    */     
/* 28 */     this.last = -1;
/* 29 */     this.modificationCount = paramIndexed.modificationCount();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 34 */     return this.reversed;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 39 */     return (this.next != -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public R next() {
/* 44 */     if (this.modificationCount != this.items.modificationCount()) {
/* 45 */       throw new ConcurrentModificationException();
/*    */     }
/*    */     
/* 48 */     if (this.next == -1) {
/* 49 */       throw new NoSuchElementException();
/*    */     }
/*    */     
/* 52 */     this.last = this.next;
/* 53 */     this.next = this.reversed ? ((this.next <= 0) ? -1 : (this.next - 1)) : ((this.next == this.items.size() - 1) ? -1 : (this.next + 1));
/* 54 */     return this.items.get(this.last);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 59 */     if (this.last == -1) {
/* 60 */       throw new NoSuchElementException();
/*    */     }
/*    */     
/* 63 */     if (this.modificationCount != this.items.modificationCount()) {
/* 64 */       throw new ConcurrentModificationException();
/*    */     }
/*    */     
/* 67 */     this.items.removeAt(this.last);
/* 68 */     this.last = -1;
/* 69 */     this.modificationCount = this.items.modificationCount();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIndex() {
/* 74 */     if (this.last < 0) {
/* 75 */       throw new NoSuchElementException();
/*    */     }
/* 77 */     return this.last;
/*    */   }
/*    */   
/*    */   public void forEachRemaining(Consumer<? super R> paramConsumer) {
/* 81 */     while (hasNext())
/* 82 */       paramConsumer.accept(next()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\IndexedItemIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */