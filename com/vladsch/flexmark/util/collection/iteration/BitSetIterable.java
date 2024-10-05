/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.BitSet;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class BitSetIterable
/*    */   implements ReversibleIterable<Integer> {
/*    */   private final BitSet bitSet;
/*    */   private final boolean reversed;
/*    */   
/*    */   public BitSetIterable(BitSet paramBitSet) {
/* 12 */     this(paramBitSet, false);
/*    */   }
/*    */   
/*    */   public BitSetIterable(BitSet paramBitSet, boolean paramBoolean) {
/* 16 */     this.bitSet = paramBitSet;
/* 17 */     this.reversed = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 22 */     return this.reversed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterator<Integer> iterator() {
/* 28 */     return new BitSetIterator(this.bitSet, this.reversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterable<Integer> reversed() {
/* 34 */     return new BitSetIterable(this.bitSet, !this.reversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterator<Integer> reversedIterator() {
/* 40 */     return new BitSetIterator(this.bitSet, !this.reversed);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\BitSetIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */