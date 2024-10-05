/*    */ package com.vladsch.flexmark.ext.typographic;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.AngleQuoteDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.DoubleQuoteDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.SingleQuoteDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.SmartsInlineParser;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.TypographicNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.typographic.internal.TypographicOptions;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ 
/*    */ public class TypographicExtension implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension {
/* 19 */   public static final DataKey<Boolean> ENABLE_QUOTES = new DataKey("ENABLE_QUOTES", Boolean.TRUE);
/* 20 */   public static final DataKey<Boolean> ENABLE_SMARTS = new DataKey("ENABLE_SMARTS", Boolean.TRUE);
/* 21 */   public static final DataKey<String> ANGLE_QUOTE_CLOSE = new DataKey("ANGLE_QUOTE_CLOSE", "&raquo;");
/* 22 */   public static final DataKey<String> ANGLE_QUOTE_OPEN = new DataKey("ANGLE_QUOTE_OPEN", "&laquo;");
/* 23 */   public static final NullableDataKey<String> ANGLE_QUOTE_UNMATCHED = new NullableDataKey("ANGLE_QUOTE_UNMATCHED");
/* 24 */   public static final DataKey<String> DOUBLE_QUOTE_CLOSE = new DataKey("DOUBLE_QUOTE_CLOSE", "&rdquo;");
/* 25 */   public static final DataKey<String> DOUBLE_QUOTE_OPEN = new DataKey("DOUBLE_QUOTE_OPEN", "&ldquo;");
/* 26 */   public static final NullableDataKey<String> DOUBLE_QUOTE_UNMATCHED = new NullableDataKey("DOUBLE_QUOTE_UNMATCHED");
/* 27 */   public static final DataKey<String> ELLIPSIS = new DataKey("ELLIPSIS", "&hellip;");
/* 28 */   public static final DataKey<String> ELLIPSIS_SPACED = new DataKey("ELLIPSIS_SPACED", "&hellip;");
/* 29 */   public static final DataKey<String> EM_DASH = new DataKey("EM_DASH", "&mdash;");
/* 30 */   public static final DataKey<String> EN_DASH = new DataKey("EN_DASH", "&ndash;");
/* 31 */   public static final DataKey<String> SINGLE_QUOTE_CLOSE = new DataKey("SINGLE_QUOTE_CLOSE", "&rsquo;");
/* 32 */   public static final DataKey<String> SINGLE_QUOTE_OPEN = new DataKey("SINGLE_QUOTE_OPEN", "&lsquo;");
/* 33 */   public static final DataKey<String> SINGLE_QUOTE_UNMATCHED = new DataKey("SINGLE_QUOTE_UNMATCHED", "&rsquo;");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypographicExtension create() {
/* 39 */     return new TypographicExtension();
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
/* 54 */     if (((Boolean)ENABLE_QUOTES.get((DataHolder)paramBuilder)).booleanValue()) {
/* 55 */       TypographicOptions typographicOptions = new TypographicOptions((DataHolder)paramBuilder);
/* 56 */       paramBuilder.customDelimiterProcessor((DelimiterProcessor)new AngleQuoteDelimiterProcessor(typographicOptions));
/* 57 */       paramBuilder.customDelimiterProcessor((DelimiterProcessor)new SingleQuoteDelimiterProcessor(typographicOptions));
/* 58 */       paramBuilder.customDelimiterProcessor((DelimiterProcessor)new DoubleQuoteDelimiterProcessor(typographicOptions));
/*    */     } 
/* 60 */     if (((Boolean)ENABLE_SMARTS.get((DataHolder)paramBuilder)).booleanValue()) {
/* 61 */       paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new SmartsInlineParser.Factory());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 67 */     if (paramBuilder.isRendererType("HTML") || paramBuilder.isRendererType("JIRA"))
/* 68 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new TypographicNodeRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\TypographicExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */