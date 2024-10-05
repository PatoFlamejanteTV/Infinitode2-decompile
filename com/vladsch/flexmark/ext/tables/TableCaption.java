/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.LineBreakNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class TableCaption
/*    */   extends Node
/*    */   implements DelimitedNode, LineBreakNode
/*    */ {
/* 13 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 14 */   protected BasedSequence text = BasedSequence.NULL;
/* 15 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */   
/*    */   public TableCaption(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 18 */     this.openingMarker = paramBasedSequence1;
/* 19 */     this.text = paramBasedSequence2;
/* 20 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public TableCaption(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4) {
/* 24 */     super(paramBasedSequence1);
/* 25 */     this.openingMarker = paramBasedSequence2;
/* 26 */     this.text = paramBasedSequence3;
/* 27 */     this.closingMarker = paramBasedSequence4;
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 32 */     return this.openingMarker;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 37 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence getText() {
/* 42 */     return this.text;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 47 */     this.text = paramBasedSequence;
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 52 */     return this.closingMarker;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 57 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 63 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 68 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableCaption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */