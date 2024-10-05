/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequenceImpl;
/*    */ 
/*    */ 
/*    */ public class DelimitedLinkNode
/*    */   extends LinkNode
/*    */ {
/*    */   public DelimitedLinkNode() {}
/*    */   
/*    */   public DelimitedLinkNode(BasedSequence paramBasedSequence) {
/* 13 */     super(paramBasedSequence);
/*    */   }
/*    */   
/* 16 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 17 */   protected BasedSequence text = BasedSequence.NULL;
/* 18 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 23 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 28 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */   
/*    */   public BasedSequence getLeadSegment() {
/* 32 */     return BasedSequenceImpl.firstNonNull(new BasedSequence[] { this.openingMarker, this.text });
/*    */   }
/*    */   
/*    */   public DelimitedLinkNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 36 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 37 */     this.openingMarker = paramBasedSequence1;
/* 38 */     this.text = paramBasedSequence2;
/* 39 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 43 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 47 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 51 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 55 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 59 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 63 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\DelimitedLinkNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */