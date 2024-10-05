/*    */ package com.vladsch.flexmark.formatter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlankLine;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.format.MarkdownWriterBase;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*    */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*    */ 
/*    */ 
/*    */ public class MarkdownWriter
/*    */   extends MarkdownWriterBase<MarkdownWriter, Node, NodeFormatterContext>
/*    */ {
/*    */   public MarkdownWriter() {
/* 15 */     this((Appendable)null, 0);
/*    */   }
/*    */   
/*    */   public MarkdownWriter(int paramInt) {
/* 19 */     this((Appendable)null, paramInt);
/*    */   }
/*    */   
/*    */   public MarkdownWriter(Appendable paramAppendable, int paramInt) {
/* 23 */     super(paramAppendable, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MarkdownWriter getEmptyAppendable() {
/* 29 */     return new MarkdownWriter((Appendable)this.appendable, this.appendable.getOptions());
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence lastBlockQuoteChildPrefix(BasedSequence paramBasedSequence) {
/* 34 */     Node node = (Node)((NodeFormatterContext)this.context).getCurrentNode();
/* 35 */     while (node != null && node.getNextAnyNot(new Class[] { BlankLine.class }) == null && (
/*    */       
/* 37 */       node = node.getParent()) != null && !(node instanceof com.vladsch.flexmark.util.ast.Document)) {
/* 38 */       int i; if (node instanceof com.vladsch.flexmark.util.ast.BlockQuoteLike && (
/*    */         
/* 40 */         i = paramBasedSequence.lastIndexOfAny(((NodeFormatterContext)this.context).getBlockQuoteLikePrefixPredicate())) >= 0) {
/* 41 */         paramBasedSequence = ((SequenceBuilder)((SequenceBuilder)paramBasedSequence.getBuilder().append((CharSequence)paramBasedSequence.subSequence(0, i))).append(' ').append((CharSequence)paramBasedSequence.subSequence(i + 1))).toSequence();
/*    */       }
/*    */ 
/*    */ 
/*    */       
/* 46 */       node = node;
/*    */     } 
/* 48 */     return paramBasedSequence;
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendNonTranslating(CharSequence paramCharSequence) {
/* 52 */     return appendNonTranslating((CharSequence)null, paramCharSequence, (CharSequence)null, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendNonTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 56 */     return appendNonTranslating(paramCharSequence1, paramCharSequence2, (CharSequence)null, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendNonTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
/* 60 */     return appendNonTranslating(paramCharSequence1, paramCharSequence2, paramCharSequence3, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendNonTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {
/* 64 */     if (((NodeFormatterContext)this.context).isTransformingText()) {
/* 65 */       append(((NodeFormatterContext)this.context).transformNonTranslating(paramCharSequence1, paramCharSequence2, paramCharSequence3, paramCharSequence4));
/*    */     } else {
/* 67 */       append(paramCharSequence2);
/*    */     } 
/* 69 */     return this;
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendTranslating(CharSequence paramCharSequence) {
/* 73 */     return appendTranslating((CharSequence)null, paramCharSequence, (CharSequence)null, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 77 */     return appendTranslating(paramCharSequence1, paramCharSequence2, (CharSequence)null, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
/* 81 */     return appendTranslating(paramCharSequence1, paramCharSequence2, paramCharSequence3, (CharSequence)null);
/*    */   }
/*    */   
/*    */   public MarkdownWriter appendTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {
/* 85 */     if (((NodeFormatterContext)this.context).isTransformingText()) {
/* 86 */       append(((NodeFormatterContext)this.context).transformTranslating(paramCharSequence1, paramCharSequence2, paramCharSequence3, paramCharSequence4));
/*    */     } else {
/* 88 */       if (paramCharSequence1 != null) append(paramCharSequence1); 
/* 89 */       append(paramCharSequence2);
/* 90 */       if (paramCharSequence3 != null) append(paramCharSequence3); 
/* 91 */       if (paramCharSequence4 != null) append(paramCharSequence4); 
/*    */     } 
/* 93 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\MarkdownWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */