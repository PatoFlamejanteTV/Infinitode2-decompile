/*    */ package com.vladsch.flexmark.ext.ins.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.ins.Ins;
/*    */ import com.vladsch.flexmark.ext.ins.InsExtension;
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
/*    */ public class InsNodeRenderer
/*    */   implements NodeRenderer {
/*    */   private final String insStyleHtmlOpen;
/*    */   private final String insStyleHtmlClose;
/*    */   
/*    */   public InsNodeRenderer(DataHolder paramDataHolder) {
/* 21 */     this.insStyleHtmlOpen = (String)InsExtension.INS_STYLE_HTML_OPEN.get(paramDataHolder);
/* 22 */     this.insStyleHtmlClose = (String)InsExtension.INS_STYLE_HTML_CLOSE.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 28 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Ins.class, this::render));
/* 29 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Ins paramIns, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 33 */     if (this.insStyleHtmlOpen == null || this.insStyleHtmlClose == null) {
/* 34 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 35 */         paramHtmlWriter.withAttr().tag("ins");
/*    */       } else {
/* 37 */         paramHtmlWriter.srcPos(paramIns.getText()).withAttr().tag("ins");
/*    */       } 
/* 39 */       paramNodeRendererContext.renderChildren((Node)paramIns);
/* 40 */       paramHtmlWriter.tag("/ins"); return;
/*    */     } 
/* 42 */     paramHtmlWriter.raw(this.insStyleHtmlOpen);
/* 43 */     paramNodeRendererContext.renderChildren((Node)paramIns);
/* 44 */     paramHtmlWriter.raw(this.insStyleHtmlClose);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 52 */       return new InsNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\ins\internal\InsNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */