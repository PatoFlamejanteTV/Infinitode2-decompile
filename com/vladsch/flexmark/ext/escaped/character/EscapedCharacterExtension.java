/*    */ package com.vladsch.flexmark.ext.escaped.character;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.escaped.character.internal.EscapedCharacterNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.escaped.character.internal.EscapedCharacterNodeRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EscapedCharacterExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/*    */   public static EscapedCharacterExtension create() {
/* 22 */     return new EscapedCharacterExtension();
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
/* 37 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new EscapedCharacterNodePostProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 42 */     if (paramBuilder.isRendererType("HTML")) {
/* 43 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new EscapedCharacterNodeRenderer.Factory()); return;
/* 44 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\escaped\character\EscapedCharacterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */