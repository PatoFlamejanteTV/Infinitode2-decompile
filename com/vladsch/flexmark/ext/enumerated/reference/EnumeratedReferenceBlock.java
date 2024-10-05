/*     */ package com.vladsch.flexmark.ext.enumerated.reference;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.ParagraphItemContainer;
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
/*     */ public class EnumeratedReferenceBlock
/*     */   extends Block
/*     */   implements ParagraphItemContainer, ReferenceNode<EnumeratedReferenceRepository, EnumeratedReferenceBlock, EnumeratedReferenceText>
/*     */ {
/*  19 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  20 */   protected BasedSequence text = BasedSequence.NULL;
/*  21 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*  22 */   protected BasedSequence enumeratedReference = BasedSequence.NULL;
/*     */ 
/*     */   
/*     */   public int compareTo(EnumeratedReferenceBlock paramEnumeratedReferenceBlock) {
/*  26 */     return SequenceUtils.compare((CharSequence)this.text, (CharSequence)paramEnumeratedReferenceBlock.text, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumeratedReferenceText getReferencingNode(Node paramNode) {
/*  32 */     return (paramNode instanceof EnumeratedReferenceText) ? (EnumeratedReferenceText)paramNode : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  37 */     segmentSpan(paramStringBuilder, this.openingMarker, "open");
/*  38 */     segmentSpan(paramStringBuilder, this.text, "text");
/*  39 */     segmentSpan(paramStringBuilder, this.closingMarker, "close");
/*  40 */     segmentSpan(paramStringBuilder, this.enumeratedReference, "enumeratedReference");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  46 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker, this.enumeratedReference };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumeratedReferenceBlock(BasedSequence paramBasedSequence) {
/*  53 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  57 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  61 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/*  65 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/*  69 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  73 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/*  77 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getEnumeratedReference() {
/*  81 */     return this.enumeratedReference;
/*     */   }
/*     */   
/*     */   public void setEnumeratedReference(BasedSequence paramBasedSequence) {
/*  85 */     this.enumeratedReference = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemParagraph(Paragraph paramParagraph) {
/*  90 */     return (paramParagraph == getFirstChild());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder) {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphInTightListItem(Paragraph paramParagraph) {
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   public EnumeratedReferenceBlock() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */