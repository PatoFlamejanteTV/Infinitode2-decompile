/*     */ package com.vladsch.flexmark.ext.wikilink;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkJiraRenderer;
/*     */ import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkLinkRefProcessor;
/*     */ import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkLinkResolver;
/*     */ import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkNodeFormatter;
/*     */ import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkNodeRenderer;
/*     */ import com.vladsch.flexmark.formatter.Formatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ 
/*     */ public class WikiLinkExtension implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension {
/*  20 */   public static final DataKey<Boolean> ALLOW_INLINES = new DataKey("ALLOW_INLINES", Boolean.FALSE);
/*  21 */   public static final DataKey<Boolean> ALLOW_ANCHORS = new DataKey("ALLOW_ANCHORS", Boolean.FALSE);
/*  22 */   public static final DataKey<Boolean> ALLOW_ANCHOR_ESCAPE = new DataKey("ALLOW_ANCHOR_ESCAPE", Boolean.FALSE);
/*  23 */   public static final DataKey<Boolean> ALLOW_PIPE_ESCAPE = new DataKey("ALLOW_PIPE_ESCAPE", Boolean.FALSE);
/*  24 */   public static final DataKey<Boolean> DISABLE_RENDERING = new DataKey("DISABLE_RENDERING", Boolean.FALSE);
/*  25 */   public static final DataKey<Boolean> LINK_FIRST_SYNTAX = new DataKey("LINK_FIRST_SYNTAX", Boolean.FALSE);
/*  26 */   public static final DataKey<String> LINK_PREFIX = new DataKey("LINK_PREFIX", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   public static final DataKey<String> LINK_PREFIX_ABSOLUTE = new DataKey("LINK_PREFIX_ABSOLUTE", LINK_PREFIX);
/*     */   
/*  37 */   public static final DataKey<String> IMAGE_PREFIX = new DataKey("IMAGE_PREFIX", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static final DataKey<String> IMAGE_PREFIX_ABSOLUTE = new DataKey("IMAGE_PREFIX_ABSOLUTE", IMAGE_PREFIX);
/*     */   
/*  48 */   public static final DataKey<Boolean> IMAGE_LINKS = new DataKey("IMAGE_LINKS", Boolean.FALSE);
/*  49 */   public static final DataKey<String> LINK_FILE_EXTENSION = new DataKey("LINK_FILE_EXTENSION", "");
/*  50 */   public static final DataKey<String> IMAGE_FILE_EXTENSION = new DataKey("IMAGE_FILE_EXTENSION", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final DataKey<String> LINK_ESCAPE_CHARS = new DataKey("LINK_ESCAPE_CHARS", " +/<>");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final DataKey<String> LINK_REPLACE_CHARS = new DataKey("LINK_REPLACE_CHARS", "-----");
/*     */   
/*  70 */   public static final LinkType WIKI_LINK = new LinkType("WIKI");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WikiLinkExtension create() {
/*  76 */     return new WikiLinkExtension();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void extend(Formatter.Builder paramBuilder) {
/*  91 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new WikiLinkNodeFormatter.Factory());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void extend(Parser.Builder paramBuilder) {
/*  97 */     paramBuilder.linkRefProcessorFactory((LinkRefProcessorFactory)new WikiLinkLinkRefProcessor.Factory());
/*     */   }
/*     */ 
/*     */   
/*     */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 102 */     if (paramBuilder.isRendererType("HTML")) {
/* 103 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new WikiLinkNodeRenderer.Factory());
/* 104 */       paramBuilder.linkResolverFactory((LinkResolverFactory)new WikiLinkLinkResolver.Factory()); return;
/* 105 */     }  if (paramBuilder.isRendererType("JIRA")) {
/* 106 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new WikiLinkJiraRenderer.Factory());
/* 107 */       paramBuilder.linkResolverFactory((LinkResolverFactory)new WikiLinkLinkResolver.Factory());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\WikiLinkExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */