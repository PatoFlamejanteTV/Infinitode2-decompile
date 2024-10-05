/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public abstract class NodeRendererSubContext
/*    */   implements NodeRendererContext
/*    */ {
/*    */   final HtmlWriter htmlWriter;
/*    */   Node renderingNode;
/*    */   NodeRenderingHandlerWrapper renderingHandlerWrapper;
/*    */   int doNotRenderLinksNesting;
/*    */   
/*    */   public NodeRendererSubContext(HtmlWriter paramHtmlWriter) {
/* 16 */     this.htmlWriter = paramHtmlWriter;
/* 17 */     this.renderingNode = null;
/* 18 */     this.doNotRenderLinksNesting = 0;
/*    */   }
/*    */   
/*    */   public HtmlWriter getHtmlWriter() {
/* 22 */     return this.htmlWriter;
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt) {
/* 26 */     flushTo(paramAppendable, (getHtmlOptions()).maxBlankLines, paramInt);
/*    */   }
/*    */   
/*    */   public void flushTo(Appendable paramAppendable, int paramInt1, int paramInt2) {
/* 30 */     this.htmlWriter.line();
/*    */     try {
/* 32 */       this.htmlWriter.appendTo(paramAppendable, paramInt1, paramInt2); return;
/* 33 */     } catch (IOException iOException) {
/* 34 */       (paramAppendable = null).printStackTrace();
/*    */       return;
/*    */     } 
/*    */   }
/*    */   protected int getDoNotRenderLinksNesting() {
/* 39 */     return this.doNotRenderLinksNesting;
/*    */   }
/*    */   
/*    */   public boolean isDoNotRenderLinks() {
/* 43 */     return (this.doNotRenderLinksNesting != 0);
/*    */   }
/*    */   
/*    */   public void doNotRenderLinks(boolean paramBoolean) {
/* 47 */     if (paramBoolean) { doNotRenderLinks(); return; }
/* 48 */      doRenderLinks();
/*    */   }
/*    */   
/*    */   public void doNotRenderLinks() {
/* 52 */     this.doNotRenderLinksNesting++;
/*    */   }
/*    */   
/*    */   public void doRenderLinks() {
/* 56 */     if (this.doNotRenderLinksNesting == 0) throw new IllegalStateException("Not in do not render links context"); 
/* 57 */     this.doNotRenderLinksNesting--;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\NodeRendererSubContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */