/*    */ package com.vladsch.flexmark.util.ast;
/*    */ import com.vladsch.flexmark.util.collection.ClassificationBag;
/*    */ import com.vladsch.flexmark.util.collection.SubClassingBag;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class NodeCollectingVisitor {
/* 11 */   public static final Function<Node, Class<?>> NODE_CLASSIFIER = Object::getClass;
/* 12 */   private static final Class<?>[] EMPTY_CLASSES = new Class[0];
/*    */   
/*    */   private final HashMap<Class<?>, List<Class<?>>> subClassMap;
/*    */   private final HashSet<Class<?>> included;
/*    */   private final HashSet<Class<?>> excluded;
/*    */   private final ClassificationBag<Class<?>, Node> nodes;
/*    */   private final Class<?>[] classes;
/*    */   
/*    */   public NodeCollectingVisitor(Set<Class<?>> paramSet) {
/* 21 */     this.classes = (Class[])paramSet.<Class<?>[]>toArray((Class<?>[][])EMPTY_CLASSES);
/*    */     
/* 23 */     this.subClassMap = new HashMap<>();
/* 24 */     this.included = new HashSet<>();
/* 25 */     this.included.addAll(paramSet);
/*    */     
/* 27 */     for (Class<?> clazz : paramSet) {
/*    */       ArrayList<Class<?>> arrayList;
/* 29 */       (arrayList = new ArrayList<>(1)).add(clazz);
/* 30 */       this.subClassMap.put(clazz, arrayList);
/*    */     } 
/*    */     
/* 33 */     this.excluded = new HashSet<>();
/* 34 */     this.nodes = new ClassificationBag(NODE_CLASSIFIER);
/*    */   }
/*    */   
/*    */   public void collect(Node paramNode) {
/* 38 */     visit(paramNode);
/*    */   }
/*    */   
/*    */   public SubClassingBag<Node> getSubClassingBag() {
/* 42 */     return new SubClassingBag(this.nodes, this.subClassMap);
/*    */   }
/*    */   
/*    */   private void visit(Node paramNode) {
/* 46 */     Class<?> clazz = paramNode.getClass();
/* 47 */     if (this.included.contains(clazz)) {
/* 48 */       this.nodes.add(paramNode);
/* 49 */     } else if (!this.excluded.contains(clazz)) {
/*    */       Class<?>[] arrayOfClass; int i; byte b;
/* 51 */       for (i = (arrayOfClass = this.classes).length, b = 0; b < i; b++) {
/* 52 */         Class<?> clazz1; if ((clazz1 = arrayOfClass[b]).isInstance(paramNode)) {
/*    */           
/* 54 */           this.included.add(clazz);
/*    */           List<Class<?>> list;
/* 56 */           if ((list = this.subClassMap.get(clazz1)) == null) {
/*    */             
/* 58 */             (list = new ArrayList<>(2)).add(clazz1);
/* 59 */             list.add(clazz);
/* 60 */             this.subClassMap.put(clazz1, list);
/*    */           } else {
/* 62 */             list.add(clazz);
/*    */           } 
/*    */           
/* 65 */           this.nodes.add(paramNode);
/* 66 */           visitChildren(paramNode);
/*    */           
/*    */           return;
/*    */         } 
/*    */       } 
/*    */       
/* 72 */       this.excluded.add(clazz);
/*    */     } 
/* 74 */     visitChildren(paramNode);
/*    */   }
/*    */   
/*    */   private void visitChildren(Node paramNode) {
/* 78 */     paramNode = paramNode.getFirstChild();
/* 79 */     while (paramNode != null) {
/*    */ 
/*    */       
/* 82 */       Node node = paramNode.getNext();
/* 83 */       visit(paramNode);
/* 84 */       paramNode = node;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */