/*    */ package com.vladsch.flexmark.ext.escaped.character;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class EscapedCharacter
/*    */   extends Node
/*    */   implements DoNotDecorate
/*    */ {
/* 12 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 13 */   protected BasedSequence text = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 19 */     return new BasedSequence[] { this.openingMarker, this.text };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 24 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, BasedSequence.NULL, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public EscapedCharacter() {}
/*    */   
/*    */   public EscapedCharacter(BasedSequence paramBasedSequence) {
/* 31 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public EscapedCharacter(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/* 35 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence2.getEndOffset()));
/* 36 */     this.openingMarker = paramBasedSequence1;
/* 37 */     this.text = paramBasedSequence2;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 41 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 45 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 49 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 53 */     this.text = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\escaped\character\EscapedCharacter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */