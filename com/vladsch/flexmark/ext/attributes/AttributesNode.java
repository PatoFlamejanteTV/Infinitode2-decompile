/*    */ package com.vladsch.flexmark.ext.attributes;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NonRenderingInline;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class AttributesNode
/*    */   extends Node
/*    */   implements DelimitedNode, DoNotDecorate, NonRenderingInline
/*    */ {
/* 14 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 15 */   protected BasedSequence text = BasedSequence.NULL;
/* 16 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 22 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 27 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public AttributesNode() {}
/*    */   
/*    */   public AttributesNode(BasedSequence paramBasedSequence) {
/* 34 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public AttributesNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 38 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 39 */     this.openingMarker = paramBasedSequence1;
/* 40 */     this.text = paramBasedSequence2;
/* 41 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public AttributesNode(BasedSequence paramBasedSequence, String paramString) {
/* 45 */     super(paramBasedSequence);
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\AttributesNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */