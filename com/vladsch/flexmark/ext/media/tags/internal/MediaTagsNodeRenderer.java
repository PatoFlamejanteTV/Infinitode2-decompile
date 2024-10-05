/*     */ package com.vladsch.flexmark.ext.media.tags.internal;
/*     */ import com.vladsch.flexmark.ext.media.tags.AudioLink;
/*     */ import com.vladsch.flexmark.ext.media.tags.EmbedLink;
/*     */ import com.vladsch.flexmark.ext.media.tags.PictureLink;
/*     */ import com.vladsch.flexmark.ext.media.tags.VideoLink;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class MediaTagsNodeRenderer implements NodeRenderer {
/*     */   public MediaTagsNodeRenderer(DataHolder paramDataHolder) {}
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*     */     HashSet<NodeRenderingHandler> hashSet;
/*  23 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(AudioLink.class, this::renderAudioLink));
/*  24 */     hashSet.add(new NodeRenderingHandler(EmbedLink.class, this::renderEmbedLink));
/*  25 */     hashSet.add(new NodeRenderingHandler(PictureLink.class, this::renderPictureLink));
/*  26 */     hashSet.add(new NodeRenderingHandler(VideoLink.class, this::renderVideoLink));
/*  27 */     return (Set)hashSet;
/*     */   }
/*     */   
/*     */   private void renderAudioLink(AudioLink paramAudioLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  31 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/*  32 */       paramNodeRendererContext.renderChildren((Node)paramAudioLink); return;
/*     */     } 
/*     */     ResolvedLink resolvedLink;
/*  35 */     String[] arrayOfString2 = (resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramAudioLink.getUrl().unescape(), Boolean.FALSE)).getUrl().split("\\|");
/*  36 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("title", (CharSequence)paramAudioLink.getText()))
/*  37 */       .attr("controls", ""))
/*  38 */       .withAttr()
/*  39 */       .tag("audio"); String[] arrayOfString1; int i; byte b;
/*  40 */     for (i = (arrayOfString1 = arrayOfString2).length, b = 0; b < i; ) { String str1 = arrayOfString1[b];
/*  41 */       String str2 = (paramNodeRendererContext.getHtmlOptions()).percentEncodeUrls ? paramNodeRendererContext.encodeUrl(str1) : str1;
/*  42 */       str1 = Utilities.resolveAudioType(str1);
/*  43 */       paramHtmlWriter.attr("src", str2);
/*  44 */       if (str1 != null) paramHtmlWriter.attr("type", str1); 
/*  45 */       paramHtmlWriter.withAttr().tag("source", true); b++; }
/*     */     
/*  47 */     paramHtmlWriter.text("Your browser does not support the audio element.");
/*  48 */     paramHtmlWriter.tag("/audio");
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderEmbedLink(EmbedLink paramEmbedLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  53 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/*  54 */       paramNodeRendererContext.renderChildren((Node)paramEmbedLink); return;
/*     */     } 
/*  56 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramEmbedLink.getUrl().unescape(), null);
/*     */     
/*  58 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("title", (CharSequence)paramEmbedLink.getText()))
/*  59 */       .attr("src", resolvedLink.getUrl()))
/*  60 */       .withAttr()
/*  61 */       .tag("embed", true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderPictureLink(PictureLink paramPictureLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  66 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/*  67 */       paramNodeRendererContext.renderChildren((Node)paramPictureLink); return;
/*     */     } 
/*     */     ResolvedLink resolvedLink;
/*  70 */     String[] arrayOfString = (resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramPictureLink.getUrl().unescape(), Boolean.FALSE)).getUrl().split("\\|");
/*  71 */     paramHtmlWriter.tag("picture"); int i;
/*  72 */     for (i = 0; i < arrayOfString.length - 1; i++) {
/*  73 */       String str = arrayOfString[i];
/*  74 */       str = (paramNodeRendererContext.getHtmlOptions()).percentEncodeUrls ? paramNodeRendererContext.encodeUrl(str) : str;
/*  75 */       ((HtmlWriter)paramHtmlWriter.attr("srcset", str))
/*  76 */         .withAttr()
/*  77 */         .tag("source", true);
/*     */     } 
/*     */     
/*  80 */     if ((i = arrayOfString.length - 1) >= 0) {
/*  81 */       String str = arrayOfString[i];
/*  82 */       str = (paramNodeRendererContext.getHtmlOptions()).percentEncodeUrls ? paramNodeRendererContext.encodeUrl(str) : str;
/*  83 */       ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("src", str))
/*  84 */         .attr("alt", (CharSequence)paramPictureLink.getText()))
/*  85 */         .withAttr()
/*  86 */         .tag("img", true);
/*     */     } 
/*  88 */     paramHtmlWriter.tag("/picture");
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderVideoLink(VideoLink paramVideoLink, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  93 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/*  94 */       paramNodeRendererContext.renderChildren((Node)paramVideoLink); return;
/*     */     } 
/*     */     ResolvedLink resolvedLink;
/*  97 */     String[] arrayOfString2 = (resolvedLink = paramNodeRendererContext.resolveLink(LinkType.LINK, paramVideoLink.getUrl().unescape(), Boolean.FALSE)).getUrl().split("\\|");
/*  98 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.attr("title", (CharSequence)paramVideoLink.getText()))
/*  99 */       .attr("controls", ""))
/* 100 */       .withAttr()
/* 101 */       .tag("video"); String[] arrayOfString1; int i; byte b;
/* 102 */     for (i = (arrayOfString1 = arrayOfString2).length, b = 0; b < i; ) { String str1 = arrayOfString1[b];
/* 103 */       String str2 = (paramNodeRendererContext.getHtmlOptions()).percentEncodeUrls ? paramNodeRendererContext.encodeUrl(str1) : str1;
/* 104 */       str1 = Utilities.resolveVideoType(str1);
/* 105 */       paramHtmlWriter.attr("src", str2);
/* 106 */       if (str1 != null) paramHtmlWriter.attr("type", str1); 
/* 107 */       paramHtmlWriter.withAttr().tag("source", true); b++; }
/*     */     
/* 109 */     paramHtmlWriter.text("Your browser does not support the video element.");
/* 110 */     paramHtmlWriter.tag("/video");
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 118 */       return new MediaTagsNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\internal\MediaTagsNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */