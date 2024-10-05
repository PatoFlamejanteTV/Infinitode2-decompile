/*    */ package com.vladsch.flexmark.ext.gitlab.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GitLabOptions
/*    */   implements MutableDataSetter
/*    */ {
/*    */   public final boolean insParser;
/*    */   public final boolean delParser;
/*    */   public final boolean inlineMathParser;
/*    */   public final boolean blockQuoteParser;
/*    */   public final boolean nestedBlockQuotes;
/*    */   public final boolean renderBlockMath;
/*    */   public final boolean renderBlockMermaid;
/*    */   public final boolean renderVideoImages;
/*    */   public final boolean renderVideoLink;
/*    */   public final String inlineMathClass;
/*    */   public final String blockMathClass;
/*    */   public final String blockMermaidClass;
/*    */   public final String[] mathLanguages;
/*    */   public final String[] mermaidLanguages;
/*    */   public final String videoImageClass;
/*    */   public final String videoImageLinkTextFormat;
/*    */   public final String videoImageExtensions;
/*    */   public final HashSet<String> videoImageExtensionSet;
/*    */   @Deprecated
/*    */   public final String blockInfoDelimiters;
/*    */   @Deprecated
/*    */   public final CharPredicate blockInfoDelimiterSet;
/*    */   
/*    */   public GitLabOptions(DataHolder paramDataHolder) {
/* 46 */     this.insParser = ((Boolean)GitLabExtension.INS_PARSER.get(paramDataHolder)).booleanValue();
/* 47 */     this.delParser = ((Boolean)GitLabExtension.DEL_PARSER.get(paramDataHolder)).booleanValue();
/* 48 */     this.inlineMathParser = ((Boolean)GitLabExtension.INLINE_MATH_PARSER.get(paramDataHolder)).booleanValue();
/* 49 */     this.blockQuoteParser = ((Boolean)GitLabExtension.BLOCK_QUOTE_PARSER.get(paramDataHolder)).booleanValue();
/* 50 */     this.nestedBlockQuotes = ((Boolean)GitLabExtension.NESTED_BLOCK_QUOTES.get(paramDataHolder)).booleanValue();
/* 51 */     this.inlineMathClass = (String)GitLabExtension.INLINE_MATH_CLASS.get(paramDataHolder);
/* 52 */     this.renderBlockMath = ((Boolean)GitLabExtension.RENDER_BLOCK_MATH.get(paramDataHolder)).booleanValue();
/* 53 */     this.renderBlockMermaid = ((Boolean)GitLabExtension.RENDER_BLOCK_MERMAID.get(paramDataHolder)).booleanValue();
/* 54 */     this.renderVideoImages = ((Boolean)GitLabExtension.RENDER_VIDEO_IMAGES.get(paramDataHolder)).booleanValue();
/* 55 */     this.renderVideoLink = ((Boolean)GitLabExtension.RENDER_VIDEO_LINK.get(paramDataHolder)).booleanValue();
/* 56 */     this.blockMathClass = (String)GitLabExtension.BLOCK_MATH_CLASS.get(paramDataHolder);
/* 57 */     this.blockMermaidClass = (String)GitLabExtension.BLOCK_MERMAID_CLASS.get(paramDataHolder);
/* 58 */     this.blockInfoDelimiters = (String)HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS.get(paramDataHolder);
/* 59 */     this.blockInfoDelimiterSet = CharPredicate.anyOf(this.blockInfoDelimiters);
/* 60 */     this.mathLanguages = (String[])GitLabExtension.MATH_LANGUAGES.get(paramDataHolder);
/* 61 */     this.mermaidLanguages = (String[])GitLabExtension.MERMAID_LANGUAGES.get(paramDataHolder);
/* 62 */     this.videoImageClass = (String)GitLabExtension.VIDEO_IMAGE_CLASS.get(paramDataHolder);
/* 63 */     this.videoImageLinkTextFormat = (String)GitLabExtension.VIDEO_IMAGE_LINK_TEXT_FORMAT.get(paramDataHolder);
/* 64 */     this.videoImageExtensions = (String)GitLabExtension.VIDEO_IMAGE_EXTENSIONS.get(paramDataHolder);
/* 65 */     this.videoImageExtensionSet = new HashSet<>(); String[] arrayOfString; int i;
/*    */     byte b;
/* 67 */     for (i = (arrayOfString = arrayOfString = this.videoImageExtensions.split(",")).length, b = 0; b < i; b++) {
/*    */       String str;
/* 69 */       if (!(str = (str = arrayOfString[b]).trim()).isEmpty()) {
/* 70 */         this.videoImageExtensionSet.add(str);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 78 */     paramMutableDataHolder.set(GitLabExtension.INS_PARSER, Boolean.valueOf(this.insParser));
/* 79 */     paramMutableDataHolder.set(GitLabExtension.DEL_PARSER, Boolean.valueOf(this.delParser));
/* 80 */     paramMutableDataHolder.set(GitLabExtension.INLINE_MATH_PARSER, Boolean.valueOf(this.inlineMathParser));
/* 81 */     paramMutableDataHolder.set(GitLabExtension.BLOCK_QUOTE_PARSER, Boolean.valueOf(this.blockQuoteParser));
/* 82 */     paramMutableDataHolder.set(GitLabExtension.NESTED_BLOCK_QUOTES, Boolean.valueOf(this.nestedBlockQuotes));
/* 83 */     paramMutableDataHolder.set(GitLabExtension.INLINE_MATH_CLASS, this.inlineMathClass);
/* 84 */     paramMutableDataHolder.set(GitLabExtension.RENDER_BLOCK_MATH, Boolean.valueOf(this.renderBlockMath));
/* 85 */     paramMutableDataHolder.set(GitLabExtension.RENDER_BLOCK_MERMAID, Boolean.valueOf(this.renderBlockMermaid));
/* 86 */     paramMutableDataHolder.set(GitLabExtension.RENDER_VIDEO_IMAGES, Boolean.valueOf(this.renderVideoImages));
/* 87 */     paramMutableDataHolder.set(GitLabExtension.RENDER_VIDEO_LINK, Boolean.valueOf(this.renderVideoLink));
/* 88 */     paramMutableDataHolder.set(GitLabExtension.BLOCK_MATH_CLASS, this.blockMathClass);
/* 89 */     paramMutableDataHolder.set(GitLabExtension.BLOCK_MERMAID_CLASS, this.blockMermaidClass);
/* 90 */     paramMutableDataHolder.set(HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS, this.blockInfoDelimiters);
/* 91 */     paramMutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_CLASS, this.videoImageClass);
/* 92 */     paramMutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_LINK_TEXT_FORMAT, this.videoImageLinkTextFormat);
/* 93 */     paramMutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_EXTENSIONS, this.videoImageExtensions);
/* 94 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */