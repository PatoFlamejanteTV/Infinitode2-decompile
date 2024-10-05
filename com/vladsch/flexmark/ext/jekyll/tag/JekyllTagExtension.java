/*    */ package com.vladsch.flexmark.ext.jekyll.tag;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.internal.JekyllTagInlineParserExtension;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.internal.JekyllTagNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.internal.JekyllTagNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NotNullValueSupplier;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class JekyllTagExtension implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension {
/* 24 */   public static final DataKey<Boolean> ENABLE_INLINE_TAGS = new DataKey("ENABLE_INLINE_TAGS", Boolean.TRUE);
/* 25 */   public static final DataKey<Boolean> ENABLE_BLOCK_TAGS = new DataKey("ENABLE_BLOCK_TAGS", Boolean.TRUE);
/* 26 */   public static final DataKey<Boolean> LIST_INCLUDES_ONLY = new DataKey("LIST_INCLUDES_ONLY", Boolean.TRUE);
/* 27 */   public static final DataKey<Boolean> EMBED_INCLUDED_CONTENT = new DataKey("EMBED_INCLUDED_CONTENT", Boolean.FALSE);
/* 28 */   public static final DataKey<List<LinkResolverFactory>> LINK_RESOLVER_FACTORIES = new DataKey("LINK_RESOLVER_FACTORIES", Collections.emptyList());
/* 29 */   public static final DataKey<List<UriContentResolverFactory>> CONTENT_RESOLVER_FACTORIES = new DataKey("LINK_RESOLVER_FACTORIES", Collections.emptyList());
/* 30 */   public static final NullableDataKey<Map<String, String>> INCLUDED_HTML = new NullableDataKey("INCLUDED_HTML");
/* 31 */   public static final DataKey<List<JekyllTag>> TAG_LIST = new DataKey("TAG_LIST", java.util.ArrayList::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/* 38 */   public static final DataKey<Boolean> ENABLE_RENDERING = new DataKey("ENABLE_RENDERING", Boolean.FALSE);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static JekyllTagExtension create() {
/* 44 */     return new JekyllTagExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 49 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new JekyllTagNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 64 */     if (((Boolean)ENABLE_BLOCK_TAGS.get((DataHolder)paramBuilder)).booleanValue()) paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new JekyllTagBlockParser.Factory()); 
/* 65 */     if (((Boolean)ENABLE_INLINE_TAGS.get((DataHolder)paramBuilder)).booleanValue()) paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new JekyllTagInlineParserExtension.Factory());
/*    */     
/*    */     Map map;
/* 68 */     if (((map = (Map)INCLUDED_HTML.get((DataHolder)paramBuilder)) != null && !map.isEmpty()) || !((List)LINK_RESOLVER_FACTORIES.get((DataHolder)paramBuilder)).isEmpty()) {
/* 69 */       paramBuilder.postProcessorFactory((PostProcessorFactory)new IncludeNodePostProcessor.Factory());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 75 */     if ("HTML".equals(paramString))
/* 76 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new JekyllTagNodeRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\JekyllTagExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */