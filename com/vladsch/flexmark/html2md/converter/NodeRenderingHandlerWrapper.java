/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ class NodeRenderingHandlerWrapper<N extends Node> {
/*    */   public final HtmlNodeRendererHandler<N> myRenderingHandler;
/*    */   public final NodeRenderingHandlerWrapper<N> myPreviousRenderingHandler;
/*    */   
/*    */   public NodeRenderingHandlerWrapper(HtmlNodeRendererHandler<N> paramHtmlNodeRendererHandler, NodeRenderingHandlerWrapper<N> paramNodeRenderingHandlerWrapper) {
/* 10 */     this.myRenderingHandler = paramHtmlNodeRendererHandler;
/* 11 */     this.myPreviousRenderingHandler = paramNodeRenderingHandlerWrapper;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\NodeRenderingHandlerWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */