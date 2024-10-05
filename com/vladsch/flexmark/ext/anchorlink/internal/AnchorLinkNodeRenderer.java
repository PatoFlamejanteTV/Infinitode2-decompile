/*    */ package com.vladsch.flexmark.ext.anchorlink.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.anchorlink.AnchorLink;
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
/*    */ public class AnchorLinkNodeRenderer
/*    */   implements NodeRenderer {
/*    */   private final AnchorLinkOptions options;
/*    */   
/*    */   public AnchorLinkNodeRenderer(DataHolder paramDataHolder) {
/* 19 */     this.options = new AnchorLinkOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 25 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(AnchorLink.class, this::render));
/* 26 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(AnchorLink paramAnchorLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 30 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 31 */       if (this.options.wrapText) {
/* 32 */         paramNodeRendererContext.renderChildren((Node)paramAnchorLink); return;
/*    */       } 
/*    */     } else {
/*    */       String str;
/* 36 */       if ((str = paramNodeRendererContext.getNodeId(paramAnchorLink.getParent())) != null) {
/* 37 */         paramHtmlWriter.attr("href", "#" + str);
/* 38 */         if (this.options.setId) paramHtmlWriter.attr("id", str); 
/* 39 */         if (this.options.setName) paramHtmlWriter.attr("name", str); 
/* 40 */         if (!this.options.anchorClass.isEmpty()) paramHtmlWriter.attr("class", this.options.anchorClass);
/*    */         
/* 42 */         if (!this.options.wrapText) {
/* 43 */           paramHtmlWriter.withAttr().tag("a");
/* 44 */           if (!this.options.textPrefix.isEmpty()) paramHtmlWriter.raw(this.options.textPrefix); 
/* 45 */           if (!this.options.textSuffix.isEmpty()) paramHtmlWriter.raw(this.options.textSuffix); 
/* 46 */           paramHtmlWriter.tag("/a"); return;
/*    */         } 
/* 48 */         paramHtmlWriter.withAttr().tag("a", false, false, () -> {
/*    */               if (!this.options.textPrefix.isEmpty())
/*    */                 paramHtmlWriter.raw(this.options.textPrefix);  paramNodeRendererContext.renderChildren((Node)paramAnchorLink); if (!this.options.textSuffix.isEmpty())
/*    */                 paramHtmlWriter.raw(this.options.textSuffix); 
/*    */             });
/*    */         return;
/*    */       } 
/* 55 */       if (this.options.wrapText) {
/* 56 */         paramNodeRendererContext.renderChildren((Node)paramAnchorLink);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 66 */       return new AnchorLinkNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\anchorlink\internal\AnchorLinkNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */