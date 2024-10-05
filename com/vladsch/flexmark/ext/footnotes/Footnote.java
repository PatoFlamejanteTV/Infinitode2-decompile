/*     */ package com.vladsch.flexmark.ext.footnotes;
/*     */ import com.vladsch.flexmark.ast.LinkRendered;
/*     */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteRepository;
/*     */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class Footnote extends Node implements LinkRendered, DelimitedNode, DoNotDecorate, ReferencingNode<FootnoteRepository, FootnoteBlock> {
/*  13 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  14 */   protected BasedSequence text = BasedSequence.NULL;
/*  15 */   protected BasedSequence closingMarker = BasedSequence.NULL; protected FootnoteBlock footnoteBlock;
/*     */   protected int referenceOrdinal;
/*     */   
/*     */   public int getReferenceOrdinal() {
/*  19 */     return this.referenceOrdinal;
/*     */   }
/*     */   
/*     */   public void setReferenceOrdinal(int paramInt) {
/*  23 */     this.referenceOrdinal = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getReference() {
/*  31 */     return this.text;
/*     */   }
/*     */ 
/*     */   
/*     */   public FootnoteBlock getReferenceNode(Document paramDocument) {
/*  36 */     if (this.footnoteBlock != null || this.text.isEmpty()) return this.footnoteBlock; 
/*  37 */     this.footnoteBlock = getFootnoteBlock((FootnoteRepository)FootnoteExtension.FOOTNOTES.get((DataHolder)paramDocument));
/*  38 */     return this.footnoteBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   public FootnoteBlock getReferenceNode(FootnoteRepository paramFootnoteRepository) {
/*  43 */     if (this.footnoteBlock != null || this.text.isEmpty()) return this.footnoteBlock; 
/*  44 */     this.footnoteBlock = getFootnoteBlock(paramFootnoteRepository);
/*  45 */     return this.footnoteBlock;
/*     */   }
/*     */   
/*     */   public boolean isDefined() {
/*  49 */     return (this.footnoteBlock != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTentative() {
/*  57 */     return (this.footnoteBlock == null);
/*     */   }
/*     */   
/*     */   public FootnoteBlock getFootnoteBlock(FootnoteRepository paramFootnoteRepository) {
/*  61 */     return this.text.isEmpty() ? null : (FootnoteBlock)paramFootnoteRepository.get(this.text.toString());
/*     */   }
/*     */   
/*     */   public FootnoteBlock getFootnoteBlock() {
/*  65 */     return this.footnoteBlock;
/*     */   }
/*     */   
/*     */   public void setFootnoteBlock(FootnoteBlock paramFootnoteBlock) {
/*  69 */     this.footnoteBlock = paramFootnoteBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  75 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  80 */     paramStringBuilder.append(" ordinal: ").append((this.footnoteBlock != null) ? this.footnoteBlock.getFootnoteOrdinal() : 0).append(" ");
/*  81 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Footnote(BasedSequence paramBasedSequence) {
/*  88 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public Footnote(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  92 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/*  93 */     this.openingMarker = paramBasedSequence1;
/*  94 */     this.text = paramBasedSequence2;
/*  95 */     this.closingMarker = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  99 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 103 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/* 107 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/* 111 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 115 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 119 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public Footnote() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\Footnote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */