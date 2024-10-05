/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public class TextBase
/*    */   extends Node
/*    */   implements TextContainer
/*    */ {
/*    */   public TextBase() {}
/*    */   
/*    */   public TextBase(BasedSequence paramBasedSequence) {
/* 19 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TextBase(String paramString) {
/* 23 */     super(BasedSequence.of(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 29 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 34 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 39 */     if (BitFieldSet.any(paramInt, F_NODE_TEXT)) {
/* 40 */       paramISequenceBuilder.append((CharSequence)getChars());
/*    */     } else {
/* 42 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(getChars());
/* 43 */       BasedSequence basedSequence = Escaping.unescape(getChars(), replacedTextMapper);
/* 44 */       paramISequenceBuilder.append((CharSequence)basedSequence);
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String toStringAttributes() {
/* 52 */     return "text=" + getChars();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\TextBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */