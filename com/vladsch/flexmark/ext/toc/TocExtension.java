/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.toc.internal.TocBlockParser;
/*    */ import com.vladsch.flexmark.ext.toc.internal.TocNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.toc.internal.TocOptions;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TocExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 24 */   public static final AttributablePart TOC_CONTENT = TocUtils.TOC_CONTENT;
/* 25 */   public static final AttributablePart TOC_LIST = TocUtils.TOC_LIST;
/*    */   
/* 27 */   public static final DataKey<Integer> LEVELS = new DataKey("LEVELS", Integer.valueOf(12));
/* 28 */   public static final DataKey<Boolean> IS_TEXT_ONLY = new DataKey("IS_TEXT_ONLY", Boolean.FALSE);
/* 29 */   public static final DataKey<Boolean> IS_NUMBERED = new DataKey("IS_NUMBERED", Boolean.FALSE);
/* 30 */   public static final DataKey<TocOptions.ListType> LIST_TYPE = new DataKey("LIST_TYPE", TocOptions.ListType.HIERARCHY);
/* 31 */   public static final DataKey<Boolean> IS_HTML = new DataKey("IS_HTML", Boolean.FALSE);
/* 32 */   public static final DataKey<Integer> TITLE_LEVEL = new DataKey("TITLE_LEVEL", Integer.valueOf(1));
/* 33 */   public static final NullableDataKey<String> TITLE = new NullableDataKey("TITLE");
/* 34 */   public static final DataKey<Boolean> AST_INCLUDE_OPTIONS = new DataKey("AST_INCLUDE_OPTIONS", Boolean.FALSE);
/* 35 */   public static final DataKey<Boolean> BLANK_LINE_SPACER = new DataKey("BLANK_LINE_SPACER", Boolean.FALSE);
/* 36 */   public static final DataKey<String> DIV_CLASS = new DataKey("DIV_CLASS", "");
/* 37 */   public static final DataKey<String> LIST_CLASS = new DataKey("LIST_CLASS", "");
/* 38 */   public static final DataKey<Boolean> CASE_SENSITIVE_TOC_TAG = new DataKey("CASE_SENSITIVE_TOC_TAG", Boolean.TRUE);
/*    */ 
/*    */   
/* 41 */   public static final DataKey<SimTocGenerateOnFormat> FORMAT_UPDATE_ON_FORMAT = new DataKey("FORMAT_UPDATE_ON_FORMAT", SimTocGenerateOnFormat.UPDATE); static {
/* 42 */     FORMAT_OPTIONS = new DataKey("FORMAT_OPTIONS", new TocOptions(null, false), paramDataHolder -> new TocOptions(paramDataHolder, false));
/*    */   }
/*    */   
/*    */   public static final DataKey<TocOptions> FORMAT_OPTIONS;
/*    */   
/*    */   public static TocExtension create() {
/* 48 */     return new TocExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {
/* 54 */     if (!paramMutableDataHolder.contains((DataKeyBase)HtmlRenderer.RENDER_HEADER_ID)) {
/* 55 */       paramMutableDataHolder.set(HtmlRenderer.RENDER_HEADER_ID, Boolean.TRUE);
/* 56 */       paramMutableDataHolder.set(HtmlRenderer.GENERATE_HEADER_ID, Boolean.TRUE); return;
/* 57 */     }  if (!paramMutableDataHolder.contains((DataKeyBase)HtmlRenderer.GENERATE_HEADER_ID)) {
/* 58 */       paramMutableDataHolder.set(HtmlRenderer.GENERATE_HEADER_ID, Boolean.TRUE);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 69 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new TocBlockParser.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 74 */     if (paramBuilder.isRendererType("HTML"))
/* 75 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new TocNodeRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\TocExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */