/*    */ package com.vladsch.flexmark.ext.ins;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.ins.internal.InsDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.ins.internal.InsJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.ins.internal.InsNodeRenderer;
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
/*    */ public class InsExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 20 */   public static final NullableDataKey<String> INS_STYLE_HTML_OPEN = new NullableDataKey("INS_STYLE_HTML_OPEN");
/* 21 */   public static final NullableDataKey<String> INS_STYLE_HTML_CLOSE = new NullableDataKey("INS_STYLE_HTML_CLOSE");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static InsExtension create() {
/* 27 */     return new InsExtension();
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
/* 42 */     paramBuilder.customDelimiterProcessor((DelimiterProcessor)new InsDelimiterProcessor());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 47 */     if (paramBuilder.isRendererType("HTML")) {
/* 48 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new InsNodeRenderer.Factory()); return;
/* 49 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 50 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new InsJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\ins\InsExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */