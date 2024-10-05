/*    */ package com.vladsch.flexmark.ext.typographic.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.typographic.TypographicQuotes;
/*    */ import com.vladsch.flexmark.ext.typographic.TypographicSmarts;
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
/*    */ public class TypographicNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   public TypographicNodeRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 24 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(TypographicSmarts.class, this::render));
/* 25 */     hashSet.add(new NodeRenderingHandler(TypographicQuotes.class, this::render));
/* 26 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(TypographicQuotes paramTypographicQuotes, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 30 */     if (paramTypographicQuotes.getTypographicOpening() != null && !paramTypographicQuotes.getTypographicOpening().isEmpty()) paramHtmlWriter.raw(paramTypographicQuotes.getTypographicOpening()); 
/* 31 */     paramNodeRendererContext.renderChildren((Node)paramTypographicQuotes);
/* 32 */     if (paramTypographicQuotes.getTypographicClosing() != null && !paramTypographicQuotes.getTypographicClosing().isEmpty()) paramHtmlWriter.raw(paramTypographicQuotes.getTypographicClosing()); 
/*    */   }
/*    */   
/*    */   private void render(TypographicSmarts paramTypographicSmarts, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 36 */     paramHtmlWriter.raw(paramTypographicSmarts.getTypographicText());
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 43 */       return new TypographicNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\TypographicNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */