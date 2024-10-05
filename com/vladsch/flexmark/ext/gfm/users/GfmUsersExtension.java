/*    */ package com.vladsch.flexmark.ext.gfm.users;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.users.internal.GfmUsersInlineParserExtension;
/*    */ import com.vladsch.flexmark.ext.gfm.users.internal.GfmUsersJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.gfm.users.internal.GfmUsersNodeRenderer;
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
/*    */ public class GfmUsersExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 22 */   public static final DataKey<String> GIT_HUB_USERS_URL_ROOT = new DataKey("GIT_HUB_USERS_URL_ROOT", "https://github.com");
/* 23 */   public static final DataKey<String> GIT_HUB_USER_URL_PREFIX = new DataKey("GIT_HUB_USER_URL_PREFIX", "/");
/* 24 */   public static final DataKey<String> GIT_HUB_USER_URL_SUFFIX = new DataKey("GIT_HUB_USER_URL_SUFFIX", "");
/* 25 */   public static final DataKey<String> GIT_HUB_USER_HTML_PREFIX = new DataKey("GIT_HUB_USER_HTML_PREFIX", "<strong>");
/* 26 */   public static final DataKey<String> GIT_HUB_USER_HTML_SUFFIX = new DataKey("GIT_HUB_USER_HTML_SUFFIX", "</strong>");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GfmUsersExtension create() {
/* 32 */     return new GfmUsersExtension();
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
/* 47 */     paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new GfmUsersInlineParserExtension.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 52 */     if (paramBuilder.isRendererType("HTML")) {
/* 53 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new GfmUsersNodeRenderer.Factory()); return;
/* 54 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 55 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new GfmUsersJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gf\\users\GfmUsersExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */