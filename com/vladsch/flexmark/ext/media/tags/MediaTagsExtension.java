/*    */ package com.vladsch.flexmark.ext.media.tags;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.MediaTagsNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.MediaTagsNodeRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ public class MediaTagsExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension {
/*    */   public static MediaTagsExtension create() {
/* 15 */     return new MediaTagsExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 20 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new MediaTagsNodePostProcessor.Factory((DataHolder)paramBuilder));
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
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 35 */     if (paramBuilder.isRendererType("HTML")) {
/* 36 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new MediaTagsNodeRenderer.Factory()); return;
/* 37 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\MediaTagsExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */