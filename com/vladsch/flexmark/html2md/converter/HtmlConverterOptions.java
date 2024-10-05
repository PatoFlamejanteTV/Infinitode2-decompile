/*     */ package com.vladsch.flexmark.html2md.converter;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*     */ import com.vladsch.flexmark.util.html.CellAlignment;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ public class HtmlConverterOptions
/*     */   implements MutableDataSetter
/*     */ {
/*     */   public boolean listContentIndent;
/*     */   public boolean setextHeadings;
/*     */   public boolean outputUnknownTags;
/*     */   public boolean typographicQuotes;
/*     */   public boolean typographicSmarts;
/*     */   public boolean outputAttributesIdAttr;
/*     */   public boolean wrapAutoLinks;
/*     */   public boolean extractAutoLinks;
/*     */   public boolean renderComments;
/*     */   public boolean dotOnlyNumericLists;
/*     */   public boolean commentOriginalNonNumericListItem;
/*     */   public boolean preCodePreserveEmphasis;
/*     */   public boolean listsEndOnDoubleBlank;
/*     */   public boolean divAsParagraph;
/*     */   public boolean brAsParaBreaks;
/*     */   public boolean brAsExtraBlankLines;
/*     */   public boolean ignoreTableHeadingAfterRows;
/*     */   public boolean addTrailingEol;
/*     */   public boolean skipHeading1;
/*     */   public boolean skipHeading2;
/*     */   public boolean skipHeading3;
/*     */   public boolean skipHeading4;
/*     */   public boolean skipHeading5;
/*     */   public boolean skipHeading6;
/*     */   public boolean skipAttributes;
/*     */   public boolean skipFencedCode;
/*     */   public boolean skipCharEscape;
/*     */   public boolean divTableProcessing;
/*     */   public ExtensionConversion extInlineStrong;
/*     */   public ExtensionConversion extInlineEmphasis;
/*     */   public ExtensionConversion extInlineCode;
/*     */   public ExtensionConversion extInlineDel;
/*     */   public ExtensionConversion extInlineIns;
/*     */   public ExtensionConversion extInlineSub;
/*     */   public ExtensionConversion extInlineSup;
/*     */   public ExtensionConversion extMath;
/*     */   public LinkConversion extInlineLink;
/*     */   public LinkConversion extInlineImage;
/*     */   public char orderedListDelimiter;
/*     */   public char unorderedListDelimiter;
/*     */   public int definitionMarkerSpaces;
/*     */   public int minSetextHeadingMarkerLength;
/*     */   public String codeIndent;
/*     */   public String eolInTitleAttribute;
/*     */   public String nbspText;
/*     */   public String thematicBreak;
/*     */   public String outputAttributesNamesRegex;
/*     */   public Pattern outputAttributesNamesRegexPattern;
/*     */   public String outputIdAttributeRegex;
/*     */   public Pattern outputIdAttributeRegexPattern;
/*     */   public Map<Object, CellAlignment> tableCellAlignmentMap;
/*     */   public TableFormatOptions tableOptions;
/*     */   public int formatFlags;
/*     */   public int maxBlankLines;
/*     */   public int maxTrailingBlankLines;
/*     */   public String[] unwrappedTags;
/*     */   public String[] wrappedTags;
/*     */   public String[] divTableRowClasses;
/*     */   public String[] divTableCellClasses;
/*     */   public String[] divTableHdrClasses;
/*     */   
/*     */   public HtmlConverterOptions() {
/*  78 */     this((DataHolder)null);
/*     */   }
/*     */   
/*     */   public HtmlConverterOptions(HtmlConverterOptions paramHtmlConverterOptions) {
/*  82 */     this.listContentIndent = paramHtmlConverterOptions.listContentIndent;
/*  83 */     this.setextHeadings = paramHtmlConverterOptions.setextHeadings;
/*  84 */     this.outputUnknownTags = paramHtmlConverterOptions.outputUnknownTags;
/*  85 */     this.typographicQuotes = paramHtmlConverterOptions.typographicQuotes;
/*  86 */     this.typographicSmarts = paramHtmlConverterOptions.typographicSmarts;
/*  87 */     this.outputAttributesIdAttr = paramHtmlConverterOptions.outputAttributesIdAttr;
/*  88 */     this.wrapAutoLinks = paramHtmlConverterOptions.wrapAutoLinks;
/*  89 */     this.extractAutoLinks = paramHtmlConverterOptions.extractAutoLinks;
/*  90 */     this.renderComments = paramHtmlConverterOptions.renderComments;
/*  91 */     this.dotOnlyNumericLists = paramHtmlConverterOptions.dotOnlyNumericLists;
/*  92 */     this.commentOriginalNonNumericListItem = paramHtmlConverterOptions.commentOriginalNonNumericListItem;
/*  93 */     this.preCodePreserveEmphasis = paramHtmlConverterOptions.preCodePreserveEmphasis;
/*  94 */     this.listsEndOnDoubleBlank = paramHtmlConverterOptions.listsEndOnDoubleBlank;
/*  95 */     this.divAsParagraph = paramHtmlConverterOptions.divAsParagraph;
/*  96 */     this.brAsParaBreaks = paramHtmlConverterOptions.brAsParaBreaks;
/*  97 */     this.brAsExtraBlankLines = paramHtmlConverterOptions.brAsExtraBlankLines;
/*  98 */     this.ignoreTableHeadingAfterRows = paramHtmlConverterOptions.ignoreTableHeadingAfterRows;
/*  99 */     this.addTrailingEol = paramHtmlConverterOptions.addTrailingEol;
/* 100 */     this.skipHeading1 = paramHtmlConverterOptions.skipHeading1;
/* 101 */     this.skipHeading2 = paramHtmlConverterOptions.skipHeading2;
/* 102 */     this.skipHeading3 = paramHtmlConverterOptions.skipHeading3;
/* 103 */     this.skipHeading4 = paramHtmlConverterOptions.skipHeading4;
/* 104 */     this.skipHeading5 = paramHtmlConverterOptions.skipHeading5;
/* 105 */     this.skipHeading6 = paramHtmlConverterOptions.skipHeading6;
/* 106 */     this.skipAttributes = paramHtmlConverterOptions.skipAttributes;
/* 107 */     this.skipFencedCode = paramHtmlConverterOptions.skipFencedCode;
/* 108 */     this.skipCharEscape = paramHtmlConverterOptions.skipCharEscape;
/* 109 */     this.divTableProcessing = paramHtmlConverterOptions.divTableProcessing;
/* 110 */     this.extInlineStrong = paramHtmlConverterOptions.extInlineStrong;
/* 111 */     this.extInlineEmphasis = paramHtmlConverterOptions.extInlineEmphasis;
/* 112 */     this.extInlineCode = paramHtmlConverterOptions.extInlineCode;
/* 113 */     this.extInlineDel = paramHtmlConverterOptions.extInlineDel;
/* 114 */     this.extInlineIns = paramHtmlConverterOptions.extInlineIns;
/* 115 */     this.extInlineSub = paramHtmlConverterOptions.extInlineSub;
/* 116 */     this.extInlineSup = paramHtmlConverterOptions.extInlineSup;
/* 117 */     this.orderedListDelimiter = paramHtmlConverterOptions.orderedListDelimiter;
/* 118 */     this.unorderedListDelimiter = paramHtmlConverterOptions.unorderedListDelimiter;
/* 119 */     this.definitionMarkerSpaces = paramHtmlConverterOptions.definitionMarkerSpaces;
/* 120 */     this.minSetextHeadingMarkerLength = paramHtmlConverterOptions.minSetextHeadingMarkerLength;
/* 121 */     this.codeIndent = paramHtmlConverterOptions.codeIndent;
/* 122 */     this.eolInTitleAttribute = paramHtmlConverterOptions.eolInTitleAttribute;
/* 123 */     this.nbspText = paramHtmlConverterOptions.nbspText;
/* 124 */     this.thematicBreak = paramHtmlConverterOptions.thematicBreak;
/* 125 */     this.outputAttributesNamesRegex = paramHtmlConverterOptions.outputAttributesNamesRegex;
/* 126 */     this.outputAttributesNamesRegexPattern = paramHtmlConverterOptions.outputAttributesNamesRegexPattern;
/* 127 */     this.tableCellAlignmentMap = paramHtmlConverterOptions.tableCellAlignmentMap;
/* 128 */     this.tableOptions = paramHtmlConverterOptions.tableOptions;
/* 129 */     this.outputIdAttributeRegex = paramHtmlConverterOptions.outputIdAttributeRegex;
/* 130 */     this.outputIdAttributeRegexPattern = paramHtmlConverterOptions.outputIdAttributeRegexPattern;
/* 131 */     this.extMath = paramHtmlConverterOptions.extMath;
/* 132 */     this.extInlineLink = paramHtmlConverterOptions.extInlineLink;
/* 133 */     this.extInlineImage = paramHtmlConverterOptions.extInlineImage;
/* 134 */     this.formatFlags = paramHtmlConverterOptions.formatFlags;
/* 135 */     this.maxBlankLines = paramHtmlConverterOptions.maxBlankLines;
/* 136 */     this.maxTrailingBlankLines = paramHtmlConverterOptions.maxTrailingBlankLines;
/* 137 */     this.unwrappedTags = paramHtmlConverterOptions.unwrappedTags;
/* 138 */     this.wrappedTags = paramHtmlConverterOptions.wrappedTags;
/* 139 */     this.divTableRowClasses = paramHtmlConverterOptions.divTableRowClasses;
/* 140 */     this.divTableCellClasses = paramHtmlConverterOptions.divTableCellClasses;
/* 141 */     this.divTableHdrClasses = paramHtmlConverterOptions.divTableHdrClasses;
/*     */   }
/*     */   
/*     */   public HtmlConverterOptions(DataHolder paramDataHolder) {
/* 145 */     this.listContentIndent = ((Boolean)FlexmarkHtmlConverter.LIST_CONTENT_INDENT.get(paramDataHolder)).booleanValue();
/* 146 */     this.setextHeadings = ((Boolean)FlexmarkHtmlConverter.SETEXT_HEADINGS.get(paramDataHolder)).booleanValue();
/* 147 */     this.outputUnknownTags = ((Boolean)FlexmarkHtmlConverter.OUTPUT_UNKNOWN_TAGS.get(paramDataHolder)).booleanValue();
/* 148 */     this.typographicQuotes = ((Boolean)FlexmarkHtmlConverter.TYPOGRAPHIC_QUOTES.get(paramDataHolder)).booleanValue();
/* 149 */     this.typographicSmarts = ((Boolean)FlexmarkHtmlConverter.TYPOGRAPHIC_SMARTS.get(paramDataHolder)).booleanValue();
/* 150 */     this.outputAttributesIdAttr = ((Boolean)FlexmarkHtmlConverter.OUTPUT_ATTRIBUTES_ID.get(paramDataHolder)).booleanValue();
/* 151 */     this.wrapAutoLinks = ((Boolean)FlexmarkHtmlConverter.WRAP_AUTO_LINKS.get(paramDataHolder)).booleanValue();
/* 152 */     this.extractAutoLinks = ((Boolean)FlexmarkHtmlConverter.EXTRACT_AUTO_LINKS.get(paramDataHolder)).booleanValue();
/* 153 */     this.renderComments = ((Boolean)FlexmarkHtmlConverter.RENDER_COMMENTS.get(paramDataHolder)).booleanValue();
/* 154 */     this.dotOnlyNumericLists = ((Boolean)FlexmarkHtmlConverter.DOT_ONLY_NUMERIC_LISTS.get(paramDataHolder)).booleanValue();
/* 155 */     this.commentOriginalNonNumericListItem = ((Boolean)FlexmarkHtmlConverter.COMMENT_ORIGINAL_NON_NUMERIC_LIST_ITEM.get(paramDataHolder)).booleanValue();
/* 156 */     this.preCodePreserveEmphasis = ((Boolean)FlexmarkHtmlConverter.PRE_CODE_PRESERVE_EMPHASIS.get(paramDataHolder)).booleanValue();
/* 157 */     this.listsEndOnDoubleBlank = ((Boolean)FlexmarkHtmlConverter.LISTS_END_ON_DOUBLE_BLANK.get(paramDataHolder)).booleanValue();
/* 158 */     this.divAsParagraph = ((Boolean)FlexmarkHtmlConverter.DIV_AS_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 159 */     this.brAsParaBreaks = ((Boolean)FlexmarkHtmlConverter.BR_AS_PARA_BREAKS.get(paramDataHolder)).booleanValue();
/* 160 */     this.brAsExtraBlankLines = ((Boolean)FlexmarkHtmlConverter.BR_AS_EXTRA_BLANK_LINES.get(paramDataHolder)).booleanValue();
/* 161 */     this.ignoreTableHeadingAfterRows = ((Boolean)FlexmarkHtmlConverter.IGNORE_TABLE_HEADING_AFTER_ROWS.get(paramDataHolder)).booleanValue();
/* 162 */     this.addTrailingEol = ((Boolean)FlexmarkHtmlConverter.ADD_TRAILING_EOL.get(paramDataHolder)).booleanValue();
/* 163 */     this.skipHeading1 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_1.get(paramDataHolder)).booleanValue();
/* 164 */     this.skipHeading2 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_2.get(paramDataHolder)).booleanValue();
/* 165 */     this.skipHeading3 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_3.get(paramDataHolder)).booleanValue();
/* 166 */     this.skipHeading4 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_4.get(paramDataHolder)).booleanValue();
/* 167 */     this.skipHeading5 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_5.get(paramDataHolder)).booleanValue();
/* 168 */     this.skipHeading6 = ((Boolean)FlexmarkHtmlConverter.SKIP_HEADING_6.get(paramDataHolder)).booleanValue();
/* 169 */     this.skipAttributes = ((Boolean)FlexmarkHtmlConverter.SKIP_ATTRIBUTES.get(paramDataHolder)).booleanValue();
/* 170 */     this.skipFencedCode = ((Boolean)FlexmarkHtmlConverter.SKIP_FENCED_CODE.get(paramDataHolder)).booleanValue();
/* 171 */     this.skipCharEscape = ((Boolean)FlexmarkHtmlConverter.SKIP_CHAR_ESCAPE.get(paramDataHolder)).booleanValue();
/* 172 */     this.divTableProcessing = ((Boolean)FlexmarkHtmlConverter.DIV_TABLE_PROCESSING.get(paramDataHolder)).booleanValue();
/* 173 */     this.extInlineStrong = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_STRONG.get(paramDataHolder);
/* 174 */     this.extInlineEmphasis = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_EMPHASIS.get(paramDataHolder);
/* 175 */     this.extInlineCode = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_CODE.get(paramDataHolder);
/* 176 */     this.extInlineDel = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_DEL.get(paramDataHolder);
/* 177 */     this.extInlineIns = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_INS.get(paramDataHolder);
/* 178 */     this.extInlineSub = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_SUB.get(paramDataHolder);
/* 179 */     this.extInlineSup = (ExtensionConversion)FlexmarkHtmlConverter.EXT_INLINE_SUP.get(paramDataHolder);
/* 180 */     this.extMath = (ExtensionConversion)FlexmarkHtmlConverter.EXT_MATH.get(paramDataHolder);
/* 181 */     this.extInlineLink = (LinkConversion)FlexmarkHtmlConverter.EXT_INLINE_LINK.get(paramDataHolder);
/* 182 */     this.extInlineImage = (LinkConversion)FlexmarkHtmlConverter.EXT_INLINE_IMAGE.get(paramDataHolder);
/* 183 */     this.orderedListDelimiter = ((Character)FlexmarkHtmlConverter.ORDERED_LIST_DELIMITER.get(paramDataHolder)).charValue();
/* 184 */     this.unorderedListDelimiter = ((Character)FlexmarkHtmlConverter.UNORDERED_LIST_DELIMITER.get(paramDataHolder)).charValue();
/* 185 */     this.definitionMarkerSpaces = ((Integer)FlexmarkHtmlConverter.DEFINITION_MARKER_SPACES.get(paramDataHolder)).intValue();
/* 186 */     this.minSetextHeadingMarkerLength = Utils.minLimit(((Integer)FlexmarkHtmlConverter.MIN_SETEXT_HEADING_MARKER_LENGTH.get(paramDataHolder)).intValue(), new int[] { 3 });
/* 187 */     this.codeIndent = (String)FlexmarkHtmlConverter.CODE_INDENT.get(paramDataHolder);
/* 188 */     this.eolInTitleAttribute = (String)FlexmarkHtmlConverter.EOL_IN_TITLE_ATTRIBUTE.get(paramDataHolder);
/* 189 */     this.nbspText = (String)FlexmarkHtmlConverter.NBSP_TEXT.get(paramDataHolder);
/* 190 */     this.thematicBreak = (String)FlexmarkHtmlConverter.THEMATIC_BREAK.get(paramDataHolder);
/* 191 */     this.outputAttributesNamesRegex = (String)FlexmarkHtmlConverter.OUTPUT_ATTRIBUTES_NAMES_REGEX.get(paramDataHolder);
/* 192 */     this.outputAttributesNamesRegexPattern = Pattern.compile(this.outputAttributesNamesRegex);
/* 193 */     this.outputIdAttributeRegex = (String)FlexmarkHtmlConverter.OUTPUT_ID_ATTRIBUTE_REGEX.get(paramDataHolder);
/* 194 */     this.outputIdAttributeRegexPattern = Pattern.compile(this.outputIdAttributeRegex);
/* 195 */     this.tableCellAlignmentMap = (Map<Object, CellAlignment>)FlexmarkHtmlConverter.TABLE_CELL_ALIGNMENT_MAP.get(paramDataHolder);
/* 196 */     this.tableOptions = new TableFormatOptions(paramDataHolder);
/* 197 */     this.formatFlags = ((Integer)FlexmarkHtmlConverter.FORMAT_FLAGS.get(paramDataHolder)).intValue();
/* 198 */     this.maxBlankLines = ((Integer)FlexmarkHtmlConverter.MAX_BLANK_LINES.get(paramDataHolder)).intValue();
/* 199 */     this.maxTrailingBlankLines = ((Integer)FlexmarkHtmlConverter.MAX_TRAILING_BLANK_LINES.get(paramDataHolder)).intValue();
/* 200 */     this.unwrappedTags = (String[])FlexmarkHtmlConverter.UNWRAPPED_TAGS.get(paramDataHolder);
/* 201 */     this.wrappedTags = (String[])FlexmarkHtmlConverter.WRAPPED_TAGS.get(paramDataHolder);
/* 202 */     this.divTableRowClasses = (String[])FlexmarkHtmlConverter.DIV_TABLE_ROW_CLASSES.get(paramDataHolder);
/* 203 */     this.divTableCellClasses = (String[])FlexmarkHtmlConverter.DIV_TABLE_CELL_CLASSES.get(paramDataHolder);
/* 204 */     this.divTableHdrClasses = (String[])FlexmarkHtmlConverter.DIV_TABLE_HDR_CLASSES.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 210 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.LIST_CONTENT_INDENT, Boolean.valueOf(this.listContentIndent));
/* 211 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SETEXT_HEADINGS, Boolean.valueOf(this.setextHeadings));
/* 212 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.OUTPUT_UNKNOWN_TAGS, Boolean.valueOf(this.outputUnknownTags));
/* 213 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.TYPOGRAPHIC_QUOTES, Boolean.valueOf(this.typographicQuotes));
/* 214 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.TYPOGRAPHIC_SMARTS, Boolean.valueOf(this.typographicSmarts));
/* 215 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.OUTPUT_ATTRIBUTES_ID, Boolean.valueOf(this.outputAttributesIdAttr));
/* 216 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.WRAP_AUTO_LINKS, Boolean.valueOf(this.wrapAutoLinks));
/* 217 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXTRACT_AUTO_LINKS, Boolean.valueOf(this.extractAutoLinks));
/* 218 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.RENDER_COMMENTS, Boolean.valueOf(this.renderComments));
/* 219 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DOT_ONLY_NUMERIC_LISTS, Boolean.valueOf(this.dotOnlyNumericLists));
/* 220 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.COMMENT_ORIGINAL_NON_NUMERIC_LIST_ITEM, Boolean.valueOf(this.commentOriginalNonNumericListItem));
/* 221 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.PRE_CODE_PRESERVE_EMPHASIS, Boolean.valueOf(this.preCodePreserveEmphasis));
/* 222 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.LISTS_END_ON_DOUBLE_BLANK, Boolean.valueOf(this.listsEndOnDoubleBlank));
/* 223 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DIV_AS_PARAGRAPH, Boolean.valueOf(this.divAsParagraph));
/* 224 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.BR_AS_PARA_BREAKS, Boolean.valueOf(this.brAsParaBreaks));
/* 225 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.BR_AS_EXTRA_BLANK_LINES, Boolean.valueOf(this.brAsExtraBlankLines));
/* 226 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.IGNORE_TABLE_HEADING_AFTER_ROWS, Boolean.valueOf(this.ignoreTableHeadingAfterRows));
/* 227 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.ADD_TRAILING_EOL, Boolean.valueOf(this.addTrailingEol));
/* 228 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_1, Boolean.valueOf(this.skipHeading1));
/* 229 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_2, Boolean.valueOf(this.skipHeading2));
/* 230 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_3, Boolean.valueOf(this.skipHeading3));
/* 231 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_4, Boolean.valueOf(this.skipHeading4));
/* 232 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_5, Boolean.valueOf(this.skipHeading5));
/* 233 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_HEADING_6, Boolean.valueOf(this.skipHeading6));
/* 234 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_ATTRIBUTES, Boolean.valueOf(this.skipAttributes));
/* 235 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_FENCED_CODE, Boolean.valueOf(this.skipFencedCode));
/* 236 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.SKIP_CHAR_ESCAPE, Boolean.valueOf(this.skipCharEscape));
/* 237 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DIV_TABLE_PROCESSING, Boolean.valueOf(this.divTableProcessing));
/* 238 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_STRONG, this.extInlineStrong);
/* 239 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_EMPHASIS, this.extInlineEmphasis);
/* 240 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_CODE, this.extInlineCode);
/* 241 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_DEL, this.extInlineDel);
/* 242 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_INS, this.extInlineIns);
/* 243 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_SUB, this.extInlineSub);
/* 244 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_SUP, this.extInlineSup);
/* 245 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.ORDERED_LIST_DELIMITER, Character.valueOf(this.orderedListDelimiter));
/* 246 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.UNORDERED_LIST_DELIMITER, Character.valueOf(this.unorderedListDelimiter));
/* 247 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DEFINITION_MARKER_SPACES, Integer.valueOf(this.definitionMarkerSpaces));
/* 248 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.MIN_SETEXT_HEADING_MARKER_LENGTH, Integer.valueOf(this.minSetextHeadingMarkerLength));
/* 249 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.CODE_INDENT, this.codeIndent);
/* 250 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EOL_IN_TITLE_ATTRIBUTE, this.eolInTitleAttribute);
/* 251 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.NBSP_TEXT, this.nbspText);
/* 252 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.THEMATIC_BREAK, this.thematicBreak);
/* 253 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.OUTPUT_ATTRIBUTES_NAMES_REGEX, this.outputAttributesNamesRegex);
/* 254 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.TABLE_CELL_ALIGNMENT_MAP, this.tableCellAlignmentMap);
/* 255 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.OUTPUT_ID_ATTRIBUTE_REGEX, this.outputIdAttributeRegex);
/* 256 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_MATH, this.extMath);
/* 257 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_LINK, this.extInlineLink);
/* 258 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.EXT_INLINE_IMAGE, this.extInlineImage);
/* 259 */     paramMutableDataHolder.setFrom((MutableDataSetter)this.tableOptions);
/* 260 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.FORMAT_FLAGS, Integer.valueOf(this.formatFlags));
/* 261 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.MAX_BLANK_LINES, Integer.valueOf(this.maxBlankLines));
/* 262 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.MAX_TRAILING_BLANK_LINES, Integer.valueOf(this.maxTrailingBlankLines));
/* 263 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.UNWRAPPED_TAGS, this.unwrappedTags);
/* 264 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.WRAPPED_TAGS, this.wrappedTags);
/* 265 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DIV_TABLE_ROW_CLASSES, this.divTableRowClasses);
/* 266 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DIV_TABLE_CELL_CLASSES, this.divTableCellClasses);
/* 267 */     paramMutableDataHolder.set(FlexmarkHtmlConverter.DIV_TABLE_HDR_CLASSES, this.divTableHdrClasses);
/* 268 */     return paramMutableDataHolder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlConverterOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */