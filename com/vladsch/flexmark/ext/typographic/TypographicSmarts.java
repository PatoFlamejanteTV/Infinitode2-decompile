/*    */ package com.vladsch.flexmark.ext.typographic;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotAttributeDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.TypographicText;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TypographicSmarts
/*    */   extends Node
/*    */   implements DoNotAttributeDecorate, TypographicText
/*    */ {
/*    */   private String typographicText;
/*    */   
/*    */   public TypographicSmarts() {}
/*    */   
/*    */   public TypographicSmarts(BasedSequence paramBasedSequence) {
/* 25 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TypographicSmarts(String paramString) {
/* 29 */     this.typographicText = paramString;
/*    */   }
/*    */   
/*    */   public TypographicSmarts(BasedSequence paramBasedSequence, String paramString) {
/* 33 */     super(paramBasedSequence);
/* 34 */     this.typographicText = paramString;
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
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 51 */     paramStringBuilder.append(" typographic: ").append(this.typographicText).append(" ");
/*    */   }
/*    */   
/*    */   public String getTypographicText() {
/* 55 */     return this.typographicText;
/*    */   }
/*    */   
/*    */   public void setTypographicText(String paramString) {
/* 59 */     this.typographicText = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 65 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String toStringAttributes() {
/* 71 */     return "text=" + getChars();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\TypographicSmarts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */