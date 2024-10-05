/*    */ package com.vladsch.flexmark.youtrack.converter;
/*    */ 
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.youtrack.converter.internal.YouTrackConverterNodeRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YouTrackConverterExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/*    */   public static YouTrackConverterExtension create() {
/* 22 */     return new YouTrackConverterExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {}
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {
/*    */     String str;
/* 32 */     if ((str = (String)HtmlRenderer.TYPE.get((DataHolder)paramMutableDataHolder)).equals("HTML")) {
/*    */       
/* 34 */       HtmlRenderer.addRenderTypeEquivalence(paramMutableDataHolder, "YOUTRACK", "JIRA");
/* 35 */       paramMutableDataHolder.set(HtmlRenderer.TYPE, "YOUTRACK"); return;
/* 36 */     }  if (!str.equals("YOUTRACK")) {
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
/* 48 */     if (paramBuilder.isRendererType("YOUTRACK")) {
/* 49 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new YouTrackConverterNodeRenderer.Factory()); return;
/*    */     } 
/* 51 */     throw new IllegalStateException("YouTrack Converter Extension used with non YouTrack Renderer " + paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\youtrack\converter\YouTrackConverterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */