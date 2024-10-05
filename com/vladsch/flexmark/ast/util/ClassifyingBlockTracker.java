/*     */ package com.vladsch.flexmark.ast.util;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserTracker;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockTracker;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeClassifier;
/*     */ import com.vladsch.flexmark.util.collection.ClassificationBag;
/*     */ import com.vladsch.flexmark.util.collection.CollectionHost;
/*     */ import com.vladsch.flexmark.util.collection.OrderedMultiMap;
/*     */ import com.vladsch.flexmark.util.collection.OrderedSet;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.misc.Paired;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ public class ClassifyingBlockTracker implements BlockParserTracker, BlockTracker {
/*  19 */   protected final ClassificationBag<Class<?>, Node> nodeClassifier = new ClassificationBag((Function)NodeClassifier.INSTANCE);
/*  20 */   protected final OrderedMultiMap<BlockParser, Block> allBlockParsersMap = new OrderedMultiMap(new CollectionHost<Paired<BlockParser, Block>>()
/*     */       {
/*     */         public void adding(int param1Int, Paired<BlockParser, Block> param1Paired, Object param1Object) {
/*     */           Block block;
/*  24 */           if ((block = (Block)param1Paired.getSecond()) != null) ClassifyingBlockTracker.this.nodeClassifier.add(block);
/*     */         
/*     */         }
/*     */         
/*     */         public Object removing(int param1Int, Paired<BlockParser, Block> param1Paired) {
/*     */           Block block;
/*  30 */           if ((block = (Block)param1Paired.getSecond()) != null) ClassifyingBlockTracker.this.nodeClassifier.remove(block); 
/*  31 */           return param1Paired;
/*     */         }
/*     */ 
/*     */         
/*     */         public void clearing() {
/*  36 */           ClassifyingBlockTracker.this.nodeClassifier.clear();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void addingNulls(int param1Int) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean skipHostUpdate() {
/*  46 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public int getIteratorModificationCount() {
/*  51 */           return ClassifyingBlockTracker.this.allBlockParsersMap.getModificationCount();
/*     */         }
/*     */       });
/*     */   
/*     */   public OrderedSet<BlockParser> allBlockParsers() {
/*  56 */     return this.allBlockParsersMap.keySet();
/*     */   }
/*     */   
/*     */   public OrderedSet<Block> allBlocks() {
/*  60 */     return this.allBlockParsersMap.valueSet();
/*     */   }
/*     */   
/*     */   public Block getValue(BlockParser paramBlockParser) {
/*  64 */     return (Block)this.allBlockParsersMap.getKeyValue(paramBlockParser);
/*     */   }
/*     */   
/*     */   public BlockParser getKey(Block paramBlock) {
/*  68 */     return (BlockParser)this.allBlockParsersMap.getValueKey(paramBlock);
/*     */   }
/*     */   
/*     */   public boolean containsKey(BlockParser paramBlockParser) {
/*  72 */     return this.allBlockParsersMap.containsKey(paramBlockParser);
/*     */   }
/*     */   
/*     */   public boolean containsValue(Block paramBlock) {
/*  76 */     return this.allBlockParsersMap.containsValue(paramBlock);
/*     */   }
/*     */   
/*     */   public ClassificationBag<Class<?>, Node> getNodeClassifier() {
/*  80 */     return this.nodeClassifier;
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockParserAdded(BlockParser paramBlockParser) {
/*  85 */     this.allBlockParsersMap.putKeyValue(paramBlockParser, paramBlockParser.getBlock());
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockParserRemoved(BlockParser paramBlockParser) {
/*  90 */     this.allBlockParsersMap.removeKey(paramBlockParser);
/*     */   }
/*     */   
/*     */   private void validateLinked(Node paramNode) {
/*  94 */     if (paramNode.getNext() == null && paramNode.getParent() == null) {
/*  95 */       throw new IllegalStateException("Added block " + paramNode + " is not linked into the AST");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockAdded(Block paramBlock) {
/* 101 */     validateLinked((Node)paramBlock);
/* 102 */     this.allBlockParsersMap.putValueKey(paramBlock, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockAddedWithChildren(Block paramBlock) {
/* 107 */     validateLinked((Node)paramBlock);
/* 108 */     this.allBlockParsersMap.putValueKey(paramBlock, null);
/* 109 */     addBlocks(paramBlock.getChildren());
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockAddedWithDescendants(Block paramBlock) {
/* 114 */     validateLinked((Node)paramBlock);
/* 115 */     this.allBlockParsersMap.putValueKey(paramBlock, null);
/* 116 */     addBlocks(paramBlock.getDescendants());
/*     */   }
/*     */   
/*     */   private void addBlocks(ReversiblePeekingIterable<Node> paramReversiblePeekingIterable) {
/* 120 */     for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramReversiblePeekingIterable.iterator(); reversiblePeekingIterator.hasNext();) {
/* 121 */       if (node = reversiblePeekingIterator.next() instanceof Block) {
/* 122 */         this.allBlockParsersMap.putValueKey(node, null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void validateUnlinked(Node paramNode) {
/* 128 */     if (paramNode.getNext() != null || paramNode.getParent() != null) {
/* 129 */       throw new IllegalStateException("Removed block " + paramNode + " is still linked in the AST");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockRemoved(Block paramBlock) {
/* 135 */     validateUnlinked((Node)paramBlock);
/* 136 */     this.allBlockParsersMap.removeValue(paramBlock);
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockRemovedWithChildren(Block paramBlock) {
/* 141 */     validateUnlinked((Node)paramBlock);
/* 142 */     this.allBlockParsersMap.removeValue(paramBlock);
/* 143 */     removeBlocks(paramBlock.getChildren());
/*     */   }
/*     */ 
/*     */   
/*     */   public void blockRemovedWithDescendants(Block paramBlock) {
/* 148 */     validateUnlinked((Node)paramBlock);
/* 149 */     this.allBlockParsersMap.removeValue(paramBlock);
/* 150 */     removeBlocks(paramBlock.getDescendants());
/*     */   }
/*     */   
/*     */   private void removeBlocks(ReversiblePeekingIterable<Node> paramReversiblePeekingIterable) {
/* 154 */     for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramReversiblePeekingIterable.iterator(); reversiblePeekingIterator.hasNext();) {
/* 155 */       if (node = reversiblePeekingIterator.next() instanceof Block)
/* 156 */         this.allBlockParsersMap.removeValue(node); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\ClassifyingBlockTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */