/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.ClassificationBag;
/*     */ import com.vladsch.flexmark.util.collection.OrderedMap;
/*     */ import com.vladsch.flexmark.util.collection.OrderedSet;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class ClassifyingNodeTracker
/*     */   implements NodeTracker {
/*     */   protected final ClassificationBag<Class<?>, Node> nodeClassifier;
/*     */   private final NodeTracker host;
/*     */   private final OrderedMap<Class<?>, Set<Class<?>>> exclusionMap;
/*     */   private final OrderedSet<Class<?>> exclusionSet;
/*     */   private final HashMap<Integer, BitSet> nodeAncestryMap;
/*     */   
/*     */   public ClassifyingNodeTracker(NodeTracker paramNodeTracker, Map<Class<? extends Node>, Set<Class<?>>> paramMap) {
/*  25 */     this.host = paramNodeTracker;
/*  26 */     this.nodeClassifier = new ClassificationBag(NodeClassifier.INSTANCE);
/*  27 */     this.exclusionMap = new OrderedMap(paramMap.size());
/*  28 */     this.exclusionMap.putAll(paramMap);
/*     */ 
/*     */     
/*  31 */     this.exclusionSet = new OrderedSet();
/*     */     
/*  33 */     ReversibleIterator reversibleIterator = this.exclusionMap.valueIterable().iterator();
/*  34 */     while (reversibleIterator.hasNext()) {
/*  35 */       this.exclusionSet.addAll((Collection)reversibleIterator.next());
/*     */     }
/*  37 */     this.nodeAncestryMap = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedMap<Class<?>, Set<Class<?>>> getExclusionMap() {
/*  42 */     return this.exclusionMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public HashMap<Integer, BitSet> getNodeAncestryMap() {
/*  47 */     return this.nodeAncestryMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedSet<Class<?>> getExclusionSet() {
/*  52 */     return this.exclusionSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public ClassificationBag<Class<?>, Node> getNodeClassifier() {
/*  57 */     return this.nodeClassifier;
/*     */   }
/*     */   
/*     */   private void validateLinked(Node paramNode) {
/*  61 */     if (paramNode.getNext() == null && paramNode.getParent() == null) {
/*  62 */       throw new IllegalStateException("Added block " + paramNode + " is not linked into the AST");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void nodeAdded(Node paramNode) {
/*  68 */     validateLinked(paramNode);
/*  69 */     this.nodeClassifier.add(paramNode);
/*  70 */     if (this.host != null) this.host.nodeAdded(paramNode);
/*     */   
/*     */   }
/*     */   
/*     */   public void nodeAddedWithChildren(Node paramNode) {
/*  75 */     validateLinked(paramNode);
/*  76 */     this.nodeClassifier.add(paramNode);
/*  77 */     addNodes(paramNode.getChildren());
/*  78 */     if (this.host != null) this.host.nodeAddedWithChildren(paramNode);
/*     */   
/*     */   }
/*     */   
/*     */   public void nodeAddedWithDescendants(Node paramNode) {
/*  83 */     validateLinked(paramNode);
/*  84 */     this.nodeClassifier.add(paramNode);
/*  85 */     addNodes(paramNode.getDescendants());
/*  86 */     if (this.host != null) this.host.nodeAddedWithDescendants(paramNode); 
/*     */   }
/*     */   
/*     */   private void addNodes(ReversiblePeekingIterable<Node> paramReversiblePeekingIterable) {
/*  90 */     for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramReversiblePeekingIterable.iterator(); reversiblePeekingIterator.hasNext(); ) { Node node = reversiblePeekingIterator.next();
/*  91 */       this.nodeClassifier.add(node); }
/*     */   
/*     */   }
/*     */   
/*     */   private void validateUnlinked(Node paramNode) {
/*  96 */     if (paramNode.getNext() != null || paramNode.getParent() != null) {
/*  97 */       throw new IllegalStateException("Removed block " + paramNode + " is still linked in the AST");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void nodeRemoved(Node paramNode) {
/* 103 */     nodeRemovedWithDescendants(paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void nodeRemovedWithChildren(Node paramNode) {
/* 108 */     nodeRemovedWithDescendants(paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void nodeRemovedWithDescendants(Node paramNode) {
/* 113 */     validateUnlinked(paramNode);
/* 114 */     this.nodeClassifier.add(paramNode);
/* 115 */     removeNodes(paramNode.getDescendants());
/* 116 */     if (this.host != null) this.host.nodeRemovedWithDescendants(paramNode); 
/*     */   }
/*     */   
/*     */   private void removeNodes(ReversiblePeekingIterable<Node> paramReversiblePeekingIterable) {
/* 120 */     for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramReversiblePeekingIterable.iterator(); reversiblePeekingIterator.hasNext(); ) { Node node = reversiblePeekingIterator.next();
/* 121 */       this.nodeClassifier.add(node); }
/*     */   
/*     */   }
/*     */   
/*     */   public OrderedSet<Node> getItems() {
/* 126 */     return this.nodeClassifier.getItems();
/*     */   }
/*     */   
/*     */   public <X> ReversibleIterable<X> getCategoryItems(Class<? extends X> paramClass, Set<Class<?>> paramSet) {
/* 130 */     return this.nodeClassifier.getCategoryItems(paramClass, paramSet);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\ClassifyingNodeTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */