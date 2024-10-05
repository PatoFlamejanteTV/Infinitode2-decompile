/*    */ package com.vladsch.flexmark.ext.jekyll.tag;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JekyllTag
/*    */   extends Block
/*    */ {
/* 12 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 13 */   protected BasedSequence tag = BasedSequence.NULL;
/* 14 */   protected BasedSequence parameters = BasedSequence.NULL;
/* 15 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 21 */     return new BasedSequence[] { this.openingMarker, this.tag, this.parameters, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 26 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/* 27 */     segmentSpanChars(paramStringBuilder, this.tag, "tag");
/* 28 */     segmentSpanChars(paramStringBuilder, this.parameters, "parameters");
/* 29 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/*    */   }
/*    */ 
/*    */   
/*    */   public JekyllTag() {}
/*    */   
/*    */   public JekyllTag(BasedSequence paramBasedSequence) {
/* 36 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public JekyllTag(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4) {
/* 40 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence4.getEndOffset()));
/* 41 */     this.openingMarker = paramBasedSequence1;
/* 42 */     this.tag = paramBasedSequence2;
/* 43 */     this.parameters = paramBasedSequence3;
/* 44 */     this.closingMarker = paramBasedSequence4;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 48 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 52 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getTag() {
/* 56 */     return this.tag;
/*    */   }
/*    */   
/*    */   public void setTag(BasedSequence paramBasedSequence) {
/* 60 */     this.tag = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getParameters() {
/* 64 */     return this.parameters;
/*    */   }
/*    */   
/*    */   public void setParameters(BasedSequence paramBasedSequence) {
/* 68 */     this.parameters = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 72 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 76 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\JekyllTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */