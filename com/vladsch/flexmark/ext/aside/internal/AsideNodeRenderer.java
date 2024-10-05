/*    */ package com.vladsch.flexmark.ext.aside.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.aside.AsideBlock;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsideNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   public AsideNodeRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 23 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(AsideBlock.class, this::render));
/* 24 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(AsideBlock paramAsideBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 28 */     ((HtmlWriter)paramHtmlWriter.withAttr().withCondIndent()).tagLine("aside", () -> paramNodeRendererContext.renderChildren((Node)paramAsideBlock));
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 35 */       return new AsideNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\internal\AsideNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */