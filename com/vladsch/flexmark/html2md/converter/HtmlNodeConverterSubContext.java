/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ 
/*    */ public abstract class HtmlNodeConverterSubContext
/*    */   implements HtmlNodeConverterContext
/*    */ {
/*    */   protected final HtmlMarkdownWriter markdown;
/*    */   NodeRenderingHandlerWrapper<?> renderingHandlerWrapper;
/*    */   Node myRenderingNode;
/*    */   
/*    */   public HtmlNodeConverterSubContext(HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 15 */     this.markdown = paramHtmlMarkdownWriter;
/* 16 */     this.myRenderingNode = null;
/* 17 */     this.markdown.setContext(this);
/*    */   }
/*    */   
/*    */   public Node getRenderingNode() {
/* 21 */     return this.myRenderingNode;
/*    */   }
/*    */   
/*    */   public void setRenderingNode(Node paramNode) {
/* 25 */     this.myRenderingNode = paramNode;
/*    */   }
/*    */   
/*    */   public HtmlMarkdownWriter getMarkdown() {
/* 29 */     return this.markdown;
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt) {
/* 33 */     flushTo(paramAppendable, (getHtmlConverterOptions()).maxBlankLines, paramInt);
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt1, int paramInt2) {
/* 37 */     this.markdown.line();
/*    */     try {
/* 39 */       this.markdown.appendTo(paramAppendable, paramInt1, paramInt2); return;
/* 40 */     } catch (IOException iOException) {
/* 41 */       (paramAppendable = null).printStackTrace();
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlNodeConverterSubContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */