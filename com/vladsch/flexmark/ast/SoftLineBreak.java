/*    */ package com.vladsch.flexmark.ast;
/*    */ import com.vladsch.flexmark.util.ast.DoNotAttributeDecorate;
/*    */ import com.vladsch.flexmark.util.ast.DoNotTrim;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public class SoftLineBreak extends Node implements DoNotAttributeDecorate, DoNotTrim, TextContainer {
/*    */   public BasedSequence[] getSegments() {
/* 12 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoftLineBreak() {}
/*    */   
/*    */   public SoftLineBreak(BasedSequence paramBasedSequence) {
/* 19 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setChars(BasedSequence paramBasedSequence) {
/* 24 */     super.setChars(paramBasedSequence);
/* 25 */     assert getChars().isNotEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCharsFromContentOnly() {
/* 30 */     super.setCharsFromContentOnly();
/* 31 */     assert getChars().isNotEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCharsFromContent() {
/* 36 */     super.setCharsFromContent();
/* 37 */     assert getChars().isNotEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCharsFromSegments() {
/* 42 */     super.setCharsFromSegments();
/* 43 */     assert getChars().isNotEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 48 */     paramISequenceBuilder.add((CharSequence)getChars());
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\SoftLineBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */