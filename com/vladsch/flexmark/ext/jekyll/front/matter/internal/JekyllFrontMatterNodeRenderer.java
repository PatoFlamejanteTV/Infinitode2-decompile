/*    */ package com.vladsch.flexmark.ext.jekyll.front.matter.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.jekyll.front.matter.JekyllFrontMatterBlock;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JekyllFrontMatterNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   public JekyllFrontMatterNodeRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 23 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(JekyllFrontMatterBlock.class, this::render));
/*    */     
/* 25 */     return (Set)hashSet;
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(JekyllFrontMatterBlock paramJekyllFrontMatterBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 36 */       return new JekyllFrontMatterNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\front\matter\internal\JekyllFrontMatterNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */