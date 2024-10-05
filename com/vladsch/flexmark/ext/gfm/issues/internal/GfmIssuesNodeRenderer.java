/*    */ package com.vladsch.flexmark.ext.gfm.issues.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.issues.GfmIssue;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GfmIssuesNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final GfmIssuesOptions options;
/*    */   
/*    */   public GfmIssuesNodeRenderer(DataHolder paramDataHolder) {
/* 21 */     this.options = new GfmIssuesOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 28 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(GfmIssue.class, this::render));
/*    */     
/* 30 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(GfmIssue paramGfmIssue, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 34 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 35 */       paramHtmlWriter.text((CharSequence)paramGfmIssue.getChars());
/*    */       return;
/*    */     } 
/*    */     StringBuilder stringBuilder;
/* 39 */     (stringBuilder = new StringBuilder()).append(this.options.gitHubIssuesUrlRoot).append(this.options.gitHubIssueUrlPrefix).append((CharSequence)paramGfmIssue.getText()).append(this.options.gitHubIssueUrlSuffix);
/*    */     
/* 41 */     ((HtmlWriter)paramHtmlWriter.srcPos(paramGfmIssue.getChars()).attr("href", stringBuilder.toString())).withAttr().tag("a");
/* 42 */     paramHtmlWriter.raw(this.options.gitHubIssueTextPrefix);
/* 43 */     paramHtmlWriter.text((CharSequence)paramGfmIssue.getChars());
/* 44 */     paramHtmlWriter.raw(this.options.gitHubIssueTextSuffix);
/* 45 */     paramHtmlWriter.tag("/a");
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 53 */       return new GfmIssuesNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\issues\internal\GfmIssuesNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */