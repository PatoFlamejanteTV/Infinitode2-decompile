/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.visitor.AstAction;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ 
/*    */ public class NodeRenderingHandler<N extends Node>
/*    */   extends AstHandler<N, NodeRenderingHandler.CustomNodeRenderer<N>> {
/*    */   public NodeRenderingHandler(Class<N> paramClass, CustomNodeRenderer<N> paramCustomNodeRenderer) {
/* 11 */     super(paramClass, paramCustomNodeRenderer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Node paramNode, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 16 */     ((CustomNodeRenderer<Node>)getAdapter()).render(paramNode, paramNodeRendererContext, paramHtmlWriter);
/*    */   }
/*    */   
/*    */   public static interface CustomNodeRenderer<N extends Node> extends AstAction<N> {
/*    */     void render(N param1N, NodeRendererContext param1NodeRendererContext, HtmlWriter param1HtmlWriter);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\NodeRenderingHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */