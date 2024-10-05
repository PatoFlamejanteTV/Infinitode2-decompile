/*     */ package com.vladsch.flexmark.util.ast;
/*     */ import com.vladsch.flexmark.util.collection.CopyOnWriteRef;
/*     */ import com.vladsch.flexmark.util.collection.OrderedMap;
/*     */ import com.vladsch.flexmark.util.collection.OrderedSet;
/*     */ import java.util.BitSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Stack;
/*     */ 
/*     */ public class NodeClassifierVisitor extends NodeVisitorBase implements NodeTracker {
/*     */   private final OrderedMap<Class<?>, Set<Class<?>>> exclusionMap;
/*  14 */   private final Stack<BitSet> nodeAncestryBitSetStack = new Stack<>(); private final OrderedSet<Class<?>> exclusionSet; private final HashMap<Integer, BitSet> nodeAncestryMap; private final CopyOnWriteRef<BitSet> nodeAncestryBitSet; public NodeClassifierVisitor(Map<Class<? extends Node>, Set<Class<?>>> paramMap) {
/*  15 */     this.nodeAncestryBitSet = new CopyOnWriteRef(new BitSet(), paramBitSet -> (paramBitSet != null) ? (BitSet)paramBitSet.clone() : new BitSet());
/*     */ 
/*     */     
/*  18 */     this.isClassificationDone = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  23 */     this.classifyingNodeTracker = new ClassifyingNodeTracker(this, paramMap);
/*  24 */     this.exclusionMap = this.classifyingNodeTracker.getExclusionMap();
/*  25 */     this.nodeAncestryMap = this.classifyingNodeTracker.getNodeAncestryMap();
/*  26 */     this.exclusionSet = this.classifyingNodeTracker.getExclusionSet();
/*     */   }
/*     */   private static final BitSet EMPTY_SET = new BitSet(); private boolean isClassificationDone; private final ClassifyingNodeTracker classifyingNodeTracker;
/*     */   
/*     */   public ClassifyingNodeTracker classify(Node paramNode) {
/*  31 */     assert !this.isClassificationDone;
/*  32 */     visit(paramNode);
/*  33 */     this.isClassificationDone = true;
/*  34 */     return this.classifyingNodeTracker;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visit(Node paramNode) {
/*  39 */     visitChildren(paramNode);
/*     */   }
/*     */   public void nodeRemoved(Node paramNode) {}
/*     */   public void nodeRemovedWithChildren(Node paramNode) {}
/*     */   
/*     */   public void nodeRemovedWithDescendants(Node paramNode) {}
/*     */   
/*  46 */   public void nodeAddedWithChildren(Node paramNode) { nodeAdded(paramNode); } public void nodeAddedWithDescendants(Node paramNode) {
/*  47 */     nodeAdded(paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void nodeAdded(Node paramNode) {
/*  52 */     if (this.isClassificationDone) {
/*  53 */       if (paramNode.getParent() == null) {
/*  54 */         throw new IllegalStateException("Node must be inserted into the document before calling node tracker nodeAdded functions");
/*     */       }
/*     */       
/*  57 */       if (!(paramNode.getParent() instanceof Document)) {
/*     */         int i;
/*  59 */         if ((i = this.classifyingNodeTracker.getItems().indexOf(paramNode.getParent())) == -1) {
/*  60 */           throw new IllegalStateException("Parent node: " + paramNode.getParent() + " of " + paramNode + " is not tracked, some post processor forgot to call tracker.nodeAdded().");
/*     */         }
/*     */         
/*  63 */         BitSet bitSet = this.nodeAncestryMap.get(Integer.valueOf(i));
/*  64 */         this.nodeAncestryBitSet.setValue(bitSet);
/*     */       } 
/*     */ 
/*     */       
/*  68 */       this.nodeAncestryBitSetStack.clear();
/*  69 */       visit(paramNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   void pushNodeAncestry() {
/*  74 */     if (!this.exclusionMap.isEmpty()) {
/*  75 */       this.nodeAncestryBitSetStack.push(this.nodeAncestryBitSet.getImmutable());
/*     */     }
/*     */   }
/*     */   
/*     */   void popNodeAncestry() {
/*  80 */     this.nodeAncestryBitSet.setValue(this.nodeAncestryBitSetStack.pop());
/*     */   }
/*     */   
/*     */   boolean updateNodeAncestry(Node paramNode, CopyOnWriteRef<BitSet> paramCopyOnWriteRef) {
/*  84 */     if (!this.exclusionMap.isEmpty() && !(paramNode instanceof Document)) {
/*     */       
/*  86 */       BitSet bitSet = (BitSet)paramCopyOnWriteRef.getPeek();
/*  87 */       assert bitSet != null;
/*     */       
/*     */       int i;
/*  90 */       if ((i = this.classifyingNodeTracker.getItems().indexOf(paramNode)) == -1) {
/*  91 */         throw new IllegalStateException("Node: " + paramNode + " is not tracked, some post processor forgot to call tracker.nodeAdded().");
/*     */       }
/*     */       
/*  94 */       if (this.exclusionSet != null && !this.exclusionSet.isEmpty()) {
/*  95 */         Iterator<Class<?>> iterator = this.exclusionSet.iterator();
/*     */         
/*  97 */         while (iterator.hasNext()) {
/*     */           Class<?> clazz;
/*  99 */           if ((clazz = iterator.next()).isInstance(paramNode)) {
/*     */             
/* 101 */             int j = this.exclusionSet.indexOf(clazz);
/* 102 */             assert j != -1;
/* 103 */             if (!bitSet.get(j)) {
/* 104 */               bitSet = (BitSet)paramCopyOnWriteRef.getMutable();
/* 105 */               assert bitSet != null;
/*     */               
/* 107 */               bitSet.set(j);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 113 */       if (this.isClassificationDone && this.nodeAncestryBitSetStack.size() > 1) {
/*     */         BitSet bitSet1;
/*     */ 
/*     */         
/* 117 */         if ((bitSet1 = this.nodeAncestryMap.get(Integer.valueOf(i))) != null && bitSet1.equals(bitSet))
/*     */         {
/* 119 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 123 */       if (!bitSet.isEmpty()) {
/* 124 */         this.nodeAncestryMap.put(Integer.valueOf(i), paramCopyOnWriteRef.getImmutable());
/*     */       }
/*     */     } 
/*     */     
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitChildren(Node paramNode) {
/* 138 */     if (!this.isClassificationDone)
/*     */     {
/* 140 */       if (!(paramNode instanceof Document)) {
/* 141 */         this.classifyingNodeTracker.nodeAdded(paramNode);
/*     */       }
/*     */     }
/*     */     
/* 145 */     if (paramNode.getFirstChild() != null) {
/* 146 */       pushNodeAncestry();
/* 147 */       if (updateNodeAncestry(paramNode, this.nodeAncestryBitSet)) {
/* 148 */         super.visitChildren(paramNode);
/*     */       }
/* 150 */       popNodeAncestry(); return;
/*     */     } 
/* 152 */     updateNodeAncestry(paramNode, this.nodeAncestryBitSet);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeClassifierVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */