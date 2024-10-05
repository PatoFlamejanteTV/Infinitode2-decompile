/*    */ package com.vladsch.flexmark.ext.emoji;
/*    */ 
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public class Emoji
/*    */   extends Node
/*    */   implements DelimitedNode, TextContainer
/*    */ {
/* 17 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 18 */   protected BasedSequence text = BasedSequence.NULL;
/* 19 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 24 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 29 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public Emoji() {}
/*    */   
/*    */   public Emoji(BasedSequence paramBasedSequence) {
/* 36 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Emoji(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 40 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 41 */     this.openingMarker = paramBasedSequence1;
/* 42 */     this.text = paramBasedSequence2;
/* 43 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 47 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 51 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 55 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 59 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 63 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 67 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 72 */     if (BitFieldSet.any(paramInt, F_FOR_HEADING_ID) && (
/* 73 */       (Boolean)HtmlRenderer.HEADER_ID_ADD_EMOJI_SHORTCUT.get((DataHolder)getDocument())).booleanValue()) {
/* 74 */       paramISequenceBuilder.append((CharSequence)this.text);
/*    */     }
/*    */     
/* 77 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\Emoji.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */