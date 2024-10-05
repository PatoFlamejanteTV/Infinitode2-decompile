/*    */ package com.vladsch.flexmark.ext.gfm.issues;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.issues.internal.GfmIssuesInlineParserExtension;
/*    */ import com.vladsch.flexmark.ext.gfm.issues.internal.GfmIssuesJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.issues.internal.GfmIssuesNodeRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GfmIssuesExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 22 */   public static final DataKey<String> GIT_HUB_ISSUES_URL_ROOT = new DataKey("GIT_HUB_ISSUES_URL_ROOT", "issues");
/* 23 */   public static final DataKey<String> GIT_HUB_ISSUE_URL_PREFIX = new DataKey("GIT_HUB_ISSUE_URL_PREFIX", "/");
/* 24 */   public static final DataKey<String> GIT_HUB_ISSUE_URL_SUFFIX = new DataKey("GIT_HUB_ISSUE_URL_SUFFIX", "");
/* 25 */   public static final DataKey<String> GIT_HUB_ISSUE_HTML_PREFIX = new DataKey("GIT_HUB_ISSUE_HTML_PREFIX", "");
/* 26 */   public static final DataKey<String> GIT_HUB_ISSUE_HTML_SUFFIX = new DataKey("GIT_HUB_ISSUE_HTML_SUFFIX", "");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GfmIssuesExtension create() {
/* 32 */     return new GfmIssuesExtension();
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
/* 47 */     paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new GfmIssuesInlineParserExtension.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 52 */     if (paramBuilder.isRendererType("HTML")) {
/* 53 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new GfmIssuesNodeRenderer.Factory()); return;
/* 54 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 55 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new GfmIssuesJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\issues\GfmIssuesExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */