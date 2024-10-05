/*     */ package com.vladsch.flexmark.ext.footnotes;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.ParagraphItemContainer;
/*     */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteRepository;
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FootnoteBlock
/*     */   extends Block
/*     */   implements ParagraphItemContainer, ReferenceNode<FootnoteRepository, FootnoteBlock, Footnote>
/*     */ {
/*  20 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  21 */   protected BasedSequence text = BasedSequence.NULL;
/*  22 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*  23 */   protected BasedSequence footnote = BasedSequence.NULL;
/*  24 */   private int footnoteOrdinal = 0;
/*  25 */   private int firstReferenceOffset = Integer.MAX_VALUE;
/*  26 */   private int footnoteReferences = 0;
/*     */ 
/*     */   
/*     */   public int compareTo(FootnoteBlock paramFootnoteBlock) {
/*  30 */     return SequenceUtils.compare((CharSequence)this.text, (CharSequence)paramFootnoteBlock.text, true);
/*     */   }
/*     */   
/*     */   public int getFootnoteReferences() {
/*  34 */     return this.footnoteReferences;
/*     */   }
/*     */   
/*     */   public void setFootnoteReferences(int paramInt) {
/*  38 */     this.footnoteReferences = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Footnote getReferencingNode(Node paramNode) {
/*  44 */     return (paramNode instanceof Footnote) ? (Footnote)paramNode : null;
/*     */   }
/*     */   
/*     */   public int getFirstReferenceOffset() {
/*  48 */     return this.firstReferenceOffset;
/*     */   }
/*     */   
/*     */   public void setFirstReferenceOffset(int paramInt) {
/*  52 */     this.firstReferenceOffset = paramInt;
/*     */   }
/*     */   
/*     */   public void addFirstReferenceOffset(int paramInt) {
/*  56 */     if (this.firstReferenceOffset < paramInt) this.firstReferenceOffset = paramInt; 
/*     */   }
/*     */   
/*     */   public boolean isReferenced() {
/*  60 */     return (this.firstReferenceOffset < Integer.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public int getFootnoteOrdinal() {
/*  64 */     return this.footnoteOrdinal;
/*     */   }
/*     */   
/*     */   public void setFootnoteOrdinal(int paramInt) {
/*  68 */     this.footnoteOrdinal = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  73 */     paramStringBuilder.append(" ordinal: ").append(this.footnoteOrdinal).append(" ");
/*  74 */     segmentSpan(paramStringBuilder, this.openingMarker, "open");
/*  75 */     segmentSpan(paramStringBuilder, this.text, "text");
/*  76 */     segmentSpan(paramStringBuilder, this.closingMarker, "close");
/*  77 */     segmentSpan(paramStringBuilder, this.footnote, "footnote");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  83 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker, this.footnote };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FootnoteBlock(BasedSequence paramBasedSequence) {
/*  90 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  94 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  98 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/* 102 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/* 106 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 110 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 114 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getFootnote() {
/* 118 */     return this.footnote;
/*     */   }
/*     */   
/*     */   public void setFootnote(BasedSequence paramBasedSequence) {
/* 122 */     this.footnote = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemParagraph(Paragraph paramParagraph) {
/* 127 */     return (paramParagraph == getFirstChild());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder) {
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphInTightListItem(Paragraph paramParagraph) {
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public FootnoteBlock() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\FootnoteBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */