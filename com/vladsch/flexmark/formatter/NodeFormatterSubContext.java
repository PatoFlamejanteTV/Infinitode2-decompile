/*    */ package com.vladsch.flexmark.formatter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public abstract class NodeFormatterSubContext
/*    */   implements NodeFormatterContext
/*    */ {
/*    */   protected final MarkdownWriter markdown;
/*    */   Node renderingNode;
/* 13 */   List<NodeFormattingHandler<?>> rendererList = null;
/* 14 */   int rendererIndex = -1;
/*    */   
/*    */   public NodeFormatterSubContext(MarkdownWriter paramMarkdownWriter) {
/* 17 */     this.markdown = paramMarkdownWriter;
/* 18 */     this.renderingNode = null;
/*    */   }
/*    */   
/*    */   public Node getRenderingNode() {
/* 22 */     return this.renderingNode;
/*    */   }
/*    */   
/*    */   public void setRenderingNode(Node paramNode) {
/* 26 */     this.renderingNode = paramNode;
/*    */   }
/*    */ 
/*    */   
/*    */   public MarkdownWriter getMarkdown() {
/* 31 */     return this.markdown;
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt) {
/* 35 */     flushTo(paramAppendable, (getFormatterOptions()).maxBlankLines, paramInt);
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt1, int paramInt2) {
/* 39 */     this.markdown.line();
/*    */     try {
/* 41 */       this.markdown.appendTo(paramAppendable, paramInt1, paramInt2); return;
/* 42 */     } catch (IOException iOException) {
/* 43 */       (paramAppendable = null).printStackTrace();
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeFormatterSubContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */