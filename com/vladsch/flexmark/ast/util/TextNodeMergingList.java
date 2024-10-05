/*     */ package com.vladsch.flexmark.ast.util;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TextNodeMergingList {
/*  11 */   private ArrayList<Node> list = new ArrayList<>();
/*     */   private boolean isMerged = true;
/*     */   
/*     */   public void add(Node paramNode) {
/*  15 */     this.list.add(paramNode);
/*  16 */     if (paramNode instanceof Text) this.isMerged = false; 
/*     */   }
/*     */   
/*     */   public void add(BasedSequence paramBasedSequence) {
/*  20 */     if (!paramBasedSequence.isEmpty()) {
/*  21 */       add((Node)new Text(paramBasedSequence));
/*     */     }
/*     */   }
/*     */   
/*     */   public void addChildrenOf(Node paramNode) {
/*  26 */     paramNode = paramNode.getFirstChild();
/*  27 */     while (paramNode != null) {
/*  28 */       Node node = paramNode.getNext();
/*  29 */       paramNode.unlink();
/*  30 */       add(paramNode);
/*  31 */       paramNode = node;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void appendMergedTo(Node paramNode) {
/*  36 */     mergeList();
/*  37 */     for (Node node : this.list) {
/*  38 */       paramNode.appendChild(node);
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear() {
/*  43 */     this.list.clear();
/*  44 */     this.isMerged = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertMergedBefore(Node paramNode) {
/*  49 */     mergeList();
/*  50 */     for (Node node : this.list) {
/*  51 */       paramNode.insertBefore(node);
/*     */     }
/*  53 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertMergedAfter(Node paramNode) {
/*  58 */     mergeList();
/*  59 */     for (Node node : this.list) {
/*  60 */       paramNode.insertAfter(node);
/*  61 */       paramNode = node;
/*     */     } 
/*  63 */     clear();
/*     */   }
/*     */   
/*     */   private void mergeList() {
/*  67 */     if (!this.isMerged) {
/*     */       
/*  69 */       ArrayList<Node> arrayList = null;
/*     */       
/*  71 */       Node node = null;
/*     */       
/*  73 */       for (Iterator<Node> iterator = this.list.iterator(); iterator.hasNext(); ) {
/*  74 */         Node node1; if (node1 = iterator.next() instanceof Text) {
/*  75 */           if (!node1.getChars().isEmpty()) {
/*  76 */             if (node == null) {
/*  77 */               node = node1; continue;
/*  78 */             }  if (node.getChars().isContinuedBy(node1.getChars())) {
/*     */               
/*  80 */               node.setChars(node.getChars().spliceAtEnd(node1.getChars())); continue;
/*     */             } 
/*  82 */             if (arrayList == null) arrayList = new ArrayList(); 
/*  83 */             arrayList.add(node);
/*  84 */             node = node1;
/*     */           } 
/*     */           continue;
/*     */         } 
/*  88 */         if (arrayList == null) arrayList = new ArrayList<>(); 
/*  89 */         if (node != null) {
/*  90 */           arrayList.add(node);
/*  91 */           node = null;
/*     */         } 
/*  93 */         arrayList.add(node1);
/*     */       } 
/*     */ 
/*     */       
/*  97 */       if (node != null) {
/*  98 */         if (arrayList == null) {
/*  99 */           this.list.clear();
/* 100 */           this.list.add(node);
/*     */         } else {
/* 102 */           arrayList.add(node);
/*     */         } 
/*     */       }
/*     */       
/* 106 */       if (arrayList != null) {
/* 107 */         this.list = arrayList;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Node> getMergedList() {
/* 113 */     mergeList();
/* 114 */     return this.list;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\TextNodeMergingList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */