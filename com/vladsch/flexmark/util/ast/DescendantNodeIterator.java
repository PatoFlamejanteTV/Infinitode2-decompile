/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*    */ import java.util.Stack;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DescendantNodeIterator
/*    */   implements ReversiblePeekingIterator<Node>
/*    */ {
/*    */   private final boolean isReversed;
/*    */   private ReversiblePeekingIterator<Node> iterator;
/*    */   private Stack<ReversiblePeekingIterator<Node>> iteratorStack;
/*    */   private Node result;
/*    */   
/*    */   public DescendantNodeIterator(ReversiblePeekingIterator<Node> paramReversiblePeekingIterator) {
/* 22 */     this.isReversed = paramReversiblePeekingIterator.isReversed();
/* 23 */     this.iterator = (paramReversiblePeekingIterator instanceof DescendantNodeIterator) ? ((DescendantNodeIterator)paramReversiblePeekingIterator).iterator : paramReversiblePeekingIterator;
/* 24 */     this.iteratorStack = null;
/* 25 */     this.result = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 30 */     return this.isReversed;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 35 */     return this.iterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public Node next() {
/* 40 */     this.result = (Node)this.iterator.next();
/*    */     
/* 42 */     if (this.result.getFirstChild() != null) {
/*    */       
/* 44 */       if (this.iterator.hasNext()) {
/* 45 */         if (this.iteratorStack == null) this.iteratorStack = new Stack<>(); 
/* 46 */         this.iteratorStack.push(this.iterator);
/*    */       } 
/*    */       
/* 49 */       this.iterator = this.isReversed ? this.result.getReversedChildIterator() : this.result.getChildIterator();
/*    */     
/*    */     }
/* 52 */     else if (this.iteratorStack != null && !this.iteratorStack.isEmpty() && !this.iterator.hasNext()) {
/*    */       
/* 54 */       this.iterator = this.iteratorStack.pop();
/*    */     } 
/*    */ 
/*    */     
/* 58 */     return this.result;
/*    */   }
/*    */ 
/*    */   
/*    */   public Node peek() {
/* 63 */     return (Node)this.iterator.peek();
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 68 */     if (this.result == null) {
/* 69 */       throw new IllegalStateException("Either next() was not called yet or the node was removed");
/*    */     }
/* 71 */     this.result.unlink();
/* 72 */     this.result = null;
/*    */   }
/*    */   
/*    */   public void forEachRemaining(Consumer<? super Node> paramConsumer) {
/* 76 */     while (hasNext())
/* 77 */       paramConsumer.accept(next()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\DescendantNodeIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */