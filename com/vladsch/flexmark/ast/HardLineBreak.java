/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotTrim;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public class HardLineBreak
/*    */   extends Node
/*    */   implements DoNotTrim, TextContainer
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 15 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public HardLineBreak() {}
/*    */   
/*    */   public HardLineBreak(BasedSequence paramBasedSequence) {
/* 22 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 27 */     BasedSequence basedSequence = getChars();
/* 28 */     paramISequenceBuilder.add((CharSequence)basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HardLineBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */