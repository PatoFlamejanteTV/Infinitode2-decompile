/*    */ package com.vladsch.flexmark.ext.wikilink.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiLink;
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class WikiLinkJiraRenderer implements NodeRenderer {
/*    */   public WikiLinkJiraRenderer(DataHolder paramDataHolder) {
/* 17 */     this.options = new WikiLinkOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 23 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(WikiLink.class, this::render));
/* 24 */     return (Set)hashSet;
/*    */   }
/*    */   private final WikiLinkOptions options;
/*    */   private void render(WikiLink paramWikiLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 28 */     if (this.options.disableRendering) {
/* 29 */       paramHtmlWriter.text(paramWikiLink.getChars().unescape()); return;
/*    */     } 
/* 31 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(WikiLinkExtension.WIKI_LINK, paramWikiLink.getLink().toString(), null);
/* 32 */     paramHtmlWriter.raw("[");
/* 33 */     paramHtmlWriter.raw(paramWikiLink.getText().isNotNull() ? paramWikiLink.getText().toString() : paramWikiLink.getPageRef().toString());
/* 34 */     paramHtmlWriter.raw("|");
/* 35 */     paramHtmlWriter.raw(resolvedLink.getUrl());
/* 36 */     paramHtmlWriter.raw("]");
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 44 */       return new WikiLinkJiraRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkJiraRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */