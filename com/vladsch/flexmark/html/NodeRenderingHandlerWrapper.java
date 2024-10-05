/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ 
/*    */ 
/*    */ class NodeRenderingHandlerWrapper
/*    */ {
/*    */   public final NodeRenderingHandler<?> myRenderingHandler;
/*    */   public final NodeRenderingHandlerWrapper myPreviousRenderingHandler;
/*    */   
/*    */   public NodeRenderingHandlerWrapper(NodeRenderingHandler<?> paramNodeRenderingHandler, NodeRenderingHandlerWrapper paramNodeRenderingHandlerWrapper) {
/* 12 */     this.myRenderingHandler = paramNodeRenderingHandler;
/* 13 */     this.myPreviousRenderingHandler = paramNodeRenderingHandlerWrapper;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\NodeRenderingHandlerWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */