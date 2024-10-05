/*    */ package com.vladsch.flexmark.ext.jekyll.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.jekyll.front.matter.internal.JekyllFrontMatterBlockParser;
/*    */ import com.vladsch.flexmark.ext.jekyll.front.matter.internal.JekyllFrontMatterNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.jekyll.front.matter.internal.JekyllFrontMatterNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JekyllFrontMatterExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/*    */   public static JekyllFrontMatterExtension create() {
/* 24 */     return new JekyllFrontMatterExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 29 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new JekyllFrontMatterNodeFormatter.Factory());
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
/* 44 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new JekyllFrontMatterBlockParser.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 49 */     if (paramBuilder.isRendererType("HTML")) {
/* 50 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new JekyllFrontMatterNodeRenderer.Factory()); return;
/* 51 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\front\matter\JekyllFrontMatterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */