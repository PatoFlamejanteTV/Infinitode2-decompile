/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.format.MarkdownWriterBase;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*    */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ public class HtmlMarkdownWriter extends MarkdownWriterBase<HtmlMarkdownWriter, Node, HtmlNodeConverterContext> {
/*    */   public HtmlMarkdownWriter() {
/* 12 */     this((Appendable)null, 0);
/*    */   }
/*    */   
/*    */   public HtmlMarkdownWriter(int paramInt) {
/* 16 */     this((Appendable)null, paramInt);
/*    */   }
/*    */   
/*    */   public HtmlMarkdownWriter(Appendable paramAppendable, int paramInt) {
/* 20 */     super(paramAppendable, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public HtmlMarkdownWriter getEmptyAppendable() {
/* 26 */     return new HtmlMarkdownWriter((Appendable)this.appendable, this.appendable.getOptions());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence lastBlockQuoteChildPrefix(BasedSequence paramBasedSequence) {
/*    */     Node node;
/* 33 */     if (node = ((HtmlNodeConverterContext)this.context).getCurrentNode() instanceof Element) {
/* 34 */       Element element = (Element)node;
/*    */       
/* 36 */       while (element.nextElementSibling() == null && (
/*    */         
/* 38 */         element = element.parent()) != null) {
/* 39 */         int i; if (element.nodeName().toLowerCase().equals("blockquote") && (
/*    */           
/* 41 */           i = paramBasedSequence.lastIndexOf('>')) >= 0) {
/* 42 */           paramBasedSequence = ((SequenceBuilder)((SequenceBuilder)paramBasedSequence.getBuilder().append((CharSequence)paramBasedSequence.subSequence(0, i))).append(' ').append((CharSequence)paramBasedSequence.subSequence(i + 1))).toSequence();
/*    */         }
/*    */ 
/*    */ 
/*    */         
/* 47 */         element = element;
/*    */       } 
/*    */     } 
/* 50 */     return paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlMarkdownWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */