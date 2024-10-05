/*    */ package com.vladsch.flexmark.ext.abbreviation;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationRepository;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbbreviationBlock
/*    */   extends Block
/*    */   implements ReferenceNode<AbbreviationRepository, AbbreviationBlock, Abbreviation>
/*    */ {
/* 16 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 17 */   protected BasedSequence text = BasedSequence.NULL;
/* 18 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/* 19 */   protected BasedSequence abbreviation = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */   
/*    */   public Abbreviation getReferencingNode(Node paramNode) {
/* 24 */     return (paramNode instanceof Abbreviation) ? (Abbreviation)paramNode : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(AbbreviationBlock paramAbbreviationBlock) {
/* 29 */     return SequenceUtils.compare((CharSequence)this.text, (CharSequence)paramAbbreviationBlock.text, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 34 */     segmentSpan(paramStringBuilder, this.openingMarker, "open");
/* 35 */     segmentSpan(paramStringBuilder, this.text, "text");
/* 36 */     segmentSpan(paramStringBuilder, this.closingMarker, "close");
/* 37 */     segmentSpan(paramStringBuilder, this.abbreviation, "abbreviation");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 43 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker, this.abbreviation };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbbreviationBlock(BasedSequence paramBasedSequence) {
/* 50 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 54 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 58 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 62 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 66 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 70 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 74 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getAbbreviation() {
/* 78 */     return this.abbreviation;
/*    */   }
/*    */   
/*    */   public void setAbbreviation(BasedSequence paramBasedSequence) {
/* 82 */     this.abbreviation = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public AbbreviationBlock() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\AbbreviationBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */