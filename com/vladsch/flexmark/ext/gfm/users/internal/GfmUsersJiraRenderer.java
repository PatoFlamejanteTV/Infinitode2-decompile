/*    */ package com.vladsch.flexmark.ext.gfm.users.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.users.GfmUser;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class GfmUsersJiraRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final GfmUsersOptions options;
/*    */   
/*    */   public GfmUsersJiraRenderer(DataHolder paramDataHolder) {
/* 20 */     this.options = new GfmUsersOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/* 25 */     return new HashSet<>(Collections.singletonList(new NodeRenderingHandler(GfmUser.class, this::render)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(GfmUser paramGfmUser, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 31 */     if (paramNodeRendererContext.isDoNotRenderLinks()) {
/* 32 */       paramHtmlWriter.raw((CharSequence)paramGfmUser.getChars());
/*    */       return;
/*    */     } 
/*    */     StringBuilder stringBuilder;
/* 36 */     (stringBuilder = new StringBuilder()).append(this.options.gitHubIssuesUrlRoot).append(this.options.gitHubIssueUrlPrefix).append((CharSequence)paramGfmUser.getText()).append(this.options.gitHubIssueUrlSuffix);
/*    */     
/* 38 */     paramHtmlWriter.raw("[");
/* 39 */     paramHtmlWriter.raw((CharSequence)paramGfmUser.getChars());
/* 40 */     ((HtmlWriter)((HtmlWriter)paramHtmlWriter.raw("|")).raw(stringBuilder.toString())).raw("]");
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 48 */       return new GfmUsersJiraRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gf\\users\internal\GfmUsersJiraRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */