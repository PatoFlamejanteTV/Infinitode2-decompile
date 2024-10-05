/*     */ package com.vladsch.flexmark.formatter;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.format.CharWidthProvider;
/*     */ import com.vladsch.flexmark.util.format.options.BlockQuoteMarker;
/*     */ import com.vladsch.flexmark.util.format.options.CodeFenceMarker;
/*     */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*     */ import com.vladsch.flexmark.util.format.options.ElementAlignment;
/*     */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*     */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*     */ import com.vladsch.flexmark.util.format.options.EqualizeTrailingMarker;
/*     */ import com.vladsch.flexmark.util.format.options.HeadingStyle;
/*     */ import com.vladsch.flexmark.util.format.options.ListBulletMarker;
/*     */ import com.vladsch.flexmark.util.format.options.ListNumberedMarker;
/*     */ import com.vladsch.flexmark.util.format.options.ListSpacing;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormatterOptions
/*     */ {
/*     */   public final boolean itemContentIndent;
/*     */   public final ParserEmulationProfile emulationProfile;
/*     */   public final boolean setextHeadingEqualizeMarker;
/*     */   public final int formatFlags;
/*     */   public final int maxBlankLines;
/*     */   public final int maxTrailingBlankLines;
/*     */   public final int rightMargin;
/*     */   public final int minSetextMarkerLength;
/*     */   public final DiscretionaryText spaceAfterAtxMarker;
/*     */   public final EqualizeTrailingMarker atxHeadingTrailingMarker;
/*     */   public final HeadingStyle headingStyle;
/*     */   public final boolean blockQuoteBlankLines;
/*     */   public final BlockQuoteMarker blockQuoteMarkers;
/*     */   public final String thematicBreak;
/*     */   public final String translationIdFormat;
/*     */   public final String translationHtmlBlockPrefix;
/*     */   public final String translationHtmlInlinePrefix;
/*     */   public final String translationExcludePattern;
/*     */   public final String translationHtmlBlockTagPattern;
/*     */   public final String translationHtmlInlineTagPattern;
/*     */   public final String translationAutolinkPrefix;
/*     */   public final boolean indentedCodeMinimizeIndent;
/*     */   public final boolean fencedCodeMinimizeIndent;
/*     */   public final boolean fencedCodeMatchClosingMarker;
/*     */   public final boolean fencedCodeSpaceBeforeInfo;
/*     */   public final int fencedCodeMarkerLength;
/*     */   public final CodeFenceMarker fencedCodeMarkerType;
/*     */   
/*     */   public FormatterOptions(DataHolder paramDataHolder) {
/*  71 */     this.emulationProfile = (ParserEmulationProfile)Formatter.FORMATTER_EMULATION_PROFILE.get(paramDataHolder);
/*  72 */     this.itemContentIndent = (this.emulationProfile.family != ParserEmulationProfile.FIXED_INDENT);
/*     */     
/*  74 */     this.setextHeadingEqualizeMarker = ((Boolean)Formatter.SETEXT_HEADING_EQUALIZE_MARKER.get(paramDataHolder)).booleanValue();
/*  75 */     this.formatFlags = ((Integer)Formatter.FORMAT_FLAGS.get(paramDataHolder)).intValue();
/*  76 */     this.maxBlankLines = ((Integer)Formatter.MAX_BLANK_LINES.get(paramDataHolder)).intValue();
/*  77 */     this.maxTrailingBlankLines = ((Integer)Formatter.MAX_TRAILING_BLANK_LINES.get(paramDataHolder)).intValue();
/*  78 */     this.rightMargin = ((Integer)Formatter.RIGHT_MARGIN.get(paramDataHolder)).intValue();
/*  79 */     this.minSetextMarkerLength = ((Integer)Parser.HEADING_SETEXT_MARKER_LENGTH.get(paramDataHolder)).intValue();
/*  80 */     this.spaceAfterAtxMarker = (DiscretionaryText)Formatter.SPACE_AFTER_ATX_MARKER.get(paramDataHolder);
/*  81 */     this.atxHeadingTrailingMarker = (EqualizeTrailingMarker)Formatter.ATX_HEADING_TRAILING_MARKER.get(paramDataHolder);
/*  82 */     this.headingStyle = (HeadingStyle)Formatter.HEADING_STYLE.get(paramDataHolder);
/*  83 */     this.thematicBreak = (String)Formatter.THEMATIC_BREAK.get(paramDataHolder);
/*  84 */     this.translationIdFormat = (String)Formatter.TRANSLATION_ID_FORMAT.get(paramDataHolder);
/*  85 */     this.translationHtmlBlockPrefix = (String)Formatter.TRANSLATION_HTML_BLOCK_PREFIX.get(paramDataHolder);
/*  86 */     this.translationHtmlInlinePrefix = (String)Formatter.TRANSLATION_HTML_INLINE_PREFIX.get(paramDataHolder);
/*  87 */     this.translationAutolinkPrefix = (String)Formatter.TRANSLATION_AUTOLINK_PREFIX.get(paramDataHolder);
/*  88 */     this.translationExcludePattern = (String)Formatter.TRANSLATION_EXCLUDE_PATTERN.get(paramDataHolder);
/*  89 */     this.translationHtmlBlockTagPattern = (String)Formatter.TRANSLATION_HTML_BLOCK_TAG_PATTERN.get(paramDataHolder);
/*  90 */     this.translationHtmlInlineTagPattern = (String)Formatter.TRANSLATION_HTML_INLINE_TAG_PATTERN.get(paramDataHolder);
/*  91 */     this.blockQuoteBlankLines = ((Boolean)Formatter.BLOCK_QUOTE_BLANK_LINES.get(paramDataHolder)).booleanValue();
/*  92 */     this.blockQuoteMarkers = (BlockQuoteMarker)Formatter.BLOCK_QUOTE_MARKERS.get(paramDataHolder);
/*  93 */     this.indentedCodeMinimizeIndent = ((Boolean)Formatter.INDENTED_CODE_MINIMIZE_INDENT.get(paramDataHolder)).booleanValue();
/*  94 */     this.fencedCodeMinimizeIndent = ((Boolean)Formatter.FENCED_CODE_MINIMIZE_INDENT.get(paramDataHolder)).booleanValue();
/*  95 */     this.fencedCodeMatchClosingMarker = ((Boolean)Formatter.FENCED_CODE_MATCH_CLOSING_MARKER.get(paramDataHolder)).booleanValue();
/*  96 */     this.fencedCodeSpaceBeforeInfo = ((Boolean)Formatter.FENCED_CODE_SPACE_BEFORE_INFO.get(paramDataHolder)).booleanValue();
/*  97 */     this.fencedCodeMarkerLength = ((Integer)Formatter.FENCED_CODE_MARKER_LENGTH.get(paramDataHolder)).intValue();
/*  98 */     this.fencedCodeMarkerType = (CodeFenceMarker)Formatter.FENCED_CODE_MARKER_TYPE.get(paramDataHolder);
/*  99 */     this.listAddBlankLineBefore = ((Boolean)Formatter.LIST_ADD_BLANK_LINE_BEFORE.get(paramDataHolder)).booleanValue();
/* 100 */     this.listAlignNumeric = (ElementAlignment)Formatter.LIST_ALIGN_NUMERIC.get(paramDataHolder);
/* 101 */     this.listResetFirstItemNumber = ((Boolean)Formatter.LIST_RESET_FIRST_ITEM_NUMBER.get(paramDataHolder)).booleanValue();
/* 102 */     this.listRenumberItems = ((Boolean)Formatter.LIST_RENUMBER_ITEMS.get(paramDataHolder)).booleanValue();
/* 103 */     this.listRemoveEmptyItems = ((Boolean)Formatter.LIST_REMOVE_EMPTY_ITEMS.get(paramDataHolder)).booleanValue();
/* 104 */     this.listBulletMarker = (ListBulletMarker)Formatter.LIST_BULLET_MARKER.get(paramDataHolder);
/* 105 */     this.listNumberedMarker = (ListNumberedMarker)Formatter.LIST_NUMBERED_MARKER.get(paramDataHolder);
/* 106 */     this.listSpacing = (ListSpacing)Formatter.LIST_SPACING.get(paramDataHolder);
/* 107 */     this.listsItemContentAfterSuffix = ((Boolean)Formatter.LISTS_ITEM_CONTENT_AFTER_SUFFIX.get(paramDataHolder)).booleanValue();
/* 108 */     this.referencePlacement = (ElementPlacement)Formatter.REFERENCE_PLACEMENT.get(paramDataHolder);
/* 109 */     this.referenceSort = (ElementPlacementSort)Formatter.REFERENCE_SORT.get(paramDataHolder);
/* 110 */     this.keepImageLinksAtStart = ((Boolean)Formatter.KEEP_IMAGE_LINKS_AT_START.get(paramDataHolder)).booleanValue();
/* 111 */     this.keepExplicitLinksAtStart = ((Boolean)Formatter.KEEP_EXPLICIT_LINKS_AT_START.get(paramDataHolder)).booleanValue();
/* 112 */     this.charWidthProvider = (CharWidthProvider)Formatter.FORMAT_CHAR_WIDTH_PROVIDER.get(paramDataHolder);
/* 113 */     this.keepHardLineBreaks = ((Boolean)Formatter.KEEP_HARD_LINE_BREAKS.get(paramDataHolder)).booleanValue();
/* 114 */     this.keepSoftLineBreaks = ((Boolean)Formatter.KEEP_SOFT_LINE_BREAKS.get(paramDataHolder)).booleanValue();
/* 115 */     this.formatterOnTag = (String)Formatter.FORMATTER_ON_TAG.get(paramDataHolder);
/* 116 */     this.formatterOffTag = (String)Formatter.FORMATTER_OFF_TAG.get(paramDataHolder);
/* 117 */     this.formatterTagsEnabled = ((Boolean)Formatter.FORMATTER_TAGS_ENABLED.get(paramDataHolder)).booleanValue();
/* 118 */     this.formatterTagsAcceptRegexp = ((Boolean)Formatter.FORMATTER_TAGS_ACCEPT_REGEXP.get(paramDataHolder)).booleanValue();
/* 119 */     this.linkMarkerCommentPattern = (Pattern)Formatter.LINK_MARKER_COMMENT_PATTERN.get(paramDataHolder);
/* 120 */     this.appendTransferredReferences = ((Boolean)Formatter.APPEND_TRANSFERRED_REFERENCES.get(paramDataHolder)).booleanValue();
/* 121 */     this.optimizedInlineRendering = ((Boolean)Formatter.OPTIMIZED_INLINE_RENDERING.get(paramDataHolder)).booleanValue();
/* 122 */     this.applySpecialLeadInHandlers = ((Boolean)Formatter.APPLY_SPECIAL_LEAD_IN_HANDLERS.get(paramDataHolder)).booleanValue();
/* 123 */     this.escapeSpecialCharsOnWrap = ((Boolean)Formatter.ESCAPE_SPECIAL_CHARS.get(paramDataHolder)).booleanValue();
/* 124 */     this.escapeNumberedLeadInOnWrap = ((Boolean)Formatter.ESCAPE_NUMBERED_LEAD_IN.get(paramDataHolder)).booleanValue();
/* 125 */     this.unescapeSpecialCharsOnWrap = ((Boolean)Formatter.UNESCAPE_SPECIAL_CHARS.get(paramDataHolder)).booleanValue();
/* 126 */     this.blankLinesInAst = ((Boolean)Parser.BLANK_LINES_IN_AST.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */   
/*     */   public final boolean listAddBlankLineBefore;
/*     */   public final boolean listRenumberItems;
/*     */   public final boolean listRemoveEmptyItems;
/*     */   public final boolean listsItemContentAfterSuffix;
/*     */   public final ListBulletMarker listBulletMarker;
/*     */   public final ListNumberedMarker listNumberedMarker;
/*     */   public final ListSpacing listSpacing;
/*     */   public final ElementPlacement referencePlacement;
/*     */   public final ElementPlacementSort referenceSort;
/*     */   public final boolean keepImageLinksAtStart;
/*     */   public final boolean keepExplicitLinksAtStart;
/*     */   public final boolean keepHardLineBreaks;
/*     */   public final boolean keepSoftLineBreaks;
/*     */   public final boolean appendTransferredReferences;
/*     */   public final boolean optimizedInlineRendering;
/*     */   public final boolean applySpecialLeadInHandlers;
/*     */   public final boolean escapeSpecialCharsOnWrap;
/*     */   public final boolean escapeNumberedLeadInOnWrap;
/*     */   public final boolean unescapeSpecialCharsOnWrap;
/*     */   public final CharWidthProvider charWidthProvider;
/*     */   public final ElementAlignment listAlignNumeric;
/*     */   public final boolean listResetFirstItemNumber;
/*     */   public final String formatterOnTag;
/*     */   public final String formatterOffTag;
/*     */   public final boolean formatterTagsEnabled;
/*     */   public final boolean formatterTagsAcceptRegexp;
/*     */   public final boolean blankLinesInAst;
/*     */   public final Pattern linkMarkerCommentPattern;
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\FormatterOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */