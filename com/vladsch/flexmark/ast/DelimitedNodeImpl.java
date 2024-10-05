/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public abstract class DelimitedNodeImpl
/*    */   extends Node implements DelimitedNode {
/*  9 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 10 */   protected BasedSequence text = BasedSequence.NULL;
/* 11 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 15 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 21 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public DelimitedNodeImpl() {}
/*    */   
/*    */   public DelimitedNodeImpl(BasedSequence paramBasedSequence) {
/* 28 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public DelimitedNodeImpl(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 32 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/*    */     
/* 34 */     this.openingMarker = paramBasedSequence1;
/* 35 */     this.text = paramBasedSequence2;
/* 36 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 40 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 44 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 48 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 52 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 56 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 60 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\DelimitedNodeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */