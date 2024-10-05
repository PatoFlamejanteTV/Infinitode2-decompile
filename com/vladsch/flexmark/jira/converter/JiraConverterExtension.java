/*    */ package com.vladsch.flexmark.jira.converter;
/*    */ 
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.jira.converter.internal.JiraConverterNodeRenderer;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JiraConverterExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/*    */   public static JiraConverterExtension create() {
/* 23 */     return new JiraConverterExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {
/*    */     String str;
/* 34 */     if ((str = (String)HtmlRenderer.TYPE.get((DataHolder)paramMutableDataHolder)).equals("HTML")) {
/* 35 */       paramMutableDataHolder.set(HtmlRenderer.TYPE, "JIRA"); return;
/* 36 */     }  if (!str.equals("JIRA")) {
/* 37 */       throw new IllegalStateException("Non HTML Renderer is already set to " + str);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 48 */     if (paramBuilder.isRendererType("JIRA")) {
/* 49 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new JiraConverterNodeRenderer.Factory()); return;
/*    */     } 
/* 51 */     throw new IllegalStateException("Jira Converter Extension used with non Jira Renderer " + paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\jira\converter\JiraConverterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */