/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.NoSuchElementException;
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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ abstract class AbstractIterator<T>
/*    */   implements Iterator<T>
/*    */ {
/*    */   private T next;
/* 34 */   private State state = State.NOT_READY;
/*    */   
/*    */   protected abstract T computeNext();
/*    */   
/*    */   private enum State {
/* 39 */     READY,
/* 40 */     NOT_READY,
/* 41 */     DONE,
/* 42 */     FAILED;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final T endOfData() {
/* 53 */     this.state = State.DONE;
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasNext() {
/* 59 */     Preconditions.checkState((this.state != State.FAILED));
/* 60 */     switch (this.state) {
/*    */       case DONE:
/* 62 */         return false;
/*    */       case READY:
/* 64 */         return true;
/*    */     } 
/*    */     
/* 67 */     return tryToComputeNext();
/*    */   }
/*    */   
/*    */   private boolean tryToComputeNext() {
/* 71 */     this.state = State.FAILED;
/* 72 */     this.next = computeNext();
/* 73 */     if (this.state != State.DONE) {
/* 74 */       this.state = State.READY;
/* 75 */       return true;
/*    */     } 
/* 77 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   @ParametricNullness
/*    */   public final T next() {
/* 83 */     if (!hasNext()) {
/* 84 */       throw new NoSuchElementException();
/*    */     }
/* 86 */     this.state = State.NOT_READY;
/*    */     
/* 88 */     T t = (T)NullnessCasts.uncheckedCastNullableTToT((Object)this.next);
/* 89 */     this.next = null;
/* 90 */     return t;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void remove() {
/* 95 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\AbstractIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */