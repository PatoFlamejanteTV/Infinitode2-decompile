/*    */ package com.vladsch.flexmark.ext.gfm.strikethrough.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughSubscriptExtension;
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
/*    */ public class StrikethroughNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final String strikethroughStyleHtmlOpen;
/*    */   private final String strikethroughStyleHtmlClose;
/*    */   private final String subscriptStyleHtmlOpen;
/*    */   private final String subscriptStyleHtmlClose;
/*    */   
/*    */   public StrikethroughNodeRenderer(DataHolder paramDataHolder) {
/* 25 */     this.strikethroughStyleHtmlOpen = (String)StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_OPEN.get(paramDataHolder);
/* 26 */     this.strikethroughStyleHtmlClose = (String)StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_CLOSE.get(paramDataHolder);
/* 27 */     this.subscriptStyleHtmlOpen = (String)StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_OPEN.get(paramDataHolder);
/* 28 */     this.subscriptStyleHtmlClose = (String)StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_CLOSE.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 34 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Strikethrough.class, this::render));
/* 35 */     hashSet.add(new NodeRenderingHandler(Subscript.class, this::render));
/* 36 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Strikethrough paramStrikethrough, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 40 */     if (this.strikethroughStyleHtmlOpen == null || this.strikethroughStyleHtmlClose == null) {
/* 41 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 42 */         paramHtmlWriter.withAttr().tag("del");
/*    */       } else {
/* 44 */         paramHtmlWriter.srcPos(paramStrikethrough.getText()).withAttr().tag("del");
/*    */       } 
/* 46 */       paramNodeRendererContext.renderChildren((Node)paramStrikethrough);
/* 47 */       paramHtmlWriter.tag("/del"); return;
/*    */     } 
/* 49 */     paramHtmlWriter.raw(this.strikethroughStyleHtmlOpen);
/* 50 */     paramNodeRendererContext.renderChildren((Node)paramStrikethrough);
/* 51 */     paramHtmlWriter.raw(this.strikethroughStyleHtmlClose);
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(Subscript paramSubscript, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 56 */     if (this.subscriptStyleHtmlOpen == null || this.subscriptStyleHtmlClose == null) {
/* 57 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 58 */         paramHtmlWriter.withAttr().tag("sub");
/*    */       } else {
/* 60 */         paramHtmlWriter.srcPos(paramSubscript.getText()).withAttr().tag("sub");
/*    */       } 
/* 62 */       paramNodeRendererContext.renderChildren((Node)paramSubscript);
/* 63 */       paramHtmlWriter.tag("/sub"); return;
/*    */     } 
/* 65 */     paramHtmlWriter.raw(this.subscriptStyleHtmlOpen);
/* 66 */     paramNodeRendererContext.renderChildren((Node)paramSubscript);
/* 67 */     paramHtmlWriter.raw(this.subscriptStyleHtmlClose);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 75 */       return new StrikethroughNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\strikethrough\internal\StrikethroughNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */