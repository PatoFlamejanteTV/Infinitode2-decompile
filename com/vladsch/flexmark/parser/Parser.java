/*     */ package com.vladsch.flexmark.parser;
/*     */ import com.vladsch.flexmark.ast.util.ReferenceRepository;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
/*     */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*     */ import com.vladsch.flexmark.parser.internal.DocumentParser;
/*     */ import com.vladsch.flexmark.parser.internal.InlineParserImpl;
/*     */ import com.vladsch.flexmark.parser.internal.LinkRefProcessorData;
/*     */ import com.vladsch.flexmark.parser.internal.PostProcessorManager;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.IParse;
/*     */ import com.vladsch.flexmark.util.ast.KeepType;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.data.DataSet;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*     */ import com.vladsch.flexmark.util.misc.Extension;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Parser implements IParse {
/*  37 */   public static final DataKey<Collection<Extension>> EXTENSIONS = SharedDataKeys.EXTENSIONS;
/*     */   
/*  39 */   public static final DataKey<KeepType> REFERENCES_KEEP = new DataKey("REFERENCES_KEEP", KeepType.FIRST);
/*  40 */   public static final DataKey<ReferenceRepository> REFERENCES = new DataKey("REFERENCES", new ReferenceRepository(null), ReferenceRepository::new);
/*     */   
/*  42 */   public static final DataKey<Boolean> ASTERISK_DELIMITER_PROCESSOR = new DataKey("ASTERISK_DELIMITER_PROCESSOR", Boolean.TRUE);
/*     */   
/*  44 */   public static final DataKey<Boolean> TRACK_DOCUMENT_LINES = new DataKey("TRACK_DOCUMENT_LINES", Boolean.FALSE);
/*     */   
/*  46 */   public static final DataKey<Boolean> BLOCK_QUOTE_PARSER = new DataKey("BLOCK_QUOTE_PARSER", Boolean.TRUE);
/*  47 */   public static final DataKey<Boolean> BLOCK_QUOTE_EXTEND_TO_BLANK_LINE = new DataKey("BLOCK_QUOTE_EXTEND_TO_BLANK_LINE", Boolean.FALSE);
/*  48 */   public static final DataKey<Boolean> BLOCK_QUOTE_IGNORE_BLANK_LINE = new DataKey("BLOCK_QUOTE_IGNORE_BLANK_LINE", Boolean.FALSE);
/*  49 */   public static final DataKey<Boolean> BLOCK_QUOTE_ALLOW_LEADING_SPACE = new DataKey("BLOCK_QUOTE_ALLOW_LEADING_SPACE", Boolean.TRUE);
/*  50 */   public static final DataKey<Boolean> BLOCK_QUOTE_INTERRUPTS_PARAGRAPH = new DataKey("BLOCK_QUOTE_INTERRUPTS_PARAGRAPH", Boolean.TRUE);
/*  51 */   public static final DataKey<Boolean> BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*  52 */   public static final DataKey<Boolean> BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*     */   
/*  54 */   public static final DataKey<Boolean> FENCED_CODE_BLOCK_PARSER = new DataKey("FENCED_CODE_BLOCK_PARSER", Boolean.TRUE);
/*  55 */   public static final DataKey<Boolean> MATCH_CLOSING_FENCE_CHARACTERS = new DataKey("MATCH_CLOSING_FENCE_CHARACTERS", Boolean.TRUE);
/*  56 */   public static final DataKey<Boolean> FENCED_CODE_CONTENT_BLOCK = new DataKey("FENCED_CODE_CONTENT_BLOCK", Boolean.FALSE);
/*     */   
/*  58 */   public static final DataKey<Boolean> CODE_SOFT_LINE_BREAKS = new DataKey("CODE_SOFT_LINE_BREAKS", Boolean.FALSE);
/*  59 */   public static final DataKey<Boolean> HARD_LINE_BREAK_LIMIT = new DataKey("HARD_LINE_BREAK_LIMIT", Boolean.FALSE);
/*     */   
/*  61 */   public static final DataKey<Boolean> HEADING_PARSER = new DataKey("HEADING_PARSER", Boolean.TRUE);
/*  62 */   public static final DataKey<Integer> HEADING_SETEXT_MARKER_LENGTH = new DataKey("HEADING_SETEXT_MARKER_LENGTH", Integer.valueOf(1));
/*  63 */   public static final DataKey<Boolean> HEADING_NO_ATX_SPACE = SharedDataKeys.HEADING_NO_ATX_SPACE;
/*     */   
/*  65 */   public static final DataKey<Boolean> ESCAPE_HEADING_NO_ATX_SPACE = SharedDataKeys.ESCAPE_HEADING_NO_ATX_SPACE;
/*  66 */   public static final DataKey<Boolean> HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE = new DataKey("HEADING_NO_EMPTY_HEADING_WITHOUT_SPACE", Boolean.FALSE);
/*  67 */   public static final DataKey<Boolean> HEADING_NO_LEAD_SPACE = new DataKey("HEADING_NO_LEAD_SPACE", Boolean.FALSE);
/*  68 */   public static final DataKey<Boolean> HEADING_CAN_INTERRUPT_ITEM_PARAGRAPH = new DataKey("HEADING_CAN_INTERRUPT_ITEM_PARAGRAPH", Boolean.TRUE);
/*     */   
/*  70 */   public static final DataKey<Boolean> HTML_BLOCK_PARSER = new DataKey("HTML_BLOCK_PARSER", Boolean.TRUE);
/*  71 */   public static final DataKey<Boolean> HTML_COMMENT_BLOCKS_INTERRUPT_PARAGRAPH = new DataKey("HTML_COMMENT_BLOCKS_INTERRUPT_PARAGRAPH", Boolean.TRUE);
/*  72 */   public static final DataKey<Boolean> HTML_FOR_TRANSLATOR = SharedDataKeys.HTML_FOR_TRANSLATOR;
/*     */   
/*  74 */   public static final DataKey<Boolean> INLINE_DELIMITER_DIRECTIONAL_PUNCTUATIONS = new DataKey("INLINE_DELIMITER_DIRECTIONAL_PUNCTUATIONS", Boolean.FALSE);
/*     */   
/*  76 */   public static final DataKey<Boolean> INDENTED_CODE_BLOCK_PARSER = new DataKey("INDENTED_CODE_BLOCK_PARSER", Boolean.TRUE);
/*  77 */   public static final DataKey<Boolean> INDENTED_CODE_NO_TRAILING_BLANK_LINES = new DataKey("INDENTED_CODE_NO_TRAILING_BLANK_LINES", Boolean.TRUE);
/*     */   
/*  79 */   public static final DataKey<Boolean> INTELLIJ_DUMMY_IDENTIFIER = SharedDataKeys.INTELLIJ_DUMMY_IDENTIFIER;
/*     */   
/*  81 */   public static final DataKey<Boolean> MATCH_NESTED_LINK_REFS_FIRST = new DataKey("MATCH_NESTED_LINK_REFS_FIRST", Boolean.TRUE);
/*  82 */   public static final DataKey<Boolean> PARSE_INNER_HTML_COMMENTS = SharedDataKeys.PARSE_INNER_HTML_COMMENTS;
/*  83 */   public static final DataKey<Boolean> PARSE_MULTI_LINE_IMAGE_URLS = new DataKey("PARSE_MULTI_LINE_IMAGE_URLS", Boolean.FALSE);
/*  84 */   public static final DataKey<Boolean> PARSE_JEKYLL_MACROS_IN_URLS = new DataKey("PARSE_JEKYLL_MACROS_IN_URLS", Boolean.FALSE);
/*  85 */   public static final DataKey<Boolean> SPACE_IN_LINK_URLS = new DataKey("SPACE_IN_LINK_URLS", Boolean.FALSE);
/*  86 */   public static final DataKey<Boolean> SPACE_IN_LINK_ELEMENTS = new DataKey("SPACE_IN_LINK_ELEMENTS", Boolean.FALSE);
/*  87 */   public static final DataKey<Boolean> WWW_AUTO_LINK_ELEMENT = new DataKey("WWW_AUTO_LINK_ELEMENT", Boolean.FALSE);
/*  88 */   public static final DataKey<Boolean> LINK_TEXT_PRIORITY_OVER_LINK_REF = new DataKey("LINK_TEXT_PRIORITY_OVER_LINK_REF", Boolean.FALSE);
/*     */   
/*  90 */   public static final DataKey<Boolean> REFERENCE_PARAGRAPH_PRE_PROCESSOR = new DataKey("REFERENCE_BLOCK_PRE_PROCESSOR", Boolean.TRUE);
/*  91 */   public static final DataKey<Boolean> THEMATIC_BREAK_PARSER = new DataKey("THEMATIC_BREAK_PARSER", Boolean.TRUE);
/*  92 */   public static final DataKey<Boolean> THEMATIC_BREAK_RELAXED_START = new DataKey("THEMATIC_BREAK_RELAXED_START", Boolean.TRUE);
/*     */   
/*  94 */   public static final DataKey<Boolean> UNDERSCORE_DELIMITER_PROCESSOR = new DataKey("UNDERSCORE_DELIMITER_PROCESSOR", Boolean.TRUE);
/*  95 */   public static final DataKey<Boolean> BLANK_LINES_IN_AST = SharedDataKeys.BLANK_LINES_IN_AST;
/*  96 */   public static final DataKey<Boolean> USE_HARDCODED_LINK_ADDRESS_PARSER = new DataKey("USE_HARDCODED_LINK_ADDRESS_PARSER", Boolean.TRUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public static final DataKey<Boolean> STRONG_WRAPS_EMPHASIS = new DataKey("STRONG_WRAPS_EMPHASIS", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static final DataKey<Boolean> LINKS_ALLOW_MATCHED_PARENTHESES = new DataKey("LINKS_ALLOW_MATCHED_PARENTHESES", Boolean.TRUE);
/*     */ 
/*     */   
/* 109 */   public static final DataKey<Boolean> LIST_BLOCK_PARSER = new DataKey("LIST_BLOCK_PARSER", Boolean.TRUE);
/* 110 */   public static final DataKey<ParserEmulationProfile> PARSER_EMULATION_PROFILE = new DataKey("PARSER_EMULATION_PROFILE", ParserEmulationProfile.COMMONMARK);
/*     */ 
/*     */   
/* 113 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSER = new DataKey("HTML_BLOCK_DEEP_PARSER", Boolean.FALSE);
/* 114 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_NON_BLOCK = new DataKey("HTML_BLOCK_DEEP_PARSE_NON_BLOCK", Boolean.TRUE);
/* 115 */   public static final DataKey<Boolean> HTML_BLOCK_COMMENT_ONLY_FULL_LINE = new DataKey("HTML_BLOCK_COMMENT_ONLY_FULL_LINE", Boolean.FALSE);
/* 116 */   public static final DataKey<Boolean> HTML_BLOCK_START_ONLY_ON_BLOCK_TAGS = new DataKey("HTML_BLOCK_START_ONLY_ON_BLOCK_TAGS", HTML_BLOCK_DEEP_PARSER);
/*     */   
/* 118 */   public static final DataKey<List<String>> HTML_BLOCK_TAGS = new DataKey("HTML_BLOCK_TAGS", Arrays.asList(new String[] { "address", "article", "aside", "base", "basefont", "blockquote", "body", "caption", "center", "col", "colgroup", "dd", "details", "dialog", "dir", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hr", "html", "iframe", "legend", "li", "link", "main", "math", "menu", "menuitem", "meta", "nav", "noframes", "ol", "optgroup", "option", "p", "param", "section", "source", "summary", "table", "tbody", "td", "tfoot", "th", "thead", "title", "tr", "track", "ul" }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 188 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS = new DataKey("HTML_BL OCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS", Boolean.TRUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 193 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE = new DataKey("HTML_BL HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED = new DataKey("HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 203 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG = new DataKey("HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG", Boolean.TRUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 208 */   public static final DataKey<Boolean> HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS = new DataKey("HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 213 */   public static final DataKey<String> TRANSLATION_HTML_BLOCK_TAG_PATTERN = SharedDataKeys.TRANSLATION_HTML_BLOCK_TAG_PATTERN;
/* 214 */   public static final DataKey<String> TRANSLATION_HTML_INLINE_TAG_PATTERN = SharedDataKeys.TRANSLATION_HTML_INLINE_TAG_PATTERN;
/* 215 */   public static final DataKey<String> TRANSLATION_AUTOLINK_TAG_PATTERN = SharedDataKeys.TRANSLATION_AUTOLINK_TAG_PATTERN;
/*     */ 
/*     */ 
/*     */   
/* 219 */   public static final DataKey<Integer> LISTS_CODE_INDENT = new DataKey("LISTS_CODE_INDENT", Integer.valueOf(4));
/* 220 */   public static final DataKey<Integer> LISTS_ITEM_INDENT = new DataKey("LISTS_ITEM_INDENT", Integer.valueOf(4));
/*     */ 
/*     */   
/* 223 */   public static final DataKey<Integer> LISTS_NEW_ITEM_CODE_INDENT = new DataKey("LISTS_NEW_ITEM_CODE_INDENT", Integer.valueOf(4));
/*     */ 
/*     */   
/* 226 */   public static final DataKey<Boolean> LISTS_ITEM_MARKER_SPACE = new DataKey("LISTS_ITEM_MARKER_SPACE", Boolean.FALSE);
/*     */ 
/*     */ 
/*     */   
/* 230 */   public static final DataKey<String[]> LISTS_ITEM_MARKER_SUFFIXES = new DataKey("LISTS_ITEM_MARKER_SUFFIXES", new String[0]);
/* 231 */   public static final DataKey<Boolean> LISTS_NUMBERED_ITEM_MARKER_SUFFIXED = new DataKey("LISTS_NUMBERED_ITEM_MARKER_SUFFIXED", Boolean.TRUE);
/*     */ 
/*     */   
/* 234 */   public static final DataKey<Boolean> LISTS_AUTO_LOOSE = new DataKey("LISTS_AUTO_LOOSE", Boolean.TRUE);
/* 235 */   public static final DataKey<Boolean> LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS = new DataKey("LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS", Boolean.FALSE);
/* 236 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE = new DataKey("LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE", Boolean.FALSE);
/* 237 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE = new DataKey("LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE", Boolean.FALSE);
/* 238 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN = new DataKey("LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN", Boolean.FALSE);
/* 239 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH = new DataKey("LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH", Boolean.FALSE);
/* 240 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM = new DataKey("LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM", Boolean.FALSE);
/* 241 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE = new DataKey("LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE", Boolean.TRUE);
/* 242 */   public static final DataKey<Boolean> LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE = new DataKey("LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE", Boolean.FALSE);
/* 243 */   public static final DataKey<Boolean> LISTS_DELIMITER_MISMATCH_TO_NEW_LIST = new DataKey("LISTS_DELIMITER_MISMATCH_TO_NEW_LIST", Boolean.TRUE);
/* 244 */   public static final DataKey<Boolean> LISTS_END_ON_DOUBLE_BLANK = new DataKey("LISTS_END_ON_DOUBLE_BLANK", Boolean.FALSE);
/* 245 */   public static final DataKey<Boolean> LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST = new DataKey("LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST", Boolean.TRUE);
/* 246 */   public static final DataKey<Boolean> LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST = new DataKey("LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST", Boolean.FALSE);
/* 247 */   public static final DataKey<Boolean> LISTS_ORDERED_ITEM_DOT_ONLY = new DataKey("LISTS_ORDERED_ITEM_DOT_ONLY", Boolean.FALSE);
/* 248 */   public static final DataKey<Boolean> LISTS_ORDERED_LIST_MANUAL_START = new DataKey("LISTS_ORDERED_LIST_MANUAL_START", Boolean.TRUE);
/* 249 */   public static final DataKey<Boolean> LISTS_ITEM_CONTENT_AFTER_SUFFIX = new DataKey("LISTS_ITEM_CONTENT_AFTER_SUFFIX", Boolean.FALSE);
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
/* 260 */   public static final DataKey<Boolean> LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH", Boolean.TRUE);
/* 261 */   public static final DataKey<Boolean> LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH", Boolean.TRUE);
/* 262 */   public static final DataKey<Boolean> LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH", Boolean.FALSE);
/*     */   
/* 264 */   public static final DataKey<Boolean> LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH", Boolean.FALSE);
/* 265 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH", Boolean.FALSE);
/* 266 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH", Boolean.FALSE);
/*     */   
/* 268 */   public static final DataKey<Boolean> LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/* 269 */   public static final DataKey<Boolean> LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/* 270 */   public static final DataKey<Boolean> LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*     */ 
/*     */   
/* 273 */   public static final DataKey<Boolean> LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/* 274 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/* 275 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.TRUE);
/*     */ 
/*     */ 
/*     */   
/* 279 */   public static final DataKey<Boolean> LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.FALSE);
/* 280 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.FALSE);
/* 281 */   public static final DataKey<Boolean> LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH", Boolean.FALSE);
/* 282 */   public static final DataKey<String> LISTS_ITEM_PREFIX_CHARS = new DataKey("LISTS_ITEM_PREFIX_CHARS", "+*-");
/*     */ 
/*     */   
/* 285 */   public static final DataKey<List<SpecialLeadInHandler>> SPECIAL_LEAD_IN_HANDLERS = new DataKey("SPECIAL_LEAD_IN_HANDLERS", Collections.emptyList());
/*     */ 
/*     */   
/* 288 */   public static final DataKey<Integer> CODE_BLOCK_INDENT = new DataKey("CODE_BLOCK_INDENT", LISTS_ITEM_INDENT);
/*     */   
/*     */   private final List<CustomBlockParserFactory> blockParserFactories;
/*     */   private final Map<Character, DelimiterProcessor> delimiterProcessors;
/*     */   private final BitSet delimiterCharacters;
/*     */   private final BitSet specialCharacters;
/*     */   private final List<PostProcessorManager.PostProcessorDependencyStage> postProcessorDependencies;
/*     */   private final List<List<ParagraphPreProcessorFactory>> paragraphPreProcessorFactories;
/*     */   private final List<List<BlockPreProcessorFactory>> blockPreProcessorDependencies;
/*     */   private final LinkRefProcessorData linkRefProcessors;
/*     */   private final List<InlineParserExtensionFactory> inlineParserExtensionFactories;
/*     */   private final InlineParserFactory inlineParserFactory;
/*     */   private final DataHolder options;
/*     */   
/*     */   Parser(Builder paramBuilder) {
/* 303 */     DataSet dataSet = paramBuilder.toImmutable();
/* 304 */     this.blockParserFactories = DocumentParser.calculateBlockParserFactories((DataHolder)dataSet, paramBuilder.blockParserFactories);
/*     */     
/* 306 */     ArrayList<SpecialLeadInHandler> arrayList = new ArrayList<>(paramBuilder.specialLeadInHandlers);
/*     */     
/* 308 */     for (Iterator<CustomBlockParserFactory> iterator = this.blockParserFactories.iterator(); iterator.hasNext();) {
/*     */       
/* 310 */       if ((specialLeadInHandler = (customBlockParserFactory = iterator.next()).getLeadInHandler((DataHolder)dataSet)) != null) {
/* 311 */         arrayList.add(specialLeadInHandler);
/*     */       }
/*     */     } 
/*     */     
/*     */     MutableDataSet mutableDataSet;
/* 316 */     (mutableDataSet = new MutableDataSet((DataHolder)paramBuilder)).set(SPECIAL_LEAD_IN_HANDLERS, arrayList);
/*     */     
/* 318 */     this.options = (DataHolder)mutableDataSet.toImmutable();
/* 319 */     this.inlineParserFactory = (paramBuilder.inlineParserFactory == null) ? DocumentParser.INLINE_PARSER_FACTORY : paramBuilder.inlineParserFactory;
/* 320 */     this.paragraphPreProcessorFactories = DocumentParser.calculateParagraphPreProcessors((DataHolder)dataSet, paramBuilder.paragraphPreProcessorFactories, this.inlineParserFactory);
/* 321 */     this.blockPreProcessorDependencies = DocumentParser.calculateBlockPreProcessors((DataHolder)dataSet, paramBuilder.blockPreProcessorFactories);
/* 322 */     this.delimiterProcessors = InlineParserImpl.calculateDelimiterProcessors((DataHolder)dataSet, paramBuilder.delimiterProcessors);
/* 323 */     this.delimiterCharacters = InlineParserImpl.calculateDelimiterCharacters((DataHolder)dataSet, this.delimiterProcessors.keySet());
/* 324 */     this.linkRefProcessors = InlineParserImpl.calculateLinkRefProcessors((DataHolder)dataSet, paramBuilder.linkRefProcessors);
/* 325 */     this.specialCharacters = InlineParserImpl.calculateSpecialCharacters((DataHolder)dataSet, this.delimiterCharacters);
/* 326 */     this.postProcessorDependencies = PostProcessorManager.calculatePostProcessors((DataHolder)dataSet, paramBuilder.postProcessorFactories);
/* 327 */     this.inlineParserExtensionFactories = paramBuilder.inlineParserExtensionFactories;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Builder builder() {
/* 336 */     return new Builder();
/*     */   }
/*     */   
/*     */   public static Builder builder(DataHolder paramDataHolder) {
/* 340 */     return new Builder(paramDataHolder);
/*     */   }
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
/*     */   public Document parse(BasedSequence paramBasedSequence) {
/* 353 */     if (paramBasedSequence instanceof com.vladsch.flexmark.util.sequence.ReplacedBasedSequence) {
/* 354 */       throw new IllegalArgumentException("Parser.parse() does not support BasedSequences with replaced or non-contiguous segments.\nUse BasedSequence.of(input.toString()) to convert to contiguous based sequence.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentParser documentParser;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     Document document = (documentParser = new DocumentParser(this.options, this.blockParserFactories, this.paragraphPreProcessorFactories, this.blockPreProcessorDependencies, this.inlineParserFactory.inlineParser(this.options, this.specialCharacters, this.delimiterCharacters, this.delimiterProcessors, this.linkRefProcessors, this.inlineParserExtensionFactories))).parse((CharSequence)paramBasedSequence);
/* 366 */     return postProcess(document);
/*     */   }
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
/*     */   public Document parse(String paramString) {
/*     */     DocumentParser documentParser;
/* 383 */     Document document = (documentParser = new DocumentParser(this.options, this.blockParserFactories, this.paragraphPreProcessorFactories, this.blockPreProcessorDependencies, this.inlineParserFactory.inlineParser(this.options, this.specialCharacters, this.delimiterCharacters, this.delimiterProcessors, this.linkRefProcessors, this.inlineParserExtensionFactories))).parse((CharSequence)BasedSequence.of(paramString));
/* 384 */     return postProcess(document);
/*     */   }
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
/*     */   public Document parseReader(Reader paramReader) {
/*     */     DocumentParser documentParser;
/* 402 */     Document document = (documentParser = new DocumentParser(this.options, this.blockParserFactories, this.paragraphPreProcessorFactories, this.blockPreProcessorDependencies, this.inlineParserFactory.inlineParser(this.options, this.specialCharacters, this.delimiterCharacters, this.delimiterProcessors, this.linkRefProcessors, this.inlineParserExtensionFactories))).parse(paramReader);
/* 403 */     return postProcess(document);
/*     */   }
/*     */ 
/*     */   
/*     */   private Document postProcess(Document paramDocument) {
/* 408 */     return paramDocument = PostProcessorManager.processDocument(paramDocument, this.postProcessorDependencies);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataHolder getOptions() {
/* 413 */     return this.options;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean transferReferences(Document paramDocument1, Document paramDocument2, Boolean paramBoolean) {
/* 419 */     boolean bool = false;
/*     */     
/* 421 */     if (this.options.contains((DataKeyBase)EXTENSIONS)) {
/* 422 */       for (Iterator<Extension> iterator = ((Collection)EXTENSIONS.get(this.options)).iterator(); iterator.hasNext();) {
/* 423 */         if (extension = iterator.next() instanceof ReferenceHoldingExtension && (
/*     */           
/* 425 */           extension = extension).transferReferences((MutableDataHolder)paramDocument1, (DataHolder)paramDocument2)) bool = true;
/*     */       
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 431 */     if (paramDocument1.contains((DataKeyBase)REFERENCES) && paramDocument2.contains((DataKeyBase)REFERENCES)) {
/* 432 */       if (transferReferences((NodeRepository<Node>)REFERENCES.get((DataHolder)paramDocument1), (NodeRepository<Node>)REFERENCES.get((DataHolder)paramDocument2), (paramBoolean != null) ? paramBoolean
/* 433 */           .booleanValue() : ((REFERENCES_KEEP.get((DataHolder)paramDocument1) == KeepType.FIRST))))
/*     */       {
/* 435 */         bool = true;
/*     */       }
/*     */     }
/*     */     
/* 439 */     if (bool) {
/* 440 */       paramDocument1.set(HtmlRenderer.RECHECK_UNDEFINED_REFERENCES, Boolean.TRUE);
/*     */     }
/* 442 */     return bool;
/*     */   }
/*     */   
/*     */   public static <T extends Node> boolean transferReferences(NodeRepository<T> paramNodeRepository1, NodeRepository<T> paramNodeRepository2, boolean paramBoolean) {
/* 446 */     return NodeRepository.transferReferences(paramNodeRepository1, paramNodeRepository2, paramBoolean, null);
/*     */   }
/*     */   public static interface ReferenceHoldingExtension extends Extension {
/*     */     boolean transferReferences(MutableDataHolder param1MutableDataHolder, DataHolder param1DataHolder); }
/*     */   public static interface ParserExtension extends Extension {
/*     */     void parserOptions(MutableDataHolder param1MutableDataHolder);
/*     */     void extend(Parser.Builder param1Builder); }
/* 453 */   public static class Builder extends BuilderBase<Builder> { final List<CustomBlockParserFactory> blockParserFactories = new ArrayList<>();
/* 454 */     final List<DelimiterProcessor> delimiterProcessors = new ArrayList<>();
/* 455 */     final List<PostProcessorFactory> postProcessorFactories = new ArrayList<>();
/* 456 */     final List<ParagraphPreProcessorFactory> paragraphPreProcessorFactories = new ArrayList<>();
/* 457 */     final List<BlockPreProcessorFactory> blockPreProcessorFactories = new ArrayList<>();
/* 458 */     final List<LinkRefProcessorFactory> linkRefProcessors = new ArrayList<>();
/* 459 */     final List<InlineParserExtensionFactory> inlineParserExtensionFactories = new ArrayList<>();
/* 460 */     InlineParserFactory inlineParserFactory = null;
/* 461 */     final List<SpecialLeadInHandler> specialLeadInHandlers = new ArrayList<>();
/*     */     
/*     */     public Builder(DataHolder param1DataHolder) {
/* 464 */       super(param1DataHolder);
/* 465 */       loadExtensions();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Parser build() {
/* 477 */       return new Parser(this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void removeApiPoint(Object param1Object) {
/* 482 */       if (param1Object instanceof CustomBlockParserFactory) {
/* 483 */         this.blockParserFactories.remove(param1Object); return;
/* 484 */       }  if (param1Object instanceof DelimiterProcessor) {
/* 485 */         this.delimiterProcessors.remove(param1Object); return;
/* 486 */       }  if (param1Object instanceof PostProcessorFactory) {
/* 487 */         this.postProcessorFactories.remove(param1Object); return;
/* 488 */       }  if (param1Object instanceof ParagraphPreProcessorFactory) {
/* 489 */         this.paragraphPreProcessorFactories.remove(param1Object); return;
/* 490 */       }  if (param1Object instanceof BlockPreProcessorFactory) {
/* 491 */         this.blockPreProcessorFactories.remove(param1Object); return;
/* 492 */       }  if (param1Object instanceof LinkRefProcessorFactory) {
/* 493 */         this.linkRefProcessors.remove(param1Object); return;
/* 494 */       }  if (param1Object instanceof SpecialLeadInHandler) {
/* 495 */         this.specialLeadInHandlers.remove(param1Object); return;
/* 496 */       }  if (param1Object instanceof InlineParserExtensionFactory) {
/* 497 */         this.inlineParserExtensionFactories.remove(param1Object); return;
/* 498 */       }  if (param1Object instanceof InlineParserFactory) {
/* 499 */         this.inlineParserFactory = null; return;
/*     */       } 
/* 501 */       throw new IllegalStateException("Unknown data point type: " + param1Object.getClass().getName());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void preloadExtension(Extension param1Extension) {
/* 507 */       if (param1Extension instanceof Parser.ParserExtension)
/*     */       {
/* 509 */         (param1Extension = param1Extension).parserOptions((MutableDataHolder)this);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean loadExtension(Extension param1Extension) {
/* 515 */       if (param1Extension instanceof Parser.ParserExtension) {
/*     */         
/* 517 */         (param1Extension = param1Extension).extend(this);
/* 518 */         return true;
/*     */       } 
/* 520 */       return false;
/*     */     }
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
/*     */     public Builder customBlockParserFactory(CustomBlockParserFactory param1CustomBlockParserFactory) {
/* 534 */       this.blockParserFactories.add(param1CustomBlockParserFactory);
/* 535 */       addExtensionApiPoint(param1CustomBlockParserFactory);
/* 536 */       return this;
/*     */     }
/*     */     
/*     */     public Builder customInlineParserExtensionFactory(InlineParserExtensionFactory param1InlineParserExtensionFactory) {
/* 540 */       this.inlineParserExtensionFactories.add(param1InlineParserExtensionFactory);
/* 541 */       addExtensionApiPoint(param1InlineParserExtensionFactory);
/* 542 */       return this;
/*     */     }
/*     */     
/*     */     public Builder customInlineParserFactory(InlineParserFactory param1InlineParserFactory) {
/* 546 */       if (this.inlineParserFactory != null) {
/* 547 */         throw new IllegalStateException("custom inline parser factory is already set to " + this.inlineParserFactory.getClass().getName());
/*     */       }
/* 549 */       this.inlineParserFactory = param1InlineParserFactory;
/* 550 */       addExtensionApiPoint(param1InlineParserFactory);
/* 551 */       return this;
/*     */     }
/*     */     
/*     */     public Builder customDelimiterProcessor(DelimiterProcessor param1DelimiterProcessor) {
/* 555 */       this.delimiterProcessors.add(param1DelimiterProcessor);
/* 556 */       addExtensionApiPoint(param1DelimiterProcessor);
/* 557 */       return this;
/*     */     }
/*     */     
/*     */     public Builder postProcessorFactory(PostProcessorFactory param1PostProcessorFactory) {
/* 561 */       this.postProcessorFactories.add(param1PostProcessorFactory);
/* 562 */       addExtensionApiPoint(param1PostProcessorFactory);
/* 563 */       return this;
/*     */     }
/*     */     
/*     */     public Builder paragraphPreProcessorFactory(ParagraphPreProcessorFactory param1ParagraphPreProcessorFactory) {
/* 567 */       this.paragraphPreProcessorFactories.add(param1ParagraphPreProcessorFactory);
/* 568 */       addExtensionApiPoint(param1ParagraphPreProcessorFactory);
/* 569 */       return this;
/*     */     }
/*     */     
/*     */     public Builder blockPreProcessorFactory(BlockPreProcessorFactory param1BlockPreProcessorFactory) {
/* 573 */       this.blockPreProcessorFactories.add(param1BlockPreProcessorFactory);
/* 574 */       addExtensionApiPoint(param1BlockPreProcessorFactory);
/* 575 */       return this;
/*     */     }
/*     */     
/*     */     public Builder linkRefProcessorFactory(LinkRefProcessorFactory param1LinkRefProcessorFactory) {
/* 579 */       this.linkRefProcessors.add(param1LinkRefProcessorFactory);
/* 580 */       addExtensionApiPoint(param1LinkRefProcessorFactory);
/* 581 */       return this;
/*     */     }
/*     */     
/*     */     public Builder specialLeadInHandler(SpecialLeadInHandler param1SpecialLeadInHandler) {
/* 585 */       this.specialLeadInHandlers.add(param1SpecialLeadInHandler);
/* 586 */       addExtensionApiPoint(param1SpecialLeadInHandler);
/* 587 */       return this;
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder() {} }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MutableDataHolder addExtensions(MutableDataHolder paramMutableDataHolder, Extension... paramVarArgs) {
/* 651 */     Iterable iterable = (Iterable)EXTENSIONS.get((DataHolder)paramMutableDataHolder);
/* 652 */     ArrayList<Extension> arrayList = new ArrayList(Arrays.asList((Object[])paramVarArgs));
/*     */     
/* 654 */     for (Extension extension : iterable) {
/* 655 */       arrayList.add(extension);
/*     */     }
/*     */     
/* 658 */     paramMutableDataHolder.set(EXTENSIONS, arrayList);
/* 659 */     return paramMutableDataHolder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MutableDataHolder removeExtensions(MutableDataHolder paramMutableDataHolder, Class... paramVarArgs) {
/* 670 */     Iterable iterable = (Iterable)EXTENSIONS.get((DataHolder)paramMutableDataHolder);
/* 671 */     HashSet<Extension> hashSet = new HashSet();
/*     */     
/* 673 */     for (Extension extension : iterable) {
/* 674 */       boolean bool = true; Class[] arrayOfClass; int i; byte b;
/* 675 */       for (i = (arrayOfClass = paramVarArgs).length, b = 0; b < i; b++) {
/* 676 */         Class<?> clazz; if ((clazz = arrayOfClass[b]).isInstance(extension)) {
/* 677 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 681 */       if (bool) {
/* 682 */         hashSet.add(extension);
/*     */       }
/*     */     } 
/*     */     
/* 686 */     paramMutableDataHolder.set(EXTENSIONS, hashSet);
/* 687 */     return paramMutableDataHolder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\Parser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */