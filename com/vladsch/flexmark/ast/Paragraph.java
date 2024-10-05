/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.TextContainer;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Paragraph
/*     */   extends Block implements TextContainer {
/*  14 */   private static final int[] EMPTY_INDENTS = new int[0];
/*  15 */   private int[] lineIndents = EMPTY_INDENTS;
/*     */   
/*     */   private boolean trailingBlankLine = false;
/*     */   
/*     */   private boolean hasTableSeparator;
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  22 */     return EMPTY_SEGMENTS;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  27 */     super.getAstExtra(paramStringBuilder);
/*  28 */     if (this.trailingBlankLine) paramStringBuilder.append(" isTrailingBlankLine");
/*     */   
/*     */   }
/*     */   
/*     */   public Paragraph() {}
/*     */   
/*     */   public Paragraph(BasedSequence paramBasedSequence) {
/*  35 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public Paragraph(BasedSequence paramBasedSequence, List<BasedSequence> paramList, List<Integer> paramList1) {
/*  39 */     super(paramBasedSequence, paramList);
/*  40 */     if (paramList.size() != paramList1.size())
/*  41 */       throw new IllegalArgumentException("line segments and line indents have to be of the same size"); 
/*  42 */     setLineIndents(paramList1);
/*     */   }
/*     */   
/*     */   public Paragraph(BasedSequence paramBasedSequence, List<BasedSequence> paramList, int[] paramArrayOfint) {
/*  46 */     super(paramBasedSequence, paramList);
/*  47 */     if (paramList.size() != paramArrayOfint.length)
/*  48 */       throw new IllegalArgumentException("line segments and line indents have to be of the same size"); 
/*  49 */     this.lineIndents = paramArrayOfint;
/*     */   }
/*     */   
/*     */   public Paragraph(BlockContent paramBlockContent) {
/*  53 */     super(paramBlockContent);
/*  54 */     setLineIndents(paramBlockContent.getLineIndents());
/*     */   }
/*     */   
/*     */   protected void setLineIndents(List<Integer> paramList) {
/*  58 */     this.lineIndents = new int[paramList.size()];
/*  59 */     byte b = 0;
/*  60 */     for (Iterator<Integer> iterator = paramList.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  61 */       this.lineIndents[b++] = i; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContent(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/*  69 */     super.setContent(paramBasedSequence, paramList);
/*     */   }
/*     */   
/*     */   public void setContent(BasedSequence paramBasedSequence, List<BasedSequence> paramList, List<Integer> paramList1) {
/*  73 */     super.setContent(paramBasedSequence, paramList);
/*  74 */     if (paramList.size() != paramList1.size())
/*  75 */       throw new IllegalArgumentException("line segments and line indents have to be of the same size"); 
/*  76 */     setLineIndents(paramList1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContent(List<BasedSequence> paramList) {
/*  83 */     super.setContent(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContent(BlockContent paramBlockContent) {
/*  88 */     super.setContent(paramBlockContent);
/*  89 */     setLineIndents(paramBlockContent.getLineIndents());
/*     */   }
/*     */   
/*     */   public void setContent(BlockContent paramBlockContent, int paramInt1, int paramInt2) {
/*  93 */     super.setContent(paramBlockContent.getLines().subList(paramInt1, paramInt2));
/*  94 */     setLineIndents(paramBlockContent.getLineIndents().subList(paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public void setContent(Paragraph paramParagraph, int paramInt1, int paramInt2) {
/*  98 */     super.setContent(paramParagraph.getContentLines(paramInt1, paramInt2));
/*  99 */     if (paramInt2 > paramInt1) {
/* 100 */       int[] arrayOfInt = new int[paramInt2 - paramInt1];
/* 101 */       System.arraycopy(paramParagraph.lineIndents, paramInt1, arrayOfInt, 0, paramInt2 - paramInt1);
/* 102 */       this.lineIndents = arrayOfInt; return;
/*     */     } 
/* 104 */     this.lineIndents = EMPTY_INDENTS;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLineIndents(int[] paramArrayOfint) {
/* 109 */     this.lineIndents = paramArrayOfint;
/*     */   }
/*     */   
/*     */   public int getLineIndent(int paramInt) {
/* 113 */     return this.lineIndents[paramInt];
/*     */   }
/*     */   
/*     */   public int[] getLineIndents() {
/* 117 */     return this.lineIndents;
/*     */   }
/*     */   
/*     */   public boolean isTrailingBlankLine() {
/* 121 */     return this.trailingBlankLine;
/*     */   }
/*     */   
/*     */   public void setTrailingBlankLine(boolean paramBoolean) {
/* 125 */     this.trailingBlankLine = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setHasTableSeparator(boolean paramBoolean) {
/* 129 */     this.hasTableSeparator = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean hasTableSeparator() {
/* 133 */     return this.hasTableSeparator;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 138 */     if (!paramISequenceBuilder.isEmpty()) {
/* 139 */       paramISequenceBuilder.add("\n\n");
/*     */     }
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Paragraph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */