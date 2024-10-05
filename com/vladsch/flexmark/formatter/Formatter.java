/*      */ package com.vladsch.flexmark.formatter;
/*      */ import com.vladsch.flexmark.formatter.internal.MergeContextImpl;
/*      */ import com.vladsch.flexmark.html.AttributeProviderFactory;
/*      */ import com.vladsch.flexmark.html.LinkResolver;
/*      */ import com.vladsch.flexmark.html.LinkResolverFactory;
/*      */ import com.vladsch.flexmark.html.renderer.HeaderIdGenerator;
/*      */ import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
/*      */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*      */ import com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory;
/*      */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*      */ import com.vladsch.flexmark.html.renderer.LinkType;
/*      */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*      */ import com.vladsch.flexmark.parser.Parser;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.ast.NodeCollectingVisitor;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.data.DataKey;
/*      */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*      */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*      */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*      */ import com.vladsch.flexmark.util.data.ScopedDataSet;
/*      */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*      */ import com.vladsch.flexmark.util.format.NodeContext;
/*      */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*      */ import com.vladsch.flexmark.util.format.TrackedOffsetList;
/*      */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*      */ import com.vladsch.flexmark.util.format.options.EqualizeTrailingMarker;
/*      */ import com.vladsch.flexmark.util.html.Attributes;
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.misc.Extension;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*      */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.function.Function;
/*      */ import java.util.function.Supplier;
/*      */ 
/*      */ public class Formatter implements IRender {
/*   47 */   public static final Document[] EMPTY_DOCUMENTS = new Document[0];
/*      */ 
/*      */ 
/*      */   
/*   51 */   public static final DataKey<Integer> FORMAT_FLAGS = new DataKey("FORMAT_FLAGS", Integer.valueOf(LineAppendable.F_TRIM_LEADING_WHITESPACE | LineAppendable.F_TRIM_LEADING_EOL));
/*      */ 
/*      */   
/*      */   @Deprecated
/*   55 */   public static final int FORMAT_CONVERT_TABS = LineAppendable.F_CONVERT_TABS; @Deprecated
/*   56 */   public static final int FORMAT_COLLAPSE_WHITESPACE = LineAppendable.F_COLLAPSE_WHITESPACE; @Deprecated
/*   57 */   public static final int FORMAT_SUPPRESS_TRAILING_WHITESPACE = LineAppendable.F_TRIM_TRAILING_WHITESPACE; @Deprecated
/*   58 */   public static final int FORMAT_ALL_OPTIONS = LineAppendable.F_FORMAT_ALL;
/*      */   
/*   60 */   public static final DataKey<Boolean> GENERATE_HEADER_ID = new DataKey("GENERATE_HEADER_ID", Boolean.FALSE);
/*      */   
/*   62 */   public static final DataKey<Integer> MAX_BLANK_LINES = SharedDataKeys.FORMATTER_MAX_BLANK_LINES;
/*   63 */   public static final DataKey<Integer> MAX_TRAILING_BLANK_LINES = SharedDataKeys.FORMATTER_MAX_TRAILING_BLANK_LINES;
/*   64 */   public static final DataKey<Integer> RIGHT_MARGIN = new DataKey("RIGHT_MARGIN", Integer.valueOf(0));
/*      */   
/*   66 */   public static final DataKey<Boolean> APPLY_SPECIAL_LEAD_IN_HANDLERS = SharedDataKeys.APPLY_SPECIAL_LEAD_IN_HANDLERS;
/*   67 */   public static final DataKey<Boolean> ESCAPE_SPECIAL_CHARS = SharedDataKeys.ESCAPE_SPECIAL_CHARS;
/*   68 */   public static final DataKey<Boolean> ESCAPE_NUMBERED_LEAD_IN = SharedDataKeys.ESCAPE_NUMBERED_LEAD_IN;
/*   69 */   public static final DataKey<Boolean> UNESCAPE_SPECIAL_CHARS = SharedDataKeys.UNESCAPE_SPECIAL_CHARS;
/*      */   
/*   71 */   public static final DataKey<DiscretionaryText> SPACE_AFTER_ATX_MARKER = new DataKey("SPACE_AFTER_ATX_MARKER", DiscretionaryText.ADD);
/*   72 */   public static final DataKey<Boolean> SETEXT_HEADING_EQUALIZE_MARKER = new DataKey("SETEXT_HEADING_EQUALIZE_MARKER", Boolean.TRUE);
/*   73 */   public static final DataKey<EqualizeTrailingMarker> ATX_HEADING_TRAILING_MARKER = new DataKey("ATX_HEADING_TRAILING_MARKER", EqualizeTrailingMarker.AS_IS);
/*   74 */   public static final DataKey<HeadingStyle> HEADING_STYLE = new DataKey("HEADING_STYLE", HeadingStyle.AS_IS);
/*   75 */   public static final NullableDataKey<String> THEMATIC_BREAK = new NullableDataKey("THEMATIC_BREAK");
/*   76 */   public static final DataKey<Boolean> BLOCK_QUOTE_BLANK_LINES = SharedDataKeys.BLOCK_QUOTE_BLANK_LINES;
/*   77 */   public static final DataKey<BlockQuoteMarker> BLOCK_QUOTE_MARKERS = new DataKey("BLOCK_QUOTE_MARKERS", BlockQuoteMarker.ADD_COMPACT_WITH_SPACE);
/*   78 */   public static final DataKey<Boolean> INDENTED_CODE_MINIMIZE_INDENT = new DataKey("INDENTED_CODE_MINIMIZE_INDENT", Boolean.TRUE);
/*   79 */   public static final DataKey<Boolean> FENCED_CODE_MINIMIZE_INDENT = new DataKey("FENCED_CODE_MINIMIZE_INDENT", Boolean.TRUE);
/*   80 */   public static final DataKey<Boolean> FENCED_CODE_MATCH_CLOSING_MARKER = new DataKey("FENCED_CODE_MATCH_CLOSING_MARKER", Boolean.TRUE);
/*   81 */   public static final DataKey<Boolean> FENCED_CODE_SPACE_BEFORE_INFO = new DataKey("FENCED_CODE_SPACE_BEFORE_INFO", Boolean.FALSE);
/*   82 */   public static final DataKey<Integer> FENCED_CODE_MARKER_LENGTH = new DataKey("FENCED_CODE_MARKER_LENGTH", Integer.valueOf(3));
/*   83 */   public static final DataKey<CodeFenceMarker> FENCED_CODE_MARKER_TYPE = new DataKey("FENCED_CODE_MARKER_TYPE", CodeFenceMarker.ANY);
/*   84 */   public static final DataKey<Boolean> LIST_ADD_BLANK_LINE_BEFORE = new DataKey("LIST_ADD_BLANK_LINE_BEFORE", Boolean.FALSE);
/*   85 */   public static final DataKey<Boolean> LIST_RENUMBER_ITEMS = new DataKey("LIST_RENUMBER_ITEMS", Boolean.TRUE);
/*   86 */   public static final DataKey<Boolean> LIST_REMOVE_EMPTY_ITEMS = new DataKey("LIST_REMOVE_EMPTY_ITEMS", Boolean.FALSE);
/*   87 */   public static final DataKey<ElementAlignment> LIST_ALIGN_NUMERIC = new DataKey("LIST_ALIGN_NUMERIC", ElementAlignment.NONE);
/*   88 */   public static final DataKey<Boolean> LIST_RESET_FIRST_ITEM_NUMBER = new DataKey("LIST_RESET_FIRST_ITEM_NUMBER", Boolean.FALSE);
/*   89 */   public static final DataKey<ListBulletMarker> LIST_BULLET_MARKER = new DataKey("LIST_BULLET_MARKER", ListBulletMarker.ANY);
/*   90 */   public static final DataKey<ListNumberedMarker> LIST_NUMBERED_MARKER = new DataKey("LIST_NUMBERED_MARKER", ListNumberedMarker.ANY);
/*   91 */   public static final DataKey<ListSpacing> LIST_SPACING = new DataKey("LIST_SPACING", ListSpacing.AS_IS);
/*   92 */   public static final DataKey<Boolean> LISTS_ITEM_CONTENT_AFTER_SUFFIX = new DataKey("LISTS_ITEM_CONTENT_AFTER_SUFFIX", Boolean.FALSE);
/*   93 */   public static final DataKey<ElementPlacement> REFERENCE_PLACEMENT = new DataKey("REFERENCE_PLACEMENT", ElementPlacement.AS_IS);
/*   94 */   public static final DataKey<ElementPlacementSort> REFERENCE_SORT = new DataKey("REFERENCE_SORT", ElementPlacementSort.AS_IS);
/*   95 */   public static final DataKey<Boolean> KEEP_IMAGE_LINKS_AT_START = new DataKey("KEEP_IMAGE_LINKS_AT_START", Boolean.FALSE);
/*   96 */   public static final DataKey<Boolean> KEEP_EXPLICIT_LINKS_AT_START = new DataKey("KEEP_EXPLICIT_LINKS_AT_START", Boolean.FALSE);
/*   97 */   public static final DataKey<Boolean> OPTIMIZED_INLINE_RENDERING = new DataKey("OPTIMIZED_INLINE_RENDERING", Boolean.FALSE);
/*   98 */   public static final DataKey<CharWidthProvider> FORMAT_CHAR_WIDTH_PROVIDER = TableFormatOptions.FORMAT_CHAR_WIDTH_PROVIDER;
/*   99 */   public static final DataKey<Boolean> KEEP_HARD_LINE_BREAKS = new DataKey("KEEP_HARD_LINE_BREAKS", Boolean.TRUE);
/*  100 */   public static final DataKey<Boolean> KEEP_SOFT_LINE_BREAKS = new DataKey("KEEP_SOFT_LINE_BREAKS", Boolean.TRUE);
/*  101 */   public static final DataKey<String> FORMATTER_ON_TAG = new DataKey("FORMATTER_ON_TAG", "@formatter:on");
/*  102 */   public static final DataKey<String> FORMATTER_OFF_TAG = new DataKey("FORMATTER_OFF_TAG", "@formatter:off");
/*  103 */   public static final DataKey<Boolean> FORMATTER_TAGS_ENABLED = new DataKey("FORMATTER_TAGS_ENABLED", Boolean.FALSE);
/*  104 */   public static final DataKey<Boolean> FORMATTER_TAGS_ACCEPT_REGEXP = new DataKey("FORMATTER_TAGS_ACCEPT_REGEXP", Boolean.FALSE);
/*  105 */   public static final NullableDataKey<Pattern> LINK_MARKER_COMMENT_PATTERN = new NullableDataKey("FORMATTER_TAGS_ACCEPT_REGEXP", null);
/*      */   
/*  107 */   public static final DataKey<Boolean> APPEND_TRANSFERRED_REFERENCES = new DataKey("APPEND_TRANSFERRED_REFERENCES", Boolean.FALSE);
/*      */ 
/*      */   
/*  110 */   public static final DataKey<String> TRANSLATION_ID_FORMAT = new DataKey("TRANSLATION_ID_FORMAT", "_%d_");
/*  111 */   public static final DataKey<String> TRANSLATION_HTML_BLOCK_PREFIX = new DataKey("TRANSLATION_HTML_BLOCK_PREFIX", "__");
/*  112 */   public static final DataKey<String> TRANSLATION_HTML_INLINE_PREFIX = new DataKey("TRANSLATION_HTML_INLINE_PREFIX", "_");
/*  113 */   public static final DataKey<String> TRANSLATION_AUTOLINK_PREFIX = new DataKey("TRANSLATION_AUTOLINK_PREFIX", "___");
/*  114 */   public static final DataKey<String> TRANSLATION_EXCLUDE_PATTERN = new DataKey("TRANSLATION_EXCLUDE_PATTERN", "^[^\\p{IsAlphabetic}]*$");
/*  115 */   public static final DataKey<String> TRANSLATION_HTML_BLOCK_TAG_PATTERN = Parser.TRANSLATION_HTML_BLOCK_TAG_PATTERN;
/*  116 */   public static final DataKey<String> TRANSLATION_HTML_INLINE_TAG_PATTERN = Parser.TRANSLATION_HTML_INLINE_TAG_PATTERN;
/*      */ 
/*      */   
/*  119 */   public static final DataKey<String> DOC_RELATIVE_URL = new DataKey("DOC_RELATIVE_URL", "");
/*  120 */   public static final DataKey<String> DOC_ROOT_URL = new DataKey("DOC_ROOT_URL", "");
/*  121 */   public static final DataKey<Boolean> DEFAULT_LINK_RESOLVER = new DataKey("DEFAULT_LINK_RESOLVER", Boolean.FALSE);
/*      */ 
/*      */   
/*  124 */   public static final DataKey<ParserEmulationProfile> FORMATTER_EMULATION_PROFILE = new DataKey("FORMATTER_EMULATION_PROFILE", Parser.PARSER_EMULATION_PROFILE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   public static final DataKey<List<TrackedOffset>> TRACKED_OFFSETS = new DataKey("TRACKED_OFFSETS", Collections.emptyList());
/*      */ 
/*      */   
/*  134 */   public static final DataKey<BasedSequence> TRACKED_SEQUENCE = new DataKey("TRACKED_SEQUENCE", BasedSequence.NULL);
/*      */ 
/*      */   
/*  137 */   public static final DataKey<Boolean> RESTORE_TRACKED_SPACES = new DataKey("RESTORE_END_SPACES", Boolean.FALSE);
/*      */ 
/*      */ 
/*      */   
/*  141 */   public static final DataKey<CharSequence> DOCUMENT_FIRST_PREFIX = new DataKey("DOCUMENT_FIRST_PREFIX", BasedSequence.NULL);
/*  142 */   public static final DataKey<CharSequence> DOCUMENT_PREFIX = new DataKey("DOCUMENT_PREFIX", BasedSequence.NULL);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  148 */   public static final DataKey<Boolean> SETEXT_HEADER_EQUALIZE_MARKER = SETEXT_HEADING_EQUALIZE_MARKER;
/*      */ 
/*      */   
/*      */   @Deprecated
/*  152 */   public static final DataKey<EqualizeTrailingMarker> ATX_HEADER_TRAILING_MARKER = ATX_HEADING_TRAILING_MARKER;
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  157 */   public static final DataKey<TableCaptionHandling> FORMAT_TABLE_CAPTION = TableFormatOptions.FORMAT_TABLE_CAPTION;
/*      */ 
/*      */   
/*      */   @Deprecated
/*  161 */   public static final DataKey<DiscretionaryText> FORMAT_TABLE_CAPTION_SPACES = TableFormatOptions.FORMAT_TABLE_CAPTION_SPACES;
/*      */ 
/*      */   
/*      */   @Deprecated
/*  165 */   public static final DataKey<String> FORMAT_TABLE_INDENT_PREFIX = TableFormatOptions.FORMAT_TABLE_INDENT_PREFIX;
/*      */ 
/*      */   
/*  168 */   public static final DataKey<Map<String, String>> UNIQUIFICATION_MAP = new DataKey("REFERENCES_UNIQUIFICATION_MAP", HashMap::new);
/*  169 */   public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_ID_MAP = new DataKey("ATTRIBUTE_UNIQUIFICATION_ID_MAP", HashMap::new);
/*      */   
/*      */   private final DataHolder options;
/*      */   final List<LinkResolverFactory> linkResolverFactories;
/*      */   final List<NodeFormatterFactory> nodeFormatterFactories;
/*      */   final HeaderIdGeneratorFactory idGeneratorFactory;
/*      */   
/*      */   Formatter(Builder paramBuilder) {
/*  177 */     this.options = (DataHolder)paramBuilder.toImmutable();
/*  178 */     this.idGeneratorFactory = (paramBuilder.htmlIdGeneratorFactory == null) ? (HeaderIdGeneratorFactory)new HeaderIdGenerator.Factory() : paramBuilder.htmlIdGeneratorFactory;
/*      */     
/*  180 */     this.linkResolverFactories = DependencyResolver.resolveFlatDependencies(paramBuilder.linkResolverFactories, null, null);
/*  181 */     this.nodeFormatterFactories = calculateNodeFormatterFactories(paramBuilder.nodeFormatterFactories);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<NodeFormatterFactory> calculateNodeFormatterFactories(List<NodeFormatterFactory> paramList) {
/*  187 */     (paramList = new ArrayList<>(paramList)).add(new CoreNodeFormatter.Factory());
/*  188 */     return DependencyResolver.resolveFlatDependencies(paramList, null, null);
/*      */   }
/*      */   
/*      */   public TranslationHandler getTranslationHandler(TranslationHandlerFactory paramTranslationHandlerFactory, HtmlIdGeneratorFactory paramHtmlIdGeneratorFactory) {
/*  192 */     return paramTranslationHandlerFactory.create(this.options, paramHtmlIdGeneratorFactory);
/*      */   }
/*      */   
/*      */   public TranslationHandler getTranslationHandler(HtmlIdGeneratorFactory paramHtmlIdGeneratorFactory) {
/*  196 */     return (TranslationHandler)new TranslationHandlerImpl(this.options, paramHtmlIdGeneratorFactory);
/*      */   }
/*      */   
/*      */   public TranslationHandler getTranslationHandler() {
/*  200 */     return (TranslationHandler)new TranslationHandlerImpl(this.options, (HtmlIdGeneratorFactory)this.idGeneratorFactory);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DataHolder getOptions() {
/*  206 */     return this.options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Builder builder() {
/*  215 */     return new Builder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Builder builder(DataHolder paramDataHolder) {
/*  225 */     return new Builder(paramDataHolder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(Node paramNode, Appendable paramAppendable) {
/*  237 */     render(paramNode, paramAppendable, ((Integer)MAX_TRAILING_BLANK_LINES.get(this.options)).intValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(Node paramNode, Appendable paramAppendable, int paramInt) {
/*  251 */     MarkdownWriter markdownWriter = new MarkdownWriter(paramAppendable, ((Integer)FORMAT_FLAGS.get(this.options)).intValue());
/*      */     MainNodeFormatter mainNodeFormatter;
/*  253 */     (mainNodeFormatter = new MainNodeFormatter(this.options, markdownWriter, paramNode.getDocument(), null)).render(paramNode);
/*  254 */     markdownWriter.appendToSilently(paramAppendable, ((Integer)MAX_BLANK_LINES.get(this.options)).intValue(), paramInt);
/*      */ 
/*      */     
/*  257 */     BasedSequence basedSequence = paramNode.getDocument().getChars();
/*  258 */     if (paramAppendable instanceof SequenceBuilder && paramNode.getDocument().getChars() != mainNodeFormatter.trackedSequence)
/*      */     {
/*  260 */       basedSequence = ((SequenceBuilder)paramAppendable).toSequence(mainNodeFormatter.trackedSequence);
/*      */     }
/*      */     
/*  263 */     TrackedOffsetUtils.resolveTrackedOffsets(basedSequence, (LineAppendable)markdownWriter, (List)mainNodeFormatter.trackedOffsets.getUnresolvedOffsets(), paramInt, ((Boolean)SharedDataKeys.RUNNING_TESTS.get(this.options)).booleanValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String render(Node paramNode) {
/*  274 */     StringBuilder stringBuilder = new StringBuilder();
/*  275 */     render(paramNode, stringBuilder);
/*  276 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void translationRender(Node paramNode, Appendable paramAppendable, TranslationHandler paramTranslationHandler, RenderPurpose paramRenderPurpose) {
/*  286 */     translationRender(paramNode, paramAppendable, ((Integer)MAX_TRAILING_BLANK_LINES.get(this.options)).intValue(), paramTranslationHandler, paramRenderPurpose);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String translationRender(Node paramNode, TranslationHandler paramTranslationHandler, RenderPurpose paramRenderPurpose) {
/*  296 */     StringBuilder stringBuilder = new StringBuilder();
/*  297 */     translationRender(paramNode, stringBuilder, paramTranslationHandler, paramRenderPurpose);
/*  298 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void translationRender(Node paramNode, Appendable paramAppendable, int paramInt, TranslationHandler paramTranslationHandler, RenderPurpose paramRenderPurpose) {
/*  308 */     paramTranslationHandler.setRenderPurpose(paramRenderPurpose);
/*      */     MainNodeFormatter mainNodeFormatter;
/*  310 */     (mainNodeFormatter = new MainNodeFormatter(this.options, new MarkdownWriter(((Integer)FORMAT_FLAGS.get(this.options)).intValue() & (LineAppendable.F_TRIM_LEADING_WHITESPACE ^ 0xFFFFFFFF)), paramNode.getDocument(), paramTranslationHandler)).render(paramNode);
/*  311 */     mainNodeFormatter.flushTo(paramAppendable, ((Integer)MAX_BLANK_LINES.get(this.options)).intValue(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mergeRender(Document[] paramArrayOfDocument, Appendable paramAppendable) {
/*  321 */     mergeRender(paramArrayOfDocument, paramAppendable, ((Integer)MAX_TRAILING_BLANK_LINES.get(this.options)).intValue());
/*      */   }
/*      */   
/*      */   public void mergeRender(List<Document> paramList, Appendable paramAppendable) {
/*  325 */     mergeRender(paramList.<Document>toArray(EMPTY_DOCUMENTS), paramAppendable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String mergeRender(Document[] paramArrayOfDocument, int paramInt) {
/*  335 */     StringBuilder stringBuilder = new StringBuilder();
/*  336 */     mergeRender(paramArrayOfDocument, stringBuilder, paramInt);
/*  337 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   public String mergeRender(List<Document> paramList, int paramInt) {
/*  341 */     return mergeRender(paramList.<Document>toArray(EMPTY_DOCUMENTS), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mergeRender(List<Document> paramList, Appendable paramAppendable, int paramInt) {
/*  351 */     mergeRender(paramList.<Document>toArray(EMPTY_DOCUMENTS), paramAppendable, paramInt);
/*      */   }
/*      */   
/*      */   public void mergeRender(Document[] paramArrayOfDocument, Appendable paramAppendable, int paramInt) {
/*      */     MutableDataSet mutableDataSet;
/*  356 */     (mutableDataSet = new MutableDataSet(this.options)).set(Parser.HTML_FOR_TRANSLATOR, Boolean.TRUE);
/*      */     
/*  358 */     TranslationHandler[] arrayOfTranslationHandler = new TranslationHandler[paramArrayOfDocument.length];
/*      */     
/*  360 */     List[] arrayOfList = new List[paramArrayOfDocument.length];
/*      */     
/*  362 */     int j = paramArrayOfDocument.length;
/*  363 */     for (byte b = 0; b < j; b++) {
/*  364 */       arrayOfTranslationHandler[b] = getTranslationHandler((this.idGeneratorFactory == null) ? (HtmlIdGeneratorFactory)new HeaderIdGenerator.Factory() : (HtmlIdGeneratorFactory)this.idGeneratorFactory);
/*      */     }
/*      */     
/*  367 */     MergeContextImpl mergeContextImpl = new MergeContextImpl(paramArrayOfDocument, arrayOfTranslationHandler);
/*  368 */     int i = ((Integer)FORMAT_FLAGS.get(this.options)).intValue();
/*  369 */     j = ((Integer)MAX_BLANK_LINES.get(this.options)).intValue();
/*      */     
/*  371 */     mergeContextImpl.forEachPrecedingDocument(null, (paramTranslationContext, paramDocument, paramInt2) -> {
/*      */           (paramTranslationContext = paramTranslationContext).setRenderPurpose(RenderPurpose.TRANSLATION_SPANS);
/*      */           
/*      */           MainNodeFormatter mainNodeFormatter;
/*      */           
/*      */           (mainNodeFormatter = new MainNodeFormatter((DataHolder)paramMutableDataSet, new MarkdownWriter(paramInt1), paramDocument, (TranslationHandler)paramTranslationContext)).render((Node)paramDocument);
/*      */           
/*      */           paramArrayOfList[paramInt2] = paramTranslationContext.getTranslatingTexts();
/*      */         });
/*  380 */     paramArrayOfDocument = new Document[paramArrayOfDocument.length];
/*      */     
/*  382 */     mergeContextImpl.forEachPrecedingDocument(null, (paramTranslationContext, paramDocument, paramInt4) -> {
/*      */           (paramTranslationContext = paramTranslationContext).setRenderPurpose(RenderPurpose.TRANSLATED_SPANS);
/*      */           
/*      */           paramTranslationContext.setTranslatedTexts(paramArrayOfList[paramInt4]);
/*      */           
/*      */           MainNodeFormatter mainNodeFormatter;
/*      */           
/*      */           (mainNodeFormatter = new MainNodeFormatter((DataHolder)paramMutableDataSet, new MarkdownWriter(paramInt1), paramDocument, (TranslationHandler)paramTranslationContext)).render((Node)paramDocument);
/*      */           
/*      */           StringBuilder stringBuilder = new StringBuilder();
/*      */           
/*      */           mainNodeFormatter.flushTo(stringBuilder, paramInt2, paramInt3);
/*      */           paramArrayOfDocument[paramInt4] = Parser.builder((DataHolder)paramMutableDataSet).build().parse(stringBuilder.toString());
/*      */         });
/*  396 */     mergeContextImpl.setDocuments(paramArrayOfDocument);
/*      */     
/*  398 */     mergeContextImpl.forEachPrecedingDocument(null, (paramTranslationContext, paramDocument, paramInt4) -> {
/*      */           (paramTranslationContext = paramTranslationContext).setRenderPurpose(RenderPurpose.TRANSLATED);
/*      */           MarkdownWriter markdownWriter = new MarkdownWriter(paramInt1);
/*      */           MainNodeFormatter mainNodeFormatter;
/*      */           (mainNodeFormatter = new MainNodeFormatter((DataHolder)paramMutableDataSet, markdownWriter, paramDocument, (TranslationHandler)paramTranslationContext)).render((Node)paramDocument);
/*      */           markdownWriter.blankLine();
/*      */           mainNodeFormatter.flushTo(paramAppendable, paramInt2, paramInt3);
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Builder
/*      */     extends BuilderBase<Builder>
/*      */   {
/*  415 */     List<AttributeProviderFactory> attributeProviderFactories = new ArrayList<>();
/*  416 */     List<NodeFormatterFactory> nodeFormatterFactories = new ArrayList<>();
/*  417 */     List<LinkResolverFactory> linkResolverFactories = new ArrayList<>();
/*  418 */     HeaderIdGeneratorFactory htmlIdGeneratorFactory = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder(DataHolder param1DataHolder) {
/*  425 */       super(param1DataHolder);
/*  426 */       loadExtensions();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Formatter build() {
/*  434 */       return new Formatter(this);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void removeApiPoint(Object param1Object) {
/*  439 */       if (param1Object instanceof AttributeProviderFactory) { this.attributeProviderFactories.remove(param1Object); return; }
/*  440 */        if (param1Object instanceof NodeFormatterFactory) { this.nodeFormatterFactories.remove(param1Object); return; }
/*  441 */        if (param1Object instanceof LinkResolverFactory) { this.linkResolverFactories.remove(param1Object); return; }
/*  442 */        if (param1Object instanceof HeaderIdGeneratorFactory) { this.htmlIdGeneratorFactory = null; return; }
/*      */       
/*  444 */       throw new IllegalStateException("Unknown data point type: " + param1Object.getClass().getName());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void preloadExtension(Extension param1Extension) {
/*  450 */       if (param1Extension instanceof Formatter.FormatterExtension)
/*      */       {
/*  452 */         (param1Extension = param1Extension).rendererOptions((MutableDataHolder)this);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean loadExtension(Extension param1Extension) {
/*  458 */       if (param1Extension instanceof Formatter.FormatterExtension) {
/*      */         
/*  460 */         (param1Extension = param1Extension).extend(this);
/*  461 */         return true;
/*      */       } 
/*  463 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder nodeFormatterFactory(NodeFormatterFactory param1NodeFormatterFactory) {
/*  478 */       this.nodeFormatterFactories.add(param1NodeFormatterFactory);
/*  479 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder htmlIdGeneratorFactory(HeaderIdGeneratorFactory param1HeaderIdGeneratorFactory) {
/*  491 */       if (this.htmlIdGeneratorFactory != null) {
/*  492 */         throw new IllegalStateException("custom header id factory is already set to " + param1HeaderIdGeneratorFactory.getClass().getName());
/*      */       }
/*  494 */       this.htmlIdGeneratorFactory = param1HeaderIdGeneratorFactory;
/*  495 */       addExtensionApiPoint(param1HeaderIdGeneratorFactory);
/*  496 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder linkResolverFactory(LinkResolverFactory param1LinkResolverFactory) {
/*  510 */       this.linkResolverFactories.add(param1LinkResolverFactory);
/*  511 */       addExtensionApiPoint(param1LinkResolverFactory);
/*  512 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  530 */   private static final Iterator<Node> NULL_ITERATOR = new Iterator<Node>()
/*      */     {
/*      */       public final boolean hasNext() {
/*  533 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public final Node next() {
/*  538 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public final void remove() {}
/*      */     };
/*      */   
/*      */   public static final Iterable<Node> NULL_ITERABLE = () -> NULL_ITERATOR;
/*      */   
/*      */   private class MainNodeFormatter
/*      */     extends NodeFormatterSubContext
/*      */   {
/*      */     private final Document document;
/*      */     private final Map<Class<?>, List<NodeFormattingHandler<?>>> renderers;
/*      */     private final SubClassingBag<Node> collectedNodes;
/*      */     private final List<PhasedNodeFormatter> phasedFormatters;
/*      */     private final Set<FormattingPhase> renderingPhases;
/*      */     private final DataHolder options;
/*      */     private final Boolean isFormatControlEnabled;
/*      */     private FormattingPhase phase;
/*      */     final TranslationHandler translationHandler;
/*      */     private final LinkResolver[] linkResolvers;
/*      */     private final HashMap<LinkType, HashMap<String, ResolvedLink>> resolvedLinkMap;
/*      */     private final ExplicitAttributeIdProvider explicitAttributeIdProvider;
/*      */     private final HtmlIdGenerator idGenerator;
/*      */     private FormatControlProcessor controlProcessor;
/*      */     private final CharPredicate blockQuoteLikePredicate;
/*      */     private final BasedSequence blockQuoteLikeChars;
/*      */     final TrackedOffsetList trackedOffsets;
/*      */     final BasedSequence trackedSequence;
/*      */     final boolean restoreTrackedSpaces;
/*      */     final FormatterOptions formatterOptions;
/*      */     
/*      */     MainNodeFormatter(DataHolder param1DataHolder, MarkdownWriter param1MarkdownWriter, Document param1Document, TranslationHandler param1TranslationHandler) {
/*  572 */       super(param1MarkdownWriter); ExplicitAttributeIdProvider explicitAttributeIdProvider; this.resolvedLinkMap = new HashMap<>();
/*  573 */       this.translationHandler = param1TranslationHandler;
/*  574 */       this.options = (DataHolder)new ScopedDataSet((DataHolder)param1Document, param1DataHolder);
/*  575 */       this.formatterOptions = new FormatterOptions(this.options);
/*  576 */       this.document = param1Document;
/*  577 */       this.renderers = new HashMap<>(32);
/*  578 */       this.renderingPhases = new HashSet<>((FormattingPhase.values()).length);
/*  579 */       HashSet<NodeFormattingHandler<?>> hashSet = new HashSet(100);
/*      */       
/*  581 */       Boolean bool = (Boolean)Formatter.DEFAULT_LINK_RESOLVER.get(this.options);
/*  582 */       this.linkResolvers = new LinkResolver[Formatter.this.linkResolverFactories.size() + (bool.booleanValue() ? 1 : 0)];
/*      */       
/*  584 */       this.isFormatControlEnabled = (Boolean)Formatter.FORMATTER_TAGS_ENABLED.get(this.options);
/*      */       
/*  586 */       for (byte b = 0; b < Formatter.this.linkResolverFactories.size(); b++) {
/*  587 */         this.linkResolvers[b] = ((LinkResolverFactory)Formatter.this.linkResolverFactories.get(b)).apply((LinkResolverBasicContext)this);
/*      */       }
/*      */       
/*  590 */       if (bool.booleanValue())
/*      */       {
/*  592 */         this.linkResolvers[Formatter.this.linkResolverFactories.size()] = (new MergeLinkResolver.Factory()).apply((LinkResolverBasicContext)this);
/*      */       }
/*      */       
/*  595 */       param1MarkdownWriter.setContext(this);
/*      */       
/*  597 */       List<NodeFormatterFactory> list = Formatter.this.nodeFormatterFactories;
/*  598 */       this.phasedFormatters = new ArrayList<>(list.size());
/*  599 */       param1MarkdownWriter = null;
/*  600 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/*  602 */       for (int i = list.size() - 1; i >= 0; i--) {
/*      */         NodeFormatterFactory nodeFormatterFactory;
/*      */         
/*      */         NodeFormatter nodeFormatter;
/*      */         
/*  607 */         if (nodeFormatter = (nodeFormatterFactory = list.get(i)).create(this.options) instanceof ExplicitAttributeIdProvider) {
/*  608 */           explicitAttributeIdProvider = (ExplicitAttributeIdProvider)nodeFormatter;
/*      */         }
/*      */         
/*      */         char c;
/*  612 */         if ((c = nodeFormatter.getBlockQuoteLikePrefixChar()) != '\000') {
/*  613 */           stringBuilder.append(c);
/*      */         }
/*      */         
/*      */         Set<NodeFormattingHandler<?>> set;
/*  617 */         if ((set = nodeFormatter.getNodeFormattingHandlers()) != null) {
/*      */           
/*  619 */           for (NodeFormattingHandler<?> nodeFormattingHandler : set) {
/*      */             List<NodeFormattingHandler> list2;
/*      */             
/*  622 */             (list2 = (List)this.renderers.computeIfAbsent(nodeFormattingHandler.getNodeType(), param1Class -> new ArrayList())).add(0, nodeFormattingHandler);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  628 */           if ((set = (Set)nodeFormatter.getNodeClasses()) != null) {
/*  629 */             hashSet.addAll(set);
/*      */           }
/*      */           
/*  632 */           if (nodeFormatter instanceof PhasedNodeFormatter) {
/*      */             Set<FormattingPhase> set1;
/*  634 */             if ((set1 = ((PhasedNodeFormatter)nodeFormatter).getFormattingPhases()) != null) {
/*  635 */               if (set1.isEmpty()) throw new IllegalStateException("PhasedNodeFormatter with empty Phases"); 
/*  636 */               this.renderingPhases.addAll(set1);
/*  637 */               this.phasedFormatters.add((PhasedNodeFormatter)nodeFormatter);
/*      */             } else {
/*  639 */               throw new IllegalStateException("PhasedNodeFormatter with null Phases");
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  644 */       this.restoreTrackedSpaces = ((Boolean)Formatter.RESTORE_TRACKED_SPACES.get(this.options)).booleanValue();
/*  645 */       BasedSequence basedSequence = (BasedSequence)Formatter.TRACKED_SEQUENCE.get(this.options);
/*  646 */       List list1 = (List)Formatter.TRACKED_OFFSETS.get(this.options);
/*      */       
/*  648 */       this.trackedSequence = basedSequence.isEmpty() ? param1Document.getChars() : basedSequence;
/*  649 */       this.trackedOffsets = list1.isEmpty() ? TrackedOffsetList.EMPTY_LIST : TrackedOffsetList.create(this.trackedSequence, list1);
/*      */       
/*  651 */       assert this.trackedSequence.equals(param1Document.getChars()) : String.format("TRACKED_SEQUENCE must be character identical to document.getChars()\nTRACKED_SEQUENCE: '%s'\n altSeq: '%s'\n", new Object[] { this.trackedSequence
/*      */ 
/*      */             
/*  654 */             .toVisibleWhitespaceString(), param1Document.getChars().toVisibleWhitespaceString() });
/*      */       
/*  656 */       String str = stringBuilder.toString();
/*  657 */       this.blockQuoteLikeChars = BasedSequence.of(str);
/*  658 */       this.blockQuoteLikePredicate = CharPredicate.anyOf(str);
/*      */ 
/*      */       
/*  661 */       this.idGenerator = ((Boolean)Formatter.GENERATE_HEADER_ID.get(this.options)).booleanValue() ? ((Formatter.this.idGeneratorFactory != null) ? Formatter.this.idGeneratorFactory.create(this) : (HtmlIdGenerator)(new HeaderIdGenerator.Factory()).create(this)) : null;
/*      */       
/*  663 */       if (this.idGenerator != null) {
/*  664 */         this.idGenerator.generateIds(param1Document);
/*      */       }
/*      */       
/*  667 */       this.explicitAttributeIdProvider = explicitAttributeIdProvider;
/*      */ 
/*      */       
/*  670 */       if (!hashSet.isEmpty()) {
/*      */         NodeCollectingVisitor nodeCollectingVisitor;
/*  672 */         (nodeCollectingVisitor = new NodeCollectingVisitor(hashSet)).collect((Node)param1Document);
/*  673 */         this.collectedNodes = nodeCollectingVisitor.getSubClassingBag(); return;
/*      */       } 
/*  675 */       this.collectedNodes = null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String encodeUrl(CharSequence param1CharSequence) {
/*  682 */       return String.valueOf(param1CharSequence);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public ResolvedLink resolveLink(LinkType param1LinkType, CharSequence param1CharSequence, Attributes param1Attributes, Boolean param1Boolean) {
/*  688 */       return resolveLink(this, param1LinkType, param1CharSequence, param1Attributes);
/*      */     }
/*      */     
/*      */     ResolvedLink resolveLink(NodeFormatterSubContext param1NodeFormatterSubContext, LinkType param1LinkType, CharSequence param1CharSequence, Attributes param1Attributes) {
/*  692 */       HashMap<CharSequence, ResolvedLink> hashMap = (HashMap)this.resolvedLinkMap.computeIfAbsent(param1LinkType, param1LinkType -> new HashMap<>());
/*      */       
/*  694 */       param1CharSequence = String.valueOf(param1CharSequence);
/*      */       ResolvedLink resolvedLink;
/*  696 */       if ((resolvedLink = (ResolvedLink)hashMap.get(param1CharSequence)) == null) {
/*  697 */         resolvedLink = new ResolvedLink(param1LinkType, param1CharSequence, param1Attributes);
/*      */         
/*  699 */         if (!param1CharSequence.isEmpty()) {
/*  700 */           Node node = param1NodeFormatterSubContext.renderingNode; LinkResolver[] arrayOfLinkResolver; int i; byte b;
/*      */           LinkResolver linkResolver;
/*  702 */           for (i = (arrayOfLinkResolver = this.linkResolvers).length, b = 0; b < i && (
/*      */             
/*  704 */             resolvedLink = (linkResolver = arrayOfLinkResolver[b]).resolveLink(node, (LinkResolverBasicContext)this, resolvedLink)).getStatus() == LinkStatus.UNKNOWN; b++);
/*      */         } 
/*      */ 
/*      */         
/*  708 */         hashMap.put(param1CharSequence, resolvedLink);
/*      */       } 
/*      */       
/*  711 */       return resolvedLink;
/*      */     }
/*      */ 
/*      */     
/*      */     public void addExplicitId(Node param1Node, String param1String, NodeFormatterContext param1NodeFormatterContext, MarkdownWriter param1MarkdownWriter) {
/*  716 */       if (param1String != null && this.explicitAttributeIdProvider != null) {
/*  717 */         this.explicitAttributeIdProvider.addExplicitId(param1Node, param1String, param1NodeFormatterContext, param1MarkdownWriter);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public RenderPurpose getRenderPurpose() {
/*  724 */       return (this.translationHandler == null) ? RenderPurpose.FORMAT : this.translationHandler.getRenderPurpose();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isTransformingText() {
/*  729 */       return (this.translationHandler != null && this.translationHandler.isTransformingText());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public CharSequence transformNonTranslating(CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, CharSequence param1CharSequence4) {
/*  735 */       return (this.translationHandler == null) ? param1CharSequence2 : this.translationHandler.transformNonTranslating(param1CharSequence1, param1CharSequence2, param1CharSequence3, param1CharSequence4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public CharSequence transformTranslating(CharSequence param1CharSequence1, CharSequence param1CharSequence2, CharSequence param1CharSequence3, CharSequence param1CharSequence4) {
/*  741 */       return (this.translationHandler == null) ? param1CharSequence2 : this.translationHandler.transformTranslating(param1CharSequence1, param1CharSequence2, param1CharSequence3, param1CharSequence4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public CharSequence transformAnchorRef(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/*  747 */       return (this.translationHandler == null) ? param1CharSequence2 : this.translationHandler.transformAnchorRef(param1CharSequence1, param1CharSequence2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void postProcessNonTranslating(Function<String, CharSequence> param1Function, Runnable param1Runnable) {
/*  752 */       if (this.translationHandler != null) { this.translationHandler.postProcessNonTranslating(param1Function, param1Runnable); return; }
/*  753 */        param1Runnable.run();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T postProcessNonTranslating(Function<String, CharSequence> param1Function, Supplier<T> param1Supplier) {
/*  759 */       if (this.translationHandler != null) return this.translationHandler.postProcessNonTranslating(param1Function, param1Supplier); 
/*  760 */       return param1Supplier.get();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isPostProcessingNonTranslating() {
/*  765 */       return (this.translationHandler != null && this.translationHandler.isPostProcessingNonTranslating());
/*      */     }
/*      */ 
/*      */     
/*      */     public MergeContext getMergeContext() {
/*  770 */       return (this.translationHandler == null) ? null : this.translationHandler.getMergeContext();
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlIdGenerator getIdGenerator() {
/*  775 */       return (this.translationHandler == null) ? this.idGenerator : this.translationHandler.getIdGenerator();
/*      */     }
/*      */ 
/*      */     
/*      */     public void translatingSpan(TranslatingSpanRender param1TranslatingSpanRender) {
/*  780 */       if (this.translationHandler != null) {
/*  781 */         this.translationHandler.translatingSpan(param1TranslatingSpanRender); return;
/*      */       } 
/*  783 */       param1TranslatingSpanRender.render(this, this.markdown);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void nonTranslatingSpan(TranslatingSpanRender param1TranslatingSpanRender) {
/*  789 */       if (this.translationHandler != null) {
/*  790 */         this.translationHandler.nonTranslatingSpan(param1TranslatingSpanRender); return;
/*      */       } 
/*  792 */       param1TranslatingSpanRender.render(this, this.markdown);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void translatingRefTargetSpan(Node param1Node, TranslatingSpanRender param1TranslatingSpanRender) {
/*  798 */       if (this.translationHandler != null) {
/*  799 */         this.translationHandler.translatingRefTargetSpan(param1Node, param1TranslatingSpanRender); return;
/*      */       } 
/*  801 */       param1TranslatingSpanRender.render(this, this.markdown);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MutableDataHolder getTranslationStore() {
/*  808 */       if (this.translationHandler != null) {
/*  809 */         return this.translationHandler.getTranslationStore();
/*      */       }
/*  811 */       return (MutableDataHolder)this.document;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void customPlaceholderFormat(TranslationPlaceholderGenerator param1TranslationPlaceholderGenerator, TranslatingSpanRender param1TranslatingSpanRender) {
/*  817 */       if (this.translationHandler != null) {
/*  818 */         this.translationHandler.customPlaceholderFormat(param1TranslationPlaceholderGenerator, param1TranslatingSpanRender); return;
/*      */       } 
/*  820 */       param1TranslatingSpanRender.render(this, this.markdown);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Node getCurrentNode() {
/*  827 */       return this.renderingNode;
/*      */     }
/*      */ 
/*      */     
/*      */     public DataHolder getOptions() {
/*  832 */       return this.options;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public FormatterOptions getFormatterOptions() {
/*  838 */       return this.formatterOptions;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Document getDocument() {
/*  844 */       return this.document;
/*      */     }
/*      */ 
/*      */     
/*      */     public CharPredicate getBlockQuoteLikePrefixPredicate() {
/*  849 */       return this.blockQuoteLikePredicate;
/*      */     }
/*      */ 
/*      */     
/*      */     public BasedSequence getBlockQuoteLikePrefixChars() {
/*  854 */       return this.blockQuoteLikeChars;
/*      */     }
/*      */ 
/*      */     
/*      */     public TrackedOffsetList getTrackedOffsets() {
/*  859 */       return this.trackedOffsets;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isRestoreTrackedSpaces() {
/*  864 */       return this.restoreTrackedSpaces;
/*      */     }
/*      */ 
/*      */     
/*      */     public BasedSequence getTrackedSequence() {
/*  869 */       return this.trackedSequence;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public FormattingPhase getFormattingPhase() {
/*  875 */       return this.phase;
/*      */     }
/*      */ 
/*      */     
/*      */     public void render(Node param1Node) {
/*  880 */       renderNode(param1Node, this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Iterable<? extends Node> nodesOfType(Class<?>[] param1ArrayOfClass) {
/*  886 */       return (Iterable<? extends Node>)((this.collectedNodes == null) ? Formatter.NULL_ITERABLE : this.collectedNodes.itemsOfType(Node.class, param1ArrayOfClass));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Iterable<? extends Node> nodesOfType(Collection<Class<?>> param1Collection) {
/*  892 */       return (Iterable<? extends Node>)((this.collectedNodes == null) ? Formatter.NULL_ITERABLE : this.collectedNodes.itemsOfType(Node.class, param1Collection));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Iterable<? extends Node> reversedNodesOfType(Class<?>[] param1ArrayOfClass) {
/*  898 */       return (Iterable<? extends Node>)((this.collectedNodes == null) ? Formatter.NULL_ITERABLE : this.collectedNodes.reversedItemsOfType(Node.class, param1ArrayOfClass));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Iterable<? extends Node> reversedNodesOfType(Collection<Class<?>> param1Collection) {
/*  904 */       return (Iterable<? extends Node>)((this.collectedNodes == null) ? Formatter.NULL_ITERABLE : this.collectedNodes.reversedItemsOfType(Node.class, param1Collection));
/*      */     }
/*      */ 
/*      */     
/*      */     public NodeFormatterContext getSubContext() {
/*  909 */       return getSubContextRaw((DataHolder)null, this.markdown.getBuilder());
/*      */     }
/*      */ 
/*      */     
/*      */     public NodeFormatterContext getSubContext(DataHolder param1DataHolder) {
/*  914 */       return getSubContextRaw(param1DataHolder, this.markdown.getBuilder());
/*      */     }
/*      */ 
/*      */     
/*      */     public NodeFormatterContext getSubContext(DataHolder param1DataHolder, ISequenceBuilder<?, ?> param1ISequenceBuilder) {
/*  919 */       return getSubContextRaw(param1DataHolder, param1ISequenceBuilder);
/*      */     }
/*      */     
/*      */     NodeFormatterContext getSubContextRaw(DataHolder param1DataHolder, ISequenceBuilder<?, ?> param1ISequenceBuilder) {
/*      */       MarkdownWriter markdownWriter;
/*  924 */       (markdownWriter = new MarkdownWriter((Appendable)param1ISequenceBuilder, getMarkdown().getOptions())).setContext(this);
/*      */       
/*  926 */       return new SubNodeFormatter(this, markdownWriter, param1DataHolder);
/*      */     }
/*      */     
/*      */     void renderNode(Node param1Node, NodeFormatterSubContext param1NodeFormatterSubContext) {
/*  930 */       if (param1Node instanceof Document) {
/*      */         
/*  932 */         if (this.translationHandler != null)
/*  933 */           this.translationHandler.beginRendering((Document)param1Node, param1NodeFormatterSubContext, param1NodeFormatterSubContext.markdown);  FormattingPhase[] arrayOfFormattingPhase;
/*      */         int i;
/*      */         byte b;
/*  936 */         for (i = (arrayOfFormattingPhase = FormattingPhase.values()).length, b = 0; b < i; ) {
/*  937 */           FormattingPhase formattingPhase; if ((formattingPhase = arrayOfFormattingPhase[b]) == FormattingPhase.DOCUMENT || this.renderingPhases.contains(formattingPhase)) {
/*  938 */             this.phase = formattingPhase;
/*      */             
/*  940 */             if (this.phase == FormattingPhase.DOCUMENT) {
/*      */               
/*  942 */               ((MarkdownWriter)((MarkdownWriter)param1NodeFormatterSubContext.markdown.pushPrefix()).setPrefix((CharSequence)Formatter.DOCUMENT_FIRST_PREFIX.get((DataHolder)param1Node), false)).setPrefix((CharSequence)Formatter.DOCUMENT_PREFIX.get((DataHolder)param1Node), true);
/*      */               
/*      */               List<NodeFormattingHandler<?>> list1;
/*  945 */               if ((list1 = this.renderers.get(param1Node.getClass())) != null) {
/*  946 */                 param1NodeFormatterSubContext.rendererList = list1;
/*  947 */                 param1NodeFormatterSubContext.rendererIndex = 0;
/*  948 */                 param1NodeFormatterSubContext.renderingNode = param1Node;
/*  949 */                 ((NodeFormattingHandler)list1.get(0)).render(param1Node, param1NodeFormatterSubContext, param1NodeFormatterSubContext.markdown);
/*  950 */                 param1NodeFormatterSubContext.renderingNode = null;
/*  951 */                 param1NodeFormatterSubContext.rendererList = null;
/*  952 */                 param1NodeFormatterSubContext.rendererIndex = -1;
/*      */               } 
/*      */               
/*  955 */               param1NodeFormatterSubContext.markdown.popPrefix();
/*      */             } else {
/*      */               
/*  958 */               for (Iterator<PhasedNodeFormatter> iterator = this.phasedFormatters.iterator(); iterator.hasNext();) {
/*  959 */                 if ((phasedNodeFormatter = iterator.next()).getFormattingPhases().contains(formattingPhase)) {
/*  960 */                   param1NodeFormatterSubContext.renderingNode = param1Node;
/*  961 */                   phasedNodeFormatter.renderDocument(param1NodeFormatterSubContext, param1NodeFormatterSubContext.markdown, (Document)param1Node, formattingPhase);
/*  962 */                   param1NodeFormatterSubContext.renderingNode = null;
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }  b++;
/*      */         }  return;
/*  968 */       }  if (this.isFormatControlEnabled.booleanValue()) {
/*  969 */         if (this.controlProcessor == null) {
/*  970 */           this.controlProcessor = new FormatControlProcessor(this.document, this.options);
/*  971 */           this.controlProcessor.initializeFrom(param1Node);
/*      */         } else {
/*  973 */           this.controlProcessor.processFormatControl(param1Node);
/*      */         } 
/*      */       }
/*      */       
/*  977 */       if (this.isFormatControlEnabled.booleanValue() && this.controlProcessor.isFormattingOff()) {
/*  978 */         if (param1Node instanceof com.vladsch.flexmark.util.ast.BlankLine) { param1NodeFormatterSubContext.markdown.blankLine(); return; }
/*  979 */          param1NodeFormatterSubContext.markdown.append((CharSequence)param1Node.getChars());
/*      */         return;
/*      */       } 
/*      */       List<NodeFormattingHandler<?>> list;
/*  983 */       if ((list = this.renderers.get(param1Node.getClass())) == null) {
/*  984 */         list = this.renderers.get(Node.class);
/*      */       }
/*      */       
/*  987 */       if (list != null) {
/*  988 */         List<NodeFormattingHandler<?>> list1 = param1NodeFormatterSubContext.rendererList;
/*  989 */         int i = param1NodeFormatterSubContext.rendererIndex;
/*  990 */         Node node = param1NodeFormatterSubContext.renderingNode;
/*      */         
/*  992 */         param1NodeFormatterSubContext.rendererList = list;
/*  993 */         param1NodeFormatterSubContext.rendererIndex = 0;
/*  994 */         param1NodeFormatterSubContext.renderingNode = param1Node;
/*  995 */         ((NodeFormattingHandler)list.get(0)).render(param1Node, param1NodeFormatterSubContext, param1NodeFormatterSubContext.markdown);
/*  996 */         param1NodeFormatterSubContext.renderingNode = node;
/*  997 */         param1NodeFormatterSubContext.rendererList = list1;
/*  998 */         param1NodeFormatterSubContext.rendererIndex = i;
/*      */         return;
/*      */       } 
/* 1001 */       throw new IllegalStateException("Core Node Formatter should implement generic Node renderer");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void renderChildren(Node param1Node) {
/* 1008 */       renderChildrenNode(param1Node, this);
/*      */     }
/*      */ 
/*      */     
/*      */     public void delegateRender() {
/* 1013 */       delegateRender(this);
/*      */     }
/*      */     
/*      */     protected void delegateRender(NodeFormatterSubContext param1NodeFormatterSubContext) {
/* 1017 */       if (param1NodeFormatterSubContext.getFormattingPhase() != FormattingPhase.DOCUMENT) {
/* 1018 */         throw new IllegalStateException("Delegate rendering only supported in document rendering phase");
/*      */       }
/*      */       
/* 1021 */       if (param1NodeFormatterSubContext.rendererList == null || param1NodeFormatterSubContext.renderingNode == null) {
/* 1022 */         throw new IllegalStateException("Delegate rendering can only be called from node render handler");
/*      */       }
/*      */       
/* 1025 */       Node node = param1NodeFormatterSubContext.renderingNode;
/*      */       
/* 1027 */       List<NodeFormattingHandler<?>> list1 = param1NodeFormatterSubContext.rendererList, list2 = list1;
/*      */       
/*      */       int i, j;
/*      */       
/* 1031 */       if ((j = (i = param1NodeFormatterSubContext.rendererIndex) + 1) >= list2.size()) {
/* 1032 */         if (node instanceof Document) {
/*      */           return;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1038 */         if ((list2 = this.renderers.get(Node.class)) == null)
/* 1039 */           throw new IllegalStateException("Core Node Formatter should implement generic Node renderer"); 
/* 1040 */         if (list1 == list2) {
/* 1041 */           throw new IllegalStateException("Core Node Formatter should not delegate generic Node renderer");
/*      */         }
/*      */         
/* 1044 */         list2 = list2;
/* 1045 */         j = 0;
/*      */       } 
/*      */ 
/*      */       
/* 1049 */       param1NodeFormatterSubContext.rendererList = list2;
/* 1050 */       param1NodeFormatterSubContext.rendererIndex = j;
/* 1051 */       ((NodeFormattingHandler)list2.get(j)).render(node, param1NodeFormatterSubContext, param1NodeFormatterSubContext.markdown);
/* 1052 */       param1NodeFormatterSubContext.rendererIndex = i;
/* 1053 */       param1NodeFormatterSubContext.rendererList = list1;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void renderChildrenNode(Node param1Node, NodeFormatterSubContext param1NodeFormatterSubContext) {
/* 1058 */       param1Node = param1Node.getFirstChild();
/* 1059 */       while (param1Node != null) {
/* 1060 */         Node node = param1Node.getNext();
/* 1061 */         renderNode(param1Node, param1NodeFormatterSubContext);
/* 1062 */         param1Node = node;
/*      */       } 
/*      */     }
/*      */     
/*      */     private class SubNodeFormatter
/*      */       extends NodeFormatterSubContext implements NodeFormatterContext {
/*      */       private final Formatter.MainNodeFormatter myMainNodeRenderer;
/*      */       private final DataHolder myOptions;
/*      */       private final FormatterOptions myFormatterOptions;
/*      */       
/*      */       public SubNodeFormatter(Formatter.MainNodeFormatter param2MainNodeFormatter1, MarkdownWriter param2MarkdownWriter, DataHolder param2DataHolder) {
/* 1073 */         super(param2MarkdownWriter);
/* 1074 */         this.myMainNodeRenderer = param2MainNodeFormatter1;
/* 1075 */         this.myOptions = (param2DataHolder == null || param2DataHolder == this.myMainNodeRenderer.getOptions()) ? this.myMainNodeRenderer.getOptions() : (DataHolder)new ScopedDataSet(this.myMainNodeRenderer.getOptions(), param2DataHolder);
/* 1076 */         this.myFormatterOptions = new FormatterOptions(this.myOptions);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public MutableDataHolder getTranslationStore() {
/* 1082 */         return this.myMainNodeRenderer.getTranslationStore();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final Iterable<? extends Node> nodesOfType(Class<?>[] param2ArrayOfClass) {
/* 1088 */         return this.myMainNodeRenderer.nodesOfType(param2ArrayOfClass);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final Iterable<? extends Node> nodesOfType(Collection<Class<?>> param2Collection) {
/* 1094 */         return this.myMainNodeRenderer.nodesOfType(param2Collection);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final Iterable<? extends Node> reversedNodesOfType(Class<?>[] param2ArrayOfClass) {
/* 1100 */         return this.myMainNodeRenderer.reversedNodesOfType(param2ArrayOfClass);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final Iterable<? extends Node> reversedNodesOfType(Collection<Class<?>> param2Collection) {
/* 1106 */         return this.myMainNodeRenderer.reversedNodesOfType(param2Collection);
/*      */       }
/*      */       
/*      */       public DataHolder getOptions() {
/* 1110 */         return this.myOptions;
/*      */       }
/*      */       
/*      */       public FormatterOptions getFormatterOptions() {
/* 1114 */         return this.myFormatterOptions;
/*      */       }
/*      */       
/*      */       public Document getDocument() {
/* 1118 */         return this.myMainNodeRenderer.getDocument();
/*      */       }
/*      */       
/*      */       public CharPredicate getBlockQuoteLikePrefixPredicate() {
/* 1122 */         return this.myMainNodeRenderer.getBlockQuoteLikePrefixPredicate();
/*      */       }
/*      */       
/*      */       public BasedSequence getBlockQuoteLikePrefixChars() {
/* 1126 */         return this.myMainNodeRenderer.getBlockQuoteLikePrefixChars();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public TrackedOffsetList getTrackedOffsets() {
/* 1135 */         return TrackedOffsetList.EMPTY_LIST;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isRestoreTrackedSpaces() {
/* 1140 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public BasedSequence getTrackedSequence() {
/* 1145 */         return this.myMainNodeRenderer.getTrackedSequence();
/*      */       }
/*      */ 
/*      */       
/*      */       public FormattingPhase getFormattingPhase() {
/* 1150 */         return this.myMainNodeRenderer.getFormattingPhase();
/*      */       }
/*      */       
/*      */       public void render(Node param2Node) {
/* 1154 */         this.myMainNodeRenderer.renderNode(param2Node, this);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Node getCurrentNode() {
/* 1160 */         return this.renderingNode;
/*      */       }
/*      */ 
/*      */       
/*      */       public void delegateRender() {
/* 1165 */         this.myMainNodeRenderer.delegateRender(this);
/*      */       }
/*      */ 
/*      */       
/*      */       public NodeFormatterContext getSubContext() {
/* 1170 */         return getSubContext((DataHolder)null, this.markdown.getBuilder());
/*      */       }
/*      */ 
/*      */       
/*      */       public NodeFormatterContext getSubContext(DataHolder param2DataHolder) {
/* 1175 */         return getSubContext(param2DataHolder, this.markdown.getBuilder());
/*      */       }
/*      */ 
/*      */       
/*      */       public NodeFormatterContext getSubContext(DataHolder param2DataHolder, ISequenceBuilder<?, ?> param2ISequenceBuilder) {
/*      */         MarkdownWriter markdownWriter;
/* 1181 */         (markdownWriter = new MarkdownWriter((Appendable)param2ISequenceBuilder, this.markdown.getOptions())).setContext(this);
/*      */         
/* 1183 */         return new SubNodeFormatter(this.myMainNodeRenderer, markdownWriter, (param2DataHolder == null || param2DataHolder == this.myOptions) ? this.myOptions : (DataHolder)new ScopedDataSet(this.myOptions, param2DataHolder));
/*      */       }
/*      */ 
/*      */       
/*      */       public void renderChildren(Node param2Node) {
/* 1188 */         this.myMainNodeRenderer.renderChildrenNode(param2Node, this);
/*      */       }
/*      */ 
/*      */       
/*      */       public MarkdownWriter getMarkdown() {
/* 1193 */         return this.markdown;
/*      */       }
/*      */ 
/*      */       
/*      */       public RenderPurpose getRenderPurpose() {
/* 1198 */         return this.myMainNodeRenderer.getRenderPurpose();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isTransformingText() {
/* 1203 */         return this.myMainNodeRenderer.isTransformingText();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public CharSequence transformNonTranslating(CharSequence param2CharSequence1, CharSequence param2CharSequence2, CharSequence param2CharSequence3, CharSequence param2CharSequence4) {
/* 1209 */         return this.myMainNodeRenderer.transformNonTranslating(param2CharSequence1, param2CharSequence2, param2CharSequence3, param2CharSequence4);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public CharSequence transformTranslating(CharSequence param2CharSequence1, CharSequence param2CharSequence2, CharSequence param2CharSequence3, CharSequence param2CharSequence4) {
/* 1215 */         return this.myMainNodeRenderer.transformTranslating(param2CharSequence1, param2CharSequence2, param2CharSequence3, param2CharSequence4);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public CharSequence transformAnchorRef(CharSequence param2CharSequence1, CharSequence param2CharSequence2) {
/* 1221 */         return this.myMainNodeRenderer.transformAnchorRef(param2CharSequence1, param2CharSequence2);
/*      */       }
/*      */ 
/*      */       
/*      */       public void translatingSpan(TranslatingSpanRender param2TranslatingSpanRender) {
/* 1226 */         this.myMainNodeRenderer.translatingSpan(param2TranslatingSpanRender);
/*      */       }
/*      */ 
/*      */       
/*      */       public void nonTranslatingSpan(TranslatingSpanRender param2TranslatingSpanRender) {
/* 1231 */         this.myMainNodeRenderer.nonTranslatingSpan(param2TranslatingSpanRender);
/*      */       }
/*      */ 
/*      */       
/*      */       public void translatingRefTargetSpan(Node param2Node, TranslatingSpanRender param2TranslatingSpanRender) {
/* 1236 */         this.myMainNodeRenderer.translatingRefTargetSpan(param2Node, param2TranslatingSpanRender);
/*      */       }
/*      */ 
/*      */       
/*      */       public void customPlaceholderFormat(TranslationPlaceholderGenerator param2TranslationPlaceholderGenerator, TranslatingSpanRender param2TranslatingSpanRender) {
/* 1241 */         this.myMainNodeRenderer.customPlaceholderFormat(param2TranslationPlaceholderGenerator, param2TranslatingSpanRender);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public String encodeUrl(CharSequence param2CharSequence) {
/* 1247 */         return this.myMainNodeRenderer.encodeUrl(param2CharSequence);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Boolean param2Boolean) {
/* 1253 */         return this.myMainNodeRenderer.resolveLink(this, param2LinkType, param2CharSequence, (Attributes)null);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Attributes param2Attributes, Boolean param2Boolean) {
/* 1259 */         return this.myMainNodeRenderer.resolveLink(this, param2LinkType, param2CharSequence, param2Attributes);
/*      */       }
/*      */ 
/*      */       
/*      */       public void postProcessNonTranslating(Function<String, CharSequence> param2Function, Runnable param2Runnable) {
/* 1264 */         this.myMainNodeRenderer.postProcessNonTranslating(param2Function, param2Runnable);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public <T> T postProcessNonTranslating(Function<String, CharSequence> param2Function, Supplier<T> param2Supplier) {
/* 1270 */         return this.myMainNodeRenderer.postProcessNonTranslating(param2Function, param2Supplier);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isPostProcessingNonTranslating() {
/* 1275 */         return this.myMainNodeRenderer.isPostProcessingNonTranslating();
/*      */       }
/*      */ 
/*      */       
/*      */       public MergeContext getMergeContext() {
/* 1280 */         return this.myMainNodeRenderer.getMergeContext();
/*      */       }
/*      */ 
/*      */       
/*      */       public void addExplicitId(Node param2Node, String param2String, NodeFormatterContext param2NodeFormatterContext, MarkdownWriter param2MarkdownWriter) {
/* 1285 */         this.myMainNodeRenderer.addExplicitId(param2Node, param2String, param2NodeFormatterContext, param2MarkdownWriter);
/*      */       }
/*      */ 
/*      */       
/*      */       public HtmlIdGenerator getIdGenerator() {
/* 1290 */         return this.myMainNodeRenderer.getIdGenerator();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface FormatterExtension extends Extension {
/*      */     void rendererOptions(MutableDataHolder param1MutableDataHolder);
/*      */     
/*      */     void extend(Formatter.Builder param1Builder);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\Formatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */