/*    */ package com.vladsch.flexmark.ext.superscript.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.superscript.Superscript;
/*    */ import com.vladsch.flexmark.ext.superscript.SuperscriptExtension;
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
/*    */ public class SuperscriptNodeRenderer
/*    */   implements NodeRenderer {
/*    */   private final String superscriptStyleHtmlOpen;
/*    */   private final String superscriptStyleHtmlClose;
/*    */   
/*    */   public SuperscriptNodeRenderer(DataHolder paramDataHolder) {
/* 21 */     this.superscriptStyleHtmlOpen = (String)SuperscriptExtension.SUPERSCRIPT_STYLE_HTML_OPEN.get(paramDataHolder);
/* 22 */     this.superscriptStyleHtmlClose = (String)SuperscriptExtension.SUPERSCRIPT_STYLE_HTML_CLOSE.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 28 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Superscript.class, this::render));
/* 29 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Superscript paramSuperscript, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 33 */     if (this.superscriptStyleHtmlOpen == null || this.superscriptStyleHtmlClose == null) {
/* 34 */       if ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines) {
/* 35 */         paramHtmlWriter.withAttr().tag("sup");
/*    */       } else {
/* 37 */         paramHtmlWriter.srcPos(paramSuperscript.getText()).withAttr().tag("sup");
/*    */       } 
/* 39 */       paramNodeRendererContext.renderChildren((Node)paramSuperscript);
/* 40 */       paramHtmlWriter.tag("/sup"); return;
/*    */     } 
/* 42 */     paramHtmlWriter.raw(this.superscriptStyleHtmlOpen);
/* 43 */     paramNodeRendererContext.renderChildren((Node)paramSuperscript);
/* 44 */     paramHtmlWriter.raw(this.superscriptStyleHtmlClose);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 52 */       return new SuperscriptNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\superscript\internal\SuperscriptNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */