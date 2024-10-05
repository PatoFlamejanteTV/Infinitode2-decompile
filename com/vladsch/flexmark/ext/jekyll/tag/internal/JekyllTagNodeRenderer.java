/*    */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTag;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagBlock;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class JekyllTagNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final boolean embedIncludes;
/*    */   private final Map<String, String> includeContent;
/*    */   
/*    */   public JekyllTagNodeRenderer(DataHolder paramDataHolder) {
/* 24 */     this.includeContent = (Map<String, String>)JekyllTagExtension.INCLUDED_HTML.get(paramDataHolder);
/* 25 */     this.embedIncludes = ((Boolean)JekyllTagExtension.EMBED_INCLUDED_CONTENT.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 32 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(JekyllTag.class, this::render));
/* 33 */     hashSet.add(new NodeRenderingHandler(JekyllTagBlock.class, this::render));
/*    */     
/* 35 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(JekyllTag paramJekyllTag, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 39 */     if (this.embedIncludes) {
/* 40 */       paramNodeRendererContext.renderChildren((Node)paramJekyllTag);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(JekyllTagBlock paramJekyllTagBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 66 */     paramNodeRendererContext.renderChildren((Node)paramJekyllTagBlock);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 73 */       return new JekyllTagNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\JekyllTagNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */