/*     */ package com.vladsch.flexmark.parser.core.delimiter;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*     */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Delimiter
/*     */   implements DelimiterRun
/*     */ {
/*     */   private final Text node;
/*     */   private final BasedSequence input;
/*     */   private final char delimiterChar;
/*     */   private int index;
/*     */   private final boolean canOpen;
/*     */   private final boolean canClose;
/*     */   private boolean matched = false;
/*     */   private Delimiter previous;
/*     */   private Delimiter next;
/*  33 */   private int numDelims = 1;
/*     */ 
/*     */   
/*     */   public Delimiter getPrevious() {
/*  37 */     return this.previous;
/*     */   }
/*     */ 
/*     */   
/*     */   public Delimiter getNext() {
/*  42 */     return this.next;
/*     */   }
/*     */   
/*     */   public void setMatched(boolean paramBoolean) {
/*  46 */     this.matched = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setPrevious(Delimiter paramDelimiter) {
/*  50 */     this.previous = paramDelimiter;
/*     */   }
/*     */   
/*     */   public void setNext(Delimiter paramDelimiter) {
/*  54 */     this.next = paramDelimiter;
/*     */   }
/*     */   
/*     */   public void setNumDelims(int paramInt) {
/*  58 */     this.numDelims = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getDelimiterChar() {
/*  63 */     return this.delimiterChar;
/*     */   }
/*     */   
/*     */   public boolean isMatched() {
/*  67 */     return this.matched;
/*     */   }
/*     */   
/*     */   public int getNumDelims() {
/*  71 */     return this.numDelims;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text getNode() {
/*  76 */     return this.node;
/*     */   }
/*     */   
/*     */   public BasedSequence getInput() {
/*  80 */     return this.input;
/*     */   }
/*     */   
/*     */   public int getStartIndex() {
/*  84 */     return this.index;
/*     */   }
/*     */   
/*     */   public int getEndIndex() {
/*  88 */     return this.index + this.numDelims;
/*     */   }
/*     */   
/*     */   public int getIndex() {
/*  92 */     return this.index;
/*     */   }
/*     */   
/*     */   public void setIndex(int paramInt) {
/*  96 */     this.index = paramInt;
/*     */   }
/*     */   
/*     */   public BasedSequence getTailChars(int paramInt) {
/* 100 */     return this.input.subSequence(getEndIndex() - paramInt, getEndIndex());
/*     */   }
/*     */   
/*     */   public BasedSequence getLeadChars(int paramInt) {
/* 104 */     return this.input.subSequence(getStartIndex(), getStartIndex() + paramInt);
/*     */   }
/*     */   
/*     */   public Delimiter(BasedSequence paramBasedSequence, Text paramText, char paramChar, boolean paramBoolean1, boolean paramBoolean2, Delimiter paramDelimiter, int paramInt) {
/* 108 */     this.input = paramBasedSequence;
/* 109 */     this.node = paramText;
/* 110 */     this.delimiterChar = paramChar;
/* 111 */     this.canOpen = paramBoolean1;
/* 112 */     this.canClose = paramBoolean2;
/* 113 */     this.previous = paramDelimiter;
/* 114 */     this.index = paramInt;
/*     */   }
/*     */   
/*     */   public Text getPreviousNonDelimiterTextNode() {
/*     */     Node node;
/* 119 */     if (node = this.node.getPrevious() instanceof Text && (this.previous == null || this.previous.node != node)) {
/* 120 */       return (Text)node;
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text getNextNonDelimiterTextNode() {
/*     */     Node node;
/* 128 */     if (node = this.node.getNext() instanceof Text && (this.next == null || this.next.node != node)) {
/* 129 */       return (Text)node;
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveNodesBetweenDelimitersTo(DelimitedNode paramDelimitedNode, Delimiter paramDelimiter) {
/* 136 */     Node node = getNode().getNext();
/* 137 */     while (node != null && node != paramDelimiter.getNode()) {
/* 138 */       Node node1 = node.getNext();
/* 139 */       ((Node)paramDelimitedNode).appendChild(node);
/* 140 */       node = node1;
/*     */     } 
/*     */     
/* 143 */     paramDelimitedNode.setText(this.input.subSequence(getEndIndex(), paramDelimiter.getStartIndex()));
/* 144 */     getNode().insertAfter((Node)paramDelimitedNode);
/*     */   }
/*     */   
/*     */   public void convertDelimitersToText(int paramInt, Delimiter paramDelimiter) {
/*     */     Text text1;
/* 149 */     (text1 = new Text()).setChars(getTailChars(paramInt));
/*     */     Text text2;
/* 151 */     (text2 = new Text()).setChars(paramDelimiter.getLeadChars(paramInt));
/*     */     
/* 153 */     getNode().insertAfter((Node)text1);
/* 154 */     paramDelimiter.getNode().insertBefore((Node)text2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canOpen() {
/* 159 */     return this.canOpen;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canClose() {
/* 164 */     return this.canClose;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 169 */     return this.numDelims;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\delimiter\Delimiter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */