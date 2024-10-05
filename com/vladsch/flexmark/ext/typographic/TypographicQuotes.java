/*    */ package com.vladsch.flexmark.ext.typographic;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.DoNotAttributeDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.TypographicText;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class TypographicQuotes
/*    */   extends Node
/*    */   implements DelimitedNode, DoNotAttributeDecorate, TypographicText
/*    */ {
/* 14 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 15 */   protected BasedSequence text = BasedSequence.NULL;
/* 16 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */   
/*    */   protected String typographicOpening;
/*    */   
/*    */   protected String typographicClosing;
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 24 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 29 */     if (this.openingMarker.isNotNull()) paramStringBuilder.append(" typographicOpening: ").append(this.typographicOpening).append(" "); 
/* 30 */     if (this.closingMarker.isNotNull()) paramStringBuilder.append(" typographicClosing: ").append(this.typographicClosing).append(" "); 
/* 31 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public TypographicQuotes() {}
/*    */   
/*    */   public TypographicQuotes(BasedSequence paramBasedSequence) {
/* 38 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TypographicQuotes(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 42 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 43 */     this.openingMarker = paramBasedSequence1;
/* 44 */     this.text = paramBasedSequence2;
/* 45 */     this.closingMarker = paramBasedSequence3;
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
/*    */   
/*    */   public String getTypographicOpening() {
/* 73 */     return this.typographicOpening;
/*    */   }
/*    */   
/*    */   public void setTypographicOpening(String paramString) {
/* 77 */     this.typographicOpening = paramString;
/*    */   }
/*    */   
/*    */   public String getTypographicClosing() {
/* 81 */     return this.typographicClosing;
/*    */   }
/*    */   
/*    */   public void setTypographicClosing(String paramString) {
/* 85 */     this.typographicClosing = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\TypographicQuotes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */