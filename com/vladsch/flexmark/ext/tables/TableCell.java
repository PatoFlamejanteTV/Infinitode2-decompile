/*     */ package com.vladsch.flexmark.ext.tables;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.util.TextNodeConverter;
/*     */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.html.CellAlignment;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableCell
/*     */   extends Node
/*     */   implements DelimitedNode
/*     */ {
/*  16 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  17 */   protected BasedSequence text = BasedSequence.NULL;
/*  18 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */   
/*     */   private boolean header;
/*     */   private Alignment alignment;
/*  22 */   private int span = 1;
/*     */ 
/*     */   
/*     */   public void trimWhiteSpace() {
/*  26 */     Node node1 = getFirstChild(), node2 = node1;
/*     */     
/*  28 */     while (node2 instanceof com.vladsch.flexmark.ast.WhiteSpace) {
/*  29 */       Node node = node2.getNext();
/*  30 */       node2.unlink();
/*  31 */       node2 = node;
/*     */     } 
/*     */     
/*  34 */     node2 = getLastChild();
/*  35 */     while (node2 instanceof com.vladsch.flexmark.ast.WhiteSpace) {
/*  36 */       Node node = node2.getPrevious();
/*  37 */       node2.unlink();
/*  38 */       node2 = node;
/*     */     } 
/*     */     
/*  41 */     if (getFirstChild() == null && node1 != null) {
/*     */       
/*  43 */       Text text = new Text(node1.getChars().subSequence(0, 1));
/*  44 */       appendChild((Node)text);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mergeWhiteSpace() {
/*  49 */     boolean bool = false;
/*  50 */     Node node = getFirstChild();
/*     */     
/*  52 */     while (node instanceof com.vladsch.flexmark.ast.WhiteSpace) {
/*  53 */       Node node1 = node.getNext();
/*  54 */       Text text = new Text(node.getChars());
/*  55 */       node.insertBefore((Node)text);
/*  56 */       node.unlink();
/*  57 */       node = node1;
/*  58 */       boolean bool1 = true;
/*     */     } 
/*     */     
/*  61 */     node = getLastChild();
/*  62 */     while (node instanceof com.vladsch.flexmark.ast.WhiteSpace) {
/*  63 */       Node node1 = node.getPrevious();
/*  64 */       Text text = new Text(node.getChars());
/*  65 */       node.insertBefore((Node)text);
/*  66 */       node.unlink();
/*  67 */       node = node1;
/*  68 */       bool = true;
/*     */     } 
/*     */     
/*  71 */     if (bool) {
/*  72 */       TextNodeConverter.mergeTextNodes(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  78 */     return this.openingMarker;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  83 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getText() {
/*  88 */     return this.text;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/*  93 */     this.text = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  98 */     return this.closingMarker;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 103 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public int getSpan() {
/* 107 */     return this.span;
/*     */   }
/*     */   
/*     */   public void setSpan(int paramInt) {
/* 111 */     this.span = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/* 117 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 122 */     if (this.alignment != null) paramStringBuilder.append(" ").append(this.alignment); 
/* 123 */     if (this.header) paramStringBuilder.append(" header"); 
/* 124 */     if (this.span > 1) paramStringBuilder.append(" span=" + this.span); 
/* 125 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*     */   }
/*     */ 
/*     */   
/*     */   public TableCell() {}
/*     */   
/*     */   public TableCell(BasedSequence paramBasedSequence) {
/* 132 */     super(paramBasedSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHeader() {
/* 139 */     return this.header;
/*     */   }
/*     */   
/*     */   public void setHeader(boolean paramBoolean) {
/* 143 */     this.header = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Alignment getAlignment() {
/* 150 */     return this.alignment;
/*     */   }
/*     */   
/*     */   public void setAlignment(Alignment paramAlignment) {
/* 154 */     this.alignment = paramAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Alignment
/*     */   {
/* 161 */     LEFT, CENTER, RIGHT;
/*     */     
/*     */     public final CellAlignment cellAlignment() {
/* 164 */       switch (this) {
/*     */         case CENTER:
/* 166 */           return CellAlignment.CENTER;
/*     */         case LEFT:
/* 168 */           return CellAlignment.LEFT;
/*     */         case RIGHT:
/* 170 */           return CellAlignment.RIGHT;
/*     */       } 
/* 172 */       return CellAlignment.NONE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableCell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */