/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public interface DelimitedNode
/*    */   extends TextContainer
/*    */ {
/*    */   BasedSequence getOpeningMarker();
/*    */   
/*    */   BasedSequence getChars();
/*    */   
/*    */   void setOpeningMarker(BasedSequence paramBasedSequence);
/*    */   
/*    */   BasedSequence getText();
/*    */   
/*    */   void setText(BasedSequence paramBasedSequence);
/*    */   
/*    */   BasedSequence getClosingMarker();
/*    */   
/*    */   void setClosingMarker(BasedSequence paramBasedSequence);
/*    */   
/*    */   default boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 25 */     if (BitFieldSet.any(paramInt, F_NODE_TEXT)) {
/* 26 */       paramISequenceBuilder.append((CharSequence)getText());
/* 27 */       return false;
/*    */     } 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\DelimitedNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */