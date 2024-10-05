/*    */ package com.vladsch.flexmark.ext.gfm.strikethrough.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
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
/*    */ public class StrikethroughYouTrackRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   public StrikethroughYouTrackRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 24 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Strikethrough.class, this::render));
/* 25 */     hashSet.add(new NodeRenderingHandler(Subscript.class, this::render));
/* 26 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Strikethrough paramStrikethrough, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 30 */     paramHtmlWriter.raw("--");
/* 31 */     paramNodeRendererContext.renderChildren((Node)paramStrikethrough);
/* 32 */     paramHtmlWriter.raw("--");
/*    */   }
/*    */   
/*    */   private void render(Subscript paramSubscript, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 36 */     paramHtmlWriter.raw("~");
/* 37 */     paramNodeRendererContext.renderChildren((Node)paramSubscript);
/* 38 */     paramHtmlWriter.raw("~");
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 45 */       return new StrikethroughYouTrackRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\strikethrough\internal\StrikethroughYouTrackRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */