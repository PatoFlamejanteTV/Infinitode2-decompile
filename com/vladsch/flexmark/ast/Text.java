/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TextContainer;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public final class Text
/*    */   extends Node
/*    */   implements TextContainer
/*    */ {
/*    */   public Text() {}
/*    */   
/*    */   public Text(BasedSequence paramBasedSequence) {
/* 20 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Text(String paramString) {
/* 24 */     super(BasedSequence.of(paramString));
/*    */   }
/*    */   
/*    */   public Text(String paramString, BasedSequence paramBasedSequence) {
/* 28 */     super((BasedSequence)PrefixedSubSequence.prefixOf(paramString, paramBasedSequence));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final BasedSequence[] getSegments() {
/* 34 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor) {
/* 39 */     if (BitFieldSet.any(paramInt, F_NODE_TEXT)) {
/* 40 */       paramISequenceBuilder.append((CharSequence)getChars());
/*    */     } else {
/* 42 */       ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(getChars());
/*    */       BasedSequence basedSequence;
/* 44 */       if (!(basedSequence = Escaping.unescape(getChars(), replacedTextMapper)).isEmpty()) paramISequenceBuilder.append((CharSequence)basedSequence); 
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void getAstExtra(StringBuilder paramStringBuilder) {
/* 51 */     astExtraChars(paramStringBuilder);
/* 52 */     if (getChars() instanceof PrefixedSubSequence) {
/* 53 */       astChars(paramStringBuilder, (CharSequence)getChars(), "text");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final String toStringAttributes() {
/* 60 */     return "text=" + getChars();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */