/*    */ package com.vladsch.flexmark.ext.wikilink.internal;
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiImage;
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiLink;
/*    */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class WikiLinkNodeRenderer implements NodeRenderer {
/*    */   public WikiLinkNodeRenderer(DataHolder paramDataHolder) {
/* 18 */     this.options = new WikiLinkOptions(paramDataHolder);
/*    */   }
/*    */   private final WikiLinkOptions options;
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 24 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(WikiLink.class, this::render));
/* 25 */     hashSet.add(new NodeRenderingHandler(WikiImage.class, this::render));
/* 26 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(WikiLink paramWikiLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 30 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 31 */       if (this.options.disableRendering) {
/* 32 */         paramHtmlWriter.text(paramWikiLink.getChars().unescape()); return;
/*    */       } 
/* 34 */       ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(WikiLinkExtension.WIKI_LINK, (CharSequence)paramWikiLink.getLink(), null);
/* 35 */       paramHtmlWriter.attr("href", resolvedLink.getUrl());
/* 36 */       paramHtmlWriter.srcPos(paramWikiLink.getChars()).withAttr(resolvedLink).tag("a");
/* 37 */       paramNodeRendererContext.renderChildren((Node)paramWikiLink);
/* 38 */       paramHtmlWriter.tag("/a");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(WikiImage paramWikiImage, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 44 */     if (!paramNodeRendererContext.isDoNotRenderLinks()) {
/* 45 */       if (this.options.disableRendering) {
/* 46 */         paramHtmlWriter.text(paramWikiImage.getChars().unescape()); return;
/*    */       } 
/* 48 */       String str1 = paramWikiImage.getText().isNotNull() ? paramWikiImage.getText().toString() : paramWikiImage.getLink().unescape();
/*    */       
/*    */       ResolvedLink resolvedLink;
/* 51 */       String str2 = (resolvedLink = paramNodeRendererContext.resolveLink(WikiLinkExtension.WIKI_LINK, (CharSequence)paramWikiImage.getLink(), null)).getUrl();
/*    */       
/* 53 */       paramHtmlWriter.attr("src", str2);
/* 54 */       paramHtmlWriter.attr("alt", str1);
/* 55 */       paramHtmlWriter.srcPos(paramWikiImage.getChars()).withAttr(resolvedLink).tagVoid("img");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 64 */       return new WikiLinkNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */