/*    */ package com.vladsch.flexmark.ext.gitlab;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.ast.ParagraphContainer;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GitLabBlockQuote
/*    */   extends Block
/*    */   implements ParagraphContainer
/*    */ {
/* 16 */   private BasedSequence openingMarker = BasedSequence.NULL;
/* 17 */   private BasedSequence openingTrailing = BasedSequence.NULL;
/* 18 */   private BasedSequence closingMarker = BasedSequence.NULL;
/* 19 */   private BasedSequence closingTrailing = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 23 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/* 24 */     segmentSpanChars(paramStringBuilder, this.openingTrailing, "openTrail");
/* 25 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/* 26 */     segmentSpanChars(paramStringBuilder, this.closingTrailing, "closeTrail");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 32 */     return new BasedSequence[] { this.openingMarker, this.openingTrailing, this.closingMarker, this.closingTrailing };
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isParagraphEndWrappingDisabled(Paragraph paramParagraph) {
/* 37 */     return (paramParagraph == getLastChild() || paramParagraph.getNext() instanceof GitLabBlockQuote);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isParagraphStartWrappingDisabled(Paragraph paramParagraph) {
/* 42 */     return (paramParagraph == getFirstChild() || paramParagraph.getPrevious() instanceof GitLabBlockQuote);
/*    */   }
/*    */ 
/*    */   
/*    */   public GitLabBlockQuote() {}
/*    */   
/*    */   public GitLabBlockQuote(BasedSequence paramBasedSequence) {
/* 49 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public GitLabBlockQuote(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 53 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public GitLabBlockQuote(BlockContent paramBlockContent) {
/* 57 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 61 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 65 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 69 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 73 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningTrailing() {
/* 77 */     return this.openingTrailing;
/*    */   }
/*    */   
/*    */   public void setOpeningTrailing(BasedSequence paramBasedSequence) {
/* 81 */     this.openingTrailing = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingTrailing() {
/* 85 */     return this.closingTrailing;
/*    */   }
/*    */   
/*    */   public void setClosingTrailing(BasedSequence paramBasedSequence) {
/* 89 */     this.closingTrailing = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\GitLabBlockQuote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */