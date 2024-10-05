/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*    */ import java.util.Iterator;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ public class NodeIterable implements ReversiblePeekingIterable<Node> {
/*    */   final Node firstNode;
/*    */   final Node lastNode;
/*    */   final boolean reversed;
/*    */   
/*    */   public NodeIterable(Node paramNode1, Node paramNode2, boolean paramBoolean) {
/* 16 */     this.firstNode = paramNode1;
/* 17 */     this.lastNode = paramNode2;
/* 18 */     this.reversed = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterator<Node> iterator() {
/* 24 */     return new NodeIterator(this.firstNode, this.lastNode, this.reversed);
/*    */   }
/*    */   
/*    */   public void forEach(Consumer<? super Node> paramConsumer) {
/* 28 */     ReversiblePeekingIterator<Node> reversiblePeekingIterator = iterator();
/* 29 */     while (reversiblePeekingIterator.hasNext()) {
/* 30 */       paramConsumer.accept(reversiblePeekingIterator.next());
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterable<Node> reversed() {
/* 37 */     return new NodeIterable(this.firstNode, this.lastNode, !this.reversed);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 42 */     return this.reversed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversiblePeekingIterator<Node> reversedIterator() {
/* 48 */     return new NodeIterator(this.firstNode, this.lastNode, !this.reversed);
/*    */   }
/*    */   
/* 51 */   public static final ReversiblePeekingIterable<Node> EMPTY = new ReversiblePeekingIterable<Node>()
/*    */     {
/*    */       public final ReversiblePeekingIterator<Node> iterator()
/*    */       {
/* 55 */         return NodeIterator.EMPTY;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public final ReversiblePeekingIterable<Node> reversed() {
/* 61 */         return this;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public final void forEach(Consumer<? super Node> param1Consumer) {}
/*    */ 
/*    */       
/*    */       public final boolean isReversed() {
/* 70 */         return false;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public final ReversiblePeekingIterator<Node> reversedIterator() {
/* 76 */         return NodeIterator.EMPTY;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */