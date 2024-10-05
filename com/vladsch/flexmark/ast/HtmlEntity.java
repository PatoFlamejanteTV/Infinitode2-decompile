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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HtmlEntity
/*    */   extends Node
/*    */   implements TextContainer
/*    */ {
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 22 */     if (!getChars().isEmpty()) paramStringBuilder.append(" \"").append((CharSequence)getChars()).append("\"");
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 29 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlEntity() {}
/*    */   
/*    */   public HtmlEntity(BasedSequence paramBasedSequence) {
/* 36 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 41 */     if (BitFieldSet.any(paramInt, F_NODE_TEXT)) {
/* 42 */       paramISequenceBuilder.append((CharSequence)getChars());
/*    */     } else {
/* 44 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(getChars());
/* 45 */       BasedSequence basedSequence = Escaping.unescape(getChars(), replacedTextMapper);
/* 46 */       paramISequenceBuilder.append((CharSequence)basedSequence);
/*    */     } 
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */