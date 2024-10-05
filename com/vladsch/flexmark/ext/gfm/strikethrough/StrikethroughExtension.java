/*    */ package com.vladsch.flexmark.ext.gfm.strikethrough;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughYouTrackRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StrikethroughExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 21 */   public static final NullableDataKey<String> STRIKETHROUGH_STYLE_HTML_OPEN = StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_OPEN;
/* 22 */   public static final NullableDataKey<String> STRIKETHROUGH_STYLE_HTML_CLOSE = StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_CLOSE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static StrikethroughExtension create() {
/* 28 */     return new StrikethroughExtension();
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
/* 43 */     paramBuilder.customDelimiterProcessor((DelimiterProcessor)new StrikethroughDelimiterProcessor());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 48 */     if (paramBuilder.isRendererType("HTML")) {
/* 49 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughNodeRenderer.Factory()); return;
/* 50 */     }  if (paramBuilder.isRendererType("YOUTRACK")) {
/* 51 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughYouTrackRenderer.Factory()); return;
/* 52 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 53 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\strikethrough\StrikethroughExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */