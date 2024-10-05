/*     */ package com.vladsch.flexmark.ast.util;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TextNodeConverter
/*     */ {
/*     */   private final BasedSequence nodeChars;
/*     */   private BasedSequence remainingChars;
/*  13 */   private final ArrayList<Node> list = new ArrayList<>();
/*     */   
/*     */   public TextNodeConverter(BasedSequence paramBasedSequence) {
/*  16 */     this.nodeChars = paramBasedSequence;
/*  17 */     this.remainingChars = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void appendChild(Node paramNode) {
/*  21 */     BasedSequence basedSequence = paramNode.getChars();
/*  22 */     assert this.nodeChars.containsAllOf(basedSequence) : "child " + paramNode.toAstString(false) + " is not within parent sequence " + Node.toSegmentSpan(this.nodeChars, null);
/*  23 */     assert this.remainingChars.containsAllOf(basedSequence) : "child " + paramNode.toAstString(false) + " is not within remaining sequence " + Node.toSegmentSpan(this.remainingChars, null);
/*  24 */     paramNode.unlink();
/*  25 */     if (!(paramNode instanceof Text)) {
/*  26 */       if (this.remainingChars.getStartOffset() < basedSequence.getStartOffset())
/*     */       {
/*  28 */         this.list.add(new Text(this.remainingChars.subSequence(0, basedSequence.getStartOffset() - this.remainingChars.getStartOffset())));
/*     */       }
/*     */ 
/*     */       
/*  32 */       this.remainingChars = (BasedSequence)this.remainingChars.subSequence(basedSequence.getEndOffset() - this.remainingChars.getStartOffset());
/*  33 */       this.list.add(paramNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChildrenOf(Node paramNode) {
/*  38 */     paramNode = paramNode.getFirstChild();
/*  39 */     while (paramNode != null) {
/*  40 */       Node node = paramNode.getNext();
/*  41 */       appendChild(paramNode);
/*  42 */       paramNode = node;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void appendMergedTo(Node paramNode) {
/*  47 */     mergeList();
/*  48 */     for (Node node : this.list) {
/*  49 */       paramNode.appendChild(node);
/*     */     }
/*  51 */     clear();
/*     */   }
/*     */   
/*     */   public void clear() {
/*  55 */     this.list.clear();
/*  56 */     this.remainingChars = BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertMergedBefore(Node paramNode) {
/*  61 */     mergeList();
/*  62 */     for (Node node : this.list) {
/*  63 */       paramNode.insertBefore(node);
/*     */     }
/*  65 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void mergeTextNodes(Node paramNode) {
/*  70 */     Node node = null;
/*  71 */     paramNode = paramNode.getFirstChild();
/*  72 */     while (paramNode != null) {
/*  73 */       Node node1 = paramNode.getNext();
/*  74 */       if (node instanceof Text && paramNode instanceof Text && node.getChars().isContinuedBy(paramNode.getChars())) {
/*     */         
/*  76 */         paramNode.setChars(node.getChars().spliceAtEnd(paramNode.getChars()));
/*  77 */         node.unlink();
/*     */       } 
/*  79 */       node = paramNode;
/*  80 */       paramNode = node1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertMergedAfter(Node paramNode) {
/*  86 */     mergeList();
/*  87 */     for (Node node : this.list) {
/*  88 */       paramNode.insertAfter(node);
/*  89 */       paramNode = node;
/*     */     } 
/*  91 */     clear();
/*     */   }
/*     */   
/*     */   private void mergeList() {
/*  95 */     if (!this.remainingChars.isEmpty()) {
/*  96 */       this.list.add(new Text(this.remainingChars));
/*  97 */       this.remainingChars = BasedSequence.NULL;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Node> getMergedList() {
/* 102 */     mergeList();
/* 103 */     return this.list;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\TextNodeConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */