/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.toc.internal.SimTocBlockParser;
/*    */ import com.vladsch.flexmark.ext.toc.internal.SimTocNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.toc.internal.SimTocNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.toc.internal.TocOptions;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimTocExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 26 */   public static final AttributablePart TOC_CONTENT = TocUtils.TOC_CONTENT;
/* 27 */   public static final AttributablePart TOC_LIST = TocUtils.TOC_LIST;
/*    */   
/* 29 */   public static final DataKey<Integer> LEVELS = TocExtension.LEVELS;
/* 30 */   public static final DataKey<Boolean> IS_TEXT_ONLY = TocExtension.IS_TEXT_ONLY;
/* 31 */   public static final DataKey<Boolean> IS_NUMBERED = TocExtension.IS_NUMBERED;
/* 32 */   public static final DataKey<TocOptions.ListType> LIST_TYPE = TocExtension.LIST_TYPE;
/* 33 */   public static final DataKey<Boolean> IS_HTML = TocExtension.IS_HTML;
/* 34 */   public static final DataKey<Integer> TITLE_LEVEL = TocExtension.TITLE_LEVEL;
/* 35 */   public static final NullableDataKey<String> TITLE = TocExtension.TITLE;
/* 36 */   public static final DataKey<Boolean> AST_INCLUDE_OPTIONS = TocExtension.AST_INCLUDE_OPTIONS;
/* 37 */   public static final DataKey<Boolean> BLANK_LINE_SPACER = TocExtension.BLANK_LINE_SPACER;
/* 38 */   public static final DataKey<String> DIV_CLASS = TocExtension.DIV_CLASS;
/* 39 */   public static final DataKey<String> LIST_CLASS = TocExtension.LIST_CLASS;
/* 40 */   public static final DataKey<Boolean> CASE_SENSITIVE_TOC_TAG = TocExtension.CASE_SENSITIVE_TOC_TAG;
/*    */ 
/*    */   
/* 43 */   public static final DataKey<SimTocGenerateOnFormat> FORMAT_UPDATE_ON_FORMAT = TocExtension.FORMAT_UPDATE_ON_FORMAT;
/* 44 */   public static final DataKey<TocOptions> FORMAT_OPTIONS = TocExtension.FORMAT_OPTIONS;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SimTocExtension create() {
/* 50 */     return new SimTocExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {
/* 56 */     if (!paramMutableDataHolder.contains((DataKeyBase)HtmlRenderer.GENERATE_HEADER_ID)) {
/* 57 */       paramMutableDataHolder.set(HtmlRenderer.GENERATE_HEADER_ID, Boolean.TRUE);
/*    */     }
/*    */     
/* 60 */     if (!paramMutableDataHolder.contains((DataKeyBase)Formatter.GENERATE_HEADER_ID)) {
/* 61 */       paramMutableDataHolder.set(Formatter.GENERATE_HEADER_ID, Boolean.TRUE);
/*    */     }
/*    */     
/* 64 */     if (!paramMutableDataHolder.contains((DataKeyBase)HtmlRenderer.RENDER_HEADER_ID)) {
/* 65 */       paramMutableDataHolder.set(HtmlRenderer.RENDER_HEADER_ID, Boolean.TRUE);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 76 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new SimTocNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 81 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new SimTocBlockParser.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 86 */     if (paramBuilder.isRendererType("HTML")) {
/* 87 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new SimTocNodeRenderer.Factory()); return;
/* 88 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */