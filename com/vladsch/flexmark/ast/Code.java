/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotLinkDecorate;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public class Code
/*    */   extends DelimitedNodeImpl
/*    */   implements DoNotLinkDecorate {
/*    */   public Code() {}
/*    */   
/*    */   public Code(BasedSequence paramBasedSequence) {
/* 14 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Code(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 18 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3);
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 23 */     delimitedSegmentSpan(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 28 */     paramISequenceBuilder.append((CharSequence)getText());
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Code.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */