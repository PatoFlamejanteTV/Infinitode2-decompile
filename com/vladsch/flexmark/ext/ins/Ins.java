/*    */ package com.vladsch.flexmark.ext.ins;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class Ins
/*    */   extends Node
/*    */   implements DelimitedNode
/*    */ {
/* 12 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 13 */   protected BasedSequence text = BasedSequence.NULL;
/* 14 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   protected String insBlockText;
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 21 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 26 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public Ins() {}
/*    */   
/*    */   public Ins(BasedSequence paramBasedSequence) {
/* 33 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Ins(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 37 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 38 */     this.openingMarker = paramBasedSequence1;
/* 39 */     this.text = paramBasedSequence2;
/* 40 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public Ins(BasedSequence paramBasedSequence, String paramString) {
/* 44 */     super(paramBasedSequence);
/* 45 */     this.insBlockText = paramString;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 49 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 53 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 57 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 61 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 65 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 69 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\ins\Ins.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */