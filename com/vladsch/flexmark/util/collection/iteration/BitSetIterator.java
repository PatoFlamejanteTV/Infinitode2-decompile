/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.BitSet;
/*    */ import java.util.NoSuchElementException;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ public class BitSetIterator
/*    */   implements ReversibleIterator<Integer>
/*    */ {
/*    */   private final BitSet bitSet;
/*    */   private final boolean reversed;
/*    */   private int next;
/*    */   private int last;
/*    */   
/*    */   public BitSetIterator(BitSet paramBitSet) {
/* 16 */     this(paramBitSet, false);
/*    */   }
/*    */   
/*    */   public BitSetIterator(BitSet paramBitSet, boolean paramBoolean) {
/* 20 */     this.bitSet = paramBitSet;
/* 21 */     this.reversed = paramBoolean;
/* 22 */     this.next = paramBoolean ? paramBitSet.previousSetBit(paramBitSet.length()) : paramBitSet.nextSetBit(0);
/* 23 */     this.last = -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 28 */     return this.reversed;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 33 */     return (this.next != -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer next() {
/* 38 */     if (this.next == -1) {
/* 39 */       throw new NoSuchElementException();
/*    */     }
/* 41 */     this.last = this.next;
/* 42 */     this.next = this.reversed ? ((this.next == 0) ? -1 : this.bitSet.previousSetBit(this.next - 1)) : this.bitSet.nextSetBit(this.next + 1);
/* 43 */     return Integer.valueOf(this.last);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 48 */     if (this.last == -1) {
/* 49 */       throw new NoSuchElementException();
/*    */     }
/* 51 */     this.bitSet.clear(this.last);
/*    */   }
/*    */   
/*    */   public void forEachRemaining(Consumer<? super Integer> paramConsumer) {
/* 55 */     while (hasNext())
/* 56 */       paramConsumer.accept(next()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\BitSetIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */