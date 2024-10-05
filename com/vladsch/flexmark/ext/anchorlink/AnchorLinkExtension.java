/*    */ package com.vladsch.flexmark.ext.anchorlink;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.anchorlink.internal.AnchorLinkNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.anchorlink.internal.AnchorLinkNodeRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnchorLinkExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 19 */   public static final DataKey<Boolean> ANCHORLINKS_WRAP_TEXT = new DataKey("ANCHORLINKS_WRAP_TEXT", Boolean.TRUE);
/* 20 */   public static final DataKey<String> ANCHORLINKS_TEXT_PREFIX = new DataKey("ANCHORLINKS_TEXT_PREFIX", "");
/* 21 */   public static final DataKey<String> ANCHORLINKS_TEXT_SUFFIX = new DataKey("ANCHORLINKS_TEXT_SUFFIX", "");
/* 22 */   public static final DataKey<String> ANCHORLINKS_ANCHOR_CLASS = new DataKey("ANCHORLINKS_ANCHOR_CLASS", "");
/* 23 */   public static final DataKey<Boolean> ANCHORLINKS_SET_NAME = new DataKey("ANCHORLINKS_SET_NAME", Boolean.FALSE);
/* 24 */   public static final DataKey<Boolean> ANCHORLINKS_SET_ID = new DataKey("ANCHORLINKS_SET_ID", Boolean.TRUE);
/* 25 */   public static final DataKey<Boolean> ANCHORLINKS_NO_BLOCK_QUOTE = new DataKey("ANCHORLINKS_NO_BLOCK_QUOTE", Boolean.FALSE);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AnchorLinkExtension create() {
/* 31 */     return new AnchorLinkExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 36 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new AnchorLinkNodePostProcessor.Factory((DataHolder)paramBuilder));
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
/* 51 */     if (paramBuilder.isRendererType("HTML")) {
/* 52 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new AnchorLinkNodeRenderer.Factory()); return;
/* 53 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\anchorlink\AnchorLinkExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */