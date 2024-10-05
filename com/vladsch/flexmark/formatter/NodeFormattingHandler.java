/*    */ package com.vladsch.flexmark.formatter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.visitor.AstAction;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ 
/*    */ public class NodeFormattingHandler<N extends Node>
/*    */   extends AstHandler<N, NodeFormattingHandler.CustomNodeFormatter<N>> {
/*    */   public NodeFormattingHandler(Class<N> paramClass, CustomNodeFormatter<N> paramCustomNodeFormatter) {
/* 10 */     super(paramClass, paramCustomNodeFormatter);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Node paramNode, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 15 */     ((CustomNodeFormatter<Node>)getAdapter()).render(paramNode, paramNodeFormatterContext, paramMarkdownWriter);
/*    */   }
/*    */   
/*    */   public static interface CustomNodeFormatter<N extends Node> extends AstAction<N> {
/*    */     void render(N param1N, NodeFormatterContext param1NodeFormatterContext, MarkdownWriter param1MarkdownWriter);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeFormattingHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */