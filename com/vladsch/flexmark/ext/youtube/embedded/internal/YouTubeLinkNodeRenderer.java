/*    */ package com.vladsch.flexmark.ext.youtube.embedded.internal;
/*    */ import com.vladsch.flexmark.ext.youtube.embedded.YouTubeLink;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.LinkType;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class YouTubeLinkNodeRenderer implements NodeRenderer {
/*    */   public YouTubeLinkNodeRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 22 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(YouTubeLink.class, this::render));
/* 23 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(YouTubeLink paramYouTubeLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 27 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 28 */       paramNodeRendererContext.renderChildren((Node)paramYouTubeLink);
/*    */       return;
/*    */     } 
/* 31 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramYouTubeLink.getUrl().unescape(), null);
/*    */     
/* 33 */     URL uRL = null;
/*    */     try {
/* 35 */       uRL = new URL(resolvedLink.getUrl());
/* 36 */     } catch (MalformedURLException malformedURLException) {}
/*    */ 
/*    */     
/* 39 */     if (uRL != null && "youtu.be".equalsIgnoreCase(uRL.getHost())) {
/* 40 */       paramHtmlWriter.attr("src", "https://www.youtube-nocookie.com/embed" + uRL.getFile().replace("?t=", "?start="));
/* 41 */       paramHtmlWriter.attr("width", "560");
/* 42 */       paramHtmlWriter.attr("height", "315");
/* 43 */       paramHtmlWriter.attr("class", "youtube-embedded");
/* 44 */       paramHtmlWriter.attr("allowfullscreen", "true");
/* 45 */       paramHtmlWriter.attr("frameborder", "0");
/* 46 */       paramHtmlWriter.attr("allow", "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
/* 47 */       paramHtmlWriter.srcPos(paramYouTubeLink.getChars()).withAttr(resolvedLink).tag("iframe");
/* 48 */       paramHtmlWriter.tag("/iframe"); return;
/* 49 */     }  if (resolvedLink.getUrl().contains("www.youtube.com/watch")) {
/* 50 */       paramHtmlWriter.attr("src", resolvedLink.getUrl().replace("watch?v=".toLowerCase(), "embed/"));
/* 51 */       paramHtmlWriter.attr("width", "420");
/* 52 */       paramHtmlWriter.attr("height", "315");
/* 53 */       paramHtmlWriter.attr("class", "youtube-embedded");
/* 54 */       paramHtmlWriter.attr("allowfullscreen", "true");
/* 55 */       paramHtmlWriter.attr("frameborder", "0");
/* 56 */       paramHtmlWriter.srcPos(paramYouTubeLink.getChars()).withAttr(resolvedLink).tag("iframe");
/*    */       
/* 58 */       paramHtmlWriter.tag("/iframe"); return;
/*    */     } 
/* 60 */     paramHtmlWriter.attr("href", resolvedLink.getUrl());
/* 61 */     if (paramYouTubeLink.getTitle().isNotNull()) {
/* 62 */       paramHtmlWriter.attr("title", paramYouTubeLink.getTitle().unescape());
/*    */     }
/* 64 */     paramHtmlWriter.srcPos(paramYouTubeLink.getChars()).withAttr(resolvedLink).tag("a");
/* 65 */     paramNodeRendererContext.renderChildren((Node)paramYouTubeLink);
/* 66 */     paramHtmlWriter.tag("/a");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 75 */       return new YouTubeLinkNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\youtube\embedded\internal\YouTubeLinkNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */