/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ public class DescendantNodeIterable
/*    */   implements ReversiblePeekingIterable<Node>
/*    */ {
/*    */   private ReversiblePeekingIterable<Node> iterable;
/*    */   
/*    */   public DescendantNodeIterable(ReversiblePeekingIterable<Node> paramReversiblePeekingIterable) {
/* 16 */     if (paramReversiblePeekingIterable instanceof DescendantNodeIterable) {
/* 17 */       this.iterable = ((DescendantNodeIterable)paramReversiblePeekingIterable).iterable; return;
/*    */     } 
/* 19 */     this.iterable = paramReversiblePeekingIterable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterator<Node> iterator() {
/* 26 */     return new DescendantNodeIterator(this.iterable.iterator());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterable<Node> reversed() {
/* 32 */     return new DescendantNodeIterable(this.iterable.reversed());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterator<Node> reversedIterator() {
/* 38 */     return new DescendantNodeIterator(this.iterable.reversedIterator());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 43 */     return this.iterable.isReversed();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\DescendantNodeIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */