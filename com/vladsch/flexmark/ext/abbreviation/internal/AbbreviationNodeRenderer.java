/*    */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.Abbreviation;
/*    */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationBlock;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class AbbreviationNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final AbbreviationOptions options;
/*    */   
/*    */   public AbbreviationNodeRenderer(DataHolder paramDataHolder) {
/* 22 */     this.options = new AbbreviationOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/* 27 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(Abbreviation.class, this::render), new NodeRenderingHandler(AbbreviationBlock.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(AbbreviationBlock paramAbbreviationBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(Abbreviation paramAbbreviation, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 38 */     String str2, str1 = paramAbbreviation.getChars().unescape();
/* 39 */     BasedSequence basedSequence = paramAbbreviation.getAbbreviation();
/*    */ 
/*    */     
/* 42 */     if (this.options.useLinks) {
/* 43 */       paramHtmlWriter.attr("href", "#");
/* 44 */       str2 = "a";
/*    */     } else {
/* 46 */       str2 = "abbr";
/*    */     } 
/*    */     
/* 49 */     paramHtmlWriter.attr("title", (CharSequence)basedSequence);
/* 50 */     paramHtmlWriter.srcPos(paramAbbreviation.getChars()).withAttr().tag(str2);
/* 51 */     paramHtmlWriter.text(str1);
/* 52 */     paramHtmlWriter.closeTag(str2);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 59 */       return new AbbreviationNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */