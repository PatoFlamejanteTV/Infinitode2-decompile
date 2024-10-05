/*    */ package com.vladsch.flexmark.ext.gitlab;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabBlockQuoteParser;
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabInlineMathParser;
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabInlineParser;
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabOptions;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GitLabExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 25 */   private static final String[] DEFAULT_MATH_LANGUAGES = new String[] { "math" };
/* 26 */   private static final String[] DEFAULT_MERMAID_LANGUAGES = new String[] { "mermaid" };
/*    */   
/* 28 */   public static final DataKey<Boolean> INS_PARSER = new DataKey("INS_PARSER", Boolean.TRUE);
/* 29 */   public static final DataKey<Boolean> DEL_PARSER = new DataKey("DEL_PARSER", Boolean.TRUE);
/* 30 */   public static final DataKey<Boolean> BLOCK_QUOTE_PARSER = new DataKey("BLOCK_QUOTE_PARSER", Boolean.TRUE);
/* 31 */   public static final DataKey<Boolean> NESTED_BLOCK_QUOTES = new DataKey("NESTED_BLOCK_QUOTES", Boolean.TRUE);
/* 32 */   public static final DataKey<Boolean> INLINE_MATH_PARSER = new DataKey("INLINE_MATH_PARSER", Boolean.TRUE);
/* 33 */   public static final DataKey<Boolean> RENDER_BLOCK_MATH = new DataKey("RENDER_BLOCK_MATH", Boolean.TRUE);
/* 34 */   public static final DataKey<Boolean> RENDER_BLOCK_MERMAID = new DataKey("RENDER_BLOCK_MERMAID", Boolean.TRUE);
/* 35 */   public static final DataKey<Boolean> RENDER_VIDEO_IMAGES = new DataKey("RENDER_VIDEO_IMAGES", Boolean.TRUE);
/* 36 */   public static final DataKey<Boolean> RENDER_VIDEO_LINK = new DataKey("RENDER_VIDEO_LINK", Boolean.TRUE);
/*    */   
/* 38 */   public static final DataKey<String[]> MATH_LANGUAGES = new DataKey("MATH_LANGUAGES", DEFAULT_MATH_LANGUAGES);
/* 39 */   public static final DataKey<String[]> MERMAID_LANGUAGES = new DataKey("MERMAID_LANGUAGES", DEFAULT_MERMAID_LANGUAGES);
/* 40 */   public static final DataKey<String> INLINE_MATH_CLASS = new DataKey("INLINE_MATH_CLASS", "katex");
/* 41 */   public static final DataKey<String> BLOCK_MATH_CLASS = new DataKey("BLOCK_MATH_CLASS", "katex");
/* 42 */   public static final DataKey<String> BLOCK_MERMAID_CLASS = new DataKey("BLOCK_MERMAID_CLASS", "mermaid");
/* 43 */   public static final DataKey<String> VIDEO_IMAGE_CLASS = new DataKey("VIDEO_IMAGE_CLASS", "video-container");
/* 44 */   public static final DataKey<String> VIDEO_IMAGE_LINK_TEXT_FORMAT = new DataKey("VIDEO_IMAGE_LINK_TEXT_FORMAT", "Download '%s'");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/* 50 */   public static final DataKey<String> BLOCK_INFO_DELIMITERS = HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS;
/* 51 */   public static final DataKey<String> VIDEO_IMAGE_EXTENSIONS = new DataKey("VIDEO_IMAGE_EXTENSIONS", "mp4,m4v,mov,webm,ogv");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GitLabExtension create() {
/* 57 */     return new GitLabExtension();
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
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 72 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new GitLabNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/*    */     GitLabOptions gitLabOptions;
/* 78 */     if ((gitLabOptions = new GitLabOptions((DataHolder)paramBuilder)).blockQuoteParser) {
/* 79 */       paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new GitLabBlockQuoteParser.Factory());
/*    */     }
/*    */     
/* 82 */     if (gitLabOptions.delParser || gitLabOptions.insParser) {
/* 83 */       paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new GitLabInlineParser.Factory());
/*    */     }
/*    */     
/* 86 */     if (gitLabOptions.inlineMathParser) {
/* 87 */       paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new GitLabInlineMathParser.Factory());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 93 */     if (paramBuilder.isRendererType("HTML")) {
/* 94 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new GitLabNodeRenderer.Factory()); return;
/* 95 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\GitLabExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */