/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NodeIterator
/*     */   implements ReversiblePeekingIterator<Node>
/*     */ {
/*     */   final Node firstNode;
/*     */   final Node lastNode;
/*     */   final boolean reversed;
/*     */   Node node;
/*     */   Node result;
/*     */   
/*     */   public NodeIterator(Node paramNode) {
/*  20 */     this(paramNode, null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeIterator(Node paramNode, boolean paramBoolean) {
/*  28 */     this(paramNode, null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeIterator(Node paramNode1, Node paramNode2) {
/*  36 */     this(paramNode1, paramNode2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeIterator(Node paramNode1, Node paramNode2, boolean paramBoolean) {
/*  47 */     if (paramNode1 == null) {
/*  48 */       throw new NullPointerException();
/*     */     }
/*  50 */     this.firstNode = paramNode1;
/*  51 */     this.lastNode = paramNode2;
/*  52 */     this.reversed = paramBoolean;
/*  53 */     this.node = paramBoolean ? paramNode2 : paramNode1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReversed() {
/*  61 */     return this.reversed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  69 */     return (this.node != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node next() {
/*  77 */     this.result = null;
/*     */     
/*  79 */     if (this.node == null) {
/*  80 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/*  83 */     this.result = this.node;
/*  84 */     this.node = this.reversed ? this.node.getPrevious() : this.node.getNext();
/*  85 */     if (this.node == null || this.result == (this.reversed ? this.firstNode : this.lastNode)) this.node = null; 
/*  86 */     return this.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node peek() {
/*  94 */     if (this.node != null) {
/*  95 */       return this.node;
/*     */     }
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 105 */     if (this.result == null) {
/* 106 */       throw new IllegalStateException("Either next() was not called yet or the node was removed");
/*     */     }
/* 108 */     this.result.unlink();
/* 109 */     this.result = null;
/*     */   }
/*     */   
/*     */   public void forEachRemaining(Consumer<? super Node> paramConsumer) {
/* 113 */     if (paramConsumer == null) {
/* 114 */       throw new NullPointerException();
/*     */     }
/* 116 */     while (hasNext()) {
/* 117 */       paramConsumer.accept(next());
/*     */     }
/*     */   }
/*     */   
/* 121 */   public static final ReversiblePeekingIterator<Node> EMPTY = new ReversiblePeekingIterator<Node>()
/*     */     {
/*     */       public final void remove() {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isReversed() {
/* 129 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean hasNext() {
/* 134 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public final Node next() {
/* 139 */         throw new NoSuchElementException();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final Node peek() {
/* 145 */         return null;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */