/*    */ package com.vladsch.flexmark.ext.gfm.strikethrough;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughYouTrackRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.internal.SubscriptDelimiterProcessor;
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
/*    */ 
/*    */ 
/*    */ public class SubscriptExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 23 */   public static final NullableDataKey<String> SUBSCRIPT_STYLE_HTML_OPEN = StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_OPEN;
/* 24 */   public static final NullableDataKey<String> SUBSCRIPT_STYLE_HTML_CLOSE = StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_CLOSE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SubscriptExtension create() {
/* 30 */     return new SubscriptExtension();
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
/* 45 */     paramBuilder.customDelimiterProcessor((DelimiterProcessor)new SubscriptDelimiterProcessor());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 50 */     if (paramBuilder.isRendererType("HTML")) {
/* 51 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughNodeRenderer.Factory()); return;
/* 52 */     }  if (paramBuilder.isRendererType("YOUTRACK")) {
/* 53 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughYouTrackRenderer.Factory()); return;
/* 54 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 55 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new StrikethroughJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\strikethrough\SubscriptExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */