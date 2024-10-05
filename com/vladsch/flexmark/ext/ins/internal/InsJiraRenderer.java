/*    */ package com.vladsch.flexmark.ext.ins.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.ins.Ins;
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
/*    */ public class InsJiraRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   public InsJiraRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 23 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Ins.class, this::render));
/* 24 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Ins paramIns, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 28 */     paramHtmlWriter.raw("+");
/* 29 */     paramNodeRendererContext.renderChildren((Node)paramIns);
/* 30 */     paramHtmlWriter.raw("+");
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 37 */       return new InsJiraRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\ins\internal\InsJiraRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */