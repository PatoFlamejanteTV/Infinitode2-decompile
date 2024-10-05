/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.misc.Utils;
/*    */ import java.util.HashMap;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HtmlRendererOptions
/*    */ {
/*    */   public final String softBreak;
/*    */   public final boolean isSoftBreakAllSpaces;
/*    */   public final String hardBreak;
/*    */   public final String strongEmphasisStyleHtmlOpen;
/*    */   public final String strongEmphasisStyleHtmlClose;
/*    */   public final String emphasisStyleHtmlOpen;
/*    */   public final String emphasisStyleHtmlClose;
/*    */   public final String codeStyleHtmlOpen;
/*    */   public final String codeStyleHtmlClose;
/*    */   public final boolean escapeHtmlBlocks;
/*    */   public final boolean escapeHtmlCommentBlocks;
/*    */   public final boolean escapeInlineHtml;
/*    */   public final boolean escapeInlineHtmlComments;
/*    */   public final boolean percentEncodeUrls;
/*    */   public final int indentSize;
/*    */   public final boolean suppressHtmlBlocks;
/*    */   public final boolean suppressHtmlCommentBlocks;
/*    */   public final boolean suppressInlineHtml;
/*    */   public final boolean suppressInlineHtmlComments;
/*    */   public final boolean doNotRenderLinksInDocument;
/*    */   public final boolean renderHeaderId;
/*    */   public final boolean generateHeaderIds;
/*    */   public final String languageClassPrefix;
/*    */   public final HashMap<String, String> languageClassMap;
/*    */   public final String languageDelimiters;
/*    */   public final CharPredicate languageDelimiterSet;
/*    */   public final String noLanguageClass;
/*    */   public final String sourcePositionAttribute;
/*    */   public final String inlineCodeSpliceClass;
/*    */   public final boolean sourcePositionParagraphLines;
/*    */   public final boolean sourceWrapHtmlBlocks;
/*    */   public final int formatFlags;
/*    */   public final int maxTrailingBlankLines;
/*    */   public final int maxBlankLines;
/*    */   public final boolean htmlBlockOpenTagEol;
/*    */   public final boolean htmlBlockCloseTagEol;
/*    */   public final boolean unescapeHtmlEntities;
/*    */   public final boolean noPTagsUseBr;
/*    */   public final String autolinkWwwPrefix;
/*    */   public final Pattern suppressedLinks;
/*    */   
/*    */   public HtmlRendererOptions(DataHolder paramDataHolder) {
/* 55 */     this.softBreak = (String)HtmlRenderer.SOFT_BREAK.get(paramDataHolder);
/* 56 */     this.isSoftBreakAllSpaces = Utils.isWhiteSpaceNoEOL(this.softBreak);
/* 57 */     this.hardBreak = (String)HtmlRenderer.HARD_BREAK.get(paramDataHolder);
/* 58 */     this.strongEmphasisStyleHtmlOpen = (String)HtmlRenderer.STRONG_EMPHASIS_STYLE_HTML_OPEN.get(paramDataHolder);
/* 59 */     this.strongEmphasisStyleHtmlClose = (String)HtmlRenderer.STRONG_EMPHASIS_STYLE_HTML_CLOSE.get(paramDataHolder);
/* 60 */     this.emphasisStyleHtmlOpen = (String)HtmlRenderer.EMPHASIS_STYLE_HTML_OPEN.get(paramDataHolder);
/* 61 */     this.emphasisStyleHtmlClose = (String)HtmlRenderer.EMPHASIS_STYLE_HTML_CLOSE.get(paramDataHolder);
/* 62 */     this.codeStyleHtmlOpen = (String)HtmlRenderer.CODE_STYLE_HTML_OPEN.get(paramDataHolder);
/* 63 */     this.codeStyleHtmlClose = (String)HtmlRenderer.CODE_STYLE_HTML_CLOSE.get(paramDataHolder);
/* 64 */     this.escapeHtmlBlocks = ((Boolean)HtmlRenderer.ESCAPE_HTML_BLOCKS.get(paramDataHolder)).booleanValue();
/* 65 */     this.escapeHtmlCommentBlocks = ((Boolean)HtmlRenderer.ESCAPE_HTML_COMMENT_BLOCKS.get(paramDataHolder)).booleanValue();
/* 66 */     this.escapeInlineHtml = ((Boolean)HtmlRenderer.ESCAPE_INLINE_HTML.get(paramDataHolder)).booleanValue();
/* 67 */     this.escapeInlineHtmlComments = ((Boolean)HtmlRenderer.ESCAPE_INLINE_HTML_COMMENTS.get(paramDataHolder)).booleanValue();
/* 68 */     this.percentEncodeUrls = ((Boolean)HtmlRenderer.PERCENT_ENCODE_URLS.get(paramDataHolder)).booleanValue();
/* 69 */     this.indentSize = ((Integer)HtmlRenderer.INDENT_SIZE.get(paramDataHolder)).intValue();
/* 70 */     this.suppressHtmlBlocks = ((Boolean)HtmlRenderer.SUPPRESS_HTML_BLOCKS.get(paramDataHolder)).booleanValue();
/* 71 */     this.suppressHtmlCommentBlocks = ((Boolean)HtmlRenderer.SUPPRESS_HTML_COMMENT_BLOCKS.get(paramDataHolder)).booleanValue();
/* 72 */     this.suppressInlineHtml = ((Boolean)HtmlRenderer.SUPPRESS_INLINE_HTML.get(paramDataHolder)).booleanValue();
/* 73 */     this.suppressInlineHtmlComments = ((Boolean)HtmlRenderer.SUPPRESS_INLINE_HTML_COMMENTS.get(paramDataHolder)).booleanValue();
/* 74 */     this.doNotRenderLinksInDocument = ((Boolean)HtmlRenderer.DO_NOT_RENDER_LINKS.get(paramDataHolder)).booleanValue();
/* 75 */     this.renderHeaderId = ((Boolean)HtmlRenderer.RENDER_HEADER_ID.get(paramDataHolder)).booleanValue();
/* 76 */     this.generateHeaderIds = ((Boolean)HtmlRenderer.GENERATE_HEADER_ID.get(paramDataHolder)).booleanValue();
/* 77 */     this.languageClassPrefix = (String)HtmlRenderer.FENCED_CODE_LANGUAGE_CLASS_PREFIX.get(paramDataHolder);
/* 78 */     this.languageClassMap = (HashMap<String, String>)HtmlRenderer.FENCED_CODE_LANGUAGE_CLASS_MAP.get(paramDataHolder);
/* 79 */     this.languageDelimiters = (String)HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS.get(paramDataHolder);
/* 80 */     this.languageDelimiterSet = CharPredicate.anyOf(this.languageDelimiters);
/* 81 */     this.noLanguageClass = (String)HtmlRenderer.FENCED_CODE_NO_LANGUAGE_CLASS.get(paramDataHolder);
/* 82 */     this.sourcePositionAttribute = (String)HtmlRenderer.SOURCE_POSITION_ATTRIBUTE.get(paramDataHolder);
/* 83 */     this.sourcePositionParagraphLines = (!this.sourcePositionAttribute.isEmpty() && ((Boolean)HtmlRenderer.SOURCE_POSITION_PARAGRAPH_LINES.get(paramDataHolder)).booleanValue());
/* 84 */     this.sourceWrapHtmlBlocks = (!this.sourcePositionAttribute.isEmpty() && ((Boolean)HtmlRenderer.SOURCE_WRAP_HTML_BLOCKS.get(paramDataHolder)).booleanValue());
/* 85 */     this.formatFlags = ((Integer)HtmlRenderer.FORMAT_FLAGS.get(paramDataHolder)).intValue();
/* 86 */     this.maxTrailingBlankLines = ((Integer)HtmlRenderer.MAX_TRAILING_BLANK_LINES.get(paramDataHolder)).intValue();
/* 87 */     this.maxBlankLines = ((Integer)HtmlRenderer.MAX_BLANK_LINES.get(paramDataHolder)).intValue();
/* 88 */     this.htmlBlockOpenTagEol = ((Boolean)HtmlRenderer.HTML_BLOCK_OPEN_TAG_EOL.get(paramDataHolder)).booleanValue();
/* 89 */     this.htmlBlockCloseTagEol = ((Boolean)HtmlRenderer.HTML_BLOCK_CLOSE_TAG_EOL.get(paramDataHolder)).booleanValue();
/* 90 */     this.unescapeHtmlEntities = ((Boolean)HtmlRenderer.UNESCAPE_HTML_ENTITIES.get(paramDataHolder)).booleanValue();
/* 91 */     this.noPTagsUseBr = ((Boolean)HtmlRenderer.NO_P_TAGS_USE_BR.get(paramDataHolder)).booleanValue();
/* 92 */     this.inlineCodeSpliceClass = (String)HtmlRenderer.INLINE_CODE_SPLICE_CLASS.get(paramDataHolder);
/* 93 */     this.autolinkWwwPrefix = (String)HtmlRenderer.AUTOLINK_WWW_PREFIX.get(paramDataHolder);
/*    */     
/* 95 */     String str = (String)HtmlRenderer.SUPPRESSED_LINKS.get(paramDataHolder);
/* 96 */     this.suppressedLinks = str.isEmpty() ? null : Pattern.compile(str);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\HtmlRendererOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */